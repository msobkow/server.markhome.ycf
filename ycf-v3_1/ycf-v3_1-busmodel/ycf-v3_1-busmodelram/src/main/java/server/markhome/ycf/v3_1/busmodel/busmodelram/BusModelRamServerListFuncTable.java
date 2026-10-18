
// Description: Java 25 in-memory RAM DbIO implementation for ServerListFunc.

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
 *	BusModelRamServerListFuncTable in-memory RAM DbIO implementation
 *	for ServerListFunc.
 */
public class BusModelRamServerListFuncTable
	implements IBusModelServerListFuncTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffServerListFunc > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffServerListFunc >();
	private Map< BusModelBuffServerListFuncByRetTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerListFunc >> dictByRetTblIdx
		= new HashMap< BusModelBuffServerListFuncByRetTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerListFunc >>();

	public BusModelRamServerListFuncTable( IBusModelSchema argSchema ) {
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
	public IBusModelServerListFunc createServerListFunc( ISecureAuthorization Authorization,
		IBusModelServerListFunc iBuff )
	{
		final String S_ProcName = "createServerListFunc";
		
		BusModelBuffServerListFunc Buff = (BusModelBuffServerListFunc)(schema.getTableServerMethod().createServerMethod( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffServerListFuncByRetTblIdxKey keyRetTblIdx = (BusModelBuffServerListFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerListFunc().newByRetTblIdxKey();
		keyRetTblIdx.setOptionalRetTableId( Buff.getOptionalRetTableId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"ServerMethod",
						"ServerMethod",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerListFunc > subdictRetTblIdx;
		if( dictByRetTblIdx.containsKey( keyRetTblIdx ) ) {
			subdictRetTblIdx = dictByRetTblIdx.get( keyRetTblIdx );
		}
		else {
			subdictRetTblIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerListFunc >();
			dictByRetTblIdx.put( keyRetTblIdx, subdictRetTblIdx );
		}
		subdictRetTblIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelServerListFunc.CLASS_CODE) {
				BusModelBuffServerListFunc retbuff = ((BusModelBuffServerListFunc)(schema.getBusModelBuffFactory().getFactoryServerListFunc().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelServerListFunc readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerListFunc.readDerived";
		IBusModelServerListFunc buff;
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
	public IBusModelServerListFunc lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerListFunc.lockDerived";
		IBusModelServerListFunc buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerListFunc[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamServerListFunc.readAllDerived";
		IBusModelServerListFunc[] retList = new IBusModelServerListFunc[ dictByPKey.values().size() ];
		Iterator< BusModelBuffServerListFunc > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelServerListFunc[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerListFunc ) ) {
					filteredList.add( (IBusModelServerListFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerListFunc readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByUNameIdx";
		IBusModelServerMethod buff = schema.getTableServerMethod().readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof IBusModelServerListFunc ) {
			return( (IBusModelServerListFunc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerListFunc[] readDerivedByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByMethTableIdx";
		IBusModelServerMethod buffList[] = schema.getTableServerMethod().readDerivedByMethTableIdx( Authorization,
			TableId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelServerMethod buff;
			ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerListFunc ) ) {
					filteredList.add( (IBusModelServerListFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerListFunc[] readDerivedByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByMethCodeVisIdx";
		IBusModelServerMethod buffList[] = schema.getTableServerMethod().readDerivedByMethCodeVisIdx( Authorization,
			CodeVis );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelServerMethod buff;
			ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerListFunc ) ) {
					filteredList.add( (IBusModelServerListFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerListFunc[] readDerivedByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByMethTableVisIdx";
		IBusModelServerMethod buffList[] = schema.getTableServerMethod().readDerivedByMethTableVisIdx( Authorization,
			TableId,
			CodeVis );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelServerMethod buff;
			ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerListFunc ) ) {
					filteredList.add( (IBusModelServerListFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerListFunc[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readDerivedByDefSchemaIdx";
		IBusModelServerMethod buffList[] = schema.getTableServerMethod().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelServerMethod buff;
			ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerListFunc ) ) {
					filteredList.add( (IBusModelServerListFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerListFunc[] readDerivedByRetTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RetTableId )
	{
		final String S_ProcName = "BusModelRamServerListFunc.readDerivedByRetTblIdx";
		BusModelBuffServerListFuncByRetTblIdxKey key = (BusModelBuffServerListFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerListFunc().newByRetTblIdxKey();

		key.setOptionalRetTableId( RetTableId );
		IBusModelServerListFunc[] recArray;
		if( dictByRetTblIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerListFunc > subdictRetTblIdx
				= dictByRetTblIdx.get( key );
			recArray = new IBusModelServerListFunc[ subdictRetTblIdx.size() ];
			Iterator< BusModelBuffServerListFunc > iter = subdictRetTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerListFunc > subdictRetTblIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerListFunc >();
			dictByRetTblIdx.put( key, subdictRetTblIdx );
			recArray = new IBusModelServerListFunc[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelServerListFunc readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelServerListFunc buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerListFunc readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerListFunc.readRec";
		IBusModelServerListFunc buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelServerListFunc.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerListFunc lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelServerListFunc buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelServerListFunc.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerListFunc[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamServerListFunc.readAllRec";
		IBusModelServerListFunc buff;
		ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
		IBusModelServerListFunc[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerListFunc.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
	}

	@Override
	public IBusModelServerListFunc readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelServerListFunc buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelServerListFunc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerListFunc[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelServerListFunc buff;
		ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
		IBusModelServerListFunc[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerListFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
	}

	@Override
	public IBusModelServerListFunc readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByUNameIdx() ";
		IBusModelServerListFunc buff = readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
			return( (IBusModelServerListFunc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerListFunc[] readRecByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethTableIdx() ";
		IBusModelServerListFunc buff;
		ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
		IBusModelServerListFunc[] buffList = readDerivedByMethTableIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerListFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
	}

	@Override
	public IBusModelServerListFunc[] readRecByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethCodeVisIdx() ";
		IBusModelServerListFunc buff;
		ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
		IBusModelServerListFunc[] buffList = readDerivedByMethCodeVisIdx( Authorization,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerListFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
	}

	@Override
	public IBusModelServerListFunc[] readRecByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethTableVisIdx() ";
		IBusModelServerListFunc buff;
		ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
		IBusModelServerListFunc[] buffList = readDerivedByMethTableVisIdx( Authorization,
			TableId,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerListFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
	}

	@Override
	public IBusModelServerListFunc[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByDefSchemaIdx() ";
		IBusModelServerListFunc buff;
		ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
		IBusModelServerListFunc[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerListFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
	}

	@Override
	public IBusModelServerListFunc[] readRecByRetTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RetTableId )
	{
		final String S_ProcName = "BusModelRamServerListFunc.readRecByRetTblIdx() ";
		IBusModelServerListFunc buff;
		ArrayList<IBusModelServerListFunc> filteredList = new ArrayList<IBusModelServerListFunc>();
		IBusModelServerListFunc[] buffList = readDerivedByRetTblIdx( Authorization,
			RetTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerListFunc.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerListFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerListFunc[0] ) );
	}

	public IBusModelServerListFunc updateServerListFunc( ISecureAuthorization Authorization,
		IBusModelServerListFunc iBuff )
	{
		BusModelBuffServerListFunc Buff = (BusModelBuffServerListFunc)(schema.getTableServerMethod().updateServerMethod( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffServerListFunc existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateServerListFunc",
				"Existing record not found",
				"Existing record not found",
				"ServerListFunc",
				"ServerListFunc",
				pkey );
		}
		BusModelBuffServerListFuncByRetTblIdxKey existingKeyRetTblIdx = (BusModelBuffServerListFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerListFunc().newByRetTblIdxKey();
		existingKeyRetTblIdx.setOptionalRetTableId( existing.getOptionalRetTableId() );

		BusModelBuffServerListFuncByRetTblIdxKey newKeyRetTblIdx = (BusModelBuffServerListFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerListFunc().newByRetTblIdxKey();
		newKeyRetTblIdx.setOptionalRetTableId( Buff.getOptionalRetTableId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateServerListFunc",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"ServerMethod",
						"ServerMethod",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerListFunc > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByRetTblIdx.get( existingKeyRetTblIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRetTblIdx.containsKey( newKeyRetTblIdx ) ) {
			subdict = dictByRetTblIdx.get( newKeyRetTblIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerListFunc >();
			dictByRetTblIdx.put( newKeyRetTblIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteServerListFunc( ISecureAuthorization Authorization,
		IBusModelServerListFunc iBuff )
	{
		final String S_ProcName = "BusModelRamServerListFuncTable.deleteServerListFunc() ";
		BusModelBuffServerListFunc Buff = (BusModelBuffServerListFunc)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffServerListFunc existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteServerListFunc",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckParams[] = schema.getTableParam().readDerivedByServerMethodIdx( Authorization,
						existing.getRequiredId() );
		if( arrCheckParams.length > 0 ) {
			schema.getTableParam().deleteParamByServerMethodIdx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffServerListFuncByRetTblIdxKey keyRetTblIdx = (BusModelBuffServerListFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerListFunc().newByRetTblIdxKey();
		keyRetTblIdx.setOptionalRetTableId( existing.getOptionalRetTableId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerListFunc > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByRetTblIdx.get( keyRetTblIdx );
		subdict.remove( pkey );

		schema.getTableServerMethod().deleteServerMethod( Authorization,
			Buff );
	}
	@Override
	public void deleteServerListFuncByRetTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRetTableId )
	{
		BusModelBuffServerListFuncByRetTblIdxKey key = (BusModelBuffServerListFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerListFunc().newByRetTblIdxKey();
		key.setOptionalRetTableId( argRetTableId );
		deleteServerListFuncByRetTblIdx( Authorization, key );
	}

	@Override
	public void deleteServerListFuncByRetTblIdx( ISecureAuthorization Authorization,
		IBusModelServerListFuncByRetTblIdxKey argKey )
	{
		BusModelBuffServerListFunc cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalRetTableId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerListFunc> matchSet = new LinkedList<BusModelBuffServerListFunc>();
		Iterator<BusModelBuffServerListFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerListFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerListFunc)(schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerListFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerListFuncByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		BusModelBuffServerMethodByUNameIdxKey key = (BusModelBuffServerMethodByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteServerListFuncByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteServerListFuncByUNameIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByUNameIdxKey argKey )
	{
		BusModelBuffServerListFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerListFunc> matchSet = new LinkedList<BusModelBuffServerListFunc>();
		Iterator<BusModelBuffServerListFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerListFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerListFunc)(schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerListFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerListFuncByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffServerMethodByMethTableIdxKey key = (BusModelBuffServerMethodByMethTableIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( argTableId );
		deleteServerListFuncByMethTableIdx( Authorization, key );
	}

	@Override
	public void deleteServerListFuncByMethTableIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableIdxKey argKey )
	{
		BusModelBuffServerListFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerListFunc> matchSet = new LinkedList<BusModelBuffServerListFunc>();
		Iterator<BusModelBuffServerListFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerListFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerListFunc)(schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerListFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerListFuncByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffServerMethodByMethCodeVisIdxKey key = (BusModelBuffServerMethodByMethCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( argCodeVis );
		deleteServerListFuncByMethCodeVisIdx( Authorization, key );
	}

	@Override
	public void deleteServerListFuncByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethCodeVisIdxKey argKey )
	{
		BusModelBuffServerListFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerListFunc> matchSet = new LinkedList<BusModelBuffServerListFunc>();
		Iterator<BusModelBuffServerListFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerListFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerListFunc)(schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerListFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerListFuncByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffServerMethodByMethTableVisIdxKey key = (BusModelBuffServerMethodByMethTableVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredCodeVis( argCodeVis );
		deleteServerListFuncByMethTableVisIdx( Authorization, key );
	}

	@Override
	public void deleteServerListFuncByMethTableVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableVisIdxKey argKey )
	{
		BusModelBuffServerListFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerListFunc> matchSet = new LinkedList<BusModelBuffServerListFunc>();
		Iterator<BusModelBuffServerListFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerListFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerListFunc)(schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerListFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerListFuncByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffServerMethodByDefSchemaIdxKey key = (BusModelBuffServerMethodByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteServerListFuncByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteServerListFuncByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByDefSchemaIdxKey argKey )
	{
		BusModelBuffServerListFunc cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerListFunc> matchSet = new LinkedList<BusModelBuffServerListFunc>();
		Iterator<BusModelBuffServerListFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerListFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerListFunc)(schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerListFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerListFuncByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffServerListFunc cur;
		LinkedList<BusModelBuffServerListFunc> matchSet = new LinkedList<BusModelBuffServerListFunc>();
		Iterator<BusModelBuffServerListFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerListFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerListFunc)(schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerListFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerListFuncByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteServerListFuncByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteServerListFuncByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffServerListFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerListFunc> matchSet = new LinkedList<BusModelBuffServerListFunc>();
		Iterator<BusModelBuffServerListFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerListFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerListFunc)(schema.getTableServerListFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerListFunc( Authorization, cur );
		}
	}
}
