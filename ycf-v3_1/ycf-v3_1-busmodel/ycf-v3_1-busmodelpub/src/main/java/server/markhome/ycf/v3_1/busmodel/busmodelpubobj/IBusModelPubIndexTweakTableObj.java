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

public interface IBusModelPubIndexTweakTableObj
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
	 *	Instantiate a new IndexTweak instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubIndexTweakObj newInstance();

	/**
	 *	Instantiate a new IndexTweak edition of the specified IndexTweak instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubIndexTweakEditObj newEditInstance( IBusModelPubIndexTweakObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubIndexTweakObj realiseIndexTweak( IBusModelPubIndexTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubIndexTweakObj createIndexTweak( IBusModelPubIndexTweakObj Obj );

	/**
	 *	Read a IndexTweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexTweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubIndexTweakObj readIndexTweak( IYCFKeyHash256 pkey );

	/**
	 *	Read a IndexTweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The IndexTweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubIndexTweakObj readIndexTweak( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubIndexTweakObj readCachedIndexTweak( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeIndexTweak( IBusModelPubIndexTweakObj obj );

	void deepDisposeIndexTweak( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubIndexTweakObj lockIndexTweak( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the IndexTweak-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubIndexTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readAllIndexTweak();

	/**
	 *	Return a sorted map of all the IndexTweak-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubIndexTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readAllIndexTweak( boolean forceRead );

	List<IBusModelPubIndexTweakObj> readCachedAllIndexTweak();

	/**
	 *	Get the BusModelPubTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexTweakObj readIndexTweakByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexTweakObj readIndexTweakByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexTweakObj readIndexTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexTweakObj readIndexTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexTweakObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readIndexTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelPubIndexTweakObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexTweakObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readIndexTweakByValTentIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexTweakObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readIndexTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelPubIndexTweakObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexTweakObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readIndexTweakByScopeIdx( YCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexTweakObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readIndexTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubIndexTweakObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexTweakObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readIndexTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj cached instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexTweakObj readIndexTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj refreshed instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubIndexTweakObj readIndexTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubIndexTweakObj instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	IndexId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexTweakObj cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readIndexTweakByIndexIdx( YCFDbKeyHash256 IndexId );

	/**
	 *	Get the map of BusModelPubIndexTweakObj instances sorted by their primary keys for the duplicate IndexIdx key.
	 *
	 *	@param	IndexId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubIndexTweakObj cached instances sorted by their primary keys for the duplicate IndexIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubIndexTweakObj> readIndexTweakByIndexIdx( YCFDbKeyHash256 IndexId,
		boolean forceRead );

	IBusModelPubIndexTweakObj readCachedIndexTweakByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubIndexTweakObj readCachedIndexTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	List<IBusModelPubIndexTweakObj> readCachedIndexTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	List<IBusModelPubIndexTweakObj> readCachedIndexTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	List<IBusModelPubIndexTweakObj> readCachedIndexTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	IBusModelPubIndexTweakObj readCachedIndexTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	List<IBusModelPubIndexTweakObj> readCachedIndexTweakByIndexIdx( YCFDbKeyHash256 IndexId );

	void deepDisposeIndexTweakByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeIndexTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeIndexTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeIndexTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	void deepDisposeIndexTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeIndexTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	void deepDisposeIndexTweakByIndexIdx( YCFDbKeyHash256 IndexId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubIndexTweakObj updateIndexTweak( IBusModelPubIndexTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteIndexTweak( IBusModelPubIndexTweakObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The IndexTweak key attribute of the instance generating the id.
	 */
	void deleteIndexTweakByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 */
	void deleteIndexTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 */
	void deleteIndexTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 */
	void deleteIndexTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 */
	void deleteIndexTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 */
	void deleteIndexTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	IndexId	The IndexTweak key attribute of the instance generating the id.
	 */
	void deleteIndexTweakByIndexIdx( YCFDbKeyHash256 IndexId );
}
