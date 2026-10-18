
// Description: Java 25 in-memory RAM DbIO implementation for ISOCtryLang.

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
 *	SecureRamISOCtryLangTable in-memory RAM DbIO implementation
 *	for ISOCtryLang.
 */
public class SecureRamISOCtryLangTable
	implements ISecureISOCtryLangTable
{
	private ISecureSchema schema;
	private Map< ISecureISOCtryLangPKey,
				SecureBuffISOCtryLang > dictByPKey
		= new HashMap< ISecureISOCtryLangPKey,
				SecureBuffISOCtryLang >();
	private Map< SecureBuffISOCtryLangByCtryIdxKey,
				Map< SecureBuffISOCtryLangPKey,
					SecureBuffISOCtryLang >> dictByCtryIdx
		= new HashMap< SecureBuffISOCtryLangByCtryIdxKey,
				Map< SecureBuffISOCtryLangPKey,
					SecureBuffISOCtryLang >>();
	private Map< SecureBuffISOCtryLangByLangIdxKey,
				Map< SecureBuffISOCtryLangPKey,
					SecureBuffISOCtryLang >> dictByLangIdx
		= new HashMap< SecureBuffISOCtryLangByLangIdxKey,
				Map< SecureBuffISOCtryLangPKey,
					SecureBuffISOCtryLang >>();

	public SecureRamISOCtryLangTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffISOCtryLang ensureRec(ISecureISOCtryLang rec) {
		return (((SecureBuffISOCtryLangFactoryService)(schema.getSecureBuffFactory().getFactoryISOCtryLang())).ensureRec(rec));
	}

	@Override
	public ISecureISOCtryLang createISOCtryLang( ISecureAuthorization Authorization,
		ISecureISOCtryLang iBuff )
	{
		final String S_ProcName = "createISOCtryLang";
		
		SecureBuffISOCtryLang Buff = (SecureBuffISOCtryLang)ensureRec(iBuff);
		SecureBuffISOCtryLangPKey pkey = (SecureBuffISOCtryLangPKey)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newPKey());
		pkey.setRequiredISOCtryId(Buff.getRequiredISOCtryId());
		pkey.setRequiredISOLangId(Buff.getRequiredISOLangId());
		pkey.setRequiredISOCtryId( Buff.getRequiredISOCtryId() );
		pkey.setRequiredISOLangId( Buff.getRequiredISOLangId() );
		Buff.setRequiredContainerCtry( pkey.getRequiredISOCtryId() );
		Buff.setRequiredParentLang( pkey.getRequiredISOLangId() );
		Buff.setRequiredISOCtryId( pkey.getRequiredISOCtryId() );
		Buff.setRequiredISOLangId( pkey.getRequiredISOLangId() );
		SecureBuffISOCtryLangByCtryIdxKey keyCtryIdx = (SecureBuffISOCtryLangByCtryIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByCtryIdxKey();
		keyCtryIdx.setRequiredISOCtryId( Buff.getRequiredISOCtryId() );

		SecureBuffISOCtryLangByLangIdxKey keyLangIdx = (SecureBuffISOCtryLangByLangIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByLangIdxKey();
		keyLangIdx.setRequiredISOLangId( Buff.getRequiredISOLangId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableISOCtry().readDerivedByIdIdx( Authorization,
						Buff.getRequiredISOCtryId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"ISOCtryLangCtry",
						"ISOCtryLangCtry",
						"ISOCtry",
						"ISOCtry",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang > subdictCtryIdx;
		if( dictByCtryIdx.containsKey( keyCtryIdx ) ) {
			subdictCtryIdx = dictByCtryIdx.get( keyCtryIdx );
		}
		else {
			subdictCtryIdx = new HashMap< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang >();
			dictByCtryIdx.put( keyCtryIdx, subdictCtryIdx );
		}
		subdictCtryIdx.put( pkey, Buff );

		Map< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang > subdictLangIdx;
		if( dictByLangIdx.containsKey( keyLangIdx ) ) {
			subdictLangIdx = dictByLangIdx.get( keyLangIdx );
		}
		else {
			subdictLangIdx = new HashMap< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang >();
			dictByLangIdx.put( keyLangIdx, subdictLangIdx );
		}
		subdictLangIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureISOCtryLang.CLASS_CODE) {
				SecureBuffISOCtryLang retbuff = ((SecureBuffISOCtryLang)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureISOCtryLang readDerived( ISecureAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId )
	{
		{	$implCommaIJavaOptAtomType$ testISOCtryId = ISOCtryId;
			if (testISOCtryId == null) {
				return( null );
			}
		}
		{	$implCommaIJavaOptAtomType$ testISOLangId = ISOLangId;
			if (testISOLangId == null) {
				return( null );
			}
		}
		SecureBuffISOCtryLangPKey key = (SecureBuffISOCtryLangPKey)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newPKey());
		key.setRequiredISOCtryId( ISOCtryId );
		key.setRequiredISOLangId( ISOLangId );
		return( readDerived( Authorization, key ) );
	}

	public ISecureISOCtryLang readDerived( ISecureAuthorization Authorization,
		ISecureISOCtryLangPKey PKey )
	{
		final String S_ProcName = "SecureRamISOCtryLang.readDerived";
		SecureBuffISOCtryLangPKey key = (SecureBuffISOCtryLangPKey)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newPKey());
		key.setRequiredISOCtryId( PKey.getRequiredISOCtryId() );
		key.setRequiredISOLangId( PKey.getRequiredISOLangId() );
		ISecureISOCtryLang buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtryLang lockDerived( ISecureAuthorization Authorization,
		ISecureISOCtryLangPKey PKey )
	{
		final String S_ProcName = "SecureRamISOCtryLang.lockDerived";
		SecureBuffISOCtryLangPKey key = (SecureBuffISOCtryLangPKey)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newPKey());
		key.setRequiredISOCtryId( PKey.getRequiredISOCtryId() );
		key.setRequiredISOLangId( PKey.getRequiredISOLangId() );
		ISecureISOCtryLang buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtryLang[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamISOCtryLang.readAllDerived";
		ISecureISOCtryLang[] retList = new ISecureISOCtryLang[ dictByPKey.values().size() ];
		Iterator< SecureBuffISOCtryLang > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureISOCtryLang[] readDerivedByCtryIdx( ISecureAuthorization Authorization,
		short ISOCtryId )
	{
		final String S_ProcName = "SecureRamISOCtryLang.readDerivedByCtryIdx";
		SecureBuffISOCtryLangByCtryIdxKey key = (SecureBuffISOCtryLangByCtryIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByCtryIdxKey();

		key.setRequiredISOCtryId( ISOCtryId );
		ISecureISOCtryLang[] recArray;
		if( dictByCtryIdx.containsKey( key ) ) {
			Map< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang > subdictCtryIdx
				= dictByCtryIdx.get( key );
			recArray = new ISecureISOCtryLang[ subdictCtryIdx.size() ];
			Iterator< SecureBuffISOCtryLang > iter = subdictCtryIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang > subdictCtryIdx
				= new HashMap< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang >();
			dictByCtryIdx.put( key, subdictCtryIdx );
			recArray = new ISecureISOCtryLang[0];
		}
		return( recArray );
	}

	@Override
	public ISecureISOCtryLang[] readDerivedByLangIdx( ISecureAuthorization Authorization,
		short ISOLangId )
	{
		final String S_ProcName = "SecureRamISOCtryLang.readDerivedByLangIdx";
		SecureBuffISOCtryLangByLangIdxKey key = (SecureBuffISOCtryLangByLangIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByLangIdxKey();

		key.setRequiredISOLangId( ISOLangId );
		ISecureISOCtryLang[] recArray;
		if( dictByLangIdx.containsKey( key ) ) {
			Map< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang > subdictLangIdx
				= dictByLangIdx.get( key );
			recArray = new ISecureISOCtryLang[ subdictLangIdx.size() ];
			Iterator< SecureBuffISOCtryLang > iter = subdictLangIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang > subdictLangIdx
				= new HashMap< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang >();
			dictByLangIdx.put( key, subdictLangIdx );
			recArray = new ISecureISOCtryLang[0];
		}
		return( recArray );
	}

	@Override
	public ISecureISOCtryLang readDerivedByIdIdx( ISecureAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId )
	{
		final String S_ProcName = "SecureRamISOCtryLang.readDerivedByIdIdx() ";
		SecureBuffISOCtryLangPKey key = (SecureBuffISOCtryLangPKey)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newPKey());
		key.setRequiredISOCtryId( ISOCtryId );
		key.setRequiredISOLangId( ISOLangId );
		ISecureISOCtryLang buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtryLang readRec( ISecureAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId )
	{
		SecureBuffISOCtryLangPKey key = (SecureBuffISOCtryLangPKey)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newPKey());
		key.setRequiredISOCtryId( ISOCtryId );
		key.setRequiredISOLangId( ISOLangId );
		return( readRec( Authorization, key ) );
	}

	@Override
	public ISecureISOCtryLang readRec( ISecureAuthorization Authorization,
		ISecureISOCtryLangPKey PKey )
	{
		final String S_ProcName = "SecureRamISOCtryLang.readRec";
		ISecureISOCtryLang buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOCtryLang.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtryLang lockRec( ISecureAuthorization Authorization,
		ISecureISOCtryLangPKey PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureISOCtryLang buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureISOCtryLang.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureISOCtryLang[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamISOCtryLang.readAllRec";
		ISecureISOCtryLang buff;
		ArrayList<ISecureISOCtryLang> filteredList = new ArrayList<ISecureISOCtryLang>();
		ISecureISOCtryLang[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCtryLang.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureISOCtryLang[0] ) );
	}

	@Override
	public ISecureISOCtryLang readRecByIdIdx( ISecureAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId )
	{
		final String S_ProcName = "SecureRamISOCtryLang.readRecByIdIdx() ";
		ISecureISOCtryLang buff = readDerivedByIdIdx( Authorization,
			ISOCtryId,
			ISOLangId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCtryLang.CLASS_CODE ) ) {
			return( (ISecureISOCtryLang)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureISOCtryLang[] readRecByCtryIdx( ISecureAuthorization Authorization,
		short ISOCtryId )
	{
		final String S_ProcName = "SecureRamISOCtryLang.readRecByCtryIdx() ";
		ISecureISOCtryLang buff;
		ArrayList<ISecureISOCtryLang> filteredList = new ArrayList<ISecureISOCtryLang>();
		ISecureISOCtryLang[] buffList = readDerivedByCtryIdx( Authorization,
			ISOCtryId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCtryLang.CLASS_CODE ) ) {
				filteredList.add( (ISecureISOCtryLang)buff );
			}
		}
		return( filteredList.toArray( new ISecureISOCtryLang[0] ) );
	}

	@Override
	public ISecureISOCtryLang[] readRecByLangIdx( ISecureAuthorization Authorization,
		short ISOLangId )
	{
		final String S_ProcName = "SecureRamISOCtryLang.readRecByLangIdx() ";
		ISecureISOCtryLang buff;
		ArrayList<ISecureISOCtryLang> filteredList = new ArrayList<ISecureISOCtryLang>();
		ISecureISOCtryLang[] buffList = readDerivedByLangIdx( Authorization,
			ISOLangId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureISOCtryLang.CLASS_CODE ) ) {
				filteredList.add( (ISecureISOCtryLang)buff );
			}
		}
		return( filteredList.toArray( new ISecureISOCtryLang[0] ) );
	}

	@Override
	public ISecureISOCtryLang updateISOCtryLang( ISecureAuthorization Authorization,
		ISecureISOCtryLang iBuff )
	{
		SecureBuffISOCtryLang Buff = (SecureBuffISOCtryLang)ensureRec(iBuff);
		SecureBuffISOCtryLangPKey pkey = (SecureBuffISOCtryLangPKey)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newPKey());
		pkey = (SecureBuffISOCtryLangPKey)Buff.getPKey();
		SecureBuffISOCtryLang existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateISOCtryLang",
				"Existing record not found",
				"Existing record not found",
				"ISOCtryLang",
				"ISOCtryLang",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateISOCtryLang",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffISOCtryLangByCtryIdxKey existingKeyCtryIdx = (SecureBuffISOCtryLangByCtryIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByCtryIdxKey();
		existingKeyCtryIdx.setRequiredISOCtryId( existing.getRequiredISOCtryId() );

		SecureBuffISOCtryLangByCtryIdxKey newKeyCtryIdx = (SecureBuffISOCtryLangByCtryIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByCtryIdxKey();
		newKeyCtryIdx.setRequiredISOCtryId( Buff.getRequiredISOCtryId() );

		SecureBuffISOCtryLangByLangIdxKey existingKeyLangIdx = (SecureBuffISOCtryLangByLangIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByLangIdxKey();
		existingKeyLangIdx.setRequiredISOLangId( existing.getRequiredISOLangId() );

		SecureBuffISOCtryLangByLangIdxKey newKeyLangIdx = (SecureBuffISOCtryLangByLangIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByLangIdxKey();
		newKeyLangIdx.setRequiredISOLangId( Buff.getRequiredISOLangId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableISOCtry().readDerivedByIdIdx( Authorization,
						Buff.getRequiredISOCtryId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateISOCtryLang",
						"Container",
						"Container",
						"ISOCtryLangCtry",
						"ISOCtryLangCtry",
						"ISOCtry",
						"ISOCtry",
						null );
				}
			}
		}

		// Update is valid

		Map< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByCtryIdx.get( existingKeyCtryIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCtryIdx.containsKey( newKeyCtryIdx ) ) {
			subdict = dictByCtryIdx.get( newKeyCtryIdx );
		}
		else {
			subdict = new HashMap< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang >();
			dictByCtryIdx.put( newKeyCtryIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByLangIdx.get( existingKeyLangIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByLangIdx.containsKey( newKeyLangIdx ) ) {
			subdict = dictByLangIdx.get( newKeyLangIdx );
		}
		else {
			subdict = new HashMap< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang >();
			dictByLangIdx.put( newKeyLangIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteISOCtryLang( ISecureAuthorization Authorization,
		ISecureISOCtryLang iBuff )
	{
		final String S_ProcName = "SecureRamISOCtryLangTable.deleteISOCtryLang() ";
		SecureBuffISOCtryLang Buff = (SecureBuffISOCtryLang)ensureRec(iBuff);
		int classCode;
		SecureBuffISOCtryLangPKey pkey = (SecureBuffISOCtryLangPKey)(Buff.getPKey());
		SecureBuffISOCtryLang existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteISOCtryLang",
				pkey );
		}
		SecureBuffISOCtryLangByCtryIdxKey keyCtryIdx = (SecureBuffISOCtryLangByCtryIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByCtryIdxKey();
		keyCtryIdx.setRequiredISOCtryId( existing.getRequiredISOCtryId() );

		SecureBuffISOCtryLangByLangIdxKey keyLangIdx = (SecureBuffISOCtryLangByLangIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByLangIdxKey();
		keyLangIdx.setRequiredISOLangId( existing.getRequiredISOLangId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< SecureBuffISOCtryLangPKey, SecureBuffISOCtryLang > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByCtryIdx.get( keyCtryIdx );
		subdict.remove( pkey );

		subdict = dictByLangIdx.get( keyLangIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteISOCtryLangByIdIdx( ISecureAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId )
	{
		SecureBuffISOCtryLangPKey key = (SecureBuffISOCtryLangPKey)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newPKey());
		key.setRequiredISOCtryId( ISOCtryId );
		key.setRequiredISOLangId( ISOLangId );
		deleteISOCtryLangByIdIdx( Authorization, key );
	}

	@Override
	public void deleteISOCtryLangByIdIdx( ISecureAuthorization Authorization,
		ISecureISOCtryLangPKey PKey )
	{
		SecureBuffISOCtryLangPKey key = (SecureBuffISOCtryLangPKey)(schema.getSecureBuffFactory().getFactoryISOCtryLang().newPKey());
		key.setRequiredISOCtryId( PKey.getRequiredISOCtryId() );
		key.setRequiredISOLangId( PKey.getRequiredISOLangId() );
		SecureBuffISOCtryLangPKey argKey = key;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffISOCtryLang cur;
		LinkedList<SecureBuffISOCtryLang> matchSet = new LinkedList<SecureBuffISOCtryLang>();
		Iterator<SecureBuffISOCtryLang> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOCtryLang> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOCtryLang)(schema.getTableISOCtryLang().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOCtryId(),
				cur.getRequiredISOLangId() ));
			deleteISOCtryLang( Authorization, cur );
		}
	}

	@Override
	public void deleteISOCtryLangByCtryIdx( ISecureAuthorization Authorization,
		short argISOCtryId )
	{
		SecureBuffISOCtryLangByCtryIdxKey key = (SecureBuffISOCtryLangByCtryIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByCtryIdxKey();
		key.setRequiredISOCtryId( argISOCtryId );
		deleteISOCtryLangByCtryIdx( Authorization, key );
	}

	@Override
	public void deleteISOCtryLangByCtryIdx( ISecureAuthorization Authorization,
		ISecureISOCtryLangByCtryIdxKey argKey )
	{
		SecureBuffISOCtryLang cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOCtryLang> matchSet = new LinkedList<SecureBuffISOCtryLang>();
		Iterator<SecureBuffISOCtryLang> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOCtryLang> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOCtryLang)(schema.getTableISOCtryLang().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOCtryId(),
				cur.getRequiredISOLangId() ));
			deleteISOCtryLang( Authorization, cur );
		}
	}

	@Override
	public void deleteISOCtryLangByLangIdx( ISecureAuthorization Authorization,
		short argISOLangId )
	{
		SecureBuffISOCtryLangByLangIdxKey key = (SecureBuffISOCtryLangByLangIdxKey)schema.getSecureBuffFactory().getFactoryISOCtryLang().newByLangIdxKey();
		key.setRequiredISOLangId( argISOLangId );
		deleteISOCtryLangByLangIdx( Authorization, key );
	}

	@Override
	public void deleteISOCtryLangByLangIdx( ISecureAuthorization Authorization,
		ISecureISOCtryLangByLangIdxKey argKey )
	{
		SecureBuffISOCtryLang cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffISOCtryLang> matchSet = new LinkedList<SecureBuffISOCtryLang>();
		Iterator<SecureBuffISOCtryLang> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffISOCtryLang> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffISOCtryLang)(schema.getTableISOCtryLang().readDerivedByIdIdx( Authorization,
				cur.getRequiredISOCtryId(),
				cur.getRequiredISOLangId() ));
			deleteISOCtryLang( Authorization, cur );
		}
	}
}
