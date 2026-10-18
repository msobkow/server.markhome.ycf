// Description: Java 25 Table Object implementation for ISOLang.

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

public class BusModelISOLangTableObj
	implements IBusModelISOLangTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj> allISOLang;
	private Map< ISecureISOLangByCode3IdxKey,
		ISecureISOLangObj > indexByCode3Idx;
	private Map< ISecureISOLangByCode2IdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj > > indexByCode2Idx;
	public static String TABLE_NAME = "ISOLang";
	public static String TABLE_DBNAME = "iso_lang";

	public BusModelISOLangTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOLangObj>();
		allISOLang = null;
		indexByCode3Idx = null;
		indexByCode2Idx = null;
	}

	public BusModelISOLangTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOLangObj>();
		allISOLang = null;
		indexByCode3Idx = null;
		indexByCode2Idx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureISOLangTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureISOLangTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureISOLangTableObj.getRuntimeClassCode() );
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
		allISOLang = null;
		indexByCode3Idx = null;
		indexByCode2Idx = null;
		List<ISecureISOLangObj> toForget = new LinkedList<ISecureISOLangObj>();
		ISecureISOLangObj cur = null;
		Iterator<ISecureISOLangObj> iter = members.values().iterator();
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
	 *	BusModelISOLangObj.
	 */
	@Override
	public ISecureISOLangObj newInstance() {
		ISecureISOLangObj inst = new BusModelISOLangObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelISOLangObj.
	 */
	@Override
	public ISecureISOLangEditObj newEditInstance( ISecureISOLangObj orig ) {
		ISecureISOLangEditObj edit = new BusModelISOLangEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureISOLangObj constructByClassCode( int backingClassCode ) {
		ISecureISOLangObj obj = null;
		if( backingClassCode == ISecureISOLang.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getISOLangTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureISOLangObj realiseISOLang( ISecureISOLangObj Obj ) {
		ISecureISOLangObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureISOLangObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureISOLangObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByCode3Idx != null ) {
				ISecureISOLangByCode3IdxKey keyCode3Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode3IdxKey();
				keyCode3Idx.setRequiredISO6392Code( keepObj.getRequiredISO6392Code() );
				indexByCode3Idx.remove( keyCode3Idx );
			}

			if( indexByCode2Idx != null ) {
				ISecureISOLangByCode2IdxKey keyCode2Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode2IdxKey();
				keyCode2Idx.setOptionalISO6391Code( keepObj.getOptionalISO6391Code() );
				Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj > mapCode2Idx = indexByCode2Idx.get( keyCode2Idx );
				if( mapCode2Idx != null ) {
					mapCode2Idx.remove( keepObj.getPKey() );
					if( mapCode2Idx.size() <= 0 ) {
						indexByCode2Idx.remove( keyCode2Idx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByCode3Idx != null ) {
				ISecureISOLangByCode3IdxKey keyCode3Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode3IdxKey();
				keyCode3Idx.setRequiredISO6392Code( keepObj.getRequiredISO6392Code() );
				indexByCode3Idx.put( keyCode3Idx, keepObj );
			}

			if( indexByCode2Idx != null ) {
				ISecureISOLangByCode2IdxKey keyCode2Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode2IdxKey();
				keyCode2Idx.setOptionalISO6391Code( keepObj.getOptionalISO6391Code() );
				Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj > mapCode2Idx = indexByCode2Idx.get( keyCode2Idx );
				if( mapCode2Idx != null ) {
					mapCode2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allISOLang != null ) {
				allISOLang.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allISOLang != null ) {
				allISOLang.put( keepObj.getPKey(), keepObj );
			}

			if( indexByCode3Idx != null ) {
				ISecureISOLangByCode3IdxKey keyCode3Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode3IdxKey();
				keyCode3Idx.setRequiredISO6392Code( keepObj.getRequiredISO6392Code() );
				indexByCode3Idx.put( keyCode3Idx, keepObj );
			}

			if( indexByCode2Idx != null ) {
				ISecureISOLangByCode2IdxKey keyCode2Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode2IdxKey();
				keyCode2Idx.setOptionalISO6391Code( keepObj.getOptionalISO6391Code() );
				Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj > mapCode2Idx = indexByCode2Idx.get( keyCode2Idx );
				if( mapCode2Idx != null ) {
					mapCode2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureISOLangObj createISOLang( ISecureISOLangObj Obj ) {
		ISecureISOLangObj obj = Obj;
		ISecureISOLang rec = obj.getISOLangRec();
		schema.getSecureBackingStore().getTableISOLang().createISOLang(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureISOLangObj readISOLang( $implCommaIJavaOptAtomType$ pkey ) {
		return( readISOLang( pkey, false ) );
	}

	@Override
	public ISecureISOLangObj readISOLang( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureISOLangObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureISOLang readRec = schema.getSecureBackingStore().getTableISOLang().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getISOLangTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureISOLangObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureISOLangObj readCachedISOLang( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOLangObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeISOLang( ISecureISOLangObj obj )
	{
		final String S_ProcName = "BusModelISOLangTableObj.reallyDeepDisposeISOLang() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureISOLangObj existing = readCachedISOLang( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureISOLangByCode3IdxKey keyCode3Idx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode3IdxKey();
		keyCode3Idx.setRequiredISO6392Code( existing.getRequiredISO6392Code() );

		ISecureISOLangByCode2IdxKey keyCode2Idx = schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode2IdxKey();
		keyCode2Idx.setOptionalISO6391Code( existing.getOptionalISO6391Code() );


		schema.getISOCtryLangTableObj().deepDisposeISOCtryLangByLangIdx( existing.getRequiredISOLangId() );

		if( indexByCode3Idx != null ) {
			indexByCode3Idx.remove( keyCode3Idx );
		}

		if( indexByCode2Idx != null ) {
			if( indexByCode2Idx.containsKey( keyCode2Idx ) ) {
				indexByCode2Idx.get( keyCode2Idx ).remove( pkey );
				if( indexByCode2Idx.get( keyCode2Idx ).size() <= 0 ) {
					indexByCode2Idx.remove( keyCode2Idx );
				}
			}
		}


	}
	@Override
	public void deepDisposeISOLang( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOLangObj obj = readCachedISOLang( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureISOLangObj lockISOLang( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureISOLangObj locked = null;
		ISecureISOLang lockRec = schema.getSecureBackingStore().getTableISOLang().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getISOLangTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureISOLangObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockISOLang", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureISOLangObj> readAllISOLang() {
		return( readAllISOLang( false ) );
	}

	@Override
	public List<ISecureISOLangObj> readAllISOLang( boolean forceRead ) {
		final String S_ProcName = "readAllISOLang";
		if( ( allISOLang == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureISOLangObj>();
			allISOLang = map;
			ISecureISOLang[] recList = schema.getSecureBackingStore().getTableISOLang().readAllDerived( null );
			ISecureISOLang rec;
			ISecureISOLangObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOLangObj realised = (ISecureISOLangObj)obj.realise();
			}
		}
		int len = allISOLang.size();
		ISecureISOLangObj arr[] = new ISecureISOLangObj[len];
		Iterator<ISecureISOLangObj> valIter = allISOLang.values().iterator();
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
		ArrayList<ISecureISOLangObj> arrayList = new ArrayList<ISecureISOLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOLangObj> cmp = new Comparator<ISecureISOLangObj>() {
			@Override
			public int compare( ISecureISOLangObj lhs, ISecureISOLangObj rhs ) {
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
		List<ISecureISOLangObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureISOLangObj> readCachedAllISOLang() {
		final String S_ProcName = "readCachedAllISOLang";
		ArrayList<ISecureISOLangObj> arrayList = new ArrayList<ISecureISOLangObj>();
		if( allISOLang != null ) {
			int len = allISOLang.size();
			ISecureISOLangObj arr[] = new ISecureISOLangObj[len];
			Iterator<ISecureISOLangObj> valIter = allISOLang.values().iterator();
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
		Comparator<ISecureISOLangObj> cmp = new Comparator<ISecureISOLangObj>() {
			public int compare( ISecureISOLangObj lhs, ISecureISOLangObj rhs ) {
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
	public ISecureISOLangObj readISOLangByIdIdx( short ISOLangId )
	{
		return( readISOLangByIdIdx( ISOLangId,
			false ) );
	}

	@Override
	public ISecureISOLangObj readISOLangByIdIdx( short ISOLangId, boolean forceRead )
	{
		ISecureISOLangObj obj = readISOLang( ISOLangId, forceRead );
		return( obj );
	}

	@Override
	public ISecureISOLangObj readISOLangByCode3Idx( String ISO6392Code )
	{
		return( readISOLangByCode3Idx( ISO6392Code,
			false ) );
	}

	@Override
	public ISecureISOLangObj readISOLangByCode3Idx( String ISO6392Code, boolean forceRead )
	{
		if( indexByCode3Idx == null ) {
			indexByCode3Idx = new HashMap< ISecureISOLangByCode3IdxKey,
				ISecureISOLangObj >();
		}
		ISecureISOLangByCode3IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode3IdxKey();
		key.setRequiredISO6392Code( ISO6392Code );
		ISecureISOLangObj obj = null;
		if( ( ! forceRead ) && indexByCode3Idx.containsKey( key ) ) {
			obj = indexByCode3Idx.get( key );
		}
		else {
			ISecureISOLang rec = schema.getSecureBackingStore().getTableISOLang().readDerivedByCode3Idx( null,
				ISO6392Code );
			if( rec != null ) {
				obj = schema.getISOLangTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureISOLangObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<ISecureISOLangObj> readISOLangByCode2Idx( String ISO6391Code )
	{
		return( readISOLangByCode2Idx( ISO6391Code,
			false ) );
	}

	@Override
	public List<ISecureISOLangObj> readISOLangByCode2Idx( String ISO6391Code,
		boolean forceRead )
	{
		final String S_ProcName = "readISOLangByCode2Idx";
		ISecureISOLangByCode2IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode2IdxKey();
		key.setOptionalISO6391Code( ISO6391Code );
		Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj> dict;
		if( indexByCode2Idx == null ) {
			indexByCode2Idx = new HashMap< ISecureISOLangByCode2IdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureISOLangObj > >();
		}
		if( ( ! forceRead ) && indexByCode2Idx.containsKey( key ) ) {
			dict = indexByCode2Idx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureISOLangObj>();
			ISecureISOLangObj obj;
			ISecureISOLang[] recList = schema.getSecureBackingStore().getTableISOLang().readDerivedByCode2Idx( null,
				ISO6391Code );
			ISecureISOLang rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getISOLangTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureISOLangObj realised = (ISecureISOLangObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCode2Idx.put( key, dict );
		}
		int len = dict.size();
		ISecureISOLangObj arr[] = new ISecureISOLangObj[len];
		Iterator<ISecureISOLangObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureISOLangObj> arrayList = new ArrayList<ISecureISOLangObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureISOLangObj> cmp = new Comparator<ISecureISOLangObj>() {
			@Override
			public int compare( ISecureISOLangObj lhs, ISecureISOLangObj rhs ) {
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
		List<ISecureISOLangObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureISOLangObj readCachedISOLangByIdIdx( short ISOLangId )
	{
		ISecureISOLangObj obj = null;
		obj = readCachedISOLang( ISOLangId );
		return( obj );
	}

	@Override
	public ISecureISOLangObj readCachedISOLangByCode3Idx( String ISO6392Code )
	{
		ISecureISOLangObj obj = null;
		ISecureISOLangByCode3IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode3IdxKey();
		key.setRequiredISO6392Code( ISO6392Code );
		if( indexByCode3Idx != null ) {
			if( indexByCode3Idx.containsKey( key ) ) {
				obj = indexByCode3Idx.get( key );
			}
			else {
				Iterator<ISecureISOLangObj> valIter = members.values().iterator();
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
			Iterator<ISecureISOLangObj> valIter = members.values().iterator();
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
	public List<ISecureISOLangObj> readCachedISOLangByCode2Idx( String ISO6391Code )
	{
		final String S_ProcName = "readCachedISOLangByCode2Idx";
		ISecureISOLangByCode2IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode2IdxKey();
		key.setOptionalISO6391Code( ISO6391Code );
		ArrayList<ISecureISOLangObj> arrayList = new ArrayList<ISecureISOLangObj>();
		if( indexByCode2Idx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj> dict;
			if( indexByCode2Idx.containsKey( key ) ) {
				dict = indexByCode2Idx.get( key );
				int len = dict.size();
				ISecureISOLangObj arr[] = new ISecureISOLangObj[len];
				Iterator<ISecureISOLangObj> valIter = dict.values().iterator();
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
			ISecureISOLangObj obj;
			Iterator<ISecureISOLangObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureISOLangObj> cmp = new Comparator<ISecureISOLangObj>() {
			@Override
			public int compare( ISecureISOLangObj lhs, ISecureISOLangObj rhs ) {
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
	public void deepDisposeISOLangByIdIdx( short ISOLangId )
	{
		ISecureISOLangObj obj = readCachedISOLangByIdIdx( ISOLangId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOLangByCode3Idx( String ISO6392Code )
	{
		ISecureISOLangObj obj = readCachedISOLangByCode3Idx( ISO6392Code );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeISOLangByCode2Idx( String ISO6391Code )
	{
		final String S_ProcName = "deepDisposeISOLangByCode2Idx";
		ISecureISOLangObj obj;
		List<ISecureISOLangObj> arrayList = readCachedISOLangByCode2Idx( ISO6391Code );
		if( arrayList != null )  {
			Iterator<ISecureISOLangObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public ISecureISOLangObj updateISOLang( ISecureISOLangObj Obj ) {
		ISecureISOLangObj obj = Obj;
		schema.getSecureBackingStore().getTableISOLang().updateISOLang( null,
			Obj.getISOLangRec() );
		obj = (ISecureISOLangObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteISOLang( ISecureISOLangObj Obj ) {
		ISecureISOLangObj obj = Obj;
		schema.getSecureBackingStore().getTableISOLang().deleteISOLang( null,
			obj.getISOLangRec() );
		Obj.forget();
	}

	@Override
	public void deleteISOLangByIdIdx( short ISOLangId )
	{
		ISecureISOLangObj obj = readISOLang(ISOLangId);
		if( obj != null ) {
			ISecureISOLangEditObj editObj = (ISecureISOLangEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureISOLangEditObj)obj.beginEdit();
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
		deepDisposeISOLangByIdIdx( ISOLangId );
	}

	@Override
	public void deleteISOLangByCode3Idx( String ISO6392Code )
	{
		if( indexByCode3Idx == null ) {
			indexByCode3Idx = new HashMap< ISecureISOLangByCode3IdxKey,
				ISecureISOLangObj >();
		}
		ISecureISOLangByCode3IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode3IdxKey();
		key.setRequiredISO6392Code( ISO6392Code );
		ISecureISOLangObj obj = null;
		if( indexByCode3Idx.containsKey( key ) ) {
			obj = indexByCode3Idx.get( key );
			schema.getSecureBackingStore().getTableISOLang().deleteISOLangByCode3Idx( null,
				ISO6392Code );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableISOLang().deleteISOLangByCode3Idx( null,
				ISO6392Code );
		}
		deepDisposeISOLangByCode3Idx( ISO6392Code );
	}

	@Override
	public void deleteISOLangByCode2Idx( String ISO6391Code )
	{
		ISecureISOLangByCode2IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryISOLang().newByCode2IdxKey();
		key.setOptionalISO6391Code( ISO6391Code );
		if( indexByCode2Idx == null ) {
			indexByCode2Idx = new HashMap< ISecureISOLangByCode2IdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureISOLangObj > >();
		}
		if( indexByCode2Idx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureISOLangObj> dict = indexByCode2Idx.get( key );
			schema.getSecureBackingStore().getTableISOLang().deleteISOLangByCode2Idx( null,
				ISO6391Code );
			Iterator<ISecureISOLangObj> iter = dict.values().iterator();
			ISecureISOLangObj obj;
			List<ISecureISOLangObj> toForget = new LinkedList<ISecureISOLangObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByCode2Idx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableISOLang().deleteISOLangByCode2Idx( null,
				ISO6391Code );
		}
		deepDisposeISOLangByCode2Idx( ISO6391Code );
	}
}