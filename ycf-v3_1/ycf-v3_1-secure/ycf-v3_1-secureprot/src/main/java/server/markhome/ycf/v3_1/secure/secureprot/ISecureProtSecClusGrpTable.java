
// Description: Java 25 protlic DbIO interface for SecClusGrp.

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
 *	SecureProtSecClusGrpTable protlic database interface for SecClusGrp has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ISecureProtSecClusGrpTable
{
	public static final String TABLE_NAME = "SecClusGrp";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ISecureProtSecClusGrp protcreateSecClusGrp( ISecurePubAuthorization Authorization,
		ISecureProtSecClusGrp rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ISecureProtSecClusGrp protupdateSecClusGrp( ISecurePubAuthorization Authorization,
		ISecureProtSecClusGrp rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteSecClusGrp( ISecurePubAuthorization Authorization,
		ISecureProtSecClusGrp rec );
	/**
	 *	Delete the SecClusGrp instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteSecClusGrpByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argKey );
	/**
	 *	Delete the SecClusGrp instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusGrp key attribute of the instance generating the id.
	 */
	public void protdeleteSecClusGrpByClusterIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argClusterId );

	/**
	 *	Delete the SecClusGrp instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecClusGrpByClusterIdx( ISecurePubAuthorization Authorization,
		ISecureProtSecClusGrpByClusterIdxKey argKey );
	/**
	 *	Delete the SecClusGrp instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The SecClusGrp key attribute of the instance generating the id.
	 */
	public void protdeleteSecClusGrpByNameIdx( ISecurePubAuthorization Authorization,
		String argName );

	/**
	 *	Delete the SecClusGrp instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecClusGrpByNameIdx( ISecurePubAuthorization Authorization,
		ISecureProtSecClusGrpByNameIdxKey argKey );
	/**
	 *	Delete the SecClusGrp instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecClusGrp key attribute of the instance generating the id.
	 */
	public void protdeleteSecClusGrpByUNameIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 argClusterId,
		String argName );

	/**
	 *	Delete the SecClusGrp instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecClusGrpByUNameIdx( ISecurePubAuthorization Authorization,
		ISecureProtSecClusGrpByUNameIdxKey argKey );


	/**
	 *	Read the derived SecClusGrp record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrp instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecClusGrp protreadDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecClusGrp record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrp instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecClusGrp protlockDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all SecClusGrp instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ISecureProtSecClusGrp[] protreadProtAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived SecClusGrp record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecClusGrp protreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecClusGrpId );

	/**
	 *	Read an array of the derived SecClusGrp record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecureProtSecClusGrp[] protreadDerivedByClusterIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 ClusterId );

	/**
	 *	Read an array of the derived SecClusGrp record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecureProtSecClusGrp[] protreadDerivedByNameIdx( ISecurePubAuthorization Authorization,
		String Name );

	/**
	 *	Read the derived SecClusGrp record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecClusGrp protreadDerivedByUNameIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 ClusterId,
		String Name );

	/**
	 *	Read the specific SecClusGrp record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrp instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusGrp protreadRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecClusGrp record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrp instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusGrp protlockRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecClusGrp record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecClusGrp instances in the database accessible for the Authorization.
	 */
	public ISecureProtSecClusGrp[] protreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read the specific SecClusGrp record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusGrp protreadRecByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecClusGrpId );

	/**
	 *	Read an array of the specific SecClusGrp record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusGrp[] protreadRecByClusterIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 ClusterId );

	/**
	 *	Read an array of the specific SecClusGrp record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusGrp[] protreadRecByNameIdx( ISecurePubAuthorization Authorization,
		String Name );

	/**
	 *	Read the specific SecClusGrp record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecClusGrp key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecClusGrp protreadRecByUNameIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 ClusterId,
		String Name );
}
