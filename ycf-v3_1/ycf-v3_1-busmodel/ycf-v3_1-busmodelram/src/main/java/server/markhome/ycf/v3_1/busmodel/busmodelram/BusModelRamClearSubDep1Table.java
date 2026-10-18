
// Description: Java 25 in-memory RAM DbIO implementation for ClearSubDep1.

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
 *	BusModelRamClearSubDep1Table in-memory RAM DbIO implementation
 *	for ClearSubDep1.
 */
public class BusModelRamClearSubDep1Table
	implements IBusModelClearSubDep1Table
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffClearSubDep1 > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffClearSubDep1 >();
	private Map< BusModelBuffClearSubDep1ByClearTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearSubDep1 >> dictByClearTopDepIdx
		= new HashMap< BusModelBuffClearSubDep1ByClearTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearSubDep1 >>();
	private Map< BusModelBuffClearSubDep1ByUNameIdxKey,
			BusModelBuffClearSubDep1 > dictByUNameIdx
		= new HashMap< BusModelBuffClearSubDep1ByUNameIdxKey,
			BusModelBuffClearSubDep1 >();

	public BusModelRamClearSubDep1Table( IBusModelSchema argSchema ) {
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
	public IBusModelClearSubDep1 createClearSubDep1( ISecureAuthorization Authorization,
		IBusModelClearSubDep1 iBuff )
	{
		final String S_ProcName = "createClearSubDep1";
		
		BusModelBuffClearSubDep1 Buff = (BusModelBuffClearSubDep1)(schema.getTableClearDep().createClearDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearSubDep1ByClearTopDepIdxKey keyClearTopDepIdx = (BusModelBuffClearSubDep1ByClearTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByClearTopDepIdxKey();
		keyClearTopDepIdx.setRequiredClearTopDepId( Buff.getRequiredClearTopDepId() );

		BusModelBuffClearSubDep1ByUNameIdxKey keyUNameIdx = (BusModelBuffClearSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByUNameIdxKey();
		keyUNameIdx.setRequiredClearTopDepId( Buff.getRequiredClearTopDepId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClearSubDep1UNameIdx",
				"ClearSubDep1UNameIdx",
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
				if( null == schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClearTopDepId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ClearTopDep",
						"ClearTopDep",
						"ClearTopDep",
						"ClearTopDep",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep1 > subdictClearTopDepIdx;
		if( dictByClearTopDepIdx.containsKey( keyClearTopDepIdx ) ) {
			subdictClearTopDepIdx = dictByClearTopDepIdx.get( keyClearTopDepIdx );
		}
		else {
			subdictClearTopDepIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep1 >();
			dictByClearTopDepIdx.put( keyClearTopDepIdx, subdictClearTopDepIdx );
		}
		subdictClearTopDepIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelClearSubDep1.CLASS_CODE) {
				BusModelBuffClearSubDep1 retbuff = ((BusModelBuffClearSubDep1)(schema.getBusModelBuffFactory().getFactoryClearSubDep1().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelClearSubDep1 readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearSubDep1.readDerived";
		IBusModelClearSubDep1 buff;
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
	public IBusModelClearSubDep1 lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearSubDep1.lockDerived";
		IBusModelClearSubDep1 buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep1[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamClearSubDep1.readAllDerived";
		IBusModelClearSubDep1[] retList = new IBusModelClearSubDep1[ dictByPKey.values().size() ];
		Iterator< BusModelBuffClearSubDep1 > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelClearSubDep1[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelClearSubDep1> filteredList = new ArrayList<IBusModelClearSubDep1>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearSubDep1 ) ) {
					filteredList.add( (IBusModelClearSubDep1)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearSubDep1[0] ) );
		}
	}

	@Override
	public IBusModelClearSubDep1[] readDerivedByClearDepIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelClearSubDep1> filteredList = new ArrayList<IBusModelClearSubDep1>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearSubDep1 ) ) {
					filteredList.add( (IBusModelClearSubDep1)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearSubDep1[0] ) );
		}
	}

	@Override
	public IBusModelClearSubDep1[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelClearSubDep1> filteredList = new ArrayList<IBusModelClearSubDep1>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearSubDep1 ) ) {
					filteredList.add( (IBusModelClearSubDep1)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearSubDep1[0] ) );
		}
	}

	@Override
	public IBusModelClearSubDep1[] readDerivedByClearTopDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearTopDepId )
	{
		final String S_ProcName = "BusModelRamClearSubDep1.readDerivedByClearTopDepIdx";
		BusModelBuffClearSubDep1ByClearTopDepIdxKey key = (BusModelBuffClearSubDep1ByClearTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByClearTopDepIdxKey();

		key.setRequiredClearTopDepId( ClearTopDepId );
		IBusModelClearSubDep1[] recArray;
		if( dictByClearTopDepIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep1 > subdictClearTopDepIdx
				= dictByClearTopDepIdx.get( key );
			recArray = new IBusModelClearSubDep1[ subdictClearTopDepIdx.size() ];
			Iterator< BusModelBuffClearSubDep1 > iter = subdictClearTopDepIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep1 > subdictClearTopDepIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep1 >();
			dictByClearTopDepIdx.put( key, subdictClearTopDepIdx );
			recArray = new IBusModelClearSubDep1[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelClearSubDep1 readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearTopDepId,
		String Name )
	{
		final String S_ProcName = "BusModelRamClearSubDep1.readDerivedByUNameIdx";
		BusModelBuffClearSubDep1ByUNameIdxKey key = (BusModelBuffClearSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByUNameIdxKey();

		key.setRequiredClearTopDepId( ClearTopDepId );
		key.setRequiredName( Name );
		IBusModelClearSubDep1 buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep1 readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelClearSubDep1 buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep1 readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearSubDep1.readRec";
		IBusModelClearSubDep1 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearSubDep1.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep1 lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelClearSubDep1 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearSubDep1.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearSubDep1[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamClearSubDep1.readAllRec";
		IBusModelClearSubDep1 buff;
		ArrayList<IBusModelClearSubDep1> filteredList = new ArrayList<IBusModelClearSubDep1>();
		IBusModelClearSubDep1[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearSubDep1.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep1[0] ) );
	}

	@Override
	public IBusModelClearSubDep1 readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelClearSubDep1 buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelClearSubDep1)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelClearSubDep1[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelClearSubDep1 buff;
		ArrayList<IBusModelClearSubDep1> filteredList = new ArrayList<IBusModelClearSubDep1>();
		IBusModelClearSubDep1[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep1[0] ) );
	}

	@Override
	public IBusModelClearSubDep1[] readRecByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByClearDepIdx() ";
		IBusModelClearSubDep1 buff;
		ArrayList<IBusModelClearSubDep1> filteredList = new ArrayList<IBusModelClearSubDep1>();
		IBusModelClearSubDep1[] buffList = readDerivedByClearDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep1[0] ) );
	}

	@Override
	public IBusModelClearSubDep1[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByDefSchemaIdx() ";
		IBusModelClearSubDep1 buff;
		ArrayList<IBusModelClearSubDep1> filteredList = new ArrayList<IBusModelClearSubDep1>();
		IBusModelClearSubDep1[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep1[0] ) );
	}

	@Override
	public IBusModelClearSubDep1[] readRecByClearTopDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearTopDepId )
	{
		final String S_ProcName = "BusModelRamClearSubDep1.readRecByClearTopDepIdx() ";
		IBusModelClearSubDep1 buff;
		ArrayList<IBusModelClearSubDep1> filteredList = new ArrayList<IBusModelClearSubDep1>();
		IBusModelClearSubDep1[] buffList = readDerivedByClearTopDepIdx( Authorization,
			ClearTopDepId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearSubDep1.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearSubDep1[0] ) );
	}

	@Override
	public IBusModelClearSubDep1 readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClearTopDepId,
		String Name )
	{
		final String S_ProcName = "BusModelRamClearSubDep1.readRecByUNameIdx() ";
		IBusModelClearSubDep1 buff = readDerivedByUNameIdx( Authorization,
			ClearTopDepId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearSubDep1.CLASS_CODE ) ) {
			return( (IBusModelClearSubDep1)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelClearSubDep1 updateClearSubDep1( ISecureAuthorization Authorization,
		IBusModelClearSubDep1 iBuff )
	{
		BusModelBuffClearSubDep1 Buff = (BusModelBuffClearSubDep1)(schema.getTableClearDep().updateClearDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearSubDep1 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateClearSubDep1",
				"Existing record not found",
				"Existing record not found",
				"ClearSubDep1",
				"ClearSubDep1",
				pkey );
		}
		BusModelBuffClearSubDep1ByClearTopDepIdxKey existingKeyClearTopDepIdx = (BusModelBuffClearSubDep1ByClearTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByClearTopDepIdxKey();
		existingKeyClearTopDepIdx.setRequiredClearTopDepId( existing.getRequiredClearTopDepId() );

		BusModelBuffClearSubDep1ByClearTopDepIdxKey newKeyClearTopDepIdx = (BusModelBuffClearSubDep1ByClearTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByClearTopDepIdxKey();
		newKeyClearTopDepIdx.setRequiredClearTopDepId( Buff.getRequiredClearTopDepId() );

		BusModelBuffClearSubDep1ByUNameIdxKey existingKeyUNameIdx = (BusModelBuffClearSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredClearTopDepId( existing.getRequiredClearTopDepId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffClearSubDep1ByUNameIdxKey newKeyUNameIdx = (BusModelBuffClearSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredClearTopDepId( Buff.getRequiredClearTopDepId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateClearSubDep1",
					"ClearSubDep1UNameIdx",
					"ClearSubDep1UNameIdx",
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
						"updateClearSubDep1",
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
				if( null == schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClearTopDepId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateClearSubDep1",
						"Container",
						"Container",
						"ClearTopDep",
						"ClearTopDep",
						"ClearTopDep",
						"ClearTopDep",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep1 > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClearTopDepIdx.get( existingKeyClearTopDepIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClearTopDepIdx.containsKey( newKeyClearTopDepIdx ) ) {
			subdict = dictByClearTopDepIdx.get( newKeyClearTopDepIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep1 >();
			dictByClearTopDepIdx.put( newKeyClearTopDepIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteClearSubDep1( ISecureAuthorization Authorization,
		IBusModelClearSubDep1 iBuff )
	{
		final String S_ProcName = "BusModelRamClearSubDep1Table.deleteClearSubDep1() ";
		BusModelBuffClearSubDep1 Buff = (BusModelBuffClearSubDep1)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffClearSubDep1 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteClearSubDep1",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckClearDep[] = schema.getTableClearSubDep2().readDerivedByClearSubDep1Idx( Authorization,
						existing.getRequiredId() );
		if( arrCheckClearDep.length > 0 ) {
			schema.getTableClearSubDep2().deleteClearSubDep2ByClearSubDep1Idx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffClearSubDep1ByClearTopDepIdxKey keyClearTopDepIdx = (BusModelBuffClearSubDep1ByClearTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByClearTopDepIdxKey();
		keyClearTopDepIdx.setRequiredClearTopDepId( existing.getRequiredClearTopDepId() );

		BusModelBuffClearSubDep1ByUNameIdxKey keyUNameIdx = (BusModelBuffClearSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByUNameIdxKey();
		keyUNameIdx.setRequiredClearTopDepId( existing.getRequiredClearTopDepId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearSubDep1 > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClearTopDepIdx.get( keyClearTopDepIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableClearDep().deleteClearDep( Authorization,
			Buff );
	}
	@Override
	public void deleteClearSubDep1ByClearTopDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClearTopDepId )
	{
		BusModelBuffClearSubDep1ByClearTopDepIdxKey key = (BusModelBuffClearSubDep1ByClearTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByClearTopDepIdxKey();
		key.setRequiredClearTopDepId( argClearTopDepId );
		deleteClearSubDep1ByClearTopDepIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep1ByClearTopDepIdx( ISecureAuthorization Authorization,
		IBusModelClearSubDep1ByClearTopDepIdxKey argKey )
	{
		BusModelBuffClearSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep1> matchSet = new LinkedList<BusModelBuffClearSubDep1>();
		Iterator<BusModelBuffClearSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep1)(schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep1ByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClearTopDepId,
		String argName )
	{
		BusModelBuffClearSubDep1ByUNameIdxKey key = (BusModelBuffClearSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearSubDep1().newByUNameIdxKey();
		key.setRequiredClearTopDepId( argClearTopDepId );
		key.setRequiredName( argName );
		deleteClearSubDep1ByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep1ByUNameIdx( ISecureAuthorization Authorization,
		IBusModelClearSubDep1ByUNameIdxKey argKey )
	{
		BusModelBuffClearSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep1> matchSet = new LinkedList<BusModelBuffClearSubDep1>();
		Iterator<BusModelBuffClearSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep1)(schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep1ByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffClearDepByClearDepIdxKey key = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteClearSubDep1ByClearDepIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep1ByClearDepIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByClearDepIdxKey argKey )
	{
		BusModelBuffClearSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep1> matchSet = new LinkedList<BusModelBuffClearSubDep1>();
		Iterator<BusModelBuffClearSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep1)(schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep1ByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffClearDepByDefSchemaIdxKey key = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteClearSubDep1ByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep1ByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffClearSubDep1 cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep1> matchSet = new LinkedList<BusModelBuffClearSubDep1>();
		Iterator<BusModelBuffClearSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep1)(schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep1ByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffClearSubDep1 cur;
		LinkedList<BusModelBuffClearSubDep1> matchSet = new LinkedList<BusModelBuffClearSubDep1>();
		Iterator<BusModelBuffClearSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep1)(schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteClearSubDep1ByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearSubDep1ByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteClearSubDep1ByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffClearSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearSubDep1> matchSet = new LinkedList<BusModelBuffClearSubDep1>();
		Iterator<BusModelBuffClearSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearSubDep1)(schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearSubDep1( Authorization, cur );
		}
	}
}
