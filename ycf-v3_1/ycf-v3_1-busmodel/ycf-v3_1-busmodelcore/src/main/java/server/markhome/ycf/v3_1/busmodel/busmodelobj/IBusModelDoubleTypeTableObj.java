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

public interface IBusModelDoubleTypeTableObj
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
	 *	Instantiate a new DoubleType instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelDoubleTypeObj newInstance();

	/**
	 *	Instantiate a new DoubleType edition of the specified DoubleType instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelDoubleTypeEditObj newEditInstance( IBusModelDoubleTypeObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelDoubleTypeObj realiseDoubleType( IBusModelDoubleTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelDoubleTypeObj createDoubleType( IBusModelDoubleTypeObj Obj );

	/**
	 *	Read a DoubleType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DoubleType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelDoubleTypeObj readDoubleType( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a DoubleType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DoubleType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelDoubleTypeObj readDoubleType( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelDoubleTypeObj readCachedDoubleType( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeDoubleType( IBusModelDoubleTypeObj obj );

	void deepDisposeDoubleType( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelDoubleTypeObj lockDoubleType( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the DoubleType-derived instances in the database.
	 *
	 *	@return	List of IBusModelDoubleTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelDoubleTypeObj> readAllDoubleType();

	/**
	 *	Return a sorted map of all the DoubleType-derived instances in the database.
	 *
	 *	@return	List of IBusModelDoubleTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelDoubleTypeObj> readAllDoubleType( boolean forceRead );

	List<IBusModelDoubleTypeObj> readCachedAllDoubleType();

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelDoubleTypeObj readDoubleTypeByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelDoubleTypeObj readDoubleTypeByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelDoubleTypeObj readDoubleTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelDoubleTypeObj readDoubleTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelDoubleTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelDoubleTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelDoubleTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelDoubleTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelDoubleTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelDoubleTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelDoubleTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Get the map of BusModelDoubleTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDoubleTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDoubleTypeObj> readDoubleTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead );

	IBusModelDoubleTypeObj readCachedDoubleTypeByIdIdx( IYCFKeyHash256 Id );

	IBusModelDoubleTypeObj readCachedDoubleTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<IBusModelDoubleTypeObj> readCachedDoubleTypeByScopeIdx( IYCFKeyHash256 ScopeId );

	List<IBusModelDoubleTypeObj> readCachedDoubleTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelDoubleTypeObj> readCachedDoubleTypeByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelDoubleTypeObj> readCachedDoubleTypeByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelDoubleTypeObj> readCachedDoubleTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	List<IBusModelDoubleTypeObj> readCachedDoubleTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	List<IBusModelDoubleTypeObj> readCachedDoubleTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	void deepDisposeDoubleTypeByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeDoubleTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeDoubleTypeByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeDoubleTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeDoubleTypeByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeDoubleTypeByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeDoubleTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	void deepDisposeDoubleTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	void deepDisposeDoubleTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	IBusModelDoubleTypeObj updateDoubleType( IBusModelDoubleTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDoubleType( IBusModelDoubleTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DoubleType key attribute of the instance generating the id.
	 */
	void deleteDoubleTypeByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DoubleType key attribute of the instance generating the id.
	 */
	void deleteDoubleTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 */
	void deleteDoubleTypeByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DoubleType key attribute of the instance generating the id.
	 */
	void deleteDoubleTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DoubleType key attribute of the instance generating the id.
	 */
	void deleteDoubleTypeByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DoubleType key attribute of the instance generating the id.
	 */
	void deleteDoubleTypeByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DoubleType key attribute of the instance generating the id.
	 */
	void deleteDoubleTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DoubleType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DoubleType key attribute of the instance generating the id.
	 */
	void deleteDoubleTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The DoubleType key attribute of the instance generating the id.
	 */
	void deleteDoubleTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Move the BusModelDoubleTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelDoubleTypeObj refreshed cache instance.
	 */
	IBusModelDoubleTypeObj moveUpDoubleType( IBusModelDoubleTypeObj Obj );

	/**
	 *	Move the BusModelDoubleTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelDoubleTypeObj refreshed cache instance.
	 */
	IBusModelDoubleTypeObj moveDownDoubleType( IBusModelDoubleTypeObj Obj );
}
