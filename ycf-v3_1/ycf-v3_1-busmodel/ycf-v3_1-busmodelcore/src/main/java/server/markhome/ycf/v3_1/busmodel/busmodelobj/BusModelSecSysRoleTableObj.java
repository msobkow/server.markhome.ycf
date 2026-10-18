// Description: Java 25 Table Object implementation for SecSysRole.

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

public class BusModelSecSysRoleTableObj
	implements IBusModelSecSysRoleTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecSysRoleObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecSysRoleObj> allSecSysRole;
	private Map< ISecureSecSysRoleByUNameIdxKey,
		ISecureSecSysRoleObj > indexByUNameIdx;
	public static String TABLE_NAME = "SecSysRole";
	public static String TABLE_DBNAME = "secsysrole";

	public BusModelSecSysRoleTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSysRoleObj>();
		allSecSysRole = null;
		indexByUNameIdx = null;
	}

	public BusModelSecSysRoleTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSysRoleObj>();
		allSecSysRole = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecSysRoleTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecSysRoleTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecSysRoleTableObj.getRuntimeClassCode() );
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
		allSecSysRole = null;
		indexByUNameIdx = null;
		List<ISecureSecSysRoleObj> toForget = new LinkedList<ISecureSecSysRoleObj>();
		ISecureSecSysRoleObj cur = null;
		Iterator<ISecureSecSysRoleObj> iter = members.values().iterator();
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
	 *	BusModelSecSysRoleObj.
	 */
	@Override
	public ISecureSecSysRoleObj newInstance() {
		ISecureSecSysRoleObj inst = new BusModelSecSysRoleObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecSysRoleObj.
	 */
	@Override
	public ISecureSecSysRoleEditObj newEditInstance( ISecureSecSysRoleObj orig ) {
		ISecureSecSysRoleEditObj edit = new BusModelSecSysRoleEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecSysRoleObj constructByClassCode( int backingClassCode ) {
		ISecureSecSysRoleObj obj = null;
		if( backingClassCode == ISecureSecSysRole.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecSysRoleTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecSysRoleObj realiseSecSysRole( ISecureSecSysRoleObj Obj ) {
		ISecureSecSysRoleObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecSysRoleObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecSysRoleObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				ISecureSecSysRoleByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRole().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				ISecureSecSysRoleByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRole().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allSecSysRole != null ) {
				allSecSysRole.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecSysRole != null ) {
				allSecSysRole.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				ISecureSecSysRoleByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRole().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecSysRoleObj createSecSysRole( ISecureSecSysRoleObj Obj ) {
		ISecureSecSysRoleObj obj = Obj;
		ISecureSecSysRole rec = obj.getSecSysRoleRec();
		schema.getSecureBackingStore().getTableSecSysRole().createSecSysRole(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecSysRoleObj readSecSysRole( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecSysRole( pkey, false ) );
	}

	@Override
	public ISecureSecSysRoleObj readSecSysRole( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecSysRoleObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecSysRole readRec = schema.getSecureBackingStore().getTableSecSysRole().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecSysRoleTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecSysRoleObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecSysRoleObj readCachedSecSysRole( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecSysRoleObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecSysRole( ISecureSecSysRoleObj obj )
	{
		final String S_ProcName = "BusModelSecSysRoleTableObj.reallyDeepDisposeSecSysRole() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecSysRoleObj existing = readCachedSecSysRole( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecSysRoleByUNameIdxKey keyUNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRole().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getSecSysRoleMembTableObj().deepDisposeSecSysRoleMembBySysRoleIdx( existing.getRequiredSecSysRoleId() );
					schema.getSecSysRoleEnablesTableObj().deepDisposeSecSysRoleEnablesBySysRoleIdx( existing.getRequiredSecSysRoleId() );

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


	}
	@Override
	public void deepDisposeSecSysRole( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecSysRoleObj obj = readCachedSecSysRole( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecSysRoleObj lockSecSysRole( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecSysRoleObj locked = null;
		ISecureSecSysRole lockRec = schema.getSecureBackingStore().getTableSecSysRole().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecSysRoleTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecSysRoleObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecSysRole", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecSysRoleObj> readAllSecSysRole() {
		return( readAllSecSysRole( false ) );
	}

	@Override
	public List<ISecureSecSysRoleObj> readAllSecSysRole( boolean forceRead ) {
		final String S_ProcName = "readAllSecSysRole";
		if( ( allSecSysRole == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSysRoleObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecSysRoleObj>();
			allSecSysRole = map;
			ISecureSecSysRole[] recList = schema.getSecureBackingStore().getTableSecSysRole().readAllDerived( null );
			ISecureSecSysRole rec;
			ISecureSecSysRoleObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysRoleObj realised = (ISecureSecSysRoleObj)obj.realise();
			}
		}
		int len = allSecSysRole.size();
		ISecureSecSysRoleObj arr[] = new ISecureSecSysRoleObj[len];
		Iterator<ISecureSecSysRoleObj> valIter = allSecSysRole.values().iterator();
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
		ArrayList<ISecureSecSysRoleObj> arrayList = new ArrayList<ISecureSecSysRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysRoleObj> cmp = new Comparator<ISecureSecSysRoleObj>() {
			@Override
			public int compare( ISecureSecSysRoleObj lhs, ISecureSecSysRoleObj rhs ) {
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
		List<ISecureSecSysRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSysRoleObj> readCachedAllSecSysRole() {
		final String S_ProcName = "readCachedAllSecSysRole";
		ArrayList<ISecureSecSysRoleObj> arrayList = new ArrayList<ISecureSecSysRoleObj>();
		if( allSecSysRole != null ) {
			int len = allSecSysRole.size();
			ISecureSecSysRoleObj arr[] = new ISecureSecSysRoleObj[len];
			Iterator<ISecureSecSysRoleObj> valIter = allSecSysRole.values().iterator();
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
		Comparator<ISecureSecSysRoleObj> cmp = new Comparator<ISecureSecSysRoleObj>() {
			public int compare( ISecureSecSysRoleObj lhs, ISecureSecSysRoleObj rhs ) {
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
	public ISecureSecSysRoleObj readSecSysRoleByIdIdx( IYCFKeyHash256 SecSysRoleId )
	{
		return( readSecSysRoleByIdIdx( SecSysRoleId,
			false ) );
	}

	@Override
	public ISecureSecSysRoleObj readSecSysRoleByIdIdx( IYCFKeyHash256 SecSysRoleId, boolean forceRead )
	{
		ISecureSecSysRoleObj obj = readSecSysRole( SecSysRoleId, forceRead );
		return( obj );
	}

	@Override
	public ISecureSecSysRoleObj readSecSysRoleByUNameIdx( String Name )
	{
		return( readSecSysRoleByUNameIdx( Name,
			false ) );
	}

	@Override
	public ISecureSecSysRoleObj readSecSysRoleByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecSysRoleByUNameIdxKey,
				ISecureSecSysRoleObj >();
		}
		ISecureSecSysRoleByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRole().newByUNameIdxKey();
		key.setRequiredName( Name );
		ISecureSecSysRoleObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			ISecureSecSysRole rec = schema.getSecureBackingStore().getTableSecSysRole().readDerivedByUNameIdx( null,
				Name );
			if( rec != null ) {
				obj = schema.getSecSysRoleTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecSysRoleObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecSysRoleObj readCachedSecSysRoleByIdIdx( IYCFKeyHash256 SecSysRoleId )
	{
		ISecureSecSysRoleObj obj = null;
		obj = readCachedSecSysRole( SecSysRoleId );
		return( obj );
	}

	@Override
	public ISecureSecSysRoleObj readCachedSecSysRoleByUNameIdx( String Name )
	{
		ISecureSecSysRoleObj obj = null;
		ISecureSecSysRoleByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRole().newByUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<ISecureSecSysRoleObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecSysRoleObj> valIter = members.values().iterator();
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
	public void deepDisposeSecSysRoleByIdIdx( IYCFKeyHash256 SecSysRoleId )
	{
		ISecureSecSysRoleObj obj = readCachedSecSysRoleByIdIdx( SecSysRoleId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecSysRoleByUNameIdx( String Name )
	{
		ISecureSecSysRoleObj obj = readCachedSecSysRoleByUNameIdx( Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecSysRoleObj updateSecSysRole( ISecureSecSysRoleObj Obj ) {
		ISecureSecSysRoleObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysRole().updateSecSysRole( null,
			Obj.getSecSysRoleRec() );
		obj = (ISecureSecSysRoleObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecSysRole( ISecureSecSysRoleObj Obj ) {
		ISecureSecSysRoleObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysRole().deleteSecSysRole( null,
			obj.getSecSysRoleRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecSysRoleByIdIdx( IYCFKeyHash256 SecSysRoleId )
	{
		ISecureSecSysRoleObj obj = readSecSysRole(SecSysRoleId);
		if( obj != null ) {
			ISecureSecSysRoleEditObj editObj = (ISecureSecSysRoleEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecSysRoleEditObj)obj.beginEdit();
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
		deepDisposeSecSysRoleByIdIdx( SecSysRoleId );
	}

	@Override
	public void deleteSecSysRoleByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecSysRoleByUNameIdxKey,
				ISecureSecSysRoleObj >();
		}
		ISecureSecSysRoleByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRole().newByUNameIdxKey();
		key.setRequiredName( Name );
		ISecureSecSysRoleObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecSysRole().deleteSecSysRoleByUNameIdx( null,
				Name );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecSysRole().deleteSecSysRoleByUNameIdx( null,
				Name );
		}
		deepDisposeSecSysRoleByUNameIdx( Name );
	}
}