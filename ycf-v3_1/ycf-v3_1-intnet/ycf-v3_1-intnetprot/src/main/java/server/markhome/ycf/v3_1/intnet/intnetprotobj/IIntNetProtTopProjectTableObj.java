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

public interface IIntNetProtTopProjectTableObj
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
	 *	Instantiate a new TopProject instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetProtTopProjectObj newInstance();

	/**
	 *	Instantiate a new TopProject edition of the specified TopProject instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetProtTopProjectEditObj newEditInstance( IIntNetProtTopProjectObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetProtTopProjectEditObj instance, which may be a subclass of a TopProject instance.
	 */
	IIntNetProtTopProjectObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTopProjectObj realiseTopProject( IIntNetProtTopProjectObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTopProjectObj createTopProject( IIntNetProtTopProjectObj Obj );

	/**
	 *	Read a TopProject-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopProject-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtTopProjectObj readTopProject( YCFDbKeyHash256 pkey );

	/**
	 *	Read a TopProject-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopProject-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtTopProjectObj readTopProject( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IIntNetProtTopProjectObj readCachedTopProject( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeTopProject( IIntNetProtTopProjectObj obj );

	void deepDisposeTopProject( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTopProjectObj lockTopProject( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the TopProject-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtTopProjectObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtTopProjectObj> readAllTopProject();

	/**
	 *	Return a sorted map of all the TopProject-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtTopProjectObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtTopProjectObj> readAllTopProject( boolean forceRead );

	List<IIntNetProtTopProjectObj> readCachedAllTopProject();

	/**
	 *	Get the IIntNetProtTopProjectObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTopProjectObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTopProjectObj readTopProjectByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IIntNetProtTopProjectObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTopProjectObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTopProjectObj readTopProjectByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtTopProjectObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTopProjectObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTopProjectObj> readTopProjectByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of List<IIntNetProtTopProjectObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTopProjectObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTopProjectObj> readTopProjectByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtTopProjectObj> instances sorted by their primary keys for the duplicate TopDomainIdx key.
	 *
	 *	@param	TopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTopProjectObj> cached instances sorted by their primary keys for the duplicate TopDomainIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTopProjectObj> readTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId );

	/**
	 *	Get the map of List<IIntNetProtTopProjectObj> instances sorted by their primary keys for the duplicate TopDomainIdx key.
	 *
	 *	@param	TopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTopProjectObj> cached instances sorted by their primary keys for the duplicate TopDomainIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTopProjectObj> readTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId,
		boolean forceRead );

	/**
	 *	Get the IIntNetProtTopProjectObj instance for the unique NameIdx key.
	 *
	 *	@param	TopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTopProjectObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTopProjectObj readTopProjectByNameIdx(IYCFKeyHash256 TopDomainId,
		String Name );

	/**
	 *	Get the IIntNetProtTopProjectObj instance for the unique NameIdx key.
	 *
	 *	@param	TopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTopProjectObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTopProjectObj readTopProjectByNameIdx(IYCFKeyHash256 TopDomainId,
		String Name,
		boolean forceRead );

	IIntNetProtTopProjectObj readCachedTopProjectByIdIdx( IYCFKeyHash256 Id );

	List<List<IIntNetProtTopProjectObj>> readCachedTopProjectByTenantIdx( IYCFKeyHash256 TenantId );

	List<List<IIntNetProtTopProjectObj>> readCachedTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId );

	IIntNetProtTopProjectObj readCachedTopProjectByNameIdx( IYCFKeyHash256 TopDomainId,
		String Name );

	void deepDisposeTopProjectByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeTopProjectByTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId );

	void deepDisposeTopProjectByNameIdx( IYCFKeyHash256 TopDomainId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTopProjectObj updateTopProject( IIntNetProtTopProjectObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTopProject( IIntNetProtTopProjectObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The TopProject key attribute of the instance generating the id.
	 */
	void deleteTopProjectByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TopProject key attribute of the instance generating the id.
	 */
	void deleteTopProjectByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TopDomainId	The TopProject key attribute of the instance generating the id.
	 */
	void deleteTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TopProject key attribute of the instance generating the id.
	 */
	void deleteTopProjectByNameIdx(IYCFKeyHash256 TopDomainId,
		String Name );
}
