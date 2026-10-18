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

public interface IIntNetPubMajorVersionTableObj
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
	 *	Instantiate a new MajorVersion instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetPubMajorVersionObj newInstance();

	/**
	 *	Instantiate a new MajorVersion edition of the specified MajorVersion instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetPubMajorVersionEditObj newEditInstance( IIntNetPubMajorVersionObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetPubMajorVersionObj instance, which may be a subclass of a MajorVersion instance.
	 */
	IIntNetPubMajorVersionObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMajorVersionObj realiseMajorVersion( IIntNetPubMajorVersionObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMajorVersionObj createMajorVersion( IIntNetPubMajorVersionObj Obj );

	/**
	 *	Read a MajorVersion-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MajorVersion-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubMajorVersionObj readMajorVersion( IYCFKeyHash256 pkey );

	/**
	 *	Read a MajorVersion-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MajorVersion-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubMajorVersionObj readMajorVersion( IYCFKeyHash256 pkey,
		boolean forceRead );

	IIntNetPubMajorVersionObj readCachedMajorVersion( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeMajorVersion( IIntNetPubMajorVersionObj obj );

	void deepDisposeMajorVersion( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMajorVersionObj lockMajorVersion( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the MajorVersion-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubMajorVersionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubMajorVersionObj> readAllMajorVersion();

	/**
	 *	Return a sorted map of all the MajorVersion-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubMajorVersionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubMajorVersionObj> readAllMajorVersion( boolean forceRead );

	List<IIntNetPubMajorVersionObj> readCachedAllMajorVersion();

	/**
	 *	Get the IntNetPubMajorVersionObj instance for the primary key attributes.
	 *
	 *	@param	Id	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMajorVersionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMajorVersionObj readMajorVersionByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the IntNetPubMajorVersionObj instance for the primary key attributes.
	 *
	 *	@param	Id	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMajorVersionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMajorVersionObj readMajorVersionByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of IntNetPubMajorVersionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubMajorVersionObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubMajorVersionObj> readMajorVersionByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of IntNetPubMajorVersionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubMajorVersionObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubMajorVersionObj> readMajorVersionByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of IntNetPubMajorVersionObj instances sorted by their primary keys for the duplicate SubProjectIdx key.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubMajorVersionObj cached instances sorted by their primary keys for the duplicate SubProjectIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubMajorVersionObj> readMajorVersionBySubProjectIdx( YCFDbKeyHash256 SubProjectId );

	/**
	 *	Get the map of IntNetPubMajorVersionObj instances sorted by their primary keys for the duplicate SubProjectIdx key.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubMajorVersionObj cached instances sorted by their primary keys for the duplicate SubProjectIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubMajorVersionObj> readMajorVersionBySubProjectIdx( YCFDbKeyHash256 SubProjectId,
		boolean forceRead );

	/**
	 *	Get the IntNetPubMajorVersionObj instance for the unique NameIdx key.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMajorVersionObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMajorVersionObj readMajorVersionByNameIdx(YCFDbKeyHash256 SubProjectId,
		String Name );

	/**
	 *	Get the IntNetPubMajorVersionObj instance for the unique NameIdx key.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMajorVersionObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMajorVersionObj readMajorVersionByNameIdx(YCFDbKeyHash256 SubProjectId,
		String Name,
		boolean forceRead );

	IIntNetPubMajorVersionObj readCachedMajorVersionByIdIdx( YCFDbKeyHash256 Id );

	List<IIntNetPubMajorVersionObj> readCachedMajorVersionByTenantIdx( YCFDbKeyHash256 TenantId );

	List<IIntNetPubMajorVersionObj> readCachedMajorVersionBySubProjectIdx( YCFDbKeyHash256 SubProjectId );

	IIntNetPubMajorVersionObj readCachedMajorVersionByNameIdx( YCFDbKeyHash256 SubProjectId,
		String Name );

	void deepDisposeMajorVersionByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeMajorVersionByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeMajorVersionBySubProjectIdx( YCFDbKeyHash256 SubProjectId );

	void deepDisposeMajorVersionByNameIdx( YCFDbKeyHash256 SubProjectId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMajorVersionObj updateMajorVersion( IIntNetPubMajorVersionObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteMajorVersion( IIntNetPubMajorVersionObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionBySubProjectIdx( YCFDbKeyHash256 SubProjectId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionByNameIdx(YCFDbKeyHash256 SubProjectId,
		String Name );
}
