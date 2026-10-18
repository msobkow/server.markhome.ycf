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

public interface IBusModelPubTableTweakTableObj
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
	 *	Instantiate a new TableTweak instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubTableTweakObj newInstance();

	/**
	 *	Instantiate a new TableTweak edition of the specified TableTweak instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubTableTweakEditObj newEditInstance( IBusModelPubTableTweakObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTableTweakObj realiseTableTweak( IBusModelPubTableTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTableTweakObj createTableTweak( IBusModelPubTableTweakObj Obj );

	/**
	 *	Read a TableTweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TableTweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubTableTweakObj readTableTweak( IYCFKeyHash256 pkey );

	/**
	 *	Read a TableTweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TableTweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubTableTweakObj readTableTweak( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubTableTweakObj readCachedTableTweak( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeTableTweak( IBusModelPubTableTweakObj obj );

	void deepDisposeTableTweak( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTableTweakObj lockTableTweak( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the TableTweak-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubTableTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubTableTweakObj> readAllTableTweak();

	/**
	 *	Return a sorted map of all the TableTweak-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubTableTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubTableTweakObj> readAllTableTweak( boolean forceRead );

	List<IBusModelPubTableTweakObj> readCachedAllTableTweak();

	/**
	 *	Get the BusModelPubTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableTweakObj readTableTweakByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableTweakObj readTableTweakByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableTweakObj readTableTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableTweakObj readTableTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableTweakObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableTweakObj> readTableTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelPubTableTweakObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableTweakObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableTweakObj> readTableTweakByValTentIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableTweakObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableTweakObj> readTableTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelPubTableTweakObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableTweakObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableTweakObj> readTableTweakByScopeIdx( YCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableTweakObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableTweakObj> readTableTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubTableTweakObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableTweakObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableTweakObj> readTableTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj cached instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableTweakObj readTableTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj refreshed instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTableTweakObj readTableTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTableTweakObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableTweakObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableTweakObj> readTableTweakByTableIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Get the map of BusModelPubTableTweakObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTableTweakObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTableTweakObj> readTableTweakByTableIdx( YCFDbKeyHash256 TableId,
		boolean forceRead );

	IBusModelPubTableTweakObj readCachedTableTweakByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubTableTweakObj readCachedTableTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	List<IBusModelPubTableTweakObj> readCachedTableTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	List<IBusModelPubTableTweakObj> readCachedTableTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	List<IBusModelPubTableTweakObj> readCachedTableTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	IBusModelPubTableTweakObj readCachedTableTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	List<IBusModelPubTableTweakObj> readCachedTableTweakByTableIdx( YCFDbKeyHash256 TableId );

	void deepDisposeTableTweakByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeTableTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeTableTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeTableTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	void deepDisposeTableTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeTableTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	void deepDisposeTableTweakByTableIdx( YCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTableTweakObj updateTableTweak( IBusModelPubTableTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTableTweak( IBusModelPubTableTweakObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The TableTweak key attribute of the instance generating the id.
	 */
	void deleteTableTweakByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TableTweak key attribute of the instance generating the id.
	 */
	void deleteTableTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TableTweak key attribute of the instance generating the id.
	 */
	void deleteTableTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TableTweak key attribute of the instance generating the id.
	 */
	void deleteTableTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The TableTweak key attribute of the instance generating the id.
	 */
	void deleteTableTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The TableTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TableTweak key attribute of the instance generating the id.
	 */
	void deleteTableTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The TableTweak key attribute of the instance generating the id.
	 */
	void deleteTableTweakByTableIdx( YCFDbKeyHash256 TableId );
}
