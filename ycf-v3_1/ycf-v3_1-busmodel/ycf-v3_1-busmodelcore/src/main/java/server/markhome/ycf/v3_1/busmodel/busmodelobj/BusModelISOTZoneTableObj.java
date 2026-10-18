// Description: Java 25 Table Object implementation for ISOTZone.

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

public class BusModelISOTZoneTableObj
	implements IBusModelISOTZoneTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj> allISOTZone;
	private Map< ISecureISOTZoneByOffsetIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj > > indexByOffsetIdx;
	private Map< ISecureISOTZoneByUTZNameIdxKey,
		ISecureISOTZoneObj > indexByUTZNameIdx;
	private Map< ISecureISOTZoneByIso8601IdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj > > indexByIso8601Idx;
	public static String TABLE_NAME = "ISOTZone";
	public static String TABLE_DBNAME = "isotz";

	public BusModelISOTZoneTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj>();
		allISOTZone = null;
		indexByOffsetIdx = null;
		indexByUTZNameIdx = null;
		indexByIso8601Idx = null;
	}

	public BusModelISOTZoneTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj>();
		allISOTZone = null;
		indexByOffsetIdx = null;
		indexByUTZNameIdx = null;
		indexByIso8601Idx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureISOTZoneTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureISOTZoneTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureISOTZoneTableObj.getRuntimeClassCode() );
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
		allISOTZone = null;
		indexByOffsetIdx = null;
		indexByUTZNameIdx = null;
		indexByIso8601Idx = null;
		List<ISecureISOTZoneObj> toForget = new LinkedList<ISecureISOTZoneObj>();
		ISecureISOTZoneObj cur = null;
		Iterator<ISecureISOTZoneObj> iter = members.values().iterator();
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
	 *	BusModelISOTZoneObj.
	 */
	@Override
	public ISecureISOTZoneObj newInstance() {
		ISecureISOTZoneObj inst = new BusModelISOTZoneObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelISOTZoneObj.
	 */
	@Override
	public ISecureISOTZoneEditObj newEditInstance( ISecureISOTZoneObj orig ) {
		ISecureISOTZoneEditObj edit = new BusModelISOTZoneEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureISOTZoneObj constructByClassCode( int backingClassCode ) {
		ISecureISOTZoneObj obj = null;
		if( backingClassCode == ISecureISOTZone.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getISOTZoneTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureISOTZoneObj realiseISOTZone( ISecureISOTZoneObj Obj ) {
		ISecureISOTZoneObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureISOTZoneObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureISOTZoneObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByOffsetIdx != null ) {
				ISecureISOTZoneByOffsetIdxKey keyOffsetIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.remove( keepObj.getPKey() );
					if( mapOffsetIdx.size() <= 0 ) {
						indexByOffsetIdx.remove( keyOffsetIdx );
					}
				}
			}

			if( indexByUTZNameIdx != null ) {
				ISecureISOTZoneByUTZNameIdxKey keyUTZNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.remove( keyUTZNameIdx );
			}

			if( indexByIso8601Idx != null ) {
				ISecureISOTZoneByIso8601IdxKey keyIso8601Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.remove( keepObj.getPKey() );
					if( mapIso8601Idx.size() <= 0 ) {
						indexByIso8601Idx.remove( keyIso8601Idx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByOffsetIdx != null ) {
				ISecureISOTZoneByOffsetIdxKey keyOffsetIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUTZNameIdx != null ) {
				ISecureISOTZoneByUTZNameIdxKey keyUTZNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.put( keyUTZNameIdx, keepObj );
			}

			if( indexByIso8601Idx != null ) {
				ISecureISOTZoneByIso8601IdxKey keyIso8601Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allISOTZone != null ) {
				allISOTZone.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOTZone != null ) {
				allISOTZone.put( keepObj.getPKey(), keepObj );
			}

			if( indexByOffsetIdx != null ) {
				ISecureISOTZoneByOffsetIdxKey keyOffsetIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByOffsetIdxKey();
				keyOffsetIdx.setRequiredTZHourOffset( keepObj.getRequiredTZHourOffset() );
				keyOffsetIdx.setRequiredTZMinOffset( keepObj.getRequiredTZMinOffset() );
				Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj > mapOffsetIdx = indexByOffsetIdx.get( keyOffsetIdx );
				if( mapOffsetIdx != null ) {
					mapOffsetIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUTZNameIdx != null ) {
				ISecureISOTZoneByUTZNameIdxKey keyUTZNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByUTZNameIdxKey();
				keyUTZNameIdx.setRequiredTZName( keepObj.getRequiredTZName() );
				indexByUTZNameIdx.put( keyUTZNameIdx, keepObj );
			}

			if( indexByIso8601Idx != null ) {
				ISecureISOTZoneByIso8601IdxKey keyIso8601Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByIso8601IdxKey();
				keyIso8601Idx.setRequiredIso8601( keepObj.getRequiredIso8601() );
				Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj > mapIso8601Idx = indexByIso8601Idx.get( keyIso8601Idx );
				if( mapIso8601Idx != null ) {
					mapIso8601Idx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureISOTZoneObj createISOTZone( ISecureISOTZoneObj Obj ) {
		ISecureISOTZoneObj obj = Obj;
		ISecureISOTZone rec = obj.getISOTZoneRec();
		schema.getSecureBackingStore().getTableISOTZone().createISOTZone(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureISOTZoneObj readISOTZone( $implCommaIJavaOptAtomType$ pkey ) {
		return( readISOTZone( pkey, false ) );
	}

	@Override
	public ISecureISOTZoneObj readISOTZone( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureISOTZoneObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureISOTZone readRec = schema.getSecureBackingStore().getTableISOTZone().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getISOTZoneTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureISOTZoneObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOTZoneObj readCachedISOTZone( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOTZoneObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeISOTZone( ISecureISOTZoneObj obj )
	{
		final String S_ProcName = "BusModelISOTZoneTableObj.reallyDeepDisposeISOTZone() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureISOTZoneObj existing = readCachedISOTZone( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureISOTZoneByOffsetIdxKey keyOffsetIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByOffsetIdxKey();
		keyOffsetIdx.setRequiredTZHourOffset( existing.getRequiredTZHourOffset() );
		keyOffsetIdx.setRequiredTZMinOffset( existing.getRequiredTZMinOffset() );

		ISecureISOTZoneByUTZNameIdxKey keyUTZNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByUTZNameIdxKey();
		keyUTZNameIdx.setRequiredTZName( existing.getRequiredTZName() );

		ISecureISOTZoneByIso8601IdxKey keyIso8601Idx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByIso8601IdxKey();
		keyIso8601Idx.setRequiredIso8601( existing.getRequiredIso8601() );



		if( indexByOffsetIdx != null ) {
			if( indexByOffsetIdx.containsKey( keyOffsetIdx ) ) {
				indexByOffsetIdx.get( keyOffsetIdx ).remove( pkey );
				if( indexByOffsetIdx.get( keyOffsetIdx ).size() <= 0 ) {
					indexByOffsetIdx.remove( keyOffsetIdx );
				}
			}
		}

		if( indexByUTZNameIdx != null ) {
			indexByUTZNameIdx.remove( keyUTZNameIdx );
		}

		if( indexByIso8601Idx != null ) {
			if( indexByIso8601Idx.containsKey( keyIso8601Idx ) ) {
				indexByIso8601Idx.get( keyIso8601Idx ).remove( pkey );
				if( indexByIso8601Idx.get( keyIso8601Idx ).size() <= 0 ) {
					indexByIso8601Idx.remove( keyIso8601Idx );
				}
			}
		}


	}
	@Override
	public void deepDisposeISOTZone( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOTZoneObj obj = readCachedISOTZone( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureISOTZoneObj lockISOTZone( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOTZoneObj locked = null;
		ISecureISOTZone lockRec = schema.getSecureBackingStore().getTableISOTZone().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getISOTZoneTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureISOTZoneObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockISOTZone", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureISOTZoneObj> readAllISOTZone() {
		return( readAllISOTZone( false ) );
	}

	@Override
	public List<ISecureISOTZoneObj> readAllISOTZone( boolean forceRead ) {
		final String S_ProcName = "readAllISOTZone";
		if( ( allISOTZone == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureISOTZoneObj>();
			allISOTZone = map;
			ISecureISOTZone[] recList = schema.getSecureBackingStore().getTableISOTZone().readAllDerived( null );
			ISecureISOTZone rec;
			ISecureISOTZoneObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOTZoneObj realised = (ISecureISOTZoneObj)obj.realise();
			}
		}
		int len = allISOTZone.size();
		ISecureISOTZoneObj arr[] = new ISecureISOTZoneObj[len];
		Iterator<ISecureISOTZoneObj> valIter = allISOTZone.values().iterator();
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
		ArrayList<ISecureISOTZoneObj> arrayList = new ArrayList<ISecureISOTZoneObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOTZoneObj> cmp = new Comparator<ISecureISOTZoneObj>() {
			@Override
			public int compare( ISecureISOTZoneObj lhs, ISecureISOTZoneObj rhs ) {
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
		List<ISecureISOTZoneObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureISOTZoneObj> readCachedAllISOTZone() {
		final String S_ProcName = "readCachedAllISOTZone";
		ArrayList<ISecureISOTZoneObj> arrayList = new ArrayList<ISecureISOTZoneObj>();
		if( allISOTZone != null ) {
			int len = allISOTZone.size();
			ISecureISOTZoneObj arr[] = new ISecureISOTZoneObj[len];
			Iterator<ISecureISOTZoneObj> valIter = allISOTZone.values().iterator();
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
		Comparator<ISecureISOTZoneObj> cmp = new Comparator<ISecureISOTZoneObj>() {
			public int compare( ISecureISOTZoneObj lhs, ISecureISOTZoneObj rhs ) {
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
	public ISecureISOTZoneObj readISOTZoneByIdIdx( short ISOTZoneId )
	{
		return( readISOTZoneByIdIdx( ISOTZoneId,
			false ) );
	}

	@Override
	public ISecureISOTZoneObj readISOTZoneByIdIdx( short ISOTZoneId, boolean forceRead )
	{
		ISecureISOTZoneObj obj = readISOTZone( ISOTZoneId, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureISOTZoneObj> readISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		return( readISOTZoneByOffsetIdx( TZHourOffset,
			TZMinOffset,
			false ) );
	}

	@Override
	public List<ISecureISOTZoneObj> readISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset,
		boolean forceRead )
	{
		final String S_ProcName = "readISOTZoneByOffsetIdx";
		ISecureISOTZoneByOffsetIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj> dict;
		if( indexByOffsetIdx == null ) {
			indexByOffsetIdx = new HashMap< ISecureISOTZoneByOffsetIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureISOTZoneObj > >();
		}
		if( ( ! forceRead ) && indexByOffsetIdx.containsKey( key ) ) {
			dict = indexByOffsetIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj>();
			ISecureISOTZoneObj obj;
			ISecureISOTZone[] recList = schema.getSecureBackingStore().getTableISOTZone().readDerivedByOffsetIdx( null,
				TZHourOffset,
				TZMinOffset );
			ISecureISOTZone rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getISOTZoneTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOTZoneObj realised = (ISecureISOTZoneObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByOffsetIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureISOTZoneObj arr[] = new ISecureISOTZoneObj[len];
		Iterator<ISecureISOTZoneObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureISOTZoneObj> arrayList = new ArrayList<ISecureISOTZoneObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOTZoneObj> cmp = new Comparator<ISecureISOTZoneObj>() {
			@Override
			public int compare( ISecureISOTZoneObj lhs, ISecureISOTZoneObj rhs ) {
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
		List<ISecureISOTZoneObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureISOTZoneObj readISOTZoneByUTZNameIdx( String TZName )
	{
		return( readISOTZoneByUTZNameIdx( TZName,
			false ) );
	}

	@Override
	public ISecureISOTZoneObj readISOTZoneByUTZNameIdx( String TZName, boolean forceRead )
	{
		if( indexByUTZNameIdx == null ) {
			indexByUTZNameIdx = new HashMap< ISecureISOTZoneByUTZNameIdxKey,
				ISecureISOTZoneObj >();
		}
		ISecureISOTZoneByUTZNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByUTZNameIdxKey();
		key.setRequiredTZName( TZName );
		ISecureISOTZoneObj obj = null;
		if( ( ! forceRead ) && indexByUTZNameIdx.containsKey( key ) ) {
			obj = indexByUTZNameIdx.get( key );
		}
		else {
			ISecureISOTZone rec = schema.getSecureBackingStore().getTableISOTZone().readDerivedByUTZNameIdx( null,
				TZName );
			if( rec != null ) {
				obj = schema.getISOTZoneTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureISOTZoneObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<ISecureISOTZoneObj> readISOTZoneByIso8601Idx( String Iso8601 )
	{
		return( readISOTZoneByIso8601Idx( Iso8601,
			false ) );
	}

	@Override
	public List<ISecureISOTZoneObj> readISOTZoneByIso8601Idx( String Iso8601,
		boolean forceRead )
	{
		final String S_ProcName = "readISOTZoneByIso8601Idx";
		ISecureISOTZoneByIso8601IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );
		Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj> dict;
		if( indexByIso8601Idx == null ) {
			indexByIso8601Idx = new HashMap< ISecureISOTZoneByIso8601IdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureISOTZoneObj > >();
		}
		if( ( ! forceRead ) && indexByIso8601Idx.containsKey( key ) ) {
			dict = indexByIso8601Idx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj>();
			ISecureISOTZoneObj obj;
			ISecureISOTZone[] recList = schema.getSecureBackingStore().getTableISOTZone().readDerivedByIso8601Idx( null,
				Iso8601 );
			ISecureISOTZone rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getISOTZoneTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOTZoneObj realised = (ISecureISOTZoneObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIso8601Idx.put( key, dict );
		}
		int len = dict.size();
		ISecureISOTZoneObj arr[] = new ISecureISOTZoneObj[len];
		Iterator<ISecureISOTZoneObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureISOTZoneObj> arrayList = new ArrayList<ISecureISOTZoneObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOTZoneObj> cmp = new Comparator<ISecureISOTZoneObj>() {
			@Override
			public int compare( ISecureISOTZoneObj lhs, ISecureISOTZoneObj rhs ) {
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
		List<ISecureISOTZoneObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureISOTZoneObj readCachedISOTZoneByIdIdx( short ISOTZoneId )
	{
		ISecureISOTZoneObj obj = null;
		obj = readCachedISOTZone( ISOTZoneId );
		return( obj );
	}

	@Override
	public List<ISecureISOTZoneObj> readCachedISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		final String S_ProcName = "readCachedISOTZoneByOffsetIdx";
		ISecureISOTZoneByOffsetIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		ArrayList<ISecureISOTZoneObj> arrayList = new ArrayList<ISecureISOTZoneObj>();
		if( indexByOffsetIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj> dict;
			if( indexByOffsetIdx.containsKey( key ) ) {
				dict = indexByOffsetIdx.get( key );
				int len = dict.size();
				ISecureISOTZoneObj arr[] = new ISecureISOTZoneObj[len];
				Iterator<ISecureISOTZoneObj> valIter = dict.values().iterator();
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
			ISecureISOTZoneObj obj;
			Iterator<ISecureISOTZoneObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureISOTZoneObj> cmp = new Comparator<ISecureISOTZoneObj>() {
			@Override
			public int compare( ISecureISOTZoneObj lhs, ISecureISOTZoneObj rhs ) {
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
	public ISecureISOTZoneObj readCachedISOTZoneByUTZNameIdx( String TZName )
	{
		ISecureISOTZoneObj obj = null;
		ISecureISOTZoneByUTZNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByUTZNameIdxKey();
		key.setRequiredTZName( TZName );
		if( indexByUTZNameIdx != null ) {
			if( indexByUTZNameIdx.containsKey( key ) ) {
				obj = indexByUTZNameIdx.get( key );
			}
			else {
				Iterator<ISecureISOTZoneObj> valIter = members.values().iterator();
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
			Iterator<ISecureISOTZoneObj> valIter = members.values().iterator();
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
	public List<ISecureISOTZoneObj> readCachedISOTZoneByIso8601Idx( String Iso8601 )
	{
		final String S_ProcName = "readCachedISOTZoneByIso8601Idx";
		ISecureISOTZoneByIso8601IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );
		ArrayList<ISecureISOTZoneObj> arrayList = new ArrayList<ISecureISOTZoneObj>();
		if( indexByIso8601Idx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj> dict;
			if( indexByIso8601Idx.containsKey( key ) ) {
				dict = indexByIso8601Idx.get( key );
				int len = dict.size();
				ISecureISOTZoneObj arr[] = new ISecureISOTZoneObj[len];
				Iterator<ISecureISOTZoneObj> valIter = dict.values().iterator();
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
			ISecureISOTZoneObj obj;
			Iterator<ISecureISOTZoneObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureISOTZoneObj> cmp = new Comparator<ISecureISOTZoneObj>() {
			@Override
			public int compare( ISecureISOTZoneObj lhs, ISecureISOTZoneObj rhs ) {
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
	public void deepDisposeISOTZoneByIdIdx( short ISOTZoneId )
	{
		ISecureISOTZoneObj obj = readCachedISOTZoneByIdIdx( ISOTZoneId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		final String S_ProcName = "deepDisposeISOTZoneByOffsetIdx";
		ISecureISOTZoneObj obj;
		List<ISecureISOTZoneObj> arrayList = readCachedISOTZoneByOffsetIdx( TZHourOffset,
				TZMinOffset );
		if( arrayList != null )  {
			Iterator<ISecureISOTZoneObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeISOTZoneByUTZNameIdx( String TZName )
	{
		ISecureISOTZoneObj obj = readCachedISOTZoneByUTZNameIdx( TZName );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOTZoneByIso8601Idx( String Iso8601 )
	{
		final String S_ProcName = "deepDisposeISOTZoneByIso8601Idx";
		ISecureISOTZoneObj obj;
		List<ISecureISOTZoneObj> arrayList = readCachedISOTZoneByIso8601Idx( Iso8601 );
		if( arrayList != null )  {
			Iterator<ISecureISOTZoneObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public ISecureISOTZoneObj updateISOTZone( ISecureISOTZoneObj Obj ) {
		ISecureISOTZoneObj obj = Obj;
		schema.getSecureBackingStore().getTableISOTZone().updateISOTZone( null,
			Obj.getISOTZoneRec() );
		obj = (ISecureISOTZoneObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteISOTZone( ISecureISOTZoneObj Obj ) {
		ISecureISOTZoneObj obj = Obj;
		schema.getSecureBackingStore().getTableISOTZone().deleteISOTZone( null,
			obj.getISOTZoneRec() );
		Obj.forget();
	}

	@Override
	public void deleteISOTZoneByIdIdx( short ISOTZoneId )
	{
		ISecureISOTZoneObj obj = readISOTZone(ISOTZoneId);
		if( obj != null ) {
			ISecureISOTZoneEditObj editObj = (ISecureISOTZoneEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureISOTZoneEditObj)obj.beginEdit();
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
		deepDisposeISOTZoneByIdIdx( ISOTZoneId );
	}

	@Override
	public void deleteISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset )
	{
		ISecureISOTZoneByOffsetIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByOffsetIdxKey();
		key.setRequiredTZHourOffset( TZHourOffset );
		key.setRequiredTZMinOffset( TZMinOffset );
		if( indexByOffsetIdx == null ) {
			indexByOffsetIdx = new HashMap< ISecureISOTZoneByOffsetIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureISOTZoneObj > >();
		}
		if( indexByOffsetIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj> dict = indexByOffsetIdx.get( key );
			schema.getSecureBackingStore().getTableISOTZone().deleteISOTZoneByOffsetIdx( null,
				TZHourOffset,
				TZMinOffset );
			Iterator<ISecureISOTZoneObj> iter = dict.values().iterator();
			ISecureISOTZoneObj obj;
			List<ISecureISOTZoneObj> toForget = new LinkedList<ISecureISOTZoneObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByOffsetIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableISOTZone().deleteISOTZoneByOffsetIdx( null,
				TZHourOffset,
				TZMinOffset );
		}
		deepDisposeISOTZoneByOffsetIdx( TZHourOffset,
				TZMinOffset );
	}

	@Override
	public void deleteISOTZoneByUTZNameIdx( String TZName )
	{
		if( indexByUTZNameIdx == null ) {
			indexByUTZNameIdx = new HashMap< ISecureISOTZoneByUTZNameIdxKey,
				ISecureISOTZoneObj >();
		}
		ISecureISOTZoneByUTZNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByUTZNameIdxKey();
		key.setRequiredTZName( TZName );
		ISecureISOTZoneObj obj = null;
		if( indexByUTZNameIdx.containsKey( key ) ) {
			obj = indexByUTZNameIdx.get( key );
			schema.getSecureBackingStore().getTableISOTZone().deleteISOTZoneByUTZNameIdx( null,
				TZName );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableISOTZone().deleteISOTZoneByUTZNameIdx( null,
				TZName );
		}
		deepDisposeISOTZoneByUTZNameIdx( TZName );
	}

	@Override
	public void deleteISOTZoneByIso8601Idx( String Iso8601 )
	{
		ISecureISOTZoneByIso8601IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOTZone().newByIso8601IdxKey();
		key.setRequiredIso8601( Iso8601 );
		if( indexByIso8601Idx == null ) {
			indexByIso8601Idx = new HashMap< ISecureISOTZoneByIso8601IdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureISOTZoneObj > >();
		}
		if( indexByIso8601Idx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOTZoneObj> dict = indexByIso8601Idx.get( key );
			schema.getSecureBackingStore().getTableISOTZone().deleteISOTZoneByIso8601Idx( null,
				Iso8601 );
			Iterator<ISecureISOTZoneObj> iter = dict.values().iterator();
			ISecureISOTZoneObj obj;
			List<ISecureISOTZoneObj> toForget = new LinkedList<ISecureISOTZoneObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByIso8601Idx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableISOTZone().deleteISOTZoneByIso8601Idx( null,
				Iso8601 );
		}
		deepDisposeISOTZoneByIso8601Idx( Iso8601 );
	}
}