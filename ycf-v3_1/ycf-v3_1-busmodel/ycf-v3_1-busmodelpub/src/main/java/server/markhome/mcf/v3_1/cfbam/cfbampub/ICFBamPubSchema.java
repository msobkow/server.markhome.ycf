// Description: Java 25 public interface for a CFBam schema.

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

package server.markhome.mcf.v3_1.cfbam.cfbampub;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;
import server.markhome.mcf.v3_1.cflib.*;
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

//import server.markhome.mcf.v3_1.cfsec.cfsecpub.buff.CFSecPubBuffFactoryService;
//import server.markhome.mcf.v3_1.cfint.cfintpub.buff.CFIntPubBuffFactoryService;
//import server.markhome.mcf.v3_1.cfbam.cfbampub.buff.CFBamPubBuffFactoryService;

public interface ICFBamPubSchema
extends ICFSecPubSchema,
	ICFIntPubSchema
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
			for( CFSecPubTableData data: ICFSecPubSchema.getTableData()) {
				lst.add(data);
			}
			for( CFSecPubTableData data: ICFIntPubSchema.getTableData()) {
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
			for( CFSecPubRoleInfo info: ICFSecPubSchema.getRoleInfo()) {
				lst.add(info);
			}
			for( CFSecPubRoleInfo info: ICFIntPubSchema.getRoleInfo()) {
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

		final static ArrayList<ICFSecPubSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ICFSecPubSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ICFSecPubSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<ICFBamPubSchema> backingCFBam = new AtomicReference<>();
	public enum LoaderBehaviourEnum {
		Insert,
		Update,
		Replace
	};

	static HashMap<String,LoaderBehaviourEnum> lookupLoaderBehaviourEnum = new HashMap<String,LoaderBehaviourEnum>();

	public static LoaderBehaviourEnum parseLoaderBehaviourEnum( String value ) {
		LoaderBehaviourEnum retval = parseLoaderBehaviourEnum( ICFBamPubSchema.class.getName(), value );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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
			retval = ordinalToLoaderBehaviourEnum( ICFBamPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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
		RelationTypeEnum retval = parseRelationTypeEnum( ICFBamPubSchema.class.getName(), value );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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
			retval = ordinalToRelationTypeEnum( ICFBamPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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
		CodeVisibilityEnum retval = parseCodeVisibilityEnum( ICFBamPubSchema.class.getName(), value );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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
			retval = ordinalToCodeVisibilityEnum( ICFBamPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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
		SecScopeEnum retval = parseSecScopeEnum( ICFBamPubSchema.class.getName(), value );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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
			retval = ordinalToSecScopeEnum( ICFBamPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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
		RoleScopeEnum retval = parseRoleScopeEnum( ICFBamPubSchema.class.getName(), value );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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
			retval = ordinalToRoleScopeEnum( ICFBamPubSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
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
				throw new MCFInvalidArgumentException( fieldOrClassName,
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

		public static ICFBamPubSchema getBackingCFBam() {
			return( ICFBamPubSchema.backingCFBam.get() );
		}
		
		public static void setBackingPubSchema(ICFBamPubSchema backingSchema) {
			ICFBamPubSchema.backingCFBam.set(backingSchema);
		}
		
		public ICFBamPubSchema getCFBamSchema();
		public void setCFBamSchema(ICFBamPubSchema schema);

		public static int doInitClassMapEntries(int value) {
			value = ICFSecPubSchema.doInitClassMapEntries(value);
			value = ICFIntPubSchema.doInitClassMapEntries(value);
			if (ICFBamPubSchema.entries.isEmpty()) {
				ICFSecPubSchema.ClassMapEntry entry;
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Atom", ICFBamPubAtom.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "BlobCol", ICFBamPubBlobCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "BlobDef", ICFBamPubBlobDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "BlobType", ICFBamPubBlobType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "BoolCol", ICFBamPubBoolCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "BoolDef", ICFBamPubBoolDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "BoolType", ICFBamPubBoolType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Chain", ICFBamPubChain.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "ClearDep", ICFBamPubClearDep.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "ClearSubDep1", ICFBamPubClearSubDep1.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "ClearSubDep2", ICFBamPubClearSubDep2.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "ClearSubDep3", ICFBamPubClearSubDep3.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "ClearTopDep", ICFBamPubClearTopDep.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DateCol", ICFBamPubDateCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DateDef", ICFBamPubDateDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DateType", ICFBamPubDateType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash128Col", ICFBamPubDbKeyHash128Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash128Def", ICFBamPubDbKeyHash128Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash128Gen", ICFBamPubDbKeyHash128Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash128Type", ICFBamPubDbKeyHash128Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash160Col", ICFBamPubDbKeyHash160Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash160Def", ICFBamPubDbKeyHash160Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash160Gen", ICFBamPubDbKeyHash160Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash160Type", ICFBamPubDbKeyHash160Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash224Col", ICFBamPubDbKeyHash224Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash224Def", ICFBamPubDbKeyHash224Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash224Gen", ICFBamPubDbKeyHash224Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash224Type", ICFBamPubDbKeyHash224Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash256Col", ICFBamPubDbKeyHash256Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash256Def", ICFBamPubDbKeyHash256Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash256Gen", ICFBamPubDbKeyHash256Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash256Type", ICFBamPubDbKeyHash256Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash384Col", ICFBamPubDbKeyHash384Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash384Def", ICFBamPubDbKeyHash384Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash384Gen", ICFBamPubDbKeyHash384Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash384Type", ICFBamPubDbKeyHash384Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash512Col", ICFBamPubDbKeyHash512Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash512Def", ICFBamPubDbKeyHash512Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash512Gen", ICFBamPubDbKeyHash512Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DbKeyHash512Type", ICFBamPubDbKeyHash512Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DelDep", ICFBamPubDelDep.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DelSubDep1", ICFBamPubDelSubDep1.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DelSubDep2", ICFBamPubDelSubDep2.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DelSubDep3", ICFBamPubDelSubDep3.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DelTopDep", ICFBamPubDelTopDep.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DoubleCol", ICFBamPubDoubleCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DoubleDef", ICFBamPubDoubleDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "DoubleType", ICFBamPubDoubleType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "EnumDef", ICFBamPubEnumDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "EnumTag", ICFBamPubEnumTag.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "EnumType", ICFBamPubEnumType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "FloatCol", ICFBamPubFloatCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "FloatDef", ICFBamPubFloatDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "FloatType", ICFBamPubFloatType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Id16Gen", ICFBamPubId16Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Id32Gen", ICFBamPubId32Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Id64Gen", ICFBamPubId64Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Index", ICFBamPubIndex.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "IndexCol", ICFBamPubIndexCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "IndexTweak", ICFBamPubIndexTweak.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Int16Col", ICFBamPubInt16Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Int16Def", ICFBamPubInt16Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Int16Type", ICFBamPubInt16Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Int32Col", ICFBamPubInt32Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Int32Def", ICFBamPubInt32Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Int32Type", ICFBamPubInt32Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Int64Col", ICFBamPubInt64Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Int64Def", ICFBamPubInt64Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Int64Type", ICFBamPubInt64Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "NmTokenCol", ICFBamPubNmTokenCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "NmTokenDef", ICFBamPubNmTokenDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "NmTokenType", ICFBamPubNmTokenType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "NmTokensCol", ICFBamPubNmTokensCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "NmTokensDef", ICFBamPubNmTokensDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "NmTokensType", ICFBamPubNmTokensType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "NumberCol", ICFBamPubNumberCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "NumberDef", ICFBamPubNumberDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "NumberType", ICFBamPubNumberType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Param", ICFBamPubParam.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "PopDep", ICFBamPubPopDep.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "PopSubDep1", ICFBamPubPopSubDep1.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "PopSubDep2", ICFBamPubPopSubDep2.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "PopSubDep3", ICFBamPubPopSubDep3.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "PopTopDep", ICFBamPubPopTopDep.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Relation", ICFBamPubRelation.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "RelationCol", ICFBamPubRelationCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "RoleDef", ICFBamPubRoleDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "SchemaDef", ICFBamPubSchemaDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "SchemaRef", ICFBamPubSchemaRef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "SchemaRole", ICFBamPubSchemaRole.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "SchemaTweak", ICFBamPubSchemaTweak.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Scope", ICFBamPubScope.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "ServerListFunc", ICFBamPubServerListFunc.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "ServerMethod", ICFBamPubServerMethod.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "ServerObjFunc", ICFBamPubServerObjFunc.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "ServerProc", ICFBamPubServerProc.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "StringCol", ICFBamPubStringCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "StringDef", ICFBamPubStringDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "StringType", ICFBamPubStringType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TZDateCol", ICFBamPubTZDateCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TZDateDef", ICFBamPubTZDateDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TZDateType", ICFBamPubTZDateType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TZTimeCol", ICFBamPubTZTimeCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TZTimeDef", ICFBamPubTZTimeDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TZTimeType", ICFBamPubTZTimeType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TZTimestampCol", ICFBamPubTZTimestampCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TZTimestampDef", ICFBamPubTZTimestampDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TZTimestampType", ICFBamPubTZTimestampType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Table", ICFBamPubTable.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TableCol", ICFBamPubTableCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TableTweak", ICFBamPubTableTweak.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TextCol", ICFBamPubTextCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TextDef", ICFBamPubTextDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TextType", ICFBamPubTextType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TimeCol", ICFBamPubTimeCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TimeDef", ICFBamPubTimeDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TimeType", ICFBamPubTimeType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TimestampCol", ICFBamPubTimestampCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TimestampDef", ICFBamPubTimestampDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TimestampType", ICFBamPubTimestampType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TokenCol", ICFBamPubTokenCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TokenDef", ICFBamPubTokenDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "TokenType", ICFBamPubTokenType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Tweak", ICFBamPubTweak.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UInt16Col", ICFBamPubUInt16Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UInt16Def", ICFBamPubUInt16Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UInt16Type", ICFBamPubUInt16Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UInt32Col", ICFBamPubUInt32Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UInt32Def", ICFBamPubUInt32Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UInt32Type", ICFBamPubUInt32Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UInt64Col", ICFBamPubUInt64Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UInt64Def", ICFBamPubUInt64Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UInt64Type", ICFBamPubUInt64Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Uuid6Col", ICFBamPubUuid6Col.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Uuid6Def", ICFBamPubUuid6Def.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Uuid6Gen", ICFBamPubUuid6Gen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Uuid6Type", ICFBamPubUuid6Type.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UuidCol", ICFBamPubUuidCol.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UuidDef", ICFBamPubUuidDef.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UuidGen", ICFBamPubUuidGen.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "UuidType", ICFBamPubUuidType.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				entry = new ICFSecPubSchema.ClassMapEntry(ICFBamPubSchema.SCHEMA_NAME, "Value", ICFBamPubValue.CLASS_CODE);
				ICFBamPubSchema.entries.add(entry);
				for( ICFSecPubSchema.ClassMapEntry cur: ICFBamPubSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				ICFBamPubSchema.mapBackingClassCodeToEntry.clear();
				ICFBamPubSchema.mapRuntimeClassCodeToEntry.clear();
				for( ICFSecPubSchema.ClassMapEntry cur: ICFBamPubSchema.entries) {
					ICFBamPubSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					ICFBamPubSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ICFSecPubSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ICFSecPubSchema.ClassMapEntry entry;
			entry = ICFSecPubSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = ICFIntPubSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = ICFBamPubSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ICFSecPubSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ICFSecPubSchema.ClassMapEntry entry;
			entry = ICFSecPubSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = ICFIntPubSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			entry = ICFBamPubSchema.mapRuntimeClassCodeToEntry.get(code);
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
	 *	@return	A new ICFSecPubSchema instance.
	 */
	public ICFSecPubSchema newSchema();

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
	 *	Get the factory for CFSecPub data objects.
	 */
	// public ICFSecPubFactory getCFSecFactory();

	/**
	 *	Get the buffer factory for CFSecPub data buffers.
	 */
	// public CFSecPubBuffFactoryService getCFSecBuffFactory();

	/**
	 *	Get the factory for CFIntPub data objects.
	 */
	// public ICFIntPubFactory getCFIntFactory();

	/**
	 *	Get the buffer factory for CFIntPub data buffers.
	 */
	// public CFIntPubBuffFactoryService getCFIntBuffFactory();

	/**
	 *	Get the factory for CFBamPub data objects.
	 */
	// public ICFBamPubFactory getCFBamFactory();

	/**
	 *	Get the buffer factory for CFBamPub data buffers.
	 */
	// public CFBamPubBuffFactoryService getCFBamBuffFactory();

	/**
	 *	Get the Atom Table interface for the schema.
	 *
	 *	@return	The Atom Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubAtomTable getTableAtom();

	/**
	 *	Get the BlobCol Table interface for the schema.
	 *
	 *	@return	The BlobCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubBlobColTable getTableBlobCol();

	/**
	 *	Get the BlobDef Table interface for the schema.
	 *
	 *	@return	The BlobDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubBlobDefTable getTableBlobDef();

	/**
	 *	Get the BlobType Table interface for the schema.
	 *
	 *	@return	The BlobType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubBlobTypeTable getTableBlobType();

	/**
	 *	Get the BoolCol Table interface for the schema.
	 *
	 *	@return	The BoolCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubBoolColTable getTableBoolCol();

	/**
	 *	Get the BoolDef Table interface for the schema.
	 *
	 *	@return	The BoolDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubBoolDefTable getTableBoolDef();

	/**
	 *	Get the BoolType Table interface for the schema.
	 *
	 *	@return	The BoolType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubBoolTypeTable getTableBoolType();

	/**
	 *	Get the Chain Table interface for the schema.
	 *
	 *	@return	The Chain Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubChainTable getTableChain();

	/**
	 *	Get the ClearDep Table interface for the schema.
	 *
	 *	@return	The ClearDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubClearDepTable getTableClearDep();

	/**
	 *	Get the ClearSubDep1 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep1 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubClearSubDep1Table getTableClearSubDep1();

	/**
	 *	Get the ClearSubDep2 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep2 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubClearSubDep2Table getTableClearSubDep2();

	/**
	 *	Get the ClearSubDep3 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep3 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubClearSubDep3Table getTableClearSubDep3();

	/**
	 *	Get the ClearTopDep Table interface for the schema.
	 *
	 *	@return	The ClearTopDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubClearTopDepTable getTableClearTopDep();

	/**
	 *	Get the DateCol Table interface for the schema.
	 *
	 *	@return	The DateCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDateColTable getTableDateCol();

	/**
	 *	Get the DateDef Table interface for the schema.
	 *
	 *	@return	The DateDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDateDefTable getTableDateDef();

	/**
	 *	Get the DateType Table interface for the schema.
	 *
	 *	@return	The DateType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDateTypeTable getTableDateType();

	/**
	 *	Get the DbKeyHash128Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash128ColTable getTableDbKeyHash128Col();

	/**
	 *	Get the DbKeyHash128Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash128DefTable getTableDbKeyHash128Def();

	/**
	 *	Get the DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash128GenTable getTableDbKeyHash128Gen();

	/**
	 *	Get the DbKeyHash128Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash128Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash128TypeTable getTableDbKeyHash128Type();

	/**
	 *	Get the DbKeyHash160Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash160ColTable getTableDbKeyHash160Col();

	/**
	 *	Get the DbKeyHash160Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash160DefTable getTableDbKeyHash160Def();

	/**
	 *	Get the DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash160GenTable getTableDbKeyHash160Gen();

	/**
	 *	Get the DbKeyHash160Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash160Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash160TypeTable getTableDbKeyHash160Type();

	/**
	 *	Get the DbKeyHash224Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash224ColTable getTableDbKeyHash224Col();

	/**
	 *	Get the DbKeyHash224Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash224DefTable getTableDbKeyHash224Def();

	/**
	 *	Get the DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash224GenTable getTableDbKeyHash224Gen();

	/**
	 *	Get the DbKeyHash224Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash224Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash224TypeTable getTableDbKeyHash224Type();

	/**
	 *	Get the DbKeyHash256Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash256ColTable getTableDbKeyHash256Col();

	/**
	 *	Get the DbKeyHash256Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash256DefTable getTableDbKeyHash256Def();

	/**
	 *	Get the DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash256GenTable getTableDbKeyHash256Gen();

	/**
	 *	Get the DbKeyHash256Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash256Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash256TypeTable getTableDbKeyHash256Type();

	/**
	 *	Get the DbKeyHash384Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash384ColTable getTableDbKeyHash384Col();

	/**
	 *	Get the DbKeyHash384Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash384DefTable getTableDbKeyHash384Def();

	/**
	 *	Get the DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash384GenTable getTableDbKeyHash384Gen();

	/**
	 *	Get the DbKeyHash384Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash384Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash384TypeTable getTableDbKeyHash384Type();

	/**
	 *	Get the DbKeyHash512Col Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash512ColTable getTableDbKeyHash512Col();

	/**
	 *	Get the DbKeyHash512Def Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash512DefTable getTableDbKeyHash512Def();

	/**
	 *	Get the DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash512GenTable getTableDbKeyHash512Gen();

	/**
	 *	Get the DbKeyHash512Type Table interface for the schema.
	 *
	 *	@return	The DbKeyHash512Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDbKeyHash512TypeTable getTableDbKeyHash512Type();

	/**
	 *	Get the DelDep Table interface for the schema.
	 *
	 *	@return	The DelDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDelDepTable getTableDelDep();

	/**
	 *	Get the DelSubDep1 Table interface for the schema.
	 *
	 *	@return	The DelSubDep1 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDelSubDep1Table getTableDelSubDep1();

	/**
	 *	Get the DelSubDep2 Table interface for the schema.
	 *
	 *	@return	The DelSubDep2 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDelSubDep2Table getTableDelSubDep2();

	/**
	 *	Get the DelSubDep3 Table interface for the schema.
	 *
	 *	@return	The DelSubDep3 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDelSubDep3Table getTableDelSubDep3();

	/**
	 *	Get the DelTopDep Table interface for the schema.
	 *
	 *	@return	The DelTopDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDelTopDepTable getTableDelTopDep();

	/**
	 *	Get the DoubleCol Table interface for the schema.
	 *
	 *	@return	The DoubleCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDoubleColTable getTableDoubleCol();

	/**
	 *	Get the DoubleDef Table interface for the schema.
	 *
	 *	@return	The DoubleDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDoubleDefTable getTableDoubleDef();

	/**
	 *	Get the DoubleType Table interface for the schema.
	 *
	 *	@return	The DoubleType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubDoubleTypeTable getTableDoubleType();

	/**
	 *	Get the EnumDef Table interface for the schema.
	 *
	 *	@return	The EnumDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubEnumDefTable getTableEnumDef();

	/**
	 *	Get the EnumTag Table interface for the schema.
	 *
	 *	@return	The EnumTag Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubEnumTagTable getTableEnumTag();

	/**
	 *	Get the EnumType Table interface for the schema.
	 *
	 *	@return	The EnumType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubEnumTypeTable getTableEnumType();

	/**
	 *	Get the FloatCol Table interface for the schema.
	 *
	 *	@return	The FloatCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubFloatColTable getTableFloatCol();

	/**
	 *	Get the FloatDef Table interface for the schema.
	 *
	 *	@return	The FloatDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubFloatDefTable getTableFloatDef();

	/**
	 *	Get the FloatType Table interface for the schema.
	 *
	 *	@return	The FloatType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubFloatTypeTable getTableFloatType();

	/**
	 *	Get the Id16Gen Table interface for the schema.
	 *
	 *	@return	The Id16Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubId16GenTable getTableId16Gen();

	/**
	 *	Get the Id32Gen Table interface for the schema.
	 *
	 *	@return	The Id32Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubId32GenTable getTableId32Gen();

	/**
	 *	Get the Id64Gen Table interface for the schema.
	 *
	 *	@return	The Id64Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubId64GenTable getTableId64Gen();

	/**
	 *	Get the Index Table interface for the schema.
	 *
	 *	@return	The Index Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTable getTableIndex();

	/**
	 *	Get the IndexCol Table interface for the schema.
	 *
	 *	@return	The IndexCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexColTable getTableIndexCol();

	/**
	 *	Get the IndexTweak Table interface for the schema.
	 *
	 *	@return	The IndexTweak Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubIndexTweakTable getTableIndexTweak();

	/**
	 *	Get the Int16Col Table interface for the schema.
	 *
	 *	@return	The Int16Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubInt16ColTable getTableInt16Col();

	/**
	 *	Get the Int16Def Table interface for the schema.
	 *
	 *	@return	The Int16Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubInt16DefTable getTableInt16Def();

	/**
	 *	Get the Int16Type Table interface for the schema.
	 *
	 *	@return	The Int16Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubInt16TypeTable getTableInt16Type();

	/**
	 *	Get the Int32Col Table interface for the schema.
	 *
	 *	@return	The Int32Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubInt32ColTable getTableInt32Col();

	/**
	 *	Get the Int32Def Table interface for the schema.
	 *
	 *	@return	The Int32Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubInt32DefTable getTableInt32Def();

	/**
	 *	Get the Int32Type Table interface for the schema.
	 *
	 *	@return	The Int32Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubInt32TypeTable getTableInt32Type();

	/**
	 *	Get the Int64Col Table interface for the schema.
	 *
	 *	@return	The Int64Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubInt64ColTable getTableInt64Col();

	/**
	 *	Get the Int64Def Table interface for the schema.
	 *
	 *	@return	The Int64Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubInt64DefTable getTableInt64Def();

	/**
	 *	Get the Int64Type Table interface for the schema.
	 *
	 *	@return	The Int64Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubInt64TypeTable getTableInt64Type();

	/**
	 *	Get the NmTokenCol Table interface for the schema.
	 *
	 *	@return	The NmTokenCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubNmTokenColTable getTableNmTokenCol();

	/**
	 *	Get the NmTokenDef Table interface for the schema.
	 *
	 *	@return	The NmTokenDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubNmTokenDefTable getTableNmTokenDef();

	/**
	 *	Get the NmTokenType Table interface for the schema.
	 *
	 *	@return	The NmTokenType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubNmTokenTypeTable getTableNmTokenType();

	/**
	 *	Get the NmTokensCol Table interface for the schema.
	 *
	 *	@return	The NmTokensCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubNmTokensColTable getTableNmTokensCol();

	/**
	 *	Get the NmTokensDef Table interface for the schema.
	 *
	 *	@return	The NmTokensDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubNmTokensDefTable getTableNmTokensDef();

	/**
	 *	Get the NmTokensType Table interface for the schema.
	 *
	 *	@return	The NmTokensType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubNmTokensTypeTable getTableNmTokensType();

	/**
	 *	Get the NumberCol Table interface for the schema.
	 *
	 *	@return	The NumberCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubNumberColTable getTableNumberCol();

	/**
	 *	Get the NumberDef Table interface for the schema.
	 *
	 *	@return	The NumberDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubNumberDefTable getTableNumberDef();

	/**
	 *	Get the NumberType Table interface for the schema.
	 *
	 *	@return	The NumberType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubNumberTypeTable getTableNumberType();

	/**
	 *	Get the Param Table interface for the schema.
	 *
	 *	@return	The Param Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubParamTable getTableParam();

	/**
	 *	Get the PopDep Table interface for the schema.
	 *
	 *	@return	The PopDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopDepTable getTablePopDep();

	/**
	 *	Get the PopSubDep1 Table interface for the schema.
	 *
	 *	@return	The PopSubDep1 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep1Table getTablePopSubDep1();

	/**
	 *	Get the PopSubDep2 Table interface for the schema.
	 *
	 *	@return	The PopSubDep2 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep2Table getTablePopSubDep2();

	/**
	 *	Get the PopSubDep3 Table interface for the schema.
	 *
	 *	@return	The PopSubDep3 Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopSubDep3Table getTablePopSubDep3();

	/**
	 *	Get the PopTopDep Table interface for the schema.
	 *
	 *	@return	The PopTopDep Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubPopTopDepTable getTablePopTopDep();

	/**
	 *	Get the Relation Table interface for the schema.
	 *
	 *	@return	The Relation Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubRelationTable getTableRelation();

	/**
	 *	Get the RelationCol Table interface for the schema.
	 *
	 *	@return	The RelationCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubRelationColTable getTableRelationCol();

	/**
	 *	Get the RoleDef Table interface for the schema.
	 *
	 *	@return	The RoleDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubRoleDefTable getTableRoleDef();

	/**
	 *	Get the SchemaDef Table interface for the schema.
	 *
	 *	@return	The SchemaDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubSchemaDefTable getTableSchemaDef();

	/**
	 *	Get the SchemaRef Table interface for the schema.
	 *
	 *	@return	The SchemaRef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubSchemaRefTable getTableSchemaRef();

	/**
	 *	Get the SchemaRole Table interface for the schema.
	 *
	 *	@return	The SchemaRole Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubSchemaRoleTable getTableSchemaRole();

	/**
	 *	Get the SchemaTweak Table interface for the schema.
	 *
	 *	@return	The SchemaTweak Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubSchemaTweakTable getTableSchemaTweak();

	/**
	 *	Get the Scope Table interface for the schema.
	 *
	 *	@return	The Scope Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubScopeTable getTableScope();

	/**
	 *	Get the ServerListFunc Table interface for the schema.
	 *
	 *	@return	The ServerListFunc Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubServerListFuncTable getTableServerListFunc();

	/**
	 *	Get the ServerMethod Table interface for the schema.
	 *
	 *	@return	The ServerMethod Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubServerMethodTable getTableServerMethod();

	/**
	 *	Get the ServerObjFunc Table interface for the schema.
	 *
	 *	@return	The ServerObjFunc Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubServerObjFuncTable getTableServerObjFunc();

	/**
	 *	Get the ServerProc Table interface for the schema.
	 *
	 *	@return	The ServerProc Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubServerProcTable getTableServerProc();

	/**
	 *	Get the StringCol Table interface for the schema.
	 *
	 *	@return	The StringCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubStringColTable getTableStringCol();

	/**
	 *	Get the StringDef Table interface for the schema.
	 *
	 *	@return	The StringDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubStringDefTable getTableStringDef();

	/**
	 *	Get the StringType Table interface for the schema.
	 *
	 *	@return	The StringType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubStringTypeTable getTableStringType();

	/**
	 *	Get the TZDateCol Table interface for the schema.
	 *
	 *	@return	The TZDateCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTZDateColTable getTableTZDateCol();

	/**
	 *	Get the TZDateDef Table interface for the schema.
	 *
	 *	@return	The TZDateDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTZDateDefTable getTableTZDateDef();

	/**
	 *	Get the TZDateType Table interface for the schema.
	 *
	 *	@return	The TZDateType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTZDateTypeTable getTableTZDateType();

	/**
	 *	Get the TZTimeCol Table interface for the schema.
	 *
	 *	@return	The TZTimeCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTZTimeColTable getTableTZTimeCol();

	/**
	 *	Get the TZTimeDef Table interface for the schema.
	 *
	 *	@return	The TZTimeDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTZTimeDefTable getTableTZTimeDef();

	/**
	 *	Get the TZTimeType Table interface for the schema.
	 *
	 *	@return	The TZTimeType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTZTimeTypeTable getTableTZTimeType();

	/**
	 *	Get the TZTimestampCol Table interface for the schema.
	 *
	 *	@return	The TZTimestampCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTZTimestampColTable getTableTZTimestampCol();

	/**
	 *	Get the TZTimestampDef Table interface for the schema.
	 *
	 *	@return	The TZTimestampDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTZTimestampDefTable getTableTZTimestampDef();

	/**
	 *	Get the TZTimestampType Table interface for the schema.
	 *
	 *	@return	The TZTimestampType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTZTimestampTypeTable getTableTZTimestampType();

	/**
	 *	Get the Table Table interface for the schema.
	 *
	 *	@return	The Table Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTableTable getTableTable();

	/**
	 *	Get the TableCol Table interface for the schema.
	 *
	 *	@return	The TableCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTableColTable getTableTableCol();

	/**
	 *	Get the TableTweak Table interface for the schema.
	 *
	 *	@return	The TableTweak Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTableTweakTable getTableTableTweak();

	/**
	 *	Get the TextCol Table interface for the schema.
	 *
	 *	@return	The TextCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTextColTable getTableTextCol();

	/**
	 *	Get the TextDef Table interface for the schema.
	 *
	 *	@return	The TextDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTextDefTable getTableTextDef();

	/**
	 *	Get the TextType Table interface for the schema.
	 *
	 *	@return	The TextType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTextTypeTable getTableTextType();

	/**
	 *	Get the TimeCol Table interface for the schema.
	 *
	 *	@return	The TimeCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTimeColTable getTableTimeCol();

	/**
	 *	Get the TimeDef Table interface for the schema.
	 *
	 *	@return	The TimeDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTimeDefTable getTableTimeDef();

	/**
	 *	Get the TimeType Table interface for the schema.
	 *
	 *	@return	The TimeType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTimeTypeTable getTableTimeType();

	/**
	 *	Get the TimestampCol Table interface for the schema.
	 *
	 *	@return	The TimestampCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTimestampColTable getTableTimestampCol();

	/**
	 *	Get the TimestampDef Table interface for the schema.
	 *
	 *	@return	The TimestampDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTimestampDefTable getTableTimestampDef();

	/**
	 *	Get the TimestampType Table interface for the schema.
	 *
	 *	@return	The TimestampType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTimestampTypeTable getTableTimestampType();

	/**
	 *	Get the TokenCol Table interface for the schema.
	 *
	 *	@return	The TokenCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTokenColTable getTableTokenCol();

	/**
	 *	Get the TokenDef Table interface for the schema.
	 *
	 *	@return	The TokenDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTokenDefTable getTableTokenDef();

	/**
	 *	Get the TokenType Table interface for the schema.
	 *
	 *	@return	The TokenType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTokenTypeTable getTableTokenType();

	/**
	 *	Get the Tweak Table interface for the schema.
	 *
	 *	@return	The Tweak Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubTweakTable getTableTweak();

	/**
	 *	Get the UInt16Col Table interface for the schema.
	 *
	 *	@return	The UInt16Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUInt16ColTable getTableUInt16Col();

	/**
	 *	Get the UInt16Def Table interface for the schema.
	 *
	 *	@return	The UInt16Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUInt16DefTable getTableUInt16Def();

	/**
	 *	Get the UInt16Type Table interface for the schema.
	 *
	 *	@return	The UInt16Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUInt16TypeTable getTableUInt16Type();

	/**
	 *	Get the UInt32Col Table interface for the schema.
	 *
	 *	@return	The UInt32Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUInt32ColTable getTableUInt32Col();

	/**
	 *	Get the UInt32Def Table interface for the schema.
	 *
	 *	@return	The UInt32Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUInt32DefTable getTableUInt32Def();

	/**
	 *	Get the UInt32Type Table interface for the schema.
	 *
	 *	@return	The UInt32Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUInt32TypeTable getTableUInt32Type();

	/**
	 *	Get the UInt64Col Table interface for the schema.
	 *
	 *	@return	The UInt64Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUInt64ColTable getTableUInt64Col();

	/**
	 *	Get the UInt64Def Table interface for the schema.
	 *
	 *	@return	The UInt64Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUInt64DefTable getTableUInt64Def();

	/**
	 *	Get the UInt64Type Table interface for the schema.
	 *
	 *	@return	The UInt64Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUInt64TypeTable getTableUInt64Type();

	/**
	 *	Get the Uuid6Col Table interface for the schema.
	 *
	 *	@return	The Uuid6Col Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUuid6ColTable getTableUuid6Col();

	/**
	 *	Get the Uuid6Def Table interface for the schema.
	 *
	 *	@return	The Uuid6Def Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUuid6DefTable getTableUuid6Def();

	/**
	 *	Get the Uuid6Gen Table interface for the schema.
	 *
	 *	@return	The Uuid6Gen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUuid6GenTable getTableUuid6Gen();

	/**
	 *	Get the Uuid6Type Table interface for the schema.
	 *
	 *	@return	The Uuid6Type Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUuid6TypeTable getTableUuid6Type();

	/**
	 *	Get the UuidCol Table interface for the schema.
	 *
	 *	@return	The UuidCol Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUuidColTable getTableUuidCol();

	/**
	 *	Get the UuidDef Table interface for the schema.
	 *
	 *	@return	The UuidDef Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUuidDefTable getTableUuidDef();

	/**
	 *	Get the UuidGen Table interface for the schema.
	 *
	 *	@return	The UuidGen Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUuidGenTable getTableUuidGen();

	/**
	 *	Get the UuidType Table interface for the schema.
	 *
	 *	@return	The UuidType Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubUuidTypeTable getTableUuidType();

	/**
	 *	Get the Value Table interface for the schema.
	 *
	 *	@return	The Value Table interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	public ICFBamPubValueTable getTableValue();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	//public static ICFSecPubTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ICFSecPubTablePerms getCFSecPubTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ICFSecPubTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws MCFNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ICFSecPubTablePerms value );

	public void bootstrapSchema(CFSecPubTableData tableData[]);
	public void bootstrapAllTablesSecurity(MCFDbKeyHash256 clusterId, MCFDbKeyHash256 tenantId, CFSecPubTableData tableData[]);
}
