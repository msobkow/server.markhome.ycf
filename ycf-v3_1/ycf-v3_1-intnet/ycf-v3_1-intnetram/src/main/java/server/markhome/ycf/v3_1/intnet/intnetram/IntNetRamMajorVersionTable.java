
// Description: Java 25 in-memory RAM DbIO implementation for MajorVersion.

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
 *	IntNetRamMajorVersionTable in-memory RAM DbIO implementation
 *	for MajorVersion.
 */
public class IntNetRamMajorVersionTable
	implements IIntNetMajorVersionTable
{
	private IIntNetSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				IntNetBuffMajorVersion > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				IntNetBuffMajorVersion >();
	private Map< IntNetBuffMajorVersionByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffMajorVersion >> dictByTenantIdx
		= new HashMap< IntNetBuffMajorVersionByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffMajorVersion >>();
	private Map< IntNetBuffMajorVersionBySubProjectIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffMajorVersion >> dictBySubProjectIdx
		= new HashMap< IntNetBuffMajorVersionBySubProjectIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffMajorVersion >>();
	private Map< IntNetBuffMajorVersionByNameIdxKey,
			IntNetBuffMajorVersion > dictByNameIdx
		= new HashMap< IntNetBuffMajorVersionByNameIdxKey,
			IntNetBuffMajorVersion >();

	public IntNetRamMajorVersionTable( IIntNetSchema argSchema ) {
		schema = argSchema;
	}

	public IntNetBuffMajorVersion ensureRec(IIntNetMajorVersion rec) {
		return (((IntNetBuffMajorVersionFactoryService)(schema.getIntNetBuffFactory().getFactoryMajorVersion())).ensureRec(rec));
	}

	@Override
	public IIntNetMajorVersion createMajorVersion( ISecureAuthorization Authorization,
		IIntNetMajorVersion iBuff )
	{
		final String S_ProcName = "createMajorVersion";
		
		IntNetBuffMajorVersion Buff = (IntNetBuffMajorVersion)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextMajorVersionIdGen();
		Buff.setRequiredId( pkey );
		IntNetBuffMajorVersionByTenantIdxKey keyTenantIdx = (IntNetBuffMajorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffMajorVersionBySubProjectIdxKey keySubProjectIdx = (IntNetBuffMajorVersionBySubProjectIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
		keySubProjectIdx.setRequiredSubProjectId( Buff.getRequiredSubProjectId() );

		IntNetBuffMajorVersionByNameIdxKey keyNameIdx = (IntNetBuffMajorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByNameIdxKey();
		keyNameIdx.setRequiredSubProjectId( Buff.getRequiredSubProjectId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"MajorVersionNameIdx",
				"MajorVersionNameIdx",
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
				if( null == schema.getTableSubProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSubProjectId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ParentSubProject",
						"ParentSubProject",
						"SubProject",
						"SubProject",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion > subdictSubProjectIdx;
		if( dictBySubProjectIdx.containsKey( keySubProjectIdx ) ) {
			subdictSubProjectIdx = dictBySubProjectIdx.get( keySubProjectIdx );
		}
		else {
			subdictSubProjectIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion >();
			dictBySubProjectIdx.put( keySubProjectIdx, subdictSubProjectIdx );
		}
		subdictSubProjectIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IIntNetMajorVersion.CLASS_CODE) {
				IntNetBuffMajorVersion retbuff = ((IntNetBuffMajorVersion)(schema.getIntNetBuffFactory().getFactoryMajorVersion().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IIntNetMajorVersion readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readDerived";
		IIntNetMajorVersion buff;
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
	public IIntNetMajorVersion lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamMajorVersion.lockDerived";
		IIntNetMajorVersion buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMajorVersion[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "IntNetRamMajorVersion.readAllDerived";
		IIntNetMajorVersion[] retList = new IIntNetMajorVersion[ dictByPKey.values().size() ];
		Iterator< IntNetBuffMajorVersion > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IIntNetMajorVersion[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readDerivedByTenantIdx";
		IntNetBuffMajorVersionByTenantIdxKey key = (IntNetBuffMajorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByTenantIdxKey();

		key.setRequiredTenantId( TenantId );
		IIntNetMajorVersion[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new IIntNetMajorVersion[ subdictTenantIdx.size() ];
			Iterator< IntNetBuffMajorVersion > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion > subdictTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new IIntNetMajorVersion[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetMajorVersion[] readDerivedBySubProjectIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SubProjectId )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readDerivedBySubProjectIdx";
		IntNetBuffMajorVersionBySubProjectIdxKey key = (IntNetBuffMajorVersionBySubProjectIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newBySubProjectIdxKey();

		key.setRequiredSubProjectId( SubProjectId );
		IIntNetMajorVersion[] recArray;
		if( dictBySubProjectIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion > subdictSubProjectIdx
				= dictBySubProjectIdx.get( key );
			recArray = new IIntNetMajorVersion[ subdictSubProjectIdx.size() ];
			Iterator< IntNetBuffMajorVersion > iter = subdictSubProjectIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion > subdictSubProjectIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion >();
			dictBySubProjectIdx.put( key, subdictSubProjectIdx );
			recArray = new IIntNetMajorVersion[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetMajorVersion readDerivedByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SubProjectId,
		String Name )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readDerivedByNameIdx";
		IntNetBuffMajorVersionByNameIdxKey key = (IntNetBuffMajorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByNameIdxKey();

		key.setRequiredSubProjectId( SubProjectId );
		key.setRequiredName( Name );
		IIntNetMajorVersion buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMajorVersion readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readDerivedByIdIdx() ";
		IIntNetMajorVersion buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMajorVersion readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readRec";
		IIntNetMajorVersion buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetMajorVersion.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMajorVersion lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IIntNetMajorVersion buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetMajorVersion.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMajorVersion[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readAllRec";
		IIntNetMajorVersion buff;
		ArrayList<IIntNetMajorVersion> filteredList = new ArrayList<IIntNetMajorVersion>();
		IIntNetMajorVersion[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetMajorVersion.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IIntNetMajorVersion[0] ) );
	}

	@Override
	public IIntNetMajorVersion readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readRecByIdIdx() ";
		IIntNetMajorVersion buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetMajorVersion.CLASS_CODE ) ) {
			return( (IIntNetMajorVersion)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IIntNetMajorVersion[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readRecByTenantIdx() ";
		IIntNetMajorVersion buff;
		ArrayList<IIntNetMajorVersion> filteredList = new ArrayList<IIntNetMajorVersion>();
		IIntNetMajorVersion[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetMajorVersion.CLASS_CODE ) ) {
				filteredList.add( (IIntNetMajorVersion)buff );
			}
		}
		return( filteredList.toArray( new IIntNetMajorVersion[0] ) );
	}

	@Override
	public IIntNetMajorVersion[] readRecBySubProjectIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SubProjectId )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readRecBySubProjectIdx() ";
		IIntNetMajorVersion buff;
		ArrayList<IIntNetMajorVersion> filteredList = new ArrayList<IIntNetMajorVersion>();
		IIntNetMajorVersion[] buffList = readDerivedBySubProjectIdx( Authorization,
			SubProjectId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetMajorVersion.CLASS_CODE ) ) {
				filteredList.add( (IIntNetMajorVersion)buff );
			}
		}
		return( filteredList.toArray( new IIntNetMajorVersion[0] ) );
	}

	@Override
	public IIntNetMajorVersion readRecByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SubProjectId,
		String Name )
	{
		final String S_ProcName = "IntNetRamMajorVersion.readRecByNameIdx() ";
		IIntNetMajorVersion buff = readDerivedByNameIdx( Authorization,
			SubProjectId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetMajorVersion.CLASS_CODE ) ) {
			return( (IIntNetMajorVersion)buff );
		}
		else {
			return( null );
		}
	}

	public IIntNetMajorVersion updateMajorVersion( ISecureAuthorization Authorization,
		IIntNetMajorVersion iBuff )
	{
		IntNetBuffMajorVersion Buff = (IntNetBuffMajorVersion)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		IntNetBuffMajorVersion existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateMajorVersion",
				"Existing record not found",
				"Existing record not found",
				"MajorVersion",
				"MajorVersion",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateMajorVersion",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		IntNetBuffMajorVersionByTenantIdxKey existingKeyTenantIdx = (IntNetBuffMajorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffMajorVersionByTenantIdxKey newKeyTenantIdx = (IntNetBuffMajorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffMajorVersionBySubProjectIdxKey existingKeySubProjectIdx = (IntNetBuffMajorVersionBySubProjectIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
		existingKeySubProjectIdx.setRequiredSubProjectId( existing.getRequiredSubProjectId() );

		IntNetBuffMajorVersionBySubProjectIdxKey newKeySubProjectIdx = (IntNetBuffMajorVersionBySubProjectIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
		newKeySubProjectIdx.setRequiredSubProjectId( Buff.getRequiredSubProjectId() );

		IntNetBuffMajorVersionByNameIdxKey existingKeyNameIdx = (IntNetBuffMajorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByNameIdxKey();
		existingKeyNameIdx.setRequiredSubProjectId( existing.getRequiredSubProjectId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		IntNetBuffMajorVersionByNameIdxKey newKeyNameIdx = (IntNetBuffMajorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByNameIdxKey();
		newKeyNameIdx.setRequiredSubProjectId( Buff.getRequiredSubProjectId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateMajorVersion",
					"MajorVersionNameIdx",
					"MajorVersionNameIdx",
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
						"updateMajorVersion",
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
				if( null == schema.getTableSubProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSubProjectId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateMajorVersion",
						"Container",
						"Container",
						"ParentSubProject",
						"ParentSubProject",
						"SubProject",
						"SubProject",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion > subdict;

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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySubProjectIdx.get( existingKeySubProjectIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySubProjectIdx.containsKey( newKeySubProjectIdx ) ) {
			subdict = dictBySubProjectIdx.get( newKeySubProjectIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion >();
			dictBySubProjectIdx.put( newKeySubProjectIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteMajorVersion( ISecureAuthorization Authorization,
		IIntNetMajorVersion iBuff )
	{
		final String S_ProcName = "IntNetRamMajorVersionTable.deleteMajorVersion() ";
		IntNetBuffMajorVersion Buff = (IntNetBuffMajorVersion)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		IntNetBuffMajorVersion existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteMajorVersion",
				pkey );
		}
					schema.getTableMinorVersion().deleteMinorVersionByMajorVerIdx( Authorization,
						existing.getRequiredId() );
		IntNetBuffMajorVersionByTenantIdxKey keyTenantIdx = (IntNetBuffMajorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffMajorVersionBySubProjectIdxKey keySubProjectIdx = (IntNetBuffMajorVersionBySubProjectIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
		keySubProjectIdx.setRequiredSubProjectId( existing.getRequiredSubProjectId() );

		IntNetBuffMajorVersionByNameIdxKey keyNameIdx = (IntNetBuffMajorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByNameIdxKey();
		keyNameIdx.setRequiredSubProjectId( existing.getRequiredSubProjectId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, IntNetBuffMajorVersion > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictBySubProjectIdx.get( keySubProjectIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

	}
	@Override
	public void deleteMajorVersionByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		IntNetBuffMajorVersion cur;
		LinkedList<IntNetBuffMajorVersion> matchSet = new LinkedList<IntNetBuffMajorVersion>();
		Iterator<IntNetBuffMajorVersion> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMajorVersion> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMajorVersion)(schema.getTableMajorVersion().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteMajorVersion( Authorization, cur );
		}
	}

	@Override
	public void deleteMajorVersionByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		IntNetBuffMajorVersionByTenantIdxKey key = (IntNetBuffMajorVersionByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteMajorVersionByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteMajorVersionByTenantIdx( ISecureAuthorization Authorization,
		IIntNetMajorVersionByTenantIdxKey argKey )
	{
		IntNetBuffMajorVersion cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffMajorVersion> matchSet = new LinkedList<IntNetBuffMajorVersion>();
		Iterator<IntNetBuffMajorVersion> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMajorVersion> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMajorVersion)(schema.getTableMajorVersion().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteMajorVersion( Authorization, cur );
		}
	}

	@Override
	public void deleteMajorVersionBySubProjectIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSubProjectId )
	{
		IntNetBuffMajorVersionBySubProjectIdxKey key = (IntNetBuffMajorVersionBySubProjectIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
		key.setRequiredSubProjectId( argSubProjectId );
		deleteMajorVersionBySubProjectIdx( Authorization, key );
	}

	@Override
	public void deleteMajorVersionBySubProjectIdx( ISecureAuthorization Authorization,
		IIntNetMajorVersionBySubProjectIdxKey argKey )
	{
		IntNetBuffMajorVersion cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffMajorVersion> matchSet = new LinkedList<IntNetBuffMajorVersion>();
		Iterator<IntNetBuffMajorVersion> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMajorVersion> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMajorVersion)(schema.getTableMajorVersion().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteMajorVersion( Authorization, cur );
		}
	}

	@Override
	public void deleteMajorVersionByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSubProjectId,
		String argName )
	{
		IntNetBuffMajorVersionByNameIdxKey key = (IntNetBuffMajorVersionByNameIdxKey)schema.getIntNetBuffFactory().getFactoryMajorVersion().newByNameIdxKey();
		key.setRequiredSubProjectId( argSubProjectId );
		key.setRequiredName( argName );
		deleteMajorVersionByNameIdx( Authorization, key );
	}

	@Override
	public void deleteMajorVersionByNameIdx( ISecureAuthorization Authorization,
		IIntNetMajorVersionByNameIdxKey argKey )
	{
		IntNetBuffMajorVersion cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffMajorVersion> matchSet = new LinkedList<IntNetBuffMajorVersion>();
		Iterator<IntNetBuffMajorVersion> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMajorVersion> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMajorVersion)(schema.getTableMajorVersion().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteMajorVersion( Authorization, cur );
		}
	}
}
