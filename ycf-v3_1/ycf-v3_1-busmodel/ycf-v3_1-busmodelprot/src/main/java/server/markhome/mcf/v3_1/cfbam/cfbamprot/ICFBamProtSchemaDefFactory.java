
// Description: Java Protected Factory interface for SchemaDef.

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
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
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbamprot;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbamprotobj.*;

/*
 *	ICFBamProtSchemaDefFactory protected interface for SchemaDef
 */
public interface ICFBamProtSchemaDefFactory extends ICFBamPubSchemaDefFactory
{

	/**
	 *	Allocate a protected CTenantIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtSchemaDefByCTenantIdxKey newProtByCTenantIdxKey();

	/**
	 *	Allocate a public CTenantIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubSchemaDefByCTenantIdxKey asPublic(ICFBamProtSchemaDefByCTenantIdxKey src);

	/**
	 *	Allocate a protected MinorVersionIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtSchemaDefByMinorVersionIdxKey newProtByMinorVersionIdxKey();

	/**
	 *	Allocate a public MinorVersionIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubSchemaDefByMinorVersionIdxKey asPublic(ICFBamProtSchemaDefByMinorVersionIdxKey src);

	/**
	 *	Allocate a protected UNameIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtSchemaDefByUNameIdxKey newProtByUNameIdxKey();

	/**
	 *	Allocate a public UNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubSchemaDefByUNameIdxKey asPublic(ICFBamProtSchemaDefByUNameIdxKey src);

	/**
	 *	Allocate a protected AuthEMailIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtSchemaDefByAuthEMailIdxKey newProtByAuthEMailIdxKey();

	/**
	 *	Allocate a public AuthEMailIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubSchemaDefByAuthEMailIdxKey asPublic(ICFBamProtSchemaDefByAuthEMailIdxKey src);

	/**
	 *	Allocate a protected ProjectURLIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtSchemaDefByProjectURLIdxKey newProtByProjectURLIdxKey();

	/**
	 *	Allocate a public ProjectURLIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubSchemaDefByProjectURLIdxKey asPublic(ICFBamProtSchemaDefByProjectURLIdxKey src);

	/**
	 *	Allocate a protected PubURIIdx key over protected SchemaDef instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtSchemaDefByPubURIIdxKey newProtByPubURIIdxKey();

	/**
	 *	Allocate a public PubURIIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubSchemaDefByPubURIIdxKey asPublic(ICFBamProtSchemaDefByPubURIIdxKey src);

	/**
	 *	Allocate a protected SchemaDef interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtSchemaDef newProtRec();

	/**
	 *	Allocate a public SchemaDef interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubSchemaDef asPublic(ICFBamProtSchemaDef src);

	/**
	 *	Allocate a protected SchemaDef history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtSchemaDefH newProtHRec();

	/**
	 *	Allocate a public SchemaDef history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubSchemaDefH asPublic(ICFBamProtSchemaDefH src);

}
