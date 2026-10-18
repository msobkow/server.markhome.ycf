
// Description: Java 25 in-memory RAM DbIO implementation for TableInfo.

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
 *	SecureRamTableInfoTable in-memory RAM DbIO implementation
 *	for TableInfo.
 */
public class SecureRamTableInfoTable
	implements ISecureTableInfoTable
{
	private ISecureSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				SecureBuffTableInfo > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				SecureBuffTableInfo >();
	private Map< SecureBuffTableInfoByTableNameIdxKey,
			SecureBuffTableInfo > dictByTableNameIdx
		= new HashMap< SecureBuffTableInfoByTableNameIdxKey,
			SecureBuffTableInfo >();
	private Map< SecureBuffTableInfoBySuperNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffTableInfo >> dictBySuperNameIdx
		= new HashMap< SecureBuffTableInfoBySuperNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffTableInfo >>();
	private Map< SecureBuffTableInfoBySchemaNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffTableInfo >> dictBySchemaNameIdx
		= new HashMap< SecureBuffTableInfoBySchemaNameIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					SecureBuffTableInfo >>();
	private Map< SecureBuffTableInfoBySchemaBkCodeIdxKey,
			SecureBuffTableInfo > dictBySchemaBkCodeIdx
		= new HashMap< SecureBuffTableInfoBySchemaBkCodeIdxKey,
			SecureBuffTableInfo >();
	private Map< SecureBuffTableInfoBySchemaRTCodeIdxKey,
			SecureBuffTableInfo > dictBySchemaRTCodeIdx
		= new HashMap< SecureBuffTableInfoBySchemaRTCodeIdxKey,
			SecureBuffTableInfo >();

	public SecureRamTableInfoTable( ISecureSchema argSchema ) {
		schema = argSchema;
	}

	public SecureBuffTableInfo ensureRec(ISecureTableInfo rec) {
		return (((SecureBuffTableInfoFactoryService)(schema.getSecureBuffFactory().getFactoryTableInfo())).ensureRec(rec));
	}

	@Override
	public ISecureTableInfo createTableInfo( ISecureAuthorization Authorization,
		ISecureTableInfo iBuff )
	{
		final String S_ProcName = "createTableInfo";
		
		SecureBuffTableInfo Buff = (SecureBuffTableInfo)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextTableInfoIdGen();
		Buff.setRequiredTableInfoId( pkey );
		SecureBuffTableInfoByTableNameIdxKey keyTableNameIdx = (SecureBuffTableInfoByTableNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newByTableNameIdxKey();
		keyTableNameIdx.setRequiredTableName( Buff.getRequiredTableName() );

		SecureBuffTableInfoBySuperNameIdxKey keySuperNameIdx = (SecureBuffTableInfoBySuperNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySuperNameIdxKey();
		keySuperNameIdx.setOptionalSuperName( Buff.getOptionalSuperName() );

		SecureBuffTableInfoBySchemaNameIdxKey keySchemaNameIdx = (SecureBuffTableInfoBySchemaNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
		keySchemaNameIdx.setRequiredSchemaName( Buff.getRequiredSchemaName() );

		SecureBuffTableInfoBySchemaBkCodeIdxKey keySchemaBkCodeIdx = (SecureBuffTableInfoBySchemaBkCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
		keySchemaBkCodeIdx.setRequiredSchemaName( Buff.getRequiredSchemaName() );
		keySchemaBkCodeIdx.setRequiredBackingClassCode( Buff.getRequiredBackingClassCode() );

		SecureBuffTableInfoBySchemaRTCodeIdxKey keySchemaRTCodeIdx = (SecureBuffTableInfoBySchemaRTCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
		keySchemaRTCodeIdx.setRequiredRuntimeClassCode( Buff.getRequiredRuntimeClassCode() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByTableNameIdx.containsKey( keyTableNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TableInfoTableNameIdx",
				"TableInfoTableNameIdx",
				keyTableNameIdx );
		}

		if( dictBySchemaBkCodeIdx.containsKey( keySchemaBkCodeIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TableInfoSchemaBkCodeIdx",
				"TableInfoSchemaBkCodeIdx",
				keySchemaBkCodeIdx );
		}

		if( dictBySchemaRTCodeIdx.containsKey( keySchemaRTCodeIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"TableInfoSchemaRTCodeIdx",
				"TableInfoSchemaRTCodeIdx",
				keySchemaRTCodeIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByTableNameIdx.put( keyTableNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffTableInfo > subdictSuperNameIdx;
		if( dictBySuperNameIdx.containsKey( keySuperNameIdx ) ) {
			subdictSuperNameIdx = dictBySuperNameIdx.get( keySuperNameIdx );
		}
		else {
			subdictSuperNameIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffTableInfo >();
			dictBySuperNameIdx.put( keySuperNameIdx, subdictSuperNameIdx );
		}
		subdictSuperNameIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, SecureBuffTableInfo > subdictSchemaNameIdx;
		if( dictBySchemaNameIdx.containsKey( keySchemaNameIdx ) ) {
			subdictSchemaNameIdx = dictBySchemaNameIdx.get( keySchemaNameIdx );
		}
		else {
			subdictSchemaNameIdx = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffTableInfo >();
			dictBySchemaNameIdx.put( keySchemaNameIdx, subdictSchemaNameIdx );
		}
		subdictSchemaNameIdx.put( pkey, Buff );

		dictBySchemaBkCodeIdx.put( keySchemaBkCodeIdx, Buff );

		dictBySchemaRTCodeIdx.put( keySchemaRTCodeIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == ISecureTableInfo.CLASS_CODE) {
				SecureBuffTableInfo retbuff = ((SecureBuffTableInfo)(schema.getSecureBuffFactory().getFactoryTableInfo().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public ISecureTableInfo readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamTableInfo.readDerived";
		ISecureTableInfo buff;
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
	public ISecureTableInfo lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamTableInfo.lockDerived";
		ISecureTableInfo buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTableInfo[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "SecureRamTableInfo.readAllDerived";
		ISecureTableInfo[] retList = new ISecureTableInfo[ dictByPKey.values().size() ];
		Iterator< SecureBuffTableInfo > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public ISecureTableInfo readDerivedByTableNameIdx( ISecureAuthorization Authorization,
		String TableName )
	{
		final String S_ProcName = "SecureRamTableInfo.readDerivedByTableNameIdx";
		SecureBuffTableInfoByTableNameIdxKey key = (SecureBuffTableInfoByTableNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newByTableNameIdxKey();

		key.setRequiredTableName( TableName );
		ISecureTableInfo buff;
		if( dictByTableNameIdx.containsKey( key ) ) {
			buff = dictByTableNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTableInfo[] readDerivedBySuperNameIdx( ISecureAuthorization Authorization,
		String SuperName )
	{
		final String S_ProcName = "SecureRamTableInfo.readDerivedBySuperNameIdx";
		SecureBuffTableInfoBySuperNameIdxKey key = (SecureBuffTableInfoBySuperNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySuperNameIdxKey();

		key.setOptionalSuperName( SuperName );
		ISecureTableInfo[] recArray;
		if( dictBySuperNameIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffTableInfo > subdictSuperNameIdx
				= dictBySuperNameIdx.get( key );
			recArray = new ISecureTableInfo[ subdictSuperNameIdx.size() ];
			Iterator< SecureBuffTableInfo > iter = subdictSuperNameIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffTableInfo > subdictSuperNameIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffTableInfo >();
			dictBySuperNameIdx.put( key, subdictSuperNameIdx );
			recArray = new ISecureTableInfo[0];
		}
		return( recArray );
	}

	@Override
	public ISecureTableInfo[] readDerivedBySchemaNameIdx( ISecureAuthorization Authorization,
		String SchemaName )
	{
		final String S_ProcName = "SecureRamTableInfo.readDerivedBySchemaNameIdx";
		SecureBuffTableInfoBySchemaNameIdxKey key = (SecureBuffTableInfoBySchemaNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaNameIdxKey();

		key.setRequiredSchemaName( SchemaName );
		ISecureTableInfo[] recArray;
		if( dictBySchemaNameIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, SecureBuffTableInfo > subdictSchemaNameIdx
				= dictBySchemaNameIdx.get( key );
			recArray = new ISecureTableInfo[ subdictSchemaNameIdx.size() ];
			Iterator< SecureBuffTableInfo > iter = subdictSchemaNameIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, SecureBuffTableInfo > subdictSchemaNameIdx
				= new HashMap< $implCommaIJavaOptAtomType$, SecureBuffTableInfo >();
			dictBySchemaNameIdx.put( key, subdictSchemaNameIdx );
			recArray = new ISecureTableInfo[0];
		}
		return( recArray );
	}

	@Override
	public ISecureTableInfo readDerivedBySchemaBkCodeIdx( ISecureAuthorization Authorization,
		String SchemaName,
		int BackingClassCode )
	{
		final String S_ProcName = "SecureRamTableInfo.readDerivedBySchemaBkCodeIdx";
		SecureBuffTableInfoBySchemaBkCodeIdxKey key = (SecureBuffTableInfoBySchemaBkCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();

		key.setRequiredSchemaName( SchemaName );
		key.setRequiredBackingClassCode( BackingClassCode );
		ISecureTableInfo buff;
		if( dictBySchemaBkCodeIdx.containsKey( key ) ) {
			buff = dictBySchemaBkCodeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTableInfo readDerivedBySchemaRTCodeIdx( ISecureAuthorization Authorization,
		int RuntimeClassCode )
	{
		final String S_ProcName = "SecureRamTableInfo.readDerivedBySchemaRTCodeIdx";
		SecureBuffTableInfoBySchemaRTCodeIdxKey key = (SecureBuffTableInfoBySchemaRTCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();

		key.setRequiredRuntimeClassCode( RuntimeClassCode );
		ISecureTableInfo buff;
		if( dictBySchemaRTCodeIdx.containsKey( key ) ) {
			buff = dictBySchemaRTCodeIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTableInfo readDerivedByIdIdx( ISecureAuthorization Authorization,
		int TableInfoId )
	{
		final String S_ProcName = "SecureRamTableInfo.readDerivedByIdIdx() ";
		ISecureTableInfo buff;
		if( dictByPKey.containsKey( TableInfoId ) ) {
			buff = dictByPKey.get( TableInfoId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTableInfo readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "SecureRamTableInfo.readRec";
		ISecureTableInfo buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureTableInfo.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTableInfo lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		ISecureTableInfo buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != ISecureTableInfo.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public ISecureTableInfo[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "SecureRamTableInfo.readAllRec";
		ISecureTableInfo buff;
		ArrayList<ISecureTableInfo> filteredList = new ArrayList<ISecureTableInfo>();
		ISecureTableInfo[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureTableInfo.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new ISecureTableInfo[0] ) );
	}

	@Override
	public ISecureTableInfo readRecByIdIdx( ISecureAuthorization Authorization,
		int TableInfoId )
	{
		final String S_ProcName = "SecureRamTableInfo.readRecByIdIdx() ";
		ISecureTableInfo buff = readDerivedByIdIdx( Authorization,
			TableInfoId );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureTableInfo.CLASS_CODE ) ) {
			return( (ISecureTableInfo)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureTableInfo readRecByTableNameIdx( ISecureAuthorization Authorization,
		String TableName )
	{
		final String S_ProcName = "SecureRamTableInfo.readRecByTableNameIdx() ";
		ISecureTableInfo buff = readDerivedByTableNameIdx( Authorization,
			TableName );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureTableInfo.CLASS_CODE ) ) {
			return( (ISecureTableInfo)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureTableInfo[] readRecBySuperNameIdx( ISecureAuthorization Authorization,
		String SuperName )
	{
		final String S_ProcName = "SecureRamTableInfo.readRecBySuperNameIdx() ";
		ISecureTableInfo buff;
		ArrayList<ISecureTableInfo> filteredList = new ArrayList<ISecureTableInfo>();
		ISecureTableInfo[] buffList = readDerivedBySuperNameIdx( Authorization,
			SuperName );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureTableInfo.CLASS_CODE ) ) {
				filteredList.add( (ISecureTableInfo)buff );
			}
		}
		return( filteredList.toArray( new ISecureTableInfo[0] ) );
	}

	@Override
	public ISecureTableInfo[] readRecBySchemaNameIdx( ISecureAuthorization Authorization,
		String SchemaName )
	{
		final String S_ProcName = "SecureRamTableInfo.readRecBySchemaNameIdx() ";
		ISecureTableInfo buff;
		ArrayList<ISecureTableInfo> filteredList = new ArrayList<ISecureTableInfo>();
		ISecureTableInfo[] buffList = readDerivedBySchemaNameIdx( Authorization,
			SchemaName );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == ISecureTableInfo.CLASS_CODE ) ) {
				filteredList.add( (ISecureTableInfo)buff );
			}
		}
		return( filteredList.toArray( new ISecureTableInfo[0] ) );
	}

	@Override
	public ISecureTableInfo readRecBySchemaBkCodeIdx( ISecureAuthorization Authorization,
		String SchemaName,
		int BackingClassCode )
	{
		final String S_ProcName = "SecureRamTableInfo.readRecBySchemaBkCodeIdx() ";
		ISecureTableInfo buff = readDerivedBySchemaBkCodeIdx( Authorization,
			SchemaName,
			BackingClassCode );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureTableInfo.CLASS_CODE ) ) {
			return( (ISecureTableInfo)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public ISecureTableInfo readRecBySchemaRTCodeIdx( ISecureAuthorization Authorization,
		int RuntimeClassCode )
	{
		final String S_ProcName = "SecureRamTableInfo.readRecBySchemaRTCodeIdx() ";
		ISecureTableInfo buff = readDerivedBySchemaRTCodeIdx( Authorization,
			RuntimeClassCode );
		if( ( buff != null ) && ( buff.getClassCode() == ISecureTableInfo.CLASS_CODE ) ) {
			return( (ISecureTableInfo)buff );
		}
		else {
			return( null );
		}
	}

	public ISecureTableInfo updateTableInfo( ISecureAuthorization Authorization,
		ISecureTableInfo iBuff )
	{
		SecureBuffTableInfo Buff = (SecureBuffTableInfo)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		SecureBuffTableInfo existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateTableInfo",
				"Existing record not found",
				"Existing record not found",
				"TableInfo",
				"TableInfo",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateTableInfo",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		SecureBuffTableInfoByTableNameIdxKey existingKeyTableNameIdx = (SecureBuffTableInfoByTableNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newByTableNameIdxKey();
		existingKeyTableNameIdx.setRequiredTableName( existing.getRequiredTableName() );

		SecureBuffTableInfoByTableNameIdxKey newKeyTableNameIdx = (SecureBuffTableInfoByTableNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newByTableNameIdxKey();
		newKeyTableNameIdx.setRequiredTableName( Buff.getRequiredTableName() );

		SecureBuffTableInfoBySuperNameIdxKey existingKeySuperNameIdx = (SecureBuffTableInfoBySuperNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySuperNameIdxKey();
		existingKeySuperNameIdx.setOptionalSuperName( existing.getOptionalSuperName() );

		SecureBuffTableInfoBySuperNameIdxKey newKeySuperNameIdx = (SecureBuffTableInfoBySuperNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySuperNameIdxKey();
		newKeySuperNameIdx.setOptionalSuperName( Buff.getOptionalSuperName() );

		SecureBuffTableInfoBySchemaNameIdxKey existingKeySchemaNameIdx = (SecureBuffTableInfoBySchemaNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
		existingKeySchemaNameIdx.setRequiredSchemaName( existing.getRequiredSchemaName() );

		SecureBuffTableInfoBySchemaNameIdxKey newKeySchemaNameIdx = (SecureBuffTableInfoBySchemaNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
		newKeySchemaNameIdx.setRequiredSchemaName( Buff.getRequiredSchemaName() );

		SecureBuffTableInfoBySchemaBkCodeIdxKey existingKeySchemaBkCodeIdx = (SecureBuffTableInfoBySchemaBkCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
		existingKeySchemaBkCodeIdx.setRequiredSchemaName( existing.getRequiredSchemaName() );
		existingKeySchemaBkCodeIdx.setRequiredBackingClassCode( existing.getRequiredBackingClassCode() );

		SecureBuffTableInfoBySchemaBkCodeIdxKey newKeySchemaBkCodeIdx = (SecureBuffTableInfoBySchemaBkCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
		newKeySchemaBkCodeIdx.setRequiredSchemaName( Buff.getRequiredSchemaName() );
		newKeySchemaBkCodeIdx.setRequiredBackingClassCode( Buff.getRequiredBackingClassCode() );

		SecureBuffTableInfoBySchemaRTCodeIdxKey existingKeySchemaRTCodeIdx = (SecureBuffTableInfoBySchemaRTCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
		existingKeySchemaRTCodeIdx.setRequiredRuntimeClassCode( existing.getRequiredRuntimeClassCode() );

		SecureBuffTableInfoBySchemaRTCodeIdxKey newKeySchemaRTCodeIdx = (SecureBuffTableInfoBySchemaRTCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
		newKeySchemaRTCodeIdx.setRequiredRuntimeClassCode( Buff.getRequiredRuntimeClassCode() );

		// Check unique indexes

		if( ! existingKeyTableNameIdx.equals( newKeyTableNameIdx ) ) {
			if( dictByTableNameIdx.containsKey( newKeyTableNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTableInfo",
					"TableInfoTableNameIdx",
					"TableInfoTableNameIdx",
					newKeyTableNameIdx );
			}
		}

		if( ! existingKeySchemaBkCodeIdx.equals( newKeySchemaBkCodeIdx ) ) {
			if( dictBySchemaBkCodeIdx.containsKey( newKeySchemaBkCodeIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTableInfo",
					"TableInfoSchemaBkCodeIdx",
					"TableInfoSchemaBkCodeIdx",
					newKeySchemaBkCodeIdx );
			}
		}

		if( ! existingKeySchemaRTCodeIdx.equals( newKeySchemaRTCodeIdx ) ) {
			if( dictBySchemaRTCodeIdx.containsKey( newKeySchemaRTCodeIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateTableInfo",
					"TableInfoSchemaRTCodeIdx",
					"TableInfoSchemaRTCodeIdx",
					newKeySchemaRTCodeIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, SecureBuffTableInfo > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByTableNameIdx.remove( existingKeyTableNameIdx );
		dictByTableNameIdx.put( newKeyTableNameIdx, Buff );

		subdict = dictBySuperNameIdx.get( existingKeySuperNameIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySuperNameIdx.containsKey( newKeySuperNameIdx ) ) {
			subdict = dictBySuperNameIdx.get( newKeySuperNameIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffTableInfo >();
			dictBySuperNameIdx.put( newKeySuperNameIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySchemaNameIdx.get( existingKeySchemaNameIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchemaNameIdx.containsKey( newKeySchemaNameIdx ) ) {
			subdict = dictBySchemaNameIdx.get( newKeySchemaNameIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, SecureBuffTableInfo >();
			dictBySchemaNameIdx.put( newKeySchemaNameIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictBySchemaBkCodeIdx.remove( existingKeySchemaBkCodeIdx );
		dictBySchemaBkCodeIdx.put( newKeySchemaBkCodeIdx, Buff );

		dictBySchemaRTCodeIdx.remove( existingKeySchemaRTCodeIdx );
		dictBySchemaRTCodeIdx.put( newKeySchemaRTCodeIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteTableInfo( ISecureAuthorization Authorization,
		ISecureTableInfo iBuff )
	{
		final String S_ProcName = "SecureRamTableInfoTable.deleteTableInfo() ";
		SecureBuffTableInfo Buff = (SecureBuffTableInfo)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		SecureBuffTableInfo existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteTableInfo",
				pkey );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckTableInfoSubRefs[] = schema.getTableTableInfo().readDerivedBySuperNameIdx( Authorization,
						existing.getRequiredTableName() );
		if( arrCheckTableInfoSubRefs.length > 0 ) {
			schema.getTableTableInfo().deleteTableInfoBySuperNameIdx( Authorization,
						existing.getRequiredTableName() );
		}
		SecureBuffTableInfoByTableNameIdxKey keyTableNameIdx = (SecureBuffTableInfoByTableNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newByTableNameIdxKey();
		keyTableNameIdx.setRequiredTableName( existing.getRequiredTableName() );

		SecureBuffTableInfoBySuperNameIdxKey keySuperNameIdx = (SecureBuffTableInfoBySuperNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySuperNameIdxKey();
		keySuperNameIdx.setOptionalSuperName( existing.getOptionalSuperName() );

		SecureBuffTableInfoBySchemaNameIdxKey keySchemaNameIdx = (SecureBuffTableInfoBySchemaNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
		keySchemaNameIdx.setRequiredSchemaName( existing.getRequiredSchemaName() );

		SecureBuffTableInfoBySchemaBkCodeIdxKey keySchemaBkCodeIdx = (SecureBuffTableInfoBySchemaBkCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
		keySchemaBkCodeIdx.setRequiredSchemaName( existing.getRequiredSchemaName() );
		keySchemaBkCodeIdx.setRequiredBackingClassCode( existing.getRequiredBackingClassCode() );

		SecureBuffTableInfoBySchemaRTCodeIdxKey keySchemaRTCodeIdx = (SecureBuffTableInfoBySchemaRTCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
		keySchemaRTCodeIdx.setRequiredRuntimeClassCode( existing.getRequiredRuntimeClassCode() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, SecureBuffTableInfo > subdict;

		dictByPKey.remove( pkey );

		dictByTableNameIdx.remove( keyTableNameIdx );

		subdict = dictBySuperNameIdx.get( keySuperNameIdx );
		subdict.remove( pkey );

		subdict = dictBySchemaNameIdx.get( keySchemaNameIdx );
		subdict.remove( pkey );

		dictBySchemaBkCodeIdx.remove( keySchemaBkCodeIdx );

		dictBySchemaRTCodeIdx.remove( keySchemaRTCodeIdx );

	}
	@Override
	public void deleteTableInfoByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		SecureBuffTableInfo cur;
		LinkedList<SecureBuffTableInfo> matchSet = new LinkedList<SecureBuffTableInfo>();
		Iterator<SecureBuffTableInfo> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffTableInfo> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffTableInfo)(schema.getTableTableInfo().readDerivedByIdIdx( Authorization,
				cur.getRequiredTableInfoId() ));
			deleteTableInfo( Authorization, cur );
		}
	}

	@Override
	public void deleteTableInfoByTableNameIdx( ISecureAuthorization Authorization,
		String argTableName )
	{
		SecureBuffTableInfoByTableNameIdxKey key = (SecureBuffTableInfoByTableNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newByTableNameIdxKey();
		key.setRequiredTableName( argTableName );
		deleteTableInfoByTableNameIdx( Authorization, key );
	}

	@Override
	public void deleteTableInfoByTableNameIdx( ISecureAuthorization Authorization,
		ISecureTableInfoByTableNameIdxKey argKey )
	{
		SecureBuffTableInfo cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffTableInfo> matchSet = new LinkedList<SecureBuffTableInfo>();
		Iterator<SecureBuffTableInfo> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffTableInfo> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffTableInfo)(schema.getTableTableInfo().readDerivedByIdIdx( Authorization,
				cur.getRequiredTableInfoId() ));
			deleteTableInfo( Authorization, cur );
		}
	}

	@Override
	public void deleteTableInfoBySuperNameIdx( ISecureAuthorization Authorization,
		String argSuperName )
	{
		SecureBuffTableInfoBySuperNameIdxKey key = (SecureBuffTableInfoBySuperNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySuperNameIdxKey();
		key.setOptionalSuperName( argSuperName );
		deleteTableInfoBySuperNameIdx( Authorization, key );
	}

	@Override
	public void deleteTableInfoBySuperNameIdx( ISecureAuthorization Authorization,
		ISecureTableInfoBySuperNameIdxKey argKey )
	{
		SecureBuffTableInfo cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalSuperName() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffTableInfo> matchSet = new LinkedList<SecureBuffTableInfo>();
		Iterator<SecureBuffTableInfo> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffTableInfo> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffTableInfo)(schema.getTableTableInfo().readDerivedByIdIdx( Authorization,
				cur.getRequiredTableInfoId() ));
			deleteTableInfo( Authorization, cur );
		}
	}

	@Override
	public void deleteTableInfoBySchemaNameIdx( ISecureAuthorization Authorization,
		String argSchemaName )
	{
		SecureBuffTableInfoBySchemaNameIdxKey key = (SecureBuffTableInfoBySchemaNameIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
		key.setRequiredSchemaName( argSchemaName );
		deleteTableInfoBySchemaNameIdx( Authorization, key );
	}

	@Override
	public void deleteTableInfoBySchemaNameIdx( ISecureAuthorization Authorization,
		ISecureTableInfoBySchemaNameIdxKey argKey )
	{
		SecureBuffTableInfo cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffTableInfo> matchSet = new LinkedList<SecureBuffTableInfo>();
		Iterator<SecureBuffTableInfo> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffTableInfo> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffTableInfo)(schema.getTableTableInfo().readDerivedByIdIdx( Authorization,
				cur.getRequiredTableInfoId() ));
			deleteTableInfo( Authorization, cur );
		}
	}

	@Override
	public void deleteTableInfoBySchemaBkCodeIdx( ISecureAuthorization Authorization,
		String argSchemaName,
		int argBackingClassCode )
	{
		SecureBuffTableInfoBySchemaBkCodeIdxKey key = (SecureBuffTableInfoBySchemaBkCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
		key.setRequiredSchemaName( argSchemaName );
		key.setRequiredBackingClassCode( argBackingClassCode );
		deleteTableInfoBySchemaBkCodeIdx( Authorization, key );
	}

	@Override
	public void deleteTableInfoBySchemaBkCodeIdx( ISecureAuthorization Authorization,
		ISecureTableInfoBySchemaBkCodeIdxKey argKey )
	{
		SecureBuffTableInfo cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffTableInfo> matchSet = new LinkedList<SecureBuffTableInfo>();
		Iterator<SecureBuffTableInfo> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffTableInfo> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffTableInfo)(schema.getTableTableInfo().readDerivedByIdIdx( Authorization,
				cur.getRequiredTableInfoId() ));
			deleteTableInfo( Authorization, cur );
		}
	}

	@Override
	public void deleteTableInfoBySchemaRTCodeIdx( ISecureAuthorization Authorization,
		int argRuntimeClassCode )
	{
		SecureBuffTableInfoBySchemaRTCodeIdxKey key = (SecureBuffTableInfoBySchemaRTCodeIdxKey)schema.getSecureBuffFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
		key.setRequiredRuntimeClassCode( argRuntimeClassCode );
		deleteTableInfoBySchemaRTCodeIdx( Authorization, key );
	}

	@Override
	public void deleteTableInfoBySchemaRTCodeIdx( ISecureAuthorization Authorization,
		ISecureTableInfoBySchemaRTCodeIdxKey argKey )
	{
		SecureBuffTableInfo cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<SecureBuffTableInfo> matchSet = new LinkedList<SecureBuffTableInfo>();
		Iterator<SecureBuffTableInfo> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<SecureBuffTableInfo> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (SecureBuffTableInfo)(schema.getTableTableInfo().readDerivedByIdIdx( Authorization,
				cur.getRequiredTableInfoId() ));
			deleteTableInfo( Authorization, cur );
		}
	}
}
