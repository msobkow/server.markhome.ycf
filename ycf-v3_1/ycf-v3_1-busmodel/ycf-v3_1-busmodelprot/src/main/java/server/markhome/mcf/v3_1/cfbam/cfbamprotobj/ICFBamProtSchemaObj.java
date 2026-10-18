// Description: Java 25 Protected Schema Object interface for CFBamProt.

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

package server.markhome.mcf.v3_1.cfbam.cfbamprotobj;

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
import server.markhome.mcf.v3_1.cfbam.cfbamprot.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;

public interface ICFBamProtSchemaObj
	extends ICFSecPubSchemaObj,
		ICFIntPubSchemaObj
{
	public ICFSecPubSchema getCFSecProtBackingStore();
	public void setCFSecProtBackingStore(ICFSecPubSchema cfsecprotBackingStore);

	public ICFIntPubSchema getCFIntProtBackingStore();
	public void setCFIntProtBackingStore(ICFIntPubSchema cfintprotBackingStore);

	public ICFBamProtSchema getCFBamProtBackingStore();
	public void setCFBamProtBackingStore(ICFBamProtSchema cfbamprotBackingStore);

	/**
	 *	Get the Atom interface for the schema.
	 *
	 *	@return	The ICFBamProtAtomTableObj interface implementation for the schema.
	 */
	ICFBamProtAtomTableObj getAtomTableObj();

	/**
	 *	Get the BlobCol interface for the schema.
	 *
	 *	@return	The ICFBamProtBlobColTableObj interface implementation for the schema.
	 */
	ICFBamProtBlobColTableObj getBlobColTableObj();

	/**
	 *	Get the BlobDef interface for the schema.
	 *
	 *	@return	The ICFBamProtBlobDefTableObj interface implementation for the schema.
	 */
	ICFBamProtBlobDefTableObj getBlobDefTableObj();

	/**
	 *	Get the BlobType interface for the schema.
	 *
	 *	@return	The ICFBamProtBlobTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtBlobTypeTableObj getBlobTypeTableObj();

	/**
	 *	Get the BoolCol interface for the schema.
	 *
	 *	@return	The ICFBamProtBoolColTableObj interface implementation for the schema.
	 */
	ICFBamProtBoolColTableObj getBoolColTableObj();

	/**
	 *	Get the BoolDef interface for the schema.
	 *
	 *	@return	The ICFBamProtBoolDefTableObj interface implementation for the schema.
	 */
	ICFBamProtBoolDefTableObj getBoolDefTableObj();

	/**
	 *	Get the BoolType interface for the schema.
	 *
	 *	@return	The ICFBamProtBoolTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtBoolTypeTableObj getBoolTypeTableObj();

	/**
	 *	Get the Chain interface for the schema.
	 *
	 *	@return	The ICFBamProtChainTableObj interface implementation for the schema.
	 */
	ICFBamProtChainTableObj getChainTableObj();

	/**
	 *	Get the ClearDep interface for the schema.
	 *
	 *	@return	The ICFBamProtClearDepTableObj interface implementation for the schema.
	 */
	ICFBamProtClearDepTableObj getClearDepTableObj();

	/**
	 *	Get the ClearSubDep1 interface for the schema.
	 *
	 *	@return	The ICFBamProtClearSubDep1TableObj interface implementation for the schema.
	 */
	ICFBamProtClearSubDep1TableObj getClearSubDep1TableObj();

	/**
	 *	Get the ClearSubDep2 interface for the schema.
	 *
	 *	@return	The ICFBamProtClearSubDep2TableObj interface implementation for the schema.
	 */
	ICFBamProtClearSubDep2TableObj getClearSubDep2TableObj();

	/**
	 *	Get the ClearSubDep3 interface for the schema.
	 *
	 *	@return	The ICFBamProtClearSubDep3TableObj interface implementation for the schema.
	 */
	ICFBamProtClearSubDep3TableObj getClearSubDep3TableObj();

	/**
	 *	Get the ClearTopDep interface for the schema.
	 *
	 *	@return	The ICFBamProtClearTopDepTableObj interface implementation for the schema.
	 */
	ICFBamProtClearTopDepTableObj getClearTopDepTableObj();

	/**
	 *	Get the DateCol interface for the schema.
	 *
	 *	@return	The ICFBamProtDateColTableObj interface implementation for the schema.
	 */
	ICFBamProtDateColTableObj getDateColTableObj();

	/**
	 *	Get the DateDef interface for the schema.
	 *
	 *	@return	The ICFBamProtDateDefTableObj interface implementation for the schema.
	 */
	ICFBamProtDateDefTableObj getDateDefTableObj();

	/**
	 *	Get the DateType interface for the schema.
	 *
	 *	@return	The ICFBamProtDateTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtDateTypeTableObj getDateTypeTableObj();

	/**
	 *	Get the DbKeyHash128Col interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash128ColTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash128ColTableObj getDbKeyHash128ColTableObj();

	/**
	 *	Get the DbKeyHash128Def interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash128DefTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash128DefTableObj getDbKeyHash128DefTableObj();

	/**
	 *	Get the DbKeyHash128Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash128GenTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash128GenTableObj getDbKeyHash128GenTableObj();

	/**
	 *	Get the DbKeyHash128Type interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash128TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash128TypeTableObj getDbKeyHash128TypeTableObj();

	/**
	 *	Get the DbKeyHash160Col interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash160ColTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash160ColTableObj getDbKeyHash160ColTableObj();

	/**
	 *	Get the DbKeyHash160Def interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash160DefTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash160DefTableObj getDbKeyHash160DefTableObj();

	/**
	 *	Get the DbKeyHash160Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash160GenTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash160GenTableObj getDbKeyHash160GenTableObj();

	/**
	 *	Get the DbKeyHash160Type interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash160TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash160TypeTableObj getDbKeyHash160TypeTableObj();

	/**
	 *	Get the DbKeyHash224Col interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash224ColTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash224ColTableObj getDbKeyHash224ColTableObj();

	/**
	 *	Get the DbKeyHash224Def interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash224DefTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash224DefTableObj getDbKeyHash224DefTableObj();

	/**
	 *	Get the DbKeyHash224Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash224GenTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash224GenTableObj getDbKeyHash224GenTableObj();

	/**
	 *	Get the DbKeyHash224Type interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash224TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash224TypeTableObj getDbKeyHash224TypeTableObj();

	/**
	 *	Get the DbKeyHash256Col interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash256ColTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash256ColTableObj getDbKeyHash256ColTableObj();

	/**
	 *	Get the DbKeyHash256Def interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash256DefTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash256DefTableObj getDbKeyHash256DefTableObj();

	/**
	 *	Get the DbKeyHash256Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash256GenTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash256GenTableObj getDbKeyHash256GenTableObj();

	/**
	 *	Get the DbKeyHash256Type interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash256TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash256TypeTableObj getDbKeyHash256TypeTableObj();

	/**
	 *	Get the DbKeyHash384Col interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash384ColTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash384ColTableObj getDbKeyHash384ColTableObj();

	/**
	 *	Get the DbKeyHash384Def interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash384DefTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash384DefTableObj getDbKeyHash384DefTableObj();

	/**
	 *	Get the DbKeyHash384Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash384GenTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash384GenTableObj getDbKeyHash384GenTableObj();

	/**
	 *	Get the DbKeyHash384Type interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash384TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash384TypeTableObj getDbKeyHash384TypeTableObj();

	/**
	 *	Get the DbKeyHash512Col interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash512ColTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash512ColTableObj getDbKeyHash512ColTableObj();

	/**
	 *	Get the DbKeyHash512Def interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash512DefTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash512DefTableObj getDbKeyHash512DefTableObj();

	/**
	 *	Get the DbKeyHash512Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash512GenTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash512GenTableObj getDbKeyHash512GenTableObj();

	/**
	 *	Get the DbKeyHash512Type interface for the schema.
	 *
	 *	@return	The ICFBamProtDbKeyHash512TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtDbKeyHash512TypeTableObj getDbKeyHash512TypeTableObj();

	/**
	 *	Get the DelDep interface for the schema.
	 *
	 *	@return	The ICFBamProtDelDepTableObj interface implementation for the schema.
	 */
	ICFBamProtDelDepTableObj getDelDepTableObj();

	/**
	 *	Get the DelSubDep1 interface for the schema.
	 *
	 *	@return	The ICFBamProtDelSubDep1TableObj interface implementation for the schema.
	 */
	ICFBamProtDelSubDep1TableObj getDelSubDep1TableObj();

	/**
	 *	Get the DelSubDep2 interface for the schema.
	 *
	 *	@return	The ICFBamProtDelSubDep2TableObj interface implementation for the schema.
	 */
	ICFBamProtDelSubDep2TableObj getDelSubDep2TableObj();

	/**
	 *	Get the DelSubDep3 interface for the schema.
	 *
	 *	@return	The ICFBamProtDelSubDep3TableObj interface implementation for the schema.
	 */
	ICFBamProtDelSubDep3TableObj getDelSubDep3TableObj();

	/**
	 *	Get the DelTopDep interface for the schema.
	 *
	 *	@return	The ICFBamProtDelTopDepTableObj interface implementation for the schema.
	 */
	ICFBamProtDelTopDepTableObj getDelTopDepTableObj();

	/**
	 *	Get the DoubleCol interface for the schema.
	 *
	 *	@return	The ICFBamProtDoubleColTableObj interface implementation for the schema.
	 */
	ICFBamProtDoubleColTableObj getDoubleColTableObj();

	/**
	 *	Get the DoubleDef interface for the schema.
	 *
	 *	@return	The ICFBamProtDoubleDefTableObj interface implementation for the schema.
	 */
	ICFBamProtDoubleDefTableObj getDoubleDefTableObj();

	/**
	 *	Get the DoubleType interface for the schema.
	 *
	 *	@return	The ICFBamProtDoubleTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtDoubleTypeTableObj getDoubleTypeTableObj();

	/**
	 *	Get the EnumDef interface for the schema.
	 *
	 *	@return	The ICFBamProtEnumDefTableObj interface implementation for the schema.
	 */
	ICFBamProtEnumDefTableObj getEnumDefTableObj();

	/**
	 *	Get the EnumTag interface for the schema.
	 *
	 *	@return	The ICFBamProtEnumTagTableObj interface implementation for the schema.
	 */
	ICFBamProtEnumTagTableObj getEnumTagTableObj();

	/**
	 *	Get the EnumType interface for the schema.
	 *
	 *	@return	The ICFBamProtEnumTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtEnumTypeTableObj getEnumTypeTableObj();

	/**
	 *	Get the FloatCol interface for the schema.
	 *
	 *	@return	The ICFBamProtFloatColTableObj interface implementation for the schema.
	 */
	ICFBamProtFloatColTableObj getFloatColTableObj();

	/**
	 *	Get the FloatDef interface for the schema.
	 *
	 *	@return	The ICFBamProtFloatDefTableObj interface implementation for the schema.
	 */
	ICFBamProtFloatDefTableObj getFloatDefTableObj();

	/**
	 *	Get the FloatType interface for the schema.
	 *
	 *	@return	The ICFBamProtFloatTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtFloatTypeTableObj getFloatTypeTableObj();

	/**
	 *	Get the Id16Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtId16GenTableObj interface implementation for the schema.
	 */
	ICFBamProtId16GenTableObj getId16GenTableObj();

	/**
	 *	Get the Id32Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtId32GenTableObj interface implementation for the schema.
	 */
	ICFBamProtId32GenTableObj getId32GenTableObj();

	/**
	 *	Get the Id64Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtId64GenTableObj interface implementation for the schema.
	 */
	ICFBamProtId64GenTableObj getId64GenTableObj();

	/**
	 *	Get the Index interface for the schema.
	 *
	 *	@return	The ICFBamProtIndexTableObj interface implementation for the schema.
	 */
	ICFBamProtIndexTableObj getIndexTableObj();

	/**
	 *	Get the IndexCol interface for the schema.
	 *
	 *	@return	The ICFBamProtIndexColTableObj interface implementation for the schema.
	 */
	ICFBamProtIndexColTableObj getIndexColTableObj();

	/**
	 *	Get the IndexTweak interface for the schema.
	 *
	 *	@return	The ICFBamProtIndexTweakTableObj interface implementation for the schema.
	 */
	ICFBamProtIndexTweakTableObj getIndexTweakTableObj();

	/**
	 *	Get the Int16Col interface for the schema.
	 *
	 *	@return	The ICFBamProtInt16ColTableObj interface implementation for the schema.
	 */
	ICFBamProtInt16ColTableObj getInt16ColTableObj();

	/**
	 *	Get the Int16Def interface for the schema.
	 *
	 *	@return	The ICFBamProtInt16DefTableObj interface implementation for the schema.
	 */
	ICFBamProtInt16DefTableObj getInt16DefTableObj();

	/**
	 *	Get the Int16Type interface for the schema.
	 *
	 *	@return	The ICFBamProtInt16TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtInt16TypeTableObj getInt16TypeTableObj();

	/**
	 *	Get the Int32Col interface for the schema.
	 *
	 *	@return	The ICFBamProtInt32ColTableObj interface implementation for the schema.
	 */
	ICFBamProtInt32ColTableObj getInt32ColTableObj();

	/**
	 *	Get the Int32Def interface for the schema.
	 *
	 *	@return	The ICFBamProtInt32DefTableObj interface implementation for the schema.
	 */
	ICFBamProtInt32DefTableObj getInt32DefTableObj();

	/**
	 *	Get the Int32Type interface for the schema.
	 *
	 *	@return	The ICFBamProtInt32TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtInt32TypeTableObj getInt32TypeTableObj();

	/**
	 *	Get the Int64Col interface for the schema.
	 *
	 *	@return	The ICFBamProtInt64ColTableObj interface implementation for the schema.
	 */
	ICFBamProtInt64ColTableObj getInt64ColTableObj();

	/**
	 *	Get the Int64Def interface for the schema.
	 *
	 *	@return	The ICFBamProtInt64DefTableObj interface implementation for the schema.
	 */
	ICFBamProtInt64DefTableObj getInt64DefTableObj();

	/**
	 *	Get the Int64Type interface for the schema.
	 *
	 *	@return	The ICFBamProtInt64TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtInt64TypeTableObj getInt64TypeTableObj();

	/**
	 *	Get the NmTokenCol interface for the schema.
	 *
	 *	@return	The ICFBamProtNmTokenColTableObj interface implementation for the schema.
	 */
	ICFBamProtNmTokenColTableObj getNmTokenColTableObj();

	/**
	 *	Get the NmTokenDef interface for the schema.
	 *
	 *	@return	The ICFBamProtNmTokenDefTableObj interface implementation for the schema.
	 */
	ICFBamProtNmTokenDefTableObj getNmTokenDefTableObj();

	/**
	 *	Get the NmTokenType interface for the schema.
	 *
	 *	@return	The ICFBamProtNmTokenTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtNmTokenTypeTableObj getNmTokenTypeTableObj();

	/**
	 *	Get the NmTokensCol interface for the schema.
	 *
	 *	@return	The ICFBamProtNmTokensColTableObj interface implementation for the schema.
	 */
	ICFBamProtNmTokensColTableObj getNmTokensColTableObj();

	/**
	 *	Get the NmTokensDef interface for the schema.
	 *
	 *	@return	The ICFBamProtNmTokensDefTableObj interface implementation for the schema.
	 */
	ICFBamProtNmTokensDefTableObj getNmTokensDefTableObj();

	/**
	 *	Get the NmTokensType interface for the schema.
	 *
	 *	@return	The ICFBamProtNmTokensTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtNmTokensTypeTableObj getNmTokensTypeTableObj();

	/**
	 *	Get the NumberCol interface for the schema.
	 *
	 *	@return	The ICFBamProtNumberColTableObj interface implementation for the schema.
	 */
	ICFBamProtNumberColTableObj getNumberColTableObj();

	/**
	 *	Get the NumberDef interface for the schema.
	 *
	 *	@return	The ICFBamProtNumberDefTableObj interface implementation for the schema.
	 */
	ICFBamProtNumberDefTableObj getNumberDefTableObj();

	/**
	 *	Get the NumberType interface for the schema.
	 *
	 *	@return	The ICFBamProtNumberTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtNumberTypeTableObj getNumberTypeTableObj();

	/**
	 *	Get the Param interface for the schema.
	 *
	 *	@return	The ICFBamProtParamTableObj interface implementation for the schema.
	 */
	ICFBamProtParamTableObj getParamTableObj();

	/**
	 *	Get the PopDep interface for the schema.
	 *
	 *	@return	The ICFBamProtPopDepTableObj interface implementation for the schema.
	 */
	ICFBamProtPopDepTableObj getPopDepTableObj();

	/**
	 *	Get the PopSubDep1 interface for the schema.
	 *
	 *	@return	The ICFBamProtPopSubDep1TableObj interface implementation for the schema.
	 */
	ICFBamProtPopSubDep1TableObj getPopSubDep1TableObj();

	/**
	 *	Get the PopSubDep2 interface for the schema.
	 *
	 *	@return	The ICFBamProtPopSubDep2TableObj interface implementation for the schema.
	 */
	ICFBamProtPopSubDep2TableObj getPopSubDep2TableObj();

	/**
	 *	Get the PopSubDep3 interface for the schema.
	 *
	 *	@return	The ICFBamProtPopSubDep3TableObj interface implementation for the schema.
	 */
	ICFBamProtPopSubDep3TableObj getPopSubDep3TableObj();

	/**
	 *	Get the PopTopDep interface for the schema.
	 *
	 *	@return	The ICFBamProtPopTopDepTableObj interface implementation for the schema.
	 */
	ICFBamProtPopTopDepTableObj getPopTopDepTableObj();

	/**
	 *	Get the Relation interface for the schema.
	 *
	 *	@return	The ICFBamProtRelationTableObj interface implementation for the schema.
	 */
	ICFBamProtRelationTableObj getRelationTableObj();

	/**
	 *	Get the RelationCol interface for the schema.
	 *
	 *	@return	The ICFBamProtRelationColTableObj interface implementation for the schema.
	 */
	ICFBamProtRelationColTableObj getRelationColTableObj();

	/**
	 *	Get the RoleDef interface for the schema.
	 *
	 *	@return	The ICFBamProtRoleDefTableObj interface implementation for the schema.
	 */
	ICFBamProtRoleDefTableObj getRoleDefTableObj();

	/**
	 *	Get the SchemaDef interface for the schema.
	 *
	 *	@return	The ICFBamProtSchemaDefTableObj interface implementation for the schema.
	 */
	ICFBamProtSchemaDefTableObj getSchemaDefTableObj();

	/**
	 *	Get the SchemaRef interface for the schema.
	 *
	 *	@return	The ICFBamProtSchemaRefTableObj interface implementation for the schema.
	 */
	ICFBamProtSchemaRefTableObj getSchemaRefTableObj();

	/**
	 *	Get the SchemaRole interface for the schema.
	 *
	 *	@return	The ICFBamProtSchemaRoleTableObj interface implementation for the schema.
	 */
	ICFBamProtSchemaRoleTableObj getSchemaRoleTableObj();

	/**
	 *	Get the SchemaTweak interface for the schema.
	 *
	 *	@return	The ICFBamProtSchemaTweakTableObj interface implementation for the schema.
	 */
	ICFBamProtSchemaTweakTableObj getSchemaTweakTableObj();

	/**
	 *	Get the Scope interface for the schema.
	 *
	 *	@return	The ICFBamProtScopeTableObj interface implementation for the schema.
	 */
	ICFBamProtScopeTableObj getScopeTableObj();

	/**
	 *	Get the ServerListFunc interface for the schema.
	 *
	 *	@return	The ICFBamProtServerListFuncTableObj interface implementation for the schema.
	 */
	ICFBamProtServerListFuncTableObj getServerListFuncTableObj();

	/**
	 *	Get the ServerMethod interface for the schema.
	 *
	 *	@return	The ICFBamProtServerMethodTableObj interface implementation for the schema.
	 */
	ICFBamProtServerMethodTableObj getServerMethodTableObj();

	/**
	 *	Get the ServerObjFunc interface for the schema.
	 *
	 *	@return	The ICFBamProtServerObjFuncTableObj interface implementation for the schema.
	 */
	ICFBamProtServerObjFuncTableObj getServerObjFuncTableObj();

	/**
	 *	Get the ServerProc interface for the schema.
	 *
	 *	@return	The ICFBamProtServerProcTableObj interface implementation for the schema.
	 */
	ICFBamProtServerProcTableObj getServerProcTableObj();

	/**
	 *	Get the StringCol interface for the schema.
	 *
	 *	@return	The ICFBamProtStringColTableObj interface implementation for the schema.
	 */
	ICFBamProtStringColTableObj getStringColTableObj();

	/**
	 *	Get the StringDef interface for the schema.
	 *
	 *	@return	The ICFBamProtStringDefTableObj interface implementation for the schema.
	 */
	ICFBamProtStringDefTableObj getStringDefTableObj();

	/**
	 *	Get the StringType interface for the schema.
	 *
	 *	@return	The ICFBamProtStringTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtStringTypeTableObj getStringTypeTableObj();

	/**
	 *	Get the TZDateCol interface for the schema.
	 *
	 *	@return	The ICFBamProtTZDateColTableObj interface implementation for the schema.
	 */
	ICFBamProtTZDateColTableObj getTZDateColTableObj();

	/**
	 *	Get the TZDateDef interface for the schema.
	 *
	 *	@return	The ICFBamProtTZDateDefTableObj interface implementation for the schema.
	 */
	ICFBamProtTZDateDefTableObj getTZDateDefTableObj();

	/**
	 *	Get the TZDateType interface for the schema.
	 *
	 *	@return	The ICFBamProtTZDateTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtTZDateTypeTableObj getTZDateTypeTableObj();

	/**
	 *	Get the TZTimeCol interface for the schema.
	 *
	 *	@return	The ICFBamProtTZTimeColTableObj interface implementation for the schema.
	 */
	ICFBamProtTZTimeColTableObj getTZTimeColTableObj();

	/**
	 *	Get the TZTimeDef interface for the schema.
	 *
	 *	@return	The ICFBamProtTZTimeDefTableObj interface implementation for the schema.
	 */
	ICFBamProtTZTimeDefTableObj getTZTimeDefTableObj();

	/**
	 *	Get the TZTimeType interface for the schema.
	 *
	 *	@return	The ICFBamProtTZTimeTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtTZTimeTypeTableObj getTZTimeTypeTableObj();

	/**
	 *	Get the TZTimestampCol interface for the schema.
	 *
	 *	@return	The ICFBamProtTZTimestampColTableObj interface implementation for the schema.
	 */
	ICFBamProtTZTimestampColTableObj getTZTimestampColTableObj();

	/**
	 *	Get the TZTimestampDef interface for the schema.
	 *
	 *	@return	The ICFBamProtTZTimestampDefTableObj interface implementation for the schema.
	 */
	ICFBamProtTZTimestampDefTableObj getTZTimestampDefTableObj();

	/**
	 *	Get the TZTimestampType interface for the schema.
	 *
	 *	@return	The ICFBamProtTZTimestampTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtTZTimestampTypeTableObj getTZTimestampTypeTableObj();

	/**
	 *	Get the Table interface for the schema.
	 *
	 *	@return	The ICFBamProtTableTableObj interface implementation for the schema.
	 */
	ICFBamProtTableTableObj getTableTableObj();

	/**
	 *	Get the TableCol interface for the schema.
	 *
	 *	@return	The ICFBamProtTableColTableObj interface implementation for the schema.
	 */
	ICFBamProtTableColTableObj getTableColTableObj();

	/**
	 *	Get the TableTweak interface for the schema.
	 *
	 *	@return	The ICFBamProtTableTweakTableObj interface implementation for the schema.
	 */
	ICFBamProtTableTweakTableObj getTableTweakTableObj();

	/**
	 *	Get the TextCol interface for the schema.
	 *
	 *	@return	The ICFBamProtTextColTableObj interface implementation for the schema.
	 */
	ICFBamProtTextColTableObj getTextColTableObj();

	/**
	 *	Get the TextDef interface for the schema.
	 *
	 *	@return	The ICFBamProtTextDefTableObj interface implementation for the schema.
	 */
	ICFBamProtTextDefTableObj getTextDefTableObj();

	/**
	 *	Get the TextType interface for the schema.
	 *
	 *	@return	The ICFBamProtTextTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtTextTypeTableObj getTextTypeTableObj();

	/**
	 *	Get the TimeCol interface for the schema.
	 *
	 *	@return	The ICFBamProtTimeColTableObj interface implementation for the schema.
	 */
	ICFBamProtTimeColTableObj getTimeColTableObj();

	/**
	 *	Get the TimeDef interface for the schema.
	 *
	 *	@return	The ICFBamProtTimeDefTableObj interface implementation for the schema.
	 */
	ICFBamProtTimeDefTableObj getTimeDefTableObj();

	/**
	 *	Get the TimeType interface for the schema.
	 *
	 *	@return	The ICFBamProtTimeTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtTimeTypeTableObj getTimeTypeTableObj();

	/**
	 *	Get the TimestampCol interface for the schema.
	 *
	 *	@return	The ICFBamProtTimestampColTableObj interface implementation for the schema.
	 */
	ICFBamProtTimestampColTableObj getTimestampColTableObj();

	/**
	 *	Get the TimestampDef interface for the schema.
	 *
	 *	@return	The ICFBamProtTimestampDefTableObj interface implementation for the schema.
	 */
	ICFBamProtTimestampDefTableObj getTimestampDefTableObj();

	/**
	 *	Get the TimestampType interface for the schema.
	 *
	 *	@return	The ICFBamProtTimestampTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtTimestampTypeTableObj getTimestampTypeTableObj();

	/**
	 *	Get the TokenCol interface for the schema.
	 *
	 *	@return	The ICFBamProtTokenColTableObj interface implementation for the schema.
	 */
	ICFBamProtTokenColTableObj getTokenColTableObj();

	/**
	 *	Get the TokenDef interface for the schema.
	 *
	 *	@return	The ICFBamProtTokenDefTableObj interface implementation for the schema.
	 */
	ICFBamProtTokenDefTableObj getTokenDefTableObj();

	/**
	 *	Get the TokenType interface for the schema.
	 *
	 *	@return	The ICFBamProtTokenTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtTokenTypeTableObj getTokenTypeTableObj();

	/**
	 *	Get the Tweak interface for the schema.
	 *
	 *	@return	The ICFBamProtTweakTableObj interface implementation for the schema.
	 */
	ICFBamProtTweakTableObj getTweakTableObj();

	/**
	 *	Get the UInt16Col interface for the schema.
	 *
	 *	@return	The ICFBamProtUInt16ColTableObj interface implementation for the schema.
	 */
	ICFBamProtUInt16ColTableObj getUInt16ColTableObj();

	/**
	 *	Get the UInt16Def interface for the schema.
	 *
	 *	@return	The ICFBamProtUInt16DefTableObj interface implementation for the schema.
	 */
	ICFBamProtUInt16DefTableObj getUInt16DefTableObj();

	/**
	 *	Get the UInt16Type interface for the schema.
	 *
	 *	@return	The ICFBamProtUInt16TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtUInt16TypeTableObj getUInt16TypeTableObj();

	/**
	 *	Get the UInt32Col interface for the schema.
	 *
	 *	@return	The ICFBamProtUInt32ColTableObj interface implementation for the schema.
	 */
	ICFBamProtUInt32ColTableObj getUInt32ColTableObj();

	/**
	 *	Get the UInt32Def interface for the schema.
	 *
	 *	@return	The ICFBamProtUInt32DefTableObj interface implementation for the schema.
	 */
	ICFBamProtUInt32DefTableObj getUInt32DefTableObj();

	/**
	 *	Get the UInt32Type interface for the schema.
	 *
	 *	@return	The ICFBamProtUInt32TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtUInt32TypeTableObj getUInt32TypeTableObj();

	/**
	 *	Get the UInt64Col interface for the schema.
	 *
	 *	@return	The ICFBamProtUInt64ColTableObj interface implementation for the schema.
	 */
	ICFBamProtUInt64ColTableObj getUInt64ColTableObj();

	/**
	 *	Get the UInt64Def interface for the schema.
	 *
	 *	@return	The ICFBamProtUInt64DefTableObj interface implementation for the schema.
	 */
	ICFBamProtUInt64DefTableObj getUInt64DefTableObj();

	/**
	 *	Get the UInt64Type interface for the schema.
	 *
	 *	@return	The ICFBamProtUInt64TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtUInt64TypeTableObj getUInt64TypeTableObj();

	/**
	 *	Get the Uuid6Col interface for the schema.
	 *
	 *	@return	The ICFBamProtUuid6ColTableObj interface implementation for the schema.
	 */
	ICFBamProtUuid6ColTableObj getUuid6ColTableObj();

	/**
	 *	Get the Uuid6Def interface for the schema.
	 *
	 *	@return	The ICFBamProtUuid6DefTableObj interface implementation for the schema.
	 */
	ICFBamProtUuid6DefTableObj getUuid6DefTableObj();

	/**
	 *	Get the Uuid6Gen interface for the schema.
	 *
	 *	@return	The ICFBamProtUuid6GenTableObj interface implementation for the schema.
	 */
	ICFBamProtUuid6GenTableObj getUuid6GenTableObj();

	/**
	 *	Get the Uuid6Type interface for the schema.
	 *
	 *	@return	The ICFBamProtUuid6TypeTableObj interface implementation for the schema.
	 */
	ICFBamProtUuid6TypeTableObj getUuid6TypeTableObj();

	/**
	 *	Get the UuidCol interface for the schema.
	 *
	 *	@return	The ICFBamProtUuidColTableObj interface implementation for the schema.
	 */
	ICFBamProtUuidColTableObj getUuidColTableObj();

	/**
	 *	Get the UuidDef interface for the schema.
	 *
	 *	@return	The ICFBamProtUuidDefTableObj interface implementation for the schema.
	 */
	ICFBamProtUuidDefTableObj getUuidDefTableObj();

	/**
	 *	Get the UuidGen interface for the schema.
	 *
	 *	@return	The ICFBamProtUuidGenTableObj interface implementation for the schema.
	 */
	ICFBamProtUuidGenTableObj getUuidGenTableObj();

	/**
	 *	Get the UuidType interface for the schema.
	 *
	 *	@return	The ICFBamProtUuidTypeTableObj interface implementation for the schema.
	 */
	ICFBamProtUuidTypeTableObj getUuidTypeTableObj();

	/**
	 *	Get the Value interface for the schema.
	 *
	 *	@return	The ICFBamProtValueTableObj interface implementation for the schema.
	 */
	ICFBamProtValueTableObj getValueTableObj();
}
