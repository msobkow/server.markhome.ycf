
// Description: Java 25 in-memory RAM DbIO implementation for SecUser.

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
 *	SecureRamSecUserTable in-memory RAM DbIO implementation
 *	for SecUser.
 */
public class SecureRamSecUserTable
	implements ISecureSecUserTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecUser > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecUser >();
	private Map< SecureBuffSecUserByULoginIdxKey,
			SecureBuffSecUser > dictByULoginIdx
		= new HashMap< SecureBuffSecUserByULoginIdxKey,
			SecureBuffSecUser >();
	private Map< SecureBuffSecUserByEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUser >> dictByEMAddrIdx
		= new HashMap< SecureBuffSecUserByEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUser >>();

	public SecureRamSecUserTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecUser ensureRec(ISecureSecUser rec) {
		return (((SecureBuffSecUserFactoryService)(schema.getSecureBuffFactory().getFactorySecUser())).ensureRec(rec));
	}

	@Override
	public ISecureSecUser createSecUser( ISecureAuthorization Authorization,
		ISecureSecUser iBuff )
	{
		final String S_ProcName = "createSecUser";
		
		SecureBuffSecUser Buff = (SecureBuffSecUser)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextSecUserIdGen();
		Buff.setRequiredSecUserId( pkey );
		SecureBuffSecUserByULoginIdxKey keyULoginIdx = (SecureBuffSecUserByULoginIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByULoginIdxKey();
		keyULoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		SecureBuffSecUserByEMAddrIdxKey keyEMAddrIdx = (SecureBuffSecUserByEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByEMAddrIdxKey();
		keyEMAddrIdx.setRequiredEMailAddress( Buff.getRequiredEMailAddress() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByULoginIdx.containsKey( keyULoginIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecUserLoginIdx",
				"SecUserLoginIdx",
				keyULoginIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByULoginIdx.put( keyULoginIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUser > subdictEMAddrIdx;
		if( dictByEMAddrIdx.containsKey( keyEMAddrIdx ) ) {
			subdictEMAddrIdx = dictByEMAddrIdx.get( keyEMAddrIdx );
		}
		else {
			subdictEMAddrIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUser >();
			dictByEMAddrIdx.put( keyEMAddrIdx, subdictEMAddrIdx );
		}
		subdictEMAddrIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecUser.CLASS_CODE) {
				SecureBuffSecUser retbuff = ((SecureBuffSecUser)(schema.getSecureBuffFactory().getFactorySecUser().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecUser readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUser.readDerived";
		ISecureSecUser buff;
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
	public ISecureSecUser lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUser.lockDerived";
		ISecureSecUser buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUser[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecUser.readAllDerived";
		ISecureSecUser[] retList = new ISecureSecUser[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecUser > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecUser readDerivedByULoginIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecUser.readDerivedByULoginIdx";
		SecureBuffSecUserByULoginIdxKey key = (SecureBuffSecUserByULoginIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByULoginIdxKey();

		key.setRequiredLoginId( LoginId );
		ISecureSecUser buff;
		if( dictByULoginIdx.containsKey( key ) ) {
			buff = dictByULoginIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUser[] readDerivedByEMAddrIdx( ISecureAuthorization Authorization,
		String EMailAddress )
	{
		final String S_ProcName = "SecureRamSecUser.readDerivedByEMAddrIdx";
		SecureBuffSecUserByEMAddrIdxKey key = (SecureBuffSecUserByEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByEMAddrIdxKey();

		key.setRequiredEMailAddress( EMailAddress );
		ISecureSecUser[] recArray;
		if( dictByEMAddrIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUser > subdictEMAddrIdx
				= dictByEMAddrIdx.get( key );
			recArray = new ISecureSecUser[ subdictEMAddrIdx.size() ];
			Iterator< SecureBuffSecUser > iter = subdictEMAddrIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUser > subdictEMAddrIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUser >();
			dictByEMAddrIdx.put( key, subdictEMAddrIdx );
			recArray = new ISecureSecUser[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecUser readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUser.readDerivedByIdIdx() ";
		ISecureSecUser buff;
		if( dictByPKey.containsKey( SecUserId ) ) {
			buff = dictByPKey.get( SecUserId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUser readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUser.readRec";
		ISecureSecUser buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUser.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUser lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecUser buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUser.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUser[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecUser.readAllRec";
		ISecureSecUser buff;
		ArrayList<ISecureSecUser> filteredList = new ArrayList<ISecureSecUser>();
		ISecureSecUser[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUser.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUser[0] ) );
	}

	/**
	 *	Read a page of all the specific SecUser buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUser instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecUser[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecUser readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUser.readRecByIdIdx() ";
		ISecureSecUser buff = readDerivedByIdIdx( Authorization,
			SecUserId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUser.CLASS_CODE ) ) {
			return( (ISecureSecUser)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUser readRecByULoginIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecUser.readRecByULoginIdx() ";
		ISecureSecUser buff = readDerivedByULoginIdx( Authorization,
			LoginId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUser.CLASS_CODE ) ) {
			return( (ISecureSecUser)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUser[] readRecByEMAddrIdx( ISecureAuthorization Authorization,
		String EMailAddress )
	{
		final String S_ProcName = "SecureRamSecUser.readRecByEMAddrIdx() ";
		ISecureSecUser buff;
		ArrayList<ISecureSecUser> filteredList = new ArrayList<ISecureSecUser>();
		ISecureSecUser[] buffList = readDerivedByEMAddrIdx( Authorization,
			EMailAddress );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUser.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecUser)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUser[0] ) );
	}

	/**
	 *	Read a page array of the specific SecUser buffer instances identified by the duplicate key EMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailAddress	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecUser[] pageRecByEMAddrIdx( ISecureAuthorization Authorization,
		String EMailAddress,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageRecByEMAddrIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	public ISecureSecUser updateSecUser( ISecureAuthorization Authorization,
		ISecureSecUser iBuff )
	{
		SecureBuffSecUser Buff = (SecureBuffSecUser)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecUser existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecUser",
				"Existing record not found",
				"Existing record not found",
				"SecUser",
				"SecUser",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecUser",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecUserByULoginIdxKey existingKeyULoginIdx = (SecureBuffSecUserByULoginIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByULoginIdxKey();
		existingKeyULoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		SecureBuffSecUserByULoginIdxKey newKeyULoginIdx = (SecureBuffSecUserByULoginIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByULoginIdxKey();
		newKeyULoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		SecureBuffSecUserByEMAddrIdxKey existingKeyEMAddrIdx = (SecureBuffSecUserByEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByEMAddrIdxKey();
		existingKeyEMAddrIdx.setRequiredEMailAddress( existing.getRequiredEMailAddress() );

		SecureBuffSecUserByEMAddrIdxKey newKeyEMAddrIdx = (SecureBuffSecUserByEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByEMAddrIdxKey();
		newKeyEMAddrIdx.setRequiredEMailAddress( Buff.getRequiredEMailAddress() );

		// Check unique indexes

		if( ! existingKeyULoginIdx.equals( newKeyULoginIdx ) ) {
			if( dictByULoginIdx.containsKey( newKeyULoginIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecUser",
					"SecUserLoginIdx",
					"SecUserLoginIdx",
					newKeyULoginIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUser > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByULoginIdx.remove( existingKeyULoginIdx );
		dictByULoginIdx.put( newKeyULoginIdx, Buff );

		subdict = dictByEMAddrIdx.get( existingKeyEMAddrIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByEMAddrIdx.containsKey( newKeyEMAddrIdx ) ) {
			subdict = dictByEMAddrIdx.get( newKeyEMAddrIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUser >();
			dictByEMAddrIdx.put( newKeyEMAddrIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecUser( ISecureAuthorization Authorization,
		ISecureSecUser iBuff )
	{
		final String S_ProcName = "SecureRamSecUserTable.deleteSecUser() ";
		SecureBuffSecUser Buff = (SecureBuffSecUser)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecUser existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecUser",
				pkey );
		}
					schema.getTableSecUserPassword().deleteSecUserPasswordByIdIdx( Authorization,
						existing.getRequiredSecUserId() );
					schema.getTableSecSysGrpMemb().deleteSecSysGrpMembByLoginIdx( Authorization,
						existing.getRequiredLoginId() );
					schema.getTableSecClusGrpMemb().deleteSecClusGrpMembByLoginIdx( Authorization,
						existing.getRequiredLoginId() );
					schema.getTableSecTentGrpMemb().deleteSecTentGrpMembByUserIdx( Authorization,
						existing.getRequiredLoginId() );
					schema.getTableSecUserPassword().deleteSecUserPasswordByIdIdx( Authorization,
						existing.getRequiredSecUserId() );
					schema.getTableSecUserPWReset().deleteSecUserPWResetByIdIdx( Authorization,
						existing.getRequiredSecUserId() );
					schema.getTableSecUserEMConf().deleteSecUserEMConfByIdIdx( Authorization,
						existing.getRequiredSecUserId() );
		SecureBuffSecUserByULoginIdxKey keyULoginIdx = (SecureBuffSecUserByULoginIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByULoginIdxKey();
		keyULoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		SecureBuffSecUserByEMAddrIdxKey keyEMAddrIdx = (SecureBuffSecUserByEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByEMAddrIdxKey();
		keyEMAddrIdx.setRequiredEMailAddress( existing.getRequiredEMailAddress() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUser > subdict;

		dictByPKey.remove( pkey );

		dictByULoginIdx.remove( keyULoginIdx );

		subdict = dictByEMAddrIdx.get( keyEMAddrIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecUserByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecUser cur;
		LinkedList<SecureBuffSecUser> matchSet = new LinkedList<SecureBuffSecUser>();
		Iterator<SecureBuffSecUser> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUser> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUser)(schema.getTableSecUser().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUser( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserByULoginIdx( ISecureAuthorization Authorization,
		String argLoginId )
	{
		SecureBuffSecUserByULoginIdxKey key = (SecureBuffSecUserByULoginIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByULoginIdxKey();
		key.setRequiredLoginId( argLoginId );
		deleteSecUserByULoginIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserByULoginIdx( ISecureAuthorization Authorization,
		ISecureSecUserByULoginIdxKey argKey )
	{
		SecureBuffSecUser cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUser> matchSet = new LinkedList<SecureBuffSecUser>();
		Iterator<SecureBuffSecUser> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUser> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUser)(schema.getTableSecUser().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUser( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserByEMAddrIdx( ISecureAuthorization Authorization,
		String argEMailAddress )
	{
		SecureBuffSecUserByEMAddrIdxKey key = (SecureBuffSecUserByEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUser().newByEMAddrIdxKey();
		key.setRequiredEMailAddress( argEMailAddress );
		deleteSecUserByEMAddrIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserByEMAddrIdx( ISecureAuthorization Authorization,
		ISecureSecUserByEMAddrIdxKey argKey )
	{
		SecureBuffSecUser cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUser> matchSet = new LinkedList<SecureBuffSecUser>();
		Iterator<SecureBuffSecUser> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUser> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUser)(schema.getTableSecUser().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUser( Authorization, cur );
		}
	}
}
