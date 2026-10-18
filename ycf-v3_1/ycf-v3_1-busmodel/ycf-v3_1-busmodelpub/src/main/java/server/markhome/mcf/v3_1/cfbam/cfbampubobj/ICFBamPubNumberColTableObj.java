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

public interface ICFBamPubNumberColTableObj
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
	 *	Instantiate a new NumberCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubNumberColObj newInstance();

	/**
	 *	Instantiate a new NumberCol edition of the specified NumberCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubNumberColEditObj newEditInstance( ICFBamPubNumberColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubNumberColObj realiseNumberCol( ICFBamPubNumberColObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubNumberColObj createNumberCol( ICFBamPubNumberColObj Obj );

	/**
	 *	Read a NumberCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NumberCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubNumberColObj readNumberCol( IMCFKeyHash256 pkey );

	/**
	 *	Read a NumberCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NumberCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubNumberColObj readNumberCol( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubNumberColObj readCachedNumberCol( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeNumberCol( ICFBamPubNumberColObj obj );

	void deepDisposeNumberCol( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubNumberColObj lockNumberCol( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the NumberCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubNumberColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubNumberColObj> readAllNumberCol();

	/**
	 *	Return a sorted map of all the NumberCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubNumberColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubNumberColObj> readAllNumberCol( boolean forceRead );

	List<ICFBamPubNumberColObj> readCachedAllNumberCol();

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubNumberColObj readNumberColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubNumberColObj readNumberColByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubNumberColObj readNumberColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubNumberColObj readNumberColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of CFBamPubNumberColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByScopeIdx( MCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubNumberColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubNumberColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubNumberColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubNumberColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubNumberColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubNumberColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Get the map of CFBamPubNumberColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubNumberColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubNumberColObj> readNumberColByTableIdx( MCFDbKeyHash256 TableId,
		boolean forceRead );

	ICFBamPubNumberColObj readCachedNumberColByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubNumberColObj readCachedNumberColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	List<ICFBamPubNumberColObj> readCachedNumberColByScopeIdx( MCFDbKeyHash256 ScopeId );

	List<ICFBamPubNumberColObj> readCachedNumberColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubNumberColObj> readCachedNumberColByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubNumberColObj> readCachedNumberColByNextIdx( MCFDbKeyHash256 NextId );

	List<ICFBamPubNumberColObj> readCachedNumberColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	List<ICFBamPubNumberColObj> readCachedNumberColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	List<ICFBamPubNumberColObj> readCachedNumberColByTableIdx( MCFDbKeyHash256 TableId );

	void deepDisposeNumberColByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeNumberColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeNumberColByScopeIdx( MCFDbKeyHash256 ScopeId );

	void deepDisposeNumberColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeNumberColByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeNumberColByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeNumberColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeNumberColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	void deepDisposeNumberColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubNumberColObj updateNumberCol( ICFBamPubNumberColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteNumberCol( ICFBamPubNumberColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Move the CFBamPubNumberColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubNumberColObj refreshed cache instance.
	 */
	ICFBamPubNumberColObj moveUpNumberCol( ICFBamPubNumberColObj Obj );

	/**
	 *	Move the CFBamPubNumberColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubNumberColObj refreshed cache instance.
	 */
	ICFBamPubNumberColObj moveDownNumberCol( ICFBamPubNumberColObj Obj );
}
