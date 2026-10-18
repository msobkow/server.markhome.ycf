
// Description: Java 25 protlic DbIO interface for PopSubDep3.

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
 *	CFBamProtPopSubDep3Table protlic database interface for PopSubDep3 has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFBamProtPopSubDep3Table
extends ICFBamProtPopDepTable,
	ICFBamPubPopSubDep3Table
{
	public static final String TABLE_NAME = "PopSubDep3";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtPopSubDep3 protcreatePopSubDep3( ICFSecPubAuthorization Authorization,
		ICFBamProtPopSubDep3 rec );

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ICFBamProtPopSubDep3 protcreatePopSubDep3( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep3 rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtPopSubDep3 protupdatePopSubDep3( ICFSecPubAuthorization Authorization,
		ICFBamProtPopSubDep3 rec );

	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ICFBamProtPopSubDep3 protupdatePopSubDep3( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep3 rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeletePopSubDep3( ICFSecPubAuthorization Authorization,
		ICFBamProtPopSubDep3 rec );
	/**
	 *	Delete the PopSubDep3 instances identified by the key PopSubDep2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 */
	public void protdeletePopSubDep3ByPopSubDep2Idx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argPopSubDep2Id );

	/**
	 *	Delete the PopSubDep3 instances identified by the key PopSubDep2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByPopSubDep2Idx( ICFSecPubAuthorization Authorization,
		ICFBamProtPopSubDep3ByPopSubDep2IdxKey argKey );
	/**
	 *	Delete the PopSubDep3 instances identified by the key PopSubDep2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByPopSubDep2Idx( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep3ByPopSubDep2IdxKey argKey );
	/**
	 *	Delete the PopSubDep3 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep3 key attribute of the instance generating the id.
	 */
	public void protdeletePopSubDep3ByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argPopSubDep2Id,
		String argName );

	/**
	 *	Delete the PopSubDep3 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtPopSubDep3ByUNameIdxKey argKey );
	/**
	 *	Delete the PopSubDep3 instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByUNameIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep3ByUNameIdxKey argKey );
	/**
	 *	Delete the PopSubDep3 instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The PopSubDep3 key attribute of the instance generating the id.
	 */
	public void protdeletePopSubDep3ByRelationIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argRelationId );

	/**
	 *	Delete the PopSubDep3 instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByRelationIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtPopDepByRelationIdxKey argKey );
	/**
	 *	Delete the PopSubDep3 instances identified by the key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByRelationIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubPopDepByRelationIdxKey argKey );
	/**
	 *	Delete the PopSubDep3 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The PopSubDep3 key attribute of the instance generating the id.
	 */
	public void protdeletePopSubDep3ByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the PopSubDep3 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtPopDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the PopSubDep3 instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubPopDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the PopSubDep3 instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeletePopSubDep3ByIdIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 argKey );
	/**
	 *	Delete the PopSubDep3 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The PopSubDep3 key attribute of the instance generating the id.
	 */
	public void protdeletePopSubDep3ByTenantIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 argTenantId );

	/**
	 *	Delete the PopSubDep3 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByTenantIdx( ICFSecPubAuthorization Authorization,
		ICFBamProtScopeByTenantIdxKey argKey );
	/**
	 *	Delete the PopSubDep3 instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeletePopSubDep3ByTenantIdx( ICFSecPubAuthorization Authorization,
		ICFBamPubScopeByTenantIdxKey argKey );

	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeletePopSubDep3( ICFSecPubAuthorization Authorization,
		ICFBamPubPopSubDep3 rec );


	/**
	 *	Read the derived PopSubDep3 record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep3 instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtPopSubDep3 protreadDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived PopSubDep3 record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep3 instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtPopSubDep3 protlockDerived( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all PopSubDep3 instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ICFBamProtPopSubDep3[] protreadProtAllDerived( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the derived PopSubDep3 record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtPopSubDep3 protreadDerivedByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read an array of the derived PopSubDep3 record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtPopSubDep3[] protreadDerivedByTenantIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 TenantId );

	/**
	 *	Read an array of the derived PopSubDep3 record instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtPopSubDep3[] protreadDerivedByRelationIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 RelationId );

	/**
	 *	Read an array of the derived PopSubDep3 record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtPopSubDep3[] protreadDerivedByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the derived PopSubDep3 record instances identified by the duplicate key PopSubDep2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ICFBamProtPopSubDep3[] protreadDerivedByPopSubDep2Idx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PopSubDep2Id );

	/**
	 *	Read the derived PopSubDep3 record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ICFBamProtPopSubDep3 protreadDerivedByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PopSubDep2Id,
		String Name );

	/**
	 *	Read the specific PopSubDep3 record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep3 instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep3 protreadRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific PopSubDep3 record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the PopSubDep3 instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep3 protlockRec( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific PopSubDep3 record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific PopSubDep3 instances in the database accessible for the Authorization.
	 */
	public ICFBamProtPopSubDep3[] protreadAllRec( ICFSecPubAuthorization Authorization );

	/**
	 *	Read the specific PopSubDep3 record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep3 protreadRecByIdIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 Id );

	/**
	 *	Read an array of the specific PopSubDep3 record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep3[] protreadRecByTenantIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 TenantId );

	/**
	 *	Read an array of the specific PopSubDep3 record instances identified by the duplicate key RelationIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep3[] protreadRecByRelationIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 RelationId );

	/**
	 *	Read an array of the specific PopSubDep3 record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep3[] protreadRecByDefSchemaIdx( ICFSecPubAuthorization Authorization,
		MCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the specific PopSubDep3 record instances identified by the duplicate key PopSubDep2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep3[] protreadRecByPopSubDep2Idx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PopSubDep2Id );

	/**
	 *	Read the specific PopSubDep3 record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PopSubDep2Id	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	Name	The PopSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep3 protreadRecByUNameIdx( ICFSecPubAuthorization Authorization,
		IMCFKeyHash256 PopSubDep2Id,
		String Name );
}
