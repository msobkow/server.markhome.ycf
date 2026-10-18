
// Description: Java 25 in-memory RAM DbIO implementation for DelSubDep1.

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
 *	BusModelRamDelSubDep1Table in-memory RAM DbIO implementation
 *	for DelSubDep1.
 */
public class BusModelRamDelSubDep1Table
	implements IBusModelDelSubDep1Table
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffDelSubDep1 > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffDelSubDep1 >();
	private Map< BusModelBuffDelSubDep1ByDelTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelSubDep1 >> dictByDelTopDepIdx
		= new HashMap< BusModelBuffDelSubDep1ByDelTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelSubDep1 >>();
	private Map< BusModelBuffDelSubDep1ByUNameIdxKey,
			BusModelBuffDelSubDep1 > dictByUNameIdx
		= new HashMap< BusModelBuffDelSubDep1ByUNameIdxKey,
			BusModelBuffDelSubDep1 >();

	public BusModelRamDelSubDep1Table( IBusModelSchema argSchema ) {
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
	public IBusModelDelSubDep1 createDelSubDep1( ISecureAuthorization Authorization,
		IBusModelDelSubDep1 iBuff )
	{
		final String S_ProcName = "createDelSubDep1";
		
		BusModelBuffDelSubDep1 Buff = (BusModelBuffDelSubDep1)(schema.getTableDelDep().createDelDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDelSubDep1ByDelTopDepIdxKey keyDelTopDepIdx = (BusModelBuffDelSubDep1ByDelTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
		keyDelTopDepIdx.setRequiredDelTopDepId( Buff.getRequiredDelTopDepId() );

		BusModelBuffDelSubDep1ByUNameIdxKey keyUNameIdx = (BusModelBuffDelSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByUNameIdxKey();
		keyUNameIdx.setRequiredDelTopDepId( Buff.getRequiredDelTopDepId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DelSubDep1UNameIdx",
				"DelSubDep1UNameIdx",
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
				if( null == schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredDelTopDepId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"DelTopDep",
						"DelTopDep",
						"DelTopDep",
						"DelTopDep",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep1 > subdictDelTopDepIdx;
		if( dictByDelTopDepIdx.containsKey( keyDelTopDepIdx ) ) {
			subdictDelTopDepIdx = dictByDelTopDepIdx.get( keyDelTopDepIdx );
		}
		else {
			subdictDelTopDepIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep1 >();
			dictByDelTopDepIdx.put( keyDelTopDepIdx, subdictDelTopDepIdx );
		}
		subdictDelTopDepIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelDelSubDep1.CLASS_CODE) {
				BusModelBuffDelSubDep1 retbuff = ((BusModelBuffDelSubDep1)(schema.getBusModelBuffFactory().getFactoryDelSubDep1().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelDelSubDep1 readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelSubDep1.readDerived";
		IBusModelDelSubDep1 buff;
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
	public IBusModelDelSubDep1 lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelSubDep1.lockDerived";
		IBusModelDelSubDep1 buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep1[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamDelSubDep1.readAllDerived";
		IBusModelDelSubDep1[] retList = new IBusModelDelSubDep1[ dictByPKey.values().size() ];
		Iterator< BusModelBuffDelSubDep1 > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelDelSubDep1[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDelSubDep1> filteredList = new ArrayList<IBusModelDelSubDep1>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelSubDep1 ) ) {
					filteredList.add( (IBusModelDelSubDep1)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelSubDep1[0] ) );
		}
	}

	@Override
	public IBusModelDelSubDep1[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDelSubDep1> filteredList = new ArrayList<IBusModelDelSubDep1>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelSubDep1 ) ) {
					filteredList.add( (IBusModelDelSubDep1)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelSubDep1[0] ) );
		}
	}

	@Override
	public IBusModelDelSubDep1[] readDerivedByDelDepIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDelSubDep1> filteredList = new ArrayList<IBusModelDelSubDep1>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelSubDep1 ) ) {
					filteredList.add( (IBusModelDelSubDep1)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelSubDep1[0] ) );
		}
	}

	@Override
	public IBusModelDelSubDep1[] readDerivedByDelTopDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelTopDepId )
	{
		final String S_ProcName = "BusModelRamDelSubDep1.readDerivedByDelTopDepIdx";
		BusModelBuffDelSubDep1ByDelTopDepIdxKey key = (BusModelBuffDelSubDep1ByDelTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();

		key.setRequiredDelTopDepId( DelTopDepId );
		IBusModelDelSubDep1[] recArray;
		if( dictByDelTopDepIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep1 > subdictDelTopDepIdx
				= dictByDelTopDepIdx.get( key );
			recArray = new IBusModelDelSubDep1[ subdictDelTopDepIdx.size() ];
			Iterator< BusModelBuffDelSubDep1 > iter = subdictDelTopDepIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep1 > subdictDelTopDepIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep1 >();
			dictByDelTopDepIdx.put( key, subdictDelTopDepIdx );
			recArray = new IBusModelDelSubDep1[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelDelSubDep1 readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelTopDepId,
		String Name )
	{
		final String S_ProcName = "BusModelRamDelSubDep1.readDerivedByUNameIdx";
		BusModelBuffDelSubDep1ByUNameIdxKey key = (BusModelBuffDelSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByUNameIdxKey();

		key.setRequiredDelTopDepId( DelTopDepId );
		key.setRequiredName( Name );
		IBusModelDelSubDep1 buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep1 readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelDelSubDep1 buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep1 readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelSubDep1.readRec";
		IBusModelDelSubDep1 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelSubDep1.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep1 lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelDelSubDep1 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelSubDep1.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelSubDep1[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamDelSubDep1.readAllRec";
		IBusModelDelSubDep1 buff;
		ArrayList<IBusModelDelSubDep1> filteredList = new ArrayList<IBusModelDelSubDep1>();
		IBusModelDelSubDep1[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelSubDep1.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep1[0] ) );
	}

	@Override
	public IBusModelDelSubDep1 readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelDelSubDep1 buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelDelSubDep1)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelDelSubDep1[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelDelSubDep1 buff;
		ArrayList<IBusModelDelSubDep1> filteredList = new ArrayList<IBusModelDelSubDep1>();
		IBusModelDelSubDep1[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep1[0] ) );
	}

	@Override
	public IBusModelDelSubDep1[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDefSchemaIdx() ";
		IBusModelDelSubDep1 buff;
		ArrayList<IBusModelDelSubDep1> filteredList = new ArrayList<IBusModelDelSubDep1>();
		IBusModelDelSubDep1[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep1[0] ) );
	}

	@Override
	public IBusModelDelSubDep1[] readRecByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDelDepIdx() ";
		IBusModelDelSubDep1 buff;
		ArrayList<IBusModelDelSubDep1> filteredList = new ArrayList<IBusModelDelSubDep1>();
		IBusModelDelSubDep1[] buffList = readDerivedByDelDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep1[0] ) );
	}

	@Override
	public IBusModelDelSubDep1[] readRecByDelTopDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelTopDepId )
	{
		final String S_ProcName = "BusModelRamDelSubDep1.readRecByDelTopDepIdx() ";
		IBusModelDelSubDep1 buff;
		ArrayList<IBusModelDelSubDep1> filteredList = new ArrayList<IBusModelDelSubDep1>();
		IBusModelDelSubDep1[] buffList = readDerivedByDelTopDepIdx( Authorization,
			DelTopDepId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelSubDep1.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelSubDep1[0] ) );
	}

	@Override
	public IBusModelDelSubDep1 readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DelTopDepId,
		String Name )
	{
		final String S_ProcName = "BusModelRamDelSubDep1.readRecByUNameIdx() ";
		IBusModelDelSubDep1 buff = readDerivedByUNameIdx( Authorization,
			DelTopDepId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelSubDep1.CLASS_CODE ) ) {
			return( (IBusModelDelSubDep1)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelDelSubDep1 updateDelSubDep1( ISecureAuthorization Authorization,
		IBusModelDelSubDep1 iBuff )
	{
		BusModelBuffDelSubDep1 Buff = (BusModelBuffDelSubDep1)(schema.getTableDelDep().updateDelDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDelSubDep1 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateDelSubDep1",
				"Existing record not found",
				"Existing record not found",
				"DelSubDep1",
				"DelSubDep1",
				pkey );
		}
		BusModelBuffDelSubDep1ByDelTopDepIdxKey existingKeyDelTopDepIdx = (BusModelBuffDelSubDep1ByDelTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
		existingKeyDelTopDepIdx.setRequiredDelTopDepId( existing.getRequiredDelTopDepId() );

		BusModelBuffDelSubDep1ByDelTopDepIdxKey newKeyDelTopDepIdx = (BusModelBuffDelSubDep1ByDelTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
		newKeyDelTopDepIdx.setRequiredDelTopDepId( Buff.getRequiredDelTopDepId() );

		BusModelBuffDelSubDep1ByUNameIdxKey existingKeyUNameIdx = (BusModelBuffDelSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredDelTopDepId( existing.getRequiredDelTopDepId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffDelSubDep1ByUNameIdxKey newKeyUNameIdx = (BusModelBuffDelSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredDelTopDepId( Buff.getRequiredDelTopDepId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateDelSubDep1",
					"DelSubDep1UNameIdx",
					"DelSubDep1UNameIdx",
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
						"updateDelSubDep1",
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
				if( null == schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredDelTopDepId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateDelSubDep1",
						"Container",
						"Container",
						"DelTopDep",
						"DelTopDep",
						"DelTopDep",
						"DelTopDep",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep1 > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByDelTopDepIdx.get( existingKeyDelTopDepIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDelTopDepIdx.containsKey( newKeyDelTopDepIdx ) ) {
			subdict = dictByDelTopDepIdx.get( newKeyDelTopDepIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep1 >();
			dictByDelTopDepIdx.put( newKeyDelTopDepIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteDelSubDep1( ISecureAuthorization Authorization,
		IBusModelDelSubDep1 iBuff )
	{
		final String S_ProcName = "BusModelRamDelSubDep1Table.deleteDelSubDep1() ";
		BusModelBuffDelSubDep1 Buff = (BusModelBuffDelSubDep1)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffDelSubDep1 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteDelSubDep1",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckDelDep[] = schema.getTableDelSubDep2().readDerivedByContDelDep1Idx( Authorization,
						existing.getRequiredId() );
		if( arrCheckDelDep.length > 0 ) {
			schema.getTableDelSubDep2().deleteDelSubDep2ByContDelDep1Idx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffDelSubDep1ByDelTopDepIdxKey keyDelTopDepIdx = (BusModelBuffDelSubDep1ByDelTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
		keyDelTopDepIdx.setRequiredDelTopDepId( existing.getRequiredDelTopDepId() );

		BusModelBuffDelSubDep1ByUNameIdxKey keyUNameIdx = (BusModelBuffDelSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByUNameIdxKey();
		keyUNameIdx.setRequiredDelTopDepId( existing.getRequiredDelTopDepId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelSubDep1 > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByDelTopDepIdx.get( keyDelTopDepIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTableDelDep().deleteDelDep( Authorization,
			Buff );
	}
	@Override
	public void deleteDelSubDep1ByDelTopDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDelTopDepId )
	{
		BusModelBuffDelSubDep1ByDelTopDepIdxKey key = (BusModelBuffDelSubDep1ByDelTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
		key.setRequiredDelTopDepId( argDelTopDepId );
		deleteDelSubDep1ByDelTopDepIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep1ByDelTopDepIdx( ISecureAuthorization Authorization,
		IBusModelDelSubDep1ByDelTopDepIdxKey argKey )
	{
		BusModelBuffDelSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep1> matchSet = new LinkedList<BusModelBuffDelSubDep1>();
		Iterator<BusModelBuffDelSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep1)(schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep1ByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDelTopDepId,
		String argName )
	{
		BusModelBuffDelSubDep1ByUNameIdxKey key = (BusModelBuffDelSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelSubDep1().newByUNameIdxKey();
		key.setRequiredDelTopDepId( argDelTopDepId );
		key.setRequiredName( argName );
		deleteDelSubDep1ByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep1ByUNameIdx( ISecureAuthorization Authorization,
		IBusModelDelSubDep1ByUNameIdxKey argKey )
	{
		BusModelBuffDelSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep1> matchSet = new LinkedList<BusModelBuffDelSubDep1>();
		Iterator<BusModelBuffDelSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep1)(schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep1ByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffDelDepByDefSchemaIdxKey key = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelSubDep1ByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep1ByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffDelSubDep1 cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep1> matchSet = new LinkedList<BusModelBuffDelSubDep1>();
		Iterator<BusModelBuffDelSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep1)(schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep1ByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffDelDepByDelDepIdxKey key = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteDelSubDep1ByDelDepIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep1ByDelDepIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDelDepIdxKey argKey )
	{
		BusModelBuffDelSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep1> matchSet = new LinkedList<BusModelBuffDelSubDep1>();
		Iterator<BusModelBuffDelSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep1)(schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep1ByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffDelSubDep1 cur;
		LinkedList<BusModelBuffDelSubDep1> matchSet = new LinkedList<BusModelBuffDelSubDep1>();
		Iterator<BusModelBuffDelSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep1)(schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deleteDelSubDep1ByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelSubDep1ByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteDelSubDep1ByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffDelSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelSubDep1> matchSet = new LinkedList<BusModelBuffDelSubDep1>();
		Iterator<BusModelBuffDelSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelSubDep1)(schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelSubDep1( Authorization, cur );
		}
	}
}
