
// Description: Java 25 in-memory RAM DbIO implementation for TopProject.

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
 *	IntNetRamTopProjectTable in-memory RAM DbIO implementation
 *	for TopProject.
 */
public class IntNetRamTopProjectTable
	implements IIntNetTopProjectTable
{
	private IIntNetSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				IntNetBuffTopProject > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				IntNetBuffTopProject >();
	private Map< IntNetBuffTopProjectByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffTopProject >> dictByTenantIdx
		= new HashMap< IntNetBuffTopProjectByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffTopProject >>();
	private Map< IntNetBuffTopProjectByTopDomainIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffTopProject >> dictByTopDomainIdx
		= new HashMap< IntNetBuffTopProjectByTopDomainIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffTopProject >>();
	private Map< IntNetBuffTopProjectByNameIdxKey,
			IntNetBuffTopProject > dictByNameIdx
		= new HashMap< IntNetBuffTopProjectByNameIdxKey,
			IntNetBuffTopProject >();

	public IntNetRamTopProjectTable( IIntNetSchema argSchema ) {
		schema = argSchema;
	}

	public IntNetBuffTopProject ensureRec(IIntNetTopProject rec) {
		return (((IntNetBuffTopProjectFactoryService)(schema.getIntNetBuffFactory().getFactoryTopProject())).ensureRec(rec));
	}

	@Override
	public IIntNetTopProject createTopProject( ISecureAuthorization Authorization,
		IIntNetTopProject iBuff )
	{
		final String S_ProcName = "createTopProject";
		
		IntNetBuffTopProject Buff = (IntNetBuffTopProject)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextTopProjectIdGen();
		Buff.setRequiredId( pkey );
		IntNetBuffTopProjectByTenantIdxKey keyTenantIdx = (IntNetBuffTopProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffTopProjectByTopDomainIdxKey keyTopDomainIdx = (IntNetBuffTopProjectByTopDomainIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTopDomainIdxKey();
		keyTopDomainIdx.setRequiredTopDomainId( Buff.getRequiredTopDomainId() );

		IntNetBuffTopProjectByNameIdxKey keyNameIdx = (IntNetBuffTopProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByNameIdxKey();
		keyNameIdx.setRequiredTopDomainId( Buff.getRequiredTopDomainId() );
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TopProjectNameIdx",
				"TopProjectNameIdx",
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
				if( null == schema.getTableTopDomain().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTopDomainId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ParentTopDomain",
						"ParentTopDomain",
						"TopDomain",
						"TopDomain",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffTopProject > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffTopProject >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffTopProject > subdictTopDomainIdx;
		if( dictByTopDomainIdx.containsKey( keyTopDomainIdx ) ) {
			subdictTopDomainIdx = dictByTopDomainIdx.get( keyTopDomainIdx );
		}
		else {
			subdictTopDomainIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffTopProject >();
			dictByTopDomainIdx.put( keyTopDomainIdx, subdictTopDomainIdx );
		}
		subdictTopDomainIdx.put( pkey, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IIntNetTopProject.CLASS_CODE) {
				IntNetBuffTopProject retbuff = ((IntNetBuffTopProject)(schema.getIntNetBuffFactory().getFactoryTopProject().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IIntNetTopProject readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamTopProject.readDerived";
		IIntNetTopProject buff;
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
	public IIntNetTopProject lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamTopProject.lockDerived";
		IIntNetTopProject buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTopProject[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "IntNetRamTopProject.readAllDerived";
		IIntNetTopProject[] retList = new IIntNetTopProject[ dictByPKey.values().size() ];
		Iterator< IntNetBuffTopProject > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IIntNetTopProject[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamTopProject.readDerivedByTenantIdx";
		IntNetBuffTopProjectByTenantIdxKey key = (IntNetBuffTopProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTenantIdxKey();

		key.setRequiredTenantId( TenantId );
		IIntNetTopProject[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffTopProject > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new IIntNetTopProject[ subdictTenantIdx.size() ];
			Iterator< IntNetBuffTopProject > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffTopProject > subdictTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffTopProject >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new IIntNetTopProject[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetTopProject[] readDerivedByTopDomainIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopDomainId )
	{
		final String S_ProcName = "IntNetRamTopProject.readDerivedByTopDomainIdx";
		IntNetBuffTopProjectByTopDomainIdxKey key = (IntNetBuffTopProjectByTopDomainIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTopDomainIdxKey();

		key.setRequiredTopDomainId( TopDomainId );
		IIntNetTopProject[] recArray;
		if( dictByTopDomainIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffTopProject > subdictTopDomainIdx
				= dictByTopDomainIdx.get( key );
			recArray = new IIntNetTopProject[ subdictTopDomainIdx.size() ];
			Iterator< IntNetBuffTopProject > iter = subdictTopDomainIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffTopProject > subdictTopDomainIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffTopProject >();
			dictByTopDomainIdx.put( key, subdictTopDomainIdx );
			recArray = new IIntNetTopProject[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetTopProject readDerivedByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopDomainId,
		String Name )
	{
		final String S_ProcName = "IntNetRamTopProject.readDerivedByNameIdx";
		IntNetBuffTopProjectByNameIdxKey key = (IntNetBuffTopProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByNameIdxKey();

		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		IIntNetTopProject buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTopProject readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamTopProject.readDerivedByIdIdx() ";
		IIntNetTopProject buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTopProject readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamTopProject.readRec";
		IIntNetTopProject buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetTopProject.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTopProject lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IIntNetTopProject buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetTopProject.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetTopProject[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "IntNetRamTopProject.readAllRec";
		IIntNetTopProject buff;
		ArrayList<IIntNetTopProject> filteredList = new ArrayList<IIntNetTopProject>();
		IIntNetTopProject[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetTopProject.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IIntNetTopProject[0] ) );
	}

	@Override
	public IIntNetTopProject readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamTopProject.readRecByIdIdx() ";
		IIntNetTopProject buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetTopProject.CLASS_CODE ) ) {
			return( (IIntNetTopProject)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IIntNetTopProject[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamTopProject.readRecByTenantIdx() ";
		IIntNetTopProject buff;
		ArrayList<IIntNetTopProject> filteredList = new ArrayList<IIntNetTopProject>();
		IIntNetTopProject[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetTopProject.CLASS_CODE ) ) {
				filteredList.add( (IIntNetTopProject)buff );
			}
		}
		return( filteredList.toArray( new IIntNetTopProject[0] ) );
	}

	@Override
	public IIntNetTopProject[] readRecByTopDomainIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopDomainId )
	{
		final String S_ProcName = "IntNetRamTopProject.readRecByTopDomainIdx() ";
		IIntNetTopProject buff;
		ArrayList<IIntNetTopProject> filteredList = new ArrayList<IIntNetTopProject>();
		IIntNetTopProject[] buffList = readDerivedByTopDomainIdx( Authorization,
			TopDomainId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetTopProject.CLASS_CODE ) ) {
				filteredList.add( (IIntNetTopProject)buff );
			}
		}
		return( filteredList.toArray( new IIntNetTopProject[0] ) );
	}

	@Override
	public IIntNetTopProject readRecByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopDomainId,
		String Name )
	{
		final String S_ProcName = "IntNetRamTopProject.readRecByNameIdx() ";
		IIntNetTopProject buff = readDerivedByNameIdx( Authorization,
			TopDomainId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetTopProject.CLASS_CODE ) ) {
			return( (IIntNetTopProject)buff );
		}
		else {
			return( null );
		}
	}

	public IIntNetTopProject updateTopProject( ISecureAuthorization Authorization,
		IIntNetTopProject iBuff )
	{
		IntNetBuffTopProject Buff = (IntNetBuffTopProject)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		IntNetBuffTopProject existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateTopProject",
				"Existing record not found",
				"Existing record not found",
				"TopProject",
				"TopProject",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateTopProject",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		IntNetBuffTopProjectByTenantIdxKey existingKeyTenantIdx = (IntNetBuffTopProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffTopProjectByTenantIdxKey newKeyTenantIdx = (IntNetBuffTopProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffTopProjectByTopDomainIdxKey existingKeyTopDomainIdx = (IntNetBuffTopProjectByTopDomainIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTopDomainIdxKey();
		existingKeyTopDomainIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );

		IntNetBuffTopProjectByTopDomainIdxKey newKeyTopDomainIdx = (IntNetBuffTopProjectByTopDomainIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTopDomainIdxKey();
		newKeyTopDomainIdx.setRequiredTopDomainId( Buff.getRequiredTopDomainId() );

		IntNetBuffTopProjectByNameIdxKey existingKeyNameIdx = (IntNetBuffTopProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByNameIdxKey();
		existingKeyNameIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		IntNetBuffTopProjectByNameIdxKey newKeyNameIdx = (IntNetBuffTopProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByNameIdxKey();
		newKeyNameIdx.setRequiredTopDomainId( Buff.getRequiredTopDomainId() );
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTopProject",
					"TopProjectNameIdx",
					"TopProjectNameIdx",
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
						"updateTopProject",
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
				if( null == schema.getTableTopDomain().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTopDomainId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateTopProject",
						"Container",
						"Container",
						"ParentTopDomain",
						"ParentTopDomain",
						"TopDomain",
						"TopDomain",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, IntNetBuffTopProject > subdict;

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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffTopProject >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByTopDomainIdx.get( existingKeyTopDomainIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTopDomainIdx.containsKey( newKeyTopDomainIdx ) ) {
			subdict = dictByTopDomainIdx.get( newKeyTopDomainIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffTopProject >();
			dictByTopDomainIdx.put( newKeyTopDomainIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteTopProject( ISecureAuthorization Authorization,
		IIntNetTopProject iBuff )
	{
		final String S_ProcName = "IntNetRamTopProjectTable.deleteTopProject() ";
		IntNetBuffTopProject Buff = (IntNetBuffTopProject)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		IntNetBuffTopProject existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteTopProject",
				pkey );
		}
					schema.getTableSubProject().deleteSubProjectByTopProjectIdx( Authorization,
						existing.getRequiredId() );
		IntNetBuffTopProjectByTenantIdxKey keyTenantIdx = (IntNetBuffTopProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffTopProjectByTopDomainIdxKey keyTopDomainIdx = (IntNetBuffTopProjectByTopDomainIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTopDomainIdxKey();
		keyTopDomainIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );

		IntNetBuffTopProjectByNameIdxKey keyNameIdx = (IntNetBuffTopProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByNameIdxKey();
		keyNameIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, IntNetBuffTopProject > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByTopDomainIdx.get( keyTopDomainIdx );
		subdict.remove( pkey );

		dictByNameIdx.remove( keyNameIdx );

	}
	@Override
	public void deleteTopProjectByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		IntNetBuffTopProject cur;
		LinkedList<IntNetBuffTopProject> matchSet = new LinkedList<IntNetBuffTopProject>();
		Iterator<IntNetBuffTopProject> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffTopProject> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffTopProject)(schema.getTableTopProject().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTopProject( Authorization, cur );
		}
	}

	@Override
	public void deleteTopProjectByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		IntNetBuffTopProjectByTenantIdxKey key = (IntNetBuffTopProjectByTenantIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteTopProjectByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteTopProjectByTenantIdx( ISecureAuthorization Authorization,
		IIntNetTopProjectByTenantIdxKey argKey )
	{
		IntNetBuffTopProject cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffTopProject> matchSet = new LinkedList<IntNetBuffTopProject>();
		Iterator<IntNetBuffTopProject> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffTopProject> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffTopProject)(schema.getTableTopProject().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTopProject( Authorization, cur );
		}
	}

	@Override
	public void deleteTopProjectByTopDomainIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTopDomainId )
	{
		IntNetBuffTopProjectByTopDomainIdxKey key = (IntNetBuffTopProjectByTopDomainIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByTopDomainIdxKey();
		key.setRequiredTopDomainId( argTopDomainId );
		deleteTopProjectByTopDomainIdx( Authorization, key );
	}

	@Override
	public void deleteTopProjectByTopDomainIdx( ISecureAuthorization Authorization,
		IIntNetTopProjectByTopDomainIdxKey argKey )
	{
		IntNetBuffTopProject cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffTopProject> matchSet = new LinkedList<IntNetBuffTopProject>();
		Iterator<IntNetBuffTopProject> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffTopProject> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffTopProject)(schema.getTableTopProject().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTopProject( Authorization, cur );
		}
	}

	@Override
	public void deleteTopProjectByNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTopDomainId,
		String argName )
	{
		IntNetBuffTopProjectByNameIdxKey key = (IntNetBuffTopProjectByNameIdxKey)schema.getIntNetBuffFactory().getFactoryTopProject().newByNameIdxKey();
		key.setRequiredTopDomainId( argTopDomainId );
		key.setRequiredName( argName );
		deleteTopProjectByNameIdx( Authorization, key );
	}

	@Override
	public void deleteTopProjectByNameIdx( ISecureAuthorization Authorization,
		IIntNetTopProjectByNameIdxKey argKey )
	{
		IntNetBuffTopProject cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffTopProject> matchSet = new LinkedList<IntNetBuffTopProject>();
		Iterator<IntNetBuffTopProject> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffTopProject> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffTopProject)(schema.getTableTopProject().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTopProject( Authorization, cur );
		}
	}
}
