
// Description: Java 25 in-memory RAM DbIO implementation for RoleDef.

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
 *	BusModelRamRoleDefTable in-memory RAM DbIO implementation
 *	for RoleDef.
 */
public class BusModelRamRoleDefTable
	implements IBusModelRoleDefTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffRoleDef > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffRoleDef >();
	private Map< BusModelBuffRoleDefByUNameIdxKey,
			BusModelBuffRoleDef > dictByUNameIdx
		= new HashMap< BusModelBuffRoleDefByUNameIdxKey,
			BusModelBuffRoleDef >();
	private Map< BusModelBuffRoleDefByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRoleDef >> dictByScopeIdx
		= new HashMap< BusModelBuffRoleDefByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRoleDef >>();
	private Map< BusModelBuffRoleDefByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRoleDef >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffRoleDefByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRoleDef >>();
	private Map< BusModelBuffRoleDefByUDefIdxKey,
			BusModelBuffRoleDef > dictByUDefIdx
		= new HashMap< BusModelBuffRoleDefByUDefIdxKey,
			BusModelBuffRoleDef >();

	public BusModelRamRoleDefTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffRoleDef ensureRec(IBusModelRoleDef rec) {
		return (((BusModelBuffRoleDefFactoryService)(schema.getBusModelBuffFactory().getFactoryRoleDef())).ensureRec(rec));
	}

	@Override
	public IBusModelRoleDef createRoleDef( ISecureAuthorization Authorization,
		IBusModelRoleDef iBuff )
	{
		final String S_ProcName = "createRoleDef";
		
		BusModelBuffRoleDef Buff = (BusModelBuffRoleDef)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextRoleIdGen();
		Buff.setRequiredId( pkey );
		BusModelBuffRoleDefByUNameIdxKey keyUNameIdx = (BusModelBuffRoleDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUNameIdxKey();
		keyUNameIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffRoleDefByScopeIdxKey keyScopeIdx = (BusModelBuffRoleDefByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByScopeIdxKey();
		keyScopeIdx.setRequiredScopeId( Buff.getRequiredScopeId() );

		BusModelBuffRoleDefByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffRoleDefByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffRoleDefByUDefIdxKey keyUDefIdx = (BusModelBuffRoleDefByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUDefIdxKey();
		keyUDefIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		keyUDefIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );
		keyUDefIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"RoleDefUNameIdx",
				"RoleDefUNameIdx",
				keyUNameIdx );
		}

		if( dictByUDefIdx.containsKey( keyUDefIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"RoleDefUDefIdx",
				"RoleDefUDefIdx",
				keyUDefIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredScopeId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"Scope",
						"Scope",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef > subdictScopeIdx;
		if( dictByScopeIdx.containsKey( keyScopeIdx ) ) {
			subdictScopeIdx = dictByScopeIdx.get( keyScopeIdx );
		}
		else {
			subdictScopeIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef >();
			dictByScopeIdx.put( keyScopeIdx, subdictScopeIdx );
		}
		subdictScopeIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		dictByUDefIdx.put( keyUDefIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelRoleDef.CLASS_CODE) {
				BusModelBuffRoleDef retbuff = ((BusModelBuffRoleDef)(schema.getBusModelBuffFactory().getFactoryRoleDef().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else if (classCode == IBusModelSchemaRole.CLASS_CODE) {
				BusModelBuffSchemaRole retbuff = ((BusModelBuffSchemaRole)(schema.getBusModelBuffFactory().getFactorySchemaRole().newRec()));
				retbuff.set((IBusModelSchemaRole)Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelRoleDef readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerived";
		IBusModelRoleDef buff;
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
	public IBusModelRoleDef lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamRoleDef.lockDerived";
		IBusModelRoleDef buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRoleDef[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamRoleDef.readAllDerived";
		IBusModelRoleDef[] retList = new IBusModelRoleDef[ dictByPKey.values().size() ];
		Iterator< BusModelBuffRoleDef > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelRoleDef readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByUNameIdx";
		BusModelBuffRoleDefByUNameIdxKey key = (BusModelBuffRoleDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUNameIdxKey();

		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelRoleDef buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRoleDef[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByScopeIdx";
		BusModelBuffRoleDefByScopeIdxKey key = (BusModelBuffRoleDefByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByScopeIdxKey();

		key.setRequiredScopeId( ScopeId );
		IBusModelRoleDef[] recArray;
		if( dictByScopeIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef > subdictScopeIdx
				= dictByScopeIdx.get( key );
			recArray = new IBusModelRoleDef[ subdictScopeIdx.size() ];
			Iterator< BusModelBuffRoleDef > iter = subdictScopeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef > subdictScopeIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef >();
			dictByScopeIdx.put( key, subdictScopeIdx );
			recArray = new IBusModelRoleDef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRoleDef[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByDefSchemaIdx";
		BusModelBuffRoleDefByDefSchemaIdxKey key = (BusModelBuffRoleDefByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelRoleDef[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelRoleDef[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffRoleDef > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelRoleDef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRoleDef readDerivedByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByUDefIdx";
		BusModelBuffRoleDefByUDefIdxKey key = (BusModelBuffRoleDefByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUDefIdxKey();

		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelRoleDef buff;
		if( dictByUDefIdx.containsKey( key ) ) {
			buff = dictByUDefIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRoleDef readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByIdIdx() ";
		IBusModelRoleDef buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRoleDef readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRec";
		IBusModelRoleDef buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelRoleDef.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRoleDef lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelRoleDef buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelRoleDef.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRoleDef[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamRoleDef.readAllRec";
		IBusModelRoleDef buff;
		ArrayList<IBusModelRoleDef> filteredList = new ArrayList<IBusModelRoleDef>();
		IBusModelRoleDef[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelRoleDef[0] ) );
	}

	@Override
	public IBusModelRoleDef readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByIdIdx() ";
		IBusModelRoleDef buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
			return( (IBusModelRoleDef)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelRoleDef readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByUNameIdx() ";
		IBusModelRoleDef buff = readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
			return( (IBusModelRoleDef)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelRoleDef[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByScopeIdx() ";
		IBusModelRoleDef buff;
		ArrayList<IBusModelRoleDef> filteredList = new ArrayList<IBusModelRoleDef>();
		IBusModelRoleDef[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRoleDef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRoleDef[0] ) );
	}

	@Override
	public IBusModelRoleDef[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByDefSchemaIdx() ";
		IBusModelRoleDef buff;
		ArrayList<IBusModelRoleDef> filteredList = new ArrayList<IBusModelRoleDef>();
		IBusModelRoleDef[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRoleDef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRoleDef[0] ) );
	}

	@Override
	public IBusModelRoleDef readRecByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByUDefIdx() ";
		IBusModelRoleDef buff = readDerivedByUDefIdx( Authorization,
			ScopeId,
			DefSchemaId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
			return( (IBusModelRoleDef)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelRoleDef updateRoleDef( ISecureAuthorization Authorization,
		IBusModelRoleDef iBuff )
	{
		BusModelBuffRoleDef Buff = (BusModelBuffRoleDef)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffRoleDef existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateRoleDef",
				"Existing record not found",
				"Existing record not found",
				"RoleDef",
				"RoleDef",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateRoleDef",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		BusModelBuffRoleDefByUNameIdxKey existingKeyUNameIdx = (BusModelBuffRoleDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffRoleDefByUNameIdxKey newKeyUNameIdx = (BusModelBuffRoleDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffRoleDefByScopeIdxKey existingKeyScopeIdx = (BusModelBuffRoleDefByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByScopeIdxKey();
		existingKeyScopeIdx.setRequiredScopeId( existing.getRequiredScopeId() );

		BusModelBuffRoleDefByScopeIdxKey newKeyScopeIdx = (BusModelBuffRoleDefByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByScopeIdxKey();
		newKeyScopeIdx.setRequiredScopeId( Buff.getRequiredScopeId() );

		BusModelBuffRoleDefByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffRoleDefByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffRoleDefByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffRoleDefByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffRoleDefByUDefIdxKey existingKeyUDefIdx = (BusModelBuffRoleDefByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUDefIdxKey();
		existingKeyUDefIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		existingKeyUDefIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );
		existingKeyUDefIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffRoleDefByUDefIdxKey newKeyUDefIdx = (BusModelBuffRoleDefByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUDefIdxKey();
		newKeyUDefIdx.setRequiredScopeId( Buff.getRequiredScopeId() );
		newKeyUDefIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );
		newKeyUDefIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateRoleDef",
					"RoleDefUNameIdx",
					"RoleDefUNameIdx",
					newKeyUNameIdx );
			}
		}

		if( ! existingKeyUDefIdx.equals( newKeyUDefIdx ) ) {
			if( dictByUDefIdx.containsKey( newKeyUDefIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateRoleDef",
					"RoleDefUDefIdx",
					"RoleDefUDefIdx",
					newKeyUDefIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredScopeId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateRoleDef",
						"Container",
						"Container",
						"Scope",
						"Scope",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByScopeIdx.get( existingKeyScopeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByScopeIdx.containsKey( newKeyScopeIdx ) ) {
			subdict = dictByScopeIdx.get( newKeyScopeIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef >();
			dictByScopeIdx.put( newKeyScopeIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUDefIdx.remove( existingKeyUDefIdx );
		dictByUDefIdx.put( newKeyUDefIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteRoleDef( ISecureAuthorization Authorization,
		IBusModelRoleDef iBuff )
	{
		final String S_ProcName = "BusModelRamRoleDefTable.deleteRoleDef() ";
		BusModelBuffRoleDef Buff = (BusModelBuffRoleDef)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffRoleDef existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteRoleDef",
				pkey );
		}
		BusModelBuffRoleDefByUNameIdxKey keyUNameIdx = (BusModelBuffRoleDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUNameIdxKey();
		keyUNameIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffRoleDefByScopeIdxKey keyScopeIdx = (BusModelBuffRoleDefByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByScopeIdxKey();
		keyScopeIdx.setRequiredScopeId( existing.getRequiredScopeId() );

		BusModelBuffRoleDefByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffRoleDefByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffRoleDefByUDefIdxKey keyUDefIdx = (BusModelBuffRoleDefByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUDefIdxKey();
		keyUDefIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUDefIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );
		keyUDefIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		if( schema.getTableSchemaRole().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteRoleDef",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"SchemaRole",
				"SchemaRole",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffRoleDef > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByScopeIdx.get( keyScopeIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		dictByUDefIdx.remove( keyUDefIdx );

	}
	@Override
	public void deleteRoleDefByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteRoleDefByIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffRoleDef cur;
		LinkedList<BusModelBuffRoleDef> matchSet = new LinkedList<BusModelBuffRoleDef>();
		Iterator<BusModelBuffRoleDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRoleDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRoleDef)(schema.getTableRoleDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelRoleDef.CLASS_CODE == subClassCode ) {
				schema.getTableRoleDef().deleteRoleDef( Authorization, cur );
			}
			else if( IBusModelSchemaRole.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaRole().deleteSchemaRole( Authorization, (IBusModelSchemaRole)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteRoleDefByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		BusModelBuffRoleDefByUNameIdxKey key = (BusModelBuffRoleDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUNameIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteRoleDefByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteRoleDefByUNameIdx( ISecureAuthorization Authorization,
		IBusModelRoleDefByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteRoleDefByUNameIdx";
		BusModelBuffRoleDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRoleDef> matchSet = new LinkedList<BusModelBuffRoleDef>();
		Iterator<BusModelBuffRoleDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRoleDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRoleDef)(schema.getTableRoleDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelRoleDef.CLASS_CODE == subClassCode ) {
				schema.getTableRoleDef().deleteRoleDef( Authorization, cur );
			}
			else if( IBusModelSchemaRole.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaRole().deleteSchemaRole( Authorization, (IBusModelSchemaRole)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteRoleDefByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		BusModelBuffRoleDefByScopeIdxKey key = (BusModelBuffRoleDefByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByScopeIdxKey();
		key.setRequiredScopeId( argScopeId );
		deleteRoleDefByScopeIdx( Authorization, key );
	}

	@Override
	public void deleteRoleDefByScopeIdx( ISecureAuthorization Authorization,
		IBusModelRoleDefByScopeIdxKey argKey )
	{
		final String S_ProcName = "deleteRoleDefByScopeIdx";
		BusModelBuffRoleDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRoleDef> matchSet = new LinkedList<BusModelBuffRoleDef>();
		Iterator<BusModelBuffRoleDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRoleDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRoleDef)(schema.getTableRoleDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelRoleDef.CLASS_CODE == subClassCode ) {
				schema.getTableRoleDef().deleteRoleDef( Authorization, cur );
			}
			else if( IBusModelSchemaRole.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaRole().deleteSchemaRole( Authorization, (IBusModelSchemaRole)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteRoleDefByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffRoleDefByDefSchemaIdxKey key = (BusModelBuffRoleDefByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteRoleDefByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteRoleDefByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelRoleDefByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteRoleDefByDefSchemaIdx";
		BusModelBuffRoleDef cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRoleDef> matchSet = new LinkedList<BusModelBuffRoleDef>();
		Iterator<BusModelBuffRoleDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRoleDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRoleDef)(schema.getTableRoleDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelRoleDef.CLASS_CODE == subClassCode ) {
				schema.getTableRoleDef().deleteRoleDef( Authorization, cur );
			}
			else if( IBusModelSchemaRole.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaRole().deleteSchemaRole( Authorization, (IBusModelSchemaRole)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteRoleDefByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argDefSchemaId,
		String argName )
	{
		BusModelBuffRoleDefByUDefIdxKey key = (BusModelBuffRoleDefByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUDefIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		key.setRequiredName( argName );
		deleteRoleDefByUDefIdx( Authorization, key );
	}

	@Override
	public void deleteRoleDefByUDefIdx( ISecureAuthorization Authorization,
		IBusModelRoleDefByUDefIdxKey argKey )
	{
		final String S_ProcName = "deleteRoleDefByUDefIdx";
		BusModelBuffRoleDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRoleDef> matchSet = new LinkedList<BusModelBuffRoleDef>();
		Iterator<BusModelBuffRoleDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRoleDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRoleDef)(schema.getTableRoleDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelRoleDef.CLASS_CODE == subClassCode ) {
				schema.getTableRoleDef().deleteRoleDef( Authorization, cur );
			}
			else if( IBusModelSchemaRole.CLASS_CODE == subClassCode ) {
				schema.getTableSchemaRole().deleteSchemaRole( Authorization, (IBusModelSchemaRole)cur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}
}
