// Description: Java 25 Table Object implementation for ISOCtryCcy.

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

public class BusModelISOCtryCcyTableObj
	implements IBusModelISOCtryCcyTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj> members;
	private Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj> allISOCtryCcy;
	private Map< ISecureISOCtryCcyByCtryIdxKey,
		Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > > indexByCtryIdx;
	private Map< ISecureISOCtryCcyByCcyIdxKey,
		Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > > indexByCcyIdx;
	public static String TABLE_NAME = "ISOCtryCcy";
	public static String TABLE_DBNAME = "iso_cntryccy";

	public BusModelISOCtryCcyTableObj() {
		schema = null;
		members = new HashMap<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj>();
		allISOCtryCcy = null;
		indexByCtryIdx = null;
		indexByCcyIdx = null;
	}

	public BusModelISOCtryCcyTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj>();
		allISOCtryCcy = null;
		indexByCtryIdx = null;
		indexByCcyIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureISOCtryCcyTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureISOCtryCcyTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureISOCtryCcyTableObj.getRuntimeClassCode() );
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
		allISOCtryCcy = null;
		indexByCtryIdx = null;
		indexByCcyIdx = null;
		List<ISecureISOCtryCcyObj> toForget = new LinkedList<ISecureISOCtryCcyObj>();
		ISecureISOCtryCcyObj cur = null;
		Iterator<ISecureISOCtryCcyObj> iter = members.values().iterator();
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
	 *	BusModelISOCtryCcyObj.
	 */
	@Override
	public ISecureISOCtryCcyObj newInstance() {
		ISecureISOCtryCcyObj inst = new BusModelISOCtryCcyObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelISOCtryCcyObj.
	 */
	@Override
	public ISecureISOCtryCcyEditObj newEditInstance( ISecureISOCtryCcyObj orig ) {
		ISecureISOCtryCcyEditObj edit = new BusModelISOCtryCcyEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureISOCtryCcyObj constructByClassCode( int backingClassCode ) {
		ISecureISOCtryCcyObj obj = null;
		if( backingClassCode == ISecureISOCtryCcy.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getISOCtryCcyTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryCcyObj realiseISOCtryCcy( ISecureISOCtryCcyObj Obj ) {
		ISecureISOCtryCcyObj obj = Obj;
		ISecureISOCtryCcyPKey pkey = obj.getPKey();
		ISecureISOCtryCcyObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureISOCtryCcyObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCtryIdx != null ) {
				ISecureISOCtryCcyByCtryIdxKey keyCtryIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.remove( keepObj.getPKey() );
					if( mapCtryIdx.size() <= 0 ) {
						indexByCtryIdx.remove( keyCtryIdx );
					}
				}
			}

			if( indexByCcyIdx != null ) {
				ISecureISOCtryCcyByCcyIdxKey keyCcyIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCcyIdxKey();
				keyCcyIdx.setRequiredISOCcyId( keepObj.getRequiredISOCcyId() );
				Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > mapCcyIdx = indexByCcyIdx.get( keyCcyIdx );
				if( mapCcyIdx != null ) {
					mapCcyIdx.remove( keepObj.getPKey() );
					if( mapCcyIdx.size() <= 0 ) {
						indexByCcyIdx.remove( keyCcyIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCtryIdx != null ) {
				ISecureISOCtryCcyByCtryIdxKey keyCtryIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCcyIdx != null ) {
				ISecureISOCtryCcyByCcyIdxKey keyCcyIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCcyIdxKey();
				keyCcyIdx.setRequiredISOCcyId( keepObj.getRequiredISOCcyId() );
				Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > mapCcyIdx = indexByCcyIdx.get( keyCcyIdx );
				if( mapCcyIdx != null ) {
					mapCcyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allISOCtryCcy != null ) {
				allISOCtryCcy.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCtryCcy != null ) {
				allISOCtryCcy.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCtryIdx != null ) {
				ISecureISOCtryCcyByCtryIdxKey keyCtryIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCcyIdx != null ) {
				ISecureISOCtryCcyByCcyIdxKey keyCcyIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCcyIdxKey();
				keyCcyIdx.setRequiredISOCcyId( keepObj.getRequiredISOCcyId() );
				Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > mapCcyIdx = indexByCcyIdx.get( keyCcyIdx );
				if( mapCcyIdx != null ) {
					mapCcyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureISOCtryCcyObj createISOCtryCcy( ISecureISOCtryCcyObj Obj ) {
		ISecureISOCtryCcyObj obj = Obj;
		ISecureISOCtryCcy rec = obj.getISOCtryCcyRec();
		schema.getSecureBackingStore().getTableISOCtryCcy().createISOCtryCcy(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureISOCtryCcyObj readISOCtryCcy( ISecureISOCtryCcyPKey pkey ) {
		return( readISOCtryCcy( pkey, false ) );
	}

	@Override
	public ISecureISOCtryCcyObj readISOCtryCcy( ISecureISOCtryCcyPKey pkey, boolean forceRead ) {
		ISecureISOCtryCcyObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureISOCtryCcy readRec = schema.getSecureBackingStore().getTableISOCtryCcy().readDerivedByIdIdx( null,
						pkey.getRequiredISOCtryId(),
						pkey.getRequiredISOCcyId() );
			if( readRec != null ) {
				obj = schema.getISOCtryCcyTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureISOCtryCcyObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryCcyObj readISOCtryCcy( short ISOCtryId,
		short ISOCcyId ) {
		return( readISOCtryCcy( ISOCtryId,
			ISOCcyId, false ) );
	}

	@Override
	public ISecureISOCtryCcyObj readISOCtryCcy( short ISOCtryId,
		short ISOCcyId, boolean forceRead ) {
		ISecureISOCtryCcyObj obj = null;
		ISecureISOCtryCcy readRec = schema.getSecureBackingStore().getTableISOCtryCcy().readDerivedByIdIdx( null,
			ISOCtryId,
			ISOCcyId );
		if( readRec != null ) {
				obj = schema.getISOCtryCcyTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureISOCtryCcyObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryCcyObj readCachedISOCtryCcy( ISecureISOCtryCcyPKey pkey ) {
		ISecureISOCtryCcyObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeISOCtryCcy( ISecureISOCtryCcyObj obj )
	{
		final String S_ProcName = "BusModelISOCtryCcyTableObj.reallyDeepDisposeISOCtryCcy() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureISOCtryCcyPKey pkey = obj.getPKey();
		ISecureISOCtryCcyObj existing = readCachedISOCtryCcy( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureISOCtryCcyByCtryIdxKey keyCtryIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCtryIdxKey();
		keyCtryIdx.setRequiredISOCtryId( existing.getRequiredISOCtryId() );

		ISecureISOCtryCcyByCcyIdxKey keyCcyIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCcyIdxKey();
		keyCcyIdx.setRequiredISOCcyId( existing.getRequiredISOCcyId() );



		if( indexByCtryIdx != null ) {
			if( indexByCtryIdx.containsKey( keyCtryIdx ) ) {
				indexByCtryIdx.get( keyCtryIdx ).remove( pkey );
				if( indexByCtryIdx.get( keyCtryIdx ).size() <= 0 ) {
					indexByCtryIdx.remove( keyCtryIdx );
				}
			}
		}

		if( indexByCcyIdx != null ) {
			if( indexByCcyIdx.containsKey( keyCcyIdx ) ) {
				indexByCcyIdx.get( keyCcyIdx ).remove( pkey );
				if( indexByCcyIdx.get( keyCcyIdx ).size() <= 0 ) {
					indexByCcyIdx.remove( keyCcyIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeISOCtryCcy( ISecureISOCtryCcyPKey pkey ) {
		ISecureISOCtryCcyObj obj = readCachedISOCtryCcy( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureISOCtryCcyObj lockISOCtryCcy( ISecureISOCtryCcyPKey pkey ) {
		ISecureISOCtryCcyObj locked = null;
		ISecureISOCtryCcy lockRec = schema.getSecureBackingStore().getTableISOCtryCcy().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getISOCtryCcyTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureISOCtryCcyObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockISOCtryCcy", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureISOCtryCcyObj> readAllISOCtryCcy() {
		return( readAllISOCtryCcy( false ) );
	}

	@Override
	public List<ISecureISOCtryCcyObj> readAllISOCtryCcy( boolean forceRead ) {
		final String S_ProcName = "readAllISOCtryCcy";
		if( ( allISOCtryCcy == null ) || forceRead ) {
			Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj> map = new HashMap<ISecureISOCtryCcyPKey,ISecureISOCtryCcyObj>();
			allISOCtryCcy = map;
			ISecureISOCtryCcy[] recList = schema.getSecureBackingStore().getTableISOCtryCcy().readAllDerived( null );
			ISecureISOCtryCcy rec;
			ISecureISOCtryCcyObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOCtryCcyObj realised = (ISecureISOCtryCcyObj)obj.realise();
			}
		}
		int len = allISOCtryCcy.size();
		ISecureISOCtryCcyObj arr[] = new ISecureISOCtryCcyObj[len];
		Iterator<ISecureISOCtryCcyObj> valIter = allISOCtryCcy.values().iterator();
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
		ArrayList<ISecureISOCtryCcyObj> arrayList = new ArrayList<ISecureISOCtryCcyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOCtryCcyObj> cmp = new Comparator<ISecureISOCtryCcyObj>() {
			@Override
			public int compare( ISecureISOCtryCcyObj lhs, ISecureISOCtryCcyObj rhs ) {
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
					ISecureISOCtryCcyPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureISOCtryCcyObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureISOCtryCcyObj> readCachedAllISOCtryCcy() {
		final String S_ProcName = "readCachedAllISOCtryCcy";
		ArrayList<ISecureISOCtryCcyObj> arrayList = new ArrayList<ISecureISOCtryCcyObj>();
		if( allISOCtryCcy != null ) {
			int len = allISOCtryCcy.size();
			ISecureISOCtryCcyObj arr[] = new ISecureISOCtryCcyObj[len];
			Iterator<ISecureISOCtryCcyObj> valIter = allISOCtryCcy.values().iterator();
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
		Comparator<ISecureISOCtryCcyObj> cmp = new Comparator<ISecureISOCtryCcyObj>() {
			public int compare( ISecureISOCtryCcyObj lhs, ISecureISOCtryCcyObj rhs ) {
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
					ISecureISOCtryCcyPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public ISecureISOCtryCcyObj readISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId )
	{
		return( readISOCtryCcyByIdIdx( ISOCtryId,
			ISOCcyId,
			false ) );
	}

	@Override
	public ISecureISOCtryCcyObj readISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId, boolean forceRead )
	{
		ISecureISOCtryCcyPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOCcyId( ISOCcyId );
		ISecureISOCtryCcyObj obj = readISOCtryCcy( pkey, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureISOCtryCcyObj> readISOCtryCcyByCtryIdx( short ISOCtryId )
	{
		return( readISOCtryCcyByCtryIdx( ISOCtryId,
			false ) );
	}

	@Override
	public List<ISecureISOCtryCcyObj> readISOCtryCcyByCtryIdx( short ISOCtryId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCtryCcyByCtryIdx";
		ISecureISOCtryCcyByCtryIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj> dict;
		if( indexByCtryIdx == null ) {
			indexByCtryIdx = new HashMap< ISecureISOCtryCcyByCtryIdxKey,
				Map< ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > >();
		}
		if( ( ! forceRead ) && indexByCtryIdx.containsKey( key ) ) {
			dict = indexByCtryIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj>();
			ISecureISOCtryCcyObj obj;
			ISecureISOCtryCcy[] recList = schema.getSecureBackingStore().getTableISOCtryCcy().readDerivedByCtryIdx( null,
				ISOCtryId );
			ISecureISOCtryCcy rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getISOCtryCcyTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOCtryCcyObj realised = (ISecureISOCtryCcyObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCtryIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureISOCtryCcyObj arr[] = new ISecureISOCtryCcyObj[len];
		Iterator<ISecureISOCtryCcyObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureISOCtryCcyObj> arrayList = new ArrayList<ISecureISOCtryCcyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOCtryCcyObj> cmp = new Comparator<ISecureISOCtryCcyObj>() {
			@Override
			public int compare( ISecureISOCtryCcyObj lhs, ISecureISOCtryCcyObj rhs ) {
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
					ISecureISOCtryCcyPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureISOCtryCcyObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureISOCtryCcyObj> readISOCtryCcyByCcyIdx( short ISOCcyId )
	{
		return( readISOCtryCcyByCcyIdx( ISOCcyId,
			false ) );
	}

	@Override
	public List<ISecureISOCtryCcyObj> readISOCtryCcyByCcyIdx( short ISOCcyId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCtryCcyByCcyIdx";
		ISecureISOCtryCcyByCcyIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCcyIdxKey();
		key.setRequiredISOCcyId( ISOCcyId );
		Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj> dict;
		if( indexByCcyIdx == null ) {
			indexByCcyIdx = new HashMap< ISecureISOCtryCcyByCcyIdxKey,
				Map< ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > >();
		}
		if( ( ! forceRead ) && indexByCcyIdx.containsKey( key ) ) {
			dict = indexByCcyIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj>();
			ISecureISOCtryCcyObj obj;
			ISecureISOCtryCcy[] recList = schema.getSecureBackingStore().getTableISOCtryCcy().readDerivedByCcyIdx( null,
				ISOCcyId );
			ISecureISOCtryCcy rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getISOCtryCcyTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOCtryCcyObj realised = (ISecureISOCtryCcyObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCcyIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureISOCtryCcyObj arr[] = new ISecureISOCtryCcyObj[len];
		Iterator<ISecureISOCtryCcyObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureISOCtryCcyObj> arrayList = new ArrayList<ISecureISOCtryCcyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOCtryCcyObj> cmp = new Comparator<ISecureISOCtryCcyObj>() {
			@Override
			public int compare( ISecureISOCtryCcyObj lhs, ISecureISOCtryCcyObj rhs ) {
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
					ISecureISOCtryCcyPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureISOCtryCcyObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureISOCtryCcyObj readCachedISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId )
	{
		ISecureISOCtryCcyObj obj = null;
		ISecureISOCtryCcyPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOCcyId( ISOCcyId );
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOCcyId( ISOCcyId );
		obj = readCachedISOCtryCcy( pkey );
		return( obj );
	}

	@Override
	public List<ISecureISOCtryCcyObj> readCachedISOCtryCcyByCtryIdx( short ISOCtryId )
	{
		final String S_ProcName = "readCachedISOCtryCcyByCtryIdx";
		ISecureISOCtryCcyByCtryIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		ArrayList<ISecureISOCtryCcyObj> arrayList = new ArrayList<ISecureISOCtryCcyObj>();
		if( indexByCtryIdx != null ) {
			Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj> dict;
			if( indexByCtryIdx.containsKey( key ) ) {
				dict = indexByCtryIdx.get( key );
				int len = dict.size();
				ISecureISOCtryCcyObj arr[] = new ISecureISOCtryCcyObj[len];
				Iterator<ISecureISOCtryCcyObj> valIter = dict.values().iterator();
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
			ISecureISOCtryCcyObj obj;
			Iterator<ISecureISOCtryCcyObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureISOCtryCcyObj> cmp = new Comparator<ISecureISOCtryCcyObj>() {
			@Override
			public int compare( ISecureISOCtryCcyObj lhs, ISecureISOCtryCcyObj rhs ) {
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
					ISecureISOCtryCcyPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<ISecureISOCtryCcyObj> readCachedISOCtryCcyByCcyIdx( short ISOCcyId )
	{
		final String S_ProcName = "readCachedISOCtryCcyByCcyIdx";
		ISecureISOCtryCcyByCcyIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCcyIdxKey();
		key.setRequiredISOCcyId( ISOCcyId );
		ArrayList<ISecureISOCtryCcyObj> arrayList = new ArrayList<ISecureISOCtryCcyObj>();
		if( indexByCcyIdx != null ) {
			Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj> dict;
			if( indexByCcyIdx.containsKey( key ) ) {
				dict = indexByCcyIdx.get( key );
				int len = dict.size();
				ISecureISOCtryCcyObj arr[] = new ISecureISOCtryCcyObj[len];
				Iterator<ISecureISOCtryCcyObj> valIter = dict.values().iterator();
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
			ISecureISOCtryCcyObj obj;
			Iterator<ISecureISOCtryCcyObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureISOCtryCcyObj> cmp = new Comparator<ISecureISOCtryCcyObj>() {
			@Override
			public int compare( ISecureISOCtryCcyObj lhs, ISecureISOCtryCcyObj rhs ) {
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
					ISecureISOCtryCcyPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryCcyPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId )
	{
		ISecureISOCtryCcyObj obj = readCachedISOCtryCcyByIdIdx( ISOCtryId,
				ISOCcyId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOCtryCcyByCtryIdx( short ISOCtryId )
	{
		final String S_ProcName = "deepDisposeISOCtryCcyByCtryIdx";
		ISecureISOCtryCcyObj obj;
		List<ISecureISOCtryCcyObj> arrayList = readCachedISOCtryCcyByCtryIdx( ISOCtryId );
		if( arrayList != null )  {
			Iterator<ISecureISOCtryCcyObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeISOCtryCcyByCcyIdx( short ISOCcyId )
	{
		final String S_ProcName = "deepDisposeISOCtryCcyByCcyIdx";
		ISecureISOCtryCcyObj obj;
		List<ISecureISOCtryCcyObj> arrayList = readCachedISOCtryCcyByCcyIdx( ISOCcyId );
		if( arrayList != null )  {
			Iterator<ISecureISOCtryCcyObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public ISecureISOCtryCcyObj updateISOCtryCcy( ISecureISOCtryCcyObj Obj ) {
		ISecureISOCtryCcyObj obj = Obj;
		schema.getSecureBackingStore().getTableISOCtryCcy().updateISOCtryCcy( null,
			Obj.getISOCtryCcyRec() );
		obj = (ISecureISOCtryCcyObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteISOCtryCcy( ISecureISOCtryCcyObj Obj ) {
		ISecureISOCtryCcyObj obj = Obj;
		schema.getSecureBackingStore().getTableISOCtryCcy().deleteISOCtryCcy( null,
			obj.getISOCtryCcyRec() );
		Obj.forget();
	}

	@Override
	public void deleteISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId )
	{
		ISecureISOCtryCcyObj obj = readISOCtryCcy(ISOCtryId,
				ISOCcyId);
		if( obj != null ) {
			ISecureISOCtryCcyEditObj editObj = (ISecureISOCtryCcyEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureISOCtryCcyEditObj)obj.beginEdit();
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
		deepDisposeISOCtryCcyByIdIdx( ISOCtryId,
				ISOCcyId );
	}

	@Override
	public void deleteISOCtryCcyByCtryIdx( short ISOCtryId )
	{
		ISecureISOCtryCcyByCtryIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		if( indexByCtryIdx == null ) {
			indexByCtryIdx = new HashMap< ISecureISOCtryCcyByCtryIdxKey,
				Map< ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > >();
		}
		if( indexByCtryIdx.containsKey( key ) ) {
			Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj> dict = indexByCtryIdx.get( key );
			schema.getSecureBackingStore().getTableISOCtryCcy().deleteISOCtryCcyByCtryIdx( null,
				ISOCtryId );
			Iterator<ISecureISOCtryCcyObj> iter = dict.values().iterator();
			ISecureISOCtryCcyObj obj;
			List<ISecureISOCtryCcyObj> toForget = new LinkedList<ISecureISOCtryCcyObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByCtryIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableISOCtryCcy().deleteISOCtryCcyByCtryIdx( null,
				ISOCtryId );
		}
		deepDisposeISOCtryCcyByCtryIdx( ISOCtryId );
	}

	@Override
	public void deleteISOCtryCcyByCcyIdx( short ISOCcyId )
	{
		ISecureISOCtryCcyByCcyIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryCcy().newByCcyIdxKey();
		key.setRequiredISOCcyId( ISOCcyId );
		if( indexByCcyIdx == null ) {
			indexByCcyIdx = new HashMap< ISecureISOCtryCcyByCcyIdxKey,
				Map< ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj > >();
		}
		if( indexByCcyIdx.containsKey( key ) ) {
			Map<ISecureISOCtryCcyPKey, ISecureISOCtryCcyObj> dict = indexByCcyIdx.get( key );
			schema.getSecureBackingStore().getTableISOCtryCcy().deleteISOCtryCcyByCcyIdx( null,
				ISOCcyId );
			Iterator<ISecureISOCtryCcyObj> iter = dict.values().iterator();
			ISecureISOCtryCcyObj obj;
			List<ISecureISOCtryCcyObj> toForget = new LinkedList<ISecureISOCtryCcyObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByCcyIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableISOCtryCcy().deleteISOCtryCcyByCcyIdx( null,
				ISOCcyId );
		}
		deepDisposeISOCtryCcyByCcyIdx( ISOCcyId );
	}
}