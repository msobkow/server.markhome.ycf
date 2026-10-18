// Description: Java 25 Schema Object interface for Secure.

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

package server.markhome.ycf.v3_1.secure.secureobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

public interface ISecureSchemaObj
{
	ISecureAuthorization getAuthorization();
	void setAuthorization( ISecureAuthorization value );

	String getSchemaName();

	void setSecClusterName( String value );
	ISecureClusterObj getSecCluster();
	void setSecCluster( ISecureClusterObj value );

	void setSecTenantName( String value );
	ISecureTenantObj getSecTenant();
	void setSecTenant( ISecureTenantObj value );

	void setSecUserName( String value );
	ISecureSecUserObj getSecUser();
	void setSecUser( ISecureSecUserObj value );

	void setSecSessionId( YCFDbKeyHash256 value );
	ISecureSecSessionObj getSecSession();
	void setSecSession( ISecureSecSessionObj value );

	void logout();

	void minimizeMemory();

	public ISecureSchema getSecureBackingStore();
	public void setSecureBackingStore(ISecureSchema secureBackingStore);

	/**
	 *	Get the Cluster interface for the schema.
	 *
	 *	@return	The ISecureClusterTableObj interface implementation for the schema.
	 */
	ISecureClusterTableObj getClusterTableObj();

	/**
	 *	Get the ISOCcy interface for the schema.
	 *
	 *	@return	The ISecureISOCcyTableObj interface implementation for the schema.
	 */
	ISecureISOCcyTableObj getISOCcyTableObj();

	/**
	 *	Get the ISOCtry interface for the schema.
	 *
	 *	@return	The ISecureISOCtryTableObj interface implementation for the schema.
	 */
	ISecureISOCtryTableObj getISOCtryTableObj();

	/**
	 *	Get the ISOCtryCcy interface for the schema.
	 *
	 *	@return	The ISecureISOCtryCcyTableObj interface implementation for the schema.
	 */
	ISecureISOCtryCcyTableObj getISOCtryCcyTableObj();

	/**
	 *	Get the ISOCtryLang interface for the schema.
	 *
	 *	@return	The ISecureISOCtryLangTableObj interface implementation for the schema.
	 */
	ISecureISOCtryLangTableObj getISOCtryLangTableObj();

	/**
	 *	Get the ISOLang interface for the schema.
	 *
	 *	@return	The ISecureISOLangTableObj interface implementation for the schema.
	 */
	ISecureISOLangTableObj getISOLangTableObj();

	/**
	 *	Get the ISOTZone interface for the schema.
	 *
	 *	@return	The ISecureISOTZoneTableObj interface implementation for the schema.
	 */
	ISecureISOTZoneTableObj getISOTZoneTableObj();

	/**
	 *	Get the SecClusGrp interface for the schema.
	 *
	 *	@return	The ISecureSecClusGrpTableObj interface implementation for the schema.
	 */
	ISecureSecClusGrpTableObj getSecClusGrpTableObj();

	/**
	 *	Get the SecClusGrpMemb interface for the schema.
	 *
	 *	@return	The ISecureSecClusGrpMembTableObj interface implementation for the schema.
	 */
	ISecureSecClusGrpMembTableObj getSecClusGrpMembTableObj();

	/**
	 *	Get the SecClusRole interface for the schema.
	 *
	 *	@return	The ISecureSecClusRoleTableObj interface implementation for the schema.
	 */
	ISecureSecClusRoleTableObj getSecClusRoleTableObj();

	/**
	 *	Get the SecClusRoleMemb interface for the schema.
	 *
	 *	@return	The ISecureSecClusRoleMembTableObj interface implementation for the schema.
	 */
	ISecureSecClusRoleMembTableObj getSecClusRoleMembTableObj();

	/**
	 *	Get the SecSession interface for the schema.
	 *
	 *	@return	The ISecureSecSessionTableObj interface implementation for the schema.
	 */
	ISecureSecSessionTableObj getSecSessionTableObj();

	/**
	 *	Get the SecSysGrp interface for the schema.
	 *
	 *	@return	The ISecureSecSysGrpTableObj interface implementation for the schema.
	 */
	ISecureSecSysGrpTableObj getSecSysGrpTableObj();

	/**
	 *	Get the SecSysGrpInc interface for the schema.
	 *
	 *	@return	The ISecureSecSysGrpIncTableObj interface implementation for the schema.
	 */
	ISecureSecSysGrpIncTableObj getSecSysGrpIncTableObj();

	/**
	 *	Get the SecSysGrpMemb interface for the schema.
	 *
	 *	@return	The ISecureSecSysGrpMembTableObj interface implementation for the schema.
	 */
	ISecureSecSysGrpMembTableObj getSecSysGrpMembTableObj();

	/**
	 *	Get the SecSysRole interface for the schema.
	 *
	 *	@return	The ISecureSecSysRoleTableObj interface implementation for the schema.
	 */
	ISecureSecSysRoleTableObj getSecSysRoleTableObj();

	/**
	 *	Get the SecSysRoleEnables interface for the schema.
	 *
	 *	@return	The ISecureSecSysRoleEnablesTableObj interface implementation for the schema.
	 */
	ISecureSecSysRoleEnablesTableObj getSecSysRoleEnablesTableObj();

	/**
	 *	Get the SecSysRoleMemb interface for the schema.
	 *
	 *	@return	The ISecureSecSysRoleMembTableObj interface implementation for the schema.
	 */
	ISecureSecSysRoleMembTableObj getSecSysRoleMembTableObj();

	/**
	 *	Get the SecTentGrp interface for the schema.
	 *
	 *	@return	The ISecureSecTentGrpTableObj interface implementation for the schema.
	 */
	ISecureSecTentGrpTableObj getSecTentGrpTableObj();

	/**
	 *	Get the SecTentGrpMemb interface for the schema.
	 *
	 *	@return	The ISecureSecTentGrpMembTableObj interface implementation for the schema.
	 */
	ISecureSecTentGrpMembTableObj getSecTentGrpMembTableObj();

	/**
	 *	Get the SecTentRole interface for the schema.
	 *
	 *	@return	The ISecureSecTentRoleTableObj interface implementation for the schema.
	 */
	ISecureSecTentRoleTableObj getSecTentRoleTableObj();

	/**
	 *	Get the SecTentRoleMemb interface for the schema.
	 *
	 *	@return	The ISecureSecTentRoleMembTableObj interface implementation for the schema.
	 */
	ISecureSecTentRoleMembTableObj getSecTentRoleMembTableObj();

	/**
	 *	Get the SecUser interface for the schema.
	 *
	 *	@return	The ISecureSecUserTableObj interface implementation for the schema.
	 */
	ISecureSecUserTableObj getSecUserTableObj();

	/**
	 *	Get the SecUserEMConf interface for the schema.
	 *
	 *	@return	The ISecureSecUserEMConfTableObj interface implementation for the schema.
	 */
	ISecureSecUserEMConfTableObj getSecUserEMConfTableObj();

	/**
	 *	Get the SecUserPWHistory interface for the schema.
	 *
	 *	@return	The ISecureSecUserPWHistoryTableObj interface implementation for the schema.
	 */
	ISecureSecUserPWHistoryTableObj getSecUserPWHistoryTableObj();

	/**
	 *	Get the SecUserPWReset interface for the schema.
	 *
	 *	@return	The ISecureSecUserPWResetTableObj interface implementation for the schema.
	 */
	ISecureSecUserPWResetTableObj getSecUserPWResetTableObj();

	/**
	 *	Get the SecUserPassword interface for the schema.
	 *
	 *	@return	The ISecureSecUserPasswordTableObj interface implementation for the schema.
	 */
	ISecureSecUserPasswordTableObj getSecUserPasswordTableObj();

	/**
	 *	Get the SysCluster interface for the schema.
	 *
	 *	@return	The ISecureSysClusterTableObj interface implementation for the schema.
	 */
	ISecureSysClusterTableObj getSysClusterTableObj();

	/**
	 *	Get the TableInfo interface for the schema.
	 *
	 *	@return	The ISecureTableInfoTableObj interface implementation for the schema.
	 */
	ISecureTableInfoTableObj getTableInfoTableObj();

	/**
	 *	Get the Tenant interface for the schema.
	 *
	 *	@return	The ISecureTenantTableObj interface implementation for the schema.
	 */
	ISecureTenantTableObj getTenantTableObj();
}
