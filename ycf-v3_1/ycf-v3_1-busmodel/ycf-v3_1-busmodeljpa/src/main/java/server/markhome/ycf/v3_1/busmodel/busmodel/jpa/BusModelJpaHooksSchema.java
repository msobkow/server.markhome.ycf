// Description: Java 25 Spring JPA Hooks for BusModel

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

import java.io.Serializable;
import java.math.*;
import java.net.InetAddress;
import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.jpa.*;

/**
 *	Hooks for schema BusModel Spring resources that need to be used by getter-wrappers for AtomicReference members of the multi-threaded wedge between Spring resources and POJO code.
 *	This implementation wraps the Spring singletons instantiated during Spring's boot process for the server.markhome.ycf.v3_1.busmodel.busmodel.jpa package.  It resolves all known standard Spring resources for the LocalContainerEntityManagerFactoryBean, SchemaService, IdGenService, and the BusModel*Repository and BusModel*Service singletons that the POJOs need to invoke.  However, it relies on late-initialization during dynamic instance creation (i.e. new BusModelJpaSchemaHooks()) instead of being initialized as a Spring singleton. As the Spring instance hierarchy is instantiated before any instances of this class are instantiated, the net result bridges the gap between POJO and Spring JPA.
 */
@Service("busmodel31JpaHooksSchema")
public class BusModelJpaHooksSchema {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaScopeRepository scopeRepository;

	@Autowired
	private BusModelJpaSchemaDefRepository schemaDefRepository;

	@Autowired
	private BusModelJpaSchemaRefRepository schemaRefRepository;

	@Autowired
	private BusModelJpaServerMethodRepository serverMethodRepository;

	@Autowired
	private BusModelJpaServerObjFuncRepository serverObjFuncRepository;

	@Autowired
	private BusModelJpaServerProcRepository serverProcRepository;

	@Autowired
	private BusModelJpaTableRepository tableRepository;

	@Autowired
	private BusModelJpaTweakRepository tweakRepository;

	@Autowired
	private BusModelJpaTableTweakRepository tableTweakRepository;

	@Autowired
	private BusModelJpaSchemaTweakRepository schemaTweakRepository;

	@Autowired
	private BusModelJpaIndexTweakRepository indexTweakRepository;

	@Autowired
	private BusModelJpaValueRepository valueRepository;

	@Autowired
	private BusModelJpaAtomRepository atomRepository;

	@Autowired
	private BusModelJpaBlobDefRepository blobDefRepository;

	@Autowired
	private BusModelJpaBlobTypeRepository blobTypeRepository;

	@Autowired
	private BusModelJpaBoolDefRepository boolDefRepository;

	@Autowired
	private BusModelJpaBoolTypeRepository boolTypeRepository;

	@Autowired
	private BusModelJpaChainRepository chainRepository;

	@Autowired
	private BusModelJpaClearDepRepository clearDepRepository;

	@Autowired
	private BusModelJpaClearSubDep1Repository clearSubDep1Repository;

	@Autowired
	private BusModelJpaClearSubDep2Repository clearSubDep2Repository;

	@Autowired
	private BusModelJpaClearSubDep3Repository clearSubDep3Repository;

	@Autowired
	private BusModelJpaClearTopDepRepository clearTopDepRepository;

	@Autowired
	private BusModelJpaDateDefRepository dateDefRepository;

	@Autowired
	private BusModelJpaDateTypeRepository dateTypeRepository;

	@Autowired
	private BusModelJpaDelDepRepository delDepRepository;

	@Autowired
	private BusModelJpaDelSubDep1Repository delSubDep1Repository;

	@Autowired
	private BusModelJpaDelSubDep2Repository delSubDep2Repository;

	@Autowired
	private BusModelJpaDelSubDep3Repository delSubDep3Repository;

	@Autowired
	private BusModelJpaDelTopDepRepository delTopDepRepository;

	@Autowired
	private BusModelJpaDoubleDefRepository doubleDefRepository;

	@Autowired
	private BusModelJpaDoubleTypeRepository doubleTypeRepository;

	@Autowired
	private BusModelJpaEnumTagRepository enumTagRepository;

	@Autowired
	private BusModelJpaFloatDefRepository floatDefRepository;

	@Autowired
	private BusModelJpaFloatTypeRepository floatTypeRepository;

	@Autowired
	private BusModelJpaIndexRepository indexRepository;

	@Autowired
	private BusModelJpaIndexColRepository indexColRepository;

	@Autowired
	private BusModelJpaInt16DefRepository int16DefRepository;

	@Autowired
	private BusModelJpaInt16TypeRepository int16TypeRepository;

	@Autowired
	private BusModelJpaInt32DefRepository int32DefRepository;

	@Autowired
	private BusModelJpaInt32TypeRepository int32TypeRepository;

	@Autowired
	private BusModelJpaInt64DefRepository int64DefRepository;

	@Autowired
	private BusModelJpaInt64TypeRepository int64TypeRepository;

	@Autowired
	private BusModelJpaNmTokenDefRepository nmTokenDefRepository;

	@Autowired
	private BusModelJpaNmTokenTypeRepository nmTokenTypeRepository;

	@Autowired
	private BusModelJpaNmTokensDefRepository nmTokensDefRepository;

	@Autowired
	private BusModelJpaNmTokensTypeRepository nmTokensTypeRepository;

	@Autowired
	private BusModelJpaNumberDefRepository numberDefRepository;

	@Autowired
	private BusModelJpaNumberTypeRepository numberTypeRepository;

	@Autowired
	private BusModelJpaParamRepository paramRepository;

	@Autowired
	private BusModelJpaPopDepRepository popDepRepository;

	@Autowired
	private BusModelJpaPopSubDep1Repository popSubDep1Repository;

	@Autowired
	private BusModelJpaPopSubDep2Repository popSubDep2Repository;

	@Autowired
	private BusModelJpaPopSubDep3Repository popSubDep3Repository;

	@Autowired
	private BusModelJpaPopTopDepRepository popTopDepRepository;

	@Autowired
	private BusModelJpaRelationRepository relationRepository;

	@Autowired
	private BusModelJpaRelationColRepository relationColRepository;

	@Autowired
	private BusModelJpaServerListFuncRepository serverListFuncRepository;

	@Autowired
	private BusModelJpaDbKeyHash128DefRepository dbKeyHash128DefRepository;

	@Autowired
	private BusModelJpaDbKeyHash128ColRepository dbKeyHash128ColRepository;

	@Autowired
	private BusModelJpaDbKeyHash128TypeRepository dbKeyHash128TypeRepository;

	@Autowired
	private BusModelJpaDbKeyHash128GenRepository dbKeyHash128GenRepository;

	@Autowired
	private BusModelJpaDbKeyHash160DefRepository dbKeyHash160DefRepository;

	@Autowired
	private BusModelJpaDbKeyHash160ColRepository dbKeyHash160ColRepository;

	@Autowired
	private BusModelJpaDbKeyHash160TypeRepository dbKeyHash160TypeRepository;

	@Autowired
	private BusModelJpaDbKeyHash160GenRepository dbKeyHash160GenRepository;

	@Autowired
	private BusModelJpaDbKeyHash224DefRepository dbKeyHash224DefRepository;

	@Autowired
	private BusModelJpaDbKeyHash224ColRepository dbKeyHash224ColRepository;

	@Autowired
	private BusModelJpaDbKeyHash224TypeRepository dbKeyHash224TypeRepository;

	@Autowired
	private BusModelJpaDbKeyHash224GenRepository dbKeyHash224GenRepository;

	@Autowired
	private BusModelJpaDbKeyHash256DefRepository dbKeyHash256DefRepository;

	@Autowired
	private BusModelJpaDbKeyHash256ColRepository dbKeyHash256ColRepository;

	@Autowired
	private BusModelJpaDbKeyHash256TypeRepository dbKeyHash256TypeRepository;

	@Autowired
	private BusModelJpaDbKeyHash256GenRepository dbKeyHash256GenRepository;

	@Autowired
	private BusModelJpaDbKeyHash384DefRepository dbKeyHash384DefRepository;

	@Autowired
	private BusModelJpaDbKeyHash384ColRepository dbKeyHash384ColRepository;

	@Autowired
	private BusModelJpaDbKeyHash384TypeRepository dbKeyHash384TypeRepository;

	@Autowired
	private BusModelJpaDbKeyHash384GenRepository dbKeyHash384GenRepository;

	@Autowired
	private BusModelJpaDbKeyHash512DefRepository dbKeyHash512DefRepository;

	@Autowired
	private BusModelJpaDbKeyHash512ColRepository dbKeyHash512ColRepository;

	@Autowired
	private BusModelJpaDbKeyHash512TypeRepository dbKeyHash512TypeRepository;

	@Autowired
	private BusModelJpaDbKeyHash512GenRepository dbKeyHash512GenRepository;

	@Autowired
	private BusModelJpaStringDefRepository stringDefRepository;

	@Autowired
	private BusModelJpaStringTypeRepository stringTypeRepository;

	@Autowired
	private BusModelJpaTZDateDefRepository tZDateDefRepository;

	@Autowired
	private BusModelJpaTZDateTypeRepository tZDateTypeRepository;

	@Autowired
	private BusModelJpaTZTimeDefRepository tZTimeDefRepository;

	@Autowired
	private BusModelJpaTZTimeTypeRepository tZTimeTypeRepository;

	@Autowired
	private BusModelJpaTZTimestampDefRepository tZTimestampDefRepository;

	@Autowired
	private BusModelJpaTZTimestampTypeRepository tZTimestampTypeRepository;

	@Autowired
	private BusModelJpaTableColRepository tableColRepository;

	@Autowired
	private BusModelJpaTextDefRepository textDefRepository;

	@Autowired
	private BusModelJpaTextTypeRepository textTypeRepository;

	@Autowired
	private BusModelJpaTimeDefRepository timeDefRepository;

	@Autowired
	private BusModelJpaTimeTypeRepository timeTypeRepository;

	@Autowired
	private BusModelJpaTimestampDefRepository timestampDefRepository;

	@Autowired
	private BusModelJpaTimestampTypeRepository timestampTypeRepository;

	@Autowired
	private BusModelJpaTokenDefRepository tokenDefRepository;

	@Autowired
	private BusModelJpaTokenTypeRepository tokenTypeRepository;

	@Autowired
	private BusModelJpaUInt16DefRepository uInt16DefRepository;

	@Autowired
	private BusModelJpaUInt16TypeRepository uInt16TypeRepository;

	@Autowired
	private BusModelJpaUInt32DefRepository uInt32DefRepository;

	@Autowired
	private BusModelJpaUInt32TypeRepository uInt32TypeRepository;

	@Autowired
	private BusModelJpaUInt64DefRepository uInt64DefRepository;

	@Autowired
	private BusModelJpaUInt64TypeRepository uInt64TypeRepository;

	@Autowired
	private BusModelJpaUuidDefRepository uuidDefRepository;

	@Autowired
	private BusModelJpaUuid6DefRepository uuid6DefRepository;

	@Autowired
	private BusModelJpaUuidTypeRepository uuidTypeRepository;

	@Autowired
	private BusModelJpaUuid6TypeRepository uuid6TypeRepository;

	@Autowired
	private BusModelJpaBlobColRepository blobColRepository;

	@Autowired
	private BusModelJpaBoolColRepository boolColRepository;

	@Autowired
	private BusModelJpaDateColRepository dateColRepository;

	@Autowired
	private BusModelJpaDoubleColRepository doubleColRepository;

	@Autowired
	private BusModelJpaEnumDefRepository enumDefRepository;

	@Autowired
	private BusModelJpaEnumTypeRepository enumTypeRepository;

	@Autowired
	private BusModelJpaFloatColRepository floatColRepository;

	@Autowired
	private BusModelJpaId16GenRepository id16GenRepository;

	@Autowired
	private BusModelJpaId32GenRepository id32GenRepository;

	@Autowired
	private BusModelJpaId64GenRepository id64GenRepository;

	@Autowired
	private BusModelJpaInt16ColRepository int16ColRepository;

	@Autowired
	private BusModelJpaInt32ColRepository int32ColRepository;

	@Autowired
	private BusModelJpaInt64ColRepository int64ColRepository;

	@Autowired
	private BusModelJpaNmTokenColRepository nmTokenColRepository;

	@Autowired
	private BusModelJpaNmTokensColRepository nmTokensColRepository;

	@Autowired
	private BusModelJpaNumberColRepository numberColRepository;

	@Autowired
	private BusModelJpaStringColRepository stringColRepository;

	@Autowired
	private BusModelJpaTZDateColRepository tZDateColRepository;

	@Autowired
	private BusModelJpaTZTimeColRepository tZTimeColRepository;

	@Autowired
	private BusModelJpaTZTimestampColRepository tZTimestampColRepository;

	@Autowired
	private BusModelJpaTextColRepository textColRepository;

	@Autowired
	private BusModelJpaTimeColRepository timeColRepository;

	@Autowired
	private BusModelJpaTimestampColRepository timestampColRepository;

	@Autowired
	private BusModelJpaTokenColRepository tokenColRepository;

	@Autowired
	private BusModelJpaUInt16ColRepository uInt16ColRepository;

	@Autowired
	private BusModelJpaUInt32ColRepository uInt32ColRepository;

	@Autowired
	private BusModelJpaUInt64ColRepository uInt64ColRepository;

	@Autowired
	private BusModelJpaUuidColRepository uuidColRepository;

	@Autowired
	private BusModelJpaUuid6ColRepository uuid6ColRepository;

	@Autowired
	private BusModelJpaUuidGenRepository uuidGenRepository;

	@Autowired
	private BusModelJpaUuid6GenRepository uuid6GenRepository;

	@Autowired
	private BusModelJpaRoleDefRepository roleDefRepository;

	@Autowired
	private BusModelJpaSchemaRoleRepository schemaRoleRepository;

	@Autowired
	@Qualifier("busmodel31JpaSchemaService")
	private BusModelJpaSchemaService schemaService;

	@Autowired
	@Qualifier("busmodel31JpaFactory")
	private BusModelJpaFactoryService factoryService;

	@Autowired
	@Qualifier("BusModel31JpaIdGenService")
	private BusModelJpaIdGenService idGenService;

	@Autowired
	@Qualifier("busmodel31JpaScopeService")
	private BusModelJpaScopeService scopeService;

	@Autowired
	@Qualifier("busmodel31JpaSchemaDefService")
	private BusModelJpaSchemaDefService schemaDefService;

	@Autowired
	@Qualifier("busmodel31JpaSchemaRefService")
	private BusModelJpaSchemaRefService schemaRefService;

	@Autowired
	@Qualifier("busmodel31JpaServerMethodService")
	private BusModelJpaServerMethodService serverMethodService;

	@Autowired
	@Qualifier("busmodel31JpaServerObjFuncService")
	private BusModelJpaServerObjFuncService serverObjFuncService;

	@Autowired
	@Qualifier("busmodel31JpaServerProcService")
	private BusModelJpaServerProcService serverProcService;

	@Autowired
	@Qualifier("busmodel31JpaTableService")
	private BusModelJpaTableService tableService;

	@Autowired
	@Qualifier("busmodel31JpaTweakService")
	private BusModelJpaTweakService tweakService;

	@Autowired
	@Qualifier("busmodel31JpaTableTweakService")
	private BusModelJpaTableTweakService tableTweakService;

	@Autowired
	@Qualifier("busmodel31JpaSchemaTweakService")
	private BusModelJpaSchemaTweakService schemaTweakService;

	@Autowired
	@Qualifier("busmodel31JpaIndexTweakService")
	private BusModelJpaIndexTweakService indexTweakService;

	@Autowired
	@Qualifier("busmodel31JpaValueService")
	private BusModelJpaValueService valueService;

	@Autowired
	@Qualifier("busmodel31JpaAtomService")
	private BusModelJpaAtomService atomService;

	@Autowired
	@Qualifier("busmodel31JpaBlobDefService")
	private BusModelJpaBlobDefService blobDefService;

	@Autowired
	@Qualifier("busmodel31JpaBlobTypeService")
	private BusModelJpaBlobTypeService blobTypeService;

	@Autowired
	@Qualifier("busmodel31JpaBoolDefService")
	private BusModelJpaBoolDefService boolDefService;

	@Autowired
	@Qualifier("busmodel31JpaBoolTypeService")
	private BusModelJpaBoolTypeService boolTypeService;

	@Autowired
	@Qualifier("busmodel31JpaChainService")
	private BusModelJpaChainService chainService;

	@Autowired
	@Qualifier("busmodel31JpaClearDepService")
	private BusModelJpaClearDepService clearDepService;

	@Autowired
	@Qualifier("busmodel31JpaClearSubDep1Service")
	private BusModelJpaClearSubDep1Service clearSubDep1Service;

	@Autowired
	@Qualifier("busmodel31JpaClearSubDep2Service")
	private BusModelJpaClearSubDep2Service clearSubDep2Service;

	@Autowired
	@Qualifier("busmodel31JpaClearSubDep3Service")
	private BusModelJpaClearSubDep3Service clearSubDep3Service;

	@Autowired
	@Qualifier("busmodel31JpaClearTopDepService")
	private BusModelJpaClearTopDepService clearTopDepService;

	@Autowired
	@Qualifier("busmodel31JpaDateDefService")
	private BusModelJpaDateDefService dateDefService;

	@Autowired
	@Qualifier("busmodel31JpaDateTypeService")
	private BusModelJpaDateTypeService dateTypeService;

	@Autowired
	@Qualifier("busmodel31JpaDelDepService")
	private BusModelJpaDelDepService delDepService;

	@Autowired
	@Qualifier("busmodel31JpaDelSubDep1Service")
	private BusModelJpaDelSubDep1Service delSubDep1Service;

	@Autowired
	@Qualifier("busmodel31JpaDelSubDep2Service")
	private BusModelJpaDelSubDep2Service delSubDep2Service;

	@Autowired
	@Qualifier("busmodel31JpaDelSubDep3Service")
	private BusModelJpaDelSubDep3Service delSubDep3Service;

	@Autowired
	@Qualifier("busmodel31JpaDelTopDepService")
	private BusModelJpaDelTopDepService delTopDepService;

	@Autowired
	@Qualifier("busmodel31JpaDoubleDefService")
	private BusModelJpaDoubleDefService doubleDefService;

	@Autowired
	@Qualifier("busmodel31JpaDoubleTypeService")
	private BusModelJpaDoubleTypeService doubleTypeService;

	@Autowired
	@Qualifier("busmodel31JpaEnumTagService")
	private BusModelJpaEnumTagService enumTagService;

	@Autowired
	@Qualifier("busmodel31JpaFloatDefService")
	private BusModelJpaFloatDefService floatDefService;

	@Autowired
	@Qualifier("busmodel31JpaFloatTypeService")
	private BusModelJpaFloatTypeService floatTypeService;

	@Autowired
	@Qualifier("busmodel31JpaIndexService")
	private BusModelJpaIndexService indexService;

	@Autowired
	@Qualifier("busmodel31JpaIndexColService")
	private BusModelJpaIndexColService indexColService;

	@Autowired
	@Qualifier("busmodel31JpaInt16DefService")
	private BusModelJpaInt16DefService int16DefService;

	@Autowired
	@Qualifier("busmodel31JpaInt16TypeService")
	private BusModelJpaInt16TypeService int16TypeService;

	@Autowired
	@Qualifier("busmodel31JpaInt32DefService")
	private BusModelJpaInt32DefService int32DefService;

	@Autowired
	@Qualifier("busmodel31JpaInt32TypeService")
	private BusModelJpaInt32TypeService int32TypeService;

	@Autowired
	@Qualifier("busmodel31JpaInt64DefService")
	private BusModelJpaInt64DefService int64DefService;

	@Autowired
	@Qualifier("busmodel31JpaInt64TypeService")
	private BusModelJpaInt64TypeService int64TypeService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokenDefService")
	private BusModelJpaNmTokenDefService nmTokenDefService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokenTypeService")
	private BusModelJpaNmTokenTypeService nmTokenTypeService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokensDefService")
	private BusModelJpaNmTokensDefService nmTokensDefService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokensTypeService")
	private BusModelJpaNmTokensTypeService nmTokensTypeService;

	@Autowired
	@Qualifier("busmodel31JpaNumberDefService")
	private BusModelJpaNumberDefService numberDefService;

	@Autowired
	@Qualifier("busmodel31JpaNumberTypeService")
	private BusModelJpaNumberTypeService numberTypeService;

	@Autowired
	@Qualifier("busmodel31JpaParamService")
	private BusModelJpaParamService paramService;

	@Autowired
	@Qualifier("busmodel31JpaPopDepService")
	private BusModelJpaPopDepService popDepService;

	@Autowired
	@Qualifier("busmodel31JpaPopSubDep1Service")
	private BusModelJpaPopSubDep1Service popSubDep1Service;

	@Autowired
	@Qualifier("busmodel31JpaPopSubDep2Service")
	private BusModelJpaPopSubDep2Service popSubDep2Service;

	@Autowired
	@Qualifier("busmodel31JpaPopSubDep3Service")
	private BusModelJpaPopSubDep3Service popSubDep3Service;

	@Autowired
	@Qualifier("busmodel31JpaPopTopDepService")
	private BusModelJpaPopTopDepService popTopDepService;

	@Autowired
	@Qualifier("busmodel31JpaRelationService")
	private BusModelJpaRelationService relationService;

	@Autowired
	@Qualifier("busmodel31JpaRelationColService")
	private BusModelJpaRelationColService relationColService;

	@Autowired
	@Qualifier("busmodel31JpaServerListFuncService")
	private BusModelJpaServerListFuncService serverListFuncService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash128DefService")
	private BusModelJpaDbKeyHash128DefService dbKeyHash128DefService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash128ColService")
	private BusModelJpaDbKeyHash128ColService dbKeyHash128ColService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash128TypeService")
	private BusModelJpaDbKeyHash128TypeService dbKeyHash128TypeService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash128GenService")
	private BusModelJpaDbKeyHash128GenService dbKeyHash128GenService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash160DefService")
	private BusModelJpaDbKeyHash160DefService dbKeyHash160DefService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash160ColService")
	private BusModelJpaDbKeyHash160ColService dbKeyHash160ColService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash160TypeService")
	private BusModelJpaDbKeyHash160TypeService dbKeyHash160TypeService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash160GenService")
	private BusModelJpaDbKeyHash160GenService dbKeyHash160GenService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash224DefService")
	private BusModelJpaDbKeyHash224DefService dbKeyHash224DefService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash224ColService")
	private BusModelJpaDbKeyHash224ColService dbKeyHash224ColService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash224TypeService")
	private BusModelJpaDbKeyHash224TypeService dbKeyHash224TypeService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash224GenService")
	private BusModelJpaDbKeyHash224GenService dbKeyHash224GenService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash256DefService")
	private BusModelJpaDbKeyHash256DefService dbKeyHash256DefService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash256ColService")
	private BusModelJpaDbKeyHash256ColService dbKeyHash256ColService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash256TypeService")
	private BusModelJpaDbKeyHash256TypeService dbKeyHash256TypeService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash256GenService")
	private BusModelJpaDbKeyHash256GenService dbKeyHash256GenService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash384DefService")
	private BusModelJpaDbKeyHash384DefService dbKeyHash384DefService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash384ColService")
	private BusModelJpaDbKeyHash384ColService dbKeyHash384ColService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash384TypeService")
	private BusModelJpaDbKeyHash384TypeService dbKeyHash384TypeService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash384GenService")
	private BusModelJpaDbKeyHash384GenService dbKeyHash384GenService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash512DefService")
	private BusModelJpaDbKeyHash512DefService dbKeyHash512DefService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash512ColService")
	private BusModelJpaDbKeyHash512ColService dbKeyHash512ColService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash512TypeService")
	private BusModelJpaDbKeyHash512TypeService dbKeyHash512TypeService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash512GenService")
	private BusModelJpaDbKeyHash512GenService dbKeyHash512GenService;

	@Autowired
	@Qualifier("busmodel31JpaStringDefService")
	private BusModelJpaStringDefService stringDefService;

	@Autowired
	@Qualifier("busmodel31JpaStringTypeService")
	private BusModelJpaStringTypeService stringTypeService;

	@Autowired
	@Qualifier("busmodel31JpaTZDateDefService")
	private BusModelJpaTZDateDefService tZDateDefService;

	@Autowired
	@Qualifier("busmodel31JpaTZDateTypeService")
	private BusModelJpaTZDateTypeService tZDateTypeService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimeDefService")
	private BusModelJpaTZTimeDefService tZTimeDefService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimeTypeService")
	private BusModelJpaTZTimeTypeService tZTimeTypeService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimestampDefService")
	private BusModelJpaTZTimestampDefService tZTimestampDefService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimestampTypeService")
	private BusModelJpaTZTimestampTypeService tZTimestampTypeService;

	@Autowired
	@Qualifier("busmodel31JpaTableColService")
	private BusModelJpaTableColService tableColService;

	@Autowired
	@Qualifier("busmodel31JpaTextDefService")
	private BusModelJpaTextDefService textDefService;

	@Autowired
	@Qualifier("busmodel31JpaTextTypeService")
	private BusModelJpaTextTypeService textTypeService;

	@Autowired
	@Qualifier("busmodel31JpaTimeDefService")
	private BusModelJpaTimeDefService timeDefService;

	@Autowired
	@Qualifier("busmodel31JpaTimeTypeService")
	private BusModelJpaTimeTypeService timeTypeService;

	@Autowired
	@Qualifier("busmodel31JpaTimestampDefService")
	private BusModelJpaTimestampDefService timestampDefService;

	@Autowired
	@Qualifier("busmodel31JpaTimestampTypeService")
	private BusModelJpaTimestampTypeService timestampTypeService;

	@Autowired
	@Qualifier("busmodel31JpaTokenDefService")
	private BusModelJpaTokenDefService tokenDefService;

	@Autowired
	@Qualifier("busmodel31JpaTokenTypeService")
	private BusModelJpaTokenTypeService tokenTypeService;

	@Autowired
	@Qualifier("busmodel31JpaUInt16DefService")
	private BusModelJpaUInt16DefService uInt16DefService;

	@Autowired
	@Qualifier("busmodel31JpaUInt16TypeService")
	private BusModelJpaUInt16TypeService uInt16TypeService;

	@Autowired
	@Qualifier("busmodel31JpaUInt32DefService")
	private BusModelJpaUInt32DefService uInt32DefService;

	@Autowired
	@Qualifier("busmodel31JpaUInt32TypeService")
	private BusModelJpaUInt32TypeService uInt32TypeService;

	@Autowired
	@Qualifier("busmodel31JpaUInt64DefService")
	private BusModelJpaUInt64DefService uInt64DefService;

	@Autowired
	@Qualifier("busmodel31JpaUInt64TypeService")
	private BusModelJpaUInt64TypeService uInt64TypeService;

	@Autowired
	@Qualifier("busmodel31JpaUuidDefService")
	private BusModelJpaUuidDefService uuidDefService;

	@Autowired
	@Qualifier("busmodel31JpaUuid6DefService")
	private BusModelJpaUuid6DefService uuid6DefService;

	@Autowired
	@Qualifier("busmodel31JpaUuidTypeService")
	private BusModelJpaUuidTypeService uuidTypeService;

	@Autowired
	@Qualifier("busmodel31JpaUuid6TypeService")
	private BusModelJpaUuid6TypeService uuid6TypeService;

	@Autowired
	@Qualifier("busmodel31JpaBlobColService")
	private BusModelJpaBlobColService blobColService;

	@Autowired
	@Qualifier("busmodel31JpaBoolColService")
	private BusModelJpaBoolColService boolColService;

	@Autowired
	@Qualifier("busmodel31JpaDateColService")
	private BusModelJpaDateColService dateColService;

	@Autowired
	@Qualifier("busmodel31JpaDoubleColService")
	private BusModelJpaDoubleColService doubleColService;

	@Autowired
	@Qualifier("busmodel31JpaEnumDefService")
	private BusModelJpaEnumDefService enumDefService;

	@Autowired
	@Qualifier("busmodel31JpaEnumTypeService")
	private BusModelJpaEnumTypeService enumTypeService;

	@Autowired
	@Qualifier("busmodel31JpaFloatColService")
	private BusModelJpaFloatColService floatColService;

	@Autowired
	@Qualifier("busmodel31JpaId16GenService")
	private BusModelJpaId16GenService id16GenService;

	@Autowired
	@Qualifier("busmodel31JpaId32GenService")
	private BusModelJpaId32GenService id32GenService;

	@Autowired
	@Qualifier("busmodel31JpaId64GenService")
	private BusModelJpaId64GenService id64GenService;

	@Autowired
	@Qualifier("busmodel31JpaInt16ColService")
	private BusModelJpaInt16ColService int16ColService;

	@Autowired
	@Qualifier("busmodel31JpaInt32ColService")
	private BusModelJpaInt32ColService int32ColService;

	@Autowired
	@Qualifier("busmodel31JpaInt64ColService")
	private BusModelJpaInt64ColService int64ColService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokenColService")
	private BusModelJpaNmTokenColService nmTokenColService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokensColService")
	private BusModelJpaNmTokensColService nmTokensColService;

	@Autowired
	@Qualifier("busmodel31JpaNumberColService")
	private BusModelJpaNumberColService numberColService;

	@Autowired
	@Qualifier("busmodel31JpaStringColService")
	private BusModelJpaStringColService stringColService;

	@Autowired
	@Qualifier("busmodel31JpaTZDateColService")
	private BusModelJpaTZDateColService tZDateColService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimeColService")
	private BusModelJpaTZTimeColService tZTimeColService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimestampColService")
	private BusModelJpaTZTimestampColService tZTimestampColService;

	@Autowired
	@Qualifier("busmodel31JpaTextColService")
	private BusModelJpaTextColService textColService;

	@Autowired
	@Qualifier("busmodel31JpaTimeColService")
	private BusModelJpaTimeColService timeColService;

	@Autowired
	@Qualifier("busmodel31JpaTimestampColService")
	private BusModelJpaTimestampColService timestampColService;

	@Autowired
	@Qualifier("busmodel31JpaTokenColService")
	private BusModelJpaTokenColService tokenColService;

	@Autowired
	@Qualifier("busmodel31JpaUInt16ColService")
	private BusModelJpaUInt16ColService uInt16ColService;

	@Autowired
	@Qualifier("busmodel31JpaUInt32ColService")
	private BusModelJpaUInt32ColService uInt32ColService;

	@Autowired
	@Qualifier("busmodel31JpaUInt64ColService")
	private BusModelJpaUInt64ColService uInt64ColService;

	@Autowired
	@Qualifier("busmodel31JpaUuidColService")
	private BusModelJpaUuidColService uuidColService;

	@Autowired
	@Qualifier("busmodel31JpaUuid6ColService")
	private BusModelJpaUuid6ColService uuid6ColService;

	@Autowired
	@Qualifier("busmodel31JpaUuidGenService")
	private BusModelJpaUuidGenService uuidGenService;

	@Autowired
	@Qualifier("busmodel31JpaUuid6GenService")
	private BusModelJpaUuid6GenService uuid6GenService;

	@Autowired
	@Qualifier("busmodel31JpaRoleDefService")
	private BusModelJpaRoleDefService roleDefService;

	@Autowired
	@Qualifier("busmodel31JpaSchemaRoleService")
	private BusModelJpaSchemaRoleService schemaRoleService;

	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		if ( busmodel31EntityManagerFactory == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getEntityManagerFactoryBean",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( busmodel31EntityManagerFactory );
	}

	public BusModelJpaSchemaService getSchemaService() {
		if ( schemaService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getSchemaService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaService );
	}

	public BusModelJpaFactoryService getFactoryService() {
		if ( factoryService == null ) {
			// Dynamically resolve the factory by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getFactoryService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( factoryService );
	}

	public BusModelJpaIdGenService getIdGenService() {
		if ( idGenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getIdGenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( idGenService );
	}

	public BusModelJpaScopeRepository getScopeRepository() {
		if ( scopeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getScopeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( scopeRepository );
	}

	public BusModelJpaSchemaDefRepository getSchemaDefRepository() {
		if ( schemaDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getSchemaDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaDefRepository );
	}

	public BusModelJpaSchemaRefRepository getSchemaRefRepository() {
		if ( schemaRefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getSchemaRefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaRefRepository );
	}

	public BusModelJpaServerMethodRepository getServerMethodRepository() {
		if ( serverMethodRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getServerMethodRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( serverMethodRepository );
	}

	public BusModelJpaServerObjFuncRepository getServerObjFuncRepository() {
		if ( serverObjFuncRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getServerObjFuncRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( serverObjFuncRepository );
	}

	public BusModelJpaServerProcRepository getServerProcRepository() {
		if ( serverProcRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getServerProcRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( serverProcRepository );
	}

	public BusModelJpaTableRepository getTableRepository() {
		if ( tableRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTableRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tableRepository );
	}

	public BusModelJpaTweakRepository getTweakRepository() {
		if ( tweakRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTweakRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tweakRepository );
	}

	public BusModelJpaTableTweakRepository getTableTweakRepository() {
		if ( tableTweakRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTableTweakRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tableTweakRepository );
	}

	public BusModelJpaSchemaTweakRepository getSchemaTweakRepository() {
		if ( schemaTweakRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getSchemaTweakRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaTweakRepository );
	}

	public BusModelJpaIndexTweakRepository getIndexTweakRepository() {
		if ( indexTweakRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getIndexTweakRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( indexTweakRepository );
	}

	public BusModelJpaValueRepository getValueRepository() {
		if ( valueRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getValueRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( valueRepository );
	}

	public BusModelJpaAtomRepository getAtomRepository() {
		if ( atomRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getAtomRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( atomRepository );
	}

	public BusModelJpaBlobDefRepository getBlobDefRepository() {
		if ( blobDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getBlobDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( blobDefRepository );
	}

	public BusModelJpaBlobTypeRepository getBlobTypeRepository() {
		if ( blobTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getBlobTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( blobTypeRepository );
	}

	public BusModelJpaBoolDefRepository getBoolDefRepository() {
		if ( boolDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getBoolDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( boolDefRepository );
	}

	public BusModelJpaBoolTypeRepository getBoolTypeRepository() {
		if ( boolTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getBoolTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( boolTypeRepository );
	}

	public BusModelJpaChainRepository getChainRepository() {
		if ( chainRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getChainRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( chainRepository );
	}

	public BusModelJpaClearDepRepository getClearDepRepository() {
		if ( clearDepRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getClearDepRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearDepRepository );
	}

	public BusModelJpaClearSubDep1Repository getClearSubDep1Repository() {
		if ( clearSubDep1Repository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getClearSubDep1Repository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearSubDep1Repository );
	}

	public BusModelJpaClearSubDep2Repository getClearSubDep2Repository() {
		if ( clearSubDep2Repository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getClearSubDep2Repository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearSubDep2Repository );
	}

	public BusModelJpaClearSubDep3Repository getClearSubDep3Repository() {
		if ( clearSubDep3Repository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getClearSubDep3Repository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearSubDep3Repository );
	}

	public BusModelJpaClearTopDepRepository getClearTopDepRepository() {
		if ( clearTopDepRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getClearTopDepRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearTopDepRepository );
	}

	public BusModelJpaDateDefRepository getDateDefRepository() {
		if ( dateDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDateDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dateDefRepository );
	}

	public BusModelJpaDateTypeRepository getDateTypeRepository() {
		if ( dateTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDateTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dateTypeRepository );
	}

	public BusModelJpaDelDepRepository getDelDepRepository() {
		if ( delDepRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDelDepRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delDepRepository );
	}

	public BusModelJpaDelSubDep1Repository getDelSubDep1Repository() {
		if ( delSubDep1Repository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDelSubDep1Repository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delSubDep1Repository );
	}

	public BusModelJpaDelSubDep2Repository getDelSubDep2Repository() {
		if ( delSubDep2Repository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDelSubDep2Repository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delSubDep2Repository );
	}

	public BusModelJpaDelSubDep3Repository getDelSubDep3Repository() {
		if ( delSubDep3Repository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDelSubDep3Repository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delSubDep3Repository );
	}

	public BusModelJpaDelTopDepRepository getDelTopDepRepository() {
		if ( delTopDepRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDelTopDepRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delTopDepRepository );
	}

	public BusModelJpaDoubleDefRepository getDoubleDefRepository() {
		if ( doubleDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDoubleDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( doubleDefRepository );
	}

	public BusModelJpaDoubleTypeRepository getDoubleTypeRepository() {
		if ( doubleTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDoubleTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( doubleTypeRepository );
	}

	public BusModelJpaEnumTagRepository getEnumTagRepository() {
		if ( enumTagRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getEnumTagRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( enumTagRepository );
	}

	public BusModelJpaFloatDefRepository getFloatDefRepository() {
		if ( floatDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getFloatDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( floatDefRepository );
	}

	public BusModelJpaFloatTypeRepository getFloatTypeRepository() {
		if ( floatTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getFloatTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( floatTypeRepository );
	}

	public BusModelJpaIndexRepository getIndexRepository() {
		if ( indexRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getIndexRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( indexRepository );
	}

	public BusModelJpaIndexColRepository getIndexColRepository() {
		if ( indexColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getIndexColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( indexColRepository );
	}

	public BusModelJpaInt16DefRepository getInt16DefRepository() {
		if ( int16DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getInt16DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int16DefRepository );
	}

	public BusModelJpaInt16TypeRepository getInt16TypeRepository() {
		if ( int16TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getInt16TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int16TypeRepository );
	}

	public BusModelJpaInt32DefRepository getInt32DefRepository() {
		if ( int32DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getInt32DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int32DefRepository );
	}

	public BusModelJpaInt32TypeRepository getInt32TypeRepository() {
		if ( int32TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getInt32TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int32TypeRepository );
	}

	public BusModelJpaInt64DefRepository getInt64DefRepository() {
		if ( int64DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getInt64DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int64DefRepository );
	}

	public BusModelJpaInt64TypeRepository getInt64TypeRepository() {
		if ( int64TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getInt64TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int64TypeRepository );
	}

	public BusModelJpaNmTokenDefRepository getNmTokenDefRepository() {
		if ( nmTokenDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getNmTokenDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokenDefRepository );
	}

	public BusModelJpaNmTokenTypeRepository getNmTokenTypeRepository() {
		if ( nmTokenTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getNmTokenTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokenTypeRepository );
	}

	public BusModelJpaNmTokensDefRepository getNmTokensDefRepository() {
		if ( nmTokensDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getNmTokensDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokensDefRepository );
	}

	public BusModelJpaNmTokensTypeRepository getNmTokensTypeRepository() {
		if ( nmTokensTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getNmTokensTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokensTypeRepository );
	}

	public BusModelJpaNumberDefRepository getNumberDefRepository() {
		if ( numberDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getNumberDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( numberDefRepository );
	}

	public BusModelJpaNumberTypeRepository getNumberTypeRepository() {
		if ( numberTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getNumberTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( numberTypeRepository );
	}

	public BusModelJpaParamRepository getParamRepository() {
		if ( paramRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getParamRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( paramRepository );
	}

	public BusModelJpaPopDepRepository getPopDepRepository() {
		if ( popDepRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getPopDepRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popDepRepository );
	}

	public BusModelJpaPopSubDep1Repository getPopSubDep1Repository() {
		if ( popSubDep1Repository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getPopSubDep1Repository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popSubDep1Repository );
	}

	public BusModelJpaPopSubDep2Repository getPopSubDep2Repository() {
		if ( popSubDep2Repository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getPopSubDep2Repository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popSubDep2Repository );
	}

	public BusModelJpaPopSubDep3Repository getPopSubDep3Repository() {
		if ( popSubDep3Repository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getPopSubDep3Repository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popSubDep3Repository );
	}

	public BusModelJpaPopTopDepRepository getPopTopDepRepository() {
		if ( popTopDepRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getPopTopDepRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popTopDepRepository );
	}

	public BusModelJpaRelationRepository getRelationRepository() {
		if ( relationRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getRelationRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( relationRepository );
	}

	public BusModelJpaRelationColRepository getRelationColRepository() {
		if ( relationColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getRelationColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( relationColRepository );
	}

	public BusModelJpaServerListFuncRepository getServerListFuncRepository() {
		if ( serverListFuncRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getServerListFuncRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( serverListFuncRepository );
	}

	public BusModelJpaDbKeyHash128DefRepository getDbKeyHash128DefRepository() {
		if ( dbKeyHash128DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash128DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash128DefRepository );
	}

	public BusModelJpaDbKeyHash128ColRepository getDbKeyHash128ColRepository() {
		if ( dbKeyHash128ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash128ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash128ColRepository );
	}

	public BusModelJpaDbKeyHash128TypeRepository getDbKeyHash128TypeRepository() {
		if ( dbKeyHash128TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash128TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash128TypeRepository );
	}

	public BusModelJpaDbKeyHash128GenRepository getDbKeyHash128GenRepository() {
		if ( dbKeyHash128GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash128GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash128GenRepository );
	}

	public BusModelJpaDbKeyHash160DefRepository getDbKeyHash160DefRepository() {
		if ( dbKeyHash160DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash160DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash160DefRepository );
	}

	public BusModelJpaDbKeyHash160ColRepository getDbKeyHash160ColRepository() {
		if ( dbKeyHash160ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash160ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash160ColRepository );
	}

	public BusModelJpaDbKeyHash160TypeRepository getDbKeyHash160TypeRepository() {
		if ( dbKeyHash160TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash160TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash160TypeRepository );
	}

	public BusModelJpaDbKeyHash160GenRepository getDbKeyHash160GenRepository() {
		if ( dbKeyHash160GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash160GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash160GenRepository );
	}

	public BusModelJpaDbKeyHash224DefRepository getDbKeyHash224DefRepository() {
		if ( dbKeyHash224DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash224DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash224DefRepository );
	}

	public BusModelJpaDbKeyHash224ColRepository getDbKeyHash224ColRepository() {
		if ( dbKeyHash224ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash224ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash224ColRepository );
	}

	public BusModelJpaDbKeyHash224TypeRepository getDbKeyHash224TypeRepository() {
		if ( dbKeyHash224TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash224TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash224TypeRepository );
	}

	public BusModelJpaDbKeyHash224GenRepository getDbKeyHash224GenRepository() {
		if ( dbKeyHash224GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash224GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash224GenRepository );
	}

	public BusModelJpaDbKeyHash256DefRepository getDbKeyHash256DefRepository() {
		if ( dbKeyHash256DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash256DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash256DefRepository );
	}

	public BusModelJpaDbKeyHash256ColRepository getDbKeyHash256ColRepository() {
		if ( dbKeyHash256ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash256ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash256ColRepository );
	}

	public BusModelJpaDbKeyHash256TypeRepository getDbKeyHash256TypeRepository() {
		if ( dbKeyHash256TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash256TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash256TypeRepository );
	}

	public BusModelJpaDbKeyHash256GenRepository getDbKeyHash256GenRepository() {
		if ( dbKeyHash256GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash256GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash256GenRepository );
	}

	public BusModelJpaDbKeyHash384DefRepository getDbKeyHash384DefRepository() {
		if ( dbKeyHash384DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash384DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash384DefRepository );
	}

	public BusModelJpaDbKeyHash384ColRepository getDbKeyHash384ColRepository() {
		if ( dbKeyHash384ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash384ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash384ColRepository );
	}

	public BusModelJpaDbKeyHash384TypeRepository getDbKeyHash384TypeRepository() {
		if ( dbKeyHash384TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash384TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash384TypeRepository );
	}

	public BusModelJpaDbKeyHash384GenRepository getDbKeyHash384GenRepository() {
		if ( dbKeyHash384GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash384GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash384GenRepository );
	}

	public BusModelJpaDbKeyHash512DefRepository getDbKeyHash512DefRepository() {
		if ( dbKeyHash512DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash512DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash512DefRepository );
	}

	public BusModelJpaDbKeyHash512ColRepository getDbKeyHash512ColRepository() {
		if ( dbKeyHash512ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash512ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash512ColRepository );
	}

	public BusModelJpaDbKeyHash512TypeRepository getDbKeyHash512TypeRepository() {
		if ( dbKeyHash512TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash512TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash512TypeRepository );
	}

	public BusModelJpaDbKeyHash512GenRepository getDbKeyHash512GenRepository() {
		if ( dbKeyHash512GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash512GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash512GenRepository );
	}

	public BusModelJpaStringDefRepository getStringDefRepository() {
		if ( stringDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getStringDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( stringDefRepository );
	}

	public BusModelJpaStringTypeRepository getStringTypeRepository() {
		if ( stringTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getStringTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( stringTypeRepository );
	}

	public BusModelJpaTZDateDefRepository getTZDateDefRepository() {
		if ( tZDateDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTZDateDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZDateDefRepository );
	}

	public BusModelJpaTZDateTypeRepository getTZDateTypeRepository() {
		if ( tZDateTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTZDateTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZDateTypeRepository );
	}

	public BusModelJpaTZTimeDefRepository getTZTimeDefRepository() {
		if ( tZTimeDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTZTimeDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimeDefRepository );
	}

	public BusModelJpaTZTimeTypeRepository getTZTimeTypeRepository() {
		if ( tZTimeTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTZTimeTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimeTypeRepository );
	}

	public BusModelJpaTZTimestampDefRepository getTZTimestampDefRepository() {
		if ( tZTimestampDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTZTimestampDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimestampDefRepository );
	}

	public BusModelJpaTZTimestampTypeRepository getTZTimestampTypeRepository() {
		if ( tZTimestampTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTZTimestampTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimestampTypeRepository );
	}

	public BusModelJpaTableColRepository getTableColRepository() {
		if ( tableColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTableColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tableColRepository );
	}

	public BusModelJpaTextDefRepository getTextDefRepository() {
		if ( textDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTextDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( textDefRepository );
	}

	public BusModelJpaTextTypeRepository getTextTypeRepository() {
		if ( textTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTextTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( textTypeRepository );
	}

	public BusModelJpaTimeDefRepository getTimeDefRepository() {
		if ( timeDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTimeDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timeDefRepository );
	}

	public BusModelJpaTimeTypeRepository getTimeTypeRepository() {
		if ( timeTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTimeTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timeTypeRepository );
	}

	public BusModelJpaTimestampDefRepository getTimestampDefRepository() {
		if ( timestampDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTimestampDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timestampDefRepository );
	}

	public BusModelJpaTimestampTypeRepository getTimestampTypeRepository() {
		if ( timestampTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTimestampTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timestampTypeRepository );
	}

	public BusModelJpaTokenDefRepository getTokenDefRepository() {
		if ( tokenDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTokenDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tokenDefRepository );
	}

	public BusModelJpaTokenTypeRepository getTokenTypeRepository() {
		if ( tokenTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTokenTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tokenTypeRepository );
	}

	public BusModelJpaUInt16DefRepository getUInt16DefRepository() {
		if ( uInt16DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUInt16DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt16DefRepository );
	}

	public BusModelJpaUInt16TypeRepository getUInt16TypeRepository() {
		if ( uInt16TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUInt16TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt16TypeRepository );
	}

	public BusModelJpaUInt32DefRepository getUInt32DefRepository() {
		if ( uInt32DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUInt32DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt32DefRepository );
	}

	public BusModelJpaUInt32TypeRepository getUInt32TypeRepository() {
		if ( uInt32TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUInt32TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt32TypeRepository );
	}

	public BusModelJpaUInt64DefRepository getUInt64DefRepository() {
		if ( uInt64DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUInt64DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt64DefRepository );
	}

	public BusModelJpaUInt64TypeRepository getUInt64TypeRepository() {
		if ( uInt64TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUInt64TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt64TypeRepository );
	}

	public BusModelJpaUuidDefRepository getUuidDefRepository() {
		if ( uuidDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUuidDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuidDefRepository );
	}

	public BusModelJpaUuid6DefRepository getUuid6DefRepository() {
		if ( uuid6DefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUuid6DefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuid6DefRepository );
	}

	public BusModelJpaUuidTypeRepository getUuidTypeRepository() {
		if ( uuidTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUuidTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuidTypeRepository );
	}

	public BusModelJpaUuid6TypeRepository getUuid6TypeRepository() {
		if ( uuid6TypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUuid6TypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuid6TypeRepository );
	}

	public BusModelJpaBlobColRepository getBlobColRepository() {
		if ( blobColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getBlobColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( blobColRepository );
	}

	public BusModelJpaBoolColRepository getBoolColRepository() {
		if ( boolColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getBoolColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( boolColRepository );
	}

	public BusModelJpaDateColRepository getDateColRepository() {
		if ( dateColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDateColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dateColRepository );
	}

	public BusModelJpaDoubleColRepository getDoubleColRepository() {
		if ( doubleColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getDoubleColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( doubleColRepository );
	}

	public BusModelJpaEnumDefRepository getEnumDefRepository() {
		if ( enumDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getEnumDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( enumDefRepository );
	}

	public BusModelJpaEnumTypeRepository getEnumTypeRepository() {
		if ( enumTypeRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getEnumTypeRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( enumTypeRepository );
	}

	public BusModelJpaFloatColRepository getFloatColRepository() {
		if ( floatColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getFloatColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( floatColRepository );
	}

	public BusModelJpaId16GenRepository getId16GenRepository() {
		if ( id16GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getId16GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( id16GenRepository );
	}

	public BusModelJpaId32GenRepository getId32GenRepository() {
		if ( id32GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getId32GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( id32GenRepository );
	}

	public BusModelJpaId64GenRepository getId64GenRepository() {
		if ( id64GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getId64GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( id64GenRepository );
	}

	public BusModelJpaInt16ColRepository getInt16ColRepository() {
		if ( int16ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getInt16ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int16ColRepository );
	}

	public BusModelJpaInt32ColRepository getInt32ColRepository() {
		if ( int32ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getInt32ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int32ColRepository );
	}

	public BusModelJpaInt64ColRepository getInt64ColRepository() {
		if ( int64ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getInt64ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int64ColRepository );
	}

	public BusModelJpaNmTokenColRepository getNmTokenColRepository() {
		if ( nmTokenColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getNmTokenColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokenColRepository );
	}

	public BusModelJpaNmTokensColRepository getNmTokensColRepository() {
		if ( nmTokensColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getNmTokensColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokensColRepository );
	}

	public BusModelJpaNumberColRepository getNumberColRepository() {
		if ( numberColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getNumberColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( numberColRepository );
	}

	public BusModelJpaStringColRepository getStringColRepository() {
		if ( stringColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getStringColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( stringColRepository );
	}

	public BusModelJpaTZDateColRepository getTZDateColRepository() {
		if ( tZDateColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTZDateColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZDateColRepository );
	}

	public BusModelJpaTZTimeColRepository getTZTimeColRepository() {
		if ( tZTimeColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTZTimeColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimeColRepository );
	}

	public BusModelJpaTZTimestampColRepository getTZTimestampColRepository() {
		if ( tZTimestampColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTZTimestampColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimestampColRepository );
	}

	public BusModelJpaTextColRepository getTextColRepository() {
		if ( textColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTextColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( textColRepository );
	}

	public BusModelJpaTimeColRepository getTimeColRepository() {
		if ( timeColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTimeColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timeColRepository );
	}

	public BusModelJpaTimestampColRepository getTimestampColRepository() {
		if ( timestampColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTimestampColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timestampColRepository );
	}

	public BusModelJpaTokenColRepository getTokenColRepository() {
		if ( tokenColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getTokenColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tokenColRepository );
	}

	public BusModelJpaUInt16ColRepository getUInt16ColRepository() {
		if ( uInt16ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUInt16ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt16ColRepository );
	}

	public BusModelJpaUInt32ColRepository getUInt32ColRepository() {
		if ( uInt32ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUInt32ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt32ColRepository );
	}

	public BusModelJpaUInt64ColRepository getUInt64ColRepository() {
		if ( uInt64ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUInt64ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt64ColRepository );
	}

	public BusModelJpaUuidColRepository getUuidColRepository() {
		if ( uuidColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUuidColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuidColRepository );
	}

	public BusModelJpaUuid6ColRepository getUuid6ColRepository() {
		if ( uuid6ColRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUuid6ColRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuid6ColRepository );
	}

	public BusModelJpaUuidGenRepository getUuidGenRepository() {
		if ( uuidGenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUuidGenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuidGenRepository );
	}

	public BusModelJpaUuid6GenRepository getUuid6GenRepository() {
		if ( uuid6GenRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getUuid6GenRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuid6GenRepository );
	}

	public BusModelJpaRoleDefRepository getRoleDefRepository() {
		if ( roleDefRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getRoleDefRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( roleDefRepository );
	}

	public BusModelJpaSchemaRoleRepository getSchemaRoleRepository() {
		if ( schemaRoleRepository == null ) {
			// Dynamically resolve the repository by interface type
			throw new YCFNotImplementedYetException( getClass(), "getSchemaRoleRepository",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaRoleRepository );
	}

	public BusModelJpaScopeService getScopeService() {
		if ( scopeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getScopeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( scopeService );
	}

	public BusModelJpaSchemaDefService getSchemaDefService() {
		if ( schemaDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getSchemaDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaDefService );
	}

	public BusModelJpaSchemaRefService getSchemaRefService() {
		if ( schemaRefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getSchemaRefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaRefService );
	}

	public BusModelJpaServerMethodService getServerMethodService() {
		if ( serverMethodService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getServerMethodService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( serverMethodService );
	}

	public BusModelJpaServerObjFuncService getServerObjFuncService() {
		if ( serverObjFuncService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getServerObjFuncService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( serverObjFuncService );
	}

	public BusModelJpaServerProcService getServerProcService() {
		if ( serverProcService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getServerProcService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( serverProcService );
	}

	public BusModelJpaTableService getTableService() {
		if ( tableService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTableService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tableService );
	}

	public BusModelJpaTweakService getTweakService() {
		if ( tweakService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTweakService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tweakService );
	}

	public BusModelJpaTableTweakService getTableTweakService() {
		if ( tableTweakService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTableTweakService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tableTweakService );
	}

	public BusModelJpaSchemaTweakService getSchemaTweakService() {
		if ( schemaTweakService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getSchemaTweakService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaTweakService );
	}

	public BusModelJpaIndexTweakService getIndexTweakService() {
		if ( indexTweakService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getIndexTweakService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( indexTweakService );
	}

	public BusModelJpaValueService getValueService() {
		if ( valueService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getValueService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( valueService );
	}

	public BusModelJpaAtomService getAtomService() {
		if ( atomService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getAtomService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( atomService );
	}

	public BusModelJpaBlobDefService getBlobDefService() {
		if ( blobDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getBlobDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( blobDefService );
	}

	public BusModelJpaBlobTypeService getBlobTypeService() {
		if ( blobTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getBlobTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( blobTypeService );
	}

	public BusModelJpaBoolDefService getBoolDefService() {
		if ( boolDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getBoolDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( boolDefService );
	}

	public BusModelJpaBoolTypeService getBoolTypeService() {
		if ( boolTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getBoolTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( boolTypeService );
	}

	public BusModelJpaChainService getChainService() {
		if ( chainService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getChainService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( chainService );
	}

	public BusModelJpaClearDepService getClearDepService() {
		if ( clearDepService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getClearDepService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearDepService );
	}

	public BusModelJpaClearSubDep1Service getClearSubDep1Service() {
		if ( clearSubDep1Service == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getClearSubDep1Service",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearSubDep1Service );
	}

	public BusModelJpaClearSubDep2Service getClearSubDep2Service() {
		if ( clearSubDep2Service == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getClearSubDep2Service",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearSubDep2Service );
	}

	public BusModelJpaClearSubDep3Service getClearSubDep3Service() {
		if ( clearSubDep3Service == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getClearSubDep3Service",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearSubDep3Service );
	}

	public BusModelJpaClearTopDepService getClearTopDepService() {
		if ( clearTopDepService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getClearTopDepService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( clearTopDepService );
	}

	public BusModelJpaDateDefService getDateDefService() {
		if ( dateDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDateDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dateDefService );
	}

	public BusModelJpaDateTypeService getDateTypeService() {
		if ( dateTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDateTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dateTypeService );
	}

	public BusModelJpaDelDepService getDelDepService() {
		if ( delDepService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDelDepService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delDepService );
	}

	public BusModelJpaDelSubDep1Service getDelSubDep1Service() {
		if ( delSubDep1Service == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDelSubDep1Service",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delSubDep1Service );
	}

	public BusModelJpaDelSubDep2Service getDelSubDep2Service() {
		if ( delSubDep2Service == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDelSubDep2Service",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delSubDep2Service );
	}

	public BusModelJpaDelSubDep3Service getDelSubDep3Service() {
		if ( delSubDep3Service == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDelSubDep3Service",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delSubDep3Service );
	}

	public BusModelJpaDelTopDepService getDelTopDepService() {
		if ( delTopDepService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDelTopDepService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( delTopDepService );
	}

	public BusModelJpaDoubleDefService getDoubleDefService() {
		if ( doubleDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDoubleDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( doubleDefService );
	}

	public BusModelJpaDoubleTypeService getDoubleTypeService() {
		if ( doubleTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDoubleTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( doubleTypeService );
	}

	public BusModelJpaEnumTagService getEnumTagService() {
		if ( enumTagService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getEnumTagService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( enumTagService );
	}

	public BusModelJpaFloatDefService getFloatDefService() {
		if ( floatDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getFloatDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( floatDefService );
	}

	public BusModelJpaFloatTypeService getFloatTypeService() {
		if ( floatTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getFloatTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( floatTypeService );
	}

	public BusModelJpaIndexService getIndexService() {
		if ( indexService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getIndexService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( indexService );
	}

	public BusModelJpaIndexColService getIndexColService() {
		if ( indexColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getIndexColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( indexColService );
	}

	public BusModelJpaInt16DefService getInt16DefService() {
		if ( int16DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getInt16DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int16DefService );
	}

	public BusModelJpaInt16TypeService getInt16TypeService() {
		if ( int16TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getInt16TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int16TypeService );
	}

	public BusModelJpaInt32DefService getInt32DefService() {
		if ( int32DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getInt32DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int32DefService );
	}

	public BusModelJpaInt32TypeService getInt32TypeService() {
		if ( int32TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getInt32TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int32TypeService );
	}

	public BusModelJpaInt64DefService getInt64DefService() {
		if ( int64DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getInt64DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int64DefService );
	}

	public BusModelJpaInt64TypeService getInt64TypeService() {
		if ( int64TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getInt64TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int64TypeService );
	}

	public BusModelJpaNmTokenDefService getNmTokenDefService() {
		if ( nmTokenDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getNmTokenDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokenDefService );
	}

	public BusModelJpaNmTokenTypeService getNmTokenTypeService() {
		if ( nmTokenTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getNmTokenTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokenTypeService );
	}

	public BusModelJpaNmTokensDefService getNmTokensDefService() {
		if ( nmTokensDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getNmTokensDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokensDefService );
	}

	public BusModelJpaNmTokensTypeService getNmTokensTypeService() {
		if ( nmTokensTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getNmTokensTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokensTypeService );
	}

	public BusModelJpaNumberDefService getNumberDefService() {
		if ( numberDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getNumberDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( numberDefService );
	}

	public BusModelJpaNumberTypeService getNumberTypeService() {
		if ( numberTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getNumberTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( numberTypeService );
	}

	public BusModelJpaParamService getParamService() {
		if ( paramService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getParamService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( paramService );
	}

	public BusModelJpaPopDepService getPopDepService() {
		if ( popDepService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getPopDepService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popDepService );
	}

	public BusModelJpaPopSubDep1Service getPopSubDep1Service() {
		if ( popSubDep1Service == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getPopSubDep1Service",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popSubDep1Service );
	}

	public BusModelJpaPopSubDep2Service getPopSubDep2Service() {
		if ( popSubDep2Service == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getPopSubDep2Service",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popSubDep2Service );
	}

	public BusModelJpaPopSubDep3Service getPopSubDep3Service() {
		if ( popSubDep3Service == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getPopSubDep3Service",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popSubDep3Service );
	}

	public BusModelJpaPopTopDepService getPopTopDepService() {
		if ( popTopDepService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getPopTopDepService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( popTopDepService );
	}

	public BusModelJpaRelationService getRelationService() {
		if ( relationService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getRelationService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( relationService );
	}

	public BusModelJpaRelationColService getRelationColService() {
		if ( relationColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getRelationColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( relationColService );
	}

	public BusModelJpaServerListFuncService getServerListFuncService() {
		if ( serverListFuncService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getServerListFuncService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( serverListFuncService );
	}

	public BusModelJpaDbKeyHash128DefService getDbKeyHash128DefService() {
		if ( dbKeyHash128DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash128DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash128DefService );
	}

	public BusModelJpaDbKeyHash128ColService getDbKeyHash128ColService() {
		if ( dbKeyHash128ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash128ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash128ColService );
	}

	public BusModelJpaDbKeyHash128TypeService getDbKeyHash128TypeService() {
		if ( dbKeyHash128TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash128TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash128TypeService );
	}

	public BusModelJpaDbKeyHash128GenService getDbKeyHash128GenService() {
		if ( dbKeyHash128GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash128GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash128GenService );
	}

	public BusModelJpaDbKeyHash160DefService getDbKeyHash160DefService() {
		if ( dbKeyHash160DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash160DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash160DefService );
	}

	public BusModelJpaDbKeyHash160ColService getDbKeyHash160ColService() {
		if ( dbKeyHash160ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash160ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash160ColService );
	}

	public BusModelJpaDbKeyHash160TypeService getDbKeyHash160TypeService() {
		if ( dbKeyHash160TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash160TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash160TypeService );
	}

	public BusModelJpaDbKeyHash160GenService getDbKeyHash160GenService() {
		if ( dbKeyHash160GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash160GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash160GenService );
	}

	public BusModelJpaDbKeyHash224DefService getDbKeyHash224DefService() {
		if ( dbKeyHash224DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash224DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash224DefService );
	}

	public BusModelJpaDbKeyHash224ColService getDbKeyHash224ColService() {
		if ( dbKeyHash224ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash224ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash224ColService );
	}

	public BusModelJpaDbKeyHash224TypeService getDbKeyHash224TypeService() {
		if ( dbKeyHash224TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash224TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash224TypeService );
	}

	public BusModelJpaDbKeyHash224GenService getDbKeyHash224GenService() {
		if ( dbKeyHash224GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash224GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash224GenService );
	}

	public BusModelJpaDbKeyHash256DefService getDbKeyHash256DefService() {
		if ( dbKeyHash256DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash256DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash256DefService );
	}

	public BusModelJpaDbKeyHash256ColService getDbKeyHash256ColService() {
		if ( dbKeyHash256ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash256ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash256ColService );
	}

	public BusModelJpaDbKeyHash256TypeService getDbKeyHash256TypeService() {
		if ( dbKeyHash256TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash256TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash256TypeService );
	}

	public BusModelJpaDbKeyHash256GenService getDbKeyHash256GenService() {
		if ( dbKeyHash256GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash256GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash256GenService );
	}

	public BusModelJpaDbKeyHash384DefService getDbKeyHash384DefService() {
		if ( dbKeyHash384DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash384DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash384DefService );
	}

	public BusModelJpaDbKeyHash384ColService getDbKeyHash384ColService() {
		if ( dbKeyHash384ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash384ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash384ColService );
	}

	public BusModelJpaDbKeyHash384TypeService getDbKeyHash384TypeService() {
		if ( dbKeyHash384TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash384TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash384TypeService );
	}

	public BusModelJpaDbKeyHash384GenService getDbKeyHash384GenService() {
		if ( dbKeyHash384GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash384GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash384GenService );
	}

	public BusModelJpaDbKeyHash512DefService getDbKeyHash512DefService() {
		if ( dbKeyHash512DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash512DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash512DefService );
	}

	public BusModelJpaDbKeyHash512ColService getDbKeyHash512ColService() {
		if ( dbKeyHash512ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash512ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash512ColService );
	}

	public BusModelJpaDbKeyHash512TypeService getDbKeyHash512TypeService() {
		if ( dbKeyHash512TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash512TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash512TypeService );
	}

	public BusModelJpaDbKeyHash512GenService getDbKeyHash512GenService() {
		if ( dbKeyHash512GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDbKeyHash512GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dbKeyHash512GenService );
	}

	public BusModelJpaStringDefService getStringDefService() {
		if ( stringDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getStringDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( stringDefService );
	}

	public BusModelJpaStringTypeService getStringTypeService() {
		if ( stringTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getStringTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( stringTypeService );
	}

	public BusModelJpaTZDateDefService getTZDateDefService() {
		if ( tZDateDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTZDateDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZDateDefService );
	}

	public BusModelJpaTZDateTypeService getTZDateTypeService() {
		if ( tZDateTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTZDateTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZDateTypeService );
	}

	public BusModelJpaTZTimeDefService getTZTimeDefService() {
		if ( tZTimeDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTZTimeDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimeDefService );
	}

	public BusModelJpaTZTimeTypeService getTZTimeTypeService() {
		if ( tZTimeTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTZTimeTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimeTypeService );
	}

	public BusModelJpaTZTimestampDefService getTZTimestampDefService() {
		if ( tZTimestampDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTZTimestampDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimestampDefService );
	}

	public BusModelJpaTZTimestampTypeService getTZTimestampTypeService() {
		if ( tZTimestampTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTZTimestampTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimestampTypeService );
	}

	public BusModelJpaTableColService getTableColService() {
		if ( tableColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTableColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tableColService );
	}

	public BusModelJpaTextDefService getTextDefService() {
		if ( textDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTextDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( textDefService );
	}

	public BusModelJpaTextTypeService getTextTypeService() {
		if ( textTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTextTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( textTypeService );
	}

	public BusModelJpaTimeDefService getTimeDefService() {
		if ( timeDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTimeDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timeDefService );
	}

	public BusModelJpaTimeTypeService getTimeTypeService() {
		if ( timeTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTimeTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timeTypeService );
	}

	public BusModelJpaTimestampDefService getTimestampDefService() {
		if ( timestampDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTimestampDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timestampDefService );
	}

	public BusModelJpaTimestampTypeService getTimestampTypeService() {
		if ( timestampTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTimestampTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timestampTypeService );
	}

	public BusModelJpaTokenDefService getTokenDefService() {
		if ( tokenDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTokenDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tokenDefService );
	}

	public BusModelJpaTokenTypeService getTokenTypeService() {
		if ( tokenTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTokenTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tokenTypeService );
	}

	public BusModelJpaUInt16DefService getUInt16DefService() {
		if ( uInt16DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUInt16DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt16DefService );
	}

	public BusModelJpaUInt16TypeService getUInt16TypeService() {
		if ( uInt16TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUInt16TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt16TypeService );
	}

	public BusModelJpaUInt32DefService getUInt32DefService() {
		if ( uInt32DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUInt32DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt32DefService );
	}

	public BusModelJpaUInt32TypeService getUInt32TypeService() {
		if ( uInt32TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUInt32TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt32TypeService );
	}

	public BusModelJpaUInt64DefService getUInt64DefService() {
		if ( uInt64DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUInt64DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt64DefService );
	}

	public BusModelJpaUInt64TypeService getUInt64TypeService() {
		if ( uInt64TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUInt64TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt64TypeService );
	}

	public BusModelJpaUuidDefService getUuidDefService() {
		if ( uuidDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUuidDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuidDefService );
	}

	public BusModelJpaUuid6DefService getUuid6DefService() {
		if ( uuid6DefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUuid6DefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuid6DefService );
	}

	public BusModelJpaUuidTypeService getUuidTypeService() {
		if ( uuidTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUuidTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuidTypeService );
	}

	public BusModelJpaUuid6TypeService getUuid6TypeService() {
		if ( uuid6TypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUuid6TypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuid6TypeService );
	}

	public BusModelJpaBlobColService getBlobColService() {
		if ( blobColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getBlobColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( blobColService );
	}

	public BusModelJpaBoolColService getBoolColService() {
		if ( boolColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getBoolColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( boolColService );
	}

	public BusModelJpaDateColService getDateColService() {
		if ( dateColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDateColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( dateColService );
	}

	public BusModelJpaDoubleColService getDoubleColService() {
		if ( doubleColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getDoubleColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( doubleColService );
	}

	public BusModelJpaEnumDefService getEnumDefService() {
		if ( enumDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getEnumDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( enumDefService );
	}

	public BusModelJpaEnumTypeService getEnumTypeService() {
		if ( enumTypeService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getEnumTypeService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( enumTypeService );
	}

	public BusModelJpaFloatColService getFloatColService() {
		if ( floatColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getFloatColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( floatColService );
	}

	public BusModelJpaId16GenService getId16GenService() {
		if ( id16GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getId16GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( id16GenService );
	}

	public BusModelJpaId32GenService getId32GenService() {
		if ( id32GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getId32GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( id32GenService );
	}

	public BusModelJpaId64GenService getId64GenService() {
		if ( id64GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getId64GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( id64GenService );
	}

	public BusModelJpaInt16ColService getInt16ColService() {
		if ( int16ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getInt16ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int16ColService );
	}

	public BusModelJpaInt32ColService getInt32ColService() {
		if ( int32ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getInt32ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int32ColService );
	}

	public BusModelJpaInt64ColService getInt64ColService() {
		if ( int64ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getInt64ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( int64ColService );
	}

	public BusModelJpaNmTokenColService getNmTokenColService() {
		if ( nmTokenColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getNmTokenColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokenColService );
	}

	public BusModelJpaNmTokensColService getNmTokensColService() {
		if ( nmTokensColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getNmTokensColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( nmTokensColService );
	}

	public BusModelJpaNumberColService getNumberColService() {
		if ( numberColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getNumberColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( numberColService );
	}

	public BusModelJpaStringColService getStringColService() {
		if ( stringColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getStringColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( stringColService );
	}

	public BusModelJpaTZDateColService getTZDateColService() {
		if ( tZDateColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTZDateColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZDateColService );
	}

	public BusModelJpaTZTimeColService getTZTimeColService() {
		if ( tZTimeColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTZTimeColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimeColService );
	}

	public BusModelJpaTZTimestampColService getTZTimestampColService() {
		if ( tZTimestampColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTZTimestampColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tZTimestampColService );
	}

	public BusModelJpaTextColService getTextColService() {
		if ( textColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTextColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( textColService );
	}

	public BusModelJpaTimeColService getTimeColService() {
		if ( timeColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTimeColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timeColService );
	}

	public BusModelJpaTimestampColService getTimestampColService() {
		if ( timestampColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTimestampColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( timestampColService );
	}

	public BusModelJpaTokenColService getTokenColService() {
		if ( tokenColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getTokenColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( tokenColService );
	}

	public BusModelJpaUInt16ColService getUInt16ColService() {
		if ( uInt16ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUInt16ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt16ColService );
	}

	public BusModelJpaUInt32ColService getUInt32ColService() {
		if ( uInt32ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUInt32ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt32ColService );
	}

	public BusModelJpaUInt64ColService getUInt64ColService() {
		if ( uInt64ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUInt64ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uInt64ColService );
	}

	public BusModelJpaUuidColService getUuidColService() {
		if ( uuidColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUuidColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuidColService );
	}

	public BusModelJpaUuid6ColService getUuid6ColService() {
		if ( uuid6ColService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUuid6ColService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuid6ColService );
	}

	public BusModelJpaUuidGenService getUuidGenService() {
		if ( uuidGenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUuidGenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuidGenService );
	}

	public BusModelJpaUuid6GenService getUuid6GenService() {
		if ( uuid6GenService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getUuid6GenService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( uuid6GenService );
	}

	public BusModelJpaRoleDefService getRoleDefService() {
		if ( roleDefService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getRoleDefService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( roleDefService );
	}

	public BusModelJpaSchemaRoleService getSchemaRoleService() {
		if ( schemaRoleService == null ) {
			// Dynamically resolve the repository by qualifier name
			throw new YCFNotImplementedYetException( getClass(), "getSchemaRoleService",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either",
				"ERROR - do not know how to dynamically resolve Spring beans from POJO code yet and AspectJ did not resolve it either" );
		}
		return( schemaRoleService );
	}
}
