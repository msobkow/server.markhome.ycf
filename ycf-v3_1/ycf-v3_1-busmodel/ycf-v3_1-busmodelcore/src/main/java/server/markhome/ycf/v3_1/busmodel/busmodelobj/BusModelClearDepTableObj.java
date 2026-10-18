// Description: Java 25 Table Object implementation for ClearDep.

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

public class BusModelClearDepTableObj
	implements IBusModelClearDepTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelClearDep.CLASS_CODE;
	protected static final int backingClassCode = IBusModelClearDep.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> allClearDep;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > > indexByTenantIdx;
	private Map< IBusModelClearDepByClearDepIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > > indexByClearDepIdx;
	private Map< IBusModelClearDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > > indexByDefSchemaIdx;
	public static String TABLE_NAME = "ClearDep";
	public static String TABLE_DBNAME = "clr_dep";

	public BusModelClearDepTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearDepObj>();
		allClearDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
	}

	public BusModelClearDepTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearDepObj>();
		allClearDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelClearDepTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelClearDepTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		return( IBusModelSchemaDefObj.class );
	}


	@Override
	public void minimizeMemory() {
		allClearDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		List<IBusModelClearDepObj> toForget = new LinkedList<IBusModelClearDepObj>();
		IBusModelClearDepObj cur = null;
		Iterator<IBusModelClearDepObj> iter = members.values().iterator();
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
	 *	BusModelClearDepObj.
	 */
	@Override
	public IBusModelClearDepObj newInstance() {
		IBusModelClearDepObj inst = new BusModelClearDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelClearDepObj.
	 */
	@Override
	public IBusModelClearDepEditObj newEditInstance( IBusModelClearDepObj orig ) {
		IBusModelClearDepEditObj edit = new BusModelClearDepEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelClearDepObj realiseClearDep( IBusModelClearDepObj Obj ) {
		IBusModelClearDepObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelClearDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelClearDepObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				IBusModelClearDepByClearDepIdxKey keyClearDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.remove( keepObj.getPKey() );
					if( mapClearDepIdx.size() <= 0 ) {
						indexByClearDepIdx.remove( keyClearDepIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelClearDepObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				IBusModelClearDepByClearDepIdxKey keyClearDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allClearDep != null ) {
				allClearDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelClearDepObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearDep != null ) {
				allClearDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				IBusModelClearDepByClearDepIdxKey keyClearDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelClearDepObj createClearDep( IBusModelClearDepObj Obj ) {
		IBusModelClearDepObj obj = Obj;
		IBusModelClearDep rec = obj.getClearDepRec();
		schema.getBusModelBackingStore().getTableClearDep().createClearDep(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelClearDepObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelClearDepObj readClearDep( $implCommaIJavaOptAtomType$ pkey ) {
		return( readClearDep( pkey, false ) );
	}

	@Override
	public IBusModelClearDepObj readClearDep( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelClearDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelClearDep readRec = schema.getBusModelBackingStore().getTableClearDep().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelClearDepObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelClearDepObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelClearDepObj readCachedClearDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelClearDepObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeClearDep( IBusModelClearDepObj obj )
	{
		final String S_ProcName = "BusModelClearDepTableObj.reallyDeepDisposeClearDep() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelClearDepObj existing = readCachedClearDep( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelClearDepByClearDepIdxKey keyClearDepIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		keyClearDepIdx.setRequiredRelationId( existing.getRequiredRelationId() );

		IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );



		if( indexByClearDepIdx != null ) {
			if( indexByClearDepIdx.containsKey( keyClearDepIdx ) ) {
				indexByClearDepIdx.get( keyClearDepIdx ).remove( pkey );
				if( indexByClearDepIdx.get( keyClearDepIdx ).size() <= 0 ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}
		}

		if( indexByDefSchemaIdx != null ) {
			if( indexByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
				indexByDefSchemaIdx.get( keyDefSchemaIdx ).remove( pkey );
				if( indexByDefSchemaIdx.get( keyDefSchemaIdx ).size() <= 0 ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}
		}


		schema.getScopeTableObj().reallyDeepDisposeScope( obj );
	}
	@Override
	public void deepDisposeClearDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelClearDepObj obj = readCachedClearDep( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelClearDepObj lockClearDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelClearDepObj locked = null;
		IBusModelClearDep lockRec = schema.getBusModelBackingStore().getTableClearDep().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelClearDepObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelClearDepObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockClearDep", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelClearDepObj> readAllClearDep() {
		return( readAllClearDep( false ) );
	}

	@Override
	public List<IBusModelClearDepObj> readAllClearDep( boolean forceRead ) {
		final String S_ProcName = "readAllClearDep";
		if( ( allClearDep == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelClearDepObj>();
			allClearDep = map;
			IBusModelClearDep[] recList = schema.getBusModelBackingStore().getTableClearDep().readAllDerived( null );
			IBusModelClearDep rec;
			IBusModelClearDepObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearDepObj realised = (IBusModelClearDepObj)obj.realise();
			}
		}
		int len = allClearDep.size();
		IBusModelClearDepObj arr[] = new IBusModelClearDepObj[len];
		Iterator<IBusModelClearDepObj> valIter = allClearDep.values().iterator();
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
		ArrayList<IBusModelClearDepObj> arrayList = new ArrayList<IBusModelClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearDepObj> cmp = new Comparator<IBusModelClearDepObj>() {
			@Override
			public int compare( IBusModelClearDepObj lhs, IBusModelClearDepObj rhs ) {
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
		List<IBusModelClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearDepObj> readCachedAllClearDep() {
		final String S_ProcName = "readCachedAllClearDep";
		ArrayList<IBusModelClearDepObj> arrayList = new ArrayList<IBusModelClearDepObj>();
		if( allClearDep != null ) {
			int len = allClearDep.size();
			IBusModelClearDepObj arr[] = new IBusModelClearDepObj[len];
			Iterator<IBusModelClearDepObj> valIter = allClearDep.values().iterator();
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
		Comparator<IBusModelClearDepObj> cmp = new Comparator<IBusModelClearDepObj>() {
			public int compare( IBusModelClearDepObj lhs, IBusModelClearDepObj rhs ) {
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
	public IBusModelClearDepObj readClearDepByIdIdx( IYCFKeyHash256 Id )
	{
		return( readClearDepByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelClearDepObj readClearDepByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelClearDepObj obj = readClearDep( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelClearDepObj> readClearDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readClearDepByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelClearDepObj> readClearDepByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearDepObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearDepObj realised = (IBusModelClearDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearDepObj arr[] = new IBusModelClearDepObj[len];
		Iterator<IBusModelClearDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearDepObj> arrayList = new ArrayList<IBusModelClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearDepObj> cmp = new Comparator<IBusModelClearDepObj>() {
			@Override
			public int compare( IBusModelClearDepObj lhs, IBusModelClearDepObj rhs ) {
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
		List<IBusModelClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearDepObj> readClearDepByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		return( readClearDepByClearDepIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelClearDepObj> readClearDepByClearDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearDepByClearDepIdx";
		IBusModelClearDepByClearDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> dict;
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< IBusModelClearDepByClearDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearDepObj > >();
		}
		if( ( ! forceRead ) && indexByClearDepIdx.containsKey( key ) ) {
			dict = indexByClearDepIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearDepObj>();
			IBusModelClearDepObj obj;
			IBusModelClearDep[] recList = schema.getBusModelBackingStore().getTableClearDep().readDerivedByClearDepIdx( null,
				RelationId );
			IBusModelClearDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearDepObj realised = (IBusModelClearDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearDepIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearDepObj arr[] = new IBusModelClearDepObj[len];
		Iterator<IBusModelClearDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearDepObj> arrayList = new ArrayList<IBusModelClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearDepObj> cmp = new Comparator<IBusModelClearDepObj>() {
			@Override
			public int compare( IBusModelClearDepObj lhs, IBusModelClearDepObj rhs ) {
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
		List<IBusModelClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearDepObj> readClearDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readClearDepByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelClearDepObj> readClearDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearDepByDefSchemaIdx";
		IBusModelClearDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelClearDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearDepObj>();
			IBusModelClearDepObj obj;
			IBusModelClearDep[] recList = schema.getBusModelBackingStore().getTableClearDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelClearDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearDepObj realised = (IBusModelClearDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearDepObj arr[] = new IBusModelClearDepObj[len];
		Iterator<IBusModelClearDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearDepObj> arrayList = new ArrayList<IBusModelClearDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearDepObj> cmp = new Comparator<IBusModelClearDepObj>() {
			@Override
			public int compare( IBusModelClearDepObj lhs, IBusModelClearDepObj rhs ) {
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
		List<IBusModelClearDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelClearDepObj readCachedClearDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelClearDepObj obj = null;
		obj = readCachedClearDep( Id );
		return( obj );
	}

	@Override
	public List<IBusModelClearDepObj> readCachedClearDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedClearDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelClearDepObj> arrayList = new ArrayList<IBusModelClearDepObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelClearDepObj arr[] = new IBusModelClearDepObj[len];
				Iterator<IBusModelClearDepObj> valIter = dict.values().iterator();
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
			IBusModelClearDepObj obj;
			Iterator<IBusModelClearDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearDepObj> cmp = new Comparator<IBusModelClearDepObj>() {
			@Override
			public int compare( IBusModelClearDepObj lhs, IBusModelClearDepObj rhs ) {
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
	public List<IBusModelClearDepObj> readCachedClearDepByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedClearDepByClearDepIdx";
		IBusModelClearDepByClearDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelClearDepObj> arrayList = new ArrayList<IBusModelClearDepObj>();
		if( indexByClearDepIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> dict;
			if( indexByClearDepIdx.containsKey( key ) ) {
				dict = indexByClearDepIdx.get( key );
				int len = dict.size();
				IBusModelClearDepObj arr[] = new IBusModelClearDepObj[len];
				Iterator<IBusModelClearDepObj> valIter = dict.values().iterator();
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
			IBusModelClearDepObj obj;
			Iterator<IBusModelClearDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearDepObj> cmp = new Comparator<IBusModelClearDepObj>() {
			@Override
			public int compare( IBusModelClearDepObj lhs, IBusModelClearDepObj rhs ) {
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
	public List<IBusModelClearDepObj> readCachedClearDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedClearDepByDefSchemaIdx";
		IBusModelClearDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelClearDepObj> arrayList = new ArrayList<IBusModelClearDepObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelClearDepObj arr[] = new IBusModelClearDepObj[len];
				Iterator<IBusModelClearDepObj> valIter = dict.values().iterator();
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
			IBusModelClearDepObj obj;
			Iterator<IBusModelClearDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearDepObj> cmp = new Comparator<IBusModelClearDepObj>() {
			@Override
			public int compare( IBusModelClearDepObj lhs, IBusModelClearDepObj rhs ) {
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
	public void deepDisposeClearDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelClearDepObj obj = readCachedClearDepByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeClearDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeClearDepByTenantIdx";
		IBusModelClearDepObj obj;
		List<IBusModelClearDepObj> arrayList = readCachedClearDepByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelClearDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearDepByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposeClearDepByClearDepIdx";
		IBusModelClearDepObj obj;
		List<IBusModelClearDepObj> arrayList = readCachedClearDepByClearDepIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelClearDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeClearDepByDefSchemaIdx";
		IBusModelClearDepObj obj;
		List<IBusModelClearDepObj> arrayList = readCachedClearDepByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelClearDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelClearDepObj updateClearDep( IBusModelClearDepObj Obj ) {
		IBusModelClearDepObj obj = Obj;
		schema.getBusModelBackingStore().getTableClearDep().updateClearDep( null,
			Obj.getClearDepRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getClearDepTableObj().getClassCode() ) {
			obj = (IBusModelClearDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteClearDep( IBusModelClearDepObj Obj ) {
		IBusModelClearDepObj obj = Obj;
		schema.getBusModelBackingStore().getTableClearDep().deleteClearDep( null,
			obj.getClearDepRec() );
		Obj.forget();
	}

	@Override
	public void deleteClearDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelClearDepObj obj = readClearDep(Id);
		if( obj != null ) {
			IBusModelClearDepEditObj editObj = (IBusModelClearDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelClearDepEditObj)obj.beginEdit();
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
		deepDisposeClearDepByIdIdx( Id );
	}

	@Override
	public void deleteClearDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableClearDep().deleteClearDepByTenantIdx( null,
				TenantId );
			Iterator<IBusModelClearDepObj> iter = dict.values().iterator();
			IBusModelClearDepObj obj;
			List<IBusModelClearDepObj> toForget = new LinkedList<IBusModelClearDepObj>();
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
			schema.getBusModelBackingStore().getTableClearDep().deleteClearDepByTenantIdx( null,
				TenantId );
		}
		deepDisposeClearDepByTenantIdx( TenantId );
	}

	@Override
	public void deleteClearDepByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelClearDepByClearDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< IBusModelClearDepByClearDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearDepObj > >();
		}
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> dict = indexByClearDepIdx.get( key );
			schema.getBusModelBackingStore().getTableClearDep().deleteClearDepByClearDepIdx( null,
				RelationId );
			Iterator<IBusModelClearDepObj> iter = dict.values().iterator();
			IBusModelClearDepObj obj;
			List<IBusModelClearDepObj> toForget = new LinkedList<IBusModelClearDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByClearDepIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableClearDep().deleteClearDepByClearDepIdx( null,
				RelationId );
		}
		deepDisposeClearDepByClearDepIdx( RelationId );
	}

	@Override
	public void deleteClearDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelClearDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelClearDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearDepObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableClearDep().deleteClearDepByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelClearDepObj> iter = dict.values().iterator();
			IBusModelClearDepObj obj;
			List<IBusModelClearDepObj> toForget = new LinkedList<IBusModelClearDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByDefSchemaIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableClearDep().deleteClearDepByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeClearDepByDefSchemaIdx( DefSchemaId );
	}
}