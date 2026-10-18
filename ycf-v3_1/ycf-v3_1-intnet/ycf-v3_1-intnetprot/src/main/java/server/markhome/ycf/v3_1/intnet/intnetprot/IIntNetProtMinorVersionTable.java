
// Description: Java 25 protlic DbIO interface for MinorVersion.

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
 *	IntNetProtMinorVersionTable protlic database interface for MinorVersion has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IIntNetProtMinorVersionTable
extends IIntNetPubMinorVersionTable
{
	public static final String TABLE_NAME = "MinorVersion";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public IIntNetProtMinorVersion protcreateMinorVersion( ISecurePubAuthorization Authorization,
		IIntNetProtMinorVersion rec );

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public IIntNetProtMinorVersion protcreateMinorVersion( ISecurePubAuthorization Authorization,
		IIntNetPubMinorVersion rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public IIntNetProtMinorVersion protupdateMinorVersion( ISecurePubAuthorization Authorization,
		IIntNetProtMinorVersion rec );

	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public IIntNetProtMinorVersion protupdateMinorVersion( ISecurePubAuthorization Authorization,
		IIntNetPubMinorVersion rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteMinorVersion( ISecurePubAuthorization Authorization,
		IIntNetProtMinorVersion rec );
	/**
	 *	Delete the MinorVersion instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteMinorVersionByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argKey );
	/**
	 *	Delete the MinorVersion instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The MinorVersion key attribute of the instance generating the id.
	 */
	public void protdeleteMinorVersionByTenantIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argTenantId );

	/**
	 *	Delete the MinorVersion instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteMinorVersionByTenantIdx( ISecurePubAuthorization Authorization,
		IIntNetProtMinorVersionByTenantIdxKey argKey );
	/**
	 *	Delete the MinorVersion instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteMinorVersionByTenantIdx( ISecurePubAuthorization Authorization,
		IIntNetPubMinorVersionByTenantIdxKey argKey );
	/**
	 *	Delete the MinorVersion instances identified by the key MajorVerIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 */
	public void protdeleteMinorVersionByMajorVerIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argMajorVersionId );

	/**
	 *	Delete the MinorVersion instances identified by the key MajorVerIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteMinorVersionByMajorVerIdx( ISecurePubAuthorization Authorization,
		IIntNetProtMinorVersionByMajorVerIdxKey argKey );
	/**
	 *	Delete the MinorVersion instances identified by the key MajorVerIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteMinorVersionByMajorVerIdx( ISecurePubAuthorization Authorization,
		IIntNetPubMinorVersionByMajorVerIdxKey argKey );
	/**
	 *	Delete the MinorVersion instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MinorVersion key attribute of the instance generating the id.
	 */
	public void protdeleteMinorVersionByNameIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argMajorVersionId,
		String argName );

	/**
	 *	Delete the MinorVersion instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteMinorVersionByNameIdx( ISecurePubAuthorization Authorization,
		IIntNetProtMinorVersionByNameIdxKey argKey );
	/**
	 *	Delete the MinorVersion instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteMinorVersionByNameIdx( ISecurePubAuthorization Authorization,
		IIntNetPubMinorVersionByNameIdxKey argKey );

	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteMinorVersion( ISecurePubAuthorization Authorization,
		IIntNetPubMinorVersion rec );


	/**
	 *	Read the derived MinorVersion record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MinorVersion instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IIntNetProtMinorVersion protreadDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived MinorVersion record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MinorVersion instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public IIntNetProtMinorVersion protlockDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all MinorVersion instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public IIntNetProtMinorVersion[] protreadProtAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived MinorVersion record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IIntNetProtMinorVersion protreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 Id );

	/**
	 *	Read an array of the derived MinorVersion record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IIntNetProtMinorVersion[] protreadDerivedByTenantIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 TenantId );

	/**
	 *	Read an array of the derived MinorVersion record instances identified by the duplicate key MajorVerIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public IIntNetProtMinorVersion[] protreadDerivedByMajorVerIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 MajorVersionId );

	/**
	 *	Read the derived MinorVersion record instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public IIntNetProtMinorVersion protreadDerivedByNameIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 MajorVersionId,
		String Name );

	/**
	 *	Read the specific MinorVersion record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MinorVersion instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtMinorVersion protreadRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific MinorVersion record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the MinorVersion instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtMinorVersion protlockRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific MinorVersion record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific MinorVersion instances in the database accessible for the Authorization.
	 */
	public IIntNetProtMinorVersion[] protreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read the specific MinorVersion record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtMinorVersion protreadRecByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 Id );

	/**
	 *	Read an array of the specific MinorVersion record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtMinorVersion[] protreadRecByTenantIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 TenantId );

	/**
	 *	Read an array of the specific MinorVersion record instances identified by the duplicate key MajorVerIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtMinorVersion[] protreadRecByMajorVerIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 MajorVersionId );

	/**
	 *	Read the specific MinorVersion record instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	MajorVersionId	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@param	Name	The MinorVersion key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetProtMinorVersion protreadRecByNameIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 MajorVersionId,
		String Name );
}
