// Description: Java 25 Protected Table Object interface for CFBamProt.

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

package server.markhome.mcf.v3_1.cfbam.cfbamprotobj;

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
import server.markhome.mcf.v3_1.cfbam.cfbamprot.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;

public interface ICFBamProtSchemaRoleTableObj
{
	public ICFBamProtSchemaObj getSchema();
	public void setSchema( ICFBamProtSchemaObj value );

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
	ICFBamProtSchemaRoleObj newInstance();

	/**
	 *	Instantiate a new SchemaRole edition of the specified SchemaRole instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtSchemaRoleEditObj newEditInstance( ICFBamProtSchemaRoleObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtSchemaRoleObj realiseSchemaRole( ICFBamProtSchemaRoleObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtSchemaRoleObj createSchemaRole( ICFBamProtSchemaRoleObj Obj );

	/**
	 *	Read a SchemaRole-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaRole-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtSchemaRoleObj readSchemaRole( MCFDbKeyHash256 pkey );

	/**
	 *	Read a SchemaRole-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaRole-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtSchemaRoleObj readSchemaRole( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtSchemaRoleObj readCachedSchemaRole( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeSchemaRole( ICFBamProtSchemaRoleObj obj );

	void deepDisposeSchemaRole( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtSchemaRoleObj lockSchemaRole( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SchemaRole-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtSchemaRoleObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readAllSchemaRole();

	/**
	 *	Return a sorted map of all the SchemaRole-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtSchemaRoleObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readAllSchemaRole( boolean forceRead );

	List<ICFBamProtSchemaRoleObj> readCachedAllSchemaRole();

	/**
	 *	Get the ICFBamProtRoleDefObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRoleDefObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRoleObj readSchemaRoleByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtRoleDefObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRoleDefObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRoleObj readSchemaRoleByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtRoleDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRoleDefObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRoleObj readSchemaRoleByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the ICFBamProtRoleDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRoleDefObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRoleObj readSchemaRoleByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtSchemaRoleObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtSchemaRoleObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleByScopeIdx( IMCFKeyHash256 ScopeId );

	/**
	 *	Get the map of ICFBamProtSchemaRoleObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtSchemaRoleObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleByScopeIdx( IMCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtSchemaRoleObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtSchemaRoleObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of ICFBamProtSchemaRoleObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtSchemaRoleObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtRoleDefObj instance for the unique UDefIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRoleDefObj cached instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRoleObj readSchemaRoleByUDefIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Get the ICFBamProtRoleDefObj instance for the unique UDefIdx key.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRoleDefObj refreshed instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRoleObj readSchemaRoleByUDefIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtSchemaRoleObj> instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRoleObj> cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleBySchemaIdx( IMCFKeyHash256 SchemaDefId );

	/**
	 *	Get the map of List<ICFBamProtSchemaRoleObj> instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRoleObj> cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleBySchemaIdx( IMCFKeyHash256 SchemaDefId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtSchemaRoleObj> instances sorted by their primary keys for the duplicate RoleScopeIdx key.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRoleObj> cached instances sorted by their primary keys for the duplicate RoleScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleByRoleScopeIdx( ICFBamPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Get the map of List<ICFBamProtSchemaRoleObj> instances sorted by their primary keys for the duplicate RoleScopeIdx key.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRoleObj> cached instances sorted by their primary keys for the duplicate RoleScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleByRoleScopeIdx( ICFBamPubSchema.RoleScopeEnum RoleScope,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtSchemaRoleObj> instances sorted by their primary keys for the duplicate SchRoleScpIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRoleObj> cached instances sorted by their primary keys for the duplicate SchRoleScpIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleBySchRoleScpIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Get the map of List<ICFBamProtSchemaRoleObj> instances sorted by their primary keys for the duplicate SchRoleScpIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	RoleScope	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRoleObj> cached instances sorted by their primary keys for the duplicate SchRoleScpIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRoleObj> readSchemaRoleBySchRoleScpIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope,
		boolean forceRead );

	ICFBamProtRoleDefObj readCachedSchemaRoleByIdIdx( IMCFKeyHash256 Id );

	ICFBamProtRoleDefObj readCachedSchemaRoleByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	List<List<ICFBamProtRoleDefObj>> readCachedSchemaRoleByScopeIdx( IMCFKeyHash256 ScopeId );

	List<List<ICFBamProtRoleDefObj>> readCachedSchemaRoleByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	ICFBamProtRoleDefObj readCachedSchemaRoleByUDefIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	List<List<ICFBamProtSchemaRoleObj>> readCachedSchemaRoleBySchemaIdx( IMCFKeyHash256 SchemaDefId );

	List<List<ICFBamProtSchemaRoleObj>> readCachedSchemaRoleByRoleScopeIdx( ICFBamPubSchema.RoleScopeEnum RoleScope );

	List<List<ICFBamProtSchemaRoleObj>> readCachedSchemaRoleBySchRoleScpIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope );

	void deepDisposeSchemaRoleByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeSchemaRoleByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeSchemaRoleByScopeIdx( IMCFKeyHash256 ScopeId );

	void deepDisposeSchemaRoleByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeSchemaRoleByUDefIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	void deepDisposeSchemaRoleBySchemaIdx( IMCFKeyHash256 SchemaDefId );

	void deepDisposeSchemaRoleByRoleScopeIdx( ICFBamPubSchema.RoleScopeEnum RoleScope );

	void deepDisposeSchemaRoleBySchRoleScpIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope );

	/**
	 *	Internal use only.
	 */
	ICFBamProtSchemaRoleObj updateSchemaRole( ICFBamProtSchemaRoleObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSchemaRole( ICFBamProtSchemaRoleObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleByScopeIdx( IMCFKeyHash256 ScopeId );

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
	void deleteSchemaRoleByUDefIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The SchemaRole key attribute of the instance generating the id.
	 */
	void deleteSchemaRoleBySchemaIdx( IMCFKeyHash256 SchemaDefId );

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
	void deleteSchemaRoleBySchRoleScpIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.RoleScopeEnum RoleScope );
}
