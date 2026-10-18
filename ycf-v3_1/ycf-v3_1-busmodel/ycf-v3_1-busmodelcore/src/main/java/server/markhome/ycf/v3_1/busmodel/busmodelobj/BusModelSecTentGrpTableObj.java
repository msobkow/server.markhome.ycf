// Description: Java 25 Table Object implementation for SecTentGrp.

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

public class BusModelSecTentGrpTableObj
	implements IBusModelSecTentGrpTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj> allSecTentGrp;
	private Map< ISecureSecTentGrpByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > > indexByTenantIdx;
	private Map< ISecureSecTentGrpByNameIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > > indexByNameIdx;
	private Map< ISecureSecTentGrpByUNameIdxKey,
		ISecureSecTentGrpObj > indexByUNameIdx;
	public static String TABLE_NAME = "SecTentGrp";
	public static String TABLE_DBNAME = "sectentgrp";

	public BusModelSecTentGrpTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj>();
		allSecTentGrp = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
	}

	public BusModelSecTentGrpTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj>();
		allSecTentGrp = null;
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
		return SecureSecTentGrpTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecTentGrpTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecTentGrpTableObj.getRuntimeClassCode() );
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
		allSecTentGrp = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
		indexByUNameIdx = null;
		List<ISecureSecTentGrpObj> toForget = new LinkedList<ISecureSecTentGrpObj>();
		ISecureSecTentGrpObj cur = null;
		Iterator<ISecureSecTentGrpObj> iter = members.values().iterator();
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
	 *	BusModelSecTentGrpObj.
	 */
	@Override
	public ISecureSecTentGrpObj newInstance() {
		ISecureSecTentGrpObj inst = new BusModelSecTentGrpObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecTentGrpObj.
	 */
	@Override
	public ISecureSecTentGrpEditObj newEditInstance( ISecureSecTentGrpObj orig ) {
		ISecureSecTentGrpEditObj edit = new BusModelSecTentGrpEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecTentGrpObj constructByClassCode( int backingClassCode ) {
		ISecureSecTentGrpObj obj = null;
		if( backingClassCode == ISecureSecTentGrp.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecTentGrpTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecTentGrpObj realiseSecTentGrp( ISecureSecTentGrpObj Obj ) {
		ISecureSecTentGrpObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecTentGrpObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecTentGrpObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				ISecureSecTentGrpByTenantIdxKey keyTenantIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecTentGrpByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.remove( keepObj.getPKey() );
					if( mapNameIdx.size() <= 0 ) {
						indexByNameIdx.remove( keyNameIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecTentGrpByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				ISecureSecTentGrpByTenantIdxKey keyTenantIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecTentGrpByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecTentGrpByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allSecTentGrp != null ) {
				allSecTentGrp.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecTentGrp != null ) {
				allSecTentGrp.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				ISecureSecTentGrpByTenantIdxKey keyTenantIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecTentGrpByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				ISecureSecTentGrpByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecTentGrpObj createSecTentGrp( ISecureSecTentGrpObj Obj ) {
		ISecureSecTentGrpObj obj = Obj;
		ISecureSecTentGrp rec = obj.getSecTentGrpRec();
		schema.getSecureBackingStore().getTableSecTentGrp().createSecTentGrp(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecTentGrpObj readSecTentGrp( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecTentGrp( pkey, false ) );
	}

	@Override
	public ISecureSecTentGrpObj readSecTentGrp( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecTentGrpObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecTentGrp readRec = schema.getSecureBackingStore().getTableSecTentGrp().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecTentGrpTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecTentGrpObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecTentGrpObj readCachedSecTentGrp( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecTentGrpObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecTentGrp( ISecureSecTentGrpObj obj )
	{
		final String S_ProcName = "BusModelSecTentGrpTableObj.reallyDeepDisposeSecTentGrp() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecTentGrpObj existing = readCachedSecTentGrp( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecTentGrpByTenantIdxKey keyTenantIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		ISecureSecTentGrpByNameIdxKey keyNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );

		ISecureSecTentGrpByUNameIdxKey keyUNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByUNameIdxKey();
		keyUNameIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getSecTentGrpMembTableObj().deepDisposeSecTentGrpMembByTentGrpIdx( existing.getRequiredSecTentGrpId() );

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
	public void deepDisposeSecTentGrp( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecTentGrpObj obj = readCachedSecTentGrp( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecTentGrpObj lockSecTentGrp( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecTentGrpObj locked = null;
		ISecureSecTentGrp lockRec = schema.getSecureBackingStore().getTableSecTentGrp().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecTentGrpTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecTentGrpObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecTentGrp", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecTentGrpObj> readAllSecTentGrp() {
		return( readAllSecTentGrp( false ) );
	}

	@Override
	public List<ISecureSecTentGrpObj> readAllSecTentGrp( boolean forceRead ) {
		final String S_ProcName = "readAllSecTentGrp";
		if( ( allSecTentGrp == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecTentGrpObj>();
			allSecTentGrp = map;
			ISecureSecTentGrp[] recList = schema.getSecureBackingStore().getTableSecTentGrp().readAllDerived( null );
			ISecureSecTentGrp rec;
			ISecureSecTentGrpObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentGrpObj realised = (ISecureSecTentGrpObj)obj.realise();
			}
		}
		int len = allSecTentGrp.size();
		ISecureSecTentGrpObj arr[] = new ISecureSecTentGrpObj[len];
		Iterator<ISecureSecTentGrpObj> valIter = allSecTentGrp.values().iterator();
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
		ArrayList<ISecureSecTentGrpObj> arrayList = new ArrayList<ISecureSecTentGrpObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentGrpObj> cmp = new Comparator<ISecureSecTentGrpObj>() {
			@Override
			public int compare( ISecureSecTentGrpObj lhs, ISecureSecTentGrpObj rhs ) {
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
		List<ISecureSecTentGrpObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecTentGrpObj> readCachedAllSecTentGrp() {
		final String S_ProcName = "readCachedAllSecTentGrp";
		ArrayList<ISecureSecTentGrpObj> arrayList = new ArrayList<ISecureSecTentGrpObj>();
		if( allSecTentGrp != null ) {
			int len = allSecTentGrp.size();
			ISecureSecTentGrpObj arr[] = new ISecureSecTentGrpObj[len];
			Iterator<ISecureSecTentGrpObj> valIter = allSecTentGrp.values().iterator();
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
		Comparator<ISecureSecTentGrpObj> cmp = new Comparator<ISecureSecTentGrpObj>() {
			public int compare( ISecureSecTentGrpObj lhs, ISecureSecTentGrpObj rhs ) {
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
	public ISecureSecTentGrpObj readSecTentGrpByIdIdx( IYCFKeyHash256 SecTentGrpId )
	{
		return( readSecTentGrpByIdIdx( SecTentGrpId,
			false ) );
	}

	@Override
	public ISecureSecTentGrpObj readSecTentGrpByIdIdx( IYCFKeyHash256 SecTentGrpId, boolean forceRead )
	{
		ISecureSecTentGrpObj obj = readSecTentGrp( SecTentGrpId, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecTentGrpObj> readSecTentGrpByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readSecTentGrpByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<ISecureSecTentGrpObj> readSecTentGrpByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecTentGrpByTenantIdx";
		ISecureSecTentGrpByTenantIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< ISecureSecTentGrpByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj>();
			ISecureSecTentGrpObj obj;
			ISecureSecTentGrp[] recList = schema.getSecureBackingStore().getTableSecTentGrp().readDerivedByTenantIdx( null,
				TenantId );
			ISecureSecTentGrp rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecTentGrpTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentGrpObj realised = (ISecureSecTentGrpObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecTentGrpObj arr[] = new ISecureSecTentGrpObj[len];
		Iterator<ISecureSecTentGrpObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecTentGrpObj> arrayList = new ArrayList<ISecureSecTentGrpObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentGrpObj> cmp = new Comparator<ISecureSecTentGrpObj>() {
			@Override
			public int compare( ISecureSecTentGrpObj lhs, ISecureSecTentGrpObj rhs ) {
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
		List<ISecureSecTentGrpObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecTentGrpObj> readSecTentGrpByNameIdx( String Name )
	{
		return( readSecTentGrpByNameIdx( Name,
			false ) );
	}

	@Override
	public List<ISecureSecTentGrpObj> readSecTentGrpByNameIdx( String Name,
		boolean forceRead )
	{
		final String S_ProcName = "readSecTentGrpByNameIdx";
		ISecureSecTentGrpByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByNameIdxKey();
		key.setRequiredName( Name );
		Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj> dict;
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecTentGrpByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > >();
		}
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			dict = indexByNameIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj>();
			ISecureSecTentGrpObj obj;
			ISecureSecTentGrp[] recList = schema.getSecureBackingStore().getTableSecTentGrp().readDerivedByNameIdx( null,
				Name );
			ISecureSecTentGrp rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecTentGrpTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecTentGrpObj realised = (ISecureSecTentGrpObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNameIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecTentGrpObj arr[] = new ISecureSecTentGrpObj[len];
		Iterator<ISecureSecTentGrpObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecTentGrpObj> arrayList = new ArrayList<ISecureSecTentGrpObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecTentGrpObj> cmp = new Comparator<ISecureSecTentGrpObj>() {
			@Override
			public int compare( ISecureSecTentGrpObj lhs, ISecureSecTentGrpObj rhs ) {
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
		List<ISecureSecTentGrpObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecTentGrpObj readSecTentGrpByUNameIdx( IYCFKeyHash256 TenantId,
		String Name )
	{
		return( readSecTentGrpByUNameIdx( TenantId,
			Name,
			false ) );
	}

	@Override
	public ISecureSecTentGrpObj readSecTentGrpByUNameIdx( IYCFKeyHash256 TenantId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecTentGrpByUNameIdxKey,
				ISecureSecTentGrpObj >();
		}
		ISecureSecTentGrpByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ISecureSecTentGrpObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			ISecureSecTentGrp rec = schema.getSecureBackingStore().getTableSecTentGrp().readDerivedByUNameIdx( null,
				TenantId,
				Name );
			if( rec != null ) {
				obj = schema.getSecTentGrpTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecTentGrpObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecTentGrpObj readCachedSecTentGrpByIdIdx( IYCFKeyHash256 SecTentGrpId )
	{
		ISecureSecTentGrpObj obj = null;
		obj = readCachedSecTentGrp( SecTentGrpId );
		return( obj );
	}

	@Override
	public List<ISecureSecTentGrpObj> readCachedSecTentGrpByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedSecTentGrpByTenantIdx";
		ISecureSecTentGrpByTenantIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<ISecureSecTentGrpObj> arrayList = new ArrayList<ISecureSecTentGrpObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				ISecureSecTentGrpObj arr[] = new ISecureSecTentGrpObj[len];
				Iterator<ISecureSecTentGrpObj> valIter = dict.values().iterator();
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
			ISecureSecTentGrpObj obj;
			Iterator<ISecureSecTentGrpObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecTentGrpObj> cmp = new Comparator<ISecureSecTentGrpObj>() {
			@Override
			public int compare( ISecureSecTentGrpObj lhs, ISecureSecTentGrpObj rhs ) {
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
	public List<ISecureSecTentGrpObj> readCachedSecTentGrpByNameIdx( String Name )
	{
		final String S_ProcName = "readCachedSecTentGrpByNameIdx";
		ISecureSecTentGrpByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByNameIdxKey();
		key.setRequiredName( Name );
		ArrayList<ISecureSecTentGrpObj> arrayList = new ArrayList<ISecureSecTentGrpObj>();
		if( indexByNameIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj> dict;
			if( indexByNameIdx.containsKey( key ) ) {
				dict = indexByNameIdx.get( key );
				int len = dict.size();
				ISecureSecTentGrpObj arr[] = new ISecureSecTentGrpObj[len];
				Iterator<ISecureSecTentGrpObj> valIter = dict.values().iterator();
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
			ISecureSecTentGrpObj obj;
			Iterator<ISecureSecTentGrpObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecTentGrpObj> cmp = new Comparator<ISecureSecTentGrpObj>() {
			@Override
			public int compare( ISecureSecTentGrpObj lhs, ISecureSecTentGrpObj rhs ) {
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
	public ISecureSecTentGrpObj readCachedSecTentGrpByUNameIdx( IYCFKeyHash256 TenantId,
		String Name )
	{
		ISecureSecTentGrpObj obj = null;
		ISecureSecTentGrpByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<ISecureSecTentGrpObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecTentGrpObj> valIter = members.values().iterator();
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
	public void deepDisposeSecTentGrpByIdIdx( IYCFKeyHash256 SecTentGrpId )
	{
		ISecureSecTentGrpObj obj = readCachedSecTentGrpByIdIdx( SecTentGrpId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecTentGrpByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeSecTentGrpByTenantIdx";
		ISecureSecTentGrpObj obj;
		List<ISecureSecTentGrpObj> arrayList = readCachedSecTentGrpByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<ISecureSecTentGrpObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecTentGrpByNameIdx( String Name )
	{
		final String S_ProcName = "deepDisposeSecTentGrpByNameIdx";
		ISecureSecTentGrpObj obj;
		List<ISecureSecTentGrpObj> arrayList = readCachedSecTentGrpByNameIdx( Name );
		if( arrayList != null )  {
			Iterator<ISecureSecTentGrpObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecTentGrpByUNameIdx( IYCFKeyHash256 TenantId,
		String Name )
	{
		ISecureSecTentGrpObj obj = readCachedSecTentGrpByUNameIdx( TenantId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecTentGrpObj updateSecTentGrp( ISecureSecTentGrpObj Obj ) {
		ISecureSecTentGrpObj obj = Obj;
		schema.getSecureBackingStore().getTableSecTentGrp().updateSecTentGrp( null,
			Obj.getSecTentGrpRec() );
		obj = (ISecureSecTentGrpObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecTentGrp( ISecureSecTentGrpObj Obj ) {
		ISecureSecTentGrpObj obj = Obj;
		schema.getSecureBackingStore().getTableSecTentGrp().deleteSecTentGrp( null,
			obj.getSecTentGrpRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecTentGrpByIdIdx( IYCFKeyHash256 SecTentGrpId )
	{
		ISecureSecTentGrpObj obj = readSecTentGrp(SecTentGrpId);
		if( obj != null ) {
			ISecureSecTentGrpEditObj editObj = (ISecureSecTentGrpEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecTentGrpEditObj)obj.beginEdit();
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
		deepDisposeSecTentGrpByIdIdx( SecTentGrpId );
	}

	@Override
	public void deleteSecTentGrpByTenantIdx( IYCFKeyHash256 TenantId )
	{
		ISecureSecTentGrpByTenantIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< ISecureSecTentGrpByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj> dict = indexByTenantIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentGrp().deleteSecTentGrpByTenantIdx( null,
				TenantId );
			Iterator<ISecureSecTentGrpObj> iter = dict.values().iterator();
			ISecureSecTentGrpObj obj;
			List<ISecureSecTentGrpObj> toForget = new LinkedList<ISecureSecTentGrpObj>();
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
			schema.getSecureBackingStore().getTableSecTentGrp().deleteSecTentGrpByTenantIdx( null,
				TenantId );
		}
		deepDisposeSecTentGrpByTenantIdx( TenantId );
	}

	@Override
	public void deleteSecTentGrpByNameIdx( String Name )
	{
		ISecureSecTentGrpByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecTentGrpByNameIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecTentGrpObj > >();
		}
		if( indexByNameIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecTentGrpObj> dict = indexByNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentGrp().deleteSecTentGrpByNameIdx( null,
				Name );
			Iterator<ISecureSecTentGrpObj> iter = dict.values().iterator();
			ISecureSecTentGrpObj obj;
			List<ISecureSecTentGrpObj> toForget = new LinkedList<ISecureSecTentGrpObj>();
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
			schema.getSecureBackingStore().getTableSecTentGrp().deleteSecTentGrpByNameIdx( null,
				Name );
		}
		deepDisposeSecTentGrpByNameIdx( Name );
	}

	@Override
	public void deleteSecTentGrpByUNameIdx( IYCFKeyHash256 TenantId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecTentGrpByUNameIdxKey,
				ISecureSecTentGrpObj >();
		}
		ISecureSecTentGrpByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newByUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredName( Name );
		ISecureSecTentGrpObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecTentGrp().deleteSecTentGrpByUNameIdx( null,
				TenantId,
				Name );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecTentGrp().deleteSecTentGrpByUNameIdx( null,
				TenantId,
				Name );
		}
		deepDisposeSecTentGrpByUNameIdx( TenantId,
				Name );
	}
}