
// Description: Java 25 protlic DbIO interface for SecUserEMConf.

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
 *	SecureProtSecUserEMConfTable protlic database interface for SecUserEMConf has CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ISecureProtSecUserEMConfTable
{
	public static final String TABLE_NAME = "SecUserEMConf";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ISecureProtSecUserEMConf protcreateSecUserEMConf( ISecurePubAuthorization Authorization,
		ISecureProtSecUserEMConf rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ISecureProtSecUserEMConf protupdateSecUserEMConf( ISecurePubAuthorization Authorization,
		ISecureProtSecUserEMConf rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void protdeleteSecUserEMConf( ISecurePubAuthorization Authorization,
		ISecureProtSecUserEMConf rec );
	/**
	 *	Delete the SecUserEMConf instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void protdeleteSecUserEMConfByIdIdx( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 argKey );
	/**
	 *	Delete the SecUserEMConf instances identified by the key UUuid6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMConfirmationUuid6	The SecUserEMConf key attribute of the instance generating the id.
	 */
	public void protdeleteSecUserEMConfByUUuid6Idx( ISecurePubAuthorization Authorization,
		IYCFUuid6 argEMConfirmationUuid6 );

	/**
	 *	Delete the SecUserEMConf instances identified by the key UUuid6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecUserEMConfByUUuid6Idx( ISecurePubAuthorization Authorization,
		ISecureProtSecUserEMConfByUUuid6IdxKey argKey );
	/**
	 *	Delete the SecUserEMConf instances identified by the key ConfEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ConfirmEMailAddr	The SecUserEMConf key attribute of the instance generating the id.
	 */
	public void protdeleteSecUserEMConfByConfEMAddrIdx( ISecurePubAuthorization Authorization,
		String argConfirmEMailAddr );

	/**
	 *	Delete the SecUserEMConf instances identified by the key ConfEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecUserEMConfByConfEMAddrIdx( ISecurePubAuthorization Authorization,
		ISecureProtSecUserEMConfByConfEMAddrIdxKey argKey );
	/**
	 *	Delete the SecUserEMConf instances identified by the key SentStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailSentStamp	The SecUserEMConf key attribute of the instance generating the id.
	 */
	public void protdeleteSecUserEMConfBySentStampIdx( ISecurePubAuthorization Authorization,
		LocalDateTime argEMailSentStamp );

	/**
	 *	Delete the SecUserEMConf instances identified by the key SentStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecUserEMConfBySentStampIdx( ISecurePubAuthorization Authorization,
		ISecureProtSecUserEMConfBySentStampIdxKey argKey );
	/**
	 *	Delete the SecUserEMConf instances identified by the key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserEMConf key attribute of the instance generating the id.
	 */
	public void protdeleteSecUserEMConfByNewAcctIdx( ISecurePubAuthorization Authorization,
		boolean argNewAccount );

	/**
	 *	Delete the SecUserEMConf instances identified by the key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void protdeleteSecUserEMConfByNewAcctIdx( ISecurePubAuthorization Authorization,
		ISecureProtSecUserEMConfByNewAcctIdxKey argKey );


	/**
	 *	Read the derived SecUserEMConf record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserEMConf instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecUserEMConf protreadDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecUserEMConf record instance by protected primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserEMConf instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecUserEMConf protlockDerived( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all SecUserEMConf instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ISecureProtSecUserEMConf[] protreadProtAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived SecUserEMConf record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecUserEMConf protreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecUserId );

	/**
	 *	Read the derived SecUserEMConf record instance identified by the unique key UUuid6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMConfirmationUuid6	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecureProtSecUserEMConf protreadDerivedByUUuid6Idx( ISecurePubAuthorization Authorization,
		IYCFUuid6 EMConfirmationUuid6 );

	/**
	 *	Read an array of the derived SecUserEMConf record instances identified by the duplicate key ConfEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ConfirmEMailAddr	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecureProtSecUserEMConf[] protreadDerivedByConfEMAddrIdx( ISecurePubAuthorization Authorization,
		String ConfirmEMailAddr );

	/**
	 *	Read an array of the derived SecUserEMConf record instances identified by the duplicate key SentStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailSentStamp	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecureProtSecUserEMConf[] protreadDerivedBySentStampIdx( ISecurePubAuthorization Authorization,
		LocalDateTime EMailSentStamp );

	/**
	 *	Read an array of the derived SecUserEMConf record instances identified by the duplicate key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecureProtSecUserEMConf[] protreadDerivedByNewAcctIdx( ISecurePubAuthorization Authorization,
		boolean NewAccount );

	/**
	 *	Read the specific SecUserEMConf record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserEMConf instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf protreadRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecUserEMConf record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserEMConf instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf protlockRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecUserEMConf record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUserEMConf instances in the database accessible for the Authorization.
	 */
	public ISecureProtSecUserEMConf[] protreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecUserEMConf record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUserEMConf instances in the database accessible for the Authorization.
	 */
	public ISecureProtSecUserEMConf[] protpageAllRec( ISecurePubAuthorization Authorization,
		YCFDbKeyHash256 priorSecUserId );

	/**
	 *	Read the specific SecUserEMConf record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf protreadRecByIdIdx( ISecurePubAuthorization Authorization,
		IYCFKeyHash256 SecUserId );

	/**
	 *	Read the specific SecUserEMConf record instance identified by the unique key UUuid6Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMConfirmationUuid6	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf protreadRecByUUuid6Idx( ISecurePubAuthorization Authorization,
		IYCFUuid6 EMConfirmationUuid6 );

	/**
	 *	Read an array of the specific SecUserEMConf record instances identified by the duplicate key ConfEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ConfirmEMailAddr	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf[] protreadRecByConfEMAddrIdx( ISecurePubAuthorization Authorization,
		String ConfirmEMailAddr );

	/**
	 *	Read an array of the specific SecUserEMConf record instances identified by the duplicate key SentStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailSentStamp	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf[] protreadRecBySentStampIdx( ISecurePubAuthorization Authorization,
		LocalDateTime EMailSentStamp );

	/**
	 *	Read an array of the specific SecUserEMConf record instances identified by the duplicate key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf[] protreadRecByNewAcctIdx( ISecurePubAuthorization Authorization,
		boolean NewAccount );

	/**
	 *	Read a page array of the specific SecUserEMConf record instances identified by the duplicate key ConfEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ConfirmEMailAddr	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf[] protpageRecByConfEMAddrIdx( ISecurePubAuthorization Authorization,
		String ConfirmEMailAddr,
		IYCFKeyHash256 priorSecUserId );

	/**
	 *	Read a page array of the specific SecUserEMConf record instances identified by the duplicate key SentStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailSentStamp	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf[] protpageRecBySentStampIdx( ISecurePubAuthorization Authorization,
		LocalDateTime EMailSentStamp,
		IYCFKeyHash256 priorSecUserId );

	/**
	 *	Read a page array of the specific SecUserEMConf record instances identified by the duplicate key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureProtSecUserEMConf[] protpageRecByNewAcctIdx( ISecurePubAuthorization Authorization,
		boolean NewAccount,
		IYCFKeyHash256 priorSecUserId );
}
