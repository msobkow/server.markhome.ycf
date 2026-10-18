// Description: Java 25 Table Object implementation for Scope.

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

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public class BusModelScopeTableObj
	implements IBusModelScopeTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelScope.CLASS_CODE;
	protected static final int backingClassCode = IBusModelScope.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj> allScope;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj > > indexByTenantIdx;
	public static String TABLE_NAME = "Scope";
	public static String TABLE_DBNAME = "scopedef";

	public BusModelScopeTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelScopeObj>();
		allScope = null;
		indexByTenantIdx = null;
	}

	public BusModelScopeTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelScopeObj>();
		allScope = null;
		indexByTenantIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelScopeTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( backingClassCode );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( runtimeClassCode );
	}

	/**
	 *	Set the runtime class code for this table; this is done only during application initialization by the SchemaObj's <tt>initClassCodes()</tt> static method,
	 *	which will only set the class codes once and never again.  Once set, the class codes are immutable within the application.
	 *	Application programmers should never invoke this method, so it has package access only.
	 *
	 *	@param	argNewClassCode	The runtime class code to be used by clients and integrated application logic to identify this table of this schema.
	 */
	static void setRuntimeClassCode(int argNewClassCode ) {
		if (argNewClassCode <= 0) {
			throw new YCFArgumentUnderflowException(BusModelScopeTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
		}
		runtimeClassCode = argNewClassCode;
	}

	@Override
	public IBusModelSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IBusModelSchemaObj value ) {
		schema = (IBusModelSchemaObj)value;
	}

	@Override
	public String getTableName() {
		return( TABLE_NAME );
	}

	@Override
	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	@Override
	public Class getObjQualifyingClass() {
		return( null );
	}


	@Override
	public void minimizeMemory() {
		allScope = null;
		indexByTenantIdx = null;
		List<IBusModelScopeObj> toForget = new LinkedList<IBusModelScopeObj>();
		IBusModelScopeObj cur = null;
		Iterator<IBusModelScopeObj> iter = members.values().iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			toForget.add( cur );
		}
		iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget();
		}
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelScopeObj.
	 */
	@Override
	public IBusModelScopeObj newInstance() {
		IBusModelScopeObj inst = new BusModelScopeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelScopeObj.
	 */
	@Override
	public IBusModelScopeEditObj newEditInstance( IBusModelScopeObj orig ) {
		IBusModelScopeEditObj edit = new BusModelScopeEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelScopeObj constructByClassCode( int backingClassCode ) {
		IBusModelScopeObj obj = null;
		if( backingClassCode == IBusModelScope.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getScopeTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelSchemaDef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getSchemaDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelSchemaRef.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getSchemaRefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelServerMethod.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getServerMethodTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelServerObjFunc.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getServerObjFuncTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelServerProc.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getServerProcTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelServerListFunc.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getServerListFuncTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTable.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTableTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelClearDep.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getClearDepTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelClearSubDep1.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getClearSubDep1TableObj().newInstance();
		}
		else if( backingClassCode == IBusModelClearSubDep2.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getClearSubDep2TableObj().newInstance();
		}
		else if( backingClassCode == IBusModelClearSubDep3.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getClearSubDep3TableObj().newInstance();
		}
		else if( backingClassCode == IBusModelClearTopDep.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getClearTopDepTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDelDep.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDelDepTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDelSubDep1.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDelSubDep1TableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDelSubDep2.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDelSubDep2TableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDelSubDep3.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDelSubDep3TableObj().newInstance();
		}
		else if( backingClassCode == IBusModelDelTopDep.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getDelTopDepTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelIndex.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getIndexTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelPopDep.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getPopDepTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelPopSubDep1.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getPopSubDep1TableObj().newInstance();
		}
		else if( backingClassCode == IBusModelPopSubDep2.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getPopSubDep2TableObj().newInstance();
		}
		else if( backingClassCode == IBusModelPopSubDep3.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getPopSubDep3TableObj().newInstance();
		}
		else if( backingClassCode == IBusModelPopTopDep.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getPopTopDepTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelRelation.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getRelationTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IBusModelScopeObj realiseScope( IBusModelScopeObj Obj ) {
		IBusModelScopeObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelScopeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelScopeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allScope != null ) {
				allScope.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allScope != null ) {
				allScope.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelScopeObj createScope( IBusModelScopeObj Obj ) {
		IBusModelScopeObj obj = Obj;
		IBusModelScope rec = obj.getScopeRec();
		schema.getBusModelBackingStore().getTableScope().createScope(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelScopeObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelScopeObj readScope( $implCommaIJavaOptAtomType$ pkey ) {
		return( readScope( pkey, false ) );
	}

	@Override
	public IBusModelScopeObj readScope( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelScopeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelScope readRec = schema.getBusModelBackingStore().getTableScope().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelScopeObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelScopeObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelScopeObj readCachedScope( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelScopeObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeScope( IBusModelScopeObj obj )
	{
		final String S_ProcName = "BusModelScopeTableObj.reallyDeepDisposeScope() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelScopeObj existing = readCachedScope( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelScopeByTenantIdxKey keyTenantIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );



		if( indexByTenantIdx != null ) {
			if( indexByTenantIdx.containsKey( keyTenantIdx ) ) {
				indexByTenantIdx.get( keyTenantIdx ).remove( pkey );
				if( indexByTenantIdx.get( keyTenantIdx ).size() <= 0 ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeScope( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelScopeObj obj = readCachedScope( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelScopeObj lockScope( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelScopeObj locked = null;
		IBusModelScope lockRec = schema.getBusModelBackingStore().getTableScope().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelScopeObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelScopeObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockScope", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelScopeObj> readAllScope() {
		return( readAllScope( false ) );
	}

	@Override
	public List<IBusModelScopeObj> readAllScope( boolean forceRead ) {
		final String S_ProcName = "readAllScope";
		if( ( allScope == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelScopeObj>();
			allScope = map;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readAllDerived( null );
			IBusModelScope rec;
			IBusModelScopeObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelScopeObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelScopeObj realised = (IBusModelScopeObj)obj.realise();
			}
		}
		int len = allScope.size();
		IBusModelScopeObj arr[] = new IBusModelScopeObj[len];
		Iterator<IBusModelScopeObj> valIter = allScope.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new YCFArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<IBusModelScopeObj> arrayList = new ArrayList<IBusModelScopeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelScopeObj> cmp = new Comparator<IBusModelScopeObj>() {
			@Override
			public int compare( IBusModelScopeObj lhs, IBusModelScopeObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<IBusModelScopeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelScopeObj> readCachedAllScope() {
		final String S_ProcName = "readCachedAllScope";
		ArrayList<IBusModelScopeObj> arrayList = new ArrayList<IBusModelScopeObj>();
		if( allScope != null ) {
			int len = allScope.size();
			IBusModelScopeObj arr[] = new IBusModelScopeObj[len];
			Iterator<IBusModelScopeObj> valIter = allScope.values().iterator();
			int idx = 0;
			while( ( idx < len ) && valIter.hasNext() ) {
				arr[idx++] = valIter.next();
			}
			if( idx < len ) {
				throw new YCFArgumentUnderflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
			}
			else if( valIter.hasNext() ) {
				throw new YCFArgumentOverflowException( getClass(),
						S_ProcName,
						0,
						"idx",
						idx,
						len );
			}
			for( idx = 0; idx < len; idx ++ ) {
				arrayList.add( arr[idx] );
			}
		}
		Comparator<IBusModelScopeObj> cmp = new Comparator<IBusModelScopeObj>() {
			public int compare( IBusModelScopeObj lhs, IBusModelScopeObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public IBusModelScopeObj readScopeByIdIdx( IYCFKeyHash256 Id )
	{
		return( readScopeByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelScopeObj readScopeByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelScopeObj obj = readScope( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelScopeObj> readScopeByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readScopeByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelScopeObj> readScopeByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readScopeByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelScopeObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelScopeObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelScopeObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelScopeObj realised = (IBusModelScopeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelScopeObj arr[] = new IBusModelScopeObj[len];
		Iterator<IBusModelScopeObj> valIter = dict.values().iterator();
		int idx = 0;
		while( ( idx < len ) && valIter.hasNext() ) {
			arr[idx++] = valIter.next();
		}
		if( idx < len ) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"idx",
				idx,
				len );
		}
		else if( valIter.hasNext() ) {
			throw new YCFArgumentOverflowException( getClass(),
					S_ProcName,
					0,
					"idx",
					idx,
					len );
		}
		ArrayList<IBusModelScopeObj> arrayList = new ArrayList<IBusModelScopeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelScopeObj> cmp = new Comparator<IBusModelScopeObj>() {
			@Override
			public int compare( IBusModelScopeObj lhs, IBusModelScopeObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<IBusModelScopeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelScopeObj readCachedScopeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelScopeObj obj = null;
		obj = readCachedScope( Id );
		return( obj );
	}

	@Override
	public List<IBusModelScopeObj> readCachedScopeByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedScopeByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelScopeObj> arrayList = new ArrayList<IBusModelScopeObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelScopeObj arr[] = new IBusModelScopeObj[len];
				Iterator<IBusModelScopeObj> valIter = dict.values().iterator();
				int idx = 0;
				while( ( idx < len ) && valIter.hasNext() ) {
					arr[idx++] = valIter.next();
				}
				if( idx < len ) {
					throw new YCFArgumentUnderflowException( getClass(),
						S_ProcName,
						0,
						"idx",
						idx,
						len );
				}
				else if( valIter.hasNext() ) {
					throw new YCFArgumentOverflowException( getClass(),
							S_ProcName,
							0,
							"idx",
							idx,
							len );
				}
				for( idx = 0; idx < len; idx ++ ) {
					arrayList.add( arr[idx] );
				}
			}
		}
		else {
			IBusModelScopeObj obj;
			Iterator<IBusModelScopeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelScopeObj> cmp = new Comparator<IBusModelScopeObj>() {
			@Override
			public int compare( IBusModelScopeObj lhs, IBusModelScopeObj rhs ) {
				if( lhs == null ) {
					if( rhs == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhs == null ) {
					return( 1 );
				}
				else {
					$implCommaIJavaOptAtomType$ lhsPKey = lhs.getPKey();
					$implCommaIJavaOptAtomType$ rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeScopeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelScopeObj obj = readCachedScopeByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeScopeByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeScopeByTenantIdx";
		IBusModelScopeObj obj;
		List<IBusModelScopeObj> arrayList = readCachedScopeByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelScopeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelScopeObj updateScope( IBusModelScopeObj Obj ) {
		IBusModelScopeObj obj = Obj;
		schema.getBusModelBackingStore().getTableScope().updateScope( null,
			Obj.getScopeRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getScopeTableObj().getClassCode() ) {
			obj = (IBusModelScopeObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteScope( IBusModelScopeObj Obj ) {
		IBusModelScopeObj obj = Obj;
		schema.getBusModelBackingStore().getTableScope().deleteScope( null,
			obj.getScopeRec() );
		Obj.forget();
	}

	@Override
	public void deleteScopeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelScopeObj obj = readScope(Id);
		if( obj != null ) {
			IBusModelScopeEditObj editObj = (IBusModelScopeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelScopeEditObj)obj.beginEdit();
				if( editObj != null ) {
					editStarted = true;
				}
				else {
					editStarted = false;
				}
			}
			else {
				editStarted = false;
			}
			if( editObj != null ) {
				editObj.deleteInstance();
				if( editStarted ) {
					editObj.endEdit();
				}
			}
			obj.forget();
		}
		deepDisposeScopeByIdIdx( Id );
	}

	@Override
	public void deleteScopeByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelScopeObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelScopeObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableScope().deleteScopeByTenantIdx( null,
				TenantId );
			Iterator<IBusModelScopeObj> iter = dict.values().iterator();
			IBusModelScopeObj obj;
			List<IBusModelScopeObj> toForget = new LinkedList<IBusModelScopeObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByTenantIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableScope().deleteScopeByTenantIdx( null,
				TenantId );
		}
		deepDisposeScopeByTenantIdx( TenantId );
	}
}