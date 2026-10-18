// Description: Java 25 Table Object implementation for MimeType.

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

public class BusModelMimeTypeTableObj
	implements IBusModelMimeTypeTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, IIntNetMimeTypeObj> members;
	private Map<$implCommaIJavaOptAtomType$, IIntNetMimeTypeObj> allMimeType;
	private Map< IIntNetMimeTypeByUNameIdxKey,
		IIntNetMimeTypeObj > indexByUNameIdx;
	public static String TABLE_NAME = "MimeType";
	public static String TABLE_DBNAME = "mimetype";

	public BusModelMimeTypeTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMimeTypeObj>();
		allMimeType = null;
		indexByUNameIdx = null;
	}

	public BusModelMimeTypeTableObj( IIntNetSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetMimeTypeObj>();
		allMimeType = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return IntNetMimeTypeTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( IntNetMimeTypeTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( IntNetMimeTypeTableObj.getRuntimeClassCode() );
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
		return( null );
	}


	@Override
	public void minimizeMemory() {
		allMimeType = null;
		indexByUNameIdx = null;
		List<IIntNetMimeTypeObj> toForget = new LinkedList<IIntNetMimeTypeObj>();
		IIntNetMimeTypeObj cur = null;
		Iterator<IIntNetMimeTypeObj> iter = members.values().iterator();
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
	 *	BusModelMimeTypeObj.
	 */
	@Override
	public IIntNetMimeTypeObj newInstance() {
		IIntNetMimeTypeObj inst = new BusModelMimeTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelMimeTypeObj.
	 */
	@Override
	public IIntNetMimeTypeEditObj newEditInstance( IIntNetMimeTypeObj orig ) {
		IIntNetMimeTypeEditObj edit = new BusModelMimeTypeEditObj( orig );
		return( edit );
	}

	@Override
	public IIntNetMimeTypeObj constructByClassCode( int backingClassCode ) {
		IIntNetMimeTypeObj obj = null;
		if( backingClassCode == IIntNetMimeType.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getMimeTypeTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IIntNetMimeTypeObj realiseMimeType( IIntNetMimeTypeObj Obj ) {
		IIntNetMimeTypeObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetMimeTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IIntNetMimeTypeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IIntNetMimeTypeByUNameIdxKey keyUNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMimeType().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IIntNetMimeTypeByUNameIdxKey keyUNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMimeType().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allMimeType != null ) {
				allMimeType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allMimeType != null ) {
				allMimeType.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IIntNetMimeTypeByUNameIdxKey keyUNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryMimeType().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IIntNetMimeTypeObj createMimeType( IIntNetMimeTypeObj Obj ) {
		IIntNetMimeTypeObj obj = Obj;
		IIntNetMimeType rec = obj.getMimeTypeRec();
		schema.getIntNetBackingStore().getTableMimeType().createMimeType(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IIntNetMimeTypeObj readMimeType( $implCommaIJavaOptAtomType$ pkey ) {
		return( readMimeType( pkey, false ) );
	}

	@Override
	public IIntNetMimeTypeObj readMimeType( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IIntNetMimeTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IIntNetMimeType readRec = schema.getIntNetBackingStore().getTableMimeType().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getMimeTypeTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IIntNetMimeTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetMimeTypeObj readCachedMimeType( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetMimeTypeObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeMimeType( IIntNetMimeTypeObj obj )
	{
		final String S_ProcName = "BusModelMimeTypeTableObj.reallyDeepDisposeMimeType() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetMimeTypeObj existing = readCachedMimeType( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IIntNetMimeTypeByUNameIdxKey keyUNameIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMimeType().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );



		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


	}
	@Override
	public void deepDisposeMimeType( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetMimeTypeObj obj = readCachedMimeType( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetMimeTypeObj lockMimeType( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetMimeTypeObj locked = null;
		IIntNetMimeType lockRec = schema.getIntNetBackingStore().getTableMimeType().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getMimeTypeTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IIntNetMimeTypeObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockMimeType", pkey );
		}
		return( locked );
	}

	@Override
	public List<IIntNetMimeTypeObj> readAllMimeType() {
		return( readAllMimeType( false ) );
	}

	@Override
	public List<IIntNetMimeTypeObj> readAllMimeType( boolean forceRead ) {
		final String S_ProcName = "readAllMimeType";
		if( ( allMimeType == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetMimeTypeObj> map = new HashMap<$implCommaIJavaOptAtomType$,IIntNetMimeTypeObj>();
			allMimeType = map;
			IIntNetMimeType[] recList = schema.getIntNetBackingStore().getTableMimeType().readAllDerived( null );
			IIntNetMimeType rec;
			IIntNetMimeTypeObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetMimeTypeObj realised = (IIntNetMimeTypeObj)obj.realise();
			}
		}
		int len = allMimeType.size();
		IIntNetMimeTypeObj arr[] = new IIntNetMimeTypeObj[len];
		Iterator<IIntNetMimeTypeObj> valIter = allMimeType.values().iterator();
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
		ArrayList<IIntNetMimeTypeObj> arrayList = new ArrayList<IIntNetMimeTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetMimeTypeObj> cmp = new Comparator<IIntNetMimeTypeObj>() {
			@Override
			public int compare( IIntNetMimeTypeObj lhs, IIntNetMimeTypeObj rhs ) {
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
		List<IIntNetMimeTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetMimeTypeObj> readCachedAllMimeType() {
		final String S_ProcName = "readCachedAllMimeType";
		ArrayList<IIntNetMimeTypeObj> arrayList = new ArrayList<IIntNetMimeTypeObj>();
		if( allMimeType != null ) {
			int len = allMimeType.size();
			IIntNetMimeTypeObj arr[] = new IIntNetMimeTypeObj[len];
			Iterator<IIntNetMimeTypeObj> valIter = allMimeType.values().iterator();
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
		Comparator<IIntNetMimeTypeObj> cmp = new Comparator<IIntNetMimeTypeObj>() {
			public int compare( IIntNetMimeTypeObj lhs, IIntNetMimeTypeObj rhs ) {
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
	public IIntNetMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId )
	{
		return( readMimeTypeByIdIdx( MimeTypeId,
			false ) );
	}

	@Override
	public IIntNetMimeTypeObj readMimeTypeByIdIdx( int MimeTypeId, boolean forceRead )
	{
		IIntNetMimeTypeObj obj = readMimeType( MimeTypeId, forceRead );
		return( obj );
	}

	@Override
	public IIntNetMimeTypeObj readMimeTypeByUNameIdx( String Name )
	{
		return( readMimeTypeByUNameIdx( Name,
			false ) );
	}

	@Override
	public IIntNetMimeTypeObj readMimeTypeByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IIntNetMimeTypeByUNameIdxKey,
				IIntNetMimeTypeObj >();
		}
		IIntNetMimeTypeByUNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMimeType().newByUNameIdxKey();
		key.setRequiredName( Name );
		IIntNetMimeTypeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IIntNetMimeType rec = schema.getIntNetBackingStore().getTableMimeType().readDerivedByUNameIdx( null,
				Name );
			if( rec != null ) {
				obj = schema.getMimeTypeTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IIntNetMimeTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetMimeTypeObj readCachedMimeTypeByIdIdx( int MimeTypeId )
	{
		IIntNetMimeTypeObj obj = null;
		obj = readCachedMimeType( MimeTypeId );
		return( obj );
	}

	@Override
	public IIntNetMimeTypeObj readCachedMimeTypeByUNameIdx( String Name )
	{
		IIntNetMimeTypeObj obj = null;
		IIntNetMimeTypeByUNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMimeType().newByUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IIntNetMimeTypeObj> valIter = members.values().iterator();
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
			Iterator<IIntNetMimeTypeObj> valIter = members.values().iterator();
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
	public void deepDisposeMimeTypeByIdIdx( int MimeTypeId )
	{
		IIntNetMimeTypeObj obj = readCachedMimeTypeByIdIdx( MimeTypeId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeMimeTypeByUNameIdx( String Name )
	{
		IIntNetMimeTypeObj obj = readCachedMimeTypeByUNameIdx( Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetMimeTypeObj updateMimeType( IIntNetMimeTypeObj Obj ) {
		IIntNetMimeTypeObj obj = Obj;
		schema.getIntNetBackingStore().getTableMimeType().updateMimeType( null,
			Obj.getMimeTypeRec() );
		obj = (IIntNetMimeTypeObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteMimeType( IIntNetMimeTypeObj Obj ) {
		IIntNetMimeTypeObj obj = Obj;
		schema.getIntNetBackingStore().getTableMimeType().deleteMimeType( null,
			obj.getMimeTypeRec() );
		Obj.forget();
	}

	@Override
	public void deleteMimeTypeByIdIdx( int MimeTypeId )
	{
		IIntNetMimeTypeObj obj = readMimeType(MimeTypeId);
		if( obj != null ) {
			IIntNetMimeTypeEditObj editObj = (IIntNetMimeTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IIntNetMimeTypeEditObj)obj.beginEdit();
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
		deepDisposeMimeTypeByIdIdx( MimeTypeId );
	}

	@Override
	public void deleteMimeTypeByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IIntNetMimeTypeByUNameIdxKey,
				IIntNetMimeTypeObj >();
		}
		IIntNetMimeTypeByUNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryMimeType().newByUNameIdxKey();
		key.setRequiredName( Name );
		IIntNetMimeTypeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getIntNetBackingStore().getTableMimeType().deleteMimeTypeByUNameIdx( null,
				Name );
			obj.forget();
		}
		else {
			schema.getIntNetBackingStore().getTableMimeType().deleteMimeTypeByUNameIdx( null,
				Name );
		}
		deepDisposeMimeTypeByUNameIdx( Name );
	}
}