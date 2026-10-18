// Description: Java 25 protected interface for a CFBam schema.

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

package server.markhome.mcf.v3_1.cfbam.cfbamprot;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.MCFXmlUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprot.*;
import server.markhome.mcf.v3_1.cfint.cfintprot.*;

//import server.markhome.mcf.v3_1.cfsec.cfsecprot.buff.CFSecProtBuffFactoryService;
//import server.markhome.mcf.v3_1.cfint.cfintprot.buff.CFIntProtBuffFactoryService;
//import server.markhome.mcf.v3_1.cfbam.cfbamprot.buff.CFBamProtBuffSchema;
//import server.markhome.mcf.v3_1.cfbam.cfbamprot.buff.CFBamProtBuffFactoryService;

public interface ICFBamProtSchema
extends ICFSecProtSchema,
	ICFIntProtSchema
{

	public static final String SCHEMA_NAME = "CFBam";
	public static final String DBSCHEMA_NAME = "CFBam31";
	static final AtomicReference<ApplicationContext> arApplicationContext = new AtomicReference<>(null);
	public static final CFSecPubTableData TABLE_DATA[] = {new CFSecPubTableData("CFBam", "Chain", null, true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "EnumTag", null, true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "IndexCol", null, true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Param", null, true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "RelationCol", null, true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "RoleDef", null, true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "SchemaRole", "RoleDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Scope", null, true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "SchemaDef", "Scope", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "SchemaRef", "Scope", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "ServerMethod", "Scope", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "ServerObjFunc", "ServerMethod", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "ServerProc", "ServerMethod", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "ServerListFunc", "ServerMethod", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Table", "Scope", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "ClearDep", "Scope", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "ClearSubDep1", "ClearDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "ClearSubDep2", "ClearDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "ClearSubDep3", "ClearDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "ClearTopDep", "ClearDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DelDep", "Scope", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DelSubDep1", "DelDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DelSubDep2", "DelDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DelSubDep3", "DelDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DelTopDep", "DelDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Index", "Scope", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "PopDep", "Scope", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "PopSubDep1", "PopDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "PopSubDep2", "PopDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "PopSubDep3", "PopDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "PopTopDep", "PopDep", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Relation", "Scope", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Tweak", null, true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TableTweak", "Tweak", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "SchemaTweak", "Tweak", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "IndexTweak", "Tweak", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Value", null, true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Atom", "Value", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "BlobDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "BlobType", "BlobDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "BlobCol", "BlobDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "BoolDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "BoolType", "BoolDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "BoolCol", "BoolDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DateDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DateType", "DateDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DateCol", "DateDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DoubleDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DoubleType", "DoubleDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DoubleCol", "DoubleDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "FloatDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "FloatType", "FloatDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "FloatCol", "FloatDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Int16Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Int16Type", "Int16Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Id16Gen", "Int16Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "EnumDef", "Int16Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "EnumType", "EnumDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Int16Col", "Int16Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Int32Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Int32Type", "Int32Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Id32Gen", "Int32Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Int32Col", "Int32Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Int64Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Int64Type", "Int64Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Id64Gen", "Int64Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Int64Col", "Int64Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "NmTokenDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "NmTokenType", "NmTokenDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "NmTokenCol", "NmTokenDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "NmTokensDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "NmTokensType", "NmTokensDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "NmTokensCol", "NmTokensDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "NumberDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "NumberType", "NumberDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "NumberCol", "NumberDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash128Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash128Col", "DbKeyHash128Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash128Type", "DbKeyHash128Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash128Gen", "DbKeyHash128Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash160Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash160Col", "DbKeyHash160Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash160Type", "DbKeyHash160Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash160Gen", "DbKeyHash160Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash224Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash224Col", "DbKeyHash224Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash224Type", "DbKeyHash224Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash224Gen", "DbKeyHash224Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash256Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash256Col", "DbKeyHash256Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash256Type", "DbKeyHash256Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash256Gen", "DbKeyHash256Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash384Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash384Col", "DbKeyHash384Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash384Type", "DbKeyHash384Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash384Gen", "DbKeyHash384Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash512Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash512Col", "DbKeyHash512Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash512Type", "DbKeyHash512Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "DbKeyHash512Gen", "DbKeyHash512Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "StringDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "StringType", "StringDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "StringCol", "StringDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TZDateDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TZDateType", "TZDateDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TZDateCol", "TZDateDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TZTimeDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TZTimeType", "TZTimeDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TZTimeCol", "TZTimeDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TZTimestampDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TZTimestampType", "TZTimestampDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TZTimestampCol", "TZTimestampDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TextDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TextType", "TextDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TextCol", "TextDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TimeDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TimeType", "TimeDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TimeCol", "TimeDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TimestampDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TimestampType", "TimestampDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TimestampCol", "TimestampDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TokenDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TokenType", "TokenDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TokenCol", "TokenDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UInt16Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UInt16Type", "UInt16Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UInt16Col", "UInt16Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UInt32Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UInt32Type", "UInt32Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UInt32Col", "UInt32Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UInt64Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UInt64Type", "UInt64Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UInt64Col", "UInt64Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UuidDef", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UuidType", "UuidDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UuidGen", "UuidType", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "UuidCol", "UuidDef", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Uuid6Def", "Atom", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Uuid6Type", "Uuid6Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Uuid6Gen", "Uuid6Type", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "Uuid6Col", "Uuid6Def", true, false, "Tenant", "Public"),
		new CFSecPubTableData("CFBam", "TableCol", "Value", true, false, "Tenant", "Public")};
	public static final AtomicReference<CFSecPubTableData[]> consolidatedTableData = new AtomicReference<>(null);
	public static final CFSecPubRoleInfo ROLE_INFO[] = {};
	public static final AtomicReference<CFSecPubRoleInfo[]> consolidatedRoleInfo = new AtomicReference<>(null);
	public static CFSecPubTableData[] getTableData() {
		return TABLE_DATA;
	}

	public static CFSecPubTableData[] getConsolidatedTableData() {
		if (consolidatedTableData.get() == null) {
			ArrayList<CFSecPubTableData> lst = new ArrayList<>();
			for( CFSecPubTableData data: ICFSecProtSchema.getTableData()) {
				lst.add(data);
			}
			for( CFSecPubTableData data: ICFIntProtSchema.getTableData()) {
				lst.add(data);
			}
			for( CFSecPubTableData data: TABLE_DATA) {
				lst.add(data);
			}
			CFSecPubTableData arr[] = new CFSecPubTableData[lst.size()];
			int idx = 0;
			for(CFSecPubTableData data: lst) {
				arr[idx++] = data;
			}
			consolidatedTableData.compareAndSet(null, arr);
		}
		return(consolidatedTableData.get());
	}

	public static CFSecPubRoleInfo[] getRoleInfo() {
		return ROLE_INFO;
	}

	public static CFSecPubRoleInfo[] getConsolidatedRoleInfo() {
		if (consolidatedRoleInfo.get() == null) {
			ArrayList<CFSecPubRoleInfo> lst = new ArrayList<>();
			for( CFSecPubRoleInfo info: ICFSecProtSchema.getRoleInfo()) {
				lst.add(info);
			}
			for( CFSecPubRoleInfo info: ICFIntProtSchema.getRoleInfo()) {
				lst.add(info);
			}
			for( CFSecPubRoleInfo info: ROLE_INFO) {
				lst.add(info);
			}
			// Dependency order is the natural order of role info comparison
			lst.sort(new CFSecPubRoleInfoDependencyComparator());
			CFSecPubRoleInfo arr[] = new CFSecPubRoleInfo[lst.size()];
			int idx = 0;
			for(CFSecPubRoleInfo info: lst) {
				arr[idx++] = info;
			}
			consolidatedRoleInfo.compareAndSet(null, arr);
		}
		return(consolidatedRoleInfo.get());
	}

	public default void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		arApplicationContext.compareAndSet(arApplicationContext.get(), applicationContext);
	}

	public static ApplicationContext getApplicationContext() {
		return( arApplicationContext.get() );
	}

		final static ArrayList<ICFSecProtSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ICFSecProtSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ICFSecProtSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<ICFBamProtSchema> backingCFBam = new AtomicReference<>();
		public static ICFBamProtSchema getBackingCFBam() {
			return( ICFBamProtSchema.backingCFBam.get() );
		}
		
		public static void setBackingCFBam(ICFBamProtSchema backingSchema) {
			ICFBamProtSchema.backingCFBam.set(backingSchema);
		}
		
		public ICFBamProtSchema getCFBamSchema();
		public void setCFBamSchema(ICFBamProtSchema schema);
		
		public static int doInitClassMapEntries(int value) {
			value = ICFSecProtSchema.doInitClassMapEntries(value);
			value = ICFIntProtSchema.doInitClassMapEntries(value);
			if (ICFBamProtSchema.entries.isEmpty()) {
				ICFSecProtSchema.ClassMapEntry entry;
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Atom", ICFBamProtAtom.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "BlobCol", ICFBamProtBlobCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "BlobDef", ICFBamProtBlobDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "BlobType", ICFBamProtBlobType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "BoolCol", ICFBamProtBoolCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "BoolDef", ICFBamProtBoolDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "BoolType", ICFBamProtBoolType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Chain", ICFBamProtChain.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "ClearDep", ICFBamProtClearDep.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "ClearSubDep1", ICFBamProtClearSubDep1.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "ClearSubDep2", ICFBamProtClearSubDep2.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "ClearSubDep3", ICFBamProtClearSubDep3.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "ClearTopDep", ICFBamProtClearTopDep.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DateCol", ICFBamProtDateCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DateDef", ICFBamProtDateDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DateType", ICFBamProtDateType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash128Col", ICFBamProtDbKeyHash128Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash128Def", ICFBamProtDbKeyHash128Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash128Gen", ICFBamProtDbKeyHash128Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash128Type", ICFBamProtDbKeyHash128Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash160Col", ICFBamProtDbKeyHash160Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash160Def", ICFBamProtDbKeyHash160Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash160Gen", ICFBamProtDbKeyHash160Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash160Type", ICFBamProtDbKeyHash160Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash224Col", ICFBamProtDbKeyHash224Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash224Def", ICFBamProtDbKeyHash224Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash224Gen", ICFBamProtDbKeyHash224Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash224Type", ICFBamProtDbKeyHash224Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash256Col", ICFBamProtDbKeyHash256Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash256Def", ICFBamProtDbKeyHash256Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash256Gen", ICFBamProtDbKeyHash256Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash256Type", ICFBamProtDbKeyHash256Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash384Col", ICFBamProtDbKeyHash384Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash384Def", ICFBamProtDbKeyHash384Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash384Gen", ICFBamProtDbKeyHash384Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash384Type", ICFBamProtDbKeyHash384Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash512Col", ICFBamProtDbKeyHash512Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash512Def", ICFBamProtDbKeyHash512Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash512Gen", ICFBamProtDbKeyHash512Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DbKeyHash512Type", ICFBamProtDbKeyHash512Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DelDep", ICFBamProtDelDep.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DelSubDep1", ICFBamProtDelSubDep1.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DelSubDep2", ICFBamProtDelSubDep2.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DelSubDep3", ICFBamProtDelSubDep3.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DelTopDep", ICFBamProtDelTopDep.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DoubleCol", ICFBamProtDoubleCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DoubleDef", ICFBamProtDoubleDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "DoubleType", ICFBamProtDoubleType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "EnumDef", ICFBamProtEnumDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "EnumTag", ICFBamProtEnumTag.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "EnumType", ICFBamProtEnumType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "FloatCol", ICFBamProtFloatCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "FloatDef", ICFBamProtFloatDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "FloatType", ICFBamProtFloatType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Id16Gen", ICFBamProtId16Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Id32Gen", ICFBamProtId32Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Id64Gen", ICFBamProtId64Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Index", ICFBamProtIndex.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "IndexCol", ICFBamProtIndexCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "IndexTweak", ICFBamProtIndexTweak.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Int16Col", ICFBamProtInt16Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Int16Def", ICFBamProtInt16Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Int16Type", ICFBamProtInt16Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Int32Col", ICFBamProtInt32Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Int32Def", ICFBamProtInt32Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Int32Type", ICFBamProtInt32Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Int64Col", ICFBamProtInt64Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Int64Def", ICFBamProtInt64Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Int64Type", ICFBamProtInt64Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "NmTokenCol", ICFBamProtNmTokenCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "NmTokenDef", ICFBamProtNmTokenDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "NmTokenType", ICFBamProtNmTokenType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "NmTokensCol", ICFBamProtNmTokensCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "NmTokensDef", ICFBamProtNmTokensDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "NmTokensType", ICFBamProtNmTokensType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "NumberCol", ICFBamProtNumberCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "NumberDef", ICFBamProtNumberDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "NumberType", ICFBamProtNumberType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Param", ICFBamProtParam.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "PopDep", ICFBamProtPopDep.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "PopSubDep1", ICFBamProtPopSubDep1.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "PopSubDep2", ICFBamProtPopSubDep2.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "PopSubDep3", ICFBamProtPopSubDep3.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "PopTopDep", ICFBamProtPopTopDep.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Relation", ICFBamProtRelation.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "RelationCol", ICFBamProtRelationCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "RoleDef", ICFBamProtRoleDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "SchemaDef", ICFBamProtSchemaDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "SchemaRef", ICFBamProtSchemaRef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "SchemaRole", ICFBamProtSchemaRole.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "SchemaTweak", ICFBamProtSchemaTweak.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Scope", ICFBamProtScope.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "ServerListFunc", ICFBamProtServerListFunc.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "ServerMethod", ICFBamProtServerMethod.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "ServerObjFunc", ICFBamProtServerObjFunc.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "ServerProc", ICFBamProtServerProc.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "StringCol", ICFBamProtStringCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "StringDef", ICFBamProtStringDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "StringType", ICFBamProtStringType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TZDateCol", ICFBamProtTZDateCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TZDateDef", ICFBamProtTZDateDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TZDateType", ICFBamProtTZDateType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TZTimeCol", ICFBamProtTZTimeCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TZTimeDef", ICFBamProtTZTimeDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TZTimeType", ICFBamProtTZTimeType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TZTimestampCol", ICFBamProtTZTimestampCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TZTimestampDef", ICFBamProtTZTimestampDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TZTimestampType", ICFBamProtTZTimestampType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Table", ICFBamProtTable.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TableCol", ICFBamProtTableCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TableTweak", ICFBamProtTableTweak.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TextCol", ICFBamProtTextCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TextDef", ICFBamProtTextDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TextType", ICFBamProtTextType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TimeCol", ICFBamProtTimeCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TimeDef", ICFBamProtTimeDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TimeType", ICFBamProtTimeType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TimestampCol", ICFBamProtTimestampCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TimestampDef", ICFBamProtTimestampDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TimestampType", ICFBamProtTimestampType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TokenCol", ICFBamProtTokenCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TokenDef", ICFBamProtTokenDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "TokenType", ICFBamProtTokenType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Tweak", ICFBamProtTweak.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UInt16Col", ICFBamProtUInt16Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UInt16Def", ICFBamProtUInt16Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UInt16Type", ICFBamProtUInt16Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UInt32Col", ICFBamProtUInt32Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UInt32Def", ICFBamProtUInt32Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UInt32Type", ICFBamProtUInt32Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UInt64Col", ICFBamProtUInt64Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UInt64Def", ICFBamProtUInt64Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UInt64Type", ICFBamProtUInt64Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Uuid6Col", ICFBamProtUuid6Col.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Uuid6Def", ICFBamProtUuid6Def.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Uuid6Gen", ICFBamProtUuid6Gen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Uuid6Type", ICFBamProtUuid6Type.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UuidCol", ICFBamProtUuidCol.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UuidDef", ICFBamProtUuidDef.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UuidGen", ICFBamProtUuidGen.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "UuidType", ICFBamProtUuidType.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				entry = new ICFSecProtSchema.ClassMapEntry(ICFBamProtSchema.SCHEMA_NAME, "Value", ICFBamProtValue.CLASS_CODE);
				ICFBamProtSchema.entries.add(entry);
				for( ICFSecProtSchema.ClassMapEntry cur: ICFBamProtSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				ICFBamProtSchema.mapBackingClassCodeToEntry.clear();
				ICFBamProtSchema.mapRuntimeClassCodeToEntry.clear();
				for( ICFSecProtSchema.ClassMapEntry cur: ICFBamProtSchema.entries) {
					ICFBamProtSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					ICFBamProtSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ICFSecProtSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ICFSecProtSchema.ClassMapEntry entry;
			entry = ICFSecProtSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = ICFIntProtSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = ICFBamProtSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ICFSecProtSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ICFSecProtSchema.ClassMapEntry entry;
			entry = ICFSecProtSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = ICFIntProtSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = ICFBamProtSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public int initClassMapEntries(int value);
		public void wireRecConstructors();
		public void wireTableTableInstances();

	/**
	 *	Allocate a new schema instance.
	 *
	 *	@return	A new ICFSecProtSchema instance.
	 */
	public ICFSecProtSchema newSchema();

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen();

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen();

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen();

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen();

	/**
	 *	Get the next TableInfoIdGen identifier.
	 *
	 *	@return	The next TableInfoIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextTableInfoIdGen();

	/**
	 *	Get the next MimeTypeIdGen identifier.
	 *
	 *	@return	The next MimeTypeIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextMimeTypeIdGen();

	/**
	 *	Get the next URLProtocolIdGen identifier.
	 *
	 *	@return	The next URLProtocolIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextURLProtocolIdGen();

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextClusterIdGen();

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextSecSessionIdGen();

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextSecUserIdGen();

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextTenantIdGen();

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextSecSysGrpIdGen();

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextSecClusGrpIdGen();

	/**
	 *	Get the next SecClusRoleIdGen identifier.
	 *
	 *	@return	The next SecClusRoleIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextSecClusRoleIdGen();

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextSecTentGrpIdGen();

	/**
	 *	Get the next SecTentRoleIdGen identifier.
	 *
	 *	@return	The next SecTentRoleIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextSecTentRoleIdGen();

	/**
	 *	Get the next MajorVersionIdGen identifier.
	 *
	 *	@return	The next MajorVersionIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextMajorVersionIdGen();

	/**
	 *	Get the next MinorVersionIdGen identifier.
	 *
	 *	@return	The next MinorVersionIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextMinorVersionIdGen();

	/**
	 *	Get the next SubProjectIdGen identifier.
	 *
	 *	@return	The next SubProjectIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextSubProjectIdGen();

	/**
	 *	Get the next TldIdGen identifier.
	 *
	 *	@return	The next TldIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextTldIdGen();

	/**
	 *	Get the next TopDomainIdGen identifier.
	 *
	 *	@return	The next TopDomainIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextTopDomainIdGen();

	/**
	 *	Get the next TopProjectIdGen identifier.
	 *
	 *	@return	The next TopProjectIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextTopProjectIdGen();

	/**
	 *	Get the next LicenseIdGen identifier.
	 *
	 *	@return	The next LicenseIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextLicenseIdGen();

	/**
	 *	Get the next ChainIdGen identifier.
	 *
	 *	@return	The next ChainIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextChainIdGen();

	/**
	 *	Get the next EnumTagIdGen identifier.
	 *
	 *	@return	The next EnumTagIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextEnumTagIdGen();

	/**
	 *	Get the next IndexColIdGen identifier.
	 *
	 *	@return	The next IndexColIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextIndexColIdGen();

	/**
	 *	Get the next ParamIdGen identifier.
	 *
	 *	@return	The next ParamIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextParamIdGen();

	/**
	 *	Get the next RelationColIdGen identifier.
	 *
	 *	@return	The next RelationColIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextRelationColIdGen();

	/**
	 *	Get the next TweakIdGen identifier.
	 *
	 *	@return	The next TweakIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextTweakIdGen();

	/**
	 *	Get the next ScopeIdGen identifier.
	 *
	 *	@return	The next ScopeIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextScopeIdGen();

	/**
	 *	Get the next ValueIdGen identifier.
	 *
	 *	@return	The next ValueIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextValueIdGen();

	/**
	 *	Get the next RoleIdGen identifier.
	 *
	 *	@return	The next RoleIdGen identifier.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public MCFDbKeyHash256 nextRoleIdGen();

	/**
	 *	Get the factory for CFSecProt data objects.
	 */
	// public ICFSecProtFactory getCFSecFactory();

	/**
	 *	Get the buffer factory for CFSecProt data buffers.
	 */
	// public CFSecProtBuffFactoryService getCFSecBuffFactory();

	/**
	 *	Get the factory for CFIntProt data objects.
	 */
	// public ICFIntProtFactory getCFIntFactory();

	/**
	 *	Get the buffer factory for CFIntProt data buffers.
	 */
	// public CFIntProtBuffFactoryService getCFIntBuffFactory();

	/**
	 *	Get the factory for CFBamProt data objects.
	 */
	// public ICFBamProtFactory getCFBamFactory();

	/**
	 *	Get the buffer factory for CFBamProt data buffers.
	 */
	// public CFBamProtBuffFactoryService getCFBamBuffFactory();

	/**
	 *	Get the Atom Table interface for the schema.
	 *
	 *	@return	The Atom Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtAtomTable getTableAtom();

	/**
	 *	Get the BlobCol Table interface for the schema.
	 *
	 *	@return	The BlobCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtBlobColTable getTableBlobCol();

	/**
	 *	Get the BlobDef Table interface for the schema.
	 *
	 *	@return	The BlobDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtBlobDefTable getTableBlobDef();

	/**
	 *	Get the BlobType Table interface for the schema.
	 *
	 *	@return	The BlobType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtBlobTypeTable getTableBlobType();

	/**
	 *	Get the BoolCol Table interface for the schema.
	 *
	 *	@return	The BoolCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtBoolColTable getTableBoolCol();

	/**
	 *	Get the BoolDef Table interface for the schema.
	 *
	 *	@return	The BoolDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtBoolDefTable getTableBoolDef();

	/**
	 *	Get the BoolType Table interface for the schema.
	 *
	 *	@return	The BoolType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtBoolTypeTable getTableBoolType();

	/**
	 *	Get the Chain Table interface for the schema.
	 *
	 *	@return	The Chain Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtChainTable getTableChain();

	/**
	 *	Get the ClearDep Table interface for the schema.
	 *
	 *	@return	The ClearDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtClearDepTable getTableClearDep();

	/**
	 *	Get the ClearSubDep1 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep1 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtClearSubDep1Table getTableClearSubDep1();

	/**
	 *	Get the ClearSubDep2 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep2 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtClearSubDep2Table getTableClearSubDep2();

	/**
	 *	Get the ClearSubDep3 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep3 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtClearSubDep3Table getTableClearSubDep3();

	/**
	 *	Get the ClearTopDep Table interface for the schema.
	 *
	 *	@return	The ClearTopDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtClearTopDepTable getTableClearTopDep();

	/**
	 *	Get the DateCol Table interface for the schema.
	 *
	 *	@return	The DateCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDateColTable getTableDateCol();

	/**
	 *	Get the DateDef Table interface for the schema.
	 *
	 *	@return	The DateDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDateDefTable getTableDateDef();

	/**
	 *	Get the DateType Table interface for the schema.
	 *
	 *	@return	The DateType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDateTypeTable getTableDateType();

	/**
	 *	Get the DbKeyHash128Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash128ColTable getTableDbKeyHash128Col();

	/**
	 *	Get the DbKeyHash128Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash128DefTable getTableDbKeyHash128Def();

	/**
	 *	Get the DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash128GenTable getTableDbKeyHash128Gen();

	/**
	 *	Get the DbKeyHash128Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash128TypeTable getTableDbKeyHash128Type();

	/**
	 *	Get the DbKeyHash160Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160ColTable getTableDbKeyHash160Col();

	/**
	 *	Get the DbKeyHash160Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160DefTable getTableDbKeyHash160Def();

	/**
	 *	Get the DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160GenTable getTableDbKeyHash160Gen();

	/**
	 *	Get the DbKeyHash160Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash160TypeTable getTableDbKeyHash160Type();

	/**
	 *	Get the DbKeyHash224Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash224ColTable getTableDbKeyHash224Col();

	/**
	 *	Get the DbKeyHash224Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash224DefTable getTableDbKeyHash224Def();

	/**
	 *	Get the DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash224GenTable getTableDbKeyHash224Gen();

	/**
	 *	Get the DbKeyHash224Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash224TypeTable getTableDbKeyHash224Type();

	/**
	 *	Get the DbKeyHash256Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash256ColTable getTableDbKeyHash256Col();

	/**
	 *	Get the DbKeyHash256Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash256DefTable getTableDbKeyHash256Def();

	/**
	 *	Get the DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash256GenTable getTableDbKeyHash256Gen();

	/**
	 *	Get the DbKeyHash256Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash256TypeTable getTableDbKeyHash256Type();

	/**
	 *	Get the DbKeyHash384Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash384ColTable getTableDbKeyHash384Col();

	/**
	 *	Get the DbKeyHash384Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash384DefTable getTableDbKeyHash384Def();

	/**
	 *	Get the DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash384GenTable getTableDbKeyHash384Gen();

	/**
	 *	Get the DbKeyHash384Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash384TypeTable getTableDbKeyHash384Type();

	/**
	 *	Get the DbKeyHash512Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash512ColTable getTableDbKeyHash512Col();

	/**
	 *	Get the DbKeyHash512Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash512DefTable getTableDbKeyHash512Def();

	/**
	 *	Get the DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash512GenTable getTableDbKeyHash512Gen();

	/**
	 *	Get the DbKeyHash512Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDbKeyHash512TypeTable getTableDbKeyHash512Type();

	/**
	 *	Get the DelDep Table interface for the schema.
	 *
	 *	@return	The DelDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelDepTable getTableDelDep();

	/**
	 *	Get the DelSubDep1 Table interface for the schema.
	 *
	 *	@return	The DelSubDep1 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelSubDep1Table getTableDelSubDep1();

	/**
	 *	Get the DelSubDep2 Table interface for the schema.
	 *
	 *	@return	The DelSubDep2 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelSubDep2Table getTableDelSubDep2();

	/**
	 *	Get the DelSubDep3 Table interface for the schema.
	 *
	 *	@return	The DelSubDep3 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelSubDep3Table getTableDelSubDep3();

	/**
	 *	Get the DelTopDep Table interface for the schema.
	 *
	 *	@return	The DelTopDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDelTopDepTable getTableDelTopDep();

	/**
	 *	Get the DoubleCol Table interface for the schema.
	 *
	 *	@return	The DoubleCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDoubleColTable getTableDoubleCol();

	/**
	 *	Get the DoubleDef Table interface for the schema.
	 *
	 *	@return	The DoubleDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDoubleDefTable getTableDoubleDef();

	/**
	 *	Get the DoubleType Table interface for the schema.
	 *
	 *	@return	The DoubleType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtDoubleTypeTable getTableDoubleType();

	/**
	 *	Get the EnumDef Table interface for the schema.
	 *
	 *	@return	The EnumDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtEnumDefTable getTableEnumDef();

	/**
	 *	Get the EnumTag Table interface for the schema.
	 *
	 *	@return	The EnumTag Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtEnumTagTable getTableEnumTag();

	/**
	 *	Get the EnumType Table interface for the schema.
	 *
	 *	@return	The EnumType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtEnumTypeTable getTableEnumType();

	/**
	 *	Get the FloatCol Table interface for the schema.
	 *
	 *	@return	The FloatCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtFloatColTable getTableFloatCol();

	/**
	 *	Get the FloatDef Table interface for the schema.
	 *
	 *	@return	The FloatDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtFloatDefTable getTableFloatDef();

	/**
	 *	Get the FloatType Table interface for the schema.
	 *
	 *	@return	The FloatType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtFloatTypeTable getTableFloatType();

	/**
	 *	Get the Id16Gen Table interface for the schema.
	 *
	 *	@return	The Id16Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtId16GenTable getTableId16Gen();

	/**
	 *	Get the Id32Gen Table interface for the schema.
	 *
	 *	@return	The Id32Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtId32GenTable getTableId32Gen();

	/**
	 *	Get the Id64Gen Table interface for the schema.
	 *
	 *	@return	The Id64Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtId64GenTable getTableId64Gen();

	/**
	 *	Get the Index Table interface for the schema.
	 *
	 *	@return	The Index Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtIndexTable getTableIndex();

	/**
	 *	Get the IndexCol Table interface for the schema.
	 *
	 *	@return	The IndexCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtIndexColTable getTableIndexCol();

	/**
	 *	Get the IndexTweak Table interface for the schema.
	 *
	 *	@return	The IndexTweak Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtIndexTweakTable getTableIndexTweak();

	/**
	 *	Get the Int16Col Table interface for the schema.
	 *
	 *	@return	The Int16Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt16ColTable getTableInt16Col();

	/**
	 *	Get the Int16Def Table interface for the schema.
	 *
	 *	@return	The Int16Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt16DefTable getTableInt16Def();

	/**
	 *	Get the Int16Type Table interface for the schema.
	 *
	 *	@return	The Int16Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt16TypeTable getTableInt16Type();

	/**
	 *	Get the Int32Col Table interface for the schema.
	 *
	 *	@return	The Int32Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32ColTable getTableInt32Col();

	/**
	 *	Get the Int32Def Table interface for the schema.
	 *
	 *	@return	The Int32Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32DefTable getTableInt32Def();

	/**
	 *	Get the Int32Type Table interface for the schema.
	 *
	 *	@return	The Int32Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt32TypeTable getTableInt32Type();

	/**
	 *	Get the Int64Col Table interface for the schema.
	 *
	 *	@return	The Int64Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt64ColTable getTableInt64Col();

	/**
	 *	Get the Int64Def Table interface for the schema.
	 *
	 *	@return	The Int64Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt64DefTable getTableInt64Def();

	/**
	 *	Get the Int64Type Table interface for the schema.
	 *
	 *	@return	The Int64Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtInt64TypeTable getTableInt64Type();

	/**
	 *	Get the NmTokenCol Table interface for the schema.
	 *
	 *	@return	The NmTokenCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtNmTokenColTable getTableNmTokenCol();

	/**
	 *	Get the NmTokenDef Table interface for the schema.
	 *
	 *	@return	The NmTokenDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtNmTokenDefTable getTableNmTokenDef();

	/**
	 *	Get the NmTokenType Table interface for the schema.
	 *
	 *	@return	The NmTokenType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtNmTokenTypeTable getTableNmTokenType();

	/**
	 *	Get the NmTokensCol Table interface for the schema.
	 *
	 *	@return	The NmTokensCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtNmTokensColTable getTableNmTokensCol();

	/**
	 *	Get the NmTokensDef Table interface for the schema.
	 *
	 *	@return	The NmTokensDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtNmTokensDefTable getTableNmTokensDef();

	/**
	 *	Get the NmTokensType Table interface for the schema.
	 *
	 *	@return	The NmTokensType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtNmTokensTypeTable getTableNmTokensType();

	/**
	 *	Get the NumberCol Table interface for the schema.
	 *
	 *	@return	The NumberCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtNumberColTable getTableNumberCol();

	/**
	 *	Get the NumberDef Table interface for the schema.
	 *
	 *	@return	The NumberDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtNumberDefTable getTableNumberDef();

	/**
	 *	Get the NumberType Table interface for the schema.
	 *
	 *	@return	The NumberType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtNumberTypeTable getTableNumberType();

	/**
	 *	Get the Param Table interface for the schema.
	 *
	 *	@return	The Param Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtParamTable getTableParam();

	/**
	 *	Get the PopDep Table interface for the schema.
	 *
	 *	@return	The PopDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopDepTable getTablePopDep();

	/**
	 *	Get the PopSubDep1 Table interface for the schema.
	 *
	 *	@return	The PopSubDep1 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep1Table getTablePopSubDep1();

	/**
	 *	Get the PopSubDep2 Table interface for the schema.
	 *
	 *	@return	The PopSubDep2 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep2Table getTablePopSubDep2();

	/**
	 *	Get the PopSubDep3 Table interface for the schema.
	 *
	 *	@return	The PopSubDep3 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopSubDep3Table getTablePopSubDep3();

	/**
	 *	Get the PopTopDep Table interface for the schema.
	 *
	 *	@return	The PopTopDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtPopTopDepTable getTablePopTopDep();

	/**
	 *	Get the Relation Table interface for the schema.
	 *
	 *	@return	The Relation Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtRelationTable getTableRelation();

	/**
	 *	Get the RelationCol Table interface for the schema.
	 *
	 *	@return	The RelationCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtRelationColTable getTableRelationCol();

	/**
	 *	Get the RoleDef Table interface for the schema.
	 *
	 *	@return	The RoleDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtRoleDefTable getTableRoleDef();

	/**
	 *	Get the SchemaDef Table interface for the schema.
	 *
	 *	@return	The SchemaDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtSchemaDefTable getTableSchemaDef();

	/**
	 *	Get the SchemaRef Table interface for the schema.
	 *
	 *	@return	The SchemaRef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtSchemaRefTable getTableSchemaRef();

	/**
	 *	Get the SchemaRole Table interface for the schema.
	 *
	 *	@return	The SchemaRole Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtSchemaRoleTable getTableSchemaRole();

	/**
	 *	Get the SchemaTweak Table interface for the schema.
	 *
	 *	@return	The SchemaTweak Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtSchemaTweakTable getTableSchemaTweak();

	/**
	 *	Get the Scope Table interface for the schema.
	 *
	 *	@return	The Scope Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtScopeTable getTableScope();

	/**
	 *	Get the ServerListFunc Table interface for the schema.
	 *
	 *	@return	The ServerListFunc Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtServerListFuncTable getTableServerListFunc();

	/**
	 *	Get the ServerMethod Table interface for the schema.
	 *
	 *	@return	The ServerMethod Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtServerMethodTable getTableServerMethod();

	/**
	 *	Get the ServerObjFunc Table interface for the schema.
	 *
	 *	@return	The ServerObjFunc Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtServerObjFuncTable getTableServerObjFunc();

	/**
	 *	Get the ServerProc Table interface for the schema.
	 *
	 *	@return	The ServerProc Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtServerProcTable getTableServerProc();

	/**
	 *	Get the StringCol Table interface for the schema.
	 *
	 *	@return	The StringCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtStringColTable getTableStringCol();

	/**
	 *	Get the StringDef Table interface for the schema.
	 *
	 *	@return	The StringDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtStringDefTable getTableStringDef();

	/**
	 *	Get the StringType Table interface for the schema.
	 *
	 *	@return	The StringType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtStringTypeTable getTableStringType();

	/**
	 *	Get the TZDateCol Table interface for the schema.
	 *
	 *	@return	The TZDateCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTZDateColTable getTableTZDateCol();

	/**
	 *	Get the TZDateDef Table interface for the schema.
	 *
	 *	@return	The TZDateDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTZDateDefTable getTableTZDateDef();

	/**
	 *	Get the TZDateType Table interface for the schema.
	 *
	 *	@return	The TZDateType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTZDateTypeTable getTableTZDateType();

	/**
	 *	Get the TZTimeCol Table interface for the schema.
	 *
	 *	@return	The TZTimeCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTZTimeColTable getTableTZTimeCol();

	/**
	 *	Get the TZTimeDef Table interface for the schema.
	 *
	 *	@return	The TZTimeDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTZTimeDefTable getTableTZTimeDef();

	/**
	 *	Get the TZTimeType Table interface for the schema.
	 *
	 *	@return	The TZTimeType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTZTimeTypeTable getTableTZTimeType();

	/**
	 *	Get the TZTimestampCol Table interface for the schema.
	 *
	 *	@return	The TZTimestampCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTZTimestampColTable getTableTZTimestampCol();

	/**
	 *	Get the TZTimestampDef Table interface for the schema.
	 *
	 *	@return	The TZTimestampDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTZTimestampDefTable getTableTZTimestampDef();

	/**
	 *	Get the TZTimestampType Table interface for the schema.
	 *
	 *	@return	The TZTimestampType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTZTimestampTypeTable getTableTZTimestampType();

	/**
	 *	Get the Table Table interface for the schema.
	 *
	 *	@return	The Table Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTableTable getTableTable();

	/**
	 *	Get the TableCol Table interface for the schema.
	 *
	 *	@return	The TableCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTableColTable getTableTableCol();

	/**
	 *	Get the TableTweak Table interface for the schema.
	 *
	 *	@return	The TableTweak Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTableTweakTable getTableTableTweak();

	/**
	 *	Get the TextCol Table interface for the schema.
	 *
	 *	@return	The TextCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTextColTable getTableTextCol();

	/**
	 *	Get the TextDef Table interface for the schema.
	 *
	 *	@return	The TextDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTextDefTable getTableTextDef();

	/**
	 *	Get the TextType Table interface for the schema.
	 *
	 *	@return	The TextType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTextTypeTable getTableTextType();

	/**
	 *	Get the TimeCol Table interface for the schema.
	 *
	 *	@return	The TimeCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTimeColTable getTableTimeCol();

	/**
	 *	Get the TimeDef Table interface for the schema.
	 *
	 *	@return	The TimeDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTimeDefTable getTableTimeDef();

	/**
	 *	Get the TimeType Table interface for the schema.
	 *
	 *	@return	The TimeType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTimeTypeTable getTableTimeType();

	/**
	 *	Get the TimestampCol Table interface for the schema.
	 *
	 *	@return	The TimestampCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTimestampColTable getTableTimestampCol();

	/**
	 *	Get the TimestampDef Table interface for the schema.
	 *
	 *	@return	The TimestampDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTimestampDefTable getTableTimestampDef();

	/**
	 *	Get the TimestampType Table interface for the schema.
	 *
	 *	@return	The TimestampType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTimestampTypeTable getTableTimestampType();

	/**
	 *	Get the TokenCol Table interface for the schema.
	 *
	 *	@return	The TokenCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTokenColTable getTableTokenCol();

	/**
	 *	Get the TokenDef Table interface for the schema.
	 *
	 *	@return	The TokenDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTokenDefTable getTableTokenDef();

	/**
	 *	Get the TokenType Table interface for the schema.
	 *
	 *	@return	The TokenType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTokenTypeTable getTableTokenType();

	/**
	 *	Get the Tweak Table interface for the schema.
	 *
	 *	@return	The Tweak Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtTweakTable getTableTweak();

	/**
	 *	Get the UInt16Col Table interface for the schema.
	 *
	 *	@return	The UInt16Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUInt16ColTable getTableUInt16Col();

	/**
	 *	Get the UInt16Def Table interface for the schema.
	 *
	 *	@return	The UInt16Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUInt16DefTable getTableUInt16Def();

	/**
	 *	Get the UInt16Type Table interface for the schema.
	 *
	 *	@return	The UInt16Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUInt16TypeTable getTableUInt16Type();

	/**
	 *	Get the UInt32Col Table interface for the schema.
	 *
	 *	@return	The UInt32Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUInt32ColTable getTableUInt32Col();

	/**
	 *	Get the UInt32Def Table interface for the schema.
	 *
	 *	@return	The UInt32Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUInt32DefTable getTableUInt32Def();

	/**
	 *	Get the UInt32Type Table interface for the schema.
	 *
	 *	@return	The UInt32Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUInt32TypeTable getTableUInt32Type();

	/**
	 *	Get the UInt64Col Table interface for the schema.
	 *
	 *	@return	The UInt64Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUInt64ColTable getTableUInt64Col();

	/**
	 *	Get the UInt64Def Table interface for the schema.
	 *
	 *	@return	The UInt64Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUInt64DefTable getTableUInt64Def();

	/**
	 *	Get the UInt64Type Table interface for the schema.
	 *
	 *	@return	The UInt64Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUInt64TypeTable getTableUInt64Type();

	/**
	 *	Get the Uuid6Col Table interface for the schema.
	 *
	 *	@return	The Uuid6Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUuid6ColTable getTableUuid6Col();

	/**
	 *	Get the Uuid6Def Table interface for the schema.
	 *
	 *	@return	The Uuid6Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUuid6DefTable getTableUuid6Def();

	/**
	 *	Get the Uuid6Gen Table interface for the schema.
	 *
	 *	@return	The Uuid6Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUuid6GenTable getTableUuid6Gen();

	/**
	 *	Get the Uuid6Type Table interface for the schema.
	 *
	 *	@return	The Uuid6Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUuid6TypeTable getTableUuid6Type();

	/**
	 *	Get the UuidCol Table interface for the schema.
	 *
	 *	@return	The UuidCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUuidColTable getTableUuidCol();

	/**
	 *	Get the UuidDef Table interface for the schema.
	 *
	 *	@return	The UuidDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUuidDefTable getTableUuidDef();

	/**
	 *	Get the UuidGen Table interface for the schema.
	 *
	 *	@return	The UuidGen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUuidGenTable getTableUuidGen();

	/**
	 *	Get the UuidType Table interface for the schema.
	 *
	 *	@return	The UuidType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtUuidTypeTable getTableUuidType();

	/**
	 *	Get the Value Table interface for the schema.
	 *
	 *	@return	The Value Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamProtValueTable getTableValue();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	//public static ICFSecProtTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ICFSecProtTablePerms getCFSecProtTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ICFSecProtTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ICFSecProtTablePerms value );

	public void bootstrapSchema(CFSecPubTableData tableData[]);
	public void bootstrapAllTablesSecurity(MCFDbKeyHash256 clusterId, MCFDbKeyHash256 tenantId, CFSecPubTableData tableData[]);
}
