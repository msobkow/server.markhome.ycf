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

public interface IBusModelPubChainTableObj
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
	 *	Instantiate a new Chain instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubChainObj newInstance();

	/**
	 *	Instantiate a new Chain edition of the specified Chain instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubChainEditObj newEditInstance( IBusModelPubChainObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IBusModelPubChainObj instance, which may be a subclass of a Chain instance.
	 */
	IBusModelPubChainObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IBusModelPubChainObj realiseChain( IBusModelPubChainObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubChainObj createChain( IBusModelPubChainObj Obj );

	/**
	 *	Read a Chain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Chain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubChainObj readChain( IYCFKeyHash256 pkey );

	/**
	 *	Read a Chain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Chain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubChainObj readChain( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubChainObj readCachedChain( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeChain( IBusModelPubChainObj obj );

	void deepDisposeChain( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubChainObj lockChain( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Chain-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubChainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubChainObj> readAllChain();

	/**
	 *	Return a sorted map of all the Chain-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubChainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubChainObj> readAllChain( boolean forceRead );

	List<IBusModelPubChainObj> readCachedAllChain();

	/**
	 *	Get the BusModelPubChainObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubChainObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubChainObj readChainByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubChainObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubChainObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubChainObj readChainByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubChainObj instances sorted by their primary keys for the duplicate ChainTableIdx key.
	 *
	 *	@param	TableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubChainObj cached instances sorted by their primary keys for the duplicate ChainTableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubChainObj> readChainByChainTableIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Get the map of BusModelPubChainObj instances sorted by their primary keys for the duplicate ChainTableIdx key.
	 *
	 *	@param	TableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubChainObj cached instances sorted by their primary keys for the duplicate ChainTableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubChainObj> readChainByChainTableIdx( YCFDbKeyHash256 TableId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubChainObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubChainObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubChainObj> readChainByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubChainObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubChainObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubChainObj> readChainByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubChainObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubChainObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubChainObj readChainByUNameIdx(YCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Get the BusModelPubChainObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubChainObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubChainObj readChainByUNameIdx(YCFDbKeyHash256 TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubChainObj instances sorted by their primary keys for the duplicate PrevRelIdx key.
	 *
	 *	@param	PrevRelationId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubChainObj cached instances sorted by their primary keys for the duplicate PrevRelIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubChainObj> readChainByPrevRelIdx( YCFDbKeyHash256 PrevRelationId );

	/**
	 *	Get the map of BusModelPubChainObj instances sorted by their primary keys for the duplicate PrevRelIdx key.
	 *
	 *	@param	PrevRelationId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubChainObj cached instances sorted by their primary keys for the duplicate PrevRelIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubChainObj> readChainByPrevRelIdx( YCFDbKeyHash256 PrevRelationId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubChainObj instances sorted by their primary keys for the duplicate NextRelIdx key.
	 *
	 *	@param	NextRelationId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubChainObj cached instances sorted by their primary keys for the duplicate NextRelIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubChainObj> readChainByNextRelIdx( YCFDbKeyHash256 NextRelationId );

	/**
	 *	Get the map of BusModelPubChainObj instances sorted by their primary keys for the duplicate NextRelIdx key.
	 *
	 *	@param	NextRelationId	The Chain key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubChainObj cached instances sorted by their primary keys for the duplicate NextRelIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubChainObj> readChainByNextRelIdx( YCFDbKeyHash256 NextRelationId,
		boolean forceRead );

	IBusModelPubChainObj readCachedChainByIdIdx( YCFDbKeyHash256 Id );

	List<IBusModelPubChainObj> readCachedChainByChainTableIdx( YCFDbKeyHash256 TableId );

	List<IBusModelPubChainObj> readCachedChainByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	IBusModelPubChainObj readCachedChainByUNameIdx( YCFDbKeyHash256 TableId,
		String Name );

	List<IBusModelPubChainObj> readCachedChainByPrevRelIdx( YCFDbKeyHash256 PrevRelationId );

	List<IBusModelPubChainObj> readCachedChainByNextRelIdx( YCFDbKeyHash256 NextRelationId );

	void deepDisposeChainByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeChainByChainTableIdx( YCFDbKeyHash256 TableId );

	void deepDisposeChainByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeChainByUNameIdx( YCFDbKeyHash256 TableId,
		String Name );

	void deepDisposeChainByPrevRelIdx( YCFDbKeyHash256 PrevRelationId );

	void deepDisposeChainByNextRelIdx( YCFDbKeyHash256 NextRelationId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubChainObj updateChain( IBusModelPubChainObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteChain( IBusModelPubChainObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByChainTableIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The Chain key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByUNameIdx(YCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevRelationId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByPrevRelIdx( YCFDbKeyHash256 PrevRelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextRelationId	The Chain key attribute of the instance generating the id.
	 */
	void deleteChainByNextRelIdx( YCFDbKeyHash256 NextRelationId );
}
