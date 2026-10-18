// Description: Java 25 Table Object implementation for ISOCtry.

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

public class BusModelISOCtryTableObj
	implements IBusModelISOCtryTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureISOCtryObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureISOCtryObj> allISOCtry;
	private Map< ISecureISOCtryByISOCodeIdxKey,
		ISecureISOCtryObj > indexByISOCodeIdx;
	private Map< ISecureISOCtryByNameIdxKey,
		ISecureISOCtryObj > indexByNameIdx;
	public static String TABLE_NAME = "ISOCtry";
	public static String TABLE_DBNAME = "iso_cntry";

	public BusModelISOCtryTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOCtryObj>();
		allISOCtry = null;
		indexByISOCodeIdx = null;
		indexByNameIdx = null;
	}

	public BusModelISOCtryTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOCtryObj>();
		allISOCtry = null;
		indexByISOCodeIdx = null;
		indexByNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureISOCtryTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureISOCtryTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureISOCtryTableObj.getRuntimeClassCode() );
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
		allISOCtry = null;
		indexByISOCodeIdx = null;
		indexByNameIdx = null;
		List<ISecureISOCtryObj> toForget = new LinkedList<ISecureISOCtryObj>();
		ISecureISOCtryObj cur = null;
		Iterator<ISecureISOCtryObj> iter = members.values().iterator();
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
	 *	BusModelISOCtryObj.
	 */
	@Override
	public ISecureISOCtryObj newInstance() {
		ISecureISOCtryObj inst = new BusModelISOCtryObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelISOCtryObj.
	 */
	@Override
	public ISecureISOCtryEditObj newEditInstance( ISecureISOCtryObj orig ) {
		ISecureISOCtryEditObj edit = new BusModelISOCtryEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureISOCtryObj constructByClassCode( int backingClassCode ) {
		ISecureISOCtryObj obj = null;
		if( backingClassCode == ISecureISOCtry.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getISOCtryTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryObj realiseISOCtry( ISecureISOCtryObj Obj ) {
		ISecureISOCtryObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureISOCtryObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureISOCtryObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByISOCodeIdx != null ) {
				ISecureISOCtryByISOCodeIdxKey keyISOCodeIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.remove( keyISOCodeIdx );
			}

			if( indexByNameIdx != null ) {
				ISecureISOCtryByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByISOCodeIdx != null ) {
				ISecureISOCtryByISOCodeIdxKey keyISOCodeIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.put( keyISOCodeIdx, keepObj );
			}

			if( indexByNameIdx != null ) {
				ISecureISOCtryByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allISOCtry != null ) {
				allISOCtry.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCtry != null ) {
				allISOCtry.put( keepObj.getPKey(), keepObj );
			}

			if( indexByISOCodeIdx != null ) {
				ISecureISOCtryByISOCodeIdxKey keyISOCodeIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByISOCodeIdxKey();
				keyISOCodeIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByISOCodeIdx.put( keyISOCodeIdx, keepObj );
			}

			if( indexByNameIdx != null ) {
				ISecureISOCtryByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureISOCtryObj createISOCtry( ISecureISOCtryObj Obj ) {
		ISecureISOCtryObj obj = Obj;
		ISecureISOCtry rec = obj.getISOCtryRec();
		schema.getSecureBackingStore().getTableISOCtry().createISOCtry(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureISOCtryObj readISOCtry( $implCommaIJavaOptAtomType$ pkey ) {
		return( readISOCtry( pkey, false ) );
	}

	@Override
	public ISecureISOCtryObj readISOCtry( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureISOCtryObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureISOCtry readRec = schema.getSecureBackingStore().getTableISOCtry().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getISOCtryTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureISOCtryObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryObj readCachedISOCtry( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOCtryObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeISOCtry( ISecureISOCtryObj obj )
	{
		final String S_ProcName = "BusModelISOCtryTableObj.reallyDeepDisposeISOCtry() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureISOCtryObj existing = readCachedISOCtry( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureISOCtryByISOCodeIdxKey keyISOCodeIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByISOCodeIdxKey();
		keyISOCodeIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		ISecureISOCtryByNameIdxKey keyNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getISOCtryLangTableObj().deepDisposeISOCtryLangByCtryIdx( existing.getRequiredISOCtryId() );
					schema.getISOCtryCcyTableObj().deepDisposeISOCtryCcyByCtryIdx( existing.getRequiredISOCtryId() );

		if( indexByISOCodeIdx != null ) {
			indexByISOCodeIdx.remove( keyISOCodeIdx );
		}

		if( indexByNameIdx != null ) {
			indexByNameIdx.remove( keyNameIdx );
		}


	}
	@Override
	public void deepDisposeISOCtry( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOCtryObj obj = readCachedISOCtry( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureISOCtryObj lockISOCtry( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOCtryObj locked = null;
		ISecureISOCtry lockRec = schema.getSecureBackingStore().getTableISOCtry().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getISOCtryTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureISOCtryObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockISOCtry", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureISOCtryObj> readAllISOCtry() {
		return( readAllISOCtry( false ) );
	}

	@Override
	public List<ISecureISOCtryObj> readAllISOCtry( boolean forceRead ) {
		final String S_ProcName = "readAllISOCtry";
		if( ( allISOCtry == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOCtryObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureISOCtryObj>();
			allISOCtry = map;
			ISecureISOCtry[] recList = schema.getSecureBackingStore().getTableISOCtry().readAllDerived( null );
			ISecureISOCtry rec;
			ISecureISOCtryObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOCtryObj realised = (ISecureISOCtryObj)obj.realise();
			}
		}
		int len = allISOCtry.size();
		ISecureISOCtryObj arr[] = new ISecureISOCtryObj[len];
		Iterator<ISecureISOCtryObj> valIter = allISOCtry.values().iterator();
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
		ArrayList<ISecureISOCtryObj> arrayList = new ArrayList<ISecureISOCtryObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOCtryObj> cmp = new Comparator<ISecureISOCtryObj>() {
			@Override
			public int compare( ISecureISOCtryObj lhs, ISecureISOCtryObj rhs ) {
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
		List<ISecureISOCtryObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureISOCtryObj> readCachedAllISOCtry() {
		final String S_ProcName = "readCachedAllISOCtry";
		ArrayList<ISecureISOCtryObj> arrayList = new ArrayList<ISecureISOCtryObj>();
		if( allISOCtry != null ) {
			int len = allISOCtry.size();
			ISecureISOCtryObj arr[] = new ISecureISOCtryObj[len];
			Iterator<ISecureISOCtryObj> valIter = allISOCtry.values().iterator();
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
		Comparator<ISecureISOCtryObj> cmp = new Comparator<ISecureISOCtryObj>() {
			public int compare( ISecureISOCtryObj lhs, ISecureISOCtryObj rhs ) {
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
	public ISecureISOCtryObj readISOCtryByIdIdx( short ISOCtryId )
	{
		return( readISOCtryByIdIdx( ISOCtryId,
			false ) );
	}

	@Override
	public ISecureISOCtryObj readISOCtryByIdIdx( short ISOCtryId, boolean forceRead )
	{
		ISecureISOCtryObj obj = readISOCtry( ISOCtryId, forceRead );
		return( obj );
	}

	@Override
	public ISecureISOCtryObj readISOCtryByISOCodeIdx( String ISOCode )
	{
		return( readISOCtryByISOCodeIdx( ISOCode,
			false ) );
	}

	@Override
	public ISecureISOCtryObj readISOCtryByISOCodeIdx( String ISOCode, boolean forceRead )
	{
		if( indexByISOCodeIdx == null ) {
			indexByISOCodeIdx = new HashMap< ISecureISOCtryByISOCodeIdxKey,
				ISecureISOCtryObj >();
		}
		ISecureISOCtryByISOCodeIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		ISecureISOCtryObj obj = null;
		if( ( ! forceRead ) && indexByISOCodeIdx.containsKey( key ) ) {
			obj = indexByISOCodeIdx.get( key );
		}
		else {
			ISecureISOCtry rec = schema.getSecureBackingStore().getTableISOCtry().readDerivedByISOCodeIdx( null,
				ISOCode );
			if( rec != null ) {
				obj = schema.getISOCtryTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureISOCtryObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryObj readISOCtryByNameIdx( String Name )
	{
		return( readISOCtryByNameIdx( Name,
			false ) );
	}

	@Override
	public ISecureISOCtryObj readISOCtryByNameIdx( String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureISOCtryByNameIdxKey,
				ISecureISOCtryObj >();
		}
		ISecureISOCtryByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByNameIdxKey();
		key.setRequiredName( Name );
		ISecureISOCtryObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			ISecureISOCtry rec = schema.getSecureBackingStore().getTableISOCtry().readDerivedByNameIdx( null,
				Name );
			if( rec != null ) {
				obj = schema.getISOCtryTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureISOCtryObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOCtryObj readCachedISOCtryByIdIdx( short ISOCtryId )
	{
		ISecureISOCtryObj obj = null;
		obj = readCachedISOCtry( ISOCtryId );
		return( obj );
	}

	@Override
	public ISecureISOCtryObj readCachedISOCtryByISOCodeIdx( String ISOCode )
	{
		ISecureISOCtryObj obj = null;
		ISecureISOCtryByISOCodeIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		if( indexByISOCodeIdx != null ) {
			if( indexByISOCodeIdx.containsKey( key ) ) {
				obj = indexByISOCodeIdx.get( key );
			}
			else {
				Iterator<ISecureISOCtryObj> valIter = members.values().iterator();
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
			Iterator<ISecureISOCtryObj> valIter = members.values().iterator();
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
	public ISecureISOCtryObj readCachedISOCtryByNameIdx( String Name )
	{
		ISecureISOCtryObj obj = null;
		ISecureISOCtryByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx != null ) {
			if( indexByNameIdx.containsKey( key ) ) {
				obj = indexByNameIdx.get( key );
			}
			else {
				Iterator<ISecureISOCtryObj> valIter = members.values().iterator();
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
			Iterator<ISecureISOCtryObj> valIter = members.values().iterator();
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
	public void deepDisposeISOCtryByIdIdx( short ISOCtryId )
	{
		ISecureISOCtryObj obj = readCachedISOCtryByIdIdx( ISOCtryId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOCtryByISOCodeIdx( String ISOCode )
	{
		ISecureISOCtryObj obj = readCachedISOCtryByISOCodeIdx( ISOCode );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOCtryByNameIdx( String Name )
	{
		ISecureISOCtryObj obj = readCachedISOCtryByNameIdx( Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureISOCtryObj updateISOCtry( ISecureISOCtryObj Obj ) {
		ISecureISOCtryObj obj = Obj;
		schema.getSecureBackingStore().getTableISOCtry().updateISOCtry( null,
			Obj.getISOCtryRec() );
		obj = (ISecureISOCtryObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteISOCtry( ISecureISOCtryObj Obj ) {
		ISecureISOCtryObj obj = Obj;
		schema.getSecureBackingStore().getTableISOCtry().deleteISOCtry( null,
			obj.getISOCtryRec() );
		Obj.forget();
	}

	@Override
	public void deleteISOCtryByIdIdx( short ISOCtryId )
	{
		ISecureISOCtryObj obj = readISOCtry(ISOCtryId);
		if( obj != null ) {
			ISecureISOCtryEditObj editObj = (ISecureISOCtryEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureISOCtryEditObj)obj.beginEdit();
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
		deepDisposeISOCtryByIdIdx( ISOCtryId );
	}

	@Override
	public void deleteISOCtryByISOCodeIdx( String ISOCode )
	{
		if( indexByISOCodeIdx == null ) {
			indexByISOCodeIdx = new HashMap< ISecureISOCtryByISOCodeIdxKey,
				ISecureISOCtryObj >();
		}
		ISecureISOCtryByISOCodeIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByISOCodeIdxKey();
		key.setRequiredISOCode( ISOCode );
		ISecureISOCtryObj obj = null;
		if( indexByISOCodeIdx.containsKey( key ) ) {
			obj = indexByISOCodeIdx.get( key );
			schema.getSecureBackingStore().getTableISOCtry().deleteISOCtryByISOCodeIdx( null,
				ISOCode );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableISOCtry().deleteISOCtryByISOCodeIdx( null,
				ISOCode );
		}
		deepDisposeISOCtryByISOCodeIdx( ISOCode );
	}

	@Override
	public void deleteISOCtryByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureISOCtryByNameIdxKey,
				ISecureISOCtryObj >();
		}
		ISecureISOCtryByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCtry().newByNameIdxKey();
		key.setRequiredName( Name );
		ISecureISOCtryObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getSecureBackingStore().getTableISOCtry().deleteISOCtryByNameIdx( null,
				Name );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableISOCtry().deleteISOCtryByNameIdx( null,
				Name );
		}
		deepDisposeISOCtryByNameIdx( Name );
	}
}