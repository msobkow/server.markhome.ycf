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

public interface ICFBamProtEnumTagTableObj
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
	 *	Instantiate a new EnumTag instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtEnumTagObj newInstance();

	/**
	 *	Instantiate a new EnumTag edition of the specified EnumTag instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtEnumTagEditObj newEditInstance( ICFBamProtEnumTagObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtEnumTagObj realiseEnumTag( ICFBamProtEnumTagObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtEnumTagObj createEnumTag( ICFBamProtEnumTagObj Obj );

	/**
	 *	Read a EnumTag-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumTag-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtEnumTagObj readEnumTag( MCFDbKeyHash256 pkey );

	/**
	 *	Read a EnumTag-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumTag-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtEnumTagObj readEnumTag( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtEnumTagObj readCachedEnumTag( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeEnumTag( ICFBamProtEnumTagObj obj );

	void deepDisposeEnumTag( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtEnumTagObj lockEnumTag( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the EnumTag-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtEnumTagObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtEnumTagObj> readAllEnumTag();

	/**
	 *	Return a sorted map of all the EnumTag-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtEnumTagObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtEnumTagObj> readAllEnumTag( boolean forceRead );

	List<ICFBamProtEnumTagObj> readCachedAllEnumTag();

	/**
	 *	Get the ICFBamProtEnumTagObj instance for the primary key attributes.
	 *
	 *	@param	Id	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtEnumTagObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtEnumTagObj readEnumTagByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtEnumTagObj instance for the primary key attributes.
	 *
	 *	@param	Id	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtEnumTagObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtEnumTagObj readEnumTagByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtEnumTagObj> instances sorted by their primary keys for the duplicate EnumIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtEnumTagObj> cached instances sorted by their primary keys for the duplicate EnumIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtEnumTagObj> readEnumTagByEnumIdx( IMCFKeyHash256 EnumId );

	/**
	 *	Get the map of List<ICFBamProtEnumTagObj> instances sorted by their primary keys for the duplicate EnumIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtEnumTagObj> cached instances sorted by their primary keys for the duplicate EnumIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtEnumTagObj> readEnumTagByEnumIdx( IMCFKeyHash256 EnumId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtEnumTagObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtEnumTagObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtEnumTagObj> readEnumTagByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of List<ICFBamProtEnumTagObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtEnumTagObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtEnumTagObj> readEnumTagByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtEnumTagObj instance for the unique EnumNameIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	Name	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtEnumTagObj cached instance for the unique EnumNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtEnumTagObj readEnumTagByEnumNameIdx(IMCFKeyHash256 EnumId,
		String Name );

	/**
	 *	Get the ICFBamProtEnumTagObj instance for the unique EnumNameIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	Name	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtEnumTagObj refreshed instance for the unique EnumNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtEnumTagObj readEnumTagByEnumNameIdx(IMCFKeyHash256 EnumId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtEnumTagObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtEnumTagObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtEnumTagObj> readEnumTagByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of List<ICFBamProtEnumTagObj> instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtEnumTagObj> cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtEnumTagObj> readEnumTagByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtEnumTagObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtEnumTagObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtEnumTagObj> readEnumTagByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of List<ICFBamProtEnumTagObj> instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtEnumTagObj> cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtEnumTagObj> readEnumTagByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamProtEnumTagObj readCachedEnumTagByIdIdx( IMCFKeyHash256 Id );

	List<List<ICFBamProtEnumTagObj>> readCachedEnumTagByEnumIdx( IMCFKeyHash256 EnumId );

	List<List<ICFBamProtEnumTagObj>> readCachedEnumTagByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	ICFBamProtEnumTagObj readCachedEnumTagByEnumNameIdx( IMCFKeyHash256 EnumId,
		String Name );

	List<List<ICFBamProtEnumTagObj>> readCachedEnumTagByPrevIdx( MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtEnumTagObj>> readCachedEnumTagByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeEnumTagByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeEnumTagByEnumIdx( IMCFKeyHash256 EnumId );

	void deepDisposeEnumTagByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeEnumTagByEnumNameIdx( IMCFKeyHash256 EnumId,
		String Name );

	void deepDisposeEnumTagByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeEnumTagByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtEnumTagObj updateEnumTag( ICFBamProtEnumTagObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteEnumTag( ICFBamProtEnumTagObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumIdx( IMCFKeyHash256 EnumId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	Name	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumNameIdx(IMCFKeyHash256 EnumId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Move the ICFBamProtEnumTagObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtEnumTagObj refreshed cache instance.
	 */
	ICFBamProtEnumTagObj moveUpEnumTag( ICFBamProtEnumTagObj Obj );

	/**
	 *	Move the ICFBamProtEnumTagObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtEnumTagObj refreshed cache instance.
	 */
	ICFBamProtEnumTagObj moveDownEnumTag( ICFBamProtEnumTagObj Obj );
}
