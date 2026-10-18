
// Description: Java 25 in-memory RAM DbIO implementation for Tenant.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.secureram;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/*
 *	SecureRamTenantTable in-memory RAM DbIO implementation
 *	for Tenant.
 */
public class SecureRamTenantTable
	implements ISecureTenantTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffTenant > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffTenant >();
	private Map< SecureBuffTenantByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffTenant >> dictByClusterIdx
		= new HashMap< SecureBuffTenantByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffTenant >>();
	private Map< SecureBuffTenantByUNameIdxKey,
			SecureBuffTenant > dictByUNameIdx
		= new HashMap< SecureBuffTenantByUNameIdxKey,
			SecureBuffTenant >();

	public SecureRamTenantTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffTenant ensureRec(ISecureTenant rec) {
		return (((SecureBuffTenantFactoryService)(schema.getSecureBuffFactory().getFactoryTenant())).ensureRec(rec));
	}

	@Override
	public ISecureTenant createTenant( ISecureAuthorization Authorization,
		ISecureTenant iBuff )
	{
		final String S_ProcName = "createTenant";
		
		SecureBuffTenant Buff = (SecureBuffTenant)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextTenantIdGen();
		Buff.setRequiredId( pkey );
		SecureBuffTenantByClusterIdxKey keyClusterIdx = (SecureBuffTenantByClusterIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		SecureBuffTenantByUNameIdxKey keyUNameIdx = (SecureBuffTenantByUNameIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUNameIdx.setRequiredTenantName( Buff.getRequiredTenantName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TenantUNameIdx",
				"TenantUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"TenantCluster",
						"TenantCluster",
						"Cluster",
						"Cluster",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffTenant > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffTenant >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureTenant.CLASS_CODE) {
				SecureBuffTenant retbuff = ((SecureBuffTenant)(schema.getSecureBuffFactory().getFactoryTenant().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureTenant readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamTenant.readDerived";
		ISecureTenant buff;
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
	public ISecureTenant lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamTenant.lockDerived";
		ISecureTenant buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTenant[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamTenant.readAllDerived";
		ISecureTenant[] retList = new ISecureTenant[ dictByPKey.values().size() ];
		Iterator< SecureBuffTenant > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureTenant[] readDerivedByClusterIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "SecureRamTenant.readDerivedByClusterIdx";
		SecureBuffTenantByClusterIdxKey key = (SecureBuffTenantByClusterIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByClusterIdxKey();

		key.setRequiredClusterId( ClusterId );
		ISecureTenant[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffTenant > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new ISecureTenant[ subdictClusterIdx.size() ];
			Iterator< SecureBuffTenant > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffTenant > subdictClusterIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffTenant >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new ISecureTenant[0];
		}
		return( recArray );
	}

	@Override
	public ISecureTenant readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClusterId,
		String TenantName )
	{
		final String S_ProcName = "SecureRamTenant.readDerivedByUNameIdx";
		SecureBuffTenantByUNameIdxKey key = (SecureBuffTenantByUNameIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByUNameIdxKey();

		key.setRequiredClusterId( ClusterId );
		key.setRequiredTenantName( TenantName );
		ISecureTenant buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTenant readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "SecureRamTenant.readDerivedByIdIdx() ";
		ISecureTenant buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTenant readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamTenant.readRec";
		ISecureTenant buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureTenant.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTenant lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureTenant buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureTenant.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTenant[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamTenant.readAllRec";
		ISecureTenant buff;
		ArrayList<ISecureTenant> filteredList = new ArrayList<ISecureTenant>();
		ISecureTenant[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureTenant.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureTenant[0] ) );
	}

	/**
	 *	Read a page of all the specific Tenant buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Tenant instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureTenant[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureTenant readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "SecureRamTenant.readRecByIdIdx() ";
		ISecureTenant buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureTenant.CLASS_CODE ) ) {
			return( (ISecureTenant)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureTenant[] readRecByClusterIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "SecureRamTenant.readRecByClusterIdx() ";
		ISecureTenant buff;
		ArrayList<ISecureTenant> filteredList = new ArrayList<ISecureTenant>();
		ISecureTenant[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureTenant.CLASS_CODE ) ) {
				filteredList.add( (ISecureTenant)buff );
			}
		}
		return( filteredList.toArray( new ISecureTenant[0] ) );
	}

	@Override
	public ISecureTenant readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClusterId,
		String TenantName )
	{
		final String S_ProcName = "SecureRamTenant.readRecByUNameIdx() ";
		ISecureTenant buff = readDerivedByUNameIdx( Authorization,
			ClusterId,
			TenantName );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureTenant.CLASS_CODE ) ) {
			return( (ISecureTenant)buff );
		}
		else {
			return( null );
		}
	}

	/**
	 *	Read a page array of the specific Tenant buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureTenant[] pageRecByClusterIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClusterId,
		IYCFKeyHash256 priorId )
	{
		final String S_ProcName = "pageRecByClusterIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	public ISecureTenant updateTenant( ISecureAuthorization Authorization,
		ISecureTenant iBuff )
	{
		SecureBuffTenant Buff = (SecureBuffTenant)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffTenant existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateTenant",
				"Existing record not found",
				"Existing record not found",
				"Tenant",
				"Tenant",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateTenant",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffTenantByClusterIdxKey existingKeyClusterIdx = (SecureBuffTenantByClusterIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		SecureBuffTenantByClusterIdxKey newKeyClusterIdx = (SecureBuffTenantByClusterIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		SecureBuffTenantByUNameIdxKey existingKeyUNameIdx = (SecureBuffTenantByUNameIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUNameIdx.setRequiredTenantName( existing.getRequiredTenantName() );

		SecureBuffTenantByUNameIdxKey newKeyUNameIdx = (SecureBuffTenantByUNameIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUNameIdx.setRequiredTenantName( Buff.getRequiredTenantName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTenant",
					"TenantUNameIdx",
					"TenantUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableCluster().readDerivedByIdIdx( Authorization,
						Buff.getRequiredClusterId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateTenant",
						"Container",
						"Container",
						"TenantCluster",
						"TenantCluster",
						"Cluster",
						"Cluster",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffTenant > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClusterIdx.get( existingKeyClusterIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClusterIdx.containsKey( newKeyClusterIdx ) ) {
			subdict = dictByClusterIdx.get( newKeyClusterIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffTenant >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteTenant( ISecureAuthorization Authorization,
		ISecureTenant iBuff )
	{
		final String S_ProcName = "SecureRamTenantTable.deleteTenant() ";
		SecureBuffTenant Buff = (SecureBuffTenant)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffTenant existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteTenant",
				pkey );
		}
					schema.getTableSecTentRole().deleteSecTentRoleByTenantIdx( Authorization,
						existing.getRequiredId() );
		SecureBuffSecTentGrp buffDelTentGrpMembs;
		ISecureSecTentGrp arrDelTentGrpMembs[] = schema.getTableSecTentGrp().readDerivedByTenantIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTentGrpMembs = 0; idxDelTentGrpMembs < arrDelTentGrpMembs.length; idxDelTentGrpMembs++ ) {
			buffDelTentGrpMembs = (SecureBuffSecTentGrp)(arrDelTentGrpMembs[idxDelTentGrpMembs]);
					schema.getTableSecTentGrpMemb().deleteSecTentGrpMembByTentGrpIdx( Authorization,
						buffDelTentGrpMembs.getRequiredSecTentGrpId() );
		}
					schema.getTableSecTentGrp().deleteSecTentGrpByTenantIdx( Authorization,
						existing.getRequiredId() );
		SecureBuffTenantByClusterIdxKey keyClusterIdx = (SecureBuffTenantByClusterIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		SecureBuffTenantByUNameIdxKey keyUNameIdx = (SecureBuffTenantByUNameIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUNameIdx.setRequiredTenantName( existing.getRequiredTenantName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffTenant > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	@Override
	public void deleteTenantByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffTenant cur;
		LinkedList<SecureBuffTenant> matchSet = new LinkedList<SecureBuffTenant>();
		Iterator<SecureBuffTenant> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffTenant> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffTenant)(schema.getTableTenant().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTenant( Authorization, cur );
		}
	}

	@Override
	public void deleteTenantByClusterIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClusterId )
	{
		SecureBuffTenantByClusterIdxKey key = (SecureBuffTenantByClusterIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteTenantByClusterIdx( Authorization, key );
	}

	@Override
	public void deleteTenantByClusterIdx( ISecureAuthorization Authorization,
		ISecureTenantByClusterIdxKey argKey )
	{
		SecureBuffTenant cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffTenant> matchSet = new LinkedList<SecureBuffTenant>();
		Iterator<SecureBuffTenant> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffTenant> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffTenant)(schema.getTableTenant().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTenant( Authorization, cur );
		}
	}

	@Override
	public void deleteTenantByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClusterId,
		String argTenantName )
	{
		SecureBuffTenantByUNameIdxKey key = (SecureBuffTenantByUNameIdxKey)schema.getSecureBuffFactory().getFactoryTenant().newByUNameIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredTenantName( argTenantName );
		deleteTenantByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteTenantByUNameIdx( ISecureAuthorization Authorization,
		ISecureTenantByUNameIdxKey argKey )
	{
		SecureBuffTenant cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffTenant> matchSet = new LinkedList<SecureBuffTenant>();
		Iterator<SecureBuffTenant> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffTenant> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffTenant)(schema.getTableTenant().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteTenant( Authorization, cur );
		}
	}
}
