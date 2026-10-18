// Description: Java 25 Schema Object implementation for BusModel.

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

public class BusModelSchemaObj
	implements IBusModelSchemaObj
{
	public static final String SCHEMA_NAME = IBusModelSchema.SCHEMA_NAME;
	public static final String SCHEMA_DBNAME = IBusModelSchema.DBSCHEMA_NAME;
	protected ISecureAuthorization authorization = null;
	protected String secClusterName = "system";
	protected String secTenantName = "system";
	protected String secUserName = "system";
	protected ISecureClusterObj secCluster = null;
	protected YCFDbKeyHash256 secClusterId = null;
	protected ISecureTenantObj secTenant = null;
	protected YCFDbKeyHash256 secTenantId = null;
	protected ISecureSecUserObj secUser = null;
	protected YCFDbKeyHash256 secSessionUserId = null;
	protected ISecureSecSessionObj secSession = null;
	protected YCFDbKeyHash256 secSessionSessionId = null;
	protected String schemaDbName = SCHEMA_DBNAME;
	protected String lowerDbSchemaName = SCHEMA_DBNAME.toLowerCase();

	protected ISecureSchema secureBackingStore;
	protected IIntNetSchema intnetBackingStore;
	protected IBusModelSchema busmodelBackingStore;
	protected IBusModelAtomTableObj atomTableObj;
	protected IBusModelBlobColTableObj blobColTableObj;
	protected IBusModelBlobDefTableObj blobDefTableObj;
	protected IBusModelBlobTypeTableObj blobTypeTableObj;
	protected IBusModelBoolColTableObj boolColTableObj;
	protected IBusModelBoolDefTableObj boolDefTableObj;
	protected IBusModelBoolTypeTableObj boolTypeTableObj;
	protected IBusModelChainTableObj chainTableObj;
	protected IBusModelClearDepTableObj clearDepTableObj;
	protected IBusModelClearSubDep1TableObj clearSubDep1TableObj;
	protected IBusModelClearSubDep2TableObj clearSubDep2TableObj;
	protected IBusModelClearSubDep3TableObj clearSubDep3TableObj;
	protected IBusModelClearTopDepTableObj clearTopDepTableObj;
	protected IBusModelClusterTableObj clusterTableObj;
	protected IBusModelDateColTableObj dateColTableObj;
	protected IBusModelDateDefTableObj dateDefTableObj;
	protected IBusModelDateTypeTableObj dateTypeTableObj;
	protected IBusModelDbKeyHash128ColTableObj dbKeyHash128ColTableObj;
	protected IBusModelDbKeyHash128DefTableObj dbKeyHash128DefTableObj;
	protected IBusModelDbKeyHash128GenTableObj dbKeyHash128GenTableObj;
	protected IBusModelDbKeyHash128TypeTableObj dbKeyHash128TypeTableObj;
	protected IBusModelDbKeyHash160ColTableObj dbKeyHash160ColTableObj;
	protected IBusModelDbKeyHash160DefTableObj dbKeyHash160DefTableObj;
	protected IBusModelDbKeyHash160GenTableObj dbKeyHash160GenTableObj;
	protected IBusModelDbKeyHash160TypeTableObj dbKeyHash160TypeTableObj;
	protected IBusModelDbKeyHash224ColTableObj dbKeyHash224ColTableObj;
	protected IBusModelDbKeyHash224DefTableObj dbKeyHash224DefTableObj;
	protected IBusModelDbKeyHash224GenTableObj dbKeyHash224GenTableObj;
	protected IBusModelDbKeyHash224TypeTableObj dbKeyHash224TypeTableObj;
	protected IBusModelDbKeyHash256ColTableObj dbKeyHash256ColTableObj;
	protected IBusModelDbKeyHash256DefTableObj dbKeyHash256DefTableObj;
	protected IBusModelDbKeyHash256GenTableObj dbKeyHash256GenTableObj;
	protected IBusModelDbKeyHash256TypeTableObj dbKeyHash256TypeTableObj;
	protected IBusModelDbKeyHash384ColTableObj dbKeyHash384ColTableObj;
	protected IBusModelDbKeyHash384DefTableObj dbKeyHash384DefTableObj;
	protected IBusModelDbKeyHash384GenTableObj dbKeyHash384GenTableObj;
	protected IBusModelDbKeyHash384TypeTableObj dbKeyHash384TypeTableObj;
	protected IBusModelDbKeyHash512ColTableObj dbKeyHash512ColTableObj;
	protected IBusModelDbKeyHash512DefTableObj dbKeyHash512DefTableObj;
	protected IBusModelDbKeyHash512GenTableObj dbKeyHash512GenTableObj;
	protected IBusModelDbKeyHash512TypeTableObj dbKeyHash512TypeTableObj;
	protected IBusModelDelDepTableObj delDepTableObj;
	protected IBusModelDelSubDep1TableObj delSubDep1TableObj;
	protected IBusModelDelSubDep2TableObj delSubDep2TableObj;
	protected IBusModelDelSubDep3TableObj delSubDep3TableObj;
	protected IBusModelDelTopDepTableObj delTopDepTableObj;
	protected IBusModelDoubleColTableObj doubleColTableObj;
	protected IBusModelDoubleDefTableObj doubleDefTableObj;
	protected IBusModelDoubleTypeTableObj doubleTypeTableObj;
	protected IBusModelEnumDefTableObj enumDefTableObj;
	protected IBusModelEnumTagTableObj enumTagTableObj;
	protected IBusModelEnumTypeTableObj enumTypeTableObj;
	protected IBusModelFloatColTableObj floatColTableObj;
	protected IBusModelFloatDefTableObj floatDefTableObj;
	protected IBusModelFloatTypeTableObj floatTypeTableObj;
	protected IBusModelISOCcyTableObj iSOCcyTableObj;
	protected IBusModelISOCtryTableObj iSOCtryTableObj;
	protected IBusModelISOCtryCcyTableObj iSOCtryCcyTableObj;
	protected IBusModelISOCtryLangTableObj iSOCtryLangTableObj;
	protected IBusModelISOLangTableObj iSOLangTableObj;
	protected IBusModelISOTZoneTableObj iSOTZoneTableObj;
	protected IBusModelId16GenTableObj id16GenTableObj;
	protected IBusModelId32GenTableObj id32GenTableObj;
	protected IBusModelId64GenTableObj id64GenTableObj;
	protected IBusModelIndexTableObj indexTableObj;
	protected IBusModelIndexColTableObj indexColTableObj;
	protected IBusModelIndexTweakTableObj indexTweakTableObj;
	protected IBusModelInt16ColTableObj int16ColTableObj;
	protected IBusModelInt16DefTableObj int16DefTableObj;
	protected IBusModelInt16TypeTableObj int16TypeTableObj;
	protected IBusModelInt32ColTableObj int32ColTableObj;
	protected IBusModelInt32DefTableObj int32DefTableObj;
	protected IBusModelInt32TypeTableObj int32TypeTableObj;
	protected IBusModelInt64ColTableObj int64ColTableObj;
	protected IBusModelInt64DefTableObj int64DefTableObj;
	protected IBusModelInt64TypeTableObj int64TypeTableObj;
	protected IBusModelLicenseTableObj licenseTableObj;
	protected IBusModelMajorVersionTableObj majorVersionTableObj;
	protected IBusModelMimeTypeTableObj mimeTypeTableObj;
	protected IBusModelMinorVersionTableObj minorVersionTableObj;
	protected IBusModelNmTokenColTableObj nmTokenColTableObj;
	protected IBusModelNmTokenDefTableObj nmTokenDefTableObj;
	protected IBusModelNmTokenTypeTableObj nmTokenTypeTableObj;
	protected IBusModelNmTokensColTableObj nmTokensColTableObj;
	protected IBusModelNmTokensDefTableObj nmTokensDefTableObj;
	protected IBusModelNmTokensTypeTableObj nmTokensTypeTableObj;
	protected IBusModelNumberColTableObj numberColTableObj;
	protected IBusModelNumberDefTableObj numberDefTableObj;
	protected IBusModelNumberTypeTableObj numberTypeTableObj;
	protected IBusModelParamTableObj paramTableObj;
	protected IBusModelPopDepTableObj popDepTableObj;
	protected IBusModelPopSubDep1TableObj popSubDep1TableObj;
	protected IBusModelPopSubDep2TableObj popSubDep2TableObj;
	protected IBusModelPopSubDep3TableObj popSubDep3TableObj;
	protected IBusModelPopTopDepTableObj popTopDepTableObj;
	protected IBusModelRelationTableObj relationTableObj;
	protected IBusModelRelationColTableObj relationColTableObj;
	protected IBusModelRoleDefTableObj roleDefTableObj;
	protected IBusModelSchemaDefTableObj schemaDefTableObj;
	protected IBusModelSchemaRefTableObj schemaRefTableObj;
	protected IBusModelSchemaRoleTableObj schemaRoleTableObj;
	protected IBusModelSchemaTweakTableObj schemaTweakTableObj;
	protected IBusModelScopeTableObj scopeTableObj;
	protected IBusModelSecClusGrpTableObj secClusGrpTableObj;
	protected IBusModelSecClusGrpMembTableObj secClusGrpMembTableObj;
	protected IBusModelSecClusRoleTableObj secClusRoleTableObj;
	protected IBusModelSecClusRoleMembTableObj secClusRoleMembTableObj;
	protected IBusModelSecSessionTableObj secSessionTableObj;
	protected IBusModelSecSysGrpTableObj secSysGrpTableObj;
	protected IBusModelSecSysGrpIncTableObj secSysGrpIncTableObj;
	protected IBusModelSecSysGrpMembTableObj secSysGrpMembTableObj;
	protected IBusModelSecSysRoleTableObj secSysRoleTableObj;
	protected IBusModelSecSysRoleEnablesTableObj secSysRoleEnablesTableObj;
	protected IBusModelSecSysRoleMembTableObj secSysRoleMembTableObj;
	protected IBusModelSecTentGrpTableObj secTentGrpTableObj;
	protected IBusModelSecTentGrpMembTableObj secTentGrpMembTableObj;
	protected IBusModelSecTentRoleTableObj secTentRoleTableObj;
	protected IBusModelSecTentRoleMembTableObj secTentRoleMembTableObj;
	protected IBusModelSecUserTableObj secUserTableObj;
	protected IBusModelSecUserEMConfTableObj secUserEMConfTableObj;
	protected IBusModelSecUserPWHistoryTableObj secUserPWHistoryTableObj;
	protected IBusModelSecUserPWResetTableObj secUserPWResetTableObj;
	protected IBusModelSecUserPasswordTableObj secUserPasswordTableObj;
	protected IBusModelServerListFuncTableObj serverListFuncTableObj;
	protected IBusModelServerMethodTableObj serverMethodTableObj;
	protected IBusModelServerObjFuncTableObj serverObjFuncTableObj;
	protected IBusModelServerProcTableObj serverProcTableObj;
	protected IBusModelStringColTableObj stringColTableObj;
	protected IBusModelStringDefTableObj stringDefTableObj;
	protected IBusModelStringTypeTableObj stringTypeTableObj;
	protected IBusModelSubProjectTableObj subProjectTableObj;
	protected IBusModelSysClusterTableObj sysClusterTableObj;
	protected IBusModelTZDateColTableObj tZDateColTableObj;
	protected IBusModelTZDateDefTableObj tZDateDefTableObj;
	protected IBusModelTZDateTypeTableObj tZDateTypeTableObj;
	protected IBusModelTZTimeColTableObj tZTimeColTableObj;
	protected IBusModelTZTimeDefTableObj tZTimeDefTableObj;
	protected IBusModelTZTimeTypeTableObj tZTimeTypeTableObj;
	protected IBusModelTZTimestampColTableObj tZTimestampColTableObj;
	protected IBusModelTZTimestampDefTableObj tZTimestampDefTableObj;
	protected IBusModelTZTimestampTypeTableObj tZTimestampTypeTableObj;
	protected IBusModelTableTableObj tableTableObj;
	protected IBusModelTableColTableObj tableColTableObj;
	protected IBusModelTableInfoTableObj tableInfoTableObj;
	protected IBusModelTableTweakTableObj tableTweakTableObj;
	protected IBusModelTenantTableObj tenantTableObj;
	protected IBusModelTextColTableObj textColTableObj;
	protected IBusModelTextDefTableObj textDefTableObj;
	protected IBusModelTextTypeTableObj textTypeTableObj;
	protected IBusModelTimeColTableObj timeColTableObj;
	protected IBusModelTimeDefTableObj timeDefTableObj;
	protected IBusModelTimeTypeTableObj timeTypeTableObj;
	protected IBusModelTimestampColTableObj timestampColTableObj;
	protected IBusModelTimestampDefTableObj timestampDefTableObj;
	protected IBusModelTimestampTypeTableObj timestampTypeTableObj;
	protected IBusModelTldTableObj tldTableObj;
	protected IBusModelTokenColTableObj tokenColTableObj;
	protected IBusModelTokenDefTableObj tokenDefTableObj;
	protected IBusModelTokenTypeTableObj tokenTypeTableObj;
	protected IBusModelTopDomainTableObj topDomainTableObj;
	protected IBusModelTopProjectTableObj topProjectTableObj;
	protected IBusModelTweakTableObj tweakTableObj;
	protected IBusModelUInt16ColTableObj uInt16ColTableObj;
	protected IBusModelUInt16DefTableObj uInt16DefTableObj;
	protected IBusModelUInt16TypeTableObj uInt16TypeTableObj;
	protected IBusModelUInt32ColTableObj uInt32ColTableObj;
	protected IBusModelUInt32DefTableObj uInt32DefTableObj;
	protected IBusModelUInt32TypeTableObj uInt32TypeTableObj;
	protected IBusModelUInt64ColTableObj uInt64ColTableObj;
	protected IBusModelUInt64DefTableObj uInt64DefTableObj;
	protected IBusModelUInt64TypeTableObj uInt64TypeTableObj;
	protected IBusModelURLProtocolTableObj uRLProtocolTableObj;
	protected IBusModelUuid6ColTableObj uuid6ColTableObj;
	protected IBusModelUuid6DefTableObj uuid6DefTableObj;
	protected IBusModelUuid6GenTableObj uuid6GenTableObj;
	protected IBusModelUuid6TypeTableObj uuid6TypeTableObj;
	protected IBusModelUuidColTableObj uuidColTableObj;
	protected IBusModelUuidDefTableObj uuidDefTableObj;
	protected IBusModelUuidGenTableObj uuidGenTableObj;
	protected IBusModelUuidTypeTableObj uuidTypeTableObj;
	protected IBusModelValueTableObj valueTableObj;

	public BusModelSchemaObj() {

		secureBackingStore = null;
		intnetBackingStore = null;
		busmodelBackingStore = null;
		atomTableObj = new BusModelAtomTableObj( this );
		blobColTableObj = new BusModelBlobColTableObj( this );
		blobDefTableObj = new BusModelBlobDefTableObj( this );
		blobTypeTableObj = new BusModelBlobTypeTableObj( this );
		boolColTableObj = new BusModelBoolColTableObj( this );
		boolDefTableObj = new BusModelBoolDefTableObj( this );
		boolTypeTableObj = new BusModelBoolTypeTableObj( this );
		chainTableObj = new BusModelChainTableObj( this );
		clearDepTableObj = new BusModelClearDepTableObj( this );
		clearSubDep1TableObj = new BusModelClearSubDep1TableObj( this );
		clearSubDep2TableObj = new BusModelClearSubDep2TableObj( this );
		clearSubDep3TableObj = new BusModelClearSubDep3TableObj( this );
		clearTopDepTableObj = new BusModelClearTopDepTableObj( this );
		clusterTableObj = new BusModelClusterTableObj( this );
		dateColTableObj = new BusModelDateColTableObj( this );
		dateDefTableObj = new BusModelDateDefTableObj( this );
		dateTypeTableObj = new BusModelDateTypeTableObj( this );
		dbKeyHash128ColTableObj = new BusModelDbKeyHash128ColTableObj( this );
		dbKeyHash128DefTableObj = new BusModelDbKeyHash128DefTableObj( this );
		dbKeyHash128GenTableObj = new BusModelDbKeyHash128GenTableObj( this );
		dbKeyHash128TypeTableObj = new BusModelDbKeyHash128TypeTableObj( this );
		dbKeyHash160ColTableObj = new BusModelDbKeyHash160ColTableObj( this );
		dbKeyHash160DefTableObj = new BusModelDbKeyHash160DefTableObj( this );
		dbKeyHash160GenTableObj = new BusModelDbKeyHash160GenTableObj( this );
		dbKeyHash160TypeTableObj = new BusModelDbKeyHash160TypeTableObj( this );
		dbKeyHash224ColTableObj = new BusModelDbKeyHash224ColTableObj( this );
		dbKeyHash224DefTableObj = new BusModelDbKeyHash224DefTableObj( this );
		dbKeyHash224GenTableObj = new BusModelDbKeyHash224GenTableObj( this );
		dbKeyHash224TypeTableObj = new BusModelDbKeyHash224TypeTableObj( this );
		dbKeyHash256ColTableObj = new BusModelDbKeyHash256ColTableObj( this );
		dbKeyHash256DefTableObj = new BusModelDbKeyHash256DefTableObj( this );
		dbKeyHash256GenTableObj = new BusModelDbKeyHash256GenTableObj( this );
		dbKeyHash256TypeTableObj = new BusModelDbKeyHash256TypeTableObj( this );
		dbKeyHash384ColTableObj = new BusModelDbKeyHash384ColTableObj( this );
		dbKeyHash384DefTableObj = new BusModelDbKeyHash384DefTableObj( this );
		dbKeyHash384GenTableObj = new BusModelDbKeyHash384GenTableObj( this );
		dbKeyHash384TypeTableObj = new BusModelDbKeyHash384TypeTableObj( this );
		dbKeyHash512ColTableObj = new BusModelDbKeyHash512ColTableObj( this );
		dbKeyHash512DefTableObj = new BusModelDbKeyHash512DefTableObj( this );
		dbKeyHash512GenTableObj = new BusModelDbKeyHash512GenTableObj( this );
		dbKeyHash512TypeTableObj = new BusModelDbKeyHash512TypeTableObj( this );
		delDepTableObj = new BusModelDelDepTableObj( this );
		delSubDep1TableObj = new BusModelDelSubDep1TableObj( this );
		delSubDep2TableObj = new BusModelDelSubDep2TableObj( this );
		delSubDep3TableObj = new BusModelDelSubDep3TableObj( this );
		delTopDepTableObj = new BusModelDelTopDepTableObj( this );
		doubleColTableObj = new BusModelDoubleColTableObj( this );
		doubleDefTableObj = new BusModelDoubleDefTableObj( this );
		doubleTypeTableObj = new BusModelDoubleTypeTableObj( this );
		enumDefTableObj = new BusModelEnumDefTableObj( this );
		enumTagTableObj = new BusModelEnumTagTableObj( this );
		enumTypeTableObj = new BusModelEnumTypeTableObj( this );
		floatColTableObj = new BusModelFloatColTableObj( this );
		floatDefTableObj = new BusModelFloatDefTableObj( this );
		floatTypeTableObj = new BusModelFloatTypeTableObj( this );
		iSOCcyTableObj = new BusModelISOCcyTableObj( this );
		iSOCtryTableObj = new BusModelISOCtryTableObj( this );
		iSOCtryCcyTableObj = new BusModelISOCtryCcyTableObj( this );
		iSOCtryLangTableObj = new BusModelISOCtryLangTableObj( this );
		iSOLangTableObj = new BusModelISOLangTableObj( this );
		iSOTZoneTableObj = new BusModelISOTZoneTableObj( this );
		id16GenTableObj = new BusModelId16GenTableObj( this );
		id32GenTableObj = new BusModelId32GenTableObj( this );
		id64GenTableObj = new BusModelId64GenTableObj( this );
		indexTableObj = new BusModelIndexTableObj( this );
		indexColTableObj = new BusModelIndexColTableObj( this );
		indexTweakTableObj = new BusModelIndexTweakTableObj( this );
		int16ColTableObj = new BusModelInt16ColTableObj( this );
		int16DefTableObj = new BusModelInt16DefTableObj( this );
		int16TypeTableObj = new BusModelInt16TypeTableObj( this );
		int32ColTableObj = new BusModelInt32ColTableObj( this );
		int32DefTableObj = new BusModelInt32DefTableObj( this );
		int32TypeTableObj = new BusModelInt32TypeTableObj( this );
		int64ColTableObj = new BusModelInt64ColTableObj( this );
		int64DefTableObj = new BusModelInt64DefTableObj( this );
		int64TypeTableObj = new BusModelInt64TypeTableObj( this );
		licenseTableObj = new BusModelLicenseTableObj( this );
		majorVersionTableObj = new BusModelMajorVersionTableObj( this );
		mimeTypeTableObj = new BusModelMimeTypeTableObj( this );
		minorVersionTableObj = new BusModelMinorVersionTableObj( this );
		nmTokenColTableObj = new BusModelNmTokenColTableObj( this );
		nmTokenDefTableObj = new BusModelNmTokenDefTableObj( this );
		nmTokenTypeTableObj = new BusModelNmTokenTypeTableObj( this );
		nmTokensColTableObj = new BusModelNmTokensColTableObj( this );
		nmTokensDefTableObj = new BusModelNmTokensDefTableObj( this );
		nmTokensTypeTableObj = new BusModelNmTokensTypeTableObj( this );
		numberColTableObj = new BusModelNumberColTableObj( this );
		numberDefTableObj = new BusModelNumberDefTableObj( this );
		numberTypeTableObj = new BusModelNumberTypeTableObj( this );
		paramTableObj = new BusModelParamTableObj( this );
		popDepTableObj = new BusModelPopDepTableObj( this );
		popSubDep1TableObj = new BusModelPopSubDep1TableObj( this );
		popSubDep2TableObj = new BusModelPopSubDep2TableObj( this );
		popSubDep3TableObj = new BusModelPopSubDep3TableObj( this );
		popTopDepTableObj = new BusModelPopTopDepTableObj( this );
		relationTableObj = new BusModelRelationTableObj( this );
		relationColTableObj = new BusModelRelationColTableObj( this );
		roleDefTableObj = new BusModelRoleDefTableObj( this );
		schemaDefTableObj = new BusModelSchemaDefTableObj( this );
		schemaRefTableObj = new BusModelSchemaRefTableObj( this );
		schemaRoleTableObj = new BusModelSchemaRoleTableObj( this );
		schemaTweakTableObj = new BusModelSchemaTweakTableObj( this );
		scopeTableObj = new BusModelScopeTableObj( this );
		secClusGrpTableObj = new BusModelSecClusGrpTableObj( this );
		secClusGrpMembTableObj = new BusModelSecClusGrpMembTableObj( this );
		secClusRoleTableObj = new BusModelSecClusRoleTableObj( this );
		secClusRoleMembTableObj = new BusModelSecClusRoleMembTableObj( this );
		secSessionTableObj = new BusModelSecSessionTableObj( this );
		secSysGrpTableObj = new BusModelSecSysGrpTableObj( this );
		secSysGrpIncTableObj = new BusModelSecSysGrpIncTableObj( this );
		secSysGrpMembTableObj = new BusModelSecSysGrpMembTableObj( this );
		secSysRoleTableObj = new BusModelSecSysRoleTableObj( this );
		secSysRoleEnablesTableObj = new BusModelSecSysRoleEnablesTableObj( this );
		secSysRoleMembTableObj = new BusModelSecSysRoleMembTableObj( this );
		secTentGrpTableObj = new BusModelSecTentGrpTableObj( this );
		secTentGrpMembTableObj = new BusModelSecTentGrpMembTableObj( this );
		secTentRoleTableObj = new BusModelSecTentRoleTableObj( this );
		secTentRoleMembTableObj = new BusModelSecTentRoleMembTableObj( this );
		secUserTableObj = new BusModelSecUserTableObj( this );
		secUserEMConfTableObj = new BusModelSecUserEMConfTableObj( this );
		secUserPWHistoryTableObj = new BusModelSecUserPWHistoryTableObj( this );
		secUserPWResetTableObj = new BusModelSecUserPWResetTableObj( this );
		secUserPasswordTableObj = new BusModelSecUserPasswordTableObj( this );
		serverListFuncTableObj = new BusModelServerListFuncTableObj( this );
		serverMethodTableObj = new BusModelServerMethodTableObj( this );
		serverObjFuncTableObj = new BusModelServerObjFuncTableObj( this );
		serverProcTableObj = new BusModelServerProcTableObj( this );
		stringColTableObj = new BusModelStringColTableObj( this );
		stringDefTableObj = new BusModelStringDefTableObj( this );
		stringTypeTableObj = new BusModelStringTypeTableObj( this );
		subProjectTableObj = new BusModelSubProjectTableObj( this );
		sysClusterTableObj = new BusModelSysClusterTableObj( this );
		tZDateColTableObj = new BusModelTZDateColTableObj( this );
		tZDateDefTableObj = new BusModelTZDateDefTableObj( this );
		tZDateTypeTableObj = new BusModelTZDateTypeTableObj( this );
		tZTimeColTableObj = new BusModelTZTimeColTableObj( this );
		tZTimeDefTableObj = new BusModelTZTimeDefTableObj( this );
		tZTimeTypeTableObj = new BusModelTZTimeTypeTableObj( this );
		tZTimestampColTableObj = new BusModelTZTimestampColTableObj( this );
		tZTimestampDefTableObj = new BusModelTZTimestampDefTableObj( this );
		tZTimestampTypeTableObj = new BusModelTZTimestampTypeTableObj( this );
		tableTableObj = new BusModelTableTableObj( this );
		tableColTableObj = new BusModelTableColTableObj( this );
		tableInfoTableObj = new BusModelTableInfoTableObj( this );
		tableTweakTableObj = new BusModelTableTweakTableObj( this );
		tenantTableObj = new BusModelTenantTableObj( this );
		textColTableObj = new BusModelTextColTableObj( this );
		textDefTableObj = new BusModelTextDefTableObj( this );
		textTypeTableObj = new BusModelTextTypeTableObj( this );
		timeColTableObj = new BusModelTimeColTableObj( this );
		timeDefTableObj = new BusModelTimeDefTableObj( this );
		timeTypeTableObj = new BusModelTimeTypeTableObj( this );
		timestampColTableObj = new BusModelTimestampColTableObj( this );
		timestampDefTableObj = new BusModelTimestampDefTableObj( this );
		timestampTypeTableObj = new BusModelTimestampTypeTableObj( this );
		tldTableObj = new BusModelTldTableObj( this );
		tokenColTableObj = new BusModelTokenColTableObj( this );
		tokenDefTableObj = new BusModelTokenDefTableObj( this );
		tokenTypeTableObj = new BusModelTokenTypeTableObj( this );
		topDomainTableObj = new BusModelTopDomainTableObj( this );
		topProjectTableObj = new BusModelTopProjectTableObj( this );
		tweakTableObj = new BusModelTweakTableObj( this );
		uInt16ColTableObj = new BusModelUInt16ColTableObj( this );
		uInt16DefTableObj = new BusModelUInt16DefTableObj( this );
		uInt16TypeTableObj = new BusModelUInt16TypeTableObj( this );
		uInt32ColTableObj = new BusModelUInt32ColTableObj( this );
		uInt32DefTableObj = new BusModelUInt32DefTableObj( this );
		uInt32TypeTableObj = new BusModelUInt32TypeTableObj( this );
		uInt64ColTableObj = new BusModelUInt64ColTableObj( this );
		uInt64DefTableObj = new BusModelUInt64DefTableObj( this );
		uInt64TypeTableObj = new BusModelUInt64TypeTableObj( this );
		uRLProtocolTableObj = new BusModelURLProtocolTableObj( this );
		uuid6ColTableObj = new BusModelUuid6ColTableObj( this );
		uuid6DefTableObj = new BusModelUuid6DefTableObj( this );
		uuid6GenTableObj = new BusModelUuid6GenTableObj( this );
		uuid6TypeTableObj = new BusModelUuid6TypeTableObj( this );
		uuidColTableObj = new BusModelUuidColTableObj( this );
		uuidDefTableObj = new BusModelUuidDefTableObj( this );
		uuidGenTableObj = new BusModelUuidGenTableObj( this );
		uuidTypeTableObj = new BusModelUuidTypeTableObj( this );
		valueTableObj = new BusModelValueTableObj( this );
		}

	public void setSecClusterName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				"setClusterName",
				1,
				"value" );
		}
		secClusterName = value;
		secCluster = null;
	}

	public String getSecClusterName() {
		return( secClusterName );
	}

	public ISecureClusterObj getSecCluster() {
		if( secCluster == null ) {
			if( authorization != null ) {
				secCluster = getClusterTableObj().readClusterByIdIdx( authorization.getSecClusterId() );
			}
			else {
				secCluster = getClusterTableObj().readClusterByUDomNameIdx( secClusterName );
				if( secCluster == null && secClusterId != null && !secClusterId.isNull() ) {
					secCluster = getClusterTableObj().readClusterByIdIdx( secClusterId );
				}
			}
			if( secCluster != null ) {
				secClusterName = secCluster.getRequiredFullDomName();
				secClusterId = secCluster.getRequiredId();
				if( authorization != null ) {
					authorization.setSecCluster( secCluster );
				}
			}
		}
		return( secCluster );
	}

	public void setSecCluster( ISecureClusterObj value ) {
		secCluster = value;
		if( secCluster == null ) {
			return;
		}
		secClusterId = secCluster.getRequiredId();
		secClusterName = secCluster.getRequiredFullDomName();
		if( authorization != null ) {
			authorization.setSecCluster( secCluster );
		}
	}

	public YCFDbKeyHash256 getSecClusterId() {
		return( secClusterId );
	}

	public void setSecTenantName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				"setTenantName",
				1,
				"value" );
		}
		secTenantName = value;
		secTenant = null;
	}

	public String getSecTenantName() {
		return( secTenantName );
	}

	public ISecureTenantObj getSecTenant() {
		if( secTenant == null ) {
			if( authorization != null ) {
				secTenant = getTenantTableObj().readTenantByIdIdx( authorization.getSecTenantId() );
			}
			else {
				secTenant = getTenantTableObj().readTenantByUNameIdx( getSecCluster().getRequiredId(), secTenantName );
				if( ( secTenant == null && secTenantId != null && !secTenantId.isNull() ) ) {
					secTenant = getTenantTableObj().readTenantByIdIdx( secTenantId );
				}
			}
			if( secTenant != null ) {
				secTenantName = secTenant.getRequiredTenantName();
				secTenantId = secTenant.getRequiredId();
				if( authorization != null ) {
					authorization.setSecTenant( secTenant );
				}
			}
		}
		return( secTenant );
	}

	public void setSecTenant( ISecureTenantObj value ) {
		secTenant = value;
		if( secTenant == null ) {
			return;
		}
		secTenantId = secTenant.getRequiredId();
		secTenantName = secTenant.getRequiredTenantName();
		if( authorization != null ) {
			authorization.setSecTenant( secTenant );
		}
	}

	public YCFDbKeyHash256 getSecTenantId() {
		return( secTenantId );
	}

	public void setSecUserName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				"setUserName",
				1,
				"value" );
		}
		secUserName = value;
		secUser = null;
	}

	public String getSecUserName() {
		return( secUserName );
	}

	public ISecureSecUserObj getSecUser() {
		if( secUser == null ) {
			if( authorization != null ) {
				secUser = getSecUserTableObj().readSecUserByIdIdx( authorization.getSecUserId() );
			}
			else {
				secUser = getSecUserTableObj().readSecUserByULoginIdx( secUserName );
				if( ( secUser == null ) && ( secSessionUserId != null ) ) {
					secUser = getSecUserTableObj().readSecUserByIdIdx( secSessionUserId );
				}
			}
			if( secUser != null ) {
				secUserName = secUser.getRequiredLoginId();
				secSessionUserId = secUser.getRequiredSecUserId();
			}
		}
		return( secUser );
	}

	public void setSecUser( ISecureSecUserObj value ) {
		secUser = value;
		if( secUser != null ) {
			secUserName = secUser.getRequiredLoginId();
			secSessionUserId = secUser.getRequiredSecUserId();
		}
	}
	public ISecureSecSessionObj getSecSession() {
		if( secSession == null ) {
			if( authorization != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( authorization.getSecSessionId() );
			}
			else if( secSessionSessionId != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionSessionId );
			}
			if( secSession != null ) {
				secSessionSessionId = secSession.getRequiredSecSessionId();
				secSessionUserId = secSession.getRequiredSecUserId();
			}
		}
		return( secSession );
	}

	public void setSecSession( ISecureSecSessionObj value ) {
		secSession = value;
		if( secSession == null ) {
			return;
		}
		secSessionSessionId = secSession.getRequiredSecSessionId();
		secSessionUserId = secSession.getRequiredSecUserId();
		if( authorization != null ) {
			authorization.setSecSession( secSession );
		}
	}

	public void setSecSessionId( YCFDbKeyHash256 value ) {
		secSessionSessionId = value;
	}

	public YCFDbKeyHash256 getSecSessionSessionId() {
		return( secSessionSessionId );
	}

	public YCFDbKeyHash256 getSecSessionUserId() {
		return( secSessionUserId );
	}

	public ISecureAuthorization getAuthorization() {
		return( authorization );
	}

	public void setAuthorization( ISecureAuthorization value ) {
		authorization = value;
	}

	@Override
	public ISecureSchema getSecureBackingStore() {
		return( secureBackingStore );
	}

	@Override
	public void setSecureBackingStore(ISecureSchema secureBackingStore) {
		if (secureBackingStore == null) {
			throw new YCFNullArgumentException(getClass(), "setSecureBackingStore", 1, "secureBackingStore");
		}
		this.secureBackingStore = secureBackingStore;
	}

	@Override
	public IIntNetSchema getIntNetBackingStore() {
		return( intnetBackingStore );
	}

	@Override
	public void setIntNetBackingStore(IIntNetSchema intnetBackingStore) {
		if (intnetBackingStore == null) {
			throw new YCFNullArgumentException(getClass(), "setIntNetBackingStore", 1, "intnetBackingStore");
		}
		this.intnetBackingStore = intnetBackingStore;
	}

	@Override
	public IBusModelSchema getBusModelBackingStore() {
		return( busmodelBackingStore );
	}

	@Override
	public void setBusModelBackingStore(IBusModelSchema busmodelBackingStore) {
		if (busmodelBackingStore == null) {
			throw new YCFNullArgumentException(getClass(), "setBusModelBackingStore", 1, "busmodelBackingStore");
		}
		this.busmodelBackingStore = busmodelBackingStore;
	}

	public String getSchemaName() {
		return( SCHEMA_NAME );
	}

	public void minimizeMemory() {
		if( atomTableObj != null ) {
			atomTableObj.minimizeMemory();
		}
		if( blobColTableObj != null ) {
			blobColTableObj.minimizeMemory();
		}
		if( blobDefTableObj != null ) {
			blobDefTableObj.minimizeMemory();
		}
		if( blobTypeTableObj != null ) {
			blobTypeTableObj.minimizeMemory();
		}
		if( boolColTableObj != null ) {
			boolColTableObj.minimizeMemory();
		}
		if( boolDefTableObj != null ) {
			boolDefTableObj.minimizeMemory();
		}
		if( boolTypeTableObj != null ) {
			boolTypeTableObj.minimizeMemory();
		}
		if( chainTableObj != null ) {
			chainTableObj.minimizeMemory();
		}
		if( clearDepTableObj != null ) {
			clearDepTableObj.minimizeMemory();
		}
		if( clearSubDep1TableObj != null ) {
			clearSubDep1TableObj.minimizeMemory();
		}
		if( clearSubDep2TableObj != null ) {
			clearSubDep2TableObj.minimizeMemory();
		}
		if( clearSubDep3TableObj != null ) {
			clearSubDep3TableObj.minimizeMemory();
		}
		if( clearTopDepTableObj != null ) {
			clearTopDepTableObj.minimizeMemory();
		}
		if( clusterTableObj != null ) {
			clusterTableObj.minimizeMemory();
		}
		if( dateColTableObj != null ) {
			dateColTableObj.minimizeMemory();
		}
		if( dateDefTableObj != null ) {
			dateDefTableObj.minimizeMemory();
		}
		if( dateTypeTableObj != null ) {
			dateTypeTableObj.minimizeMemory();
		}
		if( dbKeyHash128ColTableObj != null ) {
			dbKeyHash128ColTableObj.minimizeMemory();
		}
		if( dbKeyHash128DefTableObj != null ) {
			dbKeyHash128DefTableObj.minimizeMemory();
		}
		if( dbKeyHash128GenTableObj != null ) {
			dbKeyHash128GenTableObj.minimizeMemory();
		}
		if( dbKeyHash128TypeTableObj != null ) {
			dbKeyHash128TypeTableObj.minimizeMemory();
		}
		if( dbKeyHash160ColTableObj != null ) {
			dbKeyHash160ColTableObj.minimizeMemory();
		}
		if( dbKeyHash160DefTableObj != null ) {
			dbKeyHash160DefTableObj.minimizeMemory();
		}
		if( dbKeyHash160GenTableObj != null ) {
			dbKeyHash160GenTableObj.minimizeMemory();
		}
		if( dbKeyHash160TypeTableObj != null ) {
			dbKeyHash160TypeTableObj.minimizeMemory();
		}
		if( dbKeyHash224ColTableObj != null ) {
			dbKeyHash224ColTableObj.minimizeMemory();
		}
		if( dbKeyHash224DefTableObj != null ) {
			dbKeyHash224DefTableObj.minimizeMemory();
		}
		if( dbKeyHash224GenTableObj != null ) {
			dbKeyHash224GenTableObj.minimizeMemory();
		}
		if( dbKeyHash224TypeTableObj != null ) {
			dbKeyHash224TypeTableObj.minimizeMemory();
		}
		if( dbKeyHash256ColTableObj != null ) {
			dbKeyHash256ColTableObj.minimizeMemory();
		}
		if( dbKeyHash256DefTableObj != null ) {
			dbKeyHash256DefTableObj.minimizeMemory();
		}
		if( dbKeyHash256GenTableObj != null ) {
			dbKeyHash256GenTableObj.minimizeMemory();
		}
		if( dbKeyHash256TypeTableObj != null ) {
			dbKeyHash256TypeTableObj.minimizeMemory();
		}
		if( dbKeyHash384ColTableObj != null ) {
			dbKeyHash384ColTableObj.minimizeMemory();
		}
		if( dbKeyHash384DefTableObj != null ) {
			dbKeyHash384DefTableObj.minimizeMemory();
		}
		if( dbKeyHash384GenTableObj != null ) {
			dbKeyHash384GenTableObj.minimizeMemory();
		}
		if( dbKeyHash384TypeTableObj != null ) {
			dbKeyHash384TypeTableObj.minimizeMemory();
		}
		if( dbKeyHash512ColTableObj != null ) {
			dbKeyHash512ColTableObj.minimizeMemory();
		}
		if( dbKeyHash512DefTableObj != null ) {
			dbKeyHash512DefTableObj.minimizeMemory();
		}
		if( dbKeyHash512GenTableObj != null ) {
			dbKeyHash512GenTableObj.minimizeMemory();
		}
		if( dbKeyHash512TypeTableObj != null ) {
			dbKeyHash512TypeTableObj.minimizeMemory();
		}
		if( delDepTableObj != null ) {
			delDepTableObj.minimizeMemory();
		}
		if( delSubDep1TableObj != null ) {
			delSubDep1TableObj.minimizeMemory();
		}
		if( delSubDep2TableObj != null ) {
			delSubDep2TableObj.minimizeMemory();
		}
		if( delSubDep3TableObj != null ) {
			delSubDep3TableObj.minimizeMemory();
		}
		if( delTopDepTableObj != null ) {
			delTopDepTableObj.minimizeMemory();
		}
		if( doubleColTableObj != null ) {
			doubleColTableObj.minimizeMemory();
		}
		if( doubleDefTableObj != null ) {
			doubleDefTableObj.minimizeMemory();
		}
		if( doubleTypeTableObj != null ) {
			doubleTypeTableObj.minimizeMemory();
		}
		if( enumDefTableObj != null ) {
			enumDefTableObj.minimizeMemory();
		}
		if( enumTagTableObj != null ) {
			enumTagTableObj.minimizeMemory();
		}
		if( enumTypeTableObj != null ) {
			enumTypeTableObj.minimizeMemory();
		}
		if( floatColTableObj != null ) {
			floatColTableObj.minimizeMemory();
		}
		if( floatDefTableObj != null ) {
			floatDefTableObj.minimizeMemory();
		}
		if( floatTypeTableObj != null ) {
			floatTypeTableObj.minimizeMemory();
		}
		if( iSOCcyTableObj != null ) {
			iSOCcyTableObj.minimizeMemory();
		}
		if( iSOCtryTableObj != null ) {
			iSOCtryTableObj.minimizeMemory();
		}
		if( iSOCtryCcyTableObj != null ) {
			iSOCtryCcyTableObj.minimizeMemory();
		}
		if( iSOCtryLangTableObj != null ) {
			iSOCtryLangTableObj.minimizeMemory();
		}
		if( iSOLangTableObj != null ) {
			iSOLangTableObj.minimizeMemory();
		}
		if( iSOTZoneTableObj != null ) {
			iSOTZoneTableObj.minimizeMemory();
		}
		if( id16GenTableObj != null ) {
			id16GenTableObj.minimizeMemory();
		}
		if( id32GenTableObj != null ) {
			id32GenTableObj.minimizeMemory();
		}
		if( id64GenTableObj != null ) {
			id64GenTableObj.minimizeMemory();
		}
		if( indexTableObj != null ) {
			indexTableObj.minimizeMemory();
		}
		if( indexColTableObj != null ) {
			indexColTableObj.minimizeMemory();
		}
		if( indexTweakTableObj != null ) {
			indexTweakTableObj.minimizeMemory();
		}
		if( int16ColTableObj != null ) {
			int16ColTableObj.minimizeMemory();
		}
		if( int16DefTableObj != null ) {
			int16DefTableObj.minimizeMemory();
		}
		if( int16TypeTableObj != null ) {
			int16TypeTableObj.minimizeMemory();
		}
		if( int32ColTableObj != null ) {
			int32ColTableObj.minimizeMemory();
		}
		if( int32DefTableObj != null ) {
			int32DefTableObj.minimizeMemory();
		}
		if( int32TypeTableObj != null ) {
			int32TypeTableObj.minimizeMemory();
		}
		if( int64ColTableObj != null ) {
			int64ColTableObj.minimizeMemory();
		}
		if( int64DefTableObj != null ) {
			int64DefTableObj.minimizeMemory();
		}
		if( int64TypeTableObj != null ) {
			int64TypeTableObj.minimizeMemory();
		}
		if( licenseTableObj != null ) {
			licenseTableObj.minimizeMemory();
		}
		if( majorVersionTableObj != null ) {
			majorVersionTableObj.minimizeMemory();
		}
		if( mimeTypeTableObj != null ) {
			mimeTypeTableObj.minimizeMemory();
		}
		if( minorVersionTableObj != null ) {
			minorVersionTableObj.minimizeMemory();
		}
		if( nmTokenColTableObj != null ) {
			nmTokenColTableObj.minimizeMemory();
		}
		if( nmTokenDefTableObj != null ) {
			nmTokenDefTableObj.minimizeMemory();
		}
		if( nmTokenTypeTableObj != null ) {
			nmTokenTypeTableObj.minimizeMemory();
		}
		if( nmTokensColTableObj != null ) {
			nmTokensColTableObj.minimizeMemory();
		}
		if( nmTokensDefTableObj != null ) {
			nmTokensDefTableObj.minimizeMemory();
		}
		if( nmTokensTypeTableObj != null ) {
			nmTokensTypeTableObj.minimizeMemory();
		}
		if( numberColTableObj != null ) {
			numberColTableObj.minimizeMemory();
		}
		if( numberDefTableObj != null ) {
			numberDefTableObj.minimizeMemory();
		}
		if( numberTypeTableObj != null ) {
			numberTypeTableObj.minimizeMemory();
		}
		if( paramTableObj != null ) {
			paramTableObj.minimizeMemory();
		}
		if( popDepTableObj != null ) {
			popDepTableObj.minimizeMemory();
		}
		if( popSubDep1TableObj != null ) {
			popSubDep1TableObj.minimizeMemory();
		}
		if( popSubDep2TableObj != null ) {
			popSubDep2TableObj.minimizeMemory();
		}
		if( popSubDep3TableObj != null ) {
			popSubDep3TableObj.minimizeMemory();
		}
		if( popTopDepTableObj != null ) {
			popTopDepTableObj.minimizeMemory();
		}
		if( relationTableObj != null ) {
			relationTableObj.minimizeMemory();
		}
		if( relationColTableObj != null ) {
			relationColTableObj.minimizeMemory();
		}
		if( roleDefTableObj != null ) {
			roleDefTableObj.minimizeMemory();
		}
		if( schemaDefTableObj != null ) {
			schemaDefTableObj.minimizeMemory();
		}
		if( schemaRefTableObj != null ) {
			schemaRefTableObj.minimizeMemory();
		}
		if( schemaRoleTableObj != null ) {
			schemaRoleTableObj.minimizeMemory();
		}
		if( schemaTweakTableObj != null ) {
			schemaTweakTableObj.minimizeMemory();
		}
		if( scopeTableObj != null ) {
			scopeTableObj.minimizeMemory();
		}
		if( secClusGrpTableObj != null ) {
			secClusGrpTableObj.minimizeMemory();
		}
		if( secClusGrpMembTableObj != null ) {
			secClusGrpMembTableObj.minimizeMemory();
		}
		if( secClusRoleTableObj != null ) {
			secClusRoleTableObj.minimizeMemory();
		}
		if( secClusRoleMembTableObj != null ) {
			secClusRoleMembTableObj.minimizeMemory();
		}
		if( secSessionTableObj != null ) {
			secSessionTableObj.minimizeMemory();
		}
		if( secSysGrpTableObj != null ) {
			secSysGrpTableObj.minimizeMemory();
		}
		if( secSysGrpIncTableObj != null ) {
			secSysGrpIncTableObj.minimizeMemory();
		}
		if( secSysGrpMembTableObj != null ) {
			secSysGrpMembTableObj.minimizeMemory();
		}
		if( secSysRoleTableObj != null ) {
			secSysRoleTableObj.minimizeMemory();
		}
		if( secSysRoleEnablesTableObj != null ) {
			secSysRoleEnablesTableObj.minimizeMemory();
		}
		if( secSysRoleMembTableObj != null ) {
			secSysRoleMembTableObj.minimizeMemory();
		}
		if( secTentGrpTableObj != null ) {
			secTentGrpTableObj.minimizeMemory();
		}
		if( secTentGrpMembTableObj != null ) {
			secTentGrpMembTableObj.minimizeMemory();
		}
		if( secTentRoleTableObj != null ) {
			secTentRoleTableObj.minimizeMemory();
		}
		if( secTentRoleMembTableObj != null ) {
			secTentRoleMembTableObj.minimizeMemory();
		}
		if( secUserTableObj != null ) {
			secUserTableObj.minimizeMemory();
		}
		if( secUserEMConfTableObj != null ) {
			secUserEMConfTableObj.minimizeMemory();
		}
		if( secUserPWHistoryTableObj != null ) {
			secUserPWHistoryTableObj.minimizeMemory();
		}
		if( secUserPWResetTableObj != null ) {
			secUserPWResetTableObj.minimizeMemory();
		}
		if( secUserPasswordTableObj != null ) {
			secUserPasswordTableObj.minimizeMemory();
		}
		if( serverListFuncTableObj != null ) {
			serverListFuncTableObj.minimizeMemory();
		}
		if( serverMethodTableObj != null ) {
			serverMethodTableObj.minimizeMemory();
		}
		if( serverObjFuncTableObj != null ) {
			serverObjFuncTableObj.minimizeMemory();
		}
		if( serverProcTableObj != null ) {
			serverProcTableObj.minimizeMemory();
		}
		if( stringColTableObj != null ) {
			stringColTableObj.minimizeMemory();
		}
		if( stringDefTableObj != null ) {
			stringDefTableObj.minimizeMemory();
		}
		if( stringTypeTableObj != null ) {
			stringTypeTableObj.minimizeMemory();
		}
		if( subProjectTableObj != null ) {
			subProjectTableObj.minimizeMemory();
		}
		if( sysClusterTableObj != null ) {
			sysClusterTableObj.minimizeMemory();
		}
		if( tZDateColTableObj != null ) {
			tZDateColTableObj.minimizeMemory();
		}
		if( tZDateDefTableObj != null ) {
			tZDateDefTableObj.minimizeMemory();
		}
		if( tZDateTypeTableObj != null ) {
			tZDateTypeTableObj.minimizeMemory();
		}
		if( tZTimeColTableObj != null ) {
			tZTimeColTableObj.minimizeMemory();
		}
		if( tZTimeDefTableObj != null ) {
			tZTimeDefTableObj.minimizeMemory();
		}
		if( tZTimeTypeTableObj != null ) {
			tZTimeTypeTableObj.minimizeMemory();
		}
		if( tZTimestampColTableObj != null ) {
			tZTimestampColTableObj.minimizeMemory();
		}
		if( tZTimestampDefTableObj != null ) {
			tZTimestampDefTableObj.minimizeMemory();
		}
		if( tZTimestampTypeTableObj != null ) {
			tZTimestampTypeTableObj.minimizeMemory();
		}
		if( tableTableObj != null ) {
			tableTableObj.minimizeMemory();
		}
		if( tableColTableObj != null ) {
			tableColTableObj.minimizeMemory();
		}
		if( tableInfoTableObj != null ) {
			tableInfoTableObj.minimizeMemory();
		}
		if( tableTweakTableObj != null ) {
			tableTweakTableObj.minimizeMemory();
		}
		if( tenantTableObj != null ) {
			tenantTableObj.minimizeMemory();
		}
		if( textColTableObj != null ) {
			textColTableObj.minimizeMemory();
		}
		if( textDefTableObj != null ) {
			textDefTableObj.minimizeMemory();
		}
		if( textTypeTableObj != null ) {
			textTypeTableObj.minimizeMemory();
		}
		if( timeColTableObj != null ) {
			timeColTableObj.minimizeMemory();
		}
		if( timeDefTableObj != null ) {
			timeDefTableObj.minimizeMemory();
		}
		if( timeTypeTableObj != null ) {
			timeTypeTableObj.minimizeMemory();
		}
		if( timestampColTableObj != null ) {
			timestampColTableObj.minimizeMemory();
		}
		if( timestampDefTableObj != null ) {
			timestampDefTableObj.minimizeMemory();
		}
		if( timestampTypeTableObj != null ) {
			timestampTypeTableObj.minimizeMemory();
		}
		if( tldTableObj != null ) {
			tldTableObj.minimizeMemory();
		}
		if( tokenColTableObj != null ) {
			tokenColTableObj.minimizeMemory();
		}
		if( tokenDefTableObj != null ) {
			tokenDefTableObj.minimizeMemory();
		}
		if( tokenTypeTableObj != null ) {
			tokenTypeTableObj.minimizeMemory();
		}
		if( topDomainTableObj != null ) {
			topDomainTableObj.minimizeMemory();
		}
		if( topProjectTableObj != null ) {
			topProjectTableObj.minimizeMemory();
		}
		if( tweakTableObj != null ) {
			tweakTableObj.minimizeMemory();
		}
		if( uInt16ColTableObj != null ) {
			uInt16ColTableObj.minimizeMemory();
		}
		if( uInt16DefTableObj != null ) {
			uInt16DefTableObj.minimizeMemory();
		}
		if( uInt16TypeTableObj != null ) {
			uInt16TypeTableObj.minimizeMemory();
		}
		if( uInt32ColTableObj != null ) {
			uInt32ColTableObj.minimizeMemory();
		}
		if( uInt32DefTableObj != null ) {
			uInt32DefTableObj.minimizeMemory();
		}
		if( uInt32TypeTableObj != null ) {
			uInt32TypeTableObj.minimizeMemory();
		}
		if( uInt64ColTableObj != null ) {
			uInt64ColTableObj.minimizeMemory();
		}
		if( uInt64DefTableObj != null ) {
			uInt64DefTableObj.minimizeMemory();
		}
		if( uInt64TypeTableObj != null ) {
			uInt64TypeTableObj.minimizeMemory();
		}
		if( uRLProtocolTableObj != null ) {
			uRLProtocolTableObj.minimizeMemory();
		}
		if( uuid6ColTableObj != null ) {
			uuid6ColTableObj.minimizeMemory();
		}
		if( uuid6DefTableObj != null ) {
			uuid6DefTableObj.minimizeMemory();
		}
		if( uuid6GenTableObj != null ) {
			uuid6GenTableObj.minimizeMemory();
		}
		if( uuid6TypeTableObj != null ) {
			uuid6TypeTableObj.minimizeMemory();
		}
		if( uuidColTableObj != null ) {
			uuidColTableObj.minimizeMemory();
		}
		if( uuidDefTableObj != null ) {
			uuidDefTableObj.minimizeMemory();
		}
		if( uuidGenTableObj != null ) {
			uuidGenTableObj.minimizeMemory();
		}
		if( uuidTypeTableObj != null ) {
			uuidTypeTableObj.minimizeMemory();
		}
		if( valueTableObj != null ) {
			valueTableObj.minimizeMemory();
		}
	}

	public void logout() {
		if( authorization == null ) {
			return;
		}
		setAuthorization( null );
		YCFDbKeyHash256 secSessionId = authorization.getSecSessionId();
		if( secSessionId != null ) {
			ISecureSecSessionObj secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionId );
			if( secSession != null ) {
				if( secSession.getOptionalFinish() == null ) {
					ISecureSecSessionEditObj editSecSession = secSession.beginEdit();
					editSecSession.setOptionalFinish( LocalDateTime.now() );
					editSecSession.update();
					editSecSession = null;
				}
			}
		}
	}

	public IBusModelAtomTableObj getAtomTableObj() {
		return( atomTableObj );
	}

	public IBusModelBlobColTableObj getBlobColTableObj() {
		return( blobColTableObj );
	}

	public IBusModelBlobDefTableObj getBlobDefTableObj() {
		return( blobDefTableObj );
	}

	public IBusModelBlobTypeTableObj getBlobTypeTableObj() {
		return( blobTypeTableObj );
	}

	public IBusModelBoolColTableObj getBoolColTableObj() {
		return( boolColTableObj );
	}

	public IBusModelBoolDefTableObj getBoolDefTableObj() {
		return( boolDefTableObj );
	}

	public IBusModelBoolTypeTableObj getBoolTypeTableObj() {
		return( boolTypeTableObj );
	}

	public IBusModelChainTableObj getChainTableObj() {
		return( chainTableObj );
	}

	public IBusModelClearDepTableObj getClearDepTableObj() {
		return( clearDepTableObj );
	}

	public IBusModelClearSubDep1TableObj getClearSubDep1TableObj() {
		return( clearSubDep1TableObj );
	}

	public IBusModelClearSubDep2TableObj getClearSubDep2TableObj() {
		return( clearSubDep2TableObj );
	}

	public IBusModelClearSubDep3TableObj getClearSubDep3TableObj() {
		return( clearSubDep3TableObj );
	}

	public IBusModelClearTopDepTableObj getClearTopDepTableObj() {
		return( clearTopDepTableObj );
	}

	public IBusModelClusterTableObj getClusterTableObj() {
		return( clusterTableObj );
	}

	public IBusModelDateColTableObj getDateColTableObj() {
		return( dateColTableObj );
	}

	public IBusModelDateDefTableObj getDateDefTableObj() {
		return( dateDefTableObj );
	}

	public IBusModelDateTypeTableObj getDateTypeTableObj() {
		return( dateTypeTableObj );
	}

	public IBusModelDbKeyHash128ColTableObj getDbKeyHash128ColTableObj() {
		return( dbKeyHash128ColTableObj );
	}

	public IBusModelDbKeyHash128DefTableObj getDbKeyHash128DefTableObj() {
		return( dbKeyHash128DefTableObj );
	}

	public IBusModelDbKeyHash128GenTableObj getDbKeyHash128GenTableObj() {
		return( dbKeyHash128GenTableObj );
	}

	public IBusModelDbKeyHash128TypeTableObj getDbKeyHash128TypeTableObj() {
		return( dbKeyHash128TypeTableObj );
	}

	public IBusModelDbKeyHash160ColTableObj getDbKeyHash160ColTableObj() {
		return( dbKeyHash160ColTableObj );
	}

	public IBusModelDbKeyHash160DefTableObj getDbKeyHash160DefTableObj() {
		return( dbKeyHash160DefTableObj );
	}

	public IBusModelDbKeyHash160GenTableObj getDbKeyHash160GenTableObj() {
		return( dbKeyHash160GenTableObj );
	}

	public IBusModelDbKeyHash160TypeTableObj getDbKeyHash160TypeTableObj() {
		return( dbKeyHash160TypeTableObj );
	}

	public IBusModelDbKeyHash224ColTableObj getDbKeyHash224ColTableObj() {
		return( dbKeyHash224ColTableObj );
	}

	public IBusModelDbKeyHash224DefTableObj getDbKeyHash224DefTableObj() {
		return( dbKeyHash224DefTableObj );
	}

	public IBusModelDbKeyHash224GenTableObj getDbKeyHash224GenTableObj() {
		return( dbKeyHash224GenTableObj );
	}

	public IBusModelDbKeyHash224TypeTableObj getDbKeyHash224TypeTableObj() {
		return( dbKeyHash224TypeTableObj );
	}

	public IBusModelDbKeyHash256ColTableObj getDbKeyHash256ColTableObj() {
		return( dbKeyHash256ColTableObj );
	}

	public IBusModelDbKeyHash256DefTableObj getDbKeyHash256DefTableObj() {
		return( dbKeyHash256DefTableObj );
	}

	public IBusModelDbKeyHash256GenTableObj getDbKeyHash256GenTableObj() {
		return( dbKeyHash256GenTableObj );
	}

	public IBusModelDbKeyHash256TypeTableObj getDbKeyHash256TypeTableObj() {
		return( dbKeyHash256TypeTableObj );
	}

	public IBusModelDbKeyHash384ColTableObj getDbKeyHash384ColTableObj() {
		return( dbKeyHash384ColTableObj );
	}

	public IBusModelDbKeyHash384DefTableObj getDbKeyHash384DefTableObj() {
		return( dbKeyHash384DefTableObj );
	}

	public IBusModelDbKeyHash384GenTableObj getDbKeyHash384GenTableObj() {
		return( dbKeyHash384GenTableObj );
	}

	public IBusModelDbKeyHash384TypeTableObj getDbKeyHash384TypeTableObj() {
		return( dbKeyHash384TypeTableObj );
	}

	public IBusModelDbKeyHash512ColTableObj getDbKeyHash512ColTableObj() {
		return( dbKeyHash512ColTableObj );
	}

	public IBusModelDbKeyHash512DefTableObj getDbKeyHash512DefTableObj() {
		return( dbKeyHash512DefTableObj );
	}

	public IBusModelDbKeyHash512GenTableObj getDbKeyHash512GenTableObj() {
		return( dbKeyHash512GenTableObj );
	}

	public IBusModelDbKeyHash512TypeTableObj getDbKeyHash512TypeTableObj() {
		return( dbKeyHash512TypeTableObj );
	}

	public IBusModelDelDepTableObj getDelDepTableObj() {
		return( delDepTableObj );
	}

	public IBusModelDelSubDep1TableObj getDelSubDep1TableObj() {
		return( delSubDep1TableObj );
	}

	public IBusModelDelSubDep2TableObj getDelSubDep2TableObj() {
		return( delSubDep2TableObj );
	}

	public IBusModelDelSubDep3TableObj getDelSubDep3TableObj() {
		return( delSubDep3TableObj );
	}

	public IBusModelDelTopDepTableObj getDelTopDepTableObj() {
		return( delTopDepTableObj );
	}

	public IBusModelDoubleColTableObj getDoubleColTableObj() {
		return( doubleColTableObj );
	}

	public IBusModelDoubleDefTableObj getDoubleDefTableObj() {
		return( doubleDefTableObj );
	}

	public IBusModelDoubleTypeTableObj getDoubleTypeTableObj() {
		return( doubleTypeTableObj );
	}

	public IBusModelEnumDefTableObj getEnumDefTableObj() {
		return( enumDefTableObj );
	}

	public IBusModelEnumTagTableObj getEnumTagTableObj() {
		return( enumTagTableObj );
	}

	public IBusModelEnumTypeTableObj getEnumTypeTableObj() {
		return( enumTypeTableObj );
	}

	public IBusModelFloatColTableObj getFloatColTableObj() {
		return( floatColTableObj );
	}

	public IBusModelFloatDefTableObj getFloatDefTableObj() {
		return( floatDefTableObj );
	}

	public IBusModelFloatTypeTableObj getFloatTypeTableObj() {
		return( floatTypeTableObj );
	}

	public IBusModelISOCcyTableObj getISOCcyTableObj() {
		return( iSOCcyTableObj );
	}

	public IBusModelISOCtryTableObj getISOCtryTableObj() {
		return( iSOCtryTableObj );
	}

	public IBusModelISOCtryCcyTableObj getISOCtryCcyTableObj() {
		return( iSOCtryCcyTableObj );
	}

	public IBusModelISOCtryLangTableObj getISOCtryLangTableObj() {
		return( iSOCtryLangTableObj );
	}

	public IBusModelISOLangTableObj getISOLangTableObj() {
		return( iSOLangTableObj );
	}

	public IBusModelISOTZoneTableObj getISOTZoneTableObj() {
		return( iSOTZoneTableObj );
	}

	public IBusModelId16GenTableObj getId16GenTableObj() {
		return( id16GenTableObj );
	}

	public IBusModelId32GenTableObj getId32GenTableObj() {
		return( id32GenTableObj );
	}

	public IBusModelId64GenTableObj getId64GenTableObj() {
		return( id64GenTableObj );
	}

	public IBusModelIndexTableObj getIndexTableObj() {
		return( indexTableObj );
	}

	public IBusModelIndexColTableObj getIndexColTableObj() {
		return( indexColTableObj );
	}

	public IBusModelIndexTweakTableObj getIndexTweakTableObj() {
		return( indexTweakTableObj );
	}

	public IBusModelInt16ColTableObj getInt16ColTableObj() {
		return( int16ColTableObj );
	}

	public IBusModelInt16DefTableObj getInt16DefTableObj() {
		return( int16DefTableObj );
	}

	public IBusModelInt16TypeTableObj getInt16TypeTableObj() {
		return( int16TypeTableObj );
	}

	public IBusModelInt32ColTableObj getInt32ColTableObj() {
		return( int32ColTableObj );
	}

	public IBusModelInt32DefTableObj getInt32DefTableObj() {
		return( int32DefTableObj );
	}

	public IBusModelInt32TypeTableObj getInt32TypeTableObj() {
		return( int32TypeTableObj );
	}

	public IBusModelInt64ColTableObj getInt64ColTableObj() {
		return( int64ColTableObj );
	}

	public IBusModelInt64DefTableObj getInt64DefTableObj() {
		return( int64DefTableObj );
	}

	public IBusModelInt64TypeTableObj getInt64TypeTableObj() {
		return( int64TypeTableObj );
	}

	public IBusModelLicenseTableObj getLicenseTableObj() {
		return( licenseTableObj );
	}

	public IBusModelMajorVersionTableObj getMajorVersionTableObj() {
		return( majorVersionTableObj );
	}

	public IBusModelMimeTypeTableObj getMimeTypeTableObj() {
		return( mimeTypeTableObj );
	}

	public IBusModelMinorVersionTableObj getMinorVersionTableObj() {
		return( minorVersionTableObj );
	}

	public IBusModelNmTokenColTableObj getNmTokenColTableObj() {
		return( nmTokenColTableObj );
	}

	public IBusModelNmTokenDefTableObj getNmTokenDefTableObj() {
		return( nmTokenDefTableObj );
	}

	public IBusModelNmTokenTypeTableObj getNmTokenTypeTableObj() {
		return( nmTokenTypeTableObj );
	}

	public IBusModelNmTokensColTableObj getNmTokensColTableObj() {
		return( nmTokensColTableObj );
	}

	public IBusModelNmTokensDefTableObj getNmTokensDefTableObj() {
		return( nmTokensDefTableObj );
	}

	public IBusModelNmTokensTypeTableObj getNmTokensTypeTableObj() {
		return( nmTokensTypeTableObj );
	}

	public IBusModelNumberColTableObj getNumberColTableObj() {
		return( numberColTableObj );
	}

	public IBusModelNumberDefTableObj getNumberDefTableObj() {
		return( numberDefTableObj );
	}

	public IBusModelNumberTypeTableObj getNumberTypeTableObj() {
		return( numberTypeTableObj );
	}

	public IBusModelParamTableObj getParamTableObj() {
		return( paramTableObj );
	}

	public IBusModelPopDepTableObj getPopDepTableObj() {
		return( popDepTableObj );
	}

	public IBusModelPopSubDep1TableObj getPopSubDep1TableObj() {
		return( popSubDep1TableObj );
	}

	public IBusModelPopSubDep2TableObj getPopSubDep2TableObj() {
		return( popSubDep2TableObj );
	}

	public IBusModelPopSubDep3TableObj getPopSubDep3TableObj() {
		return( popSubDep3TableObj );
	}

	public IBusModelPopTopDepTableObj getPopTopDepTableObj() {
		return( popTopDepTableObj );
	}

	public IBusModelRelationTableObj getRelationTableObj() {
		return( relationTableObj );
	}

	public IBusModelRelationColTableObj getRelationColTableObj() {
		return( relationColTableObj );
	}

	public IBusModelRoleDefTableObj getRoleDefTableObj() {
		return( roleDefTableObj );
	}

	public IBusModelSchemaDefTableObj getSchemaDefTableObj() {
		return( schemaDefTableObj );
	}

	public IBusModelSchemaRefTableObj getSchemaRefTableObj() {
		return( schemaRefTableObj );
	}

	public IBusModelSchemaRoleTableObj getSchemaRoleTableObj() {
		return( schemaRoleTableObj );
	}

	public IBusModelSchemaTweakTableObj getSchemaTweakTableObj() {
		return( schemaTweakTableObj );
	}

	public IBusModelScopeTableObj getScopeTableObj() {
		return( scopeTableObj );
	}

	public IBusModelSecClusGrpTableObj getSecClusGrpTableObj() {
		return( secClusGrpTableObj );
	}

	public IBusModelSecClusGrpMembTableObj getSecClusGrpMembTableObj() {
		return( secClusGrpMembTableObj );
	}

	public IBusModelSecClusRoleTableObj getSecClusRoleTableObj() {
		return( secClusRoleTableObj );
	}

	public IBusModelSecClusRoleMembTableObj getSecClusRoleMembTableObj() {
		return( secClusRoleMembTableObj );
	}

	public IBusModelSecSessionTableObj getSecSessionTableObj() {
		return( secSessionTableObj );
	}

	public IBusModelSecSysGrpTableObj getSecSysGrpTableObj() {
		return( secSysGrpTableObj );
	}

	public IBusModelSecSysGrpIncTableObj getSecSysGrpIncTableObj() {
		return( secSysGrpIncTableObj );
	}

	public IBusModelSecSysGrpMembTableObj getSecSysGrpMembTableObj() {
		return( secSysGrpMembTableObj );
	}

	public IBusModelSecSysRoleTableObj getSecSysRoleTableObj() {
		return( secSysRoleTableObj );
	}

	public IBusModelSecSysRoleEnablesTableObj getSecSysRoleEnablesTableObj() {
		return( secSysRoleEnablesTableObj );
	}

	public IBusModelSecSysRoleMembTableObj getSecSysRoleMembTableObj() {
		return( secSysRoleMembTableObj );
	}

	public IBusModelSecTentGrpTableObj getSecTentGrpTableObj() {
		return( secTentGrpTableObj );
	}

	public IBusModelSecTentGrpMembTableObj getSecTentGrpMembTableObj() {
		return( secTentGrpMembTableObj );
	}

	public IBusModelSecTentRoleTableObj getSecTentRoleTableObj() {
		return( secTentRoleTableObj );
	}

	public IBusModelSecTentRoleMembTableObj getSecTentRoleMembTableObj() {
		return( secTentRoleMembTableObj );
	}

	public IBusModelSecUserTableObj getSecUserTableObj() {
		return( secUserTableObj );
	}

	public IBusModelSecUserEMConfTableObj getSecUserEMConfTableObj() {
		return( secUserEMConfTableObj );
	}

	public IBusModelSecUserPWHistoryTableObj getSecUserPWHistoryTableObj() {
		return( secUserPWHistoryTableObj );
	}

	public IBusModelSecUserPWResetTableObj getSecUserPWResetTableObj() {
		return( secUserPWResetTableObj );
	}

	public IBusModelSecUserPasswordTableObj getSecUserPasswordTableObj() {
		return( secUserPasswordTableObj );
	}

	public IBusModelServerListFuncTableObj getServerListFuncTableObj() {
		return( serverListFuncTableObj );
	}

	public IBusModelServerMethodTableObj getServerMethodTableObj() {
		return( serverMethodTableObj );
	}

	public IBusModelServerObjFuncTableObj getServerObjFuncTableObj() {
		return( serverObjFuncTableObj );
	}

	public IBusModelServerProcTableObj getServerProcTableObj() {
		return( serverProcTableObj );
	}

	public IBusModelStringColTableObj getStringColTableObj() {
		return( stringColTableObj );
	}

	public IBusModelStringDefTableObj getStringDefTableObj() {
		return( stringDefTableObj );
	}

	public IBusModelStringTypeTableObj getStringTypeTableObj() {
		return( stringTypeTableObj );
	}

	public IBusModelSubProjectTableObj getSubProjectTableObj() {
		return( subProjectTableObj );
	}

	public IBusModelSysClusterTableObj getSysClusterTableObj() {
		return( sysClusterTableObj );
	}

	public IBusModelTZDateColTableObj getTZDateColTableObj() {
		return( tZDateColTableObj );
	}

	public IBusModelTZDateDefTableObj getTZDateDefTableObj() {
		return( tZDateDefTableObj );
	}

	public IBusModelTZDateTypeTableObj getTZDateTypeTableObj() {
		return( tZDateTypeTableObj );
	}

	public IBusModelTZTimeColTableObj getTZTimeColTableObj() {
		return( tZTimeColTableObj );
	}

	public IBusModelTZTimeDefTableObj getTZTimeDefTableObj() {
		return( tZTimeDefTableObj );
	}

	public IBusModelTZTimeTypeTableObj getTZTimeTypeTableObj() {
		return( tZTimeTypeTableObj );
	}

	public IBusModelTZTimestampColTableObj getTZTimestampColTableObj() {
		return( tZTimestampColTableObj );
	}

	public IBusModelTZTimestampDefTableObj getTZTimestampDefTableObj() {
		return( tZTimestampDefTableObj );
	}

	public IBusModelTZTimestampTypeTableObj getTZTimestampTypeTableObj() {
		return( tZTimestampTypeTableObj );
	}

	public IBusModelTableTableObj getTableTableObj() {
		return( tableTableObj );
	}

	public IBusModelTableColTableObj getTableColTableObj() {
		return( tableColTableObj );
	}

	public IBusModelTableInfoTableObj getTableInfoTableObj() {
		return( tableInfoTableObj );
	}

	public IBusModelTableTweakTableObj getTableTweakTableObj() {
		return( tableTweakTableObj );
	}

	public IBusModelTenantTableObj getTenantTableObj() {
		return( tenantTableObj );
	}

	public IBusModelTextColTableObj getTextColTableObj() {
		return( textColTableObj );
	}

	public IBusModelTextDefTableObj getTextDefTableObj() {
		return( textDefTableObj );
	}

	public IBusModelTextTypeTableObj getTextTypeTableObj() {
		return( textTypeTableObj );
	}

	public IBusModelTimeColTableObj getTimeColTableObj() {
		return( timeColTableObj );
	}

	public IBusModelTimeDefTableObj getTimeDefTableObj() {
		return( timeDefTableObj );
	}

	public IBusModelTimeTypeTableObj getTimeTypeTableObj() {
		return( timeTypeTableObj );
	}

	public IBusModelTimestampColTableObj getTimestampColTableObj() {
		return( timestampColTableObj );
	}

	public IBusModelTimestampDefTableObj getTimestampDefTableObj() {
		return( timestampDefTableObj );
	}

	public IBusModelTimestampTypeTableObj getTimestampTypeTableObj() {
		return( timestampTypeTableObj );
	}

	public IBusModelTldTableObj getTldTableObj() {
		return( tldTableObj );
	}

	public IBusModelTokenColTableObj getTokenColTableObj() {
		return( tokenColTableObj );
	}

	public IBusModelTokenDefTableObj getTokenDefTableObj() {
		return( tokenDefTableObj );
	}

	public IBusModelTokenTypeTableObj getTokenTypeTableObj() {
		return( tokenTypeTableObj );
	}

	public IBusModelTopDomainTableObj getTopDomainTableObj() {
		return( topDomainTableObj );
	}

	public IBusModelTopProjectTableObj getTopProjectTableObj() {
		return( topProjectTableObj );
	}

	public IBusModelTweakTableObj getTweakTableObj() {
		return( tweakTableObj );
	}

	public IBusModelUInt16ColTableObj getUInt16ColTableObj() {
		return( uInt16ColTableObj );
	}

	public IBusModelUInt16DefTableObj getUInt16DefTableObj() {
		return( uInt16DefTableObj );
	}

	public IBusModelUInt16TypeTableObj getUInt16TypeTableObj() {
		return( uInt16TypeTableObj );
	}

	public IBusModelUInt32ColTableObj getUInt32ColTableObj() {
		return( uInt32ColTableObj );
	}

	public IBusModelUInt32DefTableObj getUInt32DefTableObj() {
		return( uInt32DefTableObj );
	}

	public IBusModelUInt32TypeTableObj getUInt32TypeTableObj() {
		return( uInt32TypeTableObj );
	}

	public IBusModelUInt64ColTableObj getUInt64ColTableObj() {
		return( uInt64ColTableObj );
	}

	public IBusModelUInt64DefTableObj getUInt64DefTableObj() {
		return( uInt64DefTableObj );
	}

	public IBusModelUInt64TypeTableObj getUInt64TypeTableObj() {
		return( uInt64TypeTableObj );
	}

	public IBusModelURLProtocolTableObj getURLProtocolTableObj() {
		return( uRLProtocolTableObj );
	}

	public IBusModelUuid6ColTableObj getUuid6ColTableObj() {
		return( uuid6ColTableObj );
	}

	public IBusModelUuid6DefTableObj getUuid6DefTableObj() {
		return( uuid6DefTableObj );
	}

	public IBusModelUuid6GenTableObj getUuid6GenTableObj() {
		return( uuid6GenTableObj );
	}

	public IBusModelUuid6TypeTableObj getUuid6TypeTableObj() {
		return( uuid6TypeTableObj );
	}

	public IBusModelUuidColTableObj getUuidColTableObj() {
		return( uuidColTableObj );
	}

	public IBusModelUuidDefTableObj getUuidDefTableObj() {
		return( uuidDefTableObj );
	}

	public IBusModelUuidGenTableObj getUuidGenTableObj() {
		return( uuidGenTableObj );
	}

	public IBusModelUuidTypeTableObj getUuidTypeTableObj() {
		return( uuidTypeTableObj );
	}

	public IBusModelValueTableObj getValueTableObj() {
		return( valueTableObj );
	}
}
