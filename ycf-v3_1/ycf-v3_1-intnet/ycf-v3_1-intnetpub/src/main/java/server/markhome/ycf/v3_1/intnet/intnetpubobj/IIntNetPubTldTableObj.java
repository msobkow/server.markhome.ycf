// Description: Java 25 Public Table Object interface for IntNetPub.

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

package server.markhome.ycf.v3_1.intnet.intnetpubobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetPubTldTableObj
{
	public IIntNetPubSchemaObj getSchema();
	public void setSchema( IIntNetPubSchemaObj value );

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
	IIntNetPubTldObj newInstance();

	/**
	 *	Instantiate a new Tld edition of the specified Tld instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetPubTldEditObj newEditInstance( IIntNetPubTldObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetPubTldObj instance, which may be a subclass of a Tld instance.
	 */
	IIntNetPubTldObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetPubTldObj realiseTld( IIntNetPubTldObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetPubTldObj createTld( IIntNetPubTldObj Obj );

	/**
	 *	Read a Tld-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tld-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubTldObj readTld( IYCFKeyHash256 pkey );

	/**
	 *	Read a Tld-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tld-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubTldObj readTld( IYCFKeyHash256 pkey,
		boolean forceRead );

	IIntNetPubTldObj readCachedTld( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeTld( IIntNetPubTldObj obj );

	void deepDisposeTld( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetPubTldObj lockTld( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Tld-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubTldObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubTldObj> readAllTld();

	/**
	 *	Return a sorted map of all the Tld-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubTldObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubTldObj> readAllTld( boolean forceRead );

	List<IIntNetPubTldObj> readCachedAllTld();

	/**
	 *	Get the IntNetPubTldObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubTldObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubTldObj readTldByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the IntNetPubTldObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubTldObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubTldObj readTldByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of IntNetPubTldObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubTldObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubTldObj> readTldByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of IntNetPubTldObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubTldObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubTldObj> readTldByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the IntNetPubTldObj instance for the unique NameIdx key.
	 *
	 *	@param	Name	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubTldObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubTldObj readTldByNameIdx(String Name );

	/**
	 *	Get the IntNetPubTldObj instance for the unique NameIdx key.
	 *
	 *	@param	Name	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubTldObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubTldObj readTldByNameIdx(String Name,
		boolean forceRead );

	IIntNetPubTldObj readCachedTldByIdIdx( YCFDbKeyHash256 Id );

	List<IIntNetPubTldObj> readCachedTldByTenantIdx( YCFDbKeyHash256 TenantId );

	IIntNetPubTldObj readCachedTldByNameIdx( String Name );

	void deepDisposeTldByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeTldByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeTldByNameIdx( String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetPubTldObj updateTld( IIntNetPubTldObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTld( IIntNetPubTldObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Tld key attribute of the instance generating the id.
	 */
	void deleteTldByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The Tld key attribute of the instance generating the id.
	 */
	void deleteTldByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	Name	The Tld key attribute of the instance generating the id.
	 */
	void deleteTldByNameIdx(String Name );
}
