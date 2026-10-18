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

public interface IIntNetPubTopDomainTableObj
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
	 *	Instantiate a new TopDomain instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetPubTopDomainObj newInstance();

	/**
	 *	Instantiate a new TopDomain edition of the specified TopDomain instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetPubTopDomainEditObj newEditInstance( IIntNetPubTopDomainObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetPubTopDomainObj instance, which may be a subclass of a TopDomain instance.
	 */
	IIntNetPubTopDomainObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetPubTopDomainObj realiseTopDomain( IIntNetPubTopDomainObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetPubTopDomainObj createTopDomain( IIntNetPubTopDomainObj Obj );

	/**
	 *	Read a TopDomain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopDomain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubTopDomainObj readTopDomain( IYCFKeyHash256 pkey );

	/**
	 *	Read a TopDomain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopDomain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubTopDomainObj readTopDomain( IYCFKeyHash256 pkey,
		boolean forceRead );

	IIntNetPubTopDomainObj readCachedTopDomain( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeTopDomain( IIntNetPubTopDomainObj obj );

	void deepDisposeTopDomain( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetPubTopDomainObj lockTopDomain( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the TopDomain-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubTopDomainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubTopDomainObj> readAllTopDomain();

	/**
	 *	Return a sorted map of all the TopDomain-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubTopDomainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubTopDomainObj> readAllTopDomain( boolean forceRead );

	List<IIntNetPubTopDomainObj> readCachedAllTopDomain();

	/**
	 *	Get the IntNetPubTopDomainObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubTopDomainObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubTopDomainObj readTopDomainByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the IntNetPubTopDomainObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubTopDomainObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubTopDomainObj readTopDomainByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of IntNetPubTopDomainObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubTopDomainObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubTopDomainObj> readTopDomainByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of IntNetPubTopDomainObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubTopDomainObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubTopDomainObj> readTopDomainByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of IntNetPubTopDomainObj instances sorted by their primary keys for the duplicate TldIdx key.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubTopDomainObj cached instances sorted by their primary keys for the duplicate TldIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubTopDomainObj> readTopDomainByTldIdx( YCFDbKeyHash256 TldId );

	/**
	 *	Get the map of IntNetPubTopDomainObj instances sorted by their primary keys for the duplicate TldIdx key.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of IntNetPubTopDomainObj cached instances sorted by their primary keys for the duplicate TldIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetPubTopDomainObj> readTopDomainByTldIdx( YCFDbKeyHash256 TldId,
		boolean forceRead );

	/**
	 *	Get the IntNetPubTopDomainObj instance for the unique NameIdx key.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubTopDomainObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubTopDomainObj readTopDomainByNameIdx(YCFDbKeyHash256 TldId,
		String Name );

	/**
	 *	Get the IntNetPubTopDomainObj instance for the unique NameIdx key.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubTopDomainObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubTopDomainObj readTopDomainByNameIdx(YCFDbKeyHash256 TldId,
		String Name,
		boolean forceRead );

	IIntNetPubTopDomainObj readCachedTopDomainByIdIdx( YCFDbKeyHash256 Id );

	List<IIntNetPubTopDomainObj> readCachedTopDomainByTenantIdx( YCFDbKeyHash256 TenantId );

	List<IIntNetPubTopDomainObj> readCachedTopDomainByTldIdx( YCFDbKeyHash256 TldId );

	IIntNetPubTopDomainObj readCachedTopDomainByNameIdx( YCFDbKeyHash256 TldId,
		String Name );

	void deepDisposeTopDomainByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeTopDomainByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeTopDomainByTldIdx( YCFDbKeyHash256 TldId );

	void deepDisposeTopDomainByNameIdx( YCFDbKeyHash256 TldId,
		String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetPubTopDomainObj updateTopDomain( IIntNetPubTopDomainObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTopDomain( IIntNetPubTopDomainObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByTldIdx( YCFDbKeyHash256 TldId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByNameIdx(YCFDbKeyHash256 TldId,
		String Name );
}
