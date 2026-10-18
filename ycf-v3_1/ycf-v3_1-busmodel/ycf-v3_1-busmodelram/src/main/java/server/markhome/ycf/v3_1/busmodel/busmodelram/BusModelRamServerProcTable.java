
// Description: Java 25 in-memory RAM DbIO implementation for ServerProc.

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
 *	BusModelRamServerProcTable in-memory RAM DbIO implementation
 *	for ServerProc.
 */
public class BusModelRamServerProcTable
	implements IBusModelServerProcTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffServerProc > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffServerProc >();

	public BusModelRamServerProcTable( IBusModelSchema argSchema ) {
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
	public IBusModelServerProc createServerProc( ISecureAuthorization Authorization,
		IBusModelServerProc iBuff )
	{
		final String S_ProcName = "createServerProc";
		
		BusModelBuffServerProc Buff = (BusModelBuffServerProc)(schema.getTableServerMethod().createServerMethod( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
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

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelServerProc.CLASS_CODE) {
				BusModelBuffServerProc retbuff = ((BusModelBuffServerProc)(schema.getBusModelBuffFactory().getFactoryServerProc().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelServerProc readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerProc.readDerived";
		IBusModelServerProc buff;
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
	public IBusModelServerProc lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerProc.lockDerived";
		IBusModelServerProc buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerProc[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamServerProc.readAllDerived";
		IBusModelServerProc[] retList = new IBusModelServerProc[ dictByPKey.values().size() ];
		Iterator< BusModelBuffServerProc > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelServerProc[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerProc ) ) {
					filteredList.add( (IBusModelServerProc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerProc[0] ) );
		}
	}

	@Override
	public IBusModelServerProc readDerivedByUNameIdx( ISecureAuthorization Authorization,
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
		else if( buff instanceof IBusModelServerProc ) {
			return( (IBusModelServerProc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerProc[] readDerivedByMethTableIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerProc ) ) {
					filteredList.add( (IBusModelServerProc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerProc[0] ) );
		}
	}

	@Override
	public IBusModelServerProc[] readDerivedByMethCodeVisIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerProc ) ) {
					filteredList.add( (IBusModelServerProc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerProc[0] ) );
		}
	}

	@Override
	public IBusModelServerProc[] readDerivedByMethTableVisIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerProc ) ) {
					filteredList.add( (IBusModelServerProc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerProc[0] ) );
		}
	}

	@Override
	public IBusModelServerProc[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelServerProc ) ) {
					filteredList.add( (IBusModelServerProc)buff );
				}
			}
			return( filteredList.toArray( new IBusModelServerProc[0] ) );
		}
	}

	@Override
	public IBusModelServerProc readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelServerProc buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerProc readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamServerProc.readRec";
		IBusModelServerProc buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelServerProc.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerProc lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelServerProc buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelServerProc.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelServerProc[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamServerProc.readAllRec";
		IBusModelServerProc buff;
		ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
		IBusModelServerProc[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerProc.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerProc[0] ) );
	}

	@Override
	public IBusModelServerProc readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelServerProc buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelServerProc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerProc[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelServerProc buff;
		ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
		IBusModelServerProc[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerProc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerProc[0] ) );
	}

	@Override
	public IBusModelServerProc readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByUNameIdx() ";
		IBusModelServerProc buff = readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
			return( (IBusModelServerProc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelServerProc[] readRecByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethTableIdx() ";
		IBusModelServerProc buff;
		ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
		IBusModelServerProc[] buffList = readDerivedByMethTableIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerProc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerProc[0] ) );
	}

	@Override
	public IBusModelServerProc[] readRecByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethCodeVisIdx() ";
		IBusModelServerProc buff;
		ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
		IBusModelServerProc[] buffList = readDerivedByMethCodeVisIdx( Authorization,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerProc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerProc[0] ) );
	}

	@Override
	public IBusModelServerProc[] readRecByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByMethTableVisIdx() ";
		IBusModelServerProc buff;
		ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
		IBusModelServerProc[] buffList = readDerivedByMethTableVisIdx( Authorization,
			TableId,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerProc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerProc[0] ) );
	}

	@Override
	public IBusModelServerProc[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamServerMethod.readRecByDefSchemaIdx() ";
		IBusModelServerProc buff;
		ArrayList<IBusModelServerProc> filteredList = new ArrayList<IBusModelServerProc>();
		IBusModelServerProc[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelServerMethod.CLASS_CODE ) ) {
				filteredList.add( (IBusModelServerProc)buff );
			}
		}
		return( filteredList.toArray( new IBusModelServerProc[0] ) );
	}

	public IBusModelServerProc updateServerProc( ISecureAuthorization Authorization,
		IBusModelServerProc iBuff )
	{
		BusModelBuffServerProc Buff = (BusModelBuffServerProc)(schema.getTableServerMethod().updateServerMethod( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffServerProc existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateServerProc",
				"Existing record not found",
				"Existing record not found",
				"ServerProc",
				"ServerProc",
				pkey );
		}
		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableServerMethod().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateServerProc",
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerProc > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteServerProc( ISecureAuthorization Authorization,
		IBusModelServerProc iBuff )
	{
		final String S_ProcName = "BusModelRamServerProcTable.deleteServerProc() ";
		BusModelBuffServerProc Buff = (BusModelBuffServerProc)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffServerProc existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteServerProc",
				pkey );
		}
					schema.getTableParam().deleteParamByServerMethodIdx( Authorization,
						existing.getRequiredId() );
		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffServerProc > subdict;

		dictByPKey.remove( pkey );

		schema.getTableServerMethod().deleteServerMethod( Authorization,
			Buff );
	}
	@Override
	public void deleteServerProcByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		BusModelBuffServerMethodByUNameIdxKey key = (BusModelBuffServerMethodByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteServerProcByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteServerProcByUNameIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByUNameIdxKey argKey )
	{
		BusModelBuffServerProc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerProc> matchSet = new LinkedList<BusModelBuffServerProc>();
		Iterator<BusModelBuffServerProc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerProc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerProc)(schema.getTableServerProc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerProc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerProcByMethTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffServerMethodByMethTableIdxKey key = (BusModelBuffServerMethodByMethTableIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( argTableId );
		deleteServerProcByMethTableIdx( Authorization, key );
	}

	@Override
	public void deleteServerProcByMethTableIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableIdxKey argKey )
	{
		BusModelBuffServerProc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerProc> matchSet = new LinkedList<BusModelBuffServerProc>();
		Iterator<BusModelBuffServerProc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerProc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerProc)(schema.getTableServerProc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerProc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerProcByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffServerMethodByMethCodeVisIdxKey key = (BusModelBuffServerMethodByMethCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( argCodeVis );
		deleteServerProcByMethCodeVisIdx( Authorization, key );
	}

	@Override
	public void deleteServerProcByMethCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethCodeVisIdxKey argKey )
	{
		BusModelBuffServerProc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerProc> matchSet = new LinkedList<BusModelBuffServerProc>();
		Iterator<BusModelBuffServerProc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerProc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerProc)(schema.getTableServerProc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerProc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerProcByMethTableVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffServerMethodByMethTableVisIdxKey key = (BusModelBuffServerMethodByMethTableVisIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredCodeVis( argCodeVis );
		deleteServerProcByMethTableVisIdx( Authorization, key );
	}

	@Override
	public void deleteServerProcByMethTableVisIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByMethTableVisIdxKey argKey )
	{
		BusModelBuffServerProc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerProc> matchSet = new LinkedList<BusModelBuffServerProc>();
		Iterator<BusModelBuffServerProc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerProc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerProc)(schema.getTableServerProc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerProc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerProcByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffServerMethodByDefSchemaIdxKey key = (BusModelBuffServerMethodByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteServerProcByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteServerProcByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelServerMethodByDefSchemaIdxKey argKey )
	{
		BusModelBuffServerProc cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerProc> matchSet = new LinkedList<BusModelBuffServerProc>();
		Iterator<BusModelBuffServerProc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerProc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerProc)(schema.getTableServerProc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerProc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerProcByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffServerProc cur;
		LinkedList<BusModelBuffServerProc> matchSet = new LinkedList<BusModelBuffServerProc>();
		Iterator<BusModelBuffServerProc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerProc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerProc)(schema.getTableServerProc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerProc( Authorization, cur );
		}
	}

	@Override
	public void deleteServerProcByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteServerProcByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteServerProcByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffServerProc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffServerProc> matchSet = new LinkedList<BusModelBuffServerProc>();
		Iterator<BusModelBuffServerProc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffServerProc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffServerProc)(schema.getTableServerProc().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteServerProc( Authorization, cur );
		}
	}
}
