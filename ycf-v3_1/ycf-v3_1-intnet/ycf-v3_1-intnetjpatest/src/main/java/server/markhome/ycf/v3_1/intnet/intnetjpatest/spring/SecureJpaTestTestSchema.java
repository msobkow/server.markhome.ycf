
// Description: Spring JPA tests for Secure for the JpaTest program

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetjpatest.spring;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;

@Service("JpaTestSecure")
public class SecureJpaTestTestSchema {
    
    @Autowired
    @Qualifier("secure31EntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean secure31EntityManagerFactory;
	@Autowired
	private SecureJpaClusterService secureClusterService;

	@Autowired
	private SecureJpaTenantService secureTenantService;

	@Autowired
	private SecureJpaTableInfoService secureTableInfoService;

	@Autowired
	private SecureJpaISOCcyService secureISOCcyService;

	@Autowired
	private SecureJpaISOCtryService secureISOCtryService;

	@Autowired
	private SecureJpaISOCtryCcyService secureISOCtryCcyService;

	@Autowired
	private SecureJpaISOCtryLangService secureISOCtryLangService;

	@Autowired
	private SecureJpaISOLangService secureISOLangService;

	@Autowired
	private SecureJpaISOTZoneService secureISOTZoneService;

	@Autowired
	private SecureJpaSecUserService secureSecUserService;

	@Autowired
	private SecureJpaSecUserPasswordService secureSecUserPasswordService;

	@Autowired
	private SecureJpaSecUserEMConfService secureSecUserEMConfService;

	@Autowired
	private SecureJpaSecUserPWResetService secureSecUserPWResetService;

	@Autowired
	private SecureJpaSecUserPWHistoryService secureSecUserPWHistoryService;

	@Autowired
	private SecureJpaSecSysGrpService secureSecSysGrpService;

	@Autowired
	private SecureJpaSecSysGrpIncService secureSecSysGrpIncService;

	@Autowired
	private SecureJpaSecSysGrpMembService secureSecSysGrpMembService;

	@Autowired
	private SecureJpaSecClusGrpService secureSecClusGrpService;

	@Autowired
	private SecureJpaSecClusGrpMembService secureSecClusGrpMembService;

	@Autowired
	private SecureJpaSecTentGrpService secureSecTentGrpService;

	@Autowired
	private SecureJpaSecTentGrpMembService secureSecTentGrpMembService;

	@Autowired
	private SecureJpaSecSysRoleService secureSecSysRoleService;

	@Autowired
	private SecureJpaSecSysRoleEnablesService secureSecSysRoleEnablesService;

	@Autowired
	private SecureJpaSecSysRoleMembService secureSecSysRoleMembService;

	@Autowired
	private SecureJpaSecClusRoleService secureSecClusRoleService;

	@Autowired
	private SecureJpaSecClusRoleMembService secureSecClusRoleMembService;

	@Autowired
	private SecureJpaSecTentRoleService secureSecTentRoleService;

	@Autowired
	private SecureJpaSecTentRoleMembService secureSecTentRoleMembService;

	@Autowired
	private SecureJpaSecSessionService secureSecSessionService;

	@Autowired
	private SecureJpaSysClusterService secureSysClusterService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    // @PersistenceContext(unitName = "Secure31PU")
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting Secure tests...\n");
		List<?> clusterResults = secureClusterService.findAll();
		if (clusterResults == null) {
			messages.append("Erroneously retrieved null for SecureClusterService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clusterResults.size() + " entities from Secure.Cluster\n");
		}

		List<?> tenantResults = secureTenantService.findAll();
		if (tenantResults == null) {
			messages.append("Erroneously retrieved null for SecureTenantService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tenantResults.size() + " entities from Secure.Tenant\n");
		}

		List<?> tableInfoResults = secureTableInfoService.findAll();
		if (tableInfoResults == null) {
			messages.append("Erroneously retrieved null for SecureTableInfoService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tableInfoResults.size() + " entities from Secure.TableInfo\n");
		}

		List<?> iSOCcyResults = secureISOCcyService.findAll();
		if (iSOCcyResults == null) {
			messages.append("Erroneously retrieved null for SecureISOCcyService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOCcyResults.size() + " entities from Secure.ISOCcy\n");
		}

		List<?> iSOCtryResults = secureISOCtryService.findAll();
		if (iSOCtryResults == null) {
			messages.append("Erroneously retrieved null for SecureISOCtryService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryResults.size() + " entities from Secure.ISOCtry\n");
		}

		List<?> iSOCtryCcyResults = secureISOCtryCcyService.findAll();
		if (iSOCtryCcyResults == null) {
			messages.append("Erroneously retrieved null for SecureISOCtryCcyService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryCcyResults.size() + " entities from Secure.ISOCtryCcy\n");
		}

		List<?> iSOCtryLangResults = secureISOCtryLangService.findAll();
		if (iSOCtryLangResults == null) {
			messages.append("Erroneously retrieved null for SecureISOCtryLangService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryLangResults.size() + " entities from Secure.ISOCtryLang\n");
		}

		List<?> iSOLangResults = secureISOLangService.findAll();
		if (iSOLangResults == null) {
			messages.append("Erroneously retrieved null for SecureISOLangService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOLangResults.size() + " entities from Secure.ISOLang\n");
		}

		List<?> iSOTZoneResults = secureISOTZoneService.findAll();
		if (iSOTZoneResults == null) {
			messages.append("Erroneously retrieved null for SecureISOTZoneService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + iSOTZoneResults.size() + " entities from Secure.ISOTZone\n");
		}

		List<?> secUserResults = secureSecUserService.findAll();
		if (secUserResults == null) {
			messages.append("Erroneously retrieved null for SecureSecUserService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserResults.size() + " entities from Secure.SecUser\n");
		}

		List<?> secUserPasswordResults = secureSecUserPasswordService.findAll();
		if (secUserPasswordResults == null) {
			messages.append("Erroneously retrieved null for SecureSecUserPasswordService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserPasswordResults.size() + " entities from Secure.SecUserPassword\n");
		}

		List<?> secUserEMConfResults = secureSecUserEMConfService.findAll();
		if (secUserEMConfResults == null) {
			messages.append("Erroneously retrieved null for SecureSecUserEMConfService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserEMConfResults.size() + " entities from Secure.SecUserEMConf\n");
		}

		List<?> secUserPWResetResults = secureSecUserPWResetService.findAll();
		if (secUserPWResetResults == null) {
			messages.append("Erroneously retrieved null for SecureSecUserPWResetService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserPWResetResults.size() + " entities from Secure.SecUserPWReset\n");
		}

		List<?> secUserPWHistoryResults = secureSecUserPWHistoryService.findAll();
		if (secUserPWHistoryResults == null) {
			messages.append("Erroneously retrieved null for SecureSecUserPWHistoryService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secUserPWHistoryResults.size() + " entities from Secure.SecUserPWHistory\n");
		}

		List<?> secSysGrpResults = secureSecSysGrpService.findAll();
		if (secSysGrpResults == null) {
			messages.append("Erroneously retrieved null for SecureSecSysGrpService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSysGrpResults.size() + " entities from Secure.SecSysGrp\n");
		}

		List<?> secSysGrpIncResults = secureSecSysGrpIncService.findAll();
		if (secSysGrpIncResults == null) {
			messages.append("Erroneously retrieved null for SecureSecSysGrpIncService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSysGrpIncResults.size() + " entities from Secure.SecSysGrpInc\n");
		}

		List<?> secSysGrpMembResults = secureSecSysGrpMembService.findAll();
		if (secSysGrpMembResults == null) {
			messages.append("Erroneously retrieved null for SecureSecSysGrpMembService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSysGrpMembResults.size() + " entities from Secure.SecSysGrpMemb\n");
		}

		List<?> secClusGrpResults = secureSecClusGrpService.findAll();
		if (secClusGrpResults == null) {
			messages.append("Erroneously retrieved null for SecureSecClusGrpService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secClusGrpResults.size() + " entities from Secure.SecClusGrp\n");
		}

		List<?> secClusGrpMembResults = secureSecClusGrpMembService.findAll();
		if (secClusGrpMembResults == null) {
			messages.append("Erroneously retrieved null for SecureSecClusGrpMembService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secClusGrpMembResults.size() + " entities from Secure.SecClusGrpMemb\n");
		}

		List<?> secTentGrpResults = secureSecTentGrpService.findAll();
		if (secTentGrpResults == null) {
			messages.append("Erroneously retrieved null for SecureSecTentGrpService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secTentGrpResults.size() + " entities from Secure.SecTentGrp\n");
		}

		List<?> secTentGrpMembResults = secureSecTentGrpMembService.findAll();
		if (secTentGrpMembResults == null) {
			messages.append("Erroneously retrieved null for SecureSecTentGrpMembService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secTentGrpMembResults.size() + " entities from Secure.SecTentGrpMemb\n");
		}

		List<?> secSysRoleResults = secureSecSysRoleService.findAll();
		if (secSysRoleResults == null) {
			messages.append("Erroneously retrieved null for SecureSecSysRoleService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSysRoleResults.size() + " entities from Secure.SecSysRole\n");
		}

		List<?> secSysRoleEnablesResults = secureSecSysRoleEnablesService.findAll();
		if (secSysRoleEnablesResults == null) {
			messages.append("Erroneously retrieved null for SecureSecSysRoleEnablesService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSysRoleEnablesResults.size() + " entities from Secure.SecSysRoleEnables\n");
		}

		List<?> secSysRoleMembResults = secureSecSysRoleMembService.findAll();
		if (secSysRoleMembResults == null) {
			messages.append("Erroneously retrieved null for SecureSecSysRoleMembService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSysRoleMembResults.size() + " entities from Secure.SecSysRoleMemb\n");
		}

		List<?> secClusRoleResults = secureSecClusRoleService.findAll();
		if (secClusRoleResults == null) {
			messages.append("Erroneously retrieved null for SecureSecClusRoleService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secClusRoleResults.size() + " entities from Secure.SecClusRole\n");
		}

		List<?> secClusRoleMembResults = secureSecClusRoleMembService.findAll();
		if (secClusRoleMembResults == null) {
			messages.append("Erroneously retrieved null for SecureSecClusRoleMembService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secClusRoleMembResults.size() + " entities from Secure.SecClusRoleMemb\n");
		}

		List<?> secTentRoleResults = secureSecTentRoleService.findAll();
		if (secTentRoleResults == null) {
			messages.append("Erroneously retrieved null for SecureSecTentRoleService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secTentRoleResults.size() + " entities from Secure.SecTentRole\n");
		}

		List<?> secTentRoleMembResults = secureSecTentRoleMembService.findAll();
		if (secTentRoleMembResults == null) {
			messages.append("Erroneously retrieved null for SecureSecTentRoleMembService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secTentRoleMembResults.size() + " entities from Secure.SecTentRoleMemb\n");
		}

		List<?> secSessionResults = secureSecSessionService.findAll();
		if (secSessionResults == null) {
			messages.append("Erroneously retrieved null for SecureSecSessionService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + secSessionResults.size() + " entities from Secure.SecSession\n");
		}

		List<?> sysClusterResults = secureSysClusterService.findAll();
		if (sysClusterResults == null) {
			messages.append("Erroneously retrieved null for SecureSysClusterService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + sysClusterResults.size() + " entities from Secure.SysCluster\n");
		}

		messages.append("Secure tests complete\n");
		return( messages.toString() );
	}
}
