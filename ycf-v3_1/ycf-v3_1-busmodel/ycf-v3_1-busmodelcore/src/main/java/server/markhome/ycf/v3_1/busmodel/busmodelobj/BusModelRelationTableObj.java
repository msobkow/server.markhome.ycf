// Description: Java 25 Table Object implementation for Relation.

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

public class BusModelRelationTableObj
	implements IBusModelRelationTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelRelation.CLASS_CODE;
	protected static final int backingClassCode = IBusModelRelation.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> allRelation;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > > indexByTenantIdx;
	private Map< IBusModelRelationByUNameIdxKey,
		IBusModelRelationObj > indexByUNameIdx;
	private Map< IBusModelRelationByRelTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > > indexByRelTableIdx;
	private Map< IBusModelRelationByRelCodeVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > > indexByRelCodeVisIdx;
	private Map< IBusModelRelationByRelTableCodeVisXKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > > indexByRelTableCodeVisX;
	private Map< IBusModelRelationByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > > indexByDefSchemaIdx;
	private Map< IBusModelRelationByFromKeyIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > > indexByFromKeyIdx;
	private Map< IBusModelRelationByToTblIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > > indexByToTblIdx;
	private Map< IBusModelRelationByToKeyIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > > indexByToKeyIdx;
	private Map< IBusModelRelationByNarrowedIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > > indexByNarrowedIdx;
	public static String TABLE_NAME = "Relation";
	public static String TABLE_DBNAME = "reldef";

	public BusModelRelationTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
		allRelation = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByRelTableIdx = null;
		indexByRelCodeVisIdx = null;
		indexByRelTableCodeVisX = null;
		indexByDefSchemaIdx = null;
		indexByFromKeyIdx = null;
		indexByToTblIdx = null;
		indexByToKeyIdx = null;
		indexByNarrowedIdx = null;
	}

	public BusModelRelationTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
		allRelation = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByRelTableIdx = null;
		indexByRelCodeVisIdx = null;
		indexByRelTableCodeVisX = null;
		indexByDefSchemaIdx = null;
		indexByFromKeyIdx = null;
		indexByToTblIdx = null;
		indexByToKeyIdx = null;
		indexByNarrowedIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelRelationTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelRelationTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allRelation = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByRelTableIdx = null;
		indexByRelCodeVisIdx = null;
		indexByRelTableCodeVisX = null;
		indexByDefSchemaIdx = null;
		indexByFromKeyIdx = null;
		indexByToTblIdx = null;
		indexByToKeyIdx = null;
		indexByNarrowedIdx = null;
		List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
		IBusModelRelationObj cur = null;
		Iterator<IBusModelRelationObj> iter = members.values().iterator();
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
	 *	BusModelRelationObj.
	 */
	@Override
	public IBusModelRelationObj newInstance() {
		IBusModelRelationObj inst = new BusModelRelationObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelRelationObj.
	 */
	@Override
	public IBusModelRelationEditObj newEditInstance( IBusModelRelationObj orig ) {
		IBusModelRelationEditObj edit = new BusModelRelationEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelRelationObj realiseRelation( IBusModelRelationObj Obj ) {
		IBusModelRelationObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelRelationObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelRelationObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelRelationByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRelTableIdx != null ) {
				IBusModelRelationByRelTableIdxKey keyRelTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableIdxKey();
				keyRelTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapRelTableIdx = indexByRelTableIdx.get( keyRelTableIdx );
				if( mapRelTableIdx != null ) {
					mapRelTableIdx.remove( keepObj.getPKey() );
					if( mapRelTableIdx.size() <= 0 ) {
						indexByRelTableIdx.remove( keyRelTableIdx );
					}
				}
			}

			if( indexByRelCodeVisIdx != null ) {
				IBusModelRelationByRelCodeVisIdxKey keyRelCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelCodeVisIdxKey();
				keyRelCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapRelCodeVisIdx = indexByRelCodeVisIdx.get( keyRelCodeVisIdx );
				if( mapRelCodeVisIdx != null ) {
					mapRelCodeVisIdx.remove( keepObj.getPKey() );
					if( mapRelCodeVisIdx.size() <= 0 ) {
						indexByRelCodeVisIdx.remove( keyRelCodeVisIdx );
					}
				}
			}

			if( indexByRelTableCodeVisX != null ) {
				IBusModelRelationByRelTableCodeVisXKey keyRelTableCodeVisX =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableCodeVisXKey();
				keyRelTableCodeVisX.setRequiredTableId( keepObj.getRequiredTableId() );
				keyRelTableCodeVisX.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapRelTableCodeVisX = indexByRelTableCodeVisX.get( keyRelTableCodeVisX );
				if( mapRelTableCodeVisX != null ) {
					mapRelTableCodeVisX.remove( keepObj.getPKey() );
					if( mapRelTableCodeVisX.size() <= 0 ) {
						indexByRelTableCodeVisX.remove( keyRelTableCodeVisX );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelRelationByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByFromKeyIdx != null ) {
				IBusModelRelationByFromKeyIdxKey keyFromKeyIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByFromKeyIdxKey();
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.remove( keepObj.getPKey() );
					if( mapFromKeyIdx.size() <= 0 ) {
						indexByFromKeyIdx.remove( keyFromKeyIdx );
					}
				}
			}

			if( indexByToTblIdx != null ) {
				IBusModelRelationByToTblIdxKey keyToTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToTblIdxKey();
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.remove( keepObj.getPKey() );
					if( mapToTblIdx.size() <= 0 ) {
						indexByToTblIdx.remove( keyToTblIdx );
					}
				}
			}

			if( indexByToKeyIdx != null ) {
				IBusModelRelationByToKeyIdxKey keyToKeyIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToKeyIdxKey();
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.remove( keepObj.getPKey() );
					if( mapToKeyIdx.size() <= 0 ) {
						indexByToKeyIdx.remove( keyToKeyIdx );
					}
				}
			}

			if( indexByNarrowedIdx != null ) {
				IBusModelRelationByNarrowedIdxKey keyNarrowedIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.remove( keepObj.getPKey() );
					if( mapNarrowedIdx.size() <= 0 ) {
						indexByNarrowedIdx.remove( keyNarrowedIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelRelationObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelRelationByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRelTableIdx != null ) {
				IBusModelRelationByRelTableIdxKey keyRelTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableIdxKey();
				keyRelTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapRelTableIdx = indexByRelTableIdx.get( keyRelTableIdx );
				if( mapRelTableIdx != null ) {
					mapRelTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelCodeVisIdx != null ) {
				IBusModelRelationByRelCodeVisIdxKey keyRelCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelCodeVisIdxKey();
				keyRelCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapRelCodeVisIdx = indexByRelCodeVisIdx.get( keyRelCodeVisIdx );
				if( mapRelCodeVisIdx != null ) {
					mapRelCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelTableCodeVisX != null ) {
				IBusModelRelationByRelTableCodeVisXKey keyRelTableCodeVisX =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableCodeVisXKey();
				keyRelTableCodeVisX.setRequiredTableId( keepObj.getRequiredTableId() );
				keyRelTableCodeVisX.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapRelTableCodeVisX = indexByRelTableCodeVisX.get( keyRelTableCodeVisX );
				if( mapRelTableCodeVisX != null ) {
					mapRelTableCodeVisX.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelRelationByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFromKeyIdx != null ) {
				IBusModelRelationByFromKeyIdxKey keyFromKeyIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByFromKeyIdxKey();
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToTblIdx != null ) {
				IBusModelRelationByToTblIdxKey keyToTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToTblIdxKey();
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToKeyIdx != null ) {
				IBusModelRelationByToKeyIdxKey keyToKeyIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToKeyIdxKey();
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNarrowedIdx != null ) {
				IBusModelRelationByNarrowedIdxKey keyNarrowedIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allRelation != null ) {
				allRelation.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelRelationObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allRelation != null ) {
				allRelation.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelRelationByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRelTableIdx != null ) {
				IBusModelRelationByRelTableIdxKey keyRelTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableIdxKey();
				keyRelTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapRelTableIdx = indexByRelTableIdx.get( keyRelTableIdx );
				if( mapRelTableIdx != null ) {
					mapRelTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelCodeVisIdx != null ) {
				IBusModelRelationByRelCodeVisIdxKey keyRelCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelCodeVisIdxKey();
				keyRelCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapRelCodeVisIdx = indexByRelCodeVisIdx.get( keyRelCodeVisIdx );
				if( mapRelCodeVisIdx != null ) {
					mapRelCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelTableCodeVisX != null ) {
				IBusModelRelationByRelTableCodeVisXKey keyRelTableCodeVisX =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableCodeVisXKey();
				keyRelTableCodeVisX.setRequiredTableId( keepObj.getRequiredTableId() );
				keyRelTableCodeVisX.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapRelTableCodeVisX = indexByRelTableCodeVisX.get( keyRelTableCodeVisX );
				if( mapRelTableCodeVisX != null ) {
					mapRelTableCodeVisX.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelRelationByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFromKeyIdx != null ) {
				IBusModelRelationByFromKeyIdxKey keyFromKeyIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByFromKeyIdxKey();
				keyFromKeyIdx.setRequiredFromIndexId( keepObj.getRequiredFromIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapFromKeyIdx = indexByFromKeyIdx.get( keyFromKeyIdx );
				if( mapFromKeyIdx != null ) {
					mapFromKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToTblIdx != null ) {
				IBusModelRelationByToTblIdxKey keyToTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToTblIdxKey();
				keyToTblIdx.setRequiredToTableId( keepObj.getRequiredToTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapToTblIdx = indexByToTblIdx.get( keyToTblIdx );
				if( mapToTblIdx != null ) {
					mapToTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByToKeyIdx != null ) {
				IBusModelRelationByToKeyIdxKey keyToKeyIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToKeyIdxKey();
				keyToKeyIdx.setRequiredToIndexId( keepObj.getRequiredToIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapToKeyIdx = indexByToKeyIdx.get( keyToKeyIdx );
				if( mapToKeyIdx != null ) {
					mapToKeyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNarrowedIdx != null ) {
				IBusModelRelationByNarrowedIdxKey keyNarrowedIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByNarrowedIdxKey();
				keyNarrowedIdx.setOptionalNarrowedId( keepObj.getOptionalNarrowedId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj > mapNarrowedIdx = indexByNarrowedIdx.get( keyNarrowedIdx );
				if( mapNarrowedIdx != null ) {
					mapNarrowedIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelRelationObj createRelation( IBusModelRelationObj Obj ) {
		IBusModelRelationObj obj = Obj;
		IBusModelRelation rec = obj.getRelationRec();
		schema.getBusModelBackingStore().getTableRelation().createRelation(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelRelationObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelRelationObj readRelation( $implCommaIJavaOptAtomType$ pkey ) {
		return( readRelation( pkey, false ) );
	}

	@Override
	public IBusModelRelationObj readRelation( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelRelationObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelRelation readRec = schema.getBusModelBackingStore().getTableRelation().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelRelationObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelRelationObj readCachedRelation( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelRelationObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeRelation( IBusModelRelationObj obj )
	{
		final String S_ProcName = "BusModelRelationTableObj.reallyDeepDisposeRelation() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelRelationObj existing = readCachedRelation( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelRelationByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelRelationByRelTableIdxKey keyRelTableIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableIdxKey();
		keyRelTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		IBusModelRelationByRelCodeVisIdxKey keyRelCodeVisIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelCodeVisIdxKey();
		keyRelCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		IBusModelRelationByRelTableCodeVisXKey keyRelTableCodeVisX = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableCodeVisXKey();
		keyRelTableCodeVisX.setRequiredTableId( existing.getRequiredTableId() );
		keyRelTableCodeVisX.setRequiredCodeVis( existing.getRequiredCodeVis() );

		IBusModelRelationByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelRelationByFromKeyIdxKey keyFromKeyIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByFromKeyIdxKey();
		keyFromKeyIdx.setRequiredFromIndexId( existing.getRequiredFromIndexId() );

		IBusModelRelationByToTblIdxKey keyToTblIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToTblIdxKey();
		keyToTblIdx.setRequiredToTableId( existing.getRequiredToTableId() );

		IBusModelRelationByToKeyIdxKey keyToKeyIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToKeyIdxKey();
		keyToKeyIdx.setRequiredToIndexId( existing.getRequiredToIndexId() );

		IBusModelRelationByNarrowedIdxKey keyNarrowedIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByNarrowedIdxKey();
		keyNarrowedIdx.setOptionalNarrowedId( existing.getOptionalNarrowedId() );


					schema.getPopTopDepTableObj().deepDisposePopTopDepByContRelIdx( existing.getRequiredId() );
					schema.getRelationColTableObj().deepDisposeRelationColByRelationIdx( existing.getRequiredId() );

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByRelTableIdx != null ) {
			if( indexByRelTableIdx.containsKey( keyRelTableIdx ) ) {
				indexByRelTableIdx.get( keyRelTableIdx ).remove( pkey );
				if( indexByRelTableIdx.get( keyRelTableIdx ).size() <= 0 ) {
					indexByRelTableIdx.remove( keyRelTableIdx );
				}
			}
		}

		if( indexByRelCodeVisIdx != null ) {
			if( indexByRelCodeVisIdx.containsKey( keyRelCodeVisIdx ) ) {
				indexByRelCodeVisIdx.get( keyRelCodeVisIdx ).remove( pkey );
				if( indexByRelCodeVisIdx.get( keyRelCodeVisIdx ).size() <= 0 ) {
					indexByRelCodeVisIdx.remove( keyRelCodeVisIdx );
				}
			}
		}

		if( indexByRelTableCodeVisX != null ) {
			if( indexByRelTableCodeVisX.containsKey( keyRelTableCodeVisX ) ) {
				indexByRelTableCodeVisX.get( keyRelTableCodeVisX ).remove( pkey );
				if( indexByRelTableCodeVisX.get( keyRelTableCodeVisX ).size() <= 0 ) {
					indexByRelTableCodeVisX.remove( keyRelTableCodeVisX );
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

		if( indexByFromKeyIdx != null ) {
			if( indexByFromKeyIdx.containsKey( keyFromKeyIdx ) ) {
				indexByFromKeyIdx.get( keyFromKeyIdx ).remove( pkey );
				if( indexByFromKeyIdx.get( keyFromKeyIdx ).size() <= 0 ) {
					indexByFromKeyIdx.remove( keyFromKeyIdx );
				}
			}
		}

		if( indexByToTblIdx != null ) {
			if( indexByToTblIdx.containsKey( keyToTblIdx ) ) {
				indexByToTblIdx.get( keyToTblIdx ).remove( pkey );
				if( indexByToTblIdx.get( keyToTblIdx ).size() <= 0 ) {
					indexByToTblIdx.remove( keyToTblIdx );
				}
			}
		}

		if( indexByToKeyIdx != null ) {
			if( indexByToKeyIdx.containsKey( keyToKeyIdx ) ) {
				indexByToKeyIdx.get( keyToKeyIdx ).remove( pkey );
				if( indexByToKeyIdx.get( keyToKeyIdx ).size() <= 0 ) {
					indexByToKeyIdx.remove( keyToKeyIdx );
				}
			}
		}

		if( indexByNarrowedIdx != null ) {
			if( indexByNarrowedIdx.containsKey( keyNarrowedIdx ) ) {
				indexByNarrowedIdx.get( keyNarrowedIdx ).remove( pkey );
				if( indexByNarrowedIdx.get( keyNarrowedIdx ).size() <= 0 ) {
					indexByNarrowedIdx.remove( keyNarrowedIdx );
				}
			}
		}


		schema.getScopeTableObj().reallyDeepDisposeScope( obj );
	}
	@Override
	public void deepDisposeRelation( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelRelationObj obj = readCachedRelation( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelRelationObj lockRelation( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelRelationObj locked = null;
		IBusModelRelation lockRec = schema.getBusModelBackingStore().getTableRelation().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelRelationObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockRelation", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelRelationObj> readAllRelation() {
		return( readAllRelation( false ) );
	}

	@Override
	public List<IBusModelRelationObj> readAllRelation( boolean forceRead ) {
		final String S_ProcName = "readAllRelation";
		if( ( allRelation == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelRelationObj>();
			allRelation = map;
			IBusModelRelation[] recList = schema.getBusModelBackingStore().getTableRelation().readAllDerived( null );
			IBusModelRelation rec;
			IBusModelRelationObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
			}
		}
		int len = allRelation.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = allRelation.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRelationObj> readCachedAllRelation() {
		final String S_ProcName = "readCachedAllRelation";
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( allRelation != null ) {
			int len = allRelation.size();
			IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
			Iterator<IBusModelRelationObj> valIter = allRelation.values().iterator();
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
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public IBusModelRelationObj readRelationByIdIdx( IYCFKeyHash256 Id )
	{
		return( readRelationByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelRelationObj readRelationByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelRelationObj obj = readRelation( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readRelationByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelRelationObj readRelationByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		return( readRelationByUNameIdx( TableId,
			Name,
			false ) );
	}

	@Override
	public IBusModelRelationObj readRelationByUNameIdx( IYCFKeyHash256 TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelRelationByUNameIdxKey,
				IBusModelRelationObj >();
		}
		IBusModelRelationByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelRelationObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelRelation rec = schema.getBusModelBackingStore().getTableRelation().readDerivedByUNameIdx( null,
				TableId,
				Name );
			if( rec != null ) {
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelRelationObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByRelTableIdx( IYCFKeyHash256 TableId )
	{
		return( readRelationByRelTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByRelTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByRelTableIdx";
		IBusModelRelationByRelTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
		if( indexByRelTableIdx == null ) {
			indexByRelTableIdx = new HashMap< IBusModelRelationByRelTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( ( ! forceRead ) && indexByRelTableIdx.containsKey( key ) ) {
			dict = indexByRelTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
			IBusModelRelationObj obj;
			IBusModelRelation[] recList = schema.getBusModelBackingStore().getTableRelation().readDerivedByRelTableIdx( null,
				TableId );
			IBusModelRelation rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByRelCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readRelationByRelCodeVisIdx( CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByRelCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByRelCodeVisIdx";
		IBusModelRelationByRelCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
		if( indexByRelCodeVisIdx == null ) {
			indexByRelCodeVisIdx = new HashMap< IBusModelRelationByRelCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( ( ! forceRead ) && indexByRelCodeVisIdx.containsKey( key ) ) {
			dict = indexByRelCodeVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
			IBusModelRelationObj obj;
			IBusModelRelation[] recList = schema.getBusModelBackingStore().getTableRelation().readDerivedByRelCodeVisIdx( null,
				CodeVis );
			IBusModelRelation rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelCodeVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByRelTableCodeVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readRelationByRelTableCodeVisX( TableId,
			CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByRelTableCodeVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByRelTableCodeVisX";
		IBusModelRelationByRelTableCodeVisXKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableCodeVisXKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
		if( indexByRelTableCodeVisX == null ) {
			indexByRelTableCodeVisX = new HashMap< IBusModelRelationByRelTableCodeVisXKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( ( ! forceRead ) && indexByRelTableCodeVisX.containsKey( key ) ) {
			dict = indexByRelTableCodeVisX.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
			IBusModelRelationObj obj;
			IBusModelRelation[] recList = schema.getBusModelBackingStore().getTableRelation().readDerivedByRelTableCodeVisX( null,
				TableId,
				CodeVis );
			IBusModelRelation rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelTableCodeVisX.put( key, dict );
		}
		int len = dict.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readRelationByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByDefSchemaIdx";
		IBusModelRelationByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelRelationByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
			IBusModelRelationObj obj;
			IBusModelRelation[] recList = schema.getBusModelBackingStore().getTableRelation().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelRelation rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByFromKeyIdx( IYCFKeyHash256 FromIndexId )
	{
		return( readRelationByFromKeyIdx( FromIndexId,
			false ) );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByFromKeyIdx( IYCFKeyHash256 FromIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByFromKeyIdx";
		IBusModelRelationByFromKeyIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByFromKeyIdxKey();
		key.setRequiredFromIndexId( FromIndexId );
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
		if( indexByFromKeyIdx == null ) {
			indexByFromKeyIdx = new HashMap< IBusModelRelationByFromKeyIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( ( ! forceRead ) && indexByFromKeyIdx.containsKey( key ) ) {
			dict = indexByFromKeyIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
			IBusModelRelationObj obj;
			IBusModelRelation[] recList = schema.getBusModelBackingStore().getTableRelation().readDerivedByFromKeyIdx( null,
				FromIndexId );
			IBusModelRelation rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByFromKeyIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByToTblIdx( IYCFKeyHash256 ToTableId )
	{
		return( readRelationByToTblIdx( ToTableId,
			false ) );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByToTblIdx( IYCFKeyHash256 ToTableId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByToTblIdx";
		IBusModelRelationByToTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToTblIdxKey();
		key.setRequiredToTableId( ToTableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
		if( indexByToTblIdx == null ) {
			indexByToTblIdx = new HashMap< IBusModelRelationByToTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( ( ! forceRead ) && indexByToTblIdx.containsKey( key ) ) {
			dict = indexByToTblIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
			IBusModelRelationObj obj;
			IBusModelRelation[] recList = schema.getBusModelBackingStore().getTableRelation().readDerivedByToTblIdx( null,
				ToTableId );
			IBusModelRelation rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByToTblIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByToKeyIdx( IYCFKeyHash256 ToIndexId )
	{
		return( readRelationByToKeyIdx( ToIndexId,
			false ) );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByToKeyIdx( IYCFKeyHash256 ToIndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByToKeyIdx";
		IBusModelRelationByToKeyIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToKeyIdxKey();
		key.setRequiredToIndexId( ToIndexId );
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
		if( indexByToKeyIdx == null ) {
			indexByToKeyIdx = new HashMap< IBusModelRelationByToKeyIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( ( ! forceRead ) && indexByToKeyIdx.containsKey( key ) ) {
			dict = indexByToKeyIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
			IBusModelRelationObj obj;
			IBusModelRelation[] recList = schema.getBusModelBackingStore().getTableRelation().readDerivedByToKeyIdx( null,
				ToIndexId );
			IBusModelRelation rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByToKeyIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByNarrowedIdx( IYCFKeyHash256 NarrowedId )
	{
		return( readRelationByNarrowedIdx( NarrowedId,
			false ) );
	}

	@Override
	public List<IBusModelRelationObj> readRelationByNarrowedIdx( IYCFKeyHash256 NarrowedId,
		boolean forceRead )
	{
		final String S_ProcName = "readRelationByNarrowedIdx";
		IBusModelRelationByNarrowedIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByNarrowedIdxKey();
		key.setOptionalNarrowedId( NarrowedId );
		Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
		if( indexByNarrowedIdx == null ) {
			indexByNarrowedIdx = new HashMap< IBusModelRelationByNarrowedIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( ( ! forceRead ) && indexByNarrowedIdx.containsKey( key ) ) {
			dict = indexByNarrowedIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRelationObj>();
			IBusModelRelationObj obj;
			IBusModelRelation[] recList = schema.getBusModelBackingStore().getTableRelation().readDerivedByNarrowedIdx( null,
				NarrowedId );
			IBusModelRelation rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRelationObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRelationObj realised = (IBusModelRelationObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNarrowedIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
		Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
		List<IBusModelRelationObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelRelationObj readCachedRelationByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelRelationObj obj = null;
		obj = readCachedRelation( Id );
		return( obj );
	}

	@Override
	public List<IBusModelRelationObj> readCachedRelationByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedRelationByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
				Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
			IBusModelRelationObj obj;
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public IBusModelRelationObj readCachedRelationByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelRelationObj obj = null;
		IBusModelRelationByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelRelationObj> valIter = members.values().iterator();
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
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
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
	public List<IBusModelRelationObj> readCachedRelationByRelTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedRelationByRelTableIdx";
		IBusModelRelationByRelTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( indexByRelTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
			if( indexByRelTableIdx.containsKey( key ) ) {
				dict = indexByRelTableIdx.get( key );
				int len = dict.size();
				IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
				Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
			IBusModelRelationObj obj;
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public List<IBusModelRelationObj> readCachedRelationByRelCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedRelationByRelCodeVisIdx";
		IBusModelRelationByRelCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( indexByRelCodeVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
			if( indexByRelCodeVisIdx.containsKey( key ) ) {
				dict = indexByRelCodeVisIdx.get( key );
				int len = dict.size();
				IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
				Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
			IBusModelRelationObj obj;
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public List<IBusModelRelationObj> readCachedRelationByRelTableCodeVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedRelationByRelTableCodeVisX";
		IBusModelRelationByRelTableCodeVisXKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableCodeVisXKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( indexByRelTableCodeVisX != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
			if( indexByRelTableCodeVisX.containsKey( key ) ) {
				dict = indexByRelTableCodeVisX.get( key );
				int len = dict.size();
				IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
				Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
			IBusModelRelationObj obj;
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public List<IBusModelRelationObj> readCachedRelationByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedRelationByDefSchemaIdx";
		IBusModelRelationByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
				Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
			IBusModelRelationObj obj;
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public List<IBusModelRelationObj> readCachedRelationByFromKeyIdx( IYCFKeyHash256 FromIndexId )
	{
		final String S_ProcName = "readCachedRelationByFromKeyIdx";
		IBusModelRelationByFromKeyIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByFromKeyIdxKey();
		key.setRequiredFromIndexId( FromIndexId );
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( indexByFromKeyIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
			if( indexByFromKeyIdx.containsKey( key ) ) {
				dict = indexByFromKeyIdx.get( key );
				int len = dict.size();
				IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
				Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
			IBusModelRelationObj obj;
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public List<IBusModelRelationObj> readCachedRelationByToTblIdx( IYCFKeyHash256 ToTableId )
	{
		final String S_ProcName = "readCachedRelationByToTblIdx";
		IBusModelRelationByToTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToTblIdxKey();
		key.setRequiredToTableId( ToTableId );
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( indexByToTblIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
			if( indexByToTblIdx.containsKey( key ) ) {
				dict = indexByToTblIdx.get( key );
				int len = dict.size();
				IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
				Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
			IBusModelRelationObj obj;
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public List<IBusModelRelationObj> readCachedRelationByToKeyIdx( IYCFKeyHash256 ToIndexId )
	{
		final String S_ProcName = "readCachedRelationByToKeyIdx";
		IBusModelRelationByToKeyIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToKeyIdxKey();
		key.setRequiredToIndexId( ToIndexId );
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( indexByToKeyIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
			if( indexByToKeyIdx.containsKey( key ) ) {
				dict = indexByToKeyIdx.get( key );
				int len = dict.size();
				IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
				Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
			IBusModelRelationObj obj;
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public List<IBusModelRelationObj> readCachedRelationByNarrowedIdx( IYCFKeyHash256 NarrowedId )
	{
		final String S_ProcName = "readCachedRelationByNarrowedIdx";
		IBusModelRelationByNarrowedIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByNarrowedIdxKey();
		key.setOptionalNarrowedId( NarrowedId );
		ArrayList<IBusModelRelationObj> arrayList = new ArrayList<IBusModelRelationObj>();
		if( indexByNarrowedIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict;
			if( indexByNarrowedIdx.containsKey( key ) ) {
				dict = indexByNarrowedIdx.get( key );
				int len = dict.size();
				IBusModelRelationObj arr[] = new IBusModelRelationObj[len];
				Iterator<IBusModelRelationObj> valIter = dict.values().iterator();
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
			IBusModelRelationObj obj;
			Iterator<IBusModelRelationObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRelationObj> cmp = new Comparator<IBusModelRelationObj>() {
			@Override
			public int compare( IBusModelRelationObj lhs, IBusModelRelationObj rhs ) {
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
	public void deepDisposeRelationByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelRelationObj obj = readCachedRelationByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeRelationByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeRelationByTenantIdx";
		IBusModelRelationObj obj;
		List<IBusModelRelationObj> arrayList = readCachedRelationByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelRelationObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRelationByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelRelationObj obj = readCachedRelationByUNameIdx( TableId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeRelationByRelTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeRelationByRelTableIdx";
		IBusModelRelationObj obj;
		List<IBusModelRelationObj> arrayList = readCachedRelationByRelTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelRelationObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRelationByRelCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeRelationByRelCodeVisIdx";
		IBusModelRelationObj obj;
		List<IBusModelRelationObj> arrayList = readCachedRelationByRelCodeVisIdx( CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelRelationObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRelationByRelTableCodeVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeRelationByRelTableCodeVisX";
		IBusModelRelationObj obj;
		List<IBusModelRelationObj> arrayList = readCachedRelationByRelTableCodeVisX( TableId,
				CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelRelationObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRelationByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeRelationByDefSchemaIdx";
		IBusModelRelationObj obj;
		List<IBusModelRelationObj> arrayList = readCachedRelationByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelRelationObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRelationByFromKeyIdx( IYCFKeyHash256 FromIndexId )
	{
		final String S_ProcName = "deepDisposeRelationByFromKeyIdx";
		IBusModelRelationObj obj;
		List<IBusModelRelationObj> arrayList = readCachedRelationByFromKeyIdx( FromIndexId );
		if( arrayList != null )  {
			Iterator<IBusModelRelationObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRelationByToTblIdx( IYCFKeyHash256 ToTableId )
	{
		final String S_ProcName = "deepDisposeRelationByToTblIdx";
		IBusModelRelationObj obj;
		List<IBusModelRelationObj> arrayList = readCachedRelationByToTblIdx( ToTableId );
		if( arrayList != null )  {
			Iterator<IBusModelRelationObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRelationByToKeyIdx( IYCFKeyHash256 ToIndexId )
	{
		final String S_ProcName = "deepDisposeRelationByToKeyIdx";
		IBusModelRelationObj obj;
		List<IBusModelRelationObj> arrayList = readCachedRelationByToKeyIdx( ToIndexId );
		if( arrayList != null )  {
			Iterator<IBusModelRelationObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRelationByNarrowedIdx( IYCFKeyHash256 NarrowedId )
	{
		final String S_ProcName = "deepDisposeRelationByNarrowedIdx";
		IBusModelRelationObj obj;
		List<IBusModelRelationObj> arrayList = readCachedRelationByNarrowedIdx( NarrowedId );
		if( arrayList != null )  {
			Iterator<IBusModelRelationObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelRelationObj updateRelation( IBusModelRelationObj Obj ) {
		IBusModelRelationObj obj = Obj;
		schema.getBusModelBackingStore().getTableRelation().updateRelation( null,
			Obj.getRelationRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getRelationTableObj().getClassCode() ) {
			obj = (IBusModelRelationObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteRelation( IBusModelRelationObj Obj ) {
		IBusModelRelationObj obj = Obj;
		schema.getBusModelBackingStore().getTableRelation().deleteRelation( null,
			obj.getRelationRec() );
		Obj.forget();
	}

	@Override
	public void deleteRelationByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelRelationObj obj = readRelation(Id);
		if( obj != null ) {
			IBusModelRelationEditObj editObj = (IBusModelRelationEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelRelationEditObj)obj.beginEdit();
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
		deepDisposeRelationByIdIdx( Id );
	}

	@Override
	public void deleteRelationByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByTenantIdx( null,
				TenantId );
			Iterator<IBusModelRelationObj> iter = dict.values().iterator();
			IBusModelRelationObj obj;
			List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
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
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByTenantIdx( null,
				TenantId );
		}
		deepDisposeRelationByTenantIdx( TenantId );
	}

	@Override
	public void deleteRelationByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelRelationByUNameIdxKey,
				IBusModelRelationObj >();
		}
		IBusModelRelationByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelRelationObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByUNameIdx( null,
				TableId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByUNameIdx( null,
				TableId,
				Name );
		}
		deepDisposeRelationByUNameIdx( TableId,
				Name );
	}

	@Override
	public void deleteRelationByRelTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelRelationByRelTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByRelTableIdx == null ) {
			indexByRelTableIdx = new HashMap< IBusModelRelationByRelTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( indexByRelTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict = indexByRelTableIdx.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByRelTableIdx( null,
				TableId );
			Iterator<IBusModelRelationObj> iter = dict.values().iterator();
			IBusModelRelationObj obj;
			List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByRelTableIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByRelTableIdx( null,
				TableId );
		}
		deepDisposeRelationByRelTableIdx( TableId );
	}

	@Override
	public void deleteRelationByRelCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelRelationByRelCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		if( indexByRelCodeVisIdx == null ) {
			indexByRelCodeVisIdx = new HashMap< IBusModelRelationByRelCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( indexByRelCodeVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict = indexByRelCodeVisIdx.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByRelCodeVisIdx( null,
				CodeVis );
			Iterator<IBusModelRelationObj> iter = dict.values().iterator();
			IBusModelRelationObj obj;
			List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByRelCodeVisIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByRelCodeVisIdx( null,
				CodeVis );
		}
		deepDisposeRelationByRelCodeVisIdx( CodeVis );
	}

	@Override
	public void deleteRelationByRelTableCodeVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelRelationByRelTableCodeVisXKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByRelTableCodeVisXKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		if( indexByRelTableCodeVisX == null ) {
			indexByRelTableCodeVisX = new HashMap< IBusModelRelationByRelTableCodeVisXKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( indexByRelTableCodeVisX.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict = indexByRelTableCodeVisX.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByRelTableCodeVisX( null,
				TableId,
				CodeVis );
			Iterator<IBusModelRelationObj> iter = dict.values().iterator();
			IBusModelRelationObj obj;
			List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByRelTableCodeVisX.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByRelTableCodeVisX( null,
				TableId,
				CodeVis );
		}
		deepDisposeRelationByRelTableCodeVisX( TableId,
				CodeVis );
	}

	@Override
	public void deleteRelationByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelRelationByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelRelationByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelRelationObj> iter = dict.values().iterator();
			IBusModelRelationObj obj;
			List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
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
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeRelationByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteRelationByFromKeyIdx( IYCFKeyHash256 FromIndexId )
	{
		IBusModelRelationByFromKeyIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByFromKeyIdxKey();
		key.setRequiredFromIndexId( FromIndexId );
		if( indexByFromKeyIdx == null ) {
			indexByFromKeyIdx = new HashMap< IBusModelRelationByFromKeyIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( indexByFromKeyIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict = indexByFromKeyIdx.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByFromKeyIdx( null,
				FromIndexId );
			Iterator<IBusModelRelationObj> iter = dict.values().iterator();
			IBusModelRelationObj obj;
			List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByFromKeyIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByFromKeyIdx( null,
				FromIndexId );
		}
		deepDisposeRelationByFromKeyIdx( FromIndexId );
	}

	@Override
	public void deleteRelationByToTblIdx( IYCFKeyHash256 ToTableId )
	{
		IBusModelRelationByToTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToTblIdxKey();
		key.setRequiredToTableId( ToTableId );
		if( indexByToTblIdx == null ) {
			indexByToTblIdx = new HashMap< IBusModelRelationByToTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( indexByToTblIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict = indexByToTblIdx.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByToTblIdx( null,
				ToTableId );
			Iterator<IBusModelRelationObj> iter = dict.values().iterator();
			IBusModelRelationObj obj;
			List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByToTblIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByToTblIdx( null,
				ToTableId );
		}
		deepDisposeRelationByToTblIdx( ToTableId );
	}

	@Override
	public void deleteRelationByToKeyIdx( IYCFKeyHash256 ToIndexId )
	{
		IBusModelRelationByToKeyIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByToKeyIdxKey();
		key.setRequiredToIndexId( ToIndexId );
		if( indexByToKeyIdx == null ) {
			indexByToKeyIdx = new HashMap< IBusModelRelationByToKeyIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( indexByToKeyIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict = indexByToKeyIdx.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByToKeyIdx( null,
				ToIndexId );
			Iterator<IBusModelRelationObj> iter = dict.values().iterator();
			IBusModelRelationObj obj;
			List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByToKeyIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByToKeyIdx( null,
				ToIndexId );
		}
		deepDisposeRelationByToKeyIdx( ToIndexId );
	}

	@Override
	public void deleteRelationByNarrowedIdx( IYCFKeyHash256 NarrowedId )
	{
		IBusModelRelationByNarrowedIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newByNarrowedIdxKey();
		key.setOptionalNarrowedId( NarrowedId );
		if( indexByNarrowedIdx == null ) {
			indexByNarrowedIdx = new HashMap< IBusModelRelationByNarrowedIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRelationObj > >();
		}
		if( indexByNarrowedIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRelationObj> dict = indexByNarrowedIdx.get( key );
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByNarrowedIdx( null,
				NarrowedId );
			Iterator<IBusModelRelationObj> iter = dict.values().iterator();
			IBusModelRelationObj obj;
			List<IBusModelRelationObj> toForget = new LinkedList<IBusModelRelationObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByNarrowedIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableRelation().deleteRelationByNarrowedIdx( null,
				NarrowedId );
		}
		deepDisposeRelationByNarrowedIdx( NarrowedId );
	}
}