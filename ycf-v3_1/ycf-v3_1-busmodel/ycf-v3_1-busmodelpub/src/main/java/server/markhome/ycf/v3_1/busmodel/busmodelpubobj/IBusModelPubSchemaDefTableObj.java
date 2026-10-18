// Description: Java 25 Public Table Object interface for BusModelPub.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelpubobj;

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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IBusModelPubSchemaDefTableObj
{
	public IBusModelPubSchemaObj getSchema();
	public void setSchema( IBusModelPubSchemaObj value );

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
	 *	Instantiate a new SchemaDef instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelPubSchemaDefObj newInstance();

	/**
	 *	Instantiate a new SchemaDef edition of the specified SchemaDef instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelPubSchemaDefEditObj newEditInstance( IBusModelPubSchemaDefObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelPubSchemaDefObj realiseSchemaDef( IBusModelPubSchemaDefObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelPubSchemaDefObj createSchemaDef( IBusModelPubSchemaDefObj Obj );

	/**
	 *	Read a SchemaDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubSchemaDefObj readSchemaDef( IYCFKeyHash256 pkey );

	/**
	 *	Read a SchemaDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelPubSchemaDefObj readSchemaDef( IYCFKeyHash256 pkey,
		boolean forceRead );

	IBusModelPubSchemaDefObj readCachedSchemaDef( IYCFKeyHash256 pkey );

	public void reallyDeepDisposeSchemaDef( IBusModelPubSchemaDefObj obj );

	void deepDisposeSchemaDef( IYCFKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelPubSchemaDefObj lockSchemaDef( IYCFKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SchemaDef-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubSchemaDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readAllSchemaDef();

	/**
	 *	Return a sorted map of all the SchemaDef-derived instances in the database.
	 *
	 *	@return	List of IBusModelPubSchemaDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readAllSchemaDef( boolean forceRead );

	List<IBusModelPubSchemaDefObj> readCachedAllSchemaDef();

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubSchemaDefObj readSchemaDefByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Get the BusModelPubScopeObj instance for the primary key attributes.
	 *
	 *	@param	Id	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubSchemaDefObj readSchemaDefByIdIdx( YCFDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Get the map of BusModelPubSchemaDefObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByTenantIdx( YCFDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubSchemaDefObj instances sorted by their primary keys for the duplicate CTenantIdx key.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate CTenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByCTenantIdx( YCFDbKeyHash256 CTenantId );

	/**
	 *	Get the map of BusModelPubSchemaDefObj instances sorted by their primary keys for the duplicate CTenantIdx key.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate CTenantIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByCTenantIdx( YCFDbKeyHash256 CTenantId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubSchemaDefObj instances sorted by their primary keys for the duplicate MinorVersionIdx key.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate MinorVersionIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByMinorVersionIdx( YCFDbKeyHash256 MinorVersionId );

	/**
	 *	Get the map of BusModelPubSchemaDefObj instances sorted by their primary keys for the duplicate MinorVersionIdx key.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate MinorVersionIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByMinorVersionIdx( YCFDbKeyHash256 MinorVersionId,
		boolean forceRead );

	/**
	 *	Get the BusModelPubSchemaDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubSchemaDefObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubSchemaDefObj readSchemaDefByUNameIdx(YCFDbKeyHash256 MinorVersionId,
		String Name );

	/**
	 *	Get the BusModelPubSchemaDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubSchemaDefObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubSchemaDefObj readSchemaDefByUNameIdx(YCFDbKeyHash256 MinorVersionId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubSchemaDefObj instances sorted by their primary keys for the duplicate AuthEMailIdx key.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	AuthorEMail	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate AuthEMailIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByAuthEMailIdx( YCFDbKeyHash256 CTenantId,
		String AuthorEMail );

	/**
	 *	Get the map of BusModelPubSchemaDefObj instances sorted by their primary keys for the duplicate AuthEMailIdx key.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	AuthorEMail	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate AuthEMailIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByAuthEMailIdx( YCFDbKeyHash256 CTenantId,
		String AuthorEMail,
		boolean forceRead );

	/**
	 *	Get the map of BusModelPubSchemaDefObj instances sorted by their primary keys for the duplicate ProjectURLIdx key.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	ProjectURL	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate ProjectURLIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByProjectURLIdx( YCFDbKeyHash256 CTenantId,
		String ProjectURL );

	/**
	 *	Get the map of BusModelPubSchemaDefObj instances sorted by their primary keys for the duplicate ProjectURLIdx key.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	ProjectURL	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelPubSchemaDefObj cached instances sorted by their primary keys for the duplicate ProjectURLIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelPubSchemaDefObj> readSchemaDefByProjectURLIdx( YCFDbKeyHash256 CTenantId,
		String ProjectURL,
		boolean forceRead );

	/**
	 *	Get the BusModelPubSchemaDefObj instance for the unique PubURIIdx key.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	PublishURI	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubSchemaDefObj cached instance for the unique PubURIIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubSchemaDefObj readSchemaDefByPubURIIdx(YCFDbKeyHash256 CTenantId,
		String PublishURI );

	/**
	 *	Get the BusModelPubSchemaDefObj instance for the unique PubURIIdx key.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	PublishURI	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelPubSchemaDefObj refreshed instance for the unique PubURIIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelPubSchemaDefObj readSchemaDefByPubURIIdx(YCFDbKeyHash256 CTenantId,
		String PublishURI,
		boolean forceRead );

	IBusModelPubSchemaDefObj readCachedSchemaDefByIdIdx( YCFDbKeyHash256 Id );

	List<IBusModelPubSchemaDefObj> readCachedSchemaDefByTenantIdx( YCFDbKeyHash256 TenantId );

	List<IBusModelPubSchemaDefObj> readCachedSchemaDefByCTenantIdx( YCFDbKeyHash256 CTenantId );

	List<IBusModelPubSchemaDefObj> readCachedSchemaDefByMinorVersionIdx( YCFDbKeyHash256 MinorVersionId );

	IBusModelPubSchemaDefObj readCachedSchemaDefByUNameIdx( YCFDbKeyHash256 MinorVersionId,
		String Name );

	List<IBusModelPubSchemaDefObj> readCachedSchemaDefByAuthEMailIdx( YCFDbKeyHash256 CTenantId,
		String AuthorEMail );

	List<IBusModelPubSchemaDefObj> readCachedSchemaDefByProjectURLIdx( YCFDbKeyHash256 CTenantId,
		String ProjectURL );

	IBusModelPubSchemaDefObj readCachedSchemaDefByPubURIIdx( YCFDbKeyHash256 CTenantId,
		String PublishURI );

	void deepDisposeSchemaDefByIdIdx( YCFDbKeyHash256 Id );

	void deepDisposeSchemaDefByTenantIdx( YCFDbKeyHash256 TenantId );

	void deepDisposeSchemaDefByCTenantIdx( YCFDbKeyHash256 CTenantId );

	void deepDisposeSchemaDefByMinorVersionIdx( YCFDbKeyHash256 MinorVersionId );

	void deepDisposeSchemaDefByUNameIdx( YCFDbKeyHash256 MinorVersionId,
		String Name );

	void deepDisposeSchemaDefByAuthEMailIdx( YCFDbKeyHash256 CTenantId,
		String AuthorEMail );

	void deepDisposeSchemaDefByProjectURLIdx( YCFDbKeyHash256 CTenantId,
		String ProjectURL );

	void deepDisposeSchemaDefByPubURIIdx( YCFDbKeyHash256 CTenantId,
		String PublishURI );

	/**
	 *	Internal use only.
	 */
	IBusModelPubSchemaDefObj updateSchemaDef( IBusModelPubSchemaDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSchemaDef( IBusModelPubSchemaDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByIdIdx( YCFDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByTenantIdx( YCFDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByCTenantIdx( YCFDbKeyHash256 CTenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByMinorVersionIdx( YCFDbKeyHash256 MinorVersionId );

	/**
	 *	Internal use only.
	 *
	 *	@param	MinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByUNameIdx(YCFDbKeyHash256 MinorVersionId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	AuthorEMail	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByAuthEMailIdx( YCFDbKeyHash256 CTenantId,
		String AuthorEMail );

	/**
	 *	Internal use only.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	ProjectURL	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByProjectURLIdx( YCFDbKeyHash256 CTenantId,
		String ProjectURL );

	/**
	 *	Internal use only.
	 *
	 *	@param	CTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	PublishURI	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByPubURIIdx(YCFDbKeyHash256 CTenantId,
		String PublishURI );
}
