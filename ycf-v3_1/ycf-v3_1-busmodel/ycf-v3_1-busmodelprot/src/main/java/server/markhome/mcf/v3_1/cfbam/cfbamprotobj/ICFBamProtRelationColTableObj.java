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

public interface ICFBamProtRelationColTableObj
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
	 *	Instantiate a new RelationCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtRelationColObj newInstance();

	/**
	 *	Instantiate a new RelationCol edition of the specified RelationCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtRelationColEditObj newEditInstance( ICFBamProtRelationColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtRelationColObj realiseRelationCol( ICFBamProtRelationColObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtRelationColObj createRelationCol( ICFBamProtRelationColObj Obj );

	/**
	 *	Read a RelationCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The RelationCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtRelationColObj readRelationCol( MCFDbKeyHash256 pkey );

	/**
	 *	Read a RelationCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The RelationCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtRelationColObj readRelationCol( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtRelationColObj readCachedRelationCol( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeRelationCol( ICFBamProtRelationColObj obj );

	void deepDisposeRelationCol( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtRelationColObj lockRelationCol( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the RelationCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtRelationColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtRelationColObj> readAllRelationCol();

	/**
	 *	Return a sorted map of all the RelationCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtRelationColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtRelationColObj> readAllRelationCol( boolean forceRead );

	List<ICFBamProtRelationColObj> readCachedAllRelationCol();

	/**
	 *	Get the ICFBamProtRelationColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRelationColObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtRelationColObj readRelationColByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtRelationColObj instance for the primary key attributes.
	 *
	 *	@param	Id	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRelationColObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtRelationColObj readRelationColByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtRelationColObj instance for the unique UNameIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRelationColObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtRelationColObj readRelationColByUNameIdx(IMCFKeyHash256 RelationId,
		String Name );

	/**
	 *	Get the ICFBamProtRelationColObj instance for the unique UNameIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtRelationColObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtRelationColObj readRelationColByUNameIdx(IMCFKeyHash256 RelationId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByRelationIdx( IMCFKeyHash256 RelationId );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByRelationIdx( IMCFKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate FromColIdx key.
	 *
	 *	@param	FromColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate FromColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByFromColIdx( IMCFKeyHash256 FromColId );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate FromColIdx key.
	 *
	 *	@param	FromColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate FromColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByFromColIdx( IMCFKeyHash256 FromColId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate ToColIdx key.
	 *
	 *	@param	ToColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate ToColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByToColIdx( IMCFKeyHash256 ToColId );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate ToColIdx key.
	 *
	 *	@param	ToColId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate ToColIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByToColIdx( IMCFKeyHash256 ToColId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate RelPrevIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate RelPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByRelPrevIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate RelPrevIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate RelPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByRelPrevIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate RelNextIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate RelNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByRelNextIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<ICFBamProtRelationColObj> instances sorted by their primary keys for the duplicate RelNextIdx key.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtRelationColObj> cached instances sorted by their primary keys for the duplicate RelNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtRelationColObj> readRelationColByRelNextIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamProtRelationColObj readCachedRelationColByIdIdx( IMCFKeyHash256 Id );

	ICFBamProtRelationColObj readCachedRelationColByUNameIdx( IMCFKeyHash256 RelationId,
		String Name );

	List<List<ICFBamProtRelationColObj>> readCachedRelationColByRelationIdx( IMCFKeyHash256 RelationId );

	List<List<ICFBamProtRelationColObj>> readCachedRelationColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<List<ICFBamProtRelationColObj>> readCachedRelationColByFromColIdx( IMCFKeyHash256 FromColId );

	List<List<ICFBamProtRelationColObj>> readCachedRelationColByToColIdx( IMCFKeyHash256 ToColId );

	List<List<ICFBamProtRelationColObj>> readCachedRelationColByPrevIdx( MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtRelationColObj>> readCachedRelationColByNextIdx( MCFDbKeyHash256 NextId );

	List<List<ICFBamProtRelationColObj>> readCachedRelationColByRelPrevIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtRelationColObj>> readCachedRelationColByRelNextIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 NextId );

	void deepDisposeRelationColByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeRelationColByUNameIdx( IMCFKeyHash256 RelationId,
		String Name );

	void deepDisposeRelationColByRelationIdx( IMCFKeyHash256 RelationId );

	void deepDisposeRelationColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeRelationColByFromColIdx( IMCFKeyHash256 FromColId );

	void deepDisposeRelationColByToColIdx( IMCFKeyHash256 ToColId );

	void deepDisposeRelationColByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeRelationColByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeRelationColByRelPrevIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeRelationColByRelNextIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtRelationColObj updateRelationCol( ICFBamProtRelationColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteRelationCol( ICFBamProtRelationColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByUNameIdx(IMCFKeyHash256 RelationId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByRelationIdx( IMCFKeyHash256 RelationId );

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
	void deleteRelationColByFromColIdx( IMCFKeyHash256 FromColId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ToColId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByToColIdx( IMCFKeyHash256 ToColId );

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
	void deleteRelationColByRelPrevIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The RelationCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The RelationCol key attribute of the instance generating the id.
	 */
	void deleteRelationColByRelNextIdx( IMCFKeyHash256 RelationId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Move the ICFBamProtRelationColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtRelationColObj refreshed cache instance.
	 */
	ICFBamProtRelationColObj moveUpRelationCol( ICFBamProtRelationColObj Obj );

	/**
	 *	Move the ICFBamProtRelationColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtRelationColObj refreshed cache instance.
	 */
	ICFBamProtRelationColObj moveDownRelationCol( ICFBamProtRelationColObj Obj );
}
