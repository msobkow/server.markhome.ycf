
// Description: Java Protected Factory interface for Tweak.

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
 *	ICFBamProtTweakFactory protected interface for Tweak
 */
public interface ICFBamProtTweakFactory extends ICFBamPubTweakFactory
{

	/**
	 *	Allocate a protected primary history key for Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	ICFBamProtTweakHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for Tweak instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	ICFBamPubTweakHPKey asPublic(ICFBamProtTweakHPKey src);

	/**
	 *	Allocate a protected UNameIdx key over protected Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtTweakByUNameIdxKey newProtByUNameIdxKey();

	/**
	 *	Allocate a public UNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTweakByUNameIdxKey asPublic(ICFBamProtTweakByUNameIdxKey src);

	/**
	 *	Allocate a protected ValTentIdx key over protected Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtTweakByValTentIdxKey newProtByValTentIdxKey();

	/**
	 *	Allocate a public ValTentIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTweakByValTentIdxKey asPublic(ICFBamProtTweakByValTentIdxKey src);

	/**
	 *	Allocate a protected ScopeIdx key over protected Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtTweakByScopeIdxKey newProtByScopeIdxKey();

	/**
	 *	Allocate a public ScopeIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTweakByScopeIdxKey asPublic(ICFBamProtTweakByScopeIdxKey src);

	/**
	 *	Allocate a protected DefSchemaIdx key over protected Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtTweakByDefSchemaIdxKey newProtByDefSchemaIdxKey();

	/**
	 *	Allocate a public DefSchemaIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTweakByDefSchemaIdxKey asPublic(ICFBamProtTweakByDefSchemaIdxKey src);

	/**
	 *	Allocate a protected UDefIdx key over protected Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtTweakByUDefIdxKey newProtByUDefIdxKey();

	/**
	 *	Allocate a public UDefIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTweakByUDefIdxKey asPublic(ICFBamProtTweakByUDefIdxKey src);

	/**
	 *	Allocate a protected Tweak interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtTweak newProtRec();

	/**
	 *	Allocate a public Tweak interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTweak asPublic(ICFBamProtTweak src);

	/**
	 *	Allocate a protected Tweak history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamProtTweakH newProtHRec();

	/**
	 *	Allocate a public Tweak history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public ICFBamPubTweakH asPublic(ICFBamProtTweakH src);

}
