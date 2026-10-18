// Description: Java 25 Table Object implementation for ServerListFunc.

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

public class BusModelServerListFuncTableObj
	implements IBusModelServerListFuncTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelServerListFunc.CLASS_CODE;
	protected static final int backingClassCode = IBusModelServerListFunc.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> allServerListFunc;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > > indexByTenantIdx;
	private Map< IBusModelServerMethodByUNameIdxKey,
		IBusModelServerListFuncObj > indexByUNameIdx;
	private Map< IBusModelServerMethodByMethTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > > indexByMethTableIdx;
	private Map< IBusModelServerMethodByMethCodeVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > > indexByMethCodeVisIdx;
	private Map< IBusModelServerMethodByMethTableVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > > indexByMethTableVisIdx;
	private Map< IBusModelServerMethodByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > > indexByDefSchemaIdx;
	private Map< IBusModelServerListFuncByRetTblIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > > indexByRetTblIdx;
	public static String TABLE_NAME = "ServerListFunc";
	public static String TABLE_DBNAME = "srvlfunc";

	public BusModelServerListFuncTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj>();
		allServerListFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
	}

	public BusModelServerListFuncTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj>();
		allServerListFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelServerListFuncTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelServerListFuncTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allServerListFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
		List<IBusModelServerListFuncObj> toForget = new LinkedList<IBusModelServerListFuncObj>();
		IBusModelServerListFuncObj cur = null;
		Iterator<IBusModelServerListFuncObj> iter = members.values().iterator();
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
	 *	BusModelServerListFuncObj.
	 */
	@Override
	public IBusModelServerListFuncObj newInstance() {
		IBusModelServerListFuncObj inst = new BusModelServerListFuncObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelServerListFuncObj.
	 */
	@Override
	public IBusModelServerListFuncEditObj newEditInstance( IBusModelServerListFuncObj orig ) {
		IBusModelServerListFuncEditObj edit = new BusModelServerListFuncEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelServerListFuncObj realiseServerListFunc( IBusModelServerListFuncObj Obj ) {
		IBusModelServerListFuncObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelServerListFuncObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelServerListFuncObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelServerMethodByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByMethTableIdx != null ) {
				IBusModelServerMethodByMethTableIdxKey keyMethTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
				keyMethTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					indexByMethTableIdx.remove( keyMethTableIdx );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					indexByMethCodeVisIdx.remove( keyMethCodeVisIdx );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					indexByMethTableVisIdx.remove( keyMethTableVisIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByRetTblIdx != null ) {
				IBusModelServerListFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerListFunc().newByRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.remove( keepObj.getPKey() );
					if( mapRetTblIdx.size() <= 0 ) {
						indexByRetTblIdx.remove( keyRetTblIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelServerListFuncObj)schema.getServerMethodTableObj().realiseServerMethod( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelServerMethodByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByMethTableIdx != null ) {
				IBusModelServerMethodByMethTableIdxKey keyMethTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
				keyMethTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					mapMethCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					mapMethTableVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				IBusModelServerListFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerListFunc().newByRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allServerListFunc != null ) {
				allServerListFunc.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelServerListFuncObj)schema.getServerMethodTableObj().realiseServerMethod( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allServerListFunc != null ) {
				allServerListFunc.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelServerMethodByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByMethTableIdx != null ) {
				IBusModelServerMethodByMethTableIdxKey keyMethTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
				keyMethTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					mapMethCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					mapMethTableVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				IBusModelServerListFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerListFunc().newByRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelServerListFuncObj createServerListFunc( IBusModelServerListFuncObj Obj ) {
		IBusModelServerListFuncObj obj = Obj;
		IBusModelServerListFunc rec = obj.getServerListFuncRec();
		schema.getBusModelBackingStore().getTableServerListFunc().createServerListFunc(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelServerListFuncObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelServerListFuncObj readServerListFunc( $implCommaIJavaOptAtomType$ pkey ) {
		return( readServerListFunc( pkey, false ) );
	}

	@Override
	public IBusModelServerListFuncObj readServerListFunc( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelServerListFuncObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelServerListFunc readRec = schema.getBusModelBackingStore().getTableServerListFunc().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelServerListFuncObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelServerListFuncObj readCachedServerListFunc( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerListFuncObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeServerListFunc( IBusModelServerListFuncObj obj )
	{
		final String S_ProcName = "BusModelServerListFuncTableObj.reallyDeepDisposeServerListFunc() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelServerListFuncObj existing = readCachedServerListFunc( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelServerListFuncByRetTblIdxKey keyRetTblIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerListFunc().newByRetTblIdxKey();
		keyRetTblIdx.setOptionalRetTableId( existing.getOptionalRetTableId() );


		schema.getParamTableObj().deepDisposeParamByServerMethodIdx( existing.getRequiredId() );

		if( indexByRetTblIdx != null ) {
			if( indexByRetTblIdx.containsKey( keyRetTblIdx ) ) {
				indexByRetTblIdx.get( keyRetTblIdx ).remove( pkey );
				if( indexByRetTblIdx.get( keyRetTblIdx ).size() <= 0 ) {
					indexByRetTblIdx.remove( keyRetTblIdx );
				}
			}
		}


		schema.getServerMethodTableObj().reallyDeepDisposeServerMethod( obj );
	}
	@Override
	public void deepDisposeServerListFunc( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerListFuncObj obj = readCachedServerListFunc( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelServerListFuncObj lockServerListFunc( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerListFuncObj locked = null;
		IBusModelServerListFunc lockRec = schema.getBusModelBackingStore().getTableServerListFunc().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelServerListFuncObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockServerListFunc", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelServerListFuncObj> readAllServerListFunc() {
		return( readAllServerListFunc( false ) );
	}

	@Override
	public List<IBusModelServerListFuncObj> readAllServerListFunc( boolean forceRead ) {
		final String S_ProcName = "readAllServerListFunc";
		if( ( allServerListFunc == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelServerListFuncObj>();
			allServerListFunc = map;
			IBusModelServerListFunc[] recList = schema.getBusModelBackingStore().getTableServerListFunc().readAllDerived( null );
			IBusModelServerListFunc rec;
			IBusModelServerListFuncObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerListFuncObj realised = (IBusModelServerListFuncObj)obj.realise();
			}
		}
		int len = allServerListFunc.size();
		IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
		Iterator<IBusModelServerListFuncObj> valIter = allServerListFunc.values().iterator();
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
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
		List<IBusModelServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerListFuncObj> readCachedAllServerListFunc() {
		final String S_ProcName = "readCachedAllServerListFunc";
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>();
		if( allServerListFunc != null ) {
			int len = allServerListFunc.size();
			IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
			Iterator<IBusModelServerListFuncObj> valIter = allServerListFunc.values().iterator();
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
		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
	public IBusModelServerListFuncObj readServerListFuncByIdIdx( IYCFKeyHash256 Id )
	{
		return( readServerListFuncByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelServerListFuncObj readServerListFuncByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelServerListFuncObj obj = readServerListFunc( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readServerListFuncByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerListFuncObj realised = (IBusModelServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
		Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
		List<IBusModelServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelServerListFuncObj readServerListFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		return( readServerListFuncByUNameIdx( TableId,
			Name,
			false ) );
	}

	@Override
	public IBusModelServerListFuncObj readServerListFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelServerMethodByUNameIdxKey,
				IBusModelServerListFuncObj >();
		}
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelServerListFuncObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelServerMethod rec = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByUNameIdx( null,
				TableId,
				Name );
			if( rec != null ) {
				obj = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelServerListFuncObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByMethTableIdx( IYCFKeyHash256 TableId )
	{
		return( readServerListFuncByMethTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByMethTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByMethTableIdx";
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< IBusModelServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableIdx.containsKey( key ) ) {
			dict = indexByMethTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethTableIdx( null,
				TableId );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerListFuncObj realised = (IBusModelServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
		Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
		List<IBusModelServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readServerListFuncByMethCodeVisIdx( CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByMethCodeVisIdx";
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
		if( indexByMethCodeVisIdx == null ) {
			indexByMethCodeVisIdx = new HashMap< IBusModelServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByMethCodeVisIdx.containsKey( key ) ) {
			dict = indexByMethCodeVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethCodeVisIdx( null,
				CodeVis );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerListFuncObj realised = (IBusModelServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethCodeVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
		Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
		List<IBusModelServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readServerListFuncByMethTableVisIdx( TableId,
			CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByMethTableVisIdx";
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
		if( indexByMethTableVisIdx == null ) {
			indexByMethTableVisIdx = new HashMap< IBusModelServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableVisIdx.containsKey( key ) ) {
			dict = indexByMethTableVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethTableVisIdx( null,
				TableId,
				CodeVis );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerListFuncObj realised = (IBusModelServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
		Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
		List<IBusModelServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readServerListFuncByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByDefSchemaIdx";
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerListFuncObj realised = (IBusModelServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
		Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
		List<IBusModelServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByRetTblIdx( IYCFKeyHash256 RetTableId )
	{
		return( readServerListFuncByRetTblIdx( RetTableId,
			false ) );
	}

	@Override
	public List<IBusModelServerListFuncObj> readServerListFuncByRetTblIdx( IYCFKeyHash256 RetTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerListFuncByRetTblIdx";
		IBusModelServerListFuncByRetTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerListFunc().newByRetTblIdxKey();
		key.setOptionalRetTableId( RetTableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< IBusModelServerListFuncByRetTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( ( ! forceRead ) && indexByRetTblIdx.containsKey( key ) ) {
			dict = indexByRetTblIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj>();
			IBusModelServerListFuncObj obj;
			IBusModelServerListFunc[] recList = schema.getBusModelBackingStore().getTableServerListFunc().readDerivedByRetTblIdx( null,
				RetTableId );
			IBusModelServerListFunc rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerListFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerListFuncObj realised = (IBusModelServerListFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRetTblIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
		Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
		List<IBusModelServerListFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelServerListFuncObj readCachedServerListFuncByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerListFuncObj obj = null;
		obj = readCachedServerListFunc( Id );
		return( obj );
	}

	@Override
	public List<IBusModelServerListFuncObj> readCachedServerListFuncByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedServerListFuncByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
				Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerListFuncObj obj;
			Iterator<IBusModelServerListFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
	public IBusModelServerListFuncObj readCachedServerListFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelServerListFuncObj obj = null;
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelServerListFuncObj> valIter = members.values().iterator();
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
			Iterator<IBusModelServerListFuncObj> valIter = members.values().iterator();
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
	public List<IBusModelServerListFuncObj> readCachedServerListFuncByMethTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedServerListFuncByMethTableIdx";
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>();
		if( indexByMethTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
			if( indexByMethTableIdx.containsKey( key ) ) {
				dict = indexByMethTableIdx.get( key );
				int len = dict.size();
				IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
				Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerListFuncObj obj;
			Iterator<IBusModelServerListFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
	public List<IBusModelServerListFuncObj> readCachedServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedServerListFuncByMethCodeVisIdx";
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>();
		if( indexByMethCodeVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
			if( indexByMethCodeVisIdx.containsKey( key ) ) {
				dict = indexByMethCodeVisIdx.get( key );
				int len = dict.size();
				IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
				Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerListFuncObj obj;
			Iterator<IBusModelServerListFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
	public List<IBusModelServerListFuncObj> readCachedServerListFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedServerListFuncByMethTableVisIdx";
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>();
		if( indexByMethTableVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
			if( indexByMethTableVisIdx.containsKey( key ) ) {
				dict = indexByMethTableVisIdx.get( key );
				int len = dict.size();
				IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
				Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerListFuncObj obj;
			Iterator<IBusModelServerListFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
	public List<IBusModelServerListFuncObj> readCachedServerListFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedServerListFuncByDefSchemaIdx";
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
				Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerListFuncObj obj;
			Iterator<IBusModelServerListFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
	public List<IBusModelServerListFuncObj> readCachedServerListFuncByRetTblIdx( IYCFKeyHash256 RetTableId )
	{
		final String S_ProcName = "readCachedServerListFuncByRetTblIdx";
		IBusModelServerListFuncByRetTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerListFunc().newByRetTblIdxKey();
		key.setOptionalRetTableId( RetTableId );
		ArrayList<IBusModelServerListFuncObj> arrayList = new ArrayList<IBusModelServerListFuncObj>();
		if( indexByRetTblIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict;
			if( indexByRetTblIdx.containsKey( key ) ) {
				dict = indexByRetTblIdx.get( key );
				int len = dict.size();
				IBusModelServerListFuncObj arr[] = new IBusModelServerListFuncObj[len];
				Iterator<IBusModelServerListFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerListFuncObj obj;
			Iterator<IBusModelServerListFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerListFuncObj> cmp = new Comparator<IBusModelServerListFuncObj>() {
			@Override
			public int compare( IBusModelServerListFuncObj lhs, IBusModelServerListFuncObj rhs ) {
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
	public void deepDisposeServerListFuncByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerListFuncObj obj = readCachedServerListFuncByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeServerListFuncByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeServerListFuncByTenantIdx";
		IBusModelServerListFuncObj obj;
		List<IBusModelServerListFuncObj> arrayList = readCachedServerListFuncByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelServerListFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerListFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelServerListFuncObj obj = readCachedServerListFuncByUNameIdx( TableId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeServerListFuncByMethTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeServerListFuncByMethTableIdx";
		IBusModelServerListFuncObj obj;
		List<IBusModelServerListFuncObj> arrayList = readCachedServerListFuncByMethTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelServerListFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeServerListFuncByMethCodeVisIdx";
		IBusModelServerListFuncObj obj;
		List<IBusModelServerListFuncObj> arrayList = readCachedServerListFuncByMethCodeVisIdx( CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelServerListFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerListFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeServerListFuncByMethTableVisIdx";
		IBusModelServerListFuncObj obj;
		List<IBusModelServerListFuncObj> arrayList = readCachedServerListFuncByMethTableVisIdx( TableId,
				CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelServerListFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerListFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeServerListFuncByDefSchemaIdx";
		IBusModelServerListFuncObj obj;
		List<IBusModelServerListFuncObj> arrayList = readCachedServerListFuncByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelServerListFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerListFuncByRetTblIdx( IYCFKeyHash256 RetTableId )
	{
		final String S_ProcName = "deepDisposeServerListFuncByRetTblIdx";
		IBusModelServerListFuncObj obj;
		List<IBusModelServerListFuncObj> arrayList = readCachedServerListFuncByRetTblIdx( RetTableId );
		if( arrayList != null )  {
			Iterator<IBusModelServerListFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelServerListFuncObj updateServerListFunc( IBusModelServerListFuncObj Obj ) {
		IBusModelServerListFuncObj obj = Obj;
		schema.getBusModelBackingStore().getTableServerListFunc().updateServerListFunc( null,
			Obj.getServerListFuncRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getServerListFuncTableObj().getClassCode() ) {
			obj = (IBusModelServerListFuncObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteServerListFunc( IBusModelServerListFuncObj Obj ) {
		IBusModelServerListFuncObj obj = Obj;
		schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFunc( null,
			obj.getServerListFuncRec() );
		Obj.forget();
	}

	@Override
	public void deleteServerListFuncByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerListFuncObj obj = readServerListFunc(Id);
		if( obj != null ) {
			IBusModelServerListFuncEditObj editObj = (IBusModelServerListFuncEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelServerListFuncEditObj)obj.beginEdit();
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
		deepDisposeServerListFuncByIdIdx( Id );
	}

	@Override
	public void deleteServerListFuncByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByTenantIdx( null,
				TenantId );
			Iterator<IBusModelServerListFuncObj> iter = dict.values().iterator();
			IBusModelServerListFuncObj obj;
			List<IBusModelServerListFuncObj> toForget = new LinkedList<IBusModelServerListFuncObj>();
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
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByTenantIdx( null,
				TenantId );
		}
		deepDisposeServerListFuncByTenantIdx( TenantId );
	}

	@Override
	public void deleteServerListFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelServerMethodByUNameIdxKey,
				IBusModelServerListFuncObj >();
		}
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelServerListFuncObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByUNameIdx( null,
				TableId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByUNameIdx( null,
				TableId,
				Name );
		}
		deepDisposeServerListFuncByUNameIdx( TableId,
				Name );
	}

	@Override
	public void deleteServerListFuncByMethTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< IBusModelServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( indexByMethTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict = indexByMethTableIdx.get( key );
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByMethTableIdx( null,
				TableId );
			Iterator<IBusModelServerListFuncObj> iter = dict.values().iterator();
			IBusModelServerListFuncObj obj;
			List<IBusModelServerListFuncObj> toForget = new LinkedList<IBusModelServerListFuncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByMethTableIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByMethTableIdx( null,
				TableId );
		}
		deepDisposeServerListFuncByMethTableIdx( TableId );
	}

	@Override
	public void deleteServerListFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		if( indexByMethCodeVisIdx == null ) {
			indexByMethCodeVisIdx = new HashMap< IBusModelServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( indexByMethCodeVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict = indexByMethCodeVisIdx.get( key );
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByMethCodeVisIdx( null,
				CodeVis );
			Iterator<IBusModelServerListFuncObj> iter = dict.values().iterator();
			IBusModelServerListFuncObj obj;
			List<IBusModelServerListFuncObj> toForget = new LinkedList<IBusModelServerListFuncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByMethCodeVisIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByMethCodeVisIdx( null,
				CodeVis );
		}
		deepDisposeServerListFuncByMethCodeVisIdx( CodeVis );
	}

	@Override
	public void deleteServerListFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		if( indexByMethTableVisIdx == null ) {
			indexByMethTableVisIdx = new HashMap< IBusModelServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( indexByMethTableVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict = indexByMethTableVisIdx.get( key );
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByMethTableVisIdx( null,
				TableId,
				CodeVis );
			Iterator<IBusModelServerListFuncObj> iter = dict.values().iterator();
			IBusModelServerListFuncObj obj;
			List<IBusModelServerListFuncObj> toForget = new LinkedList<IBusModelServerListFuncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByMethTableVisIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByMethTableVisIdx( null,
				TableId,
				CodeVis );
		}
		deepDisposeServerListFuncByMethTableVisIdx( TableId,
				CodeVis );
	}

	@Override
	public void deleteServerListFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelServerListFuncObj> iter = dict.values().iterator();
			IBusModelServerListFuncObj obj;
			List<IBusModelServerListFuncObj> toForget = new LinkedList<IBusModelServerListFuncObj>();
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
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeServerListFuncByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteServerListFuncByRetTblIdx( IYCFKeyHash256 RetTableId )
	{
		IBusModelServerListFuncByRetTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerListFunc().newByRetTblIdxKey();
		key.setOptionalRetTableId( RetTableId );
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< IBusModelServerListFuncByRetTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerListFuncObj > >();
		}
		if( indexByRetTblIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerListFuncObj> dict = indexByRetTblIdx.get( key );
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByRetTblIdx( null,
				RetTableId );
			Iterator<IBusModelServerListFuncObj> iter = dict.values().iterator();
			IBusModelServerListFuncObj obj;
			List<IBusModelServerListFuncObj> toForget = new LinkedList<IBusModelServerListFuncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByRetTblIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableServerListFunc().deleteServerListFuncByRetTblIdx( null,
				RetTableId );
		}
		deepDisposeServerListFuncByRetTblIdx( RetTableId );
	}
}