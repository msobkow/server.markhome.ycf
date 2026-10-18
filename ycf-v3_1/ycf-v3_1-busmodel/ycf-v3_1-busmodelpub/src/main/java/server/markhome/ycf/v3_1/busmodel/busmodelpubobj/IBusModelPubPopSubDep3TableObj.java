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

public interface IBusModelPubPopSubDep3TableObj
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
	 *	Instantiate a new PopSubDep3 instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubPopSubDep3Obj newInstance();

	/**
	 *	Instantiate a new PopSubDep3 edition of the specified PopSubDep3 instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubPopSubDep3EditObj newEditInstance( IBusModelPubPopSubDep3Obj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubPopSubDep3Obj realisePopSubDep3( IBusModelPubPopSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubPopSubDep3Obj createPopSubDep3( IBusModelPubPopSubDep3Obj Obj );

	/**
	 *	Read a PopSubDep3-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopSubDep3-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubPopSubDep3Obj readPopSubDep3( IYCFKeyHash256 pkey );

	/**
	 *	Read a PopSubDep3-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopSubDep3-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubPopSubDep3Obj readPopSubDep3( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubPopSubDep3Obj readCachedPopSubDep3( IYCFKeyHash256 pkey );

	public void reallyDeepDisposePopSubDep3( IBusModelPubPopSubDep3Obj obj );

	void deepDisposePopSubDep3( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubPopSubDep3Obj lockPopSubDep3( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the PopSubDep3-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubPopSubDep3Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readAllPopSubDep3();

	/**
	 *	Return a sorted map of all the PopSubDep3-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubPopSubDep3Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readAllPopSubDep3( boolean forceRead );

	List<IBusModelPubPopSubDep3Obj> readCachedAllPopSubDep3();

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubPopSubDep3Obj readPopSubDep3ByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubPopSubDep3Obj readPopSubDep3ByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubPopSubDep3Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readPopSubDep3ByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelPubPopSubDep3Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubPopSubDep3Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readPopSubDep3ByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubPopDepObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	RelationId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubPopSubDep3Obj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readPopSubDep3ByRelationIdx( YCFDbKeyHash256 RelationId );

	/**
	 *	Get the map of BusModelPubPopSubDep3Obj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	RelationId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubPopSubDep3Obj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readPopSubDep3ByRelationIdx( YCFDbKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubPopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubPopSubDep3Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readPopSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubPopSubDep3Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubPopSubDep3Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readPopSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubPopSubDep3Obj instances sorted by their primary keys for the duplicate PopSubDep2Idx key.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubPopSubDep3Obj cached instances sorted by their primary keys for the duplicate PopSubDep2Idx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readPopSubDep3ByPopSubDep2Idx( YCFDbKeyHash256 PopSubDep2Id );

	/**
	 *	Get the map of BusModelPubPopSubDep3Obj instances sorted by their primary keys for the duplicate PopSubDep2Idx key.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubPopSubDep3Obj cached instances sorted by their primary keys for the duplicate PopSubDep2Idx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubPopSubDep3Obj> readPopSubDep3ByPopSubDep2Idx( YCFDbKeyHash256 PopSubDep2Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubPopSubDep3Obj instance for the unique UNameIdx key.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubPopSubDep3Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubPopSubDep3Obj readPopSubDep3ByUNameIdx(YCFDbKeyHash256 PopSubDep2Id,
		String Name );

	/**
	 *	Get the BusModelPubPopSubDep3Obj instance for the unique UNameIdx key.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubPopSubDep3Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubPopSubDep3Obj readPopSubDep3ByUNameIdx(YCFDbKeyHash256 PopSubDep2Id,
		String Name,
		boolean forceRead );

	IBusModelPubPopSubDep3Obj readCachedPopSubDep3ByIdIdx( YCFDbKeyHash256 Id );

	List<IBusModelPubPopSubDep3Obj> readCachedPopSubDep3ByTenantIdx( YCFDbKeyHash256 TenantId );

	List<IBusModelPubPopSubDep3Obj> readCachedPopSubDep3ByRelationIdx( YCFDbKeyHash256 RelationId );

	List<IBusModelPubPopSubDep3Obj> readCachedPopSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubPopSubDep3Obj> readCachedPopSubDep3ByPopSubDep2Idx( YCFDbKeyHash256 PopSubDep2Id );

	IBusModelPubPopSubDep3Obj readCachedPopSubDep3ByUNameIdx( YCFDbKeyHash256 PopSubDep2Id,
		String Name );

	void deepDisposePopSubDep3ByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposePopSubDep3ByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposePopSubDep3ByRelationIdx( YCFDbKeyHash256 RelationId );

	void deepDisposePopSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposePopSubDep3ByPopSubDep2Idx( YCFDbKeyHash256 PopSubDep2Id );

	void deepDisposePopSubDep3ByUNameIdx( YCFDbKeyHash256 PopSubDep2Id,
		String Name );

	/**
	 *	Internal use only.
	 */
	IBusModelPubPopSubDep3Obj updatePopSubDep3( IBusModelPubPopSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deletePopSubDep3( IBusModelPubPopSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The PopSubDep3 key attribute of the instance generating the id.
	 */
	void deletePopSubDep3ByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The PopSubDep3 key attribute of the instance generating the id.
	 */
	void deletePopSubDep3ByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The PopSubDep3 key attribute of the instance generating the id.
	 */
	void deletePopSubDep3ByRelationIdx( YCFDbKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The PopSubDep3 key attribute of the instance generating the id.
	 */
	void deletePopSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 */
	void deletePopSubDep3ByPopSubDep2Idx( YCFDbKeyHash256 PopSubDep2Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep3 key attribute of the instance generating the id.
	 */
	void deletePopSubDep3ByUNameIdx(YCFDbKeyHash256 PopSubDep2Id,
		String Name );
}
