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

public interface ICFBamPubInt16DefTableObj
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
	 *	Instantiate a new Int16Def instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubInt16DefObj newInstance();

	/**
	 *	Instantiate a new Int16Def edition of the specified Int16Def instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubInt16DefEditObj newEditInstance( ICFBamPubInt16DefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubInt16DefObj realiseInt16Def( ICFBamPubInt16DefObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubInt16DefObj createInt16Def( ICFBamPubInt16DefObj Obj );

	/**
	 *	Read a Int16Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubInt16DefObj readInt16Def( IMCFKeyHash256 pkey );

	/**
	 *	Read a Int16Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubInt16DefObj readInt16Def( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubInt16DefObj readCachedInt16Def( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeInt16Def( ICFBamPubInt16DefObj obj );

	void deepDisposeInt16Def( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubInt16DefObj lockInt16Def( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Int16Def-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubInt16DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubInt16DefObj> readAllInt16Def();

	/**
	 *	Return a sorted map of all the Int16Def-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubInt16DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubInt16DefObj> readAllInt16Def( boolean forceRead );

	List<ICFBamPubInt16DefObj> readCachedAllInt16Def();

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubInt16DefObj readInt16DefByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubInt16DefObj readInt16DefByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubInt16DefObj readInt16DefByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubInt16DefObj readInt16DefByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of CFBamPubInt16DefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByScopeIdx( MCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubInt16DefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubInt16DefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubInt16DefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubInt16DefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubInt16DefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt16DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt16DefObj> readInt16DefByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamPubInt16DefObj readCachedInt16DefByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubInt16DefObj readCachedInt16DefByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	List<ICFBamPubInt16DefObj> readCachedInt16DefByScopeIdx( MCFDbKeyHash256 ScopeId );

	List<ICFBamPubInt16DefObj> readCachedInt16DefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubInt16DefObj> readCachedInt16DefByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubInt16DefObj> readCachedInt16DefByNextIdx( MCFDbKeyHash256 NextId );

	List<ICFBamPubInt16DefObj> readCachedInt16DefByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	List<ICFBamPubInt16DefObj> readCachedInt16DefByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	void deepDisposeInt16DefByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeInt16DefByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeInt16DefByScopeIdx( MCFDbKeyHash256 ScopeId );

	void deepDisposeInt16DefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeInt16DefByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeInt16DefByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeInt16DefByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeInt16DefByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubInt16DefObj updateInt16Def( ICFBamPubInt16DefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt16Def( ICFBamPubInt16DefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Move the CFBamPubInt16DefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubInt16DefObj refreshed cache instance.
	 */
	ICFBamPubInt16DefObj moveUpInt16Def( ICFBamPubInt16DefObj Obj );

	/**
	 *	Move the CFBamPubInt16DefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubInt16DefObj refreshed cache instance.
	 */
	ICFBamPubInt16DefObj moveDownInt16Def( ICFBamPubInt16DefObj Obj );
}
