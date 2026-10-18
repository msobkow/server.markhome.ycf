// Description: Java 25 Table Object implementation for PopSubDep2.

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

public class BusModelPopSubDep2TableObj
	implements IBusModelPopSubDep2TableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelPopSubDep2.CLASS_CODE;
	protected static final int backingClassCode = IBusModelPopSubDep2.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> allPopSubDep2;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > > indexByTenantIdx;
	private Map< IBusModelPopDepByRelationIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > > indexByRelationIdx;
	private Map< IBusModelPopDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > > indexByDefSchemaIdx;
	private Map< IBusModelPopSubDep2ByPopSubDep1IdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > > indexByPopSubDep1Idx;
	private Map< IBusModelPopSubDep2ByUNameIdxKey,
		IBusModelPopSubDep2Obj > indexByUNameIdx;
	public static String TABLE_NAME = "PopSubDep2";
	public static String TABLE_DBNAME = "popsubdep2";

	public BusModelPopSubDep2TableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj>();
		allPopSubDep2 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopSubDep1Idx = null;
		indexByUNameIdx = null;
	}

	public BusModelPopSubDep2TableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj>();
		allPopSubDep2 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopSubDep1Idx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelPopSubDep2TableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelPopSubDep2TableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allPopSubDep2 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopSubDep1Idx = null;
		indexByUNameIdx = null;
		List<IBusModelPopSubDep2Obj> toForget = new LinkedList<IBusModelPopSubDep2Obj>();
		IBusModelPopSubDep2Obj cur = null;
		Iterator<IBusModelPopSubDep2Obj> iter = members.values().iterator();
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
	 *	BusModelPopSubDep2Obj.
	 */
	@Override
	public IBusModelPopSubDep2Obj newInstance() {
		IBusModelPopSubDep2Obj inst = new BusModelPopSubDep2Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelPopSubDep2Obj.
	 */
	@Override
	public IBusModelPopSubDep2EditObj newEditInstance( IBusModelPopSubDep2Obj orig ) {
		IBusModelPopSubDep2EditObj edit = new BusModelPopSubDep2EditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelPopSubDep2Obj realisePopSubDep2( IBusModelPopSubDep2Obj Obj ) {
		IBusModelPopSubDep2Obj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelPopSubDep2Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelPopSubDep2Obj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPopSubDep1Idx != null ) {
				IBusModelPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
				keyPopSubDep1Idx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapPopSubDep1Idx = indexByPopSubDep1Idx.get( keyPopSubDep1Idx );
				if( mapPopSubDep1Idx != null ) {
					mapPopSubDep1Idx.remove( keepObj.getPKey() );
					if( mapPopSubDep1Idx.size() <= 0 ) {
						indexByPopSubDep1Idx.remove( keyPopSubDep1Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelPopSubDep2Obj)schema.getPopDepTableObj().realisePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopSubDep1Idx != null ) {
				IBusModelPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
				keyPopSubDep1Idx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapPopSubDep1Idx = indexByPopSubDep1Idx.get( keyPopSubDep1Idx );
				if( mapPopSubDep1Idx != null ) {
					mapPopSubDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allPopSubDep2 != null ) {
				allPopSubDep2.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelPopSubDep2Obj)schema.getPopDepTableObj().realisePopDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopSubDep2 != null ) {
				allPopSubDep2.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopSubDep1Idx != null ) {
				IBusModelPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
				keyPopSubDep1Idx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > mapPopSubDep1Idx = indexByPopSubDep1Idx.get( keyPopSubDep1Idx );
				if( mapPopSubDep1Idx != null ) {
					mapPopSubDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByUNameIdxKey();
				keyUNameIdx.setRequiredPopSubDep1Id( keepObj.getRequiredPopSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelPopSubDep2Obj createPopSubDep2( IBusModelPopSubDep2Obj Obj ) {
		IBusModelPopSubDep2Obj obj = Obj;
		IBusModelPopSubDep2 rec = obj.getPopSubDep2Rec();
		schema.getBusModelBackingStore().getTablePopSubDep2().createPopSubDep2(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelPopSubDep2Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelPopSubDep2Obj readPopSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		return( readPopSubDep2( pkey, false ) );
	}

	@Override
	public IBusModelPopSubDep2Obj readPopSubDep2( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelPopSubDep2Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelPopSubDep2 readRec = schema.getBusModelBackingStore().getTablePopSubDep2().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelPopSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelPopSubDep2Obj readCachedPopSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopSubDep2Obj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposePopSubDep2( IBusModelPopSubDep2Obj obj )
	{
		final String S_ProcName = "BusModelPopSubDep2TableObj.reallyDeepDisposePopSubDep2() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelPopSubDep2Obj existing = readCachedPopSubDep2( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelPopSubDep2ByPopSubDep1IdxKey keyPopSubDep1Idx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
		keyPopSubDep1Idx.setRequiredPopSubDep1Id( existing.getRequiredPopSubDep1Id() );

		IBusModelPopSubDep2ByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByUNameIdxKey();
		keyUNameIdx.setRequiredPopSubDep1Id( existing.getRequiredPopSubDep1Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		schema.getPopSubDep3TableObj().deepDisposePopSubDep3ByPopSubDep2Idx( existing.getRequiredId() );

		if( indexByPopSubDep1Idx != null ) {
			if( indexByPopSubDep1Idx.containsKey( keyPopSubDep1Idx ) ) {
				indexByPopSubDep1Idx.get( keyPopSubDep1Idx ).remove( pkey );
				if( indexByPopSubDep1Idx.get( keyPopSubDep1Idx ).size() <= 0 ) {
					indexByPopSubDep1Idx.remove( keyPopSubDep1Idx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


		schema.getPopDepTableObj().reallyDeepDisposePopDep( obj );
	}
	@Override
	public void deepDisposePopSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopSubDep2Obj obj = readCachedPopSubDep2( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelPopSubDep2Obj lockPopSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopSubDep2Obj locked = null;
		IBusModelPopSubDep2 lockRec = schema.getBusModelBackingStore().getTablePopSubDep2().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelPopSubDep2Obj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockPopSubDep2", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readAllPopSubDep2() {
		return( readAllPopSubDep2( false ) );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readAllPopSubDep2( boolean forceRead ) {
		final String S_ProcName = "readAllPopSubDep2";
		if( ( allPopSubDep2 == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelPopSubDep2Obj>();
			allPopSubDep2 = map;
			IBusModelPopSubDep2[] recList = schema.getBusModelBackingStore().getTablePopSubDep2().readAllDerived( null );
			IBusModelPopSubDep2 rec;
			IBusModelPopSubDep2Obj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep2Obj realised = (IBusModelPopSubDep2Obj)obj.realise();
			}
		}
		int len = allPopSubDep2.size();
		IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
		Iterator<IBusModelPopSubDep2Obj> valIter = allPopSubDep2.values().iterator();
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
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			@Override
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
		List<IBusModelPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readCachedAllPopSubDep2() {
		final String S_ProcName = "readCachedAllPopSubDep2";
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>();
		if( allPopSubDep2 != null ) {
			int len = allPopSubDep2.size();
			IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
			Iterator<IBusModelPopSubDep2Obj> valIter = allPopSubDep2.values().iterator();
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
		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
	public IBusModelPopSubDep2Obj readPopSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		return( readPopSubDep2ByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelPopSubDep2Obj readPopSubDep2ByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelPopSubDep2Obj obj = readPopSubDep2( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readPopSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readPopSubDep2ByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readPopSubDep2ByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep2Obj realised = (IBusModelPopSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
		Iterator<IBusModelPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			@Override
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
		List<IBusModelPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readPopSubDep2ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		return( readPopSubDep2ByRelationIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readPopSubDep2ByRelationIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByRelationIdx";
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< IBusModelPopDepByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj>();
			IBusModelPopDepObj obj;
			IBusModelPopDep[] recList = schema.getBusModelBackingStore().getTablePopDep().readDerivedByRelationIdx( null,
				RelationId );
			IBusModelPopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep2Obj realised = (IBusModelPopSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelationIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
		Iterator<IBusModelPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			@Override
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
		List<IBusModelPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readPopSubDep2ByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readPopSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByDefSchemaIdx";
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelPopDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj>();
			IBusModelPopDepObj obj;
			IBusModelPopDep[] recList = schema.getBusModelBackingStore().getTablePopDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelPopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep2Obj realised = (IBusModelPopSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
		Iterator<IBusModelPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			@Override
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
		List<IBusModelPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readPopSubDep2ByPopSubDep1Idx( IYCFKeyHash256 PopSubDep1Id )
	{
		return( readPopSubDep2ByPopSubDep1Idx( PopSubDep1Id,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readPopSubDep2ByPopSubDep1Idx( IYCFKeyHash256 PopSubDep1Id,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep2ByPopSubDep1Idx";
		IBusModelPopSubDep2ByPopSubDep1IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict;
		if( indexByPopSubDep1Idx == null ) {
			indexByPopSubDep1Idx = new HashMap< IBusModelPopSubDep2ByPopSubDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByPopSubDep1Idx.containsKey( key ) ) {
			dict = indexByPopSubDep1Idx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj>();
			IBusModelPopSubDep2Obj obj;
			IBusModelPopSubDep2[] recList = schema.getBusModelBackingStore().getTablePopSubDep2().readDerivedByPopSubDep1Idx( null,
				PopSubDep1Id );
			IBusModelPopSubDep2 rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep2Obj realised = (IBusModelPopSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPopSubDep1Idx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
		Iterator<IBusModelPopSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			@Override
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
		List<IBusModelPopSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelPopSubDep2Obj readPopSubDep2ByUNameIdx( IYCFKeyHash256 PopSubDep1Id,
		String Name )
	{
		return( readPopSubDep2ByUNameIdx( PopSubDep1Id,
			Name,
			false ) );
	}

	@Override
	public IBusModelPopSubDep2Obj readPopSubDep2ByUNameIdx( IYCFKeyHash256 PopSubDep1Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelPopSubDep2ByUNameIdxKey,
				IBusModelPopSubDep2Obj >();
		}
		IBusModelPopSubDep2ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByUNameIdxKey();
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		key.setRequiredName( Name );
		IBusModelPopSubDep2Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelPopSubDep2 rec = schema.getBusModelBackingStore().getTablePopSubDep2().readDerivedByUNameIdx( null,
				PopSubDep1Id,
				Name );
			if( rec != null ) {
				obj = (IBusModelPopSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelPopSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelPopSubDep2Obj readCachedPopSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopSubDep2Obj obj = null;
		obj = readCachedPopSubDep2( Id );
		return( obj );
	}

	@Override
	public List<IBusModelPopSubDep2Obj> readCachedPopSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedPopSubDep2ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
				Iterator<IBusModelPopSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep2Obj obj;
			Iterator<IBusModelPopSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			@Override
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
	public List<IBusModelPopSubDep2Obj> readCachedPopSubDep2ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedPopSubDep2ByRelationIdx";
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>();
		if( indexByRelationIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict;
			if( indexByRelationIdx.containsKey( key ) ) {
				dict = indexByRelationIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
				Iterator<IBusModelPopSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep2Obj obj;
			Iterator<IBusModelPopSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			@Override
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
	public List<IBusModelPopSubDep2Obj> readCachedPopSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedPopSubDep2ByDefSchemaIdx";
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
				Iterator<IBusModelPopSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep2Obj obj;
			Iterator<IBusModelPopSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			@Override
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
	public List<IBusModelPopSubDep2Obj> readCachedPopSubDep2ByPopSubDep1Idx( IYCFKeyHash256 PopSubDep1Id )
	{
		final String S_ProcName = "readCachedPopSubDep2ByPopSubDep1Idx";
		IBusModelPopSubDep2ByPopSubDep1IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		ArrayList<IBusModelPopSubDep2Obj> arrayList = new ArrayList<IBusModelPopSubDep2Obj>();
		if( indexByPopSubDep1Idx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict;
			if( indexByPopSubDep1Idx.containsKey( key ) ) {
				dict = indexByPopSubDep1Idx.get( key );
				int len = dict.size();
				IBusModelPopSubDep2Obj arr[] = new IBusModelPopSubDep2Obj[len];
				Iterator<IBusModelPopSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep2Obj obj;
			Iterator<IBusModelPopSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep2Obj> cmp = new Comparator<IBusModelPopSubDep2Obj>() {
			@Override
			public int compare( IBusModelPopSubDep2Obj lhs, IBusModelPopSubDep2Obj rhs ) {
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
	public IBusModelPopSubDep2Obj readCachedPopSubDep2ByUNameIdx( IYCFKeyHash256 PopSubDep1Id,
		String Name )
	{
		IBusModelPopSubDep2Obj obj = null;
		IBusModelPopSubDep2ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByUNameIdxKey();
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelPopSubDep2Obj> valIter = members.values().iterator();
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
			Iterator<IBusModelPopSubDep2Obj> valIter = members.values().iterator();
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
	public void deepDisposePopSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopSubDep2Obj obj = readCachedPopSubDep2ByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposePopSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposePopSubDep2ByTenantIdx";
		IBusModelPopSubDep2Obj obj;
		List<IBusModelPopSubDep2Obj> arrayList = readCachedPopSubDep2ByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep2ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposePopSubDep2ByRelationIdx";
		IBusModelPopSubDep2Obj obj;
		List<IBusModelPopSubDep2Obj> arrayList = readCachedPopSubDep2ByRelationIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposePopSubDep2ByDefSchemaIdx";
		IBusModelPopSubDep2Obj obj;
		List<IBusModelPopSubDep2Obj> arrayList = readCachedPopSubDep2ByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep2ByPopSubDep1Idx( IYCFKeyHash256 PopSubDep1Id )
	{
		final String S_ProcName = "deepDisposePopSubDep2ByPopSubDep1Idx";
		IBusModelPopSubDep2Obj obj;
		List<IBusModelPopSubDep2Obj> arrayList = readCachedPopSubDep2ByPopSubDep1Idx( PopSubDep1Id );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep2ByUNameIdx( IYCFKeyHash256 PopSubDep1Id,
		String Name )
	{
		IBusModelPopSubDep2Obj obj = readCachedPopSubDep2ByUNameIdx( PopSubDep1Id,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelPopSubDep2Obj updatePopSubDep2( IBusModelPopSubDep2Obj Obj ) {
		IBusModelPopSubDep2Obj obj = Obj;
		schema.getBusModelBackingStore().getTablePopSubDep2().updatePopSubDep2( null,
			Obj.getPopSubDep2Rec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getPopSubDep2TableObj().getClassCode() ) {
			obj = (IBusModelPopSubDep2Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deletePopSubDep2( IBusModelPopSubDep2Obj Obj ) {
		IBusModelPopSubDep2Obj obj = Obj;
		schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2( null,
			obj.getPopSubDep2Rec() );
		Obj.forget();
	}

	@Override
	public void deletePopSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopSubDep2Obj obj = readPopSubDep2(Id);
		if( obj != null ) {
			IBusModelPopSubDep2EditObj editObj = (IBusModelPopSubDep2EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelPopSubDep2EditObj)obj.beginEdit();
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
		deepDisposePopSubDep2ByIdIdx( Id );
	}

	@Override
	public void deletePopSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByTenantIdx( null,
				TenantId );
			Iterator<IBusModelPopSubDep2Obj> iter = dict.values().iterator();
			IBusModelPopSubDep2Obj obj;
			List<IBusModelPopSubDep2Obj> toForget = new LinkedList<IBusModelPopSubDep2Obj>();
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
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByTenantIdx( null,
				TenantId );
		}
		deepDisposePopSubDep2ByTenantIdx( TenantId );
	}

	@Override
	public void deletePopSubDep2ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< IBusModelPopDepByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict = indexByRelationIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByRelationIdx( null,
				RelationId );
			Iterator<IBusModelPopSubDep2Obj> iter = dict.values().iterator();
			IBusModelPopSubDep2Obj obj;
			List<IBusModelPopSubDep2Obj> toForget = new LinkedList<IBusModelPopSubDep2Obj>();
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
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByRelationIdx( null,
				RelationId );
		}
		deepDisposePopSubDep2ByRelationIdx( RelationId );
	}

	@Override
	public void deletePopSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelPopDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelPopSubDep2Obj> iter = dict.values().iterator();
			IBusModelPopSubDep2Obj obj;
			List<IBusModelPopSubDep2Obj> toForget = new LinkedList<IBusModelPopSubDep2Obj>();
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
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposePopSubDep2ByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deletePopSubDep2ByPopSubDep1Idx( IYCFKeyHash256 PopSubDep1Id )
	{
		IBusModelPopSubDep2ByPopSubDep1IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByPopSubDep1IdxKey();
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		if( indexByPopSubDep1Idx == null ) {
			indexByPopSubDep1Idx = new HashMap< IBusModelPopSubDep2ByPopSubDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj > >();
		}
		if( indexByPopSubDep1Idx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep2Obj> dict = indexByPopSubDep1Idx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByPopSubDep1Idx( null,
				PopSubDep1Id );
			Iterator<IBusModelPopSubDep2Obj> iter = dict.values().iterator();
			IBusModelPopSubDep2Obj obj;
			List<IBusModelPopSubDep2Obj> toForget = new LinkedList<IBusModelPopSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByPopSubDep1Idx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByPopSubDep1Idx( null,
				PopSubDep1Id );
		}
		deepDisposePopSubDep2ByPopSubDep1Idx( PopSubDep1Id );
	}

	@Override
	public void deletePopSubDep2ByUNameIdx( IYCFKeyHash256 PopSubDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelPopSubDep2ByUNameIdxKey,
				IBusModelPopSubDep2Obj >();
		}
		IBusModelPopSubDep2ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newByUNameIdxKey();
		key.setRequiredPopSubDep1Id( PopSubDep1Id );
		key.setRequiredName( Name );
		IBusModelPopSubDep2Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByUNameIdx( null,
				PopSubDep1Id,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTablePopSubDep2().deletePopSubDep2ByUNameIdx( null,
				PopSubDep1Id,
				Name );
		}
		deepDisposePopSubDep2ByUNameIdx( PopSubDep1Id,
				Name );
	}
}