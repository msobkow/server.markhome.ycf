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

public interface IIntNetPubMinorVersionTableObj
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
	 *	Instantiate a new MinorVersion instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetPubMinorVersionObj newInstance();

	/**
	 *	Instantiate a new MinorVersion edition of the specified MinorVersion instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetPubMinorVersionEditObj newEditInstance( IIntNetPubMinorVersionObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetPubMinorVersionObj instance, which may be a subclass of a MinorVersion instance.
	 */
	IIntNetPubMinorVersionObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMinorVersionObj realiseMinorVersion( IIntNetPubMinorVersionObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMinorVersionObj createMinorVersion( IIntNetPubMinorVersionObj Obj );

	/**
	 *	Read a MinorVersion-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MinorVersion-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubMinorVersionObj readMinorVersion( IYCFKeyHash256 pkey );

	/**
	 *	Read a MinorVersion-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MinorVersion-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubMinorVersionObj readMinorVersion( IYCFKeyHash256 pkey,
		boolean forceRead );

	IIntNetPubMinorVersionObj readCachedMinorVersion( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeMinorVersion( IIntNetPubMinorVersionObj obj );

	void deepDisposeMinorVersion( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMinorVersionObj lockMinorVersion( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the MinorVersion-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubMinorVersionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubMinorVersionObj> readAllMinorVersion();

	/**
	 *	Return a sorted map of all the MinorVersion-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubMinorVersionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubMinorVersionObj> readAllMinorVersion( boolean forceRead );

	List<IIntNetPubMinorVersionObj> readCachedAllMinorVersion();

	/**
	 *	Get the IntNetPubMinorVersionObj instance for the primary key attributes.
	 *
	 *	@param	Id	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMinorVersionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMinorVersionObj readMinorVersionByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the IntNetPubMinorVersionObj instance for the primary key attributes.
	 *
	 *	@param	Id	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMinorVersionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMinorVersionObj readMinorVersionByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of IntNetPubMinorVersionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubMinorVersionObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubMinorVersionObj> readMinorVersionByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of IntNetPubMinorVersionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubMinorVersionObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubMinorVersionObj> readMinorVersionByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of IntNetPubMinorVersionObj instances sorted by their primary keys for the duplicate MajorVerIdx key.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubMinorVersionObj cached instances sorted by their primary keys for the duplicate MajorVerIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubMinorVersionObj> readMinorVersionByMajorVerIdx( YCFDbKeyHash256 MajorVersionId );

	/**
	 *	Get the map of IntNetPubMinorVersionObj instances sorted by their primary keys for the duplicate MajorVerIdx key.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubMinorVersionObj cached instances sorted by their primary keys for the duplicate MajorVerIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubMinorVersionObj> readMinorVersionByMajorVerIdx( YCFDbKeyHash256 MajorVersionId,
		boolean forceRead );

	/**
	 *	Get the IntNetPubMinorVersionObj instance for the unique NameIdx key.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMinorVersionObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMinorVersionObj readMinorVersionByNameIdx(YCFDbKeyHash256 MajorVersionId,
		String Name );

	/**
	 *	Get the IntNetPubMinorVersionObj instance for the unique NameIdx key.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMinorVersionObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMinorVersionObj readMinorVersionByNameIdx(YCFDbKeyHash256 MajorVersionId,
		String Name,
		boolean forceRead );

	IIntNetPubMinorVersionObj readCachedMinorVersionByIdIdx( YCFDbKeyHash256 Id );

	List<IIntNetPubMinorVersionObj> readCachedMinorVersionByTenantIdx( YCFDbKeyHash256 TenantId );

	List<IIntNetPubMinorVersionObj> readCachedMinorVersionByMajorVerIdx( YCFDbKeyHash256 MajorVersionId );

	IIntNetPubMinorVersionObj readCachedMinorVersionByNameIdx( YCFDbKeyHash256 MajorVersionId,
		String Name );

	void deepDisposeMinorVersionByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeMinorVersionByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeMinorVersionByMajorVerIdx( YCFDbKeyHash256 MajorVersionId );

	void deepDisposeMinorVersionByNameIdx( YCFDbKeyHash256 MajorVersionId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMinorVersionObj updateMinorVersion( IIntNetPubMinorVersionObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteMinorVersion( IIntNetPubMinorVersionObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByMajorVerIdx( YCFDbKeyHash256 MajorVersionId );

	/**
	 *	Internal use only.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByNameIdx(YCFDbKeyHash256 MajorVersionId,
		String Name );
}
