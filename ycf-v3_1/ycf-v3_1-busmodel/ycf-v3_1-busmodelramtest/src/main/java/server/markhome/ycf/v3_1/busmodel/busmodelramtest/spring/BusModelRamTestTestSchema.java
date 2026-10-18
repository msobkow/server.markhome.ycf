
// Description: Spring Ram storage tests for BusModel for the RamTest program

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

package server.markhome.ycf.v3_1.busmodel.busmodelramtest.spring;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.buff.*;
import server.markhome.ycf.v3_1.secure.secureram.*;
import server.markhome.ycf.v3_1.intnet.intnetram.*;
import server.markhome.ycf.v3_1.busmodel.busmodelram.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

@Service("RamTestBusModel")
public class BusModelRamTestTestSchema {
    
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting BusModel tests...\n");
		IBusModelScope[] scopeResults = IBusModelSchema.getBackingBusModel().getTableScope().readAllDerived(null);
		if (scopeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getScopeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + scopeResults.length + " entities from BusModel.Scope\n");
		}

		IBusModelSchemaDef[] schemaDefResults = IBusModelSchema.getBackingBusModel().getTableSchemaDef().readAllDerived(null);
		if (schemaDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getSchemaDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + schemaDefResults.length + " entities from BusModel.SchemaDef\n");
		}

		IBusModelSchemaRef[] schemaRefResults = IBusModelSchema.getBackingBusModel().getTableSchemaRef().readAllDerived(null);
		if (schemaRefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getSchemaRefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + schemaRefResults.length + " entities from BusModel.SchemaRef\n");
		}

		IBusModelServerMethod[] serverMethodResults = IBusModelSchema.getBackingBusModel().getTableServerMethod().readAllDerived(null);
		if (serverMethodResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getServerMethodTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serverMethodResults.length + " entities from BusModel.ServerMethod\n");
		}

		IBusModelServerObjFunc[] serverObjFuncResults = IBusModelSchema.getBackingBusModel().getTableServerObjFunc().readAllDerived(null);
		if (serverObjFuncResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getServerObjFuncTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serverObjFuncResults.length + " entities from BusModel.ServerObjFunc\n");
		}

		IBusModelServerProc[] serverProcResults = IBusModelSchema.getBackingBusModel().getTableServerProc().readAllDerived(null);
		if (serverProcResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getServerProcTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serverProcResults.length + " entities from BusModel.ServerProc\n");
		}

		IBusModelTable[] tableResults = IBusModelSchema.getBackingBusModel().getTableTable().readAllDerived(null);
		if (tableResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTableTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tableResults.length + " entities from BusModel.Table\n");
		}

		IBusModelTweak[] tweakResults = IBusModelSchema.getBackingBusModel().getTableTweak().readAllDerived(null);
		if (tweakResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTweakTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tweakResults.length + " entities from BusModel.Tweak\n");
		}

		IBusModelTableTweak[] tableTweakResults = IBusModelSchema.getBackingBusModel().getTableTableTweak().readAllDerived(null);
		if (tableTweakResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTableTweakTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tableTweakResults.length + " entities from BusModel.TableTweak\n");
		}

		IBusModelSchemaTweak[] schemaTweakResults = IBusModelSchema.getBackingBusModel().getTableSchemaTweak().readAllDerived(null);
		if (schemaTweakResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getSchemaTweakTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + schemaTweakResults.length + " entities from BusModel.SchemaTweak\n");
		}

		IBusModelIndexTweak[] indexTweakResults = IBusModelSchema.getBackingBusModel().getTableIndexTweak().readAllDerived(null);
		if (indexTweakResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getIndexTweakTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + indexTweakResults.length + " entities from BusModel.IndexTweak\n");
		}

		IBusModelValue[] valueResults = IBusModelSchema.getBackingBusModel().getTableValue().readAllDerived(null);
		if (valueResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getValueTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + valueResults.length + " entities from BusModel.Value\n");
		}

		IBusModelAtom[] atomResults = IBusModelSchema.getBackingBusModel().getTableAtom().readAllDerived(null);
		if (atomResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getAtomTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + atomResults.length + " entities from BusModel.Atom\n");
		}

		IBusModelBlobDef[] blobDefResults = IBusModelSchema.getBackingBusModel().getTableBlobDef().readAllDerived(null);
		if (blobDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getBlobDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + blobDefResults.length + " entities from BusModel.BlobDef\n");
		}

		IBusModelBlobType[] blobTypeResults = IBusModelSchema.getBackingBusModel().getTableBlobType().readAllDerived(null);
		if (blobTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getBlobTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + blobTypeResults.length + " entities from BusModel.BlobType\n");
		}

		IBusModelBoolDef[] boolDefResults = IBusModelSchema.getBackingBusModel().getTableBoolDef().readAllDerived(null);
		if (boolDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getBoolDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + boolDefResults.length + " entities from BusModel.BoolDef\n");
		}

		IBusModelBoolType[] boolTypeResults = IBusModelSchema.getBackingBusModel().getTableBoolType().readAllDerived(null);
		if (boolTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getBoolTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + boolTypeResults.length + " entities from BusModel.BoolType\n");
		}

		IBusModelChain[] chainResults = IBusModelSchema.getBackingBusModel().getTableChain().readAllDerived(null);
		if (chainResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getChainTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + chainResults.length + " entities from BusModel.Chain\n");
		}

		IBusModelClearDep[] clearDepResults = IBusModelSchema.getBackingBusModel().getTableClearDep().readAllDerived(null);
		if (clearDepResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getClearDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearDepResults.length + " entities from BusModel.ClearDep\n");
		}

		IBusModelClearSubDep1[] clearSubDep1Results = IBusModelSchema.getBackingBusModel().getTableClearSubDep1().readAllDerived(null);
		if (clearSubDep1Results == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getClearSubDep1Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep1Results.length + " entities from BusModel.ClearSubDep1\n");
		}

		IBusModelClearSubDep2[] clearSubDep2Results = IBusModelSchema.getBackingBusModel().getTableClearSubDep2().readAllDerived(null);
		if (clearSubDep2Results == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getClearSubDep2Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep2Results.length + " entities from BusModel.ClearSubDep2\n");
		}

		IBusModelClearSubDep3[] clearSubDep3Results = IBusModelSchema.getBackingBusModel().getTableClearSubDep3().readAllDerived(null);
		if (clearSubDep3Results == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getClearSubDep3Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep3Results.length + " entities from BusModel.ClearSubDep3\n");
		}

		IBusModelClearTopDep[] clearTopDepResults = IBusModelSchema.getBackingBusModel().getTableClearTopDep().readAllDerived(null);
		if (clearTopDepResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getClearTopDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearTopDepResults.length + " entities from BusModel.ClearTopDep\n");
		}

		IBusModelDateDef[] dateDefResults = IBusModelSchema.getBackingBusModel().getTableDateDef().readAllDerived(null);
		if (dateDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDateDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dateDefResults.length + " entities from BusModel.DateDef\n");
		}

		IBusModelDateType[] dateTypeResults = IBusModelSchema.getBackingBusModel().getTableDateType().readAllDerived(null);
		if (dateTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDateTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dateTypeResults.length + " entities from BusModel.DateType\n");
		}

		IBusModelDelDep[] delDepResults = IBusModelSchema.getBackingBusModel().getTableDelDep().readAllDerived(null);
		if (delDepResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDelDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delDepResults.length + " entities from BusModel.DelDep\n");
		}

		IBusModelDelSubDep1[] delSubDep1Results = IBusModelSchema.getBackingBusModel().getTableDelSubDep1().readAllDerived(null);
		if (delSubDep1Results == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDelSubDep1Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delSubDep1Results.length + " entities from BusModel.DelSubDep1\n");
		}

		IBusModelDelSubDep2[] delSubDep2Results = IBusModelSchema.getBackingBusModel().getTableDelSubDep2().readAllDerived(null);
		if (delSubDep2Results == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDelSubDep2Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delSubDep2Results.length + " entities from BusModel.DelSubDep2\n");
		}

		IBusModelDelSubDep3[] delSubDep3Results = IBusModelSchema.getBackingBusModel().getTableDelSubDep3().readAllDerived(null);
		if (delSubDep3Results == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDelSubDep3Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delSubDep3Results.length + " entities from BusModel.DelSubDep3\n");
		}

		IBusModelDelTopDep[] delTopDepResults = IBusModelSchema.getBackingBusModel().getTableDelTopDep().readAllDerived(null);
		if (delTopDepResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDelTopDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delTopDepResults.length + " entities from BusModel.DelTopDep\n");
		}

		IBusModelDoubleDef[] doubleDefResults = IBusModelSchema.getBackingBusModel().getTableDoubleDef().readAllDerived(null);
		if (doubleDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDoubleDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + doubleDefResults.length + " entities from BusModel.DoubleDef\n");
		}

		IBusModelDoubleType[] doubleTypeResults = IBusModelSchema.getBackingBusModel().getTableDoubleType().readAllDerived(null);
		if (doubleTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDoubleTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + doubleTypeResults.length + " entities from BusModel.DoubleType\n");
		}

		IBusModelEnumTag[] enumTagResults = IBusModelSchema.getBackingBusModel().getTableEnumTag().readAllDerived(null);
		if (enumTagResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getEnumTagTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + enumTagResults.length + " entities from BusModel.EnumTag\n");
		}

		IBusModelFloatDef[] floatDefResults = IBusModelSchema.getBackingBusModel().getTableFloatDef().readAllDerived(null);
		if (floatDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getFloatDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + floatDefResults.length + " entities from BusModel.FloatDef\n");
		}

		IBusModelFloatType[] floatTypeResults = IBusModelSchema.getBackingBusModel().getTableFloatType().readAllDerived(null);
		if (floatTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getFloatTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + floatTypeResults.length + " entities from BusModel.FloatType\n");
		}

		IBusModelIndex[] indexResults = IBusModelSchema.getBackingBusModel().getTableIndex().readAllDerived(null);
		if (indexResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getIndexTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + indexResults.length + " entities from BusModel.Index\n");
		}

		IBusModelIndexCol[] indexColResults = IBusModelSchema.getBackingBusModel().getTableIndexCol().readAllDerived(null);
		if (indexColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getIndexColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + indexColResults.length + " entities from BusModel.IndexCol\n");
		}

		IBusModelInt16Def[] int16DefResults = IBusModelSchema.getBackingBusModel().getTableInt16Def().readAllDerived(null);
		if (int16DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getInt16DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int16DefResults.length + " entities from BusModel.Int16Def\n");
		}

		IBusModelInt16Type[] int16TypeResults = IBusModelSchema.getBackingBusModel().getTableInt16Type().readAllDerived(null);
		if (int16TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getInt16TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int16TypeResults.length + " entities from BusModel.Int16Type\n");
		}

		IBusModelInt32Def[] int32DefResults = IBusModelSchema.getBackingBusModel().getTableInt32Def().readAllDerived(null);
		if (int32DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getInt32DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int32DefResults.length + " entities from BusModel.Int32Def\n");
		}

		IBusModelInt32Type[] int32TypeResults = IBusModelSchema.getBackingBusModel().getTableInt32Type().readAllDerived(null);
		if (int32TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getInt32TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int32TypeResults.length + " entities from BusModel.Int32Type\n");
		}

		IBusModelInt64Def[] int64DefResults = IBusModelSchema.getBackingBusModel().getTableInt64Def().readAllDerived(null);
		if (int64DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getInt64DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int64DefResults.length + " entities from BusModel.Int64Def\n");
		}

		IBusModelInt64Type[] int64TypeResults = IBusModelSchema.getBackingBusModel().getTableInt64Type().readAllDerived(null);
		if (int64TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getInt64TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int64TypeResults.length + " entities from BusModel.Int64Type\n");
		}

		IBusModelNmTokenDef[] nmTokenDefResults = IBusModelSchema.getBackingBusModel().getTableNmTokenDef().readAllDerived(null);
		if (nmTokenDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getNmTokenDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokenDefResults.length + " entities from BusModel.NmTokenDef\n");
		}

		IBusModelNmTokenType[] nmTokenTypeResults = IBusModelSchema.getBackingBusModel().getTableNmTokenType().readAllDerived(null);
		if (nmTokenTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getNmTokenTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokenTypeResults.length + " entities from BusModel.NmTokenType\n");
		}

		IBusModelNmTokensDef[] nmTokensDefResults = IBusModelSchema.getBackingBusModel().getTableNmTokensDef().readAllDerived(null);
		if (nmTokensDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getNmTokensDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokensDefResults.length + " entities from BusModel.NmTokensDef\n");
		}

		IBusModelNmTokensType[] nmTokensTypeResults = IBusModelSchema.getBackingBusModel().getTableNmTokensType().readAllDerived(null);
		if (nmTokensTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getNmTokensTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokensTypeResults.length + " entities from BusModel.NmTokensType\n");
		}

		IBusModelNumberDef[] numberDefResults = IBusModelSchema.getBackingBusModel().getTableNumberDef().readAllDerived(null);
		if (numberDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getNumberDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + numberDefResults.length + " entities from BusModel.NumberDef\n");
		}

		IBusModelNumberType[] numberTypeResults = IBusModelSchema.getBackingBusModel().getTableNumberType().readAllDerived(null);
		if (numberTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getNumberTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + numberTypeResults.length + " entities from BusModel.NumberType\n");
		}

		IBusModelParam[] paramResults = IBusModelSchema.getBackingBusModel().getTableParam().readAllDerived(null);
		if (paramResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getParamTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + paramResults.length + " entities from BusModel.Param\n");
		}

		IBusModelPopDep[] popDepResults = IBusModelSchema.getBackingBusModel().getTablePopDep().readAllDerived(null);
		if (popDepResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getPopDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popDepResults.length + " entities from BusModel.PopDep\n");
		}

		IBusModelPopSubDep1[] popSubDep1Results = IBusModelSchema.getBackingBusModel().getTablePopSubDep1().readAllDerived(null);
		if (popSubDep1Results == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getPopSubDep1Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popSubDep1Results.length + " entities from BusModel.PopSubDep1\n");
		}

		IBusModelPopSubDep2[] popSubDep2Results = IBusModelSchema.getBackingBusModel().getTablePopSubDep2().readAllDerived(null);
		if (popSubDep2Results == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getPopSubDep2Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popSubDep2Results.length + " entities from BusModel.PopSubDep2\n");
		}

		IBusModelPopSubDep3[] popSubDep3Results = IBusModelSchema.getBackingBusModel().getTablePopSubDep3().readAllDerived(null);
		if (popSubDep3Results == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getPopSubDep3Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popSubDep3Results.length + " entities from BusModel.PopSubDep3\n");
		}

		IBusModelPopTopDep[] popTopDepResults = IBusModelSchema.getBackingBusModel().getTablePopTopDep().readAllDerived(null);
		if (popTopDepResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getPopTopDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popTopDepResults.length + " entities from BusModel.PopTopDep\n");
		}

		IBusModelRelation[] relationResults = IBusModelSchema.getBackingBusModel().getTableRelation().readAllDerived(null);
		if (relationResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getRelationTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + relationResults.length + " entities from BusModel.Relation\n");
		}

		IBusModelRelationCol[] relationColResults = IBusModelSchema.getBackingBusModel().getTableRelationCol().readAllDerived(null);
		if (relationColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getRelationColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + relationColResults.length + " entities from BusModel.RelationCol\n");
		}

		IBusModelServerListFunc[] serverListFuncResults = IBusModelSchema.getBackingBusModel().getTableServerListFunc().readAllDerived(null);
		if (serverListFuncResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getServerListFuncTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serverListFuncResults.length + " entities from BusModel.ServerListFunc\n");
		}

		IBusModelDbKeyHash128Def[] dbKeyHash128DefResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash128Def().readAllDerived(null);
		if (dbKeyHash128DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash128DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128DefResults.length + " entities from BusModel.DbKeyHash128Def\n");
		}

		IBusModelDbKeyHash128Col[] dbKeyHash128ColResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash128Col().readAllDerived(null);
		if (dbKeyHash128ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash128ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128ColResults.length + " entities from BusModel.DbKeyHash128Col\n");
		}

		IBusModelDbKeyHash128Type[] dbKeyHash128TypeResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash128Type().readAllDerived(null);
		if (dbKeyHash128TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash128TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128TypeResults.length + " entities from BusModel.DbKeyHash128Type\n");
		}

		IBusModelDbKeyHash128Gen[] dbKeyHash128GenResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash128Gen().readAllDerived(null);
		if (dbKeyHash128GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash128GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128GenResults.length + " entities from BusModel.DbKeyHash128Gen\n");
		}

		IBusModelDbKeyHash160Def[] dbKeyHash160DefResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash160Def().readAllDerived(null);
		if (dbKeyHash160DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash160DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160DefResults.length + " entities from BusModel.DbKeyHash160Def\n");
		}

		IBusModelDbKeyHash160Col[] dbKeyHash160ColResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash160Col().readAllDerived(null);
		if (dbKeyHash160ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash160ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160ColResults.length + " entities from BusModel.DbKeyHash160Col\n");
		}

		IBusModelDbKeyHash160Type[] dbKeyHash160TypeResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash160Type().readAllDerived(null);
		if (dbKeyHash160TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash160TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160TypeResults.length + " entities from BusModel.DbKeyHash160Type\n");
		}

		IBusModelDbKeyHash160Gen[] dbKeyHash160GenResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash160Gen().readAllDerived(null);
		if (dbKeyHash160GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash160GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160GenResults.length + " entities from BusModel.DbKeyHash160Gen\n");
		}

		IBusModelDbKeyHash224Def[] dbKeyHash224DefResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash224Def().readAllDerived(null);
		if (dbKeyHash224DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash224DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224DefResults.length + " entities from BusModel.DbKeyHash224Def\n");
		}

		IBusModelDbKeyHash224Col[] dbKeyHash224ColResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash224Col().readAllDerived(null);
		if (dbKeyHash224ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash224ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224ColResults.length + " entities from BusModel.DbKeyHash224Col\n");
		}

		IBusModelDbKeyHash224Type[] dbKeyHash224TypeResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash224Type().readAllDerived(null);
		if (dbKeyHash224TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash224TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224TypeResults.length + " entities from BusModel.DbKeyHash224Type\n");
		}

		IBusModelDbKeyHash224Gen[] dbKeyHash224GenResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash224Gen().readAllDerived(null);
		if (dbKeyHash224GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash224GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224GenResults.length + " entities from BusModel.DbKeyHash224Gen\n");
		}

		IBusModelDbKeyHash256Def[] dbKeyHash256DefResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash256Def().readAllDerived(null);
		if (dbKeyHash256DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash256DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256DefResults.length + " entities from BusModel.DbKeyHash256Def\n");
		}

		IBusModelDbKeyHash256Col[] dbKeyHash256ColResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash256Col().readAllDerived(null);
		if (dbKeyHash256ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash256ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256ColResults.length + " entities from BusModel.DbKeyHash256Col\n");
		}

		IBusModelDbKeyHash256Type[] dbKeyHash256TypeResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash256Type().readAllDerived(null);
		if (dbKeyHash256TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash256TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256TypeResults.length + " entities from BusModel.DbKeyHash256Type\n");
		}

		IBusModelDbKeyHash256Gen[] dbKeyHash256GenResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash256Gen().readAllDerived(null);
		if (dbKeyHash256GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash256GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256GenResults.length + " entities from BusModel.DbKeyHash256Gen\n");
		}

		IBusModelDbKeyHash384Def[] dbKeyHash384DefResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash384Def().readAllDerived(null);
		if (dbKeyHash384DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash384DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384DefResults.length + " entities from BusModel.DbKeyHash384Def\n");
		}

		IBusModelDbKeyHash384Col[] dbKeyHash384ColResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash384Col().readAllDerived(null);
		if (dbKeyHash384ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash384ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384ColResults.length + " entities from BusModel.DbKeyHash384Col\n");
		}

		IBusModelDbKeyHash384Type[] dbKeyHash384TypeResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash384Type().readAllDerived(null);
		if (dbKeyHash384TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash384TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384TypeResults.length + " entities from BusModel.DbKeyHash384Type\n");
		}

		IBusModelDbKeyHash384Gen[] dbKeyHash384GenResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash384Gen().readAllDerived(null);
		if (dbKeyHash384GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash384GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384GenResults.length + " entities from BusModel.DbKeyHash384Gen\n");
		}

		IBusModelDbKeyHash512Def[] dbKeyHash512DefResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash512Def().readAllDerived(null);
		if (dbKeyHash512DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash512DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512DefResults.length + " entities from BusModel.DbKeyHash512Def\n");
		}

		IBusModelDbKeyHash512Col[] dbKeyHash512ColResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash512Col().readAllDerived(null);
		if (dbKeyHash512ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash512ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512ColResults.length + " entities from BusModel.DbKeyHash512Col\n");
		}

		IBusModelDbKeyHash512Type[] dbKeyHash512TypeResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash512Type().readAllDerived(null);
		if (dbKeyHash512TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash512TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512TypeResults.length + " entities from BusModel.DbKeyHash512Type\n");
		}

		IBusModelDbKeyHash512Gen[] dbKeyHash512GenResults = IBusModelSchema.getBackingBusModel().getTableDbKeyHash512Gen().readAllDerived(null);
		if (dbKeyHash512GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDbKeyHash512GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512GenResults.length + " entities from BusModel.DbKeyHash512Gen\n");
		}

		IBusModelStringDef[] stringDefResults = IBusModelSchema.getBackingBusModel().getTableStringDef().readAllDerived(null);
		if (stringDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getStringDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + stringDefResults.length + " entities from BusModel.StringDef\n");
		}

		IBusModelStringType[] stringTypeResults = IBusModelSchema.getBackingBusModel().getTableStringType().readAllDerived(null);
		if (stringTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getStringTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + stringTypeResults.length + " entities from BusModel.StringType\n");
		}

		IBusModelTZDateDef[] tZDateDefResults = IBusModelSchema.getBackingBusModel().getTableTZDateDef().readAllDerived(null);
		if (tZDateDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTZDateDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZDateDefResults.length + " entities from BusModel.TZDateDef\n");
		}

		IBusModelTZDateType[] tZDateTypeResults = IBusModelSchema.getBackingBusModel().getTableTZDateType().readAllDerived(null);
		if (tZDateTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTZDateTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZDateTypeResults.length + " entities from BusModel.TZDateType\n");
		}

		IBusModelTZTimeDef[] tZTimeDefResults = IBusModelSchema.getBackingBusModel().getTableTZTimeDef().readAllDerived(null);
		if (tZTimeDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTZTimeDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimeDefResults.length + " entities from BusModel.TZTimeDef\n");
		}

		IBusModelTZTimeType[] tZTimeTypeResults = IBusModelSchema.getBackingBusModel().getTableTZTimeType().readAllDerived(null);
		if (tZTimeTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTZTimeTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimeTypeResults.length + " entities from BusModel.TZTimeType\n");
		}

		IBusModelTZTimestampDef[] tZTimestampDefResults = IBusModelSchema.getBackingBusModel().getTableTZTimestampDef().readAllDerived(null);
		if (tZTimestampDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTZTimestampDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampDefResults.length + " entities from BusModel.TZTimestampDef\n");
		}

		IBusModelTZTimestampType[] tZTimestampTypeResults = IBusModelSchema.getBackingBusModel().getTableTZTimestampType().readAllDerived(null);
		if (tZTimestampTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTZTimestampTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampTypeResults.length + " entities from BusModel.TZTimestampType\n");
		}

		IBusModelTableCol[] tableColResults = IBusModelSchema.getBackingBusModel().getTableTableCol().readAllDerived(null);
		if (tableColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTableColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tableColResults.length + " entities from BusModel.TableCol\n");
		}

		IBusModelTextDef[] textDefResults = IBusModelSchema.getBackingBusModel().getTableTextDef().readAllDerived(null);
		if (textDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTextDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + textDefResults.length + " entities from BusModel.TextDef\n");
		}

		IBusModelTextType[] textTypeResults = IBusModelSchema.getBackingBusModel().getTableTextType().readAllDerived(null);
		if (textTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTextTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + textTypeResults.length + " entities from BusModel.TextType\n");
		}

		IBusModelTimeDef[] timeDefResults = IBusModelSchema.getBackingBusModel().getTableTimeDef().readAllDerived(null);
		if (timeDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTimeDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timeDefResults.length + " entities from BusModel.TimeDef\n");
		}

		IBusModelTimeType[] timeTypeResults = IBusModelSchema.getBackingBusModel().getTableTimeType().readAllDerived(null);
		if (timeTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTimeTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timeTypeResults.length + " entities from BusModel.TimeType\n");
		}

		IBusModelTimestampDef[] timestampDefResults = IBusModelSchema.getBackingBusModel().getTableTimestampDef().readAllDerived(null);
		if (timestampDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTimestampDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timestampDefResults.length + " entities from BusModel.TimestampDef\n");
		}

		IBusModelTimestampType[] timestampTypeResults = IBusModelSchema.getBackingBusModel().getTableTimestampType().readAllDerived(null);
		if (timestampTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTimestampTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timestampTypeResults.length + " entities from BusModel.TimestampType\n");
		}

		IBusModelTokenDef[] tokenDefResults = IBusModelSchema.getBackingBusModel().getTableTokenDef().readAllDerived(null);
		if (tokenDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTokenDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tokenDefResults.length + " entities from BusModel.TokenDef\n");
		}

		IBusModelTokenType[] tokenTypeResults = IBusModelSchema.getBackingBusModel().getTableTokenType().readAllDerived(null);
		if (tokenTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTokenTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tokenTypeResults.length + " entities from BusModel.TokenType\n");
		}

		IBusModelUInt16Def[] uInt16DefResults = IBusModelSchema.getBackingBusModel().getTableUInt16Def().readAllDerived(null);
		if (uInt16DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUInt16DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt16DefResults.length + " entities from BusModel.UInt16Def\n");
		}

		IBusModelUInt16Type[] uInt16TypeResults = IBusModelSchema.getBackingBusModel().getTableUInt16Type().readAllDerived(null);
		if (uInt16TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUInt16TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt16TypeResults.length + " entities from BusModel.UInt16Type\n");
		}

		IBusModelUInt32Def[] uInt32DefResults = IBusModelSchema.getBackingBusModel().getTableUInt32Def().readAllDerived(null);
		if (uInt32DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUInt32DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt32DefResults.length + " entities from BusModel.UInt32Def\n");
		}

		IBusModelUInt32Type[] uInt32TypeResults = IBusModelSchema.getBackingBusModel().getTableUInt32Type().readAllDerived(null);
		if (uInt32TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUInt32TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt32TypeResults.length + " entities from BusModel.UInt32Type\n");
		}

		IBusModelUInt64Def[] uInt64DefResults = IBusModelSchema.getBackingBusModel().getTableUInt64Def().readAllDerived(null);
		if (uInt64DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUInt64DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt64DefResults.length + " entities from BusModel.UInt64Def\n");
		}

		IBusModelUInt64Type[] uInt64TypeResults = IBusModelSchema.getBackingBusModel().getTableUInt64Type().readAllDerived(null);
		if (uInt64TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUInt64TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt64TypeResults.length + " entities from BusModel.UInt64Type\n");
		}

		IBusModelUuidDef[] uuidDefResults = IBusModelSchema.getBackingBusModel().getTableUuidDef().readAllDerived(null);
		if (uuidDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUuidDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuidDefResults.length + " entities from BusModel.UuidDef\n");
		}

		IBusModelUuid6Def[] uuid6DefResults = IBusModelSchema.getBackingBusModel().getTableUuid6Def().readAllDerived(null);
		if (uuid6DefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUuid6DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuid6DefResults.length + " entities from BusModel.Uuid6Def\n");
		}

		IBusModelUuidType[] uuidTypeResults = IBusModelSchema.getBackingBusModel().getTableUuidType().readAllDerived(null);
		if (uuidTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUuidTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuidTypeResults.length + " entities from BusModel.UuidType\n");
		}

		IBusModelUuid6Type[] uuid6TypeResults = IBusModelSchema.getBackingBusModel().getTableUuid6Type().readAllDerived(null);
		if (uuid6TypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUuid6TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuid6TypeResults.length + " entities from BusModel.Uuid6Type\n");
		}

		IBusModelBlobCol[] blobColResults = IBusModelSchema.getBackingBusModel().getTableBlobCol().readAllDerived(null);
		if (blobColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getBlobColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + blobColResults.length + " entities from BusModel.BlobCol\n");
		}

		IBusModelBoolCol[] boolColResults = IBusModelSchema.getBackingBusModel().getTableBoolCol().readAllDerived(null);
		if (boolColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getBoolColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + boolColResults.length + " entities from BusModel.BoolCol\n");
		}

		IBusModelDateCol[] dateColResults = IBusModelSchema.getBackingBusModel().getTableDateCol().readAllDerived(null);
		if (dateColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDateColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dateColResults.length + " entities from BusModel.DateCol\n");
		}

		IBusModelDoubleCol[] doubleColResults = IBusModelSchema.getBackingBusModel().getTableDoubleCol().readAllDerived(null);
		if (doubleColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getDoubleColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + doubleColResults.length + " entities from BusModel.DoubleCol\n");
		}

		IBusModelEnumDef[] enumDefResults = IBusModelSchema.getBackingBusModel().getTableEnumDef().readAllDerived(null);
		if (enumDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getEnumDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + enumDefResults.length + " entities from BusModel.EnumDef\n");
		}

		IBusModelEnumType[] enumTypeResults = IBusModelSchema.getBackingBusModel().getTableEnumType().readAllDerived(null);
		if (enumTypeResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getEnumTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + enumTypeResults.length + " entities from BusModel.EnumType\n");
		}

		IBusModelFloatCol[] floatColResults = IBusModelSchema.getBackingBusModel().getTableFloatCol().readAllDerived(null);
		if (floatColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getFloatColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + floatColResults.length + " entities from BusModel.FloatCol\n");
		}

		IBusModelId16Gen[] id16GenResults = IBusModelSchema.getBackingBusModel().getTableId16Gen().readAllDerived(null);
		if (id16GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getId16GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + id16GenResults.length + " entities from BusModel.Id16Gen\n");
		}

		IBusModelId32Gen[] id32GenResults = IBusModelSchema.getBackingBusModel().getTableId32Gen().readAllDerived(null);
		if (id32GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getId32GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + id32GenResults.length + " entities from BusModel.Id32Gen\n");
		}

		IBusModelId64Gen[] id64GenResults = IBusModelSchema.getBackingBusModel().getTableId64Gen().readAllDerived(null);
		if (id64GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getId64GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + id64GenResults.length + " entities from BusModel.Id64Gen\n");
		}

		IBusModelInt16Col[] int16ColResults = IBusModelSchema.getBackingBusModel().getTableInt16Col().readAllDerived(null);
		if (int16ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getInt16ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int16ColResults.length + " entities from BusModel.Int16Col\n");
		}

		IBusModelInt32Col[] int32ColResults = IBusModelSchema.getBackingBusModel().getTableInt32Col().readAllDerived(null);
		if (int32ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getInt32ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int32ColResults.length + " entities from BusModel.Int32Col\n");
		}

		IBusModelInt64Col[] int64ColResults = IBusModelSchema.getBackingBusModel().getTableInt64Col().readAllDerived(null);
		if (int64ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getInt64ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int64ColResults.length + " entities from BusModel.Int64Col\n");
		}

		IBusModelNmTokenCol[] nmTokenColResults = IBusModelSchema.getBackingBusModel().getTableNmTokenCol().readAllDerived(null);
		if (nmTokenColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getNmTokenColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokenColResults.length + " entities from BusModel.NmTokenCol\n");
		}

		IBusModelNmTokensCol[] nmTokensColResults = IBusModelSchema.getBackingBusModel().getTableNmTokensCol().readAllDerived(null);
		if (nmTokensColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getNmTokensColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokensColResults.length + " entities from BusModel.NmTokensCol\n");
		}

		IBusModelNumberCol[] numberColResults = IBusModelSchema.getBackingBusModel().getTableNumberCol().readAllDerived(null);
		if (numberColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getNumberColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + numberColResults.length + " entities from BusModel.NumberCol\n");
		}

		IBusModelStringCol[] stringColResults = IBusModelSchema.getBackingBusModel().getTableStringCol().readAllDerived(null);
		if (stringColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getStringColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + stringColResults.length + " entities from BusModel.StringCol\n");
		}

		IBusModelTZDateCol[] tZDateColResults = IBusModelSchema.getBackingBusModel().getTableTZDateCol().readAllDerived(null);
		if (tZDateColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTZDateColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZDateColResults.length + " entities from BusModel.TZDateCol\n");
		}

		IBusModelTZTimeCol[] tZTimeColResults = IBusModelSchema.getBackingBusModel().getTableTZTimeCol().readAllDerived(null);
		if (tZTimeColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTZTimeColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimeColResults.length + " entities from BusModel.TZTimeCol\n");
		}

		IBusModelTZTimestampCol[] tZTimestampColResults = IBusModelSchema.getBackingBusModel().getTableTZTimestampCol().readAllDerived(null);
		if (tZTimestampColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTZTimestampColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampColResults.length + " entities from BusModel.TZTimestampCol\n");
		}

		IBusModelTextCol[] textColResults = IBusModelSchema.getBackingBusModel().getTableTextCol().readAllDerived(null);
		if (textColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTextColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + textColResults.length + " entities from BusModel.TextCol\n");
		}

		IBusModelTimeCol[] timeColResults = IBusModelSchema.getBackingBusModel().getTableTimeCol().readAllDerived(null);
		if (timeColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTimeColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timeColResults.length + " entities from BusModel.TimeCol\n");
		}

		IBusModelTimestampCol[] timestampColResults = IBusModelSchema.getBackingBusModel().getTableTimestampCol().readAllDerived(null);
		if (timestampColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTimestampColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timestampColResults.length + " entities from BusModel.TimestampCol\n");
		}

		IBusModelTokenCol[] tokenColResults = IBusModelSchema.getBackingBusModel().getTableTokenCol().readAllDerived(null);
		if (tokenColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getTokenColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tokenColResults.length + " entities from BusModel.TokenCol\n");
		}

		IBusModelUInt16Col[] uInt16ColResults = IBusModelSchema.getBackingBusModel().getTableUInt16Col().readAllDerived(null);
		if (uInt16ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUInt16ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt16ColResults.length + " entities from BusModel.UInt16Col\n");
		}

		IBusModelUInt32Col[] uInt32ColResults = IBusModelSchema.getBackingBusModel().getTableUInt32Col().readAllDerived(null);
		if (uInt32ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUInt32ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt32ColResults.length + " entities from BusModel.UInt32Col\n");
		}

		IBusModelUInt64Col[] uInt64ColResults = IBusModelSchema.getBackingBusModel().getTableUInt64Col().readAllDerived(null);
		if (uInt64ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUInt64ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt64ColResults.length + " entities from BusModel.UInt64Col\n");
		}

		IBusModelUuidCol[] uuidColResults = IBusModelSchema.getBackingBusModel().getTableUuidCol().readAllDerived(null);
		if (uuidColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUuidColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuidColResults.length + " entities from BusModel.UuidCol\n");
		}

		IBusModelUuid6Col[] uuid6ColResults = IBusModelSchema.getBackingBusModel().getTableUuid6Col().readAllDerived(null);
		if (uuid6ColResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUuid6ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuid6ColResults.length + " entities from BusModel.Uuid6Col\n");
		}

		IBusModelUuidGen[] uuidGenResults = IBusModelSchema.getBackingBusModel().getTableUuidGen().readAllDerived(null);
		if (uuidGenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUuidGenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuidGenResults.length + " entities from BusModel.UuidGen\n");
		}

		IBusModelUuid6Gen[] uuid6GenResults = IBusModelSchema.getBackingBusModel().getTableUuid6Gen().readAllDerived(null);
		if (uuid6GenResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getUuid6GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuid6GenResults.length + " entities from BusModel.Uuid6Gen\n");
		}

		IBusModelRoleDef[] roleDefResults = IBusModelSchema.getBackingBusModel().getTableRoleDef().readAllDerived(null);
		if (roleDefResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getRoleDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + roleDefResults.length + " entities from BusModel.RoleDef\n");
		}

		IBusModelSchemaRole[] schemaRoleResults = IBusModelSchema.getBackingBusModel().getTableSchemaRole().readAllDerived(null);
		if (schemaRoleResults == null) {
			messages.append("Erroneously retrieved null for IBusModelSchema.getSchemaRoleTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + schemaRoleResults.length + " entities from BusModel.SchemaRole\n");
		}

		messages.append("BusModel tests complete\n");
		return( messages.toString() );
	}
}