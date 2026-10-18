
// Description: Java 25 protlic DbIO interface for SubProject.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnetprot;

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
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

/*
 *	IntNetProtSubProjectTable protlic database interface for SubProject has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IIntNetProtSubProjectTable
extends IIntNetPubSubProjectTable
{
	public static final String TABLE_NAME = "SubProject";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public IIntNetProtSubProject protcreateSubProject( ISecurePubAuthorization Authorization,
		IIntNetProtSubProject rec );

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public IIntNetProtSubProject protcreateSubProject( ISecurePubAuthorization Authorization,
		IIntNetPubSubProject rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public IIntNetProtSubProject protupdateSubProject( ISecurePubAuthorization Authorization,
		IIntNetProtSubProject rec );

	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public IIntNetProtSubProject protupdateSubProject( ISecurePubAuthorization Authorization,
		IIntNetPubSubProject rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteSubProject( ISecurePubAuthorization Authorization,
		IIntNetProtSubProject rec );
	/**
	 *	Delete the SubProject instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteSubProjectByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argKey );
	/**
	 *	Delete the SubProject instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The SubProject key attribute of the instance generating the id.
	 */
	public void protdeleteSubProjectByTenantIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argTenantId );

	/**
	 *	Delete the SubProject instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSubProjectByTenantIdx( ISecurePubAuthorization Authorization,
		IIntNetProtSubProjectByTenantIdxKey argKey );
	/**
	 *	Delete the SubProject instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSubProjectByTenantIdx( ISecurePubAuthorization Authorization,
		IIntNetPubSubProjectByTenantIdxKey argKey );
	/**
	 *	Delete the SubProject instances identified by the key TopProjectIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 */
	public void protdeleteSubProjectByTopProjectIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argTopProjectId );

	/**
	 *	Delete the SubProject instances identified by the key TopProjectIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSubProjectByTopProjectIdx( ISecurePubAuthorization Authorization,
		IIntNetProtSubProjectByTopProjectIdxKey argKey );
	/**
	 *	Delete the SubProject instances identified by the key TopProjectIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSubProjectByTopProjectIdx( ISecurePubAuthorization Authorization,
		IIntNetPubSubProjectByTopProjectIdxKey argKey );
	/**
	 *	Delete the SubProject instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SubProject key attribute of the instance generating the id.
	 */
	public void protdeleteSubProjectByNameIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argTopProjectId,
		String argName );

	/**
	 *	Delete the SubProject instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSubProjectByNameIdx( ISecurePubAuthorization Authorization,
		IIntNetProtSubProjectByNameIdxKey argKey );
	/**
	 *	Delete the SubProject instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSubProjectByNameIdx( ISecurePubAuthorization Authorization,
		IIntNetPubSubProjectByNameIdxKey argKey );

	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteSubProject( ISecurePubAuthorization Authorization,
		IIntNetPubSubProject rec );


	/**
	 *	Read the derived SubProject record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SubProject instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IIntNetProtSubProject protreadDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived SubProject record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SubProject instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IIntNetProtSubProject protlockDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all SubProject instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public IIntNetProtSubProject[] protreadProtAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived SubProject record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IIntNetProtSubProject protreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 Id );

	/**
	 *	Read an array of the derived SubProject record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IIntNetProtSubProject[] protreadDerivedByTenantIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 TenantId );

	/**
	 *	Read an array of the derived SubProject record instances identified by the duplicate key TopProjectIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IIntNetProtSubProject[] protreadDerivedByTopProjectIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 TopProjectId );

	/**
	 *	Read the derived SubProject record instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IIntNetProtSubProject protreadDerivedByNameIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 TopProjectId,
		String Name );

	/**
	 *	Read the specific SubProject record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SubProject instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtSubProject protreadRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific SubProject record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SubProject instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtSubProject protlockRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific SubProject record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SubProject instances in the database accessible for the Authorization.
	 */
	public IIntNetProtSubProject[] protreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read the specific SubProject record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtSubProject protreadRecByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 Id );

	/**
	 *	Read an array of the specific SubProject record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtSubProject[] protreadRecByTenantIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 TenantId );

	/**
	 *	Read an array of the specific SubProject record instances identified by the duplicate key TopProjectIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtSubProject[] protreadRecByTopProjectIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 TopProjectId );

	/**
	 *	Read the specific SubProject record instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TopProjectId	The SubProject key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SubProject key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtSubProject protreadRecByNameIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 TopProjectId,
		String Name );
}
