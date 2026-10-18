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

public interface IBusModelProtDelTopDepTableObj
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
	 *	Instantiate a new DelTopDep instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelProtDelTopDepObj newInstance();

	/**
	 *	Instantiate a new DelTopDep edition of the specified DelTopDep instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelProtDelTopDepEditObj newEditInstance( IBusModelProtDelTopDepObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDelTopDepObj realiseDelTopDep( IBusModelProtDelTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDelTopDepObj createDelTopDep( IBusModelProtDelTopDepObj Obj );

	/**
	 *	Read a DelTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtDelTopDepObj readDelTopDep( YCFDbKeyHash256 pkey );

	/**
	 *	Read a DelTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelProtDelTopDepObj readDelTopDep( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IBusModelProtDelTopDepObj readCachedDelTopDep( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeDelTopDep( IBusModelProtDelTopDepObj obj );

	void deepDisposeDelTopDep( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDelTopDepObj lockDelTopDep( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DelTopDep-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtDelTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readAllDelTopDep();

	/**
	 *	Return a sorted map of all the DelTopDep-derived instances in the database.
	 *
	 *	@return	List of IBusModelProtDelTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readAllDelTopDep( boolean forceRead );

	List<IBusModelProtDelTopDepObj> readCachedAllDelTopDep();

	/**
	 *	Get the IBusModelProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDelTopDepObj readDelTopDepByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IBusModelProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDelTopDepObj readDelTopDepByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDelTopDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDelTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of IBusModelProtDelTopDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDelTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDelTopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDelTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of IBusModelProtDelTopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDelTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of IBusModelProtDelTopDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDelTopDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId );

	/**
	 *	Get the map of IBusModelProtDelTopDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of IBusModelProtDelTopDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtDelTopDepObj> instances sorted by their primary keys for the duplicate DelTopDepTblIdx key.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDelTopDepObj> cached instances sorted by their primary keys for the duplicate DelTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId );

	/**
	 *	Get the map of List<IBusModelProtDelTopDepObj> instances sorted by their primary keys for the duplicate DelTopDepTblIdx key.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDelTopDepObj> cached instances sorted by their primary keys for the duplicate DelTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId,
		boolean forceRead );

	/**
	 *	Get the IBusModelProtDelTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtDelTopDepObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDelTopDepObj readDelTopDepByUNameIdx(IYCFKeyHash256 TableId,
		String Name );

	/**
	 *	Get the IBusModelProtDelTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	IBusModelProtDelTopDepObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelProtDelTopDepObj readDelTopDepByUNameIdx(IYCFKeyHash256 TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtDelTopDepObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDelTopDepObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<IBusModelProtDelTopDepObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDelTopDepObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<IBusModelProtDelTopDepObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDelTopDepObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<IBusModelProtDelTopDepObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IBusModelProtDelTopDepObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelProtDelTopDepObj> readDelTopDepByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	IBusModelProtScopeObj readCachedDelTopDepByIdIdx( IYCFKeyHash256 Id );

	List<List<IBusModelProtScopeObj>> readCachedDelTopDepByTenantIdx( IYCFKeyHash256 TenantId );

	List<List<IBusModelProtDelDepObj>> readCachedDelTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	List<List<IBusModelProtDelDepObj>> readCachedDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId );

	List<List<IBusModelProtDelTopDepObj>> readCachedDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId );

	IBusModelProtDelTopDepObj readCachedDelTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name );

	List<List<IBusModelProtDelTopDepObj>> readCachedDelTopDepByPrevIdx( YCFDbKeyHash256 PrevId );

	List<List<IBusModelProtDelTopDepObj>> readCachedDelTopDepByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeDelTopDepByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeDelTopDepByTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeDelTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId );

	void deepDisposeDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId );

	void deepDisposeDelTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name );

	void deepDisposeDelTopDepByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeDelTopDepByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelProtDelTopDepObj updateDelTopDep( IBusModelProtDelTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDelTopDep( IBusModelProtDelTopDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByUNameIdx(IYCFKeyHash256 TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Move the IBusModelProtDelTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtDelTopDepObj refreshed cache instance.
	 */
	IBusModelProtDelTopDepObj moveUpDelTopDep( IBusModelProtDelTopDepObj Obj );

	/**
	 *	Move the IBusModelProtDelTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	IBusModelProtDelTopDepObj refreshed cache instance.
	 */
	IBusModelProtDelTopDepObj moveDownDelTopDep( IBusModelProtDelTopDepObj Obj );
}
