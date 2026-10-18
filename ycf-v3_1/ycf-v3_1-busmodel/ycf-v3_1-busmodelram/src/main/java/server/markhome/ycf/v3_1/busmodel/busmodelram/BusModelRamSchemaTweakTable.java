
// Description: Java 25 in-memory RAM DbIO implementation for SchemaTweak.

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
 *	BusModelRamSchemaTweakTable in-memory RAM DbIO implementation
 *	for SchemaTweak.
 */
public class BusModelRamSchemaTweakTable
	implements IBusModelSchemaTweakTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffSchemaTweak > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffSchemaTweak >();
	private Map< BusModelBuffSchemaTweakBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaTweak >> dictBySchemaIdx
		= new HashMap< BusModelBuffSchemaTweakBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaTweak >>();

	public BusModelRamSchemaTweakTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffTweak ensureRec(IBusModelTweak rec) {
		if (rec == null) {
			return( null );
		}
		else {
			return (((BusModelBuffTweakFactoryService)(schema.getBusModelBuffFactory().getFactoryTweak())).ensureRec(rec));
		}
	}

	@Override
	public IBusModelSchemaTweak createSchemaTweak( ISecureAuthorization Authorization,
		IBusModelSchemaTweak iBuff )
	{
		final String S_ProcName = "createSchemaTweak";
		
		BusModelBuffSchemaTweak Buff = (BusModelBuffSchemaTweak)(schema.getTableTweak().createTweak( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffSchemaTweakBySchemaIdxKey keySchemaIdx = (BusModelBuffSchemaTweakBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaTweak().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTweak().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"Tweak",
						"Tweak",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSchemaDefId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"Schema",
						"Schema",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaTweak > subdictSchemaIdx;
		if( dictBySchemaIdx.containsKey( keySchemaIdx ) ) {
			subdictSchemaIdx = dictBySchemaIdx.get( keySchemaIdx );
		}
		else {
			subdictSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaTweak >();
			dictBySchemaIdx.put( keySchemaIdx, subdictSchemaIdx );
		}
		subdictSchemaIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelSchemaTweak.CLASS_CODE) {
				BusModelBuffSchemaTweak retbuff = ((BusModelBuffSchemaTweak)(schema.getBusModelBuffFactory().getFactorySchemaTweak().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelSchemaTweak readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaTweak.readDerived";
		IBusModelSchemaTweak buff;
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
	public IBusModelSchemaTweak lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaTweak.lockDerived";
		IBusModelSchemaTweak buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaTweak[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamSchemaTweak.readAllDerived";
		IBusModelSchemaTweak[] retList = new IBusModelSchemaTweak[ dictByPKey.values().size() ];
		Iterator< BusModelBuffSchemaTweak > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelSchemaTweak readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByUNameIdx";
		IBusModelTweak buff = schema.getTableTweak().readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof IBusModelSchemaTweak ) {
			return( (IBusModelSchemaTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaTweak[] readDerivedByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByValTentIdx";
		IBusModelTweak buffList[] = schema.getTableTweak().readDerivedByValTentIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelTweak buff;
			ArrayList<IBusModelSchemaTweak> filteredList = new ArrayList<IBusModelSchemaTweak>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelSchemaTweak ) ) {
					filteredList.add( (IBusModelSchemaTweak)buff );
				}
			}
			return( filteredList.toArray( new IBusModelSchemaTweak[0] ) );
		}
	}

	@Override
	public IBusModelSchemaTweak[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByScopeIdx";
		IBusModelTweak buffList[] = schema.getTableTweak().readDerivedByScopeIdx( Authorization,
			ScopeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelTweak buff;
			ArrayList<IBusModelSchemaTweak> filteredList = new ArrayList<IBusModelSchemaTweak>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelSchemaTweak ) ) {
					filteredList.add( (IBusModelSchemaTweak)buff );
				}
			}
			return( filteredList.toArray( new IBusModelSchemaTweak[0] ) );
		}
	}

	@Override
	public IBusModelSchemaTweak[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByDefSchemaIdx";
		IBusModelTweak buffList[] = schema.getTableTweak().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelTweak buff;
			ArrayList<IBusModelSchemaTweak> filteredList = new ArrayList<IBusModelSchemaTweak>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelSchemaTweak ) ) {
					filteredList.add( (IBusModelSchemaTweak)buff );
				}
			}
			return( filteredList.toArray( new IBusModelSchemaTweak[0] ) );
		}
	}

	@Override
	public IBusModelSchemaTweak readDerivedByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByUDefIdx";
		IBusModelTweak buff = schema.getTableTweak().readDerivedByUDefIdx( Authorization,
			TenantId,
			ScopeId,
			DefSchemaTenantId,
			DefSchemaId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof IBusModelSchemaTweak ) {
			return( (IBusModelSchemaTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaTweak[] readDerivedBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "BusModelRamSchemaTweak.readDerivedBySchemaIdx";
		BusModelBuffSchemaTweakBySchemaIdxKey key = (BusModelBuffSchemaTweakBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaTweak().newBySchemaIdxKey();

		key.setRequiredSchemaDefId( SchemaDefId );
		IBusModelSchemaTweak[] recArray;
		if( dictBySchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaTweak > subdictSchemaIdx
				= dictBySchemaIdx.get( key );
			recArray = new IBusModelSchemaTweak[ subdictSchemaIdx.size() ];
			Iterator< BusModelBuffSchemaTweak > iter = subdictSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaTweak > subdictSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaTweak >();
			dictBySchemaIdx.put( key, subdictSchemaIdx );
			recArray = new IBusModelSchemaTweak[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaTweak readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByIdIdx() ";
		IBusModelSchemaTweak buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaTweak readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaTweak.readRec";
		IBusModelSchemaTweak buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelSchemaTweak.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaTweak lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelSchemaTweak buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelSchemaTweak.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaTweak[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamSchemaTweak.readAllRec";
		IBusModelSchemaTweak buff;
		ArrayList<IBusModelSchemaTweak> filteredList = new ArrayList<IBusModelSchemaTweak>();
		IBusModelSchemaTweak[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaTweak.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaTweak[0] ) );
	}

	@Override
	public IBusModelSchemaTweak readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByIdIdx() ";
		IBusModelSchemaTweak buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelSchemaTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaTweak readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByUNameIdx() ";
		IBusModelSchemaTweak buff = readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelSchemaTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaTweak[] readRecByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByValTentIdx() ";
		IBusModelSchemaTweak buff;
		ArrayList<IBusModelSchemaTweak> filteredList = new ArrayList<IBusModelSchemaTweak>();
		IBusModelSchemaTweak[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaTweak[0] ) );
	}

	@Override
	public IBusModelSchemaTweak[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByScopeIdx() ";
		IBusModelSchemaTweak buff;
		ArrayList<IBusModelSchemaTweak> filteredList = new ArrayList<IBusModelSchemaTweak>();
		IBusModelSchemaTweak[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaTweak[0] ) );
	}

	@Override
	public IBusModelSchemaTweak[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByDefSchemaIdx() ";
		IBusModelSchemaTweak buff;
		ArrayList<IBusModelSchemaTweak> filteredList = new ArrayList<IBusModelSchemaTweak>();
		IBusModelSchemaTweak[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaTweak[0] ) );
	}

	@Override
	public IBusModelSchemaTweak readRecByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByUDefIdx() ";
		IBusModelSchemaTweak buff = readDerivedByUDefIdx( Authorization,
			TenantId,
			ScopeId,
			DefSchemaTenantId,
			DefSchemaId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelSchemaTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaTweak[] readRecBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "BusModelRamSchemaTweak.readRecBySchemaIdx() ";
		IBusModelSchemaTweak buff;
		ArrayList<IBusModelSchemaTweak> filteredList = new ArrayList<IBusModelSchemaTweak>();
		IBusModelSchemaTweak[] buffList = readDerivedBySchemaIdx( Authorization,
			SchemaDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaTweak[0] ) );
	}

	public IBusModelSchemaTweak updateSchemaTweak( ISecureAuthorization Authorization,
		IBusModelSchemaTweak iBuff )
	{
		BusModelBuffSchemaTweak Buff = (BusModelBuffSchemaTweak)(schema.getTableTweak().updateTweak( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffSchemaTweak existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSchemaTweak",
				"Existing record not found",
				"Existing record not found",
				"SchemaTweak",
				"SchemaTweak",
				pkey );
		}
		BusModelBuffSchemaTweakBySchemaIdxKey existingKeySchemaIdx = (BusModelBuffSchemaTweakBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaTweak().newBySchemaIdxKey();
		existingKeySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		BusModelBuffSchemaTweakBySchemaIdxKey newKeySchemaIdx = (BusModelBuffSchemaTweakBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaTweak().newBySchemaIdxKey();
		newKeySchemaIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTweak().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSchemaTweak",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"Tweak",
						"Tweak",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSchemaDefId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSchemaTweak",
						"Container",
						"Container",
						"Schema",
						"Schema",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaTweak > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySchemaIdx.get( existingKeySchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchemaIdx.containsKey( newKeySchemaIdx ) ) {
			subdict = dictBySchemaIdx.get( newKeySchemaIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaTweak >();
			dictBySchemaIdx.put( newKeySchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSchemaTweak( ISecureAuthorization Authorization,
		IBusModelSchemaTweak iBuff )
	{
		final String S_ProcName = "BusModelRamSchemaTweakTable.deleteSchemaTweak() ";
		BusModelBuffSchemaTweak Buff = (BusModelBuffSchemaTweak)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffSchemaTweak existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSchemaTweak",
				pkey );
		}
		BusModelBuffSchemaTweakBySchemaIdxKey keySchemaIdx = (BusModelBuffSchemaTweakBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaTweak().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaTweak > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySchemaIdx.get( keySchemaIdx );
		subdict.remove( pkey );

		schema.getTableTweak().deleteTweak( Authorization,
			Buff );
	}
	@Override
	public void deleteSchemaTweakBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		BusModelBuffSchemaTweakBySchemaIdxKey key = (BusModelBuffSchemaTweakBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaTweak().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( argSchemaDefId );
		deleteSchemaTweakBySchemaIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaTweakBySchemaIdx( ISecureAuthorization Authorization,
		IBusModelSchemaTweakBySchemaIdxKey argKey )
	{
		BusModelBuffSchemaTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaTweak> matchSet = new LinkedList<BusModelBuffSchemaTweak>();
		Iterator<BusModelBuffSchemaTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaTweak)(schema.getTableSchemaTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaTweakByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffSchemaTweak cur;
		LinkedList<BusModelBuffSchemaTweak> matchSet = new LinkedList<BusModelBuffSchemaTweak>();
		Iterator<BusModelBuffSchemaTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaTweak)(schema.getTableSchemaTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaTweakByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		BusModelBuffTweakByUNameIdxKey key = (BusModelBuffTweakByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteSchemaTweakByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaTweakByUNameIdx( ISecureAuthorization Authorization,
		IBusModelTweakByUNameIdxKey argKey )
	{
		BusModelBuffSchemaTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaTweak> matchSet = new LinkedList<BusModelBuffSchemaTweak>();
		Iterator<BusModelBuffSchemaTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaTweak)(schema.getTableSchemaTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaTweakByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffTweakByValTentIdxKey key = (BusModelBuffTweakByValTentIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSchemaTweakByValTentIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaTweakByValTentIdx( ISecureAuthorization Authorization,
		IBusModelTweakByValTentIdxKey argKey )
	{
		BusModelBuffSchemaTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaTweak> matchSet = new LinkedList<BusModelBuffSchemaTweak>();
		Iterator<BusModelBuffSchemaTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaTweak)(schema.getTableSchemaTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaTweakByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		BusModelBuffTweakByScopeIdxKey key = (BusModelBuffTweakByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( argScopeId );
		deleteSchemaTweakByScopeIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaTweakByScopeIdx( ISecureAuthorization Authorization,
		IBusModelTweakByScopeIdxKey argKey )
	{
		BusModelBuffSchemaTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaTweak> matchSet = new LinkedList<BusModelBuffSchemaTweak>();
		Iterator<BusModelBuffSchemaTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaTweak)(schema.getTableSchemaTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaTweakByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffTweakByDefSchemaIdxKey key = (BusModelBuffTweakByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteSchemaTweakByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaTweakByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelTweakByDefSchemaIdxKey argKey )
	{
		BusModelBuffSchemaTweak cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaTweak> matchSet = new LinkedList<BusModelBuffSchemaTweak>();
		Iterator<BusModelBuffSchemaTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaTweak)(schema.getTableSchemaTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaTweakByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argDefSchemaTenantId,
		IYCFKeyHash256 argDefSchemaId,
		String argName )
	{
		BusModelBuffTweakByUDefIdxKey key = (BusModelBuffTweakByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		key.setRequiredName( argName );
		deleteSchemaTweakByUDefIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaTweakByUDefIdx( ISecureAuthorization Authorization,
		IBusModelTweakByUDefIdxKey argKey )
	{
		BusModelBuffSchemaTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( argKey.getOptionalDefSchemaTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaTweak> matchSet = new LinkedList<BusModelBuffSchemaTweak>();
		Iterator<BusModelBuffSchemaTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaTweak)(schema.getTableSchemaTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaTweak( Authorization, cur );
		}
	}
}
