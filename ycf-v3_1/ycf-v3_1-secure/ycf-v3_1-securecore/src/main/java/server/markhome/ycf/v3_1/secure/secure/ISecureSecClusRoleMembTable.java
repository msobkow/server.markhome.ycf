
// Description: Java 25 DbIO interface for SecClusRoleMemb.

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
 *	SecureSecClusRoleMembTable database interface for SecClusRoleMemb has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ISecureSecClusRoleMembTable
{
	public static final String TABLE_NAME = "SecClusRoleMemb";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ISecureSecClusRoleMemb createSecClusRoleMemb( ISecureAuthorization Authorization,
		ISecureSecClusRoleMemb rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ISecureSecClusRoleMemb updateSecClusRoleMemb( ISecureAuthorization Authorization,
		ISecureSecClusRoleMemb rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecClusRoleMemb( ISecureAuthorization Authorization,
		ISecureSecClusRoleMemb rec );
	/**
	 *	Delete the SecClusRoleMemb instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecClusRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecClusRoleMembByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecClusRoleId,
		String argLoginId );
	/**
	 *	Delete the SecClusRoleMemb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecClusRoleMembByIdIdx( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey argKey );
	/**
	 *	Delete the SecClusRoleMemb instances identified by the key ClusRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecClusRoleMembByClusRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecClusRoleId );

	/**
	 *	Delete the SecClusRoleMemb instances identified by the key ClusRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecClusRoleMembByClusRoleIdx( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembByClusRoleIdxKey argKey );
	/**
	 *	Delete the SecClusRoleMemb instances identified by the key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecClusRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecClusRoleMembByLoginIdx( ISecureAuthorization Authorization,
		String argLoginId );

	/**
	 *	Delete the SecClusRoleMemb instances identified by the key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecClusRoleMembByLoginIdx( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembByLoginIdxKey argKey );


	/**
	 *	Read the derived SecClusRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusRoleMemb instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecClusRoleMemb readDerived( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey PKey );

	/**
	 *	Read the derived SecClusRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecClusRoleMemb readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		String LoginId );

	/**
	 *	Lock the derived SecClusRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecClusRoleMemb lockDerived( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey PKey );

	/**
	 *	Read all SecClusRoleMemb instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ISecureSecClusRoleMemb[] readAllDerived( ISecureAuthorization Authorization );

	/**
	 *	Read the derived SecClusRoleMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecClusRoleMemb readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		String LoginId );

	/**
	 *	Read an array of the derived SecClusRoleMemb record instances identified by the duplicate key ClusRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ISecureSecClusRoleMemb[] readDerivedByClusRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId );

	/**
	 *	Read an array of the derived SecClusRoleMemb record instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ISecureSecClusRoleMemb[] readDerivedByLoginIdx( ISecureAuthorization Authorization,
		String LoginId );

	/**
	 *	Read the specific SecClusRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecClusRoleMemb readRec( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey PKey );

	/**
	 *	Read the specific SecClusRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecClusRoleMemb readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		String LoginId );

	/**
	 *	Lock the specific SecClusRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecClusRoleMemb lockRec( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey PKey );

	/**
	 *	Read all the specific SecClusRoleMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecClusRoleMemb instances in the database accessible for the Authorization.
	 */
	ISecureSecClusRoleMemb[] readAllRec( ISecureAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecClusRoleMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecClusRoleMemb instances in the database accessible for the Authorization.
	 */
	ISecureSecClusRoleMemb[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId );

	/**
	 *	Read the specific SecClusRoleMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecClusRoleMemb readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		String LoginId );

	/**
	 *	Read an array of the specific SecClusRoleMemb record instances identified by the duplicate key ClusRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecClusRoleMemb[] readRecByClusRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId );

	/**
	 *	Read an array of the specific SecClusRoleMemb record instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecClusRoleMemb[] readRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId );

	/**
	 *	Read a page array of the specific SecClusRoleMemb record instances identified by the duplicate key ClusRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecClusRoleMemb[] pageRecByClusRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId );

	/**
	 *	Read a page array of the specific SecClusRoleMemb record instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecClusRoleMemb[] pageRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId,
		IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId );
}
