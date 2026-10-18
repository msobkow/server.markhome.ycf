// Description: Java 25 Table Object implementation for ClearTopDep.

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

public class BusModelClearTopDepTableObj
	implements IBusModelClearTopDepTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelClearTopDep.CLASS_CODE;
	protected static final int backingClassCode = IBusModelClearTopDep.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> allClearTopDep;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > > indexByTenantIdx;
	private Map< IBusModelClearDepByClearDepIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > > indexByClearDepIdx;
	private Map< IBusModelClearDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > > indexByDefSchemaIdx;
	private Map< IBusModelClearTopDepByClrTopDepTblIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > > indexByClrTopDepTblIdx;
	private Map< IBusModelClearTopDepByUNameIdxKey,
		IBusModelClearTopDepObj > indexByUNameIdx;
	private Map< IBusModelClearTopDepByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > > indexByPrevIdx;
	private Map< IBusModelClearTopDepByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > > indexByNextIdx;
	public static String TABLE_NAME = "ClearTopDep";
	public static String TABLE_DBNAME = "clr_topdep";

	public BusModelClearTopDepTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj>();
		allClearTopDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClrTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}

	public BusModelClearTopDepTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj>();
		allClearTopDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClrTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelClearTopDepTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelClearTopDepTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allClearTopDep = null;
		indexByTenantIdx = null;
		indexByClearDepIdx = null;
		indexByDefSchemaIdx = null;
		indexByClrTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		List<IBusModelClearTopDepObj> toForget = new LinkedList<IBusModelClearTopDepObj>();
		IBusModelClearTopDepObj cur = null;
		Iterator<IBusModelClearTopDepObj> iter = members.values().iterator();
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
	 *	BusModelClearTopDepObj.
	 */
	@Override
	public IBusModelClearTopDepObj newInstance() {
		IBusModelClearTopDepObj inst = new BusModelClearTopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelClearTopDepObj.
	 */
	@Override
	public IBusModelClearTopDepEditObj newEditInstance( IBusModelClearTopDepObj orig ) {
		IBusModelClearTopDepEditObj edit = new BusModelClearTopDepEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelClearTopDepObj realiseClearTopDep( IBusModelClearTopDepObj Obj ) {
		IBusModelClearTopDepObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelClearTopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelClearTopDepObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByClearDepIdx != null ) {
				IBusModelClearDepByClearDepIdxKey keyClearDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					indexByClearDepIdx.remove( keyClearDepIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByClrTopDepTblIdx != null ) {
				IBusModelClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
				keyClrTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapClrTopDepTblIdx = indexByClrTopDepTblIdx.get( keyClrTopDepTblIdx );
				if( mapClrTopDepTblIdx != null ) {
					mapClrTopDepTblIdx.remove( keepObj.getPKey() );
					if( mapClrTopDepTblIdx.size() <= 0 ) {
						indexByClrTopDepTblIdx.remove( keyClrTopDepTblIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelClearTopDepByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevIdx != null ) {
				IBusModelClearTopDepByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelClearTopDepByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelClearTopDepObj)schema.getClearDepTableObj().realiseClearDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				IBusModelClearDepByClearDepIdxKey keyClearDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClrTopDepTblIdx != null ) {
				IBusModelClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
				keyClrTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapClrTopDepTblIdx = indexByClrTopDepTblIdx.get( keyClrTopDepTblIdx );
				if( mapClrTopDepTblIdx != null ) {
					mapClrTopDepTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelClearTopDepByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				IBusModelClearTopDepByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelClearTopDepByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allClearTopDep != null ) {
				allClearTopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelClearTopDepObj)schema.getClearDepTableObj().realiseClearDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allClearTopDep != null ) {
				allClearTopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClearDepIdx != null ) {
				IBusModelClearDepByClearDepIdxKey keyClearDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
				keyClearDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapClearDepIdx = indexByClearDepIdx.get( keyClearDepIdx );
				if( mapClearDepIdx != null ) {
					mapClearDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelClearDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClrTopDepTblIdx != null ) {
				IBusModelClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
				keyClrTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapClrTopDepTblIdx = indexByClrTopDepTblIdx.get( keyClrTopDepTblIdx );
				if( mapClrTopDepTblIdx != null ) {
					mapClrTopDepTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelClearTopDepByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				IBusModelClearTopDepByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelClearTopDepByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelClearTopDepObj createClearTopDep( IBusModelClearTopDepObj Obj ) {
		IBusModelClearTopDepObj obj = Obj;
		IBusModelClearTopDep rec = obj.getClearTopDepRec();
		schema.getBusModelBackingStore().getTableClearTopDep().createClearTopDep(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelClearTopDepObj)(obj.realise());
		}
		IBusModelClearTopDepObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelClearTopDepObj readClearTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		return( readClearTopDep( pkey, false ) );
	}

	@Override
	public IBusModelClearTopDepObj readClearTopDep( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelClearTopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelClearTopDep readRec = schema.getBusModelBackingStore().getTableClearTopDep().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelClearTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelClearTopDepObj readCachedClearTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelClearTopDepObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeClearTopDep( IBusModelClearTopDepObj obj )
	{
		final String S_ProcName = "BusModelClearTopDepTableObj.reallyDeepDisposeClearTopDep() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelClearTopDepObj existing = readCachedClearTopDep( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelClearTopDepByClrTopDepTblIdxKey keyClrTopDepTblIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
		keyClrTopDepTblIdx.setRequiredTableId( existing.getRequiredTableId() );

		IBusModelClearTopDepByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelClearTopDepByPrevIdxKey keyPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelClearTopDepByNextIdxKey keyNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );


		schema.getClearSubDep1TableObj().deepDisposeClearSubDep1ByClearTopDepIdx( existing.getRequiredId() );

		if( indexByClrTopDepTblIdx != null ) {
			if( indexByClrTopDepTblIdx.containsKey( keyClrTopDepTblIdx ) ) {
				indexByClrTopDepTblIdx.get( keyClrTopDepTblIdx ).remove( pkey );
				if( indexByClrTopDepTblIdx.get( keyClrTopDepTblIdx ).size() <= 0 ) {
					indexByClrTopDepTblIdx.remove( keyClrTopDepTblIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByPrevIdx != null ) {
			if( indexByPrevIdx.containsKey( keyPrevIdx ) ) {
				indexByPrevIdx.get( keyPrevIdx ).remove( pkey );
				if( indexByPrevIdx.get( keyPrevIdx ).size() <= 0 ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}
		}

		if( indexByNextIdx != null ) {
			if( indexByNextIdx.containsKey( keyNextIdx ) ) {
				indexByNextIdx.get( keyNextIdx ).remove( pkey );
				if( indexByNextIdx.get( keyNextIdx ).size() <= 0 ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}
		}


		schema.getClearDepTableObj().reallyDeepDisposeClearDep( obj );
	}
	@Override
	public void deepDisposeClearTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelClearTopDepObj obj = readCachedClearTopDep( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelClearTopDepObj lockClearTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelClearTopDepObj locked = null;
		IBusModelClearTopDep lockRec = schema.getBusModelBackingStore().getTableClearTopDep().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelClearTopDepObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockClearTopDep", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelClearTopDepObj> readAllClearTopDep() {
		return( readAllClearTopDep( false ) );
	}

	@Override
	public List<IBusModelClearTopDepObj> readAllClearTopDep( boolean forceRead ) {
		final String S_ProcName = "readAllClearTopDep";
		if( ( allClearTopDep == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelClearTopDepObj>();
			allClearTopDep = map;
			IBusModelClearTopDep[] recList = schema.getBusModelBackingStore().getTableClearTopDep().readAllDerived( null );
			IBusModelClearTopDep rec;
			IBusModelClearTopDepObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearTopDepObj realised = (IBusModelClearTopDepObj)obj.realise();
			}
		}
		int len = allClearTopDep.size();
		IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
		Iterator<IBusModelClearTopDepObj> valIter = allClearTopDep.values().iterator();
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
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
		List<IBusModelClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearTopDepObj> readCachedAllClearTopDep() {
		final String S_ProcName = "readCachedAllClearTopDep";
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>();
		if( allClearTopDep != null ) {
			int len = allClearTopDep.size();
			IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
			Iterator<IBusModelClearTopDepObj> valIter = allClearTopDep.values().iterator();
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
		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
	public IBusModelClearTopDepObj readClearTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		return( readClearTopDepByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelClearTopDepObj readClearTopDepByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelClearTopDepObj obj = readClearTopDep( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readClearTopDepByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearTopDepObj realised = (IBusModelClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
		Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
		List<IBusModelClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		return( readClearTopDepByClearDepIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByClearDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByClearDepIdx";
		IBusModelClearDepByClearDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< IBusModelClearDepByClearDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByClearDepIdx.containsKey( key ) ) {
			dict = indexByClearDepIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj>();
			IBusModelClearDepObj obj;
			IBusModelClearDep[] recList = schema.getBusModelBackingStore().getTableClearDep().readDerivedByClearDepIdx( null,
				RelationId );
			IBusModelClearDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearTopDepObj realised = (IBusModelClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClearDepIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
		Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
		List<IBusModelClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readClearTopDepByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByDefSchemaIdx";
		IBusModelClearDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelClearDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj>();
			IBusModelClearDepObj obj;
			IBusModelClearDep[] recList = schema.getBusModelBackingStore().getTableClearDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelClearDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearTopDepObj realised = (IBusModelClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
		Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
		List<IBusModelClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByClrTopDepTblIdx( IYCFKeyHash256 TableId )
	{
		return( readClearTopDepByClrTopDepTblIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByClrTopDepTblIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByClrTopDepTblIdx";
		IBusModelClearTopDepByClrTopDepTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
		if( indexByClrTopDepTblIdx == null ) {
			indexByClrTopDepTblIdx = new HashMap< IBusModelClearTopDepByClrTopDepTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByClrTopDepTblIdx.containsKey( key ) ) {
			dict = indexByClrTopDepTblIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj>();
			IBusModelClearTopDepObj obj;
			IBusModelClearTopDep[] recList = schema.getBusModelBackingStore().getTableClearTopDep().readDerivedByClrTopDepTblIdx( null,
				TableId );
			IBusModelClearTopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearTopDepObj realised = (IBusModelClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClrTopDepTblIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
		Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
		List<IBusModelClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelClearTopDepObj readClearTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		return( readClearTopDepByUNameIdx( TableId,
			Name,
			false ) );
	}

	@Override
	public IBusModelClearTopDepObj readClearTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelClearTopDepByUNameIdxKey,
				IBusModelClearTopDepObj >();
		}
		IBusModelClearTopDepByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelClearTopDepObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelClearTopDep rec = schema.getBusModelBackingStore().getTableClearTopDep().readDerivedByUNameIdx( null,
				TableId,
				Name );
			if( rec != null ) {
				obj = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelClearTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readClearTopDepByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByPrevIdx";
		IBusModelClearTopDepByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelClearTopDepByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj>();
			IBusModelClearTopDepObj obj;
			IBusModelClearTopDep[] recList = schema.getBusModelBackingStore().getTableClearTopDep().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelClearTopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearTopDepObj realised = (IBusModelClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
		Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
		List<IBusModelClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readClearTopDepByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelClearTopDepObj> readClearTopDepByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readClearTopDepByNextIdx";
		IBusModelClearTopDepByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelClearTopDepByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj>();
			IBusModelClearTopDepObj obj;
			IBusModelClearTopDep[] recList = schema.getBusModelBackingStore().getTableClearTopDep().readDerivedByNextIdx( null,
				NextId );
			IBusModelClearTopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelClearTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelClearTopDepObj realised = (IBusModelClearTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
		Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
		List<IBusModelClearTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelClearTopDepObj readCachedClearTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelClearTopDepObj obj = null;
		obj = readCachedClearTopDep( Id );
		return( obj );
	}

	@Override
	public List<IBusModelClearTopDepObj> readCachedClearTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedClearTopDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
				Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
			IBusModelClearTopDepObj obj;
			Iterator<IBusModelClearTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
	public List<IBusModelClearTopDepObj> readCachedClearTopDepByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedClearTopDepByClearDepIdx";
		IBusModelClearDepByClearDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>();
		if( indexByClearDepIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
			if( indexByClearDepIdx.containsKey( key ) ) {
				dict = indexByClearDepIdx.get( key );
				int len = dict.size();
				IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
				Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
			IBusModelClearTopDepObj obj;
			Iterator<IBusModelClearTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
	public List<IBusModelClearTopDepObj> readCachedClearTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedClearTopDepByDefSchemaIdx";
		IBusModelClearDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
				Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
			IBusModelClearTopDepObj obj;
			Iterator<IBusModelClearTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
	public List<IBusModelClearTopDepObj> readCachedClearTopDepByClrTopDepTblIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedClearTopDepByClrTopDepTblIdx";
		IBusModelClearTopDepByClrTopDepTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>();
		if( indexByClrTopDepTblIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
			if( indexByClrTopDepTblIdx.containsKey( key ) ) {
				dict = indexByClrTopDepTblIdx.get( key );
				int len = dict.size();
				IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
				Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
			IBusModelClearTopDepObj obj;
			Iterator<IBusModelClearTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
	public IBusModelClearTopDepObj readCachedClearTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelClearTopDepObj obj = null;
		IBusModelClearTopDepByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelClearTopDepObj> valIter = members.values().iterator();
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
			Iterator<IBusModelClearTopDepObj> valIter = members.values().iterator();
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
	public List<IBusModelClearTopDepObj> readCachedClearTopDepByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedClearTopDepByPrevIdx";
		IBusModelClearTopDepByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
				Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
			IBusModelClearTopDepObj obj;
			Iterator<IBusModelClearTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
	public List<IBusModelClearTopDepObj> readCachedClearTopDepByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedClearTopDepByNextIdx";
		IBusModelClearTopDepByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelClearTopDepObj> arrayList = new ArrayList<IBusModelClearTopDepObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelClearTopDepObj arr[] = new IBusModelClearTopDepObj[len];
				Iterator<IBusModelClearTopDepObj> valIter = dict.values().iterator();
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
			IBusModelClearTopDepObj obj;
			Iterator<IBusModelClearTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelClearTopDepObj> cmp = new Comparator<IBusModelClearTopDepObj>() {
			@Override
			public int compare( IBusModelClearTopDepObj lhs, IBusModelClearTopDepObj rhs ) {
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
	public void deepDisposeClearTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelClearTopDepObj obj = readCachedClearTopDepByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeClearTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeClearTopDepByTenantIdx";
		IBusModelClearTopDepObj obj;
		List<IBusModelClearTopDepObj> arrayList = readCachedClearTopDepByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelClearTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearTopDepByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposeClearTopDepByClearDepIdx";
		IBusModelClearTopDepObj obj;
		List<IBusModelClearTopDepObj> arrayList = readCachedClearTopDepByClearDepIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelClearTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeClearTopDepByDefSchemaIdx";
		IBusModelClearTopDepObj obj;
		List<IBusModelClearTopDepObj> arrayList = readCachedClearTopDepByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelClearTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearTopDepByClrTopDepTblIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeClearTopDepByClrTopDepTblIdx";
		IBusModelClearTopDepObj obj;
		List<IBusModelClearTopDepObj> arrayList = readCachedClearTopDepByClrTopDepTblIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelClearTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelClearTopDepObj obj = readCachedClearTopDepByUNameIdx( TableId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeClearTopDepByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeClearTopDepByPrevIdx";
		IBusModelClearTopDepObj obj;
		List<IBusModelClearTopDepObj> arrayList = readCachedClearTopDepByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelClearTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeClearTopDepByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeClearTopDepByNextIdx";
		IBusModelClearTopDepObj obj;
		List<IBusModelClearTopDepObj> arrayList = readCachedClearTopDepByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelClearTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelClearTopDepObj updateClearTopDep( IBusModelClearTopDepObj Obj ) {
		IBusModelClearTopDepObj obj = Obj;
		schema.getBusModelBackingStore().getTableClearTopDep().updateClearTopDep( null,
			Obj.getClearTopDepRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().getClassCode() ) {
			obj = (IBusModelClearTopDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteClearTopDep( IBusModelClearTopDepObj Obj ) {
		IBusModelClearTopDepObj obj = Obj;
		IBusModelClearTopDepObj prev = obj.getOptionalLookupPrev();
		IBusModelClearTopDepObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDep( null,
			obj.getClearTopDepRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteClearTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelClearTopDepObj obj = readClearTopDep(Id);
		if( obj != null ) {
			IBusModelClearTopDepEditObj editObj = (IBusModelClearTopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelClearTopDepEditObj)obj.beginEdit();
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
		deepDisposeClearTopDepByIdIdx( Id );
	}

	@Override
	public void deleteClearTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByTenantIdx( null,
				TenantId );
			Iterator<IBusModelClearTopDepObj> iter = dict.values().iterator();
			IBusModelClearTopDepObj obj;
			List<IBusModelClearTopDepObj> toForget = new LinkedList<IBusModelClearTopDepObj>();
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
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByTenantIdx( null,
				TenantId );
		}
		deepDisposeClearTopDepByTenantIdx( TenantId );
	}

	@Override
	public void deleteClearTopDepByClearDepIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelClearDepByClearDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByClearDepIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByClearDepIdx == null ) {
			indexByClearDepIdx = new HashMap< IBusModelClearDepByClearDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( indexByClearDepIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict = indexByClearDepIdx.get( key );
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByClearDepIdx( null,
				RelationId );
			Iterator<IBusModelClearTopDepObj> iter = dict.values().iterator();
			IBusModelClearTopDepObj obj;
			List<IBusModelClearTopDepObj> toForget = new LinkedList<IBusModelClearTopDepObj>();
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
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByClearDepIdx( null,
				RelationId );
		}
		deepDisposeClearTopDepByClearDepIdx( RelationId );
	}

	@Override
	public void deleteClearTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelClearDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelClearDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelClearTopDepObj> iter = dict.values().iterator();
			IBusModelClearTopDepObj obj;
			List<IBusModelClearTopDepObj> toForget = new LinkedList<IBusModelClearTopDepObj>();
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
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeClearTopDepByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteClearTopDepByClrTopDepTblIdx( IYCFKeyHash256 TableId )
	{
		IBusModelClearTopDepByClrTopDepTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByClrTopDepTblIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByClrTopDepTblIdx == null ) {
			indexByClrTopDepTblIdx = new HashMap< IBusModelClearTopDepByClrTopDepTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( indexByClrTopDepTblIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict = indexByClrTopDepTblIdx.get( key );
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByClrTopDepTblIdx( null,
				TableId );
			Iterator<IBusModelClearTopDepObj> iter = dict.values().iterator();
			IBusModelClearTopDepObj obj;
			List<IBusModelClearTopDepObj> toForget = new LinkedList<IBusModelClearTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByClrTopDepTblIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByClrTopDepTblIdx( null,
				TableId );
		}
		deepDisposeClearTopDepByClrTopDepTblIdx( TableId );
	}

	@Override
	public void deleteClearTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelClearTopDepByUNameIdxKey,
				IBusModelClearTopDepObj >();
		}
		IBusModelClearTopDepByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelClearTopDepObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByUNameIdx( null,
				TableId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByUNameIdx( null,
				TableId,
				Name );
		}
		deepDisposeClearTopDepByUNameIdx( TableId,
				Name );
	}

	@Override
	public void deleteClearTopDepByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelClearTopDepByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelClearTopDepByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByPrevIdx( null,
				PrevId );
			Iterator<IBusModelClearTopDepObj> iter = dict.values().iterator();
			IBusModelClearTopDepObj obj;
			List<IBusModelClearTopDepObj> toForget = new LinkedList<IBusModelClearTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByPrevIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByPrevIdx( null,
				PrevId );
		}
		deepDisposeClearTopDepByPrevIdx( PrevId );
	}

	@Override
	public void deleteClearTopDepByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelClearTopDepByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelClearTopDepByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelClearTopDepObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelClearTopDepObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByNextIdx( null,
				NextId );
			Iterator<IBusModelClearTopDepObj> iter = dict.values().iterator();
			IBusModelClearTopDepObj obj;
			List<IBusModelClearTopDepObj> toForget = new LinkedList<IBusModelClearTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByNextIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableClearTopDep().deleteClearTopDepByNextIdx( null,
				NextId );
		}
		deepDisposeClearTopDepByNextIdx( NextId );
	}

	/**
	 *	Move the BusModelClearTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelClearTopDepObj refreshed cache instance.
	 */
	@Override
	public IBusModelClearTopDepObj moveUpClearTopDep( IBusModelClearTopDepObj Obj ) {
		IBusModelClearTopDepObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpClearTopDep" );
		}
		IBusModelClearTopDep rec = schema.getBusModelBackingStore().getTableClearTopDep().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getClearTopDepTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelClearTopDepObj)obj.realise();
			IBusModelClearTopDepObj prev = obj.getOptionalLookupPrev( true );
			IBusModelClearTopDepObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelClearTopDepObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelClearTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelClearTopDepObj refreshed cache instance.
	 */
	@Override
	public IBusModelClearTopDepObj moveDownClearTopDep( IBusModelClearTopDepObj Obj ) {
		IBusModelClearTopDepObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownClearTopDep" );
		}
		IBusModelClearTopDep rec = schema.getBusModelBackingStore().getTableClearTopDep().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getClearTopDepTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelClearTopDepObj)obj.realise();
			IBusModelClearTopDepObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelClearTopDepObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelClearTopDepObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}