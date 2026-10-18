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

public interface ICFBamPubRelationColTableObj
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
	 *	Instantiate a new RelationCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubRelationColObj newInstance();

	/**
	 *	Instantiate a new RelationCol edition of the specified RelationCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubRelationColEditObj newEditInstance( ICFBamPubRelationColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubRelationColObj realiseRelationCol( ICFBamPubRelationColObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubRelationColObj createRelationCol( ICFBamPubRelationColObj Obj );

	/**
	 *	Read a RelationCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The RelationCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubRelationColObj readRelationCol( IMCFKeyHash256 pkey );

	/**
	 *	Read a RelationCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The RelationCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubRelationColObj readRelationCol( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubRelationColObj readCachedRelationCol( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeRelationCol( ICFBamPubRelationColObj obj );

	void deepDisposeRelationCol( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubRelationColObj lockRelationCol( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the RelationCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubRelationColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubRelationColObj> readAllRelationCol();

	/**
	 *	Return a sorted map of all the RelationCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubRelationColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubRelationColObj> readAllRelationCol( boolean forceRead );

	List<ICFBamPubRelationColObj> readCachedAllRelationCol();

	/**
	 *	Get the CFBamPubRelationColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRelationColObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubRelationColObj readRelationColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubRelationColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRelationColObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubRelationColObj readRelationColByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubRelationColObj instance for the unique UNameIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRelationColObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubRelationColObj readRelationColByUNameIdx(MCFDbKeyHash256 RelationId,
		String Name );

	/**
	 *	Get the CFBamPubRelationColObj instance for the unique UNameIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubRelationColObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubRelationColObj readRelationColByUNameIdx(MCFDbKeyHash256 RelationId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByRelationIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByRelationIdx( MCFDbKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate FromColIdx key.
	 *
	 *	@param	FromColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate FromColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByFromColIdx( MCFDbKeyHash256 FromColId );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate FromColIdx key.
	 *
	 *	@param	FromColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate FromColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByFromColIdx( MCFDbKeyHash256 FromColId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate ToColIdx key.
	 *
	 *	@param	ToColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate ToColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByToColIdx( MCFDbKeyHash256 ToColId );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate ToColIdx key.
	 *
	 *	@param	ToColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate ToColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByToColIdx( MCFDbKeyHash256 ToColId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate RelPrevIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate RelPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByRelPrevIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate RelPrevIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate RelPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByRelPrevIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate RelNextIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate RelNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByRelNextIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubRelationColObj instances sorted by their primary keys for the duplicate RelNextIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubRelationColObj cached instances sorted by their primary keys for the duplicate RelNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubRelationColObj> readRelationColByRelNextIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamPubRelationColObj readCachedRelationColByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubRelationColObj readCachedRelationColByUNameIdx( MCFDbKeyHash256 RelationId,
		String Name );

	List<ICFBamPubRelationColObj> readCachedRelationColByRelationIdx( MCFDbKeyHash256 RelationId );

	List<ICFBamPubRelationColObj> readCachedRelationColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubRelationColObj> readCachedRelationColByFromColIdx( MCFDbKeyHash256 FromColId );

	List<ICFBamPubRelationColObj> readCachedRelationColByToColIdx( MCFDbKeyHash256 ToColId );

	List<ICFBamPubRelationColObj> readCachedRelationColByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubRelationColObj> readCachedRelationColByNextIdx( MCFDbKeyHash256 NextId );

	List<ICFBamPubRelationColObj> readCachedRelationColByRelPrevIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId );

	List<ICFBamPubRelationColObj> readCachedRelationColByRelNextIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 NextId );

	void deepDisposeRelationColByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeRelationColByUNameIdx( MCFDbKeyHash256 RelationId,
		String Name );

	void deepDisposeRelationColByRelationIdx( MCFDbKeyHash256 RelationId );

	void deepDisposeRelationColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeRelationColByFromColIdx( MCFDbKeyHash256 FromColId );

	void deepDisposeRelationColByToColIdx( MCFDbKeyHash256 ToColId );

	void deepDisposeRelationColByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeRelationColByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeRelationColByRelPrevIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeRelationColByRelNextIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubRelationColObj updateRelationCol( ICFBamPubRelationColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteRelationCol( ICFBamPubRelationColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByUNameIdx(MCFDbKeyHash256 RelationId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByRelationIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	FromColId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByFromColIdx( MCFDbKeyHash256 FromColId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ToColId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByToColIdx( MCFDbKeyHash256 ToColId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByRelPrevIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByRelNextIdx( MCFDbKeyHash256 RelationId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Move the CFBamPubRelationColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubRelationColObj refreshed cache instance.
	 */
	ICFBamPubRelationColObj moveUpRelationCol( ICFBamPubRelationColObj Obj );

	/**
	 *	Move the CFBamPubRelationColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubRelationColObj refreshed cache instance.
	 */
	ICFBamPubRelationColObj moveDownRelationCol( ICFBamPubRelationColObj Obj );
}
