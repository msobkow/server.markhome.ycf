// Description: Java 25 Table Object implementation for SysCluster.

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public class BusModelSysClusterTableObj
	implements IBusModelSysClusterTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj> allSysCluster;
	private Map< ISecureSysClusterByClusterIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj > > indexByClusterIdx;
	public static String TABLE_NAME = "SysCluster";
	public static String TABLE_DBNAME = "sysclus";

	public BusModelSysClusterTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSysClusterObj>();
		allSysCluster = null;
		indexByClusterIdx = null;
	}

	public BusModelSysClusterTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSysClusterObj>();
		allSysCluster = null;
		indexByClusterIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSysClusterTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSysClusterTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSysClusterTableObj.getRuntimeClassCode() );
	}

	@Override
	public ISecureSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( ISecureSchemaObj value ) {
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
		allSysCluster = null;
		indexByClusterIdx = null;
		List<ISecureSysClusterObj> toForget = new LinkedList<ISecureSysClusterObj>();
		ISecureSysClusterObj cur = null;
		Iterator<ISecureSysClusterObj> iter = members.values().iterator();
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
	 *	BusModelSysClusterObj.
	 */
	@Override
	public ISecureSysClusterObj newInstance() {
		ISecureSysClusterObj inst = new BusModelSysClusterObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSysClusterObj.
	 */
	@Override
	public ISecureSysClusterEditObj newEditInstance( ISecureSysClusterObj orig ) {
		ISecureSysClusterEditObj edit = new BusModelSysClusterEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSysClusterObj constructByClassCode( int backingClassCode ) {
		ISecureSysClusterObj obj = null;
		if( backingClassCode == ISecureSysCluster.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSysClusterTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSysClusterObj realiseSysCluster( ISecureSysClusterObj Obj ) {
		ISecureSysClusterObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSysClusterObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSysClusterObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				ISecureSysClusterByClusterIdxKey keyClusterIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySysCluster().newByClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				ISecureSysClusterByClusterIdxKey keyClusterIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySysCluster().newByClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSysCluster != null ) {
				allSysCluster.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSysCluster != null ) {
				allSysCluster.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				ISecureSysClusterByClusterIdxKey keyClusterIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySysCluster().newByClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSysClusterObj createSysCluster( ISecureSysClusterObj Obj ) {
		ISecureSysClusterObj obj = Obj;
		ISecureSysCluster rec = obj.getSysClusterRec();
		schema.getSecureBackingStore().getTableSysCluster().createSysCluster(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSysClusterObj readSysCluster( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSysCluster( pkey, false ) );
	}

	@Override
	public ISecureSysClusterObj readSysCluster( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSysClusterObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSysCluster readRec = schema.getSecureBackingStore().getTableSysCluster().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSysClusterTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSysClusterObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSysClusterObj readCachedSysCluster( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSysClusterObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSysCluster( ISecureSysClusterObj obj )
	{
		final String S_ProcName = "BusModelSysClusterTableObj.reallyDeepDisposeSysCluster() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSysClusterObj existing = readCachedSysCluster( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSysClusterByClusterIdxKey keyClusterIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySysCluster().newByClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );



		if( indexByClusterIdx != null ) {
			if( indexByClusterIdx.containsKey( keyClusterIdx ) ) {
				indexByClusterIdx.get( keyClusterIdx ).remove( pkey );
				if( indexByClusterIdx.get( keyClusterIdx ).size() <= 0 ) {
					indexByClusterIdx.remove( keyClusterIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeSysCluster( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSysClusterObj obj = readCachedSysCluster( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSysClusterObj lockSysCluster( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSysClusterObj locked = null;
		ISecureSysCluster lockRec = schema.getSecureBackingStore().getTableSysCluster().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSysClusterTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSysClusterObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSysCluster", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSysClusterObj> readAllSysCluster() {
		return( readAllSysCluster( false ) );
	}

	@Override
	public List<ISecureSysClusterObj> readAllSysCluster( boolean forceRead ) {
		final String S_ProcName = "readAllSysCluster";
		if( ( allSysCluster == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSysClusterObj>();
			allSysCluster = map;
			ISecureSysCluster[] recList = schema.getSecureBackingStore().getTableSysCluster().readAllDerived( null );
			ISecureSysCluster rec;
			ISecureSysClusterObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSysClusterObj realised = (ISecureSysClusterObj)obj.realise();
			}
		}
		int len = allSysCluster.size();
		ISecureSysClusterObj arr[] = new ISecureSysClusterObj[len];
		Iterator<ISecureSysClusterObj> valIter = allSysCluster.values().iterator();
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
		ArrayList<ISecureSysClusterObj> arrayList = new ArrayList<ISecureSysClusterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSysClusterObj> cmp = new Comparator<ISecureSysClusterObj>() {
			@Override
			public int compare( ISecureSysClusterObj lhs, ISecureSysClusterObj rhs ) {
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
		List<ISecureSysClusterObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSysClusterObj> readCachedAllSysCluster() {
		final String S_ProcName = "readCachedAllSysCluster";
		ArrayList<ISecureSysClusterObj> arrayList = new ArrayList<ISecureSysClusterObj>();
		if( allSysCluster != null ) {
			int len = allSysCluster.size();
			ISecureSysClusterObj arr[] = new ISecureSysClusterObj[len];
			Iterator<ISecureSysClusterObj> valIter = allSysCluster.values().iterator();
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
		Comparator<ISecureSysClusterObj> cmp = new Comparator<ISecureSysClusterObj>() {
			public int compare( ISecureSysClusterObj lhs, ISecureSysClusterObj rhs ) {
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
	public ISecureSysClusterObj readSysClusterByIdIdx( int SingletonId )
	{
		return( readSysClusterByIdIdx( SingletonId,
			false ) );
	}

	@Override
	public ISecureSysClusterObj readSysClusterByIdIdx( int SingletonId, boolean forceRead )
	{
		ISecureSysClusterObj obj = readSysCluster( SingletonId, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSysClusterObj> readSysClusterByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		return( readSysClusterByClusterIdx( ClusterId,
			false ) );
	}

	@Override
	public List<ISecureSysClusterObj> readSysClusterByClusterIdx( IYCFKeyHash256 ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSysClusterByClusterIdx";
		ISecureSysClusterByClusterIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySysCluster().newByClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< ISecureSysClusterByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSysClusterObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSysClusterObj>();
			ISecureSysClusterObj obj;
			ISecureSysCluster[] recList = schema.getSecureBackingStore().getTableSysCluster().readDerivedByClusterIdx( null,
				ClusterId );
			ISecureSysCluster rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSysClusterTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSysClusterObj realised = (ISecureSysClusterObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSysClusterObj arr[] = new ISecureSysClusterObj[len];
		Iterator<ISecureSysClusterObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSysClusterObj> arrayList = new ArrayList<ISecureSysClusterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSysClusterObj> cmp = new Comparator<ISecureSysClusterObj>() {
			@Override
			public int compare( ISecureSysClusterObj lhs, ISecureSysClusterObj rhs ) {
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
		List<ISecureSysClusterObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSysClusterObj readCachedSysClusterByIdIdx( int SingletonId )
	{
		ISecureSysClusterObj obj = null;
		obj = readCachedSysCluster( SingletonId );
		return( obj );
	}

	@Override
	public List<ISecureSysClusterObj> readCachedSysClusterByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "readCachedSysClusterByClusterIdx";
		ISecureSysClusterByClusterIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySysCluster().newByClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		ArrayList<ISecureSysClusterObj> arrayList = new ArrayList<ISecureSysClusterObj>();
		if( indexByClusterIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj> dict;
			if( indexByClusterIdx.containsKey( key ) ) {
				dict = indexByClusterIdx.get( key );
				int len = dict.size();
				ISecureSysClusterObj arr[] = new ISecureSysClusterObj[len];
				Iterator<ISecureSysClusterObj> valIter = dict.values().iterator();
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
			ISecureSysClusterObj obj;
			Iterator<ISecureSysClusterObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSysClusterObj> cmp = new Comparator<ISecureSysClusterObj>() {
			@Override
			public int compare( ISecureSysClusterObj lhs, ISecureSysClusterObj rhs ) {
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
	public void deepDisposeSysClusterByIdIdx( int SingletonId )
	{
		ISecureSysClusterObj obj = readCachedSysClusterByIdIdx( SingletonId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSysClusterByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "deepDisposeSysClusterByClusterIdx";
		ISecureSysClusterObj obj;
		List<ISecureSysClusterObj> arrayList = readCachedSysClusterByClusterIdx( ClusterId );
		if( arrayList != null )  {
			Iterator<ISecureSysClusterObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public ISecureSysClusterObj updateSysCluster( ISecureSysClusterObj Obj ) {
		ISecureSysClusterObj obj = Obj;
		schema.getSecureBackingStore().getTableSysCluster().updateSysCluster( null,
			Obj.getSysClusterRec() );
		obj = (ISecureSysClusterObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSysCluster( ISecureSysClusterObj Obj ) {
		ISecureSysClusterObj obj = Obj;
		schema.getSecureBackingStore().getTableSysCluster().deleteSysCluster( null,
			obj.getSysClusterRec() );
		Obj.forget();
	}

	@Override
	public void deleteSysClusterByIdIdx( int SingletonId )
	{
		ISecureSysClusterObj obj = readSysCluster(SingletonId);
		if( obj != null ) {
			ISecureSysClusterEditObj editObj = (ISecureSysClusterEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSysClusterEditObj)obj.beginEdit();
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
		deepDisposeSysClusterByIdIdx( SingletonId );
	}

	@Override
	public void deleteSysClusterByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		ISecureSysClusterByClusterIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySysCluster().newByClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< ISecureSysClusterByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSysClusterObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSysClusterObj> dict = indexByClusterIdx.get( key );
			schema.getSecureBackingStore().getTableSysCluster().deleteSysClusterByClusterIdx( null,
				ClusterId );
			Iterator<ISecureSysClusterObj> iter = dict.values().iterator();
			ISecureSysClusterObj obj;
			List<ISecureSysClusterObj> toForget = new LinkedList<ISecureSysClusterObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByClusterIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSysCluster().deleteSysClusterByClusterIdx( null,
				ClusterId );
		}
		deepDisposeSysClusterByClusterIdx( ClusterId );
	}
}