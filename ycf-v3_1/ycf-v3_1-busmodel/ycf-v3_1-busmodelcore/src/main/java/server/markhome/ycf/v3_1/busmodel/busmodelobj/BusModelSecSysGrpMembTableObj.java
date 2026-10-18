// Description: Java 25 Table Object implementation for SecSysGrpMemb.

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

public class BusModelSecSysGrpMembTableObj
	implements IBusModelSecSysGrpMembTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> members;
	private Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> allSecSysGrpMemb;
	private Map< ISecureSecSysGrpMembBySysGrpIdxKey,
		Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > > indexBySysGrpIdx;
	private Map< ISecureSecSysGrpMembByLoginIdxKey,
		Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > > indexByLoginIdx;
	public static String TABLE_NAME = "SecSysGrpMemb";
	public static String TABLE_DBNAME = "secsysgrpmemb";

	public BusModelSecSysGrpMembTableObj() {
		schema = null;
		members = new HashMap<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj>();
		allSecSysGrpMemb = null;
		indexBySysGrpIdx = null;
		indexByLoginIdx = null;
	}

	public BusModelSecSysGrpMembTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj>();
		allSecSysGrpMemb = null;
		indexBySysGrpIdx = null;
		indexByLoginIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecSysGrpMembTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecSysGrpMembTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecSysGrpMembTableObj.getRuntimeClassCode() );
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
		allSecSysGrpMemb = null;
		indexBySysGrpIdx = null;
		indexByLoginIdx = null;
		List<ISecureSecSysGrpMembObj> toForget = new LinkedList<ISecureSecSysGrpMembObj>();
		ISecureSecSysGrpMembObj cur = null;
		Iterator<ISecureSecSysGrpMembObj> iter = members.values().iterator();
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
	 *	BusModelSecSysGrpMembObj.
	 */
	@Override
	public ISecureSecSysGrpMembObj newInstance() {
		ISecureSecSysGrpMembObj inst = new BusModelSecSysGrpMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecSysGrpMembObj.
	 */
	@Override
	public ISecureSecSysGrpMembEditObj newEditInstance( ISecureSecSysGrpMembObj orig ) {
		ISecureSecSysGrpMembEditObj edit = new BusModelSecSysGrpMembEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecSysGrpMembObj constructByClassCode( int backingClassCode ) {
		ISecureSecSysGrpMembObj obj = null;
		if( backingClassCode == ISecureSecSysGrpMemb.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecSysGrpMembTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecSysGrpMembObj realiseSecSysGrpMemb( ISecureSecSysGrpMembObj Obj ) {
		ISecureSecSysGrpMembObj obj = Obj;
		ISecureSecSysGrpMembPKey pkey = obj.getPKey();
		ISecureSecSysGrpMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecSysGrpMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexBySysGrpIdx != null ) {
				ISecureSecSysGrpMembBySysGrpIdxKey keySysGrpIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
				keySysGrpIdx.setRequiredSecSysGrpId( keepObj.getRequiredSecSysGrpId() );
				Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > mapSysGrpIdx = indexBySysGrpIdx.get( keySysGrpIdx );
				if( mapSysGrpIdx != null ) {
					mapSysGrpIdx.remove( keepObj.getPKey() );
					if( mapSysGrpIdx.size() <= 0 ) {
						indexBySysGrpIdx.remove( keySysGrpIdx );
					}
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecSysGrpMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.remove( keepObj.getPKey() );
					if( mapLoginIdx.size() <= 0 ) {
						indexByLoginIdx.remove( keyLoginIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexBySysGrpIdx != null ) {
				ISecureSecSysGrpMembBySysGrpIdxKey keySysGrpIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
				keySysGrpIdx.setRequiredSecSysGrpId( keepObj.getRequiredSecSysGrpId() );
				Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > mapSysGrpIdx = indexBySysGrpIdx.get( keySysGrpIdx );
				if( mapSysGrpIdx != null ) {
					mapSysGrpIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecSysGrpMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecSysGrpMemb != null ) {
				allSecSysGrpMemb.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecSysGrpMemb != null ) {
				allSecSysGrpMemb.put( keepObj.getPKey(), keepObj );
			}

			if( indexBySysGrpIdx != null ) {
				ISecureSecSysGrpMembBySysGrpIdxKey keySysGrpIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
				keySysGrpIdx.setRequiredSecSysGrpId( keepObj.getRequiredSecSysGrpId() );
				Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > mapSysGrpIdx = indexBySysGrpIdx.get( keySysGrpIdx );
				if( mapSysGrpIdx != null ) {
					mapSysGrpIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecSysGrpMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecSysGrpMembObj createSecSysGrpMemb( ISecureSecSysGrpMembObj Obj ) {
		ISecureSecSysGrpMembObj obj = Obj;
		ISecureSecSysGrpMemb rec = obj.getSecSysGrpMembRec();
		schema.getSecureBackingStore().getTableSecSysGrpMemb().createSecSysGrpMemb(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecSysGrpMembObj readSecSysGrpMemb( ISecureSecSysGrpMembPKey pkey ) {
		return( readSecSysGrpMemb( pkey, false ) );
	}

	@Override
	public ISecureSecSysGrpMembObj readSecSysGrpMemb( ISecureSecSysGrpMembPKey pkey, boolean forceRead ) {
		ISecureSecSysGrpMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecSysGrpMemb readRec = schema.getSecureBackingStore().getTableSecSysGrpMemb().readDerivedByIdIdx( null,
						pkey.getRequiredSecSysGrpId(),
						pkey.getRequiredLoginId() );
			if( readRec != null ) {
				obj = schema.getSecSysGrpMembTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecSysGrpMembObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecSysGrpMembObj readSecSysGrpMemb( IYCFKeyHash256 SecSysGrpId,
		String LoginId ) {
		return( readSecSysGrpMemb( SecSysGrpId,
			LoginId, false ) );
	}

	@Override
	public ISecureSecSysGrpMembObj readSecSysGrpMemb( IYCFKeyHash256 SecSysGrpId,
		String LoginId, boolean forceRead ) {
		ISecureSecSysGrpMembObj obj = null;
		ISecureSecSysGrpMemb readRec = schema.getSecureBackingStore().getTableSecSysGrpMemb().readDerivedByIdIdx( null,
			SecSysGrpId,
			LoginId );
		if( readRec != null ) {
				obj = schema.getSecSysGrpMembTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureSecSysGrpMembObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureSecSysGrpMembObj readCachedSecSysGrpMemb( ISecureSecSysGrpMembPKey pkey ) {
		ISecureSecSysGrpMembObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecSysGrpMemb( ISecureSecSysGrpMembObj obj )
	{
		final String S_ProcName = "BusModelSecSysGrpMembTableObj.reallyDeepDisposeSecSysGrpMemb() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureSecSysGrpMembPKey pkey = obj.getPKey();
		ISecureSecSysGrpMembObj existing = readCachedSecSysGrpMemb( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecSysGrpMembBySysGrpIdxKey keySysGrpIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		keySysGrpIdx.setRequiredSecSysGrpId( existing.getRequiredSecSysGrpId() );

		ISecureSecSysGrpMembByLoginIdxKey keyLoginIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
		keyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );



		if( indexBySysGrpIdx != null ) {
			if( indexBySysGrpIdx.containsKey( keySysGrpIdx ) ) {
				indexBySysGrpIdx.get( keySysGrpIdx ).remove( pkey );
				if( indexBySysGrpIdx.get( keySysGrpIdx ).size() <= 0 ) {
					indexBySysGrpIdx.remove( keySysGrpIdx );
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
	public void deepDisposeSecSysGrpMemb( ISecureSecSysGrpMembPKey pkey ) {
		ISecureSecSysGrpMembObj obj = readCachedSecSysGrpMemb( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecSysGrpMembObj lockSecSysGrpMemb( ISecureSecSysGrpMembPKey pkey ) {
		ISecureSecSysGrpMembObj locked = null;
		ISecureSecSysGrpMemb lockRec = schema.getSecureBackingStore().getTableSecSysGrpMemb().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecSysGrpMembTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecSysGrpMembObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecSysGrpMemb", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> readAllSecSysGrpMemb() {
		return( readAllSecSysGrpMemb( false ) );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> readAllSecSysGrpMemb( boolean forceRead ) {
		final String S_ProcName = "readAllSecSysGrpMemb";
		if( ( allSecSysGrpMemb == null ) || forceRead ) {
			Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> map = new HashMap<ISecureSecSysGrpMembPKey,ISecureSecSysGrpMembObj>();
			allSecSysGrpMemb = map;
			ISecureSecSysGrpMemb[] recList = schema.getSecureBackingStore().getTableSecSysGrpMemb().readAllDerived( null );
			ISecureSecSysGrpMemb rec;
			ISecureSecSysGrpMembObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysGrpMembObj realised = (ISecureSecSysGrpMembObj)obj.realise();
			}
		}
		int len = allSecSysGrpMemb.size();
		ISecureSecSysGrpMembObj arr[] = new ISecureSecSysGrpMembObj[len];
		Iterator<ISecureSecSysGrpMembObj> valIter = allSecSysGrpMemb.values().iterator();
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
		ArrayList<ISecureSecSysGrpMembObj> arrayList = new ArrayList<ISecureSecSysGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysGrpMembObj> cmp = new Comparator<ISecureSecSysGrpMembObj>() {
			@Override
			public int compare( ISecureSecSysGrpMembObj lhs, ISecureSecSysGrpMembObj rhs ) {
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
					ISecureSecSysGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecSysGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> readCachedAllSecSysGrpMemb() {
		final String S_ProcName = "readCachedAllSecSysGrpMemb";
		ArrayList<ISecureSecSysGrpMembObj> arrayList = new ArrayList<ISecureSecSysGrpMembObj>();
		if( allSecSysGrpMemb != null ) {
			int len = allSecSysGrpMemb.size();
			ISecureSecSysGrpMembObj arr[] = new ISecureSecSysGrpMembObj[len];
			Iterator<ISecureSecSysGrpMembObj> valIter = allSecSysGrpMemb.values().iterator();
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
		Comparator<ISecureSecSysGrpMembObj> cmp = new Comparator<ISecureSecSysGrpMembObj>() {
			public int compare( ISecureSecSysGrpMembObj lhs, ISecureSecSysGrpMembObj rhs ) {
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
					ISecureSecSysGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	/**
	 *	Return a sorted map of a page of the SecSysGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ISecureSecSysGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecSysGrpMembObj> pageAllSecSysGrpMemb(IYCFKeyHash256 priorSecSysGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllSecSysGrpMemb";
		Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> map = new HashMap<ISecureSecSysGrpMembPKey,ISecureSecSysGrpMembObj>();
		ISecureSecSysGrpMemb[] recList = schema.getSecureBackingStore().getTableSecSysGrpMemb().pageAllRec( null,
			priorSecSysGrpId,
			priorLoginId );
		ISecureSecSysGrpMemb rec;
		ISecureSecSysGrpMembObj obj;
		ISecureSecSysGrpMembObj realised;
		ArrayList<ISecureSecSysGrpMembObj> arrayList = new ArrayList<ISecureSecSysGrpMembObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecSysGrpMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecSysGrpMembObj readSecSysGrpMembByIdIdx( IYCFKeyHash256 SecSysGrpId,
		String LoginId )
	{
		return( readSecSysGrpMembByIdIdx( SecSysGrpId,
			LoginId,
			false ) );
	}

	@Override
	public ISecureSecSysGrpMembObj readSecSysGrpMembByIdIdx( IYCFKeyHash256 SecSysGrpId,
		String LoginId, boolean forceRead )
	{
		ISecureSecSysGrpMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newPKey();
		pkey.setRequiredSecSysGrpId( SecSysGrpId );
		pkey.setRequiredLoginId( LoginId );
		ISecureSecSysGrpMembObj obj = readSecSysGrpMemb( pkey, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> readSecSysGrpMembBySysGrpIdx( IYCFKeyHash256 SecSysGrpId )
	{
		return( readSecSysGrpMembBySysGrpIdx( SecSysGrpId,
			false ) );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> readSecSysGrpMembBySysGrpIdx( IYCFKeyHash256 SecSysGrpId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSysGrpMembBySysGrpIdx";
		ISecureSecSysGrpMembBySysGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		key.setRequiredSecSysGrpId( SecSysGrpId );
		Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> dict;
		if( indexBySysGrpIdx == null ) {
			indexBySysGrpIdx = new HashMap< ISecureSecSysGrpMembBySysGrpIdxKey,
				Map< ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexBySysGrpIdx.containsKey( key ) ) {
			dict = indexBySysGrpIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj>();
			ISecureSecSysGrpMembObj obj;
			ISecureSecSysGrpMemb[] recList = schema.getSecureBackingStore().getTableSecSysGrpMemb().readDerivedBySysGrpIdx( null,
				SecSysGrpId );
			ISecureSecSysGrpMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSysGrpMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysGrpMembObj realised = (ISecureSecSysGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySysGrpIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSysGrpMembObj arr[] = new ISecureSecSysGrpMembObj[len];
		Iterator<ISecureSecSysGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSysGrpMembObj> arrayList = new ArrayList<ISecureSecSysGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysGrpMembObj> cmp = new Comparator<ISecureSecSysGrpMembObj>() {
			@Override
			public int compare( ISecureSecSysGrpMembObj lhs, ISecureSecSysGrpMembObj rhs ) {
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
					ISecureSecSysGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecSysGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> readSecSysGrpMembByLoginIdx( String LoginId )
	{
		return( readSecSysGrpMembByLoginIdx( LoginId,
			false ) );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> readSecSysGrpMembByLoginIdx( String LoginId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSysGrpMembByLoginIdx";
		ISecureSecSysGrpMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> dict;
		if( indexByLoginIdx == null ) {
			indexByLoginIdx = new HashMap< ISecureSecSysGrpMembByLoginIdxKey,
				Map< ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > >();
		}
		if( ( ! forceRead ) && indexByLoginIdx.containsKey( key ) ) {
			dict = indexByLoginIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj>();
			ISecureSecSysGrpMembObj obj;
			ISecureSecSysGrpMemb[] recList = schema.getSecureBackingStore().getTableSecSysGrpMemb().readDerivedByLoginIdx( null,
				LoginId );
			ISecureSecSysGrpMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSysGrpMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysGrpMembObj realised = (ISecureSecSysGrpMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLoginIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSysGrpMembObj arr[] = new ISecureSecSysGrpMembObj[len];
		Iterator<ISecureSecSysGrpMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSysGrpMembObj> arrayList = new ArrayList<ISecureSecSysGrpMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysGrpMembObj> cmp = new Comparator<ISecureSecSysGrpMembObj>() {
			@Override
			public int compare( ISecureSecSysGrpMembObj lhs, ISecureSecSysGrpMembObj rhs ) {
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
					ISecureSecSysGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecSysGrpMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecSysGrpMembObj readCachedSecSysGrpMembByIdIdx( IYCFKeyHash256 SecSysGrpId,
		String LoginId )
	{
		ISecureSecSysGrpMembObj obj = null;
		ISecureSecSysGrpMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newPKey();
		pkey.setRequiredSecSysGrpId( SecSysGrpId );
		pkey.setRequiredLoginId( LoginId );
		pkey.setRequiredSecSysGrpId( SecSysGrpId );
		pkey.setRequiredLoginId( LoginId );
		obj = readCachedSecSysGrpMemb( pkey );
		return( obj );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> readCachedSecSysGrpMembBySysGrpIdx( IYCFKeyHash256 SecSysGrpId )
	{
		final String S_ProcName = "readCachedSecSysGrpMembBySysGrpIdx";
		ISecureSecSysGrpMembBySysGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		key.setRequiredSecSysGrpId( SecSysGrpId );
		ArrayList<ISecureSecSysGrpMembObj> arrayList = new ArrayList<ISecureSecSysGrpMembObj>();
		if( indexBySysGrpIdx != null ) {
			Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> dict;
			if( indexBySysGrpIdx.containsKey( key ) ) {
				dict = indexBySysGrpIdx.get( key );
				int len = dict.size();
				ISecureSecSysGrpMembObj arr[] = new ISecureSecSysGrpMembObj[len];
				Iterator<ISecureSecSysGrpMembObj> valIter = dict.values().iterator();
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
			ISecureSecSysGrpMembObj obj;
			Iterator<ISecureSecSysGrpMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSysGrpMembObj> cmp = new Comparator<ISecureSecSysGrpMembObj>() {
			@Override
			public int compare( ISecureSecSysGrpMembObj lhs, ISecureSecSysGrpMembObj rhs ) {
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
					ISecureSecSysGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> readCachedSecSysGrpMembByLoginIdx( String LoginId )
	{
		final String S_ProcName = "readCachedSecSysGrpMembByLoginIdx";
		ISecureSecSysGrpMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ArrayList<ISecureSecSysGrpMembObj> arrayList = new ArrayList<ISecureSecSysGrpMembObj>();
		if( indexByLoginIdx != null ) {
			Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> dict;
			if( indexByLoginIdx.containsKey( key ) ) {
				dict = indexByLoginIdx.get( key );
				int len = dict.size();
				ISecureSecSysGrpMembObj arr[] = new ISecureSecSysGrpMembObj[len];
				Iterator<ISecureSecSysGrpMembObj> valIter = dict.values().iterator();
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
			ISecureSecSysGrpMembObj obj;
			Iterator<ISecureSecSysGrpMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSysGrpMembObj> cmp = new Comparator<ISecureSecSysGrpMembObj>() {
			@Override
			public int compare( ISecureSecSysGrpMembObj lhs, ISecureSecSysGrpMembObj rhs ) {
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
					ISecureSecSysGrpMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysGrpMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeSecSysGrpMembByIdIdx( IYCFKeyHash256 SecSysGrpId,
		String LoginId )
	{
		ISecureSecSysGrpMembObj obj = readCachedSecSysGrpMembByIdIdx( SecSysGrpId,
				LoginId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecSysGrpMembBySysGrpIdx( IYCFKeyHash256 SecSysGrpId )
	{
		final String S_ProcName = "deepDisposeSecSysGrpMembBySysGrpIdx";
		ISecureSecSysGrpMembObj obj;
		List<ISecureSecSysGrpMembObj> arrayList = readCachedSecSysGrpMembBySysGrpIdx( SecSysGrpId );
		if( arrayList != null )  {
			Iterator<ISecureSecSysGrpMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecSysGrpMembByLoginIdx( String LoginId )
	{
		final String S_ProcName = "deepDisposeSecSysGrpMembByLoginIdx";
		ISecureSecSysGrpMembObj obj;
		List<ISecureSecSysGrpMembObj> arrayList = readCachedSecSysGrpMembByLoginIdx( LoginId );
		if( arrayList != null )  {
			Iterator<ISecureSecSysGrpMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecSysGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SysGrpIdx key attributes.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSysGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecSysGrpMembObj> pageSecSysGrpMembBySysGrpIdx( IYCFKeyHash256 SecSysGrpId,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecSysGrpMembBySysGrpIdx";
		ISecureSecSysGrpMembBySysGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		key.setRequiredSecSysGrpId( SecSysGrpId );
		List<ISecureSecSysGrpMembObj> retList = new LinkedList<ISecureSecSysGrpMembObj>();
		ISecureSecSysGrpMembObj obj;
		ISecureSecSysGrpMemb[] recList = schema.getSecureBackingStore().getTableSecSysGrpMemb().pageRecBySysGrpIdx( null,
				SecSysGrpId,
			priorSecSysGrpId,
			priorLoginId );
		ISecureSecSysGrpMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecSysGrpMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecSysGrpMembObj realised = (ISecureSecSysGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecSysGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate LoginIdx key attributes.
	 *
	 *	@param	LoginId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSysGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecSysGrpMembObj> pageSecSysGrpMembByLoginIdx( String LoginId,
		IYCFKeyHash256 priorSecSysGrpId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecSysGrpMembByLoginIdx";
		ISecureSecSysGrpMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		List<ISecureSecSysGrpMembObj> retList = new LinkedList<ISecureSecSysGrpMembObj>();
		ISecureSecSysGrpMembObj obj;
		ISecureSecSysGrpMemb[] recList = schema.getSecureBackingStore().getTableSecSysGrpMemb().pageRecByLoginIdx( null,
				LoginId,
			priorSecSysGrpId,
			priorLoginId );
		ISecureSecSysGrpMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecSysGrpMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecSysGrpMembObj realised = (ISecureSecSysGrpMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecSysGrpMembObj updateSecSysGrpMemb( ISecureSecSysGrpMembObj Obj ) {
		ISecureSecSysGrpMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysGrpMemb().updateSecSysGrpMemb( null,
			Obj.getSecSysGrpMembRec() );
		obj = (ISecureSecSysGrpMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecSysGrpMemb( ISecureSecSysGrpMembObj Obj ) {
		ISecureSecSysGrpMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysGrpMemb().deleteSecSysGrpMemb( null,
			obj.getSecSysGrpMembRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecSysGrpMembByIdIdx( IYCFKeyHash256 SecSysGrpId,
		String LoginId )
	{
		ISecureSecSysGrpMembObj obj = readSecSysGrpMemb(SecSysGrpId,
				LoginId);
		if( obj != null ) {
			ISecureSecSysGrpMembEditObj editObj = (ISecureSecSysGrpMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecSysGrpMembEditObj)obj.beginEdit();
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
		deepDisposeSecSysGrpMembByIdIdx( SecSysGrpId,
				LoginId );
	}

	@Override
	public void deleteSecSysGrpMembBySysGrpIdx( IYCFKeyHash256 SecSysGrpId )
	{
		ISecureSecSysGrpMembBySysGrpIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newBySysGrpIdxKey();
		key.setRequiredSecSysGrpId( SecSysGrpId );
		if( indexBySysGrpIdx == null ) {
			indexBySysGrpIdx = new HashMap< ISecureSecSysGrpMembBySysGrpIdxKey,
				Map< ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > >();
		}
		if( indexBySysGrpIdx.containsKey( key ) ) {
			Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> dict = indexBySysGrpIdx.get( key );
			schema.getSecureBackingStore().getTableSecSysGrpMemb().deleteSecSysGrpMembBySysGrpIdx( null,
				SecSysGrpId );
			Iterator<ISecureSecSysGrpMembObj> iter = dict.values().iterator();
			ISecureSecSysGrpMembObj obj;
			List<ISecureSecSysGrpMembObj> toForget = new LinkedList<ISecureSecSysGrpMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySysGrpIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecSysGrpMemb().deleteSecSysGrpMembBySysGrpIdx( null,
				SecSysGrpId );
		}
		deepDisposeSecSysGrpMembBySysGrpIdx( SecSysGrpId );
	}

	@Override
	public void deleteSecSysGrpMembByLoginIdx( String LoginId )
	{
		ISecureSecSysGrpMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrpMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		if( indexByLoginIdx == null ) {
			indexByLoginIdx = new HashMap< ISecureSecSysGrpMembByLoginIdxKey,
				Map< ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj > >();
		}
		if( indexByLoginIdx.containsKey( key ) ) {
			Map<ISecureSecSysGrpMembPKey, ISecureSecSysGrpMembObj> dict = indexByLoginIdx.get( key );
			schema.getSecureBackingStore().getTableSecSysGrpMemb().deleteSecSysGrpMembByLoginIdx( null,
				LoginId );
			Iterator<ISecureSecSysGrpMembObj> iter = dict.values().iterator();
			ISecureSecSysGrpMembObj obj;
			List<ISecureSecSysGrpMembObj> toForget = new LinkedList<ISecureSecSysGrpMembObj>();
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
			schema.getSecureBackingStore().getTableSecSysGrpMemb().deleteSecSysGrpMembByLoginIdx( null,
				LoginId );
		}
		deepDisposeSecSysGrpMembByLoginIdx( LoginId );
	}
}