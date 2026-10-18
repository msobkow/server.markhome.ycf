
// Description: Java 25 DbIO interface for SecTentGrpMemb.

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
 *	SecureSecTentGrpMembTable database interface for SecTentGrpMemb has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ISecureSecTentGrpMembTable
{
	public static final String TABLE_NAME = "SecTentGrpMemb";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ISecureSecTentGrpMemb createSecTentGrpMemb( ISecureAuthorization Authorization,
		ISecureSecTentGrpMemb rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ISecureSecTentGrpMemb updateSecTentGrpMemb( ISecureAuthorization Authorization,
		ISecureSecTentGrpMemb rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecTentGrpMemb( ISecureAuthorization Authorization,
		ISecureSecTentGrpMemb rec );
	/**
	 *	Delete the SecTentGrpMemb instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecTentGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecTentGrpMembByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecTentGrpId,
		String argLoginId );
	/**
	 *	Delete the SecTentGrpMemb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecTentGrpMembByIdIdx( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey argKey );
	/**
	 *	Delete the SecTentGrpMemb instances identified by the key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecTentGrpMembByTentGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecTentGrpId );

	/**
	 *	Delete the SecTentGrpMemb instances identified by the key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecTentGrpMembByTentGrpIdx( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembByTentGrpIdxKey argKey );
	/**
	 *	Delete the SecTentGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecTentGrpMembByUserIdx( ISecureAuthorization Authorization,
		String argLoginId );

	/**
	 *	Delete the SecTentGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecTentGrpMembByUserIdx( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembByUserIdxKey argKey );


	/**
	 *	Read the derived SecTentGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpMemb instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecTentGrpMemb readDerived( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey PKey );

	/**
	 *	Read the derived SecTentGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecTentGrpMemb readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		String LoginId );

	/**
	 *	Lock the derived SecTentGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecTentGrpMemb lockDerived( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey PKey );

	/**
	 *	Read all SecTentGrpMemb instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ISecureSecTentGrpMemb[] readAllDerived( ISecureAuthorization Authorization );

	/**
	 *	Read the derived SecTentGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecTentGrpMemb readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		String LoginId );

	/**
	 *	Read an array of the derived SecTentGrpMemb record instances identified by the duplicate key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ISecureSecTentGrpMemb[] readDerivedByTentGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId );

	/**
	 *	Read an array of the derived SecTentGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ISecureSecTentGrpMemb[] readDerivedByUserIdx( ISecureAuthorization Authorization,
		String LoginId );

	/**
	 *	Read the specific SecTentGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecTentGrpMemb readRec( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey PKey );

	/**
	 *	Read the specific SecTentGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecTentGrpMemb readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		String LoginId );

	/**
	 *	Lock the specific SecTentGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecTentGrpMemb lockRec( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey PKey );

	/**
	 *	Read all the specific SecTentGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecTentGrpMemb instances in the database accessible for the Authorization.
	 */
	ISecureSecTentGrpMemb[] readAllRec( ISecureAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecTentGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecTentGrpMemb instances in the database accessible for the Authorization.
	 */
	ISecureSecTentGrpMemb[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId );

	/**
	 *	Read the specific SecTentGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecTentGrpMemb readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		String LoginId );

	/**
	 *	Read an array of the specific SecTentGrpMemb record instances identified by the duplicate key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecTentGrpMemb[] readRecByTentGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId );

	/**
	 *	Read an array of the specific SecTentGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecTentGrpMemb[] readRecByUserIdx( ISecureAuthorization Authorization,
		String LoginId );

	/**
	 *	Read a page array of the specific SecTentGrpMemb record instances identified by the duplicate key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecTentGrpMemb[] pageRecByTentGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId );

	/**
	 *	Read a page array of the specific SecTentGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecTentGrpMemb[] pageRecByUserIdx( ISecureAuthorization Authorization,
		String LoginId,
		IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId );
}
