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

public interface IBusModelProtInt16DefTableObj
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
	 *	Instantiate a new Int16Def instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelProtInt16DefObj newInstance();

	/**
	 *	Instantiate a new Int16Def edition of the specified Int16Def instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelProtInt16DefEditObj newEditInstance( IBusModelProtInt16DefObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelProtInt16DefObj realiseInt16Def( IBusModelProtInt16DefObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelProtInt16DefObj createInt16Def( IBusModelProtInt16DefObj Obj );

	/**
	 *	Read a Int16Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtInt16DefObj readInt16Def( YCFDbKeyHash256 pkey );

	/**
	 *	Read a Int16Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtInt16DefObj readInt16Def( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IBusModelProtInt16DefObj readCachedInt16Def( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeInt16Def( IBusModelProtInt16DefObj obj );

	void deepDisposeInt16Def( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelProtInt16DefObj lockInt16Def( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Int16Def-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtInt16DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtInt16DefObj> readAllInt16Def();

	/**
	 *	Return a sorted map of all the Int16Def-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtInt16DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtInt16DefObj> readAllInt16Def( boolean forceRead );

	List<IBusModelProtInt16DefObj> readCachedAllInt16Def();

	/**
	 *	Get the IBusModelProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtInt16DefObj readInt16DefByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IBusModelProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtInt16DefObj readInt16DefByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the IBusModelProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtInt16DefObj readInt16DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the IBusModelProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtInt16DefObj readInt16DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of IBusModelProtInt16DefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16DefObj> readInt16DefByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	IBusModelProtValueObj readCachedInt16DefByIdIdx( IYCFKeyHash256 Id );

	IBusModelProtValueObj readCachedInt16DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<List<IBusModelProtValueObj>> readCachedInt16DefByScopeIdx( IYCFKeyHash256 ScopeId );

	List<List<IBusModelProtValueObj>> readCachedInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<List<IBusModelProtValueObj>> readCachedInt16DefByPrevIdx( YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtValueObj>> readCachedInt16DefByNextIdx( YCFDbKeyHash256 NextId );

	List<List<IBusModelProtValueObj>> readCachedInt16DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtValueObj>> readCachedInt16DefByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	void deepDisposeInt16DefByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeInt16DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeInt16DefByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeInt16DefByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeInt16DefByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeInt16DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeInt16DefByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelProtInt16DefObj updateInt16Def( IBusModelProtInt16DefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt16Def( IBusModelProtInt16DefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Def key attribute of the instance generating the id.
	 */
	void deleteInt16DefByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Move the IBusModelProtInt16DefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtInt16DefObj refreshed cache instance.
	 */
	IBusModelProtInt16DefObj moveUpInt16Def( IBusModelProtInt16DefObj Obj );

	/**
	 *	Move the IBusModelProtInt16DefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtInt16DefObj refreshed cache instance.
	 */
	IBusModelProtInt16DefObj moveDownInt16Def( IBusModelProtInt16DefObj Obj );
}
