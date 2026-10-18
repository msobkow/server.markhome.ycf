// Description: Java 25 Spring JPA Service for Secure

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.secure.secure.jpa;

import java.io.Serializable;
import java.math.*;
import java.net.InetAddress;
import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

/**
 *	Services for schema Secure defined in server.markhome.ycf.v3_1.secure.secure.jpa
 *	using the Secure*Repository objects to access the data directly, bypassing normal application security for the bootstrap and login processing.
 */
@Service("secure31JpaSchemaService")
public class SecureJpaSchemaService {

	@Autowired
	@Qualifier("secure31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean secure31EntityManagerFactory;
	@Autowired
	private SecureJpaClusterService clusterService;

	@Autowired
	private SecureJpaTenantService tenantService;

	@Autowired
	private SecureJpaTableInfoService tableinfoService;

	@Autowired
	private SecureJpaISOCcyService isoccyService;

	@Autowired
	private SecureJpaISOCtryService isoctryService;

	@Autowired
	private SecureJpaISOCtryCcyService isoctryccyService;

	@Autowired
	private SecureJpaISOCtryLangService isoctrylangService;

	@Autowired
	private SecureJpaISOLangService isolangService;

	@Autowired
	private SecureJpaISOTZoneService isotzoneService;

	@Autowired
	private SecureJpaSecUserService secuserService;

	@Autowired
	private SecureJpaSecUserPasswordService secuserpasswordService;

	@Autowired
	private SecureJpaSecUserEMConfService secuseremconfService;

	@Autowired
	private SecureJpaSecUserPWResetService secuserpwresetService;

	@Autowired
	private SecureJpaSecUserPWHistoryService secuserpwhistoryService;

	@Autowired
	private SecureJpaSecSysGrpService secsysgrpService;

	@Autowired
	private SecureJpaSecSysGrpIncService secsysgrpincService;

	@Autowired
	private SecureJpaSecSysGrpMembService secsysgrpmembService;

	@Autowired
	private SecureJpaSecClusGrpService secclusgrpService;

	@Autowired
	private SecureJpaSecClusGrpMembService secclusgrpmembService;

	@Autowired
	private SecureJpaSecTentGrpService sectentgrpService;

	@Autowired
	private SecureJpaSecTentGrpMembService sectentgrpmembService;

	@Autowired
	private SecureJpaSecSysRoleService secsysroleService;

	@Autowired
	private SecureJpaSecSysRoleEnablesService secsysroleenablesService;

	@Autowired
	private SecureJpaSecSysRoleMembService secsysrolemembService;

	@Autowired
	private SecureJpaSecClusRoleService secclusroleService;

	@Autowired
	private SecureJpaSecClusRoleMembService secclusrolemembService;

	@Autowired
	private SecureJpaSecTentRoleService sectentroleService;

	@Autowired
	private SecureJpaSecTentRoleMembService sectentrolemembService;

	@Autowired
	private SecureJpaSecSessionService secsessionService;

	@Autowired
	private SecureJpaSysClusterService sysclusterService;


	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapSchema(SecurePubTableData tableData[]) {
		bootstrapSecurity();
		bootstrapAllTablesSecurity(tableData);
	}

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapSecurity() {
		SecureJpaSysCluster sysCluster;
		YCFDbKeyHash256 systemClusterID;
		SecureJpaCluster systemCluster;
		SecureJpaSecUser systemUser;
		YCFDbKeyHash256 systemUID;
		SecureJpaSecUser systemAdminUser;
		YCFDbKeyHash256 systemAdminUID;
		SecureJpaSecSession bootstrapSession;
		YCFDbKeyHash256 bootstrapSessionID;
		SecureJpaTenant systemTenant;
		YCFDbKeyHash256 systemTenantID;
		SecureJpaSecSysGrp secSystemAdminGroup;
		YCFDbKeyHash256 secSystemAdminGroupID;
		SecureJpaSecSysGrpMemb secSystemAdminGroupMembSystemAdmin;
		SecureJpaSecSysGrp secSysGroupPublic;
		YCFDbKeyHash256 secSysGroupPublicID;
		SecureJpaSecSysGrpInc secSysGroupPublicIncSystemAdmin;
		systemUser = secuserService.findByULoginIdx("system");
		if (systemUser != null) {
			systemUID = systemUser.getRequiredSecUserId();
			ISecureSchema.setSystemId(systemUID);

			ISecureSchema.setAuthorizationCallback( new ISecureAuthorizationCallback() {
				SecureAuthorization auth = new SecureAuthorization();
				@Override
				public ISecureAuthorization getEffectiveAuthorization() {
					return(auth);
				}
			});
			SecureAuthorization auth = (SecureAuthorization)ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization();
			auth.setAuthUuid6(YCFUuid6.generateUuid6());
			auth.setSecUserId(systemUID);
		
			systemAdminUser = secuserService.findByULoginIdx("systemadmin");
			if (systemAdminUser == null) {
				throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "findByULoginIdx('systemadmin')");
			}
			systemAdminUID = systemAdminUser.getRequiredSecUserId();

			List<SecureJpaSysCluster> sysClusters = sysclusterService.findAll();
			if (sysClusters != null && sysClusters.size() == 1) {
				sysCluster = sysClusters.get(0);
				systemClusterID = sysCluster.getRequiredClusterId();
				if(systemClusterID == null || systemClusterID.isNull()) {
					throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "systemClusterID");
				}
				systemCluster = clusterService.find(systemClusterID);
				if (systemCluster == null) {
					throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "systemCluster");
				}
				systemTenant = tenantService.findByUNameIdx(systemClusterID, "system");
				if( systemTenant == null) {
					systemTenantID = null;
					throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "systemTenant");
				}
				else {
					systemTenantID = systemTenant.getPKey();
				}
				bootstrapSession = secsessionService.findByStartIdx(systemUID, systemCluster.getCreatedAt());
				if (bootstrapSession == null) {
					List<SecureJpaSecSession> sessions = secsessionService.findBySecUserIdx(systemUID);
					if (sessions != null) {
						for (SecureJpaSecSession cursess: sessions) {
							if (bootstrapSession == null || (bootstrapSession != null && (cursess.getRequiredStart().compareTo(bootstrapSession.getRequiredStart()) < 0))) {
								bootstrapSession = cursess;
							}
						}
					}
					if (bootstrapSession == null) {
						throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "bootstrapSession");
					}
				}
				bootstrapSessionID = bootstrapSession.getPKey();

				auth.setSecSessionId(bootstrapSessionID);
				auth.setSecClusterId(systemClusterID);
				auth.setSecTenantId(systemTenantID);

				secSystemAdminGroup = (SecureJpaSecSysGrp)(secsysgrpService.findByUNameIdx( "systemadmin"));
				if (secSystemAdminGroup == null) {
					throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "secSystemAdminGroup");
				}
				secSystemAdminGroupID = secSystemAdminGroup.getRequiredSecSysGrpId();

				secSysGroupPublic = (SecureJpaSecSysGrp)(secsysgrpService.findByUNameIdx( "public"));
				if (secSysGroupPublic == null) {
					throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "secSysGroupPublic");
				}
				secSysGroupPublicID = secSysGroupPublic.getRequiredSecSysGrpId();

				secSystemAdminGroupMembSystemAdmin = (SecureJpaSecSysGrpMemb)(secsysgrpmembService.find(secSystemAdminGroupID, systemUser.getRequiredLoginId()));
				if (secSystemAdminGroupMembSystemAdmin == null) {
					throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "secSystemAdminGroupMembSystemAdmin");
				}

				secSysGroupPublicIncSystemAdmin = (SecureJpaSecSysGrpInc)(secsysgrpincService.find(secSysGroupPublicID, secSystemAdminGroup.getRequiredName()));
				if (secSysGroupPublicIncSystemAdmin == null) {
					throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "secSysGroupPublicIncSystemAdmin");
				}
			}
			else {
				throw new YCFNullArgumentException(getClass(), "bootstrapSecurity", 0, "SysClusterSingleton");
			}
		}
		else {
			systemUID = null;
			systemAdminUID = null;
			systemAdminUser = null;
			sysCluster = null;
			systemCluster = null;
			systemClusterID = null;
			bootstrapSession = null;
			bootstrapSessionID = null;
			systemTenant = null;
			systemTenantID = null;
			secSystemAdminGroup = null;
			secSystemAdminGroupID = null;
			secSystemAdminGroupMembSystemAdmin = null;
			secSysGroupPublic = null;
			secSysGroupPublicID = null;
			secSysGroupPublicIncSystemAdmin = null;
		}
		LocalDateTime now = LocalDateTime.now();
		if (systemUID == null || systemUID.isNull()) {
			systemUID = new YCFDbKeyHash256(0);
		}
		if (systemAdminUID == null || systemAdminUID.isNull()) {
			systemAdminUID = new YCFDbKeyHash256(0);
		}
		if (bootstrapSessionID == null || bootstrapSessionID.isNull()) {
			bootstrapSessionID = new YCFDbKeyHash256(0);
		}
		if (systemClusterID == null || systemClusterID.isNull()) {
			systemClusterID = new YCFDbKeyHash256(0);
		}
		if (systemTenantID == null || systemTenantID.isNull()) {
			systemTenantID = new YCFDbKeyHash256(0);
		}
		if (secSystemAdminGroupID == null || secSystemAdminGroupID.isNull()) {
			secSystemAdminGroupID = new YCFDbKeyHash256(0);
		}
		if (secSysGroupPublicID == null || secSysGroupPublicID.isNull()) {
			secSysGroupPublicID = new YCFDbKeyHash256(0);
		}
		if (ISecureSchema.getSysClusterId() == null || ISecureSchema.getSysClusterId().isNull()) {
			ISecureSchema.setSysClusterId(systemClusterID);
		}
		else if ( ! ISecureSchema.getSysClusterId().equals( systemClusterID )) {
			throw new YCFInvalidArgumentException(getClass(), "bootstrapSecurity", "Previously set system cluster id disagrees with new system cluster id", "Previously set system cluster id disagrees with new system cluster id");
		}
		if (ISecureSchema.getSysTenantId() == null || ISecureSchema.getSysTenantId().isNull()) {
			ISecureSchema.setSysTenantId(systemTenantID);
		}
		else if ( ! ISecureSchema.getSysTenantId().equals( systemTenantID )) {
			throw new YCFInvalidArgumentException(getClass(), "bootstrapSecurity", "Previously set system tenant id disagrees with new system tenant id", "Previously set system tenant id disagrees with new system tenant id");
		}
		if (!systemUID.equals(ISecureSchema.getSystemId())) {
			ISecureSchema.setSystemId(systemUID);
		}

		String fqdn;
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			fqdn = localHost.getCanonicalHostName();
		} catch (java.net.UnknownHostException e) {
			fqdn = "localhost";
		}
		
		ISecureSchema.setAuthorizationCallback( new ISecureAuthorizationCallback() {
			SecureAuthorization auth = new SecureAuthorization();
			@Override
			public ISecureAuthorization getEffectiveAuthorization() {
				return(auth);
			}
		});
		SecureAuthorization auth = (SecureAuthorization)ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization();
		auth.setAuthUuid6(YCFUuid6.generateUuid6());
		auth.setSecUserId(systemUID);
		auth.setSecSessionId(bootstrapSessionID);
		auth.setSecClusterId(systemClusterID);
		auth.setSecTenantId(systemTenantID);

		if (systemCluster == null) {
			systemCluster = new SecureJpaCluster();
			systemCluster.setRequiredRevision(1);
			systemCluster.setRequiredId(systemClusterID);
			systemCluster.setCreatedByUserId(systemUID);
			systemCluster.setUpdatedByUserId(systemUID);
			systemCluster.setCreatedAt(now);
			systemCluster.setUpdatedAt(now);
			systemCluster.setRequiredFullDomName(fqdn);
			systemCluster.setRequiredDescription("system");
			systemCluster = clusterService.create(systemCluster);
			systemClusterID = systemCluster.getPKey();
		}

		if (systemUser == null) {
			systemUser = new SecureJpaSecUser();
			systemUser.setRequiredRevision(1);
			systemUser.setCreatedByUserId(systemUID);
			systemUser.setUpdatedByUserId(systemUID);
			systemUser.setCreatedAt(now);
			systemUser.setUpdatedAt(now);
			systemUser.setRequiredSecUserId(systemUID);
			systemUser.setRequiredLoginId("system");
			systemUser.setRequiredEMailAddress("system@" + fqdn);
			systemUser.setRequiredAccountStatus(ISecurePubSchema.SecAccountStatusEnum.System);
			systemUser = secuserService.create(systemUser);
			systemUID = systemUser.getPKey();
		}

		if (systemAdminUser == null) {
			systemAdminUser = new SecureJpaSecUser();
			systemAdminUser.setRequiredRevision(1);
			systemAdminUser.setCreatedByUserId(systemUID);
			systemAdminUser.setUpdatedByUserId(systemUID);
			systemAdminUser.setCreatedAt(now);
			systemAdminUser.setUpdatedAt(now);
			systemAdminUser.setRequiredSecUserId(systemAdminUID);
			systemAdminUser.setRequiredLoginId("systemadmin");
			systemAdminUser.setRequiredEMailAddress("systemadmin@" + fqdn);
			systemAdminUser.setRequiredAccountStatus(ISecurePubSchema.SecAccountStatusEnum.ResettingPassword);
			systemAdminUser = secuserService.create(systemAdminUser);
			systemAdminUID = systemAdminUser.getPKey();
			
			SecureJpaSecUserPassword systemAdminUserPassword = secuserpasswordService.find(systemAdminUID);
			if (systemAdminUserPassword == null) {
				systemAdminUserPassword = new SecureJpaSecUserPassword();
				systemAdminUserPassword.setRequiredRevision(1);
				systemAdminUserPassword.setPKey(systemAdminUID);
				systemAdminUserPassword.setRequiredContainerUser(systemAdminUser);
				systemAdminUserPassword.setRequiredPWSetStamp(now);
				systemAdminUserPassword.setRequiredPasswordHash(ISecureSchema.getPasswordHash("ChangeOnInstall"));
				systemAdminUserPassword = secuserpasswordService.create(systemAdminUserPassword);
			}
		}

		if (systemTenant == null) {
			systemTenant = new SecureJpaTenant();
			systemTenant.setRequiredRevision(1);
			systemTenant.setRequiredId(systemTenantID);
			systemTenant.setCreatedByUserId(systemUID);
			systemTenant.setUpdatedByUserId(systemUID);
			systemTenant.setCreatedAt(now);
			systemTenant.setUpdatedAt(now);
			systemTenant.setRequiredContainerCluster(systemClusterID);
			systemTenant.setRequiredTenantName("system");
			systemTenant = tenantService.create(systemTenant);
			systemTenantID = systemTenant.getPKey();
		}

		if (bootstrapSession == null) {
			bootstrapSession = new SecureJpaSecSession();
			bootstrapSession.setRequiredRevision(1);
			bootstrapSession.setRequiredSecSessionId(bootstrapSessionID);
			bootstrapSession.setRequiredSecUserId(systemUID);
			bootstrapSession.setOptionalSecProxyId(systemUID);
			bootstrapSession.setRequiredStart(now);
			bootstrapSession.setOptionalFinish(null);
			bootstrapSession = secsessionService.create(bootstrapSession);
		}

		if (sysCluster == null) {
			sysCluster = new SecureJpaSysCluster();
			sysCluster.setRequiredContainerCluster(systemClusterID);
			sysCluster = sysclusterService.create(sysCluster);
		}

		if (secSystemAdminGroup == null) {
			secSystemAdminGroup = new SecureJpaSecSysGrp();
			secSystemAdminGroup.setPKey(secSystemAdminGroupID);
			secSystemAdminGroup.setRequiredRevision(1);
			secSystemAdminGroup.setCreatedAt(now);
			secSystemAdminGroup.setCreatedByUserId(systemUID);
			secSystemAdminGroup.setUpdatedAt(now);
			secSystemAdminGroup.setUpdatedByUserId(systemUID);
			secSystemAdminGroup.setRequiredName("systemadmin");
			secSystemAdminGroup.setRequiredSecLevel(ISecurePubSchema.SecLevelEnum.System);
			secSystemAdminGroup.setRequiredSecSysGrpId(secSystemAdminGroupID);
			secSystemAdminGroup = (SecureJpaSecSysGrp)(secsysgrpService.create(secSystemAdminGroup));
			secSystemAdminGroupID = secSystemAdminGroup.getRequiredSecSysGrpId();
		}

		if (secSystemAdminGroupMembSystemAdmin == null) {
			secSystemAdminGroupMembSystemAdmin = new SecureJpaSecSysGrpMemb();
			secSystemAdminGroupMembSystemAdmin.setRequiredRevision(1);
			secSystemAdminGroupMembSystemAdmin.setRequiredContainerGroup(secSystemAdminGroupID);
			secSystemAdminGroupMembSystemAdmin.setRequiredParentUser(systemAdminUser.getRequiredLoginId());
			secSystemAdminGroupMembSystemAdmin = (SecureJpaSecSysGrpMemb)(secsysgrpmembService.create(secSystemAdminGroupMembSystemAdmin));
		}

		if (secSysGroupPublic == null) {
			secSysGroupPublic = new SecureJpaSecSysGrp();
			secSysGroupPublic.setRequiredRevision(1);
			secSysGroupPublic.setCreatedAt(now);
			secSysGroupPublic.setCreatedByUserId(systemUID);
			secSysGroupPublic.setUpdatedAt(now);
			secSysGroupPublic.setUpdatedByUserId(systemUID);
			secSysGroupPublic.setRequiredName("public");
			secSysGroupPublic.setRequiredSecLevel(ISecurePubSchema.SecLevelEnum.System);
			secSysGroupPublic.setRequiredSecSysGrpId(secSysGroupPublicID);
			secSysGroupPublic = (SecureJpaSecSysGrp)(secsysgrpService.create(secSysGroupPublic));
			secSysGroupPublicID = secSysGroupPublic.getRequiredSecSysGrpId();
		}

		if (secSysGroupPublicIncSystemAdmin == null) {
			secSysGroupPublicIncSystemAdmin = new SecureJpaSecSysGrpInc();
			secSysGroupPublicIncSystemAdmin.setRequiredContainerGroup(secSysGroupPublicID);
			secSysGroupPublicIncSystemAdmin.setCreatedAt(now);
			secSysGroupPublicIncSystemAdmin.setCreatedByUserId(systemUID);
			secSysGroupPublicIncSystemAdmin.setUpdatedAt(now);
			secSysGroupPublicIncSystemAdmin.setUpdatedByUserId(systemUID);
			secSysGroupPublicIncSystemAdmin.setRequiredParentSubGroup(secSystemAdminGroup.getRequiredName());
			secSysGroupPublicIncSystemAdmin.setRequiredRevision(1);
			secSysGroupPublicIncSystemAdmin = (SecureJpaSecSysGrpInc)(secsysgrpincService.create(secSysGroupPublicIncSystemAdmin));
		}

		if (bootstrapSession != null && bootstrapSessionID != null && !bootstrapSessionID.isNull() && bootstrapSession.getOptionalFinish() == null) {
			bootstrapSession.setOptionalFinish(LocalDateTime.now());
			bootstrapSession = secsessionService.update(bootstrapSession);
			ISecureSchema.setAuthorizationCallback( new ISecureAuthorizationCallback() {
				@Override
				public ISecureAuthorization getEffectiveAuthorization() {
					return(null);
				}
			});
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapTableSecurity(ISecureAuthorization auth,
		LocalDateTime now,
		String tableName,
		boolean hasHistory,
		boolean isMutable,
		String secScope,
		ISecureSecSysGrp secSysGroupPublic,
		ISecureSecSysGrp secSystemAdminGroup,
		ISecureSecClusGrp secSysClusGroupSysAdmin,
		ISecureSecTentGrp secSysTentGroupSysAdmin )
	{
		ISecurePubSchema.SecLevelEnum level;
		if (secScope.equalsIgnoreCase("global")) {
			level = ISecurePubSchema.SecLevelEnum.Global;
		}
		else if (secScope.toLowerCase().startsWith("cluster")) {
			level = ISecurePubSchema.SecLevelEnum.Cluster;
		}
		else if (secScope.toLowerCase().startsWith("tenant")) {
			level = ISecurePubSchema.SecLevelEnum.Tenant;
		}
		else {
			level = ISecurePubSchema.SecLevelEnum.System;
		}
			
		String lowerTableName = tableName.toLowerCase();
		String createPermName = "create" + lowerTableName;
		String readPermName = "read" + lowerTableName;
		String updatePermName = "update" + lowerTableName;
		String deletePermName = "delete" + lowerTableName;
		String restorePermName = "restore" + lowerTableName;
		String mutatePermName = "mutate" + lowerTableName;
		String systemGroup = secSystemAdminGroup.getRequiredName();
		String sysclusadminGroup = secSysClusGroupSysAdmin.getRequiredName();
		String systentadminGroup = secSysTentGroupSysAdmin.getRequiredName();
		String publicGroup = secSysGroupPublic.getRequiredName();
		
		ISecureSecSysGrp secGroupCreate;
		YCFDbKeyHash256 secGroupCreateID;
		ISecureSecSysGrpInc secGroupCreateIncSystemAdmin;
		ISecureSecSysGrp secGroupRead;
		YCFDbKeyHash256 secGroupReadID;
		ISecureSecSysGrpInc secGroupReadIncSystemAdmin;
		ISecureSecSysGrpInc secGroupReadIncPublic;
		ISecureSecSysGrp secGroupUpdate;
		YCFDbKeyHash256 secGroupUpdateID;
		ISecureSecSysGrpInc secGroupUpdateIncSystemAdmin;
		ISecureSecSysGrp secGroupDelete;
		YCFDbKeyHash256 secGroupDeleteID;
		ISecureSecSysGrpInc secGroupDeleteIncSystemAdmin;
		ISecureSecSysGrp secGroupRestore;
		YCFDbKeyHash256 secGroupRestoreID;
		ISecureSecSysGrpInc secGroupRestoreIncSystemAdmin;
		ISecureSecSysGrp secGroupMutate;
		YCFDbKeyHash256 secGroupMutateID;
		ISecureSecSysGrpInc secGroupMutateIncSystemAdmin;

		ISecureSecClusGrp csecGroupCreate;
		YCFDbKeyHash256 csecGroupCreateID;
		ISecureSecClusGrp csecGroupRead;
		YCFDbKeyHash256 csecGroupReadID;
		ISecureSecClusGrp csecGroupUpdate;
		YCFDbKeyHash256 csecGroupUpdateID;
		ISecureSecClusGrp csecGroupDelete;
		YCFDbKeyHash256 csecGroupDeleteID;
		ISecureSecClusGrp csecGroupRestore;
		YCFDbKeyHash256 csecGroupRestoreID;
		ISecureSecClusGrp csecGroupMutate;
		YCFDbKeyHash256 csecGroupMutateID;
		
		ISecureSecTentGrp tsecGroupCreate;
		YCFDbKeyHash256 tsecGroupCreateID;
		ISecureSecTentGrp tsecGroupRead;
		YCFDbKeyHash256 tsecGroupReadID;
		ISecureSecTentGrp tsecGroupUpdate;
		YCFDbKeyHash256 tsecGroupUpdateID;
		ISecureSecTentGrp tsecGroupDelete;
		YCFDbKeyHash256 tsecGroupDeleteID;
		ISecureSecTentGrp tsecGroupRestore;
		YCFDbKeyHash256 tsecGroupRestoreID;
		ISecureSecTentGrp tsecGroupMutate;
		YCFDbKeyHash256 tsecGroupMutateID;

		secGroupCreate = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx(auth, createPermName);
		if (secGroupCreate != null) {
			secGroupCreateID = secGroupCreate.getRequiredSecSysGrpId();
			secGroupCreateIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().readDerived(auth, secGroupCreateID, systemGroup);
		}
		else {
			secGroupCreateID = null;
			secGroupCreateIncSystemAdmin = null;
		}

		secGroupRead = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx(auth, readPermName);
		if (secGroupRead != null) {
			secGroupReadID = secGroupRead.getRequiredSecSysGrpId();
			secGroupReadIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().readDerived(auth, secGroupReadID, systemGroup);
		}
		else {
			secGroupReadID = null;
			secGroupReadIncSystemAdmin = null;
		}

		if (secGroupRead != null && level == ISecurePubSchema.SecLevelEnum.Global) {
			secGroupReadIncPublic = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().readDerived(auth, secGroupReadID, publicGroup);
		}
		else {
			secGroupReadIncPublic = null;
		}

		secGroupUpdate = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx(auth, updatePermName);
		if (secGroupUpdate != null) {
			secGroupUpdateID = secGroupUpdate.getRequiredSecSysGrpId();
			secGroupUpdateIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().readDerived(auth, secGroupUpdateID, systemGroup);
		}
		else {
			secGroupUpdateID = null;
			secGroupUpdateIncSystemAdmin = null;
		}

		secGroupDelete = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx(auth, deletePermName);
		if (secGroupDelete != null) {
			secGroupDeleteID = secGroupDelete.getRequiredSecSysGrpId();
			secGroupDeleteIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().readDerived(auth, secGroupDeleteID, systemGroup);
		}
		else {
			secGroupDeleteID = null;
			secGroupDeleteIncSystemAdmin = null;
		}
		
		if (hasHistory) {
			secGroupRestore = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx(auth, restorePermName);
			if (secGroupRestore != null) {
				secGroupRestoreID = secGroupRestore.getRequiredSecSysGrpId();
				secGroupRestoreIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().readDerived(auth, secGroupRestoreID, systemGroup);
			}
			else {
				secGroupRestoreID = null;
				secGroupRestoreIncSystemAdmin = null;
			}
		}
		else {
			secGroupRestore = null;
			secGroupRestoreID = null;
			secGroupRestoreIncSystemAdmin = null;
		}
		
		if (isMutable) {
			secGroupMutate = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx(auth, mutatePermName);
			if (secGroupMutate != null) {
				secGroupMutateID = secGroupMutate.getRequiredSecSysGrpId();
				secGroupMutateIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().readDerived(auth, secGroupMutateID, systemGroup);
			}
			else {
				secGroupMutateID = null;
				secGroupMutateIncSystemAdmin = null;
			}
		}
		else {
			secGroupMutate = null;
			secGroupMutateID = null;
			secGroupMutateIncSystemAdmin = null;
		}

		if (secGroupCreateID == null || secGroupCreateID.isNull()) {
			secGroupCreateID = new YCFDbKeyHash256(0);
		}
		if (secGroupReadID == null || secGroupReadID.isNull()) {
			secGroupReadID = new YCFDbKeyHash256(0);
		}
		if (secGroupUpdateID == null || secGroupUpdateID.isNull()) {
			secGroupUpdateID = new YCFDbKeyHash256(0);
		}
		if (secGroupDeleteID == null || secGroupDeleteID.isNull()) {
			secGroupDeleteID = new YCFDbKeyHash256(0);
		}
		if (hasHistory) {
			if (secGroupRestoreID == null || secGroupRestoreID.isNull()) {
				secGroupRestoreID = new YCFDbKeyHash256(0);
			}
		}
		if (isMutable) {
			if (secGroupMutateID == null || secGroupMutateID.isNull()) {
				secGroupMutateID = new YCFDbKeyHash256(0);
			}
		}

		if (secGroupCreate == null) {
			secGroupCreate = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrp().newRec();
			secGroupCreate.setRequiredRevision(1);
			secGroupCreate.setCreatedAt(now);
			secGroupCreate.setCreatedByUserId(auth.getSecUserId());
			secGroupCreate.setUpdatedAt(now);
			secGroupCreate.setUpdatedByUserId(auth.getSecUserId());
			secGroupCreate.setRequiredName(createPermName);
			secGroupCreate.setRequiredSecLevel(level);
			secGroupCreate.setRequiredSecSysGrpId(secGroupCreateID);
			secGroupCreate = ISecureSchema.getBackingSecure().getTableSecSysGrp().createSecSysGrp(auth, secGroupCreate);
			secGroupCreateID = secGroupCreate.getRequiredSecSysGrpId();
		}

		if (secGroupCreateIncSystemAdmin == null) {
			secGroupCreateIncSystemAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrpInc().newRec();
			secGroupCreateIncSystemAdmin.setRequiredRevision(1);
			secGroupCreateIncSystemAdmin.setCreatedAt(now);
			secGroupCreateIncSystemAdmin.setCreatedByUserId(auth.getSecUserId());
			secGroupCreateIncSystemAdmin.setUpdatedAt(now);
			secGroupCreateIncSystemAdmin.setUpdatedByUserId(auth.getSecUserId());
			secGroupCreateIncSystemAdmin.setRequiredContainerGroup(secGroupCreateID);
			secGroupCreateIncSystemAdmin.setRequiredParentSubGroup(systemGroup);
			secGroupCreateIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().createSecSysGrpInc(auth, secGroupCreateIncSystemAdmin);
		}

		if (secGroupRead == null) {
			secGroupRead = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrp().newRec();
			secGroupRead.setRequiredRevision(1);
			secGroupRead.setCreatedAt(now);
			secGroupRead.setCreatedByUserId(auth.getSecUserId());
			secGroupRead.setUpdatedAt(now);
			secGroupRead.setUpdatedByUserId(auth.getSecUserId());
			secGroupRead.setRequiredName(readPermName);
			secGroupRead.setRequiredSecLevel(level);
			secGroupRead.setRequiredSecSysGrpId(secGroupReadID);
			secGroupRead = ISecureSchema.getBackingSecure().getTableSecSysGrp().createSecSysGrp(auth, secGroupRead);
			secGroupReadID = secGroupRead.getRequiredSecSysGrpId();
		}

		if (secGroupReadIncSystemAdmin == null) {
			secGroupReadIncSystemAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrpInc().newRec();
			secGroupReadIncSystemAdmin.setRequiredRevision(1);
			secGroupReadIncSystemAdmin.setCreatedAt(now);
			secGroupReadIncSystemAdmin.setCreatedByUserId(auth.getSecUserId());
			secGroupReadIncSystemAdmin.setUpdatedAt(now);
			secGroupReadIncSystemAdmin.setUpdatedByUserId(auth.getSecUserId());
			secGroupReadIncSystemAdmin.setRequiredContainerGroup(secGroupReadID);
			secGroupReadIncSystemAdmin.setRequiredParentSubGroup(systemGroup);
			secGroupReadIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().createSecSysGrpInc(auth, secGroupReadIncSystemAdmin);
		}

		if (secGroupRead != null && level == ISecurePubSchema.SecLevelEnum.Global && secGroupReadIncPublic == null) {
			secGroupReadIncPublic = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrpInc().newRec();
			secGroupReadIncPublic.setRequiredRevision(1);
			secGroupReadIncPublic.setCreatedAt(now);
			secGroupReadIncPublic.setCreatedByUserId(auth.getSecUserId());
			secGroupReadIncPublic.setUpdatedAt(now);
			secGroupReadIncPublic.setUpdatedByUserId(auth.getSecUserId());
			secGroupReadIncPublic.setRequiredContainerGroup(secGroupReadID);
			secGroupReadIncPublic.setRequiredParentSubGroup(publicGroup);
			secGroupReadIncPublic = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().createSecSysGrpInc(auth, secGroupReadIncPublic);
		}
		else {
			secGroupReadIncPublic = null;
		}

		if (secGroupUpdate == null) {
			secGroupUpdate = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrp().newRec();
			secGroupUpdate.setRequiredRevision(1);
			secGroupUpdate.setCreatedAt(now);
			secGroupUpdate.setCreatedByUserId(auth.getSecUserId());
			secGroupUpdate.setUpdatedAt(now);
			secGroupUpdate.setUpdatedByUserId(auth.getSecUserId());
			secGroupUpdate.setRequiredName(updatePermName);
			secGroupUpdate.setRequiredSecLevel(level);
			secGroupUpdate.setRequiredSecSysGrpId(secGroupUpdateID);
			secGroupUpdate = ISecureSchema.getBackingSecure().getTableSecSysGrp().createSecSysGrp(auth, secGroupUpdate);
			secGroupUpdateID = secGroupUpdate.getRequiredSecSysGrpId();
		}

		if (secGroupUpdateIncSystemAdmin == null) {
			secGroupUpdateIncSystemAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrpInc().newRec();
			secGroupUpdateIncSystemAdmin.setRequiredRevision(1);
			secGroupUpdateIncSystemAdmin.setCreatedAt(now);
			secGroupUpdateIncSystemAdmin.setCreatedByUserId(auth.getSecUserId());
			secGroupUpdateIncSystemAdmin.setUpdatedAt(now);
			secGroupUpdateIncSystemAdmin.setUpdatedByUserId(auth.getSecUserId());
			secGroupUpdateIncSystemAdmin.setRequiredContainerGroup(secGroupUpdateID);
			secGroupUpdateIncSystemAdmin.setRequiredParentSubGroup(systemGroup);
			secGroupUpdateIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().createSecSysGrpInc(auth, secGroupUpdateIncSystemAdmin);
		}

		if (secGroupDelete == null) {
			secGroupDelete = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrp().newRec();
			secGroupDelete.setRequiredRevision(1);
			secGroupDelete.setCreatedAt(now);
			secGroupDelete.setCreatedByUserId(auth.getSecUserId());
			secGroupDelete.setUpdatedAt(now);
			secGroupDelete.setUpdatedByUserId(auth.getSecUserId());
			secGroupDelete.setRequiredName(deletePermName);
			secGroupDelete.setRequiredSecLevel(level);
			secGroupDelete.setRequiredSecSysGrpId(secGroupDeleteID);
			secGroupDelete = ISecureSchema.getBackingSecure().getTableSecSysGrp().createSecSysGrp(auth, secGroupDelete);
			secGroupDeleteID = secGroupDelete.getRequiredSecSysGrpId();
		}

		if (secGroupDeleteIncSystemAdmin == null) {
			secGroupDeleteIncSystemAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrpInc().newRec();
			secGroupDeleteIncSystemAdmin.setRequiredRevision(1);
			secGroupDeleteIncSystemAdmin.setCreatedAt(now);
			secGroupDeleteIncSystemAdmin.setCreatedByUserId(auth.getSecUserId());
			secGroupDeleteIncSystemAdmin.setUpdatedAt(now);
			secGroupDeleteIncSystemAdmin.setUpdatedByUserId(auth.getSecUserId());
			secGroupDeleteIncSystemAdmin.setRequiredContainerGroup(secGroupDeleteID);
			secGroupDeleteIncSystemAdmin.setRequiredParentSubGroup(systemGroup);
			secGroupDeleteIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().createSecSysGrpInc(auth, secGroupDeleteIncSystemAdmin);
		}
		
		if (hasHistory) {
			if (secGroupRestore == null) {
				secGroupRestore = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrp().newRec();
				secGroupRestore.setRequiredRevision(1);
				secGroupRestore.setCreatedAt(now);
				secGroupRestore.setCreatedByUserId(auth.getSecUserId());
				secGroupRestore.setUpdatedAt(now);
				secGroupRestore.setUpdatedByUserId(auth.getSecUserId());
				secGroupRestore.setRequiredName(restorePermName);
				secGroupRestore.setRequiredSecLevel(level);
				secGroupRestore.setRequiredSecSysGrpId(secGroupRestoreID);
				secGroupRestore = ISecureSchema.getBackingSecure().getTableSecSysGrp().createSecSysGrp(auth, secGroupRestore);
				secGroupRestoreID = secGroupRestore.getRequiredSecSysGrpId();
			}

			if (secGroupRestoreIncSystemAdmin == null) {
				secGroupRestoreIncSystemAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrpInc().newRec();
				secGroupRestoreIncSystemAdmin.setRequiredRevision(1);
				secGroupRestoreIncSystemAdmin.setCreatedAt(now);
				secGroupRestoreIncSystemAdmin.setCreatedByUserId(auth.getSecUserId());
				secGroupRestoreIncSystemAdmin.setUpdatedAt(now);
				secGroupRestoreIncSystemAdmin.setUpdatedByUserId(auth.getSecUserId());
				secGroupRestoreIncSystemAdmin.setRequiredContainerGroup(secGroupRestoreID);
				secGroupRestoreIncSystemAdmin.setRequiredParentSubGroup(systemGroup);
				secGroupRestoreIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().createSecSysGrpInc(auth, secGroupRestoreIncSystemAdmin);
			}
		}
		
		if (isMutable) {
			if (secGroupMutate == null) {
				secGroupMutate = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrp().newRec();
				secGroupMutate.setRequiredRevision(1);
				secGroupMutate.setCreatedAt(now);
				secGroupMutate.setCreatedByUserId(auth.getSecUserId());
				secGroupMutate.setUpdatedAt(now);
				secGroupMutate.setUpdatedByUserId(auth.getSecUserId());
				secGroupMutate.setRequiredName(mutatePermName);
				secGroupMutate.setRequiredSecLevel(level);
				secGroupMutate.setRequiredSecSysGrpId(secGroupMutateID);
				secGroupMutate = ISecureSchema.getBackingSecure().getTableSecSysGrp().createSecSysGrp(auth, secGroupMutate);
				secGroupMutateID = secGroupMutate.getRequiredSecSysGrpId();
			}

			if (secGroupMutateIncSystemAdmin == null) {
				secGroupMutateIncSystemAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrpInc().newRec();
				secGroupMutateIncSystemAdmin.setRequiredRevision(1);
				secGroupMutateIncSystemAdmin.setCreatedAt(now);
				secGroupMutateIncSystemAdmin.setCreatedByUserId(auth.getSecUserId());
				secGroupMutateIncSystemAdmin.setUpdatedAt(now);
				secGroupMutateIncSystemAdmin.setUpdatedByUserId(auth.getSecUserId());
				secGroupMutateIncSystemAdmin.setRequiredContainerGroup(secGroupMutateID);
				secGroupMutateIncSystemAdmin.setRequiredParentSubGroup(systemGroup);
				secGroupMutateIncSystemAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrpInc().createSecSysGrpInc(auth, secGroupMutateIncSystemAdmin);
			}
		}
		
		if (level == ISecurePubSchema.SecLevelEnum.Cluster || level == ISecurePubSchema.SecLevelEnum.Tenant) {
			csecGroupCreate = ISecureSchema.getBackingSecure().getTableSecClusGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysClusterId(), createPermName);
			if (csecGroupCreate != null) {
				csecGroupCreateID = csecGroupCreate.getRequiredSecClusGrpId();
			}
			else {
				csecGroupCreateID = null;
			}

			csecGroupRead = ISecureSchema.getBackingSecure().getTableSecClusGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysClusterId(), readPermName);
			if (csecGroupRead != null) {
				csecGroupReadID = csecGroupRead.getRequiredSecClusGrpId();
			}
			else {
				csecGroupReadID = null;
			}

			csecGroupUpdate = ISecureSchema.getBackingSecure().getTableSecClusGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysClusterId(), updatePermName);
			if (csecGroupUpdate != null) {
				csecGroupUpdateID = csecGroupUpdate.getRequiredSecClusGrpId();
			}
			else {
				csecGroupUpdateID = null;
			}

			csecGroupDelete = ISecureSchema.getBackingSecure().getTableSecClusGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysClusterId(), deletePermName);
			if (csecGroupDelete != null) {
				csecGroupDeleteID = csecGroupDelete.getRequiredSecClusGrpId();
			}
			else {
				csecGroupDeleteID = null;
			}

			if (hasHistory) {
				csecGroupRestore = ISecureSchema.getBackingSecure().getTableSecClusGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysClusterId(), restorePermName);
				if (csecGroupRestore != null) {
					csecGroupRestoreID = csecGroupRestore.getRequiredSecClusGrpId();
				}
				else {
					csecGroupRestoreID = null;
				}
			}
			else {
				csecGroupRestore = null;
				csecGroupRestoreID = null;
			}

			if (isMutable) {
				csecGroupMutate = ISecureSchema.getBackingSecure().getTableSecClusGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysClusterId(), mutatePermName);
				if (csecGroupMutate != null) {
					csecGroupMutateID = csecGroupMutate.getRequiredSecClusGrpId();
				}
				else {
					csecGroupMutateID = null;
				}
			}
			else {
				csecGroupMutate = null;
				csecGroupMutateID = null;
			}

			if (csecGroupCreateID == null || csecGroupCreateID.isNull()) {
				csecGroupCreateID = new YCFDbKeyHash256(0);
			}
			if (csecGroupReadID == null || csecGroupReadID.isNull()) {
				csecGroupReadID = new YCFDbKeyHash256(0);
			}
			if (csecGroupUpdateID == null || csecGroupUpdateID.isNull()) {
				csecGroupUpdateID = new YCFDbKeyHash256(0);
			}
			if (csecGroupDeleteID == null || csecGroupDeleteID.isNull()) {
				csecGroupDeleteID = new YCFDbKeyHash256(0);
			}
			if (hasHistory) {
				if (csecGroupRestoreID == null || csecGroupRestoreID.isNull()) {
					csecGroupRestoreID = new YCFDbKeyHash256(0);
				}
			}
			if (isMutable) {
				if (csecGroupMutateID == null || csecGroupMutateID.isNull()) {
					csecGroupMutateID = new YCFDbKeyHash256(0);
				}
			}

			if (csecGroupCreate == null) {
				csecGroupCreate = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecClusGrp().newRec();
				csecGroupCreate.setRequiredRevision(1);
				csecGroupCreate.setCreatedAt(now);
				csecGroupCreate.setCreatedByUserId(auth.getSecUserId());
				csecGroupCreate.setUpdatedAt(now);
				csecGroupCreate.setUpdatedByUserId(auth.getSecUserId());
				csecGroupCreate.setRequiredContainerSysGrp(createPermName);
				csecGroupCreate.setRequiredSecClusGrpId(csecGroupCreateID);
				csecGroupCreate.setRequiredOwnerCluster(secSysClusGroupSysAdmin.getRequiredOwnerCluster());
				csecGroupCreate = ISecureSchema.getBackingSecure().getTableSecClusGrp().createSecClusGrp(auth, csecGroupCreate);
				csecGroupCreateID = csecGroupCreate.getRequiredSecClusGrpId();
			}

			if (csecGroupRead == null) {
				csecGroupRead = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecClusGrp().newRec();
				csecGroupRead.setRequiredRevision(1);
				csecGroupRead.setCreatedAt(now);
				csecGroupRead.setCreatedByUserId(auth.getSecUserId());
				csecGroupRead.setUpdatedAt(now);
				csecGroupRead.setUpdatedByUserId(auth.getSecUserId());
				csecGroupRead.setRequiredContainerSysGrp(readPermName);
				csecGroupRead.setRequiredSecClusGrpId(csecGroupReadID);
				csecGroupRead.setRequiredOwnerCluster(secSysClusGroupSysAdmin.getRequiredOwnerCluster());
				csecGroupRead = ISecureSchema.getBackingSecure().getTableSecClusGrp().createSecClusGrp(auth, csecGroupRead);
				csecGroupReadID = csecGroupRead.getRequiredSecClusGrpId();
			}

			if (csecGroupUpdate == null) {
				csecGroupUpdate = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecClusGrp().newRec();
				csecGroupUpdate.setRequiredRevision(1);
				csecGroupUpdate.setCreatedAt(now);
				csecGroupUpdate.setCreatedByUserId(auth.getSecUserId());
				csecGroupUpdate.setUpdatedAt(now);
				csecGroupUpdate.setUpdatedByUserId(auth.getSecUserId());
				csecGroupUpdate.setRequiredContainerSysGrp(updatePermName);
				csecGroupUpdate.setRequiredSecClusGrpId(csecGroupUpdateID);
				csecGroupUpdate.setRequiredOwnerCluster(secSysClusGroupSysAdmin.getRequiredOwnerCluster());
				csecGroupUpdate = ISecureSchema.getBackingSecure().getTableSecClusGrp().createSecClusGrp(auth, csecGroupUpdate);
				csecGroupUpdateID = csecGroupUpdate.getRequiredSecClusGrpId();
			}

			if (csecGroupDelete == null) {
				csecGroupDelete = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecClusGrp().newRec();
				csecGroupDelete.setRequiredRevision(1);
				csecGroupDelete.setCreatedAt(now);
				csecGroupDelete.setCreatedByUserId(auth.getSecUserId());
				csecGroupDelete.setUpdatedAt(now);
				csecGroupDelete.setUpdatedByUserId(auth.getSecUserId());
				csecGroupDelete.setRequiredContainerSysGrp(deletePermName);
				csecGroupDelete.setRequiredSecClusGrpId(csecGroupDeleteID);
				csecGroupDelete.setRequiredOwnerCluster(secSysClusGroupSysAdmin.getRequiredOwnerCluster());
				csecGroupDelete = ISecureSchema.getBackingSecure().getTableSecClusGrp().createSecClusGrp(auth, csecGroupDelete);
				csecGroupDeleteID = csecGroupDelete.getRequiredSecClusGrpId();
			}

			if (hasHistory) {
				if (csecGroupRestore == null) {
					csecGroupRestore = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecClusGrp().newRec();
					csecGroupRestore.setRequiredRevision(1);
					csecGroupRestore.setCreatedAt(now);
					csecGroupRestore.setCreatedByUserId(auth.getSecUserId());
					csecGroupRestore.setUpdatedAt(now);
					csecGroupRestore.setUpdatedByUserId(auth.getSecUserId());
					csecGroupRestore.setRequiredContainerSysGrp(restorePermName);
					csecGroupRestore.setRequiredSecClusGrpId(csecGroupRestoreID);
					csecGroupRestore.setRequiredOwnerCluster(secSysClusGroupSysAdmin.getRequiredOwnerCluster());
					csecGroupRestore = ISecureSchema.getBackingSecure().getTableSecClusGrp().createSecClusGrp(auth, csecGroupRestore);
					csecGroupRestoreID = csecGroupRestore.getRequiredSecClusGrpId();
				}
			}

			if (isMutable) {
				if (csecGroupMutate == null) {
					csecGroupMutate = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecClusGrp().newRec();
					csecGroupMutate.setRequiredRevision(1);
					csecGroupMutate.setCreatedAt(now);
					csecGroupMutate.setCreatedByUserId(auth.getSecUserId());
					csecGroupMutate.setUpdatedAt(now);
					csecGroupMutate.setUpdatedByUserId(auth.getSecUserId());
					csecGroupMutate.setRequiredContainerSysGrp(mutatePermName);
					csecGroupMutate.setRequiredSecClusGrpId(csecGroupMutateID);
					csecGroupMutate.setRequiredOwnerCluster(secSysClusGroupSysAdmin.getRequiredOwnerCluster());
					csecGroupMutate = ISecureSchema.getBackingSecure().getTableSecClusGrp().createSecClusGrp(auth, csecGroupMutate);
					csecGroupMutateID = csecGroupMutate.getRequiredSecClusGrpId();
				}
			}
		}

		if (level == ISecurePubSchema.SecLevelEnum.Tenant ) {
			tsecGroupCreate = ISecureSchema.getBackingSecure().getTableSecTentGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysTenantId(), createPermName);
			if (tsecGroupCreate != null) {
				tsecGroupCreateID = tsecGroupCreate.getRequiredSecTentGrpId();
			}
			else {
				tsecGroupCreateID = null;
			}

			tsecGroupRead = ISecureSchema.getBackingSecure().getTableSecTentGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysTenantId(), readPermName);
			if (tsecGroupRead != null) {
				tsecGroupReadID = tsecGroupRead.getRequiredSecTentGrpId();
			}
			else {
				tsecGroupReadID = null;
			}

			tsecGroupUpdate = ISecureSchema.getBackingSecure().getTableSecTentGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysTenantId(), updatePermName);
			if (tsecGroupUpdate != null) {
				tsecGroupUpdateID = tsecGroupUpdate.getRequiredSecTentGrpId();
			}
			else {
				tsecGroupUpdateID = null;
			}

			tsecGroupDelete = ISecureSchema.getBackingSecure().getTableSecTentGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysTenantId(), deletePermName);
			if (tsecGroupDelete != null) {
				tsecGroupDeleteID = tsecGroupDelete.getRequiredSecTentGrpId();
			}
			else {
				tsecGroupDeleteID = null;
			}

			if (hasHistory) {
				tsecGroupRestore = ISecureSchema.getBackingSecure().getTableSecTentGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysTenantId(), restorePermName);
				if (tsecGroupRestore != null) {
					tsecGroupRestoreID = tsecGroupRestore.getRequiredSecTentGrpId();
				}
				else {
					tsecGroupRestoreID = null;
				}
			}
			else {
				tsecGroupRestore = null;
				tsecGroupRestoreID = null;
			}

			if (isMutable) {
				tsecGroupMutate = ISecureSchema.getBackingSecure().getTableSecTentGrp().readDerivedByUNameIdx(auth, ISecureSchema.getSysTenantId(), mutatePermName);
				if (tsecGroupMutate != null) {
					tsecGroupMutateID = tsecGroupMutate.getRequiredSecTentGrpId();
				}
				else {
					tsecGroupMutateID = null;
				}
			}
			else {
				tsecGroupMutate = null;
				tsecGroupMutateID = null;
			}

			if (tsecGroupCreateID == null || tsecGroupCreateID.isNull()) {
				tsecGroupCreateID = new YCFDbKeyHash256(0);
			}
			if (tsecGroupReadID == null || tsecGroupReadID.isNull()) {
				tsecGroupReadID = new YCFDbKeyHash256(0);
			}
			if (tsecGroupUpdateID == null || tsecGroupUpdateID.isNull()) {
				tsecGroupUpdateID = new YCFDbKeyHash256(0);
			}
			if (tsecGroupDeleteID == null || tsecGroupDeleteID.isNull()) {
				tsecGroupDeleteID = new YCFDbKeyHash256(0);
			}
			if (hasHistory) {
				if (tsecGroupRestoreID == null || tsecGroupRestoreID.isNull()) {
					tsecGroupRestoreID = new YCFDbKeyHash256(0);
				}
			}
			if (isMutable) {
				if (tsecGroupMutateID == null || tsecGroupMutateID.isNull()) {
					tsecGroupMutateID = new YCFDbKeyHash256(0);
				}
			}

			if (tsecGroupCreate == null) {
				tsecGroupCreate = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecTentGrp().newRec();
				tsecGroupCreate.setRequiredRevision(1);
				tsecGroupCreate.setCreatedAt(now);
				tsecGroupCreate.setCreatedByUserId(auth.getSecUserId());
				tsecGroupCreate.setUpdatedAt(now);
				tsecGroupCreate.setUpdatedByUserId(auth.getSecUserId());
				tsecGroupCreate.setRequiredContainerSysGrp(createPermName);
				tsecGroupCreate.setRequiredSecTentGrpId(tsecGroupCreateID);
				tsecGroupCreate.setRequiredOwnerTenant(secSysTentGroupSysAdmin.getRequiredOwnerTenant());
				tsecGroupCreate = ISecureSchema.getBackingSecure().getTableSecTentGrp().createSecTentGrp(auth, tsecGroupCreate);
				tsecGroupCreateID = tsecGroupCreate.getRequiredSecTentGrpId();
			}

			if (tsecGroupRead == null) {
				tsecGroupRead = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecTentGrp().newRec();
				tsecGroupRead.setRequiredRevision(1);
				tsecGroupRead.setCreatedAt(now);
				tsecGroupRead.setCreatedByUserId(auth.getSecUserId());
				tsecGroupRead.setUpdatedAt(now);
				tsecGroupRead.setUpdatedByUserId(auth.getSecUserId());
				tsecGroupRead.setRequiredContainerSysGrp(readPermName);
				tsecGroupRead.setRequiredSecTentGrpId(tsecGroupReadID);
				tsecGroupRead.setRequiredOwnerTenant(secSysTentGroupSysAdmin.getRequiredOwnerTenant());
				tsecGroupRead = ISecureSchema.getBackingSecure().getTableSecTentGrp().createSecTentGrp(auth, tsecGroupRead);
				tsecGroupReadID = tsecGroupRead.getRequiredSecTentGrpId();
			}

			if (tsecGroupUpdate == null) {
				tsecGroupUpdate = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecTentGrp().newRec();
				tsecGroupUpdate.setRequiredRevision(1);
				tsecGroupUpdate.setCreatedAt(now);
				tsecGroupUpdate.setCreatedByUserId(auth.getSecUserId());
				tsecGroupUpdate.setUpdatedAt(now);
				tsecGroupUpdate.setUpdatedByUserId(auth.getSecUserId());
				tsecGroupUpdate.setRequiredContainerSysGrp(updatePermName);
				tsecGroupUpdate.setRequiredSecTentGrpId(tsecGroupUpdateID);
				tsecGroupUpdate.setRequiredOwnerTenant(secSysTentGroupSysAdmin.getRequiredOwnerTenant());
				tsecGroupUpdate = ISecureSchema.getBackingSecure().getTableSecTentGrp().createSecTentGrp(auth, tsecGroupUpdate);
				tsecGroupUpdateID = tsecGroupUpdate.getRequiredSecTentGrpId();
			}

			if (tsecGroupDelete == null) {
				tsecGroupDelete = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecTentGrp().newRec();
				tsecGroupDelete.setRequiredRevision(1);
				tsecGroupDelete.setCreatedAt(now);
				tsecGroupDelete.setCreatedByUserId(auth.getSecUserId());
				tsecGroupDelete.setUpdatedAt(now);
				tsecGroupDelete.setUpdatedByUserId(auth.getSecUserId());
				tsecGroupDelete.setRequiredContainerSysGrp(deletePermName);
				tsecGroupDelete.setRequiredSecTentGrpId(tsecGroupDeleteID);
				tsecGroupDelete.setRequiredOwnerTenant(secSysTentGroupSysAdmin.getRequiredOwnerTenant());
				tsecGroupDelete = ISecureSchema.getBackingSecure().getTableSecTentGrp().createSecTentGrp(auth, tsecGroupDelete);
				tsecGroupDeleteID = tsecGroupDelete.getRequiredSecTentGrpId();
			}

			if (hasHistory) {
				if (tsecGroupRestore == null) {
					tsecGroupRestore = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecTentGrp().newRec();
					tsecGroupRestore.setRequiredRevision(1);
					tsecGroupRestore.setCreatedAt(now);
					tsecGroupRestore.setCreatedByUserId(auth.getSecUserId());
					tsecGroupRestore.setUpdatedAt(now);
					tsecGroupRestore.setUpdatedByUserId(auth.getSecUserId());
					tsecGroupRestore.setRequiredContainerSysGrp(restorePermName);
					tsecGroupRestore.setRequiredSecTentGrpId(tsecGroupRestoreID);
					tsecGroupRestore.setRequiredOwnerTenant(secSysTentGroupSysAdmin.getRequiredOwnerTenant());
					tsecGroupRestore = ISecureSchema.getBackingSecure().getTableSecTentGrp().createSecTentGrp(auth, tsecGroupRestore);
					tsecGroupRestoreID = tsecGroupRestore.getRequiredSecTentGrpId();
				}
			}

			if (isMutable) {
				if (tsecGroupMutate == null) {
					tsecGroupMutate = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecTentGrp().newRec();
					tsecGroupMutate.setRequiredRevision(1);
					tsecGroupMutate.setCreatedAt(now);
					tsecGroupMutate.setCreatedByUserId(auth.getSecUserId());
					tsecGroupMutate.setUpdatedAt(now);
					tsecGroupMutate.setUpdatedByUserId(auth.getSecUserId());
					tsecGroupMutate.setRequiredContainerSysGrp(mutatePermName);
					tsecGroupMutate.setRequiredSecTentGrpId(tsecGroupMutateID);
					tsecGroupMutate.setRequiredOwnerTenant(secSysTentGroupSysAdmin.getRequiredOwnerTenant());
					tsecGroupMutate = ISecureSchema.getBackingSecure().getTableSecTentGrp().createSecTentGrp(auth, tsecGroupMutate);
					tsecGroupMutateID = tsecGroupMutate.getRequiredSecTentGrpId();
				}
			}
		}
	}		

	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapAllTablesSecurity(SecurePubTableData tableData[]) {
		bootstrapAllTablesSecurity(ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), tableData);
	}

	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]) {
		LocalDateTime now = LocalDateTime.now();
		ISecureSecSession bootstrapSession;
		YCFDbKeyHash256 bootstrapSessionID = new YCFDbKeyHash256(0);
		YCFDbKeyHash256 systemUID = ISecureSchema.getSystemId();

		SecureAuthorization auth = new SecureAuthorization();
		auth.setSecUserId(systemUID);
		auth.setAuthUuid6(YCFUuid6.generateUuid6());
		auth.setSecClusterId(clusterId);
		auth.setSecTenantId(tenantId);
		auth.setSecSessionId(bootstrapSessionID);
		ISecureSchema.setAuthorizationCallback( new ISecureAuthorizationCallback() {
			SecureAuthorization myauth = auth;
			@Override
			public ISecureAuthorization getEffectiveAuthorization() {
				return(myauth);
			}
		});

//ISecureSchema.getSysTenantId(), ISecureSchema.getSystemId()
		bootstrapSession = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSession().newRec();
		bootstrapSession.setRequiredRevision(1);
		bootstrapSession.setRequiredSecSessionId(bootstrapSessionID);
		bootstrapSession.setRequiredSecUserId(systemUID);
		bootstrapSession.setOptionalSecProxyId(systemUID);
		bootstrapSession.setRequiredStart(now);
		bootstrapSession.setOptionalFinish(null);
		bootstrapSession = ISecureSchema.getBackingSecure().getTableSecSession().createSecSession(auth, bootstrapSession);
		bootstrapSessionID = bootstrapSession.getRequiredSecSessionId();

		ISecureSecSysGrp secSystemAdminGroup = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx( auth, "systemadmin");
		if (secSystemAdminGroup == null) {
			throw new YCFNullArgumentException(getClass(), "bootstrapAllTablesSecurity", 0, "secSystemAdminGroup");
		}

		ISecureSecSysGrp secSysGroupPublic = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx( auth, "public");
		if (secSysGroupPublic == null) {
			throw new YCFNullArgumentException(getClass(), "bootstrapAllTablesSecurity", 0, "secSysGroupPublic");
		}
		
		ISecureCluster secCluster = ISecureSchema.getBackingSecure().getTableCluster().readDerived(auth, clusterId);
		if (secCluster == null) {
			throw new YCFNullArgumentException(getClass(), "bootstrapAllTablesSecurity", 0, "secCluster<" + clusterId.toString() + ">");
		}
		
		ISecureTenant secTenant = ISecureSchema.getBackingSecure().getTableTenant().readDerived(auth, tenantId);
		if (secTenant == null) {
			throw new YCFNullArgumentException(getClass(), "bootstrapAllTablesSecurity", 0, "secTenant<" + tenantId.toString() + ">");
		}
	
		bootstrapAllTablesSecurity(auth, systemUID, bootstrapSession, secSystemAdminGroup, secSysGroupPublic, secCluster, secTenant, tableData);

		if (bootstrapSession != null && bootstrapSessionID != null && !bootstrapSessionID.isNull() && bootstrapSession.getOptionalFinish() == null) {
			bootstrapSession.setOptionalFinish(LocalDateTime.now());
			bootstrapSession = ISecureSchema.getBackingSecure().getTableSecSession().updateSecSession(auth, bootstrapSession);
			ISecureSchema.setAuthorizationCallback( new ISecureAuthorizationCallback() {
				@Override
				public ISecureAuthorization getEffectiveAuthorization() {
					return(null);
				}
			});
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapAllTablesSecurity(ISecureAuthorization auth,
		YCFDbKeyHash256 systemUID,
		ISecureSecSession bootstrapSession,
		ISecureSecSysGrp secSystemAdminGroup,
		ISecureSecSysGrp secSysGroupPublic,
		ISecureCluster secCluster,
		ISecureTenant secTenant,
		SecurePubTableData tableData[])
	{
		LocalDateTime now = LocalDateTime.now();

		YCFDbKeyHash256 bootstrapSessionID = bootstrapSession.getRequiredSecSessionId();
		if (secSystemAdminGroup == null) {
			throw new YCFNullArgumentException(getClass(), "bootstrapAllTablesSecurity", 0, "secSystemAdminGroup");
		}
		if (secSysGroupPublic == null) {
			throw new YCFNullArgumentException(getClass(), "bootstrapAllTablesSecurity", 0, "secSysGroupPublic");
		}
		if (secCluster == null) {
			throw new YCFNullArgumentException(getClass(), "bootstrapAllTablesSecurity", 0, "secCluster");
		}
		if (secTenant == null) {
			throw new YCFNullArgumentException(getClass(), "bootstrapAllTablesSecurity", 0, "secTenant");
		}

		ISecureSecSysGrp secSysClusGroupSysAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx(auth, secCluster.getRequiredDescription().toLowerCase() + "clusteradmin");
		if (secSysClusGroupSysAdmin == null) {
			secSysClusGroupSysAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrp().newRec();
			secSysClusGroupSysAdmin.setCreatedAt(now);
			secSysClusGroupSysAdmin.setCreatedByUserId(systemUID);
			secSysClusGroupSysAdmin.setUpdatedAt(now);
			secSysClusGroupSysAdmin.setUpdatedByUserId(systemUID);
			secSysClusGroupSysAdmin.setRequiredName(secCluster.getRequiredDescription().toLowerCase() + "clusteradmin");
			secSysClusGroupSysAdmin.setRequiredRevision(1);
			secSysClusGroupSysAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrp().createSecSysGrp(auth, secSysClusGroupSysAdmin);
		}

		ISecureSecSysGrp secSysTentGroupSysAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrp().readDerivedByUNameIdx(auth, secTenant.getRequiredTenantName().toLowerCase() + "tenantadmin");
		if (secSysTentGroupSysAdmin == null) {
			secSysTentGroupSysAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecSysGrp().newRec();
			secSysTentGroupSysAdmin.setCreatedAt(now);
			secSysTentGroupSysAdmin.setCreatedByUserId(systemUID);
			secSysTentGroupSysAdmin.setUpdatedAt(now);
			secSysTentGroupSysAdmin.setUpdatedByUserId(systemUID);
			secSysTentGroupSysAdmin.setRequiredName(secTenant.getRequiredTenantName().toLowerCase() + "tenantadmin");
			secSysTentGroupSysAdmin.setRequiredRevision(1);
			secSysTentGroupSysAdmin = ISecureSchema.getBackingSecure().getTableSecSysGrp().createSecSysGrp(auth, secSysTentGroupSysAdmin);
		}

		ISecureSecClusGrp secClusGroupSysAdmin = ISecureSchema.getBackingSecure().getTableSecClusGrp().readDerivedByUNameIdx(auth, secCluster.getRequiredId(), secCluster.getRequiredDescription().toLowerCase() + "clusteradmin");
		if (secClusGroupSysAdmin == null) {
			secClusGroupSysAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecClusGrp().newRec();
			secClusGroupSysAdmin.setCreatedAt(now);
			secClusGroupSysAdmin.setCreatedByUserId(systemUID);
			secClusGroupSysAdmin.setUpdatedAt(now);
			secClusGroupSysAdmin.setUpdatedByUserId(systemUID);
			secClusGroupSysAdmin.setRequiredContainerSysGrp(secCluster.getRequiredDescription().toLowerCase() + "clusteradmin");
			secClusGroupSysAdmin.setRequiredOwnerCluster(secCluster);
			secClusGroupSysAdmin.setRequiredRevision(1);
			secClusGroupSysAdmin = ISecureSchema.getBackingSecure().getTableSecClusGrp().createSecClusGrp(auth, secClusGroupSysAdmin);
		}

		ISecureSecClusGrpMemb secClusGroupMembSystemAdmin = ISecureSchema.getBackingSecure().getTableSecClusGrpMemb().readDerivedByIdIdx(auth, secClusGroupSysAdmin.getRequiredSecClusGrpId(), "systemadmin");
		if (secClusGroupMembSystemAdmin == null) {
			secClusGroupMembSystemAdmin = new SecureJpaSecClusGrpMemb();
			secClusGroupMembSystemAdmin.setRequiredContainerGroup(secClusGroupSysAdmin);
			secClusGroupMembSystemAdmin.setCreatedAt(now);
			secClusGroupMembSystemAdmin.setCreatedByUserId(systemUID);
			secClusGroupMembSystemAdmin.setUpdatedAt(now);
			secClusGroupMembSystemAdmin.setUpdatedByUserId(systemUID);
			secClusGroupMembSystemAdmin.setRequiredParentUser("systemadmin");
			secClusGroupMembSystemAdmin.setRequiredRevision(1);
			secClusGroupMembSystemAdmin = (SecureJpaSecClusGrpMemb)(secclusgrpmembService.create((SecureJpaSecClusGrpMemb)secClusGroupMembSystemAdmin));
		}
		
		ISecureSecTentGrp secTentGroupSysAdmin = ISecureSchema.getBackingSecure().getTableSecTentGrp().readDerivedByUNameIdx(auth, secTenant.getRequiredId(), secTenant.getRequiredTenantName().toLowerCase() + "tenantadmin");
		if (secTentGroupSysAdmin == null) {
			secTentGroupSysAdmin = ISecureSchema.getBackingSecure().getSecureFactory().getFactorySecTentGrp().newRec();
			secTentGroupSysAdmin.setCreatedAt(now);
			secTentGroupSysAdmin.setCreatedByUserId(systemUID);
			secTentGroupSysAdmin.setUpdatedAt(now);
			secTentGroupSysAdmin.setUpdatedByUserId(systemUID);
			secTentGroupSysAdmin.setRequiredContainerSysGrp(secTenant.getRequiredTenantName().toLowerCase() + "tenantadmin");
			secTentGroupSysAdmin.setRequiredOwnerTenant(secTenant);
			secTentGroupSysAdmin.setRequiredRevision(1);
			secTentGroupSysAdmin = ISecureSchema.getBackingSecure().getTableSecTentGrp().createSecTentGrp(auth, secTentGroupSysAdmin);
		}

		ISecureSecTentGrpMemb secTentGroupMembSystemAdmin = ISecureSchema.getBackingSecure().getTableSecTentGrpMemb().readDerivedByIdIdx(auth, secTentGroupSysAdmin.getRequiredSecTentGrpId(), "systemadmin");
		if (secTentGroupMembSystemAdmin == null) {
			secTentGroupMembSystemAdmin = new SecureJpaSecTentGrpMemb();
			secTentGroupMembSystemAdmin.setRequiredContainerGroup(secTentGroupSysAdmin);
			secTentGroupMembSystemAdmin.setCreatedAt(now);
			secTentGroupMembSystemAdmin.setCreatedByUserId(systemUID);
			secTentGroupMembSystemAdmin.setUpdatedAt(now);
			secTentGroupMembSystemAdmin.setUpdatedByUserId(systemUID);
			secTentGroupMembSystemAdmin.setRequiredParentUser("systemadmin");
			secTentGroupMembSystemAdmin.setRequiredRevision(1);
			secTentGroupMembSystemAdmin = (SecureJpaSecTentGrpMemb)(sectentgrpmembService.create((SecureJpaSecTentGrpMemb)secTentGroupMembSystemAdmin));
		}

		for( SecurePubTableData data: tableData) {
			bootstrapTableSecurity(auth, LocalDateTime.now(), data.getTableName(), data.hasHistory(), data.isMutable(), data.getScope(), secSysGroupPublic, secSystemAdminGroup, secClusGroupSysAdmin, secTentGroupSysAdmin);
		}
	}


	/***** Internal low-level security service methods to satisfy SecurityCache implementations */

	/**
	 *	Count system-level security access for permission granted to a specific user by LoginId.
	 *
	 *		@param parmPermName The name of the permission to be checked (all lowercase in the case of generated permission names; custom roles might be mixed-case)
	 *		@param parmLoginId The LoginId of the user being authorized.
	 *		@return The number of authorizations for the specified permission and user, with an 8-level deep union in play.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	long countSysSecurityPermsByLoginId(String parmPermName, String parmLoginId) {
		EntityManager em = secure31EntityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		TypedQuery<Long> query = em.createNamedQuery("secure31SecUser.countSysSecurityPermsByLoginId", Long.class);
		query.setParameter("parmPermName", parmPermName);
		query.setParameter("parmLoginId", parmLoginId);
		Long val = query.getSingleResult();
		em.close();
		if (val != null) {
			return(val);
		}
		else {
			return(0L);
		}
	}

	/**
	 *	Count system-level security access for permission granted to a specific user by SecUserId.
	 *
	 *		@param parmPermName The name of the permission to be checked (all lowercase in the case of generated permission names; custom roles might be mixed-case)
	 *		@param parmUserId The UserId of the user being authorized.
	 *		@return The number of authorizations for the specified permission and user, with an 8-level deep union in play.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	long countSysSecurityPermsByUserId(String parmPermName, YCFDbKeyHash256 parmUserId) {
		EntityManager em = secure31EntityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		TypedQuery<Long> query = em.createNamedQuery("secure31SecUser.countSysSecurityPermsByUserId", Long.class);
		query.setParameter("parmPermName", parmPermName);
		query.setParameter("parmUserId", parmUserId);
		Long val = query.getSingleResult();
		em.close();
		if (val != null) {
			return(val);
		}
		else {
			return(0L);
		}
	}

	/**
	 *	Count cluster-level security access for permission granted to a specific user by LoginId for the specified ClusterId.
	 *
	 *		@param parmPermName The name of the permission to be checked (all lowercase in the case of generated permission names; custom roles might be mixed-case)
	 *		@param parmLoginId The LoginId of the user being authorized.
	 *		@param parmClusterId The ClusterId of the permission to be checked (not necessarily the user's current cluster)
	 *		@return The number of authorizations for the specified permission and user, with an 8-level deep union in play.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	long countClusSecurityPermsByLoginId(String parmPermName, String parmLoginId, YCFDbKeyHash256 parmClusterId) {
		EntityManager em = secure31EntityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		TypedQuery<Long> query = em.createNamedQuery("secure31SecUser.countClusSecurityPermsByLoginId", Long.class);
		query.setParameter("parmPermName", parmPermName);
		query.setParameter("parmLoginId", parmLoginId);
		query.setParameter("parmClusterId", parmClusterId);
		Long val = query.getSingleResult();
		em.close();
		if (val != null) {
			return(val);
		}
		else {
			return(0L);
		}
	}

	/**
	 *	Count cluster-level security access for permission granted to a specific user by SecUserId for the specified ClusterId.
	 *
	 *		@param parmPermName The name of the permission to be checked (all lowercase in the case of generated permission names; custom roles might be mixed-case)
	 *		@param parmLoginId The LoginId of the user being authorized.
	 *		@param parmClusterId The ClusterId of the permission to be checked (not necessarily the user's current cluster)
	 *		@return The number of authorizations for the specified permission and user, with an 8-level deep union in play.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	long countClusSecurityPermsByUserId(String parmPermName, YCFDbKeyHash256 parmUserId, YCFDbKeyHash256 parmClusterId) {
		EntityManager em = secure31EntityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		TypedQuery<Long> query = em.createNamedQuery("secure31SecUser.countClusSecurityPermsByUserId", Long.class);
		query.setParameter("parmPermName", parmPermName);
		query.setParameter("parmUserId", parmUserId);
		query.setParameter("parmClusterId", parmClusterId);
		Long val = query.getSingleResult();
		em.close();
		if (val != null) {
			return(val);
		}
		else {
			return(0L);
		}
	}

	/**
	 *	Count tenant-level security access for permission granted to a specific user by LoginId for the specified TenantId.
	 *
	 *		@param parmPermName The name of the permission to be checked (all lowercase in the case of generated permission names; custom roles might be mixed-case)
	 *		@param parmLoginId The LoginId of the user being authorized.
	 *		@param parmTenantId The TenantId of the permission to be checked (not necessarily the user's current tenant)
	 *		@return The number of authorizations for the specified permission and user, with an 8-level deep union in play.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	long countTentSecurityPermsByLoginId(String parmPermName, String parmLoginId, YCFDbKeyHash256 parmTenantId) {
		EntityManager em = secure31EntityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		TypedQuery<Long> query = em.createNamedQuery("secure31SecUser.countTentSecurityPermsByLoginId", Long.class);
		query.setParameter("parmPermName", parmPermName);
		query.setParameter("parmLoginId", parmLoginId);
		query.setParameter("parmTenantId", parmTenantId);
		Long val = query.getSingleResult();
		em.close();
		if (val != null) {
			return(val);
		}
		else {
			return(0L);
		}
	}

	/**
	 *	Count tenant-level security access for permission granted to a specific user by SecUserId for the specified TenantId.
	 *
	 *		@param parmPermName The name of the permission to be checked (all lowercase in the case of generated permission names; custom roles might be mixed-case)
	 *		@param parmLoginId The LoginId of the user being authorized.
	 *		@param parmTenantId The TenantId of the permission to be checked (not necessarily the user's current tenant)
	 *		@return The number of authorizations for the specified permission and user, with an 8-level deep union in play.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	long countTentSecurityPermsByUserId(String parmPermName, YCFDbKeyHash256 parmUserId, YCFDbKeyHash256 parmTenantId) {
		EntityManager em = secure31EntityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		TypedQuery<Long> query = em.createNamedQuery("secure31SecUser.countTentSecurityPermsByUserId", Long.class);
		query.setParameter("parmPermName", parmPermName);
		query.setParameter("parmUserId", parmUserId);
		query.setParameter("parmTenantId", parmTenantId);
		Long val = query.getSingleResult();
		em.close();
		if (val != null) {
			return(val);
		}
		else {
			return(0L);
		}
	}

	/***** Backend security service methods */

	/**
	 *	Map the userLogin string to a userId DbKey.
	 *
	 *	@param userLogin 
	 *	@return null if the userLogin does not exist, is null, is empty, or is blank. Otherwise the DbKey for the user.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public YCFDbKeyHash256 mapUserLoginToUserId(String userLogin) {
		final String S_ProcName = "mapUserLoginToUserId";
		if (userLogin == null || userLogin.isEmpty() || userLogin.isBlank()) {
			return(null);
		}
		SecureJpaSecUser rec = secuserService.findByULoginIdx(userLogin);
		if (rec == null) {
			return(null);
		}
		else {
			return(rec.getPKey());
		}
	}

	/**
	 *	Map the userId DbKey to the userLogin string.
	 *
	 *	@param userId
	 *	@return null if the userId does not exist or is null. Otherwise the userLogin for the user.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public String mapUserIdToUserLogin(YCFDbKeyHash256 userId) {
		final String S_ProcName = "mapUserIdToUserLogin";
		if (userId == null || userId.isNull()) {
			return(null);
		}
		SecureJpaSecUser rec = secuserService.find(userId);
		if (rec == null) {
			return(null);
		}
		else {
			return(rec.getRequiredLoginId());
		}
	}

	/**
	 *	Probe the back-end SecRole*, SecTent* security tables, then the SecClus* security tables, and finally the SecSys* tables
	 *	in order until a probe authorizes the users access to the permission role or group.  The probed value is then "acquired" by
	 *	the cache and kept until it expires or is forgotten by the cache.
	 *
	 *	@param userId The user id for the SecUser object this query is for.
	 *	@param clusterId The cluster id of the cluster that contains the tenant being queried.
	 *	@param tenantId The tenant id being queried.
	 *	@param permissionName The name of the permission role or group being queried.
	 *
	 *	@return true if the user is a member of the tenant role or group, the equivalent cluster admin role or group, or the equivalent system admin role or group, otherwise false.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public boolean probeMemberOfTenantGroup(YCFDbKeyHash256 userId, YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, String permissionName) {
		if (userId == null || userId.isNull()) {
			return(false);
		}
		if (permissionName == null || permissionName.isEmpty() || permissionName.isBlank()) {
			return(false);
		}
		if (clusterId == null || clusterId.isNull()) {
			return(false);
		}
		if (tenantId == null || tenantId.isNull()) {
			return(false);
		}
		long granted = countTentSecurityPermsByUserId(permissionName, userId, tenantId);
		if (granted > 0) {
			return(true);
		}
		granted = countClusSecurityPermsByUserId(permissionName, userId, clusterId);
		if (granted > 0) {
			return(true);
		}
		granted = countSysSecurityPermsByUserId(permissionName, userId);
		if (granted > 0) {
			return(true);
		}
		return(false);
	}

	/**
	 *	Probe the back-end SecRole*, SecClus* security tables, and finally the SecSys* tables in order until a probe authorizes
	 *	the users access to the permission role or group.  The probed value is then "acquired" by the cache and kept until it
	 *	expires or is forgotten by the cache.
	 *
	 *	@param userId The user id for the SecUser object this query is for.
	 *	@param clusterId The cluster id of the cluster that contains the tenant being queried.
	 *	@param permissionName The name of the permission role or group being queried.
	 *
	 *	@return true if the user is a member of the tenant role or group, the equivalent cluster admin role or group, or the equivalent system admin role or group, otherwise false.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public boolean probeMemberOfClusterGroup(YCFDbKeyHash256 userId, YCFDbKeyHash256 clusterId, String permissionName) {
		if (userId == null || userId.isNull()) {
			return(false);
		}
		if (permissionName == null || permissionName.isEmpty() || permissionName.isBlank()) {
			return(false);
		}
		if (clusterId == null || clusterId.isNull()) {
			return(false);
		}
		long granted = countClusSecurityPermsByUserId(permissionName, userId, clusterId);
		if (granted > 0) {
			return(true);
		}
		granted = countSysSecurityPermsByUserId(permissionName, userId);
		if (granted > 0) {
			return(true);
		}
		return(false);
	}

	/**
	 *	Probe the back-end SecRole*, and SecSys* tables until a probe authorizes the users access to the permission role or group.
	 *	The probed value is then "acquired" by the cache and kept until it expires or is forgotten by the cache.
	 *
	 *	@param userId The user id for the SecUser object this query is for.
	 *	@param permissionName The name of the permission role or group being queried.
	 *
	 *	@return true if the user is a member of the tenant role or group, the equivalent cluster admin role or group, or the equivalent system admin role or group, otherwise false.
	 */
	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public boolean probeMemberOfSystemGroup(YCFDbKeyHash256 userId, String permissionName) {
		if (userId == null || userId.isNull()) {
			return(false);
		}
		if (permissionName == null || permissionName.isEmpty() || permissionName.isBlank()) {
			return(false);
		}
		long granted = countSysSecurityPermsByUserId(permissionName, userId);
		if (granted > 0) {
			return(true);
		}
		return(false);
	}

		// Customized schematweak [Secure::Secure].JpaSchemaServiceCustomServices
}
