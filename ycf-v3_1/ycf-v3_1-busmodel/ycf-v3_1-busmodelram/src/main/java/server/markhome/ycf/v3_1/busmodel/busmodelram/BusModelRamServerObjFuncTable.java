
// Description: Java 25 in-memory RAM DbIO implementation for ServerObjFunc.

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
 *	BusModelRamServerObjFuncTable in-memory RAM DbIO implementation
 *	for ServerObjFunc.
 */
public class BusModelRamServerObjFuncTable
	implements IBusModelServerObjFuncTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffServerObjFunc > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffServerObjFunc >();
	private Map< BusModelBuffServerObjFuncByRetTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerObjFunc >> dictByRetTblIdx
		= new HashMap< BusModelBuffServerObjFuncByRetTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffServerObjFunc >>();

	public BusModelRamServerObjFuncTable( IBusModelSchema argSchema ) {
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
	public IBusModelServerObjFunc createServerObjFunc( ISecureAuthorization Authorization,
		IBusModelServerObjFunc iBuff )
	{
		final String S_ProcName = "createServerObjFunc";
		
		BusModelBuffServerObjFunc Buff = (BusModelBuffServerObjFunc)(schema.getTableServerMethod().createServerMethod( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffServerObjFuncByRetTblIdxKey keyRetTblIdx = (BusModelBuffServerObjFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerObjFunc > subdictRetTblIdx;
		if( dictByRetTblIdx.containsKey( keyRetTblIdx ) ) {
			subdictRetTblIdx = dictByRetTblIdx.get( keyRetTblIdx );
		}
		else {
			subdictRetTblIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerObjFunc >();
			dictByRetTblIdx.put( keyRetTblIdx, subdictRetTblIdx );
		}
		subdictRetTblIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelServerObjFunc.CLASS_CODE) {
				BusModelBuffServerObjFunc retbuff = ((BusModelBuffServerObjFunc)(schema.getBusModelBuffFactory().getFactoryServerObjFunc().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelServerObjFunc readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerObjFunc.readDerived";
		IBusModelServerObjFunc buff;
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
	public IBusModelServerObjFunc lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerObjFunc.lockDerived";
		IBusModelServerObjFunc buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerObjFunc[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamServerObjFunc.readAllDerived";
		IBusModelServerObjFunc[] retList = new IBusModelServerObjFunc[ dictByPKey.values().size() ];
		Iterator< BusModelBuffServerObjFunc > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelServerObjFunc[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerObjFunc ) ) {
					filteredList.add( (IBusModelServerObjFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerObjFunc readDerivedByUNameIdx( ISecureAuthorization Authorization,
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
		else if( buff instanceof IBusModelServerObjFunc ) {
			return( (IBusModelServerObjFunc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerObjFunc[] readDerivedByMethTableIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerObjFunc ) ) {
					filteredList.add( (IBusModelServerObjFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerObjFunc[] readDerivedByMethCodeVisIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerObjFunc ) ) {
					filteredList.add( (IBusModelServerObjFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerObjFunc[] readDerivedByMethTableVisIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerObjFunc ) ) {
					filteredList.add( (IBusModelServerObjFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerObjFunc[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerObjFunc ) ) {
					filteredList.add( (IBusModelServerObjFunc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
		}
	}

	@Override
	public IBusModelServerObjFunc[] readDerivedByRetTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RetTableId )
	{
		final String S_ProcName = "BusModelRamServerObjFunc.readDerivedByRetTblIdx";
		BusModelBuffServerObjFuncByRetTblIdxKey key = (BusModelBuffServerObjFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerObjFunc().newByRetTblIdxKey();

		key.setOptionalRetTableId( RetTableId );
		IBusModelServerObjFunc[] recArray;
		if( dictByRetTblIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerObjFunc > subdictRetTblIdx
				= dictByRetTblIdx.get( key );
			recArray = new IBusModelServerObjFunc[ subdictRetTblIdx.size() ];
			Iterator< BusModelBuffServerObjFunc > iter = subdictRetTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffServerObjFunc > subdictRetTblIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerObjFunc >();
			dictByRetTblIdx.put( key, subdictRetTblIdx );
			recArray = new IBusModelServerObjFunc[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelServerObjFunc readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelServerObjFunc buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerObjFunc readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerObjFunc.readRec";
		IBusModelServerObjFunc buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelServerObjFunc.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerObjFunc lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelServerObjFunc buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelServerObjFunc.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerObjFunc[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamServerObjFunc.readAllRec";
		IBusModelServerObjFunc buff;
		ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
		IBusModelServerObjFunc[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerObjFunc.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
	}

	@Override
	public IBusModelServerObjFunc readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelServerObjFunc buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelServerObjFunc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerObjFunc[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelServerObjFunc buff;
		ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
		IBusModelServerObjFunc[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerObjFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
	}

	@Override
	public IBusModelServerObjFunc readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByUNameIdx() ";
		IBusModelServerObjFunc buff = readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
			return( (IBusModelServerObjFunc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerObjFunc[] readRecByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethTableIdx() ";
		IBusModelServerObjFunc buff;
		ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
		IBusModelServerObjFunc[] buffList = readDerivedByMethTableIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerObjFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
	}

	@Override
	public IBusModelServerObjFunc[] readRecByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethCodeVisIdx() ";
		IBusModelServerObjFunc buff;
		ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
		IBusModelServerObjFunc[] buffList = readDerivedByMethCodeVisIdx( Authorization,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerObjFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
	}

	@Override
	public IBusModelServerObjFunc[] readRecByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethTableVisIdx() ";
		IBusModelServerObjFunc buff;
		ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
		IBusModelServerObjFunc[] buffList = readDerivedByMethTableVisIdx( Authorization,
			TableId,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerObjFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
	}

	@Override
	public IBusModelServerObjFunc[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByDefSchemaIdx() ";
		IBusModelServerObjFunc buff;
		ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
		IBusModelServerObjFunc[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerObjFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
	}

	@Override
	public IBusModelServerObjFunc[] readRecByRetTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RetTableId )
	{
		final String S_ProcName = "BusModelRamServerObjFunc.readRecByRetTblIdx() ";
		IBusModelServerObjFunc buff;
		ArrayList<IBusModelServerObjFunc> filteredList = new ArrayList<IBusModelServerObjFunc>();
		IBusModelServerObjFunc[] buffList = readDerivedByRetTblIdx( Authorization,
			RetTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerObjFunc.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerObjFunc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerObjFunc[0] ) );
	}

	public IBusModelServerObjFunc updateServerObjFunc( ISecureAuthorization Authorization,
		IBusModelServerObjFunc iBuff )
	{
		BusModelBuffServerObjFunc Buff = (BusModelBuffServerObjFunc)(schema.getTableServerMethod().updateServerMethod( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffServerObjFunc existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateServerObjFunc",
				"Existing record not found",
				"Existing record not found",
				"ServerObjFunc",
				"ServerObjFunc",
				pkey );
		}
		BusModelBuffServerObjFuncByRetTblIdxKey existingKeyRetTblIdx = (BusModelBuffServerObjFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
		existingKeyRetTblIdx.setOptionalRetTableId( existing.getOptionalRetTableId() );

		BusModelBuffServerObjFuncByRetTblIdxKey newKeyRetTblIdx = (BusModelBuffServerObjFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
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
						"updateServerObjFunc",
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerObjFunc > subdict;

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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffServerObjFunc >();
			dictByRetTblIdx.put( newKeyRetTblIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteServerObjFunc( ISecureAuthorization Authorization,
		IBusModelServerObjFunc iBuff )
	{
		final String S_ProcName = "BusModelRamServerObjFuncTable.deleteServerObjFunc() ";
		BusModelBuffServerObjFunc Buff = (BusModelBuffServerObjFunc)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffServerObjFunc existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteServerObjFunc",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckParams[] = schema.getTableParam().readDerivedByServerMethodIdx( Authorization,
						existing.getRequiredId() );
		if( arrCheckParams.length > 0 ) {
			schema.getTableParam().deleteParamByServerMethodIdx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffServerObjFuncByRetTblIdxKey keyRetTblIdx = (BusModelBuffServerObjFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
		keyRetTblIdx.setOptionalRetTableId( existing.getOptionalRetTableId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerObjFunc > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByRetTblIdx.get( keyRetTblIdx );
		subdict.remove( pkey );

		schema.getTableServerMethod().deleteServerMethod( Authorization,
			Buff );
	}
	@Override
	public void deleteServerObjFuncByRetTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRetTableId )
	{
		BusModelBuffServerObjFuncByRetTblIdxKey key = (BusModelBuffServerObjFuncByRetTblIdxKey)schema.getBusModelBuffFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
		key.setOptionalRetTableId( argRetTableId );
		deleteServerObjFuncByRetTblIdx( Authorization, key );
	}

	@Override
	public void deleteServerObjFuncByRetTblIdx( ISecureAuthorization Authorization,
		IBusModelServerObjFuncByRetTblIdxKey argKey )
	{
		BusModelBuffServerObjFunc cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalRetTableId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerObjFunc> matchSet = new LinkedList<BusModelBuffServerObjFunc>();
		Iterator<BusModelBuffServerObjFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerObjFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerObjFunc)(schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerObjFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerObjFuncByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		BusModelBuffServerMethodByUNameIdxKey key = (BusModelBuffServerMethodByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteServerObjFuncByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteServerObjFuncByUNameIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByUNameIdxKey argKey )
	{
		BusModelBuffServerObjFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerObjFunc> matchSet = new LinkedList<BusModelBuffServerObjFunc>();
		Iterator<BusModelBuffServerObjFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerObjFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerObjFunc)(schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerObjFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerObjFuncByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffServerMethodByMethTableIdxKey key = (BusModelBuffServerMethodByMethTableIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( argTableId );
		deleteServerObjFuncByMethTableIdx( Authorization, key );
	}

	@Override
	public void deleteServerObjFuncByMethTableIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableIdxKey argKey )
	{
		BusModelBuffServerObjFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerObjFunc> matchSet = new LinkedList<BusModelBuffServerObjFunc>();
		Iterator<BusModelBuffServerObjFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerObjFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerObjFunc)(schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerObjFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerObjFuncByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffServerMethodByMethCodeVisIdxKey key = (BusModelBuffServerMethodByMethCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( argCodeVis );
		deleteServerObjFuncByMethCodeVisIdx( Authorization, key );
	}

	@Override
	public void deleteServerObjFuncByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethCodeVisIdxKey argKey )
	{
		BusModelBuffServerObjFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerObjFunc> matchSet = new LinkedList<BusModelBuffServerObjFunc>();
		Iterator<BusModelBuffServerObjFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerObjFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerObjFunc)(schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerObjFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerObjFuncByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffServerMethodByMethTableVisIdxKey key = (BusModelBuffServerMethodByMethTableVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredCodeVis( argCodeVis );
		deleteServerObjFuncByMethTableVisIdx( Authorization, key );
	}

	@Override
	public void deleteServerObjFuncByMethTableVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableVisIdxKey argKey )
	{
		BusModelBuffServerObjFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerObjFunc> matchSet = new LinkedList<BusModelBuffServerObjFunc>();
		Iterator<BusModelBuffServerObjFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerObjFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerObjFunc)(schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerObjFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerObjFuncByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffServerMethodByDefSchemaIdxKey key = (BusModelBuffServerMethodByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteServerObjFuncByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteServerObjFuncByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByDefSchemaIdxKey argKey )
	{
		BusModelBuffServerObjFunc cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerObjFunc> matchSet = new LinkedList<BusModelBuffServerObjFunc>();
		Iterator<BusModelBuffServerObjFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerObjFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerObjFunc)(schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerObjFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerObjFuncByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffServerObjFunc cur;
		LinkedList<BusModelBuffServerObjFunc> matchSet = new LinkedList<BusModelBuffServerObjFunc>();
		Iterator<BusModelBuffServerObjFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerObjFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerObjFunc)(schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerObjFunc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerObjFuncByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteServerObjFuncByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteServerObjFuncByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffServerObjFunc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerObjFunc> matchSet = new LinkedList<BusModelBuffServerObjFunc>();
		Iterator<BusModelBuffServerObjFunc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerObjFunc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerObjFunc)(schema.getTableServerObjFunc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerObjFunc( Authorization, cur );
		}
	}
}
