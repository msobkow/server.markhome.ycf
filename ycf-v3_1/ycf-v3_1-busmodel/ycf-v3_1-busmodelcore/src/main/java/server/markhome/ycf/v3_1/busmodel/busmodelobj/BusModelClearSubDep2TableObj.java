// Description: Java 25 Table Object implementation for ClearSubDep2.

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

public class BusModelClearSubDep2TableObj
	implements IBusModelClearSubDep2TableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelClearSubDep2.CLASS_CODE;
	protected static final int backingClassCode = IBusModelClearSubDep2.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> allClearSubDep2;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > > indexByTenantIdx;
	private Map< IBusModelClearDepByClearDepIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > > indexByClearDepIdx;
	private Map< IBusModelClearDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > > indexByDefSchemaIdx;
	private Map< IBusModelClearSubDep2ByClearSubDep1IdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > > indexByClearSubDep1Idx;
	private Map< IBusModelClearSubDep2ByUNameIdxKey,
		IBusModelClearSubDep2Obj > indexByUNameIdx;
	public static String TABLE_NAME = "ClearSubDep2";
	public static String TABLE_DBNAME = "clrsubdep2";

	public BusModelClearSubDep2TableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj>();
		allClearSubDep2 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearSubDep1Idx = null;
		indexByUNameIdx = null;
	}

	public BusModelClearSubDep2TableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj>();
		allClearSubDep2 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearSubDep1Idx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelClearSubDep2TableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelClearSubDep2TableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allClearSubDep2 = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClearSubDep1Idx = null;
		indexByUNameIdx = null;
		List<IBusModelClearSubDep2Obj> toForget = new LinkedList<IBusModelClearSubDep2Obj>();
		IBusModelClearSubDep2Obj cur = null;
		Iterator<IBusModelClearSubDep2Obj> iter = members.values().iterator();
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
	 *	BusModelClearSubDep2Obj.
	 */
	@Override
	public IBusModelClearSubDep2Obj newInstance() {
		IBusModelClearSubDep2Obj inst = new BusModelClearSubDep2Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelClearSubDep2Obj.
	 */
	@Override
	public IBusModelClearSubDep2EditObj newEditInstance( IBusModelClearSubDep2Obj orig ) {
		IBusModelClearSubDep2EditObj edit = new BusModelClearSubDep2EditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelClearSubDep2Obj realiseClearSubDep2( IBusModelClearSubDep2Obj Obj ) {
		IBusModelClearSubDep2Obj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelClearSubDep2Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelClearSubDep2Obj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				IBusModelClearDepByClearDepIdxKey keyClearDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClearSubDep1Idx != null ) {
				IBusModelClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
				keyClearSubDep1Idx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapClearSubDep1Idx = indexByClearSubDep1Idx.get( keyClearSubDep1Idx );
				if( mapClearSubDep1Idx != null ) {
					mapClearSubDep1Idx.remove( keepObj.getPKey() );
					if( mapClearSubDep1Idx.size() <= 0 ) {
						indexByClearSubDep1Idx.remove( keyClearSubDep1Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelClearSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelClearSubDep2Obj)schema.getClearDepTableObj().realiseClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				IBusModelClearDepByClearDepIdxKey keyClearDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearSubDep1Idx != null ) {
				IBusModelClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
				keyClearSubDep1Idx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapClearSubDep1Idx = indexByClearSubDep1Idx.get( keyClearSubDep1Idx );
				if( mapClearSubDep1Idx != null ) {
					mapClearSubDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelClearSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allClearSubDep2 != null ) {
				allClearSubDep2.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelClearSubDep2Obj)schema.getClearDepTableObj().realiseClearDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearSubDep2 != null ) {
				allClearSubDep2.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				IBusModelClearDepByClearDepIdxKey keyClearDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearSubDep1Idx != null ) {
				IBusModelClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
				keyClearSubDep1Idx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > mapClearSubDep1Idx = indexByClearSubDep1Idx.get( keyClearSubDep1Idx );
				if( mapClearSubDep1Idx != null ) {
					mapClearSubDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelClearSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByUNameIdxKey();
				keyUNameIdx.setRequiredClearSubDep1Id( keepObj.getRequiredClearSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelClearSubDep2Obj createClearSubDep2( IBusModelClearSubDep2Obj Obj ) {
		IBusModelClearSubDep2Obj obj = Obj;
		IBusModelClearSubDep2 rec = obj.getClearSubDep2Rec();
		schema.getBusModelBackingStore().getTableClearSubDep2().createClearSubDep2(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelClearSubDep2Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelClearSubDep2Obj readClearSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		return( readClearSubDep2( pkey, false ) );
	}

	@Override
	public IBusModelClearSubDep2Obj readClearSubDep2( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelClearSubDep2Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelClearSubDep2 readRec = schema.getBusModelBackingStore().getTableClearSubDep2().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelClearSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelClearSubDep2Obj readCachedClearSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelClearSubDep2Obj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeClearSubDep2( IBusModelClearSubDep2Obj obj )
	{
		final String S_ProcName = "BusModelClearSubDep2TableObj.reallyDeepDisposeClearSubDep2() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelClearSubDep2Obj existing = readCachedClearSubDep2( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelClearSubDep2ByClearSubDep1IdxKey keyClearSubDep1Idx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
		keyClearSubDep1Idx.setRequiredClearSubDep1Id( existing.getRequiredClearSubDep1Id() );

		IBusModelClearSubDep2ByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByUNameIdxKey();
		keyUNameIdx.setRequiredClearSubDep1Id( existing.getRequiredClearSubDep1Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		schema.getClearSubDep3TableObj().deepDisposeClearSubDep3ByClearSubDep2Idx( existing.getRequiredId() );

		if( indexByClearSubDep1Idx != null ) {
			if( indexByClearSubDep1Idx.containsKey( keyClearSubDep1Idx ) ) {
				indexByClearSubDep1Idx.get( keyClearSubDep1Idx ).remove( pkey );
				if( indexByClearSubDep1Idx.get( keyClearSubDep1Idx ).size() <= 0 ) {
					indexByClearSubDep1Idx.remove( keyClearSubDep1Idx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


		schema.getClearDepTableObj().reallyDeepDisposeClearDep( obj );
	}
	@Override
	public void deepDisposeClearSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelClearSubDep2Obj obj = readCachedClearSubDep2( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelClearSubDep2Obj lockClearSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelClearSubDep2Obj locked = null;
		IBusModelClearSubDep2 lockRec = schema.getBusModelBackingStore().getTableClearSubDep2().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelClearSubDep2Obj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockClearSubDep2", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readAllClearSubDep2() {
		return( readAllClearSubDep2( false ) );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readAllClearSubDep2( boolean forceRead ) {
		final String S_ProcName = "readAllClearSubDep2";
		if( ( allClearSubDep2 == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelClearSubDep2Obj>();
			allClearSubDep2 = map;
			IBusModelClearSubDep2[] recList = schema.getBusModelBackingStore().getTableClearSubDep2().readAllDerived( null );
			IBusModelClearSubDep2 rec;
			IBusModelClearSubDep2Obj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearSubDep2Obj realised = (IBusModelClearSubDep2Obj)obj.realise();
			}
		}
		int len = allClearSubDep2.size();
		IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
		Iterator<IBusModelClearSubDep2Obj> valIter = allClearSubDep2.values().iterator();
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
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			@Override
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
		List<IBusModelClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readCachedAllClearSubDep2() {
		final String S_ProcName = "readCachedAllClearSubDep2";
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>();
		if( allClearSubDep2 != null ) {
			int len = allClearSubDep2.size();
			IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
			Iterator<IBusModelClearSubDep2Obj> valIter = allClearSubDep2.values().iterator();
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
		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
	public IBusModelClearSubDep2Obj readClearSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		return( readClearSubDep2ByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelClearSubDep2Obj readClearSubDep2ByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelClearSubDep2Obj obj = readClearSubDep2( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readClearSubDep2ByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearSubDep2Obj realised = (IBusModelClearSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
		Iterator<IBusModelClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			@Override
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
		List<IBusModelClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		return( readClearSubDep2ByClearDepIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByClearDepIdx";
		IBusModelClearDepByClearDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict;
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< IBusModelClearDepByClearDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByClearDepIdx.containsKey( key ) ) {
			dict = indexByClearDepIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj>();
			IBusModelClearDepObj obj;
			IBusModelClearDep[] recList = schema.getBusModelBackingStore().getTableClearDep().readDerivedByClearDepIdx( null,
				RelationId );
			IBusModelClearDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearSubDep2Obj realised = (IBusModelClearSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearDepIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
		Iterator<IBusModelClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			@Override
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
		List<IBusModelClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readClearSubDep2ByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByDefSchemaIdx";
		IBusModelClearDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelClearDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj>();
			IBusModelClearDepObj obj;
			IBusModelClearDep[] recList = schema.getBusModelBackingStore().getTableClearDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelClearDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearSubDep2Obj realised = (IBusModelClearSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
		Iterator<IBusModelClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			@Override
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
		List<IBusModelClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id )
	{
		return( readClearSubDep2ByClearSubDep1Idx( ClearSubDep1Id,
			false ) );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id,
		boolean forceRead )
	{
		final String S_ProcName = "readClearSubDep2ByClearSubDep1Idx";
		IBusModelClearSubDep2ByClearSubDep1IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict;
		if( indexByClearSubDep1Idx == null ) {
			indexByClearSubDep1Idx = new HashMap< IBusModelClearSubDep2ByClearSubDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByClearSubDep1Idx.containsKey( key ) ) {
			dict = indexByClearSubDep1Idx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj>();
			IBusModelClearSubDep2Obj obj;
			IBusModelClearSubDep2[] recList = schema.getBusModelBackingStore().getTableClearSubDep2().readDerivedByClearSubDep1Idx( null,
				ClearSubDep1Id );
			IBusModelClearSubDep2 rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearSubDep2Obj realised = (IBusModelClearSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearSubDep1Idx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
		Iterator<IBusModelClearSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			@Override
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
		List<IBusModelClearSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelClearSubDep2Obj readClearSubDep2ByUNameIdx( IYCFKeyHash256 ClearSubDep1Id,
		String Name )
	{
		return( readClearSubDep2ByUNameIdx( ClearSubDep1Id,
			Name,
			false ) );
	}

	@Override
	public IBusModelClearSubDep2Obj readClearSubDep2ByUNameIdx( IYCFKeyHash256 ClearSubDep1Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelClearSubDep2ByUNameIdxKey,
				IBusModelClearSubDep2Obj >();
		}
		IBusModelClearSubDep2ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByUNameIdxKey();
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		key.setRequiredName( Name );
		IBusModelClearSubDep2Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelClearSubDep2 rec = schema.getBusModelBackingStore().getTableClearSubDep2().readDerivedByUNameIdx( null,
				ClearSubDep1Id,
				Name );
			if( rec != null ) {
				obj = (IBusModelClearSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelClearSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelClearSubDep2Obj readCachedClearSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelClearSubDep2Obj obj = null;
		obj = readCachedClearSubDep2( Id );
		return( obj );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> readCachedClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedClearSubDep2ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
				Iterator<IBusModelClearSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelClearSubDep2Obj obj;
			Iterator<IBusModelClearSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			@Override
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
	public List<IBusModelClearSubDep2Obj> readCachedClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedClearSubDep2ByClearDepIdx";
		IBusModelClearDepByClearDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>();
		if( indexByClearDepIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict;
			if( indexByClearDepIdx.containsKey( key ) ) {
				dict = indexByClearDepIdx.get( key );
				int len = dict.size();
				IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
				Iterator<IBusModelClearSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelClearSubDep2Obj obj;
			Iterator<IBusModelClearSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			@Override
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
	public List<IBusModelClearSubDep2Obj> readCachedClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedClearSubDep2ByDefSchemaIdx";
		IBusModelClearDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
				Iterator<IBusModelClearSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelClearSubDep2Obj obj;
			Iterator<IBusModelClearSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			@Override
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
	public List<IBusModelClearSubDep2Obj> readCachedClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id )
	{
		final String S_ProcName = "readCachedClearSubDep2ByClearSubDep1Idx";
		IBusModelClearSubDep2ByClearSubDep1IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		ArrayList<IBusModelClearSubDep2Obj> arrayList = new ArrayList<IBusModelClearSubDep2Obj>();
		if( indexByClearSubDep1Idx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict;
			if( indexByClearSubDep1Idx.containsKey( key ) ) {
				dict = indexByClearSubDep1Idx.get( key );
				int len = dict.size();
				IBusModelClearSubDep2Obj arr[] = new IBusModelClearSubDep2Obj[len];
				Iterator<IBusModelClearSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelClearSubDep2Obj obj;
			Iterator<IBusModelClearSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearSubDep2Obj> cmp = new Comparator<IBusModelClearSubDep2Obj>() {
			@Override
			public int compare( IBusModelClearSubDep2Obj lhs, IBusModelClearSubDep2Obj rhs ) {
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
	public IBusModelClearSubDep2Obj readCachedClearSubDep2ByUNameIdx( IYCFKeyHash256 ClearSubDep1Id,
		String Name )
	{
		IBusModelClearSubDep2Obj obj = null;
		IBusModelClearSubDep2ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByUNameIdxKey();
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelClearSubDep2Obj> valIter = members.values().iterator();
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
			Iterator<IBusModelClearSubDep2Obj> valIter = members.values().iterator();
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
	public void deepDisposeClearSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelClearSubDep2Obj obj = readCachedClearSubDep2ByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeClearSubDep2ByTenantIdx";
		IBusModelClearSubDep2Obj obj;
		List<IBusModelClearSubDep2Obj> arrayList = readCachedClearSubDep2ByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelClearSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposeClearSubDep2ByClearDepIdx";
		IBusModelClearSubDep2Obj obj;
		List<IBusModelClearSubDep2Obj> arrayList = readCachedClearSubDep2ByClearDepIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelClearSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeClearSubDep2ByDefSchemaIdx";
		IBusModelClearSubDep2Obj obj;
		List<IBusModelClearSubDep2Obj> arrayList = readCachedClearSubDep2ByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelClearSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id )
	{
		final String S_ProcName = "deepDisposeClearSubDep2ByClearSubDep1Idx";
		IBusModelClearSubDep2Obj obj;
		List<IBusModelClearSubDep2Obj> arrayList = readCachedClearSubDep2ByClearSubDep1Idx( ClearSubDep1Id );
		if( arrayList != null )  {
			Iterator<IBusModelClearSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearSubDep2ByUNameIdx( IYCFKeyHash256 ClearSubDep1Id,
		String Name )
	{
		IBusModelClearSubDep2Obj obj = readCachedClearSubDep2ByUNameIdx( ClearSubDep1Id,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelClearSubDep2Obj updateClearSubDep2( IBusModelClearSubDep2Obj Obj ) {
		IBusModelClearSubDep2Obj obj = Obj;
		schema.getBusModelBackingStore().getTableClearSubDep2().updateClearSubDep2( null,
			Obj.getClearSubDep2Rec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getClearSubDep2TableObj().getClassCode() ) {
			obj = (IBusModelClearSubDep2Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteClearSubDep2( IBusModelClearSubDep2Obj Obj ) {
		IBusModelClearSubDep2Obj obj = Obj;
		schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2( null,
			obj.getClearSubDep2Rec() );
		Obj.forget();
	}

	@Override
	public void deleteClearSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelClearSubDep2Obj obj = readClearSubDep2(Id);
		if( obj != null ) {
			IBusModelClearSubDep2EditObj editObj = (IBusModelClearSubDep2EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelClearSubDep2EditObj)obj.beginEdit();
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
		deepDisposeClearSubDep2ByIdIdx( Id );
	}

	@Override
	public void deleteClearSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByTenantIdx( null,
				TenantId );
			Iterator<IBusModelClearSubDep2Obj> iter = dict.values().iterator();
			IBusModelClearSubDep2Obj obj;
			List<IBusModelClearSubDep2Obj> toForget = new LinkedList<IBusModelClearSubDep2Obj>();
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
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByTenantIdx( null,
				TenantId );
		}
		deepDisposeClearSubDep2ByTenantIdx( TenantId );
	}

	@Override
	public void deleteClearSubDep2ByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelClearDepByClearDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< IBusModelClearDepByClearDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > >();
		}
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict = indexByClearDepIdx.get( key );
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByClearDepIdx( null,
				RelationId );
			Iterator<IBusModelClearSubDep2Obj> iter = dict.values().iterator();
			IBusModelClearSubDep2Obj obj;
			List<IBusModelClearSubDep2Obj> toForget = new LinkedList<IBusModelClearSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByClearDepIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByClearDepIdx( null,
				RelationId );
		}
		deepDisposeClearSubDep2ByClearDepIdx( RelationId );
	}

	@Override
	public void deleteClearSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelClearDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelClearDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelClearSubDep2Obj> iter = dict.values().iterator();
			IBusModelClearSubDep2Obj obj;
			List<IBusModelClearSubDep2Obj> toForget = new LinkedList<IBusModelClearSubDep2Obj>();
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
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeClearSubDep2ByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteClearSubDep2ByClearSubDep1Idx( IYCFKeyHash256 ClearSubDep1Id )
	{
		IBusModelClearSubDep2ByClearSubDep1IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByClearSubDep1IdxKey();
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		if( indexByClearSubDep1Idx == null ) {
			indexByClearSubDep1Idx = new HashMap< IBusModelClearSubDep2ByClearSubDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj > >();
		}
		if( indexByClearSubDep1Idx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearSubDep2Obj> dict = indexByClearSubDep1Idx.get( key );
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByClearSubDep1Idx( null,
				ClearSubDep1Id );
			Iterator<IBusModelClearSubDep2Obj> iter = dict.values().iterator();
			IBusModelClearSubDep2Obj obj;
			List<IBusModelClearSubDep2Obj> toForget = new LinkedList<IBusModelClearSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByClearSubDep1Idx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByClearSubDep1Idx( null,
				ClearSubDep1Id );
		}
		deepDisposeClearSubDep2ByClearSubDep1Idx( ClearSubDep1Id );
	}

	@Override
	public void deleteClearSubDep2ByUNameIdx( IYCFKeyHash256 ClearSubDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelClearSubDep2ByUNameIdxKey,
				IBusModelClearSubDep2Obj >();
		}
		IBusModelClearSubDep2ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newByUNameIdxKey();
		key.setRequiredClearSubDep1Id( ClearSubDep1Id );
		key.setRequiredName( Name );
		IBusModelClearSubDep2Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByUNameIdx( null,
				ClearSubDep1Id,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableClearSubDep2().deleteClearSubDep2ByUNameIdx( null,
				ClearSubDep1Id,
				Name );
		}
		deepDisposeClearSubDep2ByUNameIdx( ClearSubDep1Id,
				Name );
	}
}