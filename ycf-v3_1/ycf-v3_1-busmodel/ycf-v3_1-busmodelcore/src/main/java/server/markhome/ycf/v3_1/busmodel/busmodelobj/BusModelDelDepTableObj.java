// Description: Java 25 Table Object implementation for DelDep.

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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public class BusModelDelDepTableObj
	implements IBusModelDelDepTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelDelDep.CLASS_CODE;
	protected static final int backingClassCode = IBusModelDelDep.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> allDelDep;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > > indexByTenantIdx;
	private Map< IBusModelDelDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > > indexByDefSchemaIdx;
	private Map< IBusModelDelDepByDelDepIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > > indexByDelDepIdx;
	public static String TABLE_NAME = "DelDep";
	public static String TABLE_DBNAME = "del_dep";

	public BusModelDelDepTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelDepObj>();
		allDelDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
	}

	public BusModelDelDepTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelDepObj>();
		allDelDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelDelDepTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( backingClassCode );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( runtimeClassCode );
	}

	/**
	 *	Set the runtime class code for this table; this is done only during application initialization by the SchemaObj's <tt>initClassCodes()</tt> static method,
	 *	which will only set the class codes once and never again.  Once set, the class codes are immutable within the application.
	 *	Application programmers should never invoke this method, so it has package access only.
	 *
	 *	@param	argNewClassCode	The runtime class code to be used by clients and integrated application logic to identify this table of this schema.
	 */
	static void setRuntimeClassCode(int argNewClassCode ) {
		if (argNewClassCode <= 0) {
			throw new YCFArgumentUnderflowException(BusModelDelDepTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
		}
		runtimeClassCode = argNewClassCode;
	}

	@Override
	public IBusModelSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IBusModelSchemaObj value ) {
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
		return( IBusModelSchemaDefObj.class );
	}


	@Override
	public void minimizeMemory() {
		allDelDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		List<IBusModelDelDepObj> toForget = new LinkedList<IBusModelDelDepObj>();
		IBusModelDelDepObj cur = null;
		Iterator<IBusModelDelDepObj> iter = members.values().iterator();
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
	 *	BusModelDelDepObj.
	 */
	@Override
	public IBusModelDelDepObj newInstance() {
		IBusModelDelDepObj inst = new BusModelDelDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelDelDepObj.
	 */
	@Override
	public IBusModelDelDepEditObj newEditInstance( IBusModelDelDepObj orig ) {
		IBusModelDelDepEditObj edit = new BusModelDelDepEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelDelDepObj realiseDelDep( IBusModelDelDepObj Obj ) {
		IBusModelDelDepObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDelDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelDelDepObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.remove( keepObj.getPKey() );
					if( mapDelDepIdx.size() <= 0 ) {
						indexByDelDepIdx.remove( keyDelDepIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelDelDepObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allDelDep != null ) {
				allDelDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelDelDepObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelDep != null ) {
				allDelDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelDelDepObj createDelDep( IBusModelDelDepObj Obj ) {
		IBusModelDelDepObj obj = Obj;
		IBusModelDelDep rec = obj.getDelDepRec();
		schema.getBusModelBackingStore().getTableDelDep().createDelDep(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelDelDepObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelDelDepObj readDelDep( $implCommaIJavaOptAtomType$ pkey ) {
		return( readDelDep( pkey, false ) );
	}

	@Override
	public IBusModelDelDepObj readDelDep( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelDelDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelDelDep readRec = schema.getBusModelBackingStore().getTableDelDep().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelDelDepObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelDelDepObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelDelDepObj readCachedDelDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelDepObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeDelDep( IBusModelDelDepObj obj )
	{
		final String S_ProcName = "BusModelDelDepTableObj.reallyDeepDisposeDelDep() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDelDepObj existing = readCachedDelDep( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelDelDepByDelDepIdxKey keyDelDepIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		keyDelDepIdx.setRequiredRelationId( existing.getRequiredRelationId() );



		if( indexByDefSchemaIdx != null ) {
			if( indexByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
				indexByDefSchemaIdx.get( keyDefSchemaIdx ).remove( pkey );
				if( indexByDefSchemaIdx.get( keyDefSchemaIdx ).size() <= 0 ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}
		}

		if( indexByDelDepIdx != null ) {
			if( indexByDelDepIdx.containsKey( keyDelDepIdx ) ) {
				indexByDelDepIdx.get( keyDelDepIdx ).remove( pkey );
				if( indexByDelDepIdx.get( keyDelDepIdx ).size() <= 0 ) {
					indexByDelDepIdx.remove( keyDelDepIdx );
				}
			}
		}


		schema.getScopeTableObj().reallyDeepDisposeScope( obj );
	}
	@Override
	public void deepDisposeDelDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelDepObj obj = readCachedDelDep( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelDelDepObj lockDelDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelDepObj locked = null;
		IBusModelDelDep lockRec = schema.getBusModelBackingStore().getTableDelDep().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelDelDepObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelDelDepObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockDelDep", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelDelDepObj> readAllDelDep() {
		return( readAllDelDep( false ) );
	}

	@Override
	public List<IBusModelDelDepObj> readAllDelDep( boolean forceRead ) {
		final String S_ProcName = "readAllDelDep";
		if( ( allDelDep == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelDelDepObj>();
			allDelDep = map;
			IBusModelDelDep[] recList = schema.getBusModelBackingStore().getTableDelDep().readAllDerived( null );
			IBusModelDelDep rec;
			IBusModelDelDepObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelDepObj realised = (IBusModelDelDepObj)obj.realise();
			}
		}
		int len = allDelDep.size();
		IBusModelDelDepObj arr[] = new IBusModelDelDepObj[len];
		Iterator<IBusModelDelDepObj> valIter = allDelDep.values().iterator();
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
		ArrayList<IBusModelDelDepObj> arrayList = new ArrayList<IBusModelDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelDepObj> cmp = new Comparator<IBusModelDelDepObj>() {
			@Override
			public int compare( IBusModelDelDepObj lhs, IBusModelDelDepObj rhs ) {
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
		List<IBusModelDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelDepObj> readCachedAllDelDep() {
		final String S_ProcName = "readCachedAllDelDep";
		ArrayList<IBusModelDelDepObj> arrayList = new ArrayList<IBusModelDelDepObj>();
		if( allDelDep != null ) {
			int len = allDelDep.size();
			IBusModelDelDepObj arr[] = new IBusModelDelDepObj[len];
			Iterator<IBusModelDelDepObj> valIter = allDelDep.values().iterator();
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
		Comparator<IBusModelDelDepObj> cmp = new Comparator<IBusModelDelDepObj>() {
			public int compare( IBusModelDelDepObj lhs, IBusModelDelDepObj rhs ) {
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
	public IBusModelDelDepObj readDelDepByIdIdx( IYCFKeyHash256 Id )
	{
		return( readDelDepByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelDelDepObj readDelDepByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelDelDepObj obj = readDelDep( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelDelDepObj> readDelDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readDelDepByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelDelDepObj> readDelDepByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelDepObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelDepObj realised = (IBusModelDelDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelDepObj arr[] = new IBusModelDelDepObj[len];
		Iterator<IBusModelDelDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelDepObj> arrayList = new ArrayList<IBusModelDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelDepObj> cmp = new Comparator<IBusModelDelDepObj>() {
			@Override
			public int compare( IBusModelDelDepObj lhs, IBusModelDelDepObj rhs ) {
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
		List<IBusModelDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelDepObj> readDelDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readDelDepByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelDelDepObj> readDelDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelDepByDefSchemaIdx";
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelDepObj>();
			IBusModelDelDepObj obj;
			IBusModelDelDep[] recList = schema.getBusModelBackingStore().getTableDelDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelDelDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelDepObj realised = (IBusModelDelDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelDepObj arr[] = new IBusModelDelDepObj[len];
		Iterator<IBusModelDelDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelDepObj> arrayList = new ArrayList<IBusModelDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelDepObj> cmp = new Comparator<IBusModelDelDepObj>() {
			@Override
			public int compare( IBusModelDelDepObj lhs, IBusModelDelDepObj rhs ) {
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
		List<IBusModelDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelDepObj> readDelDepByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		return( readDelDepByDelDepIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelDelDepObj> readDelDepByDelDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelDepByDelDepIdx";
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> dict;
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< IBusModelDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelDepObj > >();
		}
		if( ( ! forceRead ) && indexByDelDepIdx.containsKey( key ) ) {
			dict = indexByDelDepIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelDepObj>();
			IBusModelDelDepObj obj;
			IBusModelDelDep[] recList = schema.getBusModelBackingStore().getTableDelDep().readDerivedByDelDepIdx( null,
				RelationId );
			IBusModelDelDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelDepObj realised = (IBusModelDelDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelDepIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelDepObj arr[] = new IBusModelDelDepObj[len];
		Iterator<IBusModelDelDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelDepObj> arrayList = new ArrayList<IBusModelDelDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelDepObj> cmp = new Comparator<IBusModelDelDepObj>() {
			@Override
			public int compare( IBusModelDelDepObj lhs, IBusModelDelDepObj rhs ) {
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
		List<IBusModelDelDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelDelDepObj readCachedDelDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelDepObj obj = null;
		obj = readCachedDelDep( Id );
		return( obj );
	}

	@Override
	public List<IBusModelDelDepObj> readCachedDelDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedDelDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelDelDepObj> arrayList = new ArrayList<IBusModelDelDepObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelDelDepObj arr[] = new IBusModelDelDepObj[len];
				Iterator<IBusModelDelDepObj> valIter = dict.values().iterator();
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
			IBusModelDelDepObj obj;
			Iterator<IBusModelDelDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelDepObj> cmp = new Comparator<IBusModelDelDepObj>() {
			@Override
			public int compare( IBusModelDelDepObj lhs, IBusModelDelDepObj rhs ) {
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
	public List<IBusModelDelDepObj> readCachedDelDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedDelDepByDefSchemaIdx";
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelDelDepObj> arrayList = new ArrayList<IBusModelDelDepObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelDelDepObj arr[] = new IBusModelDelDepObj[len];
				Iterator<IBusModelDelDepObj> valIter = dict.values().iterator();
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
			IBusModelDelDepObj obj;
			Iterator<IBusModelDelDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelDepObj> cmp = new Comparator<IBusModelDelDepObj>() {
			@Override
			public int compare( IBusModelDelDepObj lhs, IBusModelDelDepObj rhs ) {
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
	public List<IBusModelDelDepObj> readCachedDelDepByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedDelDepByDelDepIdx";
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelDelDepObj> arrayList = new ArrayList<IBusModelDelDepObj>();
		if( indexByDelDepIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> dict;
			if( indexByDelDepIdx.containsKey( key ) ) {
				dict = indexByDelDepIdx.get( key );
				int len = dict.size();
				IBusModelDelDepObj arr[] = new IBusModelDelDepObj[len];
				Iterator<IBusModelDelDepObj> valIter = dict.values().iterator();
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
			IBusModelDelDepObj obj;
			Iterator<IBusModelDelDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelDepObj> cmp = new Comparator<IBusModelDelDepObj>() {
			@Override
			public int compare( IBusModelDelDepObj lhs, IBusModelDelDepObj rhs ) {
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
	public void deepDisposeDelDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelDepObj obj = readCachedDelDepByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeDelDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeDelDepByTenantIdx";
		IBusModelDelDepObj obj;
		List<IBusModelDelDepObj> arrayList = readCachedDelDepByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelDelDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeDelDepByDefSchemaIdx";
		IBusModelDelDepObj obj;
		List<IBusModelDelDepObj> arrayList = readCachedDelDepByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelDelDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelDepByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposeDelDepByDelDepIdx";
		IBusModelDelDepObj obj;
		List<IBusModelDelDepObj> arrayList = readCachedDelDepByDelDepIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelDelDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelDelDepObj updateDelDep( IBusModelDelDepObj Obj ) {
		IBusModelDelDepObj obj = Obj;
		schema.getBusModelBackingStore().getTableDelDep().updateDelDep( null,
			Obj.getDelDepRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getDelDepTableObj().getClassCode() ) {
			obj = (IBusModelDelDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteDelDep( IBusModelDelDepObj Obj ) {
		IBusModelDelDepObj obj = Obj;
		schema.getBusModelBackingStore().getTableDelDep().deleteDelDep( null,
			obj.getDelDepRec() );
		Obj.forget();
	}

	@Override
	public void deleteDelDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelDepObj obj = readDelDep(Id);
		if( obj != null ) {
			IBusModelDelDepEditObj editObj = (IBusModelDelDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelDelDepEditObj)obj.beginEdit();
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
		deepDisposeDelDepByIdIdx( Id );
	}

	@Override
	public void deleteDelDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableDelDep().deleteDelDepByTenantIdx( null,
				TenantId );
			Iterator<IBusModelDelDepObj> iter = dict.values().iterator();
			IBusModelDelDepObj obj;
			List<IBusModelDelDepObj> toForget = new LinkedList<IBusModelDelDepObj>();
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
			schema.getBusModelBackingStore().getTableDelDep().deleteDelDepByTenantIdx( null,
				TenantId );
		}
		deepDisposeDelDepByTenantIdx( TenantId );
	}

	@Override
	public void deleteDelDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableDelDep().deleteDelDepByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelDelDepObj> iter = dict.values().iterator();
			IBusModelDelDepObj obj;
			List<IBusModelDelDepObj> toForget = new LinkedList<IBusModelDelDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByDefSchemaIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDelDep().deleteDelDepByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeDelDepByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteDelDepByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< IBusModelDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelDepObj > >();
		}
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelDepObj> dict = indexByDelDepIdx.get( key );
			schema.getBusModelBackingStore().getTableDelDep().deleteDelDepByDelDepIdx( null,
				RelationId );
			Iterator<IBusModelDelDepObj> iter = dict.values().iterator();
			IBusModelDelDepObj obj;
			List<IBusModelDelDepObj> toForget = new LinkedList<IBusModelDelDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByDelDepIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDelDep().deleteDelDepByDelDepIdx( null,
				RelationId );
		}
		deepDisposeDelDepByDelDepIdx( RelationId );
	}
}