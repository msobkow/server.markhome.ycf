
// Description: Java 25 public DbIO interface for ISOLang.

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

package server.markhome.ycf.v3_1.secure.securepub;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;

/*
 *	SecurePubISOLangTable public database interface for ISOLang has CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecurePubISOLangTable
{
	public static final String TABLE_NAME = "ISOLang";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	public ISecurePubISOLang pubcreateISOLang( ISecurePubAuthorization Authorization,
		ISecurePubISOLang rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	public ISecurePubISOLang pubupdateISOLang( ISecurePubAuthorization Authorization,
		ISecurePubISOLang rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	public void pubdeleteISOLang( ISecurePubAuthorization Authorization,
		ISecurePubISOLang rec );
	/**
	 *	Delete the ISOLang instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	public void pubdeleteISOLangByIdIdx( ISecurePubAuthorization Authorization,
		Short argKey );
	/**
	 *	Delete the ISOLang instances identified by the key Code3Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISO6392Code	The ISOLang key attribute of the instance generating the id.
	 */
	public void pubdeleteISOLangByCode3Idx( ISecurePubAuthorization Authorization,
		String argISO6392Code );

	/**
	 *	Delete the ISOLang instances identified by the key Code3Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteISOLangByCode3Idx( ISecurePubAuthorization Authorization,
		ISecurePubISOLangByCode3IdxKey argKey );
	/**
	 *	Delete the ISOLang instances identified by the key Code2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISO6391Code	The ISOLang key attribute of the instance generating the id.
	 */
	public void pubdeleteISOLangByCode2Idx( ISecurePubAuthorization Authorization,
		String argISO6391Code );

	/**
	 *	Delete the ISOLang instances identified by the key Code2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	public void pubdeleteISOLangByCode2Idx( ISecurePubAuthorization Authorization,
		ISecurePubISOLangByCode2IdxKey argKey );


	/**
	 *	Read the derived ISOLang record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOLang instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubISOLang pubreadDerived( ISecurePubAuthorization Authorization,
		Short PKey );

	/**
	 *	Lock the derived ISOLang record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubISOLang publockDerived( ISecurePubAuthorization Authorization,
		Short PKey );

	/**
	 *	Read all ISOLang instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	public ISecurePubISOLang[] pubreadPubAllDerived( ISecurePubAuthorization Authorization );

	/**
	 *	Read the derived ISOLang record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOLangId	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubISOLang pubreadDerivedByIdIdx( ISecurePubAuthorization Authorization,
		short ISOLangId );

	/**
	 *	Read the derived ISOLang record instance identified by the unique key Code3Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISO6392Code	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	public ISecurePubISOLang pubreadDerivedByCode3Idx( ISecurePubAuthorization Authorization,
		String ISO6392Code );

	/**
	 *	Read an array of the derived ISOLang record instances identified by the duplicate key Code2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISO6391Code	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	public ISecurePubISOLang[] pubreadDerivedByCode2Idx( ISecurePubAuthorization Authorization,
		String ISO6391Code );

	/**
	 *	Read the specific ISOLang record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOLang pubreadRec( ISecurePubAuthorization Authorization,
		Short PKey );

	/**
	 *	Lock the specific ISOLang record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOLang publockRec( ISecurePubAuthorization Authorization,
		Short PKey );

	/**
	 *	Read all the specific ISOLang record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ISOLang instances in the database accessible for the Authorization.
	 */
	public ISecurePubISOLang[] pubreadAllRec( ISecurePubAuthorization Authorization );

	/**
	 *	Read the specific ISOLang record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOLangId	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOLang pubreadRecByIdIdx( ISecurePubAuthorization Authorization,
		short ISOLangId );

	/**
	 *	Read the specific ISOLang record instance identified by the unique key Code3Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISO6392Code	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOLang pubreadRecByCode3Idx( ISecurePubAuthorization Authorization,
		String ISO6392Code );

	/**
	 *	Read an array of the specific ISOLang record instances identified by the duplicate key Code2Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISO6391Code	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecurePubISOLang[] pubreadRecByCode2Idx( ISecurePubAuthorization Authorization,
		String ISO6391Code );
}
