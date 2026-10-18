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

public interface ICFBamProtIndexColTableObj
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
	 *	Instantiate a new IndexCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtIndexColObj newInstance();

	/**
	 *	Instantiate a new IndexCol edition of the specified IndexCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtIndexColEditObj newEditInstance( ICFBamProtIndexColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtIndexColObj realiseIndexCol( ICFBamProtIndexColObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtIndexColObj createIndexCol( ICFBamProtIndexColObj Obj );

	/**
	 *	Read a IndexCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtIndexColObj readIndexCol( MCFDbKeyHash256 pkey );

	/**
	 *	Read a IndexCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtIndexColObj readIndexCol( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtIndexColObj readCachedIndexCol( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeIndexCol( ICFBamProtIndexColObj obj );

	void deepDisposeIndexCol( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtIndexColObj lockIndexCol( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the IndexCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtIndexColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtIndexColObj> readAllIndexCol();

	/**
	 *	Return a sorted map of all the IndexCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtIndexColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtIndexColObj> readAllIndexCol( boolean forceRead );

	List<ICFBamProtIndexColObj> readCachedAllIndexCol();

	/**
	 *	Get the ICFBamProtIndexColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtIndexColObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtIndexColObj readIndexColByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtIndexColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtIndexColObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtIndexColObj readIndexColByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtIndexColObj instance for the unique UNameIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtIndexColObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtIndexColObj readIndexColByUNameIdx(IMCFKeyHash256 IndexId,
		String Name );

	/**
	 *	Get the ICFBamProtIndexColObj instance for the unique UNameIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtIndexColObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtIndexColObj readIndexColByUNameIdx(IMCFKeyHash256 IndexId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByIndexIdx( IMCFKeyHash256 IndexId );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByIndexIdx( IMCFKeyHash256 IndexId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate ColIdx key.
	 *
	 *	@param	ColumnId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate ColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByColIdx( IMCFKeyHash256 ColumnId );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate ColIdx key.
	 *
	 *	@param	ColumnId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate ColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByColIdx( IMCFKeyHash256 ColumnId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate IdxPrevIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate IdxPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByIdxPrevIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate IdxPrevIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate IdxPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByIdxPrevIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate IdxNextIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate IdxNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByIdxNextIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<ICFBamProtIndexColObj> instances sorted by their primary keys for the duplicate IdxNextIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtIndexColObj> cached instances sorted by their primary keys for the duplicate IdxNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtIndexColObj> readIndexColByIdxNextIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamProtIndexColObj readCachedIndexColByIdIdx( IMCFKeyHash256 Id );

	ICFBamProtIndexColObj readCachedIndexColByUNameIdx( IMCFKeyHash256 IndexId,
		String Name );

	List<List<ICFBamProtIndexColObj>> readCachedIndexColByIndexIdx( IMCFKeyHash256 IndexId );

	List<List<ICFBamProtIndexColObj>> readCachedIndexColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<List<ICFBamProtIndexColObj>> readCachedIndexColByColIdx( IMCFKeyHash256 ColumnId );

	List<List<ICFBamProtIndexColObj>> readCachedIndexColByPrevIdx( MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtIndexColObj>> readCachedIndexColByNextIdx( MCFDbKeyHash256 NextId );

	List<List<ICFBamProtIndexColObj>> readCachedIndexColByIdxPrevIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtIndexColObj>> readCachedIndexColByIdxNextIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 NextId );

	void deepDisposeIndexColByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeIndexColByUNameIdx( IMCFKeyHash256 IndexId,
		String Name );

	void deepDisposeIndexColByIndexIdx( IMCFKeyHash256 IndexId );

	void deepDisposeIndexColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeIndexColByColIdx( IMCFKeyHash256 ColumnId );

	void deepDisposeIndexColByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeIndexColByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeIndexColByIdxPrevIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeIndexColByIdxNextIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtIndexColObj updateIndexCol( ICFBamProtIndexColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteIndexCol( ICFBamProtIndexColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByUNameIdx(IMCFKeyHash256 IndexId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIndexIdx( IMCFKeyHash256 IndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ColumnId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByColIdx( IMCFKeyHash256 ColumnId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdxPrevIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdxNextIdx( IMCFKeyHash256 IndexId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Move the ICFBamProtIndexColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtIndexColObj refreshed cache instance.
	 */
	ICFBamProtIndexColObj moveUpIndexCol( ICFBamProtIndexColObj Obj );

	/**
	 *	Move the ICFBamProtIndexColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtIndexColObj refreshed cache instance.
	 */
	ICFBamProtIndexColObj moveDownIndexCol( ICFBamProtIndexColObj Obj );
}
