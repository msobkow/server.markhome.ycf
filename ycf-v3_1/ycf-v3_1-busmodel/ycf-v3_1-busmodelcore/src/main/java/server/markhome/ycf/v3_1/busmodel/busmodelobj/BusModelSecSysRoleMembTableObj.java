// Description: Java 25 Table Object implementation for SecSysRoleMemb.

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

public class BusModelSecSysRoleMembTableObj
	implements IBusModelSecSysRoleMembTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> members;
	private Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> allSecSysRoleMemb;
	private Map< ISecureSecSysRoleMembBySysRoleIdxKey,
		Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > > indexBySysRoleIdx;
	private Map< ISecureSecSysRoleMembByLoginIdxKey,
		Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > > indexByLoginIdx;
	public static String TABLE_NAME = "SecSysRoleMemb";
	public static String TABLE_DBNAME = "secsysrolememb";

	public BusModelSecSysRoleMembTableObj() {
		schema = null;
		members = new HashMap<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj>();
		allSecSysRoleMemb = null;
		indexBySysRoleIdx = null;
		indexByLoginIdx = null;
	}

	public BusModelSecSysRoleMembTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj>();
		allSecSysRoleMemb = null;
		indexBySysRoleIdx = null;
		indexByLoginIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecSysRoleMembTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecSysRoleMembTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecSysRoleMembTableObj.getRuntimeClassCode() );
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
		allSecSysRoleMemb = null;
		indexBySysRoleIdx = null;
		indexByLoginIdx = null;
		List<ISecureSecSysRoleMembObj> toForget = new LinkedList<ISecureSecSysRoleMembObj>();
		ISecureSecSysRoleMembObj cur = null;
		Iterator<ISecureSecSysRoleMembObj> iter = members.values().iterator();
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
	 *	BusModelSecSysRoleMembObj.
	 */
	@Override
	public ISecureSecSysRoleMembObj newInstance() {
		ISecureSecSysRoleMembObj inst = new BusModelSecSysRoleMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecSysRoleMembObj.
	 */
	@Override
	public ISecureSecSysRoleMembEditObj newEditInstance( ISecureSecSysRoleMembObj orig ) {
		ISecureSecSysRoleMembEditObj edit = new BusModelSecSysRoleMembEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecSysRoleMembObj constructByClassCode( int backingClassCode ) {
		ISecureSecSysRoleMembObj obj = null;
		if( backingClassCode == ISecureSecSysRoleMemb.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecSysRoleMembTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecSysRoleMembObj realiseSecSysRoleMemb( ISecureSecSysRoleMembObj Obj ) {
		ISecureSecSysRoleMembObj obj = Obj;
		ISecureSecSysRoleMembPKey pkey = obj.getPKey();
		ISecureSecSysRoleMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecSysRoleMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexBySysRoleIdx != null ) {
				ISecureSecSysRoleMembBySysRoleIdxKey keySysRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
				keySysRoleIdx.setRequiredSecSysRoleId( keepObj.getRequiredSecSysRoleId() );
				Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > mapSysRoleIdx = indexBySysRoleIdx.get( keySysRoleIdx );
				if( mapSysRoleIdx != null ) {
					mapSysRoleIdx.remove( keepObj.getPKey() );
					if( mapSysRoleIdx.size() <= 0 ) {
						indexBySysRoleIdx.remove( keySysRoleIdx );
					}
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecSysRoleMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.remove( keepObj.getPKey() );
					if( mapLoginIdx.size() <= 0 ) {
						indexByLoginIdx.remove( keyLoginIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexBySysRoleIdx != null ) {
				ISecureSecSysRoleMembBySysRoleIdxKey keySysRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
				keySysRoleIdx.setRequiredSecSysRoleId( keepObj.getRequiredSecSysRoleId() );
				Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > mapSysRoleIdx = indexBySysRoleIdx.get( keySysRoleIdx );
				if( mapSysRoleIdx != null ) {
					mapSysRoleIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecSysRoleMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecSysRoleMemb != null ) {
				allSecSysRoleMemb.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecSysRoleMemb != null ) {
				allSecSysRoleMemb.put( keepObj.getPKey(), keepObj );
			}

			if( indexBySysRoleIdx != null ) {
				ISecureSecSysRoleMembBySysRoleIdxKey keySysRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
				keySysRoleIdx.setRequiredSecSysRoleId( keepObj.getRequiredSecSysRoleId() );
				Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > mapSysRoleIdx = indexBySysRoleIdx.get( keySysRoleIdx );
				if( mapSysRoleIdx != null ) {
					mapSysRoleIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecSysRoleMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecSysRoleMembObj createSecSysRoleMemb( ISecureSecSysRoleMembObj Obj ) {
		ISecureSecSysRoleMembObj obj = Obj;
		ISecureSecSysRoleMemb rec = obj.getSecSysRoleMembRec();
		schema.getSecureBackingStore().getTableSecSysRoleMemb().createSecSysRoleMemb(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecSysRoleMembObj readSecSysRoleMemb( ISecureSecSysRoleMembPKey pkey ) {
		return( readSecSysRoleMemb( pkey, false ) );
	}

	@Override
	public ISecureSecSysRoleMembObj readSecSysRoleMemb( ISecureSecSysRoleMembPKey pkey, boolean forceRead ) {
		ISecureSecSysRoleMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecSysRoleMemb readRec = schema.getSecureBackingStore().getTableSecSysRoleMemb().readDerivedByIdIdx( null,
						pkey.getRequiredSecSysRoleId(),
						pkey.getRequiredLoginId() );
			if( readRec != null ) {
				obj = schema.getSecSysRoleMembTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecSysRoleMembObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecSysRoleMembObj readSecSysRoleMemb( IYCFKeyHash256 SecSysRoleId,
		String LoginId ) {
		return( readSecSysRoleMemb( SecSysRoleId,
			LoginId, false ) );
	}

	@Override
	public ISecureSecSysRoleMembObj readSecSysRoleMemb( IYCFKeyHash256 SecSysRoleId,
		String LoginId, boolean forceRead ) {
		ISecureSecSysRoleMembObj obj = null;
		ISecureSecSysRoleMemb readRec = schema.getSecureBackingStore().getTableSecSysRoleMemb().readDerivedByIdIdx( null,
			SecSysRoleId,
			LoginId );
		if( readRec != null ) {
				obj = schema.getSecSysRoleMembTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureSecSysRoleMembObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureSecSysRoleMembObj readCachedSecSysRoleMemb( ISecureSecSysRoleMembPKey pkey ) {
		ISecureSecSysRoleMembObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecSysRoleMemb( ISecureSecSysRoleMembObj obj )
	{
		final String S_ProcName = "BusModelSecSysRoleMembTableObj.reallyDeepDisposeSecSysRoleMemb() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureSecSysRoleMembPKey pkey = obj.getPKey();
		ISecureSecSysRoleMembObj existing = readCachedSecSysRoleMemb( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecSysRoleMembBySysRoleIdxKey keySysRoleIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		keySysRoleIdx.setRequiredSecSysRoleId( existing.getRequiredSecSysRoleId() );

		ISecureSecSysRoleMembByLoginIdxKey keyLoginIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
		keyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );



		if( indexBySysRoleIdx != null ) {
			if( indexBySysRoleIdx.containsKey( keySysRoleIdx ) ) {
				indexBySysRoleIdx.get( keySysRoleIdx ).remove( pkey );
				if( indexBySysRoleIdx.get( keySysRoleIdx ).size() <= 0 ) {
					indexBySysRoleIdx.remove( keySysRoleIdx );
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
	public void deepDisposeSecSysRoleMemb( ISecureSecSysRoleMembPKey pkey ) {
		ISecureSecSysRoleMembObj obj = readCachedSecSysRoleMemb( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecSysRoleMembObj lockSecSysRoleMemb( ISecureSecSysRoleMembPKey pkey ) {
		ISecureSecSysRoleMembObj locked = null;
		ISecureSecSysRoleMemb lockRec = schema.getSecureBackingStore().getTableSecSysRoleMemb().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecSysRoleMembTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecSysRoleMembObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecSysRoleMemb", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> readAllSecSysRoleMemb() {
		return( readAllSecSysRoleMemb( false ) );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> readAllSecSysRoleMemb( boolean forceRead ) {
		final String S_ProcName = "readAllSecSysRoleMemb";
		if( ( allSecSysRoleMemb == null ) || forceRead ) {
			Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> map = new HashMap<ISecureSecSysRoleMembPKey,ISecureSecSysRoleMembObj>();
			allSecSysRoleMemb = map;
			ISecureSecSysRoleMemb[] recList = schema.getSecureBackingStore().getTableSecSysRoleMemb().readAllDerived( null );
			ISecureSecSysRoleMemb rec;
			ISecureSecSysRoleMembObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysRoleMembObj realised = (ISecureSecSysRoleMembObj)obj.realise();
			}
		}
		int len = allSecSysRoleMemb.size();
		ISecureSecSysRoleMembObj arr[] = new ISecureSecSysRoleMembObj[len];
		Iterator<ISecureSecSysRoleMembObj> valIter = allSecSysRoleMemb.values().iterator();
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
		ArrayList<ISecureSecSysRoleMembObj> arrayList = new ArrayList<ISecureSecSysRoleMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysRoleMembObj> cmp = new Comparator<ISecureSecSysRoleMembObj>() {
			@Override
			public int compare( ISecureSecSysRoleMembObj lhs, ISecureSecSysRoleMembObj rhs ) {
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
					ISecureSecSysRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecSysRoleMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> readCachedAllSecSysRoleMemb() {
		final String S_ProcName = "readCachedAllSecSysRoleMemb";
		ArrayList<ISecureSecSysRoleMembObj> arrayList = new ArrayList<ISecureSecSysRoleMembObj>();
		if( allSecSysRoleMemb != null ) {
			int len = allSecSysRoleMemb.size();
			ISecureSecSysRoleMembObj arr[] = new ISecureSecSysRoleMembObj[len];
			Iterator<ISecureSecSysRoleMembObj> valIter = allSecSysRoleMemb.values().iterator();
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
		Comparator<ISecureSecSysRoleMembObj> cmp = new Comparator<ISecureSecSysRoleMembObj>() {
			public int compare( ISecureSecSysRoleMembObj lhs, ISecureSecSysRoleMembObj rhs ) {
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
					ISecureSecSysRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	/**
	 *	Return a sorted map of a page of the SecSysRoleMemb-derived instances in the database.
	 *
	 *	@return	List of ISecureSecSysRoleMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecSysRoleMembObj> pageAllSecSysRoleMemb(IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllSecSysRoleMemb";
		Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> map = new HashMap<ISecureSecSysRoleMembPKey,ISecureSecSysRoleMembObj>();
		ISecureSecSysRoleMemb[] recList = schema.getSecureBackingStore().getTableSecSysRoleMemb().pageAllRec( null,
			priorSecSysRoleId,
			priorLoginId );
		ISecureSecSysRoleMemb rec;
		ISecureSecSysRoleMembObj obj;
		ISecureSecSysRoleMembObj realised;
		ArrayList<ISecureSecSysRoleMembObj> arrayList = new ArrayList<ISecureSecSysRoleMembObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecSysRoleMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecSysRoleMembObj readSecSysRoleMembByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String LoginId )
	{
		return( readSecSysRoleMembByIdIdx( SecSysRoleId,
			LoginId,
			false ) );
	}

	@Override
	public ISecureSecSysRoleMembObj readSecSysRoleMembByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String LoginId, boolean forceRead )
	{
		ISecureSecSysRoleMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newPKey();
		pkey.setRequiredSecSysRoleId( SecSysRoleId );
		pkey.setRequiredLoginId( LoginId );
		ISecureSecSysRoleMembObj obj = readSecSysRoleMemb( pkey, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> readSecSysRoleMembBySysRoleIdx( IYCFKeyHash256 SecSysRoleId )
	{
		return( readSecSysRoleMembBySysRoleIdx( SecSysRoleId,
			false ) );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> readSecSysRoleMembBySysRoleIdx( IYCFKeyHash256 SecSysRoleId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSysRoleMembBySysRoleIdx";
		ISecureSecSysRoleMembBySysRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( SecSysRoleId );
		Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> dict;
		if( indexBySysRoleIdx == null ) {
			indexBySysRoleIdx = new HashMap< ISecureSecSysRoleMembBySysRoleIdxKey,
				Map< ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > >();
		}
		if( ( ! forceRead ) && indexBySysRoleIdx.containsKey( key ) ) {
			dict = indexBySysRoleIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj>();
			ISecureSecSysRoleMembObj obj;
			ISecureSecSysRoleMemb[] recList = schema.getSecureBackingStore().getTableSecSysRoleMemb().readDerivedBySysRoleIdx( null,
				SecSysRoleId );
			ISecureSecSysRoleMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSysRoleMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysRoleMembObj realised = (ISecureSecSysRoleMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySysRoleIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSysRoleMembObj arr[] = new ISecureSecSysRoleMembObj[len];
		Iterator<ISecureSecSysRoleMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSysRoleMembObj> arrayList = new ArrayList<ISecureSecSysRoleMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysRoleMembObj> cmp = new Comparator<ISecureSecSysRoleMembObj>() {
			@Override
			public int compare( ISecureSecSysRoleMembObj lhs, ISecureSecSysRoleMembObj rhs ) {
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
					ISecureSecSysRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecSysRoleMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> readSecSysRoleMembByLoginIdx( String LoginId )
	{
		return( readSecSysRoleMembByLoginIdx( LoginId,
			false ) );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> readSecSysRoleMembByLoginIdx( String LoginId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSysRoleMembByLoginIdx";
		ISecureSecSysRoleMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> dict;
		if( indexByLoginIdx == null ) {
			indexByLoginIdx = new HashMap< ISecureSecSysRoleMembByLoginIdxKey,
				Map< ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > >();
		}
		if( ( ! forceRead ) && indexByLoginIdx.containsKey( key ) ) {
			dict = indexByLoginIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj>();
			ISecureSecSysRoleMembObj obj;
			ISecureSecSysRoleMemb[] recList = schema.getSecureBackingStore().getTableSecSysRoleMemb().readDerivedByLoginIdx( null,
				LoginId );
			ISecureSecSysRoleMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSysRoleMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysRoleMembObj realised = (ISecureSecSysRoleMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLoginIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSysRoleMembObj arr[] = new ISecureSecSysRoleMembObj[len];
		Iterator<ISecureSecSysRoleMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSysRoleMembObj> arrayList = new ArrayList<ISecureSecSysRoleMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysRoleMembObj> cmp = new Comparator<ISecureSecSysRoleMembObj>() {
			@Override
			public int compare( ISecureSecSysRoleMembObj lhs, ISecureSecSysRoleMembObj rhs ) {
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
					ISecureSecSysRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecSysRoleMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecSysRoleMembObj readCachedSecSysRoleMembByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String LoginId )
	{
		ISecureSecSysRoleMembObj obj = null;
		ISecureSecSysRoleMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newPKey();
		pkey.setRequiredSecSysRoleId( SecSysRoleId );
		pkey.setRequiredLoginId( LoginId );
		pkey.setRequiredSecSysRoleId( SecSysRoleId );
		pkey.setRequiredLoginId( LoginId );
		obj = readCachedSecSysRoleMemb( pkey );
		return( obj );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> readCachedSecSysRoleMembBySysRoleIdx( IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "readCachedSecSysRoleMembBySysRoleIdx";
		ISecureSecSysRoleMembBySysRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( SecSysRoleId );
		ArrayList<ISecureSecSysRoleMembObj> arrayList = new ArrayList<ISecureSecSysRoleMembObj>();
		if( indexBySysRoleIdx != null ) {
			Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> dict;
			if( indexBySysRoleIdx.containsKey( key ) ) {
				dict = indexBySysRoleIdx.get( key );
				int len = dict.size();
				ISecureSecSysRoleMembObj arr[] = new ISecureSecSysRoleMembObj[len];
				Iterator<ISecureSecSysRoleMembObj> valIter = dict.values().iterator();
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
			ISecureSecSysRoleMembObj obj;
			Iterator<ISecureSecSysRoleMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSysRoleMembObj> cmp = new Comparator<ISecureSecSysRoleMembObj>() {
			@Override
			public int compare( ISecureSecSysRoleMembObj lhs, ISecureSecSysRoleMembObj rhs ) {
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
					ISecureSecSysRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> readCachedSecSysRoleMembByLoginIdx( String LoginId )
	{
		final String S_ProcName = "readCachedSecSysRoleMembByLoginIdx";
		ISecureSecSysRoleMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ArrayList<ISecureSecSysRoleMembObj> arrayList = new ArrayList<ISecureSecSysRoleMembObj>();
		if( indexByLoginIdx != null ) {
			Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> dict;
			if( indexByLoginIdx.containsKey( key ) ) {
				dict = indexByLoginIdx.get( key );
				int len = dict.size();
				ISecureSecSysRoleMembObj arr[] = new ISecureSecSysRoleMembObj[len];
				Iterator<ISecureSecSysRoleMembObj> valIter = dict.values().iterator();
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
			ISecureSecSysRoleMembObj obj;
			Iterator<ISecureSecSysRoleMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSysRoleMembObj> cmp = new Comparator<ISecureSecSysRoleMembObj>() {
			@Override
			public int compare( ISecureSecSysRoleMembObj lhs, ISecureSecSysRoleMembObj rhs ) {
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
					ISecureSecSysRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeSecSysRoleMembByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String LoginId )
	{
		ISecureSecSysRoleMembObj obj = readCachedSecSysRoleMembByIdIdx( SecSysRoleId,
				LoginId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecSysRoleMembBySysRoleIdx( IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "deepDisposeSecSysRoleMembBySysRoleIdx";
		ISecureSecSysRoleMembObj obj;
		List<ISecureSecSysRoleMembObj> arrayList = readCachedSecSysRoleMembBySysRoleIdx( SecSysRoleId );
		if( arrayList != null )  {
			Iterator<ISecureSecSysRoleMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecSysRoleMembByLoginIdx( String LoginId )
	{
		final String S_ProcName = "deepDisposeSecSysRoleMembByLoginIdx";
		ISecureSecSysRoleMembObj obj;
		List<ISecureSecSysRoleMembObj> arrayList = readCachedSecSysRoleMembByLoginIdx( LoginId );
		if( arrayList != null )  {
			Iterator<ISecureSecSysRoleMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecSysRoleMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SysRoleIdx key attributes.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSysRoleMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecSysRoleMembObj> pageSecSysRoleMembBySysRoleIdx( IYCFKeyHash256 SecSysRoleId,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecSysRoleMembBySysRoleIdx";
		ISecureSecSysRoleMembBySysRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( SecSysRoleId );
		List<ISecureSecSysRoleMembObj> retList = new LinkedList<ISecureSecSysRoleMembObj>();
		ISecureSecSysRoleMembObj obj;
		ISecureSecSysRoleMemb[] recList = schema.getSecureBackingStore().getTableSecSysRoleMemb().pageRecBySysRoleIdx( null,
				SecSysRoleId,
			priorSecSysRoleId,
			priorLoginId );
		ISecureSecSysRoleMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecSysRoleMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecSysRoleMembObj realised = (ISecureSecSysRoleMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecSysRoleMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate LoginIdx key attributes.
	 *
	 *	@param	LoginId	The SecSysRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSysRoleMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecSysRoleMembObj> pageSecSysRoleMembByLoginIdx( String LoginId,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecSysRoleMembByLoginIdx";
		ISecureSecSysRoleMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		List<ISecureSecSysRoleMembObj> retList = new LinkedList<ISecureSecSysRoleMembObj>();
		ISecureSecSysRoleMembObj obj;
		ISecureSecSysRoleMemb[] recList = schema.getSecureBackingStore().getTableSecSysRoleMemb().pageRecByLoginIdx( null,
				LoginId,
			priorSecSysRoleId,
			priorLoginId );
		ISecureSecSysRoleMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecSysRoleMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecSysRoleMembObj realised = (ISecureSecSysRoleMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecSysRoleMembObj updateSecSysRoleMemb( ISecureSecSysRoleMembObj Obj ) {
		ISecureSecSysRoleMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysRoleMemb().updateSecSysRoleMemb( null,
			Obj.getSecSysRoleMembRec() );
		obj = (ISecureSecSysRoleMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecSysRoleMemb( ISecureSecSysRoleMembObj Obj ) {
		ISecureSecSysRoleMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysRoleMemb().deleteSecSysRoleMemb( null,
			obj.getSecSysRoleMembRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecSysRoleMembByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String LoginId )
	{
		ISecureSecSysRoleMembObj obj = readSecSysRoleMemb(SecSysRoleId,
				LoginId);
		if( obj != null ) {
			ISecureSecSysRoleMembEditObj editObj = (ISecureSecSysRoleMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecSysRoleMembEditObj)obj.beginEdit();
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
		deepDisposeSecSysRoleMembByIdIdx( SecSysRoleId,
				LoginId );
	}

	@Override
	public void deleteSecSysRoleMembBySysRoleIdx( IYCFKeyHash256 SecSysRoleId )
	{
		ISecureSecSysRoleMembBySysRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( SecSysRoleId );
		if( indexBySysRoleIdx == null ) {
			indexBySysRoleIdx = new HashMap< ISecureSecSysRoleMembBySysRoleIdxKey,
				Map< ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > >();
		}
		if( indexBySysRoleIdx.containsKey( key ) ) {
			Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> dict = indexBySysRoleIdx.get( key );
			schema.getSecureBackingStore().getTableSecSysRoleMemb().deleteSecSysRoleMembBySysRoleIdx( null,
				SecSysRoleId );
			Iterator<ISecureSecSysRoleMembObj> iter = dict.values().iterator();
			ISecureSecSysRoleMembObj obj;
			List<ISecureSecSysRoleMembObj> toForget = new LinkedList<ISecureSecSysRoleMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySysRoleIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecSysRoleMemb().deleteSecSysRoleMembBySysRoleIdx( null,
				SecSysRoleId );
		}
		deepDisposeSecSysRoleMembBySysRoleIdx( SecSysRoleId );
	}

	@Override
	public void deleteSecSysRoleMembByLoginIdx( String LoginId )
	{
		ISecureSecSysRoleMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		if( indexByLoginIdx == null ) {
			indexByLoginIdx = new HashMap< ISecureSecSysRoleMembByLoginIdxKey,
				Map< ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj > >();
		}
		if( indexByLoginIdx.containsKey( key ) ) {
			Map<ISecureSecSysRoleMembPKey, ISecureSecSysRoleMembObj> dict = indexByLoginIdx.get( key );
			schema.getSecureBackingStore().getTableSecSysRoleMemb().deleteSecSysRoleMembByLoginIdx( null,
				LoginId );
			Iterator<ISecureSecSysRoleMembObj> iter = dict.values().iterator();
			ISecureSecSysRoleMembObj obj;
			List<ISecureSecSysRoleMembObj> toForget = new LinkedList<ISecureSecSysRoleMembObj>();
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
			schema.getSecureBackingStore().getTableSecSysRoleMemb().deleteSecSysRoleMembByLoginIdx( null,
				LoginId );
		}
		deepDisposeSecSysRoleMembByLoginIdx( LoginId );
	}
}