// Description: Java 25 Public Schema Object interface for CFBamPub.

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
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
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbampubobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;

import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;

public interface ICFBamPubSchemaObj
	extends ICFSecPubSchemaObj,
		ICFIntPubSchemaObj
{
	public ICFSecPubSchema getCFSecPubBackingStore();
	public void setCFSecPubBackingStore(ICFSecPubSchema cfsecpubBackingStore);

	public ICFIntPubSchema getCFIntPubBackingStore();
	public void setCFIntPubBackingStore(ICFIntPubSchema cfintpubBackingStore);

	public ICFBamPubSchema getCFBamPubBackingStore();
	public void setCFBamPubBackingStore(ICFBamPubSchema cfbampubBackingStore);

	/**
	 *	Get the Atom interface for the schema.
	 *
	 *	@return	The ICFBamPubAtomTableObj interface implementation for the schema.
	 */
	ICFBamPubAtomTableObj getAtomTableObj();

	/**
	 *	Get the BlobCol interface for the schema.
	 *
	 *	@return	The ICFBamPubBlobColTableObj interface implementation for the schema.
	 */
	ICFBamPubBlobColTableObj getBlobColTableObj();

	/**
	 *	Get the BlobDef interface for the schema.
	 *
	 *	@return	The ICFBamPubBlobDefTableObj interface implementation for the schema.
	 */
	ICFBamPubBlobDefTableObj getBlobDefTableObj();

	/**
	 *	Get the BlobType interface for the schema.
	 *
	 *	@return	The ICFBamPubBlobTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubBlobTypeTableObj getBlobTypeTableObj();

	/**
	 *	Get the BoolCol interface for the schema.
	 *
	 *	@return	The ICFBamPubBoolColTableObj interface implementation for the schema.
	 */
	ICFBamPubBoolColTableObj getBoolColTableObj();

	/**
	 *	Get the BoolDef interface for the schema.
	 *
	 *	@return	The ICFBamPubBoolDefTableObj interface implementation for the schema.
	 */
	ICFBamPubBoolDefTableObj getBoolDefTableObj();

	/**
	 *	Get the BoolType interface for the schema.
	 *
	 *	@return	The ICFBamPubBoolTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubBoolTypeTableObj getBoolTypeTableObj();

	/**
	 *	Get the Chain interface for the schema.
	 *
	 *	@return	The ICFBamPubChainTableObj interface implementation for the schema.
	 */
	ICFBamPubChainTableObj getChainTableObj();

	/**
	 *	Get the ClearDep interface for the schema.
	 *
	 *	@return	The ICFBamPubClearDepTableObj interface implementation for the schema.
	 */
	ICFBamPubClearDepTableObj getClearDepTableObj();

	/**
	 *	Get the ClearSubDep1 interface for the schema.
	 *
	 *	@return	The ICFBamPubClearSubDep1TableObj interface implementation for the schema.
	 */
	ICFBamPubClearSubDep1TableObj getClearSubDep1TableObj();

	/**
	 *	Get the ClearSubDep2 interface for the schema.
	 *
	 *	@return	The ICFBamPubClearSubDep2TableObj interface implementation for the schema.
	 */
	ICFBamPubClearSubDep2TableObj getClearSubDep2TableObj();

	/**
	 *	Get the ClearSubDep3 interface for the schema.
	 *
	 *	@return	The ICFBamPubClearSubDep3TableObj interface implementation for the schema.
	 */
	ICFBamPubClearSubDep3TableObj getClearSubDep3TableObj();

	/**
	 *	Get the ClearTopDep interface for the schema.
	 *
	 *	@return	The ICFBamPubClearTopDepTableObj interface implementation for the schema.
	 */
	ICFBamPubClearTopDepTableObj getClearTopDepTableObj();

	/**
	 *	Get the DateCol interface for the schema.
	 *
	 *	@return	The ICFBamPubDateColTableObj interface implementation for the schema.
	 */
	ICFBamPubDateColTableObj getDateColTableObj();

	/**
	 *	Get the DateDef interface for the schema.
	 *
	 *	@return	The ICFBamPubDateDefTableObj interface implementation for the schema.
	 */
	ICFBamPubDateDefTableObj getDateDefTableObj();

	/**
	 *	Get the DateType interface for the schema.
	 *
	 *	@return	The ICFBamPubDateTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubDateTypeTableObj getDateTypeTableObj();

	/**
	 *	Get the DbKeyHash128Col interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash128ColTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash128ColTableObj getDbKeyHash128ColTableObj();

	/**
	 *	Get the DbKeyHash128Def interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash128DefTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash128DefTableObj getDbKeyHash128DefTableObj();

	/**
	 *	Get the DbKeyHash128Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash128GenTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash128GenTableObj getDbKeyHash128GenTableObj();

	/**
	 *	Get the DbKeyHash128Type interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash128TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash128TypeTableObj getDbKeyHash128TypeTableObj();

	/**
	 *	Get the DbKeyHash160Col interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash160ColTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash160ColTableObj getDbKeyHash160ColTableObj();

	/**
	 *	Get the DbKeyHash160Def interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash160DefTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash160DefTableObj getDbKeyHash160DefTableObj();

	/**
	 *	Get the DbKeyHash160Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash160GenTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash160GenTableObj getDbKeyHash160GenTableObj();

	/**
	 *	Get the DbKeyHash160Type interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash160TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash160TypeTableObj getDbKeyHash160TypeTableObj();

	/**
	 *	Get the DbKeyHash224Col interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash224ColTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash224ColTableObj getDbKeyHash224ColTableObj();

	/**
	 *	Get the DbKeyHash224Def interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash224DefTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash224DefTableObj getDbKeyHash224DefTableObj();

	/**
	 *	Get the DbKeyHash224Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash224GenTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash224GenTableObj getDbKeyHash224GenTableObj();

	/**
	 *	Get the DbKeyHash224Type interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash224TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash224TypeTableObj getDbKeyHash224TypeTableObj();

	/**
	 *	Get the DbKeyHash256Col interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash256ColTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash256ColTableObj getDbKeyHash256ColTableObj();

	/**
	 *	Get the DbKeyHash256Def interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash256DefTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash256DefTableObj getDbKeyHash256DefTableObj();

	/**
	 *	Get the DbKeyHash256Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash256GenTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash256GenTableObj getDbKeyHash256GenTableObj();

	/**
	 *	Get the DbKeyHash256Type interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash256TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash256TypeTableObj getDbKeyHash256TypeTableObj();

	/**
	 *	Get the DbKeyHash384Col interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash384ColTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash384ColTableObj getDbKeyHash384ColTableObj();

	/**
	 *	Get the DbKeyHash384Def interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash384DefTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash384DefTableObj getDbKeyHash384DefTableObj();

	/**
	 *	Get the DbKeyHash384Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash384GenTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash384GenTableObj getDbKeyHash384GenTableObj();

	/**
	 *	Get the DbKeyHash384Type interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash384TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash384TypeTableObj getDbKeyHash384TypeTableObj();

	/**
	 *	Get the DbKeyHash512Col interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash512ColTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash512ColTableObj getDbKeyHash512ColTableObj();

	/**
	 *	Get the DbKeyHash512Def interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash512DefTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash512DefTableObj getDbKeyHash512DefTableObj();

	/**
	 *	Get the DbKeyHash512Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash512GenTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash512GenTableObj getDbKeyHash512GenTableObj();

	/**
	 *	Get the DbKeyHash512Type interface for the schema.
	 *
	 *	@return	The ICFBamPubDbKeyHash512TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubDbKeyHash512TypeTableObj getDbKeyHash512TypeTableObj();

	/**
	 *	Get the DelDep interface for the schema.
	 *
	 *	@return	The ICFBamPubDelDepTableObj interface implementation for the schema.
	 */
	ICFBamPubDelDepTableObj getDelDepTableObj();

	/**
	 *	Get the DelSubDep1 interface for the schema.
	 *
	 *	@return	The ICFBamPubDelSubDep1TableObj interface implementation for the schema.
	 */
	ICFBamPubDelSubDep1TableObj getDelSubDep1TableObj();

	/**
	 *	Get the DelSubDep2 interface for the schema.
	 *
	 *	@return	The ICFBamPubDelSubDep2TableObj interface implementation for the schema.
	 */
	ICFBamPubDelSubDep2TableObj getDelSubDep2TableObj();

	/**
	 *	Get the DelSubDep3 interface for the schema.
	 *
	 *	@return	The ICFBamPubDelSubDep3TableObj interface implementation for the schema.
	 */
	ICFBamPubDelSubDep3TableObj getDelSubDep3TableObj();

	/**
	 *	Get the DelTopDep interface for the schema.
	 *
	 *	@return	The ICFBamPubDelTopDepTableObj interface implementation for the schema.
	 */
	ICFBamPubDelTopDepTableObj getDelTopDepTableObj();

	/**
	 *	Get the DoubleCol interface for the schema.
	 *
	 *	@return	The ICFBamPubDoubleColTableObj interface implementation for the schema.
	 */
	ICFBamPubDoubleColTableObj getDoubleColTableObj();

	/**
	 *	Get the DoubleDef interface for the schema.
	 *
	 *	@return	The ICFBamPubDoubleDefTableObj interface implementation for the schema.
	 */
	ICFBamPubDoubleDefTableObj getDoubleDefTableObj();

	/**
	 *	Get the DoubleType interface for the schema.
	 *
	 *	@return	The ICFBamPubDoubleTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubDoubleTypeTableObj getDoubleTypeTableObj();

	/**
	 *	Get the EnumDef interface for the schema.
	 *
	 *	@return	The ICFBamPubEnumDefTableObj interface implementation for the schema.
	 */
	ICFBamPubEnumDefTableObj getEnumDefTableObj();

	/**
	 *	Get the EnumTag interface for the schema.
	 *
	 *	@return	The ICFBamPubEnumTagTableObj interface implementation for the schema.
	 */
	ICFBamPubEnumTagTableObj getEnumTagTableObj();

	/**
	 *	Get the EnumType interface for the schema.
	 *
	 *	@return	The ICFBamPubEnumTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubEnumTypeTableObj getEnumTypeTableObj();

	/**
	 *	Get the FloatCol interface for the schema.
	 *
	 *	@return	The ICFBamPubFloatColTableObj interface implementation for the schema.
	 */
	ICFBamPubFloatColTableObj getFloatColTableObj();

	/**
	 *	Get the FloatDef interface for the schema.
	 *
	 *	@return	The ICFBamPubFloatDefTableObj interface implementation for the schema.
	 */
	ICFBamPubFloatDefTableObj getFloatDefTableObj();

	/**
	 *	Get the FloatType interface for the schema.
	 *
	 *	@return	The ICFBamPubFloatTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubFloatTypeTableObj getFloatTypeTableObj();

	/**
	 *	Get the Id16Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubId16GenTableObj interface implementation for the schema.
	 */
	ICFBamPubId16GenTableObj getId16GenTableObj();

	/**
	 *	Get the Id32Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubId32GenTableObj interface implementation for the schema.
	 */
	ICFBamPubId32GenTableObj getId32GenTableObj();

	/**
	 *	Get the Id64Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubId64GenTableObj interface implementation for the schema.
	 */
	ICFBamPubId64GenTableObj getId64GenTableObj();

	/**
	 *	Get the Index interface for the schema.
	 *
	 *	@return	The ICFBamPubIndexTableObj interface implementation for the schema.
	 */
	ICFBamPubIndexTableObj getIndexTableObj();

	/**
	 *	Get the IndexCol interface for the schema.
	 *
	 *	@return	The ICFBamPubIndexColTableObj interface implementation for the schema.
	 */
	ICFBamPubIndexColTableObj getIndexColTableObj();

	/**
	 *	Get the IndexTweak interface for the schema.
	 *
	 *	@return	The ICFBamPubIndexTweakTableObj interface implementation for the schema.
	 */
	ICFBamPubIndexTweakTableObj getIndexTweakTableObj();

	/**
	 *	Get the Int16Col interface for the schema.
	 *
	 *	@return	The ICFBamPubInt16ColTableObj interface implementation for the schema.
	 */
	ICFBamPubInt16ColTableObj getInt16ColTableObj();

	/**
	 *	Get the Int16Def interface for the schema.
	 *
	 *	@return	The ICFBamPubInt16DefTableObj interface implementation for the schema.
	 */
	ICFBamPubInt16DefTableObj getInt16DefTableObj();

	/**
	 *	Get the Int16Type interface for the schema.
	 *
	 *	@return	The ICFBamPubInt16TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubInt16TypeTableObj getInt16TypeTableObj();

	/**
	 *	Get the Int32Col interface for the schema.
	 *
	 *	@return	The ICFBamPubInt32ColTableObj interface implementation for the schema.
	 */
	ICFBamPubInt32ColTableObj getInt32ColTableObj();

	/**
	 *	Get the Int32Def interface for the schema.
	 *
	 *	@return	The ICFBamPubInt32DefTableObj interface implementation for the schema.
	 */
	ICFBamPubInt32DefTableObj getInt32DefTableObj();

	/**
	 *	Get the Int32Type interface for the schema.
	 *
	 *	@return	The ICFBamPubInt32TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubInt32TypeTableObj getInt32TypeTableObj();

	/**
	 *	Get the Int64Col interface for the schema.
	 *
	 *	@return	The ICFBamPubInt64ColTableObj interface implementation for the schema.
	 */
	ICFBamPubInt64ColTableObj getInt64ColTableObj();

	/**
	 *	Get the Int64Def interface for the schema.
	 *
	 *	@return	The ICFBamPubInt64DefTableObj interface implementation for the schema.
	 */
	ICFBamPubInt64DefTableObj getInt64DefTableObj();

	/**
	 *	Get the Int64Type interface for the schema.
	 *
	 *	@return	The ICFBamPubInt64TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubInt64TypeTableObj getInt64TypeTableObj();

	/**
	 *	Get the NmTokenCol interface for the schema.
	 *
	 *	@return	The ICFBamPubNmTokenColTableObj interface implementation for the schema.
	 */
	ICFBamPubNmTokenColTableObj getNmTokenColTableObj();

	/**
	 *	Get the NmTokenDef interface for the schema.
	 *
	 *	@return	The ICFBamPubNmTokenDefTableObj interface implementation for the schema.
	 */
	ICFBamPubNmTokenDefTableObj getNmTokenDefTableObj();

	/**
	 *	Get the NmTokenType interface for the schema.
	 *
	 *	@return	The ICFBamPubNmTokenTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubNmTokenTypeTableObj getNmTokenTypeTableObj();

	/**
	 *	Get the NmTokensCol interface for the schema.
	 *
	 *	@return	The ICFBamPubNmTokensColTableObj interface implementation for the schema.
	 */
	ICFBamPubNmTokensColTableObj getNmTokensColTableObj();

	/**
	 *	Get the NmTokensDef interface for the schema.
	 *
	 *	@return	The ICFBamPubNmTokensDefTableObj interface implementation for the schema.
	 */
	ICFBamPubNmTokensDefTableObj getNmTokensDefTableObj();

	/**
	 *	Get the NmTokensType interface for the schema.
	 *
	 *	@return	The ICFBamPubNmTokensTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubNmTokensTypeTableObj getNmTokensTypeTableObj();

	/**
	 *	Get the NumberCol interface for the schema.
	 *
	 *	@return	The ICFBamPubNumberColTableObj interface implementation for the schema.
	 */
	ICFBamPubNumberColTableObj getNumberColTableObj();

	/**
	 *	Get the NumberDef interface for the schema.
	 *
	 *	@return	The ICFBamPubNumberDefTableObj interface implementation for the schema.
	 */
	ICFBamPubNumberDefTableObj getNumberDefTableObj();

	/**
	 *	Get the NumberType interface for the schema.
	 *
	 *	@return	The ICFBamPubNumberTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubNumberTypeTableObj getNumberTypeTableObj();

	/**
	 *	Get the Param interface for the schema.
	 *
	 *	@return	The ICFBamPubParamTableObj interface implementation for the schema.
	 */
	ICFBamPubParamTableObj getParamTableObj();

	/**
	 *	Get the PopDep interface for the schema.
	 *
	 *	@return	The ICFBamPubPopDepTableObj interface implementation for the schema.
	 */
	ICFBamPubPopDepTableObj getPopDepTableObj();

	/**
	 *	Get the PopSubDep1 interface for the schema.
	 *
	 *	@return	The ICFBamPubPopSubDep1TableObj interface implementation for the schema.
	 */
	ICFBamPubPopSubDep1TableObj getPopSubDep1TableObj();

	/**
	 *	Get the PopSubDep2 interface for the schema.
	 *
	 *	@return	The ICFBamPubPopSubDep2TableObj interface implementation for the schema.
	 */
	ICFBamPubPopSubDep2TableObj getPopSubDep2TableObj();

	/**
	 *	Get the PopSubDep3 interface for the schema.
	 *
	 *	@return	The ICFBamPubPopSubDep3TableObj interface implementation for the schema.
	 */
	ICFBamPubPopSubDep3TableObj getPopSubDep3TableObj();

	/**
	 *	Get the PopTopDep interface for the schema.
	 *
	 *	@return	The ICFBamPubPopTopDepTableObj interface implementation for the schema.
	 */
	ICFBamPubPopTopDepTableObj getPopTopDepTableObj();

	/**
	 *	Get the Relation interface for the schema.
	 *
	 *	@return	The ICFBamPubRelationTableObj interface implementation for the schema.
	 */
	ICFBamPubRelationTableObj getRelationTableObj();

	/**
	 *	Get the RelationCol interface for the schema.
	 *
	 *	@return	The ICFBamPubRelationColTableObj interface implementation for the schema.
	 */
	ICFBamPubRelationColTableObj getRelationColTableObj();

	/**
	 *	Get the RoleDef interface for the schema.
	 *
	 *	@return	The ICFBamPubRoleDefTableObj interface implementation for the schema.
	 */
	ICFBamPubRoleDefTableObj getRoleDefTableObj();

	/**
	 *	Get the SchemaDef interface for the schema.
	 *
	 *	@return	The ICFBamPubSchemaDefTableObj interface implementation for the schema.
	 */
	ICFBamPubSchemaDefTableObj getSchemaDefTableObj();

	/**
	 *	Get the SchemaRef interface for the schema.
	 *
	 *	@return	The ICFBamPubSchemaRefTableObj interface implementation for the schema.
	 */
	ICFBamPubSchemaRefTableObj getSchemaRefTableObj();

	/**
	 *	Get the SchemaRole interface for the schema.
	 *
	 *	@return	The ICFBamPubSchemaRoleTableObj interface implementation for the schema.
	 */
	ICFBamPubSchemaRoleTableObj getSchemaRoleTableObj();

	/**
	 *	Get the SchemaTweak interface for the schema.
	 *
	 *	@return	The ICFBamPubSchemaTweakTableObj interface implementation for the schema.
	 */
	ICFBamPubSchemaTweakTableObj getSchemaTweakTableObj();

	/**
	 *	Get the Scope interface for the schema.
	 *
	 *	@return	The ICFBamPubScopeTableObj interface implementation for the schema.
	 */
	ICFBamPubScopeTableObj getScopeTableObj();

	/**
	 *	Get the ServerListFunc interface for the schema.
	 *
	 *	@return	The ICFBamPubServerListFuncTableObj interface implementation for the schema.
	 */
	ICFBamPubServerListFuncTableObj getServerListFuncTableObj();

	/**
	 *	Get the ServerMethod interface for the schema.
	 *
	 *	@return	The ICFBamPubServerMethodTableObj interface implementation for the schema.
	 */
	ICFBamPubServerMethodTableObj getServerMethodTableObj();

	/**
	 *	Get the ServerObjFunc interface for the schema.
	 *
	 *	@return	The ICFBamPubServerObjFuncTableObj interface implementation for the schema.
	 */
	ICFBamPubServerObjFuncTableObj getServerObjFuncTableObj();

	/**
	 *	Get the ServerProc interface for the schema.
	 *
	 *	@return	The ICFBamPubServerProcTableObj interface implementation for the schema.
	 */
	ICFBamPubServerProcTableObj getServerProcTableObj();

	/**
	 *	Get the StringCol interface for the schema.
	 *
	 *	@return	The ICFBamPubStringColTableObj interface implementation for the schema.
	 */
	ICFBamPubStringColTableObj getStringColTableObj();

	/**
	 *	Get the StringDef interface for the schema.
	 *
	 *	@return	The ICFBamPubStringDefTableObj interface implementation for the schema.
	 */
	ICFBamPubStringDefTableObj getStringDefTableObj();

	/**
	 *	Get the StringType interface for the schema.
	 *
	 *	@return	The ICFBamPubStringTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubStringTypeTableObj getStringTypeTableObj();

	/**
	 *	Get the TZDateCol interface for the schema.
	 *
	 *	@return	The ICFBamPubTZDateColTableObj interface implementation for the schema.
	 */
	ICFBamPubTZDateColTableObj getTZDateColTableObj();

	/**
	 *	Get the TZDateDef interface for the schema.
	 *
	 *	@return	The ICFBamPubTZDateDefTableObj interface implementation for the schema.
	 */
	ICFBamPubTZDateDefTableObj getTZDateDefTableObj();

	/**
	 *	Get the TZDateType interface for the schema.
	 *
	 *	@return	The ICFBamPubTZDateTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubTZDateTypeTableObj getTZDateTypeTableObj();

	/**
	 *	Get the TZTimeCol interface for the schema.
	 *
	 *	@return	The ICFBamPubTZTimeColTableObj interface implementation for the schema.
	 */
	ICFBamPubTZTimeColTableObj getTZTimeColTableObj();

	/**
	 *	Get the TZTimeDef interface for the schema.
	 *
	 *	@return	The ICFBamPubTZTimeDefTableObj interface implementation for the schema.
	 */
	ICFBamPubTZTimeDefTableObj getTZTimeDefTableObj();

	/**
	 *	Get the TZTimeType interface for the schema.
	 *
	 *	@return	The ICFBamPubTZTimeTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubTZTimeTypeTableObj getTZTimeTypeTableObj();

	/**
	 *	Get the TZTimestampCol interface for the schema.
	 *
	 *	@return	The ICFBamPubTZTimestampColTableObj interface implementation for the schema.
	 */
	ICFBamPubTZTimestampColTableObj getTZTimestampColTableObj();

	/**
	 *	Get the TZTimestampDef interface for the schema.
	 *
	 *	@return	The ICFBamPubTZTimestampDefTableObj interface implementation for the schema.
	 */
	ICFBamPubTZTimestampDefTableObj getTZTimestampDefTableObj();

	/**
	 *	Get the TZTimestampType interface for the schema.
	 *
	 *	@return	The ICFBamPubTZTimestampTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubTZTimestampTypeTableObj getTZTimestampTypeTableObj();

	/**
	 *	Get the Table interface for the schema.
	 *
	 *	@return	The ICFBamPubTableTableObj interface implementation for the schema.
	 */
	ICFBamPubTableTableObj getTableTableObj();

	/**
	 *	Get the TableCol interface for the schema.
	 *
	 *	@return	The ICFBamPubTableColTableObj interface implementation for the schema.
	 */
	ICFBamPubTableColTableObj getTableColTableObj();

	/**
	 *	Get the TableTweak interface for the schema.
	 *
	 *	@return	The ICFBamPubTableTweakTableObj interface implementation for the schema.
	 */
	ICFBamPubTableTweakTableObj getTableTweakTableObj();

	/**
	 *	Get the TextCol interface for the schema.
	 *
	 *	@return	The ICFBamPubTextColTableObj interface implementation for the schema.
	 */
	ICFBamPubTextColTableObj getTextColTableObj();

	/**
	 *	Get the TextDef interface for the schema.
	 *
	 *	@return	The ICFBamPubTextDefTableObj interface implementation for the schema.
	 */
	ICFBamPubTextDefTableObj getTextDefTableObj();

	/**
	 *	Get the TextType interface for the schema.
	 *
	 *	@return	The ICFBamPubTextTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubTextTypeTableObj getTextTypeTableObj();

	/**
	 *	Get the TimeCol interface for the schema.
	 *
	 *	@return	The ICFBamPubTimeColTableObj interface implementation for the schema.
	 */
	ICFBamPubTimeColTableObj getTimeColTableObj();

	/**
	 *	Get the TimeDef interface for the schema.
	 *
	 *	@return	The ICFBamPubTimeDefTableObj interface implementation for the schema.
	 */
	ICFBamPubTimeDefTableObj getTimeDefTableObj();

	/**
	 *	Get the TimeType interface for the schema.
	 *
	 *	@return	The ICFBamPubTimeTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubTimeTypeTableObj getTimeTypeTableObj();

	/**
	 *	Get the TimestampCol interface for the schema.
	 *
	 *	@return	The ICFBamPubTimestampColTableObj interface implementation for the schema.
	 */
	ICFBamPubTimestampColTableObj getTimestampColTableObj();

	/**
	 *	Get the TimestampDef interface for the schema.
	 *
	 *	@return	The ICFBamPubTimestampDefTableObj interface implementation for the schema.
	 */
	ICFBamPubTimestampDefTableObj getTimestampDefTableObj();

	/**
	 *	Get the TimestampType interface for the schema.
	 *
	 *	@return	The ICFBamPubTimestampTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubTimestampTypeTableObj getTimestampTypeTableObj();

	/**
	 *	Get the TokenCol interface for the schema.
	 *
	 *	@return	The ICFBamPubTokenColTableObj interface implementation for the schema.
	 */
	ICFBamPubTokenColTableObj getTokenColTableObj();

	/**
	 *	Get the TokenDef interface for the schema.
	 *
	 *	@return	The ICFBamPubTokenDefTableObj interface implementation for the schema.
	 */
	ICFBamPubTokenDefTableObj getTokenDefTableObj();

	/**
	 *	Get the TokenType interface for the schema.
	 *
	 *	@return	The ICFBamPubTokenTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubTokenTypeTableObj getTokenTypeTableObj();

	/**
	 *	Get the Tweak interface for the schema.
	 *
	 *	@return	The ICFBamPubTweakTableObj interface implementation for the schema.
	 */
	ICFBamPubTweakTableObj getTweakTableObj();

	/**
	 *	Get the UInt16Col interface for the schema.
	 *
	 *	@return	The ICFBamPubUInt16ColTableObj interface implementation for the schema.
	 */
	ICFBamPubUInt16ColTableObj getUInt16ColTableObj();

	/**
	 *	Get the UInt16Def interface for the schema.
	 *
	 *	@return	The ICFBamPubUInt16DefTableObj interface implementation for the schema.
	 */
	ICFBamPubUInt16DefTableObj getUInt16DefTableObj();

	/**
	 *	Get the UInt16Type interface for the schema.
	 *
	 *	@return	The ICFBamPubUInt16TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubUInt16TypeTableObj getUInt16TypeTableObj();

	/**
	 *	Get the UInt32Col interface for the schema.
	 *
	 *	@return	The ICFBamPubUInt32ColTableObj interface implementation for the schema.
	 */
	ICFBamPubUInt32ColTableObj getUInt32ColTableObj();

	/**
	 *	Get the UInt32Def interface for the schema.
	 *
	 *	@return	The ICFBamPubUInt32DefTableObj interface implementation for the schema.
	 */
	ICFBamPubUInt32DefTableObj getUInt32DefTableObj();

	/**
	 *	Get the UInt32Type interface for the schema.
	 *
	 *	@return	The ICFBamPubUInt32TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubUInt32TypeTableObj getUInt32TypeTableObj();

	/**
	 *	Get the UInt64Col interface for the schema.
	 *
	 *	@return	The ICFBamPubUInt64ColTableObj interface implementation for the schema.
	 */
	ICFBamPubUInt64ColTableObj getUInt64ColTableObj();

	/**
	 *	Get the UInt64Def interface for the schema.
	 *
	 *	@return	The ICFBamPubUInt64DefTableObj interface implementation for the schema.
	 */
	ICFBamPubUInt64DefTableObj getUInt64DefTableObj();

	/**
	 *	Get the UInt64Type interface for the schema.
	 *
	 *	@return	The ICFBamPubUInt64TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubUInt64TypeTableObj getUInt64TypeTableObj();

	/**
	 *	Get the Uuid6Col interface for the schema.
	 *
	 *	@return	The ICFBamPubUuid6ColTableObj interface implementation for the schema.
	 */
	ICFBamPubUuid6ColTableObj getUuid6ColTableObj();

	/**
	 *	Get the Uuid6Def interface for the schema.
	 *
	 *	@return	The ICFBamPubUuid6DefTableObj interface implementation for the schema.
	 */
	ICFBamPubUuid6DefTableObj getUuid6DefTableObj();

	/**
	 *	Get the Uuid6Gen interface for the schema.
	 *
	 *	@return	The ICFBamPubUuid6GenTableObj interface implementation for the schema.
	 */
	ICFBamPubUuid6GenTableObj getUuid6GenTableObj();

	/**
	 *	Get the Uuid6Type interface for the schema.
	 *
	 *	@return	The ICFBamPubUuid6TypeTableObj interface implementation for the schema.
	 */
	ICFBamPubUuid6TypeTableObj getUuid6TypeTableObj();

	/**
	 *	Get the UuidCol interface for the schema.
	 *
	 *	@return	The ICFBamPubUuidColTableObj interface implementation for the schema.
	 */
	ICFBamPubUuidColTableObj getUuidColTableObj();

	/**
	 *	Get the UuidDef interface for the schema.
	 *
	 *	@return	The ICFBamPubUuidDefTableObj interface implementation for the schema.
	 */
	ICFBamPubUuidDefTableObj getUuidDefTableObj();

	/**
	 *	Get the UuidGen interface for the schema.
	 *
	 *	@return	The ICFBamPubUuidGenTableObj interface implementation for the schema.
	 */
	ICFBamPubUuidGenTableObj getUuidGenTableObj();

	/**
	 *	Get the UuidType interface for the schema.
	 *
	 *	@return	The ICFBamPubUuidTypeTableObj interface implementation for the schema.
	 */
	ICFBamPubUuidTypeTableObj getUuidTypeTableObj();

	/**
	 *	Get the Value interface for the schema.
	 *
	 *	@return	The ICFBamPubValueTableObj interface implementation for the schema.
	 */
	ICFBamPubValueTableObj getValueTableObj();
}
