
// Description: Java 25 in-memory RAM DbIO implementation for MimeType.

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
 *	IntNetRamMimeTypeTable in-memory RAM DbIO implementation
 *	for MimeType.
 */
public class IntNetRamMimeTypeTable
	implements IIntNetMimeTypeTable
{
	private IIntNetSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				IntNetBuffMimeType > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				IntNetBuffMimeType >();
	private Map< IntNetBuffMimeTypeByUNameIdxKey,
			IntNetBuffMimeType > dictByUNameIdx
		= new HashMap< IntNetBuffMimeTypeByUNameIdxKey,
			IntNetBuffMimeType >();

	public IntNetRamMimeTypeTable( IIntNetSchema argSchema ) {
		schema = argSchema;
	}

	public IntNetBuffMimeType ensureRec(IIntNetMimeType rec) {
		return (((IntNetBuffMimeTypeFactoryService)(schema.getIntNetBuffFactory().getFactoryMimeType())).ensureRec(rec));
	}

	@Override
	public IIntNetMimeType createMimeType( ISecureAuthorization Authorization,
		IIntNetMimeType iBuff )
	{
		final String S_ProcName = "createMimeType";
		
		IntNetBuffMimeType Buff = (IntNetBuffMimeType)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey;
		pkey = schema.nextMimeTypeIdGen();
		Buff.setRequiredMimeTypeId( pkey );
		IntNetBuffMimeTypeByUNameIdxKey keyUNameIdx = (IntNetBuffMimeTypeByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryMimeType().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"MimeTypeUNameIdx",
				"MimeTypeUNameIdx",
				keyUNameIdx );
		}

		// Validate foreign keys

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IIntNetMimeType.CLASS_CODE) {
				IntNetBuffMimeType retbuff = ((IntNetBuffMimeType)(schema.getIntNetBuffFactory().getFactoryMimeType().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IIntNetMimeType readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamMimeType.readDerived";
		IIntNetMimeType buff;
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
	public IIntNetMimeType lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamMimeType.lockDerived";
		IIntNetMimeType buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMimeType[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "IntNetRamMimeType.readAllDerived";
		IIntNetMimeType[] retList = new IIntNetMimeType[ dictByPKey.values().size() ];
		Iterator< IntNetBuffMimeType > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IIntNetMimeType readDerivedByUNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "IntNetRamMimeType.readDerivedByUNameIdx";
		IntNetBuffMimeTypeByUNameIdxKey key = (IntNetBuffMimeTypeByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryMimeType().newByUNameIdxKey();

		key.setRequiredName( Name );
		IIntNetMimeType buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMimeType readDerivedByIdIdx( ISecureAuthorization Authorization,
		int MimeTypeId )
	{
		final String S_ProcName = "IntNetRamMimeType.readDerivedByIdIdx() ";
		IIntNetMimeType buff;
		if( dictByPKey.containsKey( MimeTypeId ) ) {
			buff = dictByPKey.get( MimeTypeId );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMimeType readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "IntNetRamMimeType.readRec";
		IIntNetMimeType buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetMimeType.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMimeType lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IIntNetMimeType buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IIntNetMimeType.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IIntNetMimeType[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "IntNetRamMimeType.readAllRec";
		IIntNetMimeType buff;
		ArrayList<IIntNetMimeType> filteredList = new ArrayList<IIntNetMimeType>();
		IIntNetMimeType[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IIntNetMimeType.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IIntNetMimeType[0] ) );
	}

	@Override
	public IIntNetMimeType readRecByIdIdx( ISecureAuthorization Authorization,
		int MimeTypeId )
	{
		final String S_ProcName = "IntNetRamMimeType.readRecByIdIdx() ";
		IIntNetMimeType buff = readDerivedByIdIdx( Authorization,
			MimeTypeId );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetMimeType.CLASS_CODE ) ) {
			return( (IIntNetMimeType)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IIntNetMimeType readRecByUNameIdx( ISecureAuthorization Authorization,
		String Name )
	{
		final String S_ProcName = "IntNetRamMimeType.readRecByUNameIdx() ";
		IIntNetMimeType buff = readDerivedByUNameIdx( Authorization,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IIntNetMimeType.CLASS_CODE ) ) {
			return( (IIntNetMimeType)buff );
		}
		else {
			return( null );
		}
	}

	public IIntNetMimeType updateMimeType( ISecureAuthorization Authorization,
		IIntNetMimeType iBuff )
	{
		IntNetBuffMimeType Buff = (IntNetBuffMimeType)ensureRec(iBuff);
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		IntNetBuffMimeType existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateMimeType",
				"Existing record not found",
				"Existing record not found",
				"MimeType",
				"MimeType",
				pkey );
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() ) {
			throw new YCFCollisionDetectedException( getClass(),
				"updateMimeType",
				pkey );
		}
		Buff.setRequiredRevision( Buff.getRequiredRevision() + 1 );
		IntNetBuffMimeTypeByUNameIdxKey existingKeyUNameIdx = (IntNetBuffMimeTypeByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryMimeType().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		IntNetBuffMimeTypeByUNameIdxKey newKeyUNameIdx = (IntNetBuffMimeTypeByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryMimeType().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateMimeType",
					"MimeTypeUNameIdx",
					"MimeTypeUNameIdx",
					newKeyUNameIdx );
			}
		}

		// Validate foreign keys

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, IntNetBuffMimeType > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteMimeType( ISecureAuthorization Authorization,
		IIntNetMimeType iBuff )
	{
		final String S_ProcName = "IntNetRamMimeTypeTable.deleteMimeType() ";
		IntNetBuffMimeType Buff = (IntNetBuffMimeType)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		IntNetBuffMimeType existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteMimeType",
				pkey );
		}
		IntNetBuffMimeTypeByUNameIdxKey keyUNameIdx = (IntNetBuffMimeTypeByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryMimeType().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, IntNetBuffMimeType > subdict;

		dictByPKey.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

	}
	@Override
	public void deleteMimeTypeByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		IntNetBuffMimeType cur;
		LinkedList<IntNetBuffMimeType> matchSet = new LinkedList<IntNetBuffMimeType>();
		Iterator<IntNetBuffMimeType> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMimeType> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMimeType)(schema.getTableMimeType().readDerivedByIdIdx( Authorization,
				cur.getRequiredMimeTypeId() ));
			deleteMimeType( Authorization, cur );
		}
	}

	@Override
	public void deleteMimeTypeByUNameIdx( ISecureAuthorization Authorization,
		String argName )
	{
		IntNetBuffMimeTypeByUNameIdxKey key = (IntNetBuffMimeTypeByUNameIdxKey)schema.getIntNetBuffFactory().getFactoryMimeType().newByUNameIdxKey();
		key.setRequiredName( argName );
		deleteMimeTypeByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteMimeTypeByUNameIdx( ISecureAuthorization Authorization,
		IIntNetMimeTypeByUNameIdxKey argKey )
	{
		IntNetBuffMimeType cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<IntNetBuffMimeType> matchSet = new LinkedList<IntNetBuffMimeType>();
		Iterator<IntNetBuffMimeType> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<IntNetBuffMimeType> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (IntNetBuffMimeType)(schema.getTableMimeType().readDerivedByIdIdx( Authorization,
				cur.getRequiredMimeTypeId() ));
			deleteMimeType( Authorization, cur );
		}
	}
}
