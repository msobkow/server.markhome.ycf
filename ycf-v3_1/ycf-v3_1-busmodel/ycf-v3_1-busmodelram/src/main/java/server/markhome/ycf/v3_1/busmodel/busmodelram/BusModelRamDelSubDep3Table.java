
// Description: Java 25 in-memory RAM DbIO implementation for DelSubDep3.

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
 *	BusModelRamDelSubDep3Table in-memory RAM DbIO implementation
 *	for DelSubDep3.
 */
public class BusModelRamDelSubDep3Table
	implements IBusModelDelSubDep3Table
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffDelSubDep3 > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffDelSubDep3 >();
	private Map< BusModelBuffDelSubDep3ByDelSubDep2IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelSubDep3 >> dictByDelSubDep2Idx
		= new HashMap< BusModelBuffDelSubDep3ByDelSubDep2IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelSubDep3 >>();
	private Map< BusModelBuffDelSubDep3ByUNameIdxKey,
			BusModelBuffDelSubDep3 > dictByUNameIdx
		= new HashMap< BusModelBuffDelSubDep3ByUNameIdxKey,
			BusModelBuffDelSubDep3 >();

	public BusModelRamDelSubDep3Table( IBusModelSchema argSchema ) {
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
	public IBusModelDelSubDep3 createDelSubDep3( ISecureAuthorization Authorization,
		IBusModelDelSubDep3 iBuff )
	{
		final String S_ProcName = "createDelSubDep3";
		
		BusModelBuffDelSubDep3 Buff = (BusModelBuffDelSubDep3)(schema.getTableDelDep().createDelDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDelSubDep3ByDelSubDep2IdxKey keyDelSubDep2Idx = (BusModelBuffDelSubDep3ByDelSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByDelSubDep2IdxKey();
		keyDelSubDep2Idx.setRequiredDelSubDep2Id( Buff.getRequiredDelSubDep2Id() );

		BusModelBuffDelSubDep3ByUNameIdxKey keyUNameIdx = (BusModelBuffDelSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByUNameIdxKey();
		keyUNameIdx.setRequiredDelSubDep2Id( Buff.getRequiredDelSubDep2Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DelSubDep3UNameIdx",
				"DelSubDep3UNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDelDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"DelDep",
						"DelDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredDelSubDep2Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"DelSubDep2",
						"DelSubDep2",
						"DelSubDep2",
						"DelSubDep2",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep3 > subdictDelSubDep2Idx;
		if( dictByDelSubDep2Idx.containsKey( keyDelSubDep2Idx ) ) {
			subdictDelSubDep2Idx = dictByDelSubDep2Idx.get( keyDelSubDep2Idx );
		}
		else {
			subdictDelSubDep2Idx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep3 >();
			dictByDelSubDep2Idx.put( keyDelSubDep2Idx, subdictDelSubDep2Idx );
		}
		subdictDelSubDep2Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelDelSubDep3.CLASS_CODE) {
				BusModelBuffDelSubDep3 retbuff = ((BusModelBuffDelSubDep3)(schema.getBusModelBuffFactory().getFactoryDelSubDep3().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelDelSubDep3 readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelSubDep3.readDerived";
		IBusModelDelSubDep3 buff;
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
	public IBusModelDelSubDep3 lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelSubDep3.lockDerived";
		IBusModelDelSubDep3 buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep3[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamDelSubDep3.readAllDerived";
		IBusModelDelSubDep3[] retList = new IBusModelDelSubDep3[ dictByPKey.values().size() ];
		Iterator< BusModelBuffDelSubDep3 > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelDelSubDep3[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDelSubDep3> filteredList = new ArrayList<IBusModelDelSubDep3>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelSubDep3 ) ) {
					filteredList.add( (IBusModelDelSubDep3)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelSubDep3[0] ) );
		}
	}

	@Override
	public IBusModelDelSubDep3[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamDelDep.readDerivedByDefSchemaIdx";
		IBusModelDelDep buffList[] = schema.getTableDelDep().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelDelDep buff;
			ArrayList<IBusModelDelSubDep3> filteredList = new ArrayList<IBusModelDelSubDep3>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelSubDep3 ) ) {
					filteredList.add( (IBusModelDelSubDep3)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelSubDep3[0] ) );
		}
	}

	@Override
	public IBusModelDelSubDep3[] readDerivedByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamDelDep.readDerivedByDelDepIdx";
		IBusModelDelDep buffList[] = schema.getTableDelDep().readDerivedByDelDepIdx( Authorization,
			RelationId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelDelDep buff;
			ArrayList<IBusModelDelSubDep3> filteredList = new ArrayList<IBusModelDelSubDep3>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelSubDep3 ) ) {
					filteredList.add( (IBusModelDelSubDep3)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelSubDep3[0] ) );
		}
	}

	@Override
	public IBusModelDelSubDep3[] readDerivedByDelSubDep2Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelSubDep2Id )
	{
		final String S_ProcName = "BusModelRamDelSubDep3.readDerivedByDelSubDep2Idx";
		BusModelBuffDelSubDep3ByDelSubDep2IdxKey key = (BusModelBuffDelSubDep3ByDelSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByDelSubDep2IdxKey();

		key.setRequiredDelSubDep2Id( DelSubDep2Id );
		IBusModelDelSubDep3[] recArray;
		if( dictByDelSubDep2Idx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep3 > subdictDelSubDep2Idx
				= dictByDelSubDep2Idx.get( key );
			recArray = new IBusModelDelSubDep3[ subdictDelSubDep2Idx.size() ];
			Iterator< BusModelBuffDelSubDep3 > iter = subdictDelSubDep2Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep3 > subdictDelSubDep2Idx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep3 >();
			dictByDelSubDep2Idx.put( key, subdictDelSubDep2Idx );
			recArray = new IBusModelDelSubDep3[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelDelSubDep3 readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelSubDep2Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamDelSubDep3.readDerivedByUNameIdx";
		BusModelBuffDelSubDep3ByUNameIdxKey key = (BusModelBuffDelSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByUNameIdxKey();

		key.setRequiredDelSubDep2Id( DelSubDep2Id );
		key.setRequiredName( Name );
		IBusModelDelSubDep3 buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep3 readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelDelSubDep3 buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep3 readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelSubDep3.readRec";
		IBusModelDelSubDep3 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelSubDep3.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep3 lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelDelSubDep3 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelSubDep3.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep3[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamDelSubDep3.readAllRec";
		IBusModelDelSubDep3 buff;
		ArrayList<IBusModelDelSubDep3> filteredList = new ArrayList<IBusModelDelSubDep3>();
		IBusModelDelSubDep3[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelSubDep3.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep3[0] ) );
	}

	@Override
	public IBusModelDelSubDep3 readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelDelSubDep3 buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelDelSubDep3)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelDelSubDep3[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelDelSubDep3 buff;
		ArrayList<IBusModelDelSubDep3> filteredList = new ArrayList<IBusModelDelSubDep3>();
		IBusModelDelSubDep3[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep3[0] ) );
	}

	@Override
	public IBusModelDelSubDep3[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDefSchemaIdx() ";
		IBusModelDelSubDep3 buff;
		ArrayList<IBusModelDelSubDep3> filteredList = new ArrayList<IBusModelDelSubDep3>();
		IBusModelDelSubDep3[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep3[0] ) );
	}

	@Override
	public IBusModelDelSubDep3[] readRecByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDelDepIdx() ";
		IBusModelDelSubDep3 buff;
		ArrayList<IBusModelDelSubDep3> filteredList = new ArrayList<IBusModelDelSubDep3>();
		IBusModelDelSubDep3[] buffList = readDerivedByDelDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep3[0] ) );
	}

	@Override
	public IBusModelDelSubDep3[] readRecByDelSubDep2Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelSubDep2Id )
	{
		final String S_ProcName = "BusModelRamDelSubDep3.readRecByDelSubDep2Idx() ";
		IBusModelDelSubDep3 buff;
		ArrayList<IBusModelDelSubDep3> filteredList = new ArrayList<IBusModelDelSubDep3>();
		IBusModelDelSubDep3[] buffList = readDerivedByDelSubDep2Idx( Authorization,
			DelSubDep2Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelSubDep3.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep3)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep3[0] ) );
	}

	@Override
	public IBusModelDelSubDep3 readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelSubDep2Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamDelSubDep3.readRecByUNameIdx() ";
		IBusModelDelSubDep3 buff = readDerivedByUNameIdx( Authorization,
			DelSubDep2Id,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelSubDep3.CLASS_CODE ) ) {
			return( (IBusModelDelSubDep3)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelDelSubDep3 updateDelSubDep3( ISecureAuthorization Authorization,
		IBusModelDelSubDep3 iBuff )
	{
		BusModelBuffDelSubDep3 Buff = (BusModelBuffDelSubDep3)(schema.getTableDelDep().updateDelDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDelSubDep3 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateDelSubDep3",
				"Existing record not found",
				"Existing record not found",
				"DelSubDep3",
				"DelSubDep3",
				pkey );
		}
		BusModelBuffDelSubDep3ByDelSubDep2IdxKey existingKeyDelSubDep2Idx = (BusModelBuffDelSubDep3ByDelSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByDelSubDep2IdxKey();
		existingKeyDelSubDep2Idx.setRequiredDelSubDep2Id( existing.getRequiredDelSubDep2Id() );

		BusModelBuffDelSubDep3ByDelSubDep2IdxKey newKeyDelSubDep2Idx = (BusModelBuffDelSubDep3ByDelSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByDelSubDep2IdxKey();
		newKeyDelSubDep2Idx.setRequiredDelSubDep2Id( Buff.getRequiredDelSubDep2Id() );

		BusModelBuffDelSubDep3ByUNameIdxKey existingKeyUNameIdx = (BusModelBuffDelSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredDelSubDep2Id( existing.getRequiredDelSubDep2Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffDelSubDep3ByUNameIdxKey newKeyUNameIdx = (BusModelBuffDelSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredDelSubDep2Id( Buff.getRequiredDelSubDep2Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateDelSubDep3",
					"DelSubDep3UNameIdx",
					"DelSubDep3UNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDelDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateDelSubDep3",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"DelDep",
						"DelDep",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
						Buff.getRequiredDelSubDep2Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateDelSubDep3",
						"Container",
						"Container",
						"DelSubDep2",
						"DelSubDep2",
						"DelSubDep2",
						"DelSubDep2",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep3 > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByDelSubDep2Idx.get( existingKeyDelSubDep2Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDelSubDep2Idx.containsKey( newKeyDelSubDep2Idx ) ) {
			subdict = dictByDelSubDep2Idx.get( newKeyDelSubDep2Idx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep3 >();
			dictByDelSubDep2Idx.put( newKeyDelSubDep2Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteDelSubDep3( ISecureAuthorization Authorization,
		IBusModelDelSubDep3 iBuff )
	{
		final String S_ProcName = "BusModelRamDelSubDep3Table.deleteDelSubDep3() ";
		BusModelBuffDelSubDep3 Buff = (BusModelBuffDelSubDep3)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffDelSubDep3 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteDelSubDep3",
				pkey );
		}
		BusModelBuffDelSubDep3ByDelSubDep2IdxKey keyDelSubDep2Idx = (BusModelBuffDelSubDep3ByDelSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByDelSubDep2IdxKey();
		keyDelSubDep2Idx.setRequiredDelSubDep2Id( existing.getRequiredDelSubDep2Id() );

		BusModelBuffDelSubDep3ByUNameIdxKey keyUNameIdx = (BusModelBuffDelSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByUNameIdxKey();
		keyUNameIdx.setRequiredDelSubDep2Id( existing.getRequiredDelSubDep2Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep3 > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByDelSubDep2Idx.get( keyDelSubDep2Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableDelDep().deleteDelDep( Authorization,
			Buff );
	}
	@Override
	public void deleteDelSubDep3ByDelSubDep2Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDelSubDep2Id )
	{
		BusModelBuffDelSubDep3ByDelSubDep2IdxKey key = (BusModelBuffDelSubDep3ByDelSubDep2IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByDelSubDep2IdxKey();
		key.setRequiredDelSubDep2Id( argDelSubDep2Id );
		deleteDelSubDep3ByDelSubDep2Idx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep3ByDelSubDep2Idx( ISecureAuthorization Authorization,
		IBusModelDelSubDep3ByDelSubDep2IdxKey argKey )
	{
		BusModelBuffDelSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep3> matchSet = new LinkedList<BusModelBuffDelSubDep3>();
		Iterator<BusModelBuffDelSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep3)(schema.getTableDelSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep3ByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDelSubDep2Id,
		String argName )
	{
		BusModelBuffDelSubDep3ByUNameIdxKey key = (BusModelBuffDelSubDep3ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep3().newByUNameIdxKey();
		key.setRequiredDelSubDep2Id( argDelSubDep2Id );
		key.setRequiredName( argName );
		deleteDelSubDep3ByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep3ByUNameIdx( ISecureAuthorization Authorization,
		IBusModelDelSubDep3ByUNameIdxKey argKey )
	{
		BusModelBuffDelSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep3> matchSet = new LinkedList<BusModelBuffDelSubDep3>();
		Iterator<BusModelBuffDelSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep3)(schema.getTableDelSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep3ByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffDelDepByDefSchemaIdxKey key = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelSubDep3ByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep3ByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffDelSubDep3 cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep3> matchSet = new LinkedList<BusModelBuffDelSubDep3>();
		Iterator<BusModelBuffDelSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep3)(schema.getTableDelSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep3ByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffDelDepByDelDepIdxKey key = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteDelSubDep3ByDelDepIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep3ByDelDepIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDelDepIdxKey argKey )
	{
		BusModelBuffDelSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep3> matchSet = new LinkedList<BusModelBuffDelSubDep3>();
		Iterator<BusModelBuffDelSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep3)(schema.getTableDelSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep3ByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffDelSubDep3 cur;
		LinkedList<BusModelBuffDelSubDep3> matchSet = new LinkedList<BusModelBuffDelSubDep3>();
		Iterator<BusModelBuffDelSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep3)(schema.getTableDelSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep3( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep3ByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelSubDep3ByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep3ByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffDelSubDep3 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep3> matchSet = new LinkedList<BusModelBuffDelSubDep3>();
		Iterator<BusModelBuffDelSubDep3> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep3> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep3)(schema.getTableDelSubDep3().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep3( Authorization, cur );
		}
	}
}
