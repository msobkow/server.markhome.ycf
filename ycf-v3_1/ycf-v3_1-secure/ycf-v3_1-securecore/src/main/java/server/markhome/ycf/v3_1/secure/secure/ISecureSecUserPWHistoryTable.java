
// Description: Java 25 DbIO interface for SecUserPWHistory.

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

package server.markhome.ycf.v3_1.secure.secure;

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

import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/*
 *	SecureSecUserPWHistoryTable database interface for SecUserPWHistory has CodeVis Private, meaning that only the back-end code for the schema implementation can access it, and even the code specific user interface cannot.
 */
public interface ISecureSecUserPWHistoryTable
{
	public static final String TABLE_NAME = "SecUserPWHistory";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ISecureSecUserPWHistory createSecUserPWHistory( ISecureAuthorization Authorization,
		ISecureSecUserPWHistory rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ISecureSecUserPWHistory updateSecUserPWHistory( ISecureAuthorization Authorization,
		ISecureSecUserPWHistory rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecUserPWHistory( ISecureAuthorization Authorization,
		ISecureSecUserPWHistory rec );
	/**
	 *	Delete the SecUserPWHistory instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 */
	void deleteSecUserPWHistoryByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecUserId,
		LocalDateTime argPWSetStamp );
	/**
	 *	Delete the SecUserPWHistory instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecUserPWHistoryByIdIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey argKey );
	/**
	 *	Delete the SecUserPWHistory instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 */
	void deleteSecUserPWHistoryByUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecUserId );

	/**
	 *	Delete the SecUserPWHistory instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecUserPWHistoryByUserIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryByUserIdxKey argKey );
	/**
	 *	Delete the SecUserPWHistory instances identified by the key SetStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 */
	void deleteSecUserPWHistoryBySetStampIdx( ISecureAuthorization Authorization,
		LocalDateTime argPWSetStamp );

	/**
	 *	Delete the SecUserPWHistory instances identified by the key SetStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecUserPWHistoryBySetStampIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryBySetStampIdxKey argKey );
	/**
	 *	Delete the SecUserPWHistory instances identified by the key ReplacedStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PWReplacedStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 */
	void deleteSecUserPWHistoryByReplacedStampIdx( ISecureAuthorization Authorization,
		LocalDateTime argPWReplacedStamp );

	/**
	 *	Delete the SecUserPWHistory instances identified by the key ReplacedStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecUserPWHistoryByReplacedStampIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryByReplacedStampIdxKey argKey );


	/**
	 *	Read the derived SecUserPWHistory record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserPWHistory instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecUserPWHistory readDerived( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey PKey );

	/**
	 *	Read the derived SecUserPWHistory record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecUserPWHistory readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp );

	/**
	 *	Lock the derived SecUserPWHistory record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserPWHistory instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecUserPWHistory lockDerived( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey PKey );

	/**
	 *	Read all SecUserPWHistory instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ISecureSecUserPWHistory[] readAllDerived( ISecureAuthorization Authorization );

	/**
	 *	Read the derived SecUserPWHistory record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecUserPWHistory readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp );

	/**
	 *	Read the derived SecUserPWHistory record instance identified by the unique key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecUserPWHistory readDerivedByUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId );

	/**
	 *	Read the derived SecUserPWHistory record instance identified by the unique key SetStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecUserPWHistory readDerivedBySetStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWSetStamp );

	/**
	 *	Read the derived SecUserPWHistory record instance identified by the unique key ReplacedStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PWReplacedStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ISecureSecUserPWHistory readDerivedByReplacedStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWReplacedStamp );

	/**
	 *	Read the specific SecUserPWHistory record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserPWHistory instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecUserPWHistory readRec( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey PKey );

	/**
	 *	Read the specific SecUserPWHistory record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserPWHistory instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecUserPWHistory readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp );

	/**
	 *	Lock the specific SecUserPWHistory record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUserPWHistory instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecUserPWHistory lockRec( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey PKey );

	/**
	 *	Read all the specific SecUserPWHistory record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUserPWHistory instances in the database accessible for the Authorization.
	 */
	ISecureSecUserPWHistory[] readAllRec( ISecureAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecUserPWHistory record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUserPWHistory instances in the database accessible for the Authorization.
	 */
	ISecureSecUserPWHistory[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecUserId,
		LocalDateTime priorPWSetStamp );

	/**
	 *	Read the specific SecUserPWHistory record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecUserPWHistory readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp );

	/**
	 *	Read the specific SecUserPWHistory record instance identified by the unique key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecUserPWHistory readRecByUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId );

	/**
	 *	Read the specific SecUserPWHistory record instance identified by the unique key SetStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecUserPWHistory readRecBySetStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWSetStamp );

	/**
	 *	Read the specific SecUserPWHistory record instance identified by the unique key ReplacedStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PWReplacedStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	ISecureSecUserPWHistory readRecByReplacedStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWReplacedStamp );
}
