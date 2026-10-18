// Description: Java 25 Table Object interface for BusModel.

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

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

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
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public interface IBusModelTextDefTableObj
{
	public IBusModelSchemaObj getSchema();
	public void setSchema( IBusModelSchemaObj value );

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
	 *	Instantiate a new TextDef instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelTextDefObj newInstance();

	/**
	 *	Instantiate a new TextDef edition of the specified TextDef instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelTextDefEditObj newEditInstance( IBusModelTextDefObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelTextDefObj realiseTextDef( IBusModelTextDefObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelTextDefObj createTextDef( IBusModelTextDefObj Obj );

	/**
	 *	Read a TextDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TextDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelTextDefObj readTextDef( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a TextDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TextDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelTextDefObj readTextDef( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelTextDefObj readCachedTextDef( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeTextDef( IBusModelTextDefObj obj );

	void deepDisposeTextDef( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelTextDefObj lockTextDef( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the TextDef-derived instances in the database.
	 *
	 *	@return	List of IBusModelTextDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelTextDefObj> readAllTextDef();

	/**
	 *	Return a sorted map of all the TextDef-derived instances in the database.
	 *
	 *	@return	List of IBusModelTextDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelTextDefObj> readAllTextDef( boolean forceRead );

	List<IBusModelTextDefObj> readCachedAllTextDef();

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelTextDefObj readTextDefByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelTextDefObj readTextDefByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelTextDefObj readTextDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelTextDefObj readTextDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelTextDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelTextDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelTextDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelTextDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelTextDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelTextDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelTextDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelTextDefObj> readTextDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	IBusModelTextDefObj readCachedTextDefByIdIdx( IYCFKeyHash256 Id );

	IBusModelTextDefObj readCachedTextDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<IBusModelTextDefObj> readCachedTextDefByScopeIdx( IYCFKeyHash256 ScopeId );

	List<IBusModelTextDefObj> readCachedTextDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelTextDefObj> readCachedTextDefByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelTextDefObj> readCachedTextDefByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelTextDefObj> readCachedTextDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	List<IBusModelTextDefObj> readCachedTextDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	void deepDisposeTextDefByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeTextDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeTextDefByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeTextDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeTextDefByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeTextDefByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeTextDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	void deepDisposeTextDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelTextDefObj updateTextDef( IBusModelTextDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTextDef( IBusModelTextDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The TextDef key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The TextDef key attribute of the instance generating the id.
	 */
	void deleteTextDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Move the BusModelTextDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelTextDefObj refreshed cache instance.
	 */
	IBusModelTextDefObj moveUpTextDef( IBusModelTextDefObj Obj );

	/**
	 *	Move the BusModelTextDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelTextDefObj refreshed cache instance.
	 */
	IBusModelTextDefObj moveDownTextDef( IBusModelTextDefObj Obj );
}
