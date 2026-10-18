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

public interface IBusModelInt32ColTableObj
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
	 *	Instantiate a new Int32Col instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelInt32ColObj newInstance();

	/**
	 *	Instantiate a new Int32Col edition of the specified Int32Col instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelInt32ColEditObj newEditInstance( IBusModelInt32ColObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelInt32ColObj realiseInt32Col( IBusModelInt32ColObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelInt32ColObj createInt32Col( IBusModelInt32ColObj Obj );

	/**
	 *	Read a Int32Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int32Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelInt32ColObj readInt32Col( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a Int32Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int32Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelInt32ColObj readInt32Col( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelInt32ColObj readCachedInt32Col( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeInt32Col( IBusModelInt32ColObj obj );

	void deepDisposeInt32Col( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelInt32ColObj lockInt32Col( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the Int32Col-derived instances in the database.
	 *
	 *	@return	List of IBusModelInt32ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelInt32ColObj> readAllInt32Col();

	/**
	 *	Return a sorted map of all the Int32Col-derived instances in the database.
	 *
	 *	@return	List of IBusModelInt32ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelInt32ColObj> readAllInt32Col( boolean forceRead );

	List<IBusModelInt32ColObj> readCachedAllInt32Col();

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt32ColObj readInt32ColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt32ColObj readInt32ColByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt32ColObj readInt32ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelInt32ColObj readInt32ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelInt32ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelInt32ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelInt32ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelInt32ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelInt32ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelInt32ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelInt32ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Get the map of BusModelInt32ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelInt32ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelInt32ColObj> readInt32ColByTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead );

	IBusModelInt32ColObj readCachedInt32ColByIdIdx( IYCFKeyHash256 Id );

	IBusModelInt32ColObj readCachedInt32ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<IBusModelInt32ColObj> readCachedInt32ColByScopeIdx( IYCFKeyHash256 ScopeId );

	List<IBusModelInt32ColObj> readCachedInt32ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelInt32ColObj> readCachedInt32ColByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelInt32ColObj> readCachedInt32ColByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelInt32ColObj> readCachedInt32ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	List<IBusModelInt32ColObj> readCachedInt32ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	List<IBusModelInt32ColObj> readCachedInt32ColByTableIdx( IYCFKeyHash256 TableId );

	void deepDisposeInt32ColByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeInt32ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeInt32ColByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeInt32ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeInt32ColByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeInt32ColByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeInt32ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	void deepDisposeInt32ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	void deepDisposeInt32ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	IBusModelInt32ColObj updateInt32Col( IBusModelInt32ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt32Col( IBusModelInt32ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Int32Col key attribute of the instance generating the id.
	 */
	void deleteInt32ColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int32Col key attribute of the instance generating the id.
	 */
	void deleteInt32ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 */
	void deleteInt32ColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Int32Col key attribute of the instance generating the id.
	 */
	void deleteInt32ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Int32Col key attribute of the instance generating the id.
	 */
	void deleteInt32ColByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Int32Col key attribute of the instance generating the id.
	 */
	void deleteInt32ColByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int32Col key attribute of the instance generating the id.
	 */
	void deleteInt32ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Int32Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int32Col key attribute of the instance generating the id.
	 */
	void deleteInt32ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The Int32Col key attribute of the instance generating the id.
	 */
	void deleteInt32ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Move the BusModelInt32ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelInt32ColObj refreshed cache instance.
	 */
	IBusModelInt32ColObj moveUpInt32Col( IBusModelInt32ColObj Obj );

	/**
	 *	Move the BusModelInt32ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelInt32ColObj refreshed cache instance.
	 */
	IBusModelInt32ColObj moveDownInt32Col( IBusModelInt32ColObj Obj );
}
