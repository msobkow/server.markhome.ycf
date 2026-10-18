
// Description: Java 25 in-memory RAM DbIO implementation for ClearTopDep.

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
 *	BusModelRamClearTopDepTable in-memory RAM DbIO implementation
 *	for ClearTopDep.
 */
public class BusModelRamClearTopDepTable
	implements IBusModelClearTopDepTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffClearTopDep > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffClearTopDep >();
	private Map< BusModelBuffClearTopDepByClrTopDepTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearTopDep >> dictByClrTopDepTblIdx
		= new HashMap< BusModelBuffClearTopDepByClrTopDepTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearTopDep >>();
	private Map< BusModelBuffClearTopDepByUNameIdxKey,
			BusModelBuffClearTopDep > dictByUNameIdx
		= new HashMap< BusModelBuffClearTopDepByUNameIdxKey,
			BusModelBuffClearTopDep >();
	private Map< BusModelBuffClearTopDepByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearTopDep >> dictByPrevIdx
		= new HashMap< BusModelBuffClearTopDepByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearTopDep >>();
	private Map< BusModelBuffClearTopDepByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearTopDep >> dictByNextIdx
		= new HashMap< BusModelBuffClearTopDepByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffClearTopDep >>();

	public BusModelRamClearTopDepTable( IBusModelSchema argSchema ) {
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
	public IBusModelClearTopDep createClearTopDep( ISecureAuthorization Authorization,
		IBusModelClearTopDep iBuff )
	{
		final String S_ProcName = "createClearTopDep";
		
		BusModelBuffClearTopDep Buff = (BusModelBuffClearTopDep)(schema.getTableClearDep().createClearDep( Authorization,
			iBuff ));
		IBusModelClearTopDep tail = null;
		if( Buff.getClassCode() == IBusModelClearTopDep.CLASS_CODE ) {
			IBusModelClearTopDep[] siblings = schema.getTableClearTopDep().readDerivedByClrTopDepTblIdx( Authorization,
				Buff.getRequiredTableId() );
			for( int idx = 0; ( tail == null ) && ( idx < siblings.length ); idx ++ ) {
				if( ( siblings[idx].getOptionalNextId() == null ) )
				{
					tail = siblings[idx];
				}
			}
			if( tail != null ) {
				Buff.setOptionalLookupPrev(tail.getRequiredId());
			}
			else {
				Buff.setOptionalLookupPrev((IYCFKeyHash256)null);
			}
		}
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx = (BusModelBuffClearTopDepByClrTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
		keyClrTopDepTblIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffClearTopDepByUNameIdxKey keyUNameIdx = (BusModelBuffClearTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffClearTopDepByPrevIdxKey keyPrevIdx = (BusModelBuffClearTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffClearTopDepByNextIdxKey keyNextIdx = (BusModelBuffClearTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ClearTopDepUNameIdx",
				"ClearTopDepUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableClearDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"ClearDep",
						"ClearDep",
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdictClrTopDepTblIdx;
		if( dictByClrTopDepTblIdx.containsKey( keyClrTopDepTblIdx ) ) {
			subdictClrTopDepTblIdx = dictByClrTopDepTblIdx.get( keyClrTopDepTblIdx );
		}
		else {
			subdictClrTopDepTblIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep >();
			dictByClrTopDepTblIdx.put( keyClrTopDepTblIdx, subdictClrTopDepTblIdx );
		}
		subdictClrTopDepTblIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		if( tail != null ) {
			int tailClassCode = tail.getClassCode();
			if( tailClassCode == IBusModelClearTopDep.CLASS_CODE ) {
				IBusModelClearTopDep tailEdit = schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec();
				tailEdit.set( (IBusModelClearTopDep)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableClearTopDep().updateClearTopDep( Authorization, tailEdit );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-table-chain-link-tail-", (Integer)tailClassCode, "Classcode not recognized: " + Integer.toString(tailClassCode));
			}
		}
		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelClearTopDep.CLASS_CODE) {
				BusModelBuffClearTopDep retbuff = ((BusModelBuffClearTopDep)(schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelClearTopDep readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readDerived";
		IBusModelClearTopDep buff;
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
	public IBusModelClearTopDep lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearTopDep.lockDerived";
		IBusModelClearTopDep buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearTopDep[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamClearTopDep.readAllDerived";
		IBusModelClearTopDep[] retList = new IBusModelClearTopDep[ dictByPKey.values().size() ];
		Iterator< BusModelBuffClearTopDep > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelClearTopDep[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearTopDep ) ) {
					filteredList.add( (IBusModelClearTopDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
		}
	}

	@Override
	public IBusModelClearTopDep[] readDerivedByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamClearDep.readDerivedByClearDepIdx";
		IBusModelClearDep buffList[] = schema.getTableClearDep().readDerivedByClearDepIdx( Authorization,
			RelationId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelClearDep buff;
			ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearTopDep ) ) {
					filteredList.add( (IBusModelClearTopDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
		}
	}

	@Override
	public IBusModelClearTopDep[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamClearDep.readDerivedByDefSchemaIdx";
		IBusModelClearDep buffList[] = schema.getTableClearDep().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelClearDep buff;
			ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelClearTopDep ) ) {
					filteredList.add( (IBusModelClearTopDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
		}
	}

	@Override
	public IBusModelClearTopDep[] readDerivedByClrTopDepTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readDerivedByClrTopDepTblIdx";
		BusModelBuffClearTopDepByClrTopDepTblIdxKey key = (BusModelBuffClearTopDepByClrTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();

		key.setRequiredTableId( TableId );
		IBusModelClearTopDep[] recArray;
		if( dictByClrTopDepTblIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdictClrTopDepTblIdx
				= dictByClrTopDepTblIdx.get( key );
			recArray = new IBusModelClearTopDep[ subdictClrTopDepTblIdx.size() ];
			Iterator< BusModelBuffClearTopDep > iter = subdictClrTopDepTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdictClrTopDepTblIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep >();
			dictByClrTopDepTblIdx.put( key, subdictClrTopDepTblIdx );
			recArray = new IBusModelClearTopDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelClearTopDep readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readDerivedByUNameIdx";
		BusModelBuffClearTopDepByUNameIdxKey key = (BusModelBuffClearTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByUNameIdxKey();

		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelClearTopDep buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearTopDep[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readDerivedByPrevIdx";
		BusModelBuffClearTopDepByPrevIdxKey key = (BusModelBuffClearTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByPrevIdxKey();

		key.setOptionalPrevId( PrevId );
		IBusModelClearTopDep[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new IBusModelClearTopDep[ subdictPrevIdx.size() ];
			Iterator< BusModelBuffClearTopDep > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdictPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new IBusModelClearTopDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelClearTopDep[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readDerivedByNextIdx";
		BusModelBuffClearTopDepByNextIdxKey key = (BusModelBuffClearTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByNextIdxKey();

		key.setOptionalNextId( NextId );
		IBusModelClearTopDep[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new IBusModelClearTopDep[ subdictNextIdx.size() ];
			Iterator< BusModelBuffClearTopDep > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdictNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new IBusModelClearTopDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelClearTopDep readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelClearTopDep buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearTopDep readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readRec";
		IBusModelClearTopDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearTopDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearTopDep lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelClearTopDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelClearTopDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelClearTopDep[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readAllRec";
		IBusModelClearTopDep buff;
		ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
		IBusModelClearTopDep[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearTopDep.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
	}

	@Override
	public IBusModelClearTopDep readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelClearTopDep buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelClearTopDep)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelClearTopDep[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelClearTopDep buff;
		ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
		IBusModelClearTopDep[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
	}

	@Override
	public IBusModelClearTopDep[] readRecByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByClearDepIdx() ";
		IBusModelClearTopDep buff;
		ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
		IBusModelClearTopDep[] buffList = readDerivedByClearDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
	}

	@Override
	public IBusModelClearTopDep[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamClearDep.readRecByDefSchemaIdx() ";
		IBusModelClearTopDep buff;
		ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
		IBusModelClearTopDep[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
	}

	@Override
	public IBusModelClearTopDep[] readRecByClrTopDepTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readRecByClrTopDepTblIdx() ";
		IBusModelClearTopDep buff;
		ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
		IBusModelClearTopDep[] buffList = readDerivedByClrTopDepTblIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearTopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
	}

	@Override
	public IBusModelClearTopDep readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readRecByUNameIdx() ";
		IBusModelClearTopDep buff = readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearTopDep.CLASS_CODE ) ) {
			return( (IBusModelClearTopDep)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelClearTopDep[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readRecByPrevIdx() ";
		IBusModelClearTopDep buff;
		ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
		IBusModelClearTopDep[] buffList = readDerivedByPrevIdx( Authorization,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearTopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
	}

	@Override
	public IBusModelClearTopDep[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamClearTopDep.readRecByNextIdx() ";
		IBusModelClearTopDep buff;
		ArrayList<IBusModelClearTopDep> filteredList = new ArrayList<IBusModelClearTopDep>();
		IBusModelClearTopDep[] buffList = readDerivedByNextIdx( Authorization,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelClearTopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelClearTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelClearTopDep[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelClearTopDep moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecUp";

		IBusModelClearTopDep grandprev = null;
		IBusModelClearTopDep prev = null;
		IBusModelClearTopDep cur = null;
		IBusModelClearTopDep next = null;

		cur = schema.getTableClearTopDep().readDerivedByIdIdx(Authorization, Id);
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalPrevId() == null ) )
		{
			return( (BusModelBuffClearTopDep)cur );
		}

		prev = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
		if( prev == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx(Authorization, prev.getOptionalPrevId() ));
			if( grandprev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextId() != null ) )
		{
			next = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
			if( next == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
			}
		}

		int classCode = prev.getClassCode();
		IBusModelClearTopDep newInstance;
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffClearTopDep editPrev = (BusModelBuffClearTopDep)newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffClearTopDep editCur = (BusModelBuffClearTopDep)newInstance;
		editCur.set( cur );

		BusModelBuffClearTopDep editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandprev = (BusModelBuffClearTopDep)newInstance;
			editGrandprev.set( grandprev );
		}

		BusModelBuffClearTopDep editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext = (BusModelBuffClearTopDep)newInstance;
			editNext.set( next );
		}

		if( editGrandprev != null ) {
			editGrandprev.setOptionalLookupNext(cur.getRequiredId());
			editCur.setOptionalLookupPrev(grandprev.getRequiredId());
		}
		else {
			editCur.setOptionalLookupPrev((IYCFKeyHash256)null);
		}

			editPrev.setOptionalLookupPrev(cur.getRequiredId());

			editCur.setOptionalLookupNext(prev.getRequiredId());

		if( next != null ) {
			editPrev.setOptionalLookupNext(next.getRequiredId());
			editNext.setOptionalLookupPrev(prev.getRequiredId());
		}
		else {
			editPrev.setOptionalLookupNext((IYCFKeyHash256)null);
		}

		if( editGrandprev != null ) {
			classCode = editGrandprev.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editGrandprev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffClearTopDep)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelClearTopDep moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecDown";

		BusModelBuffClearTopDep prev = null;
		BusModelBuffClearTopDep cur = null;
		BusModelBuffClearTopDep next = null;
		BusModelBuffClearTopDep grandnext = null;

		cur = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx(Authorization, Id));
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalNextId() == null ) )
		{
			return( (BusModelBuffClearTopDep)cur );
		}

		next = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
		if( next == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
		}

		if( ( next.getOptionalNextId() != null ) )
		{
			grandnext = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx(Authorization, next.getOptionalNextId() ));
			if( grandnext == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevId() != null ) )
		{
			prev = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
			if( prev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
			}
		}

		int classCode = cur.getClassCode();
		IBusModelClearTopDep newInstance;
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffClearTopDep editCur = (BusModelBuffClearTopDep)newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffClearTopDep editNext = (BusModelBuffClearTopDep)newInstance;
		editNext.set( next );

		BusModelBuffClearTopDep editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandnext = (BusModelBuffClearTopDep)newInstance;
			editGrandnext.set( grandnext );
		}

		BusModelBuffClearTopDep editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev = (BusModelBuffClearTopDep)newInstance;
			editPrev.set( prev );
		}

		if( prev != null ) {
			editPrev.setOptionalLookupNext(next.getRequiredId());
			editNext.setOptionalLookupPrev(prev.getRequiredId());
		}
		else {
			editNext.setOptionalLookupPrev((IYCFKeyHash256)null);
		}

			editCur.setOptionalLookupPrev(next.getRequiredId());

			editNext.setOptionalLookupNext(cur.getRequiredId());

		if( editGrandnext != null ) {
			editCur.setOptionalLookupNext(grandnext.getRequiredId());
			editGrandnext.setOptionalLookupPrev(cur.getRequiredId());
		}
		else {
			editCur.setOptionalLookupNext((IYCFKeyHash256)null);
		}

		if( editPrev != null ) {
			classCode = editPrev.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editNext.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editGrandnext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffClearTopDep)editCur );
	}

	public IBusModelClearTopDep updateClearTopDep( ISecureAuthorization Authorization,
		IBusModelClearTopDep iBuff )
	{
		BusModelBuffClearTopDep Buff = (BusModelBuffClearTopDep)(schema.getTableClearDep().updateClearDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffClearTopDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateClearTopDep",
				"Existing record not found",
				"Existing record not found",
				"ClearTopDep",
				"ClearTopDep",
				pkey );
		}
		BusModelBuffClearTopDepByClrTopDepTblIdxKey existingKeyClrTopDepTblIdx = (BusModelBuffClearTopDepByClrTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
		existingKeyClrTopDepTblIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffClearTopDepByClrTopDepTblIdxKey newKeyClrTopDepTblIdx = (BusModelBuffClearTopDepByClrTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
		newKeyClrTopDepTblIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffClearTopDepByUNameIdxKey existingKeyUNameIdx = (BusModelBuffClearTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffClearTopDepByUNameIdxKey newKeyUNameIdx = (BusModelBuffClearTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffClearTopDepByPrevIdxKey existingKeyPrevIdx = (BusModelBuffClearTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffClearTopDepByPrevIdxKey newKeyPrevIdx = (BusModelBuffClearTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffClearTopDepByNextIdxKey existingKeyNextIdx = (BusModelBuffClearTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByNextIdxKey();
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffClearTopDepByNextIdxKey newKeyNextIdx = (BusModelBuffClearTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByNextIdxKey();
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateClearTopDep",
					"ClearTopDepUNameIdx",
					"ClearTopDepUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableClearDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateClearTopDep",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"ClearDep",
						"ClearDep",
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
						"updateClearTopDep",
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClrTopDepTblIdx.get( existingKeyClrTopDepTblIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClrTopDepTblIdx.containsKey( newKeyClrTopDepTblIdx ) ) {
			subdict = dictByClrTopDepTblIdx.get( newKeyClrTopDepTblIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep >();
			dictByClrTopDepTblIdx.put( newKeyClrTopDepTblIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByPrevIdx.get( existingKeyPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevIdx.containsKey( newKeyPrevIdx ) ) {
			subdict = dictByPrevIdx.get( newKeyPrevIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep >();
			dictByPrevIdx.put( newKeyPrevIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNextIdx.get( existingKeyNextIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNextIdx.containsKey( newKeyNextIdx ) ) {
			subdict = dictByNextIdx.get( newKeyNextIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteClearTopDep( ISecureAuthorization Authorization,
		IBusModelClearTopDep iBuff )
	{
		final String S_ProcName = "BusModelRamClearTopDepTable.deleteClearTopDep() ";
		BusModelBuffClearTopDep Buff = (BusModelBuffClearTopDep)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffClearTopDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteClearTopDep",
				pkey );
		}
		IYCFKeyHash256 varTableId = existing.getRequiredTableId();
		BusModelBuffTable container = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
			varTableId ));
		if( container == null ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				0,
				"container" );
		}

		IYCFKeyHash256 prevId = existing.getOptionalPrevId();
		IYCFKeyHash256 nextId = existing.getOptionalNextId();

		BusModelBuffClearTopDep prev = null;
		if( ( prevId != null ) )
		{
			prev = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				prevId ));
			if( prev == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			BusModelBuffClearTopDep editPrev;
			classCode = prev.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				editPrev = (BusModelBuffClearTopDep)(schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev.set( prev );
			editPrev.setOptionalLookupNext(nextId);
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffClearTopDep next = null;
		if( ( nextId != null ) )
		{
			next = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				nextId ));
			if( next == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			BusModelBuffClearTopDep editNext;
			classCode = next.getClassCode();
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				editNext = (BusModelBuffClearTopDep)(schema.getBusModelBuffFactory().getFactoryClearTopDep().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext.set( next );
			editNext.setOptionalLookupPrev(prevId);
			if( classCode == IBusModelClearTopDep.CLASS_CODE ) {
				schema.getTableClearTopDep().updateClearTopDep( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckClearDep[] = schema.getTableClearSubDep1().readDerivedByClearTopDepIdx( Authorization,
						existing.getRequiredId() );
		if( arrCheckClearDep.length > 0 ) {
			schema.getTableClearSubDep1().deleteClearSubDep1ByClearTopDepIdx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx = (BusModelBuffClearTopDepByClrTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
		keyClrTopDepTblIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffClearTopDepByUNameIdxKey keyUNameIdx = (BusModelBuffClearTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffClearTopDepByPrevIdxKey keyPrevIdx = (BusModelBuffClearTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffClearTopDepByNextIdxKey keyNextIdx = (BusModelBuffClearTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffClearTopDep > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClrTopDepTblIdx.get( keyClrTopDepTblIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		schema.getTableClearDep().deleteClearDep( Authorization,
			Buff );
	}
	@Override
	public void deleteClearTopDepByClrTopDepTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffClearTopDepByClrTopDepTblIdxKey key = (BusModelBuffClearTopDepByClrTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
		key.setRequiredTableId( argTableId );
		deleteClearTopDepByClrTopDepTblIdx( Authorization, key );
	}

	@Override
	public void deleteClearTopDepByClrTopDepTblIdx( ISecureAuthorization Authorization,
		IBusModelClearTopDepByClrTopDepTblIdxKey argKey )
	{
		BusModelBuffClearTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearTopDep> matchSet = new LinkedList<BusModelBuffClearTopDep>();
		Iterator<BusModelBuffClearTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteClearTopDepByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		BusModelBuffClearTopDepByUNameIdxKey key = (BusModelBuffClearTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByUNameIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteClearTopDepByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteClearTopDepByUNameIdx( ISecureAuthorization Authorization,
		IBusModelClearTopDepByUNameIdxKey argKey )
	{
		BusModelBuffClearTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearTopDep> matchSet = new LinkedList<BusModelBuffClearTopDep>();
		Iterator<BusModelBuffClearTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteClearTopDepByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffClearTopDepByPrevIdxKey key = (BusModelBuffClearTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByPrevIdxKey();
		key.setOptionalPrevId( argPrevId );
		deleteClearTopDepByPrevIdx( Authorization, key );
	}

	@Override
	public void deleteClearTopDepByPrevIdx( ISecureAuthorization Authorization,
		IBusModelClearTopDepByPrevIdxKey argKey )
	{
		BusModelBuffClearTopDep cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearTopDep> matchSet = new LinkedList<BusModelBuffClearTopDep>();
		Iterator<BusModelBuffClearTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteClearTopDepByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffClearTopDepByNextIdxKey key = (BusModelBuffClearTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryClearTopDep().newByNextIdxKey();
		key.setOptionalNextId( argNextId );
		deleteClearTopDepByNextIdx( Authorization, key );
	}

	@Override
	public void deleteClearTopDepByNextIdx( ISecureAuthorization Authorization,
		IBusModelClearTopDepByNextIdxKey argKey )
	{
		BusModelBuffClearTopDep cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearTopDep> matchSet = new LinkedList<BusModelBuffClearTopDep>();
		Iterator<BusModelBuffClearTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteClearTopDepByClearDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffClearDepByClearDepIdxKey key = (BusModelBuffClearDepByClearDepIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteClearTopDepByClearDepIdx( Authorization, key );
	}

	@Override
	public void deleteClearTopDepByClearDepIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByClearDepIdxKey argKey )
	{
		BusModelBuffClearTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearTopDep> matchSet = new LinkedList<BusModelBuffClearTopDep>();
		Iterator<BusModelBuffClearTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteClearTopDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffClearDepByDefSchemaIdxKey key = (BusModelBuffClearDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteClearTopDepByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteClearTopDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelClearDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffClearTopDep cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearTopDep> matchSet = new LinkedList<BusModelBuffClearTopDep>();
		Iterator<BusModelBuffClearTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteClearTopDepByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffClearTopDep cur;
		LinkedList<BusModelBuffClearTopDep> matchSet = new LinkedList<BusModelBuffClearTopDep>();
		Iterator<BusModelBuffClearTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteClearTopDepByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteClearTopDepByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteClearTopDepByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffClearTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffClearTopDep> matchSet = new LinkedList<BusModelBuffClearTopDep>();
		Iterator<BusModelBuffClearTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffClearTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffClearTopDep)(schema.getTableClearTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteClearTopDep( Authorization, cur );
		}
	}
}
