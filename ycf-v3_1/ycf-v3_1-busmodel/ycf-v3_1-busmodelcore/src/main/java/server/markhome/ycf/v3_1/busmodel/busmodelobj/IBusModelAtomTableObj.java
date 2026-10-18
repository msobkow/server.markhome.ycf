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

public interface IBusModelAtomTableObj
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
	 *	Instantiate a new Atom instance.
	 *
	 *	@return	A new instance.
	 */
	IBusModelAtomObj newInstance();

	/**
	 *	Instantiate a new Atom edition of the specified Atom instance.
	 *
	 *	@return	A new edition.
	 */
	IBusModelAtomEditObj newEditInstance( IBusModelAtomObj orig );

	/**
	 *	Internal use only.
	 */
	IBusModelAtomObj realiseAtom( IBusModelAtomObj Obj );

	/**
	 *	Internal use only.
	 */
	IBusModelAtomObj createAtom( IBusModelAtomObj Obj );

	/**
	 *	Read a Atom-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Atom-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelAtomObj readAtom( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Read a Atom-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Atom-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	IBusModelAtomObj readAtom( $implCommaIJavaOptAtomType$ pkey,
		boolean forceRead );

	IBusModelAtomObj readCachedAtom( $implCommaIJavaOptAtomType$ pkey );

	public void reallyDeepDisposeAtom( IBusModelAtomObj obj );

	void deepDisposeAtom( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Internal use only.
	 */
	IBusModelAtomObj lockAtom( $implCommaIJavaOptAtomType$ pkey );

	/**
	 *	Return a sorted list of all the Atom-derived instances in the database.
	 *
	 *	@return	List of IBusModelAtomObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelAtomObj> readAllAtom();

	/**
	 *	Return a sorted map of all the Atom-derived instances in the database.
	 *
	 *	@return	List of IBusModelAtomObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<IBusModelAtomObj> readAllAtom( boolean forceRead );

	List<IBusModelAtomObj> readCachedAllAtom();

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelAtomObj readAtomByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Get the BusModelValueObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	IBusModelAtomObj readAtomByIdIdx( IYCFKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelAtomObj readAtomByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Get the BusModelValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	BusModelValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	IBusModelAtomObj readAtomByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Get the map of BusModelAtomObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Get the map of BusModelAtomObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	DefSchemaId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelAtomObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	PrevId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelAtomObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	NextId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Get the map of BusModelAtomObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead );

	/**
	 *	Get the map of BusModelValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Get the map of BusModelAtomObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Atom key attribute of the instance generating the id.
	 *
	 *	@return	List of BusModelAtomObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<IBusModelAtomObj> readAtomByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead );

	IBusModelAtomObj readCachedAtomByIdIdx( IYCFKeyHash256 Id );

	IBusModelAtomObj readCachedAtomByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	List<IBusModelAtomObj> readCachedAtomByScopeIdx( IYCFKeyHash256 ScopeId );

	List<IBusModelAtomObj> readCachedAtomByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	List<IBusModelAtomObj> readCachedAtomByPrevIdx( IYCFKeyHash256 PrevId );

	List<IBusModelAtomObj> readCachedAtomByNextIdx( IYCFKeyHash256 NextId );

	List<IBusModelAtomObj> readCachedAtomByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	List<IBusModelAtomObj> readCachedAtomByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	void deepDisposeAtomByIdIdx( IYCFKeyHash256 Id );

	void deepDisposeAtomByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	void deepDisposeAtomByScopeIdx( IYCFKeyHash256 ScopeId );

	void deepDisposeAtomByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	void deepDisposeAtomByPrevIdx( IYCFKeyHash256 PrevId );

	void deepDisposeAtomByNextIdx( IYCFKeyHash256 NextId );

	void deepDisposeAtomByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	void deepDisposeAtomByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 */
	IBusModelAtomObj updateAtom( IBusModelAtomObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteAtom( IBusModelAtomObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Atom key attribute of the instance generating the id.
	 */
	void deleteAtomByIdIdx( IYCFKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@param	Name	The Atom key attribute of the instance generating the id.
	 */
	void deleteAtomByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 */
	void deleteAtomByScopeIdx( IYCFKeyHash256 ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	DefSchemaId	The Atom key attribute of the instance generating the id.
	 */
	void deleteAtomByDefSchemaIdx( IYCFKeyHash256 DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PrevId	The Atom key attribute of the instance generating the id.
	 */
	void deleteAtomByPrevIdx( IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	NextId	The Atom key attribute of the instance generating the id.
	 */
	void deleteAtomByNextIdx( IYCFKeyHash256 NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@param	PrevId	The Atom key attribute of the instance generating the id.
	 */
	void deleteAtomByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ScopeId	The Atom key attribute of the instance generating the id.
	 *
	 *	@param	NextId	The Atom key attribute of the instance generating the id.
	 */
	void deleteAtomByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId );

	/**
	 *	Move the BusModelAtomObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelAtomObj refreshed cache instance.
	 */
	IBusModelAtomObj moveUpAtom( IBusModelAtomObj Obj );

	/**
	 *	Move the BusModelAtomObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelAtomObj refreshed cache instance.
	 */
	IBusModelAtomObj moveDownAtom( IBusModelAtomObj Obj );
}
