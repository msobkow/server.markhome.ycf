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

public interface ICFBamProtNumberDefTableObj
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
	 *	Instantiate a new NumberDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtNumberDefObj newInstance();

	/**
	 *	Instantiate a new NumberDef edition of the specified NumberDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtNumberDefEditObj newEditInstance( ICFBamProtNumberDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamProtNumberDefObj realiseNumberDef( ICFBamProtNumberDefObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtNumberDefObj createNumberDef( ICFBamProtNumberDefObj Obj );

	/**
	 *	Read a NumberDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NumberDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtNumberDefObj readNumberDef( MCFDbKeyHash256 pkey );

	/**
	 *	Read a NumberDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NumberDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtNumberDefObj readNumberDef( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtNumberDefObj readCachedNumberDef( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeNumberDef( ICFBamProtNumberDefObj obj );

	void deepDisposeNumberDef( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtNumberDefObj lockNumberDef( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the NumberDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtNumberDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtNumberDefObj> readAllNumberDef();

	/**
	 *	Return a sorted map of all the NumberDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtNumberDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtNumberDefObj> readAllNumberDef( boolean forceRead );

	List<ICFBamProtNumberDefObj> readCachedAllNumberDef();

	/**
	 *	Get the ICFBamProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtNumberDefObj readNumberDefByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtNumberDefObj readNumberDefByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtNumberDefObj readNumberDefByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the ICFBamProtValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtNumberDefObj readNumberDefByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByScopeIdx( IMCFKeyHash256 ScopeId );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByScopeIdx( IMCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of ICFBamProtNumberDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@return	List of ICFBamProtNumberDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtNumberDefObj> readNumberDefByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamProtValueObj readCachedNumberDefByIdIdx( IMCFKeyHash256 Id );

	ICFBamProtValueObj readCachedNumberDefByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	List<List<ICFBamProtValueObj>> readCachedNumberDefByScopeIdx( IMCFKeyHash256 ScopeId );

	List<List<ICFBamProtValueObj>> readCachedNumberDefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<List<ICFBamProtValueObj>> readCachedNumberDefByPrevIdx( MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtValueObj>> readCachedNumberDefByNextIdx( MCFDbKeyHash256 NextId );

	List<List<ICFBamProtValueObj>> readCachedNumberDefByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	List<List<ICFBamProtValueObj>> readCachedNumberDefByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	void deepDisposeNumberDefByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeNumberDefByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeNumberDefByScopeIdx( IMCFKeyHash256 ScopeId );

	void deepDisposeNumberDefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeNumberDefByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeNumberDefByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeNumberDefByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	void deepDisposeNumberDefByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamProtNumberDefObj updateNumberDef( ICFBamProtNumberDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteNumberDef( ICFBamProtNumberDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The NumberDef key attribute of the instance generating the id.
	 */
	void deleteNumberDefByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The NumberDef key attribute of the instance generating the id.
	 */
	void deleteNumberDefByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 */
	void deleteNumberDefByScopeIdx( IMCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The NumberDef key attribute of the instance generating the id.
	 */
	void deleteNumberDefByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The NumberDef key attribute of the instance generating the id.
	 */
	void deleteNumberDefByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The NumberDef key attribute of the instance generating the id.
	 */
	void deleteNumberDefByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The NumberDef key attribute of the instance generating the id.
	 */
	void deleteNumberDefByContPrevIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The NumberDef key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The NumberDef key attribute of the instance generating the id.
	 */
	void deleteNumberDefByContNextIdx( IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Move the ICFBamProtNumberDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtNumberDefObj refreshed cache instance.
	 */
	ICFBamProtNumberDefObj moveUpNumberDef( ICFBamProtNumberDefObj Obj );

	/**
	 *	Move the ICFBamProtNumberDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	ICFBamProtNumberDefObj refreshed cache instance.
	 */
	ICFBamProtNumberDefObj moveDownNumberDef( ICFBamProtNumberDefObj Obj );
}
