
// Description: Java 25 in-memory RAM DbIO implementation for Index.

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
 *	BusModelRamIndexTable in-memory RAM DbIO implementation
 *	for Index.
 */
public class BusModelRamIndexTable
	implements IBusModelIndexTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffIndex > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffIndex >();
	private Map< BusModelBuffIndexByUNameIdxKey,
			BusModelBuffIndex > dictByUNameIdx
		= new HashMap< BusModelBuffIndexByUNameIdxKey,
			BusModelBuffIndex >();
	private Map< BusModelBuffIndexByIdxTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndex >> dictByIdxTableIdx
		= new HashMap< BusModelBuffIndexByIdxTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndex >>();
	private Map< BusModelBuffIndexByIdxCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndex >> dictByIdxCodeVisIdx
		= new HashMap< BusModelBuffIndexByIdxCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndex >>();
	private Map< BusModelBuffIndexByIdxTblCdVisXKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndex >> dictByIdxTblCdVisX
		= new HashMap< BusModelBuffIndexByIdxTblCdVisXKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndex >>();
	private Map< BusModelBuffIndexByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndex >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffIndexByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffIndex >>();

	public BusModelRamIndexTable( IBusModelSchema argSchema ) {
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
	public IBusModelIndex createIndex( ISecureAuthorization Authorization,
		IBusModelIndex iBuff )
	{
		final String S_ProcName = "createIndex";
		
		BusModelBuffIndex Buff = (BusModelBuffIndex)(schema.getTableScope().createScope( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffIndexByUNameIdxKey keyUNameIdx = (BusModelBuffIndexByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffIndexByIdxTableIdxKey keyIdxTableIdx = (BusModelBuffIndexByIdxTableIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTableIdxKey();
		keyIdxTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffIndexByIdxCodeVisIdxKey keyIdxCodeVisIdx = (BusModelBuffIndexByIdxCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
		keyIdxCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffIndexByIdxTblCdVisXKey keyIdxTblCdVisX = (BusModelBuffIndexByIdxTblCdVisXKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTblCdVisXKey();
		keyIdxTblCdVisX.setRequiredTableId( Buff.getRequiredTableId() );
		keyIdxTblCdVisX.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffIndexByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffIndexByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"IndexUNameIdx",
				"IndexUNameIdx",
				keyUNameIdx );
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

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictIdxTableIdx;
		if( dictByIdxTableIdx.containsKey( keyIdxTableIdx ) ) {
			subdictIdxTableIdx = dictByIdxTableIdx.get( keyIdxTableIdx );
		}
		else {
			subdictIdxTableIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByIdxTableIdx.put( keyIdxTableIdx, subdictIdxTableIdx );
		}
		subdictIdxTableIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictIdxCodeVisIdx;
		if( dictByIdxCodeVisIdx.containsKey( keyIdxCodeVisIdx ) ) {
			subdictIdxCodeVisIdx = dictByIdxCodeVisIdx.get( keyIdxCodeVisIdx );
		}
		else {
			subdictIdxCodeVisIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByIdxCodeVisIdx.put( keyIdxCodeVisIdx, subdictIdxCodeVisIdx );
		}
		subdictIdxCodeVisIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictIdxTblCdVisX;
		if( dictByIdxTblCdVisX.containsKey( keyIdxTblCdVisX ) ) {
			subdictIdxTblCdVisX = dictByIdxTblCdVisX.get( keyIdxTblCdVisX );
		}
		else {
			subdictIdxTblCdVisX = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByIdxTblCdVisX.put( keyIdxTblCdVisX, subdictIdxTblCdVisX );
		}
		subdictIdxTblCdVisX.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelIndex.CLASS_CODE) {
				BusModelBuffIndex retbuff = ((BusModelBuffIndex)(schema.getBusModelBuffFactory().getFactoryIndex().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelIndex readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamIndex.readDerived";
		IBusModelIndex buff;
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
	public IBusModelIndex lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamIndex.lockDerived";
		IBusModelIndex buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndex[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamIndex.readAllDerived";
		IBusModelIndex[] retList = new IBusModelIndex[ dictByPKey.values().size() ];
		Iterator< BusModelBuffIndex > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelIndex[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelIndex> filteredList = new ArrayList<IBusModelIndex>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelIndex ) ) {
					filteredList.add( (IBusModelIndex)buff );
				}
			}
			return( filteredList.toArray( new IBusModelIndex[0] ) );
		}
	}

	@Override
	public IBusModelIndex readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamIndex.readDerivedByUNameIdx";
		BusModelBuffIndexByUNameIdxKey key = (BusModelBuffIndexByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByUNameIdxKey();

		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelIndex buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndex[] readDerivedByIdxTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamIndex.readDerivedByIdxTableIdx";
		BusModelBuffIndexByIdxTableIdxKey key = (BusModelBuffIndexByIdxTableIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTableIdxKey();

		key.setRequiredTableId( TableId );
		IBusModelIndex[] recArray;
		if( dictByIdxTableIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictIdxTableIdx
				= dictByIdxTableIdx.get( key );
			recArray = new IBusModelIndex[ subdictIdxTableIdx.size() ];
			Iterator< BusModelBuffIndex > iter = subdictIdxTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictIdxTableIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByIdxTableIdx.put( key, subdictIdxTableIdx );
			recArray = new IBusModelIndex[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndex[] readDerivedByIdxCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamIndex.readDerivedByIdxCodeVisIdx";
		BusModelBuffIndexByIdxCodeVisIdxKey key = (BusModelBuffIndexByIdxCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxCodeVisIdxKey();

		key.setRequiredCodeVis( CodeVis );
		IBusModelIndex[] recArray;
		if( dictByIdxCodeVisIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictIdxCodeVisIdx
				= dictByIdxCodeVisIdx.get( key );
			recArray = new IBusModelIndex[ subdictIdxCodeVisIdx.size() ];
			Iterator< BusModelBuffIndex > iter = subdictIdxCodeVisIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictIdxCodeVisIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByIdxCodeVisIdx.put( key, subdictIdxCodeVisIdx );
			recArray = new IBusModelIndex[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndex[] readDerivedByIdxTblCdVisX( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamIndex.readDerivedByIdxTblCdVisX";
		BusModelBuffIndexByIdxTblCdVisXKey key = (BusModelBuffIndexByIdxTblCdVisXKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTblCdVisXKey();

		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		IBusModelIndex[] recArray;
		if( dictByIdxTblCdVisX.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictIdxTblCdVisX
				= dictByIdxTblCdVisX.get( key );
			recArray = new IBusModelIndex[ subdictIdxTblCdVisX.size() ];
			Iterator< BusModelBuffIndex > iter = subdictIdxTblCdVisX.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictIdxTblCdVisX
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByIdxTblCdVisX.put( key, subdictIdxTblCdVisX );
			recArray = new IBusModelIndex[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndex[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamIndex.readDerivedByDefSchemaIdx";
		BusModelBuffIndexByDefSchemaIdxKey key = (BusModelBuffIndexByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelIndex[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelIndex[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffIndex > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelIndex[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelIndex readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelIndex buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndex readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamIndex.readRec";
		IBusModelIndex buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelIndex.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndex lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelIndex buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelIndex.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelIndex[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamIndex.readAllRec";
		IBusModelIndex buff;
		ArrayList<IBusModelIndex> filteredList = new ArrayList<IBusModelIndex>();
		IBusModelIndex[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndex.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndex[0] ) );
	}

	@Override
	public IBusModelIndex readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelIndex buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelIndex)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelIndex[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelIndex buff;
		ArrayList<IBusModelIndex> filteredList = new ArrayList<IBusModelIndex>();
		IBusModelIndex[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndex)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndex[0] ) );
	}

	@Override
	public IBusModelIndex readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamIndex.readRecByUNameIdx() ";
		IBusModelIndex buff = readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndex.CLASS_CODE ) ) {
			return( (IBusModelIndex)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelIndex[] readRecByIdxTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamIndex.readRecByIdxTableIdx() ";
		IBusModelIndex buff;
		ArrayList<IBusModelIndex> filteredList = new ArrayList<IBusModelIndex>();
		IBusModelIndex[] buffList = readDerivedByIdxTableIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndex.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndex)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndex[0] ) );
	}

	@Override
	public IBusModelIndex[] readRecByIdxCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamIndex.readRecByIdxCodeVisIdx() ";
		IBusModelIndex buff;
		ArrayList<IBusModelIndex> filteredList = new ArrayList<IBusModelIndex>();
		IBusModelIndex[] buffList = readDerivedByIdxCodeVisIdx( Authorization,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndex.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndex)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndex[0] ) );
	}

	@Override
	public IBusModelIndex[] readRecByIdxTblCdVisX( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamIndex.readRecByIdxTblCdVisX() ";
		IBusModelIndex buff;
		ArrayList<IBusModelIndex> filteredList = new ArrayList<IBusModelIndex>();
		IBusModelIndex[] buffList = readDerivedByIdxTblCdVisX( Authorization,
			TableId,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndex.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndex)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndex[0] ) );
	}

	@Override
	public IBusModelIndex[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamIndex.readRecByDefSchemaIdx() ";
		IBusModelIndex buff;
		ArrayList<IBusModelIndex> filteredList = new ArrayList<IBusModelIndex>();
		IBusModelIndex[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelIndex.CLASS_CODE ) ) {
				filteredList.add( (IBusModelIndex)buff );
			}
		}
		return( filteredList.toArray( new IBusModelIndex[0] ) );
	}

	public IBusModelIndex updateIndex( ISecureAuthorization Authorization,
		IBusModelIndex iBuff )
	{
		BusModelBuffIndex Buff = (BusModelBuffIndex)(schema.getTableScope().updateScope( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffIndex existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateIndex",
				"Existing record not found",
				"Existing record not found",
				"Index",
				"Index",
				pkey );
		}
		BusModelBuffIndexByUNameIdxKey existingKeyUNameIdx = (BusModelBuffIndexByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffIndexByUNameIdxKey newKeyUNameIdx = (BusModelBuffIndexByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffIndexByIdxTableIdxKey existingKeyIdxTableIdx = (BusModelBuffIndexByIdxTableIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTableIdxKey();
		existingKeyIdxTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffIndexByIdxTableIdxKey newKeyIdxTableIdx = (BusModelBuffIndexByIdxTableIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTableIdxKey();
		newKeyIdxTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffIndexByIdxCodeVisIdxKey existingKeyIdxCodeVisIdx = (BusModelBuffIndexByIdxCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
		existingKeyIdxCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffIndexByIdxCodeVisIdxKey newKeyIdxCodeVisIdx = (BusModelBuffIndexByIdxCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
		newKeyIdxCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffIndexByIdxTblCdVisXKey existingKeyIdxTblCdVisX = (BusModelBuffIndexByIdxTblCdVisXKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTblCdVisXKey();
		existingKeyIdxTblCdVisX.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyIdxTblCdVisX.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffIndexByIdxTblCdVisXKey newKeyIdxTblCdVisX = (BusModelBuffIndexByIdxTblCdVisXKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTblCdVisXKey();
		newKeyIdxTblCdVisX.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyIdxTblCdVisX.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffIndexByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffIndexByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffIndexByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffIndexByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateIndex",
					"IndexUNameIdx",
					"IndexUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateIndex",
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
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTableId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateIndex",
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByIdxTableIdx.get( existingKeyIdxTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIdxTableIdx.containsKey( newKeyIdxTableIdx ) ) {
			subdict = dictByIdxTableIdx.get( newKeyIdxTableIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByIdxTableIdx.put( newKeyIdxTableIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByIdxCodeVisIdx.get( existingKeyIdxCodeVisIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIdxCodeVisIdx.containsKey( newKeyIdxCodeVisIdx ) ) {
			subdict = dictByIdxCodeVisIdx.get( newKeyIdxCodeVisIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByIdxCodeVisIdx.put( newKeyIdxCodeVisIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByIdxTblCdVisX.get( existingKeyIdxTblCdVisX );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIdxTblCdVisX.containsKey( newKeyIdxTblCdVisX ) ) {
			subdict = dictByIdxTblCdVisX.get( newKeyIdxTblCdVisX );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByIdxTblCdVisX.put( newKeyIdxTblCdVisX, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffIndex >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteIndex( ISecureAuthorization Authorization,
		IBusModelIndex iBuff )
	{
		final String S_ProcName = "BusModelRamIndexTable.deleteIndex() ";
		BusModelBuffIndex Buff = (BusModelBuffIndex)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffIndex existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteIndex",
				pkey );
		}
		BusModelBuffIndexCol buffDelIndexRefRelFromCols;
		IBusModelIndexCol arrDelIndexRefRelFromCols[] = schema.getTableIndexCol().readDerivedByIndexIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelIndexRefRelFromCols = 0; idxDelIndexRefRelFromCols < arrDelIndexRefRelFromCols.length; idxDelIndexRefRelFromCols++ ) {
			buffDelIndexRefRelFromCols = (BusModelBuffIndexCol)(arrDelIndexRefRelFromCols[idxDelIndexRefRelFromCols]);
					schema.getTableRelationCol().deleteRelationColByFromColIdx( Authorization,
						buffDelIndexRefRelFromCols.getRequiredId() );
		}
		BusModelBuffIndexCol buffDelIndexRefRelToCols;
		IBusModelIndexCol arrDelIndexRefRelToCols[] = schema.getTableIndexCol().readDerivedByIndexIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelIndexRefRelToCols = 0; idxDelIndexRefRelToCols < arrDelIndexRefRelToCols.length; idxDelIndexRefRelToCols++ ) {
			buffDelIndexRefRelToCols = (BusModelBuffIndexCol)(arrDelIndexRefRelToCols[idxDelIndexRefRelToCols]);
					schema.getTableRelationCol().deleteRelationColByToColIdx( Authorization,
						buffDelIndexRefRelToCols.getRequiredId() );
		}
					schema.getTableIndexCol().deleteIndexColByIndexIdx( Authorization,
						existing.getRequiredId() );
		BusModelBuffIndexByUNameIdxKey keyUNameIdx = (BusModelBuffIndexByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffIndexByIdxTableIdxKey keyIdxTableIdx = (BusModelBuffIndexByIdxTableIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTableIdxKey();
		keyIdxTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffIndexByIdxCodeVisIdxKey keyIdxCodeVisIdx = (BusModelBuffIndexByIdxCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
		keyIdxCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffIndexByIdxTblCdVisXKey keyIdxTblCdVisX = (BusModelBuffIndexByIdxTblCdVisXKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTblCdVisXKey();
		keyIdxTblCdVisX.setRequiredTableId( existing.getRequiredTableId() );
		keyIdxTblCdVisX.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffIndexByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffIndexByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		// Validate reverse foreign keys

		if( schema.getTableRelation().readDerivedByFromKeyIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteIndex",
				"Lookup",
				"Lookup",
				"FromIndex",
				"FromIndex",
				"Relation",
				"Relation",
				pkey );
		}

		if( schema.getTableRelation().readDerivedByToKeyIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteIndex",
				"Lookup",
				"Lookup",
				"ToIndex",
				"ToIndex",
				"Relation",
				"Relation",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffIndex > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByIdxTableIdx.get( keyIdxTableIdx );
		subdict.remove( pkey );

		subdict = dictByIdxCodeVisIdx.get( keyIdxCodeVisIdx );
		subdict.remove( pkey );

		subdict = dictByIdxTblCdVisX.get( keyIdxTblCdVisX );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}
	@Override
	public void deleteIndexByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		BusModelBuffIndexByUNameIdxKey key = (BusModelBuffIndexByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByUNameIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteIndexByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteIndexByUNameIdx( ISecureAuthorization Authorization,
		IBusModelIndexByUNameIdxKey argKey )
	{
		BusModelBuffIndex cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndex> matchSet = new LinkedList<BusModelBuffIndex>();
		Iterator<BusModelBuffIndex> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndex> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndex)(schema.getTableIndex().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndex( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexByIdxTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffIndexByIdxTableIdxKey key = (BusModelBuffIndexByIdxTableIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTableIdxKey();
		key.setRequiredTableId( argTableId );
		deleteIndexByIdxTableIdx( Authorization, key );
	}

	@Override
	public void deleteIndexByIdxTableIdx( ISecureAuthorization Authorization,
		IBusModelIndexByIdxTableIdxKey argKey )
	{
		BusModelBuffIndex cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndex> matchSet = new LinkedList<BusModelBuffIndex>();
		Iterator<BusModelBuffIndex> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndex> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndex)(schema.getTableIndex().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndex( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexByIdxCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffIndexByIdxCodeVisIdxKey key = (BusModelBuffIndexByIdxCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
		key.setRequiredCodeVis( argCodeVis );
		deleteIndexByIdxCodeVisIdx( Authorization, key );
	}

	@Override
	public void deleteIndexByIdxCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelIndexByIdxCodeVisIdxKey argKey )
	{
		BusModelBuffIndex cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndex> matchSet = new LinkedList<BusModelBuffIndex>();
		Iterator<BusModelBuffIndex> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndex> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndex)(schema.getTableIndex().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndex( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexByIdxTblCdVisX( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffIndexByIdxTblCdVisXKey key = (BusModelBuffIndexByIdxTblCdVisXKey)schema.getBusModelBuffFactory().getFactoryIndex().newByIdxTblCdVisXKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredCodeVis( argCodeVis );
		deleteIndexByIdxTblCdVisX( Authorization, key );
	}

	@Override
	public void deleteIndexByIdxTblCdVisX( ISecureAuthorization Authorization,
		IBusModelIndexByIdxTblCdVisXKey argKey )
	{
		BusModelBuffIndex cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndex> matchSet = new LinkedList<BusModelBuffIndex>();
		Iterator<BusModelBuffIndex> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndex> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndex)(schema.getTableIndex().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndex( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffIndexByDefSchemaIdxKey key = (BusModelBuffIndexByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryIndex().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteIndexByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteIndexByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelIndexByDefSchemaIdxKey argKey )
	{
		BusModelBuffIndex cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndex> matchSet = new LinkedList<BusModelBuffIndex>();
		Iterator<BusModelBuffIndex> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndex> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndex)(schema.getTableIndex().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndex( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffIndex cur;
		LinkedList<BusModelBuffIndex> matchSet = new LinkedList<BusModelBuffIndex>();
		Iterator<BusModelBuffIndex> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndex> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndex)(schema.getTableIndex().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndex( Authorization, cur );
		}
	}

	@Override
	public void deleteIndexByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteIndexByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteIndexByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffIndex cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffIndex> matchSet = new LinkedList<BusModelBuffIndex>();
		Iterator<BusModelBuffIndex> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffIndex> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffIndex)(schema.getTableIndex().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteIndex( Authorization, cur );
		}
	}
}
