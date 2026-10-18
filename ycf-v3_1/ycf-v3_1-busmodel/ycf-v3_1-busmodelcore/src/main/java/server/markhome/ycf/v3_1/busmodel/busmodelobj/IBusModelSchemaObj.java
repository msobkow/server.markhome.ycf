// Description: Java 25 Schema Object interface for BusModel.

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
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public interface IBusModelSchemaObj
	extends ISecureSchemaObj,
		IIntNetSchemaObj
{
	public ISecureSchema getSecureBackingStore();
	public void setSecureBackingStore(ISecureSchema secureBackingStore);

	public IIntNetSchema getIntNetBackingStore();
	public void setIntNetBackingStore(IIntNetSchema intnetBackingStore);

	public IBusModelSchema getBusModelBackingStore();
	public void setBusModelBackingStore(IBusModelSchema busmodelBackingStore);

	/**
	 *	Get the Atom interface for the schema.
	 *
	 *	@return	The IBusModelAtomTableObj interface implementation for the schema.
	 */
	IBusModelAtomTableObj getAtomTableObj();

	/**
	 *	Get the BlobCol interface for the schema.
	 *
	 *	@return	The IBusModelBlobColTableObj interface implementation for the schema.
	 */
	IBusModelBlobColTableObj getBlobColTableObj();

	/**
	 *	Get the BlobDef interface for the schema.
	 *
	 *	@return	The IBusModelBlobDefTableObj interface implementation for the schema.
	 */
	IBusModelBlobDefTableObj getBlobDefTableObj();

	/**
	 *	Get the BlobType interface for the schema.
	 *
	 *	@return	The IBusModelBlobTypeTableObj interface implementation for the schema.
	 */
	IBusModelBlobTypeTableObj getBlobTypeTableObj();

	/**
	 *	Get the BoolCol interface for the schema.
	 *
	 *	@return	The IBusModelBoolColTableObj interface implementation for the schema.
	 */
	IBusModelBoolColTableObj getBoolColTableObj();

	/**
	 *	Get the BoolDef interface for the schema.
	 *
	 *	@return	The IBusModelBoolDefTableObj interface implementation for the schema.
	 */
	IBusModelBoolDefTableObj getBoolDefTableObj();

	/**
	 *	Get the BoolType interface for the schema.
	 *
	 *	@return	The IBusModelBoolTypeTableObj interface implementation for the schema.
	 */
	IBusModelBoolTypeTableObj getBoolTypeTableObj();

	/**
	 *	Get the Chain interface for the schema.
	 *
	 *	@return	The IBusModelChainTableObj interface implementation for the schema.
	 */
	IBusModelChainTableObj getChainTableObj();

	/**
	 *	Get the ClearDep interface for the schema.
	 *
	 *	@return	The IBusModelClearDepTableObj interface implementation for the schema.
	 */
	IBusModelClearDepTableObj getClearDepTableObj();

	/**
	 *	Get the ClearSubDep1 interface for the schema.
	 *
	 *	@return	The IBusModelClearSubDep1TableObj interface implementation for the schema.
	 */
	IBusModelClearSubDep1TableObj getClearSubDep1TableObj();

	/**
	 *	Get the ClearSubDep2 interface for the schema.
	 *
	 *	@return	The IBusModelClearSubDep2TableObj interface implementation for the schema.
	 */
	IBusModelClearSubDep2TableObj getClearSubDep2TableObj();

	/**
	 *	Get the ClearSubDep3 interface for the schema.
	 *
	 *	@return	The IBusModelClearSubDep3TableObj interface implementation for the schema.
	 */
	IBusModelClearSubDep3TableObj getClearSubDep3TableObj();

	/**
	 *	Get the ClearTopDep interface for the schema.
	 *
	 *	@return	The IBusModelClearTopDepTableObj interface implementation for the schema.
	 */
	IBusModelClearTopDepTableObj getClearTopDepTableObj();

	/**
	 *	Get the DateCol interface for the schema.
	 *
	 *	@return	The IBusModelDateColTableObj interface implementation for the schema.
	 */
	IBusModelDateColTableObj getDateColTableObj();

	/**
	 *	Get the DateDef interface for the schema.
	 *
	 *	@return	The IBusModelDateDefTableObj interface implementation for the schema.
	 */
	IBusModelDateDefTableObj getDateDefTableObj();

	/**
	 *	Get the DateType interface for the schema.
	 *
	 *	@return	The IBusModelDateTypeTableObj interface implementation for the schema.
	 */
	IBusModelDateTypeTableObj getDateTypeTableObj();

	/**
	 *	Get the DbKeyHash128Col interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash128ColTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash128ColTableObj getDbKeyHash128ColTableObj();

	/**
	 *	Get the DbKeyHash128Def interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash128DefTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash128DefTableObj getDbKeyHash128DefTableObj();

	/**
	 *	Get the DbKeyHash128Gen interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash128GenTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash128GenTableObj getDbKeyHash128GenTableObj();

	/**
	 *	Get the DbKeyHash128Type interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash128TypeTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash128TypeTableObj getDbKeyHash128TypeTableObj();

	/**
	 *	Get the DbKeyHash160Col interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash160ColTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash160ColTableObj getDbKeyHash160ColTableObj();

	/**
	 *	Get the DbKeyHash160Def interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash160DefTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash160DefTableObj getDbKeyHash160DefTableObj();

	/**
	 *	Get the DbKeyHash160Gen interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash160GenTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash160GenTableObj getDbKeyHash160GenTableObj();

	/**
	 *	Get the DbKeyHash160Type interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash160TypeTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash160TypeTableObj getDbKeyHash160TypeTableObj();

	/**
	 *	Get the DbKeyHash224Col interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash224ColTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash224ColTableObj getDbKeyHash224ColTableObj();

	/**
	 *	Get the DbKeyHash224Def interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash224DefTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash224DefTableObj getDbKeyHash224DefTableObj();

	/**
	 *	Get the DbKeyHash224Gen interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash224GenTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash224GenTableObj getDbKeyHash224GenTableObj();

	/**
	 *	Get the DbKeyHash224Type interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash224TypeTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash224TypeTableObj getDbKeyHash224TypeTableObj();

	/**
	 *	Get the DbKeyHash256Col interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash256ColTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash256ColTableObj getDbKeyHash256ColTableObj();

	/**
	 *	Get the DbKeyHash256Def interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash256DefTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash256DefTableObj getDbKeyHash256DefTableObj();

	/**
	 *	Get the DbKeyHash256Gen interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash256GenTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash256GenTableObj getDbKeyHash256GenTableObj();

	/**
	 *	Get the DbKeyHash256Type interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash256TypeTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash256TypeTableObj getDbKeyHash256TypeTableObj();

	/**
	 *	Get the DbKeyHash384Col interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash384ColTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash384ColTableObj getDbKeyHash384ColTableObj();

	/**
	 *	Get the DbKeyHash384Def interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash384DefTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash384DefTableObj getDbKeyHash384DefTableObj();

	/**
	 *	Get the DbKeyHash384Gen interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash384GenTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash384GenTableObj getDbKeyHash384GenTableObj();

	/**
	 *	Get the DbKeyHash384Type interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash384TypeTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash384TypeTableObj getDbKeyHash384TypeTableObj();

	/**
	 *	Get the DbKeyHash512Col interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash512ColTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash512ColTableObj getDbKeyHash512ColTableObj();

	/**
	 *	Get the DbKeyHash512Def interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash512DefTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash512DefTableObj getDbKeyHash512DefTableObj();

	/**
	 *	Get the DbKeyHash512Gen interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash512GenTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash512GenTableObj getDbKeyHash512GenTableObj();

	/**
	 *	Get the DbKeyHash512Type interface for the schema.
	 *
	 *	@return	The IBusModelDbKeyHash512TypeTableObj interface implementation for the schema.
	 */
	IBusModelDbKeyHash512TypeTableObj getDbKeyHash512TypeTableObj();

	/**
	 *	Get the DelDep interface for the schema.
	 *
	 *	@return	The IBusModelDelDepTableObj interface implementation for the schema.
	 */
	IBusModelDelDepTableObj getDelDepTableObj();

	/**
	 *	Get the DelSubDep1 interface for the schema.
	 *
	 *	@return	The IBusModelDelSubDep1TableObj interface implementation for the schema.
	 */
	IBusModelDelSubDep1TableObj getDelSubDep1TableObj();

	/**
	 *	Get the DelSubDep2 interface for the schema.
	 *
	 *	@return	The IBusModelDelSubDep2TableObj interface implementation for the schema.
	 */
	IBusModelDelSubDep2TableObj getDelSubDep2TableObj();

	/**
	 *	Get the DelSubDep3 interface for the schema.
	 *
	 *	@return	The IBusModelDelSubDep3TableObj interface implementation for the schema.
	 */
	IBusModelDelSubDep3TableObj getDelSubDep3TableObj();

	/**
	 *	Get the DelTopDep interface for the schema.
	 *
	 *	@return	The IBusModelDelTopDepTableObj interface implementation for the schema.
	 */
	IBusModelDelTopDepTableObj getDelTopDepTableObj();

	/**
	 *	Get the DoubleCol interface for the schema.
	 *
	 *	@return	The IBusModelDoubleColTableObj interface implementation for the schema.
	 */
	IBusModelDoubleColTableObj getDoubleColTableObj();

	/**
	 *	Get the DoubleDef interface for the schema.
	 *
	 *	@return	The IBusModelDoubleDefTableObj interface implementation for the schema.
	 */
	IBusModelDoubleDefTableObj getDoubleDefTableObj();

	/**
	 *	Get the DoubleType interface for the schema.
	 *
	 *	@return	The IBusModelDoubleTypeTableObj interface implementation for the schema.
	 */
	IBusModelDoubleTypeTableObj getDoubleTypeTableObj();

	/**
	 *	Get the EnumDef interface for the schema.
	 *
	 *	@return	The IBusModelEnumDefTableObj interface implementation for the schema.
	 */
	IBusModelEnumDefTableObj getEnumDefTableObj();

	/**
	 *	Get the EnumTag interface for the schema.
	 *
	 *	@return	The IBusModelEnumTagTableObj interface implementation for the schema.
	 */
	IBusModelEnumTagTableObj getEnumTagTableObj();

	/**
	 *	Get the EnumType interface for the schema.
	 *
	 *	@return	The IBusModelEnumTypeTableObj interface implementation for the schema.
	 */
	IBusModelEnumTypeTableObj getEnumTypeTableObj();

	/**
	 *	Get the FloatCol interface for the schema.
	 *
	 *	@return	The IBusModelFloatColTableObj interface implementation for the schema.
	 */
	IBusModelFloatColTableObj getFloatColTableObj();

	/**
	 *	Get the FloatDef interface for the schema.
	 *
	 *	@return	The IBusModelFloatDefTableObj interface implementation for the schema.
	 */
	IBusModelFloatDefTableObj getFloatDefTableObj();

	/**
	 *	Get the FloatType interface for the schema.
	 *
	 *	@return	The IBusModelFloatTypeTableObj interface implementation for the schema.
	 */
	IBusModelFloatTypeTableObj getFloatTypeTableObj();

	/**
	 *	Get the Id16Gen interface for the schema.
	 *
	 *	@return	The IBusModelId16GenTableObj interface implementation for the schema.
	 */
	IBusModelId16GenTableObj getId16GenTableObj();

	/**
	 *	Get the Id32Gen interface for the schema.
	 *
	 *	@return	The IBusModelId32GenTableObj interface implementation for the schema.
	 */
	IBusModelId32GenTableObj getId32GenTableObj();

	/**
	 *	Get the Id64Gen interface for the schema.
	 *
	 *	@return	The IBusModelId64GenTableObj interface implementation for the schema.
	 */
	IBusModelId64GenTableObj getId64GenTableObj();

	/**
	 *	Get the Index interface for the schema.
	 *
	 *	@return	The IBusModelIndexTableObj interface implementation for the schema.
	 */
	IBusModelIndexTableObj getIndexTableObj();

	/**
	 *	Get the IndexCol interface for the schema.
	 *
	 *	@return	The IBusModelIndexColTableObj interface implementation for the schema.
	 */
	IBusModelIndexColTableObj getIndexColTableObj();

	/**
	 *	Get the IndexTweak interface for the schema.
	 *
	 *	@return	The IBusModelIndexTweakTableObj interface implementation for the schema.
	 */
	IBusModelIndexTweakTableObj getIndexTweakTableObj();

	/**
	 *	Get the Int16Col interface for the schema.
	 *
	 *	@return	The IBusModelInt16ColTableObj interface implementation for the schema.
	 */
	IBusModelInt16ColTableObj getInt16ColTableObj();

	/**
	 *	Get the Int16Def interface for the schema.
	 *
	 *	@return	The IBusModelInt16DefTableObj interface implementation for the schema.
	 */
	IBusModelInt16DefTableObj getInt16DefTableObj();

	/**
	 *	Get the Int16Type interface for the schema.
	 *
	 *	@return	The IBusModelInt16TypeTableObj interface implementation for the schema.
	 */
	IBusModelInt16TypeTableObj getInt16TypeTableObj();

	/**
	 *	Get the Int32Col interface for the schema.
	 *
	 *	@return	The IBusModelInt32ColTableObj interface implementation for the schema.
	 */
	IBusModelInt32ColTableObj getInt32ColTableObj();

	/**
	 *	Get the Int32Def interface for the schema.
	 *
	 *	@return	The IBusModelInt32DefTableObj interface implementation for the schema.
	 */
	IBusModelInt32DefTableObj getInt32DefTableObj();

	/**
	 *	Get the Int32Type interface for the schema.
	 *
	 *	@return	The IBusModelInt32TypeTableObj interface implementation for the schema.
	 */
	IBusModelInt32TypeTableObj getInt32TypeTableObj();

	/**
	 *	Get the Int64Col interface for the schema.
	 *
	 *	@return	The IBusModelInt64ColTableObj interface implementation for the schema.
	 */
	IBusModelInt64ColTableObj getInt64ColTableObj();

	/**
	 *	Get the Int64Def interface for the schema.
	 *
	 *	@return	The IBusModelInt64DefTableObj interface implementation for the schema.
	 */
	IBusModelInt64DefTableObj getInt64DefTableObj();

	/**
	 *	Get the Int64Type interface for the schema.
	 *
	 *	@return	The IBusModelInt64TypeTableObj interface implementation for the schema.
	 */
	IBusModelInt64TypeTableObj getInt64TypeTableObj();

	/**
	 *	Get the NmTokenCol interface for the schema.
	 *
	 *	@return	The IBusModelNmTokenColTableObj interface implementation for the schema.
	 */
	IBusModelNmTokenColTableObj getNmTokenColTableObj();

	/**
	 *	Get the NmTokenDef interface for the schema.
	 *
	 *	@return	The IBusModelNmTokenDefTableObj interface implementation for the schema.
	 */
	IBusModelNmTokenDefTableObj getNmTokenDefTableObj();

	/**
	 *	Get the NmTokenType interface for the schema.
	 *
	 *	@return	The IBusModelNmTokenTypeTableObj interface implementation for the schema.
	 */
	IBusModelNmTokenTypeTableObj getNmTokenTypeTableObj();

	/**
	 *	Get the NmTokensCol interface for the schema.
	 *
	 *	@return	The IBusModelNmTokensColTableObj interface implementation for the schema.
	 */
	IBusModelNmTokensColTableObj getNmTokensColTableObj();

	/**
	 *	Get the NmTokensDef interface for the schema.
	 *
	 *	@return	The IBusModelNmTokensDefTableObj interface implementation for the schema.
	 */
	IBusModelNmTokensDefTableObj getNmTokensDefTableObj();

	/**
	 *	Get the NmTokensType interface for the schema.
	 *
	 *	@return	The IBusModelNmTokensTypeTableObj interface implementation for the schema.
	 */
	IBusModelNmTokensTypeTableObj getNmTokensTypeTableObj();

	/**
	 *	Get the NumberCol interface for the schema.
	 *
	 *	@return	The IBusModelNumberColTableObj interface implementation for the schema.
	 */
	IBusModelNumberColTableObj getNumberColTableObj();

	/**
	 *	Get the NumberDef interface for the schema.
	 *
	 *	@return	The IBusModelNumberDefTableObj interface implementation for the schema.
	 */
	IBusModelNumberDefTableObj getNumberDefTableObj();

	/**
	 *	Get the NumberType interface for the schema.
	 *
	 *	@return	The IBusModelNumberTypeTableObj interface implementation for the schema.
	 */
	IBusModelNumberTypeTableObj getNumberTypeTableObj();

	/**
	 *	Get the Param interface for the schema.
	 *
	 *	@return	The IBusModelParamTableObj interface implementation for the schema.
	 */
	IBusModelParamTableObj getParamTableObj();

	/**
	 *	Get the PopDep interface for the schema.
	 *
	 *	@return	The IBusModelPopDepTableObj interface implementation for the schema.
	 */
	IBusModelPopDepTableObj getPopDepTableObj();

	/**
	 *	Get the PopSubDep1 interface for the schema.
	 *
	 *	@return	The IBusModelPopSubDep1TableObj interface implementation for the schema.
	 */
	IBusModelPopSubDep1TableObj getPopSubDep1TableObj();

	/**
	 *	Get the PopSubDep2 interface for the schema.
	 *
	 *	@return	The IBusModelPopSubDep2TableObj interface implementation for the schema.
	 */
	IBusModelPopSubDep2TableObj getPopSubDep2TableObj();

	/**
	 *	Get the PopSubDep3 interface for the schema.
	 *
	 *	@return	The IBusModelPopSubDep3TableObj interface implementation for the schema.
	 */
	IBusModelPopSubDep3TableObj getPopSubDep3TableObj();

	/**
	 *	Get the PopTopDep interface for the schema.
	 *
	 *	@return	The IBusModelPopTopDepTableObj interface implementation for the schema.
	 */
	IBusModelPopTopDepTableObj getPopTopDepTableObj();

	/**
	 *	Get the Relation interface for the schema.
	 *
	 *	@return	The IBusModelRelationTableObj interface implementation for the schema.
	 */
	IBusModelRelationTableObj getRelationTableObj();

	/**
	 *	Get the RelationCol interface for the schema.
	 *
	 *	@return	The IBusModelRelationColTableObj interface implementation for the schema.
	 */
	IBusModelRelationColTableObj getRelationColTableObj();

	/**
	 *	Get the RoleDef interface for the schema.
	 *
	 *	@return	The IBusModelRoleDefTableObj interface implementation for the schema.
	 */
	IBusModelRoleDefTableObj getRoleDefTableObj();

	/**
	 *	Get the SchemaDef interface for the schema.
	 *
	 *	@return	The IBusModelSchemaDefTableObj interface implementation for the schema.
	 */
	IBusModelSchemaDefTableObj getSchemaDefTableObj();

	/**
	 *	Get the SchemaRef interface for the schema.
	 *
	 *	@return	The IBusModelSchemaRefTableObj interface implementation for the schema.
	 */
	IBusModelSchemaRefTableObj getSchemaRefTableObj();

	/**
	 *	Get the SchemaRole interface for the schema.
	 *
	 *	@return	The IBusModelSchemaRoleTableObj interface implementation for the schema.
	 */
	IBusModelSchemaRoleTableObj getSchemaRoleTableObj();

	/**
	 *	Get the SchemaTweak interface for the schema.
	 *
	 *	@return	The IBusModelSchemaTweakTableObj interface implementation for the schema.
	 */
	IBusModelSchemaTweakTableObj getSchemaTweakTableObj();

	/**
	 *	Get the Scope interface for the schema.
	 *
	 *	@return	The IBusModelScopeTableObj interface implementation for the schema.
	 */
	IBusModelScopeTableObj getScopeTableObj();

	/**
	 *	Get the ServerListFunc interface for the schema.
	 *
	 *	@return	The IBusModelServerListFuncTableObj interface implementation for the schema.
	 */
	IBusModelServerListFuncTableObj getServerListFuncTableObj();

	/**
	 *	Get the ServerMethod interface for the schema.
	 *
	 *	@return	The IBusModelServerMethodTableObj interface implementation for the schema.
	 */
	IBusModelServerMethodTableObj getServerMethodTableObj();

	/**
	 *	Get the ServerObjFunc interface for the schema.
	 *
	 *	@return	The IBusModelServerObjFuncTableObj interface implementation for the schema.
	 */
	IBusModelServerObjFuncTableObj getServerObjFuncTableObj();

	/**
	 *	Get the ServerProc interface for the schema.
	 *
	 *	@return	The IBusModelServerProcTableObj interface implementation for the schema.
	 */
	IBusModelServerProcTableObj getServerProcTableObj();

	/**
	 *	Get the StringCol interface for the schema.
	 *
	 *	@return	The IBusModelStringColTableObj interface implementation for the schema.
	 */
	IBusModelStringColTableObj getStringColTableObj();

	/**
	 *	Get the StringDef interface for the schema.
	 *
	 *	@return	The IBusModelStringDefTableObj interface implementation for the schema.
	 */
	IBusModelStringDefTableObj getStringDefTableObj();

	/**
	 *	Get the StringType interface for the schema.
	 *
	 *	@return	The IBusModelStringTypeTableObj interface implementation for the schema.
	 */
	IBusModelStringTypeTableObj getStringTypeTableObj();

	/**
	 *	Get the TZDateCol interface for the schema.
	 *
	 *	@return	The IBusModelTZDateColTableObj interface implementation for the schema.
	 */
	IBusModelTZDateColTableObj getTZDateColTableObj();

	/**
	 *	Get the TZDateDef interface for the schema.
	 *
	 *	@return	The IBusModelTZDateDefTableObj interface implementation for the schema.
	 */
	IBusModelTZDateDefTableObj getTZDateDefTableObj();

	/**
	 *	Get the TZDateType interface for the schema.
	 *
	 *	@return	The IBusModelTZDateTypeTableObj interface implementation for the schema.
	 */
	IBusModelTZDateTypeTableObj getTZDateTypeTableObj();

	/**
	 *	Get the TZTimeCol interface for the schema.
	 *
	 *	@return	The IBusModelTZTimeColTableObj interface implementation for the schema.
	 */
	IBusModelTZTimeColTableObj getTZTimeColTableObj();

	/**
	 *	Get the TZTimeDef interface for the schema.
	 *
	 *	@return	The IBusModelTZTimeDefTableObj interface implementation for the schema.
	 */
	IBusModelTZTimeDefTableObj getTZTimeDefTableObj();

	/**
	 *	Get the TZTimeType interface for the schema.
	 *
	 *	@return	The IBusModelTZTimeTypeTableObj interface implementation for the schema.
	 */
	IBusModelTZTimeTypeTableObj getTZTimeTypeTableObj();

	/**
	 *	Get the TZTimestampCol interface for the schema.
	 *
	 *	@return	The IBusModelTZTimestampColTableObj interface implementation for the schema.
	 */
	IBusModelTZTimestampColTableObj getTZTimestampColTableObj();

	/**
	 *	Get the TZTimestampDef interface for the schema.
	 *
	 *	@return	The IBusModelTZTimestampDefTableObj interface implementation for the schema.
	 */
	IBusModelTZTimestampDefTableObj getTZTimestampDefTableObj();

	/**
	 *	Get the TZTimestampType interface for the schema.
	 *
	 *	@return	The IBusModelTZTimestampTypeTableObj interface implementation for the schema.
	 */
	IBusModelTZTimestampTypeTableObj getTZTimestampTypeTableObj();

	/**
	 *	Get the Table interface for the schema.
	 *
	 *	@return	The IBusModelTableTableObj interface implementation for the schema.
	 */
	IBusModelTableTableObj getTableTableObj();

	/**
	 *	Get the TableCol interface for the schema.
	 *
	 *	@return	The IBusModelTableColTableObj interface implementation for the schema.
	 */
	IBusModelTableColTableObj getTableColTableObj();

	/**
	 *	Get the TableTweak interface for the schema.
	 *
	 *	@return	The IBusModelTableTweakTableObj interface implementation for the schema.
	 */
	IBusModelTableTweakTableObj getTableTweakTableObj();

	/**
	 *	Get the TextCol interface for the schema.
	 *
	 *	@return	The IBusModelTextColTableObj interface implementation for the schema.
	 */
	IBusModelTextColTableObj getTextColTableObj();

	/**
	 *	Get the TextDef interface for the schema.
	 *
	 *	@return	The IBusModelTextDefTableObj interface implementation for the schema.
	 */
	IBusModelTextDefTableObj getTextDefTableObj();

	/**
	 *	Get the TextType interface for the schema.
	 *
	 *	@return	The IBusModelTextTypeTableObj interface implementation for the schema.
	 */
	IBusModelTextTypeTableObj getTextTypeTableObj();

	/**
	 *	Get the TimeCol interface for the schema.
	 *
	 *	@return	The IBusModelTimeColTableObj interface implementation for the schema.
	 */
	IBusModelTimeColTableObj getTimeColTableObj();

	/**
	 *	Get the TimeDef interface for the schema.
	 *
	 *	@return	The IBusModelTimeDefTableObj interface implementation for the schema.
	 */
	IBusModelTimeDefTableObj getTimeDefTableObj();

	/**
	 *	Get the TimeType interface for the schema.
	 *
	 *	@return	The IBusModelTimeTypeTableObj interface implementation for the schema.
	 */
	IBusModelTimeTypeTableObj getTimeTypeTableObj();

	/**
	 *	Get the TimestampCol interface for the schema.
	 *
	 *	@return	The IBusModelTimestampColTableObj interface implementation for the schema.
	 */
	IBusModelTimestampColTableObj getTimestampColTableObj();

	/**
	 *	Get the TimestampDef interface for the schema.
	 *
	 *	@return	The IBusModelTimestampDefTableObj interface implementation for the schema.
	 */
	IBusModelTimestampDefTableObj getTimestampDefTableObj();

	/**
	 *	Get the TimestampType interface for the schema.
	 *
	 *	@return	The IBusModelTimestampTypeTableObj interface implementation for the schema.
	 */
	IBusModelTimestampTypeTableObj getTimestampTypeTableObj();

	/**
	 *	Get the TokenCol interface for the schema.
	 *
	 *	@return	The IBusModelTokenColTableObj interface implementation for the schema.
	 */
	IBusModelTokenColTableObj getTokenColTableObj();

	/**
	 *	Get the TokenDef interface for the schema.
	 *
	 *	@return	The IBusModelTokenDefTableObj interface implementation for the schema.
	 */
	IBusModelTokenDefTableObj getTokenDefTableObj();

	/**
	 *	Get the TokenType interface for the schema.
	 *
	 *	@return	The IBusModelTokenTypeTableObj interface implementation for the schema.
	 */
	IBusModelTokenTypeTableObj getTokenTypeTableObj();

	/**
	 *	Get the Tweak interface for the schema.
	 *
	 *	@return	The IBusModelTweakTableObj interface implementation for the schema.
	 */
	IBusModelTweakTableObj getTweakTableObj();

	/**
	 *	Get the UInt16Col interface for the schema.
	 *
	 *	@return	The IBusModelUInt16ColTableObj interface implementation for the schema.
	 */
	IBusModelUInt16ColTableObj getUInt16ColTableObj();

	/**
	 *	Get the UInt16Def interface for the schema.
	 *
	 *	@return	The IBusModelUInt16DefTableObj interface implementation for the schema.
	 */
	IBusModelUInt16DefTableObj getUInt16DefTableObj();

	/**
	 *	Get the UInt16Type interface for the schema.
	 *
	 *	@return	The IBusModelUInt16TypeTableObj interface implementation for the schema.
	 */
	IBusModelUInt16TypeTableObj getUInt16TypeTableObj();

	/**
	 *	Get the UInt32Col interface for the schema.
	 *
	 *	@return	The IBusModelUInt32ColTableObj interface implementation for the schema.
	 */
	IBusModelUInt32ColTableObj getUInt32ColTableObj();

	/**
	 *	Get the UInt32Def interface for the schema.
	 *
	 *	@return	The IBusModelUInt32DefTableObj interface implementation for the schema.
	 */
	IBusModelUInt32DefTableObj getUInt32DefTableObj();

	/**
	 *	Get the UInt32Type interface for the schema.
	 *
	 *	@return	The IBusModelUInt32TypeTableObj interface implementation for the schema.
	 */
	IBusModelUInt32TypeTableObj getUInt32TypeTableObj();

	/**
	 *	Get the UInt64Col interface for the schema.
	 *
	 *	@return	The IBusModelUInt64ColTableObj interface implementation for the schema.
	 */
	IBusModelUInt64ColTableObj getUInt64ColTableObj();

	/**
	 *	Get the UInt64Def interface for the schema.
	 *
	 *	@return	The IBusModelUInt64DefTableObj interface implementation for the schema.
	 */
	IBusModelUInt64DefTableObj getUInt64DefTableObj();

	/**
	 *	Get the UInt64Type interface for the schema.
	 *
	 *	@return	The IBusModelUInt64TypeTableObj interface implementation for the schema.
	 */
	IBusModelUInt64TypeTableObj getUInt64TypeTableObj();

	/**
	 *	Get the Uuid6Col interface for the schema.
	 *
	 *	@return	The IBusModelUuid6ColTableObj interface implementation for the schema.
	 */
	IBusModelUuid6ColTableObj getUuid6ColTableObj();

	/**
	 *	Get the Uuid6Def interface for the schema.
	 *
	 *	@return	The IBusModelUuid6DefTableObj interface implementation for the schema.
	 */
	IBusModelUuid6DefTableObj getUuid6DefTableObj();

	/**
	 *	Get the Uuid6Gen interface for the schema.
	 *
	 *	@return	The IBusModelUuid6GenTableObj interface implementation for the schema.
	 */
	IBusModelUuid6GenTableObj getUuid6GenTableObj();

	/**
	 *	Get the Uuid6Type interface for the schema.
	 *
	 *	@return	The IBusModelUuid6TypeTableObj interface implementation for the schema.
	 */
	IBusModelUuid6TypeTableObj getUuid6TypeTableObj();

	/**
	 *	Get the UuidCol interface for the schema.
	 *
	 *	@return	The IBusModelUuidColTableObj interface implementation for the schema.
	 */
	IBusModelUuidColTableObj getUuidColTableObj();

	/**
	 *	Get the UuidDef interface for the schema.
	 *
	 *	@return	The IBusModelUuidDefTableObj interface implementation for the schema.
	 */
	IBusModelUuidDefTableObj getUuidDefTableObj();

	/**
	 *	Get the UuidGen interface for the schema.
	 *
	 *	@return	The IBusModelUuidGenTableObj interface implementation for the schema.
	 */
	IBusModelUuidGenTableObj getUuidGenTableObj();

	/**
	 *	Get the UuidType interface for the schema.
	 *
	 *	@return	The IBusModelUuidTypeTableObj interface implementation for the schema.
	 */
	IBusModelUuidTypeTableObj getUuidTypeTableObj();

	/**
	 *	Get the Value interface for the schema.
	 *
	 *	@return	The IBusModelValueTableObj interface implementation for the schema.
	 */
	IBusModelValueTableObj getValueTableObj();
}
