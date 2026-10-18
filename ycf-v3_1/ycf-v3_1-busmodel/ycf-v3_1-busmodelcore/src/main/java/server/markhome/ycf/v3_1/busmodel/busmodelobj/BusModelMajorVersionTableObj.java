// Description: Java 25 Table Object implementation for MajorVersion.

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

public class BusModelMajorVersionTableObj
	implements IBusModelMajorVersionTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj> members;
	private Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj> allMajorVersion;
	private Map< IIntNetMajorVersionByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > > indexByTenantIdx;
	private Map< IIntNetMajorVersionBySubProjectIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > > indexBySubProjectIdx;
	private Map< IIntNetMajorVersionByNameIdxKey,
		IIntNetMajorVersionObj > indexByNameIdx;
	public static String TABLE_NAME = "MajorVersion";
	public static String TABLE_DBNAME = "mjvrdef";

	public BusModelMajorVersionTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj>();
		allMajorVersion = null;
		indexByTenantIdx = null;
		indexBySubProjectIdx = null;
		indexByNameIdx = null;
	}

	public BusModelMajorVersionTableObj( IIntNetSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj>();
		allMajorVersion = null;
		indexByTenantIdx = null;
		indexBySubProjectIdx = null;
		indexByNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return IntNetMajorVersionTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( IntNetMajorVersionTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( IntNetMajorVersionTableObj.getRuntimeClassCode() );
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
		allMajorVersion = null;
		indexByTenantIdx = null;
		indexBySubProjectIdx = null;
		indexByNameIdx = null;
		List<IIntNetMajorVersionObj> toForget = new LinkedList<IIntNetMajorVersionObj>();
		IIntNetMajorVersionObj cur = null;
		Iterator<IIntNetMajorVersionObj> iter = members.values().iterator();
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
	 *	BusModelMajorVersionObj.
	 */
	@Override
	public IIntNetMajorVersionObj newInstance() {
		IIntNetMajorVersionObj inst = new BusModelMajorVersionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelMajorVersionObj.
	 */
	@Override
	public IIntNetMajorVersionEditObj newEditInstance( IIntNetMajorVersionObj orig ) {
		IIntNetMajorVersionEditObj edit = new BusModelMajorVersionEditObj( orig );
		return( edit );
	}

	@Override
	public IIntNetMajorVersionObj constructByClassCode( int backingClassCode ) {
		IIntNetMajorVersionObj obj = null;
		if( backingClassCode == IIntNetMajorVersion.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getMajorVersionTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IIntNetMajorVersionObj realiseMajorVersion( IIntNetMajorVersionObj Obj ) {
		IIntNetMajorVersionObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetMajorVersionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IIntNetMajorVersionObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IIntNetMajorVersionByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexBySubProjectIdx != null ) {
				IIntNetMajorVersionBySubProjectIdxKey keySubProjectIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
				keySubProjectIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > mapSubProjectIdx = indexBySubProjectIdx.get( keySubProjectIdx );
				if( mapSubProjectIdx != null ) {
					mapSubProjectIdx.remove( keepObj.getPKey() );
					if( mapSubProjectIdx.size() <= 0 ) {
						indexBySubProjectIdx.remove( keySubProjectIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetMajorVersionByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByNameIdxKey();
				keyNameIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IIntNetMajorVersionByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySubProjectIdx != null ) {
				IIntNetMajorVersionBySubProjectIdxKey keySubProjectIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
				keySubProjectIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > mapSubProjectIdx = indexBySubProjectIdx.get( keySubProjectIdx );
				if( mapSubProjectIdx != null ) {
					mapSubProjectIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetMajorVersionByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByNameIdxKey();
				keyNameIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allMajorVersion != null ) {
				allMajorVersion.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allMajorVersion != null ) {
				allMajorVersion.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IIntNetMajorVersionByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySubProjectIdx != null ) {
				IIntNetMajorVersionBySubProjectIdxKey keySubProjectIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
				keySubProjectIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > mapSubProjectIdx = indexBySubProjectIdx.get( keySubProjectIdx );
				if( mapSubProjectIdx != null ) {
					mapSubProjectIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetMajorVersionByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByNameIdxKey();
				keyNameIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IIntNetMajorVersionObj createMajorVersion( IIntNetMajorVersionObj Obj ) {
		IIntNetMajorVersionObj obj = Obj;
		IIntNetMajorVersion rec = obj.getMajorVersionRec();
		schema.getIntNetBackingStore().getTableMajorVersion().createMajorVersion(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IIntNetMajorVersionObj readMajorVersion( $implCommaIJavaOptAtomType$ pkey ) {
		return( readMajorVersion( pkey, false ) );
	}

	@Override
	public IIntNetMajorVersionObj readMajorVersion( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IIntNetMajorVersionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IIntNetMajorVersion readRec = schema.getIntNetBackingStore().getTableMajorVersion().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getMajorVersionTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IIntNetMajorVersionObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetMajorVersionObj readCachedMajorVersion( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetMajorVersionObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeMajorVersion( IIntNetMajorVersionObj obj )
	{
		final String S_ProcName = "BusModelMajorVersionTableObj.reallyDeepDisposeMajorVersion() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetMajorVersionObj existing = readCachedMajorVersion( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IIntNetMajorVersionByTenantIdxKey keyTenantIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IIntNetMajorVersionBySubProjectIdxKey keySubProjectIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
		keySubProjectIdx.setRequiredSubProjectId( existing.getRequiredSubProjectId() );

		IIntNetMajorVersionByNameIdxKey keyNameIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByNameIdxKey();
		keyNameIdx.setRequiredSubProjectId( existing.getRequiredSubProjectId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getMinorVersionTableObj().deepDisposeMinorVersionByMajorVerIdx( existing.getRequiredId() );

		if( indexByTenantIdx != null ) {
			if( indexByTenantIdx.containsKey( keyTenantIdx ) ) {
				indexByTenantIdx.get( keyTenantIdx ).remove( pkey );
				if( indexByTenantIdx.get( keyTenantIdx ).size() <= 0 ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}
		}

		if( indexBySubProjectIdx != null ) {
			if( indexBySubProjectIdx.containsKey( keySubProjectIdx ) ) {
				indexBySubProjectIdx.get( keySubProjectIdx ).remove( pkey );
				if( indexBySubProjectIdx.get( keySubProjectIdx ).size() <= 0 ) {
					indexBySubProjectIdx.remove( keySubProjectIdx );
				}
			}
		}

		if( indexByNameIdx != null ) {
			indexByNameIdx.remove( keyNameIdx );
		}


	}
	@Override
	public void deepDisposeMajorVersion( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetMajorVersionObj obj = readCachedMajorVersion( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetMajorVersionObj lockMajorVersion( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetMajorVersionObj locked = null;
		IIntNetMajorVersion lockRec = schema.getIntNetBackingStore().getTableMajorVersion().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getMajorVersionTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IIntNetMajorVersionObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockMajorVersion", pkey );
		}
		return( locked );
	}

	@Override
	public List<IIntNetMajorVersionObj> readAllMajorVersion() {
		return( readAllMajorVersion( false ) );
	}

	@Override
	public List<IIntNetMajorVersionObj> readAllMajorVersion( boolean forceRead ) {
		final String S_ProcName = "readAllMajorVersion";
		if( ( allMajorVersion == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj> map = new HashMap<$implCommaIJavaOptAtomType$,IIntNetMajorVersionObj>();
			allMajorVersion = map;
			IIntNetMajorVersion[] recList = schema.getIntNetBackingStore().getTableMajorVersion().readAllDerived( null );
			IIntNetMajorVersion rec;
			IIntNetMajorVersionObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetMajorVersionObj realised = (IIntNetMajorVersionObj)obj.realise();
			}
		}
		int len = allMajorVersion.size();
		IIntNetMajorVersionObj arr[] = new IIntNetMajorVersionObj[len];
		Iterator<IIntNetMajorVersionObj> valIter = allMajorVersion.values().iterator();
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
		ArrayList<IIntNetMajorVersionObj> arrayList = new ArrayList<IIntNetMajorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetMajorVersionObj> cmp = new Comparator<IIntNetMajorVersionObj>() {
			@Override
			public int compare( IIntNetMajorVersionObj lhs, IIntNetMajorVersionObj rhs ) {
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
		List<IIntNetMajorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetMajorVersionObj> readCachedAllMajorVersion() {
		final String S_ProcName = "readCachedAllMajorVersion";
		ArrayList<IIntNetMajorVersionObj> arrayList = new ArrayList<IIntNetMajorVersionObj>();
		if( allMajorVersion != null ) {
			int len = allMajorVersion.size();
			IIntNetMajorVersionObj arr[] = new IIntNetMajorVersionObj[len];
			Iterator<IIntNetMajorVersionObj> valIter = allMajorVersion.values().iterator();
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
		Comparator<IIntNetMajorVersionObj> cmp = new Comparator<IIntNetMajorVersionObj>() {
			public int compare( IIntNetMajorVersionObj lhs, IIntNetMajorVersionObj rhs ) {
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
	public IIntNetMajorVersionObj readMajorVersionByIdIdx( IYCFKeyHash256 Id )
	{
		return( readMajorVersionByIdIdx( Id,
			false ) );
	}

	@Override
	public IIntNetMajorVersionObj readMajorVersionByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IIntNetMajorVersionObj obj = readMajorVersion( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IIntNetMajorVersionObj> readMajorVersionByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readMajorVersionByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IIntNetMajorVersionObj> readMajorVersionByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readMajorVersionByTenantIdx";
		IIntNetMajorVersionByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetMajorVersionByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj>();
			IIntNetMajorVersionObj obj;
			IIntNetMajorVersion[] recList = schema.getIntNetBackingStore().getTableMajorVersion().readDerivedByTenantIdx( null,
				TenantId );
			IIntNetMajorVersion rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getMajorVersionTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetMajorVersionObj realised = (IIntNetMajorVersionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetMajorVersionObj arr[] = new IIntNetMajorVersionObj[len];
		Iterator<IIntNetMajorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetMajorVersionObj> arrayList = new ArrayList<IIntNetMajorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetMajorVersionObj> cmp = new Comparator<IIntNetMajorVersionObj>() {
			@Override
			public int compare( IIntNetMajorVersionObj lhs, IIntNetMajorVersionObj rhs ) {
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
		List<IIntNetMajorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetMajorVersionObj> readMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId )
	{
		return( readMajorVersionBySubProjectIdx( SubProjectId,
			false ) );
	}

	@Override
	public List<IIntNetMajorVersionObj> readMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId,
		boolean forceRead )
	{
		final String S_ProcName = "readMajorVersionBySubProjectIdx";
		IIntNetMajorVersionBySubProjectIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
		key.setRequiredSubProjectId( SubProjectId );
		Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj> dict;
		if( indexBySubProjectIdx == null ) {
			indexBySubProjectIdx = new HashMap< IIntNetMajorVersionBySubProjectIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > >();
		}
		if( ( ! forceRead ) && indexBySubProjectIdx.containsKey( key ) ) {
			dict = indexBySubProjectIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj>();
			IIntNetMajorVersionObj obj;
			IIntNetMajorVersion[] recList = schema.getIntNetBackingStore().getTableMajorVersion().readDerivedBySubProjectIdx( null,
				SubProjectId );
			IIntNetMajorVersion rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getMajorVersionTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetMajorVersionObj realised = (IIntNetMajorVersionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySubProjectIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetMajorVersionObj arr[] = new IIntNetMajorVersionObj[len];
		Iterator<IIntNetMajorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetMajorVersionObj> arrayList = new ArrayList<IIntNetMajorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetMajorVersionObj> cmp = new Comparator<IIntNetMajorVersionObj>() {
			@Override
			public int compare( IIntNetMajorVersionObj lhs, IIntNetMajorVersionObj rhs ) {
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
		List<IIntNetMajorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IIntNetMajorVersionObj readMajorVersionByNameIdx( IYCFKeyHash256 SubProjectId,
		String Name )
	{
		return( readMajorVersionByNameIdx( SubProjectId,
			Name,
			false ) );
	}

	@Override
	public IIntNetMajorVersionObj readMajorVersionByNameIdx( IYCFKeyHash256 SubProjectId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetMajorVersionByNameIdxKey,
				IIntNetMajorVersionObj >();
		}
		IIntNetMajorVersionByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByNameIdxKey();
		key.setRequiredSubProjectId( SubProjectId );
		key.setRequiredName( Name );
		IIntNetMajorVersionObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			IIntNetMajorVersion rec = schema.getIntNetBackingStore().getTableMajorVersion().readDerivedByNameIdx( null,
				SubProjectId,
				Name );
			if( rec != null ) {
				obj = schema.getMajorVersionTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IIntNetMajorVersionObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetMajorVersionObj readCachedMajorVersionByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetMajorVersionObj obj = null;
		obj = readCachedMajorVersion( Id );
		return( obj );
	}

	@Override
	public List<IIntNetMajorVersionObj> readCachedMajorVersionByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedMajorVersionByTenantIdx";
		IIntNetMajorVersionByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IIntNetMajorVersionObj> arrayList = new ArrayList<IIntNetMajorVersionObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IIntNetMajorVersionObj arr[] = new IIntNetMajorVersionObj[len];
				Iterator<IIntNetMajorVersionObj> valIter = dict.values().iterator();
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
			IIntNetMajorVersionObj obj;
			Iterator<IIntNetMajorVersionObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetMajorVersionObj> cmp = new Comparator<IIntNetMajorVersionObj>() {
			@Override
			public int compare( IIntNetMajorVersionObj lhs, IIntNetMajorVersionObj rhs ) {
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
	public List<IIntNetMajorVersionObj> readCachedMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId )
	{
		final String S_ProcName = "readCachedMajorVersionBySubProjectIdx";
		IIntNetMajorVersionBySubProjectIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
		key.setRequiredSubProjectId( SubProjectId );
		ArrayList<IIntNetMajorVersionObj> arrayList = new ArrayList<IIntNetMajorVersionObj>();
		if( indexBySubProjectIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj> dict;
			if( indexBySubProjectIdx.containsKey( key ) ) {
				dict = indexBySubProjectIdx.get( key );
				int len = dict.size();
				IIntNetMajorVersionObj arr[] = new IIntNetMajorVersionObj[len];
				Iterator<IIntNetMajorVersionObj> valIter = dict.values().iterator();
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
			IIntNetMajorVersionObj obj;
			Iterator<IIntNetMajorVersionObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetMajorVersionObj> cmp = new Comparator<IIntNetMajorVersionObj>() {
			@Override
			public int compare( IIntNetMajorVersionObj lhs, IIntNetMajorVersionObj rhs ) {
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
	public IIntNetMajorVersionObj readCachedMajorVersionByNameIdx( IYCFKeyHash256 SubProjectId,
		String Name )
	{
		IIntNetMajorVersionObj obj = null;
		IIntNetMajorVersionByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByNameIdxKey();
		key.setRequiredSubProjectId( SubProjectId );
		key.setRequiredName( Name );
		if( indexByNameIdx != null ) {
			if( indexByNameIdx.containsKey( key ) ) {
				obj = indexByNameIdx.get( key );
			}
			else {
				Iterator<IIntNetMajorVersionObj> valIter = members.values().iterator();
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
			Iterator<IIntNetMajorVersionObj> valIter = members.values().iterator();
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
	public void deepDisposeMajorVersionByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetMajorVersionObj obj = readCachedMajorVersionByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeMajorVersionByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeMajorVersionByTenantIdx";
		IIntNetMajorVersionObj obj;
		List<IIntNetMajorVersionObj> arrayList = readCachedMajorVersionByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IIntNetMajorVersionObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId )
	{
		final String S_ProcName = "deepDisposeMajorVersionBySubProjectIdx";
		IIntNetMajorVersionObj obj;
		List<IIntNetMajorVersionObj> arrayList = readCachedMajorVersionBySubProjectIdx( SubProjectId );
		if( arrayList != null )  {
			Iterator<IIntNetMajorVersionObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeMajorVersionByNameIdx( IYCFKeyHash256 SubProjectId,
		String Name )
	{
		IIntNetMajorVersionObj obj = readCachedMajorVersionByNameIdx( SubProjectId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetMajorVersionObj updateMajorVersion( IIntNetMajorVersionObj Obj ) {
		IIntNetMajorVersionObj obj = Obj;
		schema.getIntNetBackingStore().getTableMajorVersion().updateMajorVersion( null,
			Obj.getMajorVersionRec() );
		obj = (IIntNetMajorVersionObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteMajorVersion( IIntNetMajorVersionObj Obj ) {
		IIntNetMajorVersionObj obj = Obj;
		schema.getIntNetBackingStore().getTableMajorVersion().deleteMajorVersion( null,
			obj.getMajorVersionRec() );
		Obj.forget();
	}

	@Override
	public void deleteMajorVersionByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetMajorVersionObj obj = readMajorVersion(Id);
		if( obj != null ) {
			IIntNetMajorVersionEditObj editObj = (IIntNetMajorVersionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IIntNetMajorVersionEditObj)obj.beginEdit();
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
		deepDisposeMajorVersionByIdIdx( Id );
	}

	@Override
	public void deleteMajorVersionByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IIntNetMajorVersionByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetMajorVersionByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj> dict = indexByTenantIdx.get( key );
			schema.getIntNetBackingStore().getTableMajorVersion().deleteMajorVersionByTenantIdx( null,
				TenantId );
			Iterator<IIntNetMajorVersionObj> iter = dict.values().iterator();
			IIntNetMajorVersionObj obj;
			List<IIntNetMajorVersionObj> toForget = new LinkedList<IIntNetMajorVersionObj>();
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
			schema.getIntNetBackingStore().getTableMajorVersion().deleteMajorVersionByTenantIdx( null,
				TenantId );
		}
		deepDisposeMajorVersionByTenantIdx( TenantId );
	}

	@Override
	public void deleteMajorVersionBySubProjectIdx( IYCFKeyHash256 SubProjectId )
	{
		IIntNetMajorVersionBySubProjectIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newBySubProjectIdxKey();
		key.setRequiredSubProjectId( SubProjectId );
		if( indexBySubProjectIdx == null ) {
			indexBySubProjectIdx = new HashMap< IIntNetMajorVersionBySubProjectIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetMajorVersionObj > >();
		}
		if( indexBySubProjectIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMajorVersionObj> dict = indexBySubProjectIdx.get( key );
			schema.getIntNetBackingStore().getTableMajorVersion().deleteMajorVersionBySubProjectIdx( null,
				SubProjectId );
			Iterator<IIntNetMajorVersionObj> iter = dict.values().iterator();
			IIntNetMajorVersionObj obj;
			List<IIntNetMajorVersionObj> toForget = new LinkedList<IIntNetMajorVersionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySubProjectIdx.remove( key );
		}
		else {
			schema.getIntNetBackingStore().getTableMajorVersion().deleteMajorVersionBySubProjectIdx( null,
				SubProjectId );
		}
		deepDisposeMajorVersionBySubProjectIdx( SubProjectId );
	}

	@Override
	public void deleteMajorVersionByNameIdx( IYCFKeyHash256 SubProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetMajorVersionByNameIdxKey,
				IIntNetMajorVersionObj >();
		}
		IIntNetMajorVersionByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newByNameIdxKey();
		key.setRequiredSubProjectId( SubProjectId );
		key.setRequiredName( Name );
		IIntNetMajorVersionObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getIntNetBackingStore().getTableMajorVersion().deleteMajorVersionByNameIdx( null,
				SubProjectId,
				Name );
			obj.forget();
		}
		else {
			schema.getIntNetBackingStore().getTableMajorVersion().deleteMajorVersionByNameIdx( null,
				SubProjectId,
				Name );
		}
		deepDisposeMajorVersionByNameIdx( SubProjectId,
				Name );
	}
}