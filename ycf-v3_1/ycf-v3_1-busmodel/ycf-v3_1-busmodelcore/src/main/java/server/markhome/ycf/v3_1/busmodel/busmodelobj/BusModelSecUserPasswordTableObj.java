// Description: Java 25 Table Object implementation for SecUserPassword.

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

public class BusModelSecUserPasswordTableObj
	implements IBusModelSecUserPasswordTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj> allSecUserPassword;
	private Map< ISecureSecUserPasswordBySetStampIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj > > indexBySetStampIdx;
	public static String TABLE_NAME = "SecUserPassword";
	public static String TABLE_DBNAME = "secuserpw";

	public BusModelSecUserPasswordTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj>();
		allSecUserPassword = null;
		indexBySetStampIdx = null;
	}

	public BusModelSecUserPasswordTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj>();
		allSecUserPassword = null;
		indexBySetStampIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecUserPasswordTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecUserPasswordTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecUserPasswordTableObj.getRuntimeClassCode() );
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
		allSecUserPassword = null;
		indexBySetStampIdx = null;
		List<ISecureSecUserPasswordObj> toForget = new LinkedList<ISecureSecUserPasswordObj>();
		ISecureSecUserPasswordObj cur = null;
		Iterator<ISecureSecUserPasswordObj> iter = members.values().iterator();
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
	 *	BusModelSecUserPasswordObj.
	 */
	@Override
	public ISecureSecUserPasswordObj newInstance() {
		ISecureSecUserPasswordObj inst = new BusModelSecUserPasswordObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecUserPasswordObj.
	 */
	@Override
	public ISecureSecUserPasswordEditObj newEditInstance( ISecureSecUserPasswordObj orig ) {
		ISecureSecUserPasswordEditObj edit = new BusModelSecUserPasswordEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecUserPasswordObj constructByClassCode( int backingClassCode ) {
		ISecureSecUserPasswordObj obj = null;
		if( backingClassCode == ISecureSecUserPassword.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecUserPasswordTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPasswordObj realiseSecUserPassword( ISecureSecUserPasswordObj Obj ) {
		ISecureSecUserPasswordObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecUserPasswordObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecUserPasswordObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexBySetStampIdx != null ) {
				ISecureSecUserPasswordBySetStampIdxKey keySetStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPassword().newBySetStampIdxKey();
				keySetStampIdx.setRequiredPWSetStamp( keepObj.getRequiredPWSetStamp() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj > mapSetStampIdx = indexBySetStampIdx.get( keySetStampIdx );
				if( mapSetStampIdx != null ) {
					mapSetStampIdx.remove( keepObj.getPKey() );
					if( mapSetStampIdx.size() <= 0 ) {
						indexBySetStampIdx.remove( keySetStampIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexBySetStampIdx != null ) {
				ISecureSecUserPasswordBySetStampIdxKey keySetStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPassword().newBySetStampIdxKey();
				keySetStampIdx.setRequiredPWSetStamp( keepObj.getRequiredPWSetStamp() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj > mapSetStampIdx = indexBySetStampIdx.get( keySetStampIdx );
				if( mapSetStampIdx != null ) {
					mapSetStampIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecUserPassword != null ) {
				allSecUserPassword.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecUserPassword != null ) {
				allSecUserPassword.put( keepObj.getPKey(), keepObj );
			}

			if( indexBySetStampIdx != null ) {
				ISecureSecUserPasswordBySetStampIdxKey keySetStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPassword().newBySetStampIdxKey();
				keySetStampIdx.setRequiredPWSetStamp( keepObj.getRequiredPWSetStamp() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj > mapSetStampIdx = indexBySetStampIdx.get( keySetStampIdx );
				if( mapSetStampIdx != null ) {
					mapSetStampIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecUserPasswordObj createSecUserPassword( ISecureSecUserPasswordObj Obj ) {
		ISecureSecUserPasswordObj obj = Obj;
		ISecureSecUserPassword rec = obj.getSecUserPasswordRec();
		schema.getSecureBackingStore().getTableSecUserPassword().createSecUserPassword(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecUserPasswordObj readSecUserPassword( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecUserPassword( pkey, false ) );
	}

	@Override
	public ISecureSecUserPasswordObj readSecUserPassword( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecUserPasswordObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecUserPassword readRec = schema.getSecureBackingStore().getTableSecUserPassword().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecUserPasswordTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecUserPasswordObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPasswordObj readCachedSecUserPassword( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserPasswordObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecUserPassword( ISecureSecUserPasswordObj obj )
	{
		final String S_ProcName = "BusModelSecUserPasswordTableObj.reallyDeepDisposeSecUserPassword() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecUserPasswordObj existing = readCachedSecUserPassword( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecUserPasswordBySetStampIdxKey keySetStampIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPassword().newBySetStampIdxKey();
		keySetStampIdx.setRequiredPWSetStamp( existing.getRequiredPWSetStamp() );



		if( indexBySetStampIdx != null ) {
			if( indexBySetStampIdx.containsKey( keySetStampIdx ) ) {
				indexBySetStampIdx.get( keySetStampIdx ).remove( pkey );
				if( indexBySetStampIdx.get( keySetStampIdx ).size() <= 0 ) {
					indexBySetStampIdx.remove( keySetStampIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeSecUserPassword( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserPasswordObj obj = readCachedSecUserPassword( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecUserPasswordObj lockSecUserPassword( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserPasswordObj locked = null;
		ISecureSecUserPassword lockRec = schema.getSecureBackingStore().getTableSecUserPassword().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecUserPasswordTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecUserPasswordObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecUserPassword", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecUserPasswordObj> readAllSecUserPassword() {
		return( readAllSecUserPassword( false ) );
	}

	@Override
	public List<ISecureSecUserPasswordObj> readAllSecUserPassword( boolean forceRead ) {
		final String S_ProcName = "readAllSecUserPassword";
		if( ( allSecUserPassword == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecUserPasswordObj>();
			allSecUserPassword = map;
			ISecureSecUserPassword[] recList = schema.getSecureBackingStore().getTableSecUserPassword().readAllDerived( null );
			ISecureSecUserPassword rec;
			ISecureSecUserPasswordObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserPasswordObj realised = (ISecureSecUserPasswordObj)obj.realise();
			}
		}
		int len = allSecUserPassword.size();
		ISecureSecUserPasswordObj arr[] = new ISecureSecUserPasswordObj[len];
		Iterator<ISecureSecUserPasswordObj> valIter = allSecUserPassword.values().iterator();
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
		ArrayList<ISecureSecUserPasswordObj> arrayList = new ArrayList<ISecureSecUserPasswordObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserPasswordObj> cmp = new Comparator<ISecureSecUserPasswordObj>() {
			@Override
			public int compare( ISecureSecUserPasswordObj lhs, ISecureSecUserPasswordObj rhs ) {
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
		List<ISecureSecUserPasswordObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecUserPasswordObj> readCachedAllSecUserPassword() {
		final String S_ProcName = "readCachedAllSecUserPassword";
		ArrayList<ISecureSecUserPasswordObj> arrayList = new ArrayList<ISecureSecUserPasswordObj>();
		if( allSecUserPassword != null ) {
			int len = allSecUserPassword.size();
			ISecureSecUserPasswordObj arr[] = new ISecureSecUserPasswordObj[len];
			Iterator<ISecureSecUserPasswordObj> valIter = allSecUserPassword.values().iterator();
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
		Comparator<ISecureSecUserPasswordObj> cmp = new Comparator<ISecureSecUserPasswordObj>() {
			public int compare( ISecureSecUserPasswordObj lhs, ISecureSecUserPasswordObj rhs ) {
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
	public ISecureSecUserPasswordObj readSecUserPasswordByIdIdx( IYCFKeyHash256 SecUserId )
	{
		return( readSecUserPasswordByIdIdx( SecUserId,
			false ) );
	}

	@Override
	public ISecureSecUserPasswordObj readSecUserPasswordByIdIdx( IYCFKeyHash256 SecUserId, boolean forceRead )
	{
		ISecureSecUserPasswordObj obj = readSecUserPassword( SecUserId, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecUserPasswordObj> readSecUserPasswordBySetStampIdx( LocalDateTime PWSetStamp )
	{
		return( readSecUserPasswordBySetStampIdx( PWSetStamp,
			false ) );
	}

	@Override
	public List<ISecureSecUserPasswordObj> readSecUserPasswordBySetStampIdx( LocalDateTime PWSetStamp,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserPasswordBySetStampIdx";
		ISecureSecUserPasswordBySetStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPassword().newBySetStampIdxKey();
		key.setRequiredPWSetStamp( PWSetStamp );
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj> dict;
		if( indexBySetStampIdx == null ) {
			indexBySetStampIdx = new HashMap< ISecureSecUserPasswordBySetStampIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj > >();
		}
		if( ( ! forceRead ) && indexBySetStampIdx.containsKey( key ) ) {
			dict = indexBySetStampIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj>();
			ISecureSecUserPasswordObj obj;
			ISecureSecUserPassword[] recList = schema.getSecureBackingStore().getTableSecUserPassword().readDerivedBySetStampIdx( null,
				PWSetStamp );
			ISecureSecUserPassword rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecUserPasswordTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserPasswordObj realised = (ISecureSecUserPasswordObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySetStampIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecUserPasswordObj arr[] = new ISecureSecUserPasswordObj[len];
		Iterator<ISecureSecUserPasswordObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecUserPasswordObj> arrayList = new ArrayList<ISecureSecUserPasswordObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserPasswordObj> cmp = new Comparator<ISecureSecUserPasswordObj>() {
			@Override
			public int compare( ISecureSecUserPasswordObj lhs, ISecureSecUserPasswordObj rhs ) {
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
		List<ISecureSecUserPasswordObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecUserPasswordObj readCachedSecUserPasswordByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserPasswordObj obj = null;
		obj = readCachedSecUserPassword( SecUserId );
		return( obj );
	}

	@Override
	public List<ISecureSecUserPasswordObj> readCachedSecUserPasswordBySetStampIdx( LocalDateTime PWSetStamp )
	{
		final String S_ProcName = "readCachedSecUserPasswordBySetStampIdx";
		ISecureSecUserPasswordBySetStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPassword().newBySetStampIdxKey();
		key.setRequiredPWSetStamp( PWSetStamp );
		ArrayList<ISecureSecUserPasswordObj> arrayList = new ArrayList<ISecureSecUserPasswordObj>();
		if( indexBySetStampIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj> dict;
			if( indexBySetStampIdx.containsKey( key ) ) {
				dict = indexBySetStampIdx.get( key );
				int len = dict.size();
				ISecureSecUserPasswordObj arr[] = new ISecureSecUserPasswordObj[len];
				Iterator<ISecureSecUserPasswordObj> valIter = dict.values().iterator();
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
			ISecureSecUserPasswordObj obj;
			Iterator<ISecureSecUserPasswordObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecUserPasswordObj> cmp = new Comparator<ISecureSecUserPasswordObj>() {
			@Override
			public int compare( ISecureSecUserPasswordObj lhs, ISecureSecUserPasswordObj rhs ) {
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
	public void deepDisposeSecUserPasswordByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserPasswordObj obj = readCachedSecUserPasswordByIdIdx( SecUserId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserPasswordBySetStampIdx( LocalDateTime PWSetStamp )
	{
		final String S_ProcName = "deepDisposeSecUserPasswordBySetStampIdx";
		ISecureSecUserPasswordObj obj;
		List<ISecureSecUserPasswordObj> arrayList = readCachedSecUserPasswordBySetStampIdx( PWSetStamp );
		if( arrayList != null )  {
			Iterator<ISecureSecUserPasswordObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public ISecureSecUserPasswordObj updateSecUserPassword( ISecureSecUserPasswordObj Obj ) {
		ISecureSecUserPasswordObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUserPassword().updateSecUserPassword( null,
			Obj.getSecUserPasswordRec() );
		obj = (ISecureSecUserPasswordObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecUserPassword( ISecureSecUserPasswordObj Obj ) {
		ISecureSecUserPasswordObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUserPassword().deleteSecUserPassword( null,
			obj.getSecUserPasswordRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecUserPasswordByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserPasswordObj obj = readSecUserPassword(SecUserId);
		if( obj != null ) {
			ISecureSecUserPasswordEditObj editObj = (ISecureSecUserPasswordEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecUserPasswordEditObj)obj.beginEdit();
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
		deepDisposeSecUserPasswordByIdIdx( SecUserId );
	}

	@Override
	public void deleteSecUserPasswordBySetStampIdx( LocalDateTime PWSetStamp )
	{
		ISecureSecUserPasswordBySetStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPassword().newBySetStampIdxKey();
		key.setRequiredPWSetStamp( PWSetStamp );
		if( indexBySetStampIdx == null ) {
			indexBySetStampIdx = new HashMap< ISecureSecUserPasswordBySetStampIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj > >();
		}
		if( indexBySetStampIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserPasswordObj> dict = indexBySetStampIdx.get( key );
			schema.getSecureBackingStore().getTableSecUserPassword().deleteSecUserPasswordBySetStampIdx( null,
				PWSetStamp );
			Iterator<ISecureSecUserPasswordObj> iter = dict.values().iterator();
			ISecureSecUserPasswordObj obj;
			List<ISecureSecUserPasswordObj> toForget = new LinkedList<ISecureSecUserPasswordObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySetStampIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecUserPassword().deleteSecUserPasswordBySetStampIdx( null,
				PWSetStamp );
		}
		deepDisposeSecUserPasswordBySetStampIdx( PWSetStamp );
	}
}