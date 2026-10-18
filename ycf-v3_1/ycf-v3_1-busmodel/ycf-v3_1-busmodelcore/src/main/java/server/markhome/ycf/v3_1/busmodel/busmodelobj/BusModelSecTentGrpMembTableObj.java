// Description: Java 25 Table Object implementation for SecTentGrpMemb.

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

public class BusModelSecTentGrpMembTableObj
	implements IBusModelSecTentGrpMembTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> members;
	private Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> allSecTentGrpMemb;
	private Map< ISecureSecTentGrpMembByTentGrpIdxKey,
		Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > > indexByTentGrpIdx;
	private Map< ISecureSecTentGrpMembByUserIdxKey,
		Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > > indexByUserIdx;
	public static String TABLE_NAME = "SecTentGrpMemb";
	public static String TABLE_DBNAME = "sectentgrpmemb";

	public BusModelSecTentGrpMembTableObj() {
		schema = null;
		members = new HashMap<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj>();
		allSecTentGrpMemb = null;
		indexByTentGrpIdx = null;
		indexByUserIdx = null;
	}

	public BusModelSecTentGrpMembTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj>();
		allSecTentGrpMemb = null;
		indexByTentGrpIdx = null;
		indexByUserIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecTentGrpMembTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecTentGrpMembTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecTentGrpMembTableObj.getRuntimeClassCode() );
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
		allSecTentGrpMemb = null;
		indexByTentGrpIdx = null;
		indexByUserIdx = null;
		List<ISecureSecTentGrpMembObj> toForget = new LinkedList<ISecureSecTentGrpMembObj>();
		ISecureSecTentGrpMembObj cur = null;
		Iterator<ISecureSecTentGrpMembObj> iter = members.values().iterator();
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
	 *	BusModelSecTentGrpMembObj.
	 */
	@Override
	public ISecureSecTentGrpMembObj newInstance() {
		ISecureSecTentGrpMembObj inst = new BusModelSecTentGrpMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecTentGrpMembObj.
	 */
	@Override
	public ISecureSecTentGrpMembEditObj newEditInstance( ISecureSecTentGrpMembObj orig ) {
		ISecureSecTentGrpMembEditObj edit = new BusModelSecTentGrpMembEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecTentGrpMembObj constructByClassCode( int backingClassCode ) {
		ISecureSecTentGrpMembObj obj = null;
		if( backingClassCode == ISecureSecTentGrpMemb.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecTentGrpMembTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecTentGrpMembObj realiseSecTentGrpMemb( ISecureSecTentGrpMembObj Obj ) {
		ISecureSecTentGrpMembObj obj = Obj;
		ISecureSecTentGrpMembPKey pkey = obj.getPKey();
		ISecureSecTentGrpMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecTentGrpMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTentGrpIdx != null ) {
				ISecureSecTentGrpMembByTentGrpIdxKey keyTentGrpIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
				keyTentGrpIdx.setRequiredSecTentGrpId( keepObj.getRequiredSecTentGrpId() );
				Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > mapTentGrpIdx = indexByTentGrpIdx.get( keyTentGrpIdx );
				if( mapTentGrpIdx != null ) {
					mapTentGrpIdx.remove( keepObj.getPKey() );
					if( mapTentGrpIdx.size() <= 0 ) {
						indexByTentGrpIdx.remove( keyTentGrpIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				ISecureSecTentGrpMembByUserIdxKey keyUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
				keyUserIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTentGrpIdx != null ) {
				ISecureSecTentGrpMembByTentGrpIdxKey keyTentGrpIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
				keyTentGrpIdx.setRequiredSecTentGrpId( keepObj.getRequiredSecTentGrpId() );
				Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > mapTentGrpIdx = indexByTentGrpIdx.get( keyTentGrpIdx );
				if( mapTentGrpIdx != null ) {
					mapTentGrpIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				ISecureSecTentGrpMembByUserIdxKey keyUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
				keyUserIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecTentGrpMemb != null ) {
				allSecTentGrpMemb.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecTentGrpMemb != null ) {
				allSecTentGrpMemb.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTentGrpIdx != null ) {
				ISecureSecTentGrpMembByTentGrpIdxKey keyTentGrpIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
				keyTentGrpIdx.setRequiredSecTentGrpId( keepObj.getRequiredSecTentGrpId() );
				Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > mapTentGrpIdx = indexByTentGrpIdx.get( keyTentGrpIdx );
				if( mapTentGrpIdx != null ) {
					mapTentGrpIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				ISecureSecTentGrpMembByUserIdxKey keyUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
				keyUserIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecTentGrpMembObj createSecTentGrpMemb( ISecureSecTentGrpMembObj Obj ) {
		ISecureSecTentGrpMembObj obj = Obj;
		ISecureSecTentGrpMemb rec = obj.getSecTentGrpMembRec();
		schema.getSecureBackingStore().getTableSecTentGrpMemb().createSecTentGrpMemb(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecTentGrpMembObj readSecTentGrpMemb( ISecureSecTentGrpMembPKey pkey ) {
		return( readSecTentGrpMemb( pkey, false ) );
	}

	@Override
	public ISecureSecTentGrpMembObj readSecTentGrpMemb( ISecureSecTentGrpMembPKey pkey, boolean forceRead ) {
		ISecureSecTentGrpMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecTentGrpMemb readRec = schema.getSecureBackingStore().getTableSecTentGrpMemb().readDerivedByIdIdx( null,
						pkey.getRequiredSecTentGrpId(),
						pkey.getRequiredLoginId() );
			if( readRec != null ) {
				obj = schema.getSecTentGrpMembTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecTentGrpMembObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecTentGrpMembObj readSecTentGrpMemb( IYCFKeyHash256 SecTentGrpId,
		String LoginId ) {
		return( readSecTentGrpMemb( SecTentGrpId,
			LoginId, false ) );
	}

	@Override
	public ISecureSecTentGrpMembObj readSecTentGrpMemb( IYCFKeyHash256 SecTentGrpId,
		String LoginId, boolean forceRead ) {
		ISecureSecTentGrpMembObj obj = null;
		ISecureSecTentGrpMemb readRec = schema.getSecureBackingStore().getTableSecTentGrpMemb().readDerivedByIdIdx( null,
			SecTentGrpId,
			LoginId );
		if( readRec != null ) {
				obj = schema.getSecTentGrpMembTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureSecTentGrpMembObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureSecTentGrpMembObj readCachedSecTentGrpMemb( ISecureSecTentGrpMembPKey pkey ) {
		ISecureSecTentGrpMembObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecTentGrpMemb( ISecureSecTentGrpMembObj obj )
	{
		final String S_ProcName = "BusModelSecTentGrpMembTableObj.reallyDeepDisposeSecTentGrpMemb() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureSecTentGrpMembPKey pkey = obj.getPKey();
		ISecureSecTentGrpMembObj existing = readCachedSecTentGrpMemb( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecTentGrpMembByTentGrpIdxKey keyTentGrpIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		keyTentGrpIdx.setRequiredSecTentGrpId( existing.getRequiredSecTentGrpId() );

		ISecureSecTentGrpMembByUserIdxKey keyUserIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		keyUserIdx.setRequiredLoginId( existing.getRequiredLoginId() );



		if( indexByTentGrpIdx != null ) {
			if( indexByTentGrpIdx.containsKey( keyTentGrpIdx ) ) {
				indexByTentGrpIdx.get( keyTentGrpIdx ).remove( pkey );
				if( indexByTentGrpIdx.get( keyTentGrpIdx ).size() <= 0 ) {
					indexByTentGrpIdx.remove( keyTentGrpIdx );
				}
			}
		}

		if( indexByUserIdx != null ) {
			if( indexByUserIdx.containsKey( keyUserIdx ) ) {
				indexByUserIdx.get( keyUserIdx ).remove( pkey );
				if( indexByUserIdx.get( keyUserIdx ).size() <= 0 ) {
					indexByUserIdx.remove( keyUserIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeSecTentGrpMemb( ISecureSecTentGrpMembPKey pkey ) {
		ISecureSecTentGrpMembObj obj = readCachedSecTentGrpMemb( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecTentGrpMembObj lockSecTentGrpMemb( ISecureSecTentGrpMembPKey pkey ) {
		ISecureSecTentGrpMembObj locked = null;
		ISecureSecTentGrpMemb lockRec = schema.getSecureBackingStore().getTableSecTentGrpMemb().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecTentGrpMembTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecTentGrpMembObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecTentGrpMemb", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> readAllSecTentGrpMemb() {
		return( readAllSecTentGrpMemb( false ) );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> readAllSecTentGrpMemb( boolean forceRead ) {
		final String S_ProcName = "readAllSecTentGrpMemb";
		if( ( allSecTentGrpMemb == null ) || forceRead ) {
			Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> map = new HashMap<ISecureSecTentGrpMembPKey,ISecureSecTentGrpMembObj>();
			allSecTentGrpMemb = map;
			ISecureSecTentGrpMemb[] recList = schema.getSecureBackingStore().getTableSecTentGrpMemb().readAllDerived( null );
			ISecureSecTentGrpMemb rec;
			ISecureSecTentGrpMembObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentGrpMembObj realised = (ISecureSecTentGrpMembObj)obj.realise();
			}
		}
		int len = allSecTentGrpMemb.size();
		ISecureSecTentGrpMembObj arr[] = new ISecureSecTentGrpMembObj[len];
		Iterator<ISecureSecTentGrpMembObj> valIter = allSecTentGrpMemb.values().iterator();
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
		ArrayList<ISecureSecTentGrpMembObj> arrayList = new ArrayList<ISecureSecTentGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentGrpMembObj> cmp = new Comparator<ISecureSecTentGrpMembObj>() {
			@Override
			public int compare( ISecureSecTentGrpMembObj lhs, ISecureSecTentGrpMembObj rhs ) {
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
					ISecureSecTentGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecTentGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> readCachedAllSecTentGrpMemb() {
		final String S_ProcName = "readCachedAllSecTentGrpMemb";
		ArrayList<ISecureSecTentGrpMembObj> arrayList = new ArrayList<ISecureSecTentGrpMembObj>();
		if( allSecTentGrpMemb != null ) {
			int len = allSecTentGrpMemb.size();
			ISecureSecTentGrpMembObj arr[] = new ISecureSecTentGrpMembObj[len];
			Iterator<ISecureSecTentGrpMembObj> valIter = allSecTentGrpMemb.values().iterator();
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
		Comparator<ISecureSecTentGrpMembObj> cmp = new Comparator<ISecureSecTentGrpMembObj>() {
			public int compare( ISecureSecTentGrpMembObj lhs, ISecureSecTentGrpMembObj rhs ) {
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
					ISecureSecTentGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	/**
	 *	Return a sorted map of a page of the SecTentGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ISecureSecTentGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecTentGrpMembObj> pageAllSecTentGrpMemb(IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllSecTentGrpMemb";
		Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> map = new HashMap<ISecureSecTentGrpMembPKey,ISecureSecTentGrpMembObj>();
		ISecureSecTentGrpMemb[] recList = schema.getSecureBackingStore().getTableSecTentGrpMemb().pageAllRec( null,
			priorSecTentGrpId,
			priorLoginId );
		ISecureSecTentGrpMemb rec;
		ISecureSecTentGrpMembObj obj;
		ISecureSecTentGrpMembObj realised;
		ArrayList<ISecureSecTentGrpMembObj> arrayList = new ArrayList<ISecureSecTentGrpMembObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecTentGrpMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecTentGrpMembObj readSecTentGrpMembByIdIdx( IYCFKeyHash256 SecTentGrpId,
		String LoginId )
	{
		return( readSecTentGrpMembByIdIdx( SecTentGrpId,
			LoginId,
			false ) );
	}

	@Override
	public ISecureSecTentGrpMembObj readSecTentGrpMembByIdIdx( IYCFKeyHash256 SecTentGrpId,
		String LoginId, boolean forceRead )
	{
		ISecureSecTentGrpMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newPKey();
		pkey.setRequiredSecTentGrpId( SecTentGrpId );
		pkey.setRequiredLoginId( LoginId );
		ISecureSecTentGrpMembObj obj = readSecTentGrpMemb( pkey, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> readSecTentGrpMembByTentGrpIdx( IYCFKeyHash256 SecTentGrpId )
	{
		return( readSecTentGrpMembByTentGrpIdx( SecTentGrpId,
			false ) );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> readSecTentGrpMembByTentGrpIdx( IYCFKeyHash256 SecTentGrpId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecTentGrpMembByTentGrpIdx";
		ISecureSecTentGrpMembByTentGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		key.setRequiredSecTentGrpId( SecTentGrpId );
		Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> dict;
		if( indexByTentGrpIdx == null ) {
			indexByTentGrpIdx = new HashMap< ISecureSecTentGrpMembByTentGrpIdxKey,
				Map< ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByTentGrpIdx.containsKey( key ) ) {
			dict = indexByTentGrpIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj>();
			ISecureSecTentGrpMembObj obj;
			ISecureSecTentGrpMemb[] recList = schema.getSecureBackingStore().getTableSecTentGrpMemb().readDerivedByTentGrpIdx( null,
				SecTentGrpId );
			ISecureSecTentGrpMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecTentGrpMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentGrpMembObj realised = (ISecureSecTentGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTentGrpIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecTentGrpMembObj arr[] = new ISecureSecTentGrpMembObj[len];
		Iterator<ISecureSecTentGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecTentGrpMembObj> arrayList = new ArrayList<ISecureSecTentGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentGrpMembObj> cmp = new Comparator<ISecureSecTentGrpMembObj>() {
			@Override
			public int compare( ISecureSecTentGrpMembObj lhs, ISecureSecTentGrpMembObj rhs ) {
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
					ISecureSecTentGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecTentGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> readSecTentGrpMembByUserIdx( String LoginId )
	{
		return( readSecTentGrpMembByUserIdx( LoginId,
			false ) );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> readSecTentGrpMembByUserIdx( String LoginId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecTentGrpMembByUserIdx";
		ISecureSecTentGrpMembByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		key.setRequiredLoginId( LoginId );
		Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< ISecureSecTentGrpMembByUserIdxKey,
				Map< ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj>();
			ISecureSecTentGrpMembObj obj;
			ISecureSecTentGrpMemb[] recList = schema.getSecureBackingStore().getTableSecTentGrpMemb().readDerivedByUserIdx( null,
				LoginId );
			ISecureSecTentGrpMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecTentGrpMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentGrpMembObj realised = (ISecureSecTentGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByUserIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecTentGrpMembObj arr[] = new ISecureSecTentGrpMembObj[len];
		Iterator<ISecureSecTentGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecTentGrpMembObj> arrayList = new ArrayList<ISecureSecTentGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentGrpMembObj> cmp = new Comparator<ISecureSecTentGrpMembObj>() {
			@Override
			public int compare( ISecureSecTentGrpMembObj lhs, ISecureSecTentGrpMembObj rhs ) {
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
					ISecureSecTentGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecTentGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecTentGrpMembObj readCachedSecTentGrpMembByIdIdx( IYCFKeyHash256 SecTentGrpId,
		String LoginId )
	{
		ISecureSecTentGrpMembObj obj = null;
		ISecureSecTentGrpMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newPKey();
		pkey.setRequiredSecTentGrpId( SecTentGrpId );
		pkey.setRequiredLoginId( LoginId );
		pkey.setRequiredSecTentGrpId( SecTentGrpId );
		pkey.setRequiredLoginId( LoginId );
		obj = readCachedSecTentGrpMemb( pkey );
		return( obj );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> readCachedSecTentGrpMembByTentGrpIdx( IYCFKeyHash256 SecTentGrpId )
	{
		final String S_ProcName = "readCachedSecTentGrpMembByTentGrpIdx";
		ISecureSecTentGrpMembByTentGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		key.setRequiredSecTentGrpId( SecTentGrpId );
		ArrayList<ISecureSecTentGrpMembObj> arrayList = new ArrayList<ISecureSecTentGrpMembObj>();
		if( indexByTentGrpIdx != null ) {
			Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> dict;
			if( indexByTentGrpIdx.containsKey( key ) ) {
				dict = indexByTentGrpIdx.get( key );
				int len = dict.size();
				ISecureSecTentGrpMembObj arr[] = new ISecureSecTentGrpMembObj[len];
				Iterator<ISecureSecTentGrpMembObj> valIter = dict.values().iterator();
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
			ISecureSecTentGrpMembObj obj;
			Iterator<ISecureSecTentGrpMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecTentGrpMembObj> cmp = new Comparator<ISecureSecTentGrpMembObj>() {
			@Override
			public int compare( ISecureSecTentGrpMembObj lhs, ISecureSecTentGrpMembObj rhs ) {
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
					ISecureSecTentGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> readCachedSecTentGrpMembByUserIdx( String LoginId )
	{
		final String S_ProcName = "readCachedSecTentGrpMembByUserIdx";
		ISecureSecTentGrpMembByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		key.setRequiredLoginId( LoginId );
		ArrayList<ISecureSecTentGrpMembObj> arrayList = new ArrayList<ISecureSecTentGrpMembObj>();
		if( indexByUserIdx != null ) {
			Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> dict;
			if( indexByUserIdx.containsKey( key ) ) {
				dict = indexByUserIdx.get( key );
				int len = dict.size();
				ISecureSecTentGrpMembObj arr[] = new ISecureSecTentGrpMembObj[len];
				Iterator<ISecureSecTentGrpMembObj> valIter = dict.values().iterator();
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
			ISecureSecTentGrpMembObj obj;
			Iterator<ISecureSecTentGrpMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecTentGrpMembObj> cmp = new Comparator<ISecureSecTentGrpMembObj>() {
			@Override
			public int compare( ISecureSecTentGrpMembObj lhs, ISecureSecTentGrpMembObj rhs ) {
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
					ISecureSecTentGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeSecTentGrpMembByIdIdx( IYCFKeyHash256 SecTentGrpId,
		String LoginId )
	{
		ISecureSecTentGrpMembObj obj = readCachedSecTentGrpMembByIdIdx( SecTentGrpId,
				LoginId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecTentGrpMembByTentGrpIdx( IYCFKeyHash256 SecTentGrpId )
	{
		final String S_ProcName = "deepDisposeSecTentGrpMembByTentGrpIdx";
		ISecureSecTentGrpMembObj obj;
		List<ISecureSecTentGrpMembObj> arrayList = readCachedSecTentGrpMembByTentGrpIdx( SecTentGrpId );
		if( arrayList != null )  {
			Iterator<ISecureSecTentGrpMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecTentGrpMembByUserIdx( String LoginId )
	{
		final String S_ProcName = "deepDisposeSecTentGrpMembByUserIdx";
		ISecureSecTentGrpMembObj obj;
		List<ISecureSecTentGrpMembObj> arrayList = readCachedSecTentGrpMembByUserIdx( LoginId );
		if( arrayList != null )  {
			Iterator<ISecureSecTentGrpMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecTentGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate TentGrpIdx key attributes.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecTentGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecTentGrpMembObj> pageSecTentGrpMembByTentGrpIdx( IYCFKeyHash256 SecTentGrpId,
		IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecTentGrpMembByTentGrpIdx";
		ISecureSecTentGrpMembByTentGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		key.setRequiredSecTentGrpId( SecTentGrpId );
		List<ISecureSecTentGrpMembObj> retList = new LinkedList<ISecureSecTentGrpMembObj>();
		ISecureSecTentGrpMembObj obj;
		ISecureSecTentGrpMemb[] recList = schema.getSecureBackingStore().getTableSecTentGrpMemb().pageRecByTentGrpIdx( null,
				SecTentGrpId,
			priorSecTentGrpId,
			priorLoginId );
		ISecureSecTentGrpMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecTentGrpMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecTentGrpMembObj realised = (ISecureSecTentGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecTentGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	LoginId	The SecTentGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecTentGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecTentGrpMembObj> pageSecTentGrpMembByUserIdx( String LoginId,
		IYCFKeyHash256 priorSecTentGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecTentGrpMembByUserIdx";
		ISecureSecTentGrpMembByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		key.setRequiredLoginId( LoginId );
		List<ISecureSecTentGrpMembObj> retList = new LinkedList<ISecureSecTentGrpMembObj>();
		ISecureSecTentGrpMembObj obj;
		ISecureSecTentGrpMemb[] recList = schema.getSecureBackingStore().getTableSecTentGrpMemb().pageRecByUserIdx( null,
				LoginId,
			priorSecTentGrpId,
			priorLoginId );
		ISecureSecTentGrpMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecTentGrpMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecTentGrpMembObj realised = (ISecureSecTentGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecTentGrpMembObj updateSecTentGrpMemb( ISecureSecTentGrpMembObj Obj ) {
		ISecureSecTentGrpMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecTentGrpMemb().updateSecTentGrpMemb( null,
			Obj.getSecTentGrpMembRec() );
		obj = (ISecureSecTentGrpMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecTentGrpMemb( ISecureSecTentGrpMembObj Obj ) {
		ISecureSecTentGrpMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecTentGrpMemb().deleteSecTentGrpMemb( null,
			obj.getSecTentGrpMembRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecTentGrpMembByIdIdx( IYCFKeyHash256 SecTentGrpId,
		String LoginId )
	{
		ISecureSecTentGrpMembObj obj = readSecTentGrpMemb(SecTentGrpId,
				LoginId);
		if( obj != null ) {
			ISecureSecTentGrpMembEditObj editObj = (ISecureSecTentGrpMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecTentGrpMembEditObj)obj.beginEdit();
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
		deepDisposeSecTentGrpMembByIdIdx( SecTentGrpId,
				LoginId );
	}

	@Override
	public void deleteSecTentGrpMembByTentGrpIdx( IYCFKeyHash256 SecTentGrpId )
	{
		ISecureSecTentGrpMembByTentGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByTentGrpIdxKey();
		key.setRequiredSecTentGrpId( SecTentGrpId );
		if( indexByTentGrpIdx == null ) {
			indexByTentGrpIdx = new HashMap< ISecureSecTentGrpMembByTentGrpIdxKey,
				Map< ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > >();
		}
		if( indexByTentGrpIdx.containsKey( key ) ) {
			Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> dict = indexByTentGrpIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentGrpMemb().deleteSecTentGrpMembByTentGrpIdx( null,
				SecTentGrpId );
			Iterator<ISecureSecTentGrpMembObj> iter = dict.values().iterator();
			ISecureSecTentGrpMembObj obj;
			List<ISecureSecTentGrpMembObj> toForget = new LinkedList<ISecureSecTentGrpMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByTentGrpIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecTentGrpMemb().deleteSecTentGrpMembByTentGrpIdx( null,
				SecTentGrpId );
		}
		deepDisposeSecTentGrpMembByTentGrpIdx( SecTentGrpId );
	}

	@Override
	public void deleteSecTentGrpMembByUserIdx( String LoginId )
	{
		ISecureSecTentGrpMembByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrpMemb().newByUserIdxKey();
		key.setRequiredLoginId( LoginId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< ISecureSecTentGrpMembByUserIdxKey,
				Map< ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<ISecureSecTentGrpMembPKey, ISecureSecTentGrpMembObj> dict = indexByUserIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentGrpMemb().deleteSecTentGrpMembByUserIdx( null,
				LoginId );
			Iterator<ISecureSecTentGrpMembObj> iter = dict.values().iterator();
			ISecureSecTentGrpMembObj obj;
			List<ISecureSecTentGrpMembObj> toForget = new LinkedList<ISecureSecTentGrpMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByUserIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecTentGrpMemb().deleteSecTentGrpMembByUserIdx( null,
				LoginId );
		}
		deepDisposeSecTentGrpMembByUserIdx( LoginId );
	}
}