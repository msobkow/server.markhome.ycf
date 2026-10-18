// Description: Java 17 implJustProtementation of a Relation buffer

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

package server.markhome.ycf.v3_1.busmodel.busmodel.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public class BusModelProtBuffRelation
	extends BusModelProtBuffScope
	implements IBusModelRelation
{
	protected IYCFKeyHash256 requiredTableId;
	protected IYCFKeyHash256 optionalDefSchemaId;
	protected String requiredName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected IBusModelPubSchema.RelationTypeEnum requiredRelationType;
	protected String optionalDbName;
	protected String optionalSuffix;
	protected IYCFKeyHash256 requiredFromIndexId;
	protected IYCFKeyHash256 requiredToTableId;
	protected IYCFKeyHash256 requiredToIndexId;
	protected boolean requiredIsRequired;
	protected boolean requiredIsXsdContainer;
	protected boolean requiredIsLateResolver;
	protected boolean requiredAllowAddendum;
	protected IYCFKeyHash256 optionalNarrowedId;
	protected IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis;

	public BusModelProtBuffRelation() {
		super();
		requiredTableId = YCFDbKeyHash256.fromHex( IBusModelPubRelation.TABLEID_INIT_VALUE.toString() );
		optionalDefSchemaId = YCFDbKeyHash256.nullGet();
		requiredName = IBusModelPubRelation.NAME_INIT_VALUE;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		requiredRelationType = IBusModelPubRelation.RELATIONTYPE_INIT_VALUE;
		optionalDbName = null;
		optionalSuffix = null;
		requiredFromIndexId = YCFDbKeyHash256.fromHex( IBusModelPubRelation.FROMINDEXID_INIT_VALUE.toString() );
		requiredToTableId = YCFDbKeyHash256.fromHex( IBusModelPubRelation.TOTABLEID_INIT_VALUE.toString() );
		requiredToIndexId = YCFDbKeyHash256.fromHex( IBusModelPubRelation.TOINDEXID_INIT_VALUE.toString() );
		requiredIsRequired = IBusModelPubRelation.ISREQUIRED_INIT_VALUE;
		requiredIsXsdContainer = IBusModelPubRelation.ISXSDCONTAINER_INIT_VALUE;
		requiredIsLateResolver = IBusModelPubRelation.ISLATERESOLVER_INIT_VALUE;
		requiredAllowAddendum = IBusModelPubRelation.ALLOWADDENDUM_INIT_VALUE;
		optionalNarrowedId = YCFDbKeyHash256.nullGet();
		requiredCodeVis = IBusModelPubRelation.CODEVIS_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelProtRelation.CLASS_CODE );
	}

	@Override
	public IBusModelProtSchemaDef getOptionalLookupDefSchema(IYCFKeyHash256 argDefSchemaId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "IBusModelProtSchema.getBackingBusModel().getTableSchemaDef()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalDefSchemaId()));
	}

	@Override
	public void setOptionalLookupDefSchema(IYCFKeyHash256 argDefSchemaId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupDefSchema-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelProtSchemaDef found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDefSchemaId);
		if (found == null || (found != null && ((found instanceof IBusModelProtSchemaDef) || (found instanceof IBusModelProtSchemaDef) || (found instanceof IBusModelPubSchemaDef)))) {
			super.setOptionalLookupDefSchema(argDefSchemaId);
		optionalDefSchemaId = argDefSchemaId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setOptionalLookupDefSchema-args", "found", found, "IBusModelProtSchemaDefIBusModelProtSchemaDefIBusModelPubSchemaDef");
		}
	}

	@Override
	public void setOptionalLookupDefSchema(IBusModelProtSchemaDef argObj) {

		if(argObj == null) {
			setJustProtOptionalDefSchemaId(null);
		}
		else {
			setJustProtOptionalDefSchemaId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupDefSchema(IBusModelPubSchemaDef argObj) {

		if(argObj == null) {
			setJustProtOptionalDefSchemaId(null);
		}
		else {
			setJustProtOptionalDefSchemaId(argObj.getRequiredId());
		}
	}

	@Override
	public IBusModelProtTable getRequiredContainerFromTable(IYCFKeyHash256 argTableId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerFromTable", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtTableTable targetTable = targetBackingBusModel.getTableTable();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerFromTable", 0, "IBusModelProtSchema.getBackingBusModel().getTableTable()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredTableId()));
	}

	@Override
	public void setRequiredContainerFromTable(IYCFKeyHash256 argTableId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerFromTable-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtTableTable targetTable = targetBackingBusModel.getTableTable();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerFromTable", 0, "IBusModelSchema.getBackingBusModel().getTableTable()");
		}
		IBusModelProtTable found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argTableId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerFromTable-args", 0, "found");
		}
		else if (found instanceof IBusModelProtTable) || (found instanceof IBusModelProtTable) || (found instanceof IBusModelPubTable)) {
			super.setRequiredContainerFromTable(argTableId);
		requiredTableId = argTableId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerFromTable-args", "found", found, "IBusModelProtTableIBusModelProtTableIBusModelPubTable");
		}
	}

	@Override
	public void setRequiredContainerFromTable(IBusModelProtTable argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerFromTable", 1, "argObj");
		}
		else {
			setJustProtRequiredTableId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredContainerFromTable(IBusModelPubTable argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerFromTable", 1, "argObj");
		}
		else {
			setJustProtRequiredTableId(argObj.getRequiredId());
		}
	}

	@Override
	public IBusModelProtIndex getRequiredLookupFromIndex(IYCFKeyHash256 argFromIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredLookupFromIndex", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredLookupFromIndex", 0, "IBusModelProtSchema.getBackingBusModel().getTableIndex()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredFromIndexId()));
	}

	@Override
	public void setRequiredLookupFromIndex(IYCFKeyHash256 argFromIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupFromIndex-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupFromIndex", 0, "IBusModelSchema.getBackingBusModel().getTableIndex()");
		}
		IBusModelProtIndex found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argFromIndexId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupFromIndex-args", 0, "found");
		}
		else if (found instanceof IBusModelProtIndex) || (found instanceof IBusModelProtIndex) || (found instanceof IBusModelPubIndex)) {
			super.setRequiredLookupFromIndex(argFromIndexId);
		requiredFromIndexId = argFromIndexId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredLookupFromIndex-args", "found", found, "IBusModelProtIndexIBusModelProtIndexIBusModelPubIndex");
		}
	}

	@Override
	public void setRequiredLookupFromIndex(IBusModelProtIndex argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setLookupFromIndex", 1, "argObj");
		}
		else {
			setJustProtRequiredFromIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredLookupFromIndex(IBusModelPubIndex argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setLookupFromIndex", 1, "argObj");
		}
		else {
			setJustProtRequiredFromIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public IBusModelProtTable getRequiredLookupToTable(IYCFKeyHash256 argToTableId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredLookupToTable", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtTableTable targetTable = targetBackingBusModel.getTableTable();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredLookupToTable", 0, "IBusModelProtSchema.getBackingBusModel().getTableTable()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredToTableId()));
	}

	@Override
	public void setRequiredLookupToTable(IYCFKeyHash256 argToTableId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupToTable-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtTableTable targetTable = targetBackingBusModel.getTableTable();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupToTable", 0, "IBusModelSchema.getBackingBusModel().getTableTable()");
		}
		IBusModelProtTable found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argToTableId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupToTable-args", 0, "found");
		}
		else if (found instanceof IBusModelProtTable) || (found instanceof IBusModelProtTable) || (found instanceof IBusModelPubTable)) {
			super.setRequiredLookupToTable(argToTableId);
		requiredToTableId = argToTableId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredLookupToTable-args", "found", found, "IBusModelProtTableIBusModelProtTableIBusModelPubTable");
		}
	}

	@Override
	public void setRequiredLookupToTable(IBusModelProtTable argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setLookupToTable", 1, "argObj");
		}
		else {
			setJustProtRequiredToTableId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredLookupToTable(IBusModelPubTable argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setLookupToTable", 1, "argObj");
		}
		else {
			setJustProtRequiredToTableId(argObj.getRequiredId());
		}
	}

	@Override
	public IBusModelProtIndex getRequiredLookupToIndex(IYCFKeyHash256 argToIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredLookupToIndex", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredLookupToIndex", 0, "IBusModelProtSchema.getBackingBusModel().getTableIndex()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredToIndexId()));
	}

	@Override
	public void setRequiredLookupToIndex(IYCFKeyHash256 argToIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupToIndex-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupToIndex", 0, "IBusModelSchema.getBackingBusModel().getTableIndex()");
		}
		IBusModelProtIndex found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argToIndexId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupToIndex-args", 0, "found");
		}
		else if (found instanceof IBusModelProtIndex) || (found instanceof IBusModelProtIndex) || (found instanceof IBusModelPubIndex)) {
			super.setRequiredLookupToIndex(argToIndexId);
		requiredToIndexId = argToIndexId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredLookupToIndex-args", "found", found, "IBusModelProtIndexIBusModelProtIndexIBusModelPubIndex");
		}
	}

	@Override
	public void setRequiredLookupToIndex(IBusModelProtIndex argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setLookupToIndex", 1, "argObj");
		}
		else {
			setJustProtRequiredToIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredLookupToIndex(IBusModelPubIndex argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setLookupToIndex", 1, "argObj");
		}
		else {
			setJustProtRequiredToIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public IBusModelProtRelation getOptionalLookupNarrowed(IYCFKeyHash256 argNarrowedId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupNarrowed", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtRelationTable targetTable = targetBackingBusModel.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupNarrowed", 0, "IBusModelProtSchema.getBackingBusModel().getTableRelation()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalNarrowedId()));
	}

	@Override
	public void setOptionalLookupNarrowed(IYCFKeyHash256 argNarrowedId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupNarrowed-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtRelationTable targetTable = targetBackingBusModel.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupNarrowed", 0, "IBusModelSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelProtRelation found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argNarrowedId);
		if (found == null || (found != null && ((found instanceof IBusModelProtRelation) || (found instanceof IBusModelProtRelation) || (found instanceof IBusModelPubRelation)))) {
			super.setOptionalLookupNarrowed(argNarrowedId);
		optionalNarrowedId = argNarrowedId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setOptionalLookupNarrowed-args", "found", found, "IBusModelProtRelationIBusModelProtRelationIBusModelPubRelation");
		}
	}

	@Override
	public void setOptionalLookupNarrowed(IBusModelProtRelation argObj) {

		if(argObj == null) {
			setJustProtOptionalNarrowedId(null);
		}
		else {
			setJustProtOptionalNarrowedId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupNarrowed(IBusModelPubRelation argObj) {

		if(argObj == null) {
			setJustProtOptionalNarrowedId(null);
		}
		else {
			setJustProtOptionalNarrowedId(argObj.getRequiredId());
		}
	}

	@Override
	public List<IBusModelProtRelationCol> getOptionalComponentsColumns(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsColumns", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtRelationColTable targetTable = targetBackingBusModel.getTableRelationCol();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsColumns", 0, "IBusModelProtSchema.getBackingBusModel().getTableRelationCol()");
		}
		IBusModelProtRelationCol[] targetArr = targetTable.readDerivedByRelationIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtRelationCol> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtRelationCol> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelProtPopTopDep> getOptionalComponentsPopDep(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtPopTopDepTable targetTable = targetBackingBusModel.getTablePopTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsPopDep", 0, "IBusModelProtSchema.getBackingBusModel().getTablePopTopDep()");
		}
		IBusModelProtPopTopDep[] targetArr = targetTable.readDerivedByContRelIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtPopTopDep> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtPopTopDep> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredTableId() {
		return(requiredTableId);
	}

	public void setRequiredTableId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredTableId",
				1,
				"value" );
		}
		requiredTableId = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return(optionalDefSchemaId);
	}

	public void setOptionalDefSchemaId( IYCFKeyHash256 value ) {
		optionalDefSchemaId = value;
	}

	@Override
	public String getRequiredName() {
		return(requiredName);
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		else if( value.length() > 192 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredName = value;
	}

	@Override
	public String getOptionalShortName() {
		return(optionalShortName);
	}

	public void setOptionalShortName( String value ) {
		if( value != null && value.length() > 16 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalShortName",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		optionalShortName = value;
	}

	@Override
	public String getOptionalLabel() {
		return(optionalLabel);
	}

	public void setOptionalLabel( String value ) {
		if( value != null && value.length() > 64 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalLabel",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		optionalLabel = value;
	}

	@Override
	public String getOptionalShortDescription() {
		return(optionalShortDescription);
	}

	public void setOptionalShortDescription( String value ) {
		if( value != null && value.length() > 128 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		optionalShortDescription = value;
	}

	@Override
	public String getOptionalDescription() {
		return(optionalDescription);
	}

	public void setOptionalDescription( String value ) {
		if( value != null && value.length() > 1023 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1023 );
		}
		optionalDescription = value;
	}

	@Override
	public IBusModelPubSchema.RelationTypeEnum getRequiredRelationType() {
		return(requiredRelationType);
	}

	public void setRequiredRelationType( IBusModelPubSchema.RelationTypeEnum value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredRelationType",
				1,
				"value" );
		}
		requiredRelationType = value;
	}

	@Override
	public String getOptionalDbName() {
		return(optionalDbName);
	}

	public void setOptionalDbName( String value ) {
		if( value != null && value.length() > 32 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalDbName",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		optionalDbName = value;
	}

	@Override
	public String getOptionalSuffix() {
		return(optionalSuffix);
	}

	public void setOptionalSuffix( String value ) {
		if( value != null && value.length() > 16 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalSuffix",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		optionalSuffix = value;
	}

	@Override
	public IYCFKeyHash256 getRequiredFromIndexId() {
		return(requiredFromIndexId);
	}

	public void setRequiredFromIndexId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredFromIndexId",
				1,
				"value" );
		}
		requiredFromIndexId = value;
	}

	@Override
	public IYCFKeyHash256 getRequiredToTableId() {
		return(requiredToTableId);
	}

	public void setRequiredToTableId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredToTableId",
				1,
				"value" );
		}
		requiredToTableId = value;
	}

	@Override
	public IYCFKeyHash256 getRequiredToIndexId() {
		return(requiredToIndexId);
	}

	public void setRequiredToIndexId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredToIndexId",
				1,
				"value" );
		}
		requiredToIndexId = value;
	}

	@Override
	public boolean getRequiredIsRequired() {
		return(requiredIsRequired);
	}

	public void setRequiredIsRequired( boolean value ) {
		requiredIsRequired = value;
	}

	@Override
	public boolean getRequiredIsXsdContainer() {
		return(requiredIsXsdContainer);
	}

	public void setRequiredIsXsdContainer( boolean value ) {
		requiredIsXsdContainer = value;
	}

	@Override
	public boolean getRequiredIsLateResolver() {
		return(requiredIsLateResolver);
	}

	public void setRequiredIsLateResolver( boolean value ) {
		requiredIsLateResolver = value;
	}

	@Override
	public boolean getRequiredAllowAddendum() {
		return(requiredAllowAddendum);
	}

	public void setRequiredAllowAddendum( boolean value ) {
		requiredAllowAddendum = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalNarrowedId() {
		return(optionalNarrowedId);
	}

	public void setOptionalNarrowedId( IYCFKeyHash256 value ) {
		optionalNarrowedId = value;
	}

	@Override
	public IBusModelPubSchema.CodeVisibilityEnum getRequiredCodeVis() {
		return(requiredCodeVis);
	}

	public void setRequiredCodeVis( IBusModelPubSchema.CodeVisibilityEnum value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredCodeVis",
				1,
				"value" );
		}
		requiredCodeVis = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof IBusModelProtRelation rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredRelationType() != null ) {
				if( rhs.getRequiredRelationType() != null ) {
					if( ! getRequiredRelationType().equals( rhs.getRequiredRelationType() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRelationType() != null ) {
					return( false );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredFromIndexId() != null ) {
				if( rhs.getRequiredFromIndexId() != null ) {
					if( ! getRequiredFromIndexId().equals( rhs.getRequiredFromIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredFromIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredToTableId() != null ) {
				if( rhs.getRequiredToTableId() != null ) {
					if( ! getRequiredToTableId().equals( rhs.getRequiredToTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredToIndexId() != null ) {
				if( rhs.getRequiredToIndexId() != null ) {
					if( ! getRequiredToIndexId().equals( rhs.getRequiredToIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsRequired() != rhs.getRequiredIsRequired() ) {
				return( false );
			}
			if( getRequiredIsXsdContainer() != rhs.getRequiredIsXsdContainer() ) {
				return( false );
			}
			if( getRequiredIsLateResolver() != rhs.getRequiredIsLateResolver() ) {
				return( false );
			}
			if( getRequiredAllowAddendum() != rhs.getRequiredAllowAddendum() ) {
				return( false );
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationH rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredRelationType() != null ) {
				if( rhs.getRequiredRelationType() != null ) {
					if( ! getRequiredRelationType().equals( rhs.getRequiredRelationType() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRelationType() != null ) {
					return( false );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredFromIndexId() != null ) {
				if( rhs.getRequiredFromIndexId() != null ) {
					if( ! getRequiredFromIndexId().equals( rhs.getRequiredFromIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredFromIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredToTableId() != null ) {
				if( rhs.getRequiredToTableId() != null ) {
					if( ! getRequiredToTableId().equals( rhs.getRequiredToTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredToIndexId() != null ) {
				if( rhs.getRequiredToIndexId() != null ) {
					if( ! getRequiredToIndexId().equals( rhs.getRequiredToIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsRequired() != rhs.getRequiredIsRequired() ) {
				return( false );
			}
			if( getRequiredIsXsdContainer() != rhs.getRequiredIsXsdContainer() ) {
				return( false );
			}
			if( getRequiredIsLateResolver() != rhs.getRequiredIsLateResolver() ) {
				return( false );
			}
			if( getRequiredAllowAddendum() != rhs.getRequiredAllowAddendum() ) {
				return( false );
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtScopeHPKey ) {
			IBusModelProtScopeHPKey rhs = (IBusModelProtScopeHPKey)obj;
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByUNameIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByRelTableIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByRelCodeVisIdxKey rhs ) {
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByRelTableCodeVisXKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByFromKeyIdxKey rhs ) {
			if( getRequiredFromIndexId() != null ) {
				if( rhs.getRequiredFromIndexId() != null ) {
					if( ! getRequiredFromIndexId().equals( rhs.getRequiredFromIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredFromIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByToTblIdxKey rhs ) {
			if( getRequiredToTableId() != null ) {
				if( rhs.getRequiredToTableId() != null ) {
					if( ! getRequiredToTableId().equals( rhs.getRequiredToTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByToKeyIdxKey rhs ) {
			if( getRequiredToIndexId() != null ) {
				if( rhs.getRequiredToIndexId() != null ) {
					if( ! getRequiredToIndexId().equals( rhs.getRequiredToIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByNarrowedIdxKey rhs ) {
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubRelation rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredRelationType() != null ) {
				if( rhs.getRequiredRelationType() != null ) {
					if( ! getRequiredRelationType().equals( rhs.getRequiredRelationType() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRelationType() != null ) {
					return( false );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredFromIndexId() != null ) {
				if( rhs.getRequiredFromIndexId() != null ) {
					if( ! getRequiredFromIndexId().equals( rhs.getRequiredFromIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredFromIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredToTableId() != null ) {
				if( rhs.getRequiredToTableId() != null ) {
					if( ! getRequiredToTableId().equals( rhs.getRequiredToTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredToIndexId() != null ) {
				if( rhs.getRequiredToIndexId() != null ) {
					if( ! getRequiredToIndexId().equals( rhs.getRequiredToIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsRequired() != rhs.getRequiredIsRequired() ) {
				return( false );
			}
			if( getRequiredIsXsdContainer() != rhs.getRequiredIsXsdContainer() ) {
				return( false );
			}
			if( getRequiredIsLateResolver() != rhs.getRequiredIsLateResolver() ) {
				return( false );
			}
			if( getRequiredAllowAddendum() != rhs.getRequiredAllowAddendum() ) {
				return( false );
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubRelationH rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredRelationType() != null ) {
				if( rhs.getRequiredRelationType() != null ) {
					if( ! getRequiredRelationType().equals( rhs.getRequiredRelationType() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRelationType() != null ) {
					return( false );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredFromIndexId() != null ) {
				if( rhs.getRequiredFromIndexId() != null ) {
					if( ! getRequiredFromIndexId().equals( rhs.getRequiredFromIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredFromIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredToTableId() != null ) {
				if( rhs.getRequiredToTableId() != null ) {
					if( ! getRequiredToTableId().equals( rhs.getRequiredToTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredToIndexId() != null ) {
				if( rhs.getRequiredToIndexId() != null ) {
					if( ! getRequiredToIndexId().equals( rhs.getRequiredToIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsRequired() != rhs.getRequiredIsRequired() ) {
				return( false );
			}
			if( getRequiredIsXsdContainer() != rhs.getRequiredIsXsdContainer() ) {
				return( false );
			}
			if( getRequiredIsLateResolver() != rhs.getRequiredIsLateResolver() ) {
				return( false );
			}
			if( getRequiredAllowAddendum() != rhs.getRequiredAllowAddendum() ) {
				return( false );
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubScopeHPKey rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByUNameIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByRelTableIdxKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByRelCodeVisIdxKey rhs ) {
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByRelTableCodeVisXKey rhs ) {
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredCodeVis() != null ) {
				if( rhs.getRequiredCodeVis() != null ) {
					if( ! getRequiredCodeVis().equals( rhs.getRequiredCodeVis() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCodeVis() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByFromKeyIdxKey rhs ) {
			if( getRequiredFromIndexId() != null ) {
				if( rhs.getRequiredFromIndexId() != null ) {
					if( ! getRequiredFromIndexId().equals( rhs.getRequiredFromIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredFromIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByToTblIdxKey rhs ) {
			if( getRequiredToTableId() != null ) {
				if( rhs.getRequiredToTableId() != null ) {
					if( ! getRequiredToTableId().equals( rhs.getRequiredToTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByToKeyIdxKey rhs ) {
			if( getRequiredToIndexId() != null ) {
				if( rhs.getRequiredToIndexId() != null ) {
					if( ! getRequiredToIndexId().equals( rhs.getRequiredToIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredToIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRelationByNarrowedIdxKey rhs ) {
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + getRequiredTableId().hashCode();
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalShortName() != null ) {
			hashCode = hashCode + getOptionalShortName().hashCode();
		}
		if( getOptionalLabel() != null ) {
			hashCode = hashCode + getOptionalLabel().hashCode();
		}
		if( getOptionalShortDescription() != null ) {
			hashCode = hashCode + getOptionalShortDescription().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredRelationType().ordinal();
		if( getOptionalDbName() != null ) {
			hashCode = hashCode + getOptionalDbName().hashCode();
		}
		if( getOptionalSuffix() != null ) {
			hashCode = hashCode + getOptionalSuffix().hashCode();
		}
		hashCode = hashCode + getRequiredFromIndexId().hashCode();
		hashCode = hashCode + getRequiredToTableId().hashCode();
		hashCode = hashCode + getRequiredToIndexId().hashCode();
		if( getRequiredIsRequired() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredIsXsdContainer() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredIsLateResolver() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredAllowAddendum() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getOptionalNarrowedId() != null ) {
			hashCode = hashCode + getOptionalNarrowedId().hashCode();
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredCodeVis().ordinal();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof IBusModelProtRelation rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if (getRequiredRelationType() != null) {
				if (rhs.getRequiredRelationType() != null) {
					cmp = getRequiredRelationType().compareTo( rhs.getRequiredRelationType() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRelationType() != null) {
				return( -1 );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if (getRequiredFromIndexId() != null) {
				if (rhs.getRequiredFromIndexId() != null) {
					cmp = getRequiredFromIndexId().compareTo( rhs.getRequiredFromIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredFromIndexId() != null) {
				return( -1 );
			}
			if (getRequiredToTableId() != null) {
				if (rhs.getRequiredToTableId() != null) {
					cmp = getRequiredToTableId().compareTo( rhs.getRequiredToTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToTableId() != null) {
				return( -1 );
			}
			if (getRequiredToIndexId() != null) {
				if (rhs.getRequiredToIndexId() != null) {
					cmp = getRequiredToIndexId().compareTo( rhs.getRequiredToIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToIndexId() != null) {
				return( -1 );
			}
			if( getRequiredIsRequired() ) {
				if( ! rhs.getRequiredIsRequired() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsRequired() ) {
					return( -1 );
				}
			}
			if( getRequiredIsXsdContainer() ) {
				if( ! rhs.getRequiredIsXsdContainer() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsXsdContainer() ) {
					return( -1 );
				}
			}
			if( getRequiredIsLateResolver() ) {
				if( ! rhs.getRequiredIsLateResolver() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsLateResolver() ) {
					return( -1 );
				}
			}
			if( getRequiredAllowAddendum() ) {
				if( ! rhs.getRequiredAllowAddendum() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredAllowAddendum() ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					cmp = getOptionalNarrowedId().compareTo( rhs.getOptionalNarrowedId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}
			return( 0 );
 		}
		else if( obj instanceof IBusModelProtScopeHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if (getRequiredRelationType() != null) {
				if (rhs.getRequiredRelationType() != null) {
					cmp = getRequiredRelationType().compareTo( rhs.getRequiredRelationType() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRelationType() != null) {
				return( -1 );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if (getRequiredFromIndexId() != null) {
				if (rhs.getRequiredFromIndexId() != null) {
					cmp = getRequiredFromIndexId().compareTo( rhs.getRequiredFromIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredFromIndexId() != null) {
				return( -1 );
			}
			if (getRequiredToTableId() != null) {
				if (rhs.getRequiredToTableId() != null) {
					cmp = getRequiredToTableId().compareTo( rhs.getRequiredToTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToTableId() != null) {
				return( -1 );
			}
			if (getRequiredToIndexId() != null) {
				if (rhs.getRequiredToIndexId() != null) {
					cmp = getRequiredToIndexId().compareTo( rhs.getRequiredToIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToIndexId() != null) {
				return( -1 );
			}
			if( getRequiredIsRequired() ) {
				if( ! rhs.getRequiredIsRequired() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsRequired() ) {
					return( -1 );
				}
			}
			if( getRequiredIsXsdContainer() ) {
				if( ! rhs.getRequiredIsXsdContainer() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsXsdContainer() ) {
					return( -1 );
				}
			}
			if( getRequiredIsLateResolver() ) {
				if( ! rhs.getRequiredIsLateResolver() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsLateResolver() ) {
					return( -1 );
				}
			}
			if( getRequiredAllowAddendum() ) {
				if( ! rhs.getRequiredAllowAddendum() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredAllowAddendum() ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					cmp = getOptionalNarrowedId().compareTo( rhs.getOptionalNarrowedId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationByUNameIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationByRelTableIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationByRelCodeVisIdxKey rhs ) {
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationByRelTableCodeVisXKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationByFromKeyIdxKey rhs ) {
			if (getRequiredFromIndexId() != null) {
				if (rhs.getRequiredFromIndexId() != null) {
					cmp = getRequiredFromIndexId().compareTo( rhs.getRequiredFromIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredFromIndexId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationByToTblIdxKey rhs ) {
			if (getRequiredToTableId() != null) {
				if (rhs.getRequiredToTableId() != null) {
					cmp = getRequiredToTableId().compareTo( rhs.getRequiredToTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToTableId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationByToKeyIdxKey rhs ) {
			if (getRequiredToIndexId() != null) {
				if (rhs.getRequiredToIndexId() != null) {
					cmp = getRequiredToIndexId().compareTo( rhs.getRequiredToIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToIndexId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRelationByNarrowedIdxKey rhs ) {
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					cmp = getOptionalNarrowedId().compareTo( rhs.getOptionalNarrowedId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelation rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if (getRequiredRelationType() != null) {
				if (rhs.getRequiredRelationType() != null) {
					cmp = getRequiredRelationType().compareTo( rhs.getRequiredRelationType() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRelationType() != null) {
				return( -1 );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if (getRequiredFromIndexId() != null) {
				if (rhs.getRequiredFromIndexId() != null) {
					cmp = getRequiredFromIndexId().compareTo( rhs.getRequiredFromIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredFromIndexId() != null) {
				return( -1 );
			}
			if (getRequiredToTableId() != null) {
				if (rhs.getRequiredToTableId() != null) {
					cmp = getRequiredToTableId().compareTo( rhs.getRequiredToTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToTableId() != null) {
				return( -1 );
			}
			if (getRequiredToIndexId() != null) {
				if (rhs.getRequiredToIndexId() != null) {
					cmp = getRequiredToIndexId().compareTo( rhs.getRequiredToIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToIndexId() != null) {
				return( -1 );
			}
			if( getRequiredIsRequired() ) {
				if( ! rhs.getRequiredIsRequired() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsRequired() ) {
					return( -1 );
				}
			}
			if( getRequiredIsXsdContainer() ) {
				if( ! rhs.getRequiredIsXsdContainer() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsXsdContainer() ) {
					return( -1 );
				}
			}
			if( getRequiredIsLateResolver() ) {
				if( ! rhs.getRequiredIsLateResolver() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsLateResolver() ) {
					return( -1 );
				}
			}
			if( getRequiredAllowAddendum() ) {
				if( ! rhs.getRequiredAllowAddendum() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredAllowAddendum() ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					cmp = getOptionalNarrowedId().compareTo( rhs.getOptionalNarrowedId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubScopeHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if (getRequiredRelationType() != null) {
				if (rhs.getRequiredRelationType() != null) {
					cmp = getRequiredRelationType().compareTo( rhs.getRequiredRelationType() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRelationType() != null) {
				return( -1 );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if (getRequiredFromIndexId() != null) {
				if (rhs.getRequiredFromIndexId() != null) {
					cmp = getRequiredFromIndexId().compareTo( rhs.getRequiredFromIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredFromIndexId() != null) {
				return( -1 );
			}
			if (getRequiredToTableId() != null) {
				if (rhs.getRequiredToTableId() != null) {
					cmp = getRequiredToTableId().compareTo( rhs.getRequiredToTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToTableId() != null) {
				return( -1 );
			}
			if (getRequiredToIndexId() != null) {
				if (rhs.getRequiredToIndexId() != null) {
					cmp = getRequiredToIndexId().compareTo( rhs.getRequiredToIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToIndexId() != null) {
				return( -1 );
			}
			if( getRequiredIsRequired() ) {
				if( ! rhs.getRequiredIsRequired() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsRequired() ) {
					return( -1 );
				}
			}
			if( getRequiredIsXsdContainer() ) {
				if( ! rhs.getRequiredIsXsdContainer() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsXsdContainer() ) {
					return( -1 );
				}
			}
			if( getRequiredIsLateResolver() ) {
				if( ! rhs.getRequiredIsLateResolver() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsLateResolver() ) {
					return( -1 );
				}
			}
			if( getRequiredAllowAddendum() ) {
				if( ! rhs.getRequiredAllowAddendum() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredAllowAddendum() ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					cmp = getOptionalNarrowedId().compareTo( rhs.getOptionalNarrowedId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationByUNameIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationByRelTableIdxKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationByRelCodeVisIdxKey rhs ) {
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationByRelTableCodeVisXKey rhs ) {
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if (getRequiredCodeVis() != null) {
				if (rhs.getRequiredCodeVis() != null) {
					cmp = getRequiredCodeVis().compareTo( rhs.getRequiredCodeVis() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCodeVis() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationByFromKeyIdxKey rhs ) {
			if (getRequiredFromIndexId() != null) {
				if (rhs.getRequiredFromIndexId() != null) {
					cmp = getRequiredFromIndexId().compareTo( rhs.getRequiredFromIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredFromIndexId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationByToTblIdxKey rhs ) {
			if (getRequiredToTableId() != null) {
				if (rhs.getRequiredToTableId() != null) {
					cmp = getRequiredToTableId().compareTo( rhs.getRequiredToTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToTableId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationByToKeyIdxKey rhs ) {
			if (getRequiredToIndexId() != null) {
				if (rhs.getRequiredToIndexId() != null) {
					cmp = getRequiredToIndexId().compareTo( rhs.getRequiredToIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredToIndexId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRelationByNarrowedIdxKey rhs ) {
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					cmp = getOptionalNarrowedId().compareTo( rhs.getOptionalNarrowedId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			cmp = super.compareTo( obj );
			return( cmp );
		}
	}

	@Override
	public void set( IBusModelProtScope src ) {
		if( src instanceof BusModelProtBuffRelation ) {
			setJustProtRelation( (BusModelProtBuffRelation)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffRelation" );
		}
	}

	@Override
	public void setRelation( IBusModelProtRelation src ) {
		super.setScope( src );
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtRequiredContainerFromTable(src.getRequiredContainerFromTable());
		setJustProtRequiredLookupFromIndex(src.getRequiredLookupFromIndex());
		setJustProtRequiredLookupToTable(src.getRequiredLookupToTable());
		setJustProtRequiredLookupToIndex(src.getRequiredLookupToIndex());
		setJustProtOptionalLookupNarrowed(src.getOptionalLookupNarrowed());
		setJustProtRequiredTableId(src.getRequiredTableId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtRequiredRelationType(src.getRequiredRelationType());
		setJustProtOptionalDbName(src.getOptionalDbName());
		setJustProtOptionalSuffix(src.getOptionalSuffix());
		setJustProtRequiredFromIndexId(src.getRequiredFromIndexId());
		setJustProtRequiredToTableId(src.getRequiredToTableId());
		setJustProtRequiredToIndexId(src.getRequiredToIndexId());
		setJustProtRequiredIsRequired(src.getRequiredIsRequired());
		setJustProtRequiredIsXsdContainer(src.getRequiredIsXsdContainer());
		setJustProtRequiredIsLateResolver(src.getRequiredIsLateResolver());
		setJustProtRequiredAllowAddendum(src.getRequiredAllowAddendum());
		setJustProtOptionalNarrowedId(src.getOptionalNarrowedId());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
	}

	@Override
	public void set( IBusModelProtScopeH src ) {
		if( src instanceof IBusModelPubRelationH ) {
			setRelation( (IBusModelPubRelationH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubRelationH" );
		}
	}

	@Override
	public void setRelation( IBusModelProtRelationH src ) {
		super.setScope( src );
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtRequiredContainerFromTable(src.getRequiredContainerFromTable());
		setJustProtRequiredLookupFromIndex(src.getRequiredLookupFromIndex());
		setJustProtRequiredLookupToTable(src.getRequiredLookupToTable());
		setJustProtRequiredLookupToIndex(src.getRequiredLookupToIndex());
		setJustProtOptionalLookupNarrowed(src.getOptionalLookupNarrowed());
		setJustProtRequiredTableId(src.getRequiredTableId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtRequiredRelationType(src.getRequiredRelationType());
		setJustProtOptionalDbName(src.getOptionalDbName());
		setJustProtOptionalSuffix(src.getOptionalSuffix());
		setJustProtRequiredFromIndexId(src.getRequiredFromIndexId());
		setJustProtRequiredToTableId(src.getRequiredToTableId());
		setJustProtRequiredToIndexId(src.getRequiredToIndexId());
		setJustProtRequiredIsRequired(src.getRequiredIsRequired());
		setJustProtRequiredIsXsdContainer(src.getRequiredIsXsdContainer());
		setJustProtRequiredIsLateResolver(src.getRequiredIsLateResolver());
		setJustProtRequiredAllowAddendum(src.getRequiredAllowAddendum());
		setJustProtOptionalNarrowedId(src.getOptionalNarrowedId());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubProtBuffRelation ) {
			setJustProtRelation( (BusModelPubProtBuffRelation)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubProtBuffRelation" );
		}
	}

	@Override
	public void setRelation( IBusModelPubRelation src ) {
		super.setScope( src );
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtRequiredContainerFromTable(src.getRequiredContainerFromTable());
		setJustProtRequiredLookupFromIndex(src.getRequiredLookupFromIndex());
		setJustProtRequiredLookupToTable(src.getRequiredLookupToTable());
		setJustProtRequiredLookupToIndex(src.getRequiredLookupToIndex());
		setJustProtOptionalLookupNarrowed(src.getOptionalLookupNarrowed());
		setJustProtRequiredTableId(src.getRequiredTableId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtRequiredRelationType(src.getRequiredRelationType());
		setJustProtOptionalDbName(src.getOptionalDbName());
		setJustProtOptionalSuffix(src.getOptionalSuffix());
		setJustProtRequiredFromIndexId(src.getRequiredFromIndexId());
		setJustProtRequiredToTableId(src.getRequiredToTableId());
		setJustProtRequiredToIndexId(src.getRequiredToIndexId());
		setJustProtRequiredIsRequired(src.getRequiredIsRequired());
		setJustProtRequiredIsXsdContainer(src.getRequiredIsXsdContainer());
		setJustProtRequiredIsLateResolver(src.getRequiredIsLateResolver());
		setJustProtRequiredAllowAddendum(src.getRequiredAllowAddendum());
		setJustProtOptionalNarrowedId(src.getOptionalNarrowedId());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubRelationH ) {
			setRelation( (IBusModelPubRelationH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubRelationH" );
		}
	}

	@Override
	public void setRelation( IBusModelPubRelationH src ) {
		super.setScope( src );
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtRequiredContainerFromTable(src.getRequiredContainerFromTable());
		setJustProtRequiredLookupFromIndex(src.getRequiredLookupFromIndex());
		setJustProtRequiredLookupToTable(src.getRequiredLookupToTable());
		setJustProtRequiredLookupToIndex(src.getRequiredLookupToIndex());
		setJustProtOptionalLookupNarrowed(src.getOptionalLookupNarrowed());
		setJustProtRequiredTableId(src.getRequiredTableId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtRequiredRelationType(src.getRequiredRelationType());
		setJustProtOptionalDbName(src.getOptionalDbName());
		setJustProtOptionalSuffix(src.getOptionalSuffix());
		setJustProtRequiredFromIndexId(src.getRequiredFromIndexId());
		setJustProtRequiredToTableId(src.getRequiredToTableId());
		setJustProtRequiredToIndexId(src.getRequiredToIndexId());
		setJustProtRequiredIsRequired(src.getRequiredIsRequired());
		setJustProtRequiredIsXsdContainer(src.getRequiredIsXsdContainer());
		setJustProtRequiredIsLateResolver(src.getRequiredIsLateResolver());
		setJustProtRequiredAllowAddendum(src.getRequiredAllowAddendum());
		setJustProtOptionalNarrowedId(src.getOptionalNarrowedId());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredTableId().toString() + "\"" + "\"" + getRequiredId().toString() + "\"" + ( ( getOptionalDefSchemaId() == null ) ? "null" : "\"" + getOptionalDefSchemaId().toString() + "\"" ) + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"" + ( ( getOptionalShortName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortName() ) + "\"" ) + ( ( getOptionalLabel() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalLabel() ) + "\"" ) + ( ( getOptionalShortDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortDescription() ) + "\"" ) + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" ) + "\"" + getRequiredRelationType().toString() + "\"" + ( ( getOptionalDbName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDbName() ) + "\"" ) + ( ( getOptionalSuffix() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalSuffix() ) + "\"" ) + "\"" + getRequiredFromIndexId().toString() + "\"" + "\"" + getRequiredToTableId().toString() + "\"" + "\"" + getRequiredToIndexId().toString() + "\"" + (( getRequiredIsRequired() ) ? "\"true\"" : "\"false\"" ) + (( getRequiredIsXsdContainer() ) ? "\"true\"" : "\"false\"" ) + (( getRequiredIsLateResolver() ) ? "\"true\"" : "\"false\"" ) + (( getRequiredAllowAddendum() ) ? "\"true\"" : "\"false\"" ) + ( ( getOptionalNarrowedId() == null ) ? "null" : "\"" + getOptionalNarrowedId().toString() + "\"" ) + "\"" + getRequiredCodeVis().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelProtBuffRelation" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
