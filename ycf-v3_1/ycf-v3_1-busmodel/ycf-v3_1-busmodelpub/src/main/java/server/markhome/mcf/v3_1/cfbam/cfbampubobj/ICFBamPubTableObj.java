// Description: Java 25 Object interface for CFBamPub Table.

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

public interface ICFBamPubTableObj
	extends ICFBamPubScopeObj
{
	/**
	 *	Get the current edition of this Table instance as a ICFBamPubTableEditObj.
	 *
	 *	@return	The ICFBamPubTableEditObj edition of this instance.
	 */
	ICFBamPubTableEditObj getEditAsTable();

	/**
	 *	Get the ICFBamPubTableTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamPubTableTableObj table cache which manages this instance.
	 */
	ICFBamPubTableTableObj getTableTable();

	/**
	 *	Get the ICFBamPubTable instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ICFBamPubTable instance which currently backs this object.
	 */
	ICFBamPubTable getTableRec();

	/**
	 *	Get the required ICFBamPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required ICFBamPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamPubSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Get the required ICFBamPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required ICFBamPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamPubSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead );

	/**
	 *	Get the optional ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamPubSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamPubSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubRelationObj array of instances referenced by the Relation key.
	 *
	 *	@return	The optional ICFBamPubRelationObj[] array of instances referenced by the Relation key.
	 */
	List<ICFBamPubRelationObj> getOptionalComponentsRelation();

	/**
	 *	Get the array of optional ICFBamPubRelationObj array of instances referenced by the Relation key.
	 *
	 *	@return	The optional ICFBamPubRelationObj[] array of instances referenced by the Relation key.
	 */
	List<ICFBamPubRelationObj> getOptionalComponentsRelation( boolean forceRead );

	/**
	 *	Get the optional ICFBamPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional ICFBamPubIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupLookupIndex();

	/**
	 *	Get the optional ICFBamPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional ICFBamPubIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupLookupIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional ICFBamPubIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupAltIndex();

	/**
	 *	Get the optional ICFBamPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional ICFBamPubIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupAltIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamPubTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional ICFBamPubTableObj instance referenced by the QualTable key.
	 */
	ICFBamPubTableObj getOptionalLookupQualTable();

	/**
	 *	Get the optional ICFBamPubTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional ICFBamPubTableObj instance referenced by the QualTable key.
	 */
	ICFBamPubTableObj getOptionalLookupQualTable( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubIndexObj array of instances referenced by the Index key.
	 *
	 *	@return	The optional ICFBamPubIndexObj[] array of instances referenced by the Index key.
	 */
	List<ICFBamPubIndexObj> getOptionalComponentsIndex();

	/**
	 *	Get the array of optional ICFBamPubIndexObj array of instances referenced by the Index key.
	 *
	 *	@return	The optional ICFBamPubIndexObj[] array of instances referenced by the Index key.
	 */
	List<ICFBamPubIndexObj> getOptionalComponentsIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional ICFBamPubIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupPrimaryIndex();

	/**
	 *	Get the optional ICFBamPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional ICFBamPubIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamPubIndexObj getOptionalLookupPrimaryIndex( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubValueObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamPubValueObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamPubValueObj> getOptionalComponentsColumns();

	/**
	 *	Get the array of optional ICFBamPubValueObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamPubValueObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamPubValueObj> getOptionalComponentsColumns( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubRelationObj array of instances referenced by the ReverseRelations key.
	 *
	 *	@return	The optional ICFBamPubRelationObj[] array of instances referenced by the ReverseRelations key.
	 */
	List<ICFBamPubRelationObj> getOptionalChildrenReverseRelations();

	/**
	 *	Get the array of optional ICFBamPubRelationObj array of instances referenced by the ReverseRelations key.
	 *
	 *	@return	The optional ICFBamPubRelationObj[] array of instances referenced by the ReverseRelations key.
	 */
	List<ICFBamPubRelationObj> getOptionalChildrenReverseRelations( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubChainObj array of instances referenced by the Chains key.
	 *
	 *	@return	The optional ICFBamPubChainObj[] array of instances referenced by the Chains key.
	 */
	List<ICFBamPubChainObj> getOptionalComponentsChains();

	/**
	 *	Get the array of optional ICFBamPubChainObj array of instances referenced by the Chains key.
	 *
	 *	@return	The optional ICFBamPubChainObj[] array of instances referenced by the Chains key.
	 */
	List<ICFBamPubChainObj> getOptionalComponentsChains( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubDelTopDepObj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamPubDelTopDepObj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamPubDelTopDepObj> getOptionalComponentsDelDep();

	/**
	 *	Get the array of optional ICFBamPubDelTopDepObj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamPubDelTopDepObj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamPubDelTopDepObj> getOptionalComponentsDelDep( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubClearTopDepObj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamPubClearTopDepObj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamPubClearTopDepObj> getOptionalComponentsClearDep();

	/**
	 *	Get the array of optional ICFBamPubClearTopDepObj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamPubClearTopDepObj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamPubClearTopDepObj> getOptionalComponentsClearDep( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubServerMethodObj array of instances referenced by the ServerMethods key.
	 *
	 *	@return	The optional ICFBamPubServerMethodObj[] array of instances referenced by the ServerMethods key.
	 */
	List<ICFBamPubServerMethodObj> getOptionalComponentsServerMethods();

	/**
	 *	Get the array of optional ICFBamPubServerMethodObj array of instances referenced by the ServerMethods key.
	 *
	 *	@return	The optional ICFBamPubServerMethodObj[] array of instances referenced by the ServerMethods key.
	 */
	List<ICFBamPubServerMethodObj> getOptionalComponentsServerMethods( boolean forceRead );

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
	 *	Get the required MCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute Id.
	 */
	MCFDbKeyHash256 getRequiredId();

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
	 *	Get the required boolean attribute PageData.
	 *
	 *	@return	The required boolean attribute PageData.
	 */
	boolean getRequiredPageData();

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
	 *	Get the required boolean attribute HasHistory.
	 *
	 *	@return	The required boolean attribute HasHistory.
	 */
	boolean getRequiredHasHistory();

	/**
	 *	Get the required boolean attribute HasAuditColumns.
	 *
	 *	@return	The required boolean attribute HasAuditColumns.
	 */
	boolean getRequiredHasAuditColumns();

	/**
	 *	Get the required boolean attribute IsMutable.
	 *
	 *	@return	The required boolean attribute IsMutable.
	 */
	boolean getRequiredIsMutable();

	/**
	 *	Get the required boolean attribute IsServerOnly.
	 *
	 *	@return	The required boolean attribute IsServerOnly.
	 */
	boolean getRequiredIsServerOnly();

	/**
	 *	Get the required ICFBamPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 *
	 *	@return	The required ICFBamPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 */
	ICFBamPubSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour();

	/**
	 *	Get the required ICFBamPubSchema.SecScopeEnum attribute SecScope.
	 *
	 *	@return	The required ICFBamPubSchema.SecScopeEnum attribute SecScope.
	 */
	ICFBamPubSchema.SecScopeEnum getRequiredSecScope();

	/**
	 *	Get the required ICFBamPubSchema.CodeVisibilityEnum attribute CodeVis.
	 *
	 *	@return	The required ICFBamPubSchema.CodeVisibilityEnum attribute CodeVis.
	 */
	ICFBamPubSchema.CodeVisibilityEnum getRequiredCodeVis();

}
