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

public interface ICFBamProtDelSubDep2TableObj
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
	 *	Instantiate a new DelSubDep2 instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtDelSubDep2Obj newInstance();

	/**
	 *	Instantiate a new DelSubDep2 edition of the specified DelSubDep2 instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtDelSubDep2EditObj newEditInstance( ICFBamProtDelSubDep2Obj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDelSubDep2Obj realiseDelSubDep2( ICFBamProtDelSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDelSubDep2Obj createDelSubDep2( ICFBamProtDelSubDep2Obj Obj );

	/**
	 *	Read a DelSubDep2-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelSubDep2-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtDelSubDep2Obj readDelSubDep2( MCFDbKeyHash256 pkey );

	/**
	 *	Read a DelSubDep2-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelSubDep2-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtDelSubDep2Obj readDelSubDep2( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtDelSubDep2Obj readCachedDelSubDep2( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeDelSubDep2( ICFBamProtDelSubDep2Obj obj );

	void deepDisposeDelSubDep2( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDelSubDep2Obj lockDelSubDep2( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DelSubDep2-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtDelSubDep2Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readAllDelSubDep2();

	/**
	 *	Return a sorted map of all the DelSubDep2-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtDelSubDep2Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readAllDelSubDep2( boolean forceRead );

	List<ICFBamProtDelSubDep2Obj> readCachedAllDelSubDep2();

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDelSubDep2Obj readDelSubDep2ByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDelSubDep2Obj readDelSubDep2ByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDelSubDep2Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep2Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readDelSubDep2ByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Get the map of ICFBamProtDelSubDep2Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep2Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readDelSubDep2ByTenantIdx( IMCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDelSubDep2Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep2Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readDelSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of ICFBamProtDelSubDep2Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep2Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readDelSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDelSubDep2Obj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep2Obj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readDelSubDep2ByDelDepIdx( IMCFKeyHash256 RelationId );

	/**
	 *	Get the map of ICFBamProtDelSubDep2Obj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep2Obj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readDelSubDep2ByDelDepIdx( IMCFKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtDelSubDep2Obj> instances sorted by their primary keys for the duplicate ContDelDep1Idx key.
	 *
	 *	@param	DelSubDep1Id	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtDelSubDep2Obj> cached instances sorted by their primary keys for the duplicate ContDelDep1Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readDelSubDep2ByContDelDep1Idx( IMCFKeyHash256 DelSubDep1Id );

	/**
	 *	Get the map of List<ICFBamProtDelSubDep2Obj> instances sorted by their primary keys for the duplicate ContDelDep1Idx key.
	 *
	 *	@param	DelSubDep1Id	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtDelSubDep2Obj> cached instances sorted by their primary keys for the duplicate ContDelDep1Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep2Obj> readDelSubDep2ByContDelDep1Idx( IMCFKeyHash256 DelSubDep1Id,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtDelSubDep2Obj instance for the unique UNameIdx key.
	 *
	 *	@param	DelSubDep1Id	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtDelSubDep2Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDelSubDep2Obj readDelSubDep2ByUNameIdx(IMCFKeyHash256 DelSubDep1Id,
		String Name );

	/**
	 *	Get the ICFBamProtDelSubDep2Obj instance for the unique UNameIdx key.
	 *
	 *	@param	DelSubDep1Id	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtDelSubDep2Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDelSubDep2Obj readDelSubDep2ByUNameIdx(IMCFKeyHash256 DelSubDep1Id,
		String Name,
		boolean forceRead );

	ICFBamProtScopeObj readCachedDelSubDep2ByIdIdx( IMCFKeyHash256 Id );

	List<List<ICFBamProtScopeObj>> readCachedDelSubDep2ByTenantIdx( IMCFKeyHash256 TenantId );

	List<List<ICFBamProtDelDepObj>> readCachedDelSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<List<ICFBamProtDelDepObj>> readCachedDelSubDep2ByDelDepIdx( IMCFKeyHash256 RelationId );

	List<List<ICFBamProtDelSubDep2Obj>> readCachedDelSubDep2ByContDelDep1Idx( IMCFKeyHash256 DelSubDep1Id );

	ICFBamProtDelSubDep2Obj readCachedDelSubDep2ByUNameIdx( IMCFKeyHash256 DelSubDep1Id,
		String Name );

	void deepDisposeDelSubDep2ByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeDelSubDep2ByTenantIdx( IMCFKeyHash256 TenantId );

	void deepDisposeDelSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeDelSubDep2ByDelDepIdx( IMCFKeyHash256 RelationId );

	void deepDisposeDelSubDep2ByContDelDep1Idx( IMCFKeyHash256 DelSubDep1Id );

	void deepDisposeDelSubDep2ByUNameIdx( IMCFKeyHash256 DelSubDep1Id,
		String Name );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDelSubDep2Obj updateDelSubDep2( ICFBamProtDelSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDelSubDep2( ICFBamProtDelSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DelSubDep2 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep2ByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The DelSubDep2 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep2ByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DelSubDep2 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The DelSubDep2 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep2ByDelDepIdx( IMCFKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DelSubDep1Id	The DelSubDep2 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep2ByContDelDep1Idx( IMCFKeyHash256 DelSubDep1Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	DelSubDep1Id	The DelSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelSubDep2 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep2ByUNameIdx(IMCFKeyHash256 DelSubDep1Id,
		String Name );
}
