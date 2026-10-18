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

public interface IBusModelClearSubDep2TableObj
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
	 *	Instantiate a new ClearSubDep2 instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelClearSubDep2Obj newInstance();

	/**
	 *	Instantiate a new ClearSubDep2 edition of the specified ClearSubDep2 instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelClearSubDep2EditObj newEditInstance( IBusModelClearSubDep2Obj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelClearSubDep2Obj realiseClearSubDep2( IBusModelClearSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelClearSubDep2Obj createClearSubDep2( IBusModelClearSubDep2Obj Obj );

	/**
	 *	Read a ClearSubDep2-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep2-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelClearSubDep2Obj readClearSubDep2( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a ClearSubDep2-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep2-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelClearSubDep2Obj readClearSubDep2( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelClearSubDep2Obj readCachedClearSubDep2( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeClearSubDep2( IBusModelClearSubDep2Obj obj );

	void deepDisposeClearSubDep2( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelClearSubDep2Obj lockClearSubDep2( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the ClearSubDep2-derived instances in the database.
	 *
	 *	@return	List of IBusModelClearSubDep2Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readAllClearSubDep2();

	/**
	 *	Return a sorted map of all the ClearSubDep2-derived instances in the database.
	 *
	 *	@return	List of IBusModelClearSubDep2Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readAllClearSubDep2( boolean forceRead );

	List<IBusModelClearSubDep2Obj> readCachedAllClearSubDep2();

	/**
	 *	Get the BusModelScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelClearSubDep2Obj readClearSubDep2ByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelClearSubDep2Obj readClearSubDep2ByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of BusModelScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelClearSubDep2Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelClearSubDep2Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelClearSubDep2Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelClearDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelClearSubDep2Obj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId );

	/**
	 *	Get the map of BusModelClearSubDep2Obj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelClearSubDep2Obj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelClearDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelClearSubDep2Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelClearSubDep2Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelClearSubDep2Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelClearSubDep2Obj instances sorted by their primary keys for the duplicate ClearSubDep1Idx key.
	 *
	 *	@param	ClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelClearSubDep2Obj cached instances sorted by their primary keys for the duplicate ClearSubDep1Idx key,
	 *		which may be an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id );

	/**
	 *	Get the map of BusModelClearSubDep2Obj instances sorted by their primary keys for the duplicate ClearSubDep1Idx key.
	 *
	 *	@param	ClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelClearSubDep2Obj cached instances sorted by their primary keys for the duplicate ClearSubDep1Idx key,
	 *		which may be an empty set.
	 */
	List<IBusModelClearSubDep2Obj> readClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id,
		boolean forceRead );

	/**
	 *	Get the BusModelClearSubDep2Obj instance for the unique UNameIdx key.
	 *
	 *	@param	ClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelClearSubDep2Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelClearSubDep2Obj readClearSubDep2ByUNameIdx(IYCFKeyHash256 ClearSubDep1Id,
		String Name );

	/**
	 *	Get the BusModelClearSubDep2Obj instance for the unique UNameIdx key.
	 *
	 *	@param	ClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	BusModelClearSubDep2Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelClearSubDep2Obj readClearSubDep2ByUNameIdx(IYCFKeyHash256 ClearSubDep1Id,
		String Name,
		boolean forceRead );

	IBusModelClearSubDep2Obj readCachedClearSubDep2ByIdIdx( IYCFKeyHash256 Id );

	List<IBusModelClearSubDep2Obj> readCachedClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId );

	List<IBusModelClearSubDep2Obj> readCachedClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId );

	List<IBusModelClearSubDep2Obj> readCachedClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelClearSubDep2Obj> readCachedClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id );

	IBusModelClearSubDep2Obj readCachedClearSubDep2ByUNameIdx( IYCFKeyHash256 ClearSubDep1Id,
		String Name );

	void deepDisposeClearSubDep2ByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId );

	void deepDisposeClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id );

	void deepDisposeClearSubDep2ByUNameIdx( IYCFKeyHash256 ClearSubDep1Id,
		String Name );

	/**
	 *	Internal use only.
	 */
	IBusModelClearSubDep2Obj updateClearSubDep2( IBusModelClearSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteClearSubDep2( IBusModelClearSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClearSubDep1Id	The ClearSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearSubDep2 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep2ByUNameIdx(IYCFKeyHash256 ClearSubDep1Id,
		String Name );
}
