// Description: Java 25 public interface for a BusModel schema.

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

package server.markhome.ycf.v3_1.busmodel.busmodelpub;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.YCFXmlUtil;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;

//import server.markhome.ycf.v3_1.secure.securepub.buff.SecurePubBuffFactoryService;
//import server.markhome.ycf.v3_1.intnet.intnetpub.buff.IntNetPubBuffFactoryService;
//import server.markhome.ycf.v3_1.busmodel.busmodelpub.buff.BusModelPubBuffFactoryService;

public interface IBusModelPubSchema
extends ISecurePubSchema,
	IIntNetPubSchema
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
			for( SecurePubTableData data: ISecurePubSchema.getTableData()) {
				lst.add(data);
			}
			for( SecurePubTableData data: IIntNetPubSchema.getTableData()) {
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
			for( SecurePubRoleInfo info: ISecurePubSchema.getRoleInfo()) {
				lst.add(info);
			}
			for( SecurePubRoleInfo info: IIntNetPubSchema.getRoleInfo()) {
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

		final static ArrayList<ISecurePubSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ISecurePubSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ISecurePubSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<IBusModelPubSchema> backingBusModel = new AtomicReference<>();
	public enum LoaderBehaviourEnum {
		Insert,
		Update,
		Replace
	};

	static HashMap<String,LoaderBehaviourEnum> lookupLoaderBehaviourEnum = new HashMap<String,LoaderBehaviourEnum>();

	public static LoaderBehaviourEnum parseLoaderBehaviourEnum( String value ) {
		LoaderBehaviourEnum retval = parseLoaderBehaviourEnum( IBusModelPubSchema.class.getName(), value );
		return( retval );
	}

	public static LoaderBehaviourEnum parseLoaderBehaviourEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseLoaderBehaviourEnum";
		if( lookupLoaderBehaviourEnum.isEmpty() ) {
			lookupLoaderBehaviourEnum.put( "Insert", LoaderBehaviourEnum.Insert );
			lookupLoaderBehaviourEnum.put( "Update", LoaderBehaviourEnum.Update );
			lookupLoaderBehaviourEnum.put( "Replace", LoaderBehaviourEnum.Replace );
		}
		LoaderBehaviourEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupLoaderBehaviourEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,LoaderBehaviourEnum> lookupOrdinalLoaderBehaviourEnum = new HashMap<Integer,LoaderBehaviourEnum>();

	public static LoaderBehaviourEnum ordinalToLoaderBehaviourEnum( String fieldOrClassName, Short value ) {
		LoaderBehaviourEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToLoaderBehaviourEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static LoaderBehaviourEnum ordinalToLoaderBehaviourEnum( Short value ) {
		LoaderBehaviourEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToLoaderBehaviourEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static LoaderBehaviourEnum ordinalToLoaderBehaviourEnum( Integer value ) {
		LoaderBehaviourEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToLoaderBehaviourEnum( IBusModelPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static LoaderBehaviourEnum ordinalToLoaderBehaviourEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToLoaderBehaviourEnum";
		if( lookupOrdinalLoaderBehaviourEnum.isEmpty() ) {
			lookupOrdinalLoaderBehaviourEnum.put( Integer.valueOf( LoaderBehaviourEnum.Insert.ordinal() ), LoaderBehaviourEnum.Insert );
			lookupOrdinalLoaderBehaviourEnum.put( Integer.valueOf( LoaderBehaviourEnum.Update.ordinal() ), LoaderBehaviourEnum.Update );
			lookupOrdinalLoaderBehaviourEnum.put( Integer.valueOf( LoaderBehaviourEnum.Replace.ordinal() ), LoaderBehaviourEnum.Replace );
		}
		LoaderBehaviourEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalLoaderBehaviourEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	public enum RelationTypeEnum {
		Unknown,
		Lookup,
		Superclass,
		Container,
		Components,
		Owner,
		Parent,
		Children
	};

	static HashMap<String,RelationTypeEnum> lookupRelationTypeEnum = new HashMap<String,RelationTypeEnum>();

	public static RelationTypeEnum parseRelationTypeEnum( String value ) {
		RelationTypeEnum retval = parseRelationTypeEnum( IBusModelPubSchema.class.getName(), value );
		return( retval );
	}

	public static RelationTypeEnum parseRelationTypeEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseRelationTypeEnum";
		if( lookupRelationTypeEnum.isEmpty() ) {
			lookupRelationTypeEnum.put( "Unknown", RelationTypeEnum.Unknown );
			lookupRelationTypeEnum.put( "Lookup", RelationTypeEnum.Lookup );
			lookupRelationTypeEnum.put( "Superclass", RelationTypeEnum.Superclass );
			lookupRelationTypeEnum.put( "Container", RelationTypeEnum.Container );
			lookupRelationTypeEnum.put( "Components", RelationTypeEnum.Components );
			lookupRelationTypeEnum.put( "Owner", RelationTypeEnum.Owner );
			lookupRelationTypeEnum.put( "Parent", RelationTypeEnum.Parent );
			lookupRelationTypeEnum.put( "Children", RelationTypeEnum.Children );
		}
		RelationTypeEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupRelationTypeEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,RelationTypeEnum> lookupOrdinalRelationTypeEnum = new HashMap<Integer,RelationTypeEnum>();

	public static RelationTypeEnum ordinalToRelationTypeEnum( String fieldOrClassName, Short value ) {
		RelationTypeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToRelationTypeEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static RelationTypeEnum ordinalToRelationTypeEnum( Short value ) {
		RelationTypeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToRelationTypeEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static RelationTypeEnum ordinalToRelationTypeEnum( Integer value ) {
		RelationTypeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToRelationTypeEnum( IBusModelPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static RelationTypeEnum ordinalToRelationTypeEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToRelationTypeEnum";
		if( lookupOrdinalRelationTypeEnum.isEmpty() ) {
			lookupOrdinalRelationTypeEnum.put( Integer.valueOf( RelationTypeEnum.Unknown.ordinal() ), RelationTypeEnum.Unknown );
			lookupOrdinalRelationTypeEnum.put( Integer.valueOf( RelationTypeEnum.Lookup.ordinal() ), RelationTypeEnum.Lookup );
			lookupOrdinalRelationTypeEnum.put( Integer.valueOf( RelationTypeEnum.Superclass.ordinal() ), RelationTypeEnum.Superclass );
			lookupOrdinalRelationTypeEnum.put( Integer.valueOf( RelationTypeEnum.Container.ordinal() ), RelationTypeEnum.Container );
			lookupOrdinalRelationTypeEnum.put( Integer.valueOf( RelationTypeEnum.Components.ordinal() ), RelationTypeEnum.Components );
			lookupOrdinalRelationTypeEnum.put( Integer.valueOf( RelationTypeEnum.Owner.ordinal() ), RelationTypeEnum.Owner );
			lookupOrdinalRelationTypeEnum.put( Integer.valueOf( RelationTypeEnum.Parent.ordinal() ), RelationTypeEnum.Parent );
			lookupOrdinalRelationTypeEnum.put( Integer.valueOf( RelationTypeEnum.Children.ordinal() ), RelationTypeEnum.Children );
		}
		RelationTypeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalRelationTypeEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	public enum CodeVisibilityEnum {
		Public,
		Protected,
		Private
	};

	static HashMap<String,CodeVisibilityEnum> lookupCodeVisibilityEnum = new HashMap<String,CodeVisibilityEnum>();

	public static CodeVisibilityEnum parseCodeVisibilityEnum( String value ) {
		CodeVisibilityEnum retval = parseCodeVisibilityEnum( IBusModelPubSchema.class.getName(), value );
		return( retval );
	}

	public static CodeVisibilityEnum parseCodeVisibilityEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseCodeVisibilityEnum";
		if( lookupCodeVisibilityEnum.isEmpty() ) {
			lookupCodeVisibilityEnum.put( "Public", CodeVisibilityEnum.Public );
			lookupCodeVisibilityEnum.put( "Protected", CodeVisibilityEnum.Protected );
			lookupCodeVisibilityEnum.put( "Private", CodeVisibilityEnum.Private );
		}
		CodeVisibilityEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupCodeVisibilityEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,CodeVisibilityEnum> lookupOrdinalCodeVisibilityEnum = new HashMap<Integer,CodeVisibilityEnum>();

	public static CodeVisibilityEnum ordinalToCodeVisibilityEnum( String fieldOrClassName, Short value ) {
		CodeVisibilityEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToCodeVisibilityEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static CodeVisibilityEnum ordinalToCodeVisibilityEnum( Short value ) {
		CodeVisibilityEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToCodeVisibilityEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static CodeVisibilityEnum ordinalToCodeVisibilityEnum( Integer value ) {
		CodeVisibilityEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToCodeVisibilityEnum( IBusModelPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static CodeVisibilityEnum ordinalToCodeVisibilityEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToCodeVisibilityEnum";
		if( lookupOrdinalCodeVisibilityEnum.isEmpty() ) {
			lookupOrdinalCodeVisibilityEnum.put( Integer.valueOf( CodeVisibilityEnum.Public.ordinal() ), CodeVisibilityEnum.Public );
			lookupOrdinalCodeVisibilityEnum.put( Integer.valueOf( CodeVisibilityEnum.Protected.ordinal() ), CodeVisibilityEnum.Protected );
			lookupOrdinalCodeVisibilityEnum.put( Integer.valueOf( CodeVisibilityEnum.Private.ordinal() ), CodeVisibilityEnum.Private );
		}
		CodeVisibilityEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalCodeVisibilityEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	public enum SecScopeEnum {
		None,
		System,
		Cluster,
		Tenant,
		SystemGroup,
		ClusterGroup,
		TenantGroup
	};

	static HashMap<String,SecScopeEnum> lookupSecScopeEnum = new HashMap<String,SecScopeEnum>();

	public static SecScopeEnum parseSecScopeEnum( String value ) {
		SecScopeEnum retval = parseSecScopeEnum( IBusModelPubSchema.class.getName(), value );
		return( retval );
	}

	public static SecScopeEnum parseSecScopeEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseSecScopeEnum";
		if( lookupSecScopeEnum.isEmpty() ) {
			lookupSecScopeEnum.put( "None", SecScopeEnum.None );
			lookupSecScopeEnum.put( "System", SecScopeEnum.System );
			lookupSecScopeEnum.put( "Cluster", SecScopeEnum.Cluster );
			lookupSecScopeEnum.put( "Tenant", SecScopeEnum.Tenant );
			lookupSecScopeEnum.put( "SystemGroup", SecScopeEnum.SystemGroup );
			lookupSecScopeEnum.put( "ClusterGroup", SecScopeEnum.ClusterGroup );
			lookupSecScopeEnum.put( "TenantGroup", SecScopeEnum.TenantGroup );
		}
		SecScopeEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupSecScopeEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,SecScopeEnum> lookupOrdinalSecScopeEnum = new HashMap<Integer,SecScopeEnum>();

	public static SecScopeEnum ordinalToSecScopeEnum( String fieldOrClassName, Short value ) {
		SecScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecScopeEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecScopeEnum ordinalToSecScopeEnum( Short value ) {
		SecScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecScopeEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecScopeEnum ordinalToSecScopeEnum( Integer value ) {
		SecScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecScopeEnum( IBusModelPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecScopeEnum ordinalToSecScopeEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToSecScopeEnum";
		if( lookupOrdinalSecScopeEnum.isEmpty() ) {
			lookupOrdinalSecScopeEnum.put( Integer.valueOf( SecScopeEnum.None.ordinal() ), SecScopeEnum.None );
			lookupOrdinalSecScopeEnum.put( Integer.valueOf( SecScopeEnum.System.ordinal() ), SecScopeEnum.System );
			lookupOrdinalSecScopeEnum.put( Integer.valueOf( SecScopeEnum.Cluster.ordinal() ), SecScopeEnum.Cluster );
			lookupOrdinalSecScopeEnum.put( Integer.valueOf( SecScopeEnum.Tenant.ordinal() ), SecScopeEnum.Tenant );
			lookupOrdinalSecScopeEnum.put( Integer.valueOf( SecScopeEnum.SystemGroup.ordinal() ), SecScopeEnum.SystemGroup );
			lookupOrdinalSecScopeEnum.put( Integer.valueOf( SecScopeEnum.ClusterGroup.ordinal() ), SecScopeEnum.ClusterGroup );
			lookupOrdinalSecScopeEnum.put( Integer.valueOf( SecScopeEnum.TenantGroup.ordinal() ), SecScopeEnum.TenantGroup );
		}
		SecScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalSecScopeEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	public enum RoleScopeEnum {
		SysRole,
		ClusRole,
		TentRole
	};

	static HashMap<String,RoleScopeEnum> lookupRoleScopeEnum = new HashMap<String,RoleScopeEnum>();

	public static RoleScopeEnum parseRoleScopeEnum( String value ) {
		RoleScopeEnum retval = parseRoleScopeEnum( IBusModelPubSchema.class.getName(), value );
		return( retval );
	}

	public static RoleScopeEnum parseRoleScopeEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseRoleScopeEnum";
		if( lookupRoleScopeEnum.isEmpty() ) {
			lookupRoleScopeEnum.put( "SysRole", RoleScopeEnum.SysRole );
			lookupRoleScopeEnum.put( "ClusRole", RoleScopeEnum.ClusRole );
			lookupRoleScopeEnum.put( "TentRole", RoleScopeEnum.TentRole );
		}
		RoleScopeEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupRoleScopeEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,RoleScopeEnum> lookupOrdinalRoleScopeEnum = new HashMap<Integer,RoleScopeEnum>();

	public static RoleScopeEnum ordinalToRoleScopeEnum( String fieldOrClassName, Short value ) {
		RoleScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToRoleScopeEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static RoleScopeEnum ordinalToRoleScopeEnum( Short value ) {
		RoleScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToRoleScopeEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static RoleScopeEnum ordinalToRoleScopeEnum( Integer value ) {
		RoleScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToRoleScopeEnum( IBusModelPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static RoleScopeEnum ordinalToRoleScopeEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToRoleScopeEnum";
		if( lookupOrdinalRoleScopeEnum.isEmpty() ) {
			lookupOrdinalRoleScopeEnum.put( Integer.valueOf( RoleScopeEnum.SysRole.ordinal() ), RoleScopeEnum.SysRole );
			lookupOrdinalRoleScopeEnum.put( Integer.valueOf( RoleScopeEnum.ClusRole.ordinal() ), RoleScopeEnum.ClusRole );
			lookupOrdinalRoleScopeEnum.put( Integer.valueOf( RoleScopeEnum.TentRole.ordinal() ), RoleScopeEnum.TentRole );
		}
		RoleScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalRoleScopeEnum.get( value );
			if( retval == null ) {
				throw new YCFInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

		public static IBusModelPubSchema getBackingBusModel() {
			return( IBusModelPubSchema.backingBusModel.get() );
		}
		
		public static void setBackingPubSchema(IBusModelPubSchema backingSchema) {
			IBusModelPubSchema.backingBusModel.set(backingSchema);
		}
		
		public IBusModelPubSchema getBusModelSchema();
		public void setBusModelSchema(IBusModelPubSchema schema);

		public static int doInitClassMapEntries(int value) {
			value = ISecurePubSchema.doInitClassMapEntries(value);
			value = IIntNetPubSchema.doInitClassMapEntries(value);
			if (IBusModelPubSchema.entries.isEmpty()) {
				ISecurePubSchema.ClassMapEntry entry;
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Atom", IBusModelPubAtom.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "BlobCol", IBusModelPubBlobCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "BlobDef", IBusModelPubBlobDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "BlobType", IBusModelPubBlobType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "BoolCol", IBusModelPubBoolCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "BoolDef", IBusModelPubBoolDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "BoolType", IBusModelPubBoolType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Chain", IBusModelPubChain.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "ClearDep", IBusModelPubClearDep.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "ClearSubDep1", IBusModelPubClearSubDep1.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "ClearSubDep2", IBusModelPubClearSubDep2.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "ClearSubDep3", IBusModelPubClearSubDep3.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "ClearTopDep", IBusModelPubClearTopDep.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DateCol", IBusModelPubDateCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DateDef", IBusModelPubDateDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DateType", IBusModelPubDateType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash128Col", IBusModelPubDbKeyHash128Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash128Def", IBusModelPubDbKeyHash128Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash128Gen", IBusModelPubDbKeyHash128Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash128Type", IBusModelPubDbKeyHash128Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash160Col", IBusModelPubDbKeyHash160Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash160Def", IBusModelPubDbKeyHash160Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash160Gen", IBusModelPubDbKeyHash160Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash160Type", IBusModelPubDbKeyHash160Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash224Col", IBusModelPubDbKeyHash224Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash224Def", IBusModelPubDbKeyHash224Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash224Gen", IBusModelPubDbKeyHash224Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash224Type", IBusModelPubDbKeyHash224Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash256Col", IBusModelPubDbKeyHash256Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash256Def", IBusModelPubDbKeyHash256Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash256Gen", IBusModelPubDbKeyHash256Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash256Type", IBusModelPubDbKeyHash256Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash384Col", IBusModelPubDbKeyHash384Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash384Def", IBusModelPubDbKeyHash384Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash384Gen", IBusModelPubDbKeyHash384Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash384Type", IBusModelPubDbKeyHash384Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash512Col", IBusModelPubDbKeyHash512Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash512Def", IBusModelPubDbKeyHash512Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash512Gen", IBusModelPubDbKeyHash512Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DbKeyHash512Type", IBusModelPubDbKeyHash512Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DelDep", IBusModelPubDelDep.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DelSubDep1", IBusModelPubDelSubDep1.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DelSubDep2", IBusModelPubDelSubDep2.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DelSubDep3", IBusModelPubDelSubDep3.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DelTopDep", IBusModelPubDelTopDep.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DoubleCol", IBusModelPubDoubleCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DoubleDef", IBusModelPubDoubleDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "DoubleType", IBusModelPubDoubleType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "EnumDef", IBusModelPubEnumDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "EnumTag", IBusModelPubEnumTag.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "EnumType", IBusModelPubEnumType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "FloatCol", IBusModelPubFloatCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "FloatDef", IBusModelPubFloatDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "FloatType", IBusModelPubFloatType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Id16Gen", IBusModelPubId16Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Id32Gen", IBusModelPubId32Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Id64Gen", IBusModelPubId64Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Index", IBusModelPubIndex.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "IndexCol", IBusModelPubIndexCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "IndexTweak", IBusModelPubIndexTweak.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Int16Col", IBusModelPubInt16Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Int16Def", IBusModelPubInt16Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Int16Type", IBusModelPubInt16Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Int32Col", IBusModelPubInt32Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Int32Def", IBusModelPubInt32Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Int32Type", IBusModelPubInt32Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Int64Col", IBusModelPubInt64Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Int64Def", IBusModelPubInt64Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Int64Type", IBusModelPubInt64Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "NmTokenCol", IBusModelPubNmTokenCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "NmTokenDef", IBusModelPubNmTokenDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "NmTokenType", IBusModelPubNmTokenType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "NmTokensCol", IBusModelPubNmTokensCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "NmTokensDef", IBusModelPubNmTokensDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "NmTokensType", IBusModelPubNmTokensType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "NumberCol", IBusModelPubNumberCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "NumberDef", IBusModelPubNumberDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "NumberType", IBusModelPubNumberType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Param", IBusModelPubParam.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "PopDep", IBusModelPubPopDep.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "PopSubDep1", IBusModelPubPopSubDep1.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "PopSubDep2", IBusModelPubPopSubDep2.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "PopSubDep3", IBusModelPubPopSubDep3.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "PopTopDep", IBusModelPubPopTopDep.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Relation", IBusModelPubRelation.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "RelationCol", IBusModelPubRelationCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "RoleDef", IBusModelPubRoleDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "SchemaDef", IBusModelPubSchemaDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "SchemaRef", IBusModelPubSchemaRef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "SchemaRole", IBusModelPubSchemaRole.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "SchemaTweak", IBusModelPubSchemaTweak.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Scope", IBusModelPubScope.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "ServerListFunc", IBusModelPubServerListFunc.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "ServerMethod", IBusModelPubServerMethod.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "ServerObjFunc", IBusModelPubServerObjFunc.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "ServerProc", IBusModelPubServerProc.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "StringCol", IBusModelPubStringCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "StringDef", IBusModelPubStringDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "StringType", IBusModelPubStringType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TZDateCol", IBusModelPubTZDateCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TZDateDef", IBusModelPubTZDateDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TZDateType", IBusModelPubTZDateType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TZTimeCol", IBusModelPubTZTimeCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TZTimeDef", IBusModelPubTZTimeDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TZTimeType", IBusModelPubTZTimeType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TZTimestampCol", IBusModelPubTZTimestampCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TZTimestampDef", IBusModelPubTZTimestampDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TZTimestampType", IBusModelPubTZTimestampType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Table", IBusModelPubTable.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TableCol", IBusModelPubTableCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TableTweak", IBusModelPubTableTweak.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TextCol", IBusModelPubTextCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TextDef", IBusModelPubTextDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TextType", IBusModelPubTextType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TimeCol", IBusModelPubTimeCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TimeDef", IBusModelPubTimeDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TimeType", IBusModelPubTimeType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TimestampCol", IBusModelPubTimestampCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TimestampDef", IBusModelPubTimestampDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TimestampType", IBusModelPubTimestampType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TokenCol", IBusModelPubTokenCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TokenDef", IBusModelPubTokenDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "TokenType", IBusModelPubTokenType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Tweak", IBusModelPubTweak.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UInt16Col", IBusModelPubUInt16Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UInt16Def", IBusModelPubUInt16Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UInt16Type", IBusModelPubUInt16Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UInt32Col", IBusModelPubUInt32Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UInt32Def", IBusModelPubUInt32Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UInt32Type", IBusModelPubUInt32Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UInt64Col", IBusModelPubUInt64Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UInt64Def", IBusModelPubUInt64Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UInt64Type", IBusModelPubUInt64Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Uuid6Col", IBusModelPubUuid6Col.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Uuid6Def", IBusModelPubUuid6Def.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Uuid6Gen", IBusModelPubUuid6Gen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Uuid6Type", IBusModelPubUuid6Type.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UuidCol", IBusModelPubUuidCol.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UuidDef", IBusModelPubUuidDef.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UuidGen", IBusModelPubUuidGen.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "UuidType", IBusModelPubUuidType.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				entry = new ISecurePubSchema.ClassMapEntry(IBusModelPubSchema.SCHEMA_NAME, "Value", IBusModelPubValue.CLASS_CODE);
				IBusModelPubSchema.entries.add(entry);
				for( ISecurePubSchema.ClassMapEntry cur: IBusModelPubSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				IBusModelPubSchema.mapBackingClassCodeToEntry.clear();
				IBusModelPubSchema.mapRuntimeClassCodeToEntry.clear();
				for( ISecurePubSchema.ClassMapEntry cur: IBusModelPubSchema.entries) {
					IBusModelPubSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					IBusModelPubSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ISecurePubSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ISecurePubSchema.ClassMapEntry entry;
			entry = ISecurePubSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IIntNetPubSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IBusModelPubSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ISecurePubSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ISecurePubSchema.ClassMapEntry entry;
			entry = ISecurePubSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IIntNetPubSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = IBusModelPubSchema.mapRuntimeClassCodeToEntry.get(code);
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
	 *	@return	A new ISecurePubSchema instance.
	 */
	public ISecurePubSchema newSchema();

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
	 *	Get the factory for SecurePub data objects.
	 */
	// public ISecurePubFactory getSecureFactory();

	/**
	 *	Get the buffer factory for SecurePub data buffers.
	 */
	// public SecurePubBuffFactoryService getSecureBuffFactory();

	/**
	 *	Get the factory for IntNetPub data objects.
	 */
	// public IIntNetPubFactory getIntNetFactory();

	/**
	 *	Get the buffer factory for IntNetPub data buffers.
	 */
	// public IntNetPubBuffFactoryService getIntNetBuffFactory();

	/**
	 *	Get the factory for BusModelPub data objects.
	 */
	// public IBusModelPubFactory getBusModelFactory();

	/**
	 *	Get the buffer factory for BusModelPub data buffers.
	 */
	// public BusModelPubBuffFactoryService getBusModelBuffFactory();

	/**
	 *	Get the Atom Table interface for the schema.
	 *
	 *	@return	The Atom Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubAtomTable getTableAtom();

	/**
	 *	Get the BlobCol Table interface for the schema.
	 *
	 *	@return	The BlobCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubBlobColTable getTableBlobCol();

	/**
	 *	Get the BlobDef Table interface for the schema.
	 *
	 *	@return	The BlobDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubBlobDefTable getTableBlobDef();

	/**
	 *	Get the BlobType Table interface for the schema.
	 *
	 *	@return	The BlobType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubBlobTypeTable getTableBlobType();

	/**
	 *	Get the BoolCol Table interface for the schema.
	 *
	 *	@return	The BoolCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubBoolColTable getTableBoolCol();

	/**
	 *	Get the BoolDef Table interface for the schema.
	 *
	 *	@return	The BoolDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubBoolDefTable getTableBoolDef();

	/**
	 *	Get the BoolType Table interface for the schema.
	 *
	 *	@return	The BoolType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubBoolTypeTable getTableBoolType();

	/**
	 *	Get the Chain Table interface for the schema.
	 *
	 *	@return	The Chain Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubChainTable getTableChain();

	/**
	 *	Get the ClearDep Table interface for the schema.
	 *
	 *	@return	The ClearDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubClearDepTable getTableClearDep();

	/**
	 *	Get the ClearSubDep1 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep1 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubClearSubDep1Table getTableClearSubDep1();

	/**
	 *	Get the ClearSubDep2 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep2 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubClearSubDep2Table getTableClearSubDep2();

	/**
	 *	Get the ClearSubDep3 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep3 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubClearSubDep3Table getTableClearSubDep3();

	/**
	 *	Get the ClearTopDep Table interface for the schema.
	 *
	 *	@return	The ClearTopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubClearTopDepTable getTableClearTopDep();

	/**
	 *	Get the DateCol Table interface for the schema.
	 *
	 *	@return	The DateCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDateColTable getTableDateCol();

	/**
	 *	Get the DateDef Table interface for the schema.
	 *
	 *	@return	The DateDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDateDefTable getTableDateDef();

	/**
	 *	Get the DateType Table interface for the schema.
	 *
	 *	@return	The DateType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDateTypeTable getTableDateType();

	/**
	 *	Get the DbKeyHash128Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash128ColTable getTableDbKeyHash128Col();

	/**
	 *	Get the DbKeyHash128Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash128DefTable getTableDbKeyHash128Def();

	/**
	 *	Get the DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash128GenTable getTableDbKeyHash128Gen();

	/**
	 *	Get the DbKeyHash128Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash128TypeTable getTableDbKeyHash128Type();

	/**
	 *	Get the DbKeyHash160Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash160ColTable getTableDbKeyHash160Col();

	/**
	 *	Get the DbKeyHash160Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash160DefTable getTableDbKeyHash160Def();

	/**
	 *	Get the DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash160GenTable getTableDbKeyHash160Gen();

	/**
	 *	Get the DbKeyHash160Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash160TypeTable getTableDbKeyHash160Type();

	/**
	 *	Get the DbKeyHash224Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash224ColTable getTableDbKeyHash224Col();

	/**
	 *	Get the DbKeyHash224Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash224DefTable getTableDbKeyHash224Def();

	/**
	 *	Get the DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash224GenTable getTableDbKeyHash224Gen();

	/**
	 *	Get the DbKeyHash224Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash224TypeTable getTableDbKeyHash224Type();

	/**
	 *	Get the DbKeyHash256Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256ColTable getTableDbKeyHash256Col();

	/**
	 *	Get the DbKeyHash256Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256DefTable getTableDbKeyHash256Def();

	/**
	 *	Get the DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256GenTable getTableDbKeyHash256Gen();

	/**
	 *	Get the DbKeyHash256Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash256TypeTable getTableDbKeyHash256Type();

	/**
	 *	Get the DbKeyHash384Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash384ColTable getTableDbKeyHash384Col();

	/**
	 *	Get the DbKeyHash384Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash384DefTable getTableDbKeyHash384Def();

	/**
	 *	Get the DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash384GenTable getTableDbKeyHash384Gen();

	/**
	 *	Get the DbKeyHash384Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash384TypeTable getTableDbKeyHash384Type();

	/**
	 *	Get the DbKeyHash512Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash512ColTable getTableDbKeyHash512Col();

	/**
	 *	Get the DbKeyHash512Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash512DefTable getTableDbKeyHash512Def();

	/**
	 *	Get the DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash512GenTable getTableDbKeyHash512Gen();

	/**
	 *	Get the DbKeyHash512Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDbKeyHash512TypeTable getTableDbKeyHash512Type();

	/**
	 *	Get the DelDep Table interface for the schema.
	 *
	 *	@return	The DelDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelDepTable getTableDelDep();

	/**
	 *	Get the DelSubDep1 Table interface for the schema.
	 *
	 *	@return	The DelSubDep1 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelSubDep1Table getTableDelSubDep1();

	/**
	 *	Get the DelSubDep2 Table interface for the schema.
	 *
	 *	@return	The DelSubDep2 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelSubDep2Table getTableDelSubDep2();

	/**
	 *	Get the DelSubDep3 Table interface for the schema.
	 *
	 *	@return	The DelSubDep3 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelSubDep3Table getTableDelSubDep3();

	/**
	 *	Get the DelTopDep Table interface for the schema.
	 *
	 *	@return	The DelTopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDelTopDepTable getTableDelTopDep();

	/**
	 *	Get the DoubleCol Table interface for the schema.
	 *
	 *	@return	The DoubleCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDoubleColTable getTableDoubleCol();

	/**
	 *	Get the DoubleDef Table interface for the schema.
	 *
	 *	@return	The DoubleDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDoubleDefTable getTableDoubleDef();

	/**
	 *	Get the DoubleType Table interface for the schema.
	 *
	 *	@return	The DoubleType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubDoubleTypeTable getTableDoubleType();

	/**
	 *	Get the EnumDef Table interface for the schema.
	 *
	 *	@return	The EnumDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubEnumDefTable getTableEnumDef();

	/**
	 *	Get the EnumTag Table interface for the schema.
	 *
	 *	@return	The EnumTag Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubEnumTagTable getTableEnumTag();

	/**
	 *	Get the EnumType Table interface for the schema.
	 *
	 *	@return	The EnumType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubEnumTypeTable getTableEnumType();

	/**
	 *	Get the FloatCol Table interface for the schema.
	 *
	 *	@return	The FloatCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubFloatColTable getTableFloatCol();

	/**
	 *	Get the FloatDef Table interface for the schema.
	 *
	 *	@return	The FloatDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubFloatDefTable getTableFloatDef();

	/**
	 *	Get the FloatType Table interface for the schema.
	 *
	 *	@return	The FloatType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubFloatTypeTable getTableFloatType();

	/**
	 *	Get the Id16Gen Table interface for the schema.
	 *
	 *	@return	The Id16Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubId16GenTable getTableId16Gen();

	/**
	 *	Get the Id32Gen Table interface for the schema.
	 *
	 *	@return	The Id32Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubId32GenTable getTableId32Gen();

	/**
	 *	Get the Id64Gen Table interface for the schema.
	 *
	 *	@return	The Id64Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubId64GenTable getTableId64Gen();

	/**
	 *	Get the Index Table interface for the schema.
	 *
	 *	@return	The Index Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubIndexTable getTableIndex();

	/**
	 *	Get the IndexCol Table interface for the schema.
	 *
	 *	@return	The IndexCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubIndexColTable getTableIndexCol();

	/**
	 *	Get the IndexTweak Table interface for the schema.
	 *
	 *	@return	The IndexTweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubIndexTweakTable getTableIndexTweak();

	/**
	 *	Get the Int16Col Table interface for the schema.
	 *
	 *	@return	The Int16Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubInt16ColTable getTableInt16Col();

	/**
	 *	Get the Int16Def Table interface for the schema.
	 *
	 *	@return	The Int16Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubInt16DefTable getTableInt16Def();

	/**
	 *	Get the Int16Type Table interface for the schema.
	 *
	 *	@return	The Int16Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubInt16TypeTable getTableInt16Type();

	/**
	 *	Get the Int32Col Table interface for the schema.
	 *
	 *	@return	The Int32Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubInt32ColTable getTableInt32Col();

	/**
	 *	Get the Int32Def Table interface for the schema.
	 *
	 *	@return	The Int32Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubInt32DefTable getTableInt32Def();

	/**
	 *	Get the Int32Type Table interface for the schema.
	 *
	 *	@return	The Int32Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubInt32TypeTable getTableInt32Type();

	/**
	 *	Get the Int64Col Table interface for the schema.
	 *
	 *	@return	The Int64Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubInt64ColTable getTableInt64Col();

	/**
	 *	Get the Int64Def Table interface for the schema.
	 *
	 *	@return	The Int64Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubInt64DefTable getTableInt64Def();

	/**
	 *	Get the Int64Type Table interface for the schema.
	 *
	 *	@return	The Int64Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubInt64TypeTable getTableInt64Type();

	/**
	 *	Get the NmTokenCol Table interface for the schema.
	 *
	 *	@return	The NmTokenCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubNmTokenColTable getTableNmTokenCol();

	/**
	 *	Get the NmTokenDef Table interface for the schema.
	 *
	 *	@return	The NmTokenDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubNmTokenDefTable getTableNmTokenDef();

	/**
	 *	Get the NmTokenType Table interface for the schema.
	 *
	 *	@return	The NmTokenType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubNmTokenTypeTable getTableNmTokenType();

	/**
	 *	Get the NmTokensCol Table interface for the schema.
	 *
	 *	@return	The NmTokensCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubNmTokensColTable getTableNmTokensCol();

	/**
	 *	Get the NmTokensDef Table interface for the schema.
	 *
	 *	@return	The NmTokensDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubNmTokensDefTable getTableNmTokensDef();

	/**
	 *	Get the NmTokensType Table interface for the schema.
	 *
	 *	@return	The NmTokensType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubNmTokensTypeTable getTableNmTokensType();

	/**
	 *	Get the NumberCol Table interface for the schema.
	 *
	 *	@return	The NumberCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubNumberColTable getTableNumberCol();

	/**
	 *	Get the NumberDef Table interface for the schema.
	 *
	 *	@return	The NumberDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubNumberDefTable getTableNumberDef();

	/**
	 *	Get the NumberType Table interface for the schema.
	 *
	 *	@return	The NumberType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubNumberTypeTable getTableNumberType();

	/**
	 *	Get the Param Table interface for the schema.
	 *
	 *	@return	The Param Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubParamTable getTableParam();

	/**
	 *	Get the PopDep Table interface for the schema.
	 *
	 *	@return	The PopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubPopDepTable getTablePopDep();

	/**
	 *	Get the PopSubDep1 Table interface for the schema.
	 *
	 *	@return	The PopSubDep1 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubPopSubDep1Table getTablePopSubDep1();

	/**
	 *	Get the PopSubDep2 Table interface for the schema.
	 *
	 *	@return	The PopSubDep2 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubPopSubDep2Table getTablePopSubDep2();

	/**
	 *	Get the PopSubDep3 Table interface for the schema.
	 *
	 *	@return	The PopSubDep3 Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubPopSubDep3Table getTablePopSubDep3();

	/**
	 *	Get the PopTopDep Table interface for the schema.
	 *
	 *	@return	The PopTopDep Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubPopTopDepTable getTablePopTopDep();

	/**
	 *	Get the Relation Table interface for the schema.
	 *
	 *	@return	The Relation Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelationTable getTableRelation();

	/**
	 *	Get the RelationCol Table interface for the schema.
	 *
	 *	@return	The RelationCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRelationColTable getTableRelationCol();

	/**
	 *	Get the RoleDef Table interface for the schema.
	 *
	 *	@return	The RoleDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubRoleDefTable getTableRoleDef();

	/**
	 *	Get the SchemaDef Table interface for the schema.
	 *
	 *	@return	The SchemaDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaDefTable getTableSchemaDef();

	/**
	 *	Get the SchemaRef Table interface for the schema.
	 *
	 *	@return	The SchemaRef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRefTable getTableSchemaRef();

	/**
	 *	Get the SchemaRole Table interface for the schema.
	 *
	 *	@return	The SchemaRole Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaRoleTable getTableSchemaRole();

	/**
	 *	Get the SchemaTweak Table interface for the schema.
	 *
	 *	@return	The SchemaTweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubSchemaTweakTable getTableSchemaTweak();

	/**
	 *	Get the Scope Table interface for the schema.
	 *
	 *	@return	The Scope Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubScopeTable getTableScope();

	/**
	 *	Get the ServerListFunc Table interface for the schema.
	 *
	 *	@return	The ServerListFunc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubServerListFuncTable getTableServerListFunc();

	/**
	 *	Get the ServerMethod Table interface for the schema.
	 *
	 *	@return	The ServerMethod Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubServerMethodTable getTableServerMethod();

	/**
	 *	Get the ServerObjFunc Table interface for the schema.
	 *
	 *	@return	The ServerObjFunc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubServerObjFuncTable getTableServerObjFunc();

	/**
	 *	Get the ServerProc Table interface for the schema.
	 *
	 *	@return	The ServerProc Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubServerProcTable getTableServerProc();

	/**
	 *	Get the StringCol Table interface for the schema.
	 *
	 *	@return	The StringCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubStringColTable getTableStringCol();

	/**
	 *	Get the StringDef Table interface for the schema.
	 *
	 *	@return	The StringDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubStringDefTable getTableStringDef();

	/**
	 *	Get the StringType Table interface for the schema.
	 *
	 *	@return	The StringType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubStringTypeTable getTableStringType();

	/**
	 *	Get the TZDateCol Table interface for the schema.
	 *
	 *	@return	The TZDateCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTZDateColTable getTableTZDateCol();

	/**
	 *	Get the TZDateDef Table interface for the schema.
	 *
	 *	@return	The TZDateDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTZDateDefTable getTableTZDateDef();

	/**
	 *	Get the TZDateType Table interface for the schema.
	 *
	 *	@return	The TZDateType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTZDateTypeTable getTableTZDateType();

	/**
	 *	Get the TZTimeCol Table interface for the schema.
	 *
	 *	@return	The TZTimeCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTZTimeColTable getTableTZTimeCol();

	/**
	 *	Get the TZTimeDef Table interface for the schema.
	 *
	 *	@return	The TZTimeDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTZTimeDefTable getTableTZTimeDef();

	/**
	 *	Get the TZTimeType Table interface for the schema.
	 *
	 *	@return	The TZTimeType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTZTimeTypeTable getTableTZTimeType();

	/**
	 *	Get the TZTimestampCol Table interface for the schema.
	 *
	 *	@return	The TZTimestampCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTZTimestampColTable getTableTZTimestampCol();

	/**
	 *	Get the TZTimestampDef Table interface for the schema.
	 *
	 *	@return	The TZTimestampDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTZTimestampDefTable getTableTZTimestampDef();

	/**
	 *	Get the TZTimestampType Table interface for the schema.
	 *
	 *	@return	The TZTimestampType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTZTimestampTypeTable getTableTZTimestampType();

	/**
	 *	Get the Table Table interface for the schema.
	 *
	 *	@return	The Table Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTableTable getTableTable();

	/**
	 *	Get the TableCol Table interface for the schema.
	 *
	 *	@return	The TableCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTableColTable getTableTableCol();

	/**
	 *	Get the TableTweak Table interface for the schema.
	 *
	 *	@return	The TableTweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTableTweakTable getTableTableTweak();

	/**
	 *	Get the TextCol Table interface for the schema.
	 *
	 *	@return	The TextCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTextColTable getTableTextCol();

	/**
	 *	Get the TextDef Table interface for the schema.
	 *
	 *	@return	The TextDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTextDefTable getTableTextDef();

	/**
	 *	Get the TextType Table interface for the schema.
	 *
	 *	@return	The TextType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTextTypeTable getTableTextType();

	/**
	 *	Get the TimeCol Table interface for the schema.
	 *
	 *	@return	The TimeCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTimeColTable getTableTimeCol();

	/**
	 *	Get the TimeDef Table interface for the schema.
	 *
	 *	@return	The TimeDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTimeDefTable getTableTimeDef();

	/**
	 *	Get the TimeType Table interface for the schema.
	 *
	 *	@return	The TimeType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTimeTypeTable getTableTimeType();

	/**
	 *	Get the TimestampCol Table interface for the schema.
	 *
	 *	@return	The TimestampCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTimestampColTable getTableTimestampCol();

	/**
	 *	Get the TimestampDef Table interface for the schema.
	 *
	 *	@return	The TimestampDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTimestampDefTable getTableTimestampDef();

	/**
	 *	Get the TimestampType Table interface for the schema.
	 *
	 *	@return	The TimestampType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTimestampTypeTable getTableTimestampType();

	/**
	 *	Get the TokenCol Table interface for the schema.
	 *
	 *	@return	The TokenCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTokenColTable getTableTokenCol();

	/**
	 *	Get the TokenDef Table interface for the schema.
	 *
	 *	@return	The TokenDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTokenDefTable getTableTokenDef();

	/**
	 *	Get the TokenType Table interface for the schema.
	 *
	 *	@return	The TokenType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTokenTypeTable getTableTokenType();

	/**
	 *	Get the Tweak Table interface for the schema.
	 *
	 *	@return	The Tweak Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubTweakTable getTableTweak();

	/**
	 *	Get the UInt16Col Table interface for the schema.
	 *
	 *	@return	The UInt16Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUInt16ColTable getTableUInt16Col();

	/**
	 *	Get the UInt16Def Table interface for the schema.
	 *
	 *	@return	The UInt16Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUInt16DefTable getTableUInt16Def();

	/**
	 *	Get the UInt16Type Table interface for the schema.
	 *
	 *	@return	The UInt16Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUInt16TypeTable getTableUInt16Type();

	/**
	 *	Get the UInt32Col Table interface for the schema.
	 *
	 *	@return	The UInt32Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUInt32ColTable getTableUInt32Col();

	/**
	 *	Get the UInt32Def Table interface for the schema.
	 *
	 *	@return	The UInt32Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUInt32DefTable getTableUInt32Def();

	/**
	 *	Get the UInt32Type Table interface for the schema.
	 *
	 *	@return	The UInt32Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUInt32TypeTable getTableUInt32Type();

	/**
	 *	Get the UInt64Col Table interface for the schema.
	 *
	 *	@return	The UInt64Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUInt64ColTable getTableUInt64Col();

	/**
	 *	Get the UInt64Def Table interface for the schema.
	 *
	 *	@return	The UInt64Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUInt64DefTable getTableUInt64Def();

	/**
	 *	Get the UInt64Type Table interface for the schema.
	 *
	 *	@return	The UInt64Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUInt64TypeTable getTableUInt64Type();

	/**
	 *	Get the Uuid6Col Table interface for the schema.
	 *
	 *	@return	The Uuid6Col Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUuid6ColTable getTableUuid6Col();

	/**
	 *	Get the Uuid6Def Table interface for the schema.
	 *
	 *	@return	The Uuid6Def Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUuid6DefTable getTableUuid6Def();

	/**
	 *	Get the Uuid6Gen Table interface for the schema.
	 *
	 *	@return	The Uuid6Gen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUuid6GenTable getTableUuid6Gen();

	/**
	 *	Get the Uuid6Type Table interface for the schema.
	 *
	 *	@return	The Uuid6Type Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUuid6TypeTable getTableUuid6Type();

	/**
	 *	Get the UuidCol Table interface for the schema.
	 *
	 *	@return	The UuidCol Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUuidColTable getTableUuidCol();

	/**
	 *	Get the UuidDef Table interface for the schema.
	 *
	 *	@return	The UuidDef Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUuidDefTable getTableUuidDef();

	/**
	 *	Get the UuidGen Table interface for the schema.
	 *
	 *	@return	The UuidGen Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUuidGenTable getTableUuidGen();

	/**
	 *	Get the UuidType Table interface for the schema.
	 *
	 *	@return	The UuidType Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubUuidTypeTable getTableUuidType();

	/**
	 *	Get the Value Table interface for the schema.
	 *
	 *	@return	The Value Table interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	public IBusModelPubValueTable getTableValue();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static ISecurePubTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ISecurePubTablePerms getSecurePubTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ISecurePubTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws YCFNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ISecurePubTablePerms value );

	public void bootstrapSchema(SecurePubTableData tableData[]);
	public void bootstrapAllTablesSecurity(YCFDbKeyHash256 clusterId, YCFDbKeyHash256 tenantId, SecurePubTableData tableData[]);
}
