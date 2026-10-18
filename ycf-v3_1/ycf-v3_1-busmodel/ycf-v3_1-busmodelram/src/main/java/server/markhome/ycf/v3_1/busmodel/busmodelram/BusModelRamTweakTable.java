
// Description: Java 25 in-memory RAM DbIO implementation for Tweak.

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
 *	BusModelRamTweakTable in-memory RAM DbIO implementation
 *	for Tweak.
 */
public class BusModelRamTweakTable
	implements IBusModelTweakTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffTweak > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffTweak >();
	private Map< BusModelBuffTweakByUNameIdxKey,
			BusModelBuffTweak > dictByUNameIdx
		= new HashMap< BusModelBuffTweakByUNameIdxKey,
			BusModelBuffTweak >();
	private Map< BusModelBuffTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTweak >> dictByValTentIdx
		= new HashMap< BusModelBuffTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTweak >>();
	private Map< BusModelBuffTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTweak >> dictByScopeIdx
		= new HashMap< BusModelBuffTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTweak >>();
	private Map< BusModelBuffTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTweak >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTweak >>();
	private Map< BusModelBuffTweakByUDefIdxKey,
			BusModelBuffTweak > dictByUDefIdx
		= new HashMap< BusModelBuffTweakByUDefIdxKey,
			BusModelBuffTweak >();

	public BusModelRamTweakTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffTweak ensureRec(IBusModelTweak rec) {
		return (((BusModelBuffTweakFactoryService)(schema.getBusModelBuffFactory().getFactoryTweak())).ensureRec(rec));
	}

	@Override
	public IBusModelTweak createTweak( ISecureAuthorization Authorization,
		IBusModelTweak iBuff )
	{
		final String S_ProcName = "createTweak";
		
		BusModelBuffTweak Buff = (BusModelBuffTweak)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextTweakIdGen();
		Buff.setRequiredId( pkey );
		BusModelBuffTweakByUNameIdxKey keyUNameIdx = (BusModelBuffTweakByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUNameIdxKey();
		keyUNameIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffTweakByValTentIdxKey keyValTentIdx = (BusModelBuffTweakByValTentIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByValTentIdxKey();
		keyValTentIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		BusModelBuffTweakByScopeIdxKey keyScopeIdx = (BusModelBuffTweakByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByScopeIdxKey();
		keyScopeIdx.setRequiredScopeId( Buff.getRequiredScopeId() );

		BusModelBuffTweakByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffTweakByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffTweakByUDefIdxKey keyUDefIdx = (BusModelBuffTweakByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUDefIdxKey();
		keyUDefIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUDefIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		keyUDefIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		keyUDefIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );
		keyUDefIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TweakUNameIdx",
				"TweakUNameIdx",
				keyUNameIdx );
		}

		if( dictByUDefIdx.containsKey( keyUDefIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TweakUDefIdx",
				"TweakUDefIdx",
				keyUDefIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredScopeId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"Scope",
						"Scope",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdictValTentIdx;
		if( dictByValTentIdx.containsKey( keyValTentIdx ) ) {
			subdictValTentIdx = dictByValTentIdx.get( keyValTentIdx );
		}
		else {
			subdictValTentIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTweak >();
			dictByValTentIdx.put( keyValTentIdx, subdictValTentIdx );
		}
		subdictValTentIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdictScopeIdx;
		if( dictByScopeIdx.containsKey( keyScopeIdx ) ) {
			subdictScopeIdx = dictByScopeIdx.get( keyScopeIdx );
		}
		else {
			subdictScopeIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTweak >();
			dictByScopeIdx.put( keyScopeIdx, subdictScopeIdx );
		}
		subdictScopeIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTweak >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		dictByUDefIdx.put( keyUDefIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelTweak.CLASS_CODE) {
				BusModelBuffTweak retbuff = ((BusModelBuffTweak)(schema.getBusModelBuffFactory().getFactoryTweak().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTableTweak.CLASS_CODE) {
				BusModelBuffTableTweak retbuff = ((BusModelBuffTableTweak)(schema.getBusModelBuffFactory().getFactoryTableTweak().newRec()));
				retbuff.set((IBusModelTableTweak)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelSchemaTweak.CLASS_CODE) {
				BusModelBuffSchemaTweak retbuff = ((BusModelBuffSchemaTweak)(schema.getBusModelBuffFactory().getFactorySchemaTweak().newRec()));
				retbuff.set((IBusModelSchemaTweak)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelIndexTweak.CLASS_CODE) {
				BusModelBuffIndexTweak retbuff = ((BusModelBuffIndexTweak)(schema.getBusModelBuffFactory().getFactoryIndexTweak().newRec()));
				retbuff.set((IBusModelIndexTweak)Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelTweak readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamTweak.readDerived";
		IBusModelTweak buff;
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
	public IBusModelTweak lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamTweak.lockDerived";
		IBusModelTweak buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTweak[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamTweak.readAllDerived";
		IBusModelTweak[] retList = new IBusModelTweak[ dictByPKey.values().size() ];
		Iterator< BusModelBuffTweak > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelTweak readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByUNameIdx";
		BusModelBuffTweakByUNameIdxKey key = (BusModelBuffTweakByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUNameIdxKey();

		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelTweak buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTweak[] readDerivedByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByValTentIdx";
		BusModelBuffTweakByValTentIdxKey key = (BusModelBuffTweakByValTentIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByValTentIdxKey();

		key.setRequiredTenantId( TenantId );
		IBusModelTweak[] recArray;
		if( dictByValTentIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdictValTentIdx
				= dictByValTentIdx.get( key );
			recArray = new IBusModelTweak[ subdictValTentIdx.size() ];
			Iterator< BusModelBuffTweak > iter = subdictValTentIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdictValTentIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTweak >();
			dictByValTentIdx.put( key, subdictValTentIdx );
			recArray = new IBusModelTweak[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTweak[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByScopeIdx";
		BusModelBuffTweakByScopeIdxKey key = (BusModelBuffTweakByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByScopeIdxKey();

		key.setRequiredScopeId( ScopeId );
		IBusModelTweak[] recArray;
		if( dictByScopeIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdictScopeIdx
				= dictByScopeIdx.get( key );
			recArray = new IBusModelTweak[ subdictScopeIdx.size() ];
			Iterator< BusModelBuffTweak > iter = subdictScopeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdictScopeIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTweak >();
			dictByScopeIdx.put( key, subdictScopeIdx );
			recArray = new IBusModelTweak[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTweak[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByDefSchemaIdx";
		BusModelBuffTweakByDefSchemaIdxKey key = (BusModelBuffTweakByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelTweak[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelTweak[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffTweak > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTweak >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelTweak[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTweak readDerivedByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByUDefIdx";
		BusModelBuffTweakByUDefIdxKey key = (BusModelBuffTweakByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUDefIdxKey();

		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelTweak buff;
		if( dictByUDefIdx.containsKey( key ) ) {
			buff = dictByUDefIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTweak readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByIdIdx() ";
		IBusModelTweak buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTweak readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamTweak.readRec";
		IBusModelTweak buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelTweak.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTweak lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelTweak buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelTweak.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTweak[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamTweak.readAllRec";
		IBusModelTweak buff;
		ArrayList<IBusModelTweak> filteredList = new ArrayList<IBusModelTweak>();
		IBusModelTweak[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelTweak[0] ) );
	}

	@Override
	public IBusModelTweak readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByIdIdx() ";
		IBusModelTweak buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTweak readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByUNameIdx() ";
		IBusModelTweak buff = readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTweak[] readRecByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByValTentIdx() ";
		IBusModelTweak buff;
		ArrayList<IBusModelTweak> filteredList = new ArrayList<IBusModelTweak>();
		IBusModelTweak[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTweak[0] ) );
	}

	@Override
	public IBusModelTweak[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByScopeIdx() ";
		IBusModelTweak buff;
		ArrayList<IBusModelTweak> filteredList = new ArrayList<IBusModelTweak>();
		IBusModelTweak[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTweak[0] ) );
	}

	@Override
	public IBusModelTweak[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByDefSchemaIdx() ";
		IBusModelTweak buff;
		ArrayList<IBusModelTweak> filteredList = new ArrayList<IBusModelTweak>();
		IBusModelTweak[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTweak[0] ) );
	}

	@Override
	public IBusModelTweak readRecByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByUDefIdx() ";
		IBusModelTweak buff = readDerivedByUDefIdx( Authorization,
			TenantId,
			ScopeId,
			DefSchemaTenantId,
			DefSchemaId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelTweak)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelTweak updateTweak( ISecureAuthorization Authorization,
		IBusModelTweak iBuff )
	{
		BusModelBuffTweak Buff = (BusModelBuffTweak)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffTweak existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateTweak",
				"Existing record not found",
				"Existing record not found",
				"Tweak",
				"Tweak",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateTweak",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		BusModelBuffTweakByUNameIdxKey existingKeyUNameIdx = (BusModelBuffTweakByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffTweakByUNameIdxKey newKeyUNameIdx = (BusModelBuffTweakByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffTweakByValTentIdxKey existingKeyValTentIdx = (BusModelBuffTweakByValTentIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByValTentIdxKey();
		existingKeyValTentIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		BusModelBuffTweakByValTentIdxKey newKeyValTentIdx = (BusModelBuffTweakByValTentIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByValTentIdxKey();
		newKeyValTentIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		BusModelBuffTweakByScopeIdxKey existingKeyScopeIdx = (BusModelBuffTweakByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByScopeIdxKey();
		existingKeyScopeIdx.setRequiredScopeId( existing.getRequiredScopeId() );

		BusModelBuffTweakByScopeIdxKey newKeyScopeIdx = (BusModelBuffTweakByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByScopeIdxKey();
		newKeyScopeIdx.setRequiredScopeId( Buff.getRequiredScopeId() );

		BusModelBuffTweakByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffTweakByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffTweakByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffTweakByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffTweakByUDefIdxKey existingKeyUDefIdx = (BusModelBuffTweakByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUDefIdxKey();
		existingKeyUDefIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUDefIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		existingKeyUDefIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		existingKeyUDefIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );
		existingKeyUDefIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffTweakByUDefIdxKey newKeyUDefIdx = (BusModelBuffTweakByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUDefIdxKey();
		newKeyUDefIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUDefIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		newKeyUDefIdx.setOptionalDefSchemaTenantId( Buff.getOptionalDefSchemaTenantId() );
		newKeyUDefIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );
		newKeyUDefIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTweak",
					"TweakUNameIdx",
					"TweakUNameIdx",
					newKeyUNameIdx );
			}
		}

		if( ! existingKeyUDefIdx.equals( newKeyUDefIdx ) ) {
			if( dictByUDefIdx.containsKey( newKeyUDefIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTweak",
					"TweakUDefIdx",
					"TweakUDefIdx",
					newKeyUDefIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredScopeId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateTweak",
						"Container",
						"Container",
						"Scope",
						"Scope",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByValTentIdx.get( existingKeyValTentIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByValTentIdx.containsKey( newKeyValTentIdx ) ) {
			subdict = dictByValTentIdx.get( newKeyValTentIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTweak >();
			dictByValTentIdx.put( newKeyValTentIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByScopeIdx.get( existingKeyScopeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByScopeIdx.containsKey( newKeyScopeIdx ) ) {
			subdict = dictByScopeIdx.get( newKeyScopeIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTweak >();
			dictByScopeIdx.put( newKeyScopeIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTweak >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUDefIdx.remove( existingKeyUDefIdx );
		dictByUDefIdx.put( newKeyUDefIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteTweak( ISecureAuthorization Authorization,
		IBusModelTweak iBuff )
	{
		final String S_ProcName = "BusModelRamTweakTable.deleteTweak() ";
		BusModelBuffTweak Buff = (BusModelBuffTweak)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffTweak existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteTweak",
				pkey );
		}
		BusModelBuffTweakByUNameIdxKey keyUNameIdx = (BusModelBuffTweakByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUNameIdxKey();
		keyUNameIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffTweakByValTentIdxKey keyValTentIdx = (BusModelBuffTweakByValTentIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByValTentIdxKey();
		keyValTentIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		BusModelBuffTweakByScopeIdxKey keyScopeIdx = (BusModelBuffTweakByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByScopeIdxKey();
		keyScopeIdx.setRequiredScopeId( existing.getRequiredScopeId() );

		BusModelBuffTweakByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffTweakByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffTweakByUDefIdxKey keyUDefIdx = (BusModelBuffTweakByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUDefIdxKey();
		keyUDefIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUDefIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUDefIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyUDefIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );
		keyUDefIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		if( schema.getTableTableTweak().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteTweak",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"TableTweak",
				"TableTweak",
				pkey );
		}

		if( schema.getTableSchemaTweak().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteTweak",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"SchemaTweak",
				"SchemaTweak",
				pkey );
		}

		if( schema.getTableIndexTweak().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteTweak",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"IndexTweak",
				"IndexTweak",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffTweak > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByValTentIdx.get( keyValTentIdx );
		subdict.remove( pkey );

		subdict = dictByScopeIdx.get( keyScopeIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		dictByUDefIdx.remove( keyUDefIdx );

	}
	@Override
	public void deleteTweakByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteTweakByIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffTweak cur;
		LinkedList<BusModelBuffTweak> matchSet = new LinkedList<BusModelBuffTweak>();
		Iterator<BusModelBuffTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTweak)(schema.getTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTweak().deleteTweak( Authorization, cur );
			}
			else if( IBusModelTableTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTableTweak().deleteTableTweak( Authorization, (IBusModelTableTweak)cur );
			}
			else if( IBusModelSchemaTweak.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaTweak().deleteSchemaTweak( Authorization, (IBusModelSchemaTweak)cur );
			}
			else if( IBusModelIndexTweak.CLASS_CODE == subClassCode ) {
				schema.getTableIndexTweak().deleteIndexTweak( Authorization, (IBusModelIndexTweak)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteTweakByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		BusModelBuffTweakByUNameIdxKey key = (BusModelBuffTweakByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteTweakByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteTweakByUNameIdx( ISecureAuthorization Authorization,
		IBusModelTweakByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteTweakByUNameIdx";
		BusModelBuffTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTweak> matchSet = new LinkedList<BusModelBuffTweak>();
		Iterator<BusModelBuffTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTweak)(schema.getTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTweak().deleteTweak( Authorization, cur );
			}
			else if( IBusModelTableTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTableTweak().deleteTableTweak( Authorization, (IBusModelTableTweak)cur );
			}
			else if( IBusModelSchemaTweak.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaTweak().deleteSchemaTweak( Authorization, (IBusModelSchemaTweak)cur );
			}
			else if( IBusModelIndexTweak.CLASS_CODE == subClassCode ) {
				schema.getTableIndexTweak().deleteIndexTweak( Authorization, (IBusModelIndexTweak)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteTweakByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffTweakByValTentIdxKey key = (BusModelBuffTweakByValTentIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTweakByValTentIdx( Authorization, key );
	}

	@Override
	public void deleteTweakByValTentIdx( ISecureAuthorization Authorization,
		IBusModelTweakByValTentIdxKey argKey )
	{
		final String S_ProcName = "deleteTweakByValTentIdx";
		BusModelBuffTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTweak> matchSet = new LinkedList<BusModelBuffTweak>();
		Iterator<BusModelBuffTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTweak)(schema.getTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTweak().deleteTweak( Authorization, cur );
			}
			else if( IBusModelTableTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTableTweak().deleteTableTweak( Authorization, (IBusModelTableTweak)cur );
			}
			else if( IBusModelSchemaTweak.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaTweak().deleteSchemaTweak( Authorization, (IBusModelSchemaTweak)cur );
			}
			else if( IBusModelIndexTweak.CLASS_CODE == subClassCode ) {
				schema.getTableIndexTweak().deleteIndexTweak( Authorization, (IBusModelIndexTweak)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteTweakByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		BusModelBuffTweakByScopeIdxKey key = (BusModelBuffTweakByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( argScopeId );
		deleteTweakByScopeIdx( Authorization, key );
	}

	@Override
	public void deleteTweakByScopeIdx( ISecureAuthorization Authorization,
		IBusModelTweakByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteTweakByScopeIdx";
		BusModelBuffTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTweak> matchSet = new LinkedList<BusModelBuffTweak>();
		Iterator<BusModelBuffTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTweak)(schema.getTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTweak().deleteTweak( Authorization, cur );
			}
			else if( IBusModelTableTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTableTweak().deleteTableTweak( Authorization, (IBusModelTableTweak)cur );
			}
			else if( IBusModelSchemaTweak.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaTweak().deleteSchemaTweak( Authorization, (IBusModelSchemaTweak)cur );
			}
			else if( IBusModelIndexTweak.CLASS_CODE == subClassCode ) {
				schema.getTableIndexTweak().deleteIndexTweak( Authorization, (IBusModelIndexTweak)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteTweakByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffTweakByDefSchemaIdxKey key = (BusModelBuffTweakByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteTweakByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteTweakByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelTweakByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteTweakByDefSchemaIdx";
		BusModelBuffTweak cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTweak> matchSet = new LinkedList<BusModelBuffTweak>();
		Iterator<BusModelBuffTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTweak)(schema.getTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTweak().deleteTweak( Authorization, cur );
			}
			else if( IBusModelTableTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTableTweak().deleteTableTweak( Authorization, (IBusModelTableTweak)cur );
			}
			else if( IBusModelSchemaTweak.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaTweak().deleteSchemaTweak( Authorization, (IBusModelSchemaTweak)cur );
			}
			else if( IBusModelIndexTweak.CLASS_CODE == subClassCode ) {
				schema.getTableIndexTweak().deleteIndexTweak( Authorization, (IBusModelIndexTweak)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteTweakByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argDefSchemaTenantId,
		IYCFKeyHash256 argDefSchemaId,
		String argName )
	{
		BusModelBuffTweakByUDefIdxKey key = (BusModelBuffTweakByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		key.setRequiredName( argName );
		deleteTweakByUDefIdx( Authorization, key );
	}

	@Override
	public void deleteTweakByUDefIdx( ISecureAuthorization Authorization,
		IBusModelTweakByUDefIdxKey argKey )
	{
		final String S_ProcName = "deleteTweakByUDefIdx";
		BusModelBuffTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( argKey.getOptionalDefSchemaTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTweak> matchSet = new LinkedList<BusModelBuffTweak>();
		Iterator<BusModelBuffTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTweak)(schema.getTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTweak().deleteTweak( Authorization, cur );
			}
			else if( IBusModelTableTweak.CLASS_CODE == subClassCode ) {
				schema.getTableTableTweak().deleteTableTweak( Authorization, (IBusModelTableTweak)cur );
			}
			else if( IBusModelSchemaTweak.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaTweak().deleteSchemaTweak( Authorization, (IBusModelSchemaTweak)cur );
			}
			else if( IBusModelIndexTweak.CLASS_CODE == subClassCode ) {
				schema.getTableIndexTweak().deleteIndexTweak( Authorization, (IBusModelIndexTweak)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}
}
