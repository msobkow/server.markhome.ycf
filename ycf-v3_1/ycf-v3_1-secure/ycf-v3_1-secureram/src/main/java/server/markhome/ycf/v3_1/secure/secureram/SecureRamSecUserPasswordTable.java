
// Description: Java 25 in-memory RAM DbIO implementation for SecUserPassword.

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
 *	SecureRamSecUserPasswordTable in-memory RAM DbIO implementation
 *	for SecUserPassword.
 */
public class SecureRamSecUserPasswordTable
	implements ISecureSecUserPasswordTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecUserPassword > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecUserPassword >();
	private Map< SecureBuffSecUserPasswordBySetStampIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserPassword >> dictBySetStampIdx
		= new HashMap< SecureBuffSecUserPasswordBySetStampIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecUserPassword >>();

	public SecureRamSecUserPasswordTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecUserPassword ensureRec(ISecureSecUserPassword rec) {
		return (((SecureBuffSecUserPasswordFactoryService)(schema.getSecureBuffFactory().getFactorySecUserPassword())).ensureRec(rec));
	}

	@Override
	public ISecureSecUserPassword createSecUserPassword( ISecureAuthorization Authorization,
		ISecureSecUserPassword iBuff )
	{
		final String S_ProcName = "createSecUserPassword";
		
		SecureBuffSecUserPassword Buff = (SecureBuffSecUserPassword)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = Buff.getRequiredSecUserId();
		pkey = Buff.getRequiredSecUserId();
		Buff.setRequiredContainerUser( pkey );
		Buff.setRequiredSecUserId( pkey );
		SecureBuffSecUserPasswordBySetStampIdxKey keySetStampIdx = (SecureBuffSecUserPasswordBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPassword().newBySetStampIdxKey();
		keySetStampIdx.setRequiredPWSetStamp( Buff.getRequiredPWSetStamp() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecUserId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"SecUser",
						"SecUser",
						"SecUser",
						"SecUser",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPassword > subdictSetStampIdx;
		if( dictBySetStampIdx.containsKey( keySetStampIdx ) ) {
			subdictSetStampIdx = dictBySetStampIdx.get( keySetStampIdx );
		}
		else {
			subdictSetStampIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserPassword >();
			dictBySetStampIdx.put( keySetStampIdx, subdictSetStampIdx );
		}
		subdictSetStampIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecUserPassword.CLASS_CODE) {
				SecureBuffSecUserPassword retbuff = ((SecureBuffSecUserPassword)(schema.getSecureBuffFactory().getFactorySecUserPassword().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecUserPassword readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUserPassword.readDerived";
		ISecureSecUserPassword buff;
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
	public ISecureSecUserPassword lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUserPassword.lockDerived";
		ISecureSecUserPassword buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPassword[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecUserPassword.readAllDerived";
		ISecureSecUserPassword[] retList = new ISecureSecUserPassword[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecUserPassword > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecUserPassword[] readDerivedBySetStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWSetStamp )
	{
		final String S_ProcName = "SecureRamSecUserPassword.readDerivedBySetStampIdx";
		SecureBuffSecUserPasswordBySetStampIdxKey key = (SecureBuffSecUserPasswordBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPassword().newBySetStampIdxKey();

		key.setRequiredPWSetStamp( PWSetStamp );
		ISecureSecUserPassword[] recArray;
		if( dictBySetStampIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPassword > subdictSetStampIdx
				= dictBySetStampIdx.get( key );
			recArray = new ISecureSecUserPassword[ subdictSetStampIdx.size() ];
			Iterator< SecureBuffSecUserPassword > iter = subdictSetStampIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPassword > subdictSetStampIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserPassword >();
			dictBySetStampIdx.put( key, subdictSetStampIdx );
			recArray = new ISecureSecUserPassword[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecUserPassword readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUserPassword.readDerivedByIdIdx() ";
		ISecureSecUserPassword buff;
		if( dictByPKey.containsKey( SecUserId ) ) {
			buff = dictByPKey.get( SecUserId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPassword readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecUserPassword.readRec";
		ISecureSecUserPassword buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUserPassword.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPassword lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecUserPassword buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecUserPassword.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecUserPassword[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecUserPassword.readAllRec";
		ISecureSecUserPassword buff;
		ArrayList<ISecureSecUserPassword> filteredList = new ArrayList<ISecureSecUserPassword>();
		ISecureSecUserPassword[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPassword.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserPassword[0] ) );
	}

	@Override
	public ISecureSecUserPassword readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "SecureRamSecUserPassword.readRecByIdIdx() ";
		ISecureSecUserPassword buff = readDerivedByIdIdx( Authorization,
			SecUserId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPassword.CLASS_CODE ) ) {
			return( (ISecureSecUserPassword)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecUserPassword[] readRecBySetStampIdx( ISecureAuthorization Authorization,
		LocalDateTime PWSetStamp )
	{
		final String S_ProcName = "SecureRamSecUserPassword.readRecBySetStampIdx() ";
		ISecureSecUserPassword buff;
		ArrayList<ISecureSecUserPassword> filteredList = new ArrayList<ISecureSecUserPassword>();
		ISecureSecUserPassword[] buffList = readDerivedBySetStampIdx( Authorization,
			PWSetStamp );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecUserPassword.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecUserPassword)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecUserPassword[0] ) );
	}

	public ISecureSecUserPassword updateSecUserPassword( ISecureAuthorization Authorization,
		ISecureSecUserPassword iBuff )
	{
		SecureBuffSecUserPassword Buff = (SecureBuffSecUserPassword)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecUserPassword existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecUserPassword",
				"Existing record not found",
				"Existing record not found",
				"SecUserPassword",
				"SecUserPassword",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecUserPassword",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecUserPasswordBySetStampIdxKey existingKeySetStampIdx = (SecureBuffSecUserPasswordBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPassword().newBySetStampIdxKey();
		existingKeySetStampIdx.setRequiredPWSetStamp( existing.getRequiredPWSetStamp() );

		SecureBuffSecUserPasswordBySetStampIdxKey newKeySetStampIdx = (SecureBuffSecUserPasswordBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPassword().newBySetStampIdxKey();
		newKeySetStampIdx.setRequiredPWSetStamp( Buff.getRequiredPWSetStamp() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSecUser().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSecUserId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSecUserPassword",
						"Container",
						"Container",
						"SecUser",
						"SecUser",
						"SecUser",
						"SecUser",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPassword > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySetStampIdx.get( existingKeySetStampIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySetStampIdx.containsKey( newKeySetStampIdx ) ) {
			subdict = dictBySetStampIdx.get( newKeySetStampIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecUserPassword >();
			dictBySetStampIdx.put( newKeySetStampIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecUserPassword( ISecureAuthorization Authorization,
		ISecureSecUserPassword iBuff )
	{
		final String S_ProcName = "SecureRamSecUserPasswordTable.deleteSecUserPassword() ";
		SecureBuffSecUserPassword Buff = (SecureBuffSecUserPassword)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecUserPassword existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecUserPassword",
				pkey );
		}
		SecureBuffSecUserPasswordBySetStampIdxKey keySetStampIdx = (SecureBuffSecUserPasswordBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPassword().newBySetStampIdxKey();
		keySetStampIdx.setRequiredPWSetStamp( existing.getRequiredPWSetStamp() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecUserPassword > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySetStampIdx.get( keySetStampIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecUserPasswordByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecUserPassword cur;
		LinkedList<SecureBuffSecUserPassword> matchSet = new LinkedList<SecureBuffSecUserPassword>();
		Iterator<SecureBuffSecUserPassword> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPassword> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPassword)(schema.getTableSecUserPassword().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserPassword( Authorization, cur );
		}
	}

	@Override
	public void deleteSecUserPasswordBySetStampIdx( ISecureAuthorization Authorization,
		LocalDateTime argPWSetStamp )
	{
		SecureBuffSecUserPasswordBySetStampIdxKey key = (SecureBuffSecUserPasswordBySetStampIdxKey)schema.getSecureBuffFactory().getFactorySecUserPassword().newBySetStampIdxKey();
		key.setRequiredPWSetStamp( argPWSetStamp );
		deleteSecUserPasswordBySetStampIdx( Authorization, key );
	}

	@Override
	public void deleteSecUserPasswordBySetStampIdx( ISecureAuthorization Authorization,
		ISecureSecUserPasswordBySetStampIdxKey argKey )
	{
		SecureBuffSecUserPassword cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecUserPassword> matchSet = new LinkedList<SecureBuffSecUserPassword>();
		Iterator<SecureBuffSecUserPassword> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecUserPassword> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecUserPassword)(schema.getTableSecUserPassword().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecUserId() ));
			deleteSecUserPassword( Authorization, cur );
		}
	}
}
