// Description: Java 25 Public Schema Object interface for BusModelPub.

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

package server.markhome.ycf.v3_1.busmodel.busmodelpubobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IBusModelPubSchemaObj
	extends ISecurePubSchemaObj,
		IIntNetPubSchemaObj
{
	public ISecurePubSchema getSecurePubBackingStore();
	public void setSecurePubBackingStore(ISecurePubSchema securepubBackingStore);

	public IIntNetPubSchema getIntNetPubBackingStore();
	public void setIntNetPubBackingStore(IIntNetPubSchema intnetpubBackingStore);

	public IBusModelPubSchema getBusModelPubBackingStore();
	public void setBusModelPubBackingStore(IBusModelPubSchema busmodelpubBackingStore);

	/**
	 *	Get the Atom interface for the schema.
	 *
	 *	@return	The IBusModelPubAtomTableObj interface implementation for the schema.
	 */
	IBusModelPubAtomTableObj getAtomTableObj();

	/**
	 *	Get the BlobCol interface for the schema.
	 *
	 *	@return	The IBusModelPubBlobColTableObj interface implementation for the schema.
	 */
	IBusModelPubBlobColTableObj getBlobColTableObj();

	/**
	 *	Get the BlobDef interface for the schema.
	 *
	 *	@return	The IBusModelPubBlobDefTableObj interface implementation for the schema.
	 */
	IBusModelPubBlobDefTableObj getBlobDefTableObj();

	/**
	 *	Get the BlobType interface for the schema.
	 *
	 *	@return	The IBusModelPubBlobTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubBlobTypeTableObj getBlobTypeTableObj();

	/**
	 *	Get the BoolCol interface for the schema.
	 *
	 *	@return	The IBusModelPubBoolColTableObj interface implementation for the schema.
	 */
	IBusModelPubBoolColTableObj getBoolColTableObj();

	/**
	 *	Get the BoolDef interface for the schema.
	 *
	 *	@return	The IBusModelPubBoolDefTableObj interface implementation for the schema.
	 */
	IBusModelPubBoolDefTableObj getBoolDefTableObj();

	/**
	 *	Get the BoolType interface for the schema.
	 *
	 *	@return	The IBusModelPubBoolTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubBoolTypeTableObj getBoolTypeTableObj();

	/**
	 *	Get the Chain interface for the schema.
	 *
	 *	@return	The IBusModelPubChainTableObj interface implementation for the schema.
	 */
	IBusModelPubChainTableObj getChainTableObj();

	/**
	 *	Get the ClearDep interface for the schema.
	 *
	 *	@return	The IBusModelPubClearDepTableObj interface implementation for the schema.
	 */
	IBusModelPubClearDepTableObj getClearDepTableObj();

	/**
	 *	Get the ClearSubDep1 interface for the schema.
	 *
	 *	@return	The IBusModelPubClearSubDep1TableObj interface implementation for the schema.
	 */
	IBusModelPubClearSubDep1TableObj getClearSubDep1TableObj();

	/**
	 *	Get the ClearSubDep2 interface for the schema.
	 *
	 *	@return	The IBusModelPubClearSubDep2TableObj interface implementation for the schema.
	 */
	IBusModelPubClearSubDep2TableObj getClearSubDep2TableObj();

	/**
	 *	Get the ClearSubDep3 interface for the schema.
	 *
	 *	@return	The IBusModelPubClearSubDep3TableObj interface implementation for the schema.
	 */
	IBusModelPubClearSubDep3TableObj getClearSubDep3TableObj();

	/**
	 *	Get the ClearTopDep interface for the schema.
	 *
	 *	@return	The IBusModelPubClearTopDepTableObj interface implementation for the schema.
	 */
	IBusModelPubClearTopDepTableObj getClearTopDepTableObj();

	/**
	 *	Get the DateCol interface for the schema.
	 *
	 *	@return	The IBusModelPubDateColTableObj interface implementation for the schema.
	 */
	IBusModelPubDateColTableObj getDateColTableObj();

	/**
	 *	Get the DateDef interface for the schema.
	 *
	 *	@return	The IBusModelPubDateDefTableObj interface implementation for the schema.
	 */
	IBusModelPubDateDefTableObj getDateDefTableObj();

	/**
	 *	Get the DateType interface for the schema.
	 *
	 *	@return	The IBusModelPubDateTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubDateTypeTableObj getDateTypeTableObj();

	/**
	 *	Get the DbKeyHash128Col interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash128ColTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash128ColTableObj getDbKeyHash128ColTableObj();

	/**
	 *	Get the DbKeyHash128Def interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash128DefTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash128DefTableObj getDbKeyHash128DefTableObj();

	/**
	 *	Get the DbKeyHash128Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash128GenTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash128GenTableObj getDbKeyHash128GenTableObj();

	/**
	 *	Get the DbKeyHash128Type interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash128TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash128TypeTableObj getDbKeyHash128TypeTableObj();

	/**
	 *	Get the DbKeyHash160Col interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash160ColTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash160ColTableObj getDbKeyHash160ColTableObj();

	/**
	 *	Get the DbKeyHash160Def interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash160DefTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash160DefTableObj getDbKeyHash160DefTableObj();

	/**
	 *	Get the DbKeyHash160Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash160GenTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash160GenTableObj getDbKeyHash160GenTableObj();

	/**
	 *	Get the DbKeyHash160Type interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash160TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash160TypeTableObj getDbKeyHash160TypeTableObj();

	/**
	 *	Get the DbKeyHash224Col interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash224ColTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash224ColTableObj getDbKeyHash224ColTableObj();

	/**
	 *	Get the DbKeyHash224Def interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash224DefTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash224DefTableObj getDbKeyHash224DefTableObj();

	/**
	 *	Get the DbKeyHash224Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash224GenTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash224GenTableObj getDbKeyHash224GenTableObj();

	/**
	 *	Get the DbKeyHash224Type interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash224TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash224TypeTableObj getDbKeyHash224TypeTableObj();

	/**
	 *	Get the DbKeyHash256Col interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash256ColTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash256ColTableObj getDbKeyHash256ColTableObj();

	/**
	 *	Get the DbKeyHash256Def interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash256DefTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash256DefTableObj getDbKeyHash256DefTableObj();

	/**
	 *	Get the DbKeyHash256Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash256GenTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash256GenTableObj getDbKeyHash256GenTableObj();

	/**
	 *	Get the DbKeyHash256Type interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash256TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash256TypeTableObj getDbKeyHash256TypeTableObj();

	/**
	 *	Get the DbKeyHash384Col interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash384ColTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash384ColTableObj getDbKeyHash384ColTableObj();

	/**
	 *	Get the DbKeyHash384Def interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash384DefTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash384DefTableObj getDbKeyHash384DefTableObj();

	/**
	 *	Get the DbKeyHash384Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash384GenTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash384GenTableObj getDbKeyHash384GenTableObj();

	/**
	 *	Get the DbKeyHash384Type interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash384TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash384TypeTableObj getDbKeyHash384TypeTableObj();

	/**
	 *	Get the DbKeyHash512Col interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash512ColTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash512ColTableObj getDbKeyHash512ColTableObj();

	/**
	 *	Get the DbKeyHash512Def interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash512DefTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash512DefTableObj getDbKeyHash512DefTableObj();

	/**
	 *	Get the DbKeyHash512Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash512GenTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash512GenTableObj getDbKeyHash512GenTableObj();

	/**
	 *	Get the DbKeyHash512Type interface for the schema.
	 *
	 *	@return	The IBusModelPubDbKeyHash512TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubDbKeyHash512TypeTableObj getDbKeyHash512TypeTableObj();

	/**
	 *	Get the DelDep interface for the schema.
	 *
	 *	@return	The IBusModelPubDelDepTableObj interface implementation for the schema.
	 */
	IBusModelPubDelDepTableObj getDelDepTableObj();

	/**
	 *	Get the DelSubDep1 interface for the schema.
	 *
	 *	@return	The IBusModelPubDelSubDep1TableObj interface implementation for the schema.
	 */
	IBusModelPubDelSubDep1TableObj getDelSubDep1TableObj();

	/**
	 *	Get the DelSubDep2 interface for the schema.
	 *
	 *	@return	The IBusModelPubDelSubDep2TableObj interface implementation for the schema.
	 */
	IBusModelPubDelSubDep2TableObj getDelSubDep2TableObj();

	/**
	 *	Get the DelSubDep3 interface for the schema.
	 *
	 *	@return	The IBusModelPubDelSubDep3TableObj interface implementation for the schema.
	 */
	IBusModelPubDelSubDep3TableObj getDelSubDep3TableObj();

	/**
	 *	Get the DelTopDep interface for the schema.
	 *
	 *	@return	The IBusModelPubDelTopDepTableObj interface implementation for the schema.
	 */
	IBusModelPubDelTopDepTableObj getDelTopDepTableObj();

	/**
	 *	Get the DoubleCol interface for the schema.
	 *
	 *	@return	The IBusModelPubDoubleColTableObj interface implementation for the schema.
	 */
	IBusModelPubDoubleColTableObj getDoubleColTableObj();

	/**
	 *	Get the DoubleDef interface for the schema.
	 *
	 *	@return	The IBusModelPubDoubleDefTableObj interface implementation for the schema.
	 */
	IBusModelPubDoubleDefTableObj getDoubleDefTableObj();

	/**
	 *	Get the DoubleType interface for the schema.
	 *
	 *	@return	The IBusModelPubDoubleTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubDoubleTypeTableObj getDoubleTypeTableObj();

	/**
	 *	Get the EnumDef interface for the schema.
	 *
	 *	@return	The IBusModelPubEnumDefTableObj interface implementation for the schema.
	 */
	IBusModelPubEnumDefTableObj getEnumDefTableObj();

	/**
	 *	Get the EnumTag interface for the schema.
	 *
	 *	@return	The IBusModelPubEnumTagTableObj interface implementation for the schema.
	 */
	IBusModelPubEnumTagTableObj getEnumTagTableObj();

	/**
	 *	Get the EnumType interface for the schema.
	 *
	 *	@return	The IBusModelPubEnumTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubEnumTypeTableObj getEnumTypeTableObj();

	/**
	 *	Get the FloatCol interface for the schema.
	 *
	 *	@return	The IBusModelPubFloatColTableObj interface implementation for the schema.
	 */
	IBusModelPubFloatColTableObj getFloatColTableObj();

	/**
	 *	Get the FloatDef interface for the schema.
	 *
	 *	@return	The IBusModelPubFloatDefTableObj interface implementation for the schema.
	 */
	IBusModelPubFloatDefTableObj getFloatDefTableObj();

	/**
	 *	Get the FloatType interface for the schema.
	 *
	 *	@return	The IBusModelPubFloatTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubFloatTypeTableObj getFloatTypeTableObj();

	/**
	 *	Get the Id16Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubId16GenTableObj interface implementation for the schema.
	 */
	IBusModelPubId16GenTableObj getId16GenTableObj();

	/**
	 *	Get the Id32Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubId32GenTableObj interface implementation for the schema.
	 */
	IBusModelPubId32GenTableObj getId32GenTableObj();

	/**
	 *	Get the Id64Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubId64GenTableObj interface implementation for the schema.
	 */
	IBusModelPubId64GenTableObj getId64GenTableObj();

	/**
	 *	Get the Index interface for the schema.
	 *
	 *	@return	The IBusModelPubIndexTableObj interface implementation for the schema.
	 */
	IBusModelPubIndexTableObj getIndexTableObj();

	/**
	 *	Get the IndexCol interface for the schema.
	 *
	 *	@return	The IBusModelPubIndexColTableObj interface implementation for the schema.
	 */
	IBusModelPubIndexColTableObj getIndexColTableObj();

	/**
	 *	Get the IndexTweak interface for the schema.
	 *
	 *	@return	The IBusModelPubIndexTweakTableObj interface implementation for the schema.
	 */
	IBusModelPubIndexTweakTableObj getIndexTweakTableObj();

	/**
	 *	Get the Int16Col interface for the schema.
	 *
	 *	@return	The IBusModelPubInt16ColTableObj interface implementation for the schema.
	 */
	IBusModelPubInt16ColTableObj getInt16ColTableObj();

	/**
	 *	Get the Int16Def interface for the schema.
	 *
	 *	@return	The IBusModelPubInt16DefTableObj interface implementation for the schema.
	 */
	IBusModelPubInt16DefTableObj getInt16DefTableObj();

	/**
	 *	Get the Int16Type interface for the schema.
	 *
	 *	@return	The IBusModelPubInt16TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubInt16TypeTableObj getInt16TypeTableObj();

	/**
	 *	Get the Int32Col interface for the schema.
	 *
	 *	@return	The IBusModelPubInt32ColTableObj interface implementation for the schema.
	 */
	IBusModelPubInt32ColTableObj getInt32ColTableObj();

	/**
	 *	Get the Int32Def interface for the schema.
	 *
	 *	@return	The IBusModelPubInt32DefTableObj interface implementation for the schema.
	 */
	IBusModelPubInt32DefTableObj getInt32DefTableObj();

	/**
	 *	Get the Int32Type interface for the schema.
	 *
	 *	@return	The IBusModelPubInt32TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubInt32TypeTableObj getInt32TypeTableObj();

	/**
	 *	Get the Int64Col interface for the schema.
	 *
	 *	@return	The IBusModelPubInt64ColTableObj interface implementation for the schema.
	 */
	IBusModelPubInt64ColTableObj getInt64ColTableObj();

	/**
	 *	Get the Int64Def interface for the schema.
	 *
	 *	@return	The IBusModelPubInt64DefTableObj interface implementation for the schema.
	 */
	IBusModelPubInt64DefTableObj getInt64DefTableObj();

	/**
	 *	Get the Int64Type interface for the schema.
	 *
	 *	@return	The IBusModelPubInt64TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubInt64TypeTableObj getInt64TypeTableObj();

	/**
	 *	Get the NmTokenCol interface for the schema.
	 *
	 *	@return	The IBusModelPubNmTokenColTableObj interface implementation for the schema.
	 */
	IBusModelPubNmTokenColTableObj getNmTokenColTableObj();

	/**
	 *	Get the NmTokenDef interface for the schema.
	 *
	 *	@return	The IBusModelPubNmTokenDefTableObj interface implementation for the schema.
	 */
	IBusModelPubNmTokenDefTableObj getNmTokenDefTableObj();

	/**
	 *	Get the NmTokenType interface for the schema.
	 *
	 *	@return	The IBusModelPubNmTokenTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubNmTokenTypeTableObj getNmTokenTypeTableObj();

	/**
	 *	Get the NmTokensCol interface for the schema.
	 *
	 *	@return	The IBusModelPubNmTokensColTableObj interface implementation for the schema.
	 */
	IBusModelPubNmTokensColTableObj getNmTokensColTableObj();

	/**
	 *	Get the NmTokensDef interface for the schema.
	 *
	 *	@return	The IBusModelPubNmTokensDefTableObj interface implementation for the schema.
	 */
	IBusModelPubNmTokensDefTableObj getNmTokensDefTableObj();

	/**
	 *	Get the NmTokensType interface for the schema.
	 *
	 *	@return	The IBusModelPubNmTokensTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubNmTokensTypeTableObj getNmTokensTypeTableObj();

	/**
	 *	Get the NumberCol interface for the schema.
	 *
	 *	@return	The IBusModelPubNumberColTableObj interface implementation for the schema.
	 */
	IBusModelPubNumberColTableObj getNumberColTableObj();

	/**
	 *	Get the NumberDef interface for the schema.
	 *
	 *	@return	The IBusModelPubNumberDefTableObj interface implementation for the schema.
	 */
	IBusModelPubNumberDefTableObj getNumberDefTableObj();

	/**
	 *	Get the NumberType interface for the schema.
	 *
	 *	@return	The IBusModelPubNumberTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubNumberTypeTableObj getNumberTypeTableObj();

	/**
	 *	Get the Param interface for the schema.
	 *
	 *	@return	The IBusModelPubParamTableObj interface implementation for the schema.
	 */
	IBusModelPubParamTableObj getParamTableObj();

	/**
	 *	Get the PopDep interface for the schema.
	 *
	 *	@return	The IBusModelPubPopDepTableObj interface implementation for the schema.
	 */
	IBusModelPubPopDepTableObj getPopDepTableObj();

	/**
	 *	Get the PopSubDep1 interface for the schema.
	 *
	 *	@return	The IBusModelPubPopSubDep1TableObj interface implementation for the schema.
	 */
	IBusModelPubPopSubDep1TableObj getPopSubDep1TableObj();

	/**
	 *	Get the PopSubDep2 interface for the schema.
	 *
	 *	@return	The IBusModelPubPopSubDep2TableObj interface implementation for the schema.
	 */
	IBusModelPubPopSubDep2TableObj getPopSubDep2TableObj();

	/**
	 *	Get the PopSubDep3 interface for the schema.
	 *
	 *	@return	The IBusModelPubPopSubDep3TableObj interface implementation for the schema.
	 */
	IBusModelPubPopSubDep3TableObj getPopSubDep3TableObj();

	/**
	 *	Get the PopTopDep interface for the schema.
	 *
	 *	@return	The IBusModelPubPopTopDepTableObj interface implementation for the schema.
	 */
	IBusModelPubPopTopDepTableObj getPopTopDepTableObj();

	/**
	 *	Get the Relation interface for the schema.
	 *
	 *	@return	The IBusModelPubRelationTableObj interface implementation for the schema.
	 */
	IBusModelPubRelationTableObj getRelationTableObj();

	/**
	 *	Get the RelationCol interface for the schema.
	 *
	 *	@return	The IBusModelPubRelationColTableObj interface implementation for the schema.
	 */
	IBusModelPubRelationColTableObj getRelationColTableObj();

	/**
	 *	Get the RoleDef interface for the schema.
	 *
	 *	@return	The IBusModelPubRoleDefTableObj interface implementation for the schema.
	 */
	IBusModelPubRoleDefTableObj getRoleDefTableObj();

	/**
	 *	Get the SchemaDef interface for the schema.
	 *
	 *	@return	The IBusModelPubSchemaDefTableObj interface implementation for the schema.
	 */
	IBusModelPubSchemaDefTableObj getSchemaDefTableObj();

	/**
	 *	Get the SchemaRef interface for the schema.
	 *
	 *	@return	The IBusModelPubSchemaRefTableObj interface implementation for the schema.
	 */
	IBusModelPubSchemaRefTableObj getSchemaRefTableObj();

	/**
	 *	Get the SchemaRole interface for the schema.
	 *
	 *	@return	The IBusModelPubSchemaRoleTableObj interface implementation for the schema.
	 */
	IBusModelPubSchemaRoleTableObj getSchemaRoleTableObj();

	/**
	 *	Get the SchemaTweak interface for the schema.
	 *
	 *	@return	The IBusModelPubSchemaTweakTableObj interface implementation for the schema.
	 */
	IBusModelPubSchemaTweakTableObj getSchemaTweakTableObj();

	/**
	 *	Get the Scope interface for the schema.
	 *
	 *	@return	The IBusModelPubScopeTableObj interface implementation for the schema.
	 */
	IBusModelPubScopeTableObj getScopeTableObj();

	/**
	 *	Get the ServerListFunc interface for the schema.
	 *
	 *	@return	The IBusModelPubServerListFuncTableObj interface implementation for the schema.
	 */
	IBusModelPubServerListFuncTableObj getServerListFuncTableObj();

	/**
	 *	Get the ServerMethod interface for the schema.
	 *
	 *	@return	The IBusModelPubServerMethodTableObj interface implementation for the schema.
	 */
	IBusModelPubServerMethodTableObj getServerMethodTableObj();

	/**
	 *	Get the ServerObjFunc interface for the schema.
	 *
	 *	@return	The IBusModelPubServerObjFuncTableObj interface implementation for the schema.
	 */
	IBusModelPubServerObjFuncTableObj getServerObjFuncTableObj();

	/**
	 *	Get the ServerProc interface for the schema.
	 *
	 *	@return	The IBusModelPubServerProcTableObj interface implementation for the schema.
	 */
	IBusModelPubServerProcTableObj getServerProcTableObj();

	/**
	 *	Get the StringCol interface for the schema.
	 *
	 *	@return	The IBusModelPubStringColTableObj interface implementation for the schema.
	 */
	IBusModelPubStringColTableObj getStringColTableObj();

	/**
	 *	Get the StringDef interface for the schema.
	 *
	 *	@return	The IBusModelPubStringDefTableObj interface implementation for the schema.
	 */
	IBusModelPubStringDefTableObj getStringDefTableObj();

	/**
	 *	Get the StringType interface for the schema.
	 *
	 *	@return	The IBusModelPubStringTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubStringTypeTableObj getStringTypeTableObj();

	/**
	 *	Get the TZDateCol interface for the schema.
	 *
	 *	@return	The IBusModelPubTZDateColTableObj interface implementation for the schema.
	 */
	IBusModelPubTZDateColTableObj getTZDateColTableObj();

	/**
	 *	Get the TZDateDef interface for the schema.
	 *
	 *	@return	The IBusModelPubTZDateDefTableObj interface implementation for the schema.
	 */
	IBusModelPubTZDateDefTableObj getTZDateDefTableObj();

	/**
	 *	Get the TZDateType interface for the schema.
	 *
	 *	@return	The IBusModelPubTZDateTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubTZDateTypeTableObj getTZDateTypeTableObj();

	/**
	 *	Get the TZTimeCol interface for the schema.
	 *
	 *	@return	The IBusModelPubTZTimeColTableObj interface implementation for the schema.
	 */
	IBusModelPubTZTimeColTableObj getTZTimeColTableObj();

	/**
	 *	Get the TZTimeDef interface for the schema.
	 *
	 *	@return	The IBusModelPubTZTimeDefTableObj interface implementation for the schema.
	 */
	IBusModelPubTZTimeDefTableObj getTZTimeDefTableObj();

	/**
	 *	Get the TZTimeType interface for the schema.
	 *
	 *	@return	The IBusModelPubTZTimeTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubTZTimeTypeTableObj getTZTimeTypeTableObj();

	/**
	 *	Get the TZTimestampCol interface for the schema.
	 *
	 *	@return	The IBusModelPubTZTimestampColTableObj interface implementation for the schema.
	 */
	IBusModelPubTZTimestampColTableObj getTZTimestampColTableObj();

	/**
	 *	Get the TZTimestampDef interface for the schema.
	 *
	 *	@return	The IBusModelPubTZTimestampDefTableObj interface implementation for the schema.
	 */
	IBusModelPubTZTimestampDefTableObj getTZTimestampDefTableObj();

	/**
	 *	Get the TZTimestampType interface for the schema.
	 *
	 *	@return	The IBusModelPubTZTimestampTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubTZTimestampTypeTableObj getTZTimestampTypeTableObj();

	/**
	 *	Get the Table interface for the schema.
	 *
	 *	@return	The IBusModelPubTableTableObj interface implementation for the schema.
	 */
	IBusModelPubTableTableObj getTableTableObj();

	/**
	 *	Get the TableCol interface for the schema.
	 *
	 *	@return	The IBusModelPubTableColTableObj interface implementation for the schema.
	 */
	IBusModelPubTableColTableObj getTableColTableObj();

	/**
	 *	Get the TableTweak interface for the schema.
	 *
	 *	@return	The IBusModelPubTableTweakTableObj interface implementation for the schema.
	 */
	IBusModelPubTableTweakTableObj getTableTweakTableObj();

	/**
	 *	Get the TextCol interface for the schema.
	 *
	 *	@return	The IBusModelPubTextColTableObj interface implementation for the schema.
	 */
	IBusModelPubTextColTableObj getTextColTableObj();

	/**
	 *	Get the TextDef interface for the schema.
	 *
	 *	@return	The IBusModelPubTextDefTableObj interface implementation for the schema.
	 */
	IBusModelPubTextDefTableObj getTextDefTableObj();

	/**
	 *	Get the TextType interface for the schema.
	 *
	 *	@return	The IBusModelPubTextTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubTextTypeTableObj getTextTypeTableObj();

	/**
	 *	Get the TimeCol interface for the schema.
	 *
	 *	@return	The IBusModelPubTimeColTableObj interface implementation for the schema.
	 */
	IBusModelPubTimeColTableObj getTimeColTableObj();

	/**
	 *	Get the TimeDef interface for the schema.
	 *
	 *	@return	The IBusModelPubTimeDefTableObj interface implementation for the schema.
	 */
	IBusModelPubTimeDefTableObj getTimeDefTableObj();

	/**
	 *	Get the TimeType interface for the schema.
	 *
	 *	@return	The IBusModelPubTimeTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubTimeTypeTableObj getTimeTypeTableObj();

	/**
	 *	Get the TimestampCol interface for the schema.
	 *
	 *	@return	The IBusModelPubTimestampColTableObj interface implementation for the schema.
	 */
	IBusModelPubTimestampColTableObj getTimestampColTableObj();

	/**
	 *	Get the TimestampDef interface for the schema.
	 *
	 *	@return	The IBusModelPubTimestampDefTableObj interface implementation for the schema.
	 */
	IBusModelPubTimestampDefTableObj getTimestampDefTableObj();

	/**
	 *	Get the TimestampType interface for the schema.
	 *
	 *	@return	The IBusModelPubTimestampTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubTimestampTypeTableObj getTimestampTypeTableObj();

	/**
	 *	Get the TokenCol interface for the schema.
	 *
	 *	@return	The IBusModelPubTokenColTableObj interface implementation for the schema.
	 */
	IBusModelPubTokenColTableObj getTokenColTableObj();

	/**
	 *	Get the TokenDef interface for the schema.
	 *
	 *	@return	The IBusModelPubTokenDefTableObj interface implementation for the schema.
	 */
	IBusModelPubTokenDefTableObj getTokenDefTableObj();

	/**
	 *	Get the TokenType interface for the schema.
	 *
	 *	@return	The IBusModelPubTokenTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubTokenTypeTableObj getTokenTypeTableObj();

	/**
	 *	Get the Tweak interface for the schema.
	 *
	 *	@return	The IBusModelPubTweakTableObj interface implementation for the schema.
	 */
	IBusModelPubTweakTableObj getTweakTableObj();

	/**
	 *	Get the UInt16Col interface for the schema.
	 *
	 *	@return	The IBusModelPubUInt16ColTableObj interface implementation for the schema.
	 */
	IBusModelPubUInt16ColTableObj getUInt16ColTableObj();

	/**
	 *	Get the UInt16Def interface for the schema.
	 *
	 *	@return	The IBusModelPubUInt16DefTableObj interface implementation for the schema.
	 */
	IBusModelPubUInt16DefTableObj getUInt16DefTableObj();

	/**
	 *	Get the UInt16Type interface for the schema.
	 *
	 *	@return	The IBusModelPubUInt16TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubUInt16TypeTableObj getUInt16TypeTableObj();

	/**
	 *	Get the UInt32Col interface for the schema.
	 *
	 *	@return	The IBusModelPubUInt32ColTableObj interface implementation for the schema.
	 */
	IBusModelPubUInt32ColTableObj getUInt32ColTableObj();

	/**
	 *	Get the UInt32Def interface for the schema.
	 *
	 *	@return	The IBusModelPubUInt32DefTableObj interface implementation for the schema.
	 */
	IBusModelPubUInt32DefTableObj getUInt32DefTableObj();

	/**
	 *	Get the UInt32Type interface for the schema.
	 *
	 *	@return	The IBusModelPubUInt32TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubUInt32TypeTableObj getUInt32TypeTableObj();

	/**
	 *	Get the UInt64Col interface for the schema.
	 *
	 *	@return	The IBusModelPubUInt64ColTableObj interface implementation for the schema.
	 */
	IBusModelPubUInt64ColTableObj getUInt64ColTableObj();

	/**
	 *	Get the UInt64Def interface for the schema.
	 *
	 *	@return	The IBusModelPubUInt64DefTableObj interface implementation for the schema.
	 */
	IBusModelPubUInt64DefTableObj getUInt64DefTableObj();

	/**
	 *	Get the UInt64Type interface for the schema.
	 *
	 *	@return	The IBusModelPubUInt64TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubUInt64TypeTableObj getUInt64TypeTableObj();

	/**
	 *	Get the Uuid6Col interface for the schema.
	 *
	 *	@return	The IBusModelPubUuid6ColTableObj interface implementation for the schema.
	 */
	IBusModelPubUuid6ColTableObj getUuid6ColTableObj();

	/**
	 *	Get the Uuid6Def interface for the schema.
	 *
	 *	@return	The IBusModelPubUuid6DefTableObj interface implementation for the schema.
	 */
	IBusModelPubUuid6DefTableObj getUuid6DefTableObj();

	/**
	 *	Get the Uuid6Gen interface for the schema.
	 *
	 *	@return	The IBusModelPubUuid6GenTableObj interface implementation for the schema.
	 */
	IBusModelPubUuid6GenTableObj getUuid6GenTableObj();

	/**
	 *	Get the Uuid6Type interface for the schema.
	 *
	 *	@return	The IBusModelPubUuid6TypeTableObj interface implementation for the schema.
	 */
	IBusModelPubUuid6TypeTableObj getUuid6TypeTableObj();

	/**
	 *	Get the UuidCol interface for the schema.
	 *
	 *	@return	The IBusModelPubUuidColTableObj interface implementation for the schema.
	 */
	IBusModelPubUuidColTableObj getUuidColTableObj();

	/**
	 *	Get the UuidDef interface for the schema.
	 *
	 *	@return	The IBusModelPubUuidDefTableObj interface implementation for the schema.
	 */
	IBusModelPubUuidDefTableObj getUuidDefTableObj();

	/**
	 *	Get the UuidGen interface for the schema.
	 *
	 *	@return	The IBusModelPubUuidGenTableObj interface implementation for the schema.
	 */
	IBusModelPubUuidGenTableObj getUuidGenTableObj();

	/**
	 *	Get the UuidType interface for the schema.
	 *
	 *	@return	The IBusModelPubUuidTypeTableObj interface implementation for the schema.
	 */
	IBusModelPubUuidTypeTableObj getUuidTypeTableObj();

	/**
	 *	Get the Value interface for the schema.
	 *
	 *	@return	The IBusModelPubValueTableObj interface implementation for the schema.
	 */
	IBusModelPubValueTableObj getValueTableObj();
}
