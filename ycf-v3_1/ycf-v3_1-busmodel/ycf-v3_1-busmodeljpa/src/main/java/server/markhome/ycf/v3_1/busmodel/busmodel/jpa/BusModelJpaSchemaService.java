// Description: Java 25 Spring JPA Service for BusModel

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
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

/**
 *	Services for schema BusModel defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModel*Repository objects to access the data directly, bypassing normal application security for the bootstrap and login processing.
 */
@Service("busmodel31JpaSchemaService")
public class BusModelJpaSchemaService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;
	@Autowired
	private BusModelJpaScopeService scopeService;

	@Autowired
	private BusModelJpaSchemaDefService schemadefService;

	@Autowired
	private BusModelJpaSchemaRefService schemarefService;

	@Autowired
	private BusModelJpaServerMethodService servermethodService;

	@Autowired
	private BusModelJpaServerObjFuncService serverobjfuncService;

	@Autowired
	private BusModelJpaServerProcService serverprocService;

	@Autowired
	private BusModelJpaTableService tableService;

	@Autowired
	private BusModelJpaTweakService tweakService;

	@Autowired
	private BusModelJpaTableTweakService tabletweakService;

	@Autowired
	private BusModelJpaSchemaTweakService schematweakService;

	@Autowired
	private BusModelJpaIndexTweakService indextweakService;

	@Autowired
	private BusModelJpaValueService valueService;

	@Autowired
	private BusModelJpaAtomService atomService;

	@Autowired
	private BusModelJpaBlobDefService blobdefService;

	@Autowired
	private BusModelJpaBlobTypeService blobtypeService;

	@Autowired
	private BusModelJpaBoolDefService booldefService;

	@Autowired
	private BusModelJpaBoolTypeService booltypeService;

	@Autowired
	private BusModelJpaChainService chainService;

	@Autowired
	private BusModelJpaClearDepService cleardepService;

	@Autowired
	private BusModelJpaClearSubDep1Service clearsubdep1Service;

	@Autowired
	private BusModelJpaClearSubDep2Service clearsubdep2Service;

	@Autowired
	private BusModelJpaClearSubDep3Service clearsubdep3Service;

	@Autowired
	private BusModelJpaClearTopDepService cleartopdepService;

	@Autowired
	private BusModelJpaDateDefService datedefService;

	@Autowired
	private BusModelJpaDateTypeService datetypeService;

	@Autowired
	private BusModelJpaDelDepService deldepService;

	@Autowired
	private BusModelJpaDelSubDep1Service delsubdep1Service;

	@Autowired
	private BusModelJpaDelSubDep2Service delsubdep2Service;

	@Autowired
	private BusModelJpaDelSubDep3Service delsubdep3Service;

	@Autowired
	private BusModelJpaDelTopDepService deltopdepService;

	@Autowired
	private BusModelJpaDoubleDefService doubledefService;

	@Autowired
	private BusModelJpaDoubleTypeService doubletypeService;

	@Autowired
	private BusModelJpaEnumTagService enumtagService;

	@Autowired
	private BusModelJpaFloatDefService floatdefService;

	@Autowired
	private BusModelJpaFloatTypeService floattypeService;

	@Autowired
	private BusModelJpaIndexService indexService;

	@Autowired
	private BusModelJpaIndexColService indexcolService;

	@Autowired
	private BusModelJpaInt16DefService int16defService;

	@Autowired
	private BusModelJpaInt16TypeService int16typeService;

	@Autowired
	private BusModelJpaInt32DefService int32defService;

	@Autowired
	private BusModelJpaInt32TypeService int32typeService;

	@Autowired
	private BusModelJpaInt64DefService int64defService;

	@Autowired
	private BusModelJpaInt64TypeService int64typeService;

	@Autowired
	private BusModelJpaNmTokenDefService nmtokendefService;

	@Autowired
	private BusModelJpaNmTokenTypeService nmtokentypeService;

	@Autowired
	private BusModelJpaNmTokensDefService nmtokensdefService;

	@Autowired
	private BusModelJpaNmTokensTypeService nmtokenstypeService;

	@Autowired
	private BusModelJpaNumberDefService numberdefService;

	@Autowired
	private BusModelJpaNumberTypeService numbertypeService;

	@Autowired
	private BusModelJpaParamService paramService;

	@Autowired
	private BusModelJpaPopDepService popdepService;

	@Autowired
	private BusModelJpaPopSubDep1Service popsubdep1Service;

	@Autowired
	private BusModelJpaPopSubDep2Service popsubdep2Service;

	@Autowired
	private BusModelJpaPopSubDep3Service popsubdep3Service;

	@Autowired
	private BusModelJpaPopTopDepService poptopdepService;

	@Autowired
	private BusModelJpaRelationService relationService;

	@Autowired
	private BusModelJpaRelationColService relationcolService;

	@Autowired
	private BusModelJpaServerListFuncService serverlistfuncService;

	@Autowired
	private BusModelJpaDbKeyHash128DefService dbkeyhash128defService;

	@Autowired
	private BusModelJpaDbKeyHash128ColService dbkeyhash128colService;

	@Autowired
	private BusModelJpaDbKeyHash128TypeService dbkeyhash128typeService;

	@Autowired
	private BusModelJpaDbKeyHash128GenService dbkeyhash128genService;

	@Autowired
	private BusModelJpaDbKeyHash160DefService dbkeyhash160defService;

	@Autowired
	private BusModelJpaDbKeyHash160ColService dbkeyhash160colService;

	@Autowired
	private BusModelJpaDbKeyHash160TypeService dbkeyhash160typeService;

	@Autowired
	private BusModelJpaDbKeyHash160GenService dbkeyhash160genService;

	@Autowired
	private BusModelJpaDbKeyHash224DefService dbkeyhash224defService;

	@Autowired
	private BusModelJpaDbKeyHash224ColService dbkeyhash224colService;

	@Autowired
	private BusModelJpaDbKeyHash224TypeService dbkeyhash224typeService;

	@Autowired
	private BusModelJpaDbKeyHash224GenService dbkeyhash224genService;

	@Autowired
	private BusModelJpaDbKeyHash256DefService dbkeyhash256defService;

	@Autowired
	private BusModelJpaDbKeyHash256ColService dbkeyhash256colService;

	@Autowired
	private BusModelJpaDbKeyHash256TypeService dbkeyhash256typeService;

	@Autowired
	private BusModelJpaDbKeyHash256GenService dbkeyhash256genService;

	@Autowired
	private BusModelJpaDbKeyHash384DefService dbkeyhash384defService;

	@Autowired
	private BusModelJpaDbKeyHash384ColService dbkeyhash384colService;

	@Autowired
	private BusModelJpaDbKeyHash384TypeService dbkeyhash384typeService;

	@Autowired
	private BusModelJpaDbKeyHash384GenService dbkeyhash384genService;

	@Autowired
	private BusModelJpaDbKeyHash512DefService dbkeyhash512defService;

	@Autowired
	private BusModelJpaDbKeyHash512ColService dbkeyhash512colService;

	@Autowired
	private BusModelJpaDbKeyHash512TypeService dbkeyhash512typeService;

	@Autowired
	private BusModelJpaDbKeyHash512GenService dbkeyhash512genService;

	@Autowired
	private BusModelJpaStringDefService stringdefService;

	@Autowired
	private BusModelJpaStringTypeService stringtypeService;

	@Autowired
	private BusModelJpaTZDateDefService tzdatedefService;

	@Autowired
	private BusModelJpaTZDateTypeService tzdatetypeService;

	@Autowired
	private BusModelJpaTZTimeDefService tztimedefService;

	@Autowired
	private BusModelJpaTZTimeTypeService tztimetypeService;

	@Autowired
	private BusModelJpaTZTimestampDefService tztimestampdefService;

	@Autowired
	private BusModelJpaTZTimestampTypeService tztimestamptypeService;

	@Autowired
	private BusModelJpaTableColService tablecolService;

	@Autowired
	private BusModelJpaTextDefService textdefService;

	@Autowired
	private BusModelJpaTextTypeService texttypeService;

	@Autowired
	private BusModelJpaTimeDefService timedefService;

	@Autowired
	private BusModelJpaTimeTypeService timetypeService;

	@Autowired
	private BusModelJpaTimestampDefService timestampdefService;

	@Autowired
	private BusModelJpaTimestampTypeService timestamptypeService;

	@Autowired
	private BusModelJpaTokenDefService tokendefService;

	@Autowired
	private BusModelJpaTokenTypeService tokentypeService;

	@Autowired
	private BusModelJpaUInt16DefService uint16defService;

	@Autowired
	private BusModelJpaUInt16TypeService uint16typeService;

	@Autowired
	private BusModelJpaUInt32DefService uint32defService;

	@Autowired
	private BusModelJpaUInt32TypeService uint32typeService;

	@Autowired
	private BusModelJpaUInt64DefService uint64defService;

	@Autowired
	private BusModelJpaUInt64TypeService uint64typeService;

	@Autowired
	private BusModelJpaUuidDefService uuiddefService;

	@Autowired
	private BusModelJpaUuid6DefService uuid6defService;

	@Autowired
	private BusModelJpaUuidTypeService uuidtypeService;

	@Autowired
	private BusModelJpaUuid6TypeService uuid6typeService;

	@Autowired
	private BusModelJpaBlobColService blobcolService;

	@Autowired
	private BusModelJpaBoolColService boolcolService;

	@Autowired
	private BusModelJpaDateColService datecolService;

	@Autowired
	private BusModelJpaDoubleColService doublecolService;

	@Autowired
	private BusModelJpaEnumDefService enumdefService;

	@Autowired
	private BusModelJpaEnumTypeService enumtypeService;

	@Autowired
	private BusModelJpaFloatColService floatcolService;

	@Autowired
	private BusModelJpaId16GenService id16genService;

	@Autowired
	private BusModelJpaId32GenService id32genService;

	@Autowired
	private BusModelJpaId64GenService id64genService;

	@Autowired
	private BusModelJpaInt16ColService int16colService;

	@Autowired
	private BusModelJpaInt32ColService int32colService;

	@Autowired
	private BusModelJpaInt64ColService int64colService;

	@Autowired
	private BusModelJpaNmTokenColService nmtokencolService;

	@Autowired
	private BusModelJpaNmTokensColService nmtokenscolService;

	@Autowired
	private BusModelJpaNumberColService numbercolService;

	@Autowired
	private BusModelJpaStringColService stringcolService;

	@Autowired
	private BusModelJpaTZDateColService tzdatecolService;

	@Autowired
	private BusModelJpaTZTimeColService tztimecolService;

	@Autowired
	private BusModelJpaTZTimestampColService tztimestampcolService;

	@Autowired
	private BusModelJpaTextColService textcolService;

	@Autowired
	private BusModelJpaTimeColService timecolService;

	@Autowired
	private BusModelJpaTimestampColService timestampcolService;

	@Autowired
	private BusModelJpaTokenColService tokencolService;

	@Autowired
	private BusModelJpaUInt16ColService uint16colService;

	@Autowired
	private BusModelJpaUInt32ColService uint32colService;

	@Autowired
	private BusModelJpaUInt64ColService uint64colService;

	@Autowired
	private BusModelJpaUuidColService uuidcolService;

	@Autowired
	private BusModelJpaUuid6ColService uuid6colService;

	@Autowired
	private BusModelJpaUuidGenService uuidgenService;

	@Autowired
	private BusModelJpaUuid6GenService uuid6genService;

	@Autowired
	private BusModelJpaRoleDefService roledefService;

	@Autowired
	private BusModelJpaSchemaRoleService schemaroleService;


	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void bootstrapSchema(SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapSchema(tableData);
	}

	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapAllTablesSecurity(SecurePubTableData tableData[]) {
		bootstrapAllTablesSecurity(ISecureSchema.getSysClusterId(), ISecureSchema.getSysTenantId(), tableData);
	}

	@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]) {
		ISecureSchema.getBackingSecure().bootstrapAllTablesSecurity(clusterId, tenantId, tableData);
	}


		// Customized schematweak [Secure::BusModel].JpaSchemaServiceCustomServices
}
