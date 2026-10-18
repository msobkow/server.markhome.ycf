// Description: Java 25 Public Instance Edit Object interface for BusModel Relation.

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

public interface IBusModelPubRelationEditObj
	extends IBusModelPubRelationObj, IBusModelPubScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IBusModelPubRelationObj.
	 */
	IBusModelPubRelationObj getOrigAsRelation();

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
	 *	Get the IBusModelPubTableObj instance referenced by the FromTable key.
	 *
	 *	@return	The IBusModelPubTableObj instance referenced by the FromTable key.
	 */
	IBusModelPubTableObj getRequiredContainerFromTable();

	/**
	 *	Get the required IBusModelPubTableObj instance referenced by the FromTable key.
	 *
	 *	@return	The required IBusModelPubTableObj instance referenced by the FromTable key.
	 */
	IBusModelPubTableObj getRequiredContainerFromTable( boolean forceRead );

	/**
	 *	Set the IBusModelPubTableObj instance referenced by the FromTable key.
	 *
	 *	@param	value	the IBusModelPubTableObj instance to be referenced by the FromTable key.
	 */
	void setRequiredContainerFromTable( IBusModelPubTableObj value );

	/**
	 *	Get a list IBusModelPubRelationColObj instances referenced by the Columns key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubRelationColObj instances referenced by the Columns key.
	 */
	List<IBusModelPubRelationColObj> getOptionalComponentsColumns();

	/**
	 *	Get a list IBusModelPubPopTopDepObj instances referenced by the PopDep key.
	 *
	 *	@return	The (potentially empty) list of IBusModelPubPopTopDepObj instances referenced by the PopDep key.
	 */
	List<IBusModelPubPopTopDepObj> getOptionalComponentsPopDep();

	/**
	 *	Get the IBusModelPubIndexObj instance referenced by the FromIndex key.
	 *
	 *	@return	The IBusModelPubIndexObj instance referenced by the FromIndex key.
	 */
	IBusModelPubIndexObj getRequiredLookupFromIndex();

	/**
	 *	Get the required IBusModelPubIndexObj instance referenced by the FromIndex key.
	 *
	 *	@return	The required IBusModelPubIndexObj instance referenced by the FromIndex key.
	 */
	IBusModelPubIndexObj getRequiredLookupFromIndex( boolean forceRead );

	/**
	 *	Set the IBusModelPubIndexObj instance referenced by the FromIndex key.
	 *
	 *	@param	value	the IBusModelPubIndexObj instance to be referenced by the FromIndex key.
	 */
	void setRequiredLookupFromIndex( IBusModelPubIndexObj value );

	/**
	 *	Get the IBusModelPubTableObj instance referenced by the ToTable key.
	 *
	 *	@return	The IBusModelPubTableObj instance referenced by the ToTable key.
	 */
	IBusModelPubTableObj getRequiredLookupToTable();

	/**
	 *	Get the required IBusModelPubTableObj instance referenced by the ToTable key.
	 *
	 *	@return	The required IBusModelPubTableObj instance referenced by the ToTable key.
	 */
	IBusModelPubTableObj getRequiredLookupToTable( boolean forceRead );

	/**
	 *	Set the IBusModelPubTableObj instance referenced by the ToTable key.
	 *
	 *	@param	value	the IBusModelPubTableObj instance to be referenced by the ToTable key.
	 */
	void setRequiredLookupToTable( IBusModelPubTableObj value );

	/**
	 *	Get the IBusModelPubIndexObj instance referenced by the ToIndex key.
	 *
	 *	@return	The IBusModelPubIndexObj instance referenced by the ToIndex key.
	 */
	IBusModelPubIndexObj getRequiredLookupToIndex();

	/**
	 *	Get the required IBusModelPubIndexObj instance referenced by the ToIndex key.
	 *
	 *	@return	The required IBusModelPubIndexObj instance referenced by the ToIndex key.
	 */
	IBusModelPubIndexObj getRequiredLookupToIndex( boolean forceRead );

	/**
	 *	Set the IBusModelPubIndexObj instance referenced by the ToIndex key.
	 *
	 *	@param	value	the IBusModelPubIndexObj instance to be referenced by the ToIndex key.
	 */
	void setRequiredLookupToIndex( IBusModelPubIndexObj value );

	/**
	 *	Get the IBusModelPubRelationObj instance referenced by the Narrowed key.
	 *
	 *	@return	The IBusModelPubRelationObj instance referenced by the Narrowed key.
	 */
	IBusModelPubRelationObj getOptionalLookupNarrowed();

	/**
	 *	Get the optional IBusModelPubRelationObj instance referenced by the Narrowed key.
	 *
	 *	@return	The optional IBusModelPubRelationObj instance referenced by the Narrowed key.
	 */
	IBusModelPubRelationObj getOptionalLookupNarrowed( boolean forceRead );

	/**
	 *	Set the IBusModelPubRelationObj instance referenced by the Narrowed key.
	 *
	 *	@param	value	the IBusModelPubRelationObj instance to be referenced by the Narrowed key.
	 */
	void setOptionalLookupNarrowed( IBusModelPubRelationObj value );

	/**
	 *	Get the required YCFDbKeyHash256 attribute TableId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute TableId.
	 */
	YCFDbKeyHash256 getRequiredTableId();

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
	 *	Get the required IBusModelPubSchema.RelationTypeEnum attribute RelationType.
	 *
	 *	@return	The required IBusModelPubSchema.RelationTypeEnum attribute RelationType.
	 */
	IBusModelPubSchema.RelationTypeEnum getRequiredRelationType();

	/**
	 *	Set the required IBusModelPubSchema.RelationTypeEnum attribute RelationType.
	 *
	 *	@param value The required IBusModelPubSchema.RelationTypeEnum attribute RelationType value to be applied.
	 */
	void setRequiredRelationType(IBusModelPubSchema.RelationTypeEnum value);

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
	 *	Get the optional String attribute Suffix.
	 *
	 *	@return	The optional String attribute Suffix.
	 */
	String getOptionalSuffix();

	/**
	 *	Set the optional String attribute Suffix.
	 *
	 *	@param value The optional String attribute Suffix value to be applied.
	 */
	void setOptionalSuffix(String value);

	/**
	 *	Get the required YCFDbKeyHash256 attribute FromIndexId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute FromIndexId.
	 */
	YCFDbKeyHash256 getRequiredFromIndexId();

	/**
	 *	Get the required YCFDbKeyHash256 attribute ToTableId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute ToTableId.
	 */
	YCFDbKeyHash256 getRequiredToTableId();

	/**
	 *	Get the required YCFDbKeyHash256 attribute ToIndexId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute ToIndexId.
	 */
	YCFDbKeyHash256 getRequiredToIndexId();

	/**
	 *	Get the required boolean attribute IsRequired.
	 *
	 *	@return	The required boolean attribute IsRequired.
	 */
	boolean getRequiredIsRequired();

	/**
	 *	Set the required boolean attribute IsRequired.
	 *
	 *	@param value The required boolean attribute IsRequired value to be applied.
	 */
	void setRequiredIsRequired(boolean value);

	/**
	 *	Get the required boolean attribute IsXsdContainer.
	 *
	 *	@return	The required boolean attribute IsXsdContainer.
	 */
	boolean getRequiredIsXsdContainer();

	/**
	 *	Set the required boolean attribute IsXsdContainer.
	 *
	 *	@param value The required boolean attribute IsXsdContainer value to be applied.
	 */
	void setRequiredIsXsdContainer(boolean value);

	/**
	 *	Get the required boolean attribute IsLateResolver.
	 *
	 *	@return	The required boolean attribute IsLateResolver.
	 */
	boolean getRequiredIsLateResolver();

	/**
	 *	Set the required boolean attribute IsLateResolver.
	 *
	 *	@param value The required boolean attribute IsLateResolver value to be applied.
	 */
	void setRequiredIsLateResolver(boolean value);

	/**
	 *	Get the required boolean attribute AllowAddendum.
	 *
	 *	@return	The required boolean attribute AllowAddendum.
	 */
	boolean getRequiredAllowAddendum();

	/**
	 *	Set the required boolean attribute AllowAddendum.
	 *
	 *	@param value The required boolean attribute AllowAddendum value to be applied.
	 */
	void setRequiredAllowAddendum(boolean value);

	/**
	 *	Get the optional YCFDbKeyHash256 attribute NarrowedId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute NarrowedId.
	 */
	YCFDbKeyHash256 getOptionalNarrowedId();

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
