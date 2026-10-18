// Description: Java 25 protected interface for a BusModel schema.

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

package server.markhome.ycf.v3_1.busmodel.busmodelprot;

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

//import server.markhome.ycf.v3_1.secure.secureprot.buff.SecureProtBuffFactoryService;
//import server.markhome.ycf.v3_1.intnet.intnetprot.buff.IntNetProtBuffFactoryService;
//import server.markhome.ycf.v3_1.busmodel.busmodelprot.buff.BusModelProtBuffSchema;
//import server.markhome.ycf.v3_1.busmodel.busmodelprot.buff.BusModelProtBuffFactoryService;

public interface IBusModelProtSchema
extends ISecureProtSchema,
	IIntNetProtSchema
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
			for( SecurePubTableData data: ISecureProtSchema.getTableData()) {
				lst.add(data);
			}
			for( SecurePubTableData data: IIntNetProtSchema.getTableData()) {
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
			for( SecurePubRoleInfo info: ISecureProtSchema.getRoleInfo()) {
				lst.add(info);
			}
			for( SecurePubRoleInfo info: IIntNetProtSchema.getRoleInfo()) {
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

		final static ArrayList<ISecureProtSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ISecureProtSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ISecureProtSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<IBusModelProtSchema> backingBusModel = new AtomicReference<>();
		public static IBusModelProtSchema getBackingBusModel() {
			return( IBusModelProtSchema.backingBusModel.get() );
		}
		
		public static void setBackingBusModel(IBusModelProtSchema backingSchema) {
			IBusModelProtSchema.backingBusModel.set(backingSchema);
		}
		
		public IBusModelProtSchema getBusModelSchema();
		public void setBusModelSchema(IBusModelProtSchema schema);
		
		public static int doInitClassMapEntries(int value) {
			value = ISecureProtSchema.doInitClassMapEntries(value);
			value = IIntNetProtSchema.doInitClassMapEntries(value);
			if (IBusModelProtSchema.entries.isEmpty()) {
				ISecureProtSchema.ClassMapEntry entry;
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Atom", IBusModelProtAtom.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "BlobCol", IBusModelProtBlobCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "BlobDef", IBusModelProtBlobDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "BlobType", IBusModelProtBlobType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "BoolCol", IBusModelProtBoolCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "BoolDef", IBusModelProtBoolDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "BoolType", IBusModelProtBoolType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Chain", IBusModelProtChain.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "ClearDep", IBusModelProtClearDep.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "ClearSubDep1", IBusModelProtClearSubDep1.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "ClearSubDep2", IBusModelProtClearSubDep2.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "ClearSubDep3", IBusModelProtClearSubDep3.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "ClearTopDep", IBusModelProtClearTopDep.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DateCol", IBusModelProtDateCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DateDef", IBusModelProtDateDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DateType", IBusModelProtDateType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash128Col", IBusModelProtDbKeyHash128Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash128Def", IBusModelProtDbKeyHash128Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash128Gen", IBusModelProtDbKeyHash128Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash128Type", IBusModelProtDbKeyHash128Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash160Col", IBusModelProtDbKeyHash160Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash160Def", IBusModelProtDbKeyHash160Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash160Gen", IBusModelProtDbKeyHash160Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash160Type", IBusModelProtDbKeyHash160Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash224Col", IBusModelProtDbKeyHash224Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash224Def", IBusModelProtDbKeyHash224Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash224Gen", IBusModelProtDbKeyHash224Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash224Type", IBusModelProtDbKeyHash224Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash256Col", IBusModelProtDbKeyHash256Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash256Def", IBusModelProtDbKeyHash256Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash256Gen", IBusModelProtDbKeyHash256Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash256Type", IBusModelProtDbKeyHash256Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash384Col", IBusModelProtDbKeyHash384Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash384Def", IBusModelProtDbKeyHash384Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash384Gen", IBusModelProtDbKeyHash384Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash384Type", IBusModelProtDbKeyHash384Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash512Col", IBusModelProtDbKeyHash512Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash512Def", IBusModelProtDbKeyHash512Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash512Gen", IBusModelProtDbKeyHash512Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DbKeyHash512Type", IBusModelProtDbKeyHash512Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DelDep", IBusModelProtDelDep.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DelSubDep1", IBusModelProtDelSubDep1.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DelSubDep2", IBusModelProtDelSubDep2.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DelSubDep3", IBusModelProtDelSubDep3.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DelTopDep", IBusModelProtDelTopDep.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DoubleCol", IBusModelProtDoubleCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DoubleDef", IBusModelProtDoubleDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "DoubleType", IBusModelProtDoubleType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "EnumDef", IBusModelProtEnumDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "EnumTag", IBusModelProtEnumTag.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "EnumType", IBusModelProtEnumType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "FloatCol", IBusModelProtFloatCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "FloatDef", IBusModelProtFloatDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "FloatType", IBusModelProtFloatType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Id16Gen", IBusModelProtId16Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Id32Gen", IBusModelProtId32Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Id64Gen", IBusModelProtId64Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Index", IBusModelProtIndex.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "IndexCol", IBusModelProtIndexCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "IndexTweak", IBusModelProtIndexTweak.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Int16Col", IBusModelProtInt16Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Int16Def", IBusModelProtInt16Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Int16Type", IBusModelProtInt16Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Int32Col", IBusModelProtInt32Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Int32Def", IBusModelProtInt32Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Int32Type", IBusModelProtInt32Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Int64Col", IBusModelProtInt64Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Int64Def", IBusModelProtInt64Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Int64Type", IBusModelProtInt64Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "NmTokenCol", IBusModelProtNmTokenCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "NmTokenDef", IBusModelProtNmTokenDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "NmTokenType", IBusModelProtNmTokenType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "NmTokensCol", IBusModelProtNmTokensCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "NmTokensDef", IBusModelProtNmTokensDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "NmTokensType", IBusModelProtNmTokensType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "NumberCol", IBusModelProtNumberCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "NumberDef", IBusModelProtNumberDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "NumberType", IBusModelProtNumberType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Param", IBusModelProtParam.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "PopDep", IBusModelProtPopDep.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "PopSubDep1", IBusModelProtPopSubDep1.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "PopSubDep2", IBusModelProtPopSubDep2.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "PopSubDep3", IBusModelProtPopSubDep3.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "PopTopDep", IBusModelProtPopTopDep.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Relation", IBusModelProtRelation.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "RelationCol", IBusModelProtRelationCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "RoleDef", IBusModelProtRoleDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "SchemaDef", IBusModelProtSchemaDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "SchemaRef", IBusModelProtSchemaRef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "SchemaRole", IBusModelProtSchemaRole.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "SchemaTweak", IBusModelProtSchemaTweak.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Scope", IBusModelProtScope.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "ServerListFunc", IBusModelProtServerListFunc.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "ServerMethod", IBusModelProtServerMethod.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "ServerObjFunc", IBusModelProtServerObjFunc.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "ServerProc", IBusModelProtServerProc.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "StringCol", IBusModelProtStringCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "StringDef", IBusModelProtStringDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "StringType", IBusModelProtStringType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TZDateCol", IBusModelProtTZDateCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TZDateDef", IBusModelProtTZDateDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TZDateType", IBusModelProtTZDateType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TZTimeCol", IBusModelProtTZTimeCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TZTimeDef", IBusModelProtTZTimeDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TZTimeType", IBusModelProtTZTimeType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TZTimestampCol", IBusModelProtTZTimestampCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TZTimestampDef", IBusModelProtTZTimestampDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TZTimestampType", IBusModelProtTZTimestampType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Table", IBusModelProtTable.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TableCol", IBusModelProtTableCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TableTweak", IBusModelProtTableTweak.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TextCol", IBusModelProtTextCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TextDef", IBusModelProtTextDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TextType", IBusModelProtTextType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TimeCol", IBusModelProtTimeCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TimeDef", IBusModelProtTimeDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TimeType", IBusModelProtTimeType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TimestampCol", IBusModelProtTimestampCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TimestampDef", IBusModelProtTimestampDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TimestampType", IBusModelProtTimestampType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TokenCol", IBusModelProtTokenCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TokenDef", IBusModelProtTokenDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "TokenType", IBusModelProtTokenType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Tweak", IBusModelProtTweak.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UInt16Col", IBusModelProtUInt16Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UInt16Def", IBusModelProtUInt16Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UInt16Type", IBusModelProtUInt16Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UInt32Col", IBusModelProtUInt32Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UInt32Def", IBusModelProtUInt32Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UInt32Type", IBusModelProtUInt32Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UInt64Col", IBusModelProtUInt64Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UInt64Def", IBusModelProtUInt64Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UInt64Type", IBusModelProtUInt64Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Uuid6Col", IBusModelProtUuid6Col.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Uuid6Def", IBusModelProtUuid6Def.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Uuid6Gen", IBusModelProtUuid6Gen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Uuid6Type", IBusModelProtUuid6Type.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UuidCol", IBusModelProtUuidCol.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UuidDef", IBusModelProtUuidDef.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UuidGen", IBusModelProtUuidGen.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "UuidType", IBusModelProtUuidType.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				entry = new ISecureProtSchema.ClassMapEntry(IBusModelProtSchema.SCHEMA_NAME, "Value", IBusModelProtValue.CLASS_CODE);
				IBusModelProtSchema.entries.add(entry);
				for( ISecureProtSchema.ClassMapEntry cur: IBusModelProtSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				IBusModelProtSchema.mapBackingClassCodeToEntry.clear();
				IBusModelProtSchema.mapRuntimeClassCodeToEntry.clear();
				for( ISecureProtSchema.ClassMapEntry cur: IBusModelProtSchema.entries) {
					IBusModelProtSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					IBusModelProtSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ISecureProtSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ISecureProtSchema.ClassMapEntry entry;
			entry = ISecureProtSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IIntNetProtSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IBusModelProtSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ISecureProtSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ISecureProtSchema.ClassMapEntry entry;
			entry = ISecureProtSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IIntNetProtSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IBusModelProtSchema.mapRuntimeClassCodeToEntry.get(code);
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
	 *	@return	A new ISecureProtSchema instance.
	 */
	public ISecureProtSchema newSchema();

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
	 *	Get the factory for SecureProt data objects.
	 */
	// public ISecureProtFactory getSecureFactory();

	/**
	 *	Get the buffer factory for SecureProt data buffers.
	 */
	// public SecureProtBuffFactoryService getSecureBuffFactory();

	/**
	 *	Get the factory for IntNetProt data objects.
	 */
	// public IIntNetProtFactory getIntNetFactory();

	/**
	 *	Get the buffer factory for IntNetProt data buffers.
	 */
	// public IntNetProtBuffFactoryService getIntNetBuffFactory();

	/**
	 *	Get the factory for BusModelProt data objects.
	 */
	// public IBusModelProtFactory getBusModelFactory();

	/**
	 *	Get the buffer factory for BusModelProt data buffers.
	 */
	// public BusModelProtBuffFactoryService getBusModelBuffFactory();

	/**
	 *	Get the Atom Table interface for the schema.
	 *
	 *	@return	The Atom Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtAtomTable getTableAtom();

	/**
	 *	Get the BlobCol Table interface for the schema.
	 *
	 *	@return	The BlobCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtBlobColTable getTableBlobCol();

	/**
	 *	Get the BlobDef Table interface for the schema.
	 *
	 *	@return	The BlobDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtBlobDefTable getTableBlobDef();

	/**
	 *	Get the BlobType Table interface for the schema.
	 *
	 *	@return	The BlobType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtBlobTypeTable getTableBlobType();

	/**
	 *	Get the BoolCol Table interface for the schema.
	 *
	 *	@return	The BoolCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtBoolColTable getTableBoolCol();

	/**
	 *	Get the BoolDef Table interface for the schema.
	 *
	 *	@return	The BoolDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtBoolDefTable getTableBoolDef();

	/**
	 *	Get the BoolType Table interface for the schema.
	 *
	 *	@return	The BoolType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtBoolTypeTable getTableBoolType();

	/**
	 *	Get the Chain Table interface for the schema.
	 *
	 *	@return	The Chain Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtChainTable getTableChain();

	/**
	 *	Get the ClearDep Table interface for the schema.
	 *
	 *	@return	The ClearDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtClearDepTable getTableClearDep();

	/**
	 *	Get the ClearSubDep1 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep1 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtClearSubDep1Table getTableClearSubDep1();

	/**
	 *	Get the ClearSubDep2 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep2 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtClearSubDep2Table getTableClearSubDep2();

	/**
	 *	Get the ClearSubDep3 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep3 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtClearSubDep3Table getTableClearSubDep3();

	/**
	 *	Get the ClearTopDep Table interface for the schema.
	 *
	 *	@return	The ClearTopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtClearTopDepTable getTableClearTopDep();

	/**
	 *	Get the DateCol Table interface for the schema.
	 *
	 *	@return	The DateCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDateColTable getTableDateCol();

	/**
	 *	Get the DateDef Table interface for the schema.
	 *
	 *	@return	The DateDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDateDefTable getTableDateDef();

	/**
	 *	Get the DateType Table interface for the schema.
	 *
	 *	@return	The DateType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDateTypeTable getTableDateType();

	/**
	 *	Get the DbKeyHash128Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash128ColTable getTableDbKeyHash128Col();

	/**
	 *	Get the DbKeyHash128Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash128DefTable getTableDbKeyHash128Def();

	/**
	 *	Get the DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash128GenTable getTableDbKeyHash128Gen();

	/**
	 *	Get the DbKeyHash128Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash128TypeTable getTableDbKeyHash128Type();

	/**
	 *	Get the DbKeyHash160Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash160ColTable getTableDbKeyHash160Col();

	/**
	 *	Get the DbKeyHash160Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash160DefTable getTableDbKeyHash160Def();

	/**
	 *	Get the DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash160GenTable getTableDbKeyHash160Gen();

	/**
	 *	Get the DbKeyHash160Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash160TypeTable getTableDbKeyHash160Type();

	/**
	 *	Get the DbKeyHash224Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash224ColTable getTableDbKeyHash224Col();

	/**
	 *	Get the DbKeyHash224Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash224DefTable getTableDbKeyHash224Def();

	/**
	 *	Get the DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash224GenTable getTableDbKeyHash224Gen();

	/**
	 *	Get the DbKeyHash224Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash224TypeTable getTableDbKeyHash224Type();

	/**
	 *	Get the DbKeyHash256Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash256ColTable getTableDbKeyHash256Col();

	/**
	 *	Get the DbKeyHash256Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash256DefTable getTableDbKeyHash256Def();

	/**
	 *	Get the DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash256GenTable getTableDbKeyHash256Gen();

	/**
	 *	Get the DbKeyHash256Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash256TypeTable getTableDbKeyHash256Type();

	/**
	 *	Get the DbKeyHash384Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash384ColTable getTableDbKeyHash384Col();

	/**
	 *	Get the DbKeyHash384Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash384DefTable getTableDbKeyHash384Def();

	/**
	 *	Get the DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash384GenTable getTableDbKeyHash384Gen();

	/**
	 *	Get the DbKeyHash384Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash384TypeTable getTableDbKeyHash384Type();

	/**
	 *	Get the DbKeyHash512Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash512ColTable getTableDbKeyHash512Col();

	/**
	 *	Get the DbKeyHash512Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash512DefTable getTableDbKeyHash512Def();

	/**
	 *	Get the DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash512GenTable getTableDbKeyHash512Gen();

	/**
	 *	Get the DbKeyHash512Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDbKeyHash512TypeTable getTableDbKeyHash512Type();

	/**
	 *	Get the DelDep Table interface for the schema.
	 *
	 *	@return	The DelDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDelDepTable getTableDelDep();

	/**
	 *	Get the DelSubDep1 Table interface for the schema.
	 *
	 *	@return	The DelSubDep1 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDelSubDep1Table getTableDelSubDep1();

	/**
	 *	Get the DelSubDep2 Table interface for the schema.
	 *
	 *	@return	The DelSubDep2 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDelSubDep2Table getTableDelSubDep2();

	/**
	 *	Get the DelSubDep3 Table interface for the schema.
	 *
	 *	@return	The DelSubDep3 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDelSubDep3Table getTableDelSubDep3();

	/**
	 *	Get the DelTopDep Table interface for the schema.
	 *
	 *	@return	The DelTopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDelTopDepTable getTableDelTopDep();

	/**
	 *	Get the DoubleCol Table interface for the schema.
	 *
	 *	@return	The DoubleCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDoubleColTable getTableDoubleCol();

	/**
	 *	Get the DoubleDef Table interface for the schema.
	 *
	 *	@return	The DoubleDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDoubleDefTable getTableDoubleDef();

	/**
	 *	Get the DoubleType Table interface for the schema.
	 *
	 *	@return	The DoubleType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtDoubleTypeTable getTableDoubleType();

	/**
	 *	Get the EnumDef Table interface for the schema.
	 *
	 *	@return	The EnumDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtEnumDefTable getTableEnumDef();

	/**
	 *	Get the EnumTag Table interface for the schema.
	 *
	 *	@return	The EnumTag Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtEnumTagTable getTableEnumTag();

	/**
	 *	Get the EnumType Table interface for the schema.
	 *
	 *	@return	The EnumType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtEnumTypeTable getTableEnumType();

	/**
	 *	Get the FloatCol Table interface for the schema.
	 *
	 *	@return	The FloatCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtFloatColTable getTableFloatCol();

	/**
	 *	Get the FloatDef Table interface for the schema.
	 *
	 *	@return	The FloatDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtFloatDefTable getTableFloatDef();

	/**
	 *	Get the FloatType Table interface for the schema.
	 *
	 *	@return	The FloatType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtFloatTypeTable getTableFloatType();

	/**
	 *	Get the Id16Gen Table interface for the schema.
	 *
	 *	@return	The Id16Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtId16GenTable getTableId16Gen();

	/**
	 *	Get the Id32Gen Table interface for the schema.
	 *
	 *	@return	The Id32Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtId32GenTable getTableId32Gen();

	/**
	 *	Get the Id64Gen Table interface for the schema.
	 *
	 *	@return	The Id64Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtId64GenTable getTableId64Gen();

	/**
	 *	Get the Index Table interface for the schema.
	 *
	 *	@return	The Index Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtIndexTable getTableIndex();

	/**
	 *	Get the IndexCol Table interface for the schema.
	 *
	 *	@return	The IndexCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtIndexColTable getTableIndexCol();

	/**
	 *	Get the IndexTweak Table interface for the schema.
	 *
	 *	@return	The IndexTweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtIndexTweakTable getTableIndexTweak();

	/**
	 *	Get the Int16Col Table interface for the schema.
	 *
	 *	@return	The Int16Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtInt16ColTable getTableInt16Col();

	/**
	 *	Get the Int16Def Table interface for the schema.
	 *
	 *	@return	The Int16Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtInt16DefTable getTableInt16Def();

	/**
	 *	Get the Int16Type Table interface for the schema.
	 *
	 *	@return	The Int16Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtInt16TypeTable getTableInt16Type();

	/**
	 *	Get the Int32Col Table interface for the schema.
	 *
	 *	@return	The Int32Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtInt32ColTable getTableInt32Col();

	/**
	 *	Get the Int32Def Table interface for the schema.
	 *
	 *	@return	The Int32Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtInt32DefTable getTableInt32Def();

	/**
	 *	Get the Int32Type Table interface for the schema.
	 *
	 *	@return	The Int32Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtInt32TypeTable getTableInt32Type();

	/**
	 *	Get the Int64Col Table interface for the schema.
	 *
	 *	@return	The Int64Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtInt64ColTable getTableInt64Col();

	/**
	 *	Get the Int64Def Table interface for the schema.
	 *
	 *	@return	The Int64Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtInt64DefTable getTableInt64Def();

	/**
	 *	Get the Int64Type Table interface for the schema.
	 *
	 *	@return	The Int64Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtInt64TypeTable getTableInt64Type();

	/**
	 *	Get the NmTokenCol Table interface for the schema.
	 *
	 *	@return	The NmTokenCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtNmTokenColTable getTableNmTokenCol();

	/**
	 *	Get the NmTokenDef Table interface for the schema.
	 *
	 *	@return	The NmTokenDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtNmTokenDefTable getTableNmTokenDef();

	/**
	 *	Get the NmTokenType Table interface for the schema.
	 *
	 *	@return	The NmTokenType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtNmTokenTypeTable getTableNmTokenType();

	/**
	 *	Get the NmTokensCol Table interface for the schema.
	 *
	 *	@return	The NmTokensCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtNmTokensColTable getTableNmTokensCol();

	/**
	 *	Get the NmTokensDef Table interface for the schema.
	 *
	 *	@return	The NmTokensDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtNmTokensDefTable getTableNmTokensDef();

	/**
	 *	Get the NmTokensType Table interface for the schema.
	 *
	 *	@return	The NmTokensType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtNmTokensTypeTable getTableNmTokensType();

	/**
	 *	Get the NumberCol Table interface for the schema.
	 *
	 *	@return	The NumberCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtNumberColTable getTableNumberCol();

	/**
	 *	Get the NumberDef Table interface for the schema.
	 *
	 *	@return	The NumberDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtNumberDefTable getTableNumberDef();

	/**
	 *	Get the NumberType Table interface for the schema.
	 *
	 *	@return	The NumberType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtNumberTypeTable getTableNumberType();

	/**
	 *	Get the Param Table interface for the schema.
	 *
	 *	@return	The Param Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtParamTable getTableParam();

	/**
	 *	Get the PopDep Table interface for the schema.
	 *
	 *	@return	The PopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtPopDepTable getTablePopDep();

	/**
	 *	Get the PopSubDep1 Table interface for the schema.
	 *
	 *	@return	The PopSubDep1 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtPopSubDep1Table getTablePopSubDep1();

	/**
	 *	Get the PopSubDep2 Table interface for the schema.
	 *
	 *	@return	The PopSubDep2 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtPopSubDep2Table getTablePopSubDep2();

	/**
	 *	Get the PopSubDep3 Table interface for the schema.
	 *
	 *	@return	The PopSubDep3 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtPopSubDep3Table getTablePopSubDep3();

	/**
	 *	Get the PopTopDep Table interface for the schema.
	 *
	 *	@return	The PopTopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtPopTopDepTable getTablePopTopDep();

	/**
	 *	Get the Relation Table interface for the schema.
	 *
	 *	@return	The Relation Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtRelationTable getTableRelation();

	/**
	 *	Get the RelationCol Table interface for the schema.
	 *
	 *	@return	The RelationCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtRelationColTable getTableRelationCol();

	/**
	 *	Get the RoleDef Table interface for the schema.
	 *
	 *	@return	The RoleDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtRoleDefTable getTableRoleDef();

	/**
	 *	Get the SchemaDef Table interface for the schema.
	 *
	 *	@return	The SchemaDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtSchemaDefTable getTableSchemaDef();

	/**
	 *	Get the SchemaRef Table interface for the schema.
	 *
	 *	@return	The SchemaRef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtSchemaRefTable getTableSchemaRef();

	/**
	 *	Get the SchemaRole Table interface for the schema.
	 *
	 *	@return	The SchemaRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtSchemaRoleTable getTableSchemaRole();

	/**
	 *	Get the SchemaTweak Table interface for the schema.
	 *
	 *	@return	The SchemaTweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtSchemaTweakTable getTableSchemaTweak();

	/**
	 *	Get the Scope Table interface for the schema.
	 *
	 *	@return	The Scope Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtScopeTable getTableScope();

	/**
	 *	Get the ServerListFunc Table interface for the schema.
	 *
	 *	@return	The ServerListFunc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtServerListFuncTable getTableServerListFunc();

	/**
	 *	Get the ServerMethod Table interface for the schema.
	 *
	 *	@return	The ServerMethod Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtServerMethodTable getTableServerMethod();

	/**
	 *	Get the ServerObjFunc Table interface for the schema.
	 *
	 *	@return	The ServerObjFunc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtServerObjFuncTable getTableServerObjFunc();

	/**
	 *	Get the ServerProc Table interface for the schema.
	 *
	 *	@return	The ServerProc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtServerProcTable getTableServerProc();

	/**
	 *	Get the StringCol Table interface for the schema.
	 *
	 *	@return	The StringCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtStringColTable getTableStringCol();

	/**
	 *	Get the StringDef Table interface for the schema.
	 *
	 *	@return	The StringDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtStringDefTable getTableStringDef();

	/**
	 *	Get the StringType Table interface for the schema.
	 *
	 *	@return	The StringType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtStringTypeTable getTableStringType();

	/**
	 *	Get the TZDateCol Table interface for the schema.
	 *
	 *	@return	The TZDateCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTZDateColTable getTableTZDateCol();

	/**
	 *	Get the TZDateDef Table interface for the schema.
	 *
	 *	@return	The TZDateDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTZDateDefTable getTableTZDateDef();

	/**
	 *	Get the TZDateType Table interface for the schema.
	 *
	 *	@return	The TZDateType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTZDateTypeTable getTableTZDateType();

	/**
	 *	Get the TZTimeCol Table interface for the schema.
	 *
	 *	@return	The TZTimeCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTZTimeColTable getTableTZTimeCol();

	/**
	 *	Get the TZTimeDef Table interface for the schema.
	 *
	 *	@return	The TZTimeDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTZTimeDefTable getTableTZTimeDef();

	/**
	 *	Get the TZTimeType Table interface for the schema.
	 *
	 *	@return	The TZTimeType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTZTimeTypeTable getTableTZTimeType();

	/**
	 *	Get the TZTimestampCol Table interface for the schema.
	 *
	 *	@return	The TZTimestampCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTZTimestampColTable getTableTZTimestampCol();

	/**
	 *	Get the TZTimestampDef Table interface for the schema.
	 *
	 *	@return	The TZTimestampDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTZTimestampDefTable getTableTZTimestampDef();

	/**
	 *	Get the TZTimestampType Table interface for the schema.
	 *
	 *	@return	The TZTimestampType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTZTimestampTypeTable getTableTZTimestampType();

	/**
	 *	Get the Table Table interface for the schema.
	 *
	 *	@return	The Table Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTableTable getTableTable();

	/**
	 *	Get the TableCol Table interface for the schema.
	 *
	 *	@return	The TableCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTableColTable getTableTableCol();

	/**
	 *	Get the TableTweak Table interface for the schema.
	 *
	 *	@return	The TableTweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTableTweakTable getTableTableTweak();

	/**
	 *	Get the TextCol Table interface for the schema.
	 *
	 *	@return	The TextCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTextColTable getTableTextCol();

	/**
	 *	Get the TextDef Table interface for the schema.
	 *
	 *	@return	The TextDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTextDefTable getTableTextDef();

	/**
	 *	Get the TextType Table interface for the schema.
	 *
	 *	@return	The TextType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTextTypeTable getTableTextType();

	/**
	 *	Get the TimeCol Table interface for the schema.
	 *
	 *	@return	The TimeCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTimeColTable getTableTimeCol();

	/**
	 *	Get the TimeDef Table interface for the schema.
	 *
	 *	@return	The TimeDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTimeDefTable getTableTimeDef();

	/**
	 *	Get the TimeType Table interface for the schema.
	 *
	 *	@return	The TimeType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTimeTypeTable getTableTimeType();

	/**
	 *	Get the TimestampCol Table interface for the schema.
	 *
	 *	@return	The TimestampCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTimestampColTable getTableTimestampCol();

	/**
	 *	Get the TimestampDef Table interface for the schema.
	 *
	 *	@return	The TimestampDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTimestampDefTable getTableTimestampDef();

	/**
	 *	Get the TimestampType Table interface for the schema.
	 *
	 *	@return	The TimestampType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTimestampTypeTable getTableTimestampType();

	/**
	 *	Get the TokenCol Table interface for the schema.
	 *
	 *	@return	The TokenCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTokenColTable getTableTokenCol();

	/**
	 *	Get the TokenDef Table interface for the schema.
	 *
	 *	@return	The TokenDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTokenDefTable getTableTokenDef();

	/**
	 *	Get the TokenType Table interface for the schema.
	 *
	 *	@return	The TokenType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTokenTypeTable getTableTokenType();

	/**
	 *	Get the Tweak Table interface for the schema.
	 *
	 *	@return	The Tweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtTweakTable getTableTweak();

	/**
	 *	Get the UInt16Col Table interface for the schema.
	 *
	 *	@return	The UInt16Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUInt16ColTable getTableUInt16Col();

	/**
	 *	Get the UInt16Def Table interface for the schema.
	 *
	 *	@return	The UInt16Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUInt16DefTable getTableUInt16Def();

	/**
	 *	Get the UInt16Type Table interface for the schema.
	 *
	 *	@return	The UInt16Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUInt16TypeTable getTableUInt16Type();

	/**
	 *	Get the UInt32Col Table interface for the schema.
	 *
	 *	@return	The UInt32Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUInt32ColTable getTableUInt32Col();

	/**
	 *	Get the UInt32Def Table interface for the schema.
	 *
	 *	@return	The UInt32Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUInt32DefTable getTableUInt32Def();

	/**
	 *	Get the UInt32Type Table interface for the schema.
	 *
	 *	@return	The UInt32Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUInt32TypeTable getTableUInt32Type();

	/**
	 *	Get the UInt64Col Table interface for the schema.
	 *
	 *	@return	The UInt64Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUInt64ColTable getTableUInt64Col();

	/**
	 *	Get the UInt64Def Table interface for the schema.
	 *
	 *	@return	The UInt64Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUInt64DefTable getTableUInt64Def();

	/**
	 *	Get the UInt64Type Table interface for the schema.
	 *
	 *	@return	The UInt64Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUInt64TypeTable getTableUInt64Type();

	/**
	 *	Get the Uuid6Col Table interface for the schema.
	 *
	 *	@return	The Uuid6Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUuid6ColTable getTableUuid6Col();

	/**
	 *	Get the Uuid6Def Table interface for the schema.
	 *
	 *	@return	The Uuid6Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUuid6DefTable getTableUuid6Def();

	/**
	 *	Get the Uuid6Gen Table interface for the schema.
	 *
	 *	@return	The Uuid6Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUuid6GenTable getTableUuid6Gen();

	/**
	 *	Get the Uuid6Type Table interface for the schema.
	 *
	 *	@return	The Uuid6Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUuid6TypeTable getTableUuid6Type();

	/**
	 *	Get the UuidCol Table interface for the schema.
	 *
	 *	@return	The UuidCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUuidColTable getTableUuidCol();

	/**
	 *	Get the UuidDef Table interface for the schema.
	 *
	 *	@return	The UuidDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUuidDefTable getTableUuidDef();

	/**
	 *	Get the UuidGen Table interface for the schema.
	 *
	 *	@return	The UuidGen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUuidGenTable getTableUuidGen();

	/**
	 *	Get the UuidType Table interface for the schema.
	 *
	 *	@return	The UuidType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtUuidTypeTable getTableUuidType();

	/**
	 *	Get the Value Table interface for the schema.
	 *
	 *	@return	The Value Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelProtValueTable getTableValue();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static ISecureProtTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ISecureProtTablePerms getSecureProtTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ISecureProtTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ISecureProtTablePerms value );

	public void bootstrapSchema(SecurePubTableData tableData[]);
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]);
}
