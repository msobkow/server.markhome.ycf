
// Description: Java 25 in-memory RAM DbIO implementation for Atom.

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

package server.markhome.ycf.v3_1.busmodel.busmodelram;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.buff.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

/*
 *	BusModelRamAtomTable in-memory RAM DbIO implementation
 *	for Atom.
 */
public class BusModelRamAtomTable
	implements IBusModelAtomTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffAtom > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffAtom >();

	public BusModelRamAtomTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffValue ensureRec(IBusModelValue rec) {
		if (rec == null) {
			return( null );
		}
		else {
			return (((BusModelBuffValueFactoryService)(schema.getBusModelBuffFactory().getFactoryValue())).ensureRec(rec));
		}
	}

	@Override
	public IBusModelAtom createAtom( ISecureAuthorization Authorization,
		IBusModelAtom iBuff )
	{
		final String S_ProcName = "createAtom";
		
		BusModelBuffAtom Buff = (BusModelBuffAtom)(schema.getTableValue().createValue( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"Value",
						"Value",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelAtom.CLASS_CODE) {
				BusModelBuffAtom retbuff = ((BusModelBuffAtom)(schema.getBusModelBuffFactory().getFactoryAtom().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelBlobDef.CLASS_CODE) {
				BusModelBuffBlobDef retbuff = ((BusModelBuffBlobDef)(schema.getBusModelBuffFactory().getFactoryBlobDef().newRec()));
				retbuff.set((IBusModelBlobDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelBlobType.CLASS_CODE) {
				BusModelBuffBlobType retbuff = ((BusModelBuffBlobType)(schema.getBusModelBuffFactory().getFactoryBlobType().newRec()));
				retbuff.set((IBusModelBlobType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelBlobCol.CLASS_CODE) {
				BusModelBuffBlobCol retbuff = ((BusModelBuffBlobCol)(schema.getBusModelBuffFactory().getFactoryBlobCol().newRec()));
				retbuff.set((IBusModelBlobCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelBoolDef.CLASS_CODE) {
				BusModelBuffBoolDef retbuff = ((BusModelBuffBoolDef)(schema.getBusModelBuffFactory().getFactoryBoolDef().newRec()));
				retbuff.set((IBusModelBoolDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelBoolType.CLASS_CODE) {
				BusModelBuffBoolType retbuff = ((BusModelBuffBoolType)(schema.getBusModelBuffFactory().getFactoryBoolType().newRec()));
				retbuff.set((IBusModelBoolType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelBoolCol.CLASS_CODE) {
				BusModelBuffBoolCol retbuff = ((BusModelBuffBoolCol)(schema.getBusModelBuffFactory().getFactoryBoolCol().newRec()));
				retbuff.set((IBusModelBoolCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDateDef.CLASS_CODE) {
				BusModelBuffDateDef retbuff = ((BusModelBuffDateDef)(schema.getBusModelBuffFactory().getFactoryDateDef().newRec()));
				retbuff.set((IBusModelDateDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDateType.CLASS_CODE) {
				BusModelBuffDateType retbuff = ((BusModelBuffDateType)(schema.getBusModelBuffFactory().getFactoryDateType().newRec()));
				retbuff.set((IBusModelDateType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDateCol.CLASS_CODE) {
				BusModelBuffDateCol retbuff = ((BusModelBuffDateCol)(schema.getBusModelBuffFactory().getFactoryDateCol().newRec()));
				retbuff.set((IBusModelDateCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDoubleDef.CLASS_CODE) {
				BusModelBuffDoubleDef retbuff = ((BusModelBuffDoubleDef)(schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec()));
				retbuff.set((IBusModelDoubleDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDoubleType.CLASS_CODE) {
				BusModelBuffDoubleType retbuff = ((BusModelBuffDoubleType)(schema.getBusModelBuffFactory().getFactoryDoubleType().newRec()));
				retbuff.set((IBusModelDoubleType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDoubleCol.CLASS_CODE) {
				BusModelBuffDoubleCol retbuff = ((BusModelBuffDoubleCol)(schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec()));
				retbuff.set((IBusModelDoubleCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelFloatDef.CLASS_CODE) {
				BusModelBuffFloatDef retbuff = ((BusModelBuffFloatDef)(schema.getBusModelBuffFactory().getFactoryFloatDef().newRec()));
				retbuff.set((IBusModelFloatDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelFloatType.CLASS_CODE) {
				BusModelBuffFloatType retbuff = ((BusModelBuffFloatType)(schema.getBusModelBuffFactory().getFactoryFloatType().newRec()));
				retbuff.set((IBusModelFloatType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelFloatCol.CLASS_CODE) {
				BusModelBuffFloatCol retbuff = ((BusModelBuffFloatCol)(schema.getBusModelBuffFactory().getFactoryFloatCol().newRec()));
				retbuff.set((IBusModelFloatCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelInt16Def.CLASS_CODE) {
				BusModelBuffInt16Def retbuff = ((BusModelBuffInt16Def)(schema.getBusModelBuffFactory().getFactoryInt16Def().newRec()));
				retbuff.set((IBusModelInt16Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelInt16Type.CLASS_CODE) {
				BusModelBuffInt16Type retbuff = ((BusModelBuffInt16Type)(schema.getBusModelBuffFactory().getFactoryInt16Type().newRec()));
				retbuff.set((IBusModelInt16Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelId16Gen.CLASS_CODE) {
				BusModelBuffId16Gen retbuff = ((BusModelBuffId16Gen)(schema.getBusModelBuffFactory().getFactoryId16Gen().newRec()));
				retbuff.set((IBusModelId16Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelEnumDef.CLASS_CODE) {
				BusModelBuffEnumDef retbuff = ((BusModelBuffEnumDef)(schema.getBusModelBuffFactory().getFactoryEnumDef().newRec()));
				retbuff.set((IBusModelEnumDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelEnumType.CLASS_CODE) {
				BusModelBuffEnumType retbuff = ((BusModelBuffEnumType)(schema.getBusModelBuffFactory().getFactoryEnumType().newRec()));
				retbuff.set((IBusModelEnumType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelInt16Col.CLASS_CODE) {
				BusModelBuffInt16Col retbuff = ((BusModelBuffInt16Col)(schema.getBusModelBuffFactory().getFactoryInt16Col().newRec()));
				retbuff.set((IBusModelInt16Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelInt32Def.CLASS_CODE) {
				BusModelBuffInt32Def retbuff = ((BusModelBuffInt32Def)(schema.getBusModelBuffFactory().getFactoryInt32Def().newRec()));
				retbuff.set((IBusModelInt32Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelInt32Type.CLASS_CODE) {
				BusModelBuffInt32Type retbuff = ((BusModelBuffInt32Type)(schema.getBusModelBuffFactory().getFactoryInt32Type().newRec()));
				retbuff.set((IBusModelInt32Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelId32Gen.CLASS_CODE) {
				BusModelBuffId32Gen retbuff = ((BusModelBuffId32Gen)(schema.getBusModelBuffFactory().getFactoryId32Gen().newRec()));
				retbuff.set((IBusModelId32Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelInt32Col.CLASS_CODE) {
				BusModelBuffInt32Col retbuff = ((BusModelBuffInt32Col)(schema.getBusModelBuffFactory().getFactoryInt32Col().newRec()));
				retbuff.set((IBusModelInt32Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelInt64Def.CLASS_CODE) {
				BusModelBuffInt64Def retbuff = ((BusModelBuffInt64Def)(schema.getBusModelBuffFactory().getFactoryInt64Def().newRec()));
				retbuff.set((IBusModelInt64Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelInt64Type.CLASS_CODE) {
				BusModelBuffInt64Type retbuff = ((BusModelBuffInt64Type)(schema.getBusModelBuffFactory().getFactoryInt64Type().newRec()));
				retbuff.set((IBusModelInt64Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelId64Gen.CLASS_CODE) {
				BusModelBuffId64Gen retbuff = ((BusModelBuffId64Gen)(schema.getBusModelBuffFactory().getFactoryId64Gen().newRec()));
				retbuff.set((IBusModelId64Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelInt64Col.CLASS_CODE) {
				BusModelBuffInt64Col retbuff = ((BusModelBuffInt64Col)(schema.getBusModelBuffFactory().getFactoryInt64Col().newRec()));
				retbuff.set((IBusModelInt64Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelNmTokenDef.CLASS_CODE) {
				BusModelBuffNmTokenDef retbuff = ((BusModelBuffNmTokenDef)(schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec()));
				retbuff.set((IBusModelNmTokenDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelNmTokenType.CLASS_CODE) {
				BusModelBuffNmTokenType retbuff = ((BusModelBuffNmTokenType)(schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec()));
				retbuff.set((IBusModelNmTokenType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelNmTokenCol.CLASS_CODE) {
				BusModelBuffNmTokenCol retbuff = ((BusModelBuffNmTokenCol)(schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec()));
				retbuff.set((IBusModelNmTokenCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelNmTokensDef.CLASS_CODE) {
				BusModelBuffNmTokensDef retbuff = ((BusModelBuffNmTokensDef)(schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec()));
				retbuff.set((IBusModelNmTokensDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelNmTokensType.CLASS_CODE) {
				BusModelBuffNmTokensType retbuff = ((BusModelBuffNmTokensType)(schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec()));
				retbuff.set((IBusModelNmTokensType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelNmTokensCol.CLASS_CODE) {
				BusModelBuffNmTokensCol retbuff = ((BusModelBuffNmTokensCol)(schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec()));
				retbuff.set((IBusModelNmTokensCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelNumberDef.CLASS_CODE) {
				BusModelBuffNumberDef retbuff = ((BusModelBuffNumberDef)(schema.getBusModelBuffFactory().getFactoryNumberDef().newRec()));
				retbuff.set((IBusModelNumberDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelNumberType.CLASS_CODE) {
				BusModelBuffNumberType retbuff = ((BusModelBuffNumberType)(schema.getBusModelBuffFactory().getFactoryNumberType().newRec()));
				retbuff.set((IBusModelNumberType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelNumberCol.CLASS_CODE) {
				BusModelBuffNumberCol retbuff = ((BusModelBuffNumberCol)(schema.getBusModelBuffFactory().getFactoryNumberCol().newRec()));
				retbuff.set((IBusModelNumberCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash128Def.CLASS_CODE) {
				BusModelBuffDbKeyHash128Def retbuff = ((BusModelBuffDbKeyHash128Def)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec()));
				retbuff.set((IBusModelDbKeyHash128Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash128Col.CLASS_CODE) {
				BusModelBuffDbKeyHash128Col retbuff = ((BusModelBuffDbKeyHash128Col)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec()));
				retbuff.set((IBusModelDbKeyHash128Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash128Type.CLASS_CODE) {
				BusModelBuffDbKeyHash128Type retbuff = ((BusModelBuffDbKeyHash128Type)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec()));
				retbuff.set((IBusModelDbKeyHash128Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash128Gen.CLASS_CODE) {
				BusModelBuffDbKeyHash128Gen retbuff = ((BusModelBuffDbKeyHash128Gen)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec()));
				retbuff.set((IBusModelDbKeyHash128Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash160Def.CLASS_CODE) {
				BusModelBuffDbKeyHash160Def retbuff = ((BusModelBuffDbKeyHash160Def)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec()));
				retbuff.set((IBusModelDbKeyHash160Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash160Col.CLASS_CODE) {
				BusModelBuffDbKeyHash160Col retbuff = ((BusModelBuffDbKeyHash160Col)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec()));
				retbuff.set((IBusModelDbKeyHash160Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash160Type.CLASS_CODE) {
				BusModelBuffDbKeyHash160Type retbuff = ((BusModelBuffDbKeyHash160Type)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec()));
				retbuff.set((IBusModelDbKeyHash160Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash160Gen.CLASS_CODE) {
				BusModelBuffDbKeyHash160Gen retbuff = ((BusModelBuffDbKeyHash160Gen)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec()));
				retbuff.set((IBusModelDbKeyHash160Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash224Def.CLASS_CODE) {
				BusModelBuffDbKeyHash224Def retbuff = ((BusModelBuffDbKeyHash224Def)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec()));
				retbuff.set((IBusModelDbKeyHash224Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash224Col.CLASS_CODE) {
				BusModelBuffDbKeyHash224Col retbuff = ((BusModelBuffDbKeyHash224Col)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec()));
				retbuff.set((IBusModelDbKeyHash224Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash224Type.CLASS_CODE) {
				BusModelBuffDbKeyHash224Type retbuff = ((BusModelBuffDbKeyHash224Type)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec()));
				retbuff.set((IBusModelDbKeyHash224Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash224Gen.CLASS_CODE) {
				BusModelBuffDbKeyHash224Gen retbuff = ((BusModelBuffDbKeyHash224Gen)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec()));
				retbuff.set((IBusModelDbKeyHash224Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash256Def.CLASS_CODE) {
				BusModelBuffDbKeyHash256Def retbuff = ((BusModelBuffDbKeyHash256Def)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec()));
				retbuff.set((IBusModelDbKeyHash256Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash256Col.CLASS_CODE) {
				BusModelBuffDbKeyHash256Col retbuff = ((BusModelBuffDbKeyHash256Col)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec()));
				retbuff.set((IBusModelDbKeyHash256Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash256Type.CLASS_CODE) {
				BusModelBuffDbKeyHash256Type retbuff = ((BusModelBuffDbKeyHash256Type)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec()));
				retbuff.set((IBusModelDbKeyHash256Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash256Gen.CLASS_CODE) {
				BusModelBuffDbKeyHash256Gen retbuff = ((BusModelBuffDbKeyHash256Gen)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec()));
				retbuff.set((IBusModelDbKeyHash256Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash384Def.CLASS_CODE) {
				BusModelBuffDbKeyHash384Def retbuff = ((BusModelBuffDbKeyHash384Def)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec()));
				retbuff.set((IBusModelDbKeyHash384Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash384Col.CLASS_CODE) {
				BusModelBuffDbKeyHash384Col retbuff = ((BusModelBuffDbKeyHash384Col)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec()));
				retbuff.set((IBusModelDbKeyHash384Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash384Type.CLASS_CODE) {
				BusModelBuffDbKeyHash384Type retbuff = ((BusModelBuffDbKeyHash384Type)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec()));
				retbuff.set((IBusModelDbKeyHash384Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash384Gen.CLASS_CODE) {
				BusModelBuffDbKeyHash384Gen retbuff = ((BusModelBuffDbKeyHash384Gen)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec()));
				retbuff.set((IBusModelDbKeyHash384Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash512Def.CLASS_CODE) {
				BusModelBuffDbKeyHash512Def retbuff = ((BusModelBuffDbKeyHash512Def)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec()));
				retbuff.set((IBusModelDbKeyHash512Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash512Col.CLASS_CODE) {
				BusModelBuffDbKeyHash512Col retbuff = ((BusModelBuffDbKeyHash512Col)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec()));
				retbuff.set((IBusModelDbKeyHash512Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash512Type.CLASS_CODE) {
				BusModelBuffDbKeyHash512Type retbuff = ((BusModelBuffDbKeyHash512Type)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec()));
				retbuff.set((IBusModelDbKeyHash512Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash512Gen.CLASS_CODE) {
				BusModelBuffDbKeyHash512Gen retbuff = ((BusModelBuffDbKeyHash512Gen)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec()));
				retbuff.set((IBusModelDbKeyHash512Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelStringDef.CLASS_CODE) {
				BusModelBuffStringDef retbuff = ((BusModelBuffStringDef)(schema.getBusModelBuffFactory().getFactoryStringDef().newRec()));
				retbuff.set((IBusModelStringDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelStringType.CLASS_CODE) {
				BusModelBuffStringType retbuff = ((BusModelBuffStringType)(schema.getBusModelBuffFactory().getFactoryStringType().newRec()));
				retbuff.set((IBusModelStringType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelStringCol.CLASS_CODE) {
				BusModelBuffStringCol retbuff = ((BusModelBuffStringCol)(schema.getBusModelBuffFactory().getFactoryStringCol().newRec()));
				retbuff.set((IBusModelStringCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTZDateDef.CLASS_CODE) {
				BusModelBuffTZDateDef retbuff = ((BusModelBuffTZDateDef)(schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec()));
				retbuff.set((IBusModelTZDateDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTZDateType.CLASS_CODE) {
				BusModelBuffTZDateType retbuff = ((BusModelBuffTZDateType)(schema.getBusModelBuffFactory().getFactoryTZDateType().newRec()));
				retbuff.set((IBusModelTZDateType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTZDateCol.CLASS_CODE) {
				BusModelBuffTZDateCol retbuff = ((BusModelBuffTZDateCol)(schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec()));
				retbuff.set((IBusModelTZDateCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTZTimeDef.CLASS_CODE) {
				BusModelBuffTZTimeDef retbuff = ((BusModelBuffTZTimeDef)(schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec()));
				retbuff.set((IBusModelTZTimeDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTZTimeType.CLASS_CODE) {
				BusModelBuffTZTimeType retbuff = ((BusModelBuffTZTimeType)(schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec()));
				retbuff.set((IBusModelTZTimeType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTZTimeCol.CLASS_CODE) {
				BusModelBuffTZTimeCol retbuff = ((BusModelBuffTZTimeCol)(schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec()));
				retbuff.set((IBusModelTZTimeCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTZTimestampDef.CLASS_CODE) {
				BusModelBuffTZTimestampDef retbuff = ((BusModelBuffTZTimestampDef)(schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec()));
				retbuff.set((IBusModelTZTimestampDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTZTimestampType.CLASS_CODE) {
				BusModelBuffTZTimestampType retbuff = ((BusModelBuffTZTimestampType)(schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec()));
				retbuff.set((IBusModelTZTimestampType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTZTimestampCol.CLASS_CODE) {
				BusModelBuffTZTimestampCol retbuff = ((BusModelBuffTZTimestampCol)(schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec()));
				retbuff.set((IBusModelTZTimestampCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTextDef.CLASS_CODE) {
				BusModelBuffTextDef retbuff = ((BusModelBuffTextDef)(schema.getBusModelBuffFactory().getFactoryTextDef().newRec()));
				retbuff.set((IBusModelTextDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTextType.CLASS_CODE) {
				BusModelBuffTextType retbuff = ((BusModelBuffTextType)(schema.getBusModelBuffFactory().getFactoryTextType().newRec()));
				retbuff.set((IBusModelTextType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTextCol.CLASS_CODE) {
				BusModelBuffTextCol retbuff = ((BusModelBuffTextCol)(schema.getBusModelBuffFactory().getFactoryTextCol().newRec()));
				retbuff.set((IBusModelTextCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTimeDef.CLASS_CODE) {
				BusModelBuffTimeDef retbuff = ((BusModelBuffTimeDef)(schema.getBusModelBuffFactory().getFactoryTimeDef().newRec()));
				retbuff.set((IBusModelTimeDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTimeType.CLASS_CODE) {
				BusModelBuffTimeType retbuff = ((BusModelBuffTimeType)(schema.getBusModelBuffFactory().getFactoryTimeType().newRec()));
				retbuff.set((IBusModelTimeType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTimeCol.CLASS_CODE) {
				BusModelBuffTimeCol retbuff = ((BusModelBuffTimeCol)(schema.getBusModelBuffFactory().getFactoryTimeCol().newRec()));
				retbuff.set((IBusModelTimeCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTimestampDef.CLASS_CODE) {
				BusModelBuffTimestampDef retbuff = ((BusModelBuffTimestampDef)(schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec()));
				retbuff.set((IBusModelTimestampDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTimestampType.CLASS_CODE) {
				BusModelBuffTimestampType retbuff = ((BusModelBuffTimestampType)(schema.getBusModelBuffFactory().getFactoryTimestampType().newRec()));
				retbuff.set((IBusModelTimestampType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTimestampCol.CLASS_CODE) {
				BusModelBuffTimestampCol retbuff = ((BusModelBuffTimestampCol)(schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec()));
				retbuff.set((IBusModelTimestampCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTokenDef.CLASS_CODE) {
				BusModelBuffTokenDef retbuff = ((BusModelBuffTokenDef)(schema.getBusModelBuffFactory().getFactoryTokenDef().newRec()));
				retbuff.set((IBusModelTokenDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTokenType.CLASS_CODE) {
				BusModelBuffTokenType retbuff = ((BusModelBuffTokenType)(schema.getBusModelBuffFactory().getFactoryTokenType().newRec()));
				retbuff.set((IBusModelTokenType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTokenCol.CLASS_CODE) {
				BusModelBuffTokenCol retbuff = ((BusModelBuffTokenCol)(schema.getBusModelBuffFactory().getFactoryTokenCol().newRec()));
				retbuff.set((IBusModelTokenCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUInt16Def.CLASS_CODE) {
				BusModelBuffUInt16Def retbuff = ((BusModelBuffUInt16Def)(schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec()));
				retbuff.set((IBusModelUInt16Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUInt16Type.CLASS_CODE) {
				BusModelBuffUInt16Type retbuff = ((BusModelBuffUInt16Type)(schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec()));
				retbuff.set((IBusModelUInt16Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUInt16Col.CLASS_CODE) {
				BusModelBuffUInt16Col retbuff = ((BusModelBuffUInt16Col)(schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec()));
				retbuff.set((IBusModelUInt16Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUInt32Def.CLASS_CODE) {
				BusModelBuffUInt32Def retbuff = ((BusModelBuffUInt32Def)(schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec()));
				retbuff.set((IBusModelUInt32Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUInt32Type.CLASS_CODE) {
				BusModelBuffUInt32Type retbuff = ((BusModelBuffUInt32Type)(schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec()));
				retbuff.set((IBusModelUInt32Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUInt32Col.CLASS_CODE) {
				BusModelBuffUInt32Col retbuff = ((BusModelBuffUInt32Col)(schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec()));
				retbuff.set((IBusModelUInt32Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUInt64Def.CLASS_CODE) {
				BusModelBuffUInt64Def retbuff = ((BusModelBuffUInt64Def)(schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec()));
				retbuff.set((IBusModelUInt64Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUInt64Type.CLASS_CODE) {
				BusModelBuffUInt64Type retbuff = ((BusModelBuffUInt64Type)(schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec()));
				retbuff.set((IBusModelUInt64Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUInt64Col.CLASS_CODE) {
				BusModelBuffUInt64Col retbuff = ((BusModelBuffUInt64Col)(schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec()));
				retbuff.set((IBusModelUInt64Col)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUuidDef.CLASS_CODE) {
				BusModelBuffUuidDef retbuff = ((BusModelBuffUuidDef)(schema.getBusModelBuffFactory().getFactoryUuidDef().newRec()));
				retbuff.set((IBusModelUuidDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUuidType.CLASS_CODE) {
				BusModelBuffUuidType retbuff = ((BusModelBuffUuidType)(schema.getBusModelBuffFactory().getFactoryUuidType().newRec()));
				retbuff.set((IBusModelUuidType)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUuidGen.CLASS_CODE) {
				BusModelBuffUuidGen retbuff = ((BusModelBuffUuidGen)(schema.getBusModelBuffFactory().getFactoryUuidGen().newRec()));
				retbuff.set((IBusModelUuidGen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUuidCol.CLASS_CODE) {
				BusModelBuffUuidCol retbuff = ((BusModelBuffUuidCol)(schema.getBusModelBuffFactory().getFactoryUuidCol().newRec()));
				retbuff.set((IBusModelUuidCol)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUuid6Def.CLASS_CODE) {
				BusModelBuffUuid6Def retbuff = ((BusModelBuffUuid6Def)(schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec()));
				retbuff.set((IBusModelUuid6Def)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUuid6Type.CLASS_CODE) {
				BusModelBuffUuid6Type retbuff = ((BusModelBuffUuid6Type)(schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec()));
				retbuff.set((IBusModelUuid6Type)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUuid6Gen.CLASS_CODE) {
				BusModelBuffUuid6Gen retbuff = ((BusModelBuffUuid6Gen)(schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec()));
				retbuff.set((IBusModelUuid6Gen)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelUuid6Col.CLASS_CODE) {
				BusModelBuffUuid6Col retbuff = ((BusModelBuffUuid6Col)(schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec()));
				retbuff.set((IBusModelUuid6Col)Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelAtom readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamAtom.readDerived";
		IBusModelAtom buff;
		if( PKey == null ) {
			return( null );
		}
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelAtom lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamAtom.lockDerived";
		IBusModelAtom buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelAtom[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamAtom.readAllDerived";
		IBusModelAtom[] retList = new IBusModelAtom[ dictByPKey.values().size() ];
		Iterator< BusModelBuffAtom > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelAtom readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamValue.readDerivedByUNameIdx";
		IBusModelValue buff = schema.getTableValue().readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof IBusModelAtom ) {
			return( (IBusModelAtom)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelAtom[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamValue.readDerivedByScopeIdx";
		IBusModelValue buffList[] = schema.getTableValue().readDerivedByScopeIdx( Authorization,
			ScopeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelValue buff;
			ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelAtom ) ) {
					filteredList.add( (IBusModelAtom)buff );
				}
			}
			return( filteredList.toArray( new IBusModelAtom[0] ) );
		}
	}

	@Override
	public IBusModelAtom[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamValue.readDerivedByDefSchemaIdx";
		IBusModelValue buffList[] = schema.getTableValue().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelValue buff;
			ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelAtom ) ) {
					filteredList.add( (IBusModelAtom)buff );
				}
			}
			return( filteredList.toArray( new IBusModelAtom[0] ) );
		}
	}

	@Override
	public IBusModelAtom[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamValue.readDerivedByPrevIdx";
		IBusModelValue buffList[] = schema.getTableValue().readDerivedByPrevIdx( Authorization,
			PrevId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelValue buff;
			ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelAtom ) ) {
					filteredList.add( (IBusModelAtom)buff );
				}
			}
			return( filteredList.toArray( new IBusModelAtom[0] ) );
		}
	}

	@Override
	public IBusModelAtom[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamValue.readDerivedByNextIdx";
		IBusModelValue buffList[] = schema.getTableValue().readDerivedByNextIdx( Authorization,
			NextId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelValue buff;
			ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelAtom ) ) {
					filteredList.add( (IBusModelAtom)buff );
				}
			}
			return( filteredList.toArray( new IBusModelAtom[0] ) );
		}
	}

	@Override
	public IBusModelAtom[] readDerivedByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamValue.readDerivedByContPrevIdx";
		IBusModelValue buffList[] = schema.getTableValue().readDerivedByContPrevIdx( Authorization,
			ScopeId,
			PrevId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelValue buff;
			ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelAtom ) ) {
					filteredList.add( (IBusModelAtom)buff );
				}
			}
			return( filteredList.toArray( new IBusModelAtom[0] ) );
		}
	}

	@Override
	public IBusModelAtom[] readDerivedByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamValue.readDerivedByContNextIdx";
		IBusModelValue buffList[] = schema.getTableValue().readDerivedByContNextIdx( Authorization,
			ScopeId,
			NextId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelValue buff;
			ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelAtom ) ) {
					filteredList.add( (IBusModelAtom)buff );
				}
			}
			return( filteredList.toArray( new IBusModelAtom[0] ) );
		}
	}

	@Override
	public IBusModelAtom readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamValue.readDerivedByIdIdx() ";
		IBusModelAtom buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelAtom readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamAtom.readRec";
		IBusModelAtom buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelAtom.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelAtom lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelAtom buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelAtom.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelAtom[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamAtom.readAllRec";
		IBusModelAtom buff;
		ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
		IBusModelAtom[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelAtom.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelAtom[0] ) );
	}

	@Override
	public IBusModelAtom readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamValue.readRecByIdIdx() ";
		IBusModelAtom buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
			return( (IBusModelAtom)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelAtom readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamValue.readRecByUNameIdx() ";
		IBusModelAtom buff = readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
			return( (IBusModelAtom)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelAtom[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByScopeIdx() ";
		IBusModelAtom buff;
		ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
		IBusModelAtom[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelAtom)buff );
			}
		}
		return( filteredList.toArray( new IBusModelAtom[0] ) );
	}

	@Override
	public IBusModelAtom[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByDefSchemaIdx() ";
		IBusModelAtom buff;
		ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
		IBusModelAtom[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelAtom)buff );
			}
		}
		return( filteredList.toArray( new IBusModelAtom[0] ) );
	}

	@Override
	public IBusModelAtom[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByPrevIdx() ";
		IBusModelAtom buff;
		ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
		IBusModelAtom[] buffList = readDerivedByPrevIdx( Authorization,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelAtom)buff );
			}
		}
		return( filteredList.toArray( new IBusModelAtom[0] ) );
	}

	@Override
	public IBusModelAtom[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByNextIdx() ";
		IBusModelAtom buff;
		ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
		IBusModelAtom[] buffList = readDerivedByNextIdx( Authorization,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelAtom)buff );
			}
		}
		return( filteredList.toArray( new IBusModelAtom[0] ) );
	}

	@Override
	public IBusModelAtom[] readRecByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByContPrevIdx() ";
		IBusModelAtom buff;
		ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
		IBusModelAtom[] buffList = readDerivedByContPrevIdx( Authorization,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelAtom)buff );
			}
		}
		return( filteredList.toArray( new IBusModelAtom[0] ) );
	}

	@Override
	public IBusModelAtom[] readRecByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByContNextIdx() ";
		IBusModelAtom buff;
		ArrayList<IBusModelAtom> filteredList = new ArrayList<IBusModelAtom>();
		IBusModelAtom[] buffList = readDerivedByContNextIdx( Authorization,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelAtom)buff );
			}
		}
		return( filteredList.toArray( new IBusModelAtom[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelAtom moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecUp";

		IBusModelValue grandprev = null;
		IBusModelValue prev = null;
		IBusModelValue cur = null;
		IBusModelValue next = null;

		cur = schema.getTableValue().readDerivedByIdIdx(Authorization, Id);
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalPrevId() == null ) )
		{
			return( (BusModelBuffAtom)cur );
		}

		prev = (BusModelBuffValue)(schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
		if( prev == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = (BusModelBuffValue)(schema.getTableValue().readDerivedByIdIdx(Authorization, prev.getOptionalPrevId() ));
			if( grandprev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextId() != null ) )
		{
			next = (BusModelBuffValue)(schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
			if( next == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
			}
		}

		int classCode = prev.getClassCode();
		IBusModelValue newInstance;
			if( classCode == IBusModelValue.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryValue().newRec();
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryAtom().newRec();
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobDef().newRec();
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobType().newRec();
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobCol().newRec();
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolDef().newRec();
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolType().newRec();
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolCol().newRec();
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateDef().newRec();
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateType().newRec();
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateCol().newRec();
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec();
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleType().newRec();
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec();
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatDef().newRec();
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatType().newRec();
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatCol().newRec();
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Def().newRec();
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Type().newRec();
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId16Gen().newRec();
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumDef().newRec();
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumType().newRec();
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Col().newRec();
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Def().newRec();
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Type().newRec();
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId32Gen().newRec();
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Col().newRec();
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Def().newRec();
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Type().newRec();
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId64Gen().newRec();
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Col().newRec();
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec();
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec();
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec();
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec();
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec();
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec();
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberDef().newRec();
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberType().newRec();
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberCol().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec();
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringDef().newRec();
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringType().newRec();
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringCol().newRec();
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec();
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateType().newRec();
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec();
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec();
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec();
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec();
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec();
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec();
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec();
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextDef().newRec();
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextType().newRec();
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextCol().newRec();
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeDef().newRec();
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeType().newRec();
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeCol().newRec();
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec();
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampType().newRec();
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec();
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenDef().newRec();
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenType().newRec();
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenCol().newRec();
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec();
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec();
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec();
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec();
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec();
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec();
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec();
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec();
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec();
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidDef().newRec();
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidType().newRec();
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidGen().newRec();
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidCol().newRec();
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec();
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec();
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec();
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec();
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTableCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffValue editPrev = (BusModelBuffValue)newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryValue().newRec();
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryAtom().newRec();
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobDef().newRec();
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobType().newRec();
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobCol().newRec();
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolDef().newRec();
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolType().newRec();
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolCol().newRec();
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateDef().newRec();
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateType().newRec();
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateCol().newRec();
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec();
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleType().newRec();
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec();
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatDef().newRec();
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatType().newRec();
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatCol().newRec();
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Def().newRec();
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Type().newRec();
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId16Gen().newRec();
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumDef().newRec();
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumType().newRec();
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Col().newRec();
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Def().newRec();
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Type().newRec();
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId32Gen().newRec();
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Col().newRec();
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Def().newRec();
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Type().newRec();
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId64Gen().newRec();
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Col().newRec();
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec();
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec();
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec();
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec();
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec();
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec();
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberDef().newRec();
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberType().newRec();
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberCol().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec();
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringDef().newRec();
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringType().newRec();
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringCol().newRec();
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec();
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateType().newRec();
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec();
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec();
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec();
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec();
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec();
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec();
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec();
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextDef().newRec();
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextType().newRec();
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextCol().newRec();
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeDef().newRec();
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeType().newRec();
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeCol().newRec();
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec();
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampType().newRec();
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec();
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenDef().newRec();
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenType().newRec();
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenCol().newRec();
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec();
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec();
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec();
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec();
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec();
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec();
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec();
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec();
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec();
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidDef().newRec();
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidType().newRec();
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidGen().newRec();
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidCol().newRec();
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec();
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec();
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec();
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec();
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTableCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffValue editCur = (BusModelBuffValue)newInstance;
		editCur.set( cur );

		BusModelBuffValue editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryValue().newRec();
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryAtom().newRec();
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobDef().newRec();
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobType().newRec();
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobCol().newRec();
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolDef().newRec();
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolType().newRec();
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolCol().newRec();
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateDef().newRec();
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateType().newRec();
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateCol().newRec();
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec();
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleType().newRec();
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec();
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatDef().newRec();
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatType().newRec();
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatCol().newRec();
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Def().newRec();
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Type().newRec();
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId16Gen().newRec();
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumDef().newRec();
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumType().newRec();
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Col().newRec();
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Def().newRec();
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Type().newRec();
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId32Gen().newRec();
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Col().newRec();
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Def().newRec();
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Type().newRec();
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId64Gen().newRec();
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Col().newRec();
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec();
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec();
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec();
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec();
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec();
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec();
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberDef().newRec();
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberType().newRec();
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberCol().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec();
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringDef().newRec();
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringType().newRec();
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringCol().newRec();
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec();
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateType().newRec();
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec();
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec();
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec();
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec();
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec();
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec();
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec();
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextDef().newRec();
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextType().newRec();
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextCol().newRec();
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeDef().newRec();
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeType().newRec();
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeCol().newRec();
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec();
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampType().newRec();
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec();
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenDef().newRec();
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenType().newRec();
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenCol().newRec();
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec();
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec();
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec();
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec();
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec();
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec();
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec();
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec();
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec();
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidDef().newRec();
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidType().newRec();
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidGen().newRec();
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidCol().newRec();
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec();
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec();
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec();
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec();
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTableCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandprev = (BusModelBuffValue)newInstance;
			editGrandprev.set( grandprev );
		}

		BusModelBuffValue editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryValue().newRec();
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryAtom().newRec();
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobDef().newRec();
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobType().newRec();
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobCol().newRec();
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolDef().newRec();
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolType().newRec();
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolCol().newRec();
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateDef().newRec();
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateType().newRec();
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateCol().newRec();
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec();
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleType().newRec();
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec();
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatDef().newRec();
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatType().newRec();
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatCol().newRec();
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Def().newRec();
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Type().newRec();
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId16Gen().newRec();
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumDef().newRec();
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumType().newRec();
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Col().newRec();
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Def().newRec();
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Type().newRec();
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId32Gen().newRec();
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Col().newRec();
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Def().newRec();
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Type().newRec();
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId64Gen().newRec();
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Col().newRec();
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec();
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec();
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec();
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec();
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec();
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec();
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberDef().newRec();
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberType().newRec();
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberCol().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec();
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringDef().newRec();
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringType().newRec();
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringCol().newRec();
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec();
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateType().newRec();
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec();
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec();
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec();
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec();
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec();
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec();
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec();
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextDef().newRec();
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextType().newRec();
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextCol().newRec();
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeDef().newRec();
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeType().newRec();
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeCol().newRec();
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec();
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampType().newRec();
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec();
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenDef().newRec();
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenType().newRec();
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenCol().newRec();
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec();
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec();
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec();
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec();
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec();
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec();
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec();
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec();
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec();
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidDef().newRec();
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidType().newRec();
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidGen().newRec();
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidCol().newRec();
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec();
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec();
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec();
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec();
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTableCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext = (BusModelBuffValue)newInstance;
			editNext.set( next );
		}

		if( editGrandprev != null ) {
			editGrandprev.setOptionalLookupNext(cur.getRequiredId());
			editCur.setOptionalLookupPrev(grandprev.getRequiredId());
		}
		else {
			editCur.setOptionalLookupPrev((IYCFKeyHash256)null);
		}

			editPrev.setOptionalLookupPrev(cur.getRequiredId());

			editCur.setOptionalLookupNext(prev.getRequiredId());

		if( next != null ) {
			editPrev.setOptionalLookupNext(next.getRequiredId());
			editNext.setOptionalLookupPrev(prev.getRequiredId());
		}
		else {
			editPrev.setOptionalLookupNext((IYCFKeyHash256)null);
		}

		if( editGrandprev != null ) {
			classCode = editGrandprev.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editGrandprev );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editGrandprev );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editGrandprev );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editGrandprev );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editGrandprev );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editGrandprev );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editGrandprev );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editGrandprev );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editGrandprev );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editGrandprev );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editGrandprev );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editGrandprev );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editGrandprev );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editGrandprev );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editGrandprev );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editGrandprev );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editGrandprev );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editGrandprev );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editGrandprev );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editGrandprev );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editGrandprev );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editGrandprev );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editGrandprev );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editGrandprev );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editGrandprev );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editGrandprev );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editGrandprev );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editGrandprev );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editGrandprev );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editGrandprev );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editGrandprev );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editGrandprev );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editGrandprev );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editGrandprev );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editGrandprev );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editGrandprev );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editGrandprev );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editGrandprev );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editGrandprev );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editGrandprev );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editGrandprev );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editGrandprev );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editGrandprev );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editGrandprev );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editGrandprev );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editGrandprev );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editGrandprev );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editGrandprev );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editGrandprev );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editGrandprev );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editGrandprev );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editGrandprev );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editGrandprev );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editGrandprev );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editGrandprev );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editGrandprev );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editGrandprev );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editGrandprev );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editGrandprev );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editGrandprev );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editGrandprev );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editGrandprev );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editGrandprev );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editGrandprev );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editGrandprev );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editGrandprev );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editGrandprev );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editGrandprev );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editGrandprev );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editGrandprev );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editGrandprev );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editGrandprev );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editGrandprev );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editGrandprev );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editGrandprev );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editGrandprev );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editGrandprev );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editGrandprev );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editGrandprev );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editGrandprev );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editGrandprev );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editGrandprev );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editGrandprev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editPrev );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editPrev );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editPrev );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editPrev );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editPrev );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editPrev );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editPrev );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editPrev );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editPrev );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editPrev );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editPrev );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editPrev );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editPrev );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editPrev );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editPrev );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editPrev );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editPrev );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editPrev );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editPrev );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editPrev );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editPrev );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editPrev );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editPrev );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editPrev );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editPrev );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editPrev );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editPrev );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editPrev );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editPrev );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editPrev );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editPrev );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editPrev );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editPrev );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editPrev );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editPrev );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editPrev );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editPrev );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editPrev );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editPrev );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editPrev );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editPrev );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editPrev );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editPrev );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editPrev );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editPrev );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editPrev );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editPrev );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editPrev );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editPrev );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editPrev );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editPrev );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editPrev );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editPrev );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editPrev );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editPrev );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editPrev );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editPrev );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editPrev );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editPrev );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editPrev );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editPrev );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editPrev );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editPrev );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editPrev );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editPrev );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editPrev );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editPrev );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editPrev );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editPrev );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editPrev );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editPrev );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editPrev );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editPrev );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editPrev );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editPrev );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editPrev );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editPrev );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editPrev );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editPrev );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editPrev );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editPrev );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editCur );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editCur );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editCur );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editCur );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editCur );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editCur );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editCur );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editCur );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editCur );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editCur );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editCur );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editCur );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editCur );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editCur );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editCur );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editCur );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editCur );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editCur );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editCur );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editCur );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editCur );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editCur );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editCur );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editCur );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editCur );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editCur );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editCur );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editCur );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editCur );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editCur );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editCur );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editCur );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editCur );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editCur );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editCur );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editCur );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editCur );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editCur );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editCur );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editCur );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editCur );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editCur );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editCur );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editCur );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editCur );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editCur );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editCur );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editCur );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editCur );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editCur );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editCur );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editCur );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editCur );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editCur );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editCur );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editCur );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editCur );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editCur );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editCur );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editCur );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editCur );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editCur );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editCur );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editCur );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editCur );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editCur );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editCur );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editCur );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editCur );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editCur );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editCur );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editCur );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editCur );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editCur );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editCur );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editCur );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editCur );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editCur );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editCur );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editCur );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editCur );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editCur );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editNext );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editNext );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editNext );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editNext );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editNext );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editNext );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editNext );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editNext );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editNext );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editNext );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editNext );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editNext );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editNext );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editNext );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editNext );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editNext );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editNext );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editNext );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editNext );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editNext );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editNext );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editNext );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editNext );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editNext );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editNext );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editNext );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editNext );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editNext );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editNext );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editNext );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editNext );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editNext );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editNext );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editNext );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editNext );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editNext );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editNext );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editNext );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editNext );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editNext );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editNext );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editNext );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editNext );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editNext );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editNext );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editNext );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editNext );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editNext );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editNext );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editNext );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editNext );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editNext );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editNext );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editNext );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editNext );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editNext );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editNext );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editNext );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editNext );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editNext );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editNext );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editNext );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editNext );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editNext );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editNext );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editNext );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editNext );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editNext );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editNext );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editNext );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editNext );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editNext );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editNext );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editNext );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editNext );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editNext );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editNext );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editNext );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editNext );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editNext );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editNext );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffAtom)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelAtom moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecDown";

		BusModelBuffValue prev = null;
		BusModelBuffValue cur = null;
		BusModelBuffValue next = null;
		BusModelBuffValue grandnext = null;

		cur = (BusModelBuffValue)(schema.getTableValue().readDerivedByIdIdx(Authorization, Id));
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalNextId() == null ) )
		{
			return( (BusModelBuffAtom)cur );
		}

		next = (BusModelBuffValue)(schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
		if( next == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
		}

		if( ( next.getOptionalNextId() != null ) )
		{
			grandnext = (BusModelBuffValue)(schema.getTableValue().readDerivedByIdIdx(Authorization, next.getOptionalNextId() ));
			if( grandnext == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevId() != null ) )
		{
			prev = (BusModelBuffValue)(schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
			if( prev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
			}
		}

		int classCode = cur.getClassCode();
		IBusModelValue newInstance;
			if( classCode == IBusModelValue.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryValue().newRec();
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryAtom().newRec();
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobDef().newRec();
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobType().newRec();
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobCol().newRec();
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolDef().newRec();
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolType().newRec();
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolCol().newRec();
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateDef().newRec();
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateType().newRec();
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateCol().newRec();
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec();
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleType().newRec();
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec();
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatDef().newRec();
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatType().newRec();
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatCol().newRec();
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Def().newRec();
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Type().newRec();
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId16Gen().newRec();
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumDef().newRec();
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumType().newRec();
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Col().newRec();
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Def().newRec();
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Type().newRec();
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId32Gen().newRec();
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Col().newRec();
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Def().newRec();
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Type().newRec();
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId64Gen().newRec();
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Col().newRec();
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec();
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec();
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec();
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec();
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec();
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec();
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberDef().newRec();
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberType().newRec();
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberCol().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec();
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringDef().newRec();
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringType().newRec();
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringCol().newRec();
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec();
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateType().newRec();
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec();
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec();
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec();
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec();
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec();
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec();
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec();
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextDef().newRec();
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextType().newRec();
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextCol().newRec();
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeDef().newRec();
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeType().newRec();
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeCol().newRec();
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec();
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampType().newRec();
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec();
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenDef().newRec();
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenType().newRec();
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenCol().newRec();
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec();
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec();
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec();
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec();
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec();
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec();
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec();
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec();
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec();
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidDef().newRec();
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidType().newRec();
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidGen().newRec();
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidCol().newRec();
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec();
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec();
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec();
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec();
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTableCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffValue editCur = (BusModelBuffValue)newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryValue().newRec();
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryAtom().newRec();
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobDef().newRec();
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobType().newRec();
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobCol().newRec();
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolDef().newRec();
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolType().newRec();
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolCol().newRec();
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateDef().newRec();
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateType().newRec();
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateCol().newRec();
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec();
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleType().newRec();
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec();
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatDef().newRec();
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatType().newRec();
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatCol().newRec();
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Def().newRec();
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Type().newRec();
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId16Gen().newRec();
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumDef().newRec();
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumType().newRec();
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Col().newRec();
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Def().newRec();
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Type().newRec();
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId32Gen().newRec();
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Col().newRec();
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Def().newRec();
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Type().newRec();
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId64Gen().newRec();
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Col().newRec();
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec();
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec();
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec();
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec();
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec();
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec();
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberDef().newRec();
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberType().newRec();
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberCol().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec();
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringDef().newRec();
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringType().newRec();
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringCol().newRec();
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec();
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateType().newRec();
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec();
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec();
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec();
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec();
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec();
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec();
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec();
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextDef().newRec();
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextType().newRec();
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextCol().newRec();
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeDef().newRec();
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeType().newRec();
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeCol().newRec();
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec();
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampType().newRec();
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec();
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenDef().newRec();
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenType().newRec();
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenCol().newRec();
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec();
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec();
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec();
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec();
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec();
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec();
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec();
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec();
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec();
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidDef().newRec();
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidType().newRec();
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidGen().newRec();
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidCol().newRec();
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec();
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec();
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec();
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec();
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTableCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffValue editNext = (BusModelBuffValue)newInstance;
		editNext.set( next );

		BusModelBuffValue editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryValue().newRec();
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryAtom().newRec();
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobDef().newRec();
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobType().newRec();
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobCol().newRec();
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolDef().newRec();
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolType().newRec();
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolCol().newRec();
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateDef().newRec();
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateType().newRec();
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateCol().newRec();
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec();
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleType().newRec();
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec();
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatDef().newRec();
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatType().newRec();
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatCol().newRec();
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Def().newRec();
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Type().newRec();
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId16Gen().newRec();
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumDef().newRec();
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumType().newRec();
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Col().newRec();
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Def().newRec();
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Type().newRec();
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId32Gen().newRec();
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Col().newRec();
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Def().newRec();
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Type().newRec();
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId64Gen().newRec();
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Col().newRec();
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec();
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec();
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec();
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec();
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec();
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec();
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberDef().newRec();
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberType().newRec();
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberCol().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec();
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringDef().newRec();
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringType().newRec();
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringCol().newRec();
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec();
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateType().newRec();
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec();
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec();
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec();
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec();
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec();
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec();
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec();
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextDef().newRec();
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextType().newRec();
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextCol().newRec();
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeDef().newRec();
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeType().newRec();
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeCol().newRec();
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec();
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampType().newRec();
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec();
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenDef().newRec();
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenType().newRec();
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenCol().newRec();
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec();
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec();
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec();
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec();
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec();
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec();
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec();
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec();
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec();
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidDef().newRec();
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidType().newRec();
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidGen().newRec();
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidCol().newRec();
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec();
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec();
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec();
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec();
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTableCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandnext = (BusModelBuffValue)newInstance;
			editGrandnext.set( grandnext );
		}

		BusModelBuffValue editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryValue().newRec();
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryAtom().newRec();
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobDef().newRec();
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobType().newRec();
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBlobCol().newRec();
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolDef().newRec();
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolType().newRec();
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryBoolCol().newRec();
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateDef().newRec();
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateType().newRec();
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDateCol().newRec();
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec();
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleType().newRec();
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec();
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatDef().newRec();
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatType().newRec();
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryFloatCol().newRec();
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Def().newRec();
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Type().newRec();
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId16Gen().newRec();
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumDef().newRec();
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumType().newRec();
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt16Col().newRec();
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Def().newRec();
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Type().newRec();
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId32Gen().newRec();
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt32Col().newRec();
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Def().newRec();
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Type().newRec();
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryId64Gen().newRec();
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryInt64Col().newRec();
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec();
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec();
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec();
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec();
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec();
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec();
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberDef().newRec();
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberType().newRec();
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryNumberCol().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec();
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec();
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringDef().newRec();
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringType().newRec();
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryStringCol().newRec();
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec();
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateType().newRec();
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec();
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec();
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec();
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec();
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec();
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec();
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec();
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextDef().newRec();
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextType().newRec();
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTextCol().newRec();
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeDef().newRec();
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeType().newRec();
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimeCol().newRec();
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec();
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampType().newRec();
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec();
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenDef().newRec();
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenType().newRec();
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTokenCol().newRec();
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec();
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec();
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec();
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec();
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec();
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec();
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec();
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec();
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec();
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidDef().newRec();
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidType().newRec();
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidGen().newRec();
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuidCol().newRec();
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec();
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec();
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec();
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec();
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryTableCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev = (BusModelBuffValue)newInstance;
			editPrev.set( prev );
		}

		if( prev != null ) {
			editPrev.setOptionalLookupNext(next.getRequiredId());
			editNext.setOptionalLookupPrev(prev.getRequiredId());
		}
		else {
			editNext.setOptionalLookupPrev((IYCFKeyHash256)null);
		}

			editCur.setOptionalLookupPrev(next.getRequiredId());

			editNext.setOptionalLookupNext(cur.getRequiredId());

		if( editGrandnext != null ) {
			editCur.setOptionalLookupNext(grandnext.getRequiredId());
			editGrandnext.setOptionalLookupPrev(cur.getRequiredId());
		}
		else {
			editCur.setOptionalLookupNext((IYCFKeyHash256)null);
		}

		if( editPrev != null ) {
			classCode = editPrev.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editPrev );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editPrev );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editPrev );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editPrev );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editPrev );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editPrev );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editPrev );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editPrev );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editPrev );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editPrev );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editPrev );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editPrev );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editPrev );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editPrev );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editPrev );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editPrev );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editPrev );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editPrev );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editPrev );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editPrev );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editPrev );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editPrev );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editPrev );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editPrev );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editPrev );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editPrev );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editPrev );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editPrev );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editPrev );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editPrev );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editPrev );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editPrev );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editPrev );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editPrev );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editPrev );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editPrev );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editPrev );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editPrev );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editPrev );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editPrev );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editPrev );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editPrev );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editPrev );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editPrev );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editPrev );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editPrev );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editPrev );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editPrev );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editPrev );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editPrev );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editPrev );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editPrev );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editPrev );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editPrev );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editPrev );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editPrev );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editPrev );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editPrev );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editPrev );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editPrev );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editPrev );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editPrev );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editPrev );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editPrev );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editPrev );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editPrev );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editPrev );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editPrev );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editPrev );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editPrev );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editPrev );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editPrev );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editPrev );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editPrev );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editPrev );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editPrev );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editPrev );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editPrev );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editPrev );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editPrev );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editPrev );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editCur );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editCur );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editCur );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editCur );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editCur );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editCur );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editCur );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editCur );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editCur );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editCur );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editCur );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editCur );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editCur );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editCur );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editCur );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editCur );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editCur );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editCur );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editCur );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editCur );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editCur );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editCur );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editCur );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editCur );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editCur );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editCur );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editCur );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editCur );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editCur );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editCur );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editCur );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editCur );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editCur );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editCur );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editCur );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editCur );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editCur );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editCur );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editCur );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editCur );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editCur );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editCur );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editCur );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editCur );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editCur );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editCur );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editCur );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editCur );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editCur );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editCur );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editCur );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editCur );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editCur );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editCur );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editCur );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editCur );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editCur );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editCur );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editCur );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editCur );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editCur );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editCur );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editCur );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editCur );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editCur );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editCur );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editCur );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editCur );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editCur );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editCur );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editCur );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editCur );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editCur );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editCur );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editCur );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editCur );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editCur );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editCur );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editCur );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editCur );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editCur );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editCur );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editCur );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editCur );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editCur );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editCur );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editNext.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editNext );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editNext );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editNext );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editNext );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editNext );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editNext );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editNext );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editNext );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editNext );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editNext );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editNext );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editNext );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editNext );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editNext );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editNext );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editNext );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editNext );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editNext );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editNext );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editNext );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editNext );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editNext );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editNext );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editNext );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editNext );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editNext );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editNext );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editNext );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editNext );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editNext );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editNext );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editNext );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editNext );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editNext );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editNext );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editNext );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editNext );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editNext );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editNext );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editNext );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editNext );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editNext );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editNext );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editNext );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editNext );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editNext );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editNext );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editNext );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editNext );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editNext );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editNext );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editNext );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editNext );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editNext );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editNext );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editNext );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editNext );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editNext );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editNext );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editNext );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editNext );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editNext );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editNext );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editNext );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editNext );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editNext );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editNext );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editNext );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editNext );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editNext );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editNext );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editNext );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editNext );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editNext );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editNext );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editNext );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editNext );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editNext );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editNext );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editNext );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editNext );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editGrandnext );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editGrandnext );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editGrandnext );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editGrandnext );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editGrandnext );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editGrandnext );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editGrandnext );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editGrandnext );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editGrandnext );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editGrandnext );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editGrandnext );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editGrandnext );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editGrandnext );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editGrandnext );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editGrandnext );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editGrandnext );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editGrandnext );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editGrandnext );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editGrandnext );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editGrandnext );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editGrandnext );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editGrandnext );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editGrandnext );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editGrandnext );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editGrandnext );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editGrandnext );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editGrandnext );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editGrandnext );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editGrandnext );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editGrandnext );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editGrandnext );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editGrandnext );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editGrandnext );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editGrandnext );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editGrandnext );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editGrandnext );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editGrandnext );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editGrandnext );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editGrandnext );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editGrandnext );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editGrandnext );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editGrandnext );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editGrandnext );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editGrandnext );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editGrandnext );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editGrandnext );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editGrandnext );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editGrandnext );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editGrandnext );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editGrandnext );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editGrandnext );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editGrandnext );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editGrandnext );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editGrandnext );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editGrandnext );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editGrandnext );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editGrandnext );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editGrandnext );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editGrandnext );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editGrandnext );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editGrandnext );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editGrandnext );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editGrandnext );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editGrandnext );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editGrandnext );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editGrandnext );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editGrandnext );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editGrandnext );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editGrandnext );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editGrandnext );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editGrandnext );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editGrandnext );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editGrandnext );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editGrandnext );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editGrandnext );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editGrandnext );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editGrandnext );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editGrandnext );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editGrandnext );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editGrandnext );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editGrandnext );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editGrandnext );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editGrandnext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffAtom)editCur );
	}

	public IBusModelAtom updateAtom( ISecureAuthorization Authorization,
		IBusModelAtom iBuff )
	{
		BusModelBuffAtom Buff = (BusModelBuffAtom)(schema.getTableValue().updateValue( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffAtom existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateAtom",
				"Existing record not found",
				"Existing record not found",
				"Atom",
				"Atom",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateAtom",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"Value",
						"Value",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffAtom > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteAtom( ISecureAuthorization Authorization,
		IBusModelAtom iBuff )
	{
		final String S_ProcName = "BusModelRamAtomTable.deleteAtom() ";
		BusModelBuffAtom Buff = (BusModelBuffAtom)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffAtom existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteAtom",
				pkey );
		}
		IYCFKeyHash256 varScopeId = existing.getRequiredScopeId();
		BusModelBuffScope container = (BusModelBuffScope)(schema.getTableScope().readDerivedByIdIdx( Authorization,
			varScopeId ));
		if( container == null ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				0,
				"container" );
		}

		IYCFKeyHash256 prevId = existing.getOptionalPrevId();
		IYCFKeyHash256 nextId = existing.getOptionalNextId();

		BusModelBuffValue prev = null;
		if( ( prevId != null ) )
		{
			prev = (BusModelBuffValue)(schema.getTableValue().readDerivedByIdIdx( Authorization,
				prevId ));
			if( prev == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			BusModelBuffValue editPrev;
			classCode = prev.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryValue().newRec());
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryAtom().newRec());
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBlobDef().newRec());
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBlobType().newRec());
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBlobCol().newRec());
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBoolDef().newRec());
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBoolType().newRec());
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBoolCol().newRec());
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDateDef().newRec());
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDateType().newRec());
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDateCol().newRec());
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec());
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDoubleType().newRec());
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec());
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryFloatDef().newRec());
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryFloatType().newRec());
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryFloatCol().newRec());
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt16Def().newRec());
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt16Type().newRec());
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryId16Gen().newRec());
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryEnumDef().newRec());
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryEnumType().newRec());
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt16Col().newRec());
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt32Def().newRec());
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt32Type().newRec());
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryId32Gen().newRec());
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt32Col().newRec());
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt64Def().newRec());
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt64Type().newRec());
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryId64Gen().newRec());
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt64Col().newRec());
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec());
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec());
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec());
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec());
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec());
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec());
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNumberDef().newRec());
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNumberType().newRec());
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNumberCol().newRec());
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec());
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryStringDef().newRec());
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryStringType().newRec());
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryStringCol().newRec());
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec());
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZDateType().newRec());
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec());
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec());
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec());
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec());
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec());
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec());
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec());
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTextDef().newRec());
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTextType().newRec());
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTextCol().newRec());
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimeDef().newRec());
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimeType().newRec());
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimeCol().newRec());
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec());
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimestampType().newRec());
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec());
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTokenDef().newRec());
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTokenType().newRec());
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTokenCol().newRec());
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec());
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec());
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec());
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec());
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec());
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec());
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec());
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec());
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec());
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuidDef().newRec());
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuidType().newRec());
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuidGen().newRec());
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuidCol().newRec());
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec());
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec());
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec());
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec());
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				editPrev = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTableCol().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev.set( prev );
			editPrev.setOptionalLookupNext(nextId);
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editPrev );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editPrev );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editPrev );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editPrev );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editPrev );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editPrev );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editPrev );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editPrev );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editPrev );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editPrev );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editPrev );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editPrev );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editPrev );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editPrev );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editPrev );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editPrev );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editPrev );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editPrev );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editPrev );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editPrev );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editPrev );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editPrev );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editPrev );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editPrev );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editPrev );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editPrev );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editPrev );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editPrev );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editPrev );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editPrev );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editPrev );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editPrev );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editPrev );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editPrev );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editPrev );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editPrev );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editPrev );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editPrev );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editPrev );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editPrev );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editPrev );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editPrev );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editPrev );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editPrev );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editPrev );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editPrev );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editPrev );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editPrev );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editPrev );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editPrev );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editPrev );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editPrev );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editPrev );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editPrev );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editPrev );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editPrev );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editPrev );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editPrev );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editPrev );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editPrev );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editPrev );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editPrev );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editPrev );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editPrev );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editPrev );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editPrev );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editPrev );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editPrev );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editPrev );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editPrev );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editPrev );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editPrev );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editPrev );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editPrev );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editPrev );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editPrev );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editPrev );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editPrev );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editPrev );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editPrev );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editPrev );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editPrev );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffValue next = null;
		if( ( nextId != null ) )
		{
			next = (BusModelBuffValue)(schema.getTableValue().readDerivedByIdIdx( Authorization,
				nextId ));
			if( next == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			BusModelBuffValue editNext;
			classCode = next.getClassCode();
			if( classCode == IBusModelValue.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryValue().newRec());
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryAtom().newRec());
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBlobDef().newRec());
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBlobType().newRec());
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBlobCol().newRec());
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBoolDef().newRec());
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBoolType().newRec());
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryBoolCol().newRec());
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDateDef().newRec());
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDateType().newRec());
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDateCol().newRec());
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec());
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDoubleType().newRec());
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec());
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryFloatDef().newRec());
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryFloatType().newRec());
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryFloatCol().newRec());
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt16Def().newRec());
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt16Type().newRec());
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryId16Gen().newRec());
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryEnumDef().newRec());
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryEnumType().newRec());
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt16Col().newRec());
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt32Def().newRec());
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt32Type().newRec());
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryId32Gen().newRec());
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt32Col().newRec());
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt64Def().newRec());
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt64Type().newRec());
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryId64Gen().newRec());
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryInt64Col().newRec());
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec());
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec());
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec());
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec());
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec());
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec());
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNumberDef().newRec());
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNumberType().newRec());
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryNumberCol().newRec());
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec());
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec());
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec());
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec());
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec());
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryStringDef().newRec());
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryStringType().newRec());
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryStringCol().newRec());
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec());
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZDateType().newRec());
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec());
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec());
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec());
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec());
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec());
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec());
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec());
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTextDef().newRec());
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTextType().newRec());
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTextCol().newRec());
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimeDef().newRec());
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimeType().newRec());
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimeCol().newRec());
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec());
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimestampType().newRec());
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec());
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTokenDef().newRec());
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTokenType().newRec());
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTokenCol().newRec());
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec());
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec());
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec());
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec());
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec());
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec());
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec());
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec());
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec());
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuidDef().newRec());
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuidType().newRec());
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuidGen().newRec());
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuidCol().newRec());
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec());
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec());
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec());
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec());
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				editNext = (BusModelBuffValue)(schema.getBusModelBuffFactory().getFactoryTableCol().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext.set( next );
			editNext.setOptionalLookupPrev(prevId);
			if( classCode == IBusModelValue.CLASS_CODE ) {
				schema.getTableValue().updateValue( Authorization, editNext );
			}
			else if( classCode == IBusModelAtom.CLASS_CODE ) {
				schema.getTableAtom().updateAtom( Authorization, (BusModelBuffAtom)editNext );
			}
			else if( classCode == IBusModelBlobDef.CLASS_CODE ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (BusModelBuffBlobDef)editNext );
			}
			else if( classCode == IBusModelBlobType.CLASS_CODE ) {
				schema.getTableBlobType().updateBlobType( Authorization, (BusModelBuffBlobType)editNext );
			}
			else if( classCode == IBusModelBlobCol.CLASS_CODE ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (BusModelBuffBlobCol)editNext );
			}
			else if( classCode == IBusModelBoolDef.CLASS_CODE ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (BusModelBuffBoolDef)editNext );
			}
			else if( classCode == IBusModelBoolType.CLASS_CODE ) {
				schema.getTableBoolType().updateBoolType( Authorization, (BusModelBuffBoolType)editNext );
			}
			else if( classCode == IBusModelBoolCol.CLASS_CODE ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (BusModelBuffBoolCol)editNext );
			}
			else if( classCode == IBusModelDateDef.CLASS_CODE ) {
				schema.getTableDateDef().updateDateDef( Authorization, (BusModelBuffDateDef)editNext );
			}
			else if( classCode == IBusModelDateType.CLASS_CODE ) {
				schema.getTableDateType().updateDateType( Authorization, (BusModelBuffDateType)editNext );
			}
			else if( classCode == IBusModelDateCol.CLASS_CODE ) {
				schema.getTableDateCol().updateDateCol( Authorization, (BusModelBuffDateCol)editNext );
			}
			else if( classCode == IBusModelDoubleDef.CLASS_CODE ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (BusModelBuffDoubleDef)editNext );
			}
			else if( classCode == IBusModelDoubleType.CLASS_CODE ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (BusModelBuffDoubleType)editNext );
			}
			else if( classCode == IBusModelDoubleCol.CLASS_CODE ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (BusModelBuffDoubleCol)editNext );
			}
			else if( classCode == IBusModelFloatDef.CLASS_CODE ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (BusModelBuffFloatDef)editNext );
			}
			else if( classCode == IBusModelFloatType.CLASS_CODE ) {
				schema.getTableFloatType().updateFloatType( Authorization, (BusModelBuffFloatType)editNext );
			}
			else if( classCode == IBusModelFloatCol.CLASS_CODE ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (BusModelBuffFloatCol)editNext );
			}
			else if( classCode == IBusModelInt16Def.CLASS_CODE ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (BusModelBuffInt16Def)editNext );
			}
			else if( classCode == IBusModelInt16Type.CLASS_CODE ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (BusModelBuffInt16Type)editNext );
			}
			else if( classCode == IBusModelId16Gen.CLASS_CODE ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (BusModelBuffId16Gen)editNext );
			}
			else if( classCode == IBusModelEnumDef.CLASS_CODE ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (BusModelBuffEnumDef)editNext );
			}
			else if( classCode == IBusModelEnumType.CLASS_CODE ) {
				schema.getTableEnumType().updateEnumType( Authorization, (BusModelBuffEnumType)editNext );
			}
			else if( classCode == IBusModelInt16Col.CLASS_CODE ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (BusModelBuffInt16Col)editNext );
			}
			else if( classCode == IBusModelInt32Def.CLASS_CODE ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (BusModelBuffInt32Def)editNext );
			}
			else if( classCode == IBusModelInt32Type.CLASS_CODE ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (BusModelBuffInt32Type)editNext );
			}
			else if( classCode == IBusModelId32Gen.CLASS_CODE ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (BusModelBuffId32Gen)editNext );
			}
			else if( classCode == IBusModelInt32Col.CLASS_CODE ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (BusModelBuffInt32Col)editNext );
			}
			else if( classCode == IBusModelInt64Def.CLASS_CODE ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (BusModelBuffInt64Def)editNext );
			}
			else if( classCode == IBusModelInt64Type.CLASS_CODE ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (BusModelBuffInt64Type)editNext );
			}
			else if( classCode == IBusModelId64Gen.CLASS_CODE ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (BusModelBuffId64Gen)editNext );
			}
			else if( classCode == IBusModelInt64Col.CLASS_CODE ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (BusModelBuffInt64Col)editNext );
			}
			else if( classCode == IBusModelNmTokenDef.CLASS_CODE ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (BusModelBuffNmTokenDef)editNext );
			}
			else if( classCode == IBusModelNmTokenType.CLASS_CODE ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (BusModelBuffNmTokenType)editNext );
			}
			else if( classCode == IBusModelNmTokenCol.CLASS_CODE ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (BusModelBuffNmTokenCol)editNext );
			}
			else if( classCode == IBusModelNmTokensDef.CLASS_CODE ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (BusModelBuffNmTokensDef)editNext );
			}
			else if( classCode == IBusModelNmTokensType.CLASS_CODE ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (BusModelBuffNmTokensType)editNext );
			}
			else if( classCode == IBusModelNmTokensCol.CLASS_CODE ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (BusModelBuffNmTokensCol)editNext );
			}
			else if( classCode == IBusModelNumberDef.CLASS_CODE ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (BusModelBuffNumberDef)editNext );
			}
			else if( classCode == IBusModelNumberType.CLASS_CODE ) {
				schema.getTableNumberType().updateNumberType( Authorization, (BusModelBuffNumberType)editNext );
			}
			else if( classCode == IBusModelNumberCol.CLASS_CODE ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (BusModelBuffNumberCol)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, (BusModelBuffDbKeyHash128Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, (BusModelBuffDbKeyHash128Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, (BusModelBuffDbKeyHash128Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, (BusModelBuffDbKeyHash128Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, (BusModelBuffDbKeyHash160Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, (BusModelBuffDbKeyHash160Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, (BusModelBuffDbKeyHash160Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, (BusModelBuffDbKeyHash160Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, (BusModelBuffDbKeyHash224Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, (BusModelBuffDbKeyHash224Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, (BusModelBuffDbKeyHash224Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, (BusModelBuffDbKeyHash224Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, (BusModelBuffDbKeyHash256Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, (BusModelBuffDbKeyHash256Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, (BusModelBuffDbKeyHash256Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, (BusModelBuffDbKeyHash256Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, (BusModelBuffDbKeyHash384Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, (BusModelBuffDbKeyHash384Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, (BusModelBuffDbKeyHash384Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, (BusModelBuffDbKeyHash384Gen)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, (BusModelBuffDbKeyHash512Def)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, (BusModelBuffDbKeyHash512Col)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, (BusModelBuffDbKeyHash512Type)editNext );
			}
			else if( classCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, (BusModelBuffDbKeyHash512Gen)editNext );
			}
			else if( classCode == IBusModelStringDef.CLASS_CODE ) {
				schema.getTableStringDef().updateStringDef( Authorization, (BusModelBuffStringDef)editNext );
			}
			else if( classCode == IBusModelStringType.CLASS_CODE ) {
				schema.getTableStringType().updateStringType( Authorization, (BusModelBuffStringType)editNext );
			}
			else if( classCode == IBusModelStringCol.CLASS_CODE ) {
				schema.getTableStringCol().updateStringCol( Authorization, (BusModelBuffStringCol)editNext );
			}
			else if( classCode == IBusModelTZDateDef.CLASS_CODE ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (BusModelBuffTZDateDef)editNext );
			}
			else if( classCode == IBusModelTZDateType.CLASS_CODE ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (BusModelBuffTZDateType)editNext );
			}
			else if( classCode == IBusModelTZDateCol.CLASS_CODE ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (BusModelBuffTZDateCol)editNext );
			}
			else if( classCode == IBusModelTZTimeDef.CLASS_CODE ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (BusModelBuffTZTimeDef)editNext );
			}
			else if( classCode == IBusModelTZTimeType.CLASS_CODE ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (BusModelBuffTZTimeType)editNext );
			}
			else if( classCode == IBusModelTZTimeCol.CLASS_CODE ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (BusModelBuffTZTimeCol)editNext );
			}
			else if( classCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (BusModelBuffTZTimestampDef)editNext );
			}
			else if( classCode == IBusModelTZTimestampType.CLASS_CODE ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (BusModelBuffTZTimestampType)editNext );
			}
			else if( classCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (BusModelBuffTZTimestampCol)editNext );
			}
			else if( classCode == IBusModelTextDef.CLASS_CODE ) {
				schema.getTableTextDef().updateTextDef( Authorization, (BusModelBuffTextDef)editNext );
			}
			else if( classCode == IBusModelTextType.CLASS_CODE ) {
				schema.getTableTextType().updateTextType( Authorization, (BusModelBuffTextType)editNext );
			}
			else if( classCode == IBusModelTextCol.CLASS_CODE ) {
				schema.getTableTextCol().updateTextCol( Authorization, (BusModelBuffTextCol)editNext );
			}
			else if( classCode == IBusModelTimeDef.CLASS_CODE ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (BusModelBuffTimeDef)editNext );
			}
			else if( classCode == IBusModelTimeType.CLASS_CODE ) {
				schema.getTableTimeType().updateTimeType( Authorization, (BusModelBuffTimeType)editNext );
			}
			else if( classCode == IBusModelTimeCol.CLASS_CODE ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (BusModelBuffTimeCol)editNext );
			}
			else if( classCode == IBusModelTimestampDef.CLASS_CODE ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (BusModelBuffTimestampDef)editNext );
			}
			else if( classCode == IBusModelTimestampType.CLASS_CODE ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (BusModelBuffTimestampType)editNext );
			}
			else if( classCode == IBusModelTimestampCol.CLASS_CODE ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (BusModelBuffTimestampCol)editNext );
			}
			else if( classCode == IBusModelTokenDef.CLASS_CODE ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (BusModelBuffTokenDef)editNext );
			}
			else if( classCode == IBusModelTokenType.CLASS_CODE ) {
				schema.getTableTokenType().updateTokenType( Authorization, (BusModelBuffTokenType)editNext );
			}
			else if( classCode == IBusModelTokenCol.CLASS_CODE ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (BusModelBuffTokenCol)editNext );
			}
			else if( classCode == IBusModelUInt16Def.CLASS_CODE ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (BusModelBuffUInt16Def)editNext );
			}
			else if( classCode == IBusModelUInt16Type.CLASS_CODE ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (BusModelBuffUInt16Type)editNext );
			}
			else if( classCode == IBusModelUInt16Col.CLASS_CODE ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (BusModelBuffUInt16Col)editNext );
			}
			else if( classCode == IBusModelUInt32Def.CLASS_CODE ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (BusModelBuffUInt32Def)editNext );
			}
			else if( classCode == IBusModelUInt32Type.CLASS_CODE ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (BusModelBuffUInt32Type)editNext );
			}
			else if( classCode == IBusModelUInt32Col.CLASS_CODE ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (BusModelBuffUInt32Col)editNext );
			}
			else if( classCode == IBusModelUInt64Def.CLASS_CODE ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (BusModelBuffUInt64Def)editNext );
			}
			else if( classCode == IBusModelUInt64Type.CLASS_CODE ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (BusModelBuffUInt64Type)editNext );
			}
			else if( classCode == IBusModelUInt64Col.CLASS_CODE ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (BusModelBuffUInt64Col)editNext );
			}
			else if( classCode == IBusModelUuidDef.CLASS_CODE ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (BusModelBuffUuidDef)editNext );
			}
			else if( classCode == IBusModelUuidType.CLASS_CODE ) {
				schema.getTableUuidType().updateUuidType( Authorization, (BusModelBuffUuidType)editNext );
			}
			else if( classCode == IBusModelUuidGen.CLASS_CODE ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (BusModelBuffUuidGen)editNext );
			}
			else if( classCode == IBusModelUuidCol.CLASS_CODE ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (BusModelBuffUuidCol)editNext );
			}
			else if( classCode == IBusModelUuid6Def.CLASS_CODE ) {
				schema.getTableUuid6Def().updateUuid6Def( Authorization, (BusModelBuffUuid6Def)editNext );
			}
			else if( classCode == IBusModelUuid6Type.CLASS_CODE ) {
				schema.getTableUuid6Type().updateUuid6Type( Authorization, (BusModelBuffUuid6Type)editNext );
			}
			else if( classCode == IBusModelUuid6Gen.CLASS_CODE ) {
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, (BusModelBuffUuid6Gen)editNext );
			}
			else if( classCode == IBusModelUuid6Col.CLASS_CODE ) {
				schema.getTableUuid6Col().updateUuid6Col( Authorization, (BusModelBuffUuid6Col)editNext );
			}
			else if( classCode == IBusModelTableCol.CLASS_CODE ) {
				schema.getTableTableCol().updateTableCol( Authorization, (BusModelBuffTableCol)editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckReferencingTableCols[] = schema.getTableTableCol().readDerivedByDataIdx( Authorization,
						existing.getRequiredId() );
		if( arrCheckReferencingTableCols.length > 0 ) {
			schema.getTableTableCol().deleteTableColByDataIdx( Authorization,
						existing.getRequiredId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckReferencingIndexCols[] = schema.getTableIndexCol().readDerivedByColIdx( Authorization,
						existing.getRequiredId() );
		if( arrCheckReferencingIndexCols.length > 0 ) {
			schema.getTableIndexCol().deleteIndexColByColIdx( Authorization,
						existing.getRequiredId() );
		}
		// Validate reverse foreign keys

		if( schema.getTableBlobDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"BlobDef",
				"BlobDef",
				pkey );
		}

		if( schema.getTableBoolDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"BoolDef",
				"BoolDef",
				pkey );
		}

		if( schema.getTableDateDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DateDef",
				"DateDef",
				pkey );
		}

		if( schema.getTableDoubleDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DoubleDef",
				"DoubleDef",
				pkey );
		}

		if( schema.getTableFloatDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"FloatDef",
				"FloatDef",
				pkey );
		}

		if( schema.getTableInt16Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"Int16Def",
				"Int16Def",
				pkey );
		}

		if( schema.getTableInt32Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"Int32Def",
				"Int32Def",
				pkey );
		}

		if( schema.getTableInt64Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"Int64Def",
				"Int64Def",
				pkey );
		}

		if( schema.getTableNmTokenDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"NmTokenDef",
				"NmTokenDef",
				pkey );
		}

		if( schema.getTableNmTokensDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"NmTokensDef",
				"NmTokensDef",
				pkey );
		}

		if( schema.getTableNumberDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"NumberDef",
				"NumberDef",
				pkey );
		}

		if( schema.getTableDbKeyHash128Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DbKeyHash128Def",
				"DbKeyHash128Def",
				pkey );
		}

		if( schema.getTableDbKeyHash160Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DbKeyHash160Def",
				"DbKeyHash160Def",
				pkey );
		}

		if( schema.getTableDbKeyHash224Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DbKeyHash224Def",
				"DbKeyHash224Def",
				pkey );
		}

		if( schema.getTableDbKeyHash256Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DbKeyHash256Def",
				"DbKeyHash256Def",
				pkey );
		}

		if( schema.getTableDbKeyHash384Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DbKeyHash384Def",
				"DbKeyHash384Def",
				pkey );
		}

		if( schema.getTableDbKeyHash512Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DbKeyHash512Def",
				"DbKeyHash512Def",
				pkey );
		}

		if( schema.getTableStringDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"StringDef",
				"StringDef",
				pkey );
		}

		if( schema.getTableTZDateDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"TZDateDef",
				"TZDateDef",
				pkey );
		}

		if( schema.getTableTZTimeDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"TZTimeDef",
				"TZTimeDef",
				pkey );
		}

		if( schema.getTableTZTimestampDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"TZTimestampDef",
				"TZTimestampDef",
				pkey );
		}

		if( schema.getTableTextDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"TextDef",
				"TextDef",
				pkey );
		}

		if( schema.getTableTimeDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"TimeDef",
				"TimeDef",
				pkey );
		}

		if( schema.getTableTimestampDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"TimestampDef",
				"TimestampDef",
				pkey );
		}

		if( schema.getTableTokenDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"TokenDef",
				"TokenDef",
				pkey );
		}

		if( schema.getTableUInt16Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"UInt16Def",
				"UInt16Def",
				pkey );
		}

		if( schema.getTableUInt32Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"UInt32Def",
				"UInt32Def",
				pkey );
		}

		if( schema.getTableUInt64Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"UInt64Def",
				"UInt64Def",
				pkey );
		}

		if( schema.getTableUuidDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"UuidDef",
				"UuidDef",
				pkey );
		}

		if( schema.getTableUuid6Def().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteAtom",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"Uuid6Def",
				"Uuid6Def",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffAtom > subdict;

		dictByPKey.remove( pkey );

		schema.getTableValue().deleteValue( Authorization,
			Buff );
	}
	@Override
	public void deleteAtomByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteAtomByIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffAtom cur;
		LinkedList<BusModelBuffAtom> matchSet = new LinkedList<BusModelBuffAtom>();
		Iterator<BusModelBuffAtom> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffAtom> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffAtom)(schema.getTableAtom().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelAtom.CLASS_CODE == subClassCode ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( IBusModelBlobDef.CLASS_CODE == subClassCode ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (IBusModelBlobDef)cur );
			}
			else if( IBusModelBlobType.CLASS_CODE == subClassCode ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (IBusModelBlobType)cur );
			}
			else if( IBusModelBlobCol.CLASS_CODE == subClassCode ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (IBusModelBlobCol)cur );
			}
			else if( IBusModelBoolDef.CLASS_CODE == subClassCode ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (IBusModelBoolDef)cur );
			}
			else if( IBusModelBoolType.CLASS_CODE == subClassCode ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (IBusModelBoolType)cur );
			}
			else if( IBusModelBoolCol.CLASS_CODE == subClassCode ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (IBusModelBoolCol)cur );
			}
			else if( IBusModelDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (IBusModelDateDef)cur );
			}
			else if( IBusModelDateType.CLASS_CODE == subClassCode ) {
				schema.getTableDateType().deleteDateType( Authorization, (IBusModelDateType)cur );
			}
			else if( IBusModelDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (IBusModelDateCol)cur );
			}
			else if( IBusModelDoubleDef.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (IBusModelDoubleDef)cur );
			}
			else if( IBusModelDoubleType.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (IBusModelDoubleType)cur );
			}
			else if( IBusModelDoubleCol.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (IBusModelDoubleCol)cur );
			}
			else if( IBusModelFloatDef.CLASS_CODE == subClassCode ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (IBusModelFloatDef)cur );
			}
			else if( IBusModelFloatType.CLASS_CODE == subClassCode ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (IBusModelFloatType)cur );
			}
			else if( IBusModelFloatCol.CLASS_CODE == subClassCode ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (IBusModelFloatCol)cur );
			}
			else if( IBusModelInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (IBusModelInt16Def)cur );
			}
			else if( IBusModelInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (IBusModelInt16Type)cur );
			}
			else if( IBusModelId16Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (IBusModelId16Gen)cur );
			}
			else if( IBusModelEnumDef.CLASS_CODE == subClassCode ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (IBusModelEnumDef)cur );
			}
			else if( IBusModelEnumType.CLASS_CODE == subClassCode ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (IBusModelEnumType)cur );
			}
			else if( IBusModelInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (IBusModelInt16Col)cur );
			}
			else if( IBusModelInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (IBusModelInt32Def)cur );
			}
			else if( IBusModelInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (IBusModelInt32Type)cur );
			}
			else if( IBusModelId32Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (IBusModelId32Gen)cur );
			}
			else if( IBusModelInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (IBusModelInt32Col)cur );
			}
			else if( IBusModelInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (IBusModelInt64Def)cur );
			}
			else if( IBusModelInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (IBusModelInt64Type)cur );
			}
			else if( IBusModelId64Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (IBusModelId64Gen)cur );
			}
			else if( IBusModelInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (IBusModelInt64Col)cur );
			}
			else if( IBusModelNmTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (IBusModelNmTokenDef)cur );
			}
			else if( IBusModelNmTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (IBusModelNmTokenType)cur );
			}
			else if( IBusModelNmTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (IBusModelNmTokenCol)cur );
			}
			else if( IBusModelNmTokensDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (IBusModelNmTokensDef)cur );
			}
			else if( IBusModelNmTokensType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (IBusModelNmTokensType)cur );
			}
			else if( IBusModelNmTokensCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (IBusModelNmTokensCol)cur );
			}
			else if( IBusModelNumberDef.CLASS_CODE == subClassCode ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (IBusModelNumberDef)cur );
			}
			else if( IBusModelNumberType.CLASS_CODE == subClassCode ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (IBusModelNumberType)cur );
			}
			else if( IBusModelNumberCol.CLASS_CODE == subClassCode ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (IBusModelNumberCol)cur );
			}
			else if( IBusModelDbKeyHash128Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Def().deleteDbKeyHash128Def( Authorization, (IBusModelDbKeyHash128Def)cur );
			}
			else if( IBusModelDbKeyHash128Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Col().deleteDbKeyHash128Col( Authorization, (IBusModelDbKeyHash128Col)cur );
			}
			else if( IBusModelDbKeyHash128Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Type().deleteDbKeyHash128Type( Authorization, (IBusModelDbKeyHash128Type)cur );
			}
			else if( IBusModelDbKeyHash128Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Gen().deleteDbKeyHash128Gen( Authorization, (IBusModelDbKeyHash128Gen)cur );
			}
			else if( IBusModelDbKeyHash160Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Def().deleteDbKeyHash160Def( Authorization, (IBusModelDbKeyHash160Def)cur );
			}
			else if( IBusModelDbKeyHash160Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Col().deleteDbKeyHash160Col( Authorization, (IBusModelDbKeyHash160Col)cur );
			}
			else if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, (IBusModelDbKeyHash160Type)cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else if( IBusModelDbKeyHash224Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Def().deleteDbKeyHash224Def( Authorization, (IBusModelDbKeyHash224Def)cur );
			}
			else if( IBusModelDbKeyHash224Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Col().deleteDbKeyHash224Col( Authorization, (IBusModelDbKeyHash224Col)cur );
			}
			else if( IBusModelDbKeyHash224Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Type().deleteDbKeyHash224Type( Authorization, (IBusModelDbKeyHash224Type)cur );
			}
			else if( IBusModelDbKeyHash224Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Gen().deleteDbKeyHash224Gen( Authorization, (IBusModelDbKeyHash224Gen)cur );
			}
			else if( IBusModelDbKeyHash256Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Def().deleteDbKeyHash256Def( Authorization, (IBusModelDbKeyHash256Def)cur );
			}
			else if( IBusModelDbKeyHash256Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Col().deleteDbKeyHash256Col( Authorization, (IBusModelDbKeyHash256Col)cur );
			}
			else if( IBusModelDbKeyHash256Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Type().deleteDbKeyHash256Type( Authorization, (IBusModelDbKeyHash256Type)cur );
			}
			else if( IBusModelDbKeyHash256Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Gen().deleteDbKeyHash256Gen( Authorization, (IBusModelDbKeyHash256Gen)cur );
			}
			else if( IBusModelDbKeyHash384Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Def().deleteDbKeyHash384Def( Authorization, (IBusModelDbKeyHash384Def)cur );
			}
			else if( IBusModelDbKeyHash384Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Col().deleteDbKeyHash384Col( Authorization, (IBusModelDbKeyHash384Col)cur );
			}
			else if( IBusModelDbKeyHash384Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Type().deleteDbKeyHash384Type( Authorization, (IBusModelDbKeyHash384Type)cur );
			}
			else if( IBusModelDbKeyHash384Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Gen().deleteDbKeyHash384Gen( Authorization, (IBusModelDbKeyHash384Gen)cur );
			}
			else if( IBusModelDbKeyHash512Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Def().deleteDbKeyHash512Def( Authorization, (IBusModelDbKeyHash512Def)cur );
			}
			else if( IBusModelDbKeyHash512Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Col().deleteDbKeyHash512Col( Authorization, (IBusModelDbKeyHash512Col)cur );
			}
			else if( IBusModelDbKeyHash512Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Type().deleteDbKeyHash512Type( Authorization, (IBusModelDbKeyHash512Type)cur );
			}
			else if( IBusModelDbKeyHash512Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Gen().deleteDbKeyHash512Gen( Authorization, (IBusModelDbKeyHash512Gen)cur );
			}
			else if( IBusModelStringDef.CLASS_CODE == subClassCode ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (IBusModelStringDef)cur );
			}
			else if( IBusModelStringType.CLASS_CODE == subClassCode ) {
				schema.getTableStringType().deleteStringType( Authorization, (IBusModelStringType)cur );
			}
			else if( IBusModelStringCol.CLASS_CODE == subClassCode ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (IBusModelStringCol)cur );
			}
			else if( IBusModelTZDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (IBusModelTZDateDef)cur );
			}
			else if( IBusModelTZDateType.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (IBusModelTZDateType)cur );
			}
			else if( IBusModelTZDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (IBusModelTZDateCol)cur );
			}
			else if( IBusModelTZTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (IBusModelTZTimeDef)cur );
			}
			else if( IBusModelTZTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (IBusModelTZTimeType)cur );
			}
			else if( IBusModelTZTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (IBusModelTZTimeCol)cur );
			}
			else if( IBusModelTZTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (IBusModelTZTimestampDef)cur );
			}
			else if( IBusModelTZTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (IBusModelTZTimestampType)cur );
			}
			else if( IBusModelTZTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (IBusModelTZTimestampCol)cur );
			}
			else if( IBusModelTextDef.CLASS_CODE == subClassCode ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (IBusModelTextDef)cur );
			}
			else if( IBusModelTextType.CLASS_CODE == subClassCode ) {
				schema.getTableTextType().deleteTextType( Authorization, (IBusModelTextType)cur );
			}
			else if( IBusModelTextCol.CLASS_CODE == subClassCode ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (IBusModelTextCol)cur );
			}
			else if( IBusModelTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (IBusModelTimeDef)cur );
			}
			else if( IBusModelTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (IBusModelTimeType)cur );
			}
			else if( IBusModelTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (IBusModelTimeCol)cur );
			}
			else if( IBusModelTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (IBusModelTimestampDef)cur );
			}
			else if( IBusModelTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (IBusModelTimestampType)cur );
			}
			else if( IBusModelTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (IBusModelTimestampCol)cur );
			}
			else if( IBusModelTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (IBusModelTokenDef)cur );
			}
			else if( IBusModelTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (IBusModelTokenType)cur );
			}
			else if( IBusModelTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (IBusModelTokenCol)cur );
			}
			else if( IBusModelUInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (IBusModelUInt16Def)cur );
			}
			else if( IBusModelUInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (IBusModelUInt16Type)cur );
			}
			else if( IBusModelUInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (IBusModelUInt16Col)cur );
			}
			else if( IBusModelUInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (IBusModelUInt32Def)cur );
			}
			else if( IBusModelUInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (IBusModelUInt32Type)cur );
			}
			else if( IBusModelUInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (IBusModelUInt32Col)cur );
			}
			else if( IBusModelUInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (IBusModelUInt64Def)cur );
			}
			else if( IBusModelUInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (IBusModelUInt64Type)cur );
			}
			else if( IBusModelUInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (IBusModelUInt64Col)cur );
			}
			else if( IBusModelUuidDef.CLASS_CODE == subClassCode ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (IBusModelUuidDef)cur );
			}
			else if( IBusModelUuidType.CLASS_CODE == subClassCode ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (IBusModelUuidType)cur );
			}
			else if( IBusModelUuidGen.CLASS_CODE == subClassCode ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (IBusModelUuidGen)cur );
			}
			else if( IBusModelUuidCol.CLASS_CODE == subClassCode ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (IBusModelUuidCol)cur );
			}
			else if( IBusModelUuid6Def.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Def().deleteUuid6Def( Authorization, (IBusModelUuid6Def)cur );
			}
			else if( IBusModelUuid6Type.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Type().deleteUuid6Type( Authorization, (IBusModelUuid6Type)cur );
			}
			else if( IBusModelUuid6Gen.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Gen().deleteUuid6Gen( Authorization, (IBusModelUuid6Gen)cur );
			}
			else if( IBusModelUuid6Col.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Col().deleteUuid6Col( Authorization, (IBusModelUuid6Col)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteAtomByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		BusModelBuffValueByUNameIdxKey key = (BusModelBuffValueByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteAtomByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteAtomByUNameIdx( ISecureAuthorization Authorization,
		IBusModelValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByUNameIdx";
		BusModelBuffAtom cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffAtom> matchSet = new LinkedList<BusModelBuffAtom>();
		Iterator<BusModelBuffAtom> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffAtom> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffAtom)(schema.getTableAtom().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelAtom.CLASS_CODE == subClassCode ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( IBusModelBlobDef.CLASS_CODE == subClassCode ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (IBusModelBlobDef)cur );
			}
			else if( IBusModelBlobType.CLASS_CODE == subClassCode ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (IBusModelBlobType)cur );
			}
			else if( IBusModelBlobCol.CLASS_CODE == subClassCode ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (IBusModelBlobCol)cur );
			}
			else if( IBusModelBoolDef.CLASS_CODE == subClassCode ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (IBusModelBoolDef)cur );
			}
			else if( IBusModelBoolType.CLASS_CODE == subClassCode ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (IBusModelBoolType)cur );
			}
			else if( IBusModelBoolCol.CLASS_CODE == subClassCode ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (IBusModelBoolCol)cur );
			}
			else if( IBusModelDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (IBusModelDateDef)cur );
			}
			else if( IBusModelDateType.CLASS_CODE == subClassCode ) {
				schema.getTableDateType().deleteDateType( Authorization, (IBusModelDateType)cur );
			}
			else if( IBusModelDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (IBusModelDateCol)cur );
			}
			else if( IBusModelDoubleDef.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (IBusModelDoubleDef)cur );
			}
			else if( IBusModelDoubleType.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (IBusModelDoubleType)cur );
			}
			else if( IBusModelDoubleCol.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (IBusModelDoubleCol)cur );
			}
			else if( IBusModelFloatDef.CLASS_CODE == subClassCode ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (IBusModelFloatDef)cur );
			}
			else if( IBusModelFloatType.CLASS_CODE == subClassCode ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (IBusModelFloatType)cur );
			}
			else if( IBusModelFloatCol.CLASS_CODE == subClassCode ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (IBusModelFloatCol)cur );
			}
			else if( IBusModelInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (IBusModelInt16Def)cur );
			}
			else if( IBusModelInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (IBusModelInt16Type)cur );
			}
			else if( IBusModelId16Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (IBusModelId16Gen)cur );
			}
			else if( IBusModelEnumDef.CLASS_CODE == subClassCode ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (IBusModelEnumDef)cur );
			}
			else if( IBusModelEnumType.CLASS_CODE == subClassCode ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (IBusModelEnumType)cur );
			}
			else if( IBusModelInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (IBusModelInt16Col)cur );
			}
			else if( IBusModelInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (IBusModelInt32Def)cur );
			}
			else if( IBusModelInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (IBusModelInt32Type)cur );
			}
			else if( IBusModelId32Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (IBusModelId32Gen)cur );
			}
			else if( IBusModelInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (IBusModelInt32Col)cur );
			}
			else if( IBusModelInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (IBusModelInt64Def)cur );
			}
			else if( IBusModelInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (IBusModelInt64Type)cur );
			}
			else if( IBusModelId64Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (IBusModelId64Gen)cur );
			}
			else if( IBusModelInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (IBusModelInt64Col)cur );
			}
			else if( IBusModelNmTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (IBusModelNmTokenDef)cur );
			}
			else if( IBusModelNmTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (IBusModelNmTokenType)cur );
			}
			else if( IBusModelNmTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (IBusModelNmTokenCol)cur );
			}
			else if( IBusModelNmTokensDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (IBusModelNmTokensDef)cur );
			}
			else if( IBusModelNmTokensType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (IBusModelNmTokensType)cur );
			}
			else if( IBusModelNmTokensCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (IBusModelNmTokensCol)cur );
			}
			else if( IBusModelNumberDef.CLASS_CODE == subClassCode ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (IBusModelNumberDef)cur );
			}
			else if( IBusModelNumberType.CLASS_CODE == subClassCode ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (IBusModelNumberType)cur );
			}
			else if( IBusModelNumberCol.CLASS_CODE == subClassCode ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (IBusModelNumberCol)cur );
			}
			else if( IBusModelDbKeyHash128Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Def().deleteDbKeyHash128Def( Authorization, (IBusModelDbKeyHash128Def)cur );
			}
			else if( IBusModelDbKeyHash128Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Col().deleteDbKeyHash128Col( Authorization, (IBusModelDbKeyHash128Col)cur );
			}
			else if( IBusModelDbKeyHash128Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Type().deleteDbKeyHash128Type( Authorization, (IBusModelDbKeyHash128Type)cur );
			}
			else if( IBusModelDbKeyHash128Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Gen().deleteDbKeyHash128Gen( Authorization, (IBusModelDbKeyHash128Gen)cur );
			}
			else if( IBusModelDbKeyHash160Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Def().deleteDbKeyHash160Def( Authorization, (IBusModelDbKeyHash160Def)cur );
			}
			else if( IBusModelDbKeyHash160Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Col().deleteDbKeyHash160Col( Authorization, (IBusModelDbKeyHash160Col)cur );
			}
			else if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, (IBusModelDbKeyHash160Type)cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else if( IBusModelDbKeyHash224Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Def().deleteDbKeyHash224Def( Authorization, (IBusModelDbKeyHash224Def)cur );
			}
			else if( IBusModelDbKeyHash224Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Col().deleteDbKeyHash224Col( Authorization, (IBusModelDbKeyHash224Col)cur );
			}
			else if( IBusModelDbKeyHash224Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Type().deleteDbKeyHash224Type( Authorization, (IBusModelDbKeyHash224Type)cur );
			}
			else if( IBusModelDbKeyHash224Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Gen().deleteDbKeyHash224Gen( Authorization, (IBusModelDbKeyHash224Gen)cur );
			}
			else if( IBusModelDbKeyHash256Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Def().deleteDbKeyHash256Def( Authorization, (IBusModelDbKeyHash256Def)cur );
			}
			else if( IBusModelDbKeyHash256Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Col().deleteDbKeyHash256Col( Authorization, (IBusModelDbKeyHash256Col)cur );
			}
			else if( IBusModelDbKeyHash256Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Type().deleteDbKeyHash256Type( Authorization, (IBusModelDbKeyHash256Type)cur );
			}
			else if( IBusModelDbKeyHash256Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Gen().deleteDbKeyHash256Gen( Authorization, (IBusModelDbKeyHash256Gen)cur );
			}
			else if( IBusModelDbKeyHash384Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Def().deleteDbKeyHash384Def( Authorization, (IBusModelDbKeyHash384Def)cur );
			}
			else if( IBusModelDbKeyHash384Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Col().deleteDbKeyHash384Col( Authorization, (IBusModelDbKeyHash384Col)cur );
			}
			else if( IBusModelDbKeyHash384Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Type().deleteDbKeyHash384Type( Authorization, (IBusModelDbKeyHash384Type)cur );
			}
			else if( IBusModelDbKeyHash384Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Gen().deleteDbKeyHash384Gen( Authorization, (IBusModelDbKeyHash384Gen)cur );
			}
			else if( IBusModelDbKeyHash512Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Def().deleteDbKeyHash512Def( Authorization, (IBusModelDbKeyHash512Def)cur );
			}
			else if( IBusModelDbKeyHash512Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Col().deleteDbKeyHash512Col( Authorization, (IBusModelDbKeyHash512Col)cur );
			}
			else if( IBusModelDbKeyHash512Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Type().deleteDbKeyHash512Type( Authorization, (IBusModelDbKeyHash512Type)cur );
			}
			else if( IBusModelDbKeyHash512Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Gen().deleteDbKeyHash512Gen( Authorization, (IBusModelDbKeyHash512Gen)cur );
			}
			else if( IBusModelStringDef.CLASS_CODE == subClassCode ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (IBusModelStringDef)cur );
			}
			else if( IBusModelStringType.CLASS_CODE == subClassCode ) {
				schema.getTableStringType().deleteStringType( Authorization, (IBusModelStringType)cur );
			}
			else if( IBusModelStringCol.CLASS_CODE == subClassCode ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (IBusModelStringCol)cur );
			}
			else if( IBusModelTZDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (IBusModelTZDateDef)cur );
			}
			else if( IBusModelTZDateType.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (IBusModelTZDateType)cur );
			}
			else if( IBusModelTZDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (IBusModelTZDateCol)cur );
			}
			else if( IBusModelTZTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (IBusModelTZTimeDef)cur );
			}
			else if( IBusModelTZTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (IBusModelTZTimeType)cur );
			}
			else if( IBusModelTZTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (IBusModelTZTimeCol)cur );
			}
			else if( IBusModelTZTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (IBusModelTZTimestampDef)cur );
			}
			else if( IBusModelTZTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (IBusModelTZTimestampType)cur );
			}
			else if( IBusModelTZTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (IBusModelTZTimestampCol)cur );
			}
			else if( IBusModelTextDef.CLASS_CODE == subClassCode ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (IBusModelTextDef)cur );
			}
			else if( IBusModelTextType.CLASS_CODE == subClassCode ) {
				schema.getTableTextType().deleteTextType( Authorization, (IBusModelTextType)cur );
			}
			else if( IBusModelTextCol.CLASS_CODE == subClassCode ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (IBusModelTextCol)cur );
			}
			else if( IBusModelTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (IBusModelTimeDef)cur );
			}
			else if( IBusModelTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (IBusModelTimeType)cur );
			}
			else if( IBusModelTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (IBusModelTimeCol)cur );
			}
			else if( IBusModelTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (IBusModelTimestampDef)cur );
			}
			else if( IBusModelTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (IBusModelTimestampType)cur );
			}
			else if( IBusModelTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (IBusModelTimestampCol)cur );
			}
			else if( IBusModelTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (IBusModelTokenDef)cur );
			}
			else if( IBusModelTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (IBusModelTokenType)cur );
			}
			else if( IBusModelTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (IBusModelTokenCol)cur );
			}
			else if( IBusModelUInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (IBusModelUInt16Def)cur );
			}
			else if( IBusModelUInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (IBusModelUInt16Type)cur );
			}
			else if( IBusModelUInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (IBusModelUInt16Col)cur );
			}
			else if( IBusModelUInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (IBusModelUInt32Def)cur );
			}
			else if( IBusModelUInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (IBusModelUInt32Type)cur );
			}
			else if( IBusModelUInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (IBusModelUInt32Col)cur );
			}
			else if( IBusModelUInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (IBusModelUInt64Def)cur );
			}
			else if( IBusModelUInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (IBusModelUInt64Type)cur );
			}
			else if( IBusModelUInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (IBusModelUInt64Col)cur );
			}
			else if( IBusModelUuidDef.CLASS_CODE == subClassCode ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (IBusModelUuidDef)cur );
			}
			else if( IBusModelUuidType.CLASS_CODE == subClassCode ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (IBusModelUuidType)cur );
			}
			else if( IBusModelUuidGen.CLASS_CODE == subClassCode ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (IBusModelUuidGen)cur );
			}
			else if( IBusModelUuidCol.CLASS_CODE == subClassCode ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (IBusModelUuidCol)cur );
			}
			else if( IBusModelUuid6Def.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Def().deleteUuid6Def( Authorization, (IBusModelUuid6Def)cur );
			}
			else if( IBusModelUuid6Type.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Type().deleteUuid6Type( Authorization, (IBusModelUuid6Type)cur );
			}
			else if( IBusModelUuid6Gen.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Gen().deleteUuid6Gen( Authorization, (IBusModelUuid6Gen)cur );
			}
			else if( IBusModelUuid6Col.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Col().deleteUuid6Col( Authorization, (IBusModelUuid6Col)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteAtomByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		BusModelBuffValueByScopeIdxKey key = (BusModelBuffValueByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( argScopeId );
		deleteAtomByScopeIdx( Authorization, key );
	}

	@Override
	public void deleteAtomByScopeIdx( ISecureAuthorization Authorization,
		IBusModelValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByScopeIdx";
		BusModelBuffAtom cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffAtom> matchSet = new LinkedList<BusModelBuffAtom>();
		Iterator<BusModelBuffAtom> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffAtom> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffAtom)(schema.getTableAtom().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelAtom.CLASS_CODE == subClassCode ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( IBusModelBlobDef.CLASS_CODE == subClassCode ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (IBusModelBlobDef)cur );
			}
			else if( IBusModelBlobType.CLASS_CODE == subClassCode ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (IBusModelBlobType)cur );
			}
			else if( IBusModelBlobCol.CLASS_CODE == subClassCode ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (IBusModelBlobCol)cur );
			}
			else if( IBusModelBoolDef.CLASS_CODE == subClassCode ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (IBusModelBoolDef)cur );
			}
			else if( IBusModelBoolType.CLASS_CODE == subClassCode ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (IBusModelBoolType)cur );
			}
			else if( IBusModelBoolCol.CLASS_CODE == subClassCode ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (IBusModelBoolCol)cur );
			}
			else if( IBusModelDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (IBusModelDateDef)cur );
			}
			else if( IBusModelDateType.CLASS_CODE == subClassCode ) {
				schema.getTableDateType().deleteDateType( Authorization, (IBusModelDateType)cur );
			}
			else if( IBusModelDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (IBusModelDateCol)cur );
			}
			else if( IBusModelDoubleDef.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (IBusModelDoubleDef)cur );
			}
			else if( IBusModelDoubleType.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (IBusModelDoubleType)cur );
			}
			else if( IBusModelDoubleCol.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (IBusModelDoubleCol)cur );
			}
			else if( IBusModelFloatDef.CLASS_CODE == subClassCode ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (IBusModelFloatDef)cur );
			}
			else if( IBusModelFloatType.CLASS_CODE == subClassCode ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (IBusModelFloatType)cur );
			}
			else if( IBusModelFloatCol.CLASS_CODE == subClassCode ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (IBusModelFloatCol)cur );
			}
			else if( IBusModelInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (IBusModelInt16Def)cur );
			}
			else if( IBusModelInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (IBusModelInt16Type)cur );
			}
			else if( IBusModelId16Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (IBusModelId16Gen)cur );
			}
			else if( IBusModelEnumDef.CLASS_CODE == subClassCode ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (IBusModelEnumDef)cur );
			}
			else if( IBusModelEnumType.CLASS_CODE == subClassCode ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (IBusModelEnumType)cur );
			}
			else if( IBusModelInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (IBusModelInt16Col)cur );
			}
			else if( IBusModelInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (IBusModelInt32Def)cur );
			}
			else if( IBusModelInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (IBusModelInt32Type)cur );
			}
			else if( IBusModelId32Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (IBusModelId32Gen)cur );
			}
			else if( IBusModelInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (IBusModelInt32Col)cur );
			}
			else if( IBusModelInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (IBusModelInt64Def)cur );
			}
			else if( IBusModelInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (IBusModelInt64Type)cur );
			}
			else if( IBusModelId64Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (IBusModelId64Gen)cur );
			}
			else if( IBusModelInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (IBusModelInt64Col)cur );
			}
			else if( IBusModelNmTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (IBusModelNmTokenDef)cur );
			}
			else if( IBusModelNmTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (IBusModelNmTokenType)cur );
			}
			else if( IBusModelNmTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (IBusModelNmTokenCol)cur );
			}
			else if( IBusModelNmTokensDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (IBusModelNmTokensDef)cur );
			}
			else if( IBusModelNmTokensType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (IBusModelNmTokensType)cur );
			}
			else if( IBusModelNmTokensCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (IBusModelNmTokensCol)cur );
			}
			else if( IBusModelNumberDef.CLASS_CODE == subClassCode ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (IBusModelNumberDef)cur );
			}
			else if( IBusModelNumberType.CLASS_CODE == subClassCode ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (IBusModelNumberType)cur );
			}
			else if( IBusModelNumberCol.CLASS_CODE == subClassCode ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (IBusModelNumberCol)cur );
			}
			else if( IBusModelDbKeyHash128Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Def().deleteDbKeyHash128Def( Authorization, (IBusModelDbKeyHash128Def)cur );
			}
			else if( IBusModelDbKeyHash128Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Col().deleteDbKeyHash128Col( Authorization, (IBusModelDbKeyHash128Col)cur );
			}
			else if( IBusModelDbKeyHash128Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Type().deleteDbKeyHash128Type( Authorization, (IBusModelDbKeyHash128Type)cur );
			}
			else if( IBusModelDbKeyHash128Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Gen().deleteDbKeyHash128Gen( Authorization, (IBusModelDbKeyHash128Gen)cur );
			}
			else if( IBusModelDbKeyHash160Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Def().deleteDbKeyHash160Def( Authorization, (IBusModelDbKeyHash160Def)cur );
			}
			else if( IBusModelDbKeyHash160Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Col().deleteDbKeyHash160Col( Authorization, (IBusModelDbKeyHash160Col)cur );
			}
			else if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, (IBusModelDbKeyHash160Type)cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else if( IBusModelDbKeyHash224Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Def().deleteDbKeyHash224Def( Authorization, (IBusModelDbKeyHash224Def)cur );
			}
			else if( IBusModelDbKeyHash224Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Col().deleteDbKeyHash224Col( Authorization, (IBusModelDbKeyHash224Col)cur );
			}
			else if( IBusModelDbKeyHash224Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Type().deleteDbKeyHash224Type( Authorization, (IBusModelDbKeyHash224Type)cur );
			}
			else if( IBusModelDbKeyHash224Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Gen().deleteDbKeyHash224Gen( Authorization, (IBusModelDbKeyHash224Gen)cur );
			}
			else if( IBusModelDbKeyHash256Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Def().deleteDbKeyHash256Def( Authorization, (IBusModelDbKeyHash256Def)cur );
			}
			else if( IBusModelDbKeyHash256Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Col().deleteDbKeyHash256Col( Authorization, (IBusModelDbKeyHash256Col)cur );
			}
			else if( IBusModelDbKeyHash256Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Type().deleteDbKeyHash256Type( Authorization, (IBusModelDbKeyHash256Type)cur );
			}
			else if( IBusModelDbKeyHash256Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Gen().deleteDbKeyHash256Gen( Authorization, (IBusModelDbKeyHash256Gen)cur );
			}
			else if( IBusModelDbKeyHash384Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Def().deleteDbKeyHash384Def( Authorization, (IBusModelDbKeyHash384Def)cur );
			}
			else if( IBusModelDbKeyHash384Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Col().deleteDbKeyHash384Col( Authorization, (IBusModelDbKeyHash384Col)cur );
			}
			else if( IBusModelDbKeyHash384Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Type().deleteDbKeyHash384Type( Authorization, (IBusModelDbKeyHash384Type)cur );
			}
			else if( IBusModelDbKeyHash384Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Gen().deleteDbKeyHash384Gen( Authorization, (IBusModelDbKeyHash384Gen)cur );
			}
			else if( IBusModelDbKeyHash512Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Def().deleteDbKeyHash512Def( Authorization, (IBusModelDbKeyHash512Def)cur );
			}
			else if( IBusModelDbKeyHash512Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Col().deleteDbKeyHash512Col( Authorization, (IBusModelDbKeyHash512Col)cur );
			}
			else if( IBusModelDbKeyHash512Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Type().deleteDbKeyHash512Type( Authorization, (IBusModelDbKeyHash512Type)cur );
			}
			else if( IBusModelDbKeyHash512Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Gen().deleteDbKeyHash512Gen( Authorization, (IBusModelDbKeyHash512Gen)cur );
			}
			else if( IBusModelStringDef.CLASS_CODE == subClassCode ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (IBusModelStringDef)cur );
			}
			else if( IBusModelStringType.CLASS_CODE == subClassCode ) {
				schema.getTableStringType().deleteStringType( Authorization, (IBusModelStringType)cur );
			}
			else if( IBusModelStringCol.CLASS_CODE == subClassCode ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (IBusModelStringCol)cur );
			}
			else if( IBusModelTZDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (IBusModelTZDateDef)cur );
			}
			else if( IBusModelTZDateType.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (IBusModelTZDateType)cur );
			}
			else if( IBusModelTZDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (IBusModelTZDateCol)cur );
			}
			else if( IBusModelTZTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (IBusModelTZTimeDef)cur );
			}
			else if( IBusModelTZTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (IBusModelTZTimeType)cur );
			}
			else if( IBusModelTZTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (IBusModelTZTimeCol)cur );
			}
			else if( IBusModelTZTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (IBusModelTZTimestampDef)cur );
			}
			else if( IBusModelTZTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (IBusModelTZTimestampType)cur );
			}
			else if( IBusModelTZTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (IBusModelTZTimestampCol)cur );
			}
			else if( IBusModelTextDef.CLASS_CODE == subClassCode ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (IBusModelTextDef)cur );
			}
			else if( IBusModelTextType.CLASS_CODE == subClassCode ) {
				schema.getTableTextType().deleteTextType( Authorization, (IBusModelTextType)cur );
			}
			else if( IBusModelTextCol.CLASS_CODE == subClassCode ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (IBusModelTextCol)cur );
			}
			else if( IBusModelTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (IBusModelTimeDef)cur );
			}
			else if( IBusModelTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (IBusModelTimeType)cur );
			}
			else if( IBusModelTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (IBusModelTimeCol)cur );
			}
			else if( IBusModelTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (IBusModelTimestampDef)cur );
			}
			else if( IBusModelTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (IBusModelTimestampType)cur );
			}
			else if( IBusModelTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (IBusModelTimestampCol)cur );
			}
			else if( IBusModelTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (IBusModelTokenDef)cur );
			}
			else if( IBusModelTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (IBusModelTokenType)cur );
			}
			else if( IBusModelTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (IBusModelTokenCol)cur );
			}
			else if( IBusModelUInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (IBusModelUInt16Def)cur );
			}
			else if( IBusModelUInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (IBusModelUInt16Type)cur );
			}
			else if( IBusModelUInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (IBusModelUInt16Col)cur );
			}
			else if( IBusModelUInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (IBusModelUInt32Def)cur );
			}
			else if( IBusModelUInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (IBusModelUInt32Type)cur );
			}
			else if( IBusModelUInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (IBusModelUInt32Col)cur );
			}
			else if( IBusModelUInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (IBusModelUInt64Def)cur );
			}
			else if( IBusModelUInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (IBusModelUInt64Type)cur );
			}
			else if( IBusModelUInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (IBusModelUInt64Col)cur );
			}
			else if( IBusModelUuidDef.CLASS_CODE == subClassCode ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (IBusModelUuidDef)cur );
			}
			else if( IBusModelUuidType.CLASS_CODE == subClassCode ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (IBusModelUuidType)cur );
			}
			else if( IBusModelUuidGen.CLASS_CODE == subClassCode ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (IBusModelUuidGen)cur );
			}
			else if( IBusModelUuidCol.CLASS_CODE == subClassCode ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (IBusModelUuidCol)cur );
			}
			else if( IBusModelUuid6Def.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Def().deleteUuid6Def( Authorization, (IBusModelUuid6Def)cur );
			}
			else if( IBusModelUuid6Type.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Type().deleteUuid6Type( Authorization, (IBusModelUuid6Type)cur );
			}
			else if( IBusModelUuid6Gen.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Gen().deleteUuid6Gen( Authorization, (IBusModelUuid6Gen)cur );
			}
			else if( IBusModelUuid6Col.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Col().deleteUuid6Col( Authorization, (IBusModelUuid6Col)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteAtomByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffValueByDefSchemaIdxKey key = (BusModelBuffValueByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteAtomByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteAtomByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByDefSchemaIdx";
		BusModelBuffAtom cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffAtom> matchSet = new LinkedList<BusModelBuffAtom>();
		Iterator<BusModelBuffAtom> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffAtom> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffAtom)(schema.getTableAtom().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelAtom.CLASS_CODE == subClassCode ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( IBusModelBlobDef.CLASS_CODE == subClassCode ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (IBusModelBlobDef)cur );
			}
			else if( IBusModelBlobType.CLASS_CODE == subClassCode ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (IBusModelBlobType)cur );
			}
			else if( IBusModelBlobCol.CLASS_CODE == subClassCode ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (IBusModelBlobCol)cur );
			}
			else if( IBusModelBoolDef.CLASS_CODE == subClassCode ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (IBusModelBoolDef)cur );
			}
			else if( IBusModelBoolType.CLASS_CODE == subClassCode ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (IBusModelBoolType)cur );
			}
			else if( IBusModelBoolCol.CLASS_CODE == subClassCode ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (IBusModelBoolCol)cur );
			}
			else if( IBusModelDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (IBusModelDateDef)cur );
			}
			else if( IBusModelDateType.CLASS_CODE == subClassCode ) {
				schema.getTableDateType().deleteDateType( Authorization, (IBusModelDateType)cur );
			}
			else if( IBusModelDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (IBusModelDateCol)cur );
			}
			else if( IBusModelDoubleDef.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (IBusModelDoubleDef)cur );
			}
			else if( IBusModelDoubleType.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (IBusModelDoubleType)cur );
			}
			else if( IBusModelDoubleCol.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (IBusModelDoubleCol)cur );
			}
			else if( IBusModelFloatDef.CLASS_CODE == subClassCode ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (IBusModelFloatDef)cur );
			}
			else if( IBusModelFloatType.CLASS_CODE == subClassCode ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (IBusModelFloatType)cur );
			}
			else if( IBusModelFloatCol.CLASS_CODE == subClassCode ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (IBusModelFloatCol)cur );
			}
			else if( IBusModelInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (IBusModelInt16Def)cur );
			}
			else if( IBusModelInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (IBusModelInt16Type)cur );
			}
			else if( IBusModelId16Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (IBusModelId16Gen)cur );
			}
			else if( IBusModelEnumDef.CLASS_CODE == subClassCode ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (IBusModelEnumDef)cur );
			}
			else if( IBusModelEnumType.CLASS_CODE == subClassCode ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (IBusModelEnumType)cur );
			}
			else if( IBusModelInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (IBusModelInt16Col)cur );
			}
			else if( IBusModelInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (IBusModelInt32Def)cur );
			}
			else if( IBusModelInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (IBusModelInt32Type)cur );
			}
			else if( IBusModelId32Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (IBusModelId32Gen)cur );
			}
			else if( IBusModelInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (IBusModelInt32Col)cur );
			}
			else if( IBusModelInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (IBusModelInt64Def)cur );
			}
			else if( IBusModelInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (IBusModelInt64Type)cur );
			}
			else if( IBusModelId64Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (IBusModelId64Gen)cur );
			}
			else if( IBusModelInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (IBusModelInt64Col)cur );
			}
			else if( IBusModelNmTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (IBusModelNmTokenDef)cur );
			}
			else if( IBusModelNmTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (IBusModelNmTokenType)cur );
			}
			else if( IBusModelNmTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (IBusModelNmTokenCol)cur );
			}
			else if( IBusModelNmTokensDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (IBusModelNmTokensDef)cur );
			}
			else if( IBusModelNmTokensType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (IBusModelNmTokensType)cur );
			}
			else if( IBusModelNmTokensCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (IBusModelNmTokensCol)cur );
			}
			else if( IBusModelNumberDef.CLASS_CODE == subClassCode ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (IBusModelNumberDef)cur );
			}
			else if( IBusModelNumberType.CLASS_CODE == subClassCode ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (IBusModelNumberType)cur );
			}
			else if( IBusModelNumberCol.CLASS_CODE == subClassCode ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (IBusModelNumberCol)cur );
			}
			else if( IBusModelDbKeyHash128Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Def().deleteDbKeyHash128Def( Authorization, (IBusModelDbKeyHash128Def)cur );
			}
			else if( IBusModelDbKeyHash128Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Col().deleteDbKeyHash128Col( Authorization, (IBusModelDbKeyHash128Col)cur );
			}
			else if( IBusModelDbKeyHash128Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Type().deleteDbKeyHash128Type( Authorization, (IBusModelDbKeyHash128Type)cur );
			}
			else if( IBusModelDbKeyHash128Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Gen().deleteDbKeyHash128Gen( Authorization, (IBusModelDbKeyHash128Gen)cur );
			}
			else if( IBusModelDbKeyHash160Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Def().deleteDbKeyHash160Def( Authorization, (IBusModelDbKeyHash160Def)cur );
			}
			else if( IBusModelDbKeyHash160Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Col().deleteDbKeyHash160Col( Authorization, (IBusModelDbKeyHash160Col)cur );
			}
			else if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, (IBusModelDbKeyHash160Type)cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else if( IBusModelDbKeyHash224Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Def().deleteDbKeyHash224Def( Authorization, (IBusModelDbKeyHash224Def)cur );
			}
			else if( IBusModelDbKeyHash224Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Col().deleteDbKeyHash224Col( Authorization, (IBusModelDbKeyHash224Col)cur );
			}
			else if( IBusModelDbKeyHash224Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Type().deleteDbKeyHash224Type( Authorization, (IBusModelDbKeyHash224Type)cur );
			}
			else if( IBusModelDbKeyHash224Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Gen().deleteDbKeyHash224Gen( Authorization, (IBusModelDbKeyHash224Gen)cur );
			}
			else if( IBusModelDbKeyHash256Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Def().deleteDbKeyHash256Def( Authorization, (IBusModelDbKeyHash256Def)cur );
			}
			else if( IBusModelDbKeyHash256Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Col().deleteDbKeyHash256Col( Authorization, (IBusModelDbKeyHash256Col)cur );
			}
			else if( IBusModelDbKeyHash256Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Type().deleteDbKeyHash256Type( Authorization, (IBusModelDbKeyHash256Type)cur );
			}
			else if( IBusModelDbKeyHash256Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Gen().deleteDbKeyHash256Gen( Authorization, (IBusModelDbKeyHash256Gen)cur );
			}
			else if( IBusModelDbKeyHash384Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Def().deleteDbKeyHash384Def( Authorization, (IBusModelDbKeyHash384Def)cur );
			}
			else if( IBusModelDbKeyHash384Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Col().deleteDbKeyHash384Col( Authorization, (IBusModelDbKeyHash384Col)cur );
			}
			else if( IBusModelDbKeyHash384Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Type().deleteDbKeyHash384Type( Authorization, (IBusModelDbKeyHash384Type)cur );
			}
			else if( IBusModelDbKeyHash384Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Gen().deleteDbKeyHash384Gen( Authorization, (IBusModelDbKeyHash384Gen)cur );
			}
			else if( IBusModelDbKeyHash512Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Def().deleteDbKeyHash512Def( Authorization, (IBusModelDbKeyHash512Def)cur );
			}
			else if( IBusModelDbKeyHash512Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Col().deleteDbKeyHash512Col( Authorization, (IBusModelDbKeyHash512Col)cur );
			}
			else if( IBusModelDbKeyHash512Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Type().deleteDbKeyHash512Type( Authorization, (IBusModelDbKeyHash512Type)cur );
			}
			else if( IBusModelDbKeyHash512Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Gen().deleteDbKeyHash512Gen( Authorization, (IBusModelDbKeyHash512Gen)cur );
			}
			else if( IBusModelStringDef.CLASS_CODE == subClassCode ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (IBusModelStringDef)cur );
			}
			else if( IBusModelStringType.CLASS_CODE == subClassCode ) {
				schema.getTableStringType().deleteStringType( Authorization, (IBusModelStringType)cur );
			}
			else if( IBusModelStringCol.CLASS_CODE == subClassCode ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (IBusModelStringCol)cur );
			}
			else if( IBusModelTZDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (IBusModelTZDateDef)cur );
			}
			else if( IBusModelTZDateType.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (IBusModelTZDateType)cur );
			}
			else if( IBusModelTZDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (IBusModelTZDateCol)cur );
			}
			else if( IBusModelTZTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (IBusModelTZTimeDef)cur );
			}
			else if( IBusModelTZTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (IBusModelTZTimeType)cur );
			}
			else if( IBusModelTZTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (IBusModelTZTimeCol)cur );
			}
			else if( IBusModelTZTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (IBusModelTZTimestampDef)cur );
			}
			else if( IBusModelTZTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (IBusModelTZTimestampType)cur );
			}
			else if( IBusModelTZTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (IBusModelTZTimestampCol)cur );
			}
			else if( IBusModelTextDef.CLASS_CODE == subClassCode ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (IBusModelTextDef)cur );
			}
			else if( IBusModelTextType.CLASS_CODE == subClassCode ) {
				schema.getTableTextType().deleteTextType( Authorization, (IBusModelTextType)cur );
			}
			else if( IBusModelTextCol.CLASS_CODE == subClassCode ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (IBusModelTextCol)cur );
			}
			else if( IBusModelTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (IBusModelTimeDef)cur );
			}
			else if( IBusModelTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (IBusModelTimeType)cur );
			}
			else if( IBusModelTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (IBusModelTimeCol)cur );
			}
			else if( IBusModelTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (IBusModelTimestampDef)cur );
			}
			else if( IBusModelTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (IBusModelTimestampType)cur );
			}
			else if( IBusModelTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (IBusModelTimestampCol)cur );
			}
			else if( IBusModelTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (IBusModelTokenDef)cur );
			}
			else if( IBusModelTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (IBusModelTokenType)cur );
			}
			else if( IBusModelTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (IBusModelTokenCol)cur );
			}
			else if( IBusModelUInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (IBusModelUInt16Def)cur );
			}
			else if( IBusModelUInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (IBusModelUInt16Type)cur );
			}
			else if( IBusModelUInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (IBusModelUInt16Col)cur );
			}
			else if( IBusModelUInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (IBusModelUInt32Def)cur );
			}
			else if( IBusModelUInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (IBusModelUInt32Type)cur );
			}
			else if( IBusModelUInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (IBusModelUInt32Col)cur );
			}
			else if( IBusModelUInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (IBusModelUInt64Def)cur );
			}
			else if( IBusModelUInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (IBusModelUInt64Type)cur );
			}
			else if( IBusModelUInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (IBusModelUInt64Col)cur );
			}
			else if( IBusModelUuidDef.CLASS_CODE == subClassCode ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (IBusModelUuidDef)cur );
			}
			else if( IBusModelUuidType.CLASS_CODE == subClassCode ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (IBusModelUuidType)cur );
			}
			else if( IBusModelUuidGen.CLASS_CODE == subClassCode ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (IBusModelUuidGen)cur );
			}
			else if( IBusModelUuidCol.CLASS_CODE == subClassCode ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (IBusModelUuidCol)cur );
			}
			else if( IBusModelUuid6Def.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Def().deleteUuid6Def( Authorization, (IBusModelUuid6Def)cur );
			}
			else if( IBusModelUuid6Type.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Type().deleteUuid6Type( Authorization, (IBusModelUuid6Type)cur );
			}
			else if( IBusModelUuid6Gen.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Gen().deleteUuid6Gen( Authorization, (IBusModelUuid6Gen)cur );
			}
			else if( IBusModelUuid6Col.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Col().deleteUuid6Col( Authorization, (IBusModelUuid6Col)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteAtomByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffValueByPrevIdxKey key = (BusModelBuffValueByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( argPrevId );
		deleteAtomByPrevIdx( Authorization, key );
	}

	@Override
	public void deleteAtomByPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByPrevIdx";
		BusModelBuffAtom cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffAtom> matchSet = new LinkedList<BusModelBuffAtom>();
		Iterator<BusModelBuffAtom> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffAtom> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffAtom)(schema.getTableAtom().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelAtom.CLASS_CODE == subClassCode ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( IBusModelBlobDef.CLASS_CODE == subClassCode ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (IBusModelBlobDef)cur );
			}
			else if( IBusModelBlobType.CLASS_CODE == subClassCode ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (IBusModelBlobType)cur );
			}
			else if( IBusModelBlobCol.CLASS_CODE == subClassCode ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (IBusModelBlobCol)cur );
			}
			else if( IBusModelBoolDef.CLASS_CODE == subClassCode ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (IBusModelBoolDef)cur );
			}
			else if( IBusModelBoolType.CLASS_CODE == subClassCode ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (IBusModelBoolType)cur );
			}
			else if( IBusModelBoolCol.CLASS_CODE == subClassCode ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (IBusModelBoolCol)cur );
			}
			else if( IBusModelDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (IBusModelDateDef)cur );
			}
			else if( IBusModelDateType.CLASS_CODE == subClassCode ) {
				schema.getTableDateType().deleteDateType( Authorization, (IBusModelDateType)cur );
			}
			else if( IBusModelDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (IBusModelDateCol)cur );
			}
			else if( IBusModelDoubleDef.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (IBusModelDoubleDef)cur );
			}
			else if( IBusModelDoubleType.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (IBusModelDoubleType)cur );
			}
			else if( IBusModelDoubleCol.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (IBusModelDoubleCol)cur );
			}
			else if( IBusModelFloatDef.CLASS_CODE == subClassCode ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (IBusModelFloatDef)cur );
			}
			else if( IBusModelFloatType.CLASS_CODE == subClassCode ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (IBusModelFloatType)cur );
			}
			else if( IBusModelFloatCol.CLASS_CODE == subClassCode ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (IBusModelFloatCol)cur );
			}
			else if( IBusModelInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (IBusModelInt16Def)cur );
			}
			else if( IBusModelInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (IBusModelInt16Type)cur );
			}
			else if( IBusModelId16Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (IBusModelId16Gen)cur );
			}
			else if( IBusModelEnumDef.CLASS_CODE == subClassCode ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (IBusModelEnumDef)cur );
			}
			else if( IBusModelEnumType.CLASS_CODE == subClassCode ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (IBusModelEnumType)cur );
			}
			else if( IBusModelInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (IBusModelInt16Col)cur );
			}
			else if( IBusModelInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (IBusModelInt32Def)cur );
			}
			else if( IBusModelInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (IBusModelInt32Type)cur );
			}
			else if( IBusModelId32Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (IBusModelId32Gen)cur );
			}
			else if( IBusModelInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (IBusModelInt32Col)cur );
			}
			else if( IBusModelInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (IBusModelInt64Def)cur );
			}
			else if( IBusModelInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (IBusModelInt64Type)cur );
			}
			else if( IBusModelId64Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (IBusModelId64Gen)cur );
			}
			else if( IBusModelInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (IBusModelInt64Col)cur );
			}
			else if( IBusModelNmTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (IBusModelNmTokenDef)cur );
			}
			else if( IBusModelNmTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (IBusModelNmTokenType)cur );
			}
			else if( IBusModelNmTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (IBusModelNmTokenCol)cur );
			}
			else if( IBusModelNmTokensDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (IBusModelNmTokensDef)cur );
			}
			else if( IBusModelNmTokensType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (IBusModelNmTokensType)cur );
			}
			else if( IBusModelNmTokensCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (IBusModelNmTokensCol)cur );
			}
			else if( IBusModelNumberDef.CLASS_CODE == subClassCode ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (IBusModelNumberDef)cur );
			}
			else if( IBusModelNumberType.CLASS_CODE == subClassCode ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (IBusModelNumberType)cur );
			}
			else if( IBusModelNumberCol.CLASS_CODE == subClassCode ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (IBusModelNumberCol)cur );
			}
			else if( IBusModelDbKeyHash128Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Def().deleteDbKeyHash128Def( Authorization, (IBusModelDbKeyHash128Def)cur );
			}
			else if( IBusModelDbKeyHash128Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Col().deleteDbKeyHash128Col( Authorization, (IBusModelDbKeyHash128Col)cur );
			}
			else if( IBusModelDbKeyHash128Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Type().deleteDbKeyHash128Type( Authorization, (IBusModelDbKeyHash128Type)cur );
			}
			else if( IBusModelDbKeyHash128Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Gen().deleteDbKeyHash128Gen( Authorization, (IBusModelDbKeyHash128Gen)cur );
			}
			else if( IBusModelDbKeyHash160Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Def().deleteDbKeyHash160Def( Authorization, (IBusModelDbKeyHash160Def)cur );
			}
			else if( IBusModelDbKeyHash160Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Col().deleteDbKeyHash160Col( Authorization, (IBusModelDbKeyHash160Col)cur );
			}
			else if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, (IBusModelDbKeyHash160Type)cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else if( IBusModelDbKeyHash224Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Def().deleteDbKeyHash224Def( Authorization, (IBusModelDbKeyHash224Def)cur );
			}
			else if( IBusModelDbKeyHash224Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Col().deleteDbKeyHash224Col( Authorization, (IBusModelDbKeyHash224Col)cur );
			}
			else if( IBusModelDbKeyHash224Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Type().deleteDbKeyHash224Type( Authorization, (IBusModelDbKeyHash224Type)cur );
			}
			else if( IBusModelDbKeyHash224Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Gen().deleteDbKeyHash224Gen( Authorization, (IBusModelDbKeyHash224Gen)cur );
			}
			else if( IBusModelDbKeyHash256Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Def().deleteDbKeyHash256Def( Authorization, (IBusModelDbKeyHash256Def)cur );
			}
			else if( IBusModelDbKeyHash256Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Col().deleteDbKeyHash256Col( Authorization, (IBusModelDbKeyHash256Col)cur );
			}
			else if( IBusModelDbKeyHash256Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Type().deleteDbKeyHash256Type( Authorization, (IBusModelDbKeyHash256Type)cur );
			}
			else if( IBusModelDbKeyHash256Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Gen().deleteDbKeyHash256Gen( Authorization, (IBusModelDbKeyHash256Gen)cur );
			}
			else if( IBusModelDbKeyHash384Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Def().deleteDbKeyHash384Def( Authorization, (IBusModelDbKeyHash384Def)cur );
			}
			else if( IBusModelDbKeyHash384Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Col().deleteDbKeyHash384Col( Authorization, (IBusModelDbKeyHash384Col)cur );
			}
			else if( IBusModelDbKeyHash384Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Type().deleteDbKeyHash384Type( Authorization, (IBusModelDbKeyHash384Type)cur );
			}
			else if( IBusModelDbKeyHash384Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Gen().deleteDbKeyHash384Gen( Authorization, (IBusModelDbKeyHash384Gen)cur );
			}
			else if( IBusModelDbKeyHash512Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Def().deleteDbKeyHash512Def( Authorization, (IBusModelDbKeyHash512Def)cur );
			}
			else if( IBusModelDbKeyHash512Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Col().deleteDbKeyHash512Col( Authorization, (IBusModelDbKeyHash512Col)cur );
			}
			else if( IBusModelDbKeyHash512Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Type().deleteDbKeyHash512Type( Authorization, (IBusModelDbKeyHash512Type)cur );
			}
			else if( IBusModelDbKeyHash512Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Gen().deleteDbKeyHash512Gen( Authorization, (IBusModelDbKeyHash512Gen)cur );
			}
			else if( IBusModelStringDef.CLASS_CODE == subClassCode ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (IBusModelStringDef)cur );
			}
			else if( IBusModelStringType.CLASS_CODE == subClassCode ) {
				schema.getTableStringType().deleteStringType( Authorization, (IBusModelStringType)cur );
			}
			else if( IBusModelStringCol.CLASS_CODE == subClassCode ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (IBusModelStringCol)cur );
			}
			else if( IBusModelTZDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (IBusModelTZDateDef)cur );
			}
			else if( IBusModelTZDateType.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (IBusModelTZDateType)cur );
			}
			else if( IBusModelTZDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (IBusModelTZDateCol)cur );
			}
			else if( IBusModelTZTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (IBusModelTZTimeDef)cur );
			}
			else if( IBusModelTZTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (IBusModelTZTimeType)cur );
			}
			else if( IBusModelTZTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (IBusModelTZTimeCol)cur );
			}
			else if( IBusModelTZTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (IBusModelTZTimestampDef)cur );
			}
			else if( IBusModelTZTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (IBusModelTZTimestampType)cur );
			}
			else if( IBusModelTZTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (IBusModelTZTimestampCol)cur );
			}
			else if( IBusModelTextDef.CLASS_CODE == subClassCode ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (IBusModelTextDef)cur );
			}
			else if( IBusModelTextType.CLASS_CODE == subClassCode ) {
				schema.getTableTextType().deleteTextType( Authorization, (IBusModelTextType)cur );
			}
			else if( IBusModelTextCol.CLASS_CODE == subClassCode ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (IBusModelTextCol)cur );
			}
			else if( IBusModelTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (IBusModelTimeDef)cur );
			}
			else if( IBusModelTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (IBusModelTimeType)cur );
			}
			else if( IBusModelTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (IBusModelTimeCol)cur );
			}
			else if( IBusModelTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (IBusModelTimestampDef)cur );
			}
			else if( IBusModelTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (IBusModelTimestampType)cur );
			}
			else if( IBusModelTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (IBusModelTimestampCol)cur );
			}
			else if( IBusModelTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (IBusModelTokenDef)cur );
			}
			else if( IBusModelTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (IBusModelTokenType)cur );
			}
			else if( IBusModelTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (IBusModelTokenCol)cur );
			}
			else if( IBusModelUInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (IBusModelUInt16Def)cur );
			}
			else if( IBusModelUInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (IBusModelUInt16Type)cur );
			}
			else if( IBusModelUInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (IBusModelUInt16Col)cur );
			}
			else if( IBusModelUInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (IBusModelUInt32Def)cur );
			}
			else if( IBusModelUInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (IBusModelUInt32Type)cur );
			}
			else if( IBusModelUInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (IBusModelUInt32Col)cur );
			}
			else if( IBusModelUInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (IBusModelUInt64Def)cur );
			}
			else if( IBusModelUInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (IBusModelUInt64Type)cur );
			}
			else if( IBusModelUInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (IBusModelUInt64Col)cur );
			}
			else if( IBusModelUuidDef.CLASS_CODE == subClassCode ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (IBusModelUuidDef)cur );
			}
			else if( IBusModelUuidType.CLASS_CODE == subClassCode ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (IBusModelUuidType)cur );
			}
			else if( IBusModelUuidGen.CLASS_CODE == subClassCode ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (IBusModelUuidGen)cur );
			}
			else if( IBusModelUuidCol.CLASS_CODE == subClassCode ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (IBusModelUuidCol)cur );
			}
			else if( IBusModelUuid6Def.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Def().deleteUuid6Def( Authorization, (IBusModelUuid6Def)cur );
			}
			else if( IBusModelUuid6Type.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Type().deleteUuid6Type( Authorization, (IBusModelUuid6Type)cur );
			}
			else if( IBusModelUuid6Gen.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Gen().deleteUuid6Gen( Authorization, (IBusModelUuid6Gen)cur );
			}
			else if( IBusModelUuid6Col.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Col().deleteUuid6Col( Authorization, (IBusModelUuid6Col)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteAtomByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffValueByNextIdxKey key = (BusModelBuffValueByNextIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( argNextId );
		deleteAtomByNextIdx( Authorization, key );
	}

	@Override
	public void deleteAtomByNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByNextIdx";
		BusModelBuffAtom cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffAtom> matchSet = new LinkedList<BusModelBuffAtom>();
		Iterator<BusModelBuffAtom> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffAtom> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffAtom)(schema.getTableAtom().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelAtom.CLASS_CODE == subClassCode ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( IBusModelBlobDef.CLASS_CODE == subClassCode ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (IBusModelBlobDef)cur );
			}
			else if( IBusModelBlobType.CLASS_CODE == subClassCode ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (IBusModelBlobType)cur );
			}
			else if( IBusModelBlobCol.CLASS_CODE == subClassCode ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (IBusModelBlobCol)cur );
			}
			else if( IBusModelBoolDef.CLASS_CODE == subClassCode ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (IBusModelBoolDef)cur );
			}
			else if( IBusModelBoolType.CLASS_CODE == subClassCode ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (IBusModelBoolType)cur );
			}
			else if( IBusModelBoolCol.CLASS_CODE == subClassCode ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (IBusModelBoolCol)cur );
			}
			else if( IBusModelDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (IBusModelDateDef)cur );
			}
			else if( IBusModelDateType.CLASS_CODE == subClassCode ) {
				schema.getTableDateType().deleteDateType( Authorization, (IBusModelDateType)cur );
			}
			else if( IBusModelDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (IBusModelDateCol)cur );
			}
			else if( IBusModelDoubleDef.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (IBusModelDoubleDef)cur );
			}
			else if( IBusModelDoubleType.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (IBusModelDoubleType)cur );
			}
			else if( IBusModelDoubleCol.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (IBusModelDoubleCol)cur );
			}
			else if( IBusModelFloatDef.CLASS_CODE == subClassCode ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (IBusModelFloatDef)cur );
			}
			else if( IBusModelFloatType.CLASS_CODE == subClassCode ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (IBusModelFloatType)cur );
			}
			else if( IBusModelFloatCol.CLASS_CODE == subClassCode ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (IBusModelFloatCol)cur );
			}
			else if( IBusModelInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (IBusModelInt16Def)cur );
			}
			else if( IBusModelInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (IBusModelInt16Type)cur );
			}
			else if( IBusModelId16Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (IBusModelId16Gen)cur );
			}
			else if( IBusModelEnumDef.CLASS_CODE == subClassCode ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (IBusModelEnumDef)cur );
			}
			else if( IBusModelEnumType.CLASS_CODE == subClassCode ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (IBusModelEnumType)cur );
			}
			else if( IBusModelInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (IBusModelInt16Col)cur );
			}
			else if( IBusModelInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (IBusModelInt32Def)cur );
			}
			else if( IBusModelInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (IBusModelInt32Type)cur );
			}
			else if( IBusModelId32Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (IBusModelId32Gen)cur );
			}
			else if( IBusModelInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (IBusModelInt32Col)cur );
			}
			else if( IBusModelInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (IBusModelInt64Def)cur );
			}
			else if( IBusModelInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (IBusModelInt64Type)cur );
			}
			else if( IBusModelId64Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (IBusModelId64Gen)cur );
			}
			else if( IBusModelInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (IBusModelInt64Col)cur );
			}
			else if( IBusModelNmTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (IBusModelNmTokenDef)cur );
			}
			else if( IBusModelNmTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (IBusModelNmTokenType)cur );
			}
			else if( IBusModelNmTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (IBusModelNmTokenCol)cur );
			}
			else if( IBusModelNmTokensDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (IBusModelNmTokensDef)cur );
			}
			else if( IBusModelNmTokensType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (IBusModelNmTokensType)cur );
			}
			else if( IBusModelNmTokensCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (IBusModelNmTokensCol)cur );
			}
			else if( IBusModelNumberDef.CLASS_CODE == subClassCode ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (IBusModelNumberDef)cur );
			}
			else if( IBusModelNumberType.CLASS_CODE == subClassCode ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (IBusModelNumberType)cur );
			}
			else if( IBusModelNumberCol.CLASS_CODE == subClassCode ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (IBusModelNumberCol)cur );
			}
			else if( IBusModelDbKeyHash128Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Def().deleteDbKeyHash128Def( Authorization, (IBusModelDbKeyHash128Def)cur );
			}
			else if( IBusModelDbKeyHash128Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Col().deleteDbKeyHash128Col( Authorization, (IBusModelDbKeyHash128Col)cur );
			}
			else if( IBusModelDbKeyHash128Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Type().deleteDbKeyHash128Type( Authorization, (IBusModelDbKeyHash128Type)cur );
			}
			else if( IBusModelDbKeyHash128Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Gen().deleteDbKeyHash128Gen( Authorization, (IBusModelDbKeyHash128Gen)cur );
			}
			else if( IBusModelDbKeyHash160Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Def().deleteDbKeyHash160Def( Authorization, (IBusModelDbKeyHash160Def)cur );
			}
			else if( IBusModelDbKeyHash160Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Col().deleteDbKeyHash160Col( Authorization, (IBusModelDbKeyHash160Col)cur );
			}
			else if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, (IBusModelDbKeyHash160Type)cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else if( IBusModelDbKeyHash224Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Def().deleteDbKeyHash224Def( Authorization, (IBusModelDbKeyHash224Def)cur );
			}
			else if( IBusModelDbKeyHash224Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Col().deleteDbKeyHash224Col( Authorization, (IBusModelDbKeyHash224Col)cur );
			}
			else if( IBusModelDbKeyHash224Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Type().deleteDbKeyHash224Type( Authorization, (IBusModelDbKeyHash224Type)cur );
			}
			else if( IBusModelDbKeyHash224Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Gen().deleteDbKeyHash224Gen( Authorization, (IBusModelDbKeyHash224Gen)cur );
			}
			else if( IBusModelDbKeyHash256Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Def().deleteDbKeyHash256Def( Authorization, (IBusModelDbKeyHash256Def)cur );
			}
			else if( IBusModelDbKeyHash256Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Col().deleteDbKeyHash256Col( Authorization, (IBusModelDbKeyHash256Col)cur );
			}
			else if( IBusModelDbKeyHash256Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Type().deleteDbKeyHash256Type( Authorization, (IBusModelDbKeyHash256Type)cur );
			}
			else if( IBusModelDbKeyHash256Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Gen().deleteDbKeyHash256Gen( Authorization, (IBusModelDbKeyHash256Gen)cur );
			}
			else if( IBusModelDbKeyHash384Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Def().deleteDbKeyHash384Def( Authorization, (IBusModelDbKeyHash384Def)cur );
			}
			else if( IBusModelDbKeyHash384Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Col().deleteDbKeyHash384Col( Authorization, (IBusModelDbKeyHash384Col)cur );
			}
			else if( IBusModelDbKeyHash384Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Type().deleteDbKeyHash384Type( Authorization, (IBusModelDbKeyHash384Type)cur );
			}
			else if( IBusModelDbKeyHash384Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Gen().deleteDbKeyHash384Gen( Authorization, (IBusModelDbKeyHash384Gen)cur );
			}
			else if( IBusModelDbKeyHash512Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Def().deleteDbKeyHash512Def( Authorization, (IBusModelDbKeyHash512Def)cur );
			}
			else if( IBusModelDbKeyHash512Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Col().deleteDbKeyHash512Col( Authorization, (IBusModelDbKeyHash512Col)cur );
			}
			else if( IBusModelDbKeyHash512Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Type().deleteDbKeyHash512Type( Authorization, (IBusModelDbKeyHash512Type)cur );
			}
			else if( IBusModelDbKeyHash512Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Gen().deleteDbKeyHash512Gen( Authorization, (IBusModelDbKeyHash512Gen)cur );
			}
			else if( IBusModelStringDef.CLASS_CODE == subClassCode ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (IBusModelStringDef)cur );
			}
			else if( IBusModelStringType.CLASS_CODE == subClassCode ) {
				schema.getTableStringType().deleteStringType( Authorization, (IBusModelStringType)cur );
			}
			else if( IBusModelStringCol.CLASS_CODE == subClassCode ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (IBusModelStringCol)cur );
			}
			else if( IBusModelTZDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (IBusModelTZDateDef)cur );
			}
			else if( IBusModelTZDateType.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (IBusModelTZDateType)cur );
			}
			else if( IBusModelTZDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (IBusModelTZDateCol)cur );
			}
			else if( IBusModelTZTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (IBusModelTZTimeDef)cur );
			}
			else if( IBusModelTZTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (IBusModelTZTimeType)cur );
			}
			else if( IBusModelTZTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (IBusModelTZTimeCol)cur );
			}
			else if( IBusModelTZTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (IBusModelTZTimestampDef)cur );
			}
			else if( IBusModelTZTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (IBusModelTZTimestampType)cur );
			}
			else if( IBusModelTZTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (IBusModelTZTimestampCol)cur );
			}
			else if( IBusModelTextDef.CLASS_CODE == subClassCode ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (IBusModelTextDef)cur );
			}
			else if( IBusModelTextType.CLASS_CODE == subClassCode ) {
				schema.getTableTextType().deleteTextType( Authorization, (IBusModelTextType)cur );
			}
			else if( IBusModelTextCol.CLASS_CODE == subClassCode ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (IBusModelTextCol)cur );
			}
			else if( IBusModelTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (IBusModelTimeDef)cur );
			}
			else if( IBusModelTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (IBusModelTimeType)cur );
			}
			else if( IBusModelTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (IBusModelTimeCol)cur );
			}
			else if( IBusModelTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (IBusModelTimestampDef)cur );
			}
			else if( IBusModelTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (IBusModelTimestampType)cur );
			}
			else if( IBusModelTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (IBusModelTimestampCol)cur );
			}
			else if( IBusModelTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (IBusModelTokenDef)cur );
			}
			else if( IBusModelTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (IBusModelTokenType)cur );
			}
			else if( IBusModelTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (IBusModelTokenCol)cur );
			}
			else if( IBusModelUInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (IBusModelUInt16Def)cur );
			}
			else if( IBusModelUInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (IBusModelUInt16Type)cur );
			}
			else if( IBusModelUInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (IBusModelUInt16Col)cur );
			}
			else if( IBusModelUInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (IBusModelUInt32Def)cur );
			}
			else if( IBusModelUInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (IBusModelUInt32Type)cur );
			}
			else if( IBusModelUInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (IBusModelUInt32Col)cur );
			}
			else if( IBusModelUInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (IBusModelUInt64Def)cur );
			}
			else if( IBusModelUInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (IBusModelUInt64Type)cur );
			}
			else if( IBusModelUInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (IBusModelUInt64Col)cur );
			}
			else if( IBusModelUuidDef.CLASS_CODE == subClassCode ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (IBusModelUuidDef)cur );
			}
			else if( IBusModelUuidType.CLASS_CODE == subClassCode ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (IBusModelUuidType)cur );
			}
			else if( IBusModelUuidGen.CLASS_CODE == subClassCode ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (IBusModelUuidGen)cur );
			}
			else if( IBusModelUuidCol.CLASS_CODE == subClassCode ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (IBusModelUuidCol)cur );
			}
			else if( IBusModelUuid6Def.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Def().deleteUuid6Def( Authorization, (IBusModelUuid6Def)cur );
			}
			else if( IBusModelUuid6Type.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Type().deleteUuid6Type( Authorization, (IBusModelUuid6Type)cur );
			}
			else if( IBusModelUuid6Gen.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Gen().deleteUuid6Gen( Authorization, (IBusModelUuid6Gen)cur );
			}
			else if( IBusModelUuid6Col.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Col().deleteUuid6Col( Authorization, (IBusModelUuid6Col)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteAtomByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffValueByContPrevIdxKey key = (BusModelBuffValueByContPrevIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteAtomByContPrevIdx( Authorization, key );
	}

	@Override
	public void deleteAtomByContPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByContPrevIdx";
		BusModelBuffAtom cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffAtom> matchSet = new LinkedList<BusModelBuffAtom>();
		Iterator<BusModelBuffAtom> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffAtom> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffAtom)(schema.getTableAtom().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelAtom.CLASS_CODE == subClassCode ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( IBusModelBlobDef.CLASS_CODE == subClassCode ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (IBusModelBlobDef)cur );
			}
			else if( IBusModelBlobType.CLASS_CODE == subClassCode ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (IBusModelBlobType)cur );
			}
			else if( IBusModelBlobCol.CLASS_CODE == subClassCode ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (IBusModelBlobCol)cur );
			}
			else if( IBusModelBoolDef.CLASS_CODE == subClassCode ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (IBusModelBoolDef)cur );
			}
			else if( IBusModelBoolType.CLASS_CODE == subClassCode ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (IBusModelBoolType)cur );
			}
			else if( IBusModelBoolCol.CLASS_CODE == subClassCode ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (IBusModelBoolCol)cur );
			}
			else if( IBusModelDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (IBusModelDateDef)cur );
			}
			else if( IBusModelDateType.CLASS_CODE == subClassCode ) {
				schema.getTableDateType().deleteDateType( Authorization, (IBusModelDateType)cur );
			}
			else if( IBusModelDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (IBusModelDateCol)cur );
			}
			else if( IBusModelDoubleDef.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (IBusModelDoubleDef)cur );
			}
			else if( IBusModelDoubleType.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (IBusModelDoubleType)cur );
			}
			else if( IBusModelDoubleCol.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (IBusModelDoubleCol)cur );
			}
			else if( IBusModelFloatDef.CLASS_CODE == subClassCode ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (IBusModelFloatDef)cur );
			}
			else if( IBusModelFloatType.CLASS_CODE == subClassCode ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (IBusModelFloatType)cur );
			}
			else if( IBusModelFloatCol.CLASS_CODE == subClassCode ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (IBusModelFloatCol)cur );
			}
			else if( IBusModelInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (IBusModelInt16Def)cur );
			}
			else if( IBusModelInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (IBusModelInt16Type)cur );
			}
			else if( IBusModelId16Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (IBusModelId16Gen)cur );
			}
			else if( IBusModelEnumDef.CLASS_CODE == subClassCode ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (IBusModelEnumDef)cur );
			}
			else if( IBusModelEnumType.CLASS_CODE == subClassCode ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (IBusModelEnumType)cur );
			}
			else if( IBusModelInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (IBusModelInt16Col)cur );
			}
			else if( IBusModelInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (IBusModelInt32Def)cur );
			}
			else if( IBusModelInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (IBusModelInt32Type)cur );
			}
			else if( IBusModelId32Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (IBusModelId32Gen)cur );
			}
			else if( IBusModelInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (IBusModelInt32Col)cur );
			}
			else if( IBusModelInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (IBusModelInt64Def)cur );
			}
			else if( IBusModelInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (IBusModelInt64Type)cur );
			}
			else if( IBusModelId64Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (IBusModelId64Gen)cur );
			}
			else if( IBusModelInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (IBusModelInt64Col)cur );
			}
			else if( IBusModelNmTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (IBusModelNmTokenDef)cur );
			}
			else if( IBusModelNmTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (IBusModelNmTokenType)cur );
			}
			else if( IBusModelNmTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (IBusModelNmTokenCol)cur );
			}
			else if( IBusModelNmTokensDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (IBusModelNmTokensDef)cur );
			}
			else if( IBusModelNmTokensType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (IBusModelNmTokensType)cur );
			}
			else if( IBusModelNmTokensCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (IBusModelNmTokensCol)cur );
			}
			else if( IBusModelNumberDef.CLASS_CODE == subClassCode ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (IBusModelNumberDef)cur );
			}
			else if( IBusModelNumberType.CLASS_CODE == subClassCode ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (IBusModelNumberType)cur );
			}
			else if( IBusModelNumberCol.CLASS_CODE == subClassCode ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (IBusModelNumberCol)cur );
			}
			else if( IBusModelDbKeyHash128Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Def().deleteDbKeyHash128Def( Authorization, (IBusModelDbKeyHash128Def)cur );
			}
			else if( IBusModelDbKeyHash128Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Col().deleteDbKeyHash128Col( Authorization, (IBusModelDbKeyHash128Col)cur );
			}
			else if( IBusModelDbKeyHash128Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Type().deleteDbKeyHash128Type( Authorization, (IBusModelDbKeyHash128Type)cur );
			}
			else if( IBusModelDbKeyHash128Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Gen().deleteDbKeyHash128Gen( Authorization, (IBusModelDbKeyHash128Gen)cur );
			}
			else if( IBusModelDbKeyHash160Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Def().deleteDbKeyHash160Def( Authorization, (IBusModelDbKeyHash160Def)cur );
			}
			else if( IBusModelDbKeyHash160Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Col().deleteDbKeyHash160Col( Authorization, (IBusModelDbKeyHash160Col)cur );
			}
			else if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, (IBusModelDbKeyHash160Type)cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else if( IBusModelDbKeyHash224Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Def().deleteDbKeyHash224Def( Authorization, (IBusModelDbKeyHash224Def)cur );
			}
			else if( IBusModelDbKeyHash224Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Col().deleteDbKeyHash224Col( Authorization, (IBusModelDbKeyHash224Col)cur );
			}
			else if( IBusModelDbKeyHash224Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Type().deleteDbKeyHash224Type( Authorization, (IBusModelDbKeyHash224Type)cur );
			}
			else if( IBusModelDbKeyHash224Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Gen().deleteDbKeyHash224Gen( Authorization, (IBusModelDbKeyHash224Gen)cur );
			}
			else if( IBusModelDbKeyHash256Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Def().deleteDbKeyHash256Def( Authorization, (IBusModelDbKeyHash256Def)cur );
			}
			else if( IBusModelDbKeyHash256Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Col().deleteDbKeyHash256Col( Authorization, (IBusModelDbKeyHash256Col)cur );
			}
			else if( IBusModelDbKeyHash256Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Type().deleteDbKeyHash256Type( Authorization, (IBusModelDbKeyHash256Type)cur );
			}
			else if( IBusModelDbKeyHash256Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Gen().deleteDbKeyHash256Gen( Authorization, (IBusModelDbKeyHash256Gen)cur );
			}
			else if( IBusModelDbKeyHash384Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Def().deleteDbKeyHash384Def( Authorization, (IBusModelDbKeyHash384Def)cur );
			}
			else if( IBusModelDbKeyHash384Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Col().deleteDbKeyHash384Col( Authorization, (IBusModelDbKeyHash384Col)cur );
			}
			else if( IBusModelDbKeyHash384Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Type().deleteDbKeyHash384Type( Authorization, (IBusModelDbKeyHash384Type)cur );
			}
			else if( IBusModelDbKeyHash384Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Gen().deleteDbKeyHash384Gen( Authorization, (IBusModelDbKeyHash384Gen)cur );
			}
			else if( IBusModelDbKeyHash512Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Def().deleteDbKeyHash512Def( Authorization, (IBusModelDbKeyHash512Def)cur );
			}
			else if( IBusModelDbKeyHash512Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Col().deleteDbKeyHash512Col( Authorization, (IBusModelDbKeyHash512Col)cur );
			}
			else if( IBusModelDbKeyHash512Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Type().deleteDbKeyHash512Type( Authorization, (IBusModelDbKeyHash512Type)cur );
			}
			else if( IBusModelDbKeyHash512Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Gen().deleteDbKeyHash512Gen( Authorization, (IBusModelDbKeyHash512Gen)cur );
			}
			else if( IBusModelStringDef.CLASS_CODE == subClassCode ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (IBusModelStringDef)cur );
			}
			else if( IBusModelStringType.CLASS_CODE == subClassCode ) {
				schema.getTableStringType().deleteStringType( Authorization, (IBusModelStringType)cur );
			}
			else if( IBusModelStringCol.CLASS_CODE == subClassCode ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (IBusModelStringCol)cur );
			}
			else if( IBusModelTZDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (IBusModelTZDateDef)cur );
			}
			else if( IBusModelTZDateType.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (IBusModelTZDateType)cur );
			}
			else if( IBusModelTZDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (IBusModelTZDateCol)cur );
			}
			else if( IBusModelTZTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (IBusModelTZTimeDef)cur );
			}
			else if( IBusModelTZTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (IBusModelTZTimeType)cur );
			}
			else if( IBusModelTZTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (IBusModelTZTimeCol)cur );
			}
			else if( IBusModelTZTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (IBusModelTZTimestampDef)cur );
			}
			else if( IBusModelTZTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (IBusModelTZTimestampType)cur );
			}
			else if( IBusModelTZTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (IBusModelTZTimestampCol)cur );
			}
			else if( IBusModelTextDef.CLASS_CODE == subClassCode ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (IBusModelTextDef)cur );
			}
			else if( IBusModelTextType.CLASS_CODE == subClassCode ) {
				schema.getTableTextType().deleteTextType( Authorization, (IBusModelTextType)cur );
			}
			else if( IBusModelTextCol.CLASS_CODE == subClassCode ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (IBusModelTextCol)cur );
			}
			else if( IBusModelTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (IBusModelTimeDef)cur );
			}
			else if( IBusModelTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (IBusModelTimeType)cur );
			}
			else if( IBusModelTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (IBusModelTimeCol)cur );
			}
			else if( IBusModelTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (IBusModelTimestampDef)cur );
			}
			else if( IBusModelTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (IBusModelTimestampType)cur );
			}
			else if( IBusModelTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (IBusModelTimestampCol)cur );
			}
			else if( IBusModelTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (IBusModelTokenDef)cur );
			}
			else if( IBusModelTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (IBusModelTokenType)cur );
			}
			else if( IBusModelTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (IBusModelTokenCol)cur );
			}
			else if( IBusModelUInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (IBusModelUInt16Def)cur );
			}
			else if( IBusModelUInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (IBusModelUInt16Type)cur );
			}
			else if( IBusModelUInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (IBusModelUInt16Col)cur );
			}
			else if( IBusModelUInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (IBusModelUInt32Def)cur );
			}
			else if( IBusModelUInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (IBusModelUInt32Type)cur );
			}
			else if( IBusModelUInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (IBusModelUInt32Col)cur );
			}
			else if( IBusModelUInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (IBusModelUInt64Def)cur );
			}
			else if( IBusModelUInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (IBusModelUInt64Type)cur );
			}
			else if( IBusModelUInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (IBusModelUInt64Col)cur );
			}
			else if( IBusModelUuidDef.CLASS_CODE == subClassCode ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (IBusModelUuidDef)cur );
			}
			else if( IBusModelUuidType.CLASS_CODE == subClassCode ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (IBusModelUuidType)cur );
			}
			else if( IBusModelUuidGen.CLASS_CODE == subClassCode ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (IBusModelUuidGen)cur );
			}
			else if( IBusModelUuidCol.CLASS_CODE == subClassCode ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (IBusModelUuidCol)cur );
			}
			else if( IBusModelUuid6Def.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Def().deleteUuid6Def( Authorization, (IBusModelUuid6Def)cur );
			}
			else if( IBusModelUuid6Type.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Type().deleteUuid6Type( Authorization, (IBusModelUuid6Type)cur );
			}
			else if( IBusModelUuid6Gen.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Gen().deleteUuid6Gen( Authorization, (IBusModelUuid6Gen)cur );
			}
			else if( IBusModelUuid6Col.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Col().deleteUuid6Col( Authorization, (IBusModelUuid6Col)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteAtomByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffValueByContNextIdxKey key = (BusModelBuffValueByContNextIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteAtomByContNextIdx( Authorization, key );
	}

	@Override
	public void deleteAtomByContNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteAtomByContNextIdx";
		BusModelBuffAtom cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffAtom> matchSet = new LinkedList<BusModelBuffAtom>();
		Iterator<BusModelBuffAtom> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffAtom> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffAtom)(schema.getTableAtom().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelAtom.CLASS_CODE == subClassCode ) {
				schema.getTableAtom().deleteAtom( Authorization, cur );
			}
			else if( IBusModelBlobDef.CLASS_CODE == subClassCode ) {
				schema.getTableBlobDef().deleteBlobDef( Authorization, (IBusModelBlobDef)cur );
			}
			else if( IBusModelBlobType.CLASS_CODE == subClassCode ) {
				schema.getTableBlobType().deleteBlobType( Authorization, (IBusModelBlobType)cur );
			}
			else if( IBusModelBlobCol.CLASS_CODE == subClassCode ) {
				schema.getTableBlobCol().deleteBlobCol( Authorization, (IBusModelBlobCol)cur );
			}
			else if( IBusModelBoolDef.CLASS_CODE == subClassCode ) {
				schema.getTableBoolDef().deleteBoolDef( Authorization, (IBusModelBoolDef)cur );
			}
			else if( IBusModelBoolType.CLASS_CODE == subClassCode ) {
				schema.getTableBoolType().deleteBoolType( Authorization, (IBusModelBoolType)cur );
			}
			else if( IBusModelBoolCol.CLASS_CODE == subClassCode ) {
				schema.getTableBoolCol().deleteBoolCol( Authorization, (IBusModelBoolCol)cur );
			}
			else if( IBusModelDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableDateDef().deleteDateDef( Authorization, (IBusModelDateDef)cur );
			}
			else if( IBusModelDateType.CLASS_CODE == subClassCode ) {
				schema.getTableDateType().deleteDateType( Authorization, (IBusModelDateType)cur );
			}
			else if( IBusModelDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableDateCol().deleteDateCol( Authorization, (IBusModelDateCol)cur );
			}
			else if( IBusModelDoubleDef.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleDef().deleteDoubleDef( Authorization, (IBusModelDoubleDef)cur );
			}
			else if( IBusModelDoubleType.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleType().deleteDoubleType( Authorization, (IBusModelDoubleType)cur );
			}
			else if( IBusModelDoubleCol.CLASS_CODE == subClassCode ) {
				schema.getTableDoubleCol().deleteDoubleCol( Authorization, (IBusModelDoubleCol)cur );
			}
			else if( IBusModelFloatDef.CLASS_CODE == subClassCode ) {
				schema.getTableFloatDef().deleteFloatDef( Authorization, (IBusModelFloatDef)cur );
			}
			else if( IBusModelFloatType.CLASS_CODE == subClassCode ) {
				schema.getTableFloatType().deleteFloatType( Authorization, (IBusModelFloatType)cur );
			}
			else if( IBusModelFloatCol.CLASS_CODE == subClassCode ) {
				schema.getTableFloatCol().deleteFloatCol( Authorization, (IBusModelFloatCol)cur );
			}
			else if( IBusModelInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Def().deleteInt16Def( Authorization, (IBusModelInt16Def)cur );
			}
			else if( IBusModelInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Type().deleteInt16Type( Authorization, (IBusModelInt16Type)cur );
			}
			else if( IBusModelId16Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId16Gen().deleteId16Gen( Authorization, (IBusModelId16Gen)cur );
			}
			else if( IBusModelEnumDef.CLASS_CODE == subClassCode ) {
				schema.getTableEnumDef().deleteEnumDef( Authorization, (IBusModelEnumDef)cur );
			}
			else if( IBusModelEnumType.CLASS_CODE == subClassCode ) {
				schema.getTableEnumType().deleteEnumType( Authorization, (IBusModelEnumType)cur );
			}
			else if( IBusModelInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt16Col().deleteInt16Col( Authorization, (IBusModelInt16Col)cur );
			}
			else if( IBusModelInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Def().deleteInt32Def( Authorization, (IBusModelInt32Def)cur );
			}
			else if( IBusModelInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Type().deleteInt32Type( Authorization, (IBusModelInt32Type)cur );
			}
			else if( IBusModelId32Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId32Gen().deleteId32Gen( Authorization, (IBusModelId32Gen)cur );
			}
			else if( IBusModelInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt32Col().deleteInt32Col( Authorization, (IBusModelInt32Col)cur );
			}
			else if( IBusModelInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Def().deleteInt64Def( Authorization, (IBusModelInt64Def)cur );
			}
			else if( IBusModelInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Type().deleteInt64Type( Authorization, (IBusModelInt64Type)cur );
			}
			else if( IBusModelId64Gen.CLASS_CODE == subClassCode ) {
				schema.getTableId64Gen().deleteId64Gen( Authorization, (IBusModelId64Gen)cur );
			}
			else if( IBusModelInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableInt64Col().deleteInt64Col( Authorization, (IBusModelInt64Col)cur );
			}
			else if( IBusModelNmTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenDef().deleteNmTokenDef( Authorization, (IBusModelNmTokenDef)cur );
			}
			else if( IBusModelNmTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenType().deleteNmTokenType( Authorization, (IBusModelNmTokenType)cur );
			}
			else if( IBusModelNmTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokenCol().deleteNmTokenCol( Authorization, (IBusModelNmTokenCol)cur );
			}
			else if( IBusModelNmTokensDef.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensDef().deleteNmTokensDef( Authorization, (IBusModelNmTokensDef)cur );
			}
			else if( IBusModelNmTokensType.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensType().deleteNmTokensType( Authorization, (IBusModelNmTokensType)cur );
			}
			else if( IBusModelNmTokensCol.CLASS_CODE == subClassCode ) {
				schema.getTableNmTokensCol().deleteNmTokensCol( Authorization, (IBusModelNmTokensCol)cur );
			}
			else if( IBusModelNumberDef.CLASS_CODE == subClassCode ) {
				schema.getTableNumberDef().deleteNumberDef( Authorization, (IBusModelNumberDef)cur );
			}
			else if( IBusModelNumberType.CLASS_CODE == subClassCode ) {
				schema.getTableNumberType().deleteNumberType( Authorization, (IBusModelNumberType)cur );
			}
			else if( IBusModelNumberCol.CLASS_CODE == subClassCode ) {
				schema.getTableNumberCol().deleteNumberCol( Authorization, (IBusModelNumberCol)cur );
			}
			else if( IBusModelDbKeyHash128Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Def().deleteDbKeyHash128Def( Authorization, (IBusModelDbKeyHash128Def)cur );
			}
			else if( IBusModelDbKeyHash128Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Col().deleteDbKeyHash128Col( Authorization, (IBusModelDbKeyHash128Col)cur );
			}
			else if( IBusModelDbKeyHash128Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Type().deleteDbKeyHash128Type( Authorization, (IBusModelDbKeyHash128Type)cur );
			}
			else if( IBusModelDbKeyHash128Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash128Gen().deleteDbKeyHash128Gen( Authorization, (IBusModelDbKeyHash128Gen)cur );
			}
			else if( IBusModelDbKeyHash160Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Def().deleteDbKeyHash160Def( Authorization, (IBusModelDbKeyHash160Def)cur );
			}
			else if( IBusModelDbKeyHash160Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Col().deleteDbKeyHash160Col( Authorization, (IBusModelDbKeyHash160Col)cur );
			}
			else if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, (IBusModelDbKeyHash160Type)cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else if( IBusModelDbKeyHash224Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Def().deleteDbKeyHash224Def( Authorization, (IBusModelDbKeyHash224Def)cur );
			}
			else if( IBusModelDbKeyHash224Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Col().deleteDbKeyHash224Col( Authorization, (IBusModelDbKeyHash224Col)cur );
			}
			else if( IBusModelDbKeyHash224Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Type().deleteDbKeyHash224Type( Authorization, (IBusModelDbKeyHash224Type)cur );
			}
			else if( IBusModelDbKeyHash224Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash224Gen().deleteDbKeyHash224Gen( Authorization, (IBusModelDbKeyHash224Gen)cur );
			}
			else if( IBusModelDbKeyHash256Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Def().deleteDbKeyHash256Def( Authorization, (IBusModelDbKeyHash256Def)cur );
			}
			else if( IBusModelDbKeyHash256Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Col().deleteDbKeyHash256Col( Authorization, (IBusModelDbKeyHash256Col)cur );
			}
			else if( IBusModelDbKeyHash256Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Type().deleteDbKeyHash256Type( Authorization, (IBusModelDbKeyHash256Type)cur );
			}
			else if( IBusModelDbKeyHash256Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash256Gen().deleteDbKeyHash256Gen( Authorization, (IBusModelDbKeyHash256Gen)cur );
			}
			else if( IBusModelDbKeyHash384Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Def().deleteDbKeyHash384Def( Authorization, (IBusModelDbKeyHash384Def)cur );
			}
			else if( IBusModelDbKeyHash384Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Col().deleteDbKeyHash384Col( Authorization, (IBusModelDbKeyHash384Col)cur );
			}
			else if( IBusModelDbKeyHash384Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Type().deleteDbKeyHash384Type( Authorization, (IBusModelDbKeyHash384Type)cur );
			}
			else if( IBusModelDbKeyHash384Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash384Gen().deleteDbKeyHash384Gen( Authorization, (IBusModelDbKeyHash384Gen)cur );
			}
			else if( IBusModelDbKeyHash512Def.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Def().deleteDbKeyHash512Def( Authorization, (IBusModelDbKeyHash512Def)cur );
			}
			else if( IBusModelDbKeyHash512Col.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Col().deleteDbKeyHash512Col( Authorization, (IBusModelDbKeyHash512Col)cur );
			}
			else if( IBusModelDbKeyHash512Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Type().deleteDbKeyHash512Type( Authorization, (IBusModelDbKeyHash512Type)cur );
			}
			else if( IBusModelDbKeyHash512Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash512Gen().deleteDbKeyHash512Gen( Authorization, (IBusModelDbKeyHash512Gen)cur );
			}
			else if( IBusModelStringDef.CLASS_CODE == subClassCode ) {
				schema.getTableStringDef().deleteStringDef( Authorization, (IBusModelStringDef)cur );
			}
			else if( IBusModelStringType.CLASS_CODE == subClassCode ) {
				schema.getTableStringType().deleteStringType( Authorization, (IBusModelStringType)cur );
			}
			else if( IBusModelStringCol.CLASS_CODE == subClassCode ) {
				schema.getTableStringCol().deleteStringCol( Authorization, (IBusModelStringCol)cur );
			}
			else if( IBusModelTZDateDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateDef().deleteTZDateDef( Authorization, (IBusModelTZDateDef)cur );
			}
			else if( IBusModelTZDateType.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateType().deleteTZDateType( Authorization, (IBusModelTZDateType)cur );
			}
			else if( IBusModelTZDateCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZDateCol().deleteTZDateCol( Authorization, (IBusModelTZDateCol)cur );
			}
			else if( IBusModelTZTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeDef().deleteTZTimeDef( Authorization, (IBusModelTZTimeDef)cur );
			}
			else if( IBusModelTZTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeType().deleteTZTimeType( Authorization, (IBusModelTZTimeType)cur );
			}
			else if( IBusModelTZTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimeCol().deleteTZTimeCol( Authorization, (IBusModelTZTimeCol)cur );
			}
			else if( IBusModelTZTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampDef().deleteTZTimestampDef( Authorization, (IBusModelTZTimestampDef)cur );
			}
			else if( IBusModelTZTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampType().deleteTZTimestampType( Authorization, (IBusModelTZTimestampType)cur );
			}
			else if( IBusModelTZTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTZTimestampCol().deleteTZTimestampCol( Authorization, (IBusModelTZTimestampCol)cur );
			}
			else if( IBusModelTextDef.CLASS_CODE == subClassCode ) {
				schema.getTableTextDef().deleteTextDef( Authorization, (IBusModelTextDef)cur );
			}
			else if( IBusModelTextType.CLASS_CODE == subClassCode ) {
				schema.getTableTextType().deleteTextType( Authorization, (IBusModelTextType)cur );
			}
			else if( IBusModelTextCol.CLASS_CODE == subClassCode ) {
				schema.getTableTextCol().deleteTextCol( Authorization, (IBusModelTextCol)cur );
			}
			else if( IBusModelTimeDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimeDef().deleteTimeDef( Authorization, (IBusModelTimeDef)cur );
			}
			else if( IBusModelTimeType.CLASS_CODE == subClassCode ) {
				schema.getTableTimeType().deleteTimeType( Authorization, (IBusModelTimeType)cur );
			}
			else if( IBusModelTimeCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimeCol().deleteTimeCol( Authorization, (IBusModelTimeCol)cur );
			}
			else if( IBusModelTimestampDef.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampDef().deleteTimestampDef( Authorization, (IBusModelTimestampDef)cur );
			}
			else if( IBusModelTimestampType.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampType().deleteTimestampType( Authorization, (IBusModelTimestampType)cur );
			}
			else if( IBusModelTimestampCol.CLASS_CODE == subClassCode ) {
				schema.getTableTimestampCol().deleteTimestampCol( Authorization, (IBusModelTimestampCol)cur );
			}
			else if( IBusModelTokenDef.CLASS_CODE == subClassCode ) {
				schema.getTableTokenDef().deleteTokenDef( Authorization, (IBusModelTokenDef)cur );
			}
			else if( IBusModelTokenType.CLASS_CODE == subClassCode ) {
				schema.getTableTokenType().deleteTokenType( Authorization, (IBusModelTokenType)cur );
			}
			else if( IBusModelTokenCol.CLASS_CODE == subClassCode ) {
				schema.getTableTokenCol().deleteTokenCol( Authorization, (IBusModelTokenCol)cur );
			}
			else if( IBusModelUInt16Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Def().deleteUInt16Def( Authorization, (IBusModelUInt16Def)cur );
			}
			else if( IBusModelUInt16Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Type().deleteUInt16Type( Authorization, (IBusModelUInt16Type)cur );
			}
			else if( IBusModelUInt16Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt16Col().deleteUInt16Col( Authorization, (IBusModelUInt16Col)cur );
			}
			else if( IBusModelUInt32Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Def().deleteUInt32Def( Authorization, (IBusModelUInt32Def)cur );
			}
			else if( IBusModelUInt32Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Type().deleteUInt32Type( Authorization, (IBusModelUInt32Type)cur );
			}
			else if( IBusModelUInt32Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt32Col().deleteUInt32Col( Authorization, (IBusModelUInt32Col)cur );
			}
			else if( IBusModelUInt64Def.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Def().deleteUInt64Def( Authorization, (IBusModelUInt64Def)cur );
			}
			else if( IBusModelUInt64Type.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Type().deleteUInt64Type( Authorization, (IBusModelUInt64Type)cur );
			}
			else if( IBusModelUInt64Col.CLASS_CODE == subClassCode ) {
				schema.getTableUInt64Col().deleteUInt64Col( Authorization, (IBusModelUInt64Col)cur );
			}
			else if( IBusModelUuidDef.CLASS_CODE == subClassCode ) {
				schema.getTableUuidDef().deleteUuidDef( Authorization, (IBusModelUuidDef)cur );
			}
			else if( IBusModelUuidType.CLASS_CODE == subClassCode ) {
				schema.getTableUuidType().deleteUuidType( Authorization, (IBusModelUuidType)cur );
			}
			else if( IBusModelUuidGen.CLASS_CODE == subClassCode ) {
				schema.getTableUuidGen().deleteUuidGen( Authorization, (IBusModelUuidGen)cur );
			}
			else if( IBusModelUuidCol.CLASS_CODE == subClassCode ) {
				schema.getTableUuidCol().deleteUuidCol( Authorization, (IBusModelUuidCol)cur );
			}
			else if( IBusModelUuid6Def.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Def().deleteUuid6Def( Authorization, (IBusModelUuid6Def)cur );
			}
			else if( IBusModelUuid6Type.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Type().deleteUuid6Type( Authorization, (IBusModelUuid6Type)cur );
			}
			else if( IBusModelUuid6Gen.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Gen().deleteUuid6Gen( Authorization, (IBusModelUuid6Gen)cur );
			}
			else if( IBusModelUuid6Col.CLASS_CODE == subClassCode ) {
				schema.getTableUuid6Col().deleteUuid6Col( Authorization, (IBusModelUuid6Col)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}
}
