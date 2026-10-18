
// Description: Java 25 public DbIO interface for Relation.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
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
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelpub;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;

/*
 *	BusModelPubRelationTable public database interface for Relation has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelPubRelationTable
{
	public static final String TABLE_NAME = "Relation";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public IBusModelPubRelation pubcreateRelation( ISecurePubAuthorization Authorization,
		IBusModelPubRelation rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public IBusModelPubRelation pubupdateRelation( ISecurePubAuthorization Authorization,
		IBusModelPubRelation rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void pubdeleteRelation( ISecurePubAuthorization Authorization,
		IBusModelPubRelation rec );
	/**
	 *	Delete the Relation instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByUNameIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argTableId,
		String argName );

	/**
	 *	Delete the Relation instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByUNameIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRelationByUNameIdxKey argKey );
	/**
	 *	Delete the Relation instances identified by the key RelTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByRelTableIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argTableId );

	/**
	 *	Delete the Relation instances identified by the key RelTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByRelTableIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRelationByRelTableIdxKey argKey );
	/**
	 *	Delete the Relation instances identified by the key RelCodeVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByRelCodeVisIdx( ISecurePubAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis );

	/**
	 *	Delete the Relation instances identified by the key RelCodeVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByRelCodeVisIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRelationByRelCodeVisIdxKey argKey );
	/**
	 *	Delete the Relation instances identified by the key RelTableCodeVisX.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByRelTableCodeVisX( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis );

	/**
	 *	Delete the Relation instances identified by the key RelTableCodeVisX.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByRelTableCodeVisX( ISecurePubAuthorization Authorization,
		IBusModelPubRelationByRelTableCodeVisXKey argKey );
	/**
	 *	Delete the Relation instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the Relation instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByDefSchemaIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRelationByDefSchemaIdxKey argKey );
	/**
	 *	Delete the Relation instances identified by the key FromKeyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	FromIndexId	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByFromKeyIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argFromIndexId );

	/**
	 *	Delete the Relation instances identified by the key FromKeyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByFromKeyIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRelationByFromKeyIdxKey argKey );
	/**
	 *	Delete the Relation instances identified by the key ToTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ToTableId	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByToTblIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argToTableId );

	/**
	 *	Delete the Relation instances identified by the key ToTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByToTblIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRelationByToTblIdxKey argKey );
	/**
	 *	Delete the Relation instances identified by the key ToKeyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ToIndexId	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByToKeyIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argToIndexId );

	/**
	 *	Delete the Relation instances identified by the key ToKeyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByToKeyIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRelationByToKeyIdxKey argKey );
	/**
	 *	Delete the Relation instances identified by the key NarrowedIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NarrowedId	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByNarrowedIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argNarrowedId );

	/**
	 *	Delete the Relation instances identified by the key NarrowedIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByNarrowedIdx( ISecurePubAuthorization Authorization,
		IBusModelPubRelationByNarrowedIdxKey argKey );
	/**
	 *	Delete the Relation instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void pubdeleteRelationByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argKey );
	/**
	 *	Delete the Relation instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The Relation key attribute of the instance generating the id.
	 */
	public void pubdeleteRelationByTenantIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argTenantId );

	/**
	 *	Delete the Relation instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteRelationByTenantIdx( ISecurePubAuthorization Authorization,
		IBusModelPubScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived Relation record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Relation instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubRelation pubreadDerived( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Lock the derived Relation record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Relation instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubRelation publockDerived( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Read all Relation instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadPubAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived Relation record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Relation key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubRelation pubreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 Id );

	/**
	 *	Read an array of the derived Relation record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadDerivedByTenantIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TenantId );

	/**
	 *	Read the derived Relation record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Relation key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubRelation pubreadDerivedByUNameIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Read an array of the derived Relation record instances identified by the duplicate key RelTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadDerivedByRelTableIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TableId );

	/**
	 *	Read an array of the derived Relation record instances identified by the duplicate key RelCodeVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadDerivedByRelCodeVisIdx( ISecurePubAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Read an array of the derived Relation record instances identified by the duplicate key RelTableCodeVisX.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadDerivedByRelTableCodeVisX( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Read an array of the derived Relation record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadDerivedByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the derived Relation record instances identified by the duplicate key FromKeyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	FromIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadDerivedByFromKeyIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 FromIndexId );

	/**
	 *	Read an array of the derived Relation record instances identified by the duplicate key ToTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ToTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadDerivedByToTblIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ToTableId );

	/**
	 *	Read an array of the derived Relation record instances identified by the duplicate key ToKeyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ToIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadDerivedByToKeyIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ToIndexId );

	/**
	 *	Read an array of the derived Relation record instances identified by the duplicate key NarrowedIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NarrowedId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubRelation[] pubreadDerivedByNarrowedIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 NarrowedId );

	/**
	 *	Read the specific Relation record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Relation instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation pubreadRec( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Lock the specific Relation record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Relation instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation publockRec( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Read all the specific Relation record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Relation instances in the database accessible for the Authorization.
	 */
	public IBusModelPubRelation[] pubreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read the specific Relation record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Relation key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation pubreadRecByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 Id );

	/**
	 *	Read an array of the specific Relation record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation[] pubreadRecByTenantIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TenantId );

	/**
	 *	Read the specific Relation record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Relation key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation pubreadRecByUNameIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TableId,
		String Name );

	/**
	 *	Read an array of the specific Relation record instances identified by the duplicate key RelTableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation[] pubreadRecByRelTableIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TableId );

	/**
	 *	Read an array of the specific Relation record instances identified by the duplicate key RelCodeVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation[] pubreadRecByRelCodeVisIdx( ISecurePubAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Read an array of the specific Relation record instances identified by the duplicate key RelTableCodeVisX.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	CodeVis	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation[] pubreadRecByRelTableCodeVisX( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis );

	/**
	 *	Read an array of the specific Relation record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation[] pubreadRecByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the specific Relation record instances identified by the duplicate key FromKeyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	FromIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation[] pubreadRecByFromKeyIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 FromIndexId );

	/**
	 *	Read an array of the specific Relation record instances identified by the duplicate key ToTblIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ToTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation[] pubreadRecByToTblIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ToTableId );

	/**
	 *	Read an array of the specific Relation record instances identified by the duplicate key ToKeyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ToIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation[] pubreadRecByToKeyIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ToIndexId );

	/**
	 *	Read an array of the specific Relation record instances identified by the duplicate key NarrowedIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NarrowedId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelation[] pubreadRecByNarrowedIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 NarrowedId );
}
