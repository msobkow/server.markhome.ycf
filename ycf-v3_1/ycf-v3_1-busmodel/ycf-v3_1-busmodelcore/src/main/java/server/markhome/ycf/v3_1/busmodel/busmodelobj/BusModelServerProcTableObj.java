// Description: Java 25 Table Object implementation for ServerProc.

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

public class BusModelServerProcTableObj
	implements IBusModelServerProcTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelServerProc.CLASS_CODE;
	protected static final int backingClassCode = IBusModelServerProc.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> allServerProc;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > > indexByTenantIdx;
	private Map< IBusModelServerMethodByUNameIdxKey,
		IBusModelServerProcObj > indexByUNameIdx;
	private Map< IBusModelServerMethodByMethTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > > indexByMethTableIdx;
	private Map< IBusModelServerMethodByMethCodeVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > > indexByMethCodeVisIdx;
	private Map< IBusModelServerMethodByMethTableVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > > indexByMethTableVisIdx;
	private Map< IBusModelServerMethodByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > > indexByDefSchemaIdx;
	public static String TABLE_NAME = "ServerProc";
	public static String TABLE_DBNAME = "srvprc";

	public BusModelServerProcTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerProcObj>();
		allServerProc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
	}

	public BusModelServerProcTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerProcObj>();
		allServerProc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelServerProcTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelServerProcTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allServerProc = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
		List<IBusModelServerProcObj> toForget = new LinkedList<IBusModelServerProcObj>();
		IBusModelServerProcObj cur = null;
		Iterator<IBusModelServerProcObj> iter = members.values().iterator();
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
	 *	BusModelServerProcObj.
	 */
	@Override
	public IBusModelServerProcObj newInstance() {
		IBusModelServerProcObj inst = new BusModelServerProcObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelServerProcObj.
	 */
	@Override
	public IBusModelServerProcEditObj newEditInstance( IBusModelServerProcObj orig ) {
		IBusModelServerProcEditObj edit = new BusModelServerProcEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelServerProcObj realiseServerProc( IBusModelServerProcObj Obj ) {
		IBusModelServerProcObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelServerProcObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelServerProcObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					indexByMethTableIdx.remove( keyMethTableIdx );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					indexByMethCodeVisIdx.remove( keyMethCodeVisIdx );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					indexByMethTableVisIdx.remove( keyMethTableVisIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelServerProcObj)schema.getServerMethodTableObj().realiseServerMethod( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					mapMethCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					mapMethTableVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allServerProc != null ) {
				allServerProc.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelServerProcObj)schema.getServerMethodTableObj().realiseServerMethod( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allServerProc != null ) {
				allServerProc.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					mapMethCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					mapMethTableVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelServerProcObj createServerProc( IBusModelServerProcObj Obj ) {
		IBusModelServerProcObj obj = Obj;
		IBusModelServerProc rec = obj.getServerProcRec();
		schema.getBusModelBackingStore().getTableServerProc().createServerProc(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelServerProcObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelServerProcObj readServerProc( $implCommaIJavaOptAtomType$ pkey ) {
		return( readServerProc( pkey, false ) );
	}

	@Override
	public IBusModelServerProcObj readServerProc( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelServerProcObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelServerProc readRec = schema.getBusModelBackingStore().getTableServerProc().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelServerProcObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelServerProcObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelServerProcObj readCachedServerProc( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerProcObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeServerProc( IBusModelServerProcObj obj )
	{
		final String S_ProcName = "BusModelServerProcTableObj.reallyDeepDisposeServerProc() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelServerProcObj existing = readCachedServerProc( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );

					schema.getParamTableObj().deepDisposeParamByServerMethodIdx( existing.getRequiredId() );


		schema.getServerMethodTableObj().reallyDeepDisposeServerMethod( obj );
	}
	@Override
	public void deepDisposeServerProc( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerProcObj obj = readCachedServerProc( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelServerProcObj lockServerProc( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerProcObj locked = null;
		IBusModelServerProc lockRec = schema.getBusModelBackingStore().getTableServerProc().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelServerProcObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelServerProcObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockServerProc", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelServerProcObj> readAllServerProc() {
		return( readAllServerProc( false ) );
	}

	@Override
	public List<IBusModelServerProcObj> readAllServerProc( boolean forceRead ) {
		final String S_ProcName = "readAllServerProc";
		if( ( allServerProc == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelServerProcObj>();
			allServerProc = map;
			IBusModelServerProc[] recList = schema.getBusModelBackingStore().getTableServerProc().readAllDerived( null );
			IBusModelServerProc rec;
			IBusModelServerProcObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerProcObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerProcObj realised = (IBusModelServerProcObj)obj.realise();
			}
		}
		int len = allServerProc.size();
		IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
		Iterator<IBusModelServerProcObj> valIter = allServerProc.values().iterator();
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
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
		List<IBusModelServerProcObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerProcObj> readCachedAllServerProc() {
		final String S_ProcName = "readCachedAllServerProc";
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>();
		if( allServerProc != null ) {
			int len = allServerProc.size();
			IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
			Iterator<IBusModelServerProcObj> valIter = allServerProc.values().iterator();
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
		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
	public IBusModelServerProcObj readServerProcByIdIdx( IYCFKeyHash256 Id )
	{
		return( readServerProcByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelServerProcObj readServerProcByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelServerProcObj obj = readServerProc( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readServerProcByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerProcByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerProcObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerProcObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerProcObj realised = (IBusModelServerProcObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
		Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
		List<IBusModelServerProcObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelServerProcObj readServerProcByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		return( readServerProcByUNameIdx( TableId,
			Name,
			false ) );
	}

	@Override
	public IBusModelServerProcObj readServerProcByUNameIdx( IYCFKeyHash256 TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelServerMethodByUNameIdxKey,
				IBusModelServerProcObj >();
		}
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelServerProcObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelServerMethod rec = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByUNameIdx( null,
				TableId,
				Name );
			if( rec != null ) {
				obj = (IBusModelServerProcObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelServerProcObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByMethTableIdx( IYCFKeyHash256 TableId )
	{
		return( readServerProcByMethTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByMethTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerProcByMethTableIdx";
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< IBusModelServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableIdx.containsKey( key ) ) {
			dict = indexByMethTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerProcObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethTableIdx( null,
				TableId );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerProcObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerProcObj realised = (IBusModelServerProcObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
		Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
		List<IBusModelServerProcObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readServerProcByMethCodeVisIdx( CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readServerProcByMethCodeVisIdx";
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
		if( indexByMethCodeVisIdx == null ) {
			indexByMethCodeVisIdx = new HashMap< IBusModelServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( ( ! forceRead ) && indexByMethCodeVisIdx.containsKey( key ) ) {
			dict = indexByMethCodeVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerProcObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethCodeVisIdx( null,
				CodeVis );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerProcObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerProcObj realised = (IBusModelServerProcObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethCodeVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
		Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
		List<IBusModelServerProcObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readServerProcByMethTableVisIdx( TableId,
			CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readServerProcByMethTableVisIdx";
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
		if( indexByMethTableVisIdx == null ) {
			indexByMethTableVisIdx = new HashMap< IBusModelServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableVisIdx.containsKey( key ) ) {
			dict = indexByMethTableVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerProcObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethTableVisIdx( null,
				TableId,
				CodeVis );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerProcObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerProcObj realised = (IBusModelServerProcObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
		Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
		List<IBusModelServerProcObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readServerProcByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelServerProcObj> readServerProcByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerProcByDefSchemaIdx";
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerProcObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerProcObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerProcObj realised = (IBusModelServerProcObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
		Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
		List<IBusModelServerProcObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelServerProcObj readCachedServerProcByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerProcObj obj = null;
		obj = readCachedServerProc( Id );
		return( obj );
	}

	@Override
	public List<IBusModelServerProcObj> readCachedServerProcByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedServerProcByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
				Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
			IBusModelServerProcObj obj;
			Iterator<IBusModelServerProcObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
	public IBusModelServerProcObj readCachedServerProcByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelServerProcObj obj = null;
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelServerProcObj> valIter = members.values().iterator();
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
			Iterator<IBusModelServerProcObj> valIter = members.values().iterator();
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
	public List<IBusModelServerProcObj> readCachedServerProcByMethTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedServerProcByMethTableIdx";
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>();
		if( indexByMethTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
			if( indexByMethTableIdx.containsKey( key ) ) {
				dict = indexByMethTableIdx.get( key );
				int len = dict.size();
				IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
				Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
			IBusModelServerProcObj obj;
			Iterator<IBusModelServerProcObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
	public List<IBusModelServerProcObj> readCachedServerProcByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedServerProcByMethCodeVisIdx";
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>();
		if( indexByMethCodeVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
			if( indexByMethCodeVisIdx.containsKey( key ) ) {
				dict = indexByMethCodeVisIdx.get( key );
				int len = dict.size();
				IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
				Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
			IBusModelServerProcObj obj;
			Iterator<IBusModelServerProcObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
	public List<IBusModelServerProcObj> readCachedServerProcByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedServerProcByMethTableVisIdx";
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>();
		if( indexByMethTableVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
			if( indexByMethTableVisIdx.containsKey( key ) ) {
				dict = indexByMethTableVisIdx.get( key );
				int len = dict.size();
				IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
				Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
			IBusModelServerProcObj obj;
			Iterator<IBusModelServerProcObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
	public List<IBusModelServerProcObj> readCachedServerProcByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedServerProcByDefSchemaIdx";
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelServerProcObj> arrayList = new ArrayList<IBusModelServerProcObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelServerProcObj arr[] = new IBusModelServerProcObj[len];
				Iterator<IBusModelServerProcObj> valIter = dict.values().iterator();
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
			IBusModelServerProcObj obj;
			Iterator<IBusModelServerProcObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerProcObj> cmp = new Comparator<IBusModelServerProcObj>() {
			@Override
			public int compare( IBusModelServerProcObj lhs, IBusModelServerProcObj rhs ) {
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
	public void deepDisposeServerProcByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerProcObj obj = readCachedServerProcByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeServerProcByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeServerProcByTenantIdx";
		IBusModelServerProcObj obj;
		List<IBusModelServerProcObj> arrayList = readCachedServerProcByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelServerProcObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerProcByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelServerProcObj obj = readCachedServerProcByUNameIdx( TableId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeServerProcByMethTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeServerProcByMethTableIdx";
		IBusModelServerProcObj obj;
		List<IBusModelServerProcObj> arrayList = readCachedServerProcByMethTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelServerProcObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerProcByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeServerProcByMethCodeVisIdx";
		IBusModelServerProcObj obj;
		List<IBusModelServerProcObj> arrayList = readCachedServerProcByMethCodeVisIdx( CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelServerProcObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerProcByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeServerProcByMethTableVisIdx";
		IBusModelServerProcObj obj;
		List<IBusModelServerProcObj> arrayList = readCachedServerProcByMethTableVisIdx( TableId,
				CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelServerProcObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerProcByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeServerProcByDefSchemaIdx";
		IBusModelServerProcObj obj;
		List<IBusModelServerProcObj> arrayList = readCachedServerProcByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelServerProcObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelServerProcObj updateServerProc( IBusModelServerProcObj Obj ) {
		IBusModelServerProcObj obj = Obj;
		schema.getBusModelBackingStore().getTableServerProc().updateServerProc( null,
			Obj.getServerProcRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getServerProcTableObj().getClassCode() ) {
			obj = (IBusModelServerProcObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteServerProc( IBusModelServerProcObj Obj ) {
		IBusModelServerProcObj obj = Obj;
		schema.getBusModelBackingStore().getTableServerProc().deleteServerProc( null,
			obj.getServerProcRec() );
		Obj.forget();
	}

	@Override
	public void deleteServerProcByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerProcObj obj = readServerProc(Id);
		if( obj != null ) {
			IBusModelServerProcEditObj editObj = (IBusModelServerProcEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelServerProcEditObj)obj.beginEdit();
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
		deepDisposeServerProcByIdIdx( Id );
	}

	@Override
	public void deleteServerProcByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByTenantIdx( null,
				TenantId );
			Iterator<IBusModelServerProcObj> iter = dict.values().iterator();
			IBusModelServerProcObj obj;
			List<IBusModelServerProcObj> toForget = new LinkedList<IBusModelServerProcObj>();
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
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByTenantIdx( null,
				TenantId );
		}
		deepDisposeServerProcByTenantIdx( TenantId );
	}

	@Override
	public void deleteServerProcByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelServerMethodByUNameIdxKey,
				IBusModelServerProcObj >();
		}
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelServerProcObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByUNameIdx( null,
				TableId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByUNameIdx( null,
				TableId,
				Name );
		}
		deepDisposeServerProcByUNameIdx( TableId,
				Name );
	}

	@Override
	public void deleteServerProcByMethTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< IBusModelServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( indexByMethTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict = indexByMethTableIdx.get( key );
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByMethTableIdx( null,
				TableId );
			Iterator<IBusModelServerProcObj> iter = dict.values().iterator();
			IBusModelServerProcObj obj;
			List<IBusModelServerProcObj> toForget = new LinkedList<IBusModelServerProcObj>();
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
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByMethTableIdx( null,
				TableId );
		}
		deepDisposeServerProcByMethTableIdx( TableId );
	}

	@Override
	public void deleteServerProcByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		if( indexByMethCodeVisIdx == null ) {
			indexByMethCodeVisIdx = new HashMap< IBusModelServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( indexByMethCodeVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict = indexByMethCodeVisIdx.get( key );
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByMethCodeVisIdx( null,
				CodeVis );
			Iterator<IBusModelServerProcObj> iter = dict.values().iterator();
			IBusModelServerProcObj obj;
			List<IBusModelServerProcObj> toForget = new LinkedList<IBusModelServerProcObj>();
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
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByMethCodeVisIdx( null,
				CodeVis );
		}
		deepDisposeServerProcByMethCodeVisIdx( CodeVis );
	}

	@Override
	public void deleteServerProcByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		if( indexByMethTableVisIdx == null ) {
			indexByMethTableVisIdx = new HashMap< IBusModelServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( indexByMethTableVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict = indexByMethTableVisIdx.get( key );
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByMethTableVisIdx( null,
				TableId,
				CodeVis );
			Iterator<IBusModelServerProcObj> iter = dict.values().iterator();
			IBusModelServerProcObj obj;
			List<IBusModelServerProcObj> toForget = new LinkedList<IBusModelServerProcObj>();
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
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByMethTableVisIdx( null,
				TableId,
				CodeVis );
		}
		deepDisposeServerProcByMethTableVisIdx( TableId,
				CodeVis );
	}

	@Override
	public void deleteServerProcByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerProcObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerProcObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelServerProcObj> iter = dict.values().iterator();
			IBusModelServerProcObj obj;
			List<IBusModelServerProcObj> toForget = new LinkedList<IBusModelServerProcObj>();
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
			schema.getBusModelBackingStore().getTableServerProc().deleteServerProcByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeServerProcByDefSchemaIdx( DefSchemaId );
	}
}