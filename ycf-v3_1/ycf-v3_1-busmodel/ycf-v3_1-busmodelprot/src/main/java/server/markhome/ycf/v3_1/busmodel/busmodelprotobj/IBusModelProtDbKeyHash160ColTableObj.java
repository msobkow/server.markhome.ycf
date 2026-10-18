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

public interface IBusModelProtDbKeyHash160ColTableObj
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
	 *	Instantiate a new DbKeyHash160Col instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelProtDbKeyHash160ColObj newInstance();

	/**
	 *	Instantiate a new DbKeyHash160Col edition of the specified DbKeyHash160Col instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelProtDbKeyHash160ColEditObj newEditInstance( IBusModelProtDbKeyHash160ColObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDbKeyHash160ColObj realiseDbKeyHash160Col( IBusModelProtDbKeyHash160ColObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDbKeyHash160ColObj createDbKeyHash160Col( IBusModelProtDbKeyHash160ColObj Obj );

	/**
	 *	Read a DbKeyHash160Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash160Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtDbKeyHash160ColObj readDbKeyHash160Col( YCFDbKeyHash256 pkey );

	/**
	 *	Read a DbKeyHash160Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash160Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtDbKeyHash160ColObj readDbKeyHash160Col( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IBusModelProtDbKeyHash160ColObj readCachedDbKeyHash160Col( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeDbKeyHash160Col( IBusModelProtDbKeyHash160ColObj obj );

	void deepDisposeDbKeyHash160Col( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDbKeyHash160ColObj lockDbKeyHash160Col( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DbKeyHash160Col-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readAllDbKeyHash160Col();

	/**
	 *	Return a sorted map of all the DbKeyHash160Col-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readAllDbKeyHash160Col( boolean forceRead );

	List<IBusModelProtDbKeyHash160ColObj> readCachedAllDbKeyHash160Col();

	/**
	 *	Get the IBusModelProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDbKeyHash160ColObj readDbKeyHash160ColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IBusModelProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDbKeyHash160ColObj readDbKeyHash160ColByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the IBusModelProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDbKeyHash160ColObj readDbKeyHash160ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the IBusModelProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDbKeyHash160ColObj readDbKeyHash160ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of IBusModelProtDbKeyHash160ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDbKeyHash160ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtDbKeyHash160ColObj> instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDbKeyHash160ColObj> cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Get the map of List<IBusModelProtDbKeyHash160ColObj> instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDbKeyHash160ColObj> cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDbKeyHash160ColObj> readDbKeyHash160ColByTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead );

	IBusModelProtValueObj readCachedDbKeyHash160ColByIdIdx( IYCFKeyHash256 Id );

	IBusModelProtValueObj readCachedDbKeyHash160ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160ColByScopeIdx( IYCFKeyHash256 ScopeId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160ColByPrevIdx( YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160ColByNextIdx( YCFDbKeyHash256 NextId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtValueObj>> readCachedDbKeyHash160ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	List<List<IBusModelProtDbKeyHash160ColObj>> readCachedDbKeyHash160ColByTableIdx( IYCFKeyHash256 TableId );

	void deepDisposeDbKeyHash160ColByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeDbKeyHash160ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeDbKeyHash160ColByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeDbKeyHash160ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeDbKeyHash160ColByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash160ColByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash160ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeDbKeyHash160ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	void deepDisposeDbKeyHash160ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDbKeyHash160ColObj updateDbKeyHash160Col( IBusModelProtDbKeyHash160ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDbKeyHash160Col( IBusModelProtDbKeyHash160ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DbKeyHash160Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160ColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash160Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160ColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DbKeyHash160Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DbKeyHash160Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160ColByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DbKeyHash160Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160ColByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash160Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash160Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash160Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The DbKeyHash160Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash160ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Move the IBusModelProtDbKeyHash160ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtDbKeyHash160ColObj refreshed cache instance.
	 */
	IBusModelProtDbKeyHash160ColObj moveUpDbKeyHash160Col( IBusModelProtDbKeyHash160ColObj Obj );

	/**
	 *	Move the IBusModelProtDbKeyHash160ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtDbKeyHash160ColObj refreshed cache instance.
	 */
	IBusModelProtDbKeyHash160ColObj moveDownDbKeyHash160Col( IBusModelProtDbKeyHash160ColObj Obj );
}
