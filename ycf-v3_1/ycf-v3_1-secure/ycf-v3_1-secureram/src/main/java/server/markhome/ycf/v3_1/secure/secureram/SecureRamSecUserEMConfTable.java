
// Description: Java 25 in-memory RAM DbIO implementation for SecUserEMConf.

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
 *	SecureRamSecUserEMConfTable in-memory RAM DbIO implementation
 *	for SecUserEMConf.
 */
public class SecureRamSecUserEMConfTable
	implements ISecureSecUserEMConfTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecUserEMConf > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecUserEMConf >();
	private Map< SecureBuffSecUserEMConfByUUuid6IdxKey,
			SecureBuffSecUserEMConf > dictByUUuid6Idx
		= new HashMap< SecureBuffSecUserEMConfByUUuid6IdxKey,
			SecureBuffSecUserEMConf >();
	private Map< SecureBuffSecUserEMConfByConfEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserEMConf >> dictByConfEMAddrIdx
		= new HashMap< SecureBuffSecUserEMConfByConfEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserEMConf >>();
	private Map< SecureBuffSecUserEMConfBySentStampIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserEMConf >> dictBySentStampIdx
		= new HashMap< SecureBuffSecUserEMConfBySentStampIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserEMConf >>();
	private Map< SecureBuffSecUserEMConfByNewAcctIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserEMConf >> dictByNewAcctIdx
		= new HashMap< SecureBuffSecUserEMConfByNewAcctIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserEMConf >>();

	public SecureRamSecUserEMConfTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecUserEMConf ensureRec(ISecureSecUserEMConf rec) {
		return (((SecureBuffSecUserEMConfFactoryService)(schema.getSecureBuffFactory().getFactorySecUserEMConf())).ensureRec(rec));
	}

	@Override
	public ISecureSecUserEMConf createSecUserEMConf( ISecureAuthorization Authorization,
		ISecureSecUserEMConf iBuff )
	{
		final String S_ProcName = "createSecUserEMConf";
		
		SecureBuffSecUserEMConf Buff = (SecureBuffSecUserEMConf)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = Buff.getRequiredSecUserId();
		pkey = Buff.getRequiredSecUserId();
		Buff.setRequiredContainerUser( pkey );
		Buff.setRequiredSecUserId( pkey );
		SecureBuffSecUserEMConfByUUuid6IdxKey keyUUuid6Idx = (SecureBuffSecUserEMConfByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
		keyUUuid6Idx.setRequiredEMConfirmationUuid6( Buff.getRequiredEMConfirmationUuid6() );

		SecureBuffSecUserEMConfByConfEMAddrIdxKey keyConfEMAddrIdx = (SecureBuffSecUserEMConfByConfEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		keyConfEMAddrIdx.setRequiredConfirmEMailAddr( Buff.getRequiredConfirmEMailAddr() );

		SecureBuffSecUserEMConfBySentStampIdxKey keySentStampIdx = (SecureBuffSecUserEMConfBySentStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		keySentStampIdx.setRequiredEMailSentStamp( Buff.getRequiredEMailSentStamp() );

		SecureBuffSecUserEMConfByNewAcctIdxKey keyNewAcctIdx = (SecureBuffSecUserEMConfByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		keyNewAcctIdx.setRequiredNewAccount( Buff.getRequiredNewAccount() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUUuid6Idx.containsKey( keyUUuid6Idx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecUserEMConfUuid6Idx",
				"SecUserEMConfUuid6Idx",
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

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdictConfEMAddrIdx;
		if( dictByConfEMAddrIdx.containsKey( keyConfEMAddrIdx ) ) {
			subdictConfEMAddrIdx = dictByConfEMAddrIdx.get( keyConfEMAddrIdx );
		}
		else {
			subdictConfEMAddrIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf >();
			dictByConfEMAddrIdx.put( keyConfEMAddrIdx, subdictConfEMAddrIdx );
		}
		subdictConfEMAddrIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdictSentStampIdx;
		if( dictBySentStampIdx.containsKey( keySentStampIdx ) ) {
			subdictSentStampIdx = dictBySentStampIdx.get( keySentStampIdx );
		}
		else {
			subdictSentStampIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf >();
			dictBySentStampIdx.put( keySentStampIdx, subdictSentStampIdx );
		}
		subdictSentStampIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdictNewAcctIdx;
		if( dictByNewAcctIdx.containsKey( keyNewAcctIdx ) ) {
			subdictNewAcctIdx = dictByNewAcctIdx.get( keyNewAcctIdx );
		}
		else {
			subdictNewAcctIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf >();
			dictByNewAcctIdx.put( keyNewAcctIdx, subdictNewAcctIdx );
		}
		subdictNewAcctIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecUserEMConf.CLASS_CODE) {
				SecureBuffSecUserEMConf retbuff = ((SecureBuffSecUserEMConf)(schema.getSecureBuffFactory().getFactorySecUserEMConf().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecUserEMConf readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readDerived";
		ISecureSecUserEMConf buff;
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
	public ISecureSecUserEMConf lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.lockDerived";
		ISecureSecUserEMConf buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserEMConf[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecUserEMConf.readAllDerived";
		ISecureSecUserEMConf[] retList = new ISecureSecUserEMConf[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecUserEMConf > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecUserEMConf readDerivedByUUuid6Idx( ISecureAuthorization Authorization,
		IYCFUuid6 EMConfirmationUuid6 )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readDerivedByUUuid6Idx";
		SecureBuffSecUserEMConfByUUuid6IdxKey key = (SecureBuffSecUserEMConfByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();

		key.setRequiredEMConfirmationUuid6( EMConfirmationUuid6 );
		ISecureSecUserEMConf buff;
		if( dictByUUuid6Idx.containsKey( key ) ) {
			buff = dictByUUuid6Idx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserEMConf[] readDerivedByConfEMAddrIdx( ISecureAuthorization Authorization,
		String ConfirmEMailAddr )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readDerivedByConfEMAddrIdx";
		SecureBuffSecUserEMConfByConfEMAddrIdxKey key = (SecureBuffSecUserEMConfByConfEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();

		key.setRequiredConfirmEMailAddr( ConfirmEMailAddr );
		ISecureSecUserEMConf[] recArray;
		if( dictByConfEMAddrIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdictConfEMAddrIdx
				= dictByConfEMAddrIdx.get( key );
			recArray = new ISecureSecUserEMConf[ subdictConfEMAddrIdx.size() ];
			Iterator< SecureBuffSecUserEMConf > iter = subdictConfEMAddrIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdictConfEMAddrIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf >();
			dictByConfEMAddrIdx.put( key, subdictConfEMAddrIdx );
			recArray = new ISecureSecUserEMConf[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecUserEMConf[] readDerivedBySentStampIdx( ISecureAuthorization Authorization,
		LocalDateTime EMailSentStamp )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readDerivedBySentStampIdx";
		SecureBuffSecUserEMConfBySentStampIdxKey key = (SecureBuffSecUserEMConfBySentStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newBySentStampIdxKey();

		key.setRequiredEMailSentStamp( EMailSentStamp );
		ISecureSecUserEMConf[] recArray;
		if( dictBySentStampIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdictSentStampIdx
				= dictBySentStampIdx.get( key );
			recArray = new ISecureSecUserEMConf[ subdictSentStampIdx.size() ];
			Iterator< SecureBuffSecUserEMConf > iter = subdictSentStampIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdictSentStampIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf >();
			dictBySentStampIdx.put( key, subdictSentStampIdx );
			recArray = new ISecureSecUserEMConf[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecUserEMConf[] readDerivedByNewAcctIdx( ISecureAuthorization Authorization,
		boolean NewAccount )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readDerivedByNewAcctIdx";
		SecureBuffSecUserEMConfByNewAcctIdxKey key = (SecureBuffSecUserEMConfByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();

		key.setRequiredNewAccount( NewAccount );
		ISecureSecUserEMConf[] recArray;
		if( dictByNewAcctIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdictNewAcctIdx
				= dictByNewAcctIdx.get( key );
			recArray = new ISecureSecUserEMConf[ subdictNewAcctIdx.size() ];
			Iterator< SecureBuffSecUserEMConf > iter = subdictNewAcctIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdictNewAcctIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf >();
			dictByNewAcctIdx.put( key, subdictNewAcctIdx );
			recArray = new ISecureSecUserEMConf[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecUserEMConf readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readDerivedByIdIdx() ";
		ISecureSecUserEMConf buff;
		if( dictByPKey.containsKey( SecUserId ) ) {
			buff = dictByPKey.get( SecUserId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserEMConf readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readRec";
		ISecureSecUserEMConf buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUserEMConf.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserEMConf lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecUserEMConf buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUserEMConf.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserEMConf[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readAllRec";
		ISecureSecUserEMConf buff;
		ArrayList<ISecureSecUserEMConf> filteredList = new ArrayList<ISecureSecUserEMConf>();
		ISecureSecUserEMConf[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserEMConf.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserEMConf[0] ) );
	}

	/**
	 *	Read a page of all the specific SecUserEMConf buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUserEMConf instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecUserEMConf[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecUserEMConf readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readRecByIdIdx() ";
		ISecureSecUserEMConf buff = readDerivedByIdIdx( Authorization,
			SecUserId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserEMConf.CLASS_CODE ) ) {
			return( (ISecureSecUserEMConf)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUserEMConf readRecByUUuid6Idx( ISecureAuthorization Authorization,
		IYCFUuid6 EMConfirmationUuid6 )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readRecByUUuid6Idx() ";
		ISecureSecUserEMConf buff = readDerivedByUUuid6Idx( Authorization,
			EMConfirmationUuid6 );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserEMConf.CLASS_CODE ) ) {
			return( (ISecureSecUserEMConf)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUserEMConf[] readRecByConfEMAddrIdx( ISecureAuthorization Authorization,
		String ConfirmEMailAddr )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readRecByConfEMAddrIdx() ";
		ISecureSecUserEMConf buff;
		ArrayList<ISecureSecUserEMConf> filteredList = new ArrayList<ISecureSecUserEMConf>();
		ISecureSecUserEMConf[] buffList = readDerivedByConfEMAddrIdx( Authorization,
			ConfirmEMailAddr );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserEMConf.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecUserEMConf)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserEMConf[0] ) );
	}

	@Override
	public ISecureSecUserEMConf[] readRecBySentStampIdx( ISecureAuthorization Authorization,
		LocalDateTime EMailSentStamp )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readRecBySentStampIdx() ";
		ISecureSecUserEMConf buff;
		ArrayList<ISecureSecUserEMConf> filteredList = new ArrayList<ISecureSecUserEMConf>();
		ISecureSecUserEMConf[] buffList = readDerivedBySentStampIdx( Authorization,
			EMailSentStamp );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserEMConf.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecUserEMConf)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserEMConf[0] ) );
	}

	@Override
	public ISecureSecUserEMConf[] readRecByNewAcctIdx( ISecureAuthorization Authorization,
		boolean NewAccount )
	{
		final String S_ProcName = "SecureRamSecUserEMConf.readRecByNewAcctIdx() ";
		ISecureSecUserEMConf buff;
		ArrayList<ISecureSecUserEMConf> filteredList = new ArrayList<ISecureSecUserEMConf>();
		ISecureSecUserEMConf[] buffList = readDerivedByNewAcctIdx( Authorization,
			NewAccount );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserEMConf.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecUserEMConf)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserEMConf[0] ) );
	}

	/**
	 *	Read a page array of the specific SecUserEMConf buffer instances identified by the duplicate key ConfEMAddrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ConfirmEMailAddr	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecUserEMConf[] pageRecByConfEMAddrIdx( ISecureAuthorization Authorization,
		String ConfirmEMailAddr,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageRecByConfEMAddrIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecUserEMConf buffer instances identified by the duplicate key SentStampIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailSentStamp	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecUserEMConf[] pageRecBySentStampIdx( ISecureAuthorization Authorization,
		LocalDateTime EMailSentStamp,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageRecBySentStampIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecUserEMConf buffer instances identified by the duplicate key NewAcctIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	NewAccount	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecUserEMConf[] pageRecByNewAcctIdx( ISecureAuthorization Authorization,
		boolean NewAccount,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageRecByNewAcctIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	public ISecureSecUserEMConf updateSecUserEMConf( ISecureAuthorization Authorization,
		ISecureSecUserEMConf iBuff )
	{
		SecureBuffSecUserEMConf Buff = (SecureBuffSecUserEMConf)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecUserEMConf existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecUserEMConf",
				"Existing record not found",
				"Existing record not found",
				"SecUserEMConf",
				"SecUserEMConf",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecUserEMConf",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecUserEMConfByUUuid6IdxKey existingKeyUUuid6Idx = (SecureBuffSecUserEMConfByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
		existingKeyUUuid6Idx.setRequiredEMConfirmationUuid6( existing.getRequiredEMConfirmationUuid6() );

		SecureBuffSecUserEMConfByUUuid6IdxKey newKeyUUuid6Idx = (SecureBuffSecUserEMConfByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
		newKeyUUuid6Idx.setRequiredEMConfirmationUuid6( Buff.getRequiredEMConfirmationUuid6() );

		SecureBuffSecUserEMConfByConfEMAddrIdxKey existingKeyConfEMAddrIdx = (SecureBuffSecUserEMConfByConfEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		existingKeyConfEMAddrIdx.setRequiredConfirmEMailAddr( existing.getRequiredConfirmEMailAddr() );

		SecureBuffSecUserEMConfByConfEMAddrIdxKey newKeyConfEMAddrIdx = (SecureBuffSecUserEMConfByConfEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		newKeyConfEMAddrIdx.setRequiredConfirmEMailAddr( Buff.getRequiredConfirmEMailAddr() );

		SecureBuffSecUserEMConfBySentStampIdxKey existingKeySentStampIdx = (SecureBuffSecUserEMConfBySentStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		existingKeySentStampIdx.setRequiredEMailSentStamp( existing.getRequiredEMailSentStamp() );

		SecureBuffSecUserEMConfBySentStampIdxKey newKeySentStampIdx = (SecureBuffSecUserEMConfBySentStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		newKeySentStampIdx.setRequiredEMailSentStamp( Buff.getRequiredEMailSentStamp() );

		SecureBuffSecUserEMConfByNewAcctIdxKey existingKeyNewAcctIdx = (SecureBuffSecUserEMConfByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		existingKeyNewAcctIdx.setRequiredNewAccount( existing.getRequiredNewAccount() );

		SecureBuffSecUserEMConfByNewAcctIdxKey newKeyNewAcctIdx = (SecureBuffSecUserEMConfByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		newKeyNewAcctIdx.setRequiredNewAccount( Buff.getRequiredNewAccount() );

		// Check unique indexes

		if( ! existingKeyUUuid6Idx.equals( newKeyUUuid6Idx ) ) {
			if( dictByUUuid6Idx.containsKey( newKeyUUuid6Idx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecUserEMConf",
					"SecUserEMConfUuid6Idx",
					"SecUserEMConfUuid6Idx",
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
						"updateSecUserEMConf",
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

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUUuid6Idx.remove( existingKeyUUuid6Idx );
		dictByUUuid6Idx.put( newKeyUUuid6Idx, Buff );

		subdict = dictByConfEMAddrIdx.get( existingKeyConfEMAddrIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByConfEMAddrIdx.containsKey( newKeyConfEMAddrIdx ) ) {
			subdict = dictByConfEMAddrIdx.get( newKeyConfEMAddrIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf >();
			dictByConfEMAddrIdx.put( newKeyConfEMAddrIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySentStampIdx.get( existingKeySentStampIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySentStampIdx.containsKey( newKeySentStampIdx ) ) {
			subdict = dictBySentStampIdx.get( newKeySentStampIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf >();
			dictBySentStampIdx.put( newKeySentStampIdx, subdict );
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
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf >();
			dictByNewAcctIdx.put( newKeyNewAcctIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecUserEMConf( ISecureAuthorization Authorization,
		ISecureSecUserEMConf iBuff )
	{
		final String S_ProcName = "SecureRamSecUserEMConfTable.deleteSecUserEMConf() ";
		SecureBuffSecUserEMConf Buff = (SecureBuffSecUserEMConf)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecUserEMConf existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecUserEMConf",
				pkey );
		}
		SecureBuffSecUserEMConfByUUuid6IdxKey keyUUuid6Idx = (SecureBuffSecUserEMConfByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
		keyUUuid6Idx.setRequiredEMConfirmationUuid6( existing.getRequiredEMConfirmationUuid6() );

		SecureBuffSecUserEMConfByConfEMAddrIdxKey keyConfEMAddrIdx = (SecureBuffSecUserEMConfByConfEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		keyConfEMAddrIdx.setRequiredConfirmEMailAddr( existing.getRequiredConfirmEMailAddr() );

		SecureBuffSecUserEMConfBySentStampIdxKey keySentStampIdx = (SecureBuffSecUserEMConfBySentStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		keySentStampIdx.setRequiredEMailSentStamp( existing.getRequiredEMailSentStamp() );

		SecureBuffSecUserEMConfByNewAcctIdxKey keyNewAcctIdx = (SecureBuffSecUserEMConfByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		keyNewAcctIdx.setRequiredNewAccount( existing.getRequiredNewAccount() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserEMConf > subdict;

		dictByPKey.remove( pkey );

		dictByUUuid6Idx.remove( keyUUuid6Idx );

		subdict = dictByConfEMAddrIdx.get( keyConfEMAddrIdx );
		subdict.remove( pkey );

		subdict = dictBySentStampIdx.get( keySentStampIdx );
		subdict.remove( pkey );

		subdict = dictByNewAcctIdx.get( keyNewAcctIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecUserEMConfByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecUserEMConf cur;
		LinkedList<SecureBuffSecUserEMConf> matchSet = new LinkedList<SecureBuffSecUserEMConf>();
		Iterator<SecureBuffSecUserEMConf> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserEMConf> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserEMConf)(schema.getTableSecUserEMConf().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserEMConf( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserEMConfByUUuid6Idx( ISecureAuthorization Authorization,
		IYCFUuid6 argEMConfirmationUuid6 )
	{
		SecureBuffSecUserEMConfByUUuid6IdxKey key = (SecureBuffSecUserEMConfByUUuid6IdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
		key.setRequiredEMConfirmationUuid6( argEMConfirmationUuid6 );
		deleteSecUserEMConfByUUuid6Idx( Authorization, key );
	}

	@Override
	public void deleteSecUserEMConfByUUuid6Idx( ISecureAuthorization Authorization,
		ISecureSecUserEMConfByUUuid6IdxKey argKey )
	{
		SecureBuffSecUserEMConf cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserEMConf> matchSet = new LinkedList<SecureBuffSecUserEMConf>();
		Iterator<SecureBuffSecUserEMConf> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserEMConf> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserEMConf)(schema.getTableSecUserEMConf().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserEMConf( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserEMConfByConfEMAddrIdx( ISecureAuthorization Authorization,
		String argConfirmEMailAddr )
	{
		SecureBuffSecUserEMConfByConfEMAddrIdxKey key = (SecureBuffSecUserEMConfByConfEMAddrIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		key.setRequiredConfirmEMailAddr( argConfirmEMailAddr );
		deleteSecUserEMConfByConfEMAddrIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserEMConfByConfEMAddrIdx( ISecureAuthorization Authorization,
		ISecureSecUserEMConfByConfEMAddrIdxKey argKey )
	{
		SecureBuffSecUserEMConf cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserEMConf> matchSet = new LinkedList<SecureBuffSecUserEMConf>();
		Iterator<SecureBuffSecUserEMConf> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserEMConf> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserEMConf)(schema.getTableSecUserEMConf().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserEMConf( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserEMConfBySentStampIdx( ISecureAuthorization Authorization,
		LocalDateTime argEMailSentStamp )
	{
		SecureBuffSecUserEMConfBySentStampIdxKey key = (SecureBuffSecUserEMConfBySentStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		key.setRequiredEMailSentStamp( argEMailSentStamp );
		deleteSecUserEMConfBySentStampIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserEMConfBySentStampIdx( ISecureAuthorization Authorization,
		ISecureSecUserEMConfBySentStampIdxKey argKey )
	{
		SecureBuffSecUserEMConf cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserEMConf> matchSet = new LinkedList<SecureBuffSecUserEMConf>();
		Iterator<SecureBuffSecUserEMConf> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserEMConf> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserEMConf)(schema.getTableSecUserEMConf().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserEMConf( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserEMConfByNewAcctIdx( ISecureAuthorization Authorization,
		boolean argNewAccount )
	{
		SecureBuffSecUserEMConfByNewAcctIdxKey key = (SecureBuffSecUserEMConfByNewAcctIdxKey)schema.getSecureBuffFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		key.setRequiredNewAccount( argNewAccount );
		deleteSecUserEMConfByNewAcctIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserEMConfByNewAcctIdx( ISecureAuthorization Authorization,
		ISecureSecUserEMConfByNewAcctIdxKey argKey )
	{
		SecureBuffSecUserEMConf cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserEMConf> matchSet = new LinkedList<SecureBuffSecUserEMConf>();
		Iterator<SecureBuffSecUserEMConf> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserEMConf> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserEMConf)(schema.getTableSecUserEMConf().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserEMConf( Authorization, cur );
		}
	}
}
