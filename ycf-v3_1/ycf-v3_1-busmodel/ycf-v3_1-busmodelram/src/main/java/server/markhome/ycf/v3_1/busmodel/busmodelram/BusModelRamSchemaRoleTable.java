
// Description: Java 25 in-memory RAM DbIO implementation for SchemaRole.

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
 *	BusModelRamSchemaRoleTable in-memory RAM DbIO implementation
 *	for SchemaRole.
 */
public class BusModelRamSchemaRoleTable
	implements IBusModelSchemaRoleTable
{
	private IBusModelSchema schema;
	private Map< $implCommaIJavaOptAtomType$,
				BusModelBuffSchemaRole > dictByPKey
		= new HashMap< $implCommaIJavaOptAtomType$,
				BusModelBuffSchemaRole >();
	private Map< BusModelBuffSchemaRoleBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRole >> dictBySchemaIdx
		= new HashMap< BusModelBuffSchemaRoleBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRole >>();
	private Map< BusModelBuffSchemaRoleByRoleScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRole >> dictByRoleScopeIdx
		= new HashMap< BusModelBuffSchemaRoleByRoleScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRole >>();
	private Map< BusModelBuffSchemaRoleBySchRoleScpIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRole >> dictBySchRoleScpIdx
		= new HashMap< BusModelBuffSchemaRoleBySchRoleScpIdxKey,
				Map< $implCommaIJavaOptAtomType$,
					BusModelBuffSchemaRole >>();

	public BusModelRamSchemaRoleTable( IBusModelSchema argSchema ) {
		schema = argSchema;
	}

	public BusModelBuffRoleDef ensureRec(IBusModelRoleDef rec) {
		if (rec == null) {
			return( null );
		}
		else {
			return (((BusModelBuffRoleDefFactoryService)(schema.getBusModelBuffFactory().getFactoryRoleDef())).ensureRec(rec));
		}
	}

	@Override
	public IBusModelSchemaRole createSchemaRole( ISecureAuthorization Authorization,
		IBusModelSchemaRole iBuff )
	{
		final String S_ProcName = "createSchemaRole";
		
		BusModelBuffSchemaRole Buff = (BusModelBuffSchemaRole)(schema.getTableRoleDef().createRoleDef( Authorization,
			iBuff ));
		$implCommaIJavaOptAtomType$ pkey;
		pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffSchemaRoleBySchemaIdxKey keySchemaIdx = (BusModelBuffSchemaRoleBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		BusModelBuffSchemaRoleByRoleScopeIdxKey keyRoleScopeIdx = (BusModelBuffSchemaRoleByRoleScopeIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
		keyRoleScopeIdx.setRequiredRoleScope( Buff.getRequiredRoleScope() );

		BusModelBuffSchemaRoleBySchRoleScpIdxKey keySchRoleScpIdx = (BusModelBuffSchemaRoleBySchRoleScpIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
		keySchRoleScpIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		keySchRoleScpIdx.setRequiredRoleScope( Buff.getRequiredRoleScope() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new YCFPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableRoleDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"RoleDef",
						"RoleDef",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSchemaDefId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Container",
						"Schema",
						"Schema",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdictSchemaIdx;
		if( dictBySchemaIdx.containsKey( keySchemaIdx ) ) {
			subdictSchemaIdx = dictBySchemaIdx.get( keySchemaIdx );
		}
		else {
			subdictSchemaIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole >();
			dictBySchemaIdx.put( keySchemaIdx, subdictSchemaIdx );
		}
		subdictSchemaIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdictRoleScopeIdx;
		if( dictByRoleScopeIdx.containsKey( keyRoleScopeIdx ) ) {
			subdictRoleScopeIdx = dictByRoleScopeIdx.get( keyRoleScopeIdx );
		}
		else {
			subdictRoleScopeIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole >();
			dictByRoleScopeIdx.put( keyRoleScopeIdx, subdictRoleScopeIdx );
		}
		subdictRoleScopeIdx.put( pkey, Buff );

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdictSchRoleScpIdx;
		if( dictBySchRoleScpIdx.containsKey( keySchRoleScpIdx ) ) {
			subdictSchRoleScpIdx = dictBySchRoleScpIdx.get( keySchRoleScpIdx );
		}
		else {
			subdictSchRoleScpIdx = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole >();
			dictBySchRoleScpIdx.put( keySchRoleScpIdx, subdictSchRoleScpIdx );
		}
		subdictSchRoleScpIdx.put( pkey, Buff );

		if (Buff == null) {
			return( null );
		}
		else {
			int classCode = Buff.getClassCode();
			if (classCode == IBusModelSchemaRole.CLASS_CODE) {
				BusModelBuffSchemaRole retbuff = ((BusModelBuffSchemaRole)(schema.getBusModelBuffFactory().getFactorySchemaRole().newRec()));
				retbuff.set(Buff);
				return( retbuff );
			}
			else {
				throw new YCFUnsupportedClassException(getClass(), S_ProcName, "-create-buff-cloning-", (Integer)classCode, "Classcode not recognized: " + Integer.toString(classCode));
			}
		}
	}

	@Override
	public IBusModelSchemaRole readDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaRole.readDerived";
		IBusModelSchemaRole buff;
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
	public IBusModelSchemaRole lockDerived( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaRole.lockDerived";
		IBusModelSchemaRole buff;
		if( dictByPKey.containsKey( PKey ) ) {
			buff = dictByPKey.get( PKey );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaRole[] readAllDerived( ISecureAuthorization Authorization ) {
		final String S_ProcName = "BusModelRamSchemaRole.readAllDerived";
		IBusModelSchemaRole[] retList = new IBusModelSchemaRole[ dictByPKey.values().size() ];
		Iterator< BusModelBuffSchemaRole > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	@Override
	public IBusModelSchemaRole readDerivedByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByUNameIdx";
		IBusModelRoleDef buff = schema.getTableRoleDef().readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof IBusModelSchemaRole ) {
			return( (IBusModelSchemaRole)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaRole[] readDerivedByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByScopeIdx";
		IBusModelRoleDef buffList[] = schema.getTableRoleDef().readDerivedByScopeIdx( Authorization,
			ScopeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelRoleDef buff;
			ArrayList<IBusModelSchemaRole> filteredList = new ArrayList<IBusModelSchemaRole>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelSchemaRole ) ) {
					filteredList.add( (IBusModelSchemaRole)buff );
				}
			}
			return( filteredList.toArray( new IBusModelSchemaRole[0] ) );
		}
	}

	@Override
	public IBusModelSchemaRole[] readDerivedByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByDefSchemaIdx";
		IBusModelRoleDef buffList[] = schema.getTableRoleDef().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			IBusModelRoleDef buff;
			ArrayList<IBusModelSchemaRole> filteredList = new ArrayList<IBusModelSchemaRole>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof IBusModelSchemaRole ) ) {
					filteredList.add( (IBusModelSchemaRole)buff );
				}
			}
			return( filteredList.toArray( new IBusModelSchemaRole[0] ) );
		}
	}

	@Override
	public IBusModelSchemaRole readDerivedByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByUDefIdx";
		IBusModelRoleDef buff = schema.getTableRoleDef().readDerivedByUDefIdx( Authorization,
			ScopeId,
			DefSchemaId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof IBusModelSchemaRole ) {
			return( (IBusModelSchemaRole)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaRole[] readDerivedBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "BusModelRamSchemaRole.readDerivedBySchemaIdx";
		BusModelBuffSchemaRoleBySchemaIdxKey key = (BusModelBuffSchemaRoleBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchemaIdxKey();

		key.setRequiredSchemaDefId( SchemaDefId );
		IBusModelSchemaRole[] recArray;
		if( dictBySchemaIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdictSchemaIdx
				= dictBySchemaIdx.get( key );
			recArray = new IBusModelSchemaRole[ subdictSchemaIdx.size() ];
			Iterator< BusModelBuffSchemaRole > iter = subdictSchemaIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdictSchemaIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole >();
			dictBySchemaIdx.put( key, subdictSchemaIdx );
			recArray = new IBusModelSchemaRole[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaRole[] readDerivedByRoleScopeIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		final String S_ProcName = "BusModelRamSchemaRole.readDerivedByRoleScopeIdx";
		BusModelBuffSchemaRoleByRoleScopeIdxKey key = (BusModelBuffSchemaRoleByRoleScopeIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newByRoleScopeIdxKey();

		key.setRequiredRoleScope( RoleScope );
		IBusModelSchemaRole[] recArray;
		if( dictByRoleScopeIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdictRoleScopeIdx
				= dictByRoleScopeIdx.get( key );
			recArray = new IBusModelSchemaRole[ subdictRoleScopeIdx.size() ];
			Iterator< BusModelBuffSchemaRole > iter = subdictRoleScopeIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdictRoleScopeIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole >();
			dictByRoleScopeIdx.put( key, subdictRoleScopeIdx );
			recArray = new IBusModelSchemaRole[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaRole[] readDerivedBySchRoleScpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		final String S_ProcName = "BusModelRamSchemaRole.readDerivedBySchRoleScpIdx";
		BusModelBuffSchemaRoleBySchRoleScpIdxKey key = (BusModelBuffSchemaRoleBySchRoleScpIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();

		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredRoleScope( RoleScope );
		IBusModelSchemaRole[] recArray;
		if( dictBySchRoleScpIdx.containsKey( key ) ) {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdictSchRoleScpIdx
				= dictBySchRoleScpIdx.get( key );
			recArray = new IBusModelSchemaRole[ subdictSchRoleScpIdx.size() ];
			Iterator< BusModelBuffSchemaRole > iter = subdictSchRoleScpIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdictSchRoleScpIdx
				= new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole >();
			dictBySchRoleScpIdx.put( key, subdictSchRoleScpIdx );
			recArray = new IBusModelSchemaRole[0];
		}
		return( recArray );
	}

	@Override
	public IBusModelSchemaRole readDerivedByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamRoleDef.readDerivedByIdIdx() ";
		IBusModelSchemaRole buff;
		if( dictByPKey.containsKey( Id ) ) {
			buff = dictByPKey.get( Id );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaRole readRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "BusModelRamSchemaRole.readRec";
		IBusModelSchemaRole buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelSchemaRole.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaRole lockRec( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ PKey )
	{
		final String S_ProcName = "lockRec";
		IBusModelSchemaRole buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( buff.getClassCode() != IBusModelSchemaRole.CLASS_CODE ) ) {
			buff = null;
		}
		return( buff );
	}

	@Override
	public IBusModelSchemaRole[] readAllRec( ISecureAuthorization Authorization )
	{
		final String S_ProcName = "BusModelRamSchemaRole.readAllRec";
		IBusModelSchemaRole buff;
		ArrayList<IBusModelSchemaRole> filteredList = new ArrayList<IBusModelSchemaRole>();
		IBusModelSchemaRole[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRole.CLASS_CODE ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRole[0] ) );
	}

	@Override
	public IBusModelSchemaRole readRecByIdIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 Id )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByIdIdx() ";
		IBusModelSchemaRole buff = readDerivedByIdIdx( Authorization,
			Id );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
			return( (IBusModelSchemaRole)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaRole readRecByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByUNameIdx() ";
		IBusModelSchemaRole buff = readDerivedByUNameIdx( Authorization,
			ScopeId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
			return( (IBusModelSchemaRole)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaRole[] readRecByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByScopeIdx() ";
		IBusModelSchemaRole buff;
		ArrayList<IBusModelSchemaRole> filteredList = new ArrayList<IBusModelSchemaRole>();
		IBusModelSchemaRole[] buffList = readDerivedByScopeIdx( Authorization,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRole)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRole[0] ) );
	}

	@Override
	public IBusModelSchemaRole[] readRecByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByDefSchemaIdx() ";
		IBusModelSchemaRole buff;
		ArrayList<IBusModelSchemaRole> filteredList = new ArrayList<IBusModelSchemaRole>();
		IBusModelSchemaRole[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRole)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRole[0] ) );
	}

	@Override
	public IBusModelSchemaRole readRecByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		final String S_ProcName = "BusModelRamRoleDef.readRecByUDefIdx() ";
		IBusModelSchemaRole buff = readDerivedByUDefIdx( Authorization,
			ScopeId,
			DefSchemaId,
			Name );
		if( ( buff != null ) && ( buff.getClassCode() == IBusModelRoleDef.CLASS_CODE ) ) {
			return( (IBusModelSchemaRole)buff );
		}
		else {
			return( null );
		}
	}

	@Override
	public IBusModelSchemaRole[] readRecBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "BusModelRamSchemaRole.readRecBySchemaIdx() ";
		IBusModelSchemaRole buff;
		ArrayList<IBusModelSchemaRole> filteredList = new ArrayList<IBusModelSchemaRole>();
		IBusModelSchemaRole[] buffList = readDerivedBySchemaIdx( Authorization,
			SchemaDefId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRole.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRole)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRole[0] ) );
	}

	@Override
	public IBusModelSchemaRole[] readRecByRoleScopeIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		final String S_ProcName = "BusModelRamSchemaRole.readRecByRoleScopeIdx() ";
		IBusModelSchemaRole buff;
		ArrayList<IBusModelSchemaRole> filteredList = new ArrayList<IBusModelSchemaRole>();
		IBusModelSchemaRole[] buffList = readDerivedByRoleScopeIdx( Authorization,
			RoleScope );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRole.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRole)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRole[0] ) );
	}

	@Override
	public IBusModelSchemaRole[] readRecBySchRoleScpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		final String S_ProcName = "BusModelRamSchemaRole.readRecBySchRoleScpIdx() ";
		IBusModelSchemaRole buff;
		ArrayList<IBusModelSchemaRole> filteredList = new ArrayList<IBusModelSchemaRole>();
		IBusModelSchemaRole[] buffList = readDerivedBySchRoleScpIdx( Authorization,
			SchemaDefId,
			RoleScope );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && ( buff.getClassCode() == IBusModelSchemaRole.CLASS_CODE ) ) {
				filteredList.add( (IBusModelSchemaRole)buff );
			}
		}
		return( filteredList.toArray( new IBusModelSchemaRole[0] ) );
	}

	public IBusModelSchemaRole updateSchemaRole( ISecureAuthorization Authorization,
		IBusModelSchemaRole iBuff )
	{
		BusModelBuffSchemaRole Buff = (BusModelBuffSchemaRole)(schema.getTableRoleDef().updateRoleDef( Authorization,	iBuff ));
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)Buff.getPKey();
		BusModelBuffSchemaRole existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new YCFStaleCacheDetectedException( getClass(),
				"updateSchemaRole",
				"Existing record not found",
				"Existing record not found",
				"SchemaRole",
				"SchemaRole",
				pkey );
		}
		BusModelBuffSchemaRoleBySchemaIdxKey existingKeySchemaIdx = (BusModelBuffSchemaRoleBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchemaIdxKey();
		existingKeySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		BusModelBuffSchemaRoleBySchemaIdxKey newKeySchemaIdx = (BusModelBuffSchemaRoleBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchemaIdxKey();
		newKeySchemaIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );

		BusModelBuffSchemaRoleByRoleScopeIdxKey existingKeyRoleScopeIdx = (BusModelBuffSchemaRoleByRoleScopeIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
		existingKeyRoleScopeIdx.setRequiredRoleScope( existing.getRequiredRoleScope() );

		BusModelBuffSchemaRoleByRoleScopeIdxKey newKeyRoleScopeIdx = (BusModelBuffSchemaRoleByRoleScopeIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
		newKeyRoleScopeIdx.setRequiredRoleScope( Buff.getRequiredRoleScope() );

		BusModelBuffSchemaRoleBySchRoleScpIdxKey existingKeySchRoleScpIdx = (BusModelBuffSchemaRoleBySchRoleScpIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
		existingKeySchRoleScpIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		existingKeySchRoleScpIdx.setRequiredRoleScope( existing.getRequiredRoleScope() );

		BusModelBuffSchemaRoleBySchRoleScpIdxKey newKeySchRoleScpIdx = (BusModelBuffSchemaRoleBySchRoleScpIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
		newKeySchRoleScpIdx.setRequiredSchemaDefId( Buff.getRequiredSchemaDefId() );
		newKeySchRoleScpIdx.setRequiredRoleScope( Buff.getRequiredRoleScope() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableRoleDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSchemaRole",
						"Superclass",
						"Superclass",
						"SuperClass",
						"SuperClass",
						"RoleDef",
						"RoleDef",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableSchemaDef().readDerivedByIdIdx( Authorization,
						Buff.getRequiredSchemaDefId() ) )
				{
					throw new YCFUnresolvedRelationException( getClass(),
						"updateSchemaRole",
						"Container",
						"Container",
						"Schema",
						"Schema",
						"SchemaDef",
						"SchemaDef",
						null );
				}
			}
		}

		// Update is valid

		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictBySchemaIdx.get( existingKeySchemaIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchemaIdx.containsKey( newKeySchemaIdx ) ) {
			subdict = dictBySchemaIdx.get( newKeySchemaIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole >();
			dictBySchemaIdx.put( newKeySchemaIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictByRoleScopeIdx.get( existingKeyRoleScopeIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByRoleScopeIdx.containsKey( newKeyRoleScopeIdx ) ) {
			subdict = dictByRoleScopeIdx.get( newKeyRoleScopeIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole >();
			dictByRoleScopeIdx.put( newKeyRoleScopeIdx, subdict );
		}
		subdict.put( pkey, Buff );

		subdict = dictBySchRoleScpIdx.get( existingKeySchRoleScpIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictBySchRoleScpIdx.containsKey( newKeySchRoleScpIdx ) ) {
			subdict = dictBySchRoleScpIdx.get( newKeySchRoleScpIdx );
		}
		else {
			subdict = new HashMap< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole >();
			dictBySchRoleScpIdx.put( newKeySchRoleScpIdx, subdict );
		}
		subdict.put( pkey, Buff );

		return(Buff);
	}

	@Override
	public void deleteSchemaRole( ISecureAuthorization Authorization,
		IBusModelSchemaRole iBuff )
	{
		final String S_ProcName = "BusModelRamSchemaRoleTable.deleteSchemaRole() ";
		BusModelBuffSchemaRole Buff = (BusModelBuffSchemaRole)ensureRec(iBuff);
		int classCode;
		$implCommaIJavaOptAtomType$ pkey = ($implCommaIJavaOptAtomType$)(Buff.getPKey());
		BusModelBuffSchemaRole existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new YCFCollisionDetectedException( getClass(),
				"deleteSchemaRole",
				pkey );
		}
		BusModelBuffSchemaRoleBySchemaIdxKey keySchemaIdx = (BusModelBuffSchemaRoleBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		BusModelBuffSchemaRoleByRoleScopeIdxKey keyRoleScopeIdx = (BusModelBuffSchemaRoleByRoleScopeIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
		keyRoleScopeIdx.setRequiredRoleScope( existing.getRequiredRoleScope() );

		BusModelBuffSchemaRoleBySchRoleScpIdxKey keySchRoleScpIdx = (BusModelBuffSchemaRoleBySchRoleScpIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
		keySchRoleScpIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keySchRoleScpIdx.setRequiredRoleScope( existing.getRequiredRoleScope() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< $implCommaIJavaOptAtomType$, BusModelBuffSchemaRole > subdict;

		dictByPKey.remove( pkey );

		subdict = dictBySchemaIdx.get( keySchemaIdx );
		subdict.remove( pkey );

		subdict = dictByRoleScopeIdx.get( keyRoleScopeIdx );
		subdict.remove( pkey );

		subdict = dictBySchRoleScpIdx.get( keySchRoleScpIdx );
		subdict.remove( pkey );

		schema.getTableRoleDef().deleteRoleDef( Authorization,
			Buff );
	}
	@Override
	public void deleteSchemaRoleBySchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId )
	{
		BusModelBuffSchemaRoleBySchemaIdxKey key = (BusModelBuffSchemaRoleBySchemaIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( argSchemaDefId );
		deleteSchemaRoleBySchemaIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRoleBySchemaIdx( ISecureAuthorization Authorization,
		IBusModelSchemaRoleBySchemaIdxKey argKey )
	{
		BusModelBuffSchemaRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRole> matchSet = new LinkedList<BusModelBuffSchemaRole>();
		Iterator<BusModelBuffSchemaRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRole)(schema.getTableSchemaRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRoleByRoleScopeIdx( ISecureAuthorization Authorization,
		IBusModelPubSchema.RoleScopeEnum argRoleScope )
	{
		BusModelBuffSchemaRoleByRoleScopeIdxKey key = (BusModelBuffSchemaRoleByRoleScopeIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
		key.setRequiredRoleScope( argRoleScope );
		deleteSchemaRoleByRoleScopeIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRoleByRoleScopeIdx( ISecureAuthorization Authorization,
		IBusModelSchemaRoleByRoleScopeIdxKey argKey )
	{
		BusModelBuffSchemaRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRole> matchSet = new LinkedList<BusModelBuffSchemaRole>();
		Iterator<BusModelBuffSchemaRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRole)(schema.getTableSchemaRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRoleBySchRoleScpIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argSchemaDefId,
		IBusModelPubSchema.RoleScopeEnum argRoleScope )
	{
		BusModelBuffSchemaRoleBySchRoleScpIdxKey key = (BusModelBuffSchemaRoleBySchRoleScpIdxKey)schema.getBusModelBuffFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
		key.setRequiredSchemaDefId( argSchemaDefId );
		key.setRequiredRoleScope( argRoleScope );
		deleteSchemaRoleBySchRoleScpIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRoleBySchRoleScpIdx( ISecureAuthorization Authorization,
		IBusModelSchemaRoleBySchRoleScpIdxKey argKey )
	{
		BusModelBuffSchemaRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRole> matchSet = new LinkedList<BusModelBuffSchemaRole>();
		Iterator<BusModelBuffSchemaRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRole)(schema.getTableSchemaRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRoleByIdIdx( ISecureAuthorization Authorization,
		$implCommaIJavaOptAtomType$ argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		BusModelBuffSchemaRole cur;
		LinkedList<BusModelBuffSchemaRole> matchSet = new LinkedList<BusModelBuffSchemaRole>();
		Iterator<BusModelBuffSchemaRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRole)(schema.getTableSchemaRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRoleByUNameIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		String argName )
	{
		BusModelBuffRoleDefByUNameIdxKey key = (BusModelBuffRoleDefByUNameIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUNameIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteSchemaRoleByUNameIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRoleByUNameIdx( ISecureAuthorization Authorization,
		IBusModelRoleDefByUNameIdxKey argKey )
	{
		BusModelBuffSchemaRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRole> matchSet = new LinkedList<BusModelBuffSchemaRole>();
		Iterator<BusModelBuffSchemaRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRole)(schema.getTableSchemaRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRoleByScopeIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId )
	{
		BusModelBuffRoleDefByScopeIdxKey key = (BusModelBuffRoleDefByScopeIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByScopeIdxKey();
		key.setRequiredScopeId( argScopeId );
		deleteSchemaRoleByScopeIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRoleByScopeIdx( ISecureAuthorization Authorization,
		IBusModelRoleDefByScopeIdxKey argKey )
	{
		BusModelBuffSchemaRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRole> matchSet = new LinkedList<BusModelBuffSchemaRole>();
		Iterator<BusModelBuffSchemaRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRole)(schema.getTableSchemaRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRoleByDefSchemaIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argDefSchemaId )
	{
		BusModelBuffRoleDefByDefSchemaIdxKey key = (BusModelBuffRoleDefByDefSchemaIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteSchemaRoleByDefSchemaIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRoleByDefSchemaIdx( ISecureAuthorization Authorization,
		IBusModelRoleDefByDefSchemaIdxKey argKey )
	{
		BusModelBuffSchemaRole cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRole> matchSet = new LinkedList<BusModelBuffSchemaRole>();
		Iterator<BusModelBuffSchemaRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRole)(schema.getTableSchemaRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRole( Authorization, cur );
		}
	}

	@Override
	public void deleteSchemaRoleByUDefIdx( ISecureAuthorization Authorization,
		IYCFKeyHash256 argScopeId,
		IYCFKeyHash256 argDefSchemaId,
		String argName )
	{
		BusModelBuffRoleDefByUDefIdxKey key = (BusModelBuffRoleDefByUDefIdxKey)schema.getBusModelBuffFactory().getFactoryRoleDef().newByUDefIdxKey();
		key.setRequiredScopeId( argScopeId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		key.setRequiredName( argName );
		deleteSchemaRoleByUDefIdx( Authorization, key );
	}

	@Override
	public void deleteSchemaRoleByUDefIdx( ISecureAuthorization Authorization,
		IBusModelRoleDefByUDefIdxKey argKey )
	{
		BusModelBuffSchemaRole cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<BusModelBuffSchemaRole> matchSet = new LinkedList<BusModelBuffSchemaRole>();
		Iterator<BusModelBuffSchemaRole> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<BusModelBuffSchemaRole> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = (BusModelBuffSchemaRole)(schema.getTableSchemaRole().readDerivedByIdIdx( Authorization,
				cur.getRequiredId() ));
			deleteSchemaRole( Authorization, cur );
		}
	}
}
