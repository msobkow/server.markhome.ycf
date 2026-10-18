
// Description: Java 25 in-memory RAM DbIO implementation for SecTentRoleMemb.

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
 *	SecureRamSecTentRoleMembTable in-memory RAM DbIO implementation
 *	for SecTentRoleMemb.
 */
public class SecureRamSecTentRoleMembTable
	implements ISecureSecTentRoleMembTable
{
	private ISecureSchema schema;
	private Map< ISecureSecTentRoleMembPKey,
				SecureBuffSecTentRoleMemb > dictByPKey
		= new HashMap< ISecureSecTentRoleMembPKey,
				SecureBuffSecTentRoleMemb >();
	private Map< SecureBuffSecTentRoleMembByTentRoleIdxKey,
				Map< SecureBuffSecTentRoleMembPKey,
					SecureBuffSecTentRoleMemb >> dictByTentRoleIdx
		= new HashMap< SecureBuffSecTentRoleMembByTentRoleIdxKey,
				Map< SecureBuffSecTentRoleMembPKey,
					SecureBuffSecTentRoleMemb >>();
	private Map< SecureBuffSecTentRoleMembByUserIdxKey,
				Map< SecureBuffSecTentRoleMembPKey,
					SecureBuffSecTentRoleMemb >> dictByUserIdx
		= new HashMap< SecureBuffSecTentRoleMembByUserIdxKey,
				Map< SecureBuffSecTentRoleMembPKey,
					SecureBuffSecTentRoleMemb >>();

	public SecureRamSecTentRoleMembTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecTentRoleMemb ensureRec(ISecureSecTentRoleMemb rec) {
		return (((SecureBuffSecTentRoleMembFactoryService)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb())).ensureRec(rec));
	}

	@Override
	public ISecureSecTentRoleMemb createSecTentRoleMemb( ISecureAuthorization Authorization,
		ISecureSecTentRoleMemb iBuff )
	{
		final String S_ProcName = "createSecTentRoleMemb";
		
		SecureBuffSecTentRoleMemb Buff = (SecureBuffSecTentRoleMemb)ensureRec(iBuff);
		SecureBuffSecTentRoleMembPKey pkey = (SecureBuffSecTentRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newPKey());
		pkey.setRequiredSecTentRoleId(Buff.getRequiredSecTentRoleId());
		pkey.setRequiredLoginId(Buff.getRequiredLoginId());
		pkey.setRequiredSecTentRoleId( Buff.getRequiredSecTentRoleId() );
		pkey.setRequiredLoginId( Buff.getRequiredLoginId() );
		Buff.setRequiredContainerRole( pkey.getRequiredSecTentRoleId() );
		Buff.setRequiredParentUser( pkey.getRequiredLoginId() );
		Buff.setRequiredSecTentRoleId( pkey.getRequiredSecTentRoleId() );
		Buff.setRequiredLoginId( pkey.getRequiredLoginId() );
		SecureBuffSecTentRoleMembByTentRoleIdxKey keyTentRoleIdx = (SecureBuffSecTentRoleMembByTentRoleIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		keyTentRoleIdx.setRequiredSecTentRoleId( Buff.getRequiredSecTentRoleId() );

		SecureBuffSecTentRoleMembByUserIdxKey keyUserIdx = (SecureBuffSecTentRoleMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
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
				if( null == schema.getTableSecTentRole().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecTentRoleId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SecTentRoleMembRole",
						"SecTentRoleMembRole",
						"SecTentRole",
						"SecTentRole",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb > subdictTentRoleIdx;
		if( dictByTentRoleIdx.containsKey( keyTentRoleIdx ) ) {
			subdictTentRoleIdx = dictByTentRoleIdx.get( keyTentRoleIdx );
		}
		else {
			subdictTentRoleIdx = new HashMap< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb >();
			dictByTentRoleIdx.put( keyTentRoleIdx, subdictTentRoleIdx );
		}
		subdictTentRoleIdx.put( pkey, Buff );

		Map< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb > subdictUserIdx;
		if( dictByUserIdx.containsKey( keyUserIdx ) ) {
			subdictUserIdx = dictByUserIdx.get( keyUserIdx );
		}
		else {
			subdictUserIdx = new HashMap< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb >();
			dictByUserIdx.put( keyUserIdx, subdictUserIdx );
		}
		subdictUserIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecTentRoleMemb.CLASS_CODE) {
				SecureBuffSecTentRoleMemb retbuff = ((SecureBuffSecTentRoleMemb)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecTentRoleMemb readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId,
		String LoginId )
	{
		{	$implCommaIJavaOptAtomType$ testSecTentRoleId = SecTentRoleId;
			if (testSecTentRoleId == null) {
				return( null );
			}
		}
		{	$implCommaIJavaOptAtomType$ testLoginId = LoginId;
			if (testLoginId == null) {
				return( null );
			}
		}
		SecureBuffSecTentRoleMembPKey key = (SecureBuffSecTentRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newPKey());
		key.setRequiredSecTentRoleId( SecTentRoleId );
		key.setRequiredLoginId( LoginId );
		return( readDerived( Authorization, key ) );
	}

	public ISecureSecTentRoleMemb readDerived( ISecureAuthorization Authorization,
		ISecureSecTentRoleMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.readDerived";
		SecureBuffSecTentRoleMembPKey key = (SecureBuffSecTentRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newPKey());
		key.setRequiredSecTentRoleId( PKey.getRequiredSecTentRoleId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecTentRoleMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRoleMemb lockDerived( ISecureAuthorization Authorization,
		ISecureSecTentRoleMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.lockDerived";
		SecureBuffSecTentRoleMembPKey key = (SecureBuffSecTentRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newPKey());
		key.setRequiredSecTentRoleId( PKey.getRequiredSecTentRoleId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecTentRoleMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRoleMemb[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecTentRoleMemb.readAllDerived";
		ISecureSecTentRoleMemb[] retList = new ISecureSecTentRoleMemb[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecTentRoleMemb > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecTentRoleMemb[] readDerivedByTentRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.readDerivedByTentRoleIdx";
		SecureBuffSecTentRoleMembByTentRoleIdxKey key = (SecureBuffSecTentRoleMembByTentRoleIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();

		key.setRequiredSecTentRoleId( SecTentRoleId );
		ISecureSecTentRoleMemb[] recArray;
		if( dictByTentRoleIdx.containsKey( key ) ) {
			Map< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb > subdictTentRoleIdx
				= dictByTentRoleIdx.get( key );
			recArray = new ISecureSecTentRoleMemb[ subdictTentRoleIdx.size() ];
			Iterator< SecureBuffSecTentRoleMemb > iter = subdictTentRoleIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb > subdictTentRoleIdx
				= new HashMap< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb >();
			dictByTentRoleIdx.put( key, subdictTentRoleIdx );
			recArray = new ISecureSecTentRoleMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecTentRoleMemb[] readDerivedByUserIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.readDerivedByUserIdx";
		SecureBuffSecTentRoleMembByUserIdxKey key = (SecureBuffSecTentRoleMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByUserIdxKey();

		key.setRequiredLoginId( LoginId );
		ISecureSecTentRoleMemb[] recArray;
		if( dictByUserIdx.containsKey( key ) ) {
			Map< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb > subdictUserIdx
				= dictByUserIdx.get( key );
			recArray = new ISecureSecTentRoleMemb[ subdictUserIdx.size() ];
			Iterator< SecureBuffSecTentRoleMemb > iter = subdictUserIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb > subdictUserIdx
				= new HashMap< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb >();
			dictByUserIdx.put( key, subdictUserIdx );
			recArray = new ISecureSecTentRoleMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecTentRoleMemb readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.readDerivedByIdIdx() ";
		SecureBuffSecTentRoleMembPKey key = (SecureBuffSecTentRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newPKey());
		key.setRequiredSecTentRoleId( SecTentRoleId );
		key.setRequiredLoginId( LoginId );
		ISecureSecTentRoleMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRoleMemb readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId,
		String LoginId )
	{
		SecureBuffSecTentRoleMembPKey key = (SecureBuffSecTentRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newPKey());
		key.setRequiredSecTentRoleId( SecTentRoleId );
		key.setRequiredLoginId( LoginId );
		return( readRec( Authorization, key ) );
	}

	@Override
	public ISecureSecTentRoleMemb readRec( ISecureAuthorization Authorization,
		ISecureSecTentRoleMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.readRec";
		ISecureSecTentRoleMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecTentRoleMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRoleMemb lockRec( ISecureAuthorization Authorization,
		ISecureSecTentRoleMembPKey PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecTentRoleMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecTentRoleMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecTentRoleMemb[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.readAllRec";
		ISecureSecTentRoleMemb buff;
		ArrayList<ISecureSecTentRoleMemb> filteredList = new ArrayList<ISecureSecTentRoleMemb>();
		ISecureSecTentRoleMemb[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentRoleMemb.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentRoleMemb[0] ) );
	}

	/**
	 *	Read a page of all the specific SecTentRoleMemb buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecTentRoleMemb instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecTentRoleMemb[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecTentRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecTentRoleMemb readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.readRecByIdIdx() ";
		ISecureSecTentRoleMemb buff = readDerivedByIdIdx( Authorization,
			SecTentRoleId,
			LoginId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentRoleMemb.CLASS_CODE ) ) {
			return( (ISecureSecTentRoleMemb)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecTentRoleMemb[] readRecByTentRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.readRecByTentRoleIdx() ";
		ISecureSecTentRoleMemb buff;
		ArrayList<ISecureSecTentRoleMemb> filteredList = new ArrayList<ISecureSecTentRoleMemb>();
		ISecureSecTentRoleMemb[] buffList = readDerivedByTentRoleIdx( Authorization,
			SecTentRoleId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentRoleMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecTentRoleMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentRoleMemb[0] ) );
	}

	@Override
	public ISecureSecTentRoleMemb[] readRecByUserIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecTentRoleMemb.readRecByUserIdx() ";
		ISecureSecTentRoleMemb buff;
		ArrayList<ISecureSecTentRoleMemb> filteredList = new ArrayList<ISecureSecTentRoleMemb>();
		ISecureSecTentRoleMemb[] buffList = readDerivedByUserIdx( Authorization,
			LoginId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecTentRoleMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecTentRoleMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecTentRoleMemb[0] ) );
	}

	/**
	 *	Read a page array of the specific SecTentRoleMemb buffer instances identified by the duplicate key TentRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentRoleId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecTentRoleMemb[] pageRecByTentRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId,
		IYCFKeyHash256 priorSecTentRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecByTentRoleIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecTentRoleMemb buffer instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecTentRoleMemb[] pageRecByUserIdx( ISecureAuthorization Authorization,
		String LoginId,
		IYCFKeyHash256 priorSecTentRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecByUserIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecTentRoleMemb updateSecTentRoleMemb( ISecureAuthorization Authorization,
		ISecureSecTentRoleMemb iBuff )
	{
		SecureBuffSecTentRoleMemb Buff = (SecureBuffSecTentRoleMemb)ensureRec(iBuff);
		SecureBuffSecTentRoleMembPKey pkey = (SecureBuffSecTentRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newPKey());
		pkey = (SecureBuffSecTentRoleMembPKey)Buff.getPKey();
		SecureBuffSecTentRoleMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecTentRoleMemb",
				"Existing record not found",
				"Existing record not found",
				"SecTentRoleMemb",
				"SecTentRoleMemb",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecTentRoleMemb",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecTentRoleMembByTentRoleIdxKey existingKeyTentRoleIdx = (SecureBuffSecTentRoleMembByTentRoleIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		existingKeyTentRoleIdx.setRequiredSecTentRoleId( existing.getRequiredSecTentRoleId() );

		SecureBuffSecTentRoleMembByTentRoleIdxKey newKeyTentRoleIdx = (SecureBuffSecTentRoleMembByTentRoleIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		newKeyTentRoleIdx.setRequiredSecTentRoleId( Buff.getRequiredSecTentRoleId() );

		SecureBuffSecTentRoleMembByUserIdxKey existingKeyUserIdx = (SecureBuffSecTentRoleMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
		existingKeyUserIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		SecureBuffSecTentRoleMembByUserIdxKey newKeyUserIdx = (SecureBuffSecTentRoleMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
		newKeyUserIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecTentRole().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecTentRoleId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecTentRoleMemb",
						"Container",
						"Container",
						"SecTentRoleMembRole",
						"SecTentRoleMembRole",
						"SecTentRole",
						"SecTentRole",
						null );
				}
			}
		}

		// Update is valid

		Map< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTentRoleIdx.get( existingKeyTentRoleIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTentRoleIdx.containsKey( newKeyTentRoleIdx ) ) {
			subdict = dictByTentRoleIdx.get( newKeyTentRoleIdx );
		}
		else {
			subdict = new HashMap< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb >();
			dictByTentRoleIdx.put( newKeyTentRoleIdx, subdict );
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
			subdict = new HashMap< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb >();
			dictByUserIdx.put( newKeyUserIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecTentRoleMemb( ISecureAuthorization Authorization,
		ISecureSecTentRoleMemb iBuff )
	{
		final String S_ProcName = "SecureRamSecTentRoleMembTable.deleteSecTentRoleMemb() ";
		SecureBuffSecTentRoleMemb Buff = (SecureBuffSecTentRoleMemb)ensureRec(iBuff);
		int classCode;
		SecureBuffSecTentRoleMembPKey pkey = (SecureBuffSecTentRoleMembPKey)(Buff.getPKey());
		SecureBuffSecTentRoleMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecTentRoleMemb",
				pkey );
		}
		SecureBuffSecTentRoleMembByTentRoleIdxKey keyTentRoleIdx = (SecureBuffSecTentRoleMembByTentRoleIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		keyTentRoleIdx.setRequiredSecTentRoleId( existing.getRequiredSecTentRoleId() );

		SecureBuffSecTentRoleMembByUserIdxKey keyUserIdx = (SecureBuffSecTentRoleMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
		keyUserIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< SecureBuffSecTentRoleMembPKey, SecureBuffSecTentRoleMemb > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTentRoleIdx.get( keyTentRoleIdx );
		subdict.remove( pkey );

		subdict = dictByUserIdx.get( keyUserIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecTentRoleMembByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecTentRoleId,
		String LoginId )
	{
		SecureBuffSecTentRoleMembPKey key = (SecureBuffSecTentRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newPKey());
		key.setRequiredSecTentRoleId( SecTentRoleId );
		key.setRequiredLoginId( LoginId );
		deleteSecTentRoleMembByIdIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentRoleMembByIdIdx( ISecureAuthorization Authorization,
		ISecureSecTentRoleMembPKey PKey )
	{
		SecureBuffSecTentRoleMembPKey key = (SecureBuffSecTentRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newPKey());
		key.setRequiredSecTentRoleId( PKey.getRequiredSecTentRoleId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		SecureBuffSecTentRoleMembPKey argKey = key;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecTentRoleMemb cur;
		LinkedList<SecureBuffSecTentRoleMemb> matchSet = new LinkedList<SecureBuffSecTentRoleMemb>();
		Iterator<SecureBuffSecTentRoleMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentRoleMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentRoleMemb)(schema.getTableSecTentRoleMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentRoleId(),
				cur.getRequiredLoginId() ));
			deleteSecTentRoleMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentRoleMembByTentRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecTentRoleId )
	{
		SecureBuffSecTentRoleMembByTentRoleIdxKey key = (SecureBuffSecTentRoleMembByTentRoleIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		key.setRequiredSecTentRoleId( argSecTentRoleId );
		deleteSecTentRoleMembByTentRoleIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentRoleMembByTentRoleIdx( ISecureAuthorization Authorization,
		ISecureSecTentRoleMembByTentRoleIdxKey argKey )
	{
		SecureBuffSecTentRoleMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentRoleMemb> matchSet = new LinkedList<SecureBuffSecTentRoleMemb>();
		Iterator<SecureBuffSecTentRoleMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentRoleMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentRoleMemb)(schema.getTableSecTentRoleMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentRoleId(),
				cur.getRequiredLoginId() ));
			deleteSecTentRoleMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecTentRoleMembByUserIdx( ISecureAuthorization Authorization,
		String argLoginId )
	{
		SecureBuffSecTentRoleMembByUserIdxKey key = (SecureBuffSecTentRoleMembByUserIdxKey)schema.getSecureBuffFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
		key.setRequiredLoginId( argLoginId );
		deleteSecTentRoleMembByUserIdx( Authorization, key );
	}

	@Override
	public void deleteSecTentRoleMembByUserIdx( ISecureAuthorization Authorization,
		ISecureSecTentRoleMembByUserIdxKey argKey )
	{
		SecureBuffSecTentRoleMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecTentRoleMemb> matchSet = new LinkedList<SecureBuffSecTentRoleMemb>();
		Iterator<SecureBuffSecTentRoleMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecTentRoleMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecTentRoleMemb)(schema.getTableSecTentRoleMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecTentRoleId(),
				cur.getRequiredLoginId() ));
			deleteSecTentRoleMemb( Authorization, cur );
		}
	}
}
