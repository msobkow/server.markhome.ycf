
// Description: Java 25 in-memory RAM DbIO implementation for SecClusGrp.

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
 *	SecureRamSecClusGrpTable in-memory RAM DbIO implementation
 *	for SecClusGrp.
 */
public class SecureRamSecClusGrpTable
	implements ISecureSecClusGrpTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecClusGrp > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecClusGrp >();
	private Map< SecureBuffSecClusGrpByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecClusGrp >> dictByClusterIdx
		= new HashMap< SecureBuffSecClusGrpByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecClusGrp >>();
	private Map< SecureBuffSecClusGrpByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecClusGrp >> dictByNameIdx
		= new HashMap< SecureBuffSecClusGrpByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecClusGrp >>();
	private Map< SecureBuffSecClusGrpByUNameIdxKey,
			SecureBuffSecClusGrp > dictByUNameIdx
		= new HashMap< SecureBuffSecClusGrpByUNameIdxKey,
			SecureBuffSecClusGrp >();

	public SecureRamSecClusGrpTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecClusGrp ensureRec(ISecureSecClusGrp rec) {
		return (((SecureBuffSecClusGrpFactoryService)(schema.getSecureBuffFactory().getFactorySecClusGrp())).ensureRec(rec));
	}

	@Override
	public ISecureSecClusGrp createSecClusGrp( ISecureAuthorization Authorization,
		ISecureSecClusGrp iBuff )
	{
		final String S_ProcName = "createSecClusGrp";
		
		SecureBuffSecClusGrp Buff = (SecureBuffSecClusGrp)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextSecClusGrpIdGen();
		Buff.setRequiredSecClusGrpId( pkey );
		SecureBuffSecClusGrpByClusterIdxKey keyClusterIdx = (SecureBuffSecClusGrpByClusterIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		SecureBuffSecClusGrpByNameIdxKey keyNameIdx = (SecureBuffSecClusGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		SecureBuffSecClusGrpByUNameIdxKey keyUNameIdx = (SecureBuffSecClusGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecClusGrpUNameIdx",
				"SecClusGrpUNameIdx",
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
						"Owner",
						"Owner",
						"SecClusGrpCluster",
						"SecClusGrpCluster",
						"Cluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecSysGrp().readDerivedByUNameIdx( Authorization,
						Buff.getRequiredName() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SecClusGrpRefSysGrp",
						"SecClusGrpRefSysGrp",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp > subdictClusterIdx;
		if( dictByClusterIdx.containsKey( keyClusterIdx ) ) {
			subdictClusterIdx = dictByClusterIdx.get( keyClusterIdx );
		}
		else {
			subdictClusterIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp >();
			dictByClusterIdx.put( keyClusterIdx, subdictClusterIdx );
		}
		subdictClusterIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp > subdictNameIdx;
		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			subdictNameIdx = dictByNameIdx.get( keyNameIdx );
		}
		else {
			subdictNameIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp >();
			dictByNameIdx.put( keyNameIdx, subdictNameIdx );
		}
		subdictNameIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecClusGrp.CLASS_CODE) {
				SecureBuffSecClusGrp retbuff = ((SecureBuffSecClusGrp)(schema.getSecureBuffFactory().getFactorySecClusGrp().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecClusGrp readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readDerived";
		ISecureSecClusGrp buff;
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
	public ISecureSecClusGrp lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecClusGrp.lockDerived";
		ISecureSecClusGrp buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusGrp[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecClusGrp.readAllDerived";
		ISecureSecClusGrp[] retList = new ISecureSecClusGrp[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecClusGrp > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecClusGrp[] readDerivedByClusterIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readDerivedByClusterIdx";
		SecureBuffSecClusGrpByClusterIdxKey key = (SecureBuffSecClusGrpByClusterIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByClusterIdxKey();

		key.setRequiredClusterId( ClusterId );
		ISecureSecClusGrp[] recArray;
		if( dictByClusterIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp > subdictClusterIdx
				= dictByClusterIdx.get( key );
			recArray = new ISecureSecClusGrp[ subdictClusterIdx.size() ];
			Iterator< SecureBuffSecClusGrp > iter = subdictClusterIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp > subdictClusterIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp >();
			dictByClusterIdx.put( key, subdictClusterIdx );
			recArray = new ISecureSecClusGrp[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecClusGrp[] readDerivedByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readDerivedByNameIdx";
		SecureBuffSecClusGrpByNameIdxKey key = (SecureBuffSecClusGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByNameIdxKey();

		key.setRequiredName( Name );
		ISecureSecClusGrp[] recArray;
		if( dictByNameIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp > subdictNameIdx
				= dictByNameIdx.get( key );
			recArray = new ISecureSecClusGrp[ subdictNameIdx.size() ];
			Iterator< SecureBuffSecClusGrp > iter = subdictNameIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp > subdictNameIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp >();
			dictByNameIdx.put( key, subdictNameIdx );
			recArray = new ISecureSecClusGrp[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecClusGrp readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClusterId,
		String Name )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readDerivedByUNameIdx";
		SecureBuffSecClusGrpByUNameIdxKey key = (SecureBuffSecClusGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByUNameIdxKey();

		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ISecureSecClusGrp buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusGrp readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusGrpId )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readDerivedByIdIdx() ";
		ISecureSecClusGrp buff;
		if( dictByPKey.containsKey( SecClusGrpId ) ) {
			buff = dictByPKey.get( SecClusGrpId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusGrp readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readRec";
		ISecureSecClusGrp buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecClusGrp.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusGrp lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecClusGrp buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecClusGrp.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusGrp[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readAllRec";
		ISecureSecClusGrp buff;
		ArrayList<ISecureSecClusGrp> filteredList = new ArrayList<ISecureSecClusGrp>();
		ISecureSecClusGrp[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecClusGrp.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecClusGrp[0] ) );
	}

	@Override
	public ISecureSecClusGrp readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusGrpId )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readRecByIdIdx() ";
		ISecureSecClusGrp buff = readDerivedByIdIdx( Authorization,
			SecClusGrpId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecClusGrp.CLASS_CODE ) ) {
			return( (ISecureSecClusGrp)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecClusGrp[] readRecByClusterIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readRecByClusterIdx() ";
		ISecureSecClusGrp buff;
		ArrayList<ISecureSecClusGrp> filteredList = new ArrayList<ISecureSecClusGrp>();
		ISecureSecClusGrp[] buffList = readDerivedByClusterIdx( Authorization,
			ClusterId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecClusGrp.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecClusGrp)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecClusGrp[0] ) );
	}

	@Override
	public ISecureSecClusGrp[] readRecByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readRecByNameIdx() ";
		ISecureSecClusGrp buff;
		ArrayList<ISecureSecClusGrp> filteredList = new ArrayList<ISecureSecClusGrp>();
		ISecureSecClusGrp[] buffList = readDerivedByNameIdx( Authorization,
			Name );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecClusGrp.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecClusGrp)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecClusGrp[0] ) );
	}

	@Override
	public ISecureSecClusGrp readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ClusterId,
		String Name )
	{
		final String S_ProcName = "SecureRamSecClusGrp.readRecByUNameIdx() ";
		ISecureSecClusGrp buff = readDerivedByUNameIdx( Authorization,
			ClusterId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecClusGrp.CLASS_CODE ) ) {
			return( (ISecureSecClusGrp)buff );
		}
		else {
			return( null );
		}
	}

	public ISecureSecClusGrp updateSecClusGrp( ISecureAuthorization Authorization,
		ISecureSecClusGrp iBuff )
	{
		SecureBuffSecClusGrp Buff = (SecureBuffSecClusGrp)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecClusGrp existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecClusGrp",
				"Existing record not found",
				"Existing record not found",
				"SecClusGrp",
				"SecClusGrp",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecClusGrp",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecClusGrpByClusterIdxKey existingKeyClusterIdx = (SecureBuffSecClusGrpByClusterIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByClusterIdxKey();
		existingKeyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		SecureBuffSecClusGrpByClusterIdxKey newKeyClusterIdx = (SecureBuffSecClusGrpByClusterIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByClusterIdxKey();
		newKeyClusterIdx.setRequiredClusterId( Buff.getRequiredClusterId() );

		SecureBuffSecClusGrpByNameIdxKey existingKeyNameIdx = (SecureBuffSecClusGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecClusGrpByNameIdxKey newKeyNameIdx = (SecureBuffSecClusGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		SecureBuffSecClusGrpByUNameIdxKey existingKeyUNameIdx = (SecureBuffSecClusGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecClusGrpByUNameIdxKey newKeyUNameIdx = (SecureBuffSecClusGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredClusterId( Buff.getRequiredClusterId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecClusGrp",
					"SecClusGrpUNameIdx",
					"SecClusGrpUNameIdx",
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
						"updateSecClusGrp",
						"Owner",
						"Owner",
						"SecClusGrpCluster",
						"SecClusGrpCluster",
						"Cluster",
						"Cluster",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecSysGrp().readDerivedByUNameIdx( Authorization,
						Buff.getRequiredName() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecClusGrp",
						"Container",
						"Container",
						"SecClusGrpRefSysGrp",
						"SecClusGrpRefSysGrp",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp > subdict;

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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp >();
			dictByClusterIdx.put( newKeyClusterIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNameIdx.get( existingKeyNameIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
			subdict = dictByNameIdx.get( newKeyNameIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp >();
			dictByNameIdx.put( newKeyNameIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecClusGrp( ISecureAuthorization Authorization,
		ISecureSecClusGrp iBuff )
	{
		final String S_ProcName = "SecureRamSecClusGrpTable.deleteSecClusGrp() ";
		SecureBuffSecClusGrp Buff = (SecureBuffSecClusGrp)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecClusGrp existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecClusGrp",
				pkey );
		}
					schema.getTableSecClusGrpMemb().deleteSecClusGrpMembByClusGrpIdx( Authorization,
						existing.getRequiredSecClusGrpId() );
		SecureBuffSecClusGrpByClusterIdxKey keyClusterIdx = (SecureBuffSecClusGrpByClusterIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		SecureBuffSecClusGrpByNameIdxKey keyNameIdx = (SecureBuffSecClusGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecClusGrpByUNameIdxKey keyUNameIdx = (SecureBuffSecClusGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecClusGrp > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusterIdx.get( keyClusterIdx );
		subdict.remove( pkey );

		subdict = dictByNameIdx.get( keyNameIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	@Override
	public void deleteSecClusGrpByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecClusGrp cur;
		LinkedList<SecureBuffSecClusGrp> matchSet = new LinkedList<SecureBuffSecClusGrp>();
		Iterator<SecureBuffSecClusGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecClusGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecClusGrp)(schema.getTableSecClusGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecClusGrpId() ));
			deleteSecClusGrp( Authorization, cur );
		}
	}

	@Override
	public void deleteSecClusGrpByClusterIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClusterId )
	{
		SecureBuffSecClusGrpByClusterIdxKey key = (SecureBuffSecClusGrpByClusterIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByClusterIdxKey();
		key.setRequiredClusterId( argClusterId );
		deleteSecClusGrpByClusterIdx( Authorization, key );
	}

	@Override
	public void deleteSecClusGrpByClusterIdx( ISecureAuthorization Authorization,
		ISecureSecClusGrpByClusterIdxKey argKey )
	{
		SecureBuffSecClusGrp cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecClusGrp> matchSet = new LinkedList<SecureBuffSecClusGrp>();
		Iterator<SecureBuffSecClusGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecClusGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecClusGrp)(schema.getTableSecClusGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecClusGrpId() ));
			deleteSecClusGrp( Authorization, cur );
		}
	}

	@Override
	public void deleteSecClusGrpByNameIdx( ISecureAuthorization Authorization,
		String argName )
	{
		SecureBuffSecClusGrpByNameIdxKey key = (SecureBuffSecClusGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByNameIdxKey();
		key.setRequiredName( argName );
		deleteSecClusGrpByNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecClusGrpByNameIdx( ISecureAuthorization Authorization,
		ISecureSecClusGrpByNameIdxKey argKey )
	{
		SecureBuffSecClusGrp cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecClusGrp> matchSet = new LinkedList<SecureBuffSecClusGrp>();
		Iterator<SecureBuffSecClusGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecClusGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecClusGrp)(schema.getTableSecClusGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecClusGrpId() ));
			deleteSecClusGrp( Authorization, cur );
		}
	}

	@Override
	public void deleteSecClusGrpByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argClusterId,
		String argName )
	{
		SecureBuffSecClusGrpByUNameIdxKey key = (SecureBuffSecClusGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecClusGrp().newByUNameIdxKey();
		key.setRequiredClusterId( argClusterId );
		key.setRequiredName( argName );
		deleteSecClusGrpByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecClusGrpByUNameIdx( ISecureAuthorization Authorization,
		ISecureSecClusGrpByUNameIdxKey argKey )
	{
		SecureBuffSecClusGrp cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecClusGrp> matchSet = new LinkedList<SecureBuffSecClusGrp>();
		Iterator<SecureBuffSecClusGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecClusGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecClusGrp)(schema.getTableSecClusGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecClusGrpId() ));
			deleteSecClusGrp( Authorization, cur );
		}
	}
}
