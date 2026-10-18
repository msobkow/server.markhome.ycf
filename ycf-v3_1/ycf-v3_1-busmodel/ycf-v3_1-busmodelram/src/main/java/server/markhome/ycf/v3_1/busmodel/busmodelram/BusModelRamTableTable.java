
// Description: Java 25 in-memory RAM DbIO implementation for Table.

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
 *	BusModelRamTableTable in-memory RAM DbIO implementation
 *	for Table.
 */
public class BusModelRamTableTable
	implements IBusModelTableTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffTable > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffTable >();
	private Map< BusModelBuffTableBySchemaDefIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >> dictBySchemaDefIdx
		= new HashMap< BusModelBuffTableBySchemaDefIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >>();
	private Map< BusModelBuffTableByCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >> dictByCodeVisIdx
		= new HashMap< BusModelBuffTableByCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >>();
	private Map< BusModelBuffTableBySchemaCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >> dictBySchemaCodeVisIdx
		= new HashMap< BusModelBuffTableBySchemaCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >>();
	private Map< BusModelBuffTableByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffTableByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >>();
	private Map< BusModelBuffTableByUNameIdxKey,
			BusModelBuffTable > dictByUNameIdx
		= new HashMap< BusModelBuffTableByUNameIdxKey,
			BusModelBuffTable >();
	private Map< BusModelBuffTableBySchemaCdIdxKey,
			BusModelBuffTable > dictBySchemaCdIdx
		= new HashMap< BusModelBuffTableBySchemaCdIdxKey,
			BusModelBuffTable >();
	private Map< BusModelBuffTableByPrimaryIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >> dictByPrimaryIndexIdx
		= new HashMap< BusModelBuffTableByPrimaryIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >>();
	private Map< BusModelBuffTableByLookupIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >> dictByLookupIndexIdx
		= new HashMap< BusModelBuffTableByLookupIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >>();
	private Map< BusModelBuffTableByAltIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >> dictByAltIndexIdx
		= new HashMap< BusModelBuffTableByAltIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >>();
	private Map< BusModelBuffTableByQualTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >> dictByQualTableIdx
		= new HashMap< BusModelBuffTableByQualTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffTable >>();

	public BusModelRamTableTable( IBusModelSchema argSchema ) {
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
	public IBusModelTable createTable( ISecureAuthorization Authorization,
		IBusModelTable iBuff )
	{
		final String S_ProcName = "createTable";
		
		BusModelBuffTable Buff = (BusModelBuffTable)(schema.getTableScope().createScope( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffTableBySchemaDefIdxKey keySchemaDefIdx = (BusModelBuffTableBySchemaDefIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaDefIdxKey();
		keySchemaDefIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		BusModelBuffTableByCodeVisIdxKey keyCodeVisIdx = (BusModelBuffTableByCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByCodeVisIdxKey();
		keyCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffTableBySchemaCodeVisIdxKey keySchemaCodeVisIdx = (BusModelBuffTableBySchemaCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
		keySchemaCodeVisIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		keySchemaCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffTableByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffTableByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffTableByUNameIdxKey keyUNameIdx = (BusModelBuffTableByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByUNameIdxKey();
		keyUNameIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffTableBySchemaCdIdxKey keySchemaCdIdx = (BusModelBuffTableBySchemaCdIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCdIdxKey();
		keySchemaCdIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		keySchemaCdIdx.setRequiredTableClassCode( Buff.getRequiredTableClassCode() );

		BusModelBuffTableByPrimaryIndexIdxKey keyPrimaryIndexIdx = (BusModelBuffTableByPrimaryIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByPrimaryIndexIdxKey();
		keyPrimaryIndexIdx.setOptionalPrimaryIndexId( Buff.getOptionalPrimaryIndexId() );

		BusModelBuffTableByLookupIndexIdxKey keyLookupIndexIdx = (BusModelBuffTableByLookupIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByLookupIndexIdxKey();
		keyLookupIndexIdx.setOptionalLookupIndexId( Buff.getOptionalLookupIndexId() );

		BusModelBuffTableByAltIndexIdxKey keyAltIndexIdx = (BusModelBuffTableByAltIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByAltIndexIdxKey();
		keyAltIndexIdx.setOptionalAltIndexId( Buff.getOptionalAltIndexId() );

		BusModelBuffTableByQualTableIdxKey keyQualTableIdx = (BusModelBuffTableByQualTableIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByQualTableIdxKey();
		keyQualTableIdx.setOptionalQualifyingTableId( Buff.getOptionalQualifyingTableId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TableUNameIdx",
				"TableUNameIdx",
				keyUNameIdx );
		}

		if( dictBySchemaCdIdx.containsKey( keySchemaCdIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TableSchemaCodeIdx",
				"TableSchemaCodeIdx",
				keySchemaCdIdx );
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
						Buff.getRequiredSchemaDefId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SchemaDef",
						"SchemaDef",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictSchemaDefIdx;
		if( dictBySchemaDefIdx.containsKey( keySchemaDefIdx ) ) {
			subdictSchemaDefIdx = dictBySchemaDefIdx.get( keySchemaDefIdx );
		}
		else {
			subdictSchemaDefIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictBySchemaDefIdx.put( keySchemaDefIdx, subdictSchemaDefIdx );
		}
		subdictSchemaDefIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictCodeVisIdx;
		if( dictByCodeVisIdx.containsKey( keyCodeVisIdx ) ) {
			subdictCodeVisIdx = dictByCodeVisIdx.get( keyCodeVisIdx );
		}
		else {
			subdictCodeVisIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByCodeVisIdx.put( keyCodeVisIdx, subdictCodeVisIdx );
		}
		subdictCodeVisIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictSchemaCodeVisIdx;
		if( dictBySchemaCodeVisIdx.containsKey( keySchemaCodeVisIdx ) ) {
			subdictSchemaCodeVisIdx = dictBySchemaCodeVisIdx.get( keySchemaCodeVisIdx );
		}
		else {
			subdictSchemaCodeVisIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictBySchemaCodeVisIdx.put( keySchemaCodeVisIdx, subdictSchemaCodeVisIdx );
		}
		subdictSchemaCodeVisIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		dictBySchemaCdIdx.put( keySchemaCdIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictPrimaryIndexIdx;
		if( dictByPrimaryIndexIdx.containsKey( keyPrimaryIndexIdx ) ) {
			subdictPrimaryIndexIdx = dictByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
		}
		else {
			subdictPrimaryIndexIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByPrimaryIndexIdx.put( keyPrimaryIndexIdx, subdictPrimaryIndexIdx );
		}
		subdictPrimaryIndexIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictLookupIndexIdx;
		if( dictByLookupIndexIdx.containsKey( keyLookupIndexIdx ) ) {
			subdictLookupIndexIdx = dictByLookupIndexIdx.get( keyLookupIndexIdx );
		}
		else {
			subdictLookupIndexIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByLookupIndexIdx.put( keyLookupIndexIdx, subdictLookupIndexIdx );
		}
		subdictLookupIndexIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictAltIndexIdx;
		if( dictByAltIndexIdx.containsKey( keyAltIndexIdx ) ) {
			subdictAltIndexIdx = dictByAltIndexIdx.get( keyAltIndexIdx );
		}
		else {
			subdictAltIndexIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByAltIndexIdx.put( keyAltIndexIdx, subdictAltIndexIdx );
		}
		subdictAltIndexIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictQualTableIdx;
		if( dictByQualTableIdx.containsKey( keyQualTableIdx ) ) {
			subdictQualTableIdx = dictByQualTableIdx.get( keyQualTableIdx );
		}
		else {
			subdictQualTableIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByQualTableIdx.put( keyQualTableIdx, subdictQualTableIdx );
		}
		subdictQualTableIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelTable.CLASS_CODE) {
				BusModelBuffTable retbuff = ((BusModelBuffTable)(schema.getBusModelBuffFactory().getFactoryTable().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelTable readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamTable.readDerived";
		IBusModelTable buff;
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
	public IBusModelTable lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamTable.lockDerived";
		IBusModelTable buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTable[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamTable.readAllDerived";
		IBusModelTable[] retList = new IBusModelTable[ dictByPKey.values().size() ];
		Iterator< BusModelBuffTable > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelTable[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelTable ) ) {
					filteredList.add( (IBusModelTable)buff );
				}
			}
			return( filteredList.toArray( new IBusModelTable[0] ) );
		}
	}

	@Override
	public IBusModelTable[] readDerivedBySchemaDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedBySchemaDefIdx";
		BusModelBuffTableBySchemaDefIdxKey key = (BusModelBuffTableBySchemaDefIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaDefIdxKey();

		key.setRequiredSchemaDefId( SchemaDefId );
		IBusModelTable[] recArray;
		if( dictBySchemaDefIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictSchemaDefIdx
				= dictBySchemaDefIdx.get( key );
			recArray = new IBusModelTable[ subdictSchemaDefIdx.size() ];
			Iterator< BusModelBuffTable > iter = subdictSchemaDefIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictSchemaDefIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictBySchemaDefIdx.put( key, subdictSchemaDefIdx );
			recArray = new IBusModelTable[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTable[] readDerivedByCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedByCodeVisIdx";
		BusModelBuffTableByCodeVisIdxKey key = (BusModelBuffTableByCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByCodeVisIdxKey();

		key.setRequiredCodeVis( CodeVis );
		IBusModelTable[] recArray;
		if( dictByCodeVisIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictCodeVisIdx
				= dictByCodeVisIdx.get( key );
			recArray = new IBusModelTable[ subdictCodeVisIdx.size() ];
			Iterator< BusModelBuffTable > iter = subdictCodeVisIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictCodeVisIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByCodeVisIdx.put( key, subdictCodeVisIdx );
			recArray = new IBusModelTable[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTable[] readDerivedBySchemaCodeVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedBySchemaCodeVisIdx";
		BusModelBuffTableBySchemaCodeVisIdxKey key = (BusModelBuffTableBySchemaCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCodeVisIdxKey();

		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredCodeVis( CodeVis );
		IBusModelTable[] recArray;
		if( dictBySchemaCodeVisIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictSchemaCodeVisIdx
				= dictBySchemaCodeVisIdx.get( key );
			recArray = new IBusModelTable[ subdictSchemaCodeVisIdx.size() ];
			Iterator< BusModelBuffTable > iter = subdictSchemaCodeVisIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictSchemaCodeVisIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictBySchemaCodeVisIdx.put( key, subdictSchemaCodeVisIdx );
			recArray = new IBusModelTable[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTable[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedByDefSchemaIdx";
		BusModelBuffTableByDefSchemaIdxKey key = (BusModelBuffTableByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelTable[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelTable[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffTable > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelTable[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTable readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedByUNameIdx";
		BusModelBuffTableByUNameIdxKey key = (BusModelBuffTableByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByUNameIdxKey();

		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		IBusModelTable buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTable readDerivedBySchemaCdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId,
		String TableClassCode )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedBySchemaCdIdx";
		BusModelBuffTableBySchemaCdIdxKey key = (BusModelBuffTableBySchemaCdIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCdIdxKey();

		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		IBusModelTable buff;
		if( dictBySchemaCdIdx.containsKey( key ) ) {
			buff = dictBySchemaCdIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTable[] readDerivedByPrimaryIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrimaryIndexId )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedByPrimaryIndexIdx";
		BusModelBuffTableByPrimaryIndexIdxKey key = (BusModelBuffTableByPrimaryIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByPrimaryIndexIdxKey();

		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		IBusModelTable[] recArray;
		if( dictByPrimaryIndexIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictPrimaryIndexIdx
				= dictByPrimaryIndexIdx.get( key );
			recArray = new IBusModelTable[ subdictPrimaryIndexIdx.size() ];
			Iterator< BusModelBuffTable > iter = subdictPrimaryIndexIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictPrimaryIndexIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByPrimaryIndexIdx.put( key, subdictPrimaryIndexIdx );
			recArray = new IBusModelTable[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTable[] readDerivedByLookupIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 LookupIndexId )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedByLookupIndexIdx";
		BusModelBuffTableByLookupIndexIdxKey key = (BusModelBuffTableByLookupIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByLookupIndexIdxKey();

		key.setOptionalLookupIndexId( LookupIndexId );
		IBusModelTable[] recArray;
		if( dictByLookupIndexIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictLookupIndexIdx
				= dictByLookupIndexIdx.get( key );
			recArray = new IBusModelTable[ subdictLookupIndexIdx.size() ];
			Iterator< BusModelBuffTable > iter = subdictLookupIndexIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictLookupIndexIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByLookupIndexIdx.put( key, subdictLookupIndexIdx );
			recArray = new IBusModelTable[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTable[] readDerivedByAltIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 AltIndexId )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedByAltIndexIdx";
		BusModelBuffTableByAltIndexIdxKey key = (BusModelBuffTableByAltIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByAltIndexIdxKey();

		key.setOptionalAltIndexId( AltIndexId );
		IBusModelTable[] recArray;
		if( dictByAltIndexIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictAltIndexIdx
				= dictByAltIndexIdx.get( key );
			recArray = new IBusModelTable[ subdictAltIndexIdx.size() ];
			Iterator< BusModelBuffTable > iter = subdictAltIndexIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictAltIndexIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByAltIndexIdx.put( key, subdictAltIndexIdx );
			recArray = new IBusModelTable[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTable[] readDerivedByQualTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 QualifyingTableId )
	{
		final String S_ProcName = "BusModelRamTable.readDerivedByQualTableIdx";
		BusModelBuffTableByQualTableIdxKey key = (BusModelBuffTableByQualTableIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByQualTableIdxKey();

		key.setOptionalQualifyingTableId( QualifyingTableId );
		IBusModelTable[] recArray;
		if( dictByQualTableIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictQualTableIdx
				= dictByQualTableIdx.get( key );
			recArray = new IBusModelTable[ subdictQualTableIdx.size() ];
			Iterator< BusModelBuffTable > iter = subdictQualTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdictQualTableIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByQualTableIdx.put( key, subdictQualTableIdx );
			recArray = new IBusModelTable[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelTable readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelTable buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTable readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamTable.readRec";
		IBusModelTable buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelTable.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTable lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelTable buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelTable.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelTable[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamTable.readAllRec";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	@Override
	public IBusModelTable readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelTable buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelTable)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTable[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTable)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	@Override
	public IBusModelTable[] readRecBySchemaDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "BusModelRamTable.readRecBySchemaDefIdx() ";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readDerivedBySchemaDefIdx( Authorization,
			SchemaDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTable)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	@Override
	public IBusModelTable[] readRecByCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamTable.readRecByCodeVisIdx() ";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readDerivedByCodeVisIdx( Authorization,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTable)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	@Override
	public IBusModelTable[] readRecBySchemaCodeVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamTable.readRecBySchemaCodeVisIdx() ";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readDerivedBySchemaCodeVisIdx( Authorization,
			SchemaDefId,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTable)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	@Override
	public IBusModelTable[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamTable.readRecByDefSchemaIdx() ";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTable)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	@Override
	public IBusModelTable readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId,
		String Name )
	{
		final String S_ProcName = "BusModelRamTable.readRecByUNameIdx() ";
		IBusModelTable buff = readDerivedByUNameIdx( Authorization,
			SchemaDefId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
			return( (IBusModelTable)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTable readRecBySchemaCdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId,
		String TableClassCode )
	{
		final String S_ProcName = "BusModelRamTable.readRecBySchemaCdIdx() ";
		IBusModelTable buff = readDerivedBySchemaCdIdx( Authorization,
			SchemaDefId,
			TableClassCode );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
			return( (IBusModelTable)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelTable[] readRecByPrimaryIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrimaryIndexId )
	{
		final String S_ProcName = "BusModelRamTable.readRecByPrimaryIndexIdx() ";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readDerivedByPrimaryIndexIdx( Authorization,
			PrimaryIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTable)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	@Override
	public IBusModelTable[] readRecByLookupIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 LookupIndexId )
	{
		final String S_ProcName = "BusModelRamTable.readRecByLookupIndexIdx() ";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readDerivedByLookupIndexIdx( Authorization,
			LookupIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTable)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	@Override
	public IBusModelTable[] readRecByAltIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 AltIndexId )
	{
		final String S_ProcName = "BusModelRamTable.readRecByAltIndexIdx() ";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readDerivedByAltIndexIdx( Authorization,
			AltIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTable)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	@Override
	public IBusModelTable[] readRecByQualTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 QualifyingTableId )
	{
		final String S_ProcName = "BusModelRamTable.readRecByQualTableIdx() ";
		IBusModelTable buff;
		ArrayList<IBusModelTable> filteredList = new ArrayList<IBusModelTable>();
		IBusModelTable[] buffList = readDerivedByQualTableIdx( Authorization,
			QualifyingTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelTable.CLASS_CODE ) ) {
				filteredList.add( (IBusModelTable)buff );
			}
		}
		return( filteredList.toArray( new IBusModelTable[0] ) );
	}

	public IBusModelTable updateTable( ISecureAuthorization Authorization,
		IBusModelTable iBuff )
	{
		BusModelBuffTable Buff = (BusModelBuffTable)(schema.getTableScope().updateScope( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffTable existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateTable",
				"Existing record not found",
				"Existing record not found",
				"Table",
				"Table",
				pkey );
		}
		BusModelBuffTableBySchemaDefIdxKey existingKeySchemaDefIdx = (BusModelBuffTableBySchemaDefIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaDefIdxKey();
		existingKeySchemaDefIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		BusModelBuffTableBySchemaDefIdxKey newKeySchemaDefIdx = (BusModelBuffTableBySchemaDefIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaDefIdxKey();
		newKeySchemaDefIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		BusModelBuffTableByCodeVisIdxKey existingKeyCodeVisIdx = (BusModelBuffTableByCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByCodeVisIdxKey();
		existingKeyCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffTableByCodeVisIdxKey newKeyCodeVisIdx = (BusModelBuffTableByCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByCodeVisIdxKey();
		newKeyCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffTableBySchemaCodeVisIdxKey existingKeySchemaCodeVisIdx = (BusModelBuffTableBySchemaCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
		existingKeySchemaCodeVisIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		existingKeySchemaCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffTableBySchemaCodeVisIdxKey newKeySchemaCodeVisIdx = (BusModelBuffTableBySchemaCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
		newKeySchemaCodeVisIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		newKeySchemaCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffTableByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffTableByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffTableByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffTableByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffTableByUNameIdxKey existingKeyUNameIdx = (BusModelBuffTableByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffTableByUNameIdxKey newKeyUNameIdx = (BusModelBuffTableByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffTableBySchemaCdIdxKey existingKeySchemaCdIdx = (BusModelBuffTableBySchemaCdIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCdIdxKey();
		existingKeySchemaCdIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		existingKeySchemaCdIdx.setRequiredTableClassCode( existing.getRequiredTableClassCode() );

		BusModelBuffTableBySchemaCdIdxKey newKeySchemaCdIdx = (BusModelBuffTableBySchemaCdIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCdIdxKey();
		newKeySchemaCdIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		newKeySchemaCdIdx.setRequiredTableClassCode( Buff.getRequiredTableClassCode() );

		BusModelBuffTableByPrimaryIndexIdxKey existingKeyPrimaryIndexIdx = (BusModelBuffTableByPrimaryIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByPrimaryIndexIdxKey();
		existingKeyPrimaryIndexIdx.setOptionalPrimaryIndexId( existing.getOptionalPrimaryIndexId() );

		BusModelBuffTableByPrimaryIndexIdxKey newKeyPrimaryIndexIdx = (BusModelBuffTableByPrimaryIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByPrimaryIndexIdxKey();
		newKeyPrimaryIndexIdx.setOptionalPrimaryIndexId( Buff.getOptionalPrimaryIndexId() );

		BusModelBuffTableByLookupIndexIdxKey existingKeyLookupIndexIdx = (BusModelBuffTableByLookupIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByLookupIndexIdxKey();
		existingKeyLookupIndexIdx.setOptionalLookupIndexId( existing.getOptionalLookupIndexId() );

		BusModelBuffTableByLookupIndexIdxKey newKeyLookupIndexIdx = (BusModelBuffTableByLookupIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByLookupIndexIdxKey();
		newKeyLookupIndexIdx.setOptionalLookupIndexId( Buff.getOptionalLookupIndexId() );

		BusModelBuffTableByAltIndexIdxKey existingKeyAltIndexIdx = (BusModelBuffTableByAltIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByAltIndexIdxKey();
		existingKeyAltIndexIdx.setOptionalAltIndexId( existing.getOptionalAltIndexId() );

		BusModelBuffTableByAltIndexIdxKey newKeyAltIndexIdx = (BusModelBuffTableByAltIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByAltIndexIdxKey();
		newKeyAltIndexIdx.setOptionalAltIndexId( Buff.getOptionalAltIndexId() );

		BusModelBuffTableByQualTableIdxKey existingKeyQualTableIdx = (BusModelBuffTableByQualTableIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByQualTableIdxKey();
		existingKeyQualTableIdx.setOptionalQualifyingTableId( existing.getOptionalQualifyingTableId() );

		BusModelBuffTableByQualTableIdxKey newKeyQualTableIdx = (BusModelBuffTableByQualTableIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByQualTableIdxKey();
		newKeyQualTableIdx.setOptionalQualifyingTableId( Buff.getOptionalQualifyingTableId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTable",
					"TableUNameIdx",
					"TableUNameIdx",
					newKeyUNameIdx );
			}
		}

		if( ! existingKeySchemaCdIdx.equals( newKeySchemaCdIdx ) ) {
			if( dictBySchemaCdIdx.containsKey( newKeySchemaCdIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTable",
					"TableSchemaCodeIdx",
					"TableSchemaCodeIdx",
					newKeySchemaCdIdx );
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
						"updateTable",
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
						Buff.getRequiredSchemaDefId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateTable",
						"Container",
						"Container",
						"SchemaDef",
						"SchemaDef",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySchemaDefIdx.get( existingKeySchemaDefIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchemaDefIdx.containsKey( newKeySchemaDefIdx ) ) {
			subdict = dictBySchemaDefIdx.get( newKeySchemaDefIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictBySchemaDefIdx.put( newKeySchemaDefIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByCodeVisIdx.get( existingKeyCodeVisIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCodeVisIdx.containsKey( newKeyCodeVisIdx ) ) {
			subdict = dictByCodeVisIdx.get( newKeyCodeVisIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByCodeVisIdx.put( newKeyCodeVisIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySchemaCodeVisIdx.get( existingKeySchemaCodeVisIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchemaCodeVisIdx.containsKey( newKeySchemaCodeVisIdx ) ) {
			subdict = dictBySchemaCodeVisIdx.get( newKeySchemaCodeVisIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictBySchemaCodeVisIdx.put( newKeySchemaCodeVisIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		dictBySchemaCdIdx.remove( existingKeySchemaCdIdx );
		dictBySchemaCdIdx.put( newKeySchemaCdIdx, Buff );

		subdict = dictByPrimaryIndexIdx.get( existingKeyPrimaryIndexIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrimaryIndexIdx.containsKey( newKeyPrimaryIndexIdx ) ) {
			subdict = dictByPrimaryIndexIdx.get( newKeyPrimaryIndexIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByPrimaryIndexIdx.put( newKeyPrimaryIndexIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByLookupIndexIdx.get( existingKeyLookupIndexIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLookupIndexIdx.containsKey( newKeyLookupIndexIdx ) ) {
			subdict = dictByLookupIndexIdx.get( newKeyLookupIndexIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByLookupIndexIdx.put( newKeyLookupIndexIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByAltIndexIdx.get( existingKeyAltIndexIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByAltIndexIdx.containsKey( newKeyAltIndexIdx ) ) {
			subdict = dictByAltIndexIdx.get( newKeyAltIndexIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByAltIndexIdx.put( newKeyAltIndexIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByQualTableIdx.get( existingKeyQualTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByQualTableIdx.containsKey( newKeyQualTableIdx ) ) {
			subdict = dictByQualTableIdx.get( newKeyQualTableIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffTable >();
			dictByQualTableIdx.put( newKeyQualTableIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteTable( ISecureAuthorization Authorization,
		IBusModelTable iBuff )
	{
		final String S_ProcName = "BusModelRamTableTable.deleteTable() ";
		BusModelBuffTable Buff = (BusModelBuffTable)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffTable existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteTable",
				pkey );
		}
					{
						BusModelBuffTable editBuff = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
						existing.getRequiredId() ));
						editBuff.setOptionalLookupPrimaryIndex((IYCFKeyHash256)null);
						classCode = editBuff.getClassCode();
						if( classCode == IBusModelTable.CLASS_CODE ) {
							schema.getTableTable().updateTable( Authorization, editBuff );
						}
						else {
							throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-clear-top-dep-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
						}
					}
		BusModelBuffTable editSubobj = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
			existing.getRequiredId() ));
			editSubobj.setOptionalLookupLookupIndex((IYCFKeyHash256)null);
			editSubobj.setOptionalLookupAltIndex((IYCFKeyHash256)null);
			editSubobj.setOptionalLookupPrimaryIndex((IYCFKeyHash256)null);
		classCode = editSubobj.getClassCode();
		if( classCode == IBusModelTable.CLASS_CODE ) {
			schema.getTableTable().updateTable( Authorization, editSubobj );
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-clear-root-subobject-refs-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
		}
		existing = editSubobj;
					schema.getTableServerMethod().deleteServerMethodByMethTableIdx( Authorization,
						existing.getRequiredId() );
					schema.getTableDelTopDep().deleteDelTopDepByDelTopDepTblIdx( Authorization,
						existing.getRequiredId() );
					schema.getTableClearTopDep().deleteClearTopDepByClrTopDepTblIdx( Authorization,
						existing.getRequiredId() );
					schema.getTableChain().deleteChainByChainTableIdx( Authorization,
						existing.getRequiredId() );
		BusModelBuffRelation buffDelTableRelationPopDep;
		IBusModelRelation arrDelTableRelationPopDep[] = schema.getTableRelation().readDerivedByRelTableIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableRelationPopDep = 0; idxDelTableRelationPopDep < arrDelTableRelationPopDep.length; idxDelTableRelationPopDep++ ) {
			buffDelTableRelationPopDep = (BusModelBuffRelation)(arrDelTableRelationPopDep[idxDelTableRelationPopDep]);
					schema.getTablePopTopDep().deletePopTopDepByContRelIdx( Authorization,
						buffDelTableRelationPopDep.getRequiredId() );
		}
		BusModelBuffRelation buffDelTableRelationCol;
		IBusModelRelation arrDelTableRelationCol[] = schema.getTableRelation().readDerivedByRelTableIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableRelationCol = 0; idxDelTableRelationCol < arrDelTableRelationCol.length; idxDelTableRelationCol++ ) {
			buffDelTableRelationCol = (BusModelBuffRelation)(arrDelTableRelationCol[idxDelTableRelationCol]);
					schema.getTableRelationCol().deleteRelationColByRelationIdx( Authorization,
						buffDelTableRelationCol.getRequiredId() );
		}
					schema.getTableRelation().deleteRelationByRelTableIdx( Authorization,
						existing.getRequiredId() );
		BusModelBuffIndex buffDelTableIndexRefRelFmCol;
		IBusModelIndex arrDelTableIndexRefRelFmCol[] = schema.getTableIndex().readDerivedByIdxTableIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableIndexRefRelFmCol = 0; idxDelTableIndexRefRelFmCol < arrDelTableIndexRefRelFmCol.length; idxDelTableIndexRefRelFmCol++ ) {
			buffDelTableIndexRefRelFmCol = (BusModelBuffIndex)(arrDelTableIndexRefRelFmCol[idxDelTableIndexRefRelFmCol]);
			BusModelBuffIndexCol buffColumns;
			IBusModelIndexCol arrColumns[] = schema.getTableIndexCol().readDerivedByIndexIdx( Authorization,
				buffDelTableIndexRefRelFmCol.getRequiredId() );
			for( int idxColumns = 0; idxColumns < arrColumns.length; idxColumns++ ) {
				buffColumns = (BusModelBuffIndexCol)(arrColumns[idxColumns]);
					schema.getTableRelationCol().deleteRelationColByFromColIdx( Authorization,
						buffColumns.getRequiredId() );
			}
		}
		BusModelBuffIndex buffDelTableIndexRefRelToCol;
		IBusModelIndex arrDelTableIndexRefRelToCol[] = schema.getTableIndex().readDerivedByIdxTableIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableIndexRefRelToCol = 0; idxDelTableIndexRefRelToCol < arrDelTableIndexRefRelToCol.length; idxDelTableIndexRefRelToCol++ ) {
			buffDelTableIndexRefRelToCol = (BusModelBuffIndex)(arrDelTableIndexRefRelToCol[idxDelTableIndexRefRelToCol]);
			BusModelBuffIndexCol buffColumns;
			IBusModelIndexCol arrColumns[] = schema.getTableIndexCol().readDerivedByIndexIdx( Authorization,
				buffDelTableIndexRefRelToCol.getRequiredId() );
			for( int idxColumns = 0; idxColumns < arrColumns.length; idxColumns++ ) {
				buffColumns = (BusModelBuffIndexCol)(arrColumns[idxColumns]);
					schema.getTableRelationCol().deleteRelationColByToColIdx( Authorization,
						buffColumns.getRequiredId() );
			}
		}
		BusModelBuffIndex buffDelTableIndexCol;
		IBusModelIndex arrDelTableIndexCol[] = schema.getTableIndex().readDerivedByIdxTableIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableIndexCol = 0; idxDelTableIndexCol < arrDelTableIndexCol.length; idxDelTableIndexCol++ ) {
			buffDelTableIndexCol = (BusModelBuffIndex)(arrDelTableIndexCol[idxDelTableIndexCol]);
					schema.getTableIndexCol().deleteIndexColByIndexIdx( Authorization,
						buffDelTableIndexCol.getRequiredId() );
		}
					schema.getTableIndex().deleteIndexByIdxTableIdx( Authorization,
						existing.getRequiredId() );
		BusModelBuffValue buffDelTableRefIndexColumns;
		IBusModelValue arrDelTableRefIndexColumns[] = schema.getTableValue().readDerivedByScopeIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableRefIndexColumns = 0; idxDelTableRefIndexColumns < arrDelTableRefIndexColumns.length; idxDelTableRefIndexColumns++ ) {
			buffDelTableRefIndexColumns = (BusModelBuffValue)(arrDelTableRefIndexColumns[idxDelTableRefIndexColumns]);
					schema.getTableIndexCol().deleteIndexColByColIdx( Authorization,
						buffDelTableRefIndexColumns.getRequiredId() );
		}
					schema.getTableValue().deleteValueByScopeIdx( Authorization,
						existing.getRequiredId() );
		BusModelBuffTableBySchemaDefIdxKey keySchemaDefIdx = (BusModelBuffTableBySchemaDefIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaDefIdxKey();
		keySchemaDefIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		BusModelBuffTableByCodeVisIdxKey keyCodeVisIdx = (BusModelBuffTableByCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByCodeVisIdxKey();
		keyCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffTableBySchemaCodeVisIdxKey keySchemaCodeVisIdx = (BusModelBuffTableBySchemaCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
		keySchemaCodeVisIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keySchemaCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffTableByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffTableByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffTableByUNameIdxKey keyUNameIdx = (BusModelBuffTableByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByUNameIdxKey();
		keyUNameIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffTableBySchemaCdIdxKey keySchemaCdIdx = (BusModelBuffTableBySchemaCdIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCdIdxKey();
		keySchemaCdIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keySchemaCdIdx.setRequiredTableClassCode( existing.getRequiredTableClassCode() );

		BusModelBuffTableByPrimaryIndexIdxKey keyPrimaryIndexIdx = (BusModelBuffTableByPrimaryIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByPrimaryIndexIdxKey();
		keyPrimaryIndexIdx.setOptionalPrimaryIndexId( existing.getOptionalPrimaryIndexId() );

		BusModelBuffTableByLookupIndexIdxKey keyLookupIndexIdx = (BusModelBuffTableByLookupIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByLookupIndexIdxKey();
		keyLookupIndexIdx.setOptionalLookupIndexId( existing.getOptionalLookupIndexId() );

		BusModelBuffTableByAltIndexIdxKey keyAltIndexIdx = (BusModelBuffTableByAltIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByAltIndexIdxKey();
		keyAltIndexIdx.setOptionalAltIndexId( existing.getOptionalAltIndexId() );

		BusModelBuffTableByQualTableIdxKey keyQualTableIdx = (BusModelBuffTableByQualTableIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByQualTableIdxKey();
		keyQualTableIdx.setOptionalQualifyingTableId( existing.getOptionalQualifyingTableId() );

		// Validate reverse foreign keys

		if( schema.getTableRelation().readDerivedByToTblIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteTable",
				"Lookup",
				"Lookup",
				"ToTable",
				"ToTable",
				"Relation",
				"Relation",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffTable > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySchemaDefIdx.get( keySchemaDefIdx );
		subdict.remove( pkey );

		subdict = dictByCodeVisIdx.get( keyCodeVisIdx );
		subdict.remove( pkey );

		subdict = dictBySchemaCodeVisIdx.get( keySchemaCodeVisIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		dictBySchemaCdIdx.remove( keySchemaCdIdx );

		subdict = dictByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
		subdict.remove( pkey );

		subdict = dictByLookupIndexIdx.get( keyLookupIndexIdx );
		subdict.remove( pkey );

		subdict = dictByAltIndexIdx.get( keyAltIndexIdx );
		subdict.remove( pkey );

		subdict = dictByQualTableIdx.get( keyQualTableIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}
	@Override
	public void deleteTableBySchemaDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		BusModelBuffTableBySchemaDefIdxKey key = (BusModelBuffTableBySchemaDefIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaDefIdxKey();
		key.setRequiredSchemaDefId( argSchemaDefId );
		deleteTableBySchemaDefIdx( Authorization, key );
	}

	@Override
	public void deleteTableBySchemaDefIdx( ISecureAuthorization Authorization,
		IBusModelTableBySchemaDefIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableByCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffTableByCodeVisIdxKey key = (BusModelBuffTableByCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByCodeVisIdxKey();
		key.setRequiredCodeVis( argCodeVis );
		deleteTableByCodeVisIdx( Authorization, key );
	}

	@Override
	public void deleteTableByCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelTableByCodeVisIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableBySchemaCodeVisIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffTableBySchemaCodeVisIdxKey key = (BusModelBuffTableBySchemaCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
		key.setRequiredSchemaDefId( argSchemaDefId );
		key.setRequiredCodeVis( argCodeVis );
		deleteTableBySchemaCodeVisIdx( Authorization, key );
	}

	@Override
	public void deleteTableBySchemaCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelTableBySchemaCodeVisIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffTableByDefSchemaIdxKey key = (BusModelBuffTableByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteTableByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteTableByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelTableByDefSchemaIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId,
		String argName )
	{
		BusModelBuffTableByUNameIdxKey key = (BusModelBuffTableByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByUNameIdxKey();
		key.setRequiredSchemaDefId( argSchemaDefId );
		key.setRequiredName( argName );
		deleteTableByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteTableByUNameIdx( ISecureAuthorization Authorization,
		IBusModelTableByUNameIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableBySchemaCdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId,
		String argTableClassCode )
	{
		BusModelBuffTableBySchemaCdIdxKey key = (BusModelBuffTableBySchemaCdIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newBySchemaCdIdxKey();
		key.setRequiredSchemaDefId( argSchemaDefId );
		key.setRequiredTableClassCode( argTableClassCode );
		deleteTableBySchemaCdIdx( Authorization, key );
	}

	@Override
	public void deleteTableBySchemaCdIdx( ISecureAuthorization Authorization,
		IBusModelTableBySchemaCdIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableByPrimaryIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrimaryIndexId )
	{
		BusModelBuffTableByPrimaryIndexIdxKey key = (BusModelBuffTableByPrimaryIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexId( argPrimaryIndexId );
		deleteTableByPrimaryIndexIdx( Authorization, key );
	}

	@Override
	public void deleteTableByPrimaryIndexIdx( ISecureAuthorization Authorization,
		IBusModelTableByPrimaryIndexIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrimaryIndexId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableByLookupIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argLookupIndexId )
	{
		BusModelBuffTableByLookupIndexIdxKey key = (BusModelBuffTableByLookupIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByLookupIndexIdxKey();
		key.setOptionalLookupIndexId( argLookupIndexId );
		deleteTableByLookupIndexIdx( Authorization, key );
	}

	@Override
	public void deleteTableByLookupIndexIdx( ISecureAuthorization Authorization,
		IBusModelTableByLookupIndexIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalLookupIndexId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableByAltIndexIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argAltIndexId )
	{
		BusModelBuffTableByAltIndexIdxKey key = (BusModelBuffTableByAltIndexIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByAltIndexIdxKey();
		key.setOptionalAltIndexId( argAltIndexId );
		deleteTableByAltIndexIdx( Authorization, key );
	}

	@Override
	public void deleteTableByAltIndexIdx( ISecureAuthorization Authorization,
		IBusModelTableByAltIndexIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalAltIndexId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableByQualTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argQualifyingTableId )
	{
		BusModelBuffTableByQualTableIdxKey key = (BusModelBuffTableByQualTableIdxKey)schema.getBusModelBuffFactory().getFactoryTable().newByQualTableIdxKey();
		key.setOptionalQualifyingTableId( argQualifyingTableId );
		deleteTableByQualTableIdx( Authorization, key );
	}

	@Override
	public void deleteTableByQualTableIdx( ISecureAuthorization Authorization,
		IBusModelTableByQualTableIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalQualifyingTableId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffTable cur;
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}

	@Override
	public void deleteTableByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTableByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteTableByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffTable cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffTable> matchSet = new LinkedList<BusModelBuffTable>();
		Iterator<BusModelBuffTable> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffTable> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffTable)(schema.getTableTable().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTable( Authorization, cur );
		}
	}
}
