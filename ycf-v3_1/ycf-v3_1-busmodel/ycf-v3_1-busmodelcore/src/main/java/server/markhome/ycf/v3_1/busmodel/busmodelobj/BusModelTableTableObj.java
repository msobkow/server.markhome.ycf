// Description: Java 25 Table Object implementation for Table.

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

public class BusModelTableTableObj
	implements IBusModelTableTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelTable.CLASS_CODE;
	protected static final int backingClassCode = IBusModelTable.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> allTable;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > > indexByTenantIdx;
	private Map< IBusModelTableBySchemaDefIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > > indexBySchemaDefIdx;
	private Map< IBusModelTableByCodeVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > > indexByCodeVisIdx;
	private Map< IBusModelTableBySchemaCodeVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > > indexBySchemaCodeVisIdx;
	private Map< IBusModelTableByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > > indexByDefSchemaIdx;
	private Map< IBusModelTableByUNameIdxKey,
		IBusModelTableObj > indexByUNameIdx;
	private Map< IBusModelTableBySchemaCdIdxKey,
		IBusModelTableObj > indexBySchemaCdIdx;
	private Map< IBusModelTableByPrimaryIndexIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > > indexByPrimaryIndexIdx;
	private Map< IBusModelTableByLookupIndexIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > > indexByLookupIndexIdx;
	private Map< IBusModelTableByAltIndexIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > > indexByAltIndexIdx;
	private Map< IBusModelTableByQualTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > > indexByQualTableIdx;
	public static String TABLE_NAME = "Table";
	public static String TABLE_DBNAME = "tbldef";

	public BusModelTableTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
		allTable = null;
		indexByTenantIdx = null;
		indexBySchemaDefIdx = null;
		indexByCodeVisIdx = null;
		indexBySchemaCodeVisIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexBySchemaCdIdx = null;
		indexByPrimaryIndexIdx = null;
		indexByLookupIndexIdx = null;
		indexByAltIndexIdx = null;
		indexByQualTableIdx = null;
	}

	public BusModelTableTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
		allTable = null;
		indexByTenantIdx = null;
		indexBySchemaDefIdx = null;
		indexByCodeVisIdx = null;
		indexBySchemaCodeVisIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexBySchemaCdIdx = null;
		indexByPrimaryIndexIdx = null;
		indexByLookupIndexIdx = null;
		indexByAltIndexIdx = null;
		indexByQualTableIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelTableTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelTableTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allTable = null;
		indexByTenantIdx = null;
		indexBySchemaDefIdx = null;
		indexByCodeVisIdx = null;
		indexBySchemaCodeVisIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexBySchemaCdIdx = null;
		indexByPrimaryIndexIdx = null;
		indexByLookupIndexIdx = null;
		indexByAltIndexIdx = null;
		indexByQualTableIdx = null;
		List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
		IBusModelTableObj cur = null;
		Iterator<IBusModelTableObj> iter = members.values().iterator();
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
	 *	BusModelTableObj.
	 */
	@Override
	public IBusModelTableObj newInstance() {
		IBusModelTableObj inst = new BusModelTableObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelTableObj.
	 */
	@Override
	public IBusModelTableEditObj newEditInstance( IBusModelTableObj orig ) {
		IBusModelTableEditObj edit = new BusModelTableEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelTableObj realiseTable( IBusModelTableObj Obj ) {
		IBusModelTableObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTableObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelTableObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				IBusModelTableBySchemaDefIdxKey keySchemaDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaDefIdxKey();
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.remove( keepObj.getPKey() );
					if( mapSchemaDefIdx.size() <= 0 ) {
						indexBySchemaDefIdx.remove( keySchemaDefIdx );
					}
				}
			}

			if( indexByCodeVisIdx != null ) {
				IBusModelTableByCodeVisIdxKey keyCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByCodeVisIdxKey();
				keyCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapCodeVisIdx = indexByCodeVisIdx.get( keyCodeVisIdx );
				if( mapCodeVisIdx != null ) {
					mapCodeVisIdx.remove( keepObj.getPKey() );
					if( mapCodeVisIdx.size() <= 0 ) {
						indexByCodeVisIdx.remove( keyCodeVisIdx );
					}
				}
			}

			if( indexBySchemaCodeVisIdx != null ) {
				IBusModelTableBySchemaCodeVisIdxKey keySchemaCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
				keySchemaCodeVisIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapSchemaCodeVisIdx = indexBySchemaCodeVisIdx.get( keySchemaCodeVisIdx );
				if( mapSchemaCodeVisIdx != null ) {
					mapSchemaCodeVisIdx.remove( keepObj.getPKey() );
					if( mapSchemaCodeVisIdx.size() <= 0 ) {
						indexBySchemaCodeVisIdx.remove( keySchemaCodeVisIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTableByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelTableByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByUNameIdxKey();
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexBySchemaCdIdx != null ) {
				IBusModelTableBySchemaCdIdxKey keySchemaCdIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCdIdxKey();
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.remove( keySchemaCdIdx );
			}

			if( indexByPrimaryIndexIdx != null ) {
				IBusModelTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.remove( keepObj.getPKey() );
					if( mapPrimaryIndexIdx.size() <= 0 ) {
						indexByPrimaryIndexIdx.remove( keyPrimaryIndexIdx );
					}
				}
			}

			if( indexByLookupIndexIdx != null ) {
				IBusModelTableByLookupIndexIdxKey keyLookupIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.remove( keepObj.getPKey() );
					if( mapLookupIndexIdx.size() <= 0 ) {
						indexByLookupIndexIdx.remove( keyLookupIndexIdx );
					}
				}
			}

			if( indexByAltIndexIdx != null ) {
				IBusModelTableByAltIndexIdxKey keyAltIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.remove( keepObj.getPKey() );
					if( mapAltIndexIdx.size() <= 0 ) {
						indexByAltIndexIdx.remove( keyAltIndexIdx );
					}
				}
			}

			if( indexByQualTableIdx != null ) {
				IBusModelTableByQualTableIdxKey keyQualTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.remove( keepObj.getPKey() );
					if( mapQualTableIdx.size() <= 0 ) {
						indexByQualTableIdx.remove( keyQualTableIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelTableObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				IBusModelTableBySchemaDefIdxKey keySchemaDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaDefIdxKey();
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCodeVisIdx != null ) {
				IBusModelTableByCodeVisIdxKey keyCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByCodeVisIdxKey();
				keyCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapCodeVisIdx = indexByCodeVisIdx.get( keyCodeVisIdx );
				if( mapCodeVisIdx != null ) {
					mapCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaCodeVisIdx != null ) {
				IBusModelTableBySchemaCodeVisIdxKey keySchemaCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
				keySchemaCodeVisIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapSchemaCodeVisIdx = indexBySchemaCodeVisIdx.get( keySchemaCodeVisIdx );
				if( mapSchemaCodeVisIdx != null ) {
					mapSchemaCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTableByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelTableByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByUNameIdxKey();
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexBySchemaCdIdx != null ) {
				IBusModelTableBySchemaCdIdxKey keySchemaCdIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCdIdxKey();
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.put( keySchemaCdIdx, keepObj );
			}

			if( indexByPrimaryIndexIdx != null ) {
				IBusModelTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLookupIndexIdx != null ) {
				IBusModelTableByLookupIndexIdxKey keyLookupIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIndexIdx != null ) {
				IBusModelTableByAltIndexIdxKey keyAltIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByQualTableIdx != null ) {
				IBusModelTableByQualTableIdxKey keyQualTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allTable != null ) {
				allTable.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelTableObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTable != null ) {
				allTable.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaDefIdx != null ) {
				IBusModelTableBySchemaDefIdxKey keySchemaDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaDefIdxKey();
				keySchemaDefIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapSchemaDefIdx = indexBySchemaDefIdx.get( keySchemaDefIdx );
				if( mapSchemaDefIdx != null ) {
					mapSchemaDefIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCodeVisIdx != null ) {
				IBusModelTableByCodeVisIdxKey keyCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByCodeVisIdxKey();
				keyCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapCodeVisIdx = indexByCodeVisIdx.get( keyCodeVisIdx );
				if( mapCodeVisIdx != null ) {
					mapCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaCodeVisIdx != null ) {
				IBusModelTableBySchemaCodeVisIdxKey keySchemaCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
				keySchemaCodeVisIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapSchemaCodeVisIdx = indexBySchemaCodeVisIdx.get( keySchemaCodeVisIdx );
				if( mapSchemaCodeVisIdx != null ) {
					mapSchemaCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTableByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelTableByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByUNameIdxKey();
				keyUNameIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexBySchemaCdIdx != null ) {
				IBusModelTableBySchemaCdIdxKey keySchemaCdIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCdIdxKey();
				keySchemaCdIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchemaCdIdx.setRequiredTableClassCode( keepObj.getRequiredTableClassCode() );
				indexBySchemaCdIdx.put( keySchemaCdIdx, keepObj );
			}

			if( indexByPrimaryIndexIdx != null ) {
				IBusModelTableByPrimaryIndexIdxKey keyPrimaryIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByPrimaryIndexIdxKey();
				keyPrimaryIndexIdx.setOptionalPrimaryIndexId( keepObj.getOptionalPrimaryIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapPrimaryIndexIdx = indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx );
				if( mapPrimaryIndexIdx != null ) {
					mapPrimaryIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByLookupIndexIdx != null ) {
				IBusModelTableByLookupIndexIdxKey keyLookupIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByLookupIndexIdxKey();
				keyLookupIndexIdx.setOptionalLookupIndexId( keepObj.getOptionalLookupIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapLookupIndexIdx = indexByLookupIndexIdx.get( keyLookupIndexIdx );
				if( mapLookupIndexIdx != null ) {
					mapLookupIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAltIndexIdx != null ) {
				IBusModelTableByAltIndexIdxKey keyAltIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByAltIndexIdxKey();
				keyAltIndexIdx.setOptionalAltIndexId( keepObj.getOptionalAltIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapAltIndexIdx = indexByAltIndexIdx.get( keyAltIndexIdx );
				if( mapAltIndexIdx != null ) {
					mapAltIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByQualTableIdx != null ) {
				IBusModelTableByQualTableIdxKey keyQualTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByQualTableIdxKey();
				keyQualTableIdx.setOptionalQualifyingTableId( keepObj.getOptionalQualifyingTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableObj > mapQualTableIdx = indexByQualTableIdx.get( keyQualTableIdx );
				if( mapQualTableIdx != null ) {
					mapQualTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelTableObj createTable( IBusModelTableObj Obj ) {
		IBusModelTableObj obj = Obj;
		IBusModelTable rec = obj.getTableRec();
		schema.getBusModelBackingStore().getTableTable().createTable(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelTableObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelTableObj readTable( $implCommaIJavaOptAtomType$ pkey ) {
		return( readTable( pkey, false ) );
	}

	@Override
	public IBusModelTableObj readTable( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelTableObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelTable readRec = schema.getBusModelBackingStore().getTableTable().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelTableObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelTableObj readCachedTable( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTableObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeTable( IBusModelTableObj obj )
	{
		final String S_ProcName = "BusModelTableTableObj.reallyDeepDisposeTable() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTableObj existing = readCachedTable( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelTableBySchemaDefIdxKey keySchemaDefIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaDefIdxKey();
		keySchemaDefIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		IBusModelTableByCodeVisIdxKey keyCodeVisIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByCodeVisIdxKey();
		keyCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		IBusModelTableBySchemaCodeVisIdxKey keySchemaCodeVisIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
		keySchemaCodeVisIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keySchemaCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		IBusModelTableByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelTableByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByUNameIdxKey();
		keyUNameIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelTableBySchemaCdIdxKey keySchemaCdIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCdIdxKey();
		keySchemaCdIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keySchemaCdIdx.setRequiredTableClassCode( existing.getRequiredTableClassCode() );

		IBusModelTableByPrimaryIndexIdxKey keyPrimaryIndexIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByPrimaryIndexIdxKey();
		keyPrimaryIndexIdx.setOptionalPrimaryIndexId( existing.getOptionalPrimaryIndexId() );

		IBusModelTableByLookupIndexIdxKey keyLookupIndexIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByLookupIndexIdxKey();
		keyLookupIndexIdx.setOptionalLookupIndexId( existing.getOptionalLookupIndexId() );

		IBusModelTableByAltIndexIdxKey keyAltIndexIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByAltIndexIdxKey();
		keyAltIndexIdx.setOptionalAltIndexId( existing.getOptionalAltIndexId() );

		IBusModelTableByQualTableIdxKey keyQualTableIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByQualTableIdxKey();
		keyQualTableIdx.setOptionalQualifyingTableId( existing.getOptionalQualifyingTableId() );


					schema.getServerMethodTableObj().deepDisposeServerMethodByMethTableIdx( existing.getRequiredId() );
					schema.getDelTopDepTableObj().deepDisposeDelTopDepByDelTopDepTblIdx( existing.getRequiredId() );
					schema.getClearTopDepTableObj().deepDisposeClearTopDepByClrTopDepTblIdx( existing.getRequiredId() );
					schema.getChainTableObj().deepDisposeChainByChainTableIdx( existing.getRequiredId() );
		IBusModelRelationObj objDelTableRelationPopDep;
		List<IBusModelRelationObj> arrDelTableRelationPopDep = schema.getRelationTableObj().readCachedRelationByRelTableIdx( existing.getRequiredId() );
		Iterator<IBusModelRelationObj> iterDelTableRelationPopDep = arrDelTableRelationPopDep.iterator();
		while( iterDelTableRelationPopDep.hasNext() ) {
			objDelTableRelationPopDep = iterDelTableRelationPopDep.next();
			if( objDelTableRelationPopDep != null ) {
						schema.getPopTopDepTableObj().deepDisposePopTopDepByContRelIdx( objDelTableRelationPopDep.getRequiredId() );
			}
		}
		IBusModelRelationObj objDelTableRelationCol;
		List<IBusModelRelationObj> arrDelTableRelationCol = schema.getRelationTableObj().readCachedRelationByRelTableIdx( existing.getRequiredId() );
		Iterator<IBusModelRelationObj> iterDelTableRelationCol = arrDelTableRelationCol.iterator();
		while( iterDelTableRelationCol.hasNext() ) {
			objDelTableRelationCol = iterDelTableRelationCol.next();
			if( objDelTableRelationCol != null ) {
						schema.getRelationColTableObj().deepDisposeRelationColByRelationIdx( objDelTableRelationCol.getRequiredId() );
			}
		}
					schema.getRelationTableObj().deepDisposeRelationByRelTableIdx( existing.getRequiredId() );
		IBusModelIndexObj objDelTableIndexRefRelFmCol;
		List<IBusModelIndexObj> arrDelTableIndexRefRelFmCol = schema.getIndexTableObj().readCachedIndexByIdxTableIdx( existing.getRequiredId() );
		Iterator<IBusModelIndexObj> iterDelTableIndexRefRelFmCol = arrDelTableIndexRefRelFmCol.iterator();
		while( iterDelTableIndexRefRelFmCol.hasNext() ) {
			objDelTableIndexRefRelFmCol = iterDelTableIndexRefRelFmCol.next();
			if( objDelTableIndexRefRelFmCol != null ) {
			IBusModelIndexColObj objColumns;
			List<IBusModelIndexColObj> arrColumns = schema.getIndexColTableObj().readCachedIndexColByIndexIdx( objDelTableIndexRefRelFmCol.getRequiredId() );
			Iterator<IBusModelIndexColObj> iterColumns = arrColumns.iterator();
			while( iterColumns.hasNext() ) {
				objColumns = iterColumns.next();
					schema.getRelationColTableObj().deepDisposeRelationColByFromColIdx( objColumns.getRequiredId() );
			}
			}
		}
		IBusModelIndexObj objDelTableIndexRefRelToCol;
		List<IBusModelIndexObj> arrDelTableIndexRefRelToCol = schema.getIndexTableObj().readCachedIndexByIdxTableIdx( existing.getRequiredId() );
		Iterator<IBusModelIndexObj> iterDelTableIndexRefRelToCol = arrDelTableIndexRefRelToCol.iterator();
		while( iterDelTableIndexRefRelToCol.hasNext() ) {
			objDelTableIndexRefRelToCol = iterDelTableIndexRefRelToCol.next();
			if( objDelTableIndexRefRelToCol != null ) {
			IBusModelIndexColObj objColumns;
			List<IBusModelIndexColObj> arrColumns = schema.getIndexColTableObj().readCachedIndexColByIndexIdx( objDelTableIndexRefRelToCol.getRequiredId() );
			Iterator<IBusModelIndexColObj> iterColumns = arrColumns.iterator();
			while( iterColumns.hasNext() ) {
				objColumns = iterColumns.next();
					schema.getRelationColTableObj().deepDisposeRelationColByToColIdx( objColumns.getRequiredId() );
			}
			}
		}
		IBusModelIndexObj objDelTableIndexCol;
		List<IBusModelIndexObj> arrDelTableIndexCol = schema.getIndexTableObj().readCachedIndexByIdxTableIdx( existing.getRequiredId() );
		Iterator<IBusModelIndexObj> iterDelTableIndexCol = arrDelTableIndexCol.iterator();
		while( iterDelTableIndexCol.hasNext() ) {
			objDelTableIndexCol = iterDelTableIndexCol.next();
			if( objDelTableIndexCol != null ) {
						schema.getIndexColTableObj().deepDisposeIndexColByIndexIdx( objDelTableIndexCol.getRequiredId() );
			}
		}
					schema.getIndexTableObj().deepDisposeIndexByIdxTableIdx( existing.getRequiredId() );
		IBusModelValueObj objDelTableRefIndexColumns;
		List<IBusModelValueObj> arrDelTableRefIndexColumns = schema.getValueTableObj().readCachedValueByScopeIdx( existing.getRequiredId() );
		Iterator<IBusModelValueObj> iterDelTableRefIndexColumns = arrDelTableRefIndexColumns.iterator();
		while( iterDelTableRefIndexColumns.hasNext() ) {
			objDelTableRefIndexColumns = iterDelTableRefIndexColumns.next();
			if( objDelTableRefIndexColumns != null ) {
						schema.getIndexColTableObj().deepDisposeIndexColByColIdx( objDelTableRefIndexColumns.getRequiredId() );
			}
		}
					schema.getValueTableObj().deepDisposeValueByScopeIdx( existing.getRequiredId() );

		if( indexBySchemaDefIdx != null ) {
			if( indexBySchemaDefIdx.containsKey( keySchemaDefIdx ) ) {
				indexBySchemaDefIdx.get( keySchemaDefIdx ).remove( pkey );
				if( indexBySchemaDefIdx.get( keySchemaDefIdx ).size() <= 0 ) {
					indexBySchemaDefIdx.remove( keySchemaDefIdx );
				}
			}
		}

		if( indexByCodeVisIdx != null ) {
			if( indexByCodeVisIdx.containsKey( keyCodeVisIdx ) ) {
				indexByCodeVisIdx.get( keyCodeVisIdx ).remove( pkey );
				if( indexByCodeVisIdx.get( keyCodeVisIdx ).size() <= 0 ) {
					indexByCodeVisIdx.remove( keyCodeVisIdx );
				}
			}
		}

		if( indexBySchemaCodeVisIdx != null ) {
			if( indexBySchemaCodeVisIdx.containsKey( keySchemaCodeVisIdx ) ) {
				indexBySchemaCodeVisIdx.get( keySchemaCodeVisIdx ).remove( pkey );
				if( indexBySchemaCodeVisIdx.get( keySchemaCodeVisIdx ).size() <= 0 ) {
					indexBySchemaCodeVisIdx.remove( keySchemaCodeVisIdx );
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

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexBySchemaCdIdx != null ) {
			indexBySchemaCdIdx.remove( keySchemaCdIdx );
		}

		if( indexByPrimaryIndexIdx != null ) {
			if( indexByPrimaryIndexIdx.containsKey( keyPrimaryIndexIdx ) ) {
				indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx ).remove( pkey );
				if( indexByPrimaryIndexIdx.get( keyPrimaryIndexIdx ).size() <= 0 ) {
					indexByPrimaryIndexIdx.remove( keyPrimaryIndexIdx );
				}
			}
		}

		if( indexByLookupIndexIdx != null ) {
			if( indexByLookupIndexIdx.containsKey( keyLookupIndexIdx ) ) {
				indexByLookupIndexIdx.get( keyLookupIndexIdx ).remove( pkey );
				if( indexByLookupIndexIdx.get( keyLookupIndexIdx ).size() <= 0 ) {
					indexByLookupIndexIdx.remove( keyLookupIndexIdx );
				}
			}
		}

		if( indexByAltIndexIdx != null ) {
			if( indexByAltIndexIdx.containsKey( keyAltIndexIdx ) ) {
				indexByAltIndexIdx.get( keyAltIndexIdx ).remove( pkey );
				if( indexByAltIndexIdx.get( keyAltIndexIdx ).size() <= 0 ) {
					indexByAltIndexIdx.remove( keyAltIndexIdx );
				}
			}
		}

		if( indexByQualTableIdx != null ) {
			if( indexByQualTableIdx.containsKey( keyQualTableIdx ) ) {
				indexByQualTableIdx.get( keyQualTableIdx ).remove( pkey );
				if( indexByQualTableIdx.get( keyQualTableIdx ).size() <= 0 ) {
					indexByQualTableIdx.remove( keyQualTableIdx );
				}
			}
		}


		schema.getScopeTableObj().reallyDeepDisposeScope( obj );
	}
	@Override
	public void deepDisposeTable( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTableObj obj = readCachedTable( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelTableObj lockTable( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTableObj locked = null;
		IBusModelTable lockRec = schema.getBusModelBackingStore().getTableTable().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelTableObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockTable", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelTableObj> readAllTable() {
		return( readAllTable( false ) );
	}

	@Override
	public List<IBusModelTableObj> readAllTable( boolean forceRead ) {
		final String S_ProcName = "readAllTable";
		if( ( allTable == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelTableObj>();
			allTable = map;
			IBusModelTable[] recList = schema.getBusModelBackingStore().getTableTable().readAllDerived( null );
			IBusModelTable rec;
			IBusModelTableObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
			}
		}
		int len = allTable.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = allTable.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableObj> readCachedAllTable() {
		final String S_ProcName = "readCachedAllTable";
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( allTable != null ) {
			int len = allTable.size();
			IBusModelTableObj arr[] = new IBusModelTableObj[len];
			Iterator<IBusModelTableObj> valIter = allTable.values().iterator();
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
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public IBusModelTableObj readTableByIdIdx( IYCFKeyHash256 Id )
	{
		return( readTableByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelTableObj readTableByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelTableObj obj = readTable( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelTableObj> readTableByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readTableByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelTableObj> readTableByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableObj> readTableBySchemaDefIdx( IYCFKeyHash256 SchemaDefId )
	{
		return( readTableBySchemaDefIdx( SchemaDefId,
			false ) );
	}

	@Override
	public List<IBusModelTableObj> readTableBySchemaDefIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableBySchemaDefIdx";
		IBusModelTableBySchemaDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaDefIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
		if( indexBySchemaDefIdx == null ) {
			indexBySchemaDefIdx = new HashMap< IBusModelTableBySchemaDefIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaDefIdx.containsKey( key ) ) {
			dict = indexBySchemaDefIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
			IBusModelTableObj obj;
			IBusModelTable[] recList = schema.getBusModelBackingStore().getTableTable().readDerivedBySchemaDefIdx( null,
				SchemaDefId );
			IBusModelTable rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaDefIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableObj> readTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readTableByCodeVisIdx( CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelTableObj> readTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByCodeVisIdx";
		IBusModelTableByCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
		if( indexByCodeVisIdx == null ) {
			indexByCodeVisIdx = new HashMap< IBusModelTableByCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( ( ! forceRead ) && indexByCodeVisIdx.containsKey( key ) ) {
			dict = indexByCodeVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
			IBusModelTableObj obj;
			IBusModelTable[] recList = schema.getBusModelBackingStore().getTableTable().readDerivedByCodeVisIdx( null,
				CodeVis );
			IBusModelTable rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCodeVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableObj> readTableBySchemaCodeVisIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readTableBySchemaCodeVisIdx( SchemaDefId,
			CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelTableObj> readTableBySchemaCodeVisIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readTableBySchemaCodeVisIdx";
		IBusModelTableBySchemaCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
		if( indexBySchemaCodeVisIdx == null ) {
			indexBySchemaCodeVisIdx = new HashMap< IBusModelTableBySchemaCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaCodeVisIdx.containsKey( key ) ) {
			dict = indexBySchemaCodeVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
			IBusModelTableObj obj;
			IBusModelTable[] recList = schema.getBusModelBackingStore().getTableTable().readDerivedBySchemaCodeVisIdx( null,
				SchemaDefId,
				CodeVis );
			IBusModelTable rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaCodeVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableObj> readTableByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readTableByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelTableObj> readTableByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByDefSchemaIdx";
		IBusModelTableByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTableByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
			IBusModelTableObj obj;
			IBusModelTable[] recList = schema.getBusModelBackingStore().getTableTable().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelTable rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelTableObj readTableByUNameIdx( IYCFKeyHash256 SchemaDefId,
		String Name )
	{
		return( readTableByUNameIdx( SchemaDefId,
			Name,
			false ) );
	}

	@Override
	public IBusModelTableObj readTableByUNameIdx( IYCFKeyHash256 SchemaDefId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTableByUNameIdxKey,
				IBusModelTableObj >();
		}
		IBusModelTableByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByUNameIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		IBusModelTableObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelTable rec = schema.getBusModelBackingStore().getTableTable().readDerivedByUNameIdx( null,
				SchemaDefId,
				Name );
			if( rec != null ) {
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelTableObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelTableObj readTableBySchemaCdIdx( IYCFKeyHash256 SchemaDefId,
		String TableClassCode )
	{
		return( readTableBySchemaCdIdx( SchemaDefId,
			TableClassCode,
			false ) );
	}

	@Override
	public IBusModelTableObj readTableBySchemaCdIdx( IYCFKeyHash256 SchemaDefId,
		String TableClassCode, boolean forceRead )
	{
		if( indexBySchemaCdIdx == null ) {
			indexBySchemaCdIdx = new HashMap< IBusModelTableBySchemaCdIdxKey,
				IBusModelTableObj >();
		}
		IBusModelTableBySchemaCdIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCdIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		IBusModelTableObj obj = null;
		if( ( ! forceRead ) && indexBySchemaCdIdx.containsKey( key ) ) {
			obj = indexBySchemaCdIdx.get( key );
		}
		else {
			IBusModelTable rec = schema.getBusModelBackingStore().getTableTable().readDerivedBySchemaCdIdx( null,
				SchemaDefId,
				TableClassCode );
			if( rec != null ) {
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelTableObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelTableObj> readTableByPrimaryIndexIdx( IYCFKeyHash256 PrimaryIndexId )
	{
		return( readTableByPrimaryIndexIdx( PrimaryIndexId,
			false ) );
	}

	@Override
	public List<IBusModelTableObj> readTableByPrimaryIndexIdx( IYCFKeyHash256 PrimaryIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByPrimaryIndexIdx";
		IBusModelTableByPrimaryIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
		if( indexByPrimaryIndexIdx == null ) {
			indexByPrimaryIndexIdx = new HashMap< IBusModelTableByPrimaryIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( ( ! forceRead ) && indexByPrimaryIndexIdx.containsKey( key ) ) {
			dict = indexByPrimaryIndexIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
			IBusModelTableObj obj;
			IBusModelTable[] recList = schema.getBusModelBackingStore().getTableTable().readDerivedByPrimaryIndexIdx( null,
				PrimaryIndexId );
			IBusModelTable rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrimaryIndexIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableObj> readTableByLookupIndexIdx( IYCFKeyHash256 LookupIndexId )
	{
		return( readTableByLookupIndexIdx( LookupIndexId,
			false ) );
	}

	@Override
	public List<IBusModelTableObj> readTableByLookupIndexIdx( IYCFKeyHash256 LookupIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByLookupIndexIdx";
		IBusModelTableByLookupIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByLookupIndexIdxKey();
		key.setOptionalLookupIndexId( LookupIndexId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
		if( indexByLookupIndexIdx == null ) {
			indexByLookupIndexIdx = new HashMap< IBusModelTableByLookupIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( ( ! forceRead ) && indexByLookupIndexIdx.containsKey( key ) ) {
			dict = indexByLookupIndexIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
			IBusModelTableObj obj;
			IBusModelTable[] recList = schema.getBusModelBackingStore().getTableTable().readDerivedByLookupIndexIdx( null,
				LookupIndexId );
			IBusModelTable rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLookupIndexIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableObj> readTableByAltIndexIdx( IYCFKeyHash256 AltIndexId )
	{
		return( readTableByAltIndexIdx( AltIndexId,
			false ) );
	}

	@Override
	public List<IBusModelTableObj> readTableByAltIndexIdx( IYCFKeyHash256 AltIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByAltIndexIdx";
		IBusModelTableByAltIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByAltIndexIdxKey();
		key.setOptionalAltIndexId( AltIndexId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
		if( indexByAltIndexIdx == null ) {
			indexByAltIndexIdx = new HashMap< IBusModelTableByAltIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( ( ! forceRead ) && indexByAltIndexIdx.containsKey( key ) ) {
			dict = indexByAltIndexIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
			IBusModelTableObj obj;
			IBusModelTable[] recList = schema.getBusModelBackingStore().getTableTable().readDerivedByAltIndexIdx( null,
				AltIndexId );
			IBusModelTable rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByAltIndexIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableObj> readTableByQualTableIdx( IYCFKeyHash256 QualifyingTableId )
	{
		return( readTableByQualTableIdx( QualifyingTableId,
			false ) );
	}

	@Override
	public List<IBusModelTableObj> readTableByQualTableIdx( IYCFKeyHash256 QualifyingTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableByQualTableIdx";
		IBusModelTableByQualTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByQualTableIdxKey();
		key.setOptionalQualifyingTableId( QualifyingTableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
		if( indexByQualTableIdx == null ) {
			indexByQualTableIdx = new HashMap< IBusModelTableByQualTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( ( ! forceRead ) && indexByQualTableIdx.containsKey( key ) ) {
			dict = indexByQualTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableObj>();
			IBusModelTableObj obj;
			IBusModelTable[] recList = schema.getBusModelBackingStore().getTableTable().readDerivedByQualTableIdx( null,
				QualifyingTableId );
			IBusModelTable rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableObj realised = (IBusModelTableObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByQualTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableObj arr[] = new IBusModelTableObj[len];
		Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
		List<IBusModelTableObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelTableObj readCachedTableByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTableObj obj = null;
		obj = readCachedTable( Id );
		return( obj );
	}

	@Override
	public List<IBusModelTableObj> readCachedTableByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedTableByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelTableObj arr[] = new IBusModelTableObj[len];
				Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
			IBusModelTableObj obj;
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public List<IBusModelTableObj> readCachedTableBySchemaDefIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "readCachedTableBySchemaDefIdx";
		IBusModelTableBySchemaDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaDefIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( indexBySchemaDefIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
			if( indexBySchemaDefIdx.containsKey( key ) ) {
				dict = indexBySchemaDefIdx.get( key );
				int len = dict.size();
				IBusModelTableObj arr[] = new IBusModelTableObj[len];
				Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
			IBusModelTableObj obj;
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public List<IBusModelTableObj> readCachedTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedTableByCodeVisIdx";
		IBusModelTableByCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( indexByCodeVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
			if( indexByCodeVisIdx.containsKey( key ) ) {
				dict = indexByCodeVisIdx.get( key );
				int len = dict.size();
				IBusModelTableObj arr[] = new IBusModelTableObj[len];
				Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
			IBusModelTableObj obj;
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public List<IBusModelTableObj> readCachedTableBySchemaCodeVisIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedTableBySchemaCodeVisIdx";
		IBusModelTableBySchemaCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( indexBySchemaCodeVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
			if( indexBySchemaCodeVisIdx.containsKey( key ) ) {
				dict = indexBySchemaCodeVisIdx.get( key );
				int len = dict.size();
				IBusModelTableObj arr[] = new IBusModelTableObj[len];
				Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
			IBusModelTableObj obj;
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public List<IBusModelTableObj> readCachedTableByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedTableByDefSchemaIdx";
		IBusModelTableByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelTableObj arr[] = new IBusModelTableObj[len];
				Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
			IBusModelTableObj obj;
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public IBusModelTableObj readCachedTableByUNameIdx( IYCFKeyHash256 SchemaDefId,
		String Name )
	{
		IBusModelTableObj obj = null;
		IBusModelTableByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByUNameIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelTableObj> valIter = members.values().iterator();
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
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
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
	public IBusModelTableObj readCachedTableBySchemaCdIdx( IYCFKeyHash256 SchemaDefId,
		String TableClassCode )
	{
		IBusModelTableObj obj = null;
		IBusModelTableBySchemaCdIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCdIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		if( indexBySchemaCdIdx != null ) {
			if( indexBySchemaCdIdx.containsKey( key ) ) {
				obj = indexBySchemaCdIdx.get( key );
			}
			else {
				Iterator<IBusModelTableObj> valIter = members.values().iterator();
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
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
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
	public List<IBusModelTableObj> readCachedTableByPrimaryIndexIdx( IYCFKeyHash256 PrimaryIndexId )
	{
		final String S_ProcName = "readCachedTableByPrimaryIndexIdx";
		IBusModelTableByPrimaryIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( indexByPrimaryIndexIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
			if( indexByPrimaryIndexIdx.containsKey( key ) ) {
				dict = indexByPrimaryIndexIdx.get( key );
				int len = dict.size();
				IBusModelTableObj arr[] = new IBusModelTableObj[len];
				Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
			IBusModelTableObj obj;
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public List<IBusModelTableObj> readCachedTableByLookupIndexIdx( IYCFKeyHash256 LookupIndexId )
	{
		final String S_ProcName = "readCachedTableByLookupIndexIdx";
		IBusModelTableByLookupIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByLookupIndexIdxKey();
		key.setOptionalLookupIndexId( LookupIndexId );
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( indexByLookupIndexIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
			if( indexByLookupIndexIdx.containsKey( key ) ) {
				dict = indexByLookupIndexIdx.get( key );
				int len = dict.size();
				IBusModelTableObj arr[] = new IBusModelTableObj[len];
				Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
			IBusModelTableObj obj;
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public List<IBusModelTableObj> readCachedTableByAltIndexIdx( IYCFKeyHash256 AltIndexId )
	{
		final String S_ProcName = "readCachedTableByAltIndexIdx";
		IBusModelTableByAltIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByAltIndexIdxKey();
		key.setOptionalAltIndexId( AltIndexId );
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( indexByAltIndexIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
			if( indexByAltIndexIdx.containsKey( key ) ) {
				dict = indexByAltIndexIdx.get( key );
				int len = dict.size();
				IBusModelTableObj arr[] = new IBusModelTableObj[len];
				Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
			IBusModelTableObj obj;
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public List<IBusModelTableObj> readCachedTableByQualTableIdx( IYCFKeyHash256 QualifyingTableId )
	{
		final String S_ProcName = "readCachedTableByQualTableIdx";
		IBusModelTableByQualTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByQualTableIdxKey();
		key.setOptionalQualifyingTableId( QualifyingTableId );
		ArrayList<IBusModelTableObj> arrayList = new ArrayList<IBusModelTableObj>();
		if( indexByQualTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict;
			if( indexByQualTableIdx.containsKey( key ) ) {
				dict = indexByQualTableIdx.get( key );
				int len = dict.size();
				IBusModelTableObj arr[] = new IBusModelTableObj[len];
				Iterator<IBusModelTableObj> valIter = dict.values().iterator();
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
			IBusModelTableObj obj;
			Iterator<IBusModelTableObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableObj> cmp = new Comparator<IBusModelTableObj>() {
			@Override
			public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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
	public void deepDisposeTableByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTableObj obj = readCachedTableByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTableByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeTableByTenantIdx";
		IBusModelTableObj obj;
		List<IBusModelTableObj> arrayList = readCachedTableByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelTableObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableBySchemaDefIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "deepDisposeTableBySchemaDefIdx";
		IBusModelTableObj obj;
		List<IBusModelTableObj> arrayList = readCachedTableBySchemaDefIdx( SchemaDefId );
		if( arrayList != null )  {
			Iterator<IBusModelTableObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeTableByCodeVisIdx";
		IBusModelTableObj obj;
		List<IBusModelTableObj> arrayList = readCachedTableByCodeVisIdx( CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelTableObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableBySchemaCodeVisIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeTableBySchemaCodeVisIdx";
		IBusModelTableObj obj;
		List<IBusModelTableObj> arrayList = readCachedTableBySchemaCodeVisIdx( SchemaDefId,
				CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelTableObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeTableByDefSchemaIdx";
		IBusModelTableObj obj;
		List<IBusModelTableObj> arrayList = readCachedTableByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelTableObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableByUNameIdx( IYCFKeyHash256 SchemaDefId,
		String Name )
	{
		IBusModelTableObj obj = readCachedTableByUNameIdx( SchemaDefId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTableBySchemaCdIdx( IYCFKeyHash256 SchemaDefId,
		String TableClassCode )
	{
		IBusModelTableObj obj = readCachedTableBySchemaCdIdx( SchemaDefId,
				TableClassCode );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTableByPrimaryIndexIdx( IYCFKeyHash256 PrimaryIndexId )
	{
		final String S_ProcName = "deepDisposeTableByPrimaryIndexIdx";
		IBusModelTableObj obj;
		List<IBusModelTableObj> arrayList = readCachedTableByPrimaryIndexIdx( PrimaryIndexId );
		if( arrayList != null )  {
			Iterator<IBusModelTableObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableByLookupIndexIdx( IYCFKeyHash256 LookupIndexId )
	{
		final String S_ProcName = "deepDisposeTableByLookupIndexIdx";
		IBusModelTableObj obj;
		List<IBusModelTableObj> arrayList = readCachedTableByLookupIndexIdx( LookupIndexId );
		if( arrayList != null )  {
			Iterator<IBusModelTableObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableByAltIndexIdx( IYCFKeyHash256 AltIndexId )
	{
		final String S_ProcName = "deepDisposeTableByAltIndexIdx";
		IBusModelTableObj obj;
		List<IBusModelTableObj> arrayList = readCachedTableByAltIndexIdx( AltIndexId );
		if( arrayList != null )  {
			Iterator<IBusModelTableObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableByQualTableIdx( IYCFKeyHash256 QualifyingTableId )
	{
		final String S_ProcName = "deepDisposeTableByQualTableIdx";
		IBusModelTableObj obj;
		List<IBusModelTableObj> arrayList = readCachedTableByQualTableIdx( QualifyingTableId );
		if( arrayList != null )  {
			Iterator<IBusModelTableObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelTableObj updateTable( IBusModelTableObj Obj ) {
		IBusModelTableObj obj = Obj;
		schema.getBusModelBackingStore().getTableTable().updateTable( null,
			Obj.getTableRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getTableTableObj().getClassCode() ) {
			obj = (IBusModelTableObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteTable( IBusModelTableObj Obj ) {
		IBusModelTableObj obj = Obj;
		schema.getBusModelBackingStore().getTableTable().deleteTable( null,
			obj.getTableRec() );
		Obj.forget();
	}

	@Override
	public void deleteTableByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTableObj obj = readTable(Id);
		if( obj != null ) {
			IBusModelTableEditObj editObj = (IBusModelTableEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelTableEditObj)obj.beginEdit();
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
		deepDisposeTableByIdIdx( Id );
	}

	@Override
	public void deleteTableByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableByTenantIdx( null,
				TenantId );
			Iterator<IBusModelTableObj> iter = dict.values().iterator();
			IBusModelTableObj obj;
			List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
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
			schema.getBusModelBackingStore().getTableTable().deleteTableByTenantIdx( null,
				TenantId );
		}
		deepDisposeTableByTenantIdx( TenantId );
	}

	@Override
	public void deleteTableBySchemaDefIdx( IYCFKeyHash256 SchemaDefId )
	{
		IBusModelTableBySchemaDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaDefIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaDefIdx == null ) {
			indexBySchemaDefIdx = new HashMap< IBusModelTableBySchemaDefIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( indexBySchemaDefIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict = indexBySchemaDefIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableBySchemaDefIdx( null,
				SchemaDefId );
			Iterator<IBusModelTableObj> iter = dict.values().iterator();
			IBusModelTableObj obj;
			List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySchemaDefIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTable().deleteTableBySchemaDefIdx( null,
				SchemaDefId );
		}
		deepDisposeTableBySchemaDefIdx( SchemaDefId );
	}

	@Override
	public void deleteTableByCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelTableByCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		if( indexByCodeVisIdx == null ) {
			indexByCodeVisIdx = new HashMap< IBusModelTableByCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( indexByCodeVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict = indexByCodeVisIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableByCodeVisIdx( null,
				CodeVis );
			Iterator<IBusModelTableObj> iter = dict.values().iterator();
			IBusModelTableObj obj;
			List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByCodeVisIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTable().deleteTableByCodeVisIdx( null,
				CodeVis );
		}
		deepDisposeTableByCodeVisIdx( CodeVis );
	}

	@Override
	public void deleteTableBySchemaCodeVisIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelTableBySchemaCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCodeVisIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredCodeVis( CodeVis );
		if( indexBySchemaCodeVisIdx == null ) {
			indexBySchemaCodeVisIdx = new HashMap< IBusModelTableBySchemaCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( indexBySchemaCodeVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict = indexBySchemaCodeVisIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableBySchemaCodeVisIdx( null,
				SchemaDefId,
				CodeVis );
			Iterator<IBusModelTableObj> iter = dict.values().iterator();
			IBusModelTableObj obj;
			List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySchemaCodeVisIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTable().deleteTableBySchemaCodeVisIdx( null,
				SchemaDefId,
				CodeVis );
		}
		deepDisposeTableBySchemaCodeVisIdx( SchemaDefId,
				CodeVis );
	}

	@Override
	public void deleteTableByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelTableByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTableByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelTableObj> iter = dict.values().iterator();
			IBusModelTableObj obj;
			List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
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
			schema.getBusModelBackingStore().getTableTable().deleteTableByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeTableByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteTableByUNameIdx( IYCFKeyHash256 SchemaDefId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTableByUNameIdxKey,
				IBusModelTableObj >();
		}
		IBusModelTableByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByUNameIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredName( Name );
		IBusModelTableObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableByUNameIdx( null,
				SchemaDefId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableTable().deleteTableByUNameIdx( null,
				SchemaDefId,
				Name );
		}
		deepDisposeTableByUNameIdx( SchemaDefId,
				Name );
	}

	@Override
	public void deleteTableBySchemaCdIdx( IYCFKeyHash256 SchemaDefId,
		String TableClassCode )
	{
		if( indexBySchemaCdIdx == null ) {
			indexBySchemaCdIdx = new HashMap< IBusModelTableBySchemaCdIdxKey,
				IBusModelTableObj >();
		}
		IBusModelTableBySchemaCdIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newBySchemaCdIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredTableClassCode( TableClassCode );
		IBusModelTableObj obj = null;
		if( indexBySchemaCdIdx.containsKey( key ) ) {
			obj = indexBySchemaCdIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableBySchemaCdIdx( null,
				SchemaDefId,
				TableClassCode );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableTable().deleteTableBySchemaCdIdx( null,
				SchemaDefId,
				TableClassCode );
		}
		deepDisposeTableBySchemaCdIdx( SchemaDefId,
				TableClassCode );
	}

	@Override
	public void deleteTableByPrimaryIndexIdx( IYCFKeyHash256 PrimaryIndexId )
	{
		IBusModelTableByPrimaryIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByPrimaryIndexIdxKey();
		key.setOptionalPrimaryIndexId( PrimaryIndexId );
		if( indexByPrimaryIndexIdx == null ) {
			indexByPrimaryIndexIdx = new HashMap< IBusModelTableByPrimaryIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( indexByPrimaryIndexIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict = indexByPrimaryIndexIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableByPrimaryIndexIdx( null,
				PrimaryIndexId );
			Iterator<IBusModelTableObj> iter = dict.values().iterator();
			IBusModelTableObj obj;
			List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByPrimaryIndexIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTable().deleteTableByPrimaryIndexIdx( null,
				PrimaryIndexId );
		}
		deepDisposeTableByPrimaryIndexIdx( PrimaryIndexId );
	}

	@Override
	public void deleteTableByLookupIndexIdx( IYCFKeyHash256 LookupIndexId )
	{
		IBusModelTableByLookupIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByLookupIndexIdxKey();
		key.setOptionalLookupIndexId( LookupIndexId );
		if( indexByLookupIndexIdx == null ) {
			indexByLookupIndexIdx = new HashMap< IBusModelTableByLookupIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( indexByLookupIndexIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict = indexByLookupIndexIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableByLookupIndexIdx( null,
				LookupIndexId );
			Iterator<IBusModelTableObj> iter = dict.values().iterator();
			IBusModelTableObj obj;
			List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByLookupIndexIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTable().deleteTableByLookupIndexIdx( null,
				LookupIndexId );
		}
		deepDisposeTableByLookupIndexIdx( LookupIndexId );
	}

	@Override
	public void deleteTableByAltIndexIdx( IYCFKeyHash256 AltIndexId )
	{
		IBusModelTableByAltIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByAltIndexIdxKey();
		key.setOptionalAltIndexId( AltIndexId );
		if( indexByAltIndexIdx == null ) {
			indexByAltIndexIdx = new HashMap< IBusModelTableByAltIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( indexByAltIndexIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict = indexByAltIndexIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableByAltIndexIdx( null,
				AltIndexId );
			Iterator<IBusModelTableObj> iter = dict.values().iterator();
			IBusModelTableObj obj;
			List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByAltIndexIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTable().deleteTableByAltIndexIdx( null,
				AltIndexId );
		}
		deepDisposeTableByAltIndexIdx( AltIndexId );
	}

	@Override
	public void deleteTableByQualTableIdx( IYCFKeyHash256 QualifyingTableId )
	{
		IBusModelTableByQualTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTable().newByQualTableIdxKey();
		key.setOptionalQualifyingTableId( QualifyingTableId );
		if( indexByQualTableIdx == null ) {
			indexByQualTableIdx = new HashMap< IBusModelTableByQualTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableObj > >();
		}
		if( indexByQualTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableObj> dict = indexByQualTableIdx.get( key );
			schema.getBusModelBackingStore().getTableTable().deleteTableByQualTableIdx( null,
				QualifyingTableId );
			Iterator<IBusModelTableObj> iter = dict.values().iterator();
			IBusModelTableObj obj;
			List<IBusModelTableObj> toForget = new LinkedList<IBusModelTableObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByQualTableIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTable().deleteTableByQualTableIdx( null,
				QualifyingTableId );
		}
		deepDisposeTableByQualTableIdx( QualifyingTableId );
	}
}