// Description: Java 25 Table Object implementation for SecClusGrp.

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

public class BusModelSecClusGrpTableObj
	implements IBusModelSecClusGrpTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj> allSecClusGrp;
	private Map< ISecureSecClusGrpByClusterIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > > indexByClusterIdx;
	private Map< ISecureSecClusGrpByNameIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > > indexByNameIdx;
	private Map< ISecureSecClusGrpByUNameIdxKey,
		ISecureSecClusGrpObj > indexByUNameIdx;
	public static String TABLE_NAME = "SecClusGrp";
	public static String TABLE_DBNAME = "secclusgrp";

	public BusModelSecClusGrpTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj>();
		allSecClusGrp = null;
		indexByClusterIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
	}

	public BusModelSecClusGrpTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj>();
		allSecClusGrp = null;
		indexByClusterIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecClusGrpTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecClusGrpTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecClusGrpTableObj.getRuntimeClassCode() );
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
		allSecClusGrp = null;
		indexByClusterIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
		List<ISecureSecClusGrpObj> toForget = new LinkedList<ISecureSecClusGrpObj>();
		ISecureSecClusGrpObj cur = null;
		Iterator<ISecureSecClusGrpObj> iter = members.values().iterator();
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
	 *	BusModelSecClusGrpObj.
	 */
	@Override
	public ISecureSecClusGrpObj newInstance() {
		ISecureSecClusGrpObj inst = new BusModelSecClusGrpObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecClusGrpObj.
	 */
	@Override
	public ISecureSecClusGrpEditObj newEditInstance( ISecureSecClusGrpObj orig ) {
		ISecureSecClusGrpEditObj edit = new BusModelSecClusGrpEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecClusGrpObj constructByClassCode( int backingClassCode ) {
		ISecureSecClusGrpObj obj = null;
		if( backingClassCode == ISecureSecClusGrp.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecClusGrpTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecClusGrpObj realiseSecClusGrp( ISecureSecClusGrpObj Obj ) {
		ISecureSecClusGrpObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecClusGrpObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecClusGrpObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				ISecureSecClusGrpByClusterIdxKey keyClusterIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecClusGrpByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.remove( keepObj.getPKey() );
					if( mapNameIdx.size() <= 0 ) {
						indexByNameIdx.remove( keyNameIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecClusGrpByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				ISecureSecClusGrpByClusterIdxKey keyClusterIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecClusGrpByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecClusGrpByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allSecClusGrp != null ) {
				allSecClusGrp.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecClusGrp != null ) {
				allSecClusGrp.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				ISecureSecClusGrpByClusterIdxKey keyClusterIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecClusGrpByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecClusGrpByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecClusGrpObj createSecClusGrp( ISecureSecClusGrpObj Obj ) {
		ISecureSecClusGrpObj obj = Obj;
		ISecureSecClusGrp rec = obj.getSecClusGrpRec();
		schema.getSecureBackingStore().getTableSecClusGrp().createSecClusGrp(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecClusGrpObj readSecClusGrp( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecClusGrp( pkey, false ) );
	}

	@Override
	public ISecureSecClusGrpObj readSecClusGrp( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecClusGrpObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecClusGrp readRec = schema.getSecureBackingStore().getTableSecClusGrp().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecClusGrpTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecClusGrpObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecClusGrpObj readCachedSecClusGrp( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecClusGrpObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecClusGrp( ISecureSecClusGrpObj obj )
	{
		final String S_ProcName = "BusModelSecClusGrpTableObj.reallyDeepDisposeSecClusGrp() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecClusGrpObj existing = readCachedSecClusGrp( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecClusGrpByClusterIdxKey keyClusterIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		ISecureSecClusGrpByNameIdxKey keyNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		ISecureSecClusGrpByUNameIdxKey keyUNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getSecClusGrpMembTableObj().deepDisposeSecClusGrpMembByClusGrpIdx( existing.getRequiredSecClusGrpId() );

		if( indexByClusterIdx != null ) {
			if( indexByClusterIdx.containsKey( keyClusterIdx ) ) {
				indexByClusterIdx.get( keyClusterIdx ).remove( pkey );
				if( indexByClusterIdx.get( keyClusterIdx ).size() <= 0 ) {
					indexByClusterIdx.remove( keyClusterIdx );
				}
			}
		}

		if( indexByNameIdx != null ) {
			if( indexByNameIdx.containsKey( keyNameIdx ) ) {
				indexByNameIdx.get( keyNameIdx ).remove( pkey );
				if( indexByNameIdx.get( keyNameIdx ).size() <= 0 ) {
					indexByNameIdx.remove( keyNameIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


	}
	@Override
	public void deepDisposeSecClusGrp( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecClusGrpObj obj = readCachedSecClusGrp( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecClusGrpObj lockSecClusGrp( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecClusGrpObj locked = null;
		ISecureSecClusGrp lockRec = schema.getSecureBackingStore().getTableSecClusGrp().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecClusGrpTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecClusGrpObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecClusGrp", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecClusGrpObj> readAllSecClusGrp() {
		return( readAllSecClusGrp( false ) );
	}

	@Override
	public List<ISecureSecClusGrpObj> readAllSecClusGrp( boolean forceRead ) {
		final String S_ProcName = "readAllSecClusGrp";
		if( ( allSecClusGrp == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecClusGrpObj>();
			allSecClusGrp = map;
			ISecureSecClusGrp[] recList = schema.getSecureBackingStore().getTableSecClusGrp().readAllDerived( null );
			ISecureSecClusGrp rec;
			ISecureSecClusGrpObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusGrpObj realised = (ISecureSecClusGrpObj)obj.realise();
			}
		}
		int len = allSecClusGrp.size();
		ISecureSecClusGrpObj arr[] = new ISecureSecClusGrpObj[len];
		Iterator<ISecureSecClusGrpObj> valIter = allSecClusGrp.values().iterator();
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
		ArrayList<ISecureSecClusGrpObj> arrayList = new ArrayList<ISecureSecClusGrpObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusGrpObj> cmp = new Comparator<ISecureSecClusGrpObj>() {
			@Override
			public int compare( ISecureSecClusGrpObj lhs, ISecureSecClusGrpObj rhs ) {
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
		List<ISecureSecClusGrpObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecClusGrpObj> readCachedAllSecClusGrp() {
		final String S_ProcName = "readCachedAllSecClusGrp";
		ArrayList<ISecureSecClusGrpObj> arrayList = new ArrayList<ISecureSecClusGrpObj>();
		if( allSecClusGrp != null ) {
			int len = allSecClusGrp.size();
			ISecureSecClusGrpObj arr[] = new ISecureSecClusGrpObj[len];
			Iterator<ISecureSecClusGrpObj> valIter = allSecClusGrp.values().iterator();
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
		Comparator<ISecureSecClusGrpObj> cmp = new Comparator<ISecureSecClusGrpObj>() {
			public int compare( ISecureSecClusGrpObj lhs, ISecureSecClusGrpObj rhs ) {
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
	public ISecureSecClusGrpObj readSecClusGrpByIdIdx( IYCFKeyHash256 SecClusGrpId )
	{
		return( readSecClusGrpByIdIdx( SecClusGrpId,
			false ) );
	}

	@Override
	public ISecureSecClusGrpObj readSecClusGrpByIdIdx( IYCFKeyHash256 SecClusGrpId, boolean forceRead )
	{
		ISecureSecClusGrpObj obj = readSecClusGrp( SecClusGrpId, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecClusGrpObj> readSecClusGrpByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		return( readSecClusGrpByClusterIdx( ClusterId,
			false ) );
	}

	@Override
	public List<ISecureSecClusGrpObj> readSecClusGrpByClusterIdx( IYCFKeyHash256 ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecClusGrpByClusterIdx";
		ISecureSecClusGrpByClusterIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< ISecureSecClusGrpByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj>();
			ISecureSecClusGrpObj obj;
			ISecureSecClusGrp[] recList = schema.getSecureBackingStore().getTableSecClusGrp().readDerivedByClusterIdx( null,
				ClusterId );
			ISecureSecClusGrp rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecClusGrpTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusGrpObj realised = (ISecureSecClusGrpObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecClusGrpObj arr[] = new ISecureSecClusGrpObj[len];
		Iterator<ISecureSecClusGrpObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecClusGrpObj> arrayList = new ArrayList<ISecureSecClusGrpObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusGrpObj> cmp = new Comparator<ISecureSecClusGrpObj>() {
			@Override
			public int compare( ISecureSecClusGrpObj lhs, ISecureSecClusGrpObj rhs ) {
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
		List<ISecureSecClusGrpObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecClusGrpObj> readSecClusGrpByNameIdx( String Name )
	{
		return( readSecClusGrpByNameIdx( Name,
			false ) );
	}

	@Override
	public List<ISecureSecClusGrpObj> readSecClusGrpByNameIdx( String Name,
		boolean forceRead )
	{
		final String S_ProcName = "readSecClusGrpByNameIdx";
		ISecureSecClusGrpByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByNameIdxKey();
		key.setRequiredName( Name );
		Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj> dict;
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecClusGrpByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > >();
		}
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			dict = indexByNameIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj>();
			ISecureSecClusGrpObj obj;
			ISecureSecClusGrp[] recList = schema.getSecureBackingStore().getTableSecClusGrp().readDerivedByNameIdx( null,
				Name );
			ISecureSecClusGrp rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecClusGrpTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusGrpObj realised = (ISecureSecClusGrpObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNameIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecClusGrpObj arr[] = new ISecureSecClusGrpObj[len];
		Iterator<ISecureSecClusGrpObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecClusGrpObj> arrayList = new ArrayList<ISecureSecClusGrpObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusGrpObj> cmp = new Comparator<ISecureSecClusGrpObj>() {
			@Override
			public int compare( ISecureSecClusGrpObj lhs, ISecureSecClusGrpObj rhs ) {
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
		List<ISecureSecClusGrpObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecClusGrpObj readSecClusGrpByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name )
	{
		return( readSecClusGrpByUNameIdx( ClusterId,
			Name,
			false ) );
	}

	@Override
	public ISecureSecClusGrpObj readSecClusGrpByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecClusGrpByUNameIdxKey,
				ISecureSecClusGrpObj >();
		}
		ISecureSecClusGrpByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ISecureSecClusGrpObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			ISecureSecClusGrp rec = schema.getSecureBackingStore().getTableSecClusGrp().readDerivedByUNameIdx( null,
				ClusterId,
				Name );
			if( rec != null ) {
				obj = schema.getSecClusGrpTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecClusGrpObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecClusGrpObj readCachedSecClusGrpByIdIdx( IYCFKeyHash256 SecClusGrpId )
	{
		ISecureSecClusGrpObj obj = null;
		obj = readCachedSecClusGrp( SecClusGrpId );
		return( obj );
	}

	@Override
	public List<ISecureSecClusGrpObj> readCachedSecClusGrpByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "readCachedSecClusGrpByClusterIdx";
		ISecureSecClusGrpByClusterIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		ArrayList<ISecureSecClusGrpObj> arrayList = new ArrayList<ISecureSecClusGrpObj>();
		if( indexByClusterIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj> dict;
			if( indexByClusterIdx.containsKey( key ) ) {
				dict = indexByClusterIdx.get( key );
				int len = dict.size();
				ISecureSecClusGrpObj arr[] = new ISecureSecClusGrpObj[len];
				Iterator<ISecureSecClusGrpObj> valIter = dict.values().iterator();
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
			ISecureSecClusGrpObj obj;
			Iterator<ISecureSecClusGrpObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecClusGrpObj> cmp = new Comparator<ISecureSecClusGrpObj>() {
			@Override
			public int compare( ISecureSecClusGrpObj lhs, ISecureSecClusGrpObj rhs ) {
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
	public List<ISecureSecClusGrpObj> readCachedSecClusGrpByNameIdx( String Name )
	{
		final String S_ProcName = "readCachedSecClusGrpByNameIdx";
		ISecureSecClusGrpByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByNameIdxKey();
		key.setRequiredName( Name );
		ArrayList<ISecureSecClusGrpObj> arrayList = new ArrayList<ISecureSecClusGrpObj>();
		if( indexByNameIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj> dict;
			if( indexByNameIdx.containsKey( key ) ) {
				dict = indexByNameIdx.get( key );
				int len = dict.size();
				ISecureSecClusGrpObj arr[] = new ISecureSecClusGrpObj[len];
				Iterator<ISecureSecClusGrpObj> valIter = dict.values().iterator();
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
			ISecureSecClusGrpObj obj;
			Iterator<ISecureSecClusGrpObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecClusGrpObj> cmp = new Comparator<ISecureSecClusGrpObj>() {
			@Override
			public int compare( ISecureSecClusGrpObj lhs, ISecureSecClusGrpObj rhs ) {
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
	public ISecureSecClusGrpObj readCachedSecClusGrpByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name )
	{
		ISecureSecClusGrpObj obj = null;
		ISecureSecClusGrpByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<ISecureSecClusGrpObj> valIter = members.values().iterator();
				while( ( obj == null ) && valIter.hasNext() ) {
					obj = valIter.next();
					if( obj != null ) {
						if( obj.getRec().compareTo( key ) != 0 ) {
							obj = null;
						}
					}
				}
			}
		}
		else {
			Iterator<ISecureSecClusGrpObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) != 0 ) {
						obj = null;
					}
				}
			}
		}
		return( obj );
	}

	@Override
	public void deepDisposeSecClusGrpByIdIdx( IYCFKeyHash256 SecClusGrpId )
	{
		ISecureSecClusGrpObj obj = readCachedSecClusGrpByIdIdx( SecClusGrpId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecClusGrpByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "deepDisposeSecClusGrpByClusterIdx";
		ISecureSecClusGrpObj obj;
		List<ISecureSecClusGrpObj> arrayList = readCachedSecClusGrpByClusterIdx( ClusterId );
		if( arrayList != null )  {
			Iterator<ISecureSecClusGrpObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecClusGrpByNameIdx( String Name )
	{
		final String S_ProcName = "deepDisposeSecClusGrpByNameIdx";
		ISecureSecClusGrpObj obj;
		List<ISecureSecClusGrpObj> arrayList = readCachedSecClusGrpByNameIdx( Name );
		if( arrayList != null )  {
			Iterator<ISecureSecClusGrpObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecClusGrpByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name )
	{
		ISecureSecClusGrpObj obj = readCachedSecClusGrpByUNameIdx( ClusterId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecClusGrpObj updateSecClusGrp( ISecureSecClusGrpObj Obj ) {
		ISecureSecClusGrpObj obj = Obj;
		schema.getSecureBackingStore().getTableSecClusGrp().updateSecClusGrp( null,
			Obj.getSecClusGrpRec() );
		obj = (ISecureSecClusGrpObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecClusGrp( ISecureSecClusGrpObj Obj ) {
		ISecureSecClusGrpObj obj = Obj;
		schema.getSecureBackingStore().getTableSecClusGrp().deleteSecClusGrp( null,
			obj.getSecClusGrpRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecClusGrpByIdIdx( IYCFKeyHash256 SecClusGrpId )
	{
		ISecureSecClusGrpObj obj = readSecClusGrp(SecClusGrpId);
		if( obj != null ) {
			ISecureSecClusGrpEditObj editObj = (ISecureSecClusGrpEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecClusGrpEditObj)obj.beginEdit();
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
		deepDisposeSecClusGrpByIdIdx( SecClusGrpId );
	}

	@Override
	public void deleteSecClusGrpByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		ISecureSecClusGrpByClusterIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< ISecureSecClusGrpByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj> dict = indexByClusterIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusGrp().deleteSecClusGrpByClusterIdx( null,
				ClusterId );
			Iterator<ISecureSecClusGrpObj> iter = dict.values().iterator();
			ISecureSecClusGrpObj obj;
			List<ISecureSecClusGrpObj> toForget = new LinkedList<ISecureSecClusGrpObj>();
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
			schema.getSecureBackingStore().getTableSecClusGrp().deleteSecClusGrpByClusterIdx( null,
				ClusterId );
		}
		deepDisposeSecClusGrpByClusterIdx( ClusterId );
	}

	@Override
	public void deleteSecClusGrpByNameIdx( String Name )
	{
		ISecureSecClusGrpByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecClusGrpByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecClusGrpObj > >();
		}
		if( indexByNameIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusGrpObj> dict = indexByNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusGrp().deleteSecClusGrpByNameIdx( null,
				Name );
			Iterator<ISecureSecClusGrpObj> iter = dict.values().iterator();
			ISecureSecClusGrpObj obj;
			List<ISecureSecClusGrpObj> toForget = new LinkedList<ISecureSecClusGrpObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByNameIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecClusGrp().deleteSecClusGrpByNameIdx( null,
				Name );
		}
		deepDisposeSecClusGrpByNameIdx( Name );
	}

	@Override
	public void deleteSecClusGrpByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecClusGrpByUNameIdxKey,
				ISecureSecClusGrpObj >();
		}
		ISecureSecClusGrpByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newByUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ISecureSecClusGrpObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusGrp().deleteSecClusGrpByUNameIdx( null,
				ClusterId,
				Name );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecClusGrp().deleteSecClusGrpByUNameIdx( null,
				ClusterId,
				Name );
		}
		deepDisposeSecClusGrpByUNameIdx( ClusterId,
				Name );
	}
}