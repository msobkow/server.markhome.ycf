// Description: Java 25 Table Object implementation for ISOCtryLang.

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

public class BusModelISOCtryLangTableObj
	implements IBusModelISOCtryLangTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj> members;
	private Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj> allISOCtryLang;
	private Map< ISecureISOCtryLangByCtryIdxKey,
		Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj > > indexByCtryIdx;
	private Map< ISecureISOCtryLangByLangIdxKey,
		Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj > > indexByLangIdx;
	public static String TABLE_NAME = "ISOCtryLang";
	public static String TABLE_DBNAME = "iso_cntrylng";

	public BusModelISOCtryLangTableObj() {
		schema = null;
		members = new HashMap<ISecureISOCtryLangPKey, ISecureISOCtryLangObj>();
		allISOCtryLang = null;
		indexByCtryIdx = null;
		indexByLangIdx = null;
	}

	public BusModelISOCtryLangTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureISOCtryLangPKey, ISecureISOCtryLangObj>();
		allISOCtryLang = null;
		indexByCtryIdx = null;
		indexByLangIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureISOCtryLangTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureISOCtryLangTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureISOCtryLangTableObj.getRuntimeClassCode() );
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
		allISOCtryLang = null;
		indexByCtryIdx = null;
		indexByLangIdx = null;
		List<ISecureISOCtryLangObj> toForget = new LinkedList<ISecureISOCtryLangObj>();
		ISecureISOCtryLangObj cur = null;
		Iterator<ISecureISOCtryLangObj> iter = members.values().iterator();
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
	 *	BusModelISOCtryLangObj.
	 */
	@Override
	public ISecureISOCtryLangObj newInstance() {
		ISecureISOCtryLangObj inst = new BusModelISOCtryLangObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelISOCtryLangObj.
	 */
	@Override
	public ISecureISOCtryLangEditObj newEditInstance( ISecureISOCtryLangObj orig ) {
		ISecureISOCtryLangEditObj edit = new BusModelISOCtryLangEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureISOCtryLangObj constructByClassCode( int backingClassCode ) {
		ISecureISOCtryLangObj obj = null;
		if( backingClassCode == ISecureISOCtryLang.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getISOCtryLangTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryLangObj realiseISOCtryLang( ISecureISOCtryLangObj Obj ) {
		ISecureISOCtryLangObj obj = Obj;
		ISecureISOCtryLangPKey pkey = obj.getPKey();
		ISecureISOCtryLangObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureISOCtryLangObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCtryIdx != null ) {
				ISecureISOCtryLangByCtryIdxKey keyCtryIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.remove( keepObj.getPKey() );
					if( mapCtryIdx.size() <= 0 ) {
						indexByCtryIdx.remove( keyCtryIdx );
					}
				}
			}

			if( indexByLangIdx != null ) {
				ISecureISOCtryLangByLangIdxKey keyLangIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByLangIdxKey();
				keyLangIdx.setRequiredISOLangId( keepObj.getRequiredISOLangId() );
				Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj > mapLangIdx = indexByLangIdx.get( keyLangIdx );
				if( mapLangIdx != null ) {
					mapLangIdx.remove( keepObj.getPKey() );
					if( mapLangIdx.size() <= 0 ) {
						indexByLangIdx.remove( keyLangIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCtryIdx != null ) {
				ISecureISOCtryLangByCtryIdxKey keyCtryIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLangIdx != null ) {
				ISecureISOCtryLangByLangIdxKey keyLangIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByLangIdxKey();
				keyLangIdx.setRequiredISOLangId( keepObj.getRequiredISOLangId() );
				Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj > mapLangIdx = indexByLangIdx.get( keyLangIdx );
				if( mapLangIdx != null ) {
					mapLangIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allISOCtryLang != null ) {
				allISOCtryLang.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCtryLang != null ) {
				allISOCtryLang.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCtryIdx != null ) {
				ISecureISOCtryLangByCtryIdxKey keyCtryIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByCtryIdxKey();
				keyCtryIdx.setRequiredISOCtryId( keepObj.getRequiredISOCtryId() );
				Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj > mapCtryIdx = indexByCtryIdx.get( keyCtryIdx );
				if( mapCtryIdx != null ) {
					mapCtryIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLangIdx != null ) {
				ISecureISOCtryLangByLangIdxKey keyLangIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByLangIdxKey();
				keyLangIdx.setRequiredISOLangId( keepObj.getRequiredISOLangId() );
				Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj > mapLangIdx = indexByLangIdx.get( keyLangIdx );
				if( mapLangIdx != null ) {
					mapLangIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureISOCtryLangObj createISOCtryLang( ISecureISOCtryLangObj Obj ) {
		ISecureISOCtryLangObj obj = Obj;
		ISecureISOCtryLang rec = obj.getISOCtryLangRec();
		schema.getSecureBackingStore().getTableISOCtryLang().createISOCtryLang(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureISOCtryLangObj readISOCtryLang( ISecureISOCtryLangPKey pkey ) {
		return( readISOCtryLang( pkey, false ) );
	}

	@Override
	public ISecureISOCtryLangObj readISOCtryLang( ISecureISOCtryLangPKey pkey, boolean forceRead ) {
		ISecureISOCtryLangObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureISOCtryLang readRec = schema.getSecureBackingStore().getTableISOCtryLang().readDerivedByIdIdx( null,
						pkey.getRequiredISOCtryId(),
						pkey.getRequiredISOLangId() );
			if( readRec != null ) {
				obj = schema.getISOCtryLangTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureISOCtryLangObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryLangObj readISOCtryLang( short ISOCtryId,
		short ISOLangId ) {
		return( readISOCtryLang( ISOCtryId,
			ISOLangId, false ) );
	}

	@Override
	public ISecureISOCtryLangObj readISOCtryLang( short ISOCtryId,
		short ISOLangId, boolean forceRead ) {
		ISecureISOCtryLangObj obj = null;
		ISecureISOCtryLang readRec = schema.getSecureBackingStore().getTableISOCtryLang().readDerivedByIdIdx( null,
			ISOCtryId,
			ISOLangId );
		if( readRec != null ) {
				obj = schema.getISOCtryLangTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureISOCtryLangObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryLangObj readCachedISOCtryLang( ISecureISOCtryLangPKey pkey ) {
		ISecureISOCtryLangObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeISOCtryLang( ISecureISOCtryLangObj obj )
	{
		final String S_ProcName = "BusModelISOCtryLangTableObj.reallyDeepDisposeISOCtryLang() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureISOCtryLangPKey pkey = obj.getPKey();
		ISecureISOCtryLangObj existing = readCachedISOCtryLang( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureISOCtryLangByCtryIdxKey keyCtryIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByCtryIdxKey();
		keyCtryIdx.setRequiredISOCtryId( existing.getRequiredISOCtryId() );

		ISecureISOCtryLangByLangIdxKey keyLangIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByLangIdxKey();
		keyLangIdx.setRequiredISOLangId( existing.getRequiredISOLangId() );



		if( indexByCtryIdx != null ) {
			if( indexByCtryIdx.containsKey( keyCtryIdx ) ) {
				indexByCtryIdx.get( keyCtryIdx ).remove( pkey );
				if( indexByCtryIdx.get( keyCtryIdx ).size() <= 0 ) {
					indexByCtryIdx.remove( keyCtryIdx );
				}
			}
		}

		if( indexByLangIdx != null ) {
			if( indexByLangIdx.containsKey( keyLangIdx ) ) {
				indexByLangIdx.get( keyLangIdx ).remove( pkey );
				if( indexByLangIdx.get( keyLangIdx ).size() <= 0 ) {
					indexByLangIdx.remove( keyLangIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeISOCtryLang( ISecureISOCtryLangPKey pkey ) {
		ISecureISOCtryLangObj obj = readCachedISOCtryLang( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureISOCtryLangObj lockISOCtryLang( ISecureISOCtryLangPKey pkey ) {
		ISecureISOCtryLangObj locked = null;
		ISecureISOCtryLang lockRec = schema.getSecureBackingStore().getTableISOCtryLang().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getISOCtryLangTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureISOCtryLangObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockISOCtryLang", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureISOCtryLangObj> readAllISOCtryLang() {
		return( readAllISOCtryLang( false ) );
	}

	@Override
	public List<ISecureISOCtryLangObj> readAllISOCtryLang( boolean forceRead ) {
		final String S_ProcName = "readAllISOCtryLang";
		if( ( allISOCtryLang == null ) || forceRead ) {
			Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj> map = new HashMap<ISecureISOCtryLangPKey,ISecureISOCtryLangObj>();
			allISOCtryLang = map;
			ISecureISOCtryLang[] recList = schema.getSecureBackingStore().getTableISOCtryLang().readAllDerived( null );
			ISecureISOCtryLang rec;
			ISecureISOCtryLangObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOCtryLangObj realised = (ISecureISOCtryLangObj)obj.realise();
			}
		}
		int len = allISOCtryLang.size();
		ISecureISOCtryLangObj arr[] = new ISecureISOCtryLangObj[len];
		Iterator<ISecureISOCtryLangObj> valIter = allISOCtryLang.values().iterator();
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
		ArrayList<ISecureISOCtryLangObj> arrayList = new ArrayList<ISecureISOCtryLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOCtryLangObj> cmp = new Comparator<ISecureISOCtryLangObj>() {
			@Override
			public int compare( ISecureISOCtryLangObj lhs, ISecureISOCtryLangObj rhs ) {
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
					ISecureISOCtryLangPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureISOCtryLangObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureISOCtryLangObj> readCachedAllISOCtryLang() {
		final String S_ProcName = "readCachedAllISOCtryLang";
		ArrayList<ISecureISOCtryLangObj> arrayList = new ArrayList<ISecureISOCtryLangObj>();
		if( allISOCtryLang != null ) {
			int len = allISOCtryLang.size();
			ISecureISOCtryLangObj arr[] = new ISecureISOCtryLangObj[len];
			Iterator<ISecureISOCtryLangObj> valIter = allISOCtryLang.values().iterator();
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
		Comparator<ISecureISOCtryLangObj> cmp = new Comparator<ISecureISOCtryLangObj>() {
			public int compare( ISecureISOCtryLangObj lhs, ISecureISOCtryLangObj rhs ) {
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
					ISecureISOCtryLangPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public ISecureISOCtryLangObj readISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId )
	{
		return( readISOCtryLangByIdIdx( ISOCtryId,
			ISOLangId,
			false ) );
	}

	@Override
	public ISecureISOCtryLangObj readISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId, boolean forceRead )
	{
		ISecureISOCtryLangPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOLangId( ISOLangId );
		ISecureISOCtryLangObj obj = readISOCtryLang( pkey, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureISOCtryLangObj> readISOCtryLangByCtryIdx( short ISOCtryId )
	{
		return( readISOCtryLangByCtryIdx( ISOCtryId,
			false ) );
	}

	@Override
	public List<ISecureISOCtryLangObj> readISOCtryLangByCtryIdx( short ISOCtryId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCtryLangByCtryIdx";
		ISecureISOCtryLangByCtryIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj> dict;
		if( indexByCtryIdx == null ) {
			indexByCtryIdx = new HashMap< ISecureISOCtryLangByCtryIdxKey,
				Map< ISecureISOCtryLangPKey, ISecureISOCtryLangObj > >();
		}
		if( ( ! forceRead ) && indexByCtryIdx.containsKey( key ) ) {
			dict = indexByCtryIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureISOCtryLangPKey, ISecureISOCtryLangObj>();
			ISecureISOCtryLangObj obj;
			ISecureISOCtryLang[] recList = schema.getSecureBackingStore().getTableISOCtryLang().readDerivedByCtryIdx( null,
				ISOCtryId );
			ISecureISOCtryLang rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getISOCtryLangTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOCtryLangObj realised = (ISecureISOCtryLangObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCtryIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureISOCtryLangObj arr[] = new ISecureISOCtryLangObj[len];
		Iterator<ISecureISOCtryLangObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureISOCtryLangObj> arrayList = new ArrayList<ISecureISOCtryLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOCtryLangObj> cmp = new Comparator<ISecureISOCtryLangObj>() {
			@Override
			public int compare( ISecureISOCtryLangObj lhs, ISecureISOCtryLangObj rhs ) {
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
					ISecureISOCtryLangPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureISOCtryLangObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureISOCtryLangObj> readISOCtryLangByLangIdx( short ISOLangId )
	{
		return( readISOCtryLangByLangIdx( ISOLangId,
			false ) );
	}

	@Override
	public List<ISecureISOCtryLangObj> readISOCtryLangByLangIdx( short ISOLangId,
		boolean forceRead )
	{
		final String S_ProcName = "readISOCtryLangByLangIdx";
		ISecureISOCtryLangByLangIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByLangIdxKey();
		key.setRequiredISOLangId( ISOLangId );
		Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj> dict;
		if( indexByLangIdx == null ) {
			indexByLangIdx = new HashMap< ISecureISOCtryLangByLangIdxKey,
				Map< ISecureISOCtryLangPKey, ISecureISOCtryLangObj > >();
		}
		if( ( ! forceRead ) && indexByLangIdx.containsKey( key ) ) {
			dict = indexByLangIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureISOCtryLangPKey, ISecureISOCtryLangObj>();
			ISecureISOCtryLangObj obj;
			ISecureISOCtryLang[] recList = schema.getSecureBackingStore().getTableISOCtryLang().readDerivedByLangIdx( null,
				ISOLangId );
			ISecureISOCtryLang rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getISOCtryLangTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOCtryLangObj realised = (ISecureISOCtryLangObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLangIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureISOCtryLangObj arr[] = new ISecureISOCtryLangObj[len];
		Iterator<ISecureISOCtryLangObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureISOCtryLangObj> arrayList = new ArrayList<ISecureISOCtryLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOCtryLangObj> cmp = new Comparator<ISecureISOCtryLangObj>() {
			@Override
			public int compare( ISecureISOCtryLangObj lhs, ISecureISOCtryLangObj rhs ) {
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
					ISecureISOCtryLangPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureISOCtryLangObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureISOCtryLangObj readCachedISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId )
	{
		ISecureISOCtryLangObj obj = null;
		ISecureISOCtryLangPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newPKey();
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOLangId( ISOLangId );
		pkey.setRequiredISOCtryId( ISOCtryId );
		pkey.setRequiredISOLangId( ISOLangId );
		obj = readCachedISOCtryLang( pkey );
		return( obj );
	}

	@Override
	public List<ISecureISOCtryLangObj> readCachedISOCtryLangByCtryIdx( short ISOCtryId )
	{
		final String S_ProcName = "readCachedISOCtryLangByCtryIdx";
		ISecureISOCtryLangByCtryIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		ArrayList<ISecureISOCtryLangObj> arrayList = new ArrayList<ISecureISOCtryLangObj>();
		if( indexByCtryIdx != null ) {
			Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj> dict;
			if( indexByCtryIdx.containsKey( key ) ) {
				dict = indexByCtryIdx.get( key );
				int len = dict.size();
				ISecureISOCtryLangObj arr[] = new ISecureISOCtryLangObj[len];
				Iterator<ISecureISOCtryLangObj> valIter = dict.values().iterator();
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
			ISecureISOCtryLangObj obj;
			Iterator<ISecureISOCtryLangObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureISOCtryLangObj> cmp = new Comparator<ISecureISOCtryLangObj>() {
			@Override
			public int compare( ISecureISOCtryLangObj lhs, ISecureISOCtryLangObj rhs ) {
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
					ISecureISOCtryLangPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<ISecureISOCtryLangObj> readCachedISOCtryLangByLangIdx( short ISOLangId )
	{
		final String S_ProcName = "readCachedISOCtryLangByLangIdx";
		ISecureISOCtryLangByLangIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByLangIdxKey();
		key.setRequiredISOLangId( ISOLangId );
		ArrayList<ISecureISOCtryLangObj> arrayList = new ArrayList<ISecureISOCtryLangObj>();
		if( indexByLangIdx != null ) {
			Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj> dict;
			if( indexByLangIdx.containsKey( key ) ) {
				dict = indexByLangIdx.get( key );
				int len = dict.size();
				ISecureISOCtryLangObj arr[] = new ISecureISOCtryLangObj[len];
				Iterator<ISecureISOCtryLangObj> valIter = dict.values().iterator();
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
			ISecureISOCtryLangObj obj;
			Iterator<ISecureISOCtryLangObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureISOCtryLangObj> cmp = new Comparator<ISecureISOCtryLangObj>() {
			@Override
			public int compare( ISecureISOCtryLangObj lhs, ISecureISOCtryLangObj rhs ) {
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
					ISecureISOCtryLangPKey lhsPKey = lhs.getPKey();
					ISecureISOCtryLangPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId )
	{
		ISecureISOCtryLangObj obj = readCachedISOCtryLangByIdIdx( ISOCtryId,
				ISOLangId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOCtryLangByCtryIdx( short ISOCtryId )
	{
		final String S_ProcName = "deepDisposeISOCtryLangByCtryIdx";
		ISecureISOCtryLangObj obj;
		List<ISecureISOCtryLangObj> arrayList = readCachedISOCtryLangByCtryIdx( ISOCtryId );
		if( arrayList != null )  {
			Iterator<ISecureISOCtryLangObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeISOCtryLangByLangIdx( short ISOLangId )
	{
		final String S_ProcName = "deepDisposeISOCtryLangByLangIdx";
		ISecureISOCtryLangObj obj;
		List<ISecureISOCtryLangObj> arrayList = readCachedISOCtryLangByLangIdx( ISOLangId );
		if( arrayList != null )  {
			Iterator<ISecureISOCtryLangObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public ISecureISOCtryLangObj updateISOCtryLang( ISecureISOCtryLangObj Obj ) {
		ISecureISOCtryLangObj obj = Obj;
		schema.getSecureBackingStore().getTableISOCtryLang().updateISOCtryLang( null,
			Obj.getISOCtryLangRec() );
		obj = (ISecureISOCtryLangObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteISOCtryLang( ISecureISOCtryLangObj Obj ) {
		ISecureISOCtryLangObj obj = Obj;
		schema.getSecureBackingStore().getTableISOCtryLang().deleteISOCtryLang( null,
			obj.getISOCtryLangRec() );
		Obj.forget();
	}

	@Override
	public void deleteISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId )
	{
		ISecureISOCtryLangObj obj = readISOCtryLang(ISOCtryId,
				ISOLangId);
		if( obj != null ) {
			ISecureISOCtryLangEditObj editObj = (ISecureISOCtryLangEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureISOCtryLangEditObj)obj.beginEdit();
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
		deepDisposeISOCtryLangByIdIdx( ISOCtryId,
				ISOLangId );
	}

	@Override
	public void deleteISOCtryLangByCtryIdx( short ISOCtryId )
	{
		ISecureISOCtryLangByCtryIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByCtryIdxKey();
		key.setRequiredISOCtryId( ISOCtryId );
		if( indexByCtryIdx == null ) {
			indexByCtryIdx = new HashMap< ISecureISOCtryLangByCtryIdxKey,
				Map< ISecureISOCtryLangPKey, ISecureISOCtryLangObj > >();
		}
		if( indexByCtryIdx.containsKey( key ) ) {
			Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj> dict = indexByCtryIdx.get( key );
			schema.getSecureBackingStore().getTableISOCtryLang().deleteISOCtryLangByCtryIdx( null,
				ISOCtryId );
			Iterator<ISecureISOCtryLangObj> iter = dict.values().iterator();
			ISecureISOCtryLangObj obj;
			List<ISecureISOCtryLangObj> toForget = new LinkedList<ISecureISOCtryLangObj>();
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
			schema.getSecureBackingStore().getTableISOCtryLang().deleteISOCtryLangByCtryIdx( null,
				ISOCtryId );
		}
		deepDisposeISOCtryLangByCtryIdx( ISOCtryId );
	}

	@Override
	public void deleteISOCtryLangByLangIdx( short ISOLangId )
	{
		ISecureISOCtryLangByLangIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtryLang().newByLangIdxKey();
		key.setRequiredISOLangId( ISOLangId );
		if( indexByLangIdx == null ) {
			indexByLangIdx = new HashMap< ISecureISOCtryLangByLangIdxKey,
				Map< ISecureISOCtryLangPKey, ISecureISOCtryLangObj > >();
		}
		if( indexByLangIdx.containsKey( key ) ) {
			Map<ISecureISOCtryLangPKey, ISecureISOCtryLangObj> dict = indexByLangIdx.get( key );
			schema.getSecureBackingStore().getTableISOCtryLang().deleteISOCtryLangByLangIdx( null,
				ISOLangId );
			Iterator<ISecureISOCtryLangObj> iter = dict.values().iterator();
			ISecureISOCtryLangObj obj;
			List<ISecureISOCtryLangObj> toForget = new LinkedList<ISecureISOCtryLangObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByLangIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableISOCtryLang().deleteISOCtryLangByLangIdx( null,
				ISOLangId );
		}
		deepDisposeISOCtryLangByLangIdx( ISOLangId );
	}
}