// Description: Java 25 Public Schema Object interface for SecurePub.

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

package server.markhome.ycf.v3_1.secure.securepubobj;

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

public interface ISecurePubSchemaObj
{
	ISecurePubAuthorization getAuthorization();
	void setAuthorization( ISecurePubAuthorization value );

	String getSchemaName();

	void setSecClusterName( String value );
	ISecurePubClusterObj getSecCluster();
	void setSecCluster( ISecurePubClusterObj value );

	void setSecTenantName( String value );
	ISecurePubTenantObj getSecTenant();
	void setSecTenant( ISecurePubTenantObj value );

	void setSecUserName( String value );
	ISecurePubSecUserObj getSecUser();
	void setSecUser( ISecurePubSecUserObj value );

	void setSecSessionId( YCFDbKeyHash256 value );
	ISecurePubSecSessionObj getSecSession();
	void setSecSession( ISecurePubSecSessionObj value );

	void logout();

	void minimizeMemory();

	public ISecurePubSchema getSecurePubBackingStore();
	public void setSecurePubBackingStore(ISecurePubSchema securepubBackingStore);

	/**
	 *	Get the Cluster interface for the schema.
	 *
	 *	@return	The ISecurePubClusterTableObj interface implementation for the schema.
	 */
	ISecurePubClusterTableObj getClusterTableObj();

	/**
	 *	Get the ISOCcy interface for the schema.
	 *
	 *	@return	The ISecurePubISOCcyTableObj interface implementation for the schema.
	 */
	ISecurePubISOCcyTableObj getISOCcyTableObj();

	/**
	 *	Get the ISOCtry interface for the schema.
	 *
	 *	@return	The ISecurePubISOCtryTableObj interface implementation for the schema.
	 */
	ISecurePubISOCtryTableObj getISOCtryTableObj();

	/**
	 *	Get the ISOCtryCcy interface for the schema.
	 *
	 *	@return	The ISecurePubISOCtryCcyTableObj interface implementation for the schema.
	 */
	ISecurePubISOCtryCcyTableObj getISOCtryCcyTableObj();

	/**
	 *	Get the ISOCtryLang interface for the schema.
	 *
	 *	@return	The ISecurePubISOCtryLangTableObj interface implementation for the schema.
	 */
	ISecurePubISOCtryLangTableObj getISOCtryLangTableObj();

	/**
	 *	Get the ISOLang interface for the schema.
	 *
	 *	@return	The ISecurePubISOLangTableObj interface implementation for the schema.
	 */
	ISecurePubISOLangTableObj getISOLangTableObj();

	/**
	 *	Get the ISOTZone interface for the schema.
	 *
	 *	@return	The ISecurePubISOTZoneTableObj interface implementation for the schema.
	 */
	ISecurePubISOTZoneTableObj getISOTZoneTableObj();

	/**
	 *	Get the SecSession interface for the schema.
	 *
	 *	@return	The ISecurePubSecSessionTableObj interface implementation for the schema.
	 */
	ISecurePubSecSessionTableObj getSecSessionTableObj();

	/**
	 *	Get the SecSysGrp interface for the schema.
	 *
	 *	@return	The ISecurePubSecSysGrpTableObj interface implementation for the schema.
	 */
	ISecurePubSecSysGrpTableObj getSecSysGrpTableObj();

	/**
	 *	Get the SecSysRole interface for the schema.
	 *
	 *	@return	The ISecurePubSecSysRoleTableObj interface implementation for the schema.
	 */
	ISecurePubSecSysRoleTableObj getSecSysRoleTableObj();

	/**
	 *	Get the SecUser interface for the schema.
	 *
	 *	@return	The ISecurePubSecUserTableObj interface implementation for the schema.
	 */
	ISecurePubSecUserTableObj getSecUserTableObj();

	/**
	 *	Get the SysCluster interface for the schema.
	 *
	 *	@return	The ISecurePubSysClusterTableObj interface implementation for the schema.
	 */
	ISecurePubSysClusterTableObj getSysClusterTableObj();

	/**
	 *	Get the TableInfo interface for the schema.
	 *
	 *	@return	The ISecurePubTableInfoTableObj interface implementation for the schema.
	 */
	ISecurePubTableInfoTableObj getTableInfoTableObj();

	/**
	 *	Get the Tenant interface for the schema.
	 *
	 *	@return	The ISecurePubTenantTableObj interface implementation for the schema.
	 */
	ISecurePubTenantTableObj getTenantTableObj();
}
