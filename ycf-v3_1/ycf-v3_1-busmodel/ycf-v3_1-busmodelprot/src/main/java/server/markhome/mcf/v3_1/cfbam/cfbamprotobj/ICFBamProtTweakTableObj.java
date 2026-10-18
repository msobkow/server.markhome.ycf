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

public interface ICFBamProtTweakTableObj
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
	 *	Instantiate a new Tweak instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamProtTweakObj newInstance();

	/**
	 *	Instantiate a new Tweak edition of the specified Tweak instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamProtTweakEditObj newEditInstance( ICFBamProtTweakObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	ICFBamProtTweakEditObj instance, which may be a subclass of a Tweak instance.
	 */
	ICFBamProtTweakObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	ICFBamProtTweakObj realiseTweak( ICFBamProtTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFBamProtTweakObj createTweak( ICFBamProtTweakObj Obj );

	/**
	 *	Read a Tweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtTweakObj readTweak( MCFDbKeyHash256 pkey );

	/**
	 *	Read a Tweak-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tweak-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamProtTweakObj readTweak( MCFDbKeyHash256 pkey,
		boolean forceRead );

	ICFBamProtTweakObj readCachedTweak( MCFDbKeyHash256 pkey );

	public void reallyDeepDisposeTweak( ICFBamProtTweakObj obj );

	void deepDisposeTweak( MCFDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFBamProtTweakObj lockTweak( MCFDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Tweak-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtTweakObj> readAllTweak();

	/**
	 *	Return a sorted map of all the Tweak-derived instances in the database.
	 *
	 *	@return	List of ICFBamProtTweakObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamProtTweakObj> readAllTweak( boolean forceRead );

	List<ICFBamProtTweakObj> readCachedAllTweak();

	/**
	 *	Get the ICFBamProtTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTweakObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTweakObj readTweakByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Get the ICFBamProtTweakObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTweakObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTweakObj readTweakByIdIdx( IMCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTweakObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTweakObj readTweakByUNameIdx(IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the ICFBamProtTweakObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTweakObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTweakObj readTweakByUNameIdx(IMCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTweakObj> instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTweakObj> cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTweakObj> readTweakByValTentIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Get the map of List<ICFBamProtTweakObj> instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTweakObj> cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTweakObj> readTweakByValTentIdx( IMCFKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTweakObj> instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTweakObj> cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTweakObj> readTweakByScopeIdx( IMCFKeyHash256 ScopeId );

	/**
	 *	Get the map of List<ICFBamProtTweakObj> instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTweakObj> cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTweakObj> readTweakByScopeIdx( IMCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of List<ICFBamProtTweakObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTweakObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTweakObj> readTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Get the map of List<ICFBamProtTweakObj> instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	List of List<ICFBamProtTweakObj> cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamProtTweakObj> readTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the ICFBamProtTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTweakObj cached instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTweakObj readTweakByUDefIdx(IMCFKeyHash256 TenantId,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Get the ICFBamProtTweakObj instance for the unique UDefIdx key.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return	ICFBamProtTweakObj refreshed instance for the unique UDefIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamProtTweakObj readTweakByUDefIdx(IMCFKeyHash256 TenantId,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name,
		boolean forceRead );

	ICFBamProtTweakObj readCachedTweakByIdIdx( IMCFKeyHash256 Id );

	ICFBamProtTweakObj readCachedTweakByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	List<List<ICFBamProtTweakObj>> readCachedTweakByValTentIdx( IMCFKeyHash256 TenantId );

	List<List<ICFBamProtTweakObj>> readCachedTweakByScopeIdx( IMCFKeyHash256 ScopeId );

	List<List<ICFBamProtTweakObj>> readCachedTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	ICFBamProtTweakObj readCachedTweakByUDefIdx( IMCFKeyHash256 TenantId,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	void deepDisposeTweakByIdIdx( IMCFKeyHash256 Id );

	void deepDisposeTweakByUNameIdx( IMCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeTweakByValTentIdx( IMCFKeyHash256 TenantId );

	void deepDisposeTweakByScopeIdx( IMCFKeyHash256 ScopeId );

	void deepDisposeTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	void deepDisposeTweakByUDefIdx( IMCFKeyHash256 TenantId,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Internal use only.
	 */
	ICFBamProtTweakObj updateTweak( ICFBamProtTweakObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTweak( ICFBamProtTweakObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByIdIdx( IMCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByUNameIdx(IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByValTentIdx( IMCFKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByScopeIdx( IMCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByDefSchemaIdx( MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 */
	void deleteTweakByUDefIdx(IMCFKeyHash256 TenantId,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );
}
