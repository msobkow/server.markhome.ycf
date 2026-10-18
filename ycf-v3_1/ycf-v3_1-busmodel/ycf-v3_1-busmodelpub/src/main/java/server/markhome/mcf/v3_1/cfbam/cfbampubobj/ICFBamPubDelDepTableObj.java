// Description: Java 25 Public Table Object interface for CFBamPub.

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbampubobj;

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
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;

public interface ICFBamPubDelDepTableObj
{
	public ICFBamPubSchemaObj getSchema();
	public void setSchema( ICFBamPubSchemaObj value );

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
	 *	Instantiate a new DelDep instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubDelDepObj newInstance();

	/**
	 *	Instantiate a new DelDep edition of the specified DelDep instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubDelDepEditObj newEditInstance( ICFBamPubDelDepObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDelDepObj realiseDelDep( ICFBamPubDelDepObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDelDepObj createDelDep( ICFBamPubDelDepObj Obj );

	/**
	 *	Read a DelDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubDelDepObj readDelDep( IMCFKeyHash256 pkey );

	/**
	 *	Read a DelDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubDelDepObj readDelDep( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubDelDepObj readCachedDelDep( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeDelDep( ICFBamPubDelDepObj obj );

	void deepDisposeDelDep( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDelDepObj lockDelDep( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DelDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubDelDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubDelDepObj> readAllDelDep();

	/**
	 *	Return a sorted map of all the DelDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubDelDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubDelDepObj> readAllDelDep( boolean forceRead );

	List<ICFBamPubDelDepObj> readCachedAllDelDep();

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDelDepObj readDelDepByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDelDepObj readDelDepByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelDepObj> readDelDepByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFBamPubDelDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelDepObj> readDelDepByTenantIdx( MCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubDelDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelDepObj> readDelDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubDelDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelDepObj> readDelDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubDelDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelDepObj> readDelDepByDelDepIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Get the map of CFBamPubDelDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelDepObj> readDelDepByDelDepIdx( MCFDbKeyHash256 RelationId,
		boolean forceRead );

	ICFBamPubDelDepObj readCachedDelDepByIdIdx( MCFDbKeyHash256 Id );

	List<ICFBamPubDelDepObj> readCachedDelDepByTenantIdx( MCFDbKeyHash256 TenantId );

	List<ICFBamPubDelDepObj> readCachedDelDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubDelDepObj> readCachedDelDepByDelDepIdx( MCFDbKeyHash256 RelationId );

	void deepDisposeDelDepByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeDelDepByTenantIdx( MCFDbKeyHash256 TenantId );

	void deepDisposeDelDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeDelDepByDelDepIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDelDepObj updateDelDep( ICFBamPubDelDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDelDep( ICFBamPubDelDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The DelDep key attribute of the instance generating the id.
	 */
	void deleteDelDepByDelDepIdx( MCFDbKeyHash256 RelationId );
}
