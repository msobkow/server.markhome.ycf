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

public interface IBusModelPubUuid6TypeTableObj
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
	 *	Instantiate a new Uuid6Type instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubUuid6TypeObj newInstance();

	/**
	 *	Instantiate a new Uuid6Type edition of the specified Uuid6Type instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubUuid6TypeEditObj newEditInstance( IBusModelPubUuid6TypeObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubUuid6TypeObj realiseUuid6Type( IBusModelPubUuid6TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubUuid6TypeObj createUuid6Type( IBusModelPubUuid6TypeObj Obj );

	/**
	 *	Read a Uuid6Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Uuid6Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubUuid6TypeObj readUuid6Type( IYCFKeyHash256 pkey );

	/**
	 *	Read a Uuid6Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Uuid6Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubUuid6TypeObj readUuid6Type( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubUuid6TypeObj readCachedUuid6Type( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeUuid6Type( IBusModelPubUuid6TypeObj obj );

	void deepDisposeUuid6Type( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubUuid6TypeObj lockUuid6Type( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Uuid6Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubUuid6TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readAllUuid6Type();

	/**
	 *	Return a sorted map of all the Uuid6Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubUuid6TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readAllUuid6Type( boolean forceRead );

	List<IBusModelPubUuid6TypeObj> readCachedAllUuid6Type();

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubUuid6TypeObj readUuid6TypeByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubUuid6TypeObj readUuid6TypeByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubUuid6TypeObj readUuid6TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubUuid6TypeObj readUuid6TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelPubUuid6TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByScopeIdx( YCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubUuid6TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubUuid6TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubUuid6TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubUuid6TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubUuid6TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubUuid6TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Get the map of BusModelPubUuid6TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUuid6TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUuid6TypeObj> readUuid6TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId,
		boolean forceRead );

	IBusModelPubUuid6TypeObj readCachedUuid6TypeByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubUuid6TypeObj readCachedUuid6TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	List<IBusModelPubUuid6TypeObj> readCachedUuid6TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	List<IBusModelPubUuid6TypeObj> readCachedUuid6TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubUuid6TypeObj> readCachedUuid6TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	List<IBusModelPubUuid6TypeObj> readCachedUuid6TypeByNextIdx( YCFDbKeyHash256 NextId );

	List<IBusModelPubUuid6TypeObj> readCachedUuid6TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	List<IBusModelPubUuid6TypeObj> readCachedUuid6TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	List<IBusModelPubUuid6TypeObj> readCachedUuid6TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	void deepDisposeUuid6TypeByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeUuid6TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeUuid6TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	void deepDisposeUuid6TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeUuid6TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeUuid6TypeByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeUuid6TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeUuid6TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	void deepDisposeUuid6TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubUuid6TypeObj updateUuid6Type( IBusModelPubUuid6TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUuid6Type( IBusModelPubUuid6TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Uuid6Type key attribute of the instance generating the id.
	 */
	void deleteUuid6TypeByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Uuid6Type key attribute of the instance generating the id.
	 */
	void deleteUuid6TypeByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 */
	void deleteUuid6TypeByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Uuid6Type key attribute of the instance generating the id.
	 */
	void deleteUuid6TypeByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Uuid6Type key attribute of the instance generating the id.
	 */
	void deleteUuid6TypeByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Uuid6Type key attribute of the instance generating the id.
	 */
	void deleteUuid6TypeByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Uuid6Type key attribute of the instance generating the id.
	 */
	void deleteUuid6TypeByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Uuid6Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Uuid6Type key attribute of the instance generating the id.
	 */
	void deleteUuid6TypeByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Uuid6Type key attribute of the instance generating the id.
	 */
	void deleteUuid6TypeBySchemaIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Move the BusModelPubUuid6TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubUuid6TypeObj refreshed cache instance.
	 */
	IBusModelPubUuid6TypeObj moveUpUuid6Type( IBusModelPubUuid6TypeObj Obj );

	/**
	 *	Move the BusModelPubUuid6TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubUuid6TypeObj refreshed cache instance.
	 */
	IBusModelPubUuid6TypeObj moveDownUuid6Type( IBusModelPubUuid6TypeObj Obj );
}
