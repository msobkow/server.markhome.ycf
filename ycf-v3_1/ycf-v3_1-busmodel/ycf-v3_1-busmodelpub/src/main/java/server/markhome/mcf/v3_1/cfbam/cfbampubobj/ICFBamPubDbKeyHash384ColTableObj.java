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

public interface ICFBamPubDbKeyHash384ColTableObj
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
	 *	Instantiate a new DbKeyHash384Col instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubDbKeyHash384ColObj newInstance();

	/**
	 *	Instantiate a new DbKeyHash384Col edition of the specified DbKeyHash384Col instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubDbKeyHash384ColEditObj newEditInstance( ICFBamPubDbKeyHash384ColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDbKeyHash384ColObj realiseDbKeyHash384Col( ICFBamPubDbKeyHash384ColObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDbKeyHash384ColObj createDbKeyHash384Col( ICFBamPubDbKeyHash384ColObj Obj );

	/**
	 *	Read a DbKeyHash384Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash384Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubDbKeyHash384ColObj readDbKeyHash384Col( IMCFKeyHash256 pkey );

	/**
	 *	Read a DbKeyHash384Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash384Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubDbKeyHash384ColObj readDbKeyHash384Col( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubDbKeyHash384ColObj readCachedDbKeyHash384Col( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeDbKeyHash384Col( ICFBamPubDbKeyHash384ColObj obj );

	void deepDisposeDbKeyHash384Col( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDbKeyHash384ColObj lockDbKeyHash384Col( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DbKeyHash384Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubDbKeyHash384ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readAllDbKeyHash384Col();

	/**
	 *	Return a sorted map of all the DbKeyHash384Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubDbKeyHash384ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readAllDbKeyHash384Col( boolean forceRead );

	List<ICFBamPubDbKeyHash384ColObj> readCachedAllDbKeyHash384Col();

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDbKeyHash384ColObj readDbKeyHash384ColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDbKeyHash384ColObj readDbKeyHash384ColByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDbKeyHash384ColObj readDbKeyHash384ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDbKeyHash384ColObj readDbKeyHash384ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of CFBamPubDbKeyHash384ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByScopeIdx( MCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubDbKeyHash384ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubDbKeyHash384ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubDbKeyHash384ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubDbKeyHash384ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubDbKeyHash384ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubDbKeyHash384ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Get the map of CFBamPubDbKeyHash384ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDbKeyHash384ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDbKeyHash384ColObj> readDbKeyHash384ColByTableIdx( MCFDbKeyHash256 TableId,
		boolean forceRead );

	ICFBamPubDbKeyHash384ColObj readCachedDbKeyHash384ColByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubDbKeyHash384ColObj readCachedDbKeyHash384ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	List<ICFBamPubDbKeyHash384ColObj> readCachedDbKeyHash384ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	List<ICFBamPubDbKeyHash384ColObj> readCachedDbKeyHash384ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubDbKeyHash384ColObj> readCachedDbKeyHash384ColByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubDbKeyHash384ColObj> readCachedDbKeyHash384ColByNextIdx( MCFDbKeyHash256 NextId );

	List<ICFBamPubDbKeyHash384ColObj> readCachedDbKeyHash384ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	List<ICFBamPubDbKeyHash384ColObj> readCachedDbKeyHash384ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	List<ICFBamPubDbKeyHash384ColObj> readCachedDbKeyHash384ColByTableIdx( MCFDbKeyHash256 TableId );

	void deepDisposeDbKeyHash384ColByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeDbKeyHash384ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeDbKeyHash384ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	void deepDisposeDbKeyHash384ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeDbKeyHash384ColByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash384ColByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash384ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash384ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash384ColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDbKeyHash384ColObj updateDbKeyHash384Col( ICFBamPubDbKeyHash384ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDbKeyHash384Col( ICFBamPubDbKeyHash384ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DbKeyHash384Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384ColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash384Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384ColByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384ColByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DbKeyHash384Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384ColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DbKeyHash384Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384ColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DbKeyHash384Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384ColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash384Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384ColByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash384Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash384Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384ColByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The DbKeyHash384Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash384ColByTableIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Move the CFBamPubDbKeyHash384ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubDbKeyHash384ColObj refreshed cache instance.
	 */
	ICFBamPubDbKeyHash384ColObj moveUpDbKeyHash384Col( ICFBamPubDbKeyHash384ColObj Obj );

	/**
	 *	Move the CFBamPubDbKeyHash384ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubDbKeyHash384ColObj refreshed cache instance.
	 */
	ICFBamPubDbKeyHash384ColObj moveDownDbKeyHash384Col( ICFBamPubDbKeyHash384ColObj Obj );
}
