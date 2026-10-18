// Description: Java 25 Public Instance Edit Object interface for BusModel Table.

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
import org.apache.commons.text.StringEscapeUtils;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IBusModelPubTableEditObj
	extends IBusModelPubTableObj, IBusModelPubScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IBusModelPubTableObj.
	 */
	IBusModelPubTableObj getOrigAsTable();

	/**
	 *	Get the IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	IBusModelPubSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Get the required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	IBusModelPubSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead );

	/**
	 *	Set the IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@param	value	the IBusModelPubSchemaDefObj instance to be referenced by the SchemaDef key.
	 */
	void setRequiredContainerSchemaDef( IBusModelPubSchemaDefObj value );

	/**
	 *	Get the IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelPubSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelPubSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Set the IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@param	value	the IBusModelPubSchemaDefObj instance to be referenced by the DefSchema key.
	 */
	void setOptionalLookupDefSchema( IBusModelPubSchemaDefObj value );

	/**
	 *	Get a list IBusModelPubRelationObj instances referenced by the Relation key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubRelationObj instances referenced by the Relation key.
	 */
	List<IBusModelPubRelationObj> getOptionalComponentsRelation();

	/**
	 *	Get the IBusModelPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The IBusModelPubIndexObj instance referenced by the LookupIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupLookupIndex();

	/**
	 *	Get the optional IBusModelPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional IBusModelPubIndexObj instance referenced by the LookupIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupLookupIndex( boolean forceRead );

	/**
	 *	Set the IBusModelPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@param	value	the IBusModelPubIndexObj instance to be referenced by the LookupIndex key.
	 */
	void setOptionalLookupLookupIndex( IBusModelPubIndexObj value );

	/**
	 *	Get the IBusModelPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The IBusModelPubIndexObj instance referenced by the AltIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupAltIndex();

	/**
	 *	Get the optional IBusModelPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional IBusModelPubIndexObj instance referenced by the AltIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupAltIndex( boolean forceRead );

	/**
	 *	Set the IBusModelPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@param	value	the IBusModelPubIndexObj instance to be referenced by the AltIndex key.
	 */
	void setOptionalLookupAltIndex( IBusModelPubIndexObj value );

	/**
	 *	Get the IBusModelPubTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The IBusModelPubTableObj instance referenced by the QualTable key.
	 */
	IBusModelPubTableObj getOptionalLookupQualTable();

	/**
	 *	Get the optional IBusModelPubTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional IBusModelPubTableObj instance referenced by the QualTable key.
	 */
	IBusModelPubTableObj getOptionalLookupQualTable( boolean forceRead );

	/**
	 *	Set the IBusModelPubTableObj instance referenced by the QualTable key.
	 *
	 *	@param	value	the IBusModelPubTableObj instance to be referenced by the QualTable key.
	 */
	void setOptionalLookupQualTable( IBusModelPubTableObj value );

	/**
	 *	Get a list IBusModelPubIndexObj instances referenced by the Index key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubIndexObj instances referenced by the Index key.
	 */
	List<IBusModelPubIndexObj> getOptionalComponentsIndex();

	/**
	 *	Get the IBusModelPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The IBusModelPubIndexObj instance referenced by the PrimaryIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupPrimaryIndex();

	/**
	 *	Get the optional IBusModelPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional IBusModelPubIndexObj instance referenced by the PrimaryIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupPrimaryIndex( boolean forceRead );

	/**
	 *	Set the IBusModelPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@param	value	the IBusModelPubIndexObj instance to be referenced by the PrimaryIndex key.
	 */
	void setOptionalLookupPrimaryIndex( IBusModelPubIndexObj value );

	/**
	 *	Get a list IBusModelPubValueObj instances referenced by the Columns key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubValueObj instances referenced by the Columns key.
	 */
	List<IBusModelPubValueObj> getOptionalComponentsColumns();

	/**
	 *	Get a list IBusModelPubRelationObj instances referenced by the ReverseRelations key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubRelationObj instances referenced by the ReverseRelations key.
	 */
	List<IBusModelPubRelationObj> getOptionalChildrenReverseRelations();

	/**
	 *	Get a list IBusModelPubChainObj instances referenced by the Chains key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubChainObj instances referenced by the Chains key.
	 */
	List<IBusModelPubChainObj> getOptionalComponentsChains();

	/**
	 *	Get a list IBusModelPubDelTopDepObj instances referenced by the DelDep key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubDelTopDepObj instances referenced by the DelDep key.
	 */
	List<IBusModelPubDelTopDepObj> getOptionalComponentsDelDep();

	/**
	 *	Get a list IBusModelPubClearTopDepObj instances referenced by the ClearDep key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubClearTopDepObj instances referenced by the ClearDep key.
	 */
	List<IBusModelPubClearTopDepObj> getOptionalComponentsClearDep();

	/**
	 *	Get a list IBusModelPubServerMethodObj instances referenced by the ServerMethods key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubServerMethodObj instances referenced by the ServerMethods key.
	 */
	List<IBusModelPubServerMethodObj> getOptionalComponentsServerMethods();

	/**
	 *	Get a list IBusModelPubTweakObj instances referenced by the Tweaks key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubTweakObj instances referenced by the Tweaks key.
	 */
	List<IBusModelPubTweakObj> getOptionalComponentsTweaks();

	/**
	 *	Get the required YCFDbKeyHash256 attribute SchemaDefId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute SchemaDefId.
	 */
	YCFDbKeyHash256 getRequiredSchemaDefId();

	/**
	 *	Get the optional YCFDbKeyHash256 attribute DefSchemaId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute DefSchemaId.
	 */
	YCFDbKeyHash256 getOptionalDefSchemaId();

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
	 *	Get the required boolean attribute PageData.
	 *
	 *	@return	The required boolean attribute PageData.
	 */
	boolean getRequiredPageData();

	/**
	 *	Set the required boolean attribute PageData.
	 *
	 *	@param value The required boolean attribute PageData value to be applied.
	 */
	void setRequiredPageData(boolean value);

	/**
	 *	Get the optional YCFDbKeyHash256 attribute PrimaryIndexId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute PrimaryIndexId.
	 */
	YCFDbKeyHash256 getOptionalPrimaryIndexId();

	/**
	 *	Get the required String attribute TableClassCode.
	 *
	 *	@return	The required String attribute TableClassCode.
	 */
	String getRequiredTableClassCode();

	/**
	 *	Set the required String attribute TableClassCode.
	 *
	 *	@param value The required String attribute TableClassCode value to be applied.
	 */
	void setRequiredTableClassCode(String value);

	/**
	 *	Get the optional YCFDbKeyHash256 attribute LookupIndexId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute LookupIndexId.
	 */
	YCFDbKeyHash256 getOptionalLookupIndexId();

	/**
	 *	Get the optional YCFDbKeyHash256 attribute AltIndexId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute AltIndexId.
	 */
	YCFDbKeyHash256 getOptionalAltIndexId();

	/**
	 *	Get the optional YCFDbKeyHash256 attribute QualifyingTableId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute QualifyingTableId.
	 */
	YCFDbKeyHash256 getOptionalQualifyingTableId();

	/**
	 *	Get the required boolean attribute IsInstantiable.
	 *
	 *	@return	The required boolean attribute IsInstantiable.
	 */
	boolean getRequiredIsInstantiable();

	/**
	 *	Set the required boolean attribute IsInstantiable.
	 *
	 *	@param value The required boolean attribute IsInstantiable value to be applied.
	 */
	void setRequiredIsInstantiable(boolean value);

	/**
	 *	Get the required boolean attribute HasHistory.
	 *
	 *	@return	The required boolean attribute HasHistory.
	 */
	boolean getRequiredHasHistory();

	/**
	 *	Set the required boolean attribute HasHistory.
	 *
	 *	@param value The required boolean attribute HasHistory value to be applied.
	 */
	void setRequiredHasHistory(boolean value);

	/**
	 *	Get the required boolean attribute HasAuditColumns.
	 *
	 *	@return	The required boolean attribute HasAuditColumns.
	 */
	boolean getRequiredHasAuditColumns();

	/**
	 *	Set the required boolean attribute HasAuditColumns.
	 *
	 *	@param value The required boolean attribute HasAuditColumns value to be applied.
	 */
	void setRequiredHasAuditColumns(boolean value);

	/**
	 *	Get the required boolean attribute IsMutable.
	 *
	 *	@return	The required boolean attribute IsMutable.
	 */
	boolean getRequiredIsMutable();

	/**
	 *	Set the required boolean attribute IsMutable.
	 *
	 *	@param value The required boolean attribute IsMutable value to be applied.
	 */
	void setRequiredIsMutable(boolean value);

	/**
	 *	Get the required boolean attribute IsServerOnly.
	 *
	 *	@return	The required boolean attribute IsServerOnly.
	 */
	boolean getRequiredIsServerOnly();

	/**
	 *	Set the required boolean attribute IsServerOnly.
	 *
	 *	@param value The required boolean attribute IsServerOnly value to be applied.
	 */
	void setRequiredIsServerOnly(boolean value);

	/**
	 *	Get the required IBusModelPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 *
	 *	@return	The required IBusModelPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 */
	IBusModelPubSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour();

	/**
	 *	Set the required IBusModelPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 *
	 *	@param value The required IBusModelPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour value to be applied.
	 */
	void setRequiredLoaderBehaviour(IBusModelPubSchema.LoaderBehaviourEnum value);

	/**
	 *	Get the required IBusModelPubSchema.SecScopeEnum attribute SecScope.
	 *
	 *	@return	The required IBusModelPubSchema.SecScopeEnum attribute SecScope.
	 */
	IBusModelPubSchema.SecScopeEnum getRequiredSecScope();

	/**
	 *	Set the required IBusModelPubSchema.SecScopeEnum attribute SecScope.
	 *
	 *	@param value The required IBusModelPubSchema.SecScopeEnum attribute SecScope value to be applied.
	 */
	void setRequiredSecScope(IBusModelPubSchema.SecScopeEnum value);

	/**
	 *	Get the required IBusModelPubSchema.CodeVisibilityEnum attribute CodeVis.
	 *
	 *	@return	The required IBusModelPubSchema.CodeVisibilityEnum attribute CodeVis.
	 */
	IBusModelPubSchema.CodeVisibilityEnum getRequiredCodeVis();

	/**
	 *	Set the required IBusModelPubSchema.CodeVisibilityEnum attribute CodeVis.
	 *
	 *	@param value The required IBusModelPubSchema.CodeVisibilityEnum attribute CodeVis value to be applied.
	 */
	void setRequiredCodeVis(IBusModelPubSchema.CodeVisibilityEnum value);

}
