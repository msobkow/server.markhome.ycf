
// Description: Java 25 in-memory RAM DbIO implementation for SecSysGrpInc.

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
 *	SecureRamSecSysGrpIncTable in-memory RAM DbIO implementation
 *	for SecSysGrpInc.
 */
public class SecureRamSecSysGrpIncTable
	implements ISecureSecSysGrpIncTable
{
	private ISecureSchema schema;
	private Map< ISecureSecSysGrpIncPKey,
				SecureBuffSecSysGrpInc > dictByPKey
		= new HashMap< ISecureSecSysGrpIncPKey,
				SecureBuffSecSysGrpInc >();
	private Map< SecureBuffSecSysGrpIncBySysGrpIdxKey,
				Map< SecureBuffSecSysGrpIncPKey,
					SecureBuffSecSysGrpInc >> dictBySysGrpIdx
		= new HashMap< SecureBuffSecSysGrpIncBySysGrpIdxKey,
				Map< SecureBuffSecSysGrpIncPKey,
					SecureBuffSecSysGrpInc >>();
	private Map< SecureBuffSecSysGrpIncByNameIdxKey,
				Map< SecureBuffSecSysGrpIncPKey,
					SecureBuffSecSysGrpInc >> dictByNameIdx
		= new HashMap< SecureBuffSecSysGrpIncByNameIdxKey,
				Map< SecureBuffSecSysGrpIncPKey,
					SecureBuffSecSysGrpInc >>();

	public SecureRamSecSysGrpIncTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecSysGrpInc ensureRec(ISecureSecSysGrpInc rec) {
		return (((SecureBuffSecSysGrpIncFactoryService)(schema.getSecureBuffFactory().getFactorySecSysGrpInc())).ensureRec(rec));
	}

	@Override
	public ISecureSecSysGrpInc createSecSysGrpInc( ISecureAuthorization Authorization,
		ISecureSecSysGrpInc iBuff )
	{
		final String S_ProcName = "createSecSysGrpInc";
		
		SecureBuffSecSysGrpInc Buff = (SecureBuffSecSysGrpInc)ensureRec(iBuff);
		SecureBuffSecSysGrpIncPKey pkey = (SecureBuffSecSysGrpIncPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newPKey());
		pkey.setRequiredSecSysGrpId(Buff.getRequiredSecSysGrpId());
		pkey.setRequiredInclName(Buff.getRequiredInclName());
		pkey.setRequiredSecSysGrpId( Buff.getRequiredSecSysGrpId() );
		pkey.setRequiredInclName( Buff.getRequiredInclName() );
		Buff.setRequiredContainerGroup( pkey.getRequiredSecSysGrpId() );
		Buff.setRequiredParentSubGroup( pkey.getRequiredInclName() );
		Buff.setRequiredSecSysGrpId( pkey.getRequiredSecSysGrpId() );
		Buff.setRequiredInclName( pkey.getRequiredInclName() );
		SecureBuffSecSysGrpIncBySysGrpIdxKey keySysGrpIdx = (SecureBuffSecSysGrpIncBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newBySysGrpIdxKey();
		keySysGrpIdx.setRequiredSecSysGrpId( Buff.getRequiredSecSysGrpId() );

		SecureBuffSecSysGrpIncByNameIdxKey keyNameIdx = (SecureBuffSecSysGrpIncByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newByNameIdxKey();
		keyNameIdx.setRequiredInclName( Buff.getRequiredInclName() );

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
						"SecSysGrpIncGroup",
						"SecSysGrpIncGroup",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc > subdictSysGrpIdx;
		if( dictBySysGrpIdx.containsKey( keySysGrpIdx ) ) {
			subdictSysGrpIdx = dictBySysGrpIdx.get( keySysGrpIdx );
		}
		else {
			subdictSysGrpIdx = new HashMap< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc >();
			dictBySysGrpIdx.put( keySysGrpIdx, subdictSysGrpIdx );
		}
		subdictSysGrpIdx.put( pkey, Buff );

		Map< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc > subdictNameIdx;
		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			subdictNameIdx = dictByNameIdx.get( keyNameIdx );
		}
		else {
			subdictNameIdx = new HashMap< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc >();
			dictByNameIdx.put( keyNameIdx, subdictNameIdx );
		}
		subdictNameIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecSysGrpInc.CLASS_CODE) {
				SecureBuffSecSysGrpInc retbuff = ((SecureBuffSecSysGrpInc)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecSysGrpInc readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName )
	{
		{	$implCommaIJavaOptAtomType$ testSecSysGrpId = SecSysGrpId;
			if (testSecSysGrpId == null) {
				return( null );
			}
		}
		{	$implCommaIJavaOptAtomType$ testInclName = InclName;
			if (testInclName == null) {
				return( null );
			}
		}
		SecureBuffSecSysGrpIncPKey key = (SecureBuffSecSysGrpIncPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newPKey());
		key.setRequiredSecSysGrpId( SecSysGrpId );
		key.setRequiredInclName( InclName );
		return( readDerived( Authorization, key ) );
	}

	public ISecureSecSysGrpInc readDerived( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.readDerived";
		SecureBuffSecSysGrpIncPKey key = (SecureBuffSecSysGrpIncPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newPKey());
		key.setRequiredSecSysGrpId( PKey.getRequiredSecSysGrpId() );
		key.setRequiredInclName( PKey.getRequiredInclName() );
		ISecureSecSysGrpInc buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpInc lockDerived( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.lockDerived";
		SecureBuffSecSysGrpIncPKey key = (SecureBuffSecSysGrpIncPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newPKey());
		key.setRequiredSecSysGrpId( PKey.getRequiredSecSysGrpId() );
		key.setRequiredInclName( PKey.getRequiredInclName() );
		ISecureSecSysGrpInc buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpInc[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecSysGrpInc.readAllDerived";
		ISecureSecSysGrpInc[] retList = new ISecureSecSysGrpInc[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecSysGrpInc > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecSysGrpInc[] readDerivedBySysGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.readDerivedBySysGrpIdx";
		SecureBuffSecSysGrpIncBySysGrpIdxKey key = (SecureBuffSecSysGrpIncBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newBySysGrpIdxKey();

		key.setRequiredSecSysGrpId( SecSysGrpId );
		ISecureSecSysGrpInc[] recArray;
		if( dictBySysGrpIdx.containsKey( key ) ) {
			Map< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc > subdictSysGrpIdx
				= dictBySysGrpIdx.get( key );
			recArray = new ISecureSecSysGrpInc[ subdictSysGrpIdx.size() ];
			Iterator< SecureBuffSecSysGrpInc > iter = subdictSysGrpIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc > subdictSysGrpIdx
				= new HashMap< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc >();
			dictBySysGrpIdx.put( key, subdictSysGrpIdx );
			recArray = new ISecureSecSysGrpInc[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSysGrpInc[] readDerivedByNameIdx( ISecureAuthorization Authorization,
		String InclName )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.readDerivedByNameIdx";
		SecureBuffSecSysGrpIncByNameIdxKey key = (SecureBuffSecSysGrpIncByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newByNameIdxKey();

		key.setRequiredInclName( InclName );
		ISecureSecSysGrpInc[] recArray;
		if( dictByNameIdx.containsKey( key ) ) {
			Map< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc > subdictNameIdx
				= dictByNameIdx.get( key );
			recArray = new ISecureSecSysGrpInc[ subdictNameIdx.size() ];
			Iterator< SecureBuffSecSysGrpInc > iter = subdictNameIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc > subdictNameIdx
				= new HashMap< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc >();
			dictByNameIdx.put( key, subdictNameIdx );
			recArray = new ISecureSecSysGrpInc[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSysGrpInc readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.readDerivedByIdIdx() ";
		SecureBuffSecSysGrpIncPKey key = (SecureBuffSecSysGrpIncPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newPKey());
		key.setRequiredSecSysGrpId( SecSysGrpId );
		key.setRequiredInclName( InclName );
		ISecureSecSysGrpInc buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpInc readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName )
	{
		SecureBuffSecSysGrpIncPKey key = (SecureBuffSecSysGrpIncPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newPKey());
		key.setRequiredSecSysGrpId( SecSysGrpId );
		key.setRequiredInclName( InclName );
		return( readRec( Authorization, key ) );
	}

	@Override
	public ISecureSecSysGrpInc readRec( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.readRec";
		ISecureSecSysGrpInc buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysGrpInc.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpInc lockRec( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecSysGrpInc buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysGrpInc.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrpInc[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.readAllRec";
		ISecureSecSysGrpInc buff;
		ArrayList<ISecureSecSysGrpInc> filteredList = new ArrayList<ISecureSecSysGrpInc>();
		ISecureSecSysGrpInc[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrpInc.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysGrpInc[0] ) );
	}

	/**
	 *	Read a page of all the specific SecSysGrpInc buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysGrpInc instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecSysGrpInc[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorInclName )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecSysGrpInc readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.readRecByIdIdx() ";
		ISecureSecSysGrpInc buff = readDerivedByIdIdx( Authorization,
			SecSysGrpId,
			InclName );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrpInc.CLASS_CODE ) ) {
			return( (ISecureSecSysGrpInc)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecSysGrpInc[] readRecBySysGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.readRecBySysGrpIdx() ";
		ISecureSecSysGrpInc buff;
		ArrayList<ISecureSecSysGrpInc> filteredList = new ArrayList<ISecureSecSysGrpInc>();
		ISecureSecSysGrpInc[] buffList = readDerivedBySysGrpIdx( Authorization,
			SecSysGrpId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrpInc.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSysGrpInc)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysGrpInc[0] ) );
	}

	@Override
	public ISecureSecSysGrpInc[] readRecByNameIdx( ISecureAuthorization Authorization,
		String InclName )
	{
		final String S_ProcName = "SecureRamSecSysGrpInc.readRecByNameIdx() ";
		ISecureSecSysGrpInc buff;
		ArrayList<ISecureSecSysGrpInc> filteredList = new ArrayList<ISecureSecSysGrpInc>();
		ISecureSecSysGrpInc[] buffList = readDerivedByNameIdx( Authorization,
			InclName );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrpInc.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSysGrpInc)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysGrpInc[0] ) );
	}

	/**
	 *	Read a page array of the specific SecSysGrpInc buffer instances identified by the duplicate key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSysGrpInc[] pageRecBySysGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorInclName )
	{
		final String S_ProcName = "pageRecBySysGrpIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecSysGrpInc buffer instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecSysGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSysGrpInc[] pageRecByNameIdx( ISecureAuthorization Authorization,
		String InclName,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorInclName )
	{
		final String S_ProcName = "pageRecByNameIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecSysGrpInc updateSecSysGrpInc( ISecureAuthorization Authorization,
		ISecureSecSysGrpInc iBuff )
	{
		SecureBuffSecSysGrpInc Buff = (SecureBuffSecSysGrpInc)ensureRec(iBuff);
		SecureBuffSecSysGrpIncPKey pkey = (SecureBuffSecSysGrpIncPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newPKey());
		pkey = (SecureBuffSecSysGrpIncPKey)Buff.getPKey();
		SecureBuffSecSysGrpInc existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecSysGrpInc",
				"Existing record not found",
				"Existing record not found",
				"SecSysGrpInc",
				"SecSysGrpInc",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecSysGrpInc",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecSysGrpIncBySysGrpIdxKey existingKeySysGrpIdx = (SecureBuffSecSysGrpIncBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newBySysGrpIdxKey();
		existingKeySysGrpIdx.setRequiredSecSysGrpId( existing.getRequiredSecSysGrpId() );

		SecureBuffSecSysGrpIncBySysGrpIdxKey newKeySysGrpIdx = (SecureBuffSecSysGrpIncBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newBySysGrpIdxKey();
		newKeySysGrpIdx.setRequiredSecSysGrpId( Buff.getRequiredSecSysGrpId() );

		SecureBuffSecSysGrpIncByNameIdxKey existingKeyNameIdx = (SecureBuffSecSysGrpIncByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newByNameIdxKey();
		existingKeyNameIdx.setRequiredInclName( existing.getRequiredInclName() );

		SecureBuffSecSysGrpIncByNameIdxKey newKeyNameIdx = (SecureBuffSecSysGrpIncByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newByNameIdxKey();
		newKeyNameIdx.setRequiredInclName( Buff.getRequiredInclName() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecSysGrp().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecSysGrpId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecSysGrpInc",
						"Container",
						"Container",
						"SecSysGrpIncGroup",
						"SecSysGrpIncGroup",
						"SecSysGrp",
						"SecSysGrp",
						null );
				}
			}
		}

		// Update is valid

		Map< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc > subdict;

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
			subdict = new HashMap< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc >();
			dictBySysGrpIdx.put( newKeySysGrpIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByNameIdx.get( existingKeyNameIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
			subdict = dictByNameIdx.get( newKeyNameIdx );
		}
		else {
			subdict = new HashMap< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc >();
			dictByNameIdx.put( newKeyNameIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecSysGrpInc( ISecureAuthorization Authorization,
		ISecureSecSysGrpInc iBuff )
	{
		final String S_ProcName = "SecureRamSecSysGrpIncTable.deleteSecSysGrpInc() ";
		SecureBuffSecSysGrpInc Buff = (SecureBuffSecSysGrpInc)ensureRec(iBuff);
		int classCode;
		SecureBuffSecSysGrpIncPKey pkey = (SecureBuffSecSysGrpIncPKey)(Buff.getPKey());
		SecureBuffSecSysGrpInc existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecSysGrpInc",
				pkey );
		}
		SecureBuffSecSysGrpIncBySysGrpIdxKey keySysGrpIdx = (SecureBuffSecSysGrpIncBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newBySysGrpIdxKey();
		keySysGrpIdx.setRequiredSecSysGrpId( existing.getRequiredSecSysGrpId() );

		SecureBuffSecSysGrpIncByNameIdxKey keyNameIdx = (SecureBuffSecSysGrpIncByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newByNameIdxKey();
		keyNameIdx.setRequiredInclName( existing.getRequiredInclName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< SecureBuffSecSysGrpIncPKey, SecureBuffSecSysGrpInc > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySysGrpIdx.get( keySysGrpIdx );
		subdict.remove( pkey );

		subdict = dictByNameIdx.get( keyNameIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecSysGrpIncByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId,
		String InclName )
	{
		SecureBuffSecSysGrpIncPKey key = (SecureBuffSecSysGrpIncPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newPKey());
		key.setRequiredSecSysGrpId( SecSysGrpId );
		key.setRequiredInclName( InclName );
		deleteSecSysGrpIncByIdIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysGrpIncByIdIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncPKey PKey )
	{
		SecureBuffSecSysGrpIncPKey key = (SecureBuffSecSysGrpIncPKey)(schema.getSecureBuffFactory().getFactorySecSysGrpInc().newPKey());
		key.setRequiredSecSysGrpId( PKey.getRequiredSecSysGrpId() );
		key.setRequiredInclName( PKey.getRequiredInclName() );
		SecureBuffSecSysGrpIncPKey argKey = key;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecSysGrpInc cur;
		LinkedList<SecureBuffSecSysGrpInc> matchSet = new LinkedList<SecureBuffSecSysGrpInc>();
		Iterator<SecureBuffSecSysGrpInc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysGrpInc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysGrpInc)(schema.getTableSecSysGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysGrpId(),
				cur.getRequiredInclName() ));
			deleteSecSysGrpInc( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysGrpIncBySysGrpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecSysGrpId )
	{
		SecureBuffSecSysGrpIncBySysGrpIdxKey key = (SecureBuffSecSysGrpIncBySysGrpIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newBySysGrpIdxKey();
		key.setRequiredSecSysGrpId( argSecSysGrpId );
		deleteSecSysGrpIncBySysGrpIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysGrpIncBySysGrpIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncBySysGrpIdxKey argKey )
	{
		SecureBuffSecSysGrpInc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysGrpInc> matchSet = new LinkedList<SecureBuffSecSysGrpInc>();
		Iterator<SecureBuffSecSysGrpInc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysGrpInc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysGrpInc)(schema.getTableSecSysGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysGrpId(),
				cur.getRequiredInclName() ));
			deleteSecSysGrpInc( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysGrpIncByNameIdx( ISecureAuthorization Authorization,
		String argInclName )
	{
		SecureBuffSecSysGrpIncByNameIdxKey key = (SecureBuffSecSysGrpIncByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrpInc().newByNameIdxKey();
		key.setRequiredInclName( argInclName );
		deleteSecSysGrpIncByNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysGrpIncByNameIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpIncByNameIdxKey argKey )
	{
		SecureBuffSecSysGrpInc cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysGrpInc> matchSet = new LinkedList<SecureBuffSecSysGrpInc>();
		Iterator<SecureBuffSecSysGrpInc> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysGrpInc> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysGrpInc)(schema.getTableSecSysGrpInc().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysGrpId(),
				cur.getRequiredInclName() ));
			deleteSecSysGrpInc( Authorization, cur );
		}
	}
}
