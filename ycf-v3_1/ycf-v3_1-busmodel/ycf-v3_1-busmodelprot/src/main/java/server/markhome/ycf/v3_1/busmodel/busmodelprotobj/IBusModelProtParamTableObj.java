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

public interface IBusModelProtParamTableObj
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
	 *	Instantiate a new Param instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelProtParamObj newInstance();

	/**
	 *	Instantiate a new Param edition of the specified Param instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelProtParamEditObj newEditInstance( IBusModelProtParamObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IBusModelProtParamEditObj instance, which may be a subclass of a Param instance.
	 */
	IBusModelProtParamObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IBusModelProtParamObj realiseParam( IBusModelProtParamObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelProtParamObj createParam( IBusModelProtParamObj Obj );

	/**
	 *	Read a Param-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Param-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtParamObj readParam( YCFDbKeyHash256 pkey );

	/**
	 *	Read a Param-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Param-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtParamObj readParam( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IBusModelProtParamObj readCachedParam( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeParam( IBusModelProtParamObj obj );

	void deepDisposeParam( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelProtParamObj lockParam( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Param-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtParamObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtParamObj> readAllParam();

	/**
	 *	Return a sorted map of all the Param-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtParamObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtParamObj> readAllParam( boolean forceRead );

	List<IBusModelProtParamObj> readCachedAllParam();

	/**
	 *	Get the IBusModelProtParamObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtParamObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtParamObj readParamByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IBusModelProtParamObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtParamObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtParamObj readParamByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the IBusModelProtParamObj instance for the unique UNameIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtParamObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtParamObj readParamByUNameIdx(IYCFKeyHash256 ServerMethodId,
		String Name );

	/**
	 *	Get the IBusModelProtParamObj instance for the unique UNameIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtParamObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtParamObj readParamByUNameIdx(IYCFKeyHash256 ServerMethodId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate ServerMethodIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate ServerMethodIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate ServerMethodIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate ServerMethodIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate ServerTypeIdx key.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate ServerTypeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByServerTypeIdx( YCFDbKeyHash256 TypeId );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate ServerTypeIdx key.
	 *
	 *	@param	TypeId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate ServerTypeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByServerTypeIdx( YCFDbKeyHash256 TypeId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<IBusModelProtParamObj> instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtParamObj> cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtParamObj> readParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	IBusModelProtParamObj readCachedParamByIdIdx( IYCFKeyHash256 Id );

	IBusModelProtParamObj readCachedParamByUNameIdx( IYCFKeyHash256 ServerMethodId,
		String Name );

	List<List<IBusModelProtParamObj>> readCachedParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId );

	List<List<IBusModelProtParamObj>> readCachedParamByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<List<IBusModelProtParamObj>> readCachedParamByServerTypeIdx( YCFDbKeyHash256 TypeId );

	List<List<IBusModelProtParamObj>> readCachedParamByPrevIdx( YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtParamObj>> readCachedParamByNextIdx( YCFDbKeyHash256 NextId );

	List<List<IBusModelProtParamObj>> readCachedParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtParamObj>> readCachedParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId );

	void deepDisposeParamByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeParamByUNameIdx( IYCFKeyHash256 ServerMethodId,
		String Name );

	void deepDisposeParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId );

	void deepDisposeParamByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeParamByServerTypeIdx( YCFDbKeyHash256 TypeId );

	void deepDisposeParamByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeParamByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelProtParamObj updateParam( IBusModelProtParamObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteParam( IBusModelProtParamObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByUNameIdx(IYCFKeyHash256 ServerMethodId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId );

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
	void deleteParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServerMethodId	The Param key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Param key attribute of the instance generating the id.
	 */
	void deleteParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Move the IBusModelProtParamObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtParamObj refreshed cache instance.
	 */
	IBusModelProtParamObj moveUpParam( IBusModelProtParamObj Obj );

	/**
	 *	Move the IBusModelProtParamObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtParamObj refreshed cache instance.
	 */
	IBusModelProtParamObj moveDownParam( IBusModelProtParamObj Obj );
}
