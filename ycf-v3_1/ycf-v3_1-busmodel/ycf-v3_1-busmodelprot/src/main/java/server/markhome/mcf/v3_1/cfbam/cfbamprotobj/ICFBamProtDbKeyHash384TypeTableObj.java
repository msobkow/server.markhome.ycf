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

public interface ICFBamProtDbKeyHash384TypeTableObj
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
	 *	Instantiate a new DbKeyHash384Type instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtDbKeyHash384TypeObj newInstance();

	/**
	 *	Instantiate a new DbKeyHash384Type edition of the specified DbKeyHash384Type instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtDbKeyHash384TypeEditObj newEditInstance( ICFBamProtDbKeyHash384TypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDbKeyHash384TypeObj realiseDbKeyHash384Type( ICFBamProtDbKeyHash384TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDbKeyHash384TypeObj createDbKeyHash384Type( ICFBamProtDbKeyHash384TypeObj Obj );

	/**
	 *	Read a DbKeyHash384Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash384Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtDbKeyHash384TypeObj readDbKeyHash384Type( MCFDbKeyHash256 pkey );

	/**
	 *	Read a DbKeyHash384Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash384Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtDbKeyHash384TypeObj readDbKeyHash384Type( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtDbKeyHash384TypeObj readCachedDbKeyHash384Type( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeDbKeyHash384Type( ICFBamProtDbKeyHash384TypeObj obj );

	void deepDisposeDbKeyHash384Type( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDbKeyHash384TypeObj lockDbKeyHash384Type( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DbKeyHash384Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readAllDbKeyHash384Type();

	/**
	 *	Return a sorted map of all the DbKeyHash384Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readAllDbKeyHash384Type( boolean forceRead );

	List<ICFBamProtDbKeyHash384TypeObj> readCachedAllDbKeyHash384Type();

	/**
	 *	Get the ICFBamProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDbKeyHash384TypeObj readDbKeyHash384TypeByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDbKeyHash384TypeObj readDbKeyHash384TypeByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDbKeyHash384TypeObj readDbKeyHash384TypeByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the ICFBamProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDbKeyHash384TypeObj readDbKeyHash384TypeByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByScopeIdx( IMCFKeyHash256 ScopeId );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByScopeIdx( IMCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of ICFBamProtDbKeyHash384TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDbKeyHash384TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtDbKeyHash384TypeObj> instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtDbKeyHash384TypeObj> cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeBySchemaIdx( IMCFKeyHash256 SchemaDefId );

	/**
	 *	Get the map of List<ICFBamProtDbKeyHash384TypeObj> instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtDbKeyHash384TypeObj> cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDbKeyHash384TypeObj> readDbKeyHash384TypeBySchemaIdx( IMCFKeyHash256 SchemaDefId,
		boolean forceRead );

	ICFBamProtValueObj readCachedDbKeyHash384TypeByIdIdx( IMCFKeyHash256 Id );

	ICFBamProtValueObj readCachedDbKeyHash384TypeByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	List<List<ICFBamProtValueObj>> readCachedDbKeyHash384TypeByScopeIdx( IMCFKeyHash256 ScopeId );

	List<List<ICFBamProtValueObj>> readCachedDbKeyHash384TypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<List<ICFBamProtValueObj>> readCachedDbKeyHash384TypeByPrevIdx( MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtValueObj>> readCachedDbKeyHash384TypeByNextIdx( MCFDbKeyHash256 NextId );

	List<List<ICFBamProtValueObj>> readCachedDbKeyHash384TypeByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtValueObj>> readCachedDbKeyHash384TypeByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	List<List<ICFBamProtDbKeyHash384TypeObj>> readCachedDbKeyHash384TypeBySchemaIdx( IMCFKeyHash256 SchemaDefId );

	void deepDisposeDbKeyHash384TypeByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeDbKeyHash384TypeByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeDbKeyHash384TypeByScopeIdx( IMCFKeyHash256 ScopeId );

	void deepDisposeDbKeyHash384TypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeDbKeyHash384TypeByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash384TypeByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash384TypeByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash384TypeByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash384TypeBySchemaIdx( IMCFKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDbKeyHash384TypeObj updateDbKeyHash384Type( ICFBamProtDbKeyHash384TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDbKeyHash384Type( ICFBamProtDbKeyHash384TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DbKeyHash384Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384TypeByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash384Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384TypeByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384TypeByScopeIdx( IMCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DbKeyHash384Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384TypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DbKeyHash384Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384TypeByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DbKeyHash384Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384TypeByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash384Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384TypeByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash384Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash384Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384TypeByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The DbKeyHash384Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384TypeBySchemaIdx( IMCFKeyHash256 SchemaDefId );

	/**
	 *	Move the ICFBamProtDbKeyHash384TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtDbKeyHash384TypeObj refreshed cache instance.
	 */
	ICFBamProtDbKeyHash384TypeObj moveUpDbKeyHash384Type( ICFBamProtDbKeyHash384TypeObj Obj );

	/**
	 *	Move the ICFBamProtDbKeyHash384TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtDbKeyHash384TypeObj refreshed cache instance.
	 */
	ICFBamProtDbKeyHash384TypeObj moveDownDbKeyHash384Type( ICFBamProtDbKeyHash384TypeObj Obj );
}
