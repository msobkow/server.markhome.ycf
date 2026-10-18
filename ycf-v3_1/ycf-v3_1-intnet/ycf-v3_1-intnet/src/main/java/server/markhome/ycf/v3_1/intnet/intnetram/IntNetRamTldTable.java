
// Description: Java 25 in-memory RAM DbIO implementation for Tld.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnetram;

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
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

/*
 *	IntNetRamTldTable in-memory RAM DbIO implementation
 *	for Tld.
 */
public class IntNetRamTldTable
	implements IIntNetTldTable
{
	private IIntNetSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				IntNetBuffTld > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				IntNetBuffTld >();
	private Map< IntNetBuffTldByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffTld >> dictByTenantIdx
		= new HashMap< IntNetBuffTldByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffTld >>();
	private Map< IntNetBuffTldByNameIdxKey,
			IntNetBuffTld > dictByNameIdx
		= new HashMap< IntNetBuffTldByNameIdxKey,
			IntNetBuffTld >();

	public IntNetRamTldTable( IIntNetSchema argSchema ) {
		schema = argSchema;
	}

	public IntNetBuffTld ensureRec(IIntNetTld rec) {
		return (((IntNetBuffTldFactoryService)(schema.getIntNetBuffFactory().getFactoryTld())).ensureRec(rec));
	}

	@Override
	public IIntNetTld createTld( ISecureAuthorization Authorization,
		IIntNetTld iBuff )
	{
		final String S_ProcName = "createTld";
		
		IntNetBuffTld Buff = (IntNetBuffTld)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextTldIdGen();
		Buff.setRequiredId( pkey );
		IntNetBuffTldByTenantIdxKey keyTenantIdx = (IntNetBuffTldByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffTldByNameIdxKey keyNameIdx = (IntNetBuffTldByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TldNameIdx",
				"TldNameIdx",
				keyNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"TldTenant",
						"TldTenant",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffTld > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffTld >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IIntNetTld.CLASS_CODE) {
				IntNetBuffTld retbuff = ((IntNetBuffTld)(schema.getIntNetBuffFactory().getFactoryTld().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IIntNetTld readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamTld.readDerived";
		IIntNetTld buff;
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
	public IIntNetTld lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamTld.lockDerived";
		IIntNetTld buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTld[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "IntNetRamTld.readAllDerived";
		IIntNetTld[] retList = new IIntNetTld[ dictByPKey.values().size() ];
		Iterator< IntNetBuffTld > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IIntNetTld[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamTld.readDerivedByTenantIdx";
		IntNetBuffTldByTenantIdxKey key = (IntNetBuffTldByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByTenantIdxKey();

		key.setRequiredTenantId( TenantId );
		IIntNetTld[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffTld > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new IIntNetTld[ subdictTenantIdx.size() ];
			Iterator< IntNetBuffTld > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffTld > subdictTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffTld >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new IIntNetTld[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetTld readDerivedByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "IntNetRamTld.readDerivedByNameIdx";
		IntNetBuffTldByNameIdxKey key = (IntNetBuffTldByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByNameIdxKey();

		key.setRequiredName( Name );
		IIntNetTld buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTld readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamTld.readDerivedByIdIdx() ";
		IIntNetTld buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTld readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamTld.readRec";
		IIntNetTld buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetTld.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTld lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IIntNetTld buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetTld.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTld[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "IntNetRamTld.readAllRec";
		IIntNetTld buff;
		ArrayList<IIntNetTld> filteredList = new ArrayList<IIntNetTld>();
		IIntNetTld[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetTld.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IIntNetTld[0] ) );
	}

	@Override
	public IIntNetTld readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamTld.readRecByIdIdx() ";
		IIntNetTld buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetTld.CLASS_CODE ) ) {
			return( (IIntNetTld)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IIntNetTld[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamTld.readRecByTenantIdx() ";
		IIntNetTld buff;
		ArrayList<IIntNetTld> filteredList = new ArrayList<IIntNetTld>();
		IIntNetTld[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetTld.CLASS_CODE ) ) {
				filteredList.add( (IIntNetTld)buff );
			}
		}
		return( filteredList.toArray( new IIntNetTld[0] ) );
	}

	@Override
	public IIntNetTld readRecByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "IntNetRamTld.readRecByNameIdx() ";
		IIntNetTld buff = readDerivedByNameIdx( Authorization,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetTld.CLASS_CODE ) ) {
			return( (IIntNetTld)buff );
		}
		else {
			return( null );
		}
	}

	public IIntNetTld updateTld( ISecureAuthorization Authorization,
		IIntNetTld iBuff )
	{
		IntNetBuffTld Buff = (IntNetBuffTld)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		IntNetBuffTld existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateTld",
				"Existing record not found",
				"Existing record not found",
				"Tld",
				"Tld",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateTld",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		IntNetBuffTldByTenantIdxKey existingKeyTenantIdx = (IntNetBuffTldByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffTldByTenantIdxKey newKeyTenantIdx = (IntNetBuffTldByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffTldByNameIdxKey existingKeyNameIdx = (IntNetBuffTldByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		IntNetBuffTldByNameIdxKey newKeyNameIdx = (IntNetBuffTldByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTld",
					"TldNameIdx",
					"TldNameIdx",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateTld",
						"Container",
						"Container",
						"TldTenant",
						"TldTenant",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, IntNetBuffTld > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTenantIdx.get( existingKeyTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTenantIdx.containsKey( newKeyTenantIdx ) ) {
			subdict = dictByTenantIdx.get( newKeyTenantIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffTld >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteTld( ISecureAuthorization Authorization,
		IIntNetTld iBuff )
	{
		final String S_ProcName = "IntNetRamTldTable.deleteTld() ";
		IntNetBuffTld Buff = (IntNetBuffTld)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		IntNetBuffTld existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteTld",
				pkey );
		}
					schema.getTableTopDomain().deleteTopDomainByTldIdx( Authorization,
						existing.getRequiredId() );
		IntNetBuffTldByTenantIdxKey keyTenantIdx = (IntNetBuffTldByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffTldByNameIdxKey keyNameIdx = (IntNetBuffTldByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, IntNetBuffTld > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

	}
	@Override
	public void deleteTldByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		IntNetBuffTld cur;
		LinkedList<IntNetBuffTld> matchSet = new LinkedList<IntNetBuffTld>();
		Iterator<IntNetBuffTld> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffTld> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffTld)(schema.getTableTld().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTld( Authorization, cur );
		}
	}

	@Override
	public void deleteTldByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		IntNetBuffTldByTenantIdxKey key = (IntNetBuffTldByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTldByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteTldByTenantIdx( ISecureAuthorization Authorization,
		IIntNetTldByTenantIdxKey argKey )
	{
		IntNetBuffTld cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffTld> matchSet = new LinkedList<IntNetBuffTld>();
		Iterator<IntNetBuffTld> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffTld> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffTld)(schema.getTableTld().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTld( Authorization, cur );
		}
	}

	@Override
	public void deleteTldByNameIdx( ISecureAuthorization Authorization,
		String argName )
	{
		IntNetBuffTldByNameIdxKey key = (IntNetBuffTldByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTld().newByNameIdxKey();
		key.setRequiredName( argName );
		deleteTldByNameIdx( Authorization, key );
	}

	@Override
	public void deleteTldByNameIdx( ISecureAuthorization Authorization,
		IIntNetTldByNameIdxKey argKey )
	{
		IntNetBuffTld cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffTld> matchSet = new LinkedList<IntNetBuffTld>();
		Iterator<IntNetBuffTld> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffTld> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffTld)(schema.getTableTld().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTld( Authorization, cur );
		}
	}
}
