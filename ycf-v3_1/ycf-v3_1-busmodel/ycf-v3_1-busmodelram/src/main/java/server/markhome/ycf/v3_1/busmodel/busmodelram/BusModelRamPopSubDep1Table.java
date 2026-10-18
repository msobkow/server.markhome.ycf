
// Description: Java 25 in-memory RAM DbIO implementation for PopSubDep1.

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
 *	BusModelRamPopSubDep1Table in-memory RAM DbIO implementation
 *	for PopSubDep1.
 */
public class BusModelRamPopSubDep1Table
	implements IBusModelPopSubDep1Table
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffPopSubDep1 > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffPopSubDep1 >();
	private Map< BusModelBuffPopSubDep1ByPopTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffPopSubDep1 >> dictByPopTopDepIdx
		= new HashMap< BusModelBuffPopSubDep1ByPopTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffPopSubDep1 >>();
	private Map< BusModelBuffPopSubDep1ByUNameIdxKey,
			BusModelBuffPopSubDep1 > dictByUNameIdx
		= new HashMap< BusModelBuffPopSubDep1ByUNameIdxKey,
			BusModelBuffPopSubDep1 >();

	public BusModelRamPopSubDep1Table( IBusModelSchema argSchema ) {
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
	public IBusModelPopSubDep1 createPopSubDep1( ISecureAuthorization Authorization,
		IBusModelPopSubDep1 iBuff )
	{
		final String S_ProcName = "createPopSubDep1";
		
		BusModelBuffPopSubDep1 Buff = (BusModelBuffPopSubDep1)(schema.getTablePopDep().createPopDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx = (BusModelBuffPopSubDep1ByPopTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
		keyPopTopDepIdx.setRequiredPopTopDepId( Buff.getRequiredPopTopDepId() );

		BusModelBuffPopSubDep1ByUNameIdxKey keyUNameIdx = (BusModelBuffPopSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByUNameIdxKey();
		keyUNameIdx.setRequiredPopTopDepId( Buff.getRequiredPopTopDepId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"PopSubDep1UNameIdx",
				"PopSubDep1UNameIdx",
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
				if( null == schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPopTopDepId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"PopTopDep",
						"PopTopDep",
						"PopTopDep",
						"PopTopDep",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep1 > subdictPopTopDepIdx;
		if( dictByPopTopDepIdx.containsKey( keyPopTopDepIdx ) ) {
			subdictPopTopDepIdx = dictByPopTopDepIdx.get( keyPopTopDepIdx );
		}
		else {
			subdictPopTopDepIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep1 >();
			dictByPopTopDepIdx.put( keyPopTopDepIdx, subdictPopTopDepIdx );
		}
		subdictPopTopDepIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelPopSubDep1.CLASS_CODE) {
				BusModelBuffPopSubDep1 retbuff = ((BusModelBuffPopSubDep1)(schema.getBusModelBuffFactory().getFactoryPopSubDep1().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelPopSubDep1 readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopSubDep1.readDerived";
		IBusModelPopSubDep1 buff;
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
	public IBusModelPopSubDep1 lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopSubDep1.lockDerived";
		IBusModelPopSubDep1 buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep1[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamPopSubDep1.readAllDerived";
		IBusModelPopSubDep1[] retList = new IBusModelPopSubDep1[ dictByPKey.values().size() ];
		Iterator< BusModelBuffPopSubDep1 > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelPopSubDep1[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopSubDep1> filteredList = new ArrayList<IBusModelPopSubDep1>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopSubDep1 ) ) {
					filteredList.add( (IBusModelPopSubDep1)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopSubDep1[0] ) );
		}
	}

	@Override
	public IBusModelPopSubDep1[] readDerivedByRelationIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopSubDep1> filteredList = new ArrayList<IBusModelPopSubDep1>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopSubDep1 ) ) {
					filteredList.add( (IBusModelPopSubDep1)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopSubDep1[0] ) );
		}
	}

	@Override
	public IBusModelPopSubDep1[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopSubDep1> filteredList = new ArrayList<IBusModelPopSubDep1>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopSubDep1 ) ) {
					filteredList.add( (IBusModelPopSubDep1)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopSubDep1[0] ) );
		}
	}

	@Override
	public IBusModelPopSubDep1[] readDerivedByPopTopDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopTopDepId )
	{
		final String S_ProcName = "BusModelRamPopSubDep1.readDerivedByPopTopDepIdx";
		BusModelBuffPopSubDep1ByPopTopDepIdxKey key = (BusModelBuffPopSubDep1ByPopTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();

		key.setRequiredPopTopDepId( PopTopDepId );
		IBusModelPopSubDep1[] recArray;
		if( dictByPopTopDepIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep1 > subdictPopTopDepIdx
				= dictByPopTopDepIdx.get( key );
			recArray = new IBusModelPopSubDep1[ subdictPopTopDepIdx.size() ];
			Iterator< BusModelBuffPopSubDep1 > iter = subdictPopTopDepIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep1 > subdictPopTopDepIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep1 >();
			dictByPopTopDepIdx.put( key, subdictPopTopDepIdx );
			recArray = new IBusModelPopSubDep1[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelPopSubDep1 readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopTopDepId,
		String Name )
	{
		final String S_ProcName = "BusModelRamPopSubDep1.readDerivedByUNameIdx";
		BusModelBuffPopSubDep1ByUNameIdxKey key = (BusModelBuffPopSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByUNameIdxKey();

		key.setRequiredPopTopDepId( PopTopDepId );
		key.setRequiredName( Name );
		IBusModelPopSubDep1 buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep1 readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelPopSubDep1 buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep1 readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopSubDep1.readRec";
		IBusModelPopSubDep1 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelPopSubDep1.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep1 lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelPopSubDep1 buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelPopSubDep1.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopSubDep1[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamPopSubDep1.readAllRec";
		IBusModelPopSubDep1 buff;
		ArrayList<IBusModelPopSubDep1> filteredList = new ArrayList<IBusModelPopSubDep1>();
		IBusModelPopSubDep1[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopSubDep1.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep1[0] ) );
	}

	@Override
	public IBusModelPopSubDep1 readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelPopSubDep1 buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelPopSubDep1)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelPopSubDep1[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelPopSubDep1 buff;
		ArrayList<IBusModelPopSubDep1> filteredList = new ArrayList<IBusModelPopSubDep1>();
		IBusModelPopSubDep1[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep1[0] ) );
	}

	@Override
	public IBusModelPopSubDep1[] readRecByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamPopDep.readRecByRelationIdx() ";
		IBusModelPopSubDep1 buff;
		ArrayList<IBusModelPopSubDep1> filteredList = new ArrayList<IBusModelPopSubDep1>();
		IBusModelPopSubDep1[] buffList = readDerivedByRelationIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep1[0] ) );
	}

	@Override
	public IBusModelPopSubDep1[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamPopDep.readRecByDefSchemaIdx() ";
		IBusModelPopSubDep1 buff;
		ArrayList<IBusModelPopSubDep1> filteredList = new ArrayList<IBusModelPopSubDep1>();
		IBusModelPopSubDep1[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep1[0] ) );
	}

	@Override
	public IBusModelPopSubDep1[] readRecByPopTopDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopTopDepId )
	{
		final String S_ProcName = "BusModelRamPopSubDep1.readRecByPopTopDepIdx() ";
		IBusModelPopSubDep1 buff;
		ArrayList<IBusModelPopSubDep1> filteredList = new ArrayList<IBusModelPopSubDep1>();
		IBusModelPopSubDep1[] buffList = readDerivedByPopTopDepIdx( Authorization,
			PopTopDepId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopSubDep1.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopSubDep1)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopSubDep1[0] ) );
	}

	@Override
	public IBusModelPopSubDep1 readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PopTopDepId,
		String Name )
	{
		final String S_ProcName = "BusModelRamPopSubDep1.readRecByUNameIdx() ";
		IBusModelPopSubDep1 buff = readDerivedByUNameIdx( Authorization,
			PopTopDepId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopSubDep1.CLASS_CODE ) ) {
			return( (IBusModelPopSubDep1)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelPopSubDep1 updatePopSubDep1( ISecureAuthorization Authorization,
		IBusModelPopSubDep1 iBuff )
	{
		BusModelBuffPopSubDep1 Buff = (BusModelBuffPopSubDep1)(schema.getTablePopDep().updatePopDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffPopSubDep1 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updatePopSubDep1",
				"Existing record not found",
				"Existing record not found",
				"PopSubDep1",
				"PopSubDep1",
				pkey );
		}
		BusModelBuffPopSubDep1ByPopTopDepIdxKey existingKeyPopTopDepIdx = (BusModelBuffPopSubDep1ByPopTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
		existingKeyPopTopDepIdx.setRequiredPopTopDepId( existing.getRequiredPopTopDepId() );

		BusModelBuffPopSubDep1ByPopTopDepIdxKey newKeyPopTopDepIdx = (BusModelBuffPopSubDep1ByPopTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
		newKeyPopTopDepIdx.setRequiredPopTopDepId( Buff.getRequiredPopTopDepId() );

		BusModelBuffPopSubDep1ByUNameIdxKey existingKeyUNameIdx = (BusModelBuffPopSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredPopTopDepId( existing.getRequiredPopTopDepId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffPopSubDep1ByUNameIdxKey newKeyUNameIdx = (BusModelBuffPopSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredPopTopDepId( Buff.getRequiredPopTopDepId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updatePopSubDep1",
					"PopSubDep1UNameIdx",
					"PopSubDep1UNameIdx",
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
						"updatePopSubDep1",
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
				if( null == schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredPopTopDepId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updatePopSubDep1",
						"Container",
						"Container",
						"PopTopDep",
						"PopTopDep",
						"PopTopDep",
						"PopTopDep",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep1 > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByPopTopDepIdx.get( existingKeyPopTopDepIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPopTopDepIdx.containsKey( newKeyPopTopDepIdx ) ) {
			subdict = dictByPopTopDepIdx.get( newKeyPopTopDepIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep1 >();
			dictByPopTopDepIdx.put( newKeyPopTopDepIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deletePopSubDep1( ISecureAuthorization Authorization,
		IBusModelPopSubDep1 iBuff )
	{
		final String S_ProcName = "BusModelRamPopSubDep1Table.deletePopSubDep1() ";
		BusModelBuffPopSubDep1 Buff = (BusModelBuffPopSubDep1)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffPopSubDep1 existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deletePopSubDep1",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckPopDep[] = schema.getTablePopSubDep2().readDerivedByPopSubDep1Idx( Authorization,
						existing.getRequiredId() );
		if( arrCheckPopDep.length > 0 ) {
			schema.getTablePopSubDep2().deletePopSubDep2ByPopSubDep1Idx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx = (BusModelBuffPopSubDep1ByPopTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
		keyPopTopDepIdx.setRequiredPopTopDepId( existing.getRequiredPopTopDepId() );

		BusModelBuffPopSubDep1ByUNameIdxKey keyUNameIdx = (BusModelBuffPopSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByUNameIdxKey();
		keyUNameIdx.setRequiredPopTopDepId( existing.getRequiredPopTopDepId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopSubDep1 > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByPopTopDepIdx.get( keyPopTopDepIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTablePopDep().deletePopDep( Authorization,
			Buff );
	}
	@Override
	public void deletePopSubDep1ByPopTopDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPopTopDepId )
	{
		BusModelBuffPopSubDep1ByPopTopDepIdxKey key = (BusModelBuffPopSubDep1ByPopTopDepIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
		key.setRequiredPopTopDepId( argPopTopDepId );
		deletePopSubDep1ByPopTopDepIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep1ByPopTopDepIdx( ISecureAuthorization Authorization,
		IBusModelPopSubDep1ByPopTopDepIdxKey argKey )
	{
		BusModelBuffPopSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep1> matchSet = new LinkedList<BusModelBuffPopSubDep1>();
		Iterator<BusModelBuffPopSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep1)(schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep1ByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPopTopDepId,
		String argName )
	{
		BusModelBuffPopSubDep1ByUNameIdxKey key = (BusModelBuffPopSubDep1ByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopSubDep1().newByUNameIdxKey();
		key.setRequiredPopTopDepId( argPopTopDepId );
		key.setRequiredName( argName );
		deletePopSubDep1ByUNameIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep1ByUNameIdx( ISecureAuthorization Authorization,
		IBusModelPopSubDep1ByUNameIdxKey argKey )
	{
		BusModelBuffPopSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep1> matchSet = new LinkedList<BusModelBuffPopSubDep1>();
		Iterator<BusModelBuffPopSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep1)(schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep1ByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffPopDepByRelationIdxKey key = (BusModelBuffPopDepByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( argRelationId );
		deletePopSubDep1ByRelationIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep1ByRelationIdx( ISecureAuthorization Authorization,
		IBusModelPopDepByRelationIdxKey argKey )
	{
		BusModelBuffPopSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep1> matchSet = new LinkedList<BusModelBuffPopSubDep1>();
		Iterator<BusModelBuffPopSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep1)(schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep1ByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffPopDepByDefSchemaIdxKey key = (BusModelBuffPopDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deletePopSubDep1ByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep1ByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelPopDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffPopSubDep1 cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep1> matchSet = new LinkedList<BusModelBuffPopSubDep1>();
		Iterator<BusModelBuffPopSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep1)(schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep1ByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffPopSubDep1 cur;
		LinkedList<BusModelBuffPopSubDep1> matchSet = new LinkedList<BusModelBuffPopSubDep1>();
		Iterator<BusModelBuffPopSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep1)(schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep1( Authorization, cur );
		}
	}

	@Override
	public void deletePopSubDep1ByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deletePopSubDep1ByTenantIdx( Authorization, key );
	}

	@Override
	public void deletePopSubDep1ByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffPopSubDep1 cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopSubDep1> matchSet = new LinkedList<BusModelBuffPopSubDep1>();
		Iterator<BusModelBuffPopSubDep1> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopSubDep1> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopSubDep1)(schema.getTablePopSubDep1().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopSubDep1( Authorization, cur );
		}
	}
}
