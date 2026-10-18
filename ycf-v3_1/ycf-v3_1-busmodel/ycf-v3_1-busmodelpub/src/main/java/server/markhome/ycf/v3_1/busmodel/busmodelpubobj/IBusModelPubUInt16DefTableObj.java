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

public interface IBusModelPubUInt16DefTableObj
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
	 *	Instantiate a new UInt16Def instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubUInt16DefObj newInstance();

	/**
	 *	Instantiate a new UInt16Def edition of the specified UInt16Def instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubUInt16DefEditObj newEditInstance( IBusModelPubUInt16DefObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubUInt16DefObj realiseUInt16Def( IBusModelPubUInt16DefObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubUInt16DefObj createUInt16Def( IBusModelPubUInt16DefObj Obj );

	/**
	 *	Read a UInt16Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt16Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubUInt16DefObj readUInt16Def( IYCFKeyHash256 pkey );

	/**
	 *	Read a UInt16Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UInt16Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubUInt16DefObj readUInt16Def( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubUInt16DefObj readCachedUInt16Def( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeUInt16Def( IBusModelPubUInt16DefObj obj );

	void deepDisposeUInt16Def( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubUInt16DefObj lockUInt16Def( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the UInt16Def-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubUInt16DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readAllUInt16Def();

	/**
	 *	Return a sorted map of all the UInt16Def-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubUInt16DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readAllUInt16Def( boolean forceRead );

	List<IBusModelPubUInt16DefObj> readCachedAllUInt16Def();

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubUInt16DefObj readUInt16DefByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubUInt16DefObj readUInt16DefByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubUInt16DefObj readUInt16DefByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubUInt16DefObj readUInt16DefByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelPubUInt16DefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByScopeIdx( YCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubUInt16DefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubUInt16DefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubUInt16DefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubUInt16DefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubUInt16DefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubUInt16DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubUInt16DefObj> readUInt16DefByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId,
		boolean forceRead );

	IBusModelPubUInt16DefObj readCachedUInt16DefByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubUInt16DefObj readCachedUInt16DefByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	List<IBusModelPubUInt16DefObj> readCachedUInt16DefByScopeIdx( YCFDbKeyHash256 ScopeId );

	List<IBusModelPubUInt16DefObj> readCachedUInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubUInt16DefObj> readCachedUInt16DefByPrevIdx( YCFDbKeyHash256 PrevId );

	List<IBusModelPubUInt16DefObj> readCachedUInt16DefByNextIdx( YCFDbKeyHash256 NextId );

	List<IBusModelPubUInt16DefObj> readCachedUInt16DefByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	List<IBusModelPubUInt16DefObj> readCachedUInt16DefByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	void deepDisposeUInt16DefByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeUInt16DefByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeUInt16DefByScopeIdx( YCFDbKeyHash256 ScopeId );

	void deepDisposeUInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeUInt16DefByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeUInt16DefByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeUInt16DefByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	void deepDisposeUInt16DefByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubUInt16DefObj updateUInt16Def( IBusModelPubUInt16DefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUInt16Def( IBusModelPubUInt16DefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByContPrevIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The UInt16Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The UInt16Def key attribute of the instance generating the id.
	 */
	void deleteUInt16DefByContNextIdx( YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Move the BusModelPubUInt16DefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubUInt16DefObj refreshed cache instance.
	 */
	IBusModelPubUInt16DefObj moveUpUInt16Def( IBusModelPubUInt16DefObj Obj );

	/**
	 *	Move the BusModelPubUInt16DefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubUInt16DefObj refreshed cache instance.
	 */
	IBusModelPubUInt16DefObj moveDownUInt16Def( IBusModelPubUInt16DefObj Obj );
}
