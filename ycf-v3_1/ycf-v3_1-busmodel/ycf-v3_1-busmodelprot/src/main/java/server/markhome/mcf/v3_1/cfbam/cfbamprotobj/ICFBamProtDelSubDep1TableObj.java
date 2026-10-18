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

public interface ICFBamProtDelSubDep1TableObj
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
	 *	Instantiate a new DelSubDep1 instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtDelSubDep1Obj newInstance();

	/**
	 *	Instantiate a new DelSubDep1 edition of the specified DelSubDep1 instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtDelSubDep1EditObj newEditInstance( ICFBamProtDelSubDep1Obj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDelSubDep1Obj realiseDelSubDep1( ICFBamProtDelSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDelSubDep1Obj createDelSubDep1( ICFBamProtDelSubDep1Obj Obj );

	/**
	 *	Read a DelSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtDelSubDep1Obj readDelSubDep1( MCFDbKeyHash256 pkey );

	/**
	 *	Read a DelSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtDelSubDep1Obj readDelSubDep1( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtDelSubDep1Obj readCachedDelSubDep1( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeDelSubDep1( ICFBamProtDelSubDep1Obj obj );

	void deepDisposeDelSubDep1( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDelSubDep1Obj lockDelSubDep1( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the DelSubDep1-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtDelSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readAllDelSubDep1();

	/**
	 *	Return a sorted map of all the DelSubDep1-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtDelSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readAllDelSubDep1( boolean forceRead );

	List<ICFBamProtDelSubDep1Obj> readCachedAllDelSubDep1();

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDelSubDep1Obj readDelSubDep1ByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDelSubDep1Obj readDelSubDep1ByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDelSubDep1Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readDelSubDep1ByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Get the map of ICFBamProtDelSubDep1Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readDelSubDep1ByTenantIdx( IMCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDelSubDep1Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readDelSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of ICFBamProtDelSubDep1Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readDelSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtDelSubDep1Obj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readDelSubDep1ByDelDepIdx( IMCFKeyHash256 RelationId );

	/**
	 *	Get the map of ICFBamProtDelSubDep1Obj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	RelationId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtDelSubDep1Obj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readDelSubDep1ByDelDepIdx( IMCFKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtDelSubDep1Obj> instances sorted by their primary keys for the duplicate DelTopDepIdx key.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtDelSubDep1Obj> cached instances sorted by their primary keys for the duplicate DelTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readDelSubDep1ByDelTopDepIdx( IMCFKeyHash256 DelTopDepId );

	/**
	 *	Get the map of List<ICFBamProtDelSubDep1Obj> instances sorted by their primary keys for the duplicate DelTopDepIdx key.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtDelSubDep1Obj> cached instances sorted by their primary keys for the duplicate DelTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtDelSubDep1Obj> readDelSubDep1ByDelTopDepIdx( IMCFKeyHash256 DelTopDepId,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtDelSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtDelSubDep1Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDelSubDep1Obj readDelSubDep1ByUNameIdx(IMCFKeyHash256 DelTopDepId,
		String Name );

	/**
	 *	Get the ICFBamProtDelSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtDelSubDep1Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtDelSubDep1Obj readDelSubDep1ByUNameIdx(IMCFKeyHash256 DelTopDepId,
		String Name,
		boolean forceRead );

	ICFBamProtScopeObj readCachedDelSubDep1ByIdIdx( IMCFKeyHash256 Id );

	List<List<ICFBamProtScopeObj>> readCachedDelSubDep1ByTenantIdx( IMCFKeyHash256 TenantId );

	List<List<ICFBamProtDelDepObj>> readCachedDelSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<List<ICFBamProtDelDepObj>> readCachedDelSubDep1ByDelDepIdx( IMCFKeyHash256 RelationId );

	List<List<ICFBamProtDelSubDep1Obj>> readCachedDelSubDep1ByDelTopDepIdx( IMCFKeyHash256 DelTopDepId );

	ICFBamProtDelSubDep1Obj readCachedDelSubDep1ByUNameIdx( IMCFKeyHash256 DelTopDepId,
		String Name );

	void deepDisposeDelSubDep1ByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeDelSubDep1ByTenantIdx( IMCFKeyHash256 TenantId );

	void deepDisposeDelSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeDelSubDep1ByDelDepIdx( IMCFKeyHash256 RelationId );

	void deepDisposeDelSubDep1ByDelTopDepIdx( IMCFKeyHash256 DelTopDepId );

	void deepDisposeDelSubDep1ByUNameIdx( IMCFKeyHash256 DelTopDepId,
		String Name );

	/**
	 *	Internal use only.
	 */
	ICFBamProtDelSubDep1Obj updateDelSubDep1( ICFBamProtDelSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDelSubDep1( ICFBamProtDelSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByTenantIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByDelDepIdx( IMCFKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByDelTopDepIdx( IMCFKeyHash256 DelTopDepId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DelTopDepId	The DelSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DelSubDep1 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep1ByUNameIdx(IMCFKeyHash256 DelTopDepId,
		String Name );
}
