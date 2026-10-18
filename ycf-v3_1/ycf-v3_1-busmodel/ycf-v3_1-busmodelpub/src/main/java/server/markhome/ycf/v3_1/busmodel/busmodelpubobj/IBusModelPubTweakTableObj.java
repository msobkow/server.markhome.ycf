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

public interface IBusModelPubTweakTableObj
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
	 *	Instantiate a new Tweak instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubTweakObj newInstance();

	/**
	 *	Instantiate a new Tweak edition of the specified Tweak instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubTweakEditObj newEditInstance( IBusModelPubTweakObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IBusModelPubTweakObj instance, which may be a subclass of a Tweak instance.
	 */
	IBusModelPubTweakObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTweakObj realiseTweak( IBusModelPubTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTweakObj createTweak( IBusModelPubTweakObj Obj );

	/**
	 *	Read a Tweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubTweakObj readTweak( IYCFKeyHash256 pkey );

	/**
	 *	Read a Tweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubTweakObj readTweak( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubTweakObj readCachedTweak( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeTweak( IBusModelPubTweakObj obj );

	void deepDisposeTweak( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTweakObj lockTweak( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Tweak-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubTweakObj> readAllTweak();

	/**
	 *	Return a sorted map of all the Tweak-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubTweakObj> readAllTweak( boolean forceRead );

	List<IBusModelPubTweakObj> readCachedAllTweak();

	/**
	 *	Get the BusModelPubTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTweakObj readTweakByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTweakObj readTweakByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTweakObj readTweakByUNameIdx(YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTweakObj readTweakByUNameIdx(YCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTweakObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTweakObj> readTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTweakObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTweakObj> readTweakByValTentIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTweakObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTweakObj> readTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTweakObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTweakObj> readTweakByScopeIdx( YCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTweakObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTweakObj> readTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelPubTweakObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubTweakObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubTweakObj> readTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj cached instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTweakObj readTweakByUDefIdx(YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Get the BusModelPubTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubTweakObj refreshed instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubTweakObj readTweakByUDefIdx(YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name,
		boolean forceRead );

	IBusModelPubTweakObj readCachedTweakByIdIdx( YCFDbKeyHash256 Id );

	IBusModelPubTweakObj readCachedTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	List<IBusModelPubTweakObj> readCachedTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	List<IBusModelPubTweakObj> readCachedTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	List<IBusModelPubTweakObj> readCachedTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	IBusModelPubTweakObj readCachedTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	void deepDisposeTweakByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeTweakByUNameIdx( YCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	void deepDisposeTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	void deepDisposeTweakByUDefIdx( YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IBusModelPubTweakObj updateTweak( IBusModelPubTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTweak( IBusModelPubTweakObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByUNameIdx(YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByValTentIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByScopeIdx( YCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByDefSchemaIdx( YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByUDefIdx(YCFDbKeyHash256 TenantId,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 DefSchemaTenantId,
		YCFDbKeyHash256 DefSchemaId,
		String Name );
}
