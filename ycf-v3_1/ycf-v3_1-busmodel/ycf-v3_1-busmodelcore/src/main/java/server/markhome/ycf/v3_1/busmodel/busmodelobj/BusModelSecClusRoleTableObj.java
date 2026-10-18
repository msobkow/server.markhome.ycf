// Description: Java 25 Table Object implementation for SecClusRole.

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

public class BusModelSecClusRoleTableObj
	implements IBusModelSecClusRoleTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj> allSecClusRole;
	private Map< ISecureSecClusRoleByClusterIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > > indexByClusterIdx;
	private Map< ISecureSecClusRoleByNameIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > > indexByNameIdx;
	private Map< ISecureSecClusRoleByUNameIdxKey,
		ISecureSecClusRoleObj > indexByUNameIdx;
	public static String TABLE_NAME = "SecClusRole";
	public static String TABLE_DBNAME = "secclusrole";

	public BusModelSecClusRoleTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj>();
		allSecClusRole = null;
		indexByClusterIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
	}

	public BusModelSecClusRoleTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj>();
		allSecClusRole = null;
		indexByClusterIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecClusRoleTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecClusRoleTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecClusRoleTableObj.getRuntimeClassCode() );
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
		allSecClusRole = null;
		indexByClusterIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
		List<ISecureSecClusRoleObj> toForget = new LinkedList<ISecureSecClusRoleObj>();
		ISecureSecClusRoleObj cur = null;
		Iterator<ISecureSecClusRoleObj> iter = members.values().iterator();
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
	 *	BusModelSecClusRoleObj.
	 */
	@Override
	public ISecureSecClusRoleObj newInstance() {
		ISecureSecClusRoleObj inst = new BusModelSecClusRoleObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecClusRoleObj.
	 */
	@Override
	public ISecureSecClusRoleEditObj newEditInstance( ISecureSecClusRoleObj orig ) {
		ISecureSecClusRoleEditObj edit = new BusModelSecClusRoleEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecClusRoleObj constructByClassCode( int backingClassCode ) {
		ISecureSecClusRoleObj obj = null;
		if( backingClassCode == ISecureSecClusRole.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecClusRoleTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecClusRoleObj realiseSecClusRole( ISecureSecClusRoleObj Obj ) {
		ISecureSecClusRoleObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecClusRoleObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecClusRoleObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				ISecureSecClusRoleByClusterIdxKey keyClusterIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecClusRoleByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.remove( keepObj.getPKey() );
					if( mapNameIdx.size() <= 0 ) {
						indexByNameIdx.remove( keyNameIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecClusRoleByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				ISecureSecClusRoleByClusterIdxKey keyClusterIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecClusRoleByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecClusRoleByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allSecClusRole != null ) {
				allSecClusRole.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecClusRole != null ) {
				allSecClusRole.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				ISecureSecClusRoleByClusterIdxKey keyClusterIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecClusRoleByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecClusRoleByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecClusRoleObj createSecClusRole( ISecureSecClusRoleObj Obj ) {
		ISecureSecClusRoleObj obj = Obj;
		ISecureSecClusRole rec = obj.getSecClusRoleRec();
		schema.getSecureBackingStore().getTableSecClusRole().createSecClusRole(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecClusRoleObj readSecClusRole( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecClusRole( pkey, false ) );
	}

	@Override
	public ISecureSecClusRoleObj readSecClusRole( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecClusRoleObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecClusRole readRec = schema.getSecureBackingStore().getTableSecClusRole().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecClusRoleTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecClusRoleObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecClusRoleObj readCachedSecClusRole( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecClusRoleObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecClusRole( ISecureSecClusRoleObj obj )
	{
		final String S_ProcName = "BusModelSecClusRoleTableObj.reallyDeepDisposeSecClusRole() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecClusRoleObj existing = readCachedSecClusRole( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecClusRoleByClusterIdxKey keyClusterIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByClusterIdxKey();
		keyClusterIdx.setRequiredClusterId( existing.getRequiredClusterId() );

		ISecureSecClusRoleByNameIdxKey keyNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		ISecureSecClusRoleByUNameIdxKey keyUNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByUNameIdxKey();
		keyUNameIdx.setRequiredClusterId( existing.getRequiredClusterId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		schema.getSecClusRoleMembTableObj().deepDisposeSecClusRoleMembByClusRoleIdx( existing.getRequiredSecClusRoleId() );

		if( indexByClusterIdx != null ) {
			if( indexByClusterIdx.containsKey( keyClusterIdx ) ) {
				indexByClusterIdx.get( keyClusterIdx ).remove( pkey );
				if( indexByClusterIdx.get( keyClusterIdx ).size() <= 0 ) {
					indexByClusterIdx.remove( keyClusterIdx );
				}
			}
		}

		if( indexByNameIdx != null ) {
			if( indexByNameIdx.containsKey( keyNameIdx ) ) {
				indexByNameIdx.get( keyNameIdx ).remove( pkey );
				if( indexByNameIdx.get( keyNameIdx ).size() <= 0 ) {
					indexByNameIdx.remove( keyNameIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


	}
	@Override
	public void deepDisposeSecClusRole( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecClusRoleObj obj = readCachedSecClusRole( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecClusRoleObj lockSecClusRole( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecClusRoleObj locked = null;
		ISecureSecClusRole lockRec = schema.getSecureBackingStore().getTableSecClusRole().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecClusRoleTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecClusRoleObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecClusRole", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecClusRoleObj> readAllSecClusRole() {
		return( readAllSecClusRole( false ) );
	}

	@Override
	public List<ISecureSecClusRoleObj> readAllSecClusRole( boolean forceRead ) {
		final String S_ProcName = "readAllSecClusRole";
		if( ( allSecClusRole == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecClusRoleObj>();
			allSecClusRole = map;
			ISecureSecClusRole[] recList = schema.getSecureBackingStore().getTableSecClusRole().readAllDerived( null );
			ISecureSecClusRole rec;
			ISecureSecClusRoleObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusRoleObj realised = (ISecureSecClusRoleObj)obj.realise();
			}
		}
		int len = allSecClusRole.size();
		ISecureSecClusRoleObj arr[] = new ISecureSecClusRoleObj[len];
		Iterator<ISecureSecClusRoleObj> valIter = allSecClusRole.values().iterator();
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
		ArrayList<ISecureSecClusRoleObj> arrayList = new ArrayList<ISecureSecClusRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusRoleObj> cmp = new Comparator<ISecureSecClusRoleObj>() {
			@Override
			public int compare( ISecureSecClusRoleObj lhs, ISecureSecClusRoleObj rhs ) {
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
		List<ISecureSecClusRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecClusRoleObj> readCachedAllSecClusRole() {
		final String S_ProcName = "readCachedAllSecClusRole";
		ArrayList<ISecureSecClusRoleObj> arrayList = new ArrayList<ISecureSecClusRoleObj>();
		if( allSecClusRole != null ) {
			int len = allSecClusRole.size();
			ISecureSecClusRoleObj arr[] = new ISecureSecClusRoleObj[len];
			Iterator<ISecureSecClusRoleObj> valIter = allSecClusRole.values().iterator();
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
		Comparator<ISecureSecClusRoleObj> cmp = new Comparator<ISecureSecClusRoleObj>() {
			public int compare( ISecureSecClusRoleObj lhs, ISecureSecClusRoleObj rhs ) {
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
	public ISecureSecClusRoleObj readSecClusRoleByIdIdx( IYCFKeyHash256 SecClusRoleId )
	{
		return( readSecClusRoleByIdIdx( SecClusRoleId,
			false ) );
	}

	@Override
	public ISecureSecClusRoleObj readSecClusRoleByIdIdx( IYCFKeyHash256 SecClusRoleId, boolean forceRead )
	{
		ISecureSecClusRoleObj obj = readSecClusRole( SecClusRoleId, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecClusRoleObj> readSecClusRoleByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		return( readSecClusRoleByClusterIdx( ClusterId,
			false ) );
	}

	@Override
	public List<ISecureSecClusRoleObj> readSecClusRoleByClusterIdx( IYCFKeyHash256 ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecClusRoleByClusterIdx";
		ISecureSecClusRoleByClusterIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< ISecureSecClusRoleByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj>();
			ISecureSecClusRoleObj obj;
			ISecureSecClusRole[] recList = schema.getSecureBackingStore().getTableSecClusRole().readDerivedByClusterIdx( null,
				ClusterId );
			ISecureSecClusRole rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecClusRoleTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusRoleObj realised = (ISecureSecClusRoleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecClusRoleObj arr[] = new ISecureSecClusRoleObj[len];
		Iterator<ISecureSecClusRoleObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecClusRoleObj> arrayList = new ArrayList<ISecureSecClusRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusRoleObj> cmp = new Comparator<ISecureSecClusRoleObj>() {
			@Override
			public int compare( ISecureSecClusRoleObj lhs, ISecureSecClusRoleObj rhs ) {
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
		List<ISecureSecClusRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecClusRoleObj> readSecClusRoleByNameIdx( String Name )
	{
		return( readSecClusRoleByNameIdx( Name,
			false ) );
	}

	@Override
	public List<ISecureSecClusRoleObj> readSecClusRoleByNameIdx( String Name,
		boolean forceRead )
	{
		final String S_ProcName = "readSecClusRoleByNameIdx";
		ISecureSecClusRoleByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByNameIdxKey();
		key.setRequiredName( Name );
		Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj> dict;
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecClusRoleByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > >();
		}
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			dict = indexByNameIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj>();
			ISecureSecClusRoleObj obj;
			ISecureSecClusRole[] recList = schema.getSecureBackingStore().getTableSecClusRole().readDerivedByNameIdx( null,
				Name );
			ISecureSecClusRole rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecClusRoleTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecClusRoleObj realised = (ISecureSecClusRoleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNameIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecClusRoleObj arr[] = new ISecureSecClusRoleObj[len];
		Iterator<ISecureSecClusRoleObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecClusRoleObj> arrayList = new ArrayList<ISecureSecClusRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecClusRoleObj> cmp = new Comparator<ISecureSecClusRoleObj>() {
			@Override
			public int compare( ISecureSecClusRoleObj lhs, ISecureSecClusRoleObj rhs ) {
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
		List<ISecureSecClusRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecClusRoleObj readSecClusRoleByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name )
	{
		return( readSecClusRoleByUNameIdx( ClusterId,
			Name,
			false ) );
	}

	@Override
	public ISecureSecClusRoleObj readSecClusRoleByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecClusRoleByUNameIdxKey,
				ISecureSecClusRoleObj >();
		}
		ISecureSecClusRoleByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ISecureSecClusRoleObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			ISecureSecClusRole rec = schema.getSecureBackingStore().getTableSecClusRole().readDerivedByUNameIdx( null,
				ClusterId,
				Name );
			if( rec != null ) {
				obj = schema.getSecClusRoleTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecClusRoleObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecClusRoleObj readCachedSecClusRoleByIdIdx( IYCFKeyHash256 SecClusRoleId )
	{
		ISecureSecClusRoleObj obj = null;
		obj = readCachedSecClusRole( SecClusRoleId );
		return( obj );
	}

	@Override
	public List<ISecureSecClusRoleObj> readCachedSecClusRoleByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "readCachedSecClusRoleByClusterIdx";
		ISecureSecClusRoleByClusterIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		ArrayList<ISecureSecClusRoleObj> arrayList = new ArrayList<ISecureSecClusRoleObj>();
		if( indexByClusterIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj> dict;
			if( indexByClusterIdx.containsKey( key ) ) {
				dict = indexByClusterIdx.get( key );
				int len = dict.size();
				ISecureSecClusRoleObj arr[] = new ISecureSecClusRoleObj[len];
				Iterator<ISecureSecClusRoleObj> valIter = dict.values().iterator();
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
			ISecureSecClusRoleObj obj;
			Iterator<ISecureSecClusRoleObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecClusRoleObj> cmp = new Comparator<ISecureSecClusRoleObj>() {
			@Override
			public int compare( ISecureSecClusRoleObj lhs, ISecureSecClusRoleObj rhs ) {
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
	public List<ISecureSecClusRoleObj> readCachedSecClusRoleByNameIdx( String Name )
	{
		final String S_ProcName = "readCachedSecClusRoleByNameIdx";
		ISecureSecClusRoleByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByNameIdxKey();
		key.setRequiredName( Name );
		ArrayList<ISecureSecClusRoleObj> arrayList = new ArrayList<ISecureSecClusRoleObj>();
		if( indexByNameIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj> dict;
			if( indexByNameIdx.containsKey( key ) ) {
				dict = indexByNameIdx.get( key );
				int len = dict.size();
				ISecureSecClusRoleObj arr[] = new ISecureSecClusRoleObj[len];
				Iterator<ISecureSecClusRoleObj> valIter = dict.values().iterator();
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
			ISecureSecClusRoleObj obj;
			Iterator<ISecureSecClusRoleObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecClusRoleObj> cmp = new Comparator<ISecureSecClusRoleObj>() {
			@Override
			public int compare( ISecureSecClusRoleObj lhs, ISecureSecClusRoleObj rhs ) {
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
	public ISecureSecClusRoleObj readCachedSecClusRoleByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name )
	{
		ISecureSecClusRoleObj obj = null;
		ISecureSecClusRoleByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<ISecureSecClusRoleObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecClusRoleObj> valIter = members.values().iterator();
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
	public void deepDisposeSecClusRoleByIdIdx( IYCFKeyHash256 SecClusRoleId )
	{
		ISecureSecClusRoleObj obj = readCachedSecClusRoleByIdIdx( SecClusRoleId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecClusRoleByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		final String S_ProcName = "deepDisposeSecClusRoleByClusterIdx";
		ISecureSecClusRoleObj obj;
		List<ISecureSecClusRoleObj> arrayList = readCachedSecClusRoleByClusterIdx( ClusterId );
		if( arrayList != null )  {
			Iterator<ISecureSecClusRoleObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecClusRoleByNameIdx( String Name )
	{
		final String S_ProcName = "deepDisposeSecClusRoleByNameIdx";
		ISecureSecClusRoleObj obj;
		List<ISecureSecClusRoleObj> arrayList = readCachedSecClusRoleByNameIdx( Name );
		if( arrayList != null )  {
			Iterator<ISecureSecClusRoleObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecClusRoleByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name )
	{
		ISecureSecClusRoleObj obj = readCachedSecClusRoleByUNameIdx( ClusterId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecClusRoleObj updateSecClusRole( ISecureSecClusRoleObj Obj ) {
		ISecureSecClusRoleObj obj = Obj;
		schema.getSecureBackingStore().getTableSecClusRole().updateSecClusRole( null,
			Obj.getSecClusRoleRec() );
		obj = (ISecureSecClusRoleObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecClusRole( ISecureSecClusRoleObj Obj ) {
		ISecureSecClusRoleObj obj = Obj;
		schema.getSecureBackingStore().getTableSecClusRole().deleteSecClusRole( null,
			obj.getSecClusRoleRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecClusRoleByIdIdx( IYCFKeyHash256 SecClusRoleId )
	{
		ISecureSecClusRoleObj obj = readSecClusRole(SecClusRoleId);
		if( obj != null ) {
			ISecureSecClusRoleEditObj editObj = (ISecureSecClusRoleEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecClusRoleEditObj)obj.beginEdit();
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
		deepDisposeSecClusRoleByIdIdx( SecClusRoleId );
	}

	@Override
	public void deleteSecClusRoleByClusterIdx( IYCFKeyHash256 ClusterId )
	{
		ISecureSecClusRoleByClusterIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< ISecureSecClusRoleByClusterIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj> dict = indexByClusterIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusRole().deleteSecClusRoleByClusterIdx( null,
				ClusterId );
			Iterator<ISecureSecClusRoleObj> iter = dict.values().iterator();
			ISecureSecClusRoleObj obj;
			List<ISecureSecClusRoleObj> toForget = new LinkedList<ISecureSecClusRoleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByClusterIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecClusRole().deleteSecClusRoleByClusterIdx( null,
				ClusterId );
		}
		deepDisposeSecClusRoleByClusterIdx( ClusterId );
	}

	@Override
	public void deleteSecClusRoleByNameIdx( String Name )
	{
		ISecureSecClusRoleByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecClusRoleByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecClusRoleObj > >();
		}
		if( indexByNameIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecClusRoleObj> dict = indexByNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusRole().deleteSecClusRoleByNameIdx( null,
				Name );
			Iterator<ISecureSecClusRoleObj> iter = dict.values().iterator();
			ISecureSecClusRoleObj obj;
			List<ISecureSecClusRoleObj> toForget = new LinkedList<ISecureSecClusRoleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByNameIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecClusRole().deleteSecClusRoleByNameIdx( null,
				Name );
		}
		deepDisposeSecClusRoleByNameIdx( Name );
	}

	@Override
	public void deleteSecClusRoleByUNameIdx( IYCFKeyHash256 ClusterId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecClusRoleByUNameIdxKey,
				ISecureSecClusRoleObj >();
		}
		ISecureSecClusRoleByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newByUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ISecureSecClusRoleObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecClusRole().deleteSecClusRoleByUNameIdx( null,
				ClusterId,
				Name );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecClusRole().deleteSecClusRoleByUNameIdx( null,
				ClusterId,
				Name );
		}
		deepDisposeSecClusRoleByUNameIdx( ClusterId,
				Name );
	}
}