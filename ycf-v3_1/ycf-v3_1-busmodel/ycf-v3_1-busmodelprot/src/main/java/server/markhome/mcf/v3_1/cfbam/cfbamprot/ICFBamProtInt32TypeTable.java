
// Description: Java 25 protlic DbIO interface for Int32Type.

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
 *	CFBamProtInt32TypeTable protlic database interface for Int32Type has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFBamProtInt32TypeTable
extends ICFBamProtInt32DefTable,
	ICFBamPubInt32TypeTable
{
	public static final String TABLE_NAME = "Int32Type";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtInt32Type protcreateInt32Type( ICFSecPubAuthorization Authorization,
		ICFBamProtInt32Type rec );

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtInt32Type protcreateInt32Type( ICFSecPubAuthorization Authorization,
		ICFBamPubInt32Type rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtInt32Type protupdateInt32Type( ICFSecPubAuthorization Authorization,
		ICFBamProtInt32Type rec );

	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtInt32Type protupdateInt32Type( ICFSecPubAuthorization Authorization,
		ICFBamPubInt32Type rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteInt32Type( ICFSecPubAuthorization Authorization,
		ICFBamProtInt32Type rec );
	/**
	 *	Delete the Int32Type instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The Int32Type key attribute of the instance generating the id.
	 */
	public void protdeleteInt32TypeBySchemaIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argSchemaDefId );

	/**
	 *	Delete the Int32Type instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeBySchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtInt32TypeBySchemaIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeBySchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubInt32TypeBySchemaIdxKey argKey );
	/**
	 *	Delete the Int32Type instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteInt32TypeByIdIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argKey );
	/**
	 *	Delete the Int32Type instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int32Type key attribute of the instance generating the id.
	 */
	public void protdeleteInt32TypeByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId,
		String argName );

	/**
	 *	Delete the Int32Type instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByUNameIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByUNameIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 */
	public void protdeleteInt32TypeByScopeIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId );

	/**
	 *	Delete the Int32Type instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByScopeIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByScopeIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByScopeIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByScopeIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Int32Type key attribute of the instance generating the id.
	 */
	public void protdeleteInt32TypeByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the Int32Type instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 */
	public void protdeleteInt32TypeByPrevIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argPrevId );

	/**
	 *	Delete the Int32Type instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByPrevIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByPrevIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByPrevIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByPrevIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 */
	public void protdeleteInt32TypeByNextIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argNextId );

	/**
	 *	Delete the Int32Type instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByNextIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByNextIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByNextIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByNextIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 */
	public void protdeleteInt32TypeByContPrevIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId,
		MCFDbKeyHash256 argPrevId );

	/**
	 *	Delete the Int32Type instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByContPrevIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByContPrevIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByContPrevIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByContPrevIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 */
	public void protdeleteInt32TypeByContNextIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argScopeId,
		MCFDbKeyHash256 argNextId );

	/**
	 *	Delete the Int32Type instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByContNextIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtValueByContNextIdxKey argKey );
	/**
	 *	Delete the Int32Type instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteInt32TypeByContNextIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubValueByContNextIdxKey argKey );

	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteInt32Type( ICFSecPubAuthorization Authorization,
		ICFBamPubInt32Type rec );


	/**
	 *	Read the derived Int32Type record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Int32Type instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtInt32Type protreadDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived Int32Type record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Int32Type instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtInt32Type protlockDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all Int32Type instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFBamProtInt32Type[] protreadProtAllDerived( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the derived Int32Type record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtInt32Type protreadDerivedByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read the derived Int32Type record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtInt32Type protreadDerivedByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the derived Int32Type record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtInt32Type[] protreadDerivedByScopeIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId );

	/**
	 *	Read an array of the derived Int32Type record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtInt32Type[] protreadDerivedByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the derived Int32Type record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtInt32Type[] protreadDerivedByPrevIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the derived Int32Type record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtInt32Type[] protreadDerivedByNextIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the derived Int32Type record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtInt32Type[] protreadDerivedByContPrevIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the derived Int32Type record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtInt32Type[] protreadDerivedByContNextIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the derived Int32Type record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtInt32Type[] protreadDerivedBySchemaIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 SchemaDefId );

	/**
	 *	Read the specific Int32Type record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Int32Type instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type protreadRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific Int32Type record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Int32Type instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type protlockRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific Int32Type record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Int32Type instances in the database accessible for the Authorization.
	 */
	public ICFBamProtInt32Type[] protreadAllRec( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the specific Int32Type record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type protreadRecByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read the specific Int32Type record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type protreadRecByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the specific Int32Type record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type[] protreadRecByScopeIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId );

	/**
	 *	Read an array of the specific Int32Type record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type[] protreadRecByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the specific Int32Type record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type[] protreadRecByPrevIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the specific Int32Type record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type[] protreadRecByNextIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the specific Int32Type record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type[] protreadRecByContPrevIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the specific Int32Type record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type[] protreadRecByContNextIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 ScopeId,
		MCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the specific Int32Type record instances identified by the duplicate key SchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SchemaDefId	The Int32Type key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32Type[] protreadRecBySchemaIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 SchemaDefId );

	/**
	 *	Move the specified record up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	public ICFBamProtInt32Type protmoveRecUp( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id,
		int revision );

	/**
	 *	Move the specified record down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	public ICFBamProtInt32Type protmoveRecDown( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id,
		int revision );
}
