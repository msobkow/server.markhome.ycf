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

public interface IBusModelPubClearTopDepTableObj
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
	 *	Instantiate a new ClearTopDep instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubClearTopDepObj newInstance();

	/**
	 *	Instantiate a new ClearTopDep edition of the specified ClearTopDep instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubClearTopDepEditObj newEditInstance( IBusModelPubClearTopDepObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubClearTopDepObj realiseClearTopDep( IBusModelPubClearTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubClearTopDepObj createClearTopDep( IBusModelPubClearTopDepObj Obj );

	/**
	 *	Read a ClearTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubClearTopDepObj readClearTopDep( IYCFKeyHash256 pkey );

	/**
	 *	Read a ClearTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubClearTopDepObj readClearTopDep( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubClearTopDepObj readCachedClearTopDep( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeClearTopDep( IBusModelPubClearTopDepObj obj );

	void deepDisposeClearTopDep( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubClearTopDepObj lockClearTopDep( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the ClearTopDep-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubClearTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readAllClearTopDep();

	/**
	 *	Return a sorted map of all the ClearTopDep-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubClearTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readAllClearTopDep( boolean forceRead );

	List<IBusModelPubClearTopDepObj> readCachedAllClearTopDep();

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubClearTopDepObj readClearTopDepByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubClearTopDepObj readClearTopDepByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelPubClearTopDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubClearDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByClearDepIdx( YCFDbKeyHash256 RelationId );

	/**
	 *	Get the map of BusModelPubClearTopDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByClearDepIdx( YCFDbKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubClearDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubClearTopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubClearTopDepObj instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByClrTopDepTblIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Get the map of BusModelPubClearTopDepObj instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByClrTopDepTblIdx( YCFDbKeyHash256 TableId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubClearTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubClearTopDepObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubClearTopDepObj readClearTopDepByUNameIdx(YCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Get the BusModelPubClearTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubClearTopDepObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubClearTopDepObj readClearTopDepByUNameIdx(YCFDbKeyHash256 TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubClearTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubClearTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubClearTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubClearTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubClearTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubClearTopDepObj> readClearTopDepByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	IBusModelPubClearTopDepObj readCachedClearTopDepByIdIdx( YCFDbKeyHash256 Id );

	List<IBusModelPubClearTopDepObj> readCachedClearTopDepByTenantIdx( YCFDbKeyHash256 TenantId );

	List<IBusModelPubClearTopDepObj> readCachedClearTopDepByClearDepIdx( YCFDbKeyHash256 RelationId );

	List<IBusModelPubClearTopDepObj> readCachedClearTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubClearTopDepObj> readCachedClearTopDepByClrTopDepTblIdx( YCFDbKeyHash256 TableId );

	IBusModelPubClearTopDepObj readCachedClearTopDepByUNameIdx( YCFDbKeyHash256 TableId,
		String Name );

	List<IBusModelPubClearTopDepObj> readCachedClearTopDepByPrevIdx( YCFDbKeyHash256 PrevId );

	List<IBusModelPubClearTopDepObj> readCachedClearTopDepByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeClearTopDepByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeClearTopDepByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeClearTopDepByClearDepIdx( YCFDbKeyHash256 RelationId );

	void deepDisposeClearTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeClearTopDepByClrTopDepTblIdx( YCFDbKeyHash256 TableId );

	void deepDisposeClearTopDepByUNameIdx( YCFDbKeyHash256 TableId,
		String Name );

	void deepDisposeClearTopDepByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeClearTopDepByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubClearTopDepObj updateClearTopDep( IBusModelPubClearTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteClearTopDep( IBusModelPubClearTopDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByClearDepIdx( YCFDbKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByClrTopDepTblIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByUNameIdx(YCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Move the BusModelPubClearTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubClearTopDepObj refreshed cache instance.
	 */
	IBusModelPubClearTopDepObj moveUpClearTopDep( IBusModelPubClearTopDepObj Obj );

	/**
	 *	Move the BusModelPubClearTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubClearTopDepObj refreshed cache instance.
	 */
	IBusModelPubClearTopDepObj moveDownClearTopDep( IBusModelPubClearTopDepObj Obj );
}
