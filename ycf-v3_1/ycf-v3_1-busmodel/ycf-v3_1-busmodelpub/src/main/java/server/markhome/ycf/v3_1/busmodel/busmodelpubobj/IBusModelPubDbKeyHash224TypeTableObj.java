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

public interface IBusModelPubDbKeyHash224TypeTableObj
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
	 *	Instantiate a new DbKeyHash224Type instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubDbKeyHash224TypeObj newInstance();

	/**
	 *	Instantiate a new DbKeyHash224Type edition of the specified DbKeyHash224Type instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubDbKeyHash224TypeEditObj newEditInstance( IBusModelPubDbKeyHash224TypeObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDbKeyHash224TypeObj realiseDbKeyHash224Type( IBusModelPubDbKeyHash224TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDbKeyHash224TypeObj createDbKeyHash224Type( IBusModelPubDbKeyHash224TypeObj Obj );

	/**
	 *	Read a DbKeyHash224Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash224Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubDbKeyHash224TypeObj readDbKeyHash224Type( IYCFKeyHash256 pkey );

	/**
	 *	Read a DbKeyHash224Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash224Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubDbKeyHash224TypeObj readDbKeyHash224Type( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubDbKeyHash224TypeObj readCachedDbKeyHash224Type( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeDbKeyHash224Type( IBusModelPubDbKeyHash224TypeObj obj );

	void deepDisposeDbKeyHash224Type( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDbKeyHash224TypeObj lockDbKeyHash224Type( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DbKeyHash224Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubDbKeyHash224TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readAllDbKeyHash224Type();

	/**
	 *	Return a sorted map of all the DbKeyHash224Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubDbKeyHash224TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readAllDbKeyHash224Type( boolean forceRead );

	List<IBusModelPubDbKeyHash224TypeObj> readCachedAllDbKeyHash224Type();

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDbKeyHash224TypeObj readDbKeyHash224TypeByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDbKeyHash224TypeObj readDbKeyHash224TypeByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDbKeyHash224TypeObj readDbKeyHash224TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDbKeyHash224TypeObj readDbKeyHash224TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelPubDbKeyHash224TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByScopeIdx( YCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubDbKeyHash224TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubDbKeyHash224TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubDbKeyHash224TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubDbKeyHash224TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubDbKeyHash224TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubDbKeyHash224TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Get the map of BusModelPubDbKeyHash224TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDbKeyHash224TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDbKeyHash224TypeObj> readDbKeyHash224TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId,
		boolean forceRead );

	IBusModelPubDbKeyHash224TypeObj readCachedDbKeyHash224TypeByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubDbKeyHash224TypeObj readCachedDbKeyHash224TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	List<IBusModelPubDbKeyHash224TypeObj> readCachedDbKeyHash224TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	List<IBusModelPubDbKeyHash224TypeObj> readCachedDbKeyHash224TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubDbKeyHash224TypeObj> readCachedDbKeyHash224TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	List<IBusModelPubDbKeyHash224TypeObj> readCachedDbKeyHash224TypeByNextIdx( YCFDbKeyHash256 NextId );

	List<IBusModelPubDbKeyHash224TypeObj> readCachedDbKeyHash224TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	List<IBusModelPubDbKeyHash224TypeObj> readCachedDbKeyHash224TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	List<IBusModelPubDbKeyHash224TypeObj> readCachedDbKeyHash224TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	void deepDisposeDbKeyHash224TypeByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeDbKeyHash224TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeDbKeyHash224TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	void deepDisposeDbKeyHash224TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeDbKeyHash224TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash224TypeByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash224TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash224TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash224TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDbKeyHash224TypeObj updateDbKeyHash224Type( IBusModelPubDbKeyHash224TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDbKeyHash224Type( IBusModelPubDbKeyHash224TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DbKeyHash224Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash224TypeByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash224Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash224TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash224TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DbKeyHash224Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash224TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DbKeyHash224Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash224TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DbKeyHash224Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash224TypeByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash224Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash224TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash224Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash224Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash224TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The DbKeyHash224Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash224TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Move the BusModelPubDbKeyHash224TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubDbKeyHash224TypeObj refreshed cache instance.
	 */
	IBusModelPubDbKeyHash224TypeObj moveUpDbKeyHash224Type( IBusModelPubDbKeyHash224TypeObj Obj );

	/**
	 *	Move the BusModelPubDbKeyHash224TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubDbKeyHash224TypeObj refreshed cache instance.
	 */
	IBusModelPubDbKeyHash224TypeObj moveDownDbKeyHash224Type( IBusModelPubDbKeyHash224TypeObj Obj );
}
