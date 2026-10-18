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

public interface IBusModelPubDoubleColTableObj
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
	 *	Instantiate a new DoubleCol instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubDoubleColObj newInstance();

	/**
	 *	Instantiate a new DoubleCol edition of the specified DoubleCol instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubDoubleColEditObj newEditInstance( IBusModelPubDoubleColObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDoubleColObj realiseDoubleCol( IBusModelPubDoubleColObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDoubleColObj createDoubleCol( IBusModelPubDoubleColObj Obj );

	/**
	 *	Read a DoubleCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DoubleCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubDoubleColObj readDoubleCol( IYCFKeyHash256 pkey );

	/**
	 *	Read a DoubleCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DoubleCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubDoubleColObj readDoubleCol( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubDoubleColObj readCachedDoubleCol( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeDoubleCol( IBusModelPubDoubleColObj obj );

	void deepDisposeDoubleCol( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDoubleColObj lockDoubleCol( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DoubleCol-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubDoubleColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubDoubleColObj> readAllDoubleCol();

	/**
	 *	Return a sorted map of all the DoubleCol-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubDoubleColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubDoubleColObj> readAllDoubleCol( boolean forceRead );

	List<IBusModelPubDoubleColObj> readCachedAllDoubleCol();

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDoubleColObj readDoubleColByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDoubleColObj readDoubleColByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDoubleColObj readDoubleColByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDoubleColObj readDoubleColByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelPubDoubleColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByScopeIdx( YCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubDoubleColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubDoubleColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubDoubleColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubDoubleColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubDoubleColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubDoubleColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByTableIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Get the map of BusModelPubDoubleColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDoubleColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDoubleColObj> readDoubleColByTableIdx( YCFDbKeyHash256 TableId,
		boolean forceRead );

	IBusModelPubDoubleColObj readCachedDoubleColByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubDoubleColObj readCachedDoubleColByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	List<IBusModelPubDoubleColObj> readCachedDoubleColByScopeIdx( YCFDbKeyHash256 ScopeId );

	List<IBusModelPubDoubleColObj> readCachedDoubleColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubDoubleColObj> readCachedDoubleColByPrevIdx( YCFDbKeyHash256 PrevId );

	List<IBusModelPubDoubleColObj> readCachedDoubleColByNextIdx( YCFDbKeyHash256 NextId );

	List<IBusModelPubDoubleColObj> readCachedDoubleColByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	List<IBusModelPubDoubleColObj> readCachedDoubleColByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	List<IBusModelPubDoubleColObj> readCachedDoubleColByTableIdx( YCFDbKeyHash256 TableId );

	void deepDisposeDoubleColByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeDoubleColByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeDoubleColByScopeIdx( YCFDbKeyHash256 ScopeId );

	void deepDisposeDoubleColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeDoubleColByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeDoubleColByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeDoubleColByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeDoubleColByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	void deepDisposeDoubleColByTableIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDoubleColObj updateDoubleCol( IBusModelPubDoubleColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDoubleCol( IBusModelPubDoubleColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DoubleCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The DoubleCol key attribute of the instance generating the id.
	 */
	void deleteDoubleColByTableIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Move the BusModelPubDoubleColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubDoubleColObj refreshed cache instance.
	 */
	IBusModelPubDoubleColObj moveUpDoubleCol( IBusModelPubDoubleColObj Obj );

	/**
	 *	Move the BusModelPubDoubleColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubDoubleColObj refreshed cache instance.
	 */
	IBusModelPubDoubleColObj moveDownDoubleCol( IBusModelPubDoubleColObj Obj );
}
