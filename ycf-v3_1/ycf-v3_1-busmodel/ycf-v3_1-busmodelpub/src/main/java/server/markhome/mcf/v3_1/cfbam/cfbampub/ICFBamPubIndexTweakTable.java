
// Description: Java 25 public DbIO interface for IndexTweak.

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

package server.markhome.mcf.v3_1.cfbam.cfbampub;

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
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;

/*
 *	CFBamPubIndexTweakTable public database interface for IndexTweak has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFBamPubIndexTweakTable
{
	public static final String TABLE_NAME = "IndexTweak";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamPubIndexTweak pubcreateIndexTweak( ICFSecPubAuthorization Authorization,
		ICFBamPubIndexTweak rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamPubIndexTweak pubupdateIndexTweak( ICFSecPubAuthorization Authorization,
		ICFBamPubIndexTweak rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void pubdeleteIndexTweak( ICFSecPubAuthorization Authorization,
		ICFBamPubIndexTweak rec );
	/**
	 *	Delete the IndexTweak instances identified by the key IndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IndexId	The IndexTweak key attribute of the instance generating the id.
	 */
	public void pubdeleteIndexTweakByIndexIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argIndexId );

	/**
	 *	Delete the IndexTweak instances identified by the key IndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteIndexTweakByIndexIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubIndexTweakByIndexIdxKey argKey );
	/**
	 *	Delete the IndexTweak instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void pubdeleteIndexTweakByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argKey );
	/**
	 *	Delete the IndexTweak instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 */
	public void pubdeleteIndexTweakByUNameIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argScopeId,
		String argName );

	/**
	 *	Delete the IndexTweak instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteIndexTweakByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByUNameIdxKey argKey );
	/**
	 *	Delete the IndexTweak instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 */
	public void pubdeleteIndexTweakByValTentIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argTenantId );

	/**
	 *	Delete the IndexTweak instances identified by the key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteIndexTweakByValTentIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByValTentIdxKey argKey );
	/**
	 *	Delete the IndexTweak instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 */
	public void pubdeleteIndexTweakByScopeIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argScopeId );

	/**
	 *	Delete the IndexTweak instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteIndexTweakByScopeIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByScopeIdxKey argKey );
	/**
	 *	Delete the IndexTweak instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 */
	public void pubdeleteIndexTweakByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the IndexTweak instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteIndexTweakByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByDefSchemaIdxKey argKey );
	/**
	 *	Delete the IndexTweak instances identified by the key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 */
	public void pubdeleteIndexTweakByUDefIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argTenantId,
		MCFDbKeyHash256 argScopeId,
		MCFDbKeyHash256 argDefSchemaTenantId,
		MCFDbKeyHash256 argDefSchemaId,
		String argName );

	/**
	 *	Delete the IndexTweak instances identified by the key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteIndexTweakByUDefIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubTweakByUDefIdxKey argKey );


	/**
	 *	Read the derived IndexTweak record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the IndexTweak instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamPubIndexTweak pubreadDerived( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PKey );

	/**
	 *	Lock the derived IndexTweak record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the IndexTweak instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamPubIndexTweak publockDerived( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PKey );

	/**
	 *	Read all IndexTweak instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFBamPubIndexTweak[] pubreadPubAllDerived( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the derived IndexTweak record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamPubIndexTweak pubreadDerivedByIdIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 Id );

	/**
	 *	Read the derived IndexTweak record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamPubIndexTweak pubreadDerivedByUNameIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the derived IndexTweak record instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamPubIndexTweak[] pubreadDerivedByValTentIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 TenantId );

	/**
	 *	Read an array of the derived IndexTweak record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamPubIndexTweak[] pubreadDerivedByScopeIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 ScopeId );

	/**
	 *	Read an array of the derived IndexTweak record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamPubIndexTweak[] pubreadDerivedByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read the derived IndexTweak record instance identified by the unique key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamPubIndexTweak pubreadDerivedByUDefIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 TenantId,
		MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Read an array of the derived IndexTweak record instances identified by the duplicate key IndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IndexId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamPubIndexTweak[] pubreadDerivedByIndexIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 IndexId );

	/**
	 *	Read the specific IndexTweak record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the IndexTweak instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweak pubreadRec( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PKey );

	/**
	 *	Lock the specific IndexTweak record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the IndexTweak instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweak publockRec( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PKey );

	/**
	 *	Read all the specific IndexTweak record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific IndexTweak instances in the database accessible for the Authorization.
	 */
	public ICFBamPubIndexTweak[] pubreadAllRec( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the specific IndexTweak record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweak pubreadRecByIdIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 Id );

	/**
	 *	Read the specific IndexTweak record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweak pubreadRecByUNameIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the specific IndexTweak record instances identified by the duplicate key ValTentIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweak[] pubreadRecByValTentIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 TenantId );

	/**
	 *	Read an array of the specific IndexTweak record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweak[] pubreadRecByScopeIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 ScopeId );

	/**
	 *	Read an array of the specific IndexTweak record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweak[] pubreadRecByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read the specific IndexTweak record instance identified by the unique key UDefIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	ScopeId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaTenantId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	DefSchemaId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@param	Name	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweak pubreadRecByUDefIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 TenantId,
		MCFDbKeyHash256 ScopeId,
		MCFDbKeyHash256 DefSchemaTenantId,
		MCFDbKeyHash256 DefSchemaId,
		String Name );

	/**
	 *	Read an array of the specific IndexTweak record instances identified by the duplicate key IndexIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IndexId	The IndexTweak key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweak[] pubreadRecByIndexIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 IndexId );
}
