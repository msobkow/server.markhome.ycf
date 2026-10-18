
// Description: Java 25 in-memory RAM DbIO implementation for Relation.

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
 *	BusModelRamRelationTable in-memory RAM DbIO implementation
 *	for Relation.
 */
public class BusModelRamRelationTable
	implements IBusModelRelationTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffRelation > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffRelation >();
	private Map< BusModelBuffRelationByUNameIdxKey,
			BusModelBuffRelation > dictByUNameIdx
		= new HashMap< BusModelBuffRelationByUNameIdxKey,
			BusModelBuffRelation >();
	private Map< BusModelBuffRelationByRelTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >> dictByRelTableIdx
		= new HashMap< BusModelBuffRelationByRelTableIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >>();
	private Map< BusModelBuffRelationByRelCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >> dictByRelCodeVisIdx
		= new HashMap< BusModelBuffRelationByRelCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >>();
	private Map< BusModelBuffRelationByRelTableCodeVisXKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >> dictByRelTableCodeVisX
		= new HashMap< BusModelBuffRelationByRelTableCodeVisXKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >>();
	private Map< BusModelBuffRelationByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffRelationByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >>();
	private Map< BusModelBuffRelationByFromKeyIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >> dictByFromKeyIdx
		= new HashMap< BusModelBuffRelationByFromKeyIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >>();
	private Map< BusModelBuffRelationByToTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >> dictByToTblIdx
		= new HashMap< BusModelBuffRelationByToTblIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >>();
	private Map< BusModelBuffRelationByToKeyIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >> dictByToKeyIdx
		= new HashMap< BusModelBuffRelationByToKeyIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >>();
	private Map< BusModelBuffRelationByNarrowedIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >> dictByNarrowedIdx
		= new HashMap< BusModelBuffRelationByNarrowedIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffRelation >>();

	public BusModelRamRelationTable( IBusModelSchema argSchema ) {
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
	public IBusModelRelation createRelation( ISecureAuthorization Authorization,
		IBusModelRelation iBuff )
	{
		final String S_ProcName = "createRelation";
		
		BusModelBuffRelation Buff = (BusModelBuffRelation)(schema.getTableScope().createScope( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffRelationByUNameIdxKey keyUNameIdx = (BusModelBuffRelationByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffRelationByRelTableIdxKey keyRelTableIdx = (BusModelBuffRelationByRelTableIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableIdxKey();
		keyRelTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffRelationByRelCodeVisIdxKey keyRelCodeVisIdx = (BusModelBuffRelationByRelCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelCodeVisIdxKey();
		keyRelCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffRelationByRelTableCodeVisXKey keyRelTableCodeVisX = (BusModelBuffRelationByRelTableCodeVisXKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableCodeVisXKey();
		keyRelTableCodeVisX.setRequiredTableId( Buff.getRequiredTableId() );
		keyRelTableCodeVisX.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffRelationByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffRelationByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffRelationByFromKeyIdxKey keyFromKeyIdx = (BusModelBuffRelationByFromKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByFromKeyIdxKey();
		keyFromKeyIdx.setRequiredFromIndexId( Buff.getRequiredFromIndexId() );

		BusModelBuffRelationByToTblIdxKey keyToTblIdx = (BusModelBuffRelationByToTblIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToTblIdxKey();
		keyToTblIdx.setRequiredToTableId( Buff.getRequiredToTableId() );

		BusModelBuffRelationByToKeyIdxKey keyToKeyIdx = (BusModelBuffRelationByToKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToKeyIdxKey();
		keyToKeyIdx.setRequiredToIndexId( Buff.getRequiredToIndexId() );

		BusModelBuffRelationByNarrowedIdxKey keyNarrowedIdx = (BusModelBuffRelationByNarrowedIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByNarrowedIdxKey();
		keyNarrowedIdx.setOptionalNarrowedId( Buff.getOptionalNarrowedId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"RelationUNameIdx",
				"RelationUNameIdx",
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
						"FromTable",
						"FromTable",
						"Table",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredFromIndexId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"FromIndex",
						"FromIndex",
						"Index",
						"Index",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToTableId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"ToTable",
						"ToTable",
						"Table",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToIndexId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Lookup",
						"Lookup",
						"ToIndex",
						"ToIndex",
						"Index",
						"Index",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictRelTableIdx;
		if( dictByRelTableIdx.containsKey( keyRelTableIdx ) ) {
			subdictRelTableIdx = dictByRelTableIdx.get( keyRelTableIdx );
		}
		else {
			subdictRelTableIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByRelTableIdx.put( keyRelTableIdx, subdictRelTableIdx );
		}
		subdictRelTableIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictRelCodeVisIdx;
		if( dictByRelCodeVisIdx.containsKey( keyRelCodeVisIdx ) ) {
			subdictRelCodeVisIdx = dictByRelCodeVisIdx.get( keyRelCodeVisIdx );
		}
		else {
			subdictRelCodeVisIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByRelCodeVisIdx.put( keyRelCodeVisIdx, subdictRelCodeVisIdx );
		}
		subdictRelCodeVisIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictRelTableCodeVisX;
		if( dictByRelTableCodeVisX.containsKey( keyRelTableCodeVisX ) ) {
			subdictRelTableCodeVisX = dictByRelTableCodeVisX.get( keyRelTableCodeVisX );
		}
		else {
			subdictRelTableCodeVisX = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByRelTableCodeVisX.put( keyRelTableCodeVisX, subdictRelTableCodeVisX );
		}
		subdictRelTableCodeVisX.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictFromKeyIdx;
		if( dictByFromKeyIdx.containsKey( keyFromKeyIdx ) ) {
			subdictFromKeyIdx = dictByFromKeyIdx.get( keyFromKeyIdx );
		}
		else {
			subdictFromKeyIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByFromKeyIdx.put( keyFromKeyIdx, subdictFromKeyIdx );
		}
		subdictFromKeyIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictToTblIdx;
		if( dictByToTblIdx.containsKey( keyToTblIdx ) ) {
			subdictToTblIdx = dictByToTblIdx.get( keyToTblIdx );
		}
		else {
			subdictToTblIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByToTblIdx.put( keyToTblIdx, subdictToTblIdx );
		}
		subdictToTblIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictToKeyIdx;
		if( dictByToKeyIdx.containsKey( keyToKeyIdx ) ) {
			subdictToKeyIdx = dictByToKeyIdx.get( keyToKeyIdx );
		}
		else {
			subdictToKeyIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByToKeyIdx.put( keyToKeyIdx, subdictToKeyIdx );
		}
		subdictToKeyIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictNarrowedIdx;
		if( dictByNarrowedIdx.containsKey( keyNarrowedIdx ) ) {
			subdictNarrowedIdx = dictByNarrowedIdx.get( keyNarrowedIdx );
		}
		else {
			subdictNarrowedIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByNarrowedIdx.put( keyNarrowedIdx, subdictNarrowedIdx );
		}
		subdictNarrowedIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelRelation.CLASS_CODE) {
				BusModelBuffRelation retbuff = ((BusModelBuffRelation)(schema.getBusModelBuffFactory().getFactoryRelation().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelRelation readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamRelation.readDerived";
		IBusModelRelation buff;
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
	public IBusModelRelation lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamRelation.lockDerived";
		IBusModelRelation buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelation[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamRelation.readAllDerived";
		IBusModelRelation[] retList = new IBusModelRelation[ dictByPKey.values().size() ];
		Iterator< BusModelBuffRelation > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelRelation[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
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
			ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelRelation ) ) {
					filteredList.add( (IBusModelRelation)buff );
				}
			}
			return( filteredList.toArray( new IBusModelRelation[0] ) );
		}
	}

	@Override
	public IBusModelRelation readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRelation.readDerivedByUNameIdx";
		BusModelBuffRelationByUNameIdxKey key = (BusModelBuffRelationByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByUNameIdxKey();

		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelRelation buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelation[] readDerivedByRelTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamRelation.readDerivedByRelTableIdx";
		BusModelBuffRelationByRelTableIdxKey key = (BusModelBuffRelationByRelTableIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableIdxKey();

		key.setRequiredTableId( TableId );
		IBusModelRelation[] recArray;
		if( dictByRelTableIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictRelTableIdx
				= dictByRelTableIdx.get( key );
			recArray = new IBusModelRelation[ subdictRelTableIdx.size() ];
			Iterator< BusModelBuffRelation > iter = subdictRelTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictRelTableIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByRelTableIdx.put( key, subdictRelTableIdx );
			recArray = new IBusModelRelation[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelation[] readDerivedByRelCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamRelation.readDerivedByRelCodeVisIdx";
		BusModelBuffRelationByRelCodeVisIdxKey key = (BusModelBuffRelationByRelCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelCodeVisIdxKey();

		key.setRequiredCodeVis( CodeVis );
		IBusModelRelation[] recArray;
		if( dictByRelCodeVisIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictRelCodeVisIdx
				= dictByRelCodeVisIdx.get( key );
			recArray = new IBusModelRelation[ subdictRelCodeVisIdx.size() ];
			Iterator< BusModelBuffRelation > iter = subdictRelCodeVisIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictRelCodeVisIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByRelCodeVisIdx.put( key, subdictRelCodeVisIdx );
			recArray = new IBusModelRelation[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelation[] readDerivedByRelTableCodeVisX( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamRelation.readDerivedByRelTableCodeVisX";
		BusModelBuffRelationByRelTableCodeVisXKey key = (BusModelBuffRelationByRelTableCodeVisXKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableCodeVisXKey();

		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		IBusModelRelation[] recArray;
		if( dictByRelTableCodeVisX.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictRelTableCodeVisX
				= dictByRelTableCodeVisX.get( key );
			recArray = new IBusModelRelation[ subdictRelTableCodeVisX.size() ];
			Iterator< BusModelBuffRelation > iter = subdictRelTableCodeVisX.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictRelTableCodeVisX
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByRelTableCodeVisX.put( key, subdictRelTableCodeVisX );
			recArray = new IBusModelRelation[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelation[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamRelation.readDerivedByDefSchemaIdx";
		BusModelBuffRelationByDefSchemaIdxKey key = (BusModelBuffRelationByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelRelation[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelRelation[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffRelation > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelRelation[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelation[] readDerivedByFromKeyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 FromIndexId )
	{
		final String S_ProcName = "BusModelRamRelation.readDerivedByFromKeyIdx";
		BusModelBuffRelationByFromKeyIdxKey key = (BusModelBuffRelationByFromKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByFromKeyIdxKey();

		key.setRequiredFromIndexId( FromIndexId );
		IBusModelRelation[] recArray;
		if( dictByFromKeyIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictFromKeyIdx
				= dictByFromKeyIdx.get( key );
			recArray = new IBusModelRelation[ subdictFromKeyIdx.size() ];
			Iterator< BusModelBuffRelation > iter = subdictFromKeyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictFromKeyIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByFromKeyIdx.put( key, subdictFromKeyIdx );
			recArray = new IBusModelRelation[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelation[] readDerivedByToTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ToTableId )
	{
		final String S_ProcName = "BusModelRamRelation.readDerivedByToTblIdx";
		BusModelBuffRelationByToTblIdxKey key = (BusModelBuffRelationByToTblIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToTblIdxKey();

		key.setRequiredToTableId( ToTableId );
		IBusModelRelation[] recArray;
		if( dictByToTblIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictToTblIdx
				= dictByToTblIdx.get( key );
			recArray = new IBusModelRelation[ subdictToTblIdx.size() ];
			Iterator< BusModelBuffRelation > iter = subdictToTblIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictToTblIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByToTblIdx.put( key, subdictToTblIdx );
			recArray = new IBusModelRelation[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelation[] readDerivedByToKeyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ToIndexId )
	{
		final String S_ProcName = "BusModelRamRelation.readDerivedByToKeyIdx";
		BusModelBuffRelationByToKeyIdxKey key = (BusModelBuffRelationByToKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToKeyIdxKey();

		key.setRequiredToIndexId( ToIndexId );
		IBusModelRelation[] recArray;
		if( dictByToKeyIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictToKeyIdx
				= dictByToKeyIdx.get( key );
			recArray = new IBusModelRelation[ subdictToKeyIdx.size() ];
			Iterator< BusModelBuffRelation > iter = subdictToKeyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictToKeyIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByToKeyIdx.put( key, subdictToKeyIdx );
			recArray = new IBusModelRelation[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelation[] readDerivedByNarrowedIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NarrowedId )
	{
		final String S_ProcName = "BusModelRamRelation.readDerivedByNarrowedIdx";
		BusModelBuffRelationByNarrowedIdxKey key = (BusModelBuffRelationByNarrowedIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByNarrowedIdxKey();

		key.setOptionalNarrowedId( NarrowedId );
		IBusModelRelation[] recArray;
		if( dictByNarrowedIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictNarrowedIdx
				= dictByNarrowedIdx.get( key );
			recArray = new IBusModelRelation[ subdictNarrowedIdx.size() ];
			Iterator< BusModelBuffRelation > iter = subdictNarrowedIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdictNarrowedIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByNarrowedIdx.put( key, subdictNarrowedIdx );
			recArray = new IBusModelRelation[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelRelation readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelRelation buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelation readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamRelation.readRec";
		IBusModelRelation buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelRelation.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelation lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelRelation buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelRelation.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelRelation[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamRelation.readAllRec";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	@Override
	public IBusModelRelation readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelRelation buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelRelation)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelRelation[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelation)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	@Override
	public IBusModelRelation readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRelation.readRecByUNameIdx() ";
		IBusModelRelation buff = readDerivedByUNameIdx( Authorization,
			TableId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
			return( (IBusModelRelation)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelRelation[] readRecByRelTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "BusModelRamRelation.readRecByRelTableIdx() ";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readDerivedByRelTableIdx( Authorization,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelation)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	@Override
	public IBusModelRelation[] readRecByRelCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamRelation.readRecByRelCodeVisIdx() ";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readDerivedByRelCodeVisIdx( Authorization,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelation)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	@Override
	public IBusModelRelation[] readRecByRelTableCodeVisX( ISecureAuthorization Authorization,
		IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "BusModelRamRelation.readRecByRelTableCodeVisX() ";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readDerivedByRelTableCodeVisX( Authorization,
			TableId,
			CodeVis );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelation)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	@Override
	public IBusModelRelation[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamRelation.readRecByDefSchemaIdx() ";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelation)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	@Override
	public IBusModelRelation[] readRecByFromKeyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 FromIndexId )
	{
		final String S_ProcName = "BusModelRamRelation.readRecByFromKeyIdx() ";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readDerivedByFromKeyIdx( Authorization,
			FromIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelation)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	@Override
	public IBusModelRelation[] readRecByToTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ToTableId )
	{
		final String S_ProcName = "BusModelRamRelation.readRecByToTblIdx() ";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readDerivedByToTblIdx( Authorization,
			ToTableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelation)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	@Override
	public IBusModelRelation[] readRecByToKeyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ToIndexId )
	{
		final String S_ProcName = "BusModelRamRelation.readRecByToKeyIdx() ";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readDerivedByToKeyIdx( Authorization,
			ToIndexId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelation)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	@Override
	public IBusModelRelation[] readRecByNarrowedIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NarrowedId )
	{
		final String S_ProcName = "BusModelRamRelation.readRecByNarrowedIdx() ";
		IBusModelRelation buff;
		ArrayList<IBusModelRelation> filteredList = new ArrayList<IBusModelRelation>();
		IBusModelRelation[] buffList = readDerivedByNarrowedIdx( Authorization,
			NarrowedId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRelation.CLASS_CODE ) ) {
				filteredList.add( (IBusModelRelation)buff );
			}
		}
		return( filteredList.toArray( new IBusModelRelation[0] ) );
	}

	public IBusModelRelation updateRelation( ISecureAuthorization Authorization,
		IBusModelRelation iBuff )
	{
		BusModelBuffRelation Buff = (BusModelBuffRelation)(schema.getTableScope().updateScope( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffRelation existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateRelation",
				"Existing record not found",
				"Existing record not found",
				"Relation",
				"Relation",
				pkey );
		}
		BusModelBuffRelationByUNameIdxKey existingKeyUNameIdx = (BusModelBuffRelationByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffRelationByUNameIdxKey newKeyUNameIdx = (BusModelBuffRelationByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffRelationByRelTableIdxKey existingKeyRelTableIdx = (BusModelBuffRelationByRelTableIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableIdxKey();
		existingKeyRelTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffRelationByRelTableIdxKey newKeyRelTableIdx = (BusModelBuffRelationByRelTableIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableIdxKey();
		newKeyRelTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		BusModelBuffRelationByRelCodeVisIdxKey existingKeyRelCodeVisIdx = (BusModelBuffRelationByRelCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelCodeVisIdxKey();
		existingKeyRelCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffRelationByRelCodeVisIdxKey newKeyRelCodeVisIdx = (BusModelBuffRelationByRelCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelCodeVisIdxKey();
		newKeyRelCodeVisIdx.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffRelationByRelTableCodeVisXKey existingKeyRelTableCodeVisX = (BusModelBuffRelationByRelTableCodeVisXKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableCodeVisXKey();
		existingKeyRelTableCodeVisX.setRequiredTableId( existing.getRequiredTableId() );
		existingKeyRelTableCodeVisX.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffRelationByRelTableCodeVisXKey newKeyRelTableCodeVisX = (BusModelBuffRelationByRelTableCodeVisXKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableCodeVisXKey();
		newKeyRelTableCodeVisX.setRequiredTableId( Buff.getRequiredTableId() );
		newKeyRelTableCodeVisX.setRequiredCodeVis( Buff.getRequiredCodeVis() );

		BusModelBuffRelationByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffRelationByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffRelationByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffRelationByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffRelationByFromKeyIdxKey existingKeyFromKeyIdx = (BusModelBuffRelationByFromKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByFromKeyIdxKey();
		existingKeyFromKeyIdx.setRequiredFromIndexId( existing.getRequiredFromIndexId() );

		BusModelBuffRelationByFromKeyIdxKey newKeyFromKeyIdx = (BusModelBuffRelationByFromKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByFromKeyIdxKey();
		newKeyFromKeyIdx.setRequiredFromIndexId( Buff.getRequiredFromIndexId() );

		BusModelBuffRelationByToTblIdxKey existingKeyToTblIdx = (BusModelBuffRelationByToTblIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToTblIdxKey();
		existingKeyToTblIdx.setRequiredToTableId( existing.getRequiredToTableId() );

		BusModelBuffRelationByToTblIdxKey newKeyToTblIdx = (BusModelBuffRelationByToTblIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToTblIdxKey();
		newKeyToTblIdx.setRequiredToTableId( Buff.getRequiredToTableId() );

		BusModelBuffRelationByToKeyIdxKey existingKeyToKeyIdx = (BusModelBuffRelationByToKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToKeyIdxKey();
		existingKeyToKeyIdx.setRequiredToIndexId( existing.getRequiredToIndexId() );

		BusModelBuffRelationByToKeyIdxKey newKeyToKeyIdx = (BusModelBuffRelationByToKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToKeyIdxKey();
		newKeyToKeyIdx.setRequiredToIndexId( Buff.getRequiredToIndexId() );

		BusModelBuffRelationByNarrowedIdxKey existingKeyNarrowedIdx = (BusModelBuffRelationByNarrowedIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByNarrowedIdxKey();
		existingKeyNarrowedIdx.setOptionalNarrowedId( existing.getOptionalNarrowedId() );

		BusModelBuffRelationByNarrowedIdxKey newKeyNarrowedIdx = (BusModelBuffRelationByNarrowedIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByNarrowedIdxKey();
		newKeyNarrowedIdx.setOptionalNarrowedId( Buff.getOptionalNarrowedId() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateRelation",
					"RelationUNameIdx",
					"RelationUNameIdx",
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
						"updateRelation",
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
						"updateRelation",
						"Container",
						"Container",
						"FromTable",
						"FromTable",
						"Table",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredFromIndexId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateRelation",
						"Lookup",
						"Lookup",
						"FromIndex",
						"FromIndex",
						"Index",
						"Index",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToTableId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateRelation",
						"Lookup",
						"Lookup",
						"ToTable",
						"ToTable",
						"Table",
						"Table",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableIndex().readDerivedByIdIdx( Authorization,
						Buff.getRequiredToIndexId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateRelation",
						"Lookup",
						"Lookup",
						"ToIndex",
						"ToIndex",
						"Index",
						"Index",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByRelTableIdx.get( existingKeyRelTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelTableIdx.containsKey( newKeyRelTableIdx ) ) {
			subdict = dictByRelTableIdx.get( newKeyRelTableIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByRelTableIdx.put( newKeyRelTableIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRelCodeVisIdx.get( existingKeyRelCodeVisIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelCodeVisIdx.containsKey( newKeyRelCodeVisIdx ) ) {
			subdict = dictByRelCodeVisIdx.get( newKeyRelCodeVisIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByRelCodeVisIdx.put( newKeyRelCodeVisIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRelTableCodeVisX.get( existingKeyRelTableCodeVisX );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRelTableCodeVisX.containsKey( newKeyRelTableCodeVisX ) ) {
			subdict = dictByRelTableCodeVisX.get( newKeyRelTableCodeVisX );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByRelTableCodeVisX.put( newKeyRelTableCodeVisX, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByFromKeyIdx.get( existingKeyFromKeyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFromKeyIdx.containsKey( newKeyFromKeyIdx ) ) {
			subdict = dictByFromKeyIdx.get( newKeyFromKeyIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByFromKeyIdx.put( newKeyFromKeyIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByToTblIdx.get( existingKeyToTblIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByToTblIdx.containsKey( newKeyToTblIdx ) ) {
			subdict = dictByToTblIdx.get( newKeyToTblIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByToTblIdx.put( newKeyToTblIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByToKeyIdx.get( existingKeyToKeyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByToKeyIdx.containsKey( newKeyToKeyIdx ) ) {
			subdict = dictByToKeyIdx.get( newKeyToKeyIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByToKeyIdx.put( newKeyToKeyIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNarrowedIdx.get( existingKeyNarrowedIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNarrowedIdx.containsKey( newKeyNarrowedIdx ) ) {
			subdict = dictByNarrowedIdx.get( newKeyNarrowedIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffRelation >();
			dictByNarrowedIdx.put( newKeyNarrowedIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteRelation( ISecureAuthorization Authorization,
		IBusModelRelation iBuff )
	{
		final String S_ProcName = "BusModelRamRelationTable.deleteRelation() ";
		BusModelBuffRelation Buff = (BusModelBuffRelation)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffRelation existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteRelation",
				pkey );
		}
					schema.getTablePopTopDep().deletePopTopDepByContRelIdx( Authorization,
						existing.getRequiredId() );
					schema.getTableRelationCol().deleteRelationColByRelationIdx( Authorization,
						existing.getRequiredId() );
		BusModelBuffRelationByUNameIdxKey keyUNameIdx = (BusModelBuffRelationByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffRelationByRelTableIdxKey keyRelTableIdx = (BusModelBuffRelationByRelTableIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableIdxKey();
		keyRelTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		BusModelBuffRelationByRelCodeVisIdxKey keyRelCodeVisIdx = (BusModelBuffRelationByRelCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelCodeVisIdxKey();
		keyRelCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffRelationByRelTableCodeVisXKey keyRelTableCodeVisX = (BusModelBuffRelationByRelTableCodeVisXKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableCodeVisXKey();
		keyRelTableCodeVisX.setRequiredTableId( existing.getRequiredTableId() );
		keyRelTableCodeVisX.setRequiredCodeVis( existing.getRequiredCodeVis() );

		BusModelBuffRelationByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffRelationByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffRelationByFromKeyIdxKey keyFromKeyIdx = (BusModelBuffRelationByFromKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByFromKeyIdxKey();
		keyFromKeyIdx.setRequiredFromIndexId( existing.getRequiredFromIndexId() );

		BusModelBuffRelationByToTblIdxKey keyToTblIdx = (BusModelBuffRelationByToTblIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToTblIdxKey();
		keyToTblIdx.setRequiredToTableId( existing.getRequiredToTableId() );

		BusModelBuffRelationByToKeyIdxKey keyToKeyIdx = (BusModelBuffRelationByToKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToKeyIdxKey();
		keyToKeyIdx.setRequiredToIndexId( existing.getRequiredToIndexId() );

		BusModelBuffRelationByNarrowedIdxKey keyNarrowedIdx = (BusModelBuffRelationByNarrowedIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByNarrowedIdxKey();
		keyNarrowedIdx.setOptionalNarrowedId( existing.getOptionalNarrowedId() );

		// Validate reverse foreign keys

		if( schema.getTableChain().readDerivedByPrevRelIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"Lookup",
				"PrevRelation",
				"PrevRelation",
				"Chain",
				"Chain",
				pkey );
		}

		if( schema.getTableChain().readDerivedByNextRelIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"Lookup",
				"NextRelation",
				"NextRelation",
				"Chain",
				"Chain",
				pkey );
		}

		if( schema.getTableClearDep().readDerivedByClearDepIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"Lookup",
				"Relation",
				"Relation",
				"ClearDep",
				"ClearDep",
				pkey );
		}

		if( schema.getTableDelDep().readDerivedByDelDepIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"Lookup",
				"Relation",
				"Relation",
				"DelDep",
				"DelDep",
				pkey );
		}

		if( schema.getTablePopDep().readDerivedByRelationIdx( Authorization,
					existing.getRequiredId() ).length > 0 )
		{
			throw new YCFDependentsDetectedException( getClass(),
				"deleteRelation",
				"Lookup",
				"Lookup",
				"Relation",
				"Relation",
				"PopDep",
				"PopDep",
				pkey );
		}

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffRelation > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByRelTableIdx.get( keyRelTableIdx );
		subdict.remove( pkey );

		subdict = dictByRelCodeVisIdx.get( keyRelCodeVisIdx );
		subdict.remove( pkey );

		subdict = dictByRelTableCodeVisX.get( keyRelTableCodeVisX );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		subdict = dictByFromKeyIdx.get( keyFromKeyIdx );
		subdict.remove( pkey );

		subdict = dictByToTblIdx.get( keyToTblIdx );
		subdict.remove( pkey );

		subdict = dictByToKeyIdx.get( keyToKeyIdx );
		subdict.remove( pkey );

		subdict = dictByNarrowedIdx.get( keyNarrowedIdx );
		subdict.remove( pkey );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}
	@Override
	public void deleteRelationByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		String argName )
	{
		BusModelBuffRelationByUNameIdxKey key = (BusModelBuffRelationByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByUNameIdxKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredName( argName );
		deleteRelationByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteRelationByUNameIdx( ISecureAuthorization Authorization,
		IBusModelRelationByUNameIdxKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByRelTableIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId )
	{
		BusModelBuffRelationByRelTableIdxKey key = (BusModelBuffRelationByRelTableIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableIdxKey();
		key.setRequiredTableId( argTableId );
		deleteRelationByRelTableIdx( Authorization, key );
	}

	@Override
	public void deleteRelationByRelTableIdx( ISecureAuthorization Authorization,
		IBusModelRelationByRelTableIdxKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByRelCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffRelationByRelCodeVisIdxKey key = (BusModelBuffRelationByRelCodeVisIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelCodeVisIdxKey();
		key.setRequiredCodeVis( argCodeVis );
		deleteRelationByRelCodeVisIdx( Authorization, key );
	}

	@Override
	public void deleteRelationByRelCodeVisIdx( ISecureAuthorization Authorization,
		IBusModelRelationByRelCodeVisIdxKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByRelTableCodeVisX( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTableId,
		IBusModelPubSchema.CodeVisibilityEnum argCodeVis )
	{
		BusModelBuffRelationByRelTableCodeVisXKey key = (BusModelBuffRelationByRelTableCodeVisXKey)schema.getBusModelBuffFactory().getFactoryRelation().newByRelTableCodeVisXKey();
		key.setRequiredTableId( argTableId );
		key.setRequiredCodeVis( argCodeVis );
		deleteRelationByRelTableCodeVisX( Authorization, key );
	}

	@Override
	public void deleteRelationByRelTableCodeVisX( ISecureAuthorization Authorization,
		IBusModelRelationByRelTableCodeVisXKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffRelationByDefSchemaIdxKey key = (BusModelBuffRelationByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteRelationByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteRelationByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelRelationByDefSchemaIdxKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByFromKeyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argFromIndexId )
	{
		BusModelBuffRelationByFromKeyIdxKey key = (BusModelBuffRelationByFromKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByFromKeyIdxKey();
		key.setRequiredFromIndexId( argFromIndexId );
		deleteRelationByFromKeyIdx( Authorization, key );
	}

	@Override
	public void deleteRelationByFromKeyIdx( ISecureAuthorization Authorization,
		IBusModelRelationByFromKeyIdxKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByToTblIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argToTableId )
	{
		BusModelBuffRelationByToTblIdxKey key = (BusModelBuffRelationByToTblIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToTblIdxKey();
		key.setRequiredToTableId( argToTableId );
		deleteRelationByToTblIdx( Authorization, key );
	}

	@Override
	public void deleteRelationByToTblIdx( ISecureAuthorization Authorization,
		IBusModelRelationByToTblIdxKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByToKeyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argToIndexId )
	{
		BusModelBuffRelationByToKeyIdxKey key = (BusModelBuffRelationByToKeyIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByToKeyIdxKey();
		key.setRequiredToIndexId( argToIndexId );
		deleteRelationByToKeyIdx( Authorization, key );
	}

	@Override
	public void deleteRelationByToKeyIdx( ISecureAuthorization Authorization,
		IBusModelRelationByToKeyIdxKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByNarrowedIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNarrowedId )
	{
		BusModelBuffRelationByNarrowedIdxKey key = (BusModelBuffRelationByNarrowedIdxKey)schema.getBusModelBuffFactory().getFactoryRelation().newByNarrowedIdxKey();
		key.setOptionalNarrowedId( argNarrowedId );
		deleteRelationByNarrowedIdx( Authorization, key );
	}

	@Override
	public void deleteRelationByNarrowedIdx( ISecureAuthorization Authorization,
		IBusModelRelationByNarrowedIdxKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNarrowedId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffRelation cur;
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}

	@Override
	public void deleteRelationByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteRelationByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteRelationByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffRelation cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffRelation> matchSet = new LinkedList<BusModelBuffRelation>();
		Iterator<BusModelBuffRelation> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffRelation> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteRelation( Authorization, cur );
		}
	}
}
