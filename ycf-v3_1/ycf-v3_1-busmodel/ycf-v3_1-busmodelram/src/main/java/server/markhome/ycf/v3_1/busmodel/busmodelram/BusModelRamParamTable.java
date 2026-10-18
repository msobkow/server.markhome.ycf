
// Description: Java 25 in-memory RAM DbIO implementation for Param.

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
 *	BusModelRamParamTable in-memory RAM DbIO implementation
 *	for Param.
 */
public class BusModelRamParamTable
	implements IBusModelParamTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffParam > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffParam >();
	private Map< BusModelBuffParamByUNameIdxKey,
			BusModelBuffParam > dictByUNameIdx
		= new HashMap< BusModelBuffParamByUNameIdxKey,
			BusModelBuffParam >();
	private Map< BusModelBuffParamByServerMethodIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >> dictByServerMethodIdx
		= new HashMap< BusModelBuffParamByServerMethodIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >>();
	private Map< BusModelBuffParamByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffParamByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >>();
	private Map< BusModelBuffParamByServerTypeIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >> dictByServerTypeIdx
		= new HashMap< BusModelBuffParamByServerTypeIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >>();
	private Map< BusModelBuffParamByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >> dictByPrevIdx
		= new HashMap< BusModelBuffParamByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >>();
	private Map< BusModelBuffParamByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >> dictByNextIdx
		= new HashMap< BusModelBuffParamByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >>();
	private Map< BusModelBuffParamByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >> dictByContPrevIdx
		= new HashMap< BusModelBuffParamByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >>();
	private Map< BusModelBuffParamByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >> dictByContNextIdx
		= new HashMap< BusModelBuffParamByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffParam >>();

	public BusModelRamParamTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffParam ensureRec(IBusModelParam rec) {
		return (((BusModelBuffParamFactoryService)(schema.getBusModelBuffFactory().getFactoryParam())).ensureRec(rec));
	}

	@Override
	public IBusModelParam createParam( ISecureAuthorization Authorization,
		IBusModelParam iBuff )
	{
		final String S_ProcName = "createParam";
		
		BusModelBuffParam Buff = (BusModelBuffParam)ensureRec(iBuff);
			IBusModelParam tail = null;

			IBusModelParam[] siblings = schema.getTableParam().readDerivedByServerMethodIdx( Authorization,
				Buff.getRequiredServerMethodId() );
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
		
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextParamIdGen();
		Buff.setRequiredId( pkey );
		BusModelBuffParamByUNameIdxKey keyUNameIdx = (BusModelBuffParamByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByUNameIdxKey();
		keyUNameIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffParamByServerMethodIdxKey keyServerMethodIdx = (BusModelBuffParamByServerMethodIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerMethodIdxKey();
		keyServerMethodIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );

		BusModelBuffParamByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffParamByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffParamByServerTypeIdxKey keyServerTypeIdx = (BusModelBuffParamByServerTypeIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerTypeIdxKey();
		keyServerTypeIdx.setOptionalTypeId( Buff.getOptionalTypeId() );

		BusModelBuffParamByPrevIdxKey keyPrevIdx = (BusModelBuffParamByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffParamByNextIdxKey keyNextIdx = (BusModelBuffParamByNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		BusModelBuffParamByContPrevIdxKey keyContPrevIdx = (BusModelBuffParamByContPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContPrevIdxKey();
		keyContPrevIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		keyContPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffParamByContNextIdxKey keyContNextIdx = (BusModelBuffParamByContNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContNextIdxKey();
		keyContNextIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		keyContNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ParamUNameIdx",
				"ParamUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
						Buff.getRequiredServerMethodId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ServerMethod",
						"ServerMethod",
						"ServerMethod",
						"ServerMethod",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			if( Buff.getOptionalTypeId() != null ) {
				allNull = false;
			}
			if( ! allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getOptionalTypeId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"Type",
						"Type",
						"Value",
						"Value",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictServerMethodIdx;
		if( dictByServerMethodIdx.containsKey( keyServerMethodIdx ) ) {
			subdictServerMethodIdx = dictByServerMethodIdx.get( keyServerMethodIdx );
		}
		else {
			subdictServerMethodIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByServerMethodIdx.put( keyServerMethodIdx, subdictServerMethodIdx );
		}
		subdictServerMethodIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictServerTypeIdx;
		if( dictByServerTypeIdx.containsKey( keyServerTypeIdx ) ) {
			subdictServerTypeIdx = dictByServerTypeIdx.get( keyServerTypeIdx );
		}
		else {
			subdictServerTypeIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByServerTypeIdx.put( keyServerTypeIdx, subdictServerTypeIdx );
		}
		subdictServerTypeIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictContPrevIdx;
		if( dictByContPrevIdx.containsKey( keyContPrevIdx ) ) {
			subdictContPrevIdx = dictByContPrevIdx.get( keyContPrevIdx );
		}
		else {
			subdictContPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByContPrevIdx.put( keyContPrevIdx, subdictContPrevIdx );
		}
		subdictContPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictContNextIdx;
		if( dictByContNextIdx.containsKey( keyContNextIdx ) ) {
			subdictContNextIdx = dictByContNextIdx.get( keyContNextIdx );
		}
		else {
			subdictContNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByContNextIdx.put( keyContNextIdx, subdictContNextIdx );
		}
		subdictContNextIdx.put( pkey, Buff );

		if( tail != null ) {
			IBusModelParam tailEdit = schema.getBusModelBuffFactory().getFactoryParam().newRec();
			tailEdit.set( (IBusModelParam)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
			schema.getTableParam().updateParam( Authorization, tailEdit );
		}
		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelParam.CLASS_CODE) {
				BusModelBuffParam retbuff = ((BusModelBuffParam)(schema.getBusModelBuffFactory().getFactoryParam().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelParam readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamParam.readDerived";
		IBusModelParam buff;
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
	public IBusModelParam lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamParam.lockDerived";
		IBusModelParam buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelParam[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamParam.readAllDerived";
		IBusModelParam[] retList = new IBusModelParam[ dictByPKey.values().size() ];
		Iterator< BusModelBuffParam > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelParam readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ServerMethodId,
		String Name )
	{
		final String S_ProcName = "BusModelRamParam.readDerivedByUNameIdx";
		BusModelBuffParamByUNameIdxKey key = (BusModelBuffParamByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByUNameIdxKey();

		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		IBusModelParam buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelParam[] readDerivedByServerMethodIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ServerMethodId )
	{
		final String S_ProcName = "BusModelRamParam.readDerivedByServerMethodIdx";
		BusModelBuffParamByServerMethodIdxKey key = (BusModelBuffParamByServerMethodIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerMethodIdxKey();

		key.setRequiredServerMethodId( ServerMethodId );
		IBusModelParam[] recArray;
		if( dictByServerMethodIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictServerMethodIdx
				= dictByServerMethodIdx.get( key );
			recArray = new IBusModelParam[ subdictServerMethodIdx.size() ];
			Iterator< BusModelBuffParam > iter = subdictServerMethodIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictServerMethodIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByServerMethodIdx.put( key, subdictServerMethodIdx );
			recArray = new IBusModelParam[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelParam[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamParam.readDerivedByDefSchemaIdx";
		BusModelBuffParamByDefSchemaIdxKey key = (BusModelBuffParamByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelParam[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelParam[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffParam > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelParam[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelParam[] readDerivedByServerTypeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TypeId )
	{
		final String S_ProcName = "BusModelRamParam.readDerivedByServerTypeIdx";
		BusModelBuffParamByServerTypeIdxKey key = (BusModelBuffParamByServerTypeIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerTypeIdxKey();

		key.setOptionalTypeId( TypeId );
		IBusModelParam[] recArray;
		if( dictByServerTypeIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictServerTypeIdx
				= dictByServerTypeIdx.get( key );
			recArray = new IBusModelParam[ subdictServerTypeIdx.size() ];
			Iterator< BusModelBuffParam > iter = subdictServerTypeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictServerTypeIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByServerTypeIdx.put( key, subdictServerTypeIdx );
			recArray = new IBusModelParam[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelParam[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamParam.readDerivedByPrevIdx";
		BusModelBuffParamByPrevIdxKey key = (BusModelBuffParamByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByPrevIdxKey();

		key.setOptionalPrevId( PrevId );
		IBusModelParam[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new IBusModelParam[ subdictPrevIdx.size() ];
			Iterator< BusModelBuffParam > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new IBusModelParam[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelParam[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamParam.readDerivedByNextIdx";
		BusModelBuffParamByNextIdxKey key = (BusModelBuffParamByNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByNextIdxKey();

		key.setOptionalNextId( NextId );
		IBusModelParam[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new IBusModelParam[ subdictNextIdx.size() ];
			Iterator< BusModelBuffParam > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new IBusModelParam[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelParam[] readDerivedByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamParam.readDerivedByContPrevIdx";
		BusModelBuffParamByContPrevIdxKey key = (BusModelBuffParamByContPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContPrevIdxKey();

		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		IBusModelParam[] recArray;
		if( dictByContPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictContPrevIdx
				= dictByContPrevIdx.get( key );
			recArray = new IBusModelParam[ subdictContPrevIdx.size() ];
			Iterator< BusModelBuffParam > iter = subdictContPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictContPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByContPrevIdx.put( key, subdictContPrevIdx );
			recArray = new IBusModelParam[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelParam[] readDerivedByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamParam.readDerivedByContNextIdx";
		BusModelBuffParamByContNextIdxKey key = (BusModelBuffParamByContNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContNextIdxKey();

		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		IBusModelParam[] recArray;
		if( dictByContNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictContNextIdx
				= dictByContNextIdx.get( key );
			recArray = new IBusModelParam[ subdictContNextIdx.size() ];
			Iterator< BusModelBuffParam > iter = subdictContNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdictContNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByContNextIdx.put( key, subdictContNextIdx );
			recArray = new IBusModelParam[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelParam readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamParam.readDerivedByIdIdx() ";
		IBusModelParam buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelParam readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamParam.readRec";
		IBusModelParam buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelParam.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelParam lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelParam buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelParam.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelParam[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamParam.readAllRec";
		IBusModelParam buff;
		ArrayList<IBusModelParam> filteredList = new ArrayList<IBusModelParam>();
		IBusModelParam[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelParam[0] ) );
	}

	@Override
	public IBusModelParam readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamParam.readRecByIdIdx() ";
		IBusModelParam buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
			return( (IBusModelParam)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelParam readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ServerMethodId,
		String Name )
	{
		final String S_ProcName = "BusModelRamParam.readRecByUNameIdx() ";
		IBusModelParam buff = readDerivedByUNameIdx( Authorization,
			ServerMethodId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
			return( (IBusModelParam)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelParam[] readRecByServerMethodIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ServerMethodId )
	{
		final String S_ProcName = "BusModelRamParam.readRecByServerMethodIdx() ";
		IBusModelParam buff;
		ArrayList<IBusModelParam> filteredList = new ArrayList<IBusModelParam>();
		IBusModelParam[] buffList = readDerivedByServerMethodIdx( Authorization,
			ServerMethodId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
				filteredList.add( (IBusModelParam)buff );
			}
		}
		return( filteredList.toArray( new IBusModelParam[0] ) );
	}

	@Override
	public IBusModelParam[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamParam.readRecByDefSchemaIdx() ";
		IBusModelParam buff;
		ArrayList<IBusModelParam> filteredList = new ArrayList<IBusModelParam>();
		IBusModelParam[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
				filteredList.add( (IBusModelParam)buff );
			}
		}
		return( filteredList.toArray( new IBusModelParam[0] ) );
	}

	@Override
	public IBusModelParam[] readRecByServerTypeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TypeId )
	{
		final String S_ProcName = "BusModelRamParam.readRecByServerTypeIdx() ";
		IBusModelParam buff;
		ArrayList<IBusModelParam> filteredList = new ArrayList<IBusModelParam>();
		IBusModelParam[] buffList = readDerivedByServerTypeIdx( Authorization,
			TypeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
				filteredList.add( (IBusModelParam)buff );
			}
		}
		return( filteredList.toArray( new IBusModelParam[0] ) );
	}

	@Override
	public IBusModelParam[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamParam.readRecByPrevIdx() ";
		IBusModelParam buff;
		ArrayList<IBusModelParam> filteredList = new ArrayList<IBusModelParam>();
		IBusModelParam[] buffList = readDerivedByPrevIdx( Authorization,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
				filteredList.add( (IBusModelParam)buff );
			}
		}
		return( filteredList.toArray( new IBusModelParam[0] ) );
	}

	@Override
	public IBusModelParam[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamParam.readRecByNextIdx() ";
		IBusModelParam buff;
		ArrayList<IBusModelParam> filteredList = new ArrayList<IBusModelParam>();
		IBusModelParam[] buffList = readDerivedByNextIdx( Authorization,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
				filteredList.add( (IBusModelParam)buff );
			}
		}
		return( filteredList.toArray( new IBusModelParam[0] ) );
	}

	@Override
	public IBusModelParam[] readRecByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamParam.readRecByContPrevIdx() ";
		IBusModelParam buff;
		ArrayList<IBusModelParam> filteredList = new ArrayList<IBusModelParam>();
		IBusModelParam[] buffList = readDerivedByContPrevIdx( Authorization,
			ServerMethodId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
				filteredList.add( (IBusModelParam)buff );
			}
		}
		return( filteredList.toArray( new IBusModelParam[0] ) );
	}

	@Override
	public IBusModelParam[] readRecByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamParam.readRecByContNextIdx() ";
		IBusModelParam buff;
		ArrayList<IBusModelParam> filteredList = new ArrayList<IBusModelParam>();
		IBusModelParam[] buffList = readDerivedByContNextIdx( Authorization,
			ServerMethodId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelParam.CLASS_CODE ) ) {
				filteredList.add( (IBusModelParam)buff );
			}
		}
		return( filteredList.toArray( new IBusModelParam[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelParam moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecUp";

		IBusModelParam grandprev = null;
		IBusModelParam prev = null;
		IBusModelParam cur = null;
		IBusModelParam next = null;

		cur = schema.getTableParam().readDerivedByIdIdx(Authorization, Id);
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalPrevId() == null ) )
		{
			return( (BusModelBuffParam)cur );
		}

		prev = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
		if( prev == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx(Authorization, prev.getOptionalPrevId() ));
			if( grandprev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextId() != null ) )
		{
			next = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
			if( next == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
			}
		}

		int classCode = prev.getClassCode();
		IBusModelParam newInstance;
			if( classCode == IBusModelParam.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryParam().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffParam editPrev = (BusModelBuffParam)newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryParam().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffParam editCur = (BusModelBuffParam)newInstance;
		editCur.set( cur );

		BusModelBuffParam editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryParam().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandprev = (BusModelBuffParam)newInstance;
			editGrandprev.set( grandprev );
		}

		BusModelBuffParam editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryParam().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext = (BusModelBuffParam)newInstance;
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
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editGrandprev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffParam)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelParam moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecDown";

		BusModelBuffParam prev = null;
		BusModelBuffParam cur = null;
		BusModelBuffParam next = null;
		BusModelBuffParam grandnext = null;

		cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx(Authorization, Id));
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalNextId() == null ) )
		{
			return( (BusModelBuffParam)cur );
		}

		next = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
		if( next == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
		}

		if( ( next.getOptionalNextId() != null ) )
		{
			grandnext = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx(Authorization, next.getOptionalNextId() ));
			if( grandnext == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevId() != null ) )
		{
			prev = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
			if( prev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
			}
		}

		int classCode = cur.getClassCode();
		IBusModelParam newInstance;
			if( classCode == IBusModelParam.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryParam().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffParam editCur = (BusModelBuffParam)newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryParam().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffParam editNext = (BusModelBuffParam)newInstance;
		editNext.set( next );

		BusModelBuffParam editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryParam().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandnext = (BusModelBuffParam)newInstance;
			editGrandnext.set( grandnext );
		}

		BusModelBuffParam editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryParam().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev = (BusModelBuffParam)newInstance;
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
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editNext.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editGrandnext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffParam)editCur );
	}

	public IBusModelParam updateParam( ISecureAuthorization Authorization,
		IBusModelParam iBuff )
	{
		BusModelBuffParam Buff = (BusModelBuffParam)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffParam existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateParam",
				"Existing record not found",
				"Existing record not found",
				"Param",
				"Param",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateParam",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		BusModelBuffParamByUNameIdxKey existingKeyUNameIdx = (BusModelBuffParamByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffParamByUNameIdxKey newKeyUNameIdx = (BusModelBuffParamByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffParamByServerMethodIdxKey existingKeyServerMethodIdx = (BusModelBuffParamByServerMethodIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerMethodIdxKey();
		existingKeyServerMethodIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );

		BusModelBuffParamByServerMethodIdxKey newKeyServerMethodIdx = (BusModelBuffParamByServerMethodIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerMethodIdxKey();
		newKeyServerMethodIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );

		BusModelBuffParamByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffParamByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffParamByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffParamByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffParamByServerTypeIdxKey existingKeyServerTypeIdx = (BusModelBuffParamByServerTypeIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerTypeIdxKey();
		existingKeyServerTypeIdx.setOptionalTypeId( existing.getOptionalTypeId() );

		BusModelBuffParamByServerTypeIdxKey newKeyServerTypeIdx = (BusModelBuffParamByServerTypeIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerTypeIdxKey();
		newKeyServerTypeIdx.setOptionalTypeId( Buff.getOptionalTypeId() );

		BusModelBuffParamByPrevIdxKey existingKeyPrevIdx = (BusModelBuffParamByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffParamByPrevIdxKey newKeyPrevIdx = (BusModelBuffParamByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffParamByNextIdxKey existingKeyNextIdx = (BusModelBuffParamByNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByNextIdxKey();
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffParamByNextIdxKey newKeyNextIdx = (BusModelBuffParamByNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByNextIdxKey();
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		BusModelBuffParamByContPrevIdxKey existingKeyContPrevIdx = (BusModelBuffParamByContPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContPrevIdxKey();
		existingKeyContPrevIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		existingKeyContPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffParamByContPrevIdxKey newKeyContPrevIdx = (BusModelBuffParamByContPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContPrevIdxKey();
		newKeyContPrevIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		newKeyContPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffParamByContNextIdxKey existingKeyContNextIdx = (BusModelBuffParamByContNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContNextIdxKey();
		existingKeyContNextIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		existingKeyContNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffParamByContNextIdxKey newKeyContNextIdx = (BusModelBuffParamByContNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContNextIdxKey();
		newKeyContNextIdx.setRequiredServerMethodId( Buff.getRequiredServerMethodId() );
		newKeyContNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateParam",
					"ParamUNameIdx",
					"ParamUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
						Buff.getRequiredServerMethodId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateParam",
						"Container",
						"Container",
						"ServerMethod",
						"ServerMethod",
						"ServerMethod",
						"ServerMethod",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			if( Buff.getOptionalTypeId() != null ) {
				allNull = false;
			}
			if( allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getOptionalTypeId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateParam",
						"Lookup",
						"Lookup",
						"Type",
						"Type",
						"Value",
						"Value",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByServerMethodIdx.get( existingKeyServerMethodIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByServerMethodIdx.containsKey( newKeyServerMethodIdx ) ) {
			subdict = dictByServerMethodIdx.get( newKeyServerMethodIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByServerMethodIdx.put( newKeyServerMethodIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDefSchemaIdx.get( existingKeyDefSchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDefSchemaIdx.containsKey( newKeyDefSchemaIdx ) ) {
			subdict = dictByDefSchemaIdx.get( newKeyDefSchemaIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByServerTypeIdx.get( existingKeyServerTypeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByServerTypeIdx.containsKey( newKeyServerTypeIdx ) ) {
			subdict = dictByServerTypeIdx.get( newKeyServerTypeIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByServerTypeIdx.put( newKeyServerTypeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByPrevIdx.get( existingKeyPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevIdx.containsKey( newKeyPrevIdx ) ) {
			subdict = dictByPrevIdx.get( newKeyPrevIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByPrevIdx.put( newKeyPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNextIdx.get( existingKeyNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNextIdx.containsKey( newKeyNextIdx ) ) {
			subdict = dictByNextIdx.get( newKeyNextIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByContPrevIdx.get( existingKeyContPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContPrevIdx.containsKey( newKeyContPrevIdx ) ) {
			subdict = dictByContPrevIdx.get( newKeyContPrevIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByContPrevIdx.put( newKeyContPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByContNextIdx.get( existingKeyContNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContNextIdx.containsKey( newKeyContNextIdx ) ) {
			subdict = dictByContNextIdx.get( newKeyContNextIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffParam >();
			dictByContNextIdx.put( newKeyContNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteParam( ISecureAuthorization Authorization,
		IBusModelParam iBuff )
	{
		final String S_ProcName = "BusModelRamParamTable.deleteParam() ";
		BusModelBuffParam Buff = (BusModelBuffParam)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffParam existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteParam",
				pkey );
		}
		IYCFKeyHash256 varServerMethodId = existing.getRequiredServerMethodId();
		BusModelBuffServerMethod container = (BusModelBuffServerMethod)(schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
			varServerMethodId ));
		if( container == null ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				0,
				"container" );
		}

		IYCFKeyHash256 prevId = existing.getOptionalPrevId();
		IYCFKeyHash256 nextId = existing.getOptionalNextId();

		BusModelBuffParam prev = null;
		if( ( prevId != null ) )
		{
			prev = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				prevId ));
			if( prev == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			BusModelBuffParam editPrev;
			classCode = prev.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				editPrev = (BusModelBuffParam)(schema.getBusModelBuffFactory().getFactoryParam().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev.set( prev );
			editPrev.setOptionalLookupNext(nextId);
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffParam next = null;
		if( ( nextId != null ) )
		{
			next = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				nextId ));
			if( next == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			BusModelBuffParam editNext;
			classCode = next.getClassCode();
			if( classCode == IBusModelParam.CLASS_CODE ) {
				editNext = (BusModelBuffParam)(schema.getBusModelBuffFactory().getFactoryParam().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext.set( next );
			editNext.setOptionalLookupPrev(prevId);
			if( classCode == IBusModelParam.CLASS_CODE ) {
				schema.getTableParam().updateParam( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffParamByUNameIdxKey keyUNameIdx = (BusModelBuffParamByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByUNameIdxKey();
		keyUNameIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffParamByServerMethodIdxKey keyServerMethodIdx = (BusModelBuffParamByServerMethodIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerMethodIdxKey();
		keyServerMethodIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );

		BusModelBuffParamByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffParamByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffParamByServerTypeIdxKey keyServerTypeIdx = (BusModelBuffParamByServerTypeIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerTypeIdxKey();
		keyServerTypeIdx.setOptionalTypeId( existing.getOptionalTypeId() );

		BusModelBuffParamByPrevIdxKey keyPrevIdx = (BusModelBuffParamByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffParamByNextIdxKey keyNextIdx = (BusModelBuffParamByNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffParamByContPrevIdxKey keyContPrevIdx = (BusModelBuffParamByContPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContPrevIdxKey();
		keyContPrevIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		keyContPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffParamByContNextIdxKey keyContNextIdx = (BusModelBuffParamByContNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContNextIdxKey();
		keyContNextIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		keyContNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffParam > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByServerMethodIdx.get( keyServerMethodIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByServerTypeIdx.get( keyServerTypeIdx );
		subdict.remove( pkey );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		subdict = dictByContPrevIdx.get( keyContPrevIdx );
		subdict.remove( pkey );

		subdict = dictByContNextIdx.get( keyContNextIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteParamByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffParam cur;
		LinkedList<BusModelBuffParam> matchSet = new LinkedList<BusModelBuffParam>();
		Iterator<BusModelBuffParam> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffParam> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteParam( Authorization, cur );
		}
	}

	@Override
	public void deleteParamByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argServerMethodId,
		String argName )
	{
		BusModelBuffParamByUNameIdxKey key = (BusModelBuffParamByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByUNameIdxKey();
		key.setRequiredServerMethodId( argServerMethodId );
		key.setRequiredName( argName );
		deleteParamByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteParamByUNameIdx( ISecureAuthorization Authorization,
		IBusModelParamByUNameIdxKey argKey )
	{
		BusModelBuffParam cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffParam> matchSet = new LinkedList<BusModelBuffParam>();
		Iterator<BusModelBuffParam> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffParam> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteParam( Authorization, cur );
		}
	}

	@Override
	public void deleteParamByServerMethodIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argServerMethodId )
	{
		BusModelBuffParamByServerMethodIdxKey key = (BusModelBuffParamByServerMethodIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerMethodIdxKey();
		key.setRequiredServerMethodId( argServerMethodId );
		deleteParamByServerMethodIdx( Authorization, key );
	}

	@Override
	public void deleteParamByServerMethodIdx( ISecureAuthorization Authorization,
		IBusModelParamByServerMethodIdxKey argKey )
	{
		BusModelBuffParam cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffParam> matchSet = new LinkedList<BusModelBuffParam>();
		Iterator<BusModelBuffParam> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffParam> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteParam( Authorization, cur );
		}
	}

	@Override
	public void deleteParamByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffParamByDefSchemaIdxKey key = (BusModelBuffParamByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteParamByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteParamByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelParamByDefSchemaIdxKey argKey )
	{
		BusModelBuffParam cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffParam> matchSet = new LinkedList<BusModelBuffParam>();
		Iterator<BusModelBuffParam> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffParam> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteParam( Authorization, cur );
		}
	}

	@Override
	public void deleteParamByServerTypeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTypeId )
	{
		BusModelBuffParamByServerTypeIdxKey key = (BusModelBuffParamByServerTypeIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByServerTypeIdxKey();
		key.setOptionalTypeId( argTypeId );
		deleteParamByServerTypeIdx( Authorization, key );
	}

	@Override
	public void deleteParamByServerTypeIdx( ISecureAuthorization Authorization,
		IBusModelParamByServerTypeIdxKey argKey )
	{
		BusModelBuffParam cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalTypeId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffParam> matchSet = new LinkedList<BusModelBuffParam>();
		Iterator<BusModelBuffParam> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffParam> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteParam( Authorization, cur );
		}
	}

	@Override
	public void deleteParamByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffParamByPrevIdxKey key = (BusModelBuffParamByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByPrevIdxKey();
		key.setOptionalPrevId( argPrevId );
		deleteParamByPrevIdx( Authorization, key );
	}

	@Override
	public void deleteParamByPrevIdx( ISecureAuthorization Authorization,
		IBusModelParamByPrevIdxKey argKey )
	{
		BusModelBuffParam cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffParam> matchSet = new LinkedList<BusModelBuffParam>();
		Iterator<BusModelBuffParam> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffParam> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteParam( Authorization, cur );
		}
	}

	@Override
	public void deleteParamByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffParamByNextIdxKey key = (BusModelBuffParamByNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByNextIdxKey();
		key.setOptionalNextId( argNextId );
		deleteParamByNextIdx( Authorization, key );
	}

	@Override
	public void deleteParamByNextIdx( ISecureAuthorization Authorization,
		IBusModelParamByNextIdxKey argKey )
	{
		BusModelBuffParam cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffParam> matchSet = new LinkedList<BusModelBuffParam>();
		Iterator<BusModelBuffParam> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffParam> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteParam( Authorization, cur );
		}
	}

	@Override
	public void deleteParamByContPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argServerMethodId,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffParamByContPrevIdxKey key = (BusModelBuffParamByContPrevIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContPrevIdxKey();
		key.setRequiredServerMethodId( argServerMethodId );
		key.setOptionalPrevId( argPrevId );
		deleteParamByContPrevIdx( Authorization, key );
	}

	@Override
	public void deleteParamByContPrevIdx( ISecureAuthorization Authorization,
		IBusModelParamByContPrevIdxKey argKey )
	{
		BusModelBuffParam cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffParam> matchSet = new LinkedList<BusModelBuffParam>();
		Iterator<BusModelBuffParam> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffParam> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteParam( Authorization, cur );
		}
	}

	@Override
	public void deleteParamByContNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argServerMethodId,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffParamByContNextIdxKey key = (BusModelBuffParamByContNextIdxKey)schema.getBusModelBuffFactory().getFactoryParam().newByContNextIdxKey();
		key.setRequiredServerMethodId( argServerMethodId );
		key.setOptionalNextId( argNextId );
		deleteParamByContNextIdx( Authorization, key );
	}

	@Override
	public void deleteParamByContNextIdx( ISecureAuthorization Authorization,
		IBusModelParamByContNextIdxKey argKey )
	{
		BusModelBuffParam cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffParam> matchSet = new LinkedList<BusModelBuffParam>();
		Iterator<BusModelBuffParam> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffParam> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffParam)(schema.getTableParam().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteParam( Authorization, cur );
		}
	}
}
