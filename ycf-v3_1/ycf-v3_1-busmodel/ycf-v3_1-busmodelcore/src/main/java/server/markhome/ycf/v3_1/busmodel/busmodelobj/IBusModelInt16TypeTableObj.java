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

public interface IBusModelInt16TypeTableObj
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
	 *	Instantiate a new Int16Type instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelInt16TypeObj newInstance();

	/**
	 *	Instantiate a new Int16Type edition of the specified Int16Type instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelInt16TypeEditObj newEditInstance( IBusModelInt16TypeObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelInt16TypeObj realiseInt16Type( IBusModelInt16TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelInt16TypeObj createInt16Type( IBusModelInt16TypeObj Obj );

	/**
	 *	Read a Int16Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelInt16TypeObj readInt16Type( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a Int16Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelInt16TypeObj readInt16Type( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelInt16TypeObj readCachedInt16Type( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeInt16Type( IBusModelInt16TypeObj obj );

	void deepDisposeInt16Type( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelInt16TypeObj lockInt16Type( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the Int16Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelInt16TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelInt16TypeObj> readAllInt16Type();

	/**
	 *	Return a sorted map of all the Int16Type-derived instances in the database.
	 *
	 *	@return	List of IBusModelInt16TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelInt16TypeObj> readAllInt16Type( boolean forceRead );

	List<IBusModelInt16TypeObj> readCachedAllInt16Type();

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt16TypeObj readInt16TypeByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt16TypeObj readInt16TypeByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt16TypeObj readInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt16TypeObj readInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelInt16TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelInt16TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelInt16TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelInt16TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelInt16TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelInt16TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelInt16TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Get the map of BusModelInt16TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt16TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt16TypeObj> readInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead );

	IBusModelInt16TypeObj readCachedInt16TypeByIdIdx( IYCFKeyHash256 Id );

	IBusModelInt16TypeObj readCachedInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<IBusModelInt16TypeObj> readCachedInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId );

	List<IBusModelInt16TypeObj> readCachedInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelInt16TypeObj> readCachedInt16TypeByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelInt16TypeObj> readCachedInt16TypeByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelInt16TypeObj> readCachedInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	List<IBusModelInt16TypeObj> readCachedInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	List<IBusModelInt16TypeObj> readCachedInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	void deepDisposeInt16TypeByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeInt16TypeByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeInt16TypeByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	void deepDisposeInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	void deepDisposeInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	IBusModelInt16TypeObj updateInt16Type( IBusModelInt16TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt16Type( IBusModelInt16TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Move the BusModelInt16TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelInt16TypeObj refreshed cache instance.
	 */
	IBusModelInt16TypeObj moveUpInt16Type( IBusModelInt16TypeObj Obj );

	/**
	 *	Move the BusModelInt16TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelInt16TypeObj refreshed cache instance.
	 */
	IBusModelInt16TypeObj moveDownInt16Type( IBusModelInt16TypeObj Obj );
}
