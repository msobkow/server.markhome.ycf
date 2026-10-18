// Description: Java 25 Table Object interface for BusModel.

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

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public interface IBusModelInt64DefTableObj
{
	public IBusModelSchemaObj getSchema();
	public void setSchema( IBusModelSchemaObj value );

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
	 *	Instantiate a new Int64Def instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelInt64DefObj newInstance();

	/**
	 *	Instantiate a new Int64Def edition of the specified Int64Def instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelInt64DefEditObj newEditInstance( IBusModelInt64DefObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelInt64DefObj realiseInt64Def( IBusModelInt64DefObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelInt64DefObj createInt64Def( IBusModelInt64DefObj Obj );

	/**
	 *	Read a Int64Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelInt64DefObj readInt64Def( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a Int64Def-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Def-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelInt64DefObj readInt64Def( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelInt64DefObj readCachedInt64Def( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeInt64Def( IBusModelInt64DefObj obj );

	void deepDisposeInt64Def( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelInt64DefObj lockInt64Def( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the Int64Def-derived instances in the database.
	 *
	 *	@return	List of IBusModelInt64DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelInt64DefObj> readAllInt64Def();

	/**
	 *	Return a sorted map of all the Int64Def-derived instances in the database.
	 *
	 *	@return	List of IBusModelInt64DefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelInt64DefObj> readAllInt64Def( boolean forceRead );

	List<IBusModelInt64DefObj> readCachedAllInt64Def();

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt64DefObj readInt64DefByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt64DefObj readInt64DefByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt64DefObj readInt64DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt64DefObj readInt64DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelInt64DefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelInt64DefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelInt64DefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelInt64DefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelInt64DefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelInt64DefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt64DefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt64DefObj> readInt64DefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	IBusModelInt64DefObj readCachedInt64DefByIdIdx( IYCFKeyHash256 Id );

	IBusModelInt64DefObj readCachedInt64DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<IBusModelInt64DefObj> readCachedInt64DefByScopeIdx( IYCFKeyHash256 ScopeId );

	List<IBusModelInt64DefObj> readCachedInt64DefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelInt64DefObj> readCachedInt64DefByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelInt64DefObj> readCachedInt64DefByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelInt64DefObj> readCachedInt64DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	List<IBusModelInt64DefObj> readCachedInt64DefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	void deepDisposeInt64DefByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeInt64DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeInt64DefByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeInt64DefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeInt64DefByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeInt64DefByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeInt64DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	void deepDisposeInt64DefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelInt64DefObj updateInt64Def( IBusModelInt64DefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt64Def( IBusModelInt64DefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int64Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int64Def key attribute of the instance generating the id.
	 */
	void deleteInt64DefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Move the BusModelInt64DefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelInt64DefObj refreshed cache instance.
	 */
	IBusModelInt64DefObj moveUpInt64Def( IBusModelInt64DefObj Obj );

	/**
	 *	Move the BusModelInt64DefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelInt64DefObj refreshed cache instance.
	 */
	IBusModelInt64DefObj moveDownInt64Def( IBusModelInt64DefObj Obj );
}
