// Description: Java 25 JPA implementation of a Secure factory service.

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import server.markhome.ycf.v3_1.secure.secure.*;

/**
 *	JPA Factory Services for schema Secure as specified by ISecureFactory.
 */
@Service("secure31JpaFactoryService")
public class SecureJpaFactoryService
	implements ISecureFactory
{

	@Autowired
	@Qualifier("secure31JpaClusterFactoryService")
	protected SecureJpaClusterFactoryService clusterFactoryService;

	@Autowired
	@Qualifier("secure31JpaTenantFactoryService")
	protected SecureJpaTenantFactoryService tenantFactoryService;

	@Autowired
	@Qualifier("secure31JpaTableInfoFactoryService")
	protected SecureJpaTableInfoFactoryService tableinfoFactoryService;

	@Autowired
	@Qualifier("secure31JpaISOCcyFactoryService")
	protected SecureJpaISOCcyFactoryService isoccyFactoryService;

	@Autowired
	@Qualifier("secure31JpaISOCtryFactoryService")
	protected SecureJpaISOCtryFactoryService isoctryFactoryService;

	@Autowired
	@Qualifier("secure31JpaISOCtryCcyFactoryService")
	protected SecureJpaISOCtryCcyFactoryService isoctryccyFactoryService;

	@Autowired
	@Qualifier("secure31JpaISOCtryLangFactoryService")
	protected SecureJpaISOCtryLangFactoryService isoctrylangFactoryService;

	@Autowired
	@Qualifier("secure31JpaISOLangFactoryService")
	protected SecureJpaISOLangFactoryService isolangFactoryService;

	@Autowired
	@Qualifier("secure31JpaISOTZoneFactoryService")
	protected SecureJpaISOTZoneFactoryService isotzoneFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecUserFactoryService")
	protected SecureJpaSecUserFactoryService secuserFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecUserPasswordFactoryService")
	protected SecureJpaSecUserPasswordFactoryService secuserpasswordFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecUserEMConfFactoryService")
	protected SecureJpaSecUserEMConfFactoryService secuseremconfFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecUserPWResetFactoryService")
	protected SecureJpaSecUserPWResetFactoryService secuserpwresetFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecUserPWHistoryFactoryService")
	protected SecureJpaSecUserPWHistoryFactoryService secuserpwhistoryFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecSysGrpFactoryService")
	protected SecureJpaSecSysGrpFactoryService secsysgrpFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecSysGrpIncFactoryService")
	protected SecureJpaSecSysGrpIncFactoryService secsysgrpincFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecSysGrpMembFactoryService")
	protected SecureJpaSecSysGrpMembFactoryService secsysgrpmembFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecClusGrpFactoryService")
	protected SecureJpaSecClusGrpFactoryService secclusgrpFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecClusGrpMembFactoryService")
	protected SecureJpaSecClusGrpMembFactoryService secclusgrpmembFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecTentGrpFactoryService")
	protected SecureJpaSecTentGrpFactoryService sectentgrpFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecTentGrpMembFactoryService")
	protected SecureJpaSecTentGrpMembFactoryService sectentgrpmembFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecSysRoleFactoryService")
	protected SecureJpaSecSysRoleFactoryService secsysroleFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecSysRoleEnablesFactoryService")
	protected SecureJpaSecSysRoleEnablesFactoryService secsysroleenablesFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecSysRoleMembFactoryService")
	protected SecureJpaSecSysRoleMembFactoryService secsysrolemembFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecClusRoleFactoryService")
	protected SecureJpaSecClusRoleFactoryService secclusroleFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecClusRoleMembFactoryService")
	protected SecureJpaSecClusRoleMembFactoryService secclusrolemembFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecTentRoleFactoryService")
	protected SecureJpaSecTentRoleFactoryService sectentroleFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecTentRoleMembFactoryService")
	protected SecureJpaSecTentRoleMembFactoryService sectentrolemembFactoryService;

	@Autowired
	@Qualifier("secure31JpaSecSessionFactoryService")
	protected SecureJpaSecSessionFactoryService secsessionFactoryService;

	@Autowired
	@Qualifier("secure31JpaSysClusterFactoryService")
	protected SecureJpaSysClusterFactoryService sysclusterFactoryService;


	public SecureJpaFactoryService() { }

	@Override
	public ISecureClusterFactory getFactoryCluster() {
		return(clusterFactoryService);
	}

	public SecureJpaClusterFactoryService getClusterFactoryService() {
		return(clusterFactoryService);
	}

	@Override
	public ISecureTenantFactory getFactoryTenant() {
		return(tenantFactoryService);
	}

	public SecureJpaTenantFactoryService getTenantFactoryService() {
		return(tenantFactoryService);
	}

	@Override
	public ISecureTableInfoFactory getFactoryTableInfo() {
		return(tableinfoFactoryService);
	}

	public SecureJpaTableInfoFactoryService getTableInfoFactoryService() {
		return(tableinfoFactoryService);
	}

	@Override
	public ISecureISOCcyFactory getFactoryISOCcy() {
		return(isoccyFactoryService);
	}

	public SecureJpaISOCcyFactoryService getISOCcyFactoryService() {
		return(isoccyFactoryService);
	}

	@Override
	public ISecureISOCtryFactory getFactoryISOCtry() {
		return(isoctryFactoryService);
	}

	public SecureJpaISOCtryFactoryService getISOCtryFactoryService() {
		return(isoctryFactoryService);
	}

	@Override
	public ISecureISOCtryCcyFactory getFactoryISOCtryCcy() {
		return(isoctryccyFactoryService);
	}

	public SecureJpaISOCtryCcyFactoryService getISOCtryCcyFactoryService() {
		return(isoctryccyFactoryService);
	}

	@Override
	public ISecureISOCtryLangFactory getFactoryISOCtryLang() {
		return(isoctrylangFactoryService);
	}

	public SecureJpaISOCtryLangFactoryService getISOCtryLangFactoryService() {
		return(isoctrylangFactoryService);
	}

	@Override
	public ISecureISOLangFactory getFactoryISOLang() {
		return(isolangFactoryService);
	}

	public SecureJpaISOLangFactoryService getISOLangFactoryService() {
		return(isolangFactoryService);
	}

	@Override
	public ISecureISOTZoneFactory getFactoryISOTZone() {
		return(isotzoneFactoryService);
	}

	public SecureJpaISOTZoneFactoryService getISOTZoneFactoryService() {
		return(isotzoneFactoryService);
	}

	@Override
	public ISecureSecUserFactory getFactorySecUser() {
		return(secuserFactoryService);
	}

	public SecureJpaSecUserFactoryService getSecUserFactoryService() {
		return(secuserFactoryService);
	}

	@Override
	public ISecureSecUserPasswordFactory getFactorySecUserPassword() {
		return(secuserpasswordFactoryService);
	}

	public SecureJpaSecUserPasswordFactoryService getSecUserPasswordFactoryService() {
		return(secuserpasswordFactoryService);
	}

	@Override
	public ISecureSecUserEMConfFactory getFactorySecUserEMConf() {
		return(secuseremconfFactoryService);
	}

	public SecureJpaSecUserEMConfFactoryService getSecUserEMConfFactoryService() {
		return(secuseremconfFactoryService);
	}

	@Override
	public ISecureSecUserPWResetFactory getFactorySecUserPWReset() {
		return(secuserpwresetFactoryService);
	}

	public SecureJpaSecUserPWResetFactoryService getSecUserPWResetFactoryService() {
		return(secuserpwresetFactoryService);
	}

	@Override
	public ISecureSecUserPWHistoryFactory getFactorySecUserPWHistory() {
		return(secuserpwhistoryFactoryService);
	}

	public SecureJpaSecUserPWHistoryFactoryService getSecUserPWHistoryFactoryService() {
		return(secuserpwhistoryFactoryService);
	}

	@Override
	public ISecureSecSysGrpFactory getFactorySecSysGrp() {
		return(secsysgrpFactoryService);
	}

	public SecureJpaSecSysGrpFactoryService getSecSysGrpFactoryService() {
		return(secsysgrpFactoryService);
	}

	@Override
	public ISecureSecSysGrpIncFactory getFactorySecSysGrpInc() {
		return(secsysgrpincFactoryService);
	}

	public SecureJpaSecSysGrpIncFactoryService getSecSysGrpIncFactoryService() {
		return(secsysgrpincFactoryService);
	}

	@Override
	public ISecureSecSysGrpMembFactory getFactorySecSysGrpMemb() {
		return(secsysgrpmembFactoryService);
	}

	public SecureJpaSecSysGrpMembFactoryService getSecSysGrpMembFactoryService() {
		return(secsysgrpmembFactoryService);
	}

	@Override
	public ISecureSecClusGrpFactory getFactorySecClusGrp() {
		return(secclusgrpFactoryService);
	}

	public SecureJpaSecClusGrpFactoryService getSecClusGrpFactoryService() {
		return(secclusgrpFactoryService);
	}

	@Override
	public ISecureSecClusGrpMembFactory getFactorySecClusGrpMemb() {
		return(secclusgrpmembFactoryService);
	}

	public SecureJpaSecClusGrpMembFactoryService getSecClusGrpMembFactoryService() {
		return(secclusgrpmembFactoryService);
	}

	@Override
	public ISecureSecTentGrpFactory getFactorySecTentGrp() {
		return(sectentgrpFactoryService);
	}

	public SecureJpaSecTentGrpFactoryService getSecTentGrpFactoryService() {
		return(sectentgrpFactoryService);
	}

	@Override
	public ISecureSecTentGrpMembFactory getFactorySecTentGrpMemb() {
		return(sectentgrpmembFactoryService);
	}

	public SecureJpaSecTentGrpMembFactoryService getSecTentGrpMembFactoryService() {
		return(sectentgrpmembFactoryService);
	}

	@Override
	public ISecureSecSysRoleFactory getFactorySecSysRole() {
		return(secsysroleFactoryService);
	}

	public SecureJpaSecSysRoleFactoryService getSecSysRoleFactoryService() {
		return(secsysroleFactoryService);
	}

	@Override
	public ISecureSecSysRoleEnablesFactory getFactorySecSysRoleEnables() {
		return(secsysroleenablesFactoryService);
	}

	public SecureJpaSecSysRoleEnablesFactoryService getSecSysRoleEnablesFactoryService() {
		return(secsysroleenablesFactoryService);
	}

	@Override
	public ISecureSecSysRoleMembFactory getFactorySecSysRoleMemb() {
		return(secsysrolemembFactoryService);
	}

	public SecureJpaSecSysRoleMembFactoryService getSecSysRoleMembFactoryService() {
		return(secsysrolemembFactoryService);
	}

	@Override
	public ISecureSecClusRoleFactory getFactorySecClusRole() {
		return(secclusroleFactoryService);
	}

	public SecureJpaSecClusRoleFactoryService getSecClusRoleFactoryService() {
		return(secclusroleFactoryService);
	}

	@Override
	public ISecureSecClusRoleMembFactory getFactorySecClusRoleMemb() {
		return(secclusrolemembFactoryService);
	}

	public SecureJpaSecClusRoleMembFactoryService getSecClusRoleMembFactoryService() {
		return(secclusrolemembFactoryService);
	}

	@Override
	public ISecureSecTentRoleFactory getFactorySecTentRole() {
		return(sectentroleFactoryService);
	}

	public SecureJpaSecTentRoleFactoryService getSecTentRoleFactoryService() {
		return(sectentroleFactoryService);
	}

	@Override
	public ISecureSecTentRoleMembFactory getFactorySecTentRoleMemb() {
		return(sectentrolemembFactoryService);
	}

	public SecureJpaSecTentRoleMembFactoryService getSecTentRoleMembFactoryService() {
		return(sectentrolemembFactoryService);
	}

	@Override
	public ISecureSecSessionFactory getFactorySecSession() {
		return(secsessionFactoryService);
	}

	public SecureJpaSecSessionFactoryService getSecSessionFactoryService() {
		return(secsessionFactoryService);
	}

	@Override
	public ISecureSysClusterFactory getFactorySysCluster() {
		return(sysclusterFactoryService);
	}

	public SecureJpaSysClusterFactoryService getSysClusterFactoryService() {
		return(sysclusterFactoryService);
	}

}
