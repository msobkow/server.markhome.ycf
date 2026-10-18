
// Description: Java 25 in-memory RAM DbIO implementation for SecTentGrp.

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
 *	SecureRamSecTentGrpTable in-memory RAM DbIO implementation
 *	for SecTentGrp.
 */
public class SecureRamSecTentGrpTable
	implements ISecureSecTentGrpTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecTentGrp > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecTentGrp >();
	private Map< SecureBuffSecTentGrpByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecTentGrp >> dictByTenantIdx
		= new HashMap< SecureBuffSecTentGrpByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecTentGrp >>();
	private Map< SecureBuffSecTentGrpByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecTentGrp >> dictByNameIdx
		= new HashMap< SecureBuffSecTentGrpByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecTentGrp >>();
	private Map< SecureBuffSecTentGrpByUNameIdxKey,
			SecureBuffSecTentGrp > dictByUNameIdx
		= new HashMap< SecureBuffSecTentGrpByUNameIdxKey,
			SecureBuffSecTentGrp >();

	public SecureRamSecTentGrpTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecTentGrp ensureRec(ISecureSecTentGrp rec) {
		return (((SecureBuffSecTentGrpFactoryService)(schema.getSecureBuffFactory().getFactorySecTentGrp())).ensureRec(rec));
	}

	@Override
	public ISecureSecTentGrp createSecTentGrp( ISecureAuthorization Authorization,
		ISecureSecTentGrp iBuff )
	{
		final String S_ProcName = "createSecTentGrp";
		
		SecureBuffSecTentGrp Buff = (SecureBuffSecTentGrp)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextSecTentGrpIdGen();
		Buff.setRequiredSecTentGrpId( pkey );
		SecureBuffSecTentGrpByTenantIdxKey keyTenantIdx = (SecureBuffSecTentGrpByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		SecureBuffSecTentGrpByNameIdxKey keyNameIdx = (SecureBuffSecTentGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		SecureBuffSecTentGrpByUNameIdxKey keyUNameIdx = (SecureBuffSecTentGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecTentGrpUNameIdx",
				"SecTentGrpUNameIdx",
				keyUNameIdx );
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
						"SecTentGrpTenant",
						"SecTentGrpTenant",
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
				if( null == schema.getTableSecSysGrp().readDerivedByUNameIdx( Authorization,
						Buff.getRequiredName() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SecTentGrpRefSysGrp",
						"SecTentGrpRefSysGrp",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp > subdictNameIdx;
		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			subdictNameIdx = dictByNameIdx.get( keyNameIdx );
		}
		else {
			subdictNameIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp >();
			dictByNameIdx.put( keyNameIdx, subdictNameIdx );
		}
		subdictNameIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecTentGrp.CLASS_CODE) {
				SecureBuffSecTentGrp retbuff = ((SecureBuffSecTentGrp)(schema.getSecureBuffFactory().getFactorySecTentGrp().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecTentGrp readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readDerived";
		ISecureSecTentGrp buff;
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
	public ISecureSecTentGrp lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecTentGrp.lockDerived";
		ISecureSecTentGrp buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrp[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecTentGrp.readAllDerived";
		ISecureSecTentGrp[] retList = new ISecureSecTentGrp[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecTentGrp > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecTentGrp[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readDerivedByTenantIdx";
		SecureBuffSecTentGrpByTenantIdxKey key = (SecureBuffSecTentGrpByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByTenantIdxKey();

		key.setRequiredTenantId( TenantId );
		ISecureSecTentGrp[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new ISecureSecTentGrp[ subdictTenantIdx.size() ];
			Iterator< SecureBuffSecTentGrp > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp > subdictTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new ISecureSecTentGrp[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecTentGrp[] readDerivedByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readDerivedByNameIdx";
		SecureBuffSecTentGrpByNameIdxKey key = (SecureBuffSecTentGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByNameIdxKey();

		key.setRequiredName( Name );
		ISecureSecTentGrp[] recArray;
		if( dictByNameIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp > subdictNameIdx
				= dictByNameIdx.get( key );
			recArray = new ISecureSecTentGrp[ subdictNameIdx.size() ];
			Iterator< SecureBuffSecTentGrp > iter = subdictNameIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp > subdictNameIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp >();
			dictByNameIdx.put( key, subdictNameIdx );
			recArray = new ISecureSecTentGrp[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecTentGrp readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		String Name )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readDerivedByUNameIdx";
		SecureBuffSecTentGrpByUNameIdxKey key = (SecureBuffSecTentGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByUNameIdxKey();

		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ISecureSecTentGrp buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrp readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readDerivedByIdIdx() ";
		ISecureSecTentGrp buff;
		if( dictByPKey.containsKey( SecTentGrpId ) ) {
			buff = dictByPKey.get( SecTentGrpId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrp readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readRec";
		ISecureSecTentGrp buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecTentGrp.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrp lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecTentGrp buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecTentGrp.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrp[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readAllRec";
		ISecureSecTentGrp buff;
		ArrayList<ISecureSecTentGrp> filteredList = new ArrayList<ISecureSecTentGrp>();
		ISecureSecTentGrp[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentGrp.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentGrp[0] ) );
	}

	@Override
	public ISecureSecTentGrp readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readRecByIdIdx() ";
		ISecureSecTentGrp buff = readDerivedByIdIdx( Authorization,
			SecTentGrpId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentGrp.CLASS_CODE ) ) {
			return( (ISecureSecTentGrp)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecTentGrp[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readRecByTenantIdx() ";
		ISecureSecTentGrp buff;
		ArrayList<ISecureSecTentGrp> filteredList = new ArrayList<ISecureSecTentGrp>();
		ISecureSecTentGrp[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentGrp.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecTentGrp)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentGrp[0] ) );
	}

	@Override
	public ISecureSecTentGrp[] readRecByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readRecByNameIdx() ";
		ISecureSecTentGrp buff;
		ArrayList<ISecureSecTentGrp> filteredList = new ArrayList<ISecureSecTentGrp>();
		ISecureSecTentGrp[] buffList = readDerivedByNameIdx( Authorization,
			Name );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentGrp.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecTentGrp)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentGrp[0] ) );
	}

	@Override
	public ISecureSecTentGrp readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		String Name )
	{
		final String S_ProcName = "SecureRamSecTentGrp.readRecByUNameIdx() ";
		ISecureSecTentGrp buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentGrp.CLASS_CODE ) ) {
			return( (ISecureSecTentGrp)buff );
		}
		else {
			return( null );
		}
	}

	public ISecureSecTentGrp updateSecTentGrp( ISecureAuthorization Authorization,
		ISecureSecTentGrp iBuff )
	{
		SecureBuffSecTentGrp Buff = (SecureBuffSecTentGrp)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecTentGrp existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecTentGrp",
				"Existing record not found",
				"Existing record not found",
				"SecTentGrp",
				"SecTentGrp",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecTentGrp",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecTentGrpByTenantIdxKey existingKeyTenantIdx = (SecureBuffSecTentGrpByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		SecureBuffSecTentGrpByTenantIdxKey newKeyTenantIdx = (SecureBuffSecTentGrpByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		SecureBuffSecTentGrpByNameIdxKey existingKeyNameIdx = (SecureBuffSecTentGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecTentGrpByNameIdxKey newKeyNameIdx = (SecureBuffSecTentGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		SecureBuffSecTentGrpByUNameIdxKey existingKeyUNameIdx = (SecureBuffSecTentGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecTentGrpByUNameIdxKey newKeyUNameIdx = (SecureBuffSecTentGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecTentGrp",
					"SecTentGrpUNameIdx",
					"SecTentGrpUNameIdx",
					newKeyUNameIdx );
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
						"updateSecTentGrp",
						"Owner",
						"Owner",
						"SecTentGrpTenant",
						"SecTentGrpTenant",
						"Tenant",
						"Tenant",
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
						"updateSecTentGrp",
						"Container",
						"Container",
						"SecTentGrpRefSysGrp",
						"SecTentGrpRefSysGrp",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp > subdict;

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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp >();
			dictByTenantIdx.put( newKeyTenantIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp >();
			dictByNameIdx.put( newKeyNameIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecTentGrp( ISecureAuthorization Authorization,
		ISecureSecTentGrp iBuff )
	{
		final String S_ProcName = "SecureRamSecTentGrpTable.deleteSecTentGrp() ";
		SecureBuffSecTentGrp Buff = (SecureBuffSecTentGrp)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecTentGrp existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecTentGrp",
				pkey );
		}
					schema.getTableSecTentGrpMemb().deleteSecTentGrpMembByTentGrpIdx( Authorization,
						existing.getRequiredSecTentGrpId() );
		SecureBuffSecTentGrpByTenantIdxKey keyTenantIdx = (SecureBuffSecTentGrpByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		SecureBuffSecTentGrpByNameIdxKey keyNameIdx = (SecureBuffSecTentGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecTentGrpByUNameIdxKey keyUNameIdx = (SecureBuffSecTentGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentGrp > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByNameIdx.get( keyNameIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	@Override
	public void deleteSecTentGrpByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecTentGrp cur;
		LinkedList<SecureBuffSecTentGrp> matchSet = new LinkedList<SecureBuffSecTentGrp>();
		Iterator<SecureBuffSecTentGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentGrp)(schema.getTableSecTentGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentGrpId() ));
			deleteSecTentGrp( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentGrpByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		SecureBuffSecTentGrpByTenantIdxKey key = (SecureBuffSecTentGrpByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSecTentGrpByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentGrpByTenantIdx( ISecureAuthorization Authorization,
		ISecureSecTentGrpByTenantIdxKey argKey )
	{
		SecureBuffSecTentGrp cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentGrp> matchSet = new LinkedList<SecureBuffSecTentGrp>();
		Iterator<SecureBuffSecTentGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentGrp)(schema.getTableSecTentGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentGrpId() ));
			deleteSecTentGrp( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentGrpByNameIdx( ISecureAuthorization Authorization,
		String argName )
	{
		SecureBuffSecTentGrpByNameIdxKey key = (SecureBuffSecTentGrpByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByNameIdxKey();
		key.setRequiredName( argName );
		deleteSecTentGrpByNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentGrpByNameIdx( ISecureAuthorization Authorization,
		ISecureSecTentGrpByNameIdxKey argKey )
	{
		SecureBuffSecTentGrp cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentGrp> matchSet = new LinkedList<SecureBuffSecTentGrp>();
		Iterator<SecureBuffSecTentGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentGrp)(schema.getTableSecTentGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentGrpId() ));
			deleteSecTentGrp( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentGrpByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId,
		String argName )
	{
		SecureBuffSecTentGrpByUNameIdxKey key = (SecureBuffSecTentGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrp().newByUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredName( argName );
		deleteSecTentGrpByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentGrpByUNameIdx( ISecureAuthorization Authorization,
		ISecureSecTentGrpByUNameIdxKey argKey )
	{
		SecureBuffSecTentGrp cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentGrp> matchSet = new LinkedList<SecureBuffSecTentGrp>();
		Iterator<SecureBuffSecTentGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentGrp)(schema.getTableSecTentGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentGrpId() ));
			deleteSecTentGrp( Authorization, cur );
		}
	}
}
