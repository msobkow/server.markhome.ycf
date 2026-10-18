
// Description: Java 25 in-memory RAM DbIO implementation for PopTopDep.

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
 *	BusModelRamPopTopDepTable in-memory RAM DbIO implementation
 *	for PopTopDep.
 */
public class BusModelRamPopTopDepTable
	implements IBusModelPopTopDepTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffPopTopDep > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffPopTopDep >();
	private Map< BusModelBuffPopTopDepByContRelIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffPopTopDep >> dictByContRelIdx
		= new HashMap< BusModelBuffPopTopDepByContRelIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffPopTopDep >>();
	private Map< BusModelBuffPopTopDepByUNameIdxKey,
			BusModelBuffPopTopDep > dictByUNameIdx
		= new HashMap< BusModelBuffPopTopDepByUNameIdxKey,
			BusModelBuffPopTopDep >();

	public BusModelRamPopTopDepTable( IBusModelSchema argSchema ) {
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
	public IBusModelPopTopDep createPopTopDep( ISecureAuthorization Authorization,
		IBusModelPopTopDep iBuff )
	{
		final String S_ProcName = "createPopTopDep";
		
		BusModelBuffPopTopDep Buff = (BusModelBuffPopTopDep)(schema.getTablePopDep().createPopDep( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffPopTopDepByContRelIdxKey keyContRelIdx = (BusModelBuffPopTopDepByContRelIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByContRelIdxKey();
		keyContRelIdx.setRequiredContRelationId( Buff.getRequiredContRelationId() );

		BusModelBuffPopTopDepByUNameIdxKey keyUNameIdx = (BusModelBuffPopTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByUNameIdxKey();
		keyUNameIdx.setRequiredContRelationId( Buff.getRequiredContRelationId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"PopTopDepUNameIdx",
				"PopTopDepUNameIdx",
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
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ContRelation",
						"ContRelation",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopTopDep > subdictContRelIdx;
		if( dictByContRelIdx.containsKey( keyContRelIdx ) ) {
			subdictContRelIdx = dictByContRelIdx.get( keyContRelIdx );
		}
		else {
			subdictContRelIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopTopDep >();
			dictByContRelIdx.put( keyContRelIdx, subdictContRelIdx );
		}
		subdictContRelIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelPopTopDep.CLASS_CODE) {
				BusModelBuffPopTopDep retbuff = ((BusModelBuffPopTopDep)(schema.getBusModelBuffFactory().getFactoryPopTopDep().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelPopTopDep readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopTopDep.readDerived";
		IBusModelPopTopDep buff;
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
	public IBusModelPopTopDep lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopTopDep.lockDerived";
		IBusModelPopTopDep buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopTopDep[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamPopTopDep.readAllDerived";
		IBusModelPopTopDep[] retList = new IBusModelPopTopDep[ dictByPKey.values().size() ];
		Iterator< BusModelBuffPopTopDep > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelPopTopDep[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopTopDep> filteredList = new ArrayList<IBusModelPopTopDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopTopDep ) ) {
					filteredList.add( (IBusModelPopTopDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopTopDep[0] ) );
		}
	}

	@Override
	public IBusModelPopTopDep[] readDerivedByRelationIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopTopDep> filteredList = new ArrayList<IBusModelPopTopDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopTopDep ) ) {
					filteredList.add( (IBusModelPopTopDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopTopDep[0] ) );
		}
	}

	@Override
	public IBusModelPopTopDep[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelPopTopDep> filteredList = new ArrayList<IBusModelPopTopDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelPopTopDep ) ) {
					filteredList.add( (IBusModelPopTopDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelPopTopDep[0] ) );
		}
	}

	@Override
	public IBusModelPopTopDep[] readDerivedByContRelIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ContRelationId )
	{
		final String S_ProcName = "BusModelRamPopTopDep.readDerivedByContRelIdx";
		BusModelBuffPopTopDepByContRelIdxKey key = (BusModelBuffPopTopDepByContRelIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByContRelIdxKey();

		key.setRequiredContRelationId( ContRelationId );
		IBusModelPopTopDep[] recArray;
		if( dictByContRelIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffPopTopDep > subdictContRelIdx
				= dictByContRelIdx.get( key );
			recArray = new IBusModelPopTopDep[ subdictContRelIdx.size() ];
			Iterator< BusModelBuffPopTopDep > iter = subdictContRelIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffPopTopDep > subdictContRelIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopTopDep >();
			dictByContRelIdx.put( key, subdictContRelIdx );
			recArray = new IBusModelPopTopDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelPopTopDep readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ContRelationId,
		String Name )
	{
		final String S_ProcName = "BusModelRamPopTopDep.readDerivedByUNameIdx";
		BusModelBuffPopTopDepByUNameIdxKey key = (BusModelBuffPopTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByUNameIdxKey();

		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		IBusModelPopTopDep buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopTopDep readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelPopTopDep buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopTopDep readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamPopTopDep.readRec";
		IBusModelPopTopDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelPopTopDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopTopDep lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelPopTopDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelPopTopDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelPopTopDep[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamPopTopDep.readAllRec";
		IBusModelPopTopDep buff;
		ArrayList<IBusModelPopTopDep> filteredList = new ArrayList<IBusModelPopTopDep>();
		IBusModelPopTopDep[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopTopDep.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopTopDep[0] ) );
	}

	@Override
	public IBusModelPopTopDep readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelPopTopDep buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelPopTopDep)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelPopTopDep[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelPopTopDep buff;
		ArrayList<IBusModelPopTopDep> filteredList = new ArrayList<IBusModelPopTopDep>();
		IBusModelPopTopDep[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopTopDep[0] ) );
	}

	@Override
	public IBusModelPopTopDep[] readRecByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamPopDep.readRecByRelationIdx() ";
		IBusModelPopTopDep buff;
		ArrayList<IBusModelPopTopDep> filteredList = new ArrayList<IBusModelPopTopDep>();
		IBusModelPopTopDep[] buffList = readDerivedByRelationIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopTopDep[0] ) );
	}

	@Override
	public IBusModelPopTopDep[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamPopDep.readRecByDefSchemaIdx() ";
		IBusModelPopTopDep buff;
		ArrayList<IBusModelPopTopDep> filteredList = new ArrayList<IBusModelPopTopDep>();
		IBusModelPopTopDep[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopTopDep[0] ) );
	}

	@Override
	public IBusModelPopTopDep[] readRecByContRelIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ContRelationId )
	{
		final String S_ProcName = "BusModelRamPopTopDep.readRecByContRelIdx() ";
		IBusModelPopTopDep buff;
		ArrayList<IBusModelPopTopDep> filteredList = new ArrayList<IBusModelPopTopDep>();
		IBusModelPopTopDep[] buffList = readDerivedByContRelIdx( Authorization,
			ContRelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopTopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelPopTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelPopTopDep[0] ) );
	}

	@Override
	public IBusModelPopTopDep readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ContRelationId,
		String Name )
	{
		final String S_ProcName = "BusModelRamPopTopDep.readRecByUNameIdx() ";
		IBusModelPopTopDep buff = readDerivedByUNameIdx( Authorization,
			ContRelationId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelPopTopDep.CLASS_CODE ) ) {
			return( (IBusModelPopTopDep)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelPopTopDep updatePopTopDep( ISecureAuthorization Authorization,
		IBusModelPopTopDep iBuff )
	{
		BusModelBuffPopTopDep Buff = (BusModelBuffPopTopDep)(schema.getTablePopDep().updatePopDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffPopTopDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updatePopTopDep",
				"Existing record not found",
				"Existing record not found",
				"PopTopDep",
				"PopTopDep",
				pkey );
		}
		BusModelBuffPopTopDepByContRelIdxKey existingKeyContRelIdx = (BusModelBuffPopTopDepByContRelIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByContRelIdxKey();
		existingKeyContRelIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );

		BusModelBuffPopTopDepByContRelIdxKey newKeyContRelIdx = (BusModelBuffPopTopDepByContRelIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByContRelIdxKey();
		newKeyContRelIdx.setRequiredContRelationId( Buff.getRequiredContRelationId() );

		BusModelBuffPopTopDepByUNameIdxKey existingKeyUNameIdx = (BusModelBuffPopTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffPopTopDepByUNameIdxKey newKeyUNameIdx = (BusModelBuffPopTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredContRelationId( Buff.getRequiredContRelationId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updatePopTopDep",
					"PopTopDepUNameIdx",
					"PopTopDepUNameIdx",
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
						"updatePopTopDep",
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
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredContRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updatePopTopDep",
						"Container",
						"Container",
						"ContRelation",
						"ContRelation",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopTopDep > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByContRelIdx.get( existingKeyContRelIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByContRelIdx.containsKey( newKeyContRelIdx ) ) {
			subdict = dictByContRelIdx.get( newKeyContRelIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffPopTopDep >();
			dictByContRelIdx.put( newKeyContRelIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deletePopTopDep( ISecureAuthorization Authorization,
		IBusModelPopTopDep iBuff )
	{
		final String S_ProcName = "BusModelRamPopTopDepTable.deletePopTopDep() ";
		BusModelBuffPopTopDep Buff = (BusModelBuffPopTopDep)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffPopTopDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deletePopTopDep",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckPopDep[] = schema.getTablePopSubDep1().readDerivedByPopTopDepIdx( Authorization,
						existing.getRequiredId() );
		if( arrCheckPopDep.length > 0 ) {
			schema.getTablePopSubDep1().deletePopSubDep1ByPopTopDepIdx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffPopTopDepByContRelIdxKey keyContRelIdx = (BusModelBuffPopTopDepByContRelIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByContRelIdxKey();
		keyContRelIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );

		BusModelBuffPopTopDepByUNameIdxKey keyUNameIdx = (BusModelBuffPopTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByUNameIdxKey();
		keyUNameIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffPopTopDep > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByContRelIdx.get( keyContRelIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		schema.getTablePopDep().deletePopDep( Authorization,
			Buff );
	}
	@Override
	public void deletePopTopDepByContRelIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argContRelationId )
	{
		BusModelBuffPopTopDepByContRelIdxKey key = (BusModelBuffPopTopDepByContRelIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByContRelIdxKey();
		key.setRequiredContRelationId( argContRelationId );
		deletePopTopDepByContRelIdx( Authorization, key );
	}

	@Override
	public void deletePopTopDepByContRelIdx( ISecureAuthorization Authorization,
		IBusModelPopTopDepByContRelIdxKey argKey )
	{
		BusModelBuffPopTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopTopDep> matchSet = new LinkedList<BusModelBuffPopTopDep>();
		Iterator<BusModelBuffPopTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopTopDep)(schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopTopDep( Authorization, cur );
		}
	}

	@Override
	public void deletePopTopDepByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argContRelationId,
		String argName )
	{
		BusModelBuffPopTopDepByUNameIdxKey key = (BusModelBuffPopTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryPopTopDep().newByUNameIdxKey();
		key.setRequiredContRelationId( argContRelationId );
		key.setRequiredName( argName );
		deletePopTopDepByUNameIdx( Authorization, key );
	}

	@Override
	public void deletePopTopDepByUNameIdx( ISecureAuthorization Authorization,
		IBusModelPopTopDepByUNameIdxKey argKey )
	{
		BusModelBuffPopTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopTopDep> matchSet = new LinkedList<BusModelBuffPopTopDep>();
		Iterator<BusModelBuffPopTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopTopDep)(schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopTopDep( Authorization, cur );
		}
	}

	@Override
	public void deletePopTopDepByRelationIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffPopDepByRelationIdxKey key = (BusModelBuffPopDepByRelationIdxKey)schema.getBusModelBuffFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( argRelationId );
		deletePopTopDepByRelationIdx( Authorization, key );
	}

	@Override
	public void deletePopTopDepByRelationIdx( ISecureAuthorization Authorization,
		IBusModelPopDepByRelationIdxKey argKey )
	{
		BusModelBuffPopTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopTopDep> matchSet = new LinkedList<BusModelBuffPopTopDep>();
		Iterator<BusModelBuffPopTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopTopDep)(schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopTopDep( Authorization, cur );
		}
	}

	@Override
	public void deletePopTopDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffPopDepByDefSchemaIdxKey key = (BusModelBuffPopDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deletePopTopDepByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deletePopTopDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelPopDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffPopTopDep cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopTopDep> matchSet = new LinkedList<BusModelBuffPopTopDep>();
		Iterator<BusModelBuffPopTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopTopDep)(schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopTopDep( Authorization, cur );
		}
	}

	@Override
	public void deletePopTopDepByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffPopTopDep cur;
		LinkedList<BusModelBuffPopTopDep> matchSet = new LinkedList<BusModelBuffPopTopDep>();
		Iterator<BusModelBuffPopTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopTopDep)(schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopTopDep( Authorization, cur );
		}
	}

	@Override
	public void deletePopTopDepByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deletePopTopDepByTenantIdx( Authorization, key );
	}

	@Override
	public void deletePopTopDepByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffPopTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffPopTopDep> matchSet = new LinkedList<BusModelBuffPopTopDep>();
		Iterator<BusModelBuffPopTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffPopTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffPopTopDep)(schema.getTablePopTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deletePopTopDep( Authorization, cur );
		}
	}
}
