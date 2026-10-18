
// Description: Java 25 in-memory RAM DbIO implementation for SecUserPWHistory.

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
 *	SecureRamSecUserPWHistoryTable in-memory RAM DbIO implementation
 *	for SecUserPWHistory.
 */
public class SecureRamSecUserPWHistoryTable
	implements ISecureSecUserPWHistoryTable
{
	private ISecureSchema schema;
	private Map< ISecureSecUserPWHistoryPKey,
				SecureBuffSecUserPWHistory > dictByPKey
		= new HashMap< ISecureSecUserPWHistoryPKey,
				SecureBuffSecUserPWHistory >();
	private Map< SecureBuffSecUserPWHistoryByUserIdxKey,
			SecureBuffSecUserPWHistory > dictByUserIdx
		= new HashMap< SecureBuffSecUserPWHistoryByUserIdxKey,
			SecureBuffSecUserPWHistory >();
	private Map< SecureBuffSecUserPWHistoryBySetStampIdxKey,
			SecureBuffSecUserPWHistory > dictBySetStampIdx
		= new HashMap< SecureBuffSecUserPWHistoryBySetStampIdxKey,
			SecureBuffSecUserPWHistory >();
	private Map< SecureBuffSecUserPWHistoryByReplacedStampIdxKey,
			SecureBuffSecUserPWHistory > dictByReplacedStampIdx
		= new HashMap< SecureBuffSecUserPWHistoryByReplacedStampIdxKey,
			SecureBuffSecUserPWHistory >();

	public SecureRamSecUserPWHistoryTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecUserPWHistory ensureRec(ISecureSecUserPWHistory rec) {
		return (((SecureBuffSecUserPWHistoryFactoryService)(schema.getSecureBuffFactory().getFactorySecUserPWHistory())).ensureRec(rec));
	}

	@Override
	public ISecureSecUserPWHistory createSecUserPWHistory( ISecureAuthorization Authorization,
		ISecureSecUserPWHistory iBuff )
	{
		final String S_ProcName = "createSecUserPWHistory";
		
		SecureBuffSecUserPWHistory Buff = (SecureBuffSecUserPWHistory)ensureRec(iBuff);
		SecureBuffSecUserPWHistoryPKey pkey = (SecureBuffSecUserPWHistoryPKey)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newPKey());
		pkey.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		pkey.setRequiredPWSetStamp( Buff.getRequiredPWSetStamp() );
		Buff.setRequiredSecUserId( pkey.getRequiredSecUserId() );
		Buff.setRequiredPWSetStamp( pkey.getRequiredPWSetStamp() );
		SecureBuffSecUserPWHistoryByUserIdxKey keyUserIdx = (SecureBuffSecUserPWHistoryByUserIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByUserIdxKey();
		keyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		SecureBuffSecUserPWHistoryBySetStampIdxKey keySetStampIdx = (SecureBuffSecUserPWHistoryBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
		keySetStampIdx.setRequiredPWSetStamp( Buff.getRequiredPWSetStamp() );

		SecureBuffSecUserPWHistoryByReplacedStampIdxKey keyReplacedStampIdx = (SecureBuffSecUserPWHistoryByReplacedStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
		keyReplacedStampIdx.setRequiredPWReplacedStamp( Buff.getRequiredPWReplacedStamp() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUserIdx.containsKey( keyUserIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecUserPWHistUserIdx",
				"SecUserPWHistUserIdx",
				keyUserIdx );
		}

		if( dictBySetStampIdx.containsKey( keySetStampIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecUserPWHistSetStampIdx",
				"SecUserPWHistSetStampIdx",
				keySetStampIdx );
		}

		if( dictByReplacedStampIdx.containsKey( keyReplacedStampIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecUserPWHistReplacedStampIdx",
				"SecUserPWHistReplacedStampIdx",
				keyReplacedStampIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUserIdx.put( keyUserIdx, Buff );

		dictBySetStampIdx.put( keySetStampIdx, Buff );

		dictByReplacedStampIdx.put( keyReplacedStampIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecUserPWHistory.CLASS_CODE) {
				SecureBuffSecUserPWHistory retbuff = ((SecureBuffSecUserPWHistory)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecUserPWHistory readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp )
	{
		{	$implCommaIJavaOptAtomType$ testSecUserId = SecUserId;
			if (testSecUserId == null) {
				return( null );
			}
		}
		{	$implCommaIJavaOptAtomType$ testPWSetStamp = PWSetStamp;
			if (testPWSetStamp == null) {
				return( null );
			}
		}
		SecureBuffSecUserPWHistoryPKey key = (SecureBuffSecUserPWHistoryPKey)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newPKey());
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredPWSetStamp( PWSetStamp );
		return( readDerived( Authorization, key ) );
	}

	public ISecureSecUserPWHistory readDerived( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey PKey )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readDerived";
		SecureBuffSecUserPWHistoryPKey key = (SecureBuffSecUserPWHistoryPKey)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newPKey());
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		key.setRequiredPWSetStamp( PKey.getRequiredPWSetStamp() );
		ISecureSecUserPWHistory buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWHistory lockDerived( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey PKey )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.lockDerived";
		SecureBuffSecUserPWHistoryPKey key = (SecureBuffSecUserPWHistoryPKey)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newPKey());
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		key.setRequiredPWSetStamp( PKey.getRequiredPWSetStamp() );
		ISecureSecUserPWHistory buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWHistory[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecUserPWHistory.readAllDerived";
		ISecureSecUserPWHistory[] retList = new ISecureSecUserPWHistory[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecUserPWHistory > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecUserPWHistory readDerivedByUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readDerivedByUserIdx";
		SecureBuffSecUserPWHistoryByUserIdxKey key = (SecureBuffSecUserPWHistoryByUserIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByUserIdxKey();

		key.setRequiredSecUserId( SecUserId );
		ISecureSecUserPWHistory buff;
		if( dictByUserIdx.containsKey( key ) ) {
			buff = dictByUserIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWHistory readDerivedBySetStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWSetStamp )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readDerivedBySetStampIdx";
		SecureBuffSecUserPWHistoryBySetStampIdxKey key = (SecureBuffSecUserPWHistoryBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();

		key.setRequiredPWSetStamp( PWSetStamp );
		ISecureSecUserPWHistory buff;
		if( dictBySetStampIdx.containsKey( key ) ) {
			buff = dictBySetStampIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWHistory readDerivedByReplacedStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWReplacedStamp )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readDerivedByReplacedStampIdx";
		SecureBuffSecUserPWHistoryByReplacedStampIdxKey key = (SecureBuffSecUserPWHistoryByReplacedStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();

		key.setRequiredPWReplacedStamp( PWReplacedStamp );
		ISecureSecUserPWHistory buff;
		if( dictByReplacedStampIdx.containsKey( key ) ) {
			buff = dictByReplacedStampIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWHistory readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readDerivedByIdIdx() ";
		SecureBuffSecUserPWHistoryPKey key = (SecureBuffSecUserPWHistoryPKey)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newPKey());
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredPWSetStamp( PWSetStamp );
		ISecureSecUserPWHistory buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWHistory readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp )
	{
		SecureBuffSecUserPWHistoryPKey key = (SecureBuffSecUserPWHistoryPKey)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newPKey());
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredPWSetStamp( PWSetStamp );
		return( readRec( Authorization, key ) );
	}

	@Override
	public ISecureSecUserPWHistory readRec( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey PKey )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readRec";
		ISecureSecUserPWHistory buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUserPWHistory.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWHistory lockRec( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecUserPWHistory buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUserPWHistory.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPWHistory[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readAllRec";
		ISecureSecUserPWHistory buff;
		ArrayList<ISecureSecUserPWHistory> filteredList = new ArrayList<ISecureSecUserPWHistory>();
		ISecureSecUserPWHistory[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWHistory.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserPWHistory[0] ) );
	}

	/**
	 *	Read a page of all the specific SecUserPWHistory buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUserPWHistory instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecUserPWHistory[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecUserId,
		LocalDateTime priorPWSetStamp )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecUserPWHistory readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readRecByIdIdx() ";
		ISecureSecUserPWHistory buff = readDerivedByIdIdx( Authorization,
			SecUserId,
			PWSetStamp );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWHistory.CLASS_CODE ) ) {
			return( (ISecureSecUserPWHistory)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUserPWHistory readRecByUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readRecByUserIdx() ";
		ISecureSecUserPWHistory buff = readDerivedByUserIdx( Authorization,
			SecUserId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWHistory.CLASS_CODE ) ) {
			return( (ISecureSecUserPWHistory)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUserPWHistory readRecBySetStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWSetStamp )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readRecBySetStampIdx() ";
		ISecureSecUserPWHistory buff = readDerivedBySetStampIdx( Authorization,
			PWSetStamp );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWHistory.CLASS_CODE ) ) {
			return( (ISecureSecUserPWHistory)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUserPWHistory readRecByReplacedStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWReplacedStamp )
	{
		final String S_ProcName = "SecureRamSecUserPWHistory.readRecByReplacedStampIdx() ";
		ISecureSecUserPWHistory buff = readDerivedByReplacedStampIdx( Authorization,
			PWReplacedStamp );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPWHistory.CLASS_CODE ) ) {
			return( (ISecureSecUserPWHistory)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUserPWHistory updateSecUserPWHistory( ISecureAuthorization Authorization,
		ISecureSecUserPWHistory iBuff )
	{
		SecureBuffSecUserPWHistory Buff = (SecureBuffSecUserPWHistory)ensureRec(iBuff);
		SecureBuffSecUserPWHistoryPKey pkey = (SecureBuffSecUserPWHistoryPKey)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newPKey());
		pkey = (SecureBuffSecUserPWHistoryPKey)Buff.getPKey();
		SecureBuffSecUserPWHistory existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecUserPWHistory",
				"Existing record not found",
				"Existing record not found",
				"SecUserPWHistory",
				"SecUserPWHistory",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecUserPWHistory",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecUserPWHistoryByUserIdxKey existingKeyUserIdx = (SecureBuffSecUserPWHistoryByUserIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByUserIdxKey();
		existingKeyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		SecureBuffSecUserPWHistoryByUserIdxKey newKeyUserIdx = (SecureBuffSecUserPWHistoryByUserIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByUserIdxKey();
		newKeyUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		SecureBuffSecUserPWHistoryBySetStampIdxKey existingKeySetStampIdx = (SecureBuffSecUserPWHistoryBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
		existingKeySetStampIdx.setRequiredPWSetStamp( existing.getRequiredPWSetStamp() );

		SecureBuffSecUserPWHistoryBySetStampIdxKey newKeySetStampIdx = (SecureBuffSecUserPWHistoryBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
		newKeySetStampIdx.setRequiredPWSetStamp( Buff.getRequiredPWSetStamp() );

		SecureBuffSecUserPWHistoryByReplacedStampIdxKey existingKeyReplacedStampIdx = (SecureBuffSecUserPWHistoryByReplacedStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
		existingKeyReplacedStampIdx.setRequiredPWReplacedStamp( existing.getRequiredPWReplacedStamp() );

		SecureBuffSecUserPWHistoryByReplacedStampIdxKey newKeyReplacedStampIdx = (SecureBuffSecUserPWHistoryByReplacedStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
		newKeyReplacedStampIdx.setRequiredPWReplacedStamp( Buff.getRequiredPWReplacedStamp() );

		// Check unique indexes

		if( ! existingKeyUserIdx.equals( newKeyUserIdx ) ) {
			if( dictByUserIdx.containsKey( newKeyUserIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecUserPWHistory",
					"SecUserPWHistUserIdx",
					"SecUserPWHistUserIdx",
					newKeyUserIdx );
			}
		}

		if( ! existingKeySetStampIdx.equals( newKeySetStampIdx ) ) {
			if( dictBySetStampIdx.containsKey( newKeySetStampIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecUserPWHistory",
					"SecUserPWHistSetStampIdx",
					"SecUserPWHistSetStampIdx",
					newKeySetStampIdx );
			}
		}

		if( ! existingKeyReplacedStampIdx.equals( newKeyReplacedStampIdx ) ) {
			if( dictByReplacedStampIdx.containsKey( newKeyReplacedStampIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecUserPWHistory",
					"SecUserPWHistReplacedStampIdx",
					"SecUserPWHistReplacedStampIdx",
					newKeyReplacedStampIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< SecureBuffSecUserPWHistoryPKey, SecureBuffSecUserPWHistory > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUserIdx.remove( existingKeyUserIdx );
		dictByUserIdx.put( newKeyUserIdx, Buff );

		dictBySetStampIdx.remove( existingKeySetStampIdx );
		dictBySetStampIdx.put( newKeySetStampIdx, Buff );

		dictByReplacedStampIdx.remove( existingKeyReplacedStampIdx );
		dictByReplacedStampIdx.put( newKeyReplacedStampIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecUserPWHistory( ISecureAuthorization Authorization,
		ISecureSecUserPWHistory iBuff )
	{
		final String S_ProcName = "SecureRamSecUserPWHistoryTable.deleteSecUserPWHistory() ";
		SecureBuffSecUserPWHistory Buff = (SecureBuffSecUserPWHistory)ensureRec(iBuff);
		int classCode;
		SecureBuffSecUserPWHistoryPKey pkey = (SecureBuffSecUserPWHistoryPKey)(Buff.getPKey());
		SecureBuffSecUserPWHistory existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecUserPWHistory",
				pkey );
		}
		SecureBuffSecUserPWHistoryByUserIdxKey keyUserIdx = (SecureBuffSecUserPWHistoryByUserIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByUserIdxKey();
		keyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		SecureBuffSecUserPWHistoryBySetStampIdxKey keySetStampIdx = (SecureBuffSecUserPWHistoryBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
		keySetStampIdx.setRequiredPWSetStamp( existing.getRequiredPWSetStamp() );

		SecureBuffSecUserPWHistoryByReplacedStampIdxKey keyReplacedStampIdx = (SecureBuffSecUserPWHistoryByReplacedStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
		keyReplacedStampIdx.setRequiredPWReplacedStamp( existing.getRequiredPWReplacedStamp() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< SecureBuffSecUserPWHistoryPKey, SecureBuffSecUserPWHistory > subdict;

		dictByPKey.remove( pkey );

		dictByUserIdx.remove( keyUserIdx );

		dictBySetStampIdx.remove( keySetStampIdx );

		dictByReplacedStampIdx.remove( keyReplacedStampIdx );

	}
	@Override
	public void deleteSecUserPWHistoryByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp )
	{
		SecureBuffSecUserPWHistoryPKey key = (SecureBuffSecUserPWHistoryPKey)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newPKey());
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredPWSetStamp( PWSetStamp );
		deleteSecUserPWHistoryByIdIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserPWHistoryByIdIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryPKey PKey )
	{
		SecureBuffSecUserPWHistoryPKey key = (SecureBuffSecUserPWHistoryPKey)(schema.getSecureBuffFactory().getFactorySecUserPWHistory().newPKey());
		key.setRequiredSecUserId( PKey.getRequiredSecUserId() );
		key.setRequiredPWSetStamp( PKey.getRequiredPWSetStamp() );
		SecureBuffSecUserPWHistoryPKey argKey = key;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecUserPWHistory cur;
		LinkedList<SecureBuffSecUserPWHistory> matchSet = new LinkedList<SecureBuffSecUserPWHistory>();
		Iterator<SecureBuffSecUserPWHistory> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPWHistory> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPWHistory)(schema.getTableSecUserPWHistory().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId(),
				cur.getRequiredPWSetStamp() ));
			deleteSecUserPWHistory( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserPWHistoryByUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecUserId )
	{
		SecureBuffSecUserPWHistoryByUserIdxKey key = (SecureBuffSecUserPWHistoryByUserIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecUserPWHistoryByUserIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserPWHistoryByUserIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryByUserIdxKey argKey )
	{
		SecureBuffSecUserPWHistory cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserPWHistory> matchSet = new LinkedList<SecureBuffSecUserPWHistory>();
		Iterator<SecureBuffSecUserPWHistory> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPWHistory> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPWHistory)(schema.getTableSecUserPWHistory().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId(),
				cur.getRequiredPWSetStamp() ));
			deleteSecUserPWHistory( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserPWHistoryBySetStampIdx( ISecureAuthorization Authorization,
		LocalDateTime argPWSetStamp )
	{
		SecureBuffSecUserPWHistoryBySetStampIdxKey key = (SecureBuffSecUserPWHistoryBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
		key.setRequiredPWSetStamp( argPWSetStamp );
		deleteSecUserPWHistoryBySetStampIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserPWHistoryBySetStampIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryBySetStampIdxKey argKey )
	{
		SecureBuffSecUserPWHistory cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserPWHistory> matchSet = new LinkedList<SecureBuffSecUserPWHistory>();
		Iterator<SecureBuffSecUserPWHistory> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPWHistory> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPWHistory)(schema.getTableSecUserPWHistory().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId(),
				cur.getRequiredPWSetStamp() ));
			deleteSecUserPWHistory( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserPWHistoryByReplacedStampIdx( ISecureAuthorization Authorization,
		LocalDateTime argPWReplacedStamp )
	{
		SecureBuffSecUserPWHistoryByReplacedStampIdxKey key = (SecureBuffSecUserPWHistoryByReplacedStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
		key.setRequiredPWReplacedStamp( argPWReplacedStamp );
		deleteSecUserPWHistoryByReplacedStampIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserPWHistoryByReplacedStampIdx( ISecureAuthorization Authorization,
		ISecureSecUserPWHistoryByReplacedStampIdxKey argKey )
	{
		SecureBuffSecUserPWHistory cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserPWHistory> matchSet = new LinkedList<SecureBuffSecUserPWHistory>();
		Iterator<SecureBuffSecUserPWHistory> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPWHistory> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPWHistory)(schema.getTableSecUserPWHistory().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId(),
				cur.getRequiredPWSetStamp() ));
			deleteSecUserPWHistory( Authorization, cur );
		}
	}
}
