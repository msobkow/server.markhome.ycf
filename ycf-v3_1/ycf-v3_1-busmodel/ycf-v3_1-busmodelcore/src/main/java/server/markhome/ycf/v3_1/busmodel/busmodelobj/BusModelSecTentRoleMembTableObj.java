// Description: Java 25 Table Object implementation for SecTentRoleMemb.

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

public class BusModelSecTentRoleMembTableObj
	implements IBusModelSecTentRoleMembTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> members;
	private Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> allSecTentRoleMemb;
	private Map< ISecureSecTentRoleMembByTentRoleIdxKey,
		Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > > indexByTentRoleIdx;
	private Map< ISecureSecTentRoleMembByUserIdxKey,
		Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > > indexByUserIdx;
	public static String TABLE_NAME = "SecTentRoleMemb";
	public static String TABLE_DBNAME = "sectentrolememb";

	public BusModelSecTentRoleMembTableObj() {
		schema = null;
		members = new HashMap<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj>();
		allSecTentRoleMemb = null;
		indexByTentRoleIdx = null;
		indexByUserIdx = null;
	}

	public BusModelSecTentRoleMembTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj>();
		allSecTentRoleMemb = null;
		indexByTentRoleIdx = null;
		indexByUserIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecTentRoleMembTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecTentRoleMembTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecTentRoleMembTableObj.getRuntimeClassCode() );
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
		allSecTentRoleMemb = null;
		indexByTentRoleIdx = null;
		indexByUserIdx = null;
		List<ISecureSecTentRoleMembObj> toForget = new LinkedList<ISecureSecTentRoleMembObj>();
		ISecureSecTentRoleMembObj cur = null;
		Iterator<ISecureSecTentRoleMembObj> iter = members.values().iterator();
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
	 *	BusModelSecTentRoleMembObj.
	 */
	@Override
	public ISecureSecTentRoleMembObj newInstance() {
		ISecureSecTentRoleMembObj inst = new BusModelSecTentRoleMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecTentRoleMembObj.
	 */
	@Override
	public ISecureSecTentRoleMembEditObj newEditInstance( ISecureSecTentRoleMembObj orig ) {
		ISecureSecTentRoleMembEditObj edit = new BusModelSecTentRoleMembEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecTentRoleMembObj constructByClassCode( int backingClassCode ) {
		ISecureSecTentRoleMembObj obj = null;
		if( backingClassCode == ISecureSecTentRoleMemb.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecTentRoleMembTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecTentRoleMembObj realiseSecTentRoleMemb( ISecureSecTentRoleMembObj Obj ) {
		ISecureSecTentRoleMembObj obj = Obj;
		ISecureSecTentRoleMembPKey pkey = obj.getPKey();
		ISecureSecTentRoleMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecTentRoleMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTentRoleIdx != null ) {
				ISecureSecTentRoleMembByTentRoleIdxKey keyTentRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
				keyTentRoleIdx.setRequiredSecTentRoleId( keepObj.getRequiredSecTentRoleId() );
				Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > mapTentRoleIdx = indexByTentRoleIdx.get( keyTentRoleIdx );
				if( mapTentRoleIdx != null ) {
					mapTentRoleIdx.remove( keepObj.getPKey() );
					if( mapTentRoleIdx.size() <= 0 ) {
						indexByTentRoleIdx.remove( keyTentRoleIdx );
					}
				}
			}

			if( indexByUserIdx != null ) {
				ISecureSecTentRoleMembByUserIdxKey keyUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
				keyUserIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.remove( keepObj.getPKey() );
					if( mapUserIdx.size() <= 0 ) {
						indexByUserIdx.remove( keyUserIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTentRoleIdx != null ) {
				ISecureSecTentRoleMembByTentRoleIdxKey keyTentRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
				keyTentRoleIdx.setRequiredSecTentRoleId( keepObj.getRequiredSecTentRoleId() );
				Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > mapTentRoleIdx = indexByTentRoleIdx.get( keyTentRoleIdx );
				if( mapTentRoleIdx != null ) {
					mapTentRoleIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				ISecureSecTentRoleMembByUserIdxKey keyUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
				keyUserIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecTentRoleMemb != null ) {
				allSecTentRoleMemb.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecTentRoleMemb != null ) {
				allSecTentRoleMemb.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTentRoleIdx != null ) {
				ISecureSecTentRoleMembByTentRoleIdxKey keyTentRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
				keyTentRoleIdx.setRequiredSecTentRoleId( keepObj.getRequiredSecTentRoleId() );
				Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > mapTentRoleIdx = indexByTentRoleIdx.get( keyTentRoleIdx );
				if( mapTentRoleIdx != null ) {
					mapTentRoleIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUserIdx != null ) {
				ISecureSecTentRoleMembByUserIdxKey keyUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
				keyUserIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > mapUserIdx = indexByUserIdx.get( keyUserIdx );
				if( mapUserIdx != null ) {
					mapUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecTentRoleMembObj createSecTentRoleMemb( ISecureSecTentRoleMembObj Obj ) {
		ISecureSecTentRoleMembObj obj = Obj;
		ISecureSecTentRoleMemb rec = obj.getSecTentRoleMembRec();
		schema.getSecureBackingStore().getTableSecTentRoleMemb().createSecTentRoleMemb(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecTentRoleMembObj readSecTentRoleMemb( ISecureSecTentRoleMembPKey pkey ) {
		return( readSecTentRoleMemb( pkey, false ) );
	}

	@Override
	public ISecureSecTentRoleMembObj readSecTentRoleMemb( ISecureSecTentRoleMembPKey pkey, boolean forceRead ) {
		ISecureSecTentRoleMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecTentRoleMemb readRec = schema.getSecureBackingStore().getTableSecTentRoleMemb().readDerivedByIdIdx( null,
						pkey.getRequiredSecTentRoleId(),
						pkey.getRequiredLoginId() );
			if( readRec != null ) {
				obj = schema.getSecTentRoleMembTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecTentRoleMembObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecTentRoleMembObj readSecTentRoleMemb( IYCFKeyHash256 SecTentRoleId,
		String LoginId ) {
		return( readSecTentRoleMemb( SecTentRoleId,
			LoginId, false ) );
	}

	@Override
	public ISecureSecTentRoleMembObj readSecTentRoleMemb( IYCFKeyHash256 SecTentRoleId,
		String LoginId, boolean forceRead ) {
		ISecureSecTentRoleMembObj obj = null;
		ISecureSecTentRoleMemb readRec = schema.getSecureBackingStore().getTableSecTentRoleMemb().readDerivedByIdIdx( null,
			SecTentRoleId,
			LoginId );
		if( readRec != null ) {
				obj = schema.getSecTentRoleMembTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureSecTentRoleMembObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureSecTentRoleMembObj readCachedSecTentRoleMemb( ISecureSecTentRoleMembPKey pkey ) {
		ISecureSecTentRoleMembObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecTentRoleMemb( ISecureSecTentRoleMembObj obj )
	{
		final String S_ProcName = "BusModelSecTentRoleMembTableObj.reallyDeepDisposeSecTentRoleMemb() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureSecTentRoleMembPKey pkey = obj.getPKey();
		ISecureSecTentRoleMembObj existing = readCachedSecTentRoleMemb( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecTentRoleMembByTentRoleIdxKey keyTentRoleIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		keyTentRoleIdx.setRequiredSecTentRoleId( existing.getRequiredSecTentRoleId() );

		ISecureSecTentRoleMembByUserIdxKey keyUserIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
		keyUserIdx.setRequiredLoginId( existing.getRequiredLoginId() );



		if( indexByTentRoleIdx != null ) {
			if( indexByTentRoleIdx.containsKey( keyTentRoleIdx ) ) {
				indexByTentRoleIdx.get( keyTentRoleIdx ).remove( pkey );
				if( indexByTentRoleIdx.get( keyTentRoleIdx ).size() <= 0 ) {
					indexByTentRoleIdx.remove( keyTentRoleIdx );
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
	public void deepDisposeSecTentRoleMemb( ISecureSecTentRoleMembPKey pkey ) {
		ISecureSecTentRoleMembObj obj = readCachedSecTentRoleMemb( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecTentRoleMembObj lockSecTentRoleMemb( ISecureSecTentRoleMembPKey pkey ) {
		ISecureSecTentRoleMembObj locked = null;
		ISecureSecTentRoleMemb lockRec = schema.getSecureBackingStore().getTableSecTentRoleMemb().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecTentRoleMembTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecTentRoleMembObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecTentRoleMemb", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecTentRoleMembObj> readAllSecTentRoleMemb() {
		return( readAllSecTentRoleMemb( false ) );
	}

	@Override
	public List<ISecureSecTentRoleMembObj> readAllSecTentRoleMemb( boolean forceRead ) {
		final String S_ProcName = "readAllSecTentRoleMemb";
		if( ( allSecTentRoleMemb == null ) || forceRead ) {
			Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> map = new HashMap<ISecureSecTentRoleMembPKey,ISecureSecTentRoleMembObj>();
			allSecTentRoleMemb = map;
			ISecureSecTentRoleMemb[] recList = schema.getSecureBackingStore().getTableSecTentRoleMemb().readAllDerived( null );
			ISecureSecTentRoleMemb rec;
			ISecureSecTentRoleMembObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentRoleMembObj realised = (ISecureSecTentRoleMembObj)obj.realise();
			}
		}
		int len = allSecTentRoleMemb.size();
		ISecureSecTentRoleMembObj arr[] = new ISecureSecTentRoleMembObj[len];
		Iterator<ISecureSecTentRoleMembObj> valIter = allSecTentRoleMemb.values().iterator();
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
		ArrayList<ISecureSecTentRoleMembObj> arrayList = new ArrayList<ISecureSecTentRoleMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentRoleMembObj> cmp = new Comparator<ISecureSecTentRoleMembObj>() {
			@Override
			public int compare( ISecureSecTentRoleMembObj lhs, ISecureSecTentRoleMembObj rhs ) {
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
					ISecureSecTentRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecTentRoleMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecTentRoleMembObj> readCachedAllSecTentRoleMemb() {
		final String S_ProcName = "readCachedAllSecTentRoleMemb";
		ArrayList<ISecureSecTentRoleMembObj> arrayList = new ArrayList<ISecureSecTentRoleMembObj>();
		if( allSecTentRoleMemb != null ) {
			int len = allSecTentRoleMemb.size();
			ISecureSecTentRoleMembObj arr[] = new ISecureSecTentRoleMembObj[len];
			Iterator<ISecureSecTentRoleMembObj> valIter = allSecTentRoleMemb.values().iterator();
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
		Comparator<ISecureSecTentRoleMembObj> cmp = new Comparator<ISecureSecTentRoleMembObj>() {
			public int compare( ISecureSecTentRoleMembObj lhs, ISecureSecTentRoleMembObj rhs ) {
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
					ISecureSecTentRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	/**
	 *	Return a sorted map of a page of the SecTentRoleMemb-derived instances in the database.
	 *
	 *	@return	List of ISecureSecTentRoleMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecTentRoleMembObj> pageAllSecTentRoleMemb(IYCFKeyHash256 priorSecTentRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllSecTentRoleMemb";
		Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> map = new HashMap<ISecureSecTentRoleMembPKey,ISecureSecTentRoleMembObj>();
		ISecureSecTentRoleMemb[] recList = schema.getSecureBackingStore().getTableSecTentRoleMemb().pageAllRec( null,
			priorSecTentRoleId,
			priorLoginId );
		ISecureSecTentRoleMemb rec;
		ISecureSecTentRoleMembObj obj;
		ISecureSecTentRoleMembObj realised;
		ArrayList<ISecureSecTentRoleMembObj> arrayList = new ArrayList<ISecureSecTentRoleMembObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecTentRoleMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecTentRoleMembObj readSecTentRoleMembByIdIdx( IYCFKeyHash256 SecTentRoleId,
		String LoginId )
	{
		return( readSecTentRoleMembByIdIdx( SecTentRoleId,
			LoginId,
			false ) );
	}

	@Override
	public ISecureSecTentRoleMembObj readSecTentRoleMembByIdIdx( IYCFKeyHash256 SecTentRoleId,
		String LoginId, boolean forceRead )
	{
		ISecureSecTentRoleMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newPKey();
		pkey.setRequiredSecTentRoleId( SecTentRoleId );
		pkey.setRequiredLoginId( LoginId );
		ISecureSecTentRoleMembObj obj = readSecTentRoleMemb( pkey, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecTentRoleMembObj> readSecTentRoleMembByTentRoleIdx( IYCFKeyHash256 SecTentRoleId )
	{
		return( readSecTentRoleMembByTentRoleIdx( SecTentRoleId,
			false ) );
	}

	@Override
	public List<ISecureSecTentRoleMembObj> readSecTentRoleMembByTentRoleIdx( IYCFKeyHash256 SecTentRoleId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecTentRoleMembByTentRoleIdx";
		ISecureSecTentRoleMembByTentRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		key.setRequiredSecTentRoleId( SecTentRoleId );
		Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> dict;
		if( indexByTentRoleIdx == null ) {
			indexByTentRoleIdx = new HashMap< ISecureSecTentRoleMembByTentRoleIdxKey,
				Map< ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > >();
		}
		if( ( ! forceRead ) && indexByTentRoleIdx.containsKey( key ) ) {
			dict = indexByTentRoleIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj>();
			ISecureSecTentRoleMembObj obj;
			ISecureSecTentRoleMemb[] recList = schema.getSecureBackingStore().getTableSecTentRoleMemb().readDerivedByTentRoleIdx( null,
				SecTentRoleId );
			ISecureSecTentRoleMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecTentRoleMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentRoleMembObj realised = (ISecureSecTentRoleMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTentRoleIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecTentRoleMembObj arr[] = new ISecureSecTentRoleMembObj[len];
		Iterator<ISecureSecTentRoleMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecTentRoleMembObj> arrayList = new ArrayList<ISecureSecTentRoleMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentRoleMembObj> cmp = new Comparator<ISecureSecTentRoleMembObj>() {
			@Override
			public int compare( ISecureSecTentRoleMembObj lhs, ISecureSecTentRoleMembObj rhs ) {
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
					ISecureSecTentRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecTentRoleMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecTentRoleMembObj> readSecTentRoleMembByUserIdx( String LoginId )
	{
		return( readSecTentRoleMembByUserIdx( LoginId,
			false ) );
	}

	@Override
	public List<ISecureSecTentRoleMembObj> readSecTentRoleMembByUserIdx( String LoginId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecTentRoleMembByUserIdx";
		ISecureSecTentRoleMembByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
		key.setRequiredLoginId( LoginId );
		Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> dict;
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< ISecureSecTentRoleMembByUserIdxKey,
				Map< ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > >();
		}
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			dict = indexByUserIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj>();
			ISecureSecTentRoleMembObj obj;
			ISecureSecTentRoleMemb[] recList = schema.getSecureBackingStore().getTableSecTentRoleMemb().readDerivedByUserIdx( null,
				LoginId );
			ISecureSecTentRoleMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecTentRoleMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentRoleMembObj realised = (ISecureSecTentRoleMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByUserIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecTentRoleMembObj arr[] = new ISecureSecTentRoleMembObj[len];
		Iterator<ISecureSecTentRoleMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecTentRoleMembObj> arrayList = new ArrayList<ISecureSecTentRoleMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentRoleMembObj> cmp = new Comparator<ISecureSecTentRoleMembObj>() {
			@Override
			public int compare( ISecureSecTentRoleMembObj lhs, ISecureSecTentRoleMembObj rhs ) {
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
					ISecureSecTentRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecTentRoleMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecTentRoleMembObj readCachedSecTentRoleMembByIdIdx( IYCFKeyHash256 SecTentRoleId,
		String LoginId )
	{
		ISecureSecTentRoleMembObj obj = null;
		ISecureSecTentRoleMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newPKey();
		pkey.setRequiredSecTentRoleId( SecTentRoleId );
		pkey.setRequiredLoginId( LoginId );
		pkey.setRequiredSecTentRoleId( SecTentRoleId );
		pkey.setRequiredLoginId( LoginId );
		obj = readCachedSecTentRoleMemb( pkey );
		return( obj );
	}

	@Override
	public List<ISecureSecTentRoleMembObj> readCachedSecTentRoleMembByTentRoleIdx( IYCFKeyHash256 SecTentRoleId )
	{
		final String S_ProcName = "readCachedSecTentRoleMembByTentRoleIdx";
		ISecureSecTentRoleMembByTentRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		key.setRequiredSecTentRoleId( SecTentRoleId );
		ArrayList<ISecureSecTentRoleMembObj> arrayList = new ArrayList<ISecureSecTentRoleMembObj>();
		if( indexByTentRoleIdx != null ) {
			Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> dict;
			if( indexByTentRoleIdx.containsKey( key ) ) {
				dict = indexByTentRoleIdx.get( key );
				int len = dict.size();
				ISecureSecTentRoleMembObj arr[] = new ISecureSecTentRoleMembObj[len];
				Iterator<ISecureSecTentRoleMembObj> valIter = dict.values().iterator();
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
			ISecureSecTentRoleMembObj obj;
			Iterator<ISecureSecTentRoleMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecTentRoleMembObj> cmp = new Comparator<ISecureSecTentRoleMembObj>() {
			@Override
			public int compare( ISecureSecTentRoleMembObj lhs, ISecureSecTentRoleMembObj rhs ) {
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
					ISecureSecTentRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<ISecureSecTentRoleMembObj> readCachedSecTentRoleMembByUserIdx( String LoginId )
	{
		final String S_ProcName = "readCachedSecTentRoleMembByUserIdx";
		ISecureSecTentRoleMembByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
		key.setRequiredLoginId( LoginId );
		ArrayList<ISecureSecTentRoleMembObj> arrayList = new ArrayList<ISecureSecTentRoleMembObj>();
		if( indexByUserIdx != null ) {
			Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> dict;
			if( indexByUserIdx.containsKey( key ) ) {
				dict = indexByUserIdx.get( key );
				int len = dict.size();
				ISecureSecTentRoleMembObj arr[] = new ISecureSecTentRoleMembObj[len];
				Iterator<ISecureSecTentRoleMembObj> valIter = dict.values().iterator();
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
			ISecureSecTentRoleMembObj obj;
			Iterator<ISecureSecTentRoleMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecTentRoleMembObj> cmp = new Comparator<ISecureSecTentRoleMembObj>() {
			@Override
			public int compare( ISecureSecTentRoleMembObj lhs, ISecureSecTentRoleMembObj rhs ) {
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
					ISecureSecTentRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecTentRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeSecTentRoleMembByIdIdx( IYCFKeyHash256 SecTentRoleId,
		String LoginId )
	{
		ISecureSecTentRoleMembObj obj = readCachedSecTentRoleMembByIdIdx( SecTentRoleId,
				LoginId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecTentRoleMembByTentRoleIdx( IYCFKeyHash256 SecTentRoleId )
	{
		final String S_ProcName = "deepDisposeSecTentRoleMembByTentRoleIdx";
		ISecureSecTentRoleMembObj obj;
		List<ISecureSecTentRoleMembObj> arrayList = readCachedSecTentRoleMembByTentRoleIdx( SecTentRoleId );
		if( arrayList != null )  {
			Iterator<ISecureSecTentRoleMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecTentRoleMembByUserIdx( String LoginId )
	{
		final String S_ProcName = "deepDisposeSecTentRoleMembByUserIdx";
		ISecureSecTentRoleMembObj obj;
		List<ISecureSecTentRoleMembObj> arrayList = readCachedSecTentRoleMembByUserIdx( LoginId );
		if( arrayList != null )  {
			Iterator<ISecureSecTentRoleMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecTentRoleMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate TentRoleIdx key attributes.
	 *
	 *	@param	SecTentRoleId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecTentRoleMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecTentRoleMembObj> pageSecTentRoleMembByTentRoleIdx( IYCFKeyHash256 SecTentRoleId,
		IYCFKeyHash256 priorSecTentRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecTentRoleMembByTentRoleIdx";
		ISecureSecTentRoleMembByTentRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		key.setRequiredSecTentRoleId( SecTentRoleId );
		List<ISecureSecTentRoleMembObj> retList = new LinkedList<ISecureSecTentRoleMembObj>();
		ISecureSecTentRoleMembObj obj;
		ISecureSecTentRoleMemb[] recList = schema.getSecureBackingStore().getTableSecTentRoleMemb().pageRecByTentRoleIdx( null,
				SecTentRoleId,
			priorSecTentRoleId,
			priorLoginId );
		ISecureSecTentRoleMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecTentRoleMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecTentRoleMembObj realised = (ISecureSecTentRoleMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecTentRoleMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	LoginId	The SecTentRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecTentRoleMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecTentRoleMembObj> pageSecTentRoleMembByUserIdx( String LoginId,
		IYCFKeyHash256 priorSecTentRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecTentRoleMembByUserIdx";
		ISecureSecTentRoleMembByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
		key.setRequiredLoginId( LoginId );
		List<ISecureSecTentRoleMembObj> retList = new LinkedList<ISecureSecTentRoleMembObj>();
		ISecureSecTentRoleMembObj obj;
		ISecureSecTentRoleMemb[] recList = schema.getSecureBackingStore().getTableSecTentRoleMemb().pageRecByUserIdx( null,
				LoginId,
			priorSecTentRoleId,
			priorLoginId );
		ISecureSecTentRoleMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecTentRoleMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecTentRoleMembObj realised = (ISecureSecTentRoleMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecTentRoleMembObj updateSecTentRoleMemb( ISecureSecTentRoleMembObj Obj ) {
		ISecureSecTentRoleMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecTentRoleMemb().updateSecTentRoleMemb( null,
			Obj.getSecTentRoleMembRec() );
		obj = (ISecureSecTentRoleMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecTentRoleMemb( ISecureSecTentRoleMembObj Obj ) {
		ISecureSecTentRoleMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecTentRoleMemb().deleteSecTentRoleMemb( null,
			obj.getSecTentRoleMembRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecTentRoleMembByIdIdx( IYCFKeyHash256 SecTentRoleId,
		String LoginId )
	{
		ISecureSecTentRoleMembObj obj = readSecTentRoleMemb(SecTentRoleId,
				LoginId);
		if( obj != null ) {
			ISecureSecTentRoleMembEditObj editObj = (ISecureSecTentRoleMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecTentRoleMembEditObj)obj.beginEdit();
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
		deepDisposeSecTentRoleMembByIdIdx( SecTentRoleId,
				LoginId );
	}

	@Override
	public void deleteSecTentRoleMembByTentRoleIdx( IYCFKeyHash256 SecTentRoleId )
	{
		ISecureSecTentRoleMembByTentRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByTentRoleIdxKey();
		key.setRequiredSecTentRoleId( SecTentRoleId );
		if( indexByTentRoleIdx == null ) {
			indexByTentRoleIdx = new HashMap< ISecureSecTentRoleMembByTentRoleIdxKey,
				Map< ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > >();
		}
		if( indexByTentRoleIdx.containsKey( key ) ) {
			Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> dict = indexByTentRoleIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentRoleMemb().deleteSecTentRoleMembByTentRoleIdx( null,
				SecTentRoleId );
			Iterator<ISecureSecTentRoleMembObj> iter = dict.values().iterator();
			ISecureSecTentRoleMembObj obj;
			List<ISecureSecTentRoleMembObj> toForget = new LinkedList<ISecureSecTentRoleMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByTentRoleIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecTentRoleMemb().deleteSecTentRoleMembByTentRoleIdx( null,
				SecTentRoleId );
		}
		deepDisposeSecTentRoleMembByTentRoleIdx( SecTentRoleId );
	}

	@Override
	public void deleteSecTentRoleMembByUserIdx( String LoginId )
	{
		ISecureSecTentRoleMembByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newByUserIdxKey();
		key.setRequiredLoginId( LoginId );
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< ISecureSecTentRoleMembByUserIdxKey,
				Map< ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj > >();
		}
		if( indexByUserIdx.containsKey( key ) ) {
			Map<ISecureSecTentRoleMembPKey, ISecureSecTentRoleMembObj> dict = indexByUserIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentRoleMemb().deleteSecTentRoleMembByUserIdx( null,
				LoginId );
			Iterator<ISecureSecTentRoleMembObj> iter = dict.values().iterator();
			ISecureSecTentRoleMembObj obj;
			List<ISecureSecTentRoleMembObj> toForget = new LinkedList<ISecureSecTentRoleMembObj>();
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
			schema.getSecureBackingStore().getTableSecTentRoleMemb().deleteSecTentRoleMembByUserIdx( null,
				LoginId );
		}
		deepDisposeSecTentRoleMembByUserIdx( LoginId );
	}
}