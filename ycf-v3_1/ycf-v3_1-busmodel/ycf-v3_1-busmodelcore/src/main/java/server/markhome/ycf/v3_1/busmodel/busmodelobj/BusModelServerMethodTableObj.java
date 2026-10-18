// Description: Java 25 Table Object implementation for ServerMethod.

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

public class BusModelServerMethodTableObj
	implements IBusModelServerMethodTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelServerMethod.CLASS_CODE;
	protected static final int backingClassCode = IBusModelServerMethod.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> allServerMethod;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > > indexByTenantIdx;
	private Map< IBusModelServerMethodByUNameIdxKey,
		IBusModelServerMethodObj > indexByUNameIdx;
	private Map< IBusModelServerMethodByMethTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > > indexByMethTableIdx;
	private Map< IBusModelServerMethodByMethCodeVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > > indexByMethCodeVisIdx;
	private Map< IBusModelServerMethodByMethTableVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > > indexByMethTableVisIdx;
	private Map< IBusModelServerMethodByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > > indexByDefSchemaIdx;
	public static String TABLE_NAME = "ServerMethod";
	public static String TABLE_DBNAME = "srvmeth";

	public BusModelServerMethodTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj>();
		allServerMethod = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
	}

	public BusModelServerMethodTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj>();
		allServerMethod = null;
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
		return BusModelServerMethodTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelServerMethodTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allServerMethod = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByMethTableIdx = null;
		indexByMethCodeVisIdx = null;
		indexByMethTableVisIdx = null;
		indexByDefSchemaIdx = null;
		List<IBusModelServerMethodObj> toForget = new LinkedList<IBusModelServerMethodObj>();
		IBusModelServerMethodObj cur = null;
		Iterator<IBusModelServerMethodObj> iter = members.values().iterator();
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
	 *	BusModelServerMethodObj.
	 */
	@Override
	public IBusModelServerMethodObj newInstance() {
		IBusModelServerMethodObj inst = new BusModelServerMethodObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelServerMethodObj.
	 */
	@Override
	public IBusModelServerMethodEditObj newEditInstance( IBusModelServerMethodObj orig ) {
		IBusModelServerMethodEditObj edit = new BusModelServerMethodEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelServerMethodObj realiseServerMethod( IBusModelServerMethodObj Obj ) {
		IBusModelServerMethodObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelServerMethodObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelServerMethodObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.remove( keepObj.getPKey() );
					if( mapMethTableIdx.size() <= 0 ) {
						indexByMethTableIdx.remove( keyMethTableIdx );
					}
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					mapMethCodeVisIdx.remove( keepObj.getPKey() );
					if( mapMethCodeVisIdx.size() <= 0 ) {
						indexByMethCodeVisIdx.remove( keyMethCodeVisIdx );
					}
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					mapMethTableVisIdx.remove( keepObj.getPKey() );
					if( mapMethTableVisIdx.size() <= 0 ) {
						indexByMethTableVisIdx.remove( keyMethTableVisIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelServerMethodObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					mapMethCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					mapMethTableVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allServerMethod != null ) {
				allServerMethod.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelServerMethodObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allServerMethod != null ) {
				allServerMethod.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapMethTableIdx = indexByMethTableIdx.get( keyMethTableIdx );
				if( mapMethTableIdx != null ) {
					mapMethTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethCodeVisIdx != null ) {
				IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
				keyMethCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapMethCodeVisIdx = indexByMethCodeVisIdx.get( keyMethCodeVisIdx );
				if( mapMethCodeVisIdx != null ) {
					mapMethCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMethTableVisIdx != null ) {
				IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
				keyMethTableVisIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyMethTableVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapMethTableVisIdx = indexByMethTableVisIdx.get( keyMethTableVisIdx );
				if( mapMethTableVisIdx != null ) {
					mapMethTableVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelServerMethodObj createServerMethod( IBusModelServerMethodObj Obj ) {
		IBusModelServerMethodObj obj = Obj;
		IBusModelServerMethod rec = obj.getServerMethodRec();
		schema.getBusModelBackingStore().getTableServerMethod().createServerMethod(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelServerMethodObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelServerMethodObj readServerMethod( $implCommaIJavaOptAtomType$ pkey ) {
		return( readServerMethod( pkey, false ) );
	}

	@Override
	public IBusModelServerMethodObj readServerMethod( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelServerMethodObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelServerMethod readRec = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelServerMethodObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelServerMethodObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelServerMethodObj readCachedServerMethod( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerMethodObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeServerMethod( IBusModelServerMethodObj obj )
	{
		final String S_ProcName = "BusModelServerMethodTableObj.reallyDeepDisposeServerMethod() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelServerMethodObj existing = readCachedServerMethod( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelServerMethodByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelServerMethodByMethTableIdxKey keyMethTableIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		keyMethTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		IBusModelServerMethodByMethCodeVisIdxKey keyMethCodeVisIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		keyMethCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		IBusModelServerMethodByMethTableVisIdxKey keyMethTableVisIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		keyMethTableVisIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyMethTableVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		IBusModelServerMethodByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );


		schema.getParamTableObj().deepDisposeParamByServerMethodIdx( existing.getRequiredId() );

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByMethTableIdx != null ) {
			if( indexByMethTableIdx.containsKey( keyMethTableIdx ) ) {
				indexByMethTableIdx.get( keyMethTableIdx ).remove( pkey );
				if( indexByMethTableIdx.get( keyMethTableIdx ).size() <= 0 ) {
					indexByMethTableIdx.remove( keyMethTableIdx );
				}
			}
		}

		if( indexByMethCodeVisIdx != null ) {
			if( indexByMethCodeVisIdx.containsKey( keyMethCodeVisIdx ) ) {
				indexByMethCodeVisIdx.get( keyMethCodeVisIdx ).remove( pkey );
				if( indexByMethCodeVisIdx.get( keyMethCodeVisIdx ).size() <= 0 ) {
					indexByMethCodeVisIdx.remove( keyMethCodeVisIdx );
				}
			}
		}

		if( indexByMethTableVisIdx != null ) {
			if( indexByMethTableVisIdx.containsKey( keyMethTableVisIdx ) ) {
				indexByMethTableVisIdx.get( keyMethTableVisIdx ).remove( pkey );
				if( indexByMethTableVisIdx.get( keyMethTableVisIdx ).size() <= 0 ) {
					indexByMethTableVisIdx.remove( keyMethTableVisIdx );
				}
			}
		}

		if( indexByDefSchemaIdx != null ) {
			if( indexByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
				indexByDefSchemaIdx.get( keyDefSchemaIdx ).remove( pkey );
				if( indexByDefSchemaIdx.get( keyDefSchemaIdx ).size() <= 0 ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}
		}


		schema.getScopeTableObj().reallyDeepDisposeScope( obj );
	}
	@Override
	public void deepDisposeServerMethod( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerMethodObj obj = readCachedServerMethod( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelServerMethodObj lockServerMethod( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelServerMethodObj locked = null;
		IBusModelServerMethod lockRec = schema.getBusModelBackingStore().getTableServerMethod().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelServerMethodObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelServerMethodObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockServerMethod", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelServerMethodObj> readAllServerMethod() {
		return( readAllServerMethod( false ) );
	}

	@Override
	public List<IBusModelServerMethodObj> readAllServerMethod( boolean forceRead ) {
		final String S_ProcName = "readAllServerMethod";
		if( ( allServerMethod == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelServerMethodObj>();
			allServerMethod = map;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readAllDerived( null );
			IBusModelServerMethod rec;
			IBusModelServerMethodObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerMethodObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerMethodObj realised = (IBusModelServerMethodObj)obj.realise();
			}
		}
		int len = allServerMethod.size();
		IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
		Iterator<IBusModelServerMethodObj> valIter = allServerMethod.values().iterator();
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
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
		List<IBusModelServerMethodObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerMethodObj> readCachedAllServerMethod() {
		final String S_ProcName = "readCachedAllServerMethod";
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>();
		if( allServerMethod != null ) {
			int len = allServerMethod.size();
			IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
			Iterator<IBusModelServerMethodObj> valIter = allServerMethod.values().iterator();
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
		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
	public IBusModelServerMethodObj readServerMethodByIdIdx( IYCFKeyHash256 Id )
	{
		return( readServerMethodByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelServerMethodObj readServerMethodByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelServerMethodObj obj = readServerMethod( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readServerMethodByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerMethodByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerMethodObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerMethodObj realised = (IBusModelServerMethodObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
		Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
		List<IBusModelServerMethodObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelServerMethodObj readServerMethodByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		return( readServerMethodByUNameIdx( TableId,
			Name,
			false ) );
	}

	@Override
	public IBusModelServerMethodObj readServerMethodByUNameIdx( IYCFKeyHash256 TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelServerMethodByUNameIdxKey,
				IBusModelServerMethodObj >();
		}
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelServerMethodObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelServerMethod rec = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByUNameIdx( null,
				TableId,
				Name );
			if( rec != null ) {
				obj = (IBusModelServerMethodObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelServerMethodObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByMethTableIdx( IYCFKeyHash256 TableId )
	{
		return( readServerMethodByMethTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByMethTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerMethodByMethTableIdx";
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< IBusModelServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableIdx.containsKey( key ) ) {
			dict = indexByMethTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethTableIdx( null,
				TableId );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerMethodObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerMethodObj realised = (IBusModelServerMethodObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
		Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
		List<IBusModelServerMethodObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readServerMethodByMethCodeVisIdx( CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readServerMethodByMethCodeVisIdx";
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
		if( indexByMethCodeVisIdx == null ) {
			indexByMethCodeVisIdx = new HashMap< IBusModelServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( ( ! forceRead ) && indexByMethCodeVisIdx.containsKey( key ) ) {
			dict = indexByMethCodeVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethCodeVisIdx( null,
				CodeVis );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerMethodObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerMethodObj realised = (IBusModelServerMethodObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethCodeVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
		Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
		List<IBusModelServerMethodObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readServerMethodByMethTableVisIdx( TableId,
			CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readServerMethodByMethTableVisIdx";
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
		if( indexByMethTableVisIdx == null ) {
			indexByMethTableVisIdx = new HashMap< IBusModelServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( ( ! forceRead ) && indexByMethTableVisIdx.containsKey( key ) ) {
			dict = indexByMethTableVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByMethTableVisIdx( null,
				TableId,
				CodeVis );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerMethodObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerMethodObj realised = (IBusModelServerMethodObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMethTableVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
		Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
		List<IBusModelServerMethodObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readServerMethodByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelServerMethodObj> readServerMethodByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readServerMethodByDefSchemaIdx";
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj>();
			IBusModelServerMethodObj obj;
			IBusModelServerMethod[] recList = schema.getBusModelBackingStore().getTableServerMethod().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelServerMethod rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelServerMethodObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelServerMethodObj realised = (IBusModelServerMethodObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
		Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
		List<IBusModelServerMethodObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelServerMethodObj readCachedServerMethodByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerMethodObj obj = null;
		obj = readCachedServerMethod( Id );
		return( obj );
	}

	@Override
	public List<IBusModelServerMethodObj> readCachedServerMethodByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedServerMethodByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
				Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
			IBusModelServerMethodObj obj;
			Iterator<IBusModelServerMethodObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
	public IBusModelServerMethodObj readCachedServerMethodByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelServerMethodObj obj = null;
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelServerMethodObj> valIter = members.values().iterator();
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
			Iterator<IBusModelServerMethodObj> valIter = members.values().iterator();
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
	public List<IBusModelServerMethodObj> readCachedServerMethodByMethTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedServerMethodByMethTableIdx";
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>();
		if( indexByMethTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
			if( indexByMethTableIdx.containsKey( key ) ) {
				dict = indexByMethTableIdx.get( key );
				int len = dict.size();
				IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
				Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
			IBusModelServerMethodObj obj;
			Iterator<IBusModelServerMethodObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
	public List<IBusModelServerMethodObj> readCachedServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedServerMethodByMethCodeVisIdx";
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>();
		if( indexByMethCodeVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
			if( indexByMethCodeVisIdx.containsKey( key ) ) {
				dict = indexByMethCodeVisIdx.get( key );
				int len = dict.size();
				IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
				Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
			IBusModelServerMethodObj obj;
			Iterator<IBusModelServerMethodObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
	public List<IBusModelServerMethodObj> readCachedServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedServerMethodByMethTableVisIdx";
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>();
		if( indexByMethTableVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
			if( indexByMethTableVisIdx.containsKey( key ) ) {
				dict = indexByMethTableVisIdx.get( key );
				int len = dict.size();
				IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
				Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
			IBusModelServerMethodObj obj;
			Iterator<IBusModelServerMethodObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
	public List<IBusModelServerMethodObj> readCachedServerMethodByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedServerMethodByDefSchemaIdx";
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelServerMethodObj> arrayList = new ArrayList<IBusModelServerMethodObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelServerMethodObj arr[] = new IBusModelServerMethodObj[len];
				Iterator<IBusModelServerMethodObj> valIter = dict.values().iterator();
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
			IBusModelServerMethodObj obj;
			Iterator<IBusModelServerMethodObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelServerMethodObj> cmp = new Comparator<IBusModelServerMethodObj>() {
			@Override
			public int compare( IBusModelServerMethodObj lhs, IBusModelServerMethodObj rhs ) {
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
	public void deepDisposeServerMethodByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerMethodObj obj = readCachedServerMethodByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeServerMethodByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeServerMethodByTenantIdx";
		IBusModelServerMethodObj obj;
		List<IBusModelServerMethodObj> arrayList = readCachedServerMethodByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelServerMethodObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerMethodByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelServerMethodObj obj = readCachedServerMethodByUNameIdx( TableId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeServerMethodByMethTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeServerMethodByMethTableIdx";
		IBusModelServerMethodObj obj;
		List<IBusModelServerMethodObj> arrayList = readCachedServerMethodByMethTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelServerMethodObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeServerMethodByMethCodeVisIdx";
		IBusModelServerMethodObj obj;
		List<IBusModelServerMethodObj> arrayList = readCachedServerMethodByMethCodeVisIdx( CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelServerMethodObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeServerMethodByMethTableVisIdx";
		IBusModelServerMethodObj obj;
		List<IBusModelServerMethodObj> arrayList = readCachedServerMethodByMethTableVisIdx( TableId,
				CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelServerMethodObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeServerMethodByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeServerMethodByDefSchemaIdx";
		IBusModelServerMethodObj obj;
		List<IBusModelServerMethodObj> arrayList = readCachedServerMethodByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelServerMethodObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelServerMethodObj updateServerMethod( IBusModelServerMethodObj Obj ) {
		IBusModelServerMethodObj obj = Obj;
		schema.getBusModelBackingStore().getTableServerMethod().updateServerMethod( null,
			Obj.getServerMethodRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().getClassCode() ) {
			obj = (IBusModelServerMethodObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteServerMethod( IBusModelServerMethodObj Obj ) {
		IBusModelServerMethodObj obj = Obj;
		schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethod( null,
			obj.getServerMethodRec() );
		Obj.forget();
	}

	@Override
	public void deleteServerMethodByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelServerMethodObj obj = readServerMethod(Id);
		if( obj != null ) {
			IBusModelServerMethodEditObj editObj = (IBusModelServerMethodEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelServerMethodEditObj)obj.beginEdit();
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
		deepDisposeServerMethodByIdIdx( Id );
	}

	@Override
	public void deleteServerMethodByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByTenantIdx( null,
				TenantId );
			Iterator<IBusModelServerMethodObj> iter = dict.values().iterator();
			IBusModelServerMethodObj obj;
			List<IBusModelServerMethodObj> toForget = new LinkedList<IBusModelServerMethodObj>();
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
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByTenantIdx( null,
				TenantId );
		}
		deepDisposeServerMethodByTenantIdx( TenantId );
	}

	@Override
	public void deleteServerMethodByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelServerMethodByUNameIdxKey,
				IBusModelServerMethodObj >();
		}
		IBusModelServerMethodByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelServerMethodObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByUNameIdx( null,
				TableId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByUNameIdx( null,
				TableId,
				Name );
		}
		deepDisposeServerMethodByUNameIdx( TableId,
				Name );
	}

	@Override
	public void deleteServerMethodByMethTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelServerMethodByMethTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByMethTableIdx == null ) {
			indexByMethTableIdx = new HashMap< IBusModelServerMethodByMethTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( indexByMethTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict = indexByMethTableIdx.get( key );
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByMethTableIdx( null,
				TableId );
			Iterator<IBusModelServerMethodObj> iter = dict.values().iterator();
			IBusModelServerMethodObj obj;
			List<IBusModelServerMethodObj> toForget = new LinkedList<IBusModelServerMethodObj>();
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
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByMethTableIdx( null,
				TableId );
		}
		deepDisposeServerMethodByMethTableIdx( TableId );
	}

	@Override
	public void deleteServerMethodByMethCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelServerMethodByMethCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		if( indexByMethCodeVisIdx == null ) {
			indexByMethCodeVisIdx = new HashMap< IBusModelServerMethodByMethCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( indexByMethCodeVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict = indexByMethCodeVisIdx.get( key );
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByMethCodeVisIdx( null,
				CodeVis );
			Iterator<IBusModelServerMethodObj> iter = dict.values().iterator();
			IBusModelServerMethodObj obj;
			List<IBusModelServerMethodObj> toForget = new LinkedList<IBusModelServerMethodObj>();
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
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByMethCodeVisIdx( null,
				CodeVis );
		}
		deepDisposeServerMethodByMethCodeVisIdx( CodeVis );
	}

	@Override
	public void deleteServerMethodByMethTableVisIdx( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelServerMethodByMethTableVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByMethTableVisIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		if( indexByMethTableVisIdx == null ) {
			indexByMethTableVisIdx = new HashMap< IBusModelServerMethodByMethTableVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( indexByMethTableVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict = indexByMethTableVisIdx.get( key );
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByMethTableVisIdx( null,
				TableId,
				CodeVis );
			Iterator<IBusModelServerMethodObj> iter = dict.values().iterator();
			IBusModelServerMethodObj obj;
			List<IBusModelServerMethodObj> toForget = new LinkedList<IBusModelServerMethodObj>();
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
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByMethTableVisIdx( null,
				TableId,
				CodeVis );
		}
		deepDisposeServerMethodByMethTableVisIdx( TableId,
				CodeVis );
	}

	@Override
	public void deleteServerMethodByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelServerMethodByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelServerMethodByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelServerMethodObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelServerMethodObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelServerMethodObj> iter = dict.values().iterator();
			IBusModelServerMethodObj obj;
			List<IBusModelServerMethodObj> toForget = new LinkedList<IBusModelServerMethodObj>();
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
			schema.getBusModelBackingStore().getTableServerMethod().deleteServerMethodByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeServerMethodByDefSchemaIdx( DefSchemaId );
	}
}