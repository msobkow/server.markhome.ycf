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

public interface IBusModelPubServerListFuncTableObj
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
	 *	Instantiate a new ServerListFunc instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubServerListFuncObj newInstance();

	/**
	 *	Instantiate a new ServerListFunc edition of the specified ServerListFunc instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubServerListFuncEditObj newEditInstance( IBusModelPubServerListFuncObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubServerListFuncObj realiseServerListFunc( IBusModelPubServerListFuncObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubServerListFuncObj createServerListFunc( IBusModelPubServerListFuncObj Obj );

	/**
	 *	Read a ServerListFunc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerListFunc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubServerListFuncObj readServerListFunc( IYCFKeyHash256 pkey );

	/**
	 *	Read a ServerListFunc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerListFunc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubServerListFuncObj readServerListFunc( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubServerListFuncObj readCachedServerListFunc( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeServerListFunc( IBusModelPubServerListFuncObj obj );

	void deepDisposeServerListFunc( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubServerListFuncObj lockServerListFunc( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the ServerListFunc-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubServerListFuncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readAllServerListFunc();

	/**
	 *	Return a sorted map of all the ServerListFunc-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubServerListFuncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readAllServerListFunc( boolean forceRead );

	List<IBusModelPubServerListFuncObj> readCachedAllServerListFunc();

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubServerListFuncObj readServerListFuncByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubServerListFuncObj readServerListFuncByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelPubServerListFuncObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubServerMethodObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubServerListFuncObj readServerListFuncByUNameIdx( YCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Get the BusModelPubServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubServerMethodObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubServerListFuncObj readServerListFuncByUNameIdx( YCFDbKeyHash256 TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubServerMethodObj instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	TableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByMethTableIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Get the map of BusModelPubServerListFuncObj instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	TableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByMethTableIdx( YCFDbKeyHash256 TableId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubServerMethodObj instances sorted by their primary keys for the duplicate MethCodeVisIdx key.
	 *
	 *	@param	CodeVis	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate MethCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of BusModelPubServerListFuncObj instances sorted by their primary keys for the duplicate MethCodeVisIdx key.
	 *
	 *	@param	CodeVis	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate MethCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubServerMethodObj instances sorted by their primary keys for the duplicate MethTableVisIdx key.
	 *
	 *	@param	TableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate MethTableVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByMethTableVisIdx( YCFDbKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of BusModelPubServerListFuncObj instances sorted by their primary keys for the duplicate MethTableVisIdx key.
	 *
	 *	@param	TableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate MethTableVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByMethTableVisIdx( YCFDbKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubServerMethodObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubServerListFuncObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubServerListFuncObj instances sorted by their primary keys for the duplicate RetTblIdx key.
	 *
	 *	@param	RetTableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate RetTblIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByRetTblIdx( YCFDbKeyHash256 RetTableId );

	/**
	 *	Get the map of BusModelPubServerListFuncObj instances sorted by their primary keys for the duplicate RetTblIdx key.
	 *
	 *	@param	RetTableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubServerListFuncObj cached instances sorted by their primary keys for the duplicate RetTblIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubServerListFuncObj> readServerListFuncByRetTblIdx( YCFDbKeyHash256 RetTableId,
		boolean forceRead );

	IBusModelPubServerListFuncObj readCachedServerListFuncByIdIdx( YCFDbKeyHash256 Id );

	List<IBusModelPubServerListFuncObj> readCachedServerListFuncByTenantIdx( YCFDbKeyHash256 TenantId );

	IBusModelPubServerListFuncObj readCachedServerListFuncByUNameIdx( YCFDbKeyHash256 TableId,
		String Name );

	List<IBusModelPubServerListFuncObj> readCachedServerListFuncByMethTableIdx( YCFDbKeyHash256 TableId );

	List<IBusModelPubServerListFuncObj> readCachedServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	List<IBusModelPubServerListFuncObj> readCachedServerListFuncByMethTableVisIdx( YCFDbKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	List<IBusModelPubServerListFuncObj> readCachedServerListFuncByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<IBusModelPubServerListFuncObj> readCachedServerListFuncByRetTblIdx( YCFDbKeyHash256 RetTableId );

	void deepDisposeServerListFuncByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeServerListFuncByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeServerListFuncByUNameIdx( YCFDbKeyHash256 TableId,
		String Name );

	void deepDisposeServerListFuncByMethTableIdx( YCFDbKeyHash256 TableId );

	void deepDisposeServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeServerListFuncByMethTableVisIdx( YCFDbKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeServerListFuncByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeServerListFuncByRetTblIdx( YCFDbKeyHash256 RetTableId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubServerListFuncObj updateServerListFunc( IBusModelPubServerListFuncObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteServerListFunc( IBusModelPubServerListFuncObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByUNameIdx( YCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByMethTableIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	CodeVis	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ServerListFunc key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByMethTableVisIdx( YCFDbKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RetTableId	The ServerListFunc key attribute of the instance generating the id.
	 */
	void deleteServerListFuncByRetTblIdx( YCFDbKeyHash256 RetTableId );
}
