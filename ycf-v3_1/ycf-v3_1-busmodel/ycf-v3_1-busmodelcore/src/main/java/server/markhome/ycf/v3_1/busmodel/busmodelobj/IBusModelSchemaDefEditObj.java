// Description: Java 25 Instance Edit Object interface for BusModel SchemaDef.

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
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public interface IBusModelSchemaDefEditObj
	extends IBusModelSchemaDefObj, IBusModelScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IBusModelSchemaDefObj.
	 */
	IBusModelSchemaDefObj getOrigAsSchemaDef();

	/**
	 *	Get the IIntNetMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The IIntNetMinorVersionObj instance referenced by the MinorVersion key.
	 */
	IIntNetMinorVersionObj getRequiredContainerMinorVersion();

	/**
	 *	Get the required IIntNetMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required IIntNetMinorVersionObj instance referenced by the MinorVersion key.
	 */
	IIntNetMinorVersionObj getRequiredContainerMinorVersion( boolean forceRead );

	/**
	 *	Set the IIntNetMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@param	value	the IIntNetMinorVersionObj instance to be referenced by the MinorVersion key.
	 */
	void setRequiredContainerMinorVersion( IIntNetMinorVersionObj value );

	/**
	 *	Get a list IBusModelTableObj instances referenced by the Tables key.
	 *
	 *	@return	The (potentially empty) list of IBusModelTableObj instances referenced by the Tables key.
	 */
	List<IBusModelTableObj> getOptionalComponentsTables();

	/**
	 *	Get a list IBusModelValueObj instances referenced by the Types key.
	 *
	 *	@return	The (potentially empty) list of IBusModelValueObj instances referenced by the Types key.
	 */
	List<IBusModelValueObj> getOptionalComponentsTypes();

	/**
	 *	Get a list IBusModelSchemaRefObj instances referenced by the SchemaRefs key.
	 *
	 *	@return	The (potentially empty) list of IBusModelSchemaRefObj instances referenced by the SchemaRefs key.
	 */
	List<IBusModelSchemaRefObj> getOptionalComponentsSchemaRefs();

	/**
	 *	Get a list IBusModelTweakObj instances referenced by the Tweaks key.
	 *
	 *	@return	The (potentially empty) list of IBusModelTweakObj instances referenced by the Tweaks key.
	 */
	List<IBusModelTweakObj> getOptionalComponentsTweaks();

	/**
	 *	Get a list IBusModelSchemaRoleObj instances referenced by the Roles key.
	 *
	 *	@return	The (potentially empty) list of IBusModelSchemaRoleObj instances referenced by the Roles key.
	 */
	List<IBusModelSchemaRoleObj> getOptionalComponentsRoles();

	/**
	 *	Get the ISecureTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The ISecureTenantObj instance referenced by the CTenant key.
	 */
	ISecureTenantObj getRequiredOwnerCTenant();

	/**
	 *	Get the required ISecureTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ISecureTenantObj instance referenced by the CTenant key.
	 */
	ISecureTenantObj getRequiredOwnerCTenant( boolean forceRead );

	/**
	 *	Set the ISecureTenantObj instance referenced by the CTenant key.
	 *
	 *	@param	value	the ISecureTenantObj instance to be referenced by the CTenant key.
	 */
	void setRequiredOwnerCTenant( ISecureTenantObj value );

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
