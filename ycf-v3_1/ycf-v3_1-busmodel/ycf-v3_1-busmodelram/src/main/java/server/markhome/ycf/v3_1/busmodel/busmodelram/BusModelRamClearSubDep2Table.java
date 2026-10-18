
// Description: Java 25 in-memory RAM DbIO implementation for ClearSubDep2.

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
 *	BusModelRamClearSubDep2Table in-memory RAM DbIO implementation
 *	for ClearSubDep2.
 */
public class BusModelRamClearSubDep2Table
	implements IBusModelClearSubDep2Table
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffClearSubDep2 > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffClearSubDep2 >();
	private Map< BusModelBuffClearSubDep2ByClearSubDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearSubDep2 >> dictByClearSubDep1Idx
		= new HashMap< BusModelBuffClearSubDep2ByClearSubDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearSubDep2 >>();
	private Map< BusModelBuffClearSubDep2ByUNameIdxKey,
			BusModelBuffClearSubDep2 > dictByUNameIdx
		= new HashMap< BusModelBuffClearSubDep2ByUNameIdxKey,
			BusModelBuffClearSubDep2 >();

	public BusModelRamClearSubDep2Table( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffScope ensureRec(IBusModelScope rec) {
		if (rec == null) {
			return( null );
		}
		else {
			return (((BusModelBuffScopeFactoryService)(schema.getBusModelBuffFactory().getFactoryScope())).ensureRec(rec));
		}
	}

	@Override
	public IBusModelClearSubDep2 createClearSubDep2( ISecureAuthorization Authorization,
		IBusModelClearSubDep2 iBuff )
	{
		final String S_ProcName = "createClearSubDep2";
		
		BusModelBuffClearSubDep2 Buff = (BusModelBuffClearSubDep2)(schema.getTableClearDep().createClearDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx = (BusModelBuffClearSubDep2ByClearSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
		keyClearSubDep1Idx.setRequiredClearSubDep1Id( Buff.getRequiredClearSubDep1Id() );

		BusModelBuffClearSubDep2ByUNameIdxKey keyUNameIdx = (BusModelBuffClearSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByUNameIdxKey();
		keyUNameIdx.setRequiredClearSubDep1Id( Buff.getRequiredClearSubDep1Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClearSubDep2UNameIdx",
				"ClearSubDep2UNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableClearDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"ClearDep",
						"ClearDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClearSubDep1Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ClearSubDep1",
						"ClearSubDep1",
						"ClearSubDep1",
						"ClearSubDep1",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep2 > subdictClearSubDep1Idx;
		if( dictByClearSubDep1Idx.containsKey( keyClearSubDep1Idx ) ) {
			subdictClearSubDep1Idx = dictByClearSubDep1Idx.get( keyClearSubDep1Idx );
		}
		else {
			subdictClearSubDep1Idx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep2 >();
			dictByClearSubDep1Idx.put( keyClearSubDep1Idx, subdictClearSubDep1Idx );
		}
		subdictClearSubDep1Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelClearSubDep2.CLASS_CODE) {
				BusModelBuffClearSubDep2 retbuff = ((BusModelBuffClearSubDep2)(schema.getBusModelBuffFactory().getFactoryClearSubDep2().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelClearSubDep2 readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearSubDep2.readDerived";
		IBusModelClearSubDep2 buff;
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
	public IBusModelClearSubDep2 lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearSubDep2.lockDerived";
		IBusModelClearSubDep2 buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep2[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamClearSubDep2.readAllDerived";
		IBusModelClearSubDep2[] retList = new IBusModelClearSubDep2[ dictByPKey.values().size() ];
		Iterator< BusModelBuffClearSubDep2 > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelClearSubDep2[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByTenantIdx";
		IBusModelScope buffList[] = schema.getTableScope().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelScope buff;
			ArrayList<IBusModelClearSubDep2> filteredList = new ArrayList<IBusModelClearSubDep2>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearSubDep2 ) ) {
					filteredList.add( (IBusModelClearSubDep2)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearSubDep2[0] ) );
		}
	}

	@Override
	public IBusModelClearSubDep2[] readDerivedByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamClearDep.readDerivedByClearDepIdx";
		IBusModelClearDep buffList[] = schema.getTableClearDep().readDerivedByClearDepIdx( Authorization,
			RelationId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelClearDep buff;
			ArrayList<IBusModelClearSubDep2> filteredList = new ArrayList<IBusModelClearSubDep2>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearSubDep2 ) ) {
					filteredList.add( (IBusModelClearSubDep2)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearSubDep2[0] ) );
		}
	}

	@Override
	public IBusModelClearSubDep2[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamClearDep.readDerivedByDefSchemaIdx";
		IBusModelClearDep buffList[] = schema.getTableClearDep().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelClearDep buff;
			ArrayList<IBusModelClearSubDep2> filteredList = new ArrayList<IBusModelClearSubDep2>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearSubDep2 ) ) {
					filteredList.add( (IBusModelClearSubDep2)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearSubDep2[0] ) );
		}
	}

	@Override
	public IBusModelClearSubDep2[] readDerivedByClearSubDep1Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearSubDep1Id )
	{
		final String S_ProcName = "BusModelRamClearSubDep2.readDerivedByClearSubDep1Idx";
		BusModelBuffClearSubDep2ByClearSubDep1IdxKey key = (BusModelBuffClearSubDep2ByClearSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();

		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		IBusModelClearSubDep2[] recArray;
		if( dictByClearSubDep1Idx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep2 > subdictClearSubDep1Idx
				= dictByClearSubDep1Idx.get( key );
			recArray = new IBusModelClearSubDep2[ subdictClearSubDep1Idx.size() ];
			Iterator< BusModelBuffClearSubDep2 > iter = subdictClearSubDep1Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep2 > subdictClearSubDep1Idx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep2 >();
			dictByClearSubDep1Idx.put( key, subdictClearSubDep1Idx );
			recArray = new IBusModelClearSubDep2[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelClearSubDep2 readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearSubDep1Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamClearSubDep2.readDerivedByUNameIdx";
		BusModelBuffClearSubDep2ByUNameIdxKey key = (BusModelBuffClearSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByUNameIdxKey();

		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		key.setRequiredName( Name );
		IBusModelClearSubDep2 buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep2 readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelClearSubDep2 buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep2 readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearSubDep2.readRec";
		IBusModelClearSubDep2 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearSubDep2.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep2 lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelClearSubDep2 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearSubDep2.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep2[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamClearSubDep2.readAllRec";
		IBusModelClearSubDep2 buff;
		ArrayList<IBusModelClearSubDep2> filteredList = new ArrayList<IBusModelClearSubDep2>();
		IBusModelClearSubDep2[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearSubDep2.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep2[0] ) );
	}

	@Override
	public IBusModelClearSubDep2 readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelClearSubDep2 buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelClearSubDep2)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelClearSubDep2[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelClearSubDep2 buff;
		ArrayList<IBusModelClearSubDep2> filteredList = new ArrayList<IBusModelClearSubDep2>();
		IBusModelClearSubDep2[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep2[0] ) );
	}

	@Override
	public IBusModelClearSubDep2[] readRecByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByClearDepIdx() ";
		IBusModelClearSubDep2 buff;
		ArrayList<IBusModelClearSubDep2> filteredList = new ArrayList<IBusModelClearSubDep2>();
		IBusModelClearSubDep2[] buffList = readDerivedByClearDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep2[0] ) );
	}

	@Override
	public IBusModelClearSubDep2[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByDefSchemaIdx() ";
		IBusModelClearSubDep2 buff;
		ArrayList<IBusModelClearSubDep2> filteredList = new ArrayList<IBusModelClearSubDep2>();
		IBusModelClearSubDep2[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep2[0] ) );
	}

	@Override
	public IBusModelClearSubDep2[] readRecByClearSubDep1Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearSubDep1Id )
	{
		final String S_ProcName = "BusModelRamClearSubDep2.readRecByClearSubDep1Idx() ";
		IBusModelClearSubDep2 buff;
		ArrayList<IBusModelClearSubDep2> filteredList = new ArrayList<IBusModelClearSubDep2>();
		IBusModelClearSubDep2[] buffList = readDerivedByClearSubDep1Idx( Authorization,
			ClearSubDep1Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearSubDep2.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep2[0] ) );
	}

	@Override
	public IBusModelClearSubDep2 readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearSubDep1Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamClearSubDep2.readRecByUNameIdx() ";
		IBusModelClearSubDep2 buff = readDerivedByUNameIdx( Authorization,
			ClearSubDep1Id,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearSubDep2.CLASS_CODE ) ) {
			return( (IBusModelClearSubDep2)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelClearSubDep2 updateClearSubDep2( ISecureAuthorization Authorization,
		IBusModelClearSubDep2 iBuff )
	{
		BusModelBuffClearSubDep2 Buff = (BusModelBuffClearSubDep2)(schema.getTableClearDep().updateClearDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearSubDep2 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateClearSubDep2",
				"Existing record not found",
				"Existing record not found",
				"ClearSubDep2",
				"ClearSubDep2",
				pkey );
		}
		BusModelBuffClearSubDep2ByClearSubDep1IdxKey existingKeyClearSubDep1Idx = (BusModelBuffClearSubDep2ByClearSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
		existingKeyClearSubDep1Idx.setRequiredClearSubDep1Id( existing.getRequiredClearSubDep1Id() );

		BusModelBuffClearSubDep2ByClearSubDep1IdxKey newKeyClearSubDep1Idx = (BusModelBuffClearSubDep2ByClearSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
		newKeyClearSubDep1Idx.setRequiredClearSubDep1Id( Buff.getRequiredClearSubDep1Id() );

		BusModelBuffClearSubDep2ByUNameIdxKey existingKeyUNameIdx = (BusModelBuffClearSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredClearSubDep1Id( existing.getRequiredClearSubDep1Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffClearSubDep2ByUNameIdxKey newKeyUNameIdx = (BusModelBuffClearSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredClearSubDep1Id( Buff.getRequiredClearSubDep1Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateClearSubDep2",
					"ClearSubDep2UNameIdx",
					"ClearSubDep2UNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableClearDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateClearSubDep2",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"ClearDep",
						"ClearDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClearSubDep1Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateClearSubDep2",
						"Container",
						"Container",
						"ClearSubDep1",
						"ClearSubDep1",
						"ClearSubDep1",
						"ClearSubDep1",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep2 > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClearSubDep1Idx.get( existingKeyClearSubDep1Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClearSubDep1Idx.containsKey( newKeyClearSubDep1Idx ) ) {
			subdict = dictByClearSubDep1Idx.get( newKeyClearSubDep1Idx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep2 >();
			dictByClearSubDep1Idx.put( newKeyClearSubDep1Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteClearSubDep2( ISecureAuthorization Authorization,
		IBusModelClearSubDep2 iBuff )
	{
		final String S_ProcName = "BusModelRamClearSubDep2Table.deleteClearSubDep2() ";
		BusModelBuffClearSubDep2 Buff = (BusModelBuffClearSubDep2)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffClearSubDep2 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteClearSubDep2",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckClearDep[] = schema.getTableClearSubDep3().readDerivedByClearSubDep2Idx( Authorization,
						existing.getRequiredId() );
		if( arrCheckClearDep.length > 0 ) {
			schema.getTableClearSubDep3().deleteClearSubDep3ByClearSubDep2Idx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx = (BusModelBuffClearSubDep2ByClearSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
		keyClearSubDep1Idx.setRequiredClearSubDep1Id( existing.getRequiredClearSubDep1Id() );

		BusModelBuffClearSubDep2ByUNameIdxKey keyUNameIdx = (BusModelBuffClearSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByUNameIdxKey();
		keyUNameIdx.setRequiredClearSubDep1Id( existing.getRequiredClearSubDep1Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep2 > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClearSubDep1Idx.get( keyClearSubDep1Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableClearDep().deleteClearDep( Authorization,
			Buff );
	}
	@Override
	public void deleteClearSubDep2ByClearSubDep1Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClearSubDep1Id )
	{
		BusModelBuffClearSubDep2ByClearSubDep1IdxKey key = (BusModelBuffClearSubDep2ByClearSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
		key.setRequiredClearSubDep1Id( argClearSubDep1Id );
		deleteClearSubDep2ByClearSubDep1Idx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep2ByClearSubDep1Idx( ISecureAuthorization Authorization,
		IBusModelClearSubDep2ByClearSubDep1IdxKey argKey )
	{
		BusModelBuffClearSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep2> matchSet = new LinkedList<BusModelBuffClearSubDep2>();
		Iterator<BusModelBuffClearSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep2)(schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep2ByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClearSubDep1Id,
		String argName )
	{
		BusModelBuffClearSubDep2ByUNameIdxKey key = (BusModelBuffClearSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep2().newByUNameIdxKey();
		key.setRequiredClearSubDep1Id( argClearSubDep1Id );
		key.setRequiredName( argName );
		deleteClearSubDep2ByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep2ByUNameIdx( ISecureAuthorization Authorization,
		IBusModelClearSubDep2ByUNameIdxKey argKey )
	{
		BusModelBuffClearSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep2> matchSet = new LinkedList<BusModelBuffClearSubDep2>();
		Iterator<BusModelBuffClearSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep2)(schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep2ByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffClearDepByClearDepIdxKey key = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteClearSubDep2ByClearDepIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep2ByClearDepIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByClearDepIdxKey argKey )
	{
		BusModelBuffClearSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep2> matchSet = new LinkedList<BusModelBuffClearSubDep2>();
		Iterator<BusModelBuffClearSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep2)(schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep2ByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffClearDepByDefSchemaIdxKey key = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteClearSubDep2ByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep2ByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffClearSubDep2 cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep2> matchSet = new LinkedList<BusModelBuffClearSubDep2>();
		Iterator<BusModelBuffClearSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep2)(schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep2ByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffClearSubDep2 cur;
		LinkedList<BusModelBuffClearSubDep2> matchSet = new LinkedList<BusModelBuffClearSubDep2>();
		Iterator<BusModelBuffClearSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep2)(schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep2ByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearSubDep2ByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep2ByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffClearSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep2> matchSet = new LinkedList<BusModelBuffClearSubDep2>();
		Iterator<BusModelBuffClearSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep2)(schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep2( Authorization, cur );
		}
	}
}
