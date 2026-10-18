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

public interface ICFBamPubInt64ColTableObj
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
	 *	Instantiate a new Int64Col instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubInt64ColObj newInstance();

	/**
	 *	Instantiate a new Int64Col edition of the specified Int64Col instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubInt64ColEditObj newEditInstance( ICFBamPubInt64ColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubInt64ColObj realiseInt64Col( ICFBamPubInt64ColObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubInt64ColObj createInt64Col( ICFBamPubInt64ColObj Obj );

	/**
	 *	Read a Int64Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubInt64ColObj readInt64Col( IMCFKeyHash256 pkey );

	/**
	 *	Read a Int64Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubInt64ColObj readInt64Col( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubInt64ColObj readCachedInt64Col( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeInt64Col( ICFBamPubInt64ColObj obj );

	void deepDisposeInt64Col( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubInt64ColObj lockInt64Col( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Int64Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubInt64ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubInt64ColObj> readAllInt64Col();

	/**
	 *	Return a sorted map of all the Int64Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubInt64ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubInt64ColObj> readAllInt64Col( boolean forceRead );

	List<ICFBamPubInt64ColObj> readCachedAllInt64Col();

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubInt64ColObj readInt64ColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubInt64ColObj readInt64ColByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubInt64ColObj readInt64ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubInt64ColObj readInt64ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of CFBamPubInt64ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByScopeIdx( MCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubInt64ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubInt64ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubInt64ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubInt64ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubInt64ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubInt64ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Get the map of CFBamPubInt64ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubInt64ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubInt64ColObj> readInt64ColByTableIdx( MCFDbKeyHash256 TableId,
		boolean forceRead );

	ICFBamPubInt64ColObj readCachedInt64ColByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubInt64ColObj readCachedInt64ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	List<ICFBamPubInt64ColObj> readCachedInt64ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	List<ICFBamPubInt64ColObj> readCachedInt64ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubInt64ColObj> readCachedInt64ColByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubInt64ColObj> readCachedInt64ColByNextIdx( MCFDbKeyHash256 NextId );

	List<ICFBamPubInt64ColObj> readCachedInt64ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	List<ICFBamPubInt64ColObj> readCachedInt64ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	List<ICFBamPubInt64ColObj> readCachedInt64ColByTableIdx( MCFDbKeyHash256 TableId );

	void deepDisposeInt64ColByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeInt64ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeInt64ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	void deepDisposeInt64ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeInt64ColByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeInt64ColByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeInt64ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeInt64ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	void deepDisposeInt64ColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubInt64ColObj updateInt64Col( ICFBamPubInt64ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt64Col( ICFBamPubInt64ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Move the CFBamPubInt64ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubInt64ColObj refreshed cache instance.
	 */
	ICFBamPubInt64ColObj moveUpInt64Col( ICFBamPubInt64ColObj Obj );

	/**
	 *	Move the CFBamPubInt64ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubInt64ColObj refreshed cache instance.
	 */
	ICFBamPubInt64ColObj moveDownInt64Col( ICFBamPubInt64ColObj Obj );
}
