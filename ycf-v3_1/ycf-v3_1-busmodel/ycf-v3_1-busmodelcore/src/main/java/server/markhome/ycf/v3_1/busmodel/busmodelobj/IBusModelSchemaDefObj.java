// Description: Java 25 Object interface for BusModel SchemaDef.

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

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public interface IBusModelSchemaDefObj
	extends IBusModelScopeObj
{
	/**
	 *	Get the current edition of this SchemaDef instance as a IBusModelSchemaDefEditObj.
	 *
	 *	@return	The IBusModelSchemaDefEditObj edition of this instance.
	 */
	IBusModelSchemaDefEditObj getEditAsSchemaDef();

	/**
	 *	Get the IBusModelSchemaDefTableObj table cache which manages this instance.
	 *
	 *	@return	IBusModelSchemaDefTableObj table cache which manages this instance.
	 */
	IBusModelSchemaDefTableObj getSchemaDefTable();

	/**
	 *	Get the IBusModelSchemaDef instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelSchemaDef instance which currently backs this object.
	 */
	IBusModelSchemaDef getSchemaDefRec();

	/**
	 *	Get the required IBusModelMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required IBusModelMinorVersionObj instance referenced by the MinorVersion key.
	 */
	IIntNetMinorVersionObj getRequiredContainerMinorVersion();

	/**
	 *	Get the required IIntNetMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required IIntNetMinorVersionObj instance referenced by the MinorVersion key.
	 */
	IIntNetMinorVersionObj getRequiredContainerMinorVersion( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional IBusModelTableObj[] array of instances referenced by the Tables key.
	 */
	List<IBusModelTableObj> getOptionalComponentsTables();

	/**
	 *	Get the array of optional IBusModelTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional IBusModelTableObj[] array of instances referenced by the Tables key.
	 */
	List<IBusModelTableObj> getOptionalComponentsTables( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional IBusModelValueObj[] array of instances referenced by the Types key.
	 */
	List<IBusModelValueObj> getOptionalComponentsTypes();

	/**
	 *	Get the array of optional IBusModelValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional IBusModelValueObj[] array of instances referenced by the Types key.
	 */
	List<IBusModelValueObj> getOptionalComponentsTypes( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional IBusModelSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<IBusModelSchemaRefObj> getOptionalComponentsSchemaRefs();

	/**
	 *	Get the array of optional IBusModelSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional IBusModelSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<IBusModelSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelTweakObj array of instances referenced by the Tweaks key.
	 *
	 *	@return	The optional IBusModelTweakObj[] array of instances referenced by the Tweaks key.
	 */
	List<IBusModelTweakObj> getOptionalComponentsTweaks();

	/**
	 *	Get the array of optional IBusModelTweakObj array of instances referenced by the Tweaks key.
	 *
	 *	@return	The optional IBusModelTweakObj[] array of instances referenced by the Tweaks key.
	 */
	List<IBusModelTweakObj> getOptionalComponentsTweaks( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelSchemaRoleObj array of instances referenced by the Roles key.
	 *
	 *	@return	The optional IBusModelSchemaRoleObj[] array of instances referenced by the Roles key.
	 */
	List<IBusModelSchemaRoleObj> getOptionalComponentsRoles();

	/**
	 *	Get the array of optional IBusModelSchemaRoleObj array of instances referenced by the Roles key.
	 *
	 *	@return	The optional IBusModelSchemaRoleObj[] array of instances referenced by the Roles key.
	 */
	List<IBusModelSchemaRoleObj> getOptionalComponentsRoles( boolean forceRead );

	/**
	 *	Get the required IBusModelTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required IBusModelTenantObj instance referenced by the CTenant key.
	 */
	ISecureTenantObj getRequiredOwnerCTenant();

	/**
	 *	Get the required ISecureTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ISecureTenantObj instance referenced by the CTenant key.
	 */
	ISecureTenantObj getRequiredOwnerCTenant( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute Id.
	 *
	 *	@return	The required IYCFKeyHash256 attribute Id.
	 */
	IYCFKeyHash256 getRequiredId();

	/**
	 *	Get the required IYCFKeyHash256 attribute CTenantId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute CTenantId.
	 */
	IYCFKeyHash256 getRequiredCTenantId();

	/**
	 *	Get the required IYCFKeyHash256 attribute MinorVersionId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute MinorVersionId.
	 */
	IYCFKeyHash256 getRequiredMinorVersionId();

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
