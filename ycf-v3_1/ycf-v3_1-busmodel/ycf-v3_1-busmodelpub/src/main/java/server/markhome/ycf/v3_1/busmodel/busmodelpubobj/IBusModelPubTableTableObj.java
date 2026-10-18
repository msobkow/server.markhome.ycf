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

public interface IBusModelPubTableTableObj
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
	 *	Instantiate a new Table instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubTableObj newInstance();

	/**
	 *	Instantiate a new Table edition of the specified Table instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubTableEditObj newEditInstance( IBusModelPubTableObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTableObj realiseTable( IBusModelPubTableObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTableObj createTable( IBusModelPubTableObj Obj );

	/**
	 *	Read a Table-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Table-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubTableObj readTable( IYCFKeyHash256 pkey );

	/**
	 *	Read a Table-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Table-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubTableObj readTable( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubTableObj readCachedTable( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeTable( IBusModelPubTableObj obj );

	void deepDisposeTable( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTableObj lockTable( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Table-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubTableObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubTableObj> readAllTable();

	/**
	 *	Return a sorted map of all the Table-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubTableObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubTableObj> readAllTable( boolean forceRead );

	List<IBusModelPubTableObj> readCachedAllTable();

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Table key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableObj readTableByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Table key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableObj readTableByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate SchemaDefIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate SchemaDefIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableBySchemaDefIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate SchemaDefIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate SchemaDefIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableBySchemaDefIdx( YCFDbKeyHash256 SchemaDefId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate CodeVisIdx key.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate CodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate CodeVisIdx key.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate CodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate SchemaCodeVisIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate SchemaCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableBySchemaCodeVisIdx( YCFDbKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate SchemaCodeVisIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate SchemaCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableBySchemaCodeVisIdx( YCFDbKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubTableObj instance for the unique UNameIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Table key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTableObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableObj readTableByUNameIdx(YCFDbKeyHash256 SchemaDefId,
		String Name );

	/**
	 *	Get the BusModelPubTableObj instance for the unique UNameIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Table key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTableObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableObj readTableByUNameIdx(YCFDbKeyHash256 SchemaDefId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the BusModelPubTableObj instance for the unique SchemaCdIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	TableClassCode	The Table key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTableObj cached instance for the unique SchemaCdIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableObj readTableBySchemaCdIdx(YCFDbKeyHash256 SchemaDefId,
		String TableClassCode );

	/**
	 *	Get the BusModelPubTableObj instance for the unique SchemaCdIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	TableClassCode	The Table key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTableObj refreshed instance for the unique SchemaCdIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableObj readTableBySchemaCdIdx(YCFDbKeyHash256 SchemaDefId,
		String TableClassCode,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate PrimaryIndexIdx key.
	 *
	 *	@param	PrimaryIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate PrimaryIndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByPrimaryIndexIdx( YCFDbKeyHash256 PrimaryIndexId );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate PrimaryIndexIdx key.
	 *
	 *	@param	PrimaryIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate PrimaryIndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByPrimaryIndexIdx( YCFDbKeyHash256 PrimaryIndexId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate LookupIndexIdx key.
	 *
	 *	@param	LookupIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate LookupIndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByLookupIndexIdx( YCFDbKeyHash256 LookupIndexId );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate LookupIndexIdx key.
	 *
	 *	@param	LookupIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate LookupIndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByLookupIndexIdx( YCFDbKeyHash256 LookupIndexId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate AltIndexIdx key.
	 *
	 *	@param	AltIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate AltIndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByAltIndexIdx( YCFDbKeyHash256 AltIndexId );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate AltIndexIdx key.
	 *
	 *	@param	AltIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate AltIndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByAltIndexIdx( YCFDbKeyHash256 AltIndexId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate QualTableIdx key.
	 *
	 *	@param	QualifyingTableId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate QualTableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByQualTableIdx( YCFDbKeyHash256 QualifyingTableId );

	/**
	 *	Get the map of BusModelPubTableObj instances sorted by their primary keys for the duplicate QualTableIdx key.
	 *
	 *	@param	QualifyingTableId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableObj cached instances sorted by their primary keys for the duplicate QualTableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableObj> readTableByQualTableIdx( YCFDbKeyHash256 QualifyingTableId,
		boolean forceRead );

	IBusModelPubTableObj readCachedTableByIdIdx( YCFDbKeyHash256 Id );

	List<IBusModelPubTableObj> readCachedTableByTenantIdx( YCFDbKeyHash256 TenantId );

	List<IBusModelPubTableObj> readCachedTableBySchemaDefIdx( YCFDbKeyHash256 SchemaDefId );

	List<IBusModelPubTableObj> readCachedTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	List<IBusModelPubTableObj> readCachedTableBySchemaCodeVisIdx( YCFDbKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	List<IBusModelPubTableObj> readCachedTableByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	IBusModelPubTableObj readCachedTableByUNameIdx( YCFDbKeyHash256 SchemaDefId,
		String Name );

	IBusModelPubTableObj readCachedTableBySchemaCdIdx( YCFDbKeyHash256 SchemaDefId,
		String TableClassCode );

	List<IBusModelPubTableObj> readCachedTableByPrimaryIndexIdx( YCFDbKeyHash256 PrimaryIndexId );

	List<IBusModelPubTableObj> readCachedTableByLookupIndexIdx( YCFDbKeyHash256 LookupIndexId );

	List<IBusModelPubTableObj> readCachedTableByAltIndexIdx( YCFDbKeyHash256 AltIndexId );

	List<IBusModelPubTableObj> readCachedTableByQualTableIdx( YCFDbKeyHash256 QualifyingTableId );

	void deepDisposeTableByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeTableByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeTableBySchemaDefIdx( YCFDbKeyHash256 SchemaDefId );

	void deepDisposeTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeTableBySchemaCodeVisIdx( YCFDbKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeTableByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeTableByUNameIdx( YCFDbKeyHash256 SchemaDefId,
		String Name );

	void deepDisposeTableBySchemaCdIdx( YCFDbKeyHash256 SchemaDefId,
		String TableClassCode );

	void deepDisposeTableByPrimaryIndexIdx( YCFDbKeyHash256 PrimaryIndexId );

	void deepDisposeTableByLookupIndexIdx( YCFDbKeyHash256 LookupIndexId );

	void deepDisposeTableByAltIndexIdx( YCFDbKeyHash256 AltIndexId );

	void deepDisposeTableByQualTableIdx( YCFDbKeyHash256 QualifyingTableId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTableObj updateTable( IBusModelPubTableObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTable( IBusModelPubTableObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaDefIdx( YCFDbKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaCodeVisIdx( YCFDbKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByUNameIdx(YCFDbKeyHash256 SchemaDefId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	TableClassCode	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaCdIdx(YCFDbKeyHash256 SchemaDefId,
		String TableClassCode );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrimaryIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByPrimaryIndexIdx( YCFDbKeyHash256 PrimaryIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	LookupIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByLookupIndexIdx( YCFDbKeyHash256 LookupIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	AltIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByAltIndexIdx( YCFDbKeyHash256 AltIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	QualifyingTableId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByQualTableIdx( YCFDbKeyHash256 QualifyingTableId );
}
