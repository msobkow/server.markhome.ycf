
// Description: Java 25 in-memory RAM DbIO implementation for SecTentRole.

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
 *	SecureRamSecTentRoleTable in-memory RAM DbIO implementation
 *	for SecTentRole.
 */
public class SecureRamSecTentRoleTable
	implements ISecureSecTentRoleTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecTentRole > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecTentRole >();
	private Map< SecureBuffSecTentRoleByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecTentRole >> dictByTenantIdx
		= new HashMap< SecureBuffSecTentRoleByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecTentRole >>();
	private Map< SecureBuffSecTentRoleByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecTentRole >> dictByNameIdx
		= new HashMap< SecureBuffSecTentRoleByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecTentRole >>();
	private Map< SecureBuffSecTentRoleByUNameIdxKey,
			SecureBuffSecTentRole > dictByUNameIdx
		= new HashMap< SecureBuffSecTentRoleByUNameIdxKey,
			SecureBuffSecTentRole >();

	public SecureRamSecTentRoleTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecTentRole ensureRec(ISecureSecTentRole rec) {
		return (((SecureBuffSecTentRoleFactoryService)(schema.getSecureBuffFactory().getFactorySecTentRole())).ensureRec(rec));
	}

	@Override
	public ISecureSecTentRole createSecTentRole( ISecureAuthorization Authorization,
		ISecureSecTentRole iBuff )
	{
		final String S_ProcName = "createSecTentRole";
		
		SecureBuffSecTentRole Buff = (SecureBuffSecTentRole)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextSecTentRoleIdGen();
		Buff.setRequiredSecTentRoleId( pkey );
		SecureBuffSecTentRoleByTenantIdxKey keyTenantIdx = (SecureBuffSecTentRoleByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		SecureBuffSecTentRoleByNameIdxKey keyNameIdx = (SecureBuffSecTentRoleByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		SecureBuffSecTentRoleByUNameIdxKey keyUNameIdx = (SecureBuffSecTentRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecTentRoleUNameIdx",
				"SecTentRoleUNameIdx",
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
						"SecTentRoleTenant",
						"SecTentRoleTenant",
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
						"SecTentRoleSysRole",
						"SecTentRoleSysRole",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole > subdictTenantIdx;
		if( dictByTenantIdx.containsKey( keyTenantIdx ) ) {
			subdictTenantIdx = dictByTenantIdx.get( keyTenantIdx );
		}
		else {
			subdictTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole >();
			dictByTenantIdx.put( keyTenantIdx, subdictTenantIdx );
		}
		subdictTenantIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole > subdictNameIdx;
		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			subdictNameIdx = dictByNameIdx.get( keyNameIdx );
		}
		else {
			subdictNameIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole >();
			dictByNameIdx.put( keyNameIdx, subdictNameIdx );
		}
		subdictNameIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecTentRole.CLASS_CODE) {
				SecureBuffSecTentRole retbuff = ((SecureBuffSecTentRole)(schema.getSecureBuffFactory().getFactorySecTentRole().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecTentRole readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecTentRole.readDerived";
		ISecureSecTentRole buff;
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
	public ISecureSecTentRole lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecTentRole.lockDerived";
		ISecureSecTentRole buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRole[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecTentRole.readAllDerived";
		ISecureSecTentRole[] retList = new ISecureSecTentRole[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecTentRole > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecTentRole[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "SecureRamSecTentRole.readDerivedByTenantIdx";
		SecureBuffSecTentRoleByTenantIdxKey key = (SecureBuffSecTentRoleByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByTenantIdxKey();

		key.setRequiredTenantId( TenantId );
		ISecureSecTentRole[] recArray;
		if( dictByTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole > subdictTenantIdx
				= dictByTenantIdx.get( key );
			recArray = new ISecureSecTentRole[ subdictTenantIdx.size() ];
			Iterator< SecureBuffSecTentRole > iter = subdictTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole > subdictTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole >();
			dictByTenantIdx.put( key, subdictTenantIdx );
			recArray = new ISecureSecTentRole[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecTentRole[] readDerivedByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecTentRole.readDerivedByNameIdx";
		SecureBuffSecTentRoleByNameIdxKey key = (SecureBuffSecTentRoleByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByNameIdxKey();

		key.setRequiredName( Name );
		ISecureSecTentRole[] recArray;
		if( dictByNameIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole > subdictNameIdx
				= dictByNameIdx.get( key );
			recArray = new ISecureSecTentRole[ subdictNameIdx.size() ];
			Iterator< SecureBuffSecTentRole > iter = subdictNameIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole > subdictNameIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole >();
			dictByNameIdx.put( key, subdictNameIdx );
			recArray = new ISecureSecTentRole[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecTentRole readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		String Name )
	{
		final String S_ProcName = "SecureRamSecTentRole.readDerivedByUNameIdx";
		SecureBuffSecTentRoleByUNameIdxKey key = (SecureBuffSecTentRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByUNameIdxKey();

		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ISecureSecTentRole buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRole readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId )
	{
		final String S_ProcName = "SecureRamSecTentRole.readDerivedByIdIdx() ";
		ISecureSecTentRole buff;
		if( dictByPKey.containsKey( SecTentRoleId ) ) {
			buff = dictByPKey.get( SecTentRoleId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRole readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecTentRole.readRec";
		ISecureSecTentRole buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecTentRole.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRole lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecTentRole buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecTentRole.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRole[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecTentRole.readAllRec";
		ISecureSecTentRole buff;
		ArrayList<ISecureSecTentRole> filteredList = new ArrayList<ISecureSecTentRole>();
		ISecureSecTentRole[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentRole.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentRole[0] ) );
	}

	@Override
	public ISecureSecTentRole readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId )
	{
		final String S_ProcName = "SecureRamSecTentRole.readRecByIdIdx() ";
		ISecureSecTentRole buff = readDerivedByIdIdx( Authorization,
			SecTentRoleId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentRole.CLASS_CODE ) ) {
			return( (ISecureSecTentRole)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecTentRole[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "SecureRamSecTentRole.readRecByTenantIdx() ";
		ISecureSecTentRole buff;
		ArrayList<ISecureSecTentRole> filteredList = new ArrayList<ISecureSecTentRole>();
		ISecureSecTentRole[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentRole.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecTentRole)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentRole[0] ) );
	}

	@Override
	public ISecureSecTentRole[] readRecByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecTentRole.readRecByNameIdx() ";
		ISecureSecTentRole buff;
		ArrayList<ISecureSecTentRole> filteredList = new ArrayList<ISecureSecTentRole>();
		ISecureSecTentRole[] buffList = readDerivedByNameIdx( Authorization,
			Name );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentRole.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecTentRole)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentRole[0] ) );
	}

	@Override
	public ISecureSecTentRole readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId,
		String Name )
	{
		final String S_ProcName = "SecureRamSecTentRole.readRecByUNameIdx() ";
		ISecureSecTentRole buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentRole.CLASS_CODE ) ) {
			return( (ISecureSecTentRole)buff );
		}
		else {
			return( null );
		}
	}

	public ISecureSecTentRole updateSecTentRole( ISecureAuthorization Authorization,
		ISecureSecTentRole iBuff )
	{
		SecureBuffSecTentRole Buff = (SecureBuffSecTentRole)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecTentRole existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecTentRole",
				"Existing record not found",
				"Existing record not found",
				"SecTentRole",
				"SecTentRole",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecTentRole",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecTentRoleByTenantIdxKey existingKeyTenantIdx = (SecureBuffSecTentRoleByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByTenantIdxKey();
		existingKeyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		SecureBuffSecTentRoleByTenantIdxKey newKeyTenantIdx = (SecureBuffSecTentRoleByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByTenantIdxKey();
		newKeyTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		SecureBuffSecTentRoleByNameIdxKey existingKeyNameIdx = (SecureBuffSecTentRoleByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecTentRoleByNameIdxKey newKeyNameIdx = (SecureBuffSecTentRoleByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		SecureBuffSecTentRoleByUNameIdxKey existingKeyUNameIdx = (SecureBuffSecTentRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecTentRoleByUNameIdxKey newKeyUNameIdx = (SecureBuffSecTentRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecTentRole",
					"SecTentRoleUNameIdx",
					"SecTentRoleUNameIdx",
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
						"updateSecTentRole",
						"Owner",
						"Owner",
						"SecTentRoleTenant",
						"SecTentRoleTenant",
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
						"updateSecTentRole",
						"Container",
						"Container",
						"SecTentRoleSysRole",
						"SecTentRoleSysRole",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole > subdict;

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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole >();
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole >();
			dictByNameIdx.put( newKeyNameIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecTentRole( ISecureAuthorization Authorization,
		ISecureSecTentRole iBuff )
	{
		final String S_ProcName = "SecureRamSecTentRoleTable.deleteSecTentRole() ";
		SecureBuffSecTentRole Buff = (SecureBuffSecTentRole)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecTentRole existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecTentRole",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckSecTentRoleMembByRole[] = schema.getTableSecTentRoleMemb().readDerivedByTentRoleIdx( Authorization,
						existing.getRequiredSecTentRoleId() );
		if( arrCheckSecTentRoleMembByRole.length > 0 ) {
			schema.getTableSecTentRoleMemb().deleteSecTentRoleMembByTentRoleIdx( Authorization,
						existing.getRequiredSecTentRoleId() );
		}
		SecureBuffSecTentRoleByTenantIdxKey keyTenantIdx = (SecureBuffSecTentRoleByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		SecureBuffSecTentRoleByNameIdxKey keyNameIdx = (SecureBuffSecTentRoleByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecTentRoleByUNameIdxKey keyUNameIdx = (SecureBuffSecTentRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecTentRole > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTenantIdx.get( keyTenantIdx );
		subdict.remove( pkey );

		subdict = dictByNameIdx.get( keyNameIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	@Override
	public void deleteSecTentRoleByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecTentRole cur;
		LinkedList<SecureBuffSecTentRole> matchSet = new LinkedList<SecureBuffSecTentRole>();
		Iterator<SecureBuffSecTentRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentRole)(schema.getTableSecTentRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentRoleId() ));
			deleteSecTentRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentRoleByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		SecureBuffSecTentRoleByTenantIdxKey key = (SecureBuffSecTentRoleByTenantIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSecTentRoleByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentRoleByTenantIdx( ISecureAuthorization Authorization,
		ISecureSecTentRoleByTenantIdxKey argKey )
	{
		SecureBuffSecTentRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentRole> matchSet = new LinkedList<SecureBuffSecTentRole>();
		Iterator<SecureBuffSecTentRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentRole)(schema.getTableSecTentRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentRoleId() ));
			deleteSecTentRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentRoleByNameIdx( ISecureAuthorization Authorization,
		String argName )
	{
		SecureBuffSecTentRoleByNameIdxKey key = (SecureBuffSecTentRoleByNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByNameIdxKey();
		key.setRequiredName( argName );
		deleteSecTentRoleByNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentRoleByNameIdx( ISecureAuthorization Authorization,
		ISecureSecTentRoleByNameIdxKey argKey )
	{
		SecureBuffSecTentRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentRole> matchSet = new LinkedList<SecureBuffSecTentRole>();
		Iterator<SecureBuffSecTentRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentRole)(schema.getTableSecTentRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentRoleId() ));
			deleteSecTentRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentRoleByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId,
		String argName )
	{
		SecureBuffSecTentRoleByUNameIdxKey key = (SecureBuffSecTentRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecTentRole().newByUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredName( argName );
		deleteSecTentRoleByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentRoleByUNameIdx( ISecureAuthorization Authorization,
		ISecureSecTentRoleByUNameIdxKey argKey )
	{
		SecureBuffSecTentRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentRole> matchSet = new LinkedList<SecureBuffSecTentRole>();
		Iterator<SecureBuffSecTentRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentRole)(schema.getTableSecTentRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentRoleId() ));
			deleteSecTentRole( Authorization, cur );
		}
	}
}
