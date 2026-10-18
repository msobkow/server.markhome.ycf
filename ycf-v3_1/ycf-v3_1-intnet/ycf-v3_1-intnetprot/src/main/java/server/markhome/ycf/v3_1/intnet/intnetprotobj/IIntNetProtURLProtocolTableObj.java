// Description: Java 25 Protected Table Object interface for IntNetProt.

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

package server.markhome.ycf.v3_1.intnet.intnetprotobj;

import java.math.*;
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
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IIntNetProtURLProtocolTableObj
{
	public IIntNetProtSchemaObj getSchema();
	public void setSchema( IIntNetProtSchemaObj value );

	public void minimizeMemory();

	public String getTableName();
	public String getTableDbName();

	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	public int getClassCode();

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	// public static int getBackingClassCode();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new URLProtocol instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetProtURLProtocolObj newInstance();

	/**
	 *	Instantiate a new URLProtocol edition of the specified URLProtocol instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetProtURLProtocolEditObj newEditInstance( IIntNetProtURLProtocolObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetProtURLProtocolEditObj instance, which may be a subclass of a URLProtocol instance.
	 */
	IIntNetProtURLProtocolObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetProtURLProtocolObj realiseURLProtocol( IIntNetProtURLProtocolObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetProtURLProtocolObj createURLProtocol( IIntNetProtURLProtocolObj Obj );

	/**
	 *	Read a URLProtocol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The URLProtocol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtURLProtocolObj readURLProtocol( Integer pkey );

	/**
	 *	Read a URLProtocol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The URLProtocol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtURLProtocolObj readURLProtocol( Integer pkey,
		boolean forceRead );

	IIntNetProtURLProtocolObj readCachedURLProtocol( Integer pkey );

	public void reallyDeepDisposeURLProtocol( IIntNetProtURLProtocolObj obj );

	void deepDisposeURLProtocol( Integer pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetProtURLProtocolObj lockURLProtocol( Integer pkey );

	/**
	 *	Return a sorted list of all the URLProtocol-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtURLProtocolObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtURLProtocolObj> readAllURLProtocol();

	/**
	 *	Return a sorted map of all the URLProtocol-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtURLProtocolObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtURLProtocolObj> readAllURLProtocol( boolean forceRead );

	List<IIntNetProtURLProtocolObj> readCachedAllURLProtocol();

	/**
	 *	Get the IIntNetProtURLProtocolObj instance for the primary key attributes.
	 *
	 *	@param	URLProtocolId	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtURLProtocolObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtURLProtocolObj readURLProtocolByIdIdx( int URLProtocolId );

	/**
	 *	Get the IIntNetProtURLProtocolObj instance for the primary key attributes.
	 *
	 *	@param	URLProtocolId	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtURLProtocolObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtURLProtocolObj readURLProtocolByIdIdx( int URLProtocolId,
		boolean forceRead );

	/**
	 *	Get the IIntNetProtURLProtocolObj instance for the unique UNameIdx key.
	 *
	 *	@param	Name	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtURLProtocolObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtURLProtocolObj readURLProtocolByUNameIdx(String Name );

	/**
	 *	Get the IIntNetProtURLProtocolObj instance for the unique UNameIdx key.
	 *
	 *	@param	Name	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtURLProtocolObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtURLProtocolObj readURLProtocolByUNameIdx(String Name,
		boolean forceRead );

	/**
	 *	Get the map of List<IIntNetProtURLProtocolObj> instances sorted by their primary keys for the duplicate IsSecureIdx key.
	 *
	 *	@param	IsSecure	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtURLProtocolObj> cached instances sorted by their primary keys for the duplicate IsSecureIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure );

	/**
	 *	Get the map of List<IIntNetProtURLProtocolObj> instances sorted by their primary keys for the duplicate IsSecureIdx key.
	 *
	 *	@param	IsSecure	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	List of List<IIntNetProtURLProtocolObj> cached instances sorted by their primary keys for the duplicate IsSecureIdx key,
	 *		which may be an empty set.
	 */
	List<IIntNetProtURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure,
		boolean forceRead );

	IIntNetProtURLProtocolObj readCachedURLProtocolByIdIdx( int URLProtocolId );

	IIntNetProtURLProtocolObj readCachedURLProtocolByUNameIdx( String Name );

	List<List<IIntNetProtURLProtocolObj>> readCachedURLProtocolByIsSecureIdx( boolean IsSecure );

	void deepDisposeURLProtocolByIdIdx( int URLProtocolId );

	void deepDisposeURLProtocolByUNameIdx( String Name );

	void deepDisposeURLProtocolByIsSecureIdx( boolean IsSecure );

	/**
	 *	Internal use only.
	 */
	IIntNetProtURLProtocolObj updateURLProtocol( IIntNetProtURLProtocolObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteURLProtocol( IIntNetProtURLProtocolObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	URLProtocolId	The URLProtocol key attribute of the instance generating the id.
	 */
	void deleteURLProtocolByIdIdx( int URLProtocolId );

	/**
	 *	Internal use only.
	 *
	 *	@param	Name	The URLProtocol key attribute of the instance generating the id.
	 */
	void deleteURLProtocolByUNameIdx(String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	IsSecure	The URLProtocol key attribute of the instance generating the id.
	 */
	void deleteURLProtocolByIsSecureIdx( boolean IsSecure );
}
