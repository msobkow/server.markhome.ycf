
// Description: Java 25 in-memory RAM DbIO implementation for DelTopDep.

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
 *	BusModelRamDelTopDepTable in-memory RAM DbIO implementation
 *	for DelTopDep.
 */
public class BusModelRamDelTopDepTable
	implements IBusModelDelTopDepTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffDelTopDep > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffDelTopDep >();
	private Map< BusModelBuffDelTopDepByDelTopDepTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelTopDep >> dictByDelTopDepTblIdx
		= new HashMap< BusModelBuffDelTopDepByDelTopDepTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelTopDep >>();
	private Map< BusModelBuffDelTopDepByUNameIdxKey,
			BusModelBuffDelTopDep > dictByUNameIdx
		= new HashMap< BusModelBuffDelTopDepByUNameIdxKey,
			BusModelBuffDelTopDep >();
	private Map< BusModelBuffDelTopDepByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelTopDep >> dictByPrevIdx
		= new HashMap< BusModelBuffDelTopDepByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelTopDep >>();
	private Map< BusModelBuffDelTopDepByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelTopDep >> dictByNextIdx
		= new HashMap< BusModelBuffDelTopDepByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffDelTopDep >>();

	public BusModelRamDelTopDepTable( IBusModelSchema argSchema ) {
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
	public IBusModelDelTopDep createDelTopDep( ISecureAuthorization Authorization,
		IBusModelDelTopDep iBuff )
	{
		final String S_ProcName = "createDelTopDep";
		
		BusModelBuffDelTopDep Buff = (BusModelBuffDelTopDep)(schema.getTableDelDep().createDelDep( Authorization,
			iBuff ));
		IBusModelDelTopDep tail = null;
		if( Buff.getClassCode() == IBusModelDelTopDep.CLASS_CODE ) {
			IBusModelDelTopDep[] siblings = schema.getTableDelTopDep().readDerivedByDelTopDepTblIdx( Authorization,
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
		BusModelBuffDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx = (BusModelBuffDelTopDepByDelTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
		keyDelTopDepTblIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffDelTopDepByUNameIdxKey keyUNameIdx = (BusModelBuffDelTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffDelTopDepByPrevIdxKey keyPrevIdx = (BusModelBuffDelTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffDelTopDepByNextIdxKey keyNextIdx = (BusModelBuffDelTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"DelTopDepUNameIdx",
				"DelTopDepUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableDelDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"DelDep",
						"DelDep",
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdictDelTopDepTblIdx;
		if( dictByDelTopDepTblIdx.containsKey( keyDelTopDepTblIdx ) ) {
			subdictDelTopDepTblIdx = dictByDelTopDepTblIdx.get( keyDelTopDepTblIdx );
		}
		else {
			subdictDelTopDepTblIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep >();
			dictByDelTopDepTblIdx.put( keyDelTopDepTblIdx, subdictDelTopDepTblIdx );
		}
		subdictDelTopDepTblIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		if( tail != null ) {
			int tailClassCode = tail.getClassCode();
			if( tailClassCode == IBusModelDelTopDep.CLASS_CODE ) {
				IBusModelDelTopDep tailEdit = schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec();
				tailEdit.set( (IBusModelDelTopDep)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableDelTopDep().updateDelTopDep( Authorization, tailEdit );
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
			if (classCode == IBusModelDelTopDep.CLASS_CODE) {
				BusModelBuffDelTopDep retbuff = ((BusModelBuffDelTopDep)(schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelDelTopDep readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readDerived";
		IBusModelDelTopDep buff;
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
	public IBusModelDelTopDep lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelTopDep.lockDerived";
		IBusModelDelTopDep buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelTopDep[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamDelTopDep.readAllDerived";
		IBusModelDelTopDep[] retList = new IBusModelDelTopDep[ dictByPKey.values().size() ];
		Iterator< BusModelBuffDelTopDep > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelDelTopDep[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelTopDep ) ) {
					filteredList.add( (IBusModelDelTopDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
		}
	}

	@Override
	public IBusModelDelTopDep[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamDelDep.readDerivedByDefSchemaIdx";
		IBusModelDelDep buffList[] = schema.getTableDelDep().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelDelDep buff;
			ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelTopDep ) ) {
					filteredList.add( (IBusModelDelTopDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
		}
	}

	@Override
	public IBusModelDelTopDep[] readDerivedByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamDelDep.readDerivedByDelDepIdx";
		IBusModelDelDep buffList[] = schema.getTableDelDep().readDerivedByDelDepIdx( Authorization,
			RelationId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelDelDep buff;
			ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelDelTopDep ) ) {
					filteredList.add( (IBusModelDelTopDep)buff );
				}
			}
			return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
		}
	}

	@Override
	public IBusModelDelTopDep[] readDerivedByDelTopDepTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readDerivedByDelTopDepTblIdx";
		BusModelBuffDelTopDepByDelTopDepTblIdxKey key = (BusModelBuffDelTopDepByDelTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();

		key.setRequiredTableId( TableId );
		IBusModelDelTopDep[] recArray;
		if( dictByDelTopDepTblIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdictDelTopDepTblIdx
				= dictByDelTopDepTblIdx.get( key );
			recArray = new IBusModelDelTopDep[ subdictDelTopDepTblIdx.size() ];
			Iterator< BusModelBuffDelTopDep > iter = subdictDelTopDepTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdictDelTopDepTblIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep >();
			dictByDelTopDepTblIdx.put( key, subdictDelTopDepTblIdx );
			recArray = new IBusModelDelTopDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelDelTopDep readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readDerivedByUNameIdx";
		BusModelBuffDelTopDepByUNameIdxKey key = (BusModelBuffDelTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByUNameIdxKey();

		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelDelTopDep buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelTopDep[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readDerivedByPrevIdx";
		BusModelBuffDelTopDepByPrevIdxKey key = (BusModelBuffDelTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByPrevIdxKey();

		key.setOptionalPrevId( PrevId );
		IBusModelDelTopDep[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new IBusModelDelTopDep[ subdictPrevIdx.size() ];
			Iterator< BusModelBuffDelTopDep > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdictPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new IBusModelDelTopDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelDelTopDep[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readDerivedByNextIdx";
		BusModelBuffDelTopDepByNextIdxKey key = (BusModelBuffDelTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByNextIdxKey();

		key.setOptionalNextId( NextId );
		IBusModelDelTopDep[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new IBusModelDelTopDep[ subdictNextIdx.size() ];
			Iterator< BusModelBuffDelTopDep > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdictNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new IBusModelDelTopDep[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelDelTopDep readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelDelTopDep buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelTopDep readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readRec";
		IBusModelDelTopDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelTopDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelTopDep lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelDelTopDep buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelDelTopDep.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelDelTopDep[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readAllRec";
		IBusModelDelTopDep buff;
		ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
		IBusModelDelTopDep[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelTopDep.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
	}

	@Override
	public IBusModelDelTopDep readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelDelTopDep buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelDelTopDep)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelDelTopDep[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelDelTopDep buff;
		ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
		IBusModelDelTopDep[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
	}

	@Override
	public IBusModelDelTopDep[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDefSchemaIdx() ";
		IBusModelDelTopDep buff;
		ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
		IBusModelDelTopDep[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
	}

	@Override
	public IBusModelDelTopDep[] readRecByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "BusModelRamDelDep.readRecByDelDepIdx() ";
		IBusModelDelTopDep buff;
		ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
		IBusModelDelTopDep[] buffList = readDerivedByDelDepIdx( Authorization,
			RelationId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
	}

	@Override
	public IBusModelDelTopDep[] readRecByDelTopDepTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readRecByDelTopDepTblIdx() ";
		IBusModelDelTopDep buff;
		ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
		IBusModelDelTopDep[] buffList = readDerivedByDelTopDepTblIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelTopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
	}

	@Override
	public IBusModelDelTopDep readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readRecByUNameIdx() ";
		IBusModelDelTopDep buff = readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelTopDep.CLASS_CODE ) ) {
			return( (IBusModelDelTopDep)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelDelTopDep[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readRecByPrevIdx() ";
		IBusModelDelTopDep buff;
		ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
		IBusModelDelTopDep[] buffList = readDerivedByPrevIdx( Authorization,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelTopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
	}

	@Override
	public IBusModelDelTopDep[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamDelTopDep.readRecByNextIdx() ";
		IBusModelDelTopDep buff;
		ArrayList<IBusModelDelTopDep> filteredList = new ArrayList<IBusModelDelTopDep>();
		IBusModelDelTopDep[] buffList = readDerivedByNextIdx( Authorization,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelDelTopDep.CLASS_CODE ) ) {
				filteredList.add( (IBusModelDelTopDep)buff );
			}
		}
		return( filteredList.toArray( new IBusModelDelTopDep[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelDelTopDep moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecUp";

		IBusModelDelTopDep grandprev = null;
		IBusModelDelTopDep prev = null;
		IBusModelDelTopDep cur = null;
		IBusModelDelTopDep next = null;

		cur = schema.getTableDelTopDep().readDerivedByIdIdx(Authorization, Id);
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalPrevId() == null ) )
		{
			return( (BusModelBuffDelTopDep)cur );
		}

		prev = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
		if( prev == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx(Authorization, prev.getOptionalPrevId() ));
			if( grandprev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextId() != null ) )
		{
			next = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
			if( next == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
			}
		}

		int classCode = prev.getClassCode();
		IBusModelDelTopDep newInstance;
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffDelTopDep editPrev = (BusModelBuffDelTopDep)newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffDelTopDep editCur = (BusModelBuffDelTopDep)newInstance;
		editCur.set( cur );

		BusModelBuffDelTopDep editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandprev = (BusModelBuffDelTopDep)newInstance;
			editGrandprev.set( grandprev );
		}

		BusModelBuffDelTopDep editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext = (BusModelBuffDelTopDep)newInstance;
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
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editGrandprev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffDelTopDep)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelDelTopDep moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecDown";

		BusModelBuffDelTopDep prev = null;
		BusModelBuffDelTopDep cur = null;
		BusModelBuffDelTopDep next = null;
		BusModelBuffDelTopDep grandnext = null;

		cur = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx(Authorization, Id));
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalNextId() == null ) )
		{
			return( (BusModelBuffDelTopDep)cur );
		}

		next = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
		if( next == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
		}

		if( ( next.getOptionalNextId() != null ) )
		{
			grandnext = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx(Authorization, next.getOptionalNextId() ));
			if( grandnext == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevId() != null ) )
		{
			prev = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
			if( prev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
			}
		}

		int classCode = cur.getClassCode();
		IBusModelDelTopDep newInstance;
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffDelTopDep editCur = (BusModelBuffDelTopDep)newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffDelTopDep editNext = (BusModelBuffDelTopDep)newInstance;
		editNext.set( next );

		BusModelBuffDelTopDep editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandnext = (BusModelBuffDelTopDep)newInstance;
			editGrandnext.set( grandnext );
		}

		BusModelBuffDelTopDep editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev = (BusModelBuffDelTopDep)newInstance;
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
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editNext.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editGrandnext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffDelTopDep)editCur );
	}

	public IBusModelDelTopDep updateDelTopDep( ISecureAuthorization Authorization,
		IBusModelDelTopDep iBuff )
	{
		BusModelBuffDelTopDep Buff = (BusModelBuffDelTopDep)(schema.getTableDelDep().updateDelDep( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffDelTopDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateDelTopDep",
				"Existing record not found",
				"Existing record not found",
				"DelTopDep",
				"DelTopDep",
				pkey );
		}
		BusModelBuffDelTopDepByDelTopDepTblIdxKey existingKeyDelTopDepTblIdx = (BusModelBuffDelTopDepByDelTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
		existingKeyDelTopDepTblIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffDelTopDepByDelTopDepTblIdxKey newKeyDelTopDepTblIdx = (BusModelBuffDelTopDepByDelTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
		newKeyDelTopDepTblIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffDelTopDepByUNameIdxKey existingKeyUNameIdx = (BusModelBuffDelTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffDelTopDepByUNameIdxKey newKeyUNameIdx = (BusModelBuffDelTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffDelTopDepByPrevIdxKey existingKeyPrevIdx = (BusModelBuffDelTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffDelTopDepByPrevIdxKey newKeyPrevIdx = (BusModelBuffDelTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffDelTopDepByNextIdxKey existingKeyNextIdx = (BusModelBuffDelTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByNextIdxKey();
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffDelTopDepByNextIdxKey newKeyNextIdx = (BusModelBuffDelTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByNextIdxKey();
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateDelTopDep",
					"DelTopDepUNameIdx",
					"DelTopDepUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableDelDep().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateDelTopDep",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"DelDep",
						"DelDep",
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
						"updateDelTopDep",
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByDelTopDepTblIdx.get( existingKeyDelTopDepTblIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDelTopDepTblIdx.containsKey( newKeyDelTopDepTblIdx ) ) {
			subdict = dictByDelTopDepTblIdx.get( newKeyDelTopDepTblIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep >();
			dictByDelTopDepTblIdx.put( newKeyDelTopDepTblIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep >();
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteDelTopDep( ISecureAuthorization Authorization,
		IBusModelDelTopDep iBuff )
	{
		final String S_ProcName = "BusModelRamDelTopDepTable.deleteDelTopDep() ";
		BusModelBuffDelTopDep Buff = (BusModelBuffDelTopDep)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffDelTopDep existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteDelTopDep",
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

		BusModelBuffDelTopDep prev = null;
		if( ( prevId != null ) )
		{
			prev = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				prevId ));
			if( prev == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			BusModelBuffDelTopDep editPrev;
			classCode = prev.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				editPrev = (BusModelBuffDelTopDep)(schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev.set( prev );
			editPrev.setOptionalLookupNext(nextId);
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffDelTopDep next = null;
		if( ( nextId != null ) )
		{
			next = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				nextId ));
			if( next == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			BusModelBuffDelTopDep editNext;
			classCode = next.getClassCode();
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				editNext = (BusModelBuffDelTopDep)(schema.getBusModelBuffFactory().getFactoryDelTopDep().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext.set( next );
			editNext.setOptionalLookupPrev(prevId);
			if( classCode == IBusModelDelTopDep.CLASS_CODE ) {
				schema.getTableDelTopDep().updateDelTopDep( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckDelDep[] = schema.getTableDelSubDep1().readDerivedByDelTopDepIdx( Authorization,
						existing.getRequiredId() );
		if( arrCheckDelDep.length > 0 ) {
			schema.getTableDelSubDep1().deleteDelSubDep1ByDelTopDepIdx( Authorization,
						existing.getRequiredId() );
		}
		BusModelBuffDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx = (BusModelBuffDelTopDepByDelTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
		keyDelTopDepTblIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffDelTopDepByUNameIdxKey keyUNameIdx = (BusModelBuffDelTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffDelTopDepByPrevIdxKey keyPrevIdx = (BusModelBuffDelTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffDelTopDepByNextIdxKey keyNextIdx = (BusModelBuffDelTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffDelTopDep > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByDelTopDepTblIdx.get( keyDelTopDepTblIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		schema.getTableDelDep().deleteDelDep( Authorization,
			Buff );
	}
	@Override
	public void deleteDelTopDepByDelTopDepTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffDelTopDepByDelTopDepTblIdxKey key = (BusModelBuffDelTopDepByDelTopDepTblIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
		key.setRequiredTableId( argTableId );
		deleteDelTopDepByDelTopDepTblIdx( Authorization, key );
	}

	@Override
	public void deleteDelTopDepByDelTopDepTblIdx( ISecureAuthorization Authorization,
		IBusModelDelTopDepByDelTopDepTblIdxKey argKey )
	{
		BusModelBuffDelTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelTopDep> matchSet = new LinkedList<BusModelBuffDelTopDep>();
		Iterator<BusModelBuffDelTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteDelTopDepByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		BusModelBuffDelTopDepByUNameIdxKey key = (BusModelBuffDelTopDepByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByUNameIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteDelTopDepByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteDelTopDepByUNameIdx( ISecureAuthorization Authorization,
		IBusModelDelTopDepByUNameIdxKey argKey )
	{
		BusModelBuffDelTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelTopDep> matchSet = new LinkedList<BusModelBuffDelTopDep>();
		Iterator<BusModelBuffDelTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteDelTopDepByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffDelTopDepByPrevIdxKey key = (BusModelBuffDelTopDepByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByPrevIdxKey();
		key.setOptionalPrevId( argPrevId );
		deleteDelTopDepByPrevIdx( Authorization, key );
	}

	@Override
	public void deleteDelTopDepByPrevIdx( ISecureAuthorization Authorization,
		IBusModelDelTopDepByPrevIdxKey argKey )
	{
		BusModelBuffDelTopDep cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelTopDep> matchSet = new LinkedList<BusModelBuffDelTopDep>();
		Iterator<BusModelBuffDelTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteDelTopDepByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffDelTopDepByNextIdxKey key = (BusModelBuffDelTopDepByNextIdxKey)schema.getBusModelBuffFactory().getFactoryDelTopDep().newByNextIdxKey();
		key.setOptionalNextId( argNextId );
		deleteDelTopDepByNextIdx( Authorization, key );
	}

	@Override
	public void deleteDelTopDepByNextIdx( ISecureAuthorization Authorization,
		IBusModelDelTopDepByNextIdxKey argKey )
	{
		BusModelBuffDelTopDep cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelTopDep> matchSet = new LinkedList<BusModelBuffDelTopDep>();
		Iterator<BusModelBuffDelTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteDelTopDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffDelDepByDefSchemaIdxKey key = (BusModelBuffDelDepByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteDelTopDepByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteDelTopDepByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDefSchemaIdxKey argKey )
	{
		BusModelBuffDelTopDep cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelTopDep> matchSet = new LinkedList<BusModelBuffDelTopDep>();
		Iterator<BusModelBuffDelTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteDelTopDepByDelDepIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRelationId )
	{
		BusModelBuffDelDepByDelDepIdxKey key = (BusModelBuffDelDepByDelDepIdxKey)schema.getBusModelBuffFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( argRelationId );
		deleteDelTopDepByDelDepIdx( Authorization, key );
	}

	@Override
	public void deleteDelTopDepByDelDepIdx( ISecureAuthorization Authorization,
		IBusModelDelDepByDelDepIdxKey argKey )
	{
		BusModelBuffDelTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelTopDep> matchSet = new LinkedList<BusModelBuffDelTopDep>();
		Iterator<BusModelBuffDelTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteDelTopDepByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffDelTopDep cur;
		LinkedList<BusModelBuffDelTopDep> matchSet = new LinkedList<BusModelBuffDelTopDep>();
		Iterator<BusModelBuffDelTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelTopDep( Authorization, cur );
		}
	}

	@Override
	public void deleteDelTopDepByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteDelTopDepByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteDelTopDepByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffDelTopDep cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffDelTopDep> matchSet = new LinkedList<BusModelBuffDelTopDep>();
		Iterator<BusModelBuffDelTopDep> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffDelTopDep> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffDelTopDep)(schema.getTableDelTopDep().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteDelTopDep( Authorization, cur );
		}
	}
}
