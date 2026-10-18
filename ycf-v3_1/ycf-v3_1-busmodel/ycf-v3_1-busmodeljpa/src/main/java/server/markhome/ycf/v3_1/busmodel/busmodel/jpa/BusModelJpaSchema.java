// Description: Java 25 JPA implementation of a BusModel schema.

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

package server.markhome.ycf.v3_1.busmodel.busmodel.jpa;
//package server.markhome.ycf.v3_1.busmodel.busmodel.jpa;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.net.InetAddress;
import java.util.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.YCFXmlUtil;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.jpa.BusModelJpaHooksSchema;

import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffSchema;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffFactoryService;
import server.markhome.ycf.v3_1.intnet.intnet.buff.IntNetBuffSchema;
import server.markhome.ycf.v3_1.intnet.intnet.buff.IntNetBuffFactoryService;
import server.markhome.ycf.v3_1.busmodel.busmodel.buff.BusModelBuffSchema;
import server.markhome.ycf.v3_1.busmodel.busmodel.buff.BusModelBuffFactoryService;

public class BusModelJpaSchema
	implements IBusModelSchema,
		ISecureSchema,
		IIntNetSchema
{
	private static BusModelJpaHooksSchema busmodelJpaHooksSchema = null;

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
					IBusModelScope ret = new BusModelJpaScope();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelScope.CLASS_CODE)[" + IBusModelScope.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelSchemaDef ret = new BusModelJpaSchemaDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaDef.CLASS_CODE)[" + IBusModelSchemaDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaRef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelSchemaRef ret = new BusModelJpaSchemaRef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaRef.CLASS_CODE)[" + IBusModelSchemaRef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerMethod.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelServerMethod ret = new BusModelJpaServerMethod();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerMethod.CLASS_CODE)[" + IBusModelServerMethod.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerObjFunc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelServerObjFunc ret = new BusModelJpaServerObjFunc();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerObjFunc.CLASS_CODE)[" + IBusModelServerObjFunc.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerProc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelServerProc ret = new BusModelJpaServerProc();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerProc.CLASS_CODE)[" + IBusModelServerProc.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTable.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTable ret = new BusModelJpaTable();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTable.CLASS_CODE)[" + IBusModelTable.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTweak.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTweak ret = new BusModelJpaTweak();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTweak.CLASS_CODE)[" + IBusModelTweak.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTableTweak.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTableTweak ret = new BusModelJpaTableTweak();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTableTweak.CLASS_CODE)[" + IBusModelTableTweak.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaTweak.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelSchemaTweak ret = new BusModelJpaSchemaTweak();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaTweak.CLASS_CODE)[" + IBusModelSchemaTweak.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndexTweak.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelIndexTweak ret = new BusModelJpaIndexTweak();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndexTweak.CLASS_CODE)[" + IBusModelIndexTweak.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelValue.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelValue ret = new BusModelJpaValue();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelValue.CLASS_CODE)[" + IBusModelValue.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelAtom.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelAtom ret = new BusModelJpaAtom();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelAtom.CLASS_CODE)[" + IBusModelAtom.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBlobDef ret = new BusModelJpaBlobDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobDef.CLASS_CODE)[" + IBusModelBlobDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBlobType ret = new BusModelJpaBlobType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobType.CLASS_CODE)[" + IBusModelBlobType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBoolDef ret = new BusModelJpaBoolDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolDef.CLASS_CODE)[" + IBusModelBoolDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBoolType ret = new BusModelJpaBoolType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolType.CLASS_CODE)[" + IBusModelBoolType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelChain.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelChain ret = new BusModelJpaChain();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelChain.CLASS_CODE)[" + IBusModelChain.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearDep ret = new BusModelJpaClearDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearDep.CLASS_CODE)[" + IBusModelClearDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep1.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearSubDep1 ret = new BusModelJpaClearSubDep1();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep1.CLASS_CODE)[" + IBusModelClearSubDep1.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep2.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearSubDep2 ret = new BusModelJpaClearSubDep2();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep2.CLASS_CODE)[" + IBusModelClearSubDep2.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep3.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearSubDep3 ret = new BusModelJpaClearSubDep3();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearSubDep3.CLASS_CODE)[" + IBusModelClearSubDep3.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearTopDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelClearTopDep ret = new BusModelJpaClearTopDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelClearTopDep.CLASS_CODE)[" + IBusModelClearTopDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDateDef ret = new BusModelJpaDateDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateDef.CLASS_CODE)[" + IBusModelDateDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDateType ret = new BusModelJpaDateType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateType.CLASS_CODE)[" + IBusModelDateType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelDep ret = new BusModelJpaDelDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelDep.CLASS_CODE)[" + IBusModelDelDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep1.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelSubDep1 ret = new BusModelJpaDelSubDep1();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep1.CLASS_CODE)[" + IBusModelDelSubDep1.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep2.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelSubDep2 ret = new BusModelJpaDelSubDep2();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep2.CLASS_CODE)[" + IBusModelDelSubDep2.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep3.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelSubDep3 ret = new BusModelJpaDelSubDep3();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelSubDep3.CLASS_CODE)[" + IBusModelDelSubDep3.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelTopDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDelTopDep ret = new BusModelJpaDelTopDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDelTopDep.CLASS_CODE)[" + IBusModelDelTopDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDoubleDef ret = new BusModelJpaDoubleDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleDef.CLASS_CODE)[" + IBusModelDoubleDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDoubleType ret = new BusModelJpaDoubleType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleType.CLASS_CODE)[" + IBusModelDoubleType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumTag.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelEnumTag ret = new BusModelJpaEnumTag();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumTag.CLASS_CODE)[" + IBusModelEnumTag.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelFloatDef ret = new BusModelJpaFloatDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatDef.CLASS_CODE)[" + IBusModelFloatDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelFloatType ret = new BusModelJpaFloatType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatType.CLASS_CODE)[" + IBusModelFloatType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndex.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelIndex ret = new BusModelJpaIndex();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndex.CLASS_CODE)[" + IBusModelIndex.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndexCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelIndexCol ret = new BusModelJpaIndexCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelIndexCol.CLASS_CODE)[" + IBusModelIndexCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt16Def ret = new BusModelJpaInt16Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Def.CLASS_CODE)[" + IBusModelInt16Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt16Type ret = new BusModelJpaInt16Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Type.CLASS_CODE)[" + IBusModelInt16Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt32Def ret = new BusModelJpaInt32Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Def.CLASS_CODE)[" + IBusModelInt32Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt32Type ret = new BusModelJpaInt32Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Type.CLASS_CODE)[" + IBusModelInt32Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt64Def ret = new BusModelJpaInt64Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Def.CLASS_CODE)[" + IBusModelInt64Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt64Type ret = new BusModelJpaInt64Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Type.CLASS_CODE)[" + IBusModelInt64Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokenDef ret = new BusModelJpaNmTokenDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenDef.CLASS_CODE)[" + IBusModelNmTokenDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokenType ret = new BusModelJpaNmTokenType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenType.CLASS_CODE)[" + IBusModelNmTokenType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokensDef ret = new BusModelJpaNmTokensDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensDef.CLASS_CODE)[" + IBusModelNmTokensDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokensType ret = new BusModelJpaNmTokensType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensType.CLASS_CODE)[" + IBusModelNmTokensType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNumberDef ret = new BusModelJpaNumberDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberDef.CLASS_CODE)[" + IBusModelNumberDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNumberType ret = new BusModelJpaNumberType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberType.CLASS_CODE)[" + IBusModelNumberType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelParam.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelParam ret = new BusModelJpaParam();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelParam.CLASS_CODE)[" + IBusModelParam.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopDep ret = new BusModelJpaPopDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopDep.CLASS_CODE)[" + IBusModelPopDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep1.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopSubDep1 ret = new BusModelJpaPopSubDep1();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep1.CLASS_CODE)[" + IBusModelPopSubDep1.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep2.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopSubDep2 ret = new BusModelJpaPopSubDep2();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep2.CLASS_CODE)[" + IBusModelPopSubDep2.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep3.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopSubDep3 ret = new BusModelJpaPopSubDep3();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopSubDep3.CLASS_CODE)[" + IBusModelPopSubDep3.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopTopDep.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelPopTopDep ret = new BusModelJpaPopTopDep();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelPopTopDep.CLASS_CODE)[" + IBusModelPopTopDep.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelRelation.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelRelation ret = new BusModelJpaRelation();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelRelation.CLASS_CODE)[" + IBusModelRelation.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelRelationCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelRelationCol ret = new BusModelJpaRelationCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelRelationCol.CLASS_CODE)[" + IBusModelRelationCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerListFunc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelServerListFunc ret = new BusModelJpaServerListFunc();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelServerListFunc.CLASS_CODE)[" + IBusModelServerListFunc.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash128Def ret = new BusModelJpaDbKeyHash128Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Def.CLASS_CODE)[" + IBusModelDbKeyHash128Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash128Col ret = new BusModelJpaDbKeyHash128Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Col.CLASS_CODE)[" + IBusModelDbKeyHash128Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash128Type ret = new BusModelJpaDbKeyHash128Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Type.CLASS_CODE)[" + IBusModelDbKeyHash128Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash128Gen ret = new BusModelJpaDbKeyHash128Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash128Gen.CLASS_CODE)[" + IBusModelDbKeyHash128Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash160Def ret = new BusModelJpaDbKeyHash160Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Def.CLASS_CODE)[" + IBusModelDbKeyHash160Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash160Col ret = new BusModelJpaDbKeyHash160Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Col.CLASS_CODE)[" + IBusModelDbKeyHash160Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash160Type ret = new BusModelJpaDbKeyHash160Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Type.CLASS_CODE)[" + IBusModelDbKeyHash160Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash160Gen ret = new BusModelJpaDbKeyHash160Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash160Gen.CLASS_CODE)[" + IBusModelDbKeyHash160Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash224Def ret = new BusModelJpaDbKeyHash224Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Def.CLASS_CODE)[" + IBusModelDbKeyHash224Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash224Col ret = new BusModelJpaDbKeyHash224Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Col.CLASS_CODE)[" + IBusModelDbKeyHash224Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash224Type ret = new BusModelJpaDbKeyHash224Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Type.CLASS_CODE)[" + IBusModelDbKeyHash224Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash224Gen ret = new BusModelJpaDbKeyHash224Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash224Gen.CLASS_CODE)[" + IBusModelDbKeyHash224Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash256Def ret = new BusModelJpaDbKeyHash256Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Def.CLASS_CODE)[" + IBusModelDbKeyHash256Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash256Col ret = new BusModelJpaDbKeyHash256Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Col.CLASS_CODE)[" + IBusModelDbKeyHash256Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash256Type ret = new BusModelJpaDbKeyHash256Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Type.CLASS_CODE)[" + IBusModelDbKeyHash256Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash256Gen ret = new BusModelJpaDbKeyHash256Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash256Gen.CLASS_CODE)[" + IBusModelDbKeyHash256Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash384Def ret = new BusModelJpaDbKeyHash384Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Def.CLASS_CODE)[" + IBusModelDbKeyHash384Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash384Col ret = new BusModelJpaDbKeyHash384Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Col.CLASS_CODE)[" + IBusModelDbKeyHash384Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash384Type ret = new BusModelJpaDbKeyHash384Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Type.CLASS_CODE)[" + IBusModelDbKeyHash384Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash384Gen ret = new BusModelJpaDbKeyHash384Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash384Gen.CLASS_CODE)[" + IBusModelDbKeyHash384Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash512Def ret = new BusModelJpaDbKeyHash512Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Def.CLASS_CODE)[" + IBusModelDbKeyHash512Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash512Col ret = new BusModelJpaDbKeyHash512Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Col.CLASS_CODE)[" + IBusModelDbKeyHash512Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash512Type ret = new BusModelJpaDbKeyHash512Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Type.CLASS_CODE)[" + IBusModelDbKeyHash512Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDbKeyHash512Gen ret = new BusModelJpaDbKeyHash512Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDbKeyHash512Gen.CLASS_CODE)[" + IBusModelDbKeyHash512Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelStringDef ret = new BusModelJpaStringDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringDef.CLASS_CODE)[" + IBusModelStringDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelStringType ret = new BusModelJpaStringType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringType.CLASS_CODE)[" + IBusModelStringType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZDateDef ret = new BusModelJpaTZDateDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateDef.CLASS_CODE)[" + IBusModelTZDateDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZDateType ret = new BusModelJpaTZDateType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateType.CLASS_CODE)[" + IBusModelTZDateType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimeDef ret = new BusModelJpaTZTimeDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeDef.CLASS_CODE)[" + IBusModelTZTimeDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimeType ret = new BusModelJpaTZTimeType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeType.CLASS_CODE)[" + IBusModelTZTimeType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimestampDef ret = new BusModelJpaTZTimestampDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampDef.CLASS_CODE)[" + IBusModelTZTimestampDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimestampType ret = new BusModelJpaTZTimestampType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampType.CLASS_CODE)[" + IBusModelTZTimestampType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTableCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTableCol ret = new BusModelJpaTableCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTableCol.CLASS_CODE)[" + IBusModelTableCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTextDef ret = new BusModelJpaTextDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextDef.CLASS_CODE)[" + IBusModelTextDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTextType ret = new BusModelJpaTextType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextType.CLASS_CODE)[" + IBusModelTextType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimeDef ret = new BusModelJpaTimeDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeDef.CLASS_CODE)[" + IBusModelTimeDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimeType ret = new BusModelJpaTimeType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeType.CLASS_CODE)[" + IBusModelTimeType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimestampDef ret = new BusModelJpaTimestampDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampDef.CLASS_CODE)[" + IBusModelTimestampDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimestampType ret = new BusModelJpaTimestampType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampType.CLASS_CODE)[" + IBusModelTimestampType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTokenDef ret = new BusModelJpaTokenDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenDef.CLASS_CODE)[" + IBusModelTokenDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTokenType ret = new BusModelJpaTokenType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenType.CLASS_CODE)[" + IBusModelTokenType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt16Def ret = new BusModelJpaUInt16Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Def.CLASS_CODE)[" + IBusModelUInt16Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt16Type ret = new BusModelJpaUInt16Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Type.CLASS_CODE)[" + IBusModelUInt16Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt32Def ret = new BusModelJpaUInt32Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Def.CLASS_CODE)[" + IBusModelUInt32Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt32Type ret = new BusModelJpaUInt32Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Type.CLASS_CODE)[" + IBusModelUInt32Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt64Def ret = new BusModelJpaUInt64Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Def.CLASS_CODE)[" + IBusModelUInt64Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt64Type ret = new BusModelJpaUInt64Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Type.CLASS_CODE)[" + IBusModelUInt64Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuidDef ret = new BusModelJpaUuidDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidDef.CLASS_CODE)[" + IBusModelUuidDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Def.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuid6Def ret = new BusModelJpaUuid6Def();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Def.CLASS_CODE)[" + IBusModelUuid6Def.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuidType ret = new BusModelJpaUuidType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidType.CLASS_CODE)[" + IBusModelUuidType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Type.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuid6Type ret = new BusModelJpaUuid6Type();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Type.CLASS_CODE)[" + IBusModelUuid6Type.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBlobCol ret = new BusModelJpaBlobCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBlobCol.CLASS_CODE)[" + IBusModelBlobCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelBoolCol ret = new BusModelJpaBoolCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelBoolCol.CLASS_CODE)[" + IBusModelBoolCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDateCol ret = new BusModelJpaDateCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDateCol.CLASS_CODE)[" + IBusModelDateCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelDoubleCol ret = new BusModelJpaDoubleCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelDoubleCol.CLASS_CODE)[" + IBusModelDoubleCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelEnumDef ret = new BusModelJpaEnumDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumDef.CLASS_CODE)[" + IBusModelEnumDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelEnumType ret = new BusModelJpaEnumType();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelEnumType.CLASS_CODE)[" + IBusModelEnumType.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelFloatCol ret = new BusModelJpaFloatCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelFloatCol.CLASS_CODE)[" + IBusModelFloatCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelId16Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelId16Gen ret = new BusModelJpaId16Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelId16Gen.CLASS_CODE)[" + IBusModelId16Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelId32Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelId32Gen ret = new BusModelJpaId32Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelId32Gen.CLASS_CODE)[" + IBusModelId32Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelId64Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelId64Gen ret = new BusModelJpaId64Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelId64Gen.CLASS_CODE)[" + IBusModelId64Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt16Col ret = new BusModelJpaInt16Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt16Col.CLASS_CODE)[" + IBusModelInt16Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt32Col ret = new BusModelJpaInt32Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt32Col.CLASS_CODE)[" + IBusModelInt32Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelInt64Col ret = new BusModelJpaInt64Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelInt64Col.CLASS_CODE)[" + IBusModelInt64Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokenCol ret = new BusModelJpaNmTokenCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokenCol.CLASS_CODE)[" + IBusModelNmTokenCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNmTokensCol ret = new BusModelJpaNmTokensCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNmTokensCol.CLASS_CODE)[" + IBusModelNmTokensCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelNumberCol ret = new BusModelJpaNumberCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelNumberCol.CLASS_CODE)[" + IBusModelNumberCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelStringCol ret = new BusModelJpaStringCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelStringCol.CLASS_CODE)[" + IBusModelStringCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZDateCol ret = new BusModelJpaTZDateCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZDateCol.CLASS_CODE)[" + IBusModelTZDateCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimeCol ret = new BusModelJpaTZTimeCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimeCol.CLASS_CODE)[" + IBusModelTZTimeCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTZTimestampCol ret = new BusModelJpaTZTimestampCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTZTimestampCol.CLASS_CODE)[" + IBusModelTZTimestampCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTextCol ret = new BusModelJpaTextCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTextCol.CLASS_CODE)[" + IBusModelTextCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimeCol ret = new BusModelJpaTimeCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimeCol.CLASS_CODE)[" + IBusModelTimeCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTimestampCol ret = new BusModelJpaTimestampCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTimestampCol.CLASS_CODE)[" + IBusModelTimestampCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelTokenCol ret = new BusModelJpaTokenCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelTokenCol.CLASS_CODE)[" + IBusModelTokenCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt16Col ret = new BusModelJpaUInt16Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt16Col.CLASS_CODE)[" + IBusModelUInt16Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt32Col ret = new BusModelJpaUInt32Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt32Col.CLASS_CODE)[" + IBusModelUInt32Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUInt64Col ret = new BusModelJpaUInt64Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUInt64Col.CLASS_CODE)[" + IBusModelUInt64Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidCol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuidCol ret = new BusModelJpaUuidCol();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidCol.CLASS_CODE)[" + IBusModelUuidCol.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Col.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuid6Col ret = new BusModelJpaUuid6Col();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Col.CLASS_CODE)[" + IBusModelUuid6Col.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidGen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuidGen ret = new BusModelJpaUuidGen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuidGen.CLASS_CODE)[" + IBusModelUuidGen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Gen.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelUuid6Gen ret = new BusModelJpaUuid6Gen();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelUuid6Gen.CLASS_CODE)[" + IBusModelUuid6Gen.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelRoleDef.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelRoleDef ret = new BusModelJpaRoleDef();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelRoleDef.CLASS_CODE)[" + IBusModelRoleDef.CLASS_CODE + "]");
		}
	
		entry = IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					IBusModelSchemaRole ret = new BusModelJpaSchemaRole();
					return(ret);
				}
			});
		}
		else {
			throw new YCFNullArgumentException(BusModelJpaSchema.class, "wireRecConstructors", 0, "IBusModelSchema.getClassMapByBackingClassCode(IBusModelSchemaRole.CLASS_CODE)[" + IBusModelSchemaRole.CLASS_CODE + "]");
		}
	
	}

	@Override
	public void wireTableTableInstances() {
		if (tableScope == null || !(tableScope instanceof BusModelJpaScopeTable)) {
			tableScope = new BusModelJpaScopeTable(this);
		}
		if (tableSchemaDef == null || !(tableSchemaDef instanceof BusModelJpaSchemaDefTable)) {
			tableSchemaDef = new BusModelJpaSchemaDefTable(this);
		}
		if (tableSchemaRef == null || !(tableSchemaRef instanceof BusModelJpaSchemaRefTable)) {
			tableSchemaRef = new BusModelJpaSchemaRefTable(this);
		}
		if (tableServerMethod == null || !(tableServerMethod instanceof BusModelJpaServerMethodTable)) {
			tableServerMethod = new BusModelJpaServerMethodTable(this);
		}
		if (tableServerObjFunc == null || !(tableServerObjFunc instanceof BusModelJpaServerObjFuncTable)) {
			tableServerObjFunc = new BusModelJpaServerObjFuncTable(this);
		}
		if (tableServerProc == null || !(tableServerProc instanceof BusModelJpaServerProcTable)) {
			tableServerProc = new BusModelJpaServerProcTable(this);
		}
		if (tableTable == null || !(tableTable instanceof BusModelJpaTableTable)) {
			tableTable = new BusModelJpaTableTable(this);
		}
		if (tableTweak == null || !(tableTweak instanceof BusModelJpaTweakTable)) {
			tableTweak = new BusModelJpaTweakTable(this);
		}
		if (tableTableTweak == null || !(tableTableTweak instanceof BusModelJpaTableTweakTable)) {
			tableTableTweak = new BusModelJpaTableTweakTable(this);
		}
		if (tableSchemaTweak == null || !(tableSchemaTweak instanceof BusModelJpaSchemaTweakTable)) {
			tableSchemaTweak = new BusModelJpaSchemaTweakTable(this);
		}
		if (tableIndexTweak == null || !(tableIndexTweak instanceof BusModelJpaIndexTweakTable)) {
			tableIndexTweak = new BusModelJpaIndexTweakTable(this);
		}
		if (tableValue == null || !(tableValue instanceof BusModelJpaValueTable)) {
			tableValue = new BusModelJpaValueTable(this);
		}
		if (tableAtom == null || !(tableAtom instanceof BusModelJpaAtomTable)) {
			tableAtom = new BusModelJpaAtomTable(this);
		}
		if (tableBlobDef == null || !(tableBlobDef instanceof BusModelJpaBlobDefTable)) {
			tableBlobDef = new BusModelJpaBlobDefTable(this);
		}
		if (tableBlobType == null || !(tableBlobType instanceof BusModelJpaBlobTypeTable)) {
			tableBlobType = new BusModelJpaBlobTypeTable(this);
		}
		if (tableBoolDef == null || !(tableBoolDef instanceof BusModelJpaBoolDefTable)) {
			tableBoolDef = new BusModelJpaBoolDefTable(this);
		}
		if (tableBoolType == null || !(tableBoolType instanceof BusModelJpaBoolTypeTable)) {
			tableBoolType = new BusModelJpaBoolTypeTable(this);
		}
		if (tableChain == null || !(tableChain instanceof BusModelJpaChainTable)) {
			tableChain = new BusModelJpaChainTable(this);
		}
		if (tableClearDep == null || !(tableClearDep instanceof BusModelJpaClearDepTable)) {
			tableClearDep = new BusModelJpaClearDepTable(this);
		}
		if (tableClearSubDep1 == null || !(tableClearSubDep1 instanceof BusModelJpaClearSubDep1Table)) {
			tableClearSubDep1 = new BusModelJpaClearSubDep1Table(this);
		}
		if (tableClearSubDep2 == null || !(tableClearSubDep2 instanceof BusModelJpaClearSubDep2Table)) {
			tableClearSubDep2 = new BusModelJpaClearSubDep2Table(this);
		}
		if (tableClearSubDep3 == null || !(tableClearSubDep3 instanceof BusModelJpaClearSubDep3Table)) {
			tableClearSubDep3 = new BusModelJpaClearSubDep3Table(this);
		}
		if (tableClearTopDep == null || !(tableClearTopDep instanceof BusModelJpaClearTopDepTable)) {
			tableClearTopDep = new BusModelJpaClearTopDepTable(this);
		}
		if (tableDateDef == null || !(tableDateDef instanceof BusModelJpaDateDefTable)) {
			tableDateDef = new BusModelJpaDateDefTable(this);
		}
		if (tableDateType == null || !(tableDateType instanceof BusModelJpaDateTypeTable)) {
			tableDateType = new BusModelJpaDateTypeTable(this);
		}
		if (tableDelDep == null || !(tableDelDep instanceof BusModelJpaDelDepTable)) {
			tableDelDep = new BusModelJpaDelDepTable(this);
		}
		if (tableDelSubDep1 == null || !(tableDelSubDep1 instanceof BusModelJpaDelSubDep1Table)) {
			tableDelSubDep1 = new BusModelJpaDelSubDep1Table(this);
		}
		if (tableDelSubDep2 == null || !(tableDelSubDep2 instanceof BusModelJpaDelSubDep2Table)) {
			tableDelSubDep2 = new BusModelJpaDelSubDep2Table(this);
		}
		if (tableDelSubDep3 == null || !(tableDelSubDep3 instanceof BusModelJpaDelSubDep3Table)) {
			tableDelSubDep3 = new BusModelJpaDelSubDep3Table(this);
		}
		if (tableDelTopDep == null || !(tableDelTopDep instanceof BusModelJpaDelTopDepTable)) {
			tableDelTopDep = new BusModelJpaDelTopDepTable(this);
		}
		if (tableDoubleDef == null || !(tableDoubleDef instanceof BusModelJpaDoubleDefTable)) {
			tableDoubleDef = new BusModelJpaDoubleDefTable(this);
		}
		if (tableDoubleType == null || !(tableDoubleType instanceof BusModelJpaDoubleTypeTable)) {
			tableDoubleType = new BusModelJpaDoubleTypeTable(this);
		}
		if (tableEnumTag == null || !(tableEnumTag instanceof BusModelJpaEnumTagTable)) {
			tableEnumTag = new BusModelJpaEnumTagTable(this);
		}
		if (tableFloatDef == null || !(tableFloatDef instanceof BusModelJpaFloatDefTable)) {
			tableFloatDef = new BusModelJpaFloatDefTable(this);
		}
		if (tableFloatType == null || !(tableFloatType instanceof BusModelJpaFloatTypeTable)) {
			tableFloatType = new BusModelJpaFloatTypeTable(this);
		}
		if (tableIndex == null || !(tableIndex instanceof BusModelJpaIndexTable)) {
			tableIndex = new BusModelJpaIndexTable(this);
		}
		if (tableIndexCol == null || !(tableIndexCol instanceof BusModelJpaIndexColTable)) {
			tableIndexCol = new BusModelJpaIndexColTable(this);
		}
		if (tableInt16Def == null || !(tableInt16Def instanceof BusModelJpaInt16DefTable)) {
			tableInt16Def = new BusModelJpaInt16DefTable(this);
		}
		if (tableInt16Type == null || !(tableInt16Type instanceof BusModelJpaInt16TypeTable)) {
			tableInt16Type = new BusModelJpaInt16TypeTable(this);
		}
		if (tableInt32Def == null || !(tableInt32Def instanceof BusModelJpaInt32DefTable)) {
			tableInt32Def = new BusModelJpaInt32DefTable(this);
		}
		if (tableInt32Type == null || !(tableInt32Type instanceof BusModelJpaInt32TypeTable)) {
			tableInt32Type = new BusModelJpaInt32TypeTable(this);
		}
		if (tableInt64Def == null || !(tableInt64Def instanceof BusModelJpaInt64DefTable)) {
			tableInt64Def = new BusModelJpaInt64DefTable(this);
		}
		if (tableInt64Type == null || !(tableInt64Type instanceof BusModelJpaInt64TypeTable)) {
			tableInt64Type = new BusModelJpaInt64TypeTable(this);
		}
		if (tableNmTokenDef == null || !(tableNmTokenDef instanceof BusModelJpaNmTokenDefTable)) {
			tableNmTokenDef = new BusModelJpaNmTokenDefTable(this);
		}
		if (tableNmTokenType == null || !(tableNmTokenType instanceof BusModelJpaNmTokenTypeTable)) {
			tableNmTokenType = new BusModelJpaNmTokenTypeTable(this);
		}
		if (tableNmTokensDef == null || !(tableNmTokensDef instanceof BusModelJpaNmTokensDefTable)) {
			tableNmTokensDef = new BusModelJpaNmTokensDefTable(this);
		}
		if (tableNmTokensType == null || !(tableNmTokensType instanceof BusModelJpaNmTokensTypeTable)) {
			tableNmTokensType = new BusModelJpaNmTokensTypeTable(this);
		}
		if (tableNumberDef == null || !(tableNumberDef instanceof BusModelJpaNumberDefTable)) {
			tableNumberDef = new BusModelJpaNumberDefTable(this);
		}
		if (tableNumberType == null || !(tableNumberType instanceof BusModelJpaNumberTypeTable)) {
			tableNumberType = new BusModelJpaNumberTypeTable(this);
		}
		if (tableParam == null || !(tableParam instanceof BusModelJpaParamTable)) {
			tableParam = new BusModelJpaParamTable(this);
		}
		if (tablePopDep == null || !(tablePopDep instanceof BusModelJpaPopDepTable)) {
			tablePopDep = new BusModelJpaPopDepTable(this);
		}
		if (tablePopSubDep1 == null || !(tablePopSubDep1 instanceof BusModelJpaPopSubDep1Table)) {
			tablePopSubDep1 = new BusModelJpaPopSubDep1Table(this);
		}
		if (tablePopSubDep2 == null || !(tablePopSubDep2 instanceof BusModelJpaPopSubDep2Table)) {
			tablePopSubDep2 = new BusModelJpaPopSubDep2Table(this);
		}
		if (tablePopSubDep3 == null || !(tablePopSubDep3 instanceof BusModelJpaPopSubDep3Table)) {
			tablePopSubDep3 = new BusModelJpaPopSubDep3Table(this);
		}
		if (tablePopTopDep == null || !(tablePopTopDep instanceof BusModelJpaPopTopDepTable)) {
			tablePopTopDep = new BusModelJpaPopTopDepTable(this);
		}
		if (tableRelation == null || !(tableRelation instanceof BusModelJpaRelationTable)) {
			tableRelation = new BusModelJpaRelationTable(this);
		}
		if (tableRelationCol == null || !(tableRelationCol instanceof BusModelJpaRelationColTable)) {
			tableRelationCol = new BusModelJpaRelationColTable(this);
		}
		if (tableServerListFunc == null || !(tableServerListFunc instanceof BusModelJpaServerListFuncTable)) {
			tableServerListFunc = new BusModelJpaServerListFuncTable(this);
		}
		if (tableDbKeyHash128Def == null || !(tableDbKeyHash128Def instanceof BusModelJpaDbKeyHash128DefTable)) {
			tableDbKeyHash128Def = new BusModelJpaDbKeyHash128DefTable(this);
		}
		if (tableDbKeyHash128Col == null || !(tableDbKeyHash128Col instanceof BusModelJpaDbKeyHash128ColTable)) {
			tableDbKeyHash128Col = new BusModelJpaDbKeyHash128ColTable(this);
		}
		if (tableDbKeyHash128Type == null || !(tableDbKeyHash128Type instanceof BusModelJpaDbKeyHash128TypeTable)) {
			tableDbKeyHash128Type = new BusModelJpaDbKeyHash128TypeTable(this);
		}
		if (tableDbKeyHash128Gen == null || !(tableDbKeyHash128Gen instanceof BusModelJpaDbKeyHash128GenTable)) {
			tableDbKeyHash128Gen = new BusModelJpaDbKeyHash128GenTable(this);
		}
		if (tableDbKeyHash160Def == null || !(tableDbKeyHash160Def instanceof BusModelJpaDbKeyHash160DefTable)) {
			tableDbKeyHash160Def = new BusModelJpaDbKeyHash160DefTable(this);
		}
		if (tableDbKeyHash160Col == null || !(tableDbKeyHash160Col instanceof BusModelJpaDbKeyHash160ColTable)) {
			tableDbKeyHash160Col = new BusModelJpaDbKeyHash160ColTable(this);
		}
		if (tableDbKeyHash160Type == null || !(tableDbKeyHash160Type instanceof BusModelJpaDbKeyHash160TypeTable)) {
			tableDbKeyHash160Type = new BusModelJpaDbKeyHash160TypeTable(this);
		}
		if (tableDbKeyHash160Gen == null || !(tableDbKeyHash160Gen instanceof BusModelJpaDbKeyHash160GenTable)) {
			tableDbKeyHash160Gen = new BusModelJpaDbKeyHash160GenTable(this);
		}
		if (tableDbKeyHash224Def == null || !(tableDbKeyHash224Def instanceof BusModelJpaDbKeyHash224DefTable)) {
			tableDbKeyHash224Def = new BusModelJpaDbKeyHash224DefTable(this);
		}
		if (tableDbKeyHash224Col == null || !(tableDbKeyHash224Col instanceof BusModelJpaDbKeyHash224ColTable)) {
			tableDbKeyHash224Col = new BusModelJpaDbKeyHash224ColTable(this);
		}
		if (tableDbKeyHash224Type == null || !(tableDbKeyHash224Type instanceof BusModelJpaDbKeyHash224TypeTable)) {
			tableDbKeyHash224Type = new BusModelJpaDbKeyHash224TypeTable(this);
		}
		if (tableDbKeyHash224Gen == null || !(tableDbKeyHash224Gen instanceof BusModelJpaDbKeyHash224GenTable)) {
			tableDbKeyHash224Gen = new BusModelJpaDbKeyHash224GenTable(this);
		}
		if (tableDbKeyHash256Def == null || !(tableDbKeyHash256Def instanceof BusModelJpaDbKeyHash256DefTable)) {
			tableDbKeyHash256Def = new BusModelJpaDbKeyHash256DefTable(this);
		}
		if (tableDbKeyHash256Col == null || !(tableDbKeyHash256Col instanceof BusModelJpaDbKeyHash256ColTable)) {
			tableDbKeyHash256Col = new BusModelJpaDbKeyHash256ColTable(this);
		}
		if (tableDbKeyHash256Type == null || !(tableDbKeyHash256Type instanceof BusModelJpaDbKeyHash256TypeTable)) {
			tableDbKeyHash256Type = new BusModelJpaDbKeyHash256TypeTable(this);
		}
		if (tableDbKeyHash256Gen == null || !(tableDbKeyHash256Gen instanceof BusModelJpaDbKeyHash256GenTable)) {
			tableDbKeyHash256Gen = new BusModelJpaDbKeyHash256GenTable(this);
		}
		if (tableDbKeyHash384Def == null || !(tableDbKeyHash384Def instanceof BusModelJpaDbKeyHash384DefTable)) {
			tableDbKeyHash384Def = new BusModelJpaDbKeyHash384DefTable(this);
		}
		if (tableDbKeyHash384Col == null || !(tableDbKeyHash384Col instanceof BusModelJpaDbKeyHash384ColTable)) {
			tableDbKeyHash384Col = new BusModelJpaDbKeyHash384ColTable(this);
		}
		if (tableDbKeyHash384Type == null || !(tableDbKeyHash384Type instanceof BusModelJpaDbKeyHash384TypeTable)) {
			tableDbKeyHash384Type = new BusModelJpaDbKeyHash384TypeTable(this);
		}
		if (tableDbKeyHash384Gen == null || !(tableDbKeyHash384Gen instanceof BusModelJpaDbKeyHash384GenTable)) {
			tableDbKeyHash384Gen = new BusModelJpaDbKeyHash384GenTable(this);
		}
		if (tableDbKeyHash512Def == null || !(tableDbKeyHash512Def instanceof BusModelJpaDbKeyHash512DefTable)) {
			tableDbKeyHash512Def = new BusModelJpaDbKeyHash512DefTable(this);
		}
		if (tableDbKeyHash512Col == null || !(tableDbKeyHash512Col instanceof BusModelJpaDbKeyHash512ColTable)) {
			tableDbKeyHash512Col = new BusModelJpaDbKeyHash512ColTable(this);
		}
		if (tableDbKeyHash512Type == null || !(tableDbKeyHash512Type instanceof BusModelJpaDbKeyHash512TypeTable)) {
			tableDbKeyHash512Type = new BusModelJpaDbKeyHash512TypeTable(this);
		}
		if (tableDbKeyHash512Gen == null || !(tableDbKeyHash512Gen instanceof BusModelJpaDbKeyHash512GenTable)) {
			tableDbKeyHash512Gen = new BusModelJpaDbKeyHash512GenTable(this);
		}
		if (tableStringDef == null || !(tableStringDef instanceof BusModelJpaStringDefTable)) {
			tableStringDef = new BusModelJpaStringDefTable(this);
		}
		if (tableStringType == null || !(tableStringType instanceof BusModelJpaStringTypeTable)) {
			tableStringType = new BusModelJpaStringTypeTable(this);
		}
		if (tableTZDateDef == null || !(tableTZDateDef instanceof BusModelJpaTZDateDefTable)) {
			tableTZDateDef = new BusModelJpaTZDateDefTable(this);
		}
		if (tableTZDateType == null || !(tableTZDateType instanceof BusModelJpaTZDateTypeTable)) {
			tableTZDateType = new BusModelJpaTZDateTypeTable(this);
		}
		if (tableTZTimeDef == null || !(tableTZTimeDef instanceof BusModelJpaTZTimeDefTable)) {
			tableTZTimeDef = new BusModelJpaTZTimeDefTable(this);
		}
		if (tableTZTimeType == null || !(tableTZTimeType instanceof BusModelJpaTZTimeTypeTable)) {
			tableTZTimeType = new BusModelJpaTZTimeTypeTable(this);
		}
		if (tableTZTimestampDef == null || !(tableTZTimestampDef instanceof BusModelJpaTZTimestampDefTable)) {
			tableTZTimestampDef = new BusModelJpaTZTimestampDefTable(this);
		}
		if (tableTZTimestampType == null || !(tableTZTimestampType instanceof BusModelJpaTZTimestampTypeTable)) {
			tableTZTimestampType = new BusModelJpaTZTimestampTypeTable(this);
		}
		if (tableTableCol == null || !(tableTableCol instanceof BusModelJpaTableColTable)) {
			tableTableCol = new BusModelJpaTableColTable(this);
		}
		if (tableTextDef == null || !(tableTextDef instanceof BusModelJpaTextDefTable)) {
			tableTextDef = new BusModelJpaTextDefTable(this);
		}
		if (tableTextType == null || !(tableTextType instanceof BusModelJpaTextTypeTable)) {
			tableTextType = new BusModelJpaTextTypeTable(this);
		}
		if (tableTimeDef == null || !(tableTimeDef instanceof BusModelJpaTimeDefTable)) {
			tableTimeDef = new BusModelJpaTimeDefTable(this);
		}
		if (tableTimeType == null || !(tableTimeType instanceof BusModelJpaTimeTypeTable)) {
			tableTimeType = new BusModelJpaTimeTypeTable(this);
		}
		if (tableTimestampDef == null || !(tableTimestampDef instanceof BusModelJpaTimestampDefTable)) {
			tableTimestampDef = new BusModelJpaTimestampDefTable(this);
		}
		if (tableTimestampType == null || !(tableTimestampType instanceof BusModelJpaTimestampTypeTable)) {
			tableTimestampType = new BusModelJpaTimestampTypeTable(this);
		}
		if (tableTokenDef == null || !(tableTokenDef instanceof BusModelJpaTokenDefTable)) {
			tableTokenDef = new BusModelJpaTokenDefTable(this);
		}
		if (tableTokenType == null || !(tableTokenType instanceof BusModelJpaTokenTypeTable)) {
			tableTokenType = new BusModelJpaTokenTypeTable(this);
		}
		if (tableUInt16Def == null || !(tableUInt16Def instanceof BusModelJpaUInt16DefTable)) {
			tableUInt16Def = new BusModelJpaUInt16DefTable(this);
		}
		if (tableUInt16Type == null || !(tableUInt16Type instanceof BusModelJpaUInt16TypeTable)) {
			tableUInt16Type = new BusModelJpaUInt16TypeTable(this);
		}
		if (tableUInt32Def == null || !(tableUInt32Def instanceof BusModelJpaUInt32DefTable)) {
			tableUInt32Def = new BusModelJpaUInt32DefTable(this);
		}
		if (tableUInt32Type == null || !(tableUInt32Type instanceof BusModelJpaUInt32TypeTable)) {
			tableUInt32Type = new BusModelJpaUInt32TypeTable(this);
		}
		if (tableUInt64Def == null || !(tableUInt64Def instanceof BusModelJpaUInt64DefTable)) {
			tableUInt64Def = new BusModelJpaUInt64DefTable(this);
		}
		if (tableUInt64Type == null || !(tableUInt64Type instanceof BusModelJpaUInt64TypeTable)) {
			tableUInt64Type = new BusModelJpaUInt64TypeTable(this);
		}
		if (tableUuidDef == null || !(tableUuidDef instanceof BusModelJpaUuidDefTable)) {
			tableUuidDef = new BusModelJpaUuidDefTable(this);
		}
		if (tableUuid6Def == null || !(tableUuid6Def instanceof BusModelJpaUuid6DefTable)) {
			tableUuid6Def = new BusModelJpaUuid6DefTable(this);
		}
		if (tableUuidType == null || !(tableUuidType instanceof BusModelJpaUuidTypeTable)) {
			tableUuidType = new BusModelJpaUuidTypeTable(this);
		}
		if (tableUuid6Type == null || !(tableUuid6Type instanceof BusModelJpaUuid6TypeTable)) {
			tableUuid6Type = new BusModelJpaUuid6TypeTable(this);
		}
		if (tableBlobCol == null || !(tableBlobCol instanceof BusModelJpaBlobColTable)) {
			tableBlobCol = new BusModelJpaBlobColTable(this);
		}
		if (tableBoolCol == null || !(tableBoolCol instanceof BusModelJpaBoolColTable)) {
			tableBoolCol = new BusModelJpaBoolColTable(this);
		}
		if (tableDateCol == null || !(tableDateCol instanceof BusModelJpaDateColTable)) {
			tableDateCol = new BusModelJpaDateColTable(this);
		}
		if (tableDoubleCol == null || !(tableDoubleCol instanceof BusModelJpaDoubleColTable)) {
			tableDoubleCol = new BusModelJpaDoubleColTable(this);
		}
		if (tableEnumDef == null || !(tableEnumDef instanceof BusModelJpaEnumDefTable)) {
			tableEnumDef = new BusModelJpaEnumDefTable(this);
		}
		if (tableEnumType == null || !(tableEnumType instanceof BusModelJpaEnumTypeTable)) {
			tableEnumType = new BusModelJpaEnumTypeTable(this);
		}
		if (tableFloatCol == null || !(tableFloatCol instanceof BusModelJpaFloatColTable)) {
			tableFloatCol = new BusModelJpaFloatColTable(this);
		}
		if (tableId16Gen == null || !(tableId16Gen instanceof BusModelJpaId16GenTable)) {
			tableId16Gen = new BusModelJpaId16GenTable(this);
		}
		if (tableId32Gen == null || !(tableId32Gen instanceof BusModelJpaId32GenTable)) {
			tableId32Gen = new BusModelJpaId32GenTable(this);
		}
		if (tableId64Gen == null || !(tableId64Gen instanceof BusModelJpaId64GenTable)) {
			tableId64Gen = new BusModelJpaId64GenTable(this);
		}
		if (tableInt16Col == null || !(tableInt16Col instanceof BusModelJpaInt16ColTable)) {
			tableInt16Col = new BusModelJpaInt16ColTable(this);
		}
		if (tableInt32Col == null || !(tableInt32Col instanceof BusModelJpaInt32ColTable)) {
			tableInt32Col = new BusModelJpaInt32ColTable(this);
		}
		if (tableInt64Col == null || !(tableInt64Col instanceof BusModelJpaInt64ColTable)) {
			tableInt64Col = new BusModelJpaInt64ColTable(this);
		}
		if (tableNmTokenCol == null || !(tableNmTokenCol instanceof BusModelJpaNmTokenColTable)) {
			tableNmTokenCol = new BusModelJpaNmTokenColTable(this);
		}
		if (tableNmTokensCol == null || !(tableNmTokensCol instanceof BusModelJpaNmTokensColTable)) {
			tableNmTokensCol = new BusModelJpaNmTokensColTable(this);
		}
		if (tableNumberCol == null || !(tableNumberCol instanceof BusModelJpaNumberColTable)) {
			tableNumberCol = new BusModelJpaNumberColTable(this);
		}
		if (tableStringCol == null || !(tableStringCol instanceof BusModelJpaStringColTable)) {
			tableStringCol = new BusModelJpaStringColTable(this);
		}
		if (tableTZDateCol == null || !(tableTZDateCol instanceof BusModelJpaTZDateColTable)) {
			tableTZDateCol = new BusModelJpaTZDateColTable(this);
		}
		if (tableTZTimeCol == null || !(tableTZTimeCol instanceof BusModelJpaTZTimeColTable)) {
			tableTZTimeCol = new BusModelJpaTZTimeColTable(this);
		}
		if (tableTZTimestampCol == null || !(tableTZTimestampCol instanceof BusModelJpaTZTimestampColTable)) {
			tableTZTimestampCol = new BusModelJpaTZTimestampColTable(this);
		}
		if (tableTextCol == null || !(tableTextCol instanceof BusModelJpaTextColTable)) {
			tableTextCol = new BusModelJpaTextColTable(this);
		}
		if (tableTimeCol == null || !(tableTimeCol instanceof BusModelJpaTimeColTable)) {
			tableTimeCol = new BusModelJpaTimeColTable(this);
		}
		if (tableTimestampCol == null || !(tableTimestampCol instanceof BusModelJpaTimestampColTable)) {
			tableTimestampCol = new BusModelJpaTimestampColTable(this);
		}
		if (tableTokenCol == null || !(tableTokenCol instanceof BusModelJpaTokenColTable)) {
			tableTokenCol = new BusModelJpaTokenColTable(this);
		}
		if (tableUInt16Col == null || !(tableUInt16Col instanceof BusModelJpaUInt16ColTable)) {
			tableUInt16Col = new BusModelJpaUInt16ColTable(this);
		}
		if (tableUInt32Col == null || !(tableUInt32Col instanceof BusModelJpaUInt32ColTable)) {
			tableUInt32Col = new BusModelJpaUInt32ColTable(this);
		}
		if (tableUInt64Col == null || !(tableUInt64Col instanceof BusModelJpaUInt64ColTable)) {
			tableUInt64Col = new BusModelJpaUInt64ColTable(this);
		}
		if (tableUuidCol == null || !(tableUuidCol instanceof BusModelJpaUuidColTable)) {
			tableUuidCol = new BusModelJpaUuidColTable(this);
		}
		if (tableUuid6Col == null || !(tableUuid6Col instanceof BusModelJpaUuid6ColTable)) {
			tableUuid6Col = new BusModelJpaUuid6ColTable(this);
		}
		if (tableUuidGen == null || !(tableUuidGen instanceof BusModelJpaUuidGenTable)) {
			tableUuidGen = new BusModelJpaUuidGenTable(this);
		}
		if (tableUuid6Gen == null || !(tableUuid6Gen instanceof BusModelJpaUuid6GenTable)) {
			tableUuid6Gen = new BusModelJpaUuid6GenTable(this);
		}
		if (tableRoleDef == null || !(tableRoleDef instanceof BusModelJpaRoleDefTable)) {
			tableRoleDef = new BusModelJpaRoleDefTable(this);
		}
		if (tableSchemaRole == null || !(tableSchemaRole instanceof BusModelJpaSchemaRoleTable)) {
			tableSchemaRole = new BusModelJpaSchemaRoleTable(this);
		}
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

	public static BusModelJpaHooksSchema getJpaHooksSchema() {
		return( busmodelJpaHooksSchema );
	}

	public static void setJpaHooksSchema(BusModelJpaHooksSchema jpaHooksSchema) {
		busmodelJpaHooksSchema = jpaHooksSchema;
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
		return(SecureBuffSchema.getBuffHooksSchema().getFactoryService());
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
		return(IntNetBuffSchema.getBuffHooksSchema().getFactoryService());
	}

	@Override
	public IBusModelFactory getBusModelFactory() {
		return(BusModelJpaSchema.getJpaHooksSchema().getFactoryService());
	}

	@Override
	public BusModelBuffFactoryService getBusModelBuffFactory() {
		return((BusModelBuffFactoryService)(BusModelBuffSchema.getBuffHooksSchema().getFactoryService()));
	}

	public BusModelJpaSchemaService getSchemaService() {
		return( BusModelJpaSchema.getJpaHooksSchema().getSchemaService() );
	}

	public BusModelJpaSchema() {

		tableAtom = null;
		tableBlobCol = null;
		tableBlobDef = null;
		tableBlobType = null;
		tableBoolCol = null;
		tableBoolDef = null;
		tableBoolType = null;
		tableChain = null;
		tableClearDep = null;
		tableClearSubDep1 = null;
		tableClearSubDep2 = null;
		tableClearSubDep3 = null;
		tableClearTopDep = null;
		tableCluster = null;
		tableDateCol = null;
		tableDateDef = null;
		tableDateType = null;
		tableDbKeyHash128Col = null;
		tableDbKeyHash128Def = null;
		tableDbKeyHash128Gen = null;
		tableDbKeyHash128Type = null;
		tableDbKeyHash160Col = null;
		tableDbKeyHash160Def = null;
		tableDbKeyHash160Gen = null;
		tableDbKeyHash160Type = null;
		tableDbKeyHash224Col = null;
		tableDbKeyHash224Def = null;
		tableDbKeyHash224Gen = null;
		tableDbKeyHash224Type = null;
		tableDbKeyHash256Col = null;
		tableDbKeyHash256Def = null;
		tableDbKeyHash256Gen = null;
		tableDbKeyHash256Type = null;
		tableDbKeyHash384Col = null;
		tableDbKeyHash384Def = null;
		tableDbKeyHash384Gen = null;
		tableDbKeyHash384Type = null;
		tableDbKeyHash512Col = null;
		tableDbKeyHash512Def = null;
		tableDbKeyHash512Gen = null;
		tableDbKeyHash512Type = null;
		tableDelDep = null;
		tableDelSubDep1 = null;
		tableDelSubDep2 = null;
		tableDelSubDep3 = null;
		tableDelTopDep = null;
		tableDoubleCol = null;
		tableDoubleDef = null;
		tableDoubleType = null;
		tableEnumDef = null;
		tableEnumTag = null;
		tableEnumType = null;
		tableFloatCol = null;
		tableFloatDef = null;
		tableFloatType = null;
		tableISOCcy = null;
		tableISOCtry = null;
		tableISOCtryCcy = null;
		tableISOCtryLang = null;
		tableISOLang = null;
		tableISOTZone = null;
		tableId16Gen = null;
		tableId32Gen = null;
		tableId64Gen = null;
		tableIndex = null;
		tableIndexCol = null;
		tableIndexTweak = null;
		tableInt16Col = null;
		tableInt16Def = null;
		tableInt16Type = null;
		tableInt32Col = null;
		tableInt32Def = null;
		tableInt32Type = null;
		tableInt64Col = null;
		tableInt64Def = null;
		tableInt64Type = null;
		tableLicense = null;
		tableMajorVersion = null;
		tableMimeType = null;
		tableMinorVersion = null;
		tableNmTokenCol = null;
		tableNmTokenDef = null;
		tableNmTokenType = null;
		tableNmTokensCol = null;
		tableNmTokensDef = null;
		tableNmTokensType = null;
		tableNumberCol = null;
		tableNumberDef = null;
		tableNumberType = null;
		tableParam = null;
		tablePopDep = null;
		tablePopSubDep1 = null;
		tablePopSubDep2 = null;
		tablePopSubDep3 = null;
		tablePopTopDep = null;
		tableRelation = null;
		tableRelationCol = null;
		tableRoleDef = null;
		tableSchemaDef = null;
		tableSchemaRef = null;
		tableSchemaRole = null;
		tableSchemaTweak = null;
		tableScope = null;
		tableSecClusGrp = null;
		tableSecClusGrpMemb = null;
		tableSecClusRole = null;
		tableSecClusRoleMemb = null;
		tableSecSession = null;
		tableSecSysGrp = null;
		tableSecSysGrpInc = null;
		tableSecSysGrpMemb = null;
		tableSecSysRole = null;
		tableSecSysRoleEnables = null;
		tableSecSysRoleMemb = null;
		tableSecTentGrp = null;
		tableSecTentGrpMemb = null;
		tableSecTentRole = null;
		tableSecTentRoleMemb = null;
		tableSecUser = null;
		tableSecUserEMConf = null;
		tableSecUserPWHistory = null;
		tableSecUserPWReset = null;
		tableSecUserPassword = null;
		tableServerListFunc = null;
		tableServerMethod = null;
		tableServerObjFunc = null;
		tableServerProc = null;
		tableStringCol = null;
		tableStringDef = null;
		tableStringType = null;
		tableSubProject = null;
		tableSysCluster = null;
		tableTZDateCol = null;
		tableTZDateDef = null;
		tableTZDateType = null;
		tableTZTimeCol = null;
		tableTZTimeDef = null;
		tableTZTimeType = null;
		tableTZTimestampCol = null;
		tableTZTimestampDef = null;
		tableTZTimestampType = null;
		tableTable = null;
		tableTableCol = null;
		tableTableInfo = null;
		tableTableTweak = null;
		tableTenant = null;
		tableTextCol = null;
		tableTextDef = null;
		tableTextType = null;
		tableTimeCol = null;
		tableTimeDef = null;
		tableTimeType = null;
		tableTimestampCol = null;
		tableTimestampDef = null;
		tableTimestampType = null;
		tableTld = null;
		tableTokenCol = null;
		tableTokenDef = null;
		tableTokenType = null;
		tableTopDomain = null;
		tableTopProject = null;
		tableTweak = null;
		tableUInt16Col = null;
		tableUInt16Def = null;
		tableUInt16Type = null;
		tableUInt32Col = null;
		tableUInt32Def = null;
		tableUInt32Type = null;
		tableUInt64Col = null;
		tableUInt64Def = null;
		tableUInt64Type = null;
		tableURLProtocol = null;
		tableUuid6Col = null;
		tableUuid6Def = null;
		tableUuid6Gen = null;
		tableUuid6Type = null;
		tableUuidCol = null;
		tableUuidDef = null;
		tableUuidGen = null;
		tableUuidType = null;
		tableValue = null;
	}

	@Override
	public IBusModelSchema newSchema() {
		throw new YCFMustOverrideException( getClass(), "newSchema" );
	}

	@Override
	public short nextISOCcyIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOCcyIdGen" );
	}

	@Override
	public short nextISOCtryIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOCtryIdGen" );
	}

	@Override
	public short nextISOLangIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOLangIdGen" );
	}

	@Override
	public short nextISOTZoneIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextISOTZoneIdGen" );
	}

	@Override
	public int nextTableInfoIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextTableInfoIdGen" );
	}

	@Override
	public int nextMimeTypeIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextMimeTypeIdGen" );
	}

	@Override
	public int nextURLProtocolIdGen() {
		throw new YCFNotImplementedYetException( getClass(), "nextURLProtocolIdGen" );
	}

	@Override
	public YCFDbKeyHash256 nextClusterIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecSessionIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecUserIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTenantIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecSysGrpIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecClusGrpIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecClusRoleIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecTentGrpIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSecTentRoleIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextMajorVersionIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextMinorVersionIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSubProjectIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTldIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTopDomainIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTopProjectIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextLicenseIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextChainIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextEnumTagIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextIndexColIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextParamIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextRelationColIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTweakIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextScopeIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextValueIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextRoleIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
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

	public void bootstrapSchema(SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapSchema(tableData);
	}

	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapAllTablesSecurity(clusterId, tenantId, tableData);
	}
}
