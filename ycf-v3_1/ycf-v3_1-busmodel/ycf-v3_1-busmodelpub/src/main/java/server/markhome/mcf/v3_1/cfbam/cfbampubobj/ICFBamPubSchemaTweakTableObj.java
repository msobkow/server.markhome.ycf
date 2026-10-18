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

public interface ICFBamPubSchemaTweakTableObj
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
	 *	Instantiate a new SchemaTweak instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPubSchemaTweakObj newInstance();

	/**
	 *	Instantiate a new SchemaTweak edition of the specified SchemaTweak instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPubSchemaTweakEditObj newEditInstance( ICFBamPubSchemaTweakObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPubSchemaTweakObj realiseSchemaTweak( ICFBamPubSchemaTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamPubSchemaTweakObj createSchemaTweak( ICFBamPubSchemaTweakObj Obj );

	/**
	 *	Read a SchemaTweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaTweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubSchemaTweakObj readSchemaTweak( IMCFKeyHash256 pkey );

	/**
	 *	Read a SchemaTweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaTweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPubSchemaTweakObj readSchemaTweak( IMCFKeyHash256 pkey,
		boolean forceRead );

	ICFBamPubSchemaTweakObj readCachedSchemaTweak( IMCFKeyHash256 pkey );

	public void reallyDeepDisposeSchemaTweak( ICFBamPubSchemaTweakObj obj );

	void deepDisposeSchemaTweak( IMCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamPubSchemaTweakObj lockSchemaTweak( IMCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SchemaTweak-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubSchemaTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readAllSchemaTweak();

	/**
	 *	Return a sorted map of all the SchemaTweak-derived instances in the database.
	 *
	 *	@return	List of ICFBamPubSchemaTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readAllSchemaTweak( boolean forceRead );

	List<ICFBamPubSchemaTweakObj> readCachedAllSchemaTweak();

	/**
	 *	Get the CFBamPubTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubTweakObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaTweakObj readSchemaTweakByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Get the CFBamPubTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubTweakObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaTweakObj readSchemaTweakByIdIdx( MCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the CFBamPubTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubTweakObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaTweakObj readSchemaTweakByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the CFBamPubTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubTweakObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaTweakObj readSchemaTweakByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubTweakObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaTweakObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readSchemaTweakByValTentIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFBamPubSchemaTweakObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaTweakObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readSchemaTweakByValTentIdx( MCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubTweakObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaTweakObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readSchemaTweakByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Get the map of CFBamPubSchemaTweakObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaTweakObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readSchemaTweakByScopeIdx( MCFDbKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubTweakObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaTweakObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readSchemaTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of CFBamPubSchemaTweakObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaTweakObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readSchemaTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the CFBamPubTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubTweakObj cached instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaTweakObj readSchemaTweakByUDefIdx( MCFDbKeyHash256 TenantId,
		MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Get the CFBamPubTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPubTweakObj refreshed instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPubSchemaTweakObj readSchemaTweakByUDefIdx( MCFDbKeyHash256 TenantId,
		MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPubSchemaTweakObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaTweakObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readSchemaTweakBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	/**
	 *	Get the map of CFBamPubSchemaTweakObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	SchemaDefId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPubSchemaTweakObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPubSchemaTweakObj> readSchemaTweakBySchemaIdx( MCFDbKeyHash256 SchemaDefId,
		boolean forceRead );

	ICFBamPubSchemaTweakObj readCachedSchemaTweakByIdIdx( MCFDbKeyHash256 Id );

	ICFBamPubSchemaTweakObj readCachedSchemaTweakByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	List<ICFBamPubSchemaTweakObj> readCachedSchemaTweakByValTentIdx( MCFDbKeyHash256 TenantId );

	List<ICFBamPubSchemaTweakObj> readCachedSchemaTweakByScopeIdx( MCFDbKeyHash256 ScopeId );

	List<ICFBamPubSchemaTweakObj> readCachedSchemaTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	ICFBamPubSchemaTweakObj readCachedSchemaTweakByUDefIdx( MCFDbKeyHash256 TenantId,
		MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	List<ICFBamPubSchemaTweakObj> readCachedSchemaTweakBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	void deepDisposeSchemaTweakByIdIdx( MCFDbKeyHash256 Id );

	void deepDisposeSchemaTweakByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	void deepDisposeSchemaTweakByValTentIdx( MCFDbKeyHash256 TenantId );

	void deepDisposeSchemaTweakByScopeIdx( MCFDbKeyHash256 ScopeId );

	void deepDisposeSchemaTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeSchemaTweakByUDefIdx( MCFDbKeyHash256 TenantId,
		MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	void deepDisposeSchemaTweakBySchemaIdx( MCFDbKeyHash256 SchemaDefId );

	/**
	 *	Internal use only.
	 */
	ICFBamPubSchemaTweakObj updateSchemaTweak( ICFBamPubSchemaTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSchemaTweak( ICFBamPubSchemaTweakObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The SchemaTweak key attribute of the instance generating the id.
	 */
	void deleteSchemaTweakByIdIdx( MCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaTweak key attribute of the instance generating the id.
	 */
	void deleteSchemaTweakByUNameIdx( MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The SchemaTweak key attribute of the instance generating the id.
	 */
	void deleteSchemaTweakByValTentIdx( MCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The SchemaTweak key attribute of the instance generating the id.
	 */
	void deleteSchemaTweakByScopeIdx( MCFDbKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The SchemaTweak key attribute of the instance generating the id.
	 */
	void deleteSchemaTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The SchemaTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaTweak key attribute of the instance generating the id.
	 */
	void deleteSchemaTweakByUDefIdx( MCFDbKeyHash256 TenantId,
		MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaDefId	The SchemaTweak key attribute of the instance generating the id.
	 */
	void deleteSchemaTweakBySchemaIdx( MCFDbKeyHash256 SchemaDefId );
}
