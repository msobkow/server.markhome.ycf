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

public interface ICFBamPubParamTableObj
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
	 *	Instantiate a new Param instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubParamObj newInstance();

	/**
	 *	Instantiate a new Param edition of the specified Param instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubParamEditObj newEditInstance( ICFBamPubParamObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubParamObj realiseParam( ICFBamPubParamObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubParamObj createParam( ICFBamPubParamObj Obj );

	/**
	 *	Read a Param-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Param-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubParamObj readParam( IMCFKeyHash256 pkey );

	/**
	 *	Read a Param-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Param-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubParamObj readParam( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubParamObj readCachedParam( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeParam( ICFBamPubParamObj obj );

	void deepDisposeParam( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubParamObj lockParam( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Param-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubParamObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubParamObj> readAllParam();

	/**
	 *	Return a sorted map of all the Param-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubParamObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubParamObj> readAllParam( boolean forceRead );

	List<ICFBamPubParamObj> readCachedAllParam();

	/**
	 *	Get the CFBamPubParamObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubParamObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubParamObj readParamByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubParamObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubParamObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubParamObj readParamByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubParamObj instance for the unique UNameIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubParamObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubParamObj readParamByUNameIdx(MCFDbKeyHash256 ServerMethodId,
		String Name );

	/**
	 *	Get the CFBamPubParamObj instance for the unique UNameIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubParamObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubParamObj readParamByUNameIdx(MCFDbKeyHash256 ServerMethodId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate ServerMethodIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate ServerMethodIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByServerMethodIdx( MCFDbKeyHash256 ServerMethodId );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate ServerMethodIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate ServerMethodIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByServerMethodIdx( MCFDbKeyHash256 ServerMethodId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate ServerTypeIdx key.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate ServerTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByServerTypeIdx( MCFDbKeyHash256 TypeId );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate ServerTypeIdx key.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate ServerTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByServerTypeIdx( MCFDbKeyHash256 TypeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByContPrevIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByContPrevIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByContNextIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubParamObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubParamObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubParamObj> readParamByContNextIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamPubParamObj readCachedParamByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubParamObj readCachedParamByUNameIdx( MCFDbKeyHash256 ServerMethodId,
		String Name );

	List<ICFBamPubParamObj> readCachedParamByServerMethodIdx( MCFDbKeyHash256 ServerMethodId );

	List<ICFBamPubParamObj> readCachedParamByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubParamObj> readCachedParamByServerTypeIdx( MCFDbKeyHash256 TypeId );

	List<ICFBamPubParamObj> readCachedParamByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubParamObj> readCachedParamByNextIdx( MCFDbKeyHash256 NextId );

	List<ICFBamPubParamObj> readCachedParamByContPrevIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId );

	List<ICFBamPubParamObj> readCachedParamByContNextIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId );

	void deepDisposeParamByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeParamByUNameIdx( MCFDbKeyHash256 ServerMethodId,
		String Name );

	void deepDisposeParamByServerMethodIdx( MCFDbKeyHash256 ServerMethodId );

	void deepDisposeParamByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeParamByServerTypeIdx( MCFDbKeyHash256 TypeId );

	void deepDisposeParamByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeParamByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeParamByContPrevIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeParamByContNextIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubParamObj updateParam( ICFBamPubParamObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteParam( ICFBamPubParamObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByUNameIdx(MCFDbKeyHash256 ServerMethodId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByServerMethodIdx( MCFDbKeyHash256 ServerMethodId );

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
	void deleteParamByContPrevIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByContNextIdx( MCFDbKeyHash256 ServerMethodId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Move the CFBamPubParamObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubParamObj refreshed cache instance.
	 */
	ICFBamPubParamObj moveUpParam( ICFBamPubParamObj Obj );

	/**
	 *	Move the CFBamPubParamObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubParamObj refreshed cache instance.
	 */
	ICFBamPubParamObj moveDownParam( ICFBamPubParamObj Obj );
}
