// Description: Java 25 Table Object implementation for PopTopDep.

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

public class BusModelPopTopDepTableObj
	implements IBusModelPopTopDepTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelPopTopDep.CLASS_CODE;
	protected static final int backingClassCode = IBusModelPopTopDep.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> allPopTopDep;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > > indexByTenantIdx;
	private Map< IBusModelPopDepByRelationIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > > indexByRelationIdx;
	private Map< IBusModelPopDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > > indexByDefSchemaIdx;
	private Map< IBusModelPopTopDepByContRelIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > > indexByContRelIdx;
	private Map< IBusModelPopTopDepByUNameIdxKey,
		IBusModelPopTopDepObj > indexByUNameIdx;
	public static String TABLE_NAME = "PopTopDep";
	public static String TABLE_DBNAME = "pop_topdep";

	public BusModelPopTopDepTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj>();
		allPopTopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContRelIdx = null;
		indexByUNameIdx = null;
	}

	public BusModelPopTopDepTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj>();
		allPopTopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContRelIdx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelPopTopDepTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelPopTopDepTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allPopTopDep = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByContRelIdx = null;
		indexByUNameIdx = null;
		List<IBusModelPopTopDepObj> toForget = new LinkedList<IBusModelPopTopDepObj>();
		IBusModelPopTopDepObj cur = null;
		Iterator<IBusModelPopTopDepObj> iter = members.values().iterator();
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
	 *	BusModelPopTopDepObj.
	 */
	@Override
	public IBusModelPopTopDepObj newInstance() {
		IBusModelPopTopDepObj inst = new BusModelPopTopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelPopTopDepObj.
	 */
	@Override
	public IBusModelPopTopDepEditObj newEditInstance( IBusModelPopTopDepObj orig ) {
		IBusModelPopTopDepEditObj edit = new BusModelPopTopDepEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelPopTopDepObj realisePopTopDep( IBusModelPopTopDepObj Obj ) {
		IBusModelPopTopDepObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelPopTopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelPopTopDepObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByContRelIdx != null ) {
				IBusModelPopTopDepByContRelIdxKey keyContRelIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByContRelIdxKey();
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.remove( keepObj.getPKey() );
					if( mapContRelIdx.size() <= 0 ) {
						indexByContRelIdx.remove( keyContRelIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopTopDepByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByUNameIdxKey();
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelPopTopDepObj)schema.getPopDepTableObj().realisePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContRelIdx != null ) {
				IBusModelPopTopDepByContRelIdxKey keyContRelIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByContRelIdxKey();
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopTopDepByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByUNameIdxKey();
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allPopTopDep != null ) {
				allPopTopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelPopTopDepObj)schema.getPopDepTableObj().realisePopDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopTopDep != null ) {
				allPopTopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContRelIdx != null ) {
				IBusModelPopTopDepByContRelIdxKey keyContRelIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByContRelIdxKey();
				keyContRelIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > mapContRelIdx = indexByContRelIdx.get( keyContRelIdx );
				if( mapContRelIdx != null ) {
					mapContRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopTopDepByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByUNameIdxKey();
				keyUNameIdx.setRequiredContRelationId( keepObj.getRequiredContRelationId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelPopTopDepObj createPopTopDep( IBusModelPopTopDepObj Obj ) {
		IBusModelPopTopDepObj obj = Obj;
		IBusModelPopTopDep rec = obj.getPopTopDepRec();
		schema.getBusModelBackingStore().getTablePopTopDep().createPopTopDep(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelPopTopDepObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelPopTopDepObj readPopTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		return( readPopTopDep( pkey, false ) );
	}

	@Override
	public IBusModelPopTopDepObj readPopTopDep( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelPopTopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelPopTopDep readRec = schema.getBusModelBackingStore().getTablePopTopDep().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelPopTopDepObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelPopTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelPopTopDepObj readCachedPopTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopTopDepObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposePopTopDep( IBusModelPopTopDepObj obj )
	{
		final String S_ProcName = "BusModelPopTopDepTableObj.reallyDeepDisposePopTopDep() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelPopTopDepObj existing = readCachedPopTopDep( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelPopTopDepByContRelIdxKey keyContRelIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByContRelIdxKey();
		keyContRelIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );

		IBusModelPopTopDepByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByUNameIdxKey();
		keyUNameIdx.setRequiredContRelationId( existing.getRequiredContRelationId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		schema.getPopSubDep1TableObj().deepDisposePopSubDep1ByPopTopDepIdx( existing.getRequiredId() );

		if( indexByContRelIdx != null ) {
			if( indexByContRelIdx.containsKey( keyContRelIdx ) ) {
				indexByContRelIdx.get( keyContRelIdx ).remove( pkey );
				if( indexByContRelIdx.get( keyContRelIdx ).size() <= 0 ) {
					indexByContRelIdx.remove( keyContRelIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


		schema.getPopDepTableObj().reallyDeepDisposePopDep( obj );
	}
	@Override
	public void deepDisposePopTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopTopDepObj obj = readCachedPopTopDep( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelPopTopDepObj lockPopTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopTopDepObj locked = null;
		IBusModelPopTopDep lockRec = schema.getBusModelBackingStore().getTablePopTopDep().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelPopTopDepObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelPopTopDepObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockPopTopDep", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelPopTopDepObj> readAllPopTopDep() {
		return( readAllPopTopDep( false ) );
	}

	@Override
	public List<IBusModelPopTopDepObj> readAllPopTopDep( boolean forceRead ) {
		final String S_ProcName = "readAllPopTopDep";
		if( ( allPopTopDep == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelPopTopDepObj>();
			allPopTopDep = map;
			IBusModelPopTopDep[] recList = schema.getBusModelBackingStore().getTablePopTopDep().readAllDerived( null );
			IBusModelPopTopDep rec;
			IBusModelPopTopDepObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopTopDepObj realised = (IBusModelPopTopDepObj)obj.realise();
			}
		}
		int len = allPopTopDep.size();
		IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
		Iterator<IBusModelPopTopDepObj> valIter = allPopTopDep.values().iterator();
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
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			@Override
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
		List<IBusModelPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopTopDepObj> readCachedAllPopTopDep() {
		final String S_ProcName = "readCachedAllPopTopDep";
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>();
		if( allPopTopDep != null ) {
			int len = allPopTopDep.size();
			IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
			Iterator<IBusModelPopTopDepObj> valIter = allPopTopDep.values().iterator();
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
		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
	public IBusModelPopTopDepObj readPopTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		return( readPopTopDepByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelPopTopDepObj readPopTopDepByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelPopTopDepObj obj = readPopTopDep( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelPopTopDepObj> readPopTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readPopTopDepByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelPopTopDepObj> readPopTopDepByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopTopDepObj realised = (IBusModelPopTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
		Iterator<IBusModelPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			@Override
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
		List<IBusModelPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopTopDepObj> readPopTopDepByRelationIdx( IYCFKeyHash256 RelationId )
	{
		return( readPopTopDepByRelationIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelPopTopDepObj> readPopTopDepByRelationIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByRelationIdx";
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< IBusModelPopDepByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj>();
			IBusModelPopDepObj obj;
			IBusModelPopDep[] recList = schema.getBusModelBackingStore().getTablePopDep().readDerivedByRelationIdx( null,
				RelationId );
			IBusModelPopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopTopDepObj realised = (IBusModelPopTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelationIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
		Iterator<IBusModelPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			@Override
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
		List<IBusModelPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopTopDepObj> readPopTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readPopTopDepByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelPopTopDepObj> readPopTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByDefSchemaIdx";
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelPopDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj>();
			IBusModelPopDepObj obj;
			IBusModelPopDep[] recList = schema.getBusModelBackingStore().getTablePopDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelPopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopTopDepObj realised = (IBusModelPopTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
		Iterator<IBusModelPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			@Override
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
		List<IBusModelPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopTopDepObj> readPopTopDepByContRelIdx( IYCFKeyHash256 ContRelationId )
	{
		return( readPopTopDepByContRelIdx( ContRelationId,
			false ) );
	}

	@Override
	public List<IBusModelPopTopDepObj> readPopTopDepByContRelIdx( IYCFKeyHash256 ContRelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopTopDepByContRelIdx";
		IBusModelPopTopDepByContRelIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByContRelIdxKey();
		key.setRequiredContRelationId( ContRelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict;
		if( indexByContRelIdx == null ) {
			indexByContRelIdx = new HashMap< IBusModelPopTopDepByContRelIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByContRelIdx.containsKey( key ) ) {
			dict = indexByContRelIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj>();
			IBusModelPopTopDepObj obj;
			IBusModelPopTopDep[] recList = schema.getBusModelBackingStore().getTablePopTopDep().readDerivedByContRelIdx( null,
				ContRelationId );
			IBusModelPopTopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopTopDepObj realised = (IBusModelPopTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContRelIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
		Iterator<IBusModelPopTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			@Override
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
		List<IBusModelPopTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelPopTopDepObj readPopTopDepByUNameIdx( IYCFKeyHash256 ContRelationId,
		String Name )
	{
		return( readPopTopDepByUNameIdx( ContRelationId,
			Name,
			false ) );
	}

	@Override
	public IBusModelPopTopDepObj readPopTopDepByUNameIdx( IYCFKeyHash256 ContRelationId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelPopTopDepByUNameIdxKey,
				IBusModelPopTopDepObj >();
		}
		IBusModelPopTopDepByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByUNameIdxKey();
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		IBusModelPopTopDepObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelPopTopDep rec = schema.getBusModelBackingStore().getTablePopTopDep().readDerivedByUNameIdx( null,
				ContRelationId,
				Name );
			if( rec != null ) {
				obj = (IBusModelPopTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelPopTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelPopTopDepObj readCachedPopTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopTopDepObj obj = null;
		obj = readCachedPopTopDep( Id );
		return( obj );
	}

	@Override
	public List<IBusModelPopTopDepObj> readCachedPopTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedPopTopDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
				Iterator<IBusModelPopTopDepObj> valIter = dict.values().iterator();
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
			IBusModelPopTopDepObj obj;
			Iterator<IBusModelPopTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			@Override
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
	public List<IBusModelPopTopDepObj> readCachedPopTopDepByRelationIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedPopTopDepByRelationIdx";
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>();
		if( indexByRelationIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict;
			if( indexByRelationIdx.containsKey( key ) ) {
				dict = indexByRelationIdx.get( key );
				int len = dict.size();
				IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
				Iterator<IBusModelPopTopDepObj> valIter = dict.values().iterator();
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
			IBusModelPopTopDepObj obj;
			Iterator<IBusModelPopTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			@Override
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
	public List<IBusModelPopTopDepObj> readCachedPopTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedPopTopDepByDefSchemaIdx";
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
				Iterator<IBusModelPopTopDepObj> valIter = dict.values().iterator();
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
			IBusModelPopTopDepObj obj;
			Iterator<IBusModelPopTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			@Override
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
	public List<IBusModelPopTopDepObj> readCachedPopTopDepByContRelIdx( IYCFKeyHash256 ContRelationId )
	{
		final String S_ProcName = "readCachedPopTopDepByContRelIdx";
		IBusModelPopTopDepByContRelIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByContRelIdxKey();
		key.setRequiredContRelationId( ContRelationId );
		ArrayList<IBusModelPopTopDepObj> arrayList = new ArrayList<IBusModelPopTopDepObj>();
		if( indexByContRelIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict;
			if( indexByContRelIdx.containsKey( key ) ) {
				dict = indexByContRelIdx.get( key );
				int len = dict.size();
				IBusModelPopTopDepObj arr[] = new IBusModelPopTopDepObj[len];
				Iterator<IBusModelPopTopDepObj> valIter = dict.values().iterator();
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
			IBusModelPopTopDepObj obj;
			Iterator<IBusModelPopTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopTopDepObj> cmp = new Comparator<IBusModelPopTopDepObj>() {
			@Override
			public int compare( IBusModelPopTopDepObj lhs, IBusModelPopTopDepObj rhs ) {
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
	public IBusModelPopTopDepObj readCachedPopTopDepByUNameIdx( IYCFKeyHash256 ContRelationId,
		String Name )
	{
		IBusModelPopTopDepObj obj = null;
		IBusModelPopTopDepByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByUNameIdxKey();
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelPopTopDepObj> valIter = members.values().iterator();
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
			Iterator<IBusModelPopTopDepObj> valIter = members.values().iterator();
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
	public void deepDisposePopTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopTopDepObj obj = readCachedPopTopDepByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposePopTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposePopTopDepByTenantIdx";
		IBusModelPopTopDepObj obj;
		List<IBusModelPopTopDepObj> arrayList = readCachedPopTopDepByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelPopTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopTopDepByRelationIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposePopTopDepByRelationIdx";
		IBusModelPopTopDepObj obj;
		List<IBusModelPopTopDepObj> arrayList = readCachedPopTopDepByRelationIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelPopTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposePopTopDepByDefSchemaIdx";
		IBusModelPopTopDepObj obj;
		List<IBusModelPopTopDepObj> arrayList = readCachedPopTopDepByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelPopTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopTopDepByContRelIdx( IYCFKeyHash256 ContRelationId )
	{
		final String S_ProcName = "deepDisposePopTopDepByContRelIdx";
		IBusModelPopTopDepObj obj;
		List<IBusModelPopTopDepObj> arrayList = readCachedPopTopDepByContRelIdx( ContRelationId );
		if( arrayList != null )  {
			Iterator<IBusModelPopTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopTopDepByUNameIdx( IYCFKeyHash256 ContRelationId,
		String Name )
	{
		IBusModelPopTopDepObj obj = readCachedPopTopDepByUNameIdx( ContRelationId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelPopTopDepObj updatePopTopDep( IBusModelPopTopDepObj Obj ) {
		IBusModelPopTopDepObj obj = Obj;
		schema.getBusModelBackingStore().getTablePopTopDep().updatePopTopDep( null,
			Obj.getPopTopDepRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getPopTopDepTableObj().getClassCode() ) {
			obj = (IBusModelPopTopDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deletePopTopDep( IBusModelPopTopDepObj Obj ) {
		IBusModelPopTopDepObj obj = Obj;
		schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDep( null,
			obj.getPopTopDepRec() );
		Obj.forget();
	}

	@Override
	public void deletePopTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopTopDepObj obj = readPopTopDep(Id);
		if( obj != null ) {
			IBusModelPopTopDepEditObj editObj = (IBusModelPopTopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelPopTopDepEditObj)obj.beginEdit();
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
		deepDisposePopTopDepByIdIdx( Id );
	}

	@Override
	public void deletePopTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByTenantIdx( null,
				TenantId );
			Iterator<IBusModelPopTopDepObj> iter = dict.values().iterator();
			IBusModelPopTopDepObj obj;
			List<IBusModelPopTopDepObj> toForget = new LinkedList<IBusModelPopTopDepObj>();
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
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByTenantIdx( null,
				TenantId );
		}
		deepDisposePopTopDepByTenantIdx( TenantId );
	}

	@Override
	public void deletePopTopDepByRelationIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< IBusModelPopDepByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict = indexByRelationIdx.get( key );
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByRelationIdx( null,
				RelationId );
			Iterator<IBusModelPopTopDepObj> iter = dict.values().iterator();
			IBusModelPopTopDepObj obj;
			List<IBusModelPopTopDepObj> toForget = new LinkedList<IBusModelPopTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByRelationIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByRelationIdx( null,
				RelationId );
		}
		deepDisposePopTopDepByRelationIdx( RelationId );
	}

	@Override
	public void deletePopTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelPopDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelPopTopDepObj> iter = dict.values().iterator();
			IBusModelPopTopDepObj obj;
			List<IBusModelPopTopDepObj> toForget = new LinkedList<IBusModelPopTopDepObj>();
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
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposePopTopDepByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deletePopTopDepByContRelIdx( IYCFKeyHash256 ContRelationId )
	{
		IBusModelPopTopDepByContRelIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByContRelIdxKey();
		key.setRequiredContRelationId( ContRelationId );
		if( indexByContRelIdx == null ) {
			indexByContRelIdx = new HashMap< IBusModelPopTopDepByContRelIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopTopDepObj > >();
		}
		if( indexByContRelIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopTopDepObj> dict = indexByContRelIdx.get( key );
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByContRelIdx( null,
				ContRelationId );
			Iterator<IBusModelPopTopDepObj> iter = dict.values().iterator();
			IBusModelPopTopDepObj obj;
			List<IBusModelPopTopDepObj> toForget = new LinkedList<IBusModelPopTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByContRelIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByContRelIdx( null,
				ContRelationId );
		}
		deepDisposePopTopDepByContRelIdx( ContRelationId );
	}

	@Override
	public void deletePopTopDepByUNameIdx( IYCFKeyHash256 ContRelationId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelPopTopDepByUNameIdxKey,
				IBusModelPopTopDepObj >();
		}
		IBusModelPopTopDepByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopTopDep().newByUNameIdxKey();
		key.setRequiredContRelationId( ContRelationId );
		key.setRequiredName( Name );
		IBusModelPopTopDepObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByUNameIdx( null,
				ContRelationId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTablePopTopDep().deletePopTopDepByUNameIdx( null,
				ContRelationId,
				Name );
		}
		deepDisposePopTopDepByUNameIdx( ContRelationId,
				Name );
	}
}