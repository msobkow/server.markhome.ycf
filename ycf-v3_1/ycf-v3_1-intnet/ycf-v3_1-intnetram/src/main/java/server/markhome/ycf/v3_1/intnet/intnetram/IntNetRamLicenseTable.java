
// Description: Java 25 in-memory RAM DbIO implementation for License.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetram;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

/*
 *	IntNetRamLicenseTable in-memory RAM DbIO implementation
 *	for License.
 */
public class IntNetRamLicenseTable
	implements IIntNetLicenseTable
{
	private IIntNetSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				IntNetBuffLicense > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				IntNetBuffLicense >();
	private Map< IntNetBuffLicenseByLicnTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffLicense >> dictByLicnTenantIdx
		= new HashMap< IntNetBuffLicenseByLicnTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffLicense >>();
	private Map< IntNetBuffLicenseByDomainIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffLicense >> dictByDomainIdx
		= new HashMap< IntNetBuffLicenseByDomainIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					IntNetBuffLicense >>();
	private Map< IntNetBuffLicenseByUNameIdxKey,
			IntNetBuffLicense > dictByUNameIdx
		= new HashMap< IntNetBuffLicenseByUNameIdxKey,
			IntNetBuffLicense >();

	public IntNetRamLicenseTable( IIntNetSchema argSchema ) {
		schema = argSchema;
	}

	public IntNetBuffLicense ensureRec(IIntNetLicense rec) {
		return (((IntNetBuffLicenseFactoryService)(schema.getIntNetBuffFactory().getFactoryLicense())).ensureRec(rec));
	}

	@Override
	public IIntNetLicense createLicense( ISecureAuthorization Authorization,
		IIntNetLicense iBuff )
	{
		final String S_ProcName = "createLicense";
		
		IntNetBuffLicense Buff = (IntNetBuffLicense)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextLicenseIdGen();
		Buff.setRequiredId( pkey );
		IntNetBuffLicenseByLicnTenantIdxKey keyLicnTenantIdx = (IntNetBuffLicenseByLicnTenantIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByLicnTenantIdxKey();
		keyLicnTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffLicenseByDomainIdxKey keyDomainIdx = (IntNetBuffLicenseByDomainIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByDomainIdxKey();
		keyDomainIdx.setRequiredTopDomainId( Buff.getRequiredTopDomainId() );

		IntNetBuffLicenseByUNameIdxKey keyUNameIdx = (IntNetBuffLicenseByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByUNameIdxKey();
		keyUNameIdx.setRequiredTopDomainId( Buff.getRequiredTopDomainId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"LicenseUNameIdx",
				"LicenseUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Owner",
						"Owner",
						"Owner",
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTopDomain().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTopDomainId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"TopDomain",
						"TopDomain",
						"TopDomain",
						"TopDomain",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffLicense > subdictLicnTenantIdx;
		if( dictByLicnTenantIdx.containsKey( keyLicnTenantIdx ) ) {
			subdictLicnTenantIdx = dictByLicnTenantIdx.get( keyLicnTenantIdx );
		}
		else {
			subdictLicnTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffLicense >();
			dictByLicnTenantIdx.put( keyLicnTenantIdx, subdictLicnTenantIdx );
		}
		subdictLicnTenantIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, IntNetBuffLicense > subdictDomainIdx;
		if( dictByDomainIdx.containsKey( keyDomainIdx ) ) {
			subdictDomainIdx = dictByDomainIdx.get( keyDomainIdx );
		}
		else {
			subdictDomainIdx = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffLicense >();
			dictByDomainIdx.put( keyDomainIdx, subdictDomainIdx );
		}
		subdictDomainIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IIntNetLicense.CLASS_CODE) {
				IntNetBuffLicense retbuff = ((IntNetBuffLicense)(schema.getIntNetBuffFactory().getFactoryLicense().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IIntNetLicense readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamLicense.readDerived";
		IIntNetLicense buff;
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
	public IIntNetLicense lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamLicense.lockDerived";
		IIntNetLicense buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetLicense[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "IntNetRamLicense.readAllDerived";
		IIntNetLicense[] retList = new IIntNetLicense[ dictByPKey.values().size() ];
		Iterator< IntNetBuffLicense > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IIntNetLicense[] readDerivedByLicnTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamLicense.readDerivedByLicnTenantIdx";
		IntNetBuffLicenseByLicnTenantIdxKey key = (IntNetBuffLicenseByLicnTenantIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByLicnTenantIdxKey();

		key.setRequiredTenantId( TenantId );
		IIntNetLicense[] recArray;
		if( dictByLicnTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffLicense > subdictLicnTenantIdx
				= dictByLicnTenantIdx.get( key );
			recArray = new IIntNetLicense[ subdictLicnTenantIdx.size() ];
			Iterator< IntNetBuffLicense > iter = subdictLicnTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffLicense > subdictLicnTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffLicense >();
			dictByLicnTenantIdx.put( key, subdictLicnTenantIdx );
			recArray = new IIntNetLicense[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetLicense[] readDerivedByDomainIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopDomainId )
	{
		final String S_ProcName = "IntNetRamLicense.readDerivedByDomainIdx";
		IntNetBuffLicenseByDomainIdxKey key = (IntNetBuffLicenseByDomainIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByDomainIdxKey();

		key.setRequiredTopDomainId( TopDomainId );
		IIntNetLicense[] recArray;
		if( dictByDomainIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffLicense > subdictDomainIdx
				= dictByDomainIdx.get( key );
			recArray = new IIntNetLicense[ subdictDomainIdx.size() ];
			Iterator< IntNetBuffLicense > iter = subdictDomainIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, IntNetBuffLicense > subdictDomainIdx
				= new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffLicense >();
			dictByDomainIdx.put( key, subdictDomainIdx );
			recArray = new IIntNetLicense[0];
		}
		return( recArray );
	}

	@Override
	public IIntNetLicense readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopDomainId,
		String Name )
	{
		final String S_ProcName = "IntNetRamLicense.readDerivedByUNameIdx";
		IntNetBuffLicenseByUNameIdxKey key = (IntNetBuffLicenseByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByUNameIdxKey();

		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		IIntNetLicense buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetLicense readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamLicense.readDerivedByIdIdx() ";
		IIntNetLicense buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetLicense readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamLicense.readRec";
		IIntNetLicense buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetLicense.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetLicense lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IIntNetLicense buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetLicense.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetLicense[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "IntNetRamLicense.readAllRec";
		IIntNetLicense buff;
		ArrayList<IIntNetLicense> filteredList = new ArrayList<IIntNetLicense>();
		IIntNetLicense[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetLicense.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IIntNetLicense[0] ) );
	}

	@Override
	public IIntNetLicense readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "IntNetRamLicense.readRecByIdIdx() ";
		IIntNetLicense buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetLicense.CLASS_CODE ) ) {
			return( (IIntNetLicense)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IIntNetLicense[] readRecByLicnTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "IntNetRamLicense.readRecByLicnTenantIdx() ";
		IIntNetLicense buff;
		ArrayList<IIntNetLicense> filteredList = new ArrayList<IIntNetLicense>();
		IIntNetLicense[] buffList = readDerivedByLicnTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetLicense.CLASS_CODE ) ) {
				filteredList.add( (IIntNetLicense)buff );
			}
		}
		return( filteredList.toArray( new IIntNetLicense[0] ) );
	}

	@Override
	public IIntNetLicense[] readRecByDomainIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopDomainId )
	{
		final String S_ProcName = "IntNetRamLicense.readRecByDomainIdx() ";
		IIntNetLicense buff;
		ArrayList<IIntNetLicense> filteredList = new ArrayList<IIntNetLicense>();
		IIntNetLicense[] buffList = readDerivedByDomainIdx( Authorization,
			TopDomainId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetLicense.CLASS_CODE ) ) {
				filteredList.add( (IIntNetLicense)buff );
			}
		}
		return( filteredList.toArray( new IIntNetLicense[0] ) );
	}

	@Override
	public IIntNetLicense readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TopDomainId,
		String Name )
	{
		final String S_ProcName = "IntNetRamLicense.readRecByUNameIdx() ";
		IIntNetLicense buff = readDerivedByUNameIdx( Authorization,
			TopDomainId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetLicense.CLASS_CODE ) ) {
			return( (IIntNetLicense)buff );
		}
		else {
			return( null );
		}
	}

	public IIntNetLicense updateLicense( ISecureAuthorization Authorization,
		IIntNetLicense iBuff )
	{
		IntNetBuffLicense Buff = (IntNetBuffLicense)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		IntNetBuffLicense existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateLicense",
				"Existing record not found",
				"Existing record not found",
				"License",
				"License",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateLicense",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		IntNetBuffLicenseByLicnTenantIdxKey existingKeyLicnTenantIdx = (IntNetBuffLicenseByLicnTenantIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByLicnTenantIdxKey();
		existingKeyLicnTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffLicenseByLicnTenantIdxKey newKeyLicnTenantIdx = (IntNetBuffLicenseByLicnTenantIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByLicnTenantIdxKey();
		newKeyLicnTenantIdx.setRequiredTenantId( Buff.getRequiredTenantId() );

		IntNetBuffLicenseByDomainIdxKey existingKeyDomainIdx = (IntNetBuffLicenseByDomainIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByDomainIdxKey();
		existingKeyDomainIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );

		IntNetBuffLicenseByDomainIdxKey newKeyDomainIdx = (IntNetBuffLicenseByDomainIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByDomainIdxKey();
		newKeyDomainIdx.setRequiredTopDomainId( Buff.getRequiredTopDomainId() );

		IntNetBuffLicenseByUNameIdxKey existingKeyUNameIdx = (IntNetBuffLicenseByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		IntNetBuffLicenseByUNameIdxKey newKeyUNameIdx = (IntNetBuffLicenseByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredTopDomainId( Buff.getRequiredTopDomainId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateLicense",
					"LicenseUNameIdx",
					"LicenseUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateLicense",
						"Owner",
						"Owner",
						"Owner",
						"Owner",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTopDomain().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTopDomainId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateLicense",
						"Container",
						"Container",
						"TopDomain",
						"TopDomain",
						"TopDomain",
						"TopDomain",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, IntNetBuffLicense > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByLicnTenantIdx.get( existingKeyLicnTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLicnTenantIdx.containsKey( newKeyLicnTenantIdx ) ) {
			subdict = dictByLicnTenantIdx.get( newKeyLicnTenantIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffLicense >();
			dictByLicnTenantIdx.put( newKeyLicnTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByDomainIdx.get( existingKeyDomainIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByDomainIdx.containsKey( newKeyDomainIdx ) ) {
			subdict = dictByDomainIdx.get( newKeyDomainIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, IntNetBuffLicense >();
			dictByDomainIdx.put( newKeyDomainIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteLicense( ISecureAuthorization Authorization,
		IIntNetLicense iBuff )
	{
		final String S_ProcName = "IntNetRamLicenseTable.deleteLicense() ";
		IntNetBuffLicense Buff = (IntNetBuffLicense)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		IntNetBuffLicense existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteLicense",
				pkey );
		}
		IntNetBuffLicenseByLicnTenantIdxKey keyLicnTenantIdx = (IntNetBuffLicenseByLicnTenantIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByLicnTenantIdxKey();
		keyLicnTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IntNetBuffLicenseByDomainIdxKey keyDomainIdx = (IntNetBuffLicenseByDomainIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByDomainIdxKey();
		keyDomainIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );

		IntNetBuffLicenseByUNameIdxKey keyUNameIdx = (IntNetBuffLicenseByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByUNameIdxKey();
		keyUNameIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, IntNetBuffLicense > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByLicnTenantIdx.get( keyLicnTenantIdx );
		subdict.remove( pkey );

		subdict = dictByDomainIdx.get( keyDomainIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	@Override
	public void deleteLicenseByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		IntNetBuffLicense cur;
		LinkedList<IntNetBuffLicense> matchSet = new LinkedList<IntNetBuffLicense>();
		Iterator<IntNetBuffLicense> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffLicense> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffLicense)(schema.getTableLicense().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteLicense( Authorization, cur );
		}
	}

	@Override
	public void deleteLicenseByLicnTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		IntNetBuffLicenseByLicnTenantIdxKey key = (IntNetBuffLicenseByLicnTenantIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByLicnTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteLicenseByLicnTenantIdx( Authorization, key );
	}

	@Override
	public void deleteLicenseByLicnTenantIdx( ISecureAuthorization Authorization,
		IIntNetLicenseByLicnTenantIdxKey argKey )
	{
		IntNetBuffLicense cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffLicense> matchSet = new LinkedList<IntNetBuffLicense>();
		Iterator<IntNetBuffLicense> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffLicense> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffLicense)(schema.getTableLicense().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteLicense( Authorization, cur );
		}
	}

	@Override
	public void deleteLicenseByDomainIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTopDomainId )
	{
		IntNetBuffLicenseByDomainIdxKey key = (IntNetBuffLicenseByDomainIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByDomainIdxKey();
		key.setRequiredTopDomainId( argTopDomainId );
		deleteLicenseByDomainIdx( Authorization, key );
	}

	@Override
	public void deleteLicenseByDomainIdx( ISecureAuthorization Authorization,
		IIntNetLicenseByDomainIdxKey argKey )
	{
		IntNetBuffLicense cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffLicense> matchSet = new LinkedList<IntNetBuffLicense>();
		Iterator<IntNetBuffLicense> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffLicense> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffLicense)(schema.getTableLicense().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteLicense( Authorization, cur );
		}
	}

	@Override
	public void deleteLicenseByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTopDomainId,
		String argName )
	{
		IntNetBuffLicenseByUNameIdxKey key = (IntNetBuffLicenseByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryLicense().newByUNameIdxKey();
		key.setRequiredTopDomainId( argTopDomainId );
		key.setRequiredName( argName );
		deleteLicenseByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteLicenseByUNameIdx( ISecureAuthorization Authorization,
		IIntNetLicenseByUNameIdxKey argKey )
	{
		IntNetBuffLicense cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffLicense> matchSet = new LinkedList<IntNetBuffLicense>();
		Iterator<IntNetBuffLicense> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffLicense> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffLicense)(schema.getTableLicense().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteLicense( Authorization, cur );
		}
	}
}
