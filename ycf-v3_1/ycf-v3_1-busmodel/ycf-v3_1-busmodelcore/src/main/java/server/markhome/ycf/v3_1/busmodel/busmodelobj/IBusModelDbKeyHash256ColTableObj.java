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

public interface IBusModelDbKeyHash256ColTableObj
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
	 *	Instantiate a new DbKeyHash256Col instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelDbKeyHash256ColObj newInstance();

	/**
	 *	Instantiate a new DbKeyHash256Col edition of the specified DbKeyHash256Col instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelDbKeyHash256ColEditObj newEditInstance( IBusModelDbKeyHash256ColObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelDbKeyHash256ColObj realiseDbKeyHash256Col( IBusModelDbKeyHash256ColObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelDbKeyHash256ColObj createDbKeyHash256Col( IBusModelDbKeyHash256ColObj Obj );

	/**
	 *	Read a DbKeyHash256Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash256Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelDbKeyHash256ColObj readDbKeyHash256Col( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a DbKeyHash256Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DbKeyHash256Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelDbKeyHash256ColObj readDbKeyHash256Col( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelDbKeyHash256ColObj readCachedDbKeyHash256Col( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeDbKeyHash256Col( IBusModelDbKeyHash256ColObj obj );

	void deepDisposeDbKeyHash256Col( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelDbKeyHash256ColObj lockDbKeyHash256Col( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the DbKeyHash256Col-derived instances in the database.
	 *
	 *	@return	List of IBusModelDbKeyHash256ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readAllDbKeyHash256Col();

	/**
	 *	Return a sorted map of all the DbKeyHash256Col-derived instances in the database.
	 *
	 *	@return	List of IBusModelDbKeyHash256ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readAllDbKeyHash256Col( boolean forceRead );

	List<IBusModelDbKeyHash256ColObj> readCachedAllDbKeyHash256Col();

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelDbKeyHash256ColObj readDbKeyHash256ColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelDbKeyHash256ColObj readDbKeyHash256ColByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelDbKeyHash256ColObj readDbKeyHash256ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelDbKeyHash256ColObj readDbKeyHash256ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelDbKeyHash256ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelDbKeyHash256ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelDbKeyHash256ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelDbKeyHash256ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelDbKeyHash256ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelDbKeyHash256ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelDbKeyHash256ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Get the map of BusModelDbKeyHash256ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelDbKeyHash256ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelDbKeyHash256ColObj> readDbKeyHash256ColByTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead );

	IBusModelDbKeyHash256ColObj readCachedDbKeyHash256ColByIdIdx( IYCFKeyHash256 Id );

	IBusModelDbKeyHash256ColObj readCachedDbKeyHash256ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<IBusModelDbKeyHash256ColObj> readCachedDbKeyHash256ColByScopeIdx( IYCFKeyHash256 ScopeId );

	List<IBusModelDbKeyHash256ColObj> readCachedDbKeyHash256ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelDbKeyHash256ColObj> readCachedDbKeyHash256ColByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelDbKeyHash256ColObj> readCachedDbKeyHash256ColByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelDbKeyHash256ColObj> readCachedDbKeyHash256ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	List<IBusModelDbKeyHash256ColObj> readCachedDbKeyHash256ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	List<IBusModelDbKeyHash256ColObj> readCachedDbKeyHash256ColByTableIdx( IYCFKeyHash256 TableId );

	void deepDisposeDbKeyHash256ColByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeDbKeyHash256ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeDbKeyHash256ColByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeDbKeyHash256ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeDbKeyHash256ColByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeDbKeyHash256ColByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeDbKeyHash256ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	void deepDisposeDbKeyHash256ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	void deepDisposeDbKeyHash256ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	IBusModelDbKeyHash256ColObj updateDbKeyHash256Col( IBusModelDbKeyHash256ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDbKeyHash256Col( IBusModelDbKeyHash256ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DbKeyHash256Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash256ColByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash256Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash256ColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash256ColByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DbKeyHash256Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash256ColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DbKeyHash256Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash256ColByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DbKeyHash256Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash256ColByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash256Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash256ColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The DbKeyHash256Col key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash256Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash256ColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The DbKeyHash256Col key attribute of the instance generating the id.
	 */
	void deleteDbKeyHash256ColByTableIdx( IYCFKeyHash256 TableId );

	/**
	 *	Move the BusModelDbKeyHash256ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelDbKeyHash256ColObj refreshed cache instance.
	 */
	IBusModelDbKeyHash256ColObj moveUpDbKeyHash256Col( IBusModelDbKeyHash256ColObj Obj );

	/**
	 *	Move the BusModelDbKeyHash256ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelDbKeyHash256ColObj refreshed cache instance.
	 */
	IBusModelDbKeyHash256ColObj moveDownDbKeyHash256Col( IBusModelDbKeyHash256ColObj Obj );
}
