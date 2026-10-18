
// Description: Java 25 in-memory RAM DbIO implementation for SecUserPWReset.

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
 *	SecureRamSecUserPWResetTable in-memory RAM DbIO implementation
 *	for SecUserPWReset.
 */
public class SecureRamSecUserPWResetTable
	implements ISecureSecUserPWResetTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecUserPWReset > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecUserPWReset >();
	private Map< SecureBuffSecUserPWResetByUUuid6IdxKey,
			SecureBuffSecUserPWReset > dictByUUuid6Idx
		= new HashMap< SecureBuffSecUserPWResetByUUuid6IdxKey,
			SecureBuffSecUserPWReset >();
	private Map< SecureBuffSecUserPWResetBySentEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserPWReset >> dictBySentEMAddrIdx
		= new HashMap< SecureBuffSecUserPWResetBySentEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserPWReset >>();
	private Map< SecureBuffSecUserPWResetByNewAcctIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserPWReset >> dictByNewAcctIdx
		= new HashMap< SecureBuffSecUserPWResetByNewAcctIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserPWReset >>();

	public SecureRamSecUserPWResetTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecUserPWReset ensureRec(ISecureSecUserPWReset rec) {
		return (((SecureBuffSecUserPWResetFactoryService)(schema.getSecureBuffFactory().getFactorySecUserPWReset())).ensureRec(rec));
	}

	@Override
	public ISecureSecUserPWReset createSecUserPWReset( ISecureAuthorization Authorization,
		ISecureSecUserPWReset iBuff )
	{
		final String S_ProcName = "createSecUserPWReset";
		
		SecureBuffSecUserPWReset Buff = (SecureBuffSecUserPWReset)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = Buff.getRequiredSecUserId();
		pkey = Buff.getRequiredSecUserId();
		Buff.setRequiredContainerUser( pkey );
		Buff.setRequiredSecUserId( pkey );
		SecureBuffSecUserPWResetByUUuid6IdxKey keyUUuid6Idx = (SecureBuffSecUserPWResetByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
		keyUUuid6Idx.setRequiredPasswordResetUuid6( Buff.getRequiredPasswordResetUuid6() );

		SecureBuffSecUserPWResetBySentEMAddrIdxKey keySentEMAddrIdx = (SecureBuffSecUserPWResetBySentEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		keySentEMAddrIdx.setRequiredSentToEMailAddr( Buff.getRequiredSentToEMailAddr() );

		SecureBuffSecUserPWResetByNewAcctIdxKey keyNewAcctIdx = (SecureBuffSecUserPWResetByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		keyNewAcctIdx.setRequiredNewAccount( Buff.getRequiredNewAccount() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUUuid6Idx.containsKey( keyUUuid6Idx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecUserPWResetUuid6Idx",
				"SecUserPWResetUuid6Idx",
				keyUUuid6Idx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecUserId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SecUser",
						"SecUser",
						"SecUser",
						"SecUser",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUUuid6Idx.put( keyUUuid6Idx, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset > subdictSentEMAddrIdx;
		if( dictBySentEMAddrIdx.containsKey( keySentEMAddrIdx ) ) {
			subdictSentEMAddrIdx = dictBySentEMAddrIdx.get( keySentEMAddrIdx );
		}
		else {
			subdictSentEMAddrIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset >();
			dictBySentEMAddrIdx.put( keySentEMAddrIdx, subdictSentEMAddrIdx );
		}
		subdictSentEMAddrIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset > subdictNewAcctIdx;
		if( dictByNewAcctIdx.containsKey( keyNewAcctIdx ) ) {
			subdictNewAcctIdx = dictByNewAcctIdx.get( keyNewAcctIdx );
		}
		else {
			subdictNewAcctIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset >();
			dictByNewAcctIdx.put( keyNewAcctIdx, subdictNewAcctIdx );
		}
		subdictNewAcctIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecUserPWReset.CLASS_CODE) {
				SecureBuffSecUserPWReset retbuff = ((SecureBuffSecUserPWReset)(schema.getSecureBuffFactory().getFactorySecUserPWReset().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecUserPWReset readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readDerived";
		ISecureSecUserPWReset buff;
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
	public ISecureSecUserPWReset lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.lockDerived";
		ISecureSecUserPWReset buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWReset[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecUserPWReset.readAllDerived";
		ISecureSecUserPWReset[] retList = new ISecureSecUserPWReset[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecUserPWReset > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecUserPWReset readDerivedByUUuid6Idx( ISecureAuthorization Authorization,
		IYCFUuid6 PasswordResetUuid6 )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readDerivedByUUuid6Idx";
		SecureBuffSecUserPWResetByUUuid6IdxKey key = (SecureBuffSecUserPWResetByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();

		key.setRequiredPasswordResetUuid6( PasswordResetUuid6 );
		ISecureSecUserPWReset buff;
		if( dictByUUuid6Idx.containsKey( key ) ) {
			buff = dictByUUuid6Idx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWReset[] readDerivedBySentEMAddrIdx( ISecureAuthorization Authorization,
		String SentToEMailAddr )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readDerivedBySentEMAddrIdx";
		SecureBuffSecUserPWResetBySentEMAddrIdxKey key = (SecureBuffSecUserPWResetBySentEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();

		key.setRequiredSentToEMailAddr( SentToEMailAddr );
		ISecureSecUserPWReset[] recArray;
		if( dictBySentEMAddrIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset > subdictSentEMAddrIdx
				= dictBySentEMAddrIdx.get( key );
			recArray = new ISecureSecUserPWReset[ subdictSentEMAddrIdx.size() ];
			Iterator< SecureBuffSecUserPWReset > iter = subdictSentEMAddrIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset > subdictSentEMAddrIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset >();
			dictBySentEMAddrIdx.put( key, subdictSentEMAddrIdx );
			recArray = new ISecureSecUserPWReset[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecUserPWReset[] readDerivedByNewAcctIdx( ISecureAuthorization Authorization,
		boolean NewAccount )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readDerivedByNewAcctIdx";
		SecureBuffSecUserPWResetByNewAcctIdxKey key = (SecureBuffSecUserPWResetByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();

		key.setRequiredNewAccount( NewAccount );
		ISecureSecUserPWReset[] recArray;
		if( dictByNewAcctIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset > subdictNewAcctIdx
				= dictByNewAcctIdx.get( key );
			recArray = new ISecureSecUserPWReset[ subdictNewAcctIdx.size() ];
			Iterator< SecureBuffSecUserPWReset > iter = subdictNewAcctIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset > subdictNewAcctIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset >();
			dictByNewAcctIdx.put( key, subdictNewAcctIdx );
			recArray = new ISecureSecUserPWReset[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecUserPWReset readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readDerivedByIdIdx() ";
		ISecureSecUserPWReset buff;
		if( dictByPKey.containsKey( SecUserId ) ) {
			buff = dictByPKey.get( SecUserId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWReset readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readRec";
		ISecureSecUserPWReset buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUserPWReset.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWReset lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecUserPWReset buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUserPWReset.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWReset[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readAllRec";
		ISecureSecUserPWReset buff;
		ArrayList<ISecureSecUserPWReset> filteredList = new ArrayList<ISecureSecUserPWReset>();
		ISecureSecUserPWReset[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWReset.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserPWReset[0] ) );
	}

	/**
	 *	Read a page of all the specific SecUserPWReset buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUserPWReset instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecUserPWReset[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecUserPWReset readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readRecByIdIdx() ";
		ISecureSecUserPWReset buff = readDerivedByIdIdx( Authorization,
			SecUserId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWReset.CLASS_CODE ) ) {
			return( (ISecureSecUserPWReset)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUserPWReset readRecByUUuid6Idx( ISecureAuthorization Authorization,
		IYCFUuid6 PasswordResetUuid6 )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readRecByUUuid6Idx() ";
		ISecureSecUserPWReset buff = readDerivedByUUuid6Idx( Authorization,
			PasswordResetUuid6 );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWReset.CLASS_CODE ) ) {
			return( (ISecureSecUserPWReset)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUserPWReset[] readRecBySentEMAddrIdx( ISecureAuthorization Authorization,
		String SentToEMailAddr )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readRecBySentEMAddrIdx() ";
		ISecureSecUserPWReset buff;
		ArrayList<ISecureSecUserPWReset> filteredList = new ArrayList<ISecureSecUserPWReset>();
		ISecureSecUserPWReset[] buffList = readDerivedBySentEMAddrIdx( Authorization,
			SentToEMailAddr );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWReset.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecUserPWReset)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserPWReset[0] ) );
	}

	@Override
	public ISecureSecUserPWReset[] readRecByNewAcctIdx( ISecureAuthorization Authorization,
		boolean NewAccount )
	{
		final String S_ProcName = "SecureRamSecUserPWReset.readRecByNewAcctIdx() ";
		ISecureSecUserPWReset buff;
		ArrayList<ISecureSecUserPWReset> filteredList = new ArrayList<ISecureSecUserPWReset>();
		ISecureSecUserPWReset[] buffList = readDerivedByNewAcctIdx( Authorization,
			NewAccount );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWReset.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecUserPWReset)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserPWReset[0] ) );
	}

	/**
	 *	Read a page array of the specific SecUserPWReset buffer instances identified by the duplicate key SentEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SentToEMailAddr	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecUserPWReset[] pageRecBySentEMAddrIdx( ISecureAuthorization Authorization,
		String SentToEMailAddr,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageRecBySentEMAddrIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecUserPWReset buffer instances identified by the duplicate key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecUserPWReset[] pageRecByNewAcctIdx( ISecureAuthorization Authorization,
		boolean NewAccount,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageRecByNewAcctIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	public ISecureSecUserPWReset updateSecUserPWReset( ISecureAuthorization Authorization,
		ISecureSecUserPWReset iBuff )
	{
		SecureBuffSecUserPWReset Buff = (SecureBuffSecUserPWReset)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecUserPWReset existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecUserPWReset",
				"Existing record not found",
				"Existing record not found",
				"SecUserPWReset",
				"SecUserPWReset",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecUserPWReset",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecUserPWResetByUUuid6IdxKey existingKeyUUuid6Idx = (SecureBuffSecUserPWResetByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
		existingKeyUUuid6Idx.setRequiredPasswordResetUuid6( existing.getRequiredPasswordResetUuid6() );

		SecureBuffSecUserPWResetByUUuid6IdxKey newKeyUUuid6Idx = (SecureBuffSecUserPWResetByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
		newKeyUUuid6Idx.setRequiredPasswordResetUuid6( Buff.getRequiredPasswordResetUuid6() );

		SecureBuffSecUserPWResetBySentEMAddrIdxKey existingKeySentEMAddrIdx = (SecureBuffSecUserPWResetBySentEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		existingKeySentEMAddrIdx.setRequiredSentToEMailAddr( existing.getRequiredSentToEMailAddr() );

		SecureBuffSecUserPWResetBySentEMAddrIdxKey newKeySentEMAddrIdx = (SecureBuffSecUserPWResetBySentEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		newKeySentEMAddrIdx.setRequiredSentToEMailAddr( Buff.getRequiredSentToEMailAddr() );

		SecureBuffSecUserPWResetByNewAcctIdxKey existingKeyNewAcctIdx = (SecureBuffSecUserPWResetByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		existingKeyNewAcctIdx.setRequiredNewAccount( existing.getRequiredNewAccount() );

		SecureBuffSecUserPWResetByNewAcctIdxKey newKeyNewAcctIdx = (SecureBuffSecUserPWResetByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		newKeyNewAcctIdx.setRequiredNewAccount( Buff.getRequiredNewAccount() );

		// Check unique indexes

		if( ! existingKeyUUuid6Idx.equals( newKeyUUuid6Idx ) ) {
			if( dictByUUuid6Idx.containsKey( newKeyUUuid6Idx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecUserPWReset",
					"SecUserPWResetUuid6Idx",
					"SecUserPWResetUuid6Idx",
					newKeyUUuid6Idx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecUserId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecUserPWReset",
						"Container",
						"Container",
						"SecUser",
						"SecUser",
						"SecUser",
						"SecUser",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUUuid6Idx.remove( existingKeyUUuid6Idx );
		dictByUUuid6Idx.put( newKeyUUuid6Idx, Buff );

		subdict = dictBySentEMAddrIdx.get( existingKeySentEMAddrIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySentEMAddrIdx.containsKey( newKeySentEMAddrIdx ) ) {
			subdict = dictBySentEMAddrIdx.get( newKeySentEMAddrIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset >();
			dictBySentEMAddrIdx.put( newKeySentEMAddrIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNewAcctIdx.get( existingKeyNewAcctIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNewAcctIdx.containsKey( newKeyNewAcctIdx ) ) {
			subdict = dictByNewAcctIdx.get( newKeyNewAcctIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset >();
			dictByNewAcctIdx.put( newKeyNewAcctIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecUserPWReset( ISecureAuthorization Authorization,
		ISecureSecUserPWReset iBuff )
	{
		final String S_ProcName = "SecureRamSecUserPWResetTable.deleteSecUserPWReset() ";
		SecureBuffSecUserPWReset Buff = (SecureBuffSecUserPWReset)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecUserPWReset existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecUserPWReset",
				pkey );
		}
		SecureBuffSecUserPWResetByUUuid6IdxKey keyUUuid6Idx = (SecureBuffSecUserPWResetByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
		keyUUuid6Idx.setRequiredPasswordResetUuid6( existing.getRequiredPasswordResetUuid6() );

		SecureBuffSecUserPWResetBySentEMAddrIdxKey keySentEMAddrIdx = (SecureBuffSecUserPWResetBySentEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		keySentEMAddrIdx.setRequiredSentToEMailAddr( existing.getRequiredSentToEMailAddr() );

		SecureBuffSecUserPWResetByNewAcctIdxKey keyNewAcctIdx = (SecureBuffSecUserPWResetByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		keyNewAcctIdx.setRequiredNewAccount( existing.getRequiredNewAccount() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPWReset > subdict;

		dictByPKey.remove( pkey );

		dictByUUuid6Idx.remove( keyUUuid6Idx );

		subdict = dictBySentEMAddrIdx.get( keySentEMAddrIdx );
		subdict.remove( pkey );

		subdict = dictByNewAcctIdx.get( keyNewAcctIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecUserPWResetByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecUserPWReset cur;
		LinkedList<SecureBuffSecUserPWReset> matchSet = new LinkedList<SecureBuffSecUserPWReset>();
		Iterator<SecureBuffSecUserPWReset> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPWReset> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPWReset)(schema.getTableSecUserPWReset().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserPWReset( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserPWResetByUUuid6Idx( ISecureAuthorization Authorization,
		IYCFUuid6 argPasswordResetUuid6 )
	{
		SecureBuffSecUserPWResetByUUuid6IdxKey key = (SecureBuffSecUserPWResetByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
		key.setRequiredPasswordResetUuid6( argPasswordResetUuid6 );
		deleteSecUserPWResetByUUuid6Idx( Authorization, key );
	}

	@Override
	public void deleteSecUserPWResetByUUuid6Idx( ISecureAuthorization Authorization,
		ISecureSecUserPWResetByUUuid6IdxKey argKey )
	{
		SecureBuffSecUserPWReset cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserPWReset> matchSet = new LinkedList<SecureBuffSecUserPWReset>();
		Iterator<SecureBuffSecUserPWReset> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPWReset> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPWReset)(schema.getTableSecUserPWReset().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserPWReset( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserPWResetBySentEMAddrIdx( ISecureAuthorization Authorization,
		String argSentToEMailAddr )
	{
		SecureBuffSecUserPWResetBySentEMAddrIdxKey key = (SecureBuffSecUserPWResetBySentEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		key.setRequiredSentToEMailAddr( argSentToEMailAddr );
		deleteSecUserPWResetBySentEMAddrIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserPWResetBySentEMAddrIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWResetBySentEMAddrIdxKey argKey )
	{
		SecureBuffSecUserPWReset cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserPWReset> matchSet = new LinkedList<SecureBuffSecUserPWReset>();
		Iterator<SecureBuffSecUserPWReset> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPWReset> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPWReset)(schema.getTableSecUserPWReset().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserPWReset( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserPWResetByNewAcctIdx( ISecureAuthorization Authorization,
		boolean argNewAccount )
	{
		SecureBuffSecUserPWResetByNewAcctIdxKey key = (SecureBuffSecUserPWResetByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		key.setRequiredNewAccount( argNewAccount );
		deleteSecUserPWResetByNewAcctIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserPWResetByNewAcctIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWResetByNewAcctIdxKey argKey )
	{
		SecureBuffSecUserPWReset cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserPWReset> matchSet = new LinkedList<SecureBuffSecUserPWReset>();
		Iterator<SecureBuffSecUserPWReset> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPWReset> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPWReset)(schema.getTableSecUserPWReset().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserPWReset( Authorization, cur );
		}
	}
}
