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

public interface ICFBamPubTimestampTypeTableObj
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
	 *	Instantiate a new TimestampType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubTimestampTypeObj newInstance();

	/**
	 *	Instantiate a new TimestampType edition of the specified TimestampType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubTimestampTypeEditObj newEditInstance( ICFBamPubTimestampTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubTimestampTypeObj realiseTimestampType( ICFBamPubTimestampTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubTimestampTypeObj createTimestampType( ICFBamPubTimestampTypeObj Obj );

	/**
	 *	Read a TimestampType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimestampType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubTimestampTypeObj readTimestampType( IMCFKeyHash256 pkey );

	/**
	 *	Read a TimestampType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TimestampType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubTimestampTypeObj readTimestampType( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubTimestampTypeObj readCachedTimestampType( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeTimestampType( ICFBamPubTimestampTypeObj obj );

	void deepDisposeTimestampType( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubTimestampTypeObj lockTimestampType( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the TimestampType-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubTimestampTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readAllTimestampType();

	/**
	 *	Return a sorted map of all the TimestampType-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubTimestampTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readAllTimestampType( boolean forceRead );

	List<ICFBamPubTimestampTypeObj> readCachedAllTimestampType();

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubTimestampTypeObj readTimestampTypeByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubTimestampTypeObj readTimestampTypeByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubTimestampTypeObj readTimestampTypeByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the CFBamPubValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubTimestampTypeObj readTimestampTypeByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of CFBamPubTimestampTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByScopeIdx( MCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubTimestampTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubTimestampTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubTimestampTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubTimestampTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubTimestampTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubTimestampTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	/**
	 *	Get the map of CFBamPubTimestampTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubTimestampTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubTimestampTypeObj> readTimestampTypeBySchemaIdx( MCFDbKeyHash256 SchemaDefId,
		boolean forceRead );

	ICFBamPubTimestampTypeObj readCachedTimestampTypeByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubTimestampTypeObj readCachedTimestampTypeByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	List<ICFBamPubTimestampTypeObj> readCachedTimestampTypeByScopeIdx( MCFDbKeyHash256 ScopeId );

	List<ICFBamPubTimestampTypeObj> readCachedTimestampTypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubTimestampTypeObj> readCachedTimestampTypeByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubTimestampTypeObj> readCachedTimestampTypeByNextIdx( MCFDbKeyHash256 NextId );

	List<ICFBamPubTimestampTypeObj> readCachedTimestampTypeByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	List<ICFBamPubTimestampTypeObj> readCachedTimestampTypeByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	List<ICFBamPubTimestampTypeObj> readCachedTimestampTypeBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	void deepDisposeTimestampTypeByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeTimestampTypeByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeTimestampTypeByScopeIdx( MCFDbKeyHash256 ScopeId );

	void deepDisposeTimestampTypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeTimestampTypeByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeTimestampTypeByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeTimestampTypeByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeTimestampTypeByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	void deepDisposeTimestampTypeBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubTimestampTypeObj updateTimestampType( ICFBamPubTimestampTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTimestampType( ICFBamPubTimestampTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The TimestampType key attribute of the instance generating the id.
	 */
	void deleteTimestampTypeByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TimestampType key attribute of the instance generating the id.
	 */
	void deleteTimestampTypeByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 */
	void deleteTimestampTypeByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The TimestampType key attribute of the instance generating the id.
	 */
	void deleteTimestampTypeByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The TimestampType key attribute of the instance generating the id.
	 */
	void deleteTimestampTypeByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The TimestampType key attribute of the instance generating the id.
	 */
	void deleteTimestampTypeByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The TimestampType key attribute of the instance generating the id.
	 */
	void deleteTimestampTypeByContPrevIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TimestampType key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The TimestampType key attribute of the instance generating the id.
	 */
	void deleteTimestampTypeByContNextIdx( MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The TimestampType key attribute of the instance generating the id.
	 */
	void deleteTimestampTypeBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	/**
	 *	Move the CFBamPubTimestampTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubTimestampTypeObj refreshed cache instance.
	 */
	ICFBamPubTimestampTypeObj moveUpTimestampType( ICFBamPubTimestampTypeObj Obj );

	/**
	 *	Move the CFBamPubTimestampTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubTimestampTypeObj refreshed cache instance.
	 */
	ICFBamPubTimestampTypeObj moveDownTimestampType( ICFBamPubTimestampTypeObj Obj );
}
