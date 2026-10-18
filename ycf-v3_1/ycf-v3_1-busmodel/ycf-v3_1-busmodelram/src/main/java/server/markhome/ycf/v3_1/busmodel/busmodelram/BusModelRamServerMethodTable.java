
// Description: Java 25 in-memory RAM DbIO implementation for ServerMethod.

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
 *	BusModelRamServerMethodTable in-memory RAM DbIO implementation
 *	for ServerMethod.
 */
public class BusModelRamServerMethodTable
	implements IBusModelServerMethodTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffServerMethod > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffServerMethod >();
	private Map< BusModelBuffServerMethodByUNameIdxKey,
			BusModelBuffServerMethod > dictByUNameIdx
		= new HashMap< BusModelBuffServerMethodByUNameIdxKey,
			BusModelBuffServerMethod >();
	private Map< BusModelBuffServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerMethod >> dictByMethTableIdx
		= new HashMap< BusModelBuffServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerMethod >>();
	private Map< BusModelBuffServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerMethod >> dictByMethCodeVisIdx
		= new HashMap< BusModelBuffServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerMethod >>();
	private Map< BusModelBuffServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerMethod >> dictByMethTableVisIdx
		= new HashMap< BusModelBuffServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerMethod >>();
	private Map< BusModelBuffServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerMethod >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerMethod >>();

	public BusModelRamServerMethodTable( IBusModelSchema argSchema ) {
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
	public IBusModelServerMethod createServerMethod( ISecureAuthorization Authorization,
		IBusModelServerMethod iBuff )
	{
		final String S_ProcName = "createServerMethod";
		
		BusModelBuffServerMethod Buff = (BusModelBuffServerMethod)(schema.getTableScope().createScope( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffServerMethodByUNameIdxKey keyUNameIdx = (BusModelBuffServerMethodByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffServerMethodByMethTableIdxKey keyMethTableIdx = (BusModelBuffServerMethodByMethTableIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableIdxKey();
		keyMethTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx = (BusModelBuffServerMethodByMethCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		keyMethCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffServerMethodByMethTableVisIdxKey keyMethTableVisIdx = (BusModelBuffServerMethodByMethTableVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		keyMethTableVisIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyMethTableVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffServerMethodByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffServerMethodByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ServerMethodUNameIdx",
				"ServerMethodUNameIdx",
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
						"ForTable",
						"ForTable",
						"Table",
						"Table",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictMethTableIdx;
		if( dictByMethTableIdx.containsKey( keyMethTableIdx ) ) {
			subdictMethTableIdx = dictByMethTableIdx.get( keyMethTableIdx );
		}
		else {
			subdictMethTableIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByMethTableIdx.put( keyMethTableIdx, subdictMethTableIdx );
		}
		subdictMethTableIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictMethCodeVisIdx;
		if( dictByMethCodeVisIdx.containsKey( keyMethCodeVisIdx ) ) {
			subdictMethCodeVisIdx = dictByMethCodeVisIdx.get( keyMethCodeVisIdx );
		}
		else {
			subdictMethCodeVisIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByMethCodeVisIdx.put( keyMethCodeVisIdx, subdictMethCodeVisIdx );
		}
		subdictMethCodeVisIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictMethTableVisIdx;
		if( dictByMethTableVisIdx.containsKey( keyMethTableVisIdx ) ) {
			subdictMethTableVisIdx = dictByMethTableVisIdx.get( keyMethTableVisIdx );
		}
		else {
			subdictMethTableVisIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByMethTableVisIdx.put( keyMethTableVisIdx, subdictMethTableVisIdx );
		}
		subdictMethTableVisIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelServerMethod.CLASS_CODE) {
				BusModelBuffServerMethod retbuff = ((BusModelBuffServerMethod)(schema.getBusModelBuffFactory().getFactoryServerMethod().newRec()));
				retbuff.set(Buff);
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelServerMethod readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerived";
		IBusModelServerMethod buff;
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
	public IBusModelServerMethod lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerMethod.lockDerived";
		IBusModelServerMethod buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerMethod[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamServerMethod.readAllDerived";
		IBusModelServerMethod[] retList = new IBusModelServerMethod[ dictByPKey.values().size() ];
		Iterator< BusModelBuffServerMethod > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelServerMethod[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerMethod> filteredList = new ArrayList<IBusModelServerMethod>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerMethod ) ) {
					filteredList.add( (IBusModelServerMethod)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerMethod[0] ) );
		}
	}

	@Override
	public IBusModelServerMethod readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByUNameIdx";
		BusModelBuffServerMethodByUNameIdxKey key = (BusModelBuffServerMethodByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByUNameIdxKey();

		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelServerMethod buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerMethod[] readDerivedByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByMethTableIdx";
		BusModelBuffServerMethodByMethTableIdxKey key = (BusModelBuffServerMethodByMethTableIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableIdxKey();

		key.setRequiredTableId( TableId );
		IBusModelServerMethod[] recArray;
		if( dictByMethTableIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictMethTableIdx
				= dictByMethTableIdx.get( key );
			recArray = new IBusModelServerMethod[ subdictMethTableIdx.size() ];
			Iterator< BusModelBuffServerMethod > iter = subdictMethTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictMethTableIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByMethTableIdx.put( key, subdictMethTableIdx );
			recArray = new IBusModelServerMethod[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelServerMethod[] readDerivedByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByMethCodeVisIdx";
		BusModelBuffServerMethodByMethCodeVisIdxKey key = (BusModelBuffServerMethodByMethCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();

		key.setRequiredCodeVis( CodeVis );
		IBusModelServerMethod[] recArray;
		if( dictByMethCodeVisIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictMethCodeVisIdx
				= dictByMethCodeVisIdx.get( key );
			recArray = new IBusModelServerMethod[ subdictMethCodeVisIdx.size() ];
			Iterator< BusModelBuffServerMethod > iter = subdictMethCodeVisIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictMethCodeVisIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByMethCodeVisIdx.put( key, subdictMethCodeVisIdx );
			recArray = new IBusModelServerMethod[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelServerMethod[] readDerivedByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByMethTableVisIdx";
		BusModelBuffServerMethodByMethTableVisIdxKey key = (BusModelBuffServerMethodByMethTableVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableVisIdxKey();

		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		IBusModelServerMethod[] recArray;
		if( dictByMethTableVisIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictMethTableVisIdx
				= dictByMethTableVisIdx.get( key );
			recArray = new IBusModelServerMethod[ subdictMethTableVisIdx.size() ];
			Iterator< BusModelBuffServerMethod > iter = subdictMethTableVisIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictMethTableVisIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByMethTableVisIdx.put( key, subdictMethTableVisIdx );
			recArray = new IBusModelServerMethod[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelServerMethod[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByDefSchemaIdx";
		BusModelBuffServerMethodByDefSchemaIdxKey key = (BusModelBuffServerMethodByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelServerMethod[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelServerMethod[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffServerMethod > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelServerMethod[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelServerMethod readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelServerMethod buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerMethod readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRec";
		IBusModelServerMethod buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelServerMethod.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerMethod lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelServerMethod buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelServerMethod.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerMethod[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamServerMethod.readAllRec";
		IBusModelServerMethod buff;
		ArrayList<IBusModelServerMethod> filteredList = new ArrayList<IBusModelServerMethod>();
		IBusModelServerMethod[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerMethod[0] ) );
	}

	@Override
	public IBusModelServerMethod readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelServerMethod buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelServerMethod)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerMethod[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelServerMethod buff;
		ArrayList<IBusModelServerMethod> filteredList = new ArrayList<IBusModelServerMethod>();
		IBusModelServerMethod[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerMethod)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerMethod[0] ) );
	}

	@Override
	public IBusModelServerMethod readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByUNameIdx() ";
		IBusModelServerMethod buff = readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
			return( (IBusModelServerMethod)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerMethod[] readRecByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethTableIdx() ";
		IBusModelServerMethod buff;
		ArrayList<IBusModelServerMethod> filteredList = new ArrayList<IBusModelServerMethod>();
		IBusModelServerMethod[] buffList = readDerivedByMethTableIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerMethod)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerMethod[0] ) );
	}

	@Override
	public IBusModelServerMethod[] readRecByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethCodeVisIdx() ";
		IBusModelServerMethod buff;
		ArrayList<IBusModelServerMethod> filteredList = new ArrayList<IBusModelServerMethod>();
		IBusModelServerMethod[] buffList = readDerivedByMethCodeVisIdx( Authorization,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerMethod)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerMethod[0] ) );
	}

	@Override
	public IBusModelServerMethod[] readRecByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethTableVisIdx() ";
		IBusModelServerMethod buff;
		ArrayList<IBusModelServerMethod> filteredList = new ArrayList<IBusModelServerMethod>();
		IBusModelServerMethod[] buffList = readDerivedByMethTableVisIdx( Authorization,
			TableId,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerMethod)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerMethod[0] ) );
	}

	@Override
	public IBusModelServerMethod[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByDefSchemaIdx() ";
		IBusModelServerMethod buff;
		ArrayList<IBusModelServerMethod> filteredList = new ArrayList<IBusModelServerMethod>();
		IBusModelServerMethod[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerMethod)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerMethod[0] ) );
	}

	public IBusModelServerMethod updateServerMethod( ISecureAuthorization Authorization,
		IBusModelServerMethod iBuff )
	{
		BusModelBuffServerMethod Buff = (BusModelBuffServerMethod)(schema.getTableScope().updateScope( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffServerMethod existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateServerMethod",
				"Existing record not found",
				"Existing record not found",
				"ServerMethod",
				"ServerMethod",
				pkey );
		}
		BusModelBuffServerMethodByUNameIdxKey existingKeyUNameIdx = (BusModelBuffServerMethodByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffServerMethodByUNameIdxKey newKeyUNameIdx = (BusModelBuffServerMethodByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffServerMethodByMethTableIdxKey existingKeyMethTableIdx = (BusModelBuffServerMethodByMethTableIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableIdxKey();
		existingKeyMethTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffServerMethodByMethTableIdxKey newKeyMethTableIdx = (BusModelBuffServerMethodByMethTableIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableIdxKey();
		newKeyMethTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffServerMethodByMethCodeVisIdxKey existingKeyMethCodeVisIdx = (BusModelBuffServerMethodByMethCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		existingKeyMethCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffServerMethodByMethCodeVisIdxKey newKeyMethCodeVisIdx = (BusModelBuffServerMethodByMethCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		newKeyMethCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffServerMethodByMethTableVisIdxKey existingKeyMethTableVisIdx = (BusModelBuffServerMethodByMethTableVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		existingKeyMethTableVisIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyMethTableVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffServerMethodByMethTableVisIdxKey newKeyMethTableVisIdx = (BusModelBuffServerMethodByMethTableVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		newKeyMethTableVisIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyMethTableVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffServerMethodByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffServerMethodByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffServerMethodByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffServerMethodByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateServerMethod",
					"ServerMethodUNameIdx",
					"ServerMethodUNameIdx",
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
						"updateServerMethod",
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
						"updateServerMethod",
						"Container",
						"Container",
						"ForTable",
						"ForTable",
						"Table",
						"Table",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByMethTableIdx.get( existingKeyMethTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByMethTableIdx.containsKey( newKeyMethTableIdx ) ) {
			subdict = dictByMethTableIdx.get( newKeyMethTableIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByMethTableIdx.put( newKeyMethTableIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByMethCodeVisIdx.get( existingKeyMethCodeVisIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByMethCodeVisIdx.containsKey( newKeyMethCodeVisIdx ) ) {
			subdict = dictByMethCodeVisIdx.get( newKeyMethCodeVisIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByMethCodeVisIdx.put( newKeyMethCodeVisIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByMethTableVisIdx.get( existingKeyMethTableVisIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByMethTableVisIdx.containsKey( newKeyMethTableVisIdx ) ) {
			subdict = dictByMethTableVisIdx.get( newKeyMethTableVisIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByMethTableVisIdx.put( newKeyMethTableVisIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteServerMethod( ISecureAuthorization Authorization,
		IBusModelServerMethod iBuff )
	{
		final String S_ProcName = "BusModelRamServerMethodTable.deleteServerMethod() ";
		BusModelBuffServerMethod Buff = (BusModelBuffServerMethod)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffServerMethod existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteServerMethod",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckParams[] = schema.getTableParam().readDerivedByServerMethodIdx( Authorization,
						existing.getRequiredId() );
		if( arrCheckParams.length > 0 ) {
			schema.getTableParam().deleteParamByServerMethodIdx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffServerMethodByUNameIdxKey keyUNameIdx = (BusModelBuffServerMethodByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffServerMethodByMethTableIdxKey keyMethTableIdx = (BusModelBuffServerMethodByMethTableIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableIdxKey();
		keyMethTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx = (BusModelBuffServerMethodByMethCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		keyMethCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffServerMethodByMethTableVisIdxKey keyMethTableVisIdx = (BusModelBuffServerMethodByMethTableVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		keyMethTableVisIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyMethTableVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffServerMethodByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffServerMethodByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		// Validate reverse foreign keys

		if( schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteServerMethod",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"ServerObjFunc",
				"ServerObjFunc",
				pkey );
		}

		if( schema.getTableServerProc().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteServerMethod",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"ServerProc",
				"ServerProc",
				pkey );
		}

		if( schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
					existing.getRequiredId() ) != null )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteServerMethod",
				"Superclass",
				"Superclass",
				"SuperClass",
				"SuperClass",
				"ServerListFunc",
				"ServerListFunc",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerMethod > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByMethTableIdx.get( keyMethTableIdx );
		subdict.remove( pkey );

		subdict = dictByMethCodeVisIdx.get( keyMethCodeVisIdx );
		subdict.remove( pkey );

		subdict = dictByMethTableVisIdx.get( keyMethTableVisIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}
	@Override
	public void deleteServerMethodByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		BusModelBuffServerMethodByUNameIdxKey key = (BusModelBuffServerMethodByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteServerMethodByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteServerMethodByUNameIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByUNameIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByUNameIdx";
		BusModelBuffServerMethod cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerMethod> matchSet = new LinkedList<BusModelBuffServerMethod>();
		Iterator<BusModelBuffServerMethod> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerMethod> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerMethod)(schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelServerMethod.CLASS_CODE == subClassCode ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteServerMethodByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffServerMethodByMethTableIdxKey key = (BusModelBuffServerMethodByMethTableIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( argTableId );
		deleteServerMethodByMethTableIdx( Authorization, key );
	}

	@Override
	public void deleteServerMethodByMethTableIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByMethTableIdx";
		BusModelBuffServerMethod cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerMethod> matchSet = new LinkedList<BusModelBuffServerMethod>();
		Iterator<BusModelBuffServerMethod> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerMethod> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerMethod)(schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelServerMethod.CLASS_CODE == subClassCode ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteServerMethodByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffServerMethodByMethCodeVisIdxKey key = (BusModelBuffServerMethodByMethCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( argCodeVis );
		deleteServerMethodByMethCodeVisIdx( Authorization, key );
	}

	@Override
	public void deleteServerMethodByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethCodeVisIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByMethCodeVisIdx";
		BusModelBuffServerMethod cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerMethod> matchSet = new LinkedList<BusModelBuffServerMethod>();
		Iterator<BusModelBuffServerMethod> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerMethod> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerMethod)(schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelServerMethod.CLASS_CODE == subClassCode ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteServerMethodByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffServerMethodByMethTableVisIdxKey key = (BusModelBuffServerMethodByMethTableVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredCodeVis( argCodeVis );
		deleteServerMethodByMethTableVisIdx( Authorization, key );
	}

	@Override
	public void deleteServerMethodByMethTableVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableVisIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByMethTableVisIdx";
		BusModelBuffServerMethod cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerMethod> matchSet = new LinkedList<BusModelBuffServerMethod>();
		Iterator<BusModelBuffServerMethod> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerMethod> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerMethod)(schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelServerMethod.CLASS_CODE == subClassCode ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteServerMethodByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffServerMethodByDefSchemaIdxKey key = (BusModelBuffServerMethodByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteServerMethodByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteServerMethodByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByDefSchemaIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByDefSchemaIdx";
		BusModelBuffServerMethod cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerMethod> matchSet = new LinkedList<BusModelBuffServerMethod>();
		Iterator<BusModelBuffServerMethod> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerMethod> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerMethod)(schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelServerMethod.CLASS_CODE == subClassCode ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteServerMethodByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		final String S_ProcName = "deleteServerMethodByIdIdx";
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffServerMethod cur;
		LinkedList<BusModelBuffServerMethod> matchSet = new LinkedList<BusModelBuffServerMethod>();
		Iterator<BusModelBuffServerMethod> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerMethod> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerMethod)(schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelServerMethod.CLASS_CODE == subClassCode ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}

	@Override
	public void deleteServerMethodByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteServerMethodByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteServerMethodByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		final String S_ProcName = "deleteServerMethodByTenantIdx";
		BusModelBuffServerMethod cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerMethod> matchSet = new LinkedList<BusModelBuffServerMethod>();
		Iterator<BusModelBuffServerMethod> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerMethod> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerMethod)(schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			int subClassCode = cur.getClassCode();
			if( IBusModelServerMethod.CLASS_CODE == subClassCode ) {
				schema.getTableServerMethod().deleteServerMethod( Authorization, cur );
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
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-by-suffix-class-walker-", (Integer)subClassCode, "Classcode not recognized: " + Integer.toString(subClassCode));
			}
		}
	}
}
