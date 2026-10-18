
// Description: Java 25 in-memory RAM DbIO implementation for MinorVersion.

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
 *	IntNetRamMinorVersionTable in-memory RAM DbIO implementation
 *	for MinorVersion.
 */
public class IntNetRamMinorVersionTable
	implements IIntNetMinorVersionTable
{
	private IIntNetSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				IntNetBuffMinorVersion > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				IntNetBuffMinorVersion >();
	private Map< IntNetBuffMinorVersionByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffMinorVersion >> dictByTenantIdx
		= new HashMap< IntNetBuffMinorVersionByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffMinorVersion >>();
	private Map< IntNetBuffMinorVersionByMajorVerIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffMinorVersion >> dictByMajorVerIdx
		= new HashMap< IntNetBuffMinorVersionByMajorVerIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffMinorVersion >>();
	private Map< IntNetBuffMinorVersionByNameIdxKey,
			IntNetBuffMinorVersion > dictByNameIdx
		= new HashMap< IntNetBuffMinorVersionByNameIdxKey,
			IntNetBuffMinorVersion >();

	public IntNetRamMinorVersionTable( IIntNetSchema argSchema ) {
		schema = argSchema;
	}

	public IntNetBuffMinorVersion ensureRec(IIntNetMinorVersion rec) {
		return (((IntNetBuffMinorVersionFactoryService)(schema.getIntNetBuffFactory().getFactoryMinorVersion())).ensureRec(rec));
	}

	@Override
	public IIntNetMinorVersion createMinorVersion( ISecureAuthorization Authorization,
		IIntNetMinorVersion iBuff )
	{
		final String S_ProcName = "createMinorVersion";
		
		IntNetBuffMinorVersion Buff = (IntNetBuffMinorVersion)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextMinorVersionIdGen();
		Buff.setRequiredId( pkey );
		IntNetBuffMinorVersionByTenantIdxKey keyTenantIdx = (IntNetBuffMinorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffMinorVersionByMajorVerIdxKey keyMajorVerIdx = (IntNetBuffMinorVersionByMajorVerIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
		keyMajorVerIdx.setRequiredMajorVersionId( Buff.getRequiredMajorVersionId() );

		IntNetBuffMinorVersionByNameIdxKey keyNameIdx = (IntNetBuffMinorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByNameIdxKey();
		keyNameIdx.setRequiredMajorVersionId( Buff.getRequiredMajorVersionId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"MinorVersionNameIdx",
				"MinorVersionNameIdx",
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
						"Owner",
						"Owner",
						"Tenant",
						"Tenant",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableMajorVersion().readDerivedByIdIdx( Authorization,
						Buff.getRequiredMajorVersionId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ParentMajorVersion",
						"ParentMajorVersion",
						"MajorVersion",
						"MajorVersion",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion > subdictMajorVerIdx;
		if( dictByMajorVerIdx.containsKey( keyMajorVerIdx ) ) {
			subdictMajorVerIdx = dictByMajorVerIdx.get( keyMajorVerIdx );
		}
		else {
			subdictMajorVerIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion >();
			dictByMajorVerIdx.put( keyMajorVerIdx, subdictMajorVerIdx );
		}
		subdictMajorVerIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IIntNetMinorVersion.CLASS_CODE) {
				IntNetBuffMinorVersion retbuff = ((IntNetBuffMinorVersion)(schema.getIntNetBuffFactory().getFactoryMinorVersion().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IIntNetMinorVersion readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readDerived";
		IIntNetMinorVersion buff;
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
	public IIntNetMinorVersion lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamMinorVersion.lockDerived";
		IIntNetMinorVersion buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMinorVersion[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "IntNetRamMinorVersion.readAllDerived";
		IIntNetMinorVersion[] retList = new IIntNetMinorVersion[ dictByPKey.values().size() ];
		Iterator< IntNetBuffMinorVersion > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IIntNetMinorVersion[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readDerivedByTenantIdx";
		IntNetBuffMinorVersionByTenantIdxKey key = (IntNetBuffMinorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByTenantIdxKey();

		key.setRequiredTenantId( TenantId );
		IIntNetMinorVersion[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new IIntNetMinorVersion[ subdictTenantIdx.size() ];
			Iterator< IntNetBuffMinorVersion > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion > subdictTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new IIntNetMinorVersion[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetMinorVersion[] readDerivedByMajorVerIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 MajorVersionId )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readDerivedByMajorVerIdx";
		IntNetBuffMinorVersionByMajorVerIdxKey key = (IntNetBuffMinorVersionByMajorVerIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByMajorVerIdxKey();

		key.setRequiredMajorVersionId( MajorVersionId );
		IIntNetMinorVersion[] recArray;
		if( dictByMajorVerIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion > subdictMajorVerIdx
				= dictByMajorVerIdx.get( key );
			recArray = new IIntNetMinorVersion[ subdictMajorVerIdx.size() ];
			Iterator< IntNetBuffMinorVersion > iter = subdictMajorVerIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion > subdictMajorVerIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion >();
			dictByMajorVerIdx.put( key, subdictMajorVerIdx );
			recArray = new IIntNetMinorVersion[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetMinorVersion readDerivedByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 MajorVersionId,
		String Name )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readDerivedByNameIdx";
		IntNetBuffMinorVersionByNameIdxKey key = (IntNetBuffMinorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByNameIdxKey();

		key.setRequiredMajorVersionId( MajorVersionId );
		key.setRequiredName( Name );
		IIntNetMinorVersion buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMinorVersion readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readDerivedByIdIdx() ";
		IIntNetMinorVersion buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMinorVersion readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readRec";
		IIntNetMinorVersion buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetMinorVersion.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMinorVersion lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IIntNetMinorVersion buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetMinorVersion.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMinorVersion[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readAllRec";
		IIntNetMinorVersion buff;
		ArrayList<IIntNetMinorVersion> filteredList = new ArrayList<IIntNetMinorVersion>();
		IIntNetMinorVersion[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetMinorVersion.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IIntNetMinorVersion[0] ) );
	}

	@Override
	public IIntNetMinorVersion readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readRecByIdIdx() ";
		IIntNetMinorVersion buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetMinorVersion.CLASS_CODE ) ) {
			return( (IIntNetMinorVersion)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IIntNetMinorVersion[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readRecByTenantIdx() ";
		IIntNetMinorVersion buff;
		ArrayList<IIntNetMinorVersion> filteredList = new ArrayList<IIntNetMinorVersion>();
		IIntNetMinorVersion[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetMinorVersion.CLASS_CODE ) ) {
				filteredList.add( (IIntNetMinorVersion)buff );
			}
		}
		return( filteredList.toArray( new IIntNetMinorVersion[0] ) );
	}

	@Override
	public IIntNetMinorVersion[] readRecByMajorVerIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 MajorVersionId )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readRecByMajorVerIdx() ";
		IIntNetMinorVersion buff;
		ArrayList<IIntNetMinorVersion> filteredList = new ArrayList<IIntNetMinorVersion>();
		IIntNetMinorVersion[] buffList = readDerivedByMajorVerIdx( Authorization,
			MajorVersionId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetMinorVersion.CLASS_CODE ) ) {
				filteredList.add( (IIntNetMinorVersion)buff );
			}
		}
		return( filteredList.toArray( new IIntNetMinorVersion[0] ) );
	}

	@Override
	public IIntNetMinorVersion readRecByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 MajorVersionId,
		String Name )
	{
		final String S_ProcName = "IntNetRamMinorVersion.readRecByNameIdx() ";
		IIntNetMinorVersion buff = readDerivedByNameIdx( Authorization,
			MajorVersionId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetMinorVersion.CLASS_CODE ) ) {
			return( (IIntNetMinorVersion)buff );
		}
		else {
			return( null );
		}
	}

	public IIntNetMinorVersion updateMinorVersion( ISecureAuthorization Authorization,
		IIntNetMinorVersion iBuff )
	{
		IntNetBuffMinorVersion Buff = (IntNetBuffMinorVersion)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		IntNetBuffMinorVersion existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateMinorVersion",
				"Existing record not found",
				"Existing record not found",
				"MinorVersion",
				"MinorVersion",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateMinorVersion",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		IntNetBuffMinorVersionByTenantIdxKey existingKeyTenantIdx = (IntNetBuffMinorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffMinorVersionByTenantIdxKey newKeyTenantIdx = (IntNetBuffMinorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffMinorVersionByMajorVerIdxKey existingKeyMajorVerIdx = (IntNetBuffMinorVersionByMajorVerIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
		existingKeyMajorVerIdx.setRequiredMajorVersionId( existing.getRequiredMajorVersionId() );

		IntNetBuffMinorVersionByMajorVerIdxKey newKeyMajorVerIdx = (IntNetBuffMinorVersionByMajorVerIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
		newKeyMajorVerIdx.setRequiredMajorVersionId( Buff.getRequiredMajorVersionId() );

		IntNetBuffMinorVersionByNameIdxKey existingKeyNameIdx = (IntNetBuffMinorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByNameIdxKey();
		existingKeyNameIdx.setRequiredMajorVersionId( existing.getRequiredMajorVersionId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		IntNetBuffMinorVersionByNameIdxKey newKeyNameIdx = (IntNetBuffMinorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByNameIdxKey();
		newKeyNameIdx.setRequiredMajorVersionId( Buff.getRequiredMajorVersionId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateMinorVersion",
					"MinorVersionNameIdx",
					"MinorVersionNameIdx",
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
						"updateMinorVersion",
						"Owner",
						"Owner",
						"Tenant",
						"Tenant",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableMajorVersion().readDerivedByIdIdx( Authorization,
						Buff.getRequiredMajorVersionId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateMinorVersion",
						"Container",
						"Container",
						"ParentMajorVersion",
						"ParentMajorVersion",
						"MajorVersion",
						"MajorVersion",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion > subdict;

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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByMajorVerIdx.get( existingKeyMajorVerIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByMajorVerIdx.containsKey( newKeyMajorVerIdx ) ) {
			subdict = dictByMajorVerIdx.get( newKeyMajorVerIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion >();
			dictByMajorVerIdx.put( newKeyMajorVerIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteMinorVersion( ISecureAuthorization Authorization,
		IIntNetMinorVersion iBuff )
	{
		final String S_ProcName = "IntNetRamMinorVersionTable.deleteMinorVersion() ";
		IntNetBuffMinorVersion Buff = (IntNetBuffMinorVersion)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		IntNetBuffMinorVersion existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteMinorVersion",
				pkey );
		}
		IntNetBuffMinorVersionByTenantIdxKey keyTenantIdx = (IntNetBuffMinorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffMinorVersionByMajorVerIdxKey keyMajorVerIdx = (IntNetBuffMinorVersionByMajorVerIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
		keyMajorVerIdx.setRequiredMajorVersionId( existing.getRequiredMajorVersionId() );

		IntNetBuffMinorVersionByNameIdxKey keyNameIdx = (IntNetBuffMinorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByNameIdxKey();
		keyNameIdx.setRequiredMajorVersionId( existing.getRequiredMajorVersionId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, IntNetBuffMinorVersion > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByMajorVerIdx.get( keyMajorVerIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

	}
	@Override
	public void deleteMinorVersionByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		IntNetBuffMinorVersion cur;
		LinkedList<IntNetBuffMinorVersion> matchSet = new LinkedList<IntNetBuffMinorVersion>();
		Iterator<IntNetBuffMinorVersion> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMinorVersion> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMinorVersion)(schema.getTableMinorVersion().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteMinorVersion( Authorization, cur );
		}
	}

	@Override
	public void deleteMinorVersionByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		IntNetBuffMinorVersionByTenantIdxKey key = (IntNetBuffMinorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteMinorVersionByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteMinorVersionByTenantIdx( ISecureAuthorization Authorization,
		IIntNetMinorVersionByTenantIdxKey argKey )
	{
		IntNetBuffMinorVersion cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffMinorVersion> matchSet = new LinkedList<IntNetBuffMinorVersion>();
		Iterator<IntNetBuffMinorVersion> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMinorVersion> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMinorVersion)(schema.getTableMinorVersion().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteMinorVersion( Authorization, cur );
		}
	}

	@Override
	public void deleteMinorVersionByMajorVerIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMajorVersionId )
	{
		IntNetBuffMinorVersionByMajorVerIdxKey key = (IntNetBuffMinorVersionByMajorVerIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
		key.setRequiredMajorVersionId( argMajorVersionId );
		deleteMinorVersionByMajorVerIdx( Authorization, key );
	}

	@Override
	public void deleteMinorVersionByMajorVerIdx( ISecureAuthorization Authorization,
		IIntNetMinorVersionByMajorVerIdxKey argKey )
	{
		IntNetBuffMinorVersion cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffMinorVersion> matchSet = new LinkedList<IntNetBuffMinorVersion>();
		Iterator<IntNetBuffMinorVersion> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMinorVersion> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMinorVersion)(schema.getTableMinorVersion().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteMinorVersion( Authorization, cur );
		}
	}

	@Override
	public void deleteMinorVersionByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMajorVersionId,
		String argName )
	{
		IntNetBuffMinorVersionByNameIdxKey key = (IntNetBuffMinorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMinorVersion().newByNameIdxKey();
		key.setRequiredMajorVersionId( argMajorVersionId );
		key.setRequiredName( argName );
		deleteMinorVersionByNameIdx( Authorization, key );
	}

	@Override
	public void deleteMinorVersionByNameIdx( ISecureAuthorization Authorization,
		IIntNetMinorVersionByNameIdxKey argKey )
	{
		IntNetBuffMinorVersion cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffMinorVersion> matchSet = new LinkedList<IntNetBuffMinorVersion>();
		Iterator<IntNetBuffMinorVersion> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMinorVersion> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMinorVersion)(schema.getTableMinorVersion().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteMinorVersion( Authorization, cur );
		}
	}
}
