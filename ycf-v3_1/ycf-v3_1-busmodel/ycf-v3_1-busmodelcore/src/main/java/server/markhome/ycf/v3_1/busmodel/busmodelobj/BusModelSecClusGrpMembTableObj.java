// Description: Java 25 Table Object implementation for SecClusGrpMemb.

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

public class BusModelSecClusGrpMembTableObj
	implements IBusModelSecClusGrpMembTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> members;
	private Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> allSecClusGrpMemb;
	private Map< ISecureSecClusGrpMembByClusGrpIdxKey,
		Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > > indexByClusGrpIdx;
	private Map< ISecureSecClusGrpMembByLoginIdxKey,
		Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > > indexByLoginIdx;
	public static String TABLE_NAME = "SecClusGrpMemb";
	public static String TABLE_DBNAME = "secclusgrpmemb";

	public BusModelSecClusGrpMembTableObj() {
		schema = null;
		members = new HashMap<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj>();
		allSecClusGrpMemb = null;
		indexByClusGrpIdx = null;
		indexByLoginIdx = null;
	}

	public BusModelSecClusGrpMembTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj>();
		allSecClusGrpMemb = null;
		indexByClusGrpIdx = null;
		indexByLoginIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecClusGrpMembTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecClusGrpMembTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecClusGrpMembTableObj.getRuntimeClassCode() );
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
		allSecClusGrpMemb = null;
		indexByClusGrpIdx = null;
		indexByLoginIdx = null;
		List<ISecureSecClusGrpMembObj> toForget = new LinkedList<ISecureSecClusGrpMembObj>();
		ISecureSecClusGrpMembObj cur = null;
		Iterator<ISecureSecClusGrpMembObj> iter = members.values().iterator();
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
	 *	BusModelSecClusGrpMembObj.
	 */
	@Override
	public ISecureSecClusGrpMembObj newInstance() {
		ISecureSecClusGrpMembObj inst = new BusModelSecClusGrpMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecClusGrpMembObj.
	 */
	@Override
	public ISecureSecClusGrpMembEditObj newEditInstance( ISecureSecClusGrpMembObj orig ) {
		ISecureSecClusGrpMembEditObj edit = new BusModelSecClusGrpMembEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecClusGrpMembObj constructByClassCode( int backingClassCode ) {
		ISecureSecClusGrpMembObj obj = null;
		if( backingClassCode == ISecureSecClusGrpMemb.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecClusGrpMembTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecClusGrpMembObj realiseSecClusGrpMemb( ISecureSecClusGrpMembObj Obj ) {
		ISecureSecClusGrpMembObj obj = Obj;
		ISecureSecClusGrpMembPKey pkey = obj.getPKey();
		ISecureSecClusGrpMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecClusGrpMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusGrpIdx != null ) {
				ISecureSecClusGrpMembByClusGrpIdxKey keyClusGrpIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByClusGrpIdxKey();
				keyClusGrpIdx.setRequiredSecClusGrpId( keepObj.getRequiredSecClusGrpId() );
				Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > mapClusGrpIdx = indexByClusGrpIdx.get( keyClusGrpIdx );
				if( mapClusGrpIdx != null ) {
					mapClusGrpIdx.remove( keepObj.getPKey() );
					if( mapClusGrpIdx.size() <= 0 ) {
						indexByClusGrpIdx.remove( keyClusGrpIdx );
					}
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecClusGrpMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.remove( keepObj.getPKey() );
					if( mapLoginIdx.size() <= 0 ) {
						indexByLoginIdx.remove( keyLoginIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusGrpIdx != null ) {
				ISecureSecClusGrpMembByClusGrpIdxKey keyClusGrpIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByClusGrpIdxKey();
				keyClusGrpIdx.setRequiredSecClusGrpId( keepObj.getRequiredSecClusGrpId() );
				Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > mapClusGrpIdx = indexByClusGrpIdx.get( keyClusGrpIdx );
				if( mapClusGrpIdx != null ) {
					mapClusGrpIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecClusGrpMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecClusGrpMemb != null ) {
				allSecClusGrpMemb.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecClusGrpMemb != null ) {
				allSecClusGrpMemb.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusGrpIdx != null ) {
				ISecureSecClusGrpMembByClusGrpIdxKey keyClusGrpIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByClusGrpIdxKey();
				keyClusGrpIdx.setRequiredSecClusGrpId( keepObj.getRequiredSecClusGrpId() );
				Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > mapClusGrpIdx = indexByClusGrpIdx.get( keyClusGrpIdx );
				if( mapClusGrpIdx != null ) {
					mapClusGrpIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecClusGrpMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecClusGrpMembObj createSecClusGrpMemb( ISecureSecClusGrpMembObj Obj ) {
		ISecureSecClusGrpMembObj obj = Obj;
		ISecureSecClusGrpMemb rec = obj.getSecClusGrpMembRec();
		schema.getSecureBackingStore().getTableSecClusGrpMemb().createSecClusGrpMemb(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecClusGrpMembObj readSecClusGrpMemb( ISecureSecClusGrpMembPKey pkey ) {
		return( readSecClusGrpMemb( pkey, false ) );
	}

	@Override
	public ISecureSecClusGrpMembObj readSecClusGrpMemb( ISecureSecClusGrpMembPKey pkey, boolean forceRead ) {
		ISecureSecClusGrpMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecClusGrpMemb readRec = schema.getSecureBackingStore().getTableSecClusGrpMemb().readDerivedByIdIdx( null,
						pkey.getRequiredSecClusGrpId(),
						pkey.getRequiredLoginId() );
			if( readRec != null ) {
				obj = schema.getSecClusGrpMembTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecClusGrpMembObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecClusGrpMembObj readSecClusGrpMemb( IYCFKeyHash256 SecClusGrpId,
		String LoginId ) {
		return( readSecClusGrpMemb( SecClusGrpId,
			LoginId, false ) );
	}

	@Override
	public ISecureSecClusGrpMembObj readSecClusGrpMemb( IYCFKeyHash256 SecClusGrpId,
		String LoginId, boolean forceRead ) {
		ISecureSecClusGrpMembObj obj = null;
		ISecureSecClusGrpMemb readRec = schema.getSecureBackingStore().getTableSecClusGrpMemb().readDerivedByIdIdx( null,
			SecClusGrpId,
			LoginId );
		if( readRec != null ) {
				obj = schema.getSecClusGrpMembTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureSecClusGrpMembObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureSecClusGrpMembObj readCachedSecClusGrpMemb( ISecureSecClusGrpMembPKey pkey ) {
		ISecureSecClusGrpMembObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecClusGrpMemb( ISecureSecClusGrpMembObj obj )
	{
		final String S_ProcName = "BusModelSecClusGrpMembTableObj.reallyDeepDisposeSecClusGrpMemb() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureSecClusGrpMembPKey pkey = obj.getPKey();
		ISecureSecClusGrpMembObj existing = readCachedSecClusGrpMemb( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecClusGrpMembByClusGrpIdxKey keyClusGrpIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByClusGrpIdxKey();
		keyClusGrpIdx.setRequiredSecClusGrpId( existing.getRequiredSecClusGrpId() );

		ISecureSecClusGrpMembByLoginIdxKey keyLoginIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByLoginIdxKey();
		keyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );



		if( indexByClusGrpIdx != null ) {
			if( indexByClusGrpIdx.containsKey( keyClusGrpIdx ) ) {
				indexByClusGrpIdx.get( keyClusGrpIdx ).remove( pkey );
				if( indexByClusGrpIdx.get( keyClusGrpIdx ).size() <= 0 ) {
					indexByClusGrpIdx.remove( keyClusGrpIdx );
				}
			}
		}

		if( indexByLoginIdx != null ) {
			if( indexByLoginIdx.containsKey( keyLoginIdx ) ) {
				indexByLoginIdx.get( keyLoginIdx ).remove( pkey );
				if( indexByLoginIdx.get( keyLoginIdx ).size() <= 0 ) {
					indexByLoginIdx.remove( keyLoginIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeSecClusGrpMemb( ISecureSecClusGrpMembPKey pkey ) {
		ISecureSecClusGrpMembObj obj = readCachedSecClusGrpMemb( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecClusGrpMembObj lockSecClusGrpMemb( ISecureSecClusGrpMembPKey pkey ) {
		ISecureSecClusGrpMembObj locked = null;
		ISecureSecClusGrpMemb lockRec = schema.getSecureBackingStore().getTableSecClusGrpMemb().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecClusGrpMembTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecClusGrpMembObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecClusGrpMemb", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> readAllSecClusGrpMemb() {
		return( readAllSecClusGrpMemb( false ) );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> readAllSecClusGrpMemb( boolean forceRead ) {
		final String S_ProcName = "readAllSecClusGrpMemb";
		if( ( allSecClusGrpMemb == null ) || forceRead ) {
			Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> map = new HashMap<ISecureSecClusGrpMembPKey,ISecureSecClusGrpMembObj>();
			allSecClusGrpMemb = map;
			ISecureSecClusGrpMemb[] recList = schema.getSecureBackingStore().getTableSecClusGrpMemb().readAllDerived( null );
			ISecureSecClusGrpMemb rec;
			ISecureSecClusGrpMembObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusGrpMembObj realised = (ISecureSecClusGrpMembObj)obj.realise();
			}
		}
		int len = allSecClusGrpMemb.size();
		ISecureSecClusGrpMembObj arr[] = new ISecureSecClusGrpMembObj[len];
		Iterator<ISecureSecClusGrpMembObj> valIter = allSecClusGrpMemb.values().iterator();
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
		ArrayList<ISecureSecClusGrpMembObj> arrayList = new ArrayList<ISecureSecClusGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusGrpMembObj> cmp = new Comparator<ISecureSecClusGrpMembObj>() {
			@Override
			public int compare( ISecureSecClusGrpMembObj lhs, ISecureSecClusGrpMembObj rhs ) {
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
					ISecureSecClusGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecClusGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> readCachedAllSecClusGrpMemb() {
		final String S_ProcName = "readCachedAllSecClusGrpMemb";
		ArrayList<ISecureSecClusGrpMembObj> arrayList = new ArrayList<ISecureSecClusGrpMembObj>();
		if( allSecClusGrpMemb != null ) {
			int len = allSecClusGrpMemb.size();
			ISecureSecClusGrpMembObj arr[] = new ISecureSecClusGrpMembObj[len];
			Iterator<ISecureSecClusGrpMembObj> valIter = allSecClusGrpMemb.values().iterator();
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
		Comparator<ISecureSecClusGrpMembObj> cmp = new Comparator<ISecureSecClusGrpMembObj>() {
			public int compare( ISecureSecClusGrpMembObj lhs, ISecureSecClusGrpMembObj rhs ) {
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
					ISecureSecClusGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	/**
	 *	Return a sorted map of a page of the SecClusGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ISecureSecClusGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecClusGrpMembObj> pageAllSecClusGrpMemb(IYCFKeyHash256 priorSecClusGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllSecClusGrpMemb";
		Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> map = new HashMap<ISecureSecClusGrpMembPKey,ISecureSecClusGrpMembObj>();
		ISecureSecClusGrpMemb[] recList = schema.getSecureBackingStore().getTableSecClusGrpMemb().pageAllRec( null,
			priorSecClusGrpId,
			priorLoginId );
		ISecureSecClusGrpMemb rec;
		ISecureSecClusGrpMembObj obj;
		ISecureSecClusGrpMembObj realised;
		ArrayList<ISecureSecClusGrpMembObj> arrayList = new ArrayList<ISecureSecClusGrpMembObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecClusGrpMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecClusGrpMembObj readSecClusGrpMembByIdIdx( IYCFKeyHash256 SecClusGrpId,
		String LoginId )
	{
		return( readSecClusGrpMembByIdIdx( SecClusGrpId,
			LoginId,
			false ) );
	}

	@Override
	public ISecureSecClusGrpMembObj readSecClusGrpMembByIdIdx( IYCFKeyHash256 SecClusGrpId,
		String LoginId, boolean forceRead )
	{
		ISecureSecClusGrpMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newPKey();
		pkey.setRequiredSecClusGrpId( SecClusGrpId );
		pkey.setRequiredLoginId( LoginId );
		ISecureSecClusGrpMembObj obj = readSecClusGrpMemb( pkey, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> readSecClusGrpMembByClusGrpIdx( IYCFKeyHash256 SecClusGrpId )
	{
		return( readSecClusGrpMembByClusGrpIdx( SecClusGrpId,
			false ) );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> readSecClusGrpMembByClusGrpIdx( IYCFKeyHash256 SecClusGrpId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecClusGrpMembByClusGrpIdx";
		ISecureSecClusGrpMembByClusGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByClusGrpIdxKey();
		key.setRequiredSecClusGrpId( SecClusGrpId );
		Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> dict;
		if( indexByClusGrpIdx == null ) {
			indexByClusGrpIdx = new HashMap< ISecureSecClusGrpMembByClusGrpIdxKey,
				Map< ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByClusGrpIdx.containsKey( key ) ) {
			dict = indexByClusGrpIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj>();
			ISecureSecClusGrpMembObj obj;
			ISecureSecClusGrpMemb[] recList = schema.getSecureBackingStore().getTableSecClusGrpMemb().readDerivedByClusGrpIdx( null,
				SecClusGrpId );
			ISecureSecClusGrpMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecClusGrpMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusGrpMembObj realised = (ISecureSecClusGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusGrpIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecClusGrpMembObj arr[] = new ISecureSecClusGrpMembObj[len];
		Iterator<ISecureSecClusGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecClusGrpMembObj> arrayList = new ArrayList<ISecureSecClusGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusGrpMembObj> cmp = new Comparator<ISecureSecClusGrpMembObj>() {
			@Override
			public int compare( ISecureSecClusGrpMembObj lhs, ISecureSecClusGrpMembObj rhs ) {
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
					ISecureSecClusGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecClusGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> readSecClusGrpMembByLoginIdx( String LoginId )
	{
		return( readSecClusGrpMembByLoginIdx( LoginId,
			false ) );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> readSecClusGrpMembByLoginIdx( String LoginId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecClusGrpMembByLoginIdx";
		ISecureSecClusGrpMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> dict;
		if( indexByLoginIdx == null ) {
			indexByLoginIdx = new HashMap< ISecureSecClusGrpMembByLoginIdxKey,
				Map< ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByLoginIdx.containsKey( key ) ) {
			dict = indexByLoginIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj>();
			ISecureSecClusGrpMembObj obj;
			ISecureSecClusGrpMemb[] recList = schema.getSecureBackingStore().getTableSecClusGrpMemb().readDerivedByLoginIdx( null,
				LoginId );
			ISecureSecClusGrpMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecClusGrpMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusGrpMembObj realised = (ISecureSecClusGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLoginIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecClusGrpMembObj arr[] = new ISecureSecClusGrpMembObj[len];
		Iterator<ISecureSecClusGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecClusGrpMembObj> arrayList = new ArrayList<ISecureSecClusGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusGrpMembObj> cmp = new Comparator<ISecureSecClusGrpMembObj>() {
			@Override
			public int compare( ISecureSecClusGrpMembObj lhs, ISecureSecClusGrpMembObj rhs ) {
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
					ISecureSecClusGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecClusGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecClusGrpMembObj readCachedSecClusGrpMembByIdIdx( IYCFKeyHash256 SecClusGrpId,
		String LoginId )
	{
		ISecureSecClusGrpMembObj obj = null;
		ISecureSecClusGrpMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newPKey();
		pkey.setRequiredSecClusGrpId( SecClusGrpId );
		pkey.setRequiredLoginId( LoginId );
		pkey.setRequiredSecClusGrpId( SecClusGrpId );
		pkey.setRequiredLoginId( LoginId );
		obj = readCachedSecClusGrpMemb( pkey );
		return( obj );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> readCachedSecClusGrpMembByClusGrpIdx( IYCFKeyHash256 SecClusGrpId )
	{
		final String S_ProcName = "readCachedSecClusGrpMembByClusGrpIdx";
		ISecureSecClusGrpMembByClusGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByClusGrpIdxKey();
		key.setRequiredSecClusGrpId( SecClusGrpId );
		ArrayList<ISecureSecClusGrpMembObj> arrayList = new ArrayList<ISecureSecClusGrpMembObj>();
		if( indexByClusGrpIdx != null ) {
			Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> dict;
			if( indexByClusGrpIdx.containsKey( key ) ) {
				dict = indexByClusGrpIdx.get( key );
				int len = dict.size();
				ISecureSecClusGrpMembObj arr[] = new ISecureSecClusGrpMembObj[len];
				Iterator<ISecureSecClusGrpMembObj> valIter = dict.values().iterator();
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
			ISecureSecClusGrpMembObj obj;
			Iterator<ISecureSecClusGrpMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecClusGrpMembObj> cmp = new Comparator<ISecureSecClusGrpMembObj>() {
			@Override
			public int compare( ISecureSecClusGrpMembObj lhs, ISecureSecClusGrpMembObj rhs ) {
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
					ISecureSecClusGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> readCachedSecClusGrpMembByLoginIdx( String LoginId )
	{
		final String S_ProcName = "readCachedSecClusGrpMembByLoginIdx";
		ISecureSecClusGrpMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ArrayList<ISecureSecClusGrpMembObj> arrayList = new ArrayList<ISecureSecClusGrpMembObj>();
		if( indexByLoginIdx != null ) {
			Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> dict;
			if( indexByLoginIdx.containsKey( key ) ) {
				dict = indexByLoginIdx.get( key );
				int len = dict.size();
				ISecureSecClusGrpMembObj arr[] = new ISecureSecClusGrpMembObj[len];
				Iterator<ISecureSecClusGrpMembObj> valIter = dict.values().iterator();
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
			ISecureSecClusGrpMembObj obj;
			Iterator<ISecureSecClusGrpMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecClusGrpMembObj> cmp = new Comparator<ISecureSecClusGrpMembObj>() {
			@Override
			public int compare( ISecureSecClusGrpMembObj lhs, ISecureSecClusGrpMembObj rhs ) {
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
					ISecureSecClusGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeSecClusGrpMembByIdIdx( IYCFKeyHash256 SecClusGrpId,
		String LoginId )
	{
		ISecureSecClusGrpMembObj obj = readCachedSecClusGrpMembByIdIdx( SecClusGrpId,
				LoginId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecClusGrpMembByClusGrpIdx( IYCFKeyHash256 SecClusGrpId )
	{
		final String S_ProcName = "deepDisposeSecClusGrpMembByClusGrpIdx";
		ISecureSecClusGrpMembObj obj;
		List<ISecureSecClusGrpMembObj> arrayList = readCachedSecClusGrpMembByClusGrpIdx( SecClusGrpId );
		if( arrayList != null )  {
			Iterator<ISecureSecClusGrpMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecClusGrpMembByLoginIdx( String LoginId )
	{
		final String S_ProcName = "deepDisposeSecClusGrpMembByLoginIdx";
		ISecureSecClusGrpMembObj obj;
		List<ISecureSecClusGrpMembObj> arrayList = readCachedSecClusGrpMembByLoginIdx( LoginId );
		if( arrayList != null )  {
			Iterator<ISecureSecClusGrpMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecClusGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusGrpIdx key attributes.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecClusGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecClusGrpMembObj> pageSecClusGrpMembByClusGrpIdx( IYCFKeyHash256 SecClusGrpId,
		IYCFKeyHash256 priorSecClusGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecClusGrpMembByClusGrpIdx";
		ISecureSecClusGrpMembByClusGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByClusGrpIdxKey();
		key.setRequiredSecClusGrpId( SecClusGrpId );
		List<ISecureSecClusGrpMembObj> retList = new LinkedList<ISecureSecClusGrpMembObj>();
		ISecureSecClusGrpMembObj obj;
		ISecureSecClusGrpMemb[] recList = schema.getSecureBackingStore().getTableSecClusGrpMemb().pageRecByClusGrpIdx( null,
				SecClusGrpId,
			priorSecClusGrpId,
			priorLoginId );
		ISecureSecClusGrpMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecClusGrpMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecClusGrpMembObj realised = (ISecureSecClusGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecClusGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate LoginIdx key attributes.
	 *
	 *	@param	LoginId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecClusGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecClusGrpMembObj> pageSecClusGrpMembByLoginIdx( String LoginId,
		IYCFKeyHash256 priorSecClusGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecClusGrpMembByLoginIdx";
		ISecureSecClusGrpMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		List<ISecureSecClusGrpMembObj> retList = new LinkedList<ISecureSecClusGrpMembObj>();
		ISecureSecClusGrpMembObj obj;
		ISecureSecClusGrpMemb[] recList = schema.getSecureBackingStore().getTableSecClusGrpMemb().pageRecByLoginIdx( null,
				LoginId,
			priorSecClusGrpId,
			priorLoginId );
		ISecureSecClusGrpMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecClusGrpMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecClusGrpMembObj realised = (ISecureSecClusGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecClusGrpMembObj updateSecClusGrpMemb( ISecureSecClusGrpMembObj Obj ) {
		ISecureSecClusGrpMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecClusGrpMemb().updateSecClusGrpMemb( null,
			Obj.getSecClusGrpMembRec() );
		obj = (ISecureSecClusGrpMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecClusGrpMemb( ISecureSecClusGrpMembObj Obj ) {
		ISecureSecClusGrpMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecClusGrpMemb().deleteSecClusGrpMemb( null,
			obj.getSecClusGrpMembRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecClusGrpMembByIdIdx( IYCFKeyHash256 SecClusGrpId,
		String LoginId )
	{
		ISecureSecClusGrpMembObj obj = readSecClusGrpMemb(SecClusGrpId,
				LoginId);
		if( obj != null ) {
			ISecureSecClusGrpMembEditObj editObj = (ISecureSecClusGrpMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecClusGrpMembEditObj)obj.beginEdit();
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
		deepDisposeSecClusGrpMembByIdIdx( SecClusGrpId,
				LoginId );
	}

	@Override
	public void deleteSecClusGrpMembByClusGrpIdx( IYCFKeyHash256 SecClusGrpId )
	{
		ISecureSecClusGrpMembByClusGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByClusGrpIdxKey();
		key.setRequiredSecClusGrpId( SecClusGrpId );
		if( indexByClusGrpIdx == null ) {
			indexByClusGrpIdx = new HashMap< ISecureSecClusGrpMembByClusGrpIdxKey,
				Map< ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > >();
		}
		if( indexByClusGrpIdx.containsKey( key ) ) {
			Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> dict = indexByClusGrpIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusGrpMemb().deleteSecClusGrpMembByClusGrpIdx( null,
				SecClusGrpId );
			Iterator<ISecureSecClusGrpMembObj> iter = dict.values().iterator();
			ISecureSecClusGrpMembObj obj;
			List<ISecureSecClusGrpMembObj> toForget = new LinkedList<ISecureSecClusGrpMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByClusGrpIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecClusGrpMemb().deleteSecClusGrpMembByClusGrpIdx( null,
				SecClusGrpId );
		}
		deepDisposeSecClusGrpMembByClusGrpIdx( SecClusGrpId );
	}

	@Override
	public void deleteSecClusGrpMembByLoginIdx( String LoginId )
	{
		ISecureSecClusGrpMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		if( indexByLoginIdx == null ) {
			indexByLoginIdx = new HashMap< ISecureSecClusGrpMembByLoginIdxKey,
				Map< ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj > >();
		}
		if( indexByLoginIdx.containsKey( key ) ) {
			Map<ISecureSecClusGrpMembPKey, ISecureSecClusGrpMembObj> dict = indexByLoginIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusGrpMemb().deleteSecClusGrpMembByLoginIdx( null,
				LoginId );
			Iterator<ISecureSecClusGrpMembObj> iter = dict.values().iterator();
			ISecureSecClusGrpMembObj obj;
			List<ISecureSecClusGrpMembObj> toForget = new LinkedList<ISecureSecClusGrpMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByLoginIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecClusGrpMemb().deleteSecClusGrpMembByLoginIdx( null,
				LoginId );
		}
		deepDisposeSecClusGrpMembByLoginIdx( LoginId );
	}
}