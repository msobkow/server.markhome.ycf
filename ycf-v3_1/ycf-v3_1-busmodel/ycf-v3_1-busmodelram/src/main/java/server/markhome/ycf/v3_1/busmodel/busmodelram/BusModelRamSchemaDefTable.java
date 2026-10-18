
// Description: Java 25 in-memory RAM DbIO implementation for SchemaDef.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelram;

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.buff.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

/*
 *	BusModelRamSchemaDefTable in-memory RAM DbIO implementation
 *	for SchemaDef.
 */
public class BusModelRamSchemaDefTable
	implements IBusModelSchemaDefTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffSchemaDef > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffSchemaDef >();
	private Map< BusModelBuffSchemaDefByCTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaDef >> dictByCTenantIdx
		= new HashMap< BusModelBuffSchemaDefByCTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaDef >>();
	private Map< BusModelBuffSchemaDefByMinorVersionIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaDef >> dictByMinorVersionIdx
		= new HashMap< BusModelBuffSchemaDefByMinorVersionIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaDef >>();
	private Map< BusModelBuffSchemaDefByUNameIdxKey,
			BusModelBuffSchemaDef > dictByUNameIdx
		= new HashMap< BusModelBuffSchemaDefByUNameIdxKey,
			BusModelBuffSchemaDef >();
	private Map< BusModelBuffSchemaDefByAuthEMailIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaDef >> dictByAuthEMailIdx
		= new HashMap< BusModelBuffSchemaDefByAuthEMailIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaDef >>();
	private Map< BusModelBuffSchemaDefByProjectURLIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaDef >> dictByProjectURLIdx
		= new HashMap< BusModelBuffSchemaDefByProjectURLIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaDef >>();
	private Map< BusModelBuffSchemaDefByPubURIIdxKey,
			BusModelBuffSchemaDef > dictByPubURIIdx
		= new HashMap< BusModelBuffSchemaDefByPubURIIdxKey,
			BusModelBuffSchemaDef >();

	public BusModelRamSchemaDefTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffScope ensureRec(IBusModelScope rec) {
		if (rec == null) {
			return( null );
		}
		else {
			return (((BusModelBuffScopeFactoryService)(schema.getBusModelBuffFactory().getFactoryScope())).ensureRec(rec));
		}
	}

	@Override
	public IBusModelSchemaDef createSchemaDef( ISecureAuthorization Authorization,
		IBusModelSchemaDef iBuff )
	{
		final String S_ProcName = "createSchemaDef";
		
		BusModelBuffSchemaDef Buff = (BusModelBuffSchemaDef)(schema.getTableScope().createScope( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffSchemaDefByCTenantIdxKey keyCTenantIdx = (BusModelBuffSchemaDefByCTenantIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByCTenantIdxKey();
		keyCTenantIdx.setRequiredCTenantId( Buff.getRequiredCTenantId() );

		BusModelBuffSchemaDefByMinorVersionIdxKey keyMinorVersionIdx = (BusModelBuffSchemaDefByMinorVersionIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
		keyMinorVersionIdx.setRequiredMinorVersionId( Buff.getRequiredMinorVersionId() );

		BusModelBuffSchemaDefByUNameIdxKey keyUNameIdx = (BusModelBuffSchemaDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByUNameIdxKey();
		keyUNameIdx.setRequiredMinorVersionId( Buff.getRequiredMinorVersionId() );
		keyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffSchemaDefByAuthEMailIdxKey keyAuthEMailIdx = (BusModelBuffSchemaDefByAuthEMailIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
		keyAuthEMailIdx.setRequiredCTenantId( Buff.getRequiredCTenantId() );
		keyAuthEMailIdx.setRequiredAuthorEMail( Buff.getRequiredAuthorEMail() );

		BusModelBuffSchemaDefByProjectURLIdxKey keyProjectURLIdx = (BusModelBuffSchemaDefByProjectURLIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByProjectURLIdxKey();
		keyProjectURLIdx.setRequiredCTenantId( Buff.getRequiredCTenantId() );
		keyProjectURLIdx.setRequiredProjectURL( Buff.getRequiredProjectURL() );

		BusModelBuffSchemaDefByPubURIIdxKey keyPubURIIdx = (BusModelBuffSchemaDefByPubURIIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByPubURIIdxKey();
		keyPubURIIdx.setRequiredCTenantId( Buff.getRequiredCTenantId() );
		keyPubURIIdx.setRequiredPublishURI( Buff.getRequiredPublishURI() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		if( dictByUNameIdx.containsKey( keyUNameIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SchemaDefUNameIdx",
				"SchemaDefUNameIdx",
				keyUNameIdx );
		}

		if( dictByPubURIIdx.containsKey( keyPubURIIdx ) ) {
			throw new YCFUniqueIndexViolationException( getClass(),
				S_ProcName,
				"SchemaPublishURIIdx",
				"SchemaPublishURIIdx",
				keyPubURIIdx );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableMinorVersion().readDerivedByIdIdx( Authorization,
						Buff.getRequiredMinorVersionId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"MinorVersion",
						"MinorVersion",
						"MinorVersion",
						"MinorVersion",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredCTenantId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Owner",
						"Owner",
						"CTenant",
						"CTenant",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictCTenantIdx;
		if( dictByCTenantIdx.containsKey( keyCTenantIdx ) ) {
			subdictCTenantIdx = dictByCTenantIdx.get( keyCTenantIdx );
		}
		else {
			subdictCTenantIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByCTenantIdx.put( keyCTenantIdx, subdictCTenantIdx );
		}
		subdictCTenantIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictMinorVersionIdx;
		if( dictByMinorVersionIdx.containsKey( keyMinorVersionIdx ) ) {
			subdictMinorVersionIdx = dictByMinorVersionIdx.get( keyMinorVersionIdx );
		}
		else {
			subdictMinorVersionIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByMinorVersionIdx.put( keyMinorVersionIdx, subdictMinorVersionIdx );
		}
		subdictMinorVersionIdx.put( pkey, Buff );

		dictByUNameIdx.put( keyUNameIdx, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictAuthEMailIdx;
		if( dictByAuthEMailIdx.containsKey( keyAuthEMailIdx ) ) {
			subdictAuthEMailIdx = dictByAuthEMailIdx.get( keyAuthEMailIdx );
		}
		else {
			subdictAuthEMailIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByAuthEMailIdx.put( keyAuthEMailIdx, subdictAuthEMailIdx );
		}
		subdictAuthEMailIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictProjectURLIdx;
		if( dictByProjectURLIdx.containsKey( keyProjectURLIdx ) ) {
			subdictProjectURLIdx = dictByProjectURLIdx.get( keyProjectURLIdx );
		}
		else {
			subdictProjectURLIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByProjectURLIdx.put( keyProjectURLIdx, subdictProjectURLIdx );
		}
		subdictProjectURLIdx.put( pkey, Buff );

		dictByPubURIIdx.put( keyPubURIIdx, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelSchemaDef.CLASS_CODE) {
				BusModelBuffSchemaDef retbuff = ((BusModelBuffSchemaDef)(schema.getBusModelBuffFactory().getFactorySchemaDef().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelSchemaDef readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readDerived";
		IBusModelSchemaDef buff;
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
	public IBusModelSchemaDef lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaDef.lockDerived";
		IBusModelSchemaDef buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaDef[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamSchemaDef.readAllDerived";
		IBusModelSchemaDef[] retList = new IBusModelSchemaDef[ dictByPKey.values().size() ];
		Iterator< BusModelBuffSchemaDef > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelSchemaDef[] readDerivedByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByTenantIdx";
		IBusModelScope buffList[] = schema.getTableScope().readDerivedByTenantIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelScope buff;
			ArrayList<IBusModelSchemaDef> filteredList = new ArrayList<IBusModelSchemaDef>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelSchemaDef ) ) {
					filteredList.add( (IBusModelSchemaDef)buff );
				}
			}
			return( filteredList.toArray( new IBusModelSchemaDef[0] ) );
		}
	}

	@Override
	public IBusModelSchemaDef[] readDerivedByCTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 CTenantId )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readDerivedByCTenantIdx";
		BusModelBuffSchemaDefByCTenantIdxKey key = (BusModelBuffSchemaDefByCTenantIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByCTenantIdxKey();

		key.setRequiredCTenantId( CTenantId );
		IBusModelSchemaDef[] recArray;
		if( dictByCTenantIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictCTenantIdx
				= dictByCTenantIdx.get( key );
			recArray = new IBusModelSchemaDef[ subdictCTenantIdx.size() ];
			Iterator< BusModelBuffSchemaDef > iter = subdictCTenantIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictCTenantIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByCTenantIdx.put( key, subdictCTenantIdx );
			recArray = new IBusModelSchemaDef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaDef[] readDerivedByMinorVersionIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 MinorVersionId )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readDerivedByMinorVersionIdx";
		BusModelBuffSchemaDefByMinorVersionIdxKey key = (BusModelBuffSchemaDefByMinorVersionIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByMinorVersionIdxKey();

		key.setRequiredMinorVersionId( MinorVersionId );
		IBusModelSchemaDef[] recArray;
		if( dictByMinorVersionIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictMinorVersionIdx
				= dictByMinorVersionIdx.get( key );
			recArray = new IBusModelSchemaDef[ subdictMinorVersionIdx.size() ];
			Iterator< BusModelBuffSchemaDef > iter = subdictMinorVersionIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictMinorVersionIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByMinorVersionIdx.put( key, subdictMinorVersionIdx );
			recArray = new IBusModelSchemaDef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaDef readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 MinorVersionId,
		String Name )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readDerivedByUNameIdx";
		BusModelBuffSchemaDefByUNameIdxKey key = (BusModelBuffSchemaDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByUNameIdxKey();

		key.setRequiredMinorVersionId( MinorVersionId );
		key.setRequiredName( Name );
		IBusModelSchemaDef buff;
		if( dictByUNameIdx.containsKey( key ) ) {
			buff = dictByUNameIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaDef[] readDerivedByAuthEMailIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 CTenantId,
		String AuthorEMail )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readDerivedByAuthEMailIdx";
		BusModelBuffSchemaDefByAuthEMailIdxKey key = (BusModelBuffSchemaDefByAuthEMailIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByAuthEMailIdxKey();

		key.setRequiredCTenantId( CTenantId );
		key.setRequiredAuthorEMail( AuthorEMail );
		IBusModelSchemaDef[] recArray;
		if( dictByAuthEMailIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictAuthEMailIdx
				= dictByAuthEMailIdx.get( key );
			recArray = new IBusModelSchemaDef[ subdictAuthEMailIdx.size() ];
			Iterator< BusModelBuffSchemaDef > iter = subdictAuthEMailIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictAuthEMailIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByAuthEMailIdx.put( key, subdictAuthEMailIdx );
			recArray = new IBusModelSchemaDef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaDef[] readDerivedByProjectURLIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 CTenantId,
		String ProjectURL )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readDerivedByProjectURLIdx";
		BusModelBuffSchemaDefByProjectURLIdxKey key = (BusModelBuffSchemaDefByProjectURLIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByProjectURLIdxKey();

		key.setRequiredCTenantId( CTenantId );
		key.setRequiredProjectURL( ProjectURL );
		IBusModelSchemaDef[] recArray;
		if( dictByProjectURLIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictProjectURLIdx
				= dictByProjectURLIdx.get( key );
			recArray = new IBusModelSchemaDef[ subdictProjectURLIdx.size() ];
			Iterator< BusModelBuffSchemaDef > iter = subdictProjectURLIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdictProjectURLIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByProjectURLIdx.put( key, subdictProjectURLIdx );
			recArray = new IBusModelSchemaDef[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaDef readDerivedByPubURIIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 CTenantId,
		String PublishURI )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readDerivedByPubURIIdx";
		BusModelBuffSchemaDefByPubURIIdxKey key = (BusModelBuffSchemaDefByPubURIIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByPubURIIdxKey();

		key.setRequiredCTenantId( CTenantId );
		key.setRequiredPublishURI( PublishURI );
		IBusModelSchemaDef buff;
		if( dictByPubURIIdx.containsKey( key ) ) {
			buff = dictByPubURIIdx.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaDef readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readDerivedByIdIdx() ";
		IBusModelSchemaDef buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaDef readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readRec";
		IBusModelSchemaDef buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelSchemaDef.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaDef lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelSchemaDef buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelSchemaDef.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaDef[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readAllRec";
		IBusModelSchemaDef buff;
		ArrayList<IBusModelSchemaDef> filteredList = new ArrayList<IBusModelSchemaDef>();
		IBusModelSchemaDef[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaDef.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaDef[0] ) );
	}

	@Override
	public IBusModelSchemaDef readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamScope.readRecByIdIdx() ";
		IBusModelSchemaDef buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
			return( (IBusModelSchemaDef)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaDef[] readRecByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "BusModelRamScope.readRecByTenantIdx() ";
		IBusModelSchemaDef buff;
		ArrayList<IBusModelSchemaDef> filteredList = new ArrayList<IBusModelSchemaDef>();
		IBusModelSchemaDef[] buffList = readDerivedByTenantIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelScope.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaDef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaDef[0] ) );
	}

	@Override
	public IBusModelSchemaDef[] readRecByCTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 CTenantId )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readRecByCTenantIdx() ";
		IBusModelSchemaDef buff;
		ArrayList<IBusModelSchemaDef> filteredList = new ArrayList<IBusModelSchemaDef>();
		IBusModelSchemaDef[] buffList = readDerivedByCTenantIdx( Authorization,
			CTenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaDef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaDef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaDef[0] ) );
	}

	@Override
	public IBusModelSchemaDef[] readRecByMinorVersionIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 MinorVersionId )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readRecByMinorVersionIdx() ";
		IBusModelSchemaDef buff;
		ArrayList<IBusModelSchemaDef> filteredList = new ArrayList<IBusModelSchemaDef>();
		IBusModelSchemaDef[] buffList = readDerivedByMinorVersionIdx( Authorization,
			MinorVersionId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaDef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaDef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaDef[0] ) );
	}

	@Override
	public IBusModelSchemaDef readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 MinorVersionId,
		String Name )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readRecByUNameIdx() ";
		IBusModelSchemaDef buff = readDerivedByUNameIdx( Authorization,
			MinorVersionId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaDef.CLASS_CODE ) ) {
			return( (IBusModelSchemaDef)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaDef[] readRecByAuthEMailIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 CTenantId,
		String AuthorEMail )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readRecByAuthEMailIdx() ";
		IBusModelSchemaDef buff;
		ArrayList<IBusModelSchemaDef> filteredList = new ArrayList<IBusModelSchemaDef>();
		IBusModelSchemaDef[] buffList = readDerivedByAuthEMailIdx( Authorization,
			CTenantId,
			AuthorEMail );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaDef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaDef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaDef[0] ) );
	}

	@Override
	public IBusModelSchemaDef[] readRecByProjectURLIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 CTenantId,
		String ProjectURL )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readRecByProjectURLIdx() ";
		IBusModelSchemaDef buff;
		ArrayList<IBusModelSchemaDef> filteredList = new ArrayList<IBusModelSchemaDef>();
		IBusModelSchemaDef[] buffList = readDerivedByProjectURLIdx( Authorization,
			CTenantId,
			ProjectURL );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaDef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaDef)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaDef[0] ) );
	}

	@Override
	public IBusModelSchemaDef readRecByPubURIIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 CTenantId,
		String PublishURI )
	{
		final String S_ProcName = "BusModelRamSchemaDef.readRecByPubURIIdx() ";
		IBusModelSchemaDef buff = readDerivedByPubURIIdx( Authorization,
			CTenantId,
			PublishURI );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaDef.CLASS_CODE ) ) {
			return( (IBusModelSchemaDef)buff );
		}
		else {
			return( null );
		}
	}

	public IBusModelSchemaDef updateSchemaDef( ISecureAuthorization Authorization,
		IBusModelSchemaDef iBuff )
	{
		BusModelBuffSchemaDef Buff = (BusModelBuffSchemaDef)(schema.getTableScope().updateScope( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffSchemaDef existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSchemaDef",
				"Existing record not found",
				"Existing record not found",
				"SchemaDef",
				"SchemaDef",
				pkey );
		}
		BusModelBuffSchemaDefByCTenantIdxKey existingKeyCTenantIdx = (BusModelBuffSchemaDefByCTenantIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByCTenantIdxKey();
		existingKeyCTenantIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );

		BusModelBuffSchemaDefByCTenantIdxKey newKeyCTenantIdx = (BusModelBuffSchemaDefByCTenantIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByCTenantIdxKey();
		newKeyCTenantIdx.setRequiredCTenantId( Buff.getRequiredCTenantId() );

		BusModelBuffSchemaDefByMinorVersionIdxKey existingKeyMinorVersionIdx = (BusModelBuffSchemaDefByMinorVersionIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
		existingKeyMinorVersionIdx.setRequiredMinorVersionId( existing.getRequiredMinorVersionId() );

		BusModelBuffSchemaDefByMinorVersionIdxKey newKeyMinorVersionIdx = (BusModelBuffSchemaDefByMinorVersionIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
		newKeyMinorVersionIdx.setRequiredMinorVersionId( Buff.getRequiredMinorVersionId() );

		BusModelBuffSchemaDefByUNameIdxKey existingKeyUNameIdx = (BusModelBuffSchemaDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByUNameIdxKey();
		existingKeyUNameIdx.setRequiredMinorVersionId( existing.getRequiredMinorVersionId() );
		existingKeyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffSchemaDefByUNameIdxKey newKeyUNameIdx = (BusModelBuffSchemaDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByUNameIdxKey();
		newKeyUNameIdx.setRequiredMinorVersionId( Buff.getRequiredMinorVersionId() );
		newKeyUNameIdx.setRequiredName( Buff.getRequiredName() );

		BusModelBuffSchemaDefByAuthEMailIdxKey existingKeyAuthEMailIdx = (BusModelBuffSchemaDefByAuthEMailIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
		existingKeyAuthEMailIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );
		existingKeyAuthEMailIdx.setRequiredAuthorEMail( existing.getRequiredAuthorEMail() );

		BusModelBuffSchemaDefByAuthEMailIdxKey newKeyAuthEMailIdx = (BusModelBuffSchemaDefByAuthEMailIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
		newKeyAuthEMailIdx.setRequiredCTenantId( Buff.getRequiredCTenantId() );
		newKeyAuthEMailIdx.setRequiredAuthorEMail( Buff.getRequiredAuthorEMail() );

		BusModelBuffSchemaDefByProjectURLIdxKey existingKeyProjectURLIdx = (BusModelBuffSchemaDefByProjectURLIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByProjectURLIdxKey();
		existingKeyProjectURLIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );
		existingKeyProjectURLIdx.setRequiredProjectURL( existing.getRequiredProjectURL() );

		BusModelBuffSchemaDefByProjectURLIdxKey newKeyProjectURLIdx = (BusModelBuffSchemaDefByProjectURLIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByProjectURLIdxKey();
		newKeyProjectURLIdx.setRequiredCTenantId( Buff.getRequiredCTenantId() );
		newKeyProjectURLIdx.setRequiredProjectURL( Buff.getRequiredProjectURL() );

		BusModelBuffSchemaDefByPubURIIdxKey existingKeyPubURIIdx = (BusModelBuffSchemaDefByPubURIIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByPubURIIdxKey();
		existingKeyPubURIIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );
		existingKeyPubURIIdx.setRequiredPublishURI( existing.getRequiredPublishURI() );

		BusModelBuffSchemaDefByPubURIIdxKey newKeyPubURIIdx = (BusModelBuffSchemaDefByPubURIIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByPubURIIdxKey();
		newKeyPubURIIdx.setRequiredCTenantId( Buff.getRequiredCTenantId() );
		newKeyPubURIIdx.setRequiredPublishURI( Buff.getRequiredPublishURI() );

		// Check unique indexes

		if( ! existingKeyUNameIdx.equals( newKeyUNameIdx ) ) {
			if( dictByUNameIdx.containsKey( newKeyUNameIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSchemaDef",
					"SchemaDefUNameIdx",
					"SchemaDefUNameIdx",
					newKeyUNameIdx );
			}
		}

		if( ! existingKeyPubURIIdx.equals( newKeyPubURIIdx ) ) {
			if( dictByPubURIIdx.containsKey( newKeyPubURIIdx ) ) {
				throw new YCFUniqueIndexViolationException( getClass(),
					"updateSchemaDef",
					"SchemaPublishURIIdx",
					"SchemaPublishURIIdx",
					newKeyPubURIIdx );
			}
		}

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableScope().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSchemaDef",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"Scope",
						"Scope",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableMinorVersion().readDerivedByIdIdx( Authorization,
						Buff.getRequiredMinorVersionId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSchemaDef",
						"Container",
						"Container",
						"MinorVersion",
						"MinorVersion",
						"MinorVersion",
						"MinorVersion",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTenant().readDerivedByIdIdx( Authorization,
						Buff.getRequiredCTenantId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSchemaDef",
						"Owner",
						"Owner",
						"CTenant",
						"CTenant",
						"Tenant",
						"Tenant",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByCTenantIdx.get( existingKeyCTenantIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByCTenantIdx.containsKey( newKeyCTenantIdx ) ) {
			subdict = dictByCTenantIdx.get( newKeyCTenantIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByCTenantIdx.put( newKeyCTenantIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByMinorVersionIdx.get( existingKeyMinorVersionIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByMinorVersionIdx.containsKey( newKeyMinorVersionIdx ) ) {
			subdict = dictByMinorVersionIdx.get( newKeyMinorVersionIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByMinorVersionIdx.put( newKeyMinorVersionIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByUNameIdx.remove( existingKeyUNameIdx );
		dictByUNameIdx.put( newKeyUNameIdx, Buff );

		subdict = dictByAuthEMailIdx.get( existingKeyAuthEMailIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByAuthEMailIdx.containsKey( newKeyAuthEMailIdx ) ) {
			subdict = dictByAuthEMailIdx.get( newKeyAuthEMailIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByAuthEMailIdx.put( newKeyAuthEMailIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByProjectURLIdx.get( existingKeyProjectURLIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByProjectURLIdx.containsKey( newKeyProjectURLIdx ) ) {
			subdict = dictByProjectURLIdx.get( newKeyProjectURLIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef >();
			dictByProjectURLIdx.put( newKeyProjectURLIdx, subdict );
		}
		subdict.put( pkey, Buff );

		dictByPubURIIdx.remove( existingKeyPubURIIdx );
		dictByPubURIIdx.put( newKeyPubURIIdx, Buff );

		return(Buff);
	}

	@Override
	public void deleteSchemaDef( ISecureAuthorization Authorization,
		IBusModelSchemaDef iBuff )
	{
		final String S_ProcName = "BusModelRamSchemaDefTable.deleteSchemaDef() ";
		BusModelBuffSchemaDef Buff = (BusModelBuffSchemaDef)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffSchemaDef existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSchemaDef",
				pkey );
		}
			BusModelBuffValue buffClearTypeReferences;
			IBusModelValue arrClearTypeReferences[] = schema.getTableValue().readDerivedByScopeIdx( Authorization,
			existing.getRequiredId() );
			for( int idxClearTypeReferences = 0; idxClearTypeReferences < arrClearTypeReferences.length; idxClearTypeReferences++ ) {
				buffClearTypeReferences = (BusModelBuffValue)(arrClearTypeReferences[idxClearTypeReferences]);
				BusModelBuffTableCol buffReferencingTableCols;
				IBusModelTableCol arrReferencingTableCols[] = schema.getTableTableCol().readDerivedByDataIdx( Authorization,
				buffClearTypeReferences.getRequiredId() );
				for( int idxReferencingTableCols = 0; idxReferencingTableCols < arrReferencingTableCols.length; idxReferencingTableCols++ ) {
					buffReferencingTableCols = (BusModelBuffTableCol)(arrReferencingTableCols[idxReferencingTableCols]);
					{
						BusModelBuffTableCol editBuff = (BusModelBuffTableCol)(schema.getTableTableCol().readDerivedByIdIdx( Authorization,
							buffReferencingTableCols.getRequiredId() ));
						editBuff.setRequiredParentDataType((IYCFKeyHash256)null);
						classCode = editBuff.getClassCode();
						if( classCode == IBusModelTableCol.CLASS_CODE ) {
							schema.getTableTableCol().updateTableCol( Authorization, editBuff );
						}
						else {
							throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-clear-sub-dep-2-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
						}
					}
				}
			}
			BusModelBuffTable buffClearTableRelationNarrowed;
			IBusModelTable arrClearTableRelationNarrowed[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
			for( int idxClearTableRelationNarrowed = 0; idxClearTableRelationNarrowed < arrClearTableRelationNarrowed.length; idxClearTableRelationNarrowed++ ) {
				buffClearTableRelationNarrowed = (BusModelBuffTable)(arrClearTableRelationNarrowed[idxClearTableRelationNarrowed]);
				BusModelBuffRelation buffTableRelation;
				IBusModelRelation arrTableRelation[] = schema.getTableRelation().readDerivedByRelTableIdx( Authorization,
				buffClearTableRelationNarrowed.getRequiredId() );
				for( int idxTableRelation = 0; idxTableRelation < arrTableRelation.length; idxTableRelation++ ) {
					buffTableRelation = (BusModelBuffRelation)(arrTableRelation[idxTableRelation]);
					{
						BusModelBuffRelation editBuff = (BusModelBuffRelation)(schema.getTableRelation().readDerivedByIdIdx( Authorization,
							buffTableRelation.getRequiredId() ));
						editBuff.setOptionalLookupNarrowed((IYCFKeyHash256)null);
						classCode = editBuff.getClassCode();
						if( classCode == IBusModelRelation.CLASS_CODE ) {
							schema.getTableRelation().updateRelation( Authorization, editBuff );
						}
						else {
							throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-delete-clear-sub-dep-2-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
						}
					}
				}
			}
		BusModelBuffTable buffDelTableMethods;
		IBusModelTable arrDelTableMethods[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableMethods = 0; idxDelTableMethods < arrDelTableMethods.length; idxDelTableMethods++ ) {
			buffDelTableMethods = (BusModelBuffTable)(arrDelTableMethods[idxDelTableMethods]);
					schema.getTableServerMethod().deleteServerMethodByMethTableIdx( Authorization,
						buffDelTableMethods.getRequiredId() );
		}
		BusModelBuffTable buffDelTableDelDep;
		IBusModelTable arrDelTableDelDep[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableDelDep = 0; idxDelTableDelDep < arrDelTableDelDep.length; idxDelTableDelDep++ ) {
			buffDelTableDelDep = (BusModelBuffTable)(arrDelTableDelDep[idxDelTableDelDep]);
					schema.getTableDelTopDep().deleteDelTopDepByDelTopDepTblIdx( Authorization,
						buffDelTableDelDep.getRequiredId() );
		}
		BusModelBuffTable buffDelTableClearDep;
		IBusModelTable arrDelTableClearDep[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableClearDep = 0; idxDelTableClearDep < arrDelTableClearDep.length; idxDelTableClearDep++ ) {
			buffDelTableClearDep = (BusModelBuffTable)(arrDelTableClearDep[idxDelTableClearDep]);
					schema.getTableClearTopDep().deleteClearTopDepByClrTopDepTblIdx( Authorization,
						buffDelTableClearDep.getRequiredId() );
		}
		BusModelBuffTable buffDelTableChain;
		IBusModelTable arrDelTableChain[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableChain = 0; idxDelTableChain < arrDelTableChain.length; idxDelTableChain++ ) {
			buffDelTableChain = (BusModelBuffTable)(arrDelTableChain[idxDelTableChain]);
					schema.getTableChain().deleteChainByChainTableIdx( Authorization,
						buffDelTableChain.getRequiredId() );
		}
		BusModelBuffTable buffDelTableRelationPopDep;
		IBusModelTable arrDelTableRelationPopDep[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableRelationPopDep = 0; idxDelTableRelationPopDep < arrDelTableRelationPopDep.length; idxDelTableRelationPopDep++ ) {
			buffDelTableRelationPopDep = (BusModelBuffTable)(arrDelTableRelationPopDep[idxDelTableRelationPopDep]);
			BusModelBuffRelation buffTableRelation;
			IBusModelRelation arrTableRelation[] = schema.getTableRelation().readDerivedByRelTableIdx( Authorization,
				buffDelTableRelationPopDep.getRequiredId() );
			for( int idxTableRelation = 0; idxTableRelation < arrTableRelation.length; idxTableRelation++ ) {
				buffTableRelation = (BusModelBuffRelation)(arrTableRelation[idxTableRelation]);
					schema.getTablePopTopDep().deletePopTopDepByContRelIdx( Authorization,
						buffTableRelation.getRequiredId() );
			}
		}
		BusModelBuffTable buffDelTableRelationCol;
		IBusModelTable arrDelTableRelationCol[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableRelationCol = 0; idxDelTableRelationCol < arrDelTableRelationCol.length; idxDelTableRelationCol++ ) {
			buffDelTableRelationCol = (BusModelBuffTable)(arrDelTableRelationCol[idxDelTableRelationCol]);
			BusModelBuffRelation buffTableRelation;
			IBusModelRelation arrTableRelation[] = schema.getTableRelation().readDerivedByRelTableIdx( Authorization,
				buffDelTableRelationCol.getRequiredId() );
			for( int idxTableRelation = 0; idxTableRelation < arrTableRelation.length; idxTableRelation++ ) {
				buffTableRelation = (BusModelBuffRelation)(arrTableRelation[idxTableRelation]);
					schema.getTableRelationCol().deleteRelationColByRelationIdx( Authorization,
						buffTableRelation.getRequiredId() );
			}
		}
		BusModelBuffTable buffDelTableRelation;
		IBusModelTable arrDelTableRelation[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableRelation = 0; idxDelTableRelation < arrDelTableRelation.length; idxDelTableRelation++ ) {
			buffDelTableRelation = (BusModelBuffTable)(arrDelTableRelation[idxDelTableRelation]);
					schema.getTableRelation().deleteRelationByRelTableIdx( Authorization,
						buffDelTableRelation.getRequiredId() );
		}
		BusModelBuffTable buffDelTableIndexRefRelFmCol;
		IBusModelTable arrDelTableIndexRefRelFmCol[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableIndexRefRelFmCol = 0; idxDelTableIndexRefRelFmCol < arrDelTableIndexRefRelFmCol.length; idxDelTableIndexRefRelFmCol++ ) {
			buffDelTableIndexRefRelFmCol = (BusModelBuffTable)(arrDelTableIndexRefRelFmCol[idxDelTableIndexRefRelFmCol]);
			BusModelBuffIndex buffTableIndex;
			IBusModelIndex arrTableIndex[] = schema.getTableIndex().readDerivedByIdxTableIdx( Authorization,
				buffDelTableIndexRefRelFmCol.getRequiredId() );
			for( int idxTableIndex = 0; idxTableIndex < arrTableIndex.length; idxTableIndex++ ) {
				buffTableIndex = (BusModelBuffIndex)(arrTableIndex[idxTableIndex]);
			BusModelBuffIndexCol buffColumns;
			IBusModelIndexCol arrColumns[] = schema.getTableIndexCol().readDerivedByIndexIdx( Authorization,
					buffTableIndex.getRequiredId() );
			for( int idxColumns = 0; idxColumns < arrColumns.length; idxColumns++ ) {
				buffColumns = (BusModelBuffIndexCol)(arrColumns[idxColumns]);
					schema.getTableRelationCol().deleteRelationColByFromColIdx( Authorization,
						buffColumns.getRequiredId() );
			}
			}
		}
		BusModelBuffTable buffDelTableIndexRefRelToCol;
		IBusModelTable arrDelTableIndexRefRelToCol[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableIndexRefRelToCol = 0; idxDelTableIndexRefRelToCol < arrDelTableIndexRefRelToCol.length; idxDelTableIndexRefRelToCol++ ) {
			buffDelTableIndexRefRelToCol = (BusModelBuffTable)(arrDelTableIndexRefRelToCol[idxDelTableIndexRefRelToCol]);
			BusModelBuffIndex buffTableIndex;
			IBusModelIndex arrTableIndex[] = schema.getTableIndex().readDerivedByIdxTableIdx( Authorization,
				buffDelTableIndexRefRelToCol.getRequiredId() );
			for( int idxTableIndex = 0; idxTableIndex < arrTableIndex.length; idxTableIndex++ ) {
				buffTableIndex = (BusModelBuffIndex)(arrTableIndex[idxTableIndex]);
			BusModelBuffIndexCol buffColumns;
			IBusModelIndexCol arrColumns[] = schema.getTableIndexCol().readDerivedByIndexIdx( Authorization,
					buffTableIndex.getRequiredId() );
			for( int idxColumns = 0; idxColumns < arrColumns.length; idxColumns++ ) {
				buffColumns = (BusModelBuffIndexCol)(arrColumns[idxColumns]);
					schema.getTableRelationCol().deleteRelationColByToColIdx( Authorization,
						buffColumns.getRequiredId() );
			}
			}
		}
		BusModelBuffTable buffDelTableIndexCols;
		IBusModelTable arrDelTableIndexCols[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableIndexCols = 0; idxDelTableIndexCols < arrDelTableIndexCols.length; idxDelTableIndexCols++ ) {
			buffDelTableIndexCols = (BusModelBuffTable)(arrDelTableIndexCols[idxDelTableIndexCols]);
			BusModelBuffIndex buffTableIndex;
			IBusModelIndex arrTableIndex[] = schema.getTableIndex().readDerivedByIdxTableIdx( Authorization,
				buffDelTableIndexCols.getRequiredId() );
			for( int idxTableIndex = 0; idxTableIndex < arrTableIndex.length; idxTableIndex++ ) {
				buffTableIndex = (BusModelBuffIndex)(arrTableIndex[idxTableIndex]);
					schema.getTableIndexCol().deleteIndexColByIndexIdx( Authorization,
						buffTableIndex.getRequiredId() );
			}
		}
		BusModelBuffTable buffDelTableIndexes;
		IBusModelTable arrDelTableIndexes[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableIndexes = 0; idxDelTableIndexes < arrDelTableIndexes.length; idxDelTableIndexes++ ) {
			buffDelTableIndexes = (BusModelBuffTable)(arrDelTableIndexes[idxDelTableIndexes]);
					schema.getTableIndex().deleteIndexByIdxTableIdx( Authorization,
						buffDelTableIndexes.getRequiredId() );
		}
		BusModelBuffTable buffDelTableRefIndexColumns;
		IBusModelTable arrDelTableRefIndexColumns[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableRefIndexColumns = 0; idxDelTableRefIndexColumns < arrDelTableRefIndexColumns.length; idxDelTableRefIndexColumns++ ) {
			buffDelTableRefIndexColumns = (BusModelBuffTable)(arrDelTableRefIndexColumns[idxDelTableRefIndexColumns]);
			BusModelBuffValue buffColumns;
			IBusModelValue arrColumns[] = schema.getTableValue().readDerivedByScopeIdx( Authorization,
				buffDelTableRefIndexColumns.getRequiredId() );
			for( int idxColumns = 0; idxColumns < arrColumns.length; idxColumns++ ) {
				buffColumns = (BusModelBuffValue)(arrColumns[idxColumns]);
					schema.getTableIndexCol().deleteIndexColByColIdx( Authorization,
						buffColumns.getRequiredId() );
			}
		}
		BusModelBuffTable buffDelTableColumns;
		IBusModelTable arrDelTableColumns[] = schema.getTableTable().readDerivedBySchemaDefIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTableColumns = 0; idxDelTableColumns < arrDelTableColumns.length; idxDelTableColumns++ ) {
			buffDelTableColumns = (BusModelBuffTable)(arrDelTableColumns[idxDelTableColumns]);
					schema.getTableValue().deleteValueByScopeIdx( Authorization,
						buffDelTableColumns.getRequiredId() );
		}
					schema.getTableTable().deleteTableBySchemaDefIdx( Authorization,
						existing.getRequiredId() );
		BusModelBuffValue buffDelTypeRefs;
		IBusModelValue arrDelTypeRefs[] = schema.getTableValue().readDerivedByScopeIdx( Authorization,
			existing.getRequiredId() );
		for( int idxDelTypeRefs = 0; idxDelTypeRefs < arrDelTypeRefs.length; idxDelTypeRefs++ ) {
			buffDelTypeRefs = (BusModelBuffValue)(arrDelTypeRefs[idxDelTypeRefs]);
					schema.getTableTableCol().deleteTableColByDataIdx( Authorization,
						buffDelTypeRefs.getRequiredId() );
		}
					schema.getTableValue().deleteValueByScopeIdx( Authorization,
						existing.getRequiredId() );
		BusModelBuffSchemaDefByCTenantIdxKey keyCTenantIdx = (BusModelBuffSchemaDefByCTenantIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByCTenantIdxKey();
		keyCTenantIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );

		BusModelBuffSchemaDefByMinorVersionIdxKey keyMinorVersionIdx = (BusModelBuffSchemaDefByMinorVersionIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
		keyMinorVersionIdx.setRequiredMinorVersionId( existing.getRequiredMinorVersionId() );

		BusModelBuffSchemaDefByUNameIdxKey keyUNameIdx = (BusModelBuffSchemaDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByUNameIdxKey();
		keyUNameIdx.setRequiredMinorVersionId( existing.getRequiredMinorVersionId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		BusModelBuffSchemaDefByAuthEMailIdxKey keyAuthEMailIdx = (BusModelBuffSchemaDefByAuthEMailIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
		keyAuthEMailIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );
		keyAuthEMailIdx.setRequiredAuthorEMail( existing.getRequiredAuthorEMail() );

		BusModelBuffSchemaDefByProjectURLIdxKey keyProjectURLIdx = (BusModelBuffSchemaDefByProjectURLIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByProjectURLIdxKey();
		keyProjectURLIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );
		keyProjectURLIdx.setRequiredProjectURL( existing.getRequiredProjectURL() );

		BusModelBuffSchemaDefByPubURIIdxKey keyPubURIIdx = (BusModelBuffSchemaDefByPubURIIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByPubURIIdxKey();
		keyPubURIIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );
		keyPubURIIdx.setRequiredPublishURI( existing.getRequiredPublishURI() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaDef > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByCTenantIdx.get( keyCTenantIdx );
		subdict.remove( pkey );

		subdict = dictByMinorVersionIdx.get( keyMinorVersionIdx );
		subdict.remove( pkey );

		dictByUNameIdx.remove( keyUNameIdx );

		subdict = dictByAuthEMailIdx.get( keyAuthEMailIdx );
		subdict.remove( pkey );

		subdict = dictByProjectURLIdx.get( keyProjectURLIdx );
		subdict.remove( pkey );

		dictByPubURIIdx.remove( keyPubURIIdx );

		schema.getTableScope().deleteScope( Authorization,
			Buff );
	}
	@Override
	public void deleteSchemaDefByCTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId )
	{
		BusModelBuffSchemaDefByCTenantIdxKey key = (BusModelBuffSchemaDefByCTenantIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByCTenantIdxKey();
		key.setRequiredCTenantId( argCTenantId );
		deleteSchemaDefByCTenantIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaDefByCTenantIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByCTenantIdxKey argKey )
	{
		BusModelBuffSchemaDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaDef> matchSet = new LinkedList<BusModelBuffSchemaDef>();
		Iterator<BusModelBuffSchemaDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaDef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaDefByMinorVersionIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMinorVersionId )
	{
		BusModelBuffSchemaDefByMinorVersionIdxKey key = (BusModelBuffSchemaDefByMinorVersionIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
		key.setRequiredMinorVersionId( argMinorVersionId );
		deleteSchemaDefByMinorVersionIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaDefByMinorVersionIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByMinorVersionIdxKey argKey )
	{
		BusModelBuffSchemaDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaDef> matchSet = new LinkedList<BusModelBuffSchemaDef>();
		Iterator<BusModelBuffSchemaDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaDef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaDefByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argMinorVersionId,
		String argName )
	{
		BusModelBuffSchemaDefByUNameIdxKey key = (BusModelBuffSchemaDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByUNameIdxKey();
		key.setRequiredMinorVersionId( argMinorVersionId );
		key.setRequiredName( argName );
		deleteSchemaDefByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaDefByUNameIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByUNameIdxKey argKey )
	{
		BusModelBuffSchemaDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaDef> matchSet = new LinkedList<BusModelBuffSchemaDef>();
		Iterator<BusModelBuffSchemaDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaDef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaDefByAuthEMailIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argAuthorEMail )
	{
		BusModelBuffSchemaDefByAuthEMailIdxKey key = (BusModelBuffSchemaDefByAuthEMailIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
		key.setRequiredCTenantId( argCTenantId );
		key.setRequiredAuthorEMail( argAuthorEMail );
		deleteSchemaDefByAuthEMailIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaDefByAuthEMailIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByAuthEMailIdxKey argKey )
	{
		BusModelBuffSchemaDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaDef> matchSet = new LinkedList<BusModelBuffSchemaDef>();
		Iterator<BusModelBuffSchemaDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaDef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaDefByProjectURLIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argProjectURL )
	{
		BusModelBuffSchemaDefByProjectURLIdxKey key = (BusModelBuffSchemaDefByProjectURLIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByProjectURLIdxKey();
		key.setRequiredCTenantId( argCTenantId );
		key.setRequiredProjectURL( argProjectURL );
		deleteSchemaDefByProjectURLIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaDefByProjectURLIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByProjectURLIdxKey argKey )
	{
		BusModelBuffSchemaDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaDef> matchSet = new LinkedList<BusModelBuffSchemaDef>();
		Iterator<BusModelBuffSchemaDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaDef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaDefByPubURIIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argCTenantId,
		String argPublishURI )
	{
		BusModelBuffSchemaDefByPubURIIdxKey key = (BusModelBuffSchemaDefByPubURIIdxKey)schema.getBusModelBuffFactory().getFactorySchemaDef().newByPubURIIdxKey();
		key.setRequiredCTenantId( argCTenantId );
		key.setRequiredPublishURI( argPublishURI );
		deleteSchemaDefByPubURIIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaDefByPubURIIdx( ISecureAuthorization Authorization,
		IBusModelSchemaDefByPubURIIdxKey argKey )
	{
		BusModelBuffSchemaDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaDef> matchSet = new LinkedList<BusModelBuffSchemaDef>();
		Iterator<BusModelBuffSchemaDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaDef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaDefByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffSchemaDef cur;
		LinkedList<BusModelBuffSchemaDef> matchSet = new LinkedList<BusModelBuffSchemaDef>();
		Iterator<BusModelBuffSchemaDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaDef( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaDefByTenantIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argTenantId )
	{
		BusModelBuffScopeByTenantIdxKey key = (BusModelBuffScopeByTenantIdxKey)schema.getBusModelBuffFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteSchemaDefByTenantIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaDefByTenantIdx( ISecureAuthorization Authorization,
		IBusModelScopeByTenantIdxKey argKey )
	{
		BusModelBuffSchemaDef cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaDef> matchSet = new LinkedList<BusModelBuffSchemaDef>();
		Iterator<BusModelBuffSchemaDef> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaDef> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaDef)(schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaDef( Authorization, cur );
		}
	}
}
