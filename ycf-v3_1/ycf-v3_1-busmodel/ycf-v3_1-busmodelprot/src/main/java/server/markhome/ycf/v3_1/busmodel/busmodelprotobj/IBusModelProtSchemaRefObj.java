// Description: Java 25 Object interface for BusModelProt SchemaRef.

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

package server.markhome.ycf.v3_1.busmodel.busmodelprotobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;

public interface IBusModelProtSchemaRefObj
	extends IBusModelProtScopeObj
{
	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	IBusModelProtScopeObj the reference to the moved and refreshed instance.
	 */
	IBusModelProtScopeObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	IBusModelProtSchemaRefObj the reference to the moved and refreshed instance.
	 */
	IBusModelProtScopeObj moveDown();

	/**
	 *	Get the current edition of this SchemaRef instance as a IBusModelProtSchemaRefEditObj.
	 *
	 *	@return	The IBusModelProtSchemaRefEditObj edition of this instance.
	 */
	IBusModelProtSchemaRefEditObj getEditAsSchemaRef();

	/**
	 *	Get the IBusModelProtSchemaRefTableObj table cache which manages this instance.
	 *
	 *	@return	IBusModelProtSchemaRefTableObj table cache which manages this instance.
	 */
	IBusModelProtSchemaRefTableObj getSchemaRefTable();

	/**
	 *	Get the IBusModelProtSchemaRef instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelProtSchemaRef instance which currently backs this object.
	 */
	IBusModelProtSchemaRef getSchemaRefRec();

	/**
	 *	Get the required IBusModelProtSchemaDefObj instance referenced by the Schema key.
	 *
	 *	@return	The required IBusModelProtSchemaDefObj instance referenced by the Schema key.
	 */
	IBusModelProtSchemaDefObj getRequiredContainerSchema();

	/**
	 *	Get the required IBusModelProtSchemaDefObj instance referenced by the Schema key.
	 *
	 *	@return	The required IBusModelProtSchemaDefObj instance referenced by the Schema key.
	 */
	IBusModelProtSchemaDefObj getRequiredContainerSchema( boolean forceRead );

	/**
	 *	Get the optional IBusModelProtSchemaDefObj instance referenced by the RefSchema key.
	 *
	 *	@return	The optional IBusModelProtSchemaDefObj instance referenced by the RefSchema key.
	 */
	IBusModelProtSchemaDefObj getOptionalLookupRefSchema();

	/**
	 *	Get the optional IBusModelProtSchemaDefObj instance referenced by the RefSchema key.
	 *
	 *	@return	The optional IBusModelProtSchemaDefObj instance referenced by the RefSchema key.
	 */
	IBusModelProtSchemaDefObj getOptionalLookupRefSchema( boolean forceRead );

	/**
	 *	Get the optional IBusModelProtSchemaRefObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelProtSchemaRefObj instance referenced by the Prev key.
	 */
	IBusModelProtSchemaRefObj getOptionalLookupPrev();

	/**
	 *	Get the optional IBusModelProtSchemaRefObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelProtSchemaRefObj instance referenced by the Prev key.
	 */
	IBusModelProtSchemaRefObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional IBusModelProtSchemaRefObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelProtSchemaRefObj instance referenced by the Next key.
	 */
	IBusModelProtSchemaRefObj getOptionalLookupNext();

	/**
	 *	Get the optional IBusModelProtSchemaRefObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelProtSchemaRefObj instance referenced by the Next key.
	 */
	IBusModelProtSchemaRefObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute Id.
	 *
	 *	@return	The required IYCFKeyHash256 attribute Id.
	 */
	IYCFKeyHash256 getRequiredId();

	/**
	 *	Get the required IYCFKeyHash256 attribute SchemaId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SchemaId.
	 */
	IYCFKeyHash256 getRequiredSchemaId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required String attribute RefModelName.
	 *
	 *	@return	The required String attribute RefModelName.
	 */
	String getRequiredRefModelName();

	/**
	 *	Get the required String attribute IncludeRoot.
	 *
	 *	@return	The required String attribute IncludeRoot.
	 */
	String getRequiredIncludeRoot();

	/**
	 *	Get the optional YCFDbKeyHash256 attribute RefSchemaId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute RefSchemaId.
	 */
	YCFDbKeyHash256 getOptionalRefSchemaId();

	/**
	 *	Get the optional YCFDbKeyHash256 attribute PrevId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute PrevId.
	 */
	YCFDbKeyHash256 getOptionalPrevId();

	/**
	 *	Get the optional YCFDbKeyHash256 attribute NextId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute NextId.
	 */
	YCFDbKeyHash256 getOptionalNextId();

}
