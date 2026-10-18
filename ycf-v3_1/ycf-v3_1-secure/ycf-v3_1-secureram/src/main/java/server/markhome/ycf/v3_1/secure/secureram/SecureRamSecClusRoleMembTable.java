
// Description: Java 25 in-memory RAM DbIO implementation for SecClusRoleMemb.

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
 *	SecureRamSecClusRoleMembTable in-memory RAM DbIO implementation
 *	for SecClusRoleMemb.
 */
public class SecureRamSecClusRoleMembTable
	implements ISecureSecClusRoleMembTable
{
	private ISecureSchema schema;
	private Map< ISecureSecClusRoleMembPKey,
				SecureBuffSecClusRoleMemb > dictByPKey
		= new HashMap< ISecureSecClusRoleMembPKey,
				SecureBuffSecClusRoleMemb >();
	private Map< SecureBuffSecClusRoleMembByClusRoleIdxKey,
				Map< SecureBuffSecClusRoleMembPKey,
					SecureBuffSecClusRoleMemb >> dictByClusRoleIdx
		= new HashMap< SecureBuffSecClusRoleMembByClusRoleIdxKey,
				Map< SecureBuffSecClusRoleMembPKey,
					SecureBuffSecClusRoleMemb >>();
	private Map< SecureBuffSecClusRoleMembByLoginIdxKey,
				Map< SecureBuffSecClusRoleMembPKey,
					SecureBuffSecClusRoleMemb >> dictByLoginIdx
		= new HashMap< SecureBuffSecClusRoleMembByLoginIdxKey,
				Map< SecureBuffSecClusRoleMembPKey,
					SecureBuffSecClusRoleMemb >>();

	public SecureRamSecClusRoleMembTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecClusRoleMemb ensureRec(ISecureSecClusRoleMemb rec) {
		return (((SecureBuffSecClusRoleMembFactoryService)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb())).ensureRec(rec));
	}

	@Override
	public ISecureSecClusRoleMemb createSecClusRoleMemb( ISecureAuthorization Authorization,
		ISecureSecClusRoleMemb iBuff )
	{
		final String S_ProcName = "createSecClusRoleMemb";
		
		SecureBuffSecClusRoleMemb Buff = (SecureBuffSecClusRoleMemb)ensureRec(iBuff);
		SecureBuffSecClusRoleMembPKey pkey = (SecureBuffSecClusRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newPKey());
		pkey.setRequiredSecClusRoleId(Buff.getRequiredSecClusRoleId());
		pkey.setRequiredLoginId(Buff.getRequiredLoginId());
		pkey.setRequiredSecClusRoleId( Buff.getRequiredSecClusRoleId() );
		pkey.setRequiredLoginId( Buff.getRequiredLoginId() );
		Buff.setRequiredContainerRole( pkey.getRequiredSecClusRoleId() );
		Buff.setRequiredParentUser( pkey.getRequiredLoginId() );
		Buff.setRequiredSecClusRoleId( pkey.getRequiredSecClusRoleId() );
		Buff.setRequiredLoginId( pkey.getRequiredLoginId() );
		SecureBuffSecClusRoleMembByClusRoleIdxKey keyClusRoleIdx = (SecureBuffSecClusRoleMembByClusRoleIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		keyClusRoleIdx.setRequiredSecClusRoleId( Buff.getRequiredSecClusRoleId() );

		SecureBuffSecClusRoleMembByLoginIdxKey keyLoginIdx = (SecureBuffSecClusRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		keyLoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecClusRole().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecClusRoleId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SecClusRoleMembRole",
						"SecClusRoleMembRole",
						"SecClusRole",
						"SecClusRole",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb > subdictClusRoleIdx;
		if( dictByClusRoleIdx.containsKey( keyClusRoleIdx ) ) {
			subdictClusRoleIdx = dictByClusRoleIdx.get( keyClusRoleIdx );
		}
		else {
			subdictClusRoleIdx = new HashMap< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb >();
			dictByClusRoleIdx.put( keyClusRoleIdx, subdictClusRoleIdx );
		}
		subdictClusRoleIdx.put( pkey, Buff );

		Map< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb > subdictLoginIdx;
		if( dictByLoginIdx.containsKey( keyLoginIdx ) ) {
			subdictLoginIdx = dictByLoginIdx.get( keyLoginIdx );
		}
		else {
			subdictLoginIdx = new HashMap< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb >();
			dictByLoginIdx.put( keyLoginIdx, subdictLoginIdx );
		}
		subdictLoginIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecClusRoleMemb.CLASS_CODE) {
				SecureBuffSecClusRoleMemb retbuff = ((SecureBuffSecClusRoleMemb)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecClusRoleMemb readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		String LoginId )
	{
		{	$implCommaIJavaOptAtomType$ testSecClusRoleId = SecClusRoleId;
			if (testSecClusRoleId == null) {
				return( null );
			}
		}
		{	$implCommaIJavaOptAtomType$ testLoginId = LoginId;
			if (testLoginId == null) {
				return( null );
			}
		}
		SecureBuffSecClusRoleMembPKey key = (SecureBuffSecClusRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newPKey());
		key.setRequiredSecClusRoleId( SecClusRoleId );
		key.setRequiredLoginId( LoginId );
		return( readDerived( Authorization, key ) );
	}

	public ISecureSecClusRoleMemb readDerived( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.readDerived";
		SecureBuffSecClusRoleMembPKey key = (SecureBuffSecClusRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newPKey());
		key.setRequiredSecClusRoleId( PKey.getRequiredSecClusRoleId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecClusRoleMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusRoleMemb lockDerived( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.lockDerived";
		SecureBuffSecClusRoleMembPKey key = (SecureBuffSecClusRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newPKey());
		key.setRequiredSecClusRoleId( PKey.getRequiredSecClusRoleId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecClusRoleMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusRoleMemb[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecClusRoleMemb.readAllDerived";
		ISecureSecClusRoleMemb[] retList = new ISecureSecClusRoleMemb[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecClusRoleMemb > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecClusRoleMemb[] readDerivedByClusRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.readDerivedByClusRoleIdx";
		SecureBuffSecClusRoleMembByClusRoleIdxKey key = (SecureBuffSecClusRoleMembByClusRoleIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();

		key.setRequiredSecClusRoleId( SecClusRoleId );
		ISecureSecClusRoleMemb[] recArray;
		if( dictByClusRoleIdx.containsKey( key ) ) {
			Map< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb > subdictClusRoleIdx
				= dictByClusRoleIdx.get( key );
			recArray = new ISecureSecClusRoleMemb[ subdictClusRoleIdx.size() ];
			Iterator< SecureBuffSecClusRoleMemb > iter = subdictClusRoleIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb > subdictClusRoleIdx
				= new HashMap< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb >();
			dictByClusRoleIdx.put( key, subdictClusRoleIdx );
			recArray = new ISecureSecClusRoleMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecClusRoleMemb[] readDerivedByLoginIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.readDerivedByLoginIdx";
		SecureBuffSecClusRoleMembByLoginIdxKey key = (SecureBuffSecClusRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();

		key.setRequiredLoginId( LoginId );
		ISecureSecClusRoleMemb[] recArray;
		if( dictByLoginIdx.containsKey( key ) ) {
			Map< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb > subdictLoginIdx
				= dictByLoginIdx.get( key );
			recArray = new ISecureSecClusRoleMemb[ subdictLoginIdx.size() ];
			Iterator< SecureBuffSecClusRoleMemb > iter = subdictLoginIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb > subdictLoginIdx
				= new HashMap< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb >();
			dictByLoginIdx.put( key, subdictLoginIdx );
			recArray = new ISecureSecClusRoleMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecClusRoleMemb readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.readDerivedByIdIdx() ";
		SecureBuffSecClusRoleMembPKey key = (SecureBuffSecClusRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newPKey());
		key.setRequiredSecClusRoleId( SecClusRoleId );
		key.setRequiredLoginId( LoginId );
		ISecureSecClusRoleMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusRoleMemb readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		String LoginId )
	{
		SecureBuffSecClusRoleMembPKey key = (SecureBuffSecClusRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newPKey());
		key.setRequiredSecClusRoleId( SecClusRoleId );
		key.setRequiredLoginId( LoginId );
		return( readRec( Authorization, key ) );
	}

	@Override
	public ISecureSecClusRoleMemb readRec( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.readRec";
		ISecureSecClusRoleMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecClusRoleMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusRoleMemb lockRec( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecClusRoleMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecClusRoleMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecClusRoleMemb[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.readAllRec";
		ISecureSecClusRoleMemb buff;
		ArrayList<ISecureSecClusRoleMemb> filteredList = new ArrayList<ISecureSecClusRoleMemb>();
		ISecureSecClusRoleMemb[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecClusRoleMemb.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecClusRoleMemb[0] ) );
	}

	/**
	 *	Read a page of all the specific SecClusRoleMemb buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecClusRoleMemb instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecClusRoleMemb[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecClusRoleMemb readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.readRecByIdIdx() ";
		ISecureSecClusRoleMemb buff = readDerivedByIdIdx( Authorization,
			SecClusRoleId,
			LoginId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecClusRoleMemb.CLASS_CODE ) ) {
			return( (ISecureSecClusRoleMemb)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecClusRoleMemb[] readRecByClusRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.readRecByClusRoleIdx() ";
		ISecureSecClusRoleMemb buff;
		ArrayList<ISecureSecClusRoleMemb> filteredList = new ArrayList<ISecureSecClusRoleMemb>();
		ISecureSecClusRoleMemb[] buffList = readDerivedByClusRoleIdx( Authorization,
			SecClusRoleId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecClusRoleMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecClusRoleMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecClusRoleMemb[0] ) );
	}

	@Override
	public ISecureSecClusRoleMemb[] readRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecClusRoleMemb.readRecByLoginIdx() ";
		ISecureSecClusRoleMemb buff;
		ArrayList<ISecureSecClusRoleMemb> filteredList = new ArrayList<ISecureSecClusRoleMemb>();
		ISecureSecClusRoleMemb[] buffList = readDerivedByLoginIdx( Authorization,
			LoginId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecClusRoleMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecClusRoleMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecClusRoleMemb[0] ) );
	}

	/**
	 *	Read a page array of the specific SecClusRoleMemb buffer instances identified by the duplicate key ClusRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusRoleId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecClusRoleMemb[] pageRecByClusRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecByClusRoleIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecClusRoleMemb buffer instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecClusRoleMemb[] pageRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId,
		IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecByLoginIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecClusRoleMemb updateSecClusRoleMemb( ISecureAuthorization Authorization,
		ISecureSecClusRoleMemb iBuff )
	{
		SecureBuffSecClusRoleMemb Buff = (SecureBuffSecClusRoleMemb)ensureRec(iBuff);
		SecureBuffSecClusRoleMembPKey pkey = (SecureBuffSecClusRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newPKey());
		pkey = (SecureBuffSecClusRoleMembPKey)Buff.getPKey();
		SecureBuffSecClusRoleMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecClusRoleMemb",
				"Existing record not found",
				"Existing record not found",
				"SecClusRoleMemb",
				"SecClusRoleMemb",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecClusRoleMemb",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecClusRoleMembByClusRoleIdxKey existingKeyClusRoleIdx = (SecureBuffSecClusRoleMembByClusRoleIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		existingKeyClusRoleIdx.setRequiredSecClusRoleId( existing.getRequiredSecClusRoleId() );

		SecureBuffSecClusRoleMembByClusRoleIdxKey newKeyClusRoleIdx = (SecureBuffSecClusRoleMembByClusRoleIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		newKeyClusRoleIdx.setRequiredSecClusRoleId( Buff.getRequiredSecClusRoleId() );

		SecureBuffSecClusRoleMembByLoginIdxKey existingKeyLoginIdx = (SecureBuffSecClusRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		existingKeyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		SecureBuffSecClusRoleMembByLoginIdxKey newKeyLoginIdx = (SecureBuffSecClusRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		newKeyLoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecClusRole().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecClusRoleId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecClusRoleMemb",
						"Container",
						"Container",
						"SecClusRoleMembRole",
						"SecClusRoleMembRole",
						"SecClusRole",
						"SecClusRole",
						null );
				}
			}
		}

		// Update is valid

		Map< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByClusRoleIdx.get( existingKeyClusRoleIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByClusRoleIdx.containsKey( newKeyClusRoleIdx ) ) {
			subdict = dictByClusRoleIdx.get( newKeyClusRoleIdx );
		}
		else {
			subdict = new HashMap< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb >();
			dictByClusRoleIdx.put( newKeyClusRoleIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByLoginIdx.get( existingKeyLoginIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLoginIdx.containsKey( newKeyLoginIdx ) ) {
			subdict = dictByLoginIdx.get( newKeyLoginIdx );
		}
		else {
			subdict = new HashMap< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb >();
			dictByLoginIdx.put( newKeyLoginIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecClusRoleMemb( ISecureAuthorization Authorization,
		ISecureSecClusRoleMemb iBuff )
	{
		final String S_ProcName = "SecureRamSecClusRoleMembTable.deleteSecClusRoleMemb() ";
		SecureBuffSecClusRoleMemb Buff = (SecureBuffSecClusRoleMemb)ensureRec(iBuff);
		int classCode;
		SecureBuffSecClusRoleMembPKey pkey = (SecureBuffSecClusRoleMembPKey)(Buff.getPKey());
		SecureBuffSecClusRoleMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecClusRoleMemb",
				pkey );
		}
		SecureBuffSecClusRoleMembByClusRoleIdxKey keyClusRoleIdx = (SecureBuffSecClusRoleMembByClusRoleIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		keyClusRoleIdx.setRequiredSecClusRoleId( existing.getRequiredSecClusRoleId() );

		SecureBuffSecClusRoleMembByLoginIdxKey keyLoginIdx = (SecureBuffSecClusRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		keyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< SecureBuffSecClusRoleMembPKey, SecureBuffSecClusRoleMemb > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByClusRoleIdx.get( keyClusRoleIdx );
		subdict.remove( pkey );

		subdict = dictByLoginIdx.get( keyLoginIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecClusRoleMembByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecClusRoleId,
		String LoginId )
	{
		SecureBuffSecClusRoleMembPKey key = (SecureBuffSecClusRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newPKey());
		key.setRequiredSecClusRoleId( SecClusRoleId );
		key.setRequiredLoginId( LoginId );
		deleteSecClusRoleMembByIdIdx( Authorization, key );
	}

	@Override
	public void deleteSecClusRoleMembByIdIdx( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembPKey PKey )
	{
		SecureBuffSecClusRoleMembPKey key = (SecureBuffSecClusRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newPKey());
		key.setRequiredSecClusRoleId( PKey.getRequiredSecClusRoleId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		SecureBuffSecClusRoleMembPKey argKey = key;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecClusRoleMemb cur;
		LinkedList<SecureBuffSecClusRoleMemb> matchSet = new LinkedList<SecureBuffSecClusRoleMemb>();
		Iterator<SecureBuffSecClusRoleMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecClusRoleMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecClusRoleMemb)(schema.getTableSecClusRoleMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecClusRoleId(),
				cur.getRequiredLoginId() ));
			deleteSecClusRoleMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecClusRoleMembByClusRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecClusRoleId )
	{
		SecureBuffSecClusRoleMembByClusRoleIdxKey key = (SecureBuffSecClusRoleMembByClusRoleIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		key.setRequiredSecClusRoleId( argSecClusRoleId );
		deleteSecClusRoleMembByClusRoleIdx( Authorization, key );
	}

	@Override
	public void deleteSecClusRoleMembByClusRoleIdx( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembByClusRoleIdxKey argKey )
	{
		SecureBuffSecClusRoleMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecClusRoleMemb> matchSet = new LinkedList<SecureBuffSecClusRoleMemb>();
		Iterator<SecureBuffSecClusRoleMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecClusRoleMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecClusRoleMemb)(schema.getTableSecClusRoleMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecClusRoleId(),
				cur.getRequiredLoginId() ));
			deleteSecClusRoleMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecClusRoleMembByLoginIdx( ISecureAuthorization Authorization,
		String argLoginId )
	{
		SecureBuffSecClusRoleMembByLoginIdxKey key = (SecureBuffSecClusRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( argLoginId );
		deleteSecClusRoleMembByLoginIdx( Authorization, key );
	}

	@Override
	public void deleteSecClusRoleMembByLoginIdx( ISecureAuthorization Authorization,
		ISecureSecClusRoleMembByLoginIdxKey argKey )
	{
		SecureBuffSecClusRoleMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecClusRoleMemb> matchSet = new LinkedList<SecureBuffSecClusRoleMemb>();
		Iterator<SecureBuffSecClusRoleMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecClusRoleMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecClusRoleMemb)(schema.getTableSecClusRoleMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecClusRoleId(),
				cur.getRequiredLoginId() ));
			deleteSecClusRoleMemb( Authorization, cur );
		}
	}
}
