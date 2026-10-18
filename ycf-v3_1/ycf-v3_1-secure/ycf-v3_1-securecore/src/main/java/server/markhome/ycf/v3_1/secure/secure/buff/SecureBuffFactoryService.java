// Description: Java 25 buffer implementation of a Secure factory service.

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

package server.markhome.ycf.v3_1.secure.secure.buff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

@Service("secure31BuffFactoryService")
public class SecureBuffFactoryService
	implements ISecureFactory
{

	@Autowired
	@Qualifier("secure31BuffClusterFactoryService")
	protected SecureBuffClusterFactoryService clusterFactoryService;

	@Autowired
	@Qualifier("secure31BuffISOCcyFactoryService")
	protected SecureBuffISOCcyFactoryService isoccyFactoryService;

	@Autowired
	@Qualifier("secure31BuffISOCtryFactoryService")
	protected SecureBuffISOCtryFactoryService isoctryFactoryService;

	@Autowired
	@Qualifier("secure31BuffISOCtryCcyFactoryService")
	protected SecureBuffISOCtryCcyFactoryService isoctryccyFactoryService;

	@Autowired
	@Qualifier("secure31BuffISOCtryLangFactoryService")
	protected SecureBuffISOCtryLangFactoryService isoctrylangFactoryService;

	@Autowired
	@Qualifier("secure31BuffISOLangFactoryService")
	protected SecureBuffISOLangFactoryService isolangFactoryService;

	@Autowired
	@Qualifier("secure31BuffISOTZoneFactoryService")
	protected SecureBuffISOTZoneFactoryService isotzoneFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecClusGrpFactoryService")
	protected SecureBuffSecClusGrpFactoryService secclusgrpFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecClusGrpMembFactoryService")
	protected SecureBuffSecClusGrpMembFactoryService secclusgrpmembFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecClusRoleFactoryService")
	protected SecureBuffSecClusRoleFactoryService secclusroleFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecClusRoleMembFactoryService")
	protected SecureBuffSecClusRoleMembFactoryService secclusrolemembFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecSessionFactoryService")
	protected SecureBuffSecSessionFactoryService secsessionFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecSysGrpFactoryService")
	protected SecureBuffSecSysGrpFactoryService secsysgrpFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecSysGrpIncFactoryService")
	protected SecureBuffSecSysGrpIncFactoryService secsysgrpincFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecSysGrpMembFactoryService")
	protected SecureBuffSecSysGrpMembFactoryService secsysgrpmembFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecSysRoleFactoryService")
	protected SecureBuffSecSysRoleFactoryService secsysroleFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecSysRoleEnablesFactoryService")
	protected SecureBuffSecSysRoleEnablesFactoryService secsysroleenablesFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecSysRoleMembFactoryService")
	protected SecureBuffSecSysRoleMembFactoryService secsysrolemembFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecTentGrpFactoryService")
	protected SecureBuffSecTentGrpFactoryService sectentgrpFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecTentGrpMembFactoryService")
	protected SecureBuffSecTentGrpMembFactoryService sectentgrpmembFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecTentRoleFactoryService")
	protected SecureBuffSecTentRoleFactoryService sectentroleFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecTentRoleMembFactoryService")
	protected SecureBuffSecTentRoleMembFactoryService sectentrolemembFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecUserFactoryService")
	protected SecureBuffSecUserFactoryService secuserFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecUserEMConfFactoryService")
	protected SecureBuffSecUserEMConfFactoryService secuseremconfFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecUserPWHistoryFactoryService")
	protected SecureBuffSecUserPWHistoryFactoryService secuserpwhistoryFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecUserPWResetFactoryService")
	protected SecureBuffSecUserPWResetFactoryService secuserpwresetFactoryService;

	@Autowired
	@Qualifier("secure31BuffSecUserPasswordFactoryService")
	protected SecureBuffSecUserPasswordFactoryService secuserpasswordFactoryService;

	@Autowired
	@Qualifier("secure31BuffSysClusterFactoryService")
	protected SecureBuffSysClusterFactoryService sysclusterFactoryService;

	@Autowired
	@Qualifier("secure31BuffTableInfoFactoryService")
	protected SecureBuffTableInfoFactoryService tableinfoFactoryService;

	@Autowired
	@Qualifier("secure31BuffTenantFactoryService")
	protected SecureBuffTenantFactoryService tenantFactoryService;


	public SecureBuffFactoryService() { }

	@Override
	public ISecureClusterFactory getFactoryCluster() {
		return(clusterFactoryService);
	}

	public SecureBuffClusterFactoryService getClusterFactoryService() {
		return(clusterFactoryService);
	}

	@Override
	public ISecureISOCcyFactory getFactoryISOCcy() {
		return(isoccyFactoryService);
	}

	public SecureBuffISOCcyFactoryService getISOCcyFactoryService() {
		return(isoccyFactoryService);
	}

	@Override
	public ISecureISOCtryFactory getFactoryISOCtry() {
		return(isoctryFactoryService);
	}

	public SecureBuffISOCtryFactoryService getISOCtryFactoryService() {
		return(isoctryFactoryService);
	}

	@Override
	public ISecureISOCtryCcyFactory getFactoryISOCtryCcy() {
		return(isoctryccyFactoryService);
	}

	public SecureBuffISOCtryCcyFactoryService getISOCtryCcyFactoryService() {
		return(isoctryccyFactoryService);
	}

	@Override
	public ISecureISOCtryLangFactory getFactoryISOCtryLang() {
		return(isoctrylangFactoryService);
	}

	public SecureBuffISOCtryLangFactoryService getISOCtryLangFactoryService() {
		return(isoctrylangFactoryService);
	}

	@Override
	public ISecureISOLangFactory getFactoryISOLang() {
		return(isolangFactoryService);
	}

	public SecureBuffISOLangFactoryService getISOLangFactoryService() {
		return(isolangFactoryService);
	}

	@Override
	public ISecureISOTZoneFactory getFactoryISOTZone() {
		return(isotzoneFactoryService);
	}

	public SecureBuffISOTZoneFactoryService getISOTZoneFactoryService() {
		return(isotzoneFactoryService);
	}

	@Override
	public ISecureSecClusGrpFactory getFactorySecClusGrp() {
		return(secclusgrpFactoryService);
	}

	public SecureBuffSecClusGrpFactoryService getSecClusGrpFactoryService() {
		return(secclusgrpFactoryService);
	}

	@Override
	public ISecureSecClusGrpMembFactory getFactorySecClusGrpMemb() {
		return(secclusgrpmembFactoryService);
	}

	public SecureBuffSecClusGrpMembFactoryService getSecClusGrpMembFactoryService() {
		return(secclusgrpmembFactoryService);
	}

	@Override
	public ISecureSecClusRoleFactory getFactorySecClusRole() {
		return(secclusroleFactoryService);
	}

	public SecureBuffSecClusRoleFactoryService getSecClusRoleFactoryService() {
		return(secclusroleFactoryService);
	}

	@Override
	public ISecureSecClusRoleMembFactory getFactorySecClusRoleMemb() {
		return(secclusrolemembFactoryService);
	}

	public SecureBuffSecClusRoleMembFactoryService getSecClusRoleMembFactoryService() {
		return(secclusrolemembFactoryService);
	}

	@Override
	public ISecureSecSessionFactory getFactorySecSession() {
		return(secsessionFactoryService);
	}

	public SecureBuffSecSessionFactoryService getSecSessionFactoryService() {
		return(secsessionFactoryService);
	}

	@Override
	public ISecureSecSysGrpFactory getFactorySecSysGrp() {
		return(secsysgrpFactoryService);
	}

	public SecureBuffSecSysGrpFactoryService getSecSysGrpFactoryService() {
		return(secsysgrpFactoryService);
	}

	@Override
	public ISecureSecSysGrpIncFactory getFactorySecSysGrpInc() {
		return(secsysgrpincFactoryService);
	}

	public SecureBuffSecSysGrpIncFactoryService getSecSysGrpIncFactoryService() {
		return(secsysgrpincFactoryService);
	}

	@Override
	public ISecureSecSysGrpMembFactory getFactorySecSysGrpMemb() {
		return(secsysgrpmembFactoryService);
	}

	public SecureBuffSecSysGrpMembFactoryService getSecSysGrpMembFactoryService() {
		return(secsysgrpmembFactoryService);
	}

	@Override
	public ISecureSecSysRoleFactory getFactorySecSysRole() {
		return(secsysroleFactoryService);
	}

	public SecureBuffSecSysRoleFactoryService getSecSysRoleFactoryService() {
		return(secsysroleFactoryService);
	}

	@Override
	public ISecureSecSysRoleEnablesFactory getFactorySecSysRoleEnables() {
		return(secsysroleenablesFactoryService);
	}

	public SecureBuffSecSysRoleEnablesFactoryService getSecSysRoleEnablesFactoryService() {
		return(secsysroleenablesFactoryService);
	}

	@Override
	public ISecureSecSysRoleMembFactory getFactorySecSysRoleMemb() {
		return(secsysrolemembFactoryService);
	}

	public SecureBuffSecSysRoleMembFactoryService getSecSysRoleMembFactoryService() {
		return(secsysrolemembFactoryService);
	}

	@Override
	public ISecureSecTentGrpFactory getFactorySecTentGrp() {
		return(sectentgrpFactoryService);
	}

	public SecureBuffSecTentGrpFactoryService getSecTentGrpFactoryService() {
		return(sectentgrpFactoryService);
	}

	@Override
	public ISecureSecTentGrpMembFactory getFactorySecTentGrpMemb() {
		return(sectentgrpmembFactoryService);
	}

	public SecureBuffSecTentGrpMembFactoryService getSecTentGrpMembFactoryService() {
		return(sectentgrpmembFactoryService);
	}

	@Override
	public ISecureSecTentRoleFactory getFactorySecTentRole() {
		return(sectentroleFactoryService);
	}

	public SecureBuffSecTentRoleFactoryService getSecTentRoleFactoryService() {
		return(sectentroleFactoryService);
	}

	@Override
	public ISecureSecTentRoleMembFactory getFactorySecTentRoleMemb() {
		return(sectentrolemembFactoryService);
	}

	public SecureBuffSecTentRoleMembFactoryService getSecTentRoleMembFactoryService() {
		return(sectentrolemembFactoryService);
	}

	@Override
	public ISecureSecUserFactory getFactorySecUser() {
		return(secuserFactoryService);
	}

	public SecureBuffSecUserFactoryService getSecUserFactoryService() {
		return(secuserFactoryService);
	}

	@Override
	public ISecureSecUserEMConfFactory getFactorySecUserEMConf() {
		return(secuseremconfFactoryService);
	}

	public SecureBuffSecUserEMConfFactoryService getSecUserEMConfFactoryService() {
		return(secuseremconfFactoryService);
	}

	@Override
	public ISecureSecUserPWHistoryFactory getFactorySecUserPWHistory() {
		return(secuserpwhistoryFactoryService);
	}

	public SecureBuffSecUserPWHistoryFactoryService getSecUserPWHistoryFactoryService() {
		return(secuserpwhistoryFactoryService);
	}

	@Override
	public ISecureSecUserPWResetFactory getFactorySecUserPWReset() {
		return(secuserpwresetFactoryService);
	}

	public SecureBuffSecUserPWResetFactoryService getSecUserPWResetFactoryService() {
		return(secuserpwresetFactoryService);
	}

	@Override
	public ISecureSecUserPasswordFactory getFactorySecUserPassword() {
		return(secuserpasswordFactoryService);
	}

	public SecureBuffSecUserPasswordFactoryService getSecUserPasswordFactoryService() {
		return(secuserpasswordFactoryService);
	}

	@Override
	public ISecureSysClusterFactory getFactorySysCluster() {
		return(sysclusterFactoryService);
	}

	public SecureBuffSysClusterFactoryService getSysClusterFactoryService() {
		return(sysclusterFactoryService);
	}

	@Override
	public ISecureTableInfoFactory getFactoryTableInfo() {
		return(tableinfoFactoryService);
	}

	public SecureBuffTableInfoFactoryService getTableInfoFactoryService() {
		return(tableinfoFactoryService);
	}

	@Override
	public ISecureTenantFactory getFactoryTenant() {
		return(tenantFactoryService);
	}

	public SecureBuffTenantFactoryService getTenantFactoryService() {
		return(tenantFactoryService);
	}

}
