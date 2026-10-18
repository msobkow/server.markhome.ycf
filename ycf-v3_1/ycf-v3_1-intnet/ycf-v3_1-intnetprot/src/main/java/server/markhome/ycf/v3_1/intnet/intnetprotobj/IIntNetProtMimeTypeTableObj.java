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

public interface IIntNetProtMimeTypeTableObj
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
	 *	Instantiate a new MimeType instance.
	 *
	 *	@return	A new instance.
	 */
	IIntNetProtMimeTypeObj newInstance();

	/**
	 *	Instantiate a new MimeType edition of the specified MimeType instance.
	 *
	 *	@return	A new edition.
	 */
	IIntNetProtMimeTypeEditObj newEditInstance( IIntNetProtMimeTypeObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	backingClassCode	The backing store class code used to identify the proposed instance class.
	 *
	 *	@return	IIntNetProtMimeTypeEditObj instance, which may be a subclass of a MimeType instance.
	 */
	IIntNetProtMimeTypeObj constructByClassCode( int backingClassCode );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMimeTypeObj realiseMimeType( IIntNetProtMimeTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMimeTypeObj createMimeType( IIntNetProtMimeTypeObj Obj );

	/**
	 *	Read a MimeType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MimeType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtMimeTypeObj readMimeType( Integer pkey );

	/**
	 *	Read a MimeType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The MimeType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IIntNetProtMimeTypeObj readMimeType( Integer pkey,
		boolean forceRead );

	IIntNetProtMimeTypeObj readCachedMimeType( Integer pkey );

	public void reallyDeepDisposeMimeType( IIntNetProtMimeTypeObj obj );

	void deepDisposeMimeType( Integer pkey );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMimeTypeObj lockMimeType( Integer pkey );

	/**
	 *	Return a sorted list of all the MimeType-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtMimeTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtMimeTypeObj> readAllMimeType();

	/**
	 *	Return a sorted map of all the MimeType-derived instances in the database.
	 *
	 *	@return	List of IIntNetProtMimeTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IIntNetProtMimeTypeObj> readAllMimeType( boolean forceRead );

	List<IIntNetProtMimeTypeObj> readCachedAllMimeType();

	/**
	 *	Get the IIntNetProtMimeTypeObj instance for the primary key attributes.
	 *
	 *	@param	MimeTypeId	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMimeTypeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId );

	/**
	 *	Get the IIntNetProtMimeTypeObj instance for the primary key attributes.
	 *
	 *	@param	MimeTypeId	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMimeTypeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId,
		boolean forceRead );

	/**
	 *	Get the IIntNetProtMimeTypeObj instance for the unique UNameIdx key.
	 *
	 *	@param	Name	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMimeTypeObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMimeTypeObj readMimeTypeByUNameIdx(String Name );

	/**
	 *	Get the IIntNetProtMimeTypeObj instance for the unique UNameIdx key.
	 *
	 *	@param	Name	The MimeType key attribute of the instance generating the id.
	 *
	 *	@return	IIntNetProtMimeTypeObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IIntNetProtMimeTypeObj readMimeTypeByUNameIdx(String Name,
		boolean forceRead );

	IIntNetProtMimeTypeObj readCachedMimeTypeByIdIdx( int MimeTypeId );

	IIntNetProtMimeTypeObj readCachedMimeTypeByUNameIdx( String Name );

	void deepDisposeMimeTypeByIdIdx( int MimeTypeId );

	void deepDisposeMimeTypeByUNameIdx( String Name );

	/**
	 *	Internal use only.
	 */
	IIntNetProtMimeTypeObj updateMimeType( IIntNetProtMimeTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteMimeType( IIntNetProtMimeTypeObj Obj );

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
