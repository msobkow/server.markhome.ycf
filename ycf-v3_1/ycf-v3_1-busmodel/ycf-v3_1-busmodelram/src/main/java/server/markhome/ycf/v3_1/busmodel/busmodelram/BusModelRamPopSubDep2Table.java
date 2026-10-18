
// Description: Java 25 in-memory RAM DbIO implementation for PopSubDep2.

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
 *	BusModelRamPopSubDep2Table in-memory RAM DbIO implementation
 *	for PopSubDep2.
 */
public class BusModelRamPopSubDep2Table
	implements IBusModelPopSubDep2Table
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffPopSubDep2 > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffPopSubDep2 >();
	private Map< BusModelBuffPopSubDep2ByPopSubDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffPopSubDep2 >> dictByPopSubDep1Idx
		= new HashMap< BusModelBuffPopSubDep2ByPopSubDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffPopSubDep2 >>();
	private Map< BusModelBuffPopSubDep2ByUNameIdxKey,
			BusModelBuffPopSubDep2 > dictByUNameIdx
		= new HashMap< BusModelBuffPopSubDep2ByUNameIdxKey,
			BusModelBuffPopSubDep2 >();

	public BusModelRamPopSubDep2Table( IBusModelSchema argSchema ) {
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
	public IBusModelPopSubDep2 createPopSubDep2( ISecureAuthorization Authorization,
		IBusModelPopSubDep2 iBuff )
	{
		final String S_ProcName = "createPopSubDep2";
		
		BusModelBuffPopSubDep2 Buff = (BusModelBuffPopSubDep2)(schema.getTablePopDep().createPopDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx = (BusModelBuffPopSubDep2ByPopSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
		keyPopSubDep1Idx.setRequiredPopSubDep1Id( Buff.getRequiredPopSubDep1Id() );

		BusModelBuffPopSubDep2ByUNameIdxKey keyUNameIdx = (BusModelBuffPopSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByUNameIdxKey();
		keyUNameIdx.setRequiredPopSubDep1Id( Buff.getRequiredPopSubDep1Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"PopSubDep2UNameIdx",
				"PopSubDep2UNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTablePopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"PopDep",
						"PopDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPopSubDep1Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"PopSubDep1",
						"PopSubDep1",
						"PopSubDep1",
						"PopSubDep1",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep2 > subdictPopSubDep1Idx;
		if( dictByPopSubDep1Idx.containsKey( keyPopSubDep1Idx ) ) {
			subdictPopSubDep1Idx = dictByPopSubDep1Idx.get( keyPopSubDep1Idx );
		}
		else {
			subdictPopSubDep1Idx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep2 >();
			dictByPopSubDep1Idx.put( keyPopSubDep1Idx, subdictPopSubDep1Idx );
		}
		subdictPopSubDep1Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelPopSubDep2.CLASS_CODE) {
				BusModelBuffPopSubDep2 retbuff = ((BusModelBuffPopSubDep2)(schema.getBusModelBuffFactory().getFactoryPopSubDep2().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelPopSubDep2 readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopSubDep2.readDerived";
		IBusModelPopSubDep2 buff;
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
	public IBusModelPopSubDep2 lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopSubDep2.lockDerived";
		IBusModelPopSubDep2 buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep2[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamPopSubDep2.readAllDerived";
		IBusModelPopSubDep2[] retList = new IBusModelPopSubDep2[ dictByPKey.values().size() ];
		Iterator< BusModelBuffPopSubDep2 > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelPopSubDep2[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopSubDep2> filteredList = new ArrayList<IBusModelPopSubDep2>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopSubDep2 ) ) {
					filteredList.add( (IBusModelPopSubDep2)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopSubDep2[0] ) );
		}
	}

	@Override
	public IBusModelPopSubDep2[] readDerivedByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamPopDep.readDerivedByRelationIdx";
		IBusModelPopDep buffList[] = schema.getTablePopDep().readDerivedByRelationIdx( Authorization,
			RelationId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelPopDep buff;
			ArrayList<IBusModelPopSubDep2> filteredList = new ArrayList<IBusModelPopSubDep2>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopSubDep2 ) ) {
					filteredList.add( (IBusModelPopSubDep2)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopSubDep2[0] ) );
		}
	}

	@Override
	public IBusModelPopSubDep2[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamPopDep.readDerivedByDefSchemaIdx";
		IBusModelPopDep buffList[] = schema.getTablePopDep().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelPopDep buff;
			ArrayList<IBusModelPopSubDep2> filteredList = new ArrayList<IBusModelPopSubDep2>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopSubDep2 ) ) {
					filteredList.add( (IBusModelPopSubDep2)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopSubDep2[0] ) );
		}
	}

	@Override
	public IBusModelPopSubDep2[] readDerivedByPopSubDep1Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopSubDep1Id )
	{
		final String S_ProcName = "BusModelRamPopSubDep2.readDerivedByPopSubDep1Idx";
		BusModelBuffPopSubDep2ByPopSubDep1IdxKey key = (BusModelBuffPopSubDep2ByPopSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();

		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		IBusModelPopSubDep2[] recArray;
		if( dictByPopSubDep1Idx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep2 > subdictPopSubDep1Idx
				= dictByPopSubDep1Idx.get( key );
			recArray = new IBusModelPopSubDep2[ subdictPopSubDep1Idx.size() ];
			Iterator< BusModelBuffPopSubDep2 > iter = subdictPopSubDep1Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep2 > subdictPopSubDep1Idx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep2 >();
			dictByPopSubDep1Idx.put( key, subdictPopSubDep1Idx );
			recArray = new IBusModelPopSubDep2[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelPopSubDep2 readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopSubDep1Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamPopSubDep2.readDerivedByUNameIdx";
		BusModelBuffPopSubDep2ByUNameIdxKey key = (BusModelBuffPopSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByUNameIdxKey();

		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		key.setRequiredName( Name );
		IBusModelPopSubDep2 buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep2 readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelPopSubDep2 buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep2 readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopSubDep2.readRec";
		IBusModelPopSubDep2 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelPopSubDep2.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep2 lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelPopSubDep2 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelPopSubDep2.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep2[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamPopSubDep2.readAllRec";
		IBusModelPopSubDep2 buff;
		ArrayList<IBusModelPopSubDep2> filteredList = new ArrayList<IBusModelPopSubDep2>();
		IBusModelPopSubDep2[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopSubDep2.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep2[0] ) );
	}

	@Override
	public IBusModelPopSubDep2 readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelPopSubDep2 buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelPopSubDep2)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelPopSubDep2[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelPopSubDep2 buff;
		ArrayList<IBusModelPopSubDep2> filteredList = new ArrayList<IBusModelPopSubDep2>();
		IBusModelPopSubDep2[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep2[0] ) );
	}

	@Override
	public IBusModelPopSubDep2[] readRecByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamPopDep.readRecByRelationIdx() ";
		IBusModelPopSubDep2 buff;
		ArrayList<IBusModelPopSubDep2> filteredList = new ArrayList<IBusModelPopSubDep2>();
		IBusModelPopSubDep2[] buffList = readDerivedByRelationIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep2[0] ) );
	}

	@Override
	public IBusModelPopSubDep2[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamPopDep.readRecByDefSchemaIdx() ";
		IBusModelPopSubDep2 buff;
		ArrayList<IBusModelPopSubDep2> filteredList = new ArrayList<IBusModelPopSubDep2>();
		IBusModelPopSubDep2[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep2[0] ) );
	}

	@Override
	public IBusModelPopSubDep2[] readRecByPopSubDep1Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopSubDep1Id )
	{
		final String S_ProcName = "BusModelRamPopSubDep2.readRecByPopSubDep1Idx() ";
		IBusModelPopSubDep2 buff;
		ArrayList<IBusModelPopSubDep2> filteredList = new ArrayList<IBusModelPopSubDep2>();
		IBusModelPopSubDep2[] buffList = readDerivedByPopSubDep1Idx( Authorization,
			PopSubDep1Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopSubDep2.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep2[0] ) );
	}

	@Override
	public IBusModelPopSubDep2 readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopSubDep1Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamPopSubDep2.readRecByUNameIdx() ";
		IBusModelPopSubDep2 buff = readDerivedByUNameIdx( Authorization,
			PopSubDep1Id,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopSubDep2.CLASS_CODE ) ) {
			return( (IBusModelPopSubDep2)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelPopSubDep2 updatePopSubDep2( ISecureAuthorization Authorization,
		IBusModelPopSubDep2 iBuff )
	{
		BusModelBuffPopSubDep2 Buff = (BusModelBuffPopSubDep2)(schema.getTablePopDep().updatePopDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffPopSubDep2 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updatePopSubDep2",
				"Existing record not found",
				"Existing record not found",
				"PopSubDep2",
				"PopSubDep2",
				pkey );
		}
		BusModelBuffPopSubDep2ByPopSubDep1IdxKey existingKeyPopSubDep1Idx = (BusModelBuffPopSubDep2ByPopSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
		existingKeyPopSubDep1Idx.setRequiredPopSubDep1Id( existing.getRequiredPopSubDep1Id() );

		BusModelBuffPopSubDep2ByPopSubDep1IdxKey newKeyPopSubDep1Idx = (BusModelBuffPopSubDep2ByPopSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
		newKeyPopSubDep1Idx.setRequiredPopSubDep1Id( Buff.getRequiredPopSubDep1Id() );

		BusModelBuffPopSubDep2ByUNameIdxKey existingKeyUNameIdx = (BusModelBuffPopSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredPopSubDep1Id( existing.getRequiredPopSubDep1Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffPopSubDep2ByUNameIdxKey newKeyUNameIdx = (BusModelBuffPopSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredPopSubDep1Id( Buff.getRequiredPopSubDep1Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updatePopSubDep2",
					"PopSubDep2UNameIdx",
					"PopSubDep2UNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTablePopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updatePopSubDep2",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"PopDep",
						"PopDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPopSubDep1Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updatePopSubDep2",
						"Container",
						"Container",
						"PopSubDep1",
						"PopSubDep1",
						"PopSubDep1",
						"PopSubDep1",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep2 > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByPopSubDep1Idx.get( existingKeyPopSubDep1Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPopSubDep1Idx.containsKey( newKeyPopSubDep1Idx ) ) {
			subdict = dictByPopSubDep1Idx.get( newKeyPopSubDep1Idx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep2 >();
			dictByPopSubDep1Idx.put( newKeyPopSubDep1Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deletePopSubDep2( ISecureAuthorization Authorization,
		IBusModelPopSubDep2 iBuff )
	{
		final String S_ProcName = "BusModelRamPopSubDep2Table.deletePopSubDep2() ";
		BusModelBuffPopSubDep2 Buff = (BusModelBuffPopSubDep2)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffPopSubDep2 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deletePopSubDep2",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckPopDep[] = schema.getTablePopSubDep3().readDerivedByPopSubDep2Idx( Authorization,
						existing.getRequiredId() );
		if( arrCheckPopDep.length > 0 ) {
			schema.getTablePopSubDep3().deletePopSubDep3ByPopSubDep2Idx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx = (BusModelBuffPopSubDep2ByPopSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
		keyPopSubDep1Idx.setRequiredPopSubDep1Id( existing.getRequiredPopSubDep1Id() );

		BusModelBuffPopSubDep2ByUNameIdxKey keyUNameIdx = (BusModelBuffPopSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByUNameIdxKey();
		keyUNameIdx.setRequiredPopSubDep1Id( existing.getRequiredPopSubDep1Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep2 > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByPopSubDep1Idx.get( keyPopSubDep1Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTablePopDep().deletePopDep( Authorization,
			Buff );
	}
	@Override
	public void deletePopSubDep2ByPopSubDep1Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPopSubDep1Id )
	{
		BusModelBuffPopSubDep2ByPopSubDep1IdxKey key = (BusModelBuffPopSubDep2ByPopSubDep1IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
		key.setRequiredPopSubDep1Id( argPopSubDep1Id );
		deletePopSubDep2ByPopSubDep1Idx( Authorization, key );
	}

	@Override
	public void deletePopSubDep2ByPopSubDep1Idx( ISecureAuthorization Authorization,
		IBusModelPopSubDep2ByPopSubDep1IdxKey argKey )
	{
		BusModelBuffPopSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep2> matchSet = new LinkedList<BusModelBuffPopSubDep2>();
		Iterator<BusModelBuffPopSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep2)(schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep2ByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPopSubDep1Id,
		String argName )
	{
		BusModelBuffPopSubDep2ByUNameIdxKey key = (BusModelBuffPopSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep2().newByUNameIdxKey();
		key.setRequiredPopSubDep1Id( argPopSubDep1Id );
		key.setRequiredName( argName );
		deletePopSubDep2ByUNameIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep2ByUNameIdx( ISecureAuthorization Authorization,
		IBusModelPopSubDep2ByUNameIdxKey argKey )
	{
		BusModelBuffPopSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep2> matchSet = new LinkedList<BusModelBuffPopSubDep2>();
		Iterator<BusModelBuffPopSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep2)(schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep2ByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffPopDepByRelationIdxKey key = (BusModelBuffPopDepByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( argRelationId );
		deletePopSubDep2ByRelationIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep2ByRelationIdx( ISecureAuthorization Authorization,
		IBusModelPopDepByRelationIdxKey argKey )
	{
		BusModelBuffPopSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep2> matchSet = new LinkedList<BusModelBuffPopSubDep2>();
		Iterator<BusModelBuffPopSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep2)(schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep2ByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffPopDepByDefSchemaIdxKey key = (BusModelBuffPopDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deletePopSubDep2ByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep2ByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelPopDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffPopSubDep2 cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep2> matchSet = new LinkedList<BusModelBuffPopSubDep2>();
		Iterator<BusModelBuffPopSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep2)(schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep2ByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffPopSubDep2 cur;
		LinkedList<BusModelBuffPopSubDep2> matchSet = new LinkedList<BusModelBuffPopSubDep2>();
		Iterator<BusModelBuffPopSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep2)(schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep2ByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deletePopSubDep2ByTenantIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep2ByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffPopSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep2> matchSet = new LinkedList<BusModelBuffPopSubDep2>();
		Iterator<BusModelBuffPopSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep2)(schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep2( Authorization, cur );
		}
	}
}
