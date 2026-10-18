// Description: Java 25 Protected Table Object interface for IntNetProt.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnetprotobj;

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
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IIntNetProtTldTableObj
{
	public IIntNetProtSchemaObj getSchema();
	public void setSchema( IIntNetProtSchemaObj value );

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
	 *	Instantiate a new Tld instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetProtTldObj newInstance();

	/**
	 *	Instantiate a new Tld edition of the specified Tld instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetProtTldEditObj newEditInstance( IIntNetProtTldObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetProtTldEditObj instance, which may be a subclass of a Tld instance.
	 */
	IIntNetProtTldObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTldObj realiseTld( IIntNetProtTldObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTldObj createTld( IIntNetProtTldObj Obj );

	/**
	 *	Read a Tld-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tld-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtTldObj readTld( YCFDbKeyHash256 pkey );

	/**
	 *	Read a Tld-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tld-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtTldObj readTld( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IIntNetProtTldObj readCachedTld( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeTld( IIntNetProtTldObj obj );

	void deepDisposeTld( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTldObj lockTld( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Tld-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtTldObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtTldObj> readAllTld();

	/**
	 *	Return a sorted map of all the Tld-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtTldObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtTldObj> readAllTld( boolean forceRead );

	List<IIntNetProtTldObj> readCachedAllTld();

	/**
	 *	Get the IIntNetProtTldObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTldObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTldObj readTldByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IIntNetProtTldObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTldObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTldObj readTldByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtTldObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTldObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTldObj> readTldByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of List<IIntNetProtTldObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTldObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTldObj> readTldByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the IIntNetProtTldObj instance for the unique NameIdx key.
	 *
	 *	@param	Name	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTldObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTldObj readTldByNameIdx(String Name );

	/**
	 *	Get the IIntNetProtTldObj instance for the unique NameIdx key.
	 *
	 *	@param	Name	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTldObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTldObj readTldByNameIdx(String Name,
		boolean forceRead );

	IIntNetProtTldObj readCachedTldByIdIdx( IYCFKeyHash256 Id );

	List<List<IIntNetProtTldObj>> readCachedTldByTenantIdx( IYCFKeyHash256 TenantId );

	IIntNetProtTldObj readCachedTldByNameIdx( String Name );

	void deepDisposeTldByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeTldByTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeTldByNameIdx( String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTldObj updateTld( IIntNetProtTldObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTld( IIntNetProtTldObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Tld key attribute of the instance generating the id.
	 */
	void deleteTldByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The Tld key attribute of the instance generating the id.
	 */
	void deleteTldByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	Name	The Tld key attribute of the instance generating the id.
	 */
	void deleteTldByNameIdx(String Name );
}
