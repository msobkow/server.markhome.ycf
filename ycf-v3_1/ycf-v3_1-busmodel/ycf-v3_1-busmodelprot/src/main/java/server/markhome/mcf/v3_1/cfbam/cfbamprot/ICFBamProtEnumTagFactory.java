
// Description: Java Protected Factory interface for EnumTag.

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
 *	ICFBamProtEnumTagFactory protected interface for EnumTag
 */
public interface ICFBamProtEnumTagFactory extends ICFBamPubEnumTagFactory
{

	/**
	 *	Allocate a protected primary history key for EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	ICFBamProtEnumTagHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for EnumTag instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	ICFBamPubEnumTagHPKey asPublic(ICFBamProtEnumTagHPKey src);

	/**
	 *	Allocate a protected EnumIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtEnumTagByEnumIdxKey newProtByEnumIdxKey();

	/**
	 *	Allocate a public EnumIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubEnumTagByEnumIdxKey asPublic(ICFBamProtEnumTagByEnumIdxKey src);

	/**
	 *	Allocate a protected DefSchemaIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtEnumTagByDefSchemaIdxKey newProtByDefSchemaIdxKey();

	/**
	 *	Allocate a public DefSchemaIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubEnumTagByDefSchemaIdxKey asPublic(ICFBamProtEnumTagByDefSchemaIdxKey src);

	/**
	 *	Allocate a protected EnumNameIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtEnumTagByEnumNameIdxKey newProtByEnumNameIdxKey();

	/**
	 *	Allocate a public EnumNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubEnumTagByEnumNameIdxKey asPublic(ICFBamProtEnumTagByEnumNameIdxKey src);

	/**
	 *	Allocate a protected PrevIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtEnumTagByPrevIdxKey newProtByPrevIdxKey();

	/**
	 *	Allocate a public PrevIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubEnumTagByPrevIdxKey asPublic(ICFBamProtEnumTagByPrevIdxKey src);

	/**
	 *	Allocate a protected NextIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtEnumTagByNextIdxKey newProtByNextIdxKey();

	/**
	 *	Allocate a public NextIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubEnumTagByNextIdxKey asPublic(ICFBamProtEnumTagByNextIdxKey src);

	/**
	 *	Allocate a protected EnumTag interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtEnumTag newProtRec();

	/**
	 *	Allocate a public EnumTag interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubEnumTag asPublic(ICFBamProtEnumTag src);

	/**
	 *	Allocate a protected EnumTag history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtEnumTagH newProtHRec();

	/**
	 *	Allocate a public EnumTag history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubEnumTagH asPublic(ICFBamProtEnumTagH src);

}
