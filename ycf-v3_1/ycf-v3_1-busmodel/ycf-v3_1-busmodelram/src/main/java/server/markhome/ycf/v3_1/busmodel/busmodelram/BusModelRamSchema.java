// Description: Java 25 implementation of an in-memory RAM BusModel schema.

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

package server.markhome.ycf.v3_1.busmodel.busmodelram;

import java.lang.reflect.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.buff.*;
import server.markhome.ycf.v3_1.busmodel.busmodelsaxloader.*;

import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffSchema;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffFactoryService;
import server.markhome.ycf.v3_1.intnet.intnet.buff.IntNetBuffSchema;
import server.markhome.ycf.v3_1.intnet.intnet.buff.IntNetBuffFactoryService;
//import server.markhome.ycf.v3_1.busmodel.busmodelpub.buff.BusModelPubBuffFactoryService;

public class BusModelRamSchema
	extends BusModelBuffSchema
	implements IBusModelSchema
{


	public BusModelRamSchema() {
		super();
		tableAtom = new BusModelRamAtomTable( this );
		tableBlobCol = new BusModelRamBlobColTable( this );
		tableBlobDef = new BusModelRamBlobDefTable( this );
		tableBlobType = new BusModelRamBlobTypeTable( this );
		tableBoolCol = new BusModelRamBoolColTable( this );
		tableBoolDef = new BusModelRamBoolDefTable( this );
		tableBoolType = new BusModelRamBoolTypeTable( this );
		tableChain = new BusModelRamChainTable( this );
		tableClearDep = new BusModelRamClearDepTable( this );
		tableClearSubDep1 = new BusModelRamClearSubDep1Table( this );
		tableClearSubDep2 = new BusModelRamClearSubDep2Table( this );
		tableClearSubDep3 = new BusModelRamClearSubDep3Table( this );
		tableClearTopDep = new BusModelRamClearTopDepTable( this );
		tableDateCol = new BusModelRamDateColTable( this );
		tableDateDef = new BusModelRamDateDefTable( this );
		tableDateType = new BusModelRamDateTypeTable( this );
		tableDbKeyHash128Col = new BusModelRamDbKeyHash128ColTable( this );
		tableDbKeyHash128Def = new BusModelRamDbKeyHash128DefTable( this );
		tableDbKeyHash128Gen = new BusModelRamDbKeyHash128GenTable( this );
		tableDbKeyHash128Type = new BusModelRamDbKeyHash128TypeTable( this );
		tableDbKeyHash160Col = new BusModelRamDbKeyHash160ColTable( this );
		tableDbKeyHash160Def = new BusModelRamDbKeyHash160DefTable( this );
		tableDbKeyHash160Gen = new BusModelRamDbKeyHash160GenTable( this );
		tableDbKeyHash160Type = new BusModelRamDbKeyHash160TypeTable( this );
		tableDbKeyHash224Col = new BusModelRamDbKeyHash224ColTable( this );
		tableDbKeyHash224Def = new BusModelRamDbKeyHash224DefTable( this );
		tableDbKeyHash224Gen = new BusModelRamDbKeyHash224GenTable( this );
		tableDbKeyHash224Type = new BusModelRamDbKeyHash224TypeTable( this );
		tableDbKeyHash256Col = new BusModelRamDbKeyHash256ColTable( this );
		tableDbKeyHash256Def = new BusModelRamDbKeyHash256DefTable( this );
		tableDbKeyHash256Gen = new BusModelRamDbKeyHash256GenTable( this );
		tableDbKeyHash256Type = new BusModelRamDbKeyHash256TypeTable( this );
		tableDbKeyHash384Col = new BusModelRamDbKeyHash384ColTable( this );
		tableDbKeyHash384Def = new BusModelRamDbKeyHash384DefTable( this );
		tableDbKeyHash384Gen = new BusModelRamDbKeyHash384GenTable( this );
		tableDbKeyHash384Type = new BusModelRamDbKeyHash384TypeTable( this );
		tableDbKeyHash512Col = new BusModelRamDbKeyHash512ColTable( this );
		tableDbKeyHash512Def = new BusModelRamDbKeyHash512DefTable( this );
		tableDbKeyHash512Gen = new BusModelRamDbKeyHash512GenTable( this );
		tableDbKeyHash512Type = new BusModelRamDbKeyHash512TypeTable( this );
		tableDelDep = new BusModelRamDelDepTable( this );
		tableDelSubDep1 = new BusModelRamDelSubDep1Table( this );
		tableDelSubDep2 = new BusModelRamDelSubDep2Table( this );
		tableDelSubDep3 = new BusModelRamDelSubDep3Table( this );
		tableDelTopDep = new BusModelRamDelTopDepTable( this );
		tableDoubleCol = new BusModelRamDoubleColTable( this );
		tableDoubleDef = new BusModelRamDoubleDefTable( this );
		tableDoubleType = new BusModelRamDoubleTypeTable( this );
		tableEnumDef = new BusModelRamEnumDefTable( this );
		tableEnumTag = new BusModelRamEnumTagTable( this );
		tableEnumType = new BusModelRamEnumTypeTable( this );
		tableFloatCol = new BusModelRamFloatColTable( this );
		tableFloatDef = new BusModelRamFloatDefTable( this );
		tableFloatType = new BusModelRamFloatTypeTable( this );
		tableId16Gen = new BusModelRamId16GenTable( this );
		tableId32Gen = new BusModelRamId32GenTable( this );
		tableId64Gen = new BusModelRamId64GenTable( this );
		tableIndex = new BusModelRamIndexTable( this );
		tableIndexCol = new BusModelRamIndexColTable( this );
		tableIndexTweak = new BusModelRamIndexTweakTable( this );
		tableInt16Col = new BusModelRamInt16ColTable( this );
		tableInt16Def = new BusModelRamInt16DefTable( this );
		tableInt16Type = new BusModelRamInt16TypeTable( this );
		tableInt32Col = new BusModelRamInt32ColTable( this );
		tableInt32Def = new BusModelRamInt32DefTable( this );
		tableInt32Type = new BusModelRamInt32TypeTable( this );
		tableInt64Col = new BusModelRamInt64ColTable( this );
		tableInt64Def = new BusModelRamInt64DefTable( this );
		tableInt64Type = new BusModelRamInt64TypeTable( this );
		tableNmTokenCol = new BusModelRamNmTokenColTable( this );
		tableNmTokenDef = new BusModelRamNmTokenDefTable( this );
		tableNmTokenType = new BusModelRamNmTokenTypeTable( this );
		tableNmTokensCol = new BusModelRamNmTokensColTable( this );
		tableNmTokensDef = new BusModelRamNmTokensDefTable( this );
		tableNmTokensType = new BusModelRamNmTokensTypeTable( this );
		tableNumberCol = new BusModelRamNumberColTable( this );
		tableNumberDef = new BusModelRamNumberDefTable( this );
		tableNumberType = new BusModelRamNumberTypeTable( this );
		tableParam = new BusModelRamParamTable( this );
		tablePopDep = new BusModelRamPopDepTable( this );
		tablePopSubDep1 = new BusModelRamPopSubDep1Table( this );
		tablePopSubDep2 = new BusModelRamPopSubDep2Table( this );
		tablePopSubDep3 = new BusModelRamPopSubDep3Table( this );
		tablePopTopDep = new BusModelRamPopTopDepTable( this );
		tableRelation = new BusModelRamRelationTable( this );
		tableRelationCol = new BusModelRamRelationColTable( this );
		tableRoleDef = new BusModelRamRoleDefTable( this );
		tableSchemaDef = new BusModelRamSchemaDefTable( this );
		tableSchemaRef = new BusModelRamSchemaRefTable( this );
		tableSchemaRole = new BusModelRamSchemaRoleTable( this );
		tableSchemaTweak = new BusModelRamSchemaTweakTable( this );
		tableScope = new BusModelRamScopeTable( this );
		tableServerListFunc = new BusModelRamServerListFuncTable( this );
		tableServerMethod = new BusModelRamServerMethodTable( this );
		tableServerObjFunc = new BusModelRamServerObjFuncTable( this );
		tableServerProc = new BusModelRamServerProcTable( this );
		tableStringCol = new BusModelRamStringColTable( this );
		tableStringDef = new BusModelRamStringDefTable( this );
		tableStringType = new BusModelRamStringTypeTable( this );
		tableTZDateCol = new BusModelRamTZDateColTable( this );
		tableTZDateDef = new BusModelRamTZDateDefTable( this );
		tableTZDateType = new BusModelRamTZDateTypeTable( this );
		tableTZTimeCol = new BusModelRamTZTimeColTable( this );
		tableTZTimeDef = new BusModelRamTZTimeDefTable( this );
		tableTZTimeType = new BusModelRamTZTimeTypeTable( this );
		tableTZTimestampCol = new BusModelRamTZTimestampColTable( this );
		tableTZTimestampDef = new BusModelRamTZTimestampDefTable( this );
		tableTZTimestampType = new BusModelRamTZTimestampTypeTable( this );
		tableTable = new BusModelRamTableTable( this );
		tableTableCol = new BusModelRamTableColTable( this );
		tableTableTweak = new BusModelRamTableTweakTable( this );
		tableTextCol = new BusModelRamTextColTable( this );
		tableTextDef = new BusModelRamTextDefTable( this );
		tableTextType = new BusModelRamTextTypeTable( this );
		tableTimeCol = new BusModelRamTimeColTable( this );
		tableTimeDef = new BusModelRamTimeDefTable( this );
		tableTimeType = new BusModelRamTimeTypeTable( this );
		tableTimestampCol = new BusModelRamTimestampColTable( this );
		tableTimestampDef = new BusModelRamTimestampDefTable( this );
		tableTimestampType = new BusModelRamTimestampTypeTable( this );
		tableTokenCol = new BusModelRamTokenColTable( this );
		tableTokenDef = new BusModelRamTokenDefTable( this );
		tableTokenType = new BusModelRamTokenTypeTable( this );
		tableTweak = new BusModelRamTweakTable( this );
		tableUInt16Col = new BusModelRamUInt16ColTable( this );
		tableUInt16Def = new BusModelRamUInt16DefTable( this );
		tableUInt16Type = new BusModelRamUInt16TypeTable( this );
		tableUInt32Col = new BusModelRamUInt32ColTable( this );
		tableUInt32Def = new BusModelRamUInt32DefTable( this );
		tableUInt32Type = new BusModelRamUInt32TypeTable( this );
		tableUInt64Col = new BusModelRamUInt64ColTable( this );
		tableUInt64Def = new BusModelRamUInt64DefTable( this );
		tableUInt64Type = new BusModelRamUInt64TypeTable( this );
		tableUuid6Col = new BusModelRamUuid6ColTable( this );
		tableUuid6Def = new BusModelRamUuid6DefTable( this );
		tableUuid6Gen = new BusModelRamUuid6GenTable( this );
		tableUuid6Type = new BusModelRamUuid6TypeTable( this );
		tableUuidCol = new BusModelRamUuidColTable( this );
		tableUuidDef = new BusModelRamUuidDefTable( this );
		tableUuidGen = new BusModelRamUuidGenTable( this );
		tableUuidType = new BusModelRamUuidTypeTable( this );
		tableValue = new BusModelRamValueTable( this );
	}

	@Override
	public IBusModelSchema newSchema() {
		throw new YCFMustOverrideException( getClass(), "newSchema" );
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

	public String fileImport( SecureAuthorization Authorization,
		String fileName,
		String fileContent )
	{
		final String S_ProcName = "fileImport";
		if( ( fileName == null ) || ( fileName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				1,
				"fileName" );
		}
		if( ( fileContent == null ) || ( fileContent.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				2,
				"fileContent" );
		}

		BusModelSaxLoader saxLoader = new BusModelSaxLoader();
		IBusModelSchemaObj schemaObj = new BusModelSchemaObj();
		schemaObj.setBusModelBackingStore( this );
		saxLoader.setSchemaObj( schemaObj );
		ISecureClusterObj useCluster = schemaObj.getClusterTableObj().readClusterByIdIdx( Authorization.getSecClusterId() );
		ISecureTenantObj useTenant = schemaObj.getTenantTableObj().readTenantByIdIdx( Authorization.getSecTenantId() );
		YCFCachedMessageLog runlog = new YCFCachedMessageLog();
		saxLoader.setLog( runlog );
		saxLoader.setUseCluster( useCluster );
		saxLoader.setUseTenant( useTenant );
		saxLoader.parseStringContents( fileContent );
		String logFileContent = runlog.getCacheContents();
		if( logFileContent == null ) {
			logFileContent = "";
		}

		return( logFileContent );
	}

		
	@Override
	public void wireTableTableInstances() {
		if (tableScope == null || !(tableScope instanceof BusModelRamScopeTable)) {
			tableScope = new BusModelRamScopeTable(this);
		}
		if (tableSchemaDef == null || !(tableSchemaDef instanceof BusModelRamSchemaDefTable)) {
			tableSchemaDef = new BusModelRamSchemaDefTable(this);
		}
		if (tableSchemaRef == null || !(tableSchemaRef instanceof BusModelRamSchemaRefTable)) {
			tableSchemaRef = new BusModelRamSchemaRefTable(this);
		}
		if (tableServerMethod == null || !(tableServerMethod instanceof BusModelRamServerMethodTable)) {
			tableServerMethod = new BusModelRamServerMethodTable(this);
		}
		if (tableServerObjFunc == null || !(tableServerObjFunc instanceof BusModelRamServerObjFuncTable)) {
			tableServerObjFunc = new BusModelRamServerObjFuncTable(this);
		}
		if (tableServerProc == null || !(tableServerProc instanceof BusModelRamServerProcTable)) {
			tableServerProc = new BusModelRamServerProcTable(this);
		}
		if (tableTable == null || !(tableTable instanceof BusModelRamTableTable)) {
			tableTable = new BusModelRamTableTable(this);
		}
		if (tableTweak == null || !(tableTweak instanceof BusModelRamTweakTable)) {
			tableTweak = new BusModelRamTweakTable(this);
		}
		if (tableTableTweak == null || !(tableTableTweak instanceof BusModelRamTableTweakTable)) {
			tableTableTweak = new BusModelRamTableTweakTable(this);
		}
		if (tableSchemaTweak == null || !(tableSchemaTweak instanceof BusModelRamSchemaTweakTable)) {
			tableSchemaTweak = new BusModelRamSchemaTweakTable(this);
		}
		if (tableIndexTweak == null || !(tableIndexTweak instanceof BusModelRamIndexTweakTable)) {
			tableIndexTweak = new BusModelRamIndexTweakTable(this);
		}
		if (tableValue == null || !(tableValue instanceof BusModelRamValueTable)) {
			tableValue = new BusModelRamValueTable(this);
		}
		if (tableAtom == null || !(tableAtom instanceof BusModelRamAtomTable)) {
			tableAtom = new BusModelRamAtomTable(this);
		}
		if (tableBlobDef == null || !(tableBlobDef instanceof BusModelRamBlobDefTable)) {
			tableBlobDef = new BusModelRamBlobDefTable(this);
		}
		if (tableBlobType == null || !(tableBlobType instanceof BusModelRamBlobTypeTable)) {
			tableBlobType = new BusModelRamBlobTypeTable(this);
		}
		if (tableBoolDef == null || !(tableBoolDef instanceof BusModelRamBoolDefTable)) {
			tableBoolDef = new BusModelRamBoolDefTable(this);
		}
		if (tableBoolType == null || !(tableBoolType instanceof BusModelRamBoolTypeTable)) {
			tableBoolType = new BusModelRamBoolTypeTable(this);
		}
		if (tableChain == null || !(tableChain instanceof BusModelRamChainTable)) {
			tableChain = new BusModelRamChainTable(this);
		}
		if (tableClearDep == null || !(tableClearDep instanceof BusModelRamClearDepTable)) {
			tableClearDep = new BusModelRamClearDepTable(this);
		}
		if (tableClearSubDep1 == null || !(tableClearSubDep1 instanceof BusModelRamClearSubDep1Table)) {
			tableClearSubDep1 = new BusModelRamClearSubDep1Table(this);
		}
		if (tableClearSubDep2 == null || !(tableClearSubDep2 instanceof BusModelRamClearSubDep2Table)) {
			tableClearSubDep2 = new BusModelRamClearSubDep2Table(this);
		}
		if (tableClearSubDep3 == null || !(tableClearSubDep3 instanceof BusModelRamClearSubDep3Table)) {
			tableClearSubDep3 = new BusModelRamClearSubDep3Table(this);
		}
		if (tableClearTopDep == null || !(tableClearTopDep instanceof BusModelRamClearTopDepTable)) {
			tableClearTopDep = new BusModelRamClearTopDepTable(this);
		}
		if (tableDateDef == null || !(tableDateDef instanceof BusModelRamDateDefTable)) {
			tableDateDef = new BusModelRamDateDefTable(this);
		}
		if (tableDateType == null || !(tableDateType instanceof BusModelRamDateTypeTable)) {
			tableDateType = new BusModelRamDateTypeTable(this);
		}
		if (tableDelDep == null || !(tableDelDep instanceof BusModelRamDelDepTable)) {
			tableDelDep = new BusModelRamDelDepTable(this);
		}
		if (tableDelSubDep1 == null || !(tableDelSubDep1 instanceof BusModelRamDelSubDep1Table)) {
			tableDelSubDep1 = new BusModelRamDelSubDep1Table(this);
		}
		if (tableDelSubDep2 == null || !(tableDelSubDep2 instanceof BusModelRamDelSubDep2Table)) {
			tableDelSubDep2 = new BusModelRamDelSubDep2Table(this);
		}
		if (tableDelSubDep3 == null || !(tableDelSubDep3 instanceof BusModelRamDelSubDep3Table)) {
			tableDelSubDep3 = new BusModelRamDelSubDep3Table(this);
		}
		if (tableDelTopDep == null || !(tableDelTopDep instanceof BusModelRamDelTopDepTable)) {
			tableDelTopDep = new BusModelRamDelTopDepTable(this);
		}
		if (tableDoubleDef == null || !(tableDoubleDef instanceof BusModelRamDoubleDefTable)) {
			tableDoubleDef = new BusModelRamDoubleDefTable(this);
		}
		if (tableDoubleType == null || !(tableDoubleType instanceof BusModelRamDoubleTypeTable)) {
			tableDoubleType = new BusModelRamDoubleTypeTable(this);
		}
		if (tableEnumTag == null || !(tableEnumTag instanceof BusModelRamEnumTagTable)) {
			tableEnumTag = new BusModelRamEnumTagTable(this);
		}
		if (tableFloatDef == null || !(tableFloatDef instanceof BusModelRamFloatDefTable)) {
			tableFloatDef = new BusModelRamFloatDefTable(this);
		}
		if (tableFloatType == null || !(tableFloatType instanceof BusModelRamFloatTypeTable)) {
			tableFloatType = new BusModelRamFloatTypeTable(this);
		}
		if (tableIndex == null || !(tableIndex instanceof BusModelRamIndexTable)) {
			tableIndex = new BusModelRamIndexTable(this);
		}
		if (tableIndexCol == null || !(tableIndexCol instanceof BusModelRamIndexColTable)) {
			tableIndexCol = new BusModelRamIndexColTable(this);
		}
		if (tableInt16Def == null || !(tableInt16Def instanceof BusModelRamInt16DefTable)) {
			tableInt16Def = new BusModelRamInt16DefTable(this);
		}
		if (tableInt16Type == null || !(tableInt16Type instanceof BusModelRamInt16TypeTable)) {
			tableInt16Type = new BusModelRamInt16TypeTable(this);
		}
		if (tableInt32Def == null || !(tableInt32Def instanceof BusModelRamInt32DefTable)) {
			tableInt32Def = new BusModelRamInt32DefTable(this);
		}
		if (tableInt32Type == null || !(tableInt32Type instanceof BusModelRamInt32TypeTable)) {
			tableInt32Type = new BusModelRamInt32TypeTable(this);
		}
		if (tableInt64Def == null || !(tableInt64Def instanceof BusModelRamInt64DefTable)) {
			tableInt64Def = new BusModelRamInt64DefTable(this);
		}
		if (tableInt64Type == null || !(tableInt64Type instanceof BusModelRamInt64TypeTable)) {
			tableInt64Type = new BusModelRamInt64TypeTable(this);
		}
		if (tableNmTokenDef == null || !(tableNmTokenDef instanceof BusModelRamNmTokenDefTable)) {
			tableNmTokenDef = new BusModelRamNmTokenDefTable(this);
		}
		if (tableNmTokenType == null || !(tableNmTokenType instanceof BusModelRamNmTokenTypeTable)) {
			tableNmTokenType = new BusModelRamNmTokenTypeTable(this);
		}
		if (tableNmTokensDef == null || !(tableNmTokensDef instanceof BusModelRamNmTokensDefTable)) {
			tableNmTokensDef = new BusModelRamNmTokensDefTable(this);
		}
		if (tableNmTokensType == null || !(tableNmTokensType instanceof BusModelRamNmTokensTypeTable)) {
			tableNmTokensType = new BusModelRamNmTokensTypeTable(this);
		}
		if (tableNumberDef == null || !(tableNumberDef instanceof BusModelRamNumberDefTable)) {
			tableNumberDef = new BusModelRamNumberDefTable(this);
		}
		if (tableNumberType == null || !(tableNumberType instanceof BusModelRamNumberTypeTable)) {
			tableNumberType = new BusModelRamNumberTypeTable(this);
		}
		if (tableParam == null || !(tableParam instanceof BusModelRamParamTable)) {
			tableParam = new BusModelRamParamTable(this);
		}
		if (tablePopDep == null || !(tablePopDep instanceof BusModelRamPopDepTable)) {
			tablePopDep = new BusModelRamPopDepTable(this);
		}
		if (tablePopSubDep1 == null || !(tablePopSubDep1 instanceof BusModelRamPopSubDep1Table)) {
			tablePopSubDep1 = new BusModelRamPopSubDep1Table(this);
		}
		if (tablePopSubDep2 == null || !(tablePopSubDep2 instanceof BusModelRamPopSubDep2Table)) {
			tablePopSubDep2 = new BusModelRamPopSubDep2Table(this);
		}
		if (tablePopSubDep3 == null || !(tablePopSubDep3 instanceof BusModelRamPopSubDep3Table)) {
			tablePopSubDep3 = new BusModelRamPopSubDep3Table(this);
		}
		if (tablePopTopDep == null || !(tablePopTopDep instanceof BusModelRamPopTopDepTable)) {
			tablePopTopDep = new BusModelRamPopTopDepTable(this);
		}
		if (tableRelation == null || !(tableRelation instanceof BusModelRamRelationTable)) {
			tableRelation = new BusModelRamRelationTable(this);
		}
		if (tableRelationCol == null || !(tableRelationCol instanceof BusModelRamRelationColTable)) {
			tableRelationCol = new BusModelRamRelationColTable(this);
		}
		if (tableServerListFunc == null || !(tableServerListFunc instanceof BusModelRamServerListFuncTable)) {
			tableServerListFunc = new BusModelRamServerListFuncTable(this);
		}
		if (tableDbKeyHash128Def == null || !(tableDbKeyHash128Def instanceof BusModelRamDbKeyHash128DefTable)) {
			tableDbKeyHash128Def = new BusModelRamDbKeyHash128DefTable(this);
		}
		if (tableDbKeyHash128Col == null || !(tableDbKeyHash128Col instanceof BusModelRamDbKeyHash128ColTable)) {
			tableDbKeyHash128Col = new BusModelRamDbKeyHash128ColTable(this);
		}
		if (tableDbKeyHash128Type == null || !(tableDbKeyHash128Type instanceof BusModelRamDbKeyHash128TypeTable)) {
			tableDbKeyHash128Type = new BusModelRamDbKeyHash128TypeTable(this);
		}
		if (tableDbKeyHash128Gen == null || !(tableDbKeyHash128Gen instanceof BusModelRamDbKeyHash128GenTable)) {
			tableDbKeyHash128Gen = new BusModelRamDbKeyHash128GenTable(this);
		}
		if (tableDbKeyHash160Def == null || !(tableDbKeyHash160Def instanceof BusModelRamDbKeyHash160DefTable)) {
			tableDbKeyHash160Def = new BusModelRamDbKeyHash160DefTable(this);
		}
		if (tableDbKeyHash160Col == null || !(tableDbKeyHash160Col instanceof BusModelRamDbKeyHash160ColTable)) {
			tableDbKeyHash160Col = new BusModelRamDbKeyHash160ColTable(this);
		}
		if (tableDbKeyHash160Type == null || !(tableDbKeyHash160Type instanceof BusModelRamDbKeyHash160TypeTable)) {
			tableDbKeyHash160Type = new BusModelRamDbKeyHash160TypeTable(this);
		}
		if (tableDbKeyHash160Gen == null || !(tableDbKeyHash160Gen instanceof BusModelRamDbKeyHash160GenTable)) {
			tableDbKeyHash160Gen = new BusModelRamDbKeyHash160GenTable(this);
		}
		if (tableDbKeyHash224Def == null || !(tableDbKeyHash224Def instanceof BusModelRamDbKeyHash224DefTable)) {
			tableDbKeyHash224Def = new BusModelRamDbKeyHash224DefTable(this);
		}
		if (tableDbKeyHash224Col == null || !(tableDbKeyHash224Col instanceof BusModelRamDbKeyHash224ColTable)) {
			tableDbKeyHash224Col = new BusModelRamDbKeyHash224ColTable(this);
		}
		if (tableDbKeyHash224Type == null || !(tableDbKeyHash224Type instanceof BusModelRamDbKeyHash224TypeTable)) {
			tableDbKeyHash224Type = new BusModelRamDbKeyHash224TypeTable(this);
		}
		if (tableDbKeyHash224Gen == null || !(tableDbKeyHash224Gen instanceof BusModelRamDbKeyHash224GenTable)) {
			tableDbKeyHash224Gen = new BusModelRamDbKeyHash224GenTable(this);
		}
		if (tableDbKeyHash256Def == null || !(tableDbKeyHash256Def instanceof BusModelRamDbKeyHash256DefTable)) {
			tableDbKeyHash256Def = new BusModelRamDbKeyHash256DefTable(this);
		}
		if (tableDbKeyHash256Col == null || !(tableDbKeyHash256Col instanceof BusModelRamDbKeyHash256ColTable)) {
			tableDbKeyHash256Col = new BusModelRamDbKeyHash256ColTable(this);
		}
		if (tableDbKeyHash256Type == null || !(tableDbKeyHash256Type instanceof BusModelRamDbKeyHash256TypeTable)) {
			tableDbKeyHash256Type = new BusModelRamDbKeyHash256TypeTable(this);
		}
		if (tableDbKeyHash256Gen == null || !(tableDbKeyHash256Gen instanceof BusModelRamDbKeyHash256GenTable)) {
			tableDbKeyHash256Gen = new BusModelRamDbKeyHash256GenTable(this);
		}
		if (tableDbKeyHash384Def == null || !(tableDbKeyHash384Def instanceof BusModelRamDbKeyHash384DefTable)) {
			tableDbKeyHash384Def = new BusModelRamDbKeyHash384DefTable(this);
		}
		if (tableDbKeyHash384Col == null || !(tableDbKeyHash384Col instanceof BusModelRamDbKeyHash384ColTable)) {
			tableDbKeyHash384Col = new BusModelRamDbKeyHash384ColTable(this);
		}
		if (tableDbKeyHash384Type == null || !(tableDbKeyHash384Type instanceof BusModelRamDbKeyHash384TypeTable)) {
			tableDbKeyHash384Type = new BusModelRamDbKeyHash384TypeTable(this);
		}
		if (tableDbKeyHash384Gen == null || !(tableDbKeyHash384Gen instanceof BusModelRamDbKeyHash384GenTable)) {
			tableDbKeyHash384Gen = new BusModelRamDbKeyHash384GenTable(this);
		}
		if (tableDbKeyHash512Def == null || !(tableDbKeyHash512Def instanceof BusModelRamDbKeyHash512DefTable)) {
			tableDbKeyHash512Def = new BusModelRamDbKeyHash512DefTable(this);
		}
		if (tableDbKeyHash512Col == null || !(tableDbKeyHash512Col instanceof BusModelRamDbKeyHash512ColTable)) {
			tableDbKeyHash512Col = new BusModelRamDbKeyHash512ColTable(this);
		}
		if (tableDbKeyHash512Type == null || !(tableDbKeyHash512Type instanceof BusModelRamDbKeyHash512TypeTable)) {
			tableDbKeyHash512Type = new BusModelRamDbKeyHash512TypeTable(this);
		}
		if (tableDbKeyHash512Gen == null || !(tableDbKeyHash512Gen instanceof BusModelRamDbKeyHash512GenTable)) {
			tableDbKeyHash512Gen = new BusModelRamDbKeyHash512GenTable(this);
		}
		if (tableStringDef == null || !(tableStringDef instanceof BusModelRamStringDefTable)) {
			tableStringDef = new BusModelRamStringDefTable(this);
		}
		if (tableStringType == null || !(tableStringType instanceof BusModelRamStringTypeTable)) {
			tableStringType = new BusModelRamStringTypeTable(this);
		}
		if (tableTZDateDef == null || !(tableTZDateDef instanceof BusModelRamTZDateDefTable)) {
			tableTZDateDef = new BusModelRamTZDateDefTable(this);
		}
		if (tableTZDateType == null || !(tableTZDateType instanceof BusModelRamTZDateTypeTable)) {
			tableTZDateType = new BusModelRamTZDateTypeTable(this);
		}
		if (tableTZTimeDef == null || !(tableTZTimeDef instanceof BusModelRamTZTimeDefTable)) {
			tableTZTimeDef = new BusModelRamTZTimeDefTable(this);
		}
		if (tableTZTimeType == null || !(tableTZTimeType instanceof BusModelRamTZTimeTypeTable)) {
			tableTZTimeType = new BusModelRamTZTimeTypeTable(this);
		}
		if (tableTZTimestampDef == null || !(tableTZTimestampDef instanceof BusModelRamTZTimestampDefTable)) {
			tableTZTimestampDef = new BusModelRamTZTimestampDefTable(this);
		}
		if (tableTZTimestampType == null || !(tableTZTimestampType instanceof BusModelRamTZTimestampTypeTable)) {
			tableTZTimestampType = new BusModelRamTZTimestampTypeTable(this);
		}
		if (tableTableCol == null || !(tableTableCol instanceof BusModelRamTableColTable)) {
			tableTableCol = new BusModelRamTableColTable(this);
		}
		if (tableTextDef == null || !(tableTextDef instanceof BusModelRamTextDefTable)) {
			tableTextDef = new BusModelRamTextDefTable(this);
		}
		if (tableTextType == null || !(tableTextType instanceof BusModelRamTextTypeTable)) {
			tableTextType = new BusModelRamTextTypeTable(this);
		}
		if (tableTimeDef == null || !(tableTimeDef instanceof BusModelRamTimeDefTable)) {
			tableTimeDef = new BusModelRamTimeDefTable(this);
		}
		if (tableTimeType == null || !(tableTimeType instanceof BusModelRamTimeTypeTable)) {
			tableTimeType = new BusModelRamTimeTypeTable(this);
		}
		if (tableTimestampDef == null || !(tableTimestampDef instanceof BusModelRamTimestampDefTable)) {
			tableTimestampDef = new BusModelRamTimestampDefTable(this);
		}
		if (tableTimestampType == null || !(tableTimestampType instanceof BusModelRamTimestampTypeTable)) {
			tableTimestampType = new BusModelRamTimestampTypeTable(this);
		}
		if (tableTokenDef == null || !(tableTokenDef instanceof BusModelRamTokenDefTable)) {
			tableTokenDef = new BusModelRamTokenDefTable(this);
		}
		if (tableTokenType == null || !(tableTokenType instanceof BusModelRamTokenTypeTable)) {
			tableTokenType = new BusModelRamTokenTypeTable(this);
		}
		if (tableUInt16Def == null || !(tableUInt16Def instanceof BusModelRamUInt16DefTable)) {
			tableUInt16Def = new BusModelRamUInt16DefTable(this);
		}
		if (tableUInt16Type == null || !(tableUInt16Type instanceof BusModelRamUInt16TypeTable)) {
			tableUInt16Type = new BusModelRamUInt16TypeTable(this);
		}
		if (tableUInt32Def == null || !(tableUInt32Def instanceof BusModelRamUInt32DefTable)) {
			tableUInt32Def = new BusModelRamUInt32DefTable(this);
		}
		if (tableUInt32Type == null || !(tableUInt32Type instanceof BusModelRamUInt32TypeTable)) {
			tableUInt32Type = new BusModelRamUInt32TypeTable(this);
		}
		if (tableUInt64Def == null || !(tableUInt64Def instanceof BusModelRamUInt64DefTable)) {
			tableUInt64Def = new BusModelRamUInt64DefTable(this);
		}
		if (tableUInt64Type == null || !(tableUInt64Type instanceof BusModelRamUInt64TypeTable)) {
			tableUInt64Type = new BusModelRamUInt64TypeTable(this);
		}
		if (tableUuidDef == null || !(tableUuidDef instanceof BusModelRamUuidDefTable)) {
			tableUuidDef = new BusModelRamUuidDefTable(this);
		}
		if (tableUuid6Def == null || !(tableUuid6Def instanceof BusModelRamUuid6DefTable)) {
			tableUuid6Def = new BusModelRamUuid6DefTable(this);
		}
		if (tableUuidType == null || !(tableUuidType instanceof BusModelRamUuidTypeTable)) {
			tableUuidType = new BusModelRamUuidTypeTable(this);
		}
		if (tableUuid6Type == null || !(tableUuid6Type instanceof BusModelRamUuid6TypeTable)) {
			tableUuid6Type = new BusModelRamUuid6TypeTable(this);
		}
		if (tableBlobCol == null || !(tableBlobCol instanceof BusModelRamBlobColTable)) {
			tableBlobCol = new BusModelRamBlobColTable(this);
		}
		if (tableBoolCol == null || !(tableBoolCol instanceof BusModelRamBoolColTable)) {
			tableBoolCol = new BusModelRamBoolColTable(this);
		}
		if (tableDateCol == null || !(tableDateCol instanceof BusModelRamDateColTable)) {
			tableDateCol = new BusModelRamDateColTable(this);
		}
		if (tableDoubleCol == null || !(tableDoubleCol instanceof BusModelRamDoubleColTable)) {
			tableDoubleCol = new BusModelRamDoubleColTable(this);
		}
		if (tableEnumDef == null || !(tableEnumDef instanceof BusModelRamEnumDefTable)) {
			tableEnumDef = new BusModelRamEnumDefTable(this);
		}
		if (tableEnumType == null || !(tableEnumType instanceof BusModelRamEnumTypeTable)) {
			tableEnumType = new BusModelRamEnumTypeTable(this);
		}
		if (tableFloatCol == null || !(tableFloatCol instanceof BusModelRamFloatColTable)) {
			tableFloatCol = new BusModelRamFloatColTable(this);
		}
		if (tableId16Gen == null || !(tableId16Gen instanceof BusModelRamId16GenTable)) {
			tableId16Gen = new BusModelRamId16GenTable(this);
		}
		if (tableId32Gen == null || !(tableId32Gen instanceof BusModelRamId32GenTable)) {
			tableId32Gen = new BusModelRamId32GenTable(this);
		}
		if (tableId64Gen == null || !(tableId64Gen instanceof BusModelRamId64GenTable)) {
			tableId64Gen = new BusModelRamId64GenTable(this);
		}
		if (tableInt16Col == null || !(tableInt16Col instanceof BusModelRamInt16ColTable)) {
			tableInt16Col = new BusModelRamInt16ColTable(this);
		}
		if (tableInt32Col == null || !(tableInt32Col instanceof BusModelRamInt32ColTable)) {
			tableInt32Col = new BusModelRamInt32ColTable(this);
		}
		if (tableInt64Col == null || !(tableInt64Col instanceof BusModelRamInt64ColTable)) {
			tableInt64Col = new BusModelRamInt64ColTable(this);
		}
		if (tableNmTokenCol == null || !(tableNmTokenCol instanceof BusModelRamNmTokenColTable)) {
			tableNmTokenCol = new BusModelRamNmTokenColTable(this);
		}
		if (tableNmTokensCol == null || !(tableNmTokensCol instanceof BusModelRamNmTokensColTable)) {
			tableNmTokensCol = new BusModelRamNmTokensColTable(this);
		}
		if (tableNumberCol == null || !(tableNumberCol instanceof BusModelRamNumberColTable)) {
			tableNumberCol = new BusModelRamNumberColTable(this);
		}
		if (tableStringCol == null || !(tableStringCol instanceof BusModelRamStringColTable)) {
			tableStringCol = new BusModelRamStringColTable(this);
		}
		if (tableTZDateCol == null || !(tableTZDateCol instanceof BusModelRamTZDateColTable)) {
			tableTZDateCol = new BusModelRamTZDateColTable(this);
		}
		if (tableTZTimeCol == null || !(tableTZTimeCol instanceof BusModelRamTZTimeColTable)) {
			tableTZTimeCol = new BusModelRamTZTimeColTable(this);
		}
		if (tableTZTimestampCol == null || !(tableTZTimestampCol instanceof BusModelRamTZTimestampColTable)) {
			tableTZTimestampCol = new BusModelRamTZTimestampColTable(this);
		}
		if (tableTextCol == null || !(tableTextCol instanceof BusModelRamTextColTable)) {
			tableTextCol = new BusModelRamTextColTable(this);
		}
		if (tableTimeCol == null || !(tableTimeCol instanceof BusModelRamTimeColTable)) {
			tableTimeCol = new BusModelRamTimeColTable(this);
		}
		if (tableTimestampCol == null || !(tableTimestampCol instanceof BusModelRamTimestampColTable)) {
			tableTimestampCol = new BusModelRamTimestampColTable(this);
		}
		if (tableTokenCol == null || !(tableTokenCol instanceof BusModelRamTokenColTable)) {
			tableTokenCol = new BusModelRamTokenColTable(this);
		}
		if (tableUInt16Col == null || !(tableUInt16Col instanceof BusModelRamUInt16ColTable)) {
			tableUInt16Col = new BusModelRamUInt16ColTable(this);
		}
		if (tableUInt32Col == null || !(tableUInt32Col instanceof BusModelRamUInt32ColTable)) {
			tableUInt32Col = new BusModelRamUInt32ColTable(this);
		}
		if (tableUInt64Col == null || !(tableUInt64Col instanceof BusModelRamUInt64ColTable)) {
			tableUInt64Col = new BusModelRamUInt64ColTable(this);
		}
		if (tableUuidCol == null || !(tableUuidCol instanceof BusModelRamUuidColTable)) {
			tableUuidCol = new BusModelRamUuidColTable(this);
		}
		if (tableUuid6Col == null || !(tableUuid6Col instanceof BusModelRamUuid6ColTable)) {
			tableUuid6Col = new BusModelRamUuid6ColTable(this);
		}
		if (tableUuidGen == null || !(tableUuidGen instanceof BusModelRamUuidGenTable)) {
			tableUuidGen = new BusModelRamUuidGenTable(this);
		}
		if (tableUuid6Gen == null || !(tableUuid6Gen instanceof BusModelRamUuid6GenTable)) {
			tableUuid6Gen = new BusModelRamUuid6GenTable(this);
		}
		if (tableRoleDef == null || !(tableRoleDef instanceof BusModelRamRoleDefTable)) {
			tableRoleDef = new BusModelRamRoleDefTable(this);
		}
		if (tableSchemaRole == null || !(tableSchemaRole instanceof BusModelRamSchemaRoleTable)) {
			tableSchemaRole = new BusModelRamSchemaRoleTable(this);
		}
	}
}
