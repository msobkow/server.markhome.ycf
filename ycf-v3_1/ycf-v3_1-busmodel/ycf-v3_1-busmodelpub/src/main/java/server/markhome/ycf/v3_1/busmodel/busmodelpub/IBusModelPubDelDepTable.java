
// Description: Java 25 public DbIO interface for DelDep.

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
 *	BusModelPubDelDepTable public database interface for DelDep has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelPubDelDepTable
{
	public static final String TABLE_NAME = "DelDep";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public IBusModelPubDelDep pubcreateDelDep( ISecurePubAuthorization Authorization,
		IBusModelPubDelDep rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public IBusModelPubDelDep pubupdateDelDep( ISecurePubAuthorization Authorization,
		IBusModelPubDelDep rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void pubdeleteDelDep( ISecurePubAuthorization Authorization,
		IBusModelPubDelDep rec );
	/**
	 *	Delete the DelDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DelDep key attribute of the instance generating the id.
	 */
	public void pubdeleteDelDepByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the DelDep instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDelDepByDefSchemaIdx( ISecurePubAuthorization Authorization,
		IBusModelPubDelDepByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DelDep instances identified by the key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The DelDep key attribute of the instance generating the id.
	 */
	public void pubdeleteDelDepByDelDepIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argRelationId );

	/**
	 *	Delete the DelDep instances identified by the key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDelDepByDelDepIdx( ISecurePubAuthorization Authorization,
		IBusModelPubDelDepByDelDepIdxKey argKey );
	/**
	 *	Delete the DelDep instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void pubdeleteDelDepByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argKey );
	/**
	 *	Delete the DelDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The DelDep key attribute of the instance generating the id.
	 */
	public void pubdeleteDelDepByTenantIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argTenantId );

	/**
	 *	Delete the DelDep instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDelDepByTenantIdx( ISecurePubAuthorization Authorization,
		IBusModelPubScopeByTenantIdxKey argKey );


	/**
	 *	Read the derived DelDep record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubDelDep pubreadDerived( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Lock the derived DelDep record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubDelDep publockDerived( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Read all DelDep instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public IBusModelPubDelDep[] pubreadPubAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived DelDep record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubDelDep pubreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 Id );

	/**
	 *	Read an array of the derived DelDep record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubDelDep[] pubreadDerivedByTenantIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TenantId );

	/**
	 *	Read an array of the derived DelDep record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubDelDep[] pubreadDerivedByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the derived DelDep record instances identified by the duplicate key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubDelDep[] pubreadDerivedByDelDepIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 RelationId );

	/**
	 *	Read the specific DelDep record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelDep pubreadRec( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Lock the specific DelDep record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DelDep instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelDep publockRec( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Read all the specific DelDep record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DelDep instances in the database accessible for the Authorization.
	 */
	public IBusModelPubDelDep[] pubreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read the specific DelDep record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelDep pubreadRecByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 Id );

	/**
	 *	Read an array of the specific DelDep record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelDep[] pubreadRecByTenantIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 TenantId );

	/**
	 *	Read an array of the specific DelDep record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelDep[] pubreadRecByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the specific DelDep record instances identified by the duplicate key DelDepIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	RelationId	The DelDep key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelDep[] pubreadRecByDelDepIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 RelationId );
}
