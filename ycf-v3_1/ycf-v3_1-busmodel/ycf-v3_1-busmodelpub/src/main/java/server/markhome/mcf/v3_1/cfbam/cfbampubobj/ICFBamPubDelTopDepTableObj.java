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

public interface ICFBamPubDelTopDepTableObj
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
	 *	Instantiate a new DelTopDep instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubDelTopDepObj newInstance();

	/**
	 *	Instantiate a new DelTopDep edition of the specified DelTopDep instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubDelTopDepEditObj newEditInstance( ICFBamPubDelTopDepObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDelTopDepObj realiseDelTopDep( ICFBamPubDelTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDelTopDepObj createDelTopDep( ICFBamPubDelTopDepObj Obj );

	/**
	 *	Read a DelTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubDelTopDepObj readDelTopDep( IMCFKeyHash256 pkey );

	/**
	 *	Read a DelTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubDelTopDepObj readDelTopDep( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubDelTopDepObj readCachedDelTopDep( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeDelTopDep( ICFBamPubDelTopDepObj obj );

	void deepDisposeDelTopDep( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDelTopDepObj lockDelTopDep( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DelTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubDelTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readAllDelTopDep();

	/**
	 *	Return a sorted map of all the DelTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubDelTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readAllDelTopDep( boolean forceRead );

	List<ICFBamPubDelTopDepObj> readCachedAllDelTopDep();

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDelTopDepObj readDelTopDepByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDelTopDepObj readDelTopDepByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFBamPubDelTopDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByTenantIdx( MCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubDelDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubDelTopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubDelDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByDelDepIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Get the map of CFBamPubDelTopDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByDelDepIdx( MCFDbKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubDelTopDepObj instances sorted by their primary keys for the duplicate DelTopDepTblIdx key.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate DelTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByDelTopDepTblIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Get the map of CFBamPubDelTopDepObj instances sorted by their primary keys for the duplicate DelTopDepTblIdx key.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate DelTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByDelTopDepTblIdx( MCFDbKeyHash256 TableId,
		boolean forceRead );

	/**
	 *	Get the CFBamPubDelTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubDelTopDepObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDelTopDepObj readDelTopDepByUNameIdx(MCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Get the CFBamPubDelTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubDelTopDepObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubDelTopDepObj readDelTopDepByUNameIdx(MCFDbKeyHash256 TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubDelTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubDelTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubDelTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubDelTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubDelTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubDelTopDepObj> readDelTopDepByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamPubDelTopDepObj readCachedDelTopDepByIdIdx( MCFDbKeyHash256 Id );

	List<ICFBamPubDelTopDepObj> readCachedDelTopDepByTenantIdx( MCFDbKeyHash256 TenantId );

	List<ICFBamPubDelTopDepObj> readCachedDelTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubDelTopDepObj> readCachedDelTopDepByDelDepIdx( MCFDbKeyHash256 RelationId );

	List<ICFBamPubDelTopDepObj> readCachedDelTopDepByDelTopDepTblIdx( MCFDbKeyHash256 TableId );

	ICFBamPubDelTopDepObj readCachedDelTopDepByUNameIdx( MCFDbKeyHash256 TableId,
		String Name );

	List<ICFBamPubDelTopDepObj> readCachedDelTopDepByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubDelTopDepObj> readCachedDelTopDepByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeDelTopDepByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeDelTopDepByTenantIdx( MCFDbKeyHash256 TenantId );

	void deepDisposeDelTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeDelTopDepByDelDepIdx( MCFDbKeyHash256 RelationId );

	void deepDisposeDelTopDepByDelTopDepTblIdx( MCFDbKeyHash256 TableId );

	void deepDisposeDelTopDepByUNameIdx( MCFDbKeyHash256 TableId,
		String Name );

	void deepDisposeDelTopDepByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeDelTopDepByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubDelTopDepObj updateDelTopDep( ICFBamPubDelTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDelTopDep( ICFBamPubDelTopDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDelDepIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDelTopDepTblIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByUNameIdx(MCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Move the CFBamPubDelTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubDelTopDepObj refreshed cache instance.
	 */
	ICFBamPubDelTopDepObj moveUpDelTopDep( ICFBamPubDelTopDepObj Obj );

	/**
	 *	Move the CFBamPubDelTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubDelTopDepObj refreshed cache instance.
	 */
	ICFBamPubDelTopDepObj moveDownDelTopDep( ICFBamPubDelTopDepObj Obj );
}
