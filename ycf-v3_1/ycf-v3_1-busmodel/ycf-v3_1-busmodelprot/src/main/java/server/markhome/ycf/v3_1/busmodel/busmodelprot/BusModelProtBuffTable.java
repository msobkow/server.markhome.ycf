// Description: Java 17 implJustProtementation of a Table buffer

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

public class BusModelProtBuffTable
	extends BusModelProtBuffScope
	implements IBusModelTable
{
	protected IYCFKeyHash256 requiredSchemaDefId;
	protected IYCFKeyHash256 optionalDefSchemaId;
	protected String requiredName;
	protected String optionalDbName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected boolean requiredPageData;
	protected IYCFKeyHash256 optionalPrimaryIndexId;
	protected String requiredTableClassCode;
	protected IYCFKeyHash256 optionalLookupIndexId;
	protected IYCFKeyHash256 optionalAltIndexId;
	protected IYCFKeyHash256 optionalQualifyingTableId;
	protected boolean requiredIsInstantiable;
	protected boolean requiredHasHistory;
	protected boolean requiredHasAuditColumns;
	protected boolean requiredIsMutable;
	protected boolean requiredIsServerOnly;
	protected IBusModelPubSchema.LoaderBehaviourEnum requiredLoaderBehaviour;
	protected IBusModelPubSchema.SecScopeEnum requiredSecScope;
	protected IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis;

	public BusModelProtBuffTable() {
		super();
		requiredSchemaDefId = YCFDbKeyHash256.fromHex( IBusModelPubTable.SCHEMADEFID_INIT_VALUE.toString() );
		optionalDefSchemaId = YCFDbKeyHash256.nullGet();
		requiredName = IBusModelPubTable.NAME_INIT_VALUE;
		optionalDbName = null;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		requiredPageData = IBusModelPubTable.PAGEDATA_INIT_VALUE;
		optionalPrimaryIndexId = YCFDbKeyHash256.nullGet();
		requiredTableClassCode = IBusModelPubTable.TABLECLASSCODE_INIT_VALUE;
		optionalLookupIndexId = YCFDbKeyHash256.nullGet();
		optionalAltIndexId = YCFDbKeyHash256.nullGet();
		optionalQualifyingTableId = YCFDbKeyHash256.nullGet();
		requiredIsInstantiable = IBusModelPubTable.ISINSTANTIABLE_INIT_VALUE;
		requiredHasHistory = IBusModelPubTable.HASHISTORY_INIT_VALUE;
		requiredHasAuditColumns = IBusModelPubTable.HASAUDITCOLUMNS_INIT_VALUE;
		requiredIsMutable = IBusModelPubTable.ISMUTABLE_INIT_VALUE;
		requiredIsServerOnly = IBusModelPubTable.ISSERVERONLY_INIT_VALUE;
		requiredLoaderBehaviour = IBusModelPubTable.LOADERBEHAVIOUR_INIT_VALUE;
		requiredSecScope = IBusModelPubTable.SECSCOPE_INIT_VALUE;
		requiredCodeVis = IBusModelPubTable.CODEVIS_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelProtTable.CLASS_CODE );
	}

	@Override
	public IBusModelProtSchemaDef getRequiredContainerSchemaDef(IYCFKeyHash256 argSchemaDefId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerSchemaDef", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerSchemaDef", 0, "IBusModelProtSchema.getBackingBusModel().getTableSchemaDef()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredSchemaDefId()));
	}

	@Override
	public void setRequiredContainerSchemaDef(IYCFKeyHash256 argSchemaDefId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerSchemaDef-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerSchemaDef", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelProtSchemaDef found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argSchemaDefId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerSchemaDef-args", 0, "found");
		}
		else if (found instanceof IBusModelProtSchemaDef) || (found instanceof IBusModelProtSchemaDef) || (found instanceof IBusModelPubSchemaDef)) {
			super.setRequiredContainerSchemaDef(argSchemaDefId);
		requiredSchemaDefId = argSchemaDefId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerSchemaDef-args", "found", found, "IBusModelProtSchemaDefIBusModelProtSchemaDefIBusModelPubSchemaDef");
		}
	}

	@Override
	public void setRequiredContainerSchemaDef(IBusModelProtSchemaDef argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerSchemaDef", 1, "argObj");
		}
		else {
			setJustProtRequiredSchemaDefId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredContainerSchemaDef(IBusModelPubSchemaDef argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerSchemaDef", 1, "argObj");
		}
		else {
			setJustProtRequiredSchemaDefId(argObj.getRequiredId());
		}
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
	public IBusModelProtIndex getOptionalLookupLookupIndex(IYCFKeyHash256 argLookupIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupLookupIndex", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupLookupIndex", 0, "IBusModelProtSchema.getBackingBusModel().getTableIndex()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalLookupIndexId()));
	}

	@Override
	public void setOptionalLookupLookupIndex(IYCFKeyHash256 argLookupIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupLookupIndex-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupLookupIndex", 0, "IBusModelSchema.getBackingBusModel().getTableIndex()");
		}
		IBusModelProtIndex found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argLookupIndexId);
		if (found == null || (found != null && ((found instanceof IBusModelProtIndex) || (found instanceof IBusModelProtIndex) || (found instanceof IBusModelPubIndex)))) {
			super.setOptionalLookupLookupIndex(argLookupIndexId);
		optionalLookupIndexId = argLookupIndexId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setOptionalLookupLookupIndex-args", "found", found, "IBusModelProtIndexIBusModelProtIndexIBusModelPubIndex");
		}
	}

	@Override
	public void setOptionalLookupLookupIndex(IBusModelProtIndex argObj) {

		if(argObj == null) {
			setJustProtOptionalLookupIndexId(null);
		}
		else {
			setJustProtOptionalLookupIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupLookupIndex(IBusModelPubIndex argObj) {

		if(argObj == null) {
			setJustProtOptionalLookupIndexId(null);
		}
		else {
			setJustProtOptionalLookupIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public IBusModelProtIndex getOptionalLookupAltIndex(IYCFKeyHash256 argAltIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupAltIndex", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupAltIndex", 0, "IBusModelProtSchema.getBackingBusModel().getTableIndex()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalAltIndexId()));
	}

	@Override
	public void setOptionalLookupAltIndex(IYCFKeyHash256 argAltIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupAltIndex-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupAltIndex", 0, "IBusModelSchema.getBackingBusModel().getTableIndex()");
		}
		IBusModelProtIndex found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argAltIndexId);
		if (found == null || (found != null && ((found instanceof IBusModelProtIndex) || (found instanceof IBusModelProtIndex) || (found instanceof IBusModelPubIndex)))) {
			super.setOptionalLookupAltIndex(argAltIndexId);
		optionalAltIndexId = argAltIndexId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setOptionalLookupAltIndex-args", "found", found, "IBusModelProtIndexIBusModelProtIndexIBusModelPubIndex");
		}
	}

	@Override
	public void setOptionalLookupAltIndex(IBusModelProtIndex argObj) {

		if(argObj == null) {
			setJustProtOptionalAltIndexId(null);
		}
		else {
			setJustProtOptionalAltIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupAltIndex(IBusModelPubIndex argObj) {

		if(argObj == null) {
			setJustProtOptionalAltIndexId(null);
		}
		else {
			setJustProtOptionalAltIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public IBusModelProtTable getOptionalLookupQualTable(IYCFKeyHash256 argQualifyingTableId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupQualTable", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtTableTable targetTable = targetBackingBusModel.getTableTable();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupQualTable", 0, "IBusModelProtSchema.getBackingBusModel().getTableTable()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalQualifyingTableId()));
	}

	@Override
	public void setOptionalLookupQualTable(IYCFKeyHash256 argQualifyingTableId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupQualTable-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtTableTable targetTable = targetBackingBusModel.getTableTable();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupQualTable", 0, "IBusModelSchema.getBackingBusModel().getTableTable()");
		}
		IBusModelProtTable found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argQualifyingTableId);
		if (found == null || (found != null && ((found instanceof IBusModelProtTable) || (found instanceof IBusModelProtTable) || (found instanceof IBusModelPubTable)))) {
			super.setOptionalLookupQualTable(argQualifyingTableId);
		optionalQualifyingTableId = argQualifyingTableId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setOptionalLookupQualTable-args", "found", found, "IBusModelProtTableIBusModelProtTableIBusModelPubTable");
		}
	}

	@Override
	public void setOptionalLookupQualTable(IBusModelProtTable argObj) {

		if(argObj == null) {
			setJustProtOptionalQualifyingTableId(null);
		}
		else {
			setJustProtOptionalQualifyingTableId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupQualTable(IBusModelPubTable argObj) {

		if(argObj == null) {
			setJustProtOptionalQualifyingTableId(null);
		}
		else {
			setJustProtOptionalQualifyingTableId(argObj.getRequiredId());
		}
	}

	@Override
	public IBusModelProtIndex getOptionalLookupPrimaryIndex(IYCFKeyHash256 argPrimaryIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupPrimaryIndex", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupPrimaryIndex", 0, "IBusModelProtSchema.getBackingBusModel().getTableIndex()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalPrimaryIndexId()));
	}

	@Override
	public void setOptionalLookupPrimaryIndex(IYCFKeyHash256 argPrimaryIndexId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupPrimaryIndex-args", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupPrimaryIndex", 0, "IBusModelSchema.getBackingBusModel().getTableIndex()");
		}
		IBusModelProtIndex found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPrimaryIndexId);
		if (found == null || (found != null && ((found instanceof IBusModelProtIndex) || (found instanceof IBusModelProtIndex) || (found instanceof IBusModelPubIndex)))) {
			super.setOptionalLookupPrimaryIndex(argPrimaryIndexId);
		optionalPrimaryIndexId = argPrimaryIndexId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setOptionalLookupPrimaryIndex-args", "found", found, "IBusModelProtIndexIBusModelProtIndexIBusModelPubIndex");
		}
	}

	@Override
	public void setOptionalLookupPrimaryIndex(IBusModelProtIndex argObj) {

		if(argObj == null) {
			setJustProtOptionalPrimaryIndexId(null);
		}
		else {
			setJustProtOptionalPrimaryIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public void setOptionalLookupPrimaryIndex(IBusModelPubIndex argObj) {

		if(argObj == null) {
			setJustProtOptionalPrimaryIndexId(null);
		}
		else {
			setJustProtOptionalPrimaryIndexId(argObj.getRequiredId());
		}
	}

	@Override
	public List<IBusModelProtRelation> getOptionalComponentsRelation(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsRelation", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtRelationTable targetTable = targetBackingBusModel.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsRelation", 0, "IBusModelProtSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelProtRelation[] targetArr = targetTable.readDerivedByRelTableIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtRelation> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtRelation> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelProtIndex> getOptionalComponentsIndex(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsIndex", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtIndexTable targetTable = targetBackingBusModel.getTableIndex();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsIndex", 0, "IBusModelProtSchema.getBackingBusModel().getTableIndex()");
		}
		IBusModelProtIndex[] targetArr = targetTable.readDerivedByIdxTableIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtIndex> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtIndex> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelProtValue> getOptionalComponentsColumns(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsColumns", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtValueTable targetTable = targetBackingBusModel.getTableValue();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsColumns", 0, "IBusModelProtSchema.getBackingBusModel().getTableValue()");
		}
		IBusModelProtValue[] targetArr = targetTable.readDerivedByScopeIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtValue> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtValue> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelProtRelation> getOptionalChildrenReverseRelations(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalChildrenReverseRelations", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtRelationTable targetTable = targetBackingBusModel.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalChildrenReverseRelations", 0, "IBusModelProtSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelProtRelation[] targetArr = targetTable.readDerivedByToTblIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtRelation> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtRelation> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelProtChain> getOptionalComponentsChains(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsChains", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtChainTable targetTable = targetBackingBusModel.getTableChain();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsChains", 0, "IBusModelProtSchema.getBackingBusModel().getTableChain()");
		}
		IBusModelProtChain[] targetArr = targetTable.readDerivedByChainTableIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtChain> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtChain> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelProtDelTopDep> getOptionalComponentsDelDep(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtDelTopDepTable targetTable = targetBackingBusModel.getTableDelTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsDelDep", 0, "IBusModelProtSchema.getBackingBusModel().getTableDelTopDep()");
		}
		IBusModelProtDelTopDep[] targetArr = targetTable.readDerivedByDelTopDepTblIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtDelTopDep> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtDelTopDep> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelProtClearTopDep> getOptionalComponentsClearDep(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtClearTopDepTable targetTable = targetBackingBusModel.getTableClearTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsClearDep", 0, "IBusModelProtSchema.getBackingBusModel().getTableClearTopDep()");
		}
		IBusModelProtClearTopDep[] targetArr = targetTable.readDerivedByClrTopDepTblIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtClearTopDep> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtClearTopDep> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelProtServerMethod> getOptionalComponentsServerMethods(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsServerMethods", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtServerMethodTable targetTable = targetBackingBusModel.getTableServerMethod();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsServerMethods", 0, "IBusModelProtSchema.getBackingBusModel().getTableServerMethod()");
		}
		IBusModelProtServerMethod[] targetArr = targetTable.readDerivedByMethTableIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtServerMethod> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtServerMethod> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelProtTweak> getOptionalComponentsTweaks(IYCFKeyHash256 argId) {
		IBusModelProtSchema targetBackingBusModel = IBusModelProtSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsTweaks", 0, "IBusModelProtSchema.getBackingBusModel()");
		}
		IBusModelProtTweakTable targetTable = targetBackingBusModel.getTableTweak();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsTweaks", 0, "IBusModelProtSchema.getBackingBusModel().getTableTweak()");
		}
		IBusModelProtTweak[] targetArr = targetTable.readDerivedByScopeIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelProtTweak> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelProtTweak> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredSchemaDefId() {
		return(requiredSchemaDefId);
	}

	public void setRequiredSchemaDefId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredSchemaDefId",
				1,
				"value" );
		}
		requiredSchemaDefId = value;
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
		if( value != null && value.length() > 50 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				50 );
		}
		optionalShortDescription = value;
	}

	@Override
	public String getOptionalDescription() {
		return(optionalDescription);
	}

	public void setOptionalDescription( String value ) {
		if( value != null && value.length() > 100 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				100 );
		}
		optionalDescription = value;
	}

	@Override
	public boolean getRequiredPageData() {
		return(requiredPageData);
	}

	public void setRequiredPageData( boolean value ) {
		requiredPageData = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalPrimaryIndexId() {
		return(optionalPrimaryIndexId);
	}

	public void setOptionalPrimaryIndexId( IYCFKeyHash256 value ) {
		optionalPrimaryIndexId = value;
	}

	@Override
	public String getRequiredTableClassCode() {
		return(requiredTableClassCode);
	}

	public void setRequiredTableClassCode( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredTableClassCode",
				1,
				"value" );
		}
		else if( value.length() > 4 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredTableClassCode",
				1,
				"value.length()",
				value.length(),
				4 );
		}
		requiredTableClassCode = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalLookupIndexId() {
		return(optionalLookupIndexId);
	}

	public void setOptionalLookupIndexId( IYCFKeyHash256 value ) {
		optionalLookupIndexId = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalAltIndexId() {
		return(optionalAltIndexId);
	}

	public void setOptionalAltIndexId( IYCFKeyHash256 value ) {
		optionalAltIndexId = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalQualifyingTableId() {
		return(optionalQualifyingTableId);
	}

	public void setOptionalQualifyingTableId( IYCFKeyHash256 value ) {
		optionalQualifyingTableId = value;
	}

	@Override
	public boolean getRequiredIsInstantiable() {
		return(requiredIsInstantiable);
	}

	public void setRequiredIsInstantiable( boolean value ) {
		requiredIsInstantiable = value;
	}

	@Override
	public boolean getRequiredHasHistory() {
		return(requiredHasHistory);
	}

	public void setRequiredHasHistory( boolean value ) {
		requiredHasHistory = value;
	}

	@Override
	public boolean getRequiredHasAuditColumns() {
		return(requiredHasAuditColumns);
	}

	public void setRequiredHasAuditColumns( boolean value ) {
		requiredHasAuditColumns = value;
	}

	@Override
	public boolean getRequiredIsMutable() {
		return(requiredIsMutable);
	}

	public void setRequiredIsMutable( boolean value ) {
		requiredIsMutable = value;
	}

	@Override
	public boolean getRequiredIsServerOnly() {
		return(requiredIsServerOnly);
	}

	public void setRequiredIsServerOnly( boolean value ) {
		requiredIsServerOnly = value;
	}

	@Override
	public IBusModelPubSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour() {
		return(requiredLoaderBehaviour);
	}

	public void setRequiredLoaderBehaviour( IBusModelPubSchema.LoaderBehaviourEnum value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredLoaderBehaviour",
				1,
				"value" );
		}
		requiredLoaderBehaviour = value;
	}

	@Override
	public IBusModelPubSchema.SecScopeEnum getRequiredSecScope() {
		return(requiredSecScope);
	}

	public void setRequiredSecScope( IBusModelPubSchema.SecScopeEnum value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredSecScope",
				1,
				"value" );
		}
		requiredSecScope = value;
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
		else if( obj instanceof IBusModelProtTable rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
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
			if( getRequiredPageData() != rhs.getRequiredPageData() ) {
				return( false );
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredTableClassCode() != null ) {
				if( rhs.getRequiredTableClassCode() != null ) {
					if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableClassCode() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstantiable() != rhs.getRequiredIsInstantiable() ) {
				return( false );
			}
			if( getRequiredHasHistory() != rhs.getRequiredHasHistory() ) {
				return( false );
			}
			if( getRequiredHasAuditColumns() != rhs.getRequiredHasAuditColumns() ) {
				return( false );
			}
			if( getRequiredIsMutable() != rhs.getRequiredIsMutable() ) {
				return( false );
			}
			if( getRequiredIsServerOnly() != rhs.getRequiredIsServerOnly() ) {
				return( false );
			}
			if( getRequiredLoaderBehaviour() != null ) {
				if( rhs.getRequiredLoaderBehaviour() != null ) {
					if( ! getRequiredLoaderBehaviour().equals( rhs.getRequiredLoaderBehaviour() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoaderBehaviour() != null ) {
					return( false );
				}
			}
			if( getRequiredSecScope() != null ) {
				if( rhs.getRequiredSecScope() != null ) {
					if( ! getRequiredSecScope().equals( rhs.getRequiredSecScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecScope() != null ) {
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
		else if( obj instanceof IBusModelProtTableH rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
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
			if( getRequiredPageData() != rhs.getRequiredPageData() ) {
				return( false );
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredTableClassCode() != null ) {
				if( rhs.getRequiredTableClassCode() != null ) {
					if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableClassCode() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstantiable() != rhs.getRequiredIsInstantiable() ) {
				return( false );
			}
			if( getRequiredHasHistory() != rhs.getRequiredHasHistory() ) {
				return( false );
			}
			if( getRequiredHasAuditColumns() != rhs.getRequiredHasAuditColumns() ) {
				return( false );
			}
			if( getRequiredIsMutable() != rhs.getRequiredIsMutable() ) {
				return( false );
			}
			if( getRequiredIsServerOnly() != rhs.getRequiredIsServerOnly() ) {
				return( false );
			}
			if( getRequiredLoaderBehaviour() != null ) {
				if( rhs.getRequiredLoaderBehaviour() != null ) {
					if( ! getRequiredLoaderBehaviour().equals( rhs.getRequiredLoaderBehaviour() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoaderBehaviour() != null ) {
					return( false );
				}
			}
			if( getRequiredSecScope() != null ) {
				if( rhs.getRequiredSecScope() != null ) {
					if( ! getRequiredSecScope().equals( rhs.getRequiredSecScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecScope() != null ) {
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
		else if( obj instanceof IBusModelProtTableBySchemaDefIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByCodeVisIdxKey rhs ) {
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
		else if( obj instanceof IBusModelProtTableBySchemaCodeVisIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
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
		else if( obj instanceof IBusModelProtTableByDefSchemaIdxKey rhs ) {
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
		else if( obj instanceof IBusModelProtTableByUNameIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
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
		else if( obj instanceof IBusModelProtTableBySchemaCdIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredTableClassCode() != null ) {
				if( rhs.getRequiredTableClassCode() != null ) {
					if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableClassCode() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByPrimaryIndexIdxKey rhs ) {
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByLookupIndexIdxKey rhs ) {
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByAltIndexIdxKey rhs ) {
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByQualTableIdxKey rhs ) {
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubTable rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
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
			if( getRequiredPageData() != rhs.getRequiredPageData() ) {
				return( false );
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredTableClassCode() != null ) {
				if( rhs.getRequiredTableClassCode() != null ) {
					if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableClassCode() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstantiable() != rhs.getRequiredIsInstantiable() ) {
				return( false );
			}
			if( getRequiredHasHistory() != rhs.getRequiredHasHistory() ) {
				return( false );
			}
			if( getRequiredHasAuditColumns() != rhs.getRequiredHasAuditColumns() ) {
				return( false );
			}
			if( getRequiredIsMutable() != rhs.getRequiredIsMutable() ) {
				return( false );
			}
			if( getRequiredIsServerOnly() != rhs.getRequiredIsServerOnly() ) {
				return( false );
			}
			if( getRequiredLoaderBehaviour() != null ) {
				if( rhs.getRequiredLoaderBehaviour() != null ) {
					if( ! getRequiredLoaderBehaviour().equals( rhs.getRequiredLoaderBehaviour() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoaderBehaviour() != null ) {
					return( false );
				}
			}
			if( getRequiredSecScope() != null ) {
				if( rhs.getRequiredSecScope() != null ) {
					if( ! getRequiredSecScope().equals( rhs.getRequiredSecScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecScope() != null ) {
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
		else if( obj instanceof IBusModelPubTableH rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
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
			if( getRequiredPageData() != rhs.getRequiredPageData() ) {
				return( false );
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			if( getRequiredTableClassCode() != null ) {
				if( rhs.getRequiredTableClassCode() != null ) {
					if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableClassCode() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstantiable() != rhs.getRequiredIsInstantiable() ) {
				return( false );
			}
			if( getRequiredHasHistory() != rhs.getRequiredHasHistory() ) {
				return( false );
			}
			if( getRequiredHasAuditColumns() != rhs.getRequiredHasAuditColumns() ) {
				return( false );
			}
			if( getRequiredIsMutable() != rhs.getRequiredIsMutable() ) {
				return( false );
			}
			if( getRequiredIsServerOnly() != rhs.getRequiredIsServerOnly() ) {
				return( false );
			}
			if( getRequiredLoaderBehaviour() != null ) {
				if( rhs.getRequiredLoaderBehaviour() != null ) {
					if( ! getRequiredLoaderBehaviour().equals( rhs.getRequiredLoaderBehaviour() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoaderBehaviour() != null ) {
					return( false );
				}
			}
			if( getRequiredSecScope() != null ) {
				if( rhs.getRequiredSecScope() != null ) {
					if( ! getRequiredSecScope().equals( rhs.getRequiredSecScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecScope() != null ) {
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
		else if( obj instanceof IBusModelProtTableBySchemaDefIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByCodeVisIdxKey rhs ) {
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
		else if( obj instanceof IBusModelProtTableBySchemaCodeVisIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
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
		else if( obj instanceof IBusModelProtTableByDefSchemaIdxKey rhs ) {
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
		else if( obj instanceof IBusModelProtTableByUNameIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
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
		else if( obj instanceof IBusModelProtTableBySchemaCdIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredTableClassCode() != null ) {
				if( rhs.getRequiredTableClassCode() != null ) {
					if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableClassCode() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByPrimaryIndexIdxKey rhs ) {
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByLookupIndexIdxKey rhs ) {
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByAltIndexIdxKey rhs ) {
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtTableByQualTableIdxKey rhs ) {
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
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
		hashCode = hashCode + getRequiredSchemaDefId().hashCode();
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalDbName() != null ) {
			hashCode = hashCode + getOptionalDbName().hashCode();
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
		if( getRequiredPageData() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getOptionalPrimaryIndexId() != null ) {
			hashCode = hashCode + getOptionalPrimaryIndexId().hashCode();
		}
		if( getRequiredTableClassCode() != null ) {
			hashCode = hashCode + getRequiredTableClassCode().hashCode();
		}
		if( getOptionalLookupIndexId() != null ) {
			hashCode = hashCode + getOptionalLookupIndexId().hashCode();
		}
		if( getOptionalAltIndexId() != null ) {
			hashCode = hashCode + getOptionalAltIndexId().hashCode();
		}
		if( getOptionalQualifyingTableId() != null ) {
			hashCode = hashCode + getOptionalQualifyingTableId().hashCode();
		}
		if( getRequiredIsInstantiable() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredHasHistory() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredHasAuditColumns() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredIsMutable() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredIsServerOnly() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredLoaderBehaviour().ordinal();
		hashCode = ( hashCode * 0x10000 ) + getRequiredSecScope().ordinal();
		hashCode = ( hashCode * 0x10000 ) + getRequiredCodeVis().ordinal();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof IBusModelProtTable rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
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
			if( getRequiredPageData() ) {
				if( ! rhs.getRequiredPageData() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredPageData() ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					cmp = getOptionalPrimaryIndexId().compareTo( rhs.getOptionalPrimaryIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredTableClassCode() != null) {
				if (rhs.getRequiredTableClassCode() != null) {
					cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableClassCode() != null) {
				return( -1 );
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					cmp = getOptionalLookupIndexId().compareTo( rhs.getOptionalLookupIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					cmp = getOptionalAltIndexId().compareTo( rhs.getOptionalAltIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					cmp = getOptionalQualifyingTableId().compareTo( rhs.getOptionalQualifyingTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstantiable() ) {
				if( ! rhs.getRequiredIsInstantiable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstantiable() ) {
					return( -1 );
				}
			}
			if( getRequiredHasHistory() ) {
				if( ! rhs.getRequiredHasHistory() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasHistory() ) {
					return( -1 );
				}
			}
			if( getRequiredHasAuditColumns() ) {
				if( ! rhs.getRequiredHasAuditColumns() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasAuditColumns() ) {
					return( -1 );
				}
			}
			if( getRequiredIsMutable() ) {
				if( ! rhs.getRequiredIsMutable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsMutable() ) {
					return( -1 );
				}
			}
			if( getRequiredIsServerOnly() ) {
				if( ! rhs.getRequiredIsServerOnly() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsServerOnly() ) {
					return( -1 );
				}
			}
			if (getRequiredLoaderBehaviour() != null) {
				if (rhs.getRequiredLoaderBehaviour() != null) {
					cmp = getRequiredLoaderBehaviour().compareTo( rhs.getRequiredLoaderBehaviour() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoaderBehaviour() != null) {
				return( -1 );
			}
			if (getRequiredSecScope() != null) {
				if (rhs.getRequiredSecScope() != null) {
					cmp = getRequiredSecScope().compareTo( rhs.getRequiredSecScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecScope() != null) {
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
		else if( obj instanceof IBusModelProtTableH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
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
			if( getRequiredPageData() ) {
				if( ! rhs.getRequiredPageData() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredPageData() ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					cmp = getOptionalPrimaryIndexId().compareTo( rhs.getOptionalPrimaryIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredTableClassCode() != null) {
				if (rhs.getRequiredTableClassCode() != null) {
					cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableClassCode() != null) {
				return( -1 );
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					cmp = getOptionalLookupIndexId().compareTo( rhs.getOptionalLookupIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					cmp = getOptionalAltIndexId().compareTo( rhs.getOptionalAltIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					cmp = getOptionalQualifyingTableId().compareTo( rhs.getOptionalQualifyingTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstantiable() ) {
				if( ! rhs.getRequiredIsInstantiable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstantiable() ) {
					return( -1 );
				}
			}
			if( getRequiredHasHistory() ) {
				if( ! rhs.getRequiredHasHistory() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasHistory() ) {
					return( -1 );
				}
			}
			if( getRequiredHasAuditColumns() ) {
				if( ! rhs.getRequiredHasAuditColumns() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasAuditColumns() ) {
					return( -1 );
				}
			}
			if( getRequiredIsMutable() ) {
				if( ! rhs.getRequiredIsMutable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsMutable() ) {
					return( -1 );
				}
			}
			if( getRequiredIsServerOnly() ) {
				if( ! rhs.getRequiredIsServerOnly() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsServerOnly() ) {
					return( -1 );
				}
			}
			if (getRequiredLoaderBehaviour() != null) {
				if (rhs.getRequiredLoaderBehaviour() != null) {
					cmp = getRequiredLoaderBehaviour().compareTo( rhs.getRequiredLoaderBehaviour() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoaderBehaviour() != null) {
				return( -1 );
			}
			if (getRequiredSecScope() != null) {
				if (rhs.getRequiredSecScope() != null) {
					cmp = getRequiredSecScope().compareTo( rhs.getRequiredSecScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecScope() != null) {
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
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelProtTableBySchemaDefIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtTableByCodeVisIdxKey rhs ) {
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
		else if( obj instanceof IBusModelProtTableBySchemaCodeVisIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
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
		else if( obj instanceof IBusModelProtTableByDefSchemaIdxKey rhs ) {
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
		else if( obj instanceof IBusModelProtTableByUNameIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
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
		else if( obj instanceof IBusModelProtTableBySchemaCdIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredTableClassCode() != null) {
				if (rhs.getRequiredTableClassCode() != null) {
					cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableClassCode() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtTableByPrimaryIndexIdxKey rhs ) {
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					cmp = getOptionalPrimaryIndexId().compareTo( rhs.getOptionalPrimaryIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtTableByLookupIndexIdxKey rhs ) {
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					cmp = getOptionalLookupIndexId().compareTo( rhs.getOptionalLookupIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtTableByAltIndexIdxKey rhs ) {
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					cmp = getOptionalAltIndexId().compareTo( rhs.getOptionalAltIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtTableByQualTableIdxKey rhs ) {
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					cmp = getOptionalQualifyingTableId().compareTo( rhs.getOptionalQualifyingTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubTable rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
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
			if( getRequiredPageData() ) {
				if( ! rhs.getRequiredPageData() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredPageData() ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					cmp = getOptionalPrimaryIndexId().compareTo( rhs.getOptionalPrimaryIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredTableClassCode() != null) {
				if (rhs.getRequiredTableClassCode() != null) {
					cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableClassCode() != null) {
				return( -1 );
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					cmp = getOptionalLookupIndexId().compareTo( rhs.getOptionalLookupIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					cmp = getOptionalAltIndexId().compareTo( rhs.getOptionalAltIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					cmp = getOptionalQualifyingTableId().compareTo( rhs.getOptionalQualifyingTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstantiable() ) {
				if( ! rhs.getRequiredIsInstantiable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstantiable() ) {
					return( -1 );
				}
			}
			if( getRequiredHasHistory() ) {
				if( ! rhs.getRequiredHasHistory() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasHistory() ) {
					return( -1 );
				}
			}
			if( getRequiredHasAuditColumns() ) {
				if( ! rhs.getRequiredHasAuditColumns() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasAuditColumns() ) {
					return( -1 );
				}
			}
			if( getRequiredIsMutable() ) {
				if( ! rhs.getRequiredIsMutable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsMutable() ) {
					return( -1 );
				}
			}
			if( getRequiredIsServerOnly() ) {
				if( ! rhs.getRequiredIsServerOnly() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsServerOnly() ) {
					return( -1 );
				}
			}
			if (getRequiredLoaderBehaviour() != null) {
				if (rhs.getRequiredLoaderBehaviour() != null) {
					cmp = getRequiredLoaderBehaviour().compareTo( rhs.getRequiredLoaderBehaviour() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoaderBehaviour() != null) {
				return( -1 );
			}
			if (getRequiredSecScope() != null) {
				if (rhs.getRequiredSecScope() != null) {
					cmp = getRequiredSecScope().compareTo( rhs.getRequiredSecScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecScope() != null) {
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
		else if( obj instanceof IBusModelPubTableH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
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
			if( getRequiredPageData() ) {
				if( ! rhs.getRequiredPageData() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredPageData() ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					cmp = getOptionalPrimaryIndexId().compareTo( rhs.getOptionalPrimaryIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredTableClassCode() != null) {
				if (rhs.getRequiredTableClassCode() != null) {
					cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableClassCode() != null) {
				return( -1 );
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					cmp = getOptionalLookupIndexId().compareTo( rhs.getOptionalLookupIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					cmp = getOptionalAltIndexId().compareTo( rhs.getOptionalAltIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					cmp = getOptionalQualifyingTableId().compareTo( rhs.getOptionalQualifyingTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstantiable() ) {
				if( ! rhs.getRequiredIsInstantiable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstantiable() ) {
					return( -1 );
				}
			}
			if( getRequiredHasHistory() ) {
				if( ! rhs.getRequiredHasHistory() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasHistory() ) {
					return( -1 );
				}
			}
			if( getRequiredHasAuditColumns() ) {
				if( ! rhs.getRequiredHasAuditColumns() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasAuditColumns() ) {
					return( -1 );
				}
			}
			if( getRequiredIsMutable() ) {
				if( ! rhs.getRequiredIsMutable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsMutable() ) {
					return( -1 );
				}
			}
			if( getRequiredIsServerOnly() ) {
				if( ! rhs.getRequiredIsServerOnly() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsServerOnly() ) {
					return( -1 );
				}
			}
			if (getRequiredLoaderBehaviour() != null) {
				if (rhs.getRequiredLoaderBehaviour() != null) {
					cmp = getRequiredLoaderBehaviour().compareTo( rhs.getRequiredLoaderBehaviour() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoaderBehaviour() != null) {
				return( -1 );
			}
			if (getRequiredSecScope() != null) {
				if (rhs.getRequiredSecScope() != null) {
					cmp = getRequiredSecScope().compareTo( rhs.getRequiredSecScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecScope() != null) {
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
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubTableBySchemaDefIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubTableByCodeVisIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPubTableBySchemaCodeVisIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
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
		else if( obj instanceof IBusModelPubTableByDefSchemaIdxKey rhs ) {
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
		else if( obj instanceof IBusModelPubTableByUNameIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
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
		else if( obj instanceof IBusModelPubTableBySchemaCdIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredTableClassCode() != null) {
				if (rhs.getRequiredTableClassCode() != null) {
					cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableClassCode() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubTableByPrimaryIndexIdxKey rhs ) {
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					cmp = getOptionalPrimaryIndexId().compareTo( rhs.getOptionalPrimaryIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubTableByLookupIndexIdxKey rhs ) {
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					cmp = getOptionalLookupIndexId().compareTo( rhs.getOptionalLookupIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubTableByAltIndexIdxKey rhs ) {
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					cmp = getOptionalAltIndexId().compareTo( rhs.getOptionalAltIndexId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubTableByQualTableIdxKey rhs ) {
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					cmp = getOptionalQualifyingTableId().compareTo( rhs.getOptionalQualifyingTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
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
		if( src instanceof BusModelProtBuffTable ) {
			setJustProtTable( (BusModelProtBuffTable)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffTable" );
		}
	}

	@Override
	public void setTable( IBusModelProtTable src ) {
		super.setScope( src );
		setJustProtRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtOptionalLookupLookupIndex(src.getOptionalLookupLookupIndex());
		setJustProtOptionalLookupAltIndex(src.getOptionalLookupAltIndex());
		setJustProtOptionalLookupQualTable(src.getOptionalLookupQualTable());
		setJustProtOptionalLookupPrimaryIndex(src.getOptionalLookupPrimaryIndex());
		setJustProtRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDbName(src.getOptionalDbName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtRequiredPageData(src.getRequiredPageData());
		setJustProtOptionalPrimaryIndexId(src.getOptionalPrimaryIndexId());
		setJustProtRequiredTableClassCode(src.getRequiredTableClassCode());
		setJustProtOptionalLookupIndexId(src.getOptionalLookupIndexId());
		setJustProtOptionalAltIndexId(src.getOptionalAltIndexId());
		setJustProtOptionalQualifyingTableId(src.getOptionalQualifyingTableId());
		setJustProtRequiredIsInstantiable(src.getRequiredIsInstantiable());
		setJustProtRequiredHasHistory(src.getRequiredHasHistory());
		setJustProtRequiredHasAuditColumns(src.getRequiredHasAuditColumns());
		setJustProtRequiredIsMutable(src.getRequiredIsMutable());
		setJustProtRequiredIsServerOnly(src.getRequiredIsServerOnly());
		setJustProtRequiredLoaderBehaviour(src.getRequiredLoaderBehaviour());
		setJustProtRequiredSecScope(src.getRequiredSecScope());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
	}

	@Override
	public void set( IBusModelProtScopeH src ) {
		if( src instanceof IBusModelPubTableH ) {
			setTable( (IBusModelPubTableH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubTableH" );
		}
	}

	@Override
	public void setTable( IBusModelProtTableH src ) {
		super.setScope( src );
		setJustProtRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtOptionalLookupLookupIndex(src.getOptionalLookupLookupIndex());
		setJustProtOptionalLookupAltIndex(src.getOptionalLookupAltIndex());
		setJustProtOptionalLookupQualTable(src.getOptionalLookupQualTable());
		setJustProtOptionalLookupPrimaryIndex(src.getOptionalLookupPrimaryIndex());
		setJustProtRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDbName(src.getOptionalDbName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtRequiredPageData(src.getRequiredPageData());
		setJustProtOptionalPrimaryIndexId(src.getOptionalPrimaryIndexId());
		setJustProtRequiredTableClassCode(src.getRequiredTableClassCode());
		setJustProtOptionalLookupIndexId(src.getOptionalLookupIndexId());
		setJustProtOptionalAltIndexId(src.getOptionalAltIndexId());
		setJustProtOptionalQualifyingTableId(src.getOptionalQualifyingTableId());
		setJustProtRequiredIsInstantiable(src.getRequiredIsInstantiable());
		setJustProtRequiredHasHistory(src.getRequiredHasHistory());
		setJustProtRequiredHasAuditColumns(src.getRequiredHasAuditColumns());
		setJustProtRequiredIsMutable(src.getRequiredIsMutable());
		setJustProtRequiredIsServerOnly(src.getRequiredIsServerOnly());
		setJustProtRequiredLoaderBehaviour(src.getRequiredLoaderBehaviour());
		setJustProtRequiredSecScope(src.getRequiredSecScope());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubProtBuffTable ) {
			setJustProtTable( (BusModelPubProtBuffTable)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubProtBuffTable" );
		}
	}

	@Override
	public void setTable( IBusModelPubTable src ) {
		super.setScope( src );
		setJustProtRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtOptionalLookupLookupIndex(src.getOptionalLookupLookupIndex());
		setJustProtOptionalLookupAltIndex(src.getOptionalLookupAltIndex());
		setJustProtOptionalLookupQualTable(src.getOptionalLookupQualTable());
		setJustProtOptionalLookupPrimaryIndex(src.getOptionalLookupPrimaryIndex());
		setJustProtRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDbName(src.getOptionalDbName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtRequiredPageData(src.getRequiredPageData());
		setJustProtOptionalPrimaryIndexId(src.getOptionalPrimaryIndexId());
		setJustProtRequiredTableClassCode(src.getRequiredTableClassCode());
		setJustProtOptionalLookupIndexId(src.getOptionalLookupIndexId());
		setJustProtOptionalAltIndexId(src.getOptionalAltIndexId());
		setJustProtOptionalQualifyingTableId(src.getOptionalQualifyingTableId());
		setJustProtRequiredIsInstantiable(src.getRequiredIsInstantiable());
		setJustProtRequiredHasHistory(src.getRequiredHasHistory());
		setJustProtRequiredHasAuditColumns(src.getRequiredHasAuditColumns());
		setJustProtRequiredIsMutable(src.getRequiredIsMutable());
		setJustProtRequiredIsServerOnly(src.getRequiredIsServerOnly());
		setJustProtRequiredLoaderBehaviour(src.getRequiredLoaderBehaviour());
		setJustProtRequiredSecScope(src.getRequiredSecScope());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubTableH ) {
			setTable( (IBusModelPubTableH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubTableH" );
		}
	}

	@Override
	public void setTable( IBusModelPubTableH src ) {
		super.setScope( src );
		setJustProtRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setJustProtOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setJustProtOptionalLookupLookupIndex(src.getOptionalLookupLookupIndex());
		setJustProtOptionalLookupAltIndex(src.getOptionalLookupAltIndex());
		setJustProtOptionalLookupQualTable(src.getOptionalLookupQualTable());
		setJustProtOptionalLookupPrimaryIndex(src.getOptionalLookupPrimaryIndex());
		setJustProtRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setJustProtOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDbName(src.getOptionalDbName());
		setJustProtOptionalShortName(src.getOptionalShortName());
		setJustProtOptionalLabel(src.getOptionalLabel());
		setJustProtOptionalShortDescription(src.getOptionalShortDescription());
		setJustProtOptionalDescription(src.getOptionalDescription());
		setJustProtRequiredPageData(src.getRequiredPageData());
		setJustProtOptionalPrimaryIndexId(src.getOptionalPrimaryIndexId());
		setJustProtRequiredTableClassCode(src.getRequiredTableClassCode());
		setJustProtOptionalLookupIndexId(src.getOptionalLookupIndexId());
		setJustProtOptionalAltIndexId(src.getOptionalAltIndexId());
		setJustProtOptionalQualifyingTableId(src.getOptionalQualifyingTableId());
		setJustProtRequiredIsInstantiable(src.getRequiredIsInstantiable());
		setJustProtRequiredHasHistory(src.getRequiredHasHistory());
		setJustProtRequiredHasAuditColumns(src.getRequiredHasAuditColumns());
		setJustProtRequiredIsMutable(src.getRequiredIsMutable());
		setJustProtRequiredIsServerOnly(src.getRequiredIsServerOnly());
		setJustProtRequiredLoaderBehaviour(src.getRequiredLoaderBehaviour());
		setJustProtRequiredSecScope(src.getRequiredSecScope());
		setJustProtRequiredCodeVis(src.getRequiredCodeVis());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredSchemaDefId().toString() + "\"" + ( ( getOptionalDefSchemaId() == null ) ? "null" : "\"" + getOptionalDefSchemaId().toString() + "\"" ) + "\"" + getRequiredId().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"" + ( ( getOptionalDbName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDbName() ) + "\"" ) + ( ( getOptionalShortName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortName() ) + "\"" ) + ( ( getOptionalLabel() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalLabel() ) + "\"" ) + ( ( getOptionalShortDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortDescription() ) + "\"" ) + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" ) + (( getRequiredPageData() ) ? "\"true\"" : "\"false\"" ) + ( ( getOptionalPrimaryIndexId() == null ) ? "null" : "\"" + getOptionalPrimaryIndexId().toString() + "\"" ) + "\"" + StringEscapeUtils.escapeXml11( getRequiredTableClassCode() ) + "\"" + ( ( getOptionalLookupIndexId() == null ) ? "null" : "\"" + getOptionalLookupIndexId().toString() + "\"" ) + ( ( getOptionalAltIndexId() == null ) ? "null" : "\"" + getOptionalAltIndexId().toString() + "\"" ) + ( ( getOptionalQualifyingTableId() == null ) ? "null" : "\"" + getOptionalQualifyingTableId().toString() + "\"" ) + (( getRequiredIsInstantiable() ) ? "\"true\"" : "\"false\"" ) + (( getRequiredHasHistory() ) ? "\"true\"" : "\"false\"" ) + (( getRequiredHasAuditColumns() ) ? "\"true\"" : "\"false\"" ) + (( getRequiredIsMutable() ) ? "\"true\"" : "\"false\"" ) + (( getRequiredIsServerOnly() ) ? "\"true\"" : "\"false\"" ) + "\"" + getRequiredLoaderBehaviour().toString() + "\"" + "\"" + getRequiredSecScope().toString() + "\"" + "\"" + getRequiredCodeVis().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelProtBuffTable" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
