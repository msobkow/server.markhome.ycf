
// Description: Java 25 in-memory RAM DbIO implementation for IndexTweak.

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
 *	BusModelRamIndexTweakTable in-memory RAM DbIO implementation
 *	for IndexTweak.
 */
public class BusModelRamIndexTweakTable
	implements IBusModelIndexTweakTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffIndexTweak > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffIndexTweak >();
	private Map< BusModelBuffIndexTweakByIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexTweak >> dictByIndexIdx
		= new HashMap< BusModelBuffIndexTweakByIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndexTweak >>();

	public BusModelRamIndexTweakTable( IBusModelSchema argSchema ) {
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
	public IBusModelIndexTweak createIndexTweak( ISecureAuthorization Authorization,
		IBusModelIndexTweak iBuff )
	{
		final String S_ProcName = "createIndexTweak";
		
		BusModelBuffIndexTweak Buff = (BusModelBuffIndexTweak)(schema.getTableTweak().createTweak( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffIndexTweakByIndexIdxKey keyIndexIdx = (BusModelBuffIndexTweakByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexTweak().newByIndexIdxKey();
		keyIndexIdx.setRequiredIndexId( Buff.getRequiredIndexId() );

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
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredIndexId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"Index",
						"Index",
						"Index",
						"Index",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexTweak > subdictIndexIdx;
		if( dictByIndexIdx.containsKey( keyIndexIdx ) ) {
			subdictIndexIdx = dictByIndexIdx.get( keyIndexIdx );
		}
		else {
			subdictIndexIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexTweak >();
			dictByIndexIdx.put( keyIndexIdx, subdictIndexIdx );
		}
		subdictIndexIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelIndexTweak.CLASS_CODE) {
				BusModelBuffIndexTweak retbuff = ((BusModelBuffIndexTweak)(schema.getBusModelBuffFactory().getFactoryIndexTweak().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelIndexTweak readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamIndexTweak.readDerived";
		IBusModelIndexTweak buff;
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
	public IBusModelIndexTweak lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamIndexTweak.lockDerived";
		IBusModelIndexTweak buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndexTweak[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamIndexTweak.readAllDerived";
		IBusModelIndexTweak[] retList = new IBusModelIndexTweak[ dictByPKey.values().size() ];
		Iterator< BusModelBuffIndexTweak > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelIndexTweak readDerivedByUNameIdx( ISecureAuthorization Authorization,
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
		else if( buff instanceof IBusModelIndexTweak ) {
			return( (IBusModelIndexTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelIndexTweak[] readDerivedByValTentIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelIndexTweak> filteredList = new ArrayList<IBusModelIndexTweak>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelIndexTweak ) ) {
					filteredList.add( (IBusModelIndexTweak)buff );
				}
			}
			return( filteredList.toArray( new IBusModelIndexTweak[0] ) );
		}
	}

	@Override
	public IBusModelIndexTweak[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelIndexTweak> filteredList = new ArrayList<IBusModelIndexTweak>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelIndexTweak ) ) {
					filteredList.add( (IBusModelIndexTweak)buff );
				}
			}
			return( filteredList.toArray( new IBusModelIndexTweak[0] ) );
		}
	}

	@Override
	public IBusModelIndexTweak[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelIndexTweak> filteredList = new ArrayList<IBusModelIndexTweak>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelIndexTweak ) ) {
					filteredList.add( (IBusModelIndexTweak)buff );
				}
			}
			return( filteredList.toArray( new IBusModelIndexTweak[0] ) );
		}
	}

	@Override
	public IBusModelIndexTweak readDerivedByUDefIdx( ISecureAuthorization Authorization,
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
		else if( buff instanceof IBusModelIndexTweak ) {
			return( (IBusModelIndexTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelIndexTweak[] readDerivedByIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId )
	{
		final String S_ProcName = "BusModelRamIndexTweak.readDerivedByIndexIdx";
		BusModelBuffIndexTweakByIndexIdxKey key = (BusModelBuffIndexTweakByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexTweak().newByIndexIdxKey();

		key.setRequiredIndexId( IndexId );
		IBusModelIndexTweak[] recArray;
		if( dictByIndexIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexTweak > subdictIndexIdx
				= dictByIndexIdx.get( key );
			recArray = new IBusModelIndexTweak[ subdictIndexIdx.size() ];
			Iterator< BusModelBuffIndexTweak > iter = subdictIndexIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexTweak > subdictIndexIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexTweak >();
			dictByIndexIdx.put( key, subdictIndexIdx );
			recArray = new IBusModelIndexTweak[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndexTweak readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByIdIdx() ";
		IBusModelIndexTweak buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndexTweak readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamIndexTweak.readRec";
		IBusModelIndexTweak buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelIndexTweak.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndexTweak lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelIndexTweak buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelIndexTweak.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndexTweak[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamIndexTweak.readAllRec";
		IBusModelIndexTweak buff;
		ArrayList<IBusModelIndexTweak> filteredList = new ArrayList<IBusModelIndexTweak>();
		IBusModelIndexTweak[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexTweak.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexTweak[0] ) );
	}

	@Override
	public IBusModelIndexTweak readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByIdIdx() ";
		IBusModelIndexTweak buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelIndexTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelIndexTweak readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByUNameIdx() ";
		IBusModelIndexTweak buff = readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelIndexTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelIndexTweak[] readRecByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByValTentIdx() ";
		IBusModelIndexTweak buff;
		ArrayList<IBusModelIndexTweak> filteredList = new ArrayList<IBusModelIndexTweak>();
		IBusModelIndexTweak[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexTweak[0] ) );
	}

	@Override
	public IBusModelIndexTweak[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByScopeIdx() ";
		IBusModelIndexTweak buff;
		ArrayList<IBusModelIndexTweak> filteredList = new ArrayList<IBusModelIndexTweak>();
		IBusModelIndexTweak[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexTweak[0] ) );
	}

	@Override
	public IBusModelIndexTweak[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByDefSchemaIdx() ";
		IBusModelIndexTweak buff;
		ArrayList<IBusModelIndexTweak> filteredList = new ArrayList<IBusModelIndexTweak>();
		IBusModelIndexTweak[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexTweak[0] ) );
	}

	@Override
	public IBusModelIndexTweak readRecByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByUDefIdx() ";
		IBusModelIndexTweak buff = readDerivedByUDefIdx( Authorization,
			TenantId,
			ScopeId,
			DefSchemaTenantId,
			DefSchemaId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelIndexTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelIndexTweak[] readRecByIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 IndexId )
	{
		final String S_ProcName = "BusModelRamIndexTweak.readRecByIndexIdx() ";
		IBusModelIndexTweak buff;
		ArrayList<IBusModelIndexTweak> filteredList = new ArrayList<IBusModelIndexTweak>();
		IBusModelIndexTweak[] buffList = readDerivedByIndexIdx( Authorization,
			IndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndexTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndexTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndexTweak[0] ) );
	}

	public IBusModelIndexTweak updateIndexTweak( ISecureAuthorization Authorization,
		IBusModelIndexTweak iBuff )
	{
		BusModelBuffIndexTweak Buff = (BusModelBuffIndexTweak)(schema.getTableTweak().updateTweak( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffIndexTweak existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateIndexTweak",
				"Existing record not found",
				"Existing record not found",
				"IndexTweak",
				"IndexTweak",
				pkey );
		}
		BusModelBuffIndexTweakByIndexIdxKey existingKeyIndexIdx = (BusModelBuffIndexTweakByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexTweak().newByIndexIdxKey();
		existingKeyIndexIdx.setRequiredIndexId( existing.getRequiredIndexId() );

		BusModelBuffIndexTweakByIndexIdxKey newKeyIndexIdx = (BusModelBuffIndexTweakByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexTweak().newByIndexIdxKey();
		newKeyIndexIdx.setRequiredIndexId( Buff.getRequiredIndexId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTweak().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateIndexTweak",
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
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredIndexId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateIndexTweak",
						"Container",
						"Container",
						"Index",
						"Index",
						"Index",
						"Index",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexTweak > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByIndexIdx.get( existingKeyIndexIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIndexIdx.containsKey( newKeyIndexIdx ) ) {
			subdict = dictByIndexIdx.get( newKeyIndexIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndexTweak >();
			dictByIndexIdx.put( newKeyIndexIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteIndexTweak( ISecureAuthorization Authorization,
		IBusModelIndexTweak iBuff )
	{
		final String S_ProcName = "BusModelRamIndexTweakTable.deleteIndexTweak() ";
		BusModelBuffIndexTweak Buff = (BusModelBuffIndexTweak)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffIndexTweak existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteIndexTweak",
				pkey );
		}
		BusModelBuffIndexTweakByIndexIdxKey keyIndexIdx = (BusModelBuffIndexTweakByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexTweak().newByIndexIdxKey();
		keyIndexIdx.setRequiredIndexId( existing.getRequiredIndexId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndexTweak > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByIndexIdx.get( keyIndexIdx );
		subdict.remove( pkey );

		schema.getTableTweak().deleteTweak( Authorization,
			Buff );
	}
	@Override
	public void deleteIndexTweakByIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argIndexId )
	{
		BusModelBuffIndexTweakByIndexIdxKey key = (BusModelBuffIndexTweakByIndexIdxKey)schema.getBusModelBuffFactory().getFactoryIndexTweak().newByIndexIdxKey();
		key.setRequiredIndexId( argIndexId );
		deleteIndexTweakByIndexIdx( Authorization, key );
	}

	@Override
	public void deleteIndexTweakByIndexIdx( ISecureAuthorization Authorization,
		IBusModelIndexTweakByIndexIdxKey argKey )
	{
		BusModelBuffIndexTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexTweak> matchSet = new LinkedList<BusModelBuffIndexTweak>();
		Iterator<BusModelBuffIndexTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexTweak)(schema.getTableIndexTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexTweakByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffIndexTweak cur;
		LinkedList<BusModelBuffIndexTweak> matchSet = new LinkedList<BusModelBuffIndexTweak>();
		Iterator<BusModelBuffIndexTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexTweak)(schema.getTableIndexTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexTweakByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		BusModelBuffTweakByUNameIdxKey key = (BusModelBuffTweakByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteIndexTweakByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteIndexTweakByUNameIdx( ISecureAuthorization Authorization,
		IBusModelTweakByUNameIdxKey argKey )
	{
		BusModelBuffIndexTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexTweak> matchSet = new LinkedList<BusModelBuffIndexTweak>();
		Iterator<BusModelBuffIndexTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexTweak)(schema.getTableIndexTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexTweakByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffTweakByValTentIdxKey key = (BusModelBuffTweakByValTentIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteIndexTweakByValTentIdx( Authorization, key );
	}

	@Override
	public void deleteIndexTweakByValTentIdx( ISecureAuthorization Authorization,
		IBusModelTweakByValTentIdxKey argKey )
	{
		BusModelBuffIndexTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexTweak> matchSet = new LinkedList<BusModelBuffIndexTweak>();
		Iterator<BusModelBuffIndexTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexTweak)(schema.getTableIndexTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexTweakByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		BusModelBuffTweakByScopeIdxKey key = (BusModelBuffTweakByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( argScopeId );
		deleteIndexTweakByScopeIdx( Authorization, key );
	}

	@Override
	public void deleteIndexTweakByScopeIdx( ISecureAuthorization Authorization,
		IBusModelTweakByScopeIdxKey argKey )
	{
		BusModelBuffIndexTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexTweak> matchSet = new LinkedList<BusModelBuffIndexTweak>();
		Iterator<BusModelBuffIndexTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexTweak)(schema.getTableIndexTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexTweakByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffTweakByDefSchemaIdxKey key = (BusModelBuffTweakByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteIndexTweakByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteIndexTweakByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelTweakByDefSchemaIdxKey argKey )
	{
		BusModelBuffIndexTweak cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndexTweak> matchSet = new LinkedList<BusModelBuffIndexTweak>();
		Iterator<BusModelBuffIndexTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexTweak)(schema.getTableIndexTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexTweakByUDefIdx( ISecureAuthorization Authorization,
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
		deleteIndexTweakByUDefIdx( Authorization, key );
	}

	@Override
	public void deleteIndexTweakByUDefIdx( ISecureAuthorization Authorization,
		IBusModelTweakByUDefIdxKey argKey )
	{
		BusModelBuffIndexTweak cur;
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
		LinkedList<BusModelBuffIndexTweak> matchSet = new LinkedList<BusModelBuffIndexTweak>();
		Iterator<BusModelBuffIndexTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndexTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndexTweak)(schema.getTableIndexTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndexTweak( Authorization, cur );
		}
	}
}
