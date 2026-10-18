
// Description: Java 25 in-memory RAM DbIO implementation for SecSysGrp.

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
 *	SecureRamSecSysGrpTable in-memory RAM DbIO implementation
 *	for SecSysGrp.
 */
public class SecureRamSecSysGrpTable
	implements ISecureSecSysGrpTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffSecSysGrp > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffSecSysGrp >();
	private Map< SecureBuffSecSysGrpByUNameIdxKey,
			SecureBuffSecSysGrp > dictByUNameIdx
		= new HashMap< SecureBuffSecSysGrpByUNameIdxKey,
			SecureBuffSecSysGrp >();
	private Map< SecureBuffSecSysGrpBySecLevelIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecSysGrp >> dictBySecLevelIdx
		= new HashMap< SecureBuffSecSysGrpBySecLevelIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffSecSysGrp >>();

	public SecureRamSecSysGrpTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffSecSysGrp ensureRec(ISecureSecSysGrp rec) {
		return (((SecureBuffSecSysGrpFactoryService)(schema.getSecureBuffFactory().getFactorySecSysGrp())).ensureRec(rec));
	}

	@Override
	public ISecureSecSysGrp createSecSysGrp( ISecureAuthorization Authorization,
		ISecureSecSysGrp iBuff )
	{
		final String S_ProcName = "createSecSysGrp";
		
		SecureBuffSecSysGrp Buff = (SecureBuffSecSysGrp)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextSecSysGrpIdGen();
		Buff.setRequiredSecSysGrpId( pkey );
		SecureBuffSecSysGrpByUNameIdxKey keyUNameIdx = (SecureBuffSecSysGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		SecureBuffSecSysGrpBySecLevelIdxKey keySecLevelIdx = (SecureBuffSecSysGrpBySecLevelIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
		keySecLevelIdx.setRequiredSecLevel( Buff.getRequiredSecLevel() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SecSysGrpUNameIdx",
				"SecSysGrpUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSysGrp > subdictSecLevelIdx;
		if( dictBySecLevelIdx.containsKey( keySecLevelIdx ) ) {
			subdictSecLevelIdx = dictBySecLevelIdx.get( keySecLevelIdx );
		}
		else {
			subdictSecLevelIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSysGrp >();
			dictBySecLevelIdx.put( keySecLevelIdx, subdictSecLevelIdx );
		}
		subdictSecLevelIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureSecSysGrp.CLASS_CODE) {
				SecureBuffSecSysGrp retbuff = ((SecureBuffSecSysGrp)(schema.getSecureBuffFactory().getFactorySecSysGrp().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureSecSysGrp readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecSysGrp.readDerived";
		ISecureSecSysGrp buff;
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
	public ISecureSecSysGrp lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecSysGrp.lockDerived";
		ISecureSecSysGrp buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrp[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamSecSysGrp.readAllDerived";
		ISecureSecSysGrp[] retList = new ISecureSecSysGrp[ dictByPKey.values().size() ];
		Iterator< SecureBuffSecSysGrp > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureSecSysGrp readDerivedByUNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecSysGrp.readDerivedByUNameIdx";
		SecureBuffSecSysGrpByUNameIdxKey key = (SecureBuffSecSysGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newByUNameIdxKey();

		key.setRequiredName( Name );
		ISecureSecSysGrp buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrp[] readDerivedBySecLevelIdx( ISecureAuthorization Authorization,
		ISecurePubSchema.SecLevelEnum SecLevel )
	{
		final String S_ProcName = "SecureRamSecSysGrp.readDerivedBySecLevelIdx";
		SecureBuffSecSysGrpBySecLevelIdxKey key = (SecureBuffSecSysGrpBySecLevelIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newBySecLevelIdxKey();

		key.setRequiredSecLevel( SecLevel );
		ISecureSecSysGrp[] recArray;
		if( dictBySecLevelIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecSysGrp > subdictSecLevelIdx
				= dictBySecLevelIdx.get( key );
			recArray = new ISecureSecSysGrp[ subdictSecLevelIdx.size() ];
			Iterator< SecureBuffSecSysGrp > iter = subdictSecLevelIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffSecSysGrp > subdictSecLevelIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSysGrp >();
			dictBySecLevelIdx.put( key, subdictSecLevelIdx );
			recArray = new ISecureSecSysGrp[0];
		}
		return( recArray );
	}

	@Override
	public ISecureSecSysGrp readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId )
	{
		final String S_ProcName = "SecureRamSecSysGrp.readDerivedByIdIdx() ";
		ISecureSecSysGrp buff;
		if( dictByPKey.containsKey( SecSysGrpId ) ) {
			buff = dictByPKey.get( SecSysGrpId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrp readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamSecSysGrp.readRec";
		ISecureSecSysGrp buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysGrp.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrp lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureSecSysGrp buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureSecSysGrp.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureSecSysGrp[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamSecSysGrp.readAllRec";
		ISecureSecSysGrp buff;
		ArrayList<ISecureSecSysGrp> filteredList = new ArrayList<ISecureSecSysGrp>();
		ISecureSecSysGrp[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrp.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysGrp[0] ) );
	}

	@Override
	public ISecureSecSysGrp readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SecSysGrpId )
	{
		final String S_ProcName = "SecureRamSecSysGrp.readRecByIdIdx() ";
		ISecureSecSysGrp buff = readDerivedByIdIdx( Authorization,
			SecSysGrpId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrp.CLASS_CODE ) ) {
			return( (ISecureSecSysGrp)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecSysGrp readRecByUNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "SecureRamSecSysGrp.readRecByUNameIdx() ";
		ISecureSecSysGrp buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrp.CLASS_CODE ) ) {
			return( (ISecureSecSysGrp)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureSecSysGrp[] readRecBySecLevelIdx( ISecureAuthorization Authorization,
		ISecurePubSchema.SecLevelEnum SecLevel )
	{
		final String S_ProcName = "SecureRamSecSysGrp.readRecBySecLevelIdx() ";
		ISecureSecSysGrp buff;
		ArrayList<ISecureSecSysGrp> filteredList = new ArrayList<ISecureSecSysGrp>();
		ISecureSecSysGrp[] buffList = readDerivedBySecLevelIdx( Authorization,
			SecLevel );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureSecSysGrp.CLASS_CODE ) ) {
				filteredList.add( (ISecureSecSysGrp)buff );
			}
		}
		return( filteredList.toArray( new ISecureSecSysGrp[0] ) );
	}

	public ISecureSecSysGrp updateSecSysGrp( ISecureAuthorization Authorization,
		ISecureSecSysGrp iBuff )
	{
		SecureBuffSecSysGrp Buff = (SecureBuffSecSysGrp)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffSecSysGrp existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSecSysGrp",
				"Existing record not found",
				"Existing record not found",
				"SecSysGrp",
				"SecSysGrp",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateSecSysGrp",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffSecSysGrpByUNameIdxKey existingKeyUNameIdx = (SecureBuffSecSysGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecSysGrpByUNameIdxKey newKeyUNameIdx = (SecureBuffSecSysGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		SecureBuffSecSysGrpBySecLevelIdxKey existingKeySecLevelIdx = (SecureBuffSecSysGrpBySecLevelIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
		existingKeySecLevelIdx.setRequiredSecLevel( existing.getRequiredSecLevel() );

		SecureBuffSecSysGrpBySecLevelIdxKey newKeySecLevelIdx = (SecureBuffSecSysGrpBySecLevelIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
		newKeySecLevelIdx.setRequiredSecLevel( Buff.getRequiredSecLevel() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSecSysGrp",
					"SecSysGrpUNameIdx",
					"SecSysGrpUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSysGrp > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictBySecLevelIdx.get( existingKeySecLevelIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySecLevelIdx.containsKey( newKeySecLevelIdx ) ) {
			subdict = dictBySecLevelIdx.get( newKeySecLevelIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffSecSysGrp >();
			dictBySecLevelIdx.put( newKeySecLevelIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSecSysGrp( ISecureAuthorization Authorization,
		ISecureSecSysGrp iBuff )
	{
		final String S_ProcName = "SecureRamSecSysGrpTable.deleteSecSysGrp() ";
		SecureBuffSecSysGrp Buff = (SecureBuffSecSysGrp)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffSecSysGrp existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSecSysGrp",
				pkey );
		}
					schema.getTableSecSysGrpMemb().deleteSecSysGrpMembBySysGrpIdx( Authorization,
						existing.getRequiredSecSysGrpId() );
					schema.getTableSecSysGrpInc().deleteSecSysGrpIncBySysGrpIdx( Authorization,
						existing.getRequiredSecSysGrpId() );
		SecureBuffSecSysGrpByUNameIdxKey keyUNameIdx = (SecureBuffSecSysGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		SecureBuffSecSysGrpBySecLevelIdxKey keySecLevelIdx = (SecureBuffSecSysGrpBySecLevelIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
		keySecLevelIdx.setRequiredSecLevel( existing.getRequiredSecLevel() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffSecSysGrp > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictBySecLevelIdx.get( keySecLevelIdx );
		subdict.remove( pkey );

	}
	@Override
	public void deleteSecSysGrpByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffSecSysGrp cur;
		LinkedList<SecureBuffSecSysGrp> matchSet = new LinkedList<SecureBuffSecSysGrp>();
		Iterator<SecureBuffSecSysGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysGrp)(schema.getTableSecSysGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysGrpId() ));
			deleteSecSysGrp( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysGrpByUNameIdx( ISecureAuthorization Authorization,
		String argName )
	{
		SecureBuffSecSysGrpByUNameIdxKey key = (SecureBuffSecSysGrpByUNameIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newByUNameIdxKey();
		key.setRequiredName( argName );
		deleteSecSysGrpByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysGrpByUNameIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpByUNameIdxKey argKey )
	{
		SecureBuffSecSysGrp cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysGrp> matchSet = new LinkedList<SecureBuffSecSysGrp>();
		Iterator<SecureBuffSecSysGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysGrp)(schema.getTableSecSysGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysGrpId() ));
			deleteSecSysGrp( Authorization, cur );
		}
	}

	@Override
	public void deleteSecSysGrpBySecLevelIdx( ISecureAuthorization Authorization,
		ISecurePubSchema.SecLevelEnum argSecLevel )
	{
		SecureBuffSecSysGrpBySecLevelIdxKey key = (SecureBuffSecSysGrpBySecLevelIdxKey)schema.getSecureBuffFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
		key.setRequiredSecLevel( argSecLevel );
		deleteSecSysGrpBySecLevelIdx( Authorization, key );
	}

	@Override
	public void deleteSecSysGrpBySecLevelIdx( ISecureAuthorization Authorization,
		ISecureSecSysGrpBySecLevelIdxKey argKey )
	{
		SecureBuffSecSysGrp cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffSecSysGrp> matchSet = new LinkedList<SecureBuffSecSysGrp>();
		Iterator<SecureBuffSecSysGrp> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffSecSysGrp> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffSecSysGrp)(schema.getTableSecSysGrp().readDerivedByIdIdx( Authorization,
				cur.getRequiredSecSysGrpId() ));
			deleteSecSysGrp( Authorization, cur );
		}
	}
}
