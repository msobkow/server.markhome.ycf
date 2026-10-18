// Description: Java 25 Protected Table Object interface for CFBamProt.

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

package server.markhome.mcf.v3_1.cfbam.cfbamprotobj;

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
import server.markhome.mcf.v3_1.cfbam.cfbamprot.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;

public interface ICFBamProtRelationTableObj
{
	public ICFBamProtSchemaObj getSchema();
	public void setSchema( ICFBamProtSchemaObj value );

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
	 *	Instantiate a new Relation instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtRelationObj newInstance();

	/**
	 *	Instantiate a new Relation edition of the specified Relation instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtRelationEditObj newEditInstance( ICFBamProtRelationObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtRelationObj realiseRelation( ICFBamProtRelationObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtRelationObj createRelation( ICFBamProtRelationObj Obj );

	/**
	 *	Read a Relation-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Relation-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtRelationObj readRelation( MCFDbKeyHash256 pkey );

	/**
	 *	Read a Relation-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Relation-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtRelationObj readRelation( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtRelationObj readCachedRelation( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeRelation( ICFBamProtRelationObj obj );

	void deepDisposeRelation( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtRelationObj lockRelation( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Relation-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtRelationObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtRelationObj> readAllRelation();

	/**
	 *	Return a sorted map of all the Relation-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtRelationObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtRelationObj> readAllRelation( boolean forceRead );

	List<ICFBamProtRelationObj> readCachedAllRelation();

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtRelationObj readRelationByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtRelationObj readRelationByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtRelationObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtRelationObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Get the map of ICFBamProtRelationObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtRelationObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByTenantIdx( IMCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtRelationObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRelationObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtRelationObj readRelationByUNameIdx(IMCFKeyHash256 TableId,
		String Name );

	/**
	 *	Get the ICFBamProtRelationObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRelationObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtRelationObj readRelationByUNameIdx(IMCFKeyHash256 TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate RelTableIdx key.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate RelTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByRelTableIdx( IMCFKeyHash256 TableId );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate RelTableIdx key.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate RelTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByRelTableIdx( IMCFKeyHash256 TableId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate RelCodeVisIdx key.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate RelCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByRelCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate RelCodeVisIdx key.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate RelCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByRelCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate RelTableCodeVisX key.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate RelTableCodeVisX key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByRelTableCodeVisX( IMCFKeyHash256 TableId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate RelTableCodeVisX key.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate RelTableCodeVisX key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByRelTableCodeVisX( IMCFKeyHash256 TableId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate FromKeyIdx key.
	 *
	 *	@param	FromIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate FromKeyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByFromKeyIdx( IMCFKeyHash256 FromIndexId );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate FromKeyIdx key.
	 *
	 *	@param	FromIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate FromKeyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByFromKeyIdx( IMCFKeyHash256 FromIndexId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate ToTblIdx key.
	 *
	 *	@param	ToTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate ToTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByToTblIdx( IMCFKeyHash256 ToTableId );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate ToTblIdx key.
	 *
	 *	@param	ToTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate ToTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByToTblIdx( IMCFKeyHash256 ToTableId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate ToKeyIdx key.
	 *
	 *	@param	ToIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate ToKeyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByToKeyIdx( IMCFKeyHash256 ToIndexId );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate ToKeyIdx key.
	 *
	 *	@param	ToIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate ToKeyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByToKeyIdx( IMCFKeyHash256 ToIndexId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate NarrowedIdx key.
	 *
	 *	@param	NarrowedId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate NarrowedIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByNarrowedIdx( MCFDbKeyHash256 NarrowedId );

	/**
	 *	Get the map of List<ICFBamProtRelationObj> instances sorted by their primary keys for the duplicate NarrowedIdx key.
	 *
	 *	@param	NarrowedId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationObj> cached instances sorted by their primary keys for the duplicate NarrowedIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationObj> readRelationByNarrowedIdx( MCFDbKeyHash256 NarrowedId,
		boolean forceRead );

	ICFBamProtScopeObj readCachedRelationByIdIdx( IMCFKeyHash256 Id );

	List<List<ICFBamProtScopeObj>> readCachedRelationByTenantIdx( IMCFKeyHash256 TenantId );

	ICFBamProtRelationObj readCachedRelationByUNameIdx( IMCFKeyHash256 TableId,
		String Name );

	List<List<ICFBamProtRelationObj>> readCachedRelationByRelTableIdx( IMCFKeyHash256 TableId );

	List<List<ICFBamProtRelationObj>> readCachedRelationByRelCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	List<List<ICFBamProtRelationObj>> readCachedRelationByRelTableCodeVisX( IMCFKeyHash256 TableId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	List<List<ICFBamProtRelationObj>> readCachedRelationByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<List<ICFBamProtRelationObj>> readCachedRelationByFromKeyIdx( IMCFKeyHash256 FromIndexId );

	List<List<ICFBamProtRelationObj>> readCachedRelationByToTblIdx( IMCFKeyHash256 ToTableId );

	List<List<ICFBamProtRelationObj>> readCachedRelationByToKeyIdx( IMCFKeyHash256 ToIndexId );

	List<List<ICFBamProtRelationObj>> readCachedRelationByNarrowedIdx( MCFDbKeyHash256 NarrowedId );

	void deepDisposeRelationByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeRelationByTenantIdx( IMCFKeyHash256 TenantId );

	void deepDisposeRelationByUNameIdx( IMCFKeyHash256 TableId,
		String Name );

	void deepDisposeRelationByRelTableIdx( IMCFKeyHash256 TableId );

	void deepDisposeRelationByRelCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeRelationByRelTableCodeVisX( IMCFKeyHash256 TableId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeRelationByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeRelationByFromKeyIdx( IMCFKeyHash256 FromIndexId );

	void deepDisposeRelationByToTblIdx( IMCFKeyHash256 ToTableId );

	void deepDisposeRelationByToKeyIdx( IMCFKeyHash256 ToIndexId );

	void deepDisposeRelationByNarrowedIdx( MCFDbKeyHash256 NarrowedId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtRelationObj updateRelation( ICFBamProtRelationObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteRelation( ICFBamProtRelationObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByUNameIdx(IMCFKeyHash256 TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByRelTableIdx( IMCFKeyHash256 TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByRelCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByRelTableCodeVisX( IMCFKeyHash256 TableId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	FromIndexId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByFromKeyIdx( IMCFKeyHash256 FromIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ToTableId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByToTblIdx( IMCFKeyHash256 ToTableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ToIndexId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByToKeyIdx( IMCFKeyHash256 ToIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NarrowedId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByNarrowedIdx( MCFDbKeyHash256 NarrowedId );
}
