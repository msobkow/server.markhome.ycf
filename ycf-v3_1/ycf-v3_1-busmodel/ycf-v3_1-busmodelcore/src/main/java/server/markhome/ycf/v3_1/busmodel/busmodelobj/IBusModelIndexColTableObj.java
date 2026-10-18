// Description: Java 25 Table Object interface for BusModel.

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

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

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
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public interface IBusModelIndexColTableObj
{
	public IBusModelSchemaObj getSchema();
	public void setSchema( IBusModelSchemaObj value );

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
	IBusModelIndexColObj newInstance();

	/**
	 *	Instantiate a new IndexCol edition of the specified IndexCol instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelIndexColEditObj newEditInstance( IBusModelIndexColObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IBusModelIndexColObj instance, which may be a subclass of a IndexCol instance.
	 */
	IBusModelIndexColObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IBusModelIndexColObj realiseIndexCol( IBusModelIndexColObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelIndexColObj createIndexCol( IBusModelIndexColObj Obj );

	/**
	 *	Read a IndexCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelIndexColObj readIndexCol( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a IndexCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelIndexColObj readIndexCol( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelIndexColObj readCachedIndexCol( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeIndexCol( IBusModelIndexColObj obj );

	void deepDisposeIndexCol( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelIndexColObj lockIndexCol( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the IndexCol-derived instances in the database.
	 *
	 *	@return	List of IBusModelIndexColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelIndexColObj> readAllIndexCol();

	/**
	 *	Return a sorted map of all the IndexCol-derived instances in the database.
	 *
	 *	@return	List of IBusModelIndexColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelIndexColObj> readAllIndexCol( boolean forceRead );

	List<IBusModelIndexColObj> readCachedAllIndexCol();

	/**
	 *	Get the BusModelIndexColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelIndexColObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelIndexColObj readIndexColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelIndexColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelIndexColObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelIndexColObj readIndexColByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelIndexColObj instance for the unique UNameIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelIndexColObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelIndexColObj readIndexColByUNameIdx(IYCFKeyHash256 IndexId,
		String Name );

	/**
	 *	Get the BusModelIndexColObj instance for the unique UNameIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelIndexColObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelIndexColObj readIndexColByUNameIdx(IYCFKeyHash256 IndexId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByIndexIdx( IYCFKeyHash256 IndexId );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByIndexIdx( IYCFKeyHash256 IndexId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate ColIdx key.
	 *
	 *	@param	ColumnId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate ColIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByColIdx( IYCFKeyHash256 ColumnId );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate ColIdx key.
	 *
	 *	@param	ColumnId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate ColIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByColIdx( IYCFKeyHash256 ColumnId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate IdxPrevIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate IdxPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate IdxPrevIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate IdxPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate IdxNextIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate IdxNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelIndexColObj instances sorted by their primary keys for the duplicate IdxNextIdx key.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelIndexColObj cached instances sorted by their primary keys for the duplicate IdxNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelIndexColObj> readIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	IBusModelIndexColObj readCachedIndexColByIdIdx( IYCFKeyHash256 Id );

	IBusModelIndexColObj readCachedIndexColByUNameIdx( IYCFKeyHash256 IndexId,
		String Name );

	List<IBusModelIndexColObj> readCachedIndexColByIndexIdx( IYCFKeyHash256 IndexId );

	List<IBusModelIndexColObj> readCachedIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelIndexColObj> readCachedIndexColByColIdx( IYCFKeyHash256 ColumnId );

	List<IBusModelIndexColObj> readCachedIndexColByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelIndexColObj> readCachedIndexColByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelIndexColObj> readCachedIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId );

	List<IBusModelIndexColObj> readCachedIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId );

	void deepDisposeIndexColByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeIndexColByUNameIdx( IYCFKeyHash256 IndexId,
		String Name );

	void deepDisposeIndexColByIndexIdx( IYCFKeyHash256 IndexId );

	void deepDisposeIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeIndexColByColIdx( IYCFKeyHash256 ColumnId );

	void deepDisposeIndexColByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeIndexColByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId );

	void deepDisposeIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelIndexColObj updateIndexCol( IBusModelIndexColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteIndexCol( IBusModelIndexColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByUNameIdx(IYCFKeyHash256 IndexId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIndexIdx( IYCFKeyHash256 IndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ColumnId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByColIdx( IYCFKeyHash256 ColumnId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The IndexCol key attribute of the instance generating the id.
	 */
	void deleteIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId );

	/**
	 *	Move the BusModelIndexColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelIndexColObj refreshed cache instance.
	 */
	IBusModelIndexColObj moveUpIndexCol( IBusModelIndexColObj Obj );

	/**
	 *	Move the BusModelIndexColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelIndexColObj refreshed cache instance.
	 */
	IBusModelIndexColObj moveDownIndexCol( IBusModelIndexColObj Obj );
}
