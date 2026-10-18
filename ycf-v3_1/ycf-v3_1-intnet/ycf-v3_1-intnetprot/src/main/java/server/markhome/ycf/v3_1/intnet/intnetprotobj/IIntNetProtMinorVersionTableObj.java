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

public interface IIntNetProtMinorVersionTableObj
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
	 *	Instantiate a new MinorVersion instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetProtMinorVersionObj newInstance();

	/**
	 *	Instantiate a new MinorVersion edition of the specified MinorVersion instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetProtMinorVersionEditObj newEditInstance( IIntNetProtMinorVersionObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetProtMinorVersionEditObj instance, which may be a subclass of a MinorVersion instance.
	 */
	IIntNetProtMinorVersionObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMinorVersionObj realiseMinorVersion( IIntNetProtMinorVersionObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMinorVersionObj createMinorVersion( IIntNetProtMinorVersionObj Obj );

	/**
	 *	Read a MinorVersion-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MinorVersion-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtMinorVersionObj readMinorVersion( YCFDbKeyHash256 pkey );

	/**
	 *	Read a MinorVersion-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MinorVersion-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtMinorVersionObj readMinorVersion( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IIntNetProtMinorVersionObj readCachedMinorVersion( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeMinorVersion( IIntNetProtMinorVersionObj obj );

	void deepDisposeMinorVersion( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMinorVersionObj lockMinorVersion( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the MinorVersion-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtMinorVersionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtMinorVersionObj> readAllMinorVersion();

	/**
	 *	Return a sorted map of all the MinorVersion-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtMinorVersionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtMinorVersionObj> readAllMinorVersion( boolean forceRead );

	List<IIntNetProtMinorVersionObj> readCachedAllMinorVersion();

	/**
	 *	Get the IIntNetProtMinorVersionObj instance for the primary key attributes.
	 *
	 *	@param	Id	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMinorVersionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMinorVersionObj readMinorVersionByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IIntNetProtMinorVersionObj instance for the primary key attributes.
	 *
	 *	@param	Id	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMinorVersionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMinorVersionObj readMinorVersionByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtMinorVersionObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtMinorVersionObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtMinorVersionObj> readMinorVersionByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of List<IIntNetProtMinorVersionObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtMinorVersionObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtMinorVersionObj> readMinorVersionByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtMinorVersionObj> instances sorted by their primary keys for the duplicate MajorVerIdx key.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtMinorVersionObj> cached instances sorted by their primary keys for the duplicate MajorVerIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtMinorVersionObj> readMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId );

	/**
	 *	Get the map of List<IIntNetProtMinorVersionObj> instances sorted by their primary keys for the duplicate MajorVerIdx key.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtMinorVersionObj> cached instances sorted by their primary keys for the duplicate MajorVerIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtMinorVersionObj> readMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId,
		boolean forceRead );

	/**
	 *	Get the IIntNetProtMinorVersionObj instance for the unique NameIdx key.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMinorVersionObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMinorVersionObj readMinorVersionByNameIdx(IYCFKeyHash256 MajorVersionId,
		String Name );

	/**
	 *	Get the IIntNetProtMinorVersionObj instance for the unique NameIdx key.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMinorVersionObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMinorVersionObj readMinorVersionByNameIdx(IYCFKeyHash256 MajorVersionId,
		String Name,
		boolean forceRead );

	IIntNetProtMinorVersionObj readCachedMinorVersionByIdIdx( IYCFKeyHash256 Id );

	List<List<IIntNetProtMinorVersionObj>> readCachedMinorVersionByTenantIdx( IYCFKeyHash256 TenantId );

	List<List<IIntNetProtMinorVersionObj>> readCachedMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId );

	IIntNetProtMinorVersionObj readCachedMinorVersionByNameIdx( IYCFKeyHash256 MajorVersionId,
		String Name );

	void deepDisposeMinorVersionByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeMinorVersionByTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId );

	void deepDisposeMinorVersionByNameIdx( IYCFKeyHash256 MajorVersionId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMinorVersionObj updateMinorVersion( IIntNetProtMinorVersionObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteMinorVersion( IIntNetProtMinorVersionObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId );

	/**
	 *	Internal use only.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MinorVersion key attribute of the instance generating the id.
	 */
	void deleteMinorVersionByNameIdx(IYCFKeyHash256 MajorVersionId,
		String Name );
}
