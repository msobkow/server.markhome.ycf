// Description: Java 25 Table Object implementation for SecClusRoleMemb.

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

public class BusModelSecClusRoleMembTableObj
	implements IBusModelSecClusRoleMembTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> members;
	private Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> allSecClusRoleMemb;
	private Map< ISecureSecClusRoleMembByClusRoleIdxKey,
		Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > > indexByClusRoleIdx;
	private Map< ISecureSecClusRoleMembByLoginIdxKey,
		Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > > indexByLoginIdx;
	public static String TABLE_NAME = "SecClusRoleMemb";
	public static String TABLE_DBNAME = "secclusrolememb";

	public BusModelSecClusRoleMembTableObj() {
		schema = null;
		members = new HashMap<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj>();
		allSecClusRoleMemb = null;
		indexByClusRoleIdx = null;
		indexByLoginIdx = null;
	}

	public BusModelSecClusRoleMembTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj>();
		allSecClusRoleMemb = null;
		indexByClusRoleIdx = null;
		indexByLoginIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecClusRoleMembTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecClusRoleMembTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecClusRoleMembTableObj.getRuntimeClassCode() );
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
		allSecClusRoleMemb = null;
		indexByClusRoleIdx = null;
		indexByLoginIdx = null;
		List<ISecureSecClusRoleMembObj> toForget = new LinkedList<ISecureSecClusRoleMembObj>();
		ISecureSecClusRoleMembObj cur = null;
		Iterator<ISecureSecClusRoleMembObj> iter = members.values().iterator();
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
	 *	BusModelSecClusRoleMembObj.
	 */
	@Override
	public ISecureSecClusRoleMembObj newInstance() {
		ISecureSecClusRoleMembObj inst = new BusModelSecClusRoleMembObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecClusRoleMembObj.
	 */
	@Override
	public ISecureSecClusRoleMembEditObj newEditInstance( ISecureSecClusRoleMembObj orig ) {
		ISecureSecClusRoleMembEditObj edit = new BusModelSecClusRoleMembEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecClusRoleMembObj constructByClassCode( int backingClassCode ) {
		ISecureSecClusRoleMembObj obj = null;
		if( backingClassCode == ISecureSecClusRoleMemb.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecClusRoleMembTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecClusRoleMembObj realiseSecClusRoleMemb( ISecureSecClusRoleMembObj Obj ) {
		ISecureSecClusRoleMembObj obj = Obj;
		ISecureSecClusRoleMembPKey pkey = obj.getPKey();
		ISecureSecClusRoleMembObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecClusRoleMembObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusRoleIdx != null ) {
				ISecureSecClusRoleMembByClusRoleIdxKey keyClusRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
				keyClusRoleIdx.setRequiredSecClusRoleId( keepObj.getRequiredSecClusRoleId() );
				Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > mapClusRoleIdx = indexByClusRoleIdx.get( keyClusRoleIdx );
				if( mapClusRoleIdx != null ) {
					mapClusRoleIdx.remove( keepObj.getPKey() );
					if( mapClusRoleIdx.size() <= 0 ) {
						indexByClusRoleIdx.remove( keyClusRoleIdx );
					}
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecClusRoleMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.remove( keepObj.getPKey() );
					if( mapLoginIdx.size() <= 0 ) {
						indexByLoginIdx.remove( keyLoginIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusRoleIdx != null ) {
				ISecureSecClusRoleMembByClusRoleIdxKey keyClusRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
				keyClusRoleIdx.setRequiredSecClusRoleId( keepObj.getRequiredSecClusRoleId() );
				Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > mapClusRoleIdx = indexByClusRoleIdx.get( keyClusRoleIdx );
				if( mapClusRoleIdx != null ) {
					mapClusRoleIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecClusRoleMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecClusRoleMemb != null ) {
				allSecClusRoleMemb.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecClusRoleMemb != null ) {
				allSecClusRoleMemb.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusRoleIdx != null ) {
				ISecureSecClusRoleMembByClusRoleIdxKey keyClusRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
				keyClusRoleIdx.setRequiredSecClusRoleId( keepObj.getRequiredSecClusRoleId() );
				Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > mapClusRoleIdx = indexByClusRoleIdx.get( keyClusRoleIdx );
				if( mapClusRoleIdx != null ) {
					mapClusRoleIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLoginIdx != null ) {
				ISecureSecClusRoleMembByLoginIdxKey keyLoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
				keyLoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > mapLoginIdx = indexByLoginIdx.get( keyLoginIdx );
				if( mapLoginIdx != null ) {
					mapLoginIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecClusRoleMembObj createSecClusRoleMemb( ISecureSecClusRoleMembObj Obj ) {
		ISecureSecClusRoleMembObj obj = Obj;
		ISecureSecClusRoleMemb rec = obj.getSecClusRoleMembRec();
		schema.getSecureBackingStore().getTableSecClusRoleMemb().createSecClusRoleMemb(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecClusRoleMembObj readSecClusRoleMemb( ISecureSecClusRoleMembPKey pkey ) {
		return( readSecClusRoleMemb( pkey, false ) );
	}

	@Override
	public ISecureSecClusRoleMembObj readSecClusRoleMemb( ISecureSecClusRoleMembPKey pkey, boolean forceRead ) {
		ISecureSecClusRoleMembObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecClusRoleMemb readRec = schema.getSecureBackingStore().getTableSecClusRoleMemb().readDerivedByIdIdx( null,
						pkey.getRequiredSecClusRoleId(),
						pkey.getRequiredLoginId() );
			if( readRec != null ) {
				obj = schema.getSecClusRoleMembTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecClusRoleMembObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecClusRoleMembObj readSecClusRoleMemb( IYCFKeyHash256 SecClusRoleId,
		String LoginId ) {
		return( readSecClusRoleMemb( SecClusRoleId,
			LoginId, false ) );
	}

	@Override
	public ISecureSecClusRoleMembObj readSecClusRoleMemb( IYCFKeyHash256 SecClusRoleId,
		String LoginId, boolean forceRead ) {
		ISecureSecClusRoleMembObj obj = null;
		ISecureSecClusRoleMemb readRec = schema.getSecureBackingStore().getTableSecClusRoleMemb().readDerivedByIdIdx( null,
			SecClusRoleId,
			LoginId );
		if( readRec != null ) {
				obj = schema.getSecClusRoleMembTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureSecClusRoleMembObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureSecClusRoleMembObj readCachedSecClusRoleMemb( ISecureSecClusRoleMembPKey pkey ) {
		ISecureSecClusRoleMembObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecClusRoleMemb( ISecureSecClusRoleMembObj obj )
	{
		final String S_ProcName = "BusModelSecClusRoleMembTableObj.reallyDeepDisposeSecClusRoleMemb() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureSecClusRoleMembPKey pkey = obj.getPKey();
		ISecureSecClusRoleMembObj existing = readCachedSecClusRoleMemb( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecClusRoleMembByClusRoleIdxKey keyClusRoleIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		keyClusRoleIdx.setRequiredSecClusRoleId( existing.getRequiredSecClusRoleId() );

		ISecureSecClusRoleMembByLoginIdxKey keyLoginIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		keyLoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );



		if( indexByClusRoleIdx != null ) {
			if( indexByClusRoleIdx.containsKey( keyClusRoleIdx ) ) {
				indexByClusRoleIdx.get( keyClusRoleIdx ).remove( pkey );
				if( indexByClusRoleIdx.get( keyClusRoleIdx ).size() <= 0 ) {
					indexByClusRoleIdx.remove( keyClusRoleIdx );
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
	public void deepDisposeSecClusRoleMemb( ISecureSecClusRoleMembPKey pkey ) {
		ISecureSecClusRoleMembObj obj = readCachedSecClusRoleMemb( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecClusRoleMembObj lockSecClusRoleMemb( ISecureSecClusRoleMembPKey pkey ) {
		ISecureSecClusRoleMembObj locked = null;
		ISecureSecClusRoleMemb lockRec = schema.getSecureBackingStore().getTableSecClusRoleMemb().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecClusRoleMembTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecClusRoleMembObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecClusRoleMemb", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> readAllSecClusRoleMemb() {
		return( readAllSecClusRoleMemb( false ) );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> readAllSecClusRoleMemb( boolean forceRead ) {
		final String S_ProcName = "readAllSecClusRoleMemb";
		if( ( allSecClusRoleMemb == null ) || forceRead ) {
			Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> map = new HashMap<ISecureSecClusRoleMembPKey,ISecureSecClusRoleMembObj>();
			allSecClusRoleMemb = map;
			ISecureSecClusRoleMemb[] recList = schema.getSecureBackingStore().getTableSecClusRoleMemb().readAllDerived( null );
			ISecureSecClusRoleMemb rec;
			ISecureSecClusRoleMembObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusRoleMembObj realised = (ISecureSecClusRoleMembObj)obj.realise();
			}
		}
		int len = allSecClusRoleMemb.size();
		ISecureSecClusRoleMembObj arr[] = new ISecureSecClusRoleMembObj[len];
		Iterator<ISecureSecClusRoleMembObj> valIter = allSecClusRoleMemb.values().iterator();
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
		ArrayList<ISecureSecClusRoleMembObj> arrayList = new ArrayList<ISecureSecClusRoleMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusRoleMembObj> cmp = new Comparator<ISecureSecClusRoleMembObj>() {
			@Override
			public int compare( ISecureSecClusRoleMembObj lhs, ISecureSecClusRoleMembObj rhs ) {
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
					ISecureSecClusRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecClusRoleMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> readCachedAllSecClusRoleMemb() {
		final String S_ProcName = "readCachedAllSecClusRoleMemb";
		ArrayList<ISecureSecClusRoleMembObj> arrayList = new ArrayList<ISecureSecClusRoleMembObj>();
		if( allSecClusRoleMemb != null ) {
			int len = allSecClusRoleMemb.size();
			ISecureSecClusRoleMembObj arr[] = new ISecureSecClusRoleMembObj[len];
			Iterator<ISecureSecClusRoleMembObj> valIter = allSecClusRoleMemb.values().iterator();
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
		Comparator<ISecureSecClusRoleMembObj> cmp = new Comparator<ISecureSecClusRoleMembObj>() {
			public int compare( ISecureSecClusRoleMembObj lhs, ISecureSecClusRoleMembObj rhs ) {
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
					ISecureSecClusRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	/**
	 *	Return a sorted map of a page of the SecClusRoleMemb-derived instances in the database.
	 *
	 *	@return	List of ISecureSecClusRoleMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecClusRoleMembObj> pageAllSecClusRoleMemb(IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageAllSecClusRoleMemb";
		Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> map = new HashMap<ISecureSecClusRoleMembPKey,ISecureSecClusRoleMembObj>();
		ISecureSecClusRoleMemb[] recList = schema.getSecureBackingStore().getTableSecClusRoleMemb().pageAllRec( null,
			priorSecClusRoleId,
			priorLoginId );
		ISecureSecClusRoleMemb rec;
		ISecureSecClusRoleMembObj obj;
		ISecureSecClusRoleMembObj realised;
		ArrayList<ISecureSecClusRoleMembObj> arrayList = new ArrayList<ISecureSecClusRoleMembObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecClusRoleMembObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecClusRoleMembObj readSecClusRoleMembByIdIdx( IYCFKeyHash256 SecClusRoleId,
		String LoginId )
	{
		return( readSecClusRoleMembByIdIdx( SecClusRoleId,
			LoginId,
			false ) );
	}

	@Override
	public ISecureSecClusRoleMembObj readSecClusRoleMembByIdIdx( IYCFKeyHash256 SecClusRoleId,
		String LoginId, boolean forceRead )
	{
		ISecureSecClusRoleMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newPKey();
		pkey.setRequiredSecClusRoleId( SecClusRoleId );
		pkey.setRequiredLoginId( LoginId );
		ISecureSecClusRoleMembObj obj = readSecClusRoleMemb( pkey, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> readSecClusRoleMembByClusRoleIdx( IYCFKeyHash256 SecClusRoleId )
	{
		return( readSecClusRoleMembByClusRoleIdx( SecClusRoleId,
			false ) );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> readSecClusRoleMembByClusRoleIdx( IYCFKeyHash256 SecClusRoleId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecClusRoleMembByClusRoleIdx";
		ISecureSecClusRoleMembByClusRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		key.setRequiredSecClusRoleId( SecClusRoleId );
		Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> dict;
		if( indexByClusRoleIdx == null ) {
			indexByClusRoleIdx = new HashMap< ISecureSecClusRoleMembByClusRoleIdxKey,
				Map< ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > >();
		}
		if( ( ! forceRead ) && indexByClusRoleIdx.containsKey( key ) ) {
			dict = indexByClusRoleIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj>();
			ISecureSecClusRoleMembObj obj;
			ISecureSecClusRoleMemb[] recList = schema.getSecureBackingStore().getTableSecClusRoleMemb().readDerivedByClusRoleIdx( null,
				SecClusRoleId );
			ISecureSecClusRoleMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecClusRoleMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusRoleMembObj realised = (ISecureSecClusRoleMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusRoleIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecClusRoleMembObj arr[] = new ISecureSecClusRoleMembObj[len];
		Iterator<ISecureSecClusRoleMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecClusRoleMembObj> arrayList = new ArrayList<ISecureSecClusRoleMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusRoleMembObj> cmp = new Comparator<ISecureSecClusRoleMembObj>() {
			@Override
			public int compare( ISecureSecClusRoleMembObj lhs, ISecureSecClusRoleMembObj rhs ) {
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
					ISecureSecClusRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecClusRoleMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> readSecClusRoleMembByLoginIdx( String LoginId )
	{
		return( readSecClusRoleMembByLoginIdx( LoginId,
			false ) );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> readSecClusRoleMembByLoginIdx( String LoginId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecClusRoleMembByLoginIdx";
		ISecureSecClusRoleMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> dict;
		if( indexByLoginIdx == null ) {
			indexByLoginIdx = new HashMap< ISecureSecClusRoleMembByLoginIdxKey,
				Map< ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > >();
		}
		if( ( ! forceRead ) && indexByLoginIdx.containsKey( key ) ) {
			dict = indexByLoginIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj>();
			ISecureSecClusRoleMembObj obj;
			ISecureSecClusRoleMemb[] recList = schema.getSecureBackingStore().getTableSecClusRoleMemb().readDerivedByLoginIdx( null,
				LoginId );
			ISecureSecClusRoleMemb rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecClusRoleMembTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusRoleMembObj realised = (ISecureSecClusRoleMembObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLoginIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecClusRoleMembObj arr[] = new ISecureSecClusRoleMembObj[len];
		Iterator<ISecureSecClusRoleMembObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecClusRoleMembObj> arrayList = new ArrayList<ISecureSecClusRoleMembObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusRoleMembObj> cmp = new Comparator<ISecureSecClusRoleMembObj>() {
			@Override
			public int compare( ISecureSecClusRoleMembObj lhs, ISecureSecClusRoleMembObj rhs ) {
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
					ISecureSecClusRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecClusRoleMembObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecClusRoleMembObj readCachedSecClusRoleMembByIdIdx( IYCFKeyHash256 SecClusRoleId,
		String LoginId )
	{
		ISecureSecClusRoleMembObj obj = null;
		ISecureSecClusRoleMembPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newPKey();
		pkey.setRequiredSecClusRoleId( SecClusRoleId );
		pkey.setRequiredLoginId( LoginId );
		pkey.setRequiredSecClusRoleId( SecClusRoleId );
		pkey.setRequiredLoginId( LoginId );
		obj = readCachedSecClusRoleMemb( pkey );
		return( obj );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> readCachedSecClusRoleMembByClusRoleIdx( IYCFKeyHash256 SecClusRoleId )
	{
		final String S_ProcName = "readCachedSecClusRoleMembByClusRoleIdx";
		ISecureSecClusRoleMembByClusRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		key.setRequiredSecClusRoleId( SecClusRoleId );
		ArrayList<ISecureSecClusRoleMembObj> arrayList = new ArrayList<ISecureSecClusRoleMembObj>();
		if( indexByClusRoleIdx != null ) {
			Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> dict;
			if( indexByClusRoleIdx.containsKey( key ) ) {
				dict = indexByClusRoleIdx.get( key );
				int len = dict.size();
				ISecureSecClusRoleMembObj arr[] = new ISecureSecClusRoleMembObj[len];
				Iterator<ISecureSecClusRoleMembObj> valIter = dict.values().iterator();
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
			ISecureSecClusRoleMembObj obj;
			Iterator<ISecureSecClusRoleMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecClusRoleMembObj> cmp = new Comparator<ISecureSecClusRoleMembObj>() {
			@Override
			public int compare( ISecureSecClusRoleMembObj lhs, ISecureSecClusRoleMembObj rhs ) {
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
					ISecureSecClusRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> readCachedSecClusRoleMembByLoginIdx( String LoginId )
	{
		final String S_ProcName = "readCachedSecClusRoleMembByLoginIdx";
		ISecureSecClusRoleMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ArrayList<ISecureSecClusRoleMembObj> arrayList = new ArrayList<ISecureSecClusRoleMembObj>();
		if( indexByLoginIdx != null ) {
			Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> dict;
			if( indexByLoginIdx.containsKey( key ) ) {
				dict = indexByLoginIdx.get( key );
				int len = dict.size();
				ISecureSecClusRoleMembObj arr[] = new ISecureSecClusRoleMembObj[len];
				Iterator<ISecureSecClusRoleMembObj> valIter = dict.values().iterator();
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
			ISecureSecClusRoleMembObj obj;
			Iterator<ISecureSecClusRoleMembObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecClusRoleMembObj> cmp = new Comparator<ISecureSecClusRoleMembObj>() {
			@Override
			public int compare( ISecureSecClusRoleMembObj lhs, ISecureSecClusRoleMembObj rhs ) {
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
					ISecureSecClusRoleMembPKey lhsPKey = lhs.getPKey();
					ISecureSecClusRoleMembPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeSecClusRoleMembByIdIdx( IYCFKeyHash256 SecClusRoleId,
		String LoginId )
	{
		ISecureSecClusRoleMembObj obj = readCachedSecClusRoleMembByIdIdx( SecClusRoleId,
				LoginId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecClusRoleMembByClusRoleIdx( IYCFKeyHash256 SecClusRoleId )
	{
		final String S_ProcName = "deepDisposeSecClusRoleMembByClusRoleIdx";
		ISecureSecClusRoleMembObj obj;
		List<ISecureSecClusRoleMembObj> arrayList = readCachedSecClusRoleMembByClusRoleIdx( SecClusRoleId );
		if( arrayList != null )  {
			Iterator<ISecureSecClusRoleMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecClusRoleMembByLoginIdx( String LoginId )
	{
		final String S_ProcName = "deepDisposeSecClusRoleMembByLoginIdx";
		ISecureSecClusRoleMembObj obj;
		List<ISecureSecClusRoleMembObj> arrayList = readCachedSecClusRoleMembByLoginIdx( LoginId );
		if( arrayList != null )  {
			Iterator<ISecureSecClusRoleMembObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecClusRoleMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusRoleIdx key attributes.
	 *
	 *	@param	SecClusRoleId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecClusRoleMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecClusRoleMembObj> pageSecClusRoleMembByClusRoleIdx( IYCFKeyHash256 SecClusRoleId,
		IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecClusRoleMembByClusRoleIdx";
		ISecureSecClusRoleMembByClusRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		key.setRequiredSecClusRoleId( SecClusRoleId );
		List<ISecureSecClusRoleMembObj> retList = new LinkedList<ISecureSecClusRoleMembObj>();
		ISecureSecClusRoleMembObj obj;
		ISecureSecClusRoleMemb[] recList = schema.getSecureBackingStore().getTableSecClusRoleMemb().pageRecByClusRoleIdx( null,
				SecClusRoleId,
			priorSecClusRoleId,
			priorLoginId );
		ISecureSecClusRoleMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecClusRoleMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecClusRoleMembObj realised = (ISecureSecClusRoleMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecClusRoleMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate LoginIdx key attributes.
	 *
	 *	@param	LoginId	The SecClusRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecClusRoleMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecClusRoleMembObj> pageSecClusRoleMembByLoginIdx( String LoginId,
		IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId )
	{
		final String S_ProcName = "pageSecClusRoleMembByLoginIdx";
		ISecureSecClusRoleMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		List<ISecureSecClusRoleMembObj> retList = new LinkedList<ISecureSecClusRoleMembObj>();
		ISecureSecClusRoleMembObj obj;
		ISecureSecClusRoleMemb[] recList = schema.getSecureBackingStore().getTableSecClusRoleMemb().pageRecByLoginIdx( null,
				LoginId,
			priorSecClusRoleId,
			priorLoginId );
		ISecureSecClusRoleMemb rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecClusRoleMembTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecClusRoleMembObj realised = (ISecureSecClusRoleMembObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecClusRoleMembObj updateSecClusRoleMemb( ISecureSecClusRoleMembObj Obj ) {
		ISecureSecClusRoleMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecClusRoleMemb().updateSecClusRoleMemb( null,
			Obj.getSecClusRoleMembRec() );
		obj = (ISecureSecClusRoleMembObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecClusRoleMemb( ISecureSecClusRoleMembObj Obj ) {
		ISecureSecClusRoleMembObj obj = Obj;
		schema.getSecureBackingStore().getTableSecClusRoleMemb().deleteSecClusRoleMemb( null,
			obj.getSecClusRoleMembRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecClusRoleMembByIdIdx( IYCFKeyHash256 SecClusRoleId,
		String LoginId )
	{
		ISecureSecClusRoleMembObj obj = readSecClusRoleMemb(SecClusRoleId,
				LoginId);
		if( obj != null ) {
			ISecureSecClusRoleMembEditObj editObj = (ISecureSecClusRoleMembEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecClusRoleMembEditObj)obj.beginEdit();
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
		deepDisposeSecClusRoleMembByIdIdx( SecClusRoleId,
				LoginId );
	}

	@Override
	public void deleteSecClusRoleMembByClusRoleIdx( IYCFKeyHash256 SecClusRoleId )
	{
		ISecureSecClusRoleMembByClusRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByClusRoleIdxKey();
		key.setRequiredSecClusRoleId( SecClusRoleId );
		if( indexByClusRoleIdx == null ) {
			indexByClusRoleIdx = new HashMap< ISecureSecClusRoleMembByClusRoleIdxKey,
				Map< ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > >();
		}
		if( indexByClusRoleIdx.containsKey( key ) ) {
			Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> dict = indexByClusRoleIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusRoleMemb().deleteSecClusRoleMembByClusRoleIdx( null,
				SecClusRoleId );
			Iterator<ISecureSecClusRoleMembObj> iter = dict.values().iterator();
			ISecureSecClusRoleMembObj obj;
			List<ISecureSecClusRoleMembObj> toForget = new LinkedList<ISecureSecClusRoleMembObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByClusRoleIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecClusRoleMemb().deleteSecClusRoleMembByClusRoleIdx( null,
				SecClusRoleId );
		}
		deepDisposeSecClusRoleMembByClusRoleIdx( SecClusRoleId );
	}

	@Override
	public void deleteSecClusRoleMembByLoginIdx( String LoginId )
	{
		ISecureSecClusRoleMembByLoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRoleMemb().newByLoginIdxKey();
		key.setRequiredLoginId( LoginId );
		if( indexByLoginIdx == null ) {
			indexByLoginIdx = new HashMap< ISecureSecClusRoleMembByLoginIdxKey,
				Map< ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj > >();
		}
		if( indexByLoginIdx.containsKey( key ) ) {
			Map<ISecureSecClusRoleMembPKey, ISecureSecClusRoleMembObj> dict = indexByLoginIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusRoleMemb().deleteSecClusRoleMembByLoginIdx( null,
				LoginId );
			Iterator<ISecureSecClusRoleMembObj> iter = dict.values().iterator();
			ISecureSecClusRoleMembObj obj;
			List<ISecureSecClusRoleMembObj> toForget = new LinkedList<ISecureSecClusRoleMembObj>();
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
			schema.getSecureBackingStore().getTableSecClusRoleMemb().deleteSecClusRoleMembByLoginIdx( null,
				LoginId );
		}
		deepDisposeSecClusRoleMembByLoginIdx( LoginId );
	}
}