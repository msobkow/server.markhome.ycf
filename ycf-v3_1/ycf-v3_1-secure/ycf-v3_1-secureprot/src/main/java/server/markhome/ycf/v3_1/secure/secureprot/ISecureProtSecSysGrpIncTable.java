
// Description: Java 25 protlic DbIO interface for SecSysGrpInc.

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

package server.markhome.ycf.v3_1.secure.secureprot;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	SecureProtSecSysGrpIncTable protlic database interface for SecSysGrpInc has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ISecureProtSecSysGrpIncTable
{
	public static final String TABLE_NAME = "SecSysGrpInc";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ISecureProtSecSysGrpInc protcreateSecSysGrpInc( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpInc rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ISecureProtSecSysGrpInc protupdateSecSysGrpInc( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpInc rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteSecSysGrpInc( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpInc rec );
	/**
	 *	Delete the SecSysGrpInc instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 */
	public void protdeleteSecSysGrpIncByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argSecSysGrpId,
		String argInclName );
	/**
	 *	Delete the SecSysGrpInc instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteSecSysGrpIncByIdIdx( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpIncPKey argKey );
	/**
	 *	Delete the SecSysGrpInc instances identified by the key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 */
	public void protdeleteSecSysGrpIncBySysGrpIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argSecSysGrpId );

	/**
	 *	Delete the SecSysGrpInc instances identified by the key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecSysGrpIncBySysGrpIdx( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpIncBySysGrpIdxKey argKey );
	/**
	 *	Delete the SecSysGrpInc instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 */
	public void protdeleteSecSysGrpIncByNameIdx( ISecurePubAuthorization Authorization,
		String argInclName );

	/**
	 *	Delete the SecSysGrpInc instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecSysGrpIncByNameIdx( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpIncByNameIdxKey argKey );


	/**
	 *	Read the derived SecSysGrpInc record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpInc instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecSysGrpInc protreadDerived( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpIncPKey PKey );

	/**
	 *	Read the derived SecSysGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecSysGrpInc protreadDerived( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName );

	/**
	 *	Lock the derived SecSysGrpInc record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecSysGrpInc protlockDerived( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpIncPKey PKey );

	/**
	 *	Read all SecSysGrpInc instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ISecureProtSecSysGrpInc[] protreadProtAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived SecSysGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecSysGrpInc protreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName );

	/**
	 *	Read an array of the derived SecSysGrpInc record instances identified by the duplicate key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecureProtSecSysGrpInc[] protreadDerivedBySysGrpIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId );

	/**
	 *	Read an array of the derived SecSysGrpInc record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecureProtSecSysGrpInc[] protreadDerivedByNameIdx( ISecurePubAuthorization Authorization,
		String InclName );

	/**
	 *	Read the specific SecSysGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpInc protreadRec( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpIncPKey PKey );

	/**
	 *	Read the specific SecSysGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpInc protreadRec( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName );

	/**
	 *	Lock the specific SecSysGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpInc protlockRec( ISecurePubAuthorization Authorization,
		ISecureProtSecSysGrpIncPKey PKey );

	/**
	 *	Read all the specific SecSysGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysGrpInc instances in the database accessible for the Authorization.
	 */
	public ISecureProtSecSysGrpInc[] protreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecSysGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysGrpInc instances in the database accessible for the Authorization.
	 */
	public ISecureProtSecSysGrpInc[] protpageAllRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 priorSecSysGrpId,
		String priorInclName );

	/**
	 *	Read the specific SecSysGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpInc protreadRecByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName );

	/**
	 *	Read an array of the specific SecSysGrpInc record instances identified by the duplicate key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpInc[] protreadRecBySysGrpIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId );

	/**
	 *	Read an array of the specific SecSysGrpInc record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpInc[] protreadRecByNameIdx( ISecurePubAuthorization Authorization,
		String InclName );

	/**
	 *	Read a page array of the specific SecSysGrpInc record instances identified by the duplicate key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpInc[] protpageRecBySysGrpIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorInclName );

	/**
	 *	Read a page array of the specific SecSysGrpInc record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecSysGrpInc[] protpageRecByNameIdx( ISecurePubAuthorization Authorization,
		String InclName,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorInclName );
}
