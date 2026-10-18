
// Description: Java Public Factory interface for Table.

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

package server.markhome.mcf.v3_1.cfbam.cfbampub;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;

/*
 *	ICFBamPubTableFactory public interface for Table
 */
public interface ICFBamPubTableFactory
{

	/**
	 *	Allocate a public SchemaDefIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableBySchemaDefIdxKey newPubBySchemaDefIdxKey();

	/**
	 *	Allocate a public CodeVisIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableByCodeVisIdxKey newPubByCodeVisIdxKey();

	/**
	 *	Allocate a public SchemaCodeVisIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableBySchemaCodeVisIdxKey newPubBySchemaCodeVisIdxKey();

	/**
	 *	Allocate a public DefSchemaIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableByDefSchemaIdxKey newPubByDefSchemaIdxKey();

	/**
	 *	Allocate a public UNameIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableByUNameIdxKey newPubByUNameIdxKey();

	/**
	 *	Allocate a public SchemaCdIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableBySchemaCdIdxKey newPubBySchemaCdIdxKey();

	/**
	 *	Allocate a public PrimaryIndexIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableByPrimaryIndexIdxKey newPubByPrimaryIndexIdxKey();

	/**
	 *	Allocate a public LookupIndexIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableByLookupIndexIdxKey newPubByLookupIndexIdxKey();

	/**
	 *	Allocate a public AltIndexIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableByAltIndexIdxKey newPubByAltIndexIdxKey();

	/**
	 *	Allocate a public QualTableIdx key over public Table instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableByQualTableIdxKey newPubByQualTableIdxKey();

	/**
	 *	Allocate a public Table interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTable newPubRec();

	/**
	 *	Allocate a public Table history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTableH newPubHRec();

}
