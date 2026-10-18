// Description: Java 25 Table Object implementation for SecUserPWHistory.

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

public class BusModelSecUserPWHistoryTableObj
	implements IBusModelSecUserPWHistoryTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureSecUserPWHistoryPKey, ISecureSecUserPWHistoryObj> members;
	private Map<ISecureSecUserPWHistoryPKey, ISecureSecUserPWHistoryObj> allSecUserPWHistory;
	private Map< ISecureSecUserPWHistoryByUserIdxKey,
		ISecureSecUserPWHistoryObj > indexByUserIdx;
	private Map< ISecureSecUserPWHistoryBySetStampIdxKey,
		ISecureSecUserPWHistoryObj > indexBySetStampIdx;
	private Map< ISecureSecUserPWHistoryByReplacedStampIdxKey,
		ISecureSecUserPWHistoryObj > indexByReplacedStampIdx;
	public static String TABLE_NAME = "SecUserPWHistory";
	public static String TABLE_DBNAME = "secuserpwhistory";

	public BusModelSecUserPWHistoryTableObj() {
		schema = null;
		members = new HashMap<ISecureSecUserPWHistoryPKey, ISecureSecUserPWHistoryObj>();
		allSecUserPWHistory = null;
		indexByUserIdx = null;
		indexBySetStampIdx = null;
		indexByReplacedStampIdx = null;
	}

	public BusModelSecUserPWHistoryTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureSecUserPWHistoryPKey, ISecureSecUserPWHistoryObj>();
		allSecUserPWHistory = null;
		indexByUserIdx = null;
		indexBySetStampIdx = null;
		indexByReplacedStampIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecUserPWHistoryTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecUserPWHistoryTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecUserPWHistoryTableObj.getRuntimeClassCode() );
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
		allSecUserPWHistory = null;
		indexByUserIdx = null;
		indexBySetStampIdx = null;
		indexByReplacedStampIdx = null;
		List<ISecureSecUserPWHistoryObj> toForget = new LinkedList<ISecureSecUserPWHistoryObj>();
		ISecureSecUserPWHistoryObj cur = null;
		Iterator<ISecureSecUserPWHistoryObj> iter = members.values().iterator();
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
	 *	BusModelSecUserPWHistoryObj.
	 */
	@Override
	public ISecureSecUserPWHistoryObj newInstance() {
		ISecureSecUserPWHistoryObj inst = new BusModelSecUserPWHistoryObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecUserPWHistoryObj.
	 */
	@Override
	public ISecureSecUserPWHistoryEditObj newEditInstance( ISecureSecUserPWHistoryObj orig ) {
		ISecureSecUserPWHistoryEditObj edit = new BusModelSecUserPWHistoryEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecUserPWHistoryObj constructByClassCode( int backingClassCode ) {
		ISecureSecUserPWHistoryObj obj = null;
		if( backingClassCode == ISecureSecUserPWHistory.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecUserPWHistoryTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPWHistoryObj realiseSecUserPWHistory( ISecureSecUserPWHistoryObj Obj ) {
		ISecureSecUserPWHistoryObj obj = Obj;
		ISecureSecUserPWHistoryPKey pkey = obj.getPKey();
		ISecureSecUserPWHistoryObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecUserPWHistoryObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUserIdx != null ) {
				ISecureSecUserPWHistoryByUserIdxKey keyUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUserIdx.remove( keyUserIdx );
			}

			if( indexBySetStampIdx != null ) {
				ISecureSecUserPWHistoryBySetStampIdxKey keySetStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
				keySetStampIdx.setRequiredPWSetStamp( keepObj.getRequiredPWSetStamp() );
				indexBySetStampIdx.remove( keySetStampIdx );
			}

			if( indexByReplacedStampIdx != null ) {
				ISecureSecUserPWHistoryByReplacedStampIdxKey keyReplacedStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
				keyReplacedStampIdx.setRequiredPWReplacedStamp( keepObj.getRequiredPWReplacedStamp() );
				indexByReplacedStampIdx.remove( keyReplacedStampIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUserIdx != null ) {
				ISecureSecUserPWHistoryByUserIdxKey keyUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUserIdx.put( keyUserIdx, keepObj );
			}

			if( indexBySetStampIdx != null ) {
				ISecureSecUserPWHistoryBySetStampIdxKey keySetStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
				keySetStampIdx.setRequiredPWSetStamp( keepObj.getRequiredPWSetStamp() );
				indexBySetStampIdx.put( keySetStampIdx, keepObj );
			}

			if( indexByReplacedStampIdx != null ) {
				ISecureSecUserPWHistoryByReplacedStampIdxKey keyReplacedStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
				keyReplacedStampIdx.setRequiredPWReplacedStamp( keepObj.getRequiredPWReplacedStamp() );
				indexByReplacedStampIdx.put( keyReplacedStampIdx, keepObj );
			}

			if( allSecUserPWHistory != null ) {
				allSecUserPWHistory.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecUserPWHistory != null ) {
				allSecUserPWHistory.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUserIdx != null ) {
				ISecureSecUserPWHistoryByUserIdxKey keyUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByUserIdxKey();
				keyUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				indexByUserIdx.put( keyUserIdx, keepObj );
			}

			if( indexBySetStampIdx != null ) {
				ISecureSecUserPWHistoryBySetStampIdxKey keySetStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
				keySetStampIdx.setRequiredPWSetStamp( keepObj.getRequiredPWSetStamp() );
				indexBySetStampIdx.put( keySetStampIdx, keepObj );
			}

			if( indexByReplacedStampIdx != null ) {
				ISecureSecUserPWHistoryByReplacedStampIdxKey keyReplacedStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
				keyReplacedStampIdx.setRequiredPWReplacedStamp( keepObj.getRequiredPWReplacedStamp() );
				indexByReplacedStampIdx.put( keyReplacedStampIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecUserPWHistoryObj createSecUserPWHistory( ISecureSecUserPWHistoryObj Obj ) {
		ISecureSecUserPWHistoryObj obj = Obj;
		ISecureSecUserPWHistory rec = obj.getSecUserPWHistoryRec();
		schema.getSecureBackingStore().getTableSecUserPWHistory().createSecUserPWHistory(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistory( ISecureSecUserPWHistoryPKey pkey ) {
		return( readSecUserPWHistory( pkey, false ) );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistory( ISecureSecUserPWHistoryPKey pkey, boolean forceRead ) {
		ISecureSecUserPWHistoryObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecUserPWHistory readRec = schema.getSecureBackingStore().getTableSecUserPWHistory().readDerivedByIdIdx( null,
						pkey.getRequiredSecUserId(),
						pkey.getRequiredPWSetStamp() );
			if( readRec != null ) {
				obj = schema.getSecUserPWHistoryTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecUserPWHistoryObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistory( IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp ) {
		return( readSecUserPWHistory( SecUserId,
			PWSetStamp, false ) );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistory( IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp, boolean forceRead ) {
		ISecureSecUserPWHistoryObj obj = null;
		ISecureSecUserPWHistory readRec = schema.getSecureBackingStore().getTableSecUserPWHistory().readDerivedByIdIdx( null,
			SecUserId,
			PWSetStamp );
		if( readRec != null ) {
				obj = schema.getSecUserPWHistoryTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureSecUserPWHistoryObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPWHistoryObj readCachedSecUserPWHistory( ISecureSecUserPWHistoryPKey pkey ) {
		ISecureSecUserPWHistoryObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecUserPWHistory( ISecureSecUserPWHistoryObj obj )
	{
		final String S_ProcName = "BusModelSecUserPWHistoryTableObj.reallyDeepDisposeSecUserPWHistory() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureSecUserPWHistoryPKey pkey = obj.getPKey();
		ISecureSecUserPWHistoryObj existing = readCachedSecUserPWHistory( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecUserPWHistoryByUserIdxKey keyUserIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByUserIdxKey();
		keyUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		ISecureSecUserPWHistoryBySetStampIdxKey keySetStampIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
		keySetStampIdx.setRequiredPWSetStamp( existing.getRequiredPWSetStamp() );

		ISecureSecUserPWHistoryByReplacedStampIdxKey keyReplacedStampIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
		keyReplacedStampIdx.setRequiredPWReplacedStamp( existing.getRequiredPWReplacedStamp() );



		if( indexByUserIdx != null ) {
			indexByUserIdx.remove( keyUserIdx );
		}

		if( indexBySetStampIdx != null ) {
			indexBySetStampIdx.remove( keySetStampIdx );
		}

		if( indexByReplacedStampIdx != null ) {
			indexByReplacedStampIdx.remove( keyReplacedStampIdx );
		}


	}
	@Override
	public void deepDisposeSecUserPWHistory( ISecureSecUserPWHistoryPKey pkey ) {
		ISecureSecUserPWHistoryObj obj = readCachedSecUserPWHistory( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecUserPWHistoryObj lockSecUserPWHistory( ISecureSecUserPWHistoryPKey pkey ) {
		ISecureSecUserPWHistoryObj locked = null;
		ISecureSecUserPWHistory lockRec = schema.getSecureBackingStore().getTableSecUserPWHistory().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecUserPWHistoryTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecUserPWHistoryObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecUserPWHistory", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecUserPWHistoryObj> readAllSecUserPWHistory() {
		return( readAllSecUserPWHistory( false ) );
	}

	@Override
	public List<ISecureSecUserPWHistoryObj> readAllSecUserPWHistory( boolean forceRead ) {
		final String S_ProcName = "readAllSecUserPWHistory";
		if( ( allSecUserPWHistory == null ) || forceRead ) {
			Map<ISecureSecUserPWHistoryPKey, ISecureSecUserPWHistoryObj> map = new HashMap<ISecureSecUserPWHistoryPKey,ISecureSecUserPWHistoryObj>();
			allSecUserPWHistory = map;
			ISecureSecUserPWHistory[] recList = schema.getSecureBackingStore().getTableSecUserPWHistory().readAllDerived( null );
			ISecureSecUserPWHistory rec;
			ISecureSecUserPWHistoryObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserPWHistoryObj realised = (ISecureSecUserPWHistoryObj)obj.realise();
			}
		}
		int len = allSecUserPWHistory.size();
		ISecureSecUserPWHistoryObj arr[] = new ISecureSecUserPWHistoryObj[len];
		Iterator<ISecureSecUserPWHistoryObj> valIter = allSecUserPWHistory.values().iterator();
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
		ArrayList<ISecureSecUserPWHistoryObj> arrayList = new ArrayList<ISecureSecUserPWHistoryObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserPWHistoryObj> cmp = new Comparator<ISecureSecUserPWHistoryObj>() {
			@Override
			public int compare( ISecureSecUserPWHistoryObj lhs, ISecureSecUserPWHistoryObj rhs ) {
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
					ISecureSecUserPWHistoryPKey lhsPKey = lhs.getPKey();
					ISecureSecUserPWHistoryPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecUserPWHistoryObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecUserPWHistoryObj> readCachedAllSecUserPWHistory() {
		final String S_ProcName = "readCachedAllSecUserPWHistory";
		ArrayList<ISecureSecUserPWHistoryObj> arrayList = new ArrayList<ISecureSecUserPWHistoryObj>();
		if( allSecUserPWHistory != null ) {
			int len = allSecUserPWHistory.size();
			ISecureSecUserPWHistoryObj arr[] = new ISecureSecUserPWHistoryObj[len];
			Iterator<ISecureSecUserPWHistoryObj> valIter = allSecUserPWHistory.values().iterator();
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
		Comparator<ISecureSecUserPWHistoryObj> cmp = new Comparator<ISecureSecUserPWHistoryObj>() {
			public int compare( ISecureSecUserPWHistoryObj lhs, ISecureSecUserPWHistoryObj rhs ) {
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
					ISecureSecUserPWHistoryPKey lhsPKey = lhs.getPKey();
					ISecureSecUserPWHistoryPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	/**
	 *	Return a sorted map of a page of the SecUserPWHistory-derived instances in the database.
	 *
	 *	@return	List of ISecureSecUserPWHistoryObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecUserPWHistoryObj> pageAllSecUserPWHistory(IYCFKeyHash256 priorSecUserId,
		LocalDateTime priorPWSetStamp )
	{
		final String S_ProcName = "pageAllSecUserPWHistory";
		Map<ISecureSecUserPWHistoryPKey, ISecureSecUserPWHistoryObj> map = new HashMap<ISecureSecUserPWHistoryPKey,ISecureSecUserPWHistoryObj>();
		ISecureSecUserPWHistory[] recList = schema.getSecureBackingStore().getTableSecUserPWHistory().pageAllRec( null,
			priorSecUserId,
			priorPWSetStamp );
		ISecureSecUserPWHistory rec;
		ISecureSecUserPWHistoryObj obj;
		ISecureSecUserPWHistoryObj realised;
		ArrayList<ISecureSecUserPWHistoryObj> arrayList = new ArrayList<ISecureSecUserPWHistoryObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecUserPWHistoryObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistoryByIdIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp )
	{
		return( readSecUserPWHistoryByIdIdx( SecUserId,
			PWSetStamp,
			false ) );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistoryByIdIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp, boolean forceRead )
	{
		ISecureSecUserPWHistoryPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		pkey.setRequiredPWSetStamp( PWSetStamp );
		ISecureSecUserPWHistoryObj obj = readSecUserPWHistory( pkey, forceRead );
		return( obj );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistoryByUserIdx( IYCFKeyHash256 SecUserId )
	{
		return( readSecUserPWHistoryByUserIdx( SecUserId,
			false ) );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistoryByUserIdx( IYCFKeyHash256 SecUserId, boolean forceRead )
	{
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< ISecureSecUserPWHistoryByUserIdxKey,
				ISecureSecUserPWHistoryObj >();
		}
		ISecureSecUserPWHistoryByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		ISecureSecUserPWHistoryObj obj = null;
		if( ( ! forceRead ) && indexByUserIdx.containsKey( key ) ) {
			obj = indexByUserIdx.get( key );
		}
		else {
			ISecureSecUserPWHistory rec = schema.getSecureBackingStore().getTableSecUserPWHistory().readDerivedByUserIdx( null,
				SecUserId );
			if( rec != null ) {
				obj = schema.getSecUserPWHistoryTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecUserPWHistoryObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistoryBySetStampIdx( LocalDateTime PWSetStamp )
	{
		return( readSecUserPWHistoryBySetStampIdx( PWSetStamp,
			false ) );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistoryBySetStampIdx( LocalDateTime PWSetStamp, boolean forceRead )
	{
		if( indexBySetStampIdx == null ) {
			indexBySetStampIdx = new HashMap< ISecureSecUserPWHistoryBySetStampIdxKey,
				ISecureSecUserPWHistoryObj >();
		}
		ISecureSecUserPWHistoryBySetStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
		key.setRequiredPWSetStamp( PWSetStamp );
		ISecureSecUserPWHistoryObj obj = null;
		if( ( ! forceRead ) && indexBySetStampIdx.containsKey( key ) ) {
			obj = indexBySetStampIdx.get( key );
		}
		else {
			ISecureSecUserPWHistory rec = schema.getSecureBackingStore().getTableSecUserPWHistory().readDerivedBySetStampIdx( null,
				PWSetStamp );
			if( rec != null ) {
				obj = schema.getSecUserPWHistoryTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecUserPWHistoryObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistoryByReplacedStampIdx( LocalDateTime PWReplacedStamp )
	{
		return( readSecUserPWHistoryByReplacedStampIdx( PWReplacedStamp,
			false ) );
	}

	@Override
	public ISecureSecUserPWHistoryObj readSecUserPWHistoryByReplacedStampIdx( LocalDateTime PWReplacedStamp, boolean forceRead )
	{
		if( indexByReplacedStampIdx == null ) {
			indexByReplacedStampIdx = new HashMap< ISecureSecUserPWHistoryByReplacedStampIdxKey,
				ISecureSecUserPWHistoryObj >();
		}
		ISecureSecUserPWHistoryByReplacedStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
		key.setRequiredPWReplacedStamp( PWReplacedStamp );
		ISecureSecUserPWHistoryObj obj = null;
		if( ( ! forceRead ) && indexByReplacedStampIdx.containsKey( key ) ) {
			obj = indexByReplacedStampIdx.get( key );
		}
		else {
			ISecureSecUserPWHistory rec = schema.getSecureBackingStore().getTableSecUserPWHistory().readDerivedByReplacedStampIdx( null,
				PWReplacedStamp );
			if( rec != null ) {
				obj = schema.getSecUserPWHistoryTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecUserPWHistoryObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPWHistoryObj readCachedSecUserPWHistoryByIdIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp )
	{
		ISecureSecUserPWHistoryObj obj = null;
		ISecureSecUserPWHistoryPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newPKey();
		pkey.setRequiredSecUserId( SecUserId );
		pkey.setRequiredPWSetStamp( PWSetStamp );
		pkey.setRequiredSecUserId( SecUserId );
		pkey.setRequiredPWSetStamp( PWSetStamp );
		obj = readCachedSecUserPWHistory( pkey );
		return( obj );
	}

	@Override
	public ISecureSecUserPWHistoryObj readCachedSecUserPWHistoryByUserIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserPWHistoryObj obj = null;
		ISecureSecUserPWHistoryByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexByUserIdx != null ) {
			if( indexByUserIdx.containsKey( key ) ) {
				obj = indexByUserIdx.get( key );
			}
			else {
				Iterator<ISecureSecUserPWHistoryObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecUserPWHistoryObj> valIter = members.values().iterator();
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
	public ISecureSecUserPWHistoryObj readCachedSecUserPWHistoryBySetStampIdx( LocalDateTime PWSetStamp )
	{
		ISecureSecUserPWHistoryObj obj = null;
		ISecureSecUserPWHistoryBySetStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
		key.setRequiredPWSetStamp( PWSetStamp );
		if( indexBySetStampIdx != null ) {
			if( indexBySetStampIdx.containsKey( key ) ) {
				obj = indexBySetStampIdx.get( key );
			}
			else {
				Iterator<ISecureSecUserPWHistoryObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecUserPWHistoryObj> valIter = members.values().iterator();
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
	public ISecureSecUserPWHistoryObj readCachedSecUserPWHistoryByReplacedStampIdx( LocalDateTime PWReplacedStamp )
	{
		ISecureSecUserPWHistoryObj obj = null;
		ISecureSecUserPWHistoryByReplacedStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
		key.setRequiredPWReplacedStamp( PWReplacedStamp );
		if( indexByReplacedStampIdx != null ) {
			if( indexByReplacedStampIdx.containsKey( key ) ) {
				obj = indexByReplacedStampIdx.get( key );
			}
			else {
				Iterator<ISecureSecUserPWHistoryObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecUserPWHistoryObj> valIter = members.values().iterator();
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
	public void deepDisposeSecUserPWHistoryByIdIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp )
	{
		ISecureSecUserPWHistoryObj obj = readCachedSecUserPWHistoryByIdIdx( SecUserId,
				PWSetStamp );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserPWHistoryByUserIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserPWHistoryObj obj = readCachedSecUserPWHistoryByUserIdx( SecUserId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserPWHistoryBySetStampIdx( LocalDateTime PWSetStamp )
	{
		ISecureSecUserPWHistoryObj obj = readCachedSecUserPWHistoryBySetStampIdx( PWSetStamp );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserPWHistoryByReplacedStampIdx( LocalDateTime PWReplacedStamp )
	{
		ISecureSecUserPWHistoryObj obj = readCachedSecUserPWHistoryByReplacedStampIdx( PWReplacedStamp );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecUserPWHistoryObj updateSecUserPWHistory( ISecureSecUserPWHistoryObj Obj ) {
		ISecureSecUserPWHistoryObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUserPWHistory().updateSecUserPWHistory( null,
			Obj.getSecUserPWHistoryRec() );
		obj = (ISecureSecUserPWHistoryObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecUserPWHistory( ISecureSecUserPWHistoryObj Obj ) {
		ISecureSecUserPWHistoryObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUserPWHistory().deleteSecUserPWHistory( null,
			obj.getSecUserPWHistoryRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecUserPWHistoryByIdIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime PWSetStamp )
	{
		ISecureSecUserPWHistoryObj obj = readSecUserPWHistory(SecUserId,
				PWSetStamp);
		if( obj != null ) {
			ISecureSecUserPWHistoryEditObj editObj = (ISecureSecUserPWHistoryEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecUserPWHistoryEditObj)obj.beginEdit();
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
		deepDisposeSecUserPWHistoryByIdIdx( SecUserId,
				PWSetStamp );
	}

	@Override
	public void deleteSecUserPWHistoryByUserIdx( IYCFKeyHash256 SecUserId )
	{
		if( indexByUserIdx == null ) {
			indexByUserIdx = new HashMap< ISecureSecUserPWHistoryByUserIdxKey,
				ISecureSecUserPWHistoryObj >();
		}
		ISecureSecUserPWHistoryByUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		ISecureSecUserPWHistoryObj obj = null;
		if( indexByUserIdx.containsKey( key ) ) {
			obj = indexByUserIdx.get( key );
			schema.getSecureBackingStore().getTableSecUserPWHistory().deleteSecUserPWHistoryByUserIdx( null,
				SecUserId );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecUserPWHistory().deleteSecUserPWHistoryByUserIdx( null,
				SecUserId );
		}
		deepDisposeSecUserPWHistoryByUserIdx( SecUserId );
	}

	@Override
	public void deleteSecUserPWHistoryBySetStampIdx( LocalDateTime PWSetStamp )
	{
		if( indexBySetStampIdx == null ) {
			indexBySetStampIdx = new HashMap< ISecureSecUserPWHistoryBySetStampIdxKey,
				ISecureSecUserPWHistoryObj >();
		}
		ISecureSecUserPWHistoryBySetStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newBySetStampIdxKey();
		key.setRequiredPWSetStamp( PWSetStamp );
		ISecureSecUserPWHistoryObj obj = null;
		if( indexBySetStampIdx.containsKey( key ) ) {
			obj = indexBySetStampIdx.get( key );
			schema.getSecureBackingStore().getTableSecUserPWHistory().deleteSecUserPWHistoryBySetStampIdx( null,
				PWSetStamp );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecUserPWHistory().deleteSecUserPWHistoryBySetStampIdx( null,
				PWSetStamp );
		}
		deepDisposeSecUserPWHistoryBySetStampIdx( PWSetStamp );
	}

	@Override
	public void deleteSecUserPWHistoryByReplacedStampIdx( LocalDateTime PWReplacedStamp )
	{
		if( indexByReplacedStampIdx == null ) {
			indexByReplacedStampIdx = new HashMap< ISecureSecUserPWHistoryByReplacedStampIdxKey,
				ISecureSecUserPWHistoryObj >();
		}
		ISecureSecUserPWHistoryByReplacedStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWHistory().newByReplacedStampIdxKey();
		key.setRequiredPWReplacedStamp( PWReplacedStamp );
		ISecureSecUserPWHistoryObj obj = null;
		if( indexByReplacedStampIdx.containsKey( key ) ) {
			obj = indexByReplacedStampIdx.get( key );
			schema.getSecureBackingStore().getTableSecUserPWHistory().deleteSecUserPWHistoryByReplacedStampIdx( null,
				PWReplacedStamp );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecUserPWHistory().deleteSecUserPWHistoryByReplacedStampIdx( null,
				PWReplacedStamp );
		}
		deepDisposeSecUserPWHistoryByReplacedStampIdx( PWReplacedStamp );
	}
}