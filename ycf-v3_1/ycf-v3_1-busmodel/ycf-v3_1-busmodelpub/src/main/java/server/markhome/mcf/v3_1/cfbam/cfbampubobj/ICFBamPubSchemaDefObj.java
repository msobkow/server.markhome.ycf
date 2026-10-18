// Description: Java 25 Object interface for CFBamPub SchemaDef.

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

package server.markhome.mcf.v3_1.cfbam.cfbampubobj;

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
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;

public interface ICFBamPubSchemaDefObj
	extends ICFBamPubScopeObj
{
	/**
	 *	Get the current edition of this SchemaDef instance as a ICFBamPubSchemaDefEditObj.
	 *
	 *	@return	The ICFBamPubSchemaDefEditObj edition of this instance.
	 */
	ICFBamPubSchemaDefEditObj getEditAsSchemaDef();

	/**
	 *	Get the ICFBamPubSchemaDefTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamPubSchemaDefTableObj table cache which manages this instance.
	 */
	ICFBamPubSchemaDefTableObj getSchemaDefTable();

	/**
	 *	Get the ICFBamPubSchemaDef instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ICFBamPubSchemaDef instance which currently backs this object.
	 */
	ICFBamPubSchemaDef getSchemaDefRec();

	/**
	 *	Get the required ICFBamPubMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required ICFBamPubMinorVersionObj instance referenced by the MinorVersion key.
	 */
	ICFIntPubMinorVersionObj getRequiredContainerMinorVersion();

	/**
	 *	Get the required ICFIntPubMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required ICFIntPubMinorVersionObj instance referenced by the MinorVersion key.
	 */
	ICFIntPubMinorVersionObj getRequiredContainerMinorVersion( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional ICFBamPubTableObj[] array of instances referenced by the Tables key.
	 */
	List<ICFBamPubTableObj> getOptionalComponentsTables();

	/**
	 *	Get the array of optional ICFBamPubTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional ICFBamPubTableObj[] array of instances referenced by the Tables key.
	 */
	List<ICFBamPubTableObj> getOptionalComponentsTables( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional ICFBamPubValueObj[] array of instances referenced by the Types key.
	 */
	List<ICFBamPubValueObj> getOptionalComponentsTypes();

	/**
	 *	Get the array of optional ICFBamPubValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional ICFBamPubValueObj[] array of instances referenced by the Types key.
	 */
	List<ICFBamPubValueObj> getOptionalComponentsTypes( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional ICFBamPubSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<ICFBamPubSchemaRefObj> getOptionalComponentsSchemaRefs();

	/**
	 *	Get the array of optional ICFBamPubSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional ICFBamPubSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<ICFBamPubSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubTweakObj array of instances referenced by the Tweaks key.
	 *
	 *	@return	The optional ICFBamPubTweakObj[] array of instances referenced by the Tweaks key.
	 */
	List<ICFBamPubTweakObj> getOptionalComponentsTweaks();

	/**
	 *	Get the array of optional ICFBamPubTweakObj array of instances referenced by the Tweaks key.
	 *
	 *	@return	The optional ICFBamPubTweakObj[] array of instances referenced by the Tweaks key.
	 */
	List<ICFBamPubTweakObj> getOptionalComponentsTweaks( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubSchemaRoleObj array of instances referenced by the Roles key.
	 *
	 *	@return	The optional ICFBamPubSchemaRoleObj[] array of instances referenced by the Roles key.
	 */
	List<ICFBamPubSchemaRoleObj> getOptionalComponentsRoles();

	/**
	 *	Get the array of optional ICFBamPubSchemaRoleObj array of instances referenced by the Roles key.
	 *
	 *	@return	The optional ICFBamPubSchemaRoleObj[] array of instances referenced by the Roles key.
	 */
	List<ICFBamPubSchemaRoleObj> getOptionalComponentsRoles( boolean forceRead );

	/**
	 *	Get the required ICFBamPubTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ICFBamPubTenantObj instance referenced by the CTenant key.
	 */
	ICFSecPubTenantObj getRequiredOwnerCTenant();

	/**
	 *	Get the required ICFSecPubTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ICFSecPubTenantObj instance referenced by the CTenant key.
	 */
	ICFSecPubTenantObj getRequiredOwnerCTenant( boolean forceRead );

	/**
	 *	Get the required MCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute Id.
	 */
	MCFDbKeyHash256 getRequiredId();

	/**
	 *	Get the required MCFDbKeyHash256 attribute CTenantId.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute CTenantId.
	 */
	MCFDbKeyHash256 getRequiredCTenantId();

	/**
	 *	Get the required MCFDbKeyHash256 attribute MinorVersionId.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute MinorVersionId.
	 */
	MCFDbKeyHash256 getRequiredMinorVersionId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The optional String attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Get the required String attribute CopyrightPeriod.
	 *
	 *	@return	The required String attribute CopyrightPeriod.
	 */
	String getRequiredCopyrightPeriod();

	/**
	 *	Get the required String attribute CopyrightHolder.
	 *
	 *	@return	The required String attribute CopyrightHolder.
	 */
	String getRequiredCopyrightHolder();

	/**
	 *	Get the required String attribute AuthorEMail.
	 *
	 *	@return	The required String attribute AuthorEMail.
	 */
	String getRequiredAuthorEMail();

	/**
	 *	Get the required String attribute ProjectURL.
	 *
	 *	@return	The required String attribute ProjectURL.
	 */
	String getRequiredProjectURL();

	/**
	 *	Get the required String attribute PublishURI.
	 *
	 *	@return	The required String attribute PublishURI.
	 */
	String getRequiredPublishURI();

}
