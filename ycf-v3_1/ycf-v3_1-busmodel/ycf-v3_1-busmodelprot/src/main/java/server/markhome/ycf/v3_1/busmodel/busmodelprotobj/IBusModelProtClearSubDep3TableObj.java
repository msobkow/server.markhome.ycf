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

public interface IBusModelProtClearSubDep3TableObj
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
	 *	Instantiate a new ClearSubDep3 instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelProtClearSubDep3Obj newInstance();

	/**
	 *	Instantiate a new ClearSubDep3 edition of the specified ClearSubDep3 instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelProtClearSubDep3EditObj newEditInstance( IBusModelProtClearSubDep3Obj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelProtClearSubDep3Obj realiseClearSubDep3( IBusModelProtClearSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelProtClearSubDep3Obj createClearSubDep3( IBusModelProtClearSubDep3Obj Obj );

	/**
	 *	Read a ClearSubDep3-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep3-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtClearSubDep3Obj readClearSubDep3( YCFDbKeyHash256 pkey );

	/**
	 *	Read a ClearSubDep3-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep3-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtClearSubDep3Obj readClearSubDep3( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IBusModelProtClearSubDep3Obj readCachedClearSubDep3( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeClearSubDep3( IBusModelProtClearSubDep3Obj obj );

	void deepDisposeClearSubDep3( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelProtClearSubDep3Obj lockClearSubDep3( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the ClearSubDep3-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtClearSubDep3Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readAllClearSubDep3();

	/**
	 *	Return a sorted map of all the ClearSubDep3-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtClearSubDep3Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readAllClearSubDep3( boolean forceRead );

	List<IBusModelProtClearSubDep3Obj> readCachedAllClearSubDep3();

	/**
	 *	Get the IBusModelProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtClearSubDep3Obj readClearSubDep3ByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IBusModelProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtClearSubDep3Obj readClearSubDep3ByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtClearSubDep3Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtClearSubDep3Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readClearSubDep3ByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of IBusModelProtClearSubDep3Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtClearSubDep3Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readClearSubDep3ByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtClearSubDep3Obj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtClearSubDep3Obj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readClearSubDep3ByClearDepIdx( IYCFKeyHash256 RelationId );

	/**
	 *	Get the map of IBusModelProtClearSubDep3Obj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtClearSubDep3Obj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readClearSubDep3ByClearDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtClearSubDep3Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtClearSubDep3Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readClearSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of IBusModelProtClearSubDep3Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtClearSubDep3Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readClearSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtClearSubDep3Obj> instances sorted by their primary keys for the duplicate ClearSubDep2Idx key.
	 *
	 *	@param	ClearSubDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtClearSubDep3Obj> cached instances sorted by their primary keys for the duplicate ClearSubDep2Idx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readClearSubDep3ByClearSubDep2Idx( IYCFKeyHash256 ClearSubDep2Id );

	/**
	 *	Get the map of List<IBusModelProtClearSubDep3Obj> instances sorted by their primary keys for the duplicate ClearSubDep2Idx key.
	 *
	 *	@param	ClearSubDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtClearSubDep3Obj> cached instances sorted by their primary keys for the duplicate ClearSubDep2Idx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtClearSubDep3Obj> readClearSubDep3ByClearSubDep2Idx( IYCFKeyHash256 ClearSubDep2Id,
		boolean forceRead );

	/**
	 *	Get the IBusModelProtClearSubDep3Obj instance for the unique UNameIdx key.
	 *
	 *	@param	ClearSubDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtClearSubDep3Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtClearSubDep3Obj readClearSubDep3ByUNameIdx(IYCFKeyHash256 ClearSubDep2Id,
		String Name );

	/**
	 *	Get the IBusModelProtClearSubDep3Obj instance for the unique UNameIdx key.
	 *
	 *	@param	ClearSubDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtClearSubDep3Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtClearSubDep3Obj readClearSubDep3ByUNameIdx(IYCFKeyHash256 ClearSubDep2Id,
		String Name,
		boolean forceRead );

	IBusModelProtScopeObj readCachedClearSubDep3ByIdIdx( IYCFKeyHash256 Id );

	List<List<IBusModelProtScopeObj>> readCachedClearSubDep3ByTenantIdx( IYCFKeyHash256 TenantId );

	List<List<IBusModelProtClearDepObj>> readCachedClearSubDep3ByClearDepIdx( IYCFKeyHash256 RelationId );

	List<List<IBusModelProtClearDepObj>> readCachedClearSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<List<IBusModelProtClearSubDep3Obj>> readCachedClearSubDep3ByClearSubDep2Idx( IYCFKeyHash256 ClearSubDep2Id );

	IBusModelProtClearSubDep3Obj readCachedClearSubDep3ByUNameIdx( IYCFKeyHash256 ClearSubDep2Id,
		String Name );

	void deepDisposeClearSubDep3ByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeClearSubDep3ByTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeClearSubDep3ByClearDepIdx( IYCFKeyHash256 RelationId );

	void deepDisposeClearSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeClearSubDep3ByClearSubDep2Idx( IYCFKeyHash256 ClearSubDep2Id );

	void deepDisposeClearSubDep3ByUNameIdx( IYCFKeyHash256 ClearSubDep2Id,
		String Name );

	/**
	 *	Internal use only.
	 */
	IBusModelProtClearSubDep3Obj updateClearSubDep3( IBusModelProtClearSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteClearSubDep3( IBusModelProtClearSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByClearDepIdx( IYCFKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClearSubDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByClearSubDep2Idx( IYCFKeyHash256 ClearSubDep2Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClearSubDep2Id	The ClearSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearSubDep3 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep3ByUNameIdx(IYCFKeyHash256 ClearSubDep2Id,
		String Name );
}
