
// Description: Java Protected Factory interface for SchemaDef.

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

package server.markhome.ycf.v3_1.busmodel.busmodelprot;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
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
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

/*
 *	IBusModelProtSchemaDefFactory protected interface for SchemaDef
 */
public interface IBusModelProtSchemaDefFactory extends IBusModelPubSchemaDefFactory
{

	/**
	 *	Allocate a protected CTenantIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByCTenantIdxKey newProtByCTenantIdxKey();

	/**
	 *	Allocate a public CTenantIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByCTenantIdxKey asPublic(IBusModelProtSchemaDefByCTenantIdxKey src);

	/**
	 *	Allocate a protected MinorVersionIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByMinorVersionIdxKey newProtByMinorVersionIdxKey();

	/**
	 *	Allocate a public MinorVersionIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByMinorVersionIdxKey asPublic(IBusModelProtSchemaDefByMinorVersionIdxKey src);

	/**
	 *	Allocate a protected UNameIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByUNameIdxKey newProtByUNameIdxKey();

	/**
	 *	Allocate a public UNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByUNameIdxKey asPublic(IBusModelProtSchemaDefByUNameIdxKey src);

	/**
	 *	Allocate a protected AuthEMailIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByAuthEMailIdxKey newProtByAuthEMailIdxKey();

	/**
	 *	Allocate a public AuthEMailIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByAuthEMailIdxKey asPublic(IBusModelProtSchemaDefByAuthEMailIdxKey src);

	/**
	 *	Allocate a protected ProjectURLIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByProjectURLIdxKey newProtByProjectURLIdxKey();

	/**
	 *	Allocate a public ProjectURLIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByProjectURLIdxKey asPublic(IBusModelProtSchemaDefByProjectURLIdxKey src);

	/**
	 *	Allocate a protected PubURIIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByPubURIIdxKey newProtByPubURIIdxKey();

	/**
	 *	Allocate a public PubURIIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByPubURIIdxKey asPublic(IBusModelProtSchemaDefByPubURIIdxKey src);

	/**
	 *	Allocate a protected SchemaDef interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDef newProtRec();

	/**
	 *	Allocate a public SchemaDef interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDef asPublic(IBusModelProtSchemaDef src);

	/**
	 *	Allocate a protected SchemaDef history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefH newProtHRec();

	/**
	 *	Allocate a public SchemaDef history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefH asPublic(IBusModelProtSchemaDefH src);

}
