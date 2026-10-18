// Description: Java 25 Object interface for BusModelPub SchemaDef.

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

public interface IBusModelPubSchemaDefObj
	extends IBusModelPubScopeObj
{
	/**
	 *	Get the current edition of this SchemaDef instance as a IBusModelPubSchemaDefEditObj.
	 *
	 *	@return	The IBusModelPubSchemaDefEditObj edition of this instance.
	 */
	IBusModelPubSchemaDefEditObj getEditAsSchemaDef();

	/**
	 *	Get the IBusModelPubSchemaDefTableObj table cache which manages this instance.
	 *
	 *	@return	IBusModelPubSchemaDefTableObj table cache which manages this instance.
	 */
	IBusModelPubSchemaDefTableObj getSchemaDefTable();

	/**
	 *	Get the IBusModelPubSchemaDef instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelPubSchemaDef instance which currently backs this object.
	 */
	IBusModelPubSchemaDef getSchemaDefRec();

	/**
	 *	Get the required IBusModelPubMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required IBusModelPubMinorVersionObj instance referenced by the MinorVersion key.
	 */
	IIntNetPubMinorVersionObj getRequiredContainerMinorVersion();

	/**
	 *	Get the required IIntNetPubMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required IIntNetPubMinorVersionObj instance referenced by the MinorVersion key.
	 */
	IIntNetPubMinorVersionObj getRequiredContainerMinorVersion( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional IBusModelPubTableObj[] array of instances referenced by the Tables key.
	 */
	List<IBusModelPubTableObj> getOptionalComponentsTables();

	/**
	 *	Get the array of optional IBusModelPubTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional IBusModelPubTableObj[] array of instances referenced by the Tables key.
	 */
	List<IBusModelPubTableObj> getOptionalComponentsTables( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional IBusModelPubValueObj[] array of instances referenced by the Types key.
	 */
	List<IBusModelPubValueObj> getOptionalComponentsTypes();

	/**
	 *	Get the array of optional IBusModelPubValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional IBusModelPubValueObj[] array of instances referenced by the Types key.
	 */
	List<IBusModelPubValueObj> getOptionalComponentsTypes( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional IBusModelPubSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<IBusModelPubSchemaRefObj> getOptionalComponentsSchemaRefs();

	/**
	 *	Get the array of optional IBusModelPubSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional IBusModelPubSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<IBusModelPubSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubTweakObj array of instances referenced by the Tweaks key.
	 *
	 *	@return	The optional IBusModelPubTweakObj[] array of instances referenced by the Tweaks key.
	 */
	List<IBusModelPubTweakObj> getOptionalComponentsTweaks();

	/**
	 *	Get the array of optional IBusModelPubTweakObj array of instances referenced by the Tweaks key.
	 *
	 *	@return	The optional IBusModelPubTweakObj[] array of instances referenced by the Tweaks key.
	 */
	List<IBusModelPubTweakObj> getOptionalComponentsTweaks( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubSchemaRoleObj array of instances referenced by the Roles key.
	 *
	 *	@return	The optional IBusModelPubSchemaRoleObj[] array of instances referenced by the Roles key.
	 */
	List<IBusModelPubSchemaRoleObj> getOptionalComponentsRoles();

	/**
	 *	Get the array of optional IBusModelPubSchemaRoleObj array of instances referenced by the Roles key.
	 *
	 *	@return	The optional IBusModelPubSchemaRoleObj[] array of instances referenced by the Roles key.
	 */
	List<IBusModelPubSchemaRoleObj> getOptionalComponentsRoles( boolean forceRead );

	/**
	 *	Get the required IBusModelPubTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required IBusModelPubTenantObj instance referenced by the CTenant key.
	 */
	ISecurePubTenantObj getRequiredOwnerCTenant();

	/**
	 *	Get the required ISecurePubTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ISecurePubTenantObj instance referenced by the CTenant key.
	 */
	ISecurePubTenantObj getRequiredOwnerCTenant( boolean forceRead );

	/**
	 *	Get the required YCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute Id.
	 */
	YCFDbKeyHash256 getRequiredId();

	/**
	 *	Get the required YCFDbKeyHash256 attribute CTenantId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute CTenantId.
	 */
	YCFDbKeyHash256 getRequiredCTenantId();

	/**
	 *	Get the required YCFDbKeyHash256 attribute MinorVersionId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute MinorVersionId.
	 */
	YCFDbKeyHash256 getRequiredMinorVersionId();

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
