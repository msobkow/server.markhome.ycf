
// Description: Java 25 public DbIO interface for PopSubDep1.

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
 *	CFBamPubPopSubDep1Table public database interface for PopSubDep1 has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFBamPubPopSubDep1Table
{
	public static final String TABLE_NAME = "PopSubDep1";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamPubPopSubDep1 pubcreatePopSubDep1( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep1 rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamPubPopSubDep1 pubupdatePopSubDep1( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep1 rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void pubdeletePopSubDep1( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep1 rec );
	/**
	 *	Delete the PopSubDep1 instances identified by the key PopTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	public void pubdeletePopSubDep1ByPopTopDepIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argPopTopDepId );

	/**
	 *	Delete the PopSubDep1 instances identified by the key PopTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeletePopSubDep1ByPopTopDepIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep1ByPopTopDepIdxKey argKey );
	/**
	 *	Delete the PopSubDep1 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep1 key attribute of the instance generating the id.
	 */
	public void pubdeletePopSubDep1ByUNameIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argPopTopDepId,
		String argName );

	/**
	 *	Delete the PopSubDep1 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeletePopSubDep1ByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep1ByUNameIdxKey argKey );
	/**
	 *	Delete the PopSubDep1 instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	public void pubdeletePopSubDep1ByRelationIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argRelationId );

	/**
	 *	Delete the PopSubDep1 instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeletePopSubDep1ByRelationIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubPopDepByRelationIdxKey argKey );
	/**
	 *	Delete the PopSubDep1 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	public void pubdeletePopSubDep1ByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the PopSubDep1 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeletePopSubDep1ByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubPopDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the PopSubDep1 instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void pubdeletePopSubDep1ByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argKey );
	/**
	 *	Delete the PopSubDep1 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	public void pubdeletePopSubDep1ByTenantIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argTenantId );

	/**
	 *	Delete the PopSubDep1 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeletePopSubDep1ByTenantIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived PopSubDep1 record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep1 instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamPubPopSubDep1 pubreadDerived( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PKey );

	/**
	 *	Lock the derived PopSubDep1 record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep1 instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamPubPopSubDep1 publockDerived( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PKey );

	/**
	 *	Read all PopSubDep1 instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFBamPubPopSubDep1[] pubreadPubAllDerived( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the derived PopSubDep1 record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamPubPopSubDep1 pubreadDerivedByIdIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 Id );

	/**
	 *	Read an array of the derived PopSubDep1 record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamPubPopSubDep1[] pubreadDerivedByTenantIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 TenantId );

	/**
	 *	Read an array of the derived PopSubDep1 record instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamPubPopSubDep1[] pubreadDerivedByRelationIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 RelationId );

	/**
	 *	Read an array of the derived PopSubDep1 record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamPubPopSubDep1[] pubreadDerivedByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the derived PopSubDep1 record instances identified by the duplicate key PopTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamPubPopSubDep1[] pubreadDerivedByPopTopDepIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PopTopDepId );

	/**
	 *	Read the derived PopSubDep1 record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamPubPopSubDep1 pubreadDerivedByUNameIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PopTopDepId,
		String Name );

	/**
	 *	Read the specific PopSubDep1 record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep1 instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep1 pubreadRec( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PKey );

	/**
	 *	Lock the specific PopSubDep1 record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep1 instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep1 publockRec( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PKey );

	/**
	 *	Read all the specific PopSubDep1 record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific PopSubDep1 instances in the database accessible for the Authorization.
	 */
	public ICFBamPubPopSubDep1[] pubreadAllRec( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the specific PopSubDep1 record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep1 pubreadRecByIdIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 Id );

	/**
	 *	Read an array of the specific PopSubDep1 record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep1[] pubreadRecByTenantIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 TenantId );

	/**
	 *	Read an array of the specific PopSubDep1 record instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep1[] pubreadRecByRelationIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 RelationId );

	/**
	 *	Read an array of the specific PopSubDep1 record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep1[] pubreadRecByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the specific PopSubDep1 record instances identified by the duplicate key PopTopDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep1[] pubreadRecByPopTopDepIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PopTopDepId );

	/**
	 *	Read the specific PopSubDep1 record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep1 pubreadRecByUNameIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PopTopDepId,
		String Name );
}
