
// Description: Java 25 in-memory RAM DbIO implementation for ISOLang.

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
 *	SecureRamISOLangTable in-memory RAM DbIO implementation
 *	for ISOLang.
 */
public class SecureRamISOLangTable
	implements ISecureISOLangTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffISOLang > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffISOLang >();
	private Map< SecureBuffISOLangByCode3IdxKey,
			SecureBuffISOLang > dictByCode3Idx
		= new HashMap< SecureBuffISOLangByCode3IdxKey,
			SecureBuffISOLang >();
	private Map< SecureBuffISOLangByCode2IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffISOLang >> dictByCode2Idx
		= new HashMap< SecureBuffISOLangByCode2IdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffISOLang >>();

	public SecureRamISOLangTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffISOLang ensureRec(ISecureISOLang rec) {
		return (((SecureBuffISOLangFactoryService)(schema.getSecureBuffFactory().getFactoryISOLang())).ensureRec(rec));
	}

	@Override
	public ISecureISOLang createISOLang( ISecureAuthorization Authorization,
		ISecureISOLang iBuff )
	{
		final String S_ProcName = "createISOLang";
		
		SecureBuffISOLang Buff = (SecureBuffISOLang)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextISOLangIdGen();
		Buff.setRequiredISOLangId( pkey );
		SecureBuffISOLangByCode3IdxKey keyCode3Idx = (SecureBuffISOLangByCode3IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode3IdxKey();
		keyCode3Idx.setRequiredISO6392Code( Buff.getRequiredISO6392Code() );

		SecureBuffISOLangByCode2IdxKey keyCode2Idx = (SecureBuffISOLangByCode2IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode2IdxKey();
		keyCode2Idx.setOptionalISO6391Code( Buff.getOptionalISO6391Code() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByCode3Idx.containsKey( keyCode3Idx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"ISOLang6392Idx",
				"ISOLang6392Idx",
				keyCode3Idx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByCode3Idx.put( keyCode3Idx, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffISOLang > subdictCode2Idx;
		if( dictByCode2Idx.containsKey( keyCode2Idx ) ) {
			subdictCode2Idx = dictByCode2Idx.get( keyCode2Idx );
		}
		else {
			subdictCode2Idx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffISOLang >();
			dictByCode2Idx.put( keyCode2Idx, subdictCode2Idx );
		}
		subdictCode2Idx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureISOLang.CLASS_CODE) {
				SecureBuffISOLang retbuff = ((SecureBuffISOLang)(schema.getSecureBuffFactory().getFactoryISOLang().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureISOLang readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOLang.readDerived";
		ISecureISOLang buff;
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
	public ISecureISOLang lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOLang.lockDerived";
		ISecureISOLang buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOLang[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamISOLang.readAllDerived";
		ISecureISOLang[] retList = new ISecureISOLang[ dictByPKey.values().size() ];
		Iterator< SecureBuffISOLang > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureISOLang readDerivedByCode3Idx( ISecureAuthorization Authorization,
		String ISO6392Code )
	{
		final String S_ProcName = "SecureRamISOLang.readDerivedByCode3Idx";
		SecureBuffISOLangByCode3IdxKey key = (SecureBuffISOLangByCode3IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode3IdxKey();

		key.setRequiredISO6392Code( ISO6392Code );
		ISecureISOLang buff;
		if( dictByCode3Idx.containsKey( key ) ) {
			buff = dictByCode3Idx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOLang[] readDerivedByCode2Idx( ISecureAuthorization Authorization,
		String ISO6391Code )
	{
		final String S_ProcName = "SecureRamISOLang.readDerivedByCode2Idx";
		SecureBuffISOLangByCode2IdxKey key = (SecureBuffISOLangByCode2IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode2IdxKey();

		key.setOptionalISO6391Code( ISO6391Code );
		ISecureISOLang[] recArray;
		if( dictByCode2Idx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffISOLang > subdictCode2Idx
				= dictByCode2Idx.get( key );
			recArray = new ISecureISOLang[ subdictCode2Idx.size() ];
			Iterator< SecureBuffISOLang > iter = subdictCode2Idx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffISOLang > subdictCode2Idx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffISOLang >();
			dictByCode2Idx.put( key, subdictCode2Idx );
			recArray = new ISecureISOLang[0];
		}
		return( recArray );
	}

	@Override
	public ISecureISOLang readDerivedByIdIdx( ISecureAuthorization Authorization,
		short ISOLangId )
	{
		final String S_ProcName = "SecureRamISOLang.readDerivedByIdIdx() ";
		ISecureISOLang buff;
		if( dictByPKey.containsKey( ISOLangId ) ) {
			buff = dictByPKey.get( ISOLangId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOLang readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamISOLang.readRec";
		ISecureISOLang buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOLang.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOLang lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureISOLang buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOLang.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOLang[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamISOLang.readAllRec";
		ISecureISOLang buff;
		ArrayList<ISecureISOLang> filteredList = new ArrayList<ISecureISOLang>();
		ISecureISOLang[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOLang.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureISOLang[0] ) );
	}

	@Override
	public ISecureISOLang readRecByIdIdx( ISecureAuthorization Authorization,
		short ISOLangId )
	{
		final String S_ProcName = "SecureRamISOLang.readRecByIdIdx() ";
		ISecureISOLang buff = readDerivedByIdIdx( Authorization,
			ISOLangId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOLang.CLASS_CODE ) ) {
			return( (ISecureISOLang)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureISOLang readRecByCode3Idx( ISecureAuthorization Authorization,
		String ISO6392Code )
	{
		final String S_ProcName = "SecureRamISOLang.readRecByCode3Idx() ";
		ISecureISOLang buff = readDerivedByCode3Idx( Authorization,
			ISO6392Code );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOLang.CLASS_CODE ) ) {
			return( (ISecureISOLang)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureISOLang[] readRecByCode2Idx( ISecureAuthorization Authorization,
		String ISO6391Code )
	{
		final String S_ProcName = "SecureRamISOLang.readRecByCode2Idx() ";
		ISecureISOLang buff;
		ArrayList<ISecureISOLang> filteredList = new ArrayList<ISecureISOLang>();
		ISecureISOLang[] buffList = readDerivedByCode2Idx( Authorization,
			ISO6391Code );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOLang.CLASS_CODE ) ) {
				filteredList.add( (ISecureISOLang)buff );
			}
		}
		return( filteredList.toArray( new ISecureISOLang[0] ) );
	}

	public ISecureISOLang updateISOLang( ISecureAuthorization Authorization,
		ISecureISOLang iBuff )
	{
		SecureBuffISOLang Buff = (SecureBuffISOLang)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffISOLang existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateISOLang",
				"Existing record not found",
				"Existing record not found",
				"ISOLang",
				"ISOLang",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateISOLang",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffISOLangByCode3IdxKey existingKeyCode3Idx = (SecureBuffISOLangByCode3IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode3IdxKey();
		existingKeyCode3Idx.setRequiredISO6392Code( existing.getRequiredISO6392Code() );

		SecureBuffISOLangByCode3IdxKey newKeyCode3Idx = (SecureBuffISOLangByCode3IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode3IdxKey();
		newKeyCode3Idx.setRequiredISO6392Code( Buff.getRequiredISO6392Code() );

		SecureBuffISOLangByCode2IdxKey existingKeyCode2Idx = (SecureBuffISOLangByCode2IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode2IdxKey();
		existingKeyCode2Idx.setOptionalISO6391Code( existing.getOptionalISO6391Code() );

		SecureBuffISOLangByCode2IdxKey newKeyCode2Idx = (SecureBuffISOLangByCode2IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode2IdxKey();
		newKeyCode2Idx.setOptionalISO6391Code( Buff.getOptionalISO6391Code() );

		// Check unique indexes

		if( ! existingKeyCode3Idx.equals( newKeyCode3Idx ) ) {
			if( dictByCode3Idx.containsKey( newKeyCode3Idx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateISOLang",
					"ISOLang6392Idx",
					"ISOLang6392Idx",
					newKeyCode3Idx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffISOLang > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByCode3Idx.remove( existingKeyCode3Idx );
		dictByCode3Idx.put( newKeyCode3Idx, Buff );

		subdict = dictByCode2Idx.get( existingKeyCode2Idx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCode2Idx.containsKey( newKeyCode2Idx ) ) {
			subdict = dictByCode2Idx.get( newKeyCode2Idx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffISOLang >();
			dictByCode2Idx.put( newKeyCode2Idx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteISOLang( ISecureAuthorization Authorization,
		ISecureISOLang iBuff )
	{
		final String S_ProcName = "SecureRamISOLangTable.deleteISOLang() ";
		SecureBuffISOLang Buff = (SecureBuffISOLang)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffISOLang existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteISOLang",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckISOLangCountries[] = schema.getTableISOCtryLang().readDerivedByLangIdx( Authorization,
						existing.getRequiredISOLangId() );
		if( arrCheckISOLangCountries.length > 0 ) {
			schema.getTableISOCtryLang().deleteISOCtryLangByLangIdx( Authorization,
						existing.getRequiredISOLangId() );
		}
		SecureBuffISOLangByCode3IdxKey keyCode3Idx = (SecureBuffISOLangByCode3IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode3IdxKey();
		keyCode3Idx.setRequiredISO6392Code( existing.getRequiredISO6392Code() );

		SecureBuffISOLangByCode2IdxKey keyCode2Idx = (SecureBuffISOLangByCode2IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode2IdxKey();
		keyCode2Idx.setOptionalISO6391Code( existing.getOptionalISO6391Code() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffISOLang > subdict;

		dictByPKey.remove( pkey );

		dictByCode3Idx.remove( keyCode3Idx );

		subdict = dictByCode2Idx.get( keyCode2Idx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteISOLangByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffISOLang cur;
		LinkedList<SecureBuffISOLang> matchSet = new LinkedList<SecureBuffISOLang>();
		Iterator<SecureBuffISOLang> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOLang> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOLang)(schema.getTableISOLang().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOLangId() ));
			deleteISOLang( Authorization, cur );
		}
	}

	@Override
	public void deleteISOLangByCode3Idx( ISecureAuthorization Authorization,
		String argISO6392Code )
	{
		SecureBuffISOLangByCode3IdxKey key = (SecureBuffISOLangByCode3IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode3IdxKey();
		key.setRequiredISO6392Code( argISO6392Code );
		deleteISOLangByCode3Idx( Authorization, key );
	}

	@Override
	public void deleteISOLangByCode3Idx( ISecureAuthorization Authorization,
		ISecureISOLangByCode3IdxKey argKey )
	{
		SecureBuffISOLang cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOLang> matchSet = new LinkedList<SecureBuffISOLang>();
		Iterator<SecureBuffISOLang> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOLang> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOLang)(schema.getTableISOLang().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOLangId() ));
			deleteISOLang( Authorization, cur );
		}
	}

	@Override
	public void deleteISOLangByCode2Idx( ISecureAuthorization Authorization,
		String argISO6391Code )
	{
		SecureBuffISOLangByCode2IdxKey key = (SecureBuffISOLangByCode2IdxKey)schema.getSecureBuffFactory().getFactoryISOLang().newByCode2IdxKey();
		key.setOptionalISO6391Code( argISO6391Code );
		deleteISOLangByCode2Idx( Authorization, key );
	}

	@Override
	public void deleteISOLangByCode2Idx( ISecureAuthorization Authorization,
		ISecureISOLangByCode2IdxKey argKey )
	{
		SecureBuffISOLang cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalISO6391Code() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOLang> matchSet = new LinkedList<SecureBuffISOLang>();
		Iterator<SecureBuffISOLang> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOLang> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOLang)(schema.getTableISOLang().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOLangId() ));
			deleteISOLang( Authorization, cur );
		}
	}
}
