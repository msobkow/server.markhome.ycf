// Description: Java 25 Public Table Object interface for CFBamPub.

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
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
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbampubobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;

public interface ICFBamPubSchemaRoleTableObj
{
	public ICFBamPubSchemaObj getSchema();
	public void setSchema( ICFBamPubSchemaObj value );

	public void minimizeMemory();

	public String getTableName();
	public String getTableDbName();

	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	public int getClassCode();

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	// public static int getBackingClassCode();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SchemaRole instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubSchemaRoleObj newInstance();

	/**
	 *	Instantiate a new SchemaRole edition of the specified SchemaRole instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubSchemaRoleEditObj newEditInstance( ICFBamPubSchemaRoleObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubSchemaRoleObj realiseSchemaRole( ICFBamPubSchemaRoleObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubSchemaRoleObj createSchemaRole( ICFBamPubSchemaRoleObj Obj );

	/**
	 *	Read a SchemaRole-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaRole-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubSchemaRoleObj readSchemaRole( IMCFKeyHash256 pkey );

	/**
	 *	Read a SchemaRole-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaRole-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubSchemaRoleObj readSchemaRole( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubSchemaRoleObj readCachedSchemaRole( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeSchemaRole( ICFBamPubSchemaRoleObj obj );

	void deepDisposeSchemaRole( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubSchemaRoleObj lockSchemaRole( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SchemaRole-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubSchemaRoleObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readAllSchemaRole();

	/**
	 *	Return a sorted map of all the SchemaRole-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubSchemaRoleObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readAllSchemaRole( boolean forceRead );

	List<ICFBamPubSchemaRoleObj> readCachedAllSchemaRole();

	/**
	 *	Get the CFBamPubRoleDefObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRoleDefObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaRoleObj readSchemaRoleByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubRoleDefObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRoleDefObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaRoleObj readSchemaRoleByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubRoleDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRoleDefObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaRoleObj readSchemaRoleByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the CFBamPubRoleDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRoleDefObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaRoleObj readSchemaRoleByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRoleDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of CFBamPubSchemaRoleObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleByScopeIdx( MCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRoleDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubSchemaRoleObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the CFBamPubRoleDefObj instance for the unique UDefIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRoleDefObj cached instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaRoleObj readSchemaRoleByUDefIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Get the CFBamPubRoleDefObj instance for the unique UDefIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRoleDefObj refreshed instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaRoleObj readSchemaRoleByUDefIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubSchemaRoleObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	/**
	 *	Get the map of CFBamPubSchemaRoleObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleBySchemaIdx( MCFDbKeyHash256 SchemaDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubSchemaRoleObj instances sorted by their primary keys for the duplicate RoleScopeIdx key.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate RoleScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleByRoleScopeIdx( ICFBamPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Get the map of CFBamPubSchemaRoleObj instances sorted by their primary keys for the duplicate RoleScopeIdx key.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate RoleScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleByRoleScopeIdx( ICFBamPubSchema.RoleScopeEnum RoleScope,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubSchemaRoleObj instances sorted by their primary keys for the duplicate SchRoleScpIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate SchRoleScpIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleBySchRoleScpIdx( MCFDbKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Get the map of CFBamPubSchemaRoleObj instances sorted by their primary keys for the duplicate SchRoleScpIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaRoleObj cached instances sorted by their primary keys for the duplicate SchRoleScpIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaRoleObj> readSchemaRoleBySchRoleScpIdx( MCFDbKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope,
		boolean forceRead );

	ICFBamPubSchemaRoleObj readCachedSchemaRoleByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubSchemaRoleObj readCachedSchemaRoleByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	List<ICFBamPubSchemaRoleObj> readCachedSchemaRoleByScopeIdx( MCFDbKeyHash256 ScopeId );

	List<ICFBamPubSchemaRoleObj> readCachedSchemaRoleByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	ICFBamPubSchemaRoleObj readCachedSchemaRoleByUDefIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	List<ICFBamPubSchemaRoleObj> readCachedSchemaRoleBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	List<ICFBamPubSchemaRoleObj> readCachedSchemaRoleByRoleScopeIdx( ICFBamPubSchema.RoleScopeEnum RoleScope );

	List<ICFBamPubSchemaRoleObj> readCachedSchemaRoleBySchRoleScpIdx( MCFDbKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope );

	void deepDisposeSchemaRoleByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeSchemaRoleByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeSchemaRoleByScopeIdx( MCFDbKeyHash256 ScopeId );

	void deepDisposeSchemaRoleByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeSchemaRoleByUDefIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	void deepDisposeSchemaRoleBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	void deepDisposeSchemaRoleByRoleScopeIdx( ICFBamPubSchema.RoleScopeEnum RoleScope );

	void deepDisposeSchemaRoleBySchRoleScpIdx( MCFDbKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Internal use only.
	 */
	ICFBamPubSchemaRoleObj updateSchemaRole( ICFBamPubSchemaRoleObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSchemaRole( ICFBamPubSchemaRoleObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleByUDefIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleByRoleScopeIdx( ICFBamPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleBySchRoleScpIdx( MCFDbKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope );
}
