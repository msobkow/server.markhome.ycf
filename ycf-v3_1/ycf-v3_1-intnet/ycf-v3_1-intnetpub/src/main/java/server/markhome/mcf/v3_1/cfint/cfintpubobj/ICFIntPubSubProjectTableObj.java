// Description: Java 25 Public Table Object interface for CFIntPub.

/*
 *	server.markhome.mcf.CFInt
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFInt - Internet Essentials
 *	
 *	This file is part of Mark's Code Fractal CFInt.
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

package server.markhome.mcf.v3_1.cfint.cfintpubobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;

public interface ICFIntPubSubProjectTableObj
{
	public ICFIntPubSchemaObj getSchema();
	public void setSchema( ICFIntPubSchemaObj value );

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
	 *	Instantiate a new SubProject instance.
	 *
	 *	@return	A new instance.
	 */
	ICFIntPubSubProjectObj newInstance();

	/**
	 *	Instantiate a new SubProject edition of the specified SubProject instance.
	 *
	 *	@return	A new edition.
	 */
	ICFIntPubSubProjectEditObj newEditInstance( ICFIntPubSubProjectObj orig );

	/**
	 *	Internal use only.
	 */
	ICFIntPubSubProjectObj realiseSubProject( ICFIntPubSubProjectObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFIntPubSubProjectObj createSubProject( ICFIntPubSubProjectObj Obj );

	/**
	 *	Read a SubProject-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SubProject-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntPubSubProjectObj readSubProject( IMCFKeyHash256 pkey );

	/**
	 *	Read a SubProject-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SubProject-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntPubSubProjectObj readSubProject( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFIntPubSubProjectObj readCachedSubProject( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeSubProject( ICFIntPubSubProjectObj obj );

	void deepDisposeSubProject( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFIntPubSubProjectObj lockSubProject( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SubProject-derived instances in the database.
	 *
	 *	@return	List of ICFIntPubSubProjectObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntPubSubProjectObj> readAllSubProject();

	/**
	 *	Return a sorted map of all the SubProject-derived instances in the database.
	 *
	 *	@return	List of ICFIntPubSubProjectObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntPubSubProjectObj> readAllSubProject( boolean forceRead );

	List<ICFIntPubSubProjectObj> readCachedAllSubProject();

	/**
	 *	Get the CFIntPubSubProjectObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return	CFIntPubSubProjectObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntPubSubProjectObj readSubProjectByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFIntPubSubProjectObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return	CFIntPubSubProjectObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntPubSubProjectObj readSubProjectByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of CFIntPubSubProjectObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntPubSubProjectObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntPubSubProjectObj> readSubProjectByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFIntPubSubProjectObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntPubSubProjectObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntPubSubProjectObj> readSubProjectByTenantIdx( MCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFIntPubSubProjectObj instances sorted by their primary keys for the duplicate TopProjectIdx key.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntPubSubProjectObj cached instances sorted by their primary keys for the duplicate TopProjectIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntPubSubProjectObj> readSubProjectByTopProjectIdx( MCFDbKeyHash256 TopProjectId );

	/**
	 *	Get the map of CFIntPubSubProjectObj instances sorted by their primary keys for the duplicate TopProjectIdx key.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntPubSubProjectObj cached instances sorted by their primary keys for the duplicate TopProjectIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntPubSubProjectObj> readSubProjectByTopProjectIdx( MCFDbKeyHash256 TopProjectId,
		boolean forceRead );

	/**
	 *	Get the CFIntPubSubProjectObj instance for the unique NameIdx key.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return	CFIntPubSubProjectObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntPubSubProjectObj readSubProjectByNameIdx(MCFDbKeyHash256 TopProjectId,
		String Name );

	/**
	 *	Get the CFIntPubSubProjectObj instance for the unique NameIdx key.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return	CFIntPubSubProjectObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntPubSubProjectObj readSubProjectByNameIdx(MCFDbKeyHash256 TopProjectId,
		String Name,
		boolean forceRead );

	ICFIntPubSubProjectObj readCachedSubProjectByIdIdx( MCFDbKeyHash256 Id );

	List<ICFIntPubSubProjectObj> readCachedSubProjectByTenantIdx( MCFDbKeyHash256 TenantId );

	List<ICFIntPubSubProjectObj> readCachedSubProjectByTopProjectIdx( MCFDbKeyHash256 TopProjectId );

	ICFIntPubSubProjectObj readCachedSubProjectByNameIdx( MCFDbKeyHash256 TopProjectId,
		String Name );

	void deepDisposeSubProjectByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeSubProjectByTenantIdx( MCFDbKeyHash256 TenantId );

	void deepDisposeSubProjectByTopProjectIdx( MCFDbKeyHash256 TopProjectId );

	void deepDisposeSubProjectByNameIdx( MCFDbKeyHash256 TopProjectId,
		String Name );

	/**
	 *	Internal use only.
	 */
	ICFIntPubSubProjectObj updateSubProject( ICFIntPubSubProjectObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSubProject( ICFIntPubSubProjectObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The SubProject key attribute of the instance generating the id.
	 */
	void deleteSubProjectByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The SubProject key attribute of the instance generating the id.
	 */
	void deleteSubProjectByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 */
	void deleteSubProjectByTopProjectIdx( MCFDbKeyHash256 TopProjectId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SubProject key attribute of the instance generating the id.
	 */
	void deleteSubProjectByNameIdx(MCFDbKeyHash256 TopProjectId,
		String Name );
}
