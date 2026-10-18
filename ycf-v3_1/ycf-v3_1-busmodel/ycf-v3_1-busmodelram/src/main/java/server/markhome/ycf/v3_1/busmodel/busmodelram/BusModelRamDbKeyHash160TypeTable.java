
// Description: Java 25 in-memory RAM DbIO implementation for DbKeyHash160Type.

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
 *	BusModelRamDbKeyHash160TypeTable in-memory RAM DbIO implementation
 *	for DbKeyHash160Type.
 */
public class BusModelRamDbKeyHash160TypeTable
	implements IBusModelDbKeyHash160TypeTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffDbKeyHash160Type > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffDbKeyHash160Type >();
	private Map< BusModelBuffDbKeyHash160TypeBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDbKeyHash160Type >> dictBySchemaIdx
		= new HashMap< BusModelBuffDbKeyHash160TypeBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDbKeyHash160Type >>();

	public BusModelRamDbKeyHash160TypeTable( IBusModelSchema argSchema ) {
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
	public IBusModelDbKeyHash160Type createDbKeyHash160Type( ISecureAuthorization Authorization,
		IBusModelDbKeyHash160Type iBuff )
	{
		final String S_ProcName = "createDbKeyHash160Type";
		
		BusModelBuffDbKeyHash160Type Buff = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Def().createDbKeyHash160Def( Authorization,
			iBuff ));
		IBusModelValue tail = null;
		if( Buff.getClassCode() == IBusModelDbKeyHash160Type.CLASS_CODE ) {
			IBusModelValue[] siblings = schema.getTableValue().readDerivedByScopeIdx( Authorization,
				Buff.getRequiredSchemaDefId() );
			for( int idx = 0; ( tail == null ) && ( idx < siblings.length ); idx ++ ) {
				if( ( siblings[idx].getOptionalNextId() == null ) )
				{
					tail = siblings[idx];
				}
			}
			if( tail != null ) {
				Buff.setOptionalLookupPrev(tail.getRequiredId());
			}
			else {
				Buff.setOptionalLookupPrev((IYCFKeyHash256)null);
			}
		}
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDbKeyHash160TypeBySchemaIdxKey keySchemaIdx = (BusModelBuffDbKeyHash160TypeBySchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDbKeyHash160Def().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"DbKeyHash160Def",
						"DbKeyHash160Def",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSchemaDefId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SchemaDef",
						"SchemaDef",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDbKeyHash160Type > subdictSchemaIdx;
		if( dictBySchemaIdx.containsKey( keySchemaIdx ) ) {
			subdictSchemaIdx = dictBySchemaIdx.get( keySchemaIdx );
		}
		else {
			subdictSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDbKeyHash160Type >();
			dictBySchemaIdx.put( keySchemaIdx, subdictSchemaIdx );
		}
		subdictSchemaIdx.put( pkey, Buff );

		if( tail != null ) {
			int tailClassCode = tail.getClassCode();
			if( tailClassCode == IBusModelValue.CLASS_CODE ) {
				IBusModelValue tailEdit = schema.getBusModelBuffFactory().getFactoryValue().newRec();
				tailEdit.set( (IBusModelValue)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableValue().updateValue( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelAtom.CLASS_CODE ) {
				IBusModelAtom tailEdit = schema.getBusModelBuffFactory().getFactoryAtom().newRec();
				tailEdit.set( (IBusModelAtom)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableAtom().updateAtom( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelBlobDef.CLASS_CODE ) {
				IBusModelBlobDef tailEdit = schema.getBusModelBuffFactory().getFactoryBlobDef().newRec();
				tailEdit.set( (IBusModelBlobDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableBlobDef().updateBlobDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelBlobType.CLASS_CODE ) {
				IBusModelBlobType tailEdit = schema.getBusModelBuffFactory().getFactoryBlobType().newRec();
				tailEdit.set( (IBusModelBlobType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableBlobType().updateBlobType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelBlobCol.CLASS_CODE ) {
				IBusModelBlobCol tailEdit = schema.getBusModelBuffFactory().getFactoryBlobCol().newRec();
				tailEdit.set( (IBusModelBlobCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableBlobCol().updateBlobCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelBoolDef.CLASS_CODE ) {
				IBusModelBoolDef tailEdit = schema.getBusModelBuffFactory().getFactoryBoolDef().newRec();
				tailEdit.set( (IBusModelBoolDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableBoolDef().updateBoolDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelBoolType.CLASS_CODE ) {
				IBusModelBoolType tailEdit = schema.getBusModelBuffFactory().getFactoryBoolType().newRec();
				tailEdit.set( (IBusModelBoolType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableBoolType().updateBoolType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelBoolCol.CLASS_CODE ) {
				IBusModelBoolCol tailEdit = schema.getBusModelBuffFactory().getFactoryBoolCol().newRec();
				tailEdit.set( (IBusModelBoolCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableBoolCol().updateBoolCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDateDef.CLASS_CODE ) {
				IBusModelDateDef tailEdit = schema.getBusModelBuffFactory().getFactoryDateDef().newRec();
				tailEdit.set( (IBusModelDateDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDateDef().updateDateDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDateType.CLASS_CODE ) {
				IBusModelDateType tailEdit = schema.getBusModelBuffFactory().getFactoryDateType().newRec();
				tailEdit.set( (IBusModelDateType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDateType().updateDateType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDateCol.CLASS_CODE ) {
				IBusModelDateCol tailEdit = schema.getBusModelBuffFactory().getFactoryDateCol().newRec();
				tailEdit.set( (IBusModelDateCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDateCol().updateDateCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDoubleDef.CLASS_CODE ) {
				IBusModelDoubleDef tailEdit = schema.getBusModelBuffFactory().getFactoryDoubleDef().newRec();
				tailEdit.set( (IBusModelDoubleDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDoubleDef().updateDoubleDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDoubleType.CLASS_CODE ) {
				IBusModelDoubleType tailEdit = schema.getBusModelBuffFactory().getFactoryDoubleType().newRec();
				tailEdit.set( (IBusModelDoubleType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDoubleType().updateDoubleType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDoubleCol.CLASS_CODE ) {
				IBusModelDoubleCol tailEdit = schema.getBusModelBuffFactory().getFactoryDoubleCol().newRec();
				tailEdit.set( (IBusModelDoubleCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDoubleCol().updateDoubleCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelFloatDef.CLASS_CODE ) {
				IBusModelFloatDef tailEdit = schema.getBusModelBuffFactory().getFactoryFloatDef().newRec();
				tailEdit.set( (IBusModelFloatDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableFloatDef().updateFloatDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelFloatType.CLASS_CODE ) {
				IBusModelFloatType tailEdit = schema.getBusModelBuffFactory().getFactoryFloatType().newRec();
				tailEdit.set( (IBusModelFloatType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableFloatType().updateFloatType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelFloatCol.CLASS_CODE ) {
				IBusModelFloatCol tailEdit = schema.getBusModelBuffFactory().getFactoryFloatCol().newRec();
				tailEdit.set( (IBusModelFloatCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableFloatCol().updateFloatCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelInt16Def.CLASS_CODE ) {
				IBusModelInt16Def tailEdit = schema.getBusModelBuffFactory().getFactoryInt16Def().newRec();
				tailEdit.set( (IBusModelInt16Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableInt16Def().updateInt16Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelInt16Type.CLASS_CODE ) {
				IBusModelInt16Type tailEdit = schema.getBusModelBuffFactory().getFactoryInt16Type().newRec();
				tailEdit.set( (IBusModelInt16Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableInt16Type().updateInt16Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelId16Gen.CLASS_CODE ) {
				IBusModelId16Gen tailEdit = schema.getBusModelBuffFactory().getFactoryId16Gen().newRec();
				tailEdit.set( (IBusModelId16Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableId16Gen().updateId16Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelEnumDef.CLASS_CODE ) {
				IBusModelEnumDef tailEdit = schema.getBusModelBuffFactory().getFactoryEnumDef().newRec();
				tailEdit.set( (IBusModelEnumDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableEnumDef().updateEnumDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelEnumType.CLASS_CODE ) {
				IBusModelEnumType tailEdit = schema.getBusModelBuffFactory().getFactoryEnumType().newRec();
				tailEdit.set( (IBusModelEnumType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableEnumType().updateEnumType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelInt16Col.CLASS_CODE ) {
				IBusModelInt16Col tailEdit = schema.getBusModelBuffFactory().getFactoryInt16Col().newRec();
				tailEdit.set( (IBusModelInt16Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableInt16Col().updateInt16Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelInt32Def.CLASS_CODE ) {
				IBusModelInt32Def tailEdit = schema.getBusModelBuffFactory().getFactoryInt32Def().newRec();
				tailEdit.set( (IBusModelInt32Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableInt32Def().updateInt32Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelInt32Type.CLASS_CODE ) {
				IBusModelInt32Type tailEdit = schema.getBusModelBuffFactory().getFactoryInt32Type().newRec();
				tailEdit.set( (IBusModelInt32Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableInt32Type().updateInt32Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelId32Gen.CLASS_CODE ) {
				IBusModelId32Gen tailEdit = schema.getBusModelBuffFactory().getFactoryId32Gen().newRec();
				tailEdit.set( (IBusModelId32Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableId32Gen().updateId32Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelInt32Col.CLASS_CODE ) {
				IBusModelInt32Col tailEdit = schema.getBusModelBuffFactory().getFactoryInt32Col().newRec();
				tailEdit.set( (IBusModelInt32Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableInt32Col().updateInt32Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelInt64Def.CLASS_CODE ) {
				IBusModelInt64Def tailEdit = schema.getBusModelBuffFactory().getFactoryInt64Def().newRec();
				tailEdit.set( (IBusModelInt64Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableInt64Def().updateInt64Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelInt64Type.CLASS_CODE ) {
				IBusModelInt64Type tailEdit = schema.getBusModelBuffFactory().getFactoryInt64Type().newRec();
				tailEdit.set( (IBusModelInt64Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableInt64Type().updateInt64Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelId64Gen.CLASS_CODE ) {
				IBusModelId64Gen tailEdit = schema.getBusModelBuffFactory().getFactoryId64Gen().newRec();
				tailEdit.set( (IBusModelId64Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableId64Gen().updateId64Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelInt64Col.CLASS_CODE ) {
				IBusModelInt64Col tailEdit = schema.getBusModelBuffFactory().getFactoryInt64Col().newRec();
				tailEdit.set( (IBusModelInt64Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableInt64Col().updateInt64Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelNmTokenDef.CLASS_CODE ) {
				IBusModelNmTokenDef tailEdit = schema.getBusModelBuffFactory().getFactoryNmTokenDef().newRec();
				tailEdit.set( (IBusModelNmTokenDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelNmTokenType.CLASS_CODE ) {
				IBusModelNmTokenType tailEdit = schema.getBusModelBuffFactory().getFactoryNmTokenType().newRec();
				tailEdit.set( (IBusModelNmTokenType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableNmTokenType().updateNmTokenType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelNmTokenCol.CLASS_CODE ) {
				IBusModelNmTokenCol tailEdit = schema.getBusModelBuffFactory().getFactoryNmTokenCol().newRec();
				tailEdit.set( (IBusModelNmTokenCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelNmTokensDef.CLASS_CODE ) {
				IBusModelNmTokensDef tailEdit = schema.getBusModelBuffFactory().getFactoryNmTokensDef().newRec();
				tailEdit.set( (IBusModelNmTokensDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelNmTokensType.CLASS_CODE ) {
				IBusModelNmTokensType tailEdit = schema.getBusModelBuffFactory().getFactoryNmTokensType().newRec();
				tailEdit.set( (IBusModelNmTokensType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableNmTokensType().updateNmTokensType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelNmTokensCol.CLASS_CODE ) {
				IBusModelNmTokensCol tailEdit = schema.getBusModelBuffFactory().getFactoryNmTokensCol().newRec();
				tailEdit.set( (IBusModelNmTokensCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelNumberDef.CLASS_CODE ) {
				IBusModelNumberDef tailEdit = schema.getBusModelBuffFactory().getFactoryNumberDef().newRec();
				tailEdit.set( (IBusModelNumberDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableNumberDef().updateNumberDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelNumberType.CLASS_CODE ) {
				IBusModelNumberType tailEdit = schema.getBusModelBuffFactory().getFactoryNumberType().newRec();
				tailEdit.set( (IBusModelNumberType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableNumberType().updateNumberType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelNumberCol.CLASS_CODE ) {
				IBusModelNumberCol tailEdit = schema.getBusModelBuffFactory().getFactoryNumberCol().newRec();
				tailEdit.set( (IBusModelNumberCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableNumberCol().updateNumberCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
				IBusModelDbKeyHash128Def tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Def().newRec();
				tailEdit.set( (IBusModelDbKeyHash128Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash128Def().updateDbKeyHash128Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
				IBusModelDbKeyHash128Col tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Col().newRec();
				tailEdit.set( (IBusModelDbKeyHash128Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash128Col().updateDbKeyHash128Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
				IBusModelDbKeyHash128Type tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Type().newRec();
				tailEdit.set( (IBusModelDbKeyHash128Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash128Type().updateDbKeyHash128Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
				IBusModelDbKeyHash128Gen tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash128Gen().newRec();
				tailEdit.set( (IBusModelDbKeyHash128Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash128Gen().updateDbKeyHash128Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
				IBusModelDbKeyHash160Def tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Def().newRec();
				tailEdit.set( (IBusModelDbKeyHash160Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
				IBusModelDbKeyHash160Col tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Col().newRec();
				tailEdit.set( (IBusModelDbKeyHash160Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash160Col().updateDbKeyHash160Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
				IBusModelDbKeyHash160Type tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec();
				tailEdit.set( (IBusModelDbKeyHash160Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash160Type().updateDbKeyHash160Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
				IBusModelDbKeyHash160Gen tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec();
				tailEdit.set( (IBusModelDbKeyHash160Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash160Gen().updateDbKeyHash160Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
				IBusModelDbKeyHash224Def tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Def().newRec();
				tailEdit.set( (IBusModelDbKeyHash224Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash224Def().updateDbKeyHash224Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
				IBusModelDbKeyHash224Col tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Col().newRec();
				tailEdit.set( (IBusModelDbKeyHash224Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash224Col().updateDbKeyHash224Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
				IBusModelDbKeyHash224Type tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Type().newRec();
				tailEdit.set( (IBusModelDbKeyHash224Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash224Type().updateDbKeyHash224Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
				IBusModelDbKeyHash224Gen tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash224Gen().newRec();
				tailEdit.set( (IBusModelDbKeyHash224Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash224Gen().updateDbKeyHash224Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
				IBusModelDbKeyHash256Def tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Def().newRec();
				tailEdit.set( (IBusModelDbKeyHash256Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash256Def().updateDbKeyHash256Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
				IBusModelDbKeyHash256Col tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Col().newRec();
				tailEdit.set( (IBusModelDbKeyHash256Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash256Col().updateDbKeyHash256Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
				IBusModelDbKeyHash256Type tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Type().newRec();
				tailEdit.set( (IBusModelDbKeyHash256Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash256Type().updateDbKeyHash256Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
				IBusModelDbKeyHash256Gen tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash256Gen().newRec();
				tailEdit.set( (IBusModelDbKeyHash256Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash256Gen().updateDbKeyHash256Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
				IBusModelDbKeyHash384Def tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Def().newRec();
				tailEdit.set( (IBusModelDbKeyHash384Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash384Def().updateDbKeyHash384Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
				IBusModelDbKeyHash384Col tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Col().newRec();
				tailEdit.set( (IBusModelDbKeyHash384Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash384Col().updateDbKeyHash384Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
				IBusModelDbKeyHash384Type tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Type().newRec();
				tailEdit.set( (IBusModelDbKeyHash384Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash384Type().updateDbKeyHash384Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
				IBusModelDbKeyHash384Gen tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash384Gen().newRec();
				tailEdit.set( (IBusModelDbKeyHash384Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash384Gen().updateDbKeyHash384Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
				IBusModelDbKeyHash512Def tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Def().newRec();
				tailEdit.set( (IBusModelDbKeyHash512Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash512Def().updateDbKeyHash512Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
				IBusModelDbKeyHash512Col tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Col().newRec();
				tailEdit.set( (IBusModelDbKeyHash512Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash512Col().updateDbKeyHash512Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
				IBusModelDbKeyHash512Type tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Type().newRec();
				tailEdit.set( (IBusModelDbKeyHash512Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash512Type().updateDbKeyHash512Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
				IBusModelDbKeyHash512Gen tailEdit = schema.getBusModelBuffFactory().getFactoryDbKeyHash512Gen().newRec();
				tailEdit.set( (IBusModelDbKeyHash512Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDbKeyHash512Gen().updateDbKeyHash512Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelStringDef.CLASS_CODE ) {
				IBusModelStringDef tailEdit = schema.getBusModelBuffFactory().getFactoryStringDef().newRec();
				tailEdit.set( (IBusModelStringDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableStringDef().updateStringDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelStringType.CLASS_CODE ) {
				IBusModelStringType tailEdit = schema.getBusModelBuffFactory().getFactoryStringType().newRec();
				tailEdit.set( (IBusModelStringType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableStringType().updateStringType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelStringCol.CLASS_CODE ) {
				IBusModelStringCol tailEdit = schema.getBusModelBuffFactory().getFactoryStringCol().newRec();
				tailEdit.set( (IBusModelStringCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableStringCol().updateStringCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTZDateDef.CLASS_CODE ) {
				IBusModelTZDateDef tailEdit = schema.getBusModelBuffFactory().getFactoryTZDateDef().newRec();
				tailEdit.set( (IBusModelTZDateDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTZDateDef().updateTZDateDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTZDateType.CLASS_CODE ) {
				IBusModelTZDateType tailEdit = schema.getBusModelBuffFactory().getFactoryTZDateType().newRec();
				tailEdit.set( (IBusModelTZDateType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTZDateType().updateTZDateType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTZDateCol.CLASS_CODE ) {
				IBusModelTZDateCol tailEdit = schema.getBusModelBuffFactory().getFactoryTZDateCol().newRec();
				tailEdit.set( (IBusModelTZDateCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTZDateCol().updateTZDateCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTZTimeDef.CLASS_CODE ) {
				IBusModelTZTimeDef tailEdit = schema.getBusModelBuffFactory().getFactoryTZTimeDef().newRec();
				tailEdit.set( (IBusModelTZTimeDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTZTimeType.CLASS_CODE ) {
				IBusModelTZTimeType tailEdit = schema.getBusModelBuffFactory().getFactoryTZTimeType().newRec();
				tailEdit.set( (IBusModelTZTimeType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTZTimeType().updateTZTimeType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTZTimeCol.CLASS_CODE ) {
				IBusModelTZTimeCol tailEdit = schema.getBusModelBuffFactory().getFactoryTZTimeCol().newRec();
				tailEdit.set( (IBusModelTZTimeCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTZTimestampDef.CLASS_CODE ) {
				IBusModelTZTimestampDef tailEdit = schema.getBusModelBuffFactory().getFactoryTZTimestampDef().newRec();
				tailEdit.set( (IBusModelTZTimestampDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTZTimestampType.CLASS_CODE ) {
				IBusModelTZTimestampType tailEdit = schema.getBusModelBuffFactory().getFactoryTZTimestampType().newRec();
				tailEdit.set( (IBusModelTZTimestampType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTZTimestampCol.CLASS_CODE ) {
				IBusModelTZTimestampCol tailEdit = schema.getBusModelBuffFactory().getFactoryTZTimestampCol().newRec();
				tailEdit.set( (IBusModelTZTimestampCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTextDef.CLASS_CODE ) {
				IBusModelTextDef tailEdit = schema.getBusModelBuffFactory().getFactoryTextDef().newRec();
				tailEdit.set( (IBusModelTextDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTextDef().updateTextDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTextType.CLASS_CODE ) {
				IBusModelTextType tailEdit = schema.getBusModelBuffFactory().getFactoryTextType().newRec();
				tailEdit.set( (IBusModelTextType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTextType().updateTextType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTextCol.CLASS_CODE ) {
				IBusModelTextCol tailEdit = schema.getBusModelBuffFactory().getFactoryTextCol().newRec();
				tailEdit.set( (IBusModelTextCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTextCol().updateTextCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTimeDef.CLASS_CODE ) {
				IBusModelTimeDef tailEdit = schema.getBusModelBuffFactory().getFactoryTimeDef().newRec();
				tailEdit.set( (IBusModelTimeDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTimeDef().updateTimeDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTimeType.CLASS_CODE ) {
				IBusModelTimeType tailEdit = schema.getBusModelBuffFactory().getFactoryTimeType().newRec();
				tailEdit.set( (IBusModelTimeType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTimeType().updateTimeType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTimeCol.CLASS_CODE ) {
				IBusModelTimeCol tailEdit = schema.getBusModelBuffFactory().getFactoryTimeCol().newRec();
				tailEdit.set( (IBusModelTimeCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTimeCol().updateTimeCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTimestampDef.CLASS_CODE ) {
				IBusModelTimestampDef tailEdit = schema.getBusModelBuffFactory().getFactoryTimestampDef().newRec();
				tailEdit.set( (IBusModelTimestampDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTimestampDef().updateTimestampDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTimestampType.CLASS_CODE ) {
				IBusModelTimestampType tailEdit = schema.getBusModelBuffFactory().getFactoryTimestampType().newRec();
				tailEdit.set( (IBusModelTimestampType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTimestampType().updateTimestampType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTimestampCol.CLASS_CODE ) {
				IBusModelTimestampCol tailEdit = schema.getBusModelBuffFactory().getFactoryTimestampCol().newRec();
				tailEdit.set( (IBusModelTimestampCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTimestampCol().updateTimestampCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTokenDef.CLASS_CODE ) {
				IBusModelTokenDef tailEdit = schema.getBusModelBuffFactory().getFactoryTokenDef().newRec();
				tailEdit.set( (IBusModelTokenDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTokenDef().updateTokenDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTokenType.CLASS_CODE ) {
				IBusModelTokenType tailEdit = schema.getBusModelBuffFactory().getFactoryTokenType().newRec();
				tailEdit.set( (IBusModelTokenType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTokenType().updateTokenType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTokenCol.CLASS_CODE ) {
				IBusModelTokenCol tailEdit = schema.getBusModelBuffFactory().getFactoryTokenCol().newRec();
				tailEdit.set( (IBusModelTokenCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTokenCol().updateTokenCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUInt16Def.CLASS_CODE ) {
				IBusModelUInt16Def tailEdit = schema.getBusModelBuffFactory().getFactoryUInt16Def().newRec();
				tailEdit.set( (IBusModelUInt16Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUInt16Def().updateUInt16Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUInt16Type.CLASS_CODE ) {
				IBusModelUInt16Type tailEdit = schema.getBusModelBuffFactory().getFactoryUInt16Type().newRec();
				tailEdit.set( (IBusModelUInt16Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUInt16Type().updateUInt16Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUInt16Col.CLASS_CODE ) {
				IBusModelUInt16Col tailEdit = schema.getBusModelBuffFactory().getFactoryUInt16Col().newRec();
				tailEdit.set( (IBusModelUInt16Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUInt16Col().updateUInt16Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUInt32Def.CLASS_CODE ) {
				IBusModelUInt32Def tailEdit = schema.getBusModelBuffFactory().getFactoryUInt32Def().newRec();
				tailEdit.set( (IBusModelUInt32Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUInt32Def().updateUInt32Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUInt32Type.CLASS_CODE ) {
				IBusModelUInt32Type tailEdit = schema.getBusModelBuffFactory().getFactoryUInt32Type().newRec();
				tailEdit.set( (IBusModelUInt32Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUInt32Type().updateUInt32Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUInt32Col.CLASS_CODE ) {
				IBusModelUInt32Col tailEdit = schema.getBusModelBuffFactory().getFactoryUInt32Col().newRec();
				tailEdit.set( (IBusModelUInt32Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUInt32Col().updateUInt32Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUInt64Def.CLASS_CODE ) {
				IBusModelUInt64Def tailEdit = schema.getBusModelBuffFactory().getFactoryUInt64Def().newRec();
				tailEdit.set( (IBusModelUInt64Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUInt64Def().updateUInt64Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUInt64Type.CLASS_CODE ) {
				IBusModelUInt64Type tailEdit = schema.getBusModelBuffFactory().getFactoryUInt64Type().newRec();
				tailEdit.set( (IBusModelUInt64Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUInt64Type().updateUInt64Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUInt64Col.CLASS_CODE ) {
				IBusModelUInt64Col tailEdit = schema.getBusModelBuffFactory().getFactoryUInt64Col().newRec();
				tailEdit.set( (IBusModelUInt64Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUInt64Col().updateUInt64Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUuidDef.CLASS_CODE ) {
				IBusModelUuidDef tailEdit = schema.getBusModelBuffFactory().getFactoryUuidDef().newRec();
				tailEdit.set( (IBusModelUuidDef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUuidDef().updateUuidDef( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUuidType.CLASS_CODE ) {
				IBusModelUuidType tailEdit = schema.getBusModelBuffFactory().getFactoryUuidType().newRec();
				tailEdit.set( (IBusModelUuidType)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUuidType().updateUuidType( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUuidGen.CLASS_CODE ) {
				IBusModelUuidGen tailEdit = schema.getBusModelBuffFactory().getFactoryUuidGen().newRec();
				tailEdit.set( (IBusModelUuidGen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUuidGen().updateUuidGen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUuidCol.CLASS_CODE ) {
				IBusModelUuidCol tailEdit = schema.getBusModelBuffFactory().getFactoryUuidCol().newRec();
				tailEdit.set( (IBusModelUuidCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUuidCol().updateUuidCol( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUuid6Def.CLASS_CODE ) {
				IBusModelUuid6Def tailEdit = schema.getBusModelBuffFactory().getFactoryUuid6Def().newRec();
				tailEdit.set( (IBusModelUuid6Def)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUuid6Def().updateUuid6Def( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUuid6Type.CLASS_CODE ) {
				IBusModelUuid6Type tailEdit = schema.getBusModelBuffFactory().getFactoryUuid6Type().newRec();
				tailEdit.set( (IBusModelUuid6Type)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUuid6Type().updateUuid6Type( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUuid6Gen.CLASS_CODE ) {
				IBusModelUuid6Gen tailEdit = schema.getBusModelBuffFactory().getFactoryUuid6Gen().newRec();
				tailEdit.set( (IBusModelUuid6Gen)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUuid6Gen().updateUuid6Gen( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelUuid6Col.CLASS_CODE ) {
				IBusModelUuid6Col tailEdit = schema.getBusModelBuffFactory().getFactoryUuid6Col().newRec();
				tailEdit.set( (IBusModelUuid6Col)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableUuid6Col().updateUuid6Col( Authorization, tailEdit );
			}
			else if( tailClassCode == IBusModelTableCol.CLASS_CODE ) {
				IBusModelTableCol tailEdit = schema.getBusModelBuffFactory().getFactoryTableCol().newRec();
				tailEdit.set( (IBusModelTableCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableTableCol().updateTableCol( Authorization, tailEdit );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-table-chain-link-tail-", (Integer)tailClassCode, "Classcode not recognized: " + Integer.toString(tailClassCode));
			}
		}
		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelDbKeyHash160Type.CLASS_CODE) {
				BusModelBuffDbKeyHash160Type retbuff = ((BusModelBuffDbKeyHash160Type)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDbKeyHash160Gen.CLASS_CODE) {
				BusModelBuffDbKeyHash160Gen retbuff = ((BusModelBuffDbKeyHash160Gen)(schema.getBusModelBuffFactory().getFactoryDbKeyHash160Gen().newRec()));
				retbuff.set((IBusModelDbKeyHash160Gen)Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelDbKeyHash160Type readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDbKeyHash160Type.readDerived";
		IBusModelDbKeyHash160Type buff;
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
	public IBusModelDbKeyHash160Type lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDbKeyHash160Type.lockDerived";
		IBusModelDbKeyHash160Type buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDbKeyHash160Type[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamDbKeyHash160Type.readAllDerived";
		IBusModelDbKeyHash160Type[] retList = new IBusModelDbKeyHash160Type[ dictByPKey.values().size() ];
		Iterator< BusModelBuffDbKeyHash160Type > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelDbKeyHash160Type readDerivedByUNameIdx( ISecureAuthorization Authorization,
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
		else if( buff instanceof IBusModelDbKeyHash160Type ) {
			return( (IBusModelDbKeyHash160Type)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDbKeyHash160Type ) ) {
					filteredList.add( (IBusModelDbKeyHash160Type)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDbKeyHash160Type ) ) {
					filteredList.add( (IBusModelDbKeyHash160Type)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDbKeyHash160Type ) ) {
					filteredList.add( (IBusModelDbKeyHash160Type)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type[] readDerivedByNextIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDbKeyHash160Type ) ) {
					filteredList.add( (IBusModelDbKeyHash160Type)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type[] readDerivedByContPrevIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDbKeyHash160Type ) ) {
					filteredList.add( (IBusModelDbKeyHash160Type)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type[] readDerivedByContNextIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDbKeyHash160Type ) ) {
					filteredList.add( (IBusModelDbKeyHash160Type)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type[] readDerivedBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "BusModelRamDbKeyHash160Type.readDerivedBySchemaIdx";
		BusModelBuffDbKeyHash160TypeBySchemaIdxKey key = (BusModelBuffDbKeyHash160TypeBySchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newBySchemaIdxKey();

		key.setRequiredSchemaDefId( SchemaDefId );
		IBusModelDbKeyHash160Type[] recArray;
		if( dictBySchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDbKeyHash160Type > subdictSchemaIdx
				= dictBySchemaIdx.get( key );
			recArray = new IBusModelDbKeyHash160Type[ subdictSchemaIdx.size() ];
			Iterator< BusModelBuffDbKeyHash160Type > iter = subdictSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDbKeyHash160Type > subdictSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDbKeyHash160Type >();
			dictBySchemaIdx.put( key, subdictSchemaIdx );
			recArray = new IBusModelDbKeyHash160Type[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelDbKeyHash160Type readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamValue.readDerivedByIdIdx() ";
		IBusModelDbKeyHash160Type buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDbKeyHash160Type readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDbKeyHash160Type.readRec";
		IBusModelDbKeyHash160Type buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDbKeyHash160Type.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDbKeyHash160Type lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelDbKeyHash160Type buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDbKeyHash160Type.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDbKeyHash160Type[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamDbKeyHash160Type.readAllRec";
		IBusModelDbKeyHash160Type buff;
		ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
		IBusModelDbKeyHash160Type[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDbKeyHash160Type.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
	}

	@Override
	public IBusModelDbKeyHash160Type readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamValue.readRecByIdIdx() ";
		IBusModelDbKeyHash160Type buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
			return( (IBusModelDbKeyHash160Type)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamValue.readRecByUNameIdx() ";
		IBusModelDbKeyHash160Type buff = readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
			return( (IBusModelDbKeyHash160Type)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByScopeIdx() ";
		IBusModelDbKeyHash160Type buff;
		ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
		IBusModelDbKeyHash160Type[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDbKeyHash160Type)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
	}

	@Override
	public IBusModelDbKeyHash160Type[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByDefSchemaIdx() ";
		IBusModelDbKeyHash160Type buff;
		ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
		IBusModelDbKeyHash160Type[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDbKeyHash160Type)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
	}

	@Override
	public IBusModelDbKeyHash160Type[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByPrevIdx() ";
		IBusModelDbKeyHash160Type buff;
		ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
		IBusModelDbKeyHash160Type[] buffList = readDerivedByPrevIdx( Authorization,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDbKeyHash160Type)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
	}

	@Override
	public IBusModelDbKeyHash160Type[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByNextIdx() ";
		IBusModelDbKeyHash160Type buff;
		ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
		IBusModelDbKeyHash160Type[] buffList = readDerivedByNextIdx( Authorization,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDbKeyHash160Type)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
	}

	@Override
	public IBusModelDbKeyHash160Type[] readRecByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByContPrevIdx() ";
		IBusModelDbKeyHash160Type buff;
		ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
		IBusModelDbKeyHash160Type[] buffList = readDerivedByContPrevIdx( Authorization,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDbKeyHash160Type)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
	}

	@Override
	public IBusModelDbKeyHash160Type[] readRecByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamValue.readRecByContNextIdx() ";
		IBusModelDbKeyHash160Type buff;
		ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
		IBusModelDbKeyHash160Type[] buffList = readDerivedByContNextIdx( Authorization,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelValue.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDbKeyHash160Type)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
	}

	@Override
	public IBusModelDbKeyHash160Type[] readRecBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "BusModelRamDbKeyHash160Type.readRecBySchemaIdx() ";
		IBusModelDbKeyHash160Type buff;
		ArrayList<IBusModelDbKeyHash160Type> filteredList = new ArrayList<IBusModelDbKeyHash160Type>();
		IBusModelDbKeyHash160Type[] buffList = readDerivedBySchemaIdx( Authorization,
			SchemaDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDbKeyHash160Type.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDbKeyHash160Type)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDbKeyHash160Type[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelDbKeyHash160Type moveRecUp( ISecureAuthorization Authorization,
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
			return( (BusModelBuffDbKeyHash160Type)cur );
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

		return( (BusModelBuffDbKeyHash160Type)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelDbKeyHash160Type moveRecDown( ISecureAuthorization Authorization,
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
			return( (BusModelBuffDbKeyHash160Type)cur );
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

		return( (BusModelBuffDbKeyHash160Type)editCur );
	}

	public IBusModelDbKeyHash160Type updateDbKeyHash160Type( ISecureAuthorization Authorization,
		IBusModelDbKeyHash160Type iBuff )
	{
		BusModelBuffDbKeyHash160Type Buff = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Def().updateDbKeyHash160Def( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDbKeyHash160Type existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateDbKeyHash160Type",
				"Existing record not found",
				"Existing record not found",
				"DbKeyHash160Type",
				"DbKeyHash160Type",
				pkey );
		}
		BusModelBuffDbKeyHash160TypeBySchemaIdxKey existingKeySchemaIdx = (BusModelBuffDbKeyHash160TypeBySchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newBySchemaIdxKey();
		existingKeySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		BusModelBuffDbKeyHash160TypeBySchemaIdxKey newKeySchemaIdx = (BusModelBuffDbKeyHash160TypeBySchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newBySchemaIdxKey();
		newKeySchemaIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDbKeyHash160Def().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateDbKeyHash160Type",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"DbKeyHash160Def",
						"DbKeyHash160Def",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSchemaDefId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateDbKeyHash160Type",
						"Container",
						"Container",
						"SchemaDef",
						"SchemaDef",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDbKeyHash160Type > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySchemaIdx.get( existingKeySchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchemaIdx.containsKey( newKeySchemaIdx ) ) {
			subdict = dictBySchemaIdx.get( newKeySchemaIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDbKeyHash160Type >();
			dictBySchemaIdx.put( newKeySchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteDbKeyHash160Type( ISecureAuthorization Authorization,
		IBusModelDbKeyHash160Type iBuff )
	{
		final String S_ProcName = "BusModelRamDbKeyHash160TypeTable.deleteDbKeyHash160Type() ";
		BusModelBuffDbKeyHash160Type Buff = (BusModelBuffDbKeyHash160Type)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffDbKeyHash160Type existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteDbKeyHash160Type",
				pkey );
		}
		IYCFKeyHash256 varSchemaDefId = existing.getRequiredSchemaDefId();
		BusModelBuffSchemaDef container = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
			varSchemaDefId ));
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
		BusModelBuffDbKeyHash160TypeBySchemaIdxKey keySchemaIdx = (BusModelBuffDbKeyHash160TypeBySchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		// Validate reverse foreign keys

		if( schema.getTableDbKeyHash160Gen().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteDbKeyHash160Type",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DbKeyHash160Gen",
				"DbKeyHash160Gen",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffDbKeyHash160Type > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySchemaIdx.get( keySchemaIdx );
		subdict.remove( pkey );

		schema.getTableDbKeyHash160Def().deleteDbKeyHash160Def( Authorization,
			Buff );
	}
	@Override
	public void deleteDbKeyHash160TypeBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		BusModelBuffDbKeyHash160TypeBySchemaIdxKey key = (BusModelBuffDbKeyHash160TypeBySchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDbKeyHash160Type().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( argSchemaDefId );
		deleteDbKeyHash160TypeBySchemaIdx( Authorization, key );
	}

	@Override
	public void deleteDbKeyHash160TypeBySchemaIdx( ISecureAuthorization Authorization,
		IBusModelDbKeyHash160TypeBySchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash160TypeBySchemaIdx";
		BusModelBuffDbKeyHash160Type cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDbKeyHash160Type> matchSet = new LinkedList<BusModelBuffDbKeyHash160Type>();
		Iterator<BusModelBuffDbKeyHash160Type> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDbKeyHash160Type> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Type().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDbKeyHash160TypeByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteDbKeyHash160TypeByIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffDbKeyHash160Type cur;
		LinkedList<BusModelBuffDbKeyHash160Type> matchSet = new LinkedList<BusModelBuffDbKeyHash160Type>();
		Iterator<BusModelBuffDbKeyHash160Type> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDbKeyHash160Type> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Type().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDbKeyHash160TypeByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		BusModelBuffValueByUNameIdxKey key = (BusModelBuffValueByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteDbKeyHash160TypeByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteDbKeyHash160TypeByUNameIdx( ISecureAuthorization Authorization,
		IBusModelValueByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash160TypeByUNameIdx";
		BusModelBuffDbKeyHash160Type cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDbKeyHash160Type> matchSet = new LinkedList<BusModelBuffDbKeyHash160Type>();
		Iterator<BusModelBuffDbKeyHash160Type> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDbKeyHash160Type> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Type().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDbKeyHash160TypeByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		BusModelBuffValueByScopeIdxKey key = (BusModelBuffValueByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( argScopeId );
		deleteDbKeyHash160TypeByScopeIdx( Authorization, key );
	}

	@Override
	public void deleteDbKeyHash160TypeByScopeIdx( ISecureAuthorization Authorization,
		IBusModelValueByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash160TypeByScopeIdx";
		BusModelBuffDbKeyHash160Type cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDbKeyHash160Type> matchSet = new LinkedList<BusModelBuffDbKeyHash160Type>();
		Iterator<BusModelBuffDbKeyHash160Type> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDbKeyHash160Type> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Type().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDbKeyHash160TypeByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffValueByDefSchemaIdxKey key = (BusModelBuffValueByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDbKeyHash160TypeByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteDbKeyHash160TypeByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelValueByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash160TypeByDefSchemaIdx";
		BusModelBuffDbKeyHash160Type cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDbKeyHash160Type> matchSet = new LinkedList<BusModelBuffDbKeyHash160Type>();
		Iterator<BusModelBuffDbKeyHash160Type> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDbKeyHash160Type> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Type().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDbKeyHash160TypeByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffValueByPrevIdxKey key = (BusModelBuffValueByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( argPrevId );
		deleteDbKeyHash160TypeByPrevIdx( Authorization, key );
	}

	@Override
	public void deleteDbKeyHash160TypeByPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash160TypeByPrevIdx";
		BusModelBuffDbKeyHash160Type cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDbKeyHash160Type> matchSet = new LinkedList<BusModelBuffDbKeyHash160Type>();
		Iterator<BusModelBuffDbKeyHash160Type> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDbKeyHash160Type> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Type().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDbKeyHash160TypeByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffValueByNextIdxKey key = (BusModelBuffValueByNextIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( argNextId );
		deleteDbKeyHash160TypeByNextIdx( Authorization, key );
	}

	@Override
	public void deleteDbKeyHash160TypeByNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByNextIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash160TypeByNextIdx";
		BusModelBuffDbKeyHash160Type cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDbKeyHash160Type> matchSet = new LinkedList<BusModelBuffDbKeyHash160Type>();
		Iterator<BusModelBuffDbKeyHash160Type> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDbKeyHash160Type> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Type().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDbKeyHash160TypeByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffValueByContPrevIdxKey key = (BusModelBuffValueByContPrevIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteDbKeyHash160TypeByContPrevIdx( Authorization, key );
	}

	@Override
	public void deleteDbKeyHash160TypeByContPrevIdx( ISecureAuthorization Authorization,
		IBusModelValueByContPrevIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash160TypeByContPrevIdx";
		BusModelBuffDbKeyHash160Type cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDbKeyHash160Type> matchSet = new LinkedList<BusModelBuffDbKeyHash160Type>();
		Iterator<BusModelBuffDbKeyHash160Type> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDbKeyHash160Type> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Type().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDbKeyHash160TypeByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffValueByContNextIdxKey key = (BusModelBuffValueByContNextIdxKey)schema.getBusModelBuffFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteDbKeyHash160TypeByContNextIdx( Authorization, key );
	}

	@Override
	public void deleteDbKeyHash160TypeByContNextIdx( ISecureAuthorization Authorization,
		IBusModelValueByContNextIdxKey argKey )
	{
		final String S_ProcName = "deleteDbKeyHash160TypeByContNextIdx";
		BusModelBuffDbKeyHash160Type cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDbKeyHash160Type> matchSet = new LinkedList<BusModelBuffDbKeyHash160Type>();
		Iterator<BusModelBuffDbKeyHash160Type> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDbKeyHash160Type> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDbKeyHash160Type)(schema.getTableDbKeyHash160Type().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDbKeyHash160Type.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Type().deleteDbKeyHash160Type( Authorization, cur );
			}
			else if( IBusModelDbKeyHash160Gen.CLASS_CODE == subClassCode ) {
				schema.getTableDbKeyHash160Gen().deleteDbKeyHash160Gen( Authorization, (IBusModelDbKeyHash160Gen)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}
}
