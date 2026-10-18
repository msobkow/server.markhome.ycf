
// Description: Java 25 protlic DbIO interface for Cluster.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.secureprot;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	SecureProtClusterTable protlic database interface for Cluster has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecureProtClusterTable
extends ISecurePubClusterTable
{
	public static final String TABLE_NAME = "Cluster";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ISecureProtCluster protcreateCluster( ISecurePubAuthorization Authorization,
		ISecureProtCluster rec );

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ISecureProtCluster protcreateCluster( ISecurePubAuthorization Authorization,
		ISecurePubCluster rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ISecureProtCluster protupdateCluster( ISecurePubAuthorization Authorization,
		ISecureProtCluster rec );

	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ISecureProtCluster protupdateCluster( ISecurePubAuthorization Authorization,
		ISecurePubCluster rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteCluster( ISecurePubAuthorization Authorization,
		ISecureProtCluster rec );
	/**
	 *	Delete the Cluster instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteClusterByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argKey );
	/**
	 *	Delete the Cluster instances identified by the key UDomNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	FullDomName	The Cluster key attribute of the instance generating the id.
	 */
	public void protdeleteClusterByUDomNameIdx( ISecurePubAuthorization Authorization,
		String argFullDomName );

	/**
	 *	Delete the Cluster instances identified by the key UDomNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteClusterByUDomNameIdx( ISecurePubAuthorization Authorization,
		ISecureProtClusterByUDomNameIdxKey argKey );
	/**
	 *	Delete the Cluster instances identified by the key UDomNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteClusterByUDomNameIdx( ISecurePubAuthorization Authorization,
		ISecurePubClusterByUDomNameIdxKey argKey );
	/**
	 *	Delete the Cluster instances identified by the key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Description	The Cluster key attribute of the instance generating the id.
	 */
	public void protdeleteClusterByUDescrIdx( ISecurePubAuthorization Authorization,
		String argDescription );

	/**
	 *	Delete the Cluster instances identified by the key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteClusterByUDescrIdx( ISecurePubAuthorization Authorization,
		ISecureProtClusterByUDescrIdxKey argKey );
	/**
	 *	Delete the Cluster instances identified by the key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteClusterByUDescrIdx( ISecurePubAuthorization Authorization,
		ISecurePubClusterByUDescrIdxKey argKey );

	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteCluster( ISecurePubAuthorization Authorization,
		ISecurePubCluster rec );


	/**
	 *	Read the derived Cluster record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Cluster instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtCluster protreadDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived Cluster record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Cluster instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtCluster protlockDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all Cluster instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ISecureProtCluster[] protreadProtAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived Cluster record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtCluster protreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 Id );

	/**
	 *	Read the derived Cluster record instance identified by the unique key UDomNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	FullDomName	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtCluster protreadDerivedByUDomNameIdx( ISecurePubAuthorization Authorization,
		String FullDomName );

	/**
	 *	Read the derived Cluster record instance identified by the unique key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Description	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtCluster protreadDerivedByUDescrIdx( ISecurePubAuthorization Authorization,
		String Description );

	/**
	 *	Read the specific Cluster record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Cluster instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtCluster protreadRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific Cluster record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Cluster instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtCluster protlockRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific Cluster record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Cluster instances in the database accessible for the Authorization.
	 */
	public ISecureProtCluster[] protreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read a page of all the specific Cluster record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Cluster instances in the database accessible for the Authorization.
	 */
	public ISecureProtCluster[] protpageAllRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 priorId );

	/**
	 *	Read the specific Cluster record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtCluster protreadRecByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 Id );

	/**
	 *	Read the specific Cluster record instance identified by the unique key UDomNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	FullDomName	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtCluster protreadRecByUDomNameIdx( ISecurePubAuthorization Authorization,
		String FullDomName );

	/**
	 *	Read the specific Cluster record instance identified by the unique key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Description	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtCluster protreadRecByUDescrIdx( ISecurePubAuthorization Authorization,
		String Description );
}
