
// Description: Java 25 in-memory RAM DbIO implementation for TableTweak.

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
 *	BusModelRamTableTweakTable in-memory RAM DbIO implementation
 *	for TableTweak.
 */
public class BusModelRamTableTweakTable
	implements IBusModelTableTweakTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffTableTweak > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffTableTweak >();
	private Map< BusModelBuffTableTweakByTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTableTweak >> dictByTableIdx
		= new HashMap< BusModelBuffTableTweakByTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTableTweak >>();

	public BusModelRamTableTweakTable( IBusModelSchema argSchema ) {
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
	public IBusModelTableTweak createTableTweak( ISecureAuthorization Authorization,
		IBusModelTableTweak iBuff )
	{
		final String S_ProcName = "createTableTweak";
		
		BusModelBuffTableTweak Buff = (BusModelBuffTableTweak)(schema.getTableTweak().createTweak( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffTableTweakByTableIdxKey keyTableIdx = (BusModelBuffTableTweakByTableIdxKey)schema.getBusModelBuffFactory().getFactoryTableTweak().newByTableIdxKey();
		keyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

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
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTableId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"Table",
						"Table",
						"Table",
						"Table",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTableTweak > subdictTableIdx;
		if( dictByTableIdx.containsKey( keyTableIdx ) ) {
			subdictTableIdx = dictByTableIdx.get( keyTableIdx );
		}
		else {
			subdictTableIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTableTweak >();
			dictByTableIdx.put( keyTableIdx, subdictTableIdx );
		}
		subdictTableIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelTableTweak.CLASS_CODE) {
				BusModelBuffTableTweak retbuff = ((BusModelBuffTableTweak)(schema.getBusModelBuffFactory().getFactoryTableTweak().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelTableTweak readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamTableTweak.readDerived";
		IBusModelTableTweak buff;
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
	public IBusModelTableTweak lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamTableTweak.lockDerived";
		IBusModelTableTweak buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTableTweak[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamTableTweak.readAllDerived";
		IBusModelTableTweak[] retList = new IBusModelTableTweak[ dictByPKey.values().size() ];
		Iterator< BusModelBuffTableTweak > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelTableTweak readDerivedByUNameIdx( ISecureAuthorization Authorization,
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
		else if( buff instanceof IBusModelTableTweak ) {
			return( (IBusModelTableTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTableTweak[] readDerivedByValTentIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelTableTweak> filteredList = new ArrayList<IBusModelTableTweak>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelTableTweak ) ) {
					filteredList.add( (IBusModelTableTweak)buff );
				}
			}
			return( filteredList.toArray( new IBusModelTableTweak[0] ) );
		}
	}

	@Override
	public IBusModelTableTweak[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelTableTweak> filteredList = new ArrayList<IBusModelTableTweak>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelTableTweak ) ) {
					filteredList.add( (IBusModelTableTweak)buff );
				}
			}
			return( filteredList.toArray( new IBusModelTableTweak[0] ) );
		}
	}

	@Override
	public IBusModelTableTweak[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelTableTweak> filteredList = new ArrayList<IBusModelTableTweak>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelTableTweak ) ) {
					filteredList.add( (IBusModelTableTweak)buff );
				}
			}
			return( filteredList.toArray( new IBusModelTableTweak[0] ) );
		}
	}

	@Override
	public IBusModelTableTweak readDerivedByUDefIdx( ISecureAuthorization Authorization,
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
		else if( buff instanceof IBusModelTableTweak ) {
			return( (IBusModelTableTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTableTweak[] readDerivedByTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamTableTweak.readDerivedByTableIdx";
		BusModelBuffTableTweakByTableIdxKey key = (BusModelBuffTableTweakByTableIdxKey)schema.getBusModelBuffFactory().getFactoryTableTweak().newByTableIdxKey();

		key.setRequiredTableId( TableId );
		IBusModelTableTweak[] recArray;
		if( dictByTableIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTableTweak > subdictTableIdx
				= dictByTableIdx.get( key );
			recArray = new IBusModelTableTweak[ subdictTableIdx.size() ];
			Iterator< BusModelBuffTableTweak > iter = subdictTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTableTweak > subdictTableIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTableTweak >();
			dictByTableIdx.put( key, subdictTableIdx );
			recArray = new IBusModelTableTweak[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTableTweak readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamTweak.readDerivedByIdIdx() ";
		IBusModelTableTweak buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTableTweak readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamTableTweak.readRec";
		IBusModelTableTweak buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelTableTweak.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTableTweak lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelTableTweak buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelTableTweak.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTableTweak[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamTableTweak.readAllRec";
		IBusModelTableTweak buff;
		ArrayList<IBusModelTableTweak> filteredList = new ArrayList<IBusModelTableTweak>();
		IBusModelTableTweak[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTableTweak.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelTableTweak[0] ) );
	}

	@Override
	public IBusModelTableTweak readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByIdIdx() ";
		IBusModelTableTweak buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelTableTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTableTweak readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByUNameIdx() ";
		IBusModelTableTweak buff = readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelTableTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTableTweak[] readRecByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByValTentIdx() ";
		IBusModelTableTweak buff;
		ArrayList<IBusModelTableTweak> filteredList = new ArrayList<IBusModelTableTweak>();
		IBusModelTableTweak[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTableTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTableTweak[0] ) );
	}

	@Override
	public IBusModelTableTweak[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByScopeIdx() ";
		IBusModelTableTweak buff;
		ArrayList<IBusModelTableTweak> filteredList = new ArrayList<IBusModelTableTweak>();
		IBusModelTableTweak[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTableTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTableTweak[0] ) );
	}

	@Override
	public IBusModelTableTweak[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByDefSchemaIdx() ";
		IBusModelTableTweak buff;
		ArrayList<IBusModelTableTweak> filteredList = new ArrayList<IBusModelTableTweak>();
		IBusModelTableTweak[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTableTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTableTweak[0] ) );
	}

	@Override
	public IBusModelTableTweak readRecByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTweak.readRecByUDefIdx() ";
		IBusModelTableTweak buff = readDerivedByUDefIdx( Authorization,
			TenantId,
			ScopeId,
			DefSchemaTenantId,
			DefSchemaId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTweak.CLASS_CODE ) ) {
			return( (IBusModelTableTweak)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTableTweak[] readRecByTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamTableTweak.readRecByTableIdx() ";
		IBusModelTableTweak buff;
		ArrayList<IBusModelTableTweak> filteredList = new ArrayList<IBusModelTableTweak>();
		IBusModelTableTweak[] buffList = readDerivedByTableIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTableTweak.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTableTweak)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTableTweak[0] ) );
	}

	public IBusModelTableTweak updateTableTweak( ISecureAuthorization Authorization,
		IBusModelTableTweak iBuff )
	{
		BusModelBuffTableTweak Buff = (BusModelBuffTableTweak)(schema.getTableTweak().updateTweak( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffTableTweak existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateTableTweak",
				"Existing record not found",
				"Existing record not found",
				"TableTweak",
				"TableTweak",
				pkey );
		}
		BusModelBuffTableTweakByTableIdxKey existingKeyTableIdx = (BusModelBuffTableTweakByTableIdxKey)schema.getBusModelBuffFactory().getFactoryTableTweak().newByTableIdxKey();
		existingKeyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffTableTweakByTableIdxKey newKeyTableIdx = (BusModelBuffTableTweakByTableIdxKey)schema.getBusModelBuffFactory().getFactoryTableTweak().newByTableIdxKey();
		newKeyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTweak().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateTableTweak",
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
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTableId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateTableTweak",
						"Container",
						"Container",
						"Table",
						"Table",
						"Table",
						"Table",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTableTweak > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTableIdx.get( existingKeyTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTableIdx.containsKey( newKeyTableIdx ) ) {
			subdict = dictByTableIdx.get( newKeyTableIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTableTweak >();
			dictByTableIdx.put( newKeyTableIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteTableTweak( ISecureAuthorization Authorization,
		IBusModelTableTweak iBuff )
	{
		final String S_ProcName = "BusModelRamTableTweakTable.deleteTableTweak() ";
		BusModelBuffTableTweak Buff = (BusModelBuffTableTweak)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffTableTweak existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteTableTweak",
				pkey );
		}
		BusModelBuffTableTweakByTableIdxKey keyTableIdx = (BusModelBuffTableTweakByTableIdxKey)schema.getBusModelBuffFactory().getFactoryTableTweak().newByTableIdxKey();
		keyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffTableTweak > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTableIdx.get( keyTableIdx );
		subdict.remove( pkey );

		schema.getTableTweak().deleteTweak( Authorization,
			Buff );
	}
	@Override
	public void deleteTableTweakByTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffTableTweakByTableIdxKey key = (BusModelBuffTableTweakByTableIdxKey)schema.getBusModelBuffFactory().getFactoryTableTweak().newByTableIdxKey();
		key.setRequiredTableId( argTableId );
		deleteTableTweakByTableIdx( Authorization, key );
	}

	@Override
	public void deleteTableTweakByTableIdx( ISecureAuthorization Authorization,
		IBusModelTableTweakByTableIdxKey argKey )
	{
		BusModelBuffTableTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTableTweak> matchSet = new LinkedList<BusModelBuffTableTweak>();
		Iterator<BusModelBuffTableTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTableTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTableTweak)(schema.getTableTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTableTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteTableTweakByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffTableTweak cur;
		LinkedList<BusModelBuffTableTweak> matchSet = new LinkedList<BusModelBuffTableTweak>();
		Iterator<BusModelBuffTableTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTableTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTableTweak)(schema.getTableTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTableTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteTableTweakByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		BusModelBuffTweakByUNameIdxKey key = (BusModelBuffTweakByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteTableTweakByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteTableTweakByUNameIdx( ISecureAuthorization Authorization,
		IBusModelTweakByUNameIdxKey argKey )
	{
		BusModelBuffTableTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTableTweak> matchSet = new LinkedList<BusModelBuffTableTweak>();
		Iterator<BusModelBuffTableTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTableTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTableTweak)(schema.getTableTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTableTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteTableTweakByValTentIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffTweakByValTentIdxKey key = (BusModelBuffTweakByValTentIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTableTweakByValTentIdx( Authorization, key );
	}

	@Override
	public void deleteTableTweakByValTentIdx( ISecureAuthorization Authorization,
		IBusModelTweakByValTentIdxKey argKey )
	{
		BusModelBuffTableTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTableTweak> matchSet = new LinkedList<BusModelBuffTableTweak>();
		Iterator<BusModelBuffTableTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTableTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTableTweak)(schema.getTableTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTableTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteTableTweakByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		BusModelBuffTweakByScopeIdxKey key = (BusModelBuffTweakByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( argScopeId );
		deleteTableTweakByScopeIdx( Authorization, key );
	}

	@Override
	public void deleteTableTweakByScopeIdx( ISecureAuthorization Authorization,
		IBusModelTweakByScopeIdxKey argKey )
	{
		BusModelBuffTableTweak cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTableTweak> matchSet = new LinkedList<BusModelBuffTableTweak>();
		Iterator<BusModelBuffTableTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTableTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTableTweak)(schema.getTableTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTableTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteTableTweakByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffTweakByDefSchemaIdxKey key = (BusModelBuffTweakByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteTableTweakByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteTableTweakByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelTweakByDefSchemaIdxKey argKey )
	{
		BusModelBuffTableTweak cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTableTweak> matchSet = new LinkedList<BusModelBuffTableTweak>();
		Iterator<BusModelBuffTableTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTableTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTableTweak)(schema.getTableTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTableTweak( Authorization, cur );
		}
	}

	@Override
	public void deleteTableTweakByUDefIdx( ISecureAuthorization Authorization,
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
		deleteTableTweakByUDefIdx( Authorization, key );
	}

	@Override
	public void deleteTableTweakByUDefIdx( ISecureAuthorization Authorization,
		IBusModelTweakByUDefIdxKey argKey )
	{
		BusModelBuffTableTweak cur;
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
		LinkedList<BusModelBuffTableTweak> matchSet = new LinkedList<BusModelBuffTableTweak>();
		Iterator<BusModelBuffTableTweak> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTableTweak> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTableTweak)(schema.getTableTableTweak().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTableTweak( Authorization, cur );
		}
	}
}
