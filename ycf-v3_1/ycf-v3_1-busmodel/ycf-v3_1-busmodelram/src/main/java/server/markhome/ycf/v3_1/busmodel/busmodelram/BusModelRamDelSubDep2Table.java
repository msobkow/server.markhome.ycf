
// Description: Java 25 in-memory RAM DbIO implementation for DelSubDep2.

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
 *	BusModelRamDelSubDep2Table in-memory RAM DbIO implementation
 *	for DelSubDep2.
 */
public class BusModelRamDelSubDep2Table
	implements IBusModelDelSubDep2Table
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffDelSubDep2 > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffDelSubDep2 >();
	private Map< BusModelBuffDelSubDep2ByContDelDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelSubDep2 >> dictByContDelDep1Idx
		= new HashMap< BusModelBuffDelSubDep2ByContDelDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelSubDep2 >>();
	private Map< BusModelBuffDelSubDep2ByUNameIdxKey,
			BusModelBuffDelSubDep2 > dictByUNameIdx
		= new HashMap< BusModelBuffDelSubDep2ByUNameIdxKey,
			BusModelBuffDelSubDep2 >();

	public BusModelRamDelSubDep2Table( IBusModelSchema argSchema ) {
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
	public IBusModelDelSubDep2 createDelSubDep2( ISecureAuthorization Authorization,
		IBusModelDelSubDep2 iBuff )
	{
		final String S_ProcName = "createDelSubDep2";
		
		BusModelBuffDelSubDep2 Buff = (BusModelBuffDelSubDep2)(schema.getTableDelDep().createDelDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx = (BusModelBuffDelSubDep2ByContDelDep1IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
		keyContDelDep1Idx.setRequiredDelSubDep1Id( Buff.getRequiredDelSubDep1Id() );

		BusModelBuffDelSubDep2ByUNameIdxKey keyUNameIdx = (BusModelBuffDelSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByUNameIdxKey();
		keyUNameIdx.setRequiredDelSubDep1Id( Buff.getRequiredDelSubDep1Id() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DelSubDep2UNameIdx",
				"DelSubDep2UNameIdx",
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
				if( null == schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredDelSubDep1Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"DelSubDep1",
						"DelSubDep1",
						"DelSubDep1",
						"DelSubDep1",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep2 > subdictContDelDep1Idx;
		if( dictByContDelDep1Idx.containsKey( keyContDelDep1Idx ) ) {
			subdictContDelDep1Idx = dictByContDelDep1Idx.get( keyContDelDep1Idx );
		}
		else {
			subdictContDelDep1Idx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep2 >();
			dictByContDelDep1Idx.put( keyContDelDep1Idx, subdictContDelDep1Idx );
		}
		subdictContDelDep1Idx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelDelSubDep2.CLASS_CODE) {
				BusModelBuffDelSubDep2 retbuff = ((BusModelBuffDelSubDep2)(schema.getBusModelBuffFactory().getFactoryDelSubDep2().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelDelSubDep2 readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelSubDep2.readDerived";
		IBusModelDelSubDep2 buff;
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
	public IBusModelDelSubDep2 lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelSubDep2.lockDerived";
		IBusModelDelSubDep2 buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep2[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamDelSubDep2.readAllDerived";
		IBusModelDelSubDep2[] retList = new IBusModelDelSubDep2[ dictByPKey.values().size() ];
		Iterator< BusModelBuffDelSubDep2 > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelDelSubDep2[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDelSubDep2> filteredList = new ArrayList<IBusModelDelSubDep2>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelSubDep2 ) ) {
					filteredList.add( (IBusModelDelSubDep2)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelSubDep2[0] ) );
		}
	}

	@Override
	public IBusModelDelSubDep2[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDelSubDep2> filteredList = new ArrayList<IBusModelDelSubDep2>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelSubDep2 ) ) {
					filteredList.add( (IBusModelDelSubDep2)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelSubDep2[0] ) );
		}
	}

	@Override
	public IBusModelDelSubDep2[] readDerivedByDelDepIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDelSubDep2> filteredList = new ArrayList<IBusModelDelSubDep2>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelSubDep2 ) ) {
					filteredList.add( (IBusModelDelSubDep2)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelSubDep2[0] ) );
		}
	}

	@Override
	public IBusModelDelSubDep2[] readDerivedByContDelDep1Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelSubDep1Id )
	{
		final String S_ProcName = "BusModelRamDelSubDep2.readDerivedByContDelDep1Idx";
		BusModelBuffDelSubDep2ByContDelDep1IdxKey key = (BusModelBuffDelSubDep2ByContDelDep1IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();

		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		IBusModelDelSubDep2[] recArray;
		if( dictByContDelDep1Idx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep2 > subdictContDelDep1Idx
				= dictByContDelDep1Idx.get( key );
			recArray = new IBusModelDelSubDep2[ subdictContDelDep1Idx.size() ];
			Iterator< BusModelBuffDelSubDep2 > iter = subdictContDelDep1Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep2 > subdictContDelDep1Idx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep2 >();
			dictByContDelDep1Idx.put( key, subdictContDelDep1Idx );
			recArray = new IBusModelDelSubDep2[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelDelSubDep2 readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelSubDep1Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamDelSubDep2.readDerivedByUNameIdx";
		BusModelBuffDelSubDep2ByUNameIdxKey key = (BusModelBuffDelSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByUNameIdxKey();

		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		key.setRequiredName( Name );
		IBusModelDelSubDep2 buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep2 readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelDelSubDep2 buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep2 readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelSubDep2.readRec";
		IBusModelDelSubDep2 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelSubDep2.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep2 lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelDelSubDep2 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelSubDep2.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep2[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamDelSubDep2.readAllRec";
		IBusModelDelSubDep2 buff;
		ArrayList<IBusModelDelSubDep2> filteredList = new ArrayList<IBusModelDelSubDep2>();
		IBusModelDelSubDep2[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelSubDep2.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep2[0] ) );
	}

	@Override
	public IBusModelDelSubDep2 readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelDelSubDep2 buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelDelSubDep2)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelDelSubDep2[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelDelSubDep2 buff;
		ArrayList<IBusModelDelSubDep2> filteredList = new ArrayList<IBusModelDelSubDep2>();
		IBusModelDelSubDep2[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep2[0] ) );
	}

	@Override
	public IBusModelDelSubDep2[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDefSchemaIdx() ";
		IBusModelDelSubDep2 buff;
		ArrayList<IBusModelDelSubDep2> filteredList = new ArrayList<IBusModelDelSubDep2>();
		IBusModelDelSubDep2[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep2[0] ) );
	}

	@Override
	public IBusModelDelSubDep2[] readRecByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDelDepIdx() ";
		IBusModelDelSubDep2 buff;
		ArrayList<IBusModelDelSubDep2> filteredList = new ArrayList<IBusModelDelSubDep2>();
		IBusModelDelSubDep2[] buffList = readDerivedByDelDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep2[0] ) );
	}

	@Override
	public IBusModelDelSubDep2[] readRecByContDelDep1Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelSubDep1Id )
	{
		final String S_ProcName = "BusModelRamDelSubDep2.readRecByContDelDep1Idx() ";
		IBusModelDelSubDep2 buff;
		ArrayList<IBusModelDelSubDep2> filteredList = new ArrayList<IBusModelDelSubDep2>();
		IBusModelDelSubDep2[] buffList = readDerivedByContDelDep1Idx( Authorization,
			DelSubDep1Id );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelSubDep2.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep2)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep2[0] ) );
	}

	@Override
	public IBusModelDelSubDep2 readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelSubDep1Id,
		String Name )
	{
		final String S_ProcName = "BusModelRamDelSubDep2.readRecByUNameIdx() ";
		IBusModelDelSubDep2 buff = readDerivedByUNameIdx( Authorization,
			DelSubDep1Id,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelSubDep2.CLASS_CODE ) ) {
			return( (IBusModelDelSubDep2)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelDelSubDep2 updateDelSubDep2( ISecureAuthorization Authorization,
		IBusModelDelSubDep2 iBuff )
	{
		BusModelBuffDelSubDep2 Buff = (BusModelBuffDelSubDep2)(schema.getTableDelDep().updateDelDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDelSubDep2 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateDelSubDep2",
				"Existing record not found",
				"Existing record not found",
				"DelSubDep2",
				"DelSubDep2",
				pkey );
		}
		BusModelBuffDelSubDep2ByContDelDep1IdxKey existingKeyContDelDep1Idx = (BusModelBuffDelSubDep2ByContDelDep1IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
		existingKeyContDelDep1Idx.setRequiredDelSubDep1Id( existing.getRequiredDelSubDep1Id() );

		BusModelBuffDelSubDep2ByContDelDep1IdxKey newKeyContDelDep1Idx = (BusModelBuffDelSubDep2ByContDelDep1IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
		newKeyContDelDep1Idx.setRequiredDelSubDep1Id( Buff.getRequiredDelSubDep1Id() );

		BusModelBuffDelSubDep2ByUNameIdxKey existingKeyUNameIdx = (BusModelBuffDelSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredDelSubDep1Id( existing.getRequiredDelSubDep1Id() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffDelSubDep2ByUNameIdxKey newKeyUNameIdx = (BusModelBuffDelSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredDelSubDep1Id( Buff.getRequiredDelSubDep1Id() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateDelSubDep2",
					"DelSubDep2UNameIdx",
					"DelSubDep2UNameIdx",
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
						"updateDelSubDep2",
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
				if( null == schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
						Buff.getRequiredDelSubDep1Id() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateDelSubDep2",
						"Container",
						"Container",
						"DelSubDep1",
						"DelSubDep1",
						"DelSubDep1",
						"DelSubDep1",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep2 > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContDelDep1Idx.get( existingKeyContDelDep1Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContDelDep1Idx.containsKey( newKeyContDelDep1Idx ) ) {
			subdict = dictByContDelDep1Idx.get( newKeyContDelDep1Idx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep2 >();
			dictByContDelDep1Idx.put( newKeyContDelDep1Idx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteDelSubDep2( ISecureAuthorization Authorization,
		IBusModelDelSubDep2 iBuff )
	{
		final String S_ProcName = "BusModelRamDelSubDep2Table.deleteDelSubDep2() ";
		BusModelBuffDelSubDep2 Buff = (BusModelBuffDelSubDep2)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffDelSubDep2 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteDelSubDep2",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckDelDep[] = schema.getTableDelSubDep3().readDerivedByDelSubDep2Idx( Authorization,
						existing.getRequiredId() );
		if( arrCheckDelDep.length > 0 ) {
			schema.getTableDelSubDep3().deleteDelSubDep3ByDelSubDep2Idx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx = (BusModelBuffDelSubDep2ByContDelDep1IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
		keyContDelDep1Idx.setRequiredDelSubDep1Id( existing.getRequiredDelSubDep1Id() );

		BusModelBuffDelSubDep2ByUNameIdxKey keyUNameIdx = (BusModelBuffDelSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByUNameIdxKey();
		keyUNameIdx.setRequiredDelSubDep1Id( existing.getRequiredDelSubDep1Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep2 > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContDelDep1Idx.get( keyContDelDep1Idx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableDelDep().deleteDelDep( Authorization,
			Buff );
	}
	@Override
	public void deleteDelSubDep2ByContDelDep1Idx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDelSubDep1Id )
	{
		BusModelBuffDelSubDep2ByContDelDep1IdxKey key = (BusModelBuffDelSubDep2ByContDelDep1IdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
		key.setRequiredDelSubDep1Id( argDelSubDep1Id );
		deleteDelSubDep2ByContDelDep1Idx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep2ByContDelDep1Idx( ISecureAuthorization Authorization,
		IBusModelDelSubDep2ByContDelDep1IdxKey argKey )
	{
		BusModelBuffDelSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep2> matchSet = new LinkedList<BusModelBuffDelSubDep2>();
		Iterator<BusModelBuffDelSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep2)(schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep2ByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDelSubDep1Id,
		String argName )
	{
		BusModelBuffDelSubDep2ByUNameIdxKey key = (BusModelBuffDelSubDep2ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep2().newByUNameIdxKey();
		key.setRequiredDelSubDep1Id( argDelSubDep1Id );
		key.setRequiredName( argName );
		deleteDelSubDep2ByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep2ByUNameIdx( ISecureAuthorization Authorization,
		IBusModelDelSubDep2ByUNameIdxKey argKey )
	{
		BusModelBuffDelSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep2> matchSet = new LinkedList<BusModelBuffDelSubDep2>();
		Iterator<BusModelBuffDelSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep2)(schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep2ByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffDelDepByDefSchemaIdxKey key = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelSubDep2ByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep2ByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffDelSubDep2 cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep2> matchSet = new LinkedList<BusModelBuffDelSubDep2>();
		Iterator<BusModelBuffDelSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep2)(schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep2ByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffDelDepByDelDepIdxKey key = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteDelSubDep2ByDelDepIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep2ByDelDepIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDelDepIdxKey argKey )
	{
		BusModelBuffDelSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep2> matchSet = new LinkedList<BusModelBuffDelSubDep2>();
		Iterator<BusModelBuffDelSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep2)(schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep2ByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffDelSubDep2 cur;
		LinkedList<BusModelBuffDelSubDep2> matchSet = new LinkedList<BusModelBuffDelSubDep2>();
		Iterator<BusModelBuffDelSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep2)(schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep2( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep2ByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelSubDep2ByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep2ByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffDelSubDep2 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep2> matchSet = new LinkedList<BusModelBuffDelSubDep2>();
		Iterator<BusModelBuffDelSubDep2> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep2> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep2)(schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep2( Authorization, cur );
		}
	}
}
