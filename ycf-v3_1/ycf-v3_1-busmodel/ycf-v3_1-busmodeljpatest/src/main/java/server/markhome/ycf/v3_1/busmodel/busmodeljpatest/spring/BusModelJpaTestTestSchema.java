
// Description: Spring JPA tests for BusModel for the JpaTest program

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

package server.markhome.ycf.v3_1.busmodel.busmodeljpatest.spring;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.jpa.*;

@Service("JpaTestBusModel")
public class BusModelJpaTestTestSchema {
    
    @Autowired
    @Qualifier("busmodel31EntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean busModel31EntityManagerFactory;
	@Autowired
	private BusModelJpaScopeService busModelScopeService;

	@Autowired
	private BusModelJpaSchemaDefService busModelSchemaDefService;

	@Autowired
	private BusModelJpaSchemaRefService busModelSchemaRefService;

	@Autowired
	private BusModelJpaServerMethodService busModelServerMethodService;

	@Autowired
	private BusModelJpaServerObjFuncService busModelServerObjFuncService;

	@Autowired
	private BusModelJpaServerProcService busModelServerProcService;

	@Autowired
	private BusModelJpaTableService busModelTableService;

	@Autowired
	private BusModelJpaTweakService busModelTweakService;

	@Autowired
	private BusModelJpaTableTweakService busModelTableTweakService;

	@Autowired
	private BusModelJpaSchemaTweakService busModelSchemaTweakService;

	@Autowired
	private BusModelJpaIndexTweakService busModelIndexTweakService;

	@Autowired
	private BusModelJpaValueService busModelValueService;

	@Autowired
	private BusModelJpaAtomService busModelAtomService;

	@Autowired
	private BusModelJpaBlobDefService busModelBlobDefService;

	@Autowired
	private BusModelJpaBlobTypeService busModelBlobTypeService;

	@Autowired
	private BusModelJpaBoolDefService busModelBoolDefService;

	@Autowired
	private BusModelJpaBoolTypeService busModelBoolTypeService;

	@Autowired
	private BusModelJpaChainService busModelChainService;

	@Autowired
	private BusModelJpaClearDepService busModelClearDepService;

	@Autowired
	private BusModelJpaClearSubDep1Service busModelClearSubDep1Service;

	@Autowired
	private BusModelJpaClearSubDep2Service busModelClearSubDep2Service;

	@Autowired
	private BusModelJpaClearSubDep3Service busModelClearSubDep3Service;

	@Autowired
	private BusModelJpaClearTopDepService busModelClearTopDepService;

	@Autowired
	private BusModelJpaDateDefService busModelDateDefService;

	@Autowired
	private BusModelJpaDateTypeService busModelDateTypeService;

	@Autowired
	private BusModelJpaDelDepService busModelDelDepService;

	@Autowired
	private BusModelJpaDelSubDep1Service busModelDelSubDep1Service;

	@Autowired
	private BusModelJpaDelSubDep2Service busModelDelSubDep2Service;

	@Autowired
	private BusModelJpaDelSubDep3Service busModelDelSubDep3Service;

	@Autowired
	private BusModelJpaDelTopDepService busModelDelTopDepService;

	@Autowired
	private BusModelJpaDoubleDefService busModelDoubleDefService;

	@Autowired
	private BusModelJpaDoubleTypeService busModelDoubleTypeService;

	@Autowired
	private BusModelJpaEnumTagService busModelEnumTagService;

	@Autowired
	private BusModelJpaFloatDefService busModelFloatDefService;

	@Autowired
	private BusModelJpaFloatTypeService busModelFloatTypeService;

	@Autowired
	private BusModelJpaIndexService busModelIndexService;

	@Autowired
	private BusModelJpaIndexColService busModelIndexColService;

	@Autowired
	private BusModelJpaInt16DefService busModelInt16DefService;

	@Autowired
	private BusModelJpaInt16TypeService busModelInt16TypeService;

	@Autowired
	private BusModelJpaInt32DefService busModelInt32DefService;

	@Autowired
	private BusModelJpaInt32TypeService busModelInt32TypeService;

	@Autowired
	private BusModelJpaInt64DefService busModelInt64DefService;

	@Autowired
	private BusModelJpaInt64TypeService busModelInt64TypeService;

	@Autowired
	private BusModelJpaNmTokenDefService busModelNmTokenDefService;

	@Autowired
	private BusModelJpaNmTokenTypeService busModelNmTokenTypeService;

	@Autowired
	private BusModelJpaNmTokensDefService busModelNmTokensDefService;

	@Autowired
	private BusModelJpaNmTokensTypeService busModelNmTokensTypeService;

	@Autowired
	private BusModelJpaNumberDefService busModelNumberDefService;

	@Autowired
	private BusModelJpaNumberTypeService busModelNumberTypeService;

	@Autowired
	private BusModelJpaParamService busModelParamService;

	@Autowired
	private BusModelJpaPopDepService busModelPopDepService;

	@Autowired
	private BusModelJpaPopSubDep1Service busModelPopSubDep1Service;

	@Autowired
	private BusModelJpaPopSubDep2Service busModelPopSubDep2Service;

	@Autowired
	private BusModelJpaPopSubDep3Service busModelPopSubDep3Service;

	@Autowired
	private BusModelJpaPopTopDepService busModelPopTopDepService;

	@Autowired
	private BusModelJpaRelationService busModelRelationService;

	@Autowired
	private BusModelJpaRelationColService busModelRelationColService;

	@Autowired
	private BusModelJpaServerListFuncService busModelServerListFuncService;

	@Autowired
	private BusModelJpaDbKeyHash128DefService busModelDbKeyHash128DefService;

	@Autowired
	private BusModelJpaDbKeyHash128ColService busModelDbKeyHash128ColService;

	@Autowired
	private BusModelJpaDbKeyHash128TypeService busModelDbKeyHash128TypeService;

	@Autowired
	private BusModelJpaDbKeyHash128GenService busModelDbKeyHash128GenService;

	@Autowired
	private BusModelJpaDbKeyHash160DefService busModelDbKeyHash160DefService;

	@Autowired
	private BusModelJpaDbKeyHash160ColService busModelDbKeyHash160ColService;

	@Autowired
	private BusModelJpaDbKeyHash160TypeService busModelDbKeyHash160TypeService;

	@Autowired
	private BusModelJpaDbKeyHash160GenService busModelDbKeyHash160GenService;

	@Autowired
	private BusModelJpaDbKeyHash224DefService busModelDbKeyHash224DefService;

	@Autowired
	private BusModelJpaDbKeyHash224ColService busModelDbKeyHash224ColService;

	@Autowired
	private BusModelJpaDbKeyHash224TypeService busModelDbKeyHash224TypeService;

	@Autowired
	private BusModelJpaDbKeyHash224GenService busModelDbKeyHash224GenService;

	@Autowired
	private BusModelJpaDbKeyHash256DefService busModelDbKeyHash256DefService;

	@Autowired
	private BusModelJpaDbKeyHash256ColService busModelDbKeyHash256ColService;

	@Autowired
	private BusModelJpaDbKeyHash256TypeService busModelDbKeyHash256TypeService;

	@Autowired
	private BusModelJpaDbKeyHash256GenService busModelDbKeyHash256GenService;

	@Autowired
	private BusModelJpaDbKeyHash384DefService busModelDbKeyHash384DefService;

	@Autowired
	private BusModelJpaDbKeyHash384ColService busModelDbKeyHash384ColService;

	@Autowired
	private BusModelJpaDbKeyHash384TypeService busModelDbKeyHash384TypeService;

	@Autowired
	private BusModelJpaDbKeyHash384GenService busModelDbKeyHash384GenService;

	@Autowired
	private BusModelJpaDbKeyHash512DefService busModelDbKeyHash512DefService;

	@Autowired
	private BusModelJpaDbKeyHash512ColService busModelDbKeyHash512ColService;

	@Autowired
	private BusModelJpaDbKeyHash512TypeService busModelDbKeyHash512TypeService;

	@Autowired
	private BusModelJpaDbKeyHash512GenService busModelDbKeyHash512GenService;

	@Autowired
	private BusModelJpaStringDefService busModelStringDefService;

	@Autowired
	private BusModelJpaStringTypeService busModelStringTypeService;

	@Autowired
	private BusModelJpaTZDateDefService busModelTZDateDefService;

	@Autowired
	private BusModelJpaTZDateTypeService busModelTZDateTypeService;

	@Autowired
	private BusModelJpaTZTimeDefService busModelTZTimeDefService;

	@Autowired
	private BusModelJpaTZTimeTypeService busModelTZTimeTypeService;

	@Autowired
	private BusModelJpaTZTimestampDefService busModelTZTimestampDefService;

	@Autowired
	private BusModelJpaTZTimestampTypeService busModelTZTimestampTypeService;

	@Autowired
	private BusModelJpaTableColService busModelTableColService;

	@Autowired
	private BusModelJpaTextDefService busModelTextDefService;

	@Autowired
	private BusModelJpaTextTypeService busModelTextTypeService;

	@Autowired
	private BusModelJpaTimeDefService busModelTimeDefService;

	@Autowired
	private BusModelJpaTimeTypeService busModelTimeTypeService;

	@Autowired
	private BusModelJpaTimestampDefService busModelTimestampDefService;

	@Autowired
	private BusModelJpaTimestampTypeService busModelTimestampTypeService;

	@Autowired
	private BusModelJpaTokenDefService busModelTokenDefService;

	@Autowired
	private BusModelJpaTokenTypeService busModelTokenTypeService;

	@Autowired
	private BusModelJpaUInt16DefService busModelUInt16DefService;

	@Autowired
	private BusModelJpaUInt16TypeService busModelUInt16TypeService;

	@Autowired
	private BusModelJpaUInt32DefService busModelUInt32DefService;

	@Autowired
	private BusModelJpaUInt32TypeService busModelUInt32TypeService;

	@Autowired
	private BusModelJpaUInt64DefService busModelUInt64DefService;

	@Autowired
	private BusModelJpaUInt64TypeService busModelUInt64TypeService;

	@Autowired
	private BusModelJpaUuidDefService busModelUuidDefService;

	@Autowired
	private BusModelJpaUuid6DefService busModelUuid6DefService;

	@Autowired
	private BusModelJpaUuidTypeService busModelUuidTypeService;

	@Autowired
	private BusModelJpaUuid6TypeService busModelUuid6TypeService;

	@Autowired
	private BusModelJpaBlobColService busModelBlobColService;

	@Autowired
	private BusModelJpaBoolColService busModelBoolColService;

	@Autowired
	private BusModelJpaDateColService busModelDateColService;

	@Autowired
	private BusModelJpaDoubleColService busModelDoubleColService;

	@Autowired
	private BusModelJpaEnumDefService busModelEnumDefService;

	@Autowired
	private BusModelJpaEnumTypeService busModelEnumTypeService;

	@Autowired
	private BusModelJpaFloatColService busModelFloatColService;

	@Autowired
	private BusModelJpaId16GenService busModelId16GenService;

	@Autowired
	private BusModelJpaId32GenService busModelId32GenService;

	@Autowired
	private BusModelJpaId64GenService busModelId64GenService;

	@Autowired
	private BusModelJpaInt16ColService busModelInt16ColService;

	@Autowired
	private BusModelJpaInt32ColService busModelInt32ColService;

	@Autowired
	private BusModelJpaInt64ColService busModelInt64ColService;

	@Autowired
	private BusModelJpaNmTokenColService busModelNmTokenColService;

	@Autowired
	private BusModelJpaNmTokensColService busModelNmTokensColService;

	@Autowired
	private BusModelJpaNumberColService busModelNumberColService;

	@Autowired
	private BusModelJpaStringColService busModelStringColService;

	@Autowired
	private BusModelJpaTZDateColService busModelTZDateColService;

	@Autowired
	private BusModelJpaTZTimeColService busModelTZTimeColService;

	@Autowired
	private BusModelJpaTZTimestampColService busModelTZTimestampColService;

	@Autowired
	private BusModelJpaTextColService busModelTextColService;

	@Autowired
	private BusModelJpaTimeColService busModelTimeColService;

	@Autowired
	private BusModelJpaTimestampColService busModelTimestampColService;

	@Autowired
	private BusModelJpaTokenColService busModelTokenColService;

	@Autowired
	private BusModelJpaUInt16ColService busModelUInt16ColService;

	@Autowired
	private BusModelJpaUInt32ColService busModelUInt32ColService;

	@Autowired
	private BusModelJpaUInt64ColService busModelUInt64ColService;

	@Autowired
	private BusModelJpaUuidColService busModelUuidColService;

	@Autowired
	private BusModelJpaUuid6ColService busModelUuid6ColService;

	@Autowired
	private BusModelJpaUuidGenService busModelUuidGenService;

	@Autowired
	private BusModelJpaUuid6GenService busModelUuid6GenService;

	@Autowired
	private BusModelJpaRoleDefService busModelRoleDefService;

	@Autowired
	private BusModelJpaSchemaRoleService busModelSchemaRoleService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    // @PersistenceContext(unitName = "BusModel31PU")
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting BusModel tests...\n");
		List<?> scopeResults = busModelScopeService.findAll();
		if (scopeResults == null) {
			messages.append("Erroneously retrieved null for BusModelScopeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + scopeResults.size() + " entities from BusModel.Scope\n");
		}

		List<?> schemaDefResults = busModelSchemaDefService.findAll();
		if (schemaDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelSchemaDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + schemaDefResults.size() + " entities from BusModel.SchemaDef\n");
		}

		List<?> schemaRefResults = busModelSchemaRefService.findAll();
		if (schemaRefResults == null) {
			messages.append("Erroneously retrieved null for BusModelSchemaRefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + schemaRefResults.size() + " entities from BusModel.SchemaRef\n");
		}

		List<?> serverMethodResults = busModelServerMethodService.findAll();
		if (serverMethodResults == null) {
			messages.append("Erroneously retrieved null for BusModelServerMethodService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + serverMethodResults.size() + " entities from BusModel.ServerMethod\n");
		}

		List<?> serverObjFuncResults = busModelServerObjFuncService.findAll();
		if (serverObjFuncResults == null) {
			messages.append("Erroneously retrieved null for BusModelServerObjFuncService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + serverObjFuncResults.size() + " entities from BusModel.ServerObjFunc\n");
		}

		List<?> serverProcResults = busModelServerProcService.findAll();
		if (serverProcResults == null) {
			messages.append("Erroneously retrieved null for BusModelServerProcService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + serverProcResults.size() + " entities from BusModel.ServerProc\n");
		}

		List<?> tableResults = busModelTableService.findAll();
		if (tableResults == null) {
			messages.append("Erroneously retrieved null for BusModelTableService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tableResults.size() + " entities from BusModel.Table\n");
		}

		List<?> tweakResults = busModelTweakService.findAll();
		if (tweakResults == null) {
			messages.append("Erroneously retrieved null for BusModelTweakService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tweakResults.size() + " entities from BusModel.Tweak\n");
		}

		List<?> tableTweakResults = busModelTableTweakService.findAll();
		if (tableTweakResults == null) {
			messages.append("Erroneously retrieved null for BusModelTableTweakService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tableTweakResults.size() + " entities from BusModel.TableTweak\n");
		}

		List<?> schemaTweakResults = busModelSchemaTweakService.findAll();
		if (schemaTweakResults == null) {
			messages.append("Erroneously retrieved null for BusModelSchemaTweakService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + schemaTweakResults.size() + " entities from BusModel.SchemaTweak\n");
		}

		List<?> indexTweakResults = busModelIndexTweakService.findAll();
		if (indexTweakResults == null) {
			messages.append("Erroneously retrieved null for BusModelIndexTweakService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + indexTweakResults.size() + " entities from BusModel.IndexTweak\n");
		}

		List<?> valueResults = busModelValueService.findAll();
		if (valueResults == null) {
			messages.append("Erroneously retrieved null for BusModelValueService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + valueResults.size() + " entities from BusModel.Value\n");
		}

		List<?> atomResults = busModelAtomService.findAll();
		if (atomResults == null) {
			messages.append("Erroneously retrieved null for BusModelAtomService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + atomResults.size() + " entities from BusModel.Atom\n");
		}

		List<?> blobDefResults = busModelBlobDefService.findAll();
		if (blobDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelBlobDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + blobDefResults.size() + " entities from BusModel.BlobDef\n");
		}

		List<?> blobTypeResults = busModelBlobTypeService.findAll();
		if (blobTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelBlobTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + blobTypeResults.size() + " entities from BusModel.BlobType\n");
		}

		List<?> boolDefResults = busModelBoolDefService.findAll();
		if (boolDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelBoolDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + boolDefResults.size() + " entities from BusModel.BoolDef\n");
		}

		List<?> boolTypeResults = busModelBoolTypeService.findAll();
		if (boolTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelBoolTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + boolTypeResults.size() + " entities from BusModel.BoolType\n");
		}

		List<?> chainResults = busModelChainService.findAll();
		if (chainResults == null) {
			messages.append("Erroneously retrieved null for BusModelChainService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + chainResults.size() + " entities from BusModel.Chain\n");
		}

		List<?> clearDepResults = busModelClearDepService.findAll();
		if (clearDepResults == null) {
			messages.append("Erroneously retrieved null for BusModelClearDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearDepResults.size() + " entities from BusModel.ClearDep\n");
		}

		List<?> clearSubDep1Results = busModelClearSubDep1Service.findAll();
		if (clearSubDep1Results == null) {
			messages.append("Erroneously retrieved null for BusModelClearSubDep1Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep1Results.size() + " entities from BusModel.ClearSubDep1\n");
		}

		List<?> clearSubDep2Results = busModelClearSubDep2Service.findAll();
		if (clearSubDep2Results == null) {
			messages.append("Erroneously retrieved null for BusModelClearSubDep2Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep2Results.size() + " entities from BusModel.ClearSubDep2\n");
		}

		List<?> clearSubDep3Results = busModelClearSubDep3Service.findAll();
		if (clearSubDep3Results == null) {
			messages.append("Erroneously retrieved null for BusModelClearSubDep3Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep3Results.size() + " entities from BusModel.ClearSubDep3\n");
		}

		List<?> clearTopDepResults = busModelClearTopDepService.findAll();
		if (clearTopDepResults == null) {
			messages.append("Erroneously retrieved null for BusModelClearTopDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearTopDepResults.size() + " entities from BusModel.ClearTopDep\n");
		}

		List<?> dateDefResults = busModelDateDefService.findAll();
		if (dateDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelDateDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dateDefResults.size() + " entities from BusModel.DateDef\n");
		}

		List<?> dateTypeResults = busModelDateTypeService.findAll();
		if (dateTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelDateTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dateTypeResults.size() + " entities from BusModel.DateType\n");
		}

		List<?> delDepResults = busModelDelDepService.findAll();
		if (delDepResults == null) {
			messages.append("Erroneously retrieved null for BusModelDelDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delDepResults.size() + " entities from BusModel.DelDep\n");
		}

		List<?> delSubDep1Results = busModelDelSubDep1Service.findAll();
		if (delSubDep1Results == null) {
			messages.append("Erroneously retrieved null for BusModelDelSubDep1Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delSubDep1Results.size() + " entities from BusModel.DelSubDep1\n");
		}

		List<?> delSubDep2Results = busModelDelSubDep2Service.findAll();
		if (delSubDep2Results == null) {
			messages.append("Erroneously retrieved null for BusModelDelSubDep2Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delSubDep2Results.size() + " entities from BusModel.DelSubDep2\n");
		}

		List<?> delSubDep3Results = busModelDelSubDep3Service.findAll();
		if (delSubDep3Results == null) {
			messages.append("Erroneously retrieved null for BusModelDelSubDep3Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delSubDep3Results.size() + " entities from BusModel.DelSubDep3\n");
		}

		List<?> delTopDepResults = busModelDelTopDepService.findAll();
		if (delTopDepResults == null) {
			messages.append("Erroneously retrieved null for BusModelDelTopDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delTopDepResults.size() + " entities from BusModel.DelTopDep\n");
		}

		List<?> doubleDefResults = busModelDoubleDefService.findAll();
		if (doubleDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelDoubleDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + doubleDefResults.size() + " entities from BusModel.DoubleDef\n");
		}

		List<?> doubleTypeResults = busModelDoubleTypeService.findAll();
		if (doubleTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelDoubleTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + doubleTypeResults.size() + " entities from BusModel.DoubleType\n");
		}

		List<?> enumTagResults = busModelEnumTagService.findAll();
		if (enumTagResults == null) {
			messages.append("Erroneously retrieved null for BusModelEnumTagService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + enumTagResults.size() + " entities from BusModel.EnumTag\n");
		}

		List<?> floatDefResults = busModelFloatDefService.findAll();
		if (floatDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelFloatDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + floatDefResults.size() + " entities from BusModel.FloatDef\n");
		}

		List<?> floatTypeResults = busModelFloatTypeService.findAll();
		if (floatTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelFloatTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + floatTypeResults.size() + " entities from BusModel.FloatType\n");
		}

		List<?> indexResults = busModelIndexService.findAll();
		if (indexResults == null) {
			messages.append("Erroneously retrieved null for BusModelIndexService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + indexResults.size() + " entities from BusModel.Index\n");
		}

		List<?> indexColResults = busModelIndexColService.findAll();
		if (indexColResults == null) {
			messages.append("Erroneously retrieved null for BusModelIndexColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + indexColResults.size() + " entities from BusModel.IndexCol\n");
		}

		List<?> int16DefResults = busModelInt16DefService.findAll();
		if (int16DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelInt16DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int16DefResults.size() + " entities from BusModel.Int16Def\n");
		}

		List<?> int16TypeResults = busModelInt16TypeService.findAll();
		if (int16TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelInt16TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int16TypeResults.size() + " entities from BusModel.Int16Type\n");
		}

		List<?> int32DefResults = busModelInt32DefService.findAll();
		if (int32DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelInt32DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int32DefResults.size() + " entities from BusModel.Int32Def\n");
		}

		List<?> int32TypeResults = busModelInt32TypeService.findAll();
		if (int32TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelInt32TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int32TypeResults.size() + " entities from BusModel.Int32Type\n");
		}

		List<?> int64DefResults = busModelInt64DefService.findAll();
		if (int64DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelInt64DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int64DefResults.size() + " entities from BusModel.Int64Def\n");
		}

		List<?> int64TypeResults = busModelInt64TypeService.findAll();
		if (int64TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelInt64TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int64TypeResults.size() + " entities from BusModel.Int64Type\n");
		}

		List<?> nmTokenDefResults = busModelNmTokenDefService.findAll();
		if (nmTokenDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelNmTokenDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokenDefResults.size() + " entities from BusModel.NmTokenDef\n");
		}

		List<?> nmTokenTypeResults = busModelNmTokenTypeService.findAll();
		if (nmTokenTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelNmTokenTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokenTypeResults.size() + " entities from BusModel.NmTokenType\n");
		}

		List<?> nmTokensDefResults = busModelNmTokensDefService.findAll();
		if (nmTokensDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelNmTokensDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokensDefResults.size() + " entities from BusModel.NmTokensDef\n");
		}

		List<?> nmTokensTypeResults = busModelNmTokensTypeService.findAll();
		if (nmTokensTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelNmTokensTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokensTypeResults.size() + " entities from BusModel.NmTokensType\n");
		}

		List<?> numberDefResults = busModelNumberDefService.findAll();
		if (numberDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelNumberDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + numberDefResults.size() + " entities from BusModel.NumberDef\n");
		}

		List<?> numberTypeResults = busModelNumberTypeService.findAll();
		if (numberTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelNumberTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + numberTypeResults.size() + " entities from BusModel.NumberType\n");
		}

		List<?> paramResults = busModelParamService.findAll();
		if (paramResults == null) {
			messages.append("Erroneously retrieved null for BusModelParamService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + paramResults.size() + " entities from BusModel.Param\n");
		}

		List<?> popDepResults = busModelPopDepService.findAll();
		if (popDepResults == null) {
			messages.append("Erroneously retrieved null for BusModelPopDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popDepResults.size() + " entities from BusModel.PopDep\n");
		}

		List<?> popSubDep1Results = busModelPopSubDep1Service.findAll();
		if (popSubDep1Results == null) {
			messages.append("Erroneously retrieved null for BusModelPopSubDep1Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popSubDep1Results.size() + " entities from BusModel.PopSubDep1\n");
		}

		List<?> popSubDep2Results = busModelPopSubDep2Service.findAll();
		if (popSubDep2Results == null) {
			messages.append("Erroneously retrieved null for BusModelPopSubDep2Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popSubDep2Results.size() + " entities from BusModel.PopSubDep2\n");
		}

		List<?> popSubDep3Results = busModelPopSubDep3Service.findAll();
		if (popSubDep3Results == null) {
			messages.append("Erroneously retrieved null for BusModelPopSubDep3Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popSubDep3Results.size() + " entities from BusModel.PopSubDep3\n");
		}

		List<?> popTopDepResults = busModelPopTopDepService.findAll();
		if (popTopDepResults == null) {
			messages.append("Erroneously retrieved null for BusModelPopTopDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popTopDepResults.size() + " entities from BusModel.PopTopDep\n");
		}

		List<?> relationResults = busModelRelationService.findAll();
		if (relationResults == null) {
			messages.append("Erroneously retrieved null for BusModelRelationService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + relationResults.size() + " entities from BusModel.Relation\n");
		}

		List<?> relationColResults = busModelRelationColService.findAll();
		if (relationColResults == null) {
			messages.append("Erroneously retrieved null for BusModelRelationColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + relationColResults.size() + " entities from BusModel.RelationCol\n");
		}

		List<?> serverListFuncResults = busModelServerListFuncService.findAll();
		if (serverListFuncResults == null) {
			messages.append("Erroneously retrieved null for BusModelServerListFuncService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + serverListFuncResults.size() + " entities from BusModel.ServerListFunc\n");
		}

		List<?> dbKeyHash128DefResults = busModelDbKeyHash128DefService.findAll();
		if (dbKeyHash128DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash128DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128DefResults.size() + " entities from BusModel.DbKeyHash128Def\n");
		}

		List<?> dbKeyHash128ColResults = busModelDbKeyHash128ColService.findAll();
		if (dbKeyHash128ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash128ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128ColResults.size() + " entities from BusModel.DbKeyHash128Col\n");
		}

		List<?> dbKeyHash128TypeResults = busModelDbKeyHash128TypeService.findAll();
		if (dbKeyHash128TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash128TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128TypeResults.size() + " entities from BusModel.DbKeyHash128Type\n");
		}

		List<?> dbKeyHash128GenResults = busModelDbKeyHash128GenService.findAll();
		if (dbKeyHash128GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash128GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128GenResults.size() + " entities from BusModel.DbKeyHash128Gen\n");
		}

		List<?> dbKeyHash160DefResults = busModelDbKeyHash160DefService.findAll();
		if (dbKeyHash160DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash160DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160DefResults.size() + " entities from BusModel.DbKeyHash160Def\n");
		}

		List<?> dbKeyHash160ColResults = busModelDbKeyHash160ColService.findAll();
		if (dbKeyHash160ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash160ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160ColResults.size() + " entities from BusModel.DbKeyHash160Col\n");
		}

		List<?> dbKeyHash160TypeResults = busModelDbKeyHash160TypeService.findAll();
		if (dbKeyHash160TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash160TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160TypeResults.size() + " entities from BusModel.DbKeyHash160Type\n");
		}

		List<?> dbKeyHash160GenResults = busModelDbKeyHash160GenService.findAll();
		if (dbKeyHash160GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash160GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160GenResults.size() + " entities from BusModel.DbKeyHash160Gen\n");
		}

		List<?> dbKeyHash224DefResults = busModelDbKeyHash224DefService.findAll();
		if (dbKeyHash224DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash224DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224DefResults.size() + " entities from BusModel.DbKeyHash224Def\n");
		}

		List<?> dbKeyHash224ColResults = busModelDbKeyHash224ColService.findAll();
		if (dbKeyHash224ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash224ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224ColResults.size() + " entities from BusModel.DbKeyHash224Col\n");
		}

		List<?> dbKeyHash224TypeResults = busModelDbKeyHash224TypeService.findAll();
		if (dbKeyHash224TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash224TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224TypeResults.size() + " entities from BusModel.DbKeyHash224Type\n");
		}

		List<?> dbKeyHash224GenResults = busModelDbKeyHash224GenService.findAll();
		if (dbKeyHash224GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash224GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224GenResults.size() + " entities from BusModel.DbKeyHash224Gen\n");
		}

		List<?> dbKeyHash256DefResults = busModelDbKeyHash256DefService.findAll();
		if (dbKeyHash256DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash256DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256DefResults.size() + " entities from BusModel.DbKeyHash256Def\n");
		}

		List<?> dbKeyHash256ColResults = busModelDbKeyHash256ColService.findAll();
		if (dbKeyHash256ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash256ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256ColResults.size() + " entities from BusModel.DbKeyHash256Col\n");
		}

		List<?> dbKeyHash256TypeResults = busModelDbKeyHash256TypeService.findAll();
		if (dbKeyHash256TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash256TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256TypeResults.size() + " entities from BusModel.DbKeyHash256Type\n");
		}

		List<?> dbKeyHash256GenResults = busModelDbKeyHash256GenService.findAll();
		if (dbKeyHash256GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash256GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256GenResults.size() + " entities from BusModel.DbKeyHash256Gen\n");
		}

		List<?> dbKeyHash384DefResults = busModelDbKeyHash384DefService.findAll();
		if (dbKeyHash384DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash384DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384DefResults.size() + " entities from BusModel.DbKeyHash384Def\n");
		}

		List<?> dbKeyHash384ColResults = busModelDbKeyHash384ColService.findAll();
		if (dbKeyHash384ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash384ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384ColResults.size() + " entities from BusModel.DbKeyHash384Col\n");
		}

		List<?> dbKeyHash384TypeResults = busModelDbKeyHash384TypeService.findAll();
		if (dbKeyHash384TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash384TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384TypeResults.size() + " entities from BusModel.DbKeyHash384Type\n");
		}

		List<?> dbKeyHash384GenResults = busModelDbKeyHash384GenService.findAll();
		if (dbKeyHash384GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash384GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384GenResults.size() + " entities from BusModel.DbKeyHash384Gen\n");
		}

		List<?> dbKeyHash512DefResults = busModelDbKeyHash512DefService.findAll();
		if (dbKeyHash512DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash512DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512DefResults.size() + " entities from BusModel.DbKeyHash512Def\n");
		}

		List<?> dbKeyHash512ColResults = busModelDbKeyHash512ColService.findAll();
		if (dbKeyHash512ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash512ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512ColResults.size() + " entities from BusModel.DbKeyHash512Col\n");
		}

		List<?> dbKeyHash512TypeResults = busModelDbKeyHash512TypeService.findAll();
		if (dbKeyHash512TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash512TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512TypeResults.size() + " entities from BusModel.DbKeyHash512Type\n");
		}

		List<?> dbKeyHash512GenResults = busModelDbKeyHash512GenService.findAll();
		if (dbKeyHash512GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelDbKeyHash512GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512GenResults.size() + " entities from BusModel.DbKeyHash512Gen\n");
		}

		List<?> stringDefResults = busModelStringDefService.findAll();
		if (stringDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelStringDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + stringDefResults.size() + " entities from BusModel.StringDef\n");
		}

		List<?> stringTypeResults = busModelStringTypeService.findAll();
		if (stringTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelStringTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + stringTypeResults.size() + " entities from BusModel.StringType\n");
		}

		List<?> tZDateDefResults = busModelTZDateDefService.findAll();
		if (tZDateDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelTZDateDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZDateDefResults.size() + " entities from BusModel.TZDateDef\n");
		}

		List<?> tZDateTypeResults = busModelTZDateTypeService.findAll();
		if (tZDateTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelTZDateTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZDateTypeResults.size() + " entities from BusModel.TZDateType\n");
		}

		List<?> tZTimeDefResults = busModelTZTimeDefService.findAll();
		if (tZTimeDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelTZTimeDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimeDefResults.size() + " entities from BusModel.TZTimeDef\n");
		}

		List<?> tZTimeTypeResults = busModelTZTimeTypeService.findAll();
		if (tZTimeTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelTZTimeTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimeTypeResults.size() + " entities from BusModel.TZTimeType\n");
		}

		List<?> tZTimestampDefResults = busModelTZTimestampDefService.findAll();
		if (tZTimestampDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelTZTimestampDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampDefResults.size() + " entities from BusModel.TZTimestampDef\n");
		}

		List<?> tZTimestampTypeResults = busModelTZTimestampTypeService.findAll();
		if (tZTimestampTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelTZTimestampTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampTypeResults.size() + " entities from BusModel.TZTimestampType\n");
		}

		List<?> tableColResults = busModelTableColService.findAll();
		if (tableColResults == null) {
			messages.append("Erroneously retrieved null for BusModelTableColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tableColResults.size() + " entities from BusModel.TableCol\n");
		}

		List<?> textDefResults = busModelTextDefService.findAll();
		if (textDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelTextDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + textDefResults.size() + " entities from BusModel.TextDef\n");
		}

		List<?> textTypeResults = busModelTextTypeService.findAll();
		if (textTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelTextTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + textTypeResults.size() + " entities from BusModel.TextType\n");
		}

		List<?> timeDefResults = busModelTimeDefService.findAll();
		if (timeDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelTimeDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timeDefResults.size() + " entities from BusModel.TimeDef\n");
		}

		List<?> timeTypeResults = busModelTimeTypeService.findAll();
		if (timeTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelTimeTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timeTypeResults.size() + " entities from BusModel.TimeType\n");
		}

		List<?> timestampDefResults = busModelTimestampDefService.findAll();
		if (timestampDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelTimestampDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timestampDefResults.size() + " entities from BusModel.TimestampDef\n");
		}

		List<?> timestampTypeResults = busModelTimestampTypeService.findAll();
		if (timestampTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelTimestampTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timestampTypeResults.size() + " entities from BusModel.TimestampType\n");
		}

		List<?> tokenDefResults = busModelTokenDefService.findAll();
		if (tokenDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelTokenDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tokenDefResults.size() + " entities from BusModel.TokenDef\n");
		}

		List<?> tokenTypeResults = busModelTokenTypeService.findAll();
		if (tokenTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelTokenTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tokenTypeResults.size() + " entities from BusModel.TokenType\n");
		}

		List<?> uInt16DefResults = busModelUInt16DefService.findAll();
		if (uInt16DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelUInt16DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt16DefResults.size() + " entities from BusModel.UInt16Def\n");
		}

		List<?> uInt16TypeResults = busModelUInt16TypeService.findAll();
		if (uInt16TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelUInt16TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt16TypeResults.size() + " entities from BusModel.UInt16Type\n");
		}

		List<?> uInt32DefResults = busModelUInt32DefService.findAll();
		if (uInt32DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelUInt32DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt32DefResults.size() + " entities from BusModel.UInt32Def\n");
		}

		List<?> uInt32TypeResults = busModelUInt32TypeService.findAll();
		if (uInt32TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelUInt32TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt32TypeResults.size() + " entities from BusModel.UInt32Type\n");
		}

		List<?> uInt64DefResults = busModelUInt64DefService.findAll();
		if (uInt64DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelUInt64DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt64DefResults.size() + " entities from BusModel.UInt64Def\n");
		}

		List<?> uInt64TypeResults = busModelUInt64TypeService.findAll();
		if (uInt64TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelUInt64TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt64TypeResults.size() + " entities from BusModel.UInt64Type\n");
		}

		List<?> uuidDefResults = busModelUuidDefService.findAll();
		if (uuidDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelUuidDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuidDefResults.size() + " entities from BusModel.UuidDef\n");
		}

		List<?> uuid6DefResults = busModelUuid6DefService.findAll();
		if (uuid6DefResults == null) {
			messages.append("Erroneously retrieved null for BusModelUuid6DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuid6DefResults.size() + " entities from BusModel.Uuid6Def\n");
		}

		List<?> uuidTypeResults = busModelUuidTypeService.findAll();
		if (uuidTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelUuidTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuidTypeResults.size() + " entities from BusModel.UuidType\n");
		}

		List<?> uuid6TypeResults = busModelUuid6TypeService.findAll();
		if (uuid6TypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelUuid6TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuid6TypeResults.size() + " entities from BusModel.Uuid6Type\n");
		}

		List<?> blobColResults = busModelBlobColService.findAll();
		if (blobColResults == null) {
			messages.append("Erroneously retrieved null for BusModelBlobColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + blobColResults.size() + " entities from BusModel.BlobCol\n");
		}

		List<?> boolColResults = busModelBoolColService.findAll();
		if (boolColResults == null) {
			messages.append("Erroneously retrieved null for BusModelBoolColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + boolColResults.size() + " entities from BusModel.BoolCol\n");
		}

		List<?> dateColResults = busModelDateColService.findAll();
		if (dateColResults == null) {
			messages.append("Erroneously retrieved null for BusModelDateColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dateColResults.size() + " entities from BusModel.DateCol\n");
		}

		List<?> doubleColResults = busModelDoubleColService.findAll();
		if (doubleColResults == null) {
			messages.append("Erroneously retrieved null for BusModelDoubleColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + doubleColResults.size() + " entities from BusModel.DoubleCol\n");
		}

		List<?> enumDefResults = busModelEnumDefService.findAll();
		if (enumDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelEnumDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + enumDefResults.size() + " entities from BusModel.EnumDef\n");
		}

		List<?> enumTypeResults = busModelEnumTypeService.findAll();
		if (enumTypeResults == null) {
			messages.append("Erroneously retrieved null for BusModelEnumTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + enumTypeResults.size() + " entities from BusModel.EnumType\n");
		}

		List<?> floatColResults = busModelFloatColService.findAll();
		if (floatColResults == null) {
			messages.append("Erroneously retrieved null for BusModelFloatColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + floatColResults.size() + " entities from BusModel.FloatCol\n");
		}

		List<?> id16GenResults = busModelId16GenService.findAll();
		if (id16GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelId16GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + id16GenResults.size() + " entities from BusModel.Id16Gen\n");
		}

		List<?> id32GenResults = busModelId32GenService.findAll();
		if (id32GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelId32GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + id32GenResults.size() + " entities from BusModel.Id32Gen\n");
		}

		List<?> id64GenResults = busModelId64GenService.findAll();
		if (id64GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelId64GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + id64GenResults.size() + " entities from BusModel.Id64Gen\n");
		}

		List<?> int16ColResults = busModelInt16ColService.findAll();
		if (int16ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelInt16ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int16ColResults.size() + " entities from BusModel.Int16Col\n");
		}

		List<?> int32ColResults = busModelInt32ColService.findAll();
		if (int32ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelInt32ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int32ColResults.size() + " entities from BusModel.Int32Col\n");
		}

		List<?> int64ColResults = busModelInt64ColService.findAll();
		if (int64ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelInt64ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int64ColResults.size() + " entities from BusModel.Int64Col\n");
		}

		List<?> nmTokenColResults = busModelNmTokenColService.findAll();
		if (nmTokenColResults == null) {
			messages.append("Erroneously retrieved null for BusModelNmTokenColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokenColResults.size() + " entities from BusModel.NmTokenCol\n");
		}

		List<?> nmTokensColResults = busModelNmTokensColService.findAll();
		if (nmTokensColResults == null) {
			messages.append("Erroneously retrieved null for BusModelNmTokensColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokensColResults.size() + " entities from BusModel.NmTokensCol\n");
		}

		List<?> numberColResults = busModelNumberColService.findAll();
		if (numberColResults == null) {
			messages.append("Erroneously retrieved null for BusModelNumberColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + numberColResults.size() + " entities from BusModel.NumberCol\n");
		}

		List<?> stringColResults = busModelStringColService.findAll();
		if (stringColResults == null) {
			messages.append("Erroneously retrieved null for BusModelStringColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + stringColResults.size() + " entities from BusModel.StringCol\n");
		}

		List<?> tZDateColResults = busModelTZDateColService.findAll();
		if (tZDateColResults == null) {
			messages.append("Erroneously retrieved null for BusModelTZDateColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZDateColResults.size() + " entities from BusModel.TZDateCol\n");
		}

		List<?> tZTimeColResults = busModelTZTimeColService.findAll();
		if (tZTimeColResults == null) {
			messages.append("Erroneously retrieved null for BusModelTZTimeColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimeColResults.size() + " entities from BusModel.TZTimeCol\n");
		}

		List<?> tZTimestampColResults = busModelTZTimestampColService.findAll();
		if (tZTimestampColResults == null) {
			messages.append("Erroneously retrieved null for BusModelTZTimestampColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampColResults.size() + " entities from BusModel.TZTimestampCol\n");
		}

		List<?> textColResults = busModelTextColService.findAll();
		if (textColResults == null) {
			messages.append("Erroneously retrieved null for BusModelTextColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + textColResults.size() + " entities from BusModel.TextCol\n");
		}

		List<?> timeColResults = busModelTimeColService.findAll();
		if (timeColResults == null) {
			messages.append("Erroneously retrieved null for BusModelTimeColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timeColResults.size() + " entities from BusModel.TimeCol\n");
		}

		List<?> timestampColResults = busModelTimestampColService.findAll();
		if (timestampColResults == null) {
			messages.append("Erroneously retrieved null for BusModelTimestampColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timestampColResults.size() + " entities from BusModel.TimestampCol\n");
		}

		List<?> tokenColResults = busModelTokenColService.findAll();
		if (tokenColResults == null) {
			messages.append("Erroneously retrieved null for BusModelTokenColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tokenColResults.size() + " entities from BusModel.TokenCol\n");
		}

		List<?> uInt16ColResults = busModelUInt16ColService.findAll();
		if (uInt16ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelUInt16ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt16ColResults.size() + " entities from BusModel.UInt16Col\n");
		}

		List<?> uInt32ColResults = busModelUInt32ColService.findAll();
		if (uInt32ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelUInt32ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt32ColResults.size() + " entities from BusModel.UInt32Col\n");
		}

		List<?> uInt64ColResults = busModelUInt64ColService.findAll();
		if (uInt64ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelUInt64ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt64ColResults.size() + " entities from BusModel.UInt64Col\n");
		}

		List<?> uuidColResults = busModelUuidColService.findAll();
		if (uuidColResults == null) {
			messages.append("Erroneously retrieved null for BusModelUuidColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuidColResults.size() + " entities from BusModel.UuidCol\n");
		}

		List<?> uuid6ColResults = busModelUuid6ColService.findAll();
		if (uuid6ColResults == null) {
			messages.append("Erroneously retrieved null for BusModelUuid6ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuid6ColResults.size() + " entities from BusModel.Uuid6Col\n");
		}

		List<?> uuidGenResults = busModelUuidGenService.findAll();
		if (uuidGenResults == null) {
			messages.append("Erroneously retrieved null for BusModelUuidGenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuidGenResults.size() + " entities from BusModel.UuidGen\n");
		}

		List<?> uuid6GenResults = busModelUuid6GenService.findAll();
		if (uuid6GenResults == null) {
			messages.append("Erroneously retrieved null for BusModelUuid6GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuid6GenResults.size() + " entities from BusModel.Uuid6Gen\n");
		}

		List<?> roleDefResults = busModelRoleDefService.findAll();
		if (roleDefResults == null) {
			messages.append("Erroneously retrieved null for BusModelRoleDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + roleDefResults.size() + " entities from BusModel.RoleDef\n");
		}

		List<?> schemaRoleResults = busModelSchemaRoleService.findAll();
		if (schemaRoleResults == null) {
			messages.append("Erroneously retrieved null for BusModelSchemaRoleService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + schemaRoleResults.size() + " entities from BusModel.SchemaRole\n");
		}

		messages.append("BusModel tests complete\n");
		return( messages.toString() );
	}
}
