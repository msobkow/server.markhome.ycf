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

public interface IIntNetProtMajorVersionTableObj
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
	 *	Instantiate a new MajorVersion instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetProtMajorVersionObj newInstance();

	/**
	 *	Instantiate a new MajorVersion edition of the specified MajorVersion instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetProtMajorVersionEditObj newEditInstance( IIntNetProtMajorVersionObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetProtMajorVersionEditObj instance, which may be a subclass of a MajorVersion instance.
	 */
	IIntNetProtMajorVersionObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMajorVersionObj realiseMajorVersion( IIntNetProtMajorVersionObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMajorVersionObj createMajorVersion( IIntNetProtMajorVersionObj Obj );

	/**
	 *	Read a MajorVersion-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MajorVersion-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtMajorVersionObj readMajorVersion( YCFDbKeyHash256 pkey );

	/**
	 *	Read a MajorVersion-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MajorVersion-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtMajorVersionObj readMajorVersion( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IIntNetProtMajorVersionObj readCachedMajorVersion( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeMajorVersion( IIntNetProtMajorVersionObj obj );

	void deepDisposeMajorVersion( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMajorVersionObj lockMajorVersion( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the MajorVersion-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtMajorVersionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtMajorVersionObj> readAllMajorVersion();

	/**
	 *	Return a sorted map of all the MajorVersion-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtMajorVersionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtMajorVersionObj> readAllMajorVersion( boolean forceRead );

	List<IIntNetProtMajorVersionObj> readCachedAllMajorVersion();

	/**
	 *	Get the IIntNetProtMajorVersionObj instance for the primary key attributes.
	 *
	 *	@param	Id	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMajorVersionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMajorVersionObj readMajorVersionByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IIntNetProtMajorVersionObj instance for the primary key attributes.
	 *
	 *	@param	Id	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMajorVersionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMajorVersionObj readMajorVersionByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtMajorVersionObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtMajorVersionObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtMajorVersionObj> readMajorVersionByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of List<IIntNetProtMajorVersionObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtMajorVersionObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtMajorVersionObj> readMajorVersionByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtMajorVersionObj> instances sorted by their primary keys for the duplicate SubProjectIdx key.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtMajorVersionObj> cached instances sorted by their primary keys for the duplicate SubProjectIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtMajorVersionObj> readMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId );

	/**
	 *	Get the map of List<IIntNetProtMajorVersionObj> instances sorted by their primary keys for the duplicate SubProjectIdx key.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtMajorVersionObj> cached instances sorted by their primary keys for the duplicate SubProjectIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtMajorVersionObj> readMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId,
		boolean forceRead );

	/**
	 *	Get the IIntNetProtMajorVersionObj instance for the unique NameIdx key.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMajorVersionObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMajorVersionObj readMajorVersionByNameIdx(IYCFKeyHash256 SubProjectId,
		String Name );

	/**
	 *	Get the IIntNetProtMajorVersionObj instance for the unique NameIdx key.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMajorVersionObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMajorVersionObj readMajorVersionByNameIdx(IYCFKeyHash256 SubProjectId,
		String Name,
		boolean forceRead );

	IIntNetProtMajorVersionObj readCachedMajorVersionByIdIdx( IYCFKeyHash256 Id );

	List<List<IIntNetProtMajorVersionObj>> readCachedMajorVersionByTenantIdx( IYCFKeyHash256 TenantId );

	List<List<IIntNetProtMajorVersionObj>> readCachedMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId );

	IIntNetProtMajorVersionObj readCachedMajorVersionByNameIdx( IYCFKeyHash256 SubProjectId,
		String Name );

	void deepDisposeMajorVersionByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeMajorVersionByTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId );

	void deepDisposeMajorVersionByNameIdx( IYCFKeyHash256 SubProjectId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMajorVersionObj updateMajorVersion( IIntNetProtMajorVersionObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteMajorVersion( IIntNetProtMajorVersionObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SubProjectId	The MajorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MajorVersion key attribute of the instance generating the id.
	 */
	void deleteMajorVersionByNameIdx(IYCFKeyHash256 SubProjectId,
		String Name );
}
