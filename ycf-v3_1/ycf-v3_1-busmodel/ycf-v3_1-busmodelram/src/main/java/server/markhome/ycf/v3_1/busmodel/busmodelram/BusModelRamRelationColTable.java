
// Description: Java 25 in-memory RAM DbIO implementation for RelationCol.

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
 *	BusModelRamRelationColTable in-memory RAM DbIO implementation
 *	for RelationCol.
 */
public class BusModelRamRelationColTable
	implements IBusModelRelationColTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffRelationCol > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffRelationCol >();
	private Map< BusModelBuffRelationColByUNameIdxKey,
			BusModelBuffRelationCol > dictByUNameIdx
		= new HashMap< BusModelBuffRelationColByUNameIdxKey,
			BusModelBuffRelationCol >();
	private Map< BusModelBuffRelationColByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >> dictByRelationIdx
		= new HashMap< BusModelBuffRelationColByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >>();
	private Map< BusModelBuffRelationColByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffRelationColByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >>();
	private Map< BusModelBuffRelationColByFromColIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >> dictByFromColIdx
		= new HashMap< BusModelBuffRelationColByFromColIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >>();
	private Map< BusModelBuffRelationColByToColIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >> dictByToColIdx
		= new HashMap< BusModelBuffRelationColByToColIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >>();
	private Map< BusModelBuffRelationColByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >> dictByPrevIdx
		= new HashMap< BusModelBuffRelationColByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >>();
	private Map< BusModelBuffRelationColByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >> dictByNextIdx
		= new HashMap< BusModelBuffRelationColByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >>();
	private Map< BusModelBuffRelationColByRelPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >> dictByRelPrevIdx
		= new HashMap< BusModelBuffRelationColByRelPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >>();
	private Map< BusModelBuffRelationColByRelNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >> dictByRelNextIdx
		= new HashMap< BusModelBuffRelationColByRelNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelationCol >>();

	public BusModelRamRelationColTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffRelationCol ensureRec(IBusModelRelationCol rec) {
		return (((BusModelBuffRelationColFactoryService)(schema.getBusModelBuffFactory().getFactoryRelationCol())).ensureRec(rec));
	}

	@Override
	public IBusModelRelationCol createRelationCol( ISecureAuthorization Authorization,
		IBusModelRelationCol iBuff )
	{
		final String S_ProcName = "createRelationCol";
		
		BusModelBuffRelationCol Buff = (BusModelBuffRelationCol)ensureRec(iBuff);
			IBusModelRelationCol tail = null;

			IBusModelRelationCol[] siblings = schema.getTableRelationCol().readDerivedByRelationIdx( Authorization,
				Buff.getRequiredRelationId() );
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
		pkey = schema.nextRelationColIdGen();
		Buff.setRequiredId( pkey );
		BusModelBuffRelationColByUNameIdxKey keyUNameIdx = (BusModelBuffRelationColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByUNameIdxKey();
		keyUNameIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffRelationColByRelationIdxKey keyRelationIdx = (BusModelBuffRelationColByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelationIdxKey();
		keyRelationIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		BusModelBuffRelationColByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffRelationColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffRelationColByFromColIdxKey keyFromColIdx = (BusModelBuffRelationColByFromColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByFromColIdxKey();
		keyFromColIdx.setRequiredFromColId( Buff.getRequiredFromColId() );

		BusModelBuffRelationColByToColIdxKey keyToColIdx = (BusModelBuffRelationColByToColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByToColIdxKey();
		keyToColIdx.setRequiredToColId( Buff.getRequiredToColId() );

		BusModelBuffRelationColByPrevIdxKey keyPrevIdx = (BusModelBuffRelationColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffRelationColByNextIdxKey keyNextIdx = (BusModelBuffRelationColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		BusModelBuffRelationColByRelPrevIdxKey keyRelPrevIdx = (BusModelBuffRelationColByRelPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelPrevIdxKey();
		keyRelPrevIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		keyRelPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffRelationColByRelNextIdxKey keyRelNextIdx = (BusModelBuffRelationColByRelNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelNextIdxKey();
		keyRelNextIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		keyRelNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"RelationColUNameIdx",
				"RelationColUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"Relation",
						"Relation",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
						Buff.getRequiredFromColId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"LookupFromCol",
						"LookupFromCol",
						"IndexCol",
						"IndexCol",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToColId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"LookupToCol",
						"LookupToCol",
						"IndexCol",
						"IndexCol",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictRelationIdx;
		if( dictByRelationIdx.containsKey( keyRelationIdx ) ) {
			subdictRelationIdx = dictByRelationIdx.get( keyRelationIdx );
		}
		else {
			subdictRelationIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByRelationIdx.put( keyRelationIdx, subdictRelationIdx );
		}
		subdictRelationIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictFromColIdx;
		if( dictByFromColIdx.containsKey( keyFromColIdx ) ) {
			subdictFromColIdx = dictByFromColIdx.get( keyFromColIdx );
		}
		else {
			subdictFromColIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByFromColIdx.put( keyFromColIdx, subdictFromColIdx );
		}
		subdictFromColIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictToColIdx;
		if( dictByToColIdx.containsKey( keyToColIdx ) ) {
			subdictToColIdx = dictByToColIdx.get( keyToColIdx );
		}
		else {
			subdictToColIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByToColIdx.put( keyToColIdx, subdictToColIdx );
		}
		subdictToColIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictRelPrevIdx;
		if( dictByRelPrevIdx.containsKey( keyRelPrevIdx ) ) {
			subdictRelPrevIdx = dictByRelPrevIdx.get( keyRelPrevIdx );
		}
		else {
			subdictRelPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByRelPrevIdx.put( keyRelPrevIdx, subdictRelPrevIdx );
		}
		subdictRelPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictRelNextIdx;
		if( dictByRelNextIdx.containsKey( keyRelNextIdx ) ) {
			subdictRelNextIdx = dictByRelNextIdx.get( keyRelNextIdx );
		}
		else {
			subdictRelNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByRelNextIdx.put( keyRelNextIdx, subdictRelNextIdx );
		}
		subdictRelNextIdx.put( pkey, Buff );

		if( tail != null ) {
			IBusModelRelationCol tailEdit = schema.getBusModelBuffFactory().getFactoryRelationCol().newRec();
			tailEdit.set( (IBusModelRelationCol)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
			schema.getTableRelationCol().updateRelationCol( Authorization, tailEdit );
		}
		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelRelationCol.CLASS_CODE) {
				BusModelBuffRelationCol retbuff = ((BusModelBuffRelationCol)(schema.getBusModelBuffFactory().getFactoryRelationCol().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelRelationCol readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerived";
		IBusModelRelationCol buff;
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
	public IBusModelRelationCol lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamRelationCol.lockDerived";
		IBusModelRelationCol buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelationCol[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamRelationCol.readAllDerived";
		IBusModelRelationCol[] retList = new IBusModelRelationCol[ dictByPKey.values().size() ];
		Iterator< BusModelBuffRelationCol > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelRelationCol readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByUNameIdx";
		BusModelBuffRelationColByUNameIdxKey key = (BusModelBuffRelationColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByUNameIdxKey();

		key.setRequiredRelationId( RelationId );
		key.setRequiredName( Name );
		IBusModelRelationCol buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelationCol[] readDerivedByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByRelationIdx";
		BusModelBuffRelationColByRelationIdxKey key = (BusModelBuffRelationColByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelationIdxKey();

		key.setRequiredRelationId( RelationId );
		IBusModelRelationCol[] recArray;
		if( dictByRelationIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictRelationIdx
				= dictByRelationIdx.get( key );
			recArray = new IBusModelRelationCol[ subdictRelationIdx.size() ];
			Iterator< BusModelBuffRelationCol > iter = subdictRelationIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictRelationIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByRelationIdx.put( key, subdictRelationIdx );
			recArray = new IBusModelRelationCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelationCol[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByDefSchemaIdx";
		BusModelBuffRelationColByDefSchemaIdxKey key = (BusModelBuffRelationColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelRelationCol[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelRelationCol[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffRelationCol > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelRelationCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelationCol[] readDerivedByFromColIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 FromColId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByFromColIdx";
		BusModelBuffRelationColByFromColIdxKey key = (BusModelBuffRelationColByFromColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByFromColIdxKey();

		key.setRequiredFromColId( FromColId );
		IBusModelRelationCol[] recArray;
		if( dictByFromColIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictFromColIdx
				= dictByFromColIdx.get( key );
			recArray = new IBusModelRelationCol[ subdictFromColIdx.size() ];
			Iterator< BusModelBuffRelationCol > iter = subdictFromColIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictFromColIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByFromColIdx.put( key, subdictFromColIdx );
			recArray = new IBusModelRelationCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelationCol[] readDerivedByToColIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ToColId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByToColIdx";
		BusModelBuffRelationColByToColIdxKey key = (BusModelBuffRelationColByToColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByToColIdxKey();

		key.setRequiredToColId( ToColId );
		IBusModelRelationCol[] recArray;
		if( dictByToColIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictToColIdx
				= dictByToColIdx.get( key );
			recArray = new IBusModelRelationCol[ subdictToColIdx.size() ];
			Iterator< BusModelBuffRelationCol > iter = subdictToColIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictToColIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByToColIdx.put( key, subdictToColIdx );
			recArray = new IBusModelRelationCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelationCol[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByPrevIdx";
		BusModelBuffRelationColByPrevIdxKey key = (BusModelBuffRelationColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByPrevIdxKey();

		key.setOptionalPrevId( PrevId );
		IBusModelRelationCol[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new IBusModelRelationCol[ subdictPrevIdx.size() ];
			Iterator< BusModelBuffRelationCol > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new IBusModelRelationCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelationCol[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByNextIdx";
		BusModelBuffRelationColByNextIdxKey key = (BusModelBuffRelationColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByNextIdxKey();

		key.setOptionalNextId( NextId );
		IBusModelRelationCol[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new IBusModelRelationCol[ subdictNextIdx.size() ];
			Iterator< BusModelBuffRelationCol > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new IBusModelRelationCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelationCol[] readDerivedByRelPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByRelPrevIdx";
		BusModelBuffRelationColByRelPrevIdxKey key = (BusModelBuffRelationColByRelPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelPrevIdxKey();

		key.setRequiredRelationId( RelationId );
		key.setOptionalPrevId( PrevId );
		IBusModelRelationCol[] recArray;
		if( dictByRelPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictRelPrevIdx
				= dictByRelPrevIdx.get( key );
			recArray = new IBusModelRelationCol[ subdictRelPrevIdx.size() ];
			Iterator< BusModelBuffRelationCol > iter = subdictRelPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictRelPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByRelPrevIdx.put( key, subdictRelPrevIdx );
			recArray = new IBusModelRelationCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelationCol[] readDerivedByRelNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByRelNextIdx";
		BusModelBuffRelationColByRelNextIdxKey key = (BusModelBuffRelationColByRelNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelNextIdxKey();

		key.setRequiredRelationId( RelationId );
		key.setOptionalNextId( NextId );
		IBusModelRelationCol[] recArray;
		if( dictByRelNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictRelNextIdx
				= dictByRelNextIdx.get( key );
			recArray = new IBusModelRelationCol[ subdictRelNextIdx.size() ];
			Iterator< BusModelBuffRelationCol > iter = subdictRelNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdictRelNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByRelNextIdx.put( key, subdictRelNextIdx );
			recArray = new IBusModelRelationCol[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelationCol readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamRelationCol.readDerivedByIdIdx() ";
		IBusModelRelationCol buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelationCol readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRec";
		IBusModelRelationCol buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelRelationCol.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelationCol lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelRelationCol buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelRelationCol.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelationCol[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamRelationCol.readAllRec";
		IBusModelRelationCol buff;
		ArrayList<IBusModelRelationCol> filteredList = new ArrayList<IBusModelRelationCol>();
		IBusModelRelationCol[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelationCol[0] ) );
	}

	@Override
	public IBusModelRelationCol readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByIdIdx() ";
		IBusModelRelationCol buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
			return( (IBusModelRelationCol)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelRelationCol readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByUNameIdx() ";
		IBusModelRelationCol buff = readDerivedByUNameIdx( Authorization,
			RelationId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
			return( (IBusModelRelationCol)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelRelationCol[] readRecByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByRelationIdx() ";
		IBusModelRelationCol buff;
		ArrayList<IBusModelRelationCol> filteredList = new ArrayList<IBusModelRelationCol>();
		IBusModelRelationCol[] buffList = readDerivedByRelationIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelationCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelationCol[0] ) );
	}

	@Override
	public IBusModelRelationCol[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByDefSchemaIdx() ";
		IBusModelRelationCol buff;
		ArrayList<IBusModelRelationCol> filteredList = new ArrayList<IBusModelRelationCol>();
		IBusModelRelationCol[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelationCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelationCol[0] ) );
	}

	@Override
	public IBusModelRelationCol[] readRecByFromColIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 FromColId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByFromColIdx() ";
		IBusModelRelationCol buff;
		ArrayList<IBusModelRelationCol> filteredList = new ArrayList<IBusModelRelationCol>();
		IBusModelRelationCol[] buffList = readDerivedByFromColIdx( Authorization,
			FromColId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelationCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelationCol[0] ) );
	}

	@Override
	public IBusModelRelationCol[] readRecByToColIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ToColId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByToColIdx() ";
		IBusModelRelationCol buff;
		ArrayList<IBusModelRelationCol> filteredList = new ArrayList<IBusModelRelationCol>();
		IBusModelRelationCol[] buffList = readDerivedByToColIdx( Authorization,
			ToColId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelationCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelationCol[0] ) );
	}

	@Override
	public IBusModelRelationCol[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByPrevIdx() ";
		IBusModelRelationCol buff;
		ArrayList<IBusModelRelationCol> filteredList = new ArrayList<IBusModelRelationCol>();
		IBusModelRelationCol[] buffList = readDerivedByPrevIdx( Authorization,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelationCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelationCol[0] ) );
	}

	@Override
	public IBusModelRelationCol[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByNextIdx() ";
		IBusModelRelationCol buff;
		ArrayList<IBusModelRelationCol> filteredList = new ArrayList<IBusModelRelationCol>();
		IBusModelRelationCol[] buffList = readDerivedByNextIdx( Authorization,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelationCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelationCol[0] ) );
	}

	@Override
	public IBusModelRelationCol[] readRecByRelPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByRelPrevIdx() ";
		IBusModelRelationCol buff;
		ArrayList<IBusModelRelationCol> filteredList = new ArrayList<IBusModelRelationCol>();
		IBusModelRelationCol[] buffList = readDerivedByRelPrevIdx( Authorization,
			RelationId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelationCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelationCol[0] ) );
	}

	@Override
	public IBusModelRelationCol[] readRecByRelNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamRelationCol.readRecByRelNextIdx() ";
		IBusModelRelationCol buff;
		ArrayList<IBusModelRelationCol> filteredList = new ArrayList<IBusModelRelationCol>();
		IBusModelRelationCol[] buffList = readDerivedByRelNextIdx( Authorization,
			RelationId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelationCol.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelationCol)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelationCol[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelRelationCol moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecUp";

		IBusModelRelationCol grandprev = null;
		IBusModelRelationCol prev = null;
		IBusModelRelationCol cur = null;
		IBusModelRelationCol next = null;

		cur = schema.getTableRelationCol().readDerivedByIdIdx(Authorization, Id);
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalPrevId() == null ) )
		{
			return( (BusModelBuffRelationCol)cur );
		}

		prev = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
		if( prev == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx(Authorization, prev.getOptionalPrevId() ));
			if( grandprev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextId() != null ) )
		{
			next = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
			if( next == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
			}
		}

		int classCode = prev.getClassCode();
		IBusModelRelationCol newInstance;
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryRelationCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffRelationCol editPrev = (BusModelBuffRelationCol)newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryRelationCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffRelationCol editCur = (BusModelBuffRelationCol)newInstance;
		editCur.set( cur );

		BusModelBuffRelationCol editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryRelationCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandprev = (BusModelBuffRelationCol)newInstance;
			editGrandprev.set( grandprev );
		}

		BusModelBuffRelationCol editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryRelationCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext = (BusModelBuffRelationCol)newInstance;
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
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editGrandprev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffRelationCol)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelRelationCol moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecDown";

		BusModelBuffRelationCol prev = null;
		BusModelBuffRelationCol cur = null;
		BusModelBuffRelationCol next = null;
		BusModelBuffRelationCol grandnext = null;

		cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx(Authorization, Id));
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalNextId() == null ) )
		{
			return( (BusModelBuffRelationCol)cur );
		}

		next = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
		if( next == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
		}

		if( ( next.getOptionalNextId() != null ) )
		{
			grandnext = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx(Authorization, next.getOptionalNextId() ));
			if( grandnext == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevId() != null ) )
		{
			prev = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
			if( prev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
			}
		}

		int classCode = cur.getClassCode();
		IBusModelRelationCol newInstance;
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryRelationCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffRelationCol editCur = (BusModelBuffRelationCol)newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryRelationCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffRelationCol editNext = (BusModelBuffRelationCol)newInstance;
		editNext.set( next );

		BusModelBuffRelationCol editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryRelationCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandnext = (BusModelBuffRelationCol)newInstance;
			editGrandnext.set( grandnext );
		}

		BusModelBuffRelationCol editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryRelationCol().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev = (BusModelBuffRelationCol)newInstance;
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
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editNext.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editGrandnext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffRelationCol)editCur );
	}

	public IBusModelRelationCol updateRelationCol( ISecureAuthorization Authorization,
		IBusModelRelationCol iBuff )
	{
		BusModelBuffRelationCol Buff = (BusModelBuffRelationCol)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffRelationCol existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateRelationCol",
				"Existing record not found",
				"Existing record not found",
				"RelationCol",
				"RelationCol",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateRelationCol",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		BusModelBuffRelationColByUNameIdxKey existingKeyUNameIdx = (BusModelBuffRelationColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffRelationColByUNameIdxKey newKeyUNameIdx = (BusModelBuffRelationColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffRelationColByRelationIdxKey existingKeyRelationIdx = (BusModelBuffRelationColByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelationIdxKey();
		existingKeyRelationIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		BusModelBuffRelationColByRelationIdxKey newKeyRelationIdx = (BusModelBuffRelationColByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelationIdxKey();
		newKeyRelationIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		BusModelBuffRelationColByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffRelationColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffRelationColByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffRelationColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffRelationColByFromColIdxKey existingKeyFromColIdx = (BusModelBuffRelationColByFromColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByFromColIdxKey();
		existingKeyFromColIdx.setRequiredFromColId( existing.getRequiredFromColId() );

		BusModelBuffRelationColByFromColIdxKey newKeyFromColIdx = (BusModelBuffRelationColByFromColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByFromColIdxKey();
		newKeyFromColIdx.setRequiredFromColId( Buff.getRequiredFromColId() );

		BusModelBuffRelationColByToColIdxKey existingKeyToColIdx = (BusModelBuffRelationColByToColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByToColIdxKey();
		existingKeyToColIdx.setRequiredToColId( existing.getRequiredToColId() );

		BusModelBuffRelationColByToColIdxKey newKeyToColIdx = (BusModelBuffRelationColByToColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByToColIdxKey();
		newKeyToColIdx.setRequiredToColId( Buff.getRequiredToColId() );

		BusModelBuffRelationColByPrevIdxKey existingKeyPrevIdx = (BusModelBuffRelationColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffRelationColByPrevIdxKey newKeyPrevIdx = (BusModelBuffRelationColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffRelationColByNextIdxKey existingKeyNextIdx = (BusModelBuffRelationColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByNextIdxKey();
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffRelationColByNextIdxKey newKeyNextIdx = (BusModelBuffRelationColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByNextIdxKey();
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		BusModelBuffRelationColByRelPrevIdxKey existingKeyRelPrevIdx = (BusModelBuffRelationColByRelPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelPrevIdxKey();
		existingKeyRelPrevIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		existingKeyRelPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffRelationColByRelPrevIdxKey newKeyRelPrevIdx = (BusModelBuffRelationColByRelPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelPrevIdxKey();
		newKeyRelPrevIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		newKeyRelPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffRelationColByRelNextIdxKey existingKeyRelNextIdx = (BusModelBuffRelationColByRelNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelNextIdxKey();
		existingKeyRelNextIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		existingKeyRelNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffRelationColByRelNextIdxKey newKeyRelNextIdx = (BusModelBuffRelationColByRelNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelNextIdxKey();
		newKeyRelNextIdx.setRequiredRelationId( Buff.getRequiredRelationId() );
		newKeyRelNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateRelationCol",
					"RelationColUNameIdx",
					"RelationColUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateRelationCol",
						"Container",
						"Container",
						"Relation",
						"Relation",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
						Buff.getRequiredFromColId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateRelationCol",
						"Lookup",
						"Lookup",
						"LookupFromCol",
						"LookupFromCol",
						"IndexCol",
						"IndexCol",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableIndexCol().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToColId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateRelationCol",
						"Lookup",
						"Lookup",
						"LookupToCol",
						"LookupToCol",
						"IndexCol",
						"IndexCol",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByRelationIdx.get( existingKeyRelationIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelationIdx.containsKey( newKeyRelationIdx ) ) {
			subdict = dictByRelationIdx.get( newKeyRelationIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByRelationIdx.put( newKeyRelationIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByFromColIdx.get( existingKeyFromColIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFromColIdx.containsKey( newKeyFromColIdx ) ) {
			subdict = dictByFromColIdx.get( newKeyFromColIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByFromColIdx.put( newKeyFromColIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByToColIdx.get( existingKeyToColIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByToColIdx.containsKey( newKeyToColIdx ) ) {
			subdict = dictByToColIdx.get( newKeyToColIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByToColIdx.put( newKeyToColIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRelPrevIdx.get( existingKeyRelPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelPrevIdx.containsKey( newKeyRelPrevIdx ) ) {
			subdict = dictByRelPrevIdx.get( newKeyRelPrevIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByRelPrevIdx.put( newKeyRelPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRelNextIdx.get( existingKeyRelNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelNextIdx.containsKey( newKeyRelNextIdx ) ) {
			subdict = dictByRelNextIdx.get( newKeyRelNextIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol >();
			dictByRelNextIdx.put( newKeyRelNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteRelationCol( ISecureAuthorization Authorization,
		IBusModelRelationCol iBuff )
	{
		final String S_ProcName = "BusModelRamRelationColTable.deleteRelationCol() ";
		BusModelBuffRelationCol Buff = (BusModelBuffRelationCol)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffRelationCol existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteRelationCol",
				pkey );
		}
		IYCFKeyHash256 varRelationId = existing.getRequiredRelationId();
		BusModelBuffRelation container = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
			varRelationId ));
		if( container == null ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				0,
				"container" );
		}

		IYCFKeyHash256 prevId = existing.getOptionalPrevId();
		IYCFKeyHash256 nextId = existing.getOptionalNextId();

		BusModelBuffRelationCol prev = null;
		if( ( prevId != null ) )
		{
			prev = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				prevId ));
			if( prev == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			BusModelBuffRelationCol editPrev;
			classCode = prev.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				editPrev = (BusModelBuffRelationCol)(schema.getBusModelBuffFactory().getFactoryRelationCol().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev.set( prev );
			editPrev.setOptionalLookupNext(nextId);
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffRelationCol next = null;
		if( ( nextId != null ) )
		{
			next = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				nextId ));
			if( next == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			BusModelBuffRelationCol editNext;
			classCode = next.getClassCode();
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				editNext = (BusModelBuffRelationCol)(schema.getBusModelBuffFactory().getFactoryRelationCol().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext.set( next );
			editNext.setOptionalLookupPrev(prevId);
			if( classCode == IBusModelRelationCol.CLASS_CODE ) {
				schema.getTableRelationCol().updateRelationCol( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffRelationColByUNameIdxKey keyUNameIdx = (BusModelBuffRelationColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByUNameIdxKey();
		keyUNameIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffRelationColByRelationIdxKey keyRelationIdx = (BusModelBuffRelationColByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelationIdxKey();
		keyRelationIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		BusModelBuffRelationColByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffRelationColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffRelationColByFromColIdxKey keyFromColIdx = (BusModelBuffRelationColByFromColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByFromColIdxKey();
		keyFromColIdx.setRequiredFromColId( existing.getRequiredFromColId() );

		BusModelBuffRelationColByToColIdxKey keyToColIdx = (BusModelBuffRelationColByToColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByToColIdxKey();
		keyToColIdx.setRequiredToColId( existing.getRequiredToColId() );

		BusModelBuffRelationColByPrevIdxKey keyPrevIdx = (BusModelBuffRelationColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffRelationColByNextIdxKey keyNextIdx = (BusModelBuffRelationColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffRelationColByRelPrevIdxKey keyRelPrevIdx = (BusModelBuffRelationColByRelPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelPrevIdxKey();
		keyRelPrevIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		keyRelPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffRelationColByRelNextIdxKey keyRelNextIdx = (BusModelBuffRelationColByRelNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelNextIdxKey();
		keyRelNextIdx.setRequiredRelationId( existing.getRequiredRelationId() );
		keyRelNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelationCol > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByRelationIdx.get( keyRelationIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByFromColIdx.get( keyFromColIdx );
		subdict.remove( pkey );

		subdict = dictByToColIdx.get( keyToColIdx );
		subdict.remove( pkey );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		subdict = dictByRelPrevIdx.get( keyRelPrevIdx );
		subdict.remove( pkey );

		subdict = dictByRelNextIdx.get( keyRelNextIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteRelationColByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffRelationCol cur;
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationColByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId,
		String argName )
	{
		BusModelBuffRelationColByUNameIdxKey key = (BusModelBuffRelationColByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByUNameIdxKey();
		key.setRequiredRelationId( argRelationId );
		key.setRequiredName( argName );
		deleteRelationColByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteRelationColByUNameIdx( ISecureAuthorization Authorization,
		IBusModelRelationColByUNameIdxKey argKey )
	{
		BusModelBuffRelationCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationColByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffRelationColByRelationIdxKey key = (BusModelBuffRelationColByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelationIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteRelationColByRelationIdx( Authorization, key );
	}

	@Override
	public void deleteRelationColByRelationIdx( ISecureAuthorization Authorization,
		IBusModelRelationColByRelationIdxKey argKey )
	{
		BusModelBuffRelationCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationColByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffRelationColByDefSchemaIdxKey key = (BusModelBuffRelationColByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteRelationColByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteRelationColByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelRelationColByDefSchemaIdxKey argKey )
	{
		BusModelBuffRelationCol cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationColByFromColIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argFromColId )
	{
		BusModelBuffRelationColByFromColIdxKey key = (BusModelBuffRelationColByFromColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByFromColIdxKey();
		key.setRequiredFromColId( argFromColId );
		deleteRelationColByFromColIdx( Authorization, key );
	}

	@Override
	public void deleteRelationColByFromColIdx( ISecureAuthorization Authorization,
		IBusModelRelationColByFromColIdxKey argKey )
	{
		BusModelBuffRelationCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationColByToColIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argToColId )
	{
		BusModelBuffRelationColByToColIdxKey key = (BusModelBuffRelationColByToColIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByToColIdxKey();
		key.setRequiredToColId( argToColId );
		deleteRelationColByToColIdx( Authorization, key );
	}

	@Override
	public void deleteRelationColByToColIdx( ISecureAuthorization Authorization,
		IBusModelRelationColByToColIdxKey argKey )
	{
		BusModelBuffRelationCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationColByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffRelationColByPrevIdxKey key = (BusModelBuffRelationColByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByPrevIdxKey();
		key.setOptionalPrevId( argPrevId );
		deleteRelationColByPrevIdx( Authorization, key );
	}

	@Override
	public void deleteRelationColByPrevIdx( ISecureAuthorization Authorization,
		IBusModelRelationColByPrevIdxKey argKey )
	{
		BusModelBuffRelationCol cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationColByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffRelationColByNextIdxKey key = (BusModelBuffRelationColByNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByNextIdxKey();
		key.setOptionalNextId( argNextId );
		deleteRelationColByNextIdx( Authorization, key );
	}

	@Override
	public void deleteRelationColByNextIdx( ISecureAuthorization Authorization,
		IBusModelRelationColByNextIdxKey argKey )
	{
		BusModelBuffRelationCol cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationColByRelPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffRelationColByRelPrevIdxKey key = (BusModelBuffRelationColByRelPrevIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelPrevIdxKey();
		key.setRequiredRelationId( argRelationId );
		key.setOptionalPrevId( argPrevId );
		deleteRelationColByRelPrevIdx( Authorization, key );
	}

	@Override
	public void deleteRelationColByRelPrevIdx( ISecureAuthorization Authorization,
		IBusModelRelationColByRelPrevIdxKey argKey )
	{
		BusModelBuffRelationCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationColByRelNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffRelationColByRelNextIdxKey key = (BusModelBuffRelationColByRelNextIdxKey)schema.getBusModelBuffFactory().getFactoryRelationCol().newByRelNextIdxKey();
		key.setRequiredRelationId( argRelationId );
		key.setOptionalNextId( argNextId );
		deleteRelationColByRelNextIdx( Authorization, key );
	}

	@Override
	public void deleteRelationColByRelNextIdx( ISecureAuthorization Authorization,
		IBusModelRelationColByRelNextIdxKey argKey )
	{
		BusModelBuffRelationCol cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelationCol> matchSet = new LinkedList<BusModelBuffRelationCol>();
		Iterator<BusModelBuffRelationCol> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelationCol> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelationCol)(schema.getTableRelationCol().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelationCol( Authorization, cur );
		}
	}
}
