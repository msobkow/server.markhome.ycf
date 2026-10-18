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

public interface IBusModelPubParamTableObj
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
	 *	Instantiate a new Param instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubParamObj newInstance();

	/**
	 *	Instantiate a new Param edition of the specified Param instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubParamEditObj newEditInstance( IBusModelPubParamObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IBusModelPubParamObj instance, which may be a subclass of a Param instance.
	 */
	IBusModelPubParamObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IBusModelPubParamObj realiseParam( IBusModelPubParamObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubParamObj createParam( IBusModelPubParamObj Obj );

	/**
	 *	Read a Param-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Param-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubParamObj readParam( IYCFKeyHash256 pkey );

	/**
	 *	Read a Param-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Param-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubParamObj readParam( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubParamObj readCachedParam( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeParam( IBusModelPubParamObj obj );

	void deepDisposeParam( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubParamObj lockParam( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Param-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubParamObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubParamObj> readAllParam();

	/**
	 *	Return a sorted map of all the Param-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubParamObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubParamObj> readAllParam( boolean forceRead );

	List<IBusModelPubParamObj> readCachedAllParam();

	/**
	 *	Get the BusModelPubParamObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubParamObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubParamObj readParamByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubParamObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubParamObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubParamObj readParamByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubParamObj instance for the unique UNameIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubParamObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubParamObj readParamByUNameIdx(YCFDbKeyHash256 ServerMethodId,
		String Name );

	/**
	 *	Get the BusModelPubParamObj instance for the unique UNameIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubParamObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubParamObj readParamByUNameIdx(YCFDbKeyHash256 ServerMethodId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate ServerMethodIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate ServerMethodIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByServerMethodIdx( YCFDbKeyHash256 ServerMethodId );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate ServerMethodIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate ServerMethodIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByServerMethodIdx( YCFDbKeyHash256 ServerMethodId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate ServerTypeIdx key.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate ServerTypeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByServerTypeIdx( YCFDbKeyHash256 TypeId );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate ServerTypeIdx key.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate ServerTypeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByServerTypeIdx( YCFDbKeyHash256 TypeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByContPrevIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByContPrevIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByContNextIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubParamObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubParamObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubParamObj> readParamByContNextIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	IBusModelPubParamObj readCachedParamByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubParamObj readCachedParamByUNameIdx( YCFDbKeyHash256 ServerMethodId,
		String Name );

	List<IBusModelPubParamObj> readCachedParamByServerMethodIdx( YCFDbKeyHash256 ServerMethodId );

	List<IBusModelPubParamObj> readCachedParamByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubParamObj> readCachedParamByServerTypeIdx( YCFDbKeyHash256 TypeId );

	List<IBusModelPubParamObj> readCachedParamByPrevIdx( YCFDbKeyHash256 PrevId );

	List<IBusModelPubParamObj> readCachedParamByNextIdx( YCFDbKeyHash256 NextId );

	List<IBusModelPubParamObj> readCachedParamByContPrevIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId );

	List<IBusModelPubParamObj> readCachedParamByContNextIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId );

	void deepDisposeParamByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeParamByUNameIdx( YCFDbKeyHash256 ServerMethodId,
		String Name );

	void deepDisposeParamByServerMethodIdx( YCFDbKeyHash256 ServerMethodId );

	void deepDisposeParamByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeParamByServerTypeIdx( YCFDbKeyHash256 TypeId );

	void deepDisposeParamByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeParamByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeParamByContPrevIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeParamByContNextIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubParamObj updateParam( IBusModelPubParamObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteParam( IBusModelPubParamObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByUNameIdx(YCFDbKeyHash256 ServerMethodId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByServerMethodIdx( YCFDbKeyHash256 ServerMethodId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByServerTypeIdx( YCFDbKeyHash256 TypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByContPrevIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByContNextIdx( YCFDbKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Move the BusModelPubParamObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubParamObj refreshed cache instance.
	 */
	IBusModelPubParamObj moveUpParam( IBusModelPubParamObj Obj );

	/**
	 *	Move the BusModelPubParamObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubParamObj refreshed cache instance.
	 */
	IBusModelPubParamObj moveDownParam( IBusModelPubParamObj Obj );
}
