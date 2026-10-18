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

public interface IBusModelBlobTypeTableObj
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
	 *	Instantiate a new BlobType instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelBlobTypeObj newInstance();

	/**
	 *	Instantiate a new BlobType edition of the specified BlobType instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelBlobTypeEditObj newEditInstance( IBusModelBlobTypeObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelBlobTypeObj realiseBlobType( IBusModelBlobTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelBlobTypeObj createBlobType( IBusModelBlobTypeObj Obj );

	/**
	 *	Read a BlobType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BlobType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelBlobTypeObj readBlobType( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a BlobType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BlobType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelBlobTypeObj readBlobType( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelBlobTypeObj readCachedBlobType( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeBlobType( IBusModelBlobTypeObj obj );

	void deepDisposeBlobType( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelBlobTypeObj lockBlobType( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the BlobType-derived instances in the database.
	 *
	 *	@return	List of IBusModelBlobTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelBlobTypeObj> readAllBlobType();

	/**
	 *	Return a sorted map of all the BlobType-derived instances in the database.
	 *
	 *	@return	List of IBusModelBlobTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelBlobTypeObj> readAllBlobType( boolean forceRead );

	List<IBusModelBlobTypeObj> readCachedAllBlobType();

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelBlobTypeObj readBlobTypeByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelBlobTypeObj readBlobTypeByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelBlobTypeObj readBlobTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelBlobTypeObj readBlobTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelBlobTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelBlobTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelBlobTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelBlobTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelBlobTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelBlobTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelBlobTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Get the map of BusModelBlobTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelBlobTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelBlobTypeObj> readBlobTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead );

	IBusModelBlobTypeObj readCachedBlobTypeByIdIdx( IYCFKeyHash256 Id );

	IBusModelBlobTypeObj readCachedBlobTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<IBusModelBlobTypeObj> readCachedBlobTypeByScopeIdx( IYCFKeyHash256 ScopeId );

	List<IBusModelBlobTypeObj> readCachedBlobTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelBlobTypeObj> readCachedBlobTypeByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelBlobTypeObj> readCachedBlobTypeByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelBlobTypeObj> readCachedBlobTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	List<IBusModelBlobTypeObj> readCachedBlobTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	List<IBusModelBlobTypeObj> readCachedBlobTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	void deepDisposeBlobTypeByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeBlobTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeBlobTypeByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeBlobTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeBlobTypeByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeBlobTypeByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeBlobTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	void deepDisposeBlobTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	void deepDisposeBlobTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	IBusModelBlobTypeObj updateBlobType( IBusModelBlobTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteBlobType( IBusModelBlobTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId );

	/**
	 *	Move the BusModelBlobTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelBlobTypeObj refreshed cache instance.
	 */
	IBusModelBlobTypeObj moveUpBlobType( IBusModelBlobTypeObj Obj );

	/**
	 *	Move the BusModelBlobTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelBlobTypeObj refreshed cache instance.
	 */
	IBusModelBlobTypeObj moveDownBlobType( IBusModelBlobTypeObj Obj );
}
