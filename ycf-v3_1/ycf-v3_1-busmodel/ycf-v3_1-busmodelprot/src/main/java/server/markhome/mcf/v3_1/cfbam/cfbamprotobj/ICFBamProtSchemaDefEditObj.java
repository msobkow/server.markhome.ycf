// Description: Java 25 Protected Instance Edit Object interface for CFBam SchemaDef.

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

package server.markhome.mcf.v3_1.cfbam.cfbamprotobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;

import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfbam.cfbamprot.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;

public interface ICFBamProtSchemaDefEditObj
	extends ICFBamProtSchemaDefObj, ICFBamProtScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamProtSchemaDefObj.
	 */
	ICFBamProtSchemaDefObj getOrigAsSchemaDef();

	/**
	 *	Get the ICFIntPubMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The ICFIntPubMinorVersionObj instance referenced by the MinorVersion key.
	 */
	ICFIntPubMinorVersionObj getRequiredContainerMinorVersion();

	/**
	 *	Get the required ICFIntPubMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required ICFIntPubMinorVersionObj instance referenced by the MinorVersion key.
	 */
	ICFIntPubMinorVersionObj getRequiredContainerMinorVersion( boolean forceRead );

	/**
	 *	Set the ICFIntPubMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@param	value	the ICFIntPubMinorVersionObj instance to be referenced by the MinorVersion key.
	 */
	void setRequiredContainerMinorVersion( ICFIntPubMinorVersionObj value );

	/**
	 *	Get a list ICFBamProtTableObj instances referenced by the Tables key.
	 *
	 *	@return	The (potentially empty) list of ICFBamProtTableObj instances referenced by the Tables key.
	 */
	List<ICFBamProtTableObj> getOptionalComponentsTables();

	/**
	 *	Get a list ICFBamProtValueObj instances referenced by the Types key.
	 *
	 *	@return	The (potentially empty) list of ICFBamProtValueObj instances referenced by the Types key.
	 */
	List<ICFBamProtValueObj> getOptionalComponentsTypes();

	/**
	 *	Get a list ICFBamProtSchemaRefObj instances referenced by the SchemaRefs key.
	 *
	 *	@return	The (potentially empty) list of ICFBamProtSchemaRefObj instances referenced by the SchemaRefs key.
	 */
	List<ICFBamProtSchemaRefObj> getOptionalComponentsSchemaRefs();

	/**
	 *	Get a list ICFBamProtTweakObj instances referenced by the Tweaks key.
	 *
	 *	@return	The (potentially empty) list of ICFBamProtTweakObj instances referenced by the Tweaks key.
	 */
	List<ICFBamProtTweakObj> getOptionalComponentsTweaks();

	/**
	 *	Get a list ICFBamProtSchemaRoleObj instances referenced by the Roles key.
	 *
	 *	@return	The (potentially empty) list of ICFBamProtSchemaRoleObj instances referenced by the Roles key.
	 */
	List<ICFBamProtSchemaRoleObj> getOptionalComponentsRoles();

	/**
	 *	Get the ICFSecPubTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The ICFSecPubTenantObj instance referenced by the CTenant key.
	 */
	ICFSecPubTenantObj getRequiredOwnerCTenant();

	/**
	 *	Get the required ICFSecPubTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ICFSecPubTenantObj instance referenced by the CTenant key.
	 */
	ICFSecPubTenantObj getRequiredOwnerCTenant( boolean forceRead );

	/**
	 *	Set the ICFSecPubTenantObj instance referenced by the CTenant key.
	 *
	 *	@param	value	the ICFSecPubTenantObj instance to be referenced by the CTenant key.
	 */
	void setRequiredOwnerCTenant( ICFSecPubTenantObj value );

	/**
	 *	Get the required IMCFKeyHash256 attribute CTenantId.
	 *
	 *	@return	The required IMCFKeyHash256 attribute CTenantId.
	 */
	IMCFKeyHash256 getRequiredCTenantId();

	/**
	 *	Get the required IMCFKeyHash256 attribute MinorVersionId.
	 *
	 *	@return	The required IMCFKeyHash256 attribute MinorVersionId.
	 */
	IMCFKeyHash256 getRequiredMinorVersionId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param value The required String attribute Name value to be applied.
	 */
	void setRequiredName(String value);

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The optional String attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Set the optional String attribute DbName.
	 *
	 *	@param value The optional String attribute DbName value to be applied.
	 */
	void setOptionalDbName(String value);

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Set the optional String attribute ShortName.
	 *
	 *	@param value The optional String attribute ShortName value to be applied.
	 */
	void setOptionalShortName(String value);

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Set the optional String attribute Label.
	 *
	 *	@param value The optional String attribute Label value to be applied.
	 */
	void setOptionalLabel(String value);

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Set the optional String attribute ShortDescription.
	 *
	 *	@param value The optional String attribute ShortDescription value to be applied.
	 */
	void setOptionalShortDescription(String value);

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Set the optional String attribute Description.
	 *
	 *	@param value The optional String attribute Description value to be applied.
	 */
	void setOptionalDescription(String value);

	/**
	 *	Get the required String attribute CopyrightPeriod.
	 *
	 *	@return	The required String attribute CopyrightPeriod.
	 */
	String getRequiredCopyrightPeriod();

	/**
	 *	Set the required String attribute CopyrightPeriod.
	 *
	 *	@param value The required String attribute CopyrightPeriod value to be applied.
	 */
	void setRequiredCopyrightPeriod(String value);

	/**
	 *	Get the required String attribute CopyrightHolder.
	 *
	 *	@return	The required String attribute CopyrightHolder.
	 */
	String getRequiredCopyrightHolder();

	/**
	 *	Set the required String attribute CopyrightHolder.
	 *
	 *	@param value The required String attribute CopyrightHolder value to be applied.
	 */
	void setRequiredCopyrightHolder(String value);

	/**
	 *	Get the required String attribute AuthorEMail.
	 *
	 *	@return	The required String attribute AuthorEMail.
	 */
	String getRequiredAuthorEMail();

	/**
	 *	Set the required String attribute AuthorEMail.
	 *
	 *	@param value The required String attribute AuthorEMail value to be applied.
	 */
	void setRequiredAuthorEMail(String value);

	/**
	 *	Get the required String attribute ProjectURL.
	 *
	 *	@return	The required String attribute ProjectURL.
	 */
	String getRequiredProjectURL();

	/**
	 *	Set the required String attribute ProjectURL.
	 *
	 *	@param value The required String attribute ProjectURL value to be applied.
	 */
	void setRequiredProjectURL(String value);

	/**
	 *	Get the required String attribute PublishURI.
	 *
	 *	@return	The required String attribute PublishURI.
	 */
	String getRequiredPublishURI();

	/**
	 *	Set the required String attribute PublishURI.
	 *
	 *	@param value The required String attribute PublishURI value to be applied.
	 */
	void setRequiredPublishURI(String value);

}
