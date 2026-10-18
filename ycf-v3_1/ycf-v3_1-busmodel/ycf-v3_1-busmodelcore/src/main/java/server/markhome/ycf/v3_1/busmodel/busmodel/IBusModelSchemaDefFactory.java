
// Description: Java JPA Factory interface for SchemaDef.

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

package server.markhome.ycf.v3_1.busmodel.busmodel;

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

import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

/*
 *	IBusModelSchemaDefFactory interface for SchemaDef
 */
public interface IBusModelSchemaDefFactory extends IBusModelProtSchemaDefFactory
{

	/**
	 *	Allocate a CTenantIdx key over SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelSchemaDefByCTenantIdxKey newByCTenantIdxKey();

	/**
	 *	Allocate a protected CTenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByCTenantIdxKey asProtected(IBusModelSchemaDefByCTenantIdxKey src);

	/**
	 *	Allocate a public CTenantIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByCTenantIdxKey asPublic(IBusModelSchemaDefByCTenantIdxKey src);

	/**
	 *	Allocate a MinorVersionIdx key over SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelSchemaDefByMinorVersionIdxKey newByMinorVersionIdxKey();

	/**
	 *	Allocate a protected MinorVersionIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByMinorVersionIdxKey asProtected(IBusModelSchemaDefByMinorVersionIdxKey src);

	/**
	 *	Allocate a public MinorVersionIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByMinorVersionIdxKey asPublic(IBusModelSchemaDefByMinorVersionIdxKey src);

	/**
	 *	Allocate a UNameIdx key over SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelSchemaDefByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByUNameIdxKey asProtected(IBusModelSchemaDefByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByUNameIdxKey asPublic(IBusModelSchemaDefByUNameIdxKey src);

	/**
	 *	Allocate a AuthEMailIdx key over SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelSchemaDefByAuthEMailIdxKey newByAuthEMailIdxKey();

	/**
	 *	Allocate a protected AuthEMailIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByAuthEMailIdxKey asProtected(IBusModelSchemaDefByAuthEMailIdxKey src);

	/**
	 *	Allocate a public AuthEMailIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByAuthEMailIdxKey asPublic(IBusModelSchemaDefByAuthEMailIdxKey src);

	/**
	 *	Allocate a ProjectURLIdx key over SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelSchemaDefByProjectURLIdxKey newByProjectURLIdxKey();

	/**
	 *	Allocate a protected ProjectURLIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByProjectURLIdxKey asProtected(IBusModelSchemaDefByProjectURLIdxKey src);

	/**
	 *	Allocate a public ProjectURLIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByProjectURLIdxKey asPublic(IBusModelSchemaDefByProjectURLIdxKey src);

	/**
	 *	Allocate a PubURIIdx key over SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelSchemaDefByPubURIIdxKey newByPubURIIdxKey();

	/**
	 *	Allocate a protected PubURIIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefByPubURIIdxKey asProtected(IBusModelSchemaDefByPubURIIdxKey src);

	/**
	 *	Allocate a public PubURIIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefByPubURIIdxKey asPublic(IBusModelSchemaDefByPubURIIdxKey src);

	/**
	 *	Allocate a SchemaDef interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelSchemaDef newRec();

	/**
	 *	Allocate a protected SchemaDef interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDef asProtected(IBusModelSchemaDef src);

	/**
	 *	Allocate a public SchemaDef interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDef asPublic(IBusModelSchemaDef src);

	/**
	 *	Allocate a SchemaDef history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelSchemaDefH newHRec();

	/**
	 *	Allocate a protected SchemaDef history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtSchemaDefH asProtected(IBusModelSchemaDefH src);

	/**
	 *	Allocate a public SchemaDef history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubSchemaDefH asPublic(IBusModelSchemaDefH src);

}
