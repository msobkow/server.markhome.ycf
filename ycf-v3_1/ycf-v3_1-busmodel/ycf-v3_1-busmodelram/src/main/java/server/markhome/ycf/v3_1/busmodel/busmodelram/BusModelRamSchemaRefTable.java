
// Description: Java 25 in-memory RAM DbIO implementation for SchemaRef.

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
 *	BusModelRamSchemaRefTable in-memory RAM DbIO implementation
 *	for SchemaRef.
 */
public class BusModelRamSchemaRefTable
	implements IBusModelSchemaRefTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffSchemaRef > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffSchemaRef >();
	private Map< BusModelBuffSchemaRefBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRef >> dictBySchemaIdx
		= new HashMap< BusModelBuffSchemaRefBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRef >>();
	private Map< BusModelBuffSchemaRefByUNameIdxKey,
			BusModelBuffSchemaRef > dictByUNameIdx
		= new HashMap< BusModelBuffSchemaRefByUNameIdxKey,
			BusModelBuffSchemaRef >();
	private Map< BusModelBuffSchemaRefByRefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRef >> dictByRefSchemaIdx
		= new HashMap< BusModelBuffSchemaRefByRefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRef >>();
	private Map< BusModelBuffSchemaRefByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRef >> dictByPrevIdx
		= new HashMap< BusModelBuffSchemaRefByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRef >>();
	private Map< BusModelBuffSchemaRefByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRef >> dictByNextIdx
		= new HashMap< BusModelBuffSchemaRefByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRef >>();

	public BusModelRamSchemaRefTable( IBusModelSchema argSchema ) {
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
	public IBusModelSchemaRef createSchemaRef( ISecureAuthorization Authorization,
		IBusModelSchemaRef iBuff )
	{
		final String S_ProcName = "createSchemaRef";
		
		BusModelBuffSchemaRef Buff = (BusModelBuffSchemaRef)(schema.getTableScope().createScope( Authorization,
			iBuff ));
		IBusModelSchemaRef tail = null;
		if( Buff.getClassCode() == IBusModelSchemaRef.CLASS_CODE ) {
			IBusModelSchemaRef[] siblings = schema.getTableSchemaRef().readDerivedBySchemaIdx( Authorization,
				Buff.getRequiredSchemaId() );
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
		BusModelBuffSchemaRefBySchemaIdxKey keySchemaIdx = (BusModelBuffSchemaRefBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaId( Buff.getRequiredSchemaId() );

		BusModelBuffSchemaRefByUNameIdxKey keyUNameIdx = (BusModelBuffSchemaRefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByUNameIdxKey();
		keyUNameIdx.setRequiredSchemaId( Buff.getRequiredSchemaId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffSchemaRefByRefSchemaIdxKey keyRefSchemaIdx = (BusModelBuffSchemaRefByRefSchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
		keyRefSchemaIdx.setOptionalRefSchemaId( Buff.getOptionalRefSchemaId() );

		BusModelBuffSchemaRefByPrevIdxKey keyPrevIdx = (BusModelBuffSchemaRefByPrevIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffSchemaRefByNextIdxKey keyNextIdx = (BusModelBuffSchemaRefByNextIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SchemaRefUNameIdx",
				"SchemaRefUNameIdx",
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
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSchemaId() ) )
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictSchemaIdx;
		if( dictBySchemaIdx.containsKey( keySchemaIdx ) ) {
			subdictSchemaIdx = dictBySchemaIdx.get( keySchemaIdx );
		}
		else {
			subdictSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictBySchemaIdx.put( keySchemaIdx, subdictSchemaIdx );
		}
		subdictSchemaIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictRefSchemaIdx;
		if( dictByRefSchemaIdx.containsKey( keyRefSchemaIdx ) ) {
			subdictRefSchemaIdx = dictByRefSchemaIdx.get( keyRefSchemaIdx );
		}
		else {
			subdictRefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictByRefSchemaIdx.put( keyRefSchemaIdx, subdictRefSchemaIdx );
		}
		subdictRefSchemaIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		if( tail != null ) {
			int tailClassCode = tail.getClassCode();
			if( tailClassCode == IBusModelSchemaRef.CLASS_CODE ) {
				IBusModelSchemaRef tailEdit = schema.getBusModelBuffFactory().getFactorySchemaRef().newRec();
				tailEdit.set( (IBusModelSchemaRef)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
				schema.getTableSchemaRef().updateSchemaRef( Authorization, tailEdit );
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
			if (classCode == IBusModelSchemaRef.CLASS_CODE) {
				BusModelBuffSchemaRef retbuff = ((BusModelBuffSchemaRef)(schema.getBusModelBuffFactory().getFactorySchemaRef().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelSchemaRef readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readDerived";
		IBusModelSchemaRef buff;
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
	public IBusModelSchemaRef lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaRef.lockDerived";
		IBusModelSchemaRef buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaRef[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamSchemaRef.readAllDerived";
		IBusModelSchemaRef[] retList = new IBusModelSchemaRef[ dictByPKey.values().size() ];
		Iterator< BusModelBuffSchemaRef > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelSchemaRef[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelSchemaRef> filteredList = new ArrayList<IBusModelSchemaRef>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelSchemaRef ) ) {
					filteredList.add( (IBusModelSchemaRef)buff );
				}
			}
			return( filteredList.toArray( new IBusModelSchemaRef[0] ) );
		}
	}

	@Override
	public IBusModelSchemaRef[] readDerivedBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaId )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readDerivedBySchemaIdx";
		BusModelBuffSchemaRefBySchemaIdxKey key = (BusModelBuffSchemaRefBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newBySchemaIdxKey();

		key.setRequiredSchemaId( SchemaId );
		IBusModelSchemaRef[] recArray;
		if( dictBySchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictSchemaIdx
				= dictBySchemaIdx.get( key );
			recArray = new IBusModelSchemaRef[ subdictSchemaIdx.size() ];
			Iterator< BusModelBuffSchemaRef > iter = subdictSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictBySchemaIdx.put( key, subdictSchemaIdx );
			recArray = new IBusModelSchemaRef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaRef readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readDerivedByUNameIdx";
		BusModelBuffSchemaRefByUNameIdxKey key = (BusModelBuffSchemaRefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByUNameIdxKey();

		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		IBusModelSchemaRef buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaRef[] readDerivedByRefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RefSchemaId )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readDerivedByRefSchemaIdx";
		BusModelBuffSchemaRefByRefSchemaIdxKey key = (BusModelBuffSchemaRefByRefSchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByRefSchemaIdxKey();

		key.setOptionalRefSchemaId( RefSchemaId );
		IBusModelSchemaRef[] recArray;
		if( dictByRefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictRefSchemaIdx
				= dictByRefSchemaIdx.get( key );
			recArray = new IBusModelSchemaRef[ subdictRefSchemaIdx.size() ];
			Iterator< BusModelBuffSchemaRef > iter = subdictRefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictRefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictByRefSchemaIdx.put( key, subdictRefSchemaIdx );
			recArray = new IBusModelSchemaRef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaRef[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readDerivedByPrevIdx";
		BusModelBuffSchemaRefByPrevIdxKey key = (BusModelBuffSchemaRefByPrevIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByPrevIdxKey();

		key.setOptionalPrevId( PrevId );
		IBusModelSchemaRef[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new IBusModelSchemaRef[ subdictPrevIdx.size() ];
			Iterator< BusModelBuffSchemaRef > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new IBusModelSchemaRef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaRef[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readDerivedByNextIdx";
		BusModelBuffSchemaRefByNextIdxKey key = (BusModelBuffSchemaRefByNextIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByNextIdxKey();

		key.setOptionalNextId( NextId );
		IBusModelSchemaRef[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new IBusModelSchemaRef[ subdictNextIdx.size() ];
			Iterator< BusModelBuffSchemaRef > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdictNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new IBusModelSchemaRef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaRef readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelSchemaRef buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaRef readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readRec";
		IBusModelSchemaRef buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelSchemaRef.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaRef lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelSchemaRef buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelSchemaRef.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaRef[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readAllRec";
		IBusModelSchemaRef buff;
		ArrayList<IBusModelSchemaRef> filteredList = new ArrayList<IBusModelSchemaRef>();
		IBusModelSchemaRef[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRef.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRef[0] ) );
	}

	@Override
	public IBusModelSchemaRef readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelSchemaRef buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelSchemaRef)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaRef[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelSchemaRef buff;
		ArrayList<IBusModelSchemaRef> filteredList = new ArrayList<IBusModelSchemaRef>();
		IBusModelSchemaRef[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRef[0] ) );
	}

	@Override
	public IBusModelSchemaRef[] readRecBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaId )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readRecBySchemaIdx() ";
		IBusModelSchemaRef buff;
		ArrayList<IBusModelSchemaRef> filteredList = new ArrayList<IBusModelSchemaRef>();
		IBusModelSchemaRef[] buffList = readDerivedBySchemaIdx( Authorization,
			SchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRef[0] ) );
	}

	@Override
	public IBusModelSchemaRef readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readRecByUNameIdx() ";
		IBusModelSchemaRef buff = readDerivedByUNameIdx( Authorization,
			SchemaId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRef.CLASS_CODE ) ) {
			return( (IBusModelSchemaRef)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaRef[] readRecByRefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 RefSchemaId )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readRecByRefSchemaIdx() ";
		IBusModelSchemaRef buff;
		ArrayList<IBusModelSchemaRef> filteredList = new ArrayList<IBusModelSchemaRef>();
		IBusModelSchemaRef[] buffList = readDerivedByRefSchemaIdx( Authorization,
			RefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRef[0] ) );
	}

	@Override
	public IBusModelSchemaRef[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readRecByPrevIdx() ";
		IBusModelSchemaRef buff;
		ArrayList<IBusModelSchemaRef> filteredList = new ArrayList<IBusModelSchemaRef>();
		IBusModelSchemaRef[] buffList = readDerivedByPrevIdx( Authorization,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRef[0] ) );
	}

	@Override
	public IBusModelSchemaRef[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamSchemaRef.readRecByNextIdx() ";
		IBusModelSchemaRef buff;
		ArrayList<IBusModelSchemaRef> filteredList = new ArrayList<IBusModelSchemaRef>();
		IBusModelSchemaRef[] buffList = readDerivedByNextIdx( Authorization,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRef[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelSchemaRef moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecUp";

		IBusModelSchemaRef grandprev = null;
		IBusModelSchemaRef prev = null;
		IBusModelSchemaRef cur = null;
		IBusModelSchemaRef next = null;

		cur = schema.getTableSchemaRef().readDerivedByIdIdx(Authorization, Id);
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalPrevId() == null ) )
		{
			return( (BusModelBuffSchemaRef)cur );
		}

		prev = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
		if( prev == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx(Authorization, prev.getOptionalPrevId() ));
			if( grandprev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextId() != null ) )
		{
			next = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
			if( next == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
			}
		}

		int classCode = prev.getClassCode();
		IBusModelSchemaRef newInstance;
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactorySchemaRef().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffSchemaRef editPrev = (BusModelBuffSchemaRef)newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactorySchemaRef().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffSchemaRef editCur = (BusModelBuffSchemaRef)newInstance;
		editCur.set( cur );

		BusModelBuffSchemaRef editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactorySchemaRef().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandprev = (BusModelBuffSchemaRef)newInstance;
			editGrandprev.set( grandprev );
		}

		BusModelBuffSchemaRef editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactorySchemaRef().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext = (BusModelBuffSchemaRef)newInstance;
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
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editGrandprev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffSchemaRef)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelSchemaRef moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecDown";

		BusModelBuffSchemaRef prev = null;
		BusModelBuffSchemaRef cur = null;
		BusModelBuffSchemaRef next = null;
		BusModelBuffSchemaRef grandnext = null;

		cur = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx(Authorization, Id));
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalNextId() == null ) )
		{
			return( (BusModelBuffSchemaRef)cur );
		}

		next = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
		if( next == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
		}

		if( ( next.getOptionalNextId() != null ) )
		{
			grandnext = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx(Authorization, next.getOptionalNextId() ));
			if( grandnext == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevId() != null ) )
		{
			prev = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
			if( prev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
			}
		}

		int classCode = cur.getClassCode();
		IBusModelSchemaRef newInstance;
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactorySchemaRef().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffSchemaRef editCur = (BusModelBuffSchemaRef)newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactorySchemaRef().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffSchemaRef editNext = (BusModelBuffSchemaRef)newInstance;
		editNext.set( next );

		BusModelBuffSchemaRef editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactorySchemaRef().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandnext = (BusModelBuffSchemaRef)newInstance;
			editGrandnext.set( grandnext );
		}

		BusModelBuffSchemaRef editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactorySchemaRef().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev = (BusModelBuffSchemaRef)newInstance;
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
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editNext.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editGrandnext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffSchemaRef)editCur );
	}

	public IBusModelSchemaRef updateSchemaRef( ISecureAuthorization Authorization,
		IBusModelSchemaRef iBuff )
	{
		BusModelBuffSchemaRef Buff = (BusModelBuffSchemaRef)(schema.getTableScope().updateScope( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffSchemaRef existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSchemaRef",
				"Existing record not found",
				"Existing record not found",
				"SchemaRef",
				"SchemaRef",
				pkey );
		}
		BusModelBuffSchemaRefBySchemaIdxKey existingKeySchemaIdx = (BusModelBuffSchemaRefBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newBySchemaIdxKey();
		existingKeySchemaIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );

		BusModelBuffSchemaRefBySchemaIdxKey newKeySchemaIdx = (BusModelBuffSchemaRefBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newBySchemaIdxKey();
		newKeySchemaIdx.setRequiredSchemaId( Buff.getRequiredSchemaId() );

		BusModelBuffSchemaRefByUNameIdxKey existingKeyUNameIdx = (BusModelBuffSchemaRefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffSchemaRefByUNameIdxKey newKeyUNameIdx = (BusModelBuffSchemaRefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredSchemaId( Buff.getRequiredSchemaId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffSchemaRefByRefSchemaIdxKey existingKeyRefSchemaIdx = (BusModelBuffSchemaRefByRefSchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
		existingKeyRefSchemaIdx.setOptionalRefSchemaId( existing.getOptionalRefSchemaId() );

		BusModelBuffSchemaRefByRefSchemaIdxKey newKeyRefSchemaIdx = (BusModelBuffSchemaRefByRefSchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
		newKeyRefSchemaIdx.setOptionalRefSchemaId( Buff.getOptionalRefSchemaId() );

		BusModelBuffSchemaRefByPrevIdxKey existingKeyPrevIdx = (BusModelBuffSchemaRefByPrevIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffSchemaRefByPrevIdxKey newKeyPrevIdx = (BusModelBuffSchemaRefByPrevIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffSchemaRefByNextIdxKey existingKeyNextIdx = (BusModelBuffSchemaRefByNextIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByNextIdxKey();
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffSchemaRefByNextIdxKey newKeyNextIdx = (BusModelBuffSchemaRefByNextIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByNextIdxKey();
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSchemaRef",
					"SchemaRefUNameIdx",
					"SchemaRefUNameIdx",
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
						"updateSchemaRef",
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
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSchemaId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSchemaRef",
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

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdict;

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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictBySchemaIdx.put( newKeySchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByRefSchemaIdx.get( existingKeyRefSchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRefSchemaIdx.containsKey( newKeyRefSchemaIdx ) ) {
			subdict = dictByRefSchemaIdx.get( newKeyRefSchemaIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictByRefSchemaIdx.put( newKeyRefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByPrevIdx.get( existingKeyPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevIdx.containsKey( newKeyPrevIdx ) ) {
			subdict = dictByPrevIdx.get( newKeyPrevIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSchemaRef( ISecureAuthorization Authorization,
		IBusModelSchemaRef iBuff )
	{
		final String S_ProcName = "BusModelRamSchemaRefTable.deleteSchemaRef() ";
		BusModelBuffSchemaRef Buff = (BusModelBuffSchemaRef)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffSchemaRef existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSchemaRef",
				pkey );
		}
		IYCFKeyHash256 varSchemaId = existing.getRequiredSchemaId();
		BusModelBuffSchemaDef container = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
			varSchemaId ));
		if( container == null ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				0,
				"container" );
		}

		IYCFKeyHash256 prevId = existing.getOptionalPrevId();
		IYCFKeyHash256 nextId = existing.getOptionalNextId();

		BusModelBuffSchemaRef prev = null;
		if( ( prevId != null ) )
		{
			prev = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
				prevId ));
			if( prev == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			BusModelBuffSchemaRef editPrev;
			classCode = prev.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				editPrev = (BusModelBuffSchemaRef)(schema.getBusModelBuffFactory().getFactorySchemaRef().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev.set( prev );
			editPrev.setOptionalLookupNext(nextId);
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffSchemaRef next = null;
		if( ( nextId != null ) )
		{
			next = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
				nextId ));
			if( next == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			BusModelBuffSchemaRef editNext;
			classCode = next.getClassCode();
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				editNext = (BusModelBuffSchemaRef)(schema.getBusModelBuffFactory().getFactorySchemaRef().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext.set( next );
			editNext.setOptionalLookupPrev(prevId);
			if( classCode == IBusModelSchemaRef.CLASS_CODE ) {
				schema.getTableSchemaRef().updateSchemaRef( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffSchemaRefBySchemaIdxKey keySchemaIdx = (BusModelBuffSchemaRefBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );

		BusModelBuffSchemaRefByUNameIdxKey keyUNameIdx = (BusModelBuffSchemaRefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByUNameIdxKey();
		keyUNameIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffSchemaRefByRefSchemaIdxKey keyRefSchemaIdx = (BusModelBuffSchemaRefByRefSchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
		keyRefSchemaIdx.setOptionalRefSchemaId( existing.getOptionalRefSchemaId() );

		BusModelBuffSchemaRefByPrevIdxKey keyPrevIdx = (BusModelBuffSchemaRefByPrevIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffSchemaRefByNextIdxKey keyNextIdx = (BusModelBuffSchemaRefByNextIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRef > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySchemaIdx.get( keySchemaIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByRefSchemaIdx.get( keyRefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}
	@Override
	public void deleteSchemaRefBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaId )
	{
		BusModelBuffSchemaRefBySchemaIdxKey key = (BusModelBuffSchemaRefBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newBySchemaIdxKey();
		key.setRequiredSchemaId( argSchemaId );
		deleteSchemaRefBySchemaIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRefBySchemaIdx( ISecureAuthorization Authorization,
		IBusModelSchemaRefBySchemaIdxKey argKey )
	{
		BusModelBuffSchemaRef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRef> matchSet = new LinkedList<BusModelBuffSchemaRef>();
		Iterator<BusModelBuffSchemaRef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRefByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaId,
		String argName )
	{
		BusModelBuffSchemaRefByUNameIdxKey key = (BusModelBuffSchemaRefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByUNameIdxKey();
		key.setRequiredSchemaId( argSchemaId );
		key.setRequiredName( argName );
		deleteSchemaRefByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRefByUNameIdx( ISecureAuthorization Authorization,
		IBusModelSchemaRefByUNameIdxKey argKey )
	{
		BusModelBuffSchemaRef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRef> matchSet = new LinkedList<BusModelBuffSchemaRef>();
		Iterator<BusModelBuffSchemaRef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRefByRefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argRefSchemaId )
	{
		BusModelBuffSchemaRefByRefSchemaIdxKey key = (BusModelBuffSchemaRefByRefSchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
		key.setOptionalRefSchemaId( argRefSchemaId );
		deleteSchemaRefByRefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRefByRefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelSchemaRefByRefSchemaIdxKey argKey )
	{
		BusModelBuffSchemaRef cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalRefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRef> matchSet = new LinkedList<BusModelBuffSchemaRef>();
		Iterator<BusModelBuffSchemaRef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRefByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffSchemaRefByPrevIdxKey key = (BusModelBuffSchemaRefByPrevIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByPrevIdxKey();
		key.setOptionalPrevId( argPrevId );
		deleteSchemaRefByPrevIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRefByPrevIdx( ISecureAuthorization Authorization,
		IBusModelSchemaRefByPrevIdxKey argKey )
	{
		BusModelBuffSchemaRef cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRef> matchSet = new LinkedList<BusModelBuffSchemaRef>();
		Iterator<BusModelBuffSchemaRef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRefByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffSchemaRefByNextIdxKey key = (BusModelBuffSchemaRefByNextIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRef().newByNextIdxKey();
		key.setOptionalNextId( argNextId );
		deleteSchemaRefByNextIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRefByNextIdx( ISecureAuthorization Authorization,
		IBusModelSchemaRefByNextIdxKey argKey )
	{
		BusModelBuffSchemaRef cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRef> matchSet = new LinkedList<BusModelBuffSchemaRef>();
		Iterator<BusModelBuffSchemaRef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRefByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffSchemaRef cur;
		LinkedList<BusModelBuffSchemaRef> matchSet = new LinkedList<BusModelBuffSchemaRef>();
		Iterator<BusModelBuffSchemaRef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRefByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSchemaRefByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRefByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffSchemaRef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRef> matchSet = new LinkedList<BusModelBuffSchemaRef>();
		Iterator<BusModelBuffSchemaRef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRef)(schema.getTableSchemaRef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRef( Authorization, cur );
		}
	}
}
