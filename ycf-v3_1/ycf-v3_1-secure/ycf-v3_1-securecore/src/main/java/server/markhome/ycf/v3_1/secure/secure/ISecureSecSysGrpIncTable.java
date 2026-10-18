
// Description: Java 25 DbIO interface for SecSysGrpInc.

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
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	SecureSecSysGrpIncTable database interface for SecSysGrpInc has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ISecureSecSysGrpIncTable
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
	ISecureSecSysGrpInc createSecSysGrpInc( ISecureAuthorization Authorization,
		ISecureSecSysGrpInc rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ISecureSecSysGrpInc updateSecSysGrpInc( ISecureAuthorization Authorization,
		ISecureSecSysGrpInc rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecSysGrpInc( ISecureAuthorization Authorization,
		ISecureSecSysGrpInc rec );
	/**
	 *	Delete the SecSysGrpInc instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecSysGrpIncByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecSysGrpId,
		String argInclName );
	/**
	 *	Delete the SecSysGrpInc instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecSysGrpIncByIdIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey argKey );
	/**
	 *	Delete the SecSysGrpInc instances identified by the key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecSysGrpIncBySysGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecSysGrpId );

	/**
	 *	Delete the SecSysGrpInc instances identified by the key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecSysGrpIncBySysGrpIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncBySysGrpIdxKey argKey );
	/**
	 *	Delete the SecSysGrpInc instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecSysGrpIncByNameIdx( ISecureAuthorization Authorization,
		String argInclName );

	/**
	 *	Delete the SecSysGrpInc instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecSysGrpIncByNameIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncByNameIdxKey argKey );


	/**
	 *	Read the derived SecSysGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpInc instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecSysGrpInc readDerived( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey PKey );

	/**
	 *	Read the derived SecSysGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecSysGrpInc readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName );

	/**
	 *	Lock the derived SecSysGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecSysGrpInc lockDerived( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey PKey );

	/**
	 *	Read all SecSysGrpInc instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ISecureSecSysGrpInc[] readAllDerived( ISecureAuthorization Authorization );

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
	ISecureSecSysGrpInc readDerivedByIdIdx( ISecureAuthorization Authorization,
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
	ISecureSecSysGrpInc[] readDerivedBySysGrpIdx( ISecureAuthorization Authorization,
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
	ISecureSecSysGrpInc[] readDerivedByNameIdx( ISecureAuthorization Authorization,
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
	ISecureSecSysGrpInc readRec( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey PKey );

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
	ISecureSecSysGrpInc readRec( ISecureAuthorization Authorization,
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
	ISecureSecSysGrpInc lockRec( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey PKey );

	/**
	 *	Read all the specific SecSysGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysGrpInc instances in the database accessible for the Authorization.
	 */
	ISecureSecSysGrpInc[] readAllRec( ISecureAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecSysGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysGrpInc instances in the database accessible for the Authorization.
	 */
	ISecureSecSysGrpInc[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecSysGrpId,
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
	ISecureSecSysGrpInc readRecByIdIdx( ISecureAuthorization Authorization,
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
	ISecureSecSysGrpInc[] readRecBySysGrpIdx( ISecureAuthorization Authorization,
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
	ISecureSecSysGrpInc[] readRecByNameIdx( ISecureAuthorization Authorization,
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
	ISecureSecSysGrpInc[] pageRecBySysGrpIdx( ISecureAuthorization Authorization,
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
	ISecureSecSysGrpInc[] pageRecByNameIdx( ISecureAuthorization Authorization,
		String InclName,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorInclName );
}
