
// Description: Java 25 in-memory RAM DbIO implementation for SecSysRole.

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
 *	SecureRamSecSysRoleTable in-memory RAM DbIO implementation
 *	for SecSysRole.
 */
public class SecureRamSecSysRoleTable
	implements ISecureSecSysRoleTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecSysRole > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecSysRole >();
	private Map< SecureBuffSecSysRoleByUNameIdxKey,
			SecureBuffSecSysRole > dictByUNameIdx
		= new HashMap< SecureBuffSecSysRoleByUNameIdxKey,
			SecureBuffSecSysRole >();

	public SecureRamSecSysRoleTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecSysRole ensureRec(ISecureSecSysRole rec) {
		return (((SecureBuffSecSysRoleFactoryService)(schema.getSecureBuffFactory().getFactorySecSysRole())).ensureRec(rec));
	}

	@Override
	public ISecureSecSysRole createSecSysRole( ISecureAuthorization Authorization,
		ISecureSecSysRole iBuff )
	{
		final String S_ProcName = "createSecSysRole";
		
		SecureBuffSecSysRole Buff = (SecureBuffSecSysRole)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextSecSysGrpIdGen();
		Buff.setRequiredSecSysRoleId( pkey );
		SecureBuffSecSysRoleByUNameIdxKey keyUNameIdx = (SecureBuffSecSysRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRole().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecSysRoleUNameIdx",
				"SecSysRoleUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecSysRole.CLASS_CODE) {
				SecureBuffSecSysRole retbuff = ((SecureBuffSecSysRole)(schema.getSecureBuffFactory().getFactorySecSysRole().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecSysRole readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecSysRole.readDerived";
		ISecureSecSysRole buff;
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
	public ISecureSecSysRole lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecSysRole.lockDerived";
		ISecureSecSysRole buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRole[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecSysRole.readAllDerived";
		ISecureSecSysRole[] retList = new ISecureSecSysRole[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecSysRole > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecSysRole readDerivedByUNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecSysRole.readDerivedByUNameIdx";
		SecureBuffSecSysRoleByUNameIdxKey key = (SecureBuffSecSysRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRole().newByUNameIdxKey();

		key.setRequiredName( Name );
		ISecureSecSysRole buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRole readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "SecureRamSecSysRole.readDerivedByIdIdx() ";
		ISecureSecSysRole buff;
		if( dictByPKey.containsKey( SecSysRoleId ) ) {
			buff = dictByPKey.get( SecSysRoleId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRole readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecSysRole.readRec";
		ISecureSecSysRole buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysRole.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRole lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecSysRole buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysRole.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRole[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecSysRole.readAllRec";
		ISecureSecSysRole buff;
		ArrayList<ISecureSecSysRole> filteredList = new ArrayList<ISecureSecSysRole>();
		ISecureSecSysRole[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRole.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysRole[0] ) );
	}

	@Override
	public ISecureSecSysRole readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "SecureRamSecSysRole.readRecByIdIdx() ";
		ISecureSecSysRole buff = readDerivedByIdIdx( Authorization,
			SecSysRoleId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRole.CLASS_CODE ) ) {
			return( (ISecureSecSysRole)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecSysRole readRecByUNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecSysRole.readRecByUNameIdx() ";
		ISecureSecSysRole buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRole.CLASS_CODE ) ) {
			return( (ISecureSecSysRole)buff );
		}
		else {
			return( null );
		}
	}

	public ISecureSecSysRole updateSecSysRole( ISecureAuthorization Authorization,
		ISecureSecSysRole iBuff )
	{
		SecureBuffSecSysRole Buff = (SecureBuffSecSysRole)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecSysRole existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecSysRole",
				"Existing record not found",
				"Existing record not found",
				"SecSysRole",
				"SecSysRole",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecSysRole",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecSysRoleByUNameIdxKey existingKeyUNameIdx = (SecureBuffSecSysRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRole().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecSysRoleByUNameIdxKey newKeyUNameIdx = (SecureBuffSecSysRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRole().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecSysRole",
					"SecSysRoleUNameIdx",
					"SecSysRoleUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSysRole > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecSysRole( ISecureAuthorization Authorization,
		ISecureSecSysRole iBuff )
	{
		final String S_ProcName = "SecureRamSecSysRoleTable.deleteSecSysRole() ";
		SecureBuffSecSysRole Buff = (SecureBuffSecSysRole)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecSysRole existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecSysRole",
				pkey );
		}
					schema.getTableSecSysRoleMemb().deleteSecSysRoleMembBySysRoleIdx( Authorization,
						existing.getRequiredSecSysRoleId() );
					schema.getTableSecSysRoleEnables().deleteSecSysRoleEnablesBySysRoleIdx( Authorization,
						existing.getRequiredSecSysRoleId() );
		SecureBuffSecSysRoleByUNameIdxKey keyUNameIdx = (SecureBuffSecSysRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRole().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSysRole > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	@Override
	public void deleteSecSysRoleByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecSysRole cur;
		LinkedList<SecureBuffSecSysRole> matchSet = new LinkedList<SecureBuffSecSysRole>();
		Iterator<SecureBuffSecSysRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysRole)(schema.getTableSecSysRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysRoleId() ));
			deleteSecSysRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysRoleByUNameIdx( ISecureAuthorization Authorization,
		String argName )
	{
		SecureBuffSecSysRoleByUNameIdxKey key = (SecureBuffSecSysRoleByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRole().newByUNameIdxKey();
		key.setRequiredName( argName );
		deleteSecSysRoleByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysRoleByUNameIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleByUNameIdxKey argKey )
	{
		SecureBuffSecSysRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysRole> matchSet = new LinkedList<SecureBuffSecSysRole>();
		Iterator<SecureBuffSecSysRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysRole)(schema.getTableSecSysRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysRoleId() ));
			deleteSecSysRole( Authorization, cur );
		}
	}
}
