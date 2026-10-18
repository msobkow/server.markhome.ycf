
// Description: Java 25 in-memory RAM DbIO implementation for PopSubDep3.

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
 *	BusModelRamPopSubDep3Table in-memory RAM DbIO implementation
 *	for PopSubDep3.
 */
public class BusModelRamPopSubDep3Table
	implements IBusModelPopSubDep3Table
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffPopSubDep3 > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffPopSubDep3 >();
	private Map< BusModelBuffPopSubDep3ByPopSubDep2IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffPopSubDep3 >> dictByPopSubDep2Idx
		= new HashMap< BusModelBuffPopSubDep3ByPopSubDep2IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffPopSubDep3 >>();
	private Map< BusModelBuffPopSubDep3ByUNameIdxKey,
			BusModelBuffPopSubDep3 > dictByUNameIdx
		= new HashMap< BusModelBuffPopSubDep3ByUNameIdxKey,
			BusModelBuffPopSubDep3 >();

	public BusModelRamPopSubDep3Table( IBusModelSchema argSchema ) {
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
	public IBusModelPopSubDep3 createPopSubDep3( ISecureAuthorization Authorization,
		IBusModelPopSubDep3 iBuff )
	{
		final String S_ProcName = "createPopSubDep3";
		
		BusModelBuffPopSubDep3 Buff = (BusModelBuffPopSubDep3)(schema.getTablePopDep().createPopDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffPopSubDep3ByPopSubDep2IdxKey keyPopSubDep2Idx = (BusModelBuffPopSubDep3ByPopSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
		keyPopSubDep2Idx.setRequiredPopSubDep2Id( Buff.getRequiredPopSubDep2Id() );

		BusModelBuffPopSubDep3ByUNameIdxKey keyUNameIdx = (BusModelBuffPopSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByUNameIdxKey();
		keyUNameIdx.setRequiredPopSubDep2Id( Buff.getRequiredPopSubDep2Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"PopSubDep3UNameIdx",
				"PopSubDep3UNameIdx",
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
				if( null == schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPopSubDep2Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"PopSubDep2",
						"PopSubDep2",
						"PopSubDep2",
						"PopSubDep2",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep3 > subdictPopSubDep2Idx;
		if( dictByPopSubDep2Idx.containsKey( keyPopSubDep2Idx ) ) {
			subdictPopSubDep2Idx = dictByPopSubDep2Idx.get( keyPopSubDep2Idx );
		}
		else {
			subdictPopSubDep2Idx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep3 >();
			dictByPopSubDep2Idx.put( keyPopSubDep2Idx, subdictPopSubDep2Idx );
		}
		subdictPopSubDep2Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelPopSubDep3.CLASS_CODE) {
				BusModelBuffPopSubDep3 retbuff = ((BusModelBuffPopSubDep3)(schema.getBusModelBuffFactory().getFactoryPopSubDep3().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelPopSubDep3 readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopSubDep3.readDerived";
		IBusModelPopSubDep3 buff;
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
	public IBusModelPopSubDep3 lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopSubDep3.lockDerived";
		IBusModelPopSubDep3 buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep3[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamPopSubDep3.readAllDerived";
		IBusModelPopSubDep3[] retList = new IBusModelPopSubDep3[ dictByPKey.values().size() ];
		Iterator< BusModelBuffPopSubDep3 > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelPopSubDep3[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopSubDep3> filteredList = new ArrayList<IBusModelPopSubDep3>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopSubDep3 ) ) {
					filteredList.add( (IBusModelPopSubDep3)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopSubDep3[0] ) );
		}
	}

	@Override
	public IBusModelPopSubDep3[] readDerivedByRelationIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopSubDep3> filteredList = new ArrayList<IBusModelPopSubDep3>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopSubDep3 ) ) {
					filteredList.add( (IBusModelPopSubDep3)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopSubDep3[0] ) );
		}
	}

	@Override
	public IBusModelPopSubDep3[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopSubDep3> filteredList = new ArrayList<IBusModelPopSubDep3>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopSubDep3 ) ) {
					filteredList.add( (IBusModelPopSubDep3)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopSubDep3[0] ) );
		}
	}

	@Override
	public IBusModelPopSubDep3[] readDerivedByPopSubDep2Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopSubDep2Id )
	{
		final String S_ProcName = "BusModelRamPopSubDep3.readDerivedByPopSubDep2Idx";
		BusModelBuffPopSubDep3ByPopSubDep2IdxKey key = (BusModelBuffPopSubDep3ByPopSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();

		key.setRequiredPopSubDep2Id( PopSubDep2Id );
		IBusModelPopSubDep3[] recArray;
		if( dictByPopSubDep2Idx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep3 > subdictPopSubDep2Idx
				= dictByPopSubDep2Idx.get( key );
			recArray = new IBusModelPopSubDep3[ subdictPopSubDep2Idx.size() ];
			Iterator< BusModelBuffPopSubDep3 > iter = subdictPopSubDep2Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep3 > subdictPopSubDep2Idx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep3 >();
			dictByPopSubDep2Idx.put( key, subdictPopSubDep2Idx );
			recArray = new IBusModelPopSubDep3[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelPopSubDep3 readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopSubDep2Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamPopSubDep3.readDerivedByUNameIdx";
		BusModelBuffPopSubDep3ByUNameIdxKey key = (BusModelBuffPopSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByUNameIdxKey();

		key.setRequiredPopSubDep2Id( PopSubDep2Id );
		key.setRequiredName( Name );
		IBusModelPopSubDep3 buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep3 readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelPopSubDep3 buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep3 readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopSubDep3.readRec";
		IBusModelPopSubDep3 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelPopSubDep3.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep3 lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelPopSubDep3 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelPopSubDep3.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep3[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamPopSubDep3.readAllRec";
		IBusModelPopSubDep3 buff;
		ArrayList<IBusModelPopSubDep3> filteredList = new ArrayList<IBusModelPopSubDep3>();
		IBusModelPopSubDep3[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopSubDep3.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep3[0] ) );
	}

	@Override
	public IBusModelPopSubDep3 readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelPopSubDep3 buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelPopSubDep3)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelPopSubDep3[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelPopSubDep3 buff;
		ArrayList<IBusModelPopSubDep3> filteredList = new ArrayList<IBusModelPopSubDep3>();
		IBusModelPopSubDep3[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep3[0] ) );
	}

	@Override
	public IBusModelPopSubDep3[] readRecByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamPopDep.readRecByRelationIdx() ";
		IBusModelPopSubDep3 buff;
		ArrayList<IBusModelPopSubDep3> filteredList = new ArrayList<IBusModelPopSubDep3>();
		IBusModelPopSubDep3[] buffList = readDerivedByRelationIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep3[0] ) );
	}

	@Override
	public IBusModelPopSubDep3[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamPopDep.readRecByDefSchemaIdx() ";
		IBusModelPopSubDep3 buff;
		ArrayList<IBusModelPopSubDep3> filteredList = new ArrayList<IBusModelPopSubDep3>();
		IBusModelPopSubDep3[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep3[0] ) );
	}

	@Override
	public IBusModelPopSubDep3[] readRecByPopSubDep2Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopSubDep2Id )
	{
		final String S_ProcName = "BusModelRamPopSubDep3.readRecByPopSubDep2Idx() ";
		IBusModelPopSubDep3 buff;
		ArrayList<IBusModelPopSubDep3> filteredList = new ArrayList<IBusModelPopSubDep3>();
		IBusModelPopSubDep3[] buffList = readDerivedByPopSubDep2Idx( Authorization,
			PopSubDep2Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopSubDep3.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep3[0] ) );
	}

	@Override
	public IBusModelPopSubDep3 readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopSubDep2Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamPopSubDep3.readRecByUNameIdx() ";
		IBusModelPopSubDep3 buff = readDerivedByUNameIdx( Authorization,
			PopSubDep2Id,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopSubDep3.CLASS_CODE ) ) {
			return( (IBusModelPopSubDep3)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelPopSubDep3 updatePopSubDep3( ISecureAuthorization Authorization,
		IBusModelPopSubDep3 iBuff )
	{
		BusModelBuffPopSubDep3 Buff = (BusModelBuffPopSubDep3)(schema.getTablePopDep().updatePopDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffPopSubDep3 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updatePopSubDep3",
				"Existing record not found",
				"Existing record not found",
				"PopSubDep3",
				"PopSubDep3",
				pkey );
		}
		BusModelBuffPopSubDep3ByPopSubDep2IdxKey existingKeyPopSubDep2Idx = (BusModelBuffPopSubDep3ByPopSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
		existingKeyPopSubDep2Idx.setRequiredPopSubDep2Id( existing.getRequiredPopSubDep2Id() );

		BusModelBuffPopSubDep3ByPopSubDep2IdxKey newKeyPopSubDep2Idx = (BusModelBuffPopSubDep3ByPopSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
		newKeyPopSubDep2Idx.setRequiredPopSubDep2Id( Buff.getRequiredPopSubDep2Id() );

		BusModelBuffPopSubDep3ByUNameIdxKey existingKeyUNameIdx = (BusModelBuffPopSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredPopSubDep2Id( existing.getRequiredPopSubDep2Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffPopSubDep3ByUNameIdxKey newKeyUNameIdx = (BusModelBuffPopSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredPopSubDep2Id( Buff.getRequiredPopSubDep2Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updatePopSubDep3",
					"PopSubDep3UNameIdx",
					"PopSubDep3UNameIdx",
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
						"updatePopSubDep3",
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
				if( null == schema.getTablePopSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPopSubDep2Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updatePopSubDep3",
						"Container",
						"Container",
						"PopSubDep2",
						"PopSubDep2",
						"PopSubDep2",
						"PopSubDep2",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep3 > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByPopSubDep2Idx.get( existingKeyPopSubDep2Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPopSubDep2Idx.containsKey( newKeyPopSubDep2Idx ) ) {
			subdict = dictByPopSubDep2Idx.get( newKeyPopSubDep2Idx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep3 >();
			dictByPopSubDep2Idx.put( newKeyPopSubDep2Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deletePopSubDep3( ISecureAuthorization Authorization,
		IBusModelPopSubDep3 iBuff )
	{
		final String S_ProcName = "BusModelRamPopSubDep3Table.deletePopSubDep3() ";
		BusModelBuffPopSubDep3 Buff = (BusModelBuffPopSubDep3)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffPopSubDep3 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deletePopSubDep3",
				pkey );
		}
		BusModelBuffPopSubDep3ByPopSubDep2IdxKey keyPopSubDep2Idx = (BusModelBuffPopSubDep3ByPopSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
		keyPopSubDep2Idx.setRequiredPopSubDep2Id( existing.getRequiredPopSubDep2Id() );

		BusModelBuffPopSubDep3ByUNameIdxKey keyUNameIdx = (BusModelBuffPopSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByUNameIdxKey();
		keyUNameIdx.setRequiredPopSubDep2Id( existing.getRequiredPopSubDep2Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep3 > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByPopSubDep2Idx.get( keyPopSubDep2Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTablePopDep().deletePopDep( Authorization,
			Buff );
	}
	@Override
	public void deletePopSubDep3ByPopSubDep2Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPopSubDep2Id )
	{
		BusModelBuffPopSubDep3ByPopSubDep2IdxKey key = (BusModelBuffPopSubDep3ByPopSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
		key.setRequiredPopSubDep2Id( argPopSubDep2Id );
		deletePopSubDep3ByPopSubDep2Idx( Authorization, key );
	}

	@Override
	public void deletePopSubDep3ByPopSubDep2Idx( ISecureAuthorization Authorization,
		IBusModelPopSubDep3ByPopSubDep2IdxKey argKey )
	{
		BusModelBuffPopSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep3> matchSet = new LinkedList<BusModelBuffPopSubDep3>();
		Iterator<BusModelBuffPopSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep3)(schema.getTablePopSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep3ByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPopSubDep2Id,
		String argName )
	{
		BusModelBuffPopSubDep3ByUNameIdxKey key = (BusModelBuffPopSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep3().newByUNameIdxKey();
		key.setRequiredPopSubDep2Id( argPopSubDep2Id );
		key.setRequiredName( argName );
		deletePopSubDep3ByUNameIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep3ByUNameIdx( ISecureAuthorization Authorization,
		IBusModelPopSubDep3ByUNameIdxKey argKey )
	{
		BusModelBuffPopSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep3> matchSet = new LinkedList<BusModelBuffPopSubDep3>();
		Iterator<BusModelBuffPopSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep3)(schema.getTablePopSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep3ByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffPopDepByRelationIdxKey key = (BusModelBuffPopDepByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( argRelationId );
		deletePopSubDep3ByRelationIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep3ByRelationIdx( ISecureAuthorization Authorization,
		IBusModelPopDepByRelationIdxKey argKey )
	{
		BusModelBuffPopSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep3> matchSet = new LinkedList<BusModelBuffPopSubDep3>();
		Iterator<BusModelBuffPopSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep3)(schema.getTablePopSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep3ByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffPopDepByDefSchemaIdxKey key = (BusModelBuffPopDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deletePopSubDep3ByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep3ByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelPopDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffPopSubDep3 cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep3> matchSet = new LinkedList<BusModelBuffPopSubDep3>();
		Iterator<BusModelBuffPopSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep3)(schema.getTablePopSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep3ByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffPopSubDep3 cur;
		LinkedList<BusModelBuffPopSubDep3> matchSet = new LinkedList<BusModelBuffPopSubDep3>();
		Iterator<BusModelBuffPopSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep3)(schema.getTablePopSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep3ByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deletePopSubDep3ByTenantIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep3ByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffPopSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep3> matchSet = new LinkedList<BusModelBuffPopSubDep3>();
		Iterator<BusModelBuffPopSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep3)(schema.getTablePopSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep3( Authorization, cur );
		}
	}
}
