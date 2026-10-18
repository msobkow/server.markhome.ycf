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

public interface ICFBamPubPopSubDep2TableObj
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
	 *	Instantiate a new PopSubDep2 instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubPopSubDep2Obj newInstance();

	/**
	 *	Instantiate a new PopSubDep2 edition of the specified PopSubDep2 instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubPopSubDep2EditObj newEditInstance( ICFBamPubPopSubDep2Obj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubPopSubDep2Obj realisePopSubDep2( ICFBamPubPopSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubPopSubDep2Obj createPopSubDep2( ICFBamPubPopSubDep2Obj Obj );

	/**
	 *	Read a PopSubDep2-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopSubDep2-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubPopSubDep2Obj readPopSubDep2( IMCFKeyHash256 pkey );

	/**
	 *	Read a PopSubDep2-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopSubDep2-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubPopSubDep2Obj readPopSubDep2( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubPopSubDep2Obj readCachedPopSubDep2( IMCFKeyHash256 pkey );

	public void reallyDeepDisposePopSubDep2( ICFBamPubPopSubDep2Obj obj );

	void deepDisposePopSubDep2( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubPopSubDep2Obj lockPopSubDep2( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the PopSubDep2-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubPopSubDep2Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readAllPopSubDep2();

	/**
	 *	Return a sorted map of all the PopSubDep2-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubPopSubDep2Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readAllPopSubDep2( boolean forceRead );

	List<ICFBamPubPopSubDep2Obj> readCachedAllPopSubDep2();

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubPopSubDep2Obj readPopSubDep2ByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubPopSubDep2Obj readPopSubDep2ByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubPopSubDep2Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readPopSubDep2ByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFBamPubPopSubDep2Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubPopSubDep2Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readPopSubDep2ByTenantIdx( MCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubPopDepObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	RelationId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubPopSubDep2Obj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readPopSubDep2ByRelationIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Get the map of CFBamPubPopSubDep2Obj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	RelationId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubPopSubDep2Obj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readPopSubDep2ByRelationIdx( MCFDbKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubPopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubPopSubDep2Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubPopSubDep2Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubPopSubDep2Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubPopSubDep2Obj instances sorted by their primary keys for the duplicate PopSubDep1Idx key.
	 *
	 *	@param	PopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubPopSubDep2Obj cached instances sorted by their primary keys for the duplicate PopSubDep1Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readPopSubDep2ByPopSubDep1Idx( MCFDbKeyHash256 PopSubDep1Id );

	/**
	 *	Get the map of CFBamPubPopSubDep2Obj instances sorted by their primary keys for the duplicate PopSubDep1Idx key.
	 *
	 *	@param	PopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubPopSubDep2Obj cached instances sorted by their primary keys for the duplicate PopSubDep1Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubPopSubDep2Obj> readPopSubDep2ByPopSubDep1Idx( MCFDbKeyHash256 PopSubDep1Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubPopSubDep2Obj instance for the unique UNameIdx key.
	 *
	 *	@param	PopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubPopSubDep2Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubPopSubDep2Obj readPopSubDep2ByUNameIdx(MCFDbKeyHash256 PopSubDep1Id,
		String Name );

	/**
	 *	Get the CFBamPubPopSubDep2Obj instance for the unique UNameIdx key.
	 *
	 *	@param	PopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubPopSubDep2Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubPopSubDep2Obj readPopSubDep2ByUNameIdx(MCFDbKeyHash256 PopSubDep1Id,
		String Name,
		boolean forceRead );

	ICFBamPubPopSubDep2Obj readCachedPopSubDep2ByIdIdx( MCFDbKeyHash256 Id );

	List<ICFBamPubPopSubDep2Obj> readCachedPopSubDep2ByTenantIdx( MCFDbKeyHash256 TenantId );

	List<ICFBamPubPopSubDep2Obj> readCachedPopSubDep2ByRelationIdx( MCFDbKeyHash256 RelationId );

	List<ICFBamPubPopSubDep2Obj> readCachedPopSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubPopSubDep2Obj> readCachedPopSubDep2ByPopSubDep1Idx( MCFDbKeyHash256 PopSubDep1Id );

	ICFBamPubPopSubDep2Obj readCachedPopSubDep2ByUNameIdx( MCFDbKeyHash256 PopSubDep1Id,
		String Name );

	void deepDisposePopSubDep2ByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposePopSubDep2ByTenantIdx( MCFDbKeyHash256 TenantId );

	void deepDisposePopSubDep2ByRelationIdx( MCFDbKeyHash256 RelationId );

	void deepDisposePopSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposePopSubDep2ByPopSubDep1Idx( MCFDbKeyHash256 PopSubDep1Id );

	void deepDisposePopSubDep2ByUNameIdx( MCFDbKeyHash256 PopSubDep1Id,
		String Name );

	/**
	 *	Internal use only.
	 */
	ICFBamPubPopSubDep2Obj updatePopSubDep2( ICFBamPubPopSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deletePopSubDep2( ICFBamPubPopSubDep2Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByRelationIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByPopSubDep1Idx( MCFDbKeyHash256 PopSubDep1Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	PopSubDep1Id	The PopSubDep2 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep2 key attribute of the instance generating the id.
	 */
	void deletePopSubDep2ByUNameIdx(MCFDbKeyHash256 PopSubDep1Id,
		String Name );
}
