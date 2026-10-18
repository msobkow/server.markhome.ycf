
// Description: Java 25 in-memory RAM DbIO implementation for SecSysRoleEnables.

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
 *	SecureRamSecSysRoleEnablesTable in-memory RAM DbIO implementation
 *	for SecSysRoleEnables.
 */
public class SecureRamSecSysRoleEnablesTable
	implements ISecureSecSysRoleEnablesTable
{
	private ISecureSchema schema;
	private Map< ISecureSecSysRoleEnablesPKey,
				SecureBuffSecSysRoleEnables > dictByPKey
		= new HashMap< ISecureSecSysRoleEnablesPKey,
				SecureBuffSecSysRoleEnables >();
	private Map< SecureBuffSecSysRoleEnablesBySysRoleIdxKey,
				Map< SecureBuffSecSysRoleEnablesPKey,
					SecureBuffSecSysRoleEnables >> dictBySysRoleIdx
		= new HashMap< SecureBuffSecSysRoleEnablesBySysRoleIdxKey,
				Map< SecureBuffSecSysRoleEnablesPKey,
					SecureBuffSecSysRoleEnables >>();
	private Map< SecureBuffSecSysRoleEnablesByNameIdxKey,
				Map< SecureBuffSecSysRoleEnablesPKey,
					SecureBuffSecSysRoleEnables >> dictByNameIdx
		= new HashMap< SecureBuffSecSysRoleEnablesByNameIdxKey,
				Map< SecureBuffSecSysRoleEnablesPKey,
					SecureBuffSecSysRoleEnables >>();

	public SecureRamSecSysRoleEnablesTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecSysRoleEnables ensureRec(ISecureSecSysRoleEnables rec) {
		return (((SecureBuffSecSysRoleEnablesFactoryService)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables())).ensureRec(rec));
	}

	@Override
	public ISecureSecSysRoleEnables createSecSysRoleEnables( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnables iBuff )
	{
		final String S_ProcName = "createSecSysRoleEnables";
		
		SecureBuffSecSysRoleEnables Buff = (SecureBuffSecSysRoleEnables)ensureRec(iBuff);
		SecureBuffSecSysRoleEnablesPKey pkey = (SecureBuffSecSysRoleEnablesPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newPKey());
		pkey.setRequiredSecSysRoleId(Buff.getRequiredSecSysRoleId());
		pkey.setRequiredEnableName(Buff.getRequiredEnableName());
		pkey.setRequiredSecSysRoleId( Buff.getRequiredSecSysRoleId() );
		pkey.setRequiredEnableName( Buff.getRequiredEnableName() );
		Buff.setRequiredContainerSysRole( pkey.getRequiredSecSysRoleId() );
		Buff.setRequiredParentEnableGroup( pkey.getRequiredEnableName() );
		Buff.setRequiredSecSysRoleId( pkey.getRequiredSecSysRoleId() );
		Buff.setRequiredEnableName( pkey.getRequiredEnableName() );
		SecureBuffSecSysRoleEnablesBySysRoleIdxKey keySysRoleIdx = (SecureBuffSecSysRoleEnablesBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		keySysRoleIdx.setRequiredSecSysRoleId( Buff.getRequiredSecSysRoleId() );

		SecureBuffSecSysRoleEnablesByNameIdxKey keyNameIdx = (SecureBuffSecSysRoleEnablesByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		keyNameIdx.setRequiredEnableName( Buff.getRequiredEnableName() );

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
						"SecSysRoleEnablesSysRole",
						"SecSysRoleEnablesSysRole",
						"SecSysRole",
						"SecSysRole",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables > subdictSysRoleIdx;
		if( dictBySysRoleIdx.containsKey( keySysRoleIdx ) ) {
			subdictSysRoleIdx = dictBySysRoleIdx.get( keySysRoleIdx );
		}
		else {
			subdictSysRoleIdx = new HashMap< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables >();
			dictBySysRoleIdx.put( keySysRoleIdx, subdictSysRoleIdx );
		}
		subdictSysRoleIdx.put( pkey, Buff );

		Map< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables > subdictNameIdx;
		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			subdictNameIdx = dictByNameIdx.get( keyNameIdx );
		}
		else {
			subdictNameIdx = new HashMap< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables >();
			dictByNameIdx.put( keyNameIdx, subdictNameIdx );
		}
		subdictNameIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecSysRoleEnables.CLASS_CODE) {
				SecureBuffSecSysRoleEnables retbuff = ((SecureBuffSecSysRoleEnables)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecSysRoleEnables readDerived( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String EnableName )
	{
		{	$implCommaIJavaOptAtomType$ testSecSysRoleId = SecSysRoleId;
			if (testSecSysRoleId == null) {
				return( null );
			}
		}
		{	$implCommaIJavaOptAtomType$ testEnableName = EnableName;
			if (testEnableName == null) {
				return( null );
			}
		}
		SecureBuffSecSysRoleEnablesPKey key = (SecureBuffSecSysRoleEnablesPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newPKey());
		key.setRequiredSecSysRoleId( SecSysRoleId );
		key.setRequiredEnableName( EnableName );
		return( readDerived( Authorization, key ) );
	}

	public ISecureSecSysRoleEnables readDerived( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnablesPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.readDerived";
		SecureBuffSecSysRoleEnablesPKey key = (SecureBuffSecSysRoleEnablesPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newPKey());
		key.setRequiredSecSysRoleId( PKey.getRequiredSecSysRoleId() );
		key.setRequiredEnableName( PKey.getRequiredEnableName() );
		ISecureSecSysRoleEnables buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleEnables lockDerived( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnablesPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.lockDerived";
		SecureBuffSecSysRoleEnablesPKey key = (SecureBuffSecSysRoleEnablesPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newPKey());
		key.setRequiredSecSysRoleId( PKey.getRequiredSecSysRoleId() );
		key.setRequiredEnableName( PKey.getRequiredEnableName() );
		ISecureSecSysRoleEnables buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleEnables[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecSysRoleEnables.readAllDerived";
		ISecureSecSysRoleEnables[] retList = new ISecureSecSysRoleEnables[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecSysRoleEnables > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecSysRoleEnables[] readDerivedBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.readDerivedBySysRoleIdx";
		SecureBuffSecSysRoleEnablesBySysRoleIdxKey key = (SecureBuffSecSysRoleEnablesBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();

		key.setRequiredSecSysRoleId( SecSysRoleId );
		ISecureSecSysRoleEnables[] recArray;
		if( dictBySysRoleIdx.containsKey( key ) ) {
			Map< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables > subdictSysRoleIdx
				= dictBySysRoleIdx.get( key );
			recArray = new ISecureSecSysRoleEnables[ subdictSysRoleIdx.size() ];
			Iterator< SecureBuffSecSysRoleEnables > iter = subdictSysRoleIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables > subdictSysRoleIdx
				= new HashMap< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables >();
			dictBySysRoleIdx.put( key, subdictSysRoleIdx );
			recArray = new ISecureSecSysRoleEnables[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSysRoleEnables[] readDerivedByNameIdx( ISecureAuthorization Authorization,
		String EnableName )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.readDerivedByNameIdx";
		SecureBuffSecSysRoleEnablesByNameIdxKey key = (SecureBuffSecSysRoleEnablesByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newByNameIdxKey();

		key.setRequiredEnableName( EnableName );
		ISecureSecSysRoleEnables[] recArray;
		if( dictByNameIdx.containsKey( key ) ) {
			Map< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables > subdictNameIdx
				= dictByNameIdx.get( key );
			recArray = new ISecureSecSysRoleEnables[ subdictNameIdx.size() ];
			Iterator< SecureBuffSecSysRoleEnables > iter = subdictNameIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables > subdictNameIdx
				= new HashMap< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables >();
			dictByNameIdx.put( key, subdictNameIdx );
			recArray = new ISecureSecSysRoleEnables[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSysRoleEnables readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String EnableName )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.readDerivedByIdIdx() ";
		SecureBuffSecSysRoleEnablesPKey key = (SecureBuffSecSysRoleEnablesPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newPKey());
		key.setRequiredSecSysRoleId( SecSysRoleId );
		key.setRequiredEnableName( EnableName );
		ISecureSecSysRoleEnables buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleEnables readRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String EnableName )
	{
		SecureBuffSecSysRoleEnablesPKey key = (SecureBuffSecSysRoleEnablesPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newPKey());
		key.setRequiredSecSysRoleId( SecSysRoleId );
		key.setRequiredEnableName( EnableName );
		return( readRec( Authorization, key ) );
	}

	@Override
	public ISecureSecSysRoleEnables readRec( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnablesPKey PKey )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.readRec";
		ISecureSecSysRoleEnables buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysRoleEnables.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleEnables lockRec( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnablesPKey PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecSysRoleEnables buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysRoleEnables.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysRoleEnables[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.readAllRec";
		ISecureSecSysRoleEnables buff;
		ArrayList<ISecureSecSysRoleEnables> filteredList = new ArrayList<ISecureSecSysRoleEnables>();
		ISecureSecSysRoleEnables[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRoleEnables.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysRoleEnables[0] ) );
	}

	/**
	 *	Read a page of all the specific SecSysRoleEnables buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysRoleEnables instances in the database accessible for the Authorization.
	 */
	@Override
	public ISecureSecSysRoleEnables[] pageAllRec( ISecureAuthorization Authorization,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorEnableName )
	{
		final String S_ProcName = "pageAllRec";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecSysRoleEnables readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String EnableName )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.readRecByIdIdx() ";
		ISecureSecSysRoleEnables buff = readDerivedByIdIdx( Authorization,
			SecSysRoleId,
			EnableName );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRoleEnables.CLASS_CODE ) ) {
			return( (ISecureSecSysRoleEnables)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecSysRoleEnables[] readRecBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.readRecBySysRoleIdx() ";
		ISecureSecSysRoleEnables buff;
		ArrayList<ISecureSecSysRoleEnables> filteredList = new ArrayList<ISecureSecSysRoleEnables>();
		ISecureSecSysRoleEnables[] buffList = readDerivedBySysRoleIdx( Authorization,
			SecSysRoleId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRoleEnables.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSysRoleEnables)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysRoleEnables[0] ) );
	}

	@Override
	public ISecureSecSysRoleEnables[] readRecByNameIdx( ISecureAuthorization Authorization,
		String EnableName )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnables.readRecByNameIdx() ";
		ISecureSecSysRoleEnables buff;
		ArrayList<ISecureSecSysRoleEnables> filteredList = new ArrayList<ISecureSecSysRoleEnables>();
		ISecureSecSysRoleEnables[] buffList = readDerivedByNameIdx( Authorization,
			EnableName );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysRoleEnables.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSysRoleEnables)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysRoleEnables[0] ) );
	}

	/**
	 *	Read a page array of the specific SecSysRoleEnables buffer instances identified by the duplicate key SysRoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSysRoleEnables[] pageRecBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorEnableName )
	{
		final String S_ProcName = "pageRecBySysRoleIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Read a page array of the specific SecSysRoleEnables buffer instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EnableName	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	YCFNotSupportedException thrown by client-side implementations.
	 */
	@Override
	public ISecureSecSysRoleEnables[] pageRecByNameIdx( ISecureAuthorization Authorization,
		String EnableName,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorEnableName )
	{
		final String S_ProcName = "pageRecByNameIdx";
		throw new YCFNotImplementedYetException( getClass(), S_ProcName );
	}

	@Override
	public ISecureSecSysRoleEnables updateSecSysRoleEnables( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnables iBuff )
	{
		SecureBuffSecSysRoleEnables Buff = (SecureBuffSecSysRoleEnables)ensureRec(iBuff);
		SecureBuffSecSysRoleEnablesPKey pkey = (SecureBuffSecSysRoleEnablesPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newPKey());
		pkey = (SecureBuffSecSysRoleEnablesPKey)Buff.getPKey();
		SecureBuffSecSysRoleEnables existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecSysRoleEnables",
				"Existing record not found",
				"Existing record not found",
				"SecSysRoleEnables",
				"SecSysRoleEnables",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecSysRoleEnables",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecSysRoleEnablesBySysRoleIdxKey existingKeySysRoleIdx = (SecureBuffSecSysRoleEnablesBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		existingKeySysRoleIdx.setRequiredSecSysRoleId( existing.getRequiredSecSysRoleId() );

		SecureBuffSecSysRoleEnablesBySysRoleIdxKey newKeySysRoleIdx = (SecureBuffSecSysRoleEnablesBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		newKeySysRoleIdx.setRequiredSecSysRoleId( Buff.getRequiredSecSysRoleId() );

		SecureBuffSecSysRoleEnablesByNameIdxKey existingKeyNameIdx = (SecureBuffSecSysRoleEnablesByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		existingKeyNameIdx.setRequiredEnableName( existing.getRequiredEnableName() );

		SecureBuffSecSysRoleEnablesByNameIdxKey newKeyNameIdx = (SecureBuffSecSysRoleEnablesByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		newKeyNameIdx.setRequiredEnableName( Buff.getRequiredEnableName() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecSysRole().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecSysRoleId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecSysRoleEnables",
						"Container",
						"Container",
						"SecSysRoleEnablesSysRole",
						"SecSysRoleEnablesSysRole",
						"SecSysRole",
						"SecSysRole",
						null );
				}
			}
		}

		// Update is valid

		Map< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables > subdict;

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
			subdict = new HashMap< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables >();
			dictBySysRoleIdx.put( newKeySysRoleIdx, subdict );
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
			subdict = new HashMap< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables >();
			dictByNameIdx.put( newKeyNameIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecSysRoleEnables( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnables iBuff )
	{
		final String S_ProcName = "SecureRamSecSysRoleEnablesTable.deleteSecSysRoleEnables() ";
		SecureBuffSecSysRoleEnables Buff = (SecureBuffSecSysRoleEnables)ensureRec(iBuff);
		int classCode;
		SecureBuffSecSysRoleEnablesPKey pkey = (SecureBuffSecSysRoleEnablesPKey)(Buff.getPKey());
		SecureBuffSecSysRoleEnables existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecSysRoleEnables",
				pkey );
		}
		SecureBuffSecSysRoleEnablesBySysRoleIdxKey keySysRoleIdx = (SecureBuffSecSysRoleEnablesBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		keySysRoleIdx.setRequiredSecSysRoleId( existing.getRequiredSecSysRoleId() );

		SecureBuffSecSysRoleEnablesByNameIdxKey keyNameIdx = (SecureBuffSecSysRoleEnablesByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		keyNameIdx.setRequiredEnableName( existing.getRequiredEnableName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< SecureBuffSecSysRoleEnablesPKey, SecureBuffSecSysRoleEnables > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySysRoleIdx.get( keySysRoleIdx );
		subdict.remove( pkey );

		subdict = dictByNameIdx.get( keyNameIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecSysRoleEnablesByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysRoleId,
		String EnableName )
	{
		SecureBuffSecSysRoleEnablesPKey key = (SecureBuffSecSysRoleEnablesPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newPKey());
		key.setRequiredSecSysRoleId( SecSysRoleId );
		key.setRequiredEnableName( EnableName );
		deleteSecSysRoleEnablesByIdIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysRoleEnablesByIdIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnablesPKey PKey )
	{
		SecureBuffSecSysRoleEnablesPKey key = (SecureBuffSecSysRoleEnablesPKey)(schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newPKey());
		key.setRequiredSecSysRoleId( PKey.getRequiredSecSysRoleId() );
		key.setRequiredEnableName( PKey.getRequiredEnableName() );
		SecureBuffSecSysRoleEnablesPKey argKey = key;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecSysRoleEnables cur;
		LinkedList<SecureBuffSecSysRoleEnables> matchSet = new LinkedList<SecureBuffSecSysRoleEnables>();
		Iterator<SecureBuffSecSysRoleEnables> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysRoleEnables> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysRoleEnables)(schema.getTableSecSysRoleEnables().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysRoleId(),
				cur.getRequiredEnableName() ));
			deleteSecSysRoleEnables( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysRoleEnablesBySysRoleIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSecSysRoleId )
	{
		SecureBuffSecSysRoleEnablesBySysRoleIdxKey key = (SecureBuffSecSysRoleEnablesBySysRoleIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( argSecSysRoleId );
		deleteSecSysRoleEnablesBySysRoleIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysRoleEnablesBySysRoleIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnablesBySysRoleIdxKey argKey )
	{
		SecureBuffSecSysRoleEnables cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysRoleEnables> matchSet = new LinkedList<SecureBuffSecSysRoleEnables>();
		Iterator<SecureBuffSecSysRoleEnables> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysRoleEnables> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysRoleEnables)(schema.getTableSecSysRoleEnables().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysRoleId(),
				cur.getRequiredEnableName() ));
			deleteSecSysRoleEnables( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysRoleEnablesByNameIdx( ISecureAuthorization Authorization,
		String argEnableName )
	{
		SecureBuffSecSysRoleEnablesByNameIdxKey key = (SecureBuffSecSysRoleEnablesByNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		key.setRequiredEnableName( argEnableName );
		deleteSecSysRoleEnablesByNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysRoleEnablesByNameIdx( ISecureAuthorization Authorization,
		ISecureSecSysRoleEnablesByNameIdxKey argKey )
	{
		SecureBuffSecSysRoleEnables cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysRoleEnables> matchSet = new LinkedList<SecureBuffSecSysRoleEnables>();
		Iterator<SecureBuffSecSysRoleEnables> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysRoleEnables> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysRoleEnables)(schema.getTableSecSysRoleEnables().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysRoleId(),
				cur.getRequiredEnableName() ));
			deleteSecSysRoleEnables( Authorization, cur );
		}
	}
}
