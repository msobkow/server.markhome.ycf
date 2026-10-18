// Description: Java 25 interface for a BusModel schema.

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

package server.markhome.ycf.v3_1.busmodel.busmodel;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffSchema;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffFactoryService;
import server.markhome.ycf.v3_1.intnet.intnet.buff.IntNetBuffSchema;
import server.markhome.ycf.v3_1.intnet.intnet.buff.IntNetBuffFactoryService;
import server.markhome.ycf.v3_1.busmodel.busmodel.buff.BusModelBuffSchema;
import server.markhome.ycf.v3_1.busmodel.busmodel.buff.BusModelBuffFactoryService;

public interface IBusModelSchema
extends ISecureSchema,
	IIntNetSchema
{
	public static final String SCHEMA_NAME = "BusModel";
	public static final String DBSCHEMA_NAME = "BusModel31";
	static final AtomicReference<ApplicationContext> arApplicationContext = new AtomicReference<>(null);
	public static final SecurePubTableData TABLE_DATA[] = {new SecurePubTableData("BusModel", "Chain", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "EnumTag", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "IndexCol", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Param", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "RelationCol", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "RoleDef", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "SchemaRole", "RoleDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Scope", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "SchemaDef", "Scope", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "SchemaRef", "Scope", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "ServerMethod", "Scope", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "ServerObjFunc", "ServerMethod", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "ServerProc", "ServerMethod", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "ServerListFunc", "ServerMethod", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Table", "Scope", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "ClearDep", "Scope", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "ClearSubDep1", "ClearDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "ClearSubDep2", "ClearDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "ClearSubDep3", "ClearDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "ClearTopDep", "ClearDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DelDep", "Scope", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DelSubDep1", "DelDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DelSubDep2", "DelDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DelSubDep3", "DelDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DelTopDep", "DelDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Index", "Scope", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "PopDep", "Scope", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "PopSubDep1", "PopDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "PopSubDep2", "PopDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "PopSubDep3", "PopDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "PopTopDep", "PopDep", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Relation", "Scope", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Tweak", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TableTweak", "Tweak", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "SchemaTweak", "Tweak", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "IndexTweak", "Tweak", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Value", null, true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Atom", "Value", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "BlobDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "BlobType", "BlobDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "BlobCol", "BlobDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "BoolDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "BoolType", "BoolDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "BoolCol", "BoolDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DateDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DateType", "DateDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DateCol", "DateDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DoubleDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DoubleType", "DoubleDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DoubleCol", "DoubleDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "FloatDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "FloatType", "FloatDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "FloatCol", "FloatDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Int16Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Int16Type", "Int16Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Id16Gen", "Int16Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "EnumDef", "Int16Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "EnumType", "EnumDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Int16Col", "Int16Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Int32Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Int32Type", "Int32Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Id32Gen", "Int32Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Int32Col", "Int32Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Int64Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Int64Type", "Int64Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Id64Gen", "Int64Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Int64Col", "Int64Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "NmTokenDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "NmTokenType", "NmTokenDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "NmTokenCol", "NmTokenDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "NmTokensDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "NmTokensType", "NmTokensDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "NmTokensCol", "NmTokensDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "NumberDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "NumberType", "NumberDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "NumberCol", "NumberDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash128Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash128Col", "DbKeyHash128Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash128Type", "DbKeyHash128Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash128Gen", "DbKeyHash128Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash160Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash160Col", "DbKeyHash160Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash160Type", "DbKeyHash160Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash160Gen", "DbKeyHash160Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash224Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash224Col", "DbKeyHash224Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash224Type", "DbKeyHash224Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash224Gen", "DbKeyHash224Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash256Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash256Col", "DbKeyHash256Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash256Type", "DbKeyHash256Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash256Gen", "DbKeyHash256Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash384Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash384Col", "DbKeyHash384Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash384Type", "DbKeyHash384Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash384Gen", "DbKeyHash384Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash512Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash512Col", "DbKeyHash512Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash512Type", "DbKeyHash512Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "DbKeyHash512Gen", "DbKeyHash512Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "StringDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "StringType", "StringDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "StringCol", "StringDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TZDateDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TZDateType", "TZDateDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TZDateCol", "TZDateDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TZTimeDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TZTimeType", "TZTimeDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TZTimeCol", "TZTimeDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TZTimestampDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TZTimestampType", "TZTimestampDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TZTimestampCol", "TZTimestampDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TextDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TextType", "TextDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TextCol", "TextDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TimeDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TimeType", "TimeDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TimeCol", "TimeDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TimestampDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TimestampType", "TimestampDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TimestampCol", "TimestampDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TokenDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TokenType", "TokenDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TokenCol", "TokenDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UInt16Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UInt16Type", "UInt16Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UInt16Col", "UInt16Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UInt32Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UInt32Type", "UInt32Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UInt32Col", "UInt32Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UInt64Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UInt64Type", "UInt64Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UInt64Col", "UInt64Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UuidDef", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UuidType", "UuidDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UuidGen", "UuidType", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "UuidCol", "UuidDef", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Uuid6Def", "Atom", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Uuid6Type", "Uuid6Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Uuid6Gen", "Uuid6Type", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "Uuid6Col", "Uuid6Def", true, false, "Tenant", "Public"),
		new SecurePubTableData("BusModel", "TableCol", "Value", true, false, "Tenant", "Public")};
	public static final AtomicReference<SecurePubTableData[]> consolidatedTableData = new AtomicReference<>(null);
	public static final SecurePubRoleInfo ROLE_INFO[] = {};
	public static final AtomicReference<SecurePubRoleInfo[]> consolidatedRoleInfo = new AtomicReference<>(null);

	public static SecurePubTableData[] getTableData() {
		return TABLE_DATA;
	}

	public static SecurePubTableData[] getConsolidatedTableData() {
		if (consolidatedTableData.get() == null) {
			ArrayList<SecurePubTableData> lst = new ArrayList<>();
			for( SecurePubTableData data: ISecureSchema.getTableData()) {
				lst.add(data);
			}
			for( SecurePubTableData data: IIntNetSchema.getTableData()) {
				lst.add(data);
			}
			for( SecurePubTableData data: TABLE_DATA) {
				lst.add(data);
			}
			SecurePubTableData arr[] = new SecurePubTableData[lst.size()];
			int idx = 0;
			for(SecurePubTableData data: lst) {
				arr[idx++] = data;
			}
			consolidatedTableData.compareAndSet(null, arr);
		}
		return(consolidatedTableData.get());
	}

	public static SecurePubRoleInfo[] getRoleInfo() {
		return ROLE_INFO;
	}

	public static SecurePubRoleInfo[] getConsolidatedRoleInfo() {
		if (consolidatedRoleInfo.get() == null) {
			ArrayList<SecurePubRoleInfo> lst = new ArrayList<>();
			for( SecurePubRoleInfo info: ISecureSchema.getRoleInfo()) {
				lst.add(info);
			}
			for( SecurePubRoleInfo info: IIntNetSchema.getRoleInfo()) {
				lst.add(info);
			}
			for( SecurePubRoleInfo info: ROLE_INFO) {
				lst.add(info);
			}
			// Dependency order is the natural order of role info comparison
			lst.sort(new SecurePubRoleInfoDependencyComparator());
			SecurePubRoleInfo arr[] = new SecurePubRoleInfo[lst.size()];
			int idx = 0;
			for(SecurePubRoleInfo info: lst) {
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

		final static ArrayList<ISecureSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ISecureSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ISecureSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<IBusModelSchema> backingBusModel = new AtomicReference<>();
		public static IBusModelSchema getBackingBusModel() {
			return( IBusModelSchema.backingBusModel.get() );
		}
		
		public static void setBackingBusModel(IBusModelSchema backingSchema) {
			IBusModelSchema.backingBusModel.set(backingSchema);
		}
		
		public IBusModelSchema getBusModelSchema();
		public void setBusModelSchema(IBusModelSchema schema);

		public static int doInitClassMapEntries(int value) {
			value = ISecureSchema.doInitClassMapEntries(value);
			value = IIntNetSchema.doInitClassMapEntries(value);
			if (IBusModelSchema.entries.isEmpty()) {
				ISecureSchema.ClassMapEntry entry;
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Scope", IBusModelScope.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "SchemaDef", IBusModelSchemaDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "SchemaRef", IBusModelSchemaRef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "ServerMethod", IBusModelServerMethod.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "ServerObjFunc", IBusModelServerObjFunc.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "ServerProc", IBusModelServerProc.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Table", IBusModelTable.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Tweak", IBusModelTweak.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TableTweak", IBusModelTableTweak.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "SchemaTweak", IBusModelSchemaTweak.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "IndexTweak", IBusModelIndexTweak.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Value", IBusModelValue.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Atom", IBusModelAtom.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "BlobDef", IBusModelBlobDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "BlobType", IBusModelBlobType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "BoolDef", IBusModelBoolDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "BoolType", IBusModelBoolType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Chain", IBusModelChain.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "ClearDep", IBusModelClearDep.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "ClearSubDep1", IBusModelClearSubDep1.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "ClearSubDep2", IBusModelClearSubDep2.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "ClearSubDep3", IBusModelClearSubDep3.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "ClearTopDep", IBusModelClearTopDep.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DateDef", IBusModelDateDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DateType", IBusModelDateType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DelDep", IBusModelDelDep.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DelSubDep1", IBusModelDelSubDep1.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DelSubDep2", IBusModelDelSubDep2.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DelSubDep3", IBusModelDelSubDep3.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DelTopDep", IBusModelDelTopDep.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DoubleDef", IBusModelDoubleDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DoubleType", IBusModelDoubleType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "EnumTag", IBusModelEnumTag.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "FloatDef", IBusModelFloatDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "FloatType", IBusModelFloatType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Index", IBusModelIndex.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "IndexCol", IBusModelIndexCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Int16Def", IBusModelInt16Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Int16Type", IBusModelInt16Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Int32Def", IBusModelInt32Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Int32Type", IBusModelInt32Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Int64Def", IBusModelInt64Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Int64Type", IBusModelInt64Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "NmTokenDef", IBusModelNmTokenDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "NmTokenType", IBusModelNmTokenType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "NmTokensDef", IBusModelNmTokensDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "NmTokensType", IBusModelNmTokensType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "NumberDef", IBusModelNumberDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "NumberType", IBusModelNumberType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Param", IBusModelParam.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "PopDep", IBusModelPopDep.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "PopSubDep1", IBusModelPopSubDep1.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "PopSubDep2", IBusModelPopSubDep2.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "PopSubDep3", IBusModelPopSubDep3.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "PopTopDep", IBusModelPopTopDep.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Relation", IBusModelRelation.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "RelationCol", IBusModelRelationCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "ServerListFunc", IBusModelServerListFunc.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash128Def", IBusModelDbKeyHash128Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash128Col", IBusModelDbKeyHash128Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash128Type", IBusModelDbKeyHash128Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash128Gen", IBusModelDbKeyHash128Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash160Def", IBusModelDbKeyHash160Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash160Col", IBusModelDbKeyHash160Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash160Type", IBusModelDbKeyHash160Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash160Gen", IBusModelDbKeyHash160Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash224Def", IBusModelDbKeyHash224Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash224Col", IBusModelDbKeyHash224Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash224Type", IBusModelDbKeyHash224Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash224Gen", IBusModelDbKeyHash224Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash256Def", IBusModelDbKeyHash256Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash256Col", IBusModelDbKeyHash256Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash256Type", IBusModelDbKeyHash256Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash256Gen", IBusModelDbKeyHash256Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash384Def", IBusModelDbKeyHash384Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash384Col", IBusModelDbKeyHash384Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash384Type", IBusModelDbKeyHash384Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash384Gen", IBusModelDbKeyHash384Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash512Def", IBusModelDbKeyHash512Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash512Col", IBusModelDbKeyHash512Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash512Type", IBusModelDbKeyHash512Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DbKeyHash512Gen", IBusModelDbKeyHash512Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "StringDef", IBusModelStringDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "StringType", IBusModelStringType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TZDateDef", IBusModelTZDateDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TZDateType", IBusModelTZDateType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TZTimeDef", IBusModelTZTimeDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TZTimeType", IBusModelTZTimeType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TZTimestampDef", IBusModelTZTimestampDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TZTimestampType", IBusModelTZTimestampType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TableCol", IBusModelTableCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TextDef", IBusModelTextDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TextType", IBusModelTextType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TimeDef", IBusModelTimeDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TimeType", IBusModelTimeType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TimestampDef", IBusModelTimestampDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TimestampType", IBusModelTimestampType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TokenDef", IBusModelTokenDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TokenType", IBusModelTokenType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UInt16Def", IBusModelUInt16Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UInt16Type", IBusModelUInt16Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UInt32Def", IBusModelUInt32Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UInt32Type", IBusModelUInt32Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UInt64Def", IBusModelUInt64Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UInt64Type", IBusModelUInt64Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UuidDef", IBusModelUuidDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Uuid6Def", IBusModelUuid6Def.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UuidType", IBusModelUuidType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Uuid6Type", IBusModelUuid6Type.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "BlobCol", IBusModelBlobCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "BoolCol", IBusModelBoolCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DateCol", IBusModelDateCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "DoubleCol", IBusModelDoubleCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "EnumDef", IBusModelEnumDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "EnumType", IBusModelEnumType.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "FloatCol", IBusModelFloatCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Id16Gen", IBusModelId16Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Id32Gen", IBusModelId32Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Id64Gen", IBusModelId64Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Int16Col", IBusModelInt16Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Int32Col", IBusModelInt32Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Int64Col", IBusModelInt64Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "NmTokenCol", IBusModelNmTokenCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "NmTokensCol", IBusModelNmTokensCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "NumberCol", IBusModelNumberCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "StringCol", IBusModelStringCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TZDateCol", IBusModelTZDateCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TZTimeCol", IBusModelTZTimeCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TZTimestampCol", IBusModelTZTimestampCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TextCol", IBusModelTextCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TimeCol", IBusModelTimeCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TimestampCol", IBusModelTimestampCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "TokenCol", IBusModelTokenCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UInt16Col", IBusModelUInt16Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UInt32Col", IBusModelUInt32Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UInt64Col", IBusModelUInt64Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UuidCol", IBusModelUuidCol.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Uuid6Col", IBusModelUuid6Col.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "UuidGen", IBusModelUuidGen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "Uuid6Gen", IBusModelUuid6Gen.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "RoleDef", IBusModelRoleDef.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				entry = new ISecureSchema.ClassMapEntry(IBusModelSchema.SCHEMA_NAME, "SchemaRole", IBusModelSchemaRole.CLASS_CODE);
				IBusModelSchema.entries.add(entry);
				for( ISecureSchema.ClassMapEntry cur: IBusModelSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				IBusModelSchema.mapBackingClassCodeToEntry.clear();
				IBusModelSchema.mapRuntimeClassCodeToEntry.clear();
				for( ISecureSchema.ClassMapEntry cur: IBusModelSchema.entries) {
					IBusModelSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					IBusModelSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ISecureSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ISecureSchema.ClassMapEntry entry;
			entry = ISecureSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IIntNetSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IBusModelSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ISecureSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ISecureSchema.ClassMapEntry entry;
			entry = ISecureSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IIntNetSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IBusModelSchema.mapRuntimeClassCodeToEntry.get(code);
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
	 *	@return	A new ISecureSchema instance.
	 */
	public ISecureSchema newSchema();

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen();

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen();

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen();

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen();

	/**
	 *	Get the next TableInfoIdGen identifier.
	 *
	 *	@return	The next TableInfoIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextTableInfoIdGen();

	/**
	 *	Get the next MimeTypeIdGen identifier.
	 *
	 *	@return	The next MimeTypeIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextMimeTypeIdGen();

	/**
	 *	Get the next URLProtocolIdGen identifier.
	 *
	 *	@return	The next URLProtocolIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public int nextURLProtocolIdGen();

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextClusterIdGen();

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSessionIdGen();

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecUserIdGen();

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTenantIdGen();

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecSysGrpIdGen();

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusGrpIdGen();

	/**
	 *	Get the next SecClusRoleIdGen identifier.
	 *
	 *	@return	The next SecClusRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecClusRoleIdGen();

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentGrpIdGen();

	/**
	 *	Get the next SecTentRoleIdGen identifier.
	 *
	 *	@return	The next SecTentRoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSecTentRoleIdGen();

	/**
	 *	Get the next MajorVersionIdGen identifier.
	 *
	 *	@return	The next MajorVersionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextMajorVersionIdGen();

	/**
	 *	Get the next MinorVersionIdGen identifier.
	 *
	 *	@return	The next MinorVersionIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextMinorVersionIdGen();

	/**
	 *	Get the next SubProjectIdGen identifier.
	 *
	 *	@return	The next SubProjectIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextSubProjectIdGen();

	/**
	 *	Get the next TldIdGen identifier.
	 *
	 *	@return	The next TldIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTldIdGen();

	/**
	 *	Get the next TopDomainIdGen identifier.
	 *
	 *	@return	The next TopDomainIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTopDomainIdGen();

	/**
	 *	Get the next TopProjectIdGen identifier.
	 *
	 *	@return	The next TopProjectIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTopProjectIdGen();

	/**
	 *	Get the next LicenseIdGen identifier.
	 *
	 *	@return	The next LicenseIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextLicenseIdGen();

	/**
	 *	Get the next ChainIdGen identifier.
	 *
	 *	@return	The next ChainIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextChainIdGen();

	/**
	 *	Get the next EnumTagIdGen identifier.
	 *
	 *	@return	The next EnumTagIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextEnumTagIdGen();

	/**
	 *	Get the next IndexColIdGen identifier.
	 *
	 *	@return	The next IndexColIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextIndexColIdGen();

	/**
	 *	Get the next ParamIdGen identifier.
	 *
	 *	@return	The next ParamIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextParamIdGen();

	/**
	 *	Get the next RelationColIdGen identifier.
	 *
	 *	@return	The next RelationColIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextRelationColIdGen();

	/**
	 *	Get the next TweakIdGen identifier.
	 *
	 *	@return	The next TweakIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextTweakIdGen();

	/**
	 *	Get the next ScopeIdGen identifier.
	 *
	 *	@return	The next ScopeIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextScopeIdGen();

	/**
	 *	Get the next ValueIdGen identifier.
	 *
	 *	@return	The next ValueIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextValueIdGen();

	/**
	 *	Get the next RoleIdGen identifier.
	 *
	 *	@return	The next RoleIdGen identifier.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public YCFDbKeyHash256 nextRoleIdGen();

	/**
	 *	Get the factory for Secure data objects.
	 */
	public ISecureFactory getSecureFactory();

	/**
	 *	Get the buffer factory for Secure data buffers.
	 */
	public SecureBuffFactoryService getSecureBuffFactory();

	/**
	 *	Get the factory for IntNet data objects.
	 */
	public IIntNetFactory getIntNetFactory();

	/**
	 *	Get the buffer factory for IntNet data buffers.
	 */
	public IntNetBuffFactoryService getIntNetBuffFactory();

	/**
	 *	Get the factory for BusModel data objects.
	 */
	public IBusModelFactory getBusModelFactory();

	/**
	 *	Get the buffer factory for BusModel data buffers.
	 */
	public BusModelBuffFactoryService getBusModelBuffFactory();

	/**
	 *	Get the Atom Table interface for the schema.
	 *
	 *	@return	The Atom Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelAtomTable getTableAtom();

	/**
	 *	Get the BlobCol Table interface for the schema.
	 *
	 *	@return	The BlobCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelBlobColTable getTableBlobCol();

	/**
	 *	Get the BlobDef Table interface for the schema.
	 *
	 *	@return	The BlobDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelBlobDefTable getTableBlobDef();

	/**
	 *	Get the BlobType Table interface for the schema.
	 *
	 *	@return	The BlobType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelBlobTypeTable getTableBlobType();

	/**
	 *	Get the BoolCol Table interface for the schema.
	 *
	 *	@return	The BoolCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelBoolColTable getTableBoolCol();

	/**
	 *	Get the BoolDef Table interface for the schema.
	 *
	 *	@return	The BoolDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelBoolDefTable getTableBoolDef();

	/**
	 *	Get the BoolType Table interface for the schema.
	 *
	 *	@return	The BoolType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelBoolTypeTable getTableBoolType();

	/**
	 *	Get the Chain Table interface for the schema.
	 *
	 *	@return	The Chain Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelChainTable getTableChain();

	/**
	 *	Get the ClearDep Table interface for the schema.
	 *
	 *	@return	The ClearDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelClearDepTable getTableClearDep();

	/**
	 *	Get the ClearSubDep1 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep1 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelClearSubDep1Table getTableClearSubDep1();

	/**
	 *	Get the ClearSubDep2 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep2 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelClearSubDep2Table getTableClearSubDep2();

	/**
	 *	Get the ClearSubDep3 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep3 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelClearSubDep3Table getTableClearSubDep3();

	/**
	 *	Get the ClearTopDep Table interface for the schema.
	 *
	 *	@return	The ClearTopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelClearTopDepTable getTableClearTopDep();

	/**
	 *	Get the Cluster Table interface for the schema.
	 *
	 *	@return	The Cluster Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureClusterTable getTableCluster();

	/**
	 *	Get the DateCol Table interface for the schema.
	 *
	 *	@return	The DateCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDateColTable getTableDateCol();

	/**
	 *	Get the DateDef Table interface for the schema.
	 *
	 *	@return	The DateDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDateDefTable getTableDateDef();

	/**
	 *	Get the DateType Table interface for the schema.
	 *
	 *	@return	The DateType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDateTypeTable getTableDateType();

	/**
	 *	Get the DbKeyHash128Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash128ColTable getTableDbKeyHash128Col();

	/**
	 *	Get the DbKeyHash128Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash128DefTable getTableDbKeyHash128Def();

	/**
	 *	Get the DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash128GenTable getTableDbKeyHash128Gen();

	/**
	 *	Get the DbKeyHash128Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash128TypeTable getTableDbKeyHash128Type();

	/**
	 *	Get the DbKeyHash160Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash160ColTable getTableDbKeyHash160Col();

	/**
	 *	Get the DbKeyHash160Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash160DefTable getTableDbKeyHash160Def();

	/**
	 *	Get the DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash160GenTable getTableDbKeyHash160Gen();

	/**
	 *	Get the DbKeyHash160Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash160TypeTable getTableDbKeyHash160Type();

	/**
	 *	Get the DbKeyHash224Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash224ColTable getTableDbKeyHash224Col();

	/**
	 *	Get the DbKeyHash224Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash224DefTable getTableDbKeyHash224Def();

	/**
	 *	Get the DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash224GenTable getTableDbKeyHash224Gen();

	/**
	 *	Get the DbKeyHash224Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash224TypeTable getTableDbKeyHash224Type();

	/**
	 *	Get the DbKeyHash256Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash256ColTable getTableDbKeyHash256Col();

	/**
	 *	Get the DbKeyHash256Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash256DefTable getTableDbKeyHash256Def();

	/**
	 *	Get the DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash256GenTable getTableDbKeyHash256Gen();

	/**
	 *	Get the DbKeyHash256Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash256TypeTable getTableDbKeyHash256Type();

	/**
	 *	Get the DbKeyHash384Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash384ColTable getTableDbKeyHash384Col();

	/**
	 *	Get the DbKeyHash384Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash384DefTable getTableDbKeyHash384Def();

	/**
	 *	Get the DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash384GenTable getTableDbKeyHash384Gen();

	/**
	 *	Get the DbKeyHash384Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash384TypeTable getTableDbKeyHash384Type();

	/**
	 *	Get the DbKeyHash512Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash512ColTable getTableDbKeyHash512Col();

	/**
	 *	Get the DbKeyHash512Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash512DefTable getTableDbKeyHash512Def();

	/**
	 *	Get the DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash512GenTable getTableDbKeyHash512Gen();

	/**
	 *	Get the DbKeyHash512Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDbKeyHash512TypeTable getTableDbKeyHash512Type();

	/**
	 *	Get the DelDep Table interface for the schema.
	 *
	 *	@return	The DelDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDelDepTable getTableDelDep();

	/**
	 *	Get the DelSubDep1 Table interface for the schema.
	 *
	 *	@return	The DelSubDep1 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDelSubDep1Table getTableDelSubDep1();

	/**
	 *	Get the DelSubDep2 Table interface for the schema.
	 *
	 *	@return	The DelSubDep2 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDelSubDep2Table getTableDelSubDep2();

	/**
	 *	Get the DelSubDep3 Table interface for the schema.
	 *
	 *	@return	The DelSubDep3 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDelSubDep3Table getTableDelSubDep3();

	/**
	 *	Get the DelTopDep Table interface for the schema.
	 *
	 *	@return	The DelTopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDelTopDepTable getTableDelTopDep();

	/**
	 *	Get the DoubleCol Table interface for the schema.
	 *
	 *	@return	The DoubleCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDoubleColTable getTableDoubleCol();

	/**
	 *	Get the DoubleDef Table interface for the schema.
	 *
	 *	@return	The DoubleDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDoubleDefTable getTableDoubleDef();

	/**
	 *	Get the DoubleType Table interface for the schema.
	 *
	 *	@return	The DoubleType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelDoubleTypeTable getTableDoubleType();

	/**
	 *	Get the EnumDef Table interface for the schema.
	 *
	 *	@return	The EnumDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelEnumDefTable getTableEnumDef();

	/**
	 *	Get the EnumTag Table interface for the schema.
	 *
	 *	@return	The EnumTag Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelEnumTagTable getTableEnumTag();

	/**
	 *	Get the EnumType Table interface for the schema.
	 *
	 *	@return	The EnumType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelEnumTypeTable getTableEnumType();

	/**
	 *	Get the FloatCol Table interface for the schema.
	 *
	 *	@return	The FloatCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelFloatColTable getTableFloatCol();

	/**
	 *	Get the FloatDef Table interface for the schema.
	 *
	 *	@return	The FloatDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelFloatDefTable getTableFloatDef();

	/**
	 *	Get the FloatType Table interface for the schema.
	 *
	 *	@return	The FloatType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelFloatTypeTable getTableFloatType();

	/**
	 *	Get the ISOCcy Table interface for the schema.
	 *
	 *	@return	The ISOCcy Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOCcyTable getTableISOCcy();

	/**
	 *	Get the ISOCtry Table interface for the schema.
	 *
	 *	@return	The ISOCtry Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOCtryTable getTableISOCtry();

	/**
	 *	Get the ISOCtryCcy Table interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOCtryCcyTable getTableISOCtryCcy();

	/**
	 *	Get the ISOCtryLang Table interface for the schema.
	 *
	 *	@return	The ISOCtryLang Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOCtryLangTable getTableISOCtryLang();

	/**
	 *	Get the ISOLang Table interface for the schema.
	 *
	 *	@return	The ISOLang Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOLangTable getTableISOLang();

	/**
	 *	Get the ISOTZone Table interface for the schema.
	 *
	 *	@return	The ISOTZone Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureISOTZoneTable getTableISOTZone();

	/**
	 *	Get the Id16Gen Table interface for the schema.
	 *
	 *	@return	The Id16Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelId16GenTable getTableId16Gen();

	/**
	 *	Get the Id32Gen Table interface for the schema.
	 *
	 *	@return	The Id32Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelId32GenTable getTableId32Gen();

	/**
	 *	Get the Id64Gen Table interface for the schema.
	 *
	 *	@return	The Id64Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelId64GenTable getTableId64Gen();

	/**
	 *	Get the Index Table interface for the schema.
	 *
	 *	@return	The Index Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelIndexTable getTableIndex();

	/**
	 *	Get the IndexCol Table interface for the schema.
	 *
	 *	@return	The IndexCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelIndexColTable getTableIndexCol();

	/**
	 *	Get the IndexTweak Table interface for the schema.
	 *
	 *	@return	The IndexTweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelIndexTweakTable getTableIndexTweak();

	/**
	 *	Get the Int16Col Table interface for the schema.
	 *
	 *	@return	The Int16Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelInt16ColTable getTableInt16Col();

	/**
	 *	Get the Int16Def Table interface for the schema.
	 *
	 *	@return	The Int16Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelInt16DefTable getTableInt16Def();

	/**
	 *	Get the Int16Type Table interface for the schema.
	 *
	 *	@return	The Int16Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelInt16TypeTable getTableInt16Type();

	/**
	 *	Get the Int32Col Table interface for the schema.
	 *
	 *	@return	The Int32Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelInt32ColTable getTableInt32Col();

	/**
	 *	Get the Int32Def Table interface for the schema.
	 *
	 *	@return	The Int32Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelInt32DefTable getTableInt32Def();

	/**
	 *	Get the Int32Type Table interface for the schema.
	 *
	 *	@return	The Int32Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelInt32TypeTable getTableInt32Type();

	/**
	 *	Get the Int64Col Table interface for the schema.
	 *
	 *	@return	The Int64Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelInt64ColTable getTableInt64Col();

	/**
	 *	Get the Int64Def Table interface for the schema.
	 *
	 *	@return	The Int64Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelInt64DefTable getTableInt64Def();

	/**
	 *	Get the Int64Type Table interface for the schema.
	 *
	 *	@return	The Int64Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelInt64TypeTable getTableInt64Type();

	/**
	 *	Get the License Table interface for the schema.
	 *
	 *	@return	The License Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetLicenseTable getTableLicense();

	/**
	 *	Get the MajorVersion Table interface for the schema.
	 *
	 *	@return	The MajorVersion Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetMajorVersionTable getTableMajorVersion();

	/**
	 *	Get the MimeType Table interface for the schema.
	 *
	 *	@return	The MimeType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetMimeTypeTable getTableMimeType();

	/**
	 *	Get the MinorVersion Table interface for the schema.
	 *
	 *	@return	The MinorVersion Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetMinorVersionTable getTableMinorVersion();

	/**
	 *	Get the NmTokenCol Table interface for the schema.
	 *
	 *	@return	The NmTokenCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelNmTokenColTable getTableNmTokenCol();

	/**
	 *	Get the NmTokenDef Table interface for the schema.
	 *
	 *	@return	The NmTokenDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelNmTokenDefTable getTableNmTokenDef();

	/**
	 *	Get the NmTokenType Table interface for the schema.
	 *
	 *	@return	The NmTokenType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelNmTokenTypeTable getTableNmTokenType();

	/**
	 *	Get the NmTokensCol Table interface for the schema.
	 *
	 *	@return	The NmTokensCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelNmTokensColTable getTableNmTokensCol();

	/**
	 *	Get the NmTokensDef Table interface for the schema.
	 *
	 *	@return	The NmTokensDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelNmTokensDefTable getTableNmTokensDef();

	/**
	 *	Get the NmTokensType Table interface for the schema.
	 *
	 *	@return	The NmTokensType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelNmTokensTypeTable getTableNmTokensType();

	/**
	 *	Get the NumberCol Table interface for the schema.
	 *
	 *	@return	The NumberCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelNumberColTable getTableNumberCol();

	/**
	 *	Get the NumberDef Table interface for the schema.
	 *
	 *	@return	The NumberDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelNumberDefTable getTableNumberDef();

	/**
	 *	Get the NumberType Table interface for the schema.
	 *
	 *	@return	The NumberType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelNumberTypeTable getTableNumberType();

	/**
	 *	Get the Param Table interface for the schema.
	 *
	 *	@return	The Param Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelParamTable getTableParam();

	/**
	 *	Get the PopDep Table interface for the schema.
	 *
	 *	@return	The PopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPopDepTable getTablePopDep();

	/**
	 *	Get the PopSubDep1 Table interface for the schema.
	 *
	 *	@return	The PopSubDep1 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPopSubDep1Table getTablePopSubDep1();

	/**
	 *	Get the PopSubDep2 Table interface for the schema.
	 *
	 *	@return	The PopSubDep2 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPopSubDep2Table getTablePopSubDep2();

	/**
	 *	Get the PopSubDep3 Table interface for the schema.
	 *
	 *	@return	The PopSubDep3 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPopSubDep3Table getTablePopSubDep3();

	/**
	 *	Get the PopTopDep Table interface for the schema.
	 *
	 *	@return	The PopTopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPopTopDepTable getTablePopTopDep();

	/**
	 *	Get the Relation Table interface for the schema.
	 *
	 *	@return	The Relation Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelRelationTable getTableRelation();

	/**
	 *	Get the RelationCol Table interface for the schema.
	 *
	 *	@return	The RelationCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelRelationColTable getTableRelationCol();

	/**
	 *	Get the RoleDef Table interface for the schema.
	 *
	 *	@return	The RoleDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelRoleDefTable getTableRoleDef();

	/**
	 *	Get the SchemaDef Table interface for the schema.
	 *
	 *	@return	The SchemaDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelSchemaDefTable getTableSchemaDef();

	/**
	 *	Get the SchemaRef Table interface for the schema.
	 *
	 *	@return	The SchemaRef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelSchemaRefTable getTableSchemaRef();

	/**
	 *	Get the SchemaRole Table interface for the schema.
	 *
	 *	@return	The SchemaRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelSchemaRoleTable getTableSchemaRole();

	/**
	 *	Get the SchemaTweak Table interface for the schema.
	 *
	 *	@return	The SchemaTweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelSchemaTweakTable getTableSchemaTweak();

	/**
	 *	Get the Scope Table interface for the schema.
	 *
	 *	@return	The Scope Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelScopeTable getTableScope();

	/**
	 *	Get the SecClusGrp Table interface for the schema.
	 *
	 *	@return	The SecClusGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecClusGrpTable getTableSecClusGrp();

	/**
	 *	Get the SecClusGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecClusGrpMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecClusGrpMembTable getTableSecClusGrpMemb();

	/**
	 *	Get the SecClusRole Table interface for the schema.
	 *
	 *	@return	The SecClusRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecClusRoleTable getTableSecClusRole();

	/**
	 *	Get the SecClusRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecClusRoleMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecClusRoleMembTable getTableSecClusRoleMemb();

	/**
	 *	Get the SecSession Table interface for the schema.
	 *
	 *	@return	The SecSession Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSessionTable getTableSecSession();

	/**
	 *	Get the SecSysGrp Table interface for the schema.
	 *
	 *	@return	The SecSysGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysGrpTable getTableSecSysGrp();

	/**
	 *	Get the SecSysGrpInc Table interface for the schema.
	 *
	 *	@return	The SecSysGrpInc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysGrpIncTable getTableSecSysGrpInc();

	/**
	 *	Get the SecSysGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecSysGrpMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysGrpMembTable getTableSecSysGrpMemb();

	/**
	 *	Get the SecSysRole Table interface for the schema.
	 *
	 *	@return	The SecSysRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysRoleTable getTableSecSysRole();

	/**
	 *	Get the SecSysRoleEnables Table interface for the schema.
	 *
	 *	@return	The SecSysRoleEnables Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysRoleEnablesTable getTableSecSysRoleEnables();

	/**
	 *	Get the SecSysRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecSysRoleMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecSysRoleMembTable getTableSecSysRoleMemb();

	/**
	 *	Get the SecTentGrp Table interface for the schema.
	 *
	 *	@return	The SecTentGrp Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecTentGrpTable getTableSecTentGrp();

	/**
	 *	Get the SecTentGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecTentGrpMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecTentGrpMembTable getTableSecTentGrpMemb();

	/**
	 *	Get the SecTentRole Table interface for the schema.
	 *
	 *	@return	The SecTentRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecTentRoleTable getTableSecTentRole();

	/**
	 *	Get the SecTentRoleMemb Table interface for the schema.
	 *
	 *	@return	The SecTentRoleMemb Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecTentRoleMembTable getTableSecTentRoleMemb();

	/**
	 *	Get the SecUser Table interface for the schema.
	 *
	 *	@return	The SecUser Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserTable getTableSecUser();

	/**
	 *	Get the SecUserEMConf Table interface for the schema.
	 *
	 *	@return	The SecUserEMConf Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserEMConfTable getTableSecUserEMConf();

	/**
	 *	Get the SecUserPWHistory Table interface for the schema.
	 *
	 *	@return	The SecUserPWHistory Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserPWHistoryTable getTableSecUserPWHistory();

	/**
	 *	Get the SecUserPWReset Table interface for the schema.
	 *
	 *	@return	The SecUserPWReset Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserPWResetTable getTableSecUserPWReset();

	/**
	 *	Get the SecUserPassword Table interface for the schema.
	 *
	 *	@return	The SecUserPassword Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSecUserPasswordTable getTableSecUserPassword();

	/**
	 *	Get the ServerListFunc Table interface for the schema.
	 *
	 *	@return	The ServerListFunc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelServerListFuncTable getTableServerListFunc();

	/**
	 *	Get the ServerMethod Table interface for the schema.
	 *
	 *	@return	The ServerMethod Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelServerMethodTable getTableServerMethod();

	/**
	 *	Get the ServerObjFunc Table interface for the schema.
	 *
	 *	@return	The ServerObjFunc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelServerObjFuncTable getTableServerObjFunc();

	/**
	 *	Get the ServerProc Table interface for the schema.
	 *
	 *	@return	The ServerProc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelServerProcTable getTableServerProc();

	/**
	 *	Get the StringCol Table interface for the schema.
	 *
	 *	@return	The StringCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelStringColTable getTableStringCol();

	/**
	 *	Get the StringDef Table interface for the schema.
	 *
	 *	@return	The StringDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelStringDefTable getTableStringDef();

	/**
	 *	Get the StringType Table interface for the schema.
	 *
	 *	@return	The StringType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelStringTypeTable getTableStringType();

	/**
	 *	Get the SubProject Table interface for the schema.
	 *
	 *	@return	The SubProject Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetSubProjectTable getTableSubProject();

	/**
	 *	Get the SysCluster Table interface for the schema.
	 *
	 *	@return	The SysCluster Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureSysClusterTable getTableSysCluster();

	/**
	 *	Get the TZDateCol Table interface for the schema.
	 *
	 *	@return	The TZDateCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTZDateColTable getTableTZDateCol();

	/**
	 *	Get the TZDateDef Table interface for the schema.
	 *
	 *	@return	The TZDateDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTZDateDefTable getTableTZDateDef();

	/**
	 *	Get the TZDateType Table interface for the schema.
	 *
	 *	@return	The TZDateType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTZDateTypeTable getTableTZDateType();

	/**
	 *	Get the TZTimeCol Table interface for the schema.
	 *
	 *	@return	The TZTimeCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTZTimeColTable getTableTZTimeCol();

	/**
	 *	Get the TZTimeDef Table interface for the schema.
	 *
	 *	@return	The TZTimeDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTZTimeDefTable getTableTZTimeDef();

	/**
	 *	Get the TZTimeType Table interface for the schema.
	 *
	 *	@return	The TZTimeType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTZTimeTypeTable getTableTZTimeType();

	/**
	 *	Get the TZTimestampCol Table interface for the schema.
	 *
	 *	@return	The TZTimestampCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTZTimestampColTable getTableTZTimestampCol();

	/**
	 *	Get the TZTimestampDef Table interface for the schema.
	 *
	 *	@return	The TZTimestampDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTZTimestampDefTable getTableTZTimestampDef();

	/**
	 *	Get the TZTimestampType Table interface for the schema.
	 *
	 *	@return	The TZTimestampType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTZTimestampTypeTable getTableTZTimestampType();

	/**
	 *	Get the Table Table interface for the schema.
	 *
	 *	@return	The Table Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTableTable getTableTable();

	/**
	 *	Get the TableCol Table interface for the schema.
	 *
	 *	@return	The TableCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTableColTable getTableTableCol();

	/**
	 *	Get the TableInfo Table interface for the schema.
	 *
	 *	@return	The TableInfo Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureTableInfoTable getTableTableInfo();

	/**
	 *	Get the TableTweak Table interface for the schema.
	 *
	 *	@return	The TableTweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTableTweakTable getTableTableTweak();

	/**
	 *	Get the Tenant Table interface for the schema.
	 *
	 *	@return	The Tenant Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public ISecureTenantTable getTableTenant();

	/**
	 *	Get the TextCol Table interface for the schema.
	 *
	 *	@return	The TextCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTextColTable getTableTextCol();

	/**
	 *	Get the TextDef Table interface for the schema.
	 *
	 *	@return	The TextDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTextDefTable getTableTextDef();

	/**
	 *	Get the TextType Table interface for the schema.
	 *
	 *	@return	The TextType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTextTypeTable getTableTextType();

	/**
	 *	Get the TimeCol Table interface for the schema.
	 *
	 *	@return	The TimeCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTimeColTable getTableTimeCol();

	/**
	 *	Get the TimeDef Table interface for the schema.
	 *
	 *	@return	The TimeDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTimeDefTable getTableTimeDef();

	/**
	 *	Get the TimeType Table interface for the schema.
	 *
	 *	@return	The TimeType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTimeTypeTable getTableTimeType();

	/**
	 *	Get the TimestampCol Table interface for the schema.
	 *
	 *	@return	The TimestampCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTimestampColTable getTableTimestampCol();

	/**
	 *	Get the TimestampDef Table interface for the schema.
	 *
	 *	@return	The TimestampDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTimestampDefTable getTableTimestampDef();

	/**
	 *	Get the TimestampType Table interface for the schema.
	 *
	 *	@return	The TimestampType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTimestampTypeTable getTableTimestampType();

	/**
	 *	Get the Tld Table interface for the schema.
	 *
	 *	@return	The Tld Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetTldTable getTableTld();

	/**
	 *	Get the TokenCol Table interface for the schema.
	 *
	 *	@return	The TokenCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTokenColTable getTableTokenCol();

	/**
	 *	Get the TokenDef Table interface for the schema.
	 *
	 *	@return	The TokenDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTokenDefTable getTableTokenDef();

	/**
	 *	Get the TokenType Table interface for the schema.
	 *
	 *	@return	The TokenType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTokenTypeTable getTableTokenType();

	/**
	 *	Get the TopDomain Table interface for the schema.
	 *
	 *	@return	The TopDomain Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetTopDomainTable getTableTopDomain();

	/**
	 *	Get the TopProject Table interface for the schema.
	 *
	 *	@return	The TopProject Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetTopProjectTable getTableTopProject();

	/**
	 *	Get the Tweak Table interface for the schema.
	 *
	 *	@return	The Tweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelTweakTable getTableTweak();

	/**
	 *	Get the UInt16Col Table interface for the schema.
	 *
	 *	@return	The UInt16Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUInt16ColTable getTableUInt16Col();

	/**
	 *	Get the UInt16Def Table interface for the schema.
	 *
	 *	@return	The UInt16Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUInt16DefTable getTableUInt16Def();

	/**
	 *	Get the UInt16Type Table interface for the schema.
	 *
	 *	@return	The UInt16Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUInt16TypeTable getTableUInt16Type();

	/**
	 *	Get the UInt32Col Table interface for the schema.
	 *
	 *	@return	The UInt32Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUInt32ColTable getTableUInt32Col();

	/**
	 *	Get the UInt32Def Table interface for the schema.
	 *
	 *	@return	The UInt32Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUInt32DefTable getTableUInt32Def();

	/**
	 *	Get the UInt32Type Table interface for the schema.
	 *
	 *	@return	The UInt32Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUInt32TypeTable getTableUInt32Type();

	/**
	 *	Get the UInt64Col Table interface for the schema.
	 *
	 *	@return	The UInt64Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUInt64ColTable getTableUInt64Col();

	/**
	 *	Get the UInt64Def Table interface for the schema.
	 *
	 *	@return	The UInt64Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUInt64DefTable getTableUInt64Def();

	/**
	 *	Get the UInt64Type Table interface for the schema.
	 *
	 *	@return	The UInt64Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUInt64TypeTable getTableUInt64Type();

	/**
	 *	Get the URLProtocol Table interface for the schema.
	 *
	 *	@return	The URLProtocol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IIntNetURLProtocolTable getTableURLProtocol();

	/**
	 *	Get the Uuid6Col Table interface for the schema.
	 *
	 *	@return	The Uuid6Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUuid6ColTable getTableUuid6Col();

	/**
	 *	Get the Uuid6Def Table interface for the schema.
	 *
	 *	@return	The Uuid6Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUuid6DefTable getTableUuid6Def();

	/**
	 *	Get the Uuid6Gen Table interface for the schema.
	 *
	 *	@return	The Uuid6Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUuid6GenTable getTableUuid6Gen();

	/**
	 *	Get the Uuid6Type Table interface for the schema.
	 *
	 *	@return	The Uuid6Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUuid6TypeTable getTableUuid6Type();

	/**
	 *	Get the UuidCol Table interface for the schema.
	 *
	 *	@return	The UuidCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUuidColTable getTableUuidCol();

	/**
	 *	Get the UuidDef Table interface for the schema.
	 *
	 *	@return	The UuidDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUuidDefTable getTableUuidDef();

	/**
	 *	Get the UuidGen Table interface for the schema.
	 *
	 *	@return	The UuidGen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUuidGenTable getTableUuidGen();

	/**
	 *	Get the UuidType Table interface for the schema.
	 *
	 *	@return	The UuidType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelUuidTypeTable getTableUuidType();

	/**
	 *	Get the Value Table interface for the schema.
	 *
	 *	@return	The Value Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelValueTable getTableValue();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static ISecureTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ISecureTablePerms getSecureTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ISecureTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ISecureTablePerms value );

	public void bootstrapSchema(SecurePubTableData tableData[]);
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]);
}
