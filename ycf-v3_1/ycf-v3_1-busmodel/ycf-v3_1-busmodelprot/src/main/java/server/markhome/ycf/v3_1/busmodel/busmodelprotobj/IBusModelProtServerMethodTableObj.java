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

public interface IBusModelProtServerMethodTableObj
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
	 *	Instantiate a new ServerMethod instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelProtServerMethodObj newInstance();

	/**
	 *	Instantiate a new ServerMethod edition of the specified ServerMethod instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelProtServerMethodEditObj newEditInstance( IBusModelProtServerMethodObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelProtServerMethodObj realiseServerMethod( IBusModelProtServerMethodObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelProtServerMethodObj createServerMethod( IBusModelProtServerMethodObj Obj );

	/**
	 *	Read a ServerMethod-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerMethod-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtServerMethodObj readServerMethod( YCFDbKeyHash256 pkey );

	/**
	 *	Read a ServerMethod-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerMethod-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtServerMethodObj readServerMethod( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IBusModelProtServerMethodObj readCachedServerMethod( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeServerMethod( IBusModelProtServerMethodObj obj );

	void deepDisposeServerMethod( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelProtServerMethodObj lockServerMethod( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the ServerMethod-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtServerMethodObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtServerMethodObj> readAllServerMethod();

	/**
	 *	Return a sorted map of all the ServerMethod-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtServerMethodObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtServerMethodObj> readAllServerMethod( boolean forceRead );

	List<IBusModelProtServerMethodObj> readCachedAllServerMethod();

	/**
	 *	Get the IBusModelProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtServerMethodObj readServerMethodByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IBusModelProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtServerMethodObj readServerMethodByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtServerMethodObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtServerMethodObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of IBusModelProtServerMethodObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtServerMethodObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the IBusModelProtServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtServerMethodObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtServerMethodObj readServerMethodByUNameIdx(IYCFKeyHash256 TableId,
		String Name );

	/**
	 *	Get the IBusModelProtServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtServerMethodObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtServerMethodObj readServerMethodByUNameIdx(IYCFKeyHash256 TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtServerMethodObj> instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	TableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtServerMethodObj> cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByMethTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Get the map of List<IBusModelProtServerMethodObj> instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	TableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtServerMethodObj> cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByMethTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtServerMethodObj> instances sorted by their primary keys for the duplicate MethCodeVisIdx key.
	 *
	 *	@param	CodeVis	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtServerMethodObj> cached instances sorted by their primary keys for the duplicate MethCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of List<IBusModelProtServerMethodObj> instances sorted by their primary keys for the duplicate MethCodeVisIdx key.
	 *
	 *	@param	CodeVis	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtServerMethodObj> cached instances sorted by their primary keys for the duplicate MethCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtServerMethodObj> instances sorted by their primary keys for the duplicate MethTableVisIdx key.
	 *
	 *	@param	TableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtServerMethodObj> cached instances sorted by their primary keys for the duplicate MethTableVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of List<IBusModelProtServerMethodObj> instances sorted by their primary keys for the duplicate MethTableVisIdx key.
	 *
	 *	@param	TableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtServerMethodObj> cached instances sorted by their primary keys for the duplicate MethTableVisIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtServerMethodObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtServerMethodObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of List<IBusModelProtServerMethodObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtServerMethodObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtServerMethodObj> readServerMethodByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	IBusModelProtScopeObj readCachedServerMethodByIdIdx( IYCFKeyHash256 Id );

	List<List<IBusModelProtScopeObj>> readCachedServerMethodByTenantIdx( IYCFKeyHash256 TenantId );

	IBusModelProtServerMethodObj readCachedServerMethodByUNameIdx( IYCFKeyHash256 TableId,
		String Name );

	List<List<IBusModelProtServerMethodObj>> readCachedServerMethodByMethTableIdx( IYCFKeyHash256 TableId );

	List<List<IBusModelProtServerMethodObj>> readCachedServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	List<List<IBusModelProtServerMethodObj>> readCachedServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	List<List<IBusModelProtServerMethodObj>> readCachedServerMethodByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeServerMethodByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeServerMethodByTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeServerMethodByUNameIdx( IYCFKeyHash256 TableId,
		String Name );

	void deepDisposeServerMethodByMethTableIdx( IYCFKeyHash256 TableId );

	void deepDisposeServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeServerMethodByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 */
	IBusModelProtServerMethodObj updateServerMethod( IBusModelProtServerMethodObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteServerMethod( IBusModelProtServerMethodObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByUNameIdx(IYCFKeyHash256 TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByMethTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	CodeVis	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ServerMethod key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The ServerMethod key attribute of the instance generating the id.
	 */
	void deleteServerMethodByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );
}
