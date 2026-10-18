
// Description: Java 25 in-memory RAM DbIO implementation for Chain.

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
 *	BusModelRamChainTable in-memory RAM DbIO implementation
 *	for Chain.
 */
public class BusModelRamChainTable
	implements IBusModelChainTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffChain > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffChain >();
	private Map< BusModelBuffChainByChainTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffChain >> dictByChainTableIdx
		= new HashMap< BusModelBuffChainByChainTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffChain >>();
	private Map< BusModelBuffChainByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffChain >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffChainByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffChain >>();
	private Map< BusModelBuffChainByUNameIdxKey,
			BusModelBuffChain > dictByUNameIdx
		= new HashMap< BusModelBuffChainByUNameIdxKey,
			BusModelBuffChain >();
	private Map< BusModelBuffChainByPrevRelIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffChain >> dictByPrevRelIdx
		= new HashMap< BusModelBuffChainByPrevRelIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffChain >>();
	private Map< BusModelBuffChainByNextRelIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffChain >> dictByNextRelIdx
		= new HashMap< BusModelBuffChainByNextRelIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffChain >>();

	public BusModelRamChainTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffChain ensureRec(IBusModelChain rec) {
		return (((BusModelBuffChainFactoryService)(schema.getBusModelBuffFactory().getFactoryChain())).ensureRec(rec));
	}

	@Override
	public IBusModelChain createChain( ISecureAuthorization Authorization,
		IBusModelChain iBuff )
	{
		final String S_ProcName = "createChain";
		
		BusModelBuffChain Buff = (BusModelBuffChain)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextChainIdGen();
		Buff.setRequiredId( pkey );
		BusModelBuffChainByChainTableIdxKey keyChainTableIdx = (BusModelBuffChainByChainTableIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByChainTableIdxKey();
		keyChainTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffChainByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffChainByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffChainByUNameIdxKey keyUNameIdx = (BusModelBuffChainByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffChainByPrevRelIdxKey keyPrevRelIdx = (BusModelBuffChainByPrevRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByPrevRelIdxKey();
		keyPrevRelIdx.setRequiredPrevRelationId( Buff.getRequiredPrevRelationId() );

		BusModelBuffChainByNextRelIdxKey keyNextRelIdx = (BusModelBuffChainByNextRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByNextRelIdxKey();
		keyNextRelIdx.setRequiredNextRelationId( Buff.getRequiredNextRelationId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ChainUNameIdx",
				"ChainUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTableId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"Table",
						"Table",
						"Table",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPrevRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"PrevRelation",
						"PrevRelation",
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
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredNextRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"NextRelation",
						"NextRelation",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictChainTableIdx;
		if( dictByChainTableIdx.containsKey( keyChainTableIdx ) ) {
			subdictChainTableIdx = dictByChainTableIdx.get( keyChainTableIdx );
		}
		else {
			subdictChainTableIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByChainTableIdx.put( keyChainTableIdx, subdictChainTableIdx );
		}
		subdictChainTableIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictPrevRelIdx;
		if( dictByPrevRelIdx.containsKey( keyPrevRelIdx ) ) {
			subdictPrevRelIdx = dictByPrevRelIdx.get( keyPrevRelIdx );
		}
		else {
			subdictPrevRelIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByPrevRelIdx.put( keyPrevRelIdx, subdictPrevRelIdx );
		}
		subdictPrevRelIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictNextRelIdx;
		if( dictByNextRelIdx.containsKey( keyNextRelIdx ) ) {
			subdictNextRelIdx = dictByNextRelIdx.get( keyNextRelIdx );
		}
		else {
			subdictNextRelIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByNextRelIdx.put( keyNextRelIdx, subdictNextRelIdx );
		}
		subdictNextRelIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelChain.CLASS_CODE) {
				BusModelBuffChain retbuff = ((BusModelBuffChain)(schema.getBusModelBuffFactory().getFactoryChain().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelChain readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamChain.readDerived";
		IBusModelChain buff;
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
	public IBusModelChain lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamChain.lockDerived";
		IBusModelChain buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelChain[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamChain.readAllDerived";
		IBusModelChain[] retList = new IBusModelChain[ dictByPKey.values().size() ];
		Iterator< BusModelBuffChain > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelChain[] readDerivedByChainTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamChain.readDerivedByChainTableIdx";
		BusModelBuffChainByChainTableIdxKey key = (BusModelBuffChainByChainTableIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByChainTableIdxKey();

		key.setRequiredTableId( TableId );
		IBusModelChain[] recArray;
		if( dictByChainTableIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictChainTableIdx
				= dictByChainTableIdx.get( key );
			recArray = new IBusModelChain[ subdictChainTableIdx.size() ];
			Iterator< BusModelBuffChain > iter = subdictChainTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictChainTableIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByChainTableIdx.put( key, subdictChainTableIdx );
			recArray = new IBusModelChain[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelChain[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamChain.readDerivedByDefSchemaIdx";
		BusModelBuffChainByDefSchemaIdxKey key = (BusModelBuffChainByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelChain[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelChain[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffChain > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelChain[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelChain readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamChain.readDerivedByUNameIdx";
		BusModelBuffChainByUNameIdxKey key = (BusModelBuffChainByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByUNameIdxKey();

		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelChain buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelChain[] readDerivedByPrevRelIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevRelationId )
	{
		final String S_ProcName = "BusModelRamChain.readDerivedByPrevRelIdx";
		BusModelBuffChainByPrevRelIdxKey key = (BusModelBuffChainByPrevRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByPrevRelIdxKey();

		key.setRequiredPrevRelationId( PrevRelationId );
		IBusModelChain[] recArray;
		if( dictByPrevRelIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictPrevRelIdx
				= dictByPrevRelIdx.get( key );
			recArray = new IBusModelChain[ subdictPrevRelIdx.size() ];
			Iterator< BusModelBuffChain > iter = subdictPrevRelIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictPrevRelIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByPrevRelIdx.put( key, subdictPrevRelIdx );
			recArray = new IBusModelChain[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelChain[] readDerivedByNextRelIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextRelationId )
	{
		final String S_ProcName = "BusModelRamChain.readDerivedByNextRelIdx";
		BusModelBuffChainByNextRelIdxKey key = (BusModelBuffChainByNextRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByNextRelIdxKey();

		key.setRequiredNextRelationId( NextRelationId );
		IBusModelChain[] recArray;
		if( dictByNextRelIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictNextRelIdx
				= dictByNextRelIdx.get( key );
			recArray = new IBusModelChain[ subdictNextRelIdx.size() ];
			Iterator< BusModelBuffChain > iter = subdictNextRelIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdictNextRelIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByNextRelIdx.put( key, subdictNextRelIdx );
			recArray = new IBusModelChain[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelChain readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamChain.readDerivedByIdIdx() ";
		IBusModelChain buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelChain readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamChain.readRec";
		IBusModelChain buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelChain.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelChain lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelChain buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelChain.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelChain[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamChain.readAllRec";
		IBusModelChain buff;
		ArrayList<IBusModelChain> filteredList = new ArrayList<IBusModelChain>();
		IBusModelChain[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelChain.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelChain[0] ) );
	}

	@Override
	public IBusModelChain readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamChain.readRecByIdIdx() ";
		IBusModelChain buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelChain.CLASS_CODE ) ) {
			return( (IBusModelChain)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelChain[] readRecByChainTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamChain.readRecByChainTableIdx() ";
		IBusModelChain buff;
		ArrayList<IBusModelChain> filteredList = new ArrayList<IBusModelChain>();
		IBusModelChain[] buffList = readDerivedByChainTableIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelChain.CLASS_CODE ) ) {
				filteredList.add( (IBusModelChain)buff );
			}
		}
		return( filteredList.toArray( new IBusModelChain[0] ) );
	}

	@Override
	public IBusModelChain[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamChain.readRecByDefSchemaIdx() ";
		IBusModelChain buff;
		ArrayList<IBusModelChain> filteredList = new ArrayList<IBusModelChain>();
		IBusModelChain[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelChain.CLASS_CODE ) ) {
				filteredList.add( (IBusModelChain)buff );
			}
		}
		return( filteredList.toArray( new IBusModelChain[0] ) );
	}

	@Override
	public IBusModelChain readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamChain.readRecByUNameIdx() ";
		IBusModelChain buff = readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelChain.CLASS_CODE ) ) {
			return( (IBusModelChain)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelChain[] readRecByPrevRelIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevRelationId )
	{
		final String S_ProcName = "BusModelRamChain.readRecByPrevRelIdx() ";
		IBusModelChain buff;
		ArrayList<IBusModelChain> filteredList = new ArrayList<IBusModelChain>();
		IBusModelChain[] buffList = readDerivedByPrevRelIdx( Authorization,
			PrevRelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelChain.CLASS_CODE ) ) {
				filteredList.add( (IBusModelChain)buff );
			}
		}
		return( filteredList.toArray( new IBusModelChain[0] ) );
	}

	@Override
	public IBusModelChain[] readRecByNextRelIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextRelationId )
	{
		final String S_ProcName = "BusModelRamChain.readRecByNextRelIdx() ";
		IBusModelChain buff;
		ArrayList<IBusModelChain> filteredList = new ArrayList<IBusModelChain>();
		IBusModelChain[] buffList = readDerivedByNextRelIdx( Authorization,
			NextRelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelChain.CLASS_CODE ) ) {
				filteredList.add( (IBusModelChain)buff );
			}
		}
		return( filteredList.toArray( new IBusModelChain[0] ) );
	}

	public IBusModelChain updateChain( ISecureAuthorization Authorization,
		IBusModelChain iBuff )
	{
		BusModelBuffChain Buff = (BusModelBuffChain)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffChain existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateChain",
				"Existing record not found",
				"Existing record not found",
				"Chain",
				"Chain",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateChain",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		BusModelBuffChainByChainTableIdxKey existingKeyChainTableIdx = (BusModelBuffChainByChainTableIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByChainTableIdxKey();
		existingKeyChainTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffChainByChainTableIdxKey newKeyChainTableIdx = (BusModelBuffChainByChainTableIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByChainTableIdxKey();
		newKeyChainTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffChainByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffChainByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffChainByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffChainByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffChainByUNameIdxKey existingKeyUNameIdx = (BusModelBuffChainByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffChainByUNameIdxKey newKeyUNameIdx = (BusModelBuffChainByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffChainByPrevRelIdxKey existingKeyPrevRelIdx = (BusModelBuffChainByPrevRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByPrevRelIdxKey();
		existingKeyPrevRelIdx.setRequiredPrevRelationId( existing.getRequiredPrevRelationId() );

		BusModelBuffChainByPrevRelIdxKey newKeyPrevRelIdx = (BusModelBuffChainByPrevRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByPrevRelIdxKey();
		newKeyPrevRelIdx.setRequiredPrevRelationId( Buff.getRequiredPrevRelationId() );

		BusModelBuffChainByNextRelIdxKey existingKeyNextRelIdx = (BusModelBuffChainByNextRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByNextRelIdxKey();
		existingKeyNextRelIdx.setRequiredNextRelationId( existing.getRequiredNextRelationId() );

		BusModelBuffChainByNextRelIdxKey newKeyNextRelIdx = (BusModelBuffChainByNextRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByNextRelIdxKey();
		newKeyNextRelIdx.setRequiredNextRelationId( Buff.getRequiredNextRelationId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateChain",
					"ChainUNameIdx",
					"ChainUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTableId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateChain",
						"Container",
						"Container",
						"Table",
						"Table",
						"Table",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPrevRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateChain",
						"Lookup",
						"Lookup",
						"PrevRelation",
						"PrevRelation",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredNextRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateChain",
						"Lookup",
						"Lookup",
						"NextRelation",
						"NextRelation",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByChainTableIdx.get( existingKeyChainTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByChainTableIdx.containsKey( newKeyChainTableIdx ) ) {
			subdict = dictByChainTableIdx.get( newKeyChainTableIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByChainTableIdx.put( newKeyChainTableIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByPrevRelIdx.get( existingKeyPrevRelIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevRelIdx.containsKey( newKeyPrevRelIdx ) ) {
			subdict = dictByPrevRelIdx.get( newKeyPrevRelIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByPrevRelIdx.put( newKeyPrevRelIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNextRelIdx.get( existingKeyNextRelIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNextRelIdx.containsKey( newKeyNextRelIdx ) ) {
			subdict = dictByNextRelIdx.get( newKeyNextRelIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffChain >();
			dictByNextRelIdx.put( newKeyNextRelIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteChain( ISecureAuthorization Authorization,
		IBusModelChain iBuff )
	{
		final String S_ProcName = "BusModelRamChainTable.deleteChain() ";
		BusModelBuffChain Buff = (BusModelBuffChain)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffChain existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteChain",
				pkey );
		}
		BusModelBuffChainByChainTableIdxKey keyChainTableIdx = (BusModelBuffChainByChainTableIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByChainTableIdxKey();
		keyChainTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffChainByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffChainByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffChainByUNameIdxKey keyUNameIdx = (BusModelBuffChainByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffChainByPrevRelIdxKey keyPrevRelIdx = (BusModelBuffChainByPrevRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByPrevRelIdxKey();
		keyPrevRelIdx.setRequiredPrevRelationId( existing.getRequiredPrevRelationId() );

		BusModelBuffChainByNextRelIdxKey keyNextRelIdx = (BusModelBuffChainByNextRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByNextRelIdxKey();
		keyNextRelIdx.setRequiredNextRelationId( existing.getRequiredNextRelationId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffChain > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByChainTableIdx.get( keyChainTableIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByPrevRelIdx.get( keyPrevRelIdx );
		subdict.remove( pkey );

		subdict = dictByNextRelIdx.get( keyNextRelIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteChainByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffChain cur;
		LinkedList<BusModelBuffChain> matchSet = new LinkedList<BusModelBuffChain>();
		Iterator<BusModelBuffChain> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffChain> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffChain)(schema.getTableChain().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteChain( Authorization, cur );
		}
	}

	@Override
	public void deleteChainByChainTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffChainByChainTableIdxKey key = (BusModelBuffChainByChainTableIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByChainTableIdxKey();
		key.setRequiredTableId( argTableId );
		deleteChainByChainTableIdx( Authorization, key );
	}

	@Override
	public void deleteChainByChainTableIdx( ISecureAuthorization Authorization,
		IBusModelChainByChainTableIdxKey argKey )
	{
		BusModelBuffChain cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffChain> matchSet = new LinkedList<BusModelBuffChain>();
		Iterator<BusModelBuffChain> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffChain> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffChain)(schema.getTableChain().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteChain( Authorization, cur );
		}
	}

	@Override
	public void deleteChainByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffChainByDefSchemaIdxKey key = (BusModelBuffChainByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteChainByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteChainByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelChainByDefSchemaIdxKey argKey )
	{
		BusModelBuffChain cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffChain> matchSet = new LinkedList<BusModelBuffChain>();
		Iterator<BusModelBuffChain> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffChain> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffChain)(schema.getTableChain().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteChain( Authorization, cur );
		}
	}

	@Override
	public void deleteChainByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		BusModelBuffChainByUNameIdxKey key = (BusModelBuffChainByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByUNameIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteChainByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteChainByUNameIdx( ISecureAuthorization Authorization,
		IBusModelChainByUNameIdxKey argKey )
	{
		BusModelBuffChain cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffChain> matchSet = new LinkedList<BusModelBuffChain>();
		Iterator<BusModelBuffChain> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffChain> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffChain)(schema.getTableChain().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteChain( Authorization, cur );
		}
	}

	@Override
	public void deleteChainByPrevRelIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevRelationId )
	{
		BusModelBuffChainByPrevRelIdxKey key = (BusModelBuffChainByPrevRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByPrevRelIdxKey();
		key.setRequiredPrevRelationId( argPrevRelationId );
		deleteChainByPrevRelIdx( Authorization, key );
	}

	@Override
	public void deleteChainByPrevRelIdx( ISecureAuthorization Authorization,
		IBusModelChainByPrevRelIdxKey argKey )
	{
		BusModelBuffChain cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffChain> matchSet = new LinkedList<BusModelBuffChain>();
		Iterator<BusModelBuffChain> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffChain> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffChain)(schema.getTableChain().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteChain( Authorization, cur );
		}
	}

	@Override
	public void deleteChainByNextRelIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextRelationId )
	{
		BusModelBuffChainByNextRelIdxKey key = (BusModelBuffChainByNextRelIdxKey)schema.getBusModelBuffFactory().getFactoryChain().newByNextRelIdxKey();
		key.setRequiredNextRelationId( argNextRelationId );
		deleteChainByNextRelIdx( Authorization, key );
	}

	@Override
	public void deleteChainByNextRelIdx( ISecureAuthorization Authorization,
		IBusModelChainByNextRelIdxKey argKey )
	{
		BusModelBuffChain cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffChain> matchSet = new LinkedList<BusModelBuffChain>();
		Iterator<BusModelBuffChain> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffChain> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffChain)(schema.getTableChain().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteChain( Authorization, cur );
		}
	}
}
