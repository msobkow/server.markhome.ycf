// Description: Java 25 Public Instance Edit Object interface for CFBam Table.

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
import org.apache.commons.text.StringEscapeUtils;

import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;

public interface ICFBamPubTableEditObj
	extends ICFBamPubTableObj, ICFBamPubScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamPubTableObj.
	 */
	ICFBamPubTableObj getOrigAsTable();

	/**
	 *	Get the ICFBamPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The ICFBamPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamPubSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Get the required ICFBamPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required ICFBamPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamPubSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead );

	/**
	 *	Set the ICFBamPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@param	value	the ICFBamPubSchemaDefObj instance to be referenced by the SchemaDef key.
	 */
	void setRequiredContainerSchemaDef( ICFBamPubSchemaDefObj value );

	/**
	 *	Get the ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamPubSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamPubSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Set the ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@param	value	the ICFBamPubSchemaDefObj instance to be referenced by the DefSchema key.
	 */
	void setOptionalLookupDefSchema( ICFBamPubSchemaDefObj value );

	/**
	 *	Get a list ICFBamPubRelationObj instances referenced by the Relation key.
	 *
	 *	@return	The (potentially empty) list of ICFBamPubRelationObj instances referenced by the Relation key.
	 */
	List<ICFBamPubRelationObj> getOptionalComponentsRelation();

	/**
	 *	Get the ICFBamPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The ICFBamPubIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupLookupIndex();

	/**
	 *	Get the optional ICFBamPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional ICFBamPubIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupLookupIndex( boolean forceRead );

	/**
	 *	Set the ICFBamPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@param	value	the ICFBamPubIndexObj instance to be referenced by the LookupIndex key.
	 */
	void setOptionalLookupLookupIndex( ICFBamPubIndexObj value );

	/**
	 *	Get the ICFBamPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The ICFBamPubIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupAltIndex();

	/**
	 *	Get the optional ICFBamPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional ICFBamPubIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupAltIndex( boolean forceRead );

	/**
	 *	Set the ICFBamPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@param	value	the ICFBamPubIndexObj instance to be referenced by the AltIndex key.
	 */
	void setOptionalLookupAltIndex( ICFBamPubIndexObj value );

	/**
	 *	Get the ICFBamPubTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The ICFBamPubTableObj instance referenced by the QualTable key.
	 */
	ICFBamPubTableObj getOptionalLookupQualTable();

	/**
	 *	Get the optional ICFBamPubTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional ICFBamPubTableObj instance referenced by the QualTable key.
	 */
	ICFBamPubTableObj getOptionalLookupQualTable( boolean forceRead );

	/**
	 *	Set the ICFBamPubTableObj instance referenced by the QualTable key.
	 *
	 *	@param	value	the ICFBamPubTableObj instance to be referenced by the QualTable key.
	 */
	void setOptionalLookupQualTable( ICFBamPubTableObj value );

	/**
	 *	Get a list ICFBamPubIndexObj instances referenced by the Index key.
	 *
	 *	@return	The (potentially empty) list of ICFBamPubIndexObj instances referenced by the Index key.
	 */
	List<ICFBamPubIndexObj> getOptionalComponentsIndex();

	/**
	 *	Get the ICFBamPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The ICFBamPubIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupPrimaryIndex();

	/**
	 *	Get the optional ICFBamPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional ICFBamPubIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupPrimaryIndex( boolean forceRead );

	/**
	 *	Set the ICFBamPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@param	value	the ICFBamPubIndexObj instance to be referenced by the PrimaryIndex key.
	 */
	void setOptionalLookupPrimaryIndex( ICFBamPubIndexObj value );

	/**
	 *	Get a list ICFBamPubValueObj instances referenced by the Columns key.
	 *
	 *	@return	The (potentially empty) list of ICFBamPubValueObj instances referenced by the Columns key.
	 */
	List<ICFBamPubValueObj> getOptionalComponentsColumns();

	/**
	 *	Get a list ICFBamPubRelationObj instances referenced by the ReverseRelations key.
	 *
	 *	@return	The (potentially empty) list of ICFBamPubRelationObj instances referenced by the ReverseRelations key.
	 */
	List<ICFBamPubRelationObj> getOptionalChildrenReverseRelations();

	/**
	 *	Get a list ICFBamPubChainObj instances referenced by the Chains key.
	 *
	 *	@return	The (potentially empty) list of ICFBamPubChainObj instances referenced by the Chains key.
	 */
	List<ICFBamPubChainObj> getOptionalComponentsChains();

	/**
	 *	Get a list ICFBamPubDelTopDepObj instances referenced by the DelDep key.
	 *
	 *	@return	The (potentially empty) list of ICFBamPubDelTopDepObj instances referenced by the DelDep key.
	 */
	List<ICFBamPubDelTopDepObj> getOptionalComponentsDelDep();

	/**
	 *	Get a list ICFBamPubClearTopDepObj instances referenced by the ClearDep key.
	 *
	 *	@return	The (potentially empty) list of ICFBamPubClearTopDepObj instances referenced by the ClearDep key.
	 */
	List<ICFBamPubClearTopDepObj> getOptionalComponentsClearDep();

	/**
	 *	Get a list ICFBamPubServerMethodObj instances referenced by the ServerMethods key.
	 *
	 *	@return	The (potentially empty) list of ICFBamPubServerMethodObj instances referenced by the ServerMethods key.
	 */
	List<ICFBamPubServerMethodObj> getOptionalComponentsServerMethods();

	/**
	 *	Get a list ICFBamPubTweakObj instances referenced by the Tweaks key.
	 *
	 *	@return	The (potentially empty) list of ICFBamPubTweakObj instances referenced by the Tweaks key.
	 */
	List<ICFBamPubTweakObj> getOptionalComponentsTweaks();

	/**
	 *	Get the required MCFDbKeyHash256 attribute SchemaDefId.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute SchemaDefId.
	 */
	MCFDbKeyHash256 getRequiredSchemaDefId();

	/**
	 *	Get the optional MCFDbKeyHash256 attribute DefSchemaId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute DefSchemaId.
	 */
	MCFDbKeyHash256 getOptionalDefSchemaId();

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
	 *	Get the optional MCFDbKeyHash256 attribute PrimaryIndexId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute PrimaryIndexId.
	 */
	MCFDbKeyHash256 getOptionalPrimaryIndexId();

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
	 *	Get the optional MCFDbKeyHash256 attribute LookupIndexId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute LookupIndexId.
	 */
	MCFDbKeyHash256 getOptionalLookupIndexId();

	/**
	 *	Get the optional MCFDbKeyHash256 attribute AltIndexId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute AltIndexId.
	 */
	MCFDbKeyHash256 getOptionalAltIndexId();

	/**
	 *	Get the optional MCFDbKeyHash256 attribute QualifyingTableId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute QualifyingTableId.
	 */
	MCFDbKeyHash256 getOptionalQualifyingTableId();

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
	 *	Get the required ICFBamPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 *
	 *	@return	The required ICFBamPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 */
	ICFBamPubSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour();

	/**
	 *	Set the required ICFBamPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 *
	 *	@param value The required ICFBamPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour value to be applied.
	 */
	void setRequiredLoaderBehaviour(ICFBamPubSchema.LoaderBehaviourEnum value);

	/**
	 *	Get the required ICFBamPubSchema.SecScopeEnum attribute SecScope.
	 *
	 *	@return	The required ICFBamPubSchema.SecScopeEnum attribute SecScope.
	 */
	ICFBamPubSchema.SecScopeEnum getRequiredSecScope();

	/**
	 *	Set the required ICFBamPubSchema.SecScopeEnum attribute SecScope.
	 *
	 *	@param value The required ICFBamPubSchema.SecScopeEnum attribute SecScope value to be applied.
	 */
	void setRequiredSecScope(ICFBamPubSchema.SecScopeEnum value);

	/**
	 *	Get the required ICFBamPubSchema.CodeVisibilityEnum attribute CodeVis.
	 *
	 *	@return	The required ICFBamPubSchema.CodeVisibilityEnum attribute CodeVis.
	 */
	ICFBamPubSchema.CodeVisibilityEnum getRequiredCodeVis();

	/**
	 *	Set the required ICFBamPubSchema.CodeVisibilityEnum attribute CodeVis.
	 *
	 *	@param value The required ICFBamPubSchema.CodeVisibilityEnum attribute CodeVis value to be applied.
	 */
	void setRequiredCodeVis(ICFBamPubSchema.CodeVisibilityEnum value);

}
