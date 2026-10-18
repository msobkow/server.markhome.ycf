// Description: Java 25 Object interface for BusModelPub DbKeyHash384Type.

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

public interface IBusModelPubDbKeyHash384TypeObj
	extends IBusModelPubDbKeyHash384DefObj
{
	/**
	 *	Get the current edition of this DbKeyHash384Type instance as a IBusModelPubDbKeyHash384TypeEditObj.
	 *
	 *	@return	The IBusModelPubDbKeyHash384TypeEditObj edition of this instance.
	 */
	IBusModelPubDbKeyHash384TypeEditObj getEditAsDbKeyHash384Type();

	/**
	 *	Get the IBusModelPubDbKeyHash384TypeTableObj table cache which manages this instance.
	 *
	 *	@return	IBusModelPubDbKeyHash384TypeTableObj table cache which manages this instance.
	 */
	IBusModelPubDbKeyHash384TypeTableObj getDbKeyHash384TypeTable();

	/**
	 *	Get the IBusModelPubDbKeyHash384Type instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelPubDbKeyHash384Type instance which currently backs this object.
	 */
	IBusModelPubDbKeyHash384Type getDbKeyHash384TypeRec();

	/**
	 *	Get the required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	IBusModelPubSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Get the required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	IBusModelPubSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead );

	/**
	 *	Get the required YCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute Id.
	 */
	YCFDbKeyHash256 getRequiredId();

	/**
	 *	Get the required YCFDbKeyHash256 attribute SchemaDefId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute SchemaDefId.
	 */
	YCFDbKeyHash256 getRequiredSchemaDefId();

}
