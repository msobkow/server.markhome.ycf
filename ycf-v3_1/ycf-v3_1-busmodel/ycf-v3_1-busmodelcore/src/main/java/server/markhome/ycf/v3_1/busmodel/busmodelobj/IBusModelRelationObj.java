// Description: Java 25 Object interface for BusModel Relation.

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

public interface IBusModelRelationObj
	extends IBusModelScopeObj
{
	/**
	 *	Get the current edition of this Relation instance as a IBusModelRelationEditObj.
	 *
	 *	@return	The IBusModelRelationEditObj edition of this instance.
	 */
	IBusModelRelationEditObj getEditAsRelation();

	/**
	 *	Get the IBusModelRelationTableObj table cache which manages this instance.
	 *
	 *	@return	IBusModelRelationTableObj table cache which manages this instance.
	 */
	IBusModelRelationTableObj getRelationTable();

	/**
	 *	Get the IBusModelRelation instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	IBusModelRelation instance which currently backs this object.
	 */
	IBusModelRelation getRelationRec();

	/**
	 *	Get the optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional IBusModelSchemaDefObj instance referenced by the DefSchema key.
	 */
	IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the required IBusModelTableObj instance referenced by the FromTable key.
	 *
	 *	@return	The required IBusModelTableObj instance referenced by the FromTable key.
	 */
	IBusModelTableObj getRequiredContainerFromTable();

	/**
	 *	Get the required IBusModelTableObj instance referenced by the FromTable key.
	 *
	 *	@return	The required IBusModelTableObj instance referenced by the FromTable key.
	 */
	IBusModelTableObj getRequiredContainerFromTable( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelRelationColObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional IBusModelRelationColObj[] array of instances referenced by the Columns key.
	 */
	List<IBusModelRelationColObj> getOptionalComponentsColumns();

	/**
	 *	Get the array of optional IBusModelRelationColObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional IBusModelRelationColObj[] array of instances referenced by the Columns key.
	 */
	List<IBusModelRelationColObj> getOptionalComponentsColumns( boolean forceRead );

	/**
	 *	Get the array of optional IBusModelPopTopDepObj array of instances referenced by the PopDep key.
	 *
	 *	@return	The optional IBusModelPopTopDepObj[] array of instances referenced by the PopDep key.
	 */
	List<IBusModelPopTopDepObj> getOptionalComponentsPopDep();

	/**
	 *	Get the array of optional IBusModelPopTopDepObj array of instances referenced by the PopDep key.
	 *
	 *	@return	The optional IBusModelPopTopDepObj[] array of instances referenced by the PopDep key.
	 */
	List<IBusModelPopTopDepObj> getOptionalComponentsPopDep( boolean forceRead );

	/**
	 *	Get the required IBusModelIndexObj instance referenced by the FromIndex key.
	 *
	 *	@return	The required IBusModelIndexObj instance referenced by the FromIndex key.
	 */
	IBusModelIndexObj getRequiredLookupFromIndex();

	/**
	 *	Get the required IBusModelIndexObj instance referenced by the FromIndex key.
	 *
	 *	@return	The required IBusModelIndexObj instance referenced by the FromIndex key.
	 */
	IBusModelIndexObj getRequiredLookupFromIndex( boolean forceRead );

	/**
	 *	Get the required IBusModelTableObj instance referenced by the ToTable key.
	 *
	 *	@return	The required IBusModelTableObj instance referenced by the ToTable key.
	 */
	IBusModelTableObj getRequiredLookupToTable();

	/**
	 *	Get the required IBusModelTableObj instance referenced by the ToTable key.
	 *
	 *	@return	The required IBusModelTableObj instance referenced by the ToTable key.
	 */
	IBusModelTableObj getRequiredLookupToTable( boolean forceRead );

	/**
	 *	Get the required IBusModelIndexObj instance referenced by the ToIndex key.
	 *
	 *	@return	The required IBusModelIndexObj instance referenced by the ToIndex key.
	 */
	IBusModelIndexObj getRequiredLookupToIndex();

	/**
	 *	Get the required IBusModelIndexObj instance referenced by the ToIndex key.
	 *
	 *	@return	The required IBusModelIndexObj instance referenced by the ToIndex key.
	 */
	IBusModelIndexObj getRequiredLookupToIndex( boolean forceRead );

	/**
	 *	Get the optional IBusModelRelationObj instance referenced by the Narrowed key.
	 *
	 *	@return	The optional IBusModelRelationObj instance referenced by the Narrowed key.
	 */
	IBusModelRelationObj getOptionalLookupNarrowed();

	/**
	 *	Get the optional IBusModelRelationObj instance referenced by the Narrowed key.
	 *
	 *	@return	The optional IBusModelRelationObj instance referenced by the Narrowed key.
	 */
	IBusModelRelationObj getOptionalLookupNarrowed( boolean forceRead );

	/**
	 *	Get the required IYCFKeyHash256 attribute TableId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute TableId.
	 */
	IYCFKeyHash256 getRequiredTableId();

	/**
	 *	Get the required IYCFKeyHash256 attribute Id.
	 *
	 *	@return	The required IYCFKeyHash256 attribute Id.
	 */
	IYCFKeyHash256 getRequiredId();

	/**
	 *	Get the optional IYCFKeyHash256 attribute DefSchemaId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute DefSchemaId.
	 */
	IYCFKeyHash256 getOptionalDefSchemaId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

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
	 *	Get the required IBusModelPubSchema.RelationTypeEnum attribute RelationType.
	 *
	 *	@return	The required IBusModelPubSchema.RelationTypeEnum attribute RelationType.
	 */
	IBusModelPubSchema.RelationTypeEnum getRequiredRelationType();

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The optional String attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Get the optional String attribute Suffix.
	 *
	 *	@return	The optional String attribute Suffix.
	 */
	String getOptionalSuffix();

	/**
	 *	Get the required IYCFKeyHash256 attribute FromIndexId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute FromIndexId.
	 */
	IYCFKeyHash256 getRequiredFromIndexId();

	/**
	 *	Get the required IYCFKeyHash256 attribute ToTableId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute ToTableId.
	 */
	IYCFKeyHash256 getRequiredToTableId();

	/**
	 *	Get the required IYCFKeyHash256 attribute ToIndexId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute ToIndexId.
	 */
	IYCFKeyHash256 getRequiredToIndexId();

	/**
	 *	Get the required boolean attribute IsRequired.
	 *
	 *	@return	The required boolean attribute IsRequired.
	 */
	boolean getRequiredIsRequired();

	/**
	 *	Get the required boolean attribute IsXsdContainer.
	 *
	 *	@return	The required boolean attribute IsXsdContainer.
	 */
	boolean getRequiredIsXsdContainer();

	/**
	 *	Get the required boolean attribute IsLateResolver.
	 *
	 *	@return	The required boolean attribute IsLateResolver.
	 */
	boolean getRequiredIsLateResolver();

	/**
	 *	Get the required boolean attribute AllowAddendum.
	 *
	 *	@return	The required boolean attribute AllowAddendum.
	 */
	boolean getRequiredAllowAddendum();

	/**
	 *	Get the optional IYCFKeyHash256 attribute NarrowedId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute NarrowedId.
	 */
	IYCFKeyHash256 getOptionalNarrowedId();

	/**
	 *	Get the required IBusModelPubSchema.CodeVisibilityEnum attribute CodeVis.
	 *
	 *	@return	The required IBusModelPubSchema.CodeVisibilityEnum attribute CodeVis.
	 */
	IBusModelPubSchema.CodeVisibilityEnum getRequiredCodeVis();

	IBusModelSubProjectObj getProject();
	IBusModelTopDomainObj getCompany();
	IBusModelSchemaDefObj getSchemaDef();
	IBusModelMinorVersionObj getVersion();
	String getVersionString();
	String getPackedVersionString();
	Boolean isColumnInOwnerRelation();

}
