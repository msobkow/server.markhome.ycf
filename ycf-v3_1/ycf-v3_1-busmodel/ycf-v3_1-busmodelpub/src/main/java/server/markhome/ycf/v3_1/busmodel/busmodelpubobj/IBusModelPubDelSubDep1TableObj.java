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

public interface IBusModelPubDelSubDep1TableObj
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
	 *	Instantiate a new DelSubDep1 instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubDelSubDep1Obj newInstance();

	/**
	 *	Instantiate a new DelSubDep1 edition of the specified DelSubDep1 instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubDelSubDep1EditObj newEditInstance( IBusModelPubDelSubDep1Obj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDelSubDep1Obj realiseDelSubDep1( IBusModelPubDelSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDelSubDep1Obj createDelSubDep1( IBusModelPubDelSubDep1Obj Obj );

	/**
	 *	Read a DelSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubDelSubDep1Obj readDelSubDep1( IYCFKeyHash256 pkey );

	/**
	 *	Read a DelSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubDelSubDep1Obj readDelSubDep1( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubDelSubDep1Obj readCachedDelSubDep1( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeDelSubDep1( IBusModelPubDelSubDep1Obj obj );

	void deepDisposeDelSubDep1( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDelSubDep1Obj lockDelSubDep1( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DelSubDep1-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubDelSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readAllDelSubDep1();

	/**
	 *	Return a sorted map of all the DelSubDep1-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubDelSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readAllDelSubDep1( boolean forceRead );

	List<IBusModelPubDelSubDep1Obj> readCachedAllDelSubDep1();

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDelSubDep1Obj readDelSubDep1ByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDelSubDep1Obj readDelSubDep1ByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDelSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readDelSubDep1ByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelPubDelSubDep1Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDelSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readDelSubDep1ByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubDelDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readDelSubDep1ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubDelSubDep1Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readDelSubDep1ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubDelDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readDelSubDep1ByDelDepIdx( YCFDbKeyHash256 RelationId );

	/**
	 *	Get the map of BusModelPubDelSubDep1Obj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readDelSubDep1ByDelDepIdx( YCFDbKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubDelSubDep1Obj instances sorted by their primary keys for the duplicate DelTopDepIdx key.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DelTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readDelSubDep1ByDelTopDepIdx( YCFDbKeyHash256 DelTopDepId );

	/**
	 *	Get the map of BusModelPubDelSubDep1Obj instances sorted by their primary keys for the duplicate DelTopDepIdx key.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DelTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubDelSubDep1Obj> readDelSubDep1ByDelTopDepIdx( YCFDbKeyHash256 DelTopDepId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubDelSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubDelSubDep1Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDelSubDep1Obj readDelSubDep1ByUNameIdx(YCFDbKeyHash256 DelTopDepId,
		String Name );

	/**
	 *	Get the BusModelPubDelSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubDelSubDep1Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubDelSubDep1Obj readDelSubDep1ByUNameIdx(YCFDbKeyHash256 DelTopDepId,
		String Name,
		boolean forceRead );

	IBusModelPubDelSubDep1Obj readCachedDelSubDep1ByIdIdx( YCFDbKeyHash256 Id );

	List<IBusModelPubDelSubDep1Obj> readCachedDelSubDep1ByTenantIdx( YCFDbKeyHash256 TenantId );

	List<IBusModelPubDelSubDep1Obj> readCachedDelSubDep1ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubDelSubDep1Obj> readCachedDelSubDep1ByDelDepIdx( YCFDbKeyHash256 RelationId );

	List<IBusModelPubDelSubDep1Obj> readCachedDelSubDep1ByDelTopDepIdx( YCFDbKeyHash256 DelTopDepId );

	IBusModelPubDelSubDep1Obj readCachedDelSubDep1ByUNameIdx( YCFDbKeyHash256 DelTopDepId,
		String Name );

	void deepDisposeDelSubDep1ByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeDelSubDep1ByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeDelSubDep1ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeDelSubDep1ByDelDepIdx( YCFDbKeyHash256 RelationId );

	void deepDisposeDelSubDep1ByDelTopDepIdx( YCFDbKeyHash256 DelTopDepId );

	void deepDisposeDelSubDep1ByUNameIdx( YCFDbKeyHash256 DelTopDepId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IBusModelPubDelSubDep1Obj updateDelSubDep1( IBusModelPubDelSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDelSubDep1( IBusModelPubDelSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByDelDepIdx( YCFDbKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByDelTopDepIdx( YCFDbKeyHash256 DelTopDepId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByUNameIdx(YCFDbKeyHash256 DelTopDepId,
		String Name );
}
