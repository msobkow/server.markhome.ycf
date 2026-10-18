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

public interface ICFBamPubClearTopDepTableObj
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
	 *	Instantiate a new ClearTopDep instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubClearTopDepObj newInstance();

	/**
	 *	Instantiate a new ClearTopDep edition of the specified ClearTopDep instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubClearTopDepEditObj newEditInstance( ICFBamPubClearTopDepObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubClearTopDepObj realiseClearTopDep( ICFBamPubClearTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubClearTopDepObj createClearTopDep( ICFBamPubClearTopDepObj Obj );

	/**
	 *	Read a ClearTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubClearTopDepObj readClearTopDep( IMCFKeyHash256 pkey );

	/**
	 *	Read a ClearTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ClearTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubClearTopDepObj readClearTopDep( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubClearTopDepObj readCachedClearTopDep( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeClearTopDep( ICFBamPubClearTopDepObj obj );

	void deepDisposeClearTopDep( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubClearTopDepObj lockClearTopDep( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the ClearTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubClearTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readAllClearTopDep();

	/**
	 *	Return a sorted map of all the ClearTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubClearTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readAllClearTopDep( boolean forceRead );

	List<ICFBamPubClearTopDepObj> readCachedAllClearTopDep();

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubClearTopDepObj readClearTopDepByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubClearTopDepObj readClearTopDepByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFBamPubClearTopDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByTenantIdx( MCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubClearDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByClearDepIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Get the map of CFBamPubClearTopDepObj instances sorted by their primary keys for the duplicate ClearDepIdx key.
	 *
	 *	@param	RelationId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate ClearDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByClearDepIdx( MCFDbKeyHash256 RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubClearDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubClearTopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubClearTopDepObj instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByClrTopDepTblIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Get the map of CFBamPubClearTopDepObj instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate ClrTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByClrTopDepTblIdx( MCFDbKeyHash256 TableId,
		boolean forceRead );

	/**
	 *	Get the CFBamPubClearTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubClearTopDepObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubClearTopDepObj readClearTopDepByUNameIdx(MCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Get the CFBamPubClearTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubClearTopDepObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubClearTopDepObj readClearTopDepByUNameIdx(MCFDbKeyHash256 TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubClearTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Get the map of CFBamPubClearTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByPrevIdx( MCFDbKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubClearTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Get the map of CFBamPubClearTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubClearTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubClearTopDepObj> readClearTopDepByNextIdx( MCFDbKeyHash256 NextId,
		boolean forceRead );

	ICFBamPubClearTopDepObj readCachedClearTopDepByIdIdx( MCFDbKeyHash256 Id );

	List<ICFBamPubClearTopDepObj> readCachedClearTopDepByTenantIdx( MCFDbKeyHash256 TenantId );

	List<ICFBamPubClearTopDepObj> readCachedClearTopDepByClearDepIdx( MCFDbKeyHash256 RelationId );

	List<ICFBamPubClearTopDepObj> readCachedClearTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	List<ICFBamPubClearTopDepObj> readCachedClearTopDepByClrTopDepTblIdx( MCFDbKeyHash256 TableId );

	ICFBamPubClearTopDepObj readCachedClearTopDepByUNameIdx( MCFDbKeyHash256 TableId,
		String Name );

	List<ICFBamPubClearTopDepObj> readCachedClearTopDepByPrevIdx( MCFDbKeyHash256 PrevId );

	List<ICFBamPubClearTopDepObj> readCachedClearTopDepByNextIdx( MCFDbKeyHash256 NextId );

	void deepDisposeClearTopDepByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeClearTopDepByTenantIdx( MCFDbKeyHash256 TenantId );

	void deepDisposeClearTopDepByClearDepIdx( MCFDbKeyHash256 RelationId );

	void deepDisposeClearTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeClearTopDepByClrTopDepTblIdx( MCFDbKeyHash256 TableId );

	void deepDisposeClearTopDepByUNameIdx( MCFDbKeyHash256 TableId,
		String Name );

	void deepDisposeClearTopDepByPrevIdx( MCFDbKeyHash256 PrevId );

	void deepDisposeClearTopDepByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubClearTopDepObj updateClearTopDep( ICFBamPubClearTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteClearTopDep( ICFBamPubClearTopDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByTenantIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	RelationId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByClearDepIdx( MCFDbKeyHash256 RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByClrTopDepTblIdx( MCFDbKeyHash256 TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableId	The ClearTopDep key attribute of the instance generating the id.
	 *
	 *	@param	Name	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByUNameIdx(MCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByPrevIdx( MCFDbKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The ClearTopDep key attribute of the instance generating the id.
	 */
	void deleteClearTopDepByNextIdx( MCFDbKeyHash256 NextId );

	/**
	 *	Move the CFBamPubClearTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubClearTopDepObj refreshed cache instance.
	 */
	ICFBamPubClearTopDepObj moveUpClearTopDep( ICFBamPubClearTopDepObj Obj );

	/**
	 *	Move the CFBamPubClearTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamPubClearTopDepObj refreshed cache instance.
	 */
	ICFBamPubClearTopDepObj moveDownClearTopDep( ICFBamPubClearTopDepObj Obj );
}
