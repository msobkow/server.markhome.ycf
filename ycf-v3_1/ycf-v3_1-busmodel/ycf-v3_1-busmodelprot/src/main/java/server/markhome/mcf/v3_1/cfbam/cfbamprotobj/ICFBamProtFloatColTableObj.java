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

public interface ICFBamProtFloatColTableObj
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
	 *	Instantiate a new FloatCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtFloatColObj newInstance();

	/**
	 *	Instantiate a new FloatCol edition of the specified FloatCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtFloatColEditObj newEditInstance( ICFBamProtFloatColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtFloatColObj realiseFloatCol( ICFBamProtFloatColObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtFloatColObj createFloatCol( ICFBamProtFloatColObj Obj );

	/**
	 *	Read a FloatCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The FloatCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtFloatColObj readFloatCol( MCFDbKeyHash256 pkey );

	/**
	 *	Read a FloatCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The FloatCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtFloatColObj readFloatCol( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtFloatColObj readCachedFloatCol( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeFloatCol( ICFBamProtFloatColObj obj );

	void deepDisposeFloatCol( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtFloatColObj lockFloatCol( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the FloatCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtFloatColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtFloatColObj> readAllFloatCol();

	/**
	 *	Return a sorted map of all the FloatCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtFloatColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtFloatColObj> readAllFloatCol( boolean forceRead );

	List<ICFBamProtFloatColObj> readCachedAllFloatCol();

	/**
	 *	Get the ICFBamProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtFloatColObj readFloatColByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtFloatColObj readFloatColByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtFloatColObj readFloatColByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the ICFBamProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtFloatColObj readFloatColByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByScopeIdx( IMCFKeyHash256 ScopeId );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByScopeIdx( IMCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of ICFBamProtFloatColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtFloatColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtFloatColObj> instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtFloatColObj> cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByTableIdx( IMCFKeyHash256 TableId );

	/**
	 *	Get the map of List<ICFBamProtFloatColObj> instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	TableId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtFloatColObj> cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtFloatColObj> readFloatColByTableIdx( IMCFKeyHash256 TableId,
		boolean forceRead );

	ICFBamProtValueObj readCachedFloatColByIdIdx( IMCFKeyHash256 Id );

	ICFBamProtValueObj readCachedFloatColByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	List<List<ICFBamProtValueObj>> readCachedFloatColByScopeIdx( IMCFKeyHash256 ScopeId );

	List<List<ICFBamProtValueObj>> readCachedFloatColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<List<ICFBamProtValueObj>> readCachedFloatColByPrevIdx( MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtValueObj>> readCachedFloatColByNextIdx( MCFDbKeyHash256 NextId );

	List<List<ICFBamProtValueObj>> readCachedFloatColByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtValueObj>> readCachedFloatColByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	List<List<ICFBamProtFloatColObj>> readCachedFloatColByTableIdx( IMCFKeyHash256 TableId );

	void deepDisposeFloatColByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeFloatColByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeFloatColByScopeIdx( IMCFKeyHash256 ScopeId );

	void deepDisposeFloatColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeFloatColByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeFloatColByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeFloatColByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeFloatColByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	void deepDisposeFloatColByTableIdx( IMCFKeyHash256 TableId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtFloatColObj updateFloatCol( ICFBamProtFloatColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteFloatCol( ICFBamProtFloatColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The FloatCol key attribute of the instance generating the id.
	 */
	void deleteFloatColByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@param	Name	The FloatCol key attribute of the instance generating the id.
	 */
	void deleteFloatColByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 */
	void deleteFloatColByScopeIdx( IMCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The FloatCol key attribute of the instance generating the id.
	 */
	void deleteFloatColByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The FloatCol key attribute of the instance generating the id.
	 */
	void deleteFloatColByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The FloatCol key attribute of the instance generating the id.
	 */
	void deleteFloatColByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The FloatCol key attribute of the instance generating the id.
	 */
	void deleteFloatColByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The FloatCol key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The FloatCol key attribute of the instance generating the id.
	 */
	void deleteFloatColByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The FloatCol key attribute of the instance generating the id.
	 */
	void deleteFloatColByTableIdx( IMCFKeyHash256 TableId );

	/**
	 *	Move the ICFBamProtFloatColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtFloatColObj refreshed cache instance.
	 */
	ICFBamProtFloatColObj moveUpFloatCol( ICFBamProtFloatColObj Obj );

	/**
	 *	Move the ICFBamProtFloatColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtFloatColObj refreshed cache instance.
	 */
	ICFBamProtFloatColObj moveDownFloatCol( ICFBamProtFloatColObj Obj );
}
