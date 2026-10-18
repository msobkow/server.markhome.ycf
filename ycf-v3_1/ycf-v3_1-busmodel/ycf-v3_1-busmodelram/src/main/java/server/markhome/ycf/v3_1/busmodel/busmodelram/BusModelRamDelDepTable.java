
// Description: Java 25 in-memory RAM DbIO implementation for DelDep.

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
 *	BusModelRamDelDepTable in-memory RAM DbIO implementation
 *	for DelDep.
 */
public class BusModelRamDelDepTable
	implements IBusModelDelDepTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffDelDep > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffDelDep >();
	private Map< BusModelBuffDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelDep >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelDep >>();
	private Map< BusModelBuffDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelDep >> dictByDelDepIdx
		= new HashMap< BusModelBuffDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelDep >>();

	public BusModelRamDelDepTable( IBusModelSchema argSchema ) {
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
	public IBusModelDelDep createDelDep( ISecureAuthorization Authorization,
		IBusModelDelDep iBuff )
	{
		final String S_ProcName = "createDelDep";
		
		BusModelBuffDelDep Buff = (BusModelBuffDelDep)(schema.getTableScope().createScope( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDelDepByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffDelDepByDelDepIdxKey keyDelDepIdx = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();
		keyDelDepIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelDep > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelDep >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelDep > subdictDelDepIdx;
		if( dictByDelDepIdx.containsKey( keyDelDepIdx ) ) {
			subdictDelDepIdx = dictByDelDepIdx.get( keyDelDepIdx );
		}
		else {
			subdictDelDepIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelDep >();
			dictByDelDepIdx.put( keyDelDepIdx, subdictDelDepIdx );
		}
		subdictDelDepIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelDelDep.CLASS_CODE) {
				BusModelBuffDelDep retbuff = ((BusModelBuffDelDep)(schema.getBusModelBuffFactory().getFactoryDelDep().newRec()));
				retbuff.set(Buff);
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelDelDep readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelDep.readDerived";
		IBusModelDelDep buff;
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
	public IBusModelDelDep lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelDep.lockDerived";
		IBusModelDelDep buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelDep[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamDelDep.readAllDerived";
		IBusModelDelDep[] retList = new IBusModelDelDep[ dictByPKey.values().size() ];
		Iterator< BusModelBuffDelDep > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelDelDep[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDelDep> filteredList = new ArrayList<IBusModelDelDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelDep ) ) {
					filteredList.add( (IBusModelDelDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelDep[0] ) );
		}
	}

	@Override
	public IBusModelDelDep[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamDelDep.readDerivedByDefSchemaIdx";
		BusModelBuffDelDepByDefSchemaIdxKey key = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelDelDep[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelDep > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelDelDep[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffDelDep > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelDep > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelDep >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelDelDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelDelDep[] readDerivedByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamDelDep.readDerivedByDelDepIdx";
		BusModelBuffDelDepByDelDepIdxKey key = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();

		key.setRequiredRelationId( RelationId );
		IBusModelDelDep[] recArray;
		if( dictByDelDepIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelDep > subdictDelDepIdx
				= dictByDelDepIdx.get( key );
			recArray = new IBusModelDelDep[ subdictDelDepIdx.size() ];
			Iterator< BusModelBuffDelDep > iter = subdictDelDepIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelDep > subdictDelDepIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelDep >();
			dictByDelDepIdx.put( key, subdictDelDepIdx );
			recArray = new IBusModelDelDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelDelDep readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelDelDep buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelDep readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelDep.readRec";
		IBusModelDelDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelDep lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelDelDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelDep[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamDelDep.readAllRec";
		IBusModelDelDep buff;
		ArrayList<IBusModelDelDep> filteredList = new ArrayList<IBusModelDelDep>();
		IBusModelDelDep[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelDep[0] ) );
	}

	@Override
	public IBusModelDelDep readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelDelDep buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelDelDep)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelDelDep[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelDelDep buff;
		ArrayList<IBusModelDelDep> filteredList = new ArrayList<IBusModelDelDep>();
		IBusModelDelDep[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelDep[0] ) );
	}

	@Override
	public IBusModelDelDep[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDefSchemaIdx() ";
		IBusModelDelDep buff;
		ArrayList<IBusModelDelDep> filteredList = new ArrayList<IBusModelDelDep>();
		IBusModelDelDep[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelDep[0] ) );
	}

	@Override
	public IBusModelDelDep[] readRecByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDelDepIdx() ";
		IBusModelDelDep buff;
		ArrayList<IBusModelDelDep> filteredList = new ArrayList<IBusModelDelDep>();
		IBusModelDelDep[] buffList = readDerivedByDelDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelDep[0] ) );
	}

	public IBusModelDelDep updateDelDep( ISecureAuthorization Authorization,
		IBusModelDelDep iBuff )
	{
		BusModelBuffDelDep Buff = (BusModelBuffDelDep)(schema.getTableScope().updateScope( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDelDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateDelDep",
				"Existing record not found",
				"Existing record not found",
				"DelDep",
				"DelDep",
				pkey );
		}
		BusModelBuffDelDepByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffDelDepByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffDelDepByDelDepIdxKey existingKeyDelDepIdx = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();
		existingKeyDelDepIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		BusModelBuffDelDepByDelDepIdxKey newKeyDelDepIdx = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();
		newKeyDelDepIdx.setRequiredRelationId( Buff.getRequiredRelationId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateDelDep",
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
						"updateDelDep",
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelDep > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByDefSchemaIdx.get( existingKeyDefSchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDefSchemaIdx.containsKey( newKeyDefSchemaIdx ) ) {
			subdict = dictByDefSchemaIdx.get( newKeyDefSchemaIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelDep >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDelDepIdx.get( existingKeyDelDepIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDelDepIdx.containsKey( newKeyDelDepIdx ) ) {
			subdict = dictByDelDepIdx.get( newKeyDelDepIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelDep >();
			dictByDelDepIdx.put( newKeyDelDepIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteDelDep( ISecureAuthorization Authorization,
		IBusModelDelDep iBuff )
	{
		final String S_ProcName = "BusModelRamDelDepTable.deleteDelDep() ";
		BusModelBuffDelDep Buff = (BusModelBuffDelDep)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffDelDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteDelDep",
				pkey );
		}
		BusModelBuffDelDepByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffDelDepByDelDepIdxKey keyDelDepIdx = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();
		keyDelDepIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		// Validate reverse foreign keys

		if( schema.getTableDelSubDep1().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteDelDep",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DelSubDep1",
				"DelSubDep1",
				pkey );
		}

		if( schema.getTableDelSubDep2().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteDelDep",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DelSubDep2",
				"DelSubDep2",
				pkey );
		}

		if( schema.getTableDelSubDep3().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteDelDep",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DelSubDep3",
				"DelSubDep3",
				pkey );
		}

		if( schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteDelDep",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"DelTopDep",
				"DelTopDep",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelDep > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByDelDepIdx.get( keyDelDepIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}
	@Override
	public void deleteDelDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffDelDepByDefSchemaIdxKey key = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelDepByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteDelDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteDelDepByDefSchemaIdx";
		BusModelBuffDelDep cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelDep> matchSet = new LinkedList<BusModelBuffDelDep>();
		Iterator<BusModelBuffDelDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelDep)(schema.getTableDelDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDelDep.CLASS_CODE == subClassCode ) {
				schema.getTableDelDep().deleteDelDep( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDelDepByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffDelDepByDelDepIdxKey key = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteDelDepByDelDepIdx( Authorization, key );
	}

	@Override
	public void deleteDelDepByDelDepIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDelDepIdxKey argKey )
	{
		final String S_ProcName = "deleteDelDepByDelDepIdx";
		BusModelBuffDelDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelDep> matchSet = new LinkedList<BusModelBuffDelDep>();
		Iterator<BusModelBuffDelDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelDep)(schema.getTableDelDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDelDep.CLASS_CODE == subClassCode ) {
				schema.getTableDelDep().deleteDelDep( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDelDepByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteDelDepByIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffDelDep cur;
		LinkedList<BusModelBuffDelDep> matchSet = new LinkedList<BusModelBuffDelDep>();
		Iterator<BusModelBuffDelDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelDep)(schema.getTableDelDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDelDep.CLASS_CODE == subClassCode ) {
				schema.getTableDelDep().deleteDelDep( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteDelDepByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelDepByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteDelDepByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteDelDepByTenantIdx";
		BusModelBuffDelDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelDep> matchSet = new LinkedList<BusModelBuffDelDep>();
		Iterator<BusModelBuffDelDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelDep)(schema.getTableDelDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelDelDep.CLASS_CODE == subClassCode ) {
				schema.getTableDelDep().deleteDelDep( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}
}
