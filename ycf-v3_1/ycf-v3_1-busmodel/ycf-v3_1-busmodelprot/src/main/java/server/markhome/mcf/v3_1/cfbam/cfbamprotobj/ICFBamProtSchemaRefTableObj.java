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

public interface ICFBamProtSchemaRefTableObj
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
	 *	Instantiate a new SchemaRef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtSchemaRefObj newInstance();

	/**
	 *	Instantiate a new SchemaRef edition of the specified SchemaRef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtSchemaRefEditObj newEditInstance( ICFBamProtSchemaRefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtSchemaRefObj realiseSchemaRef( ICFBamProtSchemaRefObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtSchemaRefObj createSchemaRef( ICFBamProtSchemaRefObj Obj );

	/**
	 *	Read a SchemaRef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaRef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtSchemaRefObj readSchemaRef( MCFDbKeyHash256 pkey );

	/**
	 *	Read a SchemaRef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaRef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtSchemaRefObj readSchemaRef( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtSchemaRefObj readCachedSchemaRef( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeSchemaRef( ICFBamProtSchemaRefObj obj );

	void deepDisposeSchemaRef( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtSchemaRefObj lockSchemaRef( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SchemaRef-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtSchemaRefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readAllSchemaRef();

	/**
	 *	Return a sorted map of all the SchemaRef-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtSchemaRefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readAllSchemaRef( boolean forceRead );

	List<ICFBamProtSchemaRefObj> readCachedAllSchemaRef();

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRefObj readSchemaRefByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRefObj readSchemaRefByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtSchemaRefObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtSchemaRefObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Get the map of ICFBamProtSchemaRefObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtSchemaRefObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefByTenantIdx( IMCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtSchemaRefObj> instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRefObj> cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefBySchemaIdx( IMCFKeyHash256 SchemaId );

	/**
	 *	Get the map of List<ICFBamProtSchemaRefObj> instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRefObj> cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefBySchemaIdx( IMCFKeyHash256 SchemaId,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtSchemaRefObj instance for the unique UNameIdx key.
	 *
	 *	@param	SchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtSchemaRefObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRefObj readSchemaRefByUNameIdx(IMCFKeyHash256 SchemaId,
		String Name );

	/**
	 *	Get the ICFBamProtSchemaRefObj instance for the unique UNameIdx key.
	 *
	 *	@param	SchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtSchemaRefObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtSchemaRefObj readSchemaRefByUNameIdx(IMCFKeyHash256 SchemaId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtSchemaRefObj> instances sorted by their primary keys for the duplicate RefSchemaIdx key.
	 *
	 *	@param	RefSchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRefObj> cached instances sorted by their primary keys for the duplicate RefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefByRefSchemaIdx( MCFDbKeyHash256 RefSchemaId );

	/**
	 *	Get the map of List<ICFBamProtSchemaRefObj> instances sorted by their primary keys for the duplicate RefSchemaIdx key.
	 *
	 *	@param	RefSchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRefObj> cached instances sorted by their primary keys for the duplicate RefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefByRefSchemaIdx( MCFDbKeyHash256 RefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtSchemaRefObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRefObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<ICFBamProtSchemaRefObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRefObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtSchemaRefObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRefObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<ICFBamProtSchemaRefObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtSchemaRefObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtSchemaRefObj> readSchemaRefByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamProtScopeObj readCachedSchemaRefByIdIdx( IMCFKeyHash256 Id );

	List<List<ICFBamProtScopeObj>> readCachedSchemaRefByTenantIdx( IMCFKeyHash256 TenantId );

	List<List<ICFBamProtSchemaRefObj>> readCachedSchemaRefBySchemaIdx( IMCFKeyHash256 SchemaId );

	ICFBamProtSchemaRefObj readCachedSchemaRefByUNameIdx( IMCFKeyHash256 SchemaId,
		String Name );

	List<List<ICFBamProtSchemaRefObj>> readCachedSchemaRefByRefSchemaIdx( MCFDbKeyHash256 RefSchemaId );

	List<List<ICFBamProtSchemaRefObj>> readCachedSchemaRefByPrevIdx( MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtSchemaRefObj>> readCachedSchemaRefByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeSchemaRefByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeSchemaRefByTenantIdx( IMCFKeyHash256 TenantId );

	void deepDisposeSchemaRefBySchemaIdx( IMCFKeyHash256 SchemaId );

	void deepDisposeSchemaRefByUNameIdx( IMCFKeyHash256 SchemaId,
		String Name );

	void deepDisposeSchemaRefByRefSchemaIdx( MCFDbKeyHash256 RefSchemaId );

	void deepDisposeSchemaRefByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeSchemaRefByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtSchemaRefObj updateSchemaRef( ICFBamProtSchemaRefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSchemaRef( ICFBamProtSchemaRefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefBySchemaIdx( IMCFKeyHash256 SchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaId	The SchemaRef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByUNameIdx(IMCFKeyHash256 SchemaId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	RefSchemaId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByRefSchemaIdx( MCFDbKeyHash256 RefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The SchemaRef key attribute of the instance generating the id.
	 */
	void deleteSchemaRefByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Move the ICFBamProtSchemaRefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtSchemaRefObj refreshed cache instance.
	 */
	ICFBamProtSchemaRefObj moveUpSchemaRef( ICFBamProtSchemaRefObj Obj );

	/**
	 *	Move the ICFBamProtSchemaRefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtSchemaRefObj refreshed cache instance.
	 */
	ICFBamProtSchemaRefObj moveDownSchemaRef( ICFBamProtSchemaRefObj Obj );
}
