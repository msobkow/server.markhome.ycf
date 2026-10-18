
// Description: Java 25 in-memory RAM DbIO implementation for SecSysGrpMemb.

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
 *	SecureRamSecSysGrpMembTable in-memory RAM DbIO implementation
 *	for SecSysGrpMemb.
 */
public class SecureRamSecSysGrpMembTable
	implements ISecureSecSysGrpMembTable
{
	private ISecureSchema schema;
	private Map< ISecureSecSysGrpMembPKey,
				SecureBuffSecSysGrpMemb > dictByPKey
		= new HashMap< ISecureSecSysGrpMembPKey,
				SecureBuffSecSysGrpMemb >();
	private Map< SecureBuffSecSysGrpMembBySysGrpIdxKey,
				Map< SecureBuffSecSysGrpMembPKey,
					SecureBuffSecSysGrpMemb >> dictBySysGrpIdx
		= new HashMap< SecureBuffSecSysGrpMembBySysGrpIdxKey,
				Map< SecureBuffSecSysGrpMembPKey,
					SecureBuffSecSysGrpMemb >>();
	private Map< SecureBuffSecSysGrpMembByLoginIdxKey,
				Map< SecureBuffSecSysGrpMembPKey,
					SecureBuffSecSysGrpMemb >> dictByLoginIdx
		= new HashMap< SecureBuffSecSysGrpMembByLoginIdxKey,
				Map< SecureBuffSecSysGrpMembPKey,
					SecureBuffSecSysGrpMemb >>();

	public SecureRamSecSysGrpMembTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecSysGrpMemb ensureRec(ISecureSecSysGrpMemb rec) {
		return (((SecureBuffSecSysGrpMembFactoryService)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb())).ensureRec(rec));
	}

	@Override
	public ISecureSecSysGrpMemb createSecSysGrpMemb( ISecureAuthorization Authorization,
		ISecureSecSysGrpMemb iBuff )
	{
		final String S_ProcName = "createSecSysGrpMemb";
		
		SecureBuffSecSysGrpMemb Buff = (SecureBuffSecSysGrpMemb)ensureRec(iBuff);
		SecureBuffSecSysGrpMembPKey pkey = (SecureBuffSecSysGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newPKey());
		pkey.setRequiredSecSysGrpId(Buff.getRequiredSecSysGrpId());
		pkey.setRequiredLoginId(Buff.getRequiredLoginId());
		pkey.setRequiredSecSysGrpId( Buff.getRequiredSecSysGrpId() );
		pkey.setRequiredLoginId( Buff.getRequiredLoginId() );
		Buff.setRequiredContainerGroup( pkey.getRequiredSecSysGrpId() );
		Buff.setRequiredParentUser( pkey.getRequiredLoginId() );
		Buff.setRequiredSecSysGrpId( pkey.getRequiredSecSysGrpId() );
		Buff.setRequiredLoginId( pkey.getRequiredLoginId() );
		SecureBuffSecSysGrpMembBySysGrpIdxKey keySysGrpIdx = (SecureBuffSecSysGrpMembBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		keySysGrpIdx.setRequiredSecSysGrpId( Buff.getRequiredSecSysGrpId() );

		SecureBuffSecSysGrpMembByLoginIdxKey keyLoginIdx = (SecureBuffSecSysGrpMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
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
				if( null == schema.getTableSecSysGrp().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecSysGrpId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SecSysGrpMembGroup",
						"SecSysGrpMembGroup",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb > subdictSysGrpIdx;
		if( dictBySysGrpIdx.containsKey( keySysGrpIdx ) ) {
			subdictSysGrpIdx = dictBySysGrpIdx.get( keySysGrpIdx );
		}
		else {
			subdictSysGrpIdx = new HashMap< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb >();
			dictBySysGrpIdx.put( keySysGrpIdx, subdictSysGrpIdx );
		}
		subdictSysGrpIdx.put( pkey, Buff );

		Map< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb > subdictLoginIdx;
		if( dictByLoginIdx.containsKey( keyLoginIdx ) ) {
			subdictLoginIdx = dictByLoginIdx.get( keyLoginIdx );
		}
		else {
			subdictLoginIdx = new HashMap< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb >();
			dictByLoginIdx.put( keyLoginIdx, subdictLoginIdx );
		}
		subdictLoginIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecSysGrpMemb.CLASS_CODE) {
				SecureBuffSecSysGrpMemb retbuff = ((SecureBuffSecSysGrpMemb)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecSysGrpMemb readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String LoginId )
	{
		{	$implCommaIJavaOptAtomType$ testSecSysGrpId = SecSysGrpId;
			if (testSecSysGrpId == null) {
				return( null );
			}
		}
		{	$implCommaIJavaOptAtomType$ testLoginId = LoginId;
			if (testLoginId == null) {
				return( null );
			}
		}
		SecureBuffSecSysGrpMembPKey key = (SecureBuffSecSysGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newPKey());
		key.setRequiredSecSysGrpId( SecSysGrpId );
		key.setRequiredLoginId( LoginId );
		return( readDerived( Authorization, key ) );
	}

	public ISecureSecSysGrpMemb readDerived( ISecureAuthorization Authorization,
		ISecureSecSysGrpMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.readDerived";
		SecureBuffSecSysGrpMembPKey key = (SecureBuffSecSysGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newPKey());
		key.setRequiredSecSysGrpId( PKey.getRequiredSecSysGrpId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecSysGrpMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpMemb lockDerived( ISecureAuthorization Authorization,
		ISecureSecSysGrpMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.lockDerived";
		SecureBuffSecSysGrpMembPKey key = (SecureBuffSecSysGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newPKey());
		key.setRequiredSecSysGrpId( PKey.getRequiredSecSysGrpId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		ISecureSecSysGrpMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpMemb[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecSysGrpMemb.readAllDerived";
		ISecureSecSysGrpMemb[] retList = new ISecureSecSysGrpMemb[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecSysGrpMemb > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecSysGrpMemb[] readDerivedBySysGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.readDerivedBySysGrpIdx";
		SecureBuffSecSysGrpMembBySysGrpIdxKey key = (SecureBuffSecSysGrpMembBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();

		key.setRequiredSecSysGrpId( SecSysGrpId );
		ISecureSecSysGrpMemb[] recArray;
		if( dictBySysGrpIdx.containsKey( key ) ) {
			Map< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb > subdictSysGrpIdx
				= dictBySysGrpIdx.get( key );
			recArray = new ISecureSecSysGrpMemb[ subdictSysGrpIdx.size() ];
			Iterator< SecureBuffSecSysGrpMemb > iter = subdictSysGrpIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb > subdictSysGrpIdx
				= new HashMap< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb >();
			dictBySysGrpIdx.put( key, subdictSysGrpIdx );
			recArray = new ISecureSecSysGrpMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSysGrpMemb[] readDerivedByLoginIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.readDerivedByLoginIdx";
		SecureBuffSecSysGrpMembByLoginIdxKey key = (SecureBuffSecSysGrpMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();

		key.setRequiredLoginId( LoginId );
		ISecureSecSysGrpMemb[] recArray;
		if( dictByLoginIdx.containsKey( key ) ) {
			Map< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb > subdictLoginIdx
				= dictByLoginIdx.get( key );
			recArray = new ISecureSecSysGrpMemb[ subdictLoginIdx.size() ];
			Iterator< SecureBuffSecSysGrpMemb > iter = subdictLoginIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb > subdictLoginIdx
				= new HashMap< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb >();
			dictByLoginIdx.put( key, subdictLoginIdx );
			recArray = new ISecureSecSysGrpMemb[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSysGrpMemb readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.readDerivedByIdIdx() ";
		SecureBuffSecSysGrpMembPKey key = (SecureBuffSecSysGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newPKey());
		key.setRequiredSecSysGrpId( SecSysGrpId );
		key.setRequiredLoginId( LoginId );
		ISecureSecSysGrpMemb buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpMemb readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String LoginId )
	{
		SecureBuffSecSysGrpMembPKey key = (SecureBuffSecSysGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newPKey());
		key.setRequiredSecSysGrpId( SecSysGrpId );
		key.setRequiredLoginId( LoginId );
		return( readRec( Authorization, key ) );
	}

	@Override
	public ISecureSecSysGrpMemb readRec( ISecureAuthorization Authorization,
		ISecureSecSysGrpMembPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.readRec";
		ISecureSecSysGrpMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysGrpMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpMemb lockRec( ISecureAuthorization Authorization,
		ISecureSecSysGrpMembPKey PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecSysGrpMemb buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysGrpMemb.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpMemb[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.readAllRec";
		ISecureSecSysGrpMemb buff;
		ArrayList<ISecureSecSysGrpMemb> filteredList = new ArrayList<ISecureSecSysGrpMemb>();
		ISecureSecSysGrpMemb[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrpMemb.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysGrpMemb[0] ) );
	}

	/**
	 *	Read a page of all the specific SecSysGrpMemb buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysGrpMemb instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecSysGrpMemb[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecSysGrpMemb readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.readRecByIdIdx() ";
		ISecureSecSysGrpMemb buff = readDerivedByIdIdx( Authorization,
			SecSysGrpId,
			LoginId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrpMemb.CLASS_CODE ) ) {
			return( (ISecureSecSysGrpMemb)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecSysGrpMemb[] readRecBySysGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.readRecBySysGrpIdx() ";
		ISecureSecSysGrpMemb buff;
		ArrayList<ISecureSecSysGrpMemb> filteredList = new ArrayList<ISecureSecSysGrpMemb>();
		ISecureSecSysGrpMemb[] buffList = readDerivedBySysGrpIdx( Authorization,
			SecSysGrpId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrpMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSysGrpMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysGrpMemb[0] ) );
	}

	@Override
	public ISecureSecSysGrpMemb[] readRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId )
	{
		final String S_ProcName = "SecureRamSecSysGrpMemb.readRecByLoginIdx() ";
		ISecureSecSysGrpMemb buff;
		ArrayList<ISecureSecSysGrpMemb> filteredList = new ArrayList<ISecureSecSysGrpMemb>();
		ISecureSecSysGrpMemb[] buffList = readDerivedByLoginIdx( Authorization,
			LoginId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrpMemb.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSysGrpMemb)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysGrpMemb[0] ) );
	}

	/**
	 *	Read a page array of the specific SecSysGrpMemb buffer instances identified by the duplicate key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSysGrpMemb[] pageRecBySysGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecBySysGrpIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecSysGrpMemb buffer instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSysGrpMemb[] pageRecByLoginIdx( ISecureAuthorization Authorization,
		String LoginId,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageRecByLoginIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecSysGrpMemb updateSecSysGrpMemb( ISecureAuthorization Authorization,
		ISecureSecSysGrpMemb iBuff )
	{
		SecureBuffSecSysGrpMemb Buff = (SecureBuffSecSysGrpMemb)ensureRec(iBuff);
		SecureBuffSecSysGrpMembPKey pkey = (SecureBuffSecSysGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newPKey());
		pkey = (SecureBuffSecSysGrpMembPKey)Buff.getPKey();
		SecureBuffSecSysGrpMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecSysGrpMemb",
				"Existing record not found",
				"Existing record not found",
				"SecSysGrpMemb",
				"SecSysGrpMemb",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecSysGrpMemb",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecSysGrpMembBySysGrpIdxKey existingKeySysGrpIdx = (SecureBuffSecSysGrpMembBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		existingKeySysGrpIdx.setRequiredSecSysGrpId( existing.getRequiredSecSysGrpId() );

		SecureBuffSecSysGrpMembBySysGrpIdxKey newKeySysGrpIdx = (SecureBuffSecSysGrpMembBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		newKeySysGrpIdx.setRequiredSecSysGrpId( Buff.getRequiredSecSysGrpId() );

		SecureBuffSecSysGrpMembByLoginIdxKey existingKeyLoginIdx = (SecureBuffSecSysGrpMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
		existingKeyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		SecureBuffSecSysGrpMembByLoginIdxKey newKeyLoginIdx = (SecureBuffSecSysGrpMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
		newKeyLoginIdx.setRequiredLoginId( Buff.getRequiredLoginId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecSysGrp().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecSysGrpId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecSysGrpMemb",
						"Container",
						"Container",
						"SecSysGrpMembGroup",
						"SecSysGrpMembGroup",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Update is valid

		Map< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySysGrpIdx.get( existingKeySysGrpIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySysGrpIdx.containsKey( newKeySysGrpIdx ) ) {
			subdict = dictBySysGrpIdx.get( newKeySysGrpIdx );
		}
		else {
			subdict = new HashMap< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb >();
			dictBySysGrpIdx.put( newKeySysGrpIdx, subdict );
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
			subdict = new HashMap< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb >();
			dictByLoginIdx.put( newKeyLoginIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecSysGrpMemb( ISecureAuthorization Authorization,
		ISecureSecSysGrpMemb iBuff )
	{
		final String S_ProcName = "SecureRamSecSysGrpMembTable.deleteSecSysGrpMemb() ";
		SecureBuffSecSysGrpMemb Buff = (SecureBuffSecSysGrpMemb)ensureRec(iBuff);
		int classCode;
		SecureBuffSecSysGrpMembPKey pkey = (SecureBuffSecSysGrpMembPKey)(Buff.getPKey());
		SecureBuffSecSysGrpMemb existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecSysGrpMemb",
				pkey );
		}
		SecureBuffSecSysGrpMembBySysGrpIdxKey keySysGrpIdx = (SecureBuffSecSysGrpMembBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		keySysGrpIdx.setRequiredSecSysGrpId( existing.getRequiredSecSysGrpId() );

		SecureBuffSecSysGrpMembByLoginIdxKey keyLoginIdx = (SecureBuffSecSysGrpMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
		keyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< SecureBuffSecSysGrpMembPKey, SecureBuffSecSysGrpMemb > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySysGrpIdx.get( keySysGrpIdx );
		subdict.remove( pkey );

		subdict = dictByLoginIdx.get( keyLoginIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecSysGrpMembByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String LoginId )
	{
		SecureBuffSecSysGrpMembPKey key = (SecureBuffSecSysGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newPKey());
		key.setRequiredSecSysGrpId( SecSysGrpId );
		key.setRequiredLoginId( LoginId );
		deleteSecSysGrpMembByIdIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysGrpMembByIdIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpMembPKey PKey )
	{
		SecureBuffSecSysGrpMembPKey key = (SecureBuffSecSysGrpMembPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newPKey());
		key.setRequiredSecSysGrpId( PKey.getRequiredSecSysGrpId() );
		key.setRequiredLoginId( PKey.getRequiredLoginId() );
		SecureBuffSecSysGrpMembPKey argKey = key;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecSysGrpMemb cur;
		LinkedList<SecureBuffSecSysGrpMemb> matchSet = new LinkedList<SecureBuffSecSysGrpMemb>();
		Iterator<SecureBuffSecSysGrpMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysGrpMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysGrpMemb)(schema.getTableSecSysGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysGrpId(),
				cur.getRequiredLoginId() ));
			deleteSecSysGrpMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysGrpMembBySysGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecSysGrpId )
	{
		SecureBuffSecSysGrpMembBySysGrpIdxKey key = (SecureBuffSecSysGrpMembBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		key.setRequiredSecSysGrpId( argSecSysGrpId );
		deleteSecSysGrpMembBySysGrpIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysGrpMembBySysGrpIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpMembBySysGrpIdxKey argKey )
	{
		SecureBuffSecSysGrpMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysGrpMemb> matchSet = new LinkedList<SecureBuffSecSysGrpMemb>();
		Iterator<SecureBuffSecSysGrpMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysGrpMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysGrpMemb)(schema.getTableSecSysGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysGrpId(),
				cur.getRequiredLoginId() ));
			deleteSecSysGrpMemb( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysGrpMembByLoginIdx( ISecureAuthorization Authorization,
		String argLoginId )
	{
		SecureBuffSecSysGrpMembByLoginIdxKey key = (SecureBuffSecSysGrpMembByLoginIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
		key.setRequiredLoginId( argLoginId );
		deleteSecSysGrpMembByLoginIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysGrpMembByLoginIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpMembByLoginIdxKey argKey )
	{
		SecureBuffSecSysGrpMemb cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysGrpMemb> matchSet = new LinkedList<SecureBuffSecSysGrpMemb>();
		Iterator<SecureBuffSecSysGrpMemb> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysGrpMemb> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysGrpMemb)(schema.getTableSecSysGrpMemb().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysGrpId(),
				cur.getRequiredLoginId() ));
			deleteSecSysGrpMemb( Authorization, cur );
		}
	}
}
