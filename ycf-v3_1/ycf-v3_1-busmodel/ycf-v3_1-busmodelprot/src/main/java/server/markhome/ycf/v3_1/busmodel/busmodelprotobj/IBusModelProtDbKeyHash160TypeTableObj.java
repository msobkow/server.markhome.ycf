// Description: Java 25 Protected Table Object interface for BusModelProt.

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

package server.markhome.ycf.v3_1.busmodel.busmodelprotobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;

public interface IBusModelProtDbKeyHash160TypeTableObj
{
	public IBusModelProtSchemaObj getSchema();
	public void setSchema( IBusModelProtSchemaObj value );

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
	 *	Instantiate a new DbKeyHash160Type instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelProtDbKeyHash160TypeObj newInstance();

	/**
	 *	Instantiate a new DbKeyHash160Type edition of the specified DbKeyHash160Type instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelProtDbKeyHash160TypeEditObj newEditInstance( IBusModelProtDbKeyHash160TypeObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDbKeyHash160TypeObj realiseDbKeyHash160Type( IBusModelProtDbKeyHash160TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDbKeyHash160TypeObj createDbKeyHash160Type( IBusModelProtDbKeyHash160TypeObj Obj );

	/**
	 *	Read a DbKeyHash160Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash160Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtDbKeyHash160TypeObj readDbKeyHash160Type( YCFDbKeyHash256 pkey );

	/**
	 *	Read a DbKeyHash160Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash160Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtDbKeyHash160TypeObj readDbKeyHash160Type( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IBusModelProtDbKeyHash160TypeObj readCachedDbKeyHash160Type( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeDbKeyHash160Type( IBusModelProtDbKeyHash160TypeObj obj );

	void deepDisposeDbKeyHash160Type( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDbKeyHash160TypeObj lockDbKeyHash160Type( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DbKeyHash160Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readAllDbKeyHash160Type();

	/**
	 *	Return a sorted map of all the DbKeyHash160Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readAllDbKeyHash160Type( boolean forceRead );

	List<IBusModelProtDbKeyHash160TypeObj> readCachedAllDbKeyHash160Type();

	/**
	 *	Get the IBusModelProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDbKeyHash160TypeObj readDbKeyHash160TypeByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IBusModelProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDbKeyHash160TypeObj readDbKeyHash160TypeByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the IBusModelProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDbKeyHash160TypeObj readDbKeyHash160TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the IBusModelProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDbKeyHash160TypeObj readDbKeyHash160TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtDbKeyHash160TypeObj> instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDbKeyHash160TypeObj> cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Get the map of List<IBusModelProtDbKeyHash160TypeObj> instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDbKeyHash160TypeObj> cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160TypeObj> readDbKeyHash160TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead );

	IBusModelProtValueObj readCachedDbKeyHash160TypeByIdIdx( IYCFKeyHash256 Id );

	IBusModelProtValueObj readCachedDbKeyHash160TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160TypeByScopeIdx( IYCFKeyHash256 ScopeId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160TypeByNextIdx( YCFDbKeyHash256 NextId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	List<List<IBusModelProtDbKeyHash160TypeObj>> readCachedDbKeyHash160TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	void deepDisposeDbKeyHash160TypeByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeDbKeyHash160TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeDbKeyHash160TypeByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeDbKeyHash160TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeDbKeyHash160TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash160TypeByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash160TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash160TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash160TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDbKeyHash160TypeObj updateDbKeyHash160Type( IBusModelProtDbKeyHash160TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDbKeyHash160Type( IBusModelProtDbKeyHash160TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DbKeyHash160Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160TypeByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash160Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160TypeByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DbKeyHash160Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DbKeyHash160Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DbKeyHash160Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160TypeByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash160Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash160Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash160Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The DbKeyHash160Type key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Move the IBusModelProtDbKeyHash160TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtDbKeyHash160TypeObj refreshed cache instance.
	 */
	IBusModelProtDbKeyHash160TypeObj moveUpDbKeyHash160Type( IBusModelProtDbKeyHash160TypeObj Obj );

	/**
	 *	Move the IBusModelProtDbKeyHash160TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtDbKeyHash160TypeObj refreshed cache instance.
	 */
	IBusModelProtDbKeyHash160TypeObj moveDownDbKeyHash160Type( IBusModelProtDbKeyHash160TypeObj Obj );
}
