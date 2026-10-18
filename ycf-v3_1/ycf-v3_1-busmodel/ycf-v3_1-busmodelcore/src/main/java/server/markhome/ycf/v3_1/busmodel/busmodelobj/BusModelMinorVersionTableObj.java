// Description: Java 25 Table Object implementation for MinorVersion.

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public class BusModelMinorVersionTableObj
	implements IBusModelMinorVersionTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj> members;
	private Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj> allMinorVersion;
	private Map< IIntNetMinorVersionByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > > indexByTenantIdx;
	private Map< IIntNetMinorVersionByMajorVerIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > > indexByMajorVerIdx;
	private Map< IIntNetMinorVersionByNameIdxKey,
		IIntNetMinorVersionObj > indexByNameIdx;
	public static String TABLE_NAME = "MinorVersion";
	public static String TABLE_DBNAME = "mnvrdef";

	public BusModelMinorVersionTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj>();
		allMinorVersion = null;
		indexByTenantIdx = null;
		indexByMajorVerIdx = null;
		indexByNameIdx = null;
	}

	public BusModelMinorVersionTableObj( IIntNetSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj>();
		allMinorVersion = null;
		indexByTenantIdx = null;
		indexByMajorVerIdx = null;
		indexByNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return IntNetMinorVersionTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( IntNetMinorVersionTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( IntNetMinorVersionTableObj.getRuntimeClassCode() );
	}

	@Override
	public IIntNetSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IIntNetSchemaObj value ) {
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
		return( IBusModelTenantObj.class );
	}


	@Override
	public void minimizeMemory() {
		allMinorVersion = null;
		indexByTenantIdx = null;
		indexByMajorVerIdx = null;
		indexByNameIdx = null;
		List<IIntNetMinorVersionObj> toForget = new LinkedList<IIntNetMinorVersionObj>();
		IIntNetMinorVersionObj cur = null;
		Iterator<IIntNetMinorVersionObj> iter = members.values().iterator();
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
	 *	BusModelMinorVersionObj.
	 */
	@Override
	public IIntNetMinorVersionObj newInstance() {
		IIntNetMinorVersionObj inst = new BusModelMinorVersionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelMinorVersionObj.
	 */
	@Override
	public IIntNetMinorVersionEditObj newEditInstance( IIntNetMinorVersionObj orig ) {
		IIntNetMinorVersionEditObj edit = new BusModelMinorVersionEditObj( orig );
		return( edit );
	}

	@Override
	public IIntNetMinorVersionObj constructByClassCode( int backingClassCode ) {
		IIntNetMinorVersionObj obj = null;
		if( backingClassCode == IIntNetMinorVersion.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getMinorVersionTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IIntNetMinorVersionObj realiseMinorVersion( IIntNetMinorVersionObj Obj ) {
		IIntNetMinorVersionObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetMinorVersionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IIntNetMinorVersionObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IIntNetMinorVersionByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByMajorVerIdx != null ) {
				IIntNetMinorVersionByMajorVerIdxKey keyMajorVerIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
				keyMajorVerIdx.setRequiredMajorVersionId( keepObj.getRequiredMajorVersionId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > mapMajorVerIdx = indexByMajorVerIdx.get( keyMajorVerIdx );
				if( mapMajorVerIdx != null ) {
					mapMajorVerIdx.remove( keepObj.getPKey() );
					if( mapMajorVerIdx.size() <= 0 ) {
						indexByMajorVerIdx.remove( keyMajorVerIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetMinorVersionByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByNameIdxKey();
				keyNameIdx.setRequiredMajorVersionId( keepObj.getRequiredMajorVersionId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IIntNetMinorVersionByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMajorVerIdx != null ) {
				IIntNetMinorVersionByMajorVerIdxKey keyMajorVerIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
				keyMajorVerIdx.setRequiredMajorVersionId( keepObj.getRequiredMajorVersionId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > mapMajorVerIdx = indexByMajorVerIdx.get( keyMajorVerIdx );
				if( mapMajorVerIdx != null ) {
					mapMajorVerIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetMinorVersionByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByNameIdxKey();
				keyNameIdx.setRequiredMajorVersionId( keepObj.getRequiredMajorVersionId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allMinorVersion != null ) {
				allMinorVersion.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allMinorVersion != null ) {
				allMinorVersion.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IIntNetMinorVersionByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMajorVerIdx != null ) {
				IIntNetMinorVersionByMajorVerIdxKey keyMajorVerIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
				keyMajorVerIdx.setRequiredMajorVersionId( keepObj.getRequiredMajorVersionId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > mapMajorVerIdx = indexByMajorVerIdx.get( keyMajorVerIdx );
				if( mapMajorVerIdx != null ) {
					mapMajorVerIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetMinorVersionByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByNameIdxKey();
				keyNameIdx.setRequiredMajorVersionId( keepObj.getRequiredMajorVersionId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IIntNetMinorVersionObj createMinorVersion( IIntNetMinorVersionObj Obj ) {
		IIntNetMinorVersionObj obj = Obj;
		IIntNetMinorVersion rec = obj.getMinorVersionRec();
		schema.getIntNetBackingStore().getTableMinorVersion().createMinorVersion(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IIntNetMinorVersionObj readMinorVersion( $implCommaIJavaOptAtomType$ pkey ) {
		return( readMinorVersion( pkey, false ) );
	}

	@Override
	public IIntNetMinorVersionObj readMinorVersion( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IIntNetMinorVersionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IIntNetMinorVersion readRec = schema.getIntNetBackingStore().getTableMinorVersion().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getMinorVersionTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IIntNetMinorVersionObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetMinorVersionObj readCachedMinorVersion( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetMinorVersionObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeMinorVersion( IIntNetMinorVersionObj obj )
	{
		final String S_ProcName = "BusModelMinorVersionTableObj.reallyDeepDisposeMinorVersion() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetMinorVersionObj existing = readCachedMinorVersion( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IIntNetMinorVersionByTenantIdxKey keyTenantIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IIntNetMinorVersionByMajorVerIdxKey keyMajorVerIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
		keyMajorVerIdx.setRequiredMajorVersionId( existing.getRequiredMajorVersionId() );

		IIntNetMinorVersionByNameIdxKey keyNameIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByNameIdxKey();
		keyNameIdx.setRequiredMajorVersionId( existing.getRequiredMajorVersionId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getSchemaDefTableObj().deepDisposeSchemaDefByMinorVersionIdx( existing.getRequiredId() );

		if( indexByTenantIdx != null ) {
			if( indexByTenantIdx.containsKey( keyTenantIdx ) ) {
				indexByTenantIdx.get( keyTenantIdx ).remove( pkey );
				if( indexByTenantIdx.get( keyTenantIdx ).size() <= 0 ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}
		}

		if( indexByMajorVerIdx != null ) {
			if( indexByMajorVerIdx.containsKey( keyMajorVerIdx ) ) {
				indexByMajorVerIdx.get( keyMajorVerIdx ).remove( pkey );
				if( indexByMajorVerIdx.get( keyMajorVerIdx ).size() <= 0 ) {
					indexByMajorVerIdx.remove( keyMajorVerIdx );
				}
			}
		}

		if( indexByNameIdx != null ) {
			indexByNameIdx.remove( keyNameIdx );
		}


	}
	@Override
	public void deepDisposeMinorVersion( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetMinorVersionObj obj = readCachedMinorVersion( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetMinorVersionObj lockMinorVersion( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetMinorVersionObj locked = null;
		IIntNetMinorVersion lockRec = schema.getIntNetBackingStore().getTableMinorVersion().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getMinorVersionTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IIntNetMinorVersionObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockMinorVersion", pkey );
		}
		return( locked );
	}

	@Override
	public List<IIntNetMinorVersionObj> readAllMinorVersion() {
		return( readAllMinorVersion( false ) );
	}

	@Override
	public List<IIntNetMinorVersionObj> readAllMinorVersion( boolean forceRead ) {
		final String S_ProcName = "readAllMinorVersion";
		if( ( allMinorVersion == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj> map = new HashMap<$implCommaIJavaOptAtomType$,IIntNetMinorVersionObj>();
			allMinorVersion = map;
			IIntNetMinorVersion[] recList = schema.getIntNetBackingStore().getTableMinorVersion().readAllDerived( null );
			IIntNetMinorVersion rec;
			IIntNetMinorVersionObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetMinorVersionObj realised = (IIntNetMinorVersionObj)obj.realise();
			}
		}
		int len = allMinorVersion.size();
		IIntNetMinorVersionObj arr[] = new IIntNetMinorVersionObj[len];
		Iterator<IIntNetMinorVersionObj> valIter = allMinorVersion.values().iterator();
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
		ArrayList<IIntNetMinorVersionObj> arrayList = new ArrayList<IIntNetMinorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetMinorVersionObj> cmp = new Comparator<IIntNetMinorVersionObj>() {
			@Override
			public int compare( IIntNetMinorVersionObj lhs, IIntNetMinorVersionObj rhs ) {
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
		List<IIntNetMinorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetMinorVersionObj> readCachedAllMinorVersion() {
		final String S_ProcName = "readCachedAllMinorVersion";
		ArrayList<IIntNetMinorVersionObj> arrayList = new ArrayList<IIntNetMinorVersionObj>();
		if( allMinorVersion != null ) {
			int len = allMinorVersion.size();
			IIntNetMinorVersionObj arr[] = new IIntNetMinorVersionObj[len];
			Iterator<IIntNetMinorVersionObj> valIter = allMinorVersion.values().iterator();
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
		Comparator<IIntNetMinorVersionObj> cmp = new Comparator<IIntNetMinorVersionObj>() {
			public int compare( IIntNetMinorVersionObj lhs, IIntNetMinorVersionObj rhs ) {
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
	public IIntNetMinorVersionObj readMinorVersionByIdIdx( IYCFKeyHash256 Id )
	{
		return( readMinorVersionByIdIdx( Id,
			false ) );
	}

	@Override
	public IIntNetMinorVersionObj readMinorVersionByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IIntNetMinorVersionObj obj = readMinorVersion( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IIntNetMinorVersionObj> readMinorVersionByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readMinorVersionByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IIntNetMinorVersionObj> readMinorVersionByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readMinorVersionByTenantIdx";
		IIntNetMinorVersionByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetMinorVersionByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj>();
			IIntNetMinorVersionObj obj;
			IIntNetMinorVersion[] recList = schema.getIntNetBackingStore().getTableMinorVersion().readDerivedByTenantIdx( null,
				TenantId );
			IIntNetMinorVersion rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getMinorVersionTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetMinorVersionObj realised = (IIntNetMinorVersionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetMinorVersionObj arr[] = new IIntNetMinorVersionObj[len];
		Iterator<IIntNetMinorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetMinorVersionObj> arrayList = new ArrayList<IIntNetMinorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetMinorVersionObj> cmp = new Comparator<IIntNetMinorVersionObj>() {
			@Override
			public int compare( IIntNetMinorVersionObj lhs, IIntNetMinorVersionObj rhs ) {
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
		List<IIntNetMinorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetMinorVersionObj> readMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId )
	{
		return( readMinorVersionByMajorVerIdx( MajorVersionId,
			false ) );
	}

	@Override
	public List<IIntNetMinorVersionObj> readMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId,
		boolean forceRead )
	{
		final String S_ProcName = "readMinorVersionByMajorVerIdx";
		IIntNetMinorVersionByMajorVerIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
		key.setRequiredMajorVersionId( MajorVersionId );
		Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj> dict;
		if( indexByMajorVerIdx == null ) {
			indexByMajorVerIdx = new HashMap< IIntNetMinorVersionByMajorVerIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > >();
		}
		if( ( ! forceRead ) && indexByMajorVerIdx.containsKey( key ) ) {
			dict = indexByMajorVerIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj>();
			IIntNetMinorVersionObj obj;
			IIntNetMinorVersion[] recList = schema.getIntNetBackingStore().getTableMinorVersion().readDerivedByMajorVerIdx( null,
				MajorVersionId );
			IIntNetMinorVersion rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getMinorVersionTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetMinorVersionObj realised = (IIntNetMinorVersionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMajorVerIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetMinorVersionObj arr[] = new IIntNetMinorVersionObj[len];
		Iterator<IIntNetMinorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetMinorVersionObj> arrayList = new ArrayList<IIntNetMinorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetMinorVersionObj> cmp = new Comparator<IIntNetMinorVersionObj>() {
			@Override
			public int compare( IIntNetMinorVersionObj lhs, IIntNetMinorVersionObj rhs ) {
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
		List<IIntNetMinorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IIntNetMinorVersionObj readMinorVersionByNameIdx( IYCFKeyHash256 MajorVersionId,
		String Name )
	{
		return( readMinorVersionByNameIdx( MajorVersionId,
			Name,
			false ) );
	}

	@Override
	public IIntNetMinorVersionObj readMinorVersionByNameIdx( IYCFKeyHash256 MajorVersionId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetMinorVersionByNameIdxKey,
				IIntNetMinorVersionObj >();
		}
		IIntNetMinorVersionByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByNameIdxKey();
		key.setRequiredMajorVersionId( MajorVersionId );
		key.setRequiredName( Name );
		IIntNetMinorVersionObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			IIntNetMinorVersion rec = schema.getIntNetBackingStore().getTableMinorVersion().readDerivedByNameIdx( null,
				MajorVersionId,
				Name );
			if( rec != null ) {
				obj = schema.getMinorVersionTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IIntNetMinorVersionObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetMinorVersionObj readCachedMinorVersionByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetMinorVersionObj obj = null;
		obj = readCachedMinorVersion( Id );
		return( obj );
	}

	@Override
	public List<IIntNetMinorVersionObj> readCachedMinorVersionByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedMinorVersionByTenantIdx";
		IIntNetMinorVersionByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IIntNetMinorVersionObj> arrayList = new ArrayList<IIntNetMinorVersionObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IIntNetMinorVersionObj arr[] = new IIntNetMinorVersionObj[len];
				Iterator<IIntNetMinorVersionObj> valIter = dict.values().iterator();
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
			IIntNetMinorVersionObj obj;
			Iterator<IIntNetMinorVersionObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetMinorVersionObj> cmp = new Comparator<IIntNetMinorVersionObj>() {
			@Override
			public int compare( IIntNetMinorVersionObj lhs, IIntNetMinorVersionObj rhs ) {
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
	public List<IIntNetMinorVersionObj> readCachedMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId )
	{
		final String S_ProcName = "readCachedMinorVersionByMajorVerIdx";
		IIntNetMinorVersionByMajorVerIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
		key.setRequiredMajorVersionId( MajorVersionId );
		ArrayList<IIntNetMinorVersionObj> arrayList = new ArrayList<IIntNetMinorVersionObj>();
		if( indexByMajorVerIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj> dict;
			if( indexByMajorVerIdx.containsKey( key ) ) {
				dict = indexByMajorVerIdx.get( key );
				int len = dict.size();
				IIntNetMinorVersionObj arr[] = new IIntNetMinorVersionObj[len];
				Iterator<IIntNetMinorVersionObj> valIter = dict.values().iterator();
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
			IIntNetMinorVersionObj obj;
			Iterator<IIntNetMinorVersionObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetMinorVersionObj> cmp = new Comparator<IIntNetMinorVersionObj>() {
			@Override
			public int compare( IIntNetMinorVersionObj lhs, IIntNetMinorVersionObj rhs ) {
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
	public IIntNetMinorVersionObj readCachedMinorVersionByNameIdx( IYCFKeyHash256 MajorVersionId,
		String Name )
	{
		IIntNetMinorVersionObj obj = null;
		IIntNetMinorVersionByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByNameIdxKey();
		key.setRequiredMajorVersionId( MajorVersionId );
		key.setRequiredName( Name );
		if( indexByNameIdx != null ) {
			if( indexByNameIdx.containsKey( key ) ) {
				obj = indexByNameIdx.get( key );
			}
			else {
				Iterator<IIntNetMinorVersionObj> valIter = members.values().iterator();
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
			Iterator<IIntNetMinorVersionObj> valIter = members.values().iterator();
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
	public void deepDisposeMinorVersionByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetMinorVersionObj obj = readCachedMinorVersionByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeMinorVersionByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeMinorVersionByTenantIdx";
		IIntNetMinorVersionObj obj;
		List<IIntNetMinorVersionObj> arrayList = readCachedMinorVersionByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IIntNetMinorVersionObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId )
	{
		final String S_ProcName = "deepDisposeMinorVersionByMajorVerIdx";
		IIntNetMinorVersionObj obj;
		List<IIntNetMinorVersionObj> arrayList = readCachedMinorVersionByMajorVerIdx( MajorVersionId );
		if( arrayList != null )  {
			Iterator<IIntNetMinorVersionObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeMinorVersionByNameIdx( IYCFKeyHash256 MajorVersionId,
		String Name )
	{
		IIntNetMinorVersionObj obj = readCachedMinorVersionByNameIdx( MajorVersionId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetMinorVersionObj updateMinorVersion( IIntNetMinorVersionObj Obj ) {
		IIntNetMinorVersionObj obj = Obj;
		schema.getIntNetBackingStore().getTableMinorVersion().updateMinorVersion( null,
			Obj.getMinorVersionRec() );
		obj = (IIntNetMinorVersionObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteMinorVersion( IIntNetMinorVersionObj Obj ) {
		IIntNetMinorVersionObj obj = Obj;
		schema.getIntNetBackingStore().getTableMinorVersion().deleteMinorVersion( null,
			obj.getMinorVersionRec() );
		Obj.forget();
	}

	@Override
	public void deleteMinorVersionByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetMinorVersionObj obj = readMinorVersion(Id);
		if( obj != null ) {
			IIntNetMinorVersionEditObj editObj = (IIntNetMinorVersionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IIntNetMinorVersionEditObj)obj.beginEdit();
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
		deepDisposeMinorVersionByIdIdx( Id );
	}

	@Override
	public void deleteMinorVersionByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IIntNetMinorVersionByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetMinorVersionByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj> dict = indexByTenantIdx.get( key );
			schema.getIntNetBackingStore().getTableMinorVersion().deleteMinorVersionByTenantIdx( null,
				TenantId );
			Iterator<IIntNetMinorVersionObj> iter = dict.values().iterator();
			IIntNetMinorVersionObj obj;
			List<IIntNetMinorVersionObj> toForget = new LinkedList<IIntNetMinorVersionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByTenantIdx.remove( key );
		}
		else {
			schema.getIntNetBackingStore().getTableMinorVersion().deleteMinorVersionByTenantIdx( null,
				TenantId );
		}
		deepDisposeMinorVersionByTenantIdx( TenantId );
	}

	@Override
	public void deleteMinorVersionByMajorVerIdx( IYCFKeyHash256 MajorVersionId )
	{
		IIntNetMinorVersionByMajorVerIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByMajorVerIdxKey();
		key.setRequiredMajorVersionId( MajorVersionId );
		if( indexByMajorVerIdx == null ) {
			indexByMajorVerIdx = new HashMap< IIntNetMinorVersionByMajorVerIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetMinorVersionObj > >();
		}
		if( indexByMajorVerIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMinorVersionObj> dict = indexByMajorVerIdx.get( key );
			schema.getIntNetBackingStore().getTableMinorVersion().deleteMinorVersionByMajorVerIdx( null,
				MajorVersionId );
			Iterator<IIntNetMinorVersionObj> iter = dict.values().iterator();
			IIntNetMinorVersionObj obj;
			List<IIntNetMinorVersionObj> toForget = new LinkedList<IIntNetMinorVersionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByMajorVerIdx.remove( key );
		}
		else {
			schema.getIntNetBackingStore().getTableMinorVersion().deleteMinorVersionByMajorVerIdx( null,
				MajorVersionId );
		}
		deepDisposeMinorVersionByMajorVerIdx( MajorVersionId );
	}

	@Override
	public void deleteMinorVersionByNameIdx( IYCFKeyHash256 MajorVersionId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetMinorVersionByNameIdxKey,
				IIntNetMinorVersionObj >();
		}
		IIntNetMinorVersionByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMinorVersion().newByNameIdxKey();
		key.setRequiredMajorVersionId( MajorVersionId );
		key.setRequiredName( Name );
		IIntNetMinorVersionObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getIntNetBackingStore().getTableMinorVersion().deleteMinorVersionByNameIdx( null,
				MajorVersionId,
				Name );
			obj.forget();
		}
		else {
			schema.getIntNetBackingStore().getTableMinorVersion().deleteMinorVersionByNameIdx( null,
				MajorVersionId,
				Name );
		}
		deepDisposeMinorVersionByNameIdx( MajorVersionId,
				Name );
	}
}