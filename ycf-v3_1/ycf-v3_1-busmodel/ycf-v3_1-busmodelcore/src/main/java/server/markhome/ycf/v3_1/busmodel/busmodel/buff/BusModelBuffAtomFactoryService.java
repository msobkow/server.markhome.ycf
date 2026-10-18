
// Description: Java 25 Factory service implementation for Atom buffers

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

package server.markhome.ycf.v3_1.busmodel.busmodel.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

/*
 *	Java 25 Factory service implementation for Atom buffers.
 */
@Service("busmodel31BuffAtomFactoryService")
public class BusModelBuffAtomFactoryService
	implements IBusModelAtomFactory
{
	public BusModelBuffAtomFactoryService() {
	}

	@Override
	public IBusModelAtom newRec() {
		IBusModelAtom rec =
			new BusModelBuffAtom();
		return( rec );
	}

	public BusModelBuffAtom ensureRec(IBusModelAtom rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffAtom) {
			return ((BusModelBuffAtom)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelAtom.CLASS_CODE: {
					BusModelBuffAtom mapped = new BusModelBuffAtom();
					mapped.set(rec);
					return(mapped); }
				case IBusModelBlobDef.CLASS_CODE: {
					BusModelBuffBlobDef mapped = new BusModelBuffBlobDef();
					mapped.set((IBusModelBlobDef)rec);
					return(mapped); }
				case IBusModelBlobType.CLASS_CODE: {
					BusModelBuffBlobType mapped = new BusModelBuffBlobType();
					mapped.set((IBusModelBlobType)rec);
					return(mapped); }
				case IBusModelBlobCol.CLASS_CODE: {
					BusModelBuffBlobCol mapped = new BusModelBuffBlobCol();
					mapped.set((IBusModelBlobCol)rec);
					return(mapped); }
				case IBusModelBoolDef.CLASS_CODE: {
					BusModelBuffBoolDef mapped = new BusModelBuffBoolDef();
					mapped.set((IBusModelBoolDef)rec);
					return(mapped); }
				case IBusModelBoolType.CLASS_CODE: {
					BusModelBuffBoolType mapped = new BusModelBuffBoolType();
					mapped.set((IBusModelBoolType)rec);
					return(mapped); }
				case IBusModelBoolCol.CLASS_CODE: {
					BusModelBuffBoolCol mapped = new BusModelBuffBoolCol();
					mapped.set((IBusModelBoolCol)rec);
					return(mapped); }
				case IBusModelDateDef.CLASS_CODE: {
					BusModelBuffDateDef mapped = new BusModelBuffDateDef();
					mapped.set((IBusModelDateDef)rec);
					return(mapped); }
				case IBusModelDateType.CLASS_CODE: {
					BusModelBuffDateType mapped = new BusModelBuffDateType();
					mapped.set((IBusModelDateType)rec);
					return(mapped); }
				case IBusModelDateCol.CLASS_CODE: {
					BusModelBuffDateCol mapped = new BusModelBuffDateCol();
					mapped.set((IBusModelDateCol)rec);
					return(mapped); }
				case IBusModelDoubleDef.CLASS_CODE: {
					BusModelBuffDoubleDef mapped = new BusModelBuffDoubleDef();
					mapped.set((IBusModelDoubleDef)rec);
					return(mapped); }
				case IBusModelDoubleType.CLASS_CODE: {
					BusModelBuffDoubleType mapped = new BusModelBuffDoubleType();
					mapped.set((IBusModelDoubleType)rec);
					return(mapped); }
				case IBusModelDoubleCol.CLASS_CODE: {
					BusModelBuffDoubleCol mapped = new BusModelBuffDoubleCol();
					mapped.set((IBusModelDoubleCol)rec);
					return(mapped); }
				case IBusModelFloatDef.CLASS_CODE: {
					BusModelBuffFloatDef mapped = new BusModelBuffFloatDef();
					mapped.set((IBusModelFloatDef)rec);
					return(mapped); }
				case IBusModelFloatType.CLASS_CODE: {
					BusModelBuffFloatType mapped = new BusModelBuffFloatType();
					mapped.set((IBusModelFloatType)rec);
					return(mapped); }
				case IBusModelFloatCol.CLASS_CODE: {
					BusModelBuffFloatCol mapped = new BusModelBuffFloatCol();
					mapped.set((IBusModelFloatCol)rec);
					return(mapped); }
				case IBusModelInt16Def.CLASS_CODE: {
					BusModelBuffInt16Def mapped = new BusModelBuffInt16Def();
					mapped.set((IBusModelInt16Def)rec);
					return(mapped); }
				case IBusModelInt16Type.CLASS_CODE: {
					BusModelBuffInt16Type mapped = new BusModelBuffInt16Type();
					mapped.set((IBusModelInt16Type)rec);
					return(mapped); }
				case IBusModelId16Gen.CLASS_CODE: {
					BusModelBuffId16Gen mapped = new BusModelBuffId16Gen();
					mapped.set((IBusModelId16Gen)rec);
					return(mapped); }
				case IBusModelEnumDef.CLASS_CODE: {
					BusModelBuffEnumDef mapped = new BusModelBuffEnumDef();
					mapped.set((IBusModelEnumDef)rec);
					return(mapped); }
				case IBusModelEnumType.CLASS_CODE: {
					BusModelBuffEnumType mapped = new BusModelBuffEnumType();
					mapped.set((IBusModelEnumType)rec);
					return(mapped); }
				case IBusModelInt16Col.CLASS_CODE: {
					BusModelBuffInt16Col mapped = new BusModelBuffInt16Col();
					mapped.set((IBusModelInt16Col)rec);
					return(mapped); }
				case IBusModelInt32Def.CLASS_CODE: {
					BusModelBuffInt32Def mapped = new BusModelBuffInt32Def();
					mapped.set((IBusModelInt32Def)rec);
					return(mapped); }
				case IBusModelInt32Type.CLASS_CODE: {
					BusModelBuffInt32Type mapped = new BusModelBuffInt32Type();
					mapped.set((IBusModelInt32Type)rec);
					return(mapped); }
				case IBusModelId32Gen.CLASS_CODE: {
					BusModelBuffId32Gen mapped = new BusModelBuffId32Gen();
					mapped.set((IBusModelId32Gen)rec);
					return(mapped); }
				case IBusModelInt32Col.CLASS_CODE: {
					BusModelBuffInt32Col mapped = new BusModelBuffInt32Col();
					mapped.set((IBusModelInt32Col)rec);
					return(mapped); }
				case IBusModelInt64Def.CLASS_CODE: {
					BusModelBuffInt64Def mapped = new BusModelBuffInt64Def();
					mapped.set((IBusModelInt64Def)rec);
					return(mapped); }
				case IBusModelInt64Type.CLASS_CODE: {
					BusModelBuffInt64Type mapped = new BusModelBuffInt64Type();
					mapped.set((IBusModelInt64Type)rec);
					return(mapped); }
				case IBusModelId64Gen.CLASS_CODE: {
					BusModelBuffId64Gen mapped = new BusModelBuffId64Gen();
					mapped.set((IBusModelId64Gen)rec);
					return(mapped); }
				case IBusModelInt64Col.CLASS_CODE: {
					BusModelBuffInt64Col mapped = new BusModelBuffInt64Col();
					mapped.set((IBusModelInt64Col)rec);
					return(mapped); }
				case IBusModelNmTokenDef.CLASS_CODE: {
					BusModelBuffNmTokenDef mapped = new BusModelBuffNmTokenDef();
					mapped.set((IBusModelNmTokenDef)rec);
					return(mapped); }
				case IBusModelNmTokenType.CLASS_CODE: {
					BusModelBuffNmTokenType mapped = new BusModelBuffNmTokenType();
					mapped.set((IBusModelNmTokenType)rec);
					return(mapped); }
				case IBusModelNmTokenCol.CLASS_CODE: {
					BusModelBuffNmTokenCol mapped = new BusModelBuffNmTokenCol();
					mapped.set((IBusModelNmTokenCol)rec);
					return(mapped); }
				case IBusModelNmTokensDef.CLASS_CODE: {
					BusModelBuffNmTokensDef mapped = new BusModelBuffNmTokensDef();
					mapped.set((IBusModelNmTokensDef)rec);
					return(mapped); }
				case IBusModelNmTokensType.CLASS_CODE: {
					BusModelBuffNmTokensType mapped = new BusModelBuffNmTokensType();
					mapped.set((IBusModelNmTokensType)rec);
					return(mapped); }
				case IBusModelNmTokensCol.CLASS_CODE: {
					BusModelBuffNmTokensCol mapped = new BusModelBuffNmTokensCol();
					mapped.set((IBusModelNmTokensCol)rec);
					return(mapped); }
				case IBusModelNumberDef.CLASS_CODE: {
					BusModelBuffNumberDef mapped = new BusModelBuffNumberDef();
					mapped.set((IBusModelNumberDef)rec);
					return(mapped); }
				case IBusModelNumberType.CLASS_CODE: {
					BusModelBuffNumberType mapped = new BusModelBuffNumberType();
					mapped.set((IBusModelNumberType)rec);
					return(mapped); }
				case IBusModelNumberCol.CLASS_CODE: {
					BusModelBuffNumberCol mapped = new BusModelBuffNumberCol();
					mapped.set((IBusModelNumberCol)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Def.CLASS_CODE: {
					BusModelBuffDbKeyHash128Def mapped = new BusModelBuffDbKeyHash128Def();
					mapped.set((IBusModelDbKeyHash128Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Col.CLASS_CODE: {
					BusModelBuffDbKeyHash128Col mapped = new BusModelBuffDbKeyHash128Col();
					mapped.set((IBusModelDbKeyHash128Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Type.CLASS_CODE: {
					BusModelBuffDbKeyHash128Type mapped = new BusModelBuffDbKeyHash128Type();
					mapped.set((IBusModelDbKeyHash128Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash128Gen mapped = new BusModelBuffDbKeyHash128Gen();
					mapped.set((IBusModelDbKeyHash128Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Def.CLASS_CODE: {
					BusModelBuffDbKeyHash160Def mapped = new BusModelBuffDbKeyHash160Def();
					mapped.set((IBusModelDbKeyHash160Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Col.CLASS_CODE: {
					BusModelBuffDbKeyHash160Col mapped = new BusModelBuffDbKeyHash160Col();
					mapped.set((IBusModelDbKeyHash160Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Type.CLASS_CODE: {
					BusModelBuffDbKeyHash160Type mapped = new BusModelBuffDbKeyHash160Type();
					mapped.set((IBusModelDbKeyHash160Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash160Gen mapped = new BusModelBuffDbKeyHash160Gen();
					mapped.set((IBusModelDbKeyHash160Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash224Def.CLASS_CODE: {
					BusModelBuffDbKeyHash224Def mapped = new BusModelBuffDbKeyHash224Def();
					mapped.set((IBusModelDbKeyHash224Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash224Col.CLASS_CODE: {
					BusModelBuffDbKeyHash224Col mapped = new BusModelBuffDbKeyHash224Col();
					mapped.set((IBusModelDbKeyHash224Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash224Type.CLASS_CODE: {
					BusModelBuffDbKeyHash224Type mapped = new BusModelBuffDbKeyHash224Type();
					mapped.set((IBusModelDbKeyHash224Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash224Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash224Gen mapped = new BusModelBuffDbKeyHash224Gen();
					mapped.set((IBusModelDbKeyHash224Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash256Def.CLASS_CODE: {
					BusModelBuffDbKeyHash256Def mapped = new BusModelBuffDbKeyHash256Def();
					mapped.set((IBusModelDbKeyHash256Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash256Col.CLASS_CODE: {
					BusModelBuffDbKeyHash256Col mapped = new BusModelBuffDbKeyHash256Col();
					mapped.set((IBusModelDbKeyHash256Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash256Type.CLASS_CODE: {
					BusModelBuffDbKeyHash256Type mapped = new BusModelBuffDbKeyHash256Type();
					mapped.set((IBusModelDbKeyHash256Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash256Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash256Gen mapped = new BusModelBuffDbKeyHash256Gen();
					mapped.set((IBusModelDbKeyHash256Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash384Def.CLASS_CODE: {
					BusModelBuffDbKeyHash384Def mapped = new BusModelBuffDbKeyHash384Def();
					mapped.set((IBusModelDbKeyHash384Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash384Col.CLASS_CODE: {
					BusModelBuffDbKeyHash384Col mapped = new BusModelBuffDbKeyHash384Col();
					mapped.set((IBusModelDbKeyHash384Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash384Type.CLASS_CODE: {
					BusModelBuffDbKeyHash384Type mapped = new BusModelBuffDbKeyHash384Type();
					mapped.set((IBusModelDbKeyHash384Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash384Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash384Gen mapped = new BusModelBuffDbKeyHash384Gen();
					mapped.set((IBusModelDbKeyHash384Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash512Def.CLASS_CODE: {
					BusModelBuffDbKeyHash512Def mapped = new BusModelBuffDbKeyHash512Def();
					mapped.set((IBusModelDbKeyHash512Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash512Col.CLASS_CODE: {
					BusModelBuffDbKeyHash512Col mapped = new BusModelBuffDbKeyHash512Col();
					mapped.set((IBusModelDbKeyHash512Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash512Type.CLASS_CODE: {
					BusModelBuffDbKeyHash512Type mapped = new BusModelBuffDbKeyHash512Type();
					mapped.set((IBusModelDbKeyHash512Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash512Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash512Gen mapped = new BusModelBuffDbKeyHash512Gen();
					mapped.set((IBusModelDbKeyHash512Gen)rec);
					return(mapped); }
				case IBusModelStringDef.CLASS_CODE: {
					BusModelBuffStringDef mapped = new BusModelBuffStringDef();
					mapped.set((IBusModelStringDef)rec);
					return(mapped); }
				case IBusModelStringType.CLASS_CODE: {
					BusModelBuffStringType mapped = new BusModelBuffStringType();
					mapped.set((IBusModelStringType)rec);
					return(mapped); }
				case IBusModelStringCol.CLASS_CODE: {
					BusModelBuffStringCol mapped = new BusModelBuffStringCol();
					mapped.set((IBusModelStringCol)rec);
					return(mapped); }
				case IBusModelTZDateDef.CLASS_CODE: {
					BusModelBuffTZDateDef mapped = new BusModelBuffTZDateDef();
					mapped.set((IBusModelTZDateDef)rec);
					return(mapped); }
				case IBusModelTZDateType.CLASS_CODE: {
					BusModelBuffTZDateType mapped = new BusModelBuffTZDateType();
					mapped.set((IBusModelTZDateType)rec);
					return(mapped); }
				case IBusModelTZDateCol.CLASS_CODE: {
					BusModelBuffTZDateCol mapped = new BusModelBuffTZDateCol();
					mapped.set((IBusModelTZDateCol)rec);
					return(mapped); }
				case IBusModelTZTimeDef.CLASS_CODE: {
					BusModelBuffTZTimeDef mapped = new BusModelBuffTZTimeDef();
					mapped.set((IBusModelTZTimeDef)rec);
					return(mapped); }
				case IBusModelTZTimeType.CLASS_CODE: {
					BusModelBuffTZTimeType mapped = new BusModelBuffTZTimeType();
					mapped.set((IBusModelTZTimeType)rec);
					return(mapped); }
				case IBusModelTZTimeCol.CLASS_CODE: {
					BusModelBuffTZTimeCol mapped = new BusModelBuffTZTimeCol();
					mapped.set((IBusModelTZTimeCol)rec);
					return(mapped); }
				case IBusModelTZTimestampDef.CLASS_CODE: {
					BusModelBuffTZTimestampDef mapped = new BusModelBuffTZTimestampDef();
					mapped.set((IBusModelTZTimestampDef)rec);
					return(mapped); }
				case IBusModelTZTimestampType.CLASS_CODE: {
					BusModelBuffTZTimestampType mapped = new BusModelBuffTZTimestampType();
					mapped.set((IBusModelTZTimestampType)rec);
					return(mapped); }
				case IBusModelTZTimestampCol.CLASS_CODE: {
					BusModelBuffTZTimestampCol mapped = new BusModelBuffTZTimestampCol();
					mapped.set((IBusModelTZTimestampCol)rec);
					return(mapped); }
				case IBusModelTextDef.CLASS_CODE: {
					BusModelBuffTextDef mapped = new BusModelBuffTextDef();
					mapped.set((IBusModelTextDef)rec);
					return(mapped); }
				case IBusModelTextType.CLASS_CODE: {
					BusModelBuffTextType mapped = new BusModelBuffTextType();
					mapped.set((IBusModelTextType)rec);
					return(mapped); }
				case IBusModelTextCol.CLASS_CODE: {
					BusModelBuffTextCol mapped = new BusModelBuffTextCol();
					mapped.set((IBusModelTextCol)rec);
					return(mapped); }
				case IBusModelTimeDef.CLASS_CODE: {
					BusModelBuffTimeDef mapped = new BusModelBuffTimeDef();
					mapped.set((IBusModelTimeDef)rec);
					return(mapped); }
				case IBusModelTimeType.CLASS_CODE: {
					BusModelBuffTimeType mapped = new BusModelBuffTimeType();
					mapped.set((IBusModelTimeType)rec);
					return(mapped); }
				case IBusModelTimeCol.CLASS_CODE: {
					BusModelBuffTimeCol mapped = new BusModelBuffTimeCol();
					mapped.set((IBusModelTimeCol)rec);
					return(mapped); }
				case IBusModelTimestampDef.CLASS_CODE: {
					BusModelBuffTimestampDef mapped = new BusModelBuffTimestampDef();
					mapped.set((IBusModelTimestampDef)rec);
					return(mapped); }
				case IBusModelTimestampType.CLASS_CODE: {
					BusModelBuffTimestampType mapped = new BusModelBuffTimestampType();
					mapped.set((IBusModelTimestampType)rec);
					return(mapped); }
				case IBusModelTimestampCol.CLASS_CODE: {
					BusModelBuffTimestampCol mapped = new BusModelBuffTimestampCol();
					mapped.set((IBusModelTimestampCol)rec);
					return(mapped); }
				case IBusModelTokenDef.CLASS_CODE: {
					BusModelBuffTokenDef mapped = new BusModelBuffTokenDef();
					mapped.set((IBusModelTokenDef)rec);
					return(mapped); }
				case IBusModelTokenType.CLASS_CODE: {
					BusModelBuffTokenType mapped = new BusModelBuffTokenType();
					mapped.set((IBusModelTokenType)rec);
					return(mapped); }
				case IBusModelTokenCol.CLASS_CODE: {
					BusModelBuffTokenCol mapped = new BusModelBuffTokenCol();
					mapped.set((IBusModelTokenCol)rec);
					return(mapped); }
				case IBusModelUInt16Def.CLASS_CODE: {
					BusModelBuffUInt16Def mapped = new BusModelBuffUInt16Def();
					mapped.set((IBusModelUInt16Def)rec);
					return(mapped); }
				case IBusModelUInt16Type.CLASS_CODE: {
					BusModelBuffUInt16Type mapped = new BusModelBuffUInt16Type();
					mapped.set((IBusModelUInt16Type)rec);
					return(mapped); }
				case IBusModelUInt16Col.CLASS_CODE: {
					BusModelBuffUInt16Col mapped = new BusModelBuffUInt16Col();
					mapped.set((IBusModelUInt16Col)rec);
					return(mapped); }
				case IBusModelUInt32Def.CLASS_CODE: {
					BusModelBuffUInt32Def mapped = new BusModelBuffUInt32Def();
					mapped.set((IBusModelUInt32Def)rec);
					return(mapped); }
				case IBusModelUInt32Type.CLASS_CODE: {
					BusModelBuffUInt32Type mapped = new BusModelBuffUInt32Type();
					mapped.set((IBusModelUInt32Type)rec);
					return(mapped); }
				case IBusModelUInt32Col.CLASS_CODE: {
					BusModelBuffUInt32Col mapped = new BusModelBuffUInt32Col();
					mapped.set((IBusModelUInt32Col)rec);
					return(mapped); }
				case IBusModelUInt64Def.CLASS_CODE: {
					BusModelBuffUInt64Def mapped = new BusModelBuffUInt64Def();
					mapped.set((IBusModelUInt64Def)rec);
					return(mapped); }
				case IBusModelUInt64Type.CLASS_CODE: {
					BusModelBuffUInt64Type mapped = new BusModelBuffUInt64Type();
					mapped.set((IBusModelUInt64Type)rec);
					return(mapped); }
				case IBusModelUInt64Col.CLASS_CODE: {
					BusModelBuffUInt64Col mapped = new BusModelBuffUInt64Col();
					mapped.set((IBusModelUInt64Col)rec);
					return(mapped); }
				case IBusModelUuidDef.CLASS_CODE: {
					BusModelBuffUuidDef mapped = new BusModelBuffUuidDef();
					mapped.set((IBusModelUuidDef)rec);
					return(mapped); }
				case IBusModelUuidType.CLASS_CODE: {
					BusModelBuffUuidType mapped = new BusModelBuffUuidType();
					mapped.set((IBusModelUuidType)rec);
					return(mapped); }
				case IBusModelUuidGen.CLASS_CODE: {
					BusModelBuffUuidGen mapped = new BusModelBuffUuidGen();
					mapped.set((IBusModelUuidGen)rec);
					return(mapped); }
				case IBusModelUuidCol.CLASS_CODE: {
					BusModelBuffUuidCol mapped = new BusModelBuffUuidCol();
					mapped.set((IBusModelUuidCol)rec);
					return(mapped); }
				case IBusModelUuid6Def.CLASS_CODE: {
					BusModelBuffUuid6Def mapped = new BusModelBuffUuid6Def();
					mapped.set((IBusModelUuid6Def)rec);
					return(mapped); }
				case IBusModelUuid6Type.CLASS_CODE: {
					BusModelBuffUuid6Type mapped = new BusModelBuffUuid6Type();
					mapped.set((IBusModelUuid6Type)rec);
					return(mapped); }
				case IBusModelUuid6Gen.CLASS_CODE: {
					BusModelBuffUuid6Gen mapped = new BusModelBuffUuid6Gen();
					mapped.set((IBusModelUuid6Gen)rec);
					return(mapped); }
				case IBusModelUuid6Col.CLASS_CODE: {
					BusModelBuffUuid6Col mapped = new BusModelBuffUuid6Col();
					mapped.set((IBusModelUuid6Col)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelAtom",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelAtom");
			}
		}
	}

	@Override
	public IBusModelAtomH newHRec() {
		IBusModelAtomH hrec =
			new BusModelBuffAtomH();
		return( hrec );
	}

	public BusModelBuffAtomH ensureHRec(IBusModelAtomH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffAtomH) {
			return ((BusModelBuffAtomH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelAtom.CLASS_CODE: {
					BusModelBuffAtomH mapped = new BusModelBuffAtomH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelBlobDef.CLASS_CODE: {
					BusModelBuffBlobDefH mapped = new BusModelBuffBlobDefH();
					mapped.set((IBusModelBlobDefH)hrec);
					return(mapped); }
				case IBusModelBlobType.CLASS_CODE: {
					BusModelBuffBlobTypeH mapped = new BusModelBuffBlobTypeH();
					mapped.set((IBusModelBlobTypeH)hrec);
					return(mapped); }
				case IBusModelBlobCol.CLASS_CODE: {
					BusModelBuffBlobColH mapped = new BusModelBuffBlobColH();
					mapped.set((IBusModelBlobColH)hrec);
					return(mapped); }
				case IBusModelBoolDef.CLASS_CODE: {
					BusModelBuffBoolDefH mapped = new BusModelBuffBoolDefH();
					mapped.set((IBusModelBoolDefH)hrec);
					return(mapped); }
				case IBusModelBoolType.CLASS_CODE: {
					BusModelBuffBoolTypeH mapped = new BusModelBuffBoolTypeH();
					mapped.set((IBusModelBoolTypeH)hrec);
					return(mapped); }
				case IBusModelBoolCol.CLASS_CODE: {
					BusModelBuffBoolColH mapped = new BusModelBuffBoolColH();
					mapped.set((IBusModelBoolColH)hrec);
					return(mapped); }
				case IBusModelDateDef.CLASS_CODE: {
					BusModelBuffDateDefH mapped = new BusModelBuffDateDefH();
					mapped.set((IBusModelDateDefH)hrec);
					return(mapped); }
				case IBusModelDateType.CLASS_CODE: {
					BusModelBuffDateTypeH mapped = new BusModelBuffDateTypeH();
					mapped.set((IBusModelDateTypeH)hrec);
					return(mapped); }
				case IBusModelDateCol.CLASS_CODE: {
					BusModelBuffDateColH mapped = new BusModelBuffDateColH();
					mapped.set((IBusModelDateColH)hrec);
					return(mapped); }
				case IBusModelDoubleDef.CLASS_CODE: {
					BusModelBuffDoubleDefH mapped = new BusModelBuffDoubleDefH();
					mapped.set((IBusModelDoubleDefH)hrec);
					return(mapped); }
				case IBusModelDoubleType.CLASS_CODE: {
					BusModelBuffDoubleTypeH mapped = new BusModelBuffDoubleTypeH();
					mapped.set((IBusModelDoubleTypeH)hrec);
					return(mapped); }
				case IBusModelDoubleCol.CLASS_CODE: {
					BusModelBuffDoubleColH mapped = new BusModelBuffDoubleColH();
					mapped.set((IBusModelDoubleColH)hrec);
					return(mapped); }
				case IBusModelFloatDef.CLASS_CODE: {
					BusModelBuffFloatDefH mapped = new BusModelBuffFloatDefH();
					mapped.set((IBusModelFloatDefH)hrec);
					return(mapped); }
				case IBusModelFloatType.CLASS_CODE: {
					BusModelBuffFloatTypeH mapped = new BusModelBuffFloatTypeH();
					mapped.set((IBusModelFloatTypeH)hrec);
					return(mapped); }
				case IBusModelFloatCol.CLASS_CODE: {
					BusModelBuffFloatColH mapped = new BusModelBuffFloatColH();
					mapped.set((IBusModelFloatColH)hrec);
					return(mapped); }
				case IBusModelInt16Def.CLASS_CODE: {
					BusModelBuffInt16DefH mapped = new BusModelBuffInt16DefH();
					mapped.set((IBusModelInt16DefH)hrec);
					return(mapped); }
				case IBusModelInt16Type.CLASS_CODE: {
					BusModelBuffInt16TypeH mapped = new BusModelBuffInt16TypeH();
					mapped.set((IBusModelInt16TypeH)hrec);
					return(mapped); }
				case IBusModelId16Gen.CLASS_CODE: {
					BusModelBuffId16GenH mapped = new BusModelBuffId16GenH();
					mapped.set((IBusModelId16GenH)hrec);
					return(mapped); }
				case IBusModelEnumDef.CLASS_CODE: {
					BusModelBuffEnumDefH mapped = new BusModelBuffEnumDefH();
					mapped.set((IBusModelEnumDefH)hrec);
					return(mapped); }
				case IBusModelEnumType.CLASS_CODE: {
					BusModelBuffEnumTypeH mapped = new BusModelBuffEnumTypeH();
					mapped.set((IBusModelEnumTypeH)hrec);
					return(mapped); }
				case IBusModelInt16Col.CLASS_CODE: {
					BusModelBuffInt16ColH mapped = new BusModelBuffInt16ColH();
					mapped.set((IBusModelInt16ColH)hrec);
					return(mapped); }
				case IBusModelInt32Def.CLASS_CODE: {
					BusModelBuffInt32DefH mapped = new BusModelBuffInt32DefH();
					mapped.set((IBusModelInt32DefH)hrec);
					return(mapped); }
				case IBusModelInt32Type.CLASS_CODE: {
					BusModelBuffInt32TypeH mapped = new BusModelBuffInt32TypeH();
					mapped.set((IBusModelInt32TypeH)hrec);
					return(mapped); }
				case IBusModelId32Gen.CLASS_CODE: {
					BusModelBuffId32GenH mapped = new BusModelBuffId32GenH();
					mapped.set((IBusModelId32GenH)hrec);
					return(mapped); }
				case IBusModelInt32Col.CLASS_CODE: {
					BusModelBuffInt32ColH mapped = new BusModelBuffInt32ColH();
					mapped.set((IBusModelInt32ColH)hrec);
					return(mapped); }
				case IBusModelInt64Def.CLASS_CODE: {
					BusModelBuffInt64DefH mapped = new BusModelBuffInt64DefH();
					mapped.set((IBusModelInt64DefH)hrec);
					return(mapped); }
				case IBusModelInt64Type.CLASS_CODE: {
					BusModelBuffInt64TypeH mapped = new BusModelBuffInt64TypeH();
					mapped.set((IBusModelInt64TypeH)hrec);
					return(mapped); }
				case IBusModelId64Gen.CLASS_CODE: {
					BusModelBuffId64GenH mapped = new BusModelBuffId64GenH();
					mapped.set((IBusModelId64GenH)hrec);
					return(mapped); }
				case IBusModelInt64Col.CLASS_CODE: {
					BusModelBuffInt64ColH mapped = new BusModelBuffInt64ColH();
					mapped.set((IBusModelInt64ColH)hrec);
					return(mapped); }
				case IBusModelNmTokenDef.CLASS_CODE: {
					BusModelBuffNmTokenDefH mapped = new BusModelBuffNmTokenDefH();
					mapped.set((IBusModelNmTokenDefH)hrec);
					return(mapped); }
				case IBusModelNmTokenType.CLASS_CODE: {
					BusModelBuffNmTokenTypeH mapped = new BusModelBuffNmTokenTypeH();
					mapped.set((IBusModelNmTokenTypeH)hrec);
					return(mapped); }
				case IBusModelNmTokenCol.CLASS_CODE: {
					BusModelBuffNmTokenColH mapped = new BusModelBuffNmTokenColH();
					mapped.set((IBusModelNmTokenColH)hrec);
					return(mapped); }
				case IBusModelNmTokensDef.CLASS_CODE: {
					BusModelBuffNmTokensDefH mapped = new BusModelBuffNmTokensDefH();
					mapped.set((IBusModelNmTokensDefH)hrec);
					return(mapped); }
				case IBusModelNmTokensType.CLASS_CODE: {
					BusModelBuffNmTokensTypeH mapped = new BusModelBuffNmTokensTypeH();
					mapped.set((IBusModelNmTokensTypeH)hrec);
					return(mapped); }
				case IBusModelNmTokensCol.CLASS_CODE: {
					BusModelBuffNmTokensColH mapped = new BusModelBuffNmTokensColH();
					mapped.set((IBusModelNmTokensColH)hrec);
					return(mapped); }
				case IBusModelNumberDef.CLASS_CODE: {
					BusModelBuffNumberDefH mapped = new BusModelBuffNumberDefH();
					mapped.set((IBusModelNumberDefH)hrec);
					return(mapped); }
				case IBusModelNumberType.CLASS_CODE: {
					BusModelBuffNumberTypeH mapped = new BusModelBuffNumberTypeH();
					mapped.set((IBusModelNumberTypeH)hrec);
					return(mapped); }
				case IBusModelNumberCol.CLASS_CODE: {
					BusModelBuffNumberColH mapped = new BusModelBuffNumberColH();
					mapped.set((IBusModelNumberColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Def.CLASS_CODE: {
					BusModelBuffDbKeyHash128DefH mapped = new BusModelBuffDbKeyHash128DefH();
					mapped.set((IBusModelDbKeyHash128DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Col.CLASS_CODE: {
					BusModelBuffDbKeyHash128ColH mapped = new BusModelBuffDbKeyHash128ColH();
					mapped.set((IBusModelDbKeyHash128ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Type.CLASS_CODE: {
					BusModelBuffDbKeyHash128TypeH mapped = new BusModelBuffDbKeyHash128TypeH();
					mapped.set((IBusModelDbKeyHash128TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash128GenH mapped = new BusModelBuffDbKeyHash128GenH();
					mapped.set((IBusModelDbKeyHash128GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Def.CLASS_CODE: {
					BusModelBuffDbKeyHash160DefH mapped = new BusModelBuffDbKeyHash160DefH();
					mapped.set((IBusModelDbKeyHash160DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Col.CLASS_CODE: {
					BusModelBuffDbKeyHash160ColH mapped = new BusModelBuffDbKeyHash160ColH();
					mapped.set((IBusModelDbKeyHash160ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Type.CLASS_CODE: {
					BusModelBuffDbKeyHash160TypeH mapped = new BusModelBuffDbKeyHash160TypeH();
					mapped.set((IBusModelDbKeyHash160TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash160GenH mapped = new BusModelBuffDbKeyHash160GenH();
					mapped.set((IBusModelDbKeyHash160GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash224Def.CLASS_CODE: {
					BusModelBuffDbKeyHash224DefH mapped = new BusModelBuffDbKeyHash224DefH();
					mapped.set((IBusModelDbKeyHash224DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash224Col.CLASS_CODE: {
					BusModelBuffDbKeyHash224ColH mapped = new BusModelBuffDbKeyHash224ColH();
					mapped.set((IBusModelDbKeyHash224ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash224Type.CLASS_CODE: {
					BusModelBuffDbKeyHash224TypeH mapped = new BusModelBuffDbKeyHash224TypeH();
					mapped.set((IBusModelDbKeyHash224TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash224Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash224GenH mapped = new BusModelBuffDbKeyHash224GenH();
					mapped.set((IBusModelDbKeyHash224GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash256Def.CLASS_CODE: {
					BusModelBuffDbKeyHash256DefH mapped = new BusModelBuffDbKeyHash256DefH();
					mapped.set((IBusModelDbKeyHash256DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash256Col.CLASS_CODE: {
					BusModelBuffDbKeyHash256ColH mapped = new BusModelBuffDbKeyHash256ColH();
					mapped.set((IBusModelDbKeyHash256ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash256Type.CLASS_CODE: {
					BusModelBuffDbKeyHash256TypeH mapped = new BusModelBuffDbKeyHash256TypeH();
					mapped.set((IBusModelDbKeyHash256TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash256Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash256GenH mapped = new BusModelBuffDbKeyHash256GenH();
					mapped.set((IBusModelDbKeyHash256GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash384Def.CLASS_CODE: {
					BusModelBuffDbKeyHash384DefH mapped = new BusModelBuffDbKeyHash384DefH();
					mapped.set((IBusModelDbKeyHash384DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash384Col.CLASS_CODE: {
					BusModelBuffDbKeyHash384ColH mapped = new BusModelBuffDbKeyHash384ColH();
					mapped.set((IBusModelDbKeyHash384ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash384Type.CLASS_CODE: {
					BusModelBuffDbKeyHash384TypeH mapped = new BusModelBuffDbKeyHash384TypeH();
					mapped.set((IBusModelDbKeyHash384TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash384Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash384GenH mapped = new BusModelBuffDbKeyHash384GenH();
					mapped.set((IBusModelDbKeyHash384GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash512Def.CLASS_CODE: {
					BusModelBuffDbKeyHash512DefH mapped = new BusModelBuffDbKeyHash512DefH();
					mapped.set((IBusModelDbKeyHash512DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash512Col.CLASS_CODE: {
					BusModelBuffDbKeyHash512ColH mapped = new BusModelBuffDbKeyHash512ColH();
					mapped.set((IBusModelDbKeyHash512ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash512Type.CLASS_CODE: {
					BusModelBuffDbKeyHash512TypeH mapped = new BusModelBuffDbKeyHash512TypeH();
					mapped.set((IBusModelDbKeyHash512TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash512Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash512GenH mapped = new BusModelBuffDbKeyHash512GenH();
					mapped.set((IBusModelDbKeyHash512GenH)hrec);
					return(mapped); }
				case IBusModelStringDef.CLASS_CODE: {
					BusModelBuffStringDefH mapped = new BusModelBuffStringDefH();
					mapped.set((IBusModelStringDefH)hrec);
					return(mapped); }
				case IBusModelStringType.CLASS_CODE: {
					BusModelBuffStringTypeH mapped = new BusModelBuffStringTypeH();
					mapped.set((IBusModelStringTypeH)hrec);
					return(mapped); }
				case IBusModelStringCol.CLASS_CODE: {
					BusModelBuffStringColH mapped = new BusModelBuffStringColH();
					mapped.set((IBusModelStringColH)hrec);
					return(mapped); }
				case IBusModelTZDateDef.CLASS_CODE: {
					BusModelBuffTZDateDefH mapped = new BusModelBuffTZDateDefH();
					mapped.set((IBusModelTZDateDefH)hrec);
					return(mapped); }
				case IBusModelTZDateType.CLASS_CODE: {
					BusModelBuffTZDateTypeH mapped = new BusModelBuffTZDateTypeH();
					mapped.set((IBusModelTZDateTypeH)hrec);
					return(mapped); }
				case IBusModelTZDateCol.CLASS_CODE: {
					BusModelBuffTZDateColH mapped = new BusModelBuffTZDateColH();
					mapped.set((IBusModelTZDateColH)hrec);
					return(mapped); }
				case IBusModelTZTimeDef.CLASS_CODE: {
					BusModelBuffTZTimeDefH mapped = new BusModelBuffTZTimeDefH();
					mapped.set((IBusModelTZTimeDefH)hrec);
					return(mapped); }
				case IBusModelTZTimeType.CLASS_CODE: {
					BusModelBuffTZTimeTypeH mapped = new BusModelBuffTZTimeTypeH();
					mapped.set((IBusModelTZTimeTypeH)hrec);
					return(mapped); }
				case IBusModelTZTimeCol.CLASS_CODE: {
					BusModelBuffTZTimeColH mapped = new BusModelBuffTZTimeColH();
					mapped.set((IBusModelTZTimeColH)hrec);
					return(mapped); }
				case IBusModelTZTimestampDef.CLASS_CODE: {
					BusModelBuffTZTimestampDefH mapped = new BusModelBuffTZTimestampDefH();
					mapped.set((IBusModelTZTimestampDefH)hrec);
					return(mapped); }
				case IBusModelTZTimestampType.CLASS_CODE: {
					BusModelBuffTZTimestampTypeH mapped = new BusModelBuffTZTimestampTypeH();
					mapped.set((IBusModelTZTimestampTypeH)hrec);
					return(mapped); }
				case IBusModelTZTimestampCol.CLASS_CODE: {
					BusModelBuffTZTimestampColH mapped = new BusModelBuffTZTimestampColH();
					mapped.set((IBusModelTZTimestampColH)hrec);
					return(mapped); }
				case IBusModelTextDef.CLASS_CODE: {
					BusModelBuffTextDefH mapped = new BusModelBuffTextDefH();
					mapped.set((IBusModelTextDefH)hrec);
					return(mapped); }
				case IBusModelTextType.CLASS_CODE: {
					BusModelBuffTextTypeH mapped = new BusModelBuffTextTypeH();
					mapped.set((IBusModelTextTypeH)hrec);
					return(mapped); }
				case IBusModelTextCol.CLASS_CODE: {
					BusModelBuffTextColH mapped = new BusModelBuffTextColH();
					mapped.set((IBusModelTextColH)hrec);
					return(mapped); }
				case IBusModelTimeDef.CLASS_CODE: {
					BusModelBuffTimeDefH mapped = new BusModelBuffTimeDefH();
					mapped.set((IBusModelTimeDefH)hrec);
					return(mapped); }
				case IBusModelTimeType.CLASS_CODE: {
					BusModelBuffTimeTypeH mapped = new BusModelBuffTimeTypeH();
					mapped.set((IBusModelTimeTypeH)hrec);
					return(mapped); }
				case IBusModelTimeCol.CLASS_CODE: {
					BusModelBuffTimeColH mapped = new BusModelBuffTimeColH();
					mapped.set((IBusModelTimeColH)hrec);
					return(mapped); }
				case IBusModelTimestampDef.CLASS_CODE: {
					BusModelBuffTimestampDefH mapped = new BusModelBuffTimestampDefH();
					mapped.set((IBusModelTimestampDefH)hrec);
					return(mapped); }
				case IBusModelTimestampType.CLASS_CODE: {
					BusModelBuffTimestampTypeH mapped = new BusModelBuffTimestampTypeH();
					mapped.set((IBusModelTimestampTypeH)hrec);
					return(mapped); }
				case IBusModelTimestampCol.CLASS_CODE: {
					BusModelBuffTimestampColH mapped = new BusModelBuffTimestampColH();
					mapped.set((IBusModelTimestampColH)hrec);
					return(mapped); }
				case IBusModelTokenDef.CLASS_CODE: {
					BusModelBuffTokenDefH mapped = new BusModelBuffTokenDefH();
					mapped.set((IBusModelTokenDefH)hrec);
					return(mapped); }
				case IBusModelTokenType.CLASS_CODE: {
					BusModelBuffTokenTypeH mapped = new BusModelBuffTokenTypeH();
					mapped.set((IBusModelTokenTypeH)hrec);
					return(mapped); }
				case IBusModelTokenCol.CLASS_CODE: {
					BusModelBuffTokenColH mapped = new BusModelBuffTokenColH();
					mapped.set((IBusModelTokenColH)hrec);
					return(mapped); }
				case IBusModelUInt16Def.CLASS_CODE: {
					BusModelBuffUInt16DefH mapped = new BusModelBuffUInt16DefH();
					mapped.set((IBusModelUInt16DefH)hrec);
					return(mapped); }
				case IBusModelUInt16Type.CLASS_CODE: {
					BusModelBuffUInt16TypeH mapped = new BusModelBuffUInt16TypeH();
					mapped.set((IBusModelUInt16TypeH)hrec);
					return(mapped); }
				case IBusModelUInt16Col.CLASS_CODE: {
					BusModelBuffUInt16ColH mapped = new BusModelBuffUInt16ColH();
					mapped.set((IBusModelUInt16ColH)hrec);
					return(mapped); }
				case IBusModelUInt32Def.CLASS_CODE: {
					BusModelBuffUInt32DefH mapped = new BusModelBuffUInt32DefH();
					mapped.set((IBusModelUInt32DefH)hrec);
					return(mapped); }
				case IBusModelUInt32Type.CLASS_CODE: {
					BusModelBuffUInt32TypeH mapped = new BusModelBuffUInt32TypeH();
					mapped.set((IBusModelUInt32TypeH)hrec);
					return(mapped); }
				case IBusModelUInt32Col.CLASS_CODE: {
					BusModelBuffUInt32ColH mapped = new BusModelBuffUInt32ColH();
					mapped.set((IBusModelUInt32ColH)hrec);
					return(mapped); }
				case IBusModelUInt64Def.CLASS_CODE: {
					BusModelBuffUInt64DefH mapped = new BusModelBuffUInt64DefH();
					mapped.set((IBusModelUInt64DefH)hrec);
					return(mapped); }
				case IBusModelUInt64Type.CLASS_CODE: {
					BusModelBuffUInt64TypeH mapped = new BusModelBuffUInt64TypeH();
					mapped.set((IBusModelUInt64TypeH)hrec);
					return(mapped); }
				case IBusModelUInt64Col.CLASS_CODE: {
					BusModelBuffUInt64ColH mapped = new BusModelBuffUInt64ColH();
					mapped.set((IBusModelUInt64ColH)hrec);
					return(mapped); }
				case IBusModelUuidDef.CLASS_CODE: {
					BusModelBuffUuidDefH mapped = new BusModelBuffUuidDefH();
					mapped.set((IBusModelUuidDefH)hrec);
					return(mapped); }
				case IBusModelUuidType.CLASS_CODE: {
					BusModelBuffUuidTypeH mapped = new BusModelBuffUuidTypeH();
					mapped.set((IBusModelUuidTypeH)hrec);
					return(mapped); }
				case IBusModelUuidGen.CLASS_CODE: {
					BusModelBuffUuidGenH mapped = new BusModelBuffUuidGenH();
					mapped.set((IBusModelUuidGenH)hrec);
					return(mapped); }
				case IBusModelUuidCol.CLASS_CODE: {
					BusModelBuffUuidColH mapped = new BusModelBuffUuidColH();
					mapped.set((IBusModelUuidColH)hrec);
					return(mapped); }
				case IBusModelUuid6Def.CLASS_CODE: {
					BusModelBuffUuid6DefH mapped = new BusModelBuffUuid6DefH();
					mapped.set((IBusModelUuid6DefH)hrec);
					return(mapped); }
				case IBusModelUuid6Type.CLASS_CODE: {
					BusModelBuffUuid6TypeH mapped = new BusModelBuffUuid6TypeH();
					mapped.set((IBusModelUuid6TypeH)hrec);
					return(mapped); }
				case IBusModelUuid6Gen.CLASS_CODE: {
					BusModelBuffUuid6GenH mapped = new BusModelBuffUuid6GenH();
					mapped.set((IBusModelUuid6GenH)hrec);
					return(mapped); }
				case IBusModelUuid6Col.CLASS_CODE: {
					BusModelBuffUuid6ColH mapped = new BusModelBuffUuid6ColH();
					mapped.set((IBusModelUuid6ColH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelAtom",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelAtom");
			}
		}
	}
}
