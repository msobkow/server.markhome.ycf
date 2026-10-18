
// Description: Java 25 protlic DbIO interface for Tweak.

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

package server.markhome.mcf.v3_1.cfbam.cfbamprot;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
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
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbamprotobj.*;

/*
 *	CFBamProtTweakTable protlic database interface for Tweak has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFBamProtTweakTable
extends ICFBamPubTweakTable
{
	public static final String TABLE_NAME = "Tweak";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtTweak protcreateTweak( ICFSecPubAuthorization Authorization,
		ICFBamProtTweak rec );

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtTweak protcreateTweak( ICFSecPubAuthorization Authorization,
		ICFBamPubTweak rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtTweak protupdateTweak( ICFSecPubAuthorization Authorization,
		ICFBamProtTweak rec );

	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtTweak protupdateTweak( ICFSecPubAuthorization Authorization,
		ICFBamPubTweak rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteTweak( ICFSecPubAuthorization Authorization,
		ICFBamProtTweak rec );
	/**
	 *	Delete the Tweak instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteTweakByIdIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argKey );
	/**
	 *	Delete the Tweak instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 */
	public void protdeleteTweakByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId,
		String argName );

	/**
	 *	Delete the Tweak instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtTweakByUNameIdxKey argKey );
	/**
	 *	Delete the Tweak instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByUNameIdxKey argKey );
	/**
	 *	Delete the Tweak instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 */
	public void protdeleteTweakByValTentIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argTenantId );

	/**
	 *	Delete the Tweak instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByValTentIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtTweakByValTentIdxKey argKey );
	/**
	 *	Delete the Tweak instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByValTentIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByValTentIdxKey argKey );
	/**
	 *	Delete the Tweak instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 */
	public void protdeleteTweakByScopeIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId );

	/**
	 *	Delete the Tweak instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByScopeIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtTweakByScopeIdxKey argKey );
	/**
	 *	Delete the Tweak instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByScopeIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByScopeIdxKey argKey );
	/**
	 *	Delete the Tweak instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 */
	public void protdeleteTweakByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the Tweak instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtTweakByDefSchemaIdxKey argKey );
	/**
	 *	Delete the Tweak instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByDefSchemaIdxKey argKey );
	/**
	 *	Delete the Tweak instances identified by the key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
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
	public void protdeleteTweakByUDefIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argTenantId,
		IMCFKeyHash256 argScopeId,
		MCFDbKeyHash256 argDefSchemaTenantId,
		MCFDbKeyHash256 argDefSchemaId,
		String argName );

	/**
	 *	Delete the Tweak instances identified by the key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByUDefIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtTweakByUDefIdxKey argKey );
	/**
	 *	Delete the Tweak instances identified by the key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteTweakByUDefIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByUDefIdxKey argKey );

	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteTweak( ICFSecPubAuthorization Authorization,
		ICFBamPubTweak rec );


	/**
	 *	Read the derived Tweak record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Tweak instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtTweak protreadDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived Tweak record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Tweak instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtTweak protlockDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all Tweak instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFBamProtTweak[] protreadProtAllDerived( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the derived Tweak record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtTweak protreadDerivedByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read the derived Tweak record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtTweak protreadDerivedByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the derived Tweak record instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtTweak[] protreadDerivedByValTentIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 TenantId );

	/**
	 *	Read an array of the derived Tweak record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtTweak[] protreadDerivedByScopeIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId );

	/**
	 *	Read an array of the derived Tweak record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtTweak[] protreadDerivedByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read the derived Tweak record instance identified by the unique key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
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
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtTweak protreadDerivedByUDefIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 TenantId,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Read the specific Tweak record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Tweak instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTweak protreadRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific Tweak record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Tweak instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTweak protlockRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific Tweak record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Tweak instances in the database accessible for the Authorization.
	 */
	public ICFBamProtTweak[] protreadAllRec( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the specific Tweak record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTweak protreadRecByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read the specific Tweak record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTweak protreadRecByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the specific Tweak record instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTweak[] protreadRecByValTentIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 TenantId );

	/**
	 *	Read an array of the specific Tweak record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTweak[] protreadRecByScopeIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId );

	/**
	 *	Read an array of the specific Tweak record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Tweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTweak[] protreadRecByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read the specific Tweak record instance identified by the unique key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
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
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTweak protreadRecByUDefIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 TenantId,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );
}
