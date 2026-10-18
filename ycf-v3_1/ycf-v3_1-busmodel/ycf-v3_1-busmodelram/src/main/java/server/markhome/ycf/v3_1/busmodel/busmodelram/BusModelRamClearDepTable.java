
// Description: Java 25 in-memory RAM DbIO implementation for ClearDep.

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
 *	BusModelRamClearDepTable in-memory RAM DbIO implementation
 *	for ClearDep.
 */
public class BusModelRamClearDepTable
	implements IBusModelClearDepTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffClearDep > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffClearDep >();
	private Map< BusModelBuffClearDepByClearDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearDep >> dictByClearDepIdx
		= new HashMap< BusModelBuffClearDepByClearDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearDep >>();
	private Map< BusModelBuffClearDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearDep >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffClearDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearDep >>();

	public BusModelRamClearDepTable( IBusModelSchema argSchema ) {
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
	public IBusModelClearDep createClearDep( ISecureAuthorization Authorization,
		IBusModelClearDep iBuff )
	{
		final String S_ProcName = "createClearDep";
		
		BusModelBuffClearDep Buff = (BusModelBuffClearDep)(schema.getTableScope().createScope( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearDepByClearDepIdxKey keyClearDepIdx = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();
		keyClearDepIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		BusModelBuffClearDepByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"Relation",
						"Relation",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearDep > subdictClearDepIdx;
		if( dictByClearDepIdx.containsKey( keyClearDepIdx ) ) {
			subdictClearDepIdx = dictByClearDepIdx.get( keyClearDepIdx );
		}
		else {
			subdictClearDepIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearDep >();
			dictByClearDepIdx.put( keyClearDepIdx, subdictClearDepIdx );
		}
		subdictClearDepIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearDep > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearDep >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelClearDep.CLASS_CODE) {
				BusModelBuffClearDep retbuff = ((BusModelBuffClearDep)(schema.getBusModelBuffFactory().getFactoryClearDep().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelClearSubDep1.CLASS_CODE) {
				BusModelBuffClearSubDep1 retbuff = ((BusModelBuffClearSubDep1)(schema.getBusModelBuffFactory().getFactoryClearSubDep1().newRec()));
				retbuff.set((IBusModelClearSubDep1)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelClearSubDep2.CLASS_CODE) {
				BusModelBuffClearSubDep2 retbuff = ((BusModelBuffClearSubDep2)(schema.getBusModelBuffFactory().getFactoryClearSubDep2().newRec()));
				retbuff.set((IBusModelClearSubDep2)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelClearSubDep3.CLASS_CODE) {
				BusModelBuffClearSubDep3 retbuff = ((BusModelBuffClearSubDep3)(schema.getBusModelBuffFactory().getFactoryClearSubDep3().newRec()));
				retbuff.set((IBusModelClearSubDep3)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelClearTopDep.CLASS_CODE) {
				BusModelBuffClearTopDep retbuff = ((BusModelBuffClearTopDep)(schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec()));
				retbuff.set((IBusModelClearTopDep)Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelClearDep readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearDep.readDerived";
		IBusModelClearDep buff;
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
	public IBusModelClearDep lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearDep.lockDerived";
		IBusModelClearDep buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearDep[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamClearDep.readAllDerived";
		IBusModelClearDep[] retList = new IBusModelClearDep[ dictByPKey.values().size() ];
		Iterator< BusModelBuffClearDep > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelClearDep[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelClearDep> filteredList = new ArrayList<IBusModelClearDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearDep ) ) {
					filteredList.add( (IBusModelClearDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearDep[0] ) );
		}
	}

	@Override
	public IBusModelClearDep[] readDerivedByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamClearDep.readDerivedByClearDepIdx";
		BusModelBuffClearDepByClearDepIdxKey key = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();

		key.setRequiredRelationId( RelationId );
		IBusModelClearDep[] recArray;
		if( dictByClearDepIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearDep > subdictClearDepIdx
				= dictByClearDepIdx.get( key );
			recArray = new IBusModelClearDep[ subdictClearDepIdx.size() ];
			Iterator< BusModelBuffClearDep > iter = subdictClearDepIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearDep > subdictClearDepIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearDep >();
			dictByClearDepIdx.put( key, subdictClearDepIdx );
			recArray = new IBusModelClearDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelClearDep[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamClearDep.readDerivedByDefSchemaIdx";
		BusModelBuffClearDepByDefSchemaIdxKey key = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelClearDep[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearDep > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelClearDep[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffClearDep > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearDep > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearDep >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelClearDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelClearDep readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelClearDep buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearDep readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearDep.readRec";
		IBusModelClearDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearDep lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelClearDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearDep[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamClearDep.readAllRec";
		IBusModelClearDep buff;
		ArrayList<IBusModelClearDep> filteredList = new ArrayList<IBusModelClearDep>();
		IBusModelClearDep[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearDep[0] ) );
	}

	@Override
	public IBusModelClearDep readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelClearDep buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelClearDep)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelClearDep[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelClearDep buff;
		ArrayList<IBusModelClearDep> filteredList = new ArrayList<IBusModelClearDep>();
		IBusModelClearDep[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearDep[0] ) );
	}

	@Override
	public IBusModelClearDep[] readRecByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByClearDepIdx() ";
		IBusModelClearDep buff;
		ArrayList<IBusModelClearDep> filteredList = new ArrayList<IBusModelClearDep>();
		IBusModelClearDep[] buffList = readDerivedByClearDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearDep[0] ) );
	}

	@Override
	public IBusModelClearDep[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByDefSchemaIdx() ";
		IBusModelClearDep buff;
		ArrayList<IBusModelClearDep> filteredList = new ArrayList<IBusModelClearDep>();
		IBusModelClearDep[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearDep[0] ) );
	}

	public IBusModelClearDep updateClearDep( ISecureAuthorization Authorization,
		IBusModelClearDep iBuff )
	{
		BusModelBuffClearDep Buff = (BusModelBuffClearDep)(schema.getTableScope().updateScope( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateClearDep",
				"Existing record not found",
				"Existing record not found",
				"ClearDep",
				"ClearDep",
				pkey );
		}
		BusModelBuffClearDepByClearDepIdxKey existingKeyClearDepIdx = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();
		existingKeyClearDepIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		BusModelBuffClearDepByClearDepIdxKey newKeyClearDepIdx = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();
		newKeyClearDepIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		BusModelBuffClearDepByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffClearDepByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateClearDep",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRelation().readDerivedByIdIdx( Authorization,
						Buff.getRequiredRelationId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateClearDep",
						"Lookup",
						"Lookup",
						"Relation",
						"Relation",
						"Relation",
						"Relation",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearDep > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClearDepIdx.get( existingKeyClearDepIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClearDepIdx.containsKey( newKeyClearDepIdx ) ) {
			subdict = dictByClearDepIdx.get( newKeyClearDepIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearDep >();
			dictByClearDepIdx.put( newKeyClearDepIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDefSchemaIdx.get( existingKeyDefSchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDefSchemaIdx.containsKey( newKeyDefSchemaIdx ) ) {
			subdict = dictByDefSchemaIdx.get( newKeyDefSchemaIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearDep >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteClearDep( ISecureAuthorization Authorization,
		IBusModelClearDep iBuff )
	{
		final String S_ProcName = "BusModelRamClearDepTable.deleteClearDep() ";
		BusModelBuffClearDep Buff = (BusModelBuffClearDep)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffClearDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteClearDep",
				pkey );
		}
		BusModelBuffClearDepByClearDepIdxKey keyClearDepIdx = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();
		keyClearDepIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		BusModelBuffClearDepByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		// Validate reverse foreign keys

		if( schema.getTableClearSubDep1().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteClearDep",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"ClearSubDep1",
				"ClearSubDep1",
				pkey );
		}

		if( schema.getTableClearSubDep2().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteClearDep",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"ClearSubDep2",
				"ClearSubDep2",
				pkey );
		}

		if( schema.getTableClearSubDep3().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteClearDep",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"ClearSubDep3",
				"ClearSubDep3",
				pkey );
		}

		if( schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteClearDep",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"ClearTopDep",
				"ClearTopDep",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearDep > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClearDepIdx.get( keyClearDepIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}
	@Override
	public void deleteClearDepByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffClearDepByClearDepIdxKey key = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteClearDepByClearDepIdx( Authorization, key );
	}

	@Override
	public void deleteClearDepByClearDepIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByClearDepIdxKey argKey )
	{
		final String S_ProcName = "deleteClearDepByClearDepIdx";
		BusModelBuffClearDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearDep> matchSet = new LinkedList<BusModelBuffClearDep>();
		Iterator<BusModelBuffClearDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearDep)(schema.getTableClearDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelClearDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearDep().deleteClearDep( Authorization, cur );
			}
			else if( IBusModelClearSubDep1.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep1().deleteClearSubDep1( Authorization, (IBusModelClearSubDep1)cur );
			}
			else if( IBusModelClearSubDep2.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep2().deleteClearSubDep2( Authorization, (IBusModelClearSubDep2)cur );
			}
			else if( IBusModelClearSubDep3.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep3().deleteClearSubDep3( Authorization, (IBusModelClearSubDep3)cur );
			}
			else if( IBusModelClearTopDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearTopDep().deleteClearTopDep( Authorization, (IBusModelClearTopDep)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteClearDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffClearDepByDefSchemaIdxKey key = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteClearDepByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteClearDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteClearDepByDefSchemaIdx";
		BusModelBuffClearDep cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearDep> matchSet = new LinkedList<BusModelBuffClearDep>();
		Iterator<BusModelBuffClearDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearDep)(schema.getTableClearDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelClearDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearDep().deleteClearDep( Authorization, cur );
			}
			else if( IBusModelClearSubDep1.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep1().deleteClearSubDep1( Authorization, (IBusModelClearSubDep1)cur );
			}
			else if( IBusModelClearSubDep2.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep2().deleteClearSubDep2( Authorization, (IBusModelClearSubDep2)cur );
			}
			else if( IBusModelClearSubDep3.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep3().deleteClearSubDep3( Authorization, (IBusModelClearSubDep3)cur );
			}
			else if( IBusModelClearTopDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearTopDep().deleteClearTopDep( Authorization, (IBusModelClearTopDep)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteClearDepByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteClearDepByIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffClearDep cur;
		LinkedList<BusModelBuffClearDep> matchSet = new LinkedList<BusModelBuffClearDep>();
		Iterator<BusModelBuffClearDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearDep)(schema.getTableClearDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelClearDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearDep().deleteClearDep( Authorization, cur );
			}
			else if( IBusModelClearSubDep1.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep1().deleteClearSubDep1( Authorization, (IBusModelClearSubDep1)cur );
			}
			else if( IBusModelClearSubDep2.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep2().deleteClearSubDep2( Authorization, (IBusModelClearSubDep2)cur );
			}
			else if( IBusModelClearSubDep3.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep3().deleteClearSubDep3( Authorization, (IBusModelClearSubDep3)cur );
			}
			else if( IBusModelClearTopDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearTopDep().deleteClearTopDep( Authorization, (IBusModelClearTopDep)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteClearDepByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearDepByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteClearDepByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteClearDepByTenantIdx";
		BusModelBuffClearDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearDep> matchSet = new LinkedList<BusModelBuffClearDep>();
		Iterator<BusModelBuffClearDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearDep)(schema.getTableClearDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelClearDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearDep().deleteClearDep( Authorization, cur );
			}
			else if( IBusModelClearSubDep1.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep1().deleteClearSubDep1( Authorization, (IBusModelClearSubDep1)cur );
			}
			else if( IBusModelClearSubDep2.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep2().deleteClearSubDep2( Authorization, (IBusModelClearSubDep2)cur );
			}
			else if( IBusModelClearSubDep3.CLASS_CODE == subClassCode ) {
				schema.getTableClearSubDep3().deleteClearSubDep3( Authorization, (IBusModelClearSubDep3)cur );
			}
			else if( IBusModelClearTopDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearTopDep().deleteClearTopDep( Authorization, (IBusModelClearTopDep)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}
}
