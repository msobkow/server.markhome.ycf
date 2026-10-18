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

public interface ICFBamPubDbKeyHash128ColTableObj
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
	 *	Instantiate a new DbKeyHash128Col instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubDbKeyHash128ColObj newInstance();

	/**
	 *	Instantiate a new DbKeyHash128Col edition of the specified DbKeyHash128Col instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubDbKeyHash128ColEditObj newEditInstance( ICFBamPubDbKeyHash128ColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDbKeyHash128ColObj realiseDbKeyHash128Col( ICFBamPubDbKeyHash128ColObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDbKeyHash128ColObj createDbKeyHash128Col( ICFBamPubDbKeyHash128ColObj Obj );

	/**
	 *	Read a DbKeyHash128Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash128Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubDbKeyHash128ColObj readDbKeyHash128Col( IMCFKeyHash256 pkey );

	/**
	 *	Read a DbKeyHash128Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash128Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubDbKeyHash128ColObj readDbKeyHash128Col( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubDbKeyHash128ColObj readCachedDbKeyHash128Col( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeDbKeyHash128Col( ICFBamPubDbKeyHash128ColObj obj );

	void deepDisposeDbKeyHash128Col( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDbKeyHash128ColObj lockDbKeyHash128Col( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DbKeyHash128Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubDbKeyHash128ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readAllDbKeyHash128Col();

	/**
	 *	Return a sorted map of all the DbKeyHash128Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubDbKeyHash128ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readAllDbKeyHash128Col( boolean forceRead );

	List<ICFBamPubDbKeyHash128ColObj> readCachedAllDbKeyHash128Col();

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDbKeyHash128ColObj readDbKeyHash128ColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDbKeyHash128ColObj readDbKeyHash128ColByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDbKeyHash128ColObj readDbKeyHash128ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDbKeyHash128ColObj readDbKeyHash128ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of CFBamPubDbKeyHash128ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByScopeIdx( MCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubDbKeyHash128ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubDbKeyHash128ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubDbKeyHash128ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubDbKeyHash128ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubDbKeyHash128ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubDbKeyHash128ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Get the map of CFBamPubDbKeyHash128ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash128ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash128ColObj> readDbKeyHash128ColByTableIdx( MCFDbKeyHash256 TableId,
		boolean forceRead );

	ICFBamPubDbKeyHash128ColObj readCachedDbKeyHash128ColByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubDbKeyHash128ColObj readCachedDbKeyHash128ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	List<ICFBamPubDbKeyHash128ColObj> readCachedDbKeyHash128ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	List<ICFBamPubDbKeyHash128ColObj> readCachedDbKeyHash128ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubDbKeyHash128ColObj> readCachedDbKeyHash128ColByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubDbKeyHash128ColObj> readCachedDbKeyHash128ColByNextIdx( MCFDbKeyHash256 NextId );

	List<ICFBamPubDbKeyHash128ColObj> readCachedDbKeyHash128ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	List<ICFBamPubDbKeyHash128ColObj> readCachedDbKeyHash128ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	List<ICFBamPubDbKeyHash128ColObj> readCachedDbKeyHash128ColByTableIdx( MCFDbKeyHash256 TableId );

	void deepDisposeDbKeyHash128ColByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeDbKeyHash128ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeDbKeyHash128ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	void deepDisposeDbKeyHash128ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeDbKeyHash128ColByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash128ColByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash128ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash128ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash128ColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDbKeyHash128ColObj updateDbKeyHash128Col( ICFBamPubDbKeyHash128ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDbKeyHash128Col( ICFBamPubDbKeyHash128ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DbKeyHash128Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash128ColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash128Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash128ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash128ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DbKeyHash128Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash128ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DbKeyHash128Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash128ColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DbKeyHash128Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash128ColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash128Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash128ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash128Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash128Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash128ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The DbKeyHash128Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash128ColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Move the CFBamPubDbKeyHash128ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubDbKeyHash128ColObj refreshed cache instance.
	 */
	ICFBamPubDbKeyHash128ColObj moveUpDbKeyHash128Col( ICFBamPubDbKeyHash128ColObj Obj );

	/**
	 *	Move the CFBamPubDbKeyHash128ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubDbKeyHash128ColObj refreshed cache instance.
	 */
	ICFBamPubDbKeyHash128ColObj moveDownDbKeyHash128Col( ICFBamPubDbKeyHash128ColObj Obj );
}
