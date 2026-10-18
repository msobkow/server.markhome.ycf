// Description: Java 25 Table Object implementation for ISOCcy.

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

public class BusModelISOCcyTableObj
	implements IBusModelISOCcyTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureISOCcyObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureISOCcyObj> allISOCcy;
	private Map< ISecureISOCcyByCcyCdIdxKey,
		ISecureISOCcyObj > indexByCcyCdIdx;
	private Map< ISecureISOCcyByCcyNmIdxKey,
		ISecureISOCcyObj > indexByCcyNmIdx;
	public static String TABLE_NAME = "ISOCcy";
	public static String TABLE_DBNAME = "iso_ccy";

	public BusModelISOCcyTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOCcyObj>();
		allISOCcy = null;
		indexByCcyCdIdx = null;
		indexByCcyNmIdx = null;
	}

	public BusModelISOCcyTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOCcyObj>();
		allISOCcy = null;
		indexByCcyCdIdx = null;
		indexByCcyNmIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureISOCcyTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureISOCcyTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureISOCcyTableObj.getRuntimeClassCode() );
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
		allISOCcy = null;
		indexByCcyCdIdx = null;
		indexByCcyNmIdx = null;
		List<ISecureISOCcyObj> toForget = new LinkedList<ISecureISOCcyObj>();
		ISecureISOCcyObj cur = null;
		Iterator<ISecureISOCcyObj> iter = members.values().iterator();
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
	 *	BusModelISOCcyObj.
	 */
	@Override
	public ISecureISOCcyObj newInstance() {
		ISecureISOCcyObj inst = new BusModelISOCcyObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelISOCcyObj.
	 */
	@Override
	public ISecureISOCcyEditObj newEditInstance( ISecureISOCcyObj orig ) {
		ISecureISOCcyEditObj edit = new BusModelISOCcyEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureISOCcyObj constructByClassCode( int backingClassCode ) {
		ISecureISOCcyObj obj = null;
		if( backingClassCode == ISecureISOCcy.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getISOCcyTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureISOCcyObj realiseISOCcy( ISecureISOCcyObj Obj ) {
		ISecureISOCcyObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureISOCcyObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureISOCcyObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCcyCdIdx != null ) {
				ISecureISOCcyByCcyCdIdxKey keyCcyCdIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.remove( keyCcyCdIdx );
			}

			if( indexByCcyNmIdx != null ) {
				ISecureISOCcyByCcyNmIdxKey keyCcyNmIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.remove( keyCcyNmIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCcyCdIdx != null ) {
				ISecureISOCcyByCcyCdIdxKey keyCcyCdIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.put( keyCcyCdIdx, keepObj );
			}

			if( indexByCcyNmIdx != null ) {
				ISecureISOCcyByCcyNmIdxKey keyCcyNmIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.put( keyCcyNmIdx, keepObj );
			}

			if( allISOCcy != null ) {
				allISOCcy.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOCcy != null ) {
				allISOCcy.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCcyCdIdx != null ) {
				ISecureISOCcyByCcyCdIdxKey keyCcyCdIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyCdIdxKey();
				keyCcyCdIdx.setRequiredISOCode( keepObj.getRequiredISOCode() );
				indexByCcyCdIdx.put( keyCcyCdIdx, keepObj );
			}

			if( indexByCcyNmIdx != null ) {
				ISecureISOCcyByCcyNmIdxKey keyCcyNmIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyNmIdxKey();
				keyCcyNmIdx.setRequiredName( keepObj.getRequiredName() );
				indexByCcyNmIdx.put( keyCcyNmIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureISOCcyObj createISOCcy( ISecureISOCcyObj Obj ) {
		ISecureISOCcyObj obj = Obj;
		ISecureISOCcy rec = obj.getISOCcyRec();
		schema.getSecureBackingStore().getTableISOCcy().createISOCcy(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureISOCcyObj readISOCcy( $implCommaIJavaOptAtomType$ pkey ) {
		return( readISOCcy( pkey, false ) );
	}

	@Override
	public ISecureISOCcyObj readISOCcy( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureISOCcyObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureISOCcy readRec = schema.getSecureBackingStore().getTableISOCcy().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getISOCcyTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureISOCcyObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOCcyObj readCachedISOCcy( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOCcyObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeISOCcy( ISecureISOCcyObj obj )
	{
		final String S_ProcName = "BusModelISOCcyTableObj.reallyDeepDisposeISOCcy() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureISOCcyObj existing = readCachedISOCcy( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureISOCcyByCcyCdIdxKey keyCcyCdIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyCdIdxKey();
		keyCcyCdIdx.setRequiredISOCode( existing.getRequiredISOCode() );

		ISecureISOCcyByCcyNmIdxKey keyCcyNmIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyNmIdxKey();
		keyCcyNmIdx.setRequiredName( existing.getRequiredName() );


		schema.getISOCtryCcyTableObj().deepDisposeISOCtryCcyByCcyIdx( existing.getRequiredISOCcyId() );

		if( indexByCcyCdIdx != null ) {
			indexByCcyCdIdx.remove( keyCcyCdIdx );
		}

		if( indexByCcyNmIdx != null ) {
			indexByCcyNmIdx.remove( keyCcyNmIdx );
		}


	}
	@Override
	public void deepDisposeISOCcy( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOCcyObj obj = readCachedISOCcy( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureISOCcyObj lockISOCcy( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOCcyObj locked = null;
		ISecureISOCcy lockRec = schema.getSecureBackingStore().getTableISOCcy().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getISOCcyTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureISOCcyObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockISOCcy", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureISOCcyObj> readAllISOCcy() {
		return( readAllISOCcy( false ) );
	}

	@Override
	public List<ISecureISOCcyObj> readAllISOCcy( boolean forceRead ) {
		final String S_ProcName = "readAllISOCcy";
		if( ( allISOCcy == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOCcyObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureISOCcyObj>();
			allISOCcy = map;
			ISecureISOCcy[] recList = schema.getSecureBackingStore().getTableISOCcy().readAllDerived( null );
			ISecureISOCcy rec;
			ISecureISOCcyObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOCcyObj realised = (ISecureISOCcyObj)obj.realise();
			}
		}
		int len = allISOCcy.size();
		ISecureISOCcyObj arr[] = new ISecureISOCcyObj[len];
		Iterator<ISecureISOCcyObj> valIter = allISOCcy.values().iterator();
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
		ArrayList<ISecureISOCcyObj> arrayList = new ArrayList<ISecureISOCcyObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOCcyObj> cmp = new Comparator<ISecureISOCcyObj>() {
			@Override
			public int compare( ISecureISOCcyObj lhs, ISecureISOCcyObj rhs ) {
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
		List<ISecureISOCcyObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureISOCcyObj> readCachedAllISOCcy() {
		final String S_ProcName = "readCachedAllISOCcy";
		ArrayList<ISecureISOCcyObj> arrayList = new ArrayList<ISecureISOCcyObj>();
		if( allISOCcy != null ) {
			int len = allISOCcy.size();
			ISecureISOCcyObj arr[] = new ISecureISOCcyObj[len];
			Iterator<ISecureISOCcyObj> valIter = allISOCcy.values().iterator();
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
		Comparator<ISecureISOCcyObj> cmp = new Comparator<ISecureISOCcyObj>() {
			public int compare( ISecureISOCcyObj lhs, ISecureISOCcyObj rhs ) {
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
	public ISecureISOCcyObj readISOCcyByIdIdx( short ISOCcyId )
	{
		return( readISOCcyByIdIdx( ISOCcyId,
			false ) );
	}

	@Override
	public ISecureISOCcyObj readISOCcyByIdIdx( short ISOCcyId, boolean forceRead )
	{
		ISecureISOCcyObj obj = readISOCcy( ISOCcyId, forceRead );
		return( obj );
	}

	@Override
	public ISecureISOCcyObj readISOCcyByCcyCdIdx( String ISOCode )
	{
		return( readISOCcyByCcyCdIdx( ISOCode,
			false ) );
	}

	@Override
	public ISecureISOCcyObj readISOCcyByCcyCdIdx( String ISOCode, boolean forceRead )
	{
		if( indexByCcyCdIdx == null ) {
			indexByCcyCdIdx = new HashMap< ISecureISOCcyByCcyCdIdxKey,
				ISecureISOCcyObj >();
		}
		ISecureISOCcyByCcyCdIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );
		ISecureISOCcyObj obj = null;
		if( ( ! forceRead ) && indexByCcyCdIdx.containsKey( key ) ) {
			obj = indexByCcyCdIdx.get( key );
		}
		else {
			ISecureISOCcy rec = schema.getSecureBackingStore().getTableISOCcy().readDerivedByCcyCdIdx( null,
				ISOCode );
			if( rec != null ) {
				obj = schema.getISOCcyTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureISOCcyObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOCcyObj readISOCcyByCcyNmIdx( String Name )
	{
		return( readISOCcyByCcyNmIdx( Name,
			false ) );
	}

	@Override
	public ISecureISOCcyObj readISOCcyByCcyNmIdx( String Name, boolean forceRead )
	{
		if( indexByCcyNmIdx == null ) {
			indexByCcyNmIdx = new HashMap< ISecureISOCcyByCcyNmIdxKey,
				ISecureISOCcyObj >();
		}
		ISecureISOCcyByCcyNmIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyNmIdxKey();
		key.setRequiredName( Name );
		ISecureISOCcyObj obj = null;
		if( ( ! forceRead ) && indexByCcyNmIdx.containsKey( key ) ) {
			obj = indexByCcyNmIdx.get( key );
		}
		else {
			ISecureISOCcy rec = schema.getSecureBackingStore().getTableISOCcy().readDerivedByCcyNmIdx( null,
				Name );
			if( rec != null ) {
				obj = schema.getISOCcyTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureISOCcyObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOCcyObj readCachedISOCcyByIdIdx( short ISOCcyId )
	{
		ISecureISOCcyObj obj = null;
		obj = readCachedISOCcy( ISOCcyId );
		return( obj );
	}

	@Override
	public ISecureISOCcyObj readCachedISOCcyByCcyCdIdx( String ISOCode )
	{
		ISecureISOCcyObj obj = null;
		ISecureISOCcyByCcyCdIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );
		if( indexByCcyCdIdx != null ) {
			if( indexByCcyCdIdx.containsKey( key ) ) {
				obj = indexByCcyCdIdx.get( key );
			}
			else {
				Iterator<ISecureISOCcyObj> valIter = members.values().iterator();
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
			Iterator<ISecureISOCcyObj> valIter = members.values().iterator();
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
	public ISecureISOCcyObj readCachedISOCcyByCcyNmIdx( String Name )
	{
		ISecureISOCcyObj obj = null;
		ISecureISOCcyByCcyNmIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyNmIdxKey();
		key.setRequiredName( Name );
		if( indexByCcyNmIdx != null ) {
			if( indexByCcyNmIdx.containsKey( key ) ) {
				obj = indexByCcyNmIdx.get( key );
			}
			else {
				Iterator<ISecureISOCcyObj> valIter = members.values().iterator();
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
			Iterator<ISecureISOCcyObj> valIter = members.values().iterator();
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
	public void deepDisposeISOCcyByIdIdx( short ISOCcyId )
	{
		ISecureISOCcyObj obj = readCachedISOCcyByIdIdx( ISOCcyId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOCcyByCcyCdIdx( String ISOCode )
	{
		ISecureISOCcyObj obj = readCachedISOCcyByCcyCdIdx( ISOCode );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOCcyByCcyNmIdx( String Name )
	{
		ISecureISOCcyObj obj = readCachedISOCcyByCcyNmIdx( Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureISOCcyObj updateISOCcy( ISecureISOCcyObj Obj ) {
		ISecureISOCcyObj obj = Obj;
		schema.getSecureBackingStore().getTableISOCcy().updateISOCcy( null,
			Obj.getISOCcyRec() );
		obj = (ISecureISOCcyObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteISOCcy( ISecureISOCcyObj Obj ) {
		ISecureISOCcyObj obj = Obj;
		schema.getSecureBackingStore().getTableISOCcy().deleteISOCcy( null,
			obj.getISOCcyRec() );
		Obj.forget();
	}

	@Override
	public void deleteISOCcyByIdIdx( short ISOCcyId )
	{
		ISecureISOCcyObj obj = readISOCcy(ISOCcyId);
		if( obj != null ) {
			ISecureISOCcyEditObj editObj = (ISecureISOCcyEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureISOCcyEditObj)obj.beginEdit();
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
		deepDisposeISOCcyByIdIdx( ISOCcyId );
	}

	@Override
	public void deleteISOCcyByCcyCdIdx( String ISOCode )
	{
		if( indexByCcyCdIdx == null ) {
			indexByCcyCdIdx = new HashMap< ISecureISOCcyByCcyCdIdxKey,
				ISecureISOCcyObj >();
		}
		ISecureISOCcyByCcyCdIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyCdIdxKey();
		key.setRequiredISOCode( ISOCode );
		ISecureISOCcyObj obj = null;
		if( indexByCcyCdIdx.containsKey( key ) ) {
			obj = indexByCcyCdIdx.get( key );
			schema.getSecureBackingStore().getTableISOCcy().deleteISOCcyByCcyCdIdx( null,
				ISOCode );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableISOCcy().deleteISOCcyByCcyCdIdx( null,
				ISOCode );
		}
		deepDisposeISOCcyByCcyCdIdx( ISOCode );
	}

	@Override
	public void deleteISOCcyByCcyNmIdx( String Name )
	{
		if( indexByCcyNmIdx == null ) {
			indexByCcyNmIdx = new HashMap< ISecureISOCcyByCcyNmIdxKey,
				ISecureISOCcyObj >();
		}
		ISecureISOCcyByCcyNmIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOCcy().newByCcyNmIdxKey();
		key.setRequiredName( Name );
		ISecureISOCcyObj obj = null;
		if( indexByCcyNmIdx.containsKey( key ) ) {
			obj = indexByCcyNmIdx.get( key );
			schema.getSecureBackingStore().getTableISOCcy().deleteISOCcyByCcyNmIdx( null,
				Name );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableISOCcy().deleteISOCcyByCcyNmIdx( null,
				Name );
		}
		deepDisposeISOCcyByCcyNmIdx( Name );
	}
}