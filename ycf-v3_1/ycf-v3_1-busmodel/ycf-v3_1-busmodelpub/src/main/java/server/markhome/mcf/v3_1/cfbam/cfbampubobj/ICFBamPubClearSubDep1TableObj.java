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

public interface ICFBamPubClearSubDep1TableObj
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
	 *	Instantiate a new ClearSubDep1 instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubClearSubDep1Obj newInstance();

	/**
	 *	Instantiate a new ClearSubDep1 edition of the specified ClearSubDep1 instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubClearSubDep1EditObj newEditInstance( ICFBamPubClearSubDep1Obj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubClearSubDep1Obj realiseClearSubDep1( ICFBamPubClearSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubClearSubDep1Obj createClearSubDep1( ICFBamPubClearSubDep1Obj Obj );

	/**
	 *	Read a ClearSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubClearSubDep1Obj readClearSubDep1( IMCFKeyHash256 pkey );

	/**
	 *	Read a ClearSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubClearSubDep1Obj readClearSubDep1( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubClearSubDep1Obj readCachedClearSubDep1( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeClearSubDep1( ICFBamPubClearSubDep1Obj obj );

	void deepDisposeClearSubDep1( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubClearSubDep1Obj lockClearSubDep1( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the ClearSubDep1-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubClearSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readAllClearSubDep1();

	/**
	 *	Return a sorted map of all the ClearSubDep1-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubClearSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readAllClearSubDep1( boolean forceRead );

	List<ICFBamPubClearSubDep1Obj> readCachedAllClearSubDep1();

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubClearSubDep1Obj readClearSubDep1ByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubClearSubDep1Obj readClearSubDep1ByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readClearSubDep1ByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFBamPubClearSubDep1Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readClearSubDep1ByTenantIdx( MCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubClearDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearSubDep1Obj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readClearSubDep1ByClearDepIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Get the map of CFBamPubClearSubDep1Obj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearSubDep1Obj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readClearSubDep1ByClearDepIdx( MCFDbKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubClearDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readClearSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubClearSubDep1Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readClearSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubClearSubDep1Obj instances sorted by their primary keys for the duplicate ClearTopDepIdx key.
	 *
	 *	@param	ClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearSubDep1Obj cached instances sorted by their primary keys for the duplicate ClearTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readClearSubDep1ByClearTopDepIdx( MCFDbKeyHash256 ClearTopDepId );

	/**
	 *	Get the map of CFBamPubClearSubDep1Obj instances sorted by their primary keys for the duplicate ClearTopDepIdx key.
	 *
	 *	@param	ClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearSubDep1Obj cached instances sorted by their primary keys for the duplicate ClearTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearSubDep1Obj> readClearSubDep1ByClearTopDepIdx( MCFDbKeyHash256 ClearTopDepId,
		boolean forceRead );

	/**
	 *	Get the CFBamPubClearSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	ClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubClearSubDep1Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubClearSubDep1Obj readClearSubDep1ByUNameIdx(MCFDbKeyHash256 ClearTopDepId,
		String Name );

	/**
	 *	Get the CFBamPubClearSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	ClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubClearSubDep1Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubClearSubDep1Obj readClearSubDep1ByUNameIdx(MCFDbKeyHash256 ClearTopDepId,
		String Name,
		boolean forceRead );

	ICFBamPubClearSubDep1Obj readCachedClearSubDep1ByIdIdx( MCFDbKeyHash256 Id );

	List<ICFBamPubClearSubDep1Obj> readCachedClearSubDep1ByTenantIdx( MCFDbKeyHash256 TenantId );

	List<ICFBamPubClearSubDep1Obj> readCachedClearSubDep1ByClearDepIdx( MCFDbKeyHash256 RelationId );

	List<ICFBamPubClearSubDep1Obj> readCachedClearSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubClearSubDep1Obj> readCachedClearSubDep1ByClearTopDepIdx( MCFDbKeyHash256 ClearTopDepId );

	ICFBamPubClearSubDep1Obj readCachedClearSubDep1ByUNameIdx( MCFDbKeyHash256 ClearTopDepId,
		String Name );

	void deepDisposeClearSubDep1ByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeClearSubDep1ByTenantIdx( MCFDbKeyHash256 TenantId );

	void deepDisposeClearSubDep1ByClearDepIdx( MCFDbKeyHash256 RelationId );

	void deepDisposeClearSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeClearSubDep1ByClearTopDepIdx( MCFDbKeyHash256 ClearTopDepId );

	void deepDisposeClearSubDep1ByUNameIdx( MCFDbKeyHash256 ClearTopDepId,
		String Name );

	/**
	 *	Internal use only.
	 */
	ICFBamPubClearSubDep1Obj updateClearSubDep1( ICFBamPubClearSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteClearSubDep1( ICFBamPubClearSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByClearDepIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByClearTopDepIdx( MCFDbKeyHash256 ClearTopDepId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClearTopDepId	The ClearSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearSubDep1 key attribute of the instance generating the id.
	 */
	void deleteClearSubDep1ByUNameIdx(MCFDbKeyHash256 ClearTopDepId,
		String Name );
}
