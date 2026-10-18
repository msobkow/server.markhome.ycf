
// Description: Java 25 in-memory RAM DbIO implementation for ClearSubDep3.

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
 *	BusModelRamClearSubDep3Table in-memory RAM DbIO implementation
 *	for ClearSubDep3.
 */
public class BusModelRamClearSubDep3Table
	implements IBusModelClearSubDep3Table
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffClearSubDep3 > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffClearSubDep3 >();
	private Map< BusModelBuffClearSubDep3ByClearSubDep2IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearSubDep3 >> dictByClearSubDep2Idx
		= new HashMap< BusModelBuffClearSubDep3ByClearSubDep2IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearSubDep3 >>();
	private Map< BusModelBuffClearSubDep3ByUNameIdxKey,
			BusModelBuffClearSubDep3 > dictByUNameIdx
		= new HashMap< BusModelBuffClearSubDep3ByUNameIdxKey,
			BusModelBuffClearSubDep3 >();

	public BusModelRamClearSubDep3Table( IBusModelSchema argSchema ) {
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
	public IBusModelClearSubDep3 createClearSubDep3( ISecureAuthorization Authorization,
		IBusModelClearSubDep3 iBuff )
	{
		final String S_ProcName = "createClearSubDep3";
		
		BusModelBuffClearSubDep3 Buff = (BusModelBuffClearSubDep3)(schema.getTableClearDep().createClearDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearSubDep3ByClearSubDep2IdxKey keyClearSubDep2Idx = (BusModelBuffClearSubDep3ByClearSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByClearSubDep2IdxKey();
		keyClearSubDep2Idx.setRequiredClearSubDep2Id( Buff.getRequiredClearSubDep2Id() );

		BusModelBuffClearSubDep3ByUNameIdxKey keyUNameIdx = (BusModelBuffClearSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByUNameIdxKey();
		keyUNameIdx.setRequiredClearSubDep2Id( Buff.getRequiredClearSubDep2Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClearSubDep3UNameIdx",
				"ClearSubDep3UNameIdx",
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
				if( null == schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClearSubDep2Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ClearSubDep2",
						"ClearSubDep2",
						"ClearSubDep2",
						"ClearSubDep2",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep3 > subdictClearSubDep2Idx;
		if( dictByClearSubDep2Idx.containsKey( keyClearSubDep2Idx ) ) {
			subdictClearSubDep2Idx = dictByClearSubDep2Idx.get( keyClearSubDep2Idx );
		}
		else {
			subdictClearSubDep2Idx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep3 >();
			dictByClearSubDep2Idx.put( keyClearSubDep2Idx, subdictClearSubDep2Idx );
		}
		subdictClearSubDep2Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelClearSubDep3.CLASS_CODE) {
				BusModelBuffClearSubDep3 retbuff = ((BusModelBuffClearSubDep3)(schema.getBusModelBuffFactory().getFactoryClearSubDep3().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelClearSubDep3 readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearSubDep3.readDerived";
		IBusModelClearSubDep3 buff;
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
	public IBusModelClearSubDep3 lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearSubDep3.lockDerived";
		IBusModelClearSubDep3 buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep3[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamClearSubDep3.readAllDerived";
		IBusModelClearSubDep3[] retList = new IBusModelClearSubDep3[ dictByPKey.values().size() ];
		Iterator< BusModelBuffClearSubDep3 > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelClearSubDep3[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelClearSubDep3> filteredList = new ArrayList<IBusModelClearSubDep3>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearSubDep3 ) ) {
					filteredList.add( (IBusModelClearSubDep3)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearSubDep3[0] ) );
		}
	}

	@Override
	public IBusModelClearSubDep3[] readDerivedByClearDepIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelClearSubDep3> filteredList = new ArrayList<IBusModelClearSubDep3>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearSubDep3 ) ) {
					filteredList.add( (IBusModelClearSubDep3)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearSubDep3[0] ) );
		}
	}

	@Override
	public IBusModelClearSubDep3[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelClearSubDep3> filteredList = new ArrayList<IBusModelClearSubDep3>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearSubDep3 ) ) {
					filteredList.add( (IBusModelClearSubDep3)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearSubDep3[0] ) );
		}
	}

	@Override
	public IBusModelClearSubDep3[] readDerivedByClearSubDep2Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearSubDep2Id )
	{
		final String S_ProcName = "BusModelRamClearSubDep3.readDerivedByClearSubDep2Idx";
		BusModelBuffClearSubDep3ByClearSubDep2IdxKey key = (BusModelBuffClearSubDep3ByClearSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByClearSubDep2IdxKey();

		key.setRequiredClearSubDep2Id( ClearSubDep2Id );
		IBusModelClearSubDep3[] recArray;
		if( dictByClearSubDep2Idx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep3 > subdictClearSubDep2Idx
				= dictByClearSubDep2Idx.get( key );
			recArray = new IBusModelClearSubDep3[ subdictClearSubDep2Idx.size() ];
			Iterator< BusModelBuffClearSubDep3 > iter = subdictClearSubDep2Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep3 > subdictClearSubDep2Idx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep3 >();
			dictByClearSubDep2Idx.put( key, subdictClearSubDep2Idx );
			recArray = new IBusModelClearSubDep3[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelClearSubDep3 readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearSubDep2Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamClearSubDep3.readDerivedByUNameIdx";
		BusModelBuffClearSubDep3ByUNameIdxKey key = (BusModelBuffClearSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByUNameIdxKey();

		key.setRequiredClearSubDep2Id( ClearSubDep2Id );
		key.setRequiredName( Name );
		IBusModelClearSubDep3 buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep3 readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelClearSubDep3 buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep3 readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearSubDep3.readRec";
		IBusModelClearSubDep3 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearSubDep3.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep3 lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelClearSubDep3 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearSubDep3.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep3[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamClearSubDep3.readAllRec";
		IBusModelClearSubDep3 buff;
		ArrayList<IBusModelClearSubDep3> filteredList = new ArrayList<IBusModelClearSubDep3>();
		IBusModelClearSubDep3[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearSubDep3.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep3[0] ) );
	}

	@Override
	public IBusModelClearSubDep3 readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelClearSubDep3 buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelClearSubDep3)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelClearSubDep3[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelClearSubDep3 buff;
		ArrayList<IBusModelClearSubDep3> filteredList = new ArrayList<IBusModelClearSubDep3>();
		IBusModelClearSubDep3[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep3[0] ) );
	}

	@Override
	public IBusModelClearSubDep3[] readRecByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByClearDepIdx() ";
		IBusModelClearSubDep3 buff;
		ArrayList<IBusModelClearSubDep3> filteredList = new ArrayList<IBusModelClearSubDep3>();
		IBusModelClearSubDep3[] buffList = readDerivedByClearDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep3[0] ) );
	}

	@Override
	public IBusModelClearSubDep3[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByDefSchemaIdx() ";
		IBusModelClearSubDep3 buff;
		ArrayList<IBusModelClearSubDep3> filteredList = new ArrayList<IBusModelClearSubDep3>();
		IBusModelClearSubDep3[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep3[0] ) );
	}

	@Override
	public IBusModelClearSubDep3[] readRecByClearSubDep2Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearSubDep2Id )
	{
		final String S_ProcName = "BusModelRamClearSubDep3.readRecByClearSubDep2Idx() ";
		IBusModelClearSubDep3 buff;
		ArrayList<IBusModelClearSubDep3> filteredList = new ArrayList<IBusModelClearSubDep3>();
		IBusModelClearSubDep3[] buffList = readDerivedByClearSubDep2Idx( Authorization,
			ClearSubDep2Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearSubDep3.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep3[0] ) );
	}

	@Override
	public IBusModelClearSubDep3 readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearSubDep2Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamClearSubDep3.readRecByUNameIdx() ";
		IBusModelClearSubDep3 buff = readDerivedByUNameIdx( Authorization,
			ClearSubDep2Id,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearSubDep3.CLASS_CODE ) ) {
			return( (IBusModelClearSubDep3)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelClearSubDep3 updateClearSubDep3( ISecureAuthorization Authorization,
		IBusModelClearSubDep3 iBuff )
	{
		BusModelBuffClearSubDep3 Buff = (BusModelBuffClearSubDep3)(schema.getTableClearDep().updateClearDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearSubDep3 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateClearSubDep3",
				"Existing record not found",
				"Existing record not found",
				"ClearSubDep3",
				"ClearSubDep3",
				pkey );
		}
		BusModelBuffClearSubDep3ByClearSubDep2IdxKey existingKeyClearSubDep2Idx = (BusModelBuffClearSubDep3ByClearSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByClearSubDep2IdxKey();
		existingKeyClearSubDep2Idx.setRequiredClearSubDep2Id( existing.getRequiredClearSubDep2Id() );

		BusModelBuffClearSubDep3ByClearSubDep2IdxKey newKeyClearSubDep2Idx = (BusModelBuffClearSubDep3ByClearSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByClearSubDep2IdxKey();
		newKeyClearSubDep2Idx.setRequiredClearSubDep2Id( Buff.getRequiredClearSubDep2Id() );

		BusModelBuffClearSubDep3ByUNameIdxKey existingKeyUNameIdx = (BusModelBuffClearSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredClearSubDep2Id( existing.getRequiredClearSubDep2Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffClearSubDep3ByUNameIdxKey newKeyUNameIdx = (BusModelBuffClearSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredClearSubDep2Id( Buff.getRequiredClearSubDep2Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateClearSubDep3",
					"ClearSubDep3UNameIdx",
					"ClearSubDep3UNameIdx",
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
						"updateClearSubDep3",
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
				if( null == schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClearSubDep2Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateClearSubDep3",
						"Container",
						"Container",
						"ClearSubDep2",
						"ClearSubDep2",
						"ClearSubDep2",
						"ClearSubDep2",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep3 > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClearSubDep2Idx.get( existingKeyClearSubDep2Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClearSubDep2Idx.containsKey( newKeyClearSubDep2Idx ) ) {
			subdict = dictByClearSubDep2Idx.get( newKeyClearSubDep2Idx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep3 >();
			dictByClearSubDep2Idx.put( newKeyClearSubDep2Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteClearSubDep3( ISecureAuthorization Authorization,
		IBusModelClearSubDep3 iBuff )
	{
		final String S_ProcName = "BusModelRamClearSubDep3Table.deleteClearSubDep3() ";
		BusModelBuffClearSubDep3 Buff = (BusModelBuffClearSubDep3)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffClearSubDep3 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteClearSubDep3",
				pkey );
		}
		BusModelBuffClearSubDep3ByClearSubDep2IdxKey keyClearSubDep2Idx = (BusModelBuffClearSubDep3ByClearSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByClearSubDep2IdxKey();
		keyClearSubDep2Idx.setRequiredClearSubDep2Id( existing.getRequiredClearSubDep2Id() );

		BusModelBuffClearSubDep3ByUNameIdxKey keyUNameIdx = (BusModelBuffClearSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByUNameIdxKey();
		keyUNameIdx.setRequiredClearSubDep2Id( existing.getRequiredClearSubDep2Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep3 > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClearSubDep2Idx.get( keyClearSubDep2Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableClearDep().deleteClearDep( Authorization,
			Buff );
	}
	@Override
	public void deleteClearSubDep3ByClearSubDep2Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClearSubDep2Id )
	{
		BusModelBuffClearSubDep3ByClearSubDep2IdxKey key = (BusModelBuffClearSubDep3ByClearSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByClearSubDep2IdxKey();
		key.setRequiredClearSubDep2Id( argClearSubDep2Id );
		deleteClearSubDep3ByClearSubDep2Idx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep3ByClearSubDep2Idx( ISecureAuthorization Authorization,
		IBusModelClearSubDep3ByClearSubDep2IdxKey argKey )
	{
		BusModelBuffClearSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep3> matchSet = new LinkedList<BusModelBuffClearSubDep3>();
		Iterator<BusModelBuffClearSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep3)(schema.getTableClearSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep3ByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClearSubDep2Id,
		String argName )
	{
		BusModelBuffClearSubDep3ByUNameIdxKey key = (BusModelBuffClearSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep3().newByUNameIdxKey();
		key.setRequiredClearSubDep2Id( argClearSubDep2Id );
		key.setRequiredName( argName );
		deleteClearSubDep3ByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep3ByUNameIdx( ISecureAuthorization Authorization,
		IBusModelClearSubDep3ByUNameIdxKey argKey )
	{
		BusModelBuffClearSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep3> matchSet = new LinkedList<BusModelBuffClearSubDep3>();
		Iterator<BusModelBuffClearSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep3)(schema.getTableClearSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep3ByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffClearDepByClearDepIdxKey key = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteClearSubDep3ByClearDepIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep3ByClearDepIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByClearDepIdxKey argKey )
	{
		BusModelBuffClearSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep3> matchSet = new LinkedList<BusModelBuffClearSubDep3>();
		Iterator<BusModelBuffClearSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep3)(schema.getTableClearSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep3ByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffClearDepByDefSchemaIdxKey key = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteClearSubDep3ByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep3ByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffClearSubDep3 cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep3> matchSet = new LinkedList<BusModelBuffClearSubDep3>();
		Iterator<BusModelBuffClearSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep3)(schema.getTableClearSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep3ByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffClearSubDep3 cur;
		LinkedList<BusModelBuffClearSubDep3> matchSet = new LinkedList<BusModelBuffClearSubDep3>();
		Iterator<BusModelBuffClearSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep3)(schema.getTableClearSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep3ByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearSubDep3ByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep3ByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffClearSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep3> matchSet = new LinkedList<BusModelBuffClearSubDep3>();
		Iterator<BusModelBuffClearSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep3)(schema.getTableClearSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep3( Authorization, cur );
		}
	}
}
