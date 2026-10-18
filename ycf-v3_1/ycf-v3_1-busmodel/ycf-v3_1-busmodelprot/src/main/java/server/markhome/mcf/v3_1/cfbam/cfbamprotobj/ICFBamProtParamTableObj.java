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

public interface ICFBamProtParamTableObj
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
	 *	Instantiate a new Param instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtParamObj newInstance();

	/**
	 *	Instantiate a new Param edition of the specified Param instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtParamEditObj newEditInstance( ICFBamProtParamObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtParamObj realiseParam( ICFBamProtParamObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtParamObj createParam( ICFBamProtParamObj Obj );

	/**
	 *	Read a Param-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Param-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtParamObj readParam( MCFDbKeyHash256 pkey );

	/**
	 *	Read a Param-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Param-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtParamObj readParam( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtParamObj readCachedParam( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeParam( ICFBamProtParamObj obj );

	void deepDisposeParam( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtParamObj lockParam( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Param-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtParamObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtParamObj> readAllParam();

	/**
	 *	Return a sorted map of all the Param-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtParamObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtParamObj> readAllParam( boolean forceRead );

	List<ICFBamProtParamObj> readCachedAllParam();

	/**
	 *	Get the ICFBamProtParamObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtParamObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtParamObj readParamByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtParamObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtParamObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtParamObj readParamByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtParamObj instance for the unique UNameIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtParamObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtParamObj readParamByUNameIdx(IMCFKeyHash256 ServerMethodId,
		String Name );

	/**
	 *	Get the ICFBamProtParamObj instance for the unique UNameIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtParamObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtParamObj readParamByUNameIdx(IMCFKeyHash256 ServerMethodId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate ServerMethodIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate ServerMethodIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByServerMethodIdx( IMCFKeyHash256 ServerMethodId );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate ServerMethodIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate ServerMethodIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByServerMethodIdx( IMCFKeyHash256 ServerMethodId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate ServerTypeIdx key.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate ServerTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByServerTypeIdx( MCFDbKeyHash256 TypeId );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate ServerTypeIdx key.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate ServerTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByServerTypeIdx( MCFDbKeyHash256 TypeId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByContPrevIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByContPrevIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByContNextIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<ICFBamProtParamObj> instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtParamObj> cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtParamObj> readParamByContNextIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamProtParamObj readCachedParamByIdIdx( IMCFKeyHash256 Id );

	ICFBamProtParamObj readCachedParamByUNameIdx( IMCFKeyHash256 ServerMethodId,
		String Name );

	List<List<ICFBamProtParamObj>> readCachedParamByServerMethodIdx( IMCFKeyHash256 ServerMethodId );

	List<List<ICFBamProtParamObj>> readCachedParamByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<List<ICFBamProtParamObj>> readCachedParamByServerTypeIdx( MCFDbKeyHash256 TypeId );

	List<List<ICFBamProtParamObj>> readCachedParamByPrevIdx( MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtParamObj>> readCachedParamByNextIdx( MCFDbKeyHash256 NextId );

	List<List<ICFBamProtParamObj>> readCachedParamByContPrevIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtParamObj>> readCachedParamByContNextIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId );

	void deepDisposeParamByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeParamByUNameIdx( IMCFKeyHash256 ServerMethodId,
		String Name );

	void deepDisposeParamByServerMethodIdx( IMCFKeyHash256 ServerMethodId );

	void deepDisposeParamByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeParamByServerTypeIdx( MCFDbKeyHash256 TypeId );

	void deepDisposeParamByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeParamByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeParamByContPrevIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeParamByContNextIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtParamObj updateParam( ICFBamProtParamObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteParam( ICFBamProtParamObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByUNameIdx(IMCFKeyHash256 ServerMethodId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByServerMethodIdx( IMCFKeyHash256 ServerMethodId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByServerTypeIdx( MCFDbKeyHash256 TypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByContPrevIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByContNextIdx( IMCFKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Move the ICFBamProtParamObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtParamObj refreshed cache instance.
	 */
	ICFBamProtParamObj moveUpParam( ICFBamProtParamObj Obj );

	/**
	 *	Move the ICFBamProtParamObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtParamObj refreshed cache instance.
	 */
	ICFBamProtParamObj moveDownParam( ICFBamProtParamObj Obj );
}
