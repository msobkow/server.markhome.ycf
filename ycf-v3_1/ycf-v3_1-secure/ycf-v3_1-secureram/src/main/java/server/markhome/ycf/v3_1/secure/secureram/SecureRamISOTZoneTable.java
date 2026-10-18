
// Description: Java 25 in-memory RAM DbIO implementation for ISOTZone.

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
 *	SecureRamISOTZoneTable in-memory RAM DbIO implementation
 *	for ISOTZone.
 */
public class SecureRamISOTZoneTable
	implements ISecureISOTZoneTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffISOTZone > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffISOTZone >();
	private Map< SecureBuffISOTZoneByOffsetIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffISOTZone >> dictByOffsetIdx
		= new HashMap< SecureBuffISOTZoneByOffsetIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffISOTZone >>();
	private Map< SecureBuffISOTZoneByUTZNameIdxKey,
			SecureBuffISOTZone > dictByUTZNameIdx
		= new HashMap< SecureBuffISOTZoneByUTZNameIdxKey,
			SecureBuffISOTZone >();
	private Map< SecureBuffISOTZoneByIso8601IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffISOTZone >> dictByIso8601Idx
		= new HashMap< SecureBuffISOTZoneByIso8601IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffISOTZone >>();

	public SecureRamISOTZoneTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffISOTZone ensureRec(ISecureISOTZone rec) {
		return (((SecureBuffISOTZoneFactoryService)(schema.getSecureBuffFactory().getFactoryISOTZone())).ensureRec(rec));
	}

	@Override
	public ISecureISOTZone createISOTZone( ISecureAuthorization Authorization,
		ISecureISOTZone iBuff )
	{
		final String S_ProcName = "createISOTZone";
		
		SecureBuffISOTZone Buff = (SecureBuffISOTZone)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextISOTZoneIdGen();
		Buff.setRequiredISOTZoneId( pkey );
		SecureBuffISOTZoneByOffsetIdxKey keyOffsetIdx = (SecureBuffISOTZoneByOffsetIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByOffsetIdxKey();
		keyOffsetIdx.setRequiredTZHourOffset( Buff.getRequiredTZHourOffset() );
		keyOffsetIdx.setRequiredTZMinOffset( Buff.getRequiredTZMinOffset() );

		SecureBuffISOTZoneByUTZNameIdxKey keyUTZNameIdx = (SecureBuffISOTZoneByUTZNameIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByUTZNameIdxKey();
		keyUTZNameIdx.setRequiredTZName( Buff.getRequiredTZName() );

		SecureBuffISOTZoneByIso8601IdxKey keyIso8601Idx = (SecureBuffISOTZoneByIso8601IdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByIso8601IdxKey();
		keyIso8601Idx.setRequiredIso8601( Buff.getRequiredIso8601() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUTZNameIdx.containsKey( keyUTZNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOTZoneUTZNameIdx",
				"ISOTZoneUTZNameIdx",
				keyUTZNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffISOTZone > subdictOffsetIdx;
		if( dictByOffsetIdx.containsKey( keyOffsetIdx ) ) {
			subdictOffsetIdx = dictByOffsetIdx.get( keyOffsetIdx );
		}
		else {
			subdictOffsetIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffISOTZone >();
			dictByOffsetIdx.put( keyOffsetIdx, subdictOffsetIdx );
		}
		subdictOffsetIdx.put( pkey, Buff );

		dictByUTZNameIdx.put( keyUTZNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffISOTZone > subdictIso8601Idx;
		if( dictByIso8601Idx.containsKey( keyIso8601Idx ) ) {
			subdictIso8601Idx = dictByIso8601Idx.get( keyIso8601Idx );
		}
		else {
			subdictIso8601Idx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffISOTZone >();
			dictByIso8601Idx.put( keyIso8601Idx, subdictIso8601Idx );
		}
		subdictIso8601Idx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureISOTZone.CLASS_CODE) {
				SecureBuffISOTZone retbuff = ((SecureBuffISOTZone)(schema.getSecureBuffFactory().getFactoryISOTZone().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureISOTZone readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOTZone.readDerived";
		ISecureISOTZone buff;
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
	public ISecureISOTZone lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOTZone.lockDerived";
		ISecureISOTZone buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOTZone[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamISOTZone.readAllDerived";
		ISecureISOTZone[] retList = new ISecureISOTZone[ dictByPKey.values().size() ];
		Iterator< SecureBuffISOTZone > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureISOTZone[] readDerivedByOffsetIdx( ISecureAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset )
	{
		final String S_ProcName = "SecureRamISOTZone.readDerivedByOffsetIdx";
		SecureBuffISOTZoneByOffsetIdxKey key = (SecureBuffISOTZoneByOffsetIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByOffsetIdxKey();

		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		ISecureISOTZone[] recArray;
		if( dictByOffsetIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffISOTZone > subdictOffsetIdx
				= dictByOffsetIdx.get( key );
			recArray = new ISecureISOTZone[ subdictOffsetIdx.size() ];
			Iterator< SecureBuffISOTZone > iter = subdictOffsetIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffISOTZone > subdictOffsetIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffISOTZone >();
			dictByOffsetIdx.put( key, subdictOffsetIdx );
			recArray = new ISecureISOTZone[0];
		}
		return( recArray );
	}

	@Override
	public ISecureISOTZone readDerivedByUTZNameIdx( ISecureAuthorization Authorization,
		String TZName )
	{
		final String S_ProcName = "SecureRamISOTZone.readDerivedByUTZNameIdx";
		SecureBuffISOTZoneByUTZNameIdxKey key = (SecureBuffISOTZoneByUTZNameIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByUTZNameIdxKey();

		key.setRequiredTZName( TZName );
		ISecureISOTZone buff;
		if( dictByUTZNameIdx.containsKey( key ) ) {
			buff = dictByUTZNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOTZone[] readDerivedByIso8601Idx( ISecureAuthorization Authorization,
		String Iso8601 )
	{
		final String S_ProcName = "SecureRamISOTZone.readDerivedByIso8601Idx";
		SecureBuffISOTZoneByIso8601IdxKey key = (SecureBuffISOTZoneByIso8601IdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByIso8601IdxKey();

		key.setRequiredIso8601( Iso8601 );
		ISecureISOTZone[] recArray;
		if( dictByIso8601Idx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffISOTZone > subdictIso8601Idx
				= dictByIso8601Idx.get( key );
			recArray = new ISecureISOTZone[ subdictIso8601Idx.size() ];
			Iterator< SecureBuffISOTZone > iter = subdictIso8601Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffISOTZone > subdictIso8601Idx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffISOTZone >();
			dictByIso8601Idx.put( key, subdictIso8601Idx );
			recArray = new ISecureISOTZone[0];
		}
		return( recArray );
	}

	@Override
	public ISecureISOTZone readDerivedByIdIdx( ISecureAuthorization Authorization,
		short ISOTZoneId )
	{
		final String S_ProcName = "SecureRamISOTZone.readDerivedByIdIdx() ";
		ISecureISOTZone buff;
		if( dictByPKey.containsKey( ISOTZoneId ) ) {
			buff = dictByPKey.get( ISOTZoneId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOTZone readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOTZone.readRec";
		ISecureISOTZone buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOTZone.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOTZone lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureISOTZone buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOTZone.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOTZone[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamISOTZone.readAllRec";
		ISecureISOTZone buff;
		ArrayList<ISecureISOTZone> filteredList = new ArrayList<ISecureISOTZone>();
		ISecureISOTZone[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOTZone.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureISOTZone[0] ) );
	}

	@Override
	public ISecureISOTZone readRecByIdIdx( ISecureAuthorization Authorization,
		short ISOTZoneId )
	{
		final String S_ProcName = "SecureRamISOTZone.readRecByIdIdx() ";
		ISecureISOTZone buff = readDerivedByIdIdx( Authorization,
			ISOTZoneId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOTZone.CLASS_CODE ) ) {
			return( (ISecureISOTZone)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureISOTZone[] readRecByOffsetIdx( ISecureAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset )
	{
		final String S_ProcName = "SecureRamISOTZone.readRecByOffsetIdx() ";
		ISecureISOTZone buff;
		ArrayList<ISecureISOTZone> filteredList = new ArrayList<ISecureISOTZone>();
		ISecureISOTZone[] buffList = readDerivedByOffsetIdx( Authorization,
			TZHourOffset,
			TZMinOffset );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOTZone.CLASS_CODE ) ) {
				filteredList.add( (ISecureISOTZone)buff );
			}
		}
		return( filteredList.toArray( new ISecureISOTZone[0] ) );
	}

	@Override
	public ISecureISOTZone readRecByUTZNameIdx( ISecureAuthorization Authorization,
		String TZName )
	{
		final String S_ProcName = "SecureRamISOTZone.readRecByUTZNameIdx() ";
		ISecureISOTZone buff = readDerivedByUTZNameIdx( Authorization,
			TZName );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOTZone.CLASS_CODE ) ) {
			return( (ISecureISOTZone)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureISOTZone[] readRecByIso8601Idx( ISecureAuthorization Authorization,
		String Iso8601 )
	{
		final String S_ProcName = "SecureRamISOTZone.readRecByIso8601Idx() ";
		ISecureISOTZone buff;
		ArrayList<ISecureISOTZone> filteredList = new ArrayList<ISecureISOTZone>();
		ISecureISOTZone[] buffList = readDerivedByIso8601Idx( Authorization,
			Iso8601 );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOTZone.CLASS_CODE ) ) {
				filteredList.add( (ISecureISOTZone)buff );
			}
		}
		return( filteredList.toArray( new ISecureISOTZone[0] ) );
	}

	public ISecureISOTZone updateISOTZone( ISecureAuthorization Authorization,
		ISecureISOTZone iBuff )
	{
		SecureBuffISOTZone Buff = (SecureBuffISOTZone)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffISOTZone existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateISOTZone",
				"Existing record not found",
				"Existing record not found",
				"ISOTZone",
				"ISOTZone",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateISOTZone",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffISOTZoneByOffsetIdxKey existingKeyOffsetIdx = (SecureBuffISOTZoneByOffsetIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByOffsetIdxKey();
		existingKeyOffsetIdx.setRequiredTZHourOffset( existing.getRequiredTZHourOffset() );
		existingKeyOffsetIdx.setRequiredTZMinOffset( existing.getRequiredTZMinOffset() );

		SecureBuffISOTZoneByOffsetIdxKey newKeyOffsetIdx = (SecureBuffISOTZoneByOffsetIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByOffsetIdxKey();
		newKeyOffsetIdx.setRequiredTZHourOffset( Buff.getRequiredTZHourOffset() );
		newKeyOffsetIdx.setRequiredTZMinOffset( Buff.getRequiredTZMinOffset() );

		SecureBuffISOTZoneByUTZNameIdxKey existingKeyUTZNameIdx = (SecureBuffISOTZoneByUTZNameIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByUTZNameIdxKey();
		existingKeyUTZNameIdx.setRequiredTZName( existing.getRequiredTZName() );

		SecureBuffISOTZoneByUTZNameIdxKey newKeyUTZNameIdx = (SecureBuffISOTZoneByUTZNameIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByUTZNameIdxKey();
		newKeyUTZNameIdx.setRequiredTZName( Buff.getRequiredTZName() );

		SecureBuffISOTZoneByIso8601IdxKey existingKeyIso8601Idx = (SecureBuffISOTZoneByIso8601IdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByIso8601IdxKey();
		existingKeyIso8601Idx.setRequiredIso8601( existing.getRequiredIso8601() );

		SecureBuffISOTZoneByIso8601IdxKey newKeyIso8601Idx = (SecureBuffISOTZoneByIso8601IdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByIso8601IdxKey();
		newKeyIso8601Idx.setRequiredIso8601( Buff.getRequiredIso8601() );

		// Check unique indexes

		if( ! existingKeyUTZNameIdx.equals( newKeyUTZNameIdx ) ) {
			if( dictByUTZNameIdx.containsKey( newKeyUTZNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateISOTZone",
					"ISOTZoneUTZNameIdx",
					"ISOTZoneUTZNameIdx",
					newKeyUTZNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffISOTZone > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByOffsetIdx.get( existingKeyOffsetIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByOffsetIdx.containsKey( newKeyOffsetIdx ) ) {
			subdict = dictByOffsetIdx.get( newKeyOffsetIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffISOTZone >();
			dictByOffsetIdx.put( newKeyOffsetIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUTZNameIdx.remove( existingKeyUTZNameIdx );
		dictByUTZNameIdx.put( newKeyUTZNameIdx, Buff );

		subdict = dictByIso8601Idx.get( existingKeyIso8601Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByIso8601Idx.containsKey( newKeyIso8601Idx ) ) {
			subdict = dictByIso8601Idx.get( newKeyIso8601Idx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffISOTZone >();
			dictByIso8601Idx.put( newKeyIso8601Idx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteISOTZone( ISecureAuthorization Authorization,
		ISecureISOTZone iBuff )
	{
		final String S_ProcName = "SecureRamISOTZoneTable.deleteISOTZone() ";
		SecureBuffISOTZone Buff = (SecureBuffISOTZone)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffISOTZone existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteISOTZone",
				pkey );
		}
		SecureBuffISOTZoneByOffsetIdxKey keyOffsetIdx = (SecureBuffISOTZoneByOffsetIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByOffsetIdxKey();
		keyOffsetIdx.setRequiredTZHourOffset( existing.getRequiredTZHourOffset() );
		keyOffsetIdx.setRequiredTZMinOffset( existing.getRequiredTZMinOffset() );

		SecureBuffISOTZoneByUTZNameIdxKey keyUTZNameIdx = (SecureBuffISOTZoneByUTZNameIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByUTZNameIdxKey();
		keyUTZNameIdx.setRequiredTZName( existing.getRequiredTZName() );

		SecureBuffISOTZoneByIso8601IdxKey keyIso8601Idx = (SecureBuffISOTZoneByIso8601IdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByIso8601IdxKey();
		keyIso8601Idx.setRequiredIso8601( existing.getRequiredIso8601() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffISOTZone > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByOffsetIdx.get( keyOffsetIdx );
		subdict.remove( pkey );

		dictByUTZNameIdx.remove( keyUTZNameIdx );

		subdict = dictByIso8601Idx.get( keyIso8601Idx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteISOTZoneByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffISOTZone cur;
		LinkedList<SecureBuffISOTZone> matchSet = new LinkedList<SecureBuffISOTZone>();
		Iterator<SecureBuffISOTZone> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOTZone> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOTZone)(schema.getTableISOTZone().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOTZoneId() ));
			deleteISOTZone( Authorization, cur );
		}
	}

	@Override
	public void deleteISOTZoneByOffsetIdx( ISecureAuthorization Authorization,
		short argTZHourOffset,
		short argTZMinOffset )
	{
		SecureBuffISOTZoneByOffsetIdxKey key = (SecureBuffISOTZoneByOffsetIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByOffsetIdxKey();
		key.setRequiredTZHourOffset( argTZHourOffset );
		key.setRequiredTZMinOffset( argTZMinOffset );
		deleteISOTZoneByOffsetIdx( Authorization, key );
	}

	@Override
	public void deleteISOTZoneByOffsetIdx( ISecureAuthorization Authorization,
		ISecureISOTZoneByOffsetIdxKey argKey )
	{
		SecureBuffISOTZone cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOTZone> matchSet = new LinkedList<SecureBuffISOTZone>();
		Iterator<SecureBuffISOTZone> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOTZone> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOTZone)(schema.getTableISOTZone().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOTZoneId() ));
			deleteISOTZone( Authorization, cur );
		}
	}

	@Override
	public void deleteISOTZoneByUTZNameIdx( ISecureAuthorization Authorization,
		String argTZName )
	{
		SecureBuffISOTZoneByUTZNameIdxKey key = (SecureBuffISOTZoneByUTZNameIdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByUTZNameIdxKey();
		key.setRequiredTZName( argTZName );
		deleteISOTZoneByUTZNameIdx( Authorization, key );
	}

	@Override
	public void deleteISOTZoneByUTZNameIdx( ISecureAuthorization Authorization,
		ISecureISOTZoneByUTZNameIdxKey argKey )
	{
		SecureBuffISOTZone cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOTZone> matchSet = new LinkedList<SecureBuffISOTZone>();
		Iterator<SecureBuffISOTZone> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOTZone> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOTZone)(schema.getTableISOTZone().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOTZoneId() ));
			deleteISOTZone( Authorization, cur );
		}
	}

	@Override
	public void deleteISOTZoneByIso8601Idx( ISecureAuthorization Authorization,
		String argIso8601 )
	{
		SecureBuffISOTZoneByIso8601IdxKey key = (SecureBuffISOTZoneByIso8601IdxKey)schema.getSecureBuffFactory().getFactoryISOTZone().newByIso8601IdxKey();
		key.setRequiredIso8601( argIso8601 );
		deleteISOTZoneByIso8601Idx( Authorization, key );
	}

	@Override
	public void deleteISOTZoneByIso8601Idx( ISecureAuthorization Authorization,
		ISecureISOTZoneByIso8601IdxKey argKey )
	{
		SecureBuffISOTZone cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOTZone> matchSet = new LinkedList<SecureBuffISOTZone>();
		Iterator<SecureBuffISOTZone> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOTZone> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOTZone)(schema.getTableISOTZone().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOTZoneId() ));
			deleteISOTZone( Authorization, cur );
		}
	}
}
