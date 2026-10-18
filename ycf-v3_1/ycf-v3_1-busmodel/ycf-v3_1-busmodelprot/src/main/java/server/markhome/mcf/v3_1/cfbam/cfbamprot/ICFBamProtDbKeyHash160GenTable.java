
// Description: Java 25 protlic DbIO interface for DbKeyHash160Gen.

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
 *	CFBamProtDbKeyHash160GenTable protlic database interface for DbKeyHash160Gen has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFBamProtDbKeyHash160GenTable
extends ICFBamProtDbKeyHash160TypeTable,
	ICFBamPubDbKeyHash160GenTable
{
	public static final String TABLE_NAME = "DbKeyHash160Gen";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtDbKeyHash160Gen protcreateDbKeyHash160Gen( ICFSecPubAuthorization Authorization,
		ICFBamProtDbKeyHash160Gen rec );

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtDbKeyHash160Gen protcreateDbKeyHash160Gen( ICFSecPubAuthorization Authorization,
		ICFBamPubDbKeyHash160Gen rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtDbKeyHash160Gen protupdateDbKeyHash160Gen( ICFSecPubAuthorization Authorization,
		ICFBamProtDbKeyHash160Gen rec );

	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtDbKeyHash160Gen protupdateDbKeyHash160Gen( ICFSecPubAuthorization Authorization,
		ICFBamPubDbKeyHash160Gen rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteDbKeyHash160Gen( ICFSecPubAuthorization Authorization,
		ICFBamProtDbKeyHash160Gen rec );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 */
	public void protdeleteDbKeyHash160GenBySchemaIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argSchemaDefId );

	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenBySchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtDbKeyHash160TypeBySchemaIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenBySchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubDbKeyHash160TypeBySchemaIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByIdIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash160Gen key attribute of the instance generating the id.
	 */
	public void protdeleteDbKeyHash160GenByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId,
		String argName );

	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByUNameIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByUNameIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 */
	public void protdeleteDbKeyHash160GenByScopeIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId );

	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByScopeIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByScopeIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByScopeIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByScopeIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 */
	public void protdeleteDbKeyHash160GenByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 */
	public void protdeleteDbKeyHash160GenByPrevIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argPrevId );

	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByPrevIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByPrevIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByPrevIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByPrevIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 */
	public void protdeleteDbKeyHash160GenByNextIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argNextId );

	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByNextIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByNextIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByNextIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByNextIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 */
	public void protdeleteDbKeyHash160GenByContPrevIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId,
		MCFDbKeyHash256 argPrevId );

	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByContPrevIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByContPrevIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByContPrevIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByContPrevIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 */
	public void protdeleteDbKeyHash160GenByContNextIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId,
		MCFDbKeyHash256 argNextId );

	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByContNextIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByContNextIdxKey argKey );
	/**
	 *	Delete the DbKeyHash160Gen instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteDbKeyHash160GenByContNextIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByContNextIdxKey argKey );

	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteDbKeyHash160Gen( ICFSecPubAuthorization Authorization,
		ICFBamPubDbKeyHash160Gen rec );


	/**
	 *	Read the derived DbKeyHash160Gen record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash160Gen instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtDbKeyHash160Gen protreadDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived DbKeyHash160Gen record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash160Gen instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtDbKeyHash160Gen protlockDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all DbKeyHash160Gen instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadProtAllDerived( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the derived DbKeyHash160Gen record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtDbKeyHash160Gen protreadDerivedByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read the derived DbKeyHash160Gen record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtDbKeyHash160Gen protreadDerivedByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the derived DbKeyHash160Gen record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadDerivedByScopeIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId );

	/**
	 *	Read an array of the derived DbKeyHash160Gen record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadDerivedByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the derived DbKeyHash160Gen record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadDerivedByPrevIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the derived DbKeyHash160Gen record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadDerivedByNextIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the derived DbKeyHash160Gen record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadDerivedByContPrevIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the derived DbKeyHash160Gen record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadDerivedByContNextIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the derived DbKeyHash160Gen record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadDerivedBySchemaIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 SchemaDefId );

	/**
	 *	Read the specific DbKeyHash160Gen record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash160Gen instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen protreadRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific DbKeyHash160Gen record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash160Gen instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen protlockRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific DbKeyHash160Gen record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DbKeyHash160Gen instances in the database accessible for the Authorization.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadAllRec( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the specific DbKeyHash160Gen record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen protreadRecByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read the specific DbKeyHash160Gen record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen protreadRecByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the specific DbKeyHash160Gen record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadRecByScopeIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId );

	/**
	 *	Read an array of the specific DbKeyHash160Gen record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadRecByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the specific DbKeyHash160Gen record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadRecByPrevIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the specific DbKeyHash160Gen record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadRecByNextIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the specific DbKeyHash160Gen record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadRecByContPrevIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the specific DbKeyHash160Gen record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadRecByContNextIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the specific DbKeyHash160Gen record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The DbKeyHash160Gen key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160Gen[] protreadRecBySchemaIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 SchemaDefId );

	/**
	 *	Move the specified record up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	public ICFBamProtDbKeyHash160Gen protmoveRecUp( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id,
		int revision );

	/**
	 *	Move the specified record down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	public ICFBamProtDbKeyHash160Gen protmoveRecDown( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id,
		int revision );
}
