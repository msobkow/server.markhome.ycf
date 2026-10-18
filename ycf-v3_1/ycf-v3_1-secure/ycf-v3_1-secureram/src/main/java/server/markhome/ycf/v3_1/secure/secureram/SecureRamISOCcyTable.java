
// Description: Java 25 in-memory RAM DbIO implementation for ISOCcy.

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
 *	SecureRamISOCcyTable in-memory RAM DbIO implementation
 *	for ISOCcy.
 */
public class SecureRamISOCcyTable
	implements ISecureISOCcyTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffISOCcy > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffISOCcy >();
	private Map< SecureBuffISOCcyByCcyCdIdxKey,
			SecureBuffISOCcy > dictByCcyCdIdx
		= new HashMap< SecureBuffISOCcyByCcyCdIdxKey,
			SecureBuffISOCcy >();
	private Map< SecureBuffISOCcyByCcyNmIdxKey,
			SecureBuffISOCcy > dictByCcyNmIdx
		= new HashMap< SecureBuffISOCcyByCcyNmIdxKey,
			SecureBuffISOCcy >();

	public SecureRamISOCcyTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffISOCcy ensureRec(ISecureISOCcy rec) {
		return (((SecureBuffISOCcyFactoryService)(schema.getSecureBuffFactory().getFactoryISOCcy())).ensureRec(rec));
	}

	@Override
	public ISecureISOCcy createISOCcy( ISecureAuthorization Authorization,
		ISecureISOCcy iBuff )
	{
		final String S_ProcName = "createISOCcy";
		
		SecureBuffISOCcy Buff = (SecureBuffISOCcy)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextISOCcyIdGen();
		Buff.setRequiredISOCcyId( pkey );
		SecureBuffISOCcyByCcyCdIdxKey keyCcyCdIdx = (SecureBuffISOCcyByCcyCdIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyCdIdxKey();
		keyCcyCdIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		SecureBuffISOCcyByCcyNmIdxKey keyCcyNmIdx = (SecureBuffISOCcyByCcyNmIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyNmIdxKey();
		keyCcyNmIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByCcyCdIdx.containsKey( keyCcyCdIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOCcyCodeIdx",
				"ISOCcyCodeIdx",
				keyCcyCdIdx );
		}

		if( dictByCcyNmIdx.containsKey( keyCcyNmIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOCcyNameIdx",
				"ISOCcyNameIdx",
				keyCcyNmIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByCcyCdIdx.put( keyCcyCdIdx, Buff );

		dictByCcyNmIdx.put( keyCcyNmIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureISOCcy.CLASS_CODE) {
				SecureBuffISOCcy retbuff = ((SecureBuffISOCcy)(schema.getSecureBuffFactory().getFactoryISOCcy().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureISOCcy readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOCcy.readDerived";
		ISecureISOCcy buff;
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
	public ISecureISOCcy lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOCcy.lockDerived";
		ISecureISOCcy buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCcy[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamISOCcy.readAllDerived";
		ISecureISOCcy[] retList = new ISecureISOCcy[ dictByPKey.values().size() ];
		Iterator< SecureBuffISOCcy > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureISOCcy readDerivedByCcyCdIdx( ISecureAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "SecureRamISOCcy.readDerivedByCcyCdIdx";
		SecureBuffISOCcyByCcyCdIdxKey key = (SecureBuffISOCcyByCcyCdIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyCdIdxKey();

		key.setRequiredISOCode( ISOCode );
		ISecureISOCcy buff;
		if( dictByCcyCdIdx.containsKey( key ) ) {
			buff = dictByCcyCdIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCcy readDerivedByCcyNmIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamISOCcy.readDerivedByCcyNmIdx";
		SecureBuffISOCcyByCcyNmIdxKey key = (SecureBuffISOCcyByCcyNmIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyNmIdxKey();

		key.setRequiredName( Name );
		ISecureISOCcy buff;
		if( dictByCcyNmIdx.containsKey( key ) ) {
			buff = dictByCcyNmIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCcy readDerivedByIdIdx( ISecureAuthorization Authorization,
		short ISOCcyId )
	{
		final String S_ProcName = "SecureRamISOCcy.readDerivedByIdIdx() ";
		ISecureISOCcy buff;
		if( dictByPKey.containsKey( ISOCcyId ) ) {
			buff = dictByPKey.get( ISOCcyId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCcy readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOCcy.readRec";
		ISecureISOCcy buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOCcy.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCcy lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureISOCcy buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOCcy.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCcy[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamISOCcy.readAllRec";
		ISecureISOCcy buff;
		ArrayList<ISecureISOCcy> filteredList = new ArrayList<ISecureISOCcy>();
		ISecureISOCcy[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCcy.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureISOCcy[0] ) );
	}

	@Override
	public ISecureISOCcy readRecByIdIdx( ISecureAuthorization Authorization,
		short ISOCcyId )
	{
		final String S_ProcName = "SecureRamISOCcy.readRecByIdIdx() ";
		ISecureISOCcy buff = readDerivedByIdIdx( Authorization,
			ISOCcyId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCcy.CLASS_CODE ) ) {
			return( (ISecureISOCcy)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureISOCcy readRecByCcyCdIdx( ISecureAuthorization Authorization,
		String ISOCode )
	{
		final String S_ProcName = "SecureRamISOCcy.readRecByCcyCdIdx() ";
		ISecureISOCcy buff = readDerivedByCcyCdIdx( Authorization,
			ISOCode );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCcy.CLASS_CODE ) ) {
			return( (ISecureISOCcy)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureISOCcy readRecByCcyNmIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamISOCcy.readRecByCcyNmIdx() ";
		ISecureISOCcy buff = readDerivedByCcyNmIdx( Authorization,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCcy.CLASS_CODE ) ) {
			return( (ISecureISOCcy)buff );
		}
		else {
			return( null );
		}
	}

	public ISecureISOCcy updateISOCcy( ISecureAuthorization Authorization,
		ISecureISOCcy iBuff )
	{
		SecureBuffISOCcy Buff = (SecureBuffISOCcy)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffISOCcy existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateISOCcy",
				"Existing record not found",
				"Existing record not found",
				"ISOCcy",
				"ISOCcy",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateISOCcy",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffISOCcyByCcyCdIdxKey existingKeyCcyCdIdx = (SecureBuffISOCcyByCcyCdIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyCdIdxKey();
		existingKeyCcyCdIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		SecureBuffISOCcyByCcyCdIdxKey newKeyCcyCdIdx = (SecureBuffISOCcyByCcyCdIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyCdIdxKey();
		newKeyCcyCdIdx.setRequiredISOCode( Buff.getRequiredISOCode() );

		SecureBuffISOCcyByCcyNmIdxKey existingKeyCcyNmIdx = (SecureBuffISOCcyByCcyNmIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyNmIdxKey();
		existingKeyCcyNmIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffISOCcyByCcyNmIdxKey newKeyCcyNmIdx = (SecureBuffISOCcyByCcyNmIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyNmIdxKey();
		newKeyCcyNmIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyCcyCdIdx.equals( newKeyCcyCdIdx ) ) {
			if( dictByCcyCdIdx.containsKey( newKeyCcyCdIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateISOCcy",
					"ISOCcyCodeIdx",
					"ISOCcyCodeIdx",
					newKeyCcyCdIdx );
			}
		}

		if( ! existingKeyCcyNmIdx.equals( newKeyCcyNmIdx ) ) {
			if( dictByCcyNmIdx.containsKey( newKeyCcyNmIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateISOCcy",
					"ISOCcyNameIdx",
					"ISOCcyNameIdx",
					newKeyCcyNmIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffISOCcy > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByCcyCdIdx.remove( existingKeyCcyCdIdx );
		dictByCcyCdIdx.put( newKeyCcyCdIdx, Buff );

		dictByCcyNmIdx.remove( existingKeyCcyNmIdx );
		dictByCcyNmIdx.put( newKeyCcyNmIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteISOCcy( ISecureAuthorization Authorization,
		ISecureISOCcy iBuff )
	{
		final String S_ProcName = "SecureRamISOCcyTable.deleteISOCcy() ";
		SecureBuffISOCcy Buff = (SecureBuffISOCcy)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffISOCcy existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteISOCcy",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckISOCcyCountries[] = schema.getTableISOCtryCcy().readDerivedByCcyIdx( Authorization,
						existing.getRequiredISOCcyId() );
		if( arrCheckISOCcyCountries.length > 0 ) {
			schema.getTableISOCtryCcy().deleteISOCtryCcyByCcyIdx( Authorization,
						existing.getRequiredISOCcyId() );
		}
		SecureBuffISOCcyByCcyCdIdxKey keyCcyCdIdx = (SecureBuffISOCcyByCcyCdIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyCdIdxKey();
		keyCcyCdIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		SecureBuffISOCcyByCcyNmIdxKey keyCcyNmIdx = (SecureBuffISOCcyByCcyNmIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyNmIdxKey();
		keyCcyNmIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffISOCcy > subdict;

		dictByPKey.remove( pkey );

		dictByCcyCdIdx.remove( keyCcyCdIdx );

		dictByCcyNmIdx.remove( keyCcyNmIdx );

	}
	@Override
	public void deleteISOCcyByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffISOCcy cur;
		LinkedList<SecureBuffISOCcy> matchSet = new LinkedList<SecureBuffISOCcy>();
		Iterator<SecureBuffISOCcy> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOCcy> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOCcy)(schema.getTableISOCcy().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOCcyId() ));
			deleteISOCcy( Authorization, cur );
		}
	}

	@Override
	public void deleteISOCcyByCcyCdIdx( ISecureAuthorization Authorization,
		String argISOCode )
	{
		SecureBuffISOCcyByCcyCdIdxKey key = (SecureBuffISOCcyByCcyCdIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyCdIdxKey();
		key.setRequiredISOCode( argISOCode );
		deleteISOCcyByCcyCdIdx( Authorization, key );
	}

	@Override
	public void deleteISOCcyByCcyCdIdx( ISecureAuthorization Authorization,
		ISecureISOCcyByCcyCdIdxKey argKey )
	{
		SecureBuffISOCcy cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOCcy> matchSet = new LinkedList<SecureBuffISOCcy>();
		Iterator<SecureBuffISOCcy> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOCcy> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOCcy)(schema.getTableISOCcy().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOCcyId() ));
			deleteISOCcy( Authorization, cur );
		}
	}

	@Override
	public void deleteISOCcyByCcyNmIdx( ISecureAuthorization Authorization,
		String argName )
	{
		SecureBuffISOCcyByCcyNmIdxKey key = (SecureBuffISOCcyByCcyNmIdxKey)schema.getSecureBuffFactory().getFactoryISOCcy().newByCcyNmIdxKey();
		key.setRequiredName( argName );
		deleteISOCcyByCcyNmIdx( Authorization, key );
	}

	@Override
	public void deleteISOCcyByCcyNmIdx( ISecureAuthorization Authorization,
		ISecureISOCcyByCcyNmIdxKey argKey )
	{
		SecureBuffISOCcy cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOCcy> matchSet = new LinkedList<SecureBuffISOCcy>();
		Iterator<SecureBuffISOCcy> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOCcy> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOCcy)(schema.getTableISOCcy().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOCcyId() ));
			deleteISOCcy( Authorization, cur );
		}
	}
}
