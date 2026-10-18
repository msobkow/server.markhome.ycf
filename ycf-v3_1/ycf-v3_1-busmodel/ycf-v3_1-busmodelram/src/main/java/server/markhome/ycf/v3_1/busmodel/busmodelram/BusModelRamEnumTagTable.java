
// Description: Java 25 in-memory RAM DbIO implementation for EnumTag.

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
 *	BusModelRamEnumTagTable in-memory RAM DbIO implementation
 *	for EnumTag.
 */
public class BusModelRamEnumTagTable
	implements IBusModelEnumTagTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffEnumTag > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffEnumTag >();
	private Map< BusModelBuffEnumTagByEnumIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffEnumTag >> dictByEnumIdx
		= new HashMap< BusModelBuffEnumTagByEnumIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffEnumTag >>();
	private Map< BusModelBuffEnumTagByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffEnumTag >> dictByDefSchemaIdx
		= new HashMap< BusModelBuffEnumTagByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffEnumTag >>();
	private Map< BusModelBuffEnumTagByEnumNameIdxKey,
			BusModelBuffEnumTag > dictByEnumNameIdx
		= new HashMap< BusModelBuffEnumTagByEnumNameIdxKey,
			BusModelBuffEnumTag >();
	private Map< BusModelBuffEnumTagByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffEnumTag >> dictByPrevIdx
		= new HashMap< BusModelBuffEnumTagByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffEnumTag >>();
	private Map< BusModelBuffEnumTagByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffEnumTag >> dictByNextIdx
		= new HashMap< BusModelBuffEnumTagByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffEnumTag >>();

	public BusModelRamEnumTagTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffEnumTag ensureRec(IBusModelEnumTag rec) {
		return (((BusModelBuffEnumTagFactoryService)(schema.getBusModelBuffFactory().getFactoryEnumTag())).ensureRec(rec));
	}

	@Override
	public IBusModelEnumTag createEnumTag( ISecureAuthorization Authorization,
		IBusModelEnumTag iBuff )
	{
		final String S_ProcName = "createEnumTag";
		
		BusModelBuffEnumTag Buff = (BusModelBuffEnumTag)ensureRec(iBuff);
			IBusModelEnumTag tail = null;

			IBusModelEnumTag[] siblings = schema.getTableEnumTag().readDerivedByEnumIdx( Authorization,
				Buff.getRequiredEnumId() );
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
		
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextEnumTagIdGen();
		Buff.setRequiredId( pkey );
		BusModelBuffEnumTagByEnumIdxKey keyEnumIdx = (BusModelBuffEnumTagByEnumIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumIdxKey();
		keyEnumIdx.setRequiredEnumId( Buff.getRequiredEnumId() );

		BusModelBuffEnumTagByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffEnumTagByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffEnumTagByEnumNameIdxKey keyEnumNameIdx = (BusModelBuffEnumTagByEnumNameIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumNameIdxKey();
		keyEnumNameIdx.setRequiredEnumId( Buff.getRequiredEnumId() );
		keyEnumNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffEnumTagByPrevIdxKey keyPrevIdx = (BusModelBuffEnumTagByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffEnumTagByNextIdxKey keyNextIdx = (BusModelBuffEnumTagByNextIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByEnumNameIdx.containsKey( keyEnumNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"EnumTagEnumNameIdx",
				"EnumTagEnumNameIdx",
				keyEnumNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableEnumDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredEnumId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"EnumDef",
						"EnumDef",
						"EnumDef",
						"EnumDef",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictEnumIdx;
		if( dictByEnumIdx.containsKey( keyEnumIdx ) ) {
			subdictEnumIdx = dictByEnumIdx.get( keyEnumIdx );
		}
		else {
			subdictEnumIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByEnumIdx.put( keyEnumIdx, subdictEnumIdx );
		}
		subdictEnumIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictDefSchemaIdx;
		if( dictByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
			subdictDefSchemaIdx = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		}
		else {
			subdictDefSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByDefSchemaIdx.put( keyDefSchemaIdx, subdictDefSchemaIdx );
		}
		subdictDefSchemaIdx.put( pkey, Buff );

		dictByEnumNameIdx.put( keyEnumNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictPrevIdx;
		if( dictByPrevIdx.containsKey( keyPrevIdx ) ) {
			subdictPrevIdx = dictByPrevIdx.get( keyPrevIdx );
		}
		else {
			subdictPrevIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByPrevIdx.put( keyPrevIdx, subdictPrevIdx );
		}
		subdictPrevIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictNextIdx;
		if( dictByNextIdx.containsKey( keyNextIdx ) ) {
			subdictNextIdx = dictByNextIdx.get( keyNextIdx );
		}
		else {
			subdictNextIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByNextIdx.put( keyNextIdx, subdictNextIdx );
		}
		subdictNextIdx.put( pkey, Buff );

		if( tail != null ) {
			IBusModelEnumTag tailEdit = schema.getBusModelBuffFactory().getFactoryEnumTag().newRec();
			tailEdit.set( (IBusModelEnumTag)tail );
				tailEdit.setOptionalLookupNext(Buff.getRequiredId());
			schema.getTableEnumTag().updateEnumTag( Authorization, tailEdit );
		}
		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelEnumTag.CLASS_CODE) {
				BusModelBuffEnumTag retbuff = ((BusModelBuffEnumTag)(schema.getBusModelBuffFactory().getFactoryEnumTag().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelEnumTag readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamEnumTag.readDerived";
		IBusModelEnumTag buff;
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
	public IBusModelEnumTag lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamEnumTag.lockDerived";
		IBusModelEnumTag buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelEnumTag[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamEnumTag.readAllDerived";
		IBusModelEnumTag[] retList = new IBusModelEnumTag[ dictByPKey.values().size() ];
		Iterator< BusModelBuffEnumTag > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelEnumTag[] readDerivedByEnumIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 EnumId )
	{
		final String S_ProcName = "BusModelRamEnumTag.readDerivedByEnumIdx";
		BusModelBuffEnumTagByEnumIdxKey key = (BusModelBuffEnumTagByEnumIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumIdxKey();

		key.setRequiredEnumId( EnumId );
		IBusModelEnumTag[] recArray;
		if( dictByEnumIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictEnumIdx
				= dictByEnumIdx.get( key );
			recArray = new IBusModelEnumTag[ subdictEnumIdx.size() ];
			Iterator< BusModelBuffEnumTag > iter = subdictEnumIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictEnumIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByEnumIdx.put( key, subdictEnumIdx );
			recArray = new IBusModelEnumTag[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelEnumTag[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamEnumTag.readDerivedByDefSchemaIdx";
		BusModelBuffEnumTagByDefSchemaIdxKey key = (BusModelBuffEnumTagByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByDefSchemaIdxKey();

		key.setOptionalDefSchemaId( DefSchemaId );
		IBusModelEnumTag[] recArray;
		if( dictByDefSchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictDefSchemaIdx
				= dictByDefSchemaIdx.get( key );
			recArray = new IBusModelEnumTag[ subdictDefSchemaIdx.size() ];
			Iterator< BusModelBuffEnumTag > iter = subdictDefSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictDefSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByDefSchemaIdx.put( key, subdictDefSchemaIdx );
			recArray = new IBusModelEnumTag[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelEnumTag readDerivedByEnumNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 EnumId,
		String Name )
	{
		final String S_ProcName = "BusModelRamEnumTag.readDerivedByEnumNameIdx";
		BusModelBuffEnumTagByEnumNameIdxKey key = (BusModelBuffEnumTagByEnumNameIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumNameIdxKey();

		key.setRequiredEnumId( EnumId );
		key.setRequiredName( Name );
		IBusModelEnumTag buff;
		if( dictByEnumNameIdx.containsKey( key ) ) {
			buff = dictByEnumNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelEnumTag[] readDerivedByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamEnumTag.readDerivedByPrevIdx";
		BusModelBuffEnumTagByPrevIdxKey key = (BusModelBuffEnumTagByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByPrevIdxKey();

		key.setOptionalPrevId( PrevId );
		IBusModelEnumTag[] recArray;
		if( dictByPrevIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictPrevIdx
				= dictByPrevIdx.get( key );
			recArray = new IBusModelEnumTag[ subdictPrevIdx.size() ];
			Iterator< BusModelBuffEnumTag > iter = subdictPrevIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictPrevIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByPrevIdx.put( key, subdictPrevIdx );
			recArray = new IBusModelEnumTag[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelEnumTag[] readDerivedByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamEnumTag.readDerivedByNextIdx";
		BusModelBuffEnumTagByNextIdxKey key = (BusModelBuffEnumTagByNextIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByNextIdxKey();

		key.setOptionalNextId( NextId );
		IBusModelEnumTag[] recArray;
		if( dictByNextIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictNextIdx
				= dictByNextIdx.get( key );
			recArray = new IBusModelEnumTag[ subdictNextIdx.size() ];
			Iterator< BusModelBuffEnumTag > iter = subdictNextIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdictNextIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByNextIdx.put( key, subdictNextIdx );
			recArray = new IBusModelEnumTag[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelEnumTag readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamEnumTag.readDerivedByIdIdx() ";
		IBusModelEnumTag buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelEnumTag readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamEnumTag.readRec";
		IBusModelEnumTag buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelEnumTag.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelEnumTag lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelEnumTag buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelEnumTag.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelEnumTag[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamEnumTag.readAllRec";
		IBusModelEnumTag buff;
		ArrayList<IBusModelEnumTag> filteredList = new ArrayList<IBusModelEnumTag>();
		IBusModelEnumTag[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelEnumTag.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelEnumTag[0] ) );
	}

	@Override
	public IBusModelEnumTag readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamEnumTag.readRecByIdIdx() ";
		IBusModelEnumTag buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelEnumTag.CLASS_CODE ) ) {
			return( (IBusModelEnumTag)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelEnumTag[] readRecByEnumIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 EnumId )
	{
		final String S_ProcName = "BusModelRamEnumTag.readRecByEnumIdx() ";
		IBusModelEnumTag buff;
		ArrayList<IBusModelEnumTag> filteredList = new ArrayList<IBusModelEnumTag>();
		IBusModelEnumTag[] buffList = readDerivedByEnumIdx( Authorization,
			EnumId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelEnumTag.CLASS_CODE ) ) {
				filteredList.add( (IBusModelEnumTag)buff );
			}
		}
		return( filteredList.toArray( new IBusModelEnumTag[0] ) );
	}

	@Override
	public IBusModelEnumTag[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamEnumTag.readRecByDefSchemaIdx() ";
		IBusModelEnumTag buff;
		ArrayList<IBusModelEnumTag> filteredList = new ArrayList<IBusModelEnumTag>();
		IBusModelEnumTag[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelEnumTag.CLASS_CODE ) ) {
				filteredList.add( (IBusModelEnumTag)buff );
			}
		}
		return( filteredList.toArray( new IBusModelEnumTag[0] ) );
	}

	@Override
	public IBusModelEnumTag readRecByEnumNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 EnumId,
		String Name )
	{
		final String S_ProcName = "BusModelRamEnumTag.readRecByEnumNameIdx() ";
		IBusModelEnumTag buff = readDerivedByEnumNameIdx( Authorization,
			EnumId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelEnumTag.CLASS_CODE ) ) {
			return( (IBusModelEnumTag)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelEnumTag[] readRecByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "BusModelRamEnumTag.readRecByPrevIdx() ";
		IBusModelEnumTag buff;
		ArrayList<IBusModelEnumTag> filteredList = new ArrayList<IBusModelEnumTag>();
		IBusModelEnumTag[] buffList = readDerivedByPrevIdx( Authorization,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelEnumTag.CLASS_CODE ) ) {
				filteredList.add( (IBusModelEnumTag)buff );
			}
		}
		return( filteredList.toArray( new IBusModelEnumTag[0] ) );
	}

	@Override
	public IBusModelEnumTag[] readRecByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "BusModelRamEnumTag.readRecByNextIdx() ";
		IBusModelEnumTag buff;
		ArrayList<IBusModelEnumTag> filteredList = new ArrayList<IBusModelEnumTag>();
		IBusModelEnumTag[] buffList = readDerivedByNextIdx( Authorization,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelEnumTag.CLASS_CODE ) ) {
				filteredList.add( (IBusModelEnumTag)buff );
			}
		}
		return( filteredList.toArray( new IBusModelEnumTag[0] ) );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelEnumTag moveRecUp( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecUp";

		IBusModelEnumTag grandprev = null;
		IBusModelEnumTag prev = null;
		IBusModelEnumTag cur = null;
		IBusModelEnumTag next = null;

		cur = schema.getTableEnumTag().readDerivedByIdIdx(Authorization, Id);
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalPrevId() == null ) )
		{
			return( (BusModelBuffEnumTag)cur );
		}

		prev = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
		if( prev == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx(Authorization, prev.getOptionalPrevId() ));
			if( grandprev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextId() != null ) )
		{
			next = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
			if( next == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
			}
		}

		int classCode = prev.getClassCode();
		IBusModelEnumTag newInstance;
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumTag().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffEnumTag editPrev = (BusModelBuffEnumTag)newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumTag().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffEnumTag editCur = (BusModelBuffEnumTag)newInstance;
		editCur.set( cur );

		BusModelBuffEnumTag editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumTag().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandprev = (BusModelBuffEnumTag)newInstance;
			editGrandprev.set( grandprev );
		}

		BusModelBuffEnumTag editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumTag().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext = (BusModelBuffEnumTag)newInstance;
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
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editGrandprev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffEnumTag)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	@Override
	public IBusModelEnumTag moveRecDown( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id,
		int revision )
	{
		final String S_ProcName = "moveRecDown";

		BusModelBuffEnumTag prev = null;
		BusModelBuffEnumTag cur = null;
		BusModelBuffEnumTag next = null;
		BusModelBuffEnumTag grandnext = null;

		cur = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx(Authorization, Id));
		if( cur == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object" );
		}

		if( ( cur.getOptionalNextId() == null ) )
		{
			return( (BusModelBuffEnumTag)cur );
		}

		next = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx(Authorization, cur.getOptionalNextId() ));
		if( next == null ) {
			throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next" );
		}

		if( ( next.getOptionalNextId() != null ) )
		{
			grandnext = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx(Authorization, next.getOptionalNextId() ));
			if( grandnext == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevId() != null ) )
		{
			prev = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx(Authorization, cur.getOptionalPrevId() ));
			if( prev == null ) {
				throw new YCFCollisionDetectedException( getClass(), S_ProcName, "Could not locate object.prev" );
			}
		}

		int classCode = cur.getClassCode();
		IBusModelEnumTag newInstance;
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumTag().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffEnumTag editCur = (BusModelBuffEnumTag)newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumTag().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		BusModelBuffEnumTag editNext = (BusModelBuffEnumTag)newInstance;
		editNext.set( next );

		BusModelBuffEnumTag editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumTag().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editGrandnext = (BusModelBuffEnumTag)newInstance;
			editGrandnext.set( grandnext );
		}

		BusModelBuffEnumTag editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				newInstance = schema.getBusModelBuffFactory().getFactoryEnumTag().newRec();
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-instantiate-buff-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev = (BusModelBuffEnumTag)newInstance;
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
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		classCode = editCur.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editCur );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-cur-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		classCode = editNext.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editGrandnext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-update-grand-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		return( (BusModelBuffEnumTag)editCur );
	}

	public IBusModelEnumTag updateEnumTag( ISecureAuthorization Authorization,
		IBusModelEnumTag iBuff )
	{
		BusModelBuffEnumTag Buff = (BusModelBuffEnumTag)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffEnumTag existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateEnumTag",
				"Existing record not found",
				"Existing record not found",
				"EnumTag",
				"EnumTag",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateEnumTag",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		BusModelBuffEnumTagByEnumIdxKey existingKeyEnumIdx = (BusModelBuffEnumTagByEnumIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumIdxKey();
		existingKeyEnumIdx.setRequiredEnumId( existing.getRequiredEnumId() );

		BusModelBuffEnumTagByEnumIdxKey newKeyEnumIdx = (BusModelBuffEnumTagByEnumIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumIdxKey();
		newKeyEnumIdx.setRequiredEnumId( Buff.getRequiredEnumId() );

		BusModelBuffEnumTagByDefSchemaIdxKey existingKeyDefSchemaIdx = (BusModelBuffEnumTagByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
		existingKeyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffEnumTagByDefSchemaIdxKey newKeyDefSchemaIdx = (BusModelBuffEnumTagByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
		newKeyDefSchemaIdx.setOptionalDefSchemaId( Buff.getOptionalDefSchemaId() );

		BusModelBuffEnumTagByEnumNameIdxKey existingKeyEnumNameIdx = (BusModelBuffEnumTagByEnumNameIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumNameIdxKey();
		existingKeyEnumNameIdx.setRequiredEnumId( existing.getRequiredEnumId() );
		existingKeyEnumNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffEnumTagByEnumNameIdxKey newKeyEnumNameIdx = (BusModelBuffEnumTagByEnumNameIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumNameIdxKey();
		newKeyEnumNameIdx.setRequiredEnumId( Buff.getRequiredEnumId() );
		newKeyEnumNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffEnumTagByPrevIdxKey existingKeyPrevIdx = (BusModelBuffEnumTagByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByPrevIdxKey();
		existingKeyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffEnumTagByPrevIdxKey newKeyPrevIdx = (BusModelBuffEnumTagByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByPrevIdxKey();
		newKeyPrevIdx.setOptionalPrevId( Buff.getOptionalPrevId() );

		BusModelBuffEnumTagByNextIdxKey existingKeyNextIdx = (BusModelBuffEnumTagByNextIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByNextIdxKey();
		existingKeyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		BusModelBuffEnumTagByNextIdxKey newKeyNextIdx = (BusModelBuffEnumTagByNextIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByNextIdxKey();
		newKeyNextIdx.setOptionalNextId( Buff.getOptionalNextId() );

		// Check unique indexes

		if( ! existingKeyEnumNameIdx.equals( newKeyEnumNameIdx ) ) {
			if( dictByEnumNameIdx.containsKey( newKeyEnumNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateEnumTag",
					"EnumTagEnumNameIdx",
					"EnumTagEnumNameIdx",
					newKeyEnumNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableEnumDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredEnumId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateEnumTag",
						"Container",
						"Container",
						"EnumDef",
						"EnumDef",
						"EnumDef",
						"EnumDef",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByEnumIdx.get( existingKeyEnumIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEnumIdx.containsKey( newKeyEnumIdx ) ) {
			subdict = dictByEnumIdx.get( newKeyEnumIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByEnumIdx.put( newKeyEnumIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByDefSchemaIdx.put( newKeyDefSchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByEnumNameIdx.remove( existingKeyEnumNameIdx );
		dictByEnumNameIdx.put( newKeyEnumNameIdx, Buff );

		subdict = dictByPrevIdx.get( existingKeyPrevIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByPrevIdx.containsKey( newKeyPrevIdx ) ) {
			subdict = dictByPrevIdx.get( newKeyPrevIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag >();
			dictByNextIdx.put( newKeyNextIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteEnumTag( ISecureAuthorization Authorization,
		IBusModelEnumTag iBuff )
	{
		final String S_ProcName = "BusModelRamEnumTagTable.deleteEnumTag() ";
		BusModelBuffEnumTag Buff = (BusModelBuffEnumTag)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffEnumTag existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteEnumTag",
				pkey );
		}
		IYCFKeyHash256 varEnumId = existing.getRequiredEnumId();
		BusModelBuffEnumDef container = (BusModelBuffEnumDef)(schema.getTableEnumDef().readDerivedByIdIdx( Authorization,
			varEnumId ));
		if( container == null ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				0,
				"container" );
		}

		IYCFKeyHash256 prevId = existing.getOptionalPrevId();
		IYCFKeyHash256 nextId = existing.getOptionalNextId();

		BusModelBuffEnumTag prev = null;
		if( ( prevId != null ) )
		{
			prev = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx( Authorization,
				prevId ));
			if( prev == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			BusModelBuffEnumTag editPrev;
			classCode = prev.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				editPrev = (BusModelBuffEnumTag)(schema.getBusModelBuffFactory().getFactoryEnumTag().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editPrev.set( prev );
			editPrev.setOptionalLookupNext(nextId);
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editPrev );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-prev-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffEnumTag next = null;
		if( ( nextId != null ) )
		{
			next = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx( Authorization,
				nextId ));
			if( next == null ) {
				throw new YCFNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			BusModelBuffEnumTag editNext;
			classCode = next.getClassCode();
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				editNext = (BusModelBuffEnumTag)(schema.getBusModelBuffFactory().getFactoryEnumTag().newRec());
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-update-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
			editNext.set( next );
			editNext.setOptionalLookupPrev(prevId);
			if( classCode == IBusModelEnumTag.CLASS_CODE ) {
				schema.getTableEnumTag().updateEnumTag( Authorization, editNext );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-edit-next-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}

		BusModelBuffEnumTagByEnumIdxKey keyEnumIdx = (BusModelBuffEnumTagByEnumIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumIdxKey();
		keyEnumIdx.setRequiredEnumId( existing.getRequiredEnumId() );

		BusModelBuffEnumTagByDefSchemaIdxKey keyDefSchemaIdx = (BusModelBuffEnumTagByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		BusModelBuffEnumTagByEnumNameIdxKey keyEnumNameIdx = (BusModelBuffEnumTagByEnumNameIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumNameIdxKey();
		keyEnumNameIdx.setRequiredEnumId( existing.getRequiredEnumId() );
		keyEnumNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffEnumTagByPrevIdxKey keyPrevIdx = (BusModelBuffEnumTagByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		BusModelBuffEnumTagByNextIdxKey keyNextIdx = (BusModelBuffEnumTagByNextIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffEnumTag > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByEnumIdx.get( keyEnumIdx );
		subdict.remove( pkey );

		subdict = dictByDefSchemaIdx.get( keyDefSchemaIdx );
		subdict.remove( pkey );

		dictByEnumNameIdx.remove( keyEnumNameIdx );

		subdict = dictByPrevIdx.get( keyPrevIdx );
		subdict.remove( pkey );

		subdict = dictByNextIdx.get( keyNextIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteEnumTagByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffEnumTag cur;
		LinkedList<BusModelBuffEnumTag> matchSet = new LinkedList<BusModelBuffEnumTag>();
		Iterator<BusModelBuffEnumTag> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffEnumTag> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteEnumTag( Authorization, cur );
		}
	}

	@Override
	public void deleteEnumTagByEnumIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argEnumId )
	{
		BusModelBuffEnumTagByEnumIdxKey key = (BusModelBuffEnumTagByEnumIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumIdxKey();
		key.setRequiredEnumId( argEnumId );
		deleteEnumTagByEnumIdx( Authorization, key );
	}

	@Override
	public void deleteEnumTagByEnumIdx( ISecureAuthorization Authorization,
		IBusModelEnumTagByEnumIdxKey argKey )
	{
		BusModelBuffEnumTag cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffEnumTag> matchSet = new LinkedList<BusModelBuffEnumTag>();
		Iterator<BusModelBuffEnumTag> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffEnumTag> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteEnumTag( Authorization, cur );
		}
	}

	@Override
	public void deleteEnumTagByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffEnumTagByDefSchemaIdxKey key = (BusModelBuffEnumTagByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteEnumTagByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteEnumTagByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelEnumTagByDefSchemaIdxKey argKey )
	{
		BusModelBuffEnumTag cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffEnumTag> matchSet = new LinkedList<BusModelBuffEnumTag>();
		Iterator<BusModelBuffEnumTag> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffEnumTag> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteEnumTag( Authorization, cur );
		}
	}

	@Override
	public void deleteEnumTagByEnumNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argEnumId,
		String argName )
	{
		BusModelBuffEnumTagByEnumNameIdxKey key = (BusModelBuffEnumTagByEnumNameIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByEnumNameIdxKey();
		key.setRequiredEnumId( argEnumId );
		key.setRequiredName( argName );
		deleteEnumTagByEnumNameIdx( Authorization, key );
	}

	@Override
	public void deleteEnumTagByEnumNameIdx( ISecureAuthorization Authorization,
		IBusModelEnumTagByEnumNameIdxKey argKey )
	{
		BusModelBuffEnumTag cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffEnumTag> matchSet = new LinkedList<BusModelBuffEnumTag>();
		Iterator<BusModelBuffEnumTag> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffEnumTag> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteEnumTag( Authorization, cur );
		}
	}

	@Override
	public void deleteEnumTagByPrevIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argPrevId )
	{
		BusModelBuffEnumTagByPrevIdxKey key = (BusModelBuffEnumTagByPrevIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByPrevIdxKey();
		key.setOptionalPrevId( argPrevId );
		deleteEnumTagByPrevIdx( Authorization, key );
	}

	@Override
	public void deleteEnumTagByPrevIdx( ISecureAuthorization Authorization,
		IBusModelEnumTagByPrevIdxKey argKey )
	{
		BusModelBuffEnumTag cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffEnumTag> matchSet = new LinkedList<BusModelBuffEnumTag>();
		Iterator<BusModelBuffEnumTag> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffEnumTag> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteEnumTag( Authorization, cur );
		}
	}

	@Override
	public void deleteEnumTagByNextIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argNextId )
	{
		BusModelBuffEnumTagByNextIdxKey key = (BusModelBuffEnumTagByNextIdxKey)schema.getBusModelBuffFactory().getFactoryEnumTag().newByNextIdxKey();
		key.setOptionalNextId( argNextId );
		deleteEnumTagByNextIdx( Authorization, key );
	}

	@Override
	public void deleteEnumTagByNextIdx( ISecureAuthorization Authorization,
		IBusModelEnumTagByNextIdxKey argKey )
	{
		BusModelBuffEnumTag cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffEnumTag> matchSet = new LinkedList<BusModelBuffEnumTag>();
		Iterator<BusModelBuffEnumTag> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffEnumTag> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffEnumTag)(schema.getTableEnumTag().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteEnumTag( Authorization, cur );
		}
	}
}
