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

public interface IBusModelPubInt32TypeTableObj
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
	 *	Instantiate a new Int32Type instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubInt32TypeObj newInstance();

	/**
	 *	Instantiate a new Int32Type edition of the specified Int32Type instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubInt32TypeEditObj newEditInstance( IBusModelPubInt32TypeObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubInt32TypeObj realiseInt32Type( IBusModelPubInt32TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubInt32TypeObj createInt32Type( IBusModelPubInt32TypeObj Obj );

	/**
	 *	Read a Int32Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int32Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubInt32TypeObj readInt32Type( IYCFKeyHash256 pkey );

	/**
	 *	Read a Int32Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int32Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubInt32TypeObj readInt32Type( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubInt32TypeObj readCachedInt32Type( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeInt32Type( IBusModelPubInt32TypeObj obj );

	void deepDisposeInt32Type( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubInt32TypeObj lockInt32Type( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Int32Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubInt32TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readAllInt32Type();

	/**
	 *	Return a sorted map of all the Int32Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubInt32TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readAllInt32Type( boolean forceRead );

	List<IBusModelPubInt32TypeObj> readCachedAllInt32Type();

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubInt32TypeObj readInt32TypeByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubInt32TypeObj readInt32TypeByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubInt32TypeObj readInt32TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubInt32TypeObj readInt32TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelPubInt32TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByScopeIdx( YCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubInt32TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubInt32TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubInt32TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubInt32TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubInt32TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubInt32TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Get the map of BusModelPubInt32TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubInt32TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubInt32TypeObj> readInt32TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId,
		boolean forceRead );

	IBusModelPubInt32TypeObj readCachedInt32TypeByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubInt32TypeObj readCachedInt32TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	List<IBusModelPubInt32TypeObj> readCachedInt32TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	List<IBusModelPubInt32TypeObj> readCachedInt32TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubInt32TypeObj> readCachedInt32TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	List<IBusModelPubInt32TypeObj> readCachedInt32TypeByNextIdx( YCFDbKeyHash256 NextId );

	List<IBusModelPubInt32TypeObj> readCachedInt32TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	List<IBusModelPubInt32TypeObj> readCachedInt32TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	List<IBusModelPubInt32TypeObj> readCachedInt32TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	void deepDisposeInt32TypeByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeInt32TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeInt32TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	void deepDisposeInt32TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeInt32TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeInt32TypeByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeInt32TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeInt32TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	void deepDisposeInt32TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubInt32TypeObj updateInt32Type( IBusModelPubInt32TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt32Type( IBusModelPubInt32TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Int32Type key attribute of the instance generating the id.
	 */
	void deleteInt32TypeByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int32Type key attribute of the instance generating the id.
	 */
	void deleteInt32TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 */
	void deleteInt32TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Int32Type key attribute of the instance generating the id.
	 */
	void deleteInt32TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 */
	void deleteInt32TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 */
	void deleteInt32TypeByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 */
	void deleteInt32TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 */
	void deleteInt32TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Int32Type key attribute of the instance generating the id.
	 */
	void deleteInt32TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Move the BusModelPubInt32TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubInt32TypeObj refreshed cache instance.
	 */
	IBusModelPubInt32TypeObj moveUpInt32Type( IBusModelPubInt32TypeObj Obj );

	/**
	 *	Move the BusModelPubInt32TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubInt32TypeObj refreshed cache instance.
	 */
	IBusModelPubInt32TypeObj moveDownInt32Type( IBusModelPubInt32TypeObj Obj );
}
