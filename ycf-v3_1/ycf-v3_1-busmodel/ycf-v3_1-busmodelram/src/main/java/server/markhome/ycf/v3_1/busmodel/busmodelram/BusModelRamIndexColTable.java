
// Description: Java 25 in-memory RAM DbIO implementation for IndexCol.

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
 *	BusModelRamIndexColTable in-memory RAM DbIO implementation
 *	for IndexCol.
 */
public class BusModelRamIndexColTable
	implements IBusModelIndexColTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffIndexCol > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffIndexCol >();
	private Map< BusModelBuffIndexColByUNameIdxKey,
			BusModelBuffIndexCol > dictByUNameIdx
		= new HashMap< BusModelBuffIndexColByUNameIdxKey,
			BusModelBuffIndexCol >();
	private Map< BusModelBuffIndexColByIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >> dictByIndexIdx
		= new HashMap< BusModelBuffIndexColByIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >>();
	private Map< BusModelBuffIndexColByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffIndexColByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >>();
	private Map< BusModelBuffIndexColByColIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >> dictByColIdx
		= new HashMap< BusModelBuffIndexColByColIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >>();
	private Map< BusModelBuffIndexColByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >> dictByPrevIdx
		= new HashMap< BusModelBuffIndexColByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >>();
	private Map< BusModelBuffIndexColByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >> dictByNextIdx
		= new HashMap< BusModelBuffIndexColByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >>();
	private Map< BusModelBuffIndexColByIdxPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >> dictByIdxPrevIdx
		= new HashMap< BusModelBuffIndexColByIdxPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >>();
	private Map< BusModelBuffIndexColByIdxNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >> dictByIdxNextIdx
		= new HashMap< BusModelBuffIndexColByIdxNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexCol >>();

	public BusModelRamIndexColTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffIndexCol ensureRec(IBusModelIndexCol rec) {
		return (((BusModelBuffIndexColFactoryService)(schema.getBusModelBuffFactory().getFactoryIndexCol())).ensureRec(rec));
	}

	@Override
	public IBusModelIndexCol createIndexCol( ISecureAuthorization Authorization,
		IBusModelIndexCol iBuff )
	{
		final String S_ProcName = "createIndexCol";
		
		BusModelBuffIndexCol Buff = (BusModelBuffIndexCol)ensureRec(iBuff);
			IBusModelIndexCol tail = null;

			IBusModelIndexCol[] siblings = schema.getTableIndexCol().readDerivedByIndexIdx( Authorization,
				Buff.getRequiredIndexId() );
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
		pkey = schema.nextIndexColIdGen();
		Buff.setRequiredId( pkey );
		BusModelBuffIndexColByUNameIdxKey keyUNameIdx = (BusModelBuffIndexColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByUNameIdxKey();
		keyUNameIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffIndexColByIndexIdxKey keyIndexIdx = (BusModelBuffIndexColByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIndexIdxKey();
		keyIndexIdx.setRequiredIndexId( Buff.getRequiredIndexId() );

		BusModelBuffIndexColByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffIndexColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffIndexColByColIdxKey keyColIdx = (BusModelBuffIndexColByColIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByColIdxKey();
		keyColIdx.setRequiredColumnId( Buff.getRequiredColumnId() );

		BusModelBuffIndexColByPrevIdxKey keyPrevIdx = (BusModelBuffIndexColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffIndexColByNextIdxKey keyNextIdx = (BusModelBuffIndexColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		BusModelBuffIndexColByIdxPrevIdxKey keyIdxPrevIdx = (BusModelBuffIndexColByIdxPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
		keyIdxPrevIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		keyIdxPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffIndexColByIdxNextIdxKey keyIdxNextIdx = (BusModelBuffIndexColByIdxNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxNextIdxKey();
		keyIdxNextIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		keyIdxNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"IndexColUNameIdx",
				"IndexColUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredIndexId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"Index",
						"Index",
						"Index",
						"Index",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getRequiredColumnId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"Column",
						"Column",
						"Value",
						"Value",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictIndexIdx;
		if( dictByIndexIdx.containsKey( keyIndexIdx ) ) {
			subdictIndexIdx = dictByIndexIdx.get( keyIndexIdx );
		}
		else {
			subdictIndexIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByIndexIdx.put( keyIndexIdx, subdictIndexIdx );
		}
		subdictIndexIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictColIdx;
		if( dictByColIdx.containsKey( keyColIdx ) ) {
			subdictColIdx = dictByColIdx.get( keyColIdx );
		}
		else {
			subdictColIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByColIdx.put( keyColIdx, subdictColIdx );
		}
		subdictColIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictIdxPrevIdx;
		if( dictByIdxPrevIdx.containsKey( keyIdxPrevIdx ) ) {
			subdictIdxPrevIdx = dictByIdxPrevIdx.get( keyIdxPrevIdx );
		}
		else {
			subdictIdxPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByIdxPrevIdx.put( keyIdxPrevIdx, subdictIdxPrevIdx );
		}
		subdictIdxPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictIdxNextIdx;
		if( dictByIdxNextIdx.containsKey( keyIdxNextIdx ) ) {
			subdictIdxNextIdx = dictByIdxNextIdx.get( keyIdxNextIdx );
		}
		else {
			subdictIdxNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByIdxNextIdx.put( keyIdxNextIdx, subdictIdxNextIdx );
		}
		subdictIdxNextIdx.put( pkey, Buff );

		if( tail != null ) {
			IBusModelIndexCol tailEdit = schema.getBusModelBuffFactory().getFactoryIndexCol().newRec();
			tailEdit.set( (IBusModelIndexCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
			schema.getTableIndexCol().updateIndexCol( Authorization, tailEdit );
		}
		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelIndexCol.CLASS_CODE) {
				BusModelBuffIndexCol retbuff = ((BusModelBuffIndexCol)(schema.getBusModelBuffFactory().getFactoryIndexCol().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelIndexCol readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerived";
		IBusModelIndexCol buff;
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
	public IBusModelIndexCol lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamIndexCol.lockDerived";
		IBusModelIndexCol buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndexCol[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamIndexCol.readAllDerived";
		IBusModelIndexCol[] retList = new IBusModelIndexCol[ dictByPKey.values().size() ];
		Iterator< BusModelBuffIndexCol > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelIndexCol readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId,
		String Name )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerivedByUNameIdx";
		BusModelBuffIndexColByUNameIdxKey key = (BusModelBuffIndexColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByUNameIdxKey();

		key.setRequiredIndexId( IndexId );
		key.setRequiredName( Name );
		IBusModelIndexCol buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndexCol[] readDerivedByIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerivedByIndexIdx";
		BusModelBuffIndexColByIndexIdxKey key = (BusModelBuffIndexColByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIndexIdxKey();

		key.setRequiredIndexId( IndexId );
		IBusModelIndexCol[] recArray;
		if( dictByIndexIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictIndexIdx
				= dictByIndexIdx.get( key );
			recArray = new IBusModelIndexCol[ subdictIndexIdx.size() ];
			Iterator< BusModelBuffIndexCol > iter = subdictIndexIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictIndexIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByIndexIdx.put( key, subdictIndexIdx );
			recArray = new IBusModelIndexCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndexCol[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerivedByDefSchemaIdx";
		BusModelBuffIndexColByDefSchemaIdxKey key = (BusModelBuffIndexColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelIndexCol[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelIndexCol[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffIndexCol > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelIndexCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndexCol[] readDerivedByColIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ColumnId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerivedByColIdx";
		BusModelBuffIndexColByColIdxKey key = (BusModelBuffIndexColByColIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByColIdxKey();

		key.setRequiredColumnId( ColumnId );
		IBusModelIndexCol[] recArray;
		if( dictByColIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictColIdx
				= dictByColIdx.get( key );
			recArray = new IBusModelIndexCol[ subdictColIdx.size() ];
			Iterator< BusModelBuffIndexCol > iter = subdictColIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictColIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByColIdx.put( key, subdictColIdx );
			recArray = new IBusModelIndexCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndexCol[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerivedByPrevIdx";
		BusModelBuffIndexColByPrevIdxKey key = (BusModelBuffIndexColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByPrevIdxKey();

		key.setOptionalPrevId( PrevId );
		IBusModelIndexCol[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new IBusModelIndexCol[ subdictPrevIdx.size() ];
			Iterator< BusModelBuffIndexCol > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new IBusModelIndexCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndexCol[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerivedByNextIdx";
		BusModelBuffIndexColByNextIdxKey key = (BusModelBuffIndexColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByNextIdxKey();

		key.setOptionalNextId( NextId );
		IBusModelIndexCol[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new IBusModelIndexCol[ subdictNextIdx.size() ];
			Iterator< BusModelBuffIndexCol > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new IBusModelIndexCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndexCol[] readDerivedByIdxPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerivedByIdxPrevIdx";
		BusModelBuffIndexColByIdxPrevIdxKey key = (BusModelBuffIndexColByIdxPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxPrevIdxKey();

		key.setRequiredIndexId( IndexId );
		key.setOptionalPrevId( PrevId );
		IBusModelIndexCol[] recArray;
		if( dictByIdxPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictIdxPrevIdx
				= dictByIdxPrevIdx.get( key );
			recArray = new IBusModelIndexCol[ subdictIdxPrevIdx.size() ];
			Iterator< BusModelBuffIndexCol > iter = subdictIdxPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictIdxPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByIdxPrevIdx.put( key, subdictIdxPrevIdx );
			recArray = new IBusModelIndexCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndexCol[] readDerivedByIdxNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerivedByIdxNextIdx";
		BusModelBuffIndexColByIdxNextIdxKey key = (BusModelBuffIndexColByIdxNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxNextIdxKey();

		key.setRequiredIndexId( IndexId );
		key.setOptionalNextId( NextId );
		IBusModelIndexCol[] recArray;
		if( dictByIdxNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictIdxNextIdx
				= dictByIdxNextIdx.get( key );
			recArray = new IBusModelIndexCol[ subdictIdxNextIdx.size() ];
			Iterator< BusModelBuffIndexCol > iter = subdictIdxNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdictIdxNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByIdxNextIdx.put( key, subdictIdxNextIdx );
			recArray = new IBusModelIndexCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndexCol readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamIndexCol.readDerivedByIdIdx() ";
		IBusModelIndexCol buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndexCol readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRec";
		IBusModelIndexCol buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelIndexCol.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndexCol lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelIndexCol buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelIndexCol.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndexCol[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamIndexCol.readAllRec";
		IBusModelIndexCol buff;
		ArrayList<IBusModelIndexCol> filteredList = new ArrayList<IBusModelIndexCol>();
		IBusModelIndexCol[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexCol[0] ) );
	}

	@Override
	public IBusModelIndexCol readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRecByIdIdx() ";
		IBusModelIndexCol buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
			return( (IBusModelIndexCol)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelIndexCol readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId,
		String Name )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRecByUNameIdx() ";
		IBusModelIndexCol buff = readDerivedByUNameIdx( Authorization,
			IndexId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
			return( (IBusModelIndexCol)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelIndexCol[] readRecByIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRecByIndexIdx() ";
		IBusModelIndexCol buff;
		ArrayList<IBusModelIndexCol> filteredList = new ArrayList<IBusModelIndexCol>();
		IBusModelIndexCol[] buffList = readDerivedByIndexIdx( Authorization,
			IndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexCol[0] ) );
	}

	@Override
	public IBusModelIndexCol[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRecByDefSchemaIdx() ";
		IBusModelIndexCol buff;
		ArrayList<IBusModelIndexCol> filteredList = new ArrayList<IBusModelIndexCol>();
		IBusModelIndexCol[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexCol[0] ) );
	}

	@Override
	public IBusModelIndexCol[] readRecByColIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ColumnId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRecByColIdx() ";
		IBusModelIndexCol buff;
		ArrayList<IBusModelIndexCol> filteredList = new ArrayList<IBusModelIndexCol>();
		IBusModelIndexCol[] buffList = readDerivedByColIdx( Authorization,
			ColumnId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexCol[0] ) );
	}

	@Override
	public IBusModelIndexCol[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRecByPrevIdx() ";
		IBusModelIndexCol buff;
		ArrayList<IBusModelIndexCol> filteredList = new ArrayList<IBusModelIndexCol>();
		IBusModelIndexCol[] buffList = readDerivedByPrevIdx( Authorization,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexCol[0] ) );
	}

	@Override
	public IBusModelIndexCol[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRecByNextIdx() ";
		IBusModelIndexCol buff;
		ArrayList<IBusModelIndexCol> filteredList = new ArrayList<IBusModelIndexCol>();
		IBusModelIndexCol[] buffList = readDerivedByNextIdx( Authorization,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexCol[0] ) );
	}

	@Override
	public IBusModelIndexCol[] readRecByIdxPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRecByIdxPrevIdx() ";
		IBusModelIndexCol buff;
		ArrayList<IBusModelIndexCol> filteredList = new ArrayList<IBusModelIndexCol>();
		IBusModelIndexCol[] buffList = readDerivedByIdxPrevIdx( Authorization,
			IndexId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexCol[0] ) );
	}

	@Override
	public IBusModelIndexCol[] readRecByIdxNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamIndexCol.readRecByIdxNextIdx() ";
		IBusModelIndexCol buff;
		ArrayList<IBusModelIndexCol> filteredList = new ArrayList<IBusModelIndexCol>();
		IBusModelIndexCol[] buffList = readDerivedByIdxNextIdx( Authorization,
			IndexId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexCol[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelIndexCol moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecUp";

		IBusModelIndexCol grandprev = null;
		IBusModelIndexCol prev = null;
		IBusModelIndexCol cur = null;
		IBusModelIndexCol next = null;

		cur = schema.getTableIndexCol().readDerivedByIdIdx(Authorization, Id);
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalPrevId() == null ) )
		{
			return( (BusModelBuffIndexCol)cur );
		}

		prev = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
		if( prev == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx(Authorization, prev.getOptionalPrevId() ));
			if( grandprev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextId() != null ) )
		{
			next = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
			if( next == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
			}
		}

		int classCode = prev.getClassCode();
		IBusModelIndexCol newInstance;
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryIndexCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffIndexCol editPrev = (BusModelBuffIndexCol)newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryIndexCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffIndexCol editCur = (BusModelBuffIndexCol)newInstance;
		editCur.set( cur );

		BusModelBuffIndexCol editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryIndexCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandprev = (BusModelBuffIndexCol)newInstance;
			editGrandprev.set( grandprev );
		}

		BusModelBuffIndexCol editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryIndexCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext = (BusModelBuffIndexCol)newInstance;
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
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editGrandprev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffIndexCol)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelIndexCol moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecDown";

		BusModelBuffIndexCol prev = null;
		BusModelBuffIndexCol cur = null;
		BusModelBuffIndexCol next = null;
		BusModelBuffIndexCol grandnext = null;

		cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx(Authorization, Id));
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalNextId() == null ) )
		{
			return( (BusModelBuffIndexCol)cur );
		}

		next = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
		if( next == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
		}

		if( ( next.getOptionalNextId() != null ) )
		{
			grandnext = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx(Authorization, next.getOptionalNextId() ));
			if( grandnext == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevId() != null ) )
		{
			prev = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
			if( prev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
			}
		}

		int classCode = cur.getClassCode();
		IBusModelIndexCol newInstance;
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryIndexCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffIndexCol editCur = (BusModelBuffIndexCol)newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryIndexCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffIndexCol editNext = (BusModelBuffIndexCol)newInstance;
		editNext.set( next );

		BusModelBuffIndexCol editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryIndexCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandnext = (BusModelBuffIndexCol)newInstance;
			editGrandnext.set( grandnext );
		}

		BusModelBuffIndexCol editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryIndexCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev = (BusModelBuffIndexCol)newInstance;
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
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editNext.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editGrandnext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffIndexCol)editCur );
	}

	public IBusModelIndexCol updateIndexCol( ISecureAuthorization Authorization,
		IBusModelIndexCol iBuff )
	{
		BusModelBuffIndexCol Buff = (BusModelBuffIndexCol)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffIndexCol existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateIndexCol",
				"Existing record not found",
				"Existing record not found",
				"IndexCol",
				"IndexCol",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateIndexCol",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		BusModelBuffIndexColByUNameIdxKey existingKeyUNameIdx = (BusModelBuffIndexColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffIndexColByUNameIdxKey newKeyUNameIdx = (BusModelBuffIndexColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffIndexColByIndexIdxKey existingKeyIndexIdx = (BusModelBuffIndexColByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIndexIdxKey();
		existingKeyIndexIdx.setRequiredIndexId( existing.getRequiredIndexId() );

		BusModelBuffIndexColByIndexIdxKey newKeyIndexIdx = (BusModelBuffIndexColByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIndexIdxKey();
		newKeyIndexIdx.setRequiredIndexId( Buff.getRequiredIndexId() );

		BusModelBuffIndexColByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffIndexColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffIndexColByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffIndexColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffIndexColByColIdxKey existingKeyColIdx = (BusModelBuffIndexColByColIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByColIdxKey();
		existingKeyColIdx.setRequiredColumnId( existing.getRequiredColumnId() );

		BusModelBuffIndexColByColIdxKey newKeyColIdx = (BusModelBuffIndexColByColIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByColIdxKey();
		newKeyColIdx.setRequiredColumnId( Buff.getRequiredColumnId() );

		BusModelBuffIndexColByPrevIdxKey existingKeyPrevIdx = (BusModelBuffIndexColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffIndexColByPrevIdxKey newKeyPrevIdx = (BusModelBuffIndexColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffIndexColByNextIdxKey existingKeyNextIdx = (BusModelBuffIndexColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByNextIdxKey();
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffIndexColByNextIdxKey newKeyNextIdx = (BusModelBuffIndexColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByNextIdxKey();
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		BusModelBuffIndexColByIdxPrevIdxKey existingKeyIdxPrevIdx = (BusModelBuffIndexColByIdxPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
		existingKeyIdxPrevIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		existingKeyIdxPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffIndexColByIdxPrevIdxKey newKeyIdxPrevIdx = (BusModelBuffIndexColByIdxPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
		newKeyIdxPrevIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		newKeyIdxPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffIndexColByIdxNextIdxKey existingKeyIdxNextIdx = (BusModelBuffIndexColByIdxNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxNextIdxKey();
		existingKeyIdxNextIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		existingKeyIdxNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffIndexColByIdxNextIdxKey newKeyIdxNextIdx = (BusModelBuffIndexColByIdxNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxNextIdxKey();
		newKeyIdxNextIdx.setRequiredIndexId( Buff.getRequiredIndexId() );
		newKeyIdxNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateIndexCol",
					"IndexColUNameIdx",
					"IndexColUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredIndexId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateIndexCol",
						"Container",
						"Container",
						"Index",
						"Index",
						"Index",
						"Index",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableValue().readDerivedByIdIdx( Authorization,
						Buff.getRequiredColumnId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateIndexCol",
						"Lookup",
						"Lookup",
						"Column",
						"Column",
						"Value",
						"Value",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByIndexIdx.get( existingKeyIndexIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIndexIdx.containsKey( newKeyIndexIdx ) ) {
			subdict = dictByIndexIdx.get( newKeyIndexIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByIndexIdx.put( newKeyIndexIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByColIdx.get( existingKeyColIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByColIdx.containsKey( newKeyColIdx ) ) {
			subdict = dictByColIdx.get( newKeyColIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByColIdx.put( newKeyColIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByIdxPrevIdx.get( existingKeyIdxPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIdxPrevIdx.containsKey( newKeyIdxPrevIdx ) ) {
			subdict = dictByIdxPrevIdx.get( newKeyIdxPrevIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByIdxPrevIdx.put( newKeyIdxPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByIdxNextIdx.get( existingKeyIdxNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIdxNextIdx.containsKey( newKeyIdxNextIdx ) ) {
			subdict = dictByIdxNextIdx.get( newKeyIdxNextIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol >();
			dictByIdxNextIdx.put( newKeyIdxNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteIndexCol( ISecureAuthorization Authorization,
		IBusModelIndexCol iBuff )
	{
		final String S_ProcName = "BusModelRamIndexColTable.deleteIndexCol() ";
		BusModelBuffIndexCol Buff = (BusModelBuffIndexCol)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffIndexCol existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteIndexCol",
				pkey );
		}
		IYCFKeyHash256 varIndexId = existing.getRequiredIndexId();
		BusModelBuffIndex container = (BusModelBuffIndex)(schema.getTableIndex().readDerivedByIdIdx( Authorization,
			varIndexId ));
		if( container == null ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				0,
				"container" );
		}

		IYCFKeyHash256 prevId = existing.getOptionalPrevId();
		IYCFKeyHash256 nextId = existing.getOptionalNextId();

		BusModelBuffIndexCol prev = null;
		if( ( prevId != null ) )
		{
			prev = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				prevId ));
			if( prev == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			BusModelBuffIndexCol editPrev;
			classCode = prev.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				editPrev = (BusModelBuffIndexCol)(schema.getBusModelBuffFactory().getFactoryIndexCol().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev.set( prev );
			editPrev.setOptionalLookupNext(nextId);
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffIndexCol next = null;
		if( ( nextId != null ) )
		{
			next = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				nextId ));
			if( next == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			BusModelBuffIndexCol editNext;
			classCode = next.getClassCode();
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				editNext = (BusModelBuffIndexCol)(schema.getBusModelBuffFactory().getFactoryIndexCol().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext.set( next );
			editNext.setOptionalLookupPrev(prevId);
			if( classCode == IBusModelIndexCol.CLASS_CODE ) {
				schema.getTableIndexCol().updateIndexCol( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

					schema.getTableRelationCol().deleteRelationColByFromColIdx( Authorization,
						existing.getRequiredId() );
					schema.getTableRelationCol().deleteRelationColByToColIdx( Authorization,
						existing.getRequiredId() );
		BusModelBuffIndexColByUNameIdxKey keyUNameIdx = (BusModelBuffIndexColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByUNameIdxKey();
		keyUNameIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffIndexColByIndexIdxKey keyIndexIdx = (BusModelBuffIndexColByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIndexIdxKey();
		keyIndexIdx.setRequiredIndexId( existing.getRequiredIndexId() );

		BusModelBuffIndexColByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffIndexColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffIndexColByColIdxKey keyColIdx = (BusModelBuffIndexColByColIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByColIdxKey();
		keyColIdx.setRequiredColumnId( existing.getRequiredColumnId() );

		BusModelBuffIndexColByPrevIdxKey keyPrevIdx = (BusModelBuffIndexColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffIndexColByNextIdxKey keyNextIdx = (BusModelBuffIndexColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffIndexColByIdxPrevIdxKey keyIdxPrevIdx = (BusModelBuffIndexColByIdxPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
		keyIdxPrevIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		keyIdxPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffIndexColByIdxNextIdxKey keyIdxNextIdx = (BusModelBuffIndexColByIdxNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxNextIdxKey();
		keyIdxNextIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		keyIdxNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		// Validate reverse foreign keys

		if( schema.getTableRelationCol().readDerivedByFromColIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteIndexCol",
				"Lookup",
				"Lookup",
				"LookupFromCol",
				"LookupFromCol",
				"RelationCol",
				"RelationCol",
				pkey );
		}

		if( schema.getTableRelationCol().readDerivedByToColIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteIndexCol",
				"Lookup",
				"Lookup",
				"LookupToCol",
				"LookupToCol",
				"RelationCol",
				"RelationCol",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexCol > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByIndexIdx.get( keyIndexIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByColIdx.get( keyColIdx );
		subdict.remove( pkey );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		subdict = dictByIdxPrevIdx.get( keyIdxPrevIdx );
		subdict.remove( pkey );

		subdict = dictByIdxNextIdx.get( keyIdxNextIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteIndexColByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffIndexCol cur;
		LinkedList<BusModelBuffIndexCol> matchSet = new LinkedList<BusModelBuffIndexCol>();
		Iterator<BusModelBuffIndexCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexCol( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexColByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argIndexId,
		String argName )
	{
		BusModelBuffIndexColByUNameIdxKey key = (BusModelBuffIndexColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByUNameIdxKey();
		key.setRequiredIndexId( argIndexId );
		key.setRequiredName( argName );
		deleteIndexColByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteIndexColByUNameIdx( ISecureAuthorization Authorization,
		IBusModelIndexColByUNameIdxKey argKey )
	{
		BusModelBuffIndexCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexCol> matchSet = new LinkedList<BusModelBuffIndexCol>();
		Iterator<BusModelBuffIndexCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexCol( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexColByIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argIndexId )
	{
		BusModelBuffIndexColByIndexIdxKey key = (BusModelBuffIndexColByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIndexIdxKey();
		key.setRequiredIndexId( argIndexId );
		deleteIndexColByIndexIdx( Authorization, key );
	}

	@Override
	public void deleteIndexColByIndexIdx( ISecureAuthorization Authorization,
		IBusModelIndexColByIndexIdxKey argKey )
	{
		BusModelBuffIndexCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexCol> matchSet = new LinkedList<BusModelBuffIndexCol>();
		Iterator<BusModelBuffIndexCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexCol( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexColByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffIndexColByDefSchemaIdxKey key = (BusModelBuffIndexColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteIndexColByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteIndexColByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelIndexColByDefSchemaIdxKey argKey )
	{
		BusModelBuffIndexCol cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexCol> matchSet = new LinkedList<BusModelBuffIndexCol>();
		Iterator<BusModelBuffIndexCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexCol( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexColByColIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argColumnId )
	{
		BusModelBuffIndexColByColIdxKey key = (BusModelBuffIndexColByColIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByColIdxKey();
		key.setRequiredColumnId( argColumnId );
		deleteIndexColByColIdx( Authorization, key );
	}

	@Override
	public void deleteIndexColByColIdx( ISecureAuthorization Authorization,
		IBusModelIndexColByColIdxKey argKey )
	{
		BusModelBuffIndexCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexCol> matchSet = new LinkedList<BusModelBuffIndexCol>();
		Iterator<BusModelBuffIndexCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexCol( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexColByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffIndexColByPrevIdxKey key = (BusModelBuffIndexColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByPrevIdxKey();
		key.setOptionalPrevId( argPrevId );
		deleteIndexColByPrevIdx( Authorization, key );
	}

	@Override
	public void deleteIndexColByPrevIdx( ISecureAuthorization Authorization,
		IBusModelIndexColByPrevIdxKey argKey )
	{
		BusModelBuffIndexCol cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexCol> matchSet = new LinkedList<BusModelBuffIndexCol>();
		Iterator<BusModelBuffIndexCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexCol( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexColByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffIndexColByNextIdxKey key = (BusModelBuffIndexColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByNextIdxKey();
		key.setOptionalNextId( argNextId );
		deleteIndexColByNextIdx( Authorization, key );
	}

	@Override
	public void deleteIndexColByNextIdx( ISecureAuthorization Authorization,
		IBusModelIndexColByNextIdxKey argKey )
	{
		BusModelBuffIndexCol cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexCol> matchSet = new LinkedList<BusModelBuffIndexCol>();
		Iterator<BusModelBuffIndexCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexCol( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexColByIdxPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argIndexId,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffIndexColByIdxPrevIdxKey key = (BusModelBuffIndexColByIdxPrevIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
		key.setRequiredIndexId( argIndexId );
		key.setOptionalPrevId( argPrevId );
		deleteIndexColByIdxPrevIdx( Authorization, key );
	}

	@Override
	public void deleteIndexColByIdxPrevIdx( ISecureAuthorization Authorization,
		IBusModelIndexColByIdxPrevIdxKey argKey )
	{
		BusModelBuffIndexCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexCol> matchSet = new LinkedList<BusModelBuffIndexCol>();
		Iterator<BusModelBuffIndexCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexCol( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexColByIdxNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argIndexId,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffIndexColByIdxNextIdxKey key = (BusModelBuffIndexColByIdxNextIdxKey)schema.getBusModelBuffFactory().getFactoryIndexCol().newByIdxNextIdxKey();
		key.setRequiredIndexId( argIndexId );
		key.setOptionalNextId( argNextId );
		deleteIndexColByIdxNextIdx( Authorization, key );
	}

	@Override
	public void deleteIndexColByIdxNextIdx( ISecureAuthorization Authorization,
		IBusModelIndexColByIdxNextIdxKey argKey )
	{
		BusModelBuffIndexCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexCol> matchSet = new LinkedList<BusModelBuffIndexCol>();
		Iterator<BusModelBuffIndexCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexCol)(schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexCol( Authorization, cur );
		}
	}
}
