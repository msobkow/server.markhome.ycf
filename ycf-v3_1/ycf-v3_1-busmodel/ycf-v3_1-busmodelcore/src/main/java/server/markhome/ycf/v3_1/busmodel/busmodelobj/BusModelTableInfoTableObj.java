// Description: Java 25 Table Object implementation for TableInfo.

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

public class BusModelTableInfoTableObj
	implements IBusModelTableInfoTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj> allTableInfo;
	private Map< ISecureTableInfoByTableNameIdxKey,
		ISecureTableInfoObj > indexByTableNameIdx;
	private Map< ISecureTableInfoBySuperNameIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj > > indexBySuperNameIdx;
	private Map< ISecureTableInfoBySchemaNameIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj > > indexBySchemaNameIdx;
	private Map< ISecureTableInfoBySchemaBkCodeIdxKey,
		ISecureTableInfoObj > indexBySchemaBkCodeIdx;
	private Map< ISecureTableInfoBySchemaRTCodeIdxKey,
		ISecureTableInfoObj > indexBySchemaRTCodeIdx;
	public static String TABLE_NAME = "TableInfo";
	public static String TABLE_DBNAME = "table_info";

	public BusModelTableInfoTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureTableInfoObj>();
		allTableInfo = null;
		indexByTableNameIdx = null;
		indexBySuperNameIdx = null;
		indexBySchemaNameIdx = null;
		indexBySchemaBkCodeIdx = null;
		indexBySchemaRTCodeIdx = null;
	}

	public BusModelTableInfoTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureTableInfoObj>();
		allTableInfo = null;
		indexByTableNameIdx = null;
		indexBySuperNameIdx = null;
		indexBySchemaNameIdx = null;
		indexBySchemaBkCodeIdx = null;
		indexBySchemaRTCodeIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureTableInfoTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureTableInfoTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureTableInfoTableObj.getRuntimeClassCode() );
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
		allTableInfo = null;
		indexByTableNameIdx = null;
		indexBySuperNameIdx = null;
		indexBySchemaNameIdx = null;
		indexBySchemaBkCodeIdx = null;
		indexBySchemaRTCodeIdx = null;
		List<ISecureTableInfoObj> toForget = new LinkedList<ISecureTableInfoObj>();
		ISecureTableInfoObj cur = null;
		Iterator<ISecureTableInfoObj> iter = members.values().iterator();
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
	 *	BusModelTableInfoObj.
	 */
	@Override
	public ISecureTableInfoObj newInstance() {
		ISecureTableInfoObj inst = new BusModelTableInfoObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelTableInfoObj.
	 */
	@Override
	public ISecureTableInfoEditObj newEditInstance( ISecureTableInfoObj orig ) {
		ISecureTableInfoEditObj edit = new BusModelTableInfoEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureTableInfoObj constructByClassCode( int backingClassCode ) {
		ISecureTableInfoObj obj = null;
		if( backingClassCode == ISecureTableInfo.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getTableInfoTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureTableInfoObj realiseTableInfo( ISecureTableInfoObj Obj ) {
		ISecureTableInfoObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureTableInfoObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureTableInfoObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTableNameIdx != null ) {
				ISecureTableInfoByTableNameIdxKey keyTableNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newByTableNameIdxKey();
				keyTableNameIdx.setRequiredTableName( keepObj.getRequiredTableName() );
				indexByTableNameIdx.remove( keyTableNameIdx );
			}

			if( indexBySuperNameIdx != null ) {
				ISecureTableInfoBySuperNameIdxKey keySuperNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySuperNameIdxKey();
				keySuperNameIdx.setOptionalSuperName( keepObj.getOptionalSuperName() );
				Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj > mapSuperNameIdx = indexBySuperNameIdx.get( keySuperNameIdx );
				if( mapSuperNameIdx != null ) {
					mapSuperNameIdx.remove( keepObj.getPKey() );
					if( mapSuperNameIdx.size() <= 0 ) {
						indexBySuperNameIdx.remove( keySuperNameIdx );
					}
				}
			}

			if( indexBySchemaNameIdx != null ) {
				ISecureTableInfoBySchemaNameIdxKey keySchemaNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
				keySchemaNameIdx.setRequiredSchemaName( keepObj.getRequiredSchemaName() );
				Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj > mapSchemaNameIdx = indexBySchemaNameIdx.get( keySchemaNameIdx );
				if( mapSchemaNameIdx != null ) {
					mapSchemaNameIdx.remove( keepObj.getPKey() );
					if( mapSchemaNameIdx.size() <= 0 ) {
						indexBySchemaNameIdx.remove( keySchemaNameIdx );
					}
				}
			}

			if( indexBySchemaBkCodeIdx != null ) {
				ISecureTableInfoBySchemaBkCodeIdxKey keySchemaBkCodeIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
				keySchemaBkCodeIdx.setRequiredSchemaName( keepObj.getRequiredSchemaName() );
				keySchemaBkCodeIdx.setRequiredBackingClassCode( keepObj.getRequiredBackingClassCode() );
				indexBySchemaBkCodeIdx.remove( keySchemaBkCodeIdx );
			}

			if( indexBySchemaRTCodeIdx != null ) {
				ISecureTableInfoBySchemaRTCodeIdxKey keySchemaRTCodeIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
				keySchemaRTCodeIdx.setRequiredRuntimeClassCode( keepObj.getRequiredRuntimeClassCode() );
				indexBySchemaRTCodeIdx.remove( keySchemaRTCodeIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTableNameIdx != null ) {
				ISecureTableInfoByTableNameIdxKey keyTableNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newByTableNameIdxKey();
				keyTableNameIdx.setRequiredTableName( keepObj.getRequiredTableName() );
				indexByTableNameIdx.put( keyTableNameIdx, keepObj );
			}

			if( indexBySuperNameIdx != null ) {
				ISecureTableInfoBySuperNameIdxKey keySuperNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySuperNameIdxKey();
				keySuperNameIdx.setOptionalSuperName( keepObj.getOptionalSuperName() );
				Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj > mapSuperNameIdx = indexBySuperNameIdx.get( keySuperNameIdx );
				if( mapSuperNameIdx != null ) {
					mapSuperNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaNameIdx != null ) {
				ISecureTableInfoBySchemaNameIdxKey keySchemaNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
				keySchemaNameIdx.setRequiredSchemaName( keepObj.getRequiredSchemaName() );
				Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj > mapSchemaNameIdx = indexBySchemaNameIdx.get( keySchemaNameIdx );
				if( mapSchemaNameIdx != null ) {
					mapSchemaNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaBkCodeIdx != null ) {
				ISecureTableInfoBySchemaBkCodeIdxKey keySchemaBkCodeIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
				keySchemaBkCodeIdx.setRequiredSchemaName( keepObj.getRequiredSchemaName() );
				keySchemaBkCodeIdx.setRequiredBackingClassCode( keepObj.getRequiredBackingClassCode() );
				indexBySchemaBkCodeIdx.put( keySchemaBkCodeIdx, keepObj );
			}

			if( indexBySchemaRTCodeIdx != null ) {
				ISecureTableInfoBySchemaRTCodeIdxKey keySchemaRTCodeIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
				keySchemaRTCodeIdx.setRequiredRuntimeClassCode( keepObj.getRequiredRuntimeClassCode() );
				indexBySchemaRTCodeIdx.put( keySchemaRTCodeIdx, keepObj );
			}

			if( allTableInfo != null ) {
				allTableInfo.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTableInfo != null ) {
				allTableInfo.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTableNameIdx != null ) {
				ISecureTableInfoByTableNameIdxKey keyTableNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newByTableNameIdxKey();
				keyTableNameIdx.setRequiredTableName( keepObj.getRequiredTableName() );
				indexByTableNameIdx.put( keyTableNameIdx, keepObj );
			}

			if( indexBySuperNameIdx != null ) {
				ISecureTableInfoBySuperNameIdxKey keySuperNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySuperNameIdxKey();
				keySuperNameIdx.setOptionalSuperName( keepObj.getOptionalSuperName() );
				Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj > mapSuperNameIdx = indexBySuperNameIdx.get( keySuperNameIdx );
				if( mapSuperNameIdx != null ) {
					mapSuperNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaNameIdx != null ) {
				ISecureTableInfoBySchemaNameIdxKey keySchemaNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
				keySchemaNameIdx.setRequiredSchemaName( keepObj.getRequiredSchemaName() );
				Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj > mapSchemaNameIdx = indexBySchemaNameIdx.get( keySchemaNameIdx );
				if( mapSchemaNameIdx != null ) {
					mapSchemaNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaBkCodeIdx != null ) {
				ISecureTableInfoBySchemaBkCodeIdxKey keySchemaBkCodeIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
				keySchemaBkCodeIdx.setRequiredSchemaName( keepObj.getRequiredSchemaName() );
				keySchemaBkCodeIdx.setRequiredBackingClassCode( keepObj.getRequiredBackingClassCode() );
				indexBySchemaBkCodeIdx.put( keySchemaBkCodeIdx, keepObj );
			}

			if( indexBySchemaRTCodeIdx != null ) {
				ISecureTableInfoBySchemaRTCodeIdxKey keySchemaRTCodeIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
				keySchemaRTCodeIdx.setRequiredRuntimeClassCode( keepObj.getRequiredRuntimeClassCode() );
				indexBySchemaRTCodeIdx.put( keySchemaRTCodeIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureTableInfoObj createTableInfo( ISecureTableInfoObj Obj ) {
		ISecureTableInfoObj obj = Obj;
		ISecureTableInfo rec = obj.getTableInfoRec();
		schema.getSecureBackingStore().getTableTableInfo().createTableInfo(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureTableInfoObj readTableInfo( $implCommaIJavaOptAtomType$ pkey ) {
		return( readTableInfo( pkey, false ) );
	}

	@Override
	public ISecureTableInfoObj readTableInfo( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureTableInfoObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureTableInfo readRec = schema.getSecureBackingStore().getTableTableInfo().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getTableInfoTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureTableInfoObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureTableInfoObj readCachedTableInfo( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureTableInfoObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeTableInfo( ISecureTableInfoObj obj )
	{
		final String S_ProcName = "BusModelTableInfoTableObj.reallyDeepDisposeTableInfo() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureTableInfoObj existing = readCachedTableInfo( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureTableInfoByTableNameIdxKey keyTableNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newByTableNameIdxKey();
		keyTableNameIdx.setRequiredTableName( existing.getRequiredTableName() );

		ISecureTableInfoBySuperNameIdxKey keySuperNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySuperNameIdxKey();
		keySuperNameIdx.setOptionalSuperName( existing.getOptionalSuperName() );

		ISecureTableInfoBySchemaNameIdxKey keySchemaNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
		keySchemaNameIdx.setRequiredSchemaName( existing.getRequiredSchemaName() );

		ISecureTableInfoBySchemaBkCodeIdxKey keySchemaBkCodeIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
		keySchemaBkCodeIdx.setRequiredSchemaName( existing.getRequiredSchemaName() );
		keySchemaBkCodeIdx.setRequiredBackingClassCode( existing.getRequiredBackingClassCode() );

		ISecureTableInfoBySchemaRTCodeIdxKey keySchemaRTCodeIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
		keySchemaRTCodeIdx.setRequiredRuntimeClassCode( existing.getRequiredRuntimeClassCode() );


		schema.getTableInfoTableObj().deepDisposeTableInfoBySuperNameIdx( existing.getRequiredTableName() );

		if( indexByTableNameIdx != null ) {
			indexByTableNameIdx.remove( keyTableNameIdx );
		}

		if( indexBySuperNameIdx != null ) {
			if( indexBySuperNameIdx.containsKey( keySuperNameIdx ) ) {
				indexBySuperNameIdx.get( keySuperNameIdx ).remove( pkey );
				if( indexBySuperNameIdx.get( keySuperNameIdx ).size() <= 0 ) {
					indexBySuperNameIdx.remove( keySuperNameIdx );
				}
			}
		}

		if( indexBySchemaNameIdx != null ) {
			if( indexBySchemaNameIdx.containsKey( keySchemaNameIdx ) ) {
				indexBySchemaNameIdx.get( keySchemaNameIdx ).remove( pkey );
				if( indexBySchemaNameIdx.get( keySchemaNameIdx ).size() <= 0 ) {
					indexBySchemaNameIdx.remove( keySchemaNameIdx );
				}
			}
		}

		if( indexBySchemaBkCodeIdx != null ) {
			indexBySchemaBkCodeIdx.remove( keySchemaBkCodeIdx );
		}

		if( indexBySchemaRTCodeIdx != null ) {
			indexBySchemaRTCodeIdx.remove( keySchemaRTCodeIdx );
		}


	}
	@Override
	public void deepDisposeTableInfo( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureTableInfoObj obj = readCachedTableInfo( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureTableInfoObj lockTableInfo( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureTableInfoObj locked = null;
		ISecureTableInfo lockRec = schema.getSecureBackingStore().getTableTableInfo().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getTableInfoTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureTableInfoObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockTableInfo", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureTableInfoObj> readAllTableInfo() {
		return( readAllTableInfo( false ) );
	}

	@Override
	public List<ISecureTableInfoObj> readAllTableInfo( boolean forceRead ) {
		final String S_ProcName = "readAllTableInfo";
		if( ( allTableInfo == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureTableInfoObj>();
			allTableInfo = map;
			ISecureTableInfo[] recList = schema.getSecureBackingStore().getTableTableInfo().readAllDerived( null );
			ISecureTableInfo rec;
			ISecureTableInfoObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureTableInfoObj realised = (ISecureTableInfoObj)obj.realise();
			}
		}
		int len = allTableInfo.size();
		ISecureTableInfoObj arr[] = new ISecureTableInfoObj[len];
		Iterator<ISecureTableInfoObj> valIter = allTableInfo.values().iterator();
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
		ArrayList<ISecureTableInfoObj> arrayList = new ArrayList<ISecureTableInfoObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureTableInfoObj> cmp = new Comparator<ISecureTableInfoObj>() {
			@Override
			public int compare( ISecureTableInfoObj lhs, ISecureTableInfoObj rhs ) {
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
		List<ISecureTableInfoObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureTableInfoObj> readCachedAllTableInfo() {
		final String S_ProcName = "readCachedAllTableInfo";
		ArrayList<ISecureTableInfoObj> arrayList = new ArrayList<ISecureTableInfoObj>();
		if( allTableInfo != null ) {
			int len = allTableInfo.size();
			ISecureTableInfoObj arr[] = new ISecureTableInfoObj[len];
			Iterator<ISecureTableInfoObj> valIter = allTableInfo.values().iterator();
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
		Comparator<ISecureTableInfoObj> cmp = new Comparator<ISecureTableInfoObj>() {
			public int compare( ISecureTableInfoObj lhs, ISecureTableInfoObj rhs ) {
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
	public ISecureTableInfoObj readTableInfoByIdIdx( int TableInfoId )
	{
		return( readTableInfoByIdIdx( TableInfoId,
			false ) );
	}

	@Override
	public ISecureTableInfoObj readTableInfoByIdIdx( int TableInfoId, boolean forceRead )
	{
		ISecureTableInfoObj obj = readTableInfo( TableInfoId, forceRead );
		return( obj );
	}

	@Override
	public ISecureTableInfoObj readTableInfoByTableNameIdx( String TableName )
	{
		return( readTableInfoByTableNameIdx( TableName,
			false ) );
	}

	@Override
	public ISecureTableInfoObj readTableInfoByTableNameIdx( String TableName, boolean forceRead )
	{
		if( indexByTableNameIdx == null ) {
			indexByTableNameIdx = new HashMap< ISecureTableInfoByTableNameIdxKey,
				ISecureTableInfoObj >();
		}
		ISecureTableInfoByTableNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newByTableNameIdxKey();
		key.setRequiredTableName( TableName );
		ISecureTableInfoObj obj = null;
		if( ( ! forceRead ) && indexByTableNameIdx.containsKey( key ) ) {
			obj = indexByTableNameIdx.get( key );
		}
		else {
			ISecureTableInfo rec = schema.getSecureBackingStore().getTableTableInfo().readDerivedByTableNameIdx( null,
				TableName );
			if( rec != null ) {
				obj = schema.getTableInfoTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureTableInfoObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<ISecureTableInfoObj> readTableInfoBySuperNameIdx( String SuperName )
	{
		return( readTableInfoBySuperNameIdx( SuperName,
			false ) );
	}

	@Override
	public List<ISecureTableInfoObj> readTableInfoBySuperNameIdx( String SuperName,
		boolean forceRead )
	{
		final String S_ProcName = "readTableInfoBySuperNameIdx";
		ISecureTableInfoBySuperNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySuperNameIdxKey();
		key.setOptionalSuperName( SuperName );
		Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj> dict;
		if( indexBySuperNameIdx == null ) {
			indexBySuperNameIdx = new HashMap< ISecureTableInfoBySuperNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureTableInfoObj > >();
		}
		if( ( ! forceRead ) && indexBySuperNameIdx.containsKey( key ) ) {
			dict = indexBySuperNameIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureTableInfoObj>();
			ISecureTableInfoObj obj;
			ISecureTableInfo[] recList = schema.getSecureBackingStore().getTableTableInfo().readDerivedBySuperNameIdx( null,
				SuperName );
			ISecureTableInfo rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getTableInfoTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureTableInfoObj realised = (ISecureTableInfoObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySuperNameIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureTableInfoObj arr[] = new ISecureTableInfoObj[len];
		Iterator<ISecureTableInfoObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureTableInfoObj> arrayList = new ArrayList<ISecureTableInfoObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureTableInfoObj> cmp = new Comparator<ISecureTableInfoObj>() {
			@Override
			public int compare( ISecureTableInfoObj lhs, ISecureTableInfoObj rhs ) {
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
		List<ISecureTableInfoObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureTableInfoObj> readTableInfoBySchemaNameIdx( String SchemaName )
	{
		return( readTableInfoBySchemaNameIdx( SchemaName,
			false ) );
	}

	@Override
	public List<ISecureTableInfoObj> readTableInfoBySchemaNameIdx( String SchemaName,
		boolean forceRead )
	{
		final String S_ProcName = "readTableInfoBySchemaNameIdx";
		ISecureTableInfoBySchemaNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
		key.setRequiredSchemaName( SchemaName );
		Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj> dict;
		if( indexBySchemaNameIdx == null ) {
			indexBySchemaNameIdx = new HashMap< ISecureTableInfoBySchemaNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureTableInfoObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaNameIdx.containsKey( key ) ) {
			dict = indexBySchemaNameIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureTableInfoObj>();
			ISecureTableInfoObj obj;
			ISecureTableInfo[] recList = schema.getSecureBackingStore().getTableTableInfo().readDerivedBySchemaNameIdx( null,
				SchemaName );
			ISecureTableInfo rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getTableInfoTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureTableInfoObj realised = (ISecureTableInfoObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaNameIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureTableInfoObj arr[] = new ISecureTableInfoObj[len];
		Iterator<ISecureTableInfoObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureTableInfoObj> arrayList = new ArrayList<ISecureTableInfoObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureTableInfoObj> cmp = new Comparator<ISecureTableInfoObj>() {
			@Override
			public int compare( ISecureTableInfoObj lhs, ISecureTableInfoObj rhs ) {
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
		List<ISecureTableInfoObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureTableInfoObj readTableInfoBySchemaBkCodeIdx( String SchemaName,
		int BackingClassCode )
	{
		return( readTableInfoBySchemaBkCodeIdx( SchemaName,
			BackingClassCode,
			false ) );
	}

	@Override
	public ISecureTableInfoObj readTableInfoBySchemaBkCodeIdx( String SchemaName,
		int BackingClassCode, boolean forceRead )
	{
		if( indexBySchemaBkCodeIdx == null ) {
			indexBySchemaBkCodeIdx = new HashMap< ISecureTableInfoBySchemaBkCodeIdxKey,
				ISecureTableInfoObj >();
		}
		ISecureTableInfoBySchemaBkCodeIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
		key.setRequiredSchemaName( SchemaName );
		key.setRequiredBackingClassCode( BackingClassCode );
		ISecureTableInfoObj obj = null;
		if( ( ! forceRead ) && indexBySchemaBkCodeIdx.containsKey( key ) ) {
			obj = indexBySchemaBkCodeIdx.get( key );
		}
		else {
			ISecureTableInfo rec = schema.getSecureBackingStore().getTableTableInfo().readDerivedBySchemaBkCodeIdx( null,
				SchemaName,
				BackingClassCode );
			if( rec != null ) {
				obj = schema.getTableInfoTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureTableInfoObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureTableInfoObj readTableInfoBySchemaRTCodeIdx( int RuntimeClassCode )
	{
		return( readTableInfoBySchemaRTCodeIdx( RuntimeClassCode,
			false ) );
	}

	@Override
	public ISecureTableInfoObj readTableInfoBySchemaRTCodeIdx( int RuntimeClassCode, boolean forceRead )
	{
		if( indexBySchemaRTCodeIdx == null ) {
			indexBySchemaRTCodeIdx = new HashMap< ISecureTableInfoBySchemaRTCodeIdxKey,
				ISecureTableInfoObj >();
		}
		ISecureTableInfoBySchemaRTCodeIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
		key.setRequiredRuntimeClassCode( RuntimeClassCode );
		ISecureTableInfoObj obj = null;
		if( ( ! forceRead ) && indexBySchemaRTCodeIdx.containsKey( key ) ) {
			obj = indexBySchemaRTCodeIdx.get( key );
		}
		else {
			ISecureTableInfo rec = schema.getSecureBackingStore().getTableTableInfo().readDerivedBySchemaRTCodeIdx( null,
				RuntimeClassCode );
			if( rec != null ) {
				obj = schema.getTableInfoTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureTableInfoObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureTableInfoObj readCachedTableInfoByIdIdx( int TableInfoId )
	{
		ISecureTableInfoObj obj = null;
		obj = readCachedTableInfo( TableInfoId );
		return( obj );
	}

	@Override
	public ISecureTableInfoObj readCachedTableInfoByTableNameIdx( String TableName )
	{
		ISecureTableInfoObj obj = null;
		ISecureTableInfoByTableNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newByTableNameIdxKey();
		key.setRequiredTableName( TableName );
		if( indexByTableNameIdx != null ) {
			if( indexByTableNameIdx.containsKey( key ) ) {
				obj = indexByTableNameIdx.get( key );
			}
			else {
				Iterator<ISecureTableInfoObj> valIter = members.values().iterator();
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
			Iterator<ISecureTableInfoObj> valIter = members.values().iterator();
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
	public List<ISecureTableInfoObj> readCachedTableInfoBySuperNameIdx( String SuperName )
	{
		final String S_ProcName = "readCachedTableInfoBySuperNameIdx";
		ISecureTableInfoBySuperNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySuperNameIdxKey();
		key.setOptionalSuperName( SuperName );
		ArrayList<ISecureTableInfoObj> arrayList = new ArrayList<ISecureTableInfoObj>();
		if( indexBySuperNameIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj> dict;
			if( indexBySuperNameIdx.containsKey( key ) ) {
				dict = indexBySuperNameIdx.get( key );
				int len = dict.size();
				ISecureTableInfoObj arr[] = new ISecureTableInfoObj[len];
				Iterator<ISecureTableInfoObj> valIter = dict.values().iterator();
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
			ISecureTableInfoObj obj;
			Iterator<ISecureTableInfoObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureTableInfoObj> cmp = new Comparator<ISecureTableInfoObj>() {
			@Override
			public int compare( ISecureTableInfoObj lhs, ISecureTableInfoObj rhs ) {
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
	public List<ISecureTableInfoObj> readCachedTableInfoBySchemaNameIdx( String SchemaName )
	{
		final String S_ProcName = "readCachedTableInfoBySchemaNameIdx";
		ISecureTableInfoBySchemaNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
		key.setRequiredSchemaName( SchemaName );
		ArrayList<ISecureTableInfoObj> arrayList = new ArrayList<ISecureTableInfoObj>();
		if( indexBySchemaNameIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj> dict;
			if( indexBySchemaNameIdx.containsKey( key ) ) {
				dict = indexBySchemaNameIdx.get( key );
				int len = dict.size();
				ISecureTableInfoObj arr[] = new ISecureTableInfoObj[len];
				Iterator<ISecureTableInfoObj> valIter = dict.values().iterator();
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
			ISecureTableInfoObj obj;
			Iterator<ISecureTableInfoObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureTableInfoObj> cmp = new Comparator<ISecureTableInfoObj>() {
			@Override
			public int compare( ISecureTableInfoObj lhs, ISecureTableInfoObj rhs ) {
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
	public ISecureTableInfoObj readCachedTableInfoBySchemaBkCodeIdx( String SchemaName,
		int BackingClassCode )
	{
		ISecureTableInfoObj obj = null;
		ISecureTableInfoBySchemaBkCodeIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
		key.setRequiredSchemaName( SchemaName );
		key.setRequiredBackingClassCode( BackingClassCode );
		if( indexBySchemaBkCodeIdx != null ) {
			if( indexBySchemaBkCodeIdx.containsKey( key ) ) {
				obj = indexBySchemaBkCodeIdx.get( key );
			}
			else {
				Iterator<ISecureTableInfoObj> valIter = members.values().iterator();
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
			Iterator<ISecureTableInfoObj> valIter = members.values().iterator();
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
	public ISecureTableInfoObj readCachedTableInfoBySchemaRTCodeIdx( int RuntimeClassCode )
	{
		ISecureTableInfoObj obj = null;
		ISecureTableInfoBySchemaRTCodeIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
		key.setRequiredRuntimeClassCode( RuntimeClassCode );
		if( indexBySchemaRTCodeIdx != null ) {
			if( indexBySchemaRTCodeIdx.containsKey( key ) ) {
				obj = indexBySchemaRTCodeIdx.get( key );
			}
			else {
				Iterator<ISecureTableInfoObj> valIter = members.values().iterator();
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
			Iterator<ISecureTableInfoObj> valIter = members.values().iterator();
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
	public void deepDisposeTableInfoByIdIdx( int TableInfoId )
	{
		ISecureTableInfoObj obj = readCachedTableInfoByIdIdx( TableInfoId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTableInfoByTableNameIdx( String TableName )
	{
		ISecureTableInfoObj obj = readCachedTableInfoByTableNameIdx( TableName );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTableInfoBySuperNameIdx( String SuperName )
	{
		final String S_ProcName = "deepDisposeTableInfoBySuperNameIdx";
		ISecureTableInfoObj obj;
		List<ISecureTableInfoObj> arrayList = readCachedTableInfoBySuperNameIdx( SuperName );
		if( arrayList != null )  {
			Iterator<ISecureTableInfoObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableInfoBySchemaNameIdx( String SchemaName )
	{
		final String S_ProcName = "deepDisposeTableInfoBySchemaNameIdx";
		ISecureTableInfoObj obj;
		List<ISecureTableInfoObj> arrayList = readCachedTableInfoBySchemaNameIdx( SchemaName );
		if( arrayList != null )  {
			Iterator<ISecureTableInfoObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableInfoBySchemaBkCodeIdx( String SchemaName,
		int BackingClassCode )
	{
		ISecureTableInfoObj obj = readCachedTableInfoBySchemaBkCodeIdx( SchemaName,
				BackingClassCode );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTableInfoBySchemaRTCodeIdx( int RuntimeClassCode )
	{
		ISecureTableInfoObj obj = readCachedTableInfoBySchemaRTCodeIdx( RuntimeClassCode );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureTableInfoObj updateTableInfo( ISecureTableInfoObj Obj ) {
		ISecureTableInfoObj obj = Obj;
		schema.getSecureBackingStore().getTableTableInfo().updateTableInfo( null,
			Obj.getTableInfoRec() );
		obj = (ISecureTableInfoObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteTableInfo( ISecureTableInfoObj Obj ) {
		ISecureTableInfoObj obj = Obj;
		schema.getSecureBackingStore().getTableTableInfo().deleteTableInfo( null,
			obj.getTableInfoRec() );
		Obj.forget();
	}

	@Override
	public void deleteTableInfoByIdIdx( int TableInfoId )
	{
		ISecureTableInfoObj obj = readTableInfo(TableInfoId);
		if( obj != null ) {
			ISecureTableInfoEditObj editObj = (ISecureTableInfoEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureTableInfoEditObj)obj.beginEdit();
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
		deepDisposeTableInfoByIdIdx( TableInfoId );
	}

	@Override
	public void deleteTableInfoByTableNameIdx( String TableName )
	{
		if( indexByTableNameIdx == null ) {
			indexByTableNameIdx = new HashMap< ISecureTableInfoByTableNameIdxKey,
				ISecureTableInfoObj >();
		}
		ISecureTableInfoByTableNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newByTableNameIdxKey();
		key.setRequiredTableName( TableName );
		ISecureTableInfoObj obj = null;
		if( indexByTableNameIdx.containsKey( key ) ) {
			obj = indexByTableNameIdx.get( key );
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoByTableNameIdx( null,
				TableName );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoByTableNameIdx( null,
				TableName );
		}
		deepDisposeTableInfoByTableNameIdx( TableName );
	}

	@Override
	public void deleteTableInfoBySuperNameIdx( String SuperName )
	{
		ISecureTableInfoBySuperNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySuperNameIdxKey();
		key.setOptionalSuperName( SuperName );
		if( indexBySuperNameIdx == null ) {
			indexBySuperNameIdx = new HashMap< ISecureTableInfoBySuperNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureTableInfoObj > >();
		}
		if( indexBySuperNameIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj> dict = indexBySuperNameIdx.get( key );
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoBySuperNameIdx( null,
				SuperName );
			Iterator<ISecureTableInfoObj> iter = dict.values().iterator();
			ISecureTableInfoObj obj;
			List<ISecureTableInfoObj> toForget = new LinkedList<ISecureTableInfoObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySuperNameIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoBySuperNameIdx( null,
				SuperName );
		}
		deepDisposeTableInfoBySuperNameIdx( SuperName );
	}

	@Override
	public void deleteTableInfoBySchemaNameIdx( String SchemaName )
	{
		ISecureTableInfoBySchemaNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaNameIdxKey();
		key.setRequiredSchemaName( SchemaName );
		if( indexBySchemaNameIdx == null ) {
			indexBySchemaNameIdx = new HashMap< ISecureTableInfoBySchemaNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureTableInfoObj > >();
		}
		if( indexBySchemaNameIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureTableInfoObj> dict = indexBySchemaNameIdx.get( key );
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoBySchemaNameIdx( null,
				SchemaName );
			Iterator<ISecureTableInfoObj> iter = dict.values().iterator();
			ISecureTableInfoObj obj;
			List<ISecureTableInfoObj> toForget = new LinkedList<ISecureTableInfoObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySchemaNameIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoBySchemaNameIdx( null,
				SchemaName );
		}
		deepDisposeTableInfoBySchemaNameIdx( SchemaName );
	}

	@Override
	public void deleteTableInfoBySchemaBkCodeIdx( String SchemaName,
		int BackingClassCode )
	{
		if( indexBySchemaBkCodeIdx == null ) {
			indexBySchemaBkCodeIdx = new HashMap< ISecureTableInfoBySchemaBkCodeIdxKey,
				ISecureTableInfoObj >();
		}
		ISecureTableInfoBySchemaBkCodeIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaBkCodeIdxKey();
		key.setRequiredSchemaName( SchemaName );
		key.setRequiredBackingClassCode( BackingClassCode );
		ISecureTableInfoObj obj = null;
		if( indexBySchemaBkCodeIdx.containsKey( key ) ) {
			obj = indexBySchemaBkCodeIdx.get( key );
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoBySchemaBkCodeIdx( null,
				SchemaName,
				BackingClassCode );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoBySchemaBkCodeIdx( null,
				SchemaName,
				BackingClassCode );
		}
		deepDisposeTableInfoBySchemaBkCodeIdx( SchemaName,
				BackingClassCode );
	}

	@Override
	public void deleteTableInfoBySchemaRTCodeIdx( int RuntimeClassCode )
	{
		if( indexBySchemaRTCodeIdx == null ) {
			indexBySchemaRTCodeIdx = new HashMap< ISecureTableInfoBySchemaRTCodeIdxKey,
				ISecureTableInfoObj >();
		}
		ISecureTableInfoBySchemaRTCodeIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newBySchemaRTCodeIdxKey();
		key.setRequiredRuntimeClassCode( RuntimeClassCode );
		ISecureTableInfoObj obj = null;
		if( indexBySchemaRTCodeIdx.containsKey( key ) ) {
			obj = indexBySchemaRTCodeIdx.get( key );
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoBySchemaRTCodeIdx( null,
				RuntimeClassCode );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableTableInfo().deleteTableInfoBySchemaRTCodeIdx( null,
				RuntimeClassCode );
		}
		deepDisposeTableInfoBySchemaRTCodeIdx( RuntimeClassCode );
	}
}