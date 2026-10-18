// Description: Java 25 Object interface for BusModelPub Table.

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

public interface IBusModelPubTableObj
	extends IBusModelPubScopeObj
{
	/**
	 *	Get the current edition of this Table instance as a IBusModelPubTableEditObj.
	 *
	 *	@return	The IBusModelPubTableEditObj edition of this instance.
	 */
	IBusModelPubTableEditObj getEditAsTable();

	/**
	 *	Get the IBusModelPubTableTableObj table cache which manages this instance.
	 *
	 *	@return	IBusModelPubTableTableObj table cache which manages this instance.
	 */
	IBusModelPubTableTableObj getTableTable();

	/**
	 *	Get the IBusModelPubTable instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelPubTable instance which currently backs this object.
	 */
	IBusModelPubTable getTableRec();

	/**
	 *	Get the required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	IBusModelPubSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Get the required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required IBusModelPubSchemaDefObj instance referenced by the SchemaDef key.
	 */
	IBusModelPubSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead );

	/**
	 *	Get the optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelPubSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelPubSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelPubSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubRelationObj array of instances referenced by the Relation key.
	 *
	 *	@return	The optional IBusModelPubRelationObj[] array of instances referenced by the Relation key.
	 */
	List<IBusModelPubRelationObj> getOptionalComponentsRelation();

	/**
	 *	Get the array of optional IBusModelPubRelationObj array of instances referenced by the Relation key.
	 *
	 *	@return	The optional IBusModelPubRelationObj[] array of instances referenced by the Relation key.
	 */
	List<IBusModelPubRelationObj> getOptionalComponentsRelation( boolean forceRead );

	/**
	 *	Get the optional IBusModelPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional IBusModelPubIndexObj instance referenced by the LookupIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupLookupIndex();

	/**
	 *	Get the optional IBusModelPubIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional IBusModelPubIndexObj instance referenced by the LookupIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupLookupIndex( boolean forceRead );

	/**
	 *	Get the optional IBusModelPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional IBusModelPubIndexObj instance referenced by the AltIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupAltIndex();

	/**
	 *	Get the optional IBusModelPubIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional IBusModelPubIndexObj instance referenced by the AltIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupAltIndex( boolean forceRead );

	/**
	 *	Get the optional IBusModelPubTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional IBusModelPubTableObj instance referenced by the QualTable key.
	 */
	IBusModelPubTableObj getOptionalLookupQualTable();

	/**
	 *	Get the optional IBusModelPubTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional IBusModelPubTableObj instance referenced by the QualTable key.
	 */
	IBusModelPubTableObj getOptionalLookupQualTable( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubIndexObj array of instances referenced by the Index key.
	 *
	 *	@return	The optional IBusModelPubIndexObj[] array of instances referenced by the Index key.
	 */
	List<IBusModelPubIndexObj> getOptionalComponentsIndex();

	/**
	 *	Get the array of optional IBusModelPubIndexObj array of instances referenced by the Index key.
	 *
	 *	@return	The optional IBusModelPubIndexObj[] array of instances referenced by the Index key.
	 */
	List<IBusModelPubIndexObj> getOptionalComponentsIndex( boolean forceRead );

	/**
	 *	Get the optional IBusModelPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional IBusModelPubIndexObj instance referenced by the PrimaryIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupPrimaryIndex();

	/**
	 *	Get the optional IBusModelPubIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional IBusModelPubIndexObj instance referenced by the PrimaryIndex key.
	 */
	IBusModelPubIndexObj getOptionalLookupPrimaryIndex( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubValueObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional IBusModelPubValueObj[] array of instances referenced by the Columns key.
	 */
	List<IBusModelPubValueObj> getOptionalComponentsColumns();

	/**
	 *	Get the array of optional IBusModelPubValueObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional IBusModelPubValueObj[] array of instances referenced by the Columns key.
	 */
	List<IBusModelPubValueObj> getOptionalComponentsColumns( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubRelationObj array of instances referenced by the ReverseRelations key.
	 *
	 *	@return	The optional IBusModelPubRelationObj[] array of instances referenced by the ReverseRelations key.
	 */
	List<IBusModelPubRelationObj> getOptionalChildrenReverseRelations();

	/**
	 *	Get the array of optional IBusModelPubRelationObj array of instances referenced by the ReverseRelations key.
	 *
	 *	@return	The optional IBusModelPubRelationObj[] array of instances referenced by the ReverseRelations key.
	 */
	List<IBusModelPubRelationObj> getOptionalChildrenReverseRelations( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubChainObj array of instances referenced by the Chains key.
	 *
	 *	@return	The optional IBusModelPubChainObj[] array of instances referenced by the Chains key.
	 */
	List<IBusModelPubChainObj> getOptionalComponentsChains();

	/**
	 *	Get the array of optional IBusModelPubChainObj array of instances referenced by the Chains key.
	 *
	 *	@return	The optional IBusModelPubChainObj[] array of instances referenced by the Chains key.
	 */
	List<IBusModelPubChainObj> getOptionalComponentsChains( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubDelTopDepObj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional IBusModelPubDelTopDepObj[] array of instances referenced by the DelDep key.
	 */
	List<IBusModelPubDelTopDepObj> getOptionalComponentsDelDep();

	/**
	 *	Get the array of optional IBusModelPubDelTopDepObj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional IBusModelPubDelTopDepObj[] array of instances referenced by the DelDep key.
	 */
	List<IBusModelPubDelTopDepObj> getOptionalComponentsDelDep( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubClearTopDepObj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional IBusModelPubClearTopDepObj[] array of instances referenced by the ClearDep key.
	 */
	List<IBusModelPubClearTopDepObj> getOptionalComponentsClearDep();

	/**
	 *	Get the array of optional IBusModelPubClearTopDepObj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional IBusModelPubClearTopDepObj[] array of instances referenced by the ClearDep key.
	 */
	List<IBusModelPubClearTopDepObj> getOptionalComponentsClearDep( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPubServerMethodObj array of instances referenced by the ServerMethods key.
	 *
	 *	@return	The optional IBusModelPubServerMethodObj[] array of instances referenced by the ServerMethods key.
	 */
	List<IBusModelPubServerMethodObj> getOptionalComponentsServerMethods();

	/**
	 *	Get the array of optional IBusModelPubServerMethodObj array of instances referenced by the ServerMethods key.
	 *
	 *	@return	The optional IBusModelPubServerMethodObj[] array of instances referenced by the ServerMethods key.
	 */
	List<IBusModelPubServerMethodObj> getOptionalComponentsServerMethods( boolean forceRead );

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
	 *	Get the required YCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute Id.
	 */
	YCFDbKeyHash256 getRequiredId();

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
	 *	Get the required IBusModelPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 *
	 *	@return	The required IBusModelPubSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 */
	IBusModelPubSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour();

	/**
	 *	Get the required IBusModelPubSchema.SecScopeEnum attribute SecScope.
	 *
	 *	@return	The required IBusModelPubSchema.SecScopeEnum attribute SecScope.
	 */
	IBusModelPubSchema.SecScopeEnum getRequiredSecScope();

	/**
	 *	Get the required IBusModelPubSchema.CodeVisibilityEnum attribute CodeVis.
	 *
	 *	@return	The required IBusModelPubSchema.CodeVisibilityEnum attribute CodeVis.
	 */
	IBusModelPubSchema.CodeVisibilityEnum getRequiredCodeVis();

}
