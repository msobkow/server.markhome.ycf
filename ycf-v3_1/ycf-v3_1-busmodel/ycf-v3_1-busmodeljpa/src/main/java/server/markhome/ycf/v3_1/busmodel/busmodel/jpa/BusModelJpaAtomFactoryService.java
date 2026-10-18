
// Description: Java 25 Factory service implementation for Atom JPA objects

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

package server.markhome.ycf.v3_1.busmodel.busmodel.jpa;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;

/*
 *	Java 25 Factory service implementation for Atom JPA objects.
 */
public class BusModelJpaAtomFactoryService
    implements IBusModelAtomFactory
{
    public BusModelJpaAtomFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelAtom newRec() {
        IBusModelAtom rec = new BusModelJpaAtom();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaAtom ensureRec(IBusModelAtom rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaAtom) {
			return( (BusModelJpaAtom)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelAtom.CLASS_CODE: {
					BusModelJpaAtom mapped = new BusModelJpaAtom();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelBlobDef.CLASS_CODE: {
					BusModelJpaBlobDef mapped = new BusModelJpaBlobDef();
					mapped.set((IBusModelBlobDef)rec);
					return(mapped); }
				case IBusModelBlobType.CLASS_CODE: {
					BusModelJpaBlobType mapped = new BusModelJpaBlobType();
					mapped.set((IBusModelBlobType)rec);
					return(mapped); }
				case IBusModelBlobCol.CLASS_CODE: {
					BusModelJpaBlobCol mapped = new BusModelJpaBlobCol();
					mapped.set((IBusModelBlobCol)rec);
					return(mapped); }
				case IBusModelBoolDef.CLASS_CODE: {
					BusModelJpaBoolDef mapped = new BusModelJpaBoolDef();
					mapped.set((IBusModelBoolDef)rec);
					return(mapped); }
				case IBusModelBoolType.CLASS_CODE: {
					BusModelJpaBoolType mapped = new BusModelJpaBoolType();
					mapped.set((IBusModelBoolType)rec);
					return(mapped); }
				case IBusModelBoolCol.CLASS_CODE: {
					BusModelJpaBoolCol mapped = new BusModelJpaBoolCol();
					mapped.set((IBusModelBoolCol)rec);
					return(mapped); }
				case IBusModelDateDef.CLASS_CODE: {
					BusModelJpaDateDef mapped = new BusModelJpaDateDef();
					mapped.set((IBusModelDateDef)rec);
					return(mapped); }
				case IBusModelDateType.CLASS_CODE: {
					BusModelJpaDateType mapped = new BusModelJpaDateType();
					mapped.set((IBusModelDateType)rec);
					return(mapped); }
				case IBusModelDateCol.CLASS_CODE: {
					BusModelJpaDateCol mapped = new BusModelJpaDateCol();
					mapped.set((IBusModelDateCol)rec);
					return(mapped); }
				case IBusModelDoubleDef.CLASS_CODE: {
					BusModelJpaDoubleDef mapped = new BusModelJpaDoubleDef();
					mapped.set((IBusModelDoubleDef)rec);
					return(mapped); }
				case IBusModelDoubleType.CLASS_CODE: {
					BusModelJpaDoubleType mapped = new BusModelJpaDoubleType();
					mapped.set((IBusModelDoubleType)rec);
					return(mapped); }
				case IBusModelDoubleCol.CLASS_CODE: {
					BusModelJpaDoubleCol mapped = new BusModelJpaDoubleCol();
					mapped.set((IBusModelDoubleCol)rec);
					return(mapped); }
				case IBusModelFloatDef.CLASS_CODE: {
					BusModelJpaFloatDef mapped = new BusModelJpaFloatDef();
					mapped.set((IBusModelFloatDef)rec);
					return(mapped); }
				case IBusModelFloatType.CLASS_CODE: {
					BusModelJpaFloatType mapped = new BusModelJpaFloatType();
					mapped.set((IBusModelFloatType)rec);
					return(mapped); }
				case IBusModelFloatCol.CLASS_CODE: {
					BusModelJpaFloatCol mapped = new BusModelJpaFloatCol();
					mapped.set((IBusModelFloatCol)rec);
					return(mapped); }
				case IBusModelInt16Def.CLASS_CODE: {
					BusModelJpaInt16Def mapped = new BusModelJpaInt16Def();
					mapped.set((IBusModelInt16Def)rec);
					return(mapped); }
				case IBusModelInt16Type.CLASS_CODE: {
					BusModelJpaInt16Type mapped = new BusModelJpaInt16Type();
					mapped.set((IBusModelInt16Type)rec);
					return(mapped); }
				case IBusModelId16Gen.CLASS_CODE: {
					BusModelJpaId16Gen mapped = new BusModelJpaId16Gen();
					mapped.set((IBusModelId16Gen)rec);
					return(mapped); }
				case IBusModelEnumDef.CLASS_CODE: {
					BusModelJpaEnumDef mapped = new BusModelJpaEnumDef();
					mapped.set((IBusModelEnumDef)rec);
					return(mapped); }
				case IBusModelEnumType.CLASS_CODE: {
					BusModelJpaEnumType mapped = new BusModelJpaEnumType();
					mapped.set((IBusModelEnumType)rec);
					return(mapped); }
				case IBusModelInt16Col.CLASS_CODE: {
					BusModelJpaInt16Col mapped = new BusModelJpaInt16Col();
					mapped.set((IBusModelInt16Col)rec);
					return(mapped); }
				case IBusModelInt32Def.CLASS_CODE: {
					BusModelJpaInt32Def mapped = new BusModelJpaInt32Def();
					mapped.set((IBusModelInt32Def)rec);
					return(mapped); }
				case IBusModelInt32Type.CLASS_CODE: {
					BusModelJpaInt32Type mapped = new BusModelJpaInt32Type();
					mapped.set((IBusModelInt32Type)rec);
					return(mapped); }
				case IBusModelId32Gen.CLASS_CODE: {
					BusModelJpaId32Gen mapped = new BusModelJpaId32Gen();
					mapped.set((IBusModelId32Gen)rec);
					return(mapped); }
				case IBusModelInt32Col.CLASS_CODE: {
					BusModelJpaInt32Col mapped = new BusModelJpaInt32Col();
					mapped.set((IBusModelInt32Col)rec);
					return(mapped); }
				case IBusModelInt64Def.CLASS_CODE: {
					BusModelJpaInt64Def mapped = new BusModelJpaInt64Def();
					mapped.set((IBusModelInt64Def)rec);
					return(mapped); }
				case IBusModelInt64Type.CLASS_CODE: {
					BusModelJpaInt64Type mapped = new BusModelJpaInt64Type();
					mapped.set((IBusModelInt64Type)rec);
					return(mapped); }
				case IBusModelId64Gen.CLASS_CODE: {
					BusModelJpaId64Gen mapped = new BusModelJpaId64Gen();
					mapped.set((IBusModelId64Gen)rec);
					return(mapped); }
				case IBusModelInt64Col.CLASS_CODE: {
					BusModelJpaInt64Col mapped = new BusModelJpaInt64Col();
					mapped.set((IBusModelInt64Col)rec);
					return(mapped); }
				case IBusModelNmTokenDef.CLASS_CODE: {
					BusModelJpaNmTokenDef mapped = new BusModelJpaNmTokenDef();
					mapped.set((IBusModelNmTokenDef)rec);
					return(mapped); }
				case IBusModelNmTokenType.CLASS_CODE: {
					BusModelJpaNmTokenType mapped = new BusModelJpaNmTokenType();
					mapped.set((IBusModelNmTokenType)rec);
					return(mapped); }
				case IBusModelNmTokenCol.CLASS_CODE: {
					BusModelJpaNmTokenCol mapped = new BusModelJpaNmTokenCol();
					mapped.set((IBusModelNmTokenCol)rec);
					return(mapped); }
				case IBusModelNmTokensDef.CLASS_CODE: {
					BusModelJpaNmTokensDef mapped = new BusModelJpaNmTokensDef();
					mapped.set((IBusModelNmTokensDef)rec);
					return(mapped); }
				case IBusModelNmTokensType.CLASS_CODE: {
					BusModelJpaNmTokensType mapped = new BusModelJpaNmTokensType();
					mapped.set((IBusModelNmTokensType)rec);
					return(mapped); }
				case IBusModelNmTokensCol.CLASS_CODE: {
					BusModelJpaNmTokensCol mapped = new BusModelJpaNmTokensCol();
					mapped.set((IBusModelNmTokensCol)rec);
					return(mapped); }
				case IBusModelNumberDef.CLASS_CODE: {
					BusModelJpaNumberDef mapped = new BusModelJpaNumberDef();
					mapped.set((IBusModelNumberDef)rec);
					return(mapped); }
				case IBusModelNumberType.CLASS_CODE: {
					BusModelJpaNumberType mapped = new BusModelJpaNumberType();
					mapped.set((IBusModelNumberType)rec);
					return(mapped); }
				case IBusModelNumberCol.CLASS_CODE: {
					BusModelJpaNumberCol mapped = new BusModelJpaNumberCol();
					mapped.set((IBusModelNumberCol)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Def.CLASS_CODE: {
					BusModelJpaDbKeyHash128Def mapped = new BusModelJpaDbKeyHash128Def();
					mapped.set((IBusModelDbKeyHash128Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Col.CLASS_CODE: {
					BusModelJpaDbKeyHash128Col mapped = new BusModelJpaDbKeyHash128Col();
					mapped.set((IBusModelDbKeyHash128Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Type.CLASS_CODE: {
					BusModelJpaDbKeyHash128Type mapped = new BusModelJpaDbKeyHash128Type();
					mapped.set((IBusModelDbKeyHash128Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash128Gen mapped = new BusModelJpaDbKeyHash128Gen();
					mapped.set((IBusModelDbKeyHash128Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Def.CLASS_CODE: {
					BusModelJpaDbKeyHash160Def mapped = new BusModelJpaDbKeyHash160Def();
					mapped.set((IBusModelDbKeyHash160Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Col.CLASS_CODE: {
					BusModelJpaDbKeyHash160Col mapped = new BusModelJpaDbKeyHash160Col();
					mapped.set((IBusModelDbKeyHash160Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Type.CLASS_CODE: {
					BusModelJpaDbKeyHash160Type mapped = new BusModelJpaDbKeyHash160Type();
					mapped.set((IBusModelDbKeyHash160Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash160Gen mapped = new BusModelJpaDbKeyHash160Gen();
					mapped.set((IBusModelDbKeyHash160Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash224Def.CLASS_CODE: {
					BusModelJpaDbKeyHash224Def mapped = new BusModelJpaDbKeyHash224Def();
					mapped.set((IBusModelDbKeyHash224Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash224Col.CLASS_CODE: {
					BusModelJpaDbKeyHash224Col mapped = new BusModelJpaDbKeyHash224Col();
					mapped.set((IBusModelDbKeyHash224Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash224Type.CLASS_CODE: {
					BusModelJpaDbKeyHash224Type mapped = new BusModelJpaDbKeyHash224Type();
					mapped.set((IBusModelDbKeyHash224Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash224Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash224Gen mapped = new BusModelJpaDbKeyHash224Gen();
					mapped.set((IBusModelDbKeyHash224Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash256Def.CLASS_CODE: {
					BusModelJpaDbKeyHash256Def mapped = new BusModelJpaDbKeyHash256Def();
					mapped.set((IBusModelDbKeyHash256Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash256Col.CLASS_CODE: {
					BusModelJpaDbKeyHash256Col mapped = new BusModelJpaDbKeyHash256Col();
					mapped.set((IBusModelDbKeyHash256Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash256Type.CLASS_CODE: {
					BusModelJpaDbKeyHash256Type mapped = new BusModelJpaDbKeyHash256Type();
					mapped.set((IBusModelDbKeyHash256Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash256Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash256Gen mapped = new BusModelJpaDbKeyHash256Gen();
					mapped.set((IBusModelDbKeyHash256Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash384Def.CLASS_CODE: {
					BusModelJpaDbKeyHash384Def mapped = new BusModelJpaDbKeyHash384Def();
					mapped.set((IBusModelDbKeyHash384Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash384Col.CLASS_CODE: {
					BusModelJpaDbKeyHash384Col mapped = new BusModelJpaDbKeyHash384Col();
					mapped.set((IBusModelDbKeyHash384Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash384Type.CLASS_CODE: {
					BusModelJpaDbKeyHash384Type mapped = new BusModelJpaDbKeyHash384Type();
					mapped.set((IBusModelDbKeyHash384Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash384Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash384Gen mapped = new BusModelJpaDbKeyHash384Gen();
					mapped.set((IBusModelDbKeyHash384Gen)rec);
					return(mapped); }
				case IBusModelDbKeyHash512Def.CLASS_CODE: {
					BusModelJpaDbKeyHash512Def mapped = new BusModelJpaDbKeyHash512Def();
					mapped.set((IBusModelDbKeyHash512Def)rec);
					return(mapped); }
				case IBusModelDbKeyHash512Col.CLASS_CODE: {
					BusModelJpaDbKeyHash512Col mapped = new BusModelJpaDbKeyHash512Col();
					mapped.set((IBusModelDbKeyHash512Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash512Type.CLASS_CODE: {
					BusModelJpaDbKeyHash512Type mapped = new BusModelJpaDbKeyHash512Type();
					mapped.set((IBusModelDbKeyHash512Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash512Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash512Gen mapped = new BusModelJpaDbKeyHash512Gen();
					mapped.set((IBusModelDbKeyHash512Gen)rec);
					return(mapped); }
				case IBusModelStringDef.CLASS_CODE: {
					BusModelJpaStringDef mapped = new BusModelJpaStringDef();
					mapped.set((IBusModelStringDef)rec);
					return(mapped); }
				case IBusModelStringType.CLASS_CODE: {
					BusModelJpaStringType mapped = new BusModelJpaStringType();
					mapped.set((IBusModelStringType)rec);
					return(mapped); }
				case IBusModelStringCol.CLASS_CODE: {
					BusModelJpaStringCol mapped = new BusModelJpaStringCol();
					mapped.set((IBusModelStringCol)rec);
					return(mapped); }
				case IBusModelTZDateDef.CLASS_CODE: {
					BusModelJpaTZDateDef mapped = new BusModelJpaTZDateDef();
					mapped.set((IBusModelTZDateDef)rec);
					return(mapped); }
				case IBusModelTZDateType.CLASS_CODE: {
					BusModelJpaTZDateType mapped = new BusModelJpaTZDateType();
					mapped.set((IBusModelTZDateType)rec);
					return(mapped); }
				case IBusModelTZDateCol.CLASS_CODE: {
					BusModelJpaTZDateCol mapped = new BusModelJpaTZDateCol();
					mapped.set((IBusModelTZDateCol)rec);
					return(mapped); }
				case IBusModelTZTimeDef.CLASS_CODE: {
					BusModelJpaTZTimeDef mapped = new BusModelJpaTZTimeDef();
					mapped.set((IBusModelTZTimeDef)rec);
					return(mapped); }
				case IBusModelTZTimeType.CLASS_CODE: {
					BusModelJpaTZTimeType mapped = new BusModelJpaTZTimeType();
					mapped.set((IBusModelTZTimeType)rec);
					return(mapped); }
				case IBusModelTZTimeCol.CLASS_CODE: {
					BusModelJpaTZTimeCol mapped = new BusModelJpaTZTimeCol();
					mapped.set((IBusModelTZTimeCol)rec);
					return(mapped); }
				case IBusModelTZTimestampDef.CLASS_CODE: {
					BusModelJpaTZTimestampDef mapped = new BusModelJpaTZTimestampDef();
					mapped.set((IBusModelTZTimestampDef)rec);
					return(mapped); }
				case IBusModelTZTimestampType.CLASS_CODE: {
					BusModelJpaTZTimestampType mapped = new BusModelJpaTZTimestampType();
					mapped.set((IBusModelTZTimestampType)rec);
					return(mapped); }
				case IBusModelTZTimestampCol.CLASS_CODE: {
					BusModelJpaTZTimestampCol mapped = new BusModelJpaTZTimestampCol();
					mapped.set((IBusModelTZTimestampCol)rec);
					return(mapped); }
				case IBusModelTextDef.CLASS_CODE: {
					BusModelJpaTextDef mapped = new BusModelJpaTextDef();
					mapped.set((IBusModelTextDef)rec);
					return(mapped); }
				case IBusModelTextType.CLASS_CODE: {
					BusModelJpaTextType mapped = new BusModelJpaTextType();
					mapped.set((IBusModelTextType)rec);
					return(mapped); }
				case IBusModelTextCol.CLASS_CODE: {
					BusModelJpaTextCol mapped = new BusModelJpaTextCol();
					mapped.set((IBusModelTextCol)rec);
					return(mapped); }
				case IBusModelTimeDef.CLASS_CODE: {
					BusModelJpaTimeDef mapped = new BusModelJpaTimeDef();
					mapped.set((IBusModelTimeDef)rec);
					return(mapped); }
				case IBusModelTimeType.CLASS_CODE: {
					BusModelJpaTimeType mapped = new BusModelJpaTimeType();
					mapped.set((IBusModelTimeType)rec);
					return(mapped); }
				case IBusModelTimeCol.CLASS_CODE: {
					BusModelJpaTimeCol mapped = new BusModelJpaTimeCol();
					mapped.set((IBusModelTimeCol)rec);
					return(mapped); }
				case IBusModelTimestampDef.CLASS_CODE: {
					BusModelJpaTimestampDef mapped = new BusModelJpaTimestampDef();
					mapped.set((IBusModelTimestampDef)rec);
					return(mapped); }
				case IBusModelTimestampType.CLASS_CODE: {
					BusModelJpaTimestampType mapped = new BusModelJpaTimestampType();
					mapped.set((IBusModelTimestampType)rec);
					return(mapped); }
				case IBusModelTimestampCol.CLASS_CODE: {
					BusModelJpaTimestampCol mapped = new BusModelJpaTimestampCol();
					mapped.set((IBusModelTimestampCol)rec);
					return(mapped); }
				case IBusModelTokenDef.CLASS_CODE: {
					BusModelJpaTokenDef mapped = new BusModelJpaTokenDef();
					mapped.set((IBusModelTokenDef)rec);
					return(mapped); }
				case IBusModelTokenType.CLASS_CODE: {
					BusModelJpaTokenType mapped = new BusModelJpaTokenType();
					mapped.set((IBusModelTokenType)rec);
					return(mapped); }
				case IBusModelTokenCol.CLASS_CODE: {
					BusModelJpaTokenCol mapped = new BusModelJpaTokenCol();
					mapped.set((IBusModelTokenCol)rec);
					return(mapped); }
				case IBusModelUInt16Def.CLASS_CODE: {
					BusModelJpaUInt16Def mapped = new BusModelJpaUInt16Def();
					mapped.set((IBusModelUInt16Def)rec);
					return(mapped); }
				case IBusModelUInt16Type.CLASS_CODE: {
					BusModelJpaUInt16Type mapped = new BusModelJpaUInt16Type();
					mapped.set((IBusModelUInt16Type)rec);
					return(mapped); }
				case IBusModelUInt16Col.CLASS_CODE: {
					BusModelJpaUInt16Col mapped = new BusModelJpaUInt16Col();
					mapped.set((IBusModelUInt16Col)rec);
					return(mapped); }
				case IBusModelUInt32Def.CLASS_CODE: {
					BusModelJpaUInt32Def mapped = new BusModelJpaUInt32Def();
					mapped.set((IBusModelUInt32Def)rec);
					return(mapped); }
				case IBusModelUInt32Type.CLASS_CODE: {
					BusModelJpaUInt32Type mapped = new BusModelJpaUInt32Type();
					mapped.set((IBusModelUInt32Type)rec);
					return(mapped); }
				case IBusModelUInt32Col.CLASS_CODE: {
					BusModelJpaUInt32Col mapped = new BusModelJpaUInt32Col();
					mapped.set((IBusModelUInt32Col)rec);
					return(mapped); }
				case IBusModelUInt64Def.CLASS_CODE: {
					BusModelJpaUInt64Def mapped = new BusModelJpaUInt64Def();
					mapped.set((IBusModelUInt64Def)rec);
					return(mapped); }
				case IBusModelUInt64Type.CLASS_CODE: {
					BusModelJpaUInt64Type mapped = new BusModelJpaUInt64Type();
					mapped.set((IBusModelUInt64Type)rec);
					return(mapped); }
				case IBusModelUInt64Col.CLASS_CODE: {
					BusModelJpaUInt64Col mapped = new BusModelJpaUInt64Col();
					mapped.set((IBusModelUInt64Col)rec);
					return(mapped); }
				case IBusModelUuidDef.CLASS_CODE: {
					BusModelJpaUuidDef mapped = new BusModelJpaUuidDef();
					mapped.set((IBusModelUuidDef)rec);
					return(mapped); }
				case IBusModelUuidType.CLASS_CODE: {
					BusModelJpaUuidType mapped = new BusModelJpaUuidType();
					mapped.set((IBusModelUuidType)rec);
					return(mapped); }
				case IBusModelUuidGen.CLASS_CODE: {
					BusModelJpaUuidGen mapped = new BusModelJpaUuidGen();
					mapped.set((IBusModelUuidGen)rec);
					return(mapped); }
				case IBusModelUuidCol.CLASS_CODE: {
					BusModelJpaUuidCol mapped = new BusModelJpaUuidCol();
					mapped.set((IBusModelUuidCol)rec);
					return(mapped); }
				case IBusModelUuid6Def.CLASS_CODE: {
					BusModelJpaUuid6Def mapped = new BusModelJpaUuid6Def();
					mapped.set((IBusModelUuid6Def)rec);
					return(mapped); }
				case IBusModelUuid6Type.CLASS_CODE: {
					BusModelJpaUuid6Type mapped = new BusModelJpaUuid6Type();
					mapped.set((IBusModelUuid6Type)rec);
					return(mapped); }
				case IBusModelUuid6Gen.CLASS_CODE: {
					BusModelJpaUuid6Gen mapped = new BusModelJpaUuid6Gen();
					mapped.set((IBusModelUuid6Gen)rec);
					return(mapped); }
				case IBusModelUuid6Col.CLASS_CODE: {
					BusModelJpaUuid6Col mapped = new BusModelJpaUuid6Col();
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
        IBusModelAtomH hrec = new BusModelJpaAtomH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaAtomH ensureHRec(IBusModelAtomH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaAtomH) {
			return( (BusModelJpaAtomH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelAtom.CLASS_CODE: {
					BusModelJpaAtomH mapped = new BusModelJpaAtomH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelBlobDef.CLASS_CODE: {
					BusModelJpaBlobDefH mapped = new BusModelJpaBlobDefH();
					mapped.set((IBusModelBlobDefH)hrec);
					return(mapped); }
				case IBusModelBlobType.CLASS_CODE: {
					BusModelJpaBlobTypeH mapped = new BusModelJpaBlobTypeH();
					mapped.set((IBusModelBlobTypeH)hrec);
					return(mapped); }
				case IBusModelBlobCol.CLASS_CODE: {
					BusModelJpaBlobColH mapped = new BusModelJpaBlobColH();
					mapped.set((IBusModelBlobColH)hrec);
					return(mapped); }
				case IBusModelBoolDef.CLASS_CODE: {
					BusModelJpaBoolDefH mapped = new BusModelJpaBoolDefH();
					mapped.set((IBusModelBoolDefH)hrec);
					return(mapped); }
				case IBusModelBoolType.CLASS_CODE: {
					BusModelJpaBoolTypeH mapped = new BusModelJpaBoolTypeH();
					mapped.set((IBusModelBoolTypeH)hrec);
					return(mapped); }
				case IBusModelBoolCol.CLASS_CODE: {
					BusModelJpaBoolColH mapped = new BusModelJpaBoolColH();
					mapped.set((IBusModelBoolColH)hrec);
					return(mapped); }
				case IBusModelDateDef.CLASS_CODE: {
					BusModelJpaDateDefH mapped = new BusModelJpaDateDefH();
					mapped.set((IBusModelDateDefH)hrec);
					return(mapped); }
				case IBusModelDateType.CLASS_CODE: {
					BusModelJpaDateTypeH mapped = new BusModelJpaDateTypeH();
					mapped.set((IBusModelDateTypeH)hrec);
					return(mapped); }
				case IBusModelDateCol.CLASS_CODE: {
					BusModelJpaDateColH mapped = new BusModelJpaDateColH();
					mapped.set((IBusModelDateColH)hrec);
					return(mapped); }
				case IBusModelDoubleDef.CLASS_CODE: {
					BusModelJpaDoubleDefH mapped = new BusModelJpaDoubleDefH();
					mapped.set((IBusModelDoubleDefH)hrec);
					return(mapped); }
				case IBusModelDoubleType.CLASS_CODE: {
					BusModelJpaDoubleTypeH mapped = new BusModelJpaDoubleTypeH();
					mapped.set((IBusModelDoubleTypeH)hrec);
					return(mapped); }
				case IBusModelDoubleCol.CLASS_CODE: {
					BusModelJpaDoubleColH mapped = new BusModelJpaDoubleColH();
					mapped.set((IBusModelDoubleColH)hrec);
					return(mapped); }
				case IBusModelFloatDef.CLASS_CODE: {
					BusModelJpaFloatDefH mapped = new BusModelJpaFloatDefH();
					mapped.set((IBusModelFloatDefH)hrec);
					return(mapped); }
				case IBusModelFloatType.CLASS_CODE: {
					BusModelJpaFloatTypeH mapped = new BusModelJpaFloatTypeH();
					mapped.set((IBusModelFloatTypeH)hrec);
					return(mapped); }
				case IBusModelFloatCol.CLASS_CODE: {
					BusModelJpaFloatColH mapped = new BusModelJpaFloatColH();
					mapped.set((IBusModelFloatColH)hrec);
					return(mapped); }
				case IBusModelInt16Def.CLASS_CODE: {
					BusModelJpaInt16DefH mapped = new BusModelJpaInt16DefH();
					mapped.set((IBusModelInt16DefH)hrec);
					return(mapped); }
				case IBusModelInt16Type.CLASS_CODE: {
					BusModelJpaInt16TypeH mapped = new BusModelJpaInt16TypeH();
					mapped.set((IBusModelInt16TypeH)hrec);
					return(mapped); }
				case IBusModelId16Gen.CLASS_CODE: {
					BusModelJpaId16GenH mapped = new BusModelJpaId16GenH();
					mapped.set((IBusModelId16GenH)hrec);
					return(mapped); }
				case IBusModelEnumDef.CLASS_CODE: {
					BusModelJpaEnumDefH mapped = new BusModelJpaEnumDefH();
					mapped.set((IBusModelEnumDefH)hrec);
					return(mapped); }
				case IBusModelEnumType.CLASS_CODE: {
					BusModelJpaEnumTypeH mapped = new BusModelJpaEnumTypeH();
					mapped.set((IBusModelEnumTypeH)hrec);
					return(mapped); }
				case IBusModelInt16Col.CLASS_CODE: {
					BusModelJpaInt16ColH mapped = new BusModelJpaInt16ColH();
					mapped.set((IBusModelInt16ColH)hrec);
					return(mapped); }
				case IBusModelInt32Def.CLASS_CODE: {
					BusModelJpaInt32DefH mapped = new BusModelJpaInt32DefH();
					mapped.set((IBusModelInt32DefH)hrec);
					return(mapped); }
				case IBusModelInt32Type.CLASS_CODE: {
					BusModelJpaInt32TypeH mapped = new BusModelJpaInt32TypeH();
					mapped.set((IBusModelInt32TypeH)hrec);
					return(mapped); }
				case IBusModelId32Gen.CLASS_CODE: {
					BusModelJpaId32GenH mapped = new BusModelJpaId32GenH();
					mapped.set((IBusModelId32GenH)hrec);
					return(mapped); }
				case IBusModelInt32Col.CLASS_CODE: {
					BusModelJpaInt32ColH mapped = new BusModelJpaInt32ColH();
					mapped.set((IBusModelInt32ColH)hrec);
					return(mapped); }
				case IBusModelInt64Def.CLASS_CODE: {
					BusModelJpaInt64DefH mapped = new BusModelJpaInt64DefH();
					mapped.set((IBusModelInt64DefH)hrec);
					return(mapped); }
				case IBusModelInt64Type.CLASS_CODE: {
					BusModelJpaInt64TypeH mapped = new BusModelJpaInt64TypeH();
					mapped.set((IBusModelInt64TypeH)hrec);
					return(mapped); }
				case IBusModelId64Gen.CLASS_CODE: {
					BusModelJpaId64GenH mapped = new BusModelJpaId64GenH();
					mapped.set((IBusModelId64GenH)hrec);
					return(mapped); }
				case IBusModelInt64Col.CLASS_CODE: {
					BusModelJpaInt64ColH mapped = new BusModelJpaInt64ColH();
					mapped.set((IBusModelInt64ColH)hrec);
					return(mapped); }
				case IBusModelNmTokenDef.CLASS_CODE: {
					BusModelJpaNmTokenDefH mapped = new BusModelJpaNmTokenDefH();
					mapped.set((IBusModelNmTokenDefH)hrec);
					return(mapped); }
				case IBusModelNmTokenType.CLASS_CODE: {
					BusModelJpaNmTokenTypeH mapped = new BusModelJpaNmTokenTypeH();
					mapped.set((IBusModelNmTokenTypeH)hrec);
					return(mapped); }
				case IBusModelNmTokenCol.CLASS_CODE: {
					BusModelJpaNmTokenColH mapped = new BusModelJpaNmTokenColH();
					mapped.set((IBusModelNmTokenColH)hrec);
					return(mapped); }
				case IBusModelNmTokensDef.CLASS_CODE: {
					BusModelJpaNmTokensDefH mapped = new BusModelJpaNmTokensDefH();
					mapped.set((IBusModelNmTokensDefH)hrec);
					return(mapped); }
				case IBusModelNmTokensType.CLASS_CODE: {
					BusModelJpaNmTokensTypeH mapped = new BusModelJpaNmTokensTypeH();
					mapped.set((IBusModelNmTokensTypeH)hrec);
					return(mapped); }
				case IBusModelNmTokensCol.CLASS_CODE: {
					BusModelJpaNmTokensColH mapped = new BusModelJpaNmTokensColH();
					mapped.set((IBusModelNmTokensColH)hrec);
					return(mapped); }
				case IBusModelNumberDef.CLASS_CODE: {
					BusModelJpaNumberDefH mapped = new BusModelJpaNumberDefH();
					mapped.set((IBusModelNumberDefH)hrec);
					return(mapped); }
				case IBusModelNumberType.CLASS_CODE: {
					BusModelJpaNumberTypeH mapped = new BusModelJpaNumberTypeH();
					mapped.set((IBusModelNumberTypeH)hrec);
					return(mapped); }
				case IBusModelNumberCol.CLASS_CODE: {
					BusModelJpaNumberColH mapped = new BusModelJpaNumberColH();
					mapped.set((IBusModelNumberColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Def.CLASS_CODE: {
					BusModelJpaDbKeyHash128DefH mapped = new BusModelJpaDbKeyHash128DefH();
					mapped.set((IBusModelDbKeyHash128DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Col.CLASS_CODE: {
					BusModelJpaDbKeyHash128ColH mapped = new BusModelJpaDbKeyHash128ColH();
					mapped.set((IBusModelDbKeyHash128ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Type.CLASS_CODE: {
					BusModelJpaDbKeyHash128TypeH mapped = new BusModelJpaDbKeyHash128TypeH();
					mapped.set((IBusModelDbKeyHash128TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash128GenH mapped = new BusModelJpaDbKeyHash128GenH();
					mapped.set((IBusModelDbKeyHash128GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Def.CLASS_CODE: {
					BusModelJpaDbKeyHash160DefH mapped = new BusModelJpaDbKeyHash160DefH();
					mapped.set((IBusModelDbKeyHash160DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Col.CLASS_CODE: {
					BusModelJpaDbKeyHash160ColH mapped = new BusModelJpaDbKeyHash160ColH();
					mapped.set((IBusModelDbKeyHash160ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Type.CLASS_CODE: {
					BusModelJpaDbKeyHash160TypeH mapped = new BusModelJpaDbKeyHash160TypeH();
					mapped.set((IBusModelDbKeyHash160TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash160GenH mapped = new BusModelJpaDbKeyHash160GenH();
					mapped.set((IBusModelDbKeyHash160GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash224Def.CLASS_CODE: {
					BusModelJpaDbKeyHash224DefH mapped = new BusModelJpaDbKeyHash224DefH();
					mapped.set((IBusModelDbKeyHash224DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash224Col.CLASS_CODE: {
					BusModelJpaDbKeyHash224ColH mapped = new BusModelJpaDbKeyHash224ColH();
					mapped.set((IBusModelDbKeyHash224ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash224Type.CLASS_CODE: {
					BusModelJpaDbKeyHash224TypeH mapped = new BusModelJpaDbKeyHash224TypeH();
					mapped.set((IBusModelDbKeyHash224TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash224Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash224GenH mapped = new BusModelJpaDbKeyHash224GenH();
					mapped.set((IBusModelDbKeyHash224GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash256Def.CLASS_CODE: {
					BusModelJpaDbKeyHash256DefH mapped = new BusModelJpaDbKeyHash256DefH();
					mapped.set((IBusModelDbKeyHash256DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash256Col.CLASS_CODE: {
					BusModelJpaDbKeyHash256ColH mapped = new BusModelJpaDbKeyHash256ColH();
					mapped.set((IBusModelDbKeyHash256ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash256Type.CLASS_CODE: {
					BusModelJpaDbKeyHash256TypeH mapped = new BusModelJpaDbKeyHash256TypeH();
					mapped.set((IBusModelDbKeyHash256TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash256Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash256GenH mapped = new BusModelJpaDbKeyHash256GenH();
					mapped.set((IBusModelDbKeyHash256GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash384Def.CLASS_CODE: {
					BusModelJpaDbKeyHash384DefH mapped = new BusModelJpaDbKeyHash384DefH();
					mapped.set((IBusModelDbKeyHash384DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash384Col.CLASS_CODE: {
					BusModelJpaDbKeyHash384ColH mapped = new BusModelJpaDbKeyHash384ColH();
					mapped.set((IBusModelDbKeyHash384ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash384Type.CLASS_CODE: {
					BusModelJpaDbKeyHash384TypeH mapped = new BusModelJpaDbKeyHash384TypeH();
					mapped.set((IBusModelDbKeyHash384TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash384Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash384GenH mapped = new BusModelJpaDbKeyHash384GenH();
					mapped.set((IBusModelDbKeyHash384GenH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash512Def.CLASS_CODE: {
					BusModelJpaDbKeyHash512DefH mapped = new BusModelJpaDbKeyHash512DefH();
					mapped.set((IBusModelDbKeyHash512DefH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash512Col.CLASS_CODE: {
					BusModelJpaDbKeyHash512ColH mapped = new BusModelJpaDbKeyHash512ColH();
					mapped.set((IBusModelDbKeyHash512ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash512Type.CLASS_CODE: {
					BusModelJpaDbKeyHash512TypeH mapped = new BusModelJpaDbKeyHash512TypeH();
					mapped.set((IBusModelDbKeyHash512TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash512Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash512GenH mapped = new BusModelJpaDbKeyHash512GenH();
					mapped.set((IBusModelDbKeyHash512GenH)hrec);
					return(mapped); }
				case IBusModelStringDef.CLASS_CODE: {
					BusModelJpaStringDefH mapped = new BusModelJpaStringDefH();
					mapped.set((IBusModelStringDefH)hrec);
					return(mapped); }
				case IBusModelStringType.CLASS_CODE: {
					BusModelJpaStringTypeH mapped = new BusModelJpaStringTypeH();
					mapped.set((IBusModelStringTypeH)hrec);
					return(mapped); }
				case IBusModelStringCol.CLASS_CODE: {
					BusModelJpaStringColH mapped = new BusModelJpaStringColH();
					mapped.set((IBusModelStringColH)hrec);
					return(mapped); }
				case IBusModelTZDateDef.CLASS_CODE: {
					BusModelJpaTZDateDefH mapped = new BusModelJpaTZDateDefH();
					mapped.set((IBusModelTZDateDefH)hrec);
					return(mapped); }
				case IBusModelTZDateType.CLASS_CODE: {
					BusModelJpaTZDateTypeH mapped = new BusModelJpaTZDateTypeH();
					mapped.set((IBusModelTZDateTypeH)hrec);
					return(mapped); }
				case IBusModelTZDateCol.CLASS_CODE: {
					BusModelJpaTZDateColH mapped = new BusModelJpaTZDateColH();
					mapped.set((IBusModelTZDateColH)hrec);
					return(mapped); }
				case IBusModelTZTimeDef.CLASS_CODE: {
					BusModelJpaTZTimeDefH mapped = new BusModelJpaTZTimeDefH();
					mapped.set((IBusModelTZTimeDefH)hrec);
					return(mapped); }
				case IBusModelTZTimeType.CLASS_CODE: {
					BusModelJpaTZTimeTypeH mapped = new BusModelJpaTZTimeTypeH();
					mapped.set((IBusModelTZTimeTypeH)hrec);
					return(mapped); }
				case IBusModelTZTimeCol.CLASS_CODE: {
					BusModelJpaTZTimeColH mapped = new BusModelJpaTZTimeColH();
					mapped.set((IBusModelTZTimeColH)hrec);
					return(mapped); }
				case IBusModelTZTimestampDef.CLASS_CODE: {
					BusModelJpaTZTimestampDefH mapped = new BusModelJpaTZTimestampDefH();
					mapped.set((IBusModelTZTimestampDefH)hrec);
					return(mapped); }
				case IBusModelTZTimestampType.CLASS_CODE: {
					BusModelJpaTZTimestampTypeH mapped = new BusModelJpaTZTimestampTypeH();
					mapped.set((IBusModelTZTimestampTypeH)hrec);
					return(mapped); }
				case IBusModelTZTimestampCol.CLASS_CODE: {
					BusModelJpaTZTimestampColH mapped = new BusModelJpaTZTimestampColH();
					mapped.set((IBusModelTZTimestampColH)hrec);
					return(mapped); }
				case IBusModelTextDef.CLASS_CODE: {
					BusModelJpaTextDefH mapped = new BusModelJpaTextDefH();
					mapped.set((IBusModelTextDefH)hrec);
					return(mapped); }
				case IBusModelTextType.CLASS_CODE: {
					BusModelJpaTextTypeH mapped = new BusModelJpaTextTypeH();
					mapped.set((IBusModelTextTypeH)hrec);
					return(mapped); }
				case IBusModelTextCol.CLASS_CODE: {
					BusModelJpaTextColH mapped = new BusModelJpaTextColH();
					mapped.set((IBusModelTextColH)hrec);
					return(mapped); }
				case IBusModelTimeDef.CLASS_CODE: {
					BusModelJpaTimeDefH mapped = new BusModelJpaTimeDefH();
					mapped.set((IBusModelTimeDefH)hrec);
					return(mapped); }
				case IBusModelTimeType.CLASS_CODE: {
					BusModelJpaTimeTypeH mapped = new BusModelJpaTimeTypeH();
					mapped.set((IBusModelTimeTypeH)hrec);
					return(mapped); }
				case IBusModelTimeCol.CLASS_CODE: {
					BusModelJpaTimeColH mapped = new BusModelJpaTimeColH();
					mapped.set((IBusModelTimeColH)hrec);
					return(mapped); }
				case IBusModelTimestampDef.CLASS_CODE: {
					BusModelJpaTimestampDefH mapped = new BusModelJpaTimestampDefH();
					mapped.set((IBusModelTimestampDefH)hrec);
					return(mapped); }
				case IBusModelTimestampType.CLASS_CODE: {
					BusModelJpaTimestampTypeH mapped = new BusModelJpaTimestampTypeH();
					mapped.set((IBusModelTimestampTypeH)hrec);
					return(mapped); }
				case IBusModelTimestampCol.CLASS_CODE: {
					BusModelJpaTimestampColH mapped = new BusModelJpaTimestampColH();
					mapped.set((IBusModelTimestampColH)hrec);
					return(mapped); }
				case IBusModelTokenDef.CLASS_CODE: {
					BusModelJpaTokenDefH mapped = new BusModelJpaTokenDefH();
					mapped.set((IBusModelTokenDefH)hrec);
					return(mapped); }
				case IBusModelTokenType.CLASS_CODE: {
					BusModelJpaTokenTypeH mapped = new BusModelJpaTokenTypeH();
					mapped.set((IBusModelTokenTypeH)hrec);
					return(mapped); }
				case IBusModelTokenCol.CLASS_CODE: {
					BusModelJpaTokenColH mapped = new BusModelJpaTokenColH();
					mapped.set((IBusModelTokenColH)hrec);
					return(mapped); }
				case IBusModelUInt16Def.CLASS_CODE: {
					BusModelJpaUInt16DefH mapped = new BusModelJpaUInt16DefH();
					mapped.set((IBusModelUInt16DefH)hrec);
					return(mapped); }
				case IBusModelUInt16Type.CLASS_CODE: {
					BusModelJpaUInt16TypeH mapped = new BusModelJpaUInt16TypeH();
					mapped.set((IBusModelUInt16TypeH)hrec);
					return(mapped); }
				case IBusModelUInt16Col.CLASS_CODE: {
					BusModelJpaUInt16ColH mapped = new BusModelJpaUInt16ColH();
					mapped.set((IBusModelUInt16ColH)hrec);
					return(mapped); }
				case IBusModelUInt32Def.CLASS_CODE: {
					BusModelJpaUInt32DefH mapped = new BusModelJpaUInt32DefH();
					mapped.set((IBusModelUInt32DefH)hrec);
					return(mapped); }
				case IBusModelUInt32Type.CLASS_CODE: {
					BusModelJpaUInt32TypeH mapped = new BusModelJpaUInt32TypeH();
					mapped.set((IBusModelUInt32TypeH)hrec);
					return(mapped); }
				case IBusModelUInt32Col.CLASS_CODE: {
					BusModelJpaUInt32ColH mapped = new BusModelJpaUInt32ColH();
					mapped.set((IBusModelUInt32ColH)hrec);
					return(mapped); }
				case IBusModelUInt64Def.CLASS_CODE: {
					BusModelJpaUInt64DefH mapped = new BusModelJpaUInt64DefH();
					mapped.set((IBusModelUInt64DefH)hrec);
					return(mapped); }
				case IBusModelUInt64Type.CLASS_CODE: {
					BusModelJpaUInt64TypeH mapped = new BusModelJpaUInt64TypeH();
					mapped.set((IBusModelUInt64TypeH)hrec);
					return(mapped); }
				case IBusModelUInt64Col.CLASS_CODE: {
					BusModelJpaUInt64ColH mapped = new BusModelJpaUInt64ColH();
					mapped.set((IBusModelUInt64ColH)hrec);
					return(mapped); }
				case IBusModelUuidDef.CLASS_CODE: {
					BusModelJpaUuidDefH mapped = new BusModelJpaUuidDefH();
					mapped.set((IBusModelUuidDefH)hrec);
					return(mapped); }
				case IBusModelUuidType.CLASS_CODE: {
					BusModelJpaUuidTypeH mapped = new BusModelJpaUuidTypeH();
					mapped.set((IBusModelUuidTypeH)hrec);
					return(mapped); }
				case IBusModelUuidGen.CLASS_CODE: {
					BusModelJpaUuidGenH mapped = new BusModelJpaUuidGenH();
					mapped.set((IBusModelUuidGenH)hrec);
					return(mapped); }
				case IBusModelUuidCol.CLASS_CODE: {
					BusModelJpaUuidColH mapped = new BusModelJpaUuidColH();
					mapped.set((IBusModelUuidColH)hrec);
					return(mapped); }
				case IBusModelUuid6Def.CLASS_CODE: {
					BusModelJpaUuid6DefH mapped = new BusModelJpaUuid6DefH();
					mapped.set((IBusModelUuid6DefH)hrec);
					return(mapped); }
				case IBusModelUuid6Type.CLASS_CODE: {
					BusModelJpaUuid6TypeH mapped = new BusModelJpaUuid6TypeH();
					mapped.set((IBusModelUuid6TypeH)hrec);
					return(mapped); }
				case IBusModelUuid6Gen.CLASS_CODE: {
					BusModelJpaUuid6GenH mapped = new BusModelJpaUuid6GenH();
					mapped.set((IBusModelUuid6GenH)hrec);
					return(mapped); }
				case IBusModelUuid6Col.CLASS_CODE: {
					BusModelJpaUuid6ColH mapped = new BusModelJpaUuid6ColH();
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
