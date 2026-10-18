// Description: Java 25 Table Object implementation for PopSubDep3.

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

public class BusModelPopSubDep3TableObj
	implements IBusModelPopSubDep3TableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelPopSubDep3.CLASS_CODE;
	protected static final int backingClassCode = IBusModelPopSubDep3.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> allPopSubDep3;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > > indexByTenantIdx;
	private Map< IBusModelPopDepByRelationIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > > indexByRelationIdx;
	private Map< IBusModelPopDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > > indexByDefSchemaIdx;
	private Map< IBusModelPopSubDep3ByPopSubDep2IdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > > indexByPopSubDep2Idx;
	private Map< IBusModelPopSubDep3ByUNameIdxKey,
		IBusModelPopSubDep3Obj > indexByUNameIdx;
	public static String TABLE_NAME = "PopSubDep3";
	public static String TABLE_DBNAME = "popsubdep3";

	public BusModelPopSubDep3TableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj>();
		allPopSubDep3 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopSubDep2Idx = null;
		indexByUNameIdx = null;
	}

	public BusModelPopSubDep3TableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj>();
		allPopSubDep3 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopSubDep2Idx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelPopSubDep3TableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelPopSubDep3TableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allPopSubDep3 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopSubDep2Idx = null;
		indexByUNameIdx = null;
		List<IBusModelPopSubDep3Obj> toForget = new LinkedList<IBusModelPopSubDep3Obj>();
		IBusModelPopSubDep3Obj cur = null;
		Iterator<IBusModelPopSubDep3Obj> iter = members.values().iterator();
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
	 *	BusModelPopSubDep3Obj.
	 */
	@Override
	public IBusModelPopSubDep3Obj newInstance() {
		IBusModelPopSubDep3Obj inst = new BusModelPopSubDep3Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelPopSubDep3Obj.
	 */
	@Override
	public IBusModelPopSubDep3EditObj newEditInstance( IBusModelPopSubDep3Obj orig ) {
		IBusModelPopSubDep3EditObj edit = new BusModelPopSubDep3EditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelPopSubDep3Obj realisePopSubDep3( IBusModelPopSubDep3Obj Obj ) {
		IBusModelPopSubDep3Obj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelPopSubDep3Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelPopSubDep3Obj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPopSubDep2Idx != null ) {
				IBusModelPopSubDep3ByPopSubDep2IdxKey keyPopSubDep2Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
				keyPopSubDep2Idx.setRequiredPopSubDep2Id( keepObj.getRequiredPopSubDep2Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapPopSubDep2Idx = indexByPopSubDep2Idx.get( keyPopSubDep2Idx );
				if( mapPopSubDep2Idx != null ) {
					mapPopSubDep2Idx.remove( keepObj.getPKey() );
					if( mapPopSubDep2Idx.size() <= 0 ) {
						indexByPopSubDep2Idx.remove( keyPopSubDep2Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep2Id( keepObj.getRequiredPopSubDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelPopSubDep3Obj)schema.getPopDepTableObj().realisePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopSubDep2Idx != null ) {
				IBusModelPopSubDep3ByPopSubDep2IdxKey keyPopSubDep2Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
				keyPopSubDep2Idx.setRequiredPopSubDep2Id( keepObj.getRequiredPopSubDep2Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapPopSubDep2Idx = indexByPopSubDep2Idx.get( keyPopSubDep2Idx );
				if( mapPopSubDep2Idx != null ) {
					mapPopSubDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep2Id( keepObj.getRequiredPopSubDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allPopSubDep3 != null ) {
				allPopSubDep3.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelPopSubDep3Obj)schema.getPopDepTableObj().realisePopDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopSubDep3 != null ) {
				allPopSubDep3.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopSubDep2Idx != null ) {
				IBusModelPopSubDep3ByPopSubDep2IdxKey keyPopSubDep2Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
				keyPopSubDep2Idx.setRequiredPopSubDep2Id( keepObj.getRequiredPopSubDep2Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > mapPopSubDep2Idx = indexByPopSubDep2Idx.get( keyPopSubDep2Idx );
				if( mapPopSubDep2Idx != null ) {
					mapPopSubDep2Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopSubDep3ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep2Id( keepObj.getRequiredPopSubDep2Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelPopSubDep3Obj createPopSubDep3( IBusModelPopSubDep3Obj Obj ) {
		IBusModelPopSubDep3Obj obj = Obj;
		IBusModelPopSubDep3 rec = obj.getPopSubDep3Rec();
		schema.getBusModelBackingStore().getTablePopSubDep3().createPopSubDep3(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelPopSubDep3Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelPopSubDep3Obj readPopSubDep3( $implCommaIJavaOptAtomType$ pkey ) {
		return( readPopSubDep3( pkey, false ) );
	}

	@Override
	public IBusModelPopSubDep3Obj readPopSubDep3( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelPopSubDep3Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelPopSubDep3 readRec = schema.getBusModelBackingStore().getTablePopSubDep3().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelPopSubDep3Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelPopSubDep3Obj readCachedPopSubDep3( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopSubDep3Obj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposePopSubDep3( IBusModelPopSubDep3Obj obj )
	{
		final String S_ProcName = "BusModelPopSubDep3TableObj.reallyDeepDisposePopSubDep3() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelPopSubDep3Obj existing = readCachedPopSubDep3( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelPopSubDep3ByPopSubDep2IdxKey keyPopSubDep2Idx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
		keyPopSubDep2Idx.setRequiredPopSubDep2Id( existing.getRequiredPopSubDep2Id() );

		IBusModelPopSubDep3ByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByUNameIdxKey();
		keyUNameIdx.setRequiredPopSubDep2Id( existing.getRequiredPopSubDep2Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );



		if( indexByPopSubDep2Idx != null ) {
			if( indexByPopSubDep2Idx.containsKey( keyPopSubDep2Idx ) ) {
				indexByPopSubDep2Idx.get( keyPopSubDep2Idx ).remove( pkey );
				if( indexByPopSubDep2Idx.get( keyPopSubDep2Idx ).size() <= 0 ) {
					indexByPopSubDep2Idx.remove( keyPopSubDep2Idx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


		schema.getPopDepTableObj().reallyDeepDisposePopDep( obj );
	}
	@Override
	public void deepDisposePopSubDep3( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopSubDep3Obj obj = readCachedPopSubDep3( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelPopSubDep3Obj lockPopSubDep3( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopSubDep3Obj locked = null;
		IBusModelPopSubDep3 lockRec = schema.getBusModelBackingStore().getTablePopSubDep3().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelPopSubDep3Obj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockPopSubDep3", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readAllPopSubDep3() {
		return( readAllPopSubDep3( false ) );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readAllPopSubDep3( boolean forceRead ) {
		final String S_ProcName = "readAllPopSubDep3";
		if( ( allPopSubDep3 == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelPopSubDep3Obj>();
			allPopSubDep3 = map;
			IBusModelPopSubDep3[] recList = schema.getBusModelBackingStore().getTablePopSubDep3().readAllDerived( null );
			IBusModelPopSubDep3 rec;
			IBusModelPopSubDep3Obj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep3Obj realised = (IBusModelPopSubDep3Obj)obj.realise();
			}
		}
		int len = allPopSubDep3.size();
		IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
		Iterator<IBusModelPopSubDep3Obj> valIter = allPopSubDep3.values().iterator();
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
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			@Override
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
		List<IBusModelPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readCachedAllPopSubDep3() {
		final String S_ProcName = "readCachedAllPopSubDep3";
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>();
		if( allPopSubDep3 != null ) {
			int len = allPopSubDep3.size();
			IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
			Iterator<IBusModelPopSubDep3Obj> valIter = allPopSubDep3.values().iterator();
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
		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
	public IBusModelPopSubDep3Obj readPopSubDep3ByIdIdx( IYCFKeyHash256 Id )
	{
		return( readPopSubDep3ByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelPopSubDep3Obj readPopSubDep3ByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelPopSubDep3Obj obj = readPopSubDep3( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readPopSubDep3ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readPopSubDep3ByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readPopSubDep3ByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep3ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep3Obj realised = (IBusModelPopSubDep3Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
		Iterator<IBusModelPopSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			@Override
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
		List<IBusModelPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readPopSubDep3ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		return( readPopSubDep3ByRelationIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readPopSubDep3ByRelationIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep3ByRelationIdx";
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< IBusModelPopDepByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj>();
			IBusModelPopDepObj obj;
			IBusModelPopDep[] recList = schema.getBusModelBackingStore().getTablePopDep().readDerivedByRelationIdx( null,
				RelationId );
			IBusModelPopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep3Obj realised = (IBusModelPopSubDep3Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelationIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
		Iterator<IBusModelPopSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			@Override
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
		List<IBusModelPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readPopSubDep3ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readPopSubDep3ByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readPopSubDep3ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep3ByDefSchemaIdx";
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelPopDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj>();
			IBusModelPopDepObj obj;
			IBusModelPopDep[] recList = schema.getBusModelBackingStore().getTablePopDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelPopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep3Obj realised = (IBusModelPopSubDep3Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
		Iterator<IBusModelPopSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			@Override
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
		List<IBusModelPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readPopSubDep3ByPopSubDep2Idx( IYCFKeyHash256 PopSubDep2Id )
	{
		return( readPopSubDep3ByPopSubDep2Idx( PopSubDep2Id,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readPopSubDep3ByPopSubDep2Idx( IYCFKeyHash256 PopSubDep2Id,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep3ByPopSubDep2Idx";
		IBusModelPopSubDep3ByPopSubDep2IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
		key.setRequiredPopSubDep2Id( PopSubDep2Id );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict;
		if( indexByPopSubDep2Idx == null ) {
			indexByPopSubDep2Idx = new HashMap< IBusModelPopSubDep3ByPopSubDep2IdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > >();
		}
		if( ( ! forceRead ) && indexByPopSubDep2Idx.containsKey( key ) ) {
			dict = indexByPopSubDep2Idx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj>();
			IBusModelPopSubDep3Obj obj;
			IBusModelPopSubDep3[] recList = schema.getBusModelBackingStore().getTablePopSubDep3().readDerivedByPopSubDep2Idx( null,
				PopSubDep2Id );
			IBusModelPopSubDep3 rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep3Obj realised = (IBusModelPopSubDep3Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPopSubDep2Idx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
		Iterator<IBusModelPopSubDep3Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			@Override
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
		List<IBusModelPopSubDep3Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelPopSubDep3Obj readPopSubDep3ByUNameIdx( IYCFKeyHash256 PopSubDep2Id,
		String Name )
	{
		return( readPopSubDep3ByUNameIdx( PopSubDep2Id,
			Name,
			false ) );
	}

	@Override
	public IBusModelPopSubDep3Obj readPopSubDep3ByUNameIdx( IYCFKeyHash256 PopSubDep2Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelPopSubDep3ByUNameIdxKey,
				IBusModelPopSubDep3Obj >();
		}
		IBusModelPopSubDep3ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByUNameIdxKey();
		key.setRequiredPopSubDep2Id( PopSubDep2Id );
		key.setRequiredName( Name );
		IBusModelPopSubDep3Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelPopSubDep3 rec = schema.getBusModelBackingStore().getTablePopSubDep3().readDerivedByUNameIdx( null,
				PopSubDep2Id,
				Name );
			if( rec != null ) {
				obj = (IBusModelPopSubDep3Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelPopSubDep3Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelPopSubDep3Obj readCachedPopSubDep3ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopSubDep3Obj obj = null;
		obj = readCachedPopSubDep3( Id );
		return( obj );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> readCachedPopSubDep3ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedPopSubDep3ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
				Iterator<IBusModelPopSubDep3Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep3Obj obj;
			Iterator<IBusModelPopSubDep3Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			@Override
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
	public List<IBusModelPopSubDep3Obj> readCachedPopSubDep3ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedPopSubDep3ByRelationIdx";
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>();
		if( indexByRelationIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict;
			if( indexByRelationIdx.containsKey( key ) ) {
				dict = indexByRelationIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
				Iterator<IBusModelPopSubDep3Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep3Obj obj;
			Iterator<IBusModelPopSubDep3Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			@Override
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
	public List<IBusModelPopSubDep3Obj> readCachedPopSubDep3ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedPopSubDep3ByDefSchemaIdx";
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
				Iterator<IBusModelPopSubDep3Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep3Obj obj;
			Iterator<IBusModelPopSubDep3Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			@Override
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
	public List<IBusModelPopSubDep3Obj> readCachedPopSubDep3ByPopSubDep2Idx( IYCFKeyHash256 PopSubDep2Id )
	{
		final String S_ProcName = "readCachedPopSubDep3ByPopSubDep2Idx";
		IBusModelPopSubDep3ByPopSubDep2IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
		key.setRequiredPopSubDep2Id( PopSubDep2Id );
		ArrayList<IBusModelPopSubDep3Obj> arrayList = new ArrayList<IBusModelPopSubDep3Obj>();
		if( indexByPopSubDep2Idx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict;
			if( indexByPopSubDep2Idx.containsKey( key ) ) {
				dict = indexByPopSubDep2Idx.get( key );
				int len = dict.size();
				IBusModelPopSubDep3Obj arr[] = new IBusModelPopSubDep3Obj[len];
				Iterator<IBusModelPopSubDep3Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep3Obj obj;
			Iterator<IBusModelPopSubDep3Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep3Obj> cmp = new Comparator<IBusModelPopSubDep3Obj>() {
			@Override
			public int compare( IBusModelPopSubDep3Obj lhs, IBusModelPopSubDep3Obj rhs ) {
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
	public IBusModelPopSubDep3Obj readCachedPopSubDep3ByUNameIdx( IYCFKeyHash256 PopSubDep2Id,
		String Name )
	{
		IBusModelPopSubDep3Obj obj = null;
		IBusModelPopSubDep3ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByUNameIdxKey();
		key.setRequiredPopSubDep2Id( PopSubDep2Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelPopSubDep3Obj> valIter = members.values().iterator();
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
			Iterator<IBusModelPopSubDep3Obj> valIter = members.values().iterator();
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
	public void deepDisposePopSubDep3ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopSubDep3Obj obj = readCachedPopSubDep3ByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposePopSubDep3ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposePopSubDep3ByTenantIdx";
		IBusModelPopSubDep3Obj obj;
		List<IBusModelPopSubDep3Obj> arrayList = readCachedPopSubDep3ByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep3Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep3ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposePopSubDep3ByRelationIdx";
		IBusModelPopSubDep3Obj obj;
		List<IBusModelPopSubDep3Obj> arrayList = readCachedPopSubDep3ByRelationIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep3Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep3ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposePopSubDep3ByDefSchemaIdx";
		IBusModelPopSubDep3Obj obj;
		List<IBusModelPopSubDep3Obj> arrayList = readCachedPopSubDep3ByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep3Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep3ByPopSubDep2Idx( IYCFKeyHash256 PopSubDep2Id )
	{
		final String S_ProcName = "deepDisposePopSubDep3ByPopSubDep2Idx";
		IBusModelPopSubDep3Obj obj;
		List<IBusModelPopSubDep3Obj> arrayList = readCachedPopSubDep3ByPopSubDep2Idx( PopSubDep2Id );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep3Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep3ByUNameIdx( IYCFKeyHash256 PopSubDep2Id,
		String Name )
	{
		IBusModelPopSubDep3Obj obj = readCachedPopSubDep3ByUNameIdx( PopSubDep2Id,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelPopSubDep3Obj updatePopSubDep3( IBusModelPopSubDep3Obj Obj ) {
		IBusModelPopSubDep3Obj obj = Obj;
		schema.getBusModelBackingStore().getTablePopSubDep3().updatePopSubDep3( null,
			Obj.getPopSubDep3Rec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getPopSubDep3TableObj().getClassCode() ) {
			obj = (IBusModelPopSubDep3Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deletePopSubDep3( IBusModelPopSubDep3Obj Obj ) {
		IBusModelPopSubDep3Obj obj = Obj;
		schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3( null,
			obj.getPopSubDep3Rec() );
		Obj.forget();
	}

	@Override
	public void deletePopSubDep3ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopSubDep3Obj obj = readPopSubDep3(Id);
		if( obj != null ) {
			IBusModelPopSubDep3EditObj editObj = (IBusModelPopSubDep3EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelPopSubDep3EditObj)obj.beginEdit();
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
		deepDisposePopSubDep3ByIdIdx( Id );
	}

	@Override
	public void deletePopSubDep3ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByTenantIdx( null,
				TenantId );
			Iterator<IBusModelPopSubDep3Obj> iter = dict.values().iterator();
			IBusModelPopSubDep3Obj obj;
			List<IBusModelPopSubDep3Obj> toForget = new LinkedList<IBusModelPopSubDep3Obj>();
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
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByTenantIdx( null,
				TenantId );
		}
		deepDisposePopSubDep3ByTenantIdx( TenantId );
	}

	@Override
	public void deletePopSubDep3ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< IBusModelPopDepByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict = indexByRelationIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByRelationIdx( null,
				RelationId );
			Iterator<IBusModelPopSubDep3Obj> iter = dict.values().iterator();
			IBusModelPopSubDep3Obj obj;
			List<IBusModelPopSubDep3Obj> toForget = new LinkedList<IBusModelPopSubDep3Obj>();
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
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByRelationIdx( null,
				RelationId );
		}
		deepDisposePopSubDep3ByRelationIdx( RelationId );
	}

	@Override
	public void deletePopSubDep3ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelPopDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelPopSubDep3Obj> iter = dict.values().iterator();
			IBusModelPopSubDep3Obj obj;
			List<IBusModelPopSubDep3Obj> toForget = new LinkedList<IBusModelPopSubDep3Obj>();
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
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposePopSubDep3ByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deletePopSubDep3ByPopSubDep2Idx( IYCFKeyHash256 PopSubDep2Id )
	{
		IBusModelPopSubDep3ByPopSubDep2IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByPopSubDep2IdxKey();
		key.setRequiredPopSubDep2Id( PopSubDep2Id );
		if( indexByPopSubDep2Idx == null ) {
			indexByPopSubDep2Idx = new HashMap< IBusModelPopSubDep3ByPopSubDep2IdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj > >();
		}
		if( indexByPopSubDep2Idx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep3Obj> dict = indexByPopSubDep2Idx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByPopSubDep2Idx( null,
				PopSubDep2Id );
			Iterator<IBusModelPopSubDep3Obj> iter = dict.values().iterator();
			IBusModelPopSubDep3Obj obj;
			List<IBusModelPopSubDep3Obj> toForget = new LinkedList<IBusModelPopSubDep3Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByPopSubDep2Idx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByPopSubDep2Idx( null,
				PopSubDep2Id );
		}
		deepDisposePopSubDep3ByPopSubDep2Idx( PopSubDep2Id );
	}

	@Override
	public void deletePopSubDep3ByUNameIdx( IYCFKeyHash256 PopSubDep2Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelPopSubDep3ByUNameIdxKey,
				IBusModelPopSubDep3Obj >();
		}
		IBusModelPopSubDep3ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep3().newByUNameIdxKey();
		key.setRequiredPopSubDep2Id( PopSubDep2Id );
		key.setRequiredName( Name );
		IBusModelPopSubDep3Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByUNameIdx( null,
				PopSubDep2Id,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTablePopSubDep3().deletePopSubDep3ByUNameIdx( null,
				PopSubDep2Id,
				Name );
		}
		deepDisposePopSubDep3ByUNameIdx( PopSubDep2Id,
				Name );
	}
}