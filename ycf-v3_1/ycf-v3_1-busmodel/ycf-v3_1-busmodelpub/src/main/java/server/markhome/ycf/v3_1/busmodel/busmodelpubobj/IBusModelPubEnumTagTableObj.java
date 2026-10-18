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

public interface IBusModelPubEnumTagTableObj
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
	 *	Instantiate a new EnumTag instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubEnumTagObj newInstance();

	/**
	 *	Instantiate a new EnumTag edition of the specified EnumTag instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubEnumTagEditObj newEditInstance( IBusModelPubEnumTagObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IBusModelPubEnumTagObj instance, which may be a subclass of a EnumTag instance.
	 */
	IBusModelPubEnumTagObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IBusModelPubEnumTagObj realiseEnumTag( IBusModelPubEnumTagObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubEnumTagObj createEnumTag( IBusModelPubEnumTagObj Obj );

	/**
	 *	Read a EnumTag-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumTag-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubEnumTagObj readEnumTag( IYCFKeyHash256 pkey );

	/**
	 *	Read a EnumTag-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumTag-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubEnumTagObj readEnumTag( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubEnumTagObj readCachedEnumTag( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeEnumTag( IBusModelPubEnumTagObj obj );

	void deepDisposeEnumTag( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubEnumTagObj lockEnumTag( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the EnumTag-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubEnumTagObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubEnumTagObj> readAllEnumTag();

	/**
	 *	Return a sorted map of all the EnumTag-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubEnumTagObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubEnumTagObj> readAllEnumTag( boolean forceRead );

	List<IBusModelPubEnumTagObj> readCachedAllEnumTag();

	/**
	 *	Get the BusModelPubEnumTagObj instance for the primary key attributes.
	 *
	 *	@param	Id	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubEnumTagObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubEnumTagObj readEnumTagByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubEnumTagObj instance for the primary key attributes.
	 *
	 *	@param	Id	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubEnumTagObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubEnumTagObj readEnumTagByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubEnumTagObj instances sorted by their primary keys for the duplicate EnumIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubEnumTagObj cached instances sorted by their primary keys for the duplicate EnumIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubEnumTagObj> readEnumTagByEnumIdx( YCFDbKeyHash256 EnumId );

	/**
	 *	Get the map of BusModelPubEnumTagObj instances sorted by their primary keys for the duplicate EnumIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubEnumTagObj cached instances sorted by their primary keys for the duplicate EnumIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubEnumTagObj> readEnumTagByEnumIdx( YCFDbKeyHash256 EnumId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubEnumTagObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubEnumTagObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubEnumTagObj> readEnumTagByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubEnumTagObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubEnumTagObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubEnumTagObj> readEnumTagByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubEnumTagObj instance for the unique EnumNameIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	Name	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubEnumTagObj cached instance for the unique EnumNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubEnumTagObj readEnumTagByEnumNameIdx(YCFDbKeyHash256 EnumId,
		String Name );

	/**
	 *	Get the BusModelPubEnumTagObj instance for the unique EnumNameIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	Name	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubEnumTagObj refreshed instance for the unique EnumNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubEnumTagObj readEnumTagByEnumNameIdx(YCFDbKeyHash256 EnumId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubEnumTagObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubEnumTagObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubEnumTagObj> readEnumTagByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelPubEnumTagObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubEnumTagObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubEnumTagObj> readEnumTagByPrevIdx( YCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubEnumTagObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubEnumTagObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubEnumTagObj> readEnumTagByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Get the map of BusModelPubEnumTagObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubEnumTagObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubEnumTagObj> readEnumTagByNextIdx( YCFDbKeyHash256 NextId,
		boolean forceRead );

	IBusModelPubEnumTagObj readCachedEnumTagByIdIdx( YCFDbKeyHash256 Id );

	List<IBusModelPubEnumTagObj> readCachedEnumTagByEnumIdx( YCFDbKeyHash256 EnumId );

	List<IBusModelPubEnumTagObj> readCachedEnumTagByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	IBusModelPubEnumTagObj readCachedEnumTagByEnumNameIdx( YCFDbKeyHash256 EnumId,
		String Name );

	List<IBusModelPubEnumTagObj> readCachedEnumTagByPrevIdx( YCFDbKeyHash256 PrevId );

	List<IBusModelPubEnumTagObj> readCachedEnumTagByNextIdx( YCFDbKeyHash256 NextId );

	void deepDisposeEnumTagByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeEnumTagByEnumIdx( YCFDbKeyHash256 EnumId );

	void deepDisposeEnumTagByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeEnumTagByEnumNameIdx( YCFDbKeyHash256 EnumId,
		String Name );

	void deepDisposeEnumTagByPrevIdx( YCFDbKeyHash256 PrevId );

	void deepDisposeEnumTagByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubEnumTagObj updateEnumTag( IBusModelPubEnumTagObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteEnumTag( IBusModelPubEnumTagObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumIdx( YCFDbKeyHash256 EnumId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	Name	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumNameIdx(YCFDbKeyHash256 EnumId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByPrevIdx( YCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByNextIdx( YCFDbKeyHash256 NextId );

	/**
	 *	Move the BusModelPubEnumTagObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubEnumTagObj refreshed cache instance.
	 */
	IBusModelPubEnumTagObj moveUpEnumTag( IBusModelPubEnumTagObj Obj );

	/**
	 *	Move the BusModelPubEnumTagObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelPubEnumTagObj refreshed cache instance.
	 */
	IBusModelPubEnumTagObj moveDownEnumTag( IBusModelPubEnumTagObj Obj );
}
