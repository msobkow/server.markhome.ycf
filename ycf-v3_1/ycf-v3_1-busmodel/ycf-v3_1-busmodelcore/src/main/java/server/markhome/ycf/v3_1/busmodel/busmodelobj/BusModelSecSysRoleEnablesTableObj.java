// Description: Java 25 Table Object implementation for SecSysRoleEnables.

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

public class BusModelSecSysRoleEnablesTableObj
	implements IBusModelSecSysRoleEnablesTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> members;
	private Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> allSecSysRoleEnables;
	private Map< ISecureSecSysRoleEnablesBySysRoleIdxKey,
		Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > > indexBySysRoleIdx;
	private Map< ISecureSecSysRoleEnablesByNameIdxKey,
		Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > > indexByNameIdx;
	public static String TABLE_NAME = "SecSysRoleEnables";
	public static String TABLE_DBNAME = "secsysroleenables";

	public BusModelSecSysRoleEnablesTableObj() {
		schema = null;
		members = new HashMap<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj>();
		allSecSysRoleEnables = null;
		indexBySysRoleIdx = null;
		indexByNameIdx = null;
	}

	public BusModelSecSysRoleEnablesTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj>();
		allSecSysRoleEnables = null;
		indexBySysRoleIdx = null;
		indexByNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecSysRoleEnablesTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecSysRoleEnablesTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecSysRoleEnablesTableObj.getRuntimeClassCode() );
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
		allSecSysRoleEnables = null;
		indexBySysRoleIdx = null;
		indexByNameIdx = null;
		List<ISecureSecSysRoleEnablesObj> toForget = new LinkedList<ISecureSecSysRoleEnablesObj>();
		ISecureSecSysRoleEnablesObj cur = null;
		Iterator<ISecureSecSysRoleEnablesObj> iter = members.values().iterator();
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
	 *	BusModelSecSysRoleEnablesObj.
	 */
	@Override
	public ISecureSecSysRoleEnablesObj newInstance() {
		ISecureSecSysRoleEnablesObj inst = new BusModelSecSysRoleEnablesObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecSysRoleEnablesObj.
	 */
	@Override
	public ISecureSecSysRoleEnablesEditObj newEditInstance( ISecureSecSysRoleEnablesObj orig ) {
		ISecureSecSysRoleEnablesEditObj edit = new BusModelSecSysRoleEnablesEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecSysRoleEnablesObj constructByClassCode( int backingClassCode ) {
		ISecureSecSysRoleEnablesObj obj = null;
		if( backingClassCode == ISecureSecSysRoleEnables.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecSysRoleEnablesTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecSysRoleEnablesObj realiseSecSysRoleEnables( ISecureSecSysRoleEnablesObj Obj ) {
		ISecureSecSysRoleEnablesObj obj = Obj;
		ISecureSecSysRoleEnablesPKey pkey = obj.getPKey();
		ISecureSecSysRoleEnablesObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecSysRoleEnablesObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexBySysRoleIdx != null ) {
				ISecureSecSysRoleEnablesBySysRoleIdxKey keySysRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
				keySysRoleIdx.setRequiredSecSysRoleId( keepObj.getRequiredSecSysRoleId() );
				Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > mapSysRoleIdx = indexBySysRoleIdx.get( keySysRoleIdx );
				if( mapSysRoleIdx != null ) {
					mapSysRoleIdx.remove( keepObj.getPKey() );
					if( mapSysRoleIdx.size() <= 0 ) {
						indexBySysRoleIdx.remove( keySysRoleIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecSysRoleEnablesByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
				keyNameIdx.setRequiredEnableName( keepObj.getRequiredEnableName() );
				Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.remove( keepObj.getPKey() );
					if( mapNameIdx.size() <= 0 ) {
						indexByNameIdx.remove( keyNameIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexBySysRoleIdx != null ) {
				ISecureSecSysRoleEnablesBySysRoleIdxKey keySysRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
				keySysRoleIdx.setRequiredSecSysRoleId( keepObj.getRequiredSecSysRoleId() );
				Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > mapSysRoleIdx = indexBySysRoleIdx.get( keySysRoleIdx );
				if( mapSysRoleIdx != null ) {
					mapSysRoleIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecSysRoleEnablesByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
				keyNameIdx.setRequiredEnableName( keepObj.getRequiredEnableName() );
				Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecSysRoleEnables != null ) {
				allSecSysRoleEnables.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecSysRoleEnables != null ) {
				allSecSysRoleEnables.put( keepObj.getPKey(), keepObj );
			}

			if( indexBySysRoleIdx != null ) {
				ISecureSecSysRoleEnablesBySysRoleIdxKey keySysRoleIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
				keySysRoleIdx.setRequiredSecSysRoleId( keepObj.getRequiredSecSysRoleId() );
				Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > mapSysRoleIdx = indexBySysRoleIdx.get( keySysRoleIdx );
				if( mapSysRoleIdx != null ) {
					mapSysRoleIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				ISecureSecSysRoleEnablesByNameIdxKey keyNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
				keyNameIdx.setRequiredEnableName( keepObj.getRequiredEnableName() );
				Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > mapNameIdx = indexByNameIdx.get( keyNameIdx );
				if( mapNameIdx != null ) {
					mapNameIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecSysRoleEnablesObj createSecSysRoleEnables( ISecureSecSysRoleEnablesObj Obj ) {
		ISecureSecSysRoleEnablesObj obj = Obj;
		ISecureSecSysRoleEnables rec = obj.getSecSysRoleEnablesRec();
		schema.getSecureBackingStore().getTableSecSysRoleEnables().createSecSysRoleEnables(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecSysRoleEnablesObj readSecSysRoleEnables( ISecureSecSysRoleEnablesPKey pkey ) {
		return( readSecSysRoleEnables( pkey, false ) );
	}

	@Override
	public ISecureSecSysRoleEnablesObj readSecSysRoleEnables( ISecureSecSysRoleEnablesPKey pkey, boolean forceRead ) {
		ISecureSecSysRoleEnablesObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecSysRoleEnables readRec = schema.getSecureBackingStore().getTableSecSysRoleEnables().readDerivedByIdIdx( null,
						pkey.getRequiredSecSysRoleId(),
						pkey.getRequiredEnableName() );
			if( readRec != null ) {
				obj = schema.getSecSysRoleEnablesTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecSysRoleEnablesObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecSysRoleEnablesObj readSecSysRoleEnables( IYCFKeyHash256 SecSysRoleId,
		String EnableName ) {
		return( readSecSysRoleEnables( SecSysRoleId,
			EnableName, false ) );
	}

	@Override
	public ISecureSecSysRoleEnablesObj readSecSysRoleEnables( IYCFKeyHash256 SecSysRoleId,
		String EnableName, boolean forceRead ) {
		ISecureSecSysRoleEnablesObj obj = null;
		ISecureSecSysRoleEnables readRec = schema.getSecureBackingStore().getTableSecSysRoleEnables().readDerivedByIdIdx( null,
			SecSysRoleId,
			EnableName );
		if( readRec != null ) {
				obj = schema.getSecSysRoleEnablesTableObj().newInstance();
			obj.setPKey( readRec.getPKey() );
			obj.setRec( readRec );
			obj = (ISecureSecSysRoleEnablesObj)obj.realise();
		}
		return( obj );
	}

	@Override
	public ISecureSecSysRoleEnablesObj readCachedSecSysRoleEnables( ISecureSecSysRoleEnablesPKey pkey ) {
		ISecureSecSysRoleEnablesObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecSysRoleEnables( ISecureSecSysRoleEnablesObj obj )
	{
		final String S_ProcName = "BusModelSecSysRoleEnablesTableObj.reallyDeepDisposeSecSysRoleEnables() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		ISecureSecSysRoleEnablesPKey pkey = obj.getPKey();
		ISecureSecSysRoleEnablesObj existing = readCachedSecSysRoleEnables( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecSysRoleEnablesBySysRoleIdxKey keySysRoleIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		keySysRoleIdx.setRequiredSecSysRoleId( existing.getRequiredSecSysRoleId() );

		ISecureSecSysRoleEnablesByNameIdxKey keyNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		keyNameIdx.setRequiredEnableName( existing.getRequiredEnableName() );



		if( indexBySysRoleIdx != null ) {
			if( indexBySysRoleIdx.containsKey( keySysRoleIdx ) ) {
				indexBySysRoleIdx.get( keySysRoleIdx ).remove( pkey );
				if( indexBySysRoleIdx.get( keySysRoleIdx ).size() <= 0 ) {
					indexBySysRoleIdx.remove( keySysRoleIdx );
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


	}
	@Override
	public void deepDisposeSecSysRoleEnables( ISecureSecSysRoleEnablesPKey pkey ) {
		ISecureSecSysRoleEnablesObj obj = readCachedSecSysRoleEnables( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecSysRoleEnablesObj lockSecSysRoleEnables( ISecureSecSysRoleEnablesPKey pkey ) {
		ISecureSecSysRoleEnablesObj locked = null;
		ISecureSecSysRoleEnables lockRec = schema.getSecureBackingStore().getTableSecSysRoleEnables().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecSysRoleEnablesTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecSysRoleEnablesObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecSysRoleEnables", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> readAllSecSysRoleEnables() {
		return( readAllSecSysRoleEnables( false ) );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> readAllSecSysRoleEnables( boolean forceRead ) {
		final String S_ProcName = "readAllSecSysRoleEnables";
		if( ( allSecSysRoleEnables == null ) || forceRead ) {
			Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> map = new HashMap<ISecureSecSysRoleEnablesPKey,ISecureSecSysRoleEnablesObj>();
			allSecSysRoleEnables = map;
			ISecureSecSysRoleEnables[] recList = schema.getSecureBackingStore().getTableSecSysRoleEnables().readAllDerived( null );
			ISecureSecSysRoleEnables rec;
			ISecureSecSysRoleEnablesObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysRoleEnablesObj realised = (ISecureSecSysRoleEnablesObj)obj.realise();
			}
		}
		int len = allSecSysRoleEnables.size();
		ISecureSecSysRoleEnablesObj arr[] = new ISecureSecSysRoleEnablesObj[len];
		Iterator<ISecureSecSysRoleEnablesObj> valIter = allSecSysRoleEnables.values().iterator();
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
		ArrayList<ISecureSecSysRoleEnablesObj> arrayList = new ArrayList<ISecureSecSysRoleEnablesObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysRoleEnablesObj> cmp = new Comparator<ISecureSecSysRoleEnablesObj>() {
			@Override
			public int compare( ISecureSecSysRoleEnablesObj lhs, ISecureSecSysRoleEnablesObj rhs ) {
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
					ISecureSecSysRoleEnablesPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleEnablesPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecSysRoleEnablesObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> readCachedAllSecSysRoleEnables() {
		final String S_ProcName = "readCachedAllSecSysRoleEnables";
		ArrayList<ISecureSecSysRoleEnablesObj> arrayList = new ArrayList<ISecureSecSysRoleEnablesObj>();
		if( allSecSysRoleEnables != null ) {
			int len = allSecSysRoleEnables.size();
			ISecureSecSysRoleEnablesObj arr[] = new ISecureSecSysRoleEnablesObj[len];
			Iterator<ISecureSecSysRoleEnablesObj> valIter = allSecSysRoleEnables.values().iterator();
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
		Comparator<ISecureSecSysRoleEnablesObj> cmp = new Comparator<ISecureSecSysRoleEnablesObj>() {
			public int compare( ISecureSecSysRoleEnablesObj lhs, ISecureSecSysRoleEnablesObj rhs ) {
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
					ISecureSecSysRoleEnablesPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleEnablesPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	/**
	 *	Return a sorted map of a page of the SecSysRoleEnables-derived instances in the database.
	 *
	 *	@return	List of ISecureSecSysRoleEnablesObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecSysRoleEnablesObj> pageAllSecSysRoleEnables(IYCFKeyHash256 priorSecSysRoleId,
		String priorEnableName )
	{
		final String S_ProcName = "pageAllSecSysRoleEnables";
		Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> map = new HashMap<ISecureSecSysRoleEnablesPKey,ISecureSecSysRoleEnablesObj>();
		ISecureSecSysRoleEnables[] recList = schema.getSecureBackingStore().getTableSecSysRoleEnables().pageAllRec( null,
			priorSecSysRoleId,
			priorEnableName );
		ISecureSecSysRoleEnables rec;
		ISecureSecSysRoleEnablesObj obj;
		ISecureSecSysRoleEnablesObj realised;
		ArrayList<ISecureSecSysRoleEnablesObj> arrayList = new ArrayList<ISecureSecSysRoleEnablesObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecSysRoleEnablesObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecSysRoleEnablesObj readSecSysRoleEnablesByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String EnableName )
	{
		return( readSecSysRoleEnablesByIdIdx( SecSysRoleId,
			EnableName,
			false ) );
	}

	@Override
	public ISecureSecSysRoleEnablesObj readSecSysRoleEnablesByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String EnableName, boolean forceRead )
	{
		ISecureSecSysRoleEnablesPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newPKey();
		pkey.setRequiredSecSysRoleId( SecSysRoleId );
		pkey.setRequiredEnableName( EnableName );
		ISecureSecSysRoleEnablesObj obj = readSecSysRoleEnables( pkey, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> readSecSysRoleEnablesBySysRoleIdx( IYCFKeyHash256 SecSysRoleId )
	{
		return( readSecSysRoleEnablesBySysRoleIdx( SecSysRoleId,
			false ) );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> readSecSysRoleEnablesBySysRoleIdx( IYCFKeyHash256 SecSysRoleId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSysRoleEnablesBySysRoleIdx";
		ISecureSecSysRoleEnablesBySysRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( SecSysRoleId );
		Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> dict;
		if( indexBySysRoleIdx == null ) {
			indexBySysRoleIdx = new HashMap< ISecureSecSysRoleEnablesBySysRoleIdxKey,
				Map< ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > >();
		}
		if( ( ! forceRead ) && indexBySysRoleIdx.containsKey( key ) ) {
			dict = indexBySysRoleIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj>();
			ISecureSecSysRoleEnablesObj obj;
			ISecureSecSysRoleEnables[] recList = schema.getSecureBackingStore().getTableSecSysRoleEnables().readDerivedBySysRoleIdx( null,
				SecSysRoleId );
			ISecureSecSysRoleEnables rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSysRoleEnablesTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysRoleEnablesObj realised = (ISecureSecSysRoleEnablesObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySysRoleIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSysRoleEnablesObj arr[] = new ISecureSecSysRoleEnablesObj[len];
		Iterator<ISecureSecSysRoleEnablesObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSysRoleEnablesObj> arrayList = new ArrayList<ISecureSecSysRoleEnablesObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysRoleEnablesObj> cmp = new Comparator<ISecureSecSysRoleEnablesObj>() {
			@Override
			public int compare( ISecureSecSysRoleEnablesObj lhs, ISecureSecSysRoleEnablesObj rhs ) {
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
					ISecureSecSysRoleEnablesPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleEnablesPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecSysRoleEnablesObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> readSecSysRoleEnablesByNameIdx( String EnableName )
	{
		return( readSecSysRoleEnablesByNameIdx( EnableName,
			false ) );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> readSecSysRoleEnablesByNameIdx( String EnableName,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSysRoleEnablesByNameIdx";
		ISecureSecSysRoleEnablesByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		key.setRequiredEnableName( EnableName );
		Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> dict;
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecSysRoleEnablesByNameIdxKey,
				Map< ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > >();
		}
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			dict = indexByNameIdx.get( key );
		}
		else {
			dict = new HashMap<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj>();
			ISecureSecSysRoleEnablesObj obj;
			ISecureSecSysRoleEnables[] recList = schema.getSecureBackingStore().getTableSecSysRoleEnables().readDerivedByNameIdx( null,
				EnableName );
			ISecureSecSysRoleEnables rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSysRoleEnablesTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSysRoleEnablesObj realised = (ISecureSecSysRoleEnablesObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNameIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSysRoleEnablesObj arr[] = new ISecureSecSysRoleEnablesObj[len];
		Iterator<ISecureSecSysRoleEnablesObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSysRoleEnablesObj> arrayList = new ArrayList<ISecureSecSysRoleEnablesObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSysRoleEnablesObj> cmp = new Comparator<ISecureSecSysRoleEnablesObj>() {
			@Override
			public int compare( ISecureSecSysRoleEnablesObj lhs, ISecureSecSysRoleEnablesObj rhs ) {
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
					ISecureSecSysRoleEnablesPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleEnablesPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ISecureSecSysRoleEnablesObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecSysRoleEnablesObj readCachedSecSysRoleEnablesByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String EnableName )
	{
		ISecureSecSysRoleEnablesObj obj = null;
		ISecureSecSysRoleEnablesPKey pkey = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newPKey();
		pkey.setRequiredSecSysRoleId( SecSysRoleId );
		pkey.setRequiredEnableName( EnableName );
		pkey.setRequiredSecSysRoleId( SecSysRoleId );
		pkey.setRequiredEnableName( EnableName );
		obj = readCachedSecSysRoleEnables( pkey );
		return( obj );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> readCachedSecSysRoleEnablesBySysRoleIdx( IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "readCachedSecSysRoleEnablesBySysRoleIdx";
		ISecureSecSysRoleEnablesBySysRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( SecSysRoleId );
		ArrayList<ISecureSecSysRoleEnablesObj> arrayList = new ArrayList<ISecureSecSysRoleEnablesObj>();
		if( indexBySysRoleIdx != null ) {
			Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> dict;
			if( indexBySysRoleIdx.containsKey( key ) ) {
				dict = indexBySysRoleIdx.get( key );
				int len = dict.size();
				ISecureSecSysRoleEnablesObj arr[] = new ISecureSecSysRoleEnablesObj[len];
				Iterator<ISecureSecSysRoleEnablesObj> valIter = dict.values().iterator();
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
			ISecureSecSysRoleEnablesObj obj;
			Iterator<ISecureSecSysRoleEnablesObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSysRoleEnablesObj> cmp = new Comparator<ISecureSecSysRoleEnablesObj>() {
			@Override
			public int compare( ISecureSecSysRoleEnablesObj lhs, ISecureSecSysRoleEnablesObj rhs ) {
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
					ISecureSecSysRoleEnablesPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleEnablesPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> readCachedSecSysRoleEnablesByNameIdx( String EnableName )
	{
		final String S_ProcName = "readCachedSecSysRoleEnablesByNameIdx";
		ISecureSecSysRoleEnablesByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		key.setRequiredEnableName( EnableName );
		ArrayList<ISecureSecSysRoleEnablesObj> arrayList = new ArrayList<ISecureSecSysRoleEnablesObj>();
		if( indexByNameIdx != null ) {
			Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> dict;
			if( indexByNameIdx.containsKey( key ) ) {
				dict = indexByNameIdx.get( key );
				int len = dict.size();
				ISecureSecSysRoleEnablesObj arr[] = new ISecureSecSysRoleEnablesObj[len];
				Iterator<ISecureSecSysRoleEnablesObj> valIter = dict.values().iterator();
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
			ISecureSecSysRoleEnablesObj obj;
			Iterator<ISecureSecSysRoleEnablesObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSysRoleEnablesObj> cmp = new Comparator<ISecureSecSysRoleEnablesObj>() {
			@Override
			public int compare( ISecureSecSysRoleEnablesObj lhs, ISecureSecSysRoleEnablesObj rhs ) {
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
					ISecureSecSysRoleEnablesPKey lhsPKey = lhs.getPKey();
					ISecureSecSysRoleEnablesPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		return( arrayList );
	}

	@Override
	public void deepDisposeSecSysRoleEnablesByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String EnableName )
	{
		ISecureSecSysRoleEnablesObj obj = readCachedSecSysRoleEnablesByIdIdx( SecSysRoleId,
				EnableName );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecSysRoleEnablesBySysRoleIdx( IYCFKeyHash256 SecSysRoleId )
	{
		final String S_ProcName = "deepDisposeSecSysRoleEnablesBySysRoleIdx";
		ISecureSecSysRoleEnablesObj obj;
		List<ISecureSecSysRoleEnablesObj> arrayList = readCachedSecSysRoleEnablesBySysRoleIdx( SecSysRoleId );
		if( arrayList != null )  {
			Iterator<ISecureSecSysRoleEnablesObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecSysRoleEnablesByNameIdx( String EnableName )
	{
		final String S_ProcName = "deepDisposeSecSysRoleEnablesByNameIdx";
		ISecureSecSysRoleEnablesObj obj;
		List<ISecureSecSysRoleEnablesObj> arrayList = readCachedSecSysRoleEnablesByNameIdx( EnableName );
		if( arrayList != null )  {
			Iterator<ISecureSecSysRoleEnablesObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecSysRoleEnables-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SysRoleIdx key attributes.
	 *
	 *	@param	SecSysRoleId	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSysRoleEnables-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecSysRoleEnablesObj> pageSecSysRoleEnablesBySysRoleIdx( IYCFKeyHash256 SecSysRoleId,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorEnableName )
	{
		final String S_ProcName = "pageSecSysRoleEnablesBySysRoleIdx";
		ISecureSecSysRoleEnablesBySysRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( SecSysRoleId );
		List<ISecureSecSysRoleEnablesObj> retList = new LinkedList<ISecureSecSysRoleEnablesObj>();
		ISecureSecSysRoleEnablesObj obj;
		ISecureSecSysRoleEnables[] recList = schema.getSecureBackingStore().getTableSecSysRoleEnables().pageRecBySysRoleIdx( null,
				SecSysRoleId,
			priorSecSysRoleId,
			priorEnableName );
		ISecureSecSysRoleEnables rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecSysRoleEnablesTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecSysRoleEnablesObj realised = (ISecureSecSysRoleEnablesObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecSysRoleEnables-derived instances sorted by their primary keys,
	 *	as identified by the duplicate NameIdx key attributes.
	 *
	 *	@param	EnableName	The SecSysRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSysRoleEnables-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecSysRoleEnablesObj> pageSecSysRoleEnablesByNameIdx( String EnableName,
		IYCFKeyHash256 priorSecSysRoleId,
		String priorEnableName )
	{
		final String S_ProcName = "pageSecSysRoleEnablesByNameIdx";
		ISecureSecSysRoleEnablesByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		key.setRequiredEnableName( EnableName );
		List<ISecureSecSysRoleEnablesObj> retList = new LinkedList<ISecureSecSysRoleEnablesObj>();
		ISecureSecSysRoleEnablesObj obj;
		ISecureSecSysRoleEnables[] recList = schema.getSecureBackingStore().getTableSecSysRoleEnables().pageRecByNameIdx( null,
				EnableName,
			priorSecSysRoleId,
			priorEnableName );
		ISecureSecSysRoleEnables rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecSysRoleEnablesTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecSysRoleEnablesObj realised = (ISecureSecSysRoleEnablesObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecSysRoleEnablesObj updateSecSysRoleEnables( ISecureSecSysRoleEnablesObj Obj ) {
		ISecureSecSysRoleEnablesObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysRoleEnables().updateSecSysRoleEnables( null,
			Obj.getSecSysRoleEnablesRec() );
		obj = (ISecureSecSysRoleEnablesObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecSysRoleEnables( ISecureSecSysRoleEnablesObj Obj ) {
		ISecureSecSysRoleEnablesObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSysRoleEnables().deleteSecSysRoleEnables( null,
			obj.getSecSysRoleEnablesRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecSysRoleEnablesByIdIdx( IYCFKeyHash256 SecSysRoleId,
		String EnableName )
	{
		ISecureSecSysRoleEnablesObj obj = readSecSysRoleEnables(SecSysRoleId,
				EnableName);
		if( obj != null ) {
			ISecureSecSysRoleEnablesEditObj editObj = (ISecureSecSysRoleEnablesEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecSysRoleEnablesEditObj)obj.beginEdit();
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
		deepDisposeSecSysRoleEnablesByIdIdx( SecSysRoleId,
				EnableName );
	}

	@Override
	public void deleteSecSysRoleEnablesBySysRoleIdx( IYCFKeyHash256 SecSysRoleId )
	{
		ISecureSecSysRoleEnablesBySysRoleIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newBySysRoleIdxKey();
		key.setRequiredSecSysRoleId( SecSysRoleId );
		if( indexBySysRoleIdx == null ) {
			indexBySysRoleIdx = new HashMap< ISecureSecSysRoleEnablesBySysRoleIdxKey,
				Map< ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > >();
		}
		if( indexBySysRoleIdx.containsKey( key ) ) {
			Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> dict = indexBySysRoleIdx.get( key );
			schema.getSecureBackingStore().getTableSecSysRoleEnables().deleteSecSysRoleEnablesBySysRoleIdx( null,
				SecSysRoleId );
			Iterator<ISecureSecSysRoleEnablesObj> iter = dict.values().iterator();
			ISecureSecSysRoleEnablesObj obj;
			List<ISecureSecSysRoleEnablesObj> toForget = new LinkedList<ISecureSecSysRoleEnablesObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySysRoleIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecSysRoleEnables().deleteSecSysRoleEnablesBySysRoleIdx( null,
				SecSysRoleId );
		}
		deepDisposeSecSysRoleEnablesBySysRoleIdx( SecSysRoleId );
	}

	@Override
	public void deleteSecSysRoleEnablesByNameIdx( String EnableName )
	{
		ISecureSecSysRoleEnablesByNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newByNameIdxKey();
		key.setRequiredEnableName( EnableName );
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< ISecureSecSysRoleEnablesByNameIdxKey,
				Map< ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj > >();
		}
		if( indexByNameIdx.containsKey( key ) ) {
			Map<ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnablesObj> dict = indexByNameIdx.get( key );
			schema.getSecureBackingStore().getTableSecSysRoleEnables().deleteSecSysRoleEnablesByNameIdx( null,
				EnableName );
			Iterator<ISecureSecSysRoleEnablesObj> iter = dict.values().iterator();
			ISecureSecSysRoleEnablesObj obj;
			List<ISecureSecSysRoleEnablesObj> toForget = new LinkedList<ISecureSecSysRoleEnablesObj>();
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
			schema.getSecureBackingStore().getTableSecSysRoleEnables().deleteSecSysRoleEnablesByNameIdx( null,
				EnableName );
		}
		deepDisposeSecSysRoleEnablesByNameIdx( EnableName );
	}
}