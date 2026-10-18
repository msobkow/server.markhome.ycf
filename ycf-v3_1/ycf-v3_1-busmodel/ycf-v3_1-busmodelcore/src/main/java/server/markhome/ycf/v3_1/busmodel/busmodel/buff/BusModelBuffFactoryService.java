// Description: Java 25 buffer implementation of a BusModel factory service.

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
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

@Service("busmodel31BuffFactoryService")
public class BusModelBuffFactoryService
	implements IBusModelFactory
{

	@Autowired
	@Qualifier("busmodel31BuffAtomFactoryService")
	protected BusModelBuffAtomFactoryService atomFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffBlobColFactoryService")
	protected BusModelBuffBlobColFactoryService blobcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffBlobDefFactoryService")
	protected BusModelBuffBlobDefFactoryService blobdefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffBlobTypeFactoryService")
	protected BusModelBuffBlobTypeFactoryService blobtypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffBoolColFactoryService")
	protected BusModelBuffBoolColFactoryService boolcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffBoolDefFactoryService")
	protected BusModelBuffBoolDefFactoryService booldefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffBoolTypeFactoryService")
	protected BusModelBuffBoolTypeFactoryService booltypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffChainFactoryService")
	protected BusModelBuffChainFactoryService chainFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffClearDepFactoryService")
	protected BusModelBuffClearDepFactoryService cleardepFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffClearSubDep1FactoryService")
	protected BusModelBuffClearSubDep1FactoryService clearsubdep1FactoryService;

	@Autowired
	@Qualifier("busmodel31BuffClearSubDep2FactoryService")
	protected BusModelBuffClearSubDep2FactoryService clearsubdep2FactoryService;

	@Autowired
	@Qualifier("busmodel31BuffClearSubDep3FactoryService")
	protected BusModelBuffClearSubDep3FactoryService clearsubdep3FactoryService;

	@Autowired
	@Qualifier("busmodel31BuffClearTopDepFactoryService")
	protected BusModelBuffClearTopDepFactoryService cleartopdepFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDateColFactoryService")
	protected BusModelBuffDateColFactoryService datecolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDateDefFactoryService")
	protected BusModelBuffDateDefFactoryService datedefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDateTypeFactoryService")
	protected BusModelBuffDateTypeFactoryService datetypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash128ColFactoryService")
	protected BusModelBuffDbKeyHash128ColFactoryService dbkeyhash128colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash128DefFactoryService")
	protected BusModelBuffDbKeyHash128DefFactoryService dbkeyhash128defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash128GenFactoryService")
	protected BusModelBuffDbKeyHash128GenFactoryService dbkeyhash128genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash128TypeFactoryService")
	protected BusModelBuffDbKeyHash128TypeFactoryService dbkeyhash128typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash160ColFactoryService")
	protected BusModelBuffDbKeyHash160ColFactoryService dbkeyhash160colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash160DefFactoryService")
	protected BusModelBuffDbKeyHash160DefFactoryService dbkeyhash160defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash160GenFactoryService")
	protected BusModelBuffDbKeyHash160GenFactoryService dbkeyhash160genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash160TypeFactoryService")
	protected BusModelBuffDbKeyHash160TypeFactoryService dbkeyhash160typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash224ColFactoryService")
	protected BusModelBuffDbKeyHash224ColFactoryService dbkeyhash224colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash224DefFactoryService")
	protected BusModelBuffDbKeyHash224DefFactoryService dbkeyhash224defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash224GenFactoryService")
	protected BusModelBuffDbKeyHash224GenFactoryService dbkeyhash224genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash224TypeFactoryService")
	protected BusModelBuffDbKeyHash224TypeFactoryService dbkeyhash224typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash256ColFactoryService")
	protected BusModelBuffDbKeyHash256ColFactoryService dbkeyhash256colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash256DefFactoryService")
	protected BusModelBuffDbKeyHash256DefFactoryService dbkeyhash256defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash256GenFactoryService")
	protected BusModelBuffDbKeyHash256GenFactoryService dbkeyhash256genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash256TypeFactoryService")
	protected BusModelBuffDbKeyHash256TypeFactoryService dbkeyhash256typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash384ColFactoryService")
	protected BusModelBuffDbKeyHash384ColFactoryService dbkeyhash384colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash384DefFactoryService")
	protected BusModelBuffDbKeyHash384DefFactoryService dbkeyhash384defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash384GenFactoryService")
	protected BusModelBuffDbKeyHash384GenFactoryService dbkeyhash384genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash384TypeFactoryService")
	protected BusModelBuffDbKeyHash384TypeFactoryService dbkeyhash384typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash512ColFactoryService")
	protected BusModelBuffDbKeyHash512ColFactoryService dbkeyhash512colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash512DefFactoryService")
	protected BusModelBuffDbKeyHash512DefFactoryService dbkeyhash512defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash512GenFactoryService")
	protected BusModelBuffDbKeyHash512GenFactoryService dbkeyhash512genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDbKeyHash512TypeFactoryService")
	protected BusModelBuffDbKeyHash512TypeFactoryService dbkeyhash512typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDelDepFactoryService")
	protected BusModelBuffDelDepFactoryService deldepFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDelSubDep1FactoryService")
	protected BusModelBuffDelSubDep1FactoryService delsubdep1FactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDelSubDep2FactoryService")
	protected BusModelBuffDelSubDep2FactoryService delsubdep2FactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDelSubDep3FactoryService")
	protected BusModelBuffDelSubDep3FactoryService delsubdep3FactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDelTopDepFactoryService")
	protected BusModelBuffDelTopDepFactoryService deltopdepFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDoubleColFactoryService")
	protected BusModelBuffDoubleColFactoryService doublecolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDoubleDefFactoryService")
	protected BusModelBuffDoubleDefFactoryService doubledefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffDoubleTypeFactoryService")
	protected BusModelBuffDoubleTypeFactoryService doubletypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffEnumDefFactoryService")
	protected BusModelBuffEnumDefFactoryService enumdefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffEnumTagFactoryService")
	protected BusModelBuffEnumTagFactoryService enumtagFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffEnumTypeFactoryService")
	protected BusModelBuffEnumTypeFactoryService enumtypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffFloatColFactoryService")
	protected BusModelBuffFloatColFactoryService floatcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffFloatDefFactoryService")
	protected BusModelBuffFloatDefFactoryService floatdefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffFloatTypeFactoryService")
	protected BusModelBuffFloatTypeFactoryService floattypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffId16GenFactoryService")
	protected BusModelBuffId16GenFactoryService id16genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffId32GenFactoryService")
	protected BusModelBuffId32GenFactoryService id32genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffId64GenFactoryService")
	protected BusModelBuffId64GenFactoryService id64genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffIndexFactoryService")
	protected BusModelBuffIndexFactoryService indexFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffIndexColFactoryService")
	protected BusModelBuffIndexColFactoryService indexcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffIndexTweakFactoryService")
	protected BusModelBuffIndexTweakFactoryService indextweakFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffInt16ColFactoryService")
	protected BusModelBuffInt16ColFactoryService int16colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffInt16DefFactoryService")
	protected BusModelBuffInt16DefFactoryService int16defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffInt16TypeFactoryService")
	protected BusModelBuffInt16TypeFactoryService int16typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffInt32ColFactoryService")
	protected BusModelBuffInt32ColFactoryService int32colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffInt32DefFactoryService")
	protected BusModelBuffInt32DefFactoryService int32defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffInt32TypeFactoryService")
	protected BusModelBuffInt32TypeFactoryService int32typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffInt64ColFactoryService")
	protected BusModelBuffInt64ColFactoryService int64colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffInt64DefFactoryService")
	protected BusModelBuffInt64DefFactoryService int64defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffInt64TypeFactoryService")
	protected BusModelBuffInt64TypeFactoryService int64typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffNmTokenColFactoryService")
	protected BusModelBuffNmTokenColFactoryService nmtokencolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffNmTokenDefFactoryService")
	protected BusModelBuffNmTokenDefFactoryService nmtokendefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffNmTokenTypeFactoryService")
	protected BusModelBuffNmTokenTypeFactoryService nmtokentypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffNmTokensColFactoryService")
	protected BusModelBuffNmTokensColFactoryService nmtokenscolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffNmTokensDefFactoryService")
	protected BusModelBuffNmTokensDefFactoryService nmtokensdefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffNmTokensTypeFactoryService")
	protected BusModelBuffNmTokensTypeFactoryService nmtokenstypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffNumberColFactoryService")
	protected BusModelBuffNumberColFactoryService numbercolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffNumberDefFactoryService")
	protected BusModelBuffNumberDefFactoryService numberdefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffNumberTypeFactoryService")
	protected BusModelBuffNumberTypeFactoryService numbertypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffParamFactoryService")
	protected BusModelBuffParamFactoryService paramFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffPopDepFactoryService")
	protected BusModelBuffPopDepFactoryService popdepFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffPopSubDep1FactoryService")
	protected BusModelBuffPopSubDep1FactoryService popsubdep1FactoryService;

	@Autowired
	@Qualifier("busmodel31BuffPopSubDep2FactoryService")
	protected BusModelBuffPopSubDep2FactoryService popsubdep2FactoryService;

	@Autowired
	@Qualifier("busmodel31BuffPopSubDep3FactoryService")
	protected BusModelBuffPopSubDep3FactoryService popsubdep3FactoryService;

	@Autowired
	@Qualifier("busmodel31BuffPopTopDepFactoryService")
	protected BusModelBuffPopTopDepFactoryService poptopdepFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffRelationFactoryService")
	protected BusModelBuffRelationFactoryService relationFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffRelationColFactoryService")
	protected BusModelBuffRelationColFactoryService relationcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffRoleDefFactoryService")
	protected BusModelBuffRoleDefFactoryService roledefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffSchemaDefFactoryService")
	protected BusModelBuffSchemaDefFactoryService schemadefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffSchemaRefFactoryService")
	protected BusModelBuffSchemaRefFactoryService schemarefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffSchemaRoleFactoryService")
	protected BusModelBuffSchemaRoleFactoryService schemaroleFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffSchemaTweakFactoryService")
	protected BusModelBuffSchemaTweakFactoryService schematweakFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffScopeFactoryService")
	protected BusModelBuffScopeFactoryService scopeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffServerListFuncFactoryService")
	protected BusModelBuffServerListFuncFactoryService serverlistfuncFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffServerMethodFactoryService")
	protected BusModelBuffServerMethodFactoryService servermethodFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffServerObjFuncFactoryService")
	protected BusModelBuffServerObjFuncFactoryService serverobjfuncFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffServerProcFactoryService")
	protected BusModelBuffServerProcFactoryService serverprocFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffStringColFactoryService")
	protected BusModelBuffStringColFactoryService stringcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffStringDefFactoryService")
	protected BusModelBuffStringDefFactoryService stringdefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffStringTypeFactoryService")
	protected BusModelBuffStringTypeFactoryService stringtypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTZDateColFactoryService")
	protected BusModelBuffTZDateColFactoryService tzdatecolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTZDateDefFactoryService")
	protected BusModelBuffTZDateDefFactoryService tzdatedefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTZDateTypeFactoryService")
	protected BusModelBuffTZDateTypeFactoryService tzdatetypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTZTimeColFactoryService")
	protected BusModelBuffTZTimeColFactoryService tztimecolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTZTimeDefFactoryService")
	protected BusModelBuffTZTimeDefFactoryService tztimedefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTZTimeTypeFactoryService")
	protected BusModelBuffTZTimeTypeFactoryService tztimetypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTZTimestampColFactoryService")
	protected BusModelBuffTZTimestampColFactoryService tztimestampcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTZTimestampDefFactoryService")
	protected BusModelBuffTZTimestampDefFactoryService tztimestampdefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTZTimestampTypeFactoryService")
	protected BusModelBuffTZTimestampTypeFactoryService tztimestamptypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTableFactoryService")
	protected BusModelBuffTableFactoryService tableFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTableColFactoryService")
	protected BusModelBuffTableColFactoryService tablecolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTableTweakFactoryService")
	protected BusModelBuffTableTweakFactoryService tabletweakFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTextColFactoryService")
	protected BusModelBuffTextColFactoryService textcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTextDefFactoryService")
	protected BusModelBuffTextDefFactoryService textdefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTextTypeFactoryService")
	protected BusModelBuffTextTypeFactoryService texttypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTimeColFactoryService")
	protected BusModelBuffTimeColFactoryService timecolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTimeDefFactoryService")
	protected BusModelBuffTimeDefFactoryService timedefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTimeTypeFactoryService")
	protected BusModelBuffTimeTypeFactoryService timetypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTimestampColFactoryService")
	protected BusModelBuffTimestampColFactoryService timestampcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTimestampDefFactoryService")
	protected BusModelBuffTimestampDefFactoryService timestampdefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTimestampTypeFactoryService")
	protected BusModelBuffTimestampTypeFactoryService timestamptypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTokenColFactoryService")
	protected BusModelBuffTokenColFactoryService tokencolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTokenDefFactoryService")
	protected BusModelBuffTokenDefFactoryService tokendefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTokenTypeFactoryService")
	protected BusModelBuffTokenTypeFactoryService tokentypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffTweakFactoryService")
	protected BusModelBuffTweakFactoryService tweakFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUInt16ColFactoryService")
	protected BusModelBuffUInt16ColFactoryService uint16colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUInt16DefFactoryService")
	protected BusModelBuffUInt16DefFactoryService uint16defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUInt16TypeFactoryService")
	protected BusModelBuffUInt16TypeFactoryService uint16typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUInt32ColFactoryService")
	protected BusModelBuffUInt32ColFactoryService uint32colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUInt32DefFactoryService")
	protected BusModelBuffUInt32DefFactoryService uint32defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUInt32TypeFactoryService")
	protected BusModelBuffUInt32TypeFactoryService uint32typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUInt64ColFactoryService")
	protected BusModelBuffUInt64ColFactoryService uint64colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUInt64DefFactoryService")
	protected BusModelBuffUInt64DefFactoryService uint64defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUInt64TypeFactoryService")
	protected BusModelBuffUInt64TypeFactoryService uint64typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUuid6ColFactoryService")
	protected BusModelBuffUuid6ColFactoryService uuid6colFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUuid6DefFactoryService")
	protected BusModelBuffUuid6DefFactoryService uuid6defFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUuid6GenFactoryService")
	protected BusModelBuffUuid6GenFactoryService uuid6genFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUuid6TypeFactoryService")
	protected BusModelBuffUuid6TypeFactoryService uuid6typeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUuidColFactoryService")
	protected BusModelBuffUuidColFactoryService uuidcolFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUuidDefFactoryService")
	protected BusModelBuffUuidDefFactoryService uuiddefFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUuidGenFactoryService")
	protected BusModelBuffUuidGenFactoryService uuidgenFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffUuidTypeFactoryService")
	protected BusModelBuffUuidTypeFactoryService uuidtypeFactoryService;

	@Autowired
	@Qualifier("busmodel31BuffValueFactoryService")
	protected BusModelBuffValueFactoryService valueFactoryService;


	public BusModelBuffFactoryService() { }

	@Override
	public IBusModelAtomFactory getFactoryAtom() {
		return(atomFactoryService);
	}

	public BusModelBuffAtomFactoryService getAtomFactoryService() {
		return(atomFactoryService);
	}

	@Override
	public IBusModelBlobColFactory getFactoryBlobCol() {
		return(blobcolFactoryService);
	}

	public BusModelBuffBlobColFactoryService getBlobColFactoryService() {
		return(blobcolFactoryService);
	}

	@Override
	public IBusModelBlobDefFactory getFactoryBlobDef() {
		return(blobdefFactoryService);
	}

	public BusModelBuffBlobDefFactoryService getBlobDefFactoryService() {
		return(blobdefFactoryService);
	}

	@Override
	public IBusModelBlobTypeFactory getFactoryBlobType() {
		return(blobtypeFactoryService);
	}

	public BusModelBuffBlobTypeFactoryService getBlobTypeFactoryService() {
		return(blobtypeFactoryService);
	}

	@Override
	public IBusModelBoolColFactory getFactoryBoolCol() {
		return(boolcolFactoryService);
	}

	public BusModelBuffBoolColFactoryService getBoolColFactoryService() {
		return(boolcolFactoryService);
	}

	@Override
	public IBusModelBoolDefFactory getFactoryBoolDef() {
		return(booldefFactoryService);
	}

	public BusModelBuffBoolDefFactoryService getBoolDefFactoryService() {
		return(booldefFactoryService);
	}

	@Override
	public IBusModelBoolTypeFactory getFactoryBoolType() {
		return(booltypeFactoryService);
	}

	public BusModelBuffBoolTypeFactoryService getBoolTypeFactoryService() {
		return(booltypeFactoryService);
	}

	@Override
	public IBusModelChainFactory getFactoryChain() {
		return(chainFactoryService);
	}

	public BusModelBuffChainFactoryService getChainFactoryService() {
		return(chainFactoryService);
	}

	@Override
	public IBusModelClearDepFactory getFactoryClearDep() {
		return(cleardepFactoryService);
	}

	public BusModelBuffClearDepFactoryService getClearDepFactoryService() {
		return(cleardepFactoryService);
	}

	@Override
	public IBusModelClearSubDep1Factory getFactoryClearSubDep1() {
		return(clearsubdep1FactoryService);
	}

	public BusModelBuffClearSubDep1FactoryService getClearSubDep1FactoryService() {
		return(clearsubdep1FactoryService);
	}

	@Override
	public IBusModelClearSubDep2Factory getFactoryClearSubDep2() {
		return(clearsubdep2FactoryService);
	}

	public BusModelBuffClearSubDep2FactoryService getClearSubDep2FactoryService() {
		return(clearsubdep2FactoryService);
	}

	@Override
	public IBusModelClearSubDep3Factory getFactoryClearSubDep3() {
		return(clearsubdep3FactoryService);
	}

	public BusModelBuffClearSubDep3FactoryService getClearSubDep3FactoryService() {
		return(clearsubdep3FactoryService);
	}

	@Override
	public IBusModelClearTopDepFactory getFactoryClearTopDep() {
		return(cleartopdepFactoryService);
	}

	public BusModelBuffClearTopDepFactoryService getClearTopDepFactoryService() {
		return(cleartopdepFactoryService);
	}

	@Override
	public IBusModelDateColFactory getFactoryDateCol() {
		return(datecolFactoryService);
	}

	public BusModelBuffDateColFactoryService getDateColFactoryService() {
		return(datecolFactoryService);
	}

	@Override
	public IBusModelDateDefFactory getFactoryDateDef() {
		return(datedefFactoryService);
	}

	public BusModelBuffDateDefFactoryService getDateDefFactoryService() {
		return(datedefFactoryService);
	}

	@Override
	public IBusModelDateTypeFactory getFactoryDateType() {
		return(datetypeFactoryService);
	}

	public BusModelBuffDateTypeFactoryService getDateTypeFactoryService() {
		return(datetypeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash128ColFactory getFactoryDbKeyHash128Col() {
		return(dbkeyhash128colFactoryService);
	}

	public BusModelBuffDbKeyHash128ColFactoryService getDbKeyHash128ColFactoryService() {
		return(dbkeyhash128colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash128DefFactory getFactoryDbKeyHash128Def() {
		return(dbkeyhash128defFactoryService);
	}

	public BusModelBuffDbKeyHash128DefFactoryService getDbKeyHash128DefFactoryService() {
		return(dbkeyhash128defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash128GenFactory getFactoryDbKeyHash128Gen() {
		return(dbkeyhash128genFactoryService);
	}

	public BusModelBuffDbKeyHash128GenFactoryService getDbKeyHash128GenFactoryService() {
		return(dbkeyhash128genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash128TypeFactory getFactoryDbKeyHash128Type() {
		return(dbkeyhash128typeFactoryService);
	}

	public BusModelBuffDbKeyHash128TypeFactoryService getDbKeyHash128TypeFactoryService() {
		return(dbkeyhash128typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash160ColFactory getFactoryDbKeyHash160Col() {
		return(dbkeyhash160colFactoryService);
	}

	public BusModelBuffDbKeyHash160ColFactoryService getDbKeyHash160ColFactoryService() {
		return(dbkeyhash160colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash160DefFactory getFactoryDbKeyHash160Def() {
		return(dbkeyhash160defFactoryService);
	}

	public BusModelBuffDbKeyHash160DefFactoryService getDbKeyHash160DefFactoryService() {
		return(dbkeyhash160defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash160GenFactory getFactoryDbKeyHash160Gen() {
		return(dbkeyhash160genFactoryService);
	}

	public BusModelBuffDbKeyHash160GenFactoryService getDbKeyHash160GenFactoryService() {
		return(dbkeyhash160genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash160TypeFactory getFactoryDbKeyHash160Type() {
		return(dbkeyhash160typeFactoryService);
	}

	public BusModelBuffDbKeyHash160TypeFactoryService getDbKeyHash160TypeFactoryService() {
		return(dbkeyhash160typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash224ColFactory getFactoryDbKeyHash224Col() {
		return(dbkeyhash224colFactoryService);
	}

	public BusModelBuffDbKeyHash224ColFactoryService getDbKeyHash224ColFactoryService() {
		return(dbkeyhash224colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash224DefFactory getFactoryDbKeyHash224Def() {
		return(dbkeyhash224defFactoryService);
	}

	public BusModelBuffDbKeyHash224DefFactoryService getDbKeyHash224DefFactoryService() {
		return(dbkeyhash224defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash224GenFactory getFactoryDbKeyHash224Gen() {
		return(dbkeyhash224genFactoryService);
	}

	public BusModelBuffDbKeyHash224GenFactoryService getDbKeyHash224GenFactoryService() {
		return(dbkeyhash224genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash224TypeFactory getFactoryDbKeyHash224Type() {
		return(dbkeyhash224typeFactoryService);
	}

	public BusModelBuffDbKeyHash224TypeFactoryService getDbKeyHash224TypeFactoryService() {
		return(dbkeyhash224typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash256ColFactory getFactoryDbKeyHash256Col() {
		return(dbkeyhash256colFactoryService);
	}

	public BusModelBuffDbKeyHash256ColFactoryService getDbKeyHash256ColFactoryService() {
		return(dbkeyhash256colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash256DefFactory getFactoryDbKeyHash256Def() {
		return(dbkeyhash256defFactoryService);
	}

	public BusModelBuffDbKeyHash256DefFactoryService getDbKeyHash256DefFactoryService() {
		return(dbkeyhash256defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash256GenFactory getFactoryDbKeyHash256Gen() {
		return(dbkeyhash256genFactoryService);
	}

	public BusModelBuffDbKeyHash256GenFactoryService getDbKeyHash256GenFactoryService() {
		return(dbkeyhash256genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash256TypeFactory getFactoryDbKeyHash256Type() {
		return(dbkeyhash256typeFactoryService);
	}

	public BusModelBuffDbKeyHash256TypeFactoryService getDbKeyHash256TypeFactoryService() {
		return(dbkeyhash256typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash384ColFactory getFactoryDbKeyHash384Col() {
		return(dbkeyhash384colFactoryService);
	}

	public BusModelBuffDbKeyHash384ColFactoryService getDbKeyHash384ColFactoryService() {
		return(dbkeyhash384colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash384DefFactory getFactoryDbKeyHash384Def() {
		return(dbkeyhash384defFactoryService);
	}

	public BusModelBuffDbKeyHash384DefFactoryService getDbKeyHash384DefFactoryService() {
		return(dbkeyhash384defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash384GenFactory getFactoryDbKeyHash384Gen() {
		return(dbkeyhash384genFactoryService);
	}

	public BusModelBuffDbKeyHash384GenFactoryService getDbKeyHash384GenFactoryService() {
		return(dbkeyhash384genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash384TypeFactory getFactoryDbKeyHash384Type() {
		return(dbkeyhash384typeFactoryService);
	}

	public BusModelBuffDbKeyHash384TypeFactoryService getDbKeyHash384TypeFactoryService() {
		return(dbkeyhash384typeFactoryService);
	}

	@Override
	public IBusModelDbKeyHash512ColFactory getFactoryDbKeyHash512Col() {
		return(dbkeyhash512colFactoryService);
	}

	public BusModelBuffDbKeyHash512ColFactoryService getDbKeyHash512ColFactoryService() {
		return(dbkeyhash512colFactoryService);
	}

	@Override
	public IBusModelDbKeyHash512DefFactory getFactoryDbKeyHash512Def() {
		return(dbkeyhash512defFactoryService);
	}

	public BusModelBuffDbKeyHash512DefFactoryService getDbKeyHash512DefFactoryService() {
		return(dbkeyhash512defFactoryService);
	}

	@Override
	public IBusModelDbKeyHash512GenFactory getFactoryDbKeyHash512Gen() {
		return(dbkeyhash512genFactoryService);
	}

	public BusModelBuffDbKeyHash512GenFactoryService getDbKeyHash512GenFactoryService() {
		return(dbkeyhash512genFactoryService);
	}

	@Override
	public IBusModelDbKeyHash512TypeFactory getFactoryDbKeyHash512Type() {
		return(dbkeyhash512typeFactoryService);
	}

	public BusModelBuffDbKeyHash512TypeFactoryService getDbKeyHash512TypeFactoryService() {
		return(dbkeyhash512typeFactoryService);
	}

	@Override
	public IBusModelDelDepFactory getFactoryDelDep() {
		return(deldepFactoryService);
	}

	public BusModelBuffDelDepFactoryService getDelDepFactoryService() {
		return(deldepFactoryService);
	}

	@Override
	public IBusModelDelSubDep1Factory getFactoryDelSubDep1() {
		return(delsubdep1FactoryService);
	}

	public BusModelBuffDelSubDep1FactoryService getDelSubDep1FactoryService() {
		return(delsubdep1FactoryService);
	}

	@Override
	public IBusModelDelSubDep2Factory getFactoryDelSubDep2() {
		return(delsubdep2FactoryService);
	}

	public BusModelBuffDelSubDep2FactoryService getDelSubDep2FactoryService() {
		return(delsubdep2FactoryService);
	}

	@Override
	public IBusModelDelSubDep3Factory getFactoryDelSubDep3() {
		return(delsubdep3FactoryService);
	}

	public BusModelBuffDelSubDep3FactoryService getDelSubDep3FactoryService() {
		return(delsubdep3FactoryService);
	}

	@Override
	public IBusModelDelTopDepFactory getFactoryDelTopDep() {
		return(deltopdepFactoryService);
	}

	public BusModelBuffDelTopDepFactoryService getDelTopDepFactoryService() {
		return(deltopdepFactoryService);
	}

	@Override
	public IBusModelDoubleColFactory getFactoryDoubleCol() {
		return(doublecolFactoryService);
	}

	public BusModelBuffDoubleColFactoryService getDoubleColFactoryService() {
		return(doublecolFactoryService);
	}

	@Override
	public IBusModelDoubleDefFactory getFactoryDoubleDef() {
		return(doubledefFactoryService);
	}

	public BusModelBuffDoubleDefFactoryService getDoubleDefFactoryService() {
		return(doubledefFactoryService);
	}

	@Override
	public IBusModelDoubleTypeFactory getFactoryDoubleType() {
		return(doubletypeFactoryService);
	}

	public BusModelBuffDoubleTypeFactoryService getDoubleTypeFactoryService() {
		return(doubletypeFactoryService);
	}

	@Override
	public IBusModelEnumDefFactory getFactoryEnumDef() {
		return(enumdefFactoryService);
	}

	public BusModelBuffEnumDefFactoryService getEnumDefFactoryService() {
		return(enumdefFactoryService);
	}

	@Override
	public IBusModelEnumTagFactory getFactoryEnumTag() {
		return(enumtagFactoryService);
	}

	public BusModelBuffEnumTagFactoryService getEnumTagFactoryService() {
		return(enumtagFactoryService);
	}

	@Override
	public IBusModelEnumTypeFactory getFactoryEnumType() {
		return(enumtypeFactoryService);
	}

	public BusModelBuffEnumTypeFactoryService getEnumTypeFactoryService() {
		return(enumtypeFactoryService);
	}

	@Override
	public IBusModelFloatColFactory getFactoryFloatCol() {
		return(floatcolFactoryService);
	}

	public BusModelBuffFloatColFactoryService getFloatColFactoryService() {
		return(floatcolFactoryService);
	}

	@Override
	public IBusModelFloatDefFactory getFactoryFloatDef() {
		return(floatdefFactoryService);
	}

	public BusModelBuffFloatDefFactoryService getFloatDefFactoryService() {
		return(floatdefFactoryService);
	}

	@Override
	public IBusModelFloatTypeFactory getFactoryFloatType() {
		return(floattypeFactoryService);
	}

	public BusModelBuffFloatTypeFactoryService getFloatTypeFactoryService() {
		return(floattypeFactoryService);
	}

	@Override
	public IBusModelId16GenFactory getFactoryId16Gen() {
		return(id16genFactoryService);
	}

	public BusModelBuffId16GenFactoryService getId16GenFactoryService() {
		return(id16genFactoryService);
	}

	@Override
	public IBusModelId32GenFactory getFactoryId32Gen() {
		return(id32genFactoryService);
	}

	public BusModelBuffId32GenFactoryService getId32GenFactoryService() {
		return(id32genFactoryService);
	}

	@Override
	public IBusModelId64GenFactory getFactoryId64Gen() {
		return(id64genFactoryService);
	}

	public BusModelBuffId64GenFactoryService getId64GenFactoryService() {
		return(id64genFactoryService);
	}

	@Override
	public IBusModelIndexFactory getFactoryIndex() {
		return(indexFactoryService);
	}

	public BusModelBuffIndexFactoryService getIndexFactoryService() {
		return(indexFactoryService);
	}

	@Override
	public IBusModelIndexColFactory getFactoryIndexCol() {
		return(indexcolFactoryService);
	}

	public BusModelBuffIndexColFactoryService getIndexColFactoryService() {
		return(indexcolFactoryService);
	}

	@Override
	public IBusModelIndexTweakFactory getFactoryIndexTweak() {
		return(indextweakFactoryService);
	}

	public BusModelBuffIndexTweakFactoryService getIndexTweakFactoryService() {
		return(indextweakFactoryService);
	}

	@Override
	public IBusModelInt16ColFactory getFactoryInt16Col() {
		return(int16colFactoryService);
	}

	public BusModelBuffInt16ColFactoryService getInt16ColFactoryService() {
		return(int16colFactoryService);
	}

	@Override
	public IBusModelInt16DefFactory getFactoryInt16Def() {
		return(int16defFactoryService);
	}

	public BusModelBuffInt16DefFactoryService getInt16DefFactoryService() {
		return(int16defFactoryService);
	}

	@Override
	public IBusModelInt16TypeFactory getFactoryInt16Type() {
		return(int16typeFactoryService);
	}

	public BusModelBuffInt16TypeFactoryService getInt16TypeFactoryService() {
		return(int16typeFactoryService);
	}

	@Override
	public IBusModelInt32ColFactory getFactoryInt32Col() {
		return(int32colFactoryService);
	}

	public BusModelBuffInt32ColFactoryService getInt32ColFactoryService() {
		return(int32colFactoryService);
	}

	@Override
	public IBusModelInt32DefFactory getFactoryInt32Def() {
		return(int32defFactoryService);
	}

	public BusModelBuffInt32DefFactoryService getInt32DefFactoryService() {
		return(int32defFactoryService);
	}

	@Override
	public IBusModelInt32TypeFactory getFactoryInt32Type() {
		return(int32typeFactoryService);
	}

	public BusModelBuffInt32TypeFactoryService getInt32TypeFactoryService() {
		return(int32typeFactoryService);
	}

	@Override
	public IBusModelInt64ColFactory getFactoryInt64Col() {
		return(int64colFactoryService);
	}

	public BusModelBuffInt64ColFactoryService getInt64ColFactoryService() {
		return(int64colFactoryService);
	}

	@Override
	public IBusModelInt64DefFactory getFactoryInt64Def() {
		return(int64defFactoryService);
	}

	public BusModelBuffInt64DefFactoryService getInt64DefFactoryService() {
		return(int64defFactoryService);
	}

	@Override
	public IBusModelInt64TypeFactory getFactoryInt64Type() {
		return(int64typeFactoryService);
	}

	public BusModelBuffInt64TypeFactoryService getInt64TypeFactoryService() {
		return(int64typeFactoryService);
	}

	@Override
	public IBusModelNmTokenColFactory getFactoryNmTokenCol() {
		return(nmtokencolFactoryService);
	}

	public BusModelBuffNmTokenColFactoryService getNmTokenColFactoryService() {
		return(nmtokencolFactoryService);
	}

	@Override
	public IBusModelNmTokenDefFactory getFactoryNmTokenDef() {
		return(nmtokendefFactoryService);
	}

	public BusModelBuffNmTokenDefFactoryService getNmTokenDefFactoryService() {
		return(nmtokendefFactoryService);
	}

	@Override
	public IBusModelNmTokenTypeFactory getFactoryNmTokenType() {
		return(nmtokentypeFactoryService);
	}

	public BusModelBuffNmTokenTypeFactoryService getNmTokenTypeFactoryService() {
		return(nmtokentypeFactoryService);
	}

	@Override
	public IBusModelNmTokensColFactory getFactoryNmTokensCol() {
		return(nmtokenscolFactoryService);
	}

	public BusModelBuffNmTokensColFactoryService getNmTokensColFactoryService() {
		return(nmtokenscolFactoryService);
	}

	@Override
	public IBusModelNmTokensDefFactory getFactoryNmTokensDef() {
		return(nmtokensdefFactoryService);
	}

	public BusModelBuffNmTokensDefFactoryService getNmTokensDefFactoryService() {
		return(nmtokensdefFactoryService);
	}

	@Override
	public IBusModelNmTokensTypeFactory getFactoryNmTokensType() {
		return(nmtokenstypeFactoryService);
	}

	public BusModelBuffNmTokensTypeFactoryService getNmTokensTypeFactoryService() {
		return(nmtokenstypeFactoryService);
	}

	@Override
	public IBusModelNumberColFactory getFactoryNumberCol() {
		return(numbercolFactoryService);
	}

	public BusModelBuffNumberColFactoryService getNumberColFactoryService() {
		return(numbercolFactoryService);
	}

	@Override
	public IBusModelNumberDefFactory getFactoryNumberDef() {
		return(numberdefFactoryService);
	}

	public BusModelBuffNumberDefFactoryService getNumberDefFactoryService() {
		return(numberdefFactoryService);
	}

	@Override
	public IBusModelNumberTypeFactory getFactoryNumberType() {
		return(numbertypeFactoryService);
	}

	public BusModelBuffNumberTypeFactoryService getNumberTypeFactoryService() {
		return(numbertypeFactoryService);
	}

	@Override
	public IBusModelParamFactory getFactoryParam() {
		return(paramFactoryService);
	}

	public BusModelBuffParamFactoryService getParamFactoryService() {
		return(paramFactoryService);
	}

	@Override
	public IBusModelPopDepFactory getFactoryPopDep() {
		return(popdepFactoryService);
	}

	public BusModelBuffPopDepFactoryService getPopDepFactoryService() {
		return(popdepFactoryService);
	}

	@Override
	public IBusModelPopSubDep1Factory getFactoryPopSubDep1() {
		return(popsubdep1FactoryService);
	}

	public BusModelBuffPopSubDep1FactoryService getPopSubDep1FactoryService() {
		return(popsubdep1FactoryService);
	}

	@Override
	public IBusModelPopSubDep2Factory getFactoryPopSubDep2() {
		return(popsubdep2FactoryService);
	}

	public BusModelBuffPopSubDep2FactoryService getPopSubDep2FactoryService() {
		return(popsubdep2FactoryService);
	}

	@Override
	public IBusModelPopSubDep3Factory getFactoryPopSubDep3() {
		return(popsubdep3FactoryService);
	}

	public BusModelBuffPopSubDep3FactoryService getPopSubDep3FactoryService() {
		return(popsubdep3FactoryService);
	}

	@Override
	public IBusModelPopTopDepFactory getFactoryPopTopDep() {
		return(poptopdepFactoryService);
	}

	public BusModelBuffPopTopDepFactoryService getPopTopDepFactoryService() {
		return(poptopdepFactoryService);
	}

	@Override
	public IBusModelRelationFactory getFactoryRelation() {
		return(relationFactoryService);
	}

	public BusModelBuffRelationFactoryService getRelationFactoryService() {
		return(relationFactoryService);
	}

	@Override
	public IBusModelRelationColFactory getFactoryRelationCol() {
		return(relationcolFactoryService);
	}

	public BusModelBuffRelationColFactoryService getRelationColFactoryService() {
		return(relationcolFactoryService);
	}

	@Override
	public IBusModelRoleDefFactory getFactoryRoleDef() {
		return(roledefFactoryService);
	}

	public BusModelBuffRoleDefFactoryService getRoleDefFactoryService() {
		return(roledefFactoryService);
	}

	@Override
	public IBusModelSchemaDefFactory getFactorySchemaDef() {
		return(schemadefFactoryService);
	}

	public BusModelBuffSchemaDefFactoryService getSchemaDefFactoryService() {
		return(schemadefFactoryService);
	}

	@Override
	public IBusModelSchemaRefFactory getFactorySchemaRef() {
		return(schemarefFactoryService);
	}

	public BusModelBuffSchemaRefFactoryService getSchemaRefFactoryService() {
		return(schemarefFactoryService);
	}

	@Override
	public IBusModelSchemaRoleFactory getFactorySchemaRole() {
		return(schemaroleFactoryService);
	}

	public BusModelBuffSchemaRoleFactoryService getSchemaRoleFactoryService() {
		return(schemaroleFactoryService);
	}

	@Override
	public IBusModelSchemaTweakFactory getFactorySchemaTweak() {
		return(schematweakFactoryService);
	}

	public BusModelBuffSchemaTweakFactoryService getSchemaTweakFactoryService() {
		return(schematweakFactoryService);
	}

	@Override
	public IBusModelScopeFactory getFactoryScope() {
		return(scopeFactoryService);
	}

	public BusModelBuffScopeFactoryService getScopeFactoryService() {
		return(scopeFactoryService);
	}

	@Override
	public IBusModelServerListFuncFactory getFactoryServerListFunc() {
		return(serverlistfuncFactoryService);
	}

	public BusModelBuffServerListFuncFactoryService getServerListFuncFactoryService() {
		return(serverlistfuncFactoryService);
	}

	@Override
	public IBusModelServerMethodFactory getFactoryServerMethod() {
		return(servermethodFactoryService);
	}

	public BusModelBuffServerMethodFactoryService getServerMethodFactoryService() {
		return(servermethodFactoryService);
	}

	@Override
	public IBusModelServerObjFuncFactory getFactoryServerObjFunc() {
		return(serverobjfuncFactoryService);
	}

	public BusModelBuffServerObjFuncFactoryService getServerObjFuncFactoryService() {
		return(serverobjfuncFactoryService);
	}

	@Override
	public IBusModelServerProcFactory getFactoryServerProc() {
		return(serverprocFactoryService);
	}

	public BusModelBuffServerProcFactoryService getServerProcFactoryService() {
		return(serverprocFactoryService);
	}

	@Override
	public IBusModelStringColFactory getFactoryStringCol() {
		return(stringcolFactoryService);
	}

	public BusModelBuffStringColFactoryService getStringColFactoryService() {
		return(stringcolFactoryService);
	}

	@Override
	public IBusModelStringDefFactory getFactoryStringDef() {
		return(stringdefFactoryService);
	}

	public BusModelBuffStringDefFactoryService getStringDefFactoryService() {
		return(stringdefFactoryService);
	}

	@Override
	public IBusModelStringTypeFactory getFactoryStringType() {
		return(stringtypeFactoryService);
	}

	public BusModelBuffStringTypeFactoryService getStringTypeFactoryService() {
		return(stringtypeFactoryService);
	}

	@Override
	public IBusModelTZDateColFactory getFactoryTZDateCol() {
		return(tzdatecolFactoryService);
	}

	public BusModelBuffTZDateColFactoryService getTZDateColFactoryService() {
		return(tzdatecolFactoryService);
	}

	@Override
	public IBusModelTZDateDefFactory getFactoryTZDateDef() {
		return(tzdatedefFactoryService);
	}

	public BusModelBuffTZDateDefFactoryService getTZDateDefFactoryService() {
		return(tzdatedefFactoryService);
	}

	@Override
	public IBusModelTZDateTypeFactory getFactoryTZDateType() {
		return(tzdatetypeFactoryService);
	}

	public BusModelBuffTZDateTypeFactoryService getTZDateTypeFactoryService() {
		return(tzdatetypeFactoryService);
	}

	@Override
	public IBusModelTZTimeColFactory getFactoryTZTimeCol() {
		return(tztimecolFactoryService);
	}

	public BusModelBuffTZTimeColFactoryService getTZTimeColFactoryService() {
		return(tztimecolFactoryService);
	}

	@Override
	public IBusModelTZTimeDefFactory getFactoryTZTimeDef() {
		return(tztimedefFactoryService);
	}

	public BusModelBuffTZTimeDefFactoryService getTZTimeDefFactoryService() {
		return(tztimedefFactoryService);
	}

	@Override
	public IBusModelTZTimeTypeFactory getFactoryTZTimeType() {
		return(tztimetypeFactoryService);
	}

	public BusModelBuffTZTimeTypeFactoryService getTZTimeTypeFactoryService() {
		return(tztimetypeFactoryService);
	}

	@Override
	public IBusModelTZTimestampColFactory getFactoryTZTimestampCol() {
		return(tztimestampcolFactoryService);
	}

	public BusModelBuffTZTimestampColFactoryService getTZTimestampColFactoryService() {
		return(tztimestampcolFactoryService);
	}

	@Override
	public IBusModelTZTimestampDefFactory getFactoryTZTimestampDef() {
		return(tztimestampdefFactoryService);
	}

	public BusModelBuffTZTimestampDefFactoryService getTZTimestampDefFactoryService() {
		return(tztimestampdefFactoryService);
	}

	@Override
	public IBusModelTZTimestampTypeFactory getFactoryTZTimestampType() {
		return(tztimestamptypeFactoryService);
	}

	public BusModelBuffTZTimestampTypeFactoryService getTZTimestampTypeFactoryService() {
		return(tztimestamptypeFactoryService);
	}

	@Override
	public IBusModelTableFactory getFactoryTable() {
		return(tableFactoryService);
	}

	public BusModelBuffTableFactoryService getTableFactoryService() {
		return(tableFactoryService);
	}

	@Override
	public IBusModelTableColFactory getFactoryTableCol() {
		return(tablecolFactoryService);
	}

	public BusModelBuffTableColFactoryService getTableColFactoryService() {
		return(tablecolFactoryService);
	}

	@Override
	public IBusModelTableTweakFactory getFactoryTableTweak() {
		return(tabletweakFactoryService);
	}

	public BusModelBuffTableTweakFactoryService getTableTweakFactoryService() {
		return(tabletweakFactoryService);
	}

	@Override
	public IBusModelTextColFactory getFactoryTextCol() {
		return(textcolFactoryService);
	}

	public BusModelBuffTextColFactoryService getTextColFactoryService() {
		return(textcolFactoryService);
	}

	@Override
	public IBusModelTextDefFactory getFactoryTextDef() {
		return(textdefFactoryService);
	}

	public BusModelBuffTextDefFactoryService getTextDefFactoryService() {
		return(textdefFactoryService);
	}

	@Override
	public IBusModelTextTypeFactory getFactoryTextType() {
		return(texttypeFactoryService);
	}

	public BusModelBuffTextTypeFactoryService getTextTypeFactoryService() {
		return(texttypeFactoryService);
	}

	@Override
	public IBusModelTimeColFactory getFactoryTimeCol() {
		return(timecolFactoryService);
	}

	public BusModelBuffTimeColFactoryService getTimeColFactoryService() {
		return(timecolFactoryService);
	}

	@Override
	public IBusModelTimeDefFactory getFactoryTimeDef() {
		return(timedefFactoryService);
	}

	public BusModelBuffTimeDefFactoryService getTimeDefFactoryService() {
		return(timedefFactoryService);
	}

	@Override
	public IBusModelTimeTypeFactory getFactoryTimeType() {
		return(timetypeFactoryService);
	}

	public BusModelBuffTimeTypeFactoryService getTimeTypeFactoryService() {
		return(timetypeFactoryService);
	}

	@Override
	public IBusModelTimestampColFactory getFactoryTimestampCol() {
		return(timestampcolFactoryService);
	}

	public BusModelBuffTimestampColFactoryService getTimestampColFactoryService() {
		return(timestampcolFactoryService);
	}

	@Override
	public IBusModelTimestampDefFactory getFactoryTimestampDef() {
		return(timestampdefFactoryService);
	}

	public BusModelBuffTimestampDefFactoryService getTimestampDefFactoryService() {
		return(timestampdefFactoryService);
	}

	@Override
	public IBusModelTimestampTypeFactory getFactoryTimestampType() {
		return(timestamptypeFactoryService);
	}

	public BusModelBuffTimestampTypeFactoryService getTimestampTypeFactoryService() {
		return(timestamptypeFactoryService);
	}

	@Override
	public IBusModelTokenColFactory getFactoryTokenCol() {
		return(tokencolFactoryService);
	}

	public BusModelBuffTokenColFactoryService getTokenColFactoryService() {
		return(tokencolFactoryService);
	}

	@Override
	public IBusModelTokenDefFactory getFactoryTokenDef() {
		return(tokendefFactoryService);
	}

	public BusModelBuffTokenDefFactoryService getTokenDefFactoryService() {
		return(tokendefFactoryService);
	}

	@Override
	public IBusModelTokenTypeFactory getFactoryTokenType() {
		return(tokentypeFactoryService);
	}

	public BusModelBuffTokenTypeFactoryService getTokenTypeFactoryService() {
		return(tokentypeFactoryService);
	}

	@Override
	public IBusModelTweakFactory getFactoryTweak() {
		return(tweakFactoryService);
	}

	public BusModelBuffTweakFactoryService getTweakFactoryService() {
		return(tweakFactoryService);
	}

	@Override
	public IBusModelUInt16ColFactory getFactoryUInt16Col() {
		return(uint16colFactoryService);
	}

	public BusModelBuffUInt16ColFactoryService getUInt16ColFactoryService() {
		return(uint16colFactoryService);
	}

	@Override
	public IBusModelUInt16DefFactory getFactoryUInt16Def() {
		return(uint16defFactoryService);
	}

	public BusModelBuffUInt16DefFactoryService getUInt16DefFactoryService() {
		return(uint16defFactoryService);
	}

	@Override
	public IBusModelUInt16TypeFactory getFactoryUInt16Type() {
		return(uint16typeFactoryService);
	}

	public BusModelBuffUInt16TypeFactoryService getUInt16TypeFactoryService() {
		return(uint16typeFactoryService);
	}

	@Override
	public IBusModelUInt32ColFactory getFactoryUInt32Col() {
		return(uint32colFactoryService);
	}

	public BusModelBuffUInt32ColFactoryService getUInt32ColFactoryService() {
		return(uint32colFactoryService);
	}

	@Override
	public IBusModelUInt32DefFactory getFactoryUInt32Def() {
		return(uint32defFactoryService);
	}

	public BusModelBuffUInt32DefFactoryService getUInt32DefFactoryService() {
		return(uint32defFactoryService);
	}

	@Override
	public IBusModelUInt32TypeFactory getFactoryUInt32Type() {
		return(uint32typeFactoryService);
	}

	public BusModelBuffUInt32TypeFactoryService getUInt32TypeFactoryService() {
		return(uint32typeFactoryService);
	}

	@Override
	public IBusModelUInt64ColFactory getFactoryUInt64Col() {
		return(uint64colFactoryService);
	}

	public BusModelBuffUInt64ColFactoryService getUInt64ColFactoryService() {
		return(uint64colFactoryService);
	}

	@Override
	public IBusModelUInt64DefFactory getFactoryUInt64Def() {
		return(uint64defFactoryService);
	}

	public BusModelBuffUInt64DefFactoryService getUInt64DefFactoryService() {
		return(uint64defFactoryService);
	}

	@Override
	public IBusModelUInt64TypeFactory getFactoryUInt64Type() {
		return(uint64typeFactoryService);
	}

	public BusModelBuffUInt64TypeFactoryService getUInt64TypeFactoryService() {
		return(uint64typeFactoryService);
	}

	@Override
	public IBusModelUuid6ColFactory getFactoryUuid6Col() {
		return(uuid6colFactoryService);
	}

	public BusModelBuffUuid6ColFactoryService getUuid6ColFactoryService() {
		return(uuid6colFactoryService);
	}

	@Override
	public IBusModelUuid6DefFactory getFactoryUuid6Def() {
		return(uuid6defFactoryService);
	}

	public BusModelBuffUuid6DefFactoryService getUuid6DefFactoryService() {
		return(uuid6defFactoryService);
	}

	@Override
	public IBusModelUuid6GenFactory getFactoryUuid6Gen() {
		return(uuid6genFactoryService);
	}

	public BusModelBuffUuid6GenFactoryService getUuid6GenFactoryService() {
		return(uuid6genFactoryService);
	}

	@Override
	public IBusModelUuid6TypeFactory getFactoryUuid6Type() {
		return(uuid6typeFactoryService);
	}

	public BusModelBuffUuid6TypeFactoryService getUuid6TypeFactoryService() {
		return(uuid6typeFactoryService);
	}

	@Override
	public IBusModelUuidColFactory getFactoryUuidCol() {
		return(uuidcolFactoryService);
	}

	public BusModelBuffUuidColFactoryService getUuidColFactoryService() {
		return(uuidcolFactoryService);
	}

	@Override
	public IBusModelUuidDefFactory getFactoryUuidDef() {
		return(uuiddefFactoryService);
	}

	public BusModelBuffUuidDefFactoryService getUuidDefFactoryService() {
		return(uuiddefFactoryService);
	}

	@Override
	public IBusModelUuidGenFactory getFactoryUuidGen() {
		return(uuidgenFactoryService);
	}

	public BusModelBuffUuidGenFactoryService getUuidGenFactoryService() {
		return(uuidgenFactoryService);
	}

	@Override
	public IBusModelUuidTypeFactory getFactoryUuidType() {
		return(uuidtypeFactoryService);
	}

	public BusModelBuffUuidTypeFactoryService getUuidTypeFactoryService() {
		return(uuidtypeFactoryService);
	}

	@Override
	public IBusModelValueFactory getFactoryValue() {
		return(valueFactoryService);
	}

	public BusModelBuffValueFactoryService getValueFactoryService() {
		return(valueFactoryService);
	}

}
