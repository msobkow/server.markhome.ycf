// Description: Java 25 Secure Table Permissions Interface.

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

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;


public interface ISecureTablePerms
{
	/**
	 *	Is the session allowed to create Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateCluster( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadCluster( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateCluster( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteCluster( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOCcy instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOCcy( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOCcy instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOCcy( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOCcy instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOCcy( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOCcy instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOCcy( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOCtry instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOCtry( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOCtry instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOCtry( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOCtry instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOCtry( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOCtry instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOCtry( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOCtryCcy instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOCtryCcy( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOCtryCcy instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOCtryCcy( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOCtryCcy instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOCtryCcy( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOCtryCcy instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOCtryCcy( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOCtryLang instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOCtryLang( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOCtryLang instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOCtryLang( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOCtryLang instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOCtryLang( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOCtryLang instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOCtryLang( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOLang instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOLang( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOLang instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOLang( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOLang instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOLang( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOLang instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOLang( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ISOTZone instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateISOTZone( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ISOTZone instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadISOTZone( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ISOTZone instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateISOTZone( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ISOTZone instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteISOTZone( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecClusGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecClusGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecClusGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecClusGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecClusGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecClusGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecClusGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecClusGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecClusGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecClusGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecClusGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecClusGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecClusGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecClusGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecClusGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecClusGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecClusRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecClusRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecClusRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecClusRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecClusRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecClusRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecClusRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecClusRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecClusRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecClusRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecClusRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecClusRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecClusRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecClusRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecClusRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecClusRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecSession( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecSession( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecSession( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecSession( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecSysGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecSysGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecSysGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecSysGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecSysGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecSysGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecSysGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecSysGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecSysGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecSysGrpInc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecSysGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecSysGrpInc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecSysGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecSysGrpInc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecSysGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecSysGrpInc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecSysGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecSysGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecSysGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecSysGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecSysGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecSysGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecSysGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecSysGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecSysRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecSysRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecSysRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecSysRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecSysRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecSysRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecSysRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecSysRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecSysRoleEnables instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecSysRoleEnables( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecSysRoleEnables instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecSysRoleEnables( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecSysRoleEnables instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecSysRoleEnables( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecSysRoleEnables instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecSysRoleEnables( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecSysRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecSysRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecSysRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecSysRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecSysRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecSysRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecSysRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecSysRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecTentGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecTentGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecTentGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecTentGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecTentGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecTentGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecTentGrp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecTentGrp( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecTentGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecTentGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecTentGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecTentGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecTentGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecTentGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecTentGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecTentGrpMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecTentRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecTentRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecTentRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecTentRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecTentRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecTentRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecTentRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecTentRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecTentRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecTentRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecTentRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecTentRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecTentRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecTentRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecTentRoleMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecTentRoleMemb( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecUser( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecUser( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecUser( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecUser( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecUserEMConf instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecUserEMConf( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecUserEMConf instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecUserEMConf( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecUserEMConf instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecUserEMConf( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecUserEMConf instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecUserEMConf( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecUserPWHistory instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecUserPWHistory( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecUserPWHistory instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecUserPWHistory( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecUserPWHistory instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecUserPWHistory( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecUserPWHistory instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecUserPWHistory( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecUserPWReset instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecUserPWReset( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecUserPWReset instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecUserPWReset( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecUserPWReset instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecUserPWReset( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecUserPWReset instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecUserPWReset( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecUserPassword instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecUserPassword( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecUserPassword instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecUserPassword( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecUserPassword instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecUserPassword( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecUserPassword instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecUserPassword( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSysCluster( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSysCluster( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSysCluster( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSysCluster( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TableInfo instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTableInfo( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TableInfo instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTableInfo( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TableInfo instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTableInfo( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TableInfo instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTableInfo( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTenant( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTenant( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTenant( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTenant( SecureAuthorization Authorization );
}
