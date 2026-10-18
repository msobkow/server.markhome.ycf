// Description: Java 25 Table Object implementation for SecSysGrp.

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

public class BusModelSecSysGrpTableObj
	implements IBusModelSecSysGrpTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj> allSecSysGrp;
	private Map< ISecureSecSysGrpByUNameIdxKey,
		ISecureSecSysGrpObj > indexByUNameIdx;
	private Map< ISecureSecSysGrpBySecLevelIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj > > indexBySecLevelIdx;
	public static String TABLE_NAME = "SecSysGrp";
	public static String TABLE_DBNAME = "secsysgrp";

	public BusModelSecSysGrpTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj>();
		allSecSysGrp = null;
		indexByUNameIdx = null;
		indexBySecLevelIdx = null;
	}

	public BusModelSecSysGrpTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj>();
		allSecSysGrp = null;
		indexByUNameIdx = null;
		indexBySecLevelIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecSysGrpTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecSysGrpTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecSysGrpTableObj.getRuntimeClassCode() );
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
		allSecSysGrp = null;
		indexByUNameIdx = null;
		indexBySecLevelIdx = null;
		List<ISecureSecSysGrpObj> toForget = new LinkedList<ISecureSecSysGrpObj>();
		ISecureSecSysGrpObj cur = null;
		Iterator<ISecureSecSysGrpObj> iter = members.values().iterator();
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
	 *	BusModelSecSysGrpObj.
	 */
	@Override
	public ISecureSecSysGrpObj newInstance() {
		ISecureSecSysGrpObj inst = new BusModelSecSysGrpObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecSysGrpObj.
	 */
	@Override
	public ISecureSecSysGrpEditObj newEditInstance( ISecureSecSysGrpObj orig ) {
		ISecureSecSysGrpEditObj edit = new BusModelSecSysGrpEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecSysGrpObj constructByClassCode( int backingClassCode ) {
		ISecureSecSysGrpObj obj = null;
		if( backingClassCode == ISecureSecSysGrp.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecSysGrpTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecSysGrpObj realiseSecSysGrp( ISecureSecSysGrpObj Obj ) {
		ISecureSecSysGrpObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecSysGrpObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecSysGrpObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				ISecureSecSysGrpByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexBySecLevelIdx != null ) {
				ISecureSecSysGrpBySecLevelIdxKey keySecLevelIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
				keySecLevelIdx.setRequiredSecLevel( keepObj.getRequiredSecLevel() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj > mapSecLevelIdx = indexBySecLevelIdx.get( keySecLevelIdx );
				if( mapSecLevelIdx != null ) {
					mapSecLevelIdx.remove( keepObj.getPKey() );
					if( mapSecLevelIdx.size() <= 0 ) {
						indexBySecLevelIdx.remove( keySecLevelIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				ISecureSecSysGrpByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexBySecLevelIdx != null ) {
				ISecureSecSysGrpBySecLevelIdxKey keySecLevelIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
				keySecLevelIdx.setRequiredSecLevel( keepObj.getRequiredSecLevel() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj > mapSecLevelIdx = indexBySecLevelIdx.get( keySecLevelIdx );
				if( mapSecLevelIdx != null ) {
					mapSecLevelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecSysGrp != null ) {
				allSecSysGrp.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecSysGrp != null ) {
				allSecSysGrp.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				ISecureSecSysGrpByUNameIdxKey keyUNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexBySecLevelIdx != null ) {
				ISecureSecSysGrpBySecLevelIdxKey keySecLevelIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
				keySecLevelIdx.setRequiredSecLevel( keepObj.getRequiredSecLevel() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj > mapSecLevelIdx = indexBySecLevelIdx.get( keySecLevelIdx );
				if( mapSecLevelIdx != null ) {
					mapSecLevelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecSysGrpObj createSecSysGrp( ISecureSecSysGrpObj Obj ) {
		ISecureSecSysGrpObj obj = Obj;
		ISecureSecSysGrp rec = obj.getSecSysGrpRec();
		schema.getSecureBackingStore().getTableSecSysGrp().createSecSysGrp(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecSysGrpObj readSecSysGrp( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecSysGrp( pkey, false ) );
	}

	@Override
	public ISecureSecSysGrpObj readSecSysGrp( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecSysGrpObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecSysGrp readRec = schema.getSecureBackingStore().getTableSecSysGrp().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecSysGrpTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecSysGrpObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecSysGrpObj readCachedSecSysGrp( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecSysGrpObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecSysGrp( ISecureSecSysGrpObj obj )
	{
		final String S_ProcName = "BusModelSecSysGrpTableObj.reallyDeepDisposeSecSysGrp() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecSysGrpObj existing = readCachedSecSysGrp( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecSysGrpByUNameIdxKey keyUNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		ISecureSecSysGrpBySecLevelIdxKey keySecLevelIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
		keySecLevelIdx.setRequiredSecLevel( existing.getRequiredSecLevel() );


					schema.getSecSysGrpMembTableObj().deepDisposeSecSysGrpMembBySysGrpIdx( existing.getRequiredSecSysGrpId() );
					schema.getSecSysGrpIncTableObj().deepDisposeSecSysGrpIncBySysGrpIdx( existing.getRequiredSecSysGrpId() );

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexBySecLevelIdx != null ) {
			if( indexBySecLevelIdx.containsKey( keySecLevelIdx ) ) {
				indexBySecLevelIdx.get( keySecLevelIdx ).remove( pkey );
				if( indexBySecLevelIdx.get( keySecLevelIdx ).size() <= 0 ) {
					indexBySecLevelIdx.remove( keySecLevelIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeSecSysGrp( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecSysGrpObj obj = readCachedSecSysGrp( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecSysGrpObj lockSecSysGrp( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecSysGrpObj locked = null;
		ISecureSecSysGrp lockRec = schema.getSecureBackingStore().getTableSecSysGrp().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecSysGrpTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecSysGrpObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecSysGrp", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecSysGrpObj> readAllSecSysGrp() {
		return( readAllSecSysGrp( false ) );
	}

	@Override
	public List<ISecureSecSysGrpObj> readAllSecSysGrp( boolean forceRead ) {
		final String S_ProcName = "readAllSecSysGrp";
		if( ( allSecSysGrp == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecSysGrpObj>();
			allSecSysGrp = map;
			ISecureSecSysGrp[] recList = schema.getSecureBackingStore().getTableSecSysGrp().readAllDerived( null );
			ISecureSecSysGrp rec;
			ISecureSecSysGrpObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysGrpObj realised = (ISecureSecSysGrpObj)obj.realise();
			}
		}
		int len = allSecSysGrp.size();
		ISecureSecSysGrpObj arr[] = new ISecureSecSysGrpObj[len];
		Iterator<ISecureSecSysGrpObj> valIter = allSecSysGrp.values().iterator();
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
		ArrayList<ISecureSecSysGrpObj> arrayList = new ArrayList<ISecureSecSysGrpObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysGrpObj> cmp = new Comparator<ISecureSecSysGrpObj>() {
			@Override
			public int compare( ISecureSecSysGrpObj lhs, ISecureSecSysGrpObj rhs ) {
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
		List<ISecureSecSysGrpObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSysGrpObj> readCachedAllSecSysGrp() {
		final String S_ProcName = "readCachedAllSecSysGrp";
		ArrayList<ISecureSecSysGrpObj> arrayList = new ArrayList<ISecureSecSysGrpObj>();
		if( allSecSysGrp != null ) {
			int len = allSecSysGrp.size();
			ISecureSecSysGrpObj arr[] = new ISecureSecSysGrpObj[len];
			Iterator<ISecureSecSysGrpObj> valIter = allSecSysGrp.values().iterator();
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
		Comparator<ISecureSecSysGrpObj> cmp = new Comparator<ISecureSecSysGrpObj>() {
			public int compare( ISecureSecSysGrpObj lhs, ISecureSecSysGrpObj rhs ) {
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
	public ISecureSecSysGrpObj readSecSysGrpByIdIdx( IYCFKeyHash256 SecSysGrpId )
	{
		return( readSecSysGrpByIdIdx( SecSysGrpId,
			false ) );
	}

	@Override
	public ISecureSecSysGrpObj readSecSysGrpByIdIdx( IYCFKeyHash256 SecSysGrpId, boolean forceRead )
	{
		ISecureSecSysGrpObj obj = readSecSysGrp( SecSysGrpId, forceRead );
		return( obj );
	}

	@Override
	public ISecureSecSysGrpObj readSecSysGrpByUNameIdx( String Name )
	{
		return( readSecSysGrpByUNameIdx( Name,
			false ) );
	}

	@Override
	public ISecureSecSysGrpObj readSecSysGrpByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecSysGrpByUNameIdxKey,
				ISecureSecSysGrpObj >();
		}
		ISecureSecSysGrpByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newByUNameIdxKey();
		key.setRequiredName( Name );
		ISecureSecSysGrpObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			ISecureSecSysGrp rec = schema.getSecureBackingStore().getTableSecSysGrp().readDerivedByUNameIdx( null,
				Name );
			if( rec != null ) {
				obj = schema.getSecSysGrpTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecSysGrpObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<ISecureSecSysGrpObj> readSecSysGrpBySecLevelIdx( ISecurePubSchema.SecLevelEnum SecLevel )
	{
		return( readSecSysGrpBySecLevelIdx( SecLevel,
			false ) );
	}

	@Override
	public List<ISecureSecSysGrpObj> readSecSysGrpBySecLevelIdx( ISecurePubSchema.SecLevelEnum SecLevel,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSysGrpBySecLevelIdx";
		ISecureSecSysGrpBySecLevelIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
		key.setRequiredSecLevel( SecLevel );
		Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj> dict;
		if( indexBySecLevelIdx == null ) {
			indexBySecLevelIdx = new HashMap< ISecureSecSysGrpBySecLevelIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecSysGrpObj > >();
		}
		if( ( ! forceRead ) && indexBySecLevelIdx.containsKey( key ) ) {
			dict = indexBySecLevelIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj>();
			ISecureSecSysGrpObj obj;
			ISecureSecSysGrp[] recList = schema.getSecureBackingStore().getTableSecSysGrp().readDerivedBySecLevelIdx( null,
				SecLevel );
			ISecureSecSysGrp rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSysGrpTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysGrpObj realised = (ISecureSecSysGrpObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySecLevelIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSysGrpObj arr[] = new ISecureSecSysGrpObj[len];
		Iterator<ISecureSecSysGrpObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSysGrpObj> arrayList = new ArrayList<ISecureSecSysGrpObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysGrpObj> cmp = new Comparator<ISecureSecSysGrpObj>() {
			@Override
			public int compare( ISecureSecSysGrpObj lhs, ISecureSecSysGrpObj rhs ) {
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
		List<ISecureSecSysGrpObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecSysGrpObj readCachedSecSysGrpByIdIdx( IYCFKeyHash256 SecSysGrpId )
	{
		ISecureSecSysGrpObj obj = null;
		obj = readCachedSecSysGrp( SecSysGrpId );
		return( obj );
	}

	@Override
	public ISecureSecSysGrpObj readCachedSecSysGrpByUNameIdx( String Name )
	{
		ISecureSecSysGrpObj obj = null;
		ISecureSecSysGrpByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newByUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<ISecureSecSysGrpObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecSysGrpObj> valIter = members.values().iterator();
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
	public List<ISecureSecSysGrpObj> readCachedSecSysGrpBySecLevelIdx( ISecurePubSchema.SecLevelEnum SecLevel )
	{
		final String S_ProcName = "readCachedSecSysGrpBySecLevelIdx";
		ISecureSecSysGrpBySecLevelIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
		key.setRequiredSecLevel( SecLevel );
		ArrayList<ISecureSecSysGrpObj> arrayList = new ArrayList<ISecureSecSysGrpObj>();
		if( indexBySecLevelIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj> dict;
			if( indexBySecLevelIdx.containsKey( key ) ) {
				dict = indexBySecLevelIdx.get( key );
				int len = dict.size();
				ISecureSecSysGrpObj arr[] = new ISecureSecSysGrpObj[len];
				Iterator<ISecureSecSysGrpObj> valIter = dict.values().iterator();
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
			ISecureSecSysGrpObj obj;
			Iterator<ISecureSecSysGrpObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSysGrpObj> cmp = new Comparator<ISecureSecSysGrpObj>() {
			@Override
			public int compare( ISecureSecSysGrpObj lhs, ISecureSecSysGrpObj rhs ) {
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
	public void deepDisposeSecSysGrpByIdIdx( IYCFKeyHash256 SecSysGrpId )
	{
		ISecureSecSysGrpObj obj = readCachedSecSysGrpByIdIdx( SecSysGrpId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecSysGrpByUNameIdx( String Name )
	{
		ISecureSecSysGrpObj obj = readCachedSecSysGrpByUNameIdx( Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecSysGrpBySecLevelIdx( ISecurePubSchema.SecLevelEnum SecLevel )
	{
		final String S_ProcName = "deepDisposeSecSysGrpBySecLevelIdx";
		ISecureSecSysGrpObj obj;
		List<ISecureSecSysGrpObj> arrayList = readCachedSecSysGrpBySecLevelIdx( SecLevel );
		if( arrayList != null )  {
			Iterator<ISecureSecSysGrpObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public ISecureSecSysGrpObj updateSecSysGrp( ISecureSecSysGrpObj Obj ) {
		ISecureSecSysGrpObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysGrp().updateSecSysGrp( null,
			Obj.getSecSysGrpRec() );
		obj = (ISecureSecSysGrpObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecSysGrp( ISecureSecSysGrpObj Obj ) {
		ISecureSecSysGrpObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysGrp().deleteSecSysGrp( null,
			obj.getSecSysGrpRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecSysGrpByIdIdx( IYCFKeyHash256 SecSysGrpId )
	{
		ISecureSecSysGrpObj obj = readSecSysGrp(SecSysGrpId);
		if( obj != null ) {
			ISecureSecSysGrpEditObj editObj = (ISecureSecSysGrpEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecSysGrpEditObj)obj.beginEdit();
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
		deepDisposeSecSysGrpByIdIdx( SecSysGrpId );
	}

	@Override
	public void deleteSecSysGrpByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< ISecureSecSysGrpByUNameIdxKey,
				ISecureSecSysGrpObj >();
		}
		ISecureSecSysGrpByUNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newByUNameIdxKey();
		key.setRequiredName( Name );
		ISecureSecSysGrpObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecSysGrp().deleteSecSysGrpByUNameIdx( null,
				Name );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecSysGrp().deleteSecSysGrpByUNameIdx( null,
				Name );
		}
		deepDisposeSecSysGrpByUNameIdx( Name );
	}

	@Override
	public void deleteSecSysGrpBySecLevelIdx( ISecurePubSchema.SecLevelEnum SecLevel )
	{
		ISecureSecSysGrpBySecLevelIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newBySecLevelIdxKey();
		key.setRequiredSecLevel( SecLevel );
		if( indexBySecLevelIdx == null ) {
			indexBySecLevelIdx = new HashMap< ISecureSecSysGrpBySecLevelIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecSysGrpObj > >();
		}
		if( indexBySecLevelIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSysGrpObj> dict = indexBySecLevelIdx.get( key );
			schema.getSecureBackingStore().getTableSecSysGrp().deleteSecSysGrpBySecLevelIdx( null,
				SecLevel );
			Iterator<ISecureSecSysGrpObj> iter = dict.values().iterator();
			ISecureSecSysGrpObj obj;
			List<ISecureSecSysGrpObj> toForget = new LinkedList<ISecureSecSysGrpObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySecLevelIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecSysGrp().deleteSecSysGrpBySecLevelIdx( null,
				SecLevel );
		}
		deepDisposeSecSysGrpBySecLevelIdx( SecLevel );
	}
}