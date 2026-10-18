
// Description: Java 25 in-memory RAM DbIO implementation for Scope.

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
 *	BusModelRamScopeTable in-memory RAM DbIO implementation
 *	for Scope.
 */
public class BusModelRamScopeTable
	implements IBusModelScopeTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffScope > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffScope >();
	private Map< BusModelBuffScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffScope >> dictByTenantIdx
		= new HashMap< BusModelBuffScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffScope >>();

	public BusModelRamScopeTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffScope ensureRec(IBusModelScope rec) {
		return (((BusModelBuffScopeFactoryService)(schema.getBusModelBuffFactory().getFactoryScope())).ensureRec(rec));
	}

	@Override
	public IBusModelScope createScope( ISecureAuthorization Authorization,
		IBusModelScope iBuff )
	{
		final String S_ProcName = "createScope";
		
		BusModelBuffScope Buff = (BusModelBuffScope)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextScopeIdGen();
		Buff.setRequiredId( pkey );
		BusModelBuffScopeByTenantIdxKey keyTenantIdx = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Owner",
						"Owner",
						"Tenant",
						"Tenant",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffScope > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffScope >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelScope.CLASS_CODE) {
				BusModelBuffScope retbuff = ((BusModelBuffScope)(schema.getBusModelBuffFactory().getFactoryScope().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelSchemaDef.CLASS_CODE) {
				BusModelBuffSchemaDef retbuff = ((BusModelBuffSchemaDef)(schema.getBusModelBuffFactory().getFactorySchemaDef().newRec()));
				retbuff.set((IBusModelSchemaDef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelSchemaRef.CLASS_CODE) {
				BusModelBuffSchemaRef retbuff = ((BusModelBuffSchemaRef)(schema.getBusModelBuffFactory().getFactorySchemaRef().newRec()));
				retbuff.set((IBusModelSchemaRef)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelServerMethod.CLASS_CODE) {
				BusModelBuffServerMethod retbuff = ((BusModelBuffServerMethod)(schema.getBusModelBuffFactory().getFactoryServerMethod().newRec()));
				retbuff.set((IBusModelServerMethod)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelServerObjFunc.CLASS_CODE) {
				BusModelBuffServerObjFunc retbuff = ((BusModelBuffServerObjFunc)(schema.getBusModelBuffFactory().getFactoryServerObjFunc().newRec()));
				retbuff.set((IBusModelServerObjFunc)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelServerProc.CLASS_CODE) {
				BusModelBuffServerProc retbuff = ((BusModelBuffServerProc)(schema.getBusModelBuffFactory().getFactoryServerProc().newRec()));
				retbuff.set((IBusModelServerProc)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelServerListFunc.CLASS_CODE) {
				BusModelBuffServerListFunc retbuff = ((BusModelBuffServerListFunc)(schema.getBusModelBuffFactory().getFactoryServerListFunc().newRec()));
				retbuff.set((IBusModelServerListFunc)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelTable.CLASS_CODE) {
				BusModelBuffTable retbuff = ((BusModelBuffTable)(schema.getBusModelBuffFactory().getFactoryTable().newRec()));
				retbuff.set((IBusModelTable)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelClearDep.CLASS_CODE) {
				BusModelBuffClearDep retbuff = ((BusModelBuffClearDep)(schema.getBusModelBuffFactory().getFactoryClearDep().newRec()));
				retbuff.set((IBusModelClearDep)Buff);
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
			else if (classCode == IBusModelDelDep.CLASS_CODE) {
				BusModelBuffDelDep retbuff = ((BusModelBuffDelDep)(schema.getBusModelBuffFactory().getFactoryDelDep().newRec()));
				retbuff.set((IBusModelDelDep)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDelSubDep1.CLASS_CODE) {
				BusModelBuffDelSubDep1 retbuff = ((BusModelBuffDelSubDep1)(schema.getBusModelBuffFactory().getFactoryDelSubDep1().newRec()));
				retbuff.set((IBusModelDelSubDep1)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDelSubDep2.CLASS_CODE) {
				BusModelBuffDelSubDep2 retbuff = ((BusModelBuffDelSubDep2)(schema.getBusModelBuffFactory().getFactoryDelSubDep2().newRec()));
				retbuff.set((IBusModelDelSubDep2)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDelSubDep3.CLASS_CODE) {
				BusModelBuffDelSubDep3 retbuff = ((BusModelBuffDelSubDep3)(schema.getBusModelBuffFactory().getFactoryDelSubDep3().newRec()));
				retbuff.set((IBusModelDelSubDep3)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelDelTopDep.CLASS_CODE) {
				BusModelBuffDelTopDep retbuff = ((BusModelBuffDelTopDep)(schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec()));
				retbuff.set((IBusModelDelTopDep)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelIndex.CLASS_CODE) {
				BusModelBuffIndex retbuff = ((BusModelBuffIndex)(schema.getBusModelBuffFactory().getFactoryIndex().newRec()));
				retbuff.set((IBusModelIndex)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelPopDep.CLASS_CODE) {
				BusModelBuffPopDep retbuff = ((BusModelBuffPopDep)(schema.getBusModelBuffFactory().getFactoryPopDep().newRec()));
				retbuff.set((IBusModelPopDep)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelPopSubDep1.CLASS_CODE) {
				BusModelBuffPopSubDep1 retbuff = ((BusModelBuffPopSubDep1)(schema.getBusModelBuffFactory().getFactoryPopSubDep1().newRec()));
				retbuff.set((IBusModelPopSubDep1)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelPopSubDep2.CLASS_CODE) {
				BusModelBuffPopSubDep2 retbuff = ((BusModelBuffPopSubDep2)(schema.getBusModelBuffFactory().getFactoryPopSubDep2().newRec()));
				retbuff.set((IBusModelPopSubDep2)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelPopSubDep3.CLASS_CODE) {
				BusModelBuffPopSubDep3 retbuff = ((BusModelBuffPopSubDep3)(schema.getBusModelBuffFactory().getFactoryPopSubDep3().newRec()));
				retbuff.set((IBusModelPopSubDep3)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelPopTopDep.CLASS_CODE) {
				BusModelBuffPopTopDep retbuff = ((BusModelBuffPopTopDep)(schema.getBusModelBuffFactory().getFactoryPopTopDep().newRec()));
				retbuff.set((IBusModelPopTopDep)Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelRelation.CLASS_CODE) {
				BusModelBuffRelation retbuff = ((BusModelBuffRelation)(schema.getBusModelBuffFactory().getFactoryRelation().newRec()));
				retbuff.set((IBusModelRelation)Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelScope readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamScope.readDerived";
		IBusModelScope buff;
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
	public IBusModelScope lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamScope.lockDerived";
		IBusModelScope buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelScope[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamScope.readAllDerived";
		IBusModelScope[] retList = new IBusModelScope[ dictByPKey.values().size() ];
		Iterator< BusModelBuffScope > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelScope[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByTenantIdx";
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();

		key.setRequiredTenantId( TenantId );
		IBusModelScope[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffScope > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new IBusModelScope[ subdictTenantIdx.size() ];
			Iterator< BusModelBuffScope > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffScope > subdictTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffScope >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new IBusModelScope[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelScope readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelScope buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelScope readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamScope.readRec";
		IBusModelScope buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelScope.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelScope lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelScope buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelScope.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelScope[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamScope.readAllRec";
		IBusModelScope buff;
		ArrayList<IBusModelScope> filteredList = new ArrayList<IBusModelScope>();
		IBusModelScope[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelScope[0] ) );
	}

	@Override
	public IBusModelScope readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelScope buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelScope)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelScope[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelScope buff;
		ArrayList<IBusModelScope> filteredList = new ArrayList<IBusModelScope>();
		IBusModelScope[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelScope)buff );
			}
		}
		return( filteredList.toArray( new IBusModelScope[0] ) );
	}

	public IBusModelScope updateScope( ISecureAuthorization Authorization,
		IBusModelScope iBuff )
	{
		BusModelBuffScope Buff = (BusModelBuffScope)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffScope existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateScope",
				"Existing record not found",
				"Existing record not found",
				"Scope",
				"Scope",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateScope",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		BusModelBuffScopeByTenantIdxKey existingKeyTenantIdx = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		BusModelBuffScopeByTenantIdxKey newKeyTenantIdx = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateScope",
						"Owner",
						"Owner",
						"Tenant",
						"Tenant",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffScope > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTenantIdx.get( existingKeyTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTenantIdx.containsKey( newKeyTenantIdx ) ) {
			subdict = dictByTenantIdx.get( newKeyTenantIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffScope >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteScope( ISecureAuthorization Authorization,
		IBusModelScope iBuff )
	{
		final String S_ProcName = "BusModelRamScopeTable.deleteScope() ";
		BusModelBuffScope Buff = (BusModelBuffScope)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffScope existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteScope",
				pkey );
		}
		BusModelBuffScopeByTenantIdxKey keyTenantIdx = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		// Validate reverse foreign keys

		if( schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"SchemaDef",
				"SchemaDef",
				pkey );
		}

		if( schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"SchemaRef",
				"SchemaRef",
				pkey );
		}

		if( schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"ServerMethod",
				"ServerMethod",
				pkey );
		}

		if( schema.getTableTable().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"Table",
				"Table",
				pkey );
		}

		if( schema.getTableClearDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"ClearDep",
				"ClearDep",
				pkey );
		}

		if( schema.getTableDelDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DelDep",
				"DelDep",
				pkey );
		}

		if( schema.getTableIndex().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"Index",
				"Index",
				pkey );
		}

		if( schema.getTablePopDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"PopDep",
				"PopDep",
				pkey );
		}

		if( schema.getTableRelation().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteScope",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"Relation",
				"Relation",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffScope > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteScopeByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteScopeByIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffScope cur;
		LinkedList<BusModelBuffScope> matchSet = new LinkedList<BusModelBuffScope>();
		Iterator<BusModelBuffScope> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffScope> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffScope)(schema.getTableScope().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelScope.CLASS_CODE == subClassCode ) {
				schema.getTableScope().deleteScope( Authorization, cur );
			}
			else if( IBusModelSchemaDef.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaDef().deleteSchemaDef( Authorization, (IBusModelSchemaDef)cur );
			}
			else if( IBusModelSchemaRef.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaRef().deleteSchemaRef( Authorization, (IBusModelSchemaRef)cur );
			}
			else if( IBusModelServerMethod.CLASS_CODE == subClassCode ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, (IBusModelServerMethod)cur );
			}
			else if( IBusModelServerObjFunc.CLASS_CODE == subClassCode ) {
				schema.getTableServerObjFunc().deleteServerObjFunc( Authorization, (IBusModelServerObjFunc)cur );
			}
			else if( IBusModelServerProc.CLASS_CODE == subClassCode ) {
				schema.getTableServerProc().deleteServerProc( Authorization, (IBusModelServerProc)cur );
			}
			else if( IBusModelServerListFunc.CLASS_CODE == subClassCode ) {
				schema.getTableServerListFunc().deleteServerListFunc( Authorization, (IBusModelServerListFunc)cur );
			}
			else if( IBusModelTable.CLASS_CODE == subClassCode ) {
				schema.getTableTable().deleteTable( Authorization, (IBusModelTable)cur );
			}
			else if( IBusModelClearDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearDep().deleteClearDep( Authorization, (IBusModelClearDep)cur );
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
			else if( IBusModelDelDep.CLASS_CODE == subClassCode ) {
				schema.getTableDelDep().deleteDelDep( Authorization, (IBusModelDelDep)cur );
			}
			else if( IBusModelDelSubDep1.CLASS_CODE == subClassCode ) {
				schema.getTableDelSubDep1().deleteDelSubDep1( Authorization, (IBusModelDelSubDep1)cur );
			}
			else if( IBusModelDelSubDep2.CLASS_CODE == subClassCode ) {
				schema.getTableDelSubDep2().deleteDelSubDep2( Authorization, (IBusModelDelSubDep2)cur );
			}
			else if( IBusModelDelSubDep3.CLASS_CODE == subClassCode ) {
				schema.getTableDelSubDep3().deleteDelSubDep3( Authorization, (IBusModelDelSubDep3)cur );
			}
			else if( IBusModelDelTopDep.CLASS_CODE == subClassCode ) {
				schema.getTableDelTopDep().deleteDelTopDep( Authorization, (IBusModelDelTopDep)cur );
			}
			else if( IBusModelIndex.CLASS_CODE == subClassCode ) {
				schema.getTableIndex().deleteIndex( Authorization, (IBusModelIndex)cur );
			}
			else if( IBusModelPopDep.CLASS_CODE == subClassCode ) {
				schema.getTablePopDep().deletePopDep( Authorization, (IBusModelPopDep)cur );
			}
			else if( IBusModelPopSubDep1.CLASS_CODE == subClassCode ) {
				schema.getTablePopSubDep1().deletePopSubDep1( Authorization, (IBusModelPopSubDep1)cur );
			}
			else if( IBusModelPopSubDep2.CLASS_CODE == subClassCode ) {
				schema.getTablePopSubDep2().deletePopSubDep2( Authorization, (IBusModelPopSubDep2)cur );
			}
			else if( IBusModelPopSubDep3.CLASS_CODE == subClassCode ) {
				schema.getTablePopSubDep3().deletePopSubDep3( Authorization, (IBusModelPopSubDep3)cur );
			}
			else if( IBusModelPopTopDep.CLASS_CODE == subClassCode ) {
				schema.getTablePopTopDep().deletePopTopDep( Authorization, (IBusModelPopTopDep)cur );
			}
			else if( IBusModelRelation.CLASS_CODE == subClassCode ) {
				schema.getTableRelation().deleteRelation( Authorization, (IBusModelRelation)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteScopeByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteScopeByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteScopeByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteScopeByTenantIdx";
		BusModelBuffScope cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffScope> matchSet = new LinkedList<BusModelBuffScope>();
		Iterator<BusModelBuffScope> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffScope> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffScope)(schema.getTableScope().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelScope.CLASS_CODE == subClassCode ) {
				schema.getTableScope().deleteScope( Authorization, cur );
			}
			else if( IBusModelSchemaDef.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaDef().deleteSchemaDef( Authorization, (IBusModelSchemaDef)cur );
			}
			else if( IBusModelSchemaRef.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaRef().deleteSchemaRef( Authorization, (IBusModelSchemaRef)cur );
			}
			else if( IBusModelServerMethod.CLASS_CODE == subClassCode ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, (IBusModelServerMethod)cur );
			}
			else if( IBusModelServerObjFunc.CLASS_CODE == subClassCode ) {
				schema.getTableServerObjFunc().deleteServerObjFunc( Authorization, (IBusModelServerObjFunc)cur );
			}
			else if( IBusModelServerProc.CLASS_CODE == subClassCode ) {
				schema.getTableServerProc().deleteServerProc( Authorization, (IBusModelServerProc)cur );
			}
			else if( IBusModelServerListFunc.CLASS_CODE == subClassCode ) {
				schema.getTableServerListFunc().deleteServerListFunc( Authorization, (IBusModelServerListFunc)cur );
			}
			else if( IBusModelTable.CLASS_CODE == subClassCode ) {
				schema.getTableTable().deleteTable( Authorization, (IBusModelTable)cur );
			}
			else if( IBusModelClearDep.CLASS_CODE == subClassCode ) {
				schema.getTableClearDep().deleteClearDep( Authorization, (IBusModelClearDep)cur );
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
			else if( IBusModelDelDep.CLASS_CODE == subClassCode ) {
				schema.getTableDelDep().deleteDelDep( Authorization, (IBusModelDelDep)cur );
			}
			else if( IBusModelDelSubDep1.CLASS_CODE == subClassCode ) {
				schema.getTableDelSubDep1().deleteDelSubDep1( Authorization, (IBusModelDelSubDep1)cur );
			}
			else if( IBusModelDelSubDep2.CLASS_CODE == subClassCode ) {
				schema.getTableDelSubDep2().deleteDelSubDep2( Authorization, (IBusModelDelSubDep2)cur );
			}
			else if( IBusModelDelSubDep3.CLASS_CODE == subClassCode ) {
				schema.getTableDelSubDep3().deleteDelSubDep3( Authorization, (IBusModelDelSubDep3)cur );
			}
			else if( IBusModelDelTopDep.CLASS_CODE == subClassCode ) {
				schema.getTableDelTopDep().deleteDelTopDep( Authorization, (IBusModelDelTopDep)cur );
			}
			else if( IBusModelIndex.CLASS_CODE == subClassCode ) {
				schema.getTableIndex().deleteIndex( Authorization, (IBusModelIndex)cur );
			}
			else if( IBusModelPopDep.CLASS_CODE == subClassCode ) {
				schema.getTablePopDep().deletePopDep( Authorization, (IBusModelPopDep)cur );
			}
			else if( IBusModelPopSubDep1.CLASS_CODE == subClassCode ) {
				schema.getTablePopSubDep1().deletePopSubDep1( Authorization, (IBusModelPopSubDep1)cur );
			}
			else if( IBusModelPopSubDep2.CLASS_CODE == subClassCode ) {
				schema.getTablePopSubDep2().deletePopSubDep2( Authorization, (IBusModelPopSubDep2)cur );
			}
			else if( IBusModelPopSubDep3.CLASS_CODE == subClassCode ) {
				schema.getTablePopSubDep3().deletePopSubDep3( Authorization, (IBusModelPopSubDep3)cur );
			}
			else if( IBusModelPopTopDep.CLASS_CODE == subClassCode ) {
				schema.getTablePopTopDep().deletePopTopDep( Authorization, (IBusModelPopTopDep)cur );
			}
			else if( IBusModelRelation.CLASS_CODE == subClassCode ) {
				schema.getTableRelation().deleteRelation( Authorization, (IBusModelRelation)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}
}
