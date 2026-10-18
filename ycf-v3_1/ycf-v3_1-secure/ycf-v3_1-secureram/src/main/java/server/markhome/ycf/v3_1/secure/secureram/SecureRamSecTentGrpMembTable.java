
// Description: Java 25 in-memory RAM DbIO implementation for SecTentGrpMemb.

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
 *	SecureRamSecTentGrpMembTable in-memory RAM DbIO implementation
 *	for SecTentGrpMemb.
 */
public class SecureRamSecTentGrpMembTable
	implements ISecureSecTentGrpMembTable
{
	private ISecureSchema schema;
	private Map< ISecureSecTentGrpMembPKey,
				SecureBuffSecTentGrpMemb > dictByPKey
		= new HashMap< ISecureSecTentGrpMembPKey,
				SecureBuffSecTentGrpMemb >();
	private Map< SecureBuffSecTentGrpMembByTentGrpIdxKey,
				Map< SecureBuffSecTentGrpMembPKey,
					SecureBuffSecTentGrpMemb >> dictByTentGrpIdx
		= new HashMap< SecureBuffSecTentGrpMembByTentGrpIdxKey,
				Map< SecureBuffSecTentGrpMembPKey,
					SecureBuffSecTentGrpMemb >>();
	private Map< SecureBuffSecTentGrpMembByUserIdxKey,
				Map< SecureBuffSecTentGrpMembPKey,
					SecureBuffSecTentGrpMemb >> dictByUserIdx
		= new HashMap< SecureBuffSecTentGrpMembByUserIdxKey,
				Map< SecureBuffSecTentGrpMembPKey,
					SecureBuffSecTentGrpMemb >>();

	public SecureRamSecTentGrpMembTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecTentGrpMemb ensureRec(ISecureSecTentGrpMemb rec) {
		return (((SecureBuffSecTentGrpMembFactoryService)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb())).ensureRec(rec));
	}

	@Override
	public ISecureSecTentGrpMemb createSecTentGrpMemb( ISecureAuthorization Authorization,
		ISecureSecTentGrpMemb iBuff )
	{
		final String S_ProcName = "createSecTentGrpMemb";
		
		SecureBuffSecTentGrpMemb Buff = (SecureBuffSecTentGrpMemb)ensureRec(iBuff);
		SecureBuffSecTentGrpMembPKey pkey = (SecureBuffSecTentGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newPKey());
		pkey.setRequiredSecTentGrpId(Buff.getRequiredSecTentGrpId());
		pkey.setRequiredLoginId(Buff.getRequiredLoginId());
		pkey.setRequiredSecTentGrpId( Buff.getRequiredSecTentGrpId() );
		pkey.setRequiredLoginId( Buff.getRequiredLoginId() );
		Buff.setRequiredContainerGroup( pkey.getRequiredSecTentGrpId() );
		Buff.setRequiredParentUser( pkey.getRequiredLoginId() );
		Buff.setRequiredSecTentGrpId( pkey.getRequiredSecTentGrpId() );
		Buff.setRequiredLoginId( pkey.getRequiredLoginId() );
		SecureBuffSecTentGrpMembByTentGrpIdxKey keyTentGrpIdx = (SecureBuffSecTentGrpMembByTentGrpIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		keyTentGrpIdx.setRequiredSecTentGrpId( Buff.getRequiredSecTentGrpId() );

		SecureBuffSecTentGrpMembByUserIdxKey keyUserIdx = (SecureBuffSecTentGrpMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		keyUserIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecTentGrp().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecTentGrpId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SecTentGrpMembGroup",
						"SecTentGrpMembGroup",
						"SecTentGrp",
						"SecTentGrp",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb > subdictTentGrpIdx;
		if( dictByTentGrpIdx.containsKey( keyTentGrpIdx ) ) {
			subdictTentGrpIdx = dictByTentGrpIdx.get( keyTentGrpIdx );
		}
		else {
			subdictTentGrpIdx = new HashMap< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb >();
			dictByTentGrpIdx.put( keyTentGrpIdx, subdictTentGrpIdx );
		}
		subdictTentGrpIdx.put( pkey, Buff );

		Map< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb > subdictUserIdx;
		if( dictByUserIdx.containsKey( keyUserIdx ) ) {
			subdictUserIdx = dictByUserIdx.get( keyUserIdx );
		}
		else {
			subdictUserIdx = new HashMap< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb >();
			dictByUserIdx.put( keyUserIdx, subdictUserIdx );
		}
		subdictUserIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecTentGrpMemb.CLASS_CODE) {
				SecureBuffSecTentGrpMemb retbuff = ((SecureBuffSecTentGrpMemb)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecTentGrpMemb readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		String LoginId )
	{
		{	$implCommaIJavaOptAtomType$ testSecTentGrpId = SecTentGrpId;
			if (testSecTentGrpId == null) {
				return( null );
			}
		}
		{	$implCommaIJavaOptAtomType$ testLoginId = LoginId;
			if (testLoginId == null) {
				return( null );
			}
		}
		SecureBuffSecTentGrpMembPKey key = (SecureBuffSecTentGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newPKey());
		key.setRequiredSecTentGrpId( SecTentGrpId );
		key.setRequiredLoginId( LoginId );
		return( readDerived( Authorization, key ) );
	}

	public ISecureSecTentGrpMemb readDerived( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.readDerived";
		SecureBuffSecTentGrpMembPKey key = (SecureBuffSecTentGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newPKey());
		key.setRequiredSecTentGrpId( PKey.getRequiredSecTentGrpId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecTentGrpMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrpMemb lockDerived( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.lockDerived";
		SecureBuffSecTentGrpMembPKey key = (SecureBuffSecTentGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newPKey());
		key.setRequiredSecTentGrpId( PKey.getRequiredSecTentGrpId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecTentGrpMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrpMemb[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecTentGrpMemb.readAllDerived";
		ISecureSecTentGrpMemb[] retList = new ISecureSecTentGrpMemb[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecTentGrpMemb > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecTentGrpMemb[] readDerivedByTentGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.readDerivedByTentGrpIdx";
		SecureBuffSecTentGrpMembByTentGrpIdxKey key = (SecureBuffSecTentGrpMembByTentGrpIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();

		key.setRequiredSecTentGrpId( SecTentGrpId );
		ISecureSecTentGrpMemb[] recArray;
		if( dictByTentGrpIdx.containsKey( key ) ) {
			Map< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb > subdictTentGrpIdx
				= dictByTentGrpIdx.get( key );
			recArray = new ISecureSecTentGrpMemb[ subdictTentGrpIdx.size() ];
			Iterator< SecureBuffSecTentGrpMemb > iter = subdictTentGrpIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb > subdictTentGrpIdx
				= new HashMap< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb >();
			dictByTentGrpIdx.put( key, subdictTentGrpIdx );
			recArray = new ISecureSecTentGrpMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecTentGrpMemb[] readDerivedByUserIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.readDerivedByUserIdx";
		SecureBuffSecTentGrpMembByUserIdxKey key = (SecureBuffSecTentGrpMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByUserIdxKey();

		key.setRequiredLoginId( LoginId );
		ISecureSecTentGrpMemb[] recArray;
		if( dictByUserIdx.containsKey( key ) ) {
			Map< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb > subdictUserIdx
				= dictByUserIdx.get( key );
			recArray = new ISecureSecTentGrpMemb[ subdictUserIdx.size() ];
			Iterator< SecureBuffSecTentGrpMemb > iter = subdictUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb > subdictUserIdx
				= new HashMap< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb >();
			dictByUserIdx.put( key, subdictUserIdx );
			recArray = new ISecureSecTentGrpMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecTentGrpMemb readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.readDerivedByIdIdx() ";
		SecureBuffSecTentGrpMembPKey key = (SecureBuffSecTentGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newPKey());
		key.setRequiredSecTentGrpId( SecTentGrpId );
		key.setRequiredLoginId( LoginId );
		ISecureSecTentGrpMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrpMemb readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		String LoginId )
	{
		SecureBuffSecTentGrpMembPKey key = (SecureBuffSecTentGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newPKey());
		key.setRequiredSecTentGrpId( SecTentGrpId );
		key.setRequiredLoginId( LoginId );
		return( readRec( Authorization, key ) );
	}

	@Override
	public ISecureSecTentGrpMemb readRec( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.readRec";
		ISecureSecTentGrpMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecTentGrpMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrpMemb lockRec( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecTentGrpMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecTentGrpMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentGrpMemb[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.readAllRec";
		ISecureSecTentGrpMemb buff;
		ArrayList<ISecureSecTentGrpMemb> filteredList = new ArrayList<ISecureSecTentGrpMemb>();
		ISecureSecTentGrpMemb[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentGrpMemb.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentGrpMemb[0] ) );
	}

	/**
	 *	Read a page of all the specific SecTentGrpMemb buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecTentGrpMemb instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecTentGrpMemb[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecTentGrpMemb readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.readRecByIdIdx() ";
		ISecureSecTentGrpMemb buff = readDerivedByIdIdx( Authorization,
			SecTentGrpId,
			LoginId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentGrpMemb.CLASS_CODE ) ) {
			return( (ISecureSecTentGrpMemb)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecTentGrpMemb[] readRecByTentGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.readRecByTentGrpIdx() ";
		ISecureSecTentGrpMemb buff;
		ArrayList<ISecureSecTentGrpMemb> filteredList = new ArrayList<ISecureSecTentGrpMemb>();
		ISecureSecTentGrpMemb[] buffList = readDerivedByTentGrpIdx( Authorization,
			SecTentGrpId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentGrpMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecTentGrpMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentGrpMemb[0] ) );
	}

	@Override
	public ISecureSecTentGrpMemb[] readRecByUserIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecTentGrpMemb.readRecByUserIdx() ";
		ISecureSecTentGrpMemb buff;
		ArrayList<ISecureSecTentGrpMemb> filteredList = new ArrayList<ISecureSecTentGrpMemb>();
		ISecureSecTentGrpMemb[] buffList = readDerivedByUserIdx( Authorization,
			LoginId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentGrpMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecTentGrpMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentGrpMemb[0] ) );
	}

	/**
	 *	Read a page array of the specific SecTentGrpMemb buffer instances identified by the duplicate key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecTentGrpMemb[] pageRecByTentGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecByTentGrpIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecTentGrpMemb buffer instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecTentGrpMemb[] pageRecByUserIdx( ISecureAuthorization Authorization,
		String LoginId,
		IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecByUserIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecTentGrpMemb updateSecTentGrpMemb( ISecureAuthorization Authorization,
		ISecureSecTentGrpMemb iBuff )
	{
		SecureBuffSecTentGrpMemb Buff = (SecureBuffSecTentGrpMemb)ensureRec(iBuff);
		SecureBuffSecTentGrpMembPKey pkey = (SecureBuffSecTentGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newPKey());
		pkey = (SecureBuffSecTentGrpMembPKey)Buff.getPKey();
		SecureBuffSecTentGrpMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecTentGrpMemb",
				"Existing record not found",
				"Existing record not found",
				"SecTentGrpMemb",
				"SecTentGrpMemb",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecTentGrpMemb",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecTentGrpMembByTentGrpIdxKey existingKeyTentGrpIdx = (SecureBuffSecTentGrpMembByTentGrpIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		existingKeyTentGrpIdx.setRequiredSecTentGrpId( existing.getRequiredSecTentGrpId() );

		SecureBuffSecTentGrpMembByTentGrpIdxKey newKeyTentGrpIdx = (SecureBuffSecTentGrpMembByTentGrpIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		newKeyTentGrpIdx.setRequiredSecTentGrpId( Buff.getRequiredSecTentGrpId() );

		SecureBuffSecTentGrpMembByUserIdxKey existingKeyUserIdx = (SecureBuffSecTentGrpMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		existingKeyUserIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		SecureBuffSecTentGrpMembByUserIdxKey newKeyUserIdx = (SecureBuffSecTentGrpMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		newKeyUserIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecTentGrp().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecTentGrpId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecTentGrpMemb",
						"Container",
						"Container",
						"SecTentGrpMembGroup",
						"SecTentGrpMembGroup",
						"SecTentGrp",
						"SecTentGrp",
						null );
				}
			}
		}

		// Update is valid

		Map< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTentGrpIdx.get( existingKeyTentGrpIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTentGrpIdx.containsKey( newKeyTentGrpIdx ) ) {
			subdict = dictByTentGrpIdx.get( newKeyTentGrpIdx );
		}
		else {
			subdict = new HashMap< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb >();
			dictByTentGrpIdx.put( newKeyTentGrpIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByUserIdx.get( existingKeyUserIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByUserIdx.containsKey( newKeyUserIdx ) ) {
			subdict = dictByUserIdx.get( newKeyUserIdx );
		}
		else {
			subdict = new HashMap< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb >();
			dictByUserIdx.put( newKeyUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecTentGrpMemb( ISecureAuthorization Authorization,
		ISecureSecTentGrpMemb iBuff )
	{
		final String S_ProcName = "SecureRamSecTentGrpMembTable.deleteSecTentGrpMemb() ";
		SecureBuffSecTentGrpMemb Buff = (SecureBuffSecTentGrpMemb)ensureRec(iBuff);
		int classCode;
		SecureBuffSecTentGrpMembPKey pkey = (SecureBuffSecTentGrpMembPKey)(Buff.getPKey());
		SecureBuffSecTentGrpMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecTentGrpMemb",
				pkey );
		}
		SecureBuffSecTentGrpMembByTentGrpIdxKey keyTentGrpIdx = (SecureBuffSecTentGrpMembByTentGrpIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		keyTentGrpIdx.setRequiredSecTentGrpId( existing.getRequiredSecTentGrpId() );

		SecureBuffSecTentGrpMembByUserIdxKey keyUserIdx = (SecureBuffSecTentGrpMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		keyUserIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< SecureBuffSecTentGrpMembPKey, SecureBuffSecTentGrpMemb > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTentGrpIdx.get( keyTentGrpIdx );
		subdict.remove( pkey );

		subdict = dictByUserIdx.get( keyUserIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecTentGrpMembByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentGrpId,
		String LoginId )
	{
		SecureBuffSecTentGrpMembPKey key = (SecureBuffSecTentGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newPKey());
		key.setRequiredSecTentGrpId( SecTentGrpId );
		key.setRequiredLoginId( LoginId );
		deleteSecTentGrpMembByIdIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentGrpMembByIdIdx( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembPKey PKey )
	{
		SecureBuffSecTentGrpMembPKey key = (SecureBuffSecTentGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newPKey());
		key.setRequiredSecTentGrpId( PKey.getRequiredSecTentGrpId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		SecureBuffSecTentGrpMembPKey argKey = key;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecTentGrpMemb cur;
		LinkedList<SecureBuffSecTentGrpMemb> matchSet = new LinkedList<SecureBuffSecTentGrpMemb>();
		Iterator<SecureBuffSecTentGrpMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentGrpMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentGrpMemb)(schema.getTableSecTentGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentGrpId(),
				cur.getRequiredLoginId() ));
			deleteSecTentGrpMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentGrpMembByTentGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecTentGrpId )
	{
		SecureBuffSecTentGrpMembByTentGrpIdxKey key = (SecureBuffSecTentGrpMembByTentGrpIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		key.setRequiredSecTentGrpId( argSecTentGrpId );
		deleteSecTentGrpMembByTentGrpIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentGrpMembByTentGrpIdx( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembByTentGrpIdxKey argKey )
	{
		SecureBuffSecTentGrpMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentGrpMemb> matchSet = new LinkedList<SecureBuffSecTentGrpMemb>();
		Iterator<SecureBuffSecTentGrpMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentGrpMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentGrpMemb)(schema.getTableSecTentGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentGrpId(),
				cur.getRequiredLoginId() ));
			deleteSecTentGrpMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentGrpMembByUserIdx( ISecureAuthorization Authorization,
		String argLoginId )
	{
		SecureBuffSecTentGrpMembByUserIdxKey key = (SecureBuffSecTentGrpMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		key.setRequiredLoginId( argLoginId );
		deleteSecTentGrpMembByUserIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentGrpMembByUserIdx( ISecureAuthorization Authorization,
		ISecureSecTentGrpMembByUserIdxKey argKey )
	{
		SecureBuffSecTentGrpMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentGrpMemb> matchSet = new LinkedList<SecureBuffSecTentGrpMemb>();
		Iterator<SecureBuffSecTentGrpMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentGrpMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentGrpMemb)(schema.getTableSecTentGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentGrpId(),
				cur.getRequiredLoginId() ));
			deleteSecTentGrpMemb( Authorization, cur );
		}
	}
}
