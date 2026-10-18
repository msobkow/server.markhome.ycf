
// Description: Java 25 DbIO interface for SecSysRoleMemb.

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
 *	SecureSecSysRoleMembTable database interface for SecSysRoleMemb has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ISecureSecSysRoleMembTable
{
	public static final String TABLE_NAME = "SecSysRoleMemb";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ISecureSecSysRoleMemb createSecSysRoleMemb( ISecureAuthorization Authorization,
		ISecureSecSysRoleMemb rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ISecureSecSysRoleMemb updateSecSysRoleMemb( ISecureAuthorization Authorization,
		ISecureSecSysRoleMemb rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecSysRoleMemb( ISecureAuthorization Authorization,
		ISecureSecSysRoleMemb rec );
	/**
	 *	Delete the SecSysRoleMemb instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecSysRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecSysRoleMembByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecSysRoleId,
		String argLoginId );
	/**
	 *	Delete the SecSysRoleMemb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecSysRoleMembByIdIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey argKey );
	/**
	 *	Delete the SecSysRoleMemb instances identified by the key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecSysRoleMembBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecSysRoleId );

	/**
	 *	Delete the SecSysRoleMemb instances identified by the key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecSysRoleMembBySysRoleIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembBySysRoleIdxKey argKey );
	/**
	 *	Delete the SecSysRoleMemb instances identified by the key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecSysRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecSysRoleMembByLoginIdx( ISecureAuthorization Authorization,
		String argLoginId );

	/**
	 *	Delete the SecSysRoleMemb instances identified by the key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecSysRoleMembByLoginIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembByLoginIdxKey argKey );


	/**
	 *	Read the derived SecSysRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleMemb instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecSysRoleMemb readDerived( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey PKey );

	/**
	 *	Read the derived SecSysRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecSysRoleMemb readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String LoginId );

	/**
	 *	Lock the derived SecSysRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecSysRoleMemb lockDerived( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey PKey );

	/**
	 *	Read all SecSysRoleMemb instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ISecureSecSysRoleMemb[] readAllDerived( ISecureAuthorization Authorization );

	/**
	 *	Read the derived SecSysRoleMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecSysRoleMemb readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String LoginId );

	/**
	 *	Read an array of the derived SecSysRoleMemb record instances identified by the duplicate key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ISecureSecSysRoleMemb[] readDerivedBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId );

	/**
	 *	Read an array of the derived SecSysRoleMemb record instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ISecureSecSysRoleMemb[] readDerivedByLoginIdx( ISecureAuthorization Authorization,
		String LoginId );

	/**
	 *	Read the specific SecSysRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecSysRoleMemb readRec( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey PKey );

	/**
	 *	Read the specific SecSysRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecSysRoleMemb readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String LoginId );

	/**
	 *	Lock the specific SecSysRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecSysRoleMemb lockRec( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey PKey );

	/**
	 *	Read all the specific SecSysRoleMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysRoleMemb instances in the database accessible for the Authorization.
	 */
	ISecureSecSysRoleMemb[] readAllRec( ISecureAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecSysRoleMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysRoleMemb instances in the database accessible for the Authorization.
	 */
	ISecureSecSysRoleMemb[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId );

	/**
	 *	Read the specific SecSysRoleMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecSysRoleMemb readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String LoginId );

	/**
	 *	Read an array of the specific SecSysRoleMemb record instances identified by the duplicate key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecSysRoleMemb[] readRecBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId );

	/**
	 *	Read an array of the specific SecSysRoleMemb record instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecSysRoleMemb[] readRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId );

	/**
	 *	Read a page array of the specific SecSysRoleMemb record instances identified by the duplicate key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecSysRoleMemb[] pageRecBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId );

	/**
	 *	Read a page array of the specific SecSysRoleMemb record instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecSysRoleMemb[] pageRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId );
}
