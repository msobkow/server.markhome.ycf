
// Description: Java 25 in-memory RAM DbIO implementation for ISOCtry.

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
 *	SecureRamISOCtryTable in-memory RAM DbIO implementation
 *	for ISOCtry.
 */
public class SecureRamISOCtryTable
	implements ISecureISOCtryTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffISOCtry > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffISOCtry >();
	private Map< SecureBuffISOCtryByISOCodeIdxKey,
			SecureBuffISOCtry > dictByISOCodeIdx
		= new HashMap< SecureBuffISOCtryByISOCodeIdxKey,
			SecureBuffISOCtry >();
	private Map< SecureBuffISOCtryByNameIdxKey,
			SecureBuffISOCtry > dictByNameIdx
		= new HashMap< SecureBuffISOCtryByNameIdxKey,
			SecureBuffISOCtry >();

	public SecureRamISOCtryTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffISOCtry ensureRec(ISecureISOCtry rec) {
		return (((SecureBuffISOCtryFactoryService)(schema.getSecureBuffFactory().getFactoryISOCtry())).ensureRec(rec));
	}

	@Override
	public ISecureISOCtry createISOCtry( ISecureAuthorization Authorization,
		ISecureISOCtry iBuff )
	{
		final String S_ProcName = "createISOCtry";
		
		SecureBuffISOCtry Buff = (SecureBuffISOCtry)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextISOCtryIdGen();
		Buff.setRequiredISOCtryId( pkey );
		SecureBuffISOCtryByISOCodeIdxKey keyISOCodeIdx = (SecureBuffISOCtryByISOCodeIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByISOCodeIdxKey();
		keyISOCodeIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		SecureBuffISOCtryByNameIdxKey keyNameIdx = (SecureBuffISOCtryByNameIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByNameIdxKey();
		keyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByISOCodeIdx.containsKey( keyISOCodeIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOCtryCodeIdx",
				"ISOCtryCodeIdx",
				keyISOCodeIdx );
		}

		if( dictByNameIdx.containsKey( keyNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOCtryNameIdx",
				"ISOCtryNameIdx",
				keyNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByISOCodeIdx.put( keyISOCodeIdx, Buff );

		dictByNameIdx.put( keyNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureISOCtry.CLASS_CODE) {
				SecureBuffISOCtry retbuff = ((SecureBuffISOCtry)(schema.getSecureBuffFactory().getFactoryISOCtry().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureISOCtry readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOCtry.readDerived";
		ISecureISOCtry buff;
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
	public ISecureISOCtry lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOCtry.lockDerived";
		ISecureISOCtry buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtry[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamISOCtry.readAllDerived";
		ISecureISOCtry[] retList = new ISecureISOCtry[ dictByPKey.values().size() ];
		Iterator< SecureBuffISOCtry > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureISOCtry readDerivedByISOCodeIdx( ISecureAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "SecureRamISOCtry.readDerivedByISOCodeIdx";
		SecureBuffISOCtryByISOCodeIdxKey key = (SecureBuffISOCtryByISOCodeIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByISOCodeIdxKey();

		key.setRequiredISOCode( ISOCode );
		ISecureISOCtry buff;
		if( dictByISOCodeIdx.containsKey( key ) ) {
			buff = dictByISOCodeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtry readDerivedByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamISOCtry.readDerivedByNameIdx";
		SecureBuffISOCtryByNameIdxKey key = (SecureBuffISOCtryByNameIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByNameIdxKey();

		key.setRequiredName( Name );
		ISecureISOCtry buff;
		if( dictByNameIdx.containsKey( key ) ) {
			buff = dictByNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtry readDerivedByIdIdx( ISecureAuthorization Authorization,
		short ISOCtryId )
	{
		final String S_ProcName = "SecureRamISOCtry.readDerivedByIdIdx() ";
		ISecureISOCtry buff;
		if( dictByPKey.containsKey( ISOCtryId ) ) {
			buff = dictByPKey.get( ISOCtryId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtry readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOCtry.readRec";
		ISecureISOCtry buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOCtry.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtry lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureISOCtry buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOCtry.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtry[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamISOCtry.readAllRec";
		ISecureISOCtry buff;
		ArrayList<ISecureISOCtry> filteredList = new ArrayList<ISecureISOCtry>();
		ISecureISOCtry[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCtry.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureISOCtry[0] ) );
	}

	@Override
	public ISecureISOCtry readRecByIdIdx( ISecureAuthorization Authorization,
		short ISOCtryId )
	{
		final String S_ProcName = "SecureRamISOCtry.readRecByIdIdx() ";
		ISecureISOCtry buff = readDerivedByIdIdx( Authorization,
			ISOCtryId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCtry.CLASS_CODE ) ) {
			return( (ISecureISOCtry)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureISOCtry readRecByISOCodeIdx( ISecureAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "SecureRamISOCtry.readRecByISOCodeIdx() ";
		ISecureISOCtry buff = readDerivedByISOCodeIdx( Authorization,
			ISOCode );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCtry.CLASS_CODE ) ) {
			return( (ISecureISOCtry)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureISOCtry readRecByNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamISOCtry.readRecByNameIdx() ";
		ISecureISOCtry buff = readDerivedByNameIdx( Authorization,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCtry.CLASS_CODE ) ) {
			return( (ISecureISOCtry)buff );
		}
		else {
			return( null );
		}
	}

	public ISecureISOCtry updateISOCtry( ISecureAuthorization Authorization,
		ISecureISOCtry iBuff )
	{
		SecureBuffISOCtry Buff = (SecureBuffISOCtry)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffISOCtry existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateISOCtry",
				"Existing record not found",
				"Existing record not found",
				"ISOCtry",
				"ISOCtry",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateISOCtry",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffISOCtryByISOCodeIdxKey existingKeyISOCodeIdx = (SecureBuffISOCtryByISOCodeIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByISOCodeIdxKey();
		existingKeyISOCodeIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		SecureBuffISOCtryByISOCodeIdxKey newKeyISOCodeIdx = (SecureBuffISOCtryByISOCodeIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByISOCodeIdxKey();
		newKeyISOCodeIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		SecureBuffISOCtryByNameIdxKey existingKeyNameIdx = (SecureBuffISOCtryByNameIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByNameIdxKey();
		existingKeyNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffISOCtryByNameIdxKey newKeyNameIdx = (SecureBuffISOCtryByNameIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByNameIdxKey();
		newKeyNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyISOCodeIdx.equals( newKeyISOCodeIdx ) ) {
			if( dictByISOCodeIdx.containsKey( newKeyISOCodeIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateISOCtry",
					"ISOCtryCodeIdx",
					"ISOCtryCodeIdx",
					newKeyISOCodeIdx );
			}
		}

		if( ! existingKeyNameIdx.equals( newKeyNameIdx ) ) {
			if( dictByNameIdx.containsKey( newKeyNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateISOCtry",
					"ISOCtryNameIdx",
					"ISOCtryNameIdx",
					newKeyNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffISOCtry > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByISOCodeIdx.remove( existingKeyISOCodeIdx );
		dictByISOCodeIdx.put( newKeyISOCodeIdx, Buff );

		dictByNameIdx.remove( existingKeyNameIdx );
		dictByNameIdx.put( newKeyNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteISOCtry( ISecureAuthorization Authorization,
		ISecureISOCtry iBuff )
	{
		final String S_ProcName = "SecureRamISOCtryTable.deleteISOCtry() ";
		SecureBuffISOCtry Buff = (SecureBuffISOCtry)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffISOCtry existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteISOCtry",
				pkey );
		}
					schema.getTableISOCtryLang().deleteISOCtryLangByCtryIdx( Authorization,
						existing.getRequiredISOCtryId() );
					schema.getTableISOCtryCcy().deleteISOCtryCcyByCtryIdx( Authorization,
						existing.getRequiredISOCtryId() );
		SecureBuffISOCtryByISOCodeIdxKey keyISOCodeIdx = (SecureBuffISOCtryByISOCodeIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByISOCodeIdxKey();
		keyISOCodeIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		SecureBuffISOCtryByNameIdxKey keyNameIdx = (SecureBuffISOCtryByNameIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffISOCtry > subdict;

		dictByPKey.remove( pkey );

		dictByISOCodeIdx.remove( keyISOCodeIdx );

		dictByNameIdx.remove( keyNameIdx );

	}
	@Override
	public void deleteISOCtryByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffISOCtry cur;
		LinkedList<SecureBuffISOCtry> matchSet = new LinkedList<SecureBuffISOCtry>();
		Iterator<SecureBuffISOCtry> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOCtry> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOCtry)(schema.getTableISOCtry().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOCtryId() ));
			deleteISOCtry( Authorization, cur );
		}
	}

	@Override
	public void deleteISOCtryByISOCodeIdx( ISecureAuthorization Authorization,
		String argISOCode )
	{
		SecureBuffISOCtryByISOCodeIdxKey key = (SecureBuffISOCtryByISOCodeIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByISOCodeIdxKey();
		key.setRequiredISOCode( argISOCode );
		deleteISOCtryByISOCodeIdx( Authorization, key );
	}

	@Override
	public void deleteISOCtryByISOCodeIdx( ISecureAuthorization Authorization,
		ISecureISOCtryByISOCodeIdxKey argKey )
	{
		SecureBuffISOCtry cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOCtry> matchSet = new LinkedList<SecureBuffISOCtry>();
		Iterator<SecureBuffISOCtry> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOCtry> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOCtry)(schema.getTableISOCtry().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOCtryId() ));
			deleteISOCtry( Authorization, cur );
		}
	}

	@Override
	public void deleteISOCtryByNameIdx( ISecureAuthorization Authorization,
		String argName )
	{
		SecureBuffISOCtryByNameIdxKey key = (SecureBuffISOCtryByNameIdxKey)schema.getSecureBuffFactory().getFactoryISOCtry().newByNameIdxKey();
		key.setRequiredName( argName );
		deleteISOCtryByNameIdx( Authorization, key );
	}

	@Override
	public void deleteISOCtryByNameIdx( ISecureAuthorization Authorization,
		ISecureISOCtryByNameIdxKey argKey )
	{
		SecureBuffISOCtry cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOCtry> matchSet = new LinkedList<SecureBuffISOCtry>();
		Iterator<SecureBuffISOCtry> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOCtry> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOCtry)(schema.getTableISOCtry().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOCtryId() ));
			deleteISOCtry( Authorization, cur );
		}
	}
}
