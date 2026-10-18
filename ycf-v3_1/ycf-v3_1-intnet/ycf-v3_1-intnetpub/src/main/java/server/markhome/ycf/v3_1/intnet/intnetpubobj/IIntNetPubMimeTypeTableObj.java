// Description: Java 25 Public Table Object interface for IntNetPub.

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

package server.markhome.ycf.v3_1.intnet.intnetpubobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetPubMimeTypeTableObj
{
	public IIntNetPubSchemaObj getSchema();
	public void setSchema( IIntNetPubSchemaObj value );

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
	 *	Instantiate a new MimeType instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetPubMimeTypeObj newInstance();

	/**
	 *	Instantiate a new MimeType edition of the specified MimeType instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetPubMimeTypeEditObj newEditInstance( IIntNetPubMimeTypeObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetPubMimeTypeObj instance, which may be a subclass of a MimeType instance.
	 */
	IIntNetPubMimeTypeObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMimeTypeObj realiseMimeType( IIntNetPubMimeTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMimeTypeObj createMimeType( IIntNetPubMimeTypeObj Obj );

	/**
	 *	Read a MimeType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MimeType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubMimeTypeObj readMimeType( Integer pkey );

	/**
	 *	Read a MimeType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MimeType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetPubMimeTypeObj readMimeType( Integer pkey,
		boolean forceRead );

	IIntNetPubMimeTypeObj readCachedMimeType( Integer pkey );

	public void reallyDeepDisposeMimeType( IIntNetPubMimeTypeObj obj );

	void deepDisposeMimeType( Integer pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMimeTypeObj lockMimeType( Integer pkey );

	/**
	 *	Return a sorted list of all the MimeType-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubMimeTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubMimeTypeObj> readAllMimeType();

	/**
	 *	Return a sorted map of all the MimeType-derived instances in the database.
	 *
	 *	@return	List of IIntNetPubMimeTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetPubMimeTypeObj> readAllMimeType( boolean forceRead );

	List<IIntNetPubMimeTypeObj> readCachedAllMimeType();

	/**
	 *	Get the IntNetPubMimeTypeObj instance for the primary key attributes.
	 *
	 *	@param	MimeTypeId	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMimeTypeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId );

	/**
	 *	Get the IntNetPubMimeTypeObj instance for the primary key attributes.
	 *
	 *	@param	MimeTypeId	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMimeTypeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId,
		boolean forceRead );

	/**
	 *	Get the IntNetPubMimeTypeObj instance for the unique UNameIdx key.
	 *
	 *	@param	Name	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMimeTypeObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMimeTypeObj readMimeTypeByUNameIdx(String Name );

	/**
	 *	Get the IntNetPubMimeTypeObj instance for the unique UNameIdx key.
	 *
	 *	@param	Name	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return	IntNetPubMimeTypeObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetPubMimeTypeObj readMimeTypeByUNameIdx(String Name,
		boolean forceRead );

	IIntNetPubMimeTypeObj readCachedMimeTypeByIdIdx( int MimeTypeId );

	IIntNetPubMimeTypeObj readCachedMimeTypeByUNameIdx( String Name );

	void deepDisposeMimeTypeByIdIdx( int MimeTypeId );

	void deepDisposeMimeTypeByUNameIdx( String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetPubMimeTypeObj updateMimeType( IIntNetPubMimeTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteMimeType( IIntNetPubMimeTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	MimeTypeId	The MimeType key attribute of the instance generating the id.
	 */
	void deleteMimeTypeByIdIdx( int MimeTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	Name	The MimeType key attribute of the instance generating the id.
	 */
	void deleteMimeTypeByUNameIdx(String Name );
}
