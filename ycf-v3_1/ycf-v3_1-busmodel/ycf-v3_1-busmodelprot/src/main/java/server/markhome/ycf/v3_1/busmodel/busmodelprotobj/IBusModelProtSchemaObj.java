// Description: Java 25 Protected Schema Object interface for BusModelProt.

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

package server.markhome.ycf.v3_1.busmodel.busmodelprotobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;

public interface IBusModelProtSchemaObj
	extends ISecurePubSchemaObj,
		IIntNetPubSchemaObj
{
	public ISecurePubSchema getSecureProtBackingStore();
	public void setSecureProtBackingStore(ISecurePubSchema secureprotBackingStore);

	public IIntNetPubSchema getIntNetProtBackingStore();
	public void setIntNetProtBackingStore(IIntNetPubSchema intnetprotBackingStore);

	public IBusModelProtSchema getBusModelProtBackingStore();
	public void setBusModelProtBackingStore(IBusModelProtSchema busmodelprotBackingStore);

	/**
	 *	Get the Atom interface for the schema.
	 *
	 *	@return	The IBusModelProtAtomTableObj interface implementation for the schema.
	 */
	IBusModelProtAtomTableObj getAtomTableObj();

	/**
	 *	Get the BlobCol interface for the schema.
	 *
	 *	@return	The IBusModelProtBlobColTableObj interface implementation for the schema.
	 */
	IBusModelProtBlobColTableObj getBlobColTableObj();

	/**
	 *	Get the BlobDef interface for the schema.
	 *
	 *	@return	The IBusModelProtBlobDefTableObj interface implementation for the schema.
	 */
	IBusModelProtBlobDefTableObj getBlobDefTableObj();

	/**
	 *	Get the BlobType interface for the schema.
	 *
	 *	@return	The IBusModelProtBlobTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtBlobTypeTableObj getBlobTypeTableObj();

	/**
	 *	Get the BoolCol interface for the schema.
	 *
	 *	@return	The IBusModelProtBoolColTableObj interface implementation for the schema.
	 */
	IBusModelProtBoolColTableObj getBoolColTableObj();

	/**
	 *	Get the BoolDef interface for the schema.
	 *
	 *	@return	The IBusModelProtBoolDefTableObj interface implementation for the schema.
	 */
	IBusModelProtBoolDefTableObj getBoolDefTableObj();

	/**
	 *	Get the BoolType interface for the schema.
	 *
	 *	@return	The IBusModelProtBoolTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtBoolTypeTableObj getBoolTypeTableObj();

	/**
	 *	Get the Chain interface for the schema.
	 *
	 *	@return	The IBusModelProtChainTableObj interface implementation for the schema.
	 */
	IBusModelProtChainTableObj getChainTableObj();

	/**
	 *	Get the ClearDep interface for the schema.
	 *
	 *	@return	The IBusModelProtClearDepTableObj interface implementation for the schema.
	 */
	IBusModelProtClearDepTableObj getClearDepTableObj();

	/**
	 *	Get the ClearSubDep1 interface for the schema.
	 *
	 *	@return	The IBusModelProtClearSubDep1TableObj interface implementation for the schema.
	 */
	IBusModelProtClearSubDep1TableObj getClearSubDep1TableObj();

	/**
	 *	Get the ClearSubDep2 interface for the schema.
	 *
	 *	@return	The IBusModelProtClearSubDep2TableObj interface implementation for the schema.
	 */
	IBusModelProtClearSubDep2TableObj getClearSubDep2TableObj();

	/**
	 *	Get the ClearSubDep3 interface for the schema.
	 *
	 *	@return	The IBusModelProtClearSubDep3TableObj interface implementation for the schema.
	 */
	IBusModelProtClearSubDep3TableObj getClearSubDep3TableObj();

	/**
	 *	Get the ClearTopDep interface for the schema.
	 *
	 *	@return	The IBusModelProtClearTopDepTableObj interface implementation for the schema.
	 */
	IBusModelProtClearTopDepTableObj getClearTopDepTableObj();

	/**
	 *	Get the DateCol interface for the schema.
	 *
	 *	@return	The IBusModelProtDateColTableObj interface implementation for the schema.
	 */
	IBusModelProtDateColTableObj getDateColTableObj();

	/**
	 *	Get the DateDef interface for the schema.
	 *
	 *	@return	The IBusModelProtDateDefTableObj interface implementation for the schema.
	 */
	IBusModelProtDateDefTableObj getDateDefTableObj();

	/**
	 *	Get the DateType interface for the schema.
	 *
	 *	@return	The IBusModelProtDateTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtDateTypeTableObj getDateTypeTableObj();

	/**
	 *	Get the DbKeyHash128Col interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash128ColTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash128ColTableObj getDbKeyHash128ColTableObj();

	/**
	 *	Get the DbKeyHash128Def interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash128DefTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash128DefTableObj getDbKeyHash128DefTableObj();

	/**
	 *	Get the DbKeyHash128Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash128GenTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash128GenTableObj getDbKeyHash128GenTableObj();

	/**
	 *	Get the DbKeyHash128Type interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash128TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash128TypeTableObj getDbKeyHash128TypeTableObj();

	/**
	 *	Get the DbKeyHash160Col interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash160ColTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash160ColTableObj getDbKeyHash160ColTableObj();

	/**
	 *	Get the DbKeyHash160Def interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash160DefTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash160DefTableObj getDbKeyHash160DefTableObj();

	/**
	 *	Get the DbKeyHash160Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash160GenTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash160GenTableObj getDbKeyHash160GenTableObj();

	/**
	 *	Get the DbKeyHash160Type interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash160TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash160TypeTableObj getDbKeyHash160TypeTableObj();

	/**
	 *	Get the DbKeyHash224Col interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash224ColTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash224ColTableObj getDbKeyHash224ColTableObj();

	/**
	 *	Get the DbKeyHash224Def interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash224DefTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash224DefTableObj getDbKeyHash224DefTableObj();

	/**
	 *	Get the DbKeyHash224Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash224GenTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash224GenTableObj getDbKeyHash224GenTableObj();

	/**
	 *	Get the DbKeyHash224Type interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash224TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash224TypeTableObj getDbKeyHash224TypeTableObj();

	/**
	 *	Get the DbKeyHash256Col interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash256ColTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash256ColTableObj getDbKeyHash256ColTableObj();

	/**
	 *	Get the DbKeyHash256Def interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash256DefTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash256DefTableObj getDbKeyHash256DefTableObj();

	/**
	 *	Get the DbKeyHash256Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash256GenTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash256GenTableObj getDbKeyHash256GenTableObj();

	/**
	 *	Get the DbKeyHash256Type interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash256TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash256TypeTableObj getDbKeyHash256TypeTableObj();

	/**
	 *	Get the DbKeyHash384Col interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash384ColTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash384ColTableObj getDbKeyHash384ColTableObj();

	/**
	 *	Get the DbKeyHash384Def interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash384DefTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash384DefTableObj getDbKeyHash384DefTableObj();

	/**
	 *	Get the DbKeyHash384Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash384GenTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash384GenTableObj getDbKeyHash384GenTableObj();

	/**
	 *	Get the DbKeyHash384Type interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash384TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash384TypeTableObj getDbKeyHash384TypeTableObj();

	/**
	 *	Get the DbKeyHash512Col interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash512ColTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash512ColTableObj getDbKeyHash512ColTableObj();

	/**
	 *	Get the DbKeyHash512Def interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash512DefTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash512DefTableObj getDbKeyHash512DefTableObj();

	/**
	 *	Get the DbKeyHash512Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash512GenTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash512GenTableObj getDbKeyHash512GenTableObj();

	/**
	 *	Get the DbKeyHash512Type interface for the schema.
	 *
	 *	@return	The IBusModelProtDbKeyHash512TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtDbKeyHash512TypeTableObj getDbKeyHash512TypeTableObj();

	/**
	 *	Get the DelDep interface for the schema.
	 *
	 *	@return	The IBusModelProtDelDepTableObj interface implementation for the schema.
	 */
	IBusModelProtDelDepTableObj getDelDepTableObj();

	/**
	 *	Get the DelSubDep1 interface for the schema.
	 *
	 *	@return	The IBusModelProtDelSubDep1TableObj interface implementation for the schema.
	 */
	IBusModelProtDelSubDep1TableObj getDelSubDep1TableObj();

	/**
	 *	Get the DelSubDep2 interface for the schema.
	 *
	 *	@return	The IBusModelProtDelSubDep2TableObj interface implementation for the schema.
	 */
	IBusModelProtDelSubDep2TableObj getDelSubDep2TableObj();

	/**
	 *	Get the DelSubDep3 interface for the schema.
	 *
	 *	@return	The IBusModelProtDelSubDep3TableObj interface implementation for the schema.
	 */
	IBusModelProtDelSubDep3TableObj getDelSubDep3TableObj();

	/**
	 *	Get the DelTopDep interface for the schema.
	 *
	 *	@return	The IBusModelProtDelTopDepTableObj interface implementation for the schema.
	 */
	IBusModelProtDelTopDepTableObj getDelTopDepTableObj();

	/**
	 *	Get the DoubleCol interface for the schema.
	 *
	 *	@return	The IBusModelProtDoubleColTableObj interface implementation for the schema.
	 */
	IBusModelProtDoubleColTableObj getDoubleColTableObj();

	/**
	 *	Get the DoubleDef interface for the schema.
	 *
	 *	@return	The IBusModelProtDoubleDefTableObj interface implementation for the schema.
	 */
	IBusModelProtDoubleDefTableObj getDoubleDefTableObj();

	/**
	 *	Get the DoubleType interface for the schema.
	 *
	 *	@return	The IBusModelProtDoubleTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtDoubleTypeTableObj getDoubleTypeTableObj();

	/**
	 *	Get the EnumDef interface for the schema.
	 *
	 *	@return	The IBusModelProtEnumDefTableObj interface implementation for the schema.
	 */
	IBusModelProtEnumDefTableObj getEnumDefTableObj();

	/**
	 *	Get the EnumTag interface for the schema.
	 *
	 *	@return	The IBusModelProtEnumTagTableObj interface implementation for the schema.
	 */
	IBusModelProtEnumTagTableObj getEnumTagTableObj();

	/**
	 *	Get the EnumType interface for the schema.
	 *
	 *	@return	The IBusModelProtEnumTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtEnumTypeTableObj getEnumTypeTableObj();

	/**
	 *	Get the FloatCol interface for the schema.
	 *
	 *	@return	The IBusModelProtFloatColTableObj interface implementation for the schema.
	 */
	IBusModelProtFloatColTableObj getFloatColTableObj();

	/**
	 *	Get the FloatDef interface for the schema.
	 *
	 *	@return	The IBusModelProtFloatDefTableObj interface implementation for the schema.
	 */
	IBusModelProtFloatDefTableObj getFloatDefTableObj();

	/**
	 *	Get the FloatType interface for the schema.
	 *
	 *	@return	The IBusModelProtFloatTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtFloatTypeTableObj getFloatTypeTableObj();

	/**
	 *	Get the Id16Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtId16GenTableObj interface implementation for the schema.
	 */
	IBusModelProtId16GenTableObj getId16GenTableObj();

	/**
	 *	Get the Id32Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtId32GenTableObj interface implementation for the schema.
	 */
	IBusModelProtId32GenTableObj getId32GenTableObj();

	/**
	 *	Get the Id64Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtId64GenTableObj interface implementation for the schema.
	 */
	IBusModelProtId64GenTableObj getId64GenTableObj();

	/**
	 *	Get the Index interface for the schema.
	 *
	 *	@return	The IBusModelProtIndexTableObj interface implementation for the schema.
	 */
	IBusModelProtIndexTableObj getIndexTableObj();

	/**
	 *	Get the IndexCol interface for the schema.
	 *
	 *	@return	The IBusModelProtIndexColTableObj interface implementation for the schema.
	 */
	IBusModelProtIndexColTableObj getIndexColTableObj();

	/**
	 *	Get the IndexTweak interface for the schema.
	 *
	 *	@return	The IBusModelProtIndexTweakTableObj interface implementation for the schema.
	 */
	IBusModelProtIndexTweakTableObj getIndexTweakTableObj();

	/**
	 *	Get the Int16Col interface for the schema.
	 *
	 *	@return	The IBusModelProtInt16ColTableObj interface implementation for the schema.
	 */
	IBusModelProtInt16ColTableObj getInt16ColTableObj();

	/**
	 *	Get the Int16Def interface for the schema.
	 *
	 *	@return	The IBusModelProtInt16DefTableObj interface implementation for the schema.
	 */
	IBusModelProtInt16DefTableObj getInt16DefTableObj();

	/**
	 *	Get the Int16Type interface for the schema.
	 *
	 *	@return	The IBusModelProtInt16TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtInt16TypeTableObj getInt16TypeTableObj();

	/**
	 *	Get the Int32Col interface for the schema.
	 *
	 *	@return	The IBusModelProtInt32ColTableObj interface implementation for the schema.
	 */
	IBusModelProtInt32ColTableObj getInt32ColTableObj();

	/**
	 *	Get the Int32Def interface for the schema.
	 *
	 *	@return	The IBusModelProtInt32DefTableObj interface implementation for the schema.
	 */
	IBusModelProtInt32DefTableObj getInt32DefTableObj();

	/**
	 *	Get the Int32Type interface for the schema.
	 *
	 *	@return	The IBusModelProtInt32TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtInt32TypeTableObj getInt32TypeTableObj();

	/**
	 *	Get the Int64Col interface for the schema.
	 *
	 *	@return	The IBusModelProtInt64ColTableObj interface implementation for the schema.
	 */
	IBusModelProtInt64ColTableObj getInt64ColTableObj();

	/**
	 *	Get the Int64Def interface for the schema.
	 *
	 *	@return	The IBusModelProtInt64DefTableObj interface implementation for the schema.
	 */
	IBusModelProtInt64DefTableObj getInt64DefTableObj();

	/**
	 *	Get the Int64Type interface for the schema.
	 *
	 *	@return	The IBusModelProtInt64TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtInt64TypeTableObj getInt64TypeTableObj();

	/**
	 *	Get the NmTokenCol interface for the schema.
	 *
	 *	@return	The IBusModelProtNmTokenColTableObj interface implementation for the schema.
	 */
	IBusModelProtNmTokenColTableObj getNmTokenColTableObj();

	/**
	 *	Get the NmTokenDef interface for the schema.
	 *
	 *	@return	The IBusModelProtNmTokenDefTableObj interface implementation for the schema.
	 */
	IBusModelProtNmTokenDefTableObj getNmTokenDefTableObj();

	/**
	 *	Get the NmTokenType interface for the schema.
	 *
	 *	@return	The IBusModelProtNmTokenTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtNmTokenTypeTableObj getNmTokenTypeTableObj();

	/**
	 *	Get the NmTokensCol interface for the schema.
	 *
	 *	@return	The IBusModelProtNmTokensColTableObj interface implementation for the schema.
	 */
	IBusModelProtNmTokensColTableObj getNmTokensColTableObj();

	/**
	 *	Get the NmTokensDef interface for the schema.
	 *
	 *	@return	The IBusModelProtNmTokensDefTableObj interface implementation for the schema.
	 */
	IBusModelProtNmTokensDefTableObj getNmTokensDefTableObj();

	/**
	 *	Get the NmTokensType interface for the schema.
	 *
	 *	@return	The IBusModelProtNmTokensTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtNmTokensTypeTableObj getNmTokensTypeTableObj();

	/**
	 *	Get the NumberCol interface for the schema.
	 *
	 *	@return	The IBusModelProtNumberColTableObj interface implementation for the schema.
	 */
	IBusModelProtNumberColTableObj getNumberColTableObj();

	/**
	 *	Get the NumberDef interface for the schema.
	 *
	 *	@return	The IBusModelProtNumberDefTableObj interface implementation for the schema.
	 */
	IBusModelProtNumberDefTableObj getNumberDefTableObj();

	/**
	 *	Get the NumberType interface for the schema.
	 *
	 *	@return	The IBusModelProtNumberTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtNumberTypeTableObj getNumberTypeTableObj();

	/**
	 *	Get the Param interface for the schema.
	 *
	 *	@return	The IBusModelProtParamTableObj interface implementation for the schema.
	 */
	IBusModelProtParamTableObj getParamTableObj();

	/**
	 *	Get the PopDep interface for the schema.
	 *
	 *	@return	The IBusModelProtPopDepTableObj interface implementation for the schema.
	 */
	IBusModelProtPopDepTableObj getPopDepTableObj();

	/**
	 *	Get the PopSubDep1 interface for the schema.
	 *
	 *	@return	The IBusModelProtPopSubDep1TableObj interface implementation for the schema.
	 */
	IBusModelProtPopSubDep1TableObj getPopSubDep1TableObj();

	/**
	 *	Get the PopSubDep2 interface for the schema.
	 *
	 *	@return	The IBusModelProtPopSubDep2TableObj interface implementation for the schema.
	 */
	IBusModelProtPopSubDep2TableObj getPopSubDep2TableObj();

	/**
	 *	Get the PopSubDep3 interface for the schema.
	 *
	 *	@return	The IBusModelProtPopSubDep3TableObj interface implementation for the schema.
	 */
	IBusModelProtPopSubDep3TableObj getPopSubDep3TableObj();

	/**
	 *	Get the PopTopDep interface for the schema.
	 *
	 *	@return	The IBusModelProtPopTopDepTableObj interface implementation for the schema.
	 */
	IBusModelProtPopTopDepTableObj getPopTopDepTableObj();

	/**
	 *	Get the Relation interface for the schema.
	 *
	 *	@return	The IBusModelProtRelationTableObj interface implementation for the schema.
	 */
	IBusModelProtRelationTableObj getRelationTableObj();

	/**
	 *	Get the RelationCol interface for the schema.
	 *
	 *	@return	The IBusModelProtRelationColTableObj interface implementation for the schema.
	 */
	IBusModelProtRelationColTableObj getRelationColTableObj();

	/**
	 *	Get the RoleDef interface for the schema.
	 *
	 *	@return	The IBusModelProtRoleDefTableObj interface implementation for the schema.
	 */
	IBusModelProtRoleDefTableObj getRoleDefTableObj();

	/**
	 *	Get the SchemaDef interface for the schema.
	 *
	 *	@return	The IBusModelProtSchemaDefTableObj interface implementation for the schema.
	 */
	IBusModelProtSchemaDefTableObj getSchemaDefTableObj();

	/**
	 *	Get the SchemaRef interface for the schema.
	 *
	 *	@return	The IBusModelProtSchemaRefTableObj interface implementation for the schema.
	 */
	IBusModelProtSchemaRefTableObj getSchemaRefTableObj();

	/**
	 *	Get the SchemaRole interface for the schema.
	 *
	 *	@return	The IBusModelProtSchemaRoleTableObj interface implementation for the schema.
	 */
	IBusModelProtSchemaRoleTableObj getSchemaRoleTableObj();

	/**
	 *	Get the SchemaTweak interface for the schema.
	 *
	 *	@return	The IBusModelProtSchemaTweakTableObj interface implementation for the schema.
	 */
	IBusModelProtSchemaTweakTableObj getSchemaTweakTableObj();

	/**
	 *	Get the Scope interface for the schema.
	 *
	 *	@return	The IBusModelProtScopeTableObj interface implementation for the schema.
	 */
	IBusModelProtScopeTableObj getScopeTableObj();

	/**
	 *	Get the ServerListFunc interface for the schema.
	 *
	 *	@return	The IBusModelProtServerListFuncTableObj interface implementation for the schema.
	 */
	IBusModelProtServerListFuncTableObj getServerListFuncTableObj();

	/**
	 *	Get the ServerMethod interface for the schema.
	 *
	 *	@return	The IBusModelProtServerMethodTableObj interface implementation for the schema.
	 */
	IBusModelProtServerMethodTableObj getServerMethodTableObj();

	/**
	 *	Get the ServerObjFunc interface for the schema.
	 *
	 *	@return	The IBusModelProtServerObjFuncTableObj interface implementation for the schema.
	 */
	IBusModelProtServerObjFuncTableObj getServerObjFuncTableObj();

	/**
	 *	Get the ServerProc interface for the schema.
	 *
	 *	@return	The IBusModelProtServerProcTableObj interface implementation for the schema.
	 */
	IBusModelProtServerProcTableObj getServerProcTableObj();

	/**
	 *	Get the StringCol interface for the schema.
	 *
	 *	@return	The IBusModelProtStringColTableObj interface implementation for the schema.
	 */
	IBusModelProtStringColTableObj getStringColTableObj();

	/**
	 *	Get the StringDef interface for the schema.
	 *
	 *	@return	The IBusModelProtStringDefTableObj interface implementation for the schema.
	 */
	IBusModelProtStringDefTableObj getStringDefTableObj();

	/**
	 *	Get the StringType interface for the schema.
	 *
	 *	@return	The IBusModelProtStringTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtStringTypeTableObj getStringTypeTableObj();

	/**
	 *	Get the TZDateCol interface for the schema.
	 *
	 *	@return	The IBusModelProtTZDateColTableObj interface implementation for the schema.
	 */
	IBusModelProtTZDateColTableObj getTZDateColTableObj();

	/**
	 *	Get the TZDateDef interface for the schema.
	 *
	 *	@return	The IBusModelProtTZDateDefTableObj interface implementation for the schema.
	 */
	IBusModelProtTZDateDefTableObj getTZDateDefTableObj();

	/**
	 *	Get the TZDateType interface for the schema.
	 *
	 *	@return	The IBusModelProtTZDateTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtTZDateTypeTableObj getTZDateTypeTableObj();

	/**
	 *	Get the TZTimeCol interface for the schema.
	 *
	 *	@return	The IBusModelProtTZTimeColTableObj interface implementation for the schema.
	 */
	IBusModelProtTZTimeColTableObj getTZTimeColTableObj();

	/**
	 *	Get the TZTimeDef interface for the schema.
	 *
	 *	@return	The IBusModelProtTZTimeDefTableObj interface implementation for the schema.
	 */
	IBusModelProtTZTimeDefTableObj getTZTimeDefTableObj();

	/**
	 *	Get the TZTimeType interface for the schema.
	 *
	 *	@return	The IBusModelProtTZTimeTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtTZTimeTypeTableObj getTZTimeTypeTableObj();

	/**
	 *	Get the TZTimestampCol interface for the schema.
	 *
	 *	@return	The IBusModelProtTZTimestampColTableObj interface implementation for the schema.
	 */
	IBusModelProtTZTimestampColTableObj getTZTimestampColTableObj();

	/**
	 *	Get the TZTimestampDef interface for the schema.
	 *
	 *	@return	The IBusModelProtTZTimestampDefTableObj interface implementation for the schema.
	 */
	IBusModelProtTZTimestampDefTableObj getTZTimestampDefTableObj();

	/**
	 *	Get the TZTimestampType interface for the schema.
	 *
	 *	@return	The IBusModelProtTZTimestampTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtTZTimestampTypeTableObj getTZTimestampTypeTableObj();

	/**
	 *	Get the Table interface for the schema.
	 *
	 *	@return	The IBusModelProtTableTableObj interface implementation for the schema.
	 */
	IBusModelProtTableTableObj getTableTableObj();

	/**
	 *	Get the TableCol interface for the schema.
	 *
	 *	@return	The IBusModelProtTableColTableObj interface implementation for the schema.
	 */
	IBusModelProtTableColTableObj getTableColTableObj();

	/**
	 *	Get the TableTweak interface for the schema.
	 *
	 *	@return	The IBusModelProtTableTweakTableObj interface implementation for the schema.
	 */
	IBusModelProtTableTweakTableObj getTableTweakTableObj();

	/**
	 *	Get the TextCol interface for the schema.
	 *
	 *	@return	The IBusModelProtTextColTableObj interface implementation for the schema.
	 */
	IBusModelProtTextColTableObj getTextColTableObj();

	/**
	 *	Get the TextDef interface for the schema.
	 *
	 *	@return	The IBusModelProtTextDefTableObj interface implementation for the schema.
	 */
	IBusModelProtTextDefTableObj getTextDefTableObj();

	/**
	 *	Get the TextType interface for the schema.
	 *
	 *	@return	The IBusModelProtTextTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtTextTypeTableObj getTextTypeTableObj();

	/**
	 *	Get the TimeCol interface for the schema.
	 *
	 *	@return	The IBusModelProtTimeColTableObj interface implementation for the schema.
	 */
	IBusModelProtTimeColTableObj getTimeColTableObj();

	/**
	 *	Get the TimeDef interface for the schema.
	 *
	 *	@return	The IBusModelProtTimeDefTableObj interface implementation for the schema.
	 */
	IBusModelProtTimeDefTableObj getTimeDefTableObj();

	/**
	 *	Get the TimeType interface for the schema.
	 *
	 *	@return	The IBusModelProtTimeTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtTimeTypeTableObj getTimeTypeTableObj();

	/**
	 *	Get the TimestampCol interface for the schema.
	 *
	 *	@return	The IBusModelProtTimestampColTableObj interface implementation for the schema.
	 */
	IBusModelProtTimestampColTableObj getTimestampColTableObj();

	/**
	 *	Get the TimestampDef interface for the schema.
	 *
	 *	@return	The IBusModelProtTimestampDefTableObj interface implementation for the schema.
	 */
	IBusModelProtTimestampDefTableObj getTimestampDefTableObj();

	/**
	 *	Get the TimestampType interface for the schema.
	 *
	 *	@return	The IBusModelProtTimestampTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtTimestampTypeTableObj getTimestampTypeTableObj();

	/**
	 *	Get the TokenCol interface for the schema.
	 *
	 *	@return	The IBusModelProtTokenColTableObj interface implementation for the schema.
	 */
	IBusModelProtTokenColTableObj getTokenColTableObj();

	/**
	 *	Get the TokenDef interface for the schema.
	 *
	 *	@return	The IBusModelProtTokenDefTableObj interface implementation for the schema.
	 */
	IBusModelProtTokenDefTableObj getTokenDefTableObj();

	/**
	 *	Get the TokenType interface for the schema.
	 *
	 *	@return	The IBusModelProtTokenTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtTokenTypeTableObj getTokenTypeTableObj();

	/**
	 *	Get the Tweak interface for the schema.
	 *
	 *	@return	The IBusModelProtTweakTableObj interface implementation for the schema.
	 */
	IBusModelProtTweakTableObj getTweakTableObj();

	/**
	 *	Get the UInt16Col interface for the schema.
	 *
	 *	@return	The IBusModelProtUInt16ColTableObj interface implementation for the schema.
	 */
	IBusModelProtUInt16ColTableObj getUInt16ColTableObj();

	/**
	 *	Get the UInt16Def interface for the schema.
	 *
	 *	@return	The IBusModelProtUInt16DefTableObj interface implementation for the schema.
	 */
	IBusModelProtUInt16DefTableObj getUInt16DefTableObj();

	/**
	 *	Get the UInt16Type interface for the schema.
	 *
	 *	@return	The IBusModelProtUInt16TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtUInt16TypeTableObj getUInt16TypeTableObj();

	/**
	 *	Get the UInt32Col interface for the schema.
	 *
	 *	@return	The IBusModelProtUInt32ColTableObj interface implementation for the schema.
	 */
	IBusModelProtUInt32ColTableObj getUInt32ColTableObj();

	/**
	 *	Get the UInt32Def interface for the schema.
	 *
	 *	@return	The IBusModelProtUInt32DefTableObj interface implementation for the schema.
	 */
	IBusModelProtUInt32DefTableObj getUInt32DefTableObj();

	/**
	 *	Get the UInt32Type interface for the schema.
	 *
	 *	@return	The IBusModelProtUInt32TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtUInt32TypeTableObj getUInt32TypeTableObj();

	/**
	 *	Get the UInt64Col interface for the schema.
	 *
	 *	@return	The IBusModelProtUInt64ColTableObj interface implementation for the schema.
	 */
	IBusModelProtUInt64ColTableObj getUInt64ColTableObj();

	/**
	 *	Get the UInt64Def interface for the schema.
	 *
	 *	@return	The IBusModelProtUInt64DefTableObj interface implementation for the schema.
	 */
	IBusModelProtUInt64DefTableObj getUInt64DefTableObj();

	/**
	 *	Get the UInt64Type interface for the schema.
	 *
	 *	@return	The IBusModelProtUInt64TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtUInt64TypeTableObj getUInt64TypeTableObj();

	/**
	 *	Get the Uuid6Col interface for the schema.
	 *
	 *	@return	The IBusModelProtUuid6ColTableObj interface implementation for the schema.
	 */
	IBusModelProtUuid6ColTableObj getUuid6ColTableObj();

	/**
	 *	Get the Uuid6Def interface for the schema.
	 *
	 *	@return	The IBusModelProtUuid6DefTableObj interface implementation for the schema.
	 */
	IBusModelProtUuid6DefTableObj getUuid6DefTableObj();

	/**
	 *	Get the Uuid6Gen interface for the schema.
	 *
	 *	@return	The IBusModelProtUuid6GenTableObj interface implementation for the schema.
	 */
	IBusModelProtUuid6GenTableObj getUuid6GenTableObj();

	/**
	 *	Get the Uuid6Type interface for the schema.
	 *
	 *	@return	The IBusModelProtUuid6TypeTableObj interface implementation for the schema.
	 */
	IBusModelProtUuid6TypeTableObj getUuid6TypeTableObj();

	/**
	 *	Get the UuidCol interface for the schema.
	 *
	 *	@return	The IBusModelProtUuidColTableObj interface implementation for the schema.
	 */
	IBusModelProtUuidColTableObj getUuidColTableObj();

	/**
	 *	Get the UuidDef interface for the schema.
	 *
	 *	@return	The IBusModelProtUuidDefTableObj interface implementation for the schema.
	 */
	IBusModelProtUuidDefTableObj getUuidDefTableObj();

	/**
	 *	Get the UuidGen interface for the schema.
	 *
	 *	@return	The IBusModelProtUuidGenTableObj interface implementation for the schema.
	 */
	IBusModelProtUuidGenTableObj getUuidGenTableObj();

	/**
	 *	Get the UuidType interface for the schema.
	 *
	 *	@return	The IBusModelProtUuidTypeTableObj interface implementation for the schema.
	 */
	IBusModelProtUuidTypeTableObj getUuidTypeTableObj();

	/**
	 *	Get the Value interface for the schema.
	 *
	 *	@return	The IBusModelProtValueTableObj interface implementation for the schema.
	 */
	IBusModelProtValueTableObj getValueTableObj();
}
