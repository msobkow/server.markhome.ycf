// Description: Java 25 Table Object implementation for ServerObjFunc.

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

public class BusModelServerObjFuncTableObj
	implements IBusModelServerObjFuncTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelServerObjFunc.CLASS_CODE;
	protected static final int backingClassCode = IBusModelServerObjFunc.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> allServerObjFunc;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > > indexByTenantIdx;
	private Map< IBusModelServerMethodByUNameIdxKey,
		IBusModelServerObjFuncObj > indexByUNameIdx;
	private Map< IBusModelServerMethodByMethTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > > indexByMethTableIdx;
	private Map< IBusModelServerMethodByMethCodeVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > > indexByMethCodeVisIdx;
	private Map< IBusModelServerMethodByMethTableVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > > indexByMethTableVisIdx;
	private Map< IBusModelServerMethodByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > > indexByDefSchemaIdx;
	private Map< IBusModelServerObjFuncByRetTblIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > > indexByRetTblIdx;
	public static String TABLE_NAME = "ServerObjFunc";
	public static String TABLE_DBNAME = "srvofunc";

	public BusModelServerObjFuncTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj>();
		allServerObjFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
	}

	public BusModelServerObjFuncTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj>();
		allServerObjFunc = null;
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
		return BusModelServerObjFuncTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelServerObjFuncTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allServerObjFunc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
		indexByRetTblIdx = null;
		List<IBusModelServerObjFuncObj> toForget = new LinkedList<IBusModelServerObjFuncObj>();
		IBusModelServerObjFuncObj cur = null;
		Iterator<IBusModelServerObjFuncObj> iter = members.values().iterator();
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
	 *	BusModelServerObjFuncObj.
	 */
	@Override
	public IBusModelServerObjFuncObj newInstance() {
		IBusModelServerObjFuncObj inst = new BusModelServerObjFuncObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelServerObjFuncObj.
	 */
	@Override
	public IBusModelServerObjFuncEditObj newEditInstance( IBusModelServerObjFuncObj orig ) {
		IBusModelServerObjFuncEditObj edit = new BusModelServerObjFuncEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelServerObjFuncObj realiseServerObjFunc( IBusModelServerObjFuncObj Obj ) {
		IBusModelServerObjFuncObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelServerObjFuncObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelServerObjFuncObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					indexByMethTableIdx.remove( keyMethTableIdx );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					indexByMethCodeVisIdx.remove( keyMethCodeVisIdx );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					indexByMethTableVisIdx.remove( keyMethTableVisIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByRetTblIdx != null ) {
				IBusModelServerObjFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
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
			keepObj = (IBusModelServerObjFuncObj)schema.getServerMethodTableObj().realiseServerMethod( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					mapMethCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					mapMethTableVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				IBusModelServerObjFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allServerObjFunc != null ) {
				allServerObjFunc.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelServerObjFuncObj)schema.getServerMethodTableObj().realiseServerMethod( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allServerObjFunc != null ) {
				allServerObjFunc.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					mapMethCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					mapMethTableVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRetTblIdx != null ) {
				IBusModelServerObjFuncByRetTblIdxKey keyRetTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
				keyRetTblIdx.setOptionalRetTableId( keepObj.getOptionalRetTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > mapRetTblIdx = indexByRetTblIdx.get( keyRetTblIdx );
				if( mapRetTblIdx != null ) {
					mapRetTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelServerObjFuncObj createServerObjFunc( IBusModelServerObjFuncObj Obj ) {
		IBusModelServerObjFuncObj obj = Obj;
		IBusModelServerObjFunc rec = obj.getServerObjFuncRec();
		schema.getBusModelBackingStore().getTableServerObjFunc().createServerObjFunc(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelServerObjFuncObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelServerObjFuncObj readServerObjFunc( $implCommaIJavaOptAtomType$ pkey ) {
		return( readServerObjFunc( pkey, false ) );
	}

	@Override
	public IBusModelServerObjFuncObj readServerObjFunc( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelServerObjFuncObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelServerObjFunc readRec = schema.getBusModelBackingStore().getTableServerObjFunc().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelServerObjFuncObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelServerObjFuncObj readCachedServerObjFunc( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerObjFuncObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeServerObjFunc( IBusModelServerObjFuncObj obj )
	{
		final String S_ProcName = "BusModelServerObjFuncTableObj.reallyDeepDisposeServerObjFunc() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelServerObjFuncObj existing = readCachedServerObjFunc( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelServerObjFuncByRetTblIdxKey keyRetTblIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
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
	public void deepDisposeServerObjFunc( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerObjFuncObj obj = readCachedServerObjFunc( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelServerObjFuncObj lockServerObjFunc( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerObjFuncObj locked = null;
		IBusModelServerObjFunc lockRec = schema.getBusModelBackingStore().getTableServerObjFunc().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelServerObjFuncObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockServerObjFunc", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readAllServerObjFunc() {
		return( readAllServerObjFunc( false ) );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readAllServerObjFunc( boolean forceRead ) {
		final String S_ProcName = "readAllServerObjFunc";
		if( ( allServerObjFunc == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelServerObjFuncObj>();
			allServerObjFunc = map;
			IBusModelServerObjFunc[] recList = schema.getBusModelBackingStore().getTableServerObjFunc().readAllDerived( null );
			IBusModelServerObjFunc rec;
			IBusModelServerObjFuncObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerObjFuncObj realised = (IBusModelServerObjFuncObj)obj.realise();
			}
		}
		int len = allServerObjFunc.size();
		IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
		Iterator<IBusModelServerObjFuncObj> valIter = allServerObjFunc.values().iterator();
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
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
		List<IBusModelServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readCachedAllServerObjFunc() {
		final String S_ProcName = "readCachedAllServerObjFunc";
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>();
		if( allServerObjFunc != null ) {
			int len = allServerObjFunc.size();
			IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
			Iterator<IBusModelServerObjFuncObj> valIter = allServerObjFunc.values().iterator();
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
		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
	public IBusModelServerObjFuncObj readServerObjFuncByIdIdx( IYCFKeyHash256 Id )
	{
		return( readServerObjFuncByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelServerObjFuncObj readServerObjFuncByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelServerObjFuncObj obj = readServerObjFunc( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readServerObjFuncByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerObjFuncObj realised = (IBusModelServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
		Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
		List<IBusModelServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelServerObjFuncObj readServerObjFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		return( readServerObjFuncByUNameIdx( TableId,
			Name,
			false ) );
	}

	@Override
	public IBusModelServerObjFuncObj readServerObjFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelServerMethodByUNameIdxKey,
				IBusModelServerObjFuncObj >();
		}
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelServerObjFuncObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelServerMethod rec = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByUNameIdx( null,
				TableId,
				Name );
			if( rec != null ) {
				obj = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelServerObjFuncObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByMethTableIdx( IYCFKeyHash256 TableId )
	{
		return( readServerObjFuncByMethTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByMethTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByMethTableIdx";
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< IBusModelServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableIdx.containsKey( key ) ) {
			dict = indexByMethTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethTableIdx( null,
				TableId );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerObjFuncObj realised = (IBusModelServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
		Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
		List<IBusModelServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readServerObjFuncByMethCodeVisIdx( CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByMethCodeVisIdx";
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
		if( indexByMethCodeVisIdx == null ) {
			indexByMethCodeVisIdx = new HashMap< IBusModelServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByMethCodeVisIdx.containsKey( key ) ) {
			dict = indexByMethCodeVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethCodeVisIdx( null,
				CodeVis );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerObjFuncObj realised = (IBusModelServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethCodeVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
		Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
		List<IBusModelServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readServerObjFuncByMethTableVisIdx( TableId,
			CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByMethTableVisIdx";
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
		if( indexByMethTableVisIdx == null ) {
			indexByMethTableVisIdx = new HashMap< IBusModelServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableVisIdx.containsKey( key ) ) {
			dict = indexByMethTableVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethTableVisIdx( null,
				TableId,
				CodeVis );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerObjFuncObj realised = (IBusModelServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
		Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
		List<IBusModelServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readServerObjFuncByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByDefSchemaIdx";
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerObjFuncObj realised = (IBusModelServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
		Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
		List<IBusModelServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByRetTblIdx( IYCFKeyHash256 RetTableId )
	{
		return( readServerObjFuncByRetTblIdx( RetTableId,
			false ) );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readServerObjFuncByRetTblIdx( IYCFKeyHash256 RetTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerObjFuncByRetTblIdx";
		IBusModelServerObjFuncByRetTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
		key.setOptionalRetTableId( RetTableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< IBusModelServerObjFuncByRetTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( ( ! forceRead ) && indexByRetTblIdx.containsKey( key ) ) {
			dict = indexByRetTblIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj>();
			IBusModelServerObjFuncObj obj;
			IBusModelServerObjFunc[] recList = schema.getBusModelBackingStore().getTableServerObjFunc().readDerivedByRetTblIdx( null,
				RetTableId );
			IBusModelServerObjFunc rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerObjFuncObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerObjFuncObj realised = (IBusModelServerObjFuncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRetTblIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
		Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
		List<IBusModelServerObjFuncObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelServerObjFuncObj readCachedServerObjFuncByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerObjFuncObj obj = null;
		obj = readCachedServerObjFunc( Id );
		return( obj );
	}

	@Override
	public List<IBusModelServerObjFuncObj> readCachedServerObjFuncByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedServerObjFuncByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
				Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerObjFuncObj obj;
			Iterator<IBusModelServerObjFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
	public IBusModelServerObjFuncObj readCachedServerObjFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelServerObjFuncObj obj = null;
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelServerObjFuncObj> valIter = members.values().iterator();
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
			Iterator<IBusModelServerObjFuncObj> valIter = members.values().iterator();
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
	public List<IBusModelServerObjFuncObj> readCachedServerObjFuncByMethTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedServerObjFuncByMethTableIdx";
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>();
		if( indexByMethTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
			if( indexByMethTableIdx.containsKey( key ) ) {
				dict = indexByMethTableIdx.get( key );
				int len = dict.size();
				IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
				Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerObjFuncObj obj;
			Iterator<IBusModelServerObjFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
	public List<IBusModelServerObjFuncObj> readCachedServerObjFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedServerObjFuncByMethCodeVisIdx";
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>();
		if( indexByMethCodeVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
			if( indexByMethCodeVisIdx.containsKey( key ) ) {
				dict = indexByMethCodeVisIdx.get( key );
				int len = dict.size();
				IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
				Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerObjFuncObj obj;
			Iterator<IBusModelServerObjFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
	public List<IBusModelServerObjFuncObj> readCachedServerObjFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedServerObjFuncByMethTableVisIdx";
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>();
		if( indexByMethTableVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
			if( indexByMethTableVisIdx.containsKey( key ) ) {
				dict = indexByMethTableVisIdx.get( key );
				int len = dict.size();
				IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
				Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerObjFuncObj obj;
			Iterator<IBusModelServerObjFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
	public List<IBusModelServerObjFuncObj> readCachedServerObjFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedServerObjFuncByDefSchemaIdx";
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
				Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerObjFuncObj obj;
			Iterator<IBusModelServerObjFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
	public List<IBusModelServerObjFuncObj> readCachedServerObjFuncByRetTblIdx( IYCFKeyHash256 RetTableId )
	{
		final String S_ProcName = "readCachedServerObjFuncByRetTblIdx";
		IBusModelServerObjFuncByRetTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
		key.setOptionalRetTableId( RetTableId );
		ArrayList<IBusModelServerObjFuncObj> arrayList = new ArrayList<IBusModelServerObjFuncObj>();
		if( indexByRetTblIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict;
			if( indexByRetTblIdx.containsKey( key ) ) {
				dict = indexByRetTblIdx.get( key );
				int len = dict.size();
				IBusModelServerObjFuncObj arr[] = new IBusModelServerObjFuncObj[len];
				Iterator<IBusModelServerObjFuncObj> valIter = dict.values().iterator();
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
			IBusModelServerObjFuncObj obj;
			Iterator<IBusModelServerObjFuncObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerObjFuncObj> cmp = new Comparator<IBusModelServerObjFuncObj>() {
			@Override
			public int compare( IBusModelServerObjFuncObj lhs, IBusModelServerObjFuncObj rhs ) {
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
	public void deepDisposeServerObjFuncByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerObjFuncObj obj = readCachedServerObjFuncByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeServerObjFuncByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeServerObjFuncByTenantIdx";
		IBusModelServerObjFuncObj obj;
		List<IBusModelServerObjFuncObj> arrayList = readCachedServerObjFuncByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelServerObjFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerObjFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelServerObjFuncObj obj = readCachedServerObjFuncByUNameIdx( TableId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeServerObjFuncByMethTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeServerObjFuncByMethTableIdx";
		IBusModelServerObjFuncObj obj;
		List<IBusModelServerObjFuncObj> arrayList = readCachedServerObjFuncByMethTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelServerObjFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerObjFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeServerObjFuncByMethCodeVisIdx";
		IBusModelServerObjFuncObj obj;
		List<IBusModelServerObjFuncObj> arrayList = readCachedServerObjFuncByMethCodeVisIdx( CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelServerObjFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerObjFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeServerObjFuncByMethTableVisIdx";
		IBusModelServerObjFuncObj obj;
		List<IBusModelServerObjFuncObj> arrayList = readCachedServerObjFuncByMethTableVisIdx( TableId,
				CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelServerObjFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerObjFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeServerObjFuncByDefSchemaIdx";
		IBusModelServerObjFuncObj obj;
		List<IBusModelServerObjFuncObj> arrayList = readCachedServerObjFuncByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelServerObjFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerObjFuncByRetTblIdx( IYCFKeyHash256 RetTableId )
	{
		final String S_ProcName = "deepDisposeServerObjFuncByRetTblIdx";
		IBusModelServerObjFuncObj obj;
		List<IBusModelServerObjFuncObj> arrayList = readCachedServerObjFuncByRetTblIdx( RetTableId );
		if( arrayList != null )  {
			Iterator<IBusModelServerObjFuncObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelServerObjFuncObj updateServerObjFunc( IBusModelServerObjFuncObj Obj ) {
		IBusModelServerObjFuncObj obj = Obj;
		schema.getBusModelBackingStore().getTableServerObjFunc().updateServerObjFunc( null,
			Obj.getServerObjFuncRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getServerObjFuncTableObj().getClassCode() ) {
			obj = (IBusModelServerObjFuncObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteServerObjFunc( IBusModelServerObjFuncObj Obj ) {
		IBusModelServerObjFuncObj obj = Obj;
		schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFunc( null,
			obj.getServerObjFuncRec() );
		Obj.forget();
	}

	@Override
	public void deleteServerObjFuncByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerObjFuncObj obj = readServerObjFunc(Id);
		if( obj != null ) {
			IBusModelServerObjFuncEditObj editObj = (IBusModelServerObjFuncEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelServerObjFuncEditObj)obj.beginEdit();
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
		deepDisposeServerObjFuncByIdIdx( Id );
	}

	@Override
	public void deleteServerObjFuncByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByTenantIdx( null,
				TenantId );
			Iterator<IBusModelServerObjFuncObj> iter = dict.values().iterator();
			IBusModelServerObjFuncObj obj;
			List<IBusModelServerObjFuncObj> toForget = new LinkedList<IBusModelServerObjFuncObj>();
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
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByTenantIdx( null,
				TenantId );
		}
		deepDisposeServerObjFuncByTenantIdx( TenantId );
	}

	@Override
	public void deleteServerObjFuncByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelServerMethodByUNameIdxKey,
				IBusModelServerObjFuncObj >();
		}
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelServerObjFuncObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByUNameIdx( null,
				TableId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByUNameIdx( null,
				TableId,
				Name );
		}
		deepDisposeServerObjFuncByUNameIdx( TableId,
				Name );
	}

	@Override
	public void deleteServerObjFuncByMethTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< IBusModelServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( indexByMethTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict = indexByMethTableIdx.get( key );
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByMethTableIdx( null,
				TableId );
			Iterator<IBusModelServerObjFuncObj> iter = dict.values().iterator();
			IBusModelServerObjFuncObj obj;
			List<IBusModelServerObjFuncObj> toForget = new LinkedList<IBusModelServerObjFuncObj>();
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
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByMethTableIdx( null,
				TableId );
		}
		deepDisposeServerObjFuncByMethTableIdx( TableId );
	}

	@Override
	public void deleteServerObjFuncByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		if( indexByMethCodeVisIdx == null ) {
			indexByMethCodeVisIdx = new HashMap< IBusModelServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( indexByMethCodeVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict = indexByMethCodeVisIdx.get( key );
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByMethCodeVisIdx( null,
				CodeVis );
			Iterator<IBusModelServerObjFuncObj> iter = dict.values().iterator();
			IBusModelServerObjFuncObj obj;
			List<IBusModelServerObjFuncObj> toForget = new LinkedList<IBusModelServerObjFuncObj>();
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
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByMethCodeVisIdx( null,
				CodeVis );
		}
		deepDisposeServerObjFuncByMethCodeVisIdx( CodeVis );
	}

	@Override
	public void deleteServerObjFuncByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		if( indexByMethTableVisIdx == null ) {
			indexByMethTableVisIdx = new HashMap< IBusModelServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( indexByMethTableVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict = indexByMethTableVisIdx.get( key );
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByMethTableVisIdx( null,
				TableId,
				CodeVis );
			Iterator<IBusModelServerObjFuncObj> iter = dict.values().iterator();
			IBusModelServerObjFuncObj obj;
			List<IBusModelServerObjFuncObj> toForget = new LinkedList<IBusModelServerObjFuncObj>();
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
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByMethTableVisIdx( null,
				TableId,
				CodeVis );
		}
		deepDisposeServerObjFuncByMethTableVisIdx( TableId,
				CodeVis );
	}

	@Override
	public void deleteServerObjFuncByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelServerObjFuncObj> iter = dict.values().iterator();
			IBusModelServerObjFuncObj obj;
			List<IBusModelServerObjFuncObj> toForget = new LinkedList<IBusModelServerObjFuncObj>();
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
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeServerObjFuncByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteServerObjFuncByRetTblIdx( IYCFKeyHash256 RetTableId )
	{
		IBusModelServerObjFuncByRetTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerObjFunc().newByRetTblIdxKey();
		key.setOptionalRetTableId( RetTableId );
		if( indexByRetTblIdx == null ) {
			indexByRetTblIdx = new HashMap< IBusModelServerObjFuncByRetTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj > >();
		}
		if( indexByRetTblIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerObjFuncObj> dict = indexByRetTblIdx.get( key );
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByRetTblIdx( null,
				RetTableId );
			Iterator<IBusModelServerObjFuncObj> iter = dict.values().iterator();
			IBusModelServerObjFuncObj obj;
			List<IBusModelServerObjFuncObj> toForget = new LinkedList<IBusModelServerObjFuncObj>();
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
			schema.getBusModelBackingStore().getTableServerObjFunc().deleteServerObjFuncByRetTblIdx( null,
				RetTableId );
		}
		deepDisposeServerObjFuncByRetTblIdx( RetTableId );
	}
}