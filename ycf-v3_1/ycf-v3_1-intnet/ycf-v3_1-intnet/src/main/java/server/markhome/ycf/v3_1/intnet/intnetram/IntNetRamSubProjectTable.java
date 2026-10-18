
// Description: Java 25 in-memory RAM DbIO implementation for SubProject.

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
 *	IntNetRamSubProjectTable in-memory RAM DbIO implementation
 *	for SubProject.
 */
public class IntNetRamSubProjectTable
	implements IIntNetSubProjectTable
{
	private IIntNetSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				IntNetBuffSubProject > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				IntNetBuffSubProject >();
	private Map< IntNetBuffSubProjectByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffSubProject >> dictByTenantIdx
		= new HashMap< IntNetBuffSubProjectByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffSubProject >>();
	private Map< IntNetBuffSubProjectByTopProjectIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffSubProject >> dictByTopProjectIdx
		= new HashMap< IntNetBuffSubProjectByTopProjectIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffSubProject >>();
	private Map< IntNetBuffSubProjectByNameIdxKey,
			IntNetBuffSubProject > dictByNameIdx
		= new HashMap< IntNetBuffSubProjectByNameIdxKey,
			IntNetBuffSubProject >();

	public IntNetRamSubProjectTable( IIntNetSchema argSchema ) {
		schema = argSchema;
	}

	public IntNetBuffSubProject ensureRec(IIntNetSubProject rec) {
		return (((IntNetBuffSubProjectFactoryService)(schema.getIntNetBuffFactory().getFactorySubProject())).ensureRec(rec));
	}

	@Override
	public IIntNetSubProject createSubProject( ISecureAuthorization Authorization,
		IIntNetSubProject iBuff )
	{
		final String S_ProcName = "createSubProject";
		
		IntNetBuffSubProject Buff = (IntNetBuffSubProject)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextSubProjectIdGen();
		Buff.setRequiredId( pkey );
		IntNetBuffSubProjectByTenantIdxKey keyTenantIdx = (IntNetBuffSubProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffSubProjectByTopProjectIdxKey keyTopProjectIdx = (IntNetBuffSubProjectByTopProjectIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTopProjectIdxKey();
		keyTopProjectIdx.setRequiredTopProjectId( Buff.getRequiredTopProjectId() );

		IntNetBuffSubProjectByNameIdxKey keyNameIdx = (IntNetBuffSubProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByNameIdxKey();
		keyNameIdx.setRequiredTopProjectId( Buff.getRequiredTopProjectId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SubProjectNameIdx",
				"SubProjectNameIdx",
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
				if( null == schema.getTableTopProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTopProjectId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ParentTopProject",
						"ParentTopProject",
						"TopProject",
						"TopProject",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffSubProject > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffSubProject >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffSubProject > subdictTopProjectIdx;
		if( dictByTopProjectIdx.containsKey( keyTopProjectIdx ) ) {
			subdictTopProjectIdx = dictByTopProjectIdx.get( keyTopProjectIdx );
		}
		else {
			subdictTopProjectIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffSubProject >();
			dictByTopProjectIdx.put( keyTopProjectIdx, subdictTopProjectIdx );
		}
		subdictTopProjectIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IIntNetSubProject.CLASS_CODE) {
				IntNetBuffSubProject retbuff = ((IntNetBuffSubProject)(schema.getIntNetBuffFactory().getFactorySubProject().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IIntNetSubProject readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamSubProject.readDerived";
		IIntNetSubProject buff;
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
	public IIntNetSubProject lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamSubProject.lockDerived";
		IIntNetSubProject buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetSubProject[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "IntNetRamSubProject.readAllDerived";
		IIntNetSubProject[] retList = new IIntNetSubProject[ dictByPKey.values().size() ];
		Iterator< IntNetBuffSubProject > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IIntNetSubProject[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamSubProject.readDerivedByTenantIdx";
		IntNetBuffSubProjectByTenantIdxKey key = (IntNetBuffSubProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTenantIdxKey();

		key.setRequiredTenantId( TenantId );
		IIntNetSubProject[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffSubProject > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new IIntNetSubProject[ subdictTenantIdx.size() ];
			Iterator< IntNetBuffSubProject > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffSubProject > subdictTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffSubProject >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new IIntNetSubProject[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetSubProject[] readDerivedByTopProjectIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopProjectId )
	{
		final String S_ProcName = "IntNetRamSubProject.readDerivedByTopProjectIdx";
		IntNetBuffSubProjectByTopProjectIdxKey key = (IntNetBuffSubProjectByTopProjectIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTopProjectIdxKey();

		key.setRequiredTopProjectId( TopProjectId );
		IIntNetSubProject[] recArray;
		if( dictByTopProjectIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffSubProject > subdictTopProjectIdx
				= dictByTopProjectIdx.get( key );
			recArray = new IIntNetSubProject[ subdictTopProjectIdx.size() ];
			Iterator< IntNetBuffSubProject > iter = subdictTopProjectIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffSubProject > subdictTopProjectIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffSubProject >();
			dictByTopProjectIdx.put( key, subdictTopProjectIdx );
			recArray = new IIntNetSubProject[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetSubProject readDerivedByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopProjectId,
		String Name )
	{
		final String S_ProcName = "IntNetRamSubProject.readDerivedByNameIdx";
		IntNetBuffSubProjectByNameIdxKey key = (IntNetBuffSubProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByNameIdxKey();

		key.setRequiredTopProjectId( TopProjectId );
		key.setRequiredName( Name );
		IIntNetSubProject buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetSubProject readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamSubProject.readDerivedByIdIdx() ";
		IIntNetSubProject buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetSubProject readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamSubProject.readRec";
		IIntNetSubProject buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetSubProject.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetSubProject lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IIntNetSubProject buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetSubProject.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetSubProject[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "IntNetRamSubProject.readAllRec";
		IIntNetSubProject buff;
		ArrayList<IIntNetSubProject> filteredList = new ArrayList<IIntNetSubProject>();
		IIntNetSubProject[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetSubProject.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IIntNetSubProject[0] ) );
	}

	@Override
	public IIntNetSubProject readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamSubProject.readRecByIdIdx() ";
		IIntNetSubProject buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetSubProject.CLASS_CODE ) ) {
			return( (IIntNetSubProject)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IIntNetSubProject[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamSubProject.readRecByTenantIdx() ";
		IIntNetSubProject buff;
		ArrayList<IIntNetSubProject> filteredList = new ArrayList<IIntNetSubProject>();
		IIntNetSubProject[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetSubProject.CLASS_CODE ) ) {
				filteredList.add( (IIntNetSubProject)buff );
			}
		}
		return( filteredList.toArray( new IIntNetSubProject[0] ) );
	}

	@Override
	public IIntNetSubProject[] readRecByTopProjectIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopProjectId )
	{
		final String S_ProcName = "IntNetRamSubProject.readRecByTopProjectIdx() ";
		IIntNetSubProject buff;
		ArrayList<IIntNetSubProject> filteredList = new ArrayList<IIntNetSubProject>();
		IIntNetSubProject[] buffList = readDerivedByTopProjectIdx( Authorization,
			TopProjectId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetSubProject.CLASS_CODE ) ) {
				filteredList.add( (IIntNetSubProject)buff );
			}
		}
		return( filteredList.toArray( new IIntNetSubProject[0] ) );
	}

	@Override
	public IIntNetSubProject readRecByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopProjectId,
		String Name )
	{
		final String S_ProcName = "IntNetRamSubProject.readRecByNameIdx() ";
		IIntNetSubProject buff = readDerivedByNameIdx( Authorization,
			TopProjectId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetSubProject.CLASS_CODE ) ) {
			return( (IIntNetSubProject)buff );
		}
		else {
			return( null );
		}
	}

	public IIntNetSubProject updateSubProject( ISecureAuthorization Authorization,
		IIntNetSubProject iBuff )
	{
		IntNetBuffSubProject Buff = (IntNetBuffSubProject)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		IntNetBuffSubProject existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSubProject",
				"Existing record not found",
				"Existing record not found",
				"SubProject",
				"SubProject",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSubProject",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		IntNetBuffSubProjectByTenantIdxKey existingKeyTenantIdx = (IntNetBuffSubProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffSubProjectByTenantIdxKey newKeyTenantIdx = (IntNetBuffSubProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffSubProjectByTopProjectIdxKey existingKeyTopProjectIdx = (IntNetBuffSubProjectByTopProjectIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTopProjectIdxKey();
		existingKeyTopProjectIdx.setRequiredTopProjectId( existing.getRequiredTopProjectId() );

		IntNetBuffSubProjectByTopProjectIdxKey newKeyTopProjectIdx = (IntNetBuffSubProjectByTopProjectIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTopProjectIdxKey();
		newKeyTopProjectIdx.setRequiredTopProjectId( Buff.getRequiredTopProjectId() );

		IntNetBuffSubProjectByNameIdxKey existingKeyNameIdx = (IntNetBuffSubProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByNameIdxKey();
		existingKeyNameIdx.setRequiredTopProjectId( existing.getRequiredTopProjectId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		IntNetBuffSubProjectByNameIdxKey newKeyNameIdx = (IntNetBuffSubProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByNameIdxKey();
		newKeyNameIdx.setRequiredTopProjectId( Buff.getRequiredTopProjectId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSubProject",
					"SubProjectNameIdx",
					"SubProjectNameIdx",
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
						"updateSubProject",
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
				if( null == schema.getTableTopProject().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTopProjectId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSubProject",
						"Container",
						"Container",
						"ParentTopProject",
						"ParentTopProject",
						"TopProject",
						"TopProject",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, IntNetBuffSubProject > subdict;

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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffSubProject >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTopProjectIdx.get( existingKeyTopProjectIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTopProjectIdx.containsKey( newKeyTopProjectIdx ) ) {
			subdict = dictByTopProjectIdx.get( newKeyTopProjectIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffSubProject >();
			dictByTopProjectIdx.put( newKeyTopProjectIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteSubProject( ISecureAuthorization Authorization,
		IIntNetSubProject iBuff )
	{
		final String S_ProcName = "IntNetRamSubProjectTable.deleteSubProject() ";
		IntNetBuffSubProject Buff = (IntNetBuffSubProject)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		IntNetBuffSubProject existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSubProject",
				pkey );
		}
					schema.getTableMajorVersion().deleteMajorVersionBySubProjectIdx( Authorization,
						existing.getRequiredId() );
		IntNetBuffSubProjectByTenantIdxKey keyTenantIdx = (IntNetBuffSubProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffSubProjectByTopProjectIdxKey keyTopProjectIdx = (IntNetBuffSubProjectByTopProjectIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTopProjectIdxKey();
		keyTopProjectIdx.setRequiredTopProjectId( existing.getRequiredTopProjectId() );

		IntNetBuffSubProjectByNameIdxKey keyNameIdx = (IntNetBuffSubProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByNameIdxKey();
		keyNameIdx.setRequiredTopProjectId( existing.getRequiredTopProjectId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, IntNetBuffSubProject > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByTopProjectIdx.get( keyTopProjectIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

	}
	@Override
	public void deleteSubProjectByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		IntNetBuffSubProject cur;
		LinkedList<IntNetBuffSubProject> matchSet = new LinkedList<IntNetBuffSubProject>();
		Iterator<IntNetBuffSubProject> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffSubProject> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffSubProject)(schema.getTableSubProject().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSubProject( Authorization, cur );
		}
	}

	@Override
	public void deleteSubProjectByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		IntNetBuffSubProjectByTenantIdxKey key = (IntNetBuffSubProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSubProjectByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteSubProjectByTenantIdx( ISecureAuthorization Authorization,
		IIntNetSubProjectByTenantIdxKey argKey )
	{
		IntNetBuffSubProject cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffSubProject> matchSet = new LinkedList<IntNetBuffSubProject>();
		Iterator<IntNetBuffSubProject> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffSubProject> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffSubProject)(schema.getTableSubProject().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSubProject( Authorization, cur );
		}
	}

	@Override
	public void deleteSubProjectByTopProjectIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTopProjectId )
	{
		IntNetBuffSubProjectByTopProjectIdxKey key = (IntNetBuffSubProjectByTopProjectIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByTopProjectIdxKey();
		key.setRequiredTopProjectId( argTopProjectId );
		deleteSubProjectByTopProjectIdx( Authorization, key );
	}

	@Override
	public void deleteSubProjectByTopProjectIdx( ISecureAuthorization Authorization,
		IIntNetSubProjectByTopProjectIdxKey argKey )
	{
		IntNetBuffSubProject cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffSubProject> matchSet = new LinkedList<IntNetBuffSubProject>();
		Iterator<IntNetBuffSubProject> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffSubProject> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffSubProject)(schema.getTableSubProject().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSubProject( Authorization, cur );
		}
	}

	@Override
	public void deleteSubProjectByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTopProjectId,
		String argName )
	{
		IntNetBuffSubProjectByNameIdxKey key = (IntNetBuffSubProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactorySubProject().newByNameIdxKey();
		key.setRequiredTopProjectId( argTopProjectId );
		key.setRequiredName( argName );
		deleteSubProjectByNameIdx( Authorization, key );
	}

	@Override
	public void deleteSubProjectByNameIdx( ISecureAuthorization Authorization,
		IIntNetSubProjectByNameIdxKey argKey )
	{
		IntNetBuffSubProject cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffSubProject> matchSet = new LinkedList<IntNetBuffSubProject>();
		Iterator<IntNetBuffSubProject> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffSubProject> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffSubProject)(schema.getTableSubProject().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSubProject( Authorization, cur );
		}
	}
}
