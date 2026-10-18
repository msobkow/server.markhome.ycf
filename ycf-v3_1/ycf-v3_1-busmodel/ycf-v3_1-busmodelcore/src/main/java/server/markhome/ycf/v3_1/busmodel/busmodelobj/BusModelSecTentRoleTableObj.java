// Description: Java 25 Table Object implementation for SecTentRole.

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

public class BusModelSecTentRoleTableObj
	implements IBusModelSecTentRoleTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj> allSecTentRole;
	private Map< ISecureSecTentRoleByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > > indexByTenantIdx;
	private Map< ISecureSecTentRoleByNameIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > > indexByNameIdx;
	private Map< ISecureSecTentRoleByUNameIdxKey,
		ISecureSecTentRoleObj > indexByUNameIdx;
	public static String TABLE_NAME = "SecTentRole";
	public static String TABLE_DBNAME = "sectentrole";

	public BusModelSecTentRoleTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj>();
		allSecTentRole = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
	}

	public BusModelSecTentRoleTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj>();
		allSecTentRole = null;
		indexByTenantIdx = null;
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
		return SecureSecTentRoleTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecTentRoleTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecTentRoleTableObj.getRuntimeClassCode() );
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
		allSecTentRole = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
		List<ISecureSecTentRoleObj> toForget = new LinkedList<ISecureSecTentRoleObj>();
		ISecureSecTentRoleObj cur = null;
		Iterator<ISecureSecTentRoleObj> iter = members.values().iterator();
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
	 *	BusModelSecTentRoleObj.
	 */
	@Override
	public ISecureSecTentRoleObj newInstance() {
		ISecureSecTentRoleObj inst = new BusModelSecTentRoleObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecTentRoleObj.
	 */
	@Override
	public ISecureSecTentRoleEditObj newEditInstance( ISecureSecTentRoleObj orig ) {
		ISecureSecTentRoleEditObj edit = new BusModelSecTentRoleEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecTentRoleObj constructByClassCode( int backingClassCode ) {
		ISecureSecTentRoleObj obj = null;
		if( backingClassCode == ISecureSecTentRole.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecTentRoleTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecTentRoleObj realiseSecTentRole( ISecureSecTentRoleObj Obj ) {
		ISecureSecTentRoleObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecTentRoleObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecTentRoleObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				ISecureSecTentRoleByTenantIdxKey keyTenantIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecTentRoleByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.remove( keepObj.getPKey() );
					if( mapNameIdx.size() <= 0 ) {
						indexByNameIdx.remove( keyNameIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecTentRoleByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				ISecureSecTentRoleByTenantIdxKey keyTenantIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecTentRoleByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecTentRoleByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allSecTentRole != null ) {
				allSecTentRole.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecTentRole != null ) {
				allSecTentRole.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				ISecureSecTentRoleByTenantIdxKey keyTenantIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecTentRoleByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecTentRoleByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecTentRoleObj createSecTentRole( ISecureSecTentRoleObj Obj ) {
		ISecureSecTentRoleObj obj = Obj;
		ISecureSecTentRole rec = obj.getSecTentRoleRec();
		schema.getSecureBackingStore().getTableSecTentRole().createSecTentRole(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecTentRoleObj readSecTentRole( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecTentRole( pkey, false ) );
	}

	@Override
	public ISecureSecTentRoleObj readSecTentRole( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecTentRoleObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecTentRole readRec = schema.getSecureBackingStore().getTableSecTentRole().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecTentRoleTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecTentRoleObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecTentRoleObj readCachedSecTentRole( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecTentRoleObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecTentRole( ISecureSecTentRoleObj obj )
	{
		final String S_ProcName = "BusModelSecTentRoleTableObj.reallyDeepDisposeSecTentRole() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecTentRoleObj existing = readCachedSecTentRole( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecTentRoleByTenantIdxKey keyTenantIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		ISecureSecTentRoleByNameIdxKey keyNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		ISecureSecTentRoleByUNameIdxKey keyUNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		schema.getSecTentRoleMembTableObj().deepDisposeSecTentRoleMembByTentRoleIdx( existing.getRequiredSecTentRoleId() );

		if( indexByTenantIdx != null ) {
			if( indexByTenantIdx.containsKey( keyTenantIdx ) ) {
				indexByTenantIdx.get( keyTenantIdx ).remove( pkey );
				if( indexByTenantIdx.get( keyTenantIdx ).size() <= 0 ) {
					indexByTenantIdx.remove( keyTenantIdx );
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
	public void deepDisposeSecTentRole( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecTentRoleObj obj = readCachedSecTentRole( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecTentRoleObj lockSecTentRole( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecTentRoleObj locked = null;
		ISecureSecTentRole lockRec = schema.getSecureBackingStore().getTableSecTentRole().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecTentRoleTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecTentRoleObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecTentRole", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecTentRoleObj> readAllSecTentRole() {
		return( readAllSecTentRole( false ) );
	}

	@Override
	public List<ISecureSecTentRoleObj> readAllSecTentRole( boolean forceRead ) {
		final String S_ProcName = "readAllSecTentRole";
		if( ( allSecTentRole == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecTentRoleObj>();
			allSecTentRole = map;
			ISecureSecTentRole[] recList = schema.getSecureBackingStore().getTableSecTentRole().readAllDerived( null );
			ISecureSecTentRole rec;
			ISecureSecTentRoleObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentRoleObj realised = (ISecureSecTentRoleObj)obj.realise();
			}
		}
		int len = allSecTentRole.size();
		ISecureSecTentRoleObj arr[] = new ISecureSecTentRoleObj[len];
		Iterator<ISecureSecTentRoleObj> valIter = allSecTentRole.values().iterator();
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
		ArrayList<ISecureSecTentRoleObj> arrayList = new ArrayList<ISecureSecTentRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentRoleObj> cmp = new Comparator<ISecureSecTentRoleObj>() {
			@Override
			public int compare( ISecureSecTentRoleObj lhs, ISecureSecTentRoleObj rhs ) {
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
		List<ISecureSecTentRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecTentRoleObj> readCachedAllSecTentRole() {
		final String S_ProcName = "readCachedAllSecTentRole";
		ArrayList<ISecureSecTentRoleObj> arrayList = new ArrayList<ISecureSecTentRoleObj>();
		if( allSecTentRole != null ) {
			int len = allSecTentRole.size();
			ISecureSecTentRoleObj arr[] = new ISecureSecTentRoleObj[len];
			Iterator<ISecureSecTentRoleObj> valIter = allSecTentRole.values().iterator();
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
		Comparator<ISecureSecTentRoleObj> cmp = new Comparator<ISecureSecTentRoleObj>() {
			public int compare( ISecureSecTentRoleObj lhs, ISecureSecTentRoleObj rhs ) {
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
	public ISecureSecTentRoleObj readSecTentRoleByIdIdx( IYCFKeyHash256 SecTentRoleId )
	{
		return( readSecTentRoleByIdIdx( SecTentRoleId,
			false ) );
	}

	@Override
	public ISecureSecTentRoleObj readSecTentRoleByIdIdx( IYCFKeyHash256 SecTentRoleId, boolean forceRead )
	{
		ISecureSecTentRoleObj obj = readSecTentRole( SecTentRoleId, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecTentRoleObj> readSecTentRoleByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readSecTentRoleByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<ISecureSecTentRoleObj> readSecTentRoleByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecTentRoleByTenantIdx";
		ISecureSecTentRoleByTenantIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< ISecureSecTentRoleByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj>();
			ISecureSecTentRoleObj obj;
			ISecureSecTentRole[] recList = schema.getSecureBackingStore().getTableSecTentRole().readDerivedByTenantIdx( null,
				TenantId );
			ISecureSecTentRole rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecTentRoleTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentRoleObj realised = (ISecureSecTentRoleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecTentRoleObj arr[] = new ISecureSecTentRoleObj[len];
		Iterator<ISecureSecTentRoleObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecTentRoleObj> arrayList = new ArrayList<ISecureSecTentRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentRoleObj> cmp = new Comparator<ISecureSecTentRoleObj>() {
			@Override
			public int compare( ISecureSecTentRoleObj lhs, ISecureSecTentRoleObj rhs ) {
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
		List<ISecureSecTentRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecTentRoleObj> readSecTentRoleByNameIdx( String Name )
	{
		return( readSecTentRoleByNameIdx( Name,
			false ) );
	}

	@Override
	public List<ISecureSecTentRoleObj> readSecTentRoleByNameIdx( String Name,
		boolean forceRead )
	{
		final String S_ProcName = "readSecTentRoleByNameIdx";
		ISecureSecTentRoleByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByNameIdxKey();
		key.setRequiredName( Name );
		Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj> dict;
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecTentRoleByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > >();
		}
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			dict = indexByNameIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj>();
			ISecureSecTentRoleObj obj;
			ISecureSecTentRole[] recList = schema.getSecureBackingStore().getTableSecTentRole().readDerivedByNameIdx( null,
				Name );
			ISecureSecTentRole rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecTentRoleTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentRoleObj realised = (ISecureSecTentRoleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNameIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecTentRoleObj arr[] = new ISecureSecTentRoleObj[len];
		Iterator<ISecureSecTentRoleObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecTentRoleObj> arrayList = new ArrayList<ISecureSecTentRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentRoleObj> cmp = new Comparator<ISecureSecTentRoleObj>() {
			@Override
			public int compare( ISecureSecTentRoleObj lhs, ISecureSecTentRoleObj rhs ) {
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
		List<ISecureSecTentRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecTentRoleObj readSecTentRoleByUNameIdx( IYCFKeyHash256 TenantId,
		String Name )
	{
		return( readSecTentRoleByUNameIdx( TenantId,
			Name,
			false ) );
	}

	@Override
	public ISecureSecTentRoleObj readSecTentRoleByUNameIdx( IYCFKeyHash256 TenantId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecTentRoleByUNameIdxKey,
				ISecureSecTentRoleObj >();
		}
		ISecureSecTentRoleByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ISecureSecTentRoleObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			ISecureSecTentRole rec = schema.getSecureBackingStore().getTableSecTentRole().readDerivedByUNameIdx( null,
				TenantId,
				Name );
			if( rec != null ) {
				obj = schema.getSecTentRoleTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecTentRoleObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecTentRoleObj readCachedSecTentRoleByIdIdx( IYCFKeyHash256 SecTentRoleId )
	{
		ISecureSecTentRoleObj obj = null;
		obj = readCachedSecTentRole( SecTentRoleId );
		return( obj );
	}

	@Override
	public List<ISecureSecTentRoleObj> readCachedSecTentRoleByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedSecTentRoleByTenantIdx";
		ISecureSecTentRoleByTenantIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<ISecureSecTentRoleObj> arrayList = new ArrayList<ISecureSecTentRoleObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				ISecureSecTentRoleObj arr[] = new ISecureSecTentRoleObj[len];
				Iterator<ISecureSecTentRoleObj> valIter = dict.values().iterator();
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
			ISecureSecTentRoleObj obj;
			Iterator<ISecureSecTentRoleObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecTentRoleObj> cmp = new Comparator<ISecureSecTentRoleObj>() {
			@Override
			public int compare( ISecureSecTentRoleObj lhs, ISecureSecTentRoleObj rhs ) {
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
	public List<ISecureSecTentRoleObj> readCachedSecTentRoleByNameIdx( String Name )
	{
		final String S_ProcName = "readCachedSecTentRoleByNameIdx";
		ISecureSecTentRoleByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByNameIdxKey();
		key.setRequiredName( Name );
		ArrayList<ISecureSecTentRoleObj> arrayList = new ArrayList<ISecureSecTentRoleObj>();
		if( indexByNameIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj> dict;
			if( indexByNameIdx.containsKey( key ) ) {
				dict = indexByNameIdx.get( key );
				int len = dict.size();
				ISecureSecTentRoleObj arr[] = new ISecureSecTentRoleObj[len];
				Iterator<ISecureSecTentRoleObj> valIter = dict.values().iterator();
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
			ISecureSecTentRoleObj obj;
			Iterator<ISecureSecTentRoleObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecTentRoleObj> cmp = new Comparator<ISecureSecTentRoleObj>() {
			@Override
			public int compare( ISecureSecTentRoleObj lhs, ISecureSecTentRoleObj rhs ) {
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
	public ISecureSecTentRoleObj readCachedSecTentRoleByUNameIdx( IYCFKeyHash256 TenantId,
		String Name )
	{
		ISecureSecTentRoleObj obj = null;
		ISecureSecTentRoleByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<ISecureSecTentRoleObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecTentRoleObj> valIter = members.values().iterator();
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
	public void deepDisposeSecTentRoleByIdIdx( IYCFKeyHash256 SecTentRoleId )
	{
		ISecureSecTentRoleObj obj = readCachedSecTentRoleByIdIdx( SecTentRoleId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecTentRoleByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeSecTentRoleByTenantIdx";
		ISecureSecTentRoleObj obj;
		List<ISecureSecTentRoleObj> arrayList = readCachedSecTentRoleByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<ISecureSecTentRoleObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecTentRoleByNameIdx( String Name )
	{
		final String S_ProcName = "deepDisposeSecTentRoleByNameIdx";
		ISecureSecTentRoleObj obj;
		List<ISecureSecTentRoleObj> arrayList = readCachedSecTentRoleByNameIdx( Name );
		if( arrayList != null )  {
			Iterator<ISecureSecTentRoleObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecTentRoleByUNameIdx( IYCFKeyHash256 TenantId,
		String Name )
	{
		ISecureSecTentRoleObj obj = readCachedSecTentRoleByUNameIdx( TenantId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecTentRoleObj updateSecTentRole( ISecureSecTentRoleObj Obj ) {
		ISecureSecTentRoleObj obj = Obj;
		schema.getSecureBackingStore().getTableSecTentRole().updateSecTentRole( null,
			Obj.getSecTentRoleRec() );
		obj = (ISecureSecTentRoleObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecTentRole( ISecureSecTentRoleObj Obj ) {
		ISecureSecTentRoleObj obj = Obj;
		schema.getSecureBackingStore().getTableSecTentRole().deleteSecTentRole( null,
			obj.getSecTentRoleRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecTentRoleByIdIdx( IYCFKeyHash256 SecTentRoleId )
	{
		ISecureSecTentRoleObj obj = readSecTentRole(SecTentRoleId);
		if( obj != null ) {
			ISecureSecTentRoleEditObj editObj = (ISecureSecTentRoleEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecTentRoleEditObj)obj.beginEdit();
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
		deepDisposeSecTentRoleByIdIdx( SecTentRoleId );
	}

	@Override
	public void deleteSecTentRoleByTenantIdx( IYCFKeyHash256 TenantId )
	{
		ISecureSecTentRoleByTenantIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< ISecureSecTentRoleByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj> dict = indexByTenantIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentRole().deleteSecTentRoleByTenantIdx( null,
				TenantId );
			Iterator<ISecureSecTentRoleObj> iter = dict.values().iterator();
			ISecureSecTentRoleObj obj;
			List<ISecureSecTentRoleObj> toForget = new LinkedList<ISecureSecTentRoleObj>();
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
			schema.getSecureBackingStore().getTableSecTentRole().deleteSecTentRoleByTenantIdx( null,
				TenantId );
		}
		deepDisposeSecTentRoleByTenantIdx( TenantId );
	}

	@Override
	public void deleteSecTentRoleByNameIdx( String Name )
	{
		ISecureSecTentRoleByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecTentRoleByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecTentRoleObj > >();
		}
		if( indexByNameIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentRoleObj> dict = indexByNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentRole().deleteSecTentRoleByNameIdx( null,
				Name );
			Iterator<ISecureSecTentRoleObj> iter = dict.values().iterator();
			ISecureSecTentRoleObj obj;
			List<ISecureSecTentRoleObj> toForget = new LinkedList<ISecureSecTentRoleObj>();
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
			schema.getSecureBackingStore().getTableSecTentRole().deleteSecTentRoleByNameIdx( null,
				Name );
		}
		deepDisposeSecTentRoleByNameIdx( Name );
	}

	@Override
	public void deleteSecTentRoleByUNameIdx( IYCFKeyHash256 TenantId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecTentRoleByUNameIdxKey,
				ISecureSecTentRoleObj >();
		}
		ISecureSecTentRoleByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentRole().newByUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ISecureSecTentRoleObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentRole().deleteSecTentRoleByUNameIdx( null,
				TenantId,
				Name );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecTentRole().deleteSecTentRoleByUNameIdx( null,
				TenantId,
				Name );
		}
		deepDisposeSecTentRoleByUNameIdx( TenantId,
				Name );
	}
}