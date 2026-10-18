
// Description: Java 25 public DbIO interface for DbKeyHash256Def.

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
 *	BusModelPubDbKeyHash256DefTable public database interface for DbKeyHash256Def has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IBusModelPubDbKeyHash256DefTable
{
	public static final String TABLE_NAME = "DbKeyHash256Def";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public IBusModelPubDbKeyHash256Def pubcreateDbKeyHash256Def( ISecurePubAuthorization Authorization,
		IBusModelPubDbKeyHash256Def rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public IBusModelPubDbKeyHash256Def pubupdateDbKeyHash256Def( ISecurePubAuthorization Authorization,
		IBusModelPubDbKeyHash256Def rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void pubdeleteDbKeyHash256Def( ISecurePubAuthorization Authorization,
		IBusModelPubDbKeyHash256Def rec );
	/**
	 *	Delete the DbKeyHash256Def instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void pubdeleteDbKeyHash256DefByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argKey );
	/**
	 *	Delete the DbKeyHash256Def instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash256Def key attribute of the instance generating the id.
	 */
	public void pubdeleteDbKeyHash256DefByUNameIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argScopeId,
		String argName );

	/**
	 *	Delete the DbKeyHash256Def instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDbKeyHash256DefByUNameIdx( ISecurePubAuthorization Authorization,
		IBusModelPubValueByUNameIdxKey argKey );
	/**
	 *	Delete the DbKeyHash256Def instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 */
	public void pubdeleteDbKeyHash256DefByScopeIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argScopeId );

	/**
	 *	Delete the DbKeyHash256Def instances identified by the key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDbKeyHash256DefByScopeIdx( ISecurePubAuthorization Authorization,
		IBusModelPubValueByScopeIdxKey argKey );
	/**
	 *	Delete the DbKeyHash256Def instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DbKeyHash256Def key attribute of the instance generating the id.
	 */
	public void pubdeleteDbKeyHash256DefByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argDefSchemaId );

	/**
	 *	Delete the DbKeyHash256Def instances identified by the key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDbKeyHash256DefByDefSchemaIdx( ISecurePubAuthorization Authorization,
		IBusModelPubValueByDefSchemaIdxKey argKey );
	/**
	 *	Delete the DbKeyHash256Def instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The DbKeyHash256Def key attribute of the instance generating the id.
	 */
	public void pubdeleteDbKeyHash256DefByPrevIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argPrevId );

	/**
	 *	Delete the DbKeyHash256Def instances identified by the key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDbKeyHash256DefByPrevIdx( ISecurePubAuthorization Authorization,
		IBusModelPubValueByPrevIdxKey argKey );
	/**
	 *	Delete the DbKeyHash256Def instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The DbKeyHash256Def key attribute of the instance generating the id.
	 */
	public void pubdeleteDbKeyHash256DefByNextIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argNextId );

	/**
	 *	Delete the DbKeyHash256Def instances identified by the key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDbKeyHash256DefByNextIdx( ISecurePubAuthorization Authorization,
		IBusModelPubValueByNextIdxKey argKey );
	/**
	 *	Delete the DbKeyHash256Def instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash256Def key attribute of the instance generating the id.
	 */
	public void pubdeleteDbKeyHash256DefByContPrevIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argScopeId,
		YCFDbKeyHash256 argPrevId );

	/**
	 *	Delete the DbKeyHash256Def instances identified by the key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDbKeyHash256DefByContPrevIdx( ISecurePubAuthorization Authorization,
		IBusModelPubValueByContPrevIdxKey argKey );
	/**
	 *	Delete the DbKeyHash256Def instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash256Def key attribute of the instance generating the id.
	 */
	public void pubdeleteDbKeyHash256DefByContNextIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argScopeId,
		YCFDbKeyHash256 argNextId );

	/**
	 *	Delete the DbKeyHash256Def instances identified by the key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteDbKeyHash256DefByContNextIdx( ISecurePubAuthorization Authorization,
		IBusModelPubValueByContNextIdxKey argKey );


	/**
	 *	Read the derived DbKeyHash256Def record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash256Def instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubDbKeyHash256Def pubreadDerived( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Lock the derived DbKeyHash256Def record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash256Def instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubDbKeyHash256Def publockDerived( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Read all DbKeyHash256Def instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadPubAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived DbKeyHash256Def record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubDbKeyHash256Def pubreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 Id );

	/**
	 *	Read the derived DbKeyHash256Def record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IBusModelPubDbKeyHash256Def pubreadDerivedByUNameIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the derived DbKeyHash256Def record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadDerivedByScopeIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId );

	/**
	 *	Read an array of the derived DbKeyHash256Def record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadDerivedByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the derived DbKeyHash256Def record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadDerivedByPrevIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the derived DbKeyHash256Def record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadDerivedByNextIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the derived DbKeyHash256Def record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadDerivedByContPrevIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the derived DbKeyHash256Def record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadDerivedByContNextIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Read the specific DbKeyHash256Def record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash256Def instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def pubreadRec( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Lock the specific DbKeyHash256Def record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the DbKeyHash256Def instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def publockRec( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 PKey );

	/**
	 *	Read all the specific DbKeyHash256Def record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific DbKeyHash256Def instances in the database accessible for the Authorization.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read the specific DbKeyHash256Def record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def pubreadRecByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 Id );

	/**
	 *	Read the specific DbKeyHash256Def record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@param	Name	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def pubreadRecByUNameIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		String Name );

	/**
	 *	Read an array of the specific DbKeyHash256Def record instances identified by the duplicate key ScopeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadRecByScopeIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId );

	/**
	 *	Read an array of the specific DbKeyHash256Def record instances identified by the duplicate key DefSchemaIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DefSchemaId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadRecByDefSchemaIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 DefSchemaId );

	/**
	 *	Read an array of the specific DbKeyHash256Def record instances identified by the duplicate key PrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PrevId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadRecByPrevIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the specific DbKeyHash256Def record instances identified by the duplicate key NextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NextId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadRecByNextIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 NextId );

	/**
	 *	Read an array of the specific DbKeyHash256Def record instances identified by the duplicate key ContPrevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadRecByContPrevIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 PrevId );

	/**
	 *	Read an array of the specific DbKeyHash256Def record instances identified by the duplicate key ContNextIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ScopeId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The DbKeyHash256Def key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256Def[] pubreadRecByContNextIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 ScopeId,
		YCFDbKeyHash256 NextId );

	/**
	 *	Move the specified record up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	public IBusModelPubDbKeyHash256Def pubmoveRecUp( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 Id,
		int revision );

	/**
	 *	Move the specified record down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed record after it has been moved
	 */
	public IBusModelPubDbKeyHash256Def pubmoveRecDown( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision );
}
