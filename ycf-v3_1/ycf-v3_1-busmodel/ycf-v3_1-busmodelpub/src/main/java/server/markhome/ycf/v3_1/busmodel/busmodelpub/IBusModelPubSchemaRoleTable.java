
// Description: Java 25 public DbIO interface for SchemaRole.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelpub;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;

/*
 *	BusModelPubSchemaRoleTable public database interface for SchemaRole has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelPubSchemaRoleTable
{
	public static final String TABLE_NAME = "SchemaRole";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public IBusModelPubSchemaRole pubcreateSchemaRole( ISecurePubAuthorization Authorization,
		IBusModelPubSchemaRole rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public IBusModelPubSchemaRole pubupdateSchemaRole( ISecurePubAuthorization Authorization,
		IBusModelPubSchemaRole rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void pubdeleteSchemaRole( ISecurePubAuthorization Authorization,
		IBusModelPubSchemaRole rec );
	/**
	 *	Delete the SchemaRole instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 */
	public void pubdeleteSchemaRoleBySchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argSchemaDefId );

	/**
	 *	Delete the SchemaRole instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteSchemaRoleBySchemaIdx( ISecurePubAuthorization Authorization,
		IBusModelPubSchemaRoleBySchemaIdxKey argKey );
	/**
	 *	Delete the SchemaRole instances identified by the key RoleScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 */
	public void pubdeleteSchemaRoleByRoleScopeIdx( ISecurePubAuthorization Authorization,
		IBusModelPubSchema.RoleScopeEnum argRoleScope );

	/**
	 *	Delete the SchemaRole instances identified by the key RoleScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteSchemaRoleByRoleScopeIdx( ISecurePubAuthorization Authorization,
		IBusModelPubSchemaRoleByRoleScopeIdxKey argKey );
	/**
	 *	Delete the SchemaRole instances identified by the key SchRoleScpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 */
	public void pubdeleteSchemaRoleBySchRoleScpIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argSchemaDefId,
		IBusModelPubSchema.RoleScopeEnum argRoleScope );

	/**
	 *	Delete the SchemaRole instances identified by the key SchRoleScpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteSchemaRoleBySchRoleScpIdx( ISecurePubAuthorization Authorization,
		IBusModelPubSchemaRoleBySchRoleScpIdxKey argKey );
	/**
	 *	Delete the SchemaRole instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void pubdeleteSchemaRoleByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argKey );
	/**
	 *	Delete the SchemaRole instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 */
	public void pubdeleteSchemaRoleByUNameIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argScopeId,
		String argName );

	/**
	 *	Delete the SchemaRole instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteSchemaRoleByUNameIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRoleDefByUNameIdxKey argKey );
	/**
	 *	Delete the SchemaRole instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 */
	public void pubdeleteSchemaRoleByScopeIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argScopeId );

	/**
	 *	Delete the SchemaRole instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteSchemaRoleByScopeIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRoleDefByScopeIdxKey argKey );
	/**
	 *	Delete the SchemaRole instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 */
	public void pubdeleteSchemaRoleByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the SchemaRole instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteSchemaRoleByDefSchemaIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRoleDefByDefSchemaIdxKey argKey );
	/**
	 *	Delete the SchemaRole instances identified by the key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 */
	public void pubdeleteSchemaRoleByUDefIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argScopeId,
		YCFDbKeyHash256 argDefSchemaId,
		String argName );

	/**
	 *	Delete the SchemaRole instances identified by the key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteSchemaRoleByUDefIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRoleDefByUDefIdxKey argKey );


	/**
	 *	Read the derived SchemaRole record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaRole instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubSchemaRole pubreadDerived( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Lock the derived SchemaRole record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaRole instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubSchemaRole publockDerived( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Read all SchemaRole instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public IBusModelPubSchemaRole[] pubreadPubAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived SchemaRole record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubSchemaRole pubreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 Id );

	/**
	 *	Read the derived SchemaRole record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubSchemaRole pubreadDerivedByUNameIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the derived SchemaRole record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubSchemaRole[] pubreadDerivedByScopeIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId );

	/**
	 *	Read an array of the derived SchemaRole record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubSchemaRole[] pubreadDerivedByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read the derived SchemaRole record instance identified by the unique key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubSchemaRole pubreadDerivedByUDefIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Read an array of the derived SchemaRole record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubSchemaRole[] pubreadDerivedBySchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Read an array of the derived SchemaRole record instances identified by the duplicate key RoleScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubSchemaRole[] pubreadDerivedByRoleScopeIdx( ISecurePubAuthorization Authorization,
		IBusModelPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Read an array of the derived SchemaRole record instances identified by the duplicate key SchRoleScpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubSchemaRole[] pubreadDerivedBySchRoleScpIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 SchemaDefId,
		IBusModelPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Read the specific SchemaRole record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaRole instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole pubreadRec( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Lock the specific SchemaRole record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SchemaRole instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole publockRec( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Read all the specific SchemaRole record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SchemaRole instances in the database accessible for the Authorization.
	 */
	public IBusModelPubSchemaRole[] pubreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read the specific SchemaRole record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole pubreadRecByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 Id );

	/**
	 *	Read the specific SchemaRole record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole pubreadRecByUNameIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the specific SchemaRole record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole[] pubreadRecByScopeIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId );

	/**
	 *	Read an array of the specific SchemaRole record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole[] pubreadRecByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read the specific SchemaRole record instance identified by the unique key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole pubreadRecByUDefIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Read an array of the specific SchemaRole record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole[] pubreadRecBySchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Read an array of the specific SchemaRole record instances identified by the duplicate key RoleScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole[] pubreadRecByRoleScopeIdx( ISecurePubAuthorization Authorization,
		IBusModelPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Read an array of the specific SchemaRole record instances identified by the duplicate key SchRoleScpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRole[] pubreadRecBySchRoleScpIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 SchemaDefId,
		IBusModelPubSchema.RoleScopeEnum RoleScope );
}
