// Description: Java 25 JPA implementation of a BusModel factory service.

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;

/**
 *	JPA Factory Services for schema BusModel as specified by IBusModelFactory.
 */
@Service("busmodel31JpaFactoryService")
public class BusModelJpaFactoryService
	implements IBusModelFactory
{

	@Autowired
	@Qualifier("busmodel31JpaScopeFactoryService")
	protected BusModelJpaScopeFactoryService scopeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaSchemaDefFactoryService")
	protected BusModelJpaSchemaDefFactoryService schemadefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaSchemaRefFactoryService")
	protected BusModelJpaSchemaRefFactoryService schemarefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaServerMethodFactoryService")
	protected BusModelJpaServerMethodFactoryService servermethodFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaServerObjFuncFactoryService")
	protected BusModelJpaServerObjFuncFactoryService serverobjfuncFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaServerProcFactoryService")
	protected BusModelJpaServerProcFactoryService serverprocFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTableFactoryService")
	protected BusModelJpaTableFactoryService tableFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTweakFactoryService")
	protected BusModelJpaTweakFactoryService tweakFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTableTweakFactoryService")
	protected BusModelJpaTableTweakFactoryService tabletweakFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaSchemaTweakFactoryService")
	protected BusModelJpaSchemaTweakFactoryService schematweakFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaIndexTweakFactoryService")
	protected BusModelJpaIndexTweakFactoryService indextweakFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaValueFactoryService")
	protected BusModelJpaValueFactoryService valueFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaAtomFactoryService")
	protected BusModelJpaAtomFactoryService atomFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaBlobDefFactoryService")
	protected BusModelJpaBlobDefFactoryService blobdefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaBlobTypeFactoryService")
	protected BusModelJpaBlobTypeFactoryService blobtypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaBoolDefFactoryService")
	protected BusModelJpaBoolDefFactoryService booldefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaBoolTypeFactoryService")
	protected BusModelJpaBoolTypeFactoryService booltypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaChainFactoryService")
	protected BusModelJpaChainFactoryService chainFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaClearDepFactoryService")
	protected BusModelJpaClearDepFactoryService cleardepFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaClearSubDep1FactoryService")
	protected BusModelJpaClearSubDep1FactoryService clearsubdep1FactoryService;

	@Autowired
	@Qualifier("busmodel31JpaClearSubDep2FactoryService")
	protected BusModelJpaClearSubDep2FactoryService clearsubdep2FactoryService;

	@Autowired
	@Qualifier("busmodel31JpaClearSubDep3FactoryService")
	protected BusModelJpaClearSubDep3FactoryService clearsubdep3FactoryService;

	@Autowired
	@Qualifier("busmodel31JpaClearTopDepFactoryService")
	protected BusModelJpaClearTopDepFactoryService cleartopdepFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDateDefFactoryService")
	protected BusModelJpaDateDefFactoryService datedefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDateTypeFactoryService")
	protected BusModelJpaDateTypeFactoryService datetypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDelDepFactoryService")
	protected BusModelJpaDelDepFactoryService deldepFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDelSubDep1FactoryService")
	protected BusModelJpaDelSubDep1FactoryService delsubdep1FactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDelSubDep2FactoryService")
	protected BusModelJpaDelSubDep2FactoryService delsubdep2FactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDelSubDep3FactoryService")
	protected BusModelJpaDelSubDep3FactoryService delsubdep3FactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDelTopDepFactoryService")
	protected BusModelJpaDelTopDepFactoryService deltopdepFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDoubleDefFactoryService")
	protected BusModelJpaDoubleDefFactoryService doubledefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDoubleTypeFactoryService")
	protected BusModelJpaDoubleTypeFactoryService doubletypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaEnumTagFactoryService")
	protected BusModelJpaEnumTagFactoryService enumtagFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaFloatDefFactoryService")
	protected BusModelJpaFloatDefFactoryService floatdefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaFloatTypeFactoryService")
	protected BusModelJpaFloatTypeFactoryService floattypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaIndexFactoryService")
	protected BusModelJpaIndexFactoryService indexFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaIndexColFactoryService")
	protected BusModelJpaIndexColFactoryService indexcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaInt16DefFactoryService")
	protected BusModelJpaInt16DefFactoryService int16defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaInt16TypeFactoryService")
	protected BusModelJpaInt16TypeFactoryService int16typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaInt32DefFactoryService")
	protected BusModelJpaInt32DefFactoryService int32defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaInt32TypeFactoryService")
	protected BusModelJpaInt32TypeFactoryService int32typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaInt64DefFactoryService")
	protected BusModelJpaInt64DefFactoryService int64defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaInt64TypeFactoryService")
	protected BusModelJpaInt64TypeFactoryService int64typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokenDefFactoryService")
	protected BusModelJpaNmTokenDefFactoryService nmtokendefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokenTypeFactoryService")
	protected BusModelJpaNmTokenTypeFactoryService nmtokentypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokensDefFactoryService")
	protected BusModelJpaNmTokensDefFactoryService nmtokensdefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokensTypeFactoryService")
	protected BusModelJpaNmTokensTypeFactoryService nmtokenstypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaNumberDefFactoryService")
	protected BusModelJpaNumberDefFactoryService numberdefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaNumberTypeFactoryService")
	protected BusModelJpaNumberTypeFactoryService numbertypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaParamFactoryService")
	protected BusModelJpaParamFactoryService paramFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaPopDepFactoryService")
	protected BusModelJpaPopDepFactoryService popdepFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaPopSubDep1FactoryService")
	protected BusModelJpaPopSubDep1FactoryService popsubdep1FactoryService;

	@Autowired
	@Qualifier("busmodel31JpaPopSubDep2FactoryService")
	protected BusModelJpaPopSubDep2FactoryService popsubdep2FactoryService;

	@Autowired
	@Qualifier("busmodel31JpaPopSubDep3FactoryService")
	protected BusModelJpaPopSubDep3FactoryService popsubdep3FactoryService;

	@Autowired
	@Qualifier("busmodel31JpaPopTopDepFactoryService")
	protected BusModelJpaPopTopDepFactoryService poptopdepFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaRelationFactoryService")
	protected BusModelJpaRelationFactoryService relationFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaRelationColFactoryService")
	protected BusModelJpaRelationColFactoryService relationcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaServerListFuncFactoryService")
	protected BusModelJpaServerListFuncFactoryService serverlistfuncFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash128DefFactoryService")
	protected BusModelJpaDbKeyHash128DefFactoryService dbkeyhash128defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash128ColFactoryService")
	protected BusModelJpaDbKeyHash128ColFactoryService dbkeyhash128colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash128TypeFactoryService")
	protected BusModelJpaDbKeyHash128TypeFactoryService dbkeyhash128typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash128GenFactoryService")
	protected BusModelJpaDbKeyHash128GenFactoryService dbkeyhash128genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash160DefFactoryService")
	protected BusModelJpaDbKeyHash160DefFactoryService dbkeyhash160defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash160ColFactoryService")
	protected BusModelJpaDbKeyHash160ColFactoryService dbkeyhash160colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash160TypeFactoryService")
	protected BusModelJpaDbKeyHash160TypeFactoryService dbkeyhash160typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash160GenFactoryService")
	protected BusModelJpaDbKeyHash160GenFactoryService dbkeyhash160genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash224DefFactoryService")
	protected BusModelJpaDbKeyHash224DefFactoryService dbkeyhash224defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash224ColFactoryService")
	protected BusModelJpaDbKeyHash224ColFactoryService dbkeyhash224colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash224TypeFactoryService")
	protected BusModelJpaDbKeyHash224TypeFactoryService dbkeyhash224typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash224GenFactoryService")
	protected BusModelJpaDbKeyHash224GenFactoryService dbkeyhash224genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash256DefFactoryService")
	protected BusModelJpaDbKeyHash256DefFactoryService dbkeyhash256defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash256ColFactoryService")
	protected BusModelJpaDbKeyHash256ColFactoryService dbkeyhash256colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash256TypeFactoryService")
	protected BusModelJpaDbKeyHash256TypeFactoryService dbkeyhash256typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash256GenFactoryService")
	protected BusModelJpaDbKeyHash256GenFactoryService dbkeyhash256genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash384DefFactoryService")
	protected BusModelJpaDbKeyHash384DefFactoryService dbkeyhash384defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash384ColFactoryService")
	protected BusModelJpaDbKeyHash384ColFactoryService dbkeyhash384colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash384TypeFactoryService")
	protected BusModelJpaDbKeyHash384TypeFactoryService dbkeyhash384typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash384GenFactoryService")
	protected BusModelJpaDbKeyHash384GenFactoryService dbkeyhash384genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash512DefFactoryService")
	protected BusModelJpaDbKeyHash512DefFactoryService dbkeyhash512defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash512ColFactoryService")
	protected BusModelJpaDbKeyHash512ColFactoryService dbkeyhash512colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash512TypeFactoryService")
	protected BusModelJpaDbKeyHash512TypeFactoryService dbkeyhash512typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDbKeyHash512GenFactoryService")
	protected BusModelJpaDbKeyHash512GenFactoryService dbkeyhash512genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaStringDefFactoryService")
	protected BusModelJpaStringDefFactoryService stringdefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaStringTypeFactoryService")
	protected BusModelJpaStringTypeFactoryService stringtypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTZDateDefFactoryService")
	protected BusModelJpaTZDateDefFactoryService tzdatedefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTZDateTypeFactoryService")
	protected BusModelJpaTZDateTypeFactoryService tzdatetypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimeDefFactoryService")
	protected BusModelJpaTZTimeDefFactoryService tztimedefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimeTypeFactoryService")
	protected BusModelJpaTZTimeTypeFactoryService tztimetypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimestampDefFactoryService")
	protected BusModelJpaTZTimestampDefFactoryService tztimestampdefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimestampTypeFactoryService")
	protected BusModelJpaTZTimestampTypeFactoryService tztimestamptypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTableColFactoryService")
	protected BusModelJpaTableColFactoryService tablecolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTextDefFactoryService")
	protected BusModelJpaTextDefFactoryService textdefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTextTypeFactoryService")
	protected BusModelJpaTextTypeFactoryService texttypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTimeDefFactoryService")
	protected BusModelJpaTimeDefFactoryService timedefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTimeTypeFactoryService")
	protected BusModelJpaTimeTypeFactoryService timetypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTimestampDefFactoryService")
	protected BusModelJpaTimestampDefFactoryService timestampdefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTimestampTypeFactoryService")
	protected BusModelJpaTimestampTypeFactoryService timestamptypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTokenDefFactoryService")
	protected BusModelJpaTokenDefFactoryService tokendefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTokenTypeFactoryService")
	protected BusModelJpaTokenTypeFactoryService tokentypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUInt16DefFactoryService")
	protected BusModelJpaUInt16DefFactoryService uint16defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUInt16TypeFactoryService")
	protected BusModelJpaUInt16TypeFactoryService uint16typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUInt32DefFactoryService")
	protected BusModelJpaUInt32DefFactoryService uint32defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUInt32TypeFactoryService")
	protected BusModelJpaUInt32TypeFactoryService uint32typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUInt64DefFactoryService")
	protected BusModelJpaUInt64DefFactoryService uint64defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUInt64TypeFactoryService")
	protected BusModelJpaUInt64TypeFactoryService uint64typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUuidDefFactoryService")
	protected BusModelJpaUuidDefFactoryService uuiddefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUuid6DefFactoryService")
	protected BusModelJpaUuid6DefFactoryService uuid6defFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUuidTypeFactoryService")
	protected BusModelJpaUuidTypeFactoryService uuidtypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUuid6TypeFactoryService")
	protected BusModelJpaUuid6TypeFactoryService uuid6typeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaBlobColFactoryService")
	protected BusModelJpaBlobColFactoryService blobcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaBoolColFactoryService")
	protected BusModelJpaBoolColFactoryService boolcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDateColFactoryService")
	protected BusModelJpaDateColFactoryService datecolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaDoubleColFactoryService")
	protected BusModelJpaDoubleColFactoryService doublecolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaEnumDefFactoryService")
	protected BusModelJpaEnumDefFactoryService enumdefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaEnumTypeFactoryService")
	protected BusModelJpaEnumTypeFactoryService enumtypeFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaFloatColFactoryService")
	protected BusModelJpaFloatColFactoryService floatcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaId16GenFactoryService")
	protected BusModelJpaId16GenFactoryService id16genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaId32GenFactoryService")
	protected BusModelJpaId32GenFactoryService id32genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaId64GenFactoryService")
	protected BusModelJpaId64GenFactoryService id64genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaInt16ColFactoryService")
	protected BusModelJpaInt16ColFactoryService int16colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaInt32ColFactoryService")
	protected BusModelJpaInt32ColFactoryService int32colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaInt64ColFactoryService")
	protected BusModelJpaInt64ColFactoryService int64colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokenColFactoryService")
	protected BusModelJpaNmTokenColFactoryService nmtokencolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaNmTokensColFactoryService")
	protected BusModelJpaNmTokensColFactoryService nmtokenscolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaNumberColFactoryService")
	protected BusModelJpaNumberColFactoryService numbercolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaStringColFactoryService")
	protected BusModelJpaStringColFactoryService stringcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTZDateColFactoryService")
	protected BusModelJpaTZDateColFactoryService tzdatecolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimeColFactoryService")
	protected BusModelJpaTZTimeColFactoryService tztimecolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTZTimestampColFactoryService")
	protected BusModelJpaTZTimestampColFactoryService tztimestampcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTextColFactoryService")
	protected BusModelJpaTextColFactoryService textcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTimeColFactoryService")
	protected BusModelJpaTimeColFactoryService timecolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTimestampColFactoryService")
	protected BusModelJpaTimestampColFactoryService timestampcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaTokenColFactoryService")
	protected BusModelJpaTokenColFactoryService tokencolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUInt16ColFactoryService")
	protected BusModelJpaUInt16ColFactoryService uint16colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUInt32ColFactoryService")
	protected BusModelJpaUInt32ColFactoryService uint32colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUInt64ColFactoryService")
	protected BusModelJpaUInt64ColFactoryService uint64colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUuidColFactoryService")
	protected BusModelJpaUuidColFactoryService uuidcolFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUuid6ColFactoryService")
	protected BusModelJpaUuid6ColFactoryService uuid6colFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUuidGenFactoryService")
	protected BusModelJpaUuidGenFactoryService uuidgenFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaUuid6GenFactoryService")
	protected BusModelJpaUuid6GenFactoryService uuid6genFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaRoleDefFactoryService")
	protected BusModelJpaRoleDefFactoryService roledefFactoryService;

	@Autowired
	@Qualifier("busmodel31JpaSchemaRoleFactoryService")
	protected BusModelJpaSchemaRoleFactoryService schemaroleFactoryService;


	public BusModelJpaFactoryService() { }

	@Override
	public IBusModelScopeFactory getFactoryScope() {
		return(scopeFactoryService);
	}

	public BusModelJpaScopeFactoryService getScopeFactoryService() {
		return(scopeFactoryService);
	}

	@Override
	public IBusModelSchemaDefFactory getFactorySchemaDef() {
		return(schemadefFactoryService);
	}

	public BusModelJpaSchemaDefFactoryService getSchemaDefFactoryService() {
		return(schemadefFactoryService);
	}

	@Override
	public IBusModelSchemaRefFactory getFactorySchemaRef() {
		return(schemarefFactoryService);
	}

	public BusModelJpaSchemaRefFactoryService getSchemaRefFactoryService() {
		return(schemarefFactoryService);
	}

	@Override
	public IBusModelServerMethodFactory getFactoryServerMethod() {
		return(servermethodFactoryService);
	}

	public BusModelJpaServerMethodFactoryService getServerMethodFactoryService() {
		return(servermethodFactoryService);
	}

	@Override
	public IBusModelServerObjFuncFactory getFactoryServerObjFunc() {
		return(serverobjfuncFactoryService);
	}

	public BusModelJpaServerObjFuncFactoryService getServerObjFuncFactoryService() {
		return(serverobjfuncFactoryService);
	}

	@Override
	public IBusModelServerProcFactory getFactoryServerProc() {
		return(serverprocFactoryService);
	}

	public BusModelJpaServerProcFactoryService getServerProcFactoryService() {
		return(serverprocFactoryService);
	}

	@Override
	public IBusModelTableFactory getFactoryTable() {
		return(tableFactoryService);
	}

	public BusModelJpaTableFactoryService getTableFactoryService() {
		return(tableFactoryService);
	}

	@Override
	public IBusModelTweakFactory getFactoryTweak() {
		return(tweakFactoryService);
	}

	public BusModelJpaTweakFactoryService getTweakFactoryService() {
		return(tweakFactoryService);
	}

	@Override
	public IBusModelTableTweakFactory getFactoryTableTweak() {
		return(tabletweakFactoryService);
	}

	public BusModelJpaTableTweakFactoryService getTableTweakFactoryService() {
		return(tabletweakFactoryService);
	}

	@Override
	public IBusModelSchemaTweakFactory getFactorySchemaTweak() {
		return(schematweakFactoryService);
	}

	public BusModelJpaSchemaTweakFactoryService getSchemaTweakFactoryService() {
		return(schematweakFactoryService);
	}

	@Override
	public IBusModelIndexTweakFactory getFactoryIndexTweak() {
		return(indextweakFactoryService);
	}

	public BusModelJpaIndexTweakFactoryService getIndexTweakFactoryService() {
		return(indextweakFactoryService);
	}

	@Override
	public IBusModelValueFactory getFactoryValue() {
		return(valueFactoryService);
	}

	public BusModelJpaValueFactoryService getValueFactoryService() {
		return(valueFactoryService);
	}

	@Override
	public IBusModelAtomFactory getFactoryAtom() {
		return(atomFactoryService);
	}

	public BusModelJpaAtomFactoryService getAtomFactoryService() {
		return(atomFactoryService);
	}

	@Override
	public IBusModelBlobDefFactory getFactoryBlobDef() {
		return(blobdefFactoryService);
	}

	public BusModelJpaBlobDefFactoryService getBlobDefFactoryService() {
		return(blobdefFactoryService);
	}

	@Override
	public IBusModelBlobTypeFactory getFactoryBlobType() {
		return(blobtypeFactoryService);
	}

	public BusModelJpaBlobTypeFactoryService getBlobTypeFactoryService() {
		return(blobtypeFactoryService);
	}

	@Override
	public IBusModelBoolDefFactory getFactoryBoolDef() {
		return(booldefFactoryService);
	}

	public BusModelJpaBoolDefFactoryService getBoolDefFactoryService() {
		return(booldefFactoryService);
	}

	@Override
	public IBusModelBoolTypeFactory getFactoryBoolType() {
		return(booltypeFactoryService);
	}

	public BusModelJpaBoolTypeFactoryService getBoolTypeFactoryService() {
		return(booltypeFactoryService);
	}

	@Override
	public IBusModelChainFactory getFactoryChain() {
		return(chainFactoryService);
	}

	public BusModelJpaChainFactoryService getChainFactoryService() {
		return(chainFactoryService);
	}

	@Override
	public IBusModelClearDepFactory getFactoryClearDep() {
		return(cleardepFactoryService);
	}

	public BusModelJpaClearDepFactoryService getClearDepFactoryService() {
		return(cleardepFactoryService);
	}

	@Override
	public IBusModelClearSubDep1Factory getFactoryClearSubDep1() {
		return(clearsubdep1FactoryService);
	}

	public BusModelJpaClearSubDep1FactoryService getClearSubDep1FactoryService() {
		return(clearsubdep1FactoryService);
	}

	@Override
	public IBusModelClearSubDep2Factory getFactoryClearSubDep2() {
		return(clearsubdep2FactoryService);
	}

	public BusModelJpaClearSubDep2FactoryService getClearSubDep2FactoryService() {
		return(clearsubdep2FactoryService);
	}

	@Override
	public IBusModelClearSubDep3Factory getFactoryClearSubDep3() {
		return(clearsubdep3FactoryService);
	}

	public BusModelJpaClearSubDep3FactoryService getClearSubDep3FactoryService() {
		return(clearsubdep3FactoryService);
	}

	@Override
	public IBusModelClearTopDepFactory getFactoryClearTopDep() {
		return(cleartopdepFactoryService);
	}

	public BusModelJpaClearTopDepFactoryService getClearTopDepFactoryService() {
		return(cleartopdepFactoryService);
	}

	@Override
	public IBusModelDateDefFactory getFactoryDateDef() {
		return(datedefFactoryService);
	}

	public BusModelJpaDateDefFactoryService getDateDefFactoryService() {
		return(datedefFactoryService);
	}

	@Override
	public IBusModelDateTypeFactory getFactoryDateType() {
		return(datetypeFactoryService);
	}

	public BusModelJpaDateTypeFactoryService getDateTypeFactoryService() {
		return(datetypeFactoryService);
	}

	@Override
	public IBusModelDelDepFactory getFactoryDelDep() {
		return(deldepFactoryService);
	}

	public BusModelJpaDelDepFactoryService getDelDepFactoryService() {
		return(deldepFactoryService);
	}

	@Override
	public IBusModelDelSubDep1Factory getFactoryDelSubDep1() {
		return(delsubdep1FactoryService);
	}

	public BusModelJpaDelSubDep1FactoryService getDelSubDep1FactoryService() {
		return(delsubdep1FactoryService);
	}

	@Override
	public IBusModelDelSubDep2Factory getFactoryDelSubDep2() {
		return(delsubdep2FactoryService);
	}

	public BusModelJpaDelSubDep2FactoryService getDelSubDep2FactoryService() {
		return(delsubdep2FactoryService);
	}

	@Override
	public IBusModelDelSubDep3Factory getFactoryDelSubDep3() {
		return(delsubdep3FactoryService);
	}

	public BusModelJpaDelSubDep3FactoryService getDelSubDep3FactoryService() {
		return(delsubdep3FactoryService);
	}

	@Override
	public IBusModelDelTopDepFactory getFactoryDelTopDep() {
		return(deltopdepFactoryService);
	}

	public BusModelJpaDelTopDepFactoryService getDelTopDepFactoryService() {
		return(deltopdepFactoryService);
	}

	@Override
	public IBusModelDoubleDefFactory getFactoryDoubleDef() {
		return(doubledefFactoryService);
	}

	public BusModelJpaDoubleDefFactoryService getDoubleDefFactoryService() {
		return(doubledefFactoryService);
	}

	@Override
	public IBusModelDoubleTypeFactory getFactoryDoubleType() {
		return(doubletypeFactoryService);
	}

	public BusModelJpaDoubleTypeFactoryService getDoubleTypeFactoryService() {
		return(doubletypeFactoryService);
	}

	@Override
	public IBusModelEnumTagFactory getFactoryEnumTag() {
		return(enumtagFactoryService);
	}

	public BusModelJpaEnumTagFactoryService getEnumTagFactoryService() {
		return(enumtagFactoryService);
	}

	@Override
	public IBusModelFloatDefFactory getFactoryFloatDef() {
		return(floatdefFactoryService);
	}

	public BusModelJpaFloatDefFactoryService getFloatDefFactoryService() {
		return(floatdefFactoryService);
	}

	@Override
	public IBusModelFloatTypeFactory getFactoryFloatType() {
		return(floattypeFactoryService);
	}

	public BusModelJpaFloatTypeFactoryService getFloatTypeFactoryService() {
		return(floattypeFactoryService);
	}

	@Override
	public IBusModelIndexFactory getFactoryIndex() {
		return(indexFactoryService);
	}

	public BusModelJpaIndexFactoryService getIndexFactoryService() {
		return(indexFactoryService);
	}

	@Override
	public IBusModelIndexColFactory getFactoryIndexCol() {
		return(indexcolFactoryService);
	}

	public BusModelJpaIndexColFactoryService getIndexColFactoryService() {
		return(indexcolFactoryService);
	}

	@Override
	public IBusModelInt16DefFactory getFactoryInt16Def() {
		return(int16defFactoryService);
	}

	public BusModelJpaInt16DefFactoryService getInt16DefFactoryService() {
		return(int16defFactoryService);
	}

	@Override
	public IBusModelInt16TypeFactory getFactoryInt16Type() {
		return(int16typeFactoryService);
	}

	public BusModelJpaInt16TypeFactoryService getInt16TypeFactoryService() {
		return(int16typeFactoryService);
	}

	@Override
	public IBusModelInt32DefFactory getFactoryInt32Def() {
		return(int32defFactoryService);
	}

	public BusModelJpaInt32DefFactoryService getInt32DefFactoryService() {
		return(int32defFactoryService);
	}

	@Override
	public IBusModelInt32TypeFactory getFactoryInt32Type() {
		return(int32typeFactoryService);
	}

	public BusModelJpaInt32TypeFactoryService getInt32TypeFactoryService() {
		return(int32typeFactoryService);
	}

	@Override
	public IBusModelInt64DefFactory getFactoryInt64Def() {
		return(int64defFactoryService);
	}

	public BusModelJpaInt64DefFactoryService getInt64DefFactoryService() {
		return(int64defFactoryService);
	}

	@Override
	public IBusModelInt64TypeFactory getFactoryInt64Type() {
		return(int64typeFactoryService);
	}

	public BusModelJpaInt64TypeFactoryService getInt64TypeFactoryService() {
		return(int64typeFactoryService);
	}

	@Override
	public IBusModelNmTokenDefFactory getFactoryNmTokenDef() {
		return(nmtokendefFactoryService);
	}

	public BusModelJpaNmTokenDefFactoryService getNmTokenDefFactoryService() {
		return(nmtokendefFactoryService);
	}

	@Override
	public IBusModelNmTokenTypeFactory getFactoryNmTokenType() {
		return(nmtokentypeFactoryService);
	}

	public BusModelJpaNmTokenTypeFactoryService getNmTokenTypeFactoryService() {
		return(nmtokentypeFactoryService);
	}

	@Override
	public IBusModelNmTokensDefFactory getFactoryNmTokensDef() {
		return(nmtokensdefFactoryService);
	}

	public BusModelJpaNmTokensDefFactoryService getNmTokensDefFactoryService() {
		return(nmtokensdefFactoryService);
	}

	@Override
	public IBusModelNmTokensTypeFactory getFactoryNmTokensType() {
		return(nmtokenstypeFactoryService);
	}

	public BusModelJpaNmTokensTypeFactoryService getNmTokensTypeFactoryService() {
		return(nmtokenstypeFactoryService);
	}

	@Override
	public IBusModelNumberDefFactory getFactoryNumberDef() {
		return(numberdefFactoryService);
	}

	public BusModelJpaNumberDefFactoryService getNumberDefFactoryService() {
		return(numberdefFactoryService);
	}

	@Override
	public IBusModelNumberTypeFactory getFactoryNumberType() {
		return(numbertypeFactoryService);
	}

	public BusModelJpaNumberTypeFactoryService getNumberTypeFactoryService() {
		return(numbertypeFactoryService);
	}

	@Override
	public IBusModelParamFactory getFactoryParam() {
		return(paramFactoryService);
	}

	public BusModelJpaParamFactoryService getParamFactoryService() {
		return(paramFactoryService);
	}

	@Override
	public IBusModelPopDepFactory getFactoryPopDep() {
		return(popdepFactoryService);
	}

	public BusModelJpaPopDepFactoryService getPopDepFactoryService() {
		return(popdepFactoryService);
	}

	@Override
	public IBusModelPopSubDep1Factory getFactoryPopSubDep1() {
		return(popsubdep1FactoryService);
	}

	public BusModelJpaPopSubDep1FactoryService getPopSubDep1FactoryService() {
		return(popsubdep1FactoryService);
	}

	@Override
	public IBusModelPopSubDep2Factory getFactoryPopSubDep2() {
		return(popsubdep2FactoryService);
	}

	public BusModelJpaPopSubDep2FactoryService getPopSubDep2FactoryService() {
		return(popsubdep2FactoryService);
	}

	@Override
	public IBusModelPopSubDep3Factory getFactoryPopSubDep3() {
		return(popsubdep3FactoryService);
	}

	public BusModelJpaPopSubDep3FactoryService getPopSubDep3FactoryService() {
		return(popsubdep3FactoryService);
	}

	@Override
	public IBusModelPopTopDepFactory getFactoryPopTopDep() {
		return(poptopdepFactoryService);
	}

	public BusModelJpaPopTopDepFactoryService getPopTopDepFactoryService() {
		return(poptopdepFactoryService);
	}

	@Override
	public IBusModelRelationFactory getFactoryRelation() {
		return(relationFactoryService);
	}

	public BusModelJpaRelationFactoryService getRelationFactoryService() {
		return(relationFactoryService);
	}

	@Override
	public IBusModelRelationColFactory getFactoryRelationCol() {
		return(relationcolFactoryService);
	}

	public BusModelJpaRelationColFactoryService getRelationColFactoryService() {
		return(relationcolFactoryService);
	}

	@Override
	public IBusModelServerListFuncFactory getFactoryServerListFunc() {
		return(serverlistfuncFactoryService);
	}

	public BusModelJpaServerListFuncFactoryService getServerListFuncFactoryService() {
		return(serverlistfuncFactoryService);
	}

	@Override
	public IBusModelDbKeyHash128DefFactory getFactoryDbKeyHash128Def() {
		return(dbkeyhash128defFactoryService);
	}

	public BusModelJpaDbKeyHash128DefFactoryService getDbKeyHash128DefFactoryService() {
		return(dbkeyhash128defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash128ColFactory getFactoryDbKeyHash128Col() {
		return(dbkeyhash128colFactoryService);
	}

	public BusModelJpaDbKeyHash128ColFactoryService getDbKeyHash128ColFactoryService() {
		return(dbkeyhash128colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash128TypeFactory getFactoryDbKeyHash128Type() {
		return(dbkeyhash128typeFactoryService);
	}

	public BusModelJpaDbKeyHash128TypeFactoryService getDbKeyHash128TypeFactoryService() {
		return(dbkeyhash128typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash128GenFactory getFactoryDbKeyHash128Gen() {
		return(dbkeyhash128genFactoryService);
	}

	public BusModelJpaDbKeyHash128GenFactoryService getDbKeyHash128GenFactoryService() {
		return(dbkeyhash128genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash160DefFactory getFactoryDbKeyHash160Def() {
		return(dbkeyhash160defFactoryService);
	}

	public BusModelJpaDbKeyHash160DefFactoryService getDbKeyHash160DefFactoryService() {
		return(dbkeyhash160defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash160ColFactory getFactoryDbKeyHash160Col() {
		return(dbkeyhash160colFactoryService);
	}

	public BusModelJpaDbKeyHash160ColFactoryService getDbKeyHash160ColFactoryService() {
		return(dbkeyhash160colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash160TypeFactory getFactoryDbKeyHash160Type() {
		return(dbkeyhash160typeFactoryService);
	}

	public BusModelJpaDbKeyHash160TypeFactoryService getDbKeyHash160TypeFactoryService() {
		return(dbkeyhash160typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash160GenFactory getFactoryDbKeyHash160Gen() {
		return(dbkeyhash160genFactoryService);
	}

	public BusModelJpaDbKeyHash160GenFactoryService getDbKeyHash160GenFactoryService() {
		return(dbkeyhash160genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash224DefFactory getFactoryDbKeyHash224Def() {
		return(dbkeyhash224defFactoryService);
	}

	public BusModelJpaDbKeyHash224DefFactoryService getDbKeyHash224DefFactoryService() {
		return(dbkeyhash224defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash224ColFactory getFactoryDbKeyHash224Col() {
		return(dbkeyhash224colFactoryService);
	}

	public BusModelJpaDbKeyHash224ColFactoryService getDbKeyHash224ColFactoryService() {
		return(dbkeyhash224colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash224TypeFactory getFactoryDbKeyHash224Type() {
		return(dbkeyhash224typeFactoryService);
	}

	public BusModelJpaDbKeyHash224TypeFactoryService getDbKeyHash224TypeFactoryService() {
		return(dbkeyhash224typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash224GenFactory getFactoryDbKeyHash224Gen() {
		return(dbkeyhash224genFactoryService);
	}

	public BusModelJpaDbKeyHash224GenFactoryService getDbKeyHash224GenFactoryService() {
		return(dbkeyhash224genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash256DefFactory getFactoryDbKeyHash256Def() {
		return(dbkeyhash256defFactoryService);
	}

	public BusModelJpaDbKeyHash256DefFactoryService getDbKeyHash256DefFactoryService() {
		return(dbkeyhash256defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash256ColFactory getFactoryDbKeyHash256Col() {
		return(dbkeyhash256colFactoryService);
	}

	public BusModelJpaDbKeyHash256ColFactoryService getDbKeyHash256ColFactoryService() {
		return(dbkeyhash256colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash256TypeFactory getFactoryDbKeyHash256Type() {
		return(dbkeyhash256typeFactoryService);
	}

	public BusModelJpaDbKeyHash256TypeFactoryService getDbKeyHash256TypeFactoryService() {
		return(dbkeyhash256typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash256GenFactory getFactoryDbKeyHash256Gen() {
		return(dbkeyhash256genFactoryService);
	}

	public BusModelJpaDbKeyHash256GenFactoryService getDbKeyHash256GenFactoryService() {
		return(dbkeyhash256genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash384DefFactory getFactoryDbKeyHash384Def() {
		return(dbkeyhash384defFactoryService);
	}

	public BusModelJpaDbKeyHash384DefFactoryService getDbKeyHash384DefFactoryService() {
		return(dbkeyhash384defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash384ColFactory getFactoryDbKeyHash384Col() {
		return(dbkeyhash384colFactoryService);
	}

	public BusModelJpaDbKeyHash384ColFactoryService getDbKeyHash384ColFactoryService() {
		return(dbkeyhash384colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash384TypeFactory getFactoryDbKeyHash384Type() {
		return(dbkeyhash384typeFactoryService);
	}

	public BusModelJpaDbKeyHash384TypeFactoryService getDbKeyHash384TypeFactoryService() {
		return(dbkeyhash384typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash384GenFactory getFactoryDbKeyHash384Gen() {
		return(dbkeyhash384genFactoryService);
	}

	public BusModelJpaDbKeyHash384GenFactoryService getDbKeyHash384GenFactoryService() {
		return(dbkeyhash384genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash512DefFactory getFactoryDbKeyHash512Def() {
		return(dbkeyhash512defFactoryService);
	}

	public BusModelJpaDbKeyHash512DefFactoryService getDbKeyHash512DefFactoryService() {
		return(dbkeyhash512defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash512ColFactory getFactoryDbKeyHash512Col() {
		return(dbkeyhash512colFactoryService);
	}

	public BusModelJpaDbKeyHash512ColFactoryService getDbKeyHash512ColFactoryService() {
		return(dbkeyhash512colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash512TypeFactory getFactoryDbKeyHash512Type() {
		return(dbkeyhash512typeFactoryService);
	}

	public BusModelJpaDbKeyHash512TypeFactoryService getDbKeyHash512TypeFactoryService() {
		return(dbkeyhash512typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash512GenFactory getFactoryDbKeyHash512Gen() {
		return(dbkeyhash512genFactoryService);
	}

	public BusModelJpaDbKeyHash512GenFactoryService getDbKeyHash512GenFactoryService() {
		return(dbkeyhash512genFactoryService);
	}

	@Override
	public IBusModelStringDefFactory getFactoryStringDef() {
		return(stringdefFactoryService);
	}

	public BusModelJpaStringDefFactoryService getStringDefFactoryService() {
		return(stringdefFactoryService);
	}

	@Override
	public IBusModelStringTypeFactory getFactoryStringType() {
		return(stringtypeFactoryService);
	}

	public BusModelJpaStringTypeFactoryService getStringTypeFactoryService() {
		return(stringtypeFactoryService);
	}

	@Override
	public IBusModelTZDateDefFactory getFactoryTZDateDef() {
		return(tzdatedefFactoryService);
	}

	public BusModelJpaTZDateDefFactoryService getTZDateDefFactoryService() {
		return(tzdatedefFactoryService);
	}

	@Override
	public IBusModelTZDateTypeFactory getFactoryTZDateType() {
		return(tzdatetypeFactoryService);
	}

	public BusModelJpaTZDateTypeFactoryService getTZDateTypeFactoryService() {
		return(tzdatetypeFactoryService);
	}

	@Override
	public IBusModelTZTimeDefFactory getFactoryTZTimeDef() {
		return(tztimedefFactoryService);
	}

	public BusModelJpaTZTimeDefFactoryService getTZTimeDefFactoryService() {
		return(tztimedefFactoryService);
	}

	@Override
	public IBusModelTZTimeTypeFactory getFactoryTZTimeType() {
		return(tztimetypeFactoryService);
	}

	public BusModelJpaTZTimeTypeFactoryService getTZTimeTypeFactoryService() {
		return(tztimetypeFactoryService);
	}

	@Override
	public IBusModelTZTimestampDefFactory getFactoryTZTimestampDef() {
		return(tztimestampdefFactoryService);
	}

	public BusModelJpaTZTimestampDefFactoryService getTZTimestampDefFactoryService() {
		return(tztimestampdefFactoryService);
	}

	@Override
	public IBusModelTZTimestampTypeFactory getFactoryTZTimestampType() {
		return(tztimestamptypeFactoryService);
	}

	public BusModelJpaTZTimestampTypeFactoryService getTZTimestampTypeFactoryService() {
		return(tztimestamptypeFactoryService);
	}

	@Override
	public IBusModelTableColFactory getFactoryTableCol() {
		return(tablecolFactoryService);
	}

	public BusModelJpaTableColFactoryService getTableColFactoryService() {
		return(tablecolFactoryService);
	}

	@Override
	public IBusModelTextDefFactory getFactoryTextDef() {
		return(textdefFactoryService);
	}

	public BusModelJpaTextDefFactoryService getTextDefFactoryService() {
		return(textdefFactoryService);
	}

	@Override
	public IBusModelTextTypeFactory getFactoryTextType() {
		return(texttypeFactoryService);
	}

	public BusModelJpaTextTypeFactoryService getTextTypeFactoryService() {
		return(texttypeFactoryService);
	}

	@Override
	public IBusModelTimeDefFactory getFactoryTimeDef() {
		return(timedefFactoryService);
	}

	public BusModelJpaTimeDefFactoryService getTimeDefFactoryService() {
		return(timedefFactoryService);
	}

	@Override
	public IBusModelTimeTypeFactory getFactoryTimeType() {
		return(timetypeFactoryService);
	}

	public BusModelJpaTimeTypeFactoryService getTimeTypeFactoryService() {
		return(timetypeFactoryService);
	}

	@Override
	public IBusModelTimestampDefFactory getFactoryTimestampDef() {
		return(timestampdefFactoryService);
	}

	public BusModelJpaTimestampDefFactoryService getTimestampDefFactoryService() {
		return(timestampdefFactoryService);
	}

	@Override
	public IBusModelTimestampTypeFactory getFactoryTimestampType() {
		return(timestamptypeFactoryService);
	}

	public BusModelJpaTimestampTypeFactoryService getTimestampTypeFactoryService() {
		return(timestamptypeFactoryService);
	}

	@Override
	public IBusModelTokenDefFactory getFactoryTokenDef() {
		return(tokendefFactoryService);
	}

	public BusModelJpaTokenDefFactoryService getTokenDefFactoryService() {
		return(tokendefFactoryService);
	}

	@Override
	public IBusModelTokenTypeFactory getFactoryTokenType() {
		return(tokentypeFactoryService);
	}

	public BusModelJpaTokenTypeFactoryService getTokenTypeFactoryService() {
		return(tokentypeFactoryService);
	}

	@Override
	public IBusModelUInt16DefFactory getFactoryUInt16Def() {
		return(uint16defFactoryService);
	}

	public BusModelJpaUInt16DefFactoryService getUInt16DefFactoryService() {
		return(uint16defFactoryService);
	}

	@Override
	public IBusModelUInt16TypeFactory getFactoryUInt16Type() {
		return(uint16typeFactoryService);
	}

	public BusModelJpaUInt16TypeFactoryService getUInt16TypeFactoryService() {
		return(uint16typeFactoryService);
	}

	@Override
	public IBusModelUInt32DefFactory getFactoryUInt32Def() {
		return(uint32defFactoryService);
	}

	public BusModelJpaUInt32DefFactoryService getUInt32DefFactoryService() {
		return(uint32defFactoryService);
	}

	@Override
	public IBusModelUInt32TypeFactory getFactoryUInt32Type() {
		return(uint32typeFactoryService);
	}

	public BusModelJpaUInt32TypeFactoryService getUInt32TypeFactoryService() {
		return(uint32typeFactoryService);
	}

	@Override
	public IBusModelUInt64DefFactory getFactoryUInt64Def() {
		return(uint64defFactoryService);
	}

	public BusModelJpaUInt64DefFactoryService getUInt64DefFactoryService() {
		return(uint64defFactoryService);
	}

	@Override
	public IBusModelUInt64TypeFactory getFactoryUInt64Type() {
		return(uint64typeFactoryService);
	}

	public BusModelJpaUInt64TypeFactoryService getUInt64TypeFactoryService() {
		return(uint64typeFactoryService);
	}

	@Override
	public IBusModelUuidDefFactory getFactoryUuidDef() {
		return(uuiddefFactoryService);
	}

	public BusModelJpaUuidDefFactoryService getUuidDefFactoryService() {
		return(uuiddefFactoryService);
	}

	@Override
	public IBusModelUuid6DefFactory getFactoryUuid6Def() {
		return(uuid6defFactoryService);
	}

	public BusModelJpaUuid6DefFactoryService getUuid6DefFactoryService() {
		return(uuid6defFactoryService);
	}

	@Override
	public IBusModelUuidTypeFactory getFactoryUuidType() {
		return(uuidtypeFactoryService);
	}

	public BusModelJpaUuidTypeFactoryService getUuidTypeFactoryService() {
		return(uuidtypeFactoryService);
	}

	@Override
	public IBusModelUuid6TypeFactory getFactoryUuid6Type() {
		return(uuid6typeFactoryService);
	}

	public BusModelJpaUuid6TypeFactoryService getUuid6TypeFactoryService() {
		return(uuid6typeFactoryService);
	}

	@Override
	public IBusModelBlobColFactory getFactoryBlobCol() {
		return(blobcolFactoryService);
	}

	public BusModelJpaBlobColFactoryService getBlobColFactoryService() {
		return(blobcolFactoryService);
	}

	@Override
	public IBusModelBoolColFactory getFactoryBoolCol() {
		return(boolcolFactoryService);
	}

	public BusModelJpaBoolColFactoryService getBoolColFactoryService() {
		return(boolcolFactoryService);
	}

	@Override
	public IBusModelDateColFactory getFactoryDateCol() {
		return(datecolFactoryService);
	}

	public BusModelJpaDateColFactoryService getDateColFactoryService() {
		return(datecolFactoryService);
	}

	@Override
	public IBusModelDoubleColFactory getFactoryDoubleCol() {
		return(doublecolFactoryService);
	}

	public BusModelJpaDoubleColFactoryService getDoubleColFactoryService() {
		return(doublecolFactoryService);
	}

	@Override
	public IBusModelEnumDefFactory getFactoryEnumDef() {
		return(enumdefFactoryService);
	}

	public BusModelJpaEnumDefFactoryService getEnumDefFactoryService() {
		return(enumdefFactoryService);
	}

	@Override
	public IBusModelEnumTypeFactory getFactoryEnumType() {
		return(enumtypeFactoryService);
	}

	public BusModelJpaEnumTypeFactoryService getEnumTypeFactoryService() {
		return(enumtypeFactoryService);
	}

	@Override
	public IBusModelFloatColFactory getFactoryFloatCol() {
		return(floatcolFactoryService);
	}

	public BusModelJpaFloatColFactoryService getFloatColFactoryService() {
		return(floatcolFactoryService);
	}

	@Override
	public IBusModelId16GenFactory getFactoryId16Gen() {
		return(id16genFactoryService);
	}

	public BusModelJpaId16GenFactoryService getId16GenFactoryService() {
		return(id16genFactoryService);
	}

	@Override
	public IBusModelId32GenFactory getFactoryId32Gen() {
		return(id32genFactoryService);
	}

	public BusModelJpaId32GenFactoryService getId32GenFactoryService() {
		return(id32genFactoryService);
	}

	@Override
	public IBusModelId64GenFactory getFactoryId64Gen() {
		return(id64genFactoryService);
	}

	public BusModelJpaId64GenFactoryService getId64GenFactoryService() {
		return(id64genFactoryService);
	}

	@Override
	public IBusModelInt16ColFactory getFactoryInt16Col() {
		return(int16colFactoryService);
	}

	public BusModelJpaInt16ColFactoryService getInt16ColFactoryService() {
		return(int16colFactoryService);
	}

	@Override
	public IBusModelInt32ColFactory getFactoryInt32Col() {
		return(int32colFactoryService);
	}

	public BusModelJpaInt32ColFactoryService getInt32ColFactoryService() {
		return(int32colFactoryService);
	}

	@Override
	public IBusModelInt64ColFactory getFactoryInt64Col() {
		return(int64colFactoryService);
	}

	public BusModelJpaInt64ColFactoryService getInt64ColFactoryService() {
		return(int64colFactoryService);
	}

	@Override
	public IBusModelNmTokenColFactory getFactoryNmTokenCol() {
		return(nmtokencolFactoryService);
	}

	public BusModelJpaNmTokenColFactoryService getNmTokenColFactoryService() {
		return(nmtokencolFactoryService);
	}

	@Override
	public IBusModelNmTokensColFactory getFactoryNmTokensCol() {
		return(nmtokenscolFactoryService);
	}

	public BusModelJpaNmTokensColFactoryService getNmTokensColFactoryService() {
		return(nmtokenscolFactoryService);
	}

	@Override
	public IBusModelNumberColFactory getFactoryNumberCol() {
		return(numbercolFactoryService);
	}

	public BusModelJpaNumberColFactoryService getNumberColFactoryService() {
		return(numbercolFactoryService);
	}

	@Override
	public IBusModelStringColFactory getFactoryStringCol() {
		return(stringcolFactoryService);
	}

	public BusModelJpaStringColFactoryService getStringColFactoryService() {
		return(stringcolFactoryService);
	}

	@Override
	public IBusModelTZDateColFactory getFactoryTZDateCol() {
		return(tzdatecolFactoryService);
	}

	public BusModelJpaTZDateColFactoryService getTZDateColFactoryService() {
		return(tzdatecolFactoryService);
	}

	@Override
	public IBusModelTZTimeColFactory getFactoryTZTimeCol() {
		return(tztimecolFactoryService);
	}

	public BusModelJpaTZTimeColFactoryService getTZTimeColFactoryService() {
		return(tztimecolFactoryService);
	}

	@Override
	public IBusModelTZTimestampColFactory getFactoryTZTimestampCol() {
		return(tztimestampcolFactoryService);
	}

	public BusModelJpaTZTimestampColFactoryService getTZTimestampColFactoryService() {
		return(tztimestampcolFactoryService);
	}

	@Override
	public IBusModelTextColFactory getFactoryTextCol() {
		return(textcolFactoryService);
	}

	public BusModelJpaTextColFactoryService getTextColFactoryService() {
		return(textcolFactoryService);
	}

	@Override
	public IBusModelTimeColFactory getFactoryTimeCol() {
		return(timecolFactoryService);
	}

	public BusModelJpaTimeColFactoryService getTimeColFactoryService() {
		return(timecolFactoryService);
	}

	@Override
	public IBusModelTimestampColFactory getFactoryTimestampCol() {
		return(timestampcolFactoryService);
	}

	public BusModelJpaTimestampColFactoryService getTimestampColFactoryService() {
		return(timestampcolFactoryService);
	}

	@Override
	public IBusModelTokenColFactory getFactoryTokenCol() {
		return(tokencolFactoryService);
	}

	public BusModelJpaTokenColFactoryService getTokenColFactoryService() {
		return(tokencolFactoryService);
	}

	@Override
	public IBusModelUInt16ColFactory getFactoryUInt16Col() {
		return(uint16colFactoryService);
	}

	public BusModelJpaUInt16ColFactoryService getUInt16ColFactoryService() {
		return(uint16colFactoryService);
	}

	@Override
	public IBusModelUInt32ColFactory getFactoryUInt32Col() {
		return(uint32colFactoryService);
	}

	public BusModelJpaUInt32ColFactoryService getUInt32ColFactoryService() {
		return(uint32colFactoryService);
	}

	@Override
	public IBusModelUInt64ColFactory getFactoryUInt64Col() {
		return(uint64colFactoryService);
	}

	public BusModelJpaUInt64ColFactoryService getUInt64ColFactoryService() {
		return(uint64colFactoryService);
	}

	@Override
	public IBusModelUuidColFactory getFactoryUuidCol() {
		return(uuidcolFactoryService);
	}

	public BusModelJpaUuidColFactoryService getUuidColFactoryService() {
		return(uuidcolFactoryService);
	}

	@Override
	public IBusModelUuid6ColFactory getFactoryUuid6Col() {
		return(uuid6colFactoryService);
	}

	public BusModelJpaUuid6ColFactoryService getUuid6ColFactoryService() {
		return(uuid6colFactoryService);
	}

	@Override
	public IBusModelUuidGenFactory getFactoryUuidGen() {
		return(uuidgenFactoryService);
	}

	public BusModelJpaUuidGenFactoryService getUuidGenFactoryService() {
		return(uuidgenFactoryService);
	}

	@Override
	public IBusModelUuid6GenFactory getFactoryUuid6Gen() {
		return(uuid6genFactoryService);
	}

	public BusModelJpaUuid6GenFactoryService getUuid6GenFactoryService() {
		return(uuid6genFactoryService);
	}

	@Override
	public IBusModelRoleDefFactory getFactoryRoleDef() {
		return(roledefFactoryService);
	}

	public BusModelJpaRoleDefFactoryService getRoleDefFactoryService() {
		return(roledefFactoryService);
	}

	@Override
	public IBusModelSchemaRoleFactory getFactorySchemaRole() {
		return(schemaroleFactoryService);
	}

	public BusModelJpaSchemaRoleFactoryService getSchemaRoleFactoryService() {
		return(schemaroleFactoryService);
	}

}
