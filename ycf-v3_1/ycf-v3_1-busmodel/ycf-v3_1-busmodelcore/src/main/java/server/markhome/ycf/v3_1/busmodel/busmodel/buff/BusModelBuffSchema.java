// Description: Java 25 buffer implementation of a BusModel schema.

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
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.buff.BusModelBuffHooksSchema;

public class BusModelBuffSchema
	implements IBusModelSchema,
		ISecureSchema,
		IIntNetSchema
{
	private static BusModelBuffHooksSchema busmodelBuffHooksSchema = null;


	protected IBusModelAtomTable tableAtom;
	protected IBusModelBlobColTable tableBlobCol;
	protected IBusModelBlobDefTable tableBlobDef;
	protected IBusModelBlobTypeTable tableBlobType;
	protected IBusModelBoolColTable tableBoolCol;
	protected IBusModelBoolDefTable tableBoolDef;
	protected IBusModelBoolTypeTable tableBoolType;
	protected IBusModelChainTable tableChain;
	protected IBusModelClearDepTable tableClearDep;
	protected IBusModelClearSubDep1Table tableClearSubDep1;
	protected IBusModelClearSubDep2Table tableClearSubDep2;
	protected IBusModelClearSubDep3Table tableClearSubDep3;
	protected IBusModelClearTopDepTable tableClearTopDep;
	protected ISecureClusterTable tableCluster;
	protected IBusModelDateColTable tableDateCol;
	protected IBusModelDateDefTable tableDateDef;
	protected IBusModelDateTypeTable tableDateType;
	protected IBusModelDbKeyHash128ColTable tableDbKeyHash128Col;
	protected IBusModelDbKeyHash128DefTable tableDbKeyHash128Def;
	protected IBusModelDbKeyHash128GenTable tableDbKeyHash128Gen;
	protected IBusModelDbKeyHash128TypeTable tableDbKeyHash128Type;
	protected IBusModelDbKeyHash160ColTable tableDbKeyHash160Col;
	protected IBusModelDbKeyHash160DefTable tableDbKeyHash160Def;
	protected IBusModelDbKeyHash160GenTable tableDbKeyHash160Gen;
	protected IBusModelDbKeyHash160TypeTable tableDbKeyHash160Type;
	protected IBusModelDbKeyHash224ColTable tableDbKeyHash224Col;
	protected IBusModelDbKeyHash224DefTable tableDbKeyHash224Def;
	protected IBusModelDbKeyHash224GenTable tableDbKeyHash224Gen;
	protected IBusModelDbKeyHash224TypeTable tableDbKeyHash224Type;
	protected IBusModelDbKeyHash256ColTable tableDbKeyHash256Col;
	protected IBusModelDbKeyHash256DefTable tableDbKeyHash256Def;
	protected IBusModelDbKeyHash256GenTable tableDbKeyHash256Gen;
	protected IBusModelDbKeyHash256TypeTable tableDbKeyHash256Type;
	protected IBusModelDbKeyHash384ColTable tableDbKeyHash384Col;
	protected IBusModelDbKeyHash384DefTable tableDbKeyHash384Def;
	protected IBusModelDbKeyHash384GenTable tableDbKeyHash384Gen;
	protected IBusModelDbKeyHash384TypeTable tableDbKeyHash384Type;
	protected IBusModelDbKeyHash512ColTable tableDbKeyHash512Col;
	protected IBusModelDbKeyHash512DefTable tableDbKeyHash512Def;
	protected IBusModelDbKeyHash512GenTable tableDbKeyHash512Gen;
	protected IBusModelDbKeyHash512TypeTable tableDbKeyHash512Type;
	protected IBusModelDelDepTable tableDelDep;
	protected IBusModelDelSubDep1Table tableDelSubDep1;
	protected IBusModelDelSubDep2Table tableDelSubDep2;
	protected IBusModelDelSubDep3Table tableDelSubDep3;
	protected IBusModelDelTopDepTable tableDelTopDep;
	protected IBusModelDoubleColTable tableDoubleCol;
	protected IBusModelDoubleDefTable tableDoubleDef;
	protected IBusModelDoubleTypeTable tableDoubleType;
	protected IBusModelEnumDefTable tableEnumDef;
	protected IBusModelEnumTagTable tableEnumTag;
	protected IBusModelEnumTypeTable tableEnumType;
	protected IBusModelFloatColTable tableFloatCol;
	protected IBusModelFloatDefTable tableFloatDef;
	protected IBusModelFloatTypeTable tableFloatType;
	protected ISecureISOCcyTable tableISOCcy;
	protected ISecureISOCtryTable tableISOCtry;
	protected ISecureISOCtryCcyTable tableISOCtryCcy;
	protected ISecureISOCtryLangTable tableISOCtryLang;
	protected ISecureISOLangTable tableISOLang;
	protected ISecureISOTZoneTable tableISOTZone;
	protected IBusModelId16GenTable tableId16Gen;
	protected IBusModelId32GenTable tableId32Gen;
	protected IBusModelId64GenTable tableId64Gen;
	protected IBusModelIndexTable tableIndex;
	protected IBusModelIndexColTable tableIndexCol;
	protected IBusModelIndexTweakTable tableIndexTweak;
	protected IBusModelInt16ColTable tableInt16Col;
	protected IBusModelInt16DefTable tableInt16Def;
	protected IBusModelInt16TypeTable tableInt16Type;
	protected IBusModelInt32ColTable tableInt32Col;
	protected IBusModelInt32DefTable tableInt32Def;
	protected IBusModelInt32TypeTable tableInt32Type;
	protected IBusModelInt64ColTable tableInt64Col;
	protected IBusModelInt64DefTable tableInt64Def;
	protected IBusModelInt64TypeTable tableInt64Type;
	protected IIntNetLicenseTable tableLicense;
	protected IIntNetMajorVersionTable tableMajorVersion;
	protected IIntNetMimeTypeTable tableMimeType;
	protected IIntNetMinorVersionTable tableMinorVersion;
	protected IBusModelNmTokenColTable tableNmTokenCol;
	protected IBusModelNmTokenDefTable tableNmTokenDef;
	protected IBusModelNmTokenTypeTable tableNmTokenType;
	protected IBusModelNmTokensColTable tableNmTokensCol;
	protected IBusModelNmTokensDefTable tableNmTokensDef;
	protected IBusModelNmTokensTypeTable tableNmTokensType;
	protected IBusModelNumberColTable tableNumberCol;
	protected IBusModelNumberDefTable tableNumberDef;
	protected IBusModelNumberTypeTable tableNumberType;
	protected IBusModelParamTable tableParam;
	protected IBusModelPopDepTable tablePopDep;
	protected IBusModelPopSubDep1Table tablePopSubDep1;
	protected IBusModelPopSubDep2Table tablePopSubDep2;
	protected IBusModelPopSubDep3Table tablePopSubDep3;
	protected IBusModelPopTopDepTable tablePopTopDep;
	protected IBusModelRelationTable tableRelation;
	protected IBusModelRelationColTable tableRelationCol;
	protected IBusModelRoleDefTable tableRoleDef;
	protected IBusModelSchemaDefTable tableSchemaDef;
	protected IBusModelSchemaRefTable tableSchemaRef;
	protected IBusModelSchemaRoleTable tableSchemaRole;
	protected IBusModelSchemaTweakTable tableSchemaTweak;
	protected IBusModelScopeTable tableScope;
	protected ISecureSecClusGrpTable tableSecClusGrp;
	protected ISecureSecClusGrpMembTable tableSecClusGrpMemb;
	protected ISecureSecClusRoleTable tableSecClusRole;
	protected ISecureSecClusRoleMembTable tableSecClusRoleMemb;
	protected ISecureSecSessionTable tableSecSession;
	protected ISecureSecSysGrpTable tableSecSysGrp;
	protected ISecureSecSysGrpIncTable tableSecSysGrpInc;
	protected ISecureSecSysGrpMembTable tableSecSysGrpMemb;
	protected ISecureSecSysRoleTable tableSecSysRole;
	protected ISecureSecSysRoleEnablesTable tableSecSysRoleEnables;
	protected ISecureSecSysRoleMembTable tableSecSysRoleMemb;
	protected ISecureSecTentGrpTable tableSecTentGrp;
	protected ISecureSecTentGrpMembTable tableSecTentGrpMemb;
	protected ISecureSecTentRoleTable tableSecTentRole;
	protected ISecureSecTentRoleMembTable tableSecTentRoleMemb;
	protected ISecureSecUserTable tableSecUser;
	protected ISecureSecUserEMConfTable tableSecUserEMConf;
	protected ISecureSecUserPWHistoryTable tableSecUserPWHistory;
	protected ISecureSecUserPWResetTable tableSecUserPWReset;
	protected ISecureSecUserPasswordTable tableSecUserPassword;
	protected IBusModelServerListFuncTable tableServerListFunc;
	protected IBusModelServerMethodTable tableServerMethod;
	protected IBusModelServerObjFuncTable tableServerObjFunc;
	protected IBusModelServerProcTable tableServerProc;
	protected IBusModelStringColTable tableStringCol;
	protected IBusModelStringDefTable tableStringDef;
	protected IBusModelStringTypeTable tableStringType;
	protected IIntNetSubProjectTable tableSubProject;
	protected ISecureSysClusterTable tableSysCluster;
	protected IBusModelTZDateColTable tableTZDateCol;
	protected IBusModelTZDateDefTable tableTZDateDef;
	protected IBusModelTZDateTypeTable tableTZDateType;
	protected IBusModelTZTimeColTable tableTZTimeCol;
	protected IBusModelTZTimeDefTable tableTZTimeDef;
	protected IBusModelTZTimeTypeTable tableTZTimeType;
	protected IBusModelTZTimestampColTable tableTZTimestampCol;
	protected IBusModelTZTimestampDefTable tableTZTimestampDef;
	protected IBusModelTZTimestampTypeTable tableTZTimestampType;
	protected IBusModelTableTable tableTable;
	protected IBusModelTableColTable tableTableCol;
	protected ISecureTableInfoTable tableTableInfo;
	protected IBusModelTableTweakTable tableTableTweak;
	protected ISecureTenantTable tableTenant;
	protected IBusModelTextColTable tableTextCol;
	protected IBusModelTextDefTable tableTextDef;
	protected IBusModelTextTypeTable tableTextType;
	protected IBusModelTimeColTable tableTimeCol;
	protected IBusModelTimeDefTable tableTimeDef;
	protected IBusModelTimeTypeTable tableTimeType;
	protected IBusModelTimestampColTable tableTimestampCol;
	protected IBusModelTimestampDefTable tableTimestampDef;
	protected IBusModelTimestampTypeTable tableTimestampType;
	protected IIntNetTldTable tableTld;
	protected IBusModelTokenColTable tableTokenCol;
	protected IBusModelTokenDefTable tableTokenDef;
	protected IBusModelTokenTypeTable tableTokenType;
	protected IIntNetTopDomainTable tableTopDomain;
	protected IIntNetTopProjectTable tableTopProject;
	protected IBusModelTweakTable tableTweak;
	protected IBusModelUInt16ColTable tableUInt16Col;
	protected IBusModelUInt16DefTable tableUInt16Def;
	protected IBusModelUInt16TypeTable tableUInt16Type;
	protected IBusModelUInt32ColTable tableUInt32Col;
	protected IBusModelUInt32DefTable tableUInt32Def;
	protected IBusModelUInt32TypeTable tableUInt32Type;
	protected IBusModelUInt64ColTable tableUInt64Col;
	protected IBusModelUInt64DefTable tableUInt64Def;
	protected IBusModelUInt64TypeTable tableUInt64Type;
	protected IIntNetURLProtocolTable tableURLProtocol;
	protected IBusModelUuid6ColTable tableUuid6Col;
	protected IBusModelUuid6DefTable tableUuid6Def;
	protected IBusModelUuid6GenTable tableUuid6Gen;
	protected IBusModelUuid6TypeTable tableUuid6Type;
	protected IBusModelUuidColTable tableUuidCol;
	protected IBusModelUuidDefTable tableUuidDef;
	protected IBusModelUuidGenTable tableUuidGen;
	protected IBusModelUuidTypeTable tableUuidType;
	protected IBusModelValueTable tableValue;

	@Override
	public int initClassMapEntries(int value) {
		return( IBusModelSchema.doInitClassMapEntries(value) );
	}

	@Override
	public void wireRecConstructors() {
		ISecureSchema.ClassMapEntry entry;
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelScope.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelScope ret = new BusModelBuffScope();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelScope.CLASS_CODE)[" + IBusModelScope.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelSchemaDef ret = new BusModelBuffSchemaDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaDef.CLASS_CODE)[" + IBusModelSchemaDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaRef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelSchemaRef ret = new BusModelBuffSchemaRef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaRef.CLASS_CODE)[" + IBusModelSchemaRef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerMethod.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelServerMethod ret = new BusModelBuffServerMethod();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerMethod.CLASS_CODE)[" + IBusModelServerMethod.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerObjFunc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelServerObjFunc ret = new BusModelBuffServerObjFunc();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerObjFunc.CLASS_CODE)[" + IBusModelServerObjFunc.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerProc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelServerProc ret = new BusModelBuffServerProc();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerProc.CLASS_CODE)[" + IBusModelServerProc.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTable.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTable ret = new BusModelBuffTable();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTable.CLASS_CODE)[" + IBusModelTable.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTweak.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTweak ret = new BusModelBuffTweak();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTweak.CLASS_CODE)[" + IBusModelTweak.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTableTweak.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTableTweak ret = new BusModelBuffTableTweak();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTableTweak.CLASS_CODE)[" + IBusModelTableTweak.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaTweak.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelSchemaTweak ret = new BusModelBuffSchemaTweak();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaTweak.CLASS_CODE)[" + IBusModelSchemaTweak.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndexTweak.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelIndexTweak ret = new BusModelBuffIndexTweak();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndexTweak.CLASS_CODE)[" + IBusModelIndexTweak.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelValue.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelValue ret = new BusModelBuffValue();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelValue.CLASS_CODE)[" + IBusModelValue.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelAtom.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelAtom ret = new BusModelBuffAtom();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelAtom.CLASS_CODE)[" + IBusModelAtom.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBlobDef ret = new BusModelBuffBlobDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobDef.CLASS_CODE)[" + IBusModelBlobDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBlobType ret = new BusModelBuffBlobType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobType.CLASS_CODE)[" + IBusModelBlobType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBoolDef ret = new BusModelBuffBoolDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolDef.CLASS_CODE)[" + IBusModelBoolDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBoolType ret = new BusModelBuffBoolType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolType.CLASS_CODE)[" + IBusModelBoolType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelChain.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelChain ret = new BusModelBuffChain();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelChain.CLASS_CODE)[" + IBusModelChain.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearDep ret = new BusModelBuffClearDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearDep.CLASS_CODE)[" + IBusModelClearDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep1.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearSubDep1 ret = new BusModelBuffClearSubDep1();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep1.CLASS_CODE)[" + IBusModelClearSubDep1.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep2.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearSubDep2 ret = new BusModelBuffClearSubDep2();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep2.CLASS_CODE)[" + IBusModelClearSubDep2.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep3.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearSubDep3 ret = new BusModelBuffClearSubDep3();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep3.CLASS_CODE)[" + IBusModelClearSubDep3.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearTopDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearTopDep ret = new BusModelBuffClearTopDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearTopDep.CLASS_CODE)[" + IBusModelClearTopDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDateDef ret = new BusModelBuffDateDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateDef.CLASS_CODE)[" + IBusModelDateDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDateType ret = new BusModelBuffDateType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateType.CLASS_CODE)[" + IBusModelDateType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelDep ret = new BusModelBuffDelDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelDep.CLASS_CODE)[" + IBusModelDelDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep1.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelSubDep1 ret = new BusModelBuffDelSubDep1();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep1.CLASS_CODE)[" + IBusModelDelSubDep1.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep2.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelSubDep2 ret = new BusModelBuffDelSubDep2();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep2.CLASS_CODE)[" + IBusModelDelSubDep2.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep3.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelSubDep3 ret = new BusModelBuffDelSubDep3();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep3.CLASS_CODE)[" + IBusModelDelSubDep3.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelTopDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelTopDep ret = new BusModelBuffDelTopDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelTopDep.CLASS_CODE)[" + IBusModelDelTopDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDoubleDef ret = new BusModelBuffDoubleDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleDef.CLASS_CODE)[" + IBusModelDoubleDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDoubleType ret = new BusModelBuffDoubleType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleType.CLASS_CODE)[" + IBusModelDoubleType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumTag.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelEnumTag ret = new BusModelBuffEnumTag();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumTag.CLASS_CODE)[" + IBusModelEnumTag.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelFloatDef ret = new BusModelBuffFloatDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatDef.CLASS_CODE)[" + IBusModelFloatDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelFloatType ret = new BusModelBuffFloatType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatType.CLASS_CODE)[" + IBusModelFloatType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndex.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelIndex ret = new BusModelBuffIndex();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndex.CLASS_CODE)[" + IBusModelIndex.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndexCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelIndexCol ret = new BusModelBuffIndexCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndexCol.CLASS_CODE)[" + IBusModelIndexCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt16Def ret = new BusModelBuffInt16Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Def.CLASS_CODE)[" + IBusModelInt16Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt16Type ret = new BusModelBuffInt16Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Type.CLASS_CODE)[" + IBusModelInt16Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt32Def ret = new BusModelBuffInt32Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Def.CLASS_CODE)[" + IBusModelInt32Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt32Type ret = new BusModelBuffInt32Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Type.CLASS_CODE)[" + IBusModelInt32Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt64Def ret = new BusModelBuffInt64Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Def.CLASS_CODE)[" + IBusModelInt64Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt64Type ret = new BusModelBuffInt64Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Type.CLASS_CODE)[" + IBusModelInt64Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokenDef ret = new BusModelBuffNmTokenDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenDef.CLASS_CODE)[" + IBusModelNmTokenDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokenType ret = new BusModelBuffNmTokenType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenType.CLASS_CODE)[" + IBusModelNmTokenType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokensDef ret = new BusModelBuffNmTokensDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensDef.CLASS_CODE)[" + IBusModelNmTokensDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokensType ret = new BusModelBuffNmTokensType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensType.CLASS_CODE)[" + IBusModelNmTokensType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNumberDef ret = new BusModelBuffNumberDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberDef.CLASS_CODE)[" + IBusModelNumberDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNumberType ret = new BusModelBuffNumberType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberType.CLASS_CODE)[" + IBusModelNumberType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelParam.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelParam ret = new BusModelBuffParam();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelParam.CLASS_CODE)[" + IBusModelParam.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopDep ret = new BusModelBuffPopDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopDep.CLASS_CODE)[" + IBusModelPopDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep1.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopSubDep1 ret = new BusModelBuffPopSubDep1();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep1.CLASS_CODE)[" + IBusModelPopSubDep1.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep2.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopSubDep2 ret = new BusModelBuffPopSubDep2();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep2.CLASS_CODE)[" + IBusModelPopSubDep2.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep3.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopSubDep3 ret = new BusModelBuffPopSubDep3();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep3.CLASS_CODE)[" + IBusModelPopSubDep3.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopTopDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopTopDep ret = new BusModelBuffPopTopDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopTopDep.CLASS_CODE)[" + IBusModelPopTopDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelRelation.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelRelation ret = new BusModelBuffRelation();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelRelation.CLASS_CODE)[" + IBusModelRelation.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelRelationCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelRelationCol ret = new BusModelBuffRelationCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelRelationCol.CLASS_CODE)[" + IBusModelRelationCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerListFunc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelServerListFunc ret = new BusModelBuffServerListFunc();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerListFunc.CLASS_CODE)[" + IBusModelServerListFunc.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash128Def ret = new BusModelBuffDbKeyHash128Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Def.CLASS_CODE)[" + IBusModelDbKeyHash128Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash128Col ret = new BusModelBuffDbKeyHash128Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Col.CLASS_CODE)[" + IBusModelDbKeyHash128Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash128Type ret = new BusModelBuffDbKeyHash128Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Type.CLASS_CODE)[" + IBusModelDbKeyHash128Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash128Gen ret = new BusModelBuffDbKeyHash128Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Gen.CLASS_CODE)[" + IBusModelDbKeyHash128Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash160Def ret = new BusModelBuffDbKeyHash160Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Def.CLASS_CODE)[" + IBusModelDbKeyHash160Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash160Col ret = new BusModelBuffDbKeyHash160Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Col.CLASS_CODE)[" + IBusModelDbKeyHash160Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash160Type ret = new BusModelBuffDbKeyHash160Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Type.CLASS_CODE)[" + IBusModelDbKeyHash160Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash160Gen ret = new BusModelBuffDbKeyHash160Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Gen.CLASS_CODE)[" + IBusModelDbKeyHash160Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash224Def ret = new BusModelBuffDbKeyHash224Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Def.CLASS_CODE)[" + IBusModelDbKeyHash224Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash224Col ret = new BusModelBuffDbKeyHash224Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Col.CLASS_CODE)[" + IBusModelDbKeyHash224Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash224Type ret = new BusModelBuffDbKeyHash224Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Type.CLASS_CODE)[" + IBusModelDbKeyHash224Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash224Gen ret = new BusModelBuffDbKeyHash224Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Gen.CLASS_CODE)[" + IBusModelDbKeyHash224Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash256Def ret = new BusModelBuffDbKeyHash256Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Def.CLASS_CODE)[" + IBusModelDbKeyHash256Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash256Col ret = new BusModelBuffDbKeyHash256Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Col.CLASS_CODE)[" + IBusModelDbKeyHash256Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash256Type ret = new BusModelBuffDbKeyHash256Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Type.CLASS_CODE)[" + IBusModelDbKeyHash256Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash256Gen ret = new BusModelBuffDbKeyHash256Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Gen.CLASS_CODE)[" + IBusModelDbKeyHash256Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash384Def ret = new BusModelBuffDbKeyHash384Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Def.CLASS_CODE)[" + IBusModelDbKeyHash384Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash384Col ret = new BusModelBuffDbKeyHash384Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Col.CLASS_CODE)[" + IBusModelDbKeyHash384Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash384Type ret = new BusModelBuffDbKeyHash384Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Type.CLASS_CODE)[" + IBusModelDbKeyHash384Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash384Gen ret = new BusModelBuffDbKeyHash384Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Gen.CLASS_CODE)[" + IBusModelDbKeyHash384Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash512Def ret = new BusModelBuffDbKeyHash512Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Def.CLASS_CODE)[" + IBusModelDbKeyHash512Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash512Col ret = new BusModelBuffDbKeyHash512Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Col.CLASS_CODE)[" + IBusModelDbKeyHash512Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash512Type ret = new BusModelBuffDbKeyHash512Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Type.CLASS_CODE)[" + IBusModelDbKeyHash512Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash512Gen ret = new BusModelBuffDbKeyHash512Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Gen.CLASS_CODE)[" + IBusModelDbKeyHash512Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelStringDef ret = new BusModelBuffStringDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringDef.CLASS_CODE)[" + IBusModelStringDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelStringType ret = new BusModelBuffStringType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringType.CLASS_CODE)[" + IBusModelStringType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZDateDef ret = new BusModelBuffTZDateDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateDef.CLASS_CODE)[" + IBusModelTZDateDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZDateType ret = new BusModelBuffTZDateType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateType.CLASS_CODE)[" + IBusModelTZDateType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimeDef ret = new BusModelBuffTZTimeDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeDef.CLASS_CODE)[" + IBusModelTZTimeDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimeType ret = new BusModelBuffTZTimeType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeType.CLASS_CODE)[" + IBusModelTZTimeType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimestampDef ret = new BusModelBuffTZTimestampDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampDef.CLASS_CODE)[" + IBusModelTZTimestampDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimestampType ret = new BusModelBuffTZTimestampType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampType.CLASS_CODE)[" + IBusModelTZTimestampType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTableCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTableCol ret = new BusModelBuffTableCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTableCol.CLASS_CODE)[" + IBusModelTableCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTextDef ret = new BusModelBuffTextDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextDef.CLASS_CODE)[" + IBusModelTextDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTextType ret = new BusModelBuffTextType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextType.CLASS_CODE)[" + IBusModelTextType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimeDef ret = new BusModelBuffTimeDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeDef.CLASS_CODE)[" + IBusModelTimeDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimeType ret = new BusModelBuffTimeType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeType.CLASS_CODE)[" + IBusModelTimeType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimestampDef ret = new BusModelBuffTimestampDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampDef.CLASS_CODE)[" + IBusModelTimestampDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimestampType ret = new BusModelBuffTimestampType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampType.CLASS_CODE)[" + IBusModelTimestampType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTokenDef ret = new BusModelBuffTokenDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenDef.CLASS_CODE)[" + IBusModelTokenDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTokenType ret = new BusModelBuffTokenType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenType.CLASS_CODE)[" + IBusModelTokenType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt16Def ret = new BusModelBuffUInt16Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Def.CLASS_CODE)[" + IBusModelUInt16Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt16Type ret = new BusModelBuffUInt16Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Type.CLASS_CODE)[" + IBusModelUInt16Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt32Def ret = new BusModelBuffUInt32Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Def.CLASS_CODE)[" + IBusModelUInt32Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt32Type ret = new BusModelBuffUInt32Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Type.CLASS_CODE)[" + IBusModelUInt32Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt64Def ret = new BusModelBuffUInt64Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Def.CLASS_CODE)[" + IBusModelUInt64Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt64Type ret = new BusModelBuffUInt64Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Type.CLASS_CODE)[" + IBusModelUInt64Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuidDef ret = new BusModelBuffUuidDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidDef.CLASS_CODE)[" + IBusModelUuidDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuid6Def ret = new BusModelBuffUuid6Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Def.CLASS_CODE)[" + IBusModelUuid6Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuidType ret = new BusModelBuffUuidType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidType.CLASS_CODE)[" + IBusModelUuidType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuid6Type ret = new BusModelBuffUuid6Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Type.CLASS_CODE)[" + IBusModelUuid6Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBlobCol ret = new BusModelBuffBlobCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobCol.CLASS_CODE)[" + IBusModelBlobCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBoolCol ret = new BusModelBuffBoolCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolCol.CLASS_CODE)[" + IBusModelBoolCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDateCol ret = new BusModelBuffDateCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateCol.CLASS_CODE)[" + IBusModelDateCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDoubleCol ret = new BusModelBuffDoubleCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleCol.CLASS_CODE)[" + IBusModelDoubleCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelEnumDef ret = new BusModelBuffEnumDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumDef.CLASS_CODE)[" + IBusModelEnumDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelEnumType ret = new BusModelBuffEnumType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumType.CLASS_CODE)[" + IBusModelEnumType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelFloatCol ret = new BusModelBuffFloatCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatCol.CLASS_CODE)[" + IBusModelFloatCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelId16Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelId16Gen ret = new BusModelBuffId16Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelId16Gen.CLASS_CODE)[" + IBusModelId16Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelId32Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelId32Gen ret = new BusModelBuffId32Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelId32Gen.CLASS_CODE)[" + IBusModelId32Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelId64Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelId64Gen ret = new BusModelBuffId64Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelId64Gen.CLASS_CODE)[" + IBusModelId64Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt16Col ret = new BusModelBuffInt16Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Col.CLASS_CODE)[" + IBusModelInt16Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt32Col ret = new BusModelBuffInt32Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Col.CLASS_CODE)[" + IBusModelInt32Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt64Col ret = new BusModelBuffInt64Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Col.CLASS_CODE)[" + IBusModelInt64Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokenCol ret = new BusModelBuffNmTokenCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenCol.CLASS_CODE)[" + IBusModelNmTokenCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokensCol ret = new BusModelBuffNmTokensCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensCol.CLASS_CODE)[" + IBusModelNmTokensCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNumberCol ret = new BusModelBuffNumberCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberCol.CLASS_CODE)[" + IBusModelNumberCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelStringCol ret = new BusModelBuffStringCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringCol.CLASS_CODE)[" + IBusModelStringCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZDateCol ret = new BusModelBuffTZDateCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateCol.CLASS_CODE)[" + IBusModelTZDateCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimeCol ret = new BusModelBuffTZTimeCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeCol.CLASS_CODE)[" + IBusModelTZTimeCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimestampCol ret = new BusModelBuffTZTimestampCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampCol.CLASS_CODE)[" + IBusModelTZTimestampCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTextCol ret = new BusModelBuffTextCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextCol.CLASS_CODE)[" + IBusModelTextCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimeCol ret = new BusModelBuffTimeCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeCol.CLASS_CODE)[" + IBusModelTimeCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimestampCol ret = new BusModelBuffTimestampCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampCol.CLASS_CODE)[" + IBusModelTimestampCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTokenCol ret = new BusModelBuffTokenCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenCol.CLASS_CODE)[" + IBusModelTokenCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt16Col ret = new BusModelBuffUInt16Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Col.CLASS_CODE)[" + IBusModelUInt16Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt32Col ret = new BusModelBuffUInt32Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Col.CLASS_CODE)[" + IBusModelUInt32Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt64Col ret = new BusModelBuffUInt64Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Col.CLASS_CODE)[" + IBusModelUInt64Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuidCol ret = new BusModelBuffUuidCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidCol.CLASS_CODE)[" + IBusModelUuidCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuid6Col ret = new BusModelBuffUuid6Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Col.CLASS_CODE)[" + IBusModelUuid6Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidGen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuidGen ret = new BusModelBuffUuidGen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidGen.CLASS_CODE)[" + IBusModelUuidGen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuid6Gen ret = new BusModelBuffUuid6Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Gen.CLASS_CODE)[" + IBusModelUuid6Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelRoleDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelRoleDef ret = new BusModelBuffRoleDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelRoleDef.CLASS_CODE)[" + IBusModelRoleDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelSchemaRole ret = new BusModelBuffSchemaRole();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelBuffSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaRole.CLASS_CODE)[" + IBusModelSchemaRole.CLASS_CODE + "]");
		}
	
	}

	@Override
	public void wireTableTableInstances() {
		throw new YCFMustOverrideException(getClass(), "wireTableTableInstances");
	}

	@Override		
	public ISecureSchema getSecureSchema() {
		return( ISecureSchema.getBackingSecure() );
	}

	@Override
	public void setSecureSchema(ISecureSchema schema) {
		ISecureSchema.setBackingSecure(schema);
		schema.wireRecConstructors();
	}

	@Override		
	public IIntNetSchema getIntNetSchema() {
		return( IIntNetSchema.getBackingIntNet() );
	}

	@Override
	public void setIntNetSchema(IIntNetSchema schema) {
		IIntNetSchema.setBackingIntNet(schema);
		schema.wireRecConstructors();
	}

	@Override		
	public IBusModelSchema getBusModelSchema() {
		return( IBusModelSchema.getBackingBusModel() );
	}

	@Override
	public void setBusModelSchema(IBusModelSchema schema) {
		IBusModelSchema.setBackingBusModel(schema);
		schema.wireRecConstructors();
	}

	public static BusModelBuffHooksSchema getBuffHooksSchema() {
		return( busmodelBuffHooksSchema );
	}

	public static void setBuffHooksSchema(BusModelBuffHooksSchema buffHooksSchema) {
		busmodelBuffHooksSchema = buffHooksSchema;
	}

	@Override
	public ISecureFactory getSecureFactory() {
		ISecureSchema sch = ISecureSchema.getBackingSecure();
		if (sch == null) {
			return null;
		}
		else {
			return(sch.getSecureFactory());
		}
	}
	
	@Override
	public SecureBuffFactoryService getSecureBuffFactory() {
		ISecureSchema sch = ISecureSchema.getBackingSecure();
		if (sch == null) {
			return null;
		}
		else {
			return((SecureBuffFactoryService)(sch.getSecureBuffFactory()));
		}
	}

	@Override
	public IIntNetFactory getIntNetFactory() {
		IIntNetSchema sch = IIntNetSchema.getBackingIntNet();
		if (sch == null) {
			return null;
		}
		else {
			return(sch.getIntNetFactory());
		}
	}
	
	@Override
	public IntNetBuffFactoryService getIntNetBuffFactory() {
		IIntNetSchema sch = IIntNetSchema.getBackingIntNet();
		if (sch == null) {
			return null;
		}
		else {
			return((IntNetBuffFactoryService)(sch.getIntNetBuffFactory()));
		}
	}

	@Override
	public IBusModelFactory getBusModelFactory() {
		return(BusModelBuffSchema.getBuffHooksSchema().getFactoryService());
	}

	@Override
	public BusModelBuffFactoryService getBusModelBuffFactory() {
		return((BusModelBuffFactoryService)(BusModelBuffSchema.getBuffHooksSchema().getFactoryService()));
	}

	public BusModelBuffSchema() {

	tableAtom = null; // new BusModelBuffAtomTable();
	tableBlobCol = null; // new BusModelBuffBlobColTable();
	tableBlobDef = null; // new BusModelBuffBlobDefTable();
	tableBlobType = null; // new BusModelBuffBlobTypeTable();
	tableBoolCol = null; // new BusModelBuffBoolColTable();
	tableBoolDef = null; // new BusModelBuffBoolDefTable();
	tableBoolType = null; // new BusModelBuffBoolTypeTable();
	tableChain = null; // new BusModelBuffChainTable();
	tableClearDep = null; // new BusModelBuffClearDepTable();
	tableClearSubDep1 = null; // new BusModelBuffClearSubDep1Table();
	tableClearSubDep2 = null; // new BusModelBuffClearSubDep2Table();
	tableClearSubDep3 = null; // new BusModelBuffClearSubDep3Table();
	tableClearTopDep = null; // new BusModelBuffClearTopDepTable();
	tableDateCol = null; // new BusModelBuffDateColTable();
	tableDateDef = null; // new BusModelBuffDateDefTable();
	tableDateType = null; // new BusModelBuffDateTypeTable();
	tableDbKeyHash128Col = null; // new BusModelBuffDbKeyHash128ColTable();
	tableDbKeyHash128Def = null; // new BusModelBuffDbKeyHash128DefTable();
	tableDbKeyHash128Gen = null; // new BusModelBuffDbKeyHash128GenTable();
	tableDbKeyHash128Type = null; // new BusModelBuffDbKeyHash128TypeTable();
	tableDbKeyHash160Col = null; // new BusModelBuffDbKeyHash160ColTable();
	tableDbKeyHash160Def = null; // new BusModelBuffDbKeyHash160DefTable();
	tableDbKeyHash160Gen = null; // new BusModelBuffDbKeyHash160GenTable();
	tableDbKeyHash160Type = null; // new BusModelBuffDbKeyHash160TypeTable();
	tableDbKeyHash224Col = null; // new BusModelBuffDbKeyHash224ColTable();
	tableDbKeyHash224Def = null; // new BusModelBuffDbKeyHash224DefTable();
	tableDbKeyHash224Gen = null; // new BusModelBuffDbKeyHash224GenTable();
	tableDbKeyHash224Type = null; // new BusModelBuffDbKeyHash224TypeTable();
	tableDbKeyHash256Col = null; // new BusModelBuffDbKeyHash256ColTable();
	tableDbKeyHash256Def = null; // new BusModelBuffDbKeyHash256DefTable();
	tableDbKeyHash256Gen = null; // new BusModelBuffDbKeyHash256GenTable();
	tableDbKeyHash256Type = null; // new BusModelBuffDbKeyHash256TypeTable();
	tableDbKeyHash384Col = null; // new BusModelBuffDbKeyHash384ColTable();
	tableDbKeyHash384Def = null; // new BusModelBuffDbKeyHash384DefTable();
	tableDbKeyHash384Gen = null; // new BusModelBuffDbKeyHash384GenTable();
	tableDbKeyHash384Type = null; // new BusModelBuffDbKeyHash384TypeTable();
	tableDbKeyHash512Col = null; // new BusModelBuffDbKeyHash512ColTable();
	tableDbKeyHash512Def = null; // new BusModelBuffDbKeyHash512DefTable();
	tableDbKeyHash512Gen = null; // new BusModelBuffDbKeyHash512GenTable();
	tableDbKeyHash512Type = null; // new BusModelBuffDbKeyHash512TypeTable();
	tableDelDep = null; // new BusModelBuffDelDepTable();
	tableDelSubDep1 = null; // new BusModelBuffDelSubDep1Table();
	tableDelSubDep2 = null; // new BusModelBuffDelSubDep2Table();
	tableDelSubDep3 = null; // new BusModelBuffDelSubDep3Table();
	tableDelTopDep = null; // new BusModelBuffDelTopDepTable();
	tableDoubleCol = null; // new BusModelBuffDoubleColTable();
	tableDoubleDef = null; // new BusModelBuffDoubleDefTable();
	tableDoubleType = null; // new BusModelBuffDoubleTypeTable();
	tableEnumDef = null; // new BusModelBuffEnumDefTable();
	tableEnumTag = null; // new BusModelBuffEnumTagTable();
	tableEnumType = null; // new BusModelBuffEnumTypeTable();
	tableFloatCol = null; // new BusModelBuffFloatColTable();
	tableFloatDef = null; // new BusModelBuffFloatDefTable();
	tableFloatType = null; // new BusModelBuffFloatTypeTable();
	tableId16Gen = null; // new BusModelBuffId16GenTable();
	tableId32Gen = null; // new BusModelBuffId32GenTable();
	tableId64Gen = null; // new BusModelBuffId64GenTable();
	tableIndex = null; // new BusModelBuffIndexTable();
	tableIndexCol = null; // new BusModelBuffIndexColTable();
	tableIndexTweak = null; // new BusModelBuffIndexTweakTable();
	tableInt16Col = null; // new BusModelBuffInt16ColTable();
	tableInt16Def = null; // new BusModelBuffInt16DefTable();
	tableInt16Type = null; // new BusModelBuffInt16TypeTable();
	tableInt32Col = null; // new BusModelBuffInt32ColTable();
	tableInt32Def = null; // new BusModelBuffInt32DefTable();
	tableInt32Type = null; // new BusModelBuffInt32TypeTable();
	tableInt64Col = null; // new BusModelBuffInt64ColTable();
	tableInt64Def = null; // new BusModelBuffInt64DefTable();
	tableInt64Type = null; // new BusModelBuffInt64TypeTable();
	tableNmTokenCol = null; // new BusModelBuffNmTokenColTable();
	tableNmTokenDef = null; // new BusModelBuffNmTokenDefTable();
	tableNmTokenType = null; // new BusModelBuffNmTokenTypeTable();
	tableNmTokensCol = null; // new BusModelBuffNmTokensColTable();
	tableNmTokensDef = null; // new BusModelBuffNmTokensDefTable();
	tableNmTokensType = null; // new BusModelBuffNmTokensTypeTable();
	tableNumberCol = null; // new BusModelBuffNumberColTable();
	tableNumberDef = null; // new BusModelBuffNumberDefTable();
	tableNumberType = null; // new BusModelBuffNumberTypeTable();
	tableParam = null; // new BusModelBuffParamTable();
	tablePopDep = null; // new BusModelBuffPopDepTable();
	tablePopSubDep1 = null; // new BusModelBuffPopSubDep1Table();
	tablePopSubDep2 = null; // new BusModelBuffPopSubDep2Table();
	tablePopSubDep3 = null; // new BusModelBuffPopSubDep3Table();
	tablePopTopDep = null; // new BusModelBuffPopTopDepTable();
	tableRelation = null; // new BusModelBuffRelationTable();
	tableRelationCol = null; // new BusModelBuffRelationColTable();
	tableRoleDef = null; // new BusModelBuffRoleDefTable();
	tableSchemaDef = null; // new BusModelBuffSchemaDefTable();
	tableSchemaRef = null; // new BusModelBuffSchemaRefTable();
	tableSchemaRole = null; // new BusModelBuffSchemaRoleTable();
	tableSchemaTweak = null; // new BusModelBuffSchemaTweakTable();
	tableScope = null; // new BusModelBuffScopeTable();
	tableServerListFunc = null; // new BusModelBuffServerListFuncTable();
	tableServerMethod = null; // new BusModelBuffServerMethodTable();
	tableServerObjFunc = null; // new BusModelBuffServerObjFuncTable();
	tableServerProc = null; // new BusModelBuffServerProcTable();
	tableStringCol = null; // new BusModelBuffStringColTable();
	tableStringDef = null; // new BusModelBuffStringDefTable();
	tableStringType = null; // new BusModelBuffStringTypeTable();
	tableTZDateCol = null; // new BusModelBuffTZDateColTable();
	tableTZDateDef = null; // new BusModelBuffTZDateDefTable();
	tableTZDateType = null; // new BusModelBuffTZDateTypeTable();
	tableTZTimeCol = null; // new BusModelBuffTZTimeColTable();
	tableTZTimeDef = null; // new BusModelBuffTZTimeDefTable();
	tableTZTimeType = null; // new BusModelBuffTZTimeTypeTable();
	tableTZTimestampCol = null; // new BusModelBuffTZTimestampColTable();
	tableTZTimestampDef = null; // new BusModelBuffTZTimestampDefTable();
	tableTZTimestampType = null; // new BusModelBuffTZTimestampTypeTable();
	tableTable = null; // new BusModelBuffTableTable();
	tableTableCol = null; // new BusModelBuffTableColTable();
	tableTableTweak = null; // new BusModelBuffTableTweakTable();
	tableTextCol = null; // new BusModelBuffTextColTable();
	tableTextDef = null; // new BusModelBuffTextDefTable();
	tableTextType = null; // new BusModelBuffTextTypeTable();
	tableTimeCol = null; // new BusModelBuffTimeColTable();
	tableTimeDef = null; // new BusModelBuffTimeDefTable();
	tableTimeType = null; // new BusModelBuffTimeTypeTable();
	tableTimestampCol = null; // new BusModelBuffTimestampColTable();
	tableTimestampDef = null; // new BusModelBuffTimestampDefTable();
	tableTimestampType = null; // new BusModelBuffTimestampTypeTable();
	tableTokenCol = null; // new BusModelBuffTokenColTable();
	tableTokenDef = null; // new BusModelBuffTokenDefTable();
	tableTokenType = null; // new BusModelBuffTokenTypeTable();
	tableTweak = null; // new BusModelBuffTweakTable();
	tableUInt16Col = null; // new BusModelBuffUInt16ColTable();
	tableUInt16Def = null; // new BusModelBuffUInt16DefTable();
	tableUInt16Type = null; // new BusModelBuffUInt16TypeTable();
	tableUInt32Col = null; // new BusModelBuffUInt32ColTable();
	tableUInt32Def = null; // new BusModelBuffUInt32DefTable();
	tableUInt32Type = null; // new BusModelBuffUInt32TypeTable();
	tableUInt64Col = null; // new BusModelBuffUInt64ColTable();
	tableUInt64Def = null; // new BusModelBuffUInt64DefTable();
	tableUInt64Type = null; // new BusModelBuffUInt64TypeTable();
	tableUuid6Col = null; // new BusModelBuffUuid6ColTable();
	tableUuid6Def = null; // new BusModelBuffUuid6DefTable();
	tableUuid6Gen = null; // new BusModelBuffUuid6GenTable();
	tableUuid6Type = null; // new BusModelBuffUuid6TypeTable();
	tableUuidCol = null; // new BusModelBuffUuidColTable();
	tableUuidDef = null; // new BusModelBuffUuidDefTable();
	tableUuidGen = null; // new BusModelBuffUuidGenTable();
	tableUuidType = null; // new BusModelBuffUuidTypeTable();
	tableValue = null; // new BusModelBuffValueTable();
	}

	public IBusModelSchema newSchema() {
		throw new YCFMustOverrideException( getClass(), "newSchema" );
	}

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOCcyIdGen");
	}

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOCtryIdGen");
	}

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOLangIdGen");
	}

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextISOTZoneIdGen");
	}

	/**
	 *	Get the next TableInfoIdGen identifier.
	 *
	 *	@return	The next TableInfoIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextTableInfoIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextTableInfoIdGen");
	}

	/**
	 *	Get the next MimeTypeIdGen identifier.
	 *
	 *	@return	The next MimeTypeIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextMimeTypeIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextMimeTypeIdGen");
	}

	/**
	 *	Get the next URLProtocolIdGen identifier.
	 *
	 *	@return	The next URLProtocolIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextURLProtocolIdGen() {
		throw new YCFMustOverrideException(getClass(), "nextURLProtocolIdGen");
	}

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextClusterIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSessionIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecUserIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTenantIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSysGrpIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusGrpIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecClusRoleIdGen identifier.
	 *
	 *	@return	The next SecClusRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusRoleIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentGrpIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecTentRoleIdGen identifier.
	 *
	 *	@return	The next SecTentRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentRoleIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next MajorVersionIdGen identifier.
	 *
	 *	@return	The next MajorVersionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextMajorVersionIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next MinorVersionIdGen identifier.
	 *
	 *	@return	The next MinorVersionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextMinorVersionIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next SubProjectIdGen identifier.
	 *
	 *	@return	The next SubProjectIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSubProjectIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TldIdGen identifier.
	 *
	 *	@return	The next TldIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTldIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TopDomainIdGen identifier.
	 *
	 *	@return	The next TopDomainIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTopDomainIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TopProjectIdGen identifier.
	 *
	 *	@return	The next TopProjectIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTopProjectIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next LicenseIdGen identifier.
	 *
	 *	@return	The next LicenseIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextLicenseIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next ChainIdGen identifier.
	 *
	 *	@return	The next ChainIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextChainIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next EnumTagIdGen identifier.
	 *
	 *	@return	The next EnumTagIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextEnumTagIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next IndexColIdGen identifier.
	 *
	 *	@return	The next IndexColIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextIndexColIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next ParamIdGen identifier.
	 *
	 *	@return	The next ParamIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextParamIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next RelationColIdGen identifier.
	 *
	 *	@return	The next RelationColIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextRelationColIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next TweakIdGen identifier.
	 *
	 *	@return	The next TweakIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTweakIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next ScopeIdGen identifier.
	 *
	 *	@return	The next ScopeIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextScopeIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next ValueIdGen identifier.
	 *
	 *	@return	The next ValueIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextValueIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	/**
	 *	Get the next RoleIdGen identifier.
	 *
	 *	@return	The next RoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextRoleIdGen() {
		return( new YCFDbKeyHash256(0) );
	}

	public IBusModelAtomTable getTableAtom() {
		return( tableAtom );
	}

	public void setTableAtom( IBusModelAtomTable value ) {
		tableAtom = value;
	}

	public IBusModelBlobColTable getTableBlobCol() {
		return( tableBlobCol );
	}

	public void setTableBlobCol( IBusModelBlobColTable value ) {
		tableBlobCol = value;
	}

	public IBusModelBlobDefTable getTableBlobDef() {
		return( tableBlobDef );
	}

	public void setTableBlobDef( IBusModelBlobDefTable value ) {
		tableBlobDef = value;
	}

	public IBusModelBlobTypeTable getTableBlobType() {
		return( tableBlobType );
	}

	public void setTableBlobType( IBusModelBlobTypeTable value ) {
		tableBlobType = value;
	}

	public IBusModelBoolColTable getTableBoolCol() {
		return( tableBoolCol );
	}

	public void setTableBoolCol( IBusModelBoolColTable value ) {
		tableBoolCol = value;
	}

	public IBusModelBoolDefTable getTableBoolDef() {
		return( tableBoolDef );
	}

	public void setTableBoolDef( IBusModelBoolDefTable value ) {
		tableBoolDef = value;
	}

	public IBusModelBoolTypeTable getTableBoolType() {
		return( tableBoolType );
	}

	public void setTableBoolType( IBusModelBoolTypeTable value ) {
		tableBoolType = value;
	}

	public IBusModelChainTable getTableChain() {
		return( tableChain );
	}

	public void setTableChain( IBusModelChainTable value ) {
		tableChain = value;
	}

	public IBusModelClearDepTable getTableClearDep() {
		return( tableClearDep );
	}

	public void setTableClearDep( IBusModelClearDepTable value ) {
		tableClearDep = value;
	}

	public IBusModelClearSubDep1Table getTableClearSubDep1() {
		return( tableClearSubDep1 );
	}

	public void setTableClearSubDep1( IBusModelClearSubDep1Table value ) {
		tableClearSubDep1 = value;
	}

	public IBusModelClearSubDep2Table getTableClearSubDep2() {
		return( tableClearSubDep2 );
	}

	public void setTableClearSubDep2( IBusModelClearSubDep2Table value ) {
		tableClearSubDep2 = value;
	}

	public IBusModelClearSubDep3Table getTableClearSubDep3() {
		return( tableClearSubDep3 );
	}

	public void setTableClearSubDep3( IBusModelClearSubDep3Table value ) {
		tableClearSubDep3 = value;
	}

	public IBusModelClearTopDepTable getTableClearTopDep() {
		return( tableClearTopDep );
	}

	public void setTableClearTopDep( IBusModelClearTopDepTable value ) {
		tableClearTopDep = value;
	}

	public ISecureClusterTable getTableCluster() {
		return( tableCluster );
	}

	public void setTableCluster( ISecureClusterTable value ) {
		tableCluster = value;
	}

	public IBusModelDateColTable getTableDateCol() {
		return( tableDateCol );
	}

	public void setTableDateCol( IBusModelDateColTable value ) {
		tableDateCol = value;
	}

	public IBusModelDateDefTable getTableDateDef() {
		return( tableDateDef );
	}

	public void setTableDateDef( IBusModelDateDefTable value ) {
		tableDateDef = value;
	}

	public IBusModelDateTypeTable getTableDateType() {
		return( tableDateType );
	}

	public void setTableDateType( IBusModelDateTypeTable value ) {
		tableDateType = value;
	}

	public IBusModelDbKeyHash128ColTable getTableDbKeyHash128Col() {
		return( tableDbKeyHash128Col );
	}

	public void setTableDbKeyHash128Col( IBusModelDbKeyHash128ColTable value ) {
		tableDbKeyHash128Col = value;
	}

	public IBusModelDbKeyHash128DefTable getTableDbKeyHash128Def() {
		return( tableDbKeyHash128Def );
	}

	public void setTableDbKeyHash128Def( IBusModelDbKeyHash128DefTable value ) {
		tableDbKeyHash128Def = value;
	}

	public IBusModelDbKeyHash128GenTable getTableDbKeyHash128Gen() {
		return( tableDbKeyHash128Gen );
	}

	public void setTableDbKeyHash128Gen( IBusModelDbKeyHash128GenTable value ) {
		tableDbKeyHash128Gen = value;
	}

	public IBusModelDbKeyHash128TypeTable getTableDbKeyHash128Type() {
		return( tableDbKeyHash128Type );
	}

	public void setTableDbKeyHash128Type( IBusModelDbKeyHash128TypeTable value ) {
		tableDbKeyHash128Type = value;
	}

	public IBusModelDbKeyHash160ColTable getTableDbKeyHash160Col() {
		return( tableDbKeyHash160Col );
	}

	public void setTableDbKeyHash160Col( IBusModelDbKeyHash160ColTable value ) {
		tableDbKeyHash160Col = value;
	}

	public IBusModelDbKeyHash160DefTable getTableDbKeyHash160Def() {
		return( tableDbKeyHash160Def );
	}

	public void setTableDbKeyHash160Def( IBusModelDbKeyHash160DefTable value ) {
		tableDbKeyHash160Def = value;
	}

	public IBusModelDbKeyHash160GenTable getTableDbKeyHash160Gen() {
		return( tableDbKeyHash160Gen );
	}

	public void setTableDbKeyHash160Gen( IBusModelDbKeyHash160GenTable value ) {
		tableDbKeyHash160Gen = value;
	}

	public IBusModelDbKeyHash160TypeTable getTableDbKeyHash160Type() {
		return( tableDbKeyHash160Type );
	}

	public void setTableDbKeyHash160Type( IBusModelDbKeyHash160TypeTable value ) {
		tableDbKeyHash160Type = value;
	}

	public IBusModelDbKeyHash224ColTable getTableDbKeyHash224Col() {
		return( tableDbKeyHash224Col );
	}

	public void setTableDbKeyHash224Col( IBusModelDbKeyHash224ColTable value ) {
		tableDbKeyHash224Col = value;
	}

	public IBusModelDbKeyHash224DefTable getTableDbKeyHash224Def() {
		return( tableDbKeyHash224Def );
	}

	public void setTableDbKeyHash224Def( IBusModelDbKeyHash224DefTable value ) {
		tableDbKeyHash224Def = value;
	}

	public IBusModelDbKeyHash224GenTable getTableDbKeyHash224Gen() {
		return( tableDbKeyHash224Gen );
	}

	public void setTableDbKeyHash224Gen( IBusModelDbKeyHash224GenTable value ) {
		tableDbKeyHash224Gen = value;
	}

	public IBusModelDbKeyHash224TypeTable getTableDbKeyHash224Type() {
		return( tableDbKeyHash224Type );
	}

	public void setTableDbKeyHash224Type( IBusModelDbKeyHash224TypeTable value ) {
		tableDbKeyHash224Type = value;
	}

	public IBusModelDbKeyHash256ColTable getTableDbKeyHash256Col() {
		return( tableDbKeyHash256Col );
	}

	public void setTableDbKeyHash256Col( IBusModelDbKeyHash256ColTable value ) {
		tableDbKeyHash256Col = value;
	}

	public IBusModelDbKeyHash256DefTable getTableDbKeyHash256Def() {
		return( tableDbKeyHash256Def );
	}

	public void setTableDbKeyHash256Def( IBusModelDbKeyHash256DefTable value ) {
		tableDbKeyHash256Def = value;
	}

	public IBusModelDbKeyHash256GenTable getTableDbKeyHash256Gen() {
		return( tableDbKeyHash256Gen );
	}

	public void setTableDbKeyHash256Gen( IBusModelDbKeyHash256GenTable value ) {
		tableDbKeyHash256Gen = value;
	}

	public IBusModelDbKeyHash256TypeTable getTableDbKeyHash256Type() {
		return( tableDbKeyHash256Type );
	}

	public void setTableDbKeyHash256Type( IBusModelDbKeyHash256TypeTable value ) {
		tableDbKeyHash256Type = value;
	}

	public IBusModelDbKeyHash384ColTable getTableDbKeyHash384Col() {
		return( tableDbKeyHash384Col );
	}

	public void setTableDbKeyHash384Col( IBusModelDbKeyHash384ColTable value ) {
		tableDbKeyHash384Col = value;
	}

	public IBusModelDbKeyHash384DefTable getTableDbKeyHash384Def() {
		return( tableDbKeyHash384Def );
	}

	public void setTableDbKeyHash384Def( IBusModelDbKeyHash384DefTable value ) {
		tableDbKeyHash384Def = value;
	}

	public IBusModelDbKeyHash384GenTable getTableDbKeyHash384Gen() {
		return( tableDbKeyHash384Gen );
	}

	public void setTableDbKeyHash384Gen( IBusModelDbKeyHash384GenTable value ) {
		tableDbKeyHash384Gen = value;
	}

	public IBusModelDbKeyHash384TypeTable getTableDbKeyHash384Type() {
		return( tableDbKeyHash384Type );
	}

	public void setTableDbKeyHash384Type( IBusModelDbKeyHash384TypeTable value ) {
		tableDbKeyHash384Type = value;
	}

	public IBusModelDbKeyHash512ColTable getTableDbKeyHash512Col() {
		return( tableDbKeyHash512Col );
	}

	public void setTableDbKeyHash512Col( IBusModelDbKeyHash512ColTable value ) {
		tableDbKeyHash512Col = value;
	}

	public IBusModelDbKeyHash512DefTable getTableDbKeyHash512Def() {
		return( tableDbKeyHash512Def );
	}

	public void setTableDbKeyHash512Def( IBusModelDbKeyHash512DefTable value ) {
		tableDbKeyHash512Def = value;
	}

	public IBusModelDbKeyHash512GenTable getTableDbKeyHash512Gen() {
		return( tableDbKeyHash512Gen );
	}

	public void setTableDbKeyHash512Gen( IBusModelDbKeyHash512GenTable value ) {
		tableDbKeyHash512Gen = value;
	}

	public IBusModelDbKeyHash512TypeTable getTableDbKeyHash512Type() {
		return( tableDbKeyHash512Type );
	}

	public void setTableDbKeyHash512Type( IBusModelDbKeyHash512TypeTable value ) {
		tableDbKeyHash512Type = value;
	}

	public IBusModelDelDepTable getTableDelDep() {
		return( tableDelDep );
	}

	public void setTableDelDep( IBusModelDelDepTable value ) {
		tableDelDep = value;
	}

	public IBusModelDelSubDep1Table getTableDelSubDep1() {
		return( tableDelSubDep1 );
	}

	public void setTableDelSubDep1( IBusModelDelSubDep1Table value ) {
		tableDelSubDep1 = value;
	}

	public IBusModelDelSubDep2Table getTableDelSubDep2() {
		return( tableDelSubDep2 );
	}

	public void setTableDelSubDep2( IBusModelDelSubDep2Table value ) {
		tableDelSubDep2 = value;
	}

	public IBusModelDelSubDep3Table getTableDelSubDep3() {
		return( tableDelSubDep3 );
	}

	public void setTableDelSubDep3( IBusModelDelSubDep3Table value ) {
		tableDelSubDep3 = value;
	}

	public IBusModelDelTopDepTable getTableDelTopDep() {
		return( tableDelTopDep );
	}

	public void setTableDelTopDep( IBusModelDelTopDepTable value ) {
		tableDelTopDep = value;
	}

	public IBusModelDoubleColTable getTableDoubleCol() {
		return( tableDoubleCol );
	}

	public void setTableDoubleCol( IBusModelDoubleColTable value ) {
		tableDoubleCol = value;
	}

	public IBusModelDoubleDefTable getTableDoubleDef() {
		return( tableDoubleDef );
	}

	public void setTableDoubleDef( IBusModelDoubleDefTable value ) {
		tableDoubleDef = value;
	}

	public IBusModelDoubleTypeTable getTableDoubleType() {
		return( tableDoubleType );
	}

	public void setTableDoubleType( IBusModelDoubleTypeTable value ) {
		tableDoubleType = value;
	}

	public IBusModelEnumDefTable getTableEnumDef() {
		return( tableEnumDef );
	}

	public void setTableEnumDef( IBusModelEnumDefTable value ) {
		tableEnumDef = value;
	}

	public IBusModelEnumTagTable getTableEnumTag() {
		return( tableEnumTag );
	}

	public void setTableEnumTag( IBusModelEnumTagTable value ) {
		tableEnumTag = value;
	}

	public IBusModelEnumTypeTable getTableEnumType() {
		return( tableEnumType );
	}

	public void setTableEnumType( IBusModelEnumTypeTable value ) {
		tableEnumType = value;
	}

	public IBusModelFloatColTable getTableFloatCol() {
		return( tableFloatCol );
	}

	public void setTableFloatCol( IBusModelFloatColTable value ) {
		tableFloatCol = value;
	}

	public IBusModelFloatDefTable getTableFloatDef() {
		return( tableFloatDef );
	}

	public void setTableFloatDef( IBusModelFloatDefTable value ) {
		tableFloatDef = value;
	}

	public IBusModelFloatTypeTable getTableFloatType() {
		return( tableFloatType );
	}

	public void setTableFloatType( IBusModelFloatTypeTable value ) {
		tableFloatType = value;
	}

	public ISecureISOCcyTable getTableISOCcy() {
		return( tableISOCcy );
	}

	public void setTableISOCcy( ISecureISOCcyTable value ) {
		tableISOCcy = value;
	}

	public ISecureISOCtryTable getTableISOCtry() {
		return( tableISOCtry );
	}

	public void setTableISOCtry( ISecureISOCtryTable value ) {
		tableISOCtry = value;
	}

	public ISecureISOCtryCcyTable getTableISOCtryCcy() {
		return( tableISOCtryCcy );
	}

	public void setTableISOCtryCcy( ISecureISOCtryCcyTable value ) {
		tableISOCtryCcy = value;
	}

	public ISecureISOCtryLangTable getTableISOCtryLang() {
		return( tableISOCtryLang );
	}

	public void setTableISOCtryLang( ISecureISOCtryLangTable value ) {
		tableISOCtryLang = value;
	}

	public ISecureISOLangTable getTableISOLang() {
		return( tableISOLang );
	}

	public void setTableISOLang( ISecureISOLangTable value ) {
		tableISOLang = value;
	}

	public ISecureISOTZoneTable getTableISOTZone() {
		return( tableISOTZone );
	}

	public void setTableISOTZone( ISecureISOTZoneTable value ) {
		tableISOTZone = value;
	}

	public IBusModelId16GenTable getTableId16Gen() {
		return( tableId16Gen );
	}

	public void setTableId16Gen( IBusModelId16GenTable value ) {
		tableId16Gen = value;
	}

	public IBusModelId32GenTable getTableId32Gen() {
		return( tableId32Gen );
	}

	public void setTableId32Gen( IBusModelId32GenTable value ) {
		tableId32Gen = value;
	}

	public IBusModelId64GenTable getTableId64Gen() {
		return( tableId64Gen );
	}

	public void setTableId64Gen( IBusModelId64GenTable value ) {
		tableId64Gen = value;
	}

	public IBusModelIndexTable getTableIndex() {
		return( tableIndex );
	}

	public void setTableIndex( IBusModelIndexTable value ) {
		tableIndex = value;
	}

	public IBusModelIndexColTable getTableIndexCol() {
		return( tableIndexCol );
	}

	public void setTableIndexCol( IBusModelIndexColTable value ) {
		tableIndexCol = value;
	}

	public IBusModelIndexTweakTable getTableIndexTweak() {
		return( tableIndexTweak );
	}

	public void setTableIndexTweak( IBusModelIndexTweakTable value ) {
		tableIndexTweak = value;
	}

	public IBusModelInt16ColTable getTableInt16Col() {
		return( tableInt16Col );
	}

	public void setTableInt16Col( IBusModelInt16ColTable value ) {
		tableInt16Col = value;
	}

	public IBusModelInt16DefTable getTableInt16Def() {
		return( tableInt16Def );
	}

	public void setTableInt16Def( IBusModelInt16DefTable value ) {
		tableInt16Def = value;
	}

	public IBusModelInt16TypeTable getTableInt16Type() {
		return( tableInt16Type );
	}

	public void setTableInt16Type( IBusModelInt16TypeTable value ) {
		tableInt16Type = value;
	}

	public IBusModelInt32ColTable getTableInt32Col() {
		return( tableInt32Col );
	}

	public void setTableInt32Col( IBusModelInt32ColTable value ) {
		tableInt32Col = value;
	}

	public IBusModelInt32DefTable getTableInt32Def() {
		return( tableInt32Def );
	}

	public void setTableInt32Def( IBusModelInt32DefTable value ) {
		tableInt32Def = value;
	}

	public IBusModelInt32TypeTable getTableInt32Type() {
		return( tableInt32Type );
	}

	public void setTableInt32Type( IBusModelInt32TypeTable value ) {
		tableInt32Type = value;
	}

	public IBusModelInt64ColTable getTableInt64Col() {
		return( tableInt64Col );
	}

	public void setTableInt64Col( IBusModelInt64ColTable value ) {
		tableInt64Col = value;
	}

	public IBusModelInt64DefTable getTableInt64Def() {
		return( tableInt64Def );
	}

	public void setTableInt64Def( IBusModelInt64DefTable value ) {
		tableInt64Def = value;
	}

	public IBusModelInt64TypeTable getTableInt64Type() {
		return( tableInt64Type );
	}

	public void setTableInt64Type( IBusModelInt64TypeTable value ) {
		tableInt64Type = value;
	}

	public IIntNetLicenseTable getTableLicense() {
		return( tableLicense );
	}

	public void setTableLicense( IIntNetLicenseTable value ) {
		tableLicense = value;
	}

	public IIntNetMajorVersionTable getTableMajorVersion() {
		return( tableMajorVersion );
	}

	public void setTableMajorVersion( IIntNetMajorVersionTable value ) {
		tableMajorVersion = value;
	}

	public IIntNetMimeTypeTable getTableMimeType() {
		return( tableMimeType );
	}

	public void setTableMimeType( IIntNetMimeTypeTable value ) {
		tableMimeType = value;
	}

	public IIntNetMinorVersionTable getTableMinorVersion() {
		return( tableMinorVersion );
	}

	public void setTableMinorVersion( IIntNetMinorVersionTable value ) {
		tableMinorVersion = value;
	}

	public IBusModelNmTokenColTable getTableNmTokenCol() {
		return( tableNmTokenCol );
	}

	public void setTableNmTokenCol( IBusModelNmTokenColTable value ) {
		tableNmTokenCol = value;
	}

	public IBusModelNmTokenDefTable getTableNmTokenDef() {
		return( tableNmTokenDef );
	}

	public void setTableNmTokenDef( IBusModelNmTokenDefTable value ) {
		tableNmTokenDef = value;
	}

	public IBusModelNmTokenTypeTable getTableNmTokenType() {
		return( tableNmTokenType );
	}

	public void setTableNmTokenType( IBusModelNmTokenTypeTable value ) {
		tableNmTokenType = value;
	}

	public IBusModelNmTokensColTable getTableNmTokensCol() {
		return( tableNmTokensCol );
	}

	public void setTableNmTokensCol( IBusModelNmTokensColTable value ) {
		tableNmTokensCol = value;
	}

	public IBusModelNmTokensDefTable getTableNmTokensDef() {
		return( tableNmTokensDef );
	}

	public void setTableNmTokensDef( IBusModelNmTokensDefTable value ) {
		tableNmTokensDef = value;
	}

	public IBusModelNmTokensTypeTable getTableNmTokensType() {
		return( tableNmTokensType );
	}

	public void setTableNmTokensType( IBusModelNmTokensTypeTable value ) {
		tableNmTokensType = value;
	}

	public IBusModelNumberColTable getTableNumberCol() {
		return( tableNumberCol );
	}

	public void setTableNumberCol( IBusModelNumberColTable value ) {
		tableNumberCol = value;
	}

	public IBusModelNumberDefTable getTableNumberDef() {
		return( tableNumberDef );
	}

	public void setTableNumberDef( IBusModelNumberDefTable value ) {
		tableNumberDef = value;
	}

	public IBusModelNumberTypeTable getTableNumberType() {
		return( tableNumberType );
	}

	public void setTableNumberType( IBusModelNumberTypeTable value ) {
		tableNumberType = value;
	}

	public IBusModelParamTable getTableParam() {
		return( tableParam );
	}

	public void setTableParam( IBusModelParamTable value ) {
		tableParam = value;
	}

	public IBusModelPopDepTable getTablePopDep() {
		return( tablePopDep );
	}

	public void setTablePopDep( IBusModelPopDepTable value ) {
		tablePopDep = value;
	}

	public IBusModelPopSubDep1Table getTablePopSubDep1() {
		return( tablePopSubDep1 );
	}

	public void setTablePopSubDep1( IBusModelPopSubDep1Table value ) {
		tablePopSubDep1 = value;
	}

	public IBusModelPopSubDep2Table getTablePopSubDep2() {
		return( tablePopSubDep2 );
	}

	public void setTablePopSubDep2( IBusModelPopSubDep2Table value ) {
		tablePopSubDep2 = value;
	}

	public IBusModelPopSubDep3Table getTablePopSubDep3() {
		return( tablePopSubDep3 );
	}

	public void setTablePopSubDep3( IBusModelPopSubDep3Table value ) {
		tablePopSubDep3 = value;
	}

	public IBusModelPopTopDepTable getTablePopTopDep() {
		return( tablePopTopDep );
	}

	public void setTablePopTopDep( IBusModelPopTopDepTable value ) {
		tablePopTopDep = value;
	}

	public IBusModelRelationTable getTableRelation() {
		return( tableRelation );
	}

	public void setTableRelation( IBusModelRelationTable value ) {
		tableRelation = value;
	}

	public IBusModelRelationColTable getTableRelationCol() {
		return( tableRelationCol );
	}

	public void setTableRelationCol( IBusModelRelationColTable value ) {
		tableRelationCol = value;
	}

	public IBusModelRoleDefTable getTableRoleDef() {
		return( tableRoleDef );
	}

	public void setTableRoleDef( IBusModelRoleDefTable value ) {
		tableRoleDef = value;
	}

	public IBusModelSchemaDefTable getTableSchemaDef() {
		return( tableSchemaDef );
	}

	public void setTableSchemaDef( IBusModelSchemaDefTable value ) {
		tableSchemaDef = value;
	}

	public IBusModelSchemaRefTable getTableSchemaRef() {
		return( tableSchemaRef );
	}

	public void setTableSchemaRef( IBusModelSchemaRefTable value ) {
		tableSchemaRef = value;
	}

	public IBusModelSchemaRoleTable getTableSchemaRole() {
		return( tableSchemaRole );
	}

	public void setTableSchemaRole( IBusModelSchemaRoleTable value ) {
		tableSchemaRole = value;
	}

	public IBusModelSchemaTweakTable getTableSchemaTweak() {
		return( tableSchemaTweak );
	}

	public void setTableSchemaTweak( IBusModelSchemaTweakTable value ) {
		tableSchemaTweak = value;
	}

	public IBusModelScopeTable getTableScope() {
		return( tableScope );
	}

	public void setTableScope( IBusModelScopeTable value ) {
		tableScope = value;
	}

	public ISecureSecClusGrpTable getTableSecClusGrp() {
		return( tableSecClusGrp );
	}

	public void setTableSecClusGrp( ISecureSecClusGrpTable value ) {
		tableSecClusGrp = value;
	}

	public ISecureSecClusGrpMembTable getTableSecClusGrpMemb() {
		return( tableSecClusGrpMemb );
	}

	public void setTableSecClusGrpMemb( ISecureSecClusGrpMembTable value ) {
		tableSecClusGrpMemb = value;
	}

	public ISecureSecClusRoleTable getTableSecClusRole() {
		return( tableSecClusRole );
	}

	public void setTableSecClusRole( ISecureSecClusRoleTable value ) {
		tableSecClusRole = value;
	}

	public ISecureSecClusRoleMembTable getTableSecClusRoleMemb() {
		return( tableSecClusRoleMemb );
	}

	public void setTableSecClusRoleMemb( ISecureSecClusRoleMembTable value ) {
		tableSecClusRoleMemb = value;
	}

	public ISecureSecSessionTable getTableSecSession() {
		return( tableSecSession );
	}

	public void setTableSecSession( ISecureSecSessionTable value ) {
		tableSecSession = value;
	}

	public ISecureSecSysGrpTable getTableSecSysGrp() {
		return( tableSecSysGrp );
	}

	public void setTableSecSysGrp( ISecureSecSysGrpTable value ) {
		tableSecSysGrp = value;
	}

	public ISecureSecSysGrpIncTable getTableSecSysGrpInc() {
		return( tableSecSysGrpInc );
	}

	public void setTableSecSysGrpInc( ISecureSecSysGrpIncTable value ) {
		tableSecSysGrpInc = value;
	}

	public ISecureSecSysGrpMembTable getTableSecSysGrpMemb() {
		return( tableSecSysGrpMemb );
	}

	public void setTableSecSysGrpMemb( ISecureSecSysGrpMembTable value ) {
		tableSecSysGrpMemb = value;
	}

	public ISecureSecSysRoleTable getTableSecSysRole() {
		return( tableSecSysRole );
	}

	public void setTableSecSysRole( ISecureSecSysRoleTable value ) {
		tableSecSysRole = value;
	}

	public ISecureSecSysRoleEnablesTable getTableSecSysRoleEnables() {
		return( tableSecSysRoleEnables );
	}

	public void setTableSecSysRoleEnables( ISecureSecSysRoleEnablesTable value ) {
		tableSecSysRoleEnables = value;
	}

	public ISecureSecSysRoleMembTable getTableSecSysRoleMemb() {
		return( tableSecSysRoleMemb );
	}

	public void setTableSecSysRoleMemb( ISecureSecSysRoleMembTable value ) {
		tableSecSysRoleMemb = value;
	}

	public ISecureSecTentGrpTable getTableSecTentGrp() {
		return( tableSecTentGrp );
	}

	public void setTableSecTentGrp( ISecureSecTentGrpTable value ) {
		tableSecTentGrp = value;
	}

	public ISecureSecTentGrpMembTable getTableSecTentGrpMemb() {
		return( tableSecTentGrpMemb );
	}

	public void setTableSecTentGrpMemb( ISecureSecTentGrpMembTable value ) {
		tableSecTentGrpMemb = value;
	}

	public ISecureSecTentRoleTable getTableSecTentRole() {
		return( tableSecTentRole );
	}

	public void setTableSecTentRole( ISecureSecTentRoleTable value ) {
		tableSecTentRole = value;
	}

	public ISecureSecTentRoleMembTable getTableSecTentRoleMemb() {
		return( tableSecTentRoleMemb );
	}

	public void setTableSecTentRoleMemb( ISecureSecTentRoleMembTable value ) {
		tableSecTentRoleMemb = value;
	}

	public ISecureSecUserTable getTableSecUser() {
		return( tableSecUser );
	}

	public void setTableSecUser( ISecureSecUserTable value ) {
		tableSecUser = value;
	}

	public ISecureSecUserEMConfTable getTableSecUserEMConf() {
		return( tableSecUserEMConf );
	}

	public void setTableSecUserEMConf( ISecureSecUserEMConfTable value ) {
		tableSecUserEMConf = value;
	}

	public ISecureSecUserPWHistoryTable getTableSecUserPWHistory() {
		return( tableSecUserPWHistory );
	}

	public void setTableSecUserPWHistory( ISecureSecUserPWHistoryTable value ) {
		tableSecUserPWHistory = value;
	}

	public ISecureSecUserPWResetTable getTableSecUserPWReset() {
		return( tableSecUserPWReset );
	}

	public void setTableSecUserPWReset( ISecureSecUserPWResetTable value ) {
		tableSecUserPWReset = value;
	}

	public ISecureSecUserPasswordTable getTableSecUserPassword() {
		return( tableSecUserPassword );
	}

	public void setTableSecUserPassword( ISecureSecUserPasswordTable value ) {
		tableSecUserPassword = value;
	}

	public IBusModelServerListFuncTable getTableServerListFunc() {
		return( tableServerListFunc );
	}

	public void setTableServerListFunc( IBusModelServerListFuncTable value ) {
		tableServerListFunc = value;
	}

	public IBusModelServerMethodTable getTableServerMethod() {
		return( tableServerMethod );
	}

	public void setTableServerMethod( IBusModelServerMethodTable value ) {
		tableServerMethod = value;
	}

	public IBusModelServerObjFuncTable getTableServerObjFunc() {
		return( tableServerObjFunc );
	}

	public void setTableServerObjFunc( IBusModelServerObjFuncTable value ) {
		tableServerObjFunc = value;
	}

	public IBusModelServerProcTable getTableServerProc() {
		return( tableServerProc );
	}

	public void setTableServerProc( IBusModelServerProcTable value ) {
		tableServerProc = value;
	}

	public IBusModelStringColTable getTableStringCol() {
		return( tableStringCol );
	}

	public void setTableStringCol( IBusModelStringColTable value ) {
		tableStringCol = value;
	}

	public IBusModelStringDefTable getTableStringDef() {
		return( tableStringDef );
	}

	public void setTableStringDef( IBusModelStringDefTable value ) {
		tableStringDef = value;
	}

	public IBusModelStringTypeTable getTableStringType() {
		return( tableStringType );
	}

	public void setTableStringType( IBusModelStringTypeTable value ) {
		tableStringType = value;
	}

	public IIntNetSubProjectTable getTableSubProject() {
		return( tableSubProject );
	}

	public void setTableSubProject( IIntNetSubProjectTable value ) {
		tableSubProject = value;
	}

	public ISecureSysClusterTable getTableSysCluster() {
		return( tableSysCluster );
	}

	public void setTableSysCluster( ISecureSysClusterTable value ) {
		tableSysCluster = value;
	}

	public IBusModelTZDateColTable getTableTZDateCol() {
		return( tableTZDateCol );
	}

	public void setTableTZDateCol( IBusModelTZDateColTable value ) {
		tableTZDateCol = value;
	}

	public IBusModelTZDateDefTable getTableTZDateDef() {
		return( tableTZDateDef );
	}

	public void setTableTZDateDef( IBusModelTZDateDefTable value ) {
		tableTZDateDef = value;
	}

	public IBusModelTZDateTypeTable getTableTZDateType() {
		return( tableTZDateType );
	}

	public void setTableTZDateType( IBusModelTZDateTypeTable value ) {
		tableTZDateType = value;
	}

	public IBusModelTZTimeColTable getTableTZTimeCol() {
		return( tableTZTimeCol );
	}

	public void setTableTZTimeCol( IBusModelTZTimeColTable value ) {
		tableTZTimeCol = value;
	}

	public IBusModelTZTimeDefTable getTableTZTimeDef() {
		return( tableTZTimeDef );
	}

	public void setTableTZTimeDef( IBusModelTZTimeDefTable value ) {
		tableTZTimeDef = value;
	}

	public IBusModelTZTimeTypeTable getTableTZTimeType() {
		return( tableTZTimeType );
	}

	public void setTableTZTimeType( IBusModelTZTimeTypeTable value ) {
		tableTZTimeType = value;
	}

	public IBusModelTZTimestampColTable getTableTZTimestampCol() {
		return( tableTZTimestampCol );
	}

	public void setTableTZTimestampCol( IBusModelTZTimestampColTable value ) {
		tableTZTimestampCol = value;
	}

	public IBusModelTZTimestampDefTable getTableTZTimestampDef() {
		return( tableTZTimestampDef );
	}

	public void setTableTZTimestampDef( IBusModelTZTimestampDefTable value ) {
		tableTZTimestampDef = value;
	}

	public IBusModelTZTimestampTypeTable getTableTZTimestampType() {
		return( tableTZTimestampType );
	}

	public void setTableTZTimestampType( IBusModelTZTimestampTypeTable value ) {
		tableTZTimestampType = value;
	}

	public IBusModelTableTable getTableTable() {
		return( tableTable );
	}

	public void setTableTable( IBusModelTableTable value ) {
		tableTable = value;
	}

	public IBusModelTableColTable getTableTableCol() {
		return( tableTableCol );
	}

	public void setTableTableCol( IBusModelTableColTable value ) {
		tableTableCol = value;
	}

	public ISecureTableInfoTable getTableTableInfo() {
		return( tableTableInfo );
	}

	public void setTableTableInfo( ISecureTableInfoTable value ) {
		tableTableInfo = value;
	}

	public IBusModelTableTweakTable getTableTableTweak() {
		return( tableTableTweak );
	}

	public void setTableTableTweak( IBusModelTableTweakTable value ) {
		tableTableTweak = value;
	}

	public ISecureTenantTable getTableTenant() {
		return( tableTenant );
	}

	public void setTableTenant( ISecureTenantTable value ) {
		tableTenant = value;
	}

	public IBusModelTextColTable getTableTextCol() {
		return( tableTextCol );
	}

	public void setTableTextCol( IBusModelTextColTable value ) {
		tableTextCol = value;
	}

	public IBusModelTextDefTable getTableTextDef() {
		return( tableTextDef );
	}

	public void setTableTextDef( IBusModelTextDefTable value ) {
		tableTextDef = value;
	}

	public IBusModelTextTypeTable getTableTextType() {
		return( tableTextType );
	}

	public void setTableTextType( IBusModelTextTypeTable value ) {
		tableTextType = value;
	}

	public IBusModelTimeColTable getTableTimeCol() {
		return( tableTimeCol );
	}

	public void setTableTimeCol( IBusModelTimeColTable value ) {
		tableTimeCol = value;
	}

	public IBusModelTimeDefTable getTableTimeDef() {
		return( tableTimeDef );
	}

	public void setTableTimeDef( IBusModelTimeDefTable value ) {
		tableTimeDef = value;
	}

	public IBusModelTimeTypeTable getTableTimeType() {
		return( tableTimeType );
	}

	public void setTableTimeType( IBusModelTimeTypeTable value ) {
		tableTimeType = value;
	}

	public IBusModelTimestampColTable getTableTimestampCol() {
		return( tableTimestampCol );
	}

	public void setTableTimestampCol( IBusModelTimestampColTable value ) {
		tableTimestampCol = value;
	}

	public IBusModelTimestampDefTable getTableTimestampDef() {
		return( tableTimestampDef );
	}

	public void setTableTimestampDef( IBusModelTimestampDefTable value ) {
		tableTimestampDef = value;
	}

	public IBusModelTimestampTypeTable getTableTimestampType() {
		return( tableTimestampType );
	}

	public void setTableTimestampType( IBusModelTimestampTypeTable value ) {
		tableTimestampType = value;
	}

	public IIntNetTldTable getTableTld() {
		return( tableTld );
	}

	public void setTableTld( IIntNetTldTable value ) {
		tableTld = value;
	}

	public IBusModelTokenColTable getTableTokenCol() {
		return( tableTokenCol );
	}

	public void setTableTokenCol( IBusModelTokenColTable value ) {
		tableTokenCol = value;
	}

	public IBusModelTokenDefTable getTableTokenDef() {
		return( tableTokenDef );
	}

	public void setTableTokenDef( IBusModelTokenDefTable value ) {
		tableTokenDef = value;
	}

	public IBusModelTokenTypeTable getTableTokenType() {
		return( tableTokenType );
	}

	public void setTableTokenType( IBusModelTokenTypeTable value ) {
		tableTokenType = value;
	}

	public IIntNetTopDomainTable getTableTopDomain() {
		return( tableTopDomain );
	}

	public void setTableTopDomain( IIntNetTopDomainTable value ) {
		tableTopDomain = value;
	}

	public IIntNetTopProjectTable getTableTopProject() {
		return( tableTopProject );
	}

	public void setTableTopProject( IIntNetTopProjectTable value ) {
		tableTopProject = value;
	}

	public IBusModelTweakTable getTableTweak() {
		return( tableTweak );
	}

	public void setTableTweak( IBusModelTweakTable value ) {
		tableTweak = value;
	}

	public IBusModelUInt16ColTable getTableUInt16Col() {
		return( tableUInt16Col );
	}

	public void setTableUInt16Col( IBusModelUInt16ColTable value ) {
		tableUInt16Col = value;
	}

	public IBusModelUInt16DefTable getTableUInt16Def() {
		return( tableUInt16Def );
	}

	public void setTableUInt16Def( IBusModelUInt16DefTable value ) {
		tableUInt16Def = value;
	}

	public IBusModelUInt16TypeTable getTableUInt16Type() {
		return( tableUInt16Type );
	}

	public void setTableUInt16Type( IBusModelUInt16TypeTable value ) {
		tableUInt16Type = value;
	}

	public IBusModelUInt32ColTable getTableUInt32Col() {
		return( tableUInt32Col );
	}

	public void setTableUInt32Col( IBusModelUInt32ColTable value ) {
		tableUInt32Col = value;
	}

	public IBusModelUInt32DefTable getTableUInt32Def() {
		return( tableUInt32Def );
	}

	public void setTableUInt32Def( IBusModelUInt32DefTable value ) {
		tableUInt32Def = value;
	}

	public IBusModelUInt32TypeTable getTableUInt32Type() {
		return( tableUInt32Type );
	}

	public void setTableUInt32Type( IBusModelUInt32TypeTable value ) {
		tableUInt32Type = value;
	}

	public IBusModelUInt64ColTable getTableUInt64Col() {
		return( tableUInt64Col );
	}

	public void setTableUInt64Col( IBusModelUInt64ColTable value ) {
		tableUInt64Col = value;
	}

	public IBusModelUInt64DefTable getTableUInt64Def() {
		return( tableUInt64Def );
	}

	public void setTableUInt64Def( IBusModelUInt64DefTable value ) {
		tableUInt64Def = value;
	}

	public IBusModelUInt64TypeTable getTableUInt64Type() {
		return( tableUInt64Type );
	}

	public void setTableUInt64Type( IBusModelUInt64TypeTable value ) {
		tableUInt64Type = value;
	}

	public IIntNetURLProtocolTable getTableURLProtocol() {
		return( tableURLProtocol );
	}

	public void setTableURLProtocol( IIntNetURLProtocolTable value ) {
		tableURLProtocol = value;
	}

	public IBusModelUuid6ColTable getTableUuid6Col() {
		return( tableUuid6Col );
	}

	public void setTableUuid6Col( IBusModelUuid6ColTable value ) {
		tableUuid6Col = value;
	}

	public IBusModelUuid6DefTable getTableUuid6Def() {
		return( tableUuid6Def );
	}

	public void setTableUuid6Def( IBusModelUuid6DefTable value ) {
		tableUuid6Def = value;
	}

	public IBusModelUuid6GenTable getTableUuid6Gen() {
		return( tableUuid6Gen );
	}

	public void setTableUuid6Gen( IBusModelUuid6GenTable value ) {
		tableUuid6Gen = value;
	}

	public IBusModelUuid6TypeTable getTableUuid6Type() {
		return( tableUuid6Type );
	}

	public void setTableUuid6Type( IBusModelUuid6TypeTable value ) {
		tableUuid6Type = value;
	}

	public IBusModelUuidColTable getTableUuidCol() {
		return( tableUuidCol );
	}

	public void setTableUuidCol( IBusModelUuidColTable value ) {
		tableUuidCol = value;
	}

	public IBusModelUuidDefTable getTableUuidDef() {
		return( tableUuidDef );
	}

	public void setTableUuidDef( IBusModelUuidDefTable value ) {
		tableUuidDef = value;
	}

	public IBusModelUuidGenTable getTableUuidGen() {
		return( tableUuidGen );
	}

	public void setTableUuidGen( IBusModelUuidGenTable value ) {
		tableUuidGen = value;
	}

	public IBusModelUuidTypeTable getTableUuidType() {
		return( tableUuidType );
	}

	public void setTableUuidType( IBusModelUuidTypeTable value ) {
		tableUuidType = value;
	}

	public IBusModelValueTable getTableValue() {
		return( tableValue );
	}

	public void setTableValue( IBusModelValueTable value ) {
		tableValue = value;
	}

	public static String xmlEncodeString( String val ) {
		StringBuffer buff = new StringBuffer();
		int len = val.length();
		for( int idx = 0; idx < len; idx ++ ) {
			char c = val.charAt( idx );
			switch( c ) {
				case '&':
					buff.append( "&amp;" );
					break;
				case '<':
					buff.append( "&lt;" );
					break;
				case '>':
					buff.append( "&gt;" );
					break;
				case '"':
					buff.append( "&quot;" );
					break;
				case '\'':
					buff.append( "&apos;" );
					break;
				default:
					buff.append( c );
					break;
			}
		}
		return( buff.toString() );
	}

	public void bootstrapSchema(SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapSchema(tableData);
	}
	
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapAllTablesSecurity(clusterId, tenantId, tableData);
	}
}
