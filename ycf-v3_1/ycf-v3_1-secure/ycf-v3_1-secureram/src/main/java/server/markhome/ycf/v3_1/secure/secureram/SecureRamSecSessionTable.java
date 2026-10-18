
// Description: Java 25 in-memory RAM DbIO implementation for SecSession.

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
 *	SecureRamSecSessionTable in-memory RAM DbIO implementation
 *	for SecSession.
 */
public class SecureRamSecSessionTable
	implements ISecureSecSessionTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecSession > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecSession >();
	private Map< SecureBuffSecSessionBySecUserIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecSession >> dictBySecUserIdx
		= new HashMap< SecureBuffSecSessionBySecUserIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecSession >>();
	private Map< SecureBuffSecSessionByStartIdxKey,
			SecureBuffSecSession > dictByStartIdx
		= new HashMap< SecureBuffSecSessionByStartIdxKey,
			SecureBuffSecSession >();
	private Map< SecureBuffSecSessionByFinishIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecSession >> dictByFinishIdx
		= new HashMap< SecureBuffSecSessionByFinishIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecSession >>();
	private Map< SecureBuffSecSessionBySecProxyIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecSession >> dictBySecProxyIdx
		= new HashMap< SecureBuffSecSessionBySecProxyIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecSession >>();

	public SecureRamSecSessionTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecSession ensureRec(ISecureSecSession rec) {
		return (((SecureBuffSecSessionFactoryService)(schema.getSecureBuffFactory().getFactorySecSession())).ensureRec(rec));
	}

	@Override
	public ISecureSecSession createSecSession( ISecureAuthorization Authorization,
		ISecureSecSession iBuff )
	{
		final String S_ProcName = "createSecSession";
		
		SecureBuffSecSession Buff = (SecureBuffSecSession)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextSecSessionIdGen();
		Buff.setRequiredSecSessionId( pkey );
		SecureBuffSecSessionBySecUserIdxKey keySecUserIdx = (SecureBuffSecSessionBySecUserIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecUserIdxKey();
		keySecUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		SecureBuffSecSessionByStartIdxKey keyStartIdx = (SecureBuffSecSessionByStartIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByStartIdxKey();
		keyStartIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		keyStartIdx.setRequiredStart( Buff.getRequiredStart() );

		SecureBuffSecSessionByFinishIdxKey keyFinishIdx = (SecureBuffSecSessionByFinishIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByFinishIdxKey();
		keyFinishIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		keyFinishIdx.setOptionalFinish( Buff.getOptionalFinish() );

		SecureBuffSecSessionBySecProxyIdxKey keySecProxyIdx = (SecureBuffSecSessionBySecProxyIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecProxyIdxKey();
		keySecProxyIdx.setOptionalSecProxyId( Buff.getOptionalSecProxyId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByStartIdx.containsKey( keyStartIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SessionStartIdx",
				"SessionStartIdx",
				keyStartIdx );
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
						"SecSessionSecUser",
						"SecSessionSecUser",
						"SecUser",
						"SecUser",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdictSecUserIdx;
		if( dictBySecUserIdx.containsKey( keySecUserIdx ) ) {
			subdictSecUserIdx = dictBySecUserIdx.get( keySecUserIdx );
		}
		else {
			subdictSecUserIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSession >();
			dictBySecUserIdx.put( keySecUserIdx, subdictSecUserIdx );
		}
		subdictSecUserIdx.put( pkey, Buff );

		dictByStartIdx.put( keyStartIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdictFinishIdx;
		if( dictByFinishIdx.containsKey( keyFinishIdx ) ) {
			subdictFinishIdx = dictByFinishIdx.get( keyFinishIdx );
		}
		else {
			subdictFinishIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSession >();
			dictByFinishIdx.put( keyFinishIdx, subdictFinishIdx );
		}
		subdictFinishIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdictSecProxyIdx;
		if( dictBySecProxyIdx.containsKey( keySecProxyIdx ) ) {
			subdictSecProxyIdx = dictBySecProxyIdx.get( keySecProxyIdx );
		}
		else {
			subdictSecProxyIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSession >();
			dictBySecProxyIdx.put( keySecProxyIdx, subdictSecProxyIdx );
		}
		subdictSecProxyIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecSession.CLASS_CODE) {
				SecureBuffSecSession retbuff = ((SecureBuffSecSession)(schema.getSecureBuffFactory().getFactorySecSession().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecSession readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecSession.readDerived";
		ISecureSecSession buff;
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
	public ISecureSecSession lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecSession.lockDerived";
		ISecureSecSession buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSession[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecSession.readAllDerived";
		ISecureSecSession[] retList = new ISecureSecSession[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecSession > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecSession[] readDerivedBySecUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecSession.readDerivedBySecUserIdx";
		SecureBuffSecSessionBySecUserIdxKey key = (SecureBuffSecSessionBySecUserIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecUserIdxKey();

		key.setRequiredSecUserId( SecUserId );
		ISecureSecSession[] recArray;
		if( dictBySecUserIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdictSecUserIdx
				= dictBySecUserIdx.get( key );
			recArray = new ISecureSecSession[ subdictSecUserIdx.size() ];
			Iterator< SecureBuffSecSession > iter = subdictSecUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdictSecUserIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSession >();
			dictBySecUserIdx.put( key, subdictSecUserIdx );
			recArray = new ISecureSecSession[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSession readDerivedByStartIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime Start )
	{
		final String S_ProcName = "SecureRamSecSession.readDerivedByStartIdx";
		SecureBuffSecSessionByStartIdxKey key = (SecureBuffSecSessionByStartIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByStartIdxKey();

		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		ISecureSecSession buff;
		if( dictByStartIdx.containsKey( key ) ) {
			buff = dictByStartIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSession[] readDerivedByFinishIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime Finish )
	{
		final String S_ProcName = "SecureRamSecSession.readDerivedByFinishIdx";
		SecureBuffSecSessionByFinishIdxKey key = (SecureBuffSecSessionByFinishIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByFinishIdxKey();

		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		ISecureSecSession[] recArray;
		if( dictByFinishIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdictFinishIdx
				= dictByFinishIdx.get( key );
			recArray = new ISecureSecSession[ subdictFinishIdx.size() ];
			Iterator< SecureBuffSecSession > iter = subdictFinishIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdictFinishIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSession >();
			dictByFinishIdx.put( key, subdictFinishIdx );
			recArray = new ISecureSecSession[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSession[] readDerivedBySecProxyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecProxyId )
	{
		final String S_ProcName = "SecureRamSecSession.readDerivedBySecProxyIdx";
		SecureBuffSecSessionBySecProxyIdxKey key = (SecureBuffSecSessionBySecProxyIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecProxyIdxKey();

		key.setOptionalSecProxyId( SecProxyId );
		ISecureSecSession[] recArray;
		if( dictBySecProxyIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdictSecProxyIdx
				= dictBySecProxyIdx.get( key );
			recArray = new ISecureSecSession[ subdictSecProxyIdx.size() ];
			Iterator< SecureBuffSecSession > iter = subdictSecProxyIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdictSecProxyIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSession >();
			dictBySecProxyIdx.put( key, subdictSecProxyIdx );
			recArray = new ISecureSecSession[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSession readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSessionId )
	{
		final String S_ProcName = "SecureRamSecSession.readDerivedByIdIdx() ";
		ISecureSecSession buff;
		if( dictByPKey.containsKey( SecSessionId ) ) {
			buff = dictByPKey.get( SecSessionId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSession readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecSession.readRec";
		ISecureSecSession buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSession.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSession lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecSession buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSession.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSession[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecSession.readAllRec";
		ISecureSecSession buff;
		ArrayList<ISecureSecSession> filteredList = new ArrayList<ISecureSecSession>();
		ISecureSecSession[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSession.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSession[0] ) );
	}

	/**
	 *	Read a page of all the specific SecSession buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSession instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecSession[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecSessionId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecSession readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSessionId )
	{
		final String S_ProcName = "SecureRamSecSession.readRecByIdIdx() ";
		ISecureSecSession buff = readDerivedByIdIdx( Authorization,
			SecSessionId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSession.CLASS_CODE ) ) {
			return( (ISecureSecSession)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecSession[] readRecBySecUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecSession.readRecBySecUserIdx() ";
		ISecureSecSession buff;
		ArrayList<ISecureSecSession> filteredList = new ArrayList<ISecureSecSession>();
		ISecureSecSession[] buffList = readDerivedBySecUserIdx( Authorization,
			SecUserId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSession.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSession)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSession[0] ) );
	}

	@Override
	public ISecureSecSession readRecByStartIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime Start )
	{
		final String S_ProcName = "SecureRamSecSession.readRecByStartIdx() ";
		ISecureSecSession buff = readDerivedByStartIdx( Authorization,
			SecUserId,
			Start );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSession.CLASS_CODE ) ) {
			return( (ISecureSecSession)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecSession[] readRecByFinishIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime Finish )
	{
		final String S_ProcName = "SecureRamSecSession.readRecByFinishIdx() ";
		ISecureSecSession buff;
		ArrayList<ISecureSecSession> filteredList = new ArrayList<ISecureSecSession>();
		ISecureSecSession[] buffList = readDerivedByFinishIdx( Authorization,
			SecUserId,
			Finish );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSession.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSession)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSession[0] ) );
	}

	@Override
	public ISecureSecSession[] readRecBySecProxyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecProxyId )
	{
		final String S_ProcName = "SecureRamSecSession.readRecBySecProxyIdx() ";
		ISecureSecSession buff;
		ArrayList<ISecureSecSession> filteredList = new ArrayList<ISecureSecSession>();
		ISecureSecSession[] buffList = readDerivedBySecProxyIdx( Authorization,
			SecProxyId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSession.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSession)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSession[0] ) );
	}

	/**
	 *	Read a page array of the specific SecSession buffer instances identified by the duplicate key SecUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSession[] pageRecBySecUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		IYCFKeyHash256 priorSecSessionId )
	{
		final String S_ProcName = "pageRecBySecUserIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecSession buffer instances identified by the duplicate key FinishIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSession[] pageRecByFinishIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId,
		LocalDateTime Finish,
		IYCFKeyHash256 priorSecSessionId )
	{
		final String S_ProcName = "pageRecByFinishIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecSession buffer instances identified by the duplicate key SecProxyIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSession[] pageRecBySecProxyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecProxyId,
		IYCFKeyHash256 priorSecSessionId )
	{
		final String S_ProcName = "pageRecBySecProxyIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	public ISecureSecSession updateSecSession( ISecureAuthorization Authorization,
		ISecureSecSession iBuff )
	{
		SecureBuffSecSession Buff = (SecureBuffSecSession)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecSession existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecSession",
				"Existing record not found",
				"Existing record not found",
				"SecSession",
				"SecSession",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecSession",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecSessionBySecUserIdxKey existingKeySecUserIdx = (SecureBuffSecSessionBySecUserIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecUserIdxKey();
		existingKeySecUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		SecureBuffSecSessionBySecUserIdxKey newKeySecUserIdx = (SecureBuffSecSessionBySecUserIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecUserIdxKey();
		newKeySecUserIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );

		SecureBuffSecSessionByStartIdxKey existingKeyStartIdx = (SecureBuffSecSessionByStartIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByStartIdxKey();
		existingKeyStartIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		existingKeyStartIdx.setRequiredStart( existing.getRequiredStart() );

		SecureBuffSecSessionByStartIdxKey newKeyStartIdx = (SecureBuffSecSessionByStartIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByStartIdxKey();
		newKeyStartIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		newKeyStartIdx.setRequiredStart( Buff.getRequiredStart() );

		SecureBuffSecSessionByFinishIdxKey existingKeyFinishIdx = (SecureBuffSecSessionByFinishIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByFinishIdxKey();
		existingKeyFinishIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		existingKeyFinishIdx.setOptionalFinish( existing.getOptionalFinish() );

		SecureBuffSecSessionByFinishIdxKey newKeyFinishIdx = (SecureBuffSecSessionByFinishIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByFinishIdxKey();
		newKeyFinishIdx.setRequiredSecUserId( Buff.getRequiredSecUserId() );
		newKeyFinishIdx.setOptionalFinish( Buff.getOptionalFinish() );

		SecureBuffSecSessionBySecProxyIdxKey existingKeySecProxyIdx = (SecureBuffSecSessionBySecProxyIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecProxyIdxKey();
		existingKeySecProxyIdx.setOptionalSecProxyId( existing.getOptionalSecProxyId() );

		SecureBuffSecSessionBySecProxyIdxKey newKeySecProxyIdx = (SecureBuffSecSessionBySecProxyIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecProxyIdxKey();
		newKeySecProxyIdx.setOptionalSecProxyId( Buff.getOptionalSecProxyId() );

		// Check unique indexes

		if( ! existingKeyStartIdx.equals( newKeyStartIdx ) ) {
			if( dictByStartIdx.containsKey( newKeyStartIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecSession",
					"SessionStartIdx",
					"SessionStartIdx",
					newKeyStartIdx );
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
						"updateSecSession",
						"Container",
						"Container",
						"SecSessionSecUser",
						"SecSessionSecUser",
						"SecUser",
						"SecUser",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySecUserIdx.get( existingKeySecUserIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecUserIdx.containsKey( newKeySecUserIdx ) ) {
			subdict = dictBySecUserIdx.get( newKeySecUserIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSession >();
			dictBySecUserIdx.put( newKeySecUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByStartIdx.remove( existingKeyStartIdx );
		dictByStartIdx.put( newKeyStartIdx, Buff );

		subdict = dictByFinishIdx.get( existingKeyFinishIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByFinishIdx.containsKey( newKeyFinishIdx ) ) {
			subdict = dictByFinishIdx.get( newKeyFinishIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSession >();
			dictByFinishIdx.put( newKeyFinishIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySecProxyIdx.get( existingKeySecProxyIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecProxyIdx.containsKey( newKeySecProxyIdx ) ) {
			subdict = dictBySecProxyIdx.get( newKeySecProxyIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSession >();
			dictBySecProxyIdx.put( newKeySecProxyIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecSession( ISecureAuthorization Authorization,
		ISecureSecSession iBuff )
	{
		final String S_ProcName = "SecureRamSecSessionTable.deleteSecSession() ";
		SecureBuffSecSession Buff = (SecureBuffSecSession)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecSession existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecSession",
				pkey );
		}
		SecureBuffSecSessionBySecUserIdxKey keySecUserIdx = (SecureBuffSecSessionBySecUserIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecUserIdxKey();
		keySecUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		SecureBuffSecSessionByStartIdxKey keyStartIdx = (SecureBuffSecSessionByStartIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByStartIdxKey();
		keyStartIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keyStartIdx.setRequiredStart( existing.getRequiredStart() );

		SecureBuffSecSessionByFinishIdxKey keyFinishIdx = (SecureBuffSecSessionByFinishIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByFinishIdxKey();
		keyFinishIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keyFinishIdx.setOptionalFinish( existing.getOptionalFinish() );

		SecureBuffSecSessionBySecProxyIdxKey keySecProxyIdx = (SecureBuffSecSessionBySecProxyIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecProxyIdxKey();
		keySecProxyIdx.setOptionalSecProxyId( existing.getOptionalSecProxyId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSession > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySecUserIdx.get( keySecUserIdx );
		subdict.remove( pkey );

		dictByStartIdx.remove( keyStartIdx );

		subdict = dictByFinishIdx.get( keyFinishIdx );
		subdict.remove( pkey );

		subdict = dictBySecProxyIdx.get( keySecProxyIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecSessionByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecSession cur;
		LinkedList<SecureBuffSecSession> matchSet = new LinkedList<SecureBuffSecSession>();
		Iterator<SecureBuffSecSession> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSession> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSession)(schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() ));
			deleteSecSession( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSessionBySecUserIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecUserId )
	{
		SecureBuffSecSessionBySecUserIdxKey key = (SecureBuffSecSessionBySecUserIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecUserIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		deleteSecSessionBySecUserIdx( Authorization, key );
	}

	@Override
	public void deleteSecSessionBySecUserIdx( ISecureAuthorization Authorization,
		ISecureSecSessionBySecUserIdxKey argKey )
	{
		SecureBuffSecSession cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSession> matchSet = new LinkedList<SecureBuffSecSession>();
		Iterator<SecureBuffSecSession> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSession> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSession)(schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() ));
			deleteSecSession( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSessionByStartIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecUserId,
		LocalDateTime argStart )
	{
		SecureBuffSecSessionByStartIdxKey key = (SecureBuffSecSessionByStartIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByStartIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setRequiredStart( argStart );
		deleteSecSessionByStartIdx( Authorization, key );
	}

	@Override
	public void deleteSecSessionByStartIdx( ISecureAuthorization Authorization,
		ISecureSecSessionByStartIdxKey argKey )
	{
		SecureBuffSecSession cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSession> matchSet = new LinkedList<SecureBuffSecSession>();
		Iterator<SecureBuffSecSession> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSession> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSession)(schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() ));
			deleteSecSession( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSessionByFinishIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecUserId,
		LocalDateTime argFinish )
	{
		SecureBuffSecSessionByFinishIdxKey key = (SecureBuffSecSessionByFinishIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newByFinishIdxKey();
		key.setRequiredSecUserId( argSecUserId );
		key.setOptionalFinish( argFinish );
		deleteSecSessionByFinishIdx( Authorization, key );
	}

	@Override
	public void deleteSecSessionByFinishIdx( ISecureAuthorization Authorization,
		ISecureSecSessionByFinishIdxKey argKey )
	{
		SecureBuffSecSession cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalFinish() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSession> matchSet = new LinkedList<SecureBuffSecSession>();
		Iterator<SecureBuffSecSession> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSession> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSession)(schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() ));
			deleteSecSession( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSessionBySecProxyIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecProxyId )
	{
		SecureBuffSecSessionBySecProxyIdxKey key = (SecureBuffSecSessionBySecProxyIdxKey)schema.getSecureBuffFactory().getFactorySecSession().newBySecProxyIdxKey();
		key.setOptionalSecProxyId( argSecProxyId );
		deleteSecSessionBySecProxyIdx( Authorization, key );
	}

	@Override
	public void deleteSecSessionBySecProxyIdx( ISecureAuthorization Authorization,
		ISecureSecSessionBySecProxyIdxKey argKey )
	{
		SecureBuffSecSession cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalSecProxyId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSession> matchSet = new LinkedList<SecureBuffSecSession>();
		Iterator<SecureBuffSecSession> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSession> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSession)(schema.getTableSecSession().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSessionId() ));
			deleteSecSession( Authorization, cur );
		}
	}
}
