// Description: Java 25 Table Object implementation for Value.

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
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public class BusModelValueTableObj
	implements IBusModelValueTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelValue.CLASS_CODE;
	protected static final int backingClassCode = IBusModelValue.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> allValue;
	private Map< IBusModelValueByUNameIdxKey,
		IBusModelValueObj > indexByUNameIdx;
	private Map< IBusModelValueByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > > indexByScopeIdx;
	private Map< IBusModelValueByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > > indexByDefSchemaIdx;
	private Map< IBusModelValueByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > > indexByPrevIdx;
	private Map< IBusModelValueByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > > indexByNextIdx;
	private Map< IBusModelValueByContPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > > indexByContPrevIdx;
	private Map< IBusModelValueByContNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > > indexByContNextIdx;
	public static String TABLE_NAME = "Value";
	public static String TABLE_DBNAME = "valdef";

	public BusModelValueTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelValueObj>();
		allValue = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}

	public BusModelValueTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelValueObj>();
		allValue = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelValueTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( backingClassCode );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( runtimeClassCode );
	}

	/**
	 *	Set the runtime class code for this table; this is done only during application initialization by the SchemaObj's <tt>initClassCodes()</tt> static method,
	 *	which will only set the class codes once and never again.  Once set, the class codes are immutable within the application.
	 *	Application programmers should never invoke this method, so it has package access only.
	 *
	 *	@param	argNewClassCode	The runtime class code to be used by clients and integrated application logic to identify this table of this schema.
	 */
	static void setRuntimeClassCode(int argNewClassCode ) {
		if (argNewClassCode <= 0) {
			throw new YCFArgumentUnderflowException(BusModelValueTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
		}
		runtimeClassCode = argNewClassCode;
	}

	@Override
	public IBusModelSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IBusModelSchemaObj value ) {
		schema = (IBusModelSchemaObj)value;
	}

	@Override
	public String getTableName() {
		return( TABLE_NAME );
	}

	@Override
	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	@Override
	public Class getObjQualifyingClass() {
		return( IBusModelSchemaDefObj.class );
	}


	@Override
	public void minimizeMemory() {
		allValue = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		List<IBusModelValueObj> toForget = new LinkedList<IBusModelValueObj>();
		IBusModelValueObj cur = null;
		Iterator<IBusModelValueObj> iter = members.values().iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			toForget.add( cur );
		}
		iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget();
		}
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelValueObj.
	 */
	@Override
	public IBusModelValueObj newInstance() {
		IBusModelValueObj inst = new BusModelValueObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelValueObj.
	 */
	@Override
	public IBusModelValueEditObj newEditInstance( IBusModelValueObj orig ) {
		IBusModelValueEditObj edit = new BusModelValueEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelValueObj constructByClassCode( int backingClassCode ) {
		IBusModelValueObj obj = null;
		if( backingClassCode == IBusModelValue.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getValueTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelAtom.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getAtomTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelBlobDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getBlobDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelBlobType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getBlobTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelBlobCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getBlobColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelBoolDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getBoolDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelBoolType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getBoolTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelBoolCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getBoolColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDateDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDateDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDateType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDateTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDateCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDateColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDoubleDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDoubleDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDoubleType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDoubleTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDoubleCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDoubleColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelFloatDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getFloatDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelFloatType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getFloatTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelFloatCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getFloatColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelInt16Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getInt16DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelInt16Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getInt16TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelId16Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getId16GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelEnumDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getEnumDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelEnumType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getEnumTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelInt16Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getInt16ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelInt32Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getInt32DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelInt32Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getInt32TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelId32Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getId32GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelInt32Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getInt32ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelInt64Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getInt64DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelInt64Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getInt64TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelId64Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getId64GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelInt64Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getInt64ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelNmTokenDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getNmTokenDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelNmTokenType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getNmTokenTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelNmTokenCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getNmTokenColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelNmTokensDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getNmTokensDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelNmTokensType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getNmTokensTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelNmTokensCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getNmTokensColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelNumberDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getNumberDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelNumberType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getNumberTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelNumberCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getNumberColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash128DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash128ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash128TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash128GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash160DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash160ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash160TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash160GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash224DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash224ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash224TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash224GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash256DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash256ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash256TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash256GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash384DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash384ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash384TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash384GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash512DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash512ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash512TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDbKeyHash512GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelStringDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getStringDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelStringType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getStringTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelStringCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getStringColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTZDateDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTZDateDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTZDateType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTZDateTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTZDateCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTZDateColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTZTimeDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTZTimeDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTZTimeType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTZTimeTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTZTimeCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTZTimeColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTZTimestampDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTZTimestampDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTZTimestampType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTZTimestampTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTZTimestampCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTZTimestampColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTextDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTextDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTextType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTextTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTextCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTextColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTimeDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTimeDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTimeType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTimeTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTimeCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTimeColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTimestampDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTimestampDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTimestampType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTimestampTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTimestampCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTimestampColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTokenDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTokenDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTokenType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTokenTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTokenCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTokenColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUInt16Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUInt16DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUInt16Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUInt16TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUInt16Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUInt16ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUInt32Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUInt32DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUInt32Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUInt32TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUInt32Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUInt32ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUInt64Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUInt64DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUInt64Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUInt64TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUInt64Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUInt64ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUuidDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUuidDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUuidType.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUuidTypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUuidGen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUuidGenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUuidCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUuidColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUuid6Def.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUuid6DefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUuid6Type.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUuid6TypeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUuid6Gen.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUuid6GenTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelUuid6Col.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getUuid6ColTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTableCol.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTableColTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IBusModelValueObj realiseValue( IBusModelValueObj Obj ) {
		IBusModelValueObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelValueObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelValueObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IBusModelValueByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByScopeIdx != null ) {
				IBusModelValueByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.remove( keepObj.getPKey() );
					if( mapScopeIdx.size() <= 0 ) {
						indexByScopeIdx.remove( keyScopeIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.remove( keepObj.getPKey() );
					if( mapContPrevIdx.size() <= 0 ) {
						indexByContPrevIdx.remove( keyContPrevIdx );
					}
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.remove( keepObj.getPKey() );
					if( mapContNextIdx.size() <= 0 ) {
						indexByContNextIdx.remove( keyContNextIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IBusModelValueByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelValueByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allValue != null ) {
				allValue.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allValue != null ) {
				allValue.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IBusModelValueByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelValueByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelValueObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelValueObj createValue( IBusModelValueObj Obj ) {
		IBusModelValueObj obj = Obj;
		IBusModelValue rec = obj.getValueRec();
		schema.getBusModelBackingStore().getTableValue().createValue(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelValueObj)(obj.realise());
		}
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelValueObj readValue( $implCommaIJavaOptAtomType$ pkey ) {
		return( readValue( pkey, false ) );
	}

	@Override
	public IBusModelValueObj readValue( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelValueObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelValue readRec = schema.getBusModelBackingStore().getTableValue().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelValueObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelValueObj readCachedValue( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelValueObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeValue( IBusModelValueObj obj )
	{
		final String S_ProcName = "BusModelValueTableObj.reallyDeepDisposeValue() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelValueObj existing = readCachedValue( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelValueByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		keyUNameIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelValueByScopeIdxKey keyScopeIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		keyScopeIdx.setRequiredScopeId( existing.getRequiredScopeId() );

		IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelValueByPrevIdxKey keyPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelValueByNextIdxKey keyNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		IBusModelValueByContPrevIdxKey keyContPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		keyContPrevIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyContPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelValueByContNextIdxKey keyContNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		keyContNextIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyContNextIdx.setOptionalNextId( existing.getOptionalNextId() );


		schema.getTableColTableObj().deepDisposeTableColByDataIdx( existing.getRequiredId() );
		schema.getIndexColTableObj().deepDisposeIndexColByColIdx( existing.getRequiredId() );

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByScopeIdx != null ) {
			if( indexByScopeIdx.containsKey( keyScopeIdx ) ) {
				indexByScopeIdx.get( keyScopeIdx ).remove( pkey );
				if( indexByScopeIdx.get( keyScopeIdx ).size() <= 0 ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}
		}

		if( indexByDefSchemaIdx != null ) {
			if( indexByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
				indexByDefSchemaIdx.get( keyDefSchemaIdx ).remove( pkey );
				if( indexByDefSchemaIdx.get( keyDefSchemaIdx ).size() <= 0 ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}
		}

		if( indexByPrevIdx != null ) {
			if( indexByPrevIdx.containsKey( keyPrevIdx ) ) {
				indexByPrevIdx.get( keyPrevIdx ).remove( pkey );
				if( indexByPrevIdx.get( keyPrevIdx ).size() <= 0 ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}
		}

		if( indexByNextIdx != null ) {
			if( indexByNextIdx.containsKey( keyNextIdx ) ) {
				indexByNextIdx.get( keyNextIdx ).remove( pkey );
				if( indexByNextIdx.get( keyNextIdx ).size() <= 0 ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}
		}

		if( indexByContPrevIdx != null ) {
			if( indexByContPrevIdx.containsKey( keyContPrevIdx ) ) {
				indexByContPrevIdx.get( keyContPrevIdx ).remove( pkey );
				if( indexByContPrevIdx.get( keyContPrevIdx ).size() <= 0 ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}
		}

		if( indexByContNextIdx != null ) {
			if( indexByContNextIdx.containsKey( keyContNextIdx ) ) {
				indexByContNextIdx.get( keyContNextIdx ).remove( pkey );
				if( indexByContNextIdx.get( keyContNextIdx ).size() <= 0 ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeValue( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelValueObj obj = readCachedValue( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelValueObj lockValue( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelValueObj locked = null;
		IBusModelValue lockRec = schema.getBusModelBackingStore().getTableValue().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelValueObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockValue", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelValueObj> readAllValue() {
		return( readAllValue( false ) );
	}

	@Override
	public List<IBusModelValueObj> readAllValue( boolean forceRead ) {
		final String S_ProcName = "readAllValue";
		if( ( allValue == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelValueObj>();
			allValue = map;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readAllDerived( null );
			IBusModelValue rec;
			IBusModelValueObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelValueObj realised = (IBusModelValueObj)obj.realise();
			}
		}
		int len = allValue.size();
		IBusModelValueObj arr[] = new IBusModelValueObj[len];
		Iterator<IBusModelValueObj> valIter = allValue.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new YCFArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<IBusModelValueObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelValueObj> readCachedAllValue() {
		final String S_ProcName = "readCachedAllValue";
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>();
		if( allValue != null ) {
			int len = allValue.size();
			IBusModelValueObj arr[] = new IBusModelValueObj[len];
			Iterator<IBusModelValueObj> valIter = allValue.values().iterator();
			int idx = 0;
			while( ( idx < len ) && valIter.hasNext() ) {
				arr[idx++] = valIter.next();
			}
			if( idx < len ) {
				throw new YCFArgumentUnderflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
			}
			else if( valIter.hasNext() ) {
				throw new YCFArgumentOverflowException( getClass(),
						S_ProcName,
						0,
						"idx",
						idx,
						len );
			}
			for( idx = 0; idx < len; idx ++ ) {
				arrayList.add( arr[idx] );
			}
		}
		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public IBusModelValueObj readValueByIdIdx( IYCFKeyHash256 Id )
	{
		return( readValueByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelValueObj readValueByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelValueObj obj = readValue( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelValueObj readValueByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readValueByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelValueObj readValueByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelValueObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelValueObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelValue rec = schema.getBusModelBackingStore().getTableValue().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelValueObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelValueObj> readValueByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readValueByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelValueObj> readValueByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readValueByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelValueObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelValueObj realised = (IBusModelValueObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelValueObj arr[] = new IBusModelValueObj[len];
		Iterator<IBusModelValueObj> valIter = dict.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new YCFArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<IBusModelValueObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelValueObj> readValueByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readValueByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelValueObj> readValueByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readValueByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelValueObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelValueObj realised = (IBusModelValueObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelValueObj arr[] = new IBusModelValueObj[len];
		Iterator<IBusModelValueObj> valIter = dict.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new YCFArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<IBusModelValueObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelValueObj> readValueByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readValueByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelValueObj> readValueByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readValueByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelValueObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelValueObj realised = (IBusModelValueObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelValueObj arr[] = new IBusModelValueObj[len];
		Iterator<IBusModelValueObj> valIter = dict.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new YCFArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<IBusModelValueObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelValueObj> readValueByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readValueByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelValueObj> readValueByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readValueByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelValueObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByNextIdx( null,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelValueObj realised = (IBusModelValueObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelValueObj arr[] = new IBusModelValueObj[len];
		Iterator<IBusModelValueObj> valIter = dict.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new YCFArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<IBusModelValueObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelValueObj> readValueByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		return( readValueByContPrevIdx( ScopeId,
			PrevId,
			false ) );
	}

	@Override
	public List<IBusModelValueObj> readValueByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readValueByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelValueObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContPrevIdx( null,
				ScopeId,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelValueObj realised = (IBusModelValueObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelValueObj arr[] = new IBusModelValueObj[len];
		Iterator<IBusModelValueObj> valIter = dict.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new YCFArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<IBusModelValueObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelValueObj> readValueByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		return( readValueByContNextIdx( ScopeId,
			NextId,
			false ) );
	}

	@Override
	public List<IBusModelValueObj> readValueByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readValueByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelValueObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContNextIdx( null,
				ScopeId,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelValueObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelValueObj realised = (IBusModelValueObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelValueObj arr[] = new IBusModelValueObj[len];
		Iterator<IBusModelValueObj> valIter = dict.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new YCFArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<IBusModelValueObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelValueObj readCachedValueByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelValueObj obj = null;
		obj = readCachedValue( Id );
		return( obj );
	}

	@Override
	public IBusModelValueObj readCachedValueByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelValueObj obj = null;
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelValueObj> valIter = members.values().iterator();
				while( ( obj == null ) && valIter.hasNext() ) {
					obj = valIter.next();
					if( obj != null ) {
						if( obj.getRec().compareTo( key ) != 0 ) {
							obj = null;
						}
					}
				}
			}
		}
		else {
			Iterator<IBusModelValueObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) != 0 ) {
						obj = null;
					}
				}
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelValueObj> readCachedValueByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedValueByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelValueObj arr[] = new IBusModelValueObj[len];
				Iterator<IBusModelValueObj> valIter = dict.values().iterator();
				int idx = 0;
				while( ( idx < len ) && valIter.hasNext() ) {
					arr[idx++] = valIter.next();
				}
				if( idx < len ) {
					throw new YCFArgumentUnderflowException( getClass(),
						S_ProcName,
						0,
						"idx",
						idx,
						len );
				}
				else if( valIter.hasNext() ) {
					throw new YCFArgumentOverflowException( getClass(),
							S_ProcName,
							0,
							"idx",
							idx,
							len );
				}
				for( idx = 0; idx < len; idx ++ ) {
					arrayList.add( arr[idx] );
				}
			}
		}
		else {
			IBusModelValueObj obj;
			Iterator<IBusModelValueObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<IBusModelValueObj> readCachedValueByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedValueByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelValueObj arr[] = new IBusModelValueObj[len];
				Iterator<IBusModelValueObj> valIter = dict.values().iterator();
				int idx = 0;
				while( ( idx < len ) && valIter.hasNext() ) {
					arr[idx++] = valIter.next();
				}
				if( idx < len ) {
					throw new YCFArgumentUnderflowException( getClass(),
						S_ProcName,
						0,
						"idx",
						idx,
						len );
				}
				else if( valIter.hasNext() ) {
					throw new YCFArgumentOverflowException( getClass(),
							S_ProcName,
							0,
							"idx",
							idx,
							len );
				}
				for( idx = 0; idx < len; idx ++ ) {
					arrayList.add( arr[idx] );
				}
			}
		}
		else {
			IBusModelValueObj obj;
			Iterator<IBusModelValueObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<IBusModelValueObj> readCachedValueByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedValueByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelValueObj arr[] = new IBusModelValueObj[len];
				Iterator<IBusModelValueObj> valIter = dict.values().iterator();
				int idx = 0;
				while( ( idx < len ) && valIter.hasNext() ) {
					arr[idx++] = valIter.next();
				}
				if( idx < len ) {
					throw new YCFArgumentUnderflowException( getClass(),
						S_ProcName,
						0,
						"idx",
						idx,
						len );
				}
				else if( valIter.hasNext() ) {
					throw new YCFArgumentOverflowException( getClass(),
							S_ProcName,
							0,
							"idx",
							idx,
							len );
				}
				for( idx = 0; idx < len; idx ++ ) {
					arrayList.add( arr[idx] );
				}
			}
		}
		else {
			IBusModelValueObj obj;
			Iterator<IBusModelValueObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<IBusModelValueObj> readCachedValueByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedValueByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelValueObj arr[] = new IBusModelValueObj[len];
				Iterator<IBusModelValueObj> valIter = dict.values().iterator();
				int idx = 0;
				while( ( idx < len ) && valIter.hasNext() ) {
					arr[idx++] = valIter.next();
				}
				if( idx < len ) {
					throw new YCFArgumentUnderflowException( getClass(),
						S_ProcName,
						0,
						"idx",
						idx,
						len );
				}
				else if( valIter.hasNext() ) {
					throw new YCFArgumentOverflowException( getClass(),
							S_ProcName,
							0,
							"idx",
							idx,
							len );
				}
				for( idx = 0; idx < len; idx ++ ) {
					arrayList.add( arr[idx] );
				}
			}
		}
		else {
			IBusModelValueObj obj;
			Iterator<IBusModelValueObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<IBusModelValueObj> readCachedValueByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedValueByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>();
		if( indexByContPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
			if( indexByContPrevIdx.containsKey( key ) ) {
				dict = indexByContPrevIdx.get( key );
				int len = dict.size();
				IBusModelValueObj arr[] = new IBusModelValueObj[len];
				Iterator<IBusModelValueObj> valIter = dict.values().iterator();
				int idx = 0;
				while( ( idx < len ) && valIter.hasNext() ) {
					arr[idx++] = valIter.next();
				}
				if( idx < len ) {
					throw new YCFArgumentUnderflowException( getClass(),
						S_ProcName,
						0,
						"idx",
						idx,
						len );
				}
				else if( valIter.hasNext() ) {
					throw new YCFArgumentOverflowException( getClass(),
							S_ProcName,
							0,
							"idx",
							idx,
							len );
				}
				for( idx = 0; idx < len; idx ++ ) {
					arrayList.add( arr[idx] );
				}
			}
		}
		else {
			IBusModelValueObj obj;
			Iterator<IBusModelValueObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<IBusModelValueObj> readCachedValueByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedValueByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelValueObj> arrayList = new ArrayList<IBusModelValueObj>();
		if( indexByContNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict;
			if( indexByContNextIdx.containsKey( key ) ) {
				dict = indexByContNextIdx.get( key );
				int len = dict.size();
				IBusModelValueObj arr[] = new IBusModelValueObj[len];
				Iterator<IBusModelValueObj> valIter = dict.values().iterator();
				int idx = 0;
				while( ( idx < len ) && valIter.hasNext() ) {
					arr[idx++] = valIter.next();
				}
				if( idx < len ) {
					throw new YCFArgumentUnderflowException( getClass(),
						S_ProcName,
						0,
						"idx",
						idx,
						len );
				}
				else if( valIter.hasNext() ) {
					throw new YCFArgumentOverflowException( getClass(),
							S_ProcName,
							0,
							"idx",
							idx,
							len );
				}
				for( idx = 0; idx < len; idx ++ ) {
					arrayList.add( arr[idx] );
				}
			}
		}
		else {
			IBusModelValueObj obj;
			Iterator<IBusModelValueObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelValueObj> cmp = new Comparator<IBusModelValueObj>() {
			@Override
			public int compare( IBusModelValueObj lhs, IBusModelValueObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeValueByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelValueObj obj = readCachedValueByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeValueByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelValueObj obj = readCachedValueByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeValueByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeValueByScopeIdx";
		IBusModelValueObj obj;
		List<IBusModelValueObj> arrayList = readCachedValueByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelValueObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeValueByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeValueByDefSchemaIdx";
		IBusModelValueObj obj;
		List<IBusModelValueObj> arrayList = readCachedValueByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelValueObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeValueByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeValueByPrevIdx";
		IBusModelValueObj obj;
		List<IBusModelValueObj> arrayList = readCachedValueByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelValueObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeValueByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeValueByNextIdx";
		IBusModelValueObj obj;
		List<IBusModelValueObj> arrayList = readCachedValueByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelValueObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeValueByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeValueByContPrevIdx";
		IBusModelValueObj obj;
		List<IBusModelValueObj> arrayList = readCachedValueByContPrevIdx( ScopeId,
				PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelValueObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeValueByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeValueByContNextIdx";
		IBusModelValueObj obj;
		List<IBusModelValueObj> arrayList = readCachedValueByContNextIdx( ScopeId,
				NextId );
		if( arrayList != null )  {
			Iterator<IBusModelValueObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelValueObj updateValue( IBusModelValueObj Obj ) {
		IBusModelValueObj obj = Obj;
		schema.getBusModelBackingStore().getTableValue().updateValue( null,
			Obj.getValueRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getValueTableObj().getClassCode() ) {
			obj = (IBusModelValueObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteValue( IBusModelValueObj Obj ) {
		IBusModelValueObj obj = Obj;
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		IBusModelValueObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableValue().deleteValue( null,
			obj.getValueRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteValueByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelValueObj obj = readValue(Id);
		if( obj != null ) {
			IBusModelValueEditObj editObj = (IBusModelValueEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelValueEditObj)obj.beginEdit();
				if( editObj != null ) {
					editStarted = true;
				}
				else {
					editStarted = false;
				}
			}
			else {
				editStarted = false;
			}
			if( editObj != null ) {
				editObj.deleteInstance();
				if( editStarted ) {
					editObj.endEdit();
				}
			}
			obj.forget();
		}
		deepDisposeValueByIdIdx( Id );
	}

	@Override
	public void deleteValueByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelValueObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelValueObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableValue().deleteValueByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableValue().deleteValueByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeValueByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteValueByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableValue().deleteValueByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelValueObj> iter = dict.values().iterator();
			IBusModelValueObj obj;
			List<IBusModelValueObj> toForget = new LinkedList<IBusModelValueObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByScopeIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableValue().deleteValueByScopeIdx( null,
				ScopeId );
		}
		deepDisposeValueByScopeIdx( ScopeId );
	}

	@Override
	public void deleteValueByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableValue().deleteValueByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelValueObj> iter = dict.values().iterator();
			IBusModelValueObj obj;
			List<IBusModelValueObj> toForget = new LinkedList<IBusModelValueObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByDefSchemaIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableValue().deleteValueByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeValueByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteValueByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableValue().deleteValueByPrevIdx( null,
				PrevId );
			Iterator<IBusModelValueObj> iter = dict.values().iterator();
			IBusModelValueObj obj;
			List<IBusModelValueObj> toForget = new LinkedList<IBusModelValueObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByPrevIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableValue().deleteValueByPrevIdx( null,
				PrevId );
		}
		deepDisposeValueByPrevIdx( PrevId );
	}

	@Override
	public void deleteValueByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableValue().deleteValueByNextIdx( null,
				NextId );
			Iterator<IBusModelValueObj> iter = dict.values().iterator();
			IBusModelValueObj obj;
			List<IBusModelValueObj> toForget = new LinkedList<IBusModelValueObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByNextIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableValue().deleteValueByNextIdx( null,
				NextId );
		}
		deepDisposeValueByNextIdx( NextId );
	}

	@Override
	public void deleteValueByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict = indexByContPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableValue().deleteValueByContPrevIdx( null,
				ScopeId,
				PrevId );
			Iterator<IBusModelValueObj> iter = dict.values().iterator();
			IBusModelValueObj obj;
			List<IBusModelValueObj> toForget = new LinkedList<IBusModelValueObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByContPrevIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableValue().deleteValueByContPrevIdx( null,
				ScopeId,
				PrevId );
		}
		deepDisposeValueByContPrevIdx( ScopeId,
				PrevId );
	}

	@Override
	public void deleteValueByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelValueObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelValueObj> dict = indexByContNextIdx.get( key );
			schema.getBusModelBackingStore().getTableValue().deleteValueByContNextIdx( null,
				ScopeId,
				NextId );
			Iterator<IBusModelValueObj> iter = dict.values().iterator();
			IBusModelValueObj obj;
			List<IBusModelValueObj> toForget = new LinkedList<IBusModelValueObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByContNextIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableValue().deleteValueByContNextIdx( null,
				ScopeId,
				NextId );
		}
		deepDisposeValueByContNextIdx( ScopeId,
				NextId );
	}

	/**
	 *	Move the BusModelValueObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelValueObj refreshed cache instance.
	 */
	@Override
	public IBusModelValueObj moveUpValue( IBusModelValueObj Obj ) {
		IBusModelValueObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpValue" );
		}
		IBusModelValue rec = schema.getBusModelBackingStore().getTableValue().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getValueTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelValueObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelValueObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelValueObj refreshed cache instance.
	 */
	@Override
	public IBusModelValueObj moveDownValue( IBusModelValueObj Obj ) {
		IBusModelValueObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownValue" );
		}
		IBusModelValue rec = schema.getBusModelBackingStore().getTableValue().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getValueTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelValueObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}