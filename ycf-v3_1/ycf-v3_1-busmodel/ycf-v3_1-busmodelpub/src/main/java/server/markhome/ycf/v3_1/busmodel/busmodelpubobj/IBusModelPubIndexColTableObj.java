// Description: Java 25 Public Table Object interface for BusModelPub.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
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
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelpubobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IBusModelPubIndexColTableObj
{
	public IBusModelPubSchemaObj getSchema();
	public void setSchema( IBusModelPubSchemaObj value );

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
	IBusModelPubIndexColObj newInstance();

	/**
	 *	Instantiate a new IndexCol edition of the specified IndexCol instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubIndexColEditObj newEditInstance( IBusModelPubIndexColObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IBusModelPubIndexColObj instance, which may be a subclass of a IndexCol instance.
	 */
	IBusModelPubIndexColObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IBusModelPubIndexColObj realiseIndexCol( IBusModelPubIndexColObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubIndexColObj createIndexCol( IBusModelPubIndexColObj Obj );

	/**
	 *	Read a IndexCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubIndexColObj readIndexCol( IYCFKeyHash256 pkey );

	/**
	 *	Read a IndexCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubIndexColObj readIndexCol( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubIndexColObj readCachedIndexCol( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeIndexCol( IBusModelPubIndexColObj obj );

	void deepDisposeIndexCol( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubIndexColObj lockIndexCol( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the IndexCol-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubIndexColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubIndexColObj> readAllIndexCol();

	/**
	 *	Return a sorted map of all the IndexCol-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubIndexColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubIndexColObj> readAllIndexCol( boolean forceRead );

	List<IBusModelPubIndexColObj> readCachedAllIndexCol();

	/**
	 *	Get the BusModelPubIndexColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubIndexColObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexColObj readIndexColByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubIndexColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubIndexColObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexColObj readIndexColByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubIndexColObj instance for the unique UNameIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubIndexColObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexColObj readIndexColByUNameIdx(YCFDbKeyHash256 IndexId,
		String Name );

	/**
	 *	Get the BusModelPubIndexColObj instance for the unique UNameIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubIndexColObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexColObj readIndexColByUNameIdx(YCFDbKeyHash256 IndexId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByIndexIdx( YCFDbKeyHash256 IndexId );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByIndexIdx( YCFDbKeyHash256 IndexId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate ColIdx key.
	 *
	 *	@param	ColumnId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate ColIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByColIdx( YCFDbKeyHash256 ColumnId );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate ColIdx key.
	 *
	 *	@param	ColumnId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate ColIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByColIdx( YCFDbKeyHash256 ColumnId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate IdxPrevIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate IdxPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByIdxPrevIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate IdxPrevIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate IdxPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByIdxPrevIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate IdxNextIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate IdxNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByIdxNextIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubIndexColObj instances sorted by their primary keys for the duplicate IdxNextIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexColObj cached instances sorted by their primary keys for the duplicate IdxNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexColObj> readIndexColByIdxNextIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	IBusModelPubIndexColObj readCachedIndexColByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubIndexColObj readCachedIndexColByUNameIdx( YCFDbKeyHash256 IndexId,
		String Name );

	List<IBusModelPubIndexColObj> readCachedIndexColByIndexIdx( YCFDbKeyHash256 IndexId );

	List<IBusModelPubIndexColObj> readCachedIndexColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubIndexColObj> readCachedIndexColByColIdx( YCFDbKeyHash256 ColumnId );

	List<IBusModelPubIndexColObj> readCachedIndexColByPrevIdx( YCFDbKeyHash256 PrevId );

	List<IBusModelPubIndexColObj> readCachedIndexColByNextIdx( YCFDbKeyHash256 NextId );

	List<IBusModelPubIndexColObj> readCachedIndexColByIdxPrevIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 PrevId );

	List<IBusModelPubIndexColObj> readCachedIndexColByIdxNextIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 NextId );

	void deepDisposeIndexColByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeIndexColByUNameIdx( YCFDbKeyHash256 IndexId,
		String Name );

	void deepDisposeIndexColByIndexIdx( YCFDbKeyHash256 IndexId );

	void deepDisposeIndexColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeIndexColByColIdx( YCFDbKeyHash256 ColumnId );

	void deepDisposeIndexColByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeIndexColByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeIndexColByIdxPrevIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeIndexColByIdxNextIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubIndexColObj updateIndexCol( IBusModelPubIndexColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteIndexCol( IBusModelPubIndexColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByUNameIdx(YCFDbKeyHash256 IndexId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIndexIdx( YCFDbKeyHash256 IndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ColumnId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByColIdx( YCFDbKeyHash256 ColumnId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdxPrevIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdxNextIdx( YCFDbKeyHash256 IndexId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Move the BusModelPubIndexColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubIndexColObj refreshed cache instance.
	 */
	IBusModelPubIndexColObj moveUpIndexCol( IBusModelPubIndexColObj Obj );

	/**
	 *	Move the BusModelPubIndexColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubIndexColObj refreshed cache instance.
	 */
	IBusModelPubIndexColObj moveDownIndexCol( IBusModelPubIndexColObj Obj );
}
