
// Description: Java 25 in-memory RAM DbIO implementation for SecSysRoleMemb.

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
 *	SecureRamSecSysRoleMembTable in-memory RAM DbIO implementation
 *	for SecSysRoleMemb.
 */
public class SecureRamSecSysRoleMembTable
	implements ISecureSecSysRoleMembTable
{
	private ISecureSchema schema;
	private Map< ISecureSecSysRoleMembPKey,
				SecureBuffSecSysRoleMemb > dictByPKey
		= new HashMap< ISecureSecSysRoleMembPKey,
				SecureBuffSecSysRoleMemb >();
	private Map< SecureBuffSecSysRoleMembBySysRoleIdxKey,
				Map< SecureBuffSecSysRoleMembPKey,
					SecureBuffSecSysRoleMemb >> dictBySysRoleIdx
		= new HashMap< SecureBuffSecSysRoleMembBySysRoleIdxKey,
				Map< SecureBuffSecSysRoleMembPKey,
					SecureBuffSecSysRoleMemb >>();
	private Map< SecureBuffSecSysRoleMembByLoginIdxKey,
				Map< SecureBuffSecSysRoleMembPKey,
					SecureBuffSecSysRoleMemb >> dictByLoginIdx
		= new HashMap< SecureBuffSecSysRoleMembByLoginIdxKey,
				Map< SecureBuffSecSysRoleMembPKey,
					SecureBuffSecSysRoleMemb >>();

	public SecureRamSecSysRoleMembTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecSysRoleMemb ensureRec(ISecureSecSysRoleMemb rec) {
		return (((SecureBuffSecSysRoleMembFactoryService)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb())).ensureRec(rec));
	}

	@Override
	public ISecureSecSysRoleMemb createSecSysRoleMemb( ISecureAuthorization Authorization,
		ISecureSecSysRoleMemb iBuff )
	{
		final String S_ProcName = "createSecSysRoleMemb";
		
		SecureBuffSecSysRoleMemb Buff = (SecureBuffSecSysRoleMemb)ensureRec(iBuff);
		SecureBuffSecSysRoleMembPKey pkey = (SecureBuffSecSysRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newPKey());
		pkey.setRequiredSecSysRoleId(Buff.getRequiredSecSysRoleId());
		pkey.setRequiredLoginId(Buff.getRequiredLoginId());
		pkey.setRequiredSecSysRoleId( Buff.getRequiredSecSysRoleId() );
		pkey.setRequiredLoginId( Buff.getRequiredLoginId() );
		Buff.setRequiredContainerSysRole( pkey.getRequiredSecSysRoleId() );
		Buff.setRequiredParentUser( pkey.getRequiredLoginId() );
		Buff.setRequiredSecSysRoleId( pkey.getRequiredSecSysRoleId() );
		Buff.setRequiredLoginId( pkey.getRequiredLoginId() );
		SecureBuffSecSysRoleMembBySysRoleIdxKey keySysRoleIdx = (SecureBuffSecSysRoleMembBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		keySysRoleIdx.setRequiredSecSysRoleId( Buff.getRequiredSecSysRoleId() );

		SecureBuffSecSysRoleMembByLoginIdxKey keyLoginIdx = (SecureBuffSecSysRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
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
				if( null == schema.getTableSecSysRole().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecSysRoleId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SecSysRoleMembSysRole",
						"SecSysRoleMembSysRole",
						"SecSysRole",
						"SecSysRole",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb > subdictSysRoleIdx;
		if( dictBySysRoleIdx.containsKey( keySysRoleIdx ) ) {
			subdictSysRoleIdx = dictBySysRoleIdx.get( keySysRoleIdx );
		}
		else {
			subdictSysRoleIdx = new HashMap< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb >();
			dictBySysRoleIdx.put( keySysRoleIdx, subdictSysRoleIdx );
		}
		subdictSysRoleIdx.put( pkey, Buff );

		Map< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb > subdictLoginIdx;
		if( dictByLoginIdx.containsKey( keyLoginIdx ) ) {
			subdictLoginIdx = dictByLoginIdx.get( keyLoginIdx );
		}
		else {
			subdictLoginIdx = new HashMap< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb >();
			dictByLoginIdx.put( keyLoginIdx, subdictLoginIdx );
		}
		subdictLoginIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecSysRoleMemb.CLASS_CODE) {
				SecureBuffSecSysRoleMemb retbuff = ((SecureBuffSecSysRoleMemb)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecSysRoleMemb readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String LoginId )
	{
		{	$implCommaIJavaOptAtomType$ testSecSysRoleId = SecSysRoleId;
			if (testSecSysRoleId == null) {
				return( null );
			}
		}
		{	$implCommaIJavaOptAtomType$ testLoginId = LoginId;
			if (testLoginId == null) {
				return( null );
			}
		}
		SecureBuffSecSysRoleMembPKey key = (SecureBuffSecSysRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newPKey());
		key.setRequiredSecSysRoleId( SecSysRoleId );
		key.setRequiredLoginId( LoginId );
		return( readDerived( Authorization, key ) );
	}

	public ISecureSecSysRoleMemb readDerived( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.readDerived";
		SecureBuffSecSysRoleMembPKey key = (SecureBuffSecSysRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newPKey());
		key.setRequiredSecSysRoleId( PKey.getRequiredSecSysRoleId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecSysRoleMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleMemb lockDerived( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.lockDerived";
		SecureBuffSecSysRoleMembPKey key = (SecureBuffSecSysRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newPKey());
		key.setRequiredSecSysRoleId( PKey.getRequiredSecSysRoleId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecSysRoleMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleMemb[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecSysRoleMemb.readAllDerived";
		ISecureSecSysRoleMemb[] retList = new ISecureSecSysRoleMemb[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecSysRoleMemb > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecSysRoleMemb[] readDerivedBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.readDerivedBySysRoleIdx";
		SecureBuffSecSysRoleMembBySysRoleIdxKey key = (SecureBuffSecSysRoleMembBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();

		key.setRequiredSecSysRoleId( SecSysRoleId );
		ISecureSecSysRoleMemb[] recArray;
		if( dictBySysRoleIdx.containsKey( key ) ) {
			Map< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb > subdictSysRoleIdx
				= dictBySysRoleIdx.get( key );
			recArray = new ISecureSecSysRoleMemb[ subdictSysRoleIdx.size() ];
			Iterator< SecureBuffSecSysRoleMemb > iter = subdictSysRoleIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb > subdictSysRoleIdx
				= new HashMap< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb >();
			dictBySysRoleIdx.put( key, subdictSysRoleIdx );
			recArray = new ISecureSecSysRoleMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSysRoleMemb[] readDerivedByLoginIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.readDerivedByLoginIdx";
		SecureBuffSecSysRoleMembByLoginIdxKey key = (SecureBuffSecSysRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();

		key.setRequiredLoginId( LoginId );
		ISecureSecSysRoleMemb[] recArray;
		if( dictByLoginIdx.containsKey( key ) ) {
			Map< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb > subdictLoginIdx
				= dictByLoginIdx.get( key );
			recArray = new ISecureSecSysRoleMemb[ subdictLoginIdx.size() ];
			Iterator< SecureBuffSecSysRoleMemb > iter = subdictLoginIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb > subdictLoginIdx
				= new HashMap< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb >();
			dictByLoginIdx.put( key, subdictLoginIdx );
			recArray = new ISecureSecSysRoleMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSysRoleMemb readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.readDerivedByIdIdx() ";
		SecureBuffSecSysRoleMembPKey key = (SecureBuffSecSysRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newPKey());
		key.setRequiredSecSysRoleId( SecSysRoleId );
		key.setRequiredLoginId( LoginId );
		ISecureSecSysRoleMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleMemb readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String LoginId )
	{
		SecureBuffSecSysRoleMembPKey key = (SecureBuffSecSysRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newPKey());
		key.setRequiredSecSysRoleId( SecSysRoleId );
		key.setRequiredLoginId( LoginId );
		return( readRec( Authorization, key ) );
	}

	@Override
	public ISecureSecSysRoleMemb readRec( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.readRec";
		ISecureSecSysRoleMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysRoleMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleMemb lockRec( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecSysRoleMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysRoleMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleMemb[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.readAllRec";
		ISecureSecSysRoleMemb buff;
		ArrayList<ISecureSecSysRoleMemb> filteredList = new ArrayList<ISecureSecSysRoleMemb>();
		ISecureSecSysRoleMemb[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRoleMemb.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysRoleMemb[0] ) );
	}

	/**
	 *	Read a page of all the specific SecSysRoleMemb buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysRoleMemb instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecSysRoleMemb[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecSysRoleMemb readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.readRecByIdIdx() ";
		ISecureSecSysRoleMemb buff = readDerivedByIdIdx( Authorization,
			SecSysRoleId,
			LoginId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRoleMemb.CLASS_CODE ) ) {
			return( (ISecureSecSysRoleMemb)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecSysRoleMemb[] readRecBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.readRecBySysRoleIdx() ";
		ISecureSecSysRoleMemb buff;
		ArrayList<ISecureSecSysRoleMemb> filteredList = new ArrayList<ISecureSecSysRoleMemb>();
		ISecureSecSysRoleMemb[] buffList = readDerivedBySysRoleIdx( Authorization,
			SecSysRoleId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRoleMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSysRoleMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysRoleMemb[0] ) );
	}

	@Override
	public ISecureSecSysRoleMemb[] readRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecSysRoleMemb.readRecByLoginIdx() ";
		ISecureSecSysRoleMemb buff;
		ArrayList<ISecureSecSysRoleMemb> filteredList = new ArrayList<ISecureSecSysRoleMemb>();
		ISecureSecSysRoleMemb[] buffList = readDerivedByLoginIdx( Authorization,
			LoginId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRoleMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSysRoleMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysRoleMemb[0] ) );
	}

	/**
	 *	Read a page array of the specific SecSysRoleMemb buffer instances identified by the duplicate key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSysRoleMemb[] pageRecBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecBySysRoleIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecSysRoleMemb buffer instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSysRoleMemb[] pageRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecByLoginIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecSysRoleMemb updateSecSysRoleMemb( ISecureAuthorization Authorization,
		ISecureSecSysRoleMemb iBuff )
	{
		SecureBuffSecSysRoleMemb Buff = (SecureBuffSecSysRoleMemb)ensureRec(iBuff);
		SecureBuffSecSysRoleMembPKey pkey = (SecureBuffSecSysRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newPKey());
		pkey = (SecureBuffSecSysRoleMembPKey)Buff.getPKey();
		SecureBuffSecSysRoleMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecSysRoleMemb",
				"Existing record not found",
				"Existing record not found",
				"SecSysRoleMemb",
				"SecSysRoleMemb",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecSysRoleMemb",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecSysRoleMembBySysRoleIdxKey existingKeySysRoleIdx = (SecureBuffSecSysRoleMembBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		existingKeySysRoleIdx.setRequiredSecSysRoleId( existing.getRequiredSecSysRoleId() );

		SecureBuffSecSysRoleMembBySysRoleIdxKey newKeySysRoleIdx = (SecureBuffSecSysRoleMembBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		newKeySysRoleIdx.setRequiredSecSysRoleId( Buff.getRequiredSecSysRoleId() );

		SecureBuffSecSysRoleMembByLoginIdxKey existingKeyLoginIdx = (SecureBuffSecSysRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
		existingKeyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		SecureBuffSecSysRoleMembByLoginIdxKey newKeyLoginIdx = (SecureBuffSecSysRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
		newKeyLoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecSysRole().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecSysRoleId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecSysRoleMemb",
						"Container",
						"Container",
						"SecSysRoleMembSysRole",
						"SecSysRoleMembSysRole",
						"SecSysRole",
						"SecSysRole",
						null );
				}
			}
		}

		// Update is valid

		Map< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySysRoleIdx.get( existingKeySysRoleIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySysRoleIdx.containsKey( newKeySysRoleIdx ) ) {
			subdict = dictBySysRoleIdx.get( newKeySysRoleIdx );
		}
		else {
			subdict = new HashMap< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb >();
			dictBySysRoleIdx.put( newKeySysRoleIdx, subdict );
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
			subdict = new HashMap< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb >();
			dictByLoginIdx.put( newKeyLoginIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecSysRoleMemb( ISecureAuthorization Authorization,
		ISecureSecSysRoleMemb iBuff )
	{
		final String S_ProcName = "SecureRamSecSysRoleMembTable.deleteSecSysRoleMemb() ";
		SecureBuffSecSysRoleMemb Buff = (SecureBuffSecSysRoleMemb)ensureRec(iBuff);
		int classCode;
		SecureBuffSecSysRoleMembPKey pkey = (SecureBuffSecSysRoleMembPKey)(Buff.getPKey());
		SecureBuffSecSysRoleMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecSysRoleMemb",
				pkey );
		}
		SecureBuffSecSysRoleMembBySysRoleIdxKey keySysRoleIdx = (SecureBuffSecSysRoleMembBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		keySysRoleIdx.setRequiredSecSysRoleId( existing.getRequiredSecSysRoleId() );

		SecureBuffSecSysRoleMembByLoginIdxKey keyLoginIdx = (SecureBuffSecSysRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
		keyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< SecureBuffSecSysRoleMembPKey, SecureBuffSecSysRoleMemb > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySysRoleIdx.get( keySysRoleIdx );
		subdict.remove( pkey );

		subdict = dictByLoginIdx.get( keyLoginIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecSysRoleMembByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String LoginId )
	{
		SecureBuffSecSysRoleMembPKey key = (SecureBuffSecSysRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newPKey());
		key.setRequiredSecSysRoleId( SecSysRoleId );
		key.setRequiredLoginId( LoginId );
		deleteSecSysRoleMembByIdIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysRoleMembByIdIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembPKey PKey )
	{
		SecureBuffSecSysRoleMembPKey key = (SecureBuffSecSysRoleMembPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newPKey());
		key.setRequiredSecSysRoleId( PKey.getRequiredSecSysRoleId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		SecureBuffSecSysRoleMembPKey argKey = key;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecSysRoleMemb cur;
		LinkedList<SecureBuffSecSysRoleMemb> matchSet = new LinkedList<SecureBuffSecSysRoleMemb>();
		Iterator<SecureBuffSecSysRoleMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysRoleMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysRoleMemb)(schema.getTableSecSysRoleMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysRoleId(),
				cur.getRequiredLoginId() ));
			deleteSecSysRoleMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysRoleMembBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecSysRoleId )
	{
		SecureBuffSecSysRoleMembBySysRoleIdxKey key = (SecureBuffSecSysRoleMembBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( argSecSysRoleId );
		deleteSecSysRoleMembBySysRoleIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysRoleMembBySysRoleIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembBySysRoleIdxKey argKey )
	{
		SecureBuffSecSysRoleMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysRoleMemb> matchSet = new LinkedList<SecureBuffSecSysRoleMemb>();
		Iterator<SecureBuffSecSysRoleMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysRoleMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysRoleMemb)(schema.getTableSecSysRoleMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysRoleId(),
				cur.getRequiredLoginId() ));
			deleteSecSysRoleMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysRoleMembByLoginIdx( ISecureAuthorization Authorization,
		String argLoginId )
	{
		SecureBuffSecSysRoleMembByLoginIdxKey key = (SecureBuffSecSysRoleMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( argLoginId );
		deleteSecSysRoleMembByLoginIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysRoleMembByLoginIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleMembByLoginIdxKey argKey )
	{
		SecureBuffSecSysRoleMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysRoleMemb> matchSet = new LinkedList<SecureBuffSecSysRoleMemb>();
		Iterator<SecureBuffSecSysRoleMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysRoleMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysRoleMemb)(schema.getTableSecSysRoleMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysRoleId(),
				cur.getRequiredLoginId() ));
			deleteSecSysRoleMemb( Authorization, cur );
		}
	}
}
