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

public interface IBusModelNumberColTableObj
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
	 *	Instantiate a new NumberCol instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelNumberColObj newInstance();

	/**
	 *	Instantiate a new NumberCol edition of the specified NumberCol instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelNumberColEditObj newEditInstance( IBusModelNumberColObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelNumberColObj realiseNumberCol( IBusModelNumberColObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelNumberColObj createNumberCol( IBusModelNumberColObj Obj );

	/**
	 *	Read a NumberCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NumberCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelNumberColObj readNumberCol( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a NumberCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NumberCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelNumberColObj readNumberCol( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelNumberColObj readCachedNumberCol( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeNumberCol( IBusModelNumberColObj obj );

	void deepDisposeNumberCol( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelNumberColObj lockNumberCol( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the NumberCol-derived instances in the database.
	 *
	 *	@return	List of IBusModelNumberColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelNumberColObj> readAllNumberCol();

	/**
	 *	Return a sorted map of all the NumberCol-derived instances in the database.
	 *
	 *	@return	List of IBusModelNumberColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelNumberColObj> readAllNumberCol( boolean forceRead );

	List<IBusModelNumberColObj> readCachedAllNumberCol();

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelNumberColObj readNumberColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelNumberColObj readNumberColByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelNumberColObj readNumberColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelNumberColObj readNumberColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelNumberColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelNumberColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelNumberColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelNumberColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelNumberColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelNumberColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelNumberColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Get the map of BusModelNumberColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelNumberColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelNumberColObj> readNumberColByTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead );

	IBusModelNumberColObj readCachedNumberColByIdIdx( IYCFKeyHash256 Id );

	IBusModelNumberColObj readCachedNumberColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<IBusModelNumberColObj> readCachedNumberColByScopeIdx( IYCFKeyHash256 ScopeId );

	List<IBusModelNumberColObj> readCachedNumberColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelNumberColObj> readCachedNumberColByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelNumberColObj> readCachedNumberColByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelNumberColObj> readCachedNumberColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	List<IBusModelNumberColObj> readCachedNumberColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	List<IBusModelNumberColObj> readCachedNumberColByTableIdx( IYCFKeyHash256 TableId );

	void deepDisposeNumberColByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeNumberColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeNumberColByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeNumberColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeNumberColByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeNumberColByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeNumberColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	void deepDisposeNumberColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	void deepDisposeNumberColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	IBusModelNumberColObj updateNumberCol( IBusModelNumberColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteNumberCol( IBusModelNumberColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The NumberCol key attribute of the instance generating the id.
	 */
	void deleteNumberColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Move the BusModelNumberColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelNumberColObj refreshed cache instance.
	 */
	IBusModelNumberColObj moveUpNumberCol( IBusModelNumberColObj Obj );

	/**
	 *	Move the BusModelNumberColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelNumberColObj refreshed cache instance.
	 */
	IBusModelNumberColObj moveDownNumberCol( IBusModelNumberColObj Obj );
}
