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

public interface IBusModelProtInt16ColTableObj
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
	 *	Instantiate a new Int16Col instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelProtInt16ColObj newInstance();

	/**
	 *	Instantiate a new Int16Col edition of the specified Int16Col instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelProtInt16ColEditObj newEditInstance( IBusModelProtInt16ColObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelProtInt16ColObj realiseInt16Col( IBusModelProtInt16ColObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelProtInt16ColObj createInt16Col( IBusModelProtInt16ColObj Obj );

	/**
	 *	Read a Int16Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtInt16ColObj readInt16Col( YCFDbKeyHash256 pkey );

	/**
	 *	Read a Int16Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtInt16ColObj readInt16Col( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IBusModelProtInt16ColObj readCachedInt16Col( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeInt16Col( IBusModelProtInt16ColObj obj );

	void deepDisposeInt16Col( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelProtInt16ColObj lockInt16Col( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Int16Col-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtInt16ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtInt16ColObj> readAllInt16Col();

	/**
	 *	Return a sorted map of all the Int16Col-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtInt16ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtInt16ColObj> readAllInt16Col( boolean forceRead );

	List<IBusModelProtInt16ColObj> readCachedAllInt16Col();

	/**
	 *	Get the IBusModelProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtInt16ColObj readInt16ColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IBusModelProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtInt16ColObj readInt16ColByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the IBusModelProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtInt16ColObj readInt16ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the IBusModelProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtInt16ColObj readInt16ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of IBusModelProtInt16ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtInt16ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtInt16ColObj> instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtInt16ColObj> cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Get the map of List<IBusModelProtInt16ColObj> instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtInt16ColObj> cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtInt16ColObj> readInt16ColByTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead );

	IBusModelProtValueObj readCachedInt16ColByIdIdx( IYCFKeyHash256 Id );

	IBusModelProtValueObj readCachedInt16ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<List<IBusModelProtValueObj>> readCachedInt16ColByScopeIdx( IYCFKeyHash256 ScopeId );

	List<List<IBusModelProtValueObj>> readCachedInt16ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<List<IBusModelProtValueObj>> readCachedInt16ColByPrevIdx( YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtValueObj>> readCachedInt16ColByNextIdx( YCFDbKeyHash256 NextId );

	List<List<IBusModelProtValueObj>> readCachedInt16ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtValueObj>> readCachedInt16ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	List<List<IBusModelProtInt16ColObj>> readCachedInt16ColByTableIdx( IYCFKeyHash256 TableId );

	void deepDisposeInt16ColByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeInt16ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeInt16ColByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeInt16ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeInt16ColByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeInt16ColByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeInt16ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeInt16ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	void deepDisposeInt16ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	IBusModelProtInt16ColObj updateInt16Col( IBusModelProtInt16ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt16Col( IBusModelProtInt16ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByContNextIdx( IYCFKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The Int16Col key attribute of the instance generating the id.
	 */
	void deleteInt16ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Move the IBusModelProtInt16ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtInt16ColObj refreshed cache instance.
	 */
	IBusModelProtInt16ColObj moveUpInt16Col( IBusModelProtInt16ColObj Obj );

	/**
	 *	Move the IBusModelProtInt16ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtInt16ColObj refreshed cache instance.
	 */
	IBusModelProtInt16ColObj moveDownInt16Col( IBusModelProtInt16ColObj Obj );
}
