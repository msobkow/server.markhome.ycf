// Description: Java 25 interface for a Secure data object factory.

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

package server.markhome.ycf.v3_1.secure.secure;

public interface ISecureFactory
{
	/**
	 *	Get the Cluster Factory interface for the schema.
	 *
	 *	@return	The Cluster Factory interface for the schema.
	 */
	public ISecureClusterFactory getFactoryCluster();

	/**
	 *	Get the ISOCcy Factory interface for the schema.
	 *
	 *	@return	The ISOCcy Factory interface for the schema.
	 */
	public ISecureISOCcyFactory getFactoryISOCcy();

	/**
	 *	Get the ISOCtry Factory interface for the schema.
	 *
	 *	@return	The ISOCtry Factory interface for the schema.
	 */
	public ISecureISOCtryFactory getFactoryISOCtry();

	/**
	 *	Get the ISOCtryCcy Factory interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Factory interface for the schema.
	 */
	public ISecureISOCtryCcyFactory getFactoryISOCtryCcy();

	/**
	 *	Get the ISOCtryLang Factory interface for the schema.
	 *
	 *	@return	The ISOCtryLang Factory interface for the schema.
	 */
	public ISecureISOCtryLangFactory getFactoryISOCtryLang();

	/**
	 *	Get the ISOLang Factory interface for the schema.
	 *
	 *	@return	The ISOLang Factory interface for the schema.
	 */
	public ISecureISOLangFactory getFactoryISOLang();

	/**
	 *	Get the ISOTZone Factory interface for the schema.
	 *
	 *	@return	The ISOTZone Factory interface for the schema.
	 */
	public ISecureISOTZoneFactory getFactoryISOTZone();

	/**
	 *	Get the SecClusGrp Factory interface for the schema.
	 *
	 *	@return	The SecClusGrp Factory interface for the schema.
	 */
	public ISecureSecClusGrpFactory getFactorySecClusGrp();

	/**
	 *	Get the SecClusGrpMemb Factory interface for the schema.
	 *
	 *	@return	The SecClusGrpMemb Factory interface for the schema.
	 */
	public ISecureSecClusGrpMembFactory getFactorySecClusGrpMemb();

	/**
	 *	Get the SecClusRole Factory interface for the schema.
	 *
	 *	@return	The SecClusRole Factory interface for the schema.
	 */
	public ISecureSecClusRoleFactory getFactorySecClusRole();

	/**
	 *	Get the SecClusRoleMemb Factory interface for the schema.
	 *
	 *	@return	The SecClusRoleMemb Factory interface for the schema.
	 */
	public ISecureSecClusRoleMembFactory getFactorySecClusRoleMemb();

	/**
	 *	Get the SecSession Factory interface for the schema.
	 *
	 *	@return	The SecSession Factory interface for the schema.
	 */
	public ISecureSecSessionFactory getFactorySecSession();

	/**
	 *	Get the SecSysGrp Factory interface for the schema.
	 *
	 *	@return	The SecSysGrp Factory interface for the schema.
	 */
	public ISecureSecSysGrpFactory getFactorySecSysGrp();

	/**
	 *	Get the SecSysGrpInc Factory interface for the schema.
	 *
	 *	@return	The SecSysGrpInc Factory interface for the schema.
	 */
	public ISecureSecSysGrpIncFactory getFactorySecSysGrpInc();

	/**
	 *	Get the SecSysGrpMemb Factory interface for the schema.
	 *
	 *	@return	The SecSysGrpMemb Factory interface for the schema.
	 */
	public ISecureSecSysGrpMembFactory getFactorySecSysGrpMemb();

	/**
	 *	Get the SecSysRole Factory interface for the schema.
	 *
	 *	@return	The SecSysRole Factory interface for the schema.
	 */
	public ISecureSecSysRoleFactory getFactorySecSysRole();

	/**
	 *	Get the SecSysRoleEnables Factory interface for the schema.
	 *
	 *	@return	The SecSysRoleEnables Factory interface for the schema.
	 */
	public ISecureSecSysRoleEnablesFactory getFactorySecSysRoleEnables();

	/**
	 *	Get the SecSysRoleMemb Factory interface for the schema.
	 *
	 *	@return	The SecSysRoleMemb Factory interface for the schema.
	 */
	public ISecureSecSysRoleMembFactory getFactorySecSysRoleMemb();

	/**
	 *	Get the SecTentGrp Factory interface for the schema.
	 *
	 *	@return	The SecTentGrp Factory interface for the schema.
	 */
	public ISecureSecTentGrpFactory getFactorySecTentGrp();

	/**
	 *	Get the SecTentGrpMemb Factory interface for the schema.
	 *
	 *	@return	The SecTentGrpMemb Factory interface for the schema.
	 */
	public ISecureSecTentGrpMembFactory getFactorySecTentGrpMemb();

	/**
	 *	Get the SecTentRole Factory interface for the schema.
	 *
	 *	@return	The SecTentRole Factory interface for the schema.
	 */
	public ISecureSecTentRoleFactory getFactorySecTentRole();

	/**
	 *	Get the SecTentRoleMemb Factory interface for the schema.
	 *
	 *	@return	The SecTentRoleMemb Factory interface for the schema.
	 */
	public ISecureSecTentRoleMembFactory getFactorySecTentRoleMemb();

	/**
	 *	Get the SecUser Factory interface for the schema.
	 *
	 *	@return	The SecUser Factory interface for the schema.
	 */
	public ISecureSecUserFactory getFactorySecUser();

	/**
	 *	Get the SecUserEMConf Factory interface for the schema.
	 *
	 *	@return	The SecUserEMConf Factory interface for the schema.
	 */
	public ISecureSecUserEMConfFactory getFactorySecUserEMConf();

	/**
	 *	Get the SecUserPWHistory Factory interface for the schema.
	 *
	 *	@return	The SecUserPWHistory Factory interface for the schema.
	 */
	public ISecureSecUserPWHistoryFactory getFactorySecUserPWHistory();

	/**
	 *	Get the SecUserPWReset Factory interface for the schema.
	 *
	 *	@return	The SecUserPWReset Factory interface for the schema.
	 */
	public ISecureSecUserPWResetFactory getFactorySecUserPWReset();

	/**
	 *	Get the SecUserPassword Factory interface for the schema.
	 *
	 *	@return	The SecUserPassword Factory interface for the schema.
	 */
	public ISecureSecUserPasswordFactory getFactorySecUserPassword();

	/**
	 *	Get the SysCluster Factory interface for the schema.
	 *
	 *	@return	The SysCluster Factory interface for the schema.
	 */
	public ISecureSysClusterFactory getFactorySysCluster();

	/**
	 *	Get the TableInfo Factory interface for the schema.
	 *
	 *	@return	The TableInfo Factory interface for the schema.
	 */
	public ISecureTableInfoFactory getFactoryTableInfo();

	/**
	 *	Get the Tenant Factory interface for the schema.
	 *
	 *	@return	The Tenant Factory interface for the schema.
	 */
	public ISecureTenantFactory getFactoryTenant();

}
