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

public interface ICFBamPubEnumTagTableObj
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
	 *	Instantiate a new EnumTag instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubEnumTagObj newInstance();

	/**
	 *	Instantiate a new EnumTag edition of the specified EnumTag instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubEnumTagEditObj newEditInstance( ICFBamPubEnumTagObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubEnumTagObj realiseEnumTag( ICFBamPubEnumTagObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubEnumTagObj createEnumTag( ICFBamPubEnumTagObj Obj );

	/**
	 *	Read a EnumTag-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumTag-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubEnumTagObj readEnumTag( IMCFKeyHash256 pkey );

	/**
	 *	Read a EnumTag-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumTag-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubEnumTagObj readEnumTag( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubEnumTagObj readCachedEnumTag( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeEnumTag( ICFBamPubEnumTagObj obj );

	void deepDisposeEnumTag( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubEnumTagObj lockEnumTag( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the EnumTag-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubEnumTagObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubEnumTagObj> readAllEnumTag();

	/**
	 *	Return a sorted map of all the EnumTag-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubEnumTagObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubEnumTagObj> readAllEnumTag( boolean forceRead );

	List<ICFBamPubEnumTagObj> readCachedAllEnumTag();

	/**
	 *	Get the CFBamPubEnumTagObj instance for the primary key attributes.
	 *
	 *	@param	Id	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubEnumTagObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubEnumTagObj readEnumTagByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubEnumTagObj instance for the primary key attributes.
	 *
	 *	@param	Id	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubEnumTagObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubEnumTagObj readEnumTagByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubEnumTagObj instances sorted by their primary keys for the duplicate EnumIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubEnumTagObj cached instances sorted by their primary keys for the duplicate EnumIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubEnumTagObj> readEnumTagByEnumIdx( MCFDbKeyHash256 EnumId );

	/**
	 *	Get the map of CFBamPubEnumTagObj instances sorted by their primary keys for the duplicate EnumIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubEnumTagObj cached instances sorted by their primary keys for the duplicate EnumIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubEnumTagObj> readEnumTagByEnumIdx( MCFDbKeyHash256 EnumId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubEnumTagObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubEnumTagObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubEnumTagObj> readEnumTagByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubEnumTagObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubEnumTagObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubEnumTagObj> readEnumTagByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the CFBamPubEnumTagObj instance for the unique EnumNameIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	Name	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubEnumTagObj cached instance for the unique EnumNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubEnumTagObj readEnumTagByEnumNameIdx(MCFDbKeyHash256 EnumId,
		String Name );

	/**
	 *	Get the CFBamPubEnumTagObj instance for the unique EnumNameIdx key.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	Name	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubEnumTagObj refreshed instance for the unique EnumNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubEnumTagObj readEnumTagByEnumNameIdx(MCFDbKeyHash256 EnumId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubEnumTagObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubEnumTagObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubEnumTagObj> readEnumTagByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubEnumTagObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubEnumTagObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubEnumTagObj> readEnumTagByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubEnumTagObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubEnumTagObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubEnumTagObj> readEnumTagByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubEnumTagObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubEnumTagObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubEnumTagObj> readEnumTagByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamPubEnumTagObj readCachedEnumTagByIdIdx( MCFDbKeyHash256 Id );

	List<ICFBamPubEnumTagObj> readCachedEnumTagByEnumIdx( MCFDbKeyHash256 EnumId );

	List<ICFBamPubEnumTagObj> readCachedEnumTagByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	ICFBamPubEnumTagObj readCachedEnumTagByEnumNameIdx( MCFDbKeyHash256 EnumId,
		String Name );

	List<ICFBamPubEnumTagObj> readCachedEnumTagByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubEnumTagObj> readCachedEnumTagByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeEnumTagByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeEnumTagByEnumIdx( MCFDbKeyHash256 EnumId );

	void deepDisposeEnumTagByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeEnumTagByEnumNameIdx( MCFDbKeyHash256 EnumId,
		String Name );

	void deepDisposeEnumTagByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeEnumTagByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubEnumTagObj updateEnumTag( ICFBamPubEnumTagObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteEnumTag( ICFBamPubEnumTagObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	EnumId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumIdx( MCFDbKeyHash256 EnumId );

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
	void deleteEnumTagByEnumNameIdx(MCFDbKeyHash256 EnumId,
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
	 *	Move the CFBamPubEnumTagObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubEnumTagObj refreshed cache instance.
	 */
	ICFBamPubEnumTagObj moveUpEnumTag( ICFBamPubEnumTagObj Obj );

	/**
	 *	Move the CFBamPubEnumTagObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubEnumTagObj refreshed cache instance.
	 */
	ICFBamPubEnumTagObj moveDownEnumTag( ICFBamPubEnumTagObj Obj );
}
