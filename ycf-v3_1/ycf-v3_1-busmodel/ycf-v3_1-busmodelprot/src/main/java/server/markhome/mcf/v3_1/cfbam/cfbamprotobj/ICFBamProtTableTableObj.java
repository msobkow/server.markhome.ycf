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

public interface ICFBamProtTableTableObj
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
	 *	Instantiate a new Table instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtTableObj newInstance();

	/**
	 *	Instantiate a new Table edition of the specified Table instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtTableEditObj newEditInstance( ICFBamProtTableObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtTableObj realiseTable( ICFBamProtTableObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtTableObj createTable( ICFBamProtTableObj Obj );

	/**
	 *	Read a Table-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Table-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtTableObj readTable( MCFDbKeyHash256 pkey );

	/**
	 *	Read a Table-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Table-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtTableObj readTable( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtTableObj readCachedTable( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeTable( ICFBamProtTableObj obj );

	void deepDisposeTable( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtTableObj lockTable( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Table-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtTableObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtTableObj> readAllTable();

	/**
	 *	Return a sorted map of all the Table-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtTableObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtTableObj> readAllTable( boolean forceRead );

	List<ICFBamProtTableObj> readCachedAllTable();

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Table key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTableObj readTableByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Table key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTableObj readTableByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtTableObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtTableObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Get the map of ICFBamProtTableObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtTableObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByTenantIdx( IMCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate SchemaDefIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate SchemaDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableBySchemaDefIdx( IMCFKeyHash256 SchemaDefId );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate SchemaDefIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate SchemaDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableBySchemaDefIdx( IMCFKeyHash256 SchemaDefId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate CodeVisIdx key.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate CodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate CodeVisIdx key.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate CodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate SchemaCodeVisIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate SchemaCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableBySchemaCodeVisIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate SchemaCodeVisIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate SchemaCodeVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableBySchemaCodeVisIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtTableObj instance for the unique UNameIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Table key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTableObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTableObj readTableByUNameIdx(IMCFKeyHash256 SchemaDefId,
		String Name );

	/**
	 *	Get the ICFBamProtTableObj instance for the unique UNameIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Table key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTableObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTableObj readTableByUNameIdx(IMCFKeyHash256 SchemaDefId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtTableObj instance for the unique SchemaCdIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	TableClassCode	The Table key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTableObj cached instance for the unique SchemaCdIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTableObj readTableBySchemaCdIdx(IMCFKeyHash256 SchemaDefId,
		String TableClassCode );

	/**
	 *	Get the ICFBamProtTableObj instance for the unique SchemaCdIdx key.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	TableClassCode	The Table key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTableObj refreshed instance for the unique SchemaCdIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTableObj readTableBySchemaCdIdx(IMCFKeyHash256 SchemaDefId,
		String TableClassCode,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate PrimaryIndexIdx key.
	 *
	 *	@param	PrimaryIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate PrimaryIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByPrimaryIndexIdx( MCFDbKeyHash256 PrimaryIndexId );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate PrimaryIndexIdx key.
	 *
	 *	@param	PrimaryIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate PrimaryIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByPrimaryIndexIdx( MCFDbKeyHash256 PrimaryIndexId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate LookupIndexIdx key.
	 *
	 *	@param	LookupIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate LookupIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByLookupIndexIdx( MCFDbKeyHash256 LookupIndexId );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate LookupIndexIdx key.
	 *
	 *	@param	LookupIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate LookupIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByLookupIndexIdx( MCFDbKeyHash256 LookupIndexId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate AltIndexIdx key.
	 *
	 *	@param	AltIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate AltIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByAltIndexIdx( MCFDbKeyHash256 AltIndexId );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate AltIndexIdx key.
	 *
	 *	@param	AltIndexId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate AltIndexIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByAltIndexIdx( MCFDbKeyHash256 AltIndexId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate QualTableIdx key.
	 *
	 *	@param	QualifyingTableId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate QualTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByQualTableIdx( MCFDbKeyHash256 QualifyingTableId );

	/**
	 *	Get the map of List<ICFBamProtTableObj> instances sorted by their primary keys for the duplicate QualTableIdx key.
	 *
	 *	@param	QualifyingTableId	The Table key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTableObj> cached instances sorted by their primary keys for the duplicate QualTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTableObj> readTableByQualTableIdx( MCFDbKeyHash256 QualifyingTableId,
		boolean forceRead );

	ICFBamProtScopeObj readCachedTableByIdIdx( IMCFKeyHash256 Id );

	List<List<ICFBamProtScopeObj>> readCachedTableByTenantIdx( IMCFKeyHash256 TenantId );

	List<List<ICFBamProtTableObj>> readCachedTableBySchemaDefIdx( IMCFKeyHash256 SchemaDefId );

	List<List<ICFBamProtTableObj>> readCachedTableByCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	List<List<ICFBamProtTableObj>> readCachedTableBySchemaCodeVisIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	List<List<ICFBamProtTableObj>> readCachedTableByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	ICFBamProtTableObj readCachedTableByUNameIdx( IMCFKeyHash256 SchemaDefId,
		String Name );

	ICFBamProtTableObj readCachedTableBySchemaCdIdx( IMCFKeyHash256 SchemaDefId,
		String TableClassCode );

	List<List<ICFBamProtTableObj>> readCachedTableByPrimaryIndexIdx( MCFDbKeyHash256 PrimaryIndexId );

	List<List<ICFBamProtTableObj>> readCachedTableByLookupIndexIdx( MCFDbKeyHash256 LookupIndexId );

	List<List<ICFBamProtTableObj>> readCachedTableByAltIndexIdx( MCFDbKeyHash256 AltIndexId );

	List<List<ICFBamProtTableObj>> readCachedTableByQualTableIdx( MCFDbKeyHash256 QualifyingTableId );

	void deepDisposeTableByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeTableByTenantIdx( IMCFKeyHash256 TenantId );

	void deepDisposeTableBySchemaDefIdx( IMCFKeyHash256 SchemaDefId );

	void deepDisposeTableByCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeTableBySchemaCodeVisIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	void deepDisposeTableByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeTableByUNameIdx( IMCFKeyHash256 SchemaDefId,
		String Name );

	void deepDisposeTableBySchemaCdIdx( IMCFKeyHash256 SchemaDefId,
		String TableClassCode );

	void deepDisposeTableByPrimaryIndexIdx( MCFDbKeyHash256 PrimaryIndexId );

	void deepDisposeTableByLookupIndexIdx( MCFDbKeyHash256 LookupIndexId );

	void deepDisposeTableByAltIndexIdx( MCFDbKeyHash256 AltIndexId );

	void deepDisposeTableByQualTableIdx( MCFDbKeyHash256 QualifyingTableId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtTableObj updateTable( ICFBamProtTableObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTable( ICFBamProtTableObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaDefIdx( IMCFKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByCodeVisIdx( ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaCodeVisIdx( IMCFKeyHash256 SchemaDefId,
		ICFBamPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByUNameIdx(IMCFKeyHash256 SchemaDefId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The Table key attribute of the instance generating the id.
	 *
	 *	@param	TableClassCode	The Table key attribute of the instance generating the id.
	 */
	void deleteTableBySchemaCdIdx(IMCFKeyHash256 SchemaDefId,
		String TableClassCode );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrimaryIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByPrimaryIndexIdx( MCFDbKeyHash256 PrimaryIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	LookupIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByLookupIndexIdx( MCFDbKeyHash256 LookupIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	AltIndexId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByAltIndexIdx( MCFDbKeyHash256 AltIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	QualifyingTableId	The Table key attribute of the instance generating the id.
	 */
	void deleteTableByQualTableIdx( MCFDbKeyHash256 QualifyingTableId );
}
