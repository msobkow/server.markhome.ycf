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

public interface IIntNetProtTopDomainTableObj
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
	 *	Instantiate a new TopDomain instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetProtTopDomainObj newInstance();

	/**
	 *	Instantiate a new TopDomain edition of the specified TopDomain instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetProtTopDomainEditObj newEditInstance( IIntNetProtTopDomainObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetProtTopDomainEditObj instance, which may be a subclass of a TopDomain instance.
	 */
	IIntNetProtTopDomainObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTopDomainObj realiseTopDomain( IIntNetProtTopDomainObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTopDomainObj createTopDomain( IIntNetProtTopDomainObj Obj );

	/**
	 *	Read a TopDomain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopDomain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtTopDomainObj readTopDomain( YCFDbKeyHash256 pkey );

	/**
	 *	Read a TopDomain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopDomain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtTopDomainObj readTopDomain( YCFDbKeyHash256 pkey,
		boolean forceRead );

	IIntNetProtTopDomainObj readCachedTopDomain( YCFDbKeyHash256 pkey );

	public void reallyDeepDisposeTopDomain( IIntNetProtTopDomainObj obj );

	void deepDisposeTopDomain( YCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTopDomainObj lockTopDomain( YCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the TopDomain-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtTopDomainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtTopDomainObj> readAllTopDomain();

	/**
	 *	Return a sorted map of all the TopDomain-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtTopDomainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtTopDomainObj> readAllTopDomain( boolean forceRead );

	List<IIntNetProtTopDomainObj> readCachedAllTopDomain();

	/**
	 *	Get the IIntNetProtTopDomainObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTopDomainObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTopDomainObj readTopDomainByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the IIntNetProtTopDomainObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTopDomainObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTopDomainObj readTopDomainByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtTopDomainObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTopDomainObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTopDomainObj> readTopDomainByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Get the map of List<IIntNetProtTopDomainObj> instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTopDomainObj> cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTopDomainObj> readTopDomainByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtTopDomainObj> instances sorted by their primary keys for the duplicate TldIdx key.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTopDomainObj> cached instances sorted by their primary keys for the duplicate TldIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTopDomainObj> readTopDomainByTldIdx( IYCFKeyHash256 TldId );

	/**
	 *	Get the map of List<IIntNetProtTopDomainObj> instances sorted by their primary keys for the duplicate TldIdx key.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtTopDomainObj> cached instances sorted by their primary keys for the duplicate TldIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtTopDomainObj> readTopDomainByTldIdx( IYCFKeyHash256 TldId,
		boolean forceRead );

	/**
	 *	Get the IIntNetProtTopDomainObj instance for the unique NameIdx key.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTopDomainObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTopDomainObj readTopDomainByNameIdx(IYCFKeyHash256 TldId,
		String Name );

	/**
	 *	Get the IIntNetProtTopDomainObj instance for the unique NameIdx key.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtTopDomainObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtTopDomainObj readTopDomainByNameIdx(IYCFKeyHash256 TldId,
		String Name,
		boolean forceRead );

	IIntNetProtTopDomainObj readCachedTopDomainByIdIdx( IYCFKeyHash256 Id );

	List<List<IIntNetProtTopDomainObj>> readCachedTopDomainByTenantIdx( IYCFKeyHash256 TenantId );

	List<List<IIntNetProtTopDomainObj>> readCachedTopDomainByTldIdx( IYCFKeyHash256 TldId );

	IIntNetProtTopDomainObj readCachedTopDomainByNameIdx( IYCFKeyHash256 TldId,
		String Name );

	void deepDisposeTopDomainByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeTopDomainByTenantIdx( IYCFKeyHash256 TenantId );

	void deepDisposeTopDomainByTldIdx( IYCFKeyHash256 TldId );

	void deepDisposeTopDomainByNameIdx( IYCFKeyHash256 TldId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetProtTopDomainObj updateTopDomain( IIntNetProtTopDomainObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTopDomain( IIntNetProtTopDomainObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByTenantIdx( IYCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByTldIdx( IYCFKeyHash256 TldId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByNameIdx(IYCFKeyHash256 TldId,
		String Name );
}
